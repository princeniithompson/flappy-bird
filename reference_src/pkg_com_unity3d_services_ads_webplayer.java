// Package bundle: com.unity3d.services.ads.webplayer (14 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.webplayer.WebPlayerBridgeInterface
// ============================================================
package com.unity3d.services.ads.webplayer;

public class WebPlayerBridgeInterface {
    private final String viewId;

    public WebPlayerBridgeInterface(String p0) {
        new Object();
        viewId = p0;
        return;
    }

    public void handleEvent(String p0) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_1c;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.WEBPLAYER_EVENT, 2);
      L_1c:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.webplayer.WebPlayerError
// ============================================================
package com.unity3d.services.ads.webplayer;

public final class WebPlayerError extends Enum {
    private static final WebPlayerError[] $VALUES;
    public static final WebPlayerError WEBPLAYER_NULL;

    private static WebPlayerError[] $values() {
        return 1;
    }

    static <clinit>() {
        new WebPlayerError("WEBPLAYER_NULL", 0);
        WEBPLAYER_NULL = new WebPlayerError(..);
        WebPlayerError.$values();
        $VALUES = WebPlayerError.$values(..);
        return;
    }

    private WebPlayerError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static WebPlayerError valueOf(String p0) {
        Enum.valueOf(WebPlayerError.class, p0);
        return Enum.valueOf(..);
    }

    public static WebPlayerError[] values() {
        WebPlayerError.$VALUES.clone();
        return WebPlayerError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.webplayer.WebPlayerEvent
// ============================================================
package com.unity3d.services.ads.webplayer;

public final class WebPlayerEvent extends Enum {
    private static final WebPlayerEvent[] $VALUES;
    public static final WebPlayerEvent CLIENT_CERT_REQUEST;
    public static final WebPlayerEvent CLOSE_WINDOW;
    public static final WebPlayerEvent CONSOLE_MESSAGE;
    public static final WebPlayerEvent CREATE_WINDOW;
    public static final WebPlayerEvent DOWNLOAD_START;
    public static final WebPlayerEvent ERROR;
    public static final WebPlayerEvent FORM_RESUBMISSION;
    public static final WebPlayerEvent FRAME_UPDATE;
    public static final WebPlayerEvent GEOLOCATION_PERMISSIONS_SHOW;
    public static final WebPlayerEvent GET_FRAME_RESPONSE;
    public static final WebPlayerEvent HIDE_CUSTOM_VIEW;
    public static final WebPlayerEvent HTTP_AUTH_REQUEST;
    public static final WebPlayerEvent HTTP_ERROR;
    public static final WebPlayerEvent JS_ALERT;
    public static final WebPlayerEvent JS_CONFIRM;
    public static final WebPlayerEvent JS_PROMPT;
    public static final WebPlayerEvent LOAD_RESOUCE;
    public static final WebPlayerEvent LOGIN_REQUEST;
    public static final WebPlayerEvent PAGE_COMMIT_VISIBLE;
    public static final WebPlayerEvent PAGE_FINISHED;
    public static final WebPlayerEvent PAGE_STARTED;
    public static final WebPlayerEvent PERMISSION_REQUEST;
    public static final WebPlayerEvent PROGRESS_CHANGED;
    public static final WebPlayerEvent RECEIVED_ICON;
    public static final WebPlayerEvent RECEIVED_TITLE;
    public static final WebPlayerEvent RECEIVED_TOUCH_ICON_URL;
    public static final WebPlayerEvent REQUEST_FOCUS;
    public static final WebPlayerEvent SCALE_CHANGED;
    public static final WebPlayerEvent SHOULD_INTERCEPT_REQUEST;
    public static final WebPlayerEvent SHOULD_OVERRIDE_KEY_EVENT;
    public static final WebPlayerEvent SHOULD_OVERRIDE_URL_LOADING;
    public static final WebPlayerEvent SHOW_CUSTOM_VIEW;
    public static final WebPlayerEvent SHOW_FILE_CHOOSER;
    public static final WebPlayerEvent SSL_ERROR;
    public static final WebPlayerEvent UNHANDLED_KEY_EVENT;
    public static final WebPlayerEvent WEBPLAYER_EVENT;

    private static WebPlayerEvent[] $values() {
        return 36;
    }

    static <clinit>() {
        new WebPlayerEvent("PAGE_STARTED", 0);
        PAGE_STARTED = new WebPlayerEvent(..);
        new WebPlayerEvent("PAGE_FINISHED", 1);
        PAGE_FINISHED = new WebPlayerEvent(..);
        new WebPlayerEvent("ERROR", 2);
        ERROR = new WebPlayerEvent(..);
        new WebPlayerEvent("HTTP_ERROR", 3);
        HTTP_ERROR = new WebPlayerEvent(..);
        new WebPlayerEvent("PERMISSION_REQUEST", 4);
        PERMISSION_REQUEST = new WebPlayerEvent(..);
        new WebPlayerEvent("LOAD_RESOUCE", 5);
        LOAD_RESOUCE = new WebPlayerEvent(..);
        new WebPlayerEvent("SSL_ERROR", 6);
        SSL_ERROR = new WebPlayerEvent(..);
        new WebPlayerEvent("CLIENT_CERT_REQUEST", 7);
        CLIENT_CERT_REQUEST = new WebPlayerEvent(..);
        new WebPlayerEvent("HTTP_AUTH_REQUEST", 8);
        HTTP_AUTH_REQUEST = new WebPlayerEvent(..);
        new WebPlayerEvent("SCALE_CHANGED", 9);
        SCALE_CHANGED = new WebPlayerEvent(..);
        new WebPlayerEvent("LOGIN_REQUEST", 10);
        LOGIN_REQUEST = new WebPlayerEvent(..);
        new WebPlayerEvent("PROGRESS_CHANGED", 11);
        PROGRESS_CHANGED = new WebPlayerEvent(..);
        new WebPlayerEvent("RECEIVED_TITLE", 12);
        RECEIVED_TITLE = new WebPlayerEvent(..);
        new WebPlayerEvent("RECEIVED_ICON", 13);
        RECEIVED_ICON = new WebPlayerEvent(..);
        new WebPlayerEvent("RECEIVED_TOUCH_ICON_URL", 14);
        RECEIVED_TOUCH_ICON_URL = new WebPlayerEvent(..);
        new WebPlayerEvent("SHOW_CUSTOM_VIEW", 15);
        SHOW_CUSTOM_VIEW = new WebPlayerEvent(..);
        new WebPlayerEvent("HIDE_CUSTOM_VIEW", 16);
        HIDE_CUSTOM_VIEW = new WebPlayerEvent(..);
        new WebPlayerEvent("CREATE_WINDOW", 17);
        CREATE_WINDOW = new WebPlayerEvent(..);
        new WebPlayerEvent("CLOSE_WINDOW", 18);
        CLOSE_WINDOW = new WebPlayerEvent(..);
        new WebPlayerEvent("REQUEST_FOCUS", 19);
        REQUEST_FOCUS = new WebPlayerEvent(..);
        new WebPlayerEvent("JS_ALERT", 20);
        JS_ALERT = new WebPlayerEvent(..);
        new WebPlayerEvent("JS_CONFIRM", 21);
        JS_CONFIRM = new WebPlayerEvent(..);
        new WebPlayerEvent("JS_PROMPT", 22);
        JS_PROMPT = new WebPlayerEvent(..);
        new WebPlayerEvent("CONSOLE_MESSAGE", 23);
        CONSOLE_MESSAGE = new WebPlayerEvent(..);
        new WebPlayerEvent("SHOW_FILE_CHOOSER", 24);
        SHOW_FILE_CHOOSER = new WebPlayerEvent(..);
        new WebPlayerEvent("GEOLOCATION_PERMISSIONS_SHOW", 25);
        GEOLOCATION_PERMISSIONS_SHOW = new WebPlayerEvent(..);
        new WebPlayerEvent("DOWNLOAD_START", 26);
        DOWNLOAD_START = new WebPlayerEvent(..);
        new WebPlayerEvent("SHOULD_OVERRIDE_URL_LOADING", 27);
        SHOULD_OVERRIDE_URL_LOADING = new WebPlayerEvent(..);
        new WebPlayerEvent("SHOULD_OVERRIDE_KEY_EVENT", 28);
        SHOULD_OVERRIDE_KEY_EVENT = new WebPlayerEvent(..);
        new WebPlayerEvent("PAGE_COMMIT_VISIBLE", 29);
        PAGE_COMMIT_VISIBLE = new WebPlayerEvent(..);
        new WebPlayerEvent("FORM_RESUBMISSION", 30);
        FORM_RESUBMISSION = new WebPlayerEvent(..);
        new WebPlayerEvent("UNHANDLED_KEY_EVENT", 31);
        UNHANDLED_KEY_EVENT = new WebPlayerEvent(..);
        new WebPlayerEvent("WEBPLAYER_EVENT", 32);
        WEBPLAYER_EVENT = new WebPlayerEvent(..);
        new WebPlayerEvent("SHOULD_INTERCEPT_REQUEST", 33);
        SHOULD_INTERCEPT_REQUEST = new WebPlayerEvent(..);
        new WebPlayerEvent("FRAME_UPDATE", 34);
        FRAME_UPDATE = new WebPlayerEvent(..);
        new WebPlayerEvent("GET_FRAME_RESPONSE", 35);
        GET_FRAME_RESPONSE = new WebPlayerEvent(..);
        WebPlayerEvent.$values();
        $VALUES = WebPlayerEvent.$values(..);
        return;
    }

    private WebPlayerEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static WebPlayerEvent valueOf(String p0) {
        Enum.valueOf(WebPlayerEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static WebPlayerEvent[] values() {
        WebPlayerEvent.$VALUES.clone();
        return WebPlayerEvent[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.webplayer.WebPlayerEventBridge
// ============================================================
package com.unity3d.services.ads.webplayer;

public class WebPlayerEventBridge {
    public WebPlayerEventBridge() {
        new Object();
        return;
    }

    public static void error(String p0, String p1, String p2) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_19;
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.ERROR, 3);
      L_19:
        return;
    }

    public static void sendFrameUpdate(String p0, int p1, int p2, int p3, int p4, float p5) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_36;
        Integer.valueOf(p1);
        Integer.valueOf(p2);
        Integer.valueOf(p3);
        Integer.valueOf(p4);
        Float.valueOf(p5);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.FRAME_UPDATE, 6);
      L_36:
        return;
    }

    public static void sendGetFrameResponse(String p0, String p1, int p2, int p3, int p4, int p5, float p6) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_39;
        Integer.valueOf(p2);
        Integer.valueOf(p3);
        Integer.valueOf(p4);
        Integer.valueOf(p5);
        Float.valueOf(p6);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.GET_FRAME_RESPONSE, 7);
      L_39:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.webplayer.WebPlayerSettingsCache
// ============================================================
package com.unity3d.services.ads.webplayer;

public class WebPlayerSettingsCache {
    private static WebPlayerSettingsCache instance;
    private HashMap _webPlayerEventSettings;
    private HashMap _webPlayerSettings;
    private HashMap _webSettings;

    public WebPlayerSettingsCache() {
        new Object();
        new HashMap();
        _webSettings = new HashMap(..);
        new HashMap();
        _webPlayerSettings = new HashMap(..);
        new HashMap();
        _webPlayerEventSettings = new HashMap(..);
        return;
    }

    public static WebPlayerSettingsCache getInstance() {
        if (if-nez(WebPlayerSettingsCache.instance)) goto L_b;
        new WebPlayerSettingsCache();
        instance = new WebPlayerSettingsCache(..);
      L_b:
        return WebPlayerSettingsCache.instance;
    }

    public void addWebPlayerEventSettings(String p0, JSONObject p1) {
        _webPlayerEventSettings.put(p0, p1);
        return;
        throw p0;
    }

    public void addWebPlayerSettings(String p0, JSONObject p1) {
        _webPlayerSettings.put(p0, p1);
        return;
        throw p0;
    }

    public void addWebSettings(String p0, JSONObject p1) {
        _webSettings.put(p0, p1);
        return;
        throw p0;
    }

    public JSONObject getWebPlayerEventSettings(String p0) {
        _webPlayerEventSettings.containsKey(p0);
        if (if-eqz(HashMap.containsKey(..))) goto L_13;
        _webPlayerEventSettings.get(p0);
        return HashMap.get(..);
      L_13:
        new JSONObject();
        return new JSONObject(..);
        throw new JSONObject(..);
    }

    public JSONObject getWebPlayerSettings(String p0) {
        _webPlayerSettings.containsKey(p0);
        if (if-eqz(HashMap.containsKey(..))) goto L_13;
        _webPlayerSettings.get(p0);
        return HashMap.get(..);
      L_13:
        new JSONObject();
        return new JSONObject(..);
        throw new JSONObject(..);
    }

    public JSONObject getWebSettings(String p0) {
        _webSettings.containsKey(p0);
        if (if-eqz(HashMap.containsKey(..))) goto L_13;
        _webSettings.get(p0);
        return HashMap.get(..);
      L_13:
        new JSONObject();
        return new JSONObject(..);
        throw new JSONObject(..);
    }

    public void removeWebPlayerEventSettings(String p0) {
        _webPlayerEventSettings.containsKey(p0);
        if (if-eqz(HashMap.containsKey(..))) goto L_e;
        _webPlayerEventSettings.remove(p0);
      L_e:
        return;
        throw p0;
    }

    public void removeWebPlayerSettings(String p0) {
        _webPlayerSettings.containsKey(p0);
        if (if-eqz(HashMap.containsKey(..))) goto L_e;
        _webPlayerSettings.remove(p0);
      L_e:
        return;
        throw p0;
    }

    public void removeWebSettings(String p0) {
        _webSettings.containsKey(p0);
        if (if-eqz(HashMap.containsKey(..))) goto L_e;
        _webSettings.remove(p0);
      L_e:
        return;
        throw p0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.webplayer.WebPlayerView
// ============================================================
package com.unity3d.services.ads.webplayer;

public class WebPlayerView extends WebView {
    private Map _erroredSettings;
    private Method _evaluateJavascript;
    private JSONObject _eventSettings;
    private Runnable _unsubscribeLayoutChange;
    private String viewId;

    public WebPlayerView(Context p0, String p1, JSONObject p2, JSONObject p3) {
        new WebView(p0);
        _evaluateJavascript = 0;
        _unsubscribeLayoutChange = 0;
        viewId = p1;
        new WebView(..).getSettings();
        WebPlayerView.getSettings(..).setAllowFileAccessFromFileURLs(0);
        WebPlayerView.getSettings(..).setAllowUniversalAccessFromFileURLs(0);
        WebView.class.getMethod("evaluateJavascript", v6);
        _evaluateJavascript = Class.getMethod(..);
        DeviceLog.exception("Method evaluateJavascript not found", Class.getMethod(..));
        _evaluateJavascript = 0;
      L_34:
        WebPlayerView.getSettings(..).setCacheMode(2);
        WebPlayerView.getSettings(..).setDatabaseEnabled(0);
        WebPlayerView.getSettings(..).setDomStorageEnabled(0);
        WebPlayerView.getSettings(..).setGeolocationEnabled(0);
        WebPlayerView.getSettings(..).setJavaScriptEnabled(1);
        WebPlayerView.getSettings(..).setLoadsImagesAutomatically(1);
        WebPlayerView.getSettings(..).setPluginState(WebSettings$PluginState.OFF);
        WebPlayerView.getSettings(..).setRenderPriority(WebSettings$RenderPriority.NORMAL);
        WebPlayerView.getSettings(..).setSaveFormData(0);
        WebPlayerView.getSettings(..).setSavePassword(0);
        new WebView(..).setHorizontalScrollBarEnabled(0);
        new WebView(..).setVerticalScrollBarEnabled(0);
        new WebView(..).setInitialScale(0);
        new WebView(..).setBackgroundColor(0);
        new ColorDrawable(0);
        ViewUtilities.setBackground(new WebView(..), new ColorDrawable(..));
        new WebView(..).setBackgroundResource(0);
        new WebView(..).setSettings(p2, p3);
        new WebPlayerView$WebPlayerClient(new WebView(..), 0);
        new WebView(..).setWebViewClient(new WebPlayerView$WebPlayerClient(..));
        new WebPlayerView$WebPlayerChromeClient(new WebView(..), 0);
        new WebView(..).setWebChromeClient(new WebPlayerView$WebPlayerChromeClient(..));
        new WebPlayerView$WebPlayerDownloadListener(new WebView(..), 0);
        new WebView(..).setDownloadListener(new WebPlayerView$WebPlayerDownloadListener(..));
        new WebPlayerBridgeInterface(p1);
        new WebView(..).addJavascriptInterface(new WebPlayerBridgeInterface(..), "webplayerbridge");
        WebPlayerViewCache.getInstance();
        WebPlayerViewCache.getInstance(..).addWebPlayer(p1, new WebView(..));
        new WebView(..).subscribeOnLayoutChange();
        return;
    }

    static Method access$300(WebPlayerView p0) {
        return _evaluateJavascript;
    }

    static String access$400(WebPlayerView p0) {
        return viewId;
    }

    static boolean access$500(WebPlayerView p0, String p1) {
        p0.shouldCallSuper(p1);
        return WebPlayerView.shouldCallSuper(..);
    }

    static boolean access$600(WebPlayerView p0, String p1) {
        p0.shouldSendEvent(p1);
        return WebPlayerView.shouldSendEvent(..);
    }

    static boolean access$700(WebPlayerView p0, String p1) {
        p0.hasReturnValue(p1);
        return WebPlayerView.hasReturnValue(..);
    }

    static Object access$800(WebPlayerView p0, String p1, Class p2, Object p3) {
        p0.getReturnValue(p1, p2, p3);
        return WebPlayerView.getReturnValue(..);
    }

    private void addErroredSetting(String p0, String p1) {
        if (if-nez(_erroredSettings)) goto L_b;
        new HashMap();
        _erroredSettings = new HashMap(..);
      L_b:
        _erroredSettings.put(p0, p1);
        return;
    }

    private Object getReturnValue(String p0, Class p1, Object p2) {
        if (if-eqz(_eventSettings)) goto L_2d;
        _eventSettings.has(p0);
        if (if-eqz(JSONObject.has(..))) goto L_2d;
        _eventSettings.getJSONObject(p0);
        JSONObject.getJSONObject(..).has("returnValue");
        if (if-eqz(JSONObject.has(..))) goto L_2d;
        _eventSettings.getJSONObject(p0);
        JSONObject.getJSONObject(..).get("returnValue");
        p1.cast(JSONObject.get(..));
        return Class.cast(..);
        DeviceLog.exception("Error getting default return value", Class.cast(..));
      L_2d:
        return p2;
    }

    private Class[] getTypes(JSONArray p0) {
        if (if-nez(p0)) goto L_4;
        return 0;
      L_4:
        0.length();
        if (if-eqz(0)) goto L_41;
      L_d:
        0.length();
        if (if-ge(0, JSONArray.length(..))) goto L_41;
        0.get(0);
        if (if-eqz(JSONArray.get(..))) goto L_30;
        0.get(0);
        JSONArray.get(..).getString("className");
        Class.forName(JSONObject.getString(..));
        if (if-eqz(Class.forName(..))) goto L_3e;
      L_30:
        0.get(0);
        JSONArray.get(..).getClass();
        WebPlayerView.getPrimitiveClass(Object.getClass(..));
      L_3e:
      L_41:
        return JSONArray.length(..);
    }

    private Object[] getValues(JSONArray p0) {
        if (if-nez(p0)) goto L_4;
        return 0;
      L_4:
        p0.length();
        p0.length();
      L_12:
        p0.length();
        if (if-ge(0, JSONArray.length(..))) goto L_62;
        p0.get(0);
        if (if-eqz(JSONArray.get(..))) goto L_59;
        p0.get(0);
        JSONArray.get(..).get("value");
        JSONArray.get(..).getString("type");
        JSONArray.get(..).has("className");
        if (if-eqz(JSONObject.has(..))) goto L_3f;
        JSONArray.get(..).getString("className");
      L_3f:
      L_40:
        if (if-eqz(0)) goto L_5f;
        JSONObject.getString(..).equals("Enum");
        if (if-eqz(String.equals(..))) goto L_5f;
        Class.forName(0);
        if (if-eqz(Class.forName(..))) goto L_5f;
        Enum.valueOf(Class.forName(..), JSONObject.get(..));
      L_59:
        p0.get(0);
      L_5f:
      L_62:
        if (if-eqz(p0)) goto L_6b;
        p0.length();
        System.arraycopy(JSONArray.length(..), 0, JSONArray.length(..), 0, JSONArray.length(..));
      L_6b:
        return JSONArray.length(..);
    }

    private boolean hasReturnValue(String p0) {
        if (if-eqz(_eventSettings)) goto L_20;
        _eventSettings.has(p0);
        if (if-eqz(JSONObject.has(..))) goto L_20;
        _eventSettings.getJSONObject(p0);
        JSONObject.getJSONObject(..).has("returnValue");
        if (if-eqz(JSONObject.has(..))) goto L_20;
        return 1;
        DeviceLog.exception("Error getting default return value", 1);
      L_20:
        return 0;
    }

    private Object setTargetSettings(Object p0, JSONObject p1) {
        if (if-eqz(p1)) goto L_38;
        p1.keys();
      L_6:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_38;
        JSONObject.keys(..).next();
        p1.getJSONArray(Iterator.next(..));
        WebPlayerView.getTypes(JSONObject.getJSONArray(..));
        p0.getClass();
        Object.getClass(..).getMethod(Iterator.next(..), WebPlayerView.getTypes(..));
        WebPlayerView.getValues(JSONObject.getJSONArray(..));
        Class.getMethod(..).invoke(p0, WebPlayerView.getValues(..));
        WebPlayerView.getValues(..).getMessage();
        WebPlayerView.addErroredSetting(Iterator.next(..), Exception.getMessage(..));
        DeviceLog.exception("Setting errored", WebPlayerView.getValues(..));
      L_38:
        return p0;
    }

    private boolean shouldCallSuper(String p0) {
        if (if-eqz(_eventSettings)) goto L_29;
        _eventSettings.has(p0);
        if (if-eqz(JSONObject.has(..))) goto L_29;
        _eventSettings.getJSONObject(p0);
        JSONObject.getJSONObject(..).has("callSuper");
        if (if-eqz(JSONObject.has(..))) goto L_29;
        _eventSettings.getJSONObject(p0);
        JSONObject.getJSONObject(..).getBoolean("callSuper");
        return JSONObject.getBoolean(..);
        DeviceLog.exception("Error getting super call status", JSONObject.getBoolean(..));
      L_29:
        return 1;
    }

    private boolean shouldSendEvent(String p0) {
        if (if-eqz(_eventSettings)) goto L_29;
        _eventSettings.has(p0);
        if (if-eqz(JSONObject.has(..))) goto L_29;
        _eventSettings.getJSONObject(p0);
        JSONObject.getJSONObject(..).has("sendEvent");
        if (if-eqz(JSONObject.has(..))) goto L_29;
        _eventSettings.getJSONObject(p0);
        JSONObject.getJSONObject(..).getBoolean("sendEvent");
        return JSONObject.getBoolean(..);
        DeviceLog.exception("Error getting send event status", JSONObject.getBoolean(..));
      L_29:
        return 0;
    }

    private void subscribeOnLayoutChange() {
        if (if-eqz(_unsubscribeLayoutChange)) goto L_7;
        _unsubscribeLayoutChange.run();
      L_7:
        new WebPlayerView$1(this);
        WebPlayerView.addOnLayoutChangeListener(new WebPlayerView$1(..));
        new WebPlayerView$2(this, new WebPlayerView$1(..));
        _unsubscribeLayoutChange = new WebPlayerView$2(..);
        return;
    }

    public void destroy() {
        WebView.destroy();
        WebPlayerViewCache.getInstance();
        WebPlayerViewCache.getInstance(..).removeWebPlayer(viewId);
        if (if-eqz(_unsubscribeLayoutChange)) goto L_13;
        _unsubscribeLayoutChange.run();
      L_13:
        return;
    }

    public Map getErroredSettings() {
        return _erroredSettings;
    }

    public Class getPrimitiveClass(Class p0) {
        p0.getName();
        Class.getName(..).equals("java.lang.Byte");
        if (if-eqz(String.equals(..))) goto L_f;
        return Byte.TYPE;
      L_f:
        Class.getName(..).equals("java.lang.Short");
        if (if-eqz(String.equals(..))) goto L_1a;
        return Short.TYPE;
      L_1a:
        Class.getName(..).equals("java.lang.Integer");
        if (if-eqz(String.equals(..))) goto L_25;
        return Integer.TYPE;
      L_25:
        Class.getName(..).equals("java.lang.Long");
        if (if-eqz(String.equals(..))) goto L_30;
        return Long.TYPE;
      L_30:
        Class.getName(..).equals("java.lang.Character");
        if (if-eqz(String.equals(..))) goto L_3b;
        return Character.TYPE;
      L_3b:
        Class.getName(..).equals("java.lang.Float");
        if (if-eqz(String.equals(..))) goto L_46;
        return Float.TYPE;
      L_46:
        Class.getName(..).equals("java.lang.Double");
        if (if-eqz(String.equals(..))) goto L_51;
        return Double.TYPE;
      L_51:
        Class.getName(..).equals("java.lang.Boolean");
        if (if-eqz(String.equals(..))) goto L_5c;
        return Boolean.TYPE;
      L_5c:
        Class.getName(..).equals("java.lang.Void");
        if (if-eqz(String.equals(..))) goto L_66;
      L_66:
        return Void.TYPE;
    }

    public void invokeJavascript(String p0) {
        new WebPlayerView$JavaScriptInvocation(this, p0, this);
        Utilities.runOnUiThread(new WebPlayerView$JavaScriptInvocation(..));
        return;
    }

    public void onLayoutChange() {
        WebPlayerView.getLocationOnScreen(2);
        WebPlayerView.getWidth();
        WebPlayerView.getHeight();
        WebPlayerView.getAlpha();
        WebPlayerEventBridge.sendFrameUpdate(viewId, v3, v4, WebPlayerView.getWidth(..), WebPlayerView.getHeight(..), WebPlayerView.getAlpha(..));
        return;
    }

    protected void onSizeChanged(int p0, int p1, int p2, int p3) {
        WebView.onSizeChanged(p0, p1, p2, p3);
        WebPlayerView.onLayoutChange();
        return;
    }

    public void sendEvent(JSONArray p0) {
        new StringBuilder("javascript:window.nativebridge.receiveEvent(");
        p0.toString();
        new StringBuilder(..).append(JSONArray.toString(..));
        new StringBuilder(..).append(")");
        new StringBuilder(..).toString();
        WebPlayerView.invokeJavascript(StringBuilder.toString(..));
        return;
    }

    public void setEventSettings(JSONObject p0) {
        _eventSettings = p0;
        return;
    }

    public void setSettings(JSONObject p0, JSONObject p1) {
        if (if-eqz(_erroredSettings)) goto L_7;
        _erroredSettings.clear();
      L_7:
        WebPlayerView.getSettings();
        WebPlayerView.setTargetSettings(WebPlayerView.getSettings(..), p0);
        WebPlayerView.setTargetSettings(this, p1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.webplayer.WebPlayerViewCache
// ============================================================
package com.unity3d.services.ads.webplayer;

public class WebPlayerViewCache {
    private static WebPlayerViewCache instance;
    private HashMap _webPlayerMap;

    public WebPlayerViewCache() {
        new Object();
        new HashMap();
        _webPlayerMap = new HashMap(..);
        return;
    }

    public static WebPlayerViewCache getInstance() {
        if (if-nez(WebPlayerViewCache.instance)) goto L_b;
        new WebPlayerViewCache();
        instance = new WebPlayerViewCache(..);
      L_b:
        return WebPlayerViewCache.instance;
    }

    public void addWebPlayer(String p0, WebPlayerView p1) {
        _webPlayerMap.put(p0, p1);
        return;
        throw p0;
    }

    public WebPlayerView getWebPlayer(String p0) {
        _webPlayerMap.containsKey(p0);
        if (if-eqz(HashMap.containsKey(..))) goto L_13;
        _webPlayerMap.get(p0);
        return HashMap.get(..);
      L_13:
        return 0;
        throw 0;
    }

    public void removeWebPlayer(String p0) {
        _webPlayerMap.containsKey(p0);
        if (if-eqz(HashMap.containsKey(..))) goto L_e;
        _webPlayerMap.remove(p0);
      L_e:
        return;
        throw p0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.webplayer.WebPlayerView$1
// ============================================================
package com.unity3d.services.ads.webplayer;

class WebPlayerView$1 {
    final WebPlayerView this$0;

    WebPlayerView$1(WebPlayerView p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void onLayoutChange(View p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
        this$0.onLayoutChange();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.webplayer.WebPlayerView$2
// ============================================================
package com.unity3d.services.ads.webplayer;

class WebPlayerView$2 {
    final WebPlayerView this$0;
    final View$OnLayoutChangeListener val$onLayoutChangeListener;

    WebPlayerView$2(WebPlayerView p0, View$OnLayoutChangeListener p1) {
        this$0 = p0;
        val$onLayoutChangeListener = p1;
        new Object();
        return;
    }

    public void run() {
        this$0.removeOnLayoutChangeListener(val$onLayoutChangeListener);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.webplayer.WebPlayerView$JavaScriptInvocation
// ============================================================
package com.unity3d.services.ads.webplayer;

class WebPlayerView$JavaScriptInvocation {
    private String _jsString;
    private WebView _webView;
    final WebPlayerView this$0;

    public WebPlayerView$JavaScriptInvocation(WebPlayerView p0, String p1, WebView p2) {
        this$0 = p0;
        new Object();
        _jsString = p1;
        _webView = p2;
        return;
    }

    public void run() {
        if (if-eqz(_jsString)) goto L_23;
        WebPlayerView.access$300(this$0);
        WebPlayerView.access$300(..).invoke(_webView, 2);
        DeviceLog.exception("Error while processing JavaScriptString", WebPlayerView.access$300(..));
      L_23:
        DeviceLog.error("Could not process JavaScript, the string is NULL");
      L_28:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.webplayer.WebPlayerView$WebPlayerChromeClient
// ============================================================
package com.unity3d.services.ads.webplayer;

class WebPlayerView$WebPlayerChromeClient extends WebChromeClient {
    final WebPlayerView this$0;

    private WebPlayerView$WebPlayerChromeClient(WebPlayerView p0) {
        this$0 = p0;
        new WebChromeClient();
        return;
    }

    WebPlayerView$WebPlayerChromeClient(WebPlayerView p0, WebPlayerView$1 p1) {
        new WebPlayerView$WebPlayerChromeClient(p0);
        return;
    }

    public void onCloseWindow(WebView p0) {
        WebPlayerView.access$500(this$0, "onCloseWindow");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebChromeClient.onCloseWindow(p0);
      L_d:
        WebPlayerView.access$600(this$0, "onCloseWindow");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_2c;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CLOSE_WINDOW, 1);
      L_2c:
        return;
    }

    public boolean onConsoleMessage(ConsoleMessage p0) {
        Boolean.valueOf(0);
        WebPlayerView.access$500(this$0, "onConsoleMessage");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_17;
        WebChromeClient.onConsoleMessage(p0);
        Boolean.valueOf(WebChromeClient.onConsoleMessage(..));
      L_17:
        WebPlayerView.access$600(this$0, "onConsoleMessage");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_41;
        if (if-eqz(p0)) goto L_27;
        p0.message();
      L_27:
      L_29:
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CONSOLE_MESSAGE, 2);
      L_41:
        WebPlayerView.access$700(this$0, "onConsoleMessage");
        if (if-eqz(WebPlayerView.access$700(..))) goto L_58;
        Boolean.valueOf(1);
        WebPlayerView.access$800(this$0, "onConsoleMessage", Boolean.class, Boolean.valueOf(..));
      L_58:
        WebPlayerView.access$800(..).booleanValue();
        return Boolean.booleanValue(..);
    }

    public boolean onCreateWindow(WebView p0, boolean p1, boolean p2, Message p3) {
        Boolean.valueOf(0);
        WebPlayerView.access$500(this$0, "onCreateWindow");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_18;
        WebChromeClient.onCreateWindow(p0, p1, p2, p3);
        Boolean.valueOf(WebChromeClient.onCreateWindow(..));
      L_18:
      L_19:
        WebPlayerView.access$600(this$0, "onCreateWindow");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_48;
        WebViewApp.getCurrentApp();
        Boolean.valueOf(p1);
        Boolean.valueOf(p2);
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CREATE_WINDOW, 4);
      L_48:
        WebPlayerView.access$700(this$0, "onCreateWindow");
        if (if-eqz(WebPlayerView.access$700(..))) goto L_5a;
        WebPlayerView.access$800(this$0, "onCreateWindow", Boolean.class, Boolean.valueOf(..));
      L_5a:
        WebPlayerView.access$800(..).booleanValue();
        return Boolean.booleanValue(..);
    }

    public void onGeolocationPermissionsShowPrompt(String p0, GeolocationPermissions$Callback p1) {
        WebPlayerView.access$500(this$0, "onGeolocationPermissionsShowPrompt");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebChromeClient.onGeolocationPermissionsShowPrompt(p0, p1);
      L_d:
        WebPlayerView.access$600(this$0, "onGeolocationPermissionsShowPrompt");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_2f;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.GEOLOCATION_PERMISSIONS_SHOW, 2);
      L_2f:
        return;
    }

    public void onHideCustomView() {
        WebPlayerView.access$500(this$0, "onHideCustomView");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebChromeClient.onHideCustomView();
      L_d:
        WebPlayerView.access$600(this$0, "onHideCustomView");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_2c;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.HIDE_CUSTOM_VIEW, 1);
      L_2c:
        return;
    }

    public boolean onJsAlert(WebView p0, String p1, String p2, JsResult p3) {
        Boolean.valueOf(0);
        WebPlayerView.access$500(this$0, "onJsAlert");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_17;
        WebChromeClient.onJsAlert(p0, p1, p2, p3);
        Boolean.valueOf(WebChromeClient.onJsAlert(..));
      L_17:
        WebPlayerView.access$600(this$0, "onJsAlert");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_3e;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.JS_ALERT, 4);
      L_3e:
        WebPlayerView.access$700(this$0, "onJsAlert");
        if (if-eqz(WebPlayerView.access$700(..))) goto L_55;
        Boolean.valueOf(1);
        WebPlayerView.access$800(this$0, "onJsAlert", Boolean.class, Boolean.valueOf(..));
      L_55:
        WebPlayerView.access$800(..).booleanValue();
        return Boolean.booleanValue(..);
    }

    public boolean onJsConfirm(WebView p0, String p1, String p2, JsResult p3) {
        Boolean.valueOf(0);
        WebPlayerView.access$500(this$0, "onJsConfirm");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_17;
        WebChromeClient.onJsConfirm(p0, p1, p2, p3);
        Boolean.valueOf(WebChromeClient.onJsConfirm(..));
      L_17:
        WebPlayerView.access$600(this$0, "onJsConfirm");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_3b;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.JS_CONFIRM, 3);
      L_3b:
        WebPlayerView.access$700(this$0, "onJsConfirm");
        if (if-eqz(WebPlayerView.access$700(..))) goto L_52;
        Boolean.valueOf(1);
        WebPlayerView.access$800(this$0, "onJsConfirm", Boolean.class, Boolean.valueOf(..));
      L_52:
        WebPlayerView.access$800(..).booleanValue();
        return Boolean.booleanValue(..);
    }

    public boolean onJsPrompt(WebView p0, String p1, String p2, String p3, JsPromptResult p4) {
        Boolean.valueOf(0);
        WebPlayerView.access$500(this$0, "onJsPrompt");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_17;
        WebChromeClient.onJsPrompt(p0, p1, p2, p3, p4);
        Boolean.valueOf(WebChromeClient.onJsPrompt(..));
      L_17:
        WebPlayerView.access$600(this$0, "onJsPrompt");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_3e;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.JS_PROMPT, 4);
      L_3e:
        WebPlayerView.access$700(this$0, "onJsPrompt");
        if (if-eqz(WebPlayerView.access$700(..))) goto L_55;
        Boolean.valueOf(1);
        WebPlayerView.access$800(this$0, "onJsPrompt", Boolean.class, Boolean.valueOf(..));
      L_55:
        WebPlayerView.access$800(..).booleanValue();
        return Boolean.booleanValue(..);
    }

    public void onPermissionRequest(PermissionRequest p0) {
        WebPlayerView.access$500(this$0, "onPermissionRequest");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebChromeClient.onPermissionRequest(p0);
      L_d:
        WebPlayerView.access$600(this$0, "onPermissionRequest");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_42;
        if (if-eqz(p0)) goto L_26;
        p0.getOrigin();
        if (if-eqz(PermissionRequest.getOrigin(..))) goto L_26;
        p0.getOrigin();
        PermissionRequest.getOrigin(..).toString();
      L_26:
      L_28:
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PERMISSION_REQUEST, 2);
      L_42:
        return;
    }

    public void onProgressChanged(WebView p0, int p1) {
        WebPlayerView.access$500(this$0, "onProgressChanged");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebChromeClient.onProgressChanged(p0, p1);
      L_d:
        WebPlayerView.access$600(this$0, "onProgressChanged");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_33;
        WebViewApp.getCurrentApp();
        Integer.valueOf(p1);
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PROGRESS_CHANGED, 2);
      L_33:
        return;
    }

    public void onReceivedIcon(WebView p0, Bitmap p1) {
        WebPlayerView.access$500(this$0, "onReceivedIcon");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebChromeClient.onReceivedIcon(p0, p1);
      L_d:
        WebPlayerView.access$600(this$0, "onReceivedIcon");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_2c;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_ICON, 1);
      L_2c:
        return;
    }

    public void onReceivedTitle(WebView p0, String p1) {
        WebPlayerView.access$500(this$0, "onReceivedTitle");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebChromeClient.onReceivedTitle(p0, p1);
      L_d:
        WebPlayerView.access$600(this$0, "onReceivedTitle");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_2f;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_TITLE, 2);
      L_2f:
        return;
    }

    public void onReceivedTouchIconUrl(WebView p0, String p1, boolean p2) {
        WebPlayerView.access$500(this$0, "onReceivedTouchIconUrl");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebChromeClient.onReceivedTouchIconUrl(p0, p1, p2);
      L_d:
        WebPlayerView.access$600(this$0, "onReceivedTouchIconUrl");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_36;
        WebViewApp.getCurrentApp();
        Boolean.valueOf(p2);
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_TOUCH_ICON_URL, 3);
      L_36:
        return;
    }

    public void onRequestFocus(WebView p0) {
        WebPlayerView.access$500(this$0, "onRequestFocus");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebChromeClient.onRequestFocus(p0);
      L_d:
        WebPlayerView.access$600(this$0, "onRequestFocus");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_2c;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.REQUEST_FOCUS, 1);
      L_2c:
        return;
    }

    public void onShowCustomView(View p0, WebChromeClient$CustomViewCallback p1) {
        WebPlayerView.access$500(this$0, "onShowCustomView");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebChromeClient.onShowCustomView(p0, p1);
      L_d:
        WebPlayerView.access$600(this$0, "onShowCustomView");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_2c;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOW_CUSTOM_VIEW, 1);
      L_2c:
        return;
    }

    public boolean onShowFileChooser(WebView p0, ValueCallback p1, WebChromeClient$FileChooserParams p2) {
        Boolean.valueOf(0);
        WebPlayerView.access$500(this$0, "onShowFileChooser");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_17;
        WebChromeClient.onShowFileChooser(p0, p1, p2);
        Boolean.valueOf(WebChromeClient.onShowFileChooser(..));
      L_17:
        WebPlayerView.access$600(this$0, "onShowFileChooser");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_35;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOW_FILE_CHOOSER, v5);
      L_35:
        WebPlayerView.access$700(this$0, "onShowFileChooser");
        if (if-eqz(WebPlayerView.access$700(..))) goto L_56;
        Boolean.valueOf(1);
        WebPlayerView.access$800(this$0, "onShowFileChooser", Boolean.class, Boolean.valueOf(..));
        WebPlayerView.access$800(..).booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_56;
        p1.onReceiveValue(0);
      L_56:
        WebPlayerView.access$800(..).booleanValue();
        return Boolean.booleanValue(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.webplayer.WebPlayerView$WebPlayerClient
// ============================================================
package com.unity3d.services.ads.webplayer;

class WebPlayerView$WebPlayerClient extends WebViewClient {
    final WebPlayerView this$0;

    private WebPlayerView$WebPlayerClient(WebPlayerView p0) {
        this$0 = p0;
        new WebViewClient();
        return;
    }

    WebPlayerView$WebPlayerClient(WebPlayerView p0, WebPlayerView$1 p1) {
        new WebPlayerView$WebPlayerClient(p0);
        return;
    }

    public void onFormResubmission(WebView p0, Message p1, Message p2) {
        WebPlayerView.access$500(this$0, "onFormResubmission");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebViewClient.onFormResubmission(p0, p1, p2);
      L_d:
        WebPlayerView.access$600(this$0, "onFormResubmission");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_2c;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.FORM_RESUBMISSION, 1);
      L_2c:
        return;
    }

    public void onLoadResource(WebView p0, String p1) {
        WebPlayerView.access$500(this$0, "onLoadResource");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebViewClient.onLoadResource(p0, p1);
      L_d:
        WebPlayerView.access$600(this$0, "onLoadResource");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_2f;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.LOAD_RESOUCE, 2);
      L_2f:
        return;
    }

    public void onPageCommitVisible(WebView p0, String p1) {
        WebPlayerView.access$500(this$0, "onPageCommitVisible");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebViewClient.onPageCommitVisible(p0, p1);
      L_d:
        WebPlayerView.access$600(this$0, "onPageCommitVisible");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_2f;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PAGE_COMMIT_VISIBLE, 2);
      L_2f:
        return;
    }

    public void onPageFinished(WebView p0, String p1) {
        WebPlayerView.access$500(this$0, "onPageFinished");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebViewClient.onPageFinished(p0, p1);
      L_d:
        WebPlayerView.access$600(this$0, "onPageFinished");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_2f;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PAGE_FINISHED, 2);
      L_2f:
        return;
    }

    public void onPageStarted(WebView p0, String p1, Bitmap p2) {
        WebPlayerView.access$500(this$0, "onPageStarted");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebViewClient.onPageStarted(p0, p1, p2);
      L_d:
        WebPlayerView.access$600(this$0, "onPageStarted");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_2f;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PAGE_STARTED, 2);
      L_2f:
        return;
    }

    public void onReceivedClientCertRequest(WebView p0, ClientCertRequest p1) {
        WebPlayerView.access$500(this$0, "onReceivedClientCertRequest");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebViewClient.onReceivedClientCertRequest(p0, p1);
      L_d:
        WebPlayerView.access$600(this$0, "onReceivedClientCertRequest");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_44;
        if (if-eqz(p1)) goto L_20;
        p1.getHost();
        p1.getPort();
      L_20:
      L_23:
        WebViewApp.getCurrentApp();
        Integer.valueOf(-1);
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CLIENT_CERT_REQUEST, 3);
      L_44:
        return;
    }

    public void onReceivedError(WebView p0, int p1, String p2, String p3) {
        WebPlayerView.access$500(this$0, "onReceivedError");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebViewClient.onReceivedError(p0, p1, p2, p3);
      L_d:
        WebPlayerView.access$600(this$0, "onReceivedError");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_1e;
        WebPlayerView.access$400(this$0);
        WebPlayerEventBridge.error(WebPlayerView.access$400(..), p3, p2);
      L_1e:
        return;
    }

    public void onReceivedError(WebView p0, WebResourceRequest p1, WebResourceError p2) {
        WebPlayerView.access$500(this$0, "onReceivedError");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebViewClient.onReceivedError(p0, p1, p2);
      L_d:
        WebPlayerView.access$600(this$0, "onReceivedError");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_42;
        if (if-eqz(p2)) goto L_28;
        p2.getDescription();
        if (if-eqz(WebResourceError.getDescription(..))) goto L_28;
        p2.getDescription();
        WebResourceError.getDescription(..).toString();
      L_28:
      L_29:
        if (if-eqz(p1)) goto L_39;
        p1.getUrl();
        if (if-eqz(WebResourceRequest.getUrl(..))) goto L_39;
        p1.getUrl();
        WebResourceRequest.getUrl(..).toString();
      L_39:
        WebPlayerView.access$400(this$0);
        WebPlayerEventBridge.error(WebPlayerView.access$400(..), Uri.toString(..), "");
      L_42:
        return;
    }

    public void onReceivedHttpAuthRequest(WebView p0, HttpAuthHandler p1, String p2, String p3) {
        WebPlayerView.access$500(this$0, "onReceivedHttpAuthRequest");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebViewClient.onReceivedHttpAuthRequest(p0, p1, p2, p3);
      L_d:
        WebPlayerView.access$600(this$0, "onReceivedHttpAuthRequest");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_32;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.HTTP_AUTH_REQUEST, 3);
      L_32:
        return;
    }

    public void onReceivedHttpError(WebView p0, WebResourceRequest p1, WebResourceResponse p2) {
        WebPlayerView.access$500(this$0, "onReceivedHttpError");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebViewClient.onReceivedHttpError(p0, p1, p2);
      L_d:
        WebPlayerView.access$600(this$0, "onReceivedHttpError");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_5c;
        if (if-eqz(p1)) goto L_28;
        p1.getUrl();
        if (if-eqz(WebResourceRequest.getUrl(..))) goto L_28;
        p1.getUrl();
        WebResourceRequest.getUrl(..).toString();
      L_28:
      L_29:
        if (if-eqz(p2)) goto L_37;
        p2.getStatusCode();
        p2.getReasonPhrase();
      L_37:
      L_38:
        WebViewApp.getCurrentApp();
        Integer.valueOf(-1);
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.HTTP_ERROR, 4);
      L_5c:
        return;
    }

    public void onReceivedLoginRequest(WebView p0, String p1, String p2, String p3) {
        WebPlayerView.access$500(this$0, "onReceivedLoginRequest");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebViewClient.onReceivedLoginRequest(p0, p1, p2, p3);
      L_d:
        WebPlayerView.access$600(this$0, "onReceivedLoginRequest");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_35;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.LOGIN_REQUEST, 4);
      L_35:
        return;
    }

    public void onReceivedSslError(WebView p0, SslErrorHandler p1, SslError p2) {
        WebViewClient.onReceivedSslError(p0, p1, p2);
        if (if-eqz(p2)) goto L_1c;
        p2.getUrl();
        p2.toString();
        DeviceLog.error("Received SSL error for '%s': %s", v1);
      L_1c:
        DeviceLog.error("Received unknown SSL error: SslError was null");
      L_21:
        WebPlayerView.access$600(this$0, "onReceivedSslError");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_4b;
        if (if-eqz(p2)) goto L_32;
        p2.getUrl();
      L_32:
      L_34:
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SSL_ERROR, 2);
      L_4b:
        return;
    }

    public boolean onRenderProcessGone(WebView p0, RenderProcessGoneDetail p1) {
        new WebPlayerView$WebPlayerClient$1(this, p0);
        Utilities.runOnUiThread(new WebPlayerView$WebPlayerClient$1(..));
        WebPlayerView.access$400(this$0);
        this$0.getUrl();
        new StringBuilder("UnityAds Sdk WebPlayer onRenderProcessGone : ");
        p1.toString();
        new StringBuilder(..).append(Object.toString(..));
        new StringBuilder(..).toString();
        WebPlayerEventBridge.error(WebPlayerView.access$400(..), WebPlayerView.getUrl(..), StringBuilder.toString(..));
        new StringBuilder("UnityAds Sdk WebPlayer onRenderProcessGone : ");
        p1.toString();
        new StringBuilder(..).append(Object.toString(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
        return 1;
    }

    public void onScaleChanged(WebView p0, float p1, float p2) {
        WebPlayerView.access$500(this$0, "onScaleChanged");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebViewClient.onScaleChanged(p0, p1, p2);
      L_d:
        WebPlayerView.access$600(this$0, "onScaleChanged");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_3a;
        WebViewApp.getCurrentApp();
        Float.valueOf(p1);
        Float.valueOf(p2);
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SCALE_CHANGED, 3);
      L_3a:
        return;
    }

    public void onUnhandledKeyEvent(WebView p0, KeyEvent p1) {
        WebPlayerView.access$500(this$0, "onUnhandledKeyEvent");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_d;
        WebViewClient.onUnhandledKeyEvent(p0, p1);
      L_d:
        WebPlayerView.access$600(this$0, "onUnhandledKeyEvent");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_42;
        WebViewApp.getCurrentApp();
        p1.getKeyCode();
        Integer.valueOf(KeyEvent.getKeyCode(..));
        p1.getAction();
        Integer.valueOf(KeyEvent.getAction(..));
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.UNHANDLED_KEY_EVENT, 3);
      L_42:
        return;
    }

    public WebResourceResponse shouldInterceptRequest(WebView p0, WebResourceRequest p1) {
        WebPlayerView.access$500(this$0, "shouldInterceptRequest");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_f;
        WebViewClient.shouldInterceptRequest(p0, p1);
      L_f:
      L_10:
        WebPlayerView.access$600(this$0, "shouldInterceptRequest");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_3a;
        WebViewApp.getCurrentApp();
        p1.getUrl();
        WebResourceRequest.getUrl(..).toString();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOULD_INTERCEPT_REQUEST, 2);
      L_3a:
        return 0;
    }

    public boolean shouldOverrideKeyEvent(WebView p0, KeyEvent p1) {
        Boolean.valueOf(0);
        WebPlayerView.access$500(this$0, "shouldOverrideKeyEvent");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_17;
        WebViewClient.shouldOverrideKeyEvent(p0, p1);
        Boolean.valueOf(WebViewClient.shouldOverrideKeyEvent(..));
      L_17:
        WebPlayerView.access$600(this$0, "shouldOverrideKeyEvent");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_4b;
        WebViewApp.getCurrentApp();
        p1.getKeyCode();
        Integer.valueOf(KeyEvent.getKeyCode(..));
        p1.getAction();
        Integer.valueOf(KeyEvent.getAction(..));
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOULD_OVERRIDE_KEY_EVENT, 3);
      L_4b:
        WebPlayerView.access$700(this$0, "shouldOverrideKeyEvent");
        if (if-eqz(WebPlayerView.access$700(..))) goto L_62;
        Boolean.valueOf(1);
        WebPlayerView.access$800(this$0, "shouldOverrideKeyEvent", Boolean.class, Boolean.valueOf(..));
      L_62:
        WebPlayerView.access$800(..).booleanValue();
        return Boolean.booleanValue(..);
    }

    public boolean shouldOverrideUrlLoading(WebView p0, WebResourceRequest p1) {
        Boolean.valueOf(0);
        WebPlayerView.access$500(this$0, "shouldOverrideUrlLoading");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_17;
        WebViewClient.shouldOverrideUrlLoading(p0, p1);
        Boolean.valueOf(WebViewClient.shouldOverrideUrlLoading(..));
      L_17:
        WebPlayerView.access$600(this$0, "shouldOverrideUrlLoading");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_47;
        WebViewApp.getCurrentApp();
        p1.getUrl();
        WebResourceRequest.getUrl(..).toString();
        p1.getMethod();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOULD_OVERRIDE_URL_LOADING, 3);
      L_47:
        WebPlayerView.access$700(this$0, "shouldOverrideUrlLoading");
        if (if-eqz(WebPlayerView.access$700(..))) goto L_5e;
        Boolean.valueOf(1);
        WebPlayerView.access$800(this$0, "shouldOverrideUrlLoading", Boolean.class, Boolean.valueOf(..));
      L_5e:
        WebPlayerView.access$800(..).booleanValue();
        return Boolean.booleanValue(..);
    }

    public boolean shouldOverrideUrlLoading(WebView p0, String p1) {
        Boolean.valueOf(0);
        WebPlayerView.access$500(this$0, "shouldOverrideUrlLoading");
        if (if-eqz(WebPlayerView.access$500(..))) goto L_17;
        WebViewClient.shouldOverrideUrlLoading(p0, p1);
        Boolean.valueOf(WebViewClient.shouldOverrideUrlLoading(..));
      L_17:
        WebPlayerView.access$600(this$0, "shouldOverrideUrlLoading");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_38;
        WebViewApp.getCurrentApp();
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOULD_OVERRIDE_URL_LOADING, 2);
      L_38:
        WebPlayerView.access$700(this$0, "shouldOverrideUrlLoading");
        if (if-eqz(WebPlayerView.access$700(..))) goto L_4f;
        Boolean.valueOf(1);
        WebPlayerView.access$800(this$0, "shouldOverrideUrlLoading", Boolean.class, Boolean.valueOf(..));
      L_4f:
        WebPlayerView.access$800(..).booleanValue();
        return Boolean.booleanValue(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.webplayer.WebPlayerView$WebPlayerClient$1
// ============================================================
package com.unity3d.services.ads.webplayer;

class WebPlayerView$WebPlayerClient$1 {
    final WebPlayerView$WebPlayerClient this$1;
    final WebView val$view;

    WebPlayerView$WebPlayerClient$1(WebPlayerView$WebPlayerClient p0, WebView p1) {
        this$1 = p0;
        val$view = p1;
        new Object();
        return;
    }

    public void run() {
        ViewUtilities.removeViewFromParent(val$view);
        WebView.destroy();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.webplayer.WebPlayerView$WebPlayerDownloadListener
// ============================================================
package com.unity3d.services.ads.webplayer;

class WebPlayerView$WebPlayerDownloadListener {
    final WebPlayerView this$0;

    private WebPlayerView$WebPlayerDownloadListener(WebPlayerView p0) {
        this$0 = p0;
        new Object();
        return;
    }

    WebPlayerView$WebPlayerDownloadListener(WebPlayerView p0, WebPlayerView$1 p1) {
        new WebPlayerView$WebPlayerDownloadListener(p0);
        return;
    }

    public void onDownloadStart(String p0, String p1, String p2, String p3, long p4) {
        WebPlayerView.access$600(this$0, "onDownloadStart");
        if (if-eqz(WebPlayerView.access$600(..))) goto L_34;
        WebViewApp.getCurrentApp();
        Long.valueOf(p4, v11);
        WebPlayerView.access$400(this$0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.DOWNLOAD_START, 6);
      L_34:
        return;
    }

}

