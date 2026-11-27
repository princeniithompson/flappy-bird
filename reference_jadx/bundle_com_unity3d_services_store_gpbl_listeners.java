
// ===== FILE: com/unity3d/services/store/gpbl/listeners/BillingClientStateListener.java =====
package com.unity3d.services.store.gpbl.listeners;

import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import kotlin.Metadata;

/* compiled from: BillingClientStateListener.kt */
@Metadata(m443d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, m444d2 = {"Lcom/unity3d/services/store/gpbl/listeners/BillingClientStateListener;", "", "onBillingServiceDisconnected", "", "onBillingSetupFinished", "billingResult", "Lcom/unity3d/services/store/gpbl/bridges/BillingResultBridge;", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface BillingClientStateListener {
    void onBillingServiceDisconnected();

    void onBillingSetupFinished(BillingResultBridge billingResult);
}

// ===== FILE: com/unity3d/services/store/gpbl/listeners/BillingInitializationListener.java =====
package com.unity3d.services.store.gpbl.listeners;

import kotlin.Metadata;

/* compiled from: BillingInitializationListener.kt */
@Metadata(m443d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0005"}, m444d2 = {"Lcom/unity3d/services/store/gpbl/listeners/BillingInitializationListener;", "Lcom/unity3d/services/store/gpbl/listeners/BillingClientStateListener;", "Lcom/unity3d/services/store/gpbl/listeners/PurchaseUpdatedResponseListener;", "onIsAlreadyInitialized", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface BillingInitializationListener extends BillingClientStateListener, PurchaseUpdatedResponseListener {
    void onIsAlreadyInitialized();
}

// ===== FILE: com/unity3d/services/store/gpbl/listeners/FeatureSupportedListener.java =====
package com.unity3d.services.store.gpbl.listeners;

import kotlin.Metadata;

/* compiled from: FeatureSupportedListener.kt */
@Metadata(m443d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m444d2 = {"Lcom/unity3d/services/store/gpbl/listeners/FeatureSupportedListener;", "", "onFeatureSupported", "", "featureSupported", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface FeatureSupportedListener {
    void onFeatureSupported(int featureSupported);
}

// ===== FILE: com/unity3d/services/store/gpbl/listeners/PurchaseHistoryResponseListener.java =====
package com.unity3d.services.store.gpbl.listeners;

import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseHistoryRecordBridge;
import java.util.List;
import kotlin.Metadata;

/* compiled from: PurchaseHistoryResponseListener.kt */
@Metadata(m443d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¨\u0006\t"}, m444d2 = {"Lcom/unity3d/services/store/gpbl/listeners/PurchaseHistoryResponseListener;", "", "onPurchaseHistoryUpdated", "", "billingResult", "Lcom/unity3d/services/store/gpbl/bridges/BillingResultBridge;", "purchaseHistoryRecordList", "", "Lcom/unity3d/services/store/gpbl/bridges/PurchaseHistoryRecordBridge;", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface PurchaseHistoryResponseListener {
    void onPurchaseHistoryUpdated(BillingResultBridge billingResult, List<? extends PurchaseHistoryRecordBridge> purchaseHistoryRecordList);
}

// ===== FILE: com/unity3d/services/store/gpbl/listeners/PurchaseUpdatedResponseListener.java =====
package com.unity3d.services.store.gpbl.listeners;

import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseBridge;
import java.util.List;
import kotlin.Metadata;

/* compiled from: PurchaseUpdatedResponseListener.kt */
@Metadata(m443d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¨\u0006\t"}, m444d2 = {"Lcom/unity3d/services/store/gpbl/listeners/PurchaseUpdatedResponseListener;", "", "onPurchaseUpdated", "", "billingResult", "Lcom/unity3d/services/store/gpbl/bridges/BillingResultBridge;", "purchases", "", "Lcom/unity3d/services/store/gpbl/bridges/PurchaseBridge;", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface PurchaseUpdatedResponseListener {
    void onPurchaseUpdated(BillingResultBridge billingResult, List<? extends PurchaseBridge> purchases);
}

// ===== FILE: com/unity3d/services/store/gpbl/listeners/PurchasesResponseListener.java =====
package com.unity3d.services.store.gpbl.listeners;

import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseBridge;
import java.util.List;
import kotlin.Metadata;

/* compiled from: PurchasesResponseListener.kt */
@Metadata(m443d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¨\u0006\t"}, m444d2 = {"Lcom/unity3d/services/store/gpbl/listeners/PurchasesResponseListener;", "", "onPurchaseResponse", "", "billingResult", "Lcom/unity3d/services/store/gpbl/bridges/BillingResultBridge;", "purchases", "", "Lcom/unity3d/services/store/gpbl/bridges/PurchaseBridge;", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface PurchasesResponseListener {
    void onPurchaseResponse(BillingResultBridge billingResult, List<? extends PurchaseBridge> purchases);
}

// ===== FILE: com/unity3d/services/store/gpbl/listeners/SkuDetailsResponseListener.java =====
package com.unity3d.services.store.gpbl.listeners;

import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.SkuDetailsBridge;
import java.util.List;
import kotlin.Metadata;

/* compiled from: SkuDetailsResponseListener.kt */
@Metadata(m443d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¨\u0006\t"}, m444d2 = {"Lcom/unity3d/services/store/gpbl/listeners/SkuDetailsResponseListener;", "", "onSkuDetailsUpdated", "", "billingResult", "Lcom/unity3d/services/store/gpbl/bridges/BillingResultBridge;", "skuDetailsList", "", "Lcom/unity3d/services/store/gpbl/bridges/SkuDetailsBridge;", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface SkuDetailsResponseListener {
    void onSkuDetailsUpdated(BillingResultBridge billingResult, List<? extends SkuDetailsBridge> skuDetailsList);
}

// ===== FILE: com/unity3d/services/store/gpbl/listeners/StoreEventListener.java =====
package com.unity3d.services.store.gpbl.listeners;

import kotlin.Metadata;

/* compiled from: StoreEventListener.kt */
@Metadata(m443d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m444d2 = {"Lcom/unity3d/services/store/gpbl/listeners/StoreEventListener;", "Lcom/unity3d/services/store/gpbl/listeners/PurchaseHistoryResponseListener;", "Lcom/unity3d/services/store/gpbl/listeners/SkuDetailsResponseListener;", "Lcom/unity3d/services/store/gpbl/listeners/PurchasesResponseListener;", "Lcom/unity3d/services/store/gpbl/listeners/PurchaseUpdatedResponseListener;", "Lcom/unity3d/services/store/gpbl/listeners/FeatureSupportedListener;", "Lcom/unity3d/services/store/gpbl/listeners/BillingInitializationListener;", "operationId", "", "getOperationId", "()I", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface StoreEventListener extends PurchaseHistoryResponseListener, SkuDetailsResponseListener, PurchasesResponseListener, PurchaseUpdatedResponseListener, FeatureSupportedListener, BillingInitializationListener {
    int getOperationId();
}
