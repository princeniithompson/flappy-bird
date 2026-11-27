// Package bundle: com.unity3d.services.core.webview.bridge.invocation (5 classes)

// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocation
// ============================================================
package com.unity3d.services.core.webview.bridge.invocation;

public abstract class IWebViewBridgeInvocation {
    public abstract void invoke(String p0, String p1, int p2, Object[] p3) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocationCallback
// ============================================================
package com.unity3d.services.core.webview.bridge.invocation;

public abstract class IWebViewBridgeInvocationCallback {
    public abstract void onFailure(String p0, CallbackStatus p1) {
        // native or abstract
    }

    public abstract void onSuccess() {
        // native or abstract
    }

    public abstract void onTimeout() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocation
// ============================================================
package com.unity3d.services.core.webview.bridge.invocation;

public class WebViewBridgeInvocation {
    private static IWebViewBridgeInvocationCallback invocationCallback;
    private ExecutorService _executorService;
    private IWebViewBridgeInvoker _webViewBridgeInvoker;

    public WebViewBridgeInvocation(ExecutorService p0, IWebViewBridgeInvoker p1, IWebViewBridgeInvocationCallback p2) {
        new Object();
        _executorService = p0;
        invocationCallback = p2;
        if (if-eqz(p1)) goto L_c;
        _webViewBridgeInvoker = p1;
        return;
      L_c:
        new IllegalArgumentException("webViewBridgeInvoker cannot be null");
        throw new IllegalArgumentException(..);
    }

    public void invoke(String p0, String p1, int p2, Object[] p3) {
        new WebViewBridgeInvocationRunnable(WebViewBridgeInvocation.invocationCallback, _webViewBridgeInvoker, p0, p1, p2, p3);
        _executorService.submit(new WebViewBridgeInvocationRunnable);
        return;
        throw p0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocationRunnable
// ============================================================
package com.unity3d.services.core.webview.bridge.invocation;

public class WebViewBridgeInvocationRunnable {
    private static CallbackStatus _callbackStatus;
    private static ConditionVariable _responseTimeout;
    private String _className;
    private IWebViewBridgeInvocationCallback _invocationCallback;
    private Object[] _invocationParameters;
    private String _methodName;
    private int _timeoutLengthInMilliSeconds;
    private Method _webViewBridgeCallbackMethod;
    private IWebViewBridgeInvoker _webViewBridgeInvoker;

    public WebViewBridgeInvocationRunnable(IWebViewBridgeInvocationCallback p0, IWebViewBridgeInvoker p1, String p2, String p3, int p4, Object[] p5) {
        new Object();
        Class.getMethod("onInvocationComplete", 1);
        _webViewBridgeCallbackMethod = Class.getMethod(..);
        _invocationCallback = p0;
        _webViewBridgeInvoker = p1;
        _className = p2;
        _methodName = p3;
        _timeoutLengthInMilliSeconds = p4;
        _invocationParameters = p5;
        return;
        new IllegalArgumentException("WebViewBridgeInvocation callback method cannot be found", p0);
        throw new IllegalArgumentException(..);
    }

    public static void onInvocationComplete(CallbackStatus p0) {
        _callbackStatus = p0;
        if (if-eqz(WebViewBridgeInvocationRunnable._responseTimeout)) goto L_c;
        ConditionVariable.open();
      L_c:
        return;
        throw WebViewBridgeInvocationRunnable._responseTimeout;
    }

    public void run() {
        _callbackStatus = 0;
        new ConditionVariable();
        _responseTimeout = new ConditionVariable(..);
        _webViewBridgeInvoker.invokeMethod(_className, _methodName, _webViewBridgeCallbackMethod, _invocationParameters);
        if (if-nez(_invocationCallback)) goto L_1d;
        return;
      L_1d:
        if (if-nez(IWebViewBridgeInvoker.invokeMethod(..))) goto L_25;
        _invocationCallback.onFailure("WebViewBridgeInvocationRunnable:run: invokeMethod failure", 0);
        return;
      L_25:
        ConditionVariable.block(_timeoutLengthInMilliSeconds, _invocationCallback);
        if (if-eqz(ConditionVariable.block(..))) goto L_46;
        if (if-ne(WebViewBridgeInvocationRunnable._callbackStatus, CallbackStatus.OK)) goto L_3c;
        _invocationCallback.onSuccess();
      L_3c:
        _invocationCallback.onFailure("WebViewBridgeInvocationRunnable:run CallbackStatus.Error", WebViewBridgeInvocationRunnable._callbackStatus);
      L_46:
        _invocationCallback.onTimeout();
      L_4b:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.invocation.WebViewBridgeInvocationSingleThreadedExecutor
// ============================================================
package com.unity3d.services.core.webview.bridge.invocation;

public class WebViewBridgeInvocationSingleThreadedExecutor {
    private static WebViewBridgeInvocationSingleThreadedExecutor instance;
    private ExecutorService _ExecutorService;

    private WebViewBridgeInvocationSingleThreadedExecutor() {
        new Object();
        Executors.newSingleThreadExecutor();
        _ExecutorService = Executors.newSingleThreadExecutor(..);
        return;
    }

    public static WebViewBridgeInvocationSingleThreadedExecutor getInstance() {
        if (if-nez(WebViewBridgeInvocationSingleThreadedExecutor.instance)) goto L_b;
        new WebViewBridgeInvocationSingleThreadedExecutor();
        instance = new WebViewBridgeInvocationSingleThreadedExecutor(..);
      L_b:
        return WebViewBridgeInvocationSingleThreadedExecutor.instance;
    }

    public ExecutorService getExecutorService() {
        return _ExecutorService;
    }

}

