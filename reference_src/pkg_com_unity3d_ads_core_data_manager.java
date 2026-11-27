// Package bundle: com.unity3d.ads.core.data.manager (14 classes)

// ============================================================
// CLASS: com.unity3d.ads.core.data.manager.AndroidOmidManager
// ============================================================
package com.unity3d.ads.core.data.manager;

public final class AndroidOmidManager {
    public AndroidOmidManager() {
        new Object();
        return;
    }

    public void activate(Context p0) {
        Omid.activate(p0);
        return;
    }

    public AdEvents createAdEvents(AdSession p0) {
        AdEvents.createAdEvents(p0);
        return AdEvents.createAdEvents(..);
    }

    public AdSession createAdSession(AdSessionConfiguration p0, AdSessionContext p1) {
        AdSession.createAdSession(p0, p1);
        return AdSession.createAdSession(..);
    }

    public AdSessionConfiguration createAdSessionConfiguration(CreativeType p0, ImpressionType p1, Owner p2, Owner p3, boolean p4) {
        AdSessionConfiguration.createAdSessionConfiguration(p0, p1, p2, p3, p4);
        return AdSessionConfiguration.createAdSessionConfiguration(..);
    }

    public AdSessionContext createHtmlAdSessionContext(Partner p0, WebView p1, String p2, String p3) {
        AdSessionContext.createHtmlAdSessionContext(p0, p1, p2, p3);
        return AdSessionContext.createHtmlAdSessionContext(..);
    }

    public AdSessionContext createJavaScriptAdSessionContext(Partner p0, WebView p1, String p2, String p3) {
        AdSessionContext.createJavascriptAdSessionContext(p0, p1, p2, p3);
        return AdSessionContext.createJavascriptAdSessionContext(..);
    }

    public String getVersion() {
        Omid.getVersion();
        return Omid.getVersion(..);
    }

    public boolean isActive() {
        Omid.isActive();
        return Omid.isActive(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.manager.AndroidSDKPropertiesManager
// ============================================================
package com.unity3d.ads.core.data.manager;

public final class AndroidSDKPropertiesManager {
    public AndroidSDKPropertiesManager() {
        new Object();
        return;
    }

    public void setInitialized(boolean p0) {
        SdkProperties.setInitialized(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.manager.AndroidSDKPropertiesManagerKt
// ============================================================
package com.unity3d.ads.core.data.manager;

public final class AndroidSDKPropertiesManagerKt {
}


// ============================================================
// CLASS: com.unity3d.ads.core.data.manager.AndroidStorageManager
// ============================================================
package com.unity3d.ads.core.data.manager;

public final class AndroidStorageManager {
    public static final AndroidStorageManager$Companion Companion = null;
    private static final String KEY_INITIALIZED = "configuration.hasInitialized";

    static <clinit>() {
        new AndroidStorageManager$Companion(0);
        Companion = new AndroidStorageManager$Companion(..);
        return;
    }

    public AndroidStorageManager() {
        new Object();
        return;
    }

    public void addStorageLocation(StorageManager$StorageType p0, String p1) {
        StorageManager.addStorageLocation(p0, p1);
        return;
    }

    public Storage getStorage(StorageManager$StorageType p0) {
        StorageManager.getStorage(p0);
        return StorageManager.getStorage(..);
    }

    public void hasInitialized() {
        AndroidStorageManager.getStorage(StorageManager$StorageType.PRIVATE);
        Boolean.valueOf(1);
        AndroidStorageManager.getStorage(..).set("configuration.hasInitialized", Boolean.valueOf(..));
        AndroidStorageManager.getStorage(..).writeStorage();
        return;
    }

    public boolean hasStorage(StorageManager$StorageType p0) {
        StorageManager.hasStorage(p0);
        return StorageManager.hasStorage(..);
    }

    public boolean init(Context p0) {
        StorageManager.init(p0);
        return StorageManager.init(..);
    }

    public void initStorage(StorageManager$StorageType p0) {
        StorageManager.initStorage(p0);
        return;
    }

    public void removeStorage(StorageManager$StorageType p0) {
        StorageManager.removeStorage(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.manager.AndroidStorageManagerKt
// ============================================================
package com.unity3d.ads.core.data.manager;

public final class AndroidStorageManagerKt {
}


// ============================================================
// CLASS: com.unity3d.ads.core.data.manager.OmidManager
// ============================================================
package com.unity3d.ads.core.data.manager;

public abstract class OmidManager {
    public abstract void activate(Context p0) {
        // native or abstract
    }

    public abstract AdEvents createAdEvents(AdSession p0) {
        // native or abstract
    }

    public abstract AdSession createAdSession(AdSessionConfiguration p0, AdSessionContext p1) {
        // native or abstract
    }

    public abstract AdSessionConfiguration createAdSessionConfiguration(CreativeType p0, ImpressionType p1, Owner p2, Owner p3, boolean p4) {
        // native or abstract
    }

    public abstract AdSessionContext createHtmlAdSessionContext(Partner p0, WebView p1, String p2, String p3) {
        // native or abstract
    }

    public abstract AdSessionContext createJavaScriptAdSessionContext(Partner p0, WebView p1, String p2, String p3) {
        // native or abstract
    }

    public abstract String getVersion() {
        // native or abstract
    }

    public abstract boolean isActive() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.manager.SDKPropertiesManager
// ============================================================
package com.unity3d.ads.core.data.manager;

public abstract class SDKPropertiesManager {
    public abstract void setInitialized(boolean p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.manager.StorageManager
// ============================================================
package com.unity3d.ads.core.data.manager;

public abstract class StorageManager {
    public abstract void addStorageLocation(StorageManager$StorageType p0, String p1) {
        // native or abstract
    }

    public abstract Storage getStorage(StorageManager$StorageType p0) {
        // native or abstract
    }

    public abstract void hasInitialized() {
        // native or abstract
    }

    public abstract boolean hasStorage(StorageManager$StorageType p0) {
        // native or abstract
    }

    public abstract boolean init(Context p0) {
        // native or abstract
    }

    public abstract void initStorage(StorageManager$StorageType p0) {
        // native or abstract
    }

    public abstract void removeStorage(StorageManager$StorageType p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.manager.TransactionEventManager
// ============================================================
package com.unity3d.ads.core.data.manager;

public final class TransactionEventManager {
    public static final TransactionEventManager$Companion Companion = null;
    private static final String INAPP = "inapp";
    private static final int dummyOperationId = 42;
    private final GetTransactionData getTransactionData;
    private final GetTransactionRequest getTransactionRequest;
    private final ByteStringDataSource iapTransactionStore;
    private final CoroutineScope scope;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final StoreMonitor storeMonitor;
    private final TransactionEventRepository transactionEventRepository;

    static <clinit>() {
        new TransactionEventManager$Companion(0);
        Companion = new TransactionEventManager$Companion(..);
        return;
    }

    public TransactionEventManager(CoroutineScope p0, StoreMonitor p1, GetTransactionData p2, GetTransactionRequest p3, TransactionEventRepository p4, ByteStringDataSource p5, SendDiagnosticEvent p6) {
        new Object();
        scope = p0;
        storeMonitor = p1;
        getTransactionData = p2;
        getTransactionRequest = p3;
        transactionEventRepository = p4;
        iapTransactionStore = p5;
        sendDiagnosticEvent = p6;
        return;
    }

    public static final GetTransactionData access$getGetTransactionData$p(TransactionEventManager p0) {
        return getTransactionData;
    }

    public static final GetTransactionRequest access$getGetTransactionRequest$p(TransactionEventManager p0) {
        return getTransactionRequest;
    }

    public static final ByteStringDataSource access$getIapTransactionStore$p(TransactionEventManager p0) {
        return iapTransactionStore;
    }

    public static final SendDiagnosticEvent access$getSendDiagnosticEvent$p(TransactionEventManager p0) {
        return sendDiagnosticEvent;
    }

    public static final StoreMonitor access$getStoreMonitor$p(TransactionEventManager p0) {
        return storeMonitor;
    }

    public static final TransactionEventRepository access$getTransactionEventRepository$p(TransactionEventManager p0) {
        return transactionEventRepository;
    }

    public static final void access$onPurchasesReceived(TransactionEventManager p0, BillingResultBridge p1, List p2) {
        p0.onPurchasesReceived(p1, p2);
        return;
    }

    private final void onPurchasesReceived(BillingResultBridge p0, List p1) {
        p0.getResponseCode();
        if (if-ne(BillingResultBridge.getResponseCode(..), BillingResultResponseCode.OK)) goto L_2c;
        if (if-eqz(p1)) goto L_16;
        p1.isEmpty();
        if (if-eqz(Collection.isEmpty(..))) goto L_14;
      L_14:
      L_16:
      L_17:
        if (if-eqz(1)) goto L_1a;
      L_1a:
        new TransactionEventManager$onPurchasesReceived$1(p1, this, 0);
        BuildersKt.launch$default(scope, 0, 0, new TransactionEventManager$onPurchasesReceived$1(..), 3, 0);
      L_2c:
        return;
    }

    public final void invoke() {
        new TransactionEventManager$invoke$1(this, 0);
        BuildersKt.launch$default(scope, 0, 0, new TransactionEventManager$invoke$1(..), 3, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.manager.AndroidStorageManager$Companion
// ============================================================
package com.unity3d.ads.core.data.manager;

public final class AndroidStorageManager$Companion {
    private AndroidStorageManager$Companion() {
        new Object();
        return;
    }

    public AndroidStorageManager$Companion(DefaultConstructorMarker p0) {
        new AndroidStorageManager$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.manager.TransactionEventManager$Companion
// ============================================================
package com.unity3d.ads.core.data.manager;

public final class TransactionEventManager$Companion {
    private TransactionEventManager$Companion() {
        new Object();
        return;
    }

    public TransactionEventManager$Companion(DefaultConstructorMarker p0) {
        new TransactionEventManager$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.manager.TransactionEventManager$invoke$1
// ============================================================
package com.unity3d.ads.core.data.manager;

final class TransactionEventManager$invoke$1 extends SuspendLambda {
    Object L$0;
    int label;
    final TransactionEventManager this$0;

    public static void $r8$lambda$BNbMlSYHnYWaIBvVXabB5HcRgkM(TransactionEventManager p0, BillingResultBridge p1, List p2) {
        TransactionEventManager$invoke$1.invokeSuspend$lambda$1(p0, p1, p2);
        return;
    }

    TransactionEventManager$invoke$1(TransactionEventManager p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    private static final void invokeSuspend$lambda$1(TransactionEventManager p0, BillingResultBridge p1, List p2) {
        TransactionEventManager.access$onPurchasesReceived(p0, p1, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new TransactionEventManager$invoke$1(this$0, p1);
        return new TransactionEventManager$invoke$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        TransactionEventManager$invoke$1.invoke(p0, p1);
        return TransactionEventManager$invoke$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        TransactionEventManager$invoke$1.create(p0, p1);
        TransactionEventManager$invoke$1.invokeSuspend(Unit.INSTANCE);
        return TransactionEventManager$invoke$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_1b;
        if (if-ne(label, 1)) goto L_13;
        ResultKt.throwOnFailure(p0);
      L_13:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1b:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        TransactionEventManager.access$getStoreMonitor$p(this$0);
        StoreMonitor.isInitialized();
        if (if-nez(StoreMonitor.isInitialized(..))) goto L_8a;
        L$0 = this$0;
        label = 1;
        IntrinsicsKt.intercepted(this);
        new CancellableContinuationImpl(IntrinsicsKt.intercepted(..), 1);
        new CancellableContinuationImpl(..).initCancellability();
        TransactionEventManager.access$getStoreMonitor$p(this$0);
        new TransactionEventManager$invoke$1$1$1(new CancellableContinuationImpl(..), this$0);
        StoreMonitor.initialize(new TransactionEventManager$invoke$1$1$1(..));
        new CancellableContinuationImpl(..).getResult();
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(CancellableContinuationImpl.getResult(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_60;
        DebugProbesKt.probeCoroutineSuspended(this);
      L_60:
        if (if-ne(CancellableContinuationImpl.getResult(..), "call to 'resume' before 'invoke' with coroutine")) goto L_63;
        return "call to 'resume' before 'invoke' with coroutine";
      L_63:
        TransactionEventManager.access$getStoreMonitor$p(this$0);
        new TransactionEventManager$invoke$1$$ExternalSyntheticLambda0(this$0);
        StoreMonitor.getPurchases(42, "inapp", new TransactionEventManager$invoke$1$$ExternalSyntheticLambda0(..));
        TransactionEventManager.access$getSendDiagnosticEvent$p(this$0);
        SendDiagnosticEvent$DefaultImpls.invoke$default(TransactionEventManager.access$getSendDiagnosticEvent$p(..), "billing_service_unavailable", 0, 0, 0, 0, 30, 0);
      L_8a:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.manager.TransactionEventManager$invoke$1$1$1
// ============================================================
package com.unity3d.ads.core.data.manager;

public final class TransactionEventManager$invoke$1$1$1 {
    final CancellableContinuation $it;
    final TransactionEventManager this$0;

    TransactionEventManager$invoke$1$1$1(CancellableContinuation p0, TransactionEventManager p1) {
        $it = p0;
        this$0 = p1;
        new Object();
        return;
    }

    private final void tryResume() {
        $it.isActive();
        if (if-eqz(CancellableContinuation.isActive(..))) goto L_17;
        Result.constructor-impl(Unit.INSTANCE);
        $it.resumeWith(Result.constructor-impl(..));
      L_17:
        return;
    }

    private final void tryResumeWithException(Exception p0) {
        $it.isActive();
        if (if-eqz(CancellableContinuation.isActive(..))) goto L_1b;
        ResultKt.createFailure(p0);
        Result.constructor-impl(ResultKt.createFailure(..));
        $it.resumeWith(Result.constructor-impl(..));
      L_1b:
        return;
    }

    public void onBillingServiceDisconnected() {
        new TransactionException("Billing service disconnected");
        TransactionEventManager$invoke$1$1$1.tryResumeWithException(new TransactionException(..));
        return;
    }

    public void onBillingSetupFinished(BillingResultBridge p0) {
        p0.getResponseCode();
        if (if-eq(BillingResultBridge.getResponseCode(..), BillingResultResponseCode.OK)) goto L_1a;
        new TransactionException("Billing setup failed");
        TransactionEventManager$invoke$1$1$1.tryResumeWithException(new TransactionException(..));
        return;
      L_1a:
        TransactionEventManager$invoke$1$1$1.tryResume();
        return;
    }

    public void onIsAlreadyInitialized() {
        TransactionEventManager$invoke$1$1$1.tryResume();
        return;
    }

    public void onPurchaseUpdated(BillingResultBridge p0, List p1) {
        TransactionEventManager.access$onPurchasesReceived(this$0, p0, p1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.manager.TransactionEventManager$onPurchasesReceived$1
// ============================================================
package com.unity3d.ads.core.data.manager;

final class TransactionEventManager$onPurchasesReceived$1 extends SuspendLambda {
    final List $purchases;
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final TransactionEventManager this$0;

    public static void $r8$lambda$EcK5Jn68DtuMlRcmDB-MyXPG9yU(List p0, int p1, List p2, TransactionEventManager p3, PurchaseBridge p4, BillingResultBridge p5, List p6) {
        TransactionEventManager$onPurchasesReceived$1.invokeSuspend$lambda$3$lambda$2(p0, p1, p2, p3, p4, p5, p6);
        return;
    }

    TransactionEventManager$onPurchasesReceived$1(List p0, TransactionEventManager p1, Continuation p2) {
        $purchases = p0;
        this$0 = p1;
        new SuspendLambda(2, p2);
        return;
    }

    private static final void invokeSuspend$lambda$3$lambda$2(List p0, int p1, List p2, TransactionEventManager p3, PurchaseBridge p4, BillingResultBridge p5, List p6) {
        if (if-eqz(p6)) goto L_49;
        p5.getResponseCode();
        if (if-eq(BillingResultBridge.getResponseCode(..), BillingResultResponseCode.OK)) goto L_b;
      L_b:
        CollectionsKt.collectionSizeOrDefault(p6, 10);
        new ArrayList(CollectionsKt.collectionSizeOrDefault(..));
        p6.iterator();
      L_1e:
        Iterable.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_36;
        Iterable.iterator(..).next();
        TransactionEventManager.access$getGetTransactionData$p(p3);
        GetTransactionData.invoke(p4, Iterator.next(..));
        new ArrayList(..).add(GetTransactionData.invoke(..));
      L_36:
        p2.addAll(new ArrayList(..));
        p0.get(p1);
        List.get(..).complete(Unit.INSTANCE);
        return;
      L_49:
        List.get(..).get(Unit.INSTANCE);
        List.get(..).complete(Unit.INSTANCE);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new TransactionEventManager$onPurchasesReceived$1($purchases, this$0, p1);
        return new TransactionEventManager$onPurchasesReceived$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        TransactionEventManager$onPurchasesReceived$1.invoke(p0, p1);
        return TransactionEventManager$onPurchasesReceived$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        TransactionEventManager$onPurchasesReceived$1.create(p0, p1);
        TransactionEventManager$onPurchasesReceived$1.invokeSuspend(Unit.INSTANCE);
        return TransactionEventManager$onPurchasesReceived$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_5b;
        if (if-eq(label, 1)) goto L_2e;
        if (if-eq(label, 2)) goto L_24;
        if (if-ne(label, 3)) goto L_1c;
        ResultKt.throwOnFailure(p0);
      L_1c:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_24:
        ResultKt.throwOnFailure(p0);
      L_2e:
        ResultKt.throwOnFailure(p0);
      L_5b:
        ResultKt.throwOnFailure(p0);
        new ArrayList();
        CollectionsKt.collectionSizeOrDefault($purchases, 10);
        new ArrayList(CollectionsKt.collectionSizeOrDefault(..));
        $purchases.iterator();
      L_7a:
        Iterable.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_8e;
        Iterable.iterator(..).next();
        CompletableDeferredKt.CompletableDeferred$default(0, 1, 0);
        new ArrayList(..).add(CompletableDeferredKt.CompletableDeferred$default(..));
      L_8e:
        $purchases.iterator();
      L_9f:
        Iterable.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_14f;
        Iterable.iterator(..).next();
        if (if-gez(0)) goto L_b0;
        CollectionsKt.throwIndexOverflow();
      L_b0:
        Iterator.next(..).getOriginalJson();
        PurchaseBridge.getOriginalJson(..).get("purchaseTime");
        Intrinsics.checkNotNull(JSONObject.get(..), "null cannot be cast to non-null type kotlin.Long");
        JSONObject.get(..).longValue();
        TransactionEventManager.access$getIapTransactionStore$p(this$0);
        L$0 = new ArrayList(..);
        L$1 = new ArrayList(..);
        L$2 = this$0;
        L$3 = Iterable.iterator(..);
        L$4 = Iterator.next(..);
        I$0 = L$4;
        I$1 = 0;
        J$0 = Long.longValue(..);
        label = 1;
        ByteStringDataSource.get(this);
        if (if-ne(ByteStringDataSource.get(..), new IllegalStateException(..))) goto L_e4;
        return new IllegalStateException(..);
      L_e4:
      L_f3:
        ByteStringDataSource.get(..).getData();
        Timestamp.parseFrom(ByteStringStoreOuterClass$ByteStringStore.getData(..));
        Timestamp.parseFrom(..).getSeconds();
        if (if-gez(Timestamp.getSeconds(..))) goto L_137;
        TransactionEventManager.access$getStoreMonitor$p(this$0);
        Iterator.next(..).getOriginalJson();
        PurchaseBridge.getOriginalJson(..).get("productId");
        Intrinsics.checkNotNull(JSONObject.get(..), "null cannot be cast to non-null type kotlin.String");
        CollectionsKt.listOf(JSONObject.get(..));
        new TransactionEventManager$onPurchasesReceived$1$$ExternalSyntheticLambda0(new ArrayList(..), 0, new ArrayList(..), this$0, Iterator.next(..));
        StoreMonitor.getSkuDetails(42, "inapp", CollectionsKt.listOf(..), new TransactionEventManager$onPurchasesReceived$1$$ExternalSyntheticLambda0);
      L_137:
        this$0.get(0);
        List.get(..).complete(Unit.INSTANCE);
      L_143:
      L_14f:
        this$0.toArray(0);
        Arrays.copyOf(Collection.toArray(..), 3);
        L$0 = new ArrayList(..);
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        L$4 = 0;
        label = 2;
        AwaitKt.awaitAll(Arrays.copyOf(..), this);
        if (if-ne(AwaitKt.awaitAll(..), new IllegalStateException(..))) goto L_179;
        return new IllegalStateException(..);
      L_179:
        new ArrayList(..).isEmpty();
        if (if-eqz(Collection.isEmpty(..))) goto L_1a5;
        TransactionEventManager.access$getGetTransactionRequest$p(this$0);
        L$0 = 0;
        label = 3;
        GetTransactionRequest.invoke(new ArrayList(..), this);
        if (if-ne(GetTransactionRequest.invoke(..), new IllegalStateException(..))) goto L_19a;
        return new IllegalStateException(..);
      L_19a:
        TransactionEventManager.access$getTransactionEventRepository$p(this$0);
        TransactionEventRepository.addTransactionEvent(GetTransactionRequest.invoke(..));
      L_1a5:
        return Unit.INSTANCE;
    }

}

