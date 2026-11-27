// Package bundle: com.unity3d.services.analytics.interfaces (3 classes)

// ============================================================
// CLASS: com.unity3d.services.analytics.interfaces.Analytics
// ============================================================
package com.unity3d.services.analytics.interfaces;

public class Analytics {
    public Analytics() {
        new Object();
        return;
    }

    public static void initialize(IAnalytics p0) {
        Analytics.setAnalyticsInterface(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.analytics.interfaces.AnalyticsError
// ============================================================
package com.unity3d.services.analytics.interfaces;

public final class AnalyticsError extends Enum {
    private static final AnalyticsError[] $VALUES;
    public static final AnalyticsError API_NOT_FOUND;

    private static AnalyticsError[] $values() {
        return 1;
    }

    static <clinit>() {
        new AnalyticsError("API_NOT_FOUND", 0);
        API_NOT_FOUND = new AnalyticsError(..);
        AnalyticsError.$values();
        $VALUES = AnalyticsError.$values(..);
        return;
    }

    private AnalyticsError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static AnalyticsError valueOf(String p0) {
        Enum.valueOf(AnalyticsError.class, p0);
        return Enum.valueOf(..);
    }

    public static AnalyticsError[] values() {
        AnalyticsError.$VALUES.clone();
        return AnalyticsError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.analytics.interfaces.IAnalytics
// ============================================================
package com.unity3d.services.analytics.interfaces;

public abstract class IAnalytics {
    public abstract void onAddExtras(String p0) {
        // native or abstract
    }

}

