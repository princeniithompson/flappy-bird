// Package bundle: com.unity3d.services.analytics.core.configuration (1 classes)

// ============================================================
// CLASS: com.unity3d.services.analytics.core.configuration.AnalyticsModuleConfiguration
// ============================================================
package com.unity3d.services.analytics.core.configuration;

public class AnalyticsModuleConfiguration {
    private static final Class[] WEB_APP_API_CLASS_LIST;

    static <clinit>() {
        WEB_APP_API_CLASS_LIST = 1;
        return;
    }

    public AnalyticsModuleConfiguration() {
        new Object();
        return;
    }

    public Class[] getWebAppApiClassList() {
        return AnalyticsModuleConfiguration.WEB_APP_API_CLASS_LIST;
    }

    public boolean initCompleteState(Configuration p0) {
        return 1;
    }

    public boolean initErrorState(Configuration p0, ErrorState p1, String p2) {
        return 1;
    }

    public boolean resetState(Configuration p0) {
        return 1;
    }

}

