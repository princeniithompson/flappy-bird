
// ===== FILE: com/unity3d/services/store/gpbl/bridges/billingclient/common/BillingClientBridgeCommon.java =====
package com.unity3d.services.store.gpbl.bridges.billingclient.common;

import android.content.Context;
import com.unity3d.services.core.reflection.GenericBridge;
import com.unity3d.services.store.gpbl.BillingResultResponseCode;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge;
import com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient;
import com.unity3d.services.store.gpbl.proxies.BillingClientStateListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchaseHistoryResponseListenerProxy;
import com.unity3d.services.store.gpbl.proxies.SkuDetailsResponseListenerProxy;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class BillingClientBridgeCommon extends GenericBridge implements IBillingClient {
    protected static final String endConnectionMethodName = "endConnection";
    protected static final String isFeatureSupportedMethodName = "isFeatureSupported";
    protected static final String isReadyMethodName = "isReady";
    protected static final String newBuilderMethodName = "newBuilder";
    protected static final String queryPurchaseHistoryAsyncMethodName = "queryPurchaseHistoryAsync";
    protected static final String querySkuDetailsAsyncMethodName = "querySkuDetailsAsync";
    protected static final String startConnectionMethodName = "startConnection";
    private static final Map<String, Class<?>[]> staticMethods = new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBridgeCommon.1
        {
            put(BillingClientBridgeCommon.newBuilderMethodName, new Class[]{Context.class});
        }
    };
    protected final Object _billingClientInternalInstance;

    @Override // com.unity3d.services.core.reflection.GenericBridge
    protected String getClassName() {
        return "com.android.billingclient.api.BillingClient";
    }

    public BillingClientBridgeCommon(Object obj, Map<String, Class<?>[]> map) throws ClassNotFoundException {
        super(appendFunctionAnParameters(map));
        this._billingClientInternalInstance = obj;
    }

    private static Map<String, Class<?>[]> appendFunctionAnParameters(Map<String, Class<?>[]> map) throws ClassNotFoundException {
        map.putAll(new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBridgeCommon.2
            {
                put(BillingClientBridgeCommon.newBuilderMethodName, new Class[]{Context.class});
                put(BillingClientBridgeCommon.startConnectionMethodName, new Class[]{BillingClientStateListenerProxy.getProxyListenerClass()});
                put(BillingClientBridgeCommon.endConnectionMethodName, new Class[0]);
                put(BillingClientBridgeCommon.querySkuDetailsAsyncMethodName, new Class[]{SkuDetailsParamsBridge.getClassForBridge(), SkuDetailsResponseListenerProxy.getProxyListenerClass()});
                put(BillingClientBridgeCommon.queryPurchaseHistoryAsyncMethodName, new Class[]{String.class, PurchaseHistoryResponseListenerProxy.getProxyListenerClass()});
                put(BillingClientBridgeCommon.isFeatureSupportedMethodName, new Class[]{String.class});
                put(BillingClientBridgeCommon.isReadyMethodName, new Class[0]);
            }
        });
        return map;
    }

    protected static Class<?> getClassForBridge() throws ClassNotFoundException {
        return Class.forName("com.android.billingclient.api.BillingClient");
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient
    public void startConnection(BillingClientStateListenerProxy billingClientStateListenerProxy) throws ClassNotFoundException {
        callVoidMethod(startConnectionMethodName, this._billingClientInternalInstance, billingClientStateListenerProxy.getProxyInstance());
    }

    public void endConnection() {
        callVoidMethod(endConnectionMethodName, this._billingClientInternalInstance, new Object[0]);
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient
    public BillingResultResponseCode isFeatureSupported(String str) {
        return new BillingResultBridge(callNonVoidMethod(isFeatureSupportedMethodName, this._billingClientInternalInstance, str)).getResponseCode();
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient
    public boolean isReady() {
        return ((Boolean) callNonVoidMethod(isReadyMethodName, this._billingClientInternalInstance, new Object[0])).booleanValue();
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient
    public void querySkuDetailsAsync(SkuDetailsParamsBridge skuDetailsParamsBridge, SkuDetailsResponseListenerProxy skuDetailsResponseListenerProxy) throws ClassNotFoundException {
        callVoidMethod(querySkuDetailsAsyncMethodName, this._billingClientInternalInstance, skuDetailsParamsBridge.getInternalInstance(), skuDetailsResponseListenerProxy.getProxyInstance());
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClient
    public void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListenerProxy purchaseHistoryResponseListenerProxy) throws ClassNotFoundException {
        callVoidMethod(queryPurchaseHistoryAsyncMethodName, this._billingClientInternalInstance, str, purchaseHistoryResponseListenerProxy.getProxyInstance());
    }

    public static Object callNonVoidStaticMethod(String str, Object... objArr) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        return getClassForBridge().getMethod(str, staticMethods.get(str)).invoke(null, objArr);
    }
}

// ===== FILE: com/unity3d/services/store/gpbl/bridges/billingclient/common/BillingClientBuilderBridgeCommon.java =====
package com.unity3d.services.store.gpbl.bridges.billingclient.common;

import com.unity3d.services.core.reflection.GenericBridge;
import com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClientBuilderBridge;
import com.unity3d.services.store.gpbl.proxies.PurchaseUpdatedListenerProxy;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class BillingClientBuilderBridgeCommon extends GenericBridge implements IBillingClientBuilderBridge {
    protected static final String buildMethodName = "build";
    private static final String enablePendingPurchasesMethodName = "enablePendingPurchases";
    private static final String setListenerMethodName = "setListener";
    protected Object _billingClientBuilderInternalInstance;

    @Override // com.unity3d.services.core.reflection.GenericBridge
    protected String getClassName() {
        return "com.android.billingclient.api.BillingClient$Builder";
    }

    public BillingClientBuilderBridgeCommon(Object obj) throws ClassNotFoundException {
        super(new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.billingclient.common.BillingClientBuilderBridgeCommon.1
            {
                put(BillingClientBuilderBridgeCommon.setListenerMethodName, new Class[]{PurchaseUpdatedListenerProxy.getProxyListenerClass()});
                put(BillingClientBuilderBridgeCommon.enablePendingPurchasesMethodName, new Class[0]);
                put(BillingClientBuilderBridgeCommon.buildMethodName, new Class[0]);
            }
        });
        this._billingClientBuilderInternalInstance = obj;
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClientBuilderBridge
    public IBillingClientBuilderBridge setListener(PurchaseUpdatedListenerProxy purchaseUpdatedListenerProxy) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        this._billingClientBuilderInternalInstance = callNonVoidMethod(setListenerMethodName, this._billingClientBuilderInternalInstance, purchaseUpdatedListenerProxy.getProxyInstance());
        return this;
    }

    @Override // com.unity3d.services.store.gpbl.bridges.billingclient.IBillingClientBuilderBridge
    public IBillingClientBuilderBridge enablePendingPurchases() {
        this._billingClientBuilderInternalInstance = callNonVoidMethod(enablePendingPurchasesMethodName, this._billingClientBuilderInternalInstance, new Object[0]);
        return this;
    }
}
