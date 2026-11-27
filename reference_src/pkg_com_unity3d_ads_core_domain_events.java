// Package bundle: com.unity3d.ads.core.domain.events (26 classes)

// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.AndroidGetTransactionData
// ============================================================
package com.unity3d.ads.core.domain.events;

public final class AndroidGetTransactionData {
    private final GetByteStringId getByteStringId;

    public AndroidGetTransactionData(GetByteStringId p0) {
        new Object();
        getByteStringId = p0;
        return;
    }

    public TransactionEventRequestOuterClass$TransactionData invoke(PurchaseBridge p0, SkuDetailsBridge p1) {
        TransactionEventRequestOuterClass$TransactionData.newBuilder();
        TransactionDataKt$Dsl.Companion._create(TransactionEventRequestOuterClass$TransactionData.newBuilder(..));
        p0.getOriginalJson();
        PurchaseBridge.getOriginalJson(..).get("productId");
        JSONObject.get(..).toString();
        TransactionDataKt$Dsl.setProductId(Object.toString(..));
        getByteStringId.invoke();
        TransactionDataKt$Dsl.setEventId(GetByteStringId.invoke(..));
        p0.getOriginalJson();
        PurchaseBridge.getOriginalJson(..).get("purchaseTime");
        Intrinsics.checkNotNull(JSONObject.get(..), "null cannot be cast to non-null type kotlin.Long");
        JSONObject.get(..).longValue();
        TimestampExtensionsKt.fromMillis(Long.longValue(..), "null cannot be cast to non-null type kotlin.Long");
        TransactionDataKt$Dsl.setTimestamp(TimestampExtensionsKt.fromMillis(..));
        p0.getOriginalJson();
        PurchaseBridge.getOriginalJson(..).get("orderId");
        JSONObject.get(..).toString();
        TransactionDataKt$Dsl.setTransactionId(Object.toString(..));
        p1.getOriginalJson();
        SkuDetailsBridge.getOriginalJson(..).toString();
        TransactionDataKt$Dsl.setProduct(JSONObject.toString(..));
        p0.getOriginalJson();
        PurchaseBridge.getOriginalJson(..).toString();
        TransactionDataKt$Dsl.setTransaction(JSONObject.toString(..));
        p0.getOriginalJson();
        PurchaseBridge.getOriginalJson(..).get("purchaseState");
        Intrinsics.checkNotNull(JSONObject.get(..), "null cannot be cast to non-null type kotlin.Int");
        JSONObject.get(..).intValue();
        TransactionStateExtensionsKt.fromPurchaseState(Integer.intValue(..));
        TransactionDataKt$Dsl.setTransactionState(TransactionStateExtensionsKt.fromPurchaseState(..));
        TransactionDataKt$Dsl._build();
        return TransactionDataKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.AndroidHandleGatewayEventResponse
// ============================================================
package com.unity3d.ads.core.domain.events;

public final class AndroidHandleGatewayEventResponse {
    public AndroidHandleGatewayEventResponse() {
        new Object();
        return;
    }

    public Object invoke(UniversalResponseOuterClass$UniversalResponse p0, Continuation p1) {
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.CommonGetTransactionRequest
// ============================================================
package com.unity3d.ads.core.domain.events;

public final class CommonGetTransactionRequest {
    private final DeviceInfoRepository deviceInfoRepository;

    public CommonGetTransactionRequest(DeviceInfoRepository p0) {
        new Object();
        deviceInfoRepository = p0;
        return;
    }

    public Object invoke(List p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new CommonGetTransactionRequest$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_46;
        if (if-ne(label, 1)) goto L_3e;
        ResultKt.throwOnFailure(result);
      L_3e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_46:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        TransactionEventRequestOuterClass$TransactionEventRequest.newBuilder();
        TransactionEventRequestKt$Dsl$Companion._create(TransactionEventRequestOuterClass$TransactionEventRequest.newBuilder(..));
        L$0 = this;
        L$1 = new IllegalStateException(..);
        L$2 = TransactionEventRequestKt$Dsl$Companion._create(..);
        L$3 = TransactionEventRequestKt$Dsl$Companion._create(..);
        L$4 = TransactionEventRequestKt$Dsl$Companion._create(..);
        label = L$1;
        deviceInfoRepository.staticDeviceInfo(L$0);
        if (if-ne(DeviceInfoRepository.staticDeviceInfo(..), L$3)) goto L_6d;
        return L$3;
      L_6d:
      L_73:
        TransactionEventRequestKt$Dsl.setStaticDeviceInfo(DeviceInfoRepository.staticDeviceInfo(..));
        deviceInfoRepository.getDynamicDeviceInfo();
        TransactionEventRequestKt$Dsl.setDynamicDeviceInfo(DeviceInfoRepository.getDynamicDeviceInfo(..));
        TransactionEventRequestKt$Dsl.setAppStore(TransactionEventRequestOuterClass$StoreType.STORE_TYPE_GOOGLE_PLAY);
        TransactionEventRequestKt$Dsl.getTransactionData();
        TransactionEventRequestKt$Dsl.addAllTransactionData(TransactionEventRequestKt$Dsl.getTransactionData(..), new IllegalStateException(..));
        TransactionEventRequestKt$Dsl._build();
        return TransactionEventRequestKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.DiagnosticEventObserver
// ============================================================
package com.unity3d.ads.core.domain.events;

public final class DiagnosticEventObserver {
    private final BackgroundWorker backgroundWorker;
    private final CoroutineDispatcher defaultDispatcher;
    private final DiagnosticEventRepository diagnosticEventRepository;
    private final GetDiagnosticEventBatchRequest getDiagnosticEventBatchRequest;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
    private final MutableStateFlow isRunning;
    private final UniversalRequestDataSource universalRequestDataSource;

    public DiagnosticEventObserver(GetUniversalRequestForPayLoad p0, GetDiagnosticEventBatchRequest p1, CoroutineDispatcher p2, DiagnosticEventRepository p3, UniversalRequestDataSource p4, BackgroundWorker p5) {
        new Object();
        getUniversalRequestForPayLoad = p0;
        getDiagnosticEventBatchRequest = p1;
        defaultDispatcher = p2;
        diagnosticEventRepository = p3;
        universalRequestDataSource = p4;
        backgroundWorker = p5;
        Boolean.valueOf(0);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        isRunning = StateFlowKt.MutableStateFlow(..);
        return;
    }

    public static final BackgroundWorker access$getBackgroundWorker$p(DiagnosticEventObserver p0) {
        return backgroundWorker;
    }

    public static final CoroutineDispatcher access$getDefaultDispatcher$p(DiagnosticEventObserver p0) {
        return defaultDispatcher;
    }

    public static final DiagnosticEventRepository access$getDiagnosticEventRepository$p(DiagnosticEventObserver p0) {
        return diagnosticEventRepository;
    }

    public static final GetDiagnosticEventBatchRequest access$getGetDiagnosticEventBatchRequest$p(DiagnosticEventObserver p0) {
        return getDiagnosticEventBatchRequest;
    }

    public static final GetUniversalRequestForPayLoad access$getGetUniversalRequestForPayLoad$p(DiagnosticEventObserver p0) {
        return getUniversalRequestForPayLoad;
    }

    public static final UniversalRequestDataSource access$getUniversalRequestDataSource$p(DiagnosticEventObserver p0) {
        return universalRequestDataSource;
    }

    public static final MutableStateFlow access$isRunning$p(DiagnosticEventObserver p0) {
        return isRunning;
    }

    public final Object invoke(Continuation p0) {
        new DiagnosticEventObserver$invoke$2(this, 0);
        BuildersKt.withContext(defaultDispatcher, new DiagnosticEventObserver$invoke$2(..), p0);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_17;
        return BuildersKt.withContext(..);
      L_17:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.EventObservers
// ============================================================
package com.unity3d.ads.core.domain.events;

public final class EventObservers {
    private final DiagnosticEventObserver diagnosticEventObserver;
    private final OperativeEventObserver operativeEventObserver;
    private final TransactionEventObserver transactionEventObserver;

    public EventObservers(OperativeEventObserver p0, DiagnosticEventObserver p1, TransactionEventObserver p2) {
        new Object();
        operativeEventObserver = p0;
        diagnosticEventObserver = p1;
        transactionEventObserver = p2;
        return;
    }

    public final DiagnosticEventObserver getDiagnosticEventObserver() {
        return diagnosticEventObserver;
    }

    public final OperativeEventObserver getOperativeEventObserver() {
        return operativeEventObserver;
    }

    public final TransactionEventObserver getTransactionEventObserver() {
        return transactionEventObserver;
    }

    public final Object invoke(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new EventObservers$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_48;
        if (if-eq(label, 1)) goto L_40;
        if (if-eq(label, 2)) goto L_38;
        if (if-ne(label, 3)) goto L_30;
        ResultKt.throwOnFailure(result);
      L_30:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_38:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_40:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_48:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        L$0 = this;
        label = 1;
        operativeEventObserver.invoke("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(OperativeEventObserver.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_58;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_58:
      L_59:
        L$0 = this;
        label = 2;
        diagnosticEventObserver.invoke("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(DiagnosticEventObserver.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_66;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_66:
        L$0 = 0;
        label = 3;
        transactionEventObserver.invoke("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(TransactionEventObserver.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_74;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_74:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.GetDiagnosticEventBatchRequest
// ============================================================
package com.unity3d.ads.core.domain.events;

public final class GetDiagnosticEventBatchRequest {
    public GetDiagnosticEventBatchRequest() {
        new Object();
        return;
    }

    public final DiagnosticEventRequestOuterClass$DiagnosticEventRequest invoke(List p0) {
        DiagnosticEventRequestOuterClass$DiagnosticEventRequest.newBuilder();
        DiagnosticEventRequestKt$Dsl$Companion._create(DiagnosticEventRequestOuterClass$DiagnosticEventRequest.newBuilder(..));
        DiagnosticEventRequestKt$Dsl.getBatch();
        DiagnosticEventRequestKt$Dsl.addAllBatch(DiagnosticEventRequestKt$Dsl.getBatch(..), p0);
        DiagnosticEventRequestKt$Dsl._build();
        return DiagnosticEventRequestKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest
// ============================================================
package com.unity3d.ads.core.domain.events;

public final class GetDiagnosticEventRequest {
    private final GetSharedDataTimestamps getSharedDataTimestamps;

    public GetDiagnosticEventRequest(GetSharedDataTimestamps p0) {
        new Object();
        getSharedDataTimestamps = p0;
        return;
    }

    public final DiagnosticEventRequestOuterClass$DiagnosticEvent invoke(String p0, Map p1, Map p2, Double p3, Boolean p4, ByteString p5, String p6, DiagnosticEventRequestOuterClass$DiagnosticAdType p7) {
        DiagnosticEventRequestOuterClass$DiagnosticEvent.newBuilder();
        DiagnosticEventKt$Dsl.Companion._create(DiagnosticEventRequestOuterClass$DiagnosticEvent.newBuilder(..));
        DiagnosticEventKt$Dsl.setEventType(DiagnosticEventRequestOuterClass$DiagnosticEventType.DIAGNOSTIC_EVENT_TYPE_CUSTOM);
        getSharedDataTimestamps.invoke();
        DiagnosticEventKt$Dsl.setTimestamps(GetSharedDataTimestamps.invoke(..));
        DiagnosticEventKt$Dsl.setCustomEventType(p0);
        if (if-eqz(p1)) goto L_2e;
        DiagnosticEventKt$Dsl.getStringTagsMap();
        DiagnosticEventKt$Dsl.putAllStringTags(DiagnosticEventKt$Dsl.getStringTagsMap(..), p1);
      L_2e:
        if (if-eqz(p2)) goto L_37;
        DiagnosticEventKt$Dsl.getIntTagsMap();
        DiagnosticEventKt$Dsl.putAllIntTags(DiagnosticEventKt$Dsl.getIntTagsMap(..), p2);
      L_37:
        if (if-eqz(p3)) goto L_42;
        p3.doubleValue();
        DiagnosticEventKt$Dsl.setTimeValue(Number.doubleValue(..), p1);
      L_42:
        if (if-eqz(p4)) goto L_4b;
        p4.booleanValue();
        DiagnosticEventKt$Dsl.setIsHeaderBidding(Boolean.booleanValue(..));
      L_4b:
        if (if-eqz(p5)) goto L_50;
        DiagnosticEventKt$Dsl.setImpressionOpportunityId(p5);
      L_50:
        if (if-eqz(p6)) goto L_55;
        DiagnosticEventKt$Dsl.setPlacementId(p6);
      L_55:
        if (if-eqz(p7)) goto L_5a;
        DiagnosticEventKt$Dsl.setAdType(p7);
      L_5a:
        DiagnosticEventKt$Dsl._build();
        return DiagnosticEventKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.GetOperativeEventApi
// ============================================================
package com.unity3d.ads.core.domain.events;

public final class GetOperativeEventApi {
    private final OperativeEventRepository operativeEventRepository;
    private final GetOperativeEventRequest operativeEventRequest;

    public GetOperativeEventApi(OperativeEventRepository p0, GetOperativeEventRequest p1) {
        new Object();
        operativeEventRepository = p0;
        operativeEventRequest = p1;
        return;
    }

    public static Object invoke$default(GetOperativeEventApi p0, OperativeEventRequestOuterClass$OperativeEventType p1, ByteString p2, ByteString p3, ByteString p4, String p5, Continuation p6, int p7, Object p8) {
        if (if-eqz(p7)) goto L_5;
      L_5:
        p0.invoke(p1, p2, p3, p4, 0, p6);
        return GetOperativeEventApi.invoke(..);
    }

    public final Object invoke(OperativeEventRequestOuterClass$OperativeEventType p0, ByteString p1, ByteString p2, ByteString p3, String p4, Continuation p5) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new GetOperativeEventApi$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_37;
        if (if-ne(label, 1)) goto L_2f;
        ResultKt.throwOnFailure(result);
      L_2f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_37:
        ResultKt.throwOnFailure(result);
        L$0 = this;
        label = 1;
        operativeEventRequest.invoke(new IllegalStateException(..), p2, "call to 'resume' before 'invoke' with coroutine", p3, p4, new GetOperativeEventApi$invoke$1(..));
        if (if-ne(GetOperativeEventRequest.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4c;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4c:
      L_4d:
        operativeEventRepository.addOperativeEvent(GetOperativeEventRequest.invoke(..));
        return Unit.INSTANCE;
    }

    public final Object invoke(OperativeEventRequestOuterClass$OperativeEventType p0, AdObject p1, ByteString p2, Continuation p3) {
        p1.getOpportunityId();
        p1.getTrackingToken();
        p1.getPlayerServerId();
        GetOperativeEventApi.invoke(p0, AdObject.getOpportunityId(..), AdObject.getTrackingToken(..), p2, AdObject.getPlayerServerId(..), p3);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(GetOperativeEventApi.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1b;
        return GetOperativeEventApi.invoke(..);
      L_1b:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.GetOperativeEventRequest
// ============================================================
package com.unity3d.ads.core.domain.events;

public final class GetOperativeEventRequest {
    private final CampaignRepository campaignRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetByteStringId generateByteStringId;
    private final SessionRepository sessionRepository;

    public GetOperativeEventRequest(GetByteStringId p0, DeviceInfoRepository p1, SessionRepository p2, CampaignRepository p3) {
        new Object();
        generateByteStringId = p0;
        deviceInfoRepository = p1;
        sessionRepository = p2;
        campaignRepository = p3;
        return;
    }

    public final Object invoke(OperativeEventRequestOuterClass$OperativeEventType p0, ByteString p1, ByteString p2, ByteString p3, String p4, Continuation p5) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new GetOperativeEventRequest$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_42;
        if (if-ne(label, 1)) goto L_3a;
        ResultKt.throwOnFailure(result);
      L_3a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_42:
        ResultKt.throwOnFailure(result);
        OperativeEventRequestOuterClass$OperativeEventRequest.newBuilder();
        OperativeEventRequestKt$Dsl$Companion._create(OperativeEventRequestOuterClass$OperativeEventRequest.newBuilder(..));
        generateByteStringId.invoke();
        OperativeEventRequestKt$Dsl.setEventId(GetByteStringId.invoke(..));
        OperativeEventRequestKt$Dsl.setEventType(new IllegalStateException(..));
        OperativeEventRequestKt$Dsl.setImpressionOpportunityId(L$1);
        OperativeEventRequestKt$Dsl.setTrackingToken("call to 'resume' before 'invoke' with coroutine");
        OperativeEventRequestKt$Dsl.setAdditionalData(L$0);
        if (if-eqz(p4)) goto L_6e;
        OperativeEventRequestKt$Dsl.setSid(p4);
      L_6e:
        deviceInfoRepository.getDynamicDeviceInfo();
        OperativeEventRequestKt$Dsl.setDynamicDeviceInfo(DeviceInfoRepository.getDynamicDeviceInfo(..));
        L$0 = this;
        L$1 = OperativeEventRequestKt$Dsl$Companion._create(..);
        L$2 = OperativeEventRequestKt$Dsl$Companion._create(..);
        L$3 = OperativeEventRequestKt$Dsl$Companion._create(..);
        label = 1;
        deviceInfoRepository.staticDeviceInfo(new GetOperativeEventRequest$invoke$1(..));
        if (if-ne(DeviceInfoRepository.staticDeviceInfo(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_8a;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_8a:
      L_8f:
        OperativeEventRequestKt$Dsl.setStaticDeviceInfo(DeviceInfoRepository.staticDeviceInfo(..));
        sessionRepository.getSessionCounters();
        OperativeEventRequestKt$Dsl.setSessionCounters(SessionRepository.getSessionCounters(..));
        campaignRepository.getCampaignState();
        OperativeEventRequestKt$Dsl.setCampaignState(CampaignRepository.getCampaignState(..));
        OperativeEventRequestKt$Dsl._build();
        return OperativeEventRequestKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.GetTransactionData
// ============================================================
package com.unity3d.ads.core.domain.events;

public abstract class GetTransactionData {
    public abstract TransactionEventRequestOuterClass$TransactionData invoke(PurchaseBridge p0, SkuDetailsBridge p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.GetTransactionRequest
// ============================================================
package com.unity3d.ads.core.domain.events;

public abstract class GetTransactionRequest {
    public abstract Object invoke(List p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.HandleGatewayEventResponse
// ============================================================
package com.unity3d.ads.core.domain.events;

public abstract class HandleGatewayEventResponse {
    public abstract Object invoke(UniversalResponseOuterClass$UniversalResponse p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.OperativeEventObserver
// ============================================================
package com.unity3d.ads.core.domain.events;

public final class OperativeEventObserver {
    private final BackgroundWorker backgroundWorker;
    private final CoroutineDispatcher defaultDispatcher;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
    private final MutableStateFlow isRunning;
    private final OperativeEventRepository operativeEventRepository;
    private final UniversalRequestDataSource universalRequestDataSource;

    public OperativeEventObserver(GetUniversalRequestForPayLoad p0, CoroutineDispatcher p1, OperativeEventRepository p2, UniversalRequestDataSource p3, BackgroundWorker p4) {
        new Object();
        getUniversalRequestForPayLoad = p0;
        defaultDispatcher = p1;
        operativeEventRepository = p2;
        universalRequestDataSource = p3;
        backgroundWorker = p4;
        Boolean.valueOf(0);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        isRunning = StateFlowKt.MutableStateFlow(..);
        return;
    }

    public static final BackgroundWorker access$getBackgroundWorker$p(OperativeEventObserver p0) {
        return backgroundWorker;
    }

    public static final CoroutineDispatcher access$getDefaultDispatcher$p(OperativeEventObserver p0) {
        return defaultDispatcher;
    }

    public static final GetUniversalRequestForPayLoad access$getGetUniversalRequestForPayLoad$p(OperativeEventObserver p0) {
        return getUniversalRequestForPayLoad;
    }

    public static final OperativeEventRepository access$getOperativeEventRepository$p(OperativeEventObserver p0) {
        return operativeEventRepository;
    }

    public static final UniversalRequestDataSource access$getUniversalRequestDataSource$p(OperativeEventObserver p0) {
        return universalRequestDataSource;
    }

    public static final MutableStateFlow access$isRunning$p(OperativeEventObserver p0) {
        return isRunning;
    }

    public final Object invoke(Continuation p0) {
        new OperativeEventObserver$invoke$2(this, 0);
        BuildersKt.withContext(defaultDispatcher, new OperativeEventObserver$invoke$2(..), p0);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_17;
        return BuildersKt.withContext(..);
      L_17:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.TransactionEventObserver
// ============================================================
package com.unity3d.ads.core.domain.events;

public final class TransactionEventObserver {
    private final CoroutineDispatcher defaultDispatcher;
    private final GatewayClient gatewayClient;
    private final GetRequestPolicy getRequestPolicy;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
    private final ByteStringDataSource iapTransactionStore;
    private final MutableStateFlow isRunning;
    private final TransactionEventRepository transactionEventRepository;

    public TransactionEventObserver(GetUniversalRequestForPayLoad p0, CoroutineDispatcher p1, TransactionEventRepository p2, GatewayClient p3, GetRequestPolicy p4, ByteStringDataSource p5) {
        new Object();
        getUniversalRequestForPayLoad = p0;
        defaultDispatcher = p1;
        transactionEventRepository = p2;
        gatewayClient = p3;
        getRequestPolicy = p4;
        iapTransactionStore = p5;
        Boolean.valueOf(0);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        isRunning = StateFlowKt.MutableStateFlow(..);
        return;
    }

    public static final CoroutineDispatcher access$getDefaultDispatcher$p(TransactionEventObserver p0) {
        return defaultDispatcher;
    }

    public static final GatewayClient access$getGatewayClient$p(TransactionEventObserver p0) {
        return gatewayClient;
    }

    public static final GetRequestPolicy access$getGetRequestPolicy$p(TransactionEventObserver p0) {
        return getRequestPolicy;
    }

    public static final GetUniversalRequestForPayLoad access$getGetUniversalRequestForPayLoad$p(TransactionEventObserver p0) {
        return getUniversalRequestForPayLoad;
    }

    public static final ByteStringDataSource access$getIapTransactionStore$p(TransactionEventObserver p0) {
        return iapTransactionStore;
    }

    public static final TransactionEventRepository access$getTransactionEventRepository$p(TransactionEventObserver p0) {
        return transactionEventRepository;
    }

    public static final MutableStateFlow access$isRunning$p(TransactionEventObserver p0) {
        return isRunning;
    }

    public final Object invoke(Continuation p0) {
        new TransactionEventObserver$invoke$2(this, 0);
        BuildersKt.withContext(defaultDispatcher, new TransactionEventObserver$invoke$2(..), p0);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_17;
        return BuildersKt.withContext(..);
      L_17:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.UniversalRequestEventSender
// ============================================================
package com.unity3d.ads.core.domain.events;

public final class UniversalRequestEventSender {
    private final GatewayClient gatewayClient;
    private final HandleGatewayEventResponse handleGatewayEventResponse;

    public UniversalRequestEventSender(GatewayClient p0, HandleGatewayEventResponse p1) {
        new Object();
        gatewayClient = p0;
        handleGatewayEventResponse = p1;
        return;
    }

    public final Object invoke(UniversalRequestOuterClass$UniversalRequest p0, RequestPolicy p1, Continuation p2) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new UniversalRequestEventSender$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_3d;
        if (if-eq(label, 1)) goto L_35;
        if (if-ne(label, 2)) goto L_2d;
        ResultKt.throwOnFailure(result);
      L_2d:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_35:
        ResultKt.throwOnFailure(result);
      L_3d:
        ResultKt.throwOnFailure(result);
        L$0 = this;
        label = 1;
        GatewayClient$DefaultImpls.request$default(gatewayClient, 0, L$0, "call to 'resume' before 'invoke' with coroutine", OperationType.UNIVERSAL_EVENT, new UniversalRequestEventSender$invoke$1(..), 1, 0);
        if (if-ne(GatewayClient$DefaultImpls.request$default(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_56;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_56:
      L_57:
        L$0 = 0;
        label = 2;
        handleGatewayEventResponse.invoke(GatewayClient$DefaultImpls.request$default(..), new UniversalRequestEventSender$invoke$1(..));
        if (if-ne(HandleGatewayEventResponse.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_67;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_67:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.CommonGetTransactionRequest$invoke$1
// ============================================================
package com.unity3d.ads.core.domain.events;

final class CommonGetTransactionRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    Object result;
    final CommonGetTransactionRequest this$0;

    CommonGetTransactionRequest$invoke$1(CommonGetTransactionRequest p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, this);
        return CommonGetTransactionRequest.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.DiagnosticEventObserver$invoke$2
// ============================================================
package com.unity3d.ads.core.domain.events;

final class DiagnosticEventObserver$invoke$2 extends SuspendLambda {
    int label;
    final DiagnosticEventObserver this$0;

    DiagnosticEventObserver$invoke$2(DiagnosticEventObserver p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new DiagnosticEventObserver$invoke$2(this$0, p1);
        return new DiagnosticEventObserver$invoke$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        DiagnosticEventObserver$invoke$2.invoke(p0, p1);
        return DiagnosticEventObserver$invoke$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        DiagnosticEventObserver$invoke$2.create(p0, p1);
        DiagnosticEventObserver$invoke$2.invokeSuspend(Unit.INSTANCE);
        return DiagnosticEventObserver$invoke$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_5a;
        ResultKt.throwOnFailure(p0);
        DiagnosticEventObserver.access$isRunning$p(this$0);
      L_10:
        MutableStateFlow.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        Boxing.boxBoolean(1);
        MutableStateFlow.compareAndSet(MutableStateFlow.getValue(..), Boxing.boxBoolean(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_10;
        MutableStateFlow.getValue(..).booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_2e;
        return Unit.INSTANCE;
      L_2e:
        DiagnosticEventObserver.access$getDiagnosticEventRepository$p(this$0);
        DiagnosticEventRepository.getDiagnosticEvents();
        new DiagnosticEventObserver$invoke$2$2(this$0, 0);
        FlowKt.onEach(DiagnosticEventRepository.getDiagnosticEvents(..), new DiagnosticEventObserver$invoke$2$2(..));
        DiagnosticEventObserver.access$getDefaultDispatcher$p(this$0);
        CoroutineScopeKt.CoroutineScope(DiagnosticEventObserver.access$getDefaultDispatcher$p(..));
        FlowKt.launchIn(FlowKt.onEach(..), CoroutineScopeKt.CoroutineScope(..));
        return Unit.INSTANCE;
      L_5a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.DiagnosticEventObserver$invoke$2$2
// ============================================================
package com.unity3d.ads.core.domain.events;

final class DiagnosticEventObserver$invoke$2$2 extends SuspendLambda {
    Object L$0;
    int label;
    final DiagnosticEventObserver this$0;

    DiagnosticEventObserver$invoke$2$2(DiagnosticEventObserver p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new DiagnosticEventObserver$invoke$2$2(this$0, p1);
        L$0 = p0;
        return new DiagnosticEventObserver$invoke$2$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        DiagnosticEventObserver$invoke$2$2.invoke(p0, p1);
        return DiagnosticEventObserver$invoke$2$2.invoke(..);
    }

    public final Object invoke(List p0, Continuation p1) {
        DiagnosticEventObserver$invoke$2$2.create(p0, p1);
        DiagnosticEventObserver$invoke$2$2.invokeSuspend(Unit.INSTANCE);
        return DiagnosticEventObserver$invoke$2$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_23;
        if (if-eq(label, 1)) goto L_1f;
        if (if-ne(label, 2)) goto L_17;
        ResultKt.throwOnFailure(p0);
      L_17:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1f:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_23:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder();
        UniversalRequestKt$PayloadKt$Dsl$Companion._create(UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder(..));
        DiagnosticEventObserver.access$getGetDiagnosticEventBatchRequest$p(this$0);
        GetDiagnosticEventBatchRequest.invoke(L$0);
        UniversalRequestKt$PayloadKt$Dsl.setDiagnosticEventRequest(GetDiagnosticEventBatchRequest.invoke(..));
        UniversalRequestKt$PayloadKt$Dsl._build();
        DiagnosticEventObserver.access$getGetUniversalRequestForPayLoad$p(this$0);
        label = 1;
        GetUniversalRequestForPayLoad.invoke(UniversalRequestKt$PayloadKt$Dsl._build(..), this);
        if (if-ne(GetUniversalRequestForPayLoad.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_5e;
        return "call to 'resume' before 'invoke' with coroutine";
      L_5e:
        UUID.randomUUID();
        UUID.randomUUID(..).toString();
        DiagnosticEventObserver.access$getUniversalRequestDataSource$p(this$0);
        UniversalRequestOuterClass$UniversalRequest.toByteArray();
        ByteStringsKt.toByteString(UniversalRequestOuterClass$UniversalRequest.toByteArray(..));
        L$0 = UUID.toString(..);
        label = 2;
        UniversalRequestDataSource.set(UUID.toString(..), ByteStringsKt.toByteString(..), this);
        if (if-ne(UniversalRequestDataSource.set(..), "call to 'resume' before 'invoke' with coroutine")) goto L_8e;
        return "call to 'resume' before 'invoke' with coroutine";
      L_8e:
      L_8f:
        new UniversalRequestWorkerData(UUID.toString(..));
        DiagnosticEventObserver.access$getBackgroundWorker$p(this$0);
        new Constraints$Builder();
        new Constraints$Builder(..).setRequiredNetworkType(NetworkType.CONNECTED);
        Constraints$Builder.build();
        new OneTimeWorkRequest$Builder(DiagnosticEventJob.class);
        new OneTimeWorkRequest$Builder(..).setConstraints(Constraints$Builder.build(..));
        new UniversalRequestWorkerData(..).invoke();
        OneTimeWorkRequest$Builder.setInputData(UniversalRequestWorkerData.invoke(..));
        OneTimeWorkRequest$Builder.build();
        BackgroundWorker.getWorkManager();
        BackgroundWorker.getWorkManager(..).enqueue(OneTimeWorkRequest$Builder.build(..));
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.EventObservers$invoke$1
// ============================================================
package com.unity3d.ads.core.domain.events;

final class EventObservers$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final EventObservers this$0;

    EventObservers$invoke$1(EventObservers p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(this);
        return EventObservers.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.GetOperativeEventApi$invoke$1
// ============================================================
package com.unity3d.ads.core.domain.events;

final class GetOperativeEventApi$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final GetOperativeEventApi this$0;

    GetOperativeEventApi$invoke$1(GetOperativeEventApi p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, 0, 0, 0, 0, this);
        return GetOperativeEventApi.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.GetOperativeEventRequest$invoke$1
// ============================================================
package com.unity3d.ads.core.domain.events;

final class GetOperativeEventRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    Object result;
    final GetOperativeEventRequest this$0;

    GetOperativeEventRequest$invoke$1(GetOperativeEventRequest p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, 0, 0, 0, 0, this);
        return GetOperativeEventRequest.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.OperativeEventObserver$invoke$2
// ============================================================
package com.unity3d.ads.core.domain.events;

final class OperativeEventObserver$invoke$2 extends SuspendLambda {
    int label;
    final OperativeEventObserver this$0;

    OperativeEventObserver$invoke$2(OperativeEventObserver p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new OperativeEventObserver$invoke$2(this$0, p1);
        return new OperativeEventObserver$invoke$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        OperativeEventObserver$invoke$2.invoke(p0, p1);
        return OperativeEventObserver$invoke$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        OperativeEventObserver$invoke$2.create(p0, p1);
        OperativeEventObserver$invoke$2.invokeSuspend(Unit.INSTANCE);
        return OperativeEventObserver$invoke$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_5a;
        ResultKt.throwOnFailure(p0);
        OperativeEventObserver.access$isRunning$p(this$0);
      L_10:
        MutableStateFlow.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        Boxing.boxBoolean(1);
        MutableStateFlow.compareAndSet(MutableStateFlow.getValue(..), Boxing.boxBoolean(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_10;
        MutableStateFlow.getValue(..).booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_2e;
        return Unit.INSTANCE;
      L_2e:
        OperativeEventObserver.access$getOperativeEventRepository$p(this$0);
        OperativeEventRepository.getOperativeEvents();
        new OperativeEventObserver$invoke$2$2(this$0, 0);
        FlowKt.onEach(OperativeEventRepository.getOperativeEvents(..), new OperativeEventObserver$invoke$2$2(..));
        OperativeEventObserver.access$getDefaultDispatcher$p(this$0);
        CoroutineScopeKt.CoroutineScope(OperativeEventObserver.access$getDefaultDispatcher$p(..));
        FlowKt.launchIn(FlowKt.onEach(..), CoroutineScopeKt.CoroutineScope(..));
        return Unit.INSTANCE;
      L_5a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.OperativeEventObserver$invoke$2$2
// ============================================================
package com.unity3d.ads.core.domain.events;

final class OperativeEventObserver$invoke$2$2 extends SuspendLambda {
    Object L$0;
    int label;
    final OperativeEventObserver this$0;

    OperativeEventObserver$invoke$2$2(OperativeEventObserver p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new OperativeEventObserver$invoke$2$2(this$0, p1);
        L$0 = p0;
        return new OperativeEventObserver$invoke$2$2(..);
    }

    public final Object invoke(OperativeEventRequestOuterClass$OperativeEventRequest p0, Continuation p1) {
        OperativeEventObserver$invoke$2$2.create(p0, p1);
        OperativeEventObserver$invoke$2$2.invokeSuspend(Unit.INSTANCE);
        return OperativeEventObserver$invoke$2$2.invokeSuspend(..);
    }

    public Object invoke(Object p0, Object p1) {
        OperativeEventObserver$invoke$2$2.invoke(p0, p1);
        return OperativeEventObserver$invoke$2$2.invoke(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_22;
        if (if-eq(label, 1)) goto L_1e;
        if (if-ne(label, 2)) goto L_16;
        ResultKt.throwOnFailure(p0);
      L_16:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1e:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_22:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder();
        UniversalRequestKt$PayloadKt$Dsl$Companion._create(UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder(..));
        UniversalRequestKt$PayloadKt$Dsl.setOperativeEvent(L$0);
        UniversalRequestKt$PayloadKt$Dsl._build();
        OperativeEventObserver.access$getGetUniversalRequestForPayLoad$p(this$0);
        label = 1;
        GetUniversalRequestForPayLoad.invoke(UniversalRequestKt$PayloadKt$Dsl._build(..), this);
        if (if-ne(GetUniversalRequestForPayLoad.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_53;
        return "call to 'resume' before 'invoke' with coroutine";
      L_53:
        UUID.randomUUID();
        UUID.randomUUID(..).toString();
        OperativeEventObserver.access$getUniversalRequestDataSource$p(this$0);
        UniversalRequestOuterClass$UniversalRequest.toByteArray();
        ByteStringsKt.toByteString(UniversalRequestOuterClass$UniversalRequest.toByteArray(..));
        L$0 = UUID.toString(..);
        label = 2;
        UniversalRequestDataSource.set(UUID.toString(..), ByteStringsKt.toByteString(..), this);
        if (if-ne(UniversalRequestDataSource.set(..), "call to 'resume' before 'invoke' with coroutine")) goto L_83;
        return "call to 'resume' before 'invoke' with coroutine";
      L_83:
      L_84:
        new UniversalRequestWorkerData(UUID.toString(..));
        OperativeEventObserver.access$getBackgroundWorker$p(this$0);
        new Constraints$Builder();
        new Constraints$Builder(..).setRequiredNetworkType(NetworkType.CONNECTED);
        Constraints$Builder.build();
        new OneTimeWorkRequest$Builder(OperativeEventJob.class);
        new OneTimeWorkRequest$Builder(..).setConstraints(Constraints$Builder.build(..));
        new UniversalRequestWorkerData(..).invoke();
        OneTimeWorkRequest$Builder.setInputData(UniversalRequestWorkerData.invoke(..));
        OneTimeWorkRequest$Builder.build();
        BackgroundWorker.getWorkManager();
        BackgroundWorker.getWorkManager(..).enqueue(OneTimeWorkRequest$Builder.build(..));
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.TransactionEventObserver$invoke$2
// ============================================================
package com.unity3d.ads.core.domain.events;

final class TransactionEventObserver$invoke$2 extends SuspendLambda {
    int label;
    final TransactionEventObserver this$0;

    TransactionEventObserver$invoke$2(TransactionEventObserver p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new TransactionEventObserver$invoke$2(this$0, p1);
        return new TransactionEventObserver$invoke$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        TransactionEventObserver$invoke$2.invoke(p0, p1);
        return TransactionEventObserver$invoke$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        TransactionEventObserver$invoke$2.create(p0, p1);
        TransactionEventObserver$invoke$2.invokeSuspend(Unit.INSTANCE);
        return TransactionEventObserver$invoke$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_5a;
        ResultKt.throwOnFailure(p0);
        TransactionEventObserver.access$isRunning$p(this$0);
      L_10:
        MutableStateFlow.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        Boxing.boxBoolean(1);
        MutableStateFlow.compareAndSet(MutableStateFlow.getValue(..), Boxing.boxBoolean(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_10;
        MutableStateFlow.getValue(..).booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_2e;
        return Unit.INSTANCE;
      L_2e:
        TransactionEventObserver.access$getTransactionEventRepository$p(this$0);
        TransactionEventRepository.getTransactionEvents();
        new TransactionEventObserver$invoke$2$2(this$0, 0);
        FlowKt.onEach(TransactionEventRepository.getTransactionEvents(..), new TransactionEventObserver$invoke$2$2(..));
        TransactionEventObserver.access$getDefaultDispatcher$p(this$0);
        CoroutineScopeKt.CoroutineScope(TransactionEventObserver.access$getDefaultDispatcher$p(..));
        FlowKt.launchIn(FlowKt.onEach(..), CoroutineScopeKt.CoroutineScope(..));
        return Unit.INSTANCE;
      L_5a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.TransactionEventObserver$invoke$2$2
// ============================================================
package com.unity3d.ads.core.domain.events;

final class TransactionEventObserver$invoke$2$2 extends SuspendLambda {
    Object L$0;
    int label;
    final TransactionEventObserver this$0;

    TransactionEventObserver$invoke$2$2(TransactionEventObserver p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new TransactionEventObserver$invoke$2$2(this$0, p1);
        L$0 = p0;
        return new TransactionEventObserver$invoke$2$2(..);
    }

    public final Object invoke(TransactionEventRequestOuterClass$TransactionEventRequest p0, Continuation p1) {
        TransactionEventObserver$invoke$2$2.create(p0, p1);
        TransactionEventObserver$invoke$2$2.invokeSuspend(Unit.INSTANCE);
        return TransactionEventObserver$invoke$2$2.invokeSuspend(..);
    }

    public Object invoke(Object p0, Object p1) {
        TransactionEventObserver$invoke$2$2.invoke(p0, p1);
        return TransactionEventObserver$invoke$2$2.invoke(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_2a;
        if (if-eq(label, 1)) goto L_26;
        if (if-eq(label, 2)) goto L_1e;
        if (if-ne(label, 3)) goto L_16;
        ResultKt.throwOnFailure(p0);
      L_16:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1e:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_26:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_2a:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder();
        UniversalRequestKt$PayloadKt$Dsl$Companion._create(UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder(..));
        UniversalRequestKt$PayloadKt$Dsl.setTransactionEventRequest(L$0);
        UniversalRequestKt$PayloadKt$Dsl._build();
        TransactionEventObserver.access$getGetUniversalRequestForPayLoad$p(this$0);
        label = 1;
        GetUniversalRequestForPayLoad.invoke(UniversalRequestKt$PayloadKt$Dsl._build(..), this);
        if (if-ne(GetUniversalRequestForPayLoad.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_5b;
        return "call to 'resume' before 'invoke' with coroutine";
      L_5b:
        TransactionEventObserver.access$getGatewayClient$p(this$0);
        TransactionEventObserver.access$getGetRequestPolicy$p(this$0);
        GetRequestPolicy.invoke();
        L$0 = GetUniversalRequestForPayLoad.invoke(..);
        label = 2;
        GatewayClient$DefaultImpls.request$default(TransactionEventObserver.access$getGatewayClient$p(..), 0, GetUniversalRequestForPayLoad.invoke(..), GetRequestPolicy.invoke(..), OperationType.TRANSACTION_EVENT, this, 1, 0);
        if (if-ne(GatewayClient$DefaultImpls.request$default(..), "call to 'resume' before 'invoke' with coroutine")) goto L_82;
        return "call to 'resume' before 'invoke' with coroutine";
      L_82:
        UniversalResponseOuterClass$UniversalResponse.getError();
        if (if-eqz(UniversalResponseOuterClass$UniversalResponse.getError(..))) goto L_b4;
        TransactionEventObserver.access$getIapTransactionStore$p(this$0);
        UniversalRequestOuterClass$UniversalRequest.getSharedData();
        UniversalRequestOuterClass$UniversalRequest$SharedData.getTimestamps();
        TimestampsOuterClass$Timestamps.getTimestamp();
        Timestamp.toByteString();
        L$0 = 0;
        label = 3;
        ByteStringDataSource.set(Timestamp.toByteString(..), this);
        if (if-ne(ByteStringDataSource.set(..), "call to 'resume' before 'invoke' with coroutine")) goto L_b4;
        return "call to 'resume' before 'invoke' with coroutine";
      L_b4:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.events.UniversalRequestEventSender$invoke$1
// ============================================================
package com.unity3d.ads.core.domain.events;

final class UniversalRequestEventSender$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final UniversalRequestEventSender this$0;

    UniversalRequestEventSender$invoke$1(UniversalRequestEventSender p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, 0, this);
        return UniversalRequestEventSender.invoke(..);
    }

}

