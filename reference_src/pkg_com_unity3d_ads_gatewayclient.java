// Package bundle: com.unity3d.ads.gatewayclient (8 classes)

// ============================================================
// CLASS: com.unity3d.ads.gatewayclient.CommonGatewayClient
// ============================================================
package com.unity3d.ads.gatewayclient;

public final class CommonGatewayClient {
    public static final int CODE_400 = 400;
    public static final int CODE_599 = 599;
    public static final CommonGatewayClient$Companion Companion = null;
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_PROTOBUF = "application/x-protobuf";
    public static final String HEADER_RETRY_ATTEMPT = "X-RETRY-ATTEMPT";
    private final HandleGatewayUniversalResponse handleGatewayUniversalResponse;
    private final HttpClient httpClient;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;

    static <clinit>() {
        new CommonGatewayClient$Companion(0);
        Companion = new CommonGatewayClient$Companion(..);
        return;
    }

    public CommonGatewayClient(HttpClient p0, HandleGatewayUniversalResponse p1, SendDiagnosticEvent p2, SessionRepository p3) {
        new Object();
        httpClient = p0;
        handleGatewayUniversalResponse = p1;
        sendDiagnosticEvent = p2;
        sessionRepository = p3;
        return;
    }

    public static final Object access$executeRequest(CommonGatewayClient p0, HttpRequest p1, int p2, OperationType p3, Continuation p4) {
        p0.executeRequest(p1, p2, p3, p4);
        return CommonGatewayClient.executeRequest(..);
    }

    public static final Object access$executeWithRetry(CommonGatewayClient p0, String p1, UniversalRequestOuterClass$UniversalRequest p2, RequestPolicy p3, OperationType p4, Continuation p5) {
        p0.executeWithRetry(p1, p2, p3, p4, p5);
        return CommonGatewayClient.executeWithRetry(..);
    }

    private final HttpRequest buildHttpRequest(String p0, Map p1, RequestPolicy p2, UniversalRequestOuterClass$UniversalRequest p3) {
        p3.toByteArray();
        p2.getConnectTimeout();
        p2.getReadTimeout();
        p2.getWriteTimeout();
        p2.getOverallTimeout();
        new HttpRequest(p0, 0, RequestType.POST, UniversalRequestOuterClass$UniversalRequest.toByteArray(..), p1, 0, 0, 0, 0, RequestPolicy.getConnectTimeout(..), RequestPolicy.getReadTimeout(..), RequestPolicy.getWriteTimeout(..), RequestPolicy.getOverallTimeout(..), 1, 0);
        return new HttpRequest;
    }

    private final long calculateDelayTime(RequestPolicy p0, int p1) {
        p0.getRetryWaitBase();
        CommonGatewayClient.calculateExponentialBackoff(RequestPolicy.getRetryWaitBase(..), p1);
        p0.getRetryJitterPct();
        CommonGatewayClient.calculateJitter(CommonGatewayClient.calculateExponentialBackoff(..), v1, RequestPolicy.getRetryJitterPct(..));
        p0.getRetryMaxInterval();
        Math.min(CommonGatewayClient.calculateExponentialBackoff(..), v1, RequestPolicy.getRetryMaxInterval(..), RequestPolicy.getRetryJitterPct(..));
        return Math.min(..);
    }

    private final long calculateExponentialBackoff(int p0, int p1) {
        Math.pow(Color(0x40000000), v3, p0, p1);
        return v0;
    }

    private final long calculateJitter(long p0, float p1) {
        Random.Default.nextLong(v0, v1, p0, v6);
        return Random$Default.nextLong(..);
    }

    private final Object executeRequest(HttpRequest p0, int p1, OperationType p2, Continuation p3) {
        if (if-eqz(v2)) goto L_18;
        if (if-eqz(label)) goto L_18;
        label = label;
      L_18:
        new CommonGatewayClient$executeRequest$1(this, label);
      L_1d:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_57;
        if (if-ne(label, 1)) goto L_4f;
        ResultKt.throwOnFailure(result);
      L_4f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_57:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        TimeSource$Monotonic.INSTANCE.markNow-z9LOYto();
        L$0 = this;
        L$1 = p2;
        I$0 = p1;
        J$0 = TimeSource$Monotonic.markNow-z9LOYto(..);
        label = I$0;
        httpClient.execute(p0, "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(HttpClient.execute(..), J$0)) goto L_79;
        return J$0;
      L_79:
      L_7b:
        TimeSource$Monotonic$ValueTimeMark.box-impl(TimeSource$Monotonic.markNow-z9LOYto(..), v7);
        CommonGatewayClient.sendNetworkSuccessDiagnosticEvent(HttpClient.execute(..), p1, p2, TimeSource$Monotonic$ValueTimeMark.box-impl(..));
      L_97:
      L_98:
        new UnityAdsNetworkException("Gateway request was canceled due to exceeding timeout for operation", 0, 0, 0, 0, 0, 0, 126, 0);
        TimeSource$Monotonic$ValueTimeMark.box-impl(TimeSource$Monotonic.markNow-z9LOYto(..), v7);
        CommonGatewayClient.sendNetworkErrorDiagnosticEvent(new UnityAdsNetworkException, p1, p2, TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        throw new UnityAdsNetworkException;
      L_b8:
      L_b9:
        TimeSource$Monotonic$ValueTimeMark.box-impl(TimeSource$Monotonic.markNow-z9LOYto(..), v7);
        CommonGatewayClient.sendNetworkErrorDiagnosticEvent(new UnityAdsNetworkException, p1, p2, TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        HttpResponseKt.toHttpResponse(new UnityAdsNetworkException);
      L_c4:
        return HttpResponseKt.toHttpResponse(..);
    }

    private final Object executeWithRetry(String p0, UniversalRequestOuterClass$UniversalRequest p1, RequestPolicy p2, OperationType p3, Continuation p4) {
        if (if-eqz(v1)) goto L_18;
        if (if-eqz(label)) goto L_18;
        label = label;
      L_18:
        new CommonGatewayClient$executeWithRetry$1(this, label);
      L_1f:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_9b;
        if (if-eq(label, 1)) goto L_78;
        if (if-eq(label, 2)) goto L_6f;
        if (if-ne(label, 3)) goto L_67;
        ResultKt.throwOnFailure(result);
      L_59:
      L_67:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_6f:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_78:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_9b:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        CommonGatewayClient.getGatewayUrl(p0);
        TimeSource$Monotonic.INSTANCE.markNow-z9LOYto();
      L_b5:
        CommonGatewayClient.getHeaders(0);
        CommonGatewayClient.buildHttpRequest(CommonGatewayClient.getGatewayUrl(..), CommonGatewayClient.getHeaders(..), p2, p1);
        L$0 = this;
        L$1 = p1;
        L$2 = p2;
        L$3 = p3;
        L$4 = CommonGatewayClient.getGatewayUrl(..);
        I$0 = 0;
        J$0 = TimeSource$Monotonic.markNow-z9LOYto(..);
        label = 1;
        CommonGatewayClient.executeRequest(CommonGatewayClient.buildHttpRequest(..), 0, p3, L$0);
        if (if-ne(CommonGatewayClient.executeRequest(..), L$3)) goto L_d4;
        return L$3;
      L_d4:
      L_e7:
        HttpResponseKt.isSuccessful(CommonGatewayClient.executeRequest(..));
        if (if-eqz(HttpResponseKt.isSuccessful(..))) goto L_10b;
        CommonGatewayClient.getUniversalResponse(CommonGatewayClient.executeRequest(..), p3);
        L$0 = CommonGatewayClient.getUniversalResponse(..);
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        L$4 = 0;
        label = 2;
        handleGatewayUniversalResponse.invoke(CommonGatewayClient.getUniversalResponse(..), L$0);
        if (if-ne(HandleGatewayUniversalResponse.invoke(..), L$3)) goto L_109;
        return L$3;
      L_109:
      L_10a:
        return CommonGatewayClient.getUniversalResponse(..);
      L_10b:
        CommonGatewayClient.calculateDelayTime(p2, handleGatewayUniversalResponse);
        TimeSource$Monotonic$ValueTimeMark.box-impl(TimeSource$Monotonic.markNow-z9LOYto(..), 0);
        TimeExtensionsKt.elapsedMillis(TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        HttpResponse.getStatusCode();
        p2.getMaxDuration();
        CommonGatewayClient.shouldRetry(HttpResponse.getStatusCode(..), this, L$3, RequestPolicy.getMaxDuration(..));
        if (if-eqz(CommonGatewayClient.shouldRetry(..))) goto L_1a8;
        L$0 = this;
        L$1 = p1;
        L$2 = p2;
        L$3 = p3;
        L$4 = CommonGatewayClient.getGatewayUrl(..);
        I$0 = handleGatewayUniversalResponse;
        J$0 = TimeSource$Monotonic.markNow-z9LOYto(..);
        label = 3;
        DelayKt.delay(CommonGatewayClient.calculateDelayTime(..), 1, CommonGatewayClient.getUniversalResponse(..));
        if (if-ne(DelayKt.delay(..), L$3)) goto L_14a;
        return L$3;
      L_14a:
      L_150:
      L_160:
        new StringBuilder("Gateway was canceled while waiting for next request,  after ");
        new StringBuilder(..).append(CommonGatewayClient.getGatewayUrl(..));
        new StringBuilder(..).append(" retries currentDuration: ");
        TimeSource$Monotonic$ValueTimeMark.box-impl(L$3, 0);
        TimeExtensionsKt.elapsedMillis(TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        new StringBuilder(..).append(TimeExtensionsKt.elapsedMillis(..), p3);
        new StringBuilder(..).append(" maxDuration: ");
        p2.getMaxDuration();
        new StringBuilder(..).append(RequestPolicy.getMaxDuration(..));
        new StringBuilder(..).append(0);
        new StringBuilder(..).toString();
        new UnityAdsNetworkException(StringBuilder.toString(..), 0, 0, 0, 0, 0, 0, 126, 0);
        throw new UnityAdsNetworkException;
      L_1a8:
        new StringBuilder("Gateway request failed after ");
        new StringBuilder(..).append(CommonGatewayClient.getGatewayUrl(..));
        new StringBuilder(..).append(" retries  currentDuration: ");
        new StringBuilder(..).append(TimeExtensionsKt.elapsedMillis(..), "Gateway request failed after ");
        new StringBuilder(..).append(" maxDuration: ");
        p2.getMaxDuration();
        new StringBuilder(..).append(RequestPolicy.getMaxDuration(..));
        new StringBuilder(..).append(0);
        new StringBuilder(..).toString();
        new UnityAdsNetworkException(StringBuilder.toString(..), 0, 0, 0, 0, 0, 0, 126, 0);
        throw new UnityAdsNetworkException;
    }

    private final String getGatewayUrl(String p0) {
        Intrinsics.areEqual(p0, "https://gateway.unityads.unity3d.com/v1");
        if (if-nez(Intrinsics.areEqual(..))) goto L_9;
      L_9:
        sessionRepository.getGatewayUrl();
      L_f:
        return SessionRepository.getGatewayUrl(..);
    }

    private final Map getHeaders(int p0) {
        MapsKt.createMapBuilder();
        CollectionsKt.listOf("application/x-protobuf");
        MapsKt.createMapBuilder(..).put("Content-Type", CollectionsKt.listOf(..));
        if (if-lez(p0)) goto L_1e;
        String.valueOf(p0);
        CollectionsKt.listOf(String.valueOf(..));
        MapsKt.createMapBuilder(..).put("X-RETRY-ATTEMPT", CollectionsKt.listOf(..));
      L_1e:
        MapsKt.build(MapsKt.createMapBuilder(..));
        return MapsKt.build(..);
    }

    private final UniversalResponseOuterClass$UniversalResponse getUniversalResponse(HttpResponse p0, OperationType p1) {
        p0.getBody();
        if (if-eqz(v1)) goto L_14;
        UniversalResponseOuterClass$UniversalResponse.parseFrom(HttpResponse.getBody(..));
        return UniversalResponseOuterClass$UniversalResponse.parseFrom(..);
      L_14:
        if (if-eqz("parseFrom(responseBody)")) goto L_2f;
        String.getBytes(Charsets.ISO_8859_1);
        UniversalResponseOuterClass$UniversalResponse.parseFrom(String.getBytes(..));
        return UniversalResponseOuterClass$UniversalResponse.parseFrom(..);
      L_2f:
        new InvalidProtocolBufferException("Could not parse response from gateway service");
        throw new InvalidProtocolBufferException(..);
        InvalidProtocolBufferException.getLocalizedMessage();
        DeviceLog.debug("Failed to parse response from gateway service with exception: %s", v2);
        p1.toString();
        TuplesKt.to("operation", OperationType.toString(..));
        TuplesKt.to("reason", "protobuf_parsing");
        p0.getBody();
        HttpResponse.getBody(..).toString();
        TuplesKt.to("reason_debug", Object.toString(..));
        MapsKt.mapOf(3);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_network_parse_failure", 0, MapsKt.mapOf(..), 0, 0, 26, 0);
        UniversalResponseOuterClass$UniversalResponse.newBuilder();
        UniversalResponseKt$Dsl.Companion._create(UniversalResponseOuterClass$UniversalResponse.newBuilder(..));
        ErrorOuterClass$Error.newBuilder();
        ErrorKt$Dsl.Companion._create(ErrorOuterClass$Error.newBuilder(..));
        ErrorKt$Dsl$Companion._create(..).setErrorText("ERROR: Could not parse response from gateway service");
        ErrorKt$Dsl$Companion._create(..)._build();
        UniversalResponseKt$Dsl.setError(ErrorKt$Dsl._build(..));
        UniversalResponseKt$Dsl._build();
        return UniversalResponseKt$Dsl._build(..);
    }

    private final void sendNetworkErrorDiagnosticEvent(UnityAdsNetworkException p0, int p1, OperationType p2, TimeMark p3) {
        if (if-ne(p2, OperationType.UNIVERSAL_EVENT)) goto L_5;
        return;
      L_5:
        p2.toString();
        TuplesKt.to("operation", OperationType.toString(..));
        String.valueOf(p1);
        TuplesKt.to("retries", String.valueOf(..));
        p0.getProtocol();
        String.valueOf(UnityAdsNetworkException.getProtocol(..));
        TuplesKt.to("protocol", String.valueOf(..));
        p0.getClient();
        String.valueOf(UnityAdsNetworkException.getClient(..));
        TuplesKt.to("network_client", String.valueOf(..));
        p0.getCode();
        String.valueOf(UnityAdsNetworkException.getCode(..));
        TuplesKt.to("reason_code", String.valueOf(..));
        p0.getMessage();
        TuplesKt.to("reason_debug", UnityAdsNetworkException.getMessage(..));
        MapsKt.mutableMapOf(6);
        TimeExtensionsKt.elapsedMillis(p3);
        Double.valueOf(TimeExtensionsKt.elapsedMillis(..), 5);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_network_failure_time", Double.valueOf(..), MapsKt.mutableMapOf(..), 0, 0, 24, 0);
        return;
    }

    private final void sendNetworkSuccessDiagnosticEvent(HttpResponse p0, int p1, OperationType p2, TimeMark p3) {
        if (if-ne(p2, OperationType.UNIVERSAL_EVENT)) goto L_5;
        return;
      L_5:
        p2.toString();
        TuplesKt.to("operation", OperationType.toString(..));
        String.valueOf(p1);
        TuplesKt.to("retries", String.valueOf(..));
        p0.getProtocol();
        TuplesKt.to("protocol", HttpResponse.getProtocol(..));
        p0.getClient();
        TuplesKt.to("network_client", HttpResponse.getClient(..));
        p0.getStatusCode();
        String.valueOf(HttpResponse.getStatusCode(..));
        TuplesKt.to("reason_code", String.valueOf(..));
        MapsKt.mutableMapOf(5);
        TimeExtensionsKt.elapsedMillis(p3);
        Double.valueOf(TimeExtensionsKt.elapsedMillis(..), 4);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_network_success_time", Double.valueOf(..), MapsKt.mutableMapOf(..), 0, 0, 24, 0);
        return;
    }

    private final boolean shouldRetry(int p0, long p1, int p2) {
        if (if-gt(400, p0)) goto L_c;
        if (if-ge(p0, 600)) goto L_c;
      L_c:
      L_d:
        if (if-eqz(0)) goto L_15;
        if (if-gez(0)) goto L_15;
      L_15:
      L_16:
        return 0;
    }

    public Object request(String p0, UniversalRequestOuterClass$UniversalRequest p1, RequestPolicy p2, OperationType p3, Continuation p4) {
        p2.getMaxDuration();
        new CommonGatewayClient$request$2(this, p0, p1, p2, p3, 0);
        TimeoutKt.withTimeout(RequestPolicy.getMaxDuration(..), v1, new CommonGatewayClient$request$2, p4);
        return TimeoutKt.withTimeout(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.gatewayclient.GatewayClient
// ============================================================
package com.unity3d.ads.gatewayclient;

public abstract class GatewayClient {
    public abstract Object request(String p0, UniversalRequestOuterClass$UniversalRequest p1, RequestPolicy p2, OperationType p3, Continuation p4) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.gatewayclient.RequestPolicy
// ============================================================
package com.unity3d.ads.gatewayclient;

public final class RequestPolicy {
    private final int connectTimeout;
    private final int maxDuration;
    private final int overallTimeout;
    private final int readTimeout;
    private final float retryJitterPct;
    private final int retryMaxInterval;
    private final int retryWaitBase;
    private final boolean shouldStoreLocally;
    private final int writeTimeout;

    public RequestPolicy(int p0, int p1, int p2, float p3, int p4, int p5, int p6, int p7, boolean p8) {
        new Object();
        maxDuration = p0;
        retryMaxInterval = p1;
        retryWaitBase = p2;
        retryJitterPct = p3;
        connectTimeout = p4;
        readTimeout = p5;
        writeTimeout = p6;
        overallTimeout = p7;
        shouldStoreLocally = p8;
        return;
    }

    public static RequestPolicy copy$default(RequestPolicy p0, int p1, int p2, int p3, float p4, int p5, int p6, int p7, int p8, boolean p9, int p10, Object p11) {
        if (if-eqz(v2)) goto L_a;
      L_a:
      L_b:
        if (if-eqz(v3)) goto L_12;
      L_12:
      L_13:
        if (if-eqz(v4)) goto L_1a;
      L_1a:
      L_1b:
        if (if-eqz(v5)) goto L_22;
      L_22:
      L_23:
        if (if-eqz(v6)) goto L_2a;
      L_2a:
      L_2b:
        if (if-eqz(v7)) goto L_32;
      L_32:
      L_34:
        if (if-eqz(v8)) goto L_3b;
      L_3b:
      L_3d:
        if (if-eqz(v9)) goto L_44;
      L_44:
      L_46:
        if (if-eqz(p10)) goto L_4d;
      L_4d:
      L_4f:
        p0.copy(p1, p2, p3, p4, p5, p6, p7, p8, p9);
        return RequestPolicy.copy(..);
    }

    public final int component1() {
        return maxDuration;
    }

    public final int component2() {
        return retryMaxInterval;
    }

    public final int component3() {
        return retryWaitBase;
    }

    public final float component4() {
        return retryJitterPct;
    }

    public final int component5() {
        return connectTimeout;
    }

    public final int component6() {
        return readTimeout;
    }

    public final int component7() {
        return writeTimeout;
    }

    public final int component8() {
        return overallTimeout;
    }

    public final boolean component9() {
        return shouldStoreLocally;
    }

    public final RequestPolicy copy(int p0, int p1, int p2, float p3, int p4, int p5, int p6, int p7, boolean p8) {
        new RequestPolicy(p0, p1, p2, p3, p4, p5, p6, p7, p8);
        return new RequestPolicy;
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        if (if-eq(maxDuration, maxDuration)) goto L_13;
        return 0;
      L_13:
        if (if-eq(retryMaxInterval, retryMaxInterval)) goto L_1a;
        return 0;
      L_1a:
        if (if-eq(retryWaitBase, retryWaitBase)) goto L_21;
        return 0;
      L_21:
        Float.compare(retryJitterPct, retryJitterPct);
        if (if-eqz(Float.compare(..))) goto L_2c;
        return 0;
      L_2c:
        if (if-eq(connectTimeout, connectTimeout)) goto L_33;
        return 0;
      L_33:
        if (if-eq(readTimeout, readTimeout)) goto L_3a;
        return 0;
      L_3a:
        if (if-eq(writeTimeout, writeTimeout)) goto L_41;
        return 0;
      L_41:
        if (if-eq(overallTimeout, overallTimeout)) goto L_48;
        return 0;
      L_48:
        if (if-eq(shouldStoreLocally, shouldStoreLocally)) goto L_4f;
        return 0;
      L_4f:
        return 1;
    }

    public final int getConnectTimeout() {
        return connectTimeout;
    }

    public final int getMaxDuration() {
        return maxDuration;
    }

    public final int getOverallTimeout() {
        return overallTimeout;
    }

    public final int getReadTimeout() {
        return readTimeout;
    }

    public final float getRetryJitterPct() {
        return retryJitterPct;
    }

    public final int getRetryMaxInterval() {
        return retryMaxInterval;
    }

    public final int getRetryWaitBase() {
        return retryWaitBase;
    }

    public final boolean getShouldStoreLocally() {
        return shouldStoreLocally;
    }

    public final int getWriteTimeout() {
        return writeTimeout;
    }

    public int hashCode() {
        Float.floatToIntBits(retryJitterPct);
        if (if-eqz(shouldStoreLocally)) goto L_30;
      L_30:
        return maxDuration;
    }

    public String toString() {
        new StringBuilder("RequestPolicy(maxDuration=");
        new StringBuilder(..).append(maxDuration);
        new StringBuilder(..).append(", retryMaxInterval=");
        new StringBuilder(..).append(retryMaxInterval);
        new StringBuilder(..).append(", retryWaitBase=");
        new StringBuilder(..).append(retryWaitBase);
        new StringBuilder(..).append(", retryJitterPct=");
        new StringBuilder(..).append(retryJitterPct);
        new StringBuilder(..).append(", connectTimeout=");
        new StringBuilder(..).append(connectTimeout);
        new StringBuilder(..).append(", readTimeout=");
        new StringBuilder(..).append(readTimeout);
        new StringBuilder(..).append(", writeTimeout=");
        new StringBuilder(..).append(writeTimeout);
        new StringBuilder(..).append(", overallTimeout=");
        new StringBuilder(..).append(overallTimeout);
        new StringBuilder(..).append(", shouldStoreLocally=");
        new StringBuilder(..).append(shouldStoreLocally);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.gatewayclient.CommonGatewayClient$Companion
// ============================================================
package com.unity3d.ads.gatewayclient;

public final class CommonGatewayClient$Companion {
    private CommonGatewayClient$Companion() {
        new Object();
        return;
    }

    public CommonGatewayClient$Companion(DefaultConstructorMarker p0) {
        new CommonGatewayClient$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.gatewayclient.CommonGatewayClient$executeRequest$1
// ============================================================
package com.unity3d.ads.gatewayclient;

final class CommonGatewayClient$executeRequest$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final CommonGatewayClient this$0;

    CommonGatewayClient$executeRequest$1(CommonGatewayClient p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        CommonGatewayClient.access$executeRequest(this$0, 0, 0, 0, this);
        return CommonGatewayClient.access$executeRequest(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.gatewayclient.CommonGatewayClient$executeWithRetry$1
// ============================================================
package com.unity3d.ads.gatewayclient;

final class CommonGatewayClient$executeWithRetry$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    Object result;
    final CommonGatewayClient this$0;

    CommonGatewayClient$executeWithRetry$1(CommonGatewayClient p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        CommonGatewayClient.access$executeWithRetry(this$0, 0, 0, 0, 0, this);
        return CommonGatewayClient.access$executeWithRetry(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.gatewayclient.CommonGatewayClient$request$2
// ============================================================
package com.unity3d.ads.gatewayclient;

final class CommonGatewayClient$request$2 extends SuspendLambda {
    final OperationType $operationType;
    final UniversalRequestOuterClass$UniversalRequest $request;
    final RequestPolicy $requestPolicy;
    final String $url;
    int label;
    final CommonGatewayClient this$0;

    CommonGatewayClient$request$2(CommonGatewayClient p0, String p1, UniversalRequestOuterClass$UniversalRequest p2, RequestPolicy p3, OperationType p4, Continuation p5) {
        this$0 = p0;
        $url = p1;
        $request = p2;
        $requestPolicy = p3;
        $operationType = p4;
        new SuspendLambda(2, p5);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new CommonGatewayClient$request$2(this$0, $url, $request, $requestPolicy, $operationType, p1);
        return new CommonGatewayClient$request$2;
    }

    public Object invoke(Object p0, Object p1) {
        CommonGatewayClient$request$2.invoke(p0, p1);
        return CommonGatewayClient$request$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        CommonGatewayClient$request$2.create(p0, p1);
        CommonGatewayClient$request$2.invokeSuspend(Unit.INSTANCE);
        return CommonGatewayClient$request$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        label = 1;
        CommonGatewayClient.access$executeWithRetry(this$0, $url, $request, $requestPolicy, $operationType, this);
        if (if-ne(CommonGatewayClient.access$executeWithRetry(..), "call to 'resume' before 'invoke' with coroutine")) goto L_31;
        return "call to 'resume' before 'invoke' with coroutine";
      L_31:
        return CommonGatewayClient.access$executeWithRetry(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.gatewayclient.GatewayClient$DefaultImpls
// ============================================================
package com.unity3d.ads.gatewayclient;

public final class GatewayClient$DefaultImpls {
    public static Object request$default(GatewayClient p0, String p1, UniversalRequestOuterClass$UniversalRequest p2, RequestPolicy p3, OperationType p4, Continuation p5, int p6, Object p7) {
        if (if-nez(p7)) goto L_19;
        if (if-eqz(p7)) goto L_8;
      L_8:
        if (if-eqz("https://gateway.unityads.unity3d.com/v1")) goto L_f;
      L_f:
        p0.request("https://gateway.unityads.unity3d.com/v1", p2, p3, OperationType.UNKNOWN, p5);
        return GatewayClient.request(..);
      L_19:
        new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: request");
        throw new UnsupportedOperationException(..);
    }

}

