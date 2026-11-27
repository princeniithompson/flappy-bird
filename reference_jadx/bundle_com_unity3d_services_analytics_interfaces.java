
// ===== FILE: com/unity3d/services/analytics/interfaces/Analytics.java =====
package com.unity3d.services.analytics.interfaces;

/* loaded from: classes.dex */
public class Analytics {
    public static void initialize(IAnalytics iAnalytics) {
        com.unity3d.services.analytics.core.api.Analytics.setAnalyticsInterface(iAnalytics);
    }
}

// ===== FILE: com/unity3d/services/analytics/interfaces/AnalyticsError.java =====
package com.unity3d.services.analytics.interfaces;

/* loaded from: classes.dex */
public enum AnalyticsError {
    API_NOT_FOUND
}

// ===== FILE: com/unity3d/services/analytics/interfaces/IAnalytics.java =====
package com.unity3d.services.analytics.interfaces;

/* loaded from: classes.dex */
public interface IAnalytics {
    void onAddExtras(String str);
}
