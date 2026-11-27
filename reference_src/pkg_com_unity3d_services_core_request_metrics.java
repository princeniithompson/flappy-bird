// Package bundle: com.unity3d.services.core.request.metrics (26 classes)

// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.AdOperationError
// ============================================================
package com.unity3d.services.core.request.metrics;

public final class AdOperationError extends Enum {
    private static final AdOperationError[] $VALUES;
    public static final AdOperationError already_showing;
    public static final AdOperationError callback_error;
    public static final AdOperationError callback_timeout;
    public static final AdOperationError init_failed;
    public static final AdOperationError internal;
    public static final AdOperationError invalid;
    public static final AdOperationError no_connection;
    public static final AdOperationError no_fill;
    public static final AdOperationError not_ready;
    public static final AdOperationError player;
    public static final AdOperationError timeout;

    private static AdOperationError[] $values() {
        return 11;
    }

    static <clinit>() {
        new AdOperationError("init_failed", 0);
        init_failed = new AdOperationError(..);
        new AdOperationError("internal", 1);
        internal = new AdOperationError(..);
        new AdOperationError("invalid", 2);
        invalid = new AdOperationError(..);
        new AdOperationError("no_fill", 3);
        no_fill = new AdOperationError(..);
        new AdOperationError("timeout", 4);
        timeout = new AdOperationError(..);
        new AdOperationError("not_ready", 5);
        not_ready = new AdOperationError(..);
        new AdOperationError("player", 6);
        player = new AdOperationError(..);
        new AdOperationError("no_connection", 7);
        no_connection = new AdOperationError(..);
        new AdOperationError("already_showing", 8);
        already_showing = new AdOperationError(..);
        new AdOperationError("callback_error", 9);
        callback_error = new AdOperationError(..);
        new AdOperationError("callback_timeout", 10);
        callback_timeout = new AdOperationError(..);
        AdOperationError.$values();
        $VALUES = AdOperationError.$values(..);
        return;
    }

    private AdOperationError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static AdOperationError valueOf(String p0) {
        Enum.valueOf(AdOperationError.class, p0);
        return Enum.valueOf(..);
    }

    public static AdOperationError[] values() {
        AdOperationError.$VALUES.clone();
        return AdOperationError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.AdOperationMetric
// ============================================================
package com.unity3d.services.core.request.metrics;

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

    public AdOperationMetric() {
        new Object();
        return;
    }

    private static HashMap getTags(AdOperationError p0, boolean p1, boolean p2, Boolean p3) {
        if (if-nez(p0)) goto L_5;
      L_5:
        "unknown".toString();
      L_9:
        if (if-eqz(p2)) goto L_e;
      L_e:
      L_10:
        new AdOperationMetric$1(p1, AdOperationError.toString(..), "video", p3);
        return new AdOperationMetric$1(..);
    }

    private static AdOperationError mapUnityAdsLoadError(UnityAds$UnityAdsLoadError p0) {
        p0.ordinal();
        if (if-eq(UnityAds$UnityAdsLoadError.ordinal(..), 1)) goto L_25;
        if (if-eq(UnityAds$UnityAdsLoadError.ordinal(..), 2)) goto L_22;
        if (if-eq(UnityAds$UnityAdsLoadError.ordinal(..), 3)) goto L_1f;
        if (if-eq(UnityAds$UnityAdsLoadError.ordinal(..), 4)) goto L_1c;
        if (if-eq(UnityAds$UnityAdsLoadError.ordinal(..), 5)) goto L_19;
        return 0;
      L_19:
        return AdOperationError.timeout;
      L_1c:
        return AdOperationError.no_fill;
      L_1f:
        return AdOperationError.invalid;
      L_22:
        return AdOperationError.internal;
      L_25:
        return AdOperationError.init_failed;
    }

    private static AdOperationError mapUnityAdsShowError(UnityAds$UnityAdsShowError p0) {
        p0.ordinal();
        return 0;
        return AdOperationError.internal;
        return AdOperationError.already_showing;
        return AdOperationError.no_connection;
        return AdOperationError.invalid;
        return AdOperationError.player;
        return AdOperationError.not_ready;
        return AdOperationError.init_failed;
    }

    public static Metric newAdLoadFailure(UnityAds$UnityAdsLoadError p0, Long p1, boolean p2, boolean p3) {
        AdOperationMetric.mapUnityAdsLoadError(p0);
        AdOperationMetric.newAdLoadFailure(AdOperationMetric.mapUnityAdsLoadError(..), p1, p2, p3);
        return AdOperationMetric.newAdLoadFailure(..);
    }

    public static Metric newAdLoadFailure(AdOperationError p0, Long p1, boolean p2, boolean p3) {
        Boolean.valueOf(p3);
        AdOperationMetric.getTags(p0, 1, p2, Boolean.valueOf(..));
        new Metric("native_load_time_failure", p1, AdOperationMetric.getTags(..));
        return new Metric(..);
    }

    public static Metric newAdLoadStart(boolean p0, boolean p1) {
        Boolean.valueOf(p1);
        AdOperationMetric.getTags(0, 0, p0, Boolean.valueOf(..));
        new Metric("native_load_started", 0, AdOperationMetric.getTags(..));
        return new Metric(..);
    }

    public static Metric newAdLoadSuccess(Long p0, boolean p1, boolean p2) {
        Boolean.valueOf(p2);
        AdOperationMetric.getTags(0, 0, p1, Boolean.valueOf(..));
        new Metric("native_load_time_success", p0, AdOperationMetric.getTags(..));
        return new Metric(..);
    }

    public static Metric newAdShowFailure(UnityAds$UnityAdsShowError p0, Long p1) {
        AdOperationMetric.mapUnityAdsShowError(p0);
        AdOperationMetric.newAdShowFailure(AdOperationMetric.mapUnityAdsShowError(..), p1);
        return AdOperationMetric.newAdShowFailure(..);
    }

    public static Metric newAdShowFailure(AdOperationError p0, Long p1) {
        AdOperationMetric.getTags(p0, 1, 0, 0);
        new Metric("native_show_time_failure", p1, AdOperationMetric.getTags(..));
        return new Metric(..);
    }

    public static Metric newAdShowStart() {
        AdOperationMetric.getTags(0, 0, 0, 0);
        new Metric("native_show_started", 0, AdOperationMetric.getTags(..));
        return new Metric(..);
    }

    public static Metric newAdShowSuccess(Long p0) {
        AdOperationMetric.getTags(0, 0, 0, 0);
        new Metric("native_show_time_success", p0, AdOperationMetric.getTags(..));
        return new Metric(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.InitMetric
// ============================================================
package com.unity3d.services.core.request.metrics;

public class InitMetric {
    private static final String INIT_GAME_ID_CHANGED = "native_initialize_game_id_changed";
    private static final String INIT_GAME_ID_SAME = "native_initialize_game_id_same";
    private static final String INIT_TAG_GAME_ID = "game_id";
    private static final String INIT_TAG_PREVIOUS_GAME_ID = "previous_game_id";
    private static final String INIT_TAG_PREVIOUS_TEST_MODE = "previous_test_mode";
    private static final String INIT_TAG_TEST_MODE = "test_mode";
    private static final String INIT_TEST_MODE_CHANGED = "native_initialize_test_mode_changed";
    private static final String INIT_TEST_MODE_SAME = "native_initialize_test_mode_same";

    public InitMetric() {
        new Object();
        return;
    }

    public static Metric newInitGameIdChanged(String p0, String p1) {
        new InitMetric$1(p1, p0);
        new Metric("native_initialize_game_id_changed", 0, new InitMetric$1(..));
        return new Metric(..);
    }

    public static Metric newInitGameIdSame(String p0, String p1) {
        new InitMetric$2(p1, p0);
        new Metric("native_initialize_game_id_same", 0, new InitMetric$2(..));
        return new Metric(..);
    }

    public static Metric newInitTestModeChanged(Boolean p0, Boolean p1) {
        new InitMetric$3(p1, p0);
        new Metric("native_initialize_test_mode_changed", 0, new InitMetric$3(..));
        return new Metric(..);
    }

    public static Metric newInitTestModeSame(Boolean p0, Boolean p1) {
        new InitMetric$4(p1, p0);
        new Metric("native_initialize_test_mode_same", 0, new InitMetric$4(..));
        return new Metric(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.Metric
// ============================================================
package com.unity3d.services.core.request.metrics;

public final class Metric {
    public static final Metric$Companion Companion = null;
    private static final String METRIC_NAME = "n";
    private static final String METRIC_TAGS = "t";
    private static final String METRIC_VALUE = "v";
    private final String name;
    private final Map tags;
    private final Object value;

    static <clinit>() {
        new Metric$Companion(0);
        Companion = new Metric$Companion(..);
        return;
    }

    public Metric(String p0) {
        new Metric(p0, 0, 0, 6, 0);
        return;
    }

    public Metric(String p0, Object p1) {
        new Metric(p0, p1, 0, 4, 0);
        return;
    }

    public Metric(String p0, Object p1, Map p2) {
        new Object();
        name = p0;
        value = p1;
        tags = p2;
        return;
    }

    public Metric(String p0, Object p1, Map p2, int p3, DefaultConstructorMarker p4) {
        if (if-eqz(p4)) goto L_5;
      L_5:
        if (if-eqz(p3)) goto L_d;
        MapsKt.emptyMap();
      L_d:
        new Metric(p0, 0, MapsKt.emptyMap(..));
        return;
    }

    public static Metric copy$default(Metric p0, String p1, Object p2, Map p3, int p4, Object p5) {
        if (if-eqz(p5)) goto L_6;
      L_6:
        if (if-eqz(p5)) goto L_c;
      L_c:
        if (if-eqz(p4)) goto L_12;
      L_12:
        p0.copy(name, value, tags);
        return Metric.copy(..);
    }

    public final String component1() {
        return name;
    }

    public final Object component2() {
        return value;
    }

    public final Map component3() {
        return tags;
    }

    public final Metric copy(String p0, Object p1, Map p2) {
        new Metric(p0, p1, p2);
        return new Metric(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(name, name);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        Intrinsics.areEqual(value, value);
        if (if-nez(Intrinsics.areEqual(..))) goto L_22;
        return 0;
      L_22:
        Intrinsics.areEqual(tags, tags);
        if (if-nez(Intrinsics.areEqual(..))) goto L_2d;
        return 0;
      L_2d:
        return 1;
    }

    public final String getName() {
        return name;
    }

    public final Map getTags() {
        return tags;
    }

    public final Object getValue() {
        return value;
    }

    public int hashCode() {
        if (if-nez(name)) goto L_7;
      L_7:
        0.hashCode();
      L_b:
        if (if-nez(value)) goto L_12;
      L_12:
        Object.hashCode();
      L_16:
        tags.hashCode();
        return String.hashCode(..);
    }

    public final Map toMap() {
        MapsKt.createMapBuilder();
        if (if-eqz(name)) goto L_d;
        MapsKt.createMapBuilder(..).put("n", name);
      L_d:
        if (if-eqz(value)) goto L_16;
        MapsKt.createMapBuilder(..).put("v", value);
      L_16:
        tags.isEmpty();
        if (if-eqz(Map.isEmpty(..))) goto L_27;
        MapsKt.createMapBuilder(..).put("t", tags);
      L_27:
        MapsKt.build(MapsKt.createMapBuilder(..));
        return MapsKt.build(..);
    }

    public String toString() {
        new StringBuilder("Metric(name=");
        new StringBuilder(..).append(name);
        new StringBuilder(..).append(", value=");
        new StringBuilder(..).append(value);
        new StringBuilder(..).append(", tags=");
        new StringBuilder(..).append(tags);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.MetricCommonTags
// ============================================================
package com.unity3d.services.core.request.metrics;

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
    private Map _experiments;
    private String _mediationAdapter;
    private String _mediationName;
    private String _mediationVersion;
    private final String _platform;
    private String _privacyMode;
    private final IObserver _privacyObserver;
    private final String _sdkVersion;
    private final String _systemVersion;
    private final boolean _testMode;

    public MetricCommonTags() {
        new Object();
        new MetricCommonTags$1(new Object(..));
        _privacyObserver = new MetricCommonTags$1(..);
        Device.getNetworkCountryISO();
        _countryISO = Device.getNetworkCountryISO(..);
        _platform = "android";
        SdkProperties.getVersionName();
        _sdkVersion = SdkProperties.getVersionName(..);
        Device.getOsVersion();
        _systemVersion = Device.getOsVersion(..);
        PrivacyConfigStorage.getInstance();
        PrivacyConfigStorage.getInstance(..).getPrivacyConfig();
        PrivacyConfig.getPrivacyStatus();
        PrivacyConfig.getPrivacyStatus(..).toLowerCase();
        _privacyMode = PrivacyConfigStatus.toLowerCase(..);
        SdkProperties.isTestMode();
        _testMode = SdkProperties.isTestMode(..);
        PrivacyConfigStorage.getInstance();
        PrivacyConfigStorage.getInstance(..).registerObserver(new MetricCommonTags$1(..));
        return;
    }

    static String access$002(MetricCommonTags p0, String p1) {
        _privacyMode = p1;
        return p1;
    }

    private boolean mediationIsEmpty() {
        if (if-eqz(_mediationName)) goto L_d;
        _mediationName.isEmpty();
        if (if-eqz(String.isEmpty(..))) goto L_b;
      L_b:
      L_d:
      L_e:
        return 1;
    }

    private void refreshMediationData() {
        StorageManager.getStorage(StorageManager$StorageType.PUBLIC);
        if (if-eqz(StorageManager.getStorage(..))) goto L_3d;
        StorageManager.getStorage(..).initStorage();
        if (if-eqz(Storage.initStorage(..))) goto L_3d;
        StorageManager.getStorage(..).get("mediation.name.value");
        _mediationName = Storage.get(..);
        StorageManager.getStorage(..).get("mediation.version.value");
        _mediationVersion = Storage.get(..);
        StorageManager.getStorage(..).get("mediation.adapter_version.value");
        _mediationAdapter = Storage.get(..);
        Storage.get(..).getLocalizedMessage();
        DeviceLog.debug("Failed to refreshMediationData: %s", 1);
      L_3d:
        return;
    }

    public void shutdown() {
        PrivacyConfigStorage.getInstance();
        PrivacyConfigStorage.getInstance(..).unregisterObserver(_privacyObserver);
        return;
    }

    public Map toMap() {
        MetricCommonTags.mediationIsEmpty();
        if (if-eqz(MetricCommonTags.mediationIsEmpty(..))) goto L_9;
        MetricCommonTags.refreshMediationData();
      L_9:
        new HashMap();
        if (if-eqz(_countryISO)) goto L_17;
        new HashMap(..).put("iso", _countryISO);
      L_17:
        if (if-eqz(_platform)) goto L_20;
        new HashMap(..).put("plt", _platform);
      L_20:
        if (if-eqz(_sdkVersion)) goto L_29;
        new HashMap(..).put("sdk", _sdkVersion);
      L_29:
        if (if-eqz(_systemVersion)) goto L_32;
        new HashMap(..).put("system", _systemVersion);
      L_32:
        if (if-eqz(_privacyMode)) goto L_3b;
        new HashMap(..).put("prvc", _privacyMode);
      L_3b:
        if (if-eqz(_configSrc)) goto L_44;
        new HashMap(..).put("src", _configSrc);
      L_44:
        if (if-eqz(_mediationName)) goto L_4d;
        new HashMap(..).put("m_name", _mediationName);
      L_4d:
        if (if-eqz(_mediationVersion)) goto L_56;
        new HashMap(..).put("m_ver", _mediationVersion);
      L_56:
        if (if-eqz(_mediationAdapter)) goto L_5f;
        new HashMap(..).put("m_ad_ver", _mediationAdapter);
      L_5f:
        if (if-eqz(_experiments)) goto L_66;
        new HashMap(..).putAll(_experiments);
      L_66:
        String.valueOf(_testMode);
        new HashMap(..).put("tm", String.valueOf(..));
        return new HashMap(..);
    }

    public void updateWithConfig(Configuration p0) {
        p0.getSrc();
        _configSrc = Configuration.getSrc(..);
        p0.getExperiments();
        if (if-eqz(Configuration.getExperiments(..))) goto L_16;
        p0.getExperiments();
        Configuration.getExperiments(..).getExperimentTags();
        _experiments = IExperiments.getExperimentTags(..);
      L_16:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.MetricSender
// ============================================================
package com.unity3d.services.core.request.metrics;

public class MetricSender extends MetricSenderBase {
    private final MetricCommonTags commonTags;
    private final ISDKDispatchers dispatchers;
    private final HttpClient httpClient;
    private final String metricEndPoint;
    private final String metricSampleRate;
    private final CoroutineScope scope;
    private final String sessionToken;

    public MetricSender(Configuration p0, InitializationStatusReader p1) {
        new MetricSenderBase(p1);
        new MetricCommonTags();
        new MetricCommonTags(..).updateWithConfig(p0);
        commonTags = new MetricCommonTags(..);
        p0.getMetricSampleRate();
        MathKt.roundToInt(Configuration.getMetricSampleRate(..), v1);
        String.valueOf(MathKt.roundToInt(..));
        metricSampleRate = String.valueOf(..);
        p0.getSessionToken();
        sessionToken = Configuration.getSessionToken(..);
        new MetricSenderBase(..).getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        dispatchers = IServicesRegistry.getService(..);
        new MetricSenderBase(..).getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(HttpClient.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        httpClient = IServicesRegistry.getService(..);
        IServicesRegistry.getService(..).getIo();
        CoroutineScopeKt.CoroutineScope(ISDKDispatchers.getIo(..));
        scope = CoroutineScopeKt.CoroutineScope(..);
        p0.getMetricsUrl();
        metricEndPoint = Configuration.getMetricsUrl(..);
        return;
    }

    public static final MetricCommonTags access$getCommonTags$p(MetricSender p0) {
        return commonTags;
    }

    public static final HttpClient access$getHttpClient$p(MetricSender p0) {
        return httpClient;
    }

    public static final String access$getMetricSampleRate$p(MetricSender p0) {
        return metricSampleRate;
    }

    public static final String access$getSessionToken$p(MetricSender p0) {
        return sessionToken;
    }

    public String getMetricEndPoint() {
        return metricEndPoint;
    }

    public IServiceProvider getServiceProvider() {
        IServiceComponent$DefaultImpls.getServiceProvider(this);
        return IServiceComponent$DefaultImpls.getServiceProvider(..);
    }

    public void sendEvent(String p0, String p1, Map p2) {
        p0.length();
        if (if-nez(CharSequence.length(..))) goto L_15;
      L_15:
      L_16:
        if (if-eqz(0)) goto L_2a;
        new StringBuilder("Metric event not sent due to being null or empty: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        return;
      L_2a:
        new Metric(StringBuilder.toString(..), new StringBuilder(..), "Metric event not sent due to being null or empty: ");
        CollectionsKt.listOf(new Metric(..));
        MetricSender.sendMetrics(CollectionsKt.listOf(..));
        return;
    }

    public void sendMetric(Metric p0) {
        CollectionsKt.listOf(p0);
        MetricSender.sendMetrics(CollectionsKt.listOf(..));
        return;
    }

    public void sendMetrics(List p0) {
        p0.isEmpty();
        if (if-eqz(List.isEmpty(..))) goto L_11;
        DeviceLog.debug("Metrics event not send due to being empty");
        return;
      L_11:
        MetricSender.getMetricEndPoint();
        if (if-eqz(MetricSender.getMetricEndPoint(..))) goto L_22;
        StringsKt.isBlank(MetricSender.getMetricEndPoint(..));
        if (if-eqz(StringsKt.isBlank(..))) goto L_20;
      L_20:
      L_22:
      L_23:
        if (if-eqz(1)) goto L_43;
        new StringBuilder("Metrics: ");
        new StringBuilder(..).append("Metrics event not send due to being empty");
        new StringBuilder(..).append(" was not sent to null or empty endpoint: ");
        MetricSender.getMetricEndPoint();
        new StringBuilder(..).append(MetricSender.getMetricEndPoint(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        return;
      L_43:
        new MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, StringBuilder.toString(..));
        new MetricSender$sendMetrics$1(this, StringBuilder.toString(..), 0);
        BuildersKt.launch$default(scope, new MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1(..), 0, new MetricSender$sendMetrics$1(..), 2, 0);
        return;
    }

    public final void shutdown() {
        commonTags.shutdown();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.MetricSenderBase
// ============================================================
package com.unity3d.services.core.request.metrics;

public abstract class MetricSenderBase {
    private final InitializationStatusReader _initStatusReader;

    public MetricSenderBase(InitializationStatusReader p0) {
        new Object();
        _initStatusReader = p0;
        return;
    }

    public void sendEvent(String p0) {
        SDKMetricsSender$DefaultImpls.sendEvent(this, p0);
        return;
    }

    public void sendMetricWithInitState(Metric p0) {
        SdkProperties.getCurrentInitializationState();
        _initStatusReader.getInitializationStateString(SdkProperties.getCurrentInitializationState(..));
        TuplesKt.to("state", InitializationStatusReader.getInitializationStateString(..));
        MapsKt.mapOf(TuplesKt.to(..));
        p0.getTags();
        MapsKt.plus(Metric.getTags(..), MapsKt.mapOf(..));
        Metric.copy$default(p0, 0, 0, MapsKt.plus(..), 3, 0);
        MetricSenderBase.sendMetric(Metric.copy$default(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.MetricSenderWithBatch
// ============================================================
package com.unity3d.services.core.request.metrics;

public final class MetricSenderWithBatch extends MetricSenderBase {
    private SDKMetricsSender _original;
    private final LinkedBlockingQueue _queue;

    public MetricSenderWithBatch(SDKMetricsSender p0, InitializationStatusReader p1) {
        new MetricSenderBase(p1);
        _original = p0;
        new LinkedBlockingQueue();
        _queue = new LinkedBlockingQueue(..);
        return;
    }

    public String getMetricEndPoint() {
        _original.getMetricEndPoint();
        return SDKMetricsSender.getMetricEndPoint(..);
    }

    public void sendEvent(String p0, String p1, Map p2) {
        p0.length();
        if (if-nez(CharSequence.length(..))) goto L_15;
      L_15:
      L_16:
        if (if-eqz(0)) goto L_2a;
        new StringBuilder("Metric event not sent due to being empty: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        return;
      L_2a:
        new Metric(StringBuilder.toString(..), new StringBuilder(..), "Metric event not sent due to being empty: ");
        CollectionsKt.listOf(new Metric(..));
        MetricSenderWithBatch.sendMetrics(CollectionsKt.listOf(..));
        return;
    }

    public void sendMetric(Metric p0) {
        CollectionsKt.listOf(p0);
        MetricSenderWithBatch.sendMetrics(CollectionsKt.listOf(..));
        return;
    }

    public void sendMetrics(List p0) {
        _queue.addAll(p0);
        _original.getMetricEndPoint();
        TextUtils.isEmpty(SDKMetricsSender.getMetricEndPoint(..));
        if (if-nez(TextUtils.isEmpty(..))) goto L_37;
        _queue.size();
        if (if-lez(LinkedBlockingQueue.size(..))) goto L_37;
        new ArrayList();
        _queue.drainTo(new ArrayList(..));
        _original.sendMetrics(new ArrayList(..));
      L_37:
        return;
        throw new ArrayList(..);
    }

    public final void sendQueueIfNeeded() {
        CollectionsKt.emptyList();
        MetricSenderWithBatch.sendMetrics(CollectionsKt.emptyList(..));
        return;
    }

    public final void updateOriginal(SDKMetricsSender p0) {
        _original = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.MetricsContainer
// ============================================================
package com.unity3d.services.core.request.metrics;

public final class MetricsContainer {
    public static final MetricsContainer$Companion Companion = null;
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
    private final List metrics;
    private final String sTkn;
    private final String shSid;

    static <clinit>() {
        new MetricsContainer$Companion(0);
        Companion = new MetricsContainer$Companion(..);
        return;
    }

    public MetricsContainer(String p0, MetricCommonTags p1, List p2, String p3) {
        new Object();
        metricSampleRate = p0;
        commonTags = p1;
        metrics = p2;
        sTkn = p3;
        Session.Default.getId();
        shSid = Session$Default.getId(..);
        Device.getApiLevel();
        String.valueOf(Device.getApiLevel(..));
        apiLevel = String.valueOf(..);
        Device.getModel();
        deviceModel = Device.getModel(..);
        Device.getDevice();
        deviceName = Device.getDevice(..);
        Device.getManufacturer();
        deviceManufacturer = Device.getManufacturer(..);
        ClientProperties.getGameId();
        gameId = ClientProperties.getGameId(..);
        return;
    }

    public final Map toMap() {
        CollectionsKt.collectionSizeOrDefault(metrics, 10);
        new ArrayList(CollectionsKt.collectionSizeOrDefault(..));
        metrics.iterator();
      L_15:
        Iterable.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_29;
        Iterable.iterator(..).next();
        Iterator.next(..).toMap();
        new ArrayList(..).add(Metric.toMap(..));
      L_29:
        MapsKt.createMapBuilder();
        MapsKt.createMapBuilder(..).put("msr", metricSampleRate);
        MapsKt.createMapBuilder(..).put("m", new ArrayList(..));
        commonTags.toMap();
        MapsKt.createMapBuilder(..).put("t", MetricCommonTags.toMap(..));
        MapsKt.createMapBuilder(..).put("shSid", shSid);
        MapsKt.createMapBuilder(..).put("apil", apiLevel);
        if (if-eqz(sTkn)) goto L_5d;
        MapsKt.createMapBuilder(..).put("sTkn", sTkn);
      L_5d:
        if (if-eqz(deviceModel)) goto L_69;
        MapsKt.createMapBuilder(..).put("deviceModel", deviceModel);
      L_69:
        if (if-eqz(deviceName)) goto L_75;
        MapsKt.createMapBuilder(..).put("deviceName", deviceName);
      L_75:
        if (if-eqz(deviceManufacturer)) goto L_83;
        MapsKt.createMapBuilder(..).put("deviceMake", deviceManufacturer);
      L_83:
        if (if-eqz(gameId)) goto L_8f;
        MapsKt.createMapBuilder(..).put("gameId", gameId);
      L_8f:
        MapsKt.build(MapsKt.createMapBuilder(..));
        return MapsKt.build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.SDKMetrics
// ============================================================
package com.unity3d.services.core.request.metrics;

public final class SDKMetrics {
    private static final String NULL_INSTANCE_METRICS_URL = "nullInstanceMetricsUrl";
    private static MetricSenderWithBatch _batchedSender;
    private static final AtomicBoolean _configurationIsSet;
    private static SDKMetricsSender _instance;

    static <clinit>() {
        new AtomicBoolean(0);
        _configurationIsSet = new AtomicBoolean(..);
        return;
    }

    public SDKMetrics() {
        new Object();
        return;
    }

    public static SDKMetricsSender getInstance() {
        if (if-nez(SDKMetrics._instance)) goto L_f;
        new SDKMetrics$NullInstance(0);
        _instance = new SDKMetrics$NullInstance(..);
      L_f:
        if (if-nez(SDKMetrics._batchedSender)) goto L_21;
        new InitializationStatusReader();
        new MetricSenderWithBatch(SDKMetrics._instance, new InitializationStatusReader(..));
        _batchedSender = new MetricSenderWithBatch(..);
      L_21:
        return SDKMetrics._batchedSender;
        throw SDKMetrics._batchedSender;
    }

    private static boolean isAllowedToSetConfiguration(Configuration p0) {
        p0.getMetricsUrl();
        TextUtils.isEmpty(Configuration.getMetricsUrl(..));
        if (if-nez(TextUtils.isEmpty(..))) goto L_15;
        SDKMetrics._configurationIsSet.compareAndSet(0, 1);
        if (if-eqz(AtomicBoolean.compareAndSet(..))) goto L_15;
      L_15:
        return 1;
    }

    public static void setConfiguration(Configuration p0) {
        if (if-nez(p0)) goto L_8;
        DeviceLog.debug("Metrics will not be sent from the device for this session due to misconfiguration");
        return;
      L_8:
        SDKMetrics.isAllowedToSetConfiguration("Metrics will not be sent from the device for this session due to misconfiguration");
        if (if-nez(SDKMetrics.isAllowedToSetConfiguration(..))) goto L_f;
        return;
      L_f:
        if (if-eqz(v1)) goto L_1a;
        SDKMetrics._instance.shutdown();
      L_1a:
        Configuration.areMetricsEnabledForCurrentSession();
        Boolean.booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_31;
        new InitializationStatusReader();
        new MetricSender("Metrics will not be sent from the device for this session due to misconfiguration", new InitializationStatusReader(..));
        _instance = new MetricSender(..);
      L_31:
        DeviceLog.debug("Metrics will not be sent from the device for this session");
        new SDKMetrics$NullInstance("nullInstanceMetricsUrl");
        _instance = new SDKMetrics$NullInstance(..);
      L_3f:
        if (if-nez(SDKMetrics._batchedSender)) goto L_52;
        new InitializationStatusReader();
        new MetricSenderWithBatch(SDKMetrics._instance, new InitializationStatusReader(..));
        _batchedSender = new MetricSenderWithBatch(..);
      L_52:
        new MetricSenderWithBatch(..).updateOriginal(SDKMetrics._instance);
      L_57:
        SDKMetrics._batchedSender.sendQueueIfNeeded();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.SDKMetricsSender
// ============================================================
package com.unity3d.services.core.request.metrics;

public abstract class SDKMetricsSender {
    public abstract String getMetricEndPoint() {
        // native or abstract
    }

    public abstract void sendEvent(String p0) {
        // native or abstract
    }

    public abstract void sendEvent(String p0, String p1, Map p2) {
        // native or abstract
    }

    public abstract void sendMetric(Metric p0) {
        // native or abstract
    }

    public abstract void sendMetricWithInitState(Metric p0) {
        // native or abstract
    }

    public abstract void sendMetrics(List p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.ScarMetric
// ============================================================
package com.unity3d.services.core.request.metrics;

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

    public ScarMetric() {
        new Object();
        return;
    }

    private static long getTotalFetchTime() {
        System.nanoTime();
        TimeUnit.NANOSECONDS.toMillis(System.nanoTime(..), v2);
        return TimeUnit.toMillis(..);
    }

    private static long getTotalUploadTime() {
        System.nanoTime();
        TimeUnit.NANOSECONDS.toMillis(System.nanoTime(..), v2);
        return TimeUnit.toMillis(..);
    }

    public static Metric hbSignalsFetchFailure(boolean p0, String p1) {
        new HashMap();
        new HashMap(..).put("reason", p1);
        if (if-eqz(p0)) goto L_14;
      L_14:
      L_16:
        String.format("native_hb_signals_%s_fetch_failure", 1);
        ScarMetric.getTotalFetchTime();
        Long.valueOf(ScarMetric.getTotalFetchTime(..), 0);
        new Metric(String.format(..), Long.valueOf(..), new HashMap(..));
        return new Metric(..);
    }

    public static Metric hbSignalsFetchStart(boolean p0) {
        System.nanoTime();
        _fetchStartTime = System.nanoTime(..);
        if (if-eqz(p0)) goto L_10;
      L_10:
      L_12:
        String.format("native_hb_signals_%s_fetch_start", 1);
        new Metric(String.format(..), 0);
        return new Metric(..);
    }

    public static Metric hbSignalsFetchSuccess(boolean p0) {
        if (if-eqz(p0)) goto L_a;
      L_a:
      L_c:
        String.format("native_hb_signals_%s_fetch_success", 1);
        ScarMetric.getTotalFetchTime();
        Long.valueOf(ScarMetric.getTotalFetchTime(..), 0);
        new Metric(String.format(..), Long.valueOf(..));
        return new Metric(..);
    }

    public static Metric hbSignalsUploadFailure(boolean p0, String p1) {
        new HashMap();
        new HashMap(..).put("reason", p1);
        if (if-eqz(p0)) goto L_14;
      L_14:
      L_16:
        String.format("native_hb_signals_%s_upload_failure", 1);
        ScarMetric.getTotalUploadTime();
        Long.valueOf(ScarMetric.getTotalUploadTime(..), 0);
        new Metric(String.format(..), Long.valueOf(..), new HashMap(..));
        return new Metric(..);
    }

    public static Metric hbSignalsUploadStart(boolean p0) {
        System.nanoTime();
        _uploadStartTime = System.nanoTime(..);
        if (if-eqz(p0)) goto L_10;
      L_10:
      L_12:
        String.format("native_hb_signals_%s_upload_start", 1);
        new Metric(String.format(..), 0);
        return new Metric(..);
    }

    public static Metric hbSignalsUploadSuccess(boolean p0) {
        if (if-eqz(p0)) goto L_a;
      L_a:
      L_c:
        String.format("native_hb_signals_%s_upload_success", 1);
        ScarMetric.getTotalUploadTime();
        Long.valueOf(ScarMetric.getTotalUploadTime(..), 0);
        new Metric(String.format(..), Long.valueOf(..));
        return new Metric(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.TSIMetric
// ============================================================
package com.unity3d.services.core.request.metrics;

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

    public TSIMetric() {
        new Object();
        return;
    }

    public static Metric newAsyncTokenAvailable(Map p0) {
        new Metric("native_async_token_available", 0, p0);
        return new Metric(..);
    }

    public static Metric newAsyncTokenNull(Map p0) {
        new Metric("native_async_token_null", 0, p0);
        return new Metric(..);
    }

    public static Metric newConfigRequestLatencyFailure(Long p0) {
        new Metric("native_config_request_failure_time", p0);
        return new Metric(..);
    }

    public static Metric newConfigRequestLatencySuccess(Long p0) {
        new Metric("native_config_request_success_time", p0);
        return new Metric(..);
    }

    public static Metric newDeviceInfoCollectionLatency(Long p0) {
        new Metric("native_device_info_collection_latency", p0);
        return new Metric(..);
    }

    public static Metric newDeviceInfoCompressionLatency(Long p0) {
        new Metric("native_device_info_compression_latency", p0);
        return new Metric(..);
    }

    public static Metric newEmergencySwitchOff() {
        new Metric("native_emergency_switch_off", 0);
        return new Metric(..);
    }

    public static Metric newInitStarted() {
        new Metric("native_initialization_started", 0);
        return new Metric(..);
    }

    public static Metric newMissingGameSessionId() {
        new Metric("native_missing_game_session_id", 0);
        return new Metric(..);
    }

    public static Metric newMissingStateId() {
        new Metric("native_missing_state_id", 0);
        return new Metric(..);
    }

    public static Metric newMissingToken() {
        new Metric("native_missing_token", 0);
        return new Metric(..);
    }

    public static Metric newNativeGeneratedTokenAvailable(Map p0) {
        new Metric("native_generated_token_available", 0, p0);
        return new Metric(..);
    }

    public static Metric newNativeGeneratedTokenNull(Map p0) {
        new Metric("native_generated_token_null", 0, p0);
        return new Metric(..);
    }

    public static Metric newPrivacyRequestLatencyFailure(Long p0) {
        new Metric("native_privacy_request_failure_time", p0);
        return new Metric(..);
    }

    public static Metric newPrivacyRequestLatencySuccess(Long p0) {
        new Metric("native_privacy_request_success_time", p0);
        return new Metric(..);
    }

    public static Metric newPrivacyResolutionRequestLatencyFailure(Long p0) {
        new Metric("native_privacy_resolution_request_latency_failure", p0);
        return new Metric(..);
    }

    public static Metric newPrivacyResolutionRequestLatencySuccess(Long p0) {
        new Metric("native_privacy_resolution_request_latency_success", p0);
        return new Metric(..);
    }

    public static Metric newTokenAvailabilityLatencyConfig(Long p0, Map p1) {
        new Metric("native_token_availability_latency_config", p0, p1);
        return new Metric(..);
    }

    public static Metric newTokenAvailabilityLatencyWebview(Long p0, Map p1) {
        new Metric("native_token_availability_latency_webview", p0, p1);
        return new Metric(..);
    }

    public static Metric newTokenResolutionRequestLatency(Long p0, Map p1) {
        new Metric("native_token_resolution_request_latency", p0, p1);
        return new Metric(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.AdOperationMetric$1
// ============================================================
package com.unity3d.services.core.request.metrics;

class AdOperationMetric$1 extends HashMap {
    final String val$errorMetric;
    final boolean val$isFailure;
    final Boolean val$isHb;
    final String val$type;

    AdOperationMetric$1(boolean p0, String p1, String p2, Boolean p3) {
        val$isFailure = p0;
        val$errorMetric = p1;
        val$type = p2;
        val$isHb = p3;
        new HashMap();
        if (if-eqz(p0)) goto L_12;
        new HashMap(..).put("reason", p1);
      L_12:
        new HashMap(..).put("type", p2);
        if (if-eqz(p3)) goto L_22;
        String.valueOf(p3);
        new HashMap(..).put("is_header_bidding", String.valueOf(..));
      L_22:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.AdOperationMetric$2
// ============================================================
package com.unity3d.services.core.request.metrics;

class AdOperationMetric$2 {
    static final int[] $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError;
    static final int[] $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError;

    static <clinit>() {
        UnityAds$UnityAdsShowError.values();
        $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowError = UnityAds$UnityAdsShowError.values(..);
        UnityAds$UnityAdsShowError.ordinal();
        UnityAds$UnityAdsShowError.NOT_READY.ordinal();
        UnityAds$UnityAdsShowError.ordinal();
        UnityAds$UnityAdsShowError.ordinal();
        UnityAds$UnityAdsShowError.ordinal();
        UnityAds$UnityAdsShowError.ordinal();
        UnityAds$UnityAdsShowError.ordinal();
        UnityAds$UnityAdsLoadError.values();
        $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError = UnityAds$UnityAdsLoadError.values(..);
        UnityAds$UnityAdsLoadError.ordinal();
        UnityAds$UnityAdsLoadError.ordinal();
        UnityAds$UnityAdsLoadError.ordinal();
        UnityAds$UnityAdsLoadError.NO_FILL.ordinal();
        UnityAds$UnityAdsLoadError.TIMEOUT.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.InitMetric$1
// ============================================================
package com.unity3d.services.core.request.metrics;

class InitMetric$1 extends HashMap {
    final String val$gameId;
    final String val$previousGameId;

    InitMetric$1(String p0, String p1) {
        val$gameId = p0;
        val$previousGameId = p1;
        new HashMap();
        new HashMap(..).put("game_id", p0);
        new HashMap(..).put("previous_game_id", p1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.InitMetric$2
// ============================================================
package com.unity3d.services.core.request.metrics;

class InitMetric$2 extends HashMap {
    final String val$gameId;
    final String val$previousGameId;

    InitMetric$2(String p0, String p1) {
        val$gameId = p0;
        val$previousGameId = p1;
        new HashMap();
        new HashMap(..).put("game_id", p0);
        new HashMap(..).put("previous_game_id", p1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.InitMetric$3
// ============================================================
package com.unity3d.services.core.request.metrics;

class InitMetric$3 extends HashMap {
    final Boolean val$previousTestMode;
    final Boolean val$testMode;

    InitMetric$3(Boolean p0, Boolean p1) {
        val$testMode = p0;
        val$previousTestMode = p1;
        new HashMap();
        p0.toString();
        new HashMap(..).put("test_mode", Boolean.toString(..));
        p1.toString();
        new HashMap(..).put("previous_test_mode", Boolean.toString(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.InitMetric$4
// ============================================================
package com.unity3d.services.core.request.metrics;

class InitMetric$4 extends HashMap {
    final Boolean val$previousTestMode;
    final Boolean val$testMode;

    InitMetric$4(Boolean p0, Boolean p1) {
        val$testMode = p0;
        val$previousTestMode = p1;
        new HashMap();
        p0.toString();
        new HashMap(..).put("test_mode", Boolean.toString(..));
        p1.toString();
        new HashMap(..).put("previous_test_mode", Boolean.toString(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.Metric$Companion
// ============================================================
package com.unity3d.services.core.request.metrics;

public final class Metric$Companion {
    private Metric$Companion() {
        new Object();
        return;
    }

    public Metric$Companion(DefaultConstructorMarker p0) {
        new Metric$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.MetricCommonTags$1
// ============================================================
package com.unity3d.services.core.request.metrics;

class MetricCommonTags$1 {
    final MetricCommonTags this$0;

    MetricCommonTags$1(MetricCommonTags p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void updated(PrivacyConfig p0) {
        p0.getPrivacyStatus();
        PrivacyConfig.getPrivacyStatus(..).toString();
        PrivacyConfigStatus.toString(..).toLowerCase();
        MetricCommonTags.access$002(this$0, String.toLowerCase(..));
        return;
    }

    public void updated(Object p0) {
        MetricCommonTags$1.updated(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1
// ============================================================
package com.unity3d.services.core.request.metrics;

public final class MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement {
    final List $metrics$inlined;

    public MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler$Key p0, List p1) {
        $metrics$inlined = p1;
        new AbstractCoroutineContextElement(p0);
        return;
    }

    public void handleException(CoroutineContext p0, Throwable p1) {
        new StringBuilder("Metric ");
        new StringBuilder(..).append($metrics$inlined);
        new StringBuilder(..).append(" failed to send with error: ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.MetricSender$sendMetrics$1
// ============================================================
package com.unity3d.services.core.request.metrics;

final class MetricSender$sendMetrics$1 extends SuspendLambda {
    final List $metrics;
    int label;
    final MetricSender this$0;

    MetricSender$sendMetrics$1(MetricSender p0, List p1, Continuation p2) {
        this$0 = p0;
        $metrics = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new MetricSender$sendMetrics$1(this$0, $metrics, p1);
        return new MetricSender$sendMetrics$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        MetricSender$sendMetrics$1.invoke(p0, p1);
        return MetricSender$sendMetrics$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        MetricSender$sendMetrics$1.create(p0, p1);
        MetricSender$sendMetrics$1.invokeSuspend(Unit.INSTANCE);
        return MetricSender$sendMetrics$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_1b;
        if (if-ne(label, 1)) goto L_13;
        ResultKt.throwOnFailure(p0);
      L_13:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1b:
        ResultKt.throwOnFailure(p0);
        MetricSender.access$getMetricSampleRate$p(this$0);
        MetricSender.access$getCommonTags$p(this$0);
        MetricSender.access$getSessionToken$p(this$0);
        new MetricsContainer(MetricSender.access$getMetricSampleRate$p(..), MetricSender.access$getCommonTags$p(..), $metrics, MetricSender.access$getSessionToken$p(..));
        new MetricsContainer(..).toMap();
        new JSONObject(MetricsContainer.toMap(..));
        new JSONObject(..).toString();
        this$0.getMetricEndPoint();
        if (if-nez(MetricSender.getMetricEndPoint(..))) goto L_55;
      L_55:
        new HttpRequest("", 0, RequestType.POST, JSONObject.toString(..), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        MetricSender.access$getHttpClient$p(this$0);
        label = 1;
        HttpClient.execute(new HttpRequest, this);
        if (if-ne(HttpClient.execute(..), new IllegalStateException(..))) goto L_88;
        return new IllegalStateException(..);
      L_88:
        HttpClient.execute(..).getStatusCode();
        if (if-ne(HttpResponse.getStatusCode(..), 2)) goto L_94;
      L_94:
      L_95:
        if (if-eqz(0)) goto L_b9;
        new StringBuilder("Metric ");
        new StringBuilder(..).append($metrics);
        new StringBuilder(..).append(" sent to ");
        this$0.getMetricEndPoint();
        new StringBuilder(..).append(MetricSender.getMetricEndPoint(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
      L_b9:
        new StringBuilder(StringBuilder.toString(..));
        new StringBuilder(..).append($metrics);
        new StringBuilder(..).append(" failed to send with response code: ");
        new StringBuilder(..).getStatusCode();
        new StringBuilder(..).append(HttpResponse.getStatusCode(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
      L_d6:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.MetricsContainer$Companion
// ============================================================
package com.unity3d.services.core.request.metrics;

public final class MetricsContainer$Companion {
    private MetricsContainer$Companion() {
        new Object();
        return;
    }

    public MetricsContainer$Companion(DefaultConstructorMarker p0) {
        new MetricsContainer$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.SDKMetrics$NullInstance
// ============================================================
package com.unity3d.services.core.request.metrics;

final class SDKMetrics$NullInstance {
    private final String _metricEndpoint;

    public SDKMetrics$NullInstance(String p0) {
        new Object();
        _metricEndpoint = p0;
        return;
    }

    public String getMetricEndPoint() {
        return _metricEndpoint;
    }

    public void sendEvent(String p0) {
        new StringBuilder("Metric ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" was skipped from being sent");
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        return;
    }

    public void sendEvent(String p0, String p1, Map p2) {
        SDKMetrics$NullInstance.sendEvent(p0);
        return;
    }

    public void sendEvent(String p0, Map p1) {
        SDKMetrics$NullInstance.sendEvent(p0);
        return;
    }

    public void sendMetric(Metric p0) {
        new StringBuilder("Metric ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" was skipped from being sent");
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        return;
    }

    public void sendMetricWithInitState(Metric p0) {
        SDKMetrics$NullInstance.sendMetric(p0);
        return;
    }

    public void sendMetrics(List p0) {
        new StringBuilder("Metrics: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" was skipped from being sent");
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.metrics.SDKMetricsSender$DefaultImpls
// ============================================================
package com.unity3d.services.core.request.metrics;

public final class SDKMetricsSender$DefaultImpls {
    public static void sendEvent(SDKMetricsSender p0, String p1) {
        SDKMetricsSender$DefaultImpls.sendEvent$default(p0, p1, 0, 0, 4, 0);
        return;
    }

    public static void sendEvent$default(SDKMetricsSender p0, String p1, String p2, Map p3, int p4, Object p5) {
        if (if-nez(p5)) goto L_13;
        if (if-eqz(p5)) goto L_7;
      L_7:
        if (if-eqz(p4)) goto L_f;
        MapsKt.emptyMap();
      L_f:
        p0.sendEvent(p1, 0, MapsKt.emptyMap(..));
        return;
      L_13:
        new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        throw new UnsupportedOperationException(..);
    }

}

