// Package bundle: com.unity3d.services.analytics.core.api (2 classes)

// ============================================================
// CLASS: com.unity3d.services.analytics.core.api.Analytics
// ============================================================
package com.unity3d.services.analytics.core.api;

public class Analytics {
    public static IAnalytics analyticsInterface;

    static <clinit>() {
        return;
    }

    public Analytics() {
        new Object();
        return;
    }

    public static void addExtras(String p0, WebViewCallback p1) {
        if (if-eqz(Analytics.analyticsInterface)) goto L_13;
        new Analytics$1(p0);
        Utilities.runOnUiThread(new Analytics$1(..));
        p1.invoke(p0);
      L_13:
        p1.error(AnalyticsError.API_NOT_FOUND, 1);
      L_1d:
        return;
    }

    public static void setAnalyticsInterface(IAnalytics p0) {
        analyticsInterface = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.analytics.core.api.Analytics$1
// ============================================================
package com.unity3d.services.analytics.core.api;

class Analytics$1 {
    final String val$extras;

    Analytics$1(String p0) {
        val$extras = p0;
        new Object();
        return;
    }

    public void run() {
        Analytics.analyticsInterface.onAddExtras(val$extras);
        return;
    }

}

