
// ===== FILE: com/unity3d/services/ads/operation/AdModule.java =====
package com.unity3d.services.ads.operation;

import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;
import com.unity3d.services.core.webview.bridge.WebViewBridgeSharedObjectStore;
import com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocationSingleThreadedExecutor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public abstract class AdModule<T extends IWebViewSharedObject, T2> extends WebViewBridgeSharedObjectStore<T> implements IAdModule<T, T2> {
    protected ExecutorService _executorService = WebViewBridgeInvocationSingleThreadedExecutor.getInstance().getExecutorService();
    protected SDKMetricsSender _sdkMetrics;

    protected AdModule(SDKMetricsSender sDKMetricsSender) {
        this._sdkMetrics = sDKMetricsSender;
    }

    @Override // com.unity3d.services.ads.operation.IAdModule
    public SDKMetricsSender getMetricSender() {
        return this._sdkMetrics;
    }
}

// ===== FILE: com/unity3d/services/ads/operation/AdOperation.java =====
package com.unity3d.services.ads.operation;

import com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocation;

/* loaded from: classes.dex */
public abstract class AdOperation implements IAdOperation {
    private static String invocationClassName = "webview";
    private String _invocationMethodName;
    private IWebViewBridgeInvocation _webViewBridgeInvocation;

    protected AdOperation(IWebViewBridgeInvocation iWebViewBridgeInvocation, String str) throws NullPointerException {
        this._invocationMethodName = str;
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("invocationMethodName cannot be null");
        }
        this._webViewBridgeInvocation = iWebViewBridgeInvocation;
        if (iWebViewBridgeInvocation == null) {
            throw new IllegalArgumentException("webViewBridgeInvocation cannot be null");
        }
    }

    @Override // com.unity3d.services.ads.operation.IAdOperation
    public void invoke(int i, Object... objArr) {
        this._webViewBridgeInvocation.invoke(invocationClassName, this._invocationMethodName, i, objArr);
    }
}

// ===== FILE: com/unity3d/services/ads/operation/IAdModule.java =====
package com.unity3d.services.ads.operation;

import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore;
import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;

/* loaded from: classes.dex */
public interface IAdModule<T extends IWebViewSharedObject, T2> extends IWebViewBridgeSharedObjectStore<T> {
    void executeAdOperation(IWebViewBridgeInvoker iWebViewBridgeInvoker, T2 t2);

    SDKMetricsSender getMetricSender();
}

// ===== FILE: com/unity3d/services/ads/operation/IAdOperation.java =====
package com.unity3d.services.ads.operation;

import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;

/* loaded from: classes.dex */
public interface IAdOperation extends IWebViewSharedObject {
    void invoke(int i, Object... objArr);
}

// ===== FILE: com/unity3d/services/ads/operation/OperationState.java =====
package com.unity3d.services.ads.operation;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.timer.BaseTimer;
import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class OperationState implements IWebViewSharedObject {
    private static String _emptyPlacementId = "";
    public Configuration configuration;

    /* renamed from: id */
    public String f691id;
    public String placementId;
    public long startTime;
    public BaseTimer timeoutTimer;

    public OperationState(String str, Configuration configuration) {
        this.placementId = str == null ? _emptyPlacementId : str;
        this.configuration = configuration;
        this.f691id = UUID.randomUUID().toString();
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewSharedObject
    public String getId() {
        return this.f691id;
    }

    public void start() {
        this.startTime = System.nanoTime();
    }

    public long duration() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startTime);
    }
}
