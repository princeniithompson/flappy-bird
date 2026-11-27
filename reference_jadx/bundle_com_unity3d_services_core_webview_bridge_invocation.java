
// ===== FILE: com/unity3d/services/core/webview/bridge/invocation/IWebViewBridgeInvocation.java =====
package com.unity3d.services.core.webview.bridge.invocation;

/* loaded from: classes.dex */
public interface IWebViewBridgeInvocation {
    void invoke(String str, String str2, int i, Object... objArr);
}

// ===== FILE: com/unity3d/services/core/webview/bridge/invocation/IWebViewBridgeInvocationCallback.java =====
package com.unity3d.services.core.webview.bridge.invocation;

import com.unity3d.services.core.webview.bridge.CallbackStatus;

/* loaded from: classes.dex */
public interface IWebViewBridgeInvocationCallback {
    void onFailure(String str, CallbackStatus callbackStatus);

    void onSuccess();

    void onTimeout();
}

// ===== FILE: com/unity3d/services/core/webview/bridge/invocation/WebViewBridgeInvocation.java =====
package com.unity3d.services.core.webview.bridge.invocation;

import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class WebViewBridgeInvocation implements IWebViewBridgeInvocation {
    private static IWebViewBridgeInvocationCallback invocationCallback;
    private ExecutorService _executorService;
    private IWebViewBridgeInvoker _webViewBridgeInvoker;

    public WebViewBridgeInvocation(ExecutorService executorService, IWebViewBridgeInvoker iWebViewBridgeInvoker, IWebViewBridgeInvocationCallback iWebViewBridgeInvocationCallback) {
        this._executorService = executorService;
        invocationCallback = iWebViewBridgeInvocationCallback;
        if (iWebViewBridgeInvoker == null) {
            throw new IllegalArgumentException("webViewBridgeInvoker cannot be null");
        }
        this._webViewBridgeInvoker = iWebViewBridgeInvoker;
    }

    @Override // com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocation
    public synchronized void invoke(String str, String str2, int i, Object... objArr) {
        this._executorService.submit(new WebViewBridgeInvocationRunnable(invocationCallback, this._webViewBridgeInvoker, str, str2, i, objArr));
    }
}

// ===== FILE: com/unity3d/services/core/webview/bridge/invocation/WebViewBridgeInvocationRunnable.java =====
package com.unity3d.services.core.webview.bridge.invocation;

import android.os.ConditionVariable;
import com.unity3d.services.core.webview.bridge.CallbackStatus;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class WebViewBridgeInvocationRunnable implements Runnable {
    private static CallbackStatus _callbackStatus;
    private static ConditionVariable _responseTimeout;
    private String _className;
    private IWebViewBridgeInvocationCallback _invocationCallback;
    private Object[] _invocationParameters;
    private String _methodName;
    private int _timeoutLengthInMilliSeconds;
    private Method _webViewBridgeCallbackMethod;
    private IWebViewBridgeInvoker _webViewBridgeInvoker;

    public WebViewBridgeInvocationRunnable(IWebViewBridgeInvocationCallback iWebViewBridgeInvocationCallback, IWebViewBridgeInvoker iWebViewBridgeInvoker, String str, String str2, int i, Object... objArr) {
        try {
            this._webViewBridgeCallbackMethod = WebViewBridgeInvocationRunnable.class.getMethod("onInvocationComplete", CallbackStatus.class);
            this._invocationCallback = iWebViewBridgeInvocationCallback;
            this._webViewBridgeInvoker = iWebViewBridgeInvoker;
            this._className = str;
            this._methodName = str2;
            this._timeoutLengthInMilliSeconds = i;
            this._invocationParameters = objArr;
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("WebViewBridgeInvocation callback method cannot be found", e);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        _callbackStatus = null;
        _responseTimeout = new ConditionVariable();
        boolean invokeMethod = this._webViewBridgeInvoker.invokeMethod(this._className, this._methodName, this._webViewBridgeCallbackMethod, this._invocationParameters);
        IWebViewBridgeInvocationCallback iWebViewBridgeInvocationCallback = this._invocationCallback;
        if (iWebViewBridgeInvocationCallback == null) {
            return;
        }
        if (!invokeMethod) {
            iWebViewBridgeInvocationCallback.onFailure("WebViewBridgeInvocationRunnable:run: invokeMethod failure", null);
            return;
        }
        if (_responseTimeout.block(this._timeoutLengthInMilliSeconds)) {
            if (_callbackStatus == CallbackStatus.OK) {
                this._invocationCallback.onSuccess();
                return;
            } else {
                this._invocationCallback.onFailure("WebViewBridgeInvocationRunnable:run CallbackStatus.Error", _callbackStatus);
                return;
            }
        }
        this._invocationCallback.onTimeout();
    }

    public static synchronized void onInvocationComplete(CallbackStatus callbackStatus) {
        synchronized (WebViewBridgeInvocationRunnable.class) {
            _callbackStatus = callbackStatus;
            ConditionVariable conditionVariable = _responseTimeout;
            if (conditionVariable != null) {
                conditionVariable.open();
            }
        }
    }
}

// ===== FILE: com/unity3d/services/core/webview/bridge/invocation/WebViewBridgeInvocationSingleThreadedExecutor.java =====
package com.unity3d.services.core.webview.bridge.invocation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class WebViewBridgeInvocationSingleThreadedExecutor {
    private static WebViewBridgeInvocationSingleThreadedExecutor instance;
    private ExecutorService _ExecutorService = Executors.newSingleThreadExecutor();

    public static WebViewBridgeInvocationSingleThreadedExecutor getInstance() {
        if (instance == null) {
            instance = new WebViewBridgeInvocationSingleThreadedExecutor();
        }
        return instance;
    }

    private WebViewBridgeInvocationSingleThreadedExecutor() {
    }

    public ExecutorService getExecutorService() {
        return this._ExecutorService;
    }
}
