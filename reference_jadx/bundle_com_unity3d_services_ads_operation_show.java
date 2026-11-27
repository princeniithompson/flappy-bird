
// ===== FILE: com/unity3d/services/ads/operation/show/IShowModule.java =====
package com.unity3d.services.ads.operation.show;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.IAdModule;

/* loaded from: classes.dex */
public interface IShowModule extends IAdModule<IShowOperation, ShowOperationState> {
    void onUnityAdsShowClick(String str);

    void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState);

    void onUnityAdsShowConsent(String str);

    void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2);

    void onUnityAdsShowStart(String str);
}

// ===== FILE: com/unity3d/services/ads/operation/show/IShowOperation.java =====
package com.unity3d.services.ads.operation.show;

import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.services.ads.operation.IAdOperation;

/* loaded from: classes.dex */
public interface IShowOperation extends IAdOperation, IUnityAdsShowListener {
    ShowOperationState getShowOperationState();
}

// ===== FILE: com/unity3d/services/ads/operation/show/ShowModule.java =====
package com.unity3d.services.ads.operation.show;

import android.app.Activity;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.constraintlayout.motion.widget.Key;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.AdModule;
import com.unity3d.services.core.configuration.ExperimentsReader;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.device.reader.HdrInfoReader;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.request.metrics.AdOperationError;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.CallbackStatus;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback;
import com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocation;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ShowModule extends AdModule<IShowOperation, ShowOperationState> implements IShowModule {
    public static String errorMsgPlacementIdNull = "[UnityAds] Placement ID cannot be null";
    private static IShowModule instance;

    public static IShowModule getInstance() {
        if (instance == null) {
            instance = new ShowModuleDecoratorTimeout(new ShowModule((SDKMetricsSender) Utilities.getService(SDKMetricsSender.class)), new ExperimentsReader());
        }
        return instance;
    }

    public ShowModule(SDKMetricsSender sDKMetricsSender) {
        super(sDKMetricsSender);
    }

    @Override // com.unity3d.services.ads.operation.IAdModule
    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, final ShowOperationState showOperationState) {
        if (TextUtils.isEmpty(showOperationState.placementId)) {
            sendOnUnityAdsFailedToShow(showOperationState, errorMsgPlacementIdNull, UnityAds.UnityAdsShowError.INVALID_ARGUMENT, true);
            return;
        }
        ShowOperation showOperation = new ShowOperation(showOperationState, new WebViewBridgeInvocation(this._executorService, iWebViewBridgeInvoker, new IWebViewBridgeInvocationCallback() { // from class: com.unity3d.services.ads.operation.show.ShowModule.1
            @Override // com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback
            public void onSuccess() {
            }

            @Override // com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback
            public void onFailure(String str, CallbackStatus callbackStatus) {
                ShowModule.this.getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdShowFailure(AdOperationError.callback_error, Long.valueOf(showOperationState.duration())));
                ShowModule.this.sendOnUnityAdsFailedToShow(showOperationState, str, UnityAds.UnityAdsShowError.INTERNAL_ERROR, false);
                ShowModule.this.remove(showOperationState.f691id);
            }

            @Override // com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback
            public void onTimeout() {
                ShowModule.this.getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdShowFailure(AdOperationError.callback_timeout, Long.valueOf(showOperationState.duration())));
                ShowModule.this.sendOnUnityAdsFailedToShow(showOperationState, "[UnityAds] Show Invocation Timeout", UnityAds.UnityAdsShowError.INTERNAL_ERROR, false);
                ShowModule.this.remove(showOperationState.f691id);
            }
        }));
        Activity activity = showOperationState.activity.get();
        ClientProperties.setActivity(activity);
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("requestedOrientation", activity.getRequestedOrientation());
            jSONObject3.put(Key.ROTATION, defaultDisplay.getRotation());
            Point point = new Point();
            defaultDisplay.getSize(point);
            jSONObject3.put("width", point.x);
            jSONObject3.put("height", point.y);
            jSONObject2.put("display", jSONObject3);
            jSONObject2.put("headerBiddingOptions", showOperationState.showOptions.getData());
            jSONObject.put("options", jSONObject2);
            jSONObject.put("listenerId", showOperation.getId());
            jSONObject.put("placementId", showOperationState.placementId);
            jSONObject.put("time", Device.getElapsedRealtime());
            set(showOperation);
            showOperation.invoke(showOperationState.configuration.getWebViewBridgeTimeout(), jSONObject);
            HdrInfoReader.getInstance().captureHDRCapabilityMetrics(activity, new ExperimentsReader());
        } catch (NullPointerException unused) {
            sendOnUnityAdsFailedToShow(showOperationState, "[UnityAds] Error creating show options", UnityAds.UnityAdsShowError.INTERNAL_ERROR, true);
        } catch (JSONException unused2) {
            sendOnUnityAdsFailedToShow(showOperationState, "[UnityAds] Error creating show options", UnityAds.UnityAdsShowError.INTERNAL_ERROR, true);
        }
    }

    @Override // com.unity3d.services.ads.operation.show.IShowModule
    public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
        IShowOperation iShowOperation = (IShowOperation) get(str);
        if (iShowOperation == null || iShowOperation.getShowOperationState() == null) {
            return;
        }
        ShowOperationState showOperationState = iShowOperation.getShowOperationState();
        getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdShowFailure(unityAdsShowError, Long.valueOf(showOperationState.duration())));
        iShowOperation.onUnityAdsShowFailure(showOperationState.placementId, unityAdsShowError, str2);
        remove(str);
    }

    @Override // com.unity3d.services.ads.operation.show.IShowModule
    public void onUnityAdsShowConsent(String str) {
        IShowOperation iShowOperation = (IShowOperation) get(str);
        if (iShowOperation != null) {
            iShowOperation.getShowOperationState();
        }
    }

    @Override // com.unity3d.services.ads.operation.show.IShowModule
    public void onUnityAdsShowStart(String str) {
        IShowOperation iShowOperation = (IShowOperation) get(str);
        if (iShowOperation == null || iShowOperation.getShowOperationState() == null) {
            return;
        }
        iShowOperation.onUnityAdsShowStart(iShowOperation.getShowOperationState().placementId);
    }

    @Override // com.unity3d.services.ads.operation.show.IShowModule
    public void onUnityAdsShowClick(String str) {
        IShowOperation iShowOperation = (IShowOperation) get(str);
        if (iShowOperation == null || iShowOperation.getShowOperationState() == null) {
            return;
        }
        iShowOperation.onUnityAdsShowClick(iShowOperation.getShowOperationState().placementId);
    }

    @Override // com.unity3d.services.ads.operation.show.IShowModule
    public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        IShowOperation iShowOperation = (IShowOperation) get(str);
        if (iShowOperation == null || iShowOperation.getShowOperationState() == null) {
            return;
        }
        ShowOperationState showOperationState = iShowOperation.getShowOperationState();
        getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdShowSuccess(Long.valueOf(showOperationState.duration())));
        iShowOperation.onUnityAdsShowComplete(showOperationState.placementId, unityAdsShowCompletionState);
        remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOnUnityAdsFailedToShow(final ShowOperationState showOperationState, final String str, final UnityAds.UnityAdsShowError unityAdsShowError, boolean z) {
        if (showOperationState == null || showOperationState.listener == null) {
            return;
        }
        if (z) {
            getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdShowFailure(unityAdsShowError, Long.valueOf(showOperationState.duration())));
        }
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.operation.show.ShowModule.2
            @Override // java.lang.Runnable
            public void run() {
                showOperationState.onUnityAdsShowFailure(unityAdsShowError, str);
            }
        });
    }
}

// ===== FILE: com/unity3d/services/ads/operation/show/ShowModuleDecorator.java =====
package com.unity3d.services.ads.operation.show;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;

/* loaded from: classes.dex */
public class ShowModuleDecorator implements IShowModule {
    private final IShowModule _showModule;

    public ShowModuleDecorator(IShowModule iShowModule) {
        this._showModule = iShowModule;
    }

    @Override // com.unity3d.services.ads.operation.IAdModule
    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, ShowOperationState showOperationState) {
        this._showModule.executeAdOperation(iWebViewBridgeInvoker, showOperationState);
    }

    @Override // com.unity3d.services.ads.operation.IAdModule
    public SDKMetricsSender getMetricSender() {
        return this._showModule.getMetricSender();
    }

    @Override // com.unity3d.services.ads.operation.show.IShowModule
    public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
        this._showModule.onUnityAdsShowFailure(str, unityAdsShowError, str2);
    }

    @Override // com.unity3d.services.ads.operation.show.IShowModule
    public void onUnityAdsShowConsent(String str) {
        this._showModule.onUnityAdsShowConsent(str);
    }

    @Override // com.unity3d.services.ads.operation.show.IShowModule
    public void onUnityAdsShowStart(String str) {
        this._showModule.onUnityAdsShowStart(str);
    }

    @Override // com.unity3d.services.ads.operation.show.IShowModule
    public void onUnityAdsShowClick(String str) {
        this._showModule.onUnityAdsShowClick(str);
    }

    @Override // com.unity3d.services.ads.operation.show.IShowModule
    public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        this._showModule.onUnityAdsShowComplete(str, unityAdsShowCompletionState);
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore
    public IShowOperation get(String str) {
        return (IShowOperation) this._showModule.get(str);
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore
    public void set(IShowOperation iShowOperation) {
        this._showModule.set(iShowOperation);
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore
    public void remove(String str) {
        this._showModule.remove(str);
    }
}

// ===== FILE: com/unity3d/services/ads/operation/show/ShowModuleDecoratorTimeout.java =====
package com.unity3d.services.ads.operation.show;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.configuration.ExperimentsReader;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.AdOperationError;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import com.unity3d.services.core.timer.BaseTimer;
import com.unity3d.services.core.timer.ITimerListener;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class ShowModuleDecoratorTimeout extends ShowModuleDecorator {
    private static final String errorMsgTimeout = "[UnityAds] Timeout while trying to show ";
    private final ExperimentsReader _experimentsReader;

    public ShowModuleDecoratorTimeout(IShowModule iShowModule, ExperimentsReader experimentsReader) {
        super(iShowModule);
        this._experimentsReader = experimentsReader;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.unity3d.services.ads.operation.show.ShowModuleDecorator, com.unity3d.services.ads.operation.IAdModule
    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, ShowOperationState showOperationState) {
        getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdShowStart());
        showOperationState.start();
        if (!this._experimentsReader.getCurrentlyActiveExperiments().isNativeShowTimeoutDisabled()) {
            startShowTimeout(showOperationState);
        }
        super.executeAdOperation(iWebViewBridgeInvoker, showOperationState);
    }

    private void startShowTimeout(final ShowOperationState showOperationState) {
        if (showOperationState == null) {
            return;
        }
        showOperationState.timeoutTimer = new BaseTimer(Integer.valueOf(showOperationState.configuration.getShowTimeout()), new ITimerListener() { // from class: com.unity3d.services.ads.operation.show.ShowModuleDecoratorTimeout.1
            @Override // com.unity3d.services.core.timer.ITimerListener
            public void onTimerFinished() {
                ShowModuleDecoratorTimeout.this.onOperationTimeout(showOperationState, UnityAds.UnityAdsShowError.TIMEOUT, "[UnityAds] Timeout while trying to show " + showOperationState.placementId);
            }
        });
        showOperationState.timeoutTimer.start(Executors.newSingleThreadScheduledExecutor());
    }

    @Override // com.unity3d.services.ads.operation.show.ShowModuleDecorator, com.unity3d.services.ads.operation.show.IShowModule
    public void onUnityAdsShowConsent(String str) {
        releaseOperationTimeoutLock(str);
        super.onUnityAdsShowConsent(str);
    }

    @Override // com.unity3d.services.ads.operation.show.ShowModuleDecorator, com.unity3d.services.ads.operation.show.IShowModule
    public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
        releaseOperationTimeoutLock(str);
        super.onUnityAdsShowFailure(str, unityAdsShowError, str2);
    }

    @Override // com.unity3d.services.ads.operation.show.ShowModuleDecorator, com.unity3d.services.ads.operation.show.IShowModule
    public void onUnityAdsShowStart(String str) {
        releaseOperationTimeoutLock(str);
        super.onUnityAdsShowStart(str);
    }

    private void releaseOperationTimeoutLock(String str) {
        ShowOperationState showOperationState;
        BaseTimer baseTimer;
        IShowOperation iShowOperation = get(str);
        if (iShowOperation == null || (showOperationState = iShowOperation.getShowOperationState()) == null || (baseTimer = showOperationState.timeoutTimer) == null) {
            return;
        }
        baseTimer.kill();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOperationTimeout(final ShowOperationState showOperationState, final UnityAds.UnityAdsShowError unityAdsShowError, final String str) {
        if (showOperationState != null) {
            getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdShowFailure(AdOperationError.timeout, Long.valueOf(showOperationState.duration())));
            remove(showOperationState.f691id);
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.operation.show.ShowModuleDecoratorTimeout$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ShowOperationState.this.onUnityAdsShowFailure(unityAdsShowError, str);
                }
            });
        }
    }
}

// ===== FILE: com/unity3d/services/ads/operation/show/ShowOperation.java =====
package com.unity3d.services.ads.operation.show;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.AdOperation;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocation;

/* loaded from: classes.dex */
public class ShowOperation extends AdOperation implements IShowOperation {
    private ShowOperationState showOperationState;

    public ShowOperation(ShowOperationState showOperationState, IWebViewBridgeInvocation iWebViewBridgeInvocation) {
        super(iWebViewBridgeInvocation, "show");
        this.showOperationState = showOperationState;
    }

    @Override // com.unity3d.services.ads.operation.show.IShowOperation
    public ShowOperationState getShowOperationState() {
        return this.showOperationState;
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowFailure(String str, final UnityAds.UnityAdsShowError unityAdsShowError, final String str2) {
        ShowOperationState showOperationState = this.showOperationState;
        if (showOperationState == null || showOperationState.listener == null) {
            return;
        }
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.operation.show.ShowOperation.1
            @Override // java.lang.Runnable
            public void run() {
                if (ShowOperation.this.showOperationState != null) {
                    ShowOperation.this.showOperationState.onUnityAdsShowFailure(unityAdsShowError, str2);
                }
            }
        });
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowStart(final String str) {
        if (this.showOperationState == null) {
            return;
        }
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.operation.show.ShowOperation.2
            @Override // java.lang.Runnable
            public void run() {
                if (ShowOperation.this.showOperationState != null) {
                    ShowOperation.this.showOperationState.onUnityAdsShowStart(str);
                }
            }
        });
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowClick(String str) {
        if (this.showOperationState == null) {
            return;
        }
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.operation.show.ShowOperation.3
            @Override // java.lang.Runnable
            public void run() {
                if (ShowOperation.this.showOperationState != null) {
                    ShowOperation.this.showOperationState.onUnityAdsShowClick();
                }
            }
        });
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowComplete(String str, final UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        if (this.showOperationState == null) {
            return;
        }
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.operation.show.ShowOperation.4
            @Override // java.lang.Runnable
            public void run() {
                if (ShowOperation.this.showOperationState != null) {
                    ShowOperation.this.showOperationState.onUnityAdsShowComplete(unityAdsShowCompletionState);
                }
            }
        });
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewSharedObject
    public String getId() {
        return this.showOperationState.f691id;
    }
}

// ===== FILE: com/unity3d/services/ads/operation/show/ShowOperationState.java =====
package com.unity3d.services.ads.operation.show;

import android.app.Activity;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.ads.operation.OperationState;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.misc.Utilities;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class ShowOperationState extends OperationState {
    public WeakReference<Activity> activity;
    public IUnityAdsShowListener listener;
    public UnityAdsShowOptions showOptions;

    public ShowOperationState(String str, IUnityAdsShowListener iUnityAdsShowListener, Activity activity, UnityAdsShowOptions unityAdsShowOptions, Configuration configuration) {
        super(str, configuration);
        this.listener = iUnityAdsShowListener;
        this.activity = new WeakReference<>(activity);
        this.showOptions = unityAdsShowOptions;
    }

    public void onUnityAdsShowFailure(final UnityAds.UnityAdsShowError unityAdsShowError, final String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.ShowOperationState$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    ShowOperationState.this.m439xb9c9007a(unityAdsShowError, str);
                }
            });
        }
    }

    /* renamed from: lambda$onUnityAdsShowFailure$0$com-unity3d-services-ads-operation-show-ShowOperationState */
    /* synthetic */ void m439xb9c9007a(UnityAds.UnityAdsShowError unityAdsShowError, String str) {
        this.listener.onUnityAdsShowFailure(this.placementId, unityAdsShowError, str);
    }

    public void onUnityAdsShowClick() {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.ShowOperationState$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ShowOperationState.this.m437x2e86f59b();
                }
            });
        }
    }

    /* renamed from: lambda$onUnityAdsShowClick$1$com-unity3d-services-ads-operation-show-ShowOperationState */
    /* synthetic */ void m437x2e86f59b() {
        this.listener.onUnityAdsShowClick(this.placementId);
    }

    public void onUnityAdsShowStart(final String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.ShowOperationState$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ShowOperationState.this.m440xce119060(str);
                }
            });
        }
    }

    /* renamed from: lambda$onUnityAdsShowStart$2$com-unity3d-services-ads-operation-show-ShowOperationState */
    /* synthetic */ void m440xce119060(String str) {
        this.listener.onUnityAdsShowStart(str);
    }

    public void onUnityAdsShowComplete(final UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.ShowOperationState$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ShowOperationState.this.m438x43b2ea60(unityAdsShowCompletionState);
                }
            });
        }
    }

    /* renamed from: lambda$onUnityAdsShowComplete$3$com-unity3d-services-ads-operation-show-ShowOperationState */
    /* synthetic */ void m438x43b2ea60(UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        this.listener.onUnityAdsShowComplete(this.placementId, unityAdsShowCompletionState);
    }
}
