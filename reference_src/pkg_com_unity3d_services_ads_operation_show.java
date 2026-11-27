// Package bundle: com.unity3d.services.ads.operation.show (14 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.operation.show.IShowModule
// ============================================================
package com.unity3d.services.ads.operation.show;

public abstract class IShowModule {
    public abstract void onUnityAdsShowClick(String p0) {
        // native or abstract
    }

    public abstract void onUnityAdsShowComplete(String p0, UnityAds$UnityAdsShowCompletionState p1) {
        // native or abstract
    }

    public abstract void onUnityAdsShowConsent(String p0) {
        // native or abstract
    }

    public abstract void onUnityAdsShowFailure(String p0, UnityAds$UnityAdsShowError p1, String p2) {
        // native or abstract
    }

    public abstract void onUnityAdsShowStart(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.show.IShowOperation
// ============================================================
package com.unity3d.services.ads.operation.show;

public abstract class IShowOperation {
    public abstract ShowOperationState getShowOperationState() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.show.ShowModule
// ============================================================
package com.unity3d.services.ads.operation.show;

public class ShowModule extends AdModule {
    public static String errorMsgPlacementIdNull = "[UnityAds] Placement ID cannot be null";
    private static IShowModule instance;

    static <clinit>() {
        return;
    }

    public ShowModule(SDKMetricsSender p0) {
        new AdModule(p0);
        return;
    }

    static void access$000(ShowModule p0, ShowOperationState p1, String p2, UnityAds$UnityAdsShowError p3, boolean p4) {
        p0.sendOnUnityAdsFailedToShow(p1, p2, p3, p4);
        return;
    }

    public static IShowModule getInstance() {
        if (if-nez(ShowModule.instance)) goto L_1d;
        Utilities.getService(SDKMetricsSender.class);
        new ShowModule(Utilities.getService(..));
        new ExperimentsReader();
        new ShowModuleDecoratorTimeout(new ShowModule(..), new ExperimentsReader(..));
        instance = new ShowModuleDecoratorTimeout(..);
      L_1d:
        return ShowModule.instance;
    }

    private void sendOnUnityAdsFailedToShow(ShowOperationState p0, String p1, UnityAds$UnityAdsShowError p2, boolean p3) {
        if (if-eqz(p0)) goto L_24;
        if (if-nez(listener)) goto L_7;
      L_7:
        if (if-eqz(p3)) goto L_1c;
        ShowModule.getMetricSender();
        p0.duration();
        Long.valueOf(ShowOperationState.duration(..), v1);
        AdOperationMetric.newAdShowFailure(p2, Long.valueOf(..));
        ShowModule.getMetricSender(..).sendMetricWithInitState(AdOperationMetric.newAdShowFailure(..));
      L_1c:
        new ShowModule$2(this, p0, p2, p1);
        Utilities.runOnUiThread(new ShowModule$2(..));
      L_24:
        return;
    }

    public void executeAdOperation(IWebViewBridgeInvoker p0, ShowOperationState p1) {
        TextUtils.isEmpty(placementId);
        if (if-eqz(TextUtils.isEmpty(..))) goto L_13;
        ShowModule.sendOnUnityAdsFailedToShow(p1, ShowModule.errorMsgPlacementIdNull, UnityAds$UnityAdsShowError.INVALID_ARGUMENT, 1);
        return;
      L_13:
        new ShowModule$1(this, p1);
        new WebViewBridgeInvocation(_executorService, ShowModule.errorMsgPlacementIdNull, new ShowModule$1(..));
        new ShowOperation(p1, new WebViewBridgeInvocation(..));
        activity.get();
        ClientProperties.setActivity(WeakReference.get(..));
        WeakReference.get(..).getSystemService("window");
        Activity.getSystemService(..).getDefaultDisplay();
        new JSONObject();
        new JSONObject();
        new JSONObject();
        WeakReference.get(..).getRequestedOrientation();
        new JSONObject(..).put("requestedOrientation", Activity.getRequestedOrientation(..));
        WindowManager.getDefaultDisplay(..).getRotation();
        new JSONObject(..).put("rotation", Display.getRotation(..));
        new Point();
        WindowManager.getDefaultDisplay(..).getSize(new Point(..));
        new JSONObject(..).put("width", x);
        new JSONObject(..).put("height", y);
        new JSONObject(..).put("display", new JSONObject(..));
        showOptions.getData();
        new JSONObject(..).put("headerBiddingOptions", UnityAdsShowOptions.getData(..));
        new JSONObject(..).put("options", new JSONObject(..));
        new ShowOperation(..).getId();
        new JSONObject(..).put("listenerId", IShowOperation.getId(..));
        new JSONObject(..).put("placementId", placementId);
        Device.getElapsedRealtime();
        new JSONObject(..).put("time", Device.getElapsedRealtime(..), UnityAdsShowOptions.getData(..));
        ShowModule.set(new ShowOperation(..));
        configuration.getWebViewBridgeTimeout();
        new ShowOperation(..).invoke(Configuration.getWebViewBridgeTimeout(..), UnityAds$UnityAdsShowError.INVALID_ARGUMENT);
        HdrInfoReader.getInstance();
        new ExperimentsReader();
        HdrInfoReader.getInstance(..).captureHDRCapabilityMetrics(WeakReference.get(..), new ExperimentsReader(..));
        return;
        ShowModule.sendOnUnityAdsFailedToShow(HdrInfoReader.getInstance(..), new ExperimentsReader(..), UnityAds$UnityAdsShowError.INTERNAL_ERROR, 0);
        return;
        ShowModule.sendOnUnityAdsFailedToShow(HdrInfoReader.getInstance(..), new ExperimentsReader(..), UnityAds$UnityAdsShowError.INTERNAL_ERROR, 0);
        return;
    }

    public void executeAdOperation(IWebViewBridgeInvoker p0, Object p1) {
        ShowModule.executeAdOperation(p0, p1);
        return;
    }

    public void onUnityAdsShowClick(String p0) {
        ShowModule.get(p0);
        if (if-eqz(ShowModule.get(..))) goto L_18;
        ShowModule.get(..).getShowOperationState();
        if (if-nez(IShowOperation.getShowOperationState(..))) goto L_f;
      L_f:
        ShowModule.get(..).getShowOperationState();
        ShowModule.get(..).onUnityAdsShowClick(placementId);
      L_18:
        return;
    }

    public void onUnityAdsShowComplete(String p0, UnityAds$UnityAdsShowCompletionState p1) {
        ShowModule.get(p0);
        if (if-eqz(ShowModule.get(..))) goto L_2e;
        ShowModule.get(..).getShowOperationState();
        if (if-nez(IShowOperation.getShowOperationState(..))) goto L_f;
      L_f:
        ShowModule.get(..).getShowOperationState();
        ShowModule.getMetricSender();
        ShowOperationState.duration();
        Long.valueOf(ShowOperationState.duration(..), v4);
        AdOperationMetric.newAdShowSuccess(Long.valueOf(..));
        ShowModule.getMetricSender(..).sendMetricWithInitState(AdOperationMetric.newAdShowSuccess(..));
        ShowModule.get(..).onUnityAdsShowComplete(placementId, p1);
        ShowModule.remove(p0);
      L_2e:
        return;
    }

    public void onUnityAdsShowConsent(String p0) {
        ShowModule.get(p0);
        if (if-eqz(ShowModule.get(..))) goto L_b;
        ShowModule.get(..).getShowOperationState();
      L_b:
        return;
    }

    public void onUnityAdsShowFailure(String p0, UnityAds$UnityAdsShowError p1, String p2) {
        ShowModule.get(p0);
        if (if-eqz(ShowModule.get(..))) goto L_2e;
        ShowModule.get(..).getShowOperationState();
        if (if-nez(IShowOperation.getShowOperationState(..))) goto L_f;
      L_f:
        ShowModule.get(..).getShowOperationState();
        ShowModule.getMetricSender();
        ShowOperationState.duration();
        Long.valueOf(ShowOperationState.duration(..), v4);
        AdOperationMetric.newAdShowFailure(p1, Long.valueOf(..));
        ShowModule.getMetricSender(..).sendMetricWithInitState(AdOperationMetric.newAdShowFailure(..));
        ShowModule.get(..).onUnityAdsShowFailure(placementId, p1, p2);
        ShowModule.remove(p0);
      L_2e:
        return;
    }

    public void onUnityAdsShowStart(String p0) {
        ShowModule.get(p0);
        if (if-eqz(ShowModule.get(..))) goto L_18;
        ShowModule.get(..).getShowOperationState();
        if (if-nez(IShowOperation.getShowOperationState(..))) goto L_f;
      L_f:
        ShowModule.get(..).getShowOperationState();
        ShowModule.get(..).onUnityAdsShowStart(placementId);
      L_18:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.show.ShowModuleDecorator
// ============================================================
package com.unity3d.services.ads.operation.show;

public class ShowModuleDecorator {
    private final IShowModule _showModule;

    public ShowModuleDecorator(IShowModule p0) {
        new Object();
        _showModule = p0;
        return;
    }

    public void executeAdOperation(IWebViewBridgeInvoker p0, ShowOperationState p1) {
        _showModule.executeAdOperation(p0, p1);
        return;
    }

    public void executeAdOperation(IWebViewBridgeInvoker p0, Object p1) {
        ShowModuleDecorator.executeAdOperation(p0, p1);
        return;
    }

    public IShowOperation get(String p0) {
        _showModule.get(p0);
        return IShowModule.get(..);
    }

    public IWebViewSharedObject get(String p0) {
        ShowModuleDecorator.get(p0);
        return ShowModuleDecorator.get(..);
    }

    public SDKMetricsSender getMetricSender() {
        _showModule.getMetricSender();
        return IShowModule.getMetricSender(..);
    }

    public void onUnityAdsShowClick(String p0) {
        _showModule.onUnityAdsShowClick(p0);
        return;
    }

    public void onUnityAdsShowComplete(String p0, UnityAds$UnityAdsShowCompletionState p1) {
        _showModule.onUnityAdsShowComplete(p0, p1);
        return;
    }

    public void onUnityAdsShowConsent(String p0) {
        _showModule.onUnityAdsShowConsent(p0);
        return;
    }

    public void onUnityAdsShowFailure(String p0, UnityAds$UnityAdsShowError p1, String p2) {
        _showModule.onUnityAdsShowFailure(p0, p1, p2);
        return;
    }

    public void onUnityAdsShowStart(String p0) {
        _showModule.onUnityAdsShowStart(p0);
        return;
    }

    public void remove(String p0) {
        _showModule.remove(p0);
        return;
    }

    public void set(IShowOperation p0) {
        _showModule.set(p0);
        return;
    }

    public void set(IWebViewSharedObject p0) {
        ShowModuleDecorator.set(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.show.ShowModuleDecoratorTimeout
// ============================================================
package com.unity3d.services.ads.operation.show;

public class ShowModuleDecoratorTimeout extends ShowModuleDecorator {
    private static final String errorMsgTimeout = "[UnityAds] Timeout while trying to show ";
    private final ExperimentsReader _experimentsReader;

    public ShowModuleDecoratorTimeout(IShowModule p0, ExperimentsReader p1) {
        new ShowModuleDecorator(p0);
        _experimentsReader = p1;
        return;
    }

    static void access$000(ShowModuleDecoratorTimeout p0, ShowOperationState p1, UnityAds$UnityAdsShowError p2, String p3) {
        p0.onOperationTimeout(p1, p2, p3);
        return;
    }

    static void lambda$onOperationTimeout$0(ShowOperationState p0, UnityAds$UnityAdsShowError p1, String p2) {
        p0.onUnityAdsShowFailure(p1, p2);
        return;
    }

    private void onOperationTimeout(ShowOperationState p0, UnityAds$UnityAdsShowError p1, String p2) {
        if (if-eqz(p0)) goto L_24;
        ShowModuleDecoratorTimeout.getMetricSender();
        p0.duration();
        Long.valueOf(ShowOperationState.duration(..), v3);
        AdOperationMetric.newAdShowFailure(AdOperationError.timeout, Long.valueOf(..));
        SDKMetricsSender.sendMetricWithInitState(AdOperationMetric.newAdShowFailure(..));
        ShowModuleDecoratorTimeout.remove(id);
        new ShowModuleDecoratorTimeout$$ExternalSyntheticLambda0(p0, p1, p2);
        Utilities.runOnUiThread(new ShowModuleDecoratorTimeout$$ExternalSyntheticLambda0(..));
      L_24:
        return;
    }

    private void releaseOperationTimeoutLock(String p0) {
        ShowModuleDecoratorTimeout.get(p0);
        if (if-nez(ShowModuleDecoratorTimeout.get(..))) goto L_7;
        return;
      L_7:
        ShowModuleDecoratorTimeout.get(..).getShowOperationState();
        if (if-nez(IShowOperation.getShowOperationState(..))) goto L_e;
        return;
      L_e:
        if (if-nez(timeoutTimer)) goto L_13;
        return;
      L_13:
        timeoutTimer.kill();
        return;
    }

    private void startShowTimeout(ShowOperationState p0) {
        if (if-nez(p0)) goto L_3;
        return;
      L_3:
        configuration.getShowTimeout();
        Integer.valueOf(Configuration.getShowTimeout(..));
        new ShowModuleDecoratorTimeout$1(this, p0);
        new BaseTimer(Integer.valueOf(..), new ShowModuleDecoratorTimeout$1(..));
        timeoutTimer = new BaseTimer(..);
        Executors.newSingleThreadScheduledExecutor();
        timeoutTimer.start(Executors.newSingleThreadScheduledExecutor(..));
        return;
    }

    public void executeAdOperation(IWebViewBridgeInvoker p0, ShowOperationState p1) {
        ShowModuleDecoratorTimeout.getMetricSender();
        AdOperationMetric.newAdShowStart();
        SDKMetricsSender.sendMetricWithInitState(AdOperationMetric.newAdShowStart(..));
        p1.start();
        _experimentsReader.getCurrentlyActiveExperiments();
        IExperiments.isNativeShowTimeoutDisabled();
        if (if-nez(IExperiments.isNativeShowTimeoutDisabled(..))) goto L_1d;
        ShowModuleDecoratorTimeout.startShowTimeout(p1);
      L_1d:
        ShowModuleDecorator.executeAdOperation(p0, p1);
        return;
    }

    public void executeAdOperation(IWebViewBridgeInvoker p0, Object p1) {
        ShowModuleDecoratorTimeout.executeAdOperation(p0, p1);
        return;
    }

    public void onUnityAdsShowConsent(String p0) {
        ShowModuleDecoratorTimeout.releaseOperationTimeoutLock(p0);
        ShowModuleDecorator.onUnityAdsShowConsent(p0);
        return;
    }

    public void onUnityAdsShowFailure(String p0, UnityAds$UnityAdsShowError p1, String p2) {
        ShowModuleDecoratorTimeout.releaseOperationTimeoutLock(p0);
        ShowModuleDecorator.onUnityAdsShowFailure(p0, p1, p2);
        return;
    }

    public void onUnityAdsShowStart(String p0) {
        ShowModuleDecoratorTimeout.releaseOperationTimeoutLock(p0);
        ShowModuleDecorator.onUnityAdsShowStart(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.show.ShowOperation
// ============================================================
package com.unity3d.services.ads.operation.show;

public class ShowOperation extends AdOperation {
    private ShowOperationState showOperationState;

    public ShowOperation(ShowOperationState p0, IWebViewBridgeInvocation p1) {
        new AdOperation(p1, "show");
        showOperationState = p0;
        return;
    }

    static ShowOperationState access$000(ShowOperation p0) {
        return showOperationState;
    }

    public String getId() {
        return id;
    }

    public ShowOperationState getShowOperationState() {
        return showOperationState;
    }

    public void onUnityAdsShowClick(String p0) {
        if (if-nez(showOperationState)) goto L_5;
        return;
      L_5:
        new ShowOperation$3(this);
        Utilities.runOnUiThread(new ShowOperation$3(..));
        return;
    }

    public void onUnityAdsShowComplete(String p0, UnityAds$UnityAdsShowCompletionState p1) {
        if (if-nez(showOperationState)) goto L_5;
        return;
      L_5:
        new ShowOperation$4(this, p1);
        Utilities.runOnUiThread(new ShowOperation$4(..));
        return;
    }

    public void onUnityAdsShowFailure(String p0, UnityAds$UnityAdsShowError p1, String p2) {
        if (if-eqz(showOperationState)) goto L_11;
        if (if-nez(listener)) goto L_9;
      L_9:
        new ShowOperation$1(this, p1, p2);
        Utilities.runOnUiThread(new ShowOperation$1(..));
      L_11:
        return;
    }

    public void onUnityAdsShowStart(String p0) {
        if (if-nez(showOperationState)) goto L_5;
        return;
      L_5:
        new ShowOperation$2(this, p0);
        Utilities.runOnUiThread(new ShowOperation$2(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.show.ShowOperationState
// ============================================================
package com.unity3d.services.ads.operation.show;

public class ShowOperationState extends OperationState {
    public WeakReference activity;
    public IUnityAdsShowListener listener;
    public UnityAdsShowOptions showOptions;

    public ShowOperationState(String p0, IUnityAdsShowListener p1, Activity p2, UnityAdsShowOptions p3, Configuration p4) {
        new OperationState(p0, p4);
        listener = p1;
        new WeakReference(p2);
        activity = new WeakReference(..);
        showOptions = p3;
        return;
    }

    void lambda$onUnityAdsShowClick$1$com-unity3d-services-ads-operation-show-ShowOperationState() {
        listener.onUnityAdsShowClick(placementId);
        return;
    }

    void lambda$onUnityAdsShowComplete$3$com-unity3d-services-ads-operation-show-ShowOperationState(UnityAds$UnityAdsShowCompletionState p0) {
        listener.onUnityAdsShowComplete(placementId, p0);
        return;
    }

    void lambda$onUnityAdsShowFailure$0$com-unity3d-services-ads-operation-show-ShowOperationState(UnityAds$UnityAdsShowError p0, String p1) {
        listener.onUnityAdsShowFailure(placementId, p0, p1);
        return;
    }

    void lambda$onUnityAdsShowStart$2$com-unity3d-services-ads-operation-show-ShowOperationState(String p0) {
        listener.onUnityAdsShowStart(p0);
        return;
    }

    public void onUnityAdsShowClick() {
        if (if-eqz(listener)) goto L_c;
        new ShowOperationState$$ExternalSyntheticLambda1(this);
        Utilities.wrapCustomerListener(new ShowOperationState$$ExternalSyntheticLambda1(..));
      L_c:
        return;
    }

    public void onUnityAdsShowComplete(UnityAds$UnityAdsShowCompletionState p0) {
        if (if-eqz(listener)) goto L_c;
        new ShowOperationState$$ExternalSyntheticLambda0(this, p0);
        Utilities.wrapCustomerListener(new ShowOperationState$$ExternalSyntheticLambda0(..));
      L_c:
        return;
    }

    public void onUnityAdsShowFailure(UnityAds$UnityAdsShowError p0, String p1) {
        if (if-eqz(listener)) goto L_c;
        new ShowOperationState$$ExternalSyntheticLambda3(this, p0, p1);
        Utilities.wrapCustomerListener(new ShowOperationState$$ExternalSyntheticLambda3(..));
      L_c:
        return;
    }

    public void onUnityAdsShowStart(String p0) {
        if (if-eqz(listener)) goto L_c;
        new ShowOperationState$$ExternalSyntheticLambda2(this, p0);
        Utilities.wrapCustomerListener(new ShowOperationState$$ExternalSyntheticLambda2(..));
      L_c:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.show.ShowModule$1
// ============================================================
package com.unity3d.services.ads.operation.show;

class ShowModule$1 {
    final ShowModule this$0;
    final ShowOperationState val$state;

    ShowModule$1(ShowModule p0, ShowOperationState p1) {
        this$0 = p0;
        val$state = p1;
        new Object();
        return;
    }

    public void onFailure(String p0, CallbackStatus p1) {
        this$0.getMetricSender();
        ShowOperationState.duration();
        Long.valueOf(ShowOperationState.duration(..), v2);
        AdOperationMetric.newAdShowFailure(AdOperationError.callback_error, Long.valueOf(..));
        ShowModule.getMetricSender(..).sendMetricWithInitState(AdOperationMetric.newAdShowFailure(..));
        ShowModule.access$000(this$0, val$state, p0, UnityAds$UnityAdsShowError.INTERNAL_ERROR, 0);
        this$0.remove(id);
        return;
    }

    public void onSuccess() {
        return;
    }

    public void onTimeout() {
        this$0.getMetricSender();
        ShowOperationState.duration();
        Long.valueOf(ShowOperationState.duration(..), v3);
        AdOperationMetric.newAdShowFailure(AdOperationError.callback_timeout, Long.valueOf(..));
        ShowModule.getMetricSender(..).sendMetricWithInitState(AdOperationMetric.newAdShowFailure(..));
        ShowModule.access$000(this$0, val$state, "[UnityAds] Show Invocation Timeout", UnityAds$UnityAdsShowError.INTERNAL_ERROR, 0);
        this$0.remove(id);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.show.ShowModule$2
// ============================================================
package com.unity3d.services.ads.operation.show;

class ShowModule$2 {
    final ShowModule this$0;
    final UnityAds$UnityAdsShowError val$error;
    final String val$message;
    final ShowOperationState val$state;

    ShowModule$2(ShowModule p0, ShowOperationState p1, UnityAds$UnityAdsShowError p2, String p3) {
        this$0 = p0;
        val$state = p1;
        val$error = p2;
        val$message = p3;
        new Object();
        return;
    }

    public void run() {
        ShowOperationState.onUnityAdsShowFailure(val$error, val$message);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.show.ShowModuleDecoratorTimeout$1
// ============================================================
package com.unity3d.services.ads.operation.show;

class ShowModuleDecoratorTimeout$1 {
    final ShowModuleDecoratorTimeout this$0;
    final ShowOperationState val$showOperationState;

    ShowModuleDecoratorTimeout$1(ShowModuleDecoratorTimeout p0, ShowOperationState p1) {
        this$0 = p0;
        val$showOperationState = p1;
        new Object();
        return;
    }

    public void onTimerFinished() {
        new StringBuilder("[UnityAds] Timeout while trying to show ");
        new StringBuilder(..).append(placementId);
        new StringBuilder(..).toString();
        ShowModuleDecoratorTimeout.access$000(this$0, val$showOperationState, UnityAds$UnityAdsShowError.TIMEOUT, StringBuilder.toString(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.show.ShowOperation$1
// ============================================================
package com.unity3d.services.ads.operation.show;

class ShowOperation$1 {
    final ShowOperation this$0;
    final UnityAds$UnityAdsShowError val$error;
    final String val$message;

    ShowOperation$1(ShowOperation p0, UnityAds$UnityAdsShowError p1, String p2) {
        this$0 = p0;
        val$error = p1;
        val$message = p2;
        new Object();
        return;
    }

    public void run() {
        ShowOperation.access$000(this$0);
        if (if-eqz(ShowOperation.access$000(..))) goto L_15;
        ShowOperation.access$000(this$0);
        ShowOperation.access$000(..).onUnityAdsShowFailure(val$error, val$message);
      L_15:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.show.ShowOperation$2
// ============================================================
package com.unity3d.services.ads.operation.show;

class ShowOperation$2 {
    final ShowOperation this$0;
    final String val$placementId;

    ShowOperation$2(ShowOperation p0, String p1) {
        this$0 = p0;
        val$placementId = p1;
        new Object();
        return;
    }

    public void run() {
        ShowOperation.access$000(this$0);
        if (if-eqz(ShowOperation.access$000(..))) goto L_13;
        ShowOperation.access$000(this$0);
        ShowOperation.access$000(..).onUnityAdsShowStart(val$placementId);
      L_13:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.show.ShowOperation$3
// ============================================================
package com.unity3d.services.ads.operation.show;

class ShowOperation$3 {
    final ShowOperation this$0;

    ShowOperation$3(ShowOperation p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void run() {
        ShowOperation.access$000(this$0);
        if (if-eqz(ShowOperation.access$000(..))) goto L_11;
        ShowOperation.access$000(this$0);
        ShowOperation.access$000(..).onUnityAdsShowClick();
      L_11:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.show.ShowOperation$4
// ============================================================
package com.unity3d.services.ads.operation.show;

class ShowOperation$4 {
    final ShowOperation this$0;
    final UnityAds$UnityAdsShowCompletionState val$state;

    ShowOperation$4(ShowOperation p0, UnityAds$UnityAdsShowCompletionState p1) {
        this$0 = p0;
        val$state = p1;
        new Object();
        return;
    }

    public void run() {
        ShowOperation.access$000(this$0);
        if (if-eqz(ShowOperation.access$000(..))) goto L_13;
        ShowOperation.access$000(this$0);
        ShowOperation.access$000(..).onUnityAdsShowComplete(val$state);
      L_13:
        return;
    }

}

