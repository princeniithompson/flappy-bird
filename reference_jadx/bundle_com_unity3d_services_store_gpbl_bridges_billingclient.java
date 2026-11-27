
// ===== FILE: com/unity3d/services/store/gpbl/bridges/billingclient/BillingClientBuilderFactory.java =====
package com.unity3d.services.store.gpbl.bridges.billingclient;

import android.content.Context;
import com.unity3d.services.store.gpbl.bridges.billingclient.p006v4.BillingClientBridge;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class BillingClientBuilderFactory {
    public static IBillingClientBuilderBridge getBillingClientBuilder(Context context) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return BillingClientBridge.newBuilder(context);
    }
}

// ===== FILE: com/unity3d/services/store/gpbl/bridges/billingclient/IBillingClient.java =====
package com.unity3d.services.store.gpbl.bridges.billingclient;

import com.unity3d.services.store.gpbl.BillingResultResponseCode;
import com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge;
import com.unity3d.services.store.gpbl.proxies.BillingClientStateListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchaseHistoryResponseListenerProxy;
import com.unity3d.services.store.gpbl.proxies.PurchasesResponseListenerProxy;
import com.unity3d.services.store.gpbl.proxies.SkuDetailsResponseListenerProxy;

/* loaded from: classes.dex */
public interface IBillingClient {
    BillingResultResponseCode isFeatureSupported(String str);

    boolean isReady();

    void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListenerProxy purchaseHistoryResponseListenerProxy) throws ClassNotFoundException;

    void queryPurchasesAsync(String str, PurchasesResponseListenerProxy purchasesResponseListenerProxy) throws ClassNotFoundException;

    void querySkuDetailsAsync(SkuDetailsParamsBridge skuDetailsParamsBridge, SkuDetailsResponseListenerProxy skuDetailsResponseListenerProxy) throws ClassNotFoundException;

    void startConnection(BillingClientStateListenerProxy billingClientStateListenerProxy) throws ClassNotFoundException;
}

// ===== FILE: com/unity3d/services/store/gpbl/bridges/billingclient/IBillingClientBuilderBridge.java =====
package com.unity3d.services.store.gpbl.bridges.billingclient;

import com.unity3d.services.store.gpbl.proxies.PurchaseUpdatedListenerProxy;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public interface IBillingClientBuilderBridge {
    IBillingClient build() throws ClassNotFoundException;

    IBillingClientBuilderBridge enablePendingPurchases();

    IBillingClientBuilderBridge setListener(PurchaseUpdatedListenerProxy purchaseUpdatedListenerProxy) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
