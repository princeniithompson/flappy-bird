// Package bundle: com.unity3d.services.store.gpbl.proxies (5 classes)

// ============================================================
// CLASS: com.unity3d.services.store.gpbl.proxies.BillingClientStateListenerProxy
// ============================================================
package com.unity3d.services.store.gpbl.proxies;

public class BillingClientStateListenerProxy extends GenericListenerProxy {
    private static String onBillingServiceDisconnectedMethodName = "onBillingServiceDisconnected";
    private static String onBillingSetupFinishedMethodName = "onBillingSetupFinished";
    private BillingClientStateListener billingClientStateListener;

    static <clinit>() {
        return;
    }

    public BillingClientStateListenerProxy(BillingClientStateListener p0) {
        new GenericListenerProxy();
        billingClientStateListener = p0;
        return;
    }

    public static Class getProxyListenerClass() {
        Class.forName("com.android.billingclient.api.BillingClientStateListener");
        return Class.forName(..);
    }

    private void onBillingServiceDisconnected() {
        if (if-eqz(billingClientStateListener)) goto L_7;
        billingClientStateListener.onBillingServiceDisconnected();
      L_7:
        return;
    }

    private void onBillingSetupFinished(Object p0) {
        if (if-eqz(billingClientStateListener)) goto L_c;
        new BillingResultBridge(p0);
        billingClientStateListener.onBillingSetupFinished(new BillingResultBridge(..));
      L_c:
        return;
    }

    public Class getProxyClass() {
        BillingClientStateListenerProxy.getProxyListenerClass();
        return BillingClientStateListenerProxy.getProxyListenerClass(..);
    }

    public Object invoke(Object p0, Method p1, Object[] p2) {
        p1.getName();
        Method.getName(..).equals(BillingClientStateListenerProxy.onBillingSetupFinishedMethodName);
        if (if-eqz(String.equals(..))) goto L_13;
        BillingClientStateListenerProxy.onBillingSetupFinished(0);
      L_13:
        p1.getName();
        Method.getName(..).equals(BillingClientStateListenerProxy.onBillingServiceDisconnectedMethodName);
        if (if-eqz(String.equals(..))) goto L_24;
        BillingClientStateListenerProxy.onBillingServiceDisconnected();
      L_22:
      L_24:
        GenericListenerProxy.invoke(0, p1, p2);
      L_28:
        return GenericListenerProxy.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.proxies.PurchaseHistoryResponseListenerProxy
// ============================================================
package com.unity3d.services.store.gpbl.proxies;

public class PurchaseHistoryResponseListenerProxy extends GenericListenerProxy {
    private static final String onPurchaseHistoryResponseMethodName = "onPurchaseHistoryResponse";
    private int _maxPurchases;
    private PurchaseHistoryResponseListener purchaseHistoryResponseListener;

    public PurchaseHistoryResponseListenerProxy(PurchaseHistoryResponseListener p0, int p1) {
        new GenericListenerProxy();
        purchaseHistoryResponseListener = p0;
        _maxPurchases = p1;
        return;
    }

    public static Class getProxyListenerClass() {
        Class.forName("com.android.billingclient.api.PurchaseHistoryResponseListener");
        return Class.forName(..);
    }

    public Class getProxyClass() {
        PurchaseHistoryResponseListenerProxy.getProxyListenerClass();
        return PurchaseHistoryResponseListenerProxy.getProxyListenerClass(..);
    }

    public Object invoke(Object p0, Method p1, Object[] p2) {
        p1.getName();
        Method.getName(..).equals("onPurchaseHistoryResponse");
        if (if-eqz(String.equals(..))) goto L_19;
        PurchaseHistoryResponseListenerProxy.onPurchaseHistoryResponse(0, 1);
      L_19:
        GenericListenerProxy.invoke(0, 1, p2);
      L_1d:
        return GenericListenerProxy.invoke(..);
    }

    public void onPurchaseHistoryResponse(Object p0, List p1) {
        if (if-eqz(p1)) goto L_21;
        new ArrayList();
      L_8:
        if (if-ge(0, _maxPurchases)) goto L_22;
        p1.size();
        if (if-ge(0, List.size(..))) goto L_22;
        p1.get(0);
        new PurchaseHistoryRecordBridge(List.get(..));
        new ArrayList(..).add(new PurchaseHistoryRecordBridge(..));
      L_21:
      L_22:
        if (if-eqz(purchaseHistoryResponseListener)) goto L_2e;
        new BillingResultBridge(p0);
        purchaseHistoryResponseListener.onPurchaseHistoryUpdated(new BillingResultBridge(..), 0);
      L_2e:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.proxies.PurchaseUpdatedListenerProxy
// ============================================================
package com.unity3d.services.store.gpbl.proxies;

public class PurchaseUpdatedListenerProxy extends GenericListenerProxy {
    private static final String onPurchasesUpdatedMethodName = "onPurchasesUpdated";
    private PurchaseUpdatedResponseListener purchaseUpdatedResponseListener;

    public PurchaseUpdatedListenerProxy(PurchaseUpdatedResponseListener p0) {
        new GenericListenerProxy();
        purchaseUpdatedResponseListener = p0;
        return;
    }

    public static Class getProxyListenerClass() {
        Class.forName("com.android.billingclient.api.PurchasesUpdatedListener");
        return Class.forName(..);
    }

    public Class getProxyClass() {
        PurchaseUpdatedListenerProxy.getProxyListenerClass();
        return PurchaseUpdatedListenerProxy.getProxyListenerClass(..);
    }

    public Object invoke(Object p0, Method p1, Object[] p2) {
        p1.getName();
        Method.getName(..).equals("onPurchasesUpdated");
        if (if-eqz(String.equals(..))) goto L_19;
        PurchaseUpdatedListenerProxy.onPurchasesUpdated(0, 1);
      L_19:
        GenericListenerProxy.invoke(0, 1, p2);
      L_1d:
        return GenericListenerProxy.invoke(..);
    }

    public void onPurchasesUpdated(Object p0, List p1) {
        if (if-eqz(p1)) goto L_1e;
        new ArrayList();
        p1.iterator();
      L_b:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_1f;
        List.iterator(..).next();
        new PurchaseBridge(Iterator.next(..));
        new ArrayList(..).add(new PurchaseBridge(..));
      L_1e:
      L_1f:
        if (if-eqz(purchaseUpdatedResponseListener)) goto L_2b;
        new BillingResultBridge(p0);
        purchaseUpdatedResponseListener.onPurchaseUpdated(new BillingResultBridge(..), 0);
      L_2b:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.proxies.PurchasesResponseListenerProxy
// ============================================================
package com.unity3d.services.store.gpbl.proxies;

public class PurchasesResponseListenerProxy extends GenericListenerProxy {
    private static final String onQueryPurchasesResponseMethodName = "onQueryPurchasesResponse";
    private PurchasesResponseListener purchasesResponseListener;

    public PurchasesResponseListenerProxy(PurchasesResponseListener p0) {
        new GenericListenerProxy();
        purchasesResponseListener = p0;
        return;
    }

    public static Class getProxyListenerClass() {
        Class.forName("com.android.billingclient.api.PurchasesResponseListener");
        return Class.forName(..);
    }

    public Class getProxyClass() {
        PurchasesResponseListenerProxy.getProxyListenerClass();
        return PurchasesResponseListenerProxy.getProxyListenerClass(..);
    }

    public PurchasesResponseListener getPurchasesResponseListener() {
        return purchasesResponseListener;
    }

    public Object invoke(Object p0, Method p1, Object[] p2) {
        p1.getName();
        Method.getName(..).equals("onQueryPurchasesResponse");
        if (if-eqz(String.equals(..))) goto L_19;
        PurchasesResponseListenerProxy.onQueryPurchasesResponse(0, 1);
      L_19:
        GenericListenerProxy.invoke(0, 1, p2);
      L_1d:
        return GenericListenerProxy.invoke(..);
    }

    public void onQueryPurchasesResponse(Object p0, List p1) {
        new BillingResultBridge(p0);
        if (if-eqz(p1)) goto L_23;
        new ArrayList();
        p1.iterator();
      L_10:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_24;
        List.iterator(..).next();
        new PurchaseBridge(Iterator.next(..));
        new ArrayList(..).add(new PurchaseBridge(..));
      L_23:
      L_24:
        if (if-eqz(purchasesResponseListener)) goto L_2b;
        purchasesResponseListener.onPurchaseResponse(new BillingResultBridge(..), 0);
      L_2b:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.proxies.SkuDetailsResponseListenerProxy
// ============================================================
package com.unity3d.services.store.gpbl.proxies;

public class SkuDetailsResponseListenerProxy extends GenericListenerProxy {
    private static final String onSkuDetailsResponseMethodName = "onSkuDetailsResponse";
    private SkuDetailsResponseListener skuDetailsResponseListener;

    public SkuDetailsResponseListenerProxy(SkuDetailsResponseListener p0) {
        new GenericListenerProxy();
        skuDetailsResponseListener = p0;
        return;
    }

    public static Class getProxyListenerClass() {
        Class.forName("com.android.billingclient.api.SkuDetailsResponseListener");
        return Class.forName(..);
    }

    public Class getProxyClass() {
        SkuDetailsResponseListenerProxy.getProxyListenerClass();
        return SkuDetailsResponseListenerProxy.getProxyListenerClass(..);
    }

    public Object invoke(Object p0, Method p1, Object[] p2) {
        p1.getName();
        Method.getName(..).equals("onSkuDetailsResponse");
        if (if-eqz(String.equals(..))) goto L_19;
        SkuDetailsResponseListenerProxy.onSkuDetailsResponse(0, 1);
      L_19:
        GenericListenerProxy.invoke(0, 1, p2);
      L_1d:
        return GenericListenerProxy.invoke(..);
    }

    public void onSkuDetailsResponse(Object p0, List p1) {
        if (if-eqz(p1)) goto L_1e;
        new ArrayList();
        p1.iterator();
      L_b:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_1f;
        List.iterator(..).next();
        new SkuDetailsBridge(Iterator.next(..));
        new ArrayList(..).add(new SkuDetailsBridge(..));
      L_1e:
      L_1f:
        if (if-eqz(skuDetailsResponseListener)) goto L_2b;
        new BillingResultBridge(p0);
        skuDetailsResponseListener.onSkuDetailsUpdated(new BillingResultBridge(..), 0);
      L_2b:
        return;
    }

}

