
// ===== FILE: com/epicgames/mobile/eossdk/C0518R.java =====
package com.epicgames.mobile.eossdk;

/* renamed from: com.epicgames.mobile.eossdk.R */
/* loaded from: classes.dex */
public final class C0518R {

    /* renamed from: com.epicgames.mobile.eossdk.R$color */
    public static final class color {
        public static final int eos_customTabToolbarColor = 2131034172;

        private color() {
        }
    }

    /* renamed from: com.epicgames.mobile.eossdk.R$drawable */
    public static final class drawable {
        public static final int close_24px = 2131165271;

        private drawable() {
        }
    }

    /* renamed from: com.epicgames.mobile.eossdk.R$string */
    public static final class string {
        public static final int eos_login_protocol_scheme = 2131623990;

        private string() {
        }
    }

    /* renamed from: com.epicgames.mobile.eossdk.R$xml */
    public static final class xml {
        public static final int eossdk_backup_rules = 2131820544;

        private xml() {
        }
    }

    private C0518R() {
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSAuthHandlerActivity.java =====
package com.epicgames.mobile.eossdk;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.Date;

/* loaded from: classes.dex */
public class EOSAuthHandlerActivity extends Activity {
    public static String LoginData = "";
    public static long LoginDataTimestamp;

    public EOSAuthHandlerActivity() {
        LoginDataTimestamp = new Date().getTime();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage == null) {
            EOSLog.Eos.Error("Failed to get application intent");
            return;
        }
        Uri data = getIntent().getData();
        LoginData = data != null ? data.toString() : "";
        launchIntentForPackage.addFlags(604504064);
        startActivity(launchIntentForPackage);
        finishAndRemoveTask();
    }

    public static void ResetData() {
        LoginData = "";
        LoginDataTimestamp = 0L;
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSCookies.java =====
package com.epicgames.mobile.eossdk;

import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class EOSCookies {
    public static void RemoveAllCookies(ValueCallback<Boolean> valueCallback) {
        if (CookieManager.getInstance().hasCookies()) {
            CookieManager.getInstance().removeAllCookies(valueCallback);
        } else {
            valueCallback.onReceiveValue(true);
        }
    }

    public static void SetCookies(final String str, final List<String> list, final ValueCallback<Boolean> valueCallback) {
        if (!list.isEmpty()) {
            CookieManager.getInstance().setCookie(str, list.get(0), new ValueCallback() { // from class: com.epicgames.mobile.eossdk.EOSCookies$$ExternalSyntheticLambda0
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    EOSCookies.lambda$SetCookies$0(str, list, valueCallback, (Boolean) obj);
                }
            });
        } else {
            valueCallback.onReceiveValue(true);
        }
    }

    static /* synthetic */ void lambda$SetCookies$0(String str, List list, ValueCallback valueCallback, Boolean bool) {
        if (bool.booleanValue()) {
            SetCookies(str, list.subList(1, list.size()), valueCallback);
        } else {
            valueCallback.onReceiveValue(false);
        }
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSLog.java =====
package com.epicgames.mobile.eossdk;

/* loaded from: classes.dex */
public class EOSLog {
    private static final int EOS_REDACT_EXP_KEEP_LEN = 3;
    private static final int EOS_REDACT_MIN_KEEP_LEN = 1;
    private static final int EOS_REDACT_MIN_LEN = 9;
    public static final EOSLogger Eos = new EOSLogger(Category.EOS);
    public static final EOSLogger EosInternal = new EOSLogger(Category.EOS_INTERNAL);
    public static final EOSLogger Overlay = new EOSLogger(Category.OVERLAY);
    public static final EOSLogger OverlayInternal = new EOSLogger(Category.OVERLAY_INTERNAL);

    public enum Category {
        EOS,
        EOS_INTERNAL,
        OVERLAY,
        OVERLAY_INTERNAL
    }

    public enum Level {
        FATAL,
        ERROR,
        WARNING,
        DISPLAY,
        LOG,
        VERBOSE,
        VERY_VERBOSE
    }

    public static native boolean IsIncludeRedactEnabled();

    private static final class IncludeRedactHolder {
        static final Boolean bIncludeRedact = Boolean.valueOf(EOSLog.IsIncludeRedactEnabled());

        private IncludeRedactHolder() {
        }
    }

    public static Boolean ShouldRedact() {
        return Boolean.valueOf(!IncludeRedactHolder.bIncludeRedact.booleanValue());
    }

    public static String Redact(String str) {
        return ShouldRedact().booleanValue() ? "<Redacted>" : str;
    }

    public static String RedactInt(long j) {
        return Redact(String.valueOf(j));
    }

    public static String RedactMid(String str) {
        if (!ShouldRedact().booleanValue()) {
            return str;
        }
        if (str.length() >= 9) {
            return String.format("%s...%s", str.substring(0, 3), str.substring(str.length() - 3, 3));
        }
        return str.length() >= 1 ? String.format("%s...%s", Character.valueOf(str.charAt(0)), str.substring(str.length() - 1, 1)) : str;
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSLogger.java =====
package com.epicgames.mobile.eossdk;

import android.util.Log;
import com.epicgames.mobile.eossdk.EOSLog;

/* loaded from: classes.dex */
public final class EOSLogger {
    private static final String LOG_TAG = "EOSSDK";
    private final boolean AllowOSLoggingFallback;
    final EOSLog.Category Category;

    public static native boolean Log(EOSLog.Category category, EOSLog.Level level, String str);

    public EOSLogger(EOSLog.Category category) {
        this.Category = category;
        this.AllowOSLoggingFallback = category == EOSLog.Category.OVERLAY || category == EOSLog.Category.EOS;
    }

    public void Fatal(String str) {
        Log(EOSLog.Level.FATAL, str);
    }

    public void Error(String str) {
        Log(EOSLog.Level.ERROR, str);
    }

    public void Warning(String str) {
        Log(EOSLog.Level.WARNING, str);
    }

    public void Display(String str) {
        Log(EOSLog.Level.DISPLAY, str);
    }

    public void Log(String str) {
        Log(EOSLog.Level.LOG, str);
    }

    public void Verbose(String str) {
        Log(EOSLog.Level.VERBOSE, str);
    }

    public void VeryVerbose(String str) {
        Log(EOSLog.Level.VERY_VERBOSE, str);
    }

    private void Log(EOSLog.Level level, String str) {
        if (Log(this.Category, level, str) || !this.AllowOSLoggingFallback) {
            return;
        }
        String str2 = GetLogCategoryString(this.Category) + ": " + str;
        int i = C05131.$SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Level[level.ordinal()];
        if (i == 1) {
            Log.w(LOG_TAG, str2);
            return;
        }
        if (i == 2 || i == 3) {
            Log.i(LOG_TAG, str2);
            return;
        }
        if (i == 4) {
            Log.d(LOG_TAG, str2);
        } else if (i == 5) {
            Log.v(LOG_TAG, str2);
        } else {
            Log.e(LOG_TAG, str2);
        }
    }

    /* renamed from: com.epicgames.mobile.eossdk.EOSLogger$1 */
    static /* synthetic */ class C05131 {
        static final /* synthetic */ int[] $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Category;
        static final /* synthetic */ int[] $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Level;

        static {
            int[] iArr = new int[EOSLog.Category.values().length];
            $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Category = iArr;
            try {
                iArr[EOSLog.Category.EOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Category[EOSLog.Category.EOS_INTERNAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Category[EOSLog.Category.OVERLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Category[EOSLog.Category.OVERLAY_INTERNAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[EOSLog.Level.values().length];
            $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Level = iArr2;
            try {
                iArr2[EOSLog.Level.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Level[EOSLog.Level.DISPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Level[EOSLog.Level.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Level[EOSLog.Level.VERBOSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Level[EOSLog.Level.VERY_VERBOSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Level[EOSLog.Level.FATAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Level[EOSLog.Level.ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private static String GetLogCategoryString(EOSLog.Category category) {
        int i = C05131.$SwitchMap$com$epicgames$mobile$eossdk$EOSLog$Category[category.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "LogEosUnknown" : "LogOverlayInternal" : "LogEosOverlay" : "LogEosInternal" : "LogEos";
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSOverlay.java =====
package com.epicgames.mobile.eossdk;

/* loaded from: classes.dex */
public final class EOSOverlay {
    public static final EOSOverlayWidgetManager WidgetManager = new EOSOverlayWidgetManager();

    public enum BrowserStatus {
        BEGIN_LOAD,
        END_LOAD,
        LOAD_ERROR,
        CLOSED,
        CRASHED
    }

    public static native void OnBrowserStatusChange(long j, long j2, BrowserStatus browserStatus);

    public static native void OnEvaluateJavascriptResult(long j, long j2, long j3, String str);

    public static native void OnExecuteJavascriptFunction(long j, long j2, String str);

    public static native void OnLoadURL(long j, long j2, boolean z);

    public static boolean SetDisplaySettings(long j, long j2, EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings) {
        return WidgetManager.SetDisplaySettings(new EOSOverlayId(j, j2), eOSOverlayWebviewDisplaySettings);
    }

    public static EOSOverlayWebviewDisplaySettings GetDisplaySettings(long j, long j2) {
        return WidgetManager.GetDisplaySettings(new EOSOverlayId(j, j2));
    }

    public static void LoadURL(long j, long j2, String str, String[] strArr, String str2, EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings) {
        WidgetManager.LoadURL(new EOSOverlayId(j, j2), str, strArr, str2, eOSOverlayWebviewDisplaySettings);
    }

    public static void EndWebview(long j, long j2, long j3) {
        WidgetManager.EndWebview(new EOSOverlayId(j, j2), j3);
    }

    public static void EvaluateJS(long j, long j2, long j3, String str) {
        WidgetManager.EvaluateJS(new EOSOverlayId(j, j2), j3, str);
    }

    public static void InvokeJavascriptCallback(String str, long j, long j2, boolean z) {
        WidgetManager.InvokeJavascriptCallback(str, j, j2, z);
    }

    public static boolean GetEnabledForNextLaunch() {
        return EOSPreferences.GetEnabledForNextLaunch();
    }

    public static void SetEnabledForNextLaunch(boolean z) {
        EOSPreferences.SetEnabledForNextLaunch(z);
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSOverlayBackground.java =====
package com.epicgames.mobile.eossdk;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class EOSOverlayBackground extends View {
    public EOSOverlayBackground(Context context, ViewGroup viewGroup) {
        super(context);
        setBackgroundColor(Color.argb(204, 18, 18, 18));
        viewGroup.addView(this, new FrameLayout.LayoutParams(-1, -1));
        hideBackground();
        invalidate();
    }

    public void destroy() {
        setOnTouchListener(null);
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    public void hideBackground() {
        setVisibility(8);
    }

    public void showBackground() {
        setVisibility(0);
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSOverlayBrowser.java =====
package com.epicgames.mobile.eossdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.epicgames.mobile.eossdk.EOSOverlay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class EOSOverlayBrowser implements EOSOverlayWebViewClientDelegate {
    private EOSOverlayClosedButton CloseButton;
    private final ArrayList<EOSOverlayQueuedEvaluateJavascript> DeferredEvaluateJSSource;
    private final AtomicReference<EOSOverlayWebviewDisplaySettings> DisplaySettings;
    private EOSOverlayLoadingBar LoadingBar;
    public final EOSOverlayId OverlayId;
    private boolean ShouldHaveLoadingBar;
    private EOSOverlayWebView WebView;
    private EOSOverlayBackground WebViewBackground;
    private boolean bReadyToEvaluateJavascript;

    public EOSOverlayBrowser(final Activity activity, EOSOverlayId eOSOverlayId, String str, EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings) {
        ArrayList<EOSOverlayQueuedEvaluateJavascript> arrayList = new ArrayList<>();
        this.DeferredEvaluateJSSource = arrayList;
        this.DisplaySettings = new AtomicReference<>(new EOSOverlayWebviewDisplaySettings());
        this.ShouldHaveLoadingBar = false;
        EOSLog.OverlayInternal.VeryVerbose(eOSOverlayId + " EOSOverlayBrowser() (Data), JavaScript: " + EOSLog.Redact(str));
        this.OverlayId = eOSOverlayId;
        arrayList.add(new EOSOverlayQueuedEvaluateJavascript(0L, false, str));
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content).getRootView();
        this.WebViewBackground = new EOSOverlayBackground(activity, viewGroup);
        WebView.setWebContentsDebuggingEnabled(false);
        EOSOverlayWebView eOSOverlayWebView = new EOSOverlayWebView(activity, eOSOverlayId);
        this.WebView = eOSOverlayWebView;
        eOSOverlayWebView.addJavascriptInterface(new EOSOverlayJavascriptInterface(eOSOverlayId), "eosBridgeJs");
        this.WebView.getSettings().setUserAgentString(WebSettings.getDefaultUserAgent(activity) + String.format(" %s", EOSSDK.EOSUserAgent));
        this.WebView.getSettings().setJavaScriptEnabled(true);
        this.WebView.setWebChromeClient(new EOSOverlayWebChromeClient(eOSOverlayId));
        this.WebView.setWebViewClient(new EOSOverlayWebViewClient(eOSOverlayId, this));
        this.WebView.setBackgroundColor(0);
        this.WebView.getSettings().setDomStorageEnabled(true);
        this.WebView.setOutlineProvider(null);
        SetVisibility(this.WebView, false);
        viewGroup.addView(this.WebView, new FrameLayout.LayoutParams(-1, -1));
        if (eOSOverlayWebviewDisplaySettings != null && eOSOverlayWebviewDisplaySettings.bUseSafeArea) {
            ViewCompat.setOnApplyWindowInsetsListener(this.WebView, new OnApplyWindowInsetsListener() { // from class: com.epicgames.mobile.eossdk.EOSOverlayBrowser$$ExternalSyntheticLambda1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return EOSOverlayBrowser.this.m514lambda$new$0$comepicgamesmobileeossdkEOSOverlayBrowser(activity, view, windowInsetsCompat);
                }
            });
        }
        this.WebView.invalidate();
        EOSOverlayLoadingBar eOSOverlayLoadingBar = new EOSOverlayLoadingBar(activity, viewGroup);
        this.LoadingBar = eOSOverlayLoadingBar;
        eOSOverlayLoadingBar.bringToFront();
        try {
            this.CloseButton = new EOSOverlayClosedButton(activity, viewGroup, this);
        } catch (Exception e) {
            EOSLog.Overlay.Error(eOSOverlayId + " EOSOverlayBrowser close button error " + e);
        }
    }

    /* renamed from: lambda$new$0$com-epicgames-mobile-eossdk-EOSOverlayBrowser, reason: not valid java name */
    /* synthetic */ WindowInsetsCompat m514lambda$new$0$comepicgamesmobileeossdkEOSOverlayBrowser(Activity activity, View view, WindowInsetsCompat windowInsetsCompat) {
        Insets systemWindowInsets = windowInsetsCompat.getSystemWindowInsets();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin = systemWindowInsets.top;
        marginLayoutParams.bottomMargin = systemWindowInsets.bottom;
        marginLayoutParams.leftMargin = systemWindowInsets.left;
        marginLayoutParams.rightMargin = systemWindowInsets.right;
        int i = activity.getResources().getConfiguration().orientation;
        if (i == 1) {
            marginLayoutParams.bottomMargin = Math.max(marginLayoutParams.bottomMargin, GetNavigationBarHeight(activity, i));
        }
        view.setLayoutParams(marginLayoutParams);
        return windowInsetsCompat;
    }

    public void SetVisibility(View view, boolean z) {
        EOSLog.OverlayInternal.VeryVerbose(this.OverlayId + " EOSOverlayBrowser.SetVisibility:" + z);
        if (z) {
            view.setVisibility(0);
            view.setClickable(true);
            view.setFocusable(true);
            view.setEnabled(true);
            view.setFocusableInTouchMode(true);
            return;
        }
        view.setVisibility(4);
        view.setClickable(false);
        view.setFocusable(false);
        view.setEnabled(false);
        view.setFocusableInTouchMode(false);
    }

    private int GetNavigationBarHeight(Context context, int i) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(i == 1 ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void LoadURL(final String str, final String[] strArr, final EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings) {
        EOSLog.Overlay.Log(this.OverlayId + " EOSOverlayBrowser.LoadURL");
        EOSLog.OverlayInternal.VeryVerbose(this.OverlayId + " EOSOverlayBrowser.LoadURL (Data), URL: " + EOSLog.Redact(str) + ", Cookies: " + EOSLog.Redact(Arrays.toString(strArr)));
        EOSCookies.RemoveAllCookies(new ValueCallback() { // from class: com.epicgames.mobile.eossdk.EOSOverlayBrowser$$ExternalSyntheticLambda0
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                EOSOverlayBrowser.this.m513lambda$LoadURL$2$comepicgamesmobileeossdkEOSOverlayBrowser(str, strArr, eOSOverlayWebviewDisplaySettings, (Boolean) obj);
            }
        });
    }

    /* renamed from: lambda$LoadURL$2$com-epicgames-mobile-eossdk-EOSOverlayBrowser, reason: not valid java name */
    /* synthetic */ void m513lambda$LoadURL$2$comepicgamesmobileeossdkEOSOverlayBrowser(final String str, String[] strArr, final EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings, Boolean bool) {
        if (!bool.booleanValue()) {
            EOSLog.Overlay.Error(this.OverlayId + " EOSOverlayBrowser.LoadURL, RemoveAllCookies failed");
            EOSOverlay.OnLoadURL(this.OverlayId.InstanceId, this.OverlayId.BrowserId, false);
            return;
        }
        EOSCookies.SetCookies(str, Arrays.asList(strArr), new ValueCallback() { // from class: com.epicgames.mobile.eossdk.EOSOverlayBrowser$$ExternalSyntheticLambda4
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                EOSOverlayBrowser.this.m512lambda$LoadURL$1$comepicgamesmobileeossdkEOSOverlayBrowser(eOSOverlayWebviewDisplaySettings, str, (Boolean) obj);
            }
        });
    }

    /* renamed from: lambda$LoadURL$1$com-epicgames-mobile-eossdk-EOSOverlayBrowser, reason: not valid java name */
    /* synthetic */ void m512lambda$LoadURL$1$comepicgamesmobileeossdkEOSOverlayBrowser(EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings, String str, Boolean bool) {
        if (!bool.booleanValue()) {
            EOSLog.Overlay.Error(this.OverlayId + " EOSOverlayBrowser.LoadURL, SetCookies failed");
            EOSOverlay.OnLoadURL(this.OverlayId.InstanceId, this.OverlayId.BrowserId, false);
            return;
        }
        if (this.WebView == null) {
            EOSLog.Overlay.Error(this.OverlayId + " EOSOverlayBrowser.LoadURL, WebView no longer exists");
            EOSOverlay.OnLoadURL(this.OverlayId.InstanceId, this.OverlayId.BrowserId, false);
            return;
        }
        SetDisplaySettings(eOSOverlayWebviewDisplaySettings);
        this.ShouldHaveLoadingBar = eOSOverlayWebviewDisplaySettings.bIsVisible;
        EOSLog.OverlayInternal.Log(this.OverlayId + " EOSOverlayBrowser.LoadURL, OnLoadURL");
        EOSOverlay.OnLoadURL(this.OverlayId.InstanceId, this.OverlayId.BrowserId, true);
        this.WebView.loadUrl(str);
        EOSOverlayLoadingBar eOSOverlayLoadingBar = this.LoadingBar;
        if (eOSOverlayLoadingBar != null && this.ShouldHaveLoadingBar) {
            eOSOverlayLoadingBar.showLoadingBar();
        }
        if (this.CloseButton != null && GetDisplaySettings().bHasCloseButton) {
            this.CloseButton.showCloseButton();
        }
        if (this.WebViewBackground == null || !GetDisplaySettings().bHasDarkenedBackground) {
            return;
        }
        this.WebViewBackground.showBackground();
    }

    public boolean EndWebview(boolean z) {
        if (this.WebView == null) {
            EOSLog.Overlay.Warning(this.OverlayId + " EOSOverlayBrowser.EndWebview, WebView already removed");
            return false;
        }
        this.LoadingBar.destroy();
        this.LoadingBar = null;
        EOSOverlayClosedButton eOSOverlayClosedButton = this.CloseButton;
        if (eOSOverlayClosedButton != null) {
            eOSOverlayClosedButton.destroy();
            this.CloseButton = null;
        }
        this.WebViewBackground.destroy();
        this.WebViewBackground = null;
        this.WebView.destroy();
        this.WebView = null;
        EOSLog.Overlay.Log(this.OverlayId + " EOSOverlayBrowser.EndWebview, bCrashed:" + z);
        EOSOverlay.OnBrowserStatusChange(this.OverlayId.InstanceId, this.OverlayId.BrowserId, z ? EOSOverlay.BrowserStatus.CRASHED : EOSOverlay.BrowserStatus.CLOSED);
        return true;
    }

    public boolean EvaluateJS(final long j, final boolean z, String str) {
        EOSLog.OverlayInternal.VeryVerbose(this.OverlayId + " EOSOverlayBrowser.EvaluateJS, RequestId: " + j + ", bWantsResult: " + z + ", bReadyToEvaluateJavascript: " + this.bReadyToEvaluateJavascript + ", Javascript: " + EOSLog.Redact(str));
        EOSOverlayWebView eOSOverlayWebView = this.WebView;
        if (eOSOverlayWebView == null) {
            EOSLog.Overlay.Warning(this.OverlayId + " EOSOverlayBrowser.EvaluateJS, No Browser, RequestId: " + j + ", bWantsResult: " + z);
            return false;
        }
        if (!this.bReadyToEvaluateJavascript) {
            this.DeferredEvaluateJSSource.add(new EOSOverlayQueuedEvaluateJavascript(j, z, str));
            return true;
        }
        eOSOverlayWebView.evaluateJavascript(str, new ValueCallback() { // from class: com.epicgames.mobile.eossdk.EOSOverlayBrowser$$ExternalSyntheticLambda2
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                EOSOverlayBrowser.this.m50xd8ecfbd(j, z, (String) obj);
            }
        });
        return true;
    }

    /* renamed from: lambda$EvaluateJS$3$com-epicgames-mobile-eossdk-EOSOverlayBrowser */
    /* synthetic */ void m50xd8ecfbd(long j, boolean z, String str) {
        EOSLog.OverlayInternal.VeryVerbose(this.OverlayId + " EOSOverlayBrowser.EvaluateJS (Completed), RequestId: " + j + ", bWantsResult: " + z + ", EvalOutput: " + EOSLog.Redact(str));
        if (z) {
            EOSOverlay.OnEvaluateJavascriptResult(this.OverlayId.InstanceId, this.OverlayId.BrowserId, j, str);
        }
    }

    public boolean InvokeJavascriptCallback(String str, long j, boolean z) {
        EOSLog.OverlayInternal.VeryVerbose(this.OverlayId + " EOSOverlayBrowser.InvokeJavascriptCallback, CallbackId: " + j + ", IsSuccess: " + z + ", ArgumentsString: " + EOSLog.Redact(str));
        if (this.WebView == null) {
            EOSLog.Overlay.Warning(this.OverlayId + " EOSOverlayBrowser.InvokeJavascriptCallback (No WebView), CallbackId: " + j);
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("callbackId", j);
            jSONObject.put("isSuccess", z);
            StringBuilder sb = new StringBuilder();
            sb.append("window.__eos_detail__.resolveBridgePromise( ");
            sb.append(jSONObject);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(",\"arguments\":");
            sb.append(str);
            sb.append("}");
            sb.append(")");
            return EvaluateJS(-1L, false, sb.toString());
        } catch (JSONException e) {
            EOSLog.Overlay.Error(this.OverlayId + " EOSOverlayBrowser.InvokeJavascriptCallback, JSONObject error: " + EOSLog.Redact(e.toString()));
            e.printStackTrace();
            return false;
        }
    }

    public void SetDisplaySettings(final EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings) {
        EOSLog.OverlayInternal.VeryVerbose(this.OverlayId + " EOSOverlayBrowser.SetDisplaySettings: " + eOSOverlayWebviewDisplaySettings);
        this.DisplaySettings.set(eOSOverlayWebviewDisplaySettings);
        EOSSDK.GetActivity().runOnUiThread(new FutureTask(new Callable() { // from class: com.epicgames.mobile.eossdk.EOSOverlayBrowser$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return EOSOverlayBrowser.this.m51x4197319f(eOSOverlayWebviewDisplaySettings);
            }
        }));
    }

    /* renamed from: lambda$SetDisplaySettings$4$com-epicgames-mobile-eossdk-EOSOverlayBrowser */
    /* synthetic */ Boolean m51x4197319f(EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings) throws Exception {
        EOSOverlayWebView eOSOverlayWebView = this.WebView;
        if (eOSOverlayWebView == null) {
            EOSLog.Overlay.Warning(this.OverlayId + " EOSOverlayBrowser.SetDisplaySettings (No WebView)");
            return false;
        }
        SetVisibility(eOSOverlayWebView, eOSOverlayWebviewDisplaySettings.bIsVisible);
        if (eOSOverlayWebviewDisplaySettings.bIsVisible) {
            this.WebView.bringToFront();
            EOSOverlayClosedButton eOSOverlayClosedButton = this.CloseButton;
            if (eOSOverlayClosedButton != null) {
                eOSOverlayClosedButton.bringToFront();
            }
        }
        ViewCompat.setElevation(this.WebView, eOSOverlayWebviewDisplaySettings.ZIndex);
        EOSOverlayClosedButton eOSOverlayClosedButton2 = this.CloseButton;
        if (eOSOverlayClosedButton2 != null) {
            ViewCompat.setElevation(eOSOverlayClosedButton2, eOSOverlayWebviewDisplaySettings.ZIndex + 0.1f);
        }
        return Boolean.valueOf(this.WebView.SetDisplaySettings(eOSOverlayWebviewDisplaySettings));
    }

    public EOSOverlayWebviewDisplaySettings GetDisplaySettings() {
        return this.DisplaySettings.get();
    }

    @Override // com.epicgames.mobile.eossdk.EOSOverlayWebViewClientDelegate
    public void onPageStarted() {
        if (this.bReadyToEvaluateJavascript) {
            return;
        }
        this.bReadyToEvaluateJavascript = true;
        Iterator<EOSOverlayQueuedEvaluateJavascript> it = this.DeferredEvaluateJSSource.iterator();
        while (it.hasNext()) {
            EOSOverlayQueuedEvaluateJavascript next = it.next();
            EvaluateJS(next.RequestId, next.bWantsResult, next.Source);
        }
        this.DeferredEvaluateJSSource.clear();
    }

    @Override // com.epicgames.mobile.eossdk.EOSOverlayWebViewClientDelegate
    public void onPageFinished() {
        EOSOverlayLoadingBar eOSOverlayLoadingBar = this.LoadingBar;
        if (eOSOverlayLoadingBar != null) {
            eOSOverlayLoadingBar.hideLoadingBar();
        }
    }

    @Override // com.epicgames.mobile.eossdk.EOSOverlayWebViewClientDelegate
    public void onRenderProcessGone() {
        EndWebview(true);
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSOverlayClosedButton.java =====
package com.epicgames.mobile.eossdk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class EOSOverlayClosedButton extends View implements View.OnTouchListener {
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

    public EOSOverlayClosedButton(Context context, ViewGroup viewGroup, EOSOverlayBrowser eOSOverlayBrowser) {
        super(context);
        this.Radius = 25.0f;
        this.Size = 15.0f;
        this.OutlineSize = 2.0f;
        this.ShortMargin = 27.0f;
        this.LargeMargin = 48.0f;
        this.ViewRect = new RectF();
        this.RectWidth = 0.0f;
        this.SafeSpaceWidth = 0.0f;
        this.SafeSpaceHeight = 0.0f;
        this.StartedTouchInside = false;
        this.OverlayBrowser = eOSOverlayBrowser;
        Paint paint = new Paint();
        this.BackgroundPaint = paint;
        paint.setColor(Color.argb(20, 20, 20, 20));
        Paint paint2 = new Paint();
        this.CrossPaint = paint2;
        paint2.setColor(-1);
        paint2.setStrokeWidth(5.0f);
        Paint paint3 = new Paint();
        this.CrossOutlinePaint = paint3;
        paint3.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint3.setStrokeWidth(CLICK_DRAG_TOLERANCE);
        viewGroup.addView(this, new FrameLayout.LayoutParams(-1, -1));
        setOnTouchListener(this);
        hideCloseButton();
        setOutlineProvider(null);
        invalidate();
    }

    public void destroy() {
        setOnTouchListener(null);
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    public float pixelsFromDp(float f) {
        return f * getContext().getResources().getDisplayMetrics().density;
    }

    private void setLandscapeMode() {
        this.SafeSpaceWidth = pixelsFromDp(48.0f);
        this.SafeSpaceHeight = pixelsFromDp(27.0f);
    }

    private void setPortraitMode() {
        this.SafeSpaceWidth = pixelsFromDp(27.0f);
        this.SafeSpaceHeight = pixelsFromDp(48.0f);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.xDisplacement = 0.0f;
        this.yDisplacement = 0.0f;
        this.ViewRect.set(0.0f, 0.0f, i, i2);
        this.RectWidth = this.ViewRect.width();
        if (i3 == 0 && i4 == 0) {
            if (i > i2) {
                setLandscapeMode();
                return;
            } else {
                setPortraitMode();
                return;
            }
        }
        if (i < i3 && i2 > i4) {
            setPortraitMode();
        } else if (i == i4 && i2 == i3) {
            setLandscapeMode();
        }
    }

    public float GetOriginX() {
        return ((this.RectWidth - this.SafeSpaceWidth) - 15.0f) + this.xDisplacement;
    }

    public float GetOriginY() {
        return (this.SafeSpaceHeight - 15.0f) + this.yDisplacement;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        float GetOriginX = GetOriginX();
        float GetOriginY = GetOriginY();
        float f = GetOriginX - 2.0f;
        float f2 = GetOriginY - 2.0f;
        float f3 = GetOriginX + 2.0f + 30.0f;
        float f4 = 2.0f + GetOriginY + 30.0f;
        canvas.drawLine(f, f2, f3, f4, this.CrossOutlinePaint);
        canvas.drawLine(f, f4, f3, f2, this.CrossOutlinePaint);
        float f5 = GetOriginX + 30.0f;
        float f6 = GetOriginY + 30.0f;
        canvas.drawLine(GetOriginX, GetOriginY, f5, f6, this.CrossPaint);
        canvas.drawLine(GetOriginX, f6, f5, GetOriginY, this.CrossPaint);
        invalidate();
    }

    public void showCloseButton() {
        setVisibility(0);
    }

    public void hideCloseButton() {
        setVisibility(8);
    }

    public boolean IsTouchInside(float f, float f2) {
        float GetOriginX = GetOriginX();
        float GetOriginY = GetOriginY();
        return new RectF(GetOriginX - 7.5f, GetOriginY - 7.5f, GetOriginX + 37.5f, GetOriginY + 37.5f).contains(f, f2);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean IsTouchInside = IsTouchInside(motionEvent.getRawX(), motionEvent.getRawY());
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downRawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            this.downRawY = rawY;
            this.downDisplacementX = this.downRawX - this.xDisplacement;
            this.downDisplacementY = rawY - this.yDisplacement;
            if (!IsTouchInside) {
                return false;
            }
            this.StartedTouchInside = true;
            return true;
        }
        if (action == 1) {
            float rawX = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            float f = rawX - this.downRawX;
            float f2 = rawY2 - this.downRawY;
            this.StartedTouchInside = false;
            if (Math.abs(f) >= CLICK_DRAG_TOLERANCE || Math.abs(f2) >= CLICK_DRAG_TOLERANCE) {
                return true;
            }
            return performClick();
        }
        if (action != 2) {
            return false;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        float GetOriginX = GetOriginX() - this.xDisplacement;
        float GetOriginY = GetOriginY() - this.yDisplacement;
        float rawX2 = motionEvent.getRawX() - this.downDisplacementX;
        float rawY3 = motionEvent.getRawY() - this.downDisplacementY;
        float f3 = GetOriginX + rawX2;
        float f4 = GetOriginY + rawY3;
        int width = view.getWidth();
        int height = view.getHeight();
        if (f3 > marginLayoutParams.leftMargin + 30.0f && f3 < (width - marginLayoutParams.rightMargin) - 45.0f && f4 > marginLayoutParams.topMargin + 30.0f && f4 < (height - marginLayoutParams.bottomMargin) - 45.0f) {
            this.xDisplacement = rawX2;
            this.yDisplacement = rawY3;
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        this.OverlayBrowser.EndWebview(false);
        return super.performClick();
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSOverlayId.java =====
package com.epicgames.mobile.eossdk;

import java.util.Objects;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* loaded from: classes.dex */
public final class EOSOverlayId {
    public final long BrowserId;
    public final long InstanceId;

    public EOSOverlayId(long j, long j2) {
        this.InstanceId = j;
        this.BrowserId = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EOSOverlayId eOSOverlayId = (EOSOverlayId) obj;
        return this.InstanceId == eOSOverlayId.InstanceId && this.BrowserId == eOSOverlayId.BrowserId;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.InstanceId), Long.valueOf(this.BrowserId));
    }

    public String toString() {
        String m458m;
        String m458m2;
        StringBuilder sb = new StringBuilder("[I:");
        m458m = UByte$$ExternalSyntheticBackport0.m458m(this.InstanceId, 10);
        sb.append(m458m);
        sb.append(" B:");
        m458m2 = UByte$$ExternalSyntheticBackport0.m458m(this.BrowserId, 10);
        sb.append(m458m2);
        sb.append("]");
        return sb.toString();
    }

    public static String UnknownBrowserIdString(long j) {
        String m458m;
        StringBuilder sb = new StringBuilder("[I:");
        m458m = UByte$$ExternalSyntheticBackport0.m458m(j, 10);
        sb.append(m458m);
        sb.append(" B:?]");
        return sb.toString();
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSOverlayJavascriptInterface.java =====
package com.epicgames.mobile.eossdk;

import android.webkit.JavascriptInterface;

/* loaded from: classes.dex */
public final class EOSOverlayJavascriptInterface {
    public final EOSOverlayId OverlayId;

    @JavascriptInterface
    public String GetNavHeight() {
        return "48px";
    }

    public EOSOverlayJavascriptInterface(EOSOverlayId eOSOverlayId) {
        this.OverlayId = eOSOverlayId;
    }

    @JavascriptInterface
    public long GetNextJavascriptCallbackId() {
        long GetNextJavascriptCallbackId = EOSOverlay.WidgetManager.GetNextJavascriptCallbackId();
        EOSLog.OverlayInternal.VeryVerbose(this.OverlayId + " EOSJSBridge.GetNextJavascriptCallbackId: , JavascriptCallbackId: " + GetNextJavascriptCallbackId);
        return GetNextJavascriptCallbackId;
    }

    @JavascriptInterface
    public void OnExecuteJavascriptFunction(long j, String str) {
        EOSLog.OverlayInternal.VeryVerbose(this.OverlayId + " EOSOverlayJavascriptInterface.OnExecuteJavascriptFunction: , CallbackId: " + j + ", JSONString: " + EOSLog.Redact(str));
        EOSOverlay.WidgetManager.OnExecuteJavascriptFunction(this.OverlayId, j, str);
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSOverlayLoadingBar.java =====
package com.epicgames.mobile.eossdk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class EOSOverlayLoadingBar extends View {
    private static float GLoadingBarAnimationRate = 612.0f;
    private static final float GLoadingBarLeftCatchupRate = 1.5f;
    private float BarLeft;
    private final Paint BarPaint;
    private float BarRight;
    private long LastRenderMs;
    private final RectF ViewRect;

    public EOSOverlayLoadingBar(Context context, ViewGroup viewGroup) {
        super(context);
        this.LastRenderMs = 0L;
        this.ViewRect = new RectF();
        this.BarLeft = 0.0f;
        this.BarRight = 0.0f;
        Paint paint = new Paint();
        this.BarPaint = paint;
        paint.setARGB(255, 0, 140, 255);
        viewGroup.addView(this, new FrameLayout.LayoutParams(-1, (int) Math.ceil(context.getResources().getDisplayMetrics().density * 4.0f)));
        hideLoadingBar();
        invalidate();
    }

    public void destroy() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.ViewRect.set(0.0f, 0.0f, i, i2);
        resetProgress();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.LastRenderMs;
        this.LastRenderMs = uptimeMillis;
        updateProgress(j / 1000.0f);
        canvas.drawRect(this.BarLeft, 0.0f, this.BarRight, this.ViewRect.height(), this.BarPaint);
        invalidate();
    }

    public void showLoadingBar() {
        resetProgress();
        setVisibility(0);
    }

    public void hideLoadingBar() {
        setVisibility(8);
    }

    private void resetProgress() {
        this.LastRenderMs = SystemClock.uptimeMillis();
        this.BarLeft = 0.0f;
        this.BarRight = 0.0f;
    }

    private void updateProgress(float f) {
        float f2 = GLoadingBarAnimationRate;
        if (this.BarRight < this.ViewRect.width() / 2.0f) {
            float f3 = this.BarRight + (f * f2);
            this.BarRight = f3;
            if (f3 > this.ViewRect.width() / 2.0f) {
                this.BarLeft += (this.BarRight - (this.ViewRect.width() / 2.0f)) * GLoadingBarLeftCatchupRate;
                return;
            }
            return;
        }
        float f4 = f * f2;
        this.BarRight = Math.min(this.ViewRect.width(), this.BarRight + f4);
        float min = Math.min(this.ViewRect.width(), this.BarLeft + (f4 * GLoadingBarLeftCatchupRate));
        this.BarLeft = min;
        if (min >= this.ViewRect.width() - 0.5d) {
            this.BarLeft = 0.0f;
            this.BarRight = 0.0f;
        }
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSOverlayQueuedEvaluateJavascript.java =====
package com.epicgames.mobile.eossdk;

/* loaded from: classes.dex */
public final class EOSOverlayQueuedEvaluateJavascript {
    final long RequestId;
    final String Source;
    final boolean bWantsResult;

    public EOSOverlayQueuedEvaluateJavascript(long j, boolean z, String str) {
        this.RequestId = j;
        this.bWantsResult = z;
        this.Source = str;
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSOverlayWebChromeClient.java =====
package com.epicgames.mobile.eossdk;

import android.net.Uri;
import android.os.Message;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* loaded from: classes.dex */
public final class EOSOverlayWebChromeClient extends WebChromeClient {
    public final EOSOverlayId OverlayId;

    public EOSOverlayWebChromeClient(EOSOverlayId eOSOverlayId) {
        this.OverlayId = eOSOverlayId;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        EOSLog.OverlayInternal.VeryVerbose(this.OverlayId + " EOSWebChromeClient onProgressChanged: " + i + "%");
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = this.OverlayId + " EOSWebChromeClient, [console] " + EOSLog.Redact(consoleMessage.message()) + " at " + consoleMessage.lineNumber() + ": " + consoleMessage.sourceId();
        int i = C05141.$SwitchMap$android$webkit$ConsoleMessage$MessageLevel[consoleMessage.messageLevel().ordinal()];
        if (i == 1) {
            EOSLog.OverlayInternal.Verbose(str);
        } else if (i == 2 || i == 3) {
            EOSLog.OverlayInternal.Log(str);
        } else if (i == 4) {
            EOSLog.OverlayInternal.Warning(str);
        } else if (i == 5) {
            EOSLog.OverlayInternal.Error(str);
        }
        return true;
    }

    /* renamed from: com.epicgames.mobile.eossdk.EOSOverlayWebChromeClient$1 */
    static /* synthetic */ class C05141 {
        static final /* synthetic */ int[] $SwitchMap$android$webkit$ConsoleMessage$MessageLevel;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.TIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        EOSLog.Overlay.Error(this.OverlayId + " EOSWebChromeClient unexpected onCreateWindow");
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        EOSLog.Overlay.Error(this.OverlayId + " EOSWebChromeClient unexpected onJsAlert");
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        EOSLog.Overlay.Error(this.OverlayId + " EOSWebChromeClient unexpected onJsConfirm");
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        EOSLog.Overlay.Error(this.OverlayId + " EOSWebChromeClient unexpected onJsPrompt");
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        EOSLog.Overlay.Error(this.OverlayId + " EOSWebChromeClient unexpected onJsBeforeUnload");
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        EOSLog.Overlay.Error(this.OverlayId + " EOSWebChromeClient unexpected onGeolocationPermissionsShowPrompt");
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        EOSLog.Overlay.Error(this.OverlayId + " EOSWebChromeClient unexpected onGeolocationPermissionsHidePrompt");
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        EOSLog.Overlay.Error(this.OverlayId + " EOSWebChromeClient unexpected onPermissionRequest");
        permissionRequest.deny();
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        EOSLog.Overlay.Error(this.OverlayId + " EOSWebChromeClient unexpected onPermissionRequestCanceled");
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        EOSLog.Overlay.Error(this.OverlayId + " EOSWebChromeClient unexpected onShowFileChooser");
        return false;
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSOverlayWebView.java =====
package com.epicgames.mobile.eossdk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebView;

/* loaded from: classes.dex */
public class EOSOverlayWebView extends WebView {
    private final float Density;
    private EOSOverlayWebviewDisplaySettings DisplaySettings;
    final EOSOverlayId OverlayId;

    public EOSOverlayWebView(Context context, EOSOverlayId eOSOverlayId) {
        super(context);
        this.OverlayId = eOSOverlayId;
        this.Density = context.getResources().getDisplayMetrics().density;
    }

    public boolean SetDisplaySettings(EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings) {
        this.DisplaySettings = eOSOverlayWebviewDisplaySettings;
        return true;
    }

    private boolean isWithinDisplaySettingsHitBox(float f, float f2) {
        EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings = this.DisplaySettings;
        if (eOSOverlayWebviewDisplaySettings == null) {
            return false;
        }
        if (eOSOverlayWebviewDisplaySettings.bHitBox) {
            return f >= this.DisplaySettings.HitBoxX && f <= this.DisplaySettings.HitBoxX + this.DisplaySettings.HitBoxWidth && f2 >= this.DisplaySettings.HitBoxY && f2 <= this.DisplaySettings.HitBoxY + this.DisplaySettings.HitBoxHeight;
        }
        return true;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = (int) ((motionEvent.getX() / this.Density) + 0.5f);
        float y = (int) ((motionEvent.getY() / this.Density) + 0.5f);
        boolean isWithinDisplaySettingsHitBox = isWithinDisplaySettingsHitBox(x, y);
        EOSLog.OverlayInternal.VeryVerbose(this.OverlayId + " onTouchEvent, isWithinHitBox: " + isWithinDisplaySettingsHitBox + ", isEnabled: " + isEnabled() + ", isClickable: " + isClickable() + ", X: " + x + ", Y: " + y + ", Density: " + this.Density);
        if (isWithinDisplaySettingsHitBox && isEnabled() && isClickable()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        EOSLog.OverlayInternal.VeryVerbose(this.OverlayId + " performClick, isEnabled: " + isEnabled() + ", isClickable: " + isClickable());
        if (isEnabled() && isClickable()) {
            return super.performClick();
        }
        return false;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSOverlayWebViewClient.java =====
package com.epicgames.mobile.eossdk;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.epicgames.mobile.eossdk.EOSOverlay;

/* loaded from: classes.dex */
class EOSOverlayWebViewClient extends WebViewClient {
    private final EOSOverlayWebViewClientDelegate Delegate;
    public final EOSOverlayId OverlayId;

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return false;
    }

    public EOSOverlayWebViewClient(EOSOverlayId eOSOverlayId, EOSOverlayWebViewClientDelegate eOSOverlayWebViewClientDelegate) {
        this.OverlayId = eOSOverlayId;
        this.Delegate = eOSOverlayWebViewClientDelegate;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        EOSLog.OverlayInternal.Log(this.OverlayId + " EOSOverlayWebViewClient.onPageStarted, URL: " + EOSLog.Redact(str));
        super.onPageStarted(webView, str, bitmap);
        this.Delegate.onPageStarted();
        EOSOverlay.OnBrowserStatusChange(this.OverlayId.InstanceId, this.OverlayId.BrowserId, EOSOverlay.BrowserStatus.BEGIN_LOAD);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        EOSLog.OverlayInternal.Log(this.OverlayId + " EOSOverlayWebViewClient.onPageFinished, URL: " + EOSLog.Redact(str));
        super.onPageFinished(webView, str);
        if (webView.getProgress() >= 100) {
            EOSOverlay.OnBrowserStatusChange(this.OverlayId.InstanceId, this.OverlayId.BrowserId, EOSOverlay.BrowserStatus.END_LOAD);
            this.Delegate.onPageFinished();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        EOSLog.OverlayInternal.VeryVerbose(this.OverlayId + " EOSOverlayWebViewClient.onLoadResource, URL: " + EOSLog.Redact(str));
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        EOSLog.Overlay.Warning(this.OverlayId + " EOSOverlayWebViewClient.onReceivedError, IsMainFrame: " + webResourceRequest.isForMainFrame() + ", Request URL: " + EOSLog.Redact(webResourceRequest.getUrl().toString()) + ", Error Code: " + EOSLog.RedactInt(webResourceError.getErrorCode()) + ", Error: " + EOSLog.Redact(webResourceError.getDescription().toString()));
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (webResourceRequest.isForMainFrame()) {
            EOSOverlay.OnBrowserStatusChange(this.OverlayId.InstanceId, this.OverlayId.BrowserId, EOSOverlay.BrowserStatus.LOAD_ERROR);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        EOSLog.Overlay.Error(this.OverlayId + " EOSOverlayWebViewClient.onReceivedHttpError, IsMainFrame: " + webResourceRequest.isForMainFrame() + ", Request URL: " + EOSLog.Redact(webResourceRequest.getUrl().toString()) + ", Error Status Code: " + EOSLog.RedactInt(webResourceResponse.getStatusCode()) + ", Error: " + EOSLog.Redact(webResourceResponse.getReasonPhrase()));
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webResourceRequest.isForMainFrame()) {
            EOSOverlay.OnBrowserStatusChange(this.OverlayId.InstanceId, this.OverlayId.BrowserId, EOSOverlay.BrowserStatus.LOAD_ERROR);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        EOSLog.Overlay.Error(this.OverlayId + " EOSOverlayWebViewClient.onReceivedSslError, URL: " + EOSLog.Redact(sslError.getUrl()) + ", Primary Error: " + EOSLog.RedactInt(sslError.getPrimaryError()) + ", Error: " + EOSLog.Redact(sslError.toString()));
        sslErrorHandler.cancel();
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        EOSLogger eOSLogger = EOSLog.Overlay;
        StringBuilder sb = new StringBuilder();
        sb.append(this.OverlayId);
        sb.append(" EOSOverlayWebViewClient.onRenderProcessGone, Browser termination unexpected. Sending crashed status, Detail: ");
        sb.append(EOSLog.Redact(renderProcessGoneDetail.toString()));
        sb.append(", ");
        sb.append(renderProcessGoneDetail.didCrash() ? "Unexpected crash" : "OOM");
        eOSLogger.Error(sb.toString());
        super.onRenderProcessGone(webView, renderProcessGoneDetail);
        this.Delegate.onRenderProcessGone();
        return true;
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSOverlayWebViewClientDelegate.java =====
package com.epicgames.mobile.eossdk;

/* loaded from: classes.dex */
public interface EOSOverlayWebViewClientDelegate {
    void onPageFinished();

    void onPageStarted();

    void onRenderProcessGone();
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSOverlayWebviewDisplaySettings.java =====
package com.epicgames.mobile.eossdk;

/* loaded from: classes.dex */
public class EOSOverlayWebviewDisplaySettings {
    public int ZIndex = 0;
    public boolean bHasCloseButton = true;
    public boolean bHasDarkenedBackground = true;
    public boolean bIsVisible = true;
    public boolean bEnableExclusiveInputMode = true;
    public boolean bHitBox = false;
    public float HitBoxX = 0.0f;
    public float HitBoxY = 0.0f;
    public float HitBoxWidth = 0.0f;
    public float HitBoxHeight = 0.0f;
    public boolean bUseSafeArea = false;

    public String toString() {
        return "EOSOverlayWebviewDisplaySettings{ZIndex=" + this.ZIndex + ", bHasCloseButton=" + this.bHasCloseButton + ", bHasDarkenedBackground=" + this.bHasDarkenedBackground + ", bIsVisible=" + this.bIsVisible + ", bEnableExclusiveInputMode=" + this.bEnableExclusiveInputMode + ", bHitBox=" + this.bHitBox + ", HitBoxX=" + this.HitBoxX + ", HitBoxY=" + this.HitBoxY + ", HitBoxWidth=" + this.HitBoxWidth + ", HitBoxHeight=" + this.HitBoxHeight + ", bUseSafeArea=" + this.bUseSafeArea + '}';
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSOverlayWidgetManager.java =====
package com.epicgames.mobile.eossdk;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class EOSOverlayWidgetManager {
    private final ConcurrentHashMap<EOSOverlayId, EOSOverlayBrowser> Browsers = new ConcurrentHashMap<>();
    private final AtomicLong NextJavascriptCallbackId = new AtomicLong();
    private final ConcurrentHashMap<Long, EOSOverlayId> CallbackBrowsers = new ConcurrentHashMap<>();

    public boolean StoreOverlayIdForCallback(EOSOverlayId eOSOverlayId, long j) {
        return this.CallbackBrowsers.putIfAbsent(Long.valueOf(j), eOSOverlayId) == null;
    }

    public EOSOverlayId RetrieveOverlayIdForCallback(long j) {
        return this.CallbackBrowsers.remove(Long.valueOf(j));
    }

    public EOSOverlayBrowser FindBrowser(EOSOverlayId eOSOverlayId) {
        return this.Browsers.get(eOSOverlayId);
    }

    public boolean RegisterBrowser(EOSOverlayBrowser eOSOverlayBrowser, EOSOverlayId eOSOverlayId) {
        return this.Browsers.putIfAbsent(eOSOverlayId, eOSOverlayBrowser) == null;
    }

    public boolean UnregisterBrowser(EOSOverlayBrowser eOSOverlayBrowser) {
        return this.Browsers.remove(eOSOverlayBrowser.OverlayId) != null;
    }

    public long GetNextJavascriptCallbackId() {
        return this.NextJavascriptCallbackId.getAndIncrement();
    }

    public void OnExecuteJavascriptFunction(EOSOverlayId eOSOverlayId, long j, String str) {
        if (!StoreOverlayIdForCallback(eOSOverlayId, j)) {
            EOSLog.Overlay.Error(eOSOverlayId + " EOSOverlayWidgetManager.OnExecuteJavascriptFunction, StoreOverlayIdForCallback failed, CallbackId: " + j + ", \n" + Log.getStackTraceString(new Exception()));
            return;
        }
        EOSOverlay.OnExecuteJavascriptFunction(eOSOverlayId.InstanceId, eOSOverlayId.BrowserId, str);
    }

    public void LoadURL(final EOSOverlayId eOSOverlayId, final String str, final String[] strArr, final String str2, EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings) {
        if (eOSOverlayWebviewDisplaySettings == null) {
            EOSLog.Overlay.Warning(eOSOverlayId + " EOSOverlayWidgetManager.LoadURL: no DisplaySettings, creating default ones instead");
        }
        if (eOSOverlayWebviewDisplaySettings == null) {
            eOSOverlayWebviewDisplaySettings = new EOSOverlayWebviewDisplaySettings();
        }
        final EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings2 = eOSOverlayWebviewDisplaySettings;
        EOSSDK.GetActivity().runOnUiThread(new FutureTask(new Callable() { // from class: com.epicgames.mobile.eossdk.EOSOverlayWidgetManager$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return EOSOverlayWidgetManager.this.m55xdf58fb48(eOSOverlayId, str, str2, eOSOverlayWebviewDisplaySettings2, strArr);
            }
        }));
    }

    /* renamed from: lambda$LoadURL$0$com-epicgames-mobile-eossdk-EOSOverlayWidgetManager */
    /* synthetic */ Void m55xdf58fb48(EOSOverlayId eOSOverlayId, String str, String str2, EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings, String[] strArr) throws Exception {
        NewBrowser(eOSOverlayId, str, str2, eOSOverlayWebviewDisplaySettings).LoadURL(str, strArr, eOSOverlayWebviewDisplaySettings);
        return null;
    }

    private EOSOverlayBrowser NewBrowser(EOSOverlayId eOSOverlayId, String str, String str2, EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings) {
        EOSOverlayBrowser FindBrowser = FindBrowser(eOSOverlayId);
        if (FindBrowser != null) {
            EOSLog.Overlay.Warning(eOSOverlayId + " EOSOverlayWidgetManager.NewBrowser, Received LoadURL request with browser already open. Closing existing browser, URL: " + EOSLog.Redact(str));
            FindBrowser.EndWebview(false);
            UnregisterBrowser(FindBrowser);
        }
        EOSOverlayBrowser eOSOverlayBrowser = new EOSOverlayBrowser(EOSSDK.GetActivity(), eOSOverlayId, str2, eOSOverlayWebviewDisplaySettings);
        if (!RegisterBrowser(eOSOverlayBrowser, eOSOverlayId)) {
            EOSLog.Overlay.Error(eOSOverlayId + " EOSOverlayWidgetManager.NewBrowser, Failed to create new Browser");
        }
        return eOSOverlayBrowser;
    }

    public void EndWebview(final EOSOverlayId eOSOverlayId, long j) {
        EOSSDK.GetActivity().runOnUiThread(new FutureTask(new Callable() { // from class: com.epicgames.mobile.eossdk.EOSOverlayWidgetManager$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return EOSOverlayWidgetManager.this.m52x1053dc98(eOSOverlayId);
            }
        }));
    }

    /* renamed from: lambda$EndWebview$1$com-epicgames-mobile-eossdk-EOSOverlayWidgetManager */
    /* synthetic */ Void m52x1053dc98(EOSOverlayId eOSOverlayId) throws Exception {
        EOSOverlayBrowser FindBrowser = FindBrowser(eOSOverlayId);
        if (FindBrowser == null) {
            EOSLog.Overlay.Warning(eOSOverlayId + " EOSOverlayWidgetManager.EndWebview, No such browser can be found");
            return null;
        }
        FindBrowser.EndWebview(false);
        UnregisterBrowser(FindBrowser);
        return null;
    }

    public boolean SetDisplaySettings(EOSOverlayId eOSOverlayId, EOSOverlayWebviewDisplaySettings eOSOverlayWebviewDisplaySettings) {
        if (eOSOverlayWebviewDisplaySettings == null) {
            EOSLog.Overlay.Warning(eOSOverlayId + " EOSOverlayWidgetManager.SetDisplaySettings: no DisplaySettings, creating default ones instead");
            eOSOverlayWebviewDisplaySettings = new EOSOverlayWebviewDisplaySettings();
        }
        EOSOverlayBrowser FindBrowser = FindBrowser(eOSOverlayId);
        if (FindBrowser == null) {
            EOSLog.Overlay.Warning(eOSOverlayId + " EOSOverlayWidgetManager.SetDisplaySettings, No such browser can be found");
            return false;
        }
        FindBrowser.SetDisplaySettings(eOSOverlayWebviewDisplaySettings);
        return true;
    }

    public EOSOverlayWebviewDisplaySettings GetDisplaySettings(EOSOverlayId eOSOverlayId) {
        EOSOverlayBrowser FindBrowser = FindBrowser(eOSOverlayId);
        if (FindBrowser == null) {
            EOSLog.Overlay.Warning(eOSOverlayId + " EOSOverlayWidgetManager.GetDisplaySettings, No such browser can be found");
            return null;
        }
        return FindBrowser.GetDisplaySettings();
    }

    public void EvaluateJS(final EOSOverlayId eOSOverlayId, final long j, final String str) {
        EOSSDK.GetActivity().runOnUiThread(new FutureTask(new Callable() { // from class: com.epicgames.mobile.eossdk.EOSOverlayWidgetManager$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return EOSOverlayWidgetManager.this.m53x77bb681d(eOSOverlayId, j, str);
            }
        }));
    }

    /* renamed from: lambda$EvaluateJS$2$com-epicgames-mobile-eossdk-EOSOverlayWidgetManager */
    /* synthetic */ Boolean m53x77bb681d(EOSOverlayId eOSOverlayId, long j, String str) throws Exception {
        EOSOverlayBrowser FindBrowser = FindBrowser(eOSOverlayId);
        if (FindBrowser == null) {
            EOSLog.Overlay.Warning(eOSOverlayId + " EOSOverlayWidgetManager.EvaluateJS, Eval JS Failed because no such browser can be found, RequestId: " + j);
            return false;
        }
        return Boolean.valueOf(FindBrowser.EvaluateJS(j, true, str));
    }

    public void InvokeJavascriptCallback(final String str, final long j, final long j2, final boolean z) {
        EOSSDK.GetActivity().runOnUiThread(new FutureTask(new Callable() { // from class: com.epicgames.mobile.eossdk.EOSOverlayWidgetManager$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return EOSOverlayWidgetManager.this.m54x8906cca6(j2, j, str, z);
            }
        }));
    }

    /* renamed from: lambda$InvokeJavascriptCallback$3$com-epicgames-mobile-eossdk-EOSOverlayWidgetManager */
    /* synthetic */ Boolean m54x8906cca6(long j, long j2, String str, boolean z) throws Exception {
        EOSOverlayId RetrieveOverlayIdForCallback = RetrieveOverlayIdForCallback(j);
        if (RetrieveOverlayIdForCallback == null) {
            EOSLog.Overlay.Warning(EOSOverlayId.UnknownBrowserIdString(j2) + "EOSOverlayWidgetManager.InvokeJavascriptCallback, No such callback can be found, CallbackId: " + j);
            return false;
        }
        if (RetrieveOverlayIdForCallback.InstanceId != j2) {
            EOSLog.Overlay.Warning(EOSOverlayId.UnknownBrowserIdString(j2) + "EOSOverlayWidgetManager.InvokeJavascriptCallback, Mismatch between stored InstanceId and calling InstanceId, Stored OverlayId: " + RetrieveOverlayIdForCallback + ", CallbackId: " + j);
            return false;
        }
        EOSOverlayBrowser FindBrowser = FindBrowser(RetrieveOverlayIdForCallback);
        if (FindBrowser == null) {
            EOSLog.Overlay.Warning(RetrieveOverlayIdForCallback + " EOSOverlayWidgetManager.InvokeJavascriptCallback, No such browser can be found");
            return false;
        }
        return Boolean.valueOf(FindBrowser.InvokeJavascriptCallback(str, j, z));
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSPreferences.java =====
package com.epicgames.mobile.eossdk;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class EOSPreferences {
    private static final String OVERLAY_ENABLED_FOR_NEXT_LAUNCH_KEY = "EOSSDK.OverlayEnabledForNextLaunch";

    private static SharedPreferences GetSharedPreferences() {
        Context GetApplicationContext = EOSSDK.GetApplicationContext();
        return GetApplicationContext.getSharedPreferences(GetApplicationContext.getPackageName() + "_eos", 0);
    }

    public static boolean GetEnabledForNextLaunch() {
        return GetSharedPreferences().getBoolean(OVERLAY_ENABLED_FOR_NEXT_LAUNCH_KEY, true);
    }

    public static void SetEnabledForNextLaunch(boolean z) {
        SharedPreferences.Editor edit = GetSharedPreferences().edit();
        edit.putBoolean(OVERLAY_ENABLED_FOR_NEXT_LAUNCH_KEY, z);
        edit.apply();
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/EOSSDK.java =====
package com.epicgames.mobile.eossdk;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;
import androidx.webkit.ProxyConfig;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class EOSSDK {
    public static final String AuthKey = "AuthKey";
    public static final String AuthKeyTime = "AuthKeyTime";
    static final String KEYCHAIN_PREFS_FILENAME = "EOS_KeychainPreferences";
    static WebView loginWebView;
    static Activity mActivity;
    static Context mContext;
    static CustomTabsClient mCustomTabsClient;
    static CustomTabsIntent mCustomTabsIntent;
    static CustomTabsSession mCustomTabsSession;
    private static String sPackageNameToUse;
    static LoginState mLoginState = LoginState.NONE;
    public static String EOSUserAgent = "Unknown";
    static final CustomTabsServiceConnection mConnection = new CustomTabsServiceConnection() { // from class: com.epicgames.mobile.eossdk.EOSSDK.1
        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            EOSSDK.mCustomTabsClient = customTabsClient;
            if (!EOSSDK.mCustomTabsClient.warmup(0L)) {
                EOSLog.Eos.Warning("Custom Tab Client warmup failed");
            }
            EOSLog.EosInternal.Log("Custom Tab Client warmup successful");
            EOSSDK.mCustomTabsSession = EOSSDK.mCustomTabsClient.newSession(null);
            if (EOSSDK.mCustomTabsSession == null) {
                EOSLog.Eos.Error("Custom Tab Session failed");
            } else {
                EOSLog.EosInternal.Log("Custom Tab Session successful");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            EOSLog.EosInternal.Log("Custom Tab service disconnected");
            EOSSDK.mCustomTabsClient = null;
            EOSSDK.mCustomTabsSession = null;
            EOSSDK.mCustomTabsIntent = null;
        }
    };
    static final Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.epicgames.mobile.eossdk.EOSSDK.2
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (!EOSAuthHandlerActivity.LoginData.isEmpty()) {
                EOSSDK.CacheLoginData();
            }
            if (!EOSSDK.HasCachedLoginData()) {
                EOSSDK.CancelLogin();
                return;
            }
            int i = C05173.$SwitchMap$com$epicgames$mobile$eossdk$LoginState[EOSSDK.mLoginState.ordinal()];
            if (i == 1) {
                EOSSDK.CompleteLogin(EOSSDK.GetCachedLoginData());
                EOSSDK.ResetCachedLoginData();
            } else if (i != 2) {
                EOSLog.EosInternal.Error("Unhandled case: unknown login state");
            }
        }
    };

    public static native void auth(String str);

    private static class LocalWebViewClient extends WebViewClient {
        private LocalWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String uri = webResourceRequest.getUrl().toString();
            if (!uri.contains("epic/auth?code=")) {
                return false;
            }
            EOSSDK.loginWebView.setVisibility(4);
            EOSSDK.auth(uri);
            EOSSDK.loginWebView.removeAllViews();
            EOSSDK.loginWebView.destroy();
            return false;
        }
    }

    public static void init(Activity activity) {
        mActivity = activity;
        mContext = activity.getApplicationContext();
        initCustomTabClient();
        Application application = mActivity.getApplication();
        if (application != null) {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = mActivityLifecycleCallbacks;
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        if (EOSAuthHandlerActivity.LoginData.isEmpty()) {
            return;
        }
        CacheLoginData();
    }

    public static void setUserAgent(String str) {
        EOSUserAgent = str;
    }

    public static int getDeviceOrientation() {
        return mActivity.getResources().getConfiguration().orientation;
    }

    /* renamed from: com.epicgames.mobile.eossdk.EOSSDK$3 */
    static /* synthetic */ class C05173 {
        static final /* synthetic */ int[] $SwitchMap$com$epicgames$mobile$eossdk$LoginState;

        static {
            int[] iArr = new int[LoginState.values().length];
            $SwitchMap$com$epicgames$mobile$eossdk$LoginState = iArr;
            try {
                iArr[LoginState.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$epicgames$mobile$eossdk$LoginState[LoginState.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static void CacheLoginData() {
        Keychain_WriteValue(AuthKey, EOSAuthHandlerActivity.LoginData);
        Keychain_WriteValue(AuthKeyTime, String.valueOf(EOSAuthHandlerActivity.LoginDataTimestamp));
        EOSAuthHandlerActivity.ResetData();
    }

    static boolean HasCachedLoginData() {
        String Keychain_ReadValue = Keychain_ReadValue(AuthKeyTime);
        if (Keychain_ReadValue == null || Keychain_ReadValue.isEmpty()) {
            return false;
        }
        if (new Date().getTime() - Long.parseLong(Keychain_ReadValue) <= 60000) {
            return true;
        }
        ResetCachedLoginData();
        return false;
    }

    static String GetCachedLoginData() {
        return Keychain_ReadValue(AuthKey);
    }

    static void ResetCachedLoginData() {
        Keychain_WriteValue(AuthKey, "");
        Keychain_WriteValue(AuthKeyTime, "");
    }

    static void CompleteLogin(String str) {
        if (mLoginState == LoginState.IN_PROGRESS) {
            mLoginState = LoginState.COMPLETED;
            auth(str);
        }
    }

    static void CancelLogin() {
        if (mLoginState == LoginState.IN_PROGRESS) {
            mLoginState = LoginState.CANCELED;
            auth("auth?error=cancelled");
        }
    }

    public static String GetOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static Activity GetActivity() {
        return mActivity;
    }

    public static Context GetApplicationContext() {
        return mContext;
    }

    public static String Keychain_ReadValue(String str) {
        try {
            return EncryptedSharedPreferences.create(KEYCHAIN_PREFS_FILENAME, MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC), mActivity, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM).getString(str, "");
        } catch (Exception e) {
            EOSLog.EosInternal.Error("Keychain ReadValue failed. " + e.getMessage());
            return "";
        }
    }

    public static boolean Keychain_WriteValue(String str, String str2) {
        try {
            return EncryptedSharedPreferences.create(KEYCHAIN_PREFS_FILENAME, MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC), mActivity, EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM).edit().putString(str, str2).commit();
        } catch (Exception e) {
            EOSLog.EosInternal.Error("Keychain WriteValue failed. " + e.getMessage());
            return false;
        }
    }

    static void initCustomTabClient() {
        String packageNameToUse = getPackageNameToUse();
        if (packageNameToUse == null) {
            EOSLog.EosInternal.Log("No package found for binding custom tab service");
        } else if (CustomTabsClient.bindCustomTabsService(mActivity, packageNameToUse, mConnection)) {
            EOSLog.EosInternal.Log("Custom tab bind successful");
        } else {
            EOSLog.EosInternal.Log("Custom tab bind fail");
        }
    }

    static List<ResolveInfo> getResolveInfoListDeprecated(Intent intent, int i) {
        return mActivity.getPackageManager().queryIntentActivities(intent, i);
    }

    static List<ResolveInfo> getResolveInfoList(Intent intent, int i) {
        PackageManager packageManager = mActivity.getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(i));
        }
        return getResolveInfoListDeprecated(intent, i);
    }

    static boolean resolverServiceDeprecated(Intent intent) {
        return mActivity.getPackageManager().resolveService(intent, 0) != null;
    }

    static boolean resolveService(Intent intent) {
        PackageManager packageManager = mActivity.getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return packageManager.resolveService(intent, PackageManager.ResolveInfoFlags.of(0L)) != null;
        }
        return resolverServiceDeprecated(intent);
    }

    static String getPackageNameToUse() {
        String str = sPackageNameToUse;
        if (str != null) {
            return str;
        }
        Intent data = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.fromParts(ProxyConfig.MATCH_HTTP, "", null));
        List<ResolveInfo> resolveInfoList = getResolveInfoList(data, 65536);
        if (resolveInfoList.isEmpty()) {
            resolveInfoList = getResolveInfoList(data, 0);
        }
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : resolveInfoList) {
            Intent intent = new Intent();
            intent.setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
            intent.setPackage(resolveInfo.activityInfo.packageName);
            if (resolveService(intent)) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            sPackageNameToUse = null;
        } else {
            sPackageNameToUse = (String) arrayList.get(0);
        }
        return sPackageNameToUse;
    }

    private static boolean isOculus() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "ro.product.manufacturer");
            if (str != null) {
                return str.equals("Oculus");
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static long PrewarmURL(String str) {
        int Value;
        CustomTabsSession customTabsSession = mCustomTabsSession;
        if (customTabsSession == null) {
            EOSLog.Eos.Error("No Custom Tab Session available");
            Value = LaunchUrlResult.CUSTOM_TAB_EXCEPTION.Value();
        } else {
            EOSLog.Eos.Log(customTabsSession.mayLaunchUrl(Uri.parse(str), null, null) ? "Prewarming URL successful" : "Failed to prewarm URL");
            mActivity.getResources();
            CustomTabsIntent build = new CustomTabsIntent.Builder(mCustomTabsSession).setDefaultColorSchemeParams(new CustomTabColorSchemeParams.Builder().setToolbarColor(Color.parseColor("#272727")).build()).setShowTitle(true).build();
            mCustomTabsIntent = build;
            build.intent.addFlags(604012544);
            mCustomTabsIntent.intent.putExtra("android.intent.extra.REFERRER", Uri.parse("android-app://" + mActivity.getPackageName()));
            Value = LaunchUrlResult.SUCCESS.Value();
        }
        return Value;
    }

    public static long LaunchURL(String str) {
        int Value;
        if (!str.startsWith("https://")) {
            EOSLog.Eos.Error("Invalid URL format");
            Value = LaunchUrlResult.INVALID_URL.Value();
        } else {
            mLoginState = LoginState.IN_PROGRESS;
            try {
                isOculus();
                if (HasCachedLoginData()) {
                    CompleteLogin(GetCachedLoginData());
                    ResetCachedLoginData();
                } else {
                    CustomTabsIntent customTabsIntent = mCustomTabsIntent;
                    if (customTabsIntent != null) {
                        customTabsIntent.launchUrl(mActivity, Uri.parse(str));
                    } else {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                        intent.addFlags(1140850688);
                        intent.addFlags(1);
                        intent.addFlags(402653184);
                        ComponentName resolveActivity = intent.resolveActivity(mActivity.getPackageManager());
                        if (resolveActivity == null) {
                            EOSLog.Eos.Error("No browser found for intent");
                            return LaunchUrlResult.RESOLVE_ACTIVITY_EXCEPTION.Value();
                        }
                        if (resolveActivity.getClassName().endsWith("ForwardIntentToParent")) {
                            int myUid = Process.myUid() / 100000;
                            EOSLog.Eos.Error("No browser found in current profile " + myUid);
                            return LaunchUrlResult.ACTIVITY_NOT_FOUND_EXCEPTION.Value();
                        }
                        mActivity.startActivity(intent);
                    }
                }
                return LaunchUrlResult.SUCCESS.Value();
            } catch (ActivityNotFoundException e) {
                EOSLog.Eos.Error("Activity not found. " + e.getMessage());
                Value = LaunchUrlResult.ACTIVITY_NOT_FOUND_EXCEPTION.Value();
            } catch (Exception e2) {
                EOSLog.Eos.Error("Error launching URL. " + e2.getMessage());
                Value = LaunchUrlResult.GENERIC_EXCEPTION.Value();
            }
        }
        return Value;
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/LaunchUrlResult.java =====
package com.epicgames.mobile.eossdk;

/* loaded from: classes.dex */
enum LaunchUrlResult {
    SUCCESS(0),
    INVALID_URL(1),
    RESOLVE_ACTIVITY_EXCEPTION(2),
    ACTIVITY_NOT_FOUND_EXCEPTION(3),
    CUSTOM_TAB_EXCEPTION(4),
    PREWARM_EXCEPTION(5),
    GENERIC_EXCEPTION(6);

    private final int _value;

    public int Value() {
        return this._value;
    }

    LaunchUrlResult(int i) {
        this._value = i;
    }
}

// ===== FILE: com/epicgames/mobile/eossdk/LoginState.java =====
package com.epicgames.mobile.eossdk;

/* loaded from: classes.dex */
enum LoginState {
    NONE,
    IN_PROGRESS,
    COMPLETED,
    CANCELED
}
