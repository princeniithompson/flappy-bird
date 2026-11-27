
// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoDataFactory.java =====
package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.configuration.InitRequestType;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.device.reader.builder.DeviceInfoReaderBuilder;
import com.unity3d.services.core.device.reader.builder.DeviceInfoReaderPrivacyBuilder;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;

/* loaded from: classes.dex */
public class DeviceInfoDataFactory {
    private final SDKMetricsSender _sdkMetricsSender;

    public DeviceInfoDataFactory(SDKMetricsSender sDKMetricsSender) {
        this._sdkMetricsSender = sDKMetricsSender;
    }

    /* renamed from: com.unity3d.services.core.device.reader.DeviceInfoDataFactory$1 */
    static /* synthetic */ class C11431 {

        /* renamed from: $SwitchMap$com$unity3d$services$core$configuration$InitRequestType */
        static final /* synthetic */ int[] f696x5633d9cb;

        static {
            int[] iArr = new int[InitRequestType.values().length];
            f696x5633d9cb = iArr;
            try {
                iArr[InitRequestType.TOKEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f696x5633d9cb[InitRequestType.PRIVACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public IDeviceInfoDataContainer getDeviceInfoData(InitRequestType initRequestType) {
        int i = C11431.f696x5633d9cb[initRequestType.ordinal()];
        if (i == 1) {
            return getTokenDeviceInfoData();
        }
        if (i != 2) {
            return null;
        }
        return getPrivacyDeviceInfoData();
    }

    private IDeviceInfoDataContainer getPrivacyDeviceInfoData() {
        return new DeviceInfoReaderCompressor(new DeviceInfoReaderPrivacyBuilder(new ConfigurationReader(), PrivacyConfigStorage.getInstance(), GameSessionIdReader.getInstance()).build());
    }

    private IDeviceInfoDataContainer getTokenDeviceInfoData() {
        return new DeviceInfoReaderCompressorWithMetrics(new DeviceInfoReaderCompressor(new DeviceInfoReaderBuilder(new ConfigurationReader(), PrivacyConfigStorage.getInstance(), GameSessionIdReader.getInstance()).build()), this._sdkMetricsSender);
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoReaderCompressor.java =====
package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.log.DeviceLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DeviceInfoReaderCompressor implements IDeviceInfoDataCompressor {
    public final IDeviceInfoReader _deviceInfoReader;

    public DeviceInfoReaderCompressor(IDeviceInfoReader iDeviceInfoReader) {
        this._deviceInfoReader = iDeviceInfoReader;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoDataContainer
    public byte[] getDeviceData() {
        return compressDeviceInfo(getDeviceInfo());
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoDataContainer
    public Map<String, Object> getDeviceInfo() {
        return this._deviceInfoReader.getDeviceInfoData();
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoDataCompressor
    public byte[] compressDeviceInfo(Map<String, Object> map) {
        if (map != null) {
            String jSONObject = new JSONObject(map).toString();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(jSONObject.length());
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(jSONObject.getBytes());
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                DeviceLog.error("Error occurred while trying to compress device data.");
                return null;
            }
        }
        DeviceLog.error("Invalid DeviceInfoData: Expected non null map provided by reader");
        return null;
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoReaderCompressorWithMetrics.java =====
package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class DeviceInfoReaderCompressorWithMetrics implements IDeviceInfoDataCompressor {
    private final IDeviceInfoDataCompressor _deviceInfoDataCompressor;
    private long _endTime;
    private final SDKMetricsSender _sdkMetricsSender;
    private long _startTimeCompression;
    private long _startTimeInfo;

    public DeviceInfoReaderCompressorWithMetrics(IDeviceInfoDataCompressor iDeviceInfoDataCompressor, SDKMetricsSender sDKMetricsSender) {
        this._deviceInfoDataCompressor = iDeviceInfoDataCompressor;
        this._sdkMetricsSender = sDKMetricsSender;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoDataContainer
    public byte[] getDeviceData() {
        if (this._deviceInfoDataCompressor == null) {
            return new byte[0];
        }
        this._startTimeInfo = System.nanoTime();
        byte[] compressDeviceInfo = compressDeviceInfo(getDeviceInfo());
        sendDeviceInfoMetrics();
        return compressDeviceInfo;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoDataContainer
    public Map<String, Object> getDeviceInfo() {
        return this._deviceInfoDataCompressor.getDeviceInfo();
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoDataCompressor
    public byte[] compressDeviceInfo(Map<String, Object> map) {
        this._startTimeCompression = System.nanoTime();
        byte[] compressDeviceInfo = this._deviceInfoDataCompressor.compressDeviceInfo(map);
        this._endTime = System.nanoTime();
        return compressDeviceInfo;
    }

    private long getDeviceInfoCollectionDuration() {
        return TimeUnit.NANOSECONDS.toMillis(this._startTimeCompression - this._startTimeInfo);
    }

    private long getCompressionDuration() {
        return TimeUnit.NANOSECONDS.toMillis(this._endTime - this._startTimeCompression);
    }

    private void sendDeviceInfoMetrics() {
        this._sdkMetricsSender.sendMetric(TSIMetric.newDeviceInfoCollectionLatency(Long.valueOf(getDeviceInfoCollectionDuration())));
        this._sdkMetricsSender.sendMetric(TSIMetric.newDeviceInfoCompressionLatency(Long.valueOf(getCompressionDuration())));
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoReaderExtended.java =====
package com.unity3d.services.core.device.reader;

import android.webkit.WebSettings;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import com.unity3d.services.core.configuration.InitRequestType;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class DeviceInfoReaderExtended implements IDeviceInfoReader {
    private final IDeviceInfoReader _deviceInfoReader;

    public DeviceInfoReaderExtended(IDeviceInfoReader iDeviceInfoReader) {
        this._deviceInfoReader = iDeviceInfoReader;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        deviceInfoData.put("bundleId", ClientProperties.getAppName());
        deviceInfoData.put("encrypted", Boolean.valueOf(ClientProperties.isAppDebuggable()));
        deviceInfoData.put("rooted", Boolean.valueOf(Device.isRooted()));
        deviceInfoData.put("osVersion", Device.getOsVersion());
        deviceInfoData.put("deviceModel", Device.getModel());
        deviceInfoData.put("language", Locale.getDefault().toString());
        deviceInfoData.put("connectionType", Device.getConnectionType());
        deviceInfoData.put("screenHeight", Integer.valueOf(Device.getScreenHeight()));
        deviceInfoData.put("screenWidth", Integer.valueOf(Device.getScreenWidth()));
        deviceInfoData.put("deviceMake", Device.getManufacturer());
        deviceInfoData.put("screenDensity", Integer.valueOf(Device.getScreenDensity()));
        deviceInfoData.put("screenSize", Integer.valueOf(Device.getScreenLayout()));
        deviceInfoData.put("limitAdTracking", Boolean.valueOf(Device.isLimitAdTrackingEnabled()));
        deviceInfoData.put("networkOperator", Device.getNetworkOperator());
        deviceInfoData.put("volume", Integer.valueOf(Device.getStreamVolume(1)));
        deviceInfoData.put("deviceFreeSpace", Long.valueOf(Device.getFreeSpace(ClientProperties.getApplicationContext().getCacheDir())));
        deviceInfoData.put("apiLevel", String.valueOf(Device.getApiLevel()));
        deviceInfoData.put("networkType", Integer.valueOf(Device.getNetworkType()));
        deviceInfoData.put("bundleVersion", ClientProperties.getAppVersion());
        try {
            deviceInfoData.put("timeZone", TimeZone.getDefault().getDisplayName(false, 0, Locale.US));
        } catch (AssertionError e) {
            DeviceLog.error("Could not read timeZone information: %s", e.getMessage());
        }
        deviceInfoData.put("timeZoneOffset", Integer.valueOf(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
        try {
            deviceInfoData.put("webviewUa", WebSettings.getDefaultUserAgent(ClientProperties.getApplicationContext()));
        } catch (Exception e2) {
            DeviceLog.exception("Error getting webview user agent", e2);
        }
        deviceInfoData.put("networkOperatorName", Device.getNetworkOperatorName());
        deviceInfoData.put("wiredHeadset", Boolean.valueOf(Device.isWiredHeadsetOn()));
        deviceInfoData.put("versionCode", Integer.valueOf(SdkProperties.getVersionCode()));
        deviceInfoData.put("stores", AndroidStaticDeviceInfoDataSource.STORE_GOOGLE);
        deviceInfoData.put("appStartTime", Long.valueOf(SdkProperties.getInitializationTimeEpoch() / 1000));
        deviceInfoData.put("sdkVersionName", SdkProperties.getVersionName());
        deviceInfoData.put("eventTimeStamp", Long.valueOf(System.currentTimeMillis() / 1000));
        deviceInfoData.put("cpuCount", Long.valueOf(Device.getCPUCount()));
        deviceInfoData.put("usbConnected", Boolean.valueOf(Device.isUSBConnected()));
        deviceInfoData.put("apkDeveloperSigningCertificateHash", Device.getCertificateFingerprint());
        deviceInfoData.put("deviceUpTime", Long.valueOf(Device.getUptime()));
        deviceInfoData.put("deviceElapsedRealtime", Long.valueOf(Device.getElapsedRealtime()));
        deviceInfoData.put("adbEnabled", Device.isAdbEnabled());
        deviceInfoData.put("androidFingerprint", Device.getFingerprint());
        deviceInfoData.put("batteryStatus", Integer.valueOf(Device.getBatteryStatus()));
        deviceInfoData.put("batteryLevel", Float.valueOf(Device.getBatteryLevel()));
        deviceInfoData.put("networkMetered", Boolean.valueOf(Device.getNetworkMetered()));
        deviceInfoData.put("test", Boolean.valueOf(SdkProperties.isTestMode()));
        deviceInfoData.put("callType", InitRequestType.TOKEN.getCallType());
        return deviceInfoData;
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoReaderFilterProvider.java =====
package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.misc.IJsonStorageReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DeviceInfoReaderFilterProvider {
    private static final String FILTER_EXCLUDE_KEY = "exclude";
    private static final String UNIFIED_CONFIG_KEY = "unifiedconfig";
    private IJsonStorageReader _storage;

    public DeviceInfoReaderFilterProvider(IJsonStorageReader iJsonStorageReader) {
        this._storage = iJsonStorageReader;
    }

    public List<String> getFilterList() {
        Object opt;
        ArrayList arrayList = new ArrayList();
        IJsonStorageReader iJsonStorageReader = this._storage;
        if (iJsonStorageReader == null || iJsonStorageReader.getData() == null || (opt = this._storage.getData().opt("unifiedconfig")) == null || !(opt instanceof JSONObject)) {
            return arrayList;
        }
        Object opt2 = ((JSONObject) opt).opt(FILTER_EXCLUDE_KEY);
        return opt2 instanceof String ? trimWhiteSpaces(Arrays.asList(((String) opt2).split(","))) : arrayList;
    }

    private List<String> trimWhiteSpaces(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().trim());
        }
        return arrayList;
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoReaderWithAuid.java =====
package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.device.Device;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceInfoReaderWithAuid.kt */
@Metadata(m443d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m444d2 = {"Lcom/unity3d/services/core/device/reader/DeviceInfoReaderWithAuid;", "Lcom/unity3d/services/core/device/reader/IDeviceInfoReader;", "_deviceInfoReader", "(Lcom/unity3d/services/core/device/reader/IDeviceInfoReader;)V", "getDeviceInfoData", "", "", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class DeviceInfoReaderWithAuid implements IDeviceInfoReader {
    private final IDeviceInfoReader _deviceInfoReader;

    public DeviceInfoReaderWithAuid(IDeviceInfoReader _deviceInfoReader) {
        Intrinsics.checkNotNullParameter(_deviceInfoReader, "_deviceInfoReader");
        this._deviceInfoReader = _deviceInfoReader;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        Intrinsics.checkNotNullExpressionValue(deviceInfoData, "_deviceInfoReader.deviceInfoData");
        String auid = Device.getAuid();
        if (auid != null) {
            deviceInfoData.put("auid", auid);
        }
        return deviceInfoData;
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoReaderWithBehavioralFlag.java =====
package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.device.reader.pii.NonBehavioralFlag;
import com.unity3d.services.core.device.reader.pii.NonBehavioralFlagReader;
import java.util.Map;

/* loaded from: classes.dex */
public class DeviceInfoReaderWithBehavioralFlag implements IDeviceInfoReader {
    private final IDeviceInfoReader _deviceInfoReader;
    private final NonBehavioralFlagReader _nonBehavioralFlagReader;

    public DeviceInfoReaderWithBehavioralFlag(IDeviceInfoReader iDeviceInfoReader, NonBehavioralFlagReader nonBehavioralFlagReader) {
        this._deviceInfoReader = iDeviceInfoReader;
        this._nonBehavioralFlagReader = nonBehavioralFlagReader;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        if (this._nonBehavioralFlagReader.getUserNonBehavioralFlag() != NonBehavioralFlag.UNKNOWN) {
            deviceInfoData.put(JsonStorageKeyNames.USER_NON_BEHAVIORAL_KEY, Boolean.valueOf(this._nonBehavioralFlagReader.getUserNonBehavioralFlag() == NonBehavioralFlag.TRUE));
        }
        return deviceInfoData;
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoReaderWithExtras.java =====
package com.unity3d.services.core.device.reader;

import java.util.Map;

/* loaded from: classes.dex */
public class DeviceInfoReaderWithExtras implements IDeviceInfoReader {
    private final IDeviceInfoReader _deviceInfoReader;
    private final Map<String, String> _extras;

    public DeviceInfoReaderWithExtras(IDeviceInfoReader iDeviceInfoReader, Map<String, String> map) {
        this._deviceInfoReader = iDeviceInfoReader;
        this._extras = map;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        Map<String, String> map;
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        if (deviceInfoData != null && (map = this._extras) != null) {
            deviceInfoData.putAll(map);
        }
        return deviceInfoData;
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoReaderWithFilter.java =====
package com.unity3d.services.core.device.reader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class DeviceInfoReaderWithFilter implements IDeviceInfoReader {
    IDeviceInfoReader _deviceInfoReader;
    List<String> _keysToExclude;

    public DeviceInfoReaderWithFilter(IDeviceInfoReader iDeviceInfoReader, List<String> list) {
        this._deviceInfoReader = iDeviceInfoReader;
        this._keysToExclude = list;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        List<String> list = this._keysToExclude;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                deviceInfoData.remove(it.next());
            }
        }
        return deviceInfoData;
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoReaderWithLifecycle.java =====
package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.lifecycle.LifecycleCache;
import java.util.Map;

/* loaded from: classes.dex */
public class DeviceInfoReaderWithLifecycle implements IDeviceInfoReader {
    private final IDeviceInfoReader _deviceInfoReader;
    private final LifecycleCache _lifecycleCache;

    public DeviceInfoReaderWithLifecycle(IDeviceInfoReader iDeviceInfoReader, LifecycleCache lifecycleCache) {
        this._deviceInfoReader = iDeviceInfoReader;
        this._lifecycleCache = lifecycleCache;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        deviceInfoData.put("appActive", Boolean.valueOf(this._lifecycleCache.isAppActive()));
        return deviceInfoData;
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoReaderWithMetrics.java =====
package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import java.util.Map;

/* loaded from: classes.dex */
public class DeviceInfoReaderWithMetrics implements IDeviceInfoReader {
    private final IDeviceInfoReader _deviceInfoReader;
    private final SDKMetricsSender _sdkMetricsSender;

    public DeviceInfoReaderWithMetrics(IDeviceInfoReader iDeviceInfoReader, SDKMetricsSender sDKMetricsSender) {
        this._deviceInfoReader = iDeviceInfoReader;
        this._sdkMetricsSender = sDKMetricsSender;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        IDeviceInfoReader iDeviceInfoReader = this._deviceInfoReader;
        if (iDeviceInfoReader == null) {
            return null;
        }
        Map<String, Object> deviceInfoData = iDeviceInfoReader.getDeviceInfoData();
        sendMetrics(deviceInfoData);
        return deviceInfoData;
    }

    private void sendMetrics(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get(JsonStorageKeyNames.GAME_SESSION_ID_NORMALIZED_KEY);
            if ((obj instanceof Long) && ((Long) obj).longValue() == 0) {
                this._sdkMetricsSender.sendMetric(TSIMetric.newMissingGameSessionId());
            }
        }
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoReaderWithPrivacy.java =====
package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.device.reader.pii.PiiDataProvider;
import com.unity3d.services.core.device.reader.pii.PiiTrackingStatusReader;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DeviceInfoReaderWithPrivacy implements IDeviceInfoReader {
    private final IDeviceInfoReader _deviceInfoReader;
    private final PiiDataProvider _piiDataProvider;
    private final PiiTrackingStatusReader _piiTrackingStatusReader;
    private final PrivacyConfigStorage _privacyConfigStorage;

    public DeviceInfoReaderWithPrivacy(IDeviceInfoReader iDeviceInfoReader, PrivacyConfigStorage privacyConfigStorage, PiiDataProvider piiDataProvider, PiiTrackingStatusReader piiTrackingStatusReader) {
        this._deviceInfoReader = iDeviceInfoReader;
        this._privacyConfigStorage = privacyConfigStorage;
        this._piiDataProvider = piiDataProvider;
        this._piiTrackingStatusReader = piiTrackingStatusReader;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        PrivacyConfigStorage privacyConfigStorage = this._privacyConfigStorage;
        if (privacyConfigStorage != null && privacyConfigStorage.getPrivacyConfig() != null) {
            if (this._privacyConfigStorage.getPrivacyConfig().allowedToSendPii()) {
                deviceInfoData.putAll(getPiiAttributesFromDevice());
            }
            if (this._privacyConfigStorage.getPrivacyConfig().shouldSendNonBehavioral()) {
                deviceInfoData.put(JsonStorageKeyNames.USER_NON_BEHAVIORAL_KEY, Boolean.valueOf(this._piiTrackingStatusReader.getUserNonBehavioralFlag()));
            }
        }
        return deviceInfoData;
    }

    private Map<String, Object> getPiiAttributesFromDevice() {
        HashMap hashMap = new HashMap();
        String advertisingTrackingId = this._piiDataProvider.getAdvertisingTrackingId();
        if (advertisingTrackingId != null) {
            hashMap.put(JsonStorageKeyNames.ADVERTISING_TRACKING_ID_NORMALIZED_KEY, advertisingTrackingId);
        }
        return hashMap;
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoReaderWithRequestType.java =====
package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.configuration.InitRequestType;
import java.util.Map;

/* loaded from: classes.dex */
public class DeviceInfoReaderWithRequestType implements IDeviceInfoReader {
    private final IDeviceInfoReader _deviceInfoReader;
    private final InitRequestType _initRequestType;

    public DeviceInfoReaderWithRequestType(IDeviceInfoReader iDeviceInfoReader, InitRequestType initRequestType) {
        this._deviceInfoReader = iDeviceInfoReader;
        this._initRequestType = initRequestType;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        InitRequestType initRequestType = this._initRequestType;
        if (initRequestType != null) {
            deviceInfoData.put("callType", initRequestType.toString().toLowerCase());
        }
        return deviceInfoData;
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoReaderWithSessionId.java =====
package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.properties.Session;
import java.util.Map;

/* loaded from: classes.dex */
public class DeviceInfoReaderWithSessionId implements IDeviceInfoReader {
    private final IDeviceInfoReader _deviceInfoReader;
    private final Session _session;

    public DeviceInfoReaderWithSessionId(IDeviceInfoReader iDeviceInfoReader, Session session) {
        this._deviceInfoReader = iDeviceInfoReader;
        this._session = session;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        deviceInfoData.put(JsonStorageKeyNames.SESSION_ID_KEY, this._session.getId());
        return deviceInfoData;
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/DeviceInfoReaderWithStorageInfo.java =====
package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.misc.IJsonStorageReader;
import com.unity3d.services.core.misc.JsonFlattener;
import com.unity3d.services.core.misc.JsonFlattenerRules;
import com.unity3d.services.core.misc.JsonStorageAggregator;
import com.unity3d.services.core.misc.Utilities;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class DeviceInfoReaderWithStorageInfo implements IDeviceInfoReader {
    private final IDeviceInfoReader _deviceInfoReader;
    private final JsonFlattenerRules _jsonFlattenerRules;
    private final List<IJsonStorageReader> _storageReaders;

    public DeviceInfoReaderWithStorageInfo(IDeviceInfoReader iDeviceInfoReader, JsonFlattenerRules jsonFlattenerRules, IJsonStorageReader... iJsonStorageReaderArr) {
        this._deviceInfoReader = iDeviceInfoReader;
        this._jsonFlattenerRules = jsonFlattenerRules;
        this._storageReaders = Arrays.asList(iJsonStorageReaderArr);
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        return deviceInfoData != null ? Utilities.combineJsonIntoMap(deviceInfoData, new JsonFlattener(new JsonStorageAggregator(this._storageReaders).getData()).flattenJson(".", this._jsonFlattenerRules)) : deviceInfoData;
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/GameSessionIdReader.java =====
package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageManager;
import com.unity3d.services.core.properties.ClientProperties;
import java.util.UUID;

/* loaded from: classes.dex */
public class GameSessionIdReader implements IGameSessionIdReader {
    private static final int GAME_SESSION_ID_LENGTH = 12;
    private static volatile GameSessionIdReader _instance;
    private Long gameSessionId;

    private GameSessionIdReader() {
    }

    public static GameSessionIdReader getInstance() {
        if (_instance == null) {
            synchronized (GameSessionIdReader.class) {
                if (_instance == null) {
                    _instance = new GameSessionIdReader();
                }
            }
        }
        return _instance;
    }

    @Override // com.unity3d.services.core.device.reader.IGameSessionIdReader
    public synchronized Long getGameSessionId() {
        if (this.gameSessionId == null) {
            generate();
        }
        return this.gameSessionId;
    }

    @Override // com.unity3d.services.core.device.reader.IGameSessionIdReader
    public synchronized Long getGameSessionIdAndStore() {
        if (this.gameSessionId == null) {
            generate();
            store();
        }
        return this.gameSessionId;
    }

    private void generate() {
        UUID randomUUID = UUID.randomUUID();
        this.gameSessionId = Long.valueOf((Long.toString(randomUUID.getMostSignificantBits()) + Long.toString(randomUUID.getLeastSignificantBits())).replace("-", "").substring(0, 12));
    }

    private void store() {
        Storage storage;
        if (!StorageManager.init(ClientProperties.getApplicationContext()) || (storage = StorageManager.getStorage(StorageManager.StorageType.PRIVATE)) == null) {
            return;
        }
        storage.set(JsonStorageKeyNames.GAME_SESSION_ID_NORMALIZED_KEY, this.gameSessionId);
        storage.writeStorage();
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/HdrInfoReader.java =====
package com.unity3d.services.core.device.reader;

import android.app.Activity;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.unity3d.services.core.configuration.ExperimentsReader;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class HdrInfoReader implements IHdrInfoReader {
    private static final AtomicBoolean _hdrMetricsCaptured = new AtomicBoolean(false);
    private static volatile HdrInfoReader _instance;
    private final SDKMetricsSender _sdkMetricsSender = (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);

    private HdrInfoReader() {
    }

    public static HdrInfoReader getInstance() {
        if (_instance == null) {
            synchronized (HdrInfoReader.class) {
                if (_instance == null) {
                    _instance = new HdrInfoReader();
                }
            }
        }
        return _instance;
    }

    @Override // com.unity3d.services.core.device.reader.IHdrInfoReader
    public void captureHDRCapabilityMetrics(Activity activity, ExperimentsReader experimentsReader) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (activity != null && experimentsReader.getCurrentlyActiveExperiments().isCaptureHDRCapabilitiesEnabled()) {
            if (_hdrMetricsCaptured.compareAndSet(false, true)) {
                ArrayList arrayList = new ArrayList(5);
                if (Build.VERSION.SDK_INT >= 24) {
                    Display.HdrCapabilities hdrCapabilities = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getHdrCapabilities();
                    boolean z5 = false;
                    z2 = false;
                    z3 = false;
                    z4 = false;
                    for (int i : hdrCapabilities.getSupportedHdrTypes()) {
                        if (i == 1) {
                            z5 = true;
                        } else if (i == 2) {
                            z2 = true;
                        } else if (i == 3) {
                            z4 = true;
                        } else if (i == 4) {
                            z3 = true;
                        }
                    }
                    long round = Math.round(hdrCapabilities.getDesiredMaxAverageLuminance());
                    long round2 = Math.round(hdrCapabilities.getDesiredMaxLuminance());
                    long round3 = Math.round(hdrCapabilities.getDesiredMinLuminance());
                    arrayList.add(new Metric("native_device_hdr_lum_max_average", Long.valueOf(round)));
                    arrayList.add(new Metric("native_device_hdr_lum_max", Long.valueOf(round2)));
                    arrayList.add(new Metric("native_device_hdr_lum_min", Long.valueOf(round3)));
                    z = Build.VERSION.SDK_INT >= 26 ? activity.getResources().getConfiguration().isScreenHdr() : false;
                    r0 = z5;
                } else {
                    z = false;
                    z2 = false;
                    z3 = false;
                    z4 = false;
                }
                if (r0) {
                    arrayList.add(new Metric("native_device_hdr_dolby_vision_success"));
                } else {
                    arrayList.add(new Metric("native_device_hdr_dolby_vision_failure"));
                }
                if (z2) {
                    arrayList.add(new Metric("native_device_hdr_hdr10_success"));
                } else {
                    arrayList.add(new Metric("native_device_hdr_hdr10_failure"));
                }
                if (z3) {
                    arrayList.add(new Metric("native_device_hdr_hdr10_plus_success"));
                } else {
                    arrayList.add(new Metric("native_device_hdr_hdr10_plus_failure"));
                }
                if (z4) {
                    arrayList.add(new Metric("native_device_hdr_hlg_success"));
                } else {
                    arrayList.add(new Metric("native_device_hdr_hlg_failure"));
                }
                if (z) {
                    arrayList.add(new Metric("native_device_hdr_screen_hdr_success"));
                } else {
                    arrayList.add(new Metric("native_device_hdr_screen_hdr_failure"));
                }
                this._sdkMetricsSender.sendMetrics(arrayList);
            }
        }
    }
}

// ===== FILE: com/unity3d/services/core/device/reader/IDeviceInfoDataCompressor.java =====
package com.unity3d.services.core.device.reader;

import java.util.Map;

/* loaded from: classes.dex */
public interface IDeviceInfoDataCompressor extends IDeviceInfoDataContainer {
    byte[] compressDeviceInfo(Map<String, Object> map);
}

// ===== FILE: com/unity3d/services/core/device/reader/IDeviceInfoDataContainer.java =====
package com.unity3d.services.core.device.reader;

import java.util.Map;

/* loaded from: classes.dex */
public interface IDeviceInfoDataContainer {
    byte[] getDeviceData();

    Map<String, Object> getDeviceInfo();
}

// ===== FILE: com/unity3d/services/core/device/reader/IDeviceInfoReader.java =====
package com.unity3d.services.core.device.reader;

import java.util.Map;

/* loaded from: classes.dex */
public interface IDeviceInfoReader {
    Map<String, Object> getDeviceInfoData();
}

// ===== FILE: com/unity3d/services/core/device/reader/IGameSessionIdReader.java =====
package com.unity3d.services.core.device.reader;

/* loaded from: classes.dex */
public interface IGameSessionIdReader {
    Long getGameSessionId();

    Long getGameSessionIdAndStore();
}

// ===== FILE: com/unity3d/services/core/device/reader/IHdrInfoReader.java =====
package com.unity3d.services.core.device.reader;

import android.app.Activity;
import com.unity3d.services.core.configuration.ExperimentsReader;

/* loaded from: classes.dex */
public interface IHdrInfoReader {
    void captureHDRCapabilityMetrics(Activity activity, ExperimentsReader experimentsReader);
}

// ===== FILE: com/unity3d/services/core/device/reader/JsonStorageKeyNames.java =====
package com.unity3d.services.core.device.reader;

/* loaded from: classes.dex */
public class JsonStorageKeyNames {
    public static final String ADVERTISING_TRACKING_ID_KEY = "advertisingTrackingId";
    public static final String ADVERTISING_TRACKING_ID_NORMALIZED_KEY = "unifiedconfig.pii.advertisingTrackingId";
    public static final String AUID_ID_KEY = "auid";
    public static final String DATA_KEY = "data";
    public static final String GAME_SESSION_ID_KEY = "gameSessionId";
    public static final String GAME_SESSION_ID_NORMALIZED_KEY = "unifiedconfig.data.gameSessionId";
    public static final String PRIVACY_MODE_KEY = "privacy.mode.value";
    public static final String PRIVACY_SPM_KEY = "privacy.spm.value";
    public static final String SESSION_ID_KEY = "sessionId";
    public static final String UNIFIED_CONFIG_KEY = "unifiedconfig";
    public static final String UNIFIED_CONFIG_PII_KEY = "unifiedconfig.pii";
    public static final String USER_NON_BEHAVIORAL_KEY = "user.nonBehavioral";
    public static final String USER_NON_BEHAVIORAL_VALUE_ALT_KEY = "user.nonBehavioral.value";
    public static final String USER_NON_BEHAVIORAL_VALUE_KEY = "user.nonbehavioral.value";
}

// ===== FILE: com/unity3d/services/core/device/reader/MinimalDeviceInfoReader.java =====
package com.unity3d.services.core.device.reader;

import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class MinimalDeviceInfoReader implements IDeviceInfoReader {
    final IGameSessionIdReader _gameSessionIdReader;

    public MinimalDeviceInfoReader(IGameSessionIdReader iGameSessionIdReader) {
        this._gameSessionIdReader = iGameSessionIdReader;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("sdkVersion", Integer.valueOf(SdkProperties.getVersionCode()));
        hashMap.put("sdkVersionName", SdkProperties.getVersionName());
        hashMap.put(ScarConstants.IDFI_KEY, Device.getIdfi());
        hashMap.put(JsonStorageKeyNames.GAME_SESSION_ID_NORMALIZED_KEY, this._gameSessionIdReader.getGameSessionIdAndStore());
        hashMap.put("ts", Long.valueOf(System.currentTimeMillis()));
        hashMap.put(AndroidGetAdPlayerContext.KEY_GAME_ID, ClientProperties.getGameId());
        return hashMap;
    }
}
