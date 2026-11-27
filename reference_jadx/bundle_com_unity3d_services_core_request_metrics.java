
// ===== FILE: com/unity3d/services/core/request/metrics/AdOperationError.java =====
package com.unity3d.services.core.request.metrics;

/* loaded from: classes.dex */
public enum AdOperationError {
    init_failed,
    internal,
    invalid,
    no_fill,
    timeout,
    not_ready,
    player,
    no_connection,
    already_showing,
    callback_error,
    callback_timeout
}

// ===== FILE: com/unity3d/services/core/request/metrics/AdOperationMetric.java =====
package com.unity3d.services.core.request.metrics;

import com.unity3d.ads.UnityAds;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AdOperationMetric {
    private static final String AD_IS_HEADER_BIDDING = "is_header_bidding";
    private static final String AD_LOAD_FAIL = "native_load_time_failure";
    private static final String AD_LOAD_START = "native_load_started";
    private static final String AD_LOAD_SUCCESS = "native_load_time_success";
    private static final String AD_LOAD_TYPE = "type";
    private static final String AD_SHOW_FAIL = "native_show_time_failure";
    private static final String AD_SHOW_START = "native_show_started";
    private static final String AD_SHOW_SUCCESS = "native_show_time_success";
    private static final String AD_TYPE_BANNER = "banner";
    private static final String AD_TYPE_VIDEO = "video";
    public static final String INIT_STATE = "state";
    public static final String REASON = "reason";
    private static final String UNKNOWN = "unknown";

    public static Metric newAdLoadStart(boolean z, boolean z2) {
        return new Metric("native_load_started", null, getTags(null, false, z, Boolean.valueOf(z2)));
    }

    public static Metric newAdShowStart() {
        return new Metric("native_show_started", null, getTags(null, false, false, null));
    }

    public static Metric newAdLoadSuccess(Long l, boolean z, boolean z2) {
        return new Metric(AD_LOAD_SUCCESS, l, getTags(null, false, z, Boolean.valueOf(z2)));
    }

    public static Metric newAdShowSuccess(Long l) {
        return new Metric(AD_SHOW_SUCCESS, l, getTags(null, false, false, null));
    }

    public static Metric newAdLoadFailure(AdOperationError adOperationError, Long l, boolean z, boolean z2) {
        return new Metric(AD_LOAD_FAIL, l, getTags(adOperationError, true, z, Boolean.valueOf(z2)));
    }

    public static Metric newAdLoadFailure(UnityAds.UnityAdsLoadError unityAdsLoadError, Long l, boolean z, boolean z2) {
        return newAdLoadFailure(mapUnityAdsLoadError(unityAdsLoadError), l, z, z2);
    }

    public static Metric newAdShowFailure(AdOperationError adOperationError, Long l) {
        return new Metric(AD_SHOW_FAIL, l, getTags(adOperationError, true, false, null));
    }

    public static Metric newAdShowFailure(UnityAds.UnityAdsShowError unityAdsShowError, Long l) {
        return newAdShowFailure(mapUnityAdsShowError(unityAdsShowError), l);
    }

    private static HashMap<String, String> getTags(AdOperationError adOperationError, boolean z, boolean z2, Boolean bool) {
        return new HashMap<String, String>(z, adOperationError == null ? "unknown" : adOperationError.toString(), z2 ? AD_TYPE_BANNER : "video", bool) { // from class: com.unity3d.services.core.request.metrics.AdOperationMetric.1
            final /* synthetic */ String val$errorMetric;
            final /* synthetic */ boolean val$isFailure;
            final /* synthetic */ Boolean val$isHb;
            final /* synthetic */ String val$type;

            {
                this.val$isFailure = z;
                this.val$errorMetric = r2;
                this.val$type = r3;
                this.val$isHb = bool;
                if (z) {
                    put("reason", r2);
                }
                put(AdOperationMetric.AD_LOAD_TYPE, r3);
                if (bool != null) {
                    put(AdOperationMetric.AD_IS_HEADER_BIDDING, String.valueOf(bool));
                }
            }
        };
    }

    private static AdOperationError mapUnityAdsLoadError(UnityAds.UnityAdsLoadError unityAdsLoadError) {
        int i = C12562.$SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[unityAdsLoadError.ordinal()];
        if (i == 1) {
            return AdOperationError.init_failed;
        }
        if (i == 2) {
            return AdOperationError.internal;
        }
        if (i == 3) {
            return AdOperationError.invalid;
        }
        if (i == 4) {
            return AdOperationError.no_fill;
        }
        if (i != 5) {
            return null;
        }
        return AdOperationError.timeout;
    }

    /* renamed from: com.unity3d.services.core.request.metrics.AdOperationMetric$2 */
    static /* synthetic */ class C12562 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError;
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError;

        static {
            int[] iArr = new int[UnityAds.UnityAdsShowError.values().length];
            $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError = iArr;
            try {
                iArr[UnityAds.UnityAdsShowError.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.NOT_READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.VIDEO_PLAYER_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.INVALID_ARGUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.NO_CONNECTION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.ALREADY_SHOWING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[UnityAds.UnityAdsShowError.INTERNAL_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[UnityAds.UnityAdsLoadError.values().length];
            $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError = iArr2;
            try {
                iArr2[UnityAds.UnityAdsLoadError.INITIALIZE_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.INTERNAL_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.INVALID_ARGUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.TIMEOUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private static AdOperationError mapUnityAdsShowError(UnityAds.UnityAdsShowError unityAdsShowError) {
        switch (C12562.$SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError[unityAdsShowError.ordinal()]) {
            case 1:
                return AdOperationError.init_failed;
            case 2:
                return AdOperationError.not_ready;
            case 3:
                return AdOperationError.player;
            case 4:
                return AdOperationError.invalid;
            case 5:
                return AdOperationError.no_connection;
            case 6:
                return AdOperationError.already_showing;
            case 7:
                return AdOperationError.internal;
            default:
                return null;
        }
    }
}

// ===== FILE: com/unity3d/services/core/request/metrics/InitMetric.java =====
package com.unity3d.services.core.request.metrics;

import java.util.HashMap;

/* loaded from: classes.dex */
public class InitMetric {
    private static final String INIT_GAME_ID_CHANGED = "native_initialize_game_id_changed";
    private static final String INIT_GAME_ID_SAME = "native_initialize_game_id_same";
    private static final String INIT_TAG_GAME_ID = "game_id";
    private static final String INIT_TAG_PREVIOUS_GAME_ID = "previous_game_id";
    private static final String INIT_TAG_PREVIOUS_TEST_MODE = "previous_test_mode";
    private static final String INIT_TAG_TEST_MODE = "test_mode";
    private static final String INIT_TEST_MODE_CHANGED = "native_initialize_test_mode_changed";
    private static final String INIT_TEST_MODE_SAME = "native_initialize_test_mode_same";

    public static Metric newInitGameIdChanged(String str, String str2) {
        return new Metric(INIT_GAME_ID_CHANGED, null, new HashMap<String, String>(str2, str) { // from class: com.unity3d.services.core.request.metrics.InitMetric.1
            final /* synthetic */ String val$gameId;
            final /* synthetic */ String val$previousGameId;

            {
                this.val$gameId = str2;
                this.val$previousGameId = str;
                put(InitMetric.INIT_TAG_GAME_ID, str2);
                put(InitMetric.INIT_TAG_PREVIOUS_GAME_ID, str);
            }
        });
    }

    public static Metric newInitGameIdSame(String str, String str2) {
        return new Metric(INIT_GAME_ID_SAME, null, new HashMap<String, String>(str2, str) { // from class: com.unity3d.services.core.request.metrics.InitMetric.2
            final /* synthetic */ String val$gameId;
            final /* synthetic */ String val$previousGameId;

            {
                this.val$gameId = str2;
                this.val$previousGameId = str;
                put(InitMetric.INIT_TAG_GAME_ID, str2);
                put(InitMetric.INIT_TAG_PREVIOUS_GAME_ID, str);
            }
        });
    }

    public static Metric newInitTestModeChanged(Boolean bool, Boolean bool2) {
        return new Metric(INIT_TEST_MODE_CHANGED, null, new HashMap<String, String>(bool2, bool) { // from class: com.unity3d.services.core.request.metrics.InitMetric.3
            final /* synthetic */ Boolean val$previousTestMode;
            final /* synthetic */ Boolean val$testMode;

            {
                this.val$testMode = bool2;
                this.val$previousTestMode = bool;
                put(InitMetric.INIT_TAG_TEST_MODE, bool2.toString());
                put(InitMetric.INIT_TAG_PREVIOUS_TEST_MODE, bool.toString());
            }
        });
    }

    public static Metric newInitTestModeSame(Boolean bool, Boolean bool2) {
        return new Metric(INIT_TEST_MODE_SAME, null, new HashMap<String, String>(bool2, bool) { // from class: com.unity3d.services.core.request.metrics.InitMetric.4
            final /* synthetic */ Boolean val$previousTestMode;
            final /* synthetic */ Boolean val$testMode;

            {
                this.val$testMode = bool2;
                this.val$previousTestMode = bool;
                put(InitMetric.INIT_TAG_TEST_MODE, bool2.toString());
                put(InitMetric.INIT_TAG_PREVIOUS_TEST_MODE, bool.toString());
            }
        });
    }
}

// ===== FILE: com/unity3d/services/core/request/metrics/Metric.java =====
package com.unity3d.services.core.request.metrics;

import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Metric.kt */
@Metadata(m443d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B3\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J7\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, m444d2 = {"Lcom/unity3d/services/core/request/metrics/Metric;", "", MediationMetaData.KEY_NAME, "", "value", "tags", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/util/Map;)V", "getName", "()Ljava/lang/String;", "getTags", "()Ljava/util/Map;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toMap", "toString", "Companion", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final /* data */ class Metric {
    private static final String METRIC_NAME = "n";
    private static final String METRIC_TAGS = "t";
    private static final String METRIC_VALUE = "v";
    private final String name;
    private final Map<String, String> tags;
    private final Object value;

    public Metric(String str) {
        this(str, null, null, 6, null);
    }

    public Metric(String str, Object obj) {
        this(str, obj, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Metric copy$default(Metric metric, String str, Object obj, Map map, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = metric.name;
        }
        if ((i & 2) != 0) {
            obj = metric.value;
        }
        if ((i & 4) != 0) {
            map = metric.tags;
        }
        return metric.copy(str, obj, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final Object getValue() {
        return this.value;
    }

    public final Map<String, String> component3() {
        return this.tags;
    }

    public final Metric copy(String name, Object value, Map<String, String> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new Metric(name, value, tags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Metric)) {
            return false;
        }
        Metric metric = (Metric) other;
        return Intrinsics.areEqual(this.name, metric.name) && Intrinsics.areEqual(this.value, metric.value) && Intrinsics.areEqual(this.tags, metric.tags);
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Object obj = this.value;
        return ((hashCode + (obj != null ? obj.hashCode() : 0)) * 31) + this.tags.hashCode();
    }

    public String toString() {
        return "Metric(name=" + this.name + ", value=" + this.value + ", tags=" + this.tags + ')';
    }

    public Metric(String str, Object obj, Map<String, String> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.name = str;
        this.value = obj;
        this.tags = tags;
    }

    public /* synthetic */ Metric(String str, Object obj, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, String> getTags() {
        return this.tags;
    }

    public final Object getValue() {
        return this.value;
    }

    public final Map<String, Object> toMap() {
        Map createMapBuilder = MapsKt.createMapBuilder();
        String str = this.name;
        if (str != null) {
            createMapBuilder.put(METRIC_NAME, str);
        }
        Object obj = this.value;
        if (obj != null) {
            createMapBuilder.put(METRIC_VALUE, obj);
        }
        if (!this.tags.isEmpty()) {
            createMapBuilder.put(METRIC_TAGS, this.tags);
        }
        return MapsKt.build(createMapBuilder);
    }
}

// ===== FILE: com/unity3d/services/core/request/metrics/MetricCommonTags.java =====
package com.unity3d.services.core.request.metrics;

import com.unity3d.ads.core.data.datasource.AndroidMediationDataSource;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.PrivacyConfig;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageManager;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.IObserver;
import com.unity3d.services.core.properties.SdkProperties;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class MetricCommonTags {
    private static final String METRIC_COMMON_TAG_CONFIG_SOURCE = "src";
    private static final String METRIC_COMMON_TAG_COUNTRY_ISO = "iso";
    private static final String METRIC_COMMON_TAG_MEDIATION_ADAPTER = "m_ad_ver";
    private static final String METRIC_COMMON_TAG_MEDIATION_NAME = "m_name";
    private static final String METRIC_COMMON_TAG_MEDIATION_VERSION = "m_ver";
    private static final String METRIC_COMMON_TAG_PLATFORM = "plt";
    public static final String METRIC_COMMON_TAG_PLATFORM_ANDROID = "android";
    private static final String METRIC_COMMON_TAG_PRIVACY_MODE = "prvc";
    private static final String METRIC_COMMON_TAG_SDK_VERSION = "sdk";
    private static final String METRIC_COMMON_TAG_SYSTEM_VERSION = "system";
    private static final String METRIC_COMMON_TAG_TEST_MODE = "tm";
    private String _configSrc;
    private final String _countryISO;
    private Map<String, String> _experiments;
    private String _mediationAdapter;
    private String _mediationName;
    private String _mediationVersion;
    private final String _platform;
    private String _privacyMode;
    private final IObserver<PrivacyConfig> _privacyObserver;
    private final String _sdkVersion;
    private final String _systemVersion;
    private final boolean _testMode;

    public MetricCommonTags() {
        IObserver<PrivacyConfig> iObserver = new IObserver<PrivacyConfig>() { // from class: com.unity3d.services.core.request.metrics.MetricCommonTags.1
            @Override // com.unity3d.services.core.misc.IObserver
            public void updated(PrivacyConfig privacyConfig) {
                MetricCommonTags.this._privacyMode = privacyConfig.getPrivacyStatus().toString().toLowerCase();
            }
        };
        this._privacyObserver = iObserver;
        this._countryISO = Device.getNetworkCountryISO();
        this._platform = "android";
        this._sdkVersion = SdkProperties.getVersionName();
        this._systemVersion = Device.getOsVersion();
        this._privacyMode = PrivacyConfigStorage.getInstance().getPrivacyConfig().getPrivacyStatus().toLowerCase();
        this._testMode = SdkProperties.isTestMode();
        PrivacyConfigStorage.getInstance().registerObserver(iObserver);
    }

    public void updateWithConfig(Configuration configuration) {
        this._configSrc = configuration.getSrc();
        if (configuration.getExperiments() != null) {
            this._experiments = configuration.getExperiments().getExperimentTags();
        }
    }

    public Map<String, String> toMap() {
        if (mediationIsEmpty()) {
            refreshMediationData();
        }
        HashMap hashMap = new HashMap();
        String str = this._countryISO;
        if (str != null) {
            hashMap.put(METRIC_COMMON_TAG_COUNTRY_ISO, str);
        }
        String str2 = this._platform;
        if (str2 != null) {
            hashMap.put(METRIC_COMMON_TAG_PLATFORM, str2);
        }
        String str3 = this._sdkVersion;
        if (str3 != null) {
            hashMap.put("sdk", str3);
        }
        String str4 = this._systemVersion;
        if (str4 != null) {
            hashMap.put(METRIC_COMMON_TAG_SYSTEM_VERSION, str4);
        }
        String str5 = this._privacyMode;
        if (str5 != null) {
            hashMap.put(METRIC_COMMON_TAG_PRIVACY_MODE, str5);
        }
        String str6 = this._configSrc;
        if (str6 != null) {
            hashMap.put(METRIC_COMMON_TAG_CONFIG_SOURCE, str6);
        }
        String str7 = this._mediationName;
        if (str7 != null) {
            hashMap.put(METRIC_COMMON_TAG_MEDIATION_NAME, str7);
        }
        String str8 = this._mediationVersion;
        if (str8 != null) {
            hashMap.put(METRIC_COMMON_TAG_MEDIATION_VERSION, str8);
        }
        String str9 = this._mediationAdapter;
        if (str9 != null) {
            hashMap.put(METRIC_COMMON_TAG_MEDIATION_ADAPTER, str9);
        }
        Map<String, String> map = this._experiments;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put(METRIC_COMMON_TAG_TEST_MODE, String.valueOf(this._testMode));
        return hashMap;
    }

    public void shutdown() {
        PrivacyConfigStorage.getInstance().unregisterObserver(this._privacyObserver);
    }

    private void refreshMediationData() {
        try {
            Storage storage = StorageManager.getStorage(StorageManager.StorageType.PUBLIC);
            if (storage == null || !storage.initStorage()) {
                return;
            }
            this._mediationName = (String) storage.get(AndroidMediationDataSource.MEDIATION_NAME_KEY);
            this._mediationVersion = (String) storage.get(AndroidMediationDataSource.MEDIATION_VERSION_KEY);
            this._mediationAdapter = (String) storage.get("mediation.adapter_version.value");
        } catch (Exception e) {
            DeviceLog.debug("Failed to refreshMediationData: %s", e.getLocalizedMessage());
        }
    }

    private boolean mediationIsEmpty() {
        String str = this._mediationName;
        return str == null || str.isEmpty();
    }
}

// ===== FILE: com/unity3d/services/core/request/metrics/MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1.java =====
package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.log.DeviceLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: CoroutineExceptionHandler.kt */
@Metadata(m443d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, m444d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ List $metrics$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Companion companion, List list) {
        super(companion);
        this.$metrics$inlined = list;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext context, Throwable exception) {
        DeviceLog.debug("Metric " + this.$metrics$inlined + " failed to send with error: " + exception);
    }
}

// ===== FILE: com/unity3d/services/core/request/metrics/MetricSender$sendMetrics$1.java =====
package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: MetricSender.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.request.metrics.MetricSender$sendMetrics$1", m464f = "MetricSender.kt", m465i = {}, m466l = {65}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class MetricSender$sendMetrics$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Metric> $metrics;
    int label;
    final /* synthetic */ MetricSender this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MetricSender$sendMetrics$1(MetricSender metricSender, List<Metric> list, Continuation<? super MetricSender$sendMetrics$1> continuation) {
        super(2, continuation);
        this.this$0 = metricSender;
        this.$metrics = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MetricSender$sendMetrics$1(this.this$0, this.$metrics, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MetricSender$sendMetrics$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        MetricCommonTags metricCommonTags;
        String str2;
        HttpClient httpClient;
        Object execute;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            str = this.this$0.metricSampleRate;
            metricCommonTags = this.this$0.commonTags;
            List<Metric> list = this.$metrics;
            str2 = this.this$0.sessionToken;
            String jSONObject = new JSONObject(new MetricsContainer(str, metricCommonTags, list, str2).toMap()).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(container.toMap()).toString()");
            String metricEndPoint = this.this$0.getMetricEndPoint();
            if (metricEndPoint == null) {
                metricEndPoint = "";
            }
            HttpRequest httpRequest = new HttpRequest(metricEndPoint, null, RequestType.POST, jSONObject, null, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131058, null);
            httpClient = this.this$0.httpClient;
            this.label = 1;
            execute = httpClient.execute(httpRequest, this);
            if (execute == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            execute = obj;
        }
        HttpResponse httpResponse = (HttpResponse) execute;
        if (httpResponse.getStatusCode() / 100 == 2) {
            DeviceLog.debug("Metric " + this.$metrics + " sent to " + this.this$0.getMetricEndPoint());
        } else {
            DeviceLog.debug("Metric " + this.$metrics + " failed to send with response code: " + httpResponse.getStatusCode());
        }
        return Unit.INSTANCE;
    }
}

// ===== FILE: com/unity3d/services/core/request/metrics/MetricSender.java =====
package com.unity3d.services.core.request.metrics;

import androidx.core.app.NotificationCompat;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.p005di.IServiceComponent;
import com.unity3d.services.core.p005di.IServiceProvider;
import com.unity3d.services.core.properties.InitializationStatusReader;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: MetricSender.kt */
@Metadata(m443d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J.\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0016\u0010 \u001a\u00020\u00182\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\"H\u0016J\u0006\u0010#\u001a\u00020\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m444d2 = {"Lcom/unity3d/services/core/request/metrics/MetricSender;", "Lcom/unity3d/services/core/request/metrics/MetricSenderBase;", "Lcom/unity3d/services/core/di/IServiceComponent;", "configuration", "Lcom/unity3d/services/core/configuration/Configuration;", "initializationStatusReader", "Lcom/unity3d/services/core/properties/InitializationStatusReader;", "(Lcom/unity3d/services/core/configuration/Configuration;Lcom/unity3d/services/core/properties/InitializationStatusReader;)V", "commonTags", "Lcom/unity3d/services/core/request/metrics/MetricCommonTags;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "httpClient", "Lcom/unity3d/services/core/network/core/HttpClient;", "metricEndPoint", "", "getMetricEndPoint", "()Ljava/lang/String;", "metricSampleRate", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sessionToken", "kotlin.jvm.PlatformType", "sendEvent", "", NotificationCompat.CATEGORY_EVENT, "value", "tags", "", "sendMetric", "metric", "Lcom/unity3d/services/core/request/metrics/Metric;", "sendMetrics", "metrics", "", "shutdown", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public class MetricSender extends MetricSenderBase implements IServiceComponent {
    private final MetricCommonTags commonTags;
    private final ISDKDispatchers dispatchers;
    private final HttpClient httpClient;
    private final String metricEndPoint;
    private final String metricSampleRate;
    private final CoroutineScope scope;
    private final String sessionToken;

    @Override // com.unity3d.services.core.p005di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetricSender(Configuration configuration, InitializationStatusReader initializationStatusReader) {
        super(initializationStatusReader);
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(initializationStatusReader, "initializationStatusReader");
        MetricCommonTags metricCommonTags = new MetricCommonTags();
        metricCommonTags.updateWithConfig(configuration);
        this.commonTags = metricCommonTags;
        this.metricSampleRate = String.valueOf(MathKt.roundToInt(configuration.getMetricSampleRate()));
        this.sessionToken = configuration.getSessionToken();
        MetricSender metricSender = this;
        ISDKDispatchers iSDKDispatchers = (ISDKDispatchers) metricSender.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class));
        this.dispatchers = iSDKDispatchers;
        this.httpClient = (HttpClient) metricSender.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(HttpClient.class));
        this.scope = CoroutineScopeKt.CoroutineScope(iSDKDispatchers.getIo());
        this.metricEndPoint = configuration.getMetricsUrl();
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public String getMetricEndPoint() {
        return this.metricEndPoint;
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendEvent(String event, String value, Map<String, String> tags) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (event.length() == 0) {
            DeviceLog.debug("Metric event not sent due to being null or empty: " + event);
            return;
        }
        sendMetrics(CollectionsKt.listOf(new Metric(event, value, tags)));
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendMetric(Metric metric) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        sendMetrics(CollectionsKt.listOf(metric));
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendMetrics(List<Metric> metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        if (metrics.isEmpty()) {
            DeviceLog.debug("Metrics event not send due to being empty");
            return;
        }
        String metricEndPoint = getMetricEndPoint();
        if (!(metricEndPoint == null || StringsKt.isBlank(metricEndPoint))) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, new MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, metrics), null, new MetricSender$sendMetrics$1(this, metrics, null), 2, null);
            return;
        }
        DeviceLog.debug("Metrics: " + metrics + " was not sent to null or empty endpoint: " + getMetricEndPoint());
    }

    public final void shutdown() {
        this.commonTags.shutdown();
    }
}

// ===== FILE: com/unity3d/services/core/request/metrics/MetricSenderBase.java =====
package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.properties.InitializationStatusReader;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetricSenderBase.kt */
@Metadata(m443d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m444d2 = {"Lcom/unity3d/services/core/request/metrics/MetricSenderBase;", "Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "_initStatusReader", "Lcom/unity3d/services/core/properties/InitializationStatusReader;", "(Lcom/unity3d/services/core/properties/InitializationStatusReader;)V", "sendMetricWithInitState", "", "metric", "Lcom/unity3d/services/core/request/metrics/Metric;", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public abstract class MetricSenderBase implements SDKMetricsSender {
    private final InitializationStatusReader _initStatusReader;

    public MetricSenderBase(InitializationStatusReader _initStatusReader) {
        Intrinsics.checkNotNullParameter(_initStatusReader, "_initStatusReader");
        this._initStatusReader = _initStatusReader;
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendEvent(String str) {
        SDKMetricsSender.DefaultImpls.sendEvent(this, str);
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendMetricWithInitState(Metric metric) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        sendMetric(Metric.copy$default(metric, null, null, MapsKt.plus(metric.getTags(), MapsKt.mapOf(TuplesKt.m451to("state", this._initStatusReader.getInitializationStateString(SdkProperties.getCurrentInitializationState())))), 3, null));
    }
}

// ===== FILE: com/unity3d/services/core/request/metrics/MetricSenderWithBatch.java =====
package com.unity3d.services.core.request.metrics;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.InitializationStatusReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetricSenderWithBatch.kt */
@Metadata(m443d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J.\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0016\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, m444d2 = {"Lcom/unity3d/services/core/request/metrics/MetricSenderWithBatch;", "Lcom/unity3d/services/core/request/metrics/MetricSenderBase;", "_original", "Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "initializationStatusReader", "Lcom/unity3d/services/core/properties/InitializationStatusReader;", "(Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;Lcom/unity3d/services/core/properties/InitializationStatusReader;)V", "_queue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/unity3d/services/core/request/metrics/Metric;", "metricEndPoint", "", "getMetricEndPoint", "()Ljava/lang/String;", "sendEvent", "", NotificationCompat.CATEGORY_EVENT, "value", "tags", "", "sendMetric", "metric", "sendMetrics", "metrics", "", "sendQueueIfNeeded", "updateOriginal", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class MetricSenderWithBatch extends MetricSenderBase {
    private SDKMetricsSender _original;
    private final LinkedBlockingQueue<Metric> _queue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetricSenderWithBatch(SDKMetricsSender _original, InitializationStatusReader initializationStatusReader) {
        super(initializationStatusReader);
        Intrinsics.checkNotNullParameter(_original, "_original");
        Intrinsics.checkNotNullParameter(initializationStatusReader, "initializationStatusReader");
        this._original = _original;
        this._queue = new LinkedBlockingQueue<>();
    }

    public final void updateOriginal(SDKMetricsSender metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        this._original = metrics;
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendEvent(String event, String value, Map<String, String> tags) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (event.length() == 0) {
            DeviceLog.debug("Metric event not sent due to being empty: " + event);
            return;
        }
        sendMetrics(CollectionsKt.listOf(new Metric(event, value, tags)));
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendMetric(Metric metric) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        sendMetrics(CollectionsKt.listOf(metric));
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public synchronized void sendMetrics(List<Metric> metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        this._queue.addAll(metrics);
        if (!TextUtils.isEmpty(this._original.getMetricEndPoint()) && this._queue.size() > 0) {
            ArrayList arrayList = new ArrayList();
            this._queue.drainTo(arrayList);
            this._original.sendMetrics(arrayList);
        }
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public String getMetricEndPoint() {
        return this._original.getMetricEndPoint();
    }

    public final void sendQueueIfNeeded() {
        sendMetrics(CollectionsKt.emptyList());
    }
}

// ===== FILE: com/unity3d/services/core/request/metrics/MetricsContainer.java =====
package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetricsContainer.kt */
@Metadata(m443d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0013R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m444d2 = {"Lcom/unity3d/services/core/request/metrics/MetricsContainer;", "", "metricSampleRate", "", "commonTags", "Lcom/unity3d/services/core/request/metrics/MetricCommonTags;", "metrics", "", "Lcom/unity3d/services/core/request/metrics/Metric;", MetricsContainer.METRIC_CONTAINER_SESSION_TOKEN, "(Ljava/lang/String;Lcom/unity3d/services/core/request/metrics/MetricCommonTags;Ljava/util/List;Ljava/lang/String;)V", "apiLevel", "deviceManufacturer", "kotlin.jvm.PlatformType", MetricsContainer.METRIC_CONTAINER_DEVICE_MODEL, MetricsContainer.METRIC_CONTAINER_DEVICE_NAME, "gameId", MetricsContainer.METRIC_CONTAINER_SHARED_SESSION_ID, "toMap", "", "Companion", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class MetricsContainer {
    private static final String METRICS_CONTAINER = "m";
    private static final String METRICS_CONTAINER_TAGS = "t";
    private static final String METRIC_CONTAINER_API_LEVEL = "apil";
    private static final String METRIC_CONTAINER_DEVICE_MAKE = "deviceMake";
    private static final String METRIC_CONTAINER_DEVICE_MODEL = "deviceModel";
    private static final String METRIC_CONTAINER_DEVICE_NAME = "deviceName";
    private static final String METRIC_CONTAINER_GAME_ID = "gameId";
    private static final String METRIC_CONTAINER_SAMPLE_RATE = "msr";
    private static final String METRIC_CONTAINER_SESSION_TOKEN = "sTkn";
    private static final String METRIC_CONTAINER_SHARED_SESSION_ID = "shSid";
    private final String apiLevel;
    private final MetricCommonTags commonTags;
    private final String deviceManufacturer;
    private final String deviceModel;
    private final String deviceName;
    private final String gameId;
    private final String metricSampleRate;
    private final List<Metric> metrics;
    private final String sTkn;
    private final String shSid;

    public MetricsContainer(String metricSampleRate, MetricCommonTags commonTags, List<Metric> metrics, String str) {
        Intrinsics.checkNotNullParameter(metricSampleRate, "metricSampleRate");
        Intrinsics.checkNotNullParameter(commonTags, "commonTags");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        this.metricSampleRate = metricSampleRate;
        this.commonTags = commonTags;
        this.metrics = metrics;
        this.sTkn = str;
        this.shSid = Session.INSTANCE.getId();
        this.apiLevel = String.valueOf(Device.getApiLevel());
        this.deviceModel = Device.getModel();
        this.deviceName = Device.getDevice();
        this.deviceManufacturer = Device.getManufacturer();
        this.gameId = ClientProperties.getGameId();
    }

    public final Map<String, Object> toMap() {
        List<Metric> list = this.metrics;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Metric) it.next()).toMap());
        }
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put(METRIC_CONTAINER_SAMPLE_RATE, this.metricSampleRate);
        createMapBuilder.put(METRICS_CONTAINER, arrayList);
        createMapBuilder.put(METRICS_CONTAINER_TAGS, this.commonTags.toMap());
        createMapBuilder.put(METRIC_CONTAINER_SHARED_SESSION_ID, this.shSid);
        createMapBuilder.put(METRIC_CONTAINER_API_LEVEL, this.apiLevel);
        String str = this.sTkn;
        if (str != null) {
            createMapBuilder.put(METRIC_CONTAINER_SESSION_TOKEN, str);
        }
        String deviceModel = this.deviceModel;
        if (deviceModel != null) {
            Intrinsics.checkNotNullExpressionValue(deviceModel, "deviceModel");
            createMapBuilder.put(METRIC_CONTAINER_DEVICE_MODEL, deviceModel);
        }
        String deviceName = this.deviceName;
        if (deviceName != null) {
            Intrinsics.checkNotNullExpressionValue(deviceName, "deviceName");
            createMapBuilder.put(METRIC_CONTAINER_DEVICE_NAME, deviceName);
        }
        String deviceManufacturer = this.deviceManufacturer;
        if (deviceManufacturer != null) {
            Intrinsics.checkNotNullExpressionValue(deviceManufacturer, "deviceManufacturer");
            createMapBuilder.put(METRIC_CONTAINER_DEVICE_MAKE, deviceManufacturer);
        }
        String gameId = this.gameId;
        if (gameId != null) {
            Intrinsics.checkNotNullExpressionValue(gameId, "gameId");
            createMapBuilder.put("gameId", gameId);
        }
        return MapsKt.build(createMapBuilder);
    }
}

// ===== FILE: com/unity3d/services/core/request/metrics/SDKMetrics.java =====
package com.unity3d.services.core.request.metrics;

import android.text.TextUtils;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.InitializationStatusReader;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class SDKMetrics {
    private static final String NULL_INSTANCE_METRICS_URL = "nullInstanceMetricsUrl";
    private static MetricSenderWithBatch _batchedSender;
    private static final AtomicBoolean _configurationIsSet = new AtomicBoolean(false);
    private static SDKMetricsSender _instance;

    public static void setConfiguration(Configuration configuration) {
        if (configuration == null) {
            DeviceLog.debug("Metrics will not be sent from the device for this session due to misconfiguration");
            return;
        }
        if (isAllowedToSetConfiguration(configuration)) {
            SDKMetricsSender sDKMetricsSender = _instance;
            if (sDKMetricsSender instanceof MetricSender) {
                ((MetricSender) sDKMetricsSender).shutdown();
            }
            if (configuration.areMetricsEnabledForCurrentSession().booleanValue()) {
                _instance = new MetricSender(configuration, new InitializationStatusReader());
            } else {
                DeviceLog.debug("Metrics will not be sent from the device for this session");
                _instance = new NullInstance(NULL_INSTANCE_METRICS_URL);
            }
            MetricSenderWithBatch metricSenderWithBatch = _batchedSender;
            if (metricSenderWithBatch == null) {
                _batchedSender = new MetricSenderWithBatch(_instance, new InitializationStatusReader());
            } else {
                metricSenderWithBatch.updateOriginal(_instance);
            }
            _batchedSender.sendQueueIfNeeded();
        }
    }

    public static synchronized SDKMetricsSender getInstance() {
        MetricSenderWithBatch metricSenderWithBatch;
        synchronized (SDKMetrics.class) {
            if (_instance == null) {
                _instance = new NullInstance(null);
            }
            if (_batchedSender == null) {
                _batchedSender = new MetricSenderWithBatch(_instance, new InitializationStatusReader());
            }
            metricSenderWithBatch = _batchedSender;
        }
        return metricSenderWithBatch;
    }

    private static boolean isAllowedToSetConfiguration(Configuration configuration) {
        return !TextUtils.isEmpty(configuration.getMetricsUrl()) && _configurationIsSet.compareAndSet(false, true);
    }

    private static final class NullInstance implements SDKMetricsSender {
        private final String _metricEndpoint;

        public NullInstance(String str) {
            this._metricEndpoint = str;
        }

        @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
        public void sendEvent(String str) {
            DeviceLog.debug("Metric " + str + " was skipped from being sent");
        }

        @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
        public void sendEvent(String str, String str2, Map<String, String> map) {
            sendEvent(str);
        }

        public void sendEvent(String str, Map<String, String> map) {
            sendEvent(str);
        }

        @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
        public void sendMetric(Metric metric) {
            DeviceLog.debug("Metric " + metric + " was skipped from being sent");
        }

        @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
        public void sendMetrics(List<Metric> list) {
            DeviceLog.debug("Metrics: " + list + " was skipped from being sent");
        }

        @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
        public void sendMetricWithInitState(Metric metric) {
            sendMetric(metric);
        }

        @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
        public String getMetricEndPoint() {
            return this._metricEndpoint;
        }
    }
}

// ===== FILE: com/unity3d/services/core/request/metrics/SDKMetricsSender.java =====
package com.unity3d.services.core.request.metrics;

import androidx.core.app.NotificationCompat;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SDKMetricsSender.kt */
@Metadata(m443d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J2\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bH&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH&J\u0016\u0010\u0010\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, m444d2 = {"Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "", "metricEndPoint", "", "getMetricEndPoint", "()Ljava/lang/String;", "sendEvent", "", NotificationCompat.CATEGORY_EVENT, "value", "tags", "", "sendMetric", "metric", "Lcom/unity3d/services/core/request/metrics/Metric;", "sendMetricWithInitState", "sendMetrics", "metrics", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface SDKMetricsSender {
    String getMetricEndPoint();

    void sendEvent(String event);

    void sendEvent(String event, String value, Map<String, String> tags);

    void sendMetric(Metric metric);

    void sendMetricWithInitState(Metric metric);

    void sendMetrics(List<Metric> metrics);

    /* compiled from: SDKMetricsSender.kt */
    @Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class DefaultImpls {
        public static void sendEvent(SDKMetricsSender sDKMetricsSender, String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            sendEvent$default(sDKMetricsSender, event, null, null, 4, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void sendEvent$default(SDKMetricsSender sDKMetricsSender, String str, String str2, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            sDKMetricsSender.sendEvent(str, str2, map);
        }
    }
}

// ===== FILE: com/unity3d/services/core/request/metrics/ScarMetric.java =====
package com.unity3d.services.core.request.metrics;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ScarMetric {
    private static final String ASYNC_PREFIX = "async";
    private static final String HB_SIGNALS_FETCH_FAILURE = "native_hb_signals_%s_fetch_failure";
    private static final String HB_SIGNALS_FETCH_START = "native_hb_signals_%s_fetch_start";
    private static final String HB_SIGNALS_FETCH_SUCCESS = "native_hb_signals_%s_fetch_success";
    private static final String HB_SIGNALS_UPLOAD_FAILURE = "native_hb_signals_%s_upload_failure";
    private static final String HB_SIGNALS_UPLOAD_START = "native_hb_signals_%s_upload_start";
    private static final String HB_SIGNALS_UPLOAD_SUCCESS = "native_hb_signals_%s_upload_success";
    private static final String REASON = "reason";
    private static final String SYNC_PREFIX = "sync";
    private static long _fetchStartTime;
    private static long _uploadStartTime;

    private static long getTotalFetchTime() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - _fetchStartTime);
    }

    private static long getTotalUploadTime() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - _uploadStartTime);
    }

    public static Metric hbSignalsFetchStart(boolean z) {
        _fetchStartTime = System.nanoTime();
        Object[] objArr = new Object[1];
        objArr[0] = z ? ASYNC_PREFIX : "sync";
        return new Metric(String.format(HB_SIGNALS_FETCH_START, objArr), null);
    }

    public static Metric hbSignalsFetchSuccess(boolean z) {
        Object[] objArr = new Object[1];
        objArr[0] = z ? ASYNC_PREFIX : "sync";
        return new Metric(String.format(HB_SIGNALS_FETCH_SUCCESS, objArr), Long.valueOf(getTotalFetchTime()));
    }

    public static Metric hbSignalsFetchFailure(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        Object[] objArr = new Object[1];
        objArr[0] = z ? ASYNC_PREFIX : "sync";
        return new Metric(String.format(HB_SIGNALS_FETCH_FAILURE, objArr), Long.valueOf(getTotalFetchTime()), hashMap);
    }

    public static Metric hbSignalsUploadStart(boolean z) {
        _uploadStartTime = System.nanoTime();
        Object[] objArr = new Object[1];
        objArr[0] = z ? ASYNC_PREFIX : "sync";
        return new Metric(String.format(HB_SIGNALS_UPLOAD_START, objArr), null);
    }

    public static Metric hbSignalsUploadSuccess(boolean z) {
        Object[] objArr = new Object[1];
        objArr[0] = z ? ASYNC_PREFIX : "sync";
        return new Metric(String.format(HB_SIGNALS_UPLOAD_SUCCESS, objArr), Long.valueOf(getTotalUploadTime()));
    }

    public static Metric hbSignalsUploadFailure(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        Object[] objArr = new Object[1];
        objArr[0] = z ? ASYNC_PREFIX : "sync";
        return new Metric(String.format(HB_SIGNALS_UPLOAD_FAILURE, objArr), Long.valueOf(getTotalUploadTime()), hashMap);
    }
}

// ===== FILE: com/unity3d/services/core/request/metrics/TSIMetric.java =====
package com.unity3d.services.core.request.metrics;

import java.util.Map;

/* loaded from: classes.dex */
public class TSIMetric {
    private static final String TSI_METRIC_COLLECTION_LATENCY = "native_device_info_collection_latency";
    private static final String TSI_METRIC_COMPRESSION_LATENCY = "native_device_info_compression_latency";
    private static final String TSI_METRIC_CONFIG_REQUEST_FAILURE = "native_config_request_failure_time";
    private static final String TSI_METRIC_CONFIG_REQUEST_SUCCESS = "native_config_request_success_time";
    private static final String TSI_METRIC_EMERGENCY_OFF = "native_emergency_switch_off";
    private static final String TSI_METRIC_INIT_STARTED = "native_initialization_started";
    private static final String TSI_METRIC_MISSING_GAME_SESSION_ID = "native_missing_game_session_id";
    private static final String TSI_METRIC_MISSING_STATE_ID = "native_missing_state_id";
    private static final String TSI_METRIC_MISSING_TOKEN = "native_missing_token";
    private static final String TSI_METRIC_PRIVACY_REQUEST_FAILURE = "native_privacy_request_failure_time";
    private static final String TSI_METRIC_PRIVACY_REQUEST_SUCCESS = "native_privacy_request_success_time";
    private static final String TSI_METRIC_PRIVACY_RESOLUTION_FAILURE = "native_privacy_resolution_request_latency_failure";
    private static final String TSI_METRIC_PRIVACY_RESOLUTION_SUCCESS = "native_privacy_resolution_request_latency_success";
    private static final String TSI_METRIC_TOKEN_ASYNC_AVAILABLE = "native_async_token_available";
    private static final String TSI_METRIC_TOKEN_ASYNC_NULL = "native_async_token_null";
    private static final String TSI_METRIC_TOKEN_AVAILABLE = "native_generated_token_available";
    private static final String TSI_METRIC_TOKEN_CONFIG = "native_token_availability_latency_config";
    private static final String TSI_METRIC_TOKEN_NULL = "native_generated_token_null";
    private static final String TSI_METRIC_TOKEN_RESOLUTION = "native_token_resolution_request_latency";
    private static final String TSI_METRIC_TOKEN_WEBVIEW = "native_token_availability_latency_webview";

    public static Metric newMissingToken() {
        return new Metric(TSI_METRIC_MISSING_TOKEN, null);
    }

    public static Metric newMissingStateId() {
        return new Metric(TSI_METRIC_MISSING_STATE_ID, null);
    }

    public static Metric newMissingGameSessionId() {
        return new Metric(TSI_METRIC_MISSING_GAME_SESSION_ID, null);
    }

    public static Metric newInitStarted() {
        return new Metric("native_initialization_started", null);
    }

    public static Metric newTokenAvailabilityLatencyConfig(Long l, Map<String, String> map) {
        return new Metric(TSI_METRIC_TOKEN_CONFIG, l, map);
    }

    public static Metric newTokenAvailabilityLatencyWebview(Long l, Map<String, String> map) {
        return new Metric(TSI_METRIC_TOKEN_WEBVIEW, l, map);
    }

    public static Metric newTokenResolutionRequestLatency(Long l, Map<String, String> map) {
        return new Metric(TSI_METRIC_TOKEN_RESOLUTION, l, map);
    }

    public static Metric newPrivacyResolutionRequestLatencySuccess(Long l) {
        return new Metric(TSI_METRIC_PRIVACY_RESOLUTION_SUCCESS, l);
    }

    public static Metric newPrivacyResolutionRequestLatencyFailure(Long l) {
        return new Metric(TSI_METRIC_PRIVACY_RESOLUTION_FAILURE, l);
    }

    public static Metric newPrivacyRequestLatencySuccess(Long l) {
        return new Metric(TSI_METRIC_PRIVACY_REQUEST_SUCCESS, l);
    }

    public static Metric newPrivacyRequestLatencyFailure(Long l) {
        return new Metric(TSI_METRIC_PRIVACY_REQUEST_FAILURE, l);
    }

    public static Metric newConfigRequestLatencySuccess(Long l) {
        return new Metric(TSI_METRIC_CONFIG_REQUEST_SUCCESS, l);
    }

    public static Metric newConfigRequestLatencyFailure(Long l) {
        return new Metric(TSI_METRIC_CONFIG_REQUEST_FAILURE, l);
    }

    public static Metric newEmergencySwitchOff() {
        return new Metric(TSI_METRIC_EMERGENCY_OFF, null);
    }

    public static Metric newDeviceInfoCollectionLatency(Long l) {
        return new Metric(TSI_METRIC_COLLECTION_LATENCY, l);
    }

    public static Metric newDeviceInfoCompressionLatency(Long l) {
        return new Metric(TSI_METRIC_COMPRESSION_LATENCY, l);
    }

    public static Metric newNativeGeneratedTokenAvailable(Map<String, String> map) {
        return new Metric(TSI_METRIC_TOKEN_AVAILABLE, null, map);
    }

    public static Metric newNativeGeneratedTokenNull(Map<String, String> map) {
        return new Metric(TSI_METRIC_TOKEN_NULL, null, map);
    }

    public static Metric newAsyncTokenNull(Map<String, String> map) {
        return new Metric(TSI_METRIC_TOKEN_ASYNC_NULL, null, map);
    }

    public static Metric newAsyncTokenAvailable(Map<String, String> map) {
        return new Metric(TSI_METRIC_TOKEN_ASYNC_AVAILABLE, null, map);
    }
}
