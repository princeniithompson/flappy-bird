
// ===== FILE: com/unity3d/services/ads/operation/load/BaseLoadModule.java =====
package com.unity3d.services.ads.operation.load;

import android.text.TextUtils;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.AdModule;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.misc.Utilities;
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
public abstract class BaseLoadModule extends AdModule<ILoadOperation, LoadOperationState> implements ILoadModule {
    static final String errorMsgFailedToCreateLoadRequest = "[UnityAds] Failed to create load request";
    static final String errorMsgInternalCommunicationFailure = "[UnityAds] Internal communication failure";
    static final String errorMsgInternalCommunicationTimeout = "[UnityAds] Internal communication timeout";
    static final String errorMsgPlacementIdNull = "[UnityAds] Placement ID cannot be null";

    abstract void addOptionalParameters(LoadOperationState loadOperationState, JSONObject jSONObject) throws JSONException;

    public BaseLoadModule(SDKMetricsSender sDKMetricsSender) {
        super(sDKMetricsSender);
    }

    @Override // com.unity3d.services.ads.operation.IAdModule
    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, final LoadOperationState loadOperationState) {
        if (TextUtils.isEmpty(loadOperationState.placementId)) {
            sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INVALID_ARGUMENT, "[UnityAds] Placement ID cannot be null", true);
            return;
        }
        LoadOperation loadOperation = new LoadOperation(loadOperationState, new WebViewBridgeInvocation(this._executorService, iWebViewBridgeInvoker, new IWebViewBridgeInvocationCallback() { // from class: com.unity3d.services.ads.operation.load.BaseLoadModule.1
            @Override // com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback
            public void onSuccess() {
            }

            @Override // com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback
            public void onFailure(String str, CallbackStatus callbackStatus) {
                BaseLoadModule.this.getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(AdOperationError.callback_error, Long.valueOf(loadOperationState.duration()), loadOperationState.isBanner(), loadOperationState.isHeaderBidding()));
                BaseLoadModule.this.sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INTERNAL_ERROR, "[UnityAds] Internal communication failure", false);
                BaseLoadModule.this.remove(loadOperationState.getId());
            }

            @Override // com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback
            public void onTimeout() {
                BaseLoadModule.this.getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(AdOperationError.callback_timeout, Long.valueOf(loadOperationState.duration()), loadOperationState.isBanner(), loadOperationState.isHeaderBidding()));
                BaseLoadModule.this.sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INTERNAL_ERROR, "[UnityAds] Internal communication timeout", false);
                BaseLoadModule.this.remove(loadOperationState.getId());
            }
        }));
        try {
            JSONObject buildBaseParameters = buildBaseParameters(loadOperationState, loadOperation);
            set(loadOperation);
            loadOperation.invoke(loadOperationState.configuration.getWebViewBridgeTimeout(), buildBaseParameters);
        } catch (NullPointerException | JSONException unused) {
            sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INTERNAL_ERROR, "[UnityAds] Failed to create load request", true);
        }
    }

    JSONObject buildBaseParameters(LoadOperationState loadOperationState, LoadOperation loadOperation) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject buildBaseOptions = buildBaseOptions(loadOperationState);
        buildBaseOptions.put("headerBiddingOptions", loadOperationState.loadOptions.getData());
        jSONObject.put("options", buildBaseOptions);
        jSONObject.put("listenerId", loadOperation.getId());
        jSONObject.put("placementId", loadOperationState.placementId);
        jSONObject.put("time", Device.getElapsedRealtime());
        addOptionalParameters(loadOperationState, jSONObject);
        return jSONObject;
    }

    JSONObject buildBaseOptions(LoadOperationState loadOperationState) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("headerBiddingOptions", loadOperationState.loadOptions.getData());
        return jSONObject;
    }

    @Override // com.unity3d.services.ads.operation.load.ILoadModule
    public void onUnityAdsAdLoaded(String str) {
        ILoadOperation iLoadOperation = (ILoadOperation) get(str);
        if (iLoadOperation == null || iLoadOperation.getLoadOperationState() == null) {
            return;
        }
        LoadOperationState loadOperationState = iLoadOperation.getLoadOperationState();
        getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadSuccess(Long.valueOf(loadOperationState.duration()), loadOperationState.isBanner(), loadOperationState.isHeaderBidding()));
        iLoadOperation.onUnityAdsAdLoaded(loadOperationState.placementId);
        remove(str);
    }

    @Override // com.unity3d.services.ads.operation.load.ILoadModule
    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        ILoadOperation iLoadOperation = (ILoadOperation) get(str);
        if (iLoadOperation == null || iLoadOperation.getLoadOperationState() == null) {
            return;
        }
        LoadOperationState loadOperationState = iLoadOperation.getLoadOperationState();
        getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(unityAdsLoadError, Long.valueOf(loadOperationState.duration()), loadOperationState.isBanner(), loadOperationState.isHeaderBidding()));
        iLoadOperation.onUnityAdsFailedToLoad(loadOperationState.placementId, unityAdsLoadError, str2);
        remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOnUnityAdsFailedToLoad(final LoadOperationState loadOperationState, final UnityAds.UnityAdsLoadError unityAdsLoadError, final String str, boolean z) {
        if (loadOperationState == null || loadOperationState.listener == null) {
            return;
        }
        if (z) {
            getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(unityAdsLoadError, Long.valueOf(loadOperationState.duration()), loadOperationState.isBanner(), loadOperationState.isHeaderBidding()));
        }
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.operation.load.BaseLoadModule.2
            @Override // java.lang.Runnable
            public void run() {
                loadOperationState.onUnityAdsFailedToLoad(unityAdsLoadError, str);
            }
        });
    }
}

// ===== FILE: com/unity3d/services/ads/operation/load/ILoadModule.java =====
package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.IAdModule;

/* loaded from: classes.dex */
public interface ILoadModule extends IAdModule<ILoadOperation, LoadOperationState> {
    void onUnityAdsAdLoaded(String str);

    void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2);
}

// ===== FILE: com/unity3d/services/ads/operation/load/ILoadOperation.java =====
package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.services.ads.operation.IAdOperation;

/* loaded from: classes.dex */
public interface ILoadOperation extends IAdOperation, IUnityAdsLoadListener {
    LoadOperationState getLoadOperationState();
}

// ===== FILE: com/unity3d/services/ads/operation/load/LoadBannerModule.java =====
package com.unity3d.services.ads.operation.load;

import com.unity3d.services.core.configuration.ExperimentsReader;
import com.unity3d.services.core.configuration.InitializationNotificationCenter;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LoadBannerModule extends BaseLoadModule {
    static ILoadModule _instance;

    public static ILoadModule getInstance() {
        if (_instance == null) {
            _instance = new LoadModuleDecoratorTimeout(new LoadModuleDecoratorInitializationBuffer(new LoadBannerModule((SDKMetricsSender) Utilities.getService(SDKMetricsSender.class)), InitializationNotificationCenter.getInstance()), new ExperimentsReader());
        }
        return _instance;
    }

    public LoadBannerModule(SDKMetricsSender sDKMetricsSender) {
        super(sDKMetricsSender);
    }

    @Override // com.unity3d.services.ads.operation.load.BaseLoadModule
    protected void addOptionalParameters(LoadOperationState loadOperationState, JSONObject jSONObject) throws JSONException {
        if (loadOperationState instanceof LoadBannerOperationState) {
            LoadBannerOperationState loadBannerOperationState = (LoadBannerOperationState) loadOperationState;
            jSONObject.put("width", loadBannerOperationState.getSize().getWidth());
            jSONObject.put("height", loadBannerOperationState.getSize().getHeight());
        }
    }
}

// ===== FILE: com/unity3d/services/ads/operation/load/LoadBannerOperationState.java =====
package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.core.configuration.Configuration;

/* loaded from: classes.dex */
public class LoadBannerOperationState extends LoadOperationState {
    private ScarAdMetadata _scarAdMetadata;
    private UnityBannerSize _size;

    public LoadBannerOperationState(String str, String str2, UnityBannerSize unityBannerSize, IUnityAdsLoadListener iUnityAdsLoadListener, UnityAdsLoadOptions unityAdsLoadOptions, Configuration configuration) {
        super(str, iUnityAdsLoadListener, unityAdsLoadOptions, configuration);
        this.f691id = str2;
        this._size = unityBannerSize;
    }

    public UnityBannerSize getSize() {
        return this._size;
    }

    public void setSize(UnityBannerSize unityBannerSize) {
        this._size = unityBannerSize;
    }

    public void setScarAdMetadata(ScarAdMetadata scarAdMetadata) {
        this._scarAdMetadata = scarAdMetadata;
    }

    public ScarAdMetadata getScarAdMetadata() {
        return this._scarAdMetadata;
    }

    public boolean isScarAd() {
        return this._scarAdMetadata != null;
    }
}

// ===== FILE: com/unity3d/services/ads/operation/load/LoadModule.java =====
package com.unity3d.services.ads.operation.load;

import com.unity3d.services.core.configuration.ExperimentsReader;
import com.unity3d.services.core.configuration.InitializationNotificationCenter;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class LoadModule extends BaseLoadModule {
    static ILoadModule _instance;

    @Override // com.unity3d.services.ads.operation.load.BaseLoadModule
    void addOptionalParameters(LoadOperationState loadOperationState, JSONObject jSONObject) {
    }

    public static ILoadModule getInstance() {
        if (_instance == null) {
            _instance = new LoadModuleDecoratorTimeout(new LoadModuleDecoratorInitializationBuffer(new LoadModule((SDKMetricsSender) Utilities.getService(SDKMetricsSender.class)), InitializationNotificationCenter.getInstance()), new ExperimentsReader());
        }
        return _instance;
    }

    public LoadModule(SDKMetricsSender sDKMetricsSender) {
        super(sDKMetricsSender);
    }
}

// ===== FILE: com/unity3d/services/ads/operation/load/LoadModuleDecorator.java =====
package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;

/* loaded from: classes.dex */
public class LoadModuleDecorator implements ILoadModule {
    private final ILoadModule _loadModule;

    public LoadModuleDecorator(ILoadModule iLoadModule) {
        this._loadModule = iLoadModule;
    }

    @Override // com.unity3d.services.ads.operation.IAdModule
    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, LoadOperationState loadOperationState) {
        this._loadModule.executeAdOperation(iWebViewBridgeInvoker, loadOperationState);
    }

    @Override // com.unity3d.services.ads.operation.IAdModule
    public SDKMetricsSender getMetricSender() {
        return this._loadModule.getMetricSender();
    }

    @Override // com.unity3d.services.ads.operation.load.ILoadModule
    public void onUnityAdsAdLoaded(String str) {
        this._loadModule.onUnityAdsAdLoaded(str);
    }

    @Override // com.unity3d.services.ads.operation.load.ILoadModule
    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        this._loadModule.onUnityAdsFailedToLoad(str, unityAdsLoadError, str2);
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore
    public ILoadOperation get(String str) {
        return (ILoadOperation) this._loadModule.get(str);
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore
    public void set(ILoadOperation iLoadOperation) {
        this._loadModule.set(iLoadOperation);
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore
    public void remove(String str) {
        this._loadModule.remove(str);
    }
}

// ===== FILE: com/unity3d/services/ads/operation/load/LoadModuleDecoratorInitializationBuffer.java =====
package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.IInitializationListener;
import com.unity3d.services.core.configuration.IInitializationNotificationCenter;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class LoadModuleDecoratorInitializationBuffer extends LoadModuleDecorator implements IInitializationListener {
    private static final String errorMsgInitializationFailed = "[UnityAds] SDK Initialization Failed";
    private static final String errorMsgInitializationFailure = "[UnityAds] SDK Initialization Failure";
    private ConcurrentHashMap<LoadOperationState, IWebViewBridgeInvoker> _queuedLoadEvents;

    public LoadModuleDecoratorInitializationBuffer(ILoadModule iLoadModule, IInitializationNotificationCenter iInitializationNotificationCenter) {
        super(iLoadModule);
        iInitializationNotificationCenter.addListener(this);
        this._queuedLoadEvents = new ConcurrentHashMap<>();
    }

    /* renamed from: com.unity3d.services.ads.operation.load.LoadModuleDecoratorInitializationBuffer$2 */
    static /* synthetic */ class C10732 {

        /* renamed from: $SwitchMap$com$unity3d$services$core$properties$SdkProperties$InitializationState */
        static final /* synthetic */ int[] f692xe3e1bbe9;

        static {
            int[] iArr = new int[SdkProperties.InitializationState.values().length];
            f692xe3e1bbe9 = iArr;
            try {
                iArr[SdkProperties.InitializationState.INITIALIZED_SUCCESSFULLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f692xe3e1bbe9[SdkProperties.InitializationState.INITIALIZED_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.unity3d.services.ads.operation.load.LoadModuleDecorator, com.unity3d.services.ads.operation.IAdModule
    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, LoadOperationState loadOperationState) {
        if (loadOperationState == null) {
            return;
        }
        int i = C10732.f692xe3e1bbe9[SdkProperties.getCurrentInitializationState().ordinal()];
        if (i == 1) {
            super.executeAdOperation(iWebViewBridgeInvoker, loadOperationState);
        } else if (i == 2) {
            sendOnUnityAdsFailedToLoad(loadOperationState, UnityAds.UnityAdsLoadError.INITIALIZE_FAILED, "[UnityAds] SDK Initialization Failed");
        } else {
            this._queuedLoadEvents.put(loadOperationState, iWebViewBridgeInvoker);
        }
    }

    @Override // com.unity3d.services.core.configuration.IInitializationListener
    public synchronized void onSdkInitialized() {
        for (Map.Entry<LoadOperationState, IWebViewBridgeInvoker> entry : this._queuedLoadEvents.entrySet()) {
            super.executeAdOperation(entry.getValue(), entry.getKey());
        }
        this._queuedLoadEvents.clear();
    }

    @Override // com.unity3d.services.core.configuration.IInitializationListener
    public synchronized void onSdkInitializationFailed(String str, ErrorState errorState, int i) {
        Iterator<LoadOperationState> it = this._queuedLoadEvents.keySet().iterator();
        while (it.hasNext()) {
            sendOnUnityAdsFailedToLoad(it.next(), UnityAds.UnityAdsLoadError.INITIALIZE_FAILED, "[UnityAds] SDK Initialization Failure");
        }
        this._queuedLoadEvents.clear();
    }

    private void sendOnUnityAdsFailedToLoad(final LoadOperationState loadOperationState, final UnityAds.UnityAdsLoadError unityAdsLoadError, final String str) {
        if (loadOperationState == null || loadOperationState.listener == null) {
            return;
        }
        getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(unityAdsLoadError, Long.valueOf(loadOperationState.duration()), loadOperationState.isBanner(), loadOperationState.isHeaderBidding()));
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.operation.load.LoadModuleDecoratorInitializationBuffer.1
            @Override // java.lang.Runnable
            public void run() {
                loadOperationState.listener.onUnityAdsFailedToLoad(loadOperationState.placementId, unityAdsLoadError, str);
            }
        });
    }
}

// ===== FILE: com/unity3d/services/ads/operation/load/LoadModuleDecoratorTimeout.java =====
package com.unity3d.services.ads.operation.load;

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
public class LoadModuleDecoratorTimeout extends LoadModuleDecorator {
    private static final String errorMsgTimeoutLoading = "[UnityAds] Timeout while loading ";
    private final ExperimentsReader _experimentsReader;

    public LoadModuleDecoratorTimeout(ILoadModule iLoadModule, ExperimentsReader experimentsReader) {
        super(iLoadModule);
        this._experimentsReader = experimentsReader;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.unity3d.services.ads.operation.load.LoadModuleDecorator, com.unity3d.services.ads.operation.IAdModule
    public void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, LoadOperationState loadOperationState) {
        getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadStart(loadOperationState.isBanner(), loadOperationState.isHeaderBidding()));
        loadOperationState.start();
        if (!this._experimentsReader.getCurrentlyActiveExperiments().isNativeLoadTimeoutDisabled()) {
            startLoadTimeout(loadOperationState);
        }
        super.executeAdOperation(iWebViewBridgeInvoker, loadOperationState);
    }

    private void startLoadTimeout(final LoadOperationState loadOperationState) {
        if (loadOperationState == null) {
            return;
        }
        loadOperationState.timeoutTimer = new BaseTimer(Integer.valueOf(loadOperationState.configuration.getLoadTimeout()), new ITimerListener() { // from class: com.unity3d.services.ads.operation.load.LoadModuleDecoratorTimeout.1
            @Override // com.unity3d.services.core.timer.ITimerListener
            public void onTimerFinished() {
                LoadModuleDecoratorTimeout.this.onOperationTimeout(loadOperationState);
            }
        });
        loadOperationState.timeoutTimer.start(Executors.newSingleThreadScheduledExecutor());
    }

    @Override // com.unity3d.services.ads.operation.load.LoadModuleDecorator, com.unity3d.services.ads.operation.load.ILoadModule
    public void onUnityAdsAdLoaded(String str) {
        releaseOperationTimeoutLock(str);
        super.onUnityAdsAdLoaded(str);
    }

    @Override // com.unity3d.services.ads.operation.load.LoadModuleDecorator, com.unity3d.services.ads.operation.load.ILoadModule
    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        releaseOperationTimeoutLock(str);
        super.onUnityAdsFailedToLoad(str, unityAdsLoadError, str2);
    }

    private void releaseOperationTimeoutLock(String str) {
        LoadOperationState loadOperationState;
        BaseTimer baseTimer;
        ILoadOperation iLoadOperation = get(str);
        if (iLoadOperation == null || (loadOperationState = iLoadOperation.getLoadOperationState()) == null || (baseTimer = loadOperationState.timeoutTimer) == null) {
            return;
        }
        baseTimer.kill();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOperationTimeout(final LoadOperationState loadOperationState) {
        if (loadOperationState != null) {
            getMetricSender().sendMetricWithInitState(AdOperationMetric.newAdLoadFailure(AdOperationError.timeout, Long.valueOf(loadOperationState.duration()), loadOperationState.isBanner(), loadOperationState.isHeaderBidding()));
            remove(loadOperationState.f691id);
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.operation.load.LoadModuleDecoratorTimeout$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    r0.onUnityAdsFailedToLoad(UnityAds.UnityAdsLoadError.TIMEOUT, "[UnityAds] Timeout while loading " + LoadOperationState.this.placementId);
                }
            });
        }
    }
}

// ===== FILE: com/unity3d/services/ads/operation/load/LoadOperation.java =====
package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.AdOperation;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocation;

/* loaded from: classes.dex */
public class LoadOperation extends AdOperation implements ILoadOperation {
    private LoadOperationState _loadOperationState;

    public LoadOperation(LoadOperationState loadOperationState, IWebViewBridgeInvocation iWebViewBridgeInvocation) {
        super(iWebViewBridgeInvocation, "load");
        this._loadOperationState = loadOperationState;
    }

    @Override // com.unity3d.services.ads.operation.load.ILoadOperation
    public LoadOperationState getLoadOperationState() {
        return this._loadOperationState;
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsAdLoaded(String str) {
        LoadOperationState loadOperationState = this._loadOperationState;
        if (loadOperationState == null || loadOperationState.listener == null || str == null) {
            return;
        }
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.operation.load.LoadOperation.1
            @Override // java.lang.Runnable
            public void run() {
                if (LoadOperation.this._loadOperationState != null) {
                    LoadOperation.this._loadOperationState.onUnityAdsAdLoaded();
                }
            }
        });
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsFailedToLoad(String str, final UnityAds.UnityAdsLoadError unityAdsLoadError, final String str2) {
        LoadOperationState loadOperationState = this._loadOperationState;
        if (loadOperationState == null || loadOperationState.listener == null || str == null) {
            return;
        }
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.operation.load.LoadOperation.2
            @Override // java.lang.Runnable
            public void run() {
                if (LoadOperation.this._loadOperationState != null) {
                    LoadOperation.this._loadOperationState.onUnityAdsFailedToLoad(unityAdsLoadError, str2);
                }
            }
        });
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewSharedObject
    public String getId() {
        return this._loadOperationState.f691id;
    }
}

// ===== FILE: com/unity3d/services/ads/operation/load/LoadOperationState.java =====
package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.domain.LegacyLoadUseCase;
import com.unity3d.services.ads.operation.OperationState;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.misc.Utilities;

/* loaded from: classes.dex */
public class LoadOperationState extends OperationState {
    public IUnityAdsLoadListener listener;
    public UnityAdsLoadOptions loadOptions;

    public LoadOperationState(String str, IUnityAdsLoadListener iUnityAdsLoadListener, UnityAdsLoadOptions unityAdsLoadOptions, Configuration configuration) {
        super(str, configuration);
        this.listener = iUnityAdsLoadListener;
        this.loadOptions = unityAdsLoadOptions;
    }

    public void onUnityAdsFailedToLoad(final UnityAds.UnityAdsLoadError unityAdsLoadError, final String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.load.LoadOperationState$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    LoadOperationState.this.m436x5da5719b(unityAdsLoadError, str);
                }
            });
        }
    }

    /* renamed from: lambda$onUnityAdsFailedToLoad$0$com-unity3d-services-ads-operation-load-LoadOperationState */
    /* synthetic */ void m436x5da5719b(UnityAds.UnityAdsLoadError unityAdsLoadError, String str) {
        this.listener.onUnityAdsFailedToLoad(this.placementId, unityAdsLoadError, str);
    }

    public void onUnityAdsAdLoaded() {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.load.LoadOperationState$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LoadOperationState.this.m435xadf8d050();
                }
            });
        }
    }

    /* renamed from: lambda$onUnityAdsAdLoaded$1$com-unity3d-services-ads-operation-load-LoadOperationState */
    /* synthetic */ void m435xadf8d050() {
        this.listener.onUnityAdsAdLoaded(this.placementId);
    }

    public boolean isBanner() {
        return this instanceof LoadBannerOperationState;
    }

    public boolean isHeaderBidding() {
        UnityAdsLoadOptions unityAdsLoadOptions = this.loadOptions;
        if (unityAdsLoadOptions == null || unityAdsLoadOptions.getData() == null) {
            return false;
        }
        return this.loadOptions.getData().has(LegacyLoadUseCase.KEY_AD_MARKUP);
    }
}
