// Package bundle: com.unity3d.services.store.gpbl.bridges.billingclient (3 classes)

// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.billingclient.BillingClientBuilderFactory
// ============================================================
package com.unity3d.services.store.gpbl.bridges.billingclient;

public class BillingClientBuilderFactory {
    public BillingClientBuilderFactory() {
        new Object();
        return;
    }

    public static IBillingClientBuilderBridge getBillingClientBuilder(Context p0) {
        BillingClientBridge.newBuilder(p0);
        return BillingClientBridge.newBuilder(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient
// ============================================================
package com.unity3d.services.store.gpbl.bridges.billingclient;

public abstract class IBillingClient {
    public abstract BillingResultResponseCode isFeatureSupported(String p0) {
        // native or abstract
    }

    public abstract boolean isReady() {
        // native or abstract
    }

    public abstract void queryPurchaseHistoryAsync(String p0, PurchaseHistoryResponseListenerProxy p1) {
        // native or abstract
    }

    public abstract void queryPurchasesAsync(String p0, PurchasesResponseListenerProxy p1) {
        // native or abstract
    }

    public abstract void querySkuDetailsAsync(SkuDetailsParamsBridge p0, SkuDetailsResponseListenerProxy p1) {
        // native or abstract
    }

    public abstract void startConnection(BillingClientStateListenerProxy p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClientBuilderBridge
// ============================================================
package com.unity3d.services.store.gpbl.bridges.billingclient;

public abstract class IBillingClientBuilderBridge {
    public abstract IBillingClient build() {
        // native or abstract
    }

    public abstract IBillingClientBuilderBridge enablePendingPurchases() {
        // native or abstract
    }

    public abstract IBillingClientBuilderBridge setListener(PurchaseUpdatedListenerProxy p0) {
        // native or abstract
    }

}

