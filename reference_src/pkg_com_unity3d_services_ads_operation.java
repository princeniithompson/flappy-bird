// Package bundle: com.unity3d.services.ads.operation (5 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.operation.AdModule
// ============================================================
package com.unity3d.services.ads.operation;

public abstract class AdModule extends WebViewBridgeSharedObjectStore {
    protected ExecutorService _executorService;
    protected SDKMetricsSender _sdkMetrics;

    protected AdModule(SDKMetricsSender p0) {
        new WebViewBridgeSharedObjectStore();
        _sdkMetrics = p0;
        WebViewBridgeInvocationSingleThreadedExecutor.getInstance();
        WebViewBridgeInvocationSingleThreadedExecutor.getExecutorService();
        _executorService = WebViewBridgeInvocationSingleThreadedExecutor.getExecutorService(..);
        return;
    }

    public SDKMetricsSender getMetricSender() {
        return _sdkMetrics;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.AdOperation
// ============================================================
package com.unity3d.services.ads.operation;

public abstract class AdOperation {
    private static String invocationClassName = "webview";
    private String _invocationMethodName;
    private IWebViewBridgeInvocation _webViewBridgeInvocation;

    static <clinit>() {
        return;
    }

    protected AdOperation(IWebViewBridgeInvocation p0, String p1) {
        new Object();
        _invocationMethodName = p1;
        if (if-eqz(p1)) goto L_1a;
        p1.isEmpty();
        if (if-nez(String.isEmpty(..))) goto L_1a;
        _webViewBridgeInvocation = p0;
        if (if-eqz(p0)) goto L_12;
        return;
      L_12:
        new IllegalArgumentException("webViewBridgeInvocation cannot be null");
        throw new IllegalArgumentException(..);
      L_1a:
        new IllegalArgumentException("invocationMethodName cannot be null");
        throw new IllegalArgumentException(..);
    }

    public void invoke(int p0, Object[] p1) {
        _webViewBridgeInvocation.invoke(AdOperation.invocationClassName, _invocationMethodName, p0, p1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.IAdModule
// ============================================================
package com.unity3d.services.ads.operation;

public abstract class IAdModule {
    public abstract void executeAdOperation(IWebViewBridgeInvoker p0, Object p1) {
        // native or abstract
    }

    public abstract SDKMetricsSender getMetricSender() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.IAdOperation
// ============================================================
package com.unity3d.services.ads.operation;

public abstract class IAdOperation {
    public abstract void invoke(int p0, Object[] p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.operation.OperationState
// ============================================================
package com.unity3d.services.ads.operation;

public class OperationState {
    private static String _emptyPlacementId = "";
    public Configuration configuration;
    public String id;
    public String placementId;
    public long startTime;
    public BaseTimer timeoutTimer;

    static <clinit>() {
        return;
    }

    public OperationState(String p0, Configuration p1) {
        new Object();
        if (if-nez(p0)) goto L_7;
      L_7:
        placementId = OperationState._emptyPlacementId;
        configuration = p1;
        UUID.randomUUID();
        UUID.randomUUID(..).toString();
        id = UUID.toString(..);
        return;
    }

    public long duration() {
        System.nanoTime();
        TimeUnit.NANOSECONDS.toMillis(System.nanoTime(..), v2);
        return TimeUnit.toMillis(..);
    }

    public String getId() {
        return id;
    }

    public void start() {
        System.nanoTime();
        startTime = System.nanoTime(..);
        return;
    }

}

