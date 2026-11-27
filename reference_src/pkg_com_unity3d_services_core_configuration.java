// Package bundle: com.unity3d.services.core.configuration (64 classes)

// ============================================================
// CLASS: com.unity3d.services.core.configuration.AdsSdkInitializer
// ============================================================
package com.unity3d.services.core.configuration;

public final class AdsSdkInitializer {
    public AdsSdkInitializer() {
        new Object();
        return;
    }

    public Object create(Context p0) {
        AdsSdkInitializer.create(p0);
        return Unit.INSTANCE;
    }

    public void create(Context p0) {
        p0.getApplicationContext();
        ClientProperties.setApplicationContext(Context.getApplicationContext(..));
        System.currentTimeMillis();
        SdkProperties.setAppInitializationTimeSinceEpoch(System.currentTimeMillis(..), v1);
        return;
    }

    public List dependencies() {
        CollectionsKt.emptyList();
        return CollectionsKt.emptyList(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.Configuration
// ============================================================
package com.unity3d.services.core.configuration;

public class Configuration {
    private String _configUrl;
    private ConfigurationRequestFactory _configurationRequestFactory;
    private int _connectedEventThresholdInMs;
    private boolean _delayWebViewUpdate;
    private ExperimentsReader _experimentReader;
    private String _filteredJsonString;
    private int _loadTimeout;
    private int _maxRetries;
    private int _maximumConnectedEvents;
    private double _metricSampleRate;
    private Boolean _metricsEnabled;
    private String _metricsUrl;
    private final Class[] _moduleConfigurationList;
    private Map _moduleConfigurations;
    private long _networkErrorTimeout;
    private int _privacyRequestWaitTimeout;
    private JSONObject _rawJsonData;
    private int _resetWebAppTimeout;
    private long _retryDelay;
    private double _retryScalingFactor;
    private String _sTkn;
    private String _scarBiddingUrl;
    private String _sdkVersion;
    private int _showTimeout;
    private String _src;
    private String _stateId;
    private int _tokenTimeout;
    private String _unifiedAuctionToken;
    private Class[] _webAppApiClassList;
    private long _webViewAppCreateTimeout;
    private int _webViewBridgeTimeout;
    private String _webViewData;
    private String _webViewHash;
    private String _webViewUrl;
    private String _webViewVersion;

    public Configuration() {
        new Object();
        _moduleConfigurationList = 5;
        new ExperimentsReader();
        _experimentReader = new ExperimentsReader(..);
        new JSONObject();
        new Object(..).setOptionalFields(new JSONObject(..), 0);
        return;
    }

    public Configuration(String p0) {
        new Experiments();
        new Configuration(p0, new Experiments(..));
        return;
    }

    public Configuration(String p0, ExperimentsReader p1) {
        p1.getCurrentlyActiveExperiments();
        new Configuration(p0, ExperimentsReader.getCurrentlyActiveExperiments(..));
        _experimentReader = p1;
        return;
    }

    public Configuration(String p0, IExperiments p1) {
        new Configuration();
        _configUrl = p0;
        new ConfigurationRequestFactory(new Configuration(..));
        _configurationRequestFactory = new ConfigurationRequestFactory(..);
        _experimentReader.updateLocalExperiments(p1);
        return;
    }

    public Configuration(JSONObject p0) {
        new Object();
        _moduleConfigurationList = 5;
        new ExperimentsReader();
        _experimentReader = new ExperimentsReader(..);
        new Object(..).handleConfigurationData(p0, 0);
        return;
    }

    private void createWebAppApiClassList() {
        new ArrayList();
        Configuration.getModuleConfigurationList();
      L_b:
        if (if-ge(0, v2)) goto L_29;
        Configuration.getModuleConfiguration(v4);
        if (if-eqz(Configuration.getModuleConfiguration(..))) goto L_26;
        IModuleConfiguration.getWebAppApiClassList();
        if (if-eqz(IModuleConfiguration.getWebAppApiClassList(..))) goto L_26;
        IModuleConfiguration.getWebAppApiClassList();
        Arrays.asList(IModuleConfiguration.getWebAppApiClassList(..));
        new ArrayList(..).addAll(Arrays.asList(..));
      L_26:
      L_29:
        new ArrayList(..).size();
        new ArrayList(..).toArray(List.size(..));
        _webAppApiClassList = List.toArray(..);
        return;
    }

    private JSONObject getFilteredConfigJson(JSONObject p0) {
        new JSONObject();
        p0.keys();
      L_9:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_3d;
        JSONObject.keys(..).next();
        p0.opt(Iterator.next(..));
        Iterator.next(..).equalsIgnoreCase("tkn");
        if (if-nez(String.equalsIgnoreCase(..))) goto L_9;
        Iterator.next(..).equalsIgnoreCase("sid");
        if (if-nez(String.equalsIgnoreCase(..))) goto L_9;
        Iterator.next(..).equalsIgnoreCase("srr");
        if (if-nez(String.equalsIgnoreCase(..))) goto L_9;
        Iterator.next(..).equalsIgnoreCase("sTkn");
        if (if-nez(String.equalsIgnoreCase(..))) goto L_9;
        new JSONObject(..).put(Iterator.next(..), JSONObject.opt(..));
      L_3d:
        return new JSONObject(..);
    }

    private void setOptionalFields(JSONObject p0, boolean p1) {
        p0.optString("version", 0);
        _webViewVersion = JSONObject.optString(..);
        p0.optBoolean("dwu", 0);
        _delayWebViewUpdate = JSONObject.optBoolean(..);
        p0.optInt("rwt", 10000);
        _resetWebAppTimeout = JSONObject.optInt(..);
        p0.optInt("mr", 6);
        _maxRetries = JSONObject.optInt(..);
        p0.optLong("rd", 5000L, v5);
        _retryDelay = JSONObject.optLong(..);
        p0.optDouble("rcf", Color(0x40000000), v5);
        _retryScalingFactor = JSONObject.optDouble(..);
        p0.optInt("cet", 10000);
        _connectedEventThresholdInMs = JSONObject.optInt(..);
        p0.optInt("mce", 500);
        _maximumConnectedEvents = JSONObject.optInt(..);
        p0.optLong("net", 60000L, v5);
        _networkErrorTimeout = JSONObject.optLong(..);
        p0.optString("sdkv", "");
        _sdkVersion = JSONObject.optString(..);
        p0.optInt("sto", 10000);
        _showTimeout = JSONObject.optInt(..);
        p0.optInt("lto", 30000);
        _loadTimeout = JSONObject.optInt(..);
        p0.optInt("wto", 5000);
        _webViewBridgeTimeout = JSONObject.optInt(..);
        p0.optString("murl", "");
        _metricsUrl = JSONObject.optString(..);
        p0.optDouble("msr", Color(0x40590000), v7);
        _metricSampleRate = JSONObject.optDouble(..);
        p0.optLong("wct", 60000L, v5);
        _webViewAppCreateTimeout = JSONObject.optLong(..);
        p0.optInt("tto", 5000);
        _tokenTimeout = JSONObject.optInt(..);
        p0.optInt("prwto", 3000);
        _privacyRequestWaitTimeout = JSONObject.optInt(..);
        p0.optString("src", 0);
        _src = JSONObject.optString(..);
        p0.optString("scurl", "https://scar.unityads.unity3d.com/v1/capture-scar-signals");
        _scarBiddingUrl = JSONObject.optString(..);
        new Random();
        new Random(..).nextInt(99);
        if (if-ltz(_metricSampleRate)) goto L_cf;
      L_cf:
        Boolean.valueOf(1);
        _metricsEnabled = Boolean.valueOf(..);
        p0.has("expo");
        if (if-eqz(JSONObject.has(..))) goto L_e7;
        p0.optJSONObject("expo");
        new ExperimentObjects(JSONObject.optJSONObject(..));
      L_e7:
        JSONObject.optJSONObject(..).optJSONObject("exp");
        new Experiments(JSONObject.optJSONObject(..));
      L_f2:
        if (if-eqz(p1)) goto L_fa;
        _experimentReader.updateRemoteExperiments(new Experiments(..));
      L_fa:
        _experimentReader.updateLocalExperiments(new Experiments(..));
      L_ff:
        return;
    }

    public Boolean areMetricsEnabledForCurrentSession() {
        return _metricsEnabled;
    }

    public void deleteFromDisk() {
        SdkProperties.getLocalConfigurationFilepath();
        new File(SdkProperties.getLocalConfigurationFilepath(..));
        new File(..).exists();
        if (if-eqz(File.exists(..))) goto L_12;
        new File(..).delete();
      L_12:
        return;
    }

    public String getConfigUrl() {
        return _configUrl;
    }

    public int getConnectedEventThreshold() {
        return _connectedEventThresholdInMs;
    }

    public boolean getDelayWebViewUpdate() {
        return _delayWebViewUpdate;
    }

    public IExperiments getExperiments() {
        _experimentReader.getCurrentlyActiveExperiments();
        return ExperimentsReader.getCurrentlyActiveExperiments(..);
    }

    public ExperimentsReader getExperimentsReader() {
        return _experimentReader;
    }

    public String getFilteredJsonString() {
        return _filteredJsonString;
    }

    public int getLoadTimeout() {
        return _loadTimeout;
    }

    public int getMaxRetries() {
        return _maxRetries;
    }

    public int getMaximumConnectedEvents() {
        return _maximumConnectedEvents;
    }

    public double getMetricSampleRate() {
        return _metricSampleRate;
    }

    public String getMetricsUrl() {
        return _metricsUrl;
    }

    public IModuleConfiguration getModuleConfiguration(Class p0) {
        if (if-eqz(_moduleConfigurations)) goto L_13;
        _moduleConfigurations.containsKey(p0);
        if (if-eqz(Map.containsKey(..))) goto L_13;
        _moduleConfigurations.get(p0);
        return Map.get(..);
      L_13:
        Map.get(..).newInstance();
        if (if-eqz(Class.newInstance(..))) goto L_2f;
        if (if-nez(_moduleConfigurations)) goto L_2e;
        new HashMap();
        _moduleConfigurations = new HashMap(..);
        Map.get(..).getName();
        new HashMap(..).put(Class.getName(..), Class.newInstance(..));
      L_2e:
        return Class.newInstance(..);
      L_2f:
        return 0;
    }

    public Class[] getModuleConfigurationList() {
        return _moduleConfigurationList;
    }

    public long getNetworkErrorTimeout() {
        return _networkErrorTimeout;
    }

    public int getPrivacyRequestWaitTimeout() {
        return _privacyRequestWaitTimeout;
    }

    public JSONObject getRawConfigData() {
        return _rawJsonData;
    }

    public int getResetWebappTimeout() {
        return _resetWebAppTimeout;
    }

    public long getRetryDelay() {
        return _retryDelay;
    }

    public double getRetryScalingFactor() {
        return _retryScalingFactor;
    }

    public String getScarBiddingUrl() {
        return _scarBiddingUrl;
    }

    public String getSdkVersion() {
        return _sdkVersion;
    }

    public String getSessionToken() {
        return _sTkn;
    }

    public int getShowTimeout() {
        return _showTimeout;
    }

    public String getSrc() {
        if (if-eqz(_src)) goto L_5;
      L_5:
      L_7:
        return "";
    }

    public String getStateId() {
        if (if-eqz(_stateId)) goto L_5;
      L_5:
      L_7:
        return "";
    }

    public int getTokenTimeout() {
        return _tokenTimeout;
    }

    public String getUnifiedAuctionToken() {
        return _unifiedAuctionToken;
    }

    public Class[] getWebAppApiClassList() {
        if (if-nez(_webAppApiClassList)) goto L_7;
        Configuration.createWebAppApiClassList();
      L_7:
        return _webAppApiClassList;
    }

    public long getWebViewAppCreateTimeout() {
        return _webViewAppCreateTimeout;
    }

    public int getWebViewBridgeTimeout() {
        return _webViewBridgeTimeout;
    }

    public String getWebViewData() {
        return _webViewData;
    }

    public String getWebViewHash() {
        return _webViewHash;
    }

    public String getWebViewUrl() {
        return _webViewUrl;
    }

    public String getWebViewVersion() {
        return _webViewVersion;
    }

    protected void handleConfigurationData(JSONObject p0, boolean p1) {
        p0.isNull("url");
        if (if-nez(JSONObject.isNull(..))) goto L_10;
        p0.getString("url");
      L_10:
      L_11:
        TextUtils.isEmpty(0);
        if (if-nez(TextUtils.isEmpty(..))) goto L_68;
        _webViewUrl = 0;
        p0.isNull("hash");
        if (if-nez(JSONObject.isNull(..))) goto L_24;
        p0.getString("hash");
      L_24:
      L_25:
        _webViewHash = 0;
        _webViewHash = 0;
      L_2a:
        p0.isNull("tkn");
        if (if-nez(JSONObject.isNull(..))) goto L_37;
        p0.optString("tkn");
      L_37:
      L_38:
        _unifiedAuctionToken = 0;
        p0.isNull("sid");
        if (if-nez(JSONObject.isNull(..))) goto L_47;
        p0.optString("sid");
      L_47:
      L_48:
        _stateId = 0;
        p0.isNull("sTkn");
        if (if-nez(JSONObject.isNull(..))) goto L_56;
        p0.optString("sTkn");
      L_56:
        _sTkn = JSONObject.optString(..);
        Configuration.setOptionalFields(p0, p1);
        Configuration.getFilteredConfigJson(p0);
        JSONObject.toString();
        _filteredJsonString = JSONObject.toString(..);
        _rawJsonData = p0;
        return;
      L_68:
        new MalformedURLException("WebView URL is null or empty");
        throw new MalformedURLException(..);
    }

    public void makeRequest() {
        if (if-eqz(_configUrl)) goto L_47;
        _configurationRequestFactory.getWebRequest();
        WebRequestToHttpRequestKt.toHttpRequest(ConfigurationRequestFactory.getWebRequest(..));
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.didConfigRequestStart();
        Utilities.getService(HttpClient.class);
        Utilities.getService(..).executeBlocking(WebRequestToHttpRequestKt.toHttpRequest(..));
        HttpClient.executeBlocking(..).getBody();
        HttpResponse.getBody(..).toString();
        new JSONObject(Object.toString(..));
        Configuration.handleConfigurationData(new JSONObject(..), 1);
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.didConfigRequestEnd(1);
        Configuration.saveToDisk();
        return;
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.didConfigRequestEnd(0);
        throw 1;
      L_47:
        new MalformedURLException("Base URL is null");
        throw new MalformedURLException(..);
    }

    public void saveToDisk() {
        SdkProperties.getLocalConfigurationFilepath();
        new File(SdkProperties.getLocalConfigurationFilepath(..));
        Configuration.getFilteredJsonString();
        Utilities.writeFile(new File(..), Configuration.getFilteredJsonString(..));
        return;
    }

    public void setWebViewData(String p0) {
        _webViewData = p0;
        return;
    }

    public void setWebViewHash(String p0) {
        _webViewHash = p0;
        return;
    }

    public void setWebViewUrl(String p0) {
        _webViewUrl = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.ConfigurationFailure
// ============================================================
package com.unity3d.services.core.configuration;

public final class ConfigurationFailure extends Enum {
    private static final ConfigurationFailure[] $VALUES;
    public static final ConfigurationFailure INVALID_DATA;
    public static final ConfigurationFailure NETWORK_FAILURE;

    private static ConfigurationFailure[] $values() {
        return 2;
    }

    static <clinit>() {
        new ConfigurationFailure("NETWORK_FAILURE", 0);
        NETWORK_FAILURE = new ConfigurationFailure(..);
        new ConfigurationFailure("INVALID_DATA", 1);
        INVALID_DATA = new ConfigurationFailure(..);
        ConfigurationFailure.$values();
        $VALUES = ConfigurationFailure.$values(..);
        return;
    }

    private ConfigurationFailure(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static ConfigurationFailure valueOf(String p0) {
        Enum.valueOf(ConfigurationFailure.class, p0);
        return Enum.valueOf(..);
    }

    public static ConfigurationFailure[] values() {
        ConfigurationFailure.$VALUES.clone();
        return ConfigurationFailure[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.ConfigurationLoader
// ============================================================
package com.unity3d.services.core.configuration;

public class ConfigurationLoader {
    private final ConfigurationRequestFactory _configurationRequestFactory;
    private final HttpClient _httpClient;
    private final Configuration _localConfiguration;
    private final SDKMetricsSender _sdkMetricsSender;

    public ConfigurationLoader(ConfigurationRequestFactory p0, SDKMetricsSender p1, HttpClient p2) {
        new Object();
        p0.getConfiguration();
        _localConfiguration = ConfigurationRequestFactory.getConfiguration(..);
        _configurationRequestFactory = p0;
        _sdkMetricsSender = p1;
        _httpClient = p2;
        return;
    }

    private void sendConfigMetrics(String p0, String p1) {
        if (if-eqz(p0)) goto L_8;
        p0.isEmpty();
        if (if-eqz(String.isEmpty(..))) goto L_11;
      L_8:
        TSIMetric.newMissingToken();
        _sdkMetricsSender.sendMetric(TSIMetric.newMissingToken(..));
      L_11:
        if (if-eqz(p1)) goto L_19;
        p1.isEmpty();
        if (if-eqz(String.isEmpty(..))) goto L_22;
      L_19:
        TSIMetric.newMissingStateId();
        _sdkMetricsSender.sendMetric(TSIMetric.newMissingStateId(..));
      L_22:
        return;
    }

    public Configuration getLocalConfiguration() {
        return _localConfiguration;
    }

    public void loadConfiguration(IConfigurationLoaderListener p0) {
        _configurationRequestFactory.getWebRequest();
        WebRequestToHttpRequestKt.toHttpRequest(ConfigurationRequestFactory.getWebRequest(..));
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.didConfigRequestStart();
        _httpClient.executeBlocking(WebRequestToHttpRequestKt.toHttpRequest(..));
        HttpClient.executeBlocking(..).getBody();
        HttpResponse.getBody(..).toString();
        HttpClient.executeBlocking(..).getStatusCode();
        if (if-ne(HttpResponse.getStatusCode(..), 2)) goto L_2b;
      L_2b:
      L_2c:
        if (if-nez(0)) goto L_34;
        p0.onError("Non 2xx HTTP status received from ads configuration request.");
        return;
      L_34:
        new JSONObject(Object.toString(..));
        _localConfiguration.handleConfigurationData(new JSONObject(..), 1);
        _localConfiguration.getUnifiedAuctionToken();
        _localConfiguration.getStateId();
        ConfigurationLoader.sendConfigMetrics(Configuration.getUnifiedAuctionToken(..), Configuration.getStateId(..));
        p0.onSuccess(_localConfiguration);
        return;
        p0.onError("Could not create web request");
        return;
        new StringBuilder("Could not create web request: ");
        new StringBuilder(..).append("Could not create web request");
        new StringBuilder(..).toString();
        p0.onError(StringBuilder.toString(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.ConfigurationReader
// ============================================================
package com.unity3d.services.core.configuration;

public class ConfigurationReader {
    private Configuration _localConfiguration;

    public ConfigurationReader() {
        new Object();
        return;
    }

    private Configuration getLocalConfiguration() {
        if (if-eqz(_localConfiguration)) goto L_5;
        return _localConfiguration;
      L_5:
        SdkProperties.getLocalConfigurationFilepath();
        new File(SdkProperties.getLocalConfigurationFilepath(..));
        new File(..).exists();
        if (if-eqz(File.exists(..))) goto L_32;
        Utilities.readFileBytes(new File(..));
        new String(Utilities.readFileBytes(..));
        new JSONObject(new String(..));
        new Configuration(new JSONObject(..));
        _localConfiguration = new Configuration(..);
        DeviceLog.debug("Unable to read configuration from storage");
        _localConfiguration = 0;
      L_32:
        return _localConfiguration;
    }

    private Configuration getRemoteConfiguration() {
        WebViewApp.getCurrentApp();
        if (if-nez(WebViewApp.getCurrentApp(..))) goto L_8;
        return 0;
      L_8:
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getConfiguration();
        return WebViewApp.getConfiguration(..);
    }

    public Configuration getCurrentConfiguration() {
        ConfigurationReader.getRemoteConfiguration();
        if (if-eqz(ConfigurationReader.getRemoteConfiguration(..))) goto L_b;
        ConfigurationReader.getRemoteConfiguration();
        return ConfigurationReader.getRemoteConfiguration(..);
      L_b:
        ConfigurationReader.getLocalConfiguration();
        if (if-eqz(ConfigurationReader.getLocalConfiguration(..))) goto L_12;
      L_12:
        new Configuration();
      L_17:
        return new Configuration(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.ConfigurationRequestFactory
// ============================================================
package com.unity3d.services.core.configuration;

public class ConfigurationRequestFactory {
    private final Configuration _configuration;
    private final IDeviceInfoDataContainer _deviceInfoDataContainer;

    public ConfigurationRequestFactory(Configuration p0) {
        new ConfigurationRequestFactory(p0, 0);
        return;
    }

    public ConfigurationRequestFactory(Configuration p0, IDeviceInfoDataContainer p1) {
        new Object();
        _configuration = p0;
        _deviceInfoDataContainer = p1;
        return;
    }

    public Configuration getConfiguration() {
        return _configuration;
    }

    public WebRequest getWebRequest() {
        _configuration.getConfigUrl();
        if (if-eqz(Configuration.getConfigUrl(..))) goto L_47;
        new StringBuilder(Configuration.getConfigUrl(..));
        new HashMap();
        Collections.singletonList("gzip");
        new HashMap(..).put("Content-Encoding", Collections.singletonList(..));
        new StringBuilder(..).toString();
        new WebRequest(StringBuilder.toString(..), "POST", new HashMap(..));
        if (if-eqz(_deviceInfoDataContainer)) goto L_31;
        _deviceInfoDataContainer.getDeviceData();
      L_31:
      L_32:
        new WebRequest(..).setBody(0);
        new StringBuilder("Requesting configuration with: ");
        new StringBuilder(..).append(new StringBuilder(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        return new WebRequest(..);
      L_47:
        new MalformedURLException("Base URL is null");
        throw new MalformedURLException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.CoreModuleConfiguration
// ============================================================
package com.unity3d.services.core.configuration;

public class CoreModuleConfiguration {
    public CoreModuleConfiguration() {
        new Object();
        return;
    }

    private void checkForPC(Configuration p0, SDKMetricsSender p1) {
        p0.getExperiments();
        Configuration.getExperiments(..).isPCCheckEnabled();
        if (if-eqz(IExperiments.isPCCheckEnabled(..))) goto L_32;
        ClientProperties.getApplicationContext();
        if (if-nez(ClientProperties.getApplicationContext(..))) goto L_11;
        return;
      L_11:
        Context.getPackageManager();
        Context.getPackageManager(..).hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE");
        if (if-eqz(PackageManager.hasSystemFeature(..))) goto L_28;
        new Metric("native_device_is_pc_success");
        p1.sendMetric(new Metric(..));
      L_28:
        new Metric("native_device_is_pc_failure");
        p1.sendMetric(new Metric(..));
      L_32:
        return;
    }

    private void collectMetrics(Configuration p0) {
        new ArrayList();
        Device.hasX264Decoder();
        if (if-eqz(Device.hasX264Decoder(..))) goto L_16;
        new Metric("native_device_decoder_x264_success");
        new ArrayList(..).add(new Metric(..));
      L_16:
        new Metric("native_device_decoder_x264_failure");
        new ArrayList(..).add(new Metric(..));
      L_20:
        Device.hasX265Decoder();
        if (if-eqz(Device.hasX265Decoder(..))) goto L_31;
        new Metric("native_device_decoder_x265_success");
        new ArrayList(..).add(new Metric(..));
      L_31:
        new Metric("native_device_decoder_x265_failure");
        new ArrayList(..).add(new Metric(..));
      L_3b:
        Device.hasAV1Decoder();
        if (if-eqz(Device.hasAV1Decoder(..))) goto L_4c;
        new Metric("native_device_decoder_av1_success");
        new ArrayList(..).add(new Metric(..));
      L_4c:
        new Metric("native_device_decoder_av1_failure");
        new ArrayList(..).add(new Metric(..));
      L_56:
        Utilities.getService(SDKMetricsSender.class);
        Utilities.getService(..).sendMetrics(new ArrayList(..));
        CoreModuleConfiguration.checkForPC(p0, Utilities.getService(..));
        return;
    }

    public Class[] getWebAppApiClassList() {
        return 14;
    }

    public boolean initCompleteState(Configuration p0) {
        SDKMetrics.setConfiguration(p0);
        InitializationNotificationCenter.getInstance();
        InitializationNotificationCenter.triggerOnSdkInitialized();
        new CoreModuleConfiguration$2(this);
        Utilities.runOnUiThread(new CoreModuleConfiguration$2(..));
        CoreModuleConfiguration.collectMetrics(p0);
        return 1;
    }

    public boolean initErrorState(Configuration p0, ErrorState p1, String p2) {
        SDKMetrics.setConfiguration(p0);
        p1.ordinal();
        if (if-eq(CoreModuleConfiguration$3.$SwitchMap$com$unity3d$services$core$configuration$ErrorState, 1)) goto L_19;
        if (if-eq(CoreModuleConfiguration$3.$SwitchMap$com$unity3d$services$core$configuration$ErrorState, 2)) goto L_16;
      L_16:
      L_19:
      L_1b:
        InitializationNotificationCenter.getInstance();
        InitializationNotificationCenter.triggerOnSdkInitializationFailed("Unity Ads failed to initialize due to internal error", p1, 0);
        new CoreModuleConfiguration$1(this, UnityAds$UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads failed to initialize due to internal error");
        Utilities.runOnUiThread(new CoreModuleConfiguration$1(..));
        return 1;
    }

    public boolean resetState(Configuration p0) {
        BroadcastMonitor.getInstance();
        BroadcastMonitor.getInstance(..).removeAllBroadcastListeners();
        CacheThread.cancel();
        WebRequestThread.cancel();
        ConnectivityMonitor.stopAll();
        ClientProperties.getApplicationContext();
        StorageManager.init(ClientProperties.getApplicationContext(..));
        ClientProperties.getApplicationContext();
        AdvertisingId.init(ClientProperties.getApplicationContext(..));
        ClientProperties.getApplicationContext();
        OpenAdvertisingId.init(ClientProperties.getApplicationContext(..));
        Utilities.getService(VolumeChange.class);
        Utilities.getService(..).clearAllListeners();
        return 1;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.EnvironmentCheck
// ============================================================
package com.unity3d.services.core.configuration;

public class EnvironmentCheck {
    public EnvironmentCheck() {
        new Object();
        return;
    }

    private static boolean hasJavascriptInterface(Method p0) {
        p0.getAnnotations();
        if (if-eqz(Method.getAnnotations(..))) goto L_16;
      L_9:
        if (if-ge(0, v1)) goto L_16;
        if (if-eqz(v3)) goto L_13;
        return 1;
      L_13:
      L_16:
        return 0;
    }

    public static boolean isEnvironmentOk() {
        EnvironmentCheck.testProGuard();
        if (if-eqz(EnvironmentCheck.testProGuard(..))) goto L_e;
        EnvironmentCheck.testCacheDirectory();
        if (if-eqz(EnvironmentCheck.testCacheDirectory(..))) goto L_e;
      L_e:
      L_f:
        return 0;
    }

    public static boolean testCacheDirectory() {
        SdkProperties.getCacheDirectory();
        SdkProperties.getWebViewCacheDirectory();
        if (if-eqz(SdkProperties.getCacheDirectory(..))) goto L_13;
        if (if-eqz(SdkProperties.getWebViewCacheDirectory(..))) goto L_13;
        DeviceLog.debug("Unity Ads cache directory check OK");
        return 1;
      L_13:
        DeviceLog.error("Unity Ads cache directory check fail: no working cache directory available");
        return 0;
    }

    public static boolean testProGuard() {
        Class.forName("com.unity3d.services.core.webview.bridge.WebViewBridgeInterface");
        Class.forName(..).getMethod("handleInvocation", v4);
        Class.forName(..).getMethod("handleCallback", 3);
        EnvironmentCheck.hasJavascriptInterface(Class.getMethod(..));
        if (if-eqz(EnvironmentCheck.hasJavascriptInterface(..))) goto L_3c;
        EnvironmentCheck.hasJavascriptInterface(Class.getMethod(..));
        if (if-eqz(EnvironmentCheck.hasJavascriptInterface(..))) goto L_3c;
        DeviceLog.debug("Unity Ads ProGuard check OK");
        return 1;
      L_3c:
        DeviceLog.error("Unity Ads ProGuard check fail: missing @JavascriptInterface annotations in Unity Ads web bridge");
        return 0;
        new StringBuilder("Unknown exception during Unity Ads ProGuard check: ");
        0.getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.exception(StringBuilder.toString(..), 0);
        return 1;
        DeviceLog.exception("Unity Ads ProGuard check fail: Unity Ads web bridge methods not found", 1);
        return 0;
        DeviceLog.exception("Unity Ads ProGuard check fail: Unity Ads web bridge class not found", 1);
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.ErrorState
// ============================================================
package com.unity3d.services.core.configuration;

public final class ErrorState extends Enum {
    private static final ErrorState[] $VALUES;
    public static final ErrorState CreateWebApp;
    public static final ErrorState CreateWebview;
    public static final ErrorState CreateWebviewConfigError;
    public static final ErrorState CreateWebviewGameIdDisabled;
    public static final ErrorState CreateWebviewInvalidArgument;
    public static final ErrorState CreateWebviewTimeout;
    public static final ErrorState InitModules;
    public static final ErrorState InvalidHash;
    public static final ErrorState LoadCache;
    public static final ErrorState MalformedWebviewRequest;
    public static final ErrorState NetworkConfigRequest;
    public static final ErrorState NetworkWebviewRequest;
    public static final ErrorState ResetWebApp;
    private String _stateMetricName;

    private static ErrorState[] $values() {
        return 13;
    }

    static <clinit>() {
        new ErrorState("CreateWebApp", 0, "create_webapp");
        CreateWebApp = new ErrorState(..);
        new ErrorState("NetworkConfigRequest", 1, "network_config");
        NetworkConfigRequest = new ErrorState(..);
        new ErrorState("NetworkWebviewRequest", 2, "network_webview");
        NetworkWebviewRequest = new ErrorState(..);
        new ErrorState("InvalidHash", 3, "invalid_hash");
        InvalidHash = new ErrorState(..);
        new ErrorState("CreateWebview", 4, "create_webview");
        CreateWebview = new ErrorState(..);
        new ErrorState("MalformedWebviewRequest", 5, "malformed_webview");
        MalformedWebviewRequest = new ErrorState(..);
        new ErrorState("ResetWebApp", 6, "reset_webapp");
        ResetWebApp = new ErrorState(..);
        new ErrorState("LoadCache", 7, "load_cache");
        LoadCache = new ErrorState(..);
        new ErrorState("InitModules", 8, "init_modules");
        InitModules = new ErrorState(..);
        new ErrorState("CreateWebviewTimeout", 9, "create_webview_timeout");
        CreateWebviewTimeout = new ErrorState(..);
        new ErrorState("CreateWebviewGameIdDisabled", 10, "create_webview_game_id_disabled");
        CreateWebviewGameIdDisabled = new ErrorState(..);
        new ErrorState("CreateWebviewConfigError", 11, "create_webview_config_error");
        CreateWebviewConfigError = new ErrorState(..);
        new ErrorState("CreateWebviewInvalidArgument", 12, "create_webview_invalid_arg");
        CreateWebviewInvalidArgument = new ErrorState(..);
        ErrorState.$values();
        $VALUES = ErrorState.$values(..);
        return;
    }

    private ErrorState(String p0, int p1, String p2) {
        new Enum(p0, p1);
        _stateMetricName = p2;
        return;
    }

    public static ErrorState valueOf(String p0) {
        Enum.valueOf(ErrorState.class, p0);
        return Enum.valueOf(..);
    }

    public static ErrorState[] values() {
        ErrorState.$VALUES.clone();
        return ErrorState[].clone(..);
    }

    public String getMetricName() {
        return _stateMetricName;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.ExperimentAppliedRule
// ============================================================
package com.unity3d.services.core.configuration;

public final class ExperimentAppliedRule extends Enum {
    private static final ExperimentAppliedRule[] $VALUES;
    public static final ExperimentAppliedRule IMMEDIATE;
    public static final ExperimentAppliedRule NEXT;

    private static ExperimentAppliedRule[] $values() {
        return 2;
    }

    static <clinit>() {
        new ExperimentAppliedRule("NEXT", 0);
        NEXT = new ExperimentAppliedRule(..);
        new ExperimentAppliedRule("IMMEDIATE", 1);
        IMMEDIATE = new ExperimentAppliedRule(..);
        ExperimentAppliedRule.$values();
        $VALUES = ExperimentAppliedRule.$values(..);
        return;
    }

    private ExperimentAppliedRule(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static ExperimentAppliedRule valueOf(String p0) {
        Enum.valueOf(ExperimentAppliedRule.class, p0);
        return Enum.valueOf(..);
    }

    public static ExperimentAppliedRule[] values() {
        ExperimentAppliedRule.$VALUES.clone();
        return ExperimentAppliedRule[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.ExperimentObject
// ============================================================
package com.unity3d.services.core.configuration;

public class ExperimentObject {
    private static final String APPLIED_KEY = "applied";
    private static final String VALUE_KEY = "value";
    private final JSONObject _experimentData;

    public ExperimentObject(JSONObject p0) {
        new Object();
        if (if-eqz(p0)) goto L_6;
      L_6:
        new JSONObject();
      L_b:
        _experimentData = new JSONObject(..);
        return;
    }

    public ExperimentAppliedRule getAppliedRule() {
        _experimentData.optString("applied");
        JSONObject.optString(..).isEmpty();
        if (if-nez(String.isEmpty(..))) goto L_24;
        JSONObject.optString(..).toUpperCase();
        ExperimentAppliedRule.valueOf(String.toUpperCase(..));
        DeviceLog.warning("Invalid rule %s for experiment", 1);
      L_24:
        return ExperimentAppliedRule.valueOf(..);
    }

    public boolean getBooleanValue() {
        _experimentData.optBoolean("value");
        return JSONObject.optBoolean(..);
    }

    public String getStringValue() {
        _experimentData.optString("value");
        return JSONObject.optString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.ExperimentObjects
// ============================================================
package com.unity3d.services.core.configuration;

public class ExperimentObjects extends ExperimentsBase {
    private final Map _experimentObjects;
    private final JSONObject _experimentObjetsData;

    public ExperimentObjects(JSONObject p0) {
        new ExperimentsBase();
        new HashMap();
        _experimentObjects = new HashMap(..);
        if (if-eqz(p0)) goto L_2d;
        _experimentObjetsData = p0;
        p0.keys();
      L_12:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_34;
        JSONObject.keys(..).next();
        p0.optJSONObject(Iterator.next(..));
        new ExperimentObject(JSONObject.optJSONObject(..));
        _experimentObjects.put(Iterator.next(..), new ExperimentObject(..));
      L_2d:
        new JSONObject();
        _experimentObjetsData = new JSONObject(..);
      L_34:
        return;
    }

    private String getExperimentValue(String p0, String p1) {
        ExperimentObjects.getExperimentObject(p0);
        if (if-eqz(ExperimentObjects.getExperimentObject(..))) goto L_a;
        ExperimentObject.getStringValue();
      L_a:
        return ExperimentObject.getStringValue(..);
    }

    private boolean getExperimentValue(String p0, boolean p1) {
        ExperimentObjects.getExperimentObject(p0);
        if (if-eqz(ExperimentObjects.getExperimentObject(..))) goto L_a;
        ExperimentObject.getBooleanValue();
      L_a:
        return ExperimentObject.getBooleanValue(..);
    }

    private boolean getExperimentValueOrDefault(String p0) {
        ExperimentObjects.getExperimentValue(p0, 0);
        return ExperimentObjects.getExperimentValue(..);
    }

    private JSONObject getExperimentWithAppliedRule(ExperimentAppliedRule p0) {
        new HashMap();
        _experimentObjects.entrySet();
        Map.entrySet(..).iterator();
      L_f:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_3b;
        Set.iterator(..).next();
        Iterator.next(..).getValue();
        Map$Entry.getValue(..).getAppliedRule();
        if (if-ne(ExperimentObject.getAppliedRule(..), p0)) goto L_f;
        Iterator.next(..).getKey();
        Iterator.next(..).getValue();
        Map$Entry.getValue(..).getStringValue();
        new HashMap(..).put(Map$Entry.getKey(..), ExperimentObject.getStringValue(..));
      L_3b:
        new JSONObject(new HashMap(..));
        return new JSONObject(..);
    }

    public JSONObject getCurrentSessionExperiments() {
        ExperimentObjects.getExperimentWithAppliedRule(ExperimentAppliedRule.IMMEDIATE);
        return ExperimentObjects.getExperimentWithAppliedRule(..);
    }

    public ExperimentObject getExperimentObject(String p0) {
        _experimentObjects.get(p0);
        return Map.get(..);
    }

    public Map getExperimentTags() {
        new HashMap();
        _experimentObjects.entrySet();
        Map.entrySet(..).iterator();
      L_f:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_2f;
        Set.iterator(..).next();
        Iterator.next(..).getKey();
        Iterator.next(..).getValue();
        Map$Entry.getValue(..).getStringValue();
        new HashMap(..).put(Map$Entry.getKey(..), ExperimentObject.getStringValue(..));
      L_2f:
        return new HashMap(..);
    }

    public JSONObject getExperimentsAsJson() {
        return _experimentObjetsData;
    }

    public JSONObject getNextSessionExperiments() {
        ExperimentObjects.getExperimentWithAppliedRule(ExperimentAppliedRule.NEXT);
        return ExperimentObjects.getExperimentWithAppliedRule(..);
    }

    public String getScarBiddingManager() {
        ScarBiddingManagerType.DISABLED.getName();
        ExperimentObjects.getExperimentValue("scar_bm", ScarBiddingManagerType.getName(..));
        return ExperimentObjects.getExperimentValue(..);
    }

    public boolean isBoldSdkNextSessionEnabled() {
        ExperimentObjects.getExperimentValueOrDefault("boldSdkNextSessionEnabled");
        return ExperimentObjects.getExperimentValueOrDefault(..);
    }

    public boolean isCaptureHDRCapabilitiesEnabled() {
        ExperimentObjects.getExperimentValueOrDefault("hdrc");
        return ExperimentObjects.getExperimentValueOrDefault(..);
    }

    public boolean isJetpackLifecycle() {
        ExperimentObjects.getExperimentValueOrDefault("gjl");
        return ExperimentObjects.getExperimentValueOrDefault(..);
    }

    public boolean isNativeLoadTimeoutDisabled() {
        ExperimentObjects.getExperimentValueOrDefault("nltd");
        return ExperimentObjects.getExperimentValueOrDefault(..);
    }

    public boolean isNativeShowTimeoutDisabled() {
        ExperimentObjects.getExperimentValueOrDefault("nstd");
        return ExperimentObjects.getExperimentValueOrDefault(..);
    }

    public boolean isOkHttpEnabled() {
        ExperimentObjects.getExperimentValueOrDefault("okhttp");
        return ExperimentObjects.getExperimentValueOrDefault(..);
    }

    public boolean isPCCheckEnabled() {
        ExperimentObjects.getExperimentValueOrDefault("pc_check");
        return ExperimentObjects.getExperimentValueOrDefault(..);
    }

    public boolean isScarBannerHbEnabled() {
        ExperimentObjects.getExperimentValueOrDefault("scar_bn");
        return ExperimentObjects.getExperimentValueOrDefault(..);
    }

    public boolean isScarInitEnabled() {
        ExperimentObjects.getExperimentValueOrDefault("scar_init");
        return ExperimentObjects.getExperimentValueOrDefault(..);
    }

    public boolean isWebAssetAdCaching() {
        ExperimentObjects.getExperimentValueOrDefault("wac");
        return ExperimentObjects.getExperimentValueOrDefault(..);
    }

    public boolean isWebGestureNotRequired() {
        ExperimentObjects.getExperimentValueOrDefault("wgr");
        return ExperimentObjects.getExperimentValueOrDefault(..);
    }

    public boolean isWebMessageEnabled() {
        ExperimentObjects.getExperimentValueOrDefault("jwm");
        return ExperimentObjects.getExperimentValueOrDefault(..);
    }

    public boolean isWebViewAsyncDownloadEnabled() {
        ExperimentObjects.getExperimentValueOrDefault("wad");
        return ExperimentObjects.getExperimentValueOrDefault(..);
    }

    public boolean shouldNativeTokenAwaitPrivacy() {
        ExperimentObjects.getExperimentValueOrDefault("tsi_prw");
        return ExperimentObjects.getExperimentValueOrDefault(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.Experiments
// ============================================================
package com.unity3d.services.core.configuration;

public class Experiments extends ExperimentsBase {
    private static final Set NEXT_SESSION_FLAGS;
    private final JSONObject _experimentData;

    static <clinit>() {
        Collections.singletonList("tsi_prw");
        new HashSet(Collections.singletonList(..));
        NEXT_SESSION_FLAGS = new HashSet(..);
        return;
    }

    public Experiments() {
        new Experiments(0);
        return;
    }

    public Experiments(JSONObject p0) {
        new ExperimentsBase();
        if (if-nez(p0)) goto L_d;
        new JSONObject();
        _experimentData = new JSONObject(..);
      L_d:
        _experimentData = new JSONObject(..);
      L_f:
        return;
    }

    public JSONObject getCurrentSessionExperiments() {
        if (if-nez(_experimentData)) goto L_6;
        return 0;
      L_6:
        new HashMap();
        _experimentData.keys();
      L_11:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_33;
        JSONObject.keys(..).next();
        Experiments.NEXT_SESSION_FLAGS.contains(Iterator.next(..));
        if (if-nez(Set.contains(..))) goto L_11;
        _experimentData.optBoolean(Iterator.next(..));
        String.valueOf(JSONObject.optBoolean(..));
        new HashMap(..).put(Iterator.next(..), String.valueOf(..));
      L_33:
        new JSONObject(new HashMap(..));
        return new JSONObject(..);
    }

    public Map getExperimentTags() {
        new HashMap();
        _experimentData.keys();
      L_b:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_25;
        JSONObject.keys(..).next();
        _experimentData.opt(Iterator.next(..));
        String.valueOf(JSONObject.opt(..));
        new HashMap(..).put(Iterator.next(..), String.valueOf(..));
      L_25:
        return new HashMap(..);
    }

    public JSONObject getExperimentsAsJson() {
        return _experimentData;
    }

    public JSONObject getNextSessionExperiments() {
        if (if-nez(_experimentData)) goto L_6;
        return 0;
      L_6:
        new HashMap();
        _experimentData.keys();
      L_11:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_33;
        JSONObject.keys(..).next();
        Experiments.NEXT_SESSION_FLAGS.contains(Iterator.next(..));
        if (if-eqz(Set.contains(..))) goto L_11;
        _experimentData.optBoolean(Iterator.next(..));
        String.valueOf(JSONObject.optBoolean(..));
        new HashMap(..).put(Iterator.next(..), String.valueOf(..));
      L_33:
        new JSONObject(new HashMap(..));
        return new JSONObject(..);
    }

    public String getScarBiddingManager() {
        ScarBiddingManagerType.DISABLED.getName();
        _experimentData.optString("scar_bm", ScarBiddingManagerType.getName(..));
        return JSONObject.optString(..);
    }

    public boolean isBoldSdkNextSessionEnabled() {
        _experimentData.optBoolean("boldSdkNextSessionEnabled", 0);
        return JSONObject.optBoolean(..);
    }

    public boolean isCaptureHDRCapabilitiesEnabled() {
        _experimentData.optBoolean("hdrc", 0);
        return JSONObject.optBoolean(..);
    }

    public boolean isJetpackLifecycle() {
        _experimentData.optBoolean("gjl", 0);
        return JSONObject.optBoolean(..);
    }

    public boolean isNativeLoadTimeoutDisabled() {
        _experimentData.optBoolean("nltd", 0);
        return JSONObject.optBoolean(..);
    }

    public boolean isNativeShowTimeoutDisabled() {
        _experimentData.optBoolean("nstd", 0);
        return JSONObject.optBoolean(..);
    }

    public boolean isOkHttpEnabled() {
        _experimentData.optBoolean("okhttp", 0);
        return JSONObject.optBoolean(..);
    }

    public boolean isPCCheckEnabled() {
        _experimentData.optBoolean("pc_check", 0);
        return JSONObject.optBoolean(..);
    }

    public boolean isScarBannerHbEnabled() {
        _experimentData.optBoolean("scar_bn", 0);
        return JSONObject.optBoolean(..);
    }

    public boolean isScarInitEnabled() {
        _experimentData.optBoolean("scar_init", 0);
        return JSONObject.optBoolean(..);
    }

    public boolean isWebAssetAdCaching() {
        _experimentData.optBoolean("wac", 0);
        return JSONObject.optBoolean(..);
    }

    public boolean isWebGestureNotRequired() {
        _experimentData.optBoolean("wgr", 0);
        return JSONObject.optBoolean(..);
    }

    public boolean isWebMessageEnabled() {
        _experimentData.optBoolean("jwm", 0);
        return JSONObject.optBoolean(..);
    }

    public boolean isWebViewAsyncDownloadEnabled() {
        _experimentData.optBoolean("wad", 0);
        return JSONObject.optBoolean(..);
    }

    public boolean shouldNativeTokenAwaitPrivacy() {
        _experimentData.optBoolean("tsi_prw", 0);
        return JSONObject.optBoolean(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.ExperimentsBase
// ============================================================
package com.unity3d.services.core.configuration;

public abstract class ExperimentsBase {
    static final boolean EXP_DEFAULT_VALUE = false;
    static final String EXP_TAG_HDR_CAPABILITIES = "hdrc";
    public static final String EXP_TAG_IS_BOLD_NEXT_SESSION = "boldSdkNextSessionEnabled";
    static final String EXP_TAG_IS_PC_CHECK_ENABLED = "pc_check";
    static final String EXP_TAG_JETPACK_LIFECYCLE = "gjl";
    static final String EXP_TAG_LOAD_TIMEOUT_DISABLED = "nltd";
    static final String EXP_TAG_OK_HTTP = "okhttp";
    static final String EXP_TAG_SCAR_BIDDING_MANAGER = "scar_bm";
    static final String EXP_TAG_SCAR_HB_BN = "scar_bn";
    static final String EXP_TAG_SCAR_INIT = "scar_init";
    static final String EXP_TAG_SHOW_TIMEOUT_DISABLED = "nstd";
    static final String EXP_TAG_WEBVIEW_ASYNC_DOWNLOAD = "wad";
    static final String EXP_TAG_WEB_AD_ASSET_CACHING = "wac";
    static final String EXP_TAG_WEB_GESTURE_NOT_REQUIRED = "wgr";
    static final String EXP_TAG_WEB_MESSAGE = "jwm";
    static final String TSI_TAG_NATIVE_TOKEN_AWAIT_PRIVACY = "tsi_prw";

    public ExperimentsBase() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.ExperimentsReader
// ============================================================
package com.unity3d.services.core.configuration;

public class ExperimentsReader {
    private IExperiments _localExperiments;
    private IExperiments _remoteExperiments;

    public ExperimentsReader() {
        new Object();
        return;
    }

    public IExperiments getCurrentlyActiveExperiments() {
        if (if-nez(_remoteExperiments)) goto L_10;
        if (if-nez(_localExperiments)) goto L_10;
        new Experiments();
        return new Experiments(..);
      L_10:
        if (if-nez(new Experiments(..))) goto L_16;
        return _localExperiments;
      L_16:
        if (if-nez(_localExperiments)) goto L_21;
        new Experiments();
        _localExperiments = new Experiments(..);
      L_21:
        _localExperiments.getNextSessionExperiments();
        _remoteExperiments.getCurrentSessionExperiments();
        Utilities.mergeJsonObjects(IExperiments.getNextSessionExperiments(..), IExperiments.getCurrentSessionExperiments(..));
        new Experiments(Utilities.mergeJsonObjects(..));
        return new Experiments(..);
        DeviceLog.error("Couldn't get active experiments, reverting to default experiments");
        new Experiments();
        return new Experiments(..);
        throw new Experiments(..);
    }

    public void updateLocalExperiments(IExperiments p0) {
        _localExperiments = p0;
        return;
        throw p0;
    }

    public void updateRemoteExperiments(IExperiments p0) {
        _remoteExperiments = p0;
        return;
        throw p0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.IConfigurationLoader
// ============================================================
package com.unity3d.services.core.configuration;

public abstract class IConfigurationLoader {
    public abstract Configuration getLocalConfiguration() {
        // native or abstract
    }

    public abstract void loadConfiguration(IConfigurationLoaderListener p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.IConfigurationLoaderListener
// ============================================================
package com.unity3d.services.core.configuration;

public abstract class IConfigurationLoaderListener {
    public abstract void onError(String p0) {
        // native or abstract
    }

    public abstract void onSuccess(Configuration p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.IExperiments
// ============================================================
package com.unity3d.services.core.configuration;

public abstract class IExperiments {
    public abstract JSONObject getCurrentSessionExperiments() {
        // native or abstract
    }

    public abstract Map getExperimentTags() {
        // native or abstract
    }

    public abstract JSONObject getExperimentsAsJson() {
        // native or abstract
    }

    public abstract JSONObject getNextSessionExperiments() {
        // native or abstract
    }

    public abstract String getScarBiddingManager() {
        // native or abstract
    }

    public abstract boolean isBoldSdkNextSessionEnabled() {
        // native or abstract
    }

    public abstract boolean isCaptureHDRCapabilitiesEnabled() {
        // native or abstract
    }

    public abstract boolean isJetpackLifecycle() {
        // native or abstract
    }

    public abstract boolean isNativeLoadTimeoutDisabled() {
        // native or abstract
    }

    public abstract boolean isNativeShowTimeoutDisabled() {
        // native or abstract
    }

    public abstract boolean isOkHttpEnabled() {
        // native or abstract
    }

    public abstract boolean isPCCheckEnabled() {
        // native or abstract
    }

    public abstract boolean isScarBannerHbEnabled() {
        // native or abstract
    }

    public abstract boolean isScarInitEnabled() {
        // native or abstract
    }

    public abstract boolean isWebAssetAdCaching() {
        // native or abstract
    }

    public abstract boolean isWebGestureNotRequired() {
        // native or abstract
    }

    public abstract boolean isWebMessageEnabled() {
        // native or abstract
    }

    public abstract boolean isWebViewAsyncDownloadEnabled() {
        // native or abstract
    }

    public abstract boolean shouldNativeTokenAwaitPrivacy() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.IInitializationListener
// ============================================================
package com.unity3d.services.core.configuration;

public abstract class IInitializationListener {
    public abstract void onSdkInitializationFailed(String p0, ErrorState p1, int p2) {
        // native or abstract
    }

    public abstract void onSdkInitialized() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.IInitializationNotificationCenter
// ============================================================
package com.unity3d.services.core.configuration;

public abstract class IInitializationNotificationCenter {
    public abstract void addListener(IInitializationListener p0) {
        // native or abstract
    }

    public abstract void removeListener(IInitializationListener p0) {
        // native or abstract
    }

    public abstract void triggerOnSdkInitializationFailed(String p0, ErrorState p1, int p2) {
        // native or abstract
    }

    public abstract void triggerOnSdkInitialized() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.IInitializeEventsMetricSender
// ============================================================
package com.unity3d.services.core.configuration;

public abstract class IInitializeEventsMetricSender {
    public abstract Long configRequestDuration() {
        // native or abstract
    }

    public abstract void didConfigRequestEnd(boolean p0) {
        // native or abstract
    }

    public abstract void didConfigRequestStart() {
        // native or abstract
    }

    public abstract void didInitStart() {
        // native or abstract
    }

    public abstract void didPrivacyConfigRequestEnd(boolean p0) {
        // native or abstract
    }

    public abstract void didPrivacyConfigRequestStart() {
        // native or abstract
    }

    public abstract Long duration() {
        // native or abstract
    }

    public abstract Map getRetryTags() {
        // native or abstract
    }

    public abstract Long initializationStartTimeStamp() {
        // native or abstract
    }

    public abstract void onRetryConfig() {
        // native or abstract
    }

    public abstract void onRetryWebview() {
        // native or abstract
    }

    public abstract Long privacyConfigDuration() {
        // native or abstract
    }

    public abstract void sdkDidInitialize() {
        // native or abstract
    }

    public abstract void sdkInitializeFailed(String p0, ErrorState p1) {
        // native or abstract
    }

    public abstract void sdkTokenDidBecomeAvailableWithConfig(boolean p0) {
        // native or abstract
    }

    public abstract void sendMetric(Metric p0) {
        // native or abstract
    }

    public abstract Long tokenDuration() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.IModuleConfiguration
// ============================================================
package com.unity3d.services.core.configuration;

public abstract class IModuleConfiguration {
    public abstract Class[] getWebAppApiClassList() {
        // native or abstract
    }

    public abstract boolean initCompleteState(Configuration p0) {
        // native or abstract
    }

    public abstract boolean initErrorState(Configuration p0, ErrorState p1, String p2) {
        // native or abstract
    }

    public abstract boolean resetState(Configuration p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.IPrivacyConfigurationListener
// ============================================================
package com.unity3d.services.core.configuration;

public abstract class IPrivacyConfigurationListener {
    public abstract void onError(PrivacyCallError p0, String p1) {
        // native or abstract
    }

    public abstract void onSuccess(PrivacyConfig p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitRequestType
// ============================================================
package com.unity3d.services.core.configuration;

public final class InitRequestType extends Enum {
    private static final InitRequestType[] $VALUES;
    public static final InitRequestType PRIVACY;
    public static final InitRequestType TOKEN;
    private String _callType;

    private static InitRequestType[] $values() {
        return 2;
    }

    static <clinit>() {
        new InitRequestType("PRIVACY", 0, "privacy");
        PRIVACY = new InitRequestType(..);
        new InitRequestType("TOKEN", 1, "token_srr");
        TOKEN = new InitRequestType(..);
        InitRequestType.$values();
        $VALUES = InitRequestType.$values(..);
        return;
    }

    private InitRequestType(String p0, int p1, String p2) {
        new Enum(p0, p1);
        _callType = p2;
        return;
    }

    public static InitRequestType valueOf(String p0) {
        Enum.valueOf(InitRequestType.class, p0);
        return Enum.valueOf(..);
    }

    public static InitRequestType[] values() {
        InitRequestType.$VALUES.clone();
        return InitRequestType[].clone(..);
    }

    public String getCallType() {
        return _callType;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializationNotificationCenter
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializationNotificationCenter {
    private static InitializationNotificationCenter instance;
    private HashMap _sdkListeners;

    static <clinit>() {
        return;
    }

    public InitializationNotificationCenter() {
        new Object();
        new HashMap();
        _sdkListeners = new HashMap(..);
        return;
    }

    public static InitializationNotificationCenter getInstance() {
        if (if-nez(InitializationNotificationCenter.instance)) goto L_b;
        new InitializationNotificationCenter();
        instance = new InitializationNotificationCenter(..);
      L_b:
        return InitializationNotificationCenter.instance;
    }

    private void removeListener(Integer p0) {
        _sdkListeners.remove(p0);
        return;
    }

    public void addListener(IInitializationListener p0) {
        if (if-eqz(p0)) goto L_13;
        p0.hashCode();
        new Integer(Object.hashCode(..));
        _sdkListeners.put(new Integer(..), p0);
      L_13:
        return;
        throw p0;
    }

    public void removeListener(IInitializationListener p0) {
        if (if-eqz(p0)) goto L_11;
        p0.hashCode();
        new Integer(Object.hashCode(..));
        InitializationNotificationCenter.removeListener(new Integer(..));
      L_11:
        return;
        throw Object.hashCode(..);
    }

    public void triggerOnSdkInitializationFailed(String p0, ErrorState p1, int p2) {
        new StringBuilder("SDK Failed to Initialize due to ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
        new ArrayList();
        _sdkListeners.entrySet();
        HashMap.entrySet(..).iterator();
      L_23:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_4e;
        Set.iterator(..).next();
        Iterator.next(..).getValue();
        if (if-eqz(Map$Entry.getValue(..))) goto L_44;
        new InitializationNotificationCenter$2(this, Iterator.next(..), StringBuilder.toString(..), p1, p2);
        Utilities.runOnUiThread(new InitializationNotificationCenter$2);
      L_44:
        Iterator.next(..).getKey();
        new ArrayList(..).add(Map$Entry.getKey(..));
      L_4e:
        new ArrayList(..).iterator();
      L_52:
        ArrayList.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_64;
        ArrayList.iterator(..).next();
        _sdkListeners.remove(Iterator.next(..));
      L_64:
        return;
        throw ArrayList.iterator(..);
    }

    public void triggerOnSdkInitialized() {
        new ArrayList();
        _sdkListeners.entrySet();
        HashMap.entrySet(..).iterator();
      L_12:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_37;
        Set.iterator(..).next();
        Iterator.next(..).getValue();
        if (if-eqz(Map$Entry.getValue(..))) goto L_2d;
        new InitializationNotificationCenter$1(this, Iterator.next(..));
        Utilities.runOnUiThread(new InitializationNotificationCenter$1(..));
      L_2d:
        Iterator.next(..).getKey();
        new ArrayList(..).add(Map$Entry.getKey(..));
      L_37:
        new ArrayList(..).iterator();
      L_3b:
        ArrayList.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_4d;
        ArrayList.iterator(..).next();
        _sdkListeners.remove(Iterator.next(..));
      L_4d:
        return;
        throw ArrayList.iterator(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeEventsMetricSender
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeEventsMetricSender {
    private static InitializeEventsMetricSender _instance;
    private long _configEndTime;
    private int _configRetryCount;
    private long _configStartTime;
    private boolean _initMetricSent;
    private long _privacyConfigEndTime;
    private long _privacyConfigStartTime;
    private final SDKMetricsSender _sdkMetricsSender;
    private long _startTime;
    private boolean _tokenMetricSent;
    private int _webviewRetryCount;

    private InitializeEventsMetricSender() {
        new Object();
        _startTime = 0L;
        _privacyConfigStartTime = 0L;
        _privacyConfigEndTime = 0L;
        _configStartTime = 0L;
        _configEndTime = 0L;
        _configRetryCount = 0;
        _webviewRetryCount = 0;
        _initMetricSent = 0;
        _tokenMetricSent = 0;
        Utilities.getService(SDKMetricsSender.class);
        _sdkMetricsSender = Utilities.getService(..);
        InitializationNotificationCenter.getInstance();
        InitializationNotificationCenter.addListener(new Object(..));
        return;
    }

    static int access$000(InitializeEventsMetricSender p0) {
        return _configRetryCount;
    }

    static int access$100(InitializeEventsMetricSender p0) {
        return _webviewRetryCount;
    }

    public static IInitializeEventsMetricSender getInstance() {
        if (if-nez(InitializeEventsMetricSender._instance)) goto L_b;
        new InitializeEventsMetricSender();
        _instance = new InitializeEventsMetricSender(..);
      L_b:
        return InitializeEventsMetricSender._instance;
    }

    private Metric getPrivacyRequestMetric(boolean p0) {
        if (if-eqz(p0)) goto L_b;
        InitializeEventsMetricSender.privacyConfigDuration();
        TSIMetric.newPrivacyRequestLatencySuccess(InitializeEventsMetricSender.privacyConfigDuration(..));
        return TSIMetric.newPrivacyRequestLatencySuccess(..);
      L_b:
        InitializeEventsMetricSender.privacyConfigDuration();
        TSIMetric.newPrivacyRequestLatencyFailure(InitializeEventsMetricSender.privacyConfigDuration(..));
        return TSIMetric.newPrivacyRequestLatencyFailure(..);
    }

    private void sendConfigResolutionRequestIfNeeded(boolean p0) {
        if (if-eqz(_configStartTime)) goto L_29;
        if (if-nez(_configEndTime)) goto L_f;
      L_f:
        if (if-eqz(p0)) goto L_1d;
        InitializeEventsMetricSender.configRequestDuration();
        TSIMetric.newConfigRequestLatencySuccess(InitializeEventsMetricSender.configRequestDuration(..));
        InitializeEventsMetricSender.sendMetric(TSIMetric.newConfigRequestLatencySuccess(..));
      L_1d:
        InitializeEventsMetricSender.configRequestDuration();
        TSIMetric.newConfigRequestLatencyFailure(InitializeEventsMetricSender.configRequestDuration(..));
        InitializeEventsMetricSender.sendMetric(TSIMetric.newConfigRequestLatencyFailure(..));
      L_28:
        return;
      L_29:
        DeviceLog.debug("sendConfigResolutionRequestIfNeeded called with invalid timestamps, skipping metric");
        return;
    }

    private void sendPrivacyResolutionRequestIfNeeded(boolean p0) {
        if (if-eqz(_privacyConfigStartTime)) goto L_17;
        if (if-nez(_privacyConfigEndTime)) goto L_f;
      L_f:
        InitializeEventsMetricSender.getPrivacyRequestMetric(p0);
        InitializeEventsMetricSender.sendMetric(InitializeEventsMetricSender.getPrivacyRequestMetric(..));
        return;
      L_17:
        DeviceLog.debug("sendPrivacyResolutionRequestIfNeeded called with invalid timestamps, skipping metric");
        return;
    }

    private void sendTokenAvailabilityMetricWithConfig(boolean p0) {
        if (if-nez(_startTime)) goto L_e;
        DeviceLog.debug("sendTokenAvailabilityMetricWithConfig called before didInitStart, skipping metric");
        return;
      L_e:
        System.nanoTime();
        TimeUnit.NANOSECONDS.toMillis(System.nanoTime(..), 0L);
        Long.valueOf(TimeUnit.toMillis(..), System.nanoTime(..));
        InitializeEventsMetricSender.getRetryTags();
        if (if-eqz("sendTokenAvailabilityMetricWithConfig called before didInitStart, skipping metric")) goto L_2a;
        TSIMetric.newTokenAvailabilityLatencyConfig(Long.valueOf(..), InitializeEventsMetricSender.getRetryTags(..));
      L_2a:
        TSIMetric.newTokenAvailabilityLatencyWebview(Long.valueOf(..), InitializeEventsMetricSender.getRetryTags(..));
      L_2e:
        InitializeEventsMetricSender.sendMetric(TSIMetric.newTokenAvailabilityLatencyWebview(..));
        return;
    }

    private void sendTokenResolutionRequestMetricIfNeeded() {
        if (if-nez(_configStartTime)) goto L_e;
        DeviceLog.debug("sendTokenResolutionRequestMetricIfNeeded called before didInitStart, skipping metric");
        return;
      L_e:
        InitializeEventsMetricSender.tokenDuration();
        InitializeEventsMetricSender.getRetryTags();
        TSIMetric.newTokenResolutionRequestLatency(InitializeEventsMetricSender.tokenDuration(..), InitializeEventsMetricSender.getRetryTags(..));
        InitializeEventsMetricSender.sendMetric(TSIMetric.newTokenResolutionRequestLatency(..));
        return;
    }

    public Long configRequestDuration() {
        TimeUnit.NANOSECONDS.toMillis(_configEndTime, v2);
        Long.valueOf(TimeUnit.toMillis(..), _configEndTime);
        return Long.valueOf(..);
    }

    public void didConfigRequestEnd(boolean p0) {
        System.nanoTime();
        _configEndTime = System.nanoTime(..);
        InitializeEventsMetricSender.sendConfigResolutionRequestIfNeeded(p0);
        return;
    }

    public void didConfigRequestStart() {
        System.nanoTime();
        _configStartTime = System.nanoTime(..);
        return;
    }

    public void didInitStart() {
        System.nanoTime();
        _startTime = System.nanoTime(..);
        _configRetryCount = 0;
        _webviewRetryCount = 0;
        TSIMetric.newInitStarted();
        InitializeEventsMetricSender.sendMetric(TSIMetric.newInitStarted(..));
        return;
    }

    public void didPrivacyConfigRequestEnd(boolean p0) {
        System.nanoTime();
        _privacyConfigEndTime = System.nanoTime(..);
        InitializeEventsMetricSender.sendPrivacyResolutionRequestIfNeeded(p0);
        return;
    }

    public void didPrivacyConfigRequestStart() {
        System.nanoTime();
        _privacyConfigStartTime = System.nanoTime(..);
        return;
    }

    public Long duration() {
        System.nanoTime();
        TimeUnit.NANOSECONDS.toMillis(System.nanoTime(..), v2);
        Long.valueOf(TimeUnit.toMillis(..), System.nanoTime(..));
        return Long.valueOf(..);
    }

    public Map getErrorStateTags(ErrorState p0) {
        InitializeEventsMetricSender.getRetryTags();
        p0.getMetricName();
        Map.put("stt", ErrorState.getMetricName(..));
        return InitializeEventsMetricSender.getRetryTags(..);
    }

    public Map getRetryTags() {
        new InitializeEventsMetricSender$1(this);
        return new InitializeEventsMetricSender$1(..);
    }

    public Long initializationStartTimeStamp() {
        Long.valueOf(_startTime, v1);
        return Long.valueOf(..);
    }

    public void onRetryConfig() {
        _configRetryCount = _configRetryCount;
        return;
    }

    public void onRetryWebview() {
        _webviewRetryCount = _webviewRetryCount;
        return;
    }

    public void onSdkInitializationFailed(String p0, ErrorState p1, int p2) {
        InitializeEventsMetricSender.sdkInitializeFailed(p0, p1);
        return;
    }

    public void onSdkInitialized() {
        InitializeEventsMetricSender.sdkDidInitialize();
        return;
    }

    public Long privacyConfigDuration() {
        TimeUnit.NANOSECONDS.toMillis(_privacyConfigEndTime, v2);
        Long.valueOf(TimeUnit.toMillis(..), _privacyConfigEndTime);
        return Long.valueOf(..);
    }

    public void sdkDidInitialize() {
        InitializeEventsMetricSender.initializationStartTimeStamp();
        Long.longValue();
        if (if-nez(Long.longValue(..))) goto L_14;
        DeviceLog.debug("sdkDidInitialize called before didInitStart, skipping metric");
      L_14:
        return;
        throw "sdkDidInitialize called before didInitStart, skipping metric";
    }

    public void sdkInitializeFailed(String p0, ErrorState p1) {
        if (if-nez(_startTime)) goto L_e;
        DeviceLog.debug("sdkInitializeFailed called before didInitStart, skipping metric");
      L_e:
        return;
        throw "sdkInitializeFailed called before didInitStart, skipping metric";
    }

    public void sdkTokenDidBecomeAvailableWithConfig(boolean p0) {
        if (if-nez(_tokenMetricSent)) goto L_10;
        InitializeEventsMetricSender.sendTokenAvailabilityMetricWithConfig(p0);
        if (if-eqz(p0)) goto L_d;
        InitializeEventsMetricSender.sendTokenResolutionRequestMetricIfNeeded();
      L_d:
        _tokenMetricSent = 1;
      L_10:
        return;
        throw 1;
    }

    public void sendMetric(Metric p0) {
        _sdkMetricsSender.sendMetric(p0);
        return;
    }

    public Long tokenDuration() {
        System.nanoTime();
        TimeUnit.NANOSECONDS.toMillis(System.nanoTime(..), v2);
        Long.valueOf(TimeUnit.toMillis(..), System.nanoTime(..));
        return Long.valueOf(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread extends Thread {
    private static InitializeThread _thread;
    private boolean _didRetry;
    private final SDKMetricsSender _sdkMetricsSender;
    private InitializeThread$InitializeState _state;
    private String _stateName;
    private long _stateStartTimestamp;
    private boolean _stopThread;

    private InitializeThread(InitializeThread$InitializeState p0) {
        new Thread();
        _stopThread = 0;
        _didRetry = 0;
        Utilities.getService(SDKMetricsSender.class);
        _sdkMetricsSender = Utilities.getService(..);
        _state = p0;
        return;
    }

    static byte[] access$400(File p0) {
        InitializeThread.loadCachedFileToByteArray(p0);
        return InitializeThread.loadCachedFileToByteArray(..);
    }

    public static DownloadLatestWebViewStatus downloadLatestWebView() {
        if (if-eqz(InitializeThread._thread)) goto L_b;
        return DownloadLatestWebViewStatus.INIT_QUEUE_NOT_EMPTY;
      L_b:
        SdkProperties.getLatestConfiguration();
        if (if-nez(SdkProperties.getLatestConfiguration(..))) goto L_15;
        return DownloadLatestWebViewStatus.MISSING_LATEST_CONFIG;
      L_15:
        SdkProperties.getLatestConfiguration();
        new InitializeThread$InitializeStateCheckForCachedWebViewUpdate(SdkProperties.getLatestConfiguration(..));
        new InitializeThread(new InitializeThread$InitializeStateCheckForCachedWebViewUpdate(..));
        _thread = new InitializeThread(..);
        new InitializeThread(..).setName("UnityAdsDownloadThread");
        InitializeThread._thread.start();
        return DownloadLatestWebViewStatus.BACKGROUND_DOWNLOAD_STARTED;
        throw DownloadLatestWebViewStatus.BACKGROUND_DOWNLOAD_STARTED;
    }

    private String getMetricNameForState(InitializeThread$InitializeState p0) {
        if (if-nez(p0)) goto L_4;
        return 0;
      L_4:
        p0.getClass();
        Object.getClass(..).getSimpleName();
        Class.getSimpleName(..).length();
        if (if-nez(String.length(..))) goto L_13;
        return 0;
      L_13:
        InitializeThread.getStatePrefixLength();
        Class.getSimpleName(..).substring(InitializeThread.getStatePrefixLength(..));
        String.substring(..).toLowerCase();
        String.toLowerCase(..).length();
        new StringBuilder(7);
        new StringBuilder(..).append("native_");
        new StringBuilder(..).append(String.toLowerCase(..));
        new StringBuilder(..).append("_state");
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    private Map getMetricTagsForState() {
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.getRetryTags();
        return IInitializeEventsMetricSender.getRetryTags(..);
    }

    private int getStatePrefixLength() {
        return 15;
    }

    private void handleStateEndMetrics(InitializeThread$InitializeState p0) {
        if (if-eqz(_stateName)) goto L_36;
        InitializeThread.isRetryState(p0);
        if (if-nez(InitializeThread.isRetryState(..))) goto L_36;
        _stateName.equals("native_retry_state");
        if (if-eqz(String.equals(..))) goto L_15;
      L_15:
        System.nanoTime();
        TimeUnit.NANOSECONDS.toMillis(System.nanoTime(..), v1);
        Long.valueOf(TimeUnit.toMillis(..), v1);
        InitializeThread.getMetricTagsForState();
        new Metric(_stateName, Long.valueOf(..), InitializeThread.getMetricTagsForState(..));
        _sdkMetricsSender.sendMetric(new Metric(..));
      L_36:
        return;
    }

    private void handleStateStartMetrics(InitializeThread$InitializeState p0) {
        InitializeThread.isRetryState(p0);
        if (if-eqz(InitializeThread.isRetryState(..))) goto L_a;
        _didRetry = 1;
      L_a:
        if (if-nez(_didRetry)) goto L_14;
        System.nanoTime();
        _stateStartTimestamp = System.nanoTime(..);
      L_14:
        _didRetry = 0;
      L_17:
        InitializeThread.getMetricNameForState(p0);
        _stateName = InitializeThread.getMetricNameForState(..);
        return;
    }

    public static void initialize(Configuration p0) {
        if (if-nez(InitializeThread._thread)) goto L_27;
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.didInitStart();
        CachedLifecycle.register();
        new InitializeThread$InitializeStateLoadConfigFile(p0);
        new InitializeThread(new InitializeThread$InitializeStateLoadConfigFile(..));
        _thread = new InitializeThread(..);
        new InitializeThread(..).setName("UnityAdsInitializeThread");
        InitializeThread._thread.start();
      L_27:
        return;
        throw InitializeThread._thread;
    }

    private boolean isRetryState(InitializeThread$InitializeState p0) {
        return p0;
    }

    private static byte[] loadCachedFileToByteArray(File p0) {
        if (if-eqz(p0)) goto L_15;
        p0.exists();
        if (if-eqz(File.exists(..))) goto L_15;
        Utilities.readFileBytes(p0);
        return Utilities.readFileBytes(..);
        new IOException("could not read from file");
        throw new IOException(..);
      L_15:
        new IOException("file not found");
        throw new IOException(..);
    }

    public static void reset() {
        if (if-nez(InitializeThread._thread)) goto L_1d;
        new InitializeThread$InitializeStateForceReset();
        new InitializeThread(new InitializeThread$InitializeStateForceReset(..));
        _thread = new InitializeThread(..);
        new InitializeThread(..).setName("UnityAdsResetThread");
        InitializeThread._thread.start();
      L_1d:
        return;
        throw InitializeThread._thread;
    }

    public void quit() {
        _stopThread = 1;
        return;
    }

    public void run() {
      L_0:
        if (if-eqz(_state)) goto L_48;
        if (if-nez(_stopThread)) goto L_48;
        InitializeThread.handleStateStartMetrics(_state);
        _state.execute();
        _state = InitializeThread$InitializeState.execute(..);
        InitializeThread.handleStateEndMetrics(InitializeThread$InitializeState.execute(..));
        new Exception(InitializeThread$InitializeState.execute(..));
        DeviceLog.exception("Unity Ads SDK failed to initialize due to application doesn't have enough memory to initialize Unity Ads SDK", new Exception(..));
        new InitializeThread$2(this);
        Utilities.runOnUiThread(new InitializeThread$2(..));
        new InitializeThread$InitializeStateForceReset();
        _state = new InitializeThread$InitializeStateForceReset(..);
        DeviceLog.exception("Unity Ads SDK encountered an error during initialization, cancel initialization", new InitializeThread$InitializeStateForceReset(..));
        new InitializeThread$1(this);
        Utilities.runOnUiThread(new InitializeThread$1(..));
        new InitializeThread$InitializeStateForceReset();
        _state = new InitializeThread$InitializeStateForceReset(..);
      L_48:
        _thread = 0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.PrivacyCallError
// ============================================================
package com.unity3d.services.core.configuration;

public final class PrivacyCallError extends Enum {
    private static final PrivacyCallError[] $VALUES;
    public static final PrivacyCallError LOCKED_423;
    public static final PrivacyCallError NETWORK_ISSUE;

    private static final PrivacyCallError[] $values() {
        return 2;
    }

    static <clinit>() {
        new PrivacyCallError("NETWORK_ISSUE", 0);
        NETWORK_ISSUE = new PrivacyCallError(..);
        new PrivacyCallError("LOCKED_423", 1);
        LOCKED_423 = new PrivacyCallError(..);
        PrivacyCallError.$values();
        $VALUES = PrivacyCallError.$values(..);
        return;
    }

    private PrivacyCallError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static PrivacyCallError valueOf(String p0) {
        Enum.valueOf(PrivacyCallError.class, p0);
        return Enum.valueOf(..);
    }

    public static PrivacyCallError[] values() {
        PrivacyCallError.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.PrivacyConfig
// ============================================================
package com.unity3d.services.core.configuration;

public class PrivacyConfig {
    private PrivacyConfigStatus _privacyConfigStatus;
    private boolean _shouldSendNonBehavioral;

    public PrivacyConfig() {
        new PrivacyConfig(PrivacyConfigStatus.UNKNOWN);
        return;
    }

    public PrivacyConfig(PrivacyConfigStatus p0) {
        new Object();
        _privacyConfigStatus = p0;
        _shouldSendNonBehavioral = 0;
        return;
    }

    public PrivacyConfig(JSONObject p0) {
        new Object();
        new Object(..).parsePrivacyResponse(p0);
        return;
    }

    private void parsePrivacyResponse(JSONObject p0) {
        p0.optBoolean("pas", 0);
        if (if-eqz(JSONObject.optBoolean(..))) goto L_c;
      L_c:
      L_e:
        _privacyConfigStatus = PrivacyConfigStatus.DENIED;
        p0.optBoolean("snb", 0);
        _shouldSendNonBehavioral = JSONObject.optBoolean(..);
        return;
    }

    public boolean allowedToSendPii() {
        _privacyConfigStatus.equals(PrivacyConfigStatus.ALLOWED);
        return PrivacyConfigStatus.equals(..);
    }

    public PrivacyConfigStatus getPrivacyStatus() {
        return _privacyConfigStatus;
    }

    public boolean shouldSendNonBehavioral() {
        return _shouldSendNonBehavioral;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.PrivacyConfigStatus
// ============================================================
package com.unity3d.services.core.configuration;

public final class PrivacyConfigStatus extends Enum {
    private static final PrivacyConfigStatus[] $VALUES;
    public static final PrivacyConfigStatus ALLOWED;
    public static final PrivacyConfigStatus DENIED;
    public static final PrivacyConfigStatus UNKNOWN;

    private static PrivacyConfigStatus[] $values() {
        return 3;
    }

    static <clinit>() {
        new PrivacyConfigStatus("UNKNOWN", 0);
        UNKNOWN = new PrivacyConfigStatus(..);
        new PrivacyConfigStatus("ALLOWED", 1);
        ALLOWED = new PrivacyConfigStatus(..);
        new PrivacyConfigStatus("DENIED", 2);
        DENIED = new PrivacyConfigStatus(..);
        PrivacyConfigStatus.$values();
        $VALUES = PrivacyConfigStatus.$values(..);
        return;
    }

    private PrivacyConfigStatus(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static PrivacyConfigStatus valueOf(String p0) {
        Enum.valueOf(PrivacyConfigStatus.class, p0);
        return Enum.valueOf(..);
    }

    public static PrivacyConfigStatus[] values() {
        PrivacyConfigStatus.$VALUES.clone();
        return PrivacyConfigStatus[].clone(..);
    }

    public String toLowerCase() {
        PrivacyConfigStatus.name();
        PrivacyConfigStatus.name(..).toLowerCase();
        return String.toLowerCase(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.PrivacyConfigStorage
// ============================================================
package com.unity3d.services.core.configuration;

public class PrivacyConfigStorage extends Observable {
    private static PrivacyConfigStorage _instance;
    private PrivacyConfig _privacyConfig;

    private PrivacyConfigStorage() {
        new Observable();
        new PrivacyConfig();
        _privacyConfig = new PrivacyConfig(..);
        return;
    }

    public static PrivacyConfigStorage getInstance() {
        if (if-nez(PrivacyConfigStorage._instance)) goto L_b;
        new PrivacyConfigStorage();
        _instance = new PrivacyConfigStorage(..);
      L_b:
        return PrivacyConfigStorage._instance;
    }

    public PrivacyConfig getPrivacyConfig() {
        return _privacyConfig;
        throw _privacyConfig;
    }

    public void registerObserver(IObserver p0) {
        Observable.registerObserver(p0);
        _privacyConfig.getPrivacyStatus();
        if (if-eq(PrivacyConfig.getPrivacyStatus(..), PrivacyConfigStatus.UNKNOWN)) goto L_13;
        p0.updated(_privacyConfig);
      L_13:
        return;
        throw p0;
    }

    public void setPrivacyConfig(PrivacyConfig p0) {
        _privacyConfig = p0;
        PrivacyConfigStorage.notifyObservers(p0);
        return;
        throw p0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.PrivacyConfigurationLoader
// ============================================================
package com.unity3d.services.core.configuration;

public class PrivacyConfigurationLoader {
    private final IConfigurationLoader _configurationLoader;
    private final ConfigurationRequestFactory _configurationRequestFactory;
    private final HttpClient _httpClient;
    private final PrivacyConfigStorage _privacyConfigStorage;

    public PrivacyConfigurationLoader(IConfigurationLoader p0, ConfigurationRequestFactory p1, PrivacyConfigStorage p2, HttpClient p3) {
        new Object();
        _configurationLoader = p0;
        _configurationRequestFactory = p1;
        _privacyConfigStorage = p2;
        _httpClient = p3;
        return;
    }

    static PrivacyConfigStorage access$000(PrivacyConfigurationLoader p0) {
        return _privacyConfigStorage;
    }

    private void load(IPrivacyConfigurationListener p0) {
        _configurationRequestFactory.getWebRequest();
        WebRequestToHttpRequestKt.toHttpRequest(ConfigurationRequestFactory.getWebRequest(..));
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.didPrivacyConfigRequestStart();
        _httpClient.executeBlocking(WebRequestToHttpRequestKt.toHttpRequest(..));
        HttpClient.executeBlocking(..).getStatusCode();
        if (if-ne(HttpResponse.getStatusCode(..), 2)) goto L_28;
      L_28:
      L_29:
        if (if-eqz(0)) goto L_48;
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.didPrivacyConfigRequestEnd(1);
        HttpClient.executeBlocking(..).getBody();
        HttpResponse.getBody(..).toString();
        new JSONObject(Object.toString(..));
        new PrivacyConfig(new JSONObject(..));
        p0.onSuccess(new PrivacyConfig(..));
      L_48:
        Object.toString(..).getStatusCode();
        if (if-ne(HttpResponse.getStatusCode(..), 423)) goto L_6d;
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.didPrivacyConfigRequestEnd(0);
        new StringBuilder(new PrivacyConfig(..));
        ClientProperties.getGameId();
        new StringBuilder(..).append(ClientProperties.getGameId(..));
        new StringBuilder(..).toString();
        p0.onError(PrivacyCallError.LOCKED_423, StringBuilder.toString(..));
      L_6d:
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.didPrivacyConfigRequestEnd(0);
        new StringBuilder(PrivacyCallError.LOCKED_423);
        new StringBuilder(..).getStatusCode();
        new StringBuilder(..).append(HttpResponse.getStatusCode(..));
        new StringBuilder(..).toString();
        p0.onError(PrivacyCallError.NETWORK_ISSUE, StringBuilder.toString(..));
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.didPrivacyConfigRequestEnd(0);
        p0.onError(PrivacyCallError.NETWORK_ISSUE, "Could not create web request");
      L_98:
        return;
        new StringBuilder("Could not create web request: ");
        new StringBuilder(..).append(PrivacyCallError.NETWORK_ISSUE);
        new StringBuilder(..).toString();
        p0.onError(PrivacyCallError.NETWORK_ISSUE, StringBuilder.toString(..));
        return;
    }

    public Configuration getLocalConfiguration() {
        _configurationLoader.getLocalConfiguration();
        return IConfigurationLoader.getLocalConfiguration(..);
    }

    public void loadConfiguration(IConfigurationLoaderListener p0) {
        new AtomicBoolean(0);
        _privacyConfigStorage.getPrivacyConfig();
        PrivacyConfig.getPrivacyStatus();
        if (if-ne(PrivacyConfig.getPrivacyStatus(..), PrivacyConfigStatus.UNKNOWN)) goto L_1c;
        new PrivacyConfigurationLoader$1(this, new AtomicBoolean(..));
        PrivacyConfigurationLoader.load(new PrivacyConfigurationLoader$1(..));
      L_1c:
        new AtomicBoolean(..).get();
        if (if-nez(AtomicBoolean.get(..))) goto L_28;
        _configurationLoader.loadConfiguration(p0);
        return;
      L_28:
        new AbortRetryException("Game is disabled");
        throw new AbortRetryException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.CoreModuleConfiguration$1
// ============================================================
package com.unity3d.services.core.configuration;

class CoreModuleConfiguration$1 {
    final CoreModuleConfiguration this$0;
    final UnityAds$UnityAdsInitializationError val$error;
    final String val$message;

    CoreModuleConfiguration$1(CoreModuleConfiguration p0, UnityAds$UnityAdsInitializationError p1, String p2) {
        this$0 = p0;
        val$error = p1;
        val$message = p2;
        new Object();
        return;
    }

    public void run() {
        SdkProperties.notifyInitializationFailed(val$error, val$message);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.CoreModuleConfiguration$2
// ============================================================
package com.unity3d.services.core.configuration;

class CoreModuleConfiguration$2 {
    final CoreModuleConfiguration this$0;

    CoreModuleConfiguration$2(CoreModuleConfiguration p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void run() {
        SdkProperties.notifyInitializationComplete();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.CoreModuleConfiguration$3
// ============================================================
package com.unity3d.services.core.configuration;

class CoreModuleConfiguration$3 {
    static final int[] $SwitchMap$com$unity3d$services$core$configuration$ErrorState;

    static <clinit>() {
        ErrorState.values();
        $SwitchMap$com$unity3d$services$core$configuration$ErrorState = ErrorState.values(..);
        ErrorState.CreateWebApp.ordinal();
        ErrorState.InitModules.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializationNotificationCenter$1
// ============================================================
package com.unity3d.services.core.configuration;

class InitializationNotificationCenter$1 {
    final InitializationNotificationCenter this$0;
    final Map$Entry val$entry;

    InitializationNotificationCenter$1(InitializationNotificationCenter p0, Map$Entry p1) {
        this$0 = p0;
        val$entry = p1;
        new Object();
        return;
    }

    public void run() {
        Map$Entry.getValue();
        Map$Entry.getValue(..).onSdkInitialized();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializationNotificationCenter$2
// ============================================================
package com.unity3d.services.core.configuration;

class InitializationNotificationCenter$2 {
    final InitializationNotificationCenter this$0;
    final int val$code;
    final Map$Entry val$entry;
    final ErrorState val$errorState;
    final String val$exceptionMessage;

    InitializationNotificationCenter$2(InitializationNotificationCenter p0, Map$Entry p1, String p2, ErrorState p3, int p4) {
        this$0 = p0;
        val$entry = p1;
        val$exceptionMessage = p2;
        val$errorState = p3;
        val$code = p4;
        new Object();
        return;
    }

    public void run() {
        Map$Entry.getValue();
        Map$Entry.getValue(..).onSdkInitializationFailed(val$exceptionMessage, val$errorState, val$code);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeEventsMetricSender$1
// ============================================================
package com.unity3d.services.core.configuration;

class InitializeEventsMetricSender$1 extends HashMap {
    final InitializeEventsMetricSender this$0;

    InitializeEventsMetricSender$1(InitializeEventsMetricSender p0) {
        this$0 = p0;
        new HashMap();
        InitializeEventsMetricSender.access$000(p0);
        String.valueOf(InitializeEventsMetricSender.access$000(..));
        new HashMap(..).put("c_retry", String.valueOf(..));
        InitializeEventsMetricSender.access$100(p0);
        String.valueOf(InitializeEventsMetricSender.access$100(..));
        new HashMap(..).put("wv_retry", String.valueOf(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$1
// ============================================================
package com.unity3d.services.core.configuration;

class InitializeThread$1 {
    final InitializeThread this$0;

    InitializeThread$1(InitializeThread p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void run() {
        SdkProperties.notifyInitializationFailed(UnityAds$UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK encountered an error during initialization, cancel initialization");
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$2
// ============================================================
package com.unity3d.services.core.configuration;

class InitializeThread$2 {
    final InitializeThread this$0;

    InitializeThread$2(InitializeThread p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void run() {
        SdkProperties.notifyInitializationFailed(UnityAds$UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to application doesn't have enough memory to initialize Unity Ads SDK");
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeState
// ============================================================
package com.unity3d.services.core.configuration;

abstract class InitializeThread$InitializeState {
    private InitializeThread$InitializeState() {
        new Object();
        return;
    }

    InitializeThread$InitializeState(InitializeThread$1 p0) {
        new InitializeThread$InitializeState();
        return;
    }

    public abstract InitializeThread$InitializeState execute() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateCheckForCachedWebViewUpdate
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateCheckForCachedWebViewUpdate extends InitializeThread$InitializeState {
    private Configuration _configuration;

    public InitializeThread$InitializeStateCheckForCachedWebViewUpdate(Configuration p0) {
        new InitializeThread$InitializeState(0);
        _configuration = p0;
        return;
    }

    public InitializeThread$InitializeState execute() {
        SdkProperties.getLocalWebViewFile();
        new File(SdkProperties.getLocalWebViewFile(..));
        InitializeThread.access$400(new File(..));
        Utilities.Sha256(InitializeThread.access$400(..));
        _configuration.getWebViewHash();
        Utilities.Sha256(..).equals(Configuration.getWebViewHash(..));
        if (if-eqz(String.equals(..))) goto L_2c;
        new String(InitializeThread.access$400(..), "UTF-8");
        new InitializeThread$InitializeStateUpdateCache(_configuration, new String(..));
        return new InitializeThread$InitializeStateUpdateCache(..);
      L_2c:
        new InitializeThread$InitializeStateDownloadWebView(_configuration);
        return new InitializeThread$InitializeStateDownloadWebView(..);
    }

    public Configuration getConfiguration() {
        return _configuration;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateCheckForUpdatedWebView
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateCheckForUpdatedWebView extends InitializeThread$InitializeState {
    private Configuration _configuration;
    private Configuration _localWebViewConfiguration;
    private byte[] _localWebViewData;

    public InitializeThread$InitializeStateCheckForUpdatedWebView(Configuration p0, byte[] p1, Configuration p2) {
        new InitializeThread$InitializeState(0);
        _configuration = p0;
        _localWebViewData = p1;
        _localWebViewConfiguration = p2;
        return;
    }

    public InitializeThread$InitializeState execute() {
        Utilities.Sha256(_localWebViewData);
        _configuration.getWebViewHash();
        Utilities.Sha256(..).equals(Configuration.getWebViewHash(..));
        if (if-nez(String.equals(..))) goto L_17;
        SdkProperties.setLatestConfiguration(_configuration);
      L_17:
        TextUtils.isEmpty(Utilities.Sha256(..));
        if (if-nez(TextUtils.isEmpty(..))) goto L_71;
        if (if-eqz(_localWebViewConfiguration)) goto L_54;
        _localWebViewConfiguration.getWebViewHash();
        if (if-eqz(Configuration.getWebViewHash(..))) goto L_54;
        _localWebViewConfiguration.getWebViewHash();
        Configuration.getWebViewHash(..).equals(Utilities.Sha256(..));
        if (if-eqz(String.equals(..))) goto L_54;
        SdkProperties.getVersionName();
        _localWebViewConfiguration.getSdkVersion();
        SdkProperties.getVersionName(..).equals(Configuration.getSdkVersion(..));
        if (if-eqz(String.equals(..))) goto L_54;
        new String(_localWebViewData, "UTF-8");
        new InitializeThread$InitializeStateCreate(_localWebViewConfiguration, new String(..));
        return new InitializeThread$InitializeStateCreate(..);
      L_54:
        if (if-eqz(_configuration)) goto L_71;
        _configuration.getWebViewHash();
        Configuration.getWebViewHash(..).equals(new String(..));
        if (if-eqz(String.equals(..))) goto L_71;
        new String(_localWebViewData, _localWebViewConfiguration);
        new InitializeThread$InitializeStateCreate(_configuration, new String(..));
        return new InitializeThread$InitializeStateCreate(..);
      L_71:
        new InitializeThread$InitializeStateLoadWeb(_configuration);
        new InitializeThread$InitializeStateCleanCache(_configuration, new InitializeThread$InitializeStateLoadWeb(..));
        return new InitializeThread$InitializeStateCleanCache(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateCleanCache
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateCleanCache extends InitializeThread$InitializeState {
    private Configuration _configuration;
    private InitializeThread$InitializeState _nextState;

    public InitializeThread$InitializeStateCleanCache(Configuration p0, InitializeThread$InitializeState p1) {
        new InitializeThread$InitializeState(0);
        _configuration = p0;
        _nextState = p1;
        return;
    }

    public InitializeThread$InitializeState execute() {
        SdkProperties.getLocalConfigurationFilepath();
        new File(SdkProperties.getLocalConfigurationFilepath(..));
        SdkProperties.getLocalWebViewFile();
        new File(SdkProperties.getLocalWebViewFile(..));
        new File(..).delete();
        new File(..).delete();
        new StringBuilder("Failure trying to clean cache: ");
        new File(..).getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
      L_2f:
        return _nextState;
    }

    public Configuration getConfiguration() {
        return _configuration;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateCleanCacheIgnoreError
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateCleanCacheIgnoreError extends InitializeThread$InitializeStateCleanCache {
    public InitializeThread$InitializeStateCleanCacheIgnoreError(Configuration p0, InitializeThread$InitializeState p1) {
        new InitializeThread$InitializeStateCleanCache(p0, p1);
        return;
    }

    public InitializeThread$InitializeState execute() {
        InitializeThread$InitializeStateCleanCache.execute();
        if (if-nez(v1)) goto L_9;
        return InitializeThread$InitializeStateCleanCache.execute(..);
      L_9:
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateComplete
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateComplete extends InitializeThread$InitializeState {
    private Configuration _configuration;

    public InitializeThread$InitializeStateComplete(Configuration p0) {
        new InitializeThread$InitializeState(0);
        _configuration = p0;
        return;
    }

    public InitializeThread$InitializeState execute() {
        _configuration.getModuleConfigurationList();
      L_8:
        if (if-ge(0, v1)) goto L_1c;
        _configuration.getModuleConfiguration(v3);
        if (if-eqz(Configuration.getModuleConfiguration(..))) goto L_19;
        IModuleConfiguration.initCompleteState(_configuration);
      L_19:
      L_1c:
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateConfig
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateConfig extends InitializeThread$InitializeState {
    private Configuration _configuration;
    private Configuration _localConfig;
    private int _maxRetries;
    private InitializeThread$InitializeState _nextState;
    private int _retries;
    private long _retryDelay;
    private double _scalingFactor;

    public InitializeThread$InitializeStateConfig(Configuration p0) {
        new InitializeThread$InitializeState(0);
        SdkProperties.getConfigUrl();
        p0.getExperimentsReader();
        new Configuration(SdkProperties.getConfigUrl(..), Configuration.getExperimentsReader(..));
        _configuration = new Configuration(..);
        _retries = 0;
        p0.getRetryDelay();
        _retryDelay = Configuration.getRetryDelay(..);
        p0.getMaxRetries();
        _maxRetries = Configuration.getMaxRetries(..);
        p0.getRetryScalingFactor();
        _scalingFactor = Configuration.getRetryScalingFactor(..);
        _localConfig = p0;
        _nextState = 0;
        return;
    }

    static Configuration access$100(InitializeThread$InitializeStateConfig p0) {
        return _configuration;
    }

    static Configuration access$102(InitializeThread$InitializeStateConfig p0, Configuration p1) {
        _configuration = p1;
        return p1;
    }

    static InitializeThread$InitializeState access$202(InitializeThread$InitializeStateConfig p0, InitializeThread$InitializeState p1) {
        _nextState = p1;
        return p1;
    }

    static Configuration access$300(InitializeThread$InitializeStateConfig p0) {
        return _localConfig;
    }

    public InitializeThread$InitializeState execute() {
        new StringBuilder("Unity Ads init: load configuration from ");
        SdkProperties.getConfigUrl();
        new StringBuilder(..).append(SdkProperties.getConfigUrl(..));
        new StringBuilder(..).toString();
        DeviceLog.info(StringBuilder.toString(..));
        InitializeThread$InitializeStateConfig.executeWithLoader();
        return InitializeThread$InitializeStateConfig.executeWithLoader(..);
    }

    public InitializeThread$InitializeState executeLegacy(Configuration p0) {
        p0.makeRequest();
        p0.getDelayWebViewUpdate();
        if (if-eqz(Configuration.getDelayWebViewUpdate(..))) goto L_11;
        new InitializeThread$InitializeStateLoadCacheConfigAndWebView(p0, _localConfig);
        return new InitializeThread$InitializeStateLoadCacheConfigAndWebView(..);
      L_11:
        new InitializeThread$InitializeStateLoadCache(p0);
        return new InitializeThread$InitializeStateLoadCache(..);
        if (if-ge(_retries, _maxRetries)) goto L_3c;
        _retryDelay = _retryDelay;
        _retries = _retries;
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.onRetryConfig();
        new InitializeThread$InitializeStateRetry(this, _retryDelay, _maxRetries);
        return new InitializeThread$InitializeStateRetry(..);
      L_3c:
        new InitializeThread$InitializeStateNetworkError(ErrorState.NetworkConfigRequest, new InitializeThread$InitializeStateRetry(..), this, _localConfig);
        return new InitializeThread$InitializeStateNetworkError(..);
    }

    public InitializeThread$InitializeState executeWithLoader() {
        Utilities.getService(SDKMetricsSender.class);
        Utilities.getService(HttpClient.class);
        PrivacyConfigStorage.getInstance();
        new DeviceInfoDataFactory(Utilities.getService(..));
        new DeviceInfoDataFactory(..).getDeviceInfoData(InitRequestType.TOKEN);
        new ConfigurationRequestFactory(_configuration, DeviceInfoDataFactory.getDeviceInfoData(..));
        new ConfigurationLoader(new ConfigurationRequestFactory(..), Utilities.getService(..), Utilities.getService(..));
        new DeviceInfoDataFactory(..).getDeviceInfoData(InitRequestType.PRIVACY);
        new ConfigurationRequestFactory(_configuration, DeviceInfoDataFactory.getDeviceInfoData(..));
        new PrivacyConfigurationLoader(new ConfigurationLoader(..), new ConfigurationRequestFactory(..), PrivacyConfigStorage.getInstance(..), Utilities.getService(..));
        SdkProperties.getConfigUrl();
        new Configuration(SdkProperties.getConfigUrl(..));
        new InitializeThread$InitializeStateConfig$1(this, Utilities.getService(..), new Configuration(..));
        new PrivacyConfigurationLoader(..).loadConfiguration(new InitializeThread$InitializeStateConfig$1(..));
        return _nextState;
        if (if-ge(_retries, _maxRetries)) goto L_74;
        _retryDelay = _retryDelay;
        _retries = _retries;
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.onRetryConfig();
        new InitializeThread$InitializeStateRetry(this, _retryDelay, _retryDelay);
        return new InitializeThread$InitializeStateRetry(..);
      L_74:
        new InitializeThread$InitializeStateNetworkError(ErrorState.NetworkConfigRequest, new InitializeThread$InitializeStateRetry(..), this, _configuration);
        return new InitializeThread$InitializeStateNetworkError(..);
    }

    public Configuration getConfiguration() {
        return _configuration;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateConfig$1
// ============================================================
package com.unity3d.services.core.configuration;

class InitializeThread$InitializeStateConfig$1 {
    final InitializeThread$InitializeStateConfig this$0;
    final Configuration val$legacyConfiguration;
    final SDKMetricsSender val$sdkMetricsSender;

    InitializeThread$InitializeStateConfig$1(InitializeThread$InitializeStateConfig p0, SDKMetricsSender p1, Configuration p2) {
        this$0 = p0;
        val$sdkMetricsSender = p1;
        val$legacyConfiguration = p2;
        new Object();
        return;
    }

    public void onError(String p0) {
        TSIMetric.newEmergencySwitchOff();
        SDKMetricsSender.sendMetric(TSIMetric.newEmergencySwitchOff(..));
        this$0.executeLegacy(val$legacyConfiguration);
        InitializeThread$InitializeStateConfig.access$202(this$0, InitializeThread$InitializeStateConfig.executeLegacy(..));
        return;
    }

    public void onSuccess(Configuration p0) {
        InitializeThread$InitializeStateConfig.access$102(this$0, p0);
        InitializeThread$InitializeStateConfig.access$100(this$0);
        Configuration.saveToDisk();
        InitializeThread$InitializeStateConfig.access$100(this$0);
        Configuration.getDelayWebViewUpdate();
        if (if-eqz(Configuration.getDelayWebViewUpdate(..))) goto L_2e;
        InitializeThread$InitializeStateConfig.access$100(this$0);
        InitializeThread$InitializeStateConfig.access$300(this$0);
        new InitializeThread$InitializeStateLoadCacheConfigAndWebView(InitializeThread$InitializeStateConfig.access$100(..), InitializeThread$InitializeStateConfig.access$300(..));
        InitializeThread$InitializeStateConfig.access$202(this$0, new InitializeThread$InitializeStateLoadCacheConfigAndWebView(..));
      L_2e:
        Utilities.getService(TokenStorage.class);
        InitializeThread$InitializeStateConfig.access$100(this$0);
        Configuration.getUnifiedAuctionToken();
        Utilities.getService(..).setInitToken(Configuration.getUnifiedAuctionToken(..));
        InitializeThread$InitializeStateConfig.access$100(this$0);
        new InitializeThread$InitializeStateLoadCache(InitializeThread$InitializeStateConfig.access$100(..));
        InitializeThread$InitializeStateConfig.access$202(this$0, new InitializeThread$InitializeStateLoadCache(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateCreate
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateCreate extends InitializeThread$InitializeState {
    private Configuration _configuration;
    private String _webViewData;

    public InitializeThread$InitializeStateCreate(Configuration p0, String p1) {
        new InitializeThread$InitializeState(0);
        _configuration = p0;
        _webViewData = p1;
        return;
    }

    public InitializeThread$InitializeState execute() {
        DeviceLog.debug("Unity Ads init: creating webapp");
        _configuration.setWebViewData(_webViewData);
        WebViewApp.create(_configuration, 0);
        if (if-nez(WebViewApp.create(..))) goto L_1b;
        new InitializeThread$InitializeStateComplete(_configuration);
        return new InitializeThread$InitializeStateComplete(..);
      L_1b:
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getWebAppFailureMessage();
        if (if-eqz(WebViewApp.getWebAppFailureMessage(..))) goto L_2e;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getWebAppFailureMessage();
      L_2e:
      L_30:
        DeviceLog.error("Unity Ads WebApp creation failed");
        new Exception("Unity Ads WebApp creation failed");
        new InitializeThread$InitializeStateError(new InitializeThread$InitializeStateComplete(..), new Exception(..), _configuration);
        return new InitializeThread$InitializeStateError(..);
        DeviceLog.exception("Illegal Thread", new InitializeThread$InitializeStateComplete(..));
        new InitializeThread$InitializeStateError(ErrorState.CreateWebApp, new InitializeThread$InitializeStateComplete(..), _configuration);
        return new InitializeThread$InitializeStateError(..);
    }

    public Configuration getConfiguration() {
        return _configuration;
    }

    public String getWebData() {
        return _webViewData;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateCreateWithRemote
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateCreateWithRemote extends InitializeThread$InitializeState {
    private Configuration _configuration;

    public InitializeThread$InitializeStateCreateWithRemote(Configuration p0) {
        new InitializeThread$InitializeState(0);
        _configuration = p0;
        return;
    }

    public InitializeThread$InitializeState execute() {
        DeviceLog.debug("Unity Ads init: creating webapp");
        WebViewApp.create(_configuration, 1);
        if (if-nez(WebViewApp.create(..))) goto L_16;
        new InitializeThread$InitializeStateComplete(_configuration);
        return new InitializeThread$InitializeStateComplete(..);
      L_16:
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getWebAppFailureMessage();
        if (if-eqz(WebViewApp.getWebAppFailureMessage(..))) goto L_29;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getWebAppFailureMessage();
      L_29:
      L_2b:
        DeviceLog.error("Unity Ads WebApp creation failed");
        new Exception("Unity Ads WebApp creation failed");
        new InitializeThread$InitializeStateError(new InitializeThread$InitializeStateComplete(..), new Exception(..), _configuration);
        return new InitializeThread$InitializeStateError(..);
        DeviceLog.exception("Illegal Thread", new InitializeThread$InitializeStateComplete(..));
        new InitializeThread$InitializeStateError(ErrorState.CreateWebApp, new InitializeThread$InitializeStateComplete(..), _configuration);
        return new InitializeThread$InitializeStateError(..);
    }

    public Configuration getConfiguration() {
        return _configuration;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateDownloadWebView
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateDownloadWebView extends InitializeThread$InitializeState {
    private Configuration _configuration;
    private HttpClient _httpClient;
    private int _retries;
    private long _retryDelay;

    public InitializeThread$InitializeStateDownloadWebView(Configuration p0) {
        new InitializeThread$InitializeState(0);
        Utilities.getService(HttpClient.class);
        _httpClient = Utilities.getService(..);
        _configuration = p0;
        _retries = 0;
        p0.getRetryDelay();
        _retryDelay = Configuration.getRetryDelay(..);
        return;
    }

    public InitializeThread$InitializeState execute() {
        new StringBuilder("Unity Ads init: downloading webapp from ");
        _configuration.getWebViewUrl();
        new StringBuilder(..).append(Configuration.getWebViewUrl(..));
        new StringBuilder(..).toString();
        DeviceLog.info(StringBuilder.toString(..));
        _configuration.getWebViewUrl();
        new HttpRequest(Configuration.getWebViewUrl(..));
        _httpClient.executeBlocking(new HttpRequest(..));
        HttpClient.executeBlocking(..).getBody();
        HttpResponse.getBody(..).toString();
        _configuration.getWebViewHash();
        if (if-eqz(Object.toString(..))) goto L_4c;
        if (if-eqz(Configuration.getWebViewHash(..))) goto L_4c;
        Utilities.Sha256(Object.toString(..));
        Utilities.Sha256(..).equals(Configuration.getWebViewHash(..));
        if (if-eqz(String.equals(..))) goto L_4c;
        new InitializeThread$InitializeStateUpdateCache(_configuration, Object.toString(..));
      L_4c:
        return new InitializeThread$InitializeStateUpdateCache(..);
        _configuration.getMaxRetries();
        if (if-ge(_retries, Configuration.getMaxRetries(..))) goto L_70;
        _configuration.getRetryScalingFactor();
        _retryDelay = _retryDelay;
        _retries = _retries;
        new InitializeThread$InitializeStateRetry(this, _retryDelay, _retries);
        return new InitializeThread$InitializeStateRetry(..);
      L_70:
        return _retryDelay;
        DeviceLog.exception("Malformed URL", _retries);
        return _retryDelay;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateError
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateError extends InitializeThread$InitializeState {
    protected Configuration _configuration;
    ErrorState _errorState;
    Exception _exception;

    public InitializeThread$InitializeStateError(ErrorState p0, Exception p1, Configuration p2) {
        new InitializeThread$InitializeState(0);
        _errorState = p0;
        _exception = p1;
        _configuration = p2;
        return;
    }

    public InitializeThread$InitializeState execute() {
        new StringBuilder("Unity Ads init: halting init in ");
        _errorState.getMetricName();
        new StringBuilder(..).append(ErrorState.getMetricName(..));
        new StringBuilder(..).append(": ");
        _exception.getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
        _configuration.getModuleConfigurationList();
      L_2d:
        if (if-ge(0, Exception.getMessage(..))) goto L_49;
        _configuration.getModuleConfiguration(v3);
        if (if-eqz(Configuration.getModuleConfiguration(..))) goto L_46;
        _exception.getMessage();
        IModuleConfiguration.initErrorState(_configuration, _errorState, Exception.getMessage(..));
      L_46:
      L_49:
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateForceReset
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateForceReset extends InitializeThread$InitializeStateReset {
    public InitializeThread$InitializeStateForceReset() {
        new Configuration();
        new InitializeThread$InitializeStateReset(new Configuration(..));
        return;
    }

    public InitializeThread$InitializeState execute() {
        SdkProperties.setInitializeState(SdkProperties$InitializationState.NOT_INITIALIZED);
        InitializeThread$InitializeStateReset.execute();
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateInitModules
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateInitModules extends InitializeThread$InitializeState {
    private Configuration _configuration;

    public InitializeThread$InitializeStateInitModules(Configuration p0) {
        new InitializeThread$InitializeState(0);
        _configuration = p0;
        return;
    }

    public InitializeThread$InitializeState execute() {
        new InitializeThread$InitializeStateConfig(_configuration);
        return new InitializeThread$InitializeStateConfig(..);
    }

    public Configuration getConfiguration() {
        return _configuration;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateLoadCache
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateLoadCache extends InitializeThread$InitializeState {
    private Configuration _configuration;

    public InitializeThread$InitializeStateLoadCache(Configuration p0) {
        new InitializeThread$InitializeState(0);
        _configuration = p0;
        return;
    }

    public InitializeThread$InitializeState execute() {
        DeviceLog.debug("Unity Ads init: check if webapp can be loaded from local cache");
        SdkProperties.getLocalWebViewFile();
        new File(SdkProperties.getLocalWebViewFile(..));
        Utilities.readFileBytes(new File(..));
        Utilities.Sha256(Utilities.readFileBytes(..));
        if (if-eqz(Utilities.Sha256(..))) goto L_43;
        _configuration.getWebViewHash();
        Utilities.Sha256(..).equals(Configuration.getWebViewHash(..));
        if (if-eqz(String.equals(..))) goto L_43;
        new String(Utilities.readFileBytes(..), "UTF-8");
        DeviceLog.info("Unity Ads init: webapp loaded from local cache");
        new InitializeThread$InitializeStateCreate(_configuration, new String(..));
        return new InitializeThread$InitializeStateCreate(..);
        new InitializeThread$InitializeStateError(ErrorState.LoadCache, new InitializeThread$InitializeStateCreate(..), _configuration);
        return new InitializeThread$InitializeStateError(..);
      L_43:
        new InitializeThread$InitializeStateLoadWeb(_configuration);
        return new InitializeThread$InitializeStateLoadWeb(..);
        new StringBuilder("Unity Ads init: webapp not found in local cache: ");
        Exception.getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        new InitializeThread$InitializeStateLoadWeb(_configuration);
        return new InitializeThread$InitializeStateLoadWeb(..);
    }

    public Configuration getConfiguration() {
        return _configuration;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateLoadCacheConfigAndWebView
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateLoadCacheConfigAndWebView extends InitializeThread$InitializeState {
    private Configuration _configuration;
    private Configuration _localConfig;

    public InitializeThread$InitializeStateLoadCacheConfigAndWebView(Configuration p0, Configuration p1) {
        new InitializeThread$InitializeState(0);
        _configuration = p0;
        _localConfig = p1;
        return;
    }

    public InitializeThread$InitializeState execute() {
        SdkProperties.getLocalWebViewFile();
        new File(SdkProperties.getLocalWebViewFile(..));
        InitializeThread.access$400(new File(..));
        new InitializeThread$InitializeStateCheckForUpdatedWebView(_configuration, InitializeThread.access$400(..), _localConfig);
        return new InitializeThread$InitializeStateCheckForUpdatedWebView(..);
        new InitializeThread$InitializeStateLoadWeb(_configuration);
        new InitializeThread$InitializeStateCleanCache(_configuration, new InitializeThread$InitializeStateLoadWeb(..));
        return new InitializeThread$InitializeStateCleanCache(..);
    }

    public Configuration getConfiguration() {
        return _configuration;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateLoadConfigFile
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateLoadConfigFile extends InitializeThread$InitializeState {
    private Configuration _configuration;

    public InitializeThread$InitializeStateLoadConfigFile(Configuration p0) {
        new InitializeThread$InitializeState(0);
        _configuration = p0;
        return;
    }

    public InitializeThread$InitializeState execute() {
        DeviceLog.debug("Unity Ads init: Loading Config File Parameters");
        SdkProperties.getLocalConfigurationFilepath();
        new File(SdkProperties.getLocalConfigurationFilepath(..));
        new File(..).exists();
        if (if-nez(File.exists(..))) goto L_1c;
        new InitializeThread$InitializeStateReset(_configuration);
        return new InitializeThread$InitializeStateReset(..);
      L_1c:
        Utilities.readFileBytes(new InitializeThread$InitializeStateReset(..));
        new String(Utilities.readFileBytes(..));
        new JSONObject(new String(..));
        new Configuration(new JSONObject(..));
        _configuration = new Configuration(..);
        DeviceLog.debug("Unity Ads init: Using default configuration parameters");
      L_37:
        new InitializeThread$InitializeStateReset(_configuration);
        return new InitializeThread$InitializeStateReset(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateLoadWeb
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateLoadWeb extends InitializeThread$InitializeState {
    private Configuration _configuration;
    private HttpClient _httpClient;
    private int _maxRetries;
    private int _retries;
    private long _retryDelay;
    private double _scalingFactor;

    public InitializeThread$InitializeStateLoadWeb(Configuration p0) {
        new InitializeThread$InitializeState(0);
        Utilities.getService(HttpClient.class);
        _httpClient = Utilities.getService(..);
        _configuration = p0;
        _retries = 0;
        p0.getRetryDelay();
        _retryDelay = Configuration.getRetryDelay(..);
        p0.getMaxRetries();
        _maxRetries = Configuration.getMaxRetries(..);
        p0.getRetryScalingFactor();
        _scalingFactor = Configuration.getRetryScalingFactor(..);
        return;
    }

    public InitializeThread$InitializeState execute() {
        new StringBuilder("Unity Ads init: loading webapp from ");
        _configuration.getWebViewUrl();
        new StringBuilder(..).append(Configuration.getWebViewUrl(..));
        new StringBuilder(..).toString();
        DeviceLog.info(StringBuilder.toString(..));
        _configuration.getWebViewUrl();
        new HttpRequest(Configuration.getWebViewUrl(..));
        _httpClient.executeBlocking(new HttpRequest(..));
        HttpClient.executeBlocking(..).getBody();
        HttpResponse.getBody(..).toString();
        _configuration.getWebViewHash();
        if (if-eqz(Configuration.getWebViewHash(..))) goto L_53;
        Utilities.Sha256(Object.toString(..));
        Utilities.Sha256(..).equals(Configuration.getWebViewHash(..));
        if (if-nez(String.equals(..))) goto L_53;
        new Exception("Invalid webViewHash");
        new InitializeThread$InitializeStateError(ErrorState.InvalidHash, new Exception(..), _configuration);
        return new InitializeThread$InitializeStateError(..);
      L_53:
        if (if-eqz(ErrorState.InvalidHash)) goto L_61;
        SdkProperties.getLocalWebViewFile();
        new File(SdkProperties.getLocalWebViewFile(..));
        Utilities.writeFile(new File(..), new InitializeThread$InitializeStateError(..));
      L_61:
        new InitializeThread$InitializeStateCreate(_configuration, new InitializeThread$InitializeStateError(..));
        return new InitializeThread$InitializeStateCreate(..);
        if (if-ge(_retries, _maxRetries)) goto L_8c;
        _retryDelay = _retryDelay;
        _retries = _retries;
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.onRetryWebview();
        new InitializeThread$InitializeStateRetry(this, _retryDelay, _retryDelay);
        return new InitializeThread$InitializeStateRetry(..);
      L_8c:
        new InitializeThread$InitializeStateNetworkError(ErrorState.NetworkWebviewRequest, new InitializeThread$InitializeStateRetry(..), this, _configuration);
        return new InitializeThread$InitializeStateNetworkError(..);
        DeviceLog.exception("Malformed URL", new InitializeThread$InitializeStateRetry(..));
        new InitializeThread$InitializeStateError(ErrorState.MalformedWebviewRequest, new InitializeThread$InitializeStateRetry(..), _configuration);
        return new InitializeThread$InitializeStateError(..);
    }

    public Configuration getConfiguration() {
        return _configuration;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateNetworkError
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateNetworkError extends InitializeThread$InitializeStateError {
    private static long _lastConnectedEventTimeMs;
    private static int _receivedConnectedEvents;
    private ConditionVariable _conditionVariable;
    private int _connectedEventThreshold;
    private InitializeThread$InitializeState _erroredState;
    private int _maximumConnectedEvents;
    private long _networkErrorTimeout;
    private ErrorState _state;

    public InitializeThread$InitializeStateNetworkError(ErrorState p0, Exception p1, InitializeThread$InitializeState p2, Configuration p3) {
        new InitializeThread$InitializeStateError(p0, p1, p3);
        _state = p0;
        _receivedConnectedEvents = 0;
        _lastConnectedEventTimeMs = 0L;
        _erroredState = p2;
        p3.getNetworkErrorTimeout();
        _networkErrorTimeout = Configuration.getNetworkErrorTimeout(..);
        p3.getMaximumConnectedEvents();
        _maximumConnectedEvents = Configuration.getMaximumConnectedEvents(..);
        p3.getConnectedEventThreshold();
        _connectedEventThreshold = Configuration.getConnectedEventThreshold(..);
        return;
    }

    private boolean shouldHandleConnectedEvent() {
        System.currentTimeMillis();
        if (if-ltz(System.currentTimeMillis(..))) goto L_16;
        if (if-gt(InitializeThread$InitializeStateNetworkError._receivedConnectedEvents, _maximumConnectedEvents)) goto L_16;
        return 1;
      L_16:
        return 0;
    }

    public InitializeThread$InitializeState execute() {
        DeviceLog.error("Unity Ads init: network error, waiting for connection events");
        new ConditionVariable();
        _conditionVariable = new ConditionVariable(..);
        ConnectivityMonitor.addListener(this);
        _conditionVariable.block(_networkErrorTimeout, v2);
        if (if-eqz(ConditionVariable.block(..))) goto L_1f;
        ConnectivityMonitor.removeListener(this);
        return _erroredState;
      L_1f:
        ConnectivityMonitor.removeListener(this);
        new Exception("No connected events within the timeout!");
        new InitializeThread$InitializeStateError(_state, new Exception(..), _configuration);
        return new InitializeThread$InitializeStateError(..);
    }

    public void onConnected() {
        _receivedConnectedEvents = InitializeThread$InitializeStateNetworkError._receivedConnectedEvents;
        DeviceLog.debug("Unity Ads init got connected event");
        InitializeThread$InitializeStateNetworkError.shouldHandleConnectedEvent();
        if (if-eqz(InitializeThread$InitializeStateNetworkError.shouldHandleConnectedEvent(..))) goto L_16;
        _conditionVariable.open();
      L_16:
        if (if-le(InitializeThread$InitializeStateNetworkError._receivedConnectedEvents, _maximumConnectedEvents)) goto L_1f;
        ConnectivityMonitor.removeListener(this);
      L_1f:
        System.currentTimeMillis();
        _lastConnectedEventTimeMs = System.currentTimeMillis(..);
        return;
    }

    public void onDisconnected() {
        DeviceLog.debug("Unity Ads init got disconnected event");
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateReset
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateReset extends InitializeThread$InitializeState {
    private Configuration _configuration;
    private int _resetWebAppTimeout;

    public InitializeThread$InitializeStateReset(Configuration p0) {
        new InitializeThread$InitializeState(0);
        _configuration = p0;
        p0.getResetWebappTimeout();
        _resetWebAppTimeout = Configuration.getResetWebappTimeout(..);
        return;
    }

    private void unregisterLifecycleCallbacks() {
        Lifecycle.getLifecycleListener();
        if (if-eqz(Lifecycle.getLifecycleListener(..))) goto L_1b;
        ClientProperties.getApplication();
        if (if-eqz(ClientProperties.getApplication(..))) goto L_17;
        ClientProperties.getApplication();
        Lifecycle.getLifecycleListener();
        ClientProperties.getApplication(..).unregisterActivityLifecycleCallbacks(Lifecycle.getLifecycleListener(..));
      L_17:
        Lifecycle.setLifecycleListener(0);
      L_1b:
        return;
    }

    public InitializeThread$InitializeState execute() {
        DeviceLog.debug("Unity Ads init: starting init");
        new ConditionVariable();
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_3d;
        WebViewApp.getCurrentApp(..).resetWebViewAppInitialization();
        WebViewApp.getCurrentApp(..).getWebView();
        if (if-eqz(WebViewApp.getWebView(..))) goto L_29;
        new InitializeThread$InitializeStateReset$1(this, WebViewApp.getCurrentApp(..), new ConditionVariable(..));
        Utilities.runOnUiThread(new InitializeThread$InitializeStateReset$1(..));
        new ConditionVariable(..).block(_resetWebAppTimeout, new InitializeThread$InitializeStateReset$1(..));
      L_29:
      L_2a:
        if (if-nez(1)) goto L_3d;
        new Exception("Reset failed on opening ConditionVariable");
        new InitializeThread$InitializeStateError(ErrorState.ResetWebApp, new Exception(..), _configuration);
        return new InitializeThread$InitializeStateError(..);
      L_3d:
        InitializeThread$InitializeStateReset.unregisterLifecycleCallbacks();
        SdkProperties.setCacheDirectory(0);
        SdkProperties.getCacheDirectory();
        if (if-nez(SdkProperties.getCacheDirectory(..))) goto L_5b;
        new Exception("Cache directory is NULL");
        new InitializeThread$InitializeStateError(ErrorState.ResetWebApp, new Exception(..), _configuration);
        return new InitializeThread$InitializeStateError(..);
      L_5b:
        SdkProperties.setWebViewCacheDirectory(new InitializeThread$InitializeStateError(..));
        SdkProperties.getWebViewCacheDirectory();
        if (if-nez(SdkProperties.getWebViewCacheDirectory(..))) goto L_75;
        new Exception("WebView cache directory is NULL");
        new InitializeThread$InitializeStateError(ErrorState.ResetWebApp, new Exception(..), _configuration);
        return new InitializeThread$InitializeStateError(..);
      L_75:
        SdkProperties.setInitialized(0);
        _configuration.getModuleConfigurationList();
      L_80:
        if (if-ge(0, new Exception(..))) goto L_94;
        _configuration.getModuleConfiguration(_configuration);
        if (if-eqz(Configuration.getModuleConfiguration(..))) goto L_91;
        IModuleConfiguration.resetState(_configuration);
      L_91:
      L_94:
        new InitializeThread$InitializeStateInitModules(_configuration);
        return new InitializeThread$InitializeStateInitModules(..);
    }

    public Configuration getConfiguration() {
        return _configuration;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateReset$1
// ============================================================
package com.unity3d.services.core.configuration;

class InitializeThread$InitializeStateReset$1 {
    final InitializeThread$InitializeStateReset this$0;
    final WebViewApp val$currentApp;
    final ConditionVariable val$cv;

    InitializeThread$InitializeStateReset$1(InitializeThread$InitializeStateReset p0, WebViewApp p1, ConditionVariable p2) {
        this$0 = p0;
        val$currentApp = p1;
        val$cv = p2;
        new Object();
        return;
    }

    public void run() {
        WebViewApp.getWebView();
        if (if-eqz(WebViewApp.getWebView(..))) goto L_11;
        WebViewApp.getWebView(..).destroy();
        WebViewApp.setWebView(0);
      L_11:
        ConditionVariable.open();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateRetry
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateRetry extends InitializeThread$InitializeState {
    long _delay;
    InitializeThread$InitializeState _state;

    public InitializeThread$InitializeStateRetry(InitializeThread$InitializeState p0, long p1) {
        new InitializeThread$InitializeState(0);
        _state = p0;
        _delay = p1;
        return;
    }

    public InitializeThread$InitializeState execute() {
        new StringBuilder("Unity Ads init: retrying in ");
        new StringBuilder(..).append(_delay, v2);
        new StringBuilder(..).append(" milliseconds");
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        Thread.sleep(_delay, " milliseconds");
        DeviceLog.exception("Init retry interrupted", _delay);
        Thread.currentThread();
        Thread.currentThread(..).interrupt();
      L_2b:
        return _state;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.InitializeThread$InitializeStateUpdateCache
// ============================================================
package com.unity3d.services.core.configuration;

public class InitializeThread$InitializeStateUpdateCache extends InitializeThread$InitializeState {
    private Configuration _configuration;
    private String _webViewData;

    public InitializeThread$InitializeStateUpdateCache(Configuration p0, String p1) {
        new InitializeThread$InitializeState(0);
        _configuration = p0;
        _webViewData = p1;
        return;
    }

    public InitializeThread$InitializeState execute() {
        if (if-eqz(_configuration)) goto L_32;
        if (if-eqz(_webViewData)) goto L_32;
        SdkProperties.getLocalWebViewFile();
        new File(SdkProperties.getLocalWebViewFile(..));
        Utilities.writeFile(new File(..), _webViewData);
        SdkProperties.getLocalConfigurationFilepath();
        new File(SdkProperties.getLocalConfigurationFilepath(..));
        _configuration.getFilteredJsonString();
        Utilities.writeFile(new File(..), Configuration.getFilteredJsonString(..));
        new InitializeThread$InitializeStateCleanCacheIgnoreError(_configuration, 0);
        return new InitializeThread$InitializeStateCleanCacheIgnoreError(..);
      L_32:
        return 0;
    }

    public Configuration getConfiguration() {
        return _configuration;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.configuration.PrivacyConfigurationLoader$1
// ============================================================
package com.unity3d.services.core.configuration;

class PrivacyConfigurationLoader$1 {
    final PrivacyConfigurationLoader this$0;
    final AtomicBoolean val$gameDisabled;

    PrivacyConfigurationLoader$1(PrivacyConfigurationLoader p0, AtomicBoolean p1) {
        this$0 = p0;
        val$gameDisabled = p1;
        new Object();
        return;
    }

    public void onError(PrivacyCallError p0, String p1) {
        new StringBuilder("Couldn't fetch privacy configuration: ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        DeviceLog.warning(StringBuilder.toString(..));
        PrivacyConfigurationLoader.access$000(this$0);
        new PrivacyConfig();
        PrivacyConfigStorage.setPrivacyConfig(new PrivacyConfig(..));
        if (if-ne(p0, PrivacyCallError.LOCKED_423)) goto L_29;
        AtomicBoolean.set(1);
      L_29:
        return;
    }

    public void onSuccess(PrivacyConfig p0) {
        PrivacyConfigurationLoader.access$000(this$0);
        PrivacyConfigStorage.setPrivacyConfig(p0);
        return;
    }

}

