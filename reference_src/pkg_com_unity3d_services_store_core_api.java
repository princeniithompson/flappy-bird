// Package bundle: com.unity3d.services.store.core.api (1 classes)

// ============================================================
// CLASS: com.unity3d.services.store.core.api.Store
// ============================================================
package com.unity3d.services.store.core.api;

public class Store {
    private static final WebViewStoreExceptionHandler WEB_VIEW_STORE_EXCEPTION_HANDLER;
    private static final StoreEventListenerFactory storeEventListenerFactory;
    private static final StoreMonitor storeMonitor;

    static <clinit>() {
        new WebViewErrorHandler();
        new WebViewStoreExceptionHandler(new WebViewErrorHandler(..));
        WEB_VIEW_STORE_EXCEPTION_HANDLER = new WebViewStoreExceptionHandler(..);
        Utilities.getService(StoreEventListenerFactory.class);
        storeEventListenerFactory = Utilities.getService(..);
        new StoreMonitor(new WebViewStoreExceptionHandler(..));
        storeMonitor = new StoreMonitor(..);
        return;
    }

    public Store() {
        new Object();
        return;
    }

    public static void getPurchaseHistory(Integer p0, String p1, Integer p2, WebViewCallback p3) {
        Store.storeMonitor.isInitialized();
        if (if-nez(StoreMonitor.isInitialized(..))) goto L_11;
        p3.error(StoreError.NOT_INITIALIZED, p1);
        return;
      L_11:
        StoreError.NOT_INITIALIZED.intValue();
        p2.intValue();
        StoreError.NOT_INITIALIZED.intValue();
        Store.storeEventListenerFactory.invoke(Integer.intValue(..));
        Store.storeMonitor.getPurchaseHistory(Integer.intValue(..), p1, Integer.intValue(..), StoreEventListenerFactory.invoke(..));
        p3.invoke(StoreEventListenerFactory.invoke(..));
        return;
    }

    public static void getPurchases(Integer p0, String p1, WebViewCallback p2) {
        Store.storeMonitor.isInitialized();
        if (if-nez(StoreMonitor.isInitialized(..))) goto L_11;
        p2.error(StoreError.NOT_INITIALIZED, p1);
        return;
      L_11:
        StoreError.NOT_INITIALIZED.intValue();
        StoreError.NOT_INITIALIZED.intValue();
        Store.storeEventListenerFactory.invoke(Integer.intValue(..));
        Store.storeMonitor.getPurchases(Integer.intValue(..), p1, StoreEventListenerFactory.invoke(..));
        p2.invoke(StoreEventListenerFactory.invoke(..));
        return;
    }

    public static void getSkuDetails(Integer p0, String p1, JSONArray p2, WebViewCallback p3) {
        Store.storeMonitor.isInitialized();
        if (if-nez(StoreMonitor.isInitialized(..))) goto L_11;
        p3.error(StoreError.NOT_INITIALIZED, p1);
        return;
      L_11:
        new ArrayList();
      L_17:
        p2.length();
        if (if-ge(0, JSONArray.length(..))) goto L_27;
        p2.getString(0);
        new ArrayList(..).add(JSONArray.getString(..));
      L_27:
        StoreError.NOT_INITIALIZED.intValue();
        StoreError.NOT_INITIALIZED.intValue();
        Store.storeEventListenerFactory.invoke(Integer.intValue(..));
        Store.storeMonitor.getSkuDetails(Integer.intValue(..), p1, new ArrayList(..), StoreEventListenerFactory.invoke(..));
        StoreError.NOT_INITIALIZED.intValue();
        WebViewStoreExceptionHandler.handleStoreException(StoreEvent.SKU_DETAILS_LIST_REQUEST_ERROR, Integer.intValue(..), p1);
      L_47:
        p3.invoke(Integer.intValue(..));
        return;
    }

    public static void initialize(WebViewCallback p0) {
        Store.storeEventListenerFactory.invoke();
        Store.storeMonitor.initialize(StoreEventListenerFactory.invoke(..));
        p0.invoke(Store.storeMonitor);
        Store.storeMonitor.getMessage();
        Store.storeMonitor.getClass();
        Object.getClass(..).getName();
        p0.error(StoreError.UNKNOWN_ERROR, 2);
      L_2c:
        return;
    }

    public static void isFeatureSupported(Integer p0, String p1, WebViewCallback p2) {
        Store.storeMonitor.isInitialized();
        if (if-nez(StoreMonitor.isInitialized(..))) goto L_11;
        p2.error(StoreError.NOT_INITIALIZED, p1);
        return;
      L_11:
        new Store$$ExternalSyntheticLambda0(StoreError.NOT_INITIALIZED, p1);
        new Thread(new Store$$ExternalSyntheticLambda0(..));
        new Thread(..).start();
        p2.invoke(StoreError.NOT_INITIALIZED);
        return;
    }

    static void lambda$isFeatureSupported$0(Integer p0, String p1) {
        p0.intValue();
        p0.intValue();
        Store.storeEventListenerFactory.invoke(Integer.intValue(..));
        Store.storeMonitor.isFeatureSupported(Integer.intValue(..), p1, StoreEventListenerFactory.invoke(..));
        return;
    }

    public static void startPurchaseTracking(JSONArray p0, WebViewCallback p1) {
        Store.storeMonitor.isInitialized();
        if (if-nez(StoreMonitor.isInitialized(..))) goto L_11;
        p1.error(StoreError.NOT_INITIALIZED, StoreMonitor.isInitialized(..));
        return;
      L_11:
        new ArrayList();
      L_17:
        StoreError.NOT_INITIALIZED.length();
        if (if-ge(0, JSONArray.length(..))) goto L_28;
        StoreError.NOT_INITIALIZED.getString(0);
        new ArrayList(..).add(JSONArray.getString(..));
      L_28:
        Store.storeEventListenerFactory.invoke(-1, 1);
        Store.storeMonitor.startPurchaseTracking(new ArrayList(..), StoreEventListenerFactory.invoke(..));
        p1.invoke(Store.storeMonitor);
        return;
        Store.storeMonitor.getMessage();
        p1.error(StoreError.JSON_ERROR, StoreEventListenerFactory.invoke(..));
        return;
    }

    public static void stopPurchaseTracking(WebViewCallback p0) {
        Store.storeMonitor.isInitialized();
        if (if-nez(StoreMonitor.isInitialized(..))) goto L_11;
        p0.error(StoreError.NOT_INITIALIZED, StoreMonitor.isInitialized(..));
        return;
      L_11:
        StoreError.NOT_INITIALIZED.stopPurchaseTracking();
        p0.invoke(StoreError.NOT_INITIALIZED);
        return;
    }

}

