// Package bundle: com.unity3d.services.store.gpbl.listeners (8 classes)

// ============================================================
// CLASS: com.unity3d.services.store.gpbl.listeners.BillingClientStateListener
// ============================================================
package com.unity3d.services.store.gpbl.listeners;

public abstract class BillingClientStateListener {
    public abstract void onBillingServiceDisconnected() {
        // native or abstract
    }

    public abstract void onBillingSetupFinished(BillingResultBridge p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.listeners.BillingInitializationListener
// ============================================================
package com.unity3d.services.store.gpbl.listeners;

public abstract class BillingInitializationListener {
    public abstract void onIsAlreadyInitialized() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.listeners.FeatureSupportedListener
// ============================================================
package com.unity3d.services.store.gpbl.listeners;

public abstract class FeatureSupportedListener {
    public abstract void onFeatureSupported(int p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.listeners.PurchaseHistoryResponseListener
// ============================================================
package com.unity3d.services.store.gpbl.listeners;

public abstract class PurchaseHistoryResponseListener {
    public abstract void onPurchaseHistoryUpdated(BillingResultBridge p0, List p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.listeners.PurchaseUpdatedResponseListener
// ============================================================
package com.unity3d.services.store.gpbl.listeners;

public abstract class PurchaseUpdatedResponseListener {
    public abstract void onPurchaseUpdated(BillingResultBridge p0, List p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.listeners.PurchasesResponseListener
// ============================================================
package com.unity3d.services.store.gpbl.listeners;

public abstract class PurchasesResponseListener {
    public abstract void onPurchaseResponse(BillingResultBridge p0, List p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.listeners.SkuDetailsResponseListener
// ============================================================
package com.unity3d.services.store.gpbl.listeners;

public abstract class SkuDetailsResponseListener {
    public abstract void onSkuDetailsUpdated(BillingResultBridge p0, List p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.listeners.StoreEventListener
// ============================================================
package com.unity3d.services.store.gpbl.listeners;

public abstract class StoreEventListener {
    public abstract int getOperationId() {
        // native or abstract
    }

}

