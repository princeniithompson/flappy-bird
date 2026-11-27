// Package bundle: com.unity3d.services.core.properties (9 classes)

// ============================================================
// CLASS: com.unity3d.services.core.properties.ClientProperties
// ============================================================
package com.unity3d.services.core.properties;

public class ClientProperties {
    private static final X500Principal DEBUG_CERT;
    private static WeakReference _activity;
    private static Application _application;
    private static Context _applicationContext;
    private static String _gameId;

    static <clinit>() {
        new X500Principal("CN=Android Debug,O=Android,C=US");
        DEBUG_CERT = new X500Principal(..);
        return;
    }

    public ClientProperties() {
        new Object();
        return;
    }

    public static Activity getActivity() {
        ClientProperties._activity.get();
        return WeakReference.get(..);
    }

    public static String getAppName() {
        if (if-nez(ClientProperties._applicationContext)) goto L_7;
        return "";
      L_7:
        "".getPackageName();
        return Context.getPackageName(..);
    }

    public static String getAppVersion() {
        ClientProperties.getApplicationContext();
        Context.getPackageName();
        ClientProperties.getApplicationContext();
        Context.getPackageManager();
        Context.getPackageManager(..).getPackageInfo(Context.getPackageName(..), 0);
        if (if-nez(versionName)) goto L_1c;
        return "FakeVersionName";
      L_1c:
        Context.getPackageManager(..).getPackageInfo("FakeVersionName", 0);
        return versionName;
        DeviceLog.exception("Error getting package info", versionName);
        return 0;
    }

    public static Application getApplication() {
        return ClientProperties._application;
    }

    public static Context getApplicationContext() {
        return ClientProperties._applicationContext;
    }

    public static String getGameId() {
        return ClientProperties._gameId;
    }

    public static boolean isAppDebuggable() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_70;
        ClientProperties.getApplicationContext();
        Context.getPackageManager();
        ClientProperties.getApplicationContext();
        Context.getPackageName();
        Context.getPackageManager(..).getApplicationInfo(Context.getPackageName(..), 0);
        flags = flags;
        if (if-eqz(flags)) goto L_27;
      L_27:
      L_28:
        DeviceLog.exception("Could not find name", 0);
      L_30:
        if (if-eqz(0)) goto L_6f;
        Context.getPackageManager(..).getPackageInfo(Context.getPackageName(..), 64);
      L_3b:
        if (if-ge(0, Context.getPackageName(..))) goto L_6f;
        CertificateFactory.getInstance("X.509");
        64.toByteArray();
        new ByteArrayInputStream(Signature.toByteArray(..));
        CertificateFactory.getInstance(..).generateCertificate(new ByteArrayInputStream(..));
        X509Certificate.getSubjectX500Principal();
        X500Principal.equals(ClientProperties.DEBUG_CERT);
        if (if-eqz(X500Principal.equals(..))) goto L_61;
      L_61:
        DeviceLog.exception("Certificate exception", "Could not find name");
        DeviceLog.exception("Could not find name", "Certificate exception");
      L_6f:
        return X500Principal.equals(..);
      L_70:
        return 0;
    }

    public static void setActivity(Activity p0) {
        new WeakReference(p0);
        _activity = new WeakReference(..);
        return;
    }

    public static void setApplication(Application p0) {
        _application = p0;
        return;
    }

    public static void setApplicationContext(Context p0) {
        _applicationContext = p0;
        return;
    }

    public static void setGameId(String p0) {
        _gameId = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.properties.InitializationStatusReader
// ============================================================
package com.unity3d.services.core.properties;

public class InitializationStatusReader {
    private static final String STATE_INITIALIZED_FAILED = "initialized_failed";
    private static final String STATE_INITIALIZED_SUCCESSFULLY = "initialized_successfully";
    private static final String STATE_INITIALIZING = "initializing";
    private static final String STATE_NOT_INITIALIZED = "not_initialized";

    public InitializationStatusReader() {
        new Object();
        return;
    }

    public String getInitializationStateString(SdkProperties$InitializationState p0) {
        p0.ordinal();
        if (if-eq(SdkProperties$InitializationState.ordinal(..), 1)) goto L_1f;
        if (if-eq(SdkProperties$InitializationState.ordinal(..), 2)) goto L_1c;
        if (if-eq(SdkProperties$InitializationState.ordinal(..), 3)) goto L_19;
        if (if-eq(SdkProperties$InitializationState.ordinal(..), 4)) goto L_16;
        return 0;
      L_16:
        return "initialized_failed";
      L_19:
        return "initialized_successfully";
      L_1c:
        return "initializing";
      L_1f:
        return "not_initialized";
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.properties.MadeWithUnityDetector
// ============================================================
package com.unity3d.services.core.properties;

public class MadeWithUnityDetector {
    public static final String UNITY_PLAYER_CLASS_NAME = "com.unity3d.player.UnityPlayer";

    public MadeWithUnityDetector() {
        new Object();
        return;
    }

    public static boolean isMadeWithUnity() {
        Class.forName("com.unity3d.player.UnityPlayer");
        return 1;
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.properties.SdkProperties
// ============================================================
package com.unity3d.services.core.properties;

public class SdkProperties {
    private static final String CACHE_DIR_NAME = "UnityAdsCache";
    private static final String CHINA_CONFIG_HOSTNAME = "dW5pdHlhZHMudW5pdHljaGluYS5jbg==";
    private static final String CHINA_ISO_ALPHA_2_CODE = "CN";
    private static final String CHINA_ISO_ALPHA_3_CODE = "CHN";
    private static final String CONFIG_VERSION_METADATA_KEY = "com.unity3d.ads.configversion";
    private static final String DEFAULT_CONFIG_HOSTNAME = "unityads.unity3d.com";
    private static final String DEFAULT_CONFIG_VERSION = "configv2";
    private static final String LOCAL_CACHE_FILE_PREFIX = "UnityAdsCache-";
    private static final String LOCAL_STORAGE_FILE_PREFIX = "UnityAdsStorage-";
    private static final String WEBVIEW_CACHE_DIR_NAME = "UnityAdsWebViewCache";
    private static long _appInitializationTimeEpochMs;
    private static CacheDirectory _cacheDirectory;
    private static String _configUrl;
    private static final AtomicReference _currentInitializationState;
    private static boolean _debugMode;
    private static final LinkedHashSet _initializationListeners;
    private static long _initializationTime;
    private static long _initializationTimeEpochMs;
    private static boolean _initialized;
    private static Configuration _latestConfiguration;
    private static boolean _reinitialized;
    private static boolean _testMode;
    private static CacheDirectory _webviewCacheDirectory;

    static <clinit>() {
        new LinkedHashSet();
        _initializationListeners = new LinkedHashSet(..);
        _initialized = 0;
        _reinitialized = 0;
        _testMode = 0;
        _debugMode = 0;
        new AtomicReference(SdkProperties$InitializationState.NOT_INITIALIZED);
        _currentInitializationState = new AtomicReference(..);
        return;
    }

    public SdkProperties() {
        new Object();
        return;
    }

    public static void addInitializationListener(IUnityAdsInitializationListener p0) {
        if (if-nez(p0)) goto L_3;
        return;
      L_3:
        LinkedHashSet.add(p0);
        return;
        throw p0;
    }

    public static long getAppInitializationTimeSinceEpoch() {
        return SdkProperties._appInitializationTimeEpochMs;
    }

    public static File getCacheDirectory() {
        ClientProperties.getApplicationContext();
        SdkProperties.getCacheDirectory(ClientProperties.getApplicationContext(..));
        return SdkProperties.getCacheDirectory(..);
    }

    public static File getCacheDirectory(Context p0) {
        if (if-nez(SdkProperties._cacheDirectory)) goto L_e;
        new CacheDirectory("UnityAdsCache");
        SdkProperties.setCacheDirectory(new CacheDirectory(..));
      L_e:
        SdkProperties._cacheDirectory.getCacheDirectory(p0);
        return CacheDirectory.getCacheDirectory(..);
    }

    public static String getCacheDirectoryName() {
        return "UnityAdsCache";
    }

    public static CacheDirectory getCacheDirectoryObject() {
        return SdkProperties._cacheDirectory;
    }

    public static String getCacheFilePrefix() {
        return "UnityAdsCache-";
    }

    public static String getConfigUrl() {
        if (if-nez(SdkProperties._configUrl)) goto L_c;
        SdkProperties.getDefaultConfigUrl("release");
        _configUrl = SdkProperties.getDefaultConfigUrl(..);
      L_c:
        return SdkProperties._configUrl;
    }

    public static String getConfigVersion(Context p0) {
        if (if-eqz(p0)) goto L_23;
        p0.getPackageManager();
        p0.getPackageName();
        Context.getPackageManager(..).getApplicationInfo(Context.getPackageName(..), 128);
        if (if-eqz(metaData)) goto L_23;
        metaData.getString("com.unity3d.ads.configversion", "configv2");
        DeviceLog.warning("Failed to retrieve application info for current package");
      L_23:
        return Bundle.getString(..);
    }

    public static SdkProperties$InitializationState getCurrentInitializationState() {
        AtomicReference.get();
        return AtomicReference.get(..);
    }

    public static boolean getDebugMode() {
        return SdkProperties._debugMode;
    }

    public static String getDefaultConfigUrl(String p0) {
        Device.getNetworkCountryISO();
        SdkProperties.isChinaLocale(Device.getNetworkCountryISO(..));
        if (if-eqz(SdkProperties.isChinaLocale(..))) goto L_17;
        Base64.decode("dW5pdHlhZHMudW5pdHljaGluYS5jbg==", 0);
        new String(Base64.decode(..));
      L_17:
      L_19:
        new StringBuilder("https://");
        ClientProperties.getApplicationContext();
        SdkProperties.getConfigVersion(ClientProperties.getApplicationContext(..));
        new StringBuilder(..).append(SdkProperties.getConfigVersion(..));
        new StringBuilder(..).append(46);
        new StringBuilder(..).append("unityads.unity3d.com");
        new StringBuilder(..).append("/webview/");
        SdkProperties.getWebViewBranch();
        new StringBuilder(..).append(SdkProperties.getWebViewBranch(..));
        new StringBuilder(..).append("/");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append("/config.json");
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    public static IUnityAdsInitializationListener[] getInitializationListeners() {
        LinkedHashSet.size();
        LinkedHashSet.toArray(LinkedHashSet.size(..));
        return LinkedHashSet.size(..);
        throw LinkedHashSet.size(..);
    }

    public static long getInitializationTime() {
        return SdkProperties._initializationTime;
    }

    public static long getInitializationTimeEpoch() {
        return SdkProperties._initializationTimeEpochMs;
    }

    public static Configuration getLatestConfiguration() {
        return SdkProperties._latestConfiguration;
    }

    public static String getLocalConfigurationFilepath() {
        SdkProperties.getWebViewCacheDirectory();
        if (if-nez(SdkProperties.getWebViewCacheDirectory(..))) goto L_9;
        return "";
      L_9:
        new StringBuilder();
        SdkProperties.getWebViewCacheDirectory();
        File.getAbsolutePath();
        new StringBuilder(..).append(File.getAbsolutePath(..));
        new StringBuilder(..).append("/UnityAdsWebViewConfiguration.json");
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    public static String getLocalStorageFilePrefix() {
        return "UnityAdsStorage-";
    }

    public static String getLocalWebViewFile() {
        SdkProperties.getWebViewCacheDirectory();
        if (if-nez(SdkProperties.getWebViewCacheDirectory(..))) goto L_9;
        return "";
      L_9:
        new StringBuilder();
        SdkProperties.getWebViewCacheDirectory();
        File.getAbsolutePath();
        new StringBuilder(..).append(File.getAbsolutePath(..));
        new StringBuilder(..).append("/UnityAdsWebApp.html");
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    public static int getVersionCode() {
        return 41205;
    }

    public static String getVersionName() {
        return "4.12.5";
    }

    private static String getWebViewBranch() {
        SdkProperties.getVersionName();
        return SdkProperties.getVersionName(..);
    }

    public static File getWebViewCacheDirectory() {
        ClientProperties.getApplicationContext();
        SdkProperties.getWebViewCacheDirectory(ClientProperties.getApplicationContext(..));
        return SdkProperties.getWebViewCacheDirectory(..);
    }

    public static File getWebViewCacheDirectory(Context p0) {
        if (if-nez(SdkProperties._webviewCacheDirectory)) goto L_f;
        new CacheDirectory("UnityAdsWebViewCache", 0);
        SdkProperties.setWebViewCacheDirectory(new CacheDirectory(..));
      L_f:
        SdkProperties._webviewCacheDirectory.getCacheDirectory(p0);
        return CacheDirectory.getCacheDirectory(..);
    }

    public static boolean isChinaLocale(String p0) {
        p0.equalsIgnoreCase("CN");
        if (if-nez(String.equalsIgnoreCase(..))) goto L_13;
        p0.equalsIgnoreCase("CHN");
        if (if-eqz(String.equalsIgnoreCase(..))) goto L_11;
      L_11:
        return 0;
      L_13:
        return 1;
    }

    public static boolean isInitialized() {
        return SdkProperties._initialized;
    }

    public static boolean isReinitialized() {
        return SdkProperties._reinitialized;
    }

    public static boolean isTestMode() {
        return SdkProperties._testMode;
    }

    static void lambda$notifyInitializationFailed$0(IUnityAdsInitializationListener p0, UnityAds$UnityAdsInitializationError p1, String p2) {
        p0.onInitializationFailed(p1, p2);
        return;
    }

    public static void notifyInitializationComplete() {
        SdkProperties.setInitializeState(SdkProperties$InitializationState.INITIALIZED_SUCCESSFULLY);
        SdkProperties.getInitializationListeners();
      L_b:
        if (if-ge(0, v1)) goto L_1d;
        Objects.requireNonNull(v3);
        new SdkProperties$$ExternalSyntheticLambda0(v3);
        Utilities.wrapCustomerListener(new SdkProperties$$ExternalSyntheticLambda0(..));
      L_1d:
        SdkProperties.resetInitializationListeners();
        return;
    }

    public static void notifyInitializationFailed(UnityAds$UnityAdsInitializationError p0, String p1) {
        SdkProperties.setInitializeState(SdkProperties$InitializationState.INITIALIZED_FAILED);
        SdkProperties.getInitializationListeners();
      L_b:
        if (if-ge(0, v1)) goto L_1a;
        new SdkProperties$$ExternalSyntheticLambda1(v3, p0, p1);
        Utilities.wrapCustomerListener(new SdkProperties$$ExternalSyntheticLambda1(..));
      L_1a:
        SdkProperties.resetInitializationListeners();
        return;
    }

    public static void resetInitializationListeners() {
        LinkedHashSet.clear();
        return;
        throw v1;
    }

    public static void setAppInitializationTimeSinceEpoch(long p0) {
        _appInitializationTimeEpochMs = p0;
        return;
    }

    public static void setCacheDirectory(CacheDirectory p0) {
        _cacheDirectory = p0;
        return;
    }

    public static void setConfigUrl(String p0) {
        if (if-eqz(p0)) goto L_24;
        p0.startsWith("http://");
        if (if-nez(String.startsWith(..))) goto L_19;
        p0.startsWith("https://");
        if (if-eqz(String.startsWith(..))) goto L_13;
      L_13:
        new MalformedURLException();
        throw new MalformedURLException(..);
      L_19:
        new URL(new MalformedURLException(..));
        new URL(..).toURI();
        _configUrl = new MalformedURLException(..);
        return;
      L_24:
        new MalformedURLException();
        throw new MalformedURLException(..);
    }

    public static void setDebugMode(boolean p0) {
        _debugMode = p0;
        if (if-eqz(p0)) goto L_a;
        DeviceLog.setLogLevel(8);
      L_a:
        DeviceLog.setLogLevel(4);
      L_e:
        return;
    }

    public static void setInitializationTime(long p0) {
        _initializationTime = p0;
        return;
    }

    public static void setInitializationTimeSinceEpoch(long p0) {
        _initializationTimeEpochMs = p0;
        return;
    }

    public static void setInitializeState(SdkProperties$InitializationState p0) {
        AtomicReference.set(p0);
        return;
    }

    public static void setInitialized(boolean p0) {
        _initialized = p0;
        return;
    }

    public static void setLatestConfiguration(Configuration p0) {
        _latestConfiguration = p0;
        return;
    }

    public static void setReinitialized(boolean p0) {
        _reinitialized = p0;
        return;
    }

    public static void setTestMode(boolean p0) {
        _testMode = p0;
        return;
    }

    public static void setWebViewCacheDirectory(CacheDirectory p0) {
        _webviewCacheDirectory = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.properties.Session
// ============================================================
package com.unity3d.services.core.properties;

public abstract class Session {
    public static final Session$Default Default;

    static <clinit>() {
        Default = Session$Default.$$INSTANCE;
        return;
    }

    public abstract String getId() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.properties.SessionIdReader
// ============================================================
package com.unity3d.services.core.properties;

public final class SessionIdReader {
    public static final SessionIdReader INSTANCE;
    private static final String sessionId;

    static <clinit>() {
        new SessionIdReader();
        INSTANCE = new SessionIdReader(..);
        UUID.randomUUID();
        UUID.randomUUID(..).toString();
        sessionId = UUID.toString(..);
        return;
    }

    private SessionIdReader() {
        new Object();
        return;
    }

    public final String getSessionId() {
        return SessionIdReader.sessionId;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.properties.InitializationStatusReader$1
// ============================================================
package com.unity3d.services.core.properties;

class InitializationStatusReader$1 {
    static final int[] $SwitchMap$com$unity3d$services$core$properties$SdkProperties$InitializationState;

    static <clinit>() {
        SdkProperties$InitializationState.values();
        $SwitchMap$com$unity3d$services$core$properties$SdkProperties$InitializationState = SdkProperties$InitializationState.values(..);
        SdkProperties$InitializationState.ordinal();
        SdkProperties$InitializationState.ordinal();
        SdkProperties$InitializationState.ordinal();
        SdkProperties$InitializationState.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.properties.SdkProperties$InitializationState
// ============================================================
package com.unity3d.services.core.properties;

public final class SdkProperties$InitializationState extends Enum {
    private static final SdkProperties$InitializationState[] $VALUES;
    public static final SdkProperties$InitializationState INITIALIZED_FAILED;
    public static final SdkProperties$InitializationState INITIALIZED_SUCCESSFULLY;
    public static final SdkProperties$InitializationState INITIALIZING;
    public static final SdkProperties$InitializationState NOT_INITIALIZED;

    private static SdkProperties$InitializationState[] $values() {
        return 4;
    }

    static <clinit>() {
        new SdkProperties$InitializationState("NOT_INITIALIZED", 0);
        NOT_INITIALIZED = new SdkProperties$InitializationState(..);
        new SdkProperties$InitializationState("INITIALIZING", 1);
        INITIALIZING = new SdkProperties$InitializationState(..);
        new SdkProperties$InitializationState("INITIALIZED_SUCCESSFULLY", 2);
        INITIALIZED_SUCCESSFULLY = new SdkProperties$InitializationState(..);
        new SdkProperties$InitializationState("INITIALIZED_FAILED", 3);
        INITIALIZED_FAILED = new SdkProperties$InitializationState(..);
        SdkProperties$InitializationState.$values();
        $VALUES = SdkProperties$InitializationState.$values(..);
        return;
    }

    private SdkProperties$InitializationState(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static SdkProperties$InitializationState valueOf(String p0) {
        Enum.valueOf(SdkProperties$InitializationState.class, p0);
        return Enum.valueOf(..);
    }

    public static SdkProperties$InitializationState[] values() {
        SdkProperties$InitializationState[].clone();
        return SdkProperties$InitializationState[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.properties.Session$Default
// ============================================================
package com.unity3d.services.core.properties;

public final class Session$Default {
    static final Session$Default $$INSTANCE;
    private static final String id;

    static <clinit>() {
        new Session$Default();
        $$INSTANCE = new Session$Default(..);
        SessionIdReader.INSTANCE.getSessionId();
        id = SessionIdReader.getSessionId(..);
        return;
    }

    private Session$Default() {
        new Object();
        return;
    }

    public String getId() {
        return Session$Default.id;
    }

}

