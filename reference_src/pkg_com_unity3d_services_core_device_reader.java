// Package bundle: com.unity3d.services.core.device.reader (25 classes)

// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoDataFactory
// ============================================================
package com.unity3d.services.core.device.reader;

public class DeviceInfoDataFactory {
    private final SDKMetricsSender _sdkMetricsSender;

    public DeviceInfoDataFactory(SDKMetricsSender p0) {
        new Object();
        _sdkMetricsSender = p0;
        return;
    }

    private IDeviceInfoDataContainer getPrivacyDeviceInfoData() {
        PrivacyConfigStorage.getInstance();
        new ConfigurationReader();
        GameSessionIdReader.getInstance();
        new DeviceInfoReaderPrivacyBuilder(new ConfigurationReader(..), PrivacyConfigStorage.getInstance(..), GameSessionIdReader.getInstance(..));
        DeviceInfoReaderBuilder.build();
        new DeviceInfoReaderCompressor(DeviceInfoReaderBuilder.build(..));
        return new DeviceInfoReaderCompressor(..);
    }

    private IDeviceInfoDataContainer getTokenDeviceInfoData() {
        PrivacyConfigStorage.getInstance();
        new ConfigurationReader();
        GameSessionIdReader.getInstance();
        new DeviceInfoReaderBuilder(new ConfigurationReader(..), PrivacyConfigStorage.getInstance(..), GameSessionIdReader.getInstance(..));
        new DeviceInfoReaderBuilder(..).build();
        new DeviceInfoReaderCompressor(DeviceInfoReaderBuilder.build(..));
        new DeviceInfoReaderCompressorWithMetrics(new DeviceInfoReaderCompressor(..), _sdkMetricsSender);
        return new DeviceInfoReaderCompressorWithMetrics(..);
    }

    public IDeviceInfoDataContainer getDeviceInfoData(InitRequestType p0) {
        p0.ordinal();
        if (if-eq(InitRequestType.ordinal(..), 1)) goto L_15;
        if (if-eq(InitRequestType.ordinal(..), 2)) goto L_10;
        return 0;
      L_10:
        DeviceInfoDataFactory.getPrivacyDeviceInfoData();
        return DeviceInfoDataFactory.getPrivacyDeviceInfoData(..);
      L_15:
        DeviceInfoDataFactory.getTokenDeviceInfoData();
        return DeviceInfoDataFactory.getTokenDeviceInfoData(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoReaderCompressor
// ============================================================
package com.unity3d.services.core.device.reader;

public class DeviceInfoReaderCompressor {
    public final IDeviceInfoReader _deviceInfoReader;

    public DeviceInfoReaderCompressor(IDeviceInfoReader p0) {
        new Object();
        _deviceInfoReader = p0;
        return;
    }

    public byte[] compressDeviceInfo(Map p0) {
        if (if-eqz(p0)) goto L_36;
        new JSONObject(p0);
        new JSONObject(..).toString();
        JSONObject.toString(..).length();
        new ByteArrayOutputStream(String.length(..));
        new GZIPOutputStream(new ByteArrayOutputStream(..));
        JSONObject.toString(..).getBytes();
        new GZIPOutputStream(..).write(String.getBytes(..));
        new GZIPOutputStream(..).flush();
        new GZIPOutputStream(..).close();
        new ByteArrayOutputStream(..).close();
        new ByteArrayOutputStream(..).toByteArray();
        DeviceLog.error("Error occurred while trying to compress device data.");
      L_36:
        DeviceLog.error("Invalid DeviceInfoData: Expected non null map provided by reader");
      L_3b:
        return ByteArrayOutputStream.toByteArray(..);
    }

    public byte[] getDeviceData() {
        DeviceInfoReaderCompressor.getDeviceInfo();
        DeviceInfoReaderCompressor.compressDeviceInfo(DeviceInfoReaderCompressor.getDeviceInfo(..));
        return DeviceInfoReaderCompressor.compressDeviceInfo(..);
    }

    public Map getDeviceInfo() {
        _deviceInfoReader.getDeviceInfoData();
        return IDeviceInfoReader.getDeviceInfoData(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoReaderCompressorWithMetrics
// ============================================================
package com.unity3d.services.core.device.reader;

public class DeviceInfoReaderCompressorWithMetrics {
    private final IDeviceInfoDataCompressor _deviceInfoDataCompressor;
    private long _endTime;
    private final SDKMetricsSender _sdkMetricsSender;
    private long _startTimeCompression;
    private long _startTimeInfo;

    public DeviceInfoReaderCompressorWithMetrics(IDeviceInfoDataCompressor p0, SDKMetricsSender p1) {
        new Object();
        _deviceInfoDataCompressor = p0;
        _sdkMetricsSender = p1;
        return;
    }

    private long getCompressionDuration() {
        TimeUnit.NANOSECONDS.toMillis(_endTime, v2);
        return TimeUnit.toMillis(..);
    }

    private long getDeviceInfoCollectionDuration() {
        TimeUnit.NANOSECONDS.toMillis(_startTimeCompression, v2);
        return TimeUnit.toMillis(..);
    }

    private void sendDeviceInfoMetrics() {
        DeviceInfoReaderCompressorWithMetrics.getDeviceInfoCollectionDuration();
        Long.valueOf(DeviceInfoReaderCompressorWithMetrics.getDeviceInfoCollectionDuration(..), v2);
        TSIMetric.newDeviceInfoCollectionLatency(Long.valueOf(..));
        _sdkMetricsSender.sendMetric(TSIMetric.newDeviceInfoCollectionLatency(..));
        DeviceInfoReaderCompressorWithMetrics.getCompressionDuration();
        Long.valueOf(DeviceInfoReaderCompressorWithMetrics.getCompressionDuration(..), v2);
        TSIMetric.newDeviceInfoCompressionLatency(Long.valueOf(..));
        _sdkMetricsSender.sendMetric(TSIMetric.newDeviceInfoCompressionLatency(..));
        return;
    }

    public byte[] compressDeviceInfo(Map p0) {
        System.nanoTime();
        _startTimeCompression = System.nanoTime(..);
        _deviceInfoDataCompressor.compressDeviceInfo(p0);
        System.nanoTime();
        _endTime = System.nanoTime(..);
        return IDeviceInfoDataCompressor.compressDeviceInfo(..);
    }

    public byte[] getDeviceData() {
        if (if-nez(_deviceInfoDataCompressor)) goto L_8;
        return 0;
      L_8:
        System.nanoTime();
        _startTimeInfo = System.nanoTime(..);
        DeviceInfoReaderCompressorWithMetrics.getDeviceInfo();
        DeviceInfoReaderCompressorWithMetrics.compressDeviceInfo(DeviceInfoReaderCompressorWithMetrics.getDeviceInfo(..));
        DeviceInfoReaderCompressorWithMetrics.sendDeviceInfoMetrics();
        return DeviceInfoReaderCompressorWithMetrics.compressDeviceInfo(..);
    }

    public Map getDeviceInfo() {
        _deviceInfoDataCompressor.getDeviceInfo();
        return IDeviceInfoDataCompressor.getDeviceInfo(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoReaderExtended
// ============================================================
package com.unity3d.services.core.device.reader;

public class DeviceInfoReaderExtended {
    private final IDeviceInfoReader _deviceInfoReader;

    public DeviceInfoReaderExtended(IDeviceInfoReader p0) {
        new Object();
        _deviceInfoReader = p0;
        return;
    }

    public Map getDeviceInfoData() {
        _deviceInfoReader.getDeviceInfoData();
        ClientProperties.getAppName();
        Map.put("bundleId", ClientProperties.getAppName(..));
        ClientProperties.isAppDebuggable();
        Boolean.valueOf(ClientProperties.isAppDebuggable(..));
        Map.put("encrypted", Boolean.valueOf(..));
        Device.isRooted();
        Boolean.valueOf(Device.isRooted(..));
        Map.put("rooted", Boolean.valueOf(..));
        Device.getOsVersion();
        Map.put("osVersion", Device.getOsVersion(..));
        Device.getModel();
        Map.put("deviceModel", Device.getModel(..));
        Locale.getDefault();
        Locale.getDefault(..).toString();
        Map.put("language", Locale.toString(..));
        Device.getConnectionType();
        Map.put("connectionType", Device.getConnectionType(..));
        Device.getScreenHeight();
        Integer.valueOf(Device.getScreenHeight(..));
        Map.put("screenHeight", Integer.valueOf(..));
        Device.getScreenWidth();
        Integer.valueOf(Device.getScreenWidth(..));
        Map.put("screenWidth", Integer.valueOf(..));
        Device.getManufacturer();
        Map.put("deviceMake", Device.getManufacturer(..));
        Device.getScreenDensity();
        Integer.valueOf(Device.getScreenDensity(..));
        Map.put("screenDensity", Integer.valueOf(..));
        Device.getScreenLayout();
        Integer.valueOf(Device.getScreenLayout(..));
        Map.put("screenSize", Integer.valueOf(..));
        Device.isLimitAdTrackingEnabled();
        Boolean.valueOf(Device.isLimitAdTrackingEnabled(..));
        Map.put("limitAdTracking", Boolean.valueOf(..));
        Device.getNetworkOperator();
        Map.put("networkOperator", Device.getNetworkOperator(..));
        Device.getStreamVolume(1);
        Integer.valueOf(Device.getStreamVolume(..));
        Map.put("volume", Integer.valueOf(..));
        ClientProperties.getApplicationContext();
        Context.getCacheDir();
        Device.getFreeSpace(Context.getCacheDir(..));
        Long.valueOf(Device.getFreeSpace(..), "volume");
        Map.put("deviceFreeSpace", Long.valueOf(..));
        Device.getApiLevel();
        String.valueOf(Device.getApiLevel(..));
        Map.put("apiLevel", String.valueOf(..));
        Device.getNetworkType();
        Integer.valueOf(Device.getNetworkType(..));
        Map.put("networkType", Integer.valueOf(..));
        ClientProperties.getAppVersion();
        Map.put("bundleVersion", ClientProperties.getAppVersion(..));
        TimeZone.getDefault();
        TimeZone.getDefault(..).getDisplayName(0, 0, Locale.US);
        Map.put("timeZone", TimeZone.getDisplayName(..));
        "timeZone".getMessage();
        DeviceLog.error("Could not read timeZone information: %s", 1);
      L_109:
        TimeZone.getDefault();
        System.currentTimeMillis();
        TimeZone.getDefault(..).getOffset(System.currentTimeMillis(..), AssertionError.getMessage(..));
        Integer.valueOf(TimeZone.getOffset(..));
        Map.put("timeZoneOffset", Integer.valueOf(..));
        ClientProperties.getApplicationContext();
        WebSettings.getDefaultUserAgent(ClientProperties.getApplicationContext(..));
        Map.put("webviewUa", WebSettings.getDefaultUserAgent(..));
        DeviceLog.exception("Error getting webview user agent", "webviewUa");
      L_134:
        Device.getNetworkOperatorName();
        Map.put("networkOperatorName", Device.getNetworkOperatorName(..));
        Device.isWiredHeadsetOn();
        Boolean.valueOf(Device.isWiredHeadsetOn(..));
        Map.put("wiredHeadset", Boolean.valueOf(..));
        SdkProperties.getVersionCode();
        Integer.valueOf(SdkProperties.getVersionCode(..));
        Map.put("versionCode", Integer.valueOf(..));
        Map.put("stores", "google");
        SdkProperties.getInitializationTimeEpoch();
        Long.valueOf(SdkProperties.getInitializationTimeEpoch(..), "google");
        Map.put("appStartTime", Long.valueOf(..));
        SdkProperties.getVersionName();
        Map.put("sdkVersionName", SdkProperties.getVersionName(..));
        System.currentTimeMillis();
        Long.valueOf(System.currentTimeMillis(..), SdkProperties.getVersionName(..));
        Map.put("eventTimeStamp", Long.valueOf(..));
        Device.getCPUCount();
        Long.valueOf(Device.getCPUCount(..), "eventTimeStamp");
        Map.put("cpuCount", Long.valueOf(..));
        Device.isUSBConnected();
        Boolean.valueOf(Device.isUSBConnected(..));
        Map.put("usbConnected", Boolean.valueOf(..));
        Device.getCertificateFingerprint();
        Map.put("apkDeveloperSigningCertificateHash", Device.getCertificateFingerprint(..));
        Device.getUptime();
        Long.valueOf(Device.getUptime(..), Device.getCertificateFingerprint(..));
        Map.put("deviceUpTime", Long.valueOf(..));
        Device.getElapsedRealtime();
        Long.valueOf(Device.getElapsedRealtime(..), "deviceUpTime");
        Map.put("deviceElapsedRealtime", Long.valueOf(..));
        Device.isAdbEnabled();
        Map.put("adbEnabled", Device.isAdbEnabled(..));
        Device.getFingerprint();
        Map.put("androidFingerprint", Device.getFingerprint(..));
        Device.getBatteryStatus();
        Integer.valueOf(Device.getBatteryStatus(..));
        Map.put("batteryStatus", Integer.valueOf(..));
        Device.getBatteryLevel();
        Float.valueOf(Device.getBatteryLevel(..));
        Map.put("batteryLevel", Float.valueOf(..));
        Device.getNetworkMetered();
        Boolean.valueOf(Device.getNetworkMetered(..));
        Map.put("networkMetered", Boolean.valueOf(..));
        SdkProperties.isTestMode();
        Boolean.valueOf(SdkProperties.isTestMode(..));
        Map.put("test", Boolean.valueOf(..));
        InitRequestType.TOKEN.getCallType();
        Map.put("callType", InitRequestType.getCallType(..));
        return IDeviceInfoReader.getDeviceInfoData(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoReaderFilterProvider
// ============================================================
package com.unity3d.services.core.device.reader;

public class DeviceInfoReaderFilterProvider {
    private static final String FILTER_EXCLUDE_KEY = "exclude";
    private static final String UNIFIED_CONFIG_KEY = "unifiedconfig";
    private IJsonStorageReader _storage;

    public DeviceInfoReaderFilterProvider(IJsonStorageReader p0) {
        new Object();
        _storage = p0;
        return;
    }

    private List trimWhiteSpaces(List p0) {
        new ArrayList();
        p0.iterator();
      L_9:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_1d;
        List.iterator(..).next();
        Iterator.next(..).trim();
        new ArrayList(..).add(String.trim(..));
      L_1d:
        return new ArrayList(..);
    }

    public List getFilterList() {
        new ArrayList();
        if (if-eqz(_storage)) goto L_3d;
        _storage.getData();
        if (if-eqz(IJsonStorageReader.getData(..))) goto L_3d;
        _storage.getData();
        IJsonStorageReader.getData(..).opt("unifiedconfig");
        if (if-eqz(JSONObject.opt(..))) goto L_3d;
        if (if-eqz("unifiedconfig")) goto L_3d;
        JSONObject.opt(..).opt("exclude");
        if (if-eqz("exclude")) goto L_3d;
        JSONObject.opt(..).split(",");
        Arrays.asList(String.split(..));
        DeviceInfoReaderFilterProvider.trimWhiteSpaces(Arrays.asList(..));
      L_3d:
        return DeviceInfoReaderFilterProvider.trimWhiteSpaces(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoReaderWithAuid
// ============================================================
package com.unity3d.services.core.device.reader;

public final class DeviceInfoReaderWithAuid {
    private final IDeviceInfoReader _deviceInfoReader;

    public DeviceInfoReaderWithAuid(IDeviceInfoReader p0) {
        new Object();
        _deviceInfoReader = p0;
        return;
    }

    public Map getDeviceInfoData() {
        _deviceInfoReader.getDeviceInfoData();
        Device.getAuid();
        if (if-eqz(Device.getAuid(..))) goto L_16;
        Map.put("auid", Device.getAuid(..));
      L_16:
        return IDeviceInfoReader.getDeviceInfoData(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoReaderWithBehavioralFlag
// ============================================================
package com.unity3d.services.core.device.reader;

public class DeviceInfoReaderWithBehavioralFlag {
    private final IDeviceInfoReader _deviceInfoReader;
    private final NonBehavioralFlagReader _nonBehavioralFlagReader;

    public DeviceInfoReaderWithBehavioralFlag(IDeviceInfoReader p0, NonBehavioralFlagReader p1) {
        new Object();
        _deviceInfoReader = p0;
        _nonBehavioralFlagReader = p1;
        return;
    }

    public Map getDeviceInfoData() {
        _deviceInfoReader.getDeviceInfoData();
        _nonBehavioralFlagReader.getUserNonBehavioralFlag();
        if (if-eq(NonBehavioralFlagReader.getUserNonBehavioralFlag(..), NonBehavioralFlag.UNKNOWN)) goto L_26;
        _nonBehavioralFlagReader.getUserNonBehavioralFlag();
        if (if-ne(NonBehavioralFlagReader.getUserNonBehavioralFlag(..), NonBehavioralFlag.TRUE)) goto L_1c;
      L_1c:
      L_1d:
        Boolean.valueOf(0);
        Map.put("user.nonBehavioral", Boolean.valueOf(..));
      L_26:
        return IDeviceInfoReader.getDeviceInfoData(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoReaderWithExtras
// ============================================================
package com.unity3d.services.core.device.reader;

public class DeviceInfoReaderWithExtras {
    private final IDeviceInfoReader _deviceInfoReader;
    private final Map _extras;

    public DeviceInfoReaderWithExtras(IDeviceInfoReader p0, Map p1) {
        new Object();
        _deviceInfoReader = p0;
        _extras = p1;
        return;
    }

    public Map getDeviceInfoData() {
        _deviceInfoReader.getDeviceInfoData();
        if (if-eqz(IDeviceInfoReader.getDeviceInfoData(..))) goto L_f;
        if (if-eqz(_extras)) goto L_f;
        Map.putAll(_extras);
      L_f:
        return IDeviceInfoReader.getDeviceInfoData(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoReaderWithFilter
// ============================================================
package com.unity3d.services.core.device.reader;

public class DeviceInfoReaderWithFilter {
    IDeviceInfoReader _deviceInfoReader;
    List _keysToExclude;

    public DeviceInfoReaderWithFilter(IDeviceInfoReader p0, List p1) {
        new Object();
        _deviceInfoReader = p0;
        _keysToExclude = p1;
        return;
    }

    public Map getDeviceInfoData() {
        _deviceInfoReader.getDeviceInfoData();
        if (if-eqz(_keysToExclude)) goto L_1e;
        _keysToExclude.iterator();
      L_e:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_1e;
        List.iterator(..).next();
        Map.remove(Iterator.next(..));
      L_1e:
        return IDeviceInfoReader.getDeviceInfoData(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoReaderWithLifecycle
// ============================================================
package com.unity3d.services.core.device.reader;

public class DeviceInfoReaderWithLifecycle {
    private final IDeviceInfoReader _deviceInfoReader;
    private final LifecycleCache _lifecycleCache;

    public DeviceInfoReaderWithLifecycle(IDeviceInfoReader p0, LifecycleCache p1) {
        new Object();
        _deviceInfoReader = p0;
        _lifecycleCache = p1;
        return;
    }

    public Map getDeviceInfoData() {
        _deviceInfoReader.getDeviceInfoData();
        _lifecycleCache.isAppActive();
        Boolean.valueOf(LifecycleCache.isAppActive(..));
        Map.put("appActive", Boolean.valueOf(..));
        return IDeviceInfoReader.getDeviceInfoData(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoReaderWithMetrics
// ============================================================
package com.unity3d.services.core.device.reader;

public class DeviceInfoReaderWithMetrics {
    private final IDeviceInfoReader _deviceInfoReader;
    private final SDKMetricsSender _sdkMetricsSender;

    public DeviceInfoReaderWithMetrics(IDeviceInfoReader p0, SDKMetricsSender p1) {
        new Object();
        _deviceInfoReader = p0;
        _sdkMetricsSender = p1;
        return;
    }

    private void sendMetrics(Map p0) {
        if (if-eqz(p0)) goto L_21;
        p0.get("unifiedconfig.data.gameSessionId");
        if (if-eqz("unifiedconfig.data.gameSessionId")) goto L_21;
        Map.get(..).longValue();
        if (if-nez(Map.get(..))) goto L_21;
        TSIMetric.newMissingGameSessionId();
        _sdkMetricsSender.sendMetric(TSIMetric.newMissingGameSessionId(..));
      L_21:
        return;
    }

    public Map getDeviceInfoData() {
        if (if-nez(_deviceInfoReader)) goto L_6;
        return 0;
      L_6:
        0.getDeviceInfoData();
        DeviceInfoReaderWithMetrics.sendMetrics(IDeviceInfoReader.getDeviceInfoData(..));
        return IDeviceInfoReader.getDeviceInfoData(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoReaderWithPrivacy
// ============================================================
package com.unity3d.services.core.device.reader;

public class DeviceInfoReaderWithPrivacy {
    private final IDeviceInfoReader _deviceInfoReader;
    private final PiiDataProvider _piiDataProvider;
    private final PiiTrackingStatusReader _piiTrackingStatusReader;
    private final PrivacyConfigStorage _privacyConfigStorage;

    public DeviceInfoReaderWithPrivacy(IDeviceInfoReader p0, PrivacyConfigStorage p1, PiiDataProvider p2, PiiTrackingStatusReader p3) {
        new Object();
        _deviceInfoReader = p0;
        _privacyConfigStorage = p1;
        _piiDataProvider = p2;
        _piiTrackingStatusReader = p3;
        return;
    }

    private Map getPiiAttributesFromDevice() {
        new HashMap();
        _piiDataProvider.getAdvertisingTrackingId();
        if (if-eqz(PiiDataProvider.getAdvertisingTrackingId(..))) goto L_12;
        new HashMap(..).put("unifiedconfig.pii.advertisingTrackingId", PiiDataProvider.getAdvertisingTrackingId(..));
      L_12:
        return new HashMap(..);
    }

    public Map getDeviceInfoData() {
        _deviceInfoReader.getDeviceInfoData();
        if (if-eqz(_privacyConfigStorage)) goto L_3e;
        _privacyConfigStorage.getPrivacyConfig();
        if (if-eqz(PrivacyConfigStorage.getPrivacyConfig(..))) goto L_3e;
        _privacyConfigStorage.getPrivacyConfig();
        PrivacyConfig.allowedToSendPii();
        if (if-eqz(PrivacyConfig.allowedToSendPii(..))) goto L_23;
        DeviceInfoReaderWithPrivacy.getPiiAttributesFromDevice();
        Map.putAll(DeviceInfoReaderWithPrivacy.getPiiAttributesFromDevice(..));
      L_23:
        _privacyConfigStorage.getPrivacyConfig();
        PrivacyConfig.shouldSendNonBehavioral();
        if (if-eqz(PrivacyConfig.shouldSendNonBehavioral(..))) goto L_3e;
        _piiTrackingStatusReader.getUserNonBehavioralFlag();
        Boolean.valueOf(PiiTrackingStatusReader.getUserNonBehavioralFlag(..));
        Map.put("user.nonBehavioral", Boolean.valueOf(..));
      L_3e:
        return IDeviceInfoReader.getDeviceInfoData(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoReaderWithRequestType
// ============================================================
package com.unity3d.services.core.device.reader;

public class DeviceInfoReaderWithRequestType {
    private final IDeviceInfoReader _deviceInfoReader;
    private final InitRequestType _initRequestType;

    public DeviceInfoReaderWithRequestType(IDeviceInfoReader p0, InitRequestType p1) {
        new Object();
        _deviceInfoReader = p0;
        _initRequestType = p1;
        return;
    }

    public Map getDeviceInfoData() {
        _deviceInfoReader.getDeviceInfoData();
        if (if-eqz(_initRequestType)) goto L_17;
        _initRequestType.toString();
        InitRequestType.toString(..).toLowerCase();
        Map.put("callType", String.toLowerCase(..));
      L_17:
        return IDeviceInfoReader.getDeviceInfoData(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoReaderWithSessionId
// ============================================================
package com.unity3d.services.core.device.reader;

public class DeviceInfoReaderWithSessionId {
    private final IDeviceInfoReader _deviceInfoReader;
    private final Session _session;

    public DeviceInfoReaderWithSessionId(IDeviceInfoReader p0, Session p1) {
        new Object();
        _deviceInfoReader = p0;
        _session = p1;
        return;
    }

    public Map getDeviceInfoData() {
        _deviceInfoReader.getDeviceInfoData();
        _session.getId();
        Map.put("sessionId", Session.getId(..));
        return IDeviceInfoReader.getDeviceInfoData(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoReaderWithStorageInfo
// ============================================================
package com.unity3d.services.core.device.reader;

public class DeviceInfoReaderWithStorageInfo {
    private final IDeviceInfoReader _deviceInfoReader;
    private final JsonFlattenerRules _jsonFlattenerRules;
    private final List _storageReaders;

    public DeviceInfoReaderWithStorageInfo(IDeviceInfoReader p0, JsonFlattenerRules p1, IJsonStorageReader[] p2) {
        new Object();
        _deviceInfoReader = p0;
        _jsonFlattenerRules = p1;
        Arrays.asList(p2);
        _storageReaders = Arrays.asList(..);
        return;
    }

    public Map getDeviceInfoData() {
        _deviceInfoReader.getDeviceInfoData();
        if (if-eqz(IDeviceInfoReader.getDeviceInfoData(..))) goto L_24;
        new JsonStorageAggregator(_storageReaders);
        new JsonStorageAggregator(..).getData();
        new JsonFlattener(JsonStorageAggregator.getData(..));
        new JsonFlattener(..).flattenJson(".", _jsonFlattenerRules);
        Utilities.combineJsonIntoMap(IDeviceInfoReader.getDeviceInfoData(..), JsonFlattener.flattenJson(..));
      L_24:
        return Utilities.combineJsonIntoMap(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.GameSessionIdReader
// ============================================================
package com.unity3d.services.core.device.reader;

public class GameSessionIdReader {
    private static final int GAME_SESSION_ID_LENGTH = 12;
    private static GameSessionIdReader _instance;
    private Long gameSessionId;

    private GameSessionIdReader() {
        new Object();
        return;
    }

    private void generate() {
        UUID.randomUUID();
        new StringBuilder();
        UUID.randomUUID(..).getMostSignificantBits();
        Long.toString(UUID.getMostSignificantBits(..), v3);
        new StringBuilder(..).append(Long.toString(..));
        UUID.randomUUID(..).getLeastSignificantBits();
        Long.toString(UUID.getLeastSignificantBits(..), v3);
        new StringBuilder(..).append(Long.toString(..));
        new StringBuilder(..).toString();
        StringBuilder.toString(..).replace("-", "");
        String.replace(..).substring(0, 12);
        Long.valueOf(String.substring(..));
        gameSessionId = Long.valueOf(..);
        return;
    }

    public static GameSessionIdReader getInstance() {
        if (if-nez(GameSessionIdReader._instance)) goto L_17;
        if (if-nez(GameSessionIdReader._instance)) goto L_12;
        new GameSessionIdReader();
        _instance = new GameSessionIdReader(..);
      L_12:
        throw new GameSessionIdReader(..);
      L_17:
        return GameSessionIdReader._instance;
    }

    private void store() {
        ClientProperties.getApplicationContext();
        StorageManager.init(ClientProperties.getApplicationContext(..));
        if (if-eqz(StorageManager.init(..))) goto L_1c;
        StorageManager.getStorage(StorageManager$StorageType.PRIVATE);
        if (if-eqz(StorageManager.getStorage(..))) goto L_1c;
        StorageManager.getStorage(..).set("unifiedconfig.data.gameSessionId", gameSessionId);
        StorageManager.getStorage(..).writeStorage();
      L_1c:
        return;
    }

    public Long getGameSessionId() {
        if (if-nez(gameSessionId)) goto L_8;
        GameSessionIdReader.generate();
      L_8:
        return gameSessionId;
        throw gameSessionId;
    }

    public Long getGameSessionIdAndStore() {
        if (if-nez(gameSessionId)) goto L_b;
        GameSessionIdReader.generate();
        GameSessionIdReader.store();
      L_b:
        return gameSessionId;
        throw gameSessionId;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.HdrInfoReader
// ============================================================
package com.unity3d.services.core.device.reader;

public class HdrInfoReader {
    private static final AtomicBoolean _hdrMetricsCaptured;
    private static HdrInfoReader _instance;
    private final SDKMetricsSender _sdkMetricsSender;

    static <clinit>() {
        new AtomicBoolean(0);
        _hdrMetricsCaptured = new AtomicBoolean(..);
        return;
    }

    private HdrInfoReader() {
        new Object();
        Utilities.getService(SDKMetricsSender.class);
        _sdkMetricsSender = Utilities.getService(..);
        return;
    }

    public static HdrInfoReader getInstance() {
        if (if-nez(HdrInfoReader._instance)) goto L_17;
        if (if-nez(HdrInfoReader._instance)) goto L_12;
        new HdrInfoReader();
        _instance = new HdrInfoReader(..);
      L_12:
        throw new HdrInfoReader(..);
      L_17:
        return HdrInfoReader._instance;
    }

    public void captureHDRCapabilityMetrics(Activity p0, ExperimentsReader p1) {
        if (if-nez(p0)) goto L_3;
        return;
      L_3:
        p1.getCurrentlyActiveExperiments();
        IExperiments.isCaptureHDRCapabilitiesEnabled();
        if (if-nez(IExperiments.isCaptureHDRCapabilitiesEnabled(..))) goto L_e;
        return;
      L_e:
        HdrInfoReader._hdrMetricsCaptured.compareAndSet(0, 1);
        if (if-eqz(AtomicBoolean.compareAndSet(..))) goto L_12e;
        new ArrayList(5);
        if (if-lt(Build$VERSION.SDK_INT, 24)) goto L_b2;
        p0.getSystemService("window");
        Activity.getSystemService(..).getDefaultDisplay();
        WindowManager.getDefaultDisplay(..).getHdrCapabilities();
        Display.getHdrCapabilities(..).getSupportedHdrTypes();
      L_3e:
        if (if-ge(0, v4)) goto L_58;
        if (if-eq(v10, 1)) goto L_54;
        if (if-eq(v10, 2)) goto L_52;
        if (if-eq(v10, 3)) goto L_50;
        if (if-eq(v10, 4)) goto L_4e;
      L_4e:
      L_50:
      L_52:
      L_54:
      L_55:
      L_58:
        Display.getHdrCapabilities(..).getDesiredMaxAverageLuminance();
        Math.round(Display$HdrCapabilities.getDesiredMaxAverageLuminance(..));
        Display.getHdrCapabilities(..).getDesiredMaxLuminance();
        Math.round(Display$HdrCapabilities.getDesiredMaxLuminance(..));
        Display.getHdrCapabilities(..).getDesiredMinLuminance();
        Math.round(Display$HdrCapabilities.getDesiredMinLuminance(..));
        Long.valueOf(Display$HdrCapabilities.getSupportedHdrTypes(..), v4);
        new Metric("native_device_hdr_lum_max_average", Long.valueOf(..));
        new ArrayList(..).add(new Metric(..));
        Long.valueOf(v10, 4);
        new Metric("native_device_hdr_lum_max", Long.valueOf(..));
        new ArrayList(..).add(new Metric(..));
        Long.valueOf(Math.round(..), Display.getHdrCapabilities(..));
        new Metric("native_device_hdr_lum_min", Long.valueOf(..));
        new ArrayList(..).add(new Metric(..));
        if (if-lt(Build$VERSION.SDK_INT, 26)) goto L_af;
        p0.getResources();
        Activity.getResources(..).getConfiguration();
        Resources.getConfiguration(..).isScreenHdr();
      L_af:
      L_b2:
      L_b6:
        if (if-eqz(1)) goto L_c3;
        new Metric("native_device_hdr_dolby_vision_success");
        new ArrayList(..).add(new Metric(..));
      L_c3:
        new Metric("native_device_hdr_dolby_vision_failure");
        new ArrayList(..).add(new Metric(..));
      L_cd:
        if (if-eqz(1)) goto L_da;
        new Metric("native_device_hdr_hdr10_success");
        new ArrayList(..).add(new Metric(..));
      L_da:
        new Metric("native_device_hdr_hdr10_failure");
        new ArrayList(..).add(new Metric(..));
      L_e4:
        if (if-eqz(1)) goto L_f1;
        new Metric("native_device_hdr_hdr10_plus_success");
        new ArrayList(..).add(new Metric(..));
      L_f1:
        new Metric("native_device_hdr_hdr10_plus_failure");
        new ArrayList(..).add(new Metric(..));
      L_fb:
        if (if-eqz(1)) goto L_108;
        new Metric("native_device_hdr_hlg_success");
        new ArrayList(..).add(new Metric(..));
      L_108:
        new Metric("native_device_hdr_hlg_failure");
        new ArrayList(..).add(new Metric(..));
      L_112:
        if (if-eqz(1)) goto L_11f;
        new Metric("native_device_hdr_screen_hdr_success");
        new ArrayList(..).add(new Metric(..));
      L_11f:
        new Metric("native_device_hdr_screen_hdr_failure");
        new ArrayList(..).add(new Metric(..));
      L_129:
        _sdkMetricsSender.sendMetrics(new ArrayList(..));
      L_12e:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.IDeviceInfoDataCompressor
// ============================================================
package com.unity3d.services.core.device.reader;

public abstract class IDeviceInfoDataCompressor {
    public abstract byte[] compressDeviceInfo(Map p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.IDeviceInfoDataContainer
// ============================================================
package com.unity3d.services.core.device.reader;

public abstract class IDeviceInfoDataContainer {
    public abstract byte[] getDeviceData() {
        // native or abstract
    }

    public abstract Map getDeviceInfo() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.IDeviceInfoReader
// ============================================================
package com.unity3d.services.core.device.reader;

public abstract class IDeviceInfoReader {
    public abstract Map getDeviceInfoData() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.IGameSessionIdReader
// ============================================================
package com.unity3d.services.core.device.reader;

public abstract class IGameSessionIdReader {
    public abstract Long getGameSessionId() {
        // native or abstract
    }

    public abstract Long getGameSessionIdAndStore() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.IHdrInfoReader
// ============================================================
package com.unity3d.services.core.device.reader;

public abstract class IHdrInfoReader {
    public abstract void captureHDRCapabilityMetrics(Activity p0, ExperimentsReader p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.JsonStorageKeyNames
// ============================================================
package com.unity3d.services.core.device.reader;

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

    public JsonStorageKeyNames() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.MinimalDeviceInfoReader
// ============================================================
package com.unity3d.services.core.device.reader;

public class MinimalDeviceInfoReader {
    final IGameSessionIdReader _gameSessionIdReader;

    public MinimalDeviceInfoReader(IGameSessionIdReader p0) {
        new Object();
        _gameSessionIdReader = p0;
        return;
    }

    public Map getDeviceInfoData() {
        new HashMap();
        new HashMap(..).put("platform", "android");
        SdkProperties.getVersionCode();
        Integer.valueOf(SdkProperties.getVersionCode(..));
        new HashMap(..).put("sdkVersion", Integer.valueOf(..));
        SdkProperties.getVersionName();
        new HashMap(..).put("sdkVersionName", SdkProperties.getVersionName(..));
        Device.getIdfi();
        new HashMap(..).put("idfi", Device.getIdfi(..));
        _gameSessionIdReader.getGameSessionIdAndStore();
        new HashMap(..).put("unifiedconfig.data.gameSessionId", IGameSessionIdReader.getGameSessionIdAndStore(..));
        System.currentTimeMillis();
        Long.valueOf(System.currentTimeMillis(..), "unifiedconfig.data.gameSessionId");
        new HashMap(..).put("ts", Long.valueOf(..));
        ClientProperties.getGameId();
        new HashMap(..).put("gameId", ClientProperties.getGameId(..));
        return new HashMap(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.DeviceInfoDataFactory$1
// ============================================================
package com.unity3d.services.core.device.reader;

class DeviceInfoDataFactory$1 {
    static final int[] $SwitchMap$com$unity3d$services$core$configuration$InitRequestType;

    static <clinit>() {
        InitRequestType.values();
        $SwitchMap$com$unity3d$services$core$configuration$InitRequestType = InitRequestType.values(..);
        InitRequestType.TOKEN.ordinal();
        InitRequestType.PRIVACY.ordinal();
        return;
    }

}

