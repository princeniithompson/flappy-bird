// Package bundle: com.unity3d.services.store.gpbl.bridges.billingclient.common (5 classes)

// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBridgeCommon
// ============================================================
package com.unity3d.services.store.gpbl.bridges.billingclient.common;

public abstract class BillingClientBridgeCommon extends GenericBridge {
    protected static final String endConnectionMethodName = "endConnection";
    protected static final String isFeatureSupportedMethodName = "isFeatureSupported";
    protected static final String isReadyMethodName = "isReady";
    protected static final String newBuilderMethodName = "newBuilder";
    protected static final String queryPurchaseHistoryAsyncMethodName = "queryPurchaseHistoryAsync";
    protected static final String querySkuDetailsAsyncMethodName = "querySkuDetailsAsync";
    protected static final String startConnectionMethodName = "startConnection";
    private static final Map staticMethods;
    protected final Object _billingClientInternalInstance;

    static <clinit>() {
        new BillingClientBridgeCommon$1();
        staticMethods = new BillingClientBridgeCommon$1(..);
        return;
    }

    public BillingClientBridgeCommon(Object p0, Map p1) {
        BillingClientBridgeCommon.appendFunctionAnParameters(p1);
        new GenericBridge(BillingClientBridgeCommon.appendFunctionAnParameters(..));
        _billingClientInternalInstance = p0;
        return;
    }

    private static Map appendFunctionAnParameters(Map p0) {
        new BillingClientBridgeCommon$2();
        p0.putAll(new BillingClientBridgeCommon$2(..));
        return p0;
    }

    public static Object callNonVoidStaticMethod(String p0, Object[] p1) {
        BillingClientBridgeCommon.getClassForBridge();
        Map.get(p0);
        Class.getMethod(p0, Map.get(..));
        Class.getMethod(..).invoke(0, p1);
        return Method.invoke(..);
    }

    protected static Class getClassForBridge() {
        Class.forName("com.android.billingclient.api.BillingClient");
        return Class.forName(..);
    }

    public void endConnection() {
        BillingClientBridgeCommon.callVoidMethod("endConnection", _billingClientInternalInstance, 0);
        return;
    }

    protected String getClassName() {
        return "com.android.billingclient.api.BillingClient";
    }

    public BillingResultResponseCode isFeatureSupported(String p0) {
        BillingClientBridgeCommon.callNonVoidMethod("isFeatureSupported", _billingClientInternalInstance, 1);
        new BillingResultBridge(BillingClientBridgeCommon.callNonVoidMethod(..));
        new BillingResultBridge(..).getResponseCode();
        return BillingResultBridge.getResponseCode(..);
    }

    public boolean isReady() {
        BillingClientBridgeCommon.callNonVoidMethod("isReady", _billingClientInternalInstance, 0);
        Boolean.booleanValue();
        return Boolean.booleanValue(..);
    }

    public void queryPurchaseHistoryAsync(String p0, PurchaseHistoryResponseListenerProxy p1) {
        p1.getProxyInstance();
        BillingClientBridgeCommon.callVoidMethod("queryPurchaseHistoryAsync", _billingClientInternalInstance, 2);
        return;
    }

    public void querySkuDetailsAsync(SkuDetailsParamsBridge p0, SkuDetailsResponseListenerProxy p1) {
        p0.getInternalInstance();
        p1.getProxyInstance();
        BillingClientBridgeCommon.callVoidMethod("querySkuDetailsAsync", _billingClientInternalInstance, 2);
        return;
    }

    public void startConnection(BillingClientStateListenerProxy p0) {
        p0.getProxyInstance();
        BillingClientBridgeCommon.callVoidMethod("startConnection", _billingClientInternalInstance, 1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBuilderBridgeCommon
// ============================================================
package com.unity3d.services.store.gpbl.bridges.billingclient.common;

public abstract class BillingClientBuilderBridgeCommon extends GenericBridge {
    protected static final String buildMethodName = "build";
    private static final String enablePendingPurchasesMethodName = "enablePendingPurchases";
    private static final String setListenerMethodName = "setListener";
    protected Object _billingClientBuilderInternalInstance;

    public BillingClientBuilderBridgeCommon(Object p0) {
        new BillingClientBuilderBridgeCommon$1();
        new GenericBridge(new BillingClientBuilderBridgeCommon$1(..));
        _billingClientBuilderInternalInstance = p0;
        return;
    }

    public IBillingClientBuilderBridge enablePendingPurchases() {
        BillingClientBuilderBridgeCommon.callNonVoidMethod("enablePendingPurchases", _billingClientBuilderInternalInstance, 0);
        _billingClientBuilderInternalInstance = BillingClientBuilderBridgeCommon.callNonVoidMethod(..);
        return this;
    }

    protected String getClassName() {
        return "com.android.billingclient.api.BillingClient$Builder";
    }

    public IBillingClientBuilderBridge setListener(PurchaseUpdatedListenerProxy p0) {
        p0.getProxyInstance();
        BillingClientBuilderBridgeCommon.callNonVoidMethod("setListener", _billingClientBuilderInternalInstance, 1);
        _billingClientBuilderInternalInstance = BillingClientBuilderBridgeCommon.callNonVoidMethod(..);
        return this;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBridgeCommon$1
// ============================================================
package com.unity3d.services.store.gpbl.bridges.billingclient.common;

class BillingClientBridgeCommon$1 extends HashMap {
    BillingClientBridgeCommon$1() {
        new HashMap();
        new HashMap(..).put("newBuilder", 1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBridgeCommon$2
// ============================================================
package com.unity3d.services.store.gpbl.bridges.billingclient.common;

class BillingClientBridgeCommon$2 extends HashMap {
    BillingClientBridgeCommon$2() {
        new HashMap();
        new HashMap(..).put("newBuilder", v1);
        BillingClientStateListenerProxy.getProxyListenerClass();
        new HashMap(..).put("startConnection", v1);
        new HashMap(..).put("endConnection", "startConnection");
        SkuDetailsParamsBridge.getClassForBridge();
        SkuDetailsResponseListenerProxy.getProxyListenerClass();
        new HashMap(..).put("querySkuDetailsAsync", "startConnection");
        PurchaseHistoryResponseListenerProxy.getProxyListenerClass();
        new HashMap(..).put("queryPurchaseHistoryAsync", 2);
        new HashMap(..).put("isFeatureSupported", 1);
        new HashMap(..).put("isReady", "isFeatureSupported");
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBuilderBridgeCommon$1
// ============================================================
package com.unity3d.services.store.gpbl.bridges.billingclient.common;

class BillingClientBuilderBridgeCommon$1 extends HashMap {
    BillingClientBuilderBridgeCommon$1() {
        new HashMap();
        PurchaseUpdatedListenerProxy.getProxyListenerClass();
        new HashMap(..).put("setListener", 1);
        new HashMap(..).put("enablePendingPurchases", "setListener");
        new HashMap(..).put("build", "setListener");
        return;
    }

}

