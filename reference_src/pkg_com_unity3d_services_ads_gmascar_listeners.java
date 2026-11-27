// Package bundle: com.unity3d.services.ads.gmascar.listeners (2 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.listeners.IBiddingSignalsListener
// ============================================================
package com.unity3d.services.ads.gmascar.listeners;

public abstract class IBiddingSignalsListener {
    public abstract void onSignalsFailure(String p0) {
        // native or abstract
    }

    public abstract void onSignalsReady(BiddingSignals p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.listeners.IInitializationStatusListener
// ============================================================
package com.unity3d.services.ads.gmascar.listeners;

public abstract class IInitializationStatusListener {
    public abstract void onInitializationComplete(Object p0) {
        // native or abstract
    }

}

