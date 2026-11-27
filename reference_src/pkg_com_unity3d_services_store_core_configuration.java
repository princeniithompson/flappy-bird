// Package bundle: com.unity3d.services.store.core.configuration (1 classes)

// ============================================================
// CLASS: com.unity3d.services.store.core.configuration.StoreModuleConfiguration
// ============================================================
package com.unity3d.services.store.core.configuration;

public class StoreModuleConfiguration {
    private static final Class[] WEB_APP_API_CLASS_LIST;

    static <clinit>() {
        WEB_APP_API_CLASS_LIST = 1;
        return;
    }

    public StoreModuleConfiguration() {
        new Object();
        return;
    }

    public Class[] getWebAppApiClassList() {
        return StoreModuleConfiguration.WEB_APP_API_CLASS_LIST;
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

