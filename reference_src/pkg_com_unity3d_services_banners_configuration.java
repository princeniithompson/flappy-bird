// Package bundle: com.unity3d.services.banners.configuration (1 classes)

// ============================================================
// CLASS: com.unity3d.services.banners.configuration.BannersModuleConfiguration
// ============================================================
package com.unity3d.services.banners.configuration;

public class BannersModuleConfiguration {
    private static final Class[] WEB_APP_API_CLASS_LIST;

    static <clinit>() {
        WEB_APP_API_CLASS_LIST = 2;
        return;
    }

    public BannersModuleConfiguration() {
        new Object();
        return;
    }

    public Class[] getWebAppApiClassList() {
        return BannersModuleConfiguration.WEB_APP_API_CLASS_LIST;
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

