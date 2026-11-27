// Package bundle: com.unity3d.services.ads.operation.load (18 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.BaseLoadModule
// ============================================================
package com.unity3d.services.ads.operation.load;

public abstract class BaseLoadModule extends AdModule {
    static final String errorMsgFailedToCreateLoadRequest = "[UnityAds] Failed to create load request";
    static final String errorMsgInternalCommunicationFailure = "[UnityAds] Internal communication failure";
    static final String errorMsgInternalCommunicationTimeout = "[UnityAds] Internal communication timeout";
    static final String errorMsgPlacementIdNull = "[UnityAds] Placement ID cannot be null";

    public BaseLoadModule(SDKMetricsSender p0) {
        new AdModule(p0);
        return;
    }

    static void access$000(BaseLoadModule p0, LoadOperationState p1, UnityAds$UnityAdsLoadError p2, String p3, boolean p4) {
        p0.sendOnUnityAdsFailedToLoad(p1, p2, p3, p4);
        return;
    }

    private void sendOnUnityAdsFailedToLoad(LoadOperationState p0, UnityAds$UnityAdsLoadError p1, String p2, boolean p3) {
        if (if-eqz(p0)) goto L_2c;
        if (if-nez(listener)) goto L_7;
      L_7:
        if (if-eqz(p3)) goto L_24;
        BaseLoadModule.getMetricSender();
        p0.duration();
        Long.valueOf(LoadOperationState.duration(..), v1);
        p0.isBanner();
        p0.isHeaderBidding();
        AdOperationMetric.newAdLoadFailure(p1, Long.valueOf(..), LoadOperationState.isBanner(..), LoadOperationState.isHeaderBidding(..));
        BaseLoadModule.getMetricSender(..).sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(..));
      L_24:
        new BaseLoadModule$2(this, p0, p1, p2);
        Utilities.runOnUiThread(new BaseLoadModule$2(..));
      L_2c:
        return;
    }

    abstract void addOptionalParameters(LoadOperationState p0, JSONObject p1) {
        // native or abstract
    }

    JSONObject buildBaseOptions(LoadOperationState p0) {
        new JSONObject();
        loadOptions.getData();
        new JSONObject(..).put("headerBiddingOptions", UnityAdsLoadOptions.getData(..));
        return new JSONObject(..);
    }

    JSONObject buildBaseParameters(LoadOperationState p0, LoadOperation p1) {
        new JSONObject();
        BaseLoadModule.buildBaseOptions(p0);
        loadOptions.getData();
        BaseLoadModule.buildBaseOptions(..).put("headerBiddingOptions", UnityAdsLoadOptions.getData(..));
        new JSONObject(..).put("options", BaseLoadModule.buildBaseOptions(..));
        p1.getId();
        new JSONObject(..).put("listenerId", LoadOperation.getId(..));
        new JSONObject(..).put("placementId", placementId);
        Device.getElapsedRealtime();
        new JSONObject(..).put("time", Device.getElapsedRealtime(..), "options");
        BaseLoadModule.addOptionalParameters(p0, new JSONObject(..));
        return new JSONObject(..);
    }

    public void executeAdOperation(IWebViewBridgeInvoker p0, LoadOperationState p1) {
        TextUtils.isEmpty(placementId);
        if (if-eqz(TextUtils.isEmpty(..))) goto L_11;
        BaseLoadModule.sendOnUnityAdsFailedToLoad(p1, UnityAds$UnityAdsLoadError.INVALID_ARGUMENT, "[UnityAds] Placement ID cannot be null", 1);
        return;
      L_11:
        new BaseLoadModule$1(this, p1);
        new WebViewBridgeInvocation(_executorService, UnityAds$UnityAdsLoadError.INVALID_ARGUMENT, new BaseLoadModule$1(..));
        new LoadOperation(p1, new WebViewBridgeInvocation(..));
        BaseLoadModule.buildBaseParameters(p1, new LoadOperation(..));
        BaseLoadModule.set(new LoadOperation(..));
        configuration.getWebViewBridgeTimeout();
        new LoadOperation(..).invoke(Configuration.getWebViewBridgeTimeout(..), 1);
        return;
        BaseLoadModule.sendOnUnityAdsFailedToLoad(Configuration.getWebViewBridgeTimeout(..), UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "[UnityAds] Failed to create load request", 1);
        return;
    }

    public void executeAdOperation(IWebViewBridgeInvoker p0, Object p1) {
        BaseLoadModule.executeAdOperation(p0, p1);
        return;
    }

    public void onUnityAdsAdLoaded(String p0) {
        BaseLoadModule.get(p0);
        if (if-eqz(BaseLoadModule.get(..))) goto L_36;
        BaseLoadModule.get(..).getLoadOperationState();
        if (if-nez(ILoadOperation.getLoadOperationState(..))) goto L_f;
      L_f:
        BaseLoadModule.get(..).getLoadOperationState();
        BaseLoadModule.getMetricSender();
        LoadOperationState.duration();
        Long.valueOf(LoadOperationState.duration(..), v4);
        LoadOperationState.isBanner();
        LoadOperationState.isHeaderBidding();
        AdOperationMetric.newAdLoadSuccess(Long.valueOf(..), LoadOperationState.isBanner(..), LoadOperationState.isHeaderBidding(..));
        BaseLoadModule.getMetricSender(..).sendMetricWithInitState(AdOperationMetric.newAdLoadSuccess(..));
        BaseLoadModule.get(..).onUnityAdsAdLoaded(placementId);
        BaseLoadModule.remove(p0);
      L_36:
        return;
    }

    public void onUnityAdsFailedToLoad(String p0, UnityAds$UnityAdsLoadError p1, String p2) {
        BaseLoadModule.get(p0);
        if (if-eqz(BaseLoadModule.get(..))) goto L_36;
        BaseLoadModule.get(..).getLoadOperationState();
        if (if-nez(ILoadOperation.getLoadOperationState(..))) goto L_f;
      L_f:
        BaseLoadModule.get(..).getLoadOperationState();
        BaseLoadModule.getMetricSender();
        LoadOperationState.duration();
        Long.valueOf(LoadOperationState.duration(..), v4);
        LoadOperationState.isBanner();
        LoadOperationState.isHeaderBidding();
        AdOperationMetric.newAdLoadFailure(p1, Long.valueOf(..), LoadOperationState.isBanner(..), LoadOperationState.isHeaderBidding(..));
        BaseLoadModule.getMetricSender(..).sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(..));
        BaseLoadModule.get(..).onUnityAdsFailedToLoad(placementId, p1, p2);
        BaseLoadModule.remove(p0);
      L_36:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.ILoadModule
// ============================================================
package com.unity3d.services.ads.operation.load;

public abstract class ILoadModule {
    public abstract void onUnityAdsAdLoaded(String p0) {
        // native or abstract
    }

    public abstract void onUnityAdsFailedToLoad(String p0, UnityAds$UnityAdsLoadError p1, String p2) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.ILoadOperation
// ============================================================
package com.unity3d.services.ads.operation.load;

public abstract class ILoadOperation {
    public abstract LoadOperationState getLoadOperationState() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.LoadBannerModule
// ============================================================
package com.unity3d.services.ads.operation.load;

public class LoadBannerModule extends BaseLoadModule {
    static ILoadModule _instance;

    public LoadBannerModule(SDKMetricsSender p0) {
        new BaseLoadModule(p0);
        return;
    }

    public static ILoadModule getInstance() {
        if (if-nez(LoadBannerModule._instance)) goto L_26;
        Utilities.getService(SDKMetricsSender.class);
        new LoadBannerModule(Utilities.getService(..));
        InitializationNotificationCenter.getInstance();
        new LoadModuleDecoratorInitializationBuffer(new LoadBannerModule(..), InitializationNotificationCenter.getInstance(..));
        new ExperimentsReader();
        new LoadModuleDecoratorTimeout(new LoadModuleDecoratorInitializationBuffer(..), new ExperimentsReader(..));
        _instance = new LoadModuleDecoratorTimeout(..);
      L_26:
        return LoadBannerModule._instance;
    }

    protected void addOptionalParameters(LoadOperationState p0, JSONObject p1) {
        if (if-eqz(v0)) goto L_20;
        p0.getSize();
        LoadBannerOperationState.getSize(..).getWidth();
        p1.put("width", UnityBannerSize.getWidth(..));
        p0.getSize();
        LoadBannerOperationState.getSize(..).getHeight();
        p1.put("height", UnityBannerSize.getHeight(..));
      L_20:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.LoadBannerOperationState
// ============================================================
package com.unity3d.services.ads.operation.load;

public class LoadBannerOperationState extends LoadOperationState {
    private ScarAdMetadata _scarAdMetadata;
    private UnityBannerSize _size;

    public LoadBannerOperationState(String p0, String p1, UnityBannerSize p2, IUnityAdsLoadListener p3, UnityAdsLoadOptions p4, Configuration p5) {
        new LoadOperationState(p0, p3, p4, p5);
        id = p1;
        _size = p2;
        return;
    }

    public ScarAdMetadata getScarAdMetadata() {
        return _scarAdMetadata;
    }

    public UnityBannerSize getSize() {
        return _size;
    }

    public boolean isScarAd() {
        if (if-eqz(_scarAdMetadata)) goto L_6;
      L_6:
      L_7:
        return 0;
    }

    public void setScarAdMetadata(ScarAdMetadata p0) {
        _scarAdMetadata = p0;
        return;
    }

    public void setSize(UnityBannerSize p0) {
        _size = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.LoadModule
// ============================================================
package com.unity3d.services.ads.operation.load;

public class LoadModule extends BaseLoadModule {
    static ILoadModule _instance;

    public LoadModule(SDKMetricsSender p0) {
        new BaseLoadModule(p0);
        return;
    }

    public static ILoadModule getInstance() {
        if (if-nez(LoadModule._instance)) goto L_26;
        Utilities.getService(SDKMetricsSender.class);
        new LoadModule(Utilities.getService(..));
        InitializationNotificationCenter.getInstance();
        new LoadModuleDecoratorInitializationBuffer(new LoadModule(..), InitializationNotificationCenter.getInstance(..));
        new ExperimentsReader();
        new LoadModuleDecoratorTimeout(new LoadModuleDecoratorInitializationBuffer(..), new ExperimentsReader(..));
        _instance = new LoadModuleDecoratorTimeout(..);
      L_26:
        return LoadModule._instance;
    }

    void addOptionalParameters(LoadOperationState p0, JSONObject p1) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.LoadModuleDecorator
// ============================================================
package com.unity3d.services.ads.operation.load;

public class LoadModuleDecorator {
    private final ILoadModule _loadModule;

    public LoadModuleDecorator(ILoadModule p0) {
        new Object();
        _loadModule = p0;
        return;
    }

    public void executeAdOperation(IWebViewBridgeInvoker p0, LoadOperationState p1) {
        _loadModule.executeAdOperation(p0, p1);
        return;
    }

    public void executeAdOperation(IWebViewBridgeInvoker p0, Object p1) {
        LoadModuleDecorator.executeAdOperation(p0, p1);
        return;
    }

    public ILoadOperation get(String p0) {
        _loadModule.get(p0);
        return ILoadModule.get(..);
    }

    public IWebViewSharedObject get(String p0) {
        LoadModuleDecorator.get(p0);
        return LoadModuleDecorator.get(..);
    }

    public SDKMetricsSender getMetricSender() {
        _loadModule.getMetricSender();
        return ILoadModule.getMetricSender(..);
    }

    public void onUnityAdsAdLoaded(String p0) {
        _loadModule.onUnityAdsAdLoaded(p0);
        return;
    }

    public void onUnityAdsFailedToLoad(String p0, UnityAds$UnityAdsLoadError p1, String p2) {
        _loadModule.onUnityAdsFailedToLoad(p0, p1, p2);
        return;
    }

    public void remove(String p0) {
        _loadModule.remove(p0);
        return;
    }

    public void set(ILoadOperation p0) {
        _loadModule.set(p0);
        return;
    }

    public void set(IWebViewSharedObject p0) {
        LoadModuleDecorator.set(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.LoadModuleDecoratorInitializationBuffer
// ============================================================
package com.unity3d.services.ads.operation.load;

public class LoadModuleDecoratorInitializationBuffer extends LoadModuleDecorator {
    private static final String errorMsgInitializationFailed = "[UnityAds] SDK Initialization Failed";
    private static final String errorMsgInitializationFailure = "[UnityAds] SDK Initialization Failure";
    private ConcurrentHashMap _queuedLoadEvents;

    public LoadModuleDecoratorInitializationBuffer(ILoadModule p0, IInitializationNotificationCenter p1) {
        new LoadModuleDecorator(p0);
        p1.addListener(new LoadModuleDecorator(..));
        new ConcurrentHashMap();
        _queuedLoadEvents = new ConcurrentHashMap(..);
        return;
    }

    private void sendOnUnityAdsFailedToLoad(LoadOperationState p0, UnityAds$UnityAdsLoadError p1, String p2) {
        if (if-eqz(p0)) goto L_2a;
        if (if-nez(listener)) goto L_7;
      L_7:
        LoadModuleDecoratorInitializationBuffer.getMetricSender();
        p0.duration();
        Long.valueOf(LoadOperationState.duration(..), v2);
        p0.isBanner();
        p0.isHeaderBidding();
        AdOperationMetric.newAdLoadFailure(p1, Long.valueOf(..), LoadOperationState.isBanner(..), LoadOperationState.isHeaderBidding(..));
        SDKMetricsSender.sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(..));
        new LoadModuleDecoratorInitializationBuffer$1(this, p0, p1, p2);
        Utilities.runOnUiThread(new LoadModuleDecoratorInitializationBuffer$1(..));
      L_2a:
        return;
    }

    public void executeAdOperation(IWebViewBridgeInvoker p0, LoadOperationState p1) {
        if (if-nez(p1)) goto L_3;
        return;
      L_3:
        SdkProperties.getCurrentInitializationState();
        SdkProperties$InitializationState.ordinal();
        if (if-eq(LoadModuleDecoratorInitializationBuffer$2.$SwitchMap$com$unity3d$services$core$properties$SdkProperties$InitializationState, 1)) goto L_23;
        if (if-eq(LoadModuleDecoratorInitializationBuffer$2.$SwitchMap$com$unity3d$services$core$properties$SdkProperties$InitializationState, 2)) goto L_1b;
        _queuedLoadEvents.put(p1, p0);
      L_1b:
        LoadModuleDecoratorInitializationBuffer.sendOnUnityAdsFailedToLoad(p1, UnityAds$UnityAdsLoadError.INITIALIZE_FAILED, "[UnityAds] SDK Initialization Failed");
      L_23:
        LoadModuleDecorator.executeAdOperation(UnityAds$UnityAdsLoadError.INITIALIZE_FAILED, p1);
      L_26:
        return;
    }

    public void executeAdOperation(IWebViewBridgeInvoker p0, Object p1) {
        LoadModuleDecoratorInitializationBuffer.executeAdOperation(p0, p1);
        return;
    }

    public void onSdkInitializationFailed(String p0, ErrorState p1, int p2) {
        _queuedLoadEvents.keySet();
        ConcurrentHashMap.keySet(..).iterator();
      L_b:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_1f;
        Set.iterator(..).next();
        LoadModuleDecoratorInitializationBuffer.sendOnUnityAdsFailedToLoad(Iterator.next(..), UnityAds$UnityAdsLoadError.INITIALIZE_FAILED, "[UnityAds] SDK Initialization Failure");
      L_1f:
        _queuedLoadEvents.clear();
        return;
        throw _queuedLoadEvents;
    }

    public void onSdkInitialized() {
        _queuedLoadEvents.entrySet();
        ConcurrentHashMap.entrySet(..).iterator();
      L_b:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_27;
        Set.iterator(..).next();
        Iterator.next(..).getValue();
        Iterator.next(..).getKey();
        LoadModuleDecorator.executeAdOperation(Map$Entry.getValue(..), Map$Entry.getKey(..));
      L_27:
        _queuedLoadEvents.clear();
        return;
        throw _queuedLoadEvents;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.LoadModuleDecoratorTimeout
// ============================================================
package com.unity3d.services.ads.operation.load;

public class LoadModuleDecoratorTimeout extends LoadModuleDecorator {
    private static final String errorMsgTimeoutLoading = "[UnityAds] Timeout while loading ";
    private final ExperimentsReader _experimentsReader;

    public LoadModuleDecoratorTimeout(ILoadModule p0, ExperimentsReader p1) {
        new LoadModuleDecorator(p0);
        _experimentsReader = p1;
        return;
    }

    static void access$000(LoadModuleDecoratorTimeout p0, LoadOperationState p1) {
        p0.onOperationTimeout(p1);
        return;
    }

    static void lambda$onOperationTimeout$0(LoadOperationState p0) {
        new StringBuilder("[UnityAds] Timeout while loading ");
        new StringBuilder(..).append(placementId);
        new StringBuilder(..).toString();
        p0.onUnityAdsFailedToLoad(UnityAds$UnityAdsLoadError.TIMEOUT, StringBuilder.toString(..));
        return;
    }

    private void onOperationTimeout(LoadOperationState p0) {
        if (if-eqz(p0)) goto L_2c;
        LoadModuleDecoratorTimeout.getMetricSender();
        p0.duration();
        Long.valueOf(LoadOperationState.duration(..), v3);
        p0.isBanner();
        p0.isHeaderBidding();
        AdOperationMetric.newAdLoadFailure(AdOperationError.timeout, Long.valueOf(..), LoadOperationState.isBanner(..), LoadOperationState.isHeaderBidding(..));
        SDKMetricsSender.sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(..));
        LoadModuleDecoratorTimeout.remove(id);
        new LoadModuleDecoratorTimeout$$ExternalSyntheticLambda0(p0);
        Utilities.runOnUiThread(new LoadModuleDecoratorTimeout$$ExternalSyntheticLambda0(..));
      L_2c:
        return;
    }

    private void releaseOperationTimeoutLock(String p0) {
        LoadModuleDecoratorTimeout.get(p0);
        if (if-nez(LoadModuleDecoratorTimeout.get(..))) goto L_7;
        return;
      L_7:
        LoadModuleDecoratorTimeout.get(..).getLoadOperationState();
        if (if-nez(ILoadOperation.getLoadOperationState(..))) goto L_e;
        return;
      L_e:
        if (if-nez(timeoutTimer)) goto L_13;
        return;
      L_13:
        timeoutTimer.kill();
        return;
    }

    private void startLoadTimeout(LoadOperationState p0) {
        if (if-nez(p0)) goto L_3;
        return;
      L_3:
        configuration.getLoadTimeout();
        Integer.valueOf(Configuration.getLoadTimeout(..));
        new LoadModuleDecoratorTimeout$1(this, p0);
        new BaseTimer(Integer.valueOf(..), new LoadModuleDecoratorTimeout$1(..));
        timeoutTimer = new BaseTimer(..);
        Executors.newSingleThreadScheduledExecutor();
        timeoutTimer.start(Executors.newSingleThreadScheduledExecutor(..));
        return;
    }

    public void executeAdOperation(IWebViewBridgeInvoker p0, LoadOperationState p1) {
        LoadModuleDecoratorTimeout.getMetricSender();
        p1.isBanner();
        p1.isHeaderBidding();
        AdOperationMetric.newAdLoadStart(LoadOperationState.isBanner(..), LoadOperationState.isHeaderBidding(..));
        SDKMetricsSender.sendMetricWithInitState(AdOperationMetric.newAdLoadStart(..));
        p1.start();
        _experimentsReader.getCurrentlyActiveExperiments();
        IExperiments.isNativeLoadTimeoutDisabled();
        if (if-nez(IExperiments.isNativeLoadTimeoutDisabled(..))) goto L_25;
        LoadModuleDecoratorTimeout.startLoadTimeout(p1);
      L_25:
        LoadModuleDecorator.executeAdOperation(p0, p1);
        return;
    }

    public void executeAdOperation(IWebViewBridgeInvoker p0, Object p1) {
        LoadModuleDecoratorTimeout.executeAdOperation(p0, p1);
        return;
    }

    public void onUnityAdsAdLoaded(String p0) {
        LoadModuleDecoratorTimeout.releaseOperationTimeoutLock(p0);
        LoadModuleDecorator.onUnityAdsAdLoaded(p0);
        return;
    }

    public void onUnityAdsFailedToLoad(String p0, UnityAds$UnityAdsLoadError p1, String p2) {
        LoadModuleDecoratorTimeout.releaseOperationTimeoutLock(p0);
        LoadModuleDecorator.onUnityAdsFailedToLoad(p0, p1, p2);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.LoadOperation
// ============================================================
package com.unity3d.services.ads.operation.load;

public class LoadOperation extends AdOperation {
    private LoadOperationState _loadOperationState;

    public LoadOperation(LoadOperationState p0, IWebViewBridgeInvocation p1) {
        new AdOperation(p1, "load");
        _loadOperationState = p0;
        return;
    }

    static LoadOperationState access$000(LoadOperation p0) {
        return _loadOperationState;
    }

    public String getId() {
        return id;
    }

    public LoadOperationState getLoadOperationState() {
        return _loadOperationState;
    }

    public void onUnityAdsAdLoaded(String p0) {
        if (if-eqz(_loadOperationState)) goto L_13;
        if (if-eqz(listener)) goto L_13;
        if (if-nez(p0)) goto L_b;
      L_b:
        new LoadOperation$1(this);
        Utilities.runOnUiThread(new LoadOperation$1(..));
      L_13:
        return;
    }

    public void onUnityAdsFailedToLoad(String p0, UnityAds$UnityAdsLoadError p1, String p2) {
        if (if-eqz(_loadOperationState)) goto L_13;
        if (if-eqz(listener)) goto L_13;
        if (if-nez(p0)) goto L_b;
      L_b:
        new LoadOperation$2(this, p1, p2);
        Utilities.runOnUiThread(new LoadOperation$2(..));
      L_13:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.LoadOperationState
// ============================================================
package com.unity3d.services.ads.operation.load;

public class LoadOperationState extends OperationState {
    public IUnityAdsLoadListener listener;
    public UnityAdsLoadOptions loadOptions;

    public LoadOperationState(String p0, IUnityAdsLoadListener p1, UnityAdsLoadOptions p2, Configuration p3) {
        new OperationState(p0, p3);
        listener = p1;
        loadOptions = p2;
        return;
    }

    public boolean isBanner() {
        return v0;
    }

    public boolean isHeaderBidding() {
        if (if-eqz(loadOptions)) goto L_18;
        loadOptions.getData();
        if (if-nez(UnityAdsLoadOptions.getData(..))) goto L_b;
      L_b:
        loadOptions.getData();
        UnityAdsLoadOptions.getData(..).has("adMarkup");
        return JSONObject.has(..);
      L_18:
        return 0;
    }

    void lambda$onUnityAdsAdLoaded$1$com-unity3d-services-ads-operation-load-LoadOperationState() {
        listener.onUnityAdsAdLoaded(placementId);
        return;
    }

    void lambda$onUnityAdsFailedToLoad$0$com-unity3d-services-ads-operation-load-LoadOperationState(UnityAds$UnityAdsLoadError p0, String p1) {
        listener.onUnityAdsFailedToLoad(placementId, p0, p1);
        return;
    }

    public void onUnityAdsAdLoaded() {
        if (if-eqz(listener)) goto L_c;
        new LoadOperationState$$ExternalSyntheticLambda0(this);
        Utilities.wrapCustomerListener(new LoadOperationState$$ExternalSyntheticLambda0(..));
      L_c:
        return;
    }

    public void onUnityAdsFailedToLoad(UnityAds$UnityAdsLoadError p0, String p1) {
        if (if-eqz(listener)) goto L_c;
        new LoadOperationState$$ExternalSyntheticLambda1(this, p0, p1);
        Utilities.wrapCustomerListener(new LoadOperationState$$ExternalSyntheticLambda1(..));
      L_c:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.BaseLoadModule$1
// ============================================================
package com.unity3d.services.ads.operation.load;

class BaseLoadModule$1 {
    final BaseLoadModule this$0;
    final LoadOperationState val$state;

    BaseLoadModule$1(BaseLoadModule p0, LoadOperationState p1) {
        this$0 = p0;
        val$state = p1;
        new Object();
        return;
    }

    public void onFailure(String p0, CallbackStatus p1) {
        this$0.getMetricSender();
        LoadOperationState.duration();
        Long.valueOf(LoadOperationState.duration(..), v1);
        LoadOperationState.isBanner();
        LoadOperationState.isHeaderBidding();
        AdOperationMetric.newAdLoadFailure(AdOperationError.callback_error, Long.valueOf(..), LoadOperationState.isBanner(..), LoadOperationState.isHeaderBidding(..));
        BaseLoadModule.getMetricSender(..).sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(..));
        BaseLoadModule.access$000(this$0, val$state, UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "[UnityAds] Internal communication failure", 0);
        LoadOperationState.getId();
        this$0.remove(LoadOperationState.getId(..));
        return;
    }

    public void onSuccess() {
        return;
    }

    public void onTimeout() {
        this$0.getMetricSender();
        LoadOperationState.duration();
        Long.valueOf(LoadOperationState.duration(..), v3);
        LoadOperationState.isBanner();
        LoadOperationState.isHeaderBidding();
        AdOperationMetric.newAdLoadFailure(AdOperationError.callback_timeout, Long.valueOf(..), LoadOperationState.isBanner(..), LoadOperationState.isHeaderBidding(..));
        BaseLoadModule.getMetricSender(..).sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(..));
        BaseLoadModule.access$000(this$0, val$state, UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "[UnityAds] Internal communication timeout", 0);
        LoadOperationState.getId();
        this$0.remove(LoadOperationState.getId(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.BaseLoadModule$2
// ============================================================
package com.unity3d.services.ads.operation.load;

class BaseLoadModule$2 {
    final BaseLoadModule this$0;
    final UnityAds$UnityAdsLoadError val$error;
    final String val$message;
    final LoadOperationState val$state;

    BaseLoadModule$2(BaseLoadModule p0, LoadOperationState p1, UnityAds$UnityAdsLoadError p2, String p3) {
        this$0 = p0;
        val$state = p1;
        val$error = p2;
        val$message = p3;
        new Object();
        return;
    }

    public void run() {
        LoadOperationState.onUnityAdsFailedToLoad(val$error, val$message);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.LoadModuleDecoratorInitializationBuffer$1
// ============================================================
package com.unity3d.services.ads.operation.load;

class LoadModuleDecoratorInitializationBuffer$1 {
    final LoadModuleDecoratorInitializationBuffer this$0;
    final UnityAds$UnityAdsLoadError val$error;
    final String val$message;
    final LoadOperationState val$state;

    LoadModuleDecoratorInitializationBuffer$1(LoadModuleDecoratorInitializationBuffer p0, LoadOperationState p1, UnityAds$UnityAdsLoadError p2, String p3) {
        this$0 = p0;
        val$state = p1;
        val$error = p2;
        val$message = p3;
        new Object();
        return;
    }

    public void run() {
        listener.onUnityAdsFailedToLoad(placementId, val$error, val$message);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.LoadModuleDecoratorInitializationBuffer$2
// ============================================================
package com.unity3d.services.ads.operation.load;

class LoadModuleDecoratorInitializationBuffer$2 {
    static final int[] $SwitchMap$com$unity3d$services$core$properties$SdkProperties$InitializationState;

    static <clinit>() {
        SdkProperties$InitializationState.values();
        $SwitchMap$com$unity3d$services$core$properties$SdkProperties$InitializationState = SdkProperties$InitializationState.values(..);
        SdkProperties$InitializationState.ordinal();
        SdkProperties$InitializationState.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.LoadModuleDecoratorTimeout$1
// ============================================================
package com.unity3d.services.ads.operation.load;

class LoadModuleDecoratorTimeout$1 {
    final LoadModuleDecoratorTimeout this$0;
    final LoadOperationState val$loadOperationState;

    LoadModuleDecoratorTimeout$1(LoadModuleDecoratorTimeout p0, LoadOperationState p1) {
        this$0 = p0;
        val$loadOperationState = p1;
        new Object();
        return;
    }

    public void onTimerFinished() {
        LoadModuleDecoratorTimeout.access$000(this$0, val$loadOperationState);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.LoadOperation$1
// ============================================================
package com.unity3d.services.ads.operation.load;

class LoadOperation$1 {
    final LoadOperation this$0;

    LoadOperation$1(LoadOperation p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void run() {
        LoadOperation.access$000(this$0);
        if (if-eqz(LoadOperation.access$000(..))) goto L_11;
        LoadOperation.access$000(this$0);
        LoadOperation.access$000(..).onUnityAdsAdLoaded();
      L_11:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.load.LoadOperation$2
// ============================================================
package com.unity3d.services.ads.operation.load;

class LoadOperation$2 {
    final LoadOperation this$0;
    final UnityAds$UnityAdsLoadError val$error;
    final String val$message;

    LoadOperation$2(LoadOperation p0, UnityAds$UnityAdsLoadError p1, String p2) {
        this$0 = p0;
        val$error = p1;
        val$message = p2;
        new Object();
        return;
    }

    public void run() {
        LoadOperation.access$000(this$0);
        if (if-eqz(LoadOperation.access$000(..))) goto L_15;
        LoadOperation.access$000(this$0);
        LoadOperation.access$000(..).onUnityAdsFailedToLoad(val$error, val$message);
      L_15:
        return;
    }

}

