// Package bundle: com.epicgames.mobile.eossdk (33 classes)

// ============================================================
// CLASS: com.epicgames.mobile.eossdk.BuildConfig
// ============================================================
package com.epicgames.mobile.eossdk;

public final class BuildConfig {
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String FLAVOR = "StaticSTDC";
    public static final String LIBRARY_PACKAGE_NAME = "com.epicgames.mobile.eossdk";

    public BuildConfig() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSAuthHandlerActivity
// ============================================================
package com.epicgames.mobile.eossdk;

public class EOSAuthHandlerActivity extends Activity {
    public static String LoginData = "";
    public static long LoginDataTimestamp;

    static <clinit>() {
        return;
    }

    public EOSAuthHandlerActivity() {
        new Activity();
        new Date();
        new Date(..).getTime();
        LoginDataTimestamp = Date.getTime(..);
        return;
    }

    public static void ResetData() {
        LoginData = "";
        LoginDataTimestamp = 0L;
        return;
    }

    protected void onCreate(Bundle p0) {
        Activity.onCreate(p0);
        EOSAuthHandlerActivity.getPackageManager();
        EOSAuthHandlerActivity.getPackageName();
        PackageManager.getLaunchIntentForPackage(EOSAuthHandlerActivity.getPackageName(..));
        if (if-nez(PackageManager.getLaunchIntentForPackage(..))) goto L_19;
        EOSLog.Eos.Error("Failed to get application intent");
        return;
      L_19:
        EOSAuthHandlerActivity.getIntent();
        EOSAuthHandlerActivity.getIntent(..).getData();
        if (if-eqz(Intent.getData(..))) goto L_28;
        Intent.getData(..).toString();
      L_28:
      L_2a:
        LoginData = "";
        EOSLog.Eos.addFlags(0x24080000);
        EOSAuthHandlerActivity.startActivity(EOSLog.Eos);
        EOSAuthHandlerActivity.finishAndRemoveTask();
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSCookies
// ============================================================
package com.epicgames.mobile.eossdk;

public class EOSCookies {
    public EOSCookies() {
        new Object();
        return;
    }

    public static void RemoveAllCookies(ValueCallback p0) {
        CookieManager.getInstance();
        CookieManager.getInstance(..).hasCookies();
        if (if-eqz(CookieManager.hasCookies(..))) goto L_12;
        CookieManager.getInstance();
        CookieManager.getInstance(..).removeAllCookies(p0);
      L_12:
        Boolean.valueOf(1);
        p0.onReceiveValue(Boolean.valueOf(..));
      L_1a:
        return;
    }

    public static void SetCookies(String p0, List p1, ValueCallback p2) {
        p1.isEmpty();
        if (if-nez(List.isEmpty(..))) goto L_1a;
        p1.get(0);
        CookieManager.getInstance();
        new EOSCookies$$ExternalSyntheticLambda0(p0, p1, p2);
        CookieManager.getInstance(..).setCookie(p0, List.get(..), new EOSCookies$$ExternalSyntheticLambda0(..));
      L_1a:
        Boolean.valueOf(1);
        p2.onReceiveValue(Boolean.valueOf(..));
      L_22:
        return;
    }

    static void lambda$SetCookies$0(String p0, List p1, ValueCallback p2, Boolean p3) {
        p3.booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_13;
        p1.size();
        p1.subList(1, List.size(..));
        EOSCookies.SetCookies(p0, List.subList(..), p2);
      L_13:
        Boolean.valueOf(0);
        p2.onReceiveValue(Boolean.valueOf(..));
      L_1b:
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSLog
// ============================================================
package com.epicgames.mobile.eossdk;

public class EOSLog {
    private static final int EOS_REDACT_EXP_KEEP_LEN = 3;
    private static final int EOS_REDACT_MIN_KEEP_LEN = 1;
    private static final int EOS_REDACT_MIN_LEN = 9;
    public static final EOSLogger Eos;
    public static final EOSLogger EosInternal;
    public static final EOSLogger Overlay;
    public static final EOSLogger OverlayInternal;

    static <clinit>() {
        new EOSLogger(EOSLog$Category.EOS);
        Eos = new EOSLogger(..);
        new EOSLogger(EOSLog$Category.EOS_INTERNAL);
        EosInternal = new EOSLogger(..);
        new EOSLogger(EOSLog$Category.OVERLAY);
        Overlay = new EOSLogger(..);
        new EOSLogger(EOSLog$Category.OVERLAY_INTERNAL);
        OverlayInternal = new EOSLogger(..);
        return;
    }

    public EOSLog() {
        new Object();
        return;
    }

    public static boolean IsIncludeRedactEnabled() {
        // native or abstract
    }

    public static String Redact(String p0) {
        EOSLog.ShouldRedact();
        EOSLog.ShouldRedact(..).booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_c;
      L_c:
        return "<Redacted>";
    }

    public static String RedactInt(long p0) {
        String.valueOf(p0, v1);
        EOSLog.Redact(String.valueOf(..));
        return EOSLog.Redact(..);
    }

    public static String RedactMid(String p0) {
        EOSLog.ShouldRedact();
        EOSLog.ShouldRedact(..).booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_51;
        p0.length();
        if (if-lt(String.length(..), 9)) goto L_30;
        p0.substring(0, 3);
        p0.length();
        p0.substring(String.length(..), 3);
        String.format("%s...%s", String.length(..));
        return String.format(..);
      L_30:
        String.format(..).length();
        if (if-lt(String.length(..), 1)) goto L_51;
        String.format(..).charAt(0);
        Character.valueOf(String.charAt(..));
        String.format(..).length();
        String.format(..).substring(String.length(..), 1);
        String.format("%s...%s", String.length(..));
      L_51:
        return String.format(..);
    }

    public static Boolean ShouldRedact() {
        Boolean.booleanValue();
        Boolean.valueOf(Boolean.booleanValue(..));
        return Boolean.valueOf(..);
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSLogger
// ============================================================
package com.epicgames.mobile.eossdk;

public final class EOSLogger {
    private static final String LOG_TAG = "EOSSDK";
    private final boolean AllowOSLoggingFallback;
    final EOSLog$Category Category;

    public EOSLogger(EOSLog$Category p0) {
        new Object();
        Category = p0;
        if (if-eq(p0, EOSLog$Category.OVERLAY)) goto L_10;
        if (if-ne(p0, EOSLog$Category.EOS)) goto L_e;
      L_e:
      L_10:
      L_11:
        AllowOSLoggingFallback = 1;
        return;
    }

    private static String GetLogCategoryString(EOSLog$Category p0) {
        p0.ordinal();
        if (if-eq(EOSLog$Category.ordinal(..), 1)) goto L_20;
        if (if-eq(EOSLog$Category.ordinal(..), 2)) goto L_1d;
        if (if-eq(EOSLog$Category.ordinal(..), 3)) goto L_1a;
        if (if-eq(EOSLog$Category.ordinal(..), 4)) goto L_17;
        return "LogEosUnknown";
      L_17:
        return "LogOverlayInternal";
      L_1a:
        return "LogEosOverlay";
      L_1d:
        return "LogEosInternal";
      L_20:
        return "LogEos";
    }

    private void Log(EOSLog$Level p0, String p1) {
        EOSLogger.Log(Category, p0, p1);
        if (if-nez(EOSLogger.Log(..))) goto L_52;
        if (if-eqz(AllowOSLoggingFallback)) goto L_52;
        new StringBuilder();
        EOSLogger.GetLogCategoryString(Category);
        new StringBuilder(..).append(EOSLogger.GetLogCategoryString(..));
        new StringBuilder(..).append(": ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        p0.ordinal();
        if (if-eq(EOSLog$Level.ordinal(..), 1)) goto L_4f;
        if (if-eq(EOSLog$Level.ordinal(..), 2)) goto L_4b;
        if (if-eq(EOSLog$Level.ordinal(..), 3)) goto L_4b;
        if (if-eq(EOSLog$Level.ordinal(..), 4)) goto L_47;
        if (if-eq(EOSLog$Level.ordinal(..), 5)) goto L_43;
        Log.e("EOSSDK", StringBuilder.toString(..));
      L_43:
        Log.v("EOSSDK", StringBuilder.toString(..));
      L_47:
        Log.d("EOSSDK", StringBuilder.toString(..));
      L_4b:
        Log.i("EOSSDK", StringBuilder.toString(..));
      L_4f:
        Log.w("EOSSDK", StringBuilder.toString(..));
      L_52:
        return;
    }

    public static boolean Log(EOSLog$Category p0, EOSLog$Level p1, String p2) {
        // native or abstract
    }

    public void Display(String p0) {
        EOSLogger.Log(EOSLog$Level.DISPLAY, p0);
        return;
    }

    public void Error(String p0) {
        EOSLogger.Log(EOSLog$Level.ERROR, p0);
        return;
    }

    public void Fatal(String p0) {
        EOSLogger.Log(EOSLog$Level.FATAL, p0);
        return;
    }

    public void Log(String p0) {
        EOSLogger.Log(EOSLog$Level.LOG, p0);
        return;
    }

    public void Verbose(String p0) {
        EOSLogger.Log(EOSLog$Level.VERBOSE, p0);
        return;
    }

    public void VeryVerbose(String p0) {
        EOSLogger.Log(EOSLog$Level.VERY_VERBOSE, p0);
        return;
    }

    public void Warning(String p0) {
        EOSLogger.Log(EOSLog$Level.WARNING, p0);
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlay
// ============================================================
package com.epicgames.mobile.eossdk;

public final class EOSOverlay {
    public static final EOSOverlayWidgetManager WidgetManager;

    static <clinit>() {
        new EOSOverlayWidgetManager();
        WidgetManager = new EOSOverlayWidgetManager(..);
        return;
    }

    public EOSOverlay() {
        new Object();
        return;
    }

    public static void EndWebview(long p0, long p1, long p2) {
        new EOSOverlayId(p0, v3, p1, v5);
        EOSOverlay.WidgetManager.EndWebview(new EOSOverlayId(..), p2, v7);
        return;
    }

    public static void EvaluateJS(long p0, long p1, long p2, String p3) {
        new EOSOverlayId(p0, v3, p1, v5);
        EOSOverlay.WidgetManager.EvaluateJS(new EOSOverlayId(..), p2, v7, p3);
        return;
    }

    public static EOSOverlayWebviewDisplaySettings GetDisplaySettings(long p0, long p1) {
        new EOSOverlayId(p0, v3, p1, v5);
        EOSOverlay.WidgetManager.GetDisplaySettings(new EOSOverlayId(..));
        return EOSOverlayWidgetManager.GetDisplaySettings(..);
    }

    public static boolean GetEnabledForNextLaunch() {
        EOSPreferences.GetEnabledForNextLaunch();
        return EOSPreferences.GetEnabledForNextLaunch(..);
    }

    public static void InvokeJavascriptCallback(String p0, long p1, long p2, boolean p3) {
        EOSOverlay.WidgetManager.InvokeJavascriptCallback(p0, p1, v3, p2, v5, p3);
        return;
    }

    public static void LoadURL(long p0, long p1, String p2, String[] p3, String p4, EOSOverlayWebviewDisplaySettings p5) {
        new EOSOverlayId(p0, v7, p1, v9);
        EOSOverlay.WidgetManager.LoadURL(new EOSOverlayId(..), p2, p3, p4, p5);
        return;
    }

    public static void OnBrowserStatusChange(long p0, long p1, EOSOverlay$BrowserStatus p2) {
        // native or abstract
    }

    public static void OnEvaluateJavascriptResult(long p0, long p1, long p2, String p3) {
        // native or abstract
    }

    public static void OnExecuteJavascriptFunction(long p0, long p1, String p2) {
        // native or abstract
    }

    public static void OnLoadURL(long p0, long p1, boolean p2) {
        // native or abstract
    }

    public static boolean SetDisplaySettings(long p0, long p1, EOSOverlayWebviewDisplaySettings p2) {
        new EOSOverlayId(p0, v3, p1, v5);
        EOSOverlay.WidgetManager.SetDisplaySettings(new EOSOverlayId(..), p2);
        return EOSOverlayWidgetManager.SetDisplaySettings(..);
    }

    public static void SetEnabledForNextLaunch(boolean p0) {
        EOSPreferences.SetEnabledForNextLaunch(p0);
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlayBackground
// ============================================================
package com.epicgames.mobile.eossdk;

public class EOSOverlayBackground extends View {
    public EOSOverlayBackground(Context p0, ViewGroup p1) {
        new View(p0);
        Color.argb(204, 18, 18, 18);
        new View(..).setBackgroundColor(Color.argb(..));
        new FrameLayout$LayoutParams(-1, -1);
        p1.addView(new View(..), new FrameLayout$LayoutParams(..));
        new View(..).hideBackground();
        new View(..).invalidate();
        return;
    }

    public void destroy() {
        EOSOverlayBackground.setOnTouchListener(0);
        EOSOverlayBackground.getParent();
        if (if-eqz(EOSOverlayBackground.getParent(..))) goto L_13;
        EOSOverlayBackground.getParent();
        EOSOverlayBackground.getParent(..).removeView(this);
      L_13:
        return;
    }

    public void hideBackground() {
        EOSOverlayBackground.setVisibility(8);
        return;
    }

    public void showBackground() {
        EOSOverlayBackground.setVisibility(0);
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlayBrowser
// ============================================================
package com.epicgames.mobile.eossdk;

public final class EOSOverlayBrowser {
    private EOSOverlayClosedButton CloseButton;
    private final ArrayList DeferredEvaluateJSSource;
    private final AtomicReference DisplaySettings;
    private EOSOverlayLoadingBar LoadingBar;
    public final EOSOverlayId OverlayId;
    private boolean ShouldHaveLoadingBar;
    private EOSOverlayWebView WebView;
    private EOSOverlayBackground WebViewBackground;
    private boolean bReadyToEvaluateJavascript;

    public EOSOverlayBrowser(Activity p0, EOSOverlayId p1, String p2, EOSOverlayWebviewDisplaySettings p3) {
        new Object();
        new ArrayList();
        DeferredEvaluateJSSource = new ArrayList(..);
        new EOSOverlayWebviewDisplaySettings();
        new AtomicReference(new EOSOverlayWebviewDisplaySettings(..));
        DisplaySettings = new AtomicReference(..);
        ShouldHaveLoadingBar = 0;
        new StringBuilder();
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(" EOSOverlayBrowser() (Data), JavaScript: ");
        EOSLog.Redact(p2);
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.VeryVerbose(StringBuilder.toString(..));
        OverlayId = p1;
        new EOSOverlayQueuedEvaluateJavascript(0L, EOSLog.Redact(..), 0, p2);
        new ArrayList(..).add(new EOSOverlayQueuedEvaluateJavascript(..));
        p0.findViewById(16908290);
        Activity.findViewById(..).getRootView();
        new EOSOverlayBackground(p0, View.getRootView(..));
        WebViewBackground = new EOSOverlayBackground(..);
        WebView.setWebContentsDebuggingEnabled(0);
        new EOSOverlayWebView(p0, p1);
        WebView = new EOSOverlayWebView(..);
        new EOSOverlayJavascriptInterface(p1);
        new EOSOverlayWebView(..).addJavascriptInterface(new EOSOverlayJavascriptInterface(..), "eosBridgeJs");
        WebView.getSettings();
        new StringBuilder();
        WebSettings.getDefaultUserAgent(p0);
        new StringBuilder(..).append(WebSettings.getDefaultUserAgent(..));
        String.format(" %s", EOSLog.Redact(..));
        new StringBuilder(..).append(String.format(..));
        new StringBuilder(..).toString();
        EOSOverlayWebView.getSettings(..).setUserAgentString(StringBuilder.toString(..));
        WebView.getSettings();
        EOSOverlayWebView.getSettings(..).setJavaScriptEnabled(1);
        new EOSOverlayWebChromeClient(p1);
        WebView.setWebChromeClient(new EOSOverlayWebChromeClient(..));
        new EOSOverlayWebViewClient(p1, new Object(..));
        WebView.setWebViewClient(new EOSOverlayWebViewClient(..));
        WebView.setBackgroundColor(0);
        WebView.getSettings();
        EOSOverlayWebView.getSettings(..).setDomStorageEnabled(1);
        WebView.setOutlineProvider(0);
        new Object(..).SetVisibility(WebView, 0);
        new FrameLayout$LayoutParams(-1, -1);
        View.getRootView(..).addView(WebView, new FrameLayout$LayoutParams(..));
        if (if-eqz(p3)) goto L_e4;
        if (if-eqz(bUseSafeArea)) goto L_e4;
        new EOSOverlayBrowser$$ExternalSyntheticLambda1(new Object(..), p0);
        ViewCompat.setOnApplyWindowInsetsListener(WebView, new EOSOverlayBrowser$$ExternalSyntheticLambda1(..));
      L_e4:
        WebView.invalidate();
        new EOSOverlayLoadingBar(p0, View.getRootView(..));
        LoadingBar = new EOSOverlayLoadingBar(..);
        new EOSOverlayLoadingBar(..).bringToFront();
        new EOSOverlayClosedButton(p0, View.getRootView(..), new Object(..));
        CloseButton = new EOSOverlayClosedButton(..);
        new StringBuilder();
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(" EOSOverlayBrowser close button error ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
      L_115:
        return;
    }

    private int GetNavigationBarHeight(Context p0, int p1) {
        p0.getResources();
        if (if-ne(p1, 1)) goto L_a;
      L_a:
      L_c:
        Context.getResources(..).getIdentifier("navigation_bar_height_landscape", "dimen", "android");
        if (if-lez(Resources.getIdentifier(..))) goto L_1b;
        Context.getResources(..).getDimensionPixelSize(Resources.getIdentifier(..));
        return Resources.getDimensionPixelSize(..);
      L_1b:
        return 0;
    }

    public boolean EndWebview(boolean p0) {
        if (if-nez(WebView)) goto L_1e;
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.EndWebview, WebView already removed");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
        return 0;
      L_1e:
        LoadingBar.destroy();
        LoadingBar = 0;
        if (if-eqz(CloseButton)) goto L_2f;
        CloseButton.destroy();
        CloseButton = 0;
      L_2f:
        WebViewBackground.destroy();
        WebViewBackground = 0;
        WebView.destroy();
        WebView = 0;
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.EndWebview, bCrashed:");
        new StringBuilder(..).append(0);
        new StringBuilder(..).toString();
        EOSLog.Overlay.Log(StringBuilder.toString(..));
        if (if-eqz(0)) goto L_65;
      L_65:
      L_67:
        EOSOverlay.OnBrowserStatusChange(InstanceId, StringBuilder.toString(..), BrowserId, v3, EOSOverlay$BrowserStatus.CLOSED);
        return 1;
    }

    public boolean EvaluateJS(long p0, boolean p1, String p2) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.EvaluateJS, RequestId: ");
        new StringBuilder(..).append(p0, v6);
        new StringBuilder(..).append(", bWantsResult: ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(", bReadyToEvaluateJavascript: ");
        new StringBuilder(..).append(bReadyToEvaluateJavascript);
        new StringBuilder(..).append(", Javascript: ");
        EOSLog.Redact(p2);
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.VeryVerbose(StringBuilder.toString(..));
        if (if-nez(WebView)) goto L_60;
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.EvaluateJS, No Browser, RequestId: ");
        new StringBuilder(..).append(p0, v6);
        new StringBuilder(..).append(", bWantsResult: ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
        return 0;
      L_60:
        if (if-nez(bReadyToEvaluateJavascript)) goto L_70;
        new EOSOverlayQueuedEvaluateJavascript(0, v6, p1, EOSLog.Overlay);
        DeferredEvaluateJSSource.add(new EOSOverlayQueuedEvaluateJavascript(..));
        return 1;
      L_70:
        new EOSOverlayBrowser$$ExternalSyntheticLambda2(this, 0, v6, p1);
        DeferredEvaluateJSSource.evaluateJavascript(EOSLog.Overlay, new EOSOverlayBrowser$$ExternalSyntheticLambda2(..));
        return 1;
    }

    public EOSOverlayWebviewDisplaySettings GetDisplaySettings() {
        DisplaySettings.get();
        return AtomicReference.get(..);
    }

    public boolean InvokeJavascriptCallback(String p0, long p1, boolean p2) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.InvokeJavascriptCallback, CallbackId: ");
        new StringBuilder(..).append(p1, v6);
        new StringBuilder(..).append(", IsSuccess: ");
        new StringBuilder(..).append(p2);
        new StringBuilder(..).append(", ArgumentsString: ");
        EOSLog.Redact(p0);
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.VeryVerbose(StringBuilder.toString(..));
        if (if-nez(WebView)) goto L_50;
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.InvokeJavascriptCallback (No WebView), CallbackId: ");
        new StringBuilder(..).append(p1, v6);
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
        return 0;
      L_50:
        new JSONObject();
        new JSONObject(..).put("callbackId", StringBuilder.toString(..), v6);
        new JSONObject(..).put("isSuccess", new StringBuilder(..));
        new StringBuilder();
        new StringBuilder(..).append("window.__eos_detail__.resolveBridgePromise( ");
        new StringBuilder(..).append(new JSONObject(..));
        new StringBuilder(..).length();
        new StringBuilder(..).deleteCharAt(StringBuilder.length(..));
        new StringBuilder(..).append(",\"arguments\":");
        new StringBuilder(..).append(EOSLog.Overlay);
        new StringBuilder(..).append("}");
        new StringBuilder(..).append(")");
        new StringBuilder(..).toString();
        EOSOverlayBrowser.EvaluateJS(-1L, ",\"arguments\":", 0, StringBuilder.toString(..));
        return EOSOverlayBrowser.EvaluateJS(..);
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.InvokeJavascriptCallback, JSONObject error: ");
        EOSOverlayBrowser.EvaluateJS(..).toString();
        EOSLog.Redact(JSONException.toString(..));
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        EOSOverlayBrowser.EvaluateJS(..).printStackTrace();
        return 0;
    }

    public void LoadURL(String p0, String[] p1, EOSOverlayWebviewDisplaySettings p2) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.LoadURL");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Log(StringBuilder.toString(..));
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.LoadURL (Data), URL: ");
        EOSLog.Redact(p0);
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).append(", Cookies: ");
        Arrays.toString(p1);
        EOSLog.Redact(Arrays.toString(..));
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.VeryVerbose(StringBuilder.toString(..));
        new EOSOverlayBrowser$$ExternalSyntheticLambda0(this, p0, p1, p2);
        EOSCookies.RemoveAllCookies(new EOSOverlayBrowser$$ExternalSyntheticLambda0(..));
        return;
    }

    public void SetDisplaySettings(EOSOverlayWebviewDisplaySettings p0) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.SetDisplaySettings: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.VeryVerbose(StringBuilder.toString(..));
        DisplaySettings.set(p0);
        new EOSOverlayBrowser$$ExternalSyntheticLambda3(this, p0);
        new FutureTask(new EOSOverlayBrowser$$ExternalSyntheticLambda3(..));
        EOSSDK.GetActivity();
        EOSSDK.GetActivity(..).runOnUiThread(new FutureTask(..));
        return;
    }

    public void SetVisibility(View p0, boolean p1) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.SetVisibility:");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.VeryVerbose(StringBuilder.toString(..));
        if (if-eqz(p1)) goto L_2f;
        p0.setVisibility(0);
        p0.setClickable(1);
        p0.setFocusable(1);
        p0.setEnabled(1);
        p0.setFocusableInTouchMode(1);
      L_2f:
        p0.setVisibility(4);
        p0.setClickable(0);
        p0.setFocusable(0);
        p0.setEnabled(0);
        p0.setFocusableInTouchMode(0);
      L_3f:
        return;
    }

    void lambda$EvaluateJS$3$com-epicgames-mobile-eossdk-EOSOverlayBrowser(long p0, boolean p1, String p2) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.EvaluateJS (Completed), RequestId: ");
        new StringBuilder(..).append(p0, v9);
        new StringBuilder(..).append(", bWantsResult: ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(", EvalOutput: ");
        EOSLog.Redact(p2);
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.VeryVerbose(StringBuilder.toString(..));
        if (if-eqz(p1)) goto L_3e;
        EOSOverlay.OnEvaluateJavascriptResult(InstanceId, StringBuilder.toString(..), BrowserId, v3, p0, v5, p2);
      L_3e:
        return;
    }

    void lambda$LoadURL$1$com-epicgames-mobile-eossdk-EOSOverlayBrowser(EOSOverlayWebviewDisplaySettings p0, String p1, Boolean p2) {
        p2.booleanValue();
        if (if-nez(Boolean.booleanValue(..))) goto L_2b;
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.LoadURL, SetCookies failed");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        EOSOverlay.OnLoadURL(InstanceId, StringBuilder.toString(..), BrowserId, v2, 0);
        return;
      L_2b:
        if (if-nez(WebView)) goto L_53;
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.LoadURL, WebView no longer exists");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        EOSOverlay.OnLoadURL(InstanceId, StringBuilder.toString(..), BrowserId, v2, 0);
        return;
      L_53:
        EOSOverlayBrowser.SetDisplaySettings(InstanceId);
        ShouldHaveLoadingBar = bIsVisible;
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.LoadURL, OnLoadURL");
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.Log(StringBuilder.toString(..));
        EOSOverlay.OnLoadURL(InstanceId, BrowserId, BrowserId, v3, 1);
        WebView.loadUrl(StringBuilder.toString(..));
        if (if-eqz(LoadingBar)) goto L_8e;
        if (if-eqz(ShouldHaveLoadingBar)) goto L_8e;
        LoadingBar.showLoadingBar();
      L_8e:
        if (if-eqz(CloseButton)) goto L_9f;
        EOSOverlayBrowser.GetDisplaySettings();
        if (if-eqz(bHasCloseButton)) goto L_9f;
        CloseButton.showCloseButton();
      L_9f:
        if (if-eqz(WebViewBackground)) goto L_b0;
        EOSOverlayBrowser.GetDisplaySettings();
        if (if-eqz(bHasDarkenedBackground)) goto L_b0;
        WebViewBackground.showBackground();
      L_b0:
        return;
    }

    void lambda$LoadURL$2$com-epicgames-mobile-eossdk-EOSOverlayBrowser(String p0, String[] p1, EOSOverlayWebviewDisplaySettings p2, Boolean p3) {
        p3.booleanValue();
        if (if-nez(Boolean.booleanValue(..))) goto L_2b;
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.LoadURL, RemoveAllCookies failed");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        EOSOverlay.OnLoadURL(InstanceId, StringBuilder.toString(..), BrowserId, Boolean.booleanValue(..), 0);
        return;
      L_2b:
        Arrays.asList(StringBuilder.toString(..));
        new EOSOverlayBrowser$$ExternalSyntheticLambda4(this, BrowserId, InstanceId);
        EOSCookies.SetCookies(InstanceId, Arrays.asList(..), new EOSOverlayBrowser$$ExternalSyntheticLambda4(..));
        return;
    }

    Boolean lambda$SetDisplaySettings$4$com-epicgames-mobile-eossdk-EOSOverlayBrowser(EOSOverlayWebviewDisplaySettings p0) {
        if (if-nez(WebView)) goto L_22;
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayBrowser.SetDisplaySettings (No WebView)");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
        Boolean.valueOf(0);
        return Boolean.valueOf(..);
      L_22:
        EOSOverlayBrowser.SetVisibility(StringBuilder.toString(..), bIsVisible);
        if (if-eqz(bIsVisible)) goto L_37;
        WebView.bringToFront();
        if (if-eqz(CloseButton)) goto L_37;
        CloseButton.bringToFront();
      L_37:
        ViewCompat.setElevation(WebView, ZIndex);
        if (if-eqz(CloseButton)) goto L_4d;
        ViewCompat.setElevation(CloseButton, ZIndex);
      L_4d:
        WebView.SetDisplaySettings(Boolean.valueOf(..));
        Boolean.valueOf(EOSOverlayWebView.SetDisplaySettings(..));
        return Boolean.valueOf(..);
    }

    WindowInsetsCompat lambda$new$0$com-epicgames-mobile-eossdk-EOSOverlayBrowser(Activity p0, View p1, WindowInsetsCompat p2) {
        p2.getSystemWindowInsets();
        p1.getLayoutParams();
        topMargin = top;
        bottomMargin = bottom;
        leftMargin = left;
        rightMargin = right;
        p0.getResources();
        Activity.getResources(..).getConfiguration();
        if (if-ne(orientation, 1)) goto L_33;
        EOSOverlayBrowser.GetNavigationBarHeight(p0, orientation);
        Math.max(bottomMargin, EOSOverlayBrowser.GetNavigationBarHeight(..));
        bottomMargin = Math.max(..);
      L_33:
        p1.setLayoutParams(View.getLayoutParams(..));
        return p2;
    }

    public void onPageFinished() {
        if (if-eqz(LoadingBar)) goto L_7;
        LoadingBar.hideLoadingBar();
      L_7:
        return;
    }

    public void onPageStarted() {
        if (if-nez(bReadyToEvaluateJavascript)) goto L_28;
        bReadyToEvaluateJavascript = 1;
        DeferredEvaluateJSSource.iterator();
      L_d:
        ArrayList.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_23;
        ArrayList.iterator(..).next();
        EOSOverlayBrowser.EvaluateJS(RequestId, v3, bWantsResult, Source);
      L_23:
        DeferredEvaluateJSSource.clear();
      L_28:
        return;
    }

    public void onRenderProcessGone() {
        EOSOverlayBrowser.EndWebview(1);
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlayClosedButton
// ============================================================
package com.epicgames.mobile.eossdk;

public class EOSOverlayClosedButton extends View {
    private static final float CLICK_DRAG_TOLERANCE = 10.0f;
    private final Paint BackgroundPaint;
    private final Paint CrossOutlinePaint;
    private final Paint CrossPaint;
    final float LargeMargin;
    final float OutlineSize;
    private EOSOverlayBrowser OverlayBrowser;
    final float Radius;
    float RectWidth;
    float SafeSpaceHeight;
    float SafeSpaceWidth;
    final float ShortMargin;
    final float Size;
    private boolean StartedTouchInside;
    private final RectF ViewRect;
    private float downDisplacementX;
    private float downDisplacementY;
    private float downRawX;
    private float downRawY;
    private float xDisplacement;
    private float yDisplacement;

    public EOSOverlayClosedButton(Context p0, ViewGroup p1, EOSOverlayBrowser p2) {
        new View(p0);
        Radius = 25.0f;
        Size = 15.0f;
        OutlineSize = 2.0f;
        ShortMargin = 27.0f;
        LargeMargin = 48.0f;
        new RectF();
        ViewRect = new RectF(..);
        RectWidth = 0;
        SafeSpaceWidth = 0;
        SafeSpaceHeight = 0;
        StartedTouchInside = 0;
        OverlayBrowser = p2;
        new Paint();
        BackgroundPaint = new Paint(..);
        Color.argb(20, 20, 20, 20);
        new Paint(..).setColor(Color.argb(..));
        new Paint();
        CrossPaint = new Paint(..);
        new Paint(..).setColor(-1);
        new Paint(..).setStrokeWidth(5.0f);
        new Paint();
        CrossOutlinePaint = new Paint(..);
        new Paint(..).setColor(0xff000000);
        new Paint(..).setStrokeWidth(10.0f);
        new FrameLayout$LayoutParams(-1, -1);
        p1.addView(new View(..), new FrameLayout$LayoutParams(..));
        new View(..).setOnTouchListener(new View(..));
        new View(..).hideCloseButton();
        new View(..).setOutlineProvider(0);
        new View(..).invalidate();
        return;
    }

    private void setLandscapeMode() {
        EOSOverlayClosedButton.pixelsFromDp(48.0f);
        SafeSpaceWidth = EOSOverlayClosedButton.pixelsFromDp(..);
        EOSOverlayClosedButton.pixelsFromDp(27.0f);
        SafeSpaceHeight = EOSOverlayClosedButton.pixelsFromDp(..);
        return;
    }

    private void setPortraitMode() {
        EOSOverlayClosedButton.pixelsFromDp(27.0f);
        SafeSpaceWidth = EOSOverlayClosedButton.pixelsFromDp(..);
        EOSOverlayClosedButton.pixelsFromDp(48.0f);
        SafeSpaceHeight = EOSOverlayClosedButton.pixelsFromDp(..);
        return;
    }

    public float GetOriginX() {
        return RectWidth;
    }

    public float GetOriginY() {
        return SafeSpaceHeight;
    }

    public boolean IsTouchInside(float p0, float p1) {
        EOSOverlayClosedButton.GetOriginX();
        EOSOverlayClosedButton.GetOriginY();
        new RectF(v4, 7.5f, EOSOverlayClosedButton.GetOriginX(..), EOSOverlayClosedButton.GetOriginY(..));
        new RectF(..).contains(p0, p1);
        return RectF.contains(..);
    }

    public void destroy() {
        EOSOverlayClosedButton.setOnTouchListener(0);
        EOSOverlayClosedButton.getParent();
        if (if-eqz(EOSOverlayClosedButton.getParent(..))) goto L_13;
        EOSOverlayClosedButton.getParent();
        EOSOverlayClosedButton.getParent(..).removeView(this);
      L_13:
        return;
    }

    public void draw(Canvas p0) {
        View.draw(p0);
        EOSOverlayClosedButton.GetOriginX();
        EOSOverlayClosedButton.GetOriginY();
        p0.drawLine(v1, v2, v3, 2.0f, CrossOutlinePaint);
        p0.drawLine(v1, 2.0f, v3, v2, CrossOutlinePaint);
        p0.drawLine(EOSOverlayClosedButton.GetOriginX(..), EOSOverlayClosedButton.GetOriginY(..), p0, v1, CrossPaint);
        p0.drawLine(EOSOverlayClosedButton.GetOriginX(..), v1, p0, EOSOverlayClosedButton.GetOriginY(..), CrossPaint);
        EOSOverlayClosedButton.invalidate();
        return;
    }

    public void hideCloseButton() {
        EOSOverlayClosedButton.setVisibility(8);
        return;
    }

    public void onSizeChanged(int p0, int p1, int p2, int p3) {
        xDisplacement = 0;
        yDisplacement = 0;
        ViewRect.set(0, 0, v2, v3);
        ViewRect.width();
        RectWidth = RectF.width(..);
        if (if-nez(p2)) goto L_22;
        if (if-nez(p3)) goto L_22;
        if (if-le(p0, p1)) goto L_1e;
        EOSOverlayClosedButton.setLandscapeMode();
      L_1e:
        EOSOverlayClosedButton.setPortraitMode();
      L_22:
        if (if-ge(p0, p2)) goto L_2a;
        if (if-le(p1, p3)) goto L_2a;
        EOSOverlayClosedButton.setPortraitMode();
      L_2a:
        if (if-ne(p0, p3)) goto L_31;
        if (if-ne(p1, p2)) goto L_31;
        EOSOverlayClosedButton.setLandscapeMode();
      L_31:
        return;
    }

    public boolean onTouch(View p0, MotionEvent p1) {
        p1.getRawX();
        p1.getRawY();
        EOSOverlayClosedButton.IsTouchInside(MotionEvent.getRawX(..), MotionEvent.getRawY(..));
        p1.getAction();
        if (if-eqz(MotionEvent.getAction(..))) goto L_99;
        if (if-eq(MotionEvent.getAction(..), 1)) goto L_71;
        if (if-eq(MotionEvent.getAction(..), 2)) goto L_1a;
        return 0;
      L_1a:
        p0.getLayoutParams();
        EOSOverlayClosedButton.GetOriginX();
        EOSOverlayClosedButton.GetOriginY();
        p1.getRawX();
        p1.getRawY();
        p0.getWidth();
        p0.getHeight();
        if (if-lez(leftMargin)) goto L_70;
        if (if-gez(EOSOverlayClosedButton.GetOriginX(..))) goto L_70;
        if (if-lez(topMargin)) goto L_70;
        if (if-gez(View.getHeight(..))) goto L_70;
        xDisplacement = MotionEvent.getRawX(..);
        yDisplacement = MotionEvent.getRawY(..);
      L_70:
        return 1;
      L_71:
        MotionEvent.getRawY(..).getRawX();
        MotionEvent.getRawY(..).getRawY();
        StartedTouchInside = EOSOverlayClosedButton.GetOriginY(..);
        Math.abs(MotionEvent.getRawX(..));
        if (if-gez(Math.abs(..))) goto L_98;
        Math.abs(MotionEvent.getRawY(..));
        if (if-gez(Math.abs(..))) goto L_98;
        EOSOverlayClosedButton.performClick();
        return EOSOverlayClosedButton.performClick(..);
      L_98:
        return 1;
      L_99:
        MotionEvent.getRawY(..).getRawX();
        downRawX = MotionEvent.getRawX(..);
        MotionEvent.getRawY(..).getRawY();
        downRawY = MotionEvent.getRawY(..);
        downDisplacementX = downRawX;
        downDisplacementY = MotionEvent.getRawY(..);
        if (if-eqz(10.0f)) goto L_b6;
        StartedTouchInside = 1;
        return 1;
      L_b6:
        return EOSOverlayClosedButton.GetOriginY(..);
    }

    public boolean performClick() {
        OverlayBrowser.EndWebview(0);
        View.performClick();
        return View.performClick(..);
    }

    public float pixelsFromDp(float p0) {
        EOSOverlayClosedButton.getContext();
        Context.getResources();
        Context.getResources(..).getDisplayMetrics();
        return p0;
    }

    public void showCloseButton() {
        EOSOverlayClosedButton.setVisibility(0);
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlayId
// ============================================================
package com.epicgames.mobile.eossdk;

public final class EOSOverlayId {
    public final long BrowserId;
    public final long InstanceId;

    public EOSOverlayId(long p0, long p1) {
        new Object();
        InstanceId = p0;
        BrowserId = p1;
        return;
    }

    public static String UnknownBrowserIdString(long p0) {
        new StringBuilder("[I:");
        UByte$$ExternalSyntheticBackport0.m(p0, v3);
        new StringBuilder(..).append(UByte$$ExternalSyntheticBackport0.m(..));
        new StringBuilder(..).append(" B:?]");
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-eqz(p0)) goto L_27;
        Object.getClass();
        p0.getClass();
        if (if-eq(Object.getClass(..), Object.getClass(..))) goto L_12;
      L_12:
        if (if-nez(InstanceId)) goto L_25;
        if (if-nez(p0)) goto L_25;
      L_25:
      L_26:
        return 0;
      L_27:
        return 0;
    }

    public int hashCode() {
        Long.valueOf(InstanceId, v2);
        Long.valueOf(BrowserId, 0);
        Objects.hash(2);
        return Objects.hash(..);
    }

    public String toString() {
        new StringBuilder("[I:");
        UByte$$ExternalSyntheticBackport0.m$1(InstanceId, v2);
        new StringBuilder(..).append(UByte$$ExternalSyntheticBackport0.m$1(..));
        new StringBuilder(..).append(" B:");
        UByte$$ExternalSyntheticBackport0.m$2(BrowserId, v2);
        new StringBuilder(..).append(UByte$$ExternalSyntheticBackport0.m$2(..));
        new StringBuilder(..).append("]");
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlayJavascriptInterface
// ============================================================
package com.epicgames.mobile.eossdk;

public final class EOSOverlayJavascriptInterface {
    public final EOSOverlayId OverlayId;

    public EOSOverlayJavascriptInterface(EOSOverlayId p0) {
        new Object();
        OverlayId = p0;
        return;
    }

    public String GetNavHeight() {
        return "48px";
    }

    public long GetNextJavascriptCallbackId() {
        EOSOverlay.WidgetManager.GetNextJavascriptCallbackId();
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSJSBridge.GetNextJavascriptCallbackId: , JavascriptCallbackId: ");
        new StringBuilder(..).append(EOSOverlayWidgetManager.GetNextJavascriptCallbackId(..), v1);
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.VeryVerbose(StringBuilder.toString(..));
        return EOSOverlayWidgetManager.GetNextJavascriptCallbackId(..);
    }

    public void OnExecuteJavascriptFunction(long p0, String p1) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayJavascriptInterface.OnExecuteJavascriptFunction: , CallbackId: ");
        new StringBuilder(..).append(p0, v5);
        new StringBuilder(..).append(", JSONString: ");
        EOSLog.Redact(p1);
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.VeryVerbose(StringBuilder.toString(..));
        EOSOverlay.WidgetManager.OnExecuteJavascriptFunction(OverlayId, p0, v5, p1);
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlayLoadingBar
// ============================================================
package com.epicgames.mobile.eossdk;

public class EOSOverlayLoadingBar extends View {
    private static float GLoadingBarAnimationRate = 612.0f;
    private static final float GLoadingBarLeftCatchupRate = 1.5f;
    private float BarLeft;
    private final Paint BarPaint;
    private float BarRight;
    private long LastRenderMs;
    private final RectF ViewRect;

    static <clinit>() {
        return;
    }

    public EOSOverlayLoadingBar(Context p0, ViewGroup p1) {
        new View(p0);
        LastRenderMs = 0L;
        new RectF();
        ViewRect = new RectF(..);
        BarLeft = 0;
        BarRight = 0;
        new Paint();
        BarPaint = new Paint(..);
        new Paint(..).setARGB(255, 0, 140, 255);
        p0.getResources();
        Context.getResources(..).getDisplayMetrics();
        Math.ceil(4.0f, 140);
        new FrameLayout$LayoutParams(-1, density);
        p1.addView(new View(..), new FrameLayout$LayoutParams(..));
        new View(..).hideLoadingBar();
        new View(..).invalidate();
        return;
    }

    private void resetProgress() {
        SystemClock.uptimeMillis();
        LastRenderMs = SystemClock.uptimeMillis(..);
        BarLeft = 0;
        BarRight = 0;
        return;
    }

    private void updateProgress(float p0) {
        ViewRect.width();
        if (if-gez(BarRight)) goto L_35;
        BarRight = BarRight;
        ViewRect.width();
        if (if-lez(RectF.width(..))) goto L_69;
        ViewRect.width();
        BarLeft = BarLeft;
      L_35:
        ViewRect.width();
        Math.min(RectF.width(..), BarRight);
        BarRight = Math.min(..);
        ViewRect.width();
        Math.min(RectF.width(..), BarLeft);
        BarLeft = Math.min(..);
        ViewRect.width();
        if (if-ltz(RectF.width(..))) goto L_69;
        BarLeft = 0;
        BarRight = 0;
      L_69:
        return;
    }

    public void destroy() {
        EOSOverlayLoadingBar.getParent();
        if (if-eqz(EOSOverlayLoadingBar.getParent(..))) goto L_f;
        EOSOverlayLoadingBar.getParent();
        EOSOverlayLoadingBar.getParent(..).removeView(this);
      L_f:
        return;
    }

    public void draw(Canvas p0) {
        View.draw(p0);
        SystemClock.uptimeMillis();
        LastRenderMs = SystemClock.uptimeMillis(..);
        EOSOverlayLoadingBar.updateProgress(SystemClock.uptimeMillis(..));
        ViewRect.height();
        p0.drawRect(BarLeft, 0, BarRight, RectF.height(..), BarPaint);
        EOSOverlayLoadingBar.invalidate();
        return;
    }

    public void hideLoadingBar() {
        EOSOverlayLoadingBar.setVisibility(8);
        return;
    }

    public void onSizeChanged(int p0, int p1, int p2, int p3) {
        ViewRect.set(0, 0, p0, p1);
        EOSOverlayLoadingBar.resetProgress();
        return;
    }

    public void showLoadingBar() {
        EOSOverlayLoadingBar.resetProgress();
        EOSOverlayLoadingBar.setVisibility(0);
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlayQueuedEvaluateJavascript
// ============================================================
package com.epicgames.mobile.eossdk;

public final class EOSOverlayQueuedEvaluateJavascript {
    final long RequestId;
    final String Source;
    final boolean bWantsResult;

    public EOSOverlayQueuedEvaluateJavascript(long p0, boolean p1, String p2) {
        new Object();
        RequestId = p0;
        bWantsResult = p1;
        Source = p2;
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlayWebChromeClient
// ============================================================
package com.epicgames.mobile.eossdk;

public final class EOSOverlayWebChromeClient extends WebChromeClient {
    public final EOSOverlayId OverlayId;

    public EOSOverlayWebChromeClient(EOSOverlayId p0) {
        new WebChromeClient();
        OverlayId = p0;
        return;
    }

    public boolean onConsoleMessage(ConsoleMessage p0) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSWebChromeClient, [console] ");
        p0.message();
        EOSLog.Redact(ConsoleMessage.message(..));
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).append(" at ");
        p0.lineNumber();
        new StringBuilder(..).append(ConsoleMessage.lineNumber(..));
        new StringBuilder(..).append(": ");
        p0.sourceId();
        new StringBuilder(..).append(ConsoleMessage.sourceId(..));
        new StringBuilder(..).toString();
        p0.messageLevel();
        ConsoleMessage.messageLevel(..).ordinal();
        if (if-eq(ConsoleMessage$MessageLevel.ordinal(..), 1)) goto L_64;
        if (if-eq(ConsoleMessage$MessageLevel.ordinal(..), 2)) goto L_5e;
        if (if-eq(ConsoleMessage$MessageLevel.ordinal(..), 3)) goto L_5e;
        if (if-eq(ConsoleMessage$MessageLevel.ordinal(..), 4)) goto L_58;
        if (if-eq(ConsoleMessage$MessageLevel.ordinal(..), 5)) goto L_52;
      L_52:
        EOSLog.OverlayInternal.Error(StringBuilder.toString(..));
      L_58:
        EOSLog.OverlayInternal.Warning(StringBuilder.toString(..));
      L_5e:
        EOSLog.OverlayInternal.Log(StringBuilder.toString(..));
      L_64:
        EOSLog.OverlayInternal.Verbose(StringBuilder.toString(..));
      L_69:
        return 1;
    }

    public boolean onCreateWindow(WebView p0, boolean p1, boolean p2, Message p3) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSWebChromeClient unexpected onCreateWindow");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        return 0;
    }

    public void onGeolocationPermissionsHidePrompt() {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSWebChromeClient unexpected onGeolocationPermissionsHidePrompt");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        return;
    }

    public void onGeolocationPermissionsShowPrompt(String p0, GeolocationPermissions$Callback p1) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSWebChromeClient unexpected onGeolocationPermissionsShowPrompt");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        return;
    }

    public boolean onJsAlert(WebView p0, String p1, String p2, JsResult p3) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSWebChromeClient unexpected onJsAlert");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        return 0;
    }

    public boolean onJsBeforeUnload(WebView p0, String p1, String p2, JsResult p3) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSWebChromeClient unexpected onJsBeforeUnload");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        return 0;
    }

    public boolean onJsConfirm(WebView p0, String p1, String p2, JsResult p3) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSWebChromeClient unexpected onJsConfirm");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        return 0;
    }

    public boolean onJsPrompt(WebView p0, String p1, String p2, String p3, JsPromptResult p4) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSWebChromeClient unexpected onJsPrompt");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        return 0;
    }

    public void onPermissionRequest(PermissionRequest p0) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSWebChromeClient unexpected onPermissionRequest");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        p0.deny();
        return;
    }

    public void onPermissionRequestCanceled(PermissionRequest p0) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSWebChromeClient unexpected onPermissionRequestCanceled");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        return;
    }

    public void onProgressChanged(WebView p0, int p1) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSWebChromeClient onProgressChanged: ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append("%");
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.VeryVerbose(StringBuilder.toString(..));
        return;
    }

    public boolean onShowFileChooser(WebView p0, ValueCallback p1, WebChromeClient$FileChooserParams p2) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSWebChromeClient unexpected onShowFileChooser");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        return 0;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlayWebView
// ============================================================
package com.epicgames.mobile.eossdk;

public class EOSOverlayWebView extends WebView {
    private final float Density;
    private EOSOverlayWebviewDisplaySettings DisplaySettings;
    final EOSOverlayId OverlayId;

    public EOSOverlayWebView(Context p0, EOSOverlayId p1) {
        new WebView(p0);
        OverlayId = p1;
        p0.getResources();
        Context.getResources(..).getDisplayMetrics();
        Density = density;
        return;
    }

    private boolean isWithinDisplaySettingsHitBox(float p0, float p1) {
        if (if-nez(DisplaySettings)) goto L_6;
        return 0;
      L_6:
        if (if-nez(bHitBox)) goto L_c;
        return 1;
      L_c:
        if (if-ltz(HitBoxX)) goto L_37;
        if (if-gtz(p0)) goto L_37;
        if (if-ltz(HitBoxY)) goto L_37;
        if (if-gtz(HitBoxY)) goto L_37;
      L_37:
        return 1;
    }

    public boolean SetDisplaySettings(EOSOverlayWebviewDisplaySettings p0) {
        DisplaySettings = p0;
        return 1;
    }

    public void destroy() {
        WebView.destroy();
        EOSOverlayWebView.getParent();
        if (if-eqz(EOSOverlayWebView.getParent(..))) goto L_12;
        EOSOverlayWebView.getParent();
        EOSOverlayWebView.getParent(..).removeView(this);
      L_12:
        return;
    }

    public boolean onTouchEvent(MotionEvent p0) {
        p0.getX();
        p0.getY();
        EOSOverlayWebView.isWithinDisplaySettingsHitBox(MotionEvent.getX(..), 0.5f);
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" onTouchEvent, isWithinHitBox: ");
        new StringBuilder(..).append(EOSOverlayWebView.isWithinDisplaySettingsHitBox(..));
        new StringBuilder(..).append(", isEnabled: ");
        EOSOverlayWebView.isEnabled();
        new StringBuilder(..).append(EOSOverlayWebView.isEnabled(..));
        new StringBuilder(..).append(", isClickable: ");
        EOSOverlayWebView.isClickable();
        new StringBuilder(..).append(EOSOverlayWebView.isClickable(..));
        new StringBuilder(..).append(", X: ");
        new StringBuilder(..).append(MotionEvent.getX(..));
        new StringBuilder(..).append(", Y: ");
        new StringBuilder(..).append(0.5f);
        new StringBuilder(..).append(", Density: ");
        new StringBuilder(..).append(Density);
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.VeryVerbose(StringBuilder.toString(..));
        if (if-eqz(EOSOverlayWebView.isWithinDisplaySettingsHitBox(..))) goto L_7a;
        EOSOverlayWebView.isEnabled();
        if (if-eqz(EOSOverlayWebView.isEnabled(..))) goto L_7a;
        EOSOverlayWebView.isClickable();
        if (if-eqz(EOSOverlayWebView.isClickable(..))) goto L_7a;
        WebView.onTouchEvent(p0);
        return WebView.onTouchEvent(..);
      L_7a:
        return 0;
    }

    public boolean performClick() {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" performClick, isEnabled: ");
        EOSOverlayWebView.isEnabled();
        new StringBuilder(..).append(EOSOverlayWebView.isEnabled(..));
        new StringBuilder(..).append(", isClickable: ");
        EOSOverlayWebView.isClickable();
        new StringBuilder(..).append(EOSOverlayWebView.isClickable(..));
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.VeryVerbose(StringBuilder.toString(..));
        EOSOverlayWebView.isEnabled();
        if (if-eqz(EOSOverlayWebView.isEnabled(..))) goto L_3c;
        EOSOverlayWebView.isClickable();
        if (if-eqz(EOSOverlayWebView.isClickable(..))) goto L_3c;
        WebView.performClick();
        return WebView.performClick(..);
      L_3c:
        return 0;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlayWebViewClient
// ============================================================
package com.epicgames.mobile.eossdk;

class EOSOverlayWebViewClient extends WebViewClient {
    private final EOSOverlayWebViewClientDelegate Delegate;
    public final EOSOverlayId OverlayId;

    public EOSOverlayWebViewClient(EOSOverlayId p0, EOSOverlayWebViewClientDelegate p1) {
        new WebViewClient();
        OverlayId = p0;
        Delegate = p1;
        return;
    }

    public void onLoadResource(WebView p0, String p1) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayWebViewClient.onLoadResource, URL: ");
        EOSLog.Redact(p1);
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.VeryVerbose(StringBuilder.toString(..));
        WebViewClient.onLoadResource(p0, p1);
        return;
    }

    public void onPageFinished(WebView p0, String p1) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayWebViewClient.onPageFinished, URL: ");
        EOSLog.Redact(p1);
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.Log(StringBuilder.toString(..));
        WebViewClient.onPageFinished(p0, p1);
        p0.getProgress();
        if (if-lt(WebView.getProgress(..), 100)) goto L_3c;
        EOSOverlay.OnBrowserStatusChange(InstanceId, 100, BrowserId, StringBuilder.toString(..), EOSOverlay$BrowserStatus.END_LOAD);
        Delegate.onPageFinished();
      L_3c:
        return;
    }

    public void onPageStarted(WebView p0, String p1, Bitmap p2) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayWebViewClient.onPageStarted, URL: ");
        EOSLog.Redact(p1);
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).toString();
        EOSLog.OverlayInternal.Log(StringBuilder.toString(..));
        WebViewClient.onPageStarted(p0, p1, p2);
        Delegate.onPageStarted();
        EOSOverlay.OnBrowserStatusChange(InstanceId, p1, BrowserId, StringBuilder.toString(..), EOSOverlay$BrowserStatus.BEGIN_LOAD);
        return;
    }

    public void onReceivedError(WebView p0, WebResourceRequest p1, WebResourceError p2) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayWebViewClient.onReceivedError, IsMainFrame: ");
        p1.isForMainFrame();
        new StringBuilder(..).append(WebResourceRequest.isForMainFrame(..));
        new StringBuilder(..).append(", Request URL: ");
        p1.getUrl();
        WebResourceRequest.getUrl(..).toString();
        EOSLog.Redact(Uri.toString(..));
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).append(", Error Code: ");
        p2.getErrorCode();
        EOSLog.RedactInt(WebResourceError.getErrorCode(..), v3);
        new StringBuilder(..).append(EOSLog.RedactInt(..));
        new StringBuilder(..).append(", Error: ");
        p2.getDescription();
        WebResourceError.getDescription(..).toString();
        EOSLog.Redact(CharSequence.toString(..));
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
        WebViewClient.onReceivedError(p0, p1, p2);
        p1.isForMainFrame();
        if (if-eqz(WebResourceRequest.isForMainFrame(..))) goto L_6e;
        EOSOverlay.OnBrowserStatusChange(InstanceId, p1, BrowserId, StringBuilder.toString(..), EOSOverlay$BrowserStatus.LOAD_ERROR);
      L_6e:
        return;
    }

    public void onReceivedHttpError(WebView p0, WebResourceRequest p1, WebResourceResponse p2) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayWebViewClient.onReceivedHttpError, IsMainFrame: ");
        p1.isForMainFrame();
        new StringBuilder(..).append(WebResourceRequest.isForMainFrame(..));
        new StringBuilder(..).append(", Request URL: ");
        p1.getUrl();
        WebResourceRequest.getUrl(..).toString();
        EOSLog.Redact(Uri.toString(..));
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).append(", Error Status Code: ");
        p2.getStatusCode();
        EOSLog.RedactInt(WebResourceResponse.getStatusCode(..), v3);
        new StringBuilder(..).append(EOSLog.RedactInt(..));
        new StringBuilder(..).append(", Error: ");
        p2.getReasonPhrase();
        EOSLog.Redact(WebResourceResponse.getReasonPhrase(..));
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        WebViewClient.onReceivedHttpError(p0, p1, p2);
        p1.isForMainFrame();
        if (if-eqz(WebResourceRequest.isForMainFrame(..))) goto L_6a;
        EOSOverlay.OnBrowserStatusChange(InstanceId, p1, BrowserId, StringBuilder.toString(..), EOSOverlay$BrowserStatus.LOAD_ERROR);
      L_6a:
        return;
    }

    public void onReceivedSslError(WebView p0, SslErrorHandler p1, SslError p2) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayWebViewClient.onReceivedSslError, URL: ");
        p2.getUrl();
        EOSLog.Redact(SslError.getUrl(..));
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).append(", Primary Error: ");
        p2.getPrimaryError();
        EOSLog.RedactInt(SslError.getPrimaryError(..), v2);
        new StringBuilder(..).append(EOSLog.RedactInt(..));
        new StringBuilder(..).append(", Error: ");
        p2.toString();
        EOSLog.Redact(SslError.toString(..));
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        p1.cancel();
        return;
    }

    public boolean onRenderProcessGone(WebView p0, RenderProcessGoneDetail p1) {
        new StringBuilder();
        new StringBuilder(..).append(OverlayId);
        new StringBuilder(..).append(" EOSOverlayWebViewClient.onRenderProcessGone, Browser termination unexpected. Sending crashed status, Detail: ");
        p1.toString();
        EOSLog.Redact(Object.toString(..));
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).append(", ");
        p1.didCrash();
        if (if-eqz(RenderProcessGoneDetail.didCrash(..))) goto L_2a;
      L_2a:
      L_2c:
        new StringBuilder(..).append("OOM");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        WebViewClient.onRenderProcessGone(p0, p1);
        Delegate.onRenderProcessGone();
        return 1;
    }

    public boolean shouldOverrideUrlLoading(WebView p0, WebResourceRequest p1) {
        return 0;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlayWebViewClientDelegate
// ============================================================
package com.epicgames.mobile.eossdk;

public abstract class EOSOverlayWebViewClientDelegate {
    public abstract void onPageFinished() {
        // native or abstract
    }

    public abstract void onPageStarted() {
        // native or abstract
    }

    public abstract void onRenderProcessGone() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlayWebviewDisplaySettings
// ============================================================
package com.epicgames.mobile.eossdk;

public class EOSOverlayWebviewDisplaySettings {
    public float HitBoxHeight;
    public float HitBoxWidth;
    public float HitBoxX;
    public float HitBoxY;
    public int ZIndex;
    public boolean bEnableExclusiveInputMode;
    public boolean bHasCloseButton;
    public boolean bHasDarkenedBackground;
    public boolean bHitBox;
    public boolean bIsVisible;
    public boolean bUseSafeArea;

    public EOSOverlayWebviewDisplaySettings() {
        new Object();
        ZIndex = 0;
        bHasCloseButton = 1;
        bHasDarkenedBackground = 1;
        bIsVisible = 1;
        bEnableExclusiveInputMode = 1;
        bHitBox = 0;
        HitBoxX = 0;
        HitBoxY = 0;
        HitBoxWidth = 0;
        HitBoxHeight = 0;
        bUseSafeArea = 0;
        return;
    }

    public String toString() {
        new StringBuilder("EOSOverlayWebviewDisplaySettings{ZIndex=");
        new StringBuilder(..).append(ZIndex);
        new StringBuilder(..).append(", bHasCloseButton=");
        new StringBuilder(..).append(bHasCloseButton);
        new StringBuilder(..).append(", bHasDarkenedBackground=");
        new StringBuilder(..).append(bHasDarkenedBackground);
        new StringBuilder(..).append(", bIsVisible=");
        new StringBuilder(..).append(bIsVisible);
        new StringBuilder(..).append(", bEnableExclusiveInputMode=");
        new StringBuilder(..).append(bEnableExclusiveInputMode);
        new StringBuilder(..).append(", bHitBox=");
        new StringBuilder(..).append(bHitBox);
        new StringBuilder(..).append(", HitBoxX=");
        new StringBuilder(..).append(HitBoxX);
        new StringBuilder(..).append(", HitBoxY=");
        new StringBuilder(..).append(HitBoxY);
        new StringBuilder(..).append(", HitBoxWidth=");
        new StringBuilder(..).append(HitBoxWidth);
        new StringBuilder(..).append(", HitBoxHeight=");
        new StringBuilder(..).append(HitBoxHeight);
        new StringBuilder(..).append(", bUseSafeArea=");
        new StringBuilder(..).append(bUseSafeArea);
        new StringBuilder(..).append(125);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlayWidgetManager
// ============================================================
package com.epicgames.mobile.eossdk;

public final class EOSOverlayWidgetManager {
    private final ConcurrentHashMap Browsers;
    private final ConcurrentHashMap CallbackBrowsers;
    private final AtomicLong NextJavascriptCallbackId;

    public EOSOverlayWidgetManager() {
        new Object();
        new ConcurrentHashMap();
        Browsers = new ConcurrentHashMap(..);
        new AtomicLong();
        NextJavascriptCallbackId = new AtomicLong(..);
        new ConcurrentHashMap();
        CallbackBrowsers = new ConcurrentHashMap(..);
        return;
    }

    private EOSOverlayBrowser NewBrowser(EOSOverlayId p0, String p1, String p2, EOSOverlayWebviewDisplaySettings p3) {
        EOSOverlayWidgetManager.FindBrowser(p0);
        if (if-eqz(EOSOverlayWidgetManager.FindBrowser(..))) goto L_2a;
        new StringBuilder();
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" EOSOverlayWidgetManager.NewBrowser, Received LoadURL request with browser already open. Closing existing browser, URL: ");
        EOSLog.Redact(p1);
        new StringBuilder(..).append(EOSLog.Redact(..));
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
        EOSOverlayBrowser.EndWebview(0);
        EOSOverlayWidgetManager.UnregisterBrowser(EOSOverlayWidgetManager.FindBrowser(..));
      L_2a:
        EOSSDK.GetActivity();
        new EOSOverlayBrowser(EOSSDK.GetActivity(..), p0, p2, p3);
        EOSOverlayWidgetManager.RegisterBrowser(new EOSOverlayBrowser(..), p0);
        if (if-nez(EOSOverlayWidgetManager.RegisterBrowser(..))) goto L_4f;
        new StringBuilder();
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" EOSOverlayWidgetManager.NewBrowser, Failed to create new Browser");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
      L_4f:
        return new EOSOverlayBrowser(..);
    }

    public void EndWebview(EOSOverlayId p0, long p1) {
        new EOSOverlayWidgetManager$$ExternalSyntheticLambda0(this, p0);
        new FutureTask(new EOSOverlayWidgetManager$$ExternalSyntheticLambda0(..));
        EOSSDK.GetActivity();
        EOSSDK.GetActivity(..).runOnUiThread(new FutureTask(..));
        return;
    }

    public void EvaluateJS(EOSOverlayId p0, long p1, String p2) {
        new EOSOverlayWidgetManager$$ExternalSyntheticLambda1(this, p0, p1, v5, p2);
        new FutureTask(new EOSOverlayWidgetManager$$ExternalSyntheticLambda1);
        EOSSDK.GetActivity();
        EOSSDK.GetActivity(..).runOnUiThread(new FutureTask(..));
        return;
    }

    public EOSOverlayBrowser FindBrowser(EOSOverlayId p0) {
        Browsers.get(p0);
        return ConcurrentHashMap.get(..);
    }

    public EOSOverlayWebviewDisplaySettings GetDisplaySettings(EOSOverlayId p0) {
        EOSOverlayWidgetManager.FindBrowser(p0);
        if (if-nez(EOSOverlayWidgetManager.FindBrowser(..))) goto L_1e;
        new StringBuilder();
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" EOSOverlayWidgetManager.GetDisplaySettings, No such browser can be found");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
        return 0;
      L_1e:
        EOSLog.Overlay.GetDisplaySettings();
        return EOSOverlayBrowser.GetDisplaySettings(..);
    }

    public long GetNextJavascriptCallbackId() {
        NextJavascriptCallbackId.getAndIncrement();
        return AtomicLong.getAndIncrement(..);
    }

    public void InvokeJavascriptCallback(String p0, long p1, long p2, boolean p3) {
        new EOSOverlayWidgetManager$$ExternalSyntheticLambda3(this, p2, v4, p1, v6, p0, p3);
        new FutureTask(new EOSOverlayWidgetManager$$ExternalSyntheticLambda3);
        EOSSDK.GetActivity();
        EOSSDK.GetActivity(..).runOnUiThread(new FutureTask(..));
        return;
    }

    public void LoadURL(EOSOverlayId p0, String p1, String[] p2, String p3, EOSOverlayWebviewDisplaySettings p4) {
        if (if-nez(p4)) goto L_18;
        new StringBuilder();
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" EOSOverlayWidgetManager.LoadURL: no DisplaySettings, creating default ones instead");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
      L_18:
        if (if-eqz(p4)) goto L_1b;
      L_1b:
        new EOSOverlayWebviewDisplaySettings();
      L_20:
        new EOSOverlayWidgetManager$$ExternalSyntheticLambda2(this, p0, p1, p3, new EOSOverlayWebviewDisplaySettings(..), p2);
        new FutureTask(new EOSOverlayWidgetManager$$ExternalSyntheticLambda2);
        EOSSDK.GetActivity();
        EOSSDK.GetActivity(..).runOnUiThread(new FutureTask(..));
        return;
    }

    public void OnExecuteJavascriptFunction(EOSOverlayId p0, long p1, String p2) {
        EOSOverlayWidgetManager.StoreOverlayIdForCallback(p0, p1, v5);
        if (if-nez(EOSOverlayWidgetManager.StoreOverlayIdForCallback(..))) goto L_31;
        new StringBuilder();
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" EOSOverlayWidgetManager.OnExecuteJavascriptFunction, StoreOverlayIdForCallback failed, CallbackId: ");
        new StringBuilder(..).append(p1, v5);
        new StringBuilder(..).append(", \n");
        new Exception();
        Log.getStackTraceString(new Exception(..));
        new StringBuilder(..).append(Log.getStackTraceString(..));
        new StringBuilder(..).toString();
        EOSLog.Overlay.Error(StringBuilder.toString(..));
        return;
      L_31:
        EOSOverlay.OnExecuteJavascriptFunction(InstanceId, v5, BrowserId, v1, EOSLog.Overlay);
        return;
    }

    public boolean RegisterBrowser(EOSOverlayBrowser p0, EOSOverlayId p1) {
        Browsers.putIfAbsent(p1, p0);
        if (if-nez(ConcurrentHashMap.putIfAbsent(..))) goto L_a;
      L_a:
      L_b:
        return 0;
    }

    public EOSOverlayId RetrieveOverlayIdForCallback(long p0) {
        Long.valueOf(p0, v3);
        CallbackBrowsers.remove(Long.valueOf(..));
        return ConcurrentHashMap.remove(..);
    }

    public boolean SetDisplaySettings(EOSOverlayId p0, EOSOverlayWebviewDisplaySettings p1) {
        if (if-nez(p1)) goto L_1d;
        new StringBuilder();
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" EOSOverlayWidgetManager.SetDisplaySettings: no DisplaySettings, creating default ones instead");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
        new EOSOverlayWebviewDisplaySettings();
      L_1d:
        EOSOverlayWidgetManager.FindBrowser(p0);
        if (if-nez(EOSOverlayWidgetManager.FindBrowser(..))) goto L_3b;
        new StringBuilder();
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" EOSOverlayWidgetManager.SetDisplaySettings, No such browser can be found");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
        return 0;
      L_3b:
        new StringBuilder(..).SetDisplaySettings(EOSLog.Overlay);
        return 1;
    }

    public boolean StoreOverlayIdForCallback(EOSOverlayId p0, long p1) {
        Long.valueOf(p1, v4);
        CallbackBrowsers.putIfAbsent(Long.valueOf(..), p0);
        if (if-nez(ConcurrentHashMap.putIfAbsent(..))) goto L_e;
      L_e:
      L_f:
        return 0;
    }

    public boolean UnregisterBrowser(EOSOverlayBrowser p0) {
        Browsers.remove(OverlayId);
        if (if-eqz(ConcurrentHashMap.remove(..))) goto L_c;
      L_c:
      L_d:
        return 0;
    }

    Void lambda$EndWebview$1$com-epicgames-mobile-eossdk-EOSOverlayWidgetManager(EOSOverlayId p0) {
        EOSOverlayWidgetManager.FindBrowser(p0);
        if (if-nez(EOSOverlayWidgetManager.FindBrowser(..))) goto L_1e;
        new StringBuilder();
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" EOSOverlayWidgetManager.EndWebview, No such browser can be found");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
        return 0;
      L_1e:
        EOSLog.Overlay.EndWebview(0);
        EOSOverlayWidgetManager.UnregisterBrowser(EOSLog.Overlay);
        return 0;
    }

    Boolean lambda$EvaluateJS$2$com-epicgames-mobile-eossdk-EOSOverlayWidgetManager(EOSOverlayId p0, long p1, String p2) {
        EOSOverlayWidgetManager.FindBrowser(p0);
        if (if-nez(EOSOverlayWidgetManager.FindBrowser(..))) goto L_25;
        new StringBuilder();
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" EOSOverlayWidgetManager.EvaluateJS, Eval JS Failed because no such browser can be found, RequestId: ");
        new StringBuilder(..).append(p1, v4);
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
        Boolean.valueOf(0);
        return Boolean.valueOf(..);
      L_25:
        new StringBuilder(..).EvaluateJS(p1, v4, 1, EOSLog.Overlay);
        Boolean.valueOf(EOSOverlayBrowser.EvaluateJS(..));
        return Boolean.valueOf(..);
    }

    Boolean lambda$InvokeJavascriptCallback$3$com-epicgames-mobile-eossdk-EOSOverlayWidgetManager(long p0, long p1, String p2, boolean p3) {
        EOSOverlayWidgetManager.RetrieveOverlayIdForCallback(p0, v6);
        Boolean.valueOf(0);
        if (if-nez(EOSOverlayWidgetManager.RetrieveOverlayIdForCallback(..))) goto L_29;
        new StringBuilder();
        EOSOverlayId.UnknownBrowserIdString(p1, v8);
        new StringBuilder(..).append(EOSOverlayId.UnknownBrowserIdString(..));
        new StringBuilder(..).append("EOSOverlayWidgetManager.InvokeJavascriptCallback, No such callback can be found, CallbackId: ");
        new StringBuilder(..).append(p0, v6);
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
        return Boolean.valueOf(..);
      L_29:
        if (if-eqz(InstanceId)) goto L_55;
        new StringBuilder();
        EOSOverlayId.UnknownBrowserIdString("EOSOverlayWidgetManager.InvokeJavascriptCallback, No such callback can be found, CallbackId: ", v8);
        new StringBuilder(..).append(EOSOverlayId.UnknownBrowserIdString(..));
        new StringBuilder(..).append("EOSOverlayWidgetManager.InvokeJavascriptCallback, Mismatch between stored InstanceId and calling InstanceId, Stored OverlayId: ");
        new StringBuilder(..).append(EOSOverlayWidgetManager.RetrieveOverlayIdForCallback(..));
        new StringBuilder(..).append(", CallbackId: ");
        new StringBuilder(..).append(StringBuilder.toString(..), v6);
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
        return Boolean.valueOf(..);
      L_55:
        EOSOverlayWidgetManager.FindBrowser(EOSOverlayWidgetManager.RetrieveOverlayIdForCallback(..));
        if (if-nez(EOSOverlayWidgetManager.FindBrowser(..))) goto L_72;
        new StringBuilder();
        new StringBuilder(..).append(EOSOverlayWidgetManager.RetrieveOverlayIdForCallback(..));
        new StringBuilder(..).append(" EOSOverlayWidgetManager.InvokeJavascriptCallback, No such browser can be found");
        new StringBuilder(..).toString();
        EOSLog.Overlay.Warning(StringBuilder.toString(..));
        return Boolean.valueOf(..);
      L_72:
        EOSOverlayBrowser.InvokeJavascriptCallback(EOSLog.Overlay, EOSLog.Overlay, StringBuilder.toString(..), new StringBuilder(..));
        Boolean.valueOf(EOSOverlayBrowser.InvokeJavascriptCallback(..));
        return Boolean.valueOf(..);
    }

    Void lambda$LoadURL$0$com-epicgames-mobile-eossdk-EOSOverlayWidgetManager(EOSOverlayId p0, String p1, String p2, EOSOverlayWebviewDisplaySettings p3, String[] p4) {
        EOSOverlayWidgetManager.NewBrowser(p0, p1, p2, p3);
        EOSOverlayBrowser.LoadURL(p1, p4, p3);
        return 0;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSPreferences
// ============================================================
package com.epicgames.mobile.eossdk;

public class EOSPreferences {
    private static final String OVERLAY_ENABLED_FOR_NEXT_LAUNCH_KEY = "EOSSDK.OverlayEnabledForNextLaunch";

    public EOSPreferences() {
        new Object();
        return;
    }

    public static boolean GetEnabledForNextLaunch() {
        EOSPreferences.GetSharedPreferences();
        SharedPreferences.getBoolean("EOSSDK.OverlayEnabledForNextLaunch", 1);
        return SharedPreferences.getBoolean(..);
    }

    private static SharedPreferences GetSharedPreferences() {
        EOSSDK.GetApplicationContext();
        new StringBuilder();
        EOSSDK.GetApplicationContext(..).getPackageName();
        new StringBuilder(..).append(Context.getPackageName(..));
        new StringBuilder(..).append("_eos");
        new StringBuilder(..).toString();
        EOSSDK.GetApplicationContext(..).getSharedPreferences(StringBuilder.toString(..), 0);
        return Context.getSharedPreferences(..);
    }

    public static void SetEnabledForNextLaunch(boolean p0) {
        EOSPreferences.GetSharedPreferences();
        SharedPreferences.edit();
        SharedPreferences.edit(..).putBoolean("EOSSDK.OverlayEnabledForNextLaunch", p0);
        SharedPreferences.edit(..).apply();
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSSDK
// ============================================================
package com.epicgames.mobile.eossdk;

public class EOSSDK {
    public static final String AuthKey = "AuthKey";
    public static final String AuthKeyTime = "AuthKeyTime";
    public static String EOSUserAgent = null;
    static final String KEYCHAIN_PREFS_FILENAME = "EOS_KeychainPreferences";
    static WebView loginWebView;
    static Activity mActivity;
    static final Application$ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    static final CustomTabsServiceConnection mConnection;
    static Context mContext;
    static CustomTabsClient mCustomTabsClient;
    static CustomTabsIntent mCustomTabsIntent;
    static CustomTabsSession mCustomTabsSession;
    static LoginState mLoginState;
    private static String sPackageNameToUse;

    static <clinit>() {
        mLoginState = LoginState.NONE;
        EOSUserAgent = "Unknown";
        new EOSSDK$1();
        mConnection = new EOSSDK$1(..);
        new EOSSDK$2();
        mActivityLifecycleCallbacks = new EOSSDK$2(..);
        return;
    }

    public EOSSDK() {
        new Object();
        return;
    }

    static void CacheLoginData() {
        EOSSDK.Keychain_WriteValue("AuthKey", EOSAuthHandlerActivity.LoginData);
        String.valueOf(EOSAuthHandlerActivity.LoginDataTimestamp, EOSAuthHandlerActivity.LoginData);
        EOSSDK.Keychain_WriteValue("AuthKeyTime", String.valueOf(..));
        EOSAuthHandlerActivity.ResetData();
        return;
    }

    static void CancelLogin() {
        if (if-ne(EOSSDK.mLoginState, LoginState.IN_PROGRESS)) goto L_f;
        mLoginState = LoginState.CANCELED;
        EOSSDK.auth("auth?error=cancelled");
      L_f:
        return;
    }

    static void CompleteLogin(String p0) {
        if (if-ne(EOSSDK.mLoginState, LoginState.IN_PROGRESS)) goto L_d;
        mLoginState = LoginState.COMPLETED;
        EOSSDK.auth(p0);
      L_d:
        return;
    }

    public static Activity GetActivity() {
        return EOSSDK.mActivity;
    }

    public static Context GetApplicationContext() {
        return EOSSDK.mContext;
    }

    static String GetCachedLoginData() {
        EOSSDK.Keychain_ReadValue("AuthKey");
        return EOSSDK.Keychain_ReadValue(..);
    }

    public static String GetOSVersion() {
        return Build$VERSION.RELEASE;
    }

    static boolean HasCachedLoginData() {
        EOSSDK.Keychain_ReadValue("AuthKeyTime");
        if (if-eqz(EOSSDK.Keychain_ReadValue(..))) goto L_2b;
        EOSSDK.Keychain_ReadValue(..).isEmpty();
        if (if-eqz(String.isEmpty(..))) goto L_10;
      L_10:
        new Date();
        new Date(..).getTime();
        Long.parseLong(EOSSDK.Keychain_ReadValue(..));
        if (if-lez(EOSSDK.Keychain_ReadValue(..))) goto L_29;
        EOSSDK.ResetCachedLoginData();
        return 0;
      L_29:
        return 1;
      L_2b:
        return 0;
    }

    public static String Keychain_ReadValue(String p0) {
        MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
        EncryptedSharedPreferences.create("EOS_KeychainPreferences", MasterKeys.getOrCreate(..), EOSSDK.mActivity, EncryptedSharedPreferences$PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences$PrefValueEncryptionScheme.AES256_GCM);
        SharedPreferences.getString(p0, "");
        return SharedPreferences.getString(..);
        new StringBuilder("Keychain ReadValue failed. ");
        SharedPreferences.getString(..).getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
        EOSLog.EosInternal.Error(StringBuilder.toString(..));
        return "";
    }

    public static boolean Keychain_WriteValue(String p0, String p1) {
        MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
        EncryptedSharedPreferences.create("EOS_KeychainPreferences", MasterKeys.getOrCreate(..), EOSSDK.mActivity, EncryptedSharedPreferences$PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences$PrefValueEncryptionScheme.AES256_GCM);
        SharedPreferences.edit();
        SharedPreferences.edit(..).putString(p0, p1);
        SharedPreferences$Editor.commit();
        return SharedPreferences$Editor.commit(..);
        new StringBuilder("Keychain WriteValue failed. ");
        SharedPreferences$Editor.commit(..).getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
        EOSLog.EosInternal.Error(StringBuilder.toString(..));
        return 0;
    }

    public static long LaunchURL(String p0) {
        p0.startsWith("https://");
        if (if-nez(String.startsWith(..))) goto L_19;
        EOSLog.Eos.Error("Invalid URL format");
        LaunchUrlResult.INVALID_URL.Value();
      L_17:
        return "Invalid URL format";
      L_19:
        mLoginState = LoginState.IN_PROGRESS;
        EOSSDK.isOculus();
        EOSSDK.HasCachedLoginData();
        if (if-eqz(EOSSDK.HasCachedLoginData(..))) goto L_31;
        EOSSDK.GetCachedLoginData();
        EOSSDK.CompleteLogin(EOSSDK.GetCachedLoginData(..));
        EOSSDK.ResetCachedLoginData();
      L_31:
        if (if-eqz(EOSSDK.mCustomTabsIntent)) goto L_3f;
        Uri.parse(EOSSDK.GetCachedLoginData(..));
        EOSSDK.mCustomTabsIntent.launchUrl(EOSSDK.mActivity, Uri.parse(..));
      L_3f:
        Uri.parse(Uri.parse(..));
        new Intent("android.intent.action.VIEW", Uri.parse(..));
        new Intent(..).addFlags(512.0f);
        new Intent(..).addFlags(1);
        new Intent(..).addFlags(0x18000000);
        EOSSDK.mActivity.getPackageManager();
        new Intent(..).resolveActivity(Activity.getPackageManager(..));
        if (if-nez(Intent.resolveActivity(..))) goto L_73;
        EOSLog.Eos.Error("No browser found for intent");
        LaunchUrlResult.Value();
        return "No browser found for intent";
      L_73:
        LaunchUrlResult.Value(..).getClassName();
        ComponentName.getClassName(..).endsWith("ForwardIntentToParent");
        if (if-eqz(String.endsWith(..))) goto L_a0;
        Process.myUid();
        new StringBuilder("No browser found for intent");
        new StringBuilder(..).append(Process.myUid(..));
        new StringBuilder(..).toString();
        EOSLog.Eos.Error(StringBuilder.toString(..));
        LaunchUrlResult.Value();
        return "No browser found for intent";
      L_a0:
        EOSSDK.mActivity.startActivity(EOSLog.Eos);
      L_a5:
        LaunchUrlResult.SUCCESS.Value();
        return "No browser found for intent";
        new StringBuilder("Error launching URL. ");
        LaunchUrlResult.Value(..).getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
        EOSLog.Eos.Error(StringBuilder.toString(..));
        LaunchUrlResult.GENERIC_EXCEPTION.Value();
        new StringBuilder("Activity not found. ");
        LaunchUrlResult.Value(..).getMessage();
        new StringBuilder(..).append(ActivityNotFoundException.getMessage(..));
        new StringBuilder(..).toString();
        EOSLog.Eos.Error(StringBuilder.toString(..));
        LaunchUrlResult.Value();
    }

    public static long PrewarmURL(String p0) {
        if (if-nez(EOSSDK.mCustomTabsSession)) goto L_13;
        EOSLog.Eos.Error("No Custom Tab Session available");
        LaunchUrlResult.CUSTOM_TAB_EXCEPTION.Value();
      L_11:
        return "No Custom Tab Session available";
      L_13:
        Uri.parse(LaunchUrlResult.Value(..));
        "No Custom Tab Session available".mayLaunchUrl(Uri.parse(..), 0, 0);
        if (if-eqz(CustomTabsSession.mayLaunchUrl(..))) goto L_23;
      L_23:
      L_25:
        EOSLog.Eos.Log("Failed to prewarm URL");
        EOSSDK.mActivity.getResources();
        new CustomTabColorSchemeParams$Builder();
        Color.parseColor("#272727");
        CustomTabColorSchemeParams$Builder.setToolbarColor(Color.parseColor(..));
        CustomTabColorSchemeParams$Builder.build();
        new CustomTabsIntent$Builder(EOSSDK.mCustomTabsSession);
        new CustomTabsIntent$Builder(..).setDefaultColorSchemeParams(CustomTabColorSchemeParams$Builder.build(..));
        CustomTabsIntent$Builder.setShowTitle(1);
        CustomTabsIntent$Builder.build();
        mCustomTabsIntent = CustomTabsIntent$Builder.build(..);
        intent.addFlags(604012544);
        new StringBuilder("android-app://");
        EOSSDK.mActivity.getPackageName();
        new StringBuilder(..).append(Activity.getPackageName(..));
        new StringBuilder(..).toString();
        Uri.parse(StringBuilder.toString(..));
        intent.putExtra("android.intent.extra.REFERRER", Uri.parse(..));
        LaunchUrlResult.SUCCESS.Value();
    }

    static void ResetCachedLoginData() {
        EOSSDK.Keychain_WriteValue("AuthKey", "");
        EOSSDK.Keychain_WriteValue("AuthKeyTime", "");
        return;
    }

    public static void auth(String p0) {
        // native or abstract
    }

    public static int getDeviceOrientation() {
        EOSSDK.mActivity.getResources();
        Activity.getResources(..).getConfiguration();
        return orientation;
    }

    static String getPackageNameToUse() {
        if (if-eqz(EOSSDK.sPackageNameToUse)) goto L_5;
        return EOSSDK.sPackageNameToUse;
      L_5:
        new Intent();
        new Intent(..).setAction("android.intent.action.VIEW");
        Intent.setAction(..).addCategory("android.intent.category.BROWSABLE");
        Uri.fromParts("http", "", 0);
        Intent.addCategory(..).setData(Uri.fromParts(..));
        EOSSDK.getResolveInfoList(Intent.setData(..), 0x10000);
        EOSSDK.getResolveInfoList(..).isEmpty();
        if (if-eqz(List.isEmpty(..))) goto L_34;
        EOSSDK.getResolveInfoList(Intent.setData(..), 0);
      L_34:
        new ArrayList();
        EOSSDK.getResolveInfoList(..).iterator();
      L_3d:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_68;
        List.iterator(..).next();
        new Intent();
        new Intent(..).setAction("android.support.customtabs.action.CustomTabsService");
        new Intent(..).setPackage(packageName);
        EOSSDK.resolveService(new Intent(..));
        if (if-eqz(EOSSDK.resolveService(..))) goto L_3d;
        new ArrayList(..).add(packageName);
      L_68:
        new ArrayList(..).isEmpty();
        if (if-eqz(List.isEmpty(..))) goto L_71;
        sPackageNameToUse = 0;
      L_71:
        new ArrayList(..).get(0);
        sPackageNameToUse = List.get(..);
      L_79:
        return EOSSDK.sPackageNameToUse;
    }

    static List getResolveInfoList(Intent p0, int p1) {
        EOSSDK.mActivity.getPackageManager();
        if (if-lt(Build$VERSION.SDK_INT, 33)) goto L_16;
        PackageManager$ResolveInfoFlags.of(Build$VERSION.SDK_INT, 33);
        Activity.getPackageManager(..).queryIntentActivities(p0, PackageManager$ResolveInfoFlags.of(..));
        return PackageManager.queryIntentActivities(..);
      L_16:
        EOSSDK.getResolveInfoListDeprecated(PackageManager.queryIntentActivities(..), PackageManager$ResolveInfoFlags.of(..));
        return EOSSDK.getResolveInfoListDeprecated(..);
    }

    static List getResolveInfoListDeprecated(Intent p0, int p1) {
        EOSSDK.mActivity.getPackageManager();
        Activity.getPackageManager(..).queryIntentActivities(p0, p1);
        return PackageManager.queryIntentActivities(..);
    }

    public static void init(Activity p0) {
        mActivity = p0;
        p0.getApplicationContext();
        mContext = Activity.getApplicationContext(..);
        EOSSDK.initCustomTabClient();
        EOSSDK.mActivity.getApplication();
        if (if-eqz(Activity.getApplication(..))) goto L_1b;
        Activity.getApplication(..).unregisterActivityLifecycleCallbacks(EOSSDK.mActivityLifecycleCallbacks);
        Activity.getApplication(..).registerActivityLifecycleCallbacks(EOSSDK.mActivityLifecycleCallbacks);
      L_1b:
        EOSAuthHandlerActivity.LoginData.isEmpty();
        if (if-nez(String.isEmpty(..))) goto L_26;
        EOSSDK.CacheLoginData();
      L_26:
        return;
    }

    static void initCustomTabClient() {
        EOSSDK.getPackageNameToUse();
        if (if-nez(EOSSDK.getPackageNameToUse(..))) goto L_e;
        EOSLog.EosInternal.Log("No package found for binding custom tab service");
      L_e:
        CustomTabsClient.bindCustomTabsService(EOSSDK.mActivity, EOSLog.EosInternal, EOSSDK.mConnection);
        if (if-eqz(CustomTabsClient.bindCustomTabsService(..))) goto L_20;
        EOSLog.EosInternal.Log("Custom tab bind successful");
      L_20:
        EOSLog.EosInternal.Log("Custom tab bind fail");
      L_27:
        return;
    }

    private static boolean isOculus() {
        Class.forName("android.os.SystemProperties");
        Class.forName(..).getMethod("get", v4);
        Class.getMethod(..).invoke(Class.forName(..), 1);
        if (if-eqz(Method.invoke(..))) goto L_33;
        Method.invoke(..).equals("Oculus");
        return String.equals(..);
      L_30:
        Method.invoke(..).printStackTrace();
      L_33:
        return String.equals(..);
    }

    static boolean resolveService(Intent p0) {
        EOSSDK.mActivity.getPackageManager();
        if (if-lt(Build$VERSION.SDK_INT, 33)) goto L_1c;
        PackageManager$ResolveInfoFlags.of(0L, 33);
        Activity.getPackageManager(..).resolveService(p0, PackageManager$ResolveInfoFlags.of(..));
        if (if-eqz(PackageManager.resolveService(..))) goto L_1a;
      L_1a:
      L_1b:
        return 0;
      L_1c:
        EOSSDK.resolverServiceDeprecated(0);
        return EOSSDK.resolverServiceDeprecated(..);
    }

    static boolean resolverServiceDeprecated(Intent p0) {
        EOSSDK.mActivity.getPackageManager();
        Activity.getPackageManager(..).resolveService(p0, 0);
        if (if-eqz(PackageManager.resolveService(..))) goto L_e;
      L_e:
        return 1;
    }

    public static void setUserAgent(String p0) {
        EOSUserAgent = p0;
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.LaunchUrlResult
// ============================================================
package com.epicgames.mobile.eossdk;

final class LaunchUrlResult extends Enum {
    private static final LaunchUrlResult[] $VALUES;
    public static final LaunchUrlResult ACTIVITY_NOT_FOUND_EXCEPTION;
    public static final LaunchUrlResult CUSTOM_TAB_EXCEPTION;
    public static final LaunchUrlResult GENERIC_EXCEPTION;
    public static final LaunchUrlResult INVALID_URL;
    public static final LaunchUrlResult PREWARM_EXCEPTION;
    public static final LaunchUrlResult RESOLVE_ACTIVITY_EXCEPTION;
    public static final LaunchUrlResult SUCCESS;
    private final int _value;

    private static LaunchUrlResult[] $values() {
        return 7;
    }

    static <clinit>() {
        new LaunchUrlResult("SUCCESS", 0, 0);
        SUCCESS = new LaunchUrlResult(..);
        new LaunchUrlResult("INVALID_URL", 1, 1);
        INVALID_URL = new LaunchUrlResult(..);
        new LaunchUrlResult("RESOLVE_ACTIVITY_EXCEPTION", 2, 2);
        RESOLVE_ACTIVITY_EXCEPTION = new LaunchUrlResult(..);
        new LaunchUrlResult("ACTIVITY_NOT_FOUND_EXCEPTION", 3, 3);
        ACTIVITY_NOT_FOUND_EXCEPTION = new LaunchUrlResult(..);
        new LaunchUrlResult("CUSTOM_TAB_EXCEPTION", 4, 4);
        CUSTOM_TAB_EXCEPTION = new LaunchUrlResult(..);
        new LaunchUrlResult("PREWARM_EXCEPTION", 5, 5);
        PREWARM_EXCEPTION = new LaunchUrlResult(..);
        new LaunchUrlResult("GENERIC_EXCEPTION", 6, 6);
        GENERIC_EXCEPTION = new LaunchUrlResult(..);
        LaunchUrlResult.$values();
        $VALUES = LaunchUrlResult.$values(..);
        return;
    }

    private LaunchUrlResult(String p0, int p1, int p2) {
        new Enum(p0, p1);
        _value = p2;
        return;
    }

    public static LaunchUrlResult valueOf(String p0) {
        Enum.valueOf(LaunchUrlResult.class, p0);
        return Enum.valueOf(..);
    }

    public static LaunchUrlResult[] values() {
        LaunchUrlResult.$VALUES.clone();
        return LaunchUrlResult[].clone(..);
    }

    public int Value() {
        return _value;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.LoginState
// ============================================================
package com.epicgames.mobile.eossdk;

final class LoginState extends Enum {
    private static final LoginState[] $VALUES;
    public static final LoginState CANCELED;
    public static final LoginState COMPLETED;
    public static final LoginState IN_PROGRESS;
    public static final LoginState NONE;

    private static LoginState[] $values() {
        return 4;
    }

    static <clinit>() {
        new LoginState("NONE", 0);
        NONE = new LoginState(..);
        new LoginState("IN_PROGRESS", 1);
        IN_PROGRESS = new LoginState(..);
        new LoginState("COMPLETED", 2);
        COMPLETED = new LoginState(..);
        new LoginState("CANCELED", 3);
        CANCELED = new LoginState(..);
        LoginState.$values();
        $VALUES = LoginState.$values(..);
        return;
    }

    private LoginState(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static LoginState valueOf(String p0) {
        Enum.valueOf(LoginState.class, p0);
        return Enum.valueOf(..);
    }

    public static LoginState[] values() {
        LoginState.$VALUES.clone();
        return LoginState[].clone(..);
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSLog$Category
// ============================================================
package com.epicgames.mobile.eossdk;

public final class EOSLog$Category extends Enum {
    private static final EOSLog$Category[] $VALUES;
    public static final EOSLog$Category EOS;
    public static final EOSLog$Category EOS_INTERNAL;
    public static final EOSLog$Category OVERLAY;
    public static final EOSLog$Category OVERLAY_INTERNAL;

    private static EOSLog$Category[] $values() {
        return 4;
    }

    static <clinit>() {
        new EOSLog$Category("EOS", 0);
        EOS = new EOSLog$Category(..);
        new EOSLog$Category("EOS_INTERNAL", 1);
        EOS_INTERNAL = new EOSLog$Category(..);
        new EOSLog$Category("OVERLAY", 2);
        OVERLAY = new EOSLog$Category(..);
        new EOSLog$Category("OVERLAY_INTERNAL", 3);
        OVERLAY_INTERNAL = new EOSLog$Category(..);
        EOSLog$Category.$values();
        $VALUES = EOSLog$Category.$values(..);
        return;
    }

    private EOSLog$Category(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static EOSLog$Category valueOf(String p0) {
        Enum.valueOf(EOSLog$Category.class, p0);
        return Enum.valueOf(..);
    }

    public static EOSLog$Category[] values() {
        EOSLog$Category.$VALUES.clone();
        return EOSLog$Category[].clone(..);
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSLog$IncludeRedactHolder
// ============================================================
package com.epicgames.mobile.eossdk;

final class EOSLog$IncludeRedactHolder {
    static final Boolean bIncludeRedact;

    static <clinit>() {
        EOSLog.IsIncludeRedactEnabled();
        Boolean.valueOf(EOSLog.IsIncludeRedactEnabled(..));
        bIncludeRedact = Boolean.valueOf(..);
        return;
    }

    private EOSLog$IncludeRedactHolder() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSLog$Level
// ============================================================
package com.epicgames.mobile.eossdk;

public final class EOSLog$Level extends Enum {
    private static final EOSLog$Level[] $VALUES;
    public static final EOSLog$Level DISPLAY;
    public static final EOSLog$Level ERROR;
    public static final EOSLog$Level FATAL;
    public static final EOSLog$Level LOG;
    public static final EOSLog$Level VERBOSE;
    public static final EOSLog$Level VERY_VERBOSE;
    public static final EOSLog$Level WARNING;

    private static EOSLog$Level[] $values() {
        return 7;
    }

    static <clinit>() {
        new EOSLog$Level("FATAL", 0);
        FATAL = new EOSLog$Level(..);
        new EOSLog$Level("ERROR", 1);
        ERROR = new EOSLog$Level(..);
        new EOSLog$Level("WARNING", 2);
        WARNING = new EOSLog$Level(..);
        new EOSLog$Level("DISPLAY", 3);
        DISPLAY = new EOSLog$Level(..);
        new EOSLog$Level("LOG", 4);
        LOG = new EOSLog$Level(..);
        new EOSLog$Level("VERBOSE", 5);
        VERBOSE = new EOSLog$Level(..);
        new EOSLog$Level("VERY_VERBOSE", 6);
        VERY_VERBOSE = new EOSLog$Level(..);
        EOSLog$Level.$values();
        $VALUES = EOSLog$Level.$values(..);
        return;
    }

    private EOSLog$Level(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static EOSLog$Level valueOf(String p0) {
        Enum.valueOf(EOSLog$Level.class, p0);
        return Enum.valueOf(..);
    }

    public static EOSLog$Level[] values() {
        EOSLog$Level.$VALUES.clone();
        return EOSLog$Level[].clone(..);
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSLogger$1
// ============================================================
package com.epicgames.mobile.eossdk;

class EOSLogger$1 {
    static final int[] $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Category;
    static final int[] $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Level;

    static <clinit>() {
        EOSLog$Category.values();
        $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Category = EOSLog$Category.values(..);
        EOSLog$Category.EOS.ordinal();
        EOSLog$Category.EOS_INTERNAL.ordinal();
        EOSLog$Category.OVERLAY.ordinal();
        EOSLog$Category.OVERLAY_INTERNAL.ordinal();
        EOSLog$Level.values();
        $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Level = EOSLog$Level.values(..);
        EOSLog$Level.WARNING.ordinal();
        EOSLog$Level.DISPLAY.ordinal();
        EOSLog$Level.LOG.ordinal();
        EOSLog$Level.VERBOSE.ordinal();
        EOSLog$Level.VERY_VERBOSE.ordinal();
        EOSLog$Level.FATAL.ordinal();
        EOSLog$Level.ERROR.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlay$BrowserStatus
// ============================================================
package com.epicgames.mobile.eossdk;

public final class EOSOverlay$BrowserStatus extends Enum {
    private static final EOSOverlay$BrowserStatus[] $VALUES;
    public static final EOSOverlay$BrowserStatus BEGIN_LOAD;
    public static final EOSOverlay$BrowserStatus CLOSED;
    public static final EOSOverlay$BrowserStatus CRASHED;
    public static final EOSOverlay$BrowserStatus END_LOAD;
    public static final EOSOverlay$BrowserStatus LOAD_ERROR;

    private static EOSOverlay$BrowserStatus[] $values() {
        return 5;
    }

    static <clinit>() {
        new EOSOverlay$BrowserStatus("BEGIN_LOAD", 0);
        BEGIN_LOAD = new EOSOverlay$BrowserStatus(..);
        new EOSOverlay$BrowserStatus("END_LOAD", 1);
        END_LOAD = new EOSOverlay$BrowserStatus(..);
        new EOSOverlay$BrowserStatus("LOAD_ERROR", 2);
        LOAD_ERROR = new EOSOverlay$BrowserStatus(..);
        new EOSOverlay$BrowserStatus("CLOSED", 3);
        CLOSED = new EOSOverlay$BrowserStatus(..);
        new EOSOverlay$BrowserStatus("CRASHED", 4);
        CRASHED = new EOSOverlay$BrowserStatus(..);
        EOSOverlay$BrowserStatus.$values();
        $VALUES = EOSOverlay$BrowserStatus.$values(..);
        return;
    }

    private EOSOverlay$BrowserStatus(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static EOSOverlay$BrowserStatus valueOf(String p0) {
        Enum.valueOf(EOSOverlay$BrowserStatus.class, p0);
        return Enum.valueOf(..);
    }

    public static EOSOverlay$BrowserStatus[] values() {
        EOSOverlay$BrowserStatus.$VALUES.clone();
        return EOSOverlay$BrowserStatus[].clone(..);
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSOverlayWebChromeClient$1
// ============================================================
package com.epicgames.mobile.eossdk;

class EOSOverlayWebChromeClient$1 {
    static final int[] $SwitchMap$android$webkit$ConsoleMessage$MessageLevel;

    static <clinit>() {
        ConsoleMessage$MessageLevel.values();
        $SwitchMap$android$webkit$ConsoleMessage$MessageLevel = ConsoleMessage$MessageLevel.values(..);
        ConsoleMessage$MessageLevel.DEBUG.ordinal();
        ConsoleMessage$MessageLevel.TIP.ordinal();
        ConsoleMessage$MessageLevel.LOG.ordinal();
        ConsoleMessage$MessageLevel.WARNING.ordinal();
        ConsoleMessage$MessageLevel.ERROR.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSSDK$1
// ============================================================
package com.epicgames.mobile.eossdk;

class EOSSDK$1 extends CustomTabsServiceConnection {
    EOSSDK$1() {
        new CustomTabsServiceConnection();
        return;
    }

    public void onCustomTabsServiceConnected(ComponentName p0, CustomTabsClient p1) {
        mCustomTabsClient = p1;
        EOSSDK.mCustomTabsClient.warmup(0L, v1);
        if (if-nez(CustomTabsClient.warmup(..))) goto L_13;
        EOSLog.Eos.Warning("Custom Tab Client warmup failed");
      L_13:
        EOSLog.EosInternal.Log("Custom Tab Client warmup successful");
        EOSSDK.mCustomTabsClient.newSession(0);
        mCustomTabsSession = CustomTabsClient.newSession(..);
        if (if-nez(EOSSDK.mCustomTabsSession)) goto L_2f;
        EOSLog.Eos.Error("Custom Tab Session failed");
        return;
      L_2f:
        EOSLog.EosInternal.Log("Custom Tab Session successful");
        return;
    }

    public void onServiceDisconnected(ComponentName p0) {
        EOSLog.EosInternal.Log("Custom Tab service disconnected");
        mCustomTabsClient = 0;
        mCustomTabsSession = 0;
        mCustomTabsIntent = 0;
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSSDK$2
// ============================================================
package com.epicgames.mobile.eossdk;

class EOSSDK$2 {
    EOSSDK$2() {
        new Object();
        return;
    }

    public void onActivityCreated(Activity p0, Bundle p1) {
        return;
    }

    public void onActivityDestroyed(Activity p0) {
        return;
    }

    public void onActivityPaused(Activity p0) {
        return;
    }

    public void onActivityResumed(Activity p0) {
        EOSAuthHandlerActivity.LoginData.isEmpty();
        if (if-nez(String.isEmpty(..))) goto L_b;
        EOSSDK.CacheLoginData();
      L_b:
        EOSSDK.HasCachedLoginData();
        if (if-nez(EOSSDK.HasCachedLoginData(..))) goto L_15;
        EOSSDK.CancelLogin();
      L_15:
        EOSSDK.mLoginState.ordinal();
        if (if-eq(EOSSDK$3.$SwitchMap$com$epicgames$mobile$eossdk$LoginState, 1)) goto L_2d;
        if (if-eq(EOSSDK$3.$SwitchMap$com$epicgames$mobile$eossdk$LoginState, 2)) goto L_37;
        EOSLog.EosInternal.Error("Unhandled case: unknown login state");
      L_2d:
        EOSSDK.GetCachedLoginData();
        EOSSDK.CompleteLogin(EOSSDK.GetCachedLoginData(..));
        EOSSDK.ResetCachedLoginData();
      L_37:
        return;
    }

    public void onActivitySaveInstanceState(Activity p0, Bundle p1) {
        return;
    }

    public void onActivityStarted(Activity p0) {
        return;
    }

    public void onActivityStopped(Activity p0) {
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSSDK$3
// ============================================================
package com.epicgames.mobile.eossdk;

class EOSSDK$3 {
    static final int[] $SwitchMap$com$epicgames$mobile$eossdk$LoginState;

    static <clinit>() {
        LoginState.values();
        $SwitchMap$com$epicgames$mobile$eossdk$LoginState = LoginState.values(..);
        LoginState.IN_PROGRESS.ordinal();
        LoginState.NONE.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.epicgames.mobile.eossdk.EOSSDK$LocalWebViewClient
// ============================================================
package com.epicgames.mobile.eossdk;

class EOSSDK$LocalWebViewClient extends WebViewClient {
    private EOSSDK$LocalWebViewClient() {
        new WebViewClient();
        return;
    }

    EOSSDK$LocalWebViewClient(EOSSDK$1 p0) {
        new EOSSDK$LocalWebViewClient();
        return;
    }

    public boolean shouldOverrideUrlLoading(WebView p0, WebResourceRequest p1) {
        p1.getUrl();
        WebResourceRequest.getUrl(..).toString();
        Uri.toString(..).contains("epic/auth?code=");
        if (if-eqz(String.contains(..))) goto L_23;
        EOSSDK.loginWebView.setVisibility(4);
        EOSSDK.auth(Uri.toString(..));
        EOSSDK.loginWebView.removeAllViews();
        EOSSDK.loginWebView.destroy();
      L_23:
        return 0;
    }

}

