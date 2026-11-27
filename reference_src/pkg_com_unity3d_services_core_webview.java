// Package bundle: com.unity3d.services.core.webview (15 classes)

// ============================================================
// CLASS: com.unity3d.services.core.webview.WebView
// ============================================================
package com.unity3d.services.core.webview;

public class WebView extends WebView {
    private final Lazy sdkMetricsSender$delegate;
    private final WebViewBridgeInterface webViewBridgeInterface;

    public static void $r8$lambda$_rTxiPsfKa4Kd9bNxyET7_zYdWU(WebView p0, String p1, ValueCallback p2) {
        WebView.evaluateJavascript$lambda$1(p0, p1, p2);
        return;
    }

    public WebView(Context p0) {
        new WebView(p0, 0, 0, 0, 0, 30, 0);
        return;
    }

    public WebView(Context p0, boolean p1) {
        new WebView(p0, p1, 0, 0, 0, 28, 0);
        return;
    }

    public WebView(Context p0, boolean p1, IWebViewBridge p2) {
        new WebView(p0, p1, p2, 0, 0, 24, 0);
        return;
    }

    public WebView(Context p0, boolean p1, IWebViewBridge p2, IInvocationCallbackInvoker p3) {
        new WebView(p0, p1, p2, p3, 0, 16, 0);
        return;
    }

    public WebView(Context p0, boolean p1, IWebViewBridge p2, IInvocationCallbackInvoker p3, IExperiments p4) {
        new WebView(p0);
        new WebView$special$$inlined$inject$default$1(new WebView(..), "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new WebView$special$$inlined$inject$default$1(..));
        sdkMetricsSender$delegate = LazyKt.lazy(..);
        new WebViewBridgeInterface(p2, p3);
        webViewBridgeInterface = new WebViewBridgeInterface(..);
        new WebView(..).getSettings();
        WebView.getSettings(..).setAllowFileAccessFromFileURLs(1);
        WebView.getSettings(..).setAllowUniversalAccessFromFileURLs(1);
        WebView.getSettings(..).setAllowFileAccess(1);
        WebView.getSettings(..).setBlockNetworkImage(0);
        WebView.getSettings(..).setBlockNetworkLoads(0);
        WebView.getSettings(..).setBuiltInZoomControls(0);
        WebView.getSettings(..).setCacheMode(2);
        WebView.getSettings(..).setDatabaseEnabled(0);
        WebView.getSettings(..).setDisplayZoomControls(0);
        WebView.getSettings(..).setDomStorageEnabled(0);
        WebView.getSettings(..).setEnableSmoothTransition(0);
        WebView.getSettings(..).setGeolocationEnabled(0);
        WebView.getSettings(..).setJavaScriptCanOpenWindowsAutomatically(0);
        WebView.getSettings(..).setJavaScriptEnabled(1);
        WebView.getSettings(..).setLightTouchEnabled(0);
        WebView.getSettings(..).setLoadWithOverviewMode(0);
        WebView.getSettings(..).setLoadsImagesAutomatically(1);
        WebView.getSettings(..).setMediaPlaybackRequiresUserGesture(0);
        WebView.getSettings(..).setMixedContentMode(1);
        WebView.getSettings(..).setNeedInitialFocus(1);
        WebView.getSettings(..).setPluginState(WebSettings$PluginState.OFF);
        WebView.getSettings(..).setRenderPriority(WebSettings$RenderPriority.NORMAL);
        WebView.getSettings(..).setSaveFormData(0);
        WebView.getSettings(..).setSavePassword(0);
        WebView.getSettings(..).setSupportMultipleWindows(0);
        WebView.getSettings(..).setSupportZoom(0);
        WebView.getSettings(..).setUseWideViewPort(1);
        WebView.getSettings(..).setMediaPlaybackRequiresUserGesture(p1);
        new WebView(..).setHorizontalScrollBarEnabled(0);
        new WebView(..).setVerticalScrollBarEnabled(0);
        new WebView(..).setInitialScale(0);
        new WebView(..).setBackgroundColor(0);
        new ColorDrawable(0);
        ViewUtilities.setBackground(new WebView(..), new ColorDrawable(..));
        new WebView(..).setBackgroundResource(0);
        p4.isWebMessageEnabled();
        if (if-eqz(IExperiments.isWebMessageEnabled(..))) goto L_c0;
        new WebView(..).getSdkMetricsSender();
        WebViewMetricKt.webMessageListenerEnabledMetric();
        WebView.getSdkMetricsSender(..).sendMetric(WebViewMetricKt.webMessageListenerEnabledMetric(..));
      L_c0:
        new WebView(..).getSdkMetricsSender();
        WebViewMetricKt.webMessageListenerDisabledMetric();
        WebView.getSdkMetricsSender(..).sendMetric(WebViewMetricKt.webMessageListenerDisabledMetric(..));
      L_cb:
        WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER");
        if (if-eqz(WebViewFeature.isFeatureSupported(..))) goto L_df;
        new WebView(..).getSdkMetricsSender();
        WebViewMetricKt.webMessageListenerSupportedMetric();
        WebView.getSdkMetricsSender(..).sendMetric(WebViewMetricKt.webMessageListenerSupportedMetric(..));
      L_df:
        new WebView(..).getSdkMetricsSender();
        WebViewMetricKt.webMessageListenerUnsupportedMetric();
        WebView.getSdkMetricsSender(..).sendMetric(WebViewMetricKt.webMessageListenerUnsupportedMetric(..));
      L_ea:
        if (if-eqz(IExperiments.isWebMessageEnabled(..))) goto L_110;
        if (if-eqz(WebViewFeature.isFeatureSupported(..))) goto L_110;
        SetsKt.setOf("*");
        new WebView$$ExternalSyntheticLambda0(new WebViewBridgeInterface(..));
        WebViewCompat.addWebMessageListener(new WebView(..), "handleInvocation", SetsKt.setOf(..), new WebView$$ExternalSyntheticLambda0(..));
        SetsKt.setOf("*");
        new WebView$$ExternalSyntheticLambda1(new WebViewBridgeInterface(..));
        WebViewCompat.addWebMessageListener(new WebView(..), "handleCallback", SetsKt.setOf(..), new WebView$$ExternalSyntheticLambda1(..));
      L_110:
        new WebView(..).addJavascriptInterface("handleCallback", "webviewbridge");
      L_115:
        return;
    }

    public WebView(Context p0, boolean p1, IWebViewBridge p2, IInvocationCallbackInvoker p3, IExperiments p4, int p5, DefaultConstructorMarker p6) {
        if (if-eqz(p6)) goto L_5;
      L_5:
        if (if-eqz(0)) goto L_10;
        SharedInstances.INSTANCE.getWebViewBridge();
      L_10:
        if (if-eqz(SharedInstances.INSTANCE)) goto L_1b;
        SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker();
      L_1b:
        if (if-eqz(SharedInstances.INSTANCE)) goto L_28;
        new Experiments();
      L_28:
        new WebView(p0, 0, SharedInstances.getWebViewBridge(..), SharedInstances.getWebViewAppInvocationCallbackInvoker(..), new Experiments(..));
        return;
    }

    private static final void evaluateJavascript$lambda$1(WebView p0, String p1, ValueCallback p2) {
        p0.evaluateJavascript(p1, p2);
        return;
    }

    private final SDKMetricsSender getSdkMetricsSender() {
        sdkMetricsSender$delegate.getValue();
        return Lazy.getValue(..);
    }

    public void evaluateJavascript(String p0, ValueCallback p1) {
        new WebView$$ExternalSyntheticLambda2(this, p0, p1);
        Utilities.runOnUiThread(new WebView$$ExternalSyntheticLambda2(..));
        return;
    }

    public IServiceProvider getServiceProvider() {
        IServiceComponent$DefaultImpls.getServiceProvider(this);
        return IServiceComponent$DefaultImpls.getServiceProvider(..);
    }

    public void loadUrl(String p0) {
        new StringBuilder("Loading url: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        WebView.loadUrl(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.WebViewApp
// ============================================================
package com.unity3d.services.core.webview;

public class WebViewApp {
    private static final int INVOKE_JS_CHARS_LENGTH = 22;
    private static ConditionVariable _conditionVariable;
    private static WebViewApp _currentApp;
    private static final AtomicReference _initialized;
    private static final AtomicReference _webAppFailureCode;
    private static final AtomicReference _webAppFailureMessage;
    private Configuration _configuration;
    private final HashMap _nativeCallbacks;
    private boolean _webAppLoaded;
    private WebView _webView;
    protected final IWebViewBridge _webViewBridge;

    static <clinit>() {
        Boolean.valueOf(0);
        new AtomicReference(Boolean.valueOf(..));
        _initialized = new AtomicReference(..);
        new AtomicReference();
        _webAppFailureMessage = new AtomicReference(..);
        new AtomicReference();
        _webAppFailureCode = new AtomicReference(..);
        return;
    }

    public WebViewApp() {
        new Object();
        _webAppLoaded = 0;
        new HashMap();
        _nativeCallbacks = new HashMap(..);
        WebViewBridge.setClassTable(0);
        SharedInstances.INSTANCE.getWebViewBridge();
        _webViewBridge = SharedInstances.getWebViewBridge(..);
        new ConditionVariable();
        _conditionVariable = new ConditionVariable(..);
        return;
    }

    private WebViewApp(Configuration p0, boolean p1, boolean p2) {
        SharedInstances.INSTANCE.getWebViewBridge();
        new WebViewApp(p0, p1, p2, SharedInstances.getWebViewBridge(..));
        return;
    }

    WebViewApp(Configuration p0, boolean p1, boolean p2, WebViewApp$1 p3) {
        new WebViewApp(p0, p1, p2);
        return;
    }

    private WebViewApp(Configuration p0, boolean p1, boolean p2, IWebViewBridge p3) {
        new Object();
        _webAppLoaded = 0;
        new HashMap();
        _nativeCallbacks = new HashMap(..);
        new Object(..).setConfiguration(p0);
        new Object(..).getConfiguration();
        WebViewApp.getConfiguration(..).getWebAppApiClassList();
        WebViewBridge.setClassTable(Configuration.getWebAppApiClassList(..));
        p0.getExperiments();
        _webViewBridge = p3;
        if (if-eqz(p1)) goto L_2d;
        ClientProperties.getApplicationContext();
        new WebViewWithCache(ClientProperties.getApplicationContext(..), p2, Configuration.getExperiments(..));
      L_2d:
        ClientProperties.getApplicationContext();
        SharedInstances.INSTANCE.getWebViewBridge();
        SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker();
        new WebView(ClientProperties.getApplicationContext(..), p2, SharedInstances.getWebViewBridge(..), SharedInstances.getWebViewAppInvocationCallbackInvoker(..), Configuration.getExperiments(..));
      L_44:
        _webView = new WebView;
        new WebViewApp$WebAppClient(0);
        new WebView.setWebViewClient(new WebViewApp$WebAppClient(..));
        return;
    }

    static ConditionVariable access$200() {
        return WebViewApp._conditionVariable;
    }

    private String buildInvokeJavascript(String p0, String p1, JSONArray p2) {
        p2.toString();
        p0.length();
        p1.length();
        JSONArray.toString(..).length();
        new StringBuilder(String.length(..));
        new StringBuilder(..).append("javascript:window.");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(".");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append("(");
        new StringBuilder(..).append(JSONArray.toString(..));
        new StringBuilder(..).append(");");
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    public static ErrorState create(Configuration p0) {
        WebViewApp.create(p0, 0);
        return WebViewApp.create(..);
    }

    public static ErrorState create(Configuration p0, boolean p1) {
        DeviceLog.entered();
        if (if-eqz(p1)) goto L_a;
        WebViewApp.createWithRemoteUrl(p0);
        return WebViewApp.createWithRemoteUrl(..);
      L_a:
        Thread.currentThread();
        Looper.getMainLooper();
        Looper.getMainLooper(..).getThread();
        Thread.currentThread(..).equals(Looper.getThread(..));
        if (if-nez(Object.equals(..))) goto L_70;
        new WebViewApp$4(WebViewApp.createWithRemoteUrl(..));
        Utilities.runOnUiThread(new WebViewApp$4(..));
        new ConditionVariable();
        _conditionVariable = new ConditionVariable(..);
        WebViewApp.createWithRemoteUrl(..).getWebViewAppCreateTimeout();
        new ConditionVariable(..).block(Configuration.getWebViewAppCreateTimeout(..), v1);
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_3d;
      L_3d:
      L_3e:
        if (if-eqz(0)) goto L_4c;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).isWebAppInitialized();
        if (if-eqz(WebViewApp.isWebAppInitialized(..))) goto L_4c;
      L_4c:
      L_4d:
        if (if-eqz(ConditionVariable.block(..))) goto L_54;
        if (if-eqz(0)) goto L_54;
        if (if-eqz(0)) goto L_54;
      L_54:
      L_55:
        if (if-nez(0)) goto L_6e;
        if (if-nez(ConditionVariable.block(..))) goto L_5c;
        return ErrorState.CreateWebviewTimeout;
      L_5c:
        WebViewApp.getCurrentApp();
        if (if-nez(WebViewApp.getCurrentApp(..))) goto L_65;
        return ErrorState.CreateWebview;
      L_65:
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getErrorStateFromWebAppCode();
        return WebViewApp.getErrorStateFromWebAppCode(..);
      L_6e:
        return 0;
      L_70:
        new IllegalThreadStateException("Cannot call create() from main thread!");
        throw new IllegalThreadStateException(..);
    }

    private static ErrorState createWithRemoteUrl(Configuration p0) {
        Thread.currentThread();
        Looper.getMainLooper();
        Looper.getMainLooper(..).getThread();
        Thread.currentThread(..).equals(Looper.getThread(..));
        if (if-nez(Object.equals(..))) goto L_66;
        new WebViewApp$5(p0);
        Utilities.runOnUiThread(new WebViewApp$5(..));
        new ConditionVariable();
        _conditionVariable = new ConditionVariable(..);
        p0.getWebViewAppCreateTimeout();
        new ConditionVariable(..).block(Configuration.getWebViewAppCreateTimeout(..), v2);
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_33;
      L_33:
      L_34:
        if (if-eqz(0)) goto L_42;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).isWebAppInitialized();
        if (if-eqz(WebViewApp.isWebAppInitialized(..))) goto L_42;
      L_42:
      L_43:
        if (if-eqz(ConditionVariable.block(..))) goto L_4a;
        if (if-eqz(0)) goto L_4a;
        if (if-eqz(0)) goto L_4a;
      L_4a:
      L_4b:
        if (if-nez(0)) goto L_64;
        if (if-nez(ConditionVariable.block(..))) goto L_52;
        return ErrorState.CreateWebviewTimeout;
      L_52:
        WebViewApp.getCurrentApp();
        if (if-nez(WebViewApp.getCurrentApp(..))) goto L_5b;
        return ErrorState.CreateWebview;
      L_5b:
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getErrorStateFromWebAppCode();
        return WebViewApp.getErrorStateFromWebAppCode(..);
      L_64:
        return 0;
      L_66:
        new IllegalThreadStateException("Cannot call create() from main thread!");
        throw new IllegalThreadStateException(..);
    }

    public static WebViewApp getCurrentApp() {
        return WebViewApp._currentApp;
    }

    private void invokeJavascriptMethod(String p0, String p1, JSONArray p2) {
        WebViewApp.buildInvokeJavascript(p0, p1, p2);
        DeviceLog.debug("Invoking javascript: %s", 1);
        WebViewApp.getWebView();
        WebViewApp.getWebView(..).evaluateJavascript(WebViewApp.buildInvokeJavascript(..), 0);
        return;
    }

    public static void setCurrentApp(WebViewApp p0) {
        _currentApp = p0;
        return;
    }

    public void addCallback(NativeCallback p0) {
        p0.getId();
        _nativeCallbacks.put(NativeCallback.getId(..), p0);
        return;
        throw p0;
    }

    public NativeCallback getCallback(String p0) {
        _nativeCallbacks.get(p0);
        return HashMap.get(..);
        throw HashMap.get(..);
    }

    public Configuration getConfiguration() {
        return _configuration;
    }

    public ErrorState getErrorStateFromWebAppCode() {
        WebViewApp.getWebAppFailureCode();
        if (if-ne(WebViewApp.getWebAppFailureCode(..), 1)) goto L_a;
        return ErrorState.CreateWebviewGameIdDisabled;
      L_a:
        if (if-ne(ErrorState.CreateWebviewGameIdDisabled, 2)) goto L_10;
        return ErrorState.CreateWebviewConfigError;
      L_10:
        if (if-ne(ErrorState.CreateWebviewConfigError, 3)) goto L_16;
        return ErrorState.CreateWebviewInvalidArgument;
      L_16:
        return ErrorState.CreateWebview;
    }

    public int getWebAppFailureCode() {
        WebViewApp._webAppFailureCode.get();
        AtomicReference.get(..).intValue();
        return Integer.intValue(..);
    }

    public String getWebAppFailureMessage() {
        WebViewApp._webAppFailureMessage.get();
        return AtomicReference.get(..);
    }

    public WebView getWebView() {
        return _webView;
    }

    public boolean invokeCallback(Invocation p0) {
        WebViewApp.isWebAppLoaded();
        if (if-nez(WebViewApp.isWebAppLoaded(..))) goto L_d;
        DeviceLog.debug("invokeBatchCallback ignored because web app is not loaded");
        return 0;
      L_d:
        new JSONArray();
        Invocation.getResponses();
        if (if-eqz(Invocation.getResponses(..))) goto L_92;
        Invocation.getResponses(..).isEmpty();
        if (if-nez(ArrayList.isEmpty(..))) goto L_92;
        Invocation.getResponses(..).iterator();
      L_23:
        ArrayList.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_92;
        ArrayList.iterator(..).next();
        Iterator.next(..).get(0);
        Iterator.next(..).get(1);
        Iterator.next(..).get(2);
        Arrays.copyOfRange(ArrayList.get(..), 1, v8);
        new ArrayList();
        new ArrayList(..).add(2);
        ArrayList.get(..).toString();
        new ArrayList(..).add(CallbackStatus.toString(..));
        new JSONArray();
        if (if-eqz(ArrayList.get(..))) goto L_68;
        ArrayList.get(..).name();
        new JSONArray(..).put(Enum.name(..));
      L_68:
      L_6a:
        if (if-ge(0, Enum.name(..))) goto L_74;
        new JSONArray(..).put(v9);
      L_74:
        new ArrayList(..).add(new JSONArray(..));
        new JSONArray();
        new ArrayList(..).iterator();
      L_80:
        ArrayList.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_8e;
        ArrayList.iterator(..).next();
        new JSONArray(..).put(Iterator.next(..));
      L_8e:
        new JSONArray(..).put(new JSONArray(..));
      L_92:
        WebViewApp.invokeJavascriptMethod("nativebridge", "handleCallback", new JSONArray(..));
        DeviceLog.error("Out of memory error while invoking callback to WebView");
        Utilities.getService(SDKMetricsSender.class);
        new WebViewApp$3(this, "invokeBatchCallback ignored because web app is not loaded");
        Utilities.getService(..).sendEvent("native_webview_oom", 0, new WebViewApp$3(..));
        return 0;
        DeviceLog.exception("Error while invoking batch response for WebView", "native_webview_oom");
      L_b9:
        return 0;
    }

    public boolean invokeMethod(String p0, String p1, Method p2, Object[] p3) {
        WebViewApp.isWebAppLoaded();
        if (if-nez(WebViewApp.isWebAppLoaded(..))) goto L_d;
        DeviceLog.debug("invokeMethod ignored because web app is not loaded");
        return 0;
      L_d:
        new JSONArray();
        new JSONArray(..).put("invokeMethod ignored because web app is not loaded");
        new JSONArray(..).put(p1);
        if (if-eqz(p2)) goto L_2b;
        new NativeCallback(p2);
        WebViewApp.addCallback(new NativeCallback(..));
        new NativeCallback(..).getId();
        new JSONArray(..).put(NativeCallback.getId(..));
      L_2b:
        new JSONArray(..).put(0);
      L_2e:
        if (if-eqz(p3)) goto L_3c;
      L_32:
        if (if-ge(0, NativeCallback.getId(..))) goto L_3c;
        new JSONArray(..).put(v4);
      L_3c:
        WebViewApp.invokeJavascriptMethod("nativebridge", "handleInvocation", new JSONArray(..));
        return 1;
        DeviceLog.error("Out of memory error while handling invocation to WebView");
        Utilities.getService(SDKMetricsSender.class);
        new WebViewApp$2(this, 1, p1);
        Utilities.getService(..).sendEvent("native_webview_oom", 0, new WebViewApp$2(..));
        return 0;
        DeviceLog.exception("Error invoking javascript method", "native_webview_oom");
        return 0;
    }

    public boolean isWebAppInitialized() {
        WebViewApp._initialized.get();
        AtomicReference.get(..).booleanValue();
        return Boolean.booleanValue(..);
    }

    public boolean isWebAppLoaded() {
        return _webAppLoaded;
    }

    public void removeCallback(NativeCallback p0) {
        p0.getId();
        _nativeCallbacks.remove(NativeCallback.getId(..));
        return;
        throw NativeCallback.getId(..);
    }

    public void resetWebViewAppInitialization() {
        _webAppLoaded = 0;
        Integer.valueOf(-1);
        WebViewApp._webAppFailureCode.set(Integer.valueOf(..));
        WebViewApp._webAppFailureMessage.set("");
        Boolean.valueOf(0);
        WebViewApp._initialized.set(Boolean.valueOf(..));
        return;
    }

    public boolean sendEvent(Enum p0, Enum p1, Object[] p2) {
        WebViewApp.isWebAppLoaded();
        if (if-nez(WebViewApp.isWebAppLoaded(..))) goto L_d;
        DeviceLog.debug("sendEvent ignored because web app is not loaded");
        return 0;
      L_d:
        new JSONArray();
        Enum.name();
        new JSONArray(..).put(Enum.name(..));
        p1.name();
        new JSONArray(..).put(Enum.name(..));
      L_22:
        if (if-ge(0, Enum.name(..))) goto L_2c;
        new JSONArray(..).put(v4);
      L_2c:
        WebViewApp.invokeJavascriptMethod("nativebridge", "handleEvent", new JSONArray(..));
        return 1;
        DeviceLog.error("Out of memory error while sending event to WebView");
        Utilities.getService(SDKMetricsSender.class);
        new WebViewApp$1(this, 1, p1);
        Utilities.getService(..).sendEvent("native_webview_oom", 0, new WebViewApp$1(..));
        return 0;
        DeviceLog.exception("Error while sending event to WebView", "native_webview_oom");
        return 0;
    }

    public void setConfiguration(Configuration p0) {
        _configuration = p0;
        return;
    }

    public void setWebAppFailureCode(int p0) {
        Integer.valueOf(p0);
        WebViewApp._webAppFailureCode.set(Integer.valueOf(..));
        return;
    }

    public void setWebAppFailureMessage(String p0) {
        WebViewApp._webAppFailureMessage.set(p0);
        return;
    }

    public void setWebAppInitialized(boolean p0) {
        Boolean.valueOf(p0);
        WebViewApp._initialized.set(Boolean.valueOf(..));
        WebViewApp._conditionVariable.open();
        return;
    }

    public void setWebAppLoaded(boolean p0) {
        _webAppLoaded = p0;
        return;
    }

    public void setWebView(WebView p0) {
        _webView = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.WebViewEventCategory
// ============================================================
package com.unity3d.services.core.webview;

public final class WebViewEventCategory extends Enum {
    private static final WebViewEventCategory[] $VALUES;
    public static final WebViewEventCategory ADUNIT;
    public static final WebViewEventCategory ANALYTICS;
    public static final WebViewEventCategory BANNER;
    public static final WebViewEventCategory BROADCAST;
    public static final WebViewEventCategory CACHE;
    public static final WebViewEventCategory CONNECTIVITY;
    public static final WebViewEventCategory DEVICEINFO;
    public static final WebViewEventCategory GMA;
    public static final WebViewEventCategory INIT_GMA;
    public static final WebViewEventCategory LIFECYCLE;
    public static final WebViewEventCategory LOAD_API;
    public static final WebViewEventCategory MEASUREMENTS;
    public static final WebViewEventCategory PERMISSIONS;
    public static final WebViewEventCategory PURCHASING;
    public static final WebViewEventCategory REQUEST;
    public static final WebViewEventCategory RESOLVE;
    public static final WebViewEventCategory STORAGE;
    public static final WebViewEventCategory STORE;
    public static final WebViewEventCategory TOKEN;
    public static final WebViewEventCategory TOPICS;
    public static final WebViewEventCategory VIDEOPLAYER;
    public static final WebViewEventCategory WEBPLAYER;

    private static WebViewEventCategory[] $values() {
        return 22;
    }

    static <clinit>() {
        new WebViewEventCategory("ADUNIT", 0);
        ADUNIT = new WebViewEventCategory(..);
        new WebViewEventCategory("BANNER", 1);
        BANNER = new WebViewEventCategory(..);
        new WebViewEventCategory("VIDEOPLAYER", 2);
        VIDEOPLAYER = new WebViewEventCategory(..);
        new WebViewEventCategory("REQUEST", 3);
        REQUEST = new WebViewEventCategory(..);
        new WebViewEventCategory("RESOLVE", 4);
        RESOLVE = new WebViewEventCategory(..);
        new WebViewEventCategory("CACHE", 5);
        CACHE = new WebViewEventCategory(..);
        new WebViewEventCategory("CONNECTIVITY", 6);
        CONNECTIVITY = new WebViewEventCategory(..);
        new WebViewEventCategory("STORAGE", 7);
        STORAGE = new WebViewEventCategory(..);
        new WebViewEventCategory("BROADCAST", 8);
        BROADCAST = new WebViewEventCategory(..);
        new WebViewEventCategory("LIFECYCLE", 9);
        LIFECYCLE = new WebViewEventCategory(..);
        new WebViewEventCategory("DEVICEINFO", 10);
        DEVICEINFO = new WebViewEventCategory(..);
        new WebViewEventCategory("WEBPLAYER", 11);
        WEBPLAYER = new WebViewEventCategory(..);
        new WebViewEventCategory("PURCHASING", 12);
        PURCHASING = new WebViewEventCategory(..);
        new WebViewEventCategory("ANALYTICS", 13);
        ANALYTICS = new WebViewEventCategory(..);
        new WebViewEventCategory("PERMISSIONS", 14);
        PERMISSIONS = new WebViewEventCategory(..);
        new WebViewEventCategory("STORE", 15);
        STORE = new WebViewEventCategory(..);
        new WebViewEventCategory("LOAD_API", 16);
        LOAD_API = new WebViewEventCategory(..);
        new WebViewEventCategory("TOKEN", 17);
        TOKEN = new WebViewEventCategory(..);
        new WebViewEventCategory("INIT_GMA", 18);
        INIT_GMA = new WebViewEventCategory(..);
        new WebViewEventCategory("GMA", 19);
        GMA = new WebViewEventCategory(..);
        new WebViewEventCategory("MEASUREMENTS", 20);
        MEASUREMENTS = new WebViewEventCategory(..);
        new WebViewEventCategory("TOPICS", 21);
        TOPICS = new WebViewEventCategory(..);
        WebViewEventCategory.$values();
        $VALUES = WebViewEventCategory.$values(..);
        return;
    }

    private WebViewEventCategory(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static WebViewEventCategory valueOf(String p0) {
        Enum.valueOf(WebViewEventCategory.class, p0);
        return Enum.valueOf(..);
    }

    public static WebViewEventCategory[] values() {
        WebViewEventCategory.$VALUES.clone();
        return WebViewEventCategory[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.WebViewMetricKt
// ============================================================
package com.unity3d.services.core.webview;

public final class WebViewMetricKt {
    public static final Metric webMessageListenerDisabledMetric() {
        new Metric("web_message_listener_disabled", 0, 0, 6, 0);
        return new Metric;
    }

    public static final Metric webMessageListenerEnabledMetric() {
        new Metric("web_message_listener_enabled", 0, 0, 6, 0);
        return new Metric;
    }

    public static final Metric webMessageListenerSupportedMetric() {
        new Metric("web_message_listener_supported", 0, 0, 6, 0);
        return new Metric;
    }

    public static final Metric webMessageListenerUnsupportedMetric() {
        new Metric("web_message_listener_unsupported", 0, 0, 6, 0);
        return new Metric;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.WebViewUrlBuilder
// ============================================================
package com.unity3d.services.core.webview;

public class WebViewUrlBuilder {
    private final SDKMetricsSender _sdkMetricsSender;
    private final String _urlWithQueryString;

    public WebViewUrlBuilder(String p0, Configuration p1) {
        new Object();
        Utilities.getService(SDKMetricsSender.class);
        _sdkMetricsSender = Utilities.getService(..);
        new StringBuilder("?platform=android");
        p1.getWebViewUrl();
        new Object(..).buildQueryParam("origin", Configuration.getWebViewUrl(..));
        new StringBuilder(..).append(WebViewUrlBuilder.buildQueryParam(..));
        new StringBuilder(..).toString();
        new StringBuilder();
        new StringBuilder(..).append(StringBuilder.toString(..));
        p1.getWebViewVersion();
        new Object(..).buildQueryParam("version", Configuration.getWebViewVersion(..));
        new StringBuilder(..).append(WebViewUrlBuilder.buildQueryParam(..));
        new StringBuilder(..).toString();
        new StringBuilder();
        new StringBuilder(..).append(StringBuilder.toString(..));
        p1.areMetricsEnabledForCurrentSession();
        String.valueOf(Configuration.areMetricsEnabledForCurrentSession(..));
        new Object(..).buildQueryParam("isNativeCollectingMetrics", String.valueOf(..));
        new StringBuilder(..).append(WebViewUrlBuilder.buildQueryParam(..));
        new StringBuilder(..).toString();
        new StringBuilder();
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(StringBuilder.toString(..));
        new StringBuilder(..).toString();
        _urlWithQueryString = StringBuilder.toString(..);
        return;
    }

    private String buildQueryParam(String p0, String p1) {
        if (if-eqz(p1)) goto L_32;
        new StringBuilder("&");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append("=");
        URLEncoder.encode(p1, "UTF-8");
        new StringBuilder(..).append(URLEncoder.encode(..));
        new StringBuilder(..).toString();
        String.format("Unsupported charset when encoding %s", 1);
        DeviceLog.exception(String.format(..), URLEncoder.encode(..));
      L_32:
        return StringBuilder.toString(..);
    }

    public String getUrlWithQueryString() {
        return _urlWithQueryString;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.WebViewWithCache
// ============================================================
package com.unity3d.services.core.webview;

public class WebViewWithCache extends WebView {
    public WebViewWithCache(Context p0, boolean p1, IExperiments p2) {
        SharedInstances.INSTANCE.getWebViewBridge();
        SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker();
        new WebViewWithCache(p0, p1, SharedInstances.getWebViewBridge(..), SharedInstances.getWebViewAppInvocationCallbackInvoker(..), p2);
        return;
    }

    public WebViewWithCache(Context p0, boolean p1, IWebViewBridge p2, IInvocationCallbackInvoker p3, IExperiments p4) {
        new WebView(p0, p1, p2, p3, p4);
        new WebView(..).getSettings();
        WebViewWithCache.getSettings(..).setCacheMode(-1);
        WebViewWithCache.getSettings(..).setDomStorageEnabled(1);
        if (if-eqz(p1)) goto L_15;
        WebViewWithCache.getSettings(..).setMediaPlaybackRequiresUserGesture(0);
      L_15:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.WebView$special$$inlined$inject$default$1
// ============================================================
package com.unity3d.services.core.webview;

public final class WebView$special$$inlined$inject$default$1 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public WebView$special$$inlined$inject$default$1(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SDKMetricsSender.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.WebViewApp$1
// ============================================================
package com.unity3d.services.core.webview;

class WebViewApp$1 extends HashMap {
    final WebViewApp this$0;
    final Enum val$eventCategory;
    final Enum val$eventId;

    WebViewApp$1(WebViewApp p0, Enum p1, Enum p2) {
        this$0 = p0;
        val$eventCategory = p1;
        val$eventId = p2;
        new HashMap();
        new HashMap(..).put("src", "handleEvent");
        p1.name();
        new HashMap(..).put("eventCategory", Enum.name(..));
        p2.name();
        new HashMap(..).put("eventId", Enum.name(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.WebViewApp$2
// ============================================================
package com.unity3d.services.core.webview;

class WebViewApp$2 extends HashMap {
    final WebViewApp this$0;
    final String val$className;
    final String val$methodName;

    WebViewApp$2(WebViewApp p0, String p1, String p2) {
        this$0 = p0;
        val$className = p1;
        val$methodName = p2;
        new HashMap();
        new HashMap(..).put("src", "handleInvocation");
        new HashMap(..).put("className", p1);
        new HashMap(..).put("methodName", p2);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.WebViewApp$3
// ============================================================
package com.unity3d.services.core.webview;

class WebViewApp$3 extends HashMap {
    final WebViewApp this$0;
    final Invocation val$invocation;

    WebViewApp$3(WebViewApp p0, Invocation p1) {
        this$0 = p0;
        val$invocation = p1;
        new HashMap();
        new HashMap(..).put("src", "handleCallback");
        p1.toString();
        new HashMap(..).put("invocation", Object.toString(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.WebViewApp$4
// ============================================================
package com.unity3d.services.core.webview;

class WebViewApp$4 {
    final Configuration val$configuration;

    WebViewApp$4(Configuration p0) {
        val$configuration = p0;
        new Object();
        return;
    }

    public void run() {
        Configuration.getExperiments();
        Configuration.getExperiments(..).isWebAssetAdCaching();
        Configuration.getExperiments();
        Configuration.getExperiments(..).isWebGestureNotRequired();
        new WebViewApp(val$configuration, IExperiments.isWebAssetAdCaching(..), IExperiments.isWebGestureNotRequired(..), 0);
        new StringBuilder("file://");
        SdkProperties.getLocalWebViewFile();
        new StringBuilder(..).append(SdkProperties.getLocalWebViewFile(..));
        new StringBuilder(..).toString();
        new WebViewUrlBuilder(StringBuilder.toString(..), val$configuration);
        new WebViewUrlBuilder(..).getUrlWithQueryString();
        new WebViewApp(..).getWebView();
        Configuration.getWebViewData();
        WebViewApp.getWebView(..).loadDataWithBaseURL(WebViewUrlBuilder.getUrlWithQueryString(..), Configuration.getWebViewData(..), "text/html", "UTF-8", 0);
        WebViewApp.setCurrentApp(new WebViewApp(..));
        return;
        new StringBuilder("Unity Ads SDK unable to create WebViewApp ");
        new WebViewApp(..).getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
        WebViewApp.access$200();
        WebViewApp.access$200(..).open();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.WebViewApp$5
// ============================================================
package com.unity3d.services.core.webview;

class WebViewApp$5 {
    final Configuration val$configuration;

    WebViewApp$5(Configuration p0) {
        val$configuration = p0;
        new Object();
        return;
    }

    public void run() {
        Configuration.getExperiments();
        Configuration.getExperiments(..).isWebGestureNotRequired();
        new WebViewApp(val$configuration, 1, IExperiments.isWebGestureNotRequired(..), 0);
        Configuration.getWebViewUrl();
        new WebViewUrlBuilder(Configuration.getWebViewUrl(..), val$configuration);
        new WebViewUrlBuilder(..).getUrlWithQueryString();
        new WebViewApp(..).getWebView();
        WebViewApp.getWebView(..).loadUrl(WebViewUrlBuilder.getUrlWithQueryString(..));
        WebViewApp.setCurrentApp(new WebViewApp(..));
        return;
        DeviceLog.error("Unity Ads SDK unable to create WebViewApp");
        WebViewApp.access$200();
        WebViewApp.access$200(..).open();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.WebViewApp$WebAppClient
// ============================================================
package com.unity3d.services.core.webview;

class WebViewApp$WebAppClient extends WebViewClient {
    private WebViewApp$WebAppClient() {
        new WebViewClient();
        return;
    }

    WebViewApp$WebAppClient(WebViewApp$1 p0) {
        new WebViewApp$WebAppClient();
        return;
    }

    public void onPageFinished(WebView p0, String p1) {
        WebViewClient.onPageFinished(p0, p1);
        new StringBuilder("Unity Ads SDK finished loading URL inside WebView: ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        return;
    }

    public void onReceivedError(WebView p0, WebResourceRequest p1, WebResourceError p2) {
        WebViewClient.onReceivedError(p0, p1, p2);
        if (if-eqz(p1)) goto L_29;
        if (if-eqz(p2)) goto L_29;
        new StringBuilder("Unity Ads SDK encountered an error (code: ");
        p2.getErrorCode();
        new StringBuilder(..).append(WebResourceError.getErrorCode(..));
        new StringBuilder(..).append(")  in WebView while loading a resource ");
        p1.getUrl();
        new StringBuilder(..).append(WebResourceRequest.getUrl(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
      L_29:
        if (if-eqz(WebResourceRequest.getUrl(..))) goto L_41;
        new StringBuilder("Unity Ads SDK encountered an error in WebView while loading a resource ");
        WebResourceRequest.getUrl(..).getUrl();
        new StringBuilder(..).append(WebResourceRequest.getUrl(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
      L_41:
        DeviceLog.error("Unity Ads SDK encountered an error in WebView while loading a resource");
      L_46:
        return;
    }

    public boolean onRenderProcessGone(WebView p0, RenderProcessGoneDetail p1) {
        new WebViewApp$WebAppClient$1(this);
        Utilities.runOnUiThread(new WebViewApp$WebAppClient$1(..));
        new StringBuilder("UnityAds SDK WebView render process gone with following reason : ");
        p1.toString();
        new StringBuilder(..).append(Object.toString(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
        Utilities.getService(SDKMetricsSender.class);
        new WebViewApp$WebAppClient$2(this, p1);
        Utilities.getService(..).sendEvent("native_webview_render_process_gone", 0, new WebViewApp$WebAppClient$2(..));
        return 1;
    }

    public boolean shouldOverrideUrlLoading(WebView p0, String p1) {
        new StringBuilder("Unity Ads SDK attempts to load URL inside WebView: ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.WebViewApp$WebAppClient$1
// ============================================================
package com.unity3d.services.core.webview;

class WebViewApp$WebAppClient$1 {
    final WebViewApp$WebAppClient this$0;

    WebViewApp$WebAppClient$1(WebViewApp$WebAppClient p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void run() {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_d;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).finish();
      L_d:
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_28;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getWebView();
        if (if-eqz(WebViewApp.getWebView(..))) goto L_28;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getWebView();
        ViewUtilities.removeViewFromParent(WebViewApp.getWebView(..));
      L_28:
        InitializeThread.reset();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.WebViewApp$WebAppClient$2
// ============================================================
package com.unity3d.services.core.webview;

class WebViewApp$WebAppClient$2 extends HashMap {
    final WebViewApp$WebAppClient this$0;
    final RenderProcessGoneDetail val$detail;

    WebViewApp$WebAppClient$2(WebViewApp$WebAppClient p0, RenderProcessGoneDetail p1) {
        this$0 = p0;
        val$detail = p1;
        new HashMap();
        if (if-lt(Build$VERSION.SDK_INT, 26)) goto L_39;
        new StringBuilder("");
        p1.didCrash();
        new StringBuilder(..).append(RenderProcessGoneDetail.didCrash(..));
        new StringBuilder(..).toString();
        new HashMap(..).put("dc", StringBuilder.toString(..));
        new StringBuilder("");
        p1.rendererPriorityAtExit();
        new StringBuilder(..).append(RenderProcessGoneDetail.rendererPriorityAtExit(..));
        new StringBuilder(..).toString();
        new HashMap(..).put("pae", StringBuilder.toString(..));
      L_39:
        return;
    }

}

