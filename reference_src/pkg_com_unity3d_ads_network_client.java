// Package bundle: com.unity3d.ads.network.client (3 classes)

// ============================================================
// CLASS: com.unity3d.ads.network.client.OkHttp3Client
// ============================================================
package com.unity3d.ads.network.client;

public final class OkHttp3Client {
    private final OkHttpClient client;
    private final ISDKDispatchers dispatchers;

    public OkHttp3Client(ISDKDispatchers p0, OkHttpClient p1) {
        new Object();
        dispatchers = p0;
        client = p1;
        return;
    }

    public static final OkHttpClient access$getClient$p(OkHttp3Client p0) {
        return client;
    }

    public static final Object access$makeRequest(OkHttp3Client p0, Request p1, long p2, long p3, Continuation p4) {
        p0.makeRequest(p1, p2, v3, p3, v5, p4);
        return OkHttp3Client.makeRequest(..);
    }

    private final Object makeRequest(Request p0, long p1, long p2, Continuation p3) {
        IntrinsicsKt.intercepted(p3);
        new CancellableContinuationImpl(IntrinsicsKt.intercepted(..), 1);
        new CancellableContinuationImpl(..).initCancellability();
        OkHttp3Client.access$getClient$p(this);
        OkHttp3Client.access$getClient$p(..).newBuilder();
        OkHttpClient.newBuilder(..).connectTimeout(p1, v7, TimeUnit.MILLISECONDS);
        OkHttpClient$Builder.readTimeout(p2, v9, TimeUnit.MILLISECONDS);
        OkHttpClient$Builder.readTimeout(..).build();
        OkHttpClient$Builder.build(..).newCall(p0);
        new OkHttp3Client$makeRequest$2$1(new CancellableContinuationImpl(..));
        OkHttpClient.newCall(..).enqueue(new OkHttp3Client$makeRequest$2$1(..));
        new CancellableContinuationImpl(..).getResult();
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(CancellableContinuationImpl.getResult(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_43;
        DebugProbesKt.probeCoroutineSuspended(p3);
      L_43:
        return CancellableContinuationImpl.getResult(..);
    }

    public Object execute(HttpRequest p0, Continuation p1) {
        dispatchers.getIo();
        new OkHttp3Client$execute$2(p0, this, 0);
        BuildersKt.withContext(ISDKDispatchers.getIo(..), new OkHttp3Client$execute$2(..), p1);
        return BuildersKt.withContext(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.network.client.OkHttp3Client$execute$2
// ============================================================
package com.unity3d.ads.network.client;

final class OkHttp3Client$execute$2 extends SuspendLambda {
    final HttpRequest $request;
    int label;
    final OkHttp3Client this$0;

    OkHttp3Client$execute$2(HttpRequest p0, OkHttp3Client p1, Continuation p2) {
        $request = p0;
        this$0 = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new OkHttp3Client$execute$2($request, this$0, p1);
        return new OkHttp3Client$execute$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        OkHttp3Client$execute$2.invoke(p0, p1);
        return OkHttp3Client$execute$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        OkHttp3Client$execute$2.create(p0, p1);
        OkHttp3Client$execute$2.create(..).invokeSuspend(Unit.INSTANCE);
        return OkHttp3Client$execute$2.invokeSuspend(..);
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
        HttpRequestToOkHttpRequestKt.toOkHttpRequest($request);
        $request.getConnectTimeout();
        $request.getReadTimeout();
        label = 1;
        OkHttp3Client.access$makeRequest(this$0, HttpRequestToOkHttpRequestKt.toOkHttpRequest(..), v5, v6, v7, v8, this);
        if (if-ne(OkHttp3Client.access$makeRequest(..), "call to 'resume' before 'invoke' with coroutine")) goto L_3c;
        return "call to 'resume' before 'invoke' with coroutine";
      L_3c:
        OkHttp3Client.access$makeRequest(..).code();
        OkHttp3Client.access$makeRequest(..).headers();
        Response.headers(..).toMultimap();
        OkHttp3Client.access$makeRequest(..).request();
        Response.request(..).url();
        Request.url(..).toString();
        OkHttp3Client.access$makeRequest(..).body();
        if (if-eqz(Response.body(..))) goto L_61;
        Response.body(..).string();
      L_61:
      L_62:
        if (if-nez(0)) goto L_66;
      L_66:
        new HttpResponse("", Response.code(..), Headers.toMultimap(..), HttpUrl.toString(..));
        return new HttpResponse(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.network.client.OkHttp3Client$makeRequest$2$1
// ============================================================
package com.unity3d.ads.network.client;

public final class OkHttp3Client$makeRequest$2$1 {
    final CancellableContinuation $continuation;

    OkHttp3Client$makeRequest$2$1(CancellableContinuation p0) {
        $continuation = p0;
        new Object();
        return;
    }

    public void onFailure(Call p0, IOException p1) {
        ResultKt.createFailure(p1);
        Result.constructor-impl(ResultKt.createFailure(..));
        $continuation.resumeWith(Result.constructor-impl(..));
        return;
    }

    public void onResponse(Call p0, Response p1) {
        Result.constructor-impl(p1);
        $continuation.resumeWith(Result.constructor-impl(..));
        return;
    }

}

