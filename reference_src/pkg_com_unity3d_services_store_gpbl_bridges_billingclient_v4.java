// Package bundle: com.unity3d.services.store.gpbl.bridges.billingclient.v4 (3 classes)

// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.billingclient.v4.BillingClientBridge
// ============================================================
package com.unity3d.services.store.gpbl.bridges.billingclient.v4;

public class BillingClientBridge extends BillingClientBridgeCommon {
    private static final String queryPurchasesAsyncMethodName = "queryPurchasesAsync";

    public BillingClientBridge(Object p0) {
        new BillingClientBridge$1();
        new BillingClientBridgeCommon(p0, new BillingClientBridge$1(..));
        return;
    }

    public static boolean isAvailable() {
        BillingClientBridge.getClassForBridge();
        PurchasesResponseListenerProxy.getProxyListenerClass();
        Class.getMethod("queryPurchasesAsync", 2);
        return 1;
    }

    public static BillingClientBridge$BuilderBridge newBuilder(Context p0) {
        BillingClientBridge.callNonVoidStaticMethod("newBuilder", 1);
        new BillingClientBridge$BuilderBridge(BillingClientBridge.callNonVoidStaticMethod(..));
        return new BillingClientBridge$BuilderBridge(..);
    }

    public void queryPurchasesAsync(String p0, PurchasesResponseListenerProxy p1) {
        p1.getProxyInstance();
        BillingClientBridge.callVoidMethod("queryPurchasesAsync", _billingClientInternalInstance, 2);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.billingclient.v4.BillingClientBridge$1
// ============================================================
package com.unity3d.services.store.gpbl.bridges.billingclient.v4;

class BillingClientBridge$1 extends HashMap {
    BillingClientBridge$1() {
        new HashMap();
        PurchasesResponseListenerProxy.getProxyListenerClass();
        new HashMap(..).put("queryPurchasesAsync", 2);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.billingclient.v4.BillingClientBridge$BuilderBridge
// ============================================================
package com.unity3d.services.store.gpbl.bridges.billingclient.v4;

public class BillingClientBridge$BuilderBridge extends BillingClientBuilderBridgeCommon {
    public BillingClientBridge$BuilderBridge(Object p0) {
        new BillingClientBuilderBridgeCommon(p0);
        return;
    }

    public IBillingClient build() {
        BillingClientBridge$BuilderBridge.build();
        return BillingClientBridge$BuilderBridge.build(..);
    }

    public BillingClientBridgeCommon build() {
        BillingClientBridge$BuilderBridge.callNonVoidMethod("build", _billingClientBuilderInternalInstance, 0);
        new BillingClientBridge(BillingClientBridge$BuilderBridge.callNonVoidMethod(..));
        return new BillingClientBridge(..);
    }

}

