
// ===== FILE: com/unity3d/services/core/webview/WebView.java =====
package com.unity3d.services.core.webview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.ProxyConfig;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.unity3d.services.core.configuration.Experiments;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.p005di.IServiceComponent;
import com.unity3d.services.core.p005di.IServiceProvider;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.IInvocationCallbackInvoker;
import com.unity3d.services.core.webview.bridge.IWebViewBridge;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import com.unity3d.services.core.webview.bridge.WebViewBridgeInterface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: WebView.kt */
@Metadata(m443d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B7\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0019H\u0016R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m444d2 = {"Lcom/unity3d/services/core/webview/WebView;", "Landroid/webkit/WebView;", "Lcom/unity3d/services/core/di/IServiceComponent;", "context", "Landroid/content/Context;", "shouldNotRequireGesturePlayback", "", "webViewBridge", "Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;", "callbackInvoker", "Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;", "experiments", "Lcom/unity3d/services/core/configuration/IExperiments;", "(Landroid/content/Context;ZLcom/unity3d/services/core/webview/bridge/IWebViewBridge;Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;Lcom/unity3d/services/core/configuration/IExperiments;)V", "sdkMetricsSender", "Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "getSdkMetricsSender", "()Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "sdkMetricsSender$delegate", "Lkotlin/Lazy;", "webViewBridgeInterface", "Lcom/unity3d/services/core/webview/bridge/WebViewBridgeInterface;", "evaluateJavascript", "", "script", "", "resultCallback", "Landroid/webkit/ValueCallback;", "loadUrl", "url", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public class WebView extends android.webkit.WebView implements IServiceComponent {

    /* renamed from: sdkMetricsSender$delegate, reason: from kotlin metadata */
    private final Lazy sdkMetricsSender;
    private final WebViewBridgeInterface webViewBridgeInterface;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context) {
        this(context, false, null, null, null, 30, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z) {
        this(context, z, null, null, null, 28, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z, IWebViewBridge webViewBridge) {
        this(context, z, webViewBridge, null, null, 24, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webViewBridge, "webViewBridge");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z, IWebViewBridge webViewBridge, IInvocationCallbackInvoker callbackInvoker) {
        this(context, z, webViewBridge, callbackInvoker, null, 16, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webViewBridge, "webViewBridge");
        Intrinsics.checkNotNullParameter(callbackInvoker, "callbackInvoker");
    }

    @Override // com.unity3d.services.core.p005di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    public /* synthetic */ WebView(Context context, boolean z, IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, Experiments experiments, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? false : z, (i & 4) != 0 ? SharedInstances.INSTANCE.getWebViewBridge() : iWebViewBridge, (i & 8) != 0 ? SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker() : iInvocationCallbackInvoker, (i & 16) != 0 ? new Experiments() : experiments);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebView(Context context, boolean z, IWebViewBridge webViewBridge, IInvocationCallbackInvoker callbackInvoker, IExperiments experiments) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webViewBridge, "webViewBridge");
        Intrinsics.checkNotNullParameter(callbackInvoker, "callbackInvoker");
        Intrinsics.checkNotNullParameter(experiments, "experiments");
        final WebView webView = this;
        final String str = "";
        this.sdkMetricsSender = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SDKMetricsSender>() { // from class: com.unity3d.services.core.webview.WebView$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.services.core.request.metrics.SDKMetricsSender, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SDKMetricsSender invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(SDKMetricsSender.class));
            }
        });
        final WebViewBridgeInterface webViewBridgeInterface = new WebViewBridgeInterface(webViewBridge, callbackInvoker);
        this.webViewBridgeInterface = webViewBridgeInterface;
        WebSettings settings = getSettings();
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowFileAccess(true);
        settings.setBlockNetworkImage(false);
        settings.setBlockNetworkLoads(false);
        settings.setBuiltInZoomControls(false);
        settings.setCacheMode(2);
        settings.setDatabaseEnabled(false);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(false);
        settings.setEnableSmoothTransition(false);
        settings.setGeolocationEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setJavaScriptEnabled(true);
        settings.setLightTouchEnabled(false);
        settings.setLoadWithOverviewMode(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(1);
        settings.setNeedInitialFocus(true);
        settings.setPluginState(WebSettings.PluginState.OFF);
        settings.setRenderPriority(WebSettings.RenderPriority.NORMAL);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(false);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(true);
        settings.setMediaPlaybackRequiresUserGesture(!z);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setInitialScale(0);
        setBackgroundColor(0);
        ViewUtilities.setBackground(this, new ColorDrawable(0));
        setBackgroundResource(0);
        boolean isWebMessageEnabled = experiments.isWebMessageEnabled();
        if (isWebMessageEnabled) {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerEnabledMetric());
        } else {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerDisabledMetric());
        }
        boolean isFeatureSupported = WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER");
        if (isFeatureSupported) {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerSupportedMetric());
        } else {
            getSdkMetricsSender().sendMetric(WebViewMetricKt.webMessageListenerUnsupportedMetric());
        }
        if (isWebMessageEnabled && isFeatureSupported) {
            WebView webView2 = this;
            WebViewCompat.addWebMessageListener(webView2, "handleInvocation", SetsKt.setOf(ProxyConfig.MATCH_ALL_SCHEMES), new WebViewCompat.WebMessageListener() { // from class: com.unity3d.services.core.webview.WebView$$ExternalSyntheticLambda0
                @Override // androidx.webkit.WebViewCompat.WebMessageListener
                public final void onPostMessage(android.webkit.WebView webView3, WebMessageCompat webMessageCompat, Uri uri, boolean z2, JavaScriptReplyProxy javaScriptReplyProxy) {
                    WebViewBridgeInterface.this.onHandleInvocation(webView3, webMessageCompat, uri, z2, javaScriptReplyProxy);
                }
            });
            WebViewCompat.addWebMessageListener(webView2, "handleCallback", SetsKt.setOf(ProxyConfig.MATCH_ALL_SCHEMES), new WebViewCompat.WebMessageListener() { // from class: com.unity3d.services.core.webview.WebView$$ExternalSyntheticLambda1
                @Override // androidx.webkit.WebViewCompat.WebMessageListener
                public final void onPostMessage(android.webkit.WebView webView3, WebMessageCompat webMessageCompat, Uri uri, boolean z2, JavaScriptReplyProxy javaScriptReplyProxy) {
                    WebViewBridgeInterface.this.onHandleCallback(webView3, webMessageCompat, uri, z2, javaScriptReplyProxy);
                }
            });
            return;
        }
        addJavascriptInterface(webViewBridgeInterface, "webviewbridge");
    }

    private final SDKMetricsSender getSdkMetricsSender() {
        return (SDKMetricsSender) this.sdkMetricsSender.getValue();
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(final String script, final ValueCallback<String> resultCallback) {
        Intrinsics.checkNotNullParameter(script, "script");
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.core.webview.WebView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                WebView.evaluateJavascript$lambda$1(WebView.this, script, resultCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void evaluateJavascript$lambda$1(WebView this$0, String script, ValueCallback valueCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(script, "$script");
        super.evaluateJavascript(script, valueCallback);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        DeviceLog.debug("Loading url: " + url);
        super.loadUrl(url);
    }
}

// ===== FILE: com/unity3d/services/core/webview/WebViewApp.java =====
package com.unity3d.services.core.webview;

import android.os.Build;
import android.os.ConditionVariable;
import android.os.Looper;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebViewClient;
import com.unity3d.services.ads.api.AdUnit;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.configuration.InitializeThread;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.bridge.CallbackStatus;
import com.unity3d.services.core.webview.bridge.IWebViewBridge;
import com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker;
import com.unity3d.services.core.webview.bridge.Invocation;
import com.unity3d.services.core.webview.bridge.NativeCallback;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import com.unity3d.services.core.webview.bridge.WebViewBridge;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class WebViewApp implements IWebViewBridgeInvoker {
    private static final int INVOKE_JS_CHARS_LENGTH = 22;
    private static ConditionVariable _conditionVariable;
    private static WebViewApp _currentApp;
    private Configuration _configuration;
    private final HashMap<String, NativeCallback> _nativeCallbacks;
    private boolean _webAppLoaded;
    private WebView _webView;
    protected final IWebViewBridge _webViewBridge;
    private static final AtomicReference<Boolean> _initialized = new AtomicReference<>(false);
    private static final AtomicReference<String> _webAppFailureMessage = new AtomicReference<>();
    private static final AtomicReference<Integer> _webAppFailureCode = new AtomicReference<>();

    private WebViewApp(Configuration configuration, boolean z, boolean z2) {
        this(configuration, z, z2, SharedInstances.INSTANCE.getWebViewBridge());
    }

    private WebViewApp(Configuration configuration, boolean z, boolean z2, IWebViewBridge iWebViewBridge) {
        WebView webView;
        this._webAppLoaded = false;
        this._nativeCallbacks = new HashMap<>();
        setConfiguration(configuration);
        WebViewBridge.setClassTable(getConfiguration().getWebAppApiClassList());
        IExperiments experiments = configuration.getExperiments();
        this._webViewBridge = iWebViewBridge;
        if (z) {
            webView = new WebViewWithCache(ClientProperties.getApplicationContext(), z2, experiments);
        } else {
            webView = new WebView(ClientProperties.getApplicationContext(), z2, SharedInstances.INSTANCE.getWebViewBridge(), SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker(), experiments);
        }
        this._webView = webView;
        webView.setWebViewClient(new WebAppClient());
    }

    public WebViewApp() {
        this._webAppLoaded = false;
        this._nativeCallbacks = new HashMap<>();
        WebViewBridge.setClassTable(new Class[0]);
        this._webViewBridge = SharedInstances.INSTANCE.getWebViewBridge();
        _conditionVariable = new ConditionVariable();
    }

    public void setWebAppLoaded(boolean z) {
        this._webAppLoaded = z;
    }

    public boolean isWebAppLoaded() {
        return this._webAppLoaded;
    }

    public void setWebAppFailureMessage(String str) {
        _webAppFailureMessage.set(str);
    }

    public void setWebAppFailureCode(int i) {
        _webAppFailureCode.set(Integer.valueOf(i));
    }

    public String getWebAppFailureMessage() {
        return _webAppFailureMessage.get();
    }

    public int getWebAppFailureCode() {
        return _webAppFailureCode.get().intValue();
    }

    public void setWebAppInitialized(boolean z) {
        _initialized.set(Boolean.valueOf(z));
        _conditionVariable.open();
    }

    public void resetWebViewAppInitialization() {
        this._webAppLoaded = false;
        _webAppFailureCode.set(-1);
        _webAppFailureMessage.set("");
        _initialized.set(false);
    }

    public boolean isWebAppInitialized() {
        return _initialized.get().booleanValue();
    }

    public WebView getWebView() {
        return this._webView;
    }

    public void setWebView(WebView webView) {
        this._webView = webView;
    }

    public Configuration getConfiguration() {
        return this._configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this._configuration = configuration;
    }

    private void invokeJavascriptMethod(String str, String str2, JSONArray jSONArray) {
        String buildInvokeJavascript = buildInvokeJavascript(str, str2, jSONArray);
        DeviceLog.debug("Invoking javascript: %s", buildInvokeJavascript);
        getWebView().evaluateJavascript(buildInvokeJavascript, null);
    }

    private String buildInvokeJavascript(String str, String str2, JSONArray jSONArray) {
        String jSONArray2 = jSONArray.toString();
        StringBuilder sb = new StringBuilder(str.length() + 22 + str2.length() + jSONArray2.length());
        sb.append("javascript:window.");
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        sb.append("(");
        sb.append(jSONArray2);
        sb.append(");");
        return sb.toString();
    }

    public boolean sendEvent(Enum r6, Enum r7, Object... objArr) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("sendEvent ignored because web app is not loaded");
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(r6.name());
        jSONArray.put(r7.name());
        for (Object obj : objArr) {
            jSONArray.put(obj);
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleEvent", jSONArray);
            return true;
        } catch (Error unused) {
            DeviceLog.error("Out of memory error while sending event to WebView");
            ((SDKMetricsSender) Utilities.getService(SDKMetricsSender.class)).sendEvent("native_webview_oom", null, new HashMap<String, String>(r6, r7) { // from class: com.unity3d.services.core.webview.WebViewApp.1
                final /* synthetic */ Enum val$eventCategory;
                final /* synthetic */ Enum val$eventId;

                {
                    this.val$eventCategory = r6;
                    this.val$eventId = r7;
                    put("src", "handleEvent");
                    put("eventCategory", r6.name());
                    put("eventId", r7.name());
                }
            });
            return false;
        } catch (Exception e) {
            DeviceLog.exception("Error while sending event to WebView", e);
            return false;
        }
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker
    public boolean invokeMethod(String str, String str2, Method method, Object... objArr) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("invokeMethod ignored because web app is not loaded");
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(str);
        jSONArray.put(str2);
        if (method != null) {
            NativeCallback nativeCallback = new NativeCallback(method);
            addCallback(nativeCallback);
            jSONArray.put(nativeCallback.getId());
        } else {
            jSONArray.put((Object) null);
        }
        if (objArr != null) {
            for (Object obj : objArr) {
                jSONArray.put(obj);
            }
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleInvocation", jSONArray);
            return true;
        } catch (Error unused) {
            DeviceLog.error("Out of memory error while handling invocation to WebView");
            ((SDKMetricsSender) Utilities.getService(SDKMetricsSender.class)).sendEvent("native_webview_oom", null, new HashMap<String, String>(str, str2) { // from class: com.unity3d.services.core.webview.WebViewApp.2
                final /* synthetic */ String val$className;
                final /* synthetic */ String val$methodName;

                {
                    this.val$className = str;
                    this.val$methodName = str2;
                    put("src", "handleInvocation");
                    put("className", str);
                    put("methodName", str2);
                }
            });
            return false;
        } catch (Exception e) {
            DeviceLog.exception("Error invoking javascript method", e);
            return false;
        }
    }

    public boolean invokeCallback(Invocation invocation) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("invokeBatchCallback ignored because web app is not loaded");
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        ArrayList<ArrayList<Object>> responses = invocation.getResponses();
        if (responses != null && !responses.isEmpty()) {
            Iterator<ArrayList<Object>> it = responses.iterator();
            while (it.hasNext()) {
                ArrayList<Object> next = it.next();
                CallbackStatus callbackStatus = (CallbackStatus) next.get(0);
                Enum r6 = (Enum) next.get(1);
                Object[] objArr = (Object[]) next.get(2);
                String str = (String) objArr[0];
                Object[] copyOfRange = Arrays.copyOfRange(objArr, 1, objArr.length);
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                arrayList.add(callbackStatus.toString());
                JSONArray jSONArray2 = new JSONArray();
                if (r6 != null) {
                    jSONArray2.put(r6.name());
                }
                for (Object obj : copyOfRange) {
                    jSONArray2.put(obj);
                }
                arrayList.add(jSONArray2);
                JSONArray jSONArray3 = new JSONArray();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONArray.put(jSONArray3);
            }
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleCallback", jSONArray);
        } catch (Error unused) {
            DeviceLog.error("Out of memory error while invoking callback to WebView");
            ((SDKMetricsSender) Utilities.getService(SDKMetricsSender.class)).sendEvent("native_webview_oom", null, new HashMap<String, String>(invocation) { // from class: com.unity3d.services.core.webview.WebViewApp.3
                final /* synthetic */ Invocation val$invocation;

                {
                    this.val$invocation = invocation;
                    put("src", "handleCallback");
                    put("invocation", invocation.toString());
                }
            });
            return false;
        } catch (Exception e) {
            DeviceLog.exception("Error while invoking batch response for WebView", e);
        }
        return true;
    }

    public void addCallback(NativeCallback nativeCallback) {
        synchronized (this._nativeCallbacks) {
            this._nativeCallbacks.put(nativeCallback.getId(), nativeCallback);
        }
    }

    public void removeCallback(NativeCallback nativeCallback) {
        synchronized (this._nativeCallbacks) {
            this._nativeCallbacks.remove(nativeCallback.getId());
        }
    }

    public NativeCallback getCallback(String str) {
        NativeCallback nativeCallback;
        synchronized (this._nativeCallbacks) {
            nativeCallback = this._nativeCallbacks.get(str);
        }
        return nativeCallback;
    }

    public static WebViewApp getCurrentApp() {
        return _currentApp;
    }

    public static void setCurrentApp(WebViewApp webViewApp) {
        _currentApp = webViewApp;
    }

    public static ErrorState create(Configuration configuration) throws IllegalThreadStateException {
        return create(configuration, false);
    }

    public static ErrorState create(final Configuration configuration, boolean z) throws IllegalThreadStateException {
        DeviceLog.entered();
        if (z) {
            return createWithRemoteUrl(configuration);
        }
        if (Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            throw new IllegalThreadStateException("Cannot call create() from main thread!");
        }
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.core.webview.WebViewApp.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Configuration configuration2 = Configuration.this;
                    WebViewApp webViewApp = new WebViewApp(configuration2, configuration2.getExperiments().isWebAssetAdCaching(), Configuration.this.getExperiments().isWebGestureNotRequired());
                    webViewApp.getWebView().loadDataWithBaseURL(new WebViewUrlBuilder("file://" + SdkProperties.getLocalWebViewFile(), Configuration.this).getUrlWithQueryString(), Configuration.this.getWebViewData(), "text/html", "UTF-8", null);
                    WebViewApp.setCurrentApp(webViewApp);
                } catch (Exception e) {
                    DeviceLog.error("Unity Ads SDK unable to create WebViewApp " + e.getMessage());
                    WebViewApp._conditionVariable.open();
                }
            }
        });
        ConditionVariable conditionVariable = new ConditionVariable();
        _conditionVariable = conditionVariable;
        boolean block = conditionVariable.block(configuration.getWebViewAppCreateTimeout());
        boolean z2 = getCurrentApp() != null;
        if (block && z2 && (z2 && getCurrentApp().isWebAppInitialized())) {
            return null;
        }
        if (!block) {
            return ErrorState.CreateWebviewTimeout;
        }
        if (getCurrentApp() == null) {
            return ErrorState.CreateWebview;
        }
        return getCurrentApp().getErrorStateFromWebAppCode();
    }

    private static ErrorState createWithRemoteUrl(final Configuration configuration) {
        if (Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            throw new IllegalThreadStateException("Cannot call create() from main thread!");
        }
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.core.webview.WebViewApp.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Configuration configuration2 = Configuration.this;
                    WebViewApp webViewApp = new WebViewApp(configuration2, true, configuration2.getExperiments().isWebGestureNotRequired());
                    webViewApp.getWebView().loadUrl(new WebViewUrlBuilder(Configuration.this.getWebViewUrl(), Configuration.this).getUrlWithQueryString());
                    WebViewApp.setCurrentApp(webViewApp);
                } catch (Exception unused) {
                    DeviceLog.error("Unity Ads SDK unable to create WebViewApp");
                    WebViewApp._conditionVariable.open();
                }
            }
        });
        ConditionVariable conditionVariable = new ConditionVariable();
        _conditionVariable = conditionVariable;
        boolean block = conditionVariable.block(configuration.getWebViewAppCreateTimeout());
        boolean z = getCurrentApp() != null;
        if (block && z && (z && getCurrentApp().isWebAppInitialized())) {
            return null;
        }
        if (!block) {
            return ErrorState.CreateWebviewTimeout;
        }
        if (getCurrentApp() == null) {
            return ErrorState.CreateWebview;
        }
        return getCurrentApp().getErrorStateFromWebAppCode();
    }

    public ErrorState getErrorStateFromWebAppCode() {
        int webAppFailureCode = getWebAppFailureCode();
        if (webAppFailureCode == 1) {
            return ErrorState.CreateWebviewGameIdDisabled;
        }
        if (webAppFailureCode == 2) {
            return ErrorState.CreateWebviewConfigError;
        }
        if (webAppFailureCode == 3) {
            return ErrorState.CreateWebviewInvalidArgument;
        }
        return ErrorState.CreateWebview;
    }

    private static class WebAppClient extends WebViewClient {
        private WebAppClient() {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(android.webkit.WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.core.webview.WebViewApp.WebAppClient.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AdUnit.getAdUnitActivity() != null) {
                        AdUnit.getAdUnitActivity().finish();
                    }
                    if (WebViewApp.getCurrentApp() != null && WebViewApp.getCurrentApp().getWebView() != null) {
                        ViewUtilities.removeViewFromParent(WebViewApp.getCurrentApp().getWebView());
                    }
                    InitializeThread.reset();
                }
            });
            DeviceLog.error("UnityAds SDK WebView render process gone with following reason : " + renderProcessGoneDetail.toString());
            ((SDKMetricsSender) Utilities.getService(SDKMetricsSender.class)).sendEvent("native_webview_render_process_gone", null, new HashMap<String, String>(renderProcessGoneDetail) { // from class: com.unity3d.services.core.webview.WebViewApp.WebAppClient.2
                final /* synthetic */ RenderProcessGoneDetail val$detail;

                {
                    this.val$detail = renderProcessGoneDetail;
                    if (Build.VERSION.SDK_INT >= 26) {
                        put("dc", "" + renderProcessGoneDetail.didCrash());
                        put("pae", "" + renderProcessGoneDetail.rendererPriorityAtExit());
                    }
                }
            });
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, String str) {
            super.onPageFinished(webView, str);
            DeviceLog.debug("Unity Ads SDK finished loading URL inside WebView: " + str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
            DeviceLog.debug("Unity Ads SDK attempts to load URL inside WebView: " + str);
            return false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest != null && webResourceError != null) {
                DeviceLog.error("Unity Ads SDK encountered an error (code: " + webResourceError.getErrorCode() + ")  in WebView while loading a resource " + webResourceRequest.getUrl());
                return;
            }
            if (webResourceRequest != null) {
                DeviceLog.error("Unity Ads SDK encountered an error in WebView while loading a resource " + webResourceRequest.getUrl());
                return;
            }
            DeviceLog.error("Unity Ads SDK encountered an error in WebView while loading a resource");
        }
    }
}

// ===== FILE: com/unity3d/services/core/webview/WebViewEventCategory.java =====
package com.unity3d.services.core.webview;

/* loaded from: classes.dex */
public enum WebViewEventCategory {
    ADUNIT,
    BANNER,
    VIDEOPLAYER,
    REQUEST,
    RESOLVE,
    CACHE,
    CONNECTIVITY,
    STORAGE,
    BROADCAST,
    LIFECYCLE,
    DEVICEINFO,
    WEBPLAYER,
    PURCHASING,
    ANALYTICS,
    PERMISSIONS,
    STORE,
    LOAD_API,
    TOKEN,
    INIT_GMA,
    GMA,
    MEASUREMENTS,
    TOPICS
}

// ===== FILE: com/unity3d/services/core/webview/WebViewMetricKt.java =====
package com.unity3d.services.core.webview;

import com.unity3d.services.core.request.metrics.Metric;
import kotlin.Metadata;

/* compiled from: WebViewMetric.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0005"}, m444d2 = {"webMessageListenerDisabledMetric", "Lcom/unity3d/services/core/request/metrics/Metric;", "webMessageListenerEnabledMetric", "webMessageListenerSupportedMetric", "webMessageListenerUnsupportedMetric", "unity-ads_release"}, m445k = 2, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class WebViewMetricKt {
    public static final Metric webMessageListenerSupportedMetric() {
        return new Metric("web_message_listener_supported", null, null, 6, null);
    }

    public static final Metric webMessageListenerUnsupportedMetric() {
        return new Metric("web_message_listener_unsupported", null, null, 6, null);
    }

    public static final Metric webMessageListenerDisabledMetric() {
        return new Metric("web_message_listener_disabled", null, null, 6, null);
    }

    public static final Metric webMessageListenerEnabledMetric() {
        return new Metric("web_message_listener_enabled", null, null, 6, null);
    }
}

// ===== FILE: com/unity3d/services/core/webview/WebViewUrlBuilder.java =====
package com.unity3d.services.core.webview;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class WebViewUrlBuilder {
    private final SDKMetricsSender _sdkMetricsSender = (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);
    private final String _urlWithQueryString;

    public WebViewUrlBuilder(String str, Configuration configuration) {
        this._urlWithQueryString = str + ((("?platform=android" + buildQueryParam("origin", configuration.getWebViewUrl())) + buildQueryParam("version", configuration.getWebViewVersion())) + buildQueryParam("isNativeCollectingMetrics", String.valueOf(configuration.areMetricsEnabledForCurrentSession())));
    }

    public String getUrlWithQueryString() {
        return this._urlWithQueryString;
    }

    private String buildQueryParam(String str, String str2) {
        if (str2 == null) {
            return "";
        }
        try {
            return "&" + str + "=" + URLEncoder.encode(str2, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            DeviceLog.exception(String.format("Unsupported charset when encoding %s", str), e);
            return "";
        }
    }
}

// ===== FILE: com/unity3d/services/core/webview/WebViewWithCache.java =====
package com.unity3d.services.core.webview;

import android.content.Context;
import android.webkit.WebSettings;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.webview.bridge.IInvocationCallbackInvoker;
import com.unity3d.services.core.webview.bridge.IWebViewBridge;
import com.unity3d.services.core.webview.bridge.SharedInstances;

/* loaded from: classes.dex */
public class WebViewWithCache extends WebView {
    public WebViewWithCache(Context context, boolean z, IExperiments iExperiments) {
        this(context, z, SharedInstances.INSTANCE.getWebViewBridge(), SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker(), iExperiments);
    }

    public WebViewWithCache(Context context, boolean z, IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, IExperiments iExperiments) {
        super(context, z, iWebViewBridge, iInvocationCallbackInvoker, iExperiments);
        WebSettings settings = getSettings();
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
        if (z) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
    }
}
