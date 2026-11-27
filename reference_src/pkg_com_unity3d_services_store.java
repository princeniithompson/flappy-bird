// Package bundle: com.unity3d.services.store (6 classes)

// ============================================================
// CLASS: com.unity3d.services.store.JsonSerializable
// ============================================================
package com.unity3d.services.store;

public abstract class JsonSerializable {
    public abstract JSONObject toJson() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.StoreError
// ============================================================
package com.unity3d.services.store;

public final class StoreError extends Enum {
    private static final StoreError[] $VALUES;
    public static final StoreError CLASS_NOT_FOUND;
    public static final StoreError ILLEGAL_ACCESS;
    public static final StoreError INVOCATION_TARGET;
    public static final StoreError JSON_ERROR;
    public static final StoreError NOT_INITIALIZED;
    public static final StoreError NO_SUCH_METHOD;
    public static final StoreError STORE_ERROR;
    public static final StoreError UNKNOWN_ERROR;

    private static final StoreError[] $values() {
        return 8;
    }

    static <clinit>() {
        new StoreError("NOT_INITIALIZED", 0);
        NOT_INITIALIZED = new StoreError(..);
        new StoreError("CLASS_NOT_FOUND", 1);
        CLASS_NOT_FOUND = new StoreError(..);
        new StoreError("NO_SUCH_METHOD", 2);
        NO_SUCH_METHOD = new StoreError(..);
        new StoreError("INVOCATION_TARGET", 3);
        INVOCATION_TARGET = new StoreError(..);
        new StoreError("ILLEGAL_ACCESS", 4);
        ILLEGAL_ACCESS = new StoreError(..);
        new StoreError("JSON_ERROR", 5);
        JSON_ERROR = new StoreError(..);
        new StoreError("STORE_ERROR", 6);
        STORE_ERROR = new StoreError(..);
        new StoreError("UNKNOWN_ERROR", 7);
        UNKNOWN_ERROR = new StoreError(..);
        StoreError.$values();
        $VALUES = StoreError.$values(..);
        return;
    }

    private StoreError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static StoreError valueOf(String p0) {
        Enum.valueOf(StoreError.class, p0);
        return Enum.valueOf(..);
    }

    public static StoreError[] values() {
        StoreError.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.StoreEvent
// ============================================================
package com.unity3d.services.store;

public final class StoreEvent extends Enum {
    private static final StoreEvent[] $VALUES;
    public static final StoreEvent DISCONNECTED_RESULT;
    public static final StoreEvent INITIALIZATION_REQUEST_FAILED;
    public static final StoreEvent INITIALIZATION_REQUEST_RESULT;
    public static final StoreEvent IS_FEATURE_SUPPORTED_REQUEST_ERROR;
    public static final StoreEvent IS_FEATURE_SUPPORTED_REQUEST_RESULT;
    public static final StoreEvent PURCHASES_ON_RESUME_ERROR;
    public static final StoreEvent PURCHASES_ON_RESUME_RESULT;
    public static final StoreEvent PURCHASES_REQUEST_ERROR;
    public static final StoreEvent PURCHASES_REQUEST_RESULT;
    public static final StoreEvent PURCHASES_UPDATED_ERROR;
    public static final StoreEvent PURCHASES_UPDATED_RESULT;
    public static final StoreEvent PURCHASE_HISTORY_LIST_REQUEST_ERROR;
    public static final StoreEvent PURCHASE_HISTORY_LIST_REQUEST_RESULT;
    public static final StoreEvent SKU_DETAILS_LIST_REQUEST_ERROR;
    public static final StoreEvent SKU_DETAILS_LIST_REQUEST_RESULT;

    private static final StoreEvent[] $values() {
        return 15;
    }

    static <clinit>() {
        new StoreEvent("INITIALIZATION_REQUEST_RESULT", 0);
        INITIALIZATION_REQUEST_RESULT = new StoreEvent(..);
        new StoreEvent("INITIALIZATION_REQUEST_FAILED", 1);
        INITIALIZATION_REQUEST_FAILED = new StoreEvent(..);
        new StoreEvent("DISCONNECTED_RESULT", 2);
        DISCONNECTED_RESULT = new StoreEvent(..);
        new StoreEvent("PURCHASES_ON_RESUME_RESULT", 3);
        PURCHASES_ON_RESUME_RESULT = new StoreEvent(..);
        new StoreEvent("PURCHASES_ON_RESUME_ERROR", 4);
        PURCHASES_ON_RESUME_ERROR = new StoreEvent(..);
        new StoreEvent("PURCHASES_UPDATED_RESULT", 5);
        PURCHASES_UPDATED_RESULT = new StoreEvent(..);
        new StoreEvent("PURCHASES_UPDATED_ERROR", 6);
        PURCHASES_UPDATED_ERROR = new StoreEvent(..);
        new StoreEvent("PURCHASES_REQUEST_RESULT", 7);
        PURCHASES_REQUEST_RESULT = new StoreEvent(..);
        new StoreEvent("PURCHASES_REQUEST_ERROR", 8);
        PURCHASES_REQUEST_ERROR = new StoreEvent(..);
        new StoreEvent("PURCHASE_HISTORY_LIST_REQUEST_RESULT", 9);
        PURCHASE_HISTORY_LIST_REQUEST_RESULT = new StoreEvent(..);
        new StoreEvent("PURCHASE_HISTORY_LIST_REQUEST_ERROR", 10);
        PURCHASE_HISTORY_LIST_REQUEST_ERROR = new StoreEvent(..);
        new StoreEvent("SKU_DETAILS_LIST_REQUEST_RESULT", 11);
        SKU_DETAILS_LIST_REQUEST_RESULT = new StoreEvent(..);
        new StoreEvent("SKU_DETAILS_LIST_REQUEST_ERROR", 12);
        SKU_DETAILS_LIST_REQUEST_ERROR = new StoreEvent(..);
        new StoreEvent("IS_FEATURE_SUPPORTED_REQUEST_RESULT", 13);
        IS_FEATURE_SUPPORTED_REQUEST_RESULT = new StoreEvent(..);
        new StoreEvent("IS_FEATURE_SUPPORTED_REQUEST_ERROR", 14);
        IS_FEATURE_SUPPORTED_REQUEST_ERROR = new StoreEvent(..);
        StoreEvent.$values();
        $VALUES = StoreEvent.$values(..);
        return;
    }

    private StoreEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static StoreEvent valueOf(String p0) {
        Enum.valueOf(StoreEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static StoreEvent[] values() {
        StoreEvent.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.StoreMonitor
// ============================================================
package com.unity3d.services.store;

public final class StoreMonitor {
    private final MutableStateFlow _isInitialized;
    private StoreBilling storeBilling;
    private final StoreExceptionHandler storeExceptionHandler;
    private StoreLifecycleListener storeLifecycleListener;

    public StoreMonitor(StoreExceptionHandler p0) {
        new Object();
        storeExceptionHandler = p0;
        Boolean.valueOf(0);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        _isInitialized = StateFlowKt.MutableStateFlow(..);
        return;
    }

    public final void getPurchaseHistory(int p0, String p1, int p2, PurchaseHistoryResponseListener p3) {
        if (if-eqz(storeBilling)) goto L_15;
        storeBilling.getPurchaseHistory(p1, p2, p3);
        storeExceptionHandler.handleStoreException(StoreEvent.PURCHASE_HISTORY_LIST_REQUEST_ERROR, p0, p1);
      L_15:
        return;
    }

    public final void getPurchases(int p0, String p1, PurchasesResponseListener p2) {
        if (if-eqz(storeBilling)) goto L_f;
        if (if-eqz(storeBilling)) goto L_23;
        storeBilling.getPurchases(p1, p2);
      L_f:
        "Required value was null.".toString();
        new IllegalStateException(Object.toString(..));
        throw new IllegalStateException(..);
        storeExceptionHandler.handleStoreException(StoreEvent.PURCHASES_REQUEST_ERROR, p0, Object.toString(..));
      L_23:
        return;
    }

    public final void getSkuDetails(int p0, String p1, List p2, SkuDetailsResponseListener p3) {
        if (if-eqz(storeBilling)) goto L_15;
        storeBilling.getSkuDetails(p1, p2, p3);
        storeExceptionHandler.handleStoreException(StoreEvent.SKU_DETAILS_LIST_REQUEST_ERROR, p0, p1);
      L_15:
        return;
    }

    public final void initialize(BillingInitializationListener p0) {
        StoreMonitor.isInitialized();
        if (if-eqz(StoreMonitor.isInitialized(..))) goto L_f;
        p0.onIsAlreadyInitialized();
        return;
      L_f:
        ClientProperties.getApplicationContext();
        new StoreBilling(ClientProperties.getApplicationContext(..), p0);
        storeBilling = new StoreBilling(..);
        new StoreBilling(..).initialize(p0);
        Boolean.valueOf(1);
        _isInitialized.setValue(Boolean.valueOf(..));
        return;
    }

    public final int isFeatureSupported(int p0, String p1, FeatureSupportedListener p2) {
        if (if-eqz(storeBilling)) goto L_f;
        storeBilling.isFeatureSupported(p1);
      L_f:
        p2.onFeatureSupported(StoreBilling.isFeatureSupported(..));
        storeExceptionHandler.handleStoreException(StoreEvent.IS_FEATURE_SUPPORTED_REQUEST_ERROR, p0, StoreBilling.isFeatureSupported(..));
      L_1b:
        return StoreBilling.isFeatureSupported(..);
    }

    public final boolean isInitialized() {
        _isInitialized.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        return Boolean.booleanValue(..);
    }

    public final void startPurchaseTracking(ArrayList p0, StoreEventListener p1) {
        if (if-eqz(storeLifecycleListener)) goto L_11;
        StoreMonitor.stopPurchaseTracking();
      L_11:
        Intrinsics.checkNotNull(storeBilling);
        new StoreLifecycleListener(p0, storeBilling, p1);
        storeLifecycleListener = new StoreLifecycleListener(..);
        ClientProperties.getApplication();
        ClientProperties.getApplication(..).registerActivityLifecycleCallbacks(storeLifecycleListener);
        return;
    }

    public final void stopPurchaseTracking() {
        if (if-eqz(storeLifecycleListener)) goto L_12;
        ClientProperties.getApplication();
        ClientProperties.getApplication(..).unregisterActivityLifecycleCallbacks(storeLifecycleListener);
        storeLifecycleListener = 0;
      L_12:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.StoreWebViewEventSender
// ============================================================
package com.unity3d.services.store;

public final class StoreWebViewEventSender {
    private final IEventSender eventSender;

    public StoreWebViewEventSender(IEventSender p0) {
        new Object();
        eventSender = p0;
        return;
    }

    public final void send(StoreEvent p0, Object[] p1) {
        Arrays.copyOf(p1, v2);
        eventSender.sendEvent(WebViewEventCategory.STORE, p0, Arrays.copyOf(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.WebViewStoreEventListener
// ============================================================
package com.unity3d.services.store;

public final class WebViewStoreEventListener {
    private final boolean isLifecycleListener;
    private final int operationId;
    private final StoreWebViewEventSender storeWebViewEventSender;

    public WebViewStoreEventListener(int p0, StoreWebViewEventSender p1, boolean p2) {
        new Object();
        operationId = p0;
        storeWebViewEventSender = p1;
        isLifecycleListener = p2;
        return;
    }

    public WebViewStoreEventListener(int p0, StoreWebViewEventSender p1, boolean p2, int p3, DefaultConstructorMarker p4) {
        if (if-eqz(p3)) goto L_5;
      L_5:
        new WebViewStoreEventListener(p0, p1, 0);
        return;
    }

    public int getOperationId() {
        return operationId;
    }

    public void onBillingServiceDisconnected() {
        storeWebViewEventSender.send(StoreEvent.DISCONNECTED_RESULT, 0);
        return;
    }

    public void onBillingSetupFinished(BillingResultBridge p0) {
        p0.getResponseCode();
        if (if-ne(BillingResultBridge.getResponseCode(..), BillingResultResponseCode.OK)) goto L_24;
        p0.getResponseCode();
        storeWebViewEventSender.send(StoreEvent.INITIALIZATION_REQUEST_RESULT, 1);
      L_24:
        BillingResultBridge.getResponseCode();
        storeWebViewEventSender.send(StoreEvent.INITIALIZATION_REQUEST_FAILED, 1);
      L_36:
        return;
    }

    public void onFeatureSupported(int p0) {
        WebViewStoreEventListener.getOperationId();
        Integer.valueOf(WebViewStoreEventListener.getOperationId(..));
        Integer.valueOf(p0);
        storeWebViewEventSender.send(StoreEvent.IS_FEATURE_SUPPORTED_REQUEST_RESULT, 2);
        return;
    }

    public void onIsAlreadyInitialized() {
        BillingResultResponseCode.OK.getResponseCode();
        Integer.valueOf(BillingResultResponseCode.getResponseCode(..));
        storeWebViewEventSender.send(StoreEvent.INITIALIZATION_REQUEST_RESULT, 1);
        return;
    }

    public void onPurchaseHistoryUpdated(BillingResultBridge p0, List p1) {
        WebViewStoreEventListener.getOperationId();
        Integer.valueOf(WebViewStoreEventListener.getOperationId(..));
        p0.getResponseCode();
        if (if-eqz(p1)) goto L_2b;
        JsonSerializableExtensionsKt.toJsonArray(p1);
        if (if-nez(JsonSerializableExtensionsKt.toJsonArray(..))) goto L_30;
      L_2b:
        new JSONArray();
      L_30:
        storeWebViewEventSender.send(StoreEvent.PURCHASE_HISTORY_LIST_REQUEST_RESULT, 3);
        return;
    }

    public void onPurchaseResponse(BillingResultBridge p0, List p1) {
        new ArrayList();
        WebViewStoreEventListener.getOperationId();
        if (if-eq(WebViewStoreEventListener.getOperationId(..), -1)) goto L_1c;
        WebViewStoreEventListener.getOperationId();
        Integer.valueOf(WebViewStoreEventListener.getOperationId(..));
        new ArrayList(..).add(Integer.valueOf(..));
      L_1c:
        p0.getResponseCode();
        if (if-ne(BillingResultBridge.getResponseCode(..), BillingResultResponseCode.OK)) goto L_51;
        if (if-eqz(p1)) goto L_2d;
        JsonSerializableExtensionsKt.toJsonArray(p1);
        if (if-nez(JsonSerializableExtensionsKt.toJsonArray(..))) goto L_32;
      L_2d:
        new JSONArray();
      L_32:
        new ArrayList(..).add(new JSONArray(..));
        if (if-eqz(isLifecycleListener)) goto L_3e;
      L_3e:
      L_40:
        new ArrayList(..).toArray(BillingResultBridge.getResponseCode(..));
        Arrays.copyOf(Collection.toArray(..), BillingResultBridge.getResponseCode(..));
        storeWebViewEventSender.send(StoreEvent.PURCHASES_REQUEST_RESULT, Arrays.copyOf(..));
      L_51:
        storeWebViewEventSender.getResponseCode();
        Arrays.copyOf(..).add(BillingResultBridge.getResponseCode(..));
        if (if-eqz(isLifecycleListener)) goto L_61;
      L_61:
      L_63:
        Arrays.copyOf(..).toArray(BillingResultBridge.getResponseCode(..));
        Arrays.copyOf(Collection.toArray(..), BillingResultBridge.getResponseCode(..));
        storeWebViewEventSender.send(StoreEvent.PURCHASES_REQUEST_ERROR, Arrays.copyOf(..));
      L_73:
        return;
    }

    public void onPurchaseUpdated(BillingResultBridge p0, List p1) {
        p0.getResponseCode();
        if (if-ne(BillingResultBridge.getResponseCode(..), BillingResultResponseCode.OK)) goto L_28;
        if (if-eqz(p1)) goto L_1d;
        JsonSerializableExtensionsKt.toJsonArray(p1);
        if (if-nez(JsonSerializableExtensionsKt.toJsonArray(..))) goto L_22;
      L_1d:
        new JSONArray();
      L_22:
        storeWebViewEventSender.send(StoreEvent.PURCHASES_UPDATED_RESULT, BillingResultResponseCode.OK);
      L_28:
        storeWebViewEventSender.getResponseCode();
        storeWebViewEventSender.send(StoreEvent.PURCHASES_UPDATED_ERROR, BillingResultResponseCode.OK);
      L_3c:
        return;
    }

    public void onSkuDetailsUpdated(BillingResultBridge p0, List p1) {
        WebViewStoreEventListener.getOperationId();
        Integer.valueOf(WebViewStoreEventListener.getOperationId(..));
        if (if-eqz(p1)) goto L_1f;
        JsonSerializableExtensionsKt.toJsonArray(p1);
        if (if-nez(JsonSerializableExtensionsKt.toJsonArray(..))) goto L_24;
      L_1f:
        new JSONArray();
      L_24:
        storeWebViewEventSender.send(StoreEvent.SKU_DETAILS_LIST_REQUEST_RESULT, 2);
        return;
    }

}

