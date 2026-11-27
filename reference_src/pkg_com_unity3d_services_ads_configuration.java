// Package bundle: com.unity3d.services.ads.configuration (2 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.configuration.AdsModuleConfiguration
// ============================================================
package com.unity3d.services.ads.configuration;

public class AdsModuleConfiguration {
    private InetAddress _address;
    private final AsyncTokenStorage asyncTokenStorage;
    private final TokenStorage tokenStorage;

    public AdsModuleConfiguration() {
        new Object();
        Utilities.getService(TokenStorage.class);
        tokenStorage = Utilities.getService(..);
        Utilities.getService(AsyncTokenStorage.class);
        asyncTokenStorage = Utilities.getService(..);
        return;
    }

    public Map getAdUnitViewHandlers() {
        new HashMap();
        new HashMap(..).put("videoplayer", VideoPlayerHandler.class);
        new HashMap(..).put("webplayer", WebPlayerHandler.class);
        new HashMap(..).put("webview", WebViewHandler.class);
        return new HashMap(..);
    }

    public Class[] getWebAppApiClassList() {
        return 9;
    }

    public boolean initCompleteState(Configuration p0) {
        AdUnitOpen.setConfiguration(p0);
        UnityAdsImplementation.setConfiguration(p0);
        asyncTokenStorage.setConfiguration(p0);
        return 1;
    }

    public boolean initErrorState(Configuration p0, ErrorState p1, String p2) {
        tokenStorage.setInitToken(0);
        tokenStorage.deleteTokens();
        return 1;
    }

    public boolean resetState(Configuration p0) {
        AdUnitOpen.setConfiguration(p0);
        UnityAdsImplementation.setConfiguration(p0);
        tokenStorage.deleteTokens();
        asyncTokenStorage.setConfiguration(p0);
        return 1;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.configuration.IAdsModuleConfiguration
// ============================================================
package com.unity3d.services.ads.configuration;

public abstract class IAdsModuleConfiguration {
    public abstract Map getAdUnitViewHandlers() {
        // native or abstract
    }

}

