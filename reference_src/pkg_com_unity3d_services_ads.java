// Package bundle: com.unity3d.services.ads (3 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.IUnityAds
// ============================================================
package com.unity3d.services.ads;

public abstract class IUnityAds {
    public abstract boolean getDebugMode() {
        // native or abstract
    }

    public abstract String getToken() {
        // native or abstract
    }

    public abstract void getToken(IUnityAdsTokenListener p0) {
        // native or abstract
    }

    public abstract String getVersion() {
        // native or abstract
    }

    public abstract void initialize(Context p0, String p1, boolean p2, IUnityAdsInitializationListener p3) {
        // native or abstract
    }

    public abstract boolean isInitialized() {
        // native or abstract
    }

    public abstract boolean isSupported() {
        // native or abstract
    }

    public abstract void load(String p0, UnityAdsLoadOptions p1, IUnityAdsLoadListener p2) {
        // native or abstract
    }

    public abstract void setDebugMode(boolean p0) {
        // native or abstract
    }

    public abstract void show(Activity p0, String p1, UnityAdsShowOptions p2, IUnityAdsShowListener p3) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.UnityAdsImplementation
// ============================================================
package com.unity3d.services.ads;

public final class UnityAdsImplementation {
    private static Configuration configuration;
    private static IUnityAds instance;
    private static WebViewBridgeInvoker webViewBridgeInvoker;

    static <clinit>() {
        new WebViewBridgeInvoker();
        webViewBridgeInvoker = new WebViewBridgeInvoker(..);
        return;
    }

    public UnityAdsImplementation() {
        new Object();
        return;
    }

    public static IUnityAds getInstance() {
        if (if-nez(UnityAdsImplementation.instance)) goto L_b;
        new UnityAdsImplementation();
        instance = new UnityAdsImplementation(..);
      L_b:
        return UnityAdsImplementation.instance;
    }

    private void handleShowError(IUnityAdsShowListener p0, String p1, UnityAds$UnityAdsShowError p2, String p3) {
        Utilities.getService(SDKMetricsSender.class);
        Long.valueOf(0L, v2);
        AdOperationMetric.newAdShowFailure(p2, Long.valueOf(..));
        Utilities.getService(..).sendMetricWithInitState(AdOperationMetric.newAdShowFailure(..));
        if (if-nez(p0)) goto L_18;
        return;
      L_18:
        p0.onUnityAdsShowFailure(p1, p2, p3);
        return;
    }

    static void lambda$getToken$0(IUnityAdsTokenListener p0) {
        p0.onUnityAdsTokenReady(0);
        return;
    }

    public static void setConfiguration(Configuration p0) {
        configuration = p0;
        return;
    }

    public boolean getDebugMode() {
        UnityServices.getDebugMode();
        return UnityServices.getDebugMode(..);
    }

    public String getToken() {
        Utilities.getService(AlternativeFlowReader.class);
        Utilities.getService(..).invoke();
        if (if-eqz(AlternativeFlowReader.invoke(..))) goto L_15;
        UnityAdsSDK.INSTANCE.getToken();
        return UnityAdsSDK.getToken(..);
      L_15:
        Utilities.getService(TokenStorage.class);
        Utilities.getService(..).getToken();
        if (if-eqz(TokenStorage.getToken(..))) goto L_4c;
        TokenStorage.getToken(..).isEmpty();
        if (if-eqz(String.isEmpty(..))) goto L_2b;
      L_2b:
        if (if-nez(UnityAdsImplementation.configuration)) goto L_38;
        new ConfigurationReader();
        new ConfigurationReader(..).getCurrentConfiguration();
      L_38:
        BiddingManagerFactory.getInstance();
        Configuration.getExperiments();
        BiddingManagerFactory.createManager(0, Configuration.getExperiments(..));
        BiddingBaseManager.start();
        BiddingBaseManager.getFormattedToken(TokenStorage.getToken(..));
        return BiddingBaseManager.getFormattedToken(..);
      L_4c:
        return BiddingManagerFactory.createManager(..);
    }

    public void getToken(IUnityAdsTokenListener p0) {
        Utilities.getService(AlternativeFlowReader.class);
        Utilities.getService(..).invoke();
        if (if-eqz(AlternativeFlowReader.invoke(..))) goto L_14;
        UnityAdsSDK.INSTANCE.getToken(p0);
      L_14:
        if (if-nez(p0)) goto L_1c;
        DeviceLog.info("Please provide non-null listener to UnityAds.GetToken method");
        return;
      L_1c:
        ClientProperties.getApplicationContext();
        if (if-nez(ClientProperties.getApplicationContext(..))) goto L_2b;
        new UnityAdsImplementation$$ExternalSyntheticLambda0("Please provide non-null listener to UnityAds.GetToken method");
        Utilities.wrapCustomerListener(new UnityAdsImplementation$$ExternalSyntheticLambda0(..));
        return;
      L_2b:
        Utilities.getService(AsyncTokenStorage.class);
        if (if-nez(UnityAdsImplementation.configuration)) goto L_40;
        new ConfigurationReader();
        new ConfigurationReader(..).getCurrentConfiguration();
      L_40:
        BiddingManagerFactory.getInstance();
        Configuration.getExperiments();
        BiddingManagerFactory.createManager("Please provide non-null listener to UnityAds.GetToken method", Configuration.getExperiments(..));
        BiddingBaseManager.start();
        Utilities.getService(..).getToken(BiddingManagerFactory.createManager(..));
      L_52:
        return;
    }

    public String getVersion() {
        UnityServices.getVersion();
        return UnityServices.getVersion(..);
    }

    public void initialize(Context p0, String p1, boolean p2, IUnityAdsInitializationListener p3) {
        DeviceLog.entered();
        UnityServices.initialize(p0, p1, p2, p3);
        return;
    }

    public boolean isInitialized() {
        UnityServices.isInitialized();
        return UnityServices.isInitialized(..);
    }

    public boolean isSupported() {
        UnityServices.isSupported();
        return UnityServices.isSupported(..);
    }

    public void load(String p0, UnityAdsLoadOptions p1, IUnityAdsLoadListener p2) {
        Utilities.getService(AlternativeFlowReader.class);
        Utilities.getService(..).invoke();
        if (if-eqz(AlternativeFlowReader.invoke(..))) goto L_15;
        UnityAdsSDK.INSTANCE.load(p0, p1, p2, 0);
      L_15:
        if (if-nez(UnityAdsImplementation.configuration)) goto L_1e;
        new Configuration();
      L_1e:
        LoadModule.getInstance();
        new LoadOperationState(p0, p2, p1, new Configuration(..));
        LoadModule.getInstance(..).executeAdOperation(UnityAdsImplementation.webViewBridgeInvoker, new LoadOperationState(..));
      L_2c:
        return;
    }

    public void setDebugMode(boolean p0) {
        UnityServices.setDebugMode(p0);
        return;
    }

    public void show(Activity p0, String p1) {
        new UnityAdsShowOptions();
        UnityAdsImplementation.show(p0, p1, new UnityAdsShowOptions(..), 0);
        return;
    }

    public void show(Activity p0, String p1, IUnityAdsShowListener p2) {
        new UnityAdsShowOptions();
        UnityAdsImplementation.show(p0, p1, new UnityAdsShowOptions(..), p2);
        return;
    }

    public void show(Activity p0, String p1, UnityAdsShowOptions p2, IUnityAdsShowListener p3) {
        Utilities.getService(AlternativeFlowReader.class);
        Utilities.getService(..).invoke();
        if (if-eqz(AlternativeFlowReader.invoke(..))) goto L_19;
        new UnityAdsImplementation$1(this, p3);
        UnityAdsSDK.INSTANCE.show(p1, p2, new UnityAdsImplementation$1(..));
      L_19:
        UnityAdsImplementation.isSupported();
        if (if-nez(UnityAdsImplementation.isSupported(..))) goto L_27;
        UnityAdsImplementation.handleShowError(p3, p1, UnityAds$UnityAdsShowError.NOT_INITIALIZED, "Unity Ads is not supported for this device");
        return;
      L_27:
        UnityAdsImplementation.isInitialized();
        if (if-nez(UnityAdsImplementation.isInitialized(..))) goto L_35;
        UnityAdsImplementation.handleShowError(p3, p1, UnityAds$UnityAdsShowError.NOT_INITIALIZED, "[UnityAds] SDK not initialized");
        return;
      L_35:
        if (if-nez(UnityAds$UnityAdsShowError.NOT_INITIALIZED)) goto L_3f;
        UnityAdsImplementation.handleShowError(p3, p1, UnityAds$UnityAdsShowError.INVALID_ARGUMENT, "Activity must not be null");
        return;
      L_3f:
        if (if-nez(p1)) goto L_4b;
        UnityAdsImplementation.handleShowError(p3, "", UnityAds$UnityAdsShowError.INVALID_ARGUMENT, "[UnityAds] Placement ID cannot be null");
        return;
      L_4b:
        if (if-nez(UnityAdsImplementation.configuration)) goto L_54;
        new Configuration();
      L_54:
        ClientProperties.setActivity(UnityAds$UnityAdsShowError.INVALID_ARGUMENT);
        ShowModule.getInstance();
        WebViewApp.getCurrentApp();
        new ShowOperationState("[UnityAds] Placement ID cannot be null", p3, UnityAds$UnityAdsShowError.INVALID_ARGUMENT, "", new Configuration(..));
        ShowModule.getInstance(..).executeAdOperation(WebViewApp.getCurrentApp(..), new ShowOperationState);
      L_6d:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.UnityAdsImplementation$1
// ============================================================
package com.unity3d.services.ads;

class UnityAdsImplementation$1 {
    final UnityAdsImplementation this$0;
    final IUnityAdsShowListener val$showListener;

    UnityAdsImplementation$1(UnityAdsImplementation p0, IUnityAdsShowListener p1) {
        this$0 = p0;
        val$showListener = p1;
        new Object();
        return;
    }

    public void onClick(String p0) {
        if (if-eqz(val$showListener)) goto L_7;
        IUnityAdsShowListener.onUnityAdsShowClick(p0);
      L_7:
        return;
    }

    public void onComplete(String p0, UnityAds$UnityAdsShowCompletionState p1) {
        if (if-eqz(val$showListener)) goto L_7;
        IUnityAdsShowListener.onUnityAdsShowComplete(p0, p1);
      L_7:
        return;
    }

    public void onError(String p0, UnityAds$UnityAdsShowError p1, String p2) {
        if (if-eqz(val$showListener)) goto L_7;
        IUnityAdsShowListener.onUnityAdsShowFailure(p0, p1, p2);
      L_7:
        return;
    }

    public void onLeftApplication(String p0) {
        return;
    }

    public void onStart(String p0) {
        if (if-eqz(val$showListener)) goto L_7;
        IUnityAdsShowListener.onUnityAdsShowStart(p0);
      L_7:
        return;
    }

}

