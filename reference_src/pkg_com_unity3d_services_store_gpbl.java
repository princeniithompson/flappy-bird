// Package bundle: com.unity3d.services.store.gpbl (3 classes)

// ============================================================
// CLASS: com.unity3d.services.store.gpbl.BillingResultResponseCode
// ============================================================
package com.unity3d.services.store.gpbl;

public final class BillingResultResponseCode extends Enum {
    private static final BillingResultResponseCode[] $VALUES;
    public static final BillingResultResponseCode BILLING_UNAVAILABLE;
    public static final BillingResultResponseCode DEVELOPER_ERROR;
    public static final BillingResultResponseCode ERROR;
    public static final BillingResultResponseCode FEATURE_NOT_SUPPORTED;
    public static final BillingResultResponseCode ITEM_ALREADY_OWNED;
    public static final BillingResultResponseCode ITEM_NOT_OWNED;
    public static final BillingResultResponseCode ITEM_UNAVAILABLE;
    public static final BillingResultResponseCode NETWORK_ERROR;
    public static final BillingResultResponseCode OK;
    public static final BillingResultResponseCode SERVICE_DISCONNECTED;
    public static final BillingResultResponseCode SERVICE_TIMEOUT;
    public static final BillingResultResponseCode SERVICE_UNAVAILABLE;
    public static final BillingResultResponseCode UNKNOWN;
    public static final BillingResultResponseCode USER_CANCELED;
    private final int _responseCode;

    private static BillingResultResponseCode[] $values() {
        return 14;
    }

    static <clinit>() {
        new BillingResultResponseCode("UNKNOWN", 0, -100);
        UNKNOWN = new BillingResultResponseCode(..);
        new BillingResultResponseCode("SERVICE_TIMEOUT", 1, -3);
        SERVICE_TIMEOUT = new BillingResultResponseCode(..);
        new BillingResultResponseCode("FEATURE_NOT_SUPPORTED", 2, -2);
        FEATURE_NOT_SUPPORTED = new BillingResultResponseCode(..);
        new BillingResultResponseCode("SERVICE_DISCONNECTED", 3, -1);
        SERVICE_DISCONNECTED = new BillingResultResponseCode(..);
        new BillingResultResponseCode("OK", 4, 0);
        OK = new BillingResultResponseCode(..);
        new BillingResultResponseCode("USER_CANCELED", 5, 1);
        USER_CANCELED = new BillingResultResponseCode(..);
        new BillingResultResponseCode("SERVICE_UNAVAILABLE", 6, 2);
        SERVICE_UNAVAILABLE = new BillingResultResponseCode(..);
        new BillingResultResponseCode("BILLING_UNAVAILABLE", 7, 3);
        BILLING_UNAVAILABLE = new BillingResultResponseCode(..);
        new BillingResultResponseCode("ITEM_UNAVAILABLE", 8, 4);
        ITEM_UNAVAILABLE = new BillingResultResponseCode(..);
        new BillingResultResponseCode("DEVELOPER_ERROR", 9, 5);
        DEVELOPER_ERROR = new BillingResultResponseCode(..);
        new BillingResultResponseCode("ERROR", 10, 6);
        ERROR = new BillingResultResponseCode(..);
        new BillingResultResponseCode("ITEM_ALREADY_OWNED", 11, 7);
        ITEM_ALREADY_OWNED = new BillingResultResponseCode(..);
        new BillingResultResponseCode("ITEM_NOT_OWNED", 12, 8);
        ITEM_NOT_OWNED = new BillingResultResponseCode(..);
        new BillingResultResponseCode("NETWORK_ERROR", 13, 12);
        NETWORK_ERROR = new BillingResultResponseCode(..);
        BillingResultResponseCode.$values();
        $VALUES = BillingResultResponseCode.$values(..);
        return;
    }

    private BillingResultResponseCode(String p0, int p1, int p2) {
        new Enum(p0, p1);
        _responseCode = p2;
        return;
    }

    public static BillingResultResponseCode fromResponseCode(int p0) {
        BillingResultResponseCode.values();
      L_6:
        if (if-ge(0, v1)) goto L_14;
        BillingResultResponseCode.getResponseCode();
        if (if-ne(BillingResultResponseCode.getResponseCode(..), p0)) goto L_11;
        return v3;
      L_11:
      L_14:
        return BillingResultResponseCode.UNKNOWN;
    }

    public static BillingResultResponseCode valueOf(String p0) {
        Enum.valueOf(BillingResultResponseCode.class, p0);
        return Enum.valueOf(..);
    }

    public static BillingResultResponseCode[] values() {
        BillingResultResponseCode.$VALUES.clone();
        return BillingResultResponseCode[].clone(..);
    }

    public int getResponseCode() {
        return _responseCode;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.IBillingResponse
// ============================================================
package com.unity3d.services.store.gpbl;

public abstract class IBillingResponse {
    public abstract JSONObject getOriginalJson() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.StoreBilling
// ============================================================
package com.unity3d.services.store.gpbl;

public class StoreBilling {
    private final IBillingClient _billingClientBridge;

    public StoreBilling(Context p0, PurchaseUpdatedResponseListener p1) {
        new Object();
        BillingClientBuilderFactory.getBillingClientBuilder(p0);
        new PurchaseUpdatedListenerProxy(p1);
        IBillingClientBuilderBridge.setListener(new PurchaseUpdatedListenerProxy(..));
        IBillingClientBuilderBridge.enablePendingPurchases();
        IBillingClientBuilderBridge.build();
        _billingClientBridge = IBillingClientBuilderBridge.build(..);
        return;
    }

    public void getPurchaseHistory(String p0, int p1, PurchaseHistoryResponseListener p2) {
        new PurchaseHistoryResponseListenerProxy(p2, p1);
        _billingClientBridge.queryPurchaseHistoryAsync(p0, new PurchaseHistoryResponseListenerProxy(..));
        return;
    }

    public void getPurchases(String p0, PurchasesResponseListener p1) {
        new PurchasesResponseListenerProxy(p1);
        _billingClientBridge.queryPurchasesAsync(p0, new PurchasesResponseListenerProxy(..));
        return;
    }

    public void getSkuDetails(String p0, List p1, SkuDetailsResponseListener p2) {
        SkuDetailsParamsBridge.newBuilder();
        SkuDetailsParamsBridge$BuilderBridge.setSkuList(p1);
        SkuDetailsParamsBridge$BuilderBridge.setType(p0);
        SkuDetailsParamsBridge$BuilderBridge.build();
        new SkuDetailsResponseListenerProxy(p2);
        _billingClientBridge.querySkuDetailsAsync(SkuDetailsParamsBridge$BuilderBridge.build(..), new SkuDetailsResponseListenerProxy(..));
        return;
    }

    public void initialize(BillingClientStateListener p0) {
        new BillingClientStateListenerProxy(p0);
        _billingClientBridge.startConnection(new BillingClientStateListenerProxy(..));
        return;
    }

    public int isFeatureSupported(String p0) {
        p0.equals("inapp");
        if (if-eqz(String.equals(..))) goto L_10;
        _billingClientBridge.isReady();
      L_10:
        IBillingClient.isReady(..).equals("subs");
        if (if-eqz(String.equals(..))) goto L_1a;
      L_1a:
        _billingClientBridge.isFeatureSupported("subscriptions");
        if (if-ne(IBillingClient.isFeatureSupported(..), BillingResultResponseCode.OK)) goto L_26;
      L_26:
      L_27:
        if (if-eqz(0)) goto L_2a;
      L_2a:
      L_2b:
        return -1;
    }

}

