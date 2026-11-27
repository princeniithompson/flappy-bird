// Package bundle: com.unity3d.services.store.core (6 classes)

// ============================================================
// CLASS: com.unity3d.services.store.core.GatewayStoreExceptionHandler
// ============================================================
package com.unity3d.services.store.core;

public final class GatewayStoreExceptionHandler {
    public GatewayStoreExceptionHandler() {
        new Object();
        return;
    }

    public void handleStoreException(StoreEvent p0, int p1, Exception p2) {
        throw p2;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.core.StoreEventListenerFactory
// ============================================================
package com.unity3d.services.store.core;

public final class StoreEventListenerFactory {
    private final StoreWebViewEventSender storeWebViewEventSender;

    public StoreEventListenerFactory(StoreWebViewEventSender p0) {
        new Object();
        storeWebViewEventSender = p0;
        return;
    }

    public static StoreEventListener invoke$default(StoreEventListenerFactory p0, int p1, boolean p2, int p3, Object p4) {
        if (if-eqz(p4)) goto L_5;
      L_5:
        if (if-eqz(p3)) goto L_a;
      L_a:
        p0.invoke(-1, 0);
        return StoreEventListenerFactory.invoke(..);
    }

    public final StoreEventListener invoke() {
        StoreEventListenerFactory.invoke$default(this, 0, 0, 3, 0);
        return StoreEventListenerFactory.invoke$default(..);
    }

    public final StoreEventListener invoke(int p0) {
        StoreEventListenerFactory.invoke$default(this, p0, 0, 2, 0);
        return StoreEventListenerFactory.invoke$default(..);
    }

    public final StoreEventListener invoke(int p0, boolean p1) {
        new WebViewStoreEventListener(p0, storeWebViewEventSender, p1);
        return new WebViewStoreEventListener(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.core.StoreExceptionHandler
// ============================================================
package com.unity3d.services.store.core;

public abstract class StoreExceptionHandler {
    public abstract void handleStoreException(StoreEvent p0, int p1, Exception p2) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.core.StoreLifecycleListener
// ============================================================
package com.unity3d.services.store.core;

public final class StoreLifecycleListener {
    private final ArrayList _purchaseTypes;
    private final StoreBilling _storeBilling;
    private final StoreEventListener _storeEventListener;

    public StoreLifecycleListener(ArrayList p0, StoreBilling p1, StoreEventListener p2) {
        new Object();
        _purchaseTypes = p0;
        _storeBilling = p1;
        _storeEventListener = p2;
        return;
    }

    public void onActivityCreated(Activity p0, Bundle p1) {
        return;
    }

    public void onActivityDestroyed(Activity p0) {
        return;
    }

    public void onActivityPaused(Activity p0) {
        return;
    }

    public void onActivityResumed(Activity p0) {
        _purchaseTypes.iterator();
      L_b:
        ArrayList.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_37;
        ArrayList.iterator(..).next();
        _storeBilling.getPurchases(Iterator.next(..), _storeEventListener);
        new StringBuilder("Couldn't fetch purchases onActivityResumed. ");
        ArrayList.iterator(..).getMessage();
        new StringBuilder(..).append(ClassNotFoundException.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.warning(StringBuilder.toString(..));
      L_37:
        return;
    }

    public void onActivitySaveInstanceState(Activity p0, Bundle p1) {
        return;
    }

    public void onActivityStarted(Activity p0) {
        return;
    }

    public void onActivityStopped(Activity p0) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.core.StoreWebViewError
// ============================================================
package com.unity3d.services.store.core;

public final class StoreWebViewError extends WebViewAdsError {
    public StoreWebViewError(Enum p0, String p1, Object[] p2) {
        Arrays.copyOf(p2, "errorArguments");
        new WebViewAdsError(p0, p1, Arrays.copyOf(..));
        return;
    }

    public String getDomain() {
        WebViewEventCategory.STORE.name();
        return WebViewEventCategory.name(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.core.WebViewStoreExceptionHandler
// ============================================================
package com.unity3d.services.store.core;

public final class WebViewStoreExceptionHandler {
    private final WebViewErrorHandler _webViewErrorHandler;

    public WebViewStoreExceptionHandler(WebViewErrorHandler p0) {
        new Object();
        _webViewErrorHandler = p0;
        return;
    }

    private final StoreError getStoreError(Exception p0) {
        if (if-eqz(v0)) goto L_7;
      L_7:
        if (if-eqz(v0)) goto L_e;
      L_e:
        if (if-eqz(v0)) goto L_15;
      L_15:
        if (if-eqz(v0)) goto L_1c;
      L_1c:
        if (if-eqz(StoreError.INVOCATION_TARGET)) goto L_23;
      L_23:
      L_25:
        return StoreError.UNKNOWN_ERROR;
    }

    private final void sendErrorToWebView(StoreEvent p0, StoreError p1, int p2, Exception p3) {
        p3.getMessage();
        Integer.valueOf(p2);
        p3.getMessage();
        new StoreWebViewError(p0, Exception.getMessage(..), 3);
        _webViewErrorHandler.handleError(new StoreWebViewError(..));
        return;
    }

    public void handleStoreException(StoreEvent p0, int p1, Exception p2) {
        WebViewStoreExceptionHandler.getStoreError(p2);
        WebViewStoreExceptionHandler.sendErrorToWebView(p0, WebViewStoreExceptionHandler.getStoreError(..), p1, p2);
        return;
    }

}

