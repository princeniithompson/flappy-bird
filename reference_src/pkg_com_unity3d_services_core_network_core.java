// Package bundle: com.unity3d.services.core.network.core (19 classes)

// ============================================================
// CLASS: com.unity3d.services.core.network.core.CronetClient
// ============================================================
package com.unity3d.services.core.network.core;

public final class CronetClient {
    public static final CronetClient$Companion Companion = null;
    private static final String MSG_CONNECTION_FAILED = "Network request failed";
    private static final String MSG_CONNECTION_TIMEOUT = "Network request timed out";
    private static final String NETWORK_CLIENT_CRONET = "cronet";
    private final ISDKDispatchers dispatchers;
    private final CronetEngine engine;

    static <clinit>() {
        new CronetClient$Companion(0);
        Companion = new CronetClient$Companion(..);
        return;
    }

    public CronetClient(CronetEngine p0, ISDKDispatchers p1) {
        new Object();
        engine = p0;
        dispatchers = p1;
        return;
    }

    public static final String access$buildUrl(CronetClient p0, HttpRequest p1) {
        p0.buildUrl(p1);
        return CronetClient.buildUrl(..);
    }

    public static final long access$getContentSize(CronetClient p0, UrlResponseInfo p1) {
        p0.getContentSize(p1);
        return CronetClient.getContentSize(..);
    }

    public static final ISDKDispatchers access$getDispatchers$p(CronetClient p0) {
        return dispatchers;
    }

    public static final CronetEngine access$getEngine$p(CronetClient p0) {
        return engine;
    }

    public static final int access$getPriority(CronetClient p0, int p1) {
        p0.getPriority(p1);
        return CronetClient.getPriority(..);
    }

    private final String buildUrl(HttpRequest p0) {
        new StringBuilder();
        p0.getBaseURL();
        StringsKt.trim(HttpRequest.getBaseURL(..), v3);
        new StringBuilder(..).append(StringsKt.trim(..));
        new StringBuilder(..).append(47);
        p0.getPath();
        StringsKt.trim(HttpRequest.getPath(..), StringsKt.trim(..));
        new StringBuilder(..).append(StringsKt.trim(..));
        new StringBuilder(..).toString();
        StringsKt.removeSuffix(StringBuilder.toString(..), "/");
        return StringsKt.removeSuffix(..);
    }

    private final long getContentSize(UrlResponseInfo p0) {
        p0.getAllHeaders();
        UrlResponseInfo.getAllHeaders(..).get("Content-Length");
        if (if-eqz(Map.get(..))) goto L_22;
        Map.get(..).get(0);
        if (if-eqz(List.get(..))) goto L_22;
        StringsKt.toLongOrNull(List.get(..));
        if (if-eqz(StringsKt.toLongOrNull(..))) goto L_22;
        StringsKt.toLongOrNull(..).longValue();
      L_22:
      L_24:
        return -1L;
    }

    private final int getPriority(int p0) {
        if (if-eqz(p0)) goto L_d;
        if (if-eq(p0, 1)) goto L_b;
        if (if-eq(p0, 2)) goto L_9;
      L_9:
      L_b:
      L_d:
      L_e:
        return 4;
    }

    public Object execute(HttpRequest p0, Continuation p1) {
        IntrinsicsKt.intercepted(p1);
        new CancellableContinuationImpl(IntrinsicsKt.intercepted(..), 1);
        new CancellableContinuationImpl(..).initCancellability();
        CronetClient.access$getDispatchers$p(this);
        p0.getReadTimeout();
        p0.getDownloadDestination();
        new CronetClient$execute$2$callback$1(new CancellableContinuationImpl(..), this, CronetClient.access$getDispatchers$p(..), v7, v8, HttpRequest.getDownloadDestination(..));
        CronetClient.access$getEngine$p(this);
        CronetClient.access$buildUrl(this, p0);
        CronetClient.access$getDispatchers$p(this);
        ISDKDispatchers.getIo();
        ExecutorsKt.asExecutor(ISDKDispatchers.getIo(..));
        CronetClient.access$getEngine$p(..).newUrlRequestBuilder(CronetClient.access$buildUrl(..), new CronetClient$execute$2$callback$1, ExecutorsKt.asExecutor(..));
        p0.getHeaders();
        HttpRequest.getHeaders(..).entrySet();
        Map.entrySet(..).iterator();
      L_4c:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_7a;
        Set.iterator(..).next();
        Iterator.next(..).getKey();
        Iterator.next(..).getValue();
        Map$Entry.getValue(..).iterator();
      L_6a:
        Iterable.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_4c;
        Iterable.iterator(..).next();
        UrlRequest$Builder.addHeader(Map$Entry.getKey(..), Iterator.next(..));
      L_7a:
        p0.getMethod();
        if (if-ne(HttpRequest.getMethod(..), RequestType.POST)) goto L_bd;
        p0.getBody();
        if (if-eqz(RequestType.POST)) goto L_91;
        p0.getBody();
      L_91:
        if (if-eqz(HttpRequest.getBody(..))) goto L_a7;
        p0.getBody();
        HttpRequest.getBody(..).getBytes(Charsets.ISO_8859_1);
      L_a7:
      L_aa:
        UploadDataProviders.create(0);
        CronetClient.access$getDispatchers$p(this);
        ISDKDispatchers.getIo();
        ExecutorsKt.asExecutor(ISDKDispatchers.getIo(..));
        UrlRequest$Builder.setUploadDataProvider(UploadDataProviders.create(..), ExecutorsKt.asExecutor(..));
      L_bd:
        p0.getMethod();
        HttpRequest.getMethod(..).toString();
        UrlRequest$Builder.setHttpMethod(RequestType.toString(..));
        p0.getPriority();
        CronetClient.access$getPriority(this, HttpRequest.getPriority(..));
        UrlRequest$Builder.setHttpMethod(..).setPriority(CronetClient.access$getPriority(..));
        UrlRequest$Builder.setPriority(..).build();
        new CronetClient$execute$2$2(UrlRequest$Builder.build(..));
        new CancellableContinuationImpl(..).invokeOnCancellation(new CronetClient$execute$2$2(..));
        CronetClient$execute$2$callback$1.startTimer(UrlRequest$Builder.build(..));
        UrlRequest$Builder.build(..).start();
        new CancellableContinuationImpl(..).getResult();
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(CancellableContinuationImpl.getResult(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_fb;
        DebugProbesKt.probeCoroutineSuspended(p1);
      L_fb:
        return CancellableContinuationImpl.getResult(..);
    }

    public HttpResponse executeBlocking(HttpRequest p0) {
        dispatchers.getIo();
        new CronetClient$executeBlocking$1(this, p0, 0);
        BuildersKt.runBlocking(ISDKDispatchers.getIo(..), new CronetClient$executeBlocking$1(..));
        return BuildersKt.runBlocking(..);
    }

    public final void shutdown() {
        engine.shutdown();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.CronetEngineBuilderFactory
// ============================================================
package com.unity3d.services.core.network.core;

public final class CronetEngineBuilderFactory {
    public CronetEngineBuilderFactory() {
        new Object();
        return;
    }

    public final CronetEngine$Builder createCronetEngineBuilder(Context p0) {
        new CronetEngine$Builder(p0);
        return new CronetEngine$Builder(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.HttpClient
// ============================================================
package com.unity3d.services.core.network.core;

public abstract class HttpClient {
    public abstract Object execute(HttpRequest p0, Continuation p1) {
        // native or abstract
    }

    public abstract HttpResponse executeBlocking(HttpRequest p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.LegacyHttpClient
// ============================================================
package com.unity3d.services.core.network.core;

public final class LegacyHttpClient {
    public static final LegacyHttpClient$Companion Companion = null;
    private static final String NETWORK_CLIENT_LEGACY = "legacy";
    private final ISDKDispatchers dispatchers;

    static <clinit>() {
        new LegacyHttpClient$Companion(0);
        Companion = new LegacyHttpClient$Companion(..);
        return;
    }

    public LegacyHttpClient(ISDKDispatchers p0) {
        new Object();
        dispatchers = p0;
        return;
    }

    public Object execute(HttpRequest p0, Continuation p1) {
        dispatchers.getIo();
        new LegacyHttpClient$execute$2(p0, 0);
        BuildersKt.withContext(ISDKDispatchers.getIo(..), new LegacyHttpClient$execute$2(..), p1);
        return BuildersKt.withContext(..);
    }

    public HttpResponse executeBlocking(HttpRequest p0) {
        dispatchers.getIo();
        new LegacyHttpClient$executeBlocking$1(this, p0, 0);
        BuildersKt.runBlocking(ISDKDispatchers.getIo(..), new LegacyHttpClient$executeBlocking$1(..));
        return BuildersKt.runBlocking(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.OkHttp3Client
// ============================================================
package com.unity3d.services.core.network.core;

public final class OkHttp3Client {
    public static final OkHttp3Client$Companion Companion = null;
    public static final String MSG_CONNECTION_FAILED = "Network request failed";
    public static final String MSG_CONNECTION_TIMEOUT = "Network request timeout";
    public static final String NETWORK_CLIENT_OKHTTP = "okhttp";
    private final OkHttpClient client;
    private final ISDKDispatchers dispatchers;

    static <clinit>() {
        new OkHttp3Client$Companion(0);
        Companion = new OkHttp3Client$Companion(..);
        return;
    }

    public OkHttp3Client(ISDKDispatchers p0, OkHttpClient p1) {
        new Object();
        dispatchers = p0;
        client = p1;
        return;
    }

    public static final OkHttpClient access$getClient$p(OkHttp3Client p0) {
        return client;
    }

    public static final Object access$makeRequest(OkHttp3Client p0, HttpRequest p1, long p2, long p3, long p4, Continuation p5) {
        p0.makeRequest(p1, p2, v3, p3, v5, p4, v7, p5);
        return OkHttp3Client.makeRequest(..);
    }

    private final Object makeRequest(HttpRequest p0, long p1, long p2, long p3, Continuation p4) {
        IntrinsicsKt.intercepted(p4);
        new CancellableContinuationImpl(IntrinsicsKt.intercepted(..), 1);
        new CancellableContinuationImpl(..).initCancellability();
        p0.isProtobuf();
        if (if-eqz(HttpRequest.isProtobuf(..))) goto L_1b;
        HttpRequestToOkHttpRequestKt.toOkHttpProtoRequest(p0);
      L_1b:
        HttpRequestToOkHttpRequestKt.toOkHttpRequest(p0);
      L_1f:
        OkHttp3Client.access$getClient$p(this);
        OkHttp3Client.access$getClient$p(..).newBuilder();
        OkHttpClient.newBuilder(..).connectTimeout(p1, v8, TimeUnit.MILLISECONDS);
        OkHttpClient$Builder.readTimeout(p2, v10, TimeUnit.MILLISECONDS);
        OkHttpClient$Builder.readTimeout(..).writeTimeout(p3, v12, TimeUnit.MILLISECONDS);
        OkHttpClient$Builder.build();
        OkHttpClient$Builder.build(..).newCall(HttpRequestToOkHttpRequestKt.toOkHttpRequest(..));
        new OkHttp3Client$makeRequest$2$1(p0, new CancellableContinuationImpl(..));
        OkHttpClient.newCall(..).enqueue(new OkHttp3Client$makeRequest$2$1(..));
        new CancellableContinuationImpl(..).getResult();
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(CancellableContinuationImpl.getResult(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_58;
        DebugProbesKt.probeCoroutineSuspended(p4);
      L_58:
        return CancellableContinuationImpl.getResult(..);
    }

    public Object execute(HttpRequest p0, Continuation p1) {
        dispatchers.getIo();
        new OkHttp3Client$execute$2(this, p0, 0);
        BuildersKt.withContext(ISDKDispatchers.getIo(..), new OkHttp3Client$execute$2(..), p1);
        return BuildersKt.withContext(..);
    }

    public HttpResponse executeBlocking(HttpRequest p0) {
        dispatchers.getIo();
        new OkHttp3Client$executeBlocking$1(this, p0, 0);
        BuildersKt.runBlocking(ISDKDispatchers.getIo(..), new OkHttp3Client$executeBlocking$1(..));
        return BuildersKt.runBlocking(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.UnityAdsUrlRequestCallback
// ============================================================
package com.unity3d.services.core.network.core;

public abstract class UnityAdsUrlRequestCallback extends UrlRequest$Callback {
    private static final int BYTE_BUFFER_CAPACITY_BYTES = 16384;
    public static final UnityAdsUrlRequestCallback$Companion Companion;
    private final ByteArrayOutputStream bytesReceived;
    private final ISDKDispatchers dispatchers;
    private final File file;
    private final long readTimeout;
    private final WritableByteChannel receiveChannel;
    private BufferedSink sink;
    private Job task;

    static <clinit>() {
        new UnityAdsUrlRequestCallback$Companion(0);
        Companion = new UnityAdsUrlRequestCallback$Companion(..);
        return;
    }

    public UnityAdsUrlRequestCallback(ISDKDispatchers p0, long p1, File p2) {
        new UrlRequest$Callback();
        dispatchers = p0;
        readTimeout = p1;
        file = p2;
        new ByteArrayOutputStream();
        bytesReceived = new ByteArrayOutputStream(..);
        Channels.newChannel(new ByteArrayOutputStream(..));
        receiveChannel = Channels.newChannel(..);
        return;
    }

    private final void cancelTimer() {
        if (if-eqz(task)) goto L_9;
        Job$DefaultImpls.cancel$default(task, 0, 1, 0);
      L_9:
        task = 0;
        return;
    }

    public final File getFile() {
        return file;
    }

    public final long getReadTimeout() {
        return readTimeout;
    }

    public void onCanceled(UrlRequest p0, UrlResponseInfo p1) {
        UrlRequest$Callback.onCanceled(p0, p1);
        UnityAdsUrlRequestCallback.cancelTimer();
        return;
    }

    public void onFailed(UrlRequest p0, UrlResponseInfo p1, CronetException p2) {
        UnityAdsUrlRequestCallback.cancelTimer();
        return;
    }

    public final void onReadCompleted(UrlRequest p0, UrlResponseInfo p1, ByteBuffer p2) {
        UnityAdsUrlRequestCallback.cancelTimer();
        p2.flip();
        if (if-eqz(file)) goto L_22;
        file.exists();
        if (if-ne(File.exists(..), 1)) goto L_22;
      L_22:
        if (if-eqz(1)) goto L_32;
        if (if-nez(sink)) goto L_2e;
        Intrinsics.throwUninitializedPropertyAccessException("sink");
      L_2e:
        0.write(p2);
      L_32:
        receiveChannel.write(p2);
      L_37:
        p2.clear();
        UnityAdsUrlRequestCallback.startTimer(p0);
        p0.read(p2);
        return;
    }

    public void onRedirectReceived(UrlRequest p0, UrlResponseInfo p1, String p2) {
        p0.followRedirect();
        return;
    }

    public final void onResponseStarted(UrlRequest p0, UrlResponseInfo p1) {
        if (if-eqz(file)) goto L_17;
        file.exists();
        if (if-ne(File.exists(..), 1)) goto L_17;
      L_17:
        if (if-eqz(1)) goto L_2a;
        Okio.sink(file);
        Okio.buffer(Okio.sink(..));
        sink = Okio.buffer(..);
      L_2a:
        UnityAdsUrlRequestCallback.startTimer(p0);
        ByteBuffer.allocateDirect(16384);
        p0.read(ByteBuffer.allocateDirect(..));
        return;
    }

    public final void onSucceeded(UrlRequest p0, UrlResponseInfo p1) {
        UnityAdsUrlRequestCallback.cancelTimer();
        bytesReceived.toByteArray();
        if (if-eqz(file)) goto L_2a;
        file.exists();
        if (if-eqz(File.exists(..))) goto L_2a;
        if (if-nez(sink)) goto L_27;
        Intrinsics.throwUninitializedPropertyAccessException("sink");
      L_27:
        0.close();
      L_2a:
        UnityAdsUrlRequestCallback.onSucceeded(p0, p1, ByteArrayOutputStream.toByteArray(..));
        return;
    }

    public abstract void onSucceeded(UrlRequest p0, UrlResponseInfo p1, byte[] p2) {
        // native or abstract
    }

    public final void startTimer(UrlRequest p0) {
        UnityAdsUrlRequestCallback.cancelTimer();
        dispatchers.getIo();
        CoroutineScopeKt.CoroutineScope(ISDKDispatchers.getIo(..));
        new UnityAdsUrlRequestCallback$startTimer$1(this, p0, 0);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(..), 0, 0, new UnityAdsUrlRequestCallback$startTimer$1(..), 3, 0);
        task = BuildersKt.launch$default(..);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.CronetClient$Companion
// ============================================================
package com.unity3d.services.core.network.core;

public final class CronetClient$Companion {
    private CronetClient$Companion() {
        new Object();
        return;
    }

    public CronetClient$Companion(DefaultConstructorMarker p0) {
        new CronetClient$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.CronetClient$execute$2$2
// ============================================================
package com.unity3d.services.core.network.core;

final class CronetClient$execute$2$2 extends Lambda {
    final UrlRequest $req;

    CronetClient$execute$2$2(UrlRequest p0) {
        $req = p0;
        new Lambda(1);
        return;
    }

    public Object invoke(Object p0) {
        CronetClient$execute$2$2.invoke(p0);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable p0) {
        $req.cancel();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.CronetClient$execute$2$callback$1
// ============================================================
package com.unity3d.services.core.network.core;

public final class CronetClient$execute$2$callback$1 extends UnityAdsUrlRequestCallback {
    final CancellableContinuation $cont;
    final CronetClient this$0;

    CronetClient$execute$2$callback$1(CancellableContinuation p0, CronetClient p1, ISDKDispatchers p2, long p3, File p4) {
        $cont = p0;
        this$0 = p1;
        new UnityAdsUrlRequestCallback(p2, p3, v5, p4);
        return;
    }

    public void onCanceled(UrlRequest p0, UrlResponseInfo p1) {
        UnityAdsUrlRequestCallback.onCanceled(p0, p1);
        if (if-eqz(p1)) goto L_11;
        p1.getUrl();
      L_11:
      L_12:
        if (if-eqz(p1)) goto L_1a;
        p1.getNegotiatedProtocol();
      L_1a:
      L_1b:
        new UnityAdsNetworkException("Network request timed out", 0, 0, 0, 0, 0, "cronet", 38, 0);
        ResultKt.createFailure(new UnityAdsNetworkException);
        Result.constructor-impl(ResultKt.createFailure(..));
        $cont.resumeWith(Result.constructor-impl(..));
        return;
    }

    public void onFailed(UrlRequest p0, UrlResponseInfo p1, CronetException p2) {
        UnityAdsUrlRequestCallback.onFailed(p0, p1, p2);
        if (if-eqz(p0)) goto L_b;
      L_b:
      L_c:
        if (if-eqz(0)) goto L_18;
        0.getCronetInternalErrorCode();
        Integer.valueOf(NetworkException.getCronetInternalErrorCode(..));
      L_18:
      L_19:
        if (if-eqz(p1)) goto L_2a;
        p1.getHttpStatusCode();
        Integer.valueOf(UrlResponseInfo.getHttpStatusCode(..));
      L_2a:
      L_2b:
        if (if-eqz(p1)) goto L_33;
        p1.getUrl();
      L_33:
      L_34:
        if (if-eqz(p1)) goto L_3a;
        p1.getNegotiatedProtocol();
      L_3a:
        new UnityAdsNetworkException("Network request failed", 0, 0, 0, UrlResponseInfo.getNegotiatedProtocol(..), 0, "cronet", 2, 0);
        ResultKt.createFailure(new UnityAdsNetworkException);
        Result.constructor-impl(ResultKt.createFailure(..));
        $cont.resumeWith(Result.constructor-impl(..));
        return;
    }

    public void onSucceeded(UrlRequest p0, UrlResponseInfo p1, byte[] p2) {
        p1.getHttpStatusCode();
        p1.getAllHeaders();
        p1.getUrl();
        p1.getNegotiatedProtocol();
        CronetClient.access$getContentSize(this$0, p1);
        new HttpResponse(p2, UrlResponseInfo.getHttpStatusCode(..), UrlResponseInfo.getAllHeaders(..), UrlResponseInfo.getUrl(..), UrlResponseInfo.getNegotiatedProtocol(..), "cronet", CronetClient.access$getContentSize(..), v8);
        Result.constructor-impl(new HttpResponse);
        $cont.resumeWith(Result.constructor-impl(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.CronetClient$executeBlocking$1
// ============================================================
package com.unity3d.services.core.network.core;

final class CronetClient$executeBlocking$1 extends SuspendLambda {
    final HttpRequest $request;
    int label;
    final CronetClient this$0;

    CronetClient$executeBlocking$1(CronetClient p0, HttpRequest p1, Continuation p2) {
        this$0 = p0;
        $request = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new CronetClient$executeBlocking$1(this$0, $request, p1);
        return new CronetClient$executeBlocking$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        CronetClient$executeBlocking$1.invoke(p0, p1);
        return CronetClient$executeBlocking$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        CronetClient$executeBlocking$1.create(p0, p1);
        CronetClient$executeBlocking$1.invokeSuspend(Unit.INSTANCE);
        return CronetClient$executeBlocking$1.invokeSuspend(..);
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
        this$0.execute($request, this);
        if (if-ne(CronetClient.execute(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2a;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2a:
        return CronetClient.execute(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.LegacyHttpClient$Companion
// ============================================================
package com.unity3d.services.core.network.core;

public final class LegacyHttpClient$Companion {
    private LegacyHttpClient$Companion() {
        new Object();
        return;
    }

    public LegacyHttpClient$Companion(DefaultConstructorMarker p0) {
        new LegacyHttpClient$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.LegacyHttpClient$execute$2
// ============================================================
package com.unity3d.services.core.network.core;

final class LegacyHttpClient$execute$2 extends SuspendLambda {
    final HttpRequest $request;
    int label;

    LegacyHttpClient$execute$2(HttpRequest p0, Continuation p1) {
        $request = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new LegacyHttpClient$execute$2($request, p1);
        return new LegacyHttpClient$execute$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        LegacyHttpClient$execute$2.invoke(p0, p1);
        return LegacyHttpClient$execute$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        LegacyHttpClient$execute$2.create(p0, p1);
        LegacyHttpClient$execute$2.invokeSuspend(Unit.INSTANCE);
        return LegacyHttpClient$execute$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_42;
        ResultKt.throwOnFailure(p0);
        HttpRequestToWebRequestKt.toWebRequest($request);
        WebRequest.makeRequest();
        WebRequest.getResponseCode();
        WebRequest.getHeaders();
        WebRequest.getUrl();
        WebRequest.getUrl(..).toString();
        if (if-nez(WebRequest.makeRequest(..))) goto L_28;
      L_28:
        new HttpResponse("", WebRequest.getResponseCode(..), WebRequest.getHeaders(..), URL.toString(..), 0, "legacy", 0L, v9, 80, 0);
        return new HttpResponse;
      L_42:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.LegacyHttpClient$executeBlocking$1
// ============================================================
package com.unity3d.services.core.network.core;

final class LegacyHttpClient$executeBlocking$1 extends SuspendLambda {
    final HttpRequest $request;
    int label;
    final LegacyHttpClient this$0;

    LegacyHttpClient$executeBlocking$1(LegacyHttpClient p0, HttpRequest p1, Continuation p2) {
        this$0 = p0;
        $request = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new LegacyHttpClient$executeBlocking$1(this$0, $request, p1);
        return new LegacyHttpClient$executeBlocking$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        LegacyHttpClient$executeBlocking$1.invoke(p0, p1);
        return LegacyHttpClient$executeBlocking$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        LegacyHttpClient$executeBlocking$1.create(p0, p1);
        LegacyHttpClient$executeBlocking$1.invokeSuspend(Unit.INSTANCE);
        return LegacyHttpClient$executeBlocking$1.invokeSuspend(..);
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
        this$0.execute($request, this);
        if (if-ne(LegacyHttpClient.execute(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2a;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2a:
        return LegacyHttpClient.execute(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.OkHttp3Client$Companion
// ============================================================
package com.unity3d.services.core.network.core;

public final class OkHttp3Client$Companion {
    private OkHttp3Client$Companion() {
        new Object();
        return;
    }

    public OkHttp3Client$Companion(DefaultConstructorMarker p0) {
        new OkHttp3Client$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.OkHttp3Client$execute$2
// ============================================================
package com.unity3d.services.core.network.core;

final class OkHttp3Client$execute$2 extends SuspendLambda {
    final HttpRequest $request;
    int label;
    final OkHttp3Client this$0;

    OkHttp3Client$execute$2(OkHttp3Client p0, HttpRequest p1, Continuation p2) {
        this$0 = p0;
        $request = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new OkHttp3Client$execute$2(this$0, $request, p1);
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
        if (if-eqz(label)) goto L_1d;
        if (if-ne(label, 1)) goto L_15;
        ResultKt.throwOnFailure(p0);
      L_15:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1d:
        ResultKt.throwOnFailure(p0);
        $request.getConnectTimeout();
        $request.getReadTimeout();
        $request.getWriteTimeout();
        label = 1;
        OkHttp3Client.access$makeRequest(this$0, $request, v7, v8, v9, v10, v11, v12, this);
        if (if-ne(OkHttp3Client.access$makeRequest(..), "call to 'resume' before 'invoke' with coroutine")) goto L_43;
        return "call to 'resume' before 'invoke' with coroutine";
      L_43:
        $request.getDownloadDestination();
        if (if-eqz(HttpRequest.getDownloadDestination(..))) goto L_4e;
      L_4e:
      L_4f:
        $request.isProtobuf();
        if (if-eqz(HttpRequest.isProtobuf(..))) goto L_65;
        OkHttp3Client.access$makeRequest(..).body();
        if (if-eqz(Response.body(..))) goto L_62;
        Response.body(..).bytes();
      L_62:
      L_65:
        OkHttp3Client.access$makeRequest(..).body();
        if (if-eqz(Response.body(..))) goto L_62;
        Response.body(..).string();
      L_70:
        OkHttp3Client.access$makeRequest(..).code();
        OkHttp3Client.access$makeRequest(..).headers();
        Response.headers(..).toMultimap();
        OkHttp3Client.access$makeRequest(..).request();
        Response.request(..).url();
        Request.url(..).toString();
        if (if-nez(ResponseBody.string(..))) goto L_8f;
      L_8f:
        OkHttp3Client.access$makeRequest(..).protocol();
        Response.protocol(..).toString();
        new HttpResponse("", Response.code(..), Headers.toMultimap(..), HttpUrl.toString(..), Protocol.toString(..), "okhttp", 0L, this, 64, 0);
        return new HttpResponse;
        $request.getBaseURL();
        new UnityAdsNetworkException("Network request failed", 0, 0, HttpRequest.getBaseURL(..), 0, 0, "okhttp", 54, 0);
        throw new UnityAdsNetworkException;
        $request.getBaseURL();
        new UnityAdsNetworkException("Network request timeout", 0, 0, HttpRequest.getBaseURL(..), 0, 0, "okhttp", 54, 0);
        throw new UnityAdsNetworkException;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.OkHttp3Client$executeBlocking$1
// ============================================================
package com.unity3d.services.core.network.core;

final class OkHttp3Client$executeBlocking$1 extends SuspendLambda {
    final HttpRequest $request;
    int label;
    final OkHttp3Client this$0;

    OkHttp3Client$executeBlocking$1(OkHttp3Client p0, HttpRequest p1, Continuation p2) {
        this$0 = p0;
        $request = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new OkHttp3Client$executeBlocking$1(this$0, $request, p1);
        return new OkHttp3Client$executeBlocking$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        OkHttp3Client$executeBlocking$1.invoke(p0, p1);
        return OkHttp3Client$executeBlocking$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        OkHttp3Client$executeBlocking$1.create(p0, p1);
        OkHttp3Client$executeBlocking$1.invokeSuspend(Unit.INSTANCE);
        return OkHttp3Client$executeBlocking$1.invokeSuspend(..);
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
        this$0.execute($request, this);
        if (if-ne(OkHttp3Client.execute(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2a;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2a:
        return OkHttp3Client.execute(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1
// ============================================================
package com.unity3d.services.core.network.core;

public final class OkHttp3Client$makeRequest$2$1 {
    final CancellableContinuation $continuation;
    final HttpRequest $request;

    OkHttp3Client$makeRequest$2$1(HttpRequest p0, CancellableContinuation p1) {
        $request = p0;
        $continuation = p1;
        new Object();
        return;
    }

    public void onFailure(Call p0, IOException p1) {
        p0.request();
        Call.request(..).url();
        Request.url(..).toString();
        new UnityAdsNetworkException("Network request failed", 0, 0, HttpUrl.toString(..), 0, 0, "okhttp", 54, 0);
        ResultKt.createFailure(new UnityAdsNetworkException);
        Result.constructor-impl(ResultKt.createFailure(..));
        $continuation.resumeWith(Result.constructor-impl(..));
        return;
    }

    public void onResponse(Call p0, Response p1) {
        $request.getDownloadDestination();
        if (if-eqz(HttpRequest.getDownloadDestination(..))) goto L_1b;
        File.exists();
        if (if-ne(File.exists(..), 1)) goto L_1b;
      L_1b:
        if (if-eqz(1)) goto L_61;
        Okio.sink(HttpRequest.getDownloadDestination(..));
        Okio.buffer(Okio.sink(..));
        p1.body();
        if (if-eqz(Response.body(..))) goto L_56;
        Response.body(..).source();
        if (if-eqz(ResponseBody.source(..))) goto L_56;
        Okio.buffer(..).writeAll(ResponseBody.source(..));
        CloseableKt.closeFinally(ResponseBody.source(..), 0);
        Long.valueOf(BufferedSink.writeAll(..), v4);
        throw Okio.buffer(..);
        CloseableKt.closeFinally(ResponseBody.source(..), Okio.buffer(..));
        throw p1;
      L_56:
        CloseableKt.closeFinally(Okio.buffer(..), 0);
        throw Okio.buffer(..);
        CloseableKt.closeFinally(Okio.buffer(..), Okio.buffer(..));
        throw p1;
      L_61:
        Result.constructor-impl(p1);
        $continuation.resumeWith(Result.constructor-impl(..));
        ResultKt.createFailure($continuation);
        Result.constructor-impl(ResultKt.createFailure(..));
        $continuation.resumeWith(Result.constructor-impl(..));
      L_83:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.UnityAdsUrlRequestCallback$Companion
// ============================================================
package com.unity3d.services.core.network.core;

public final class UnityAdsUrlRequestCallback$Companion {
    private UnityAdsUrlRequestCallback$Companion() {
        new Object();
        return;
    }

    public UnityAdsUrlRequestCallback$Companion(DefaultConstructorMarker p0) {
        new UnityAdsUrlRequestCallback$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.core.UnityAdsUrlRequestCallback$startTimer$1
// ============================================================
package com.unity3d.services.core.network.core;

final class UnityAdsUrlRequestCallback$startTimer$1 extends SuspendLambda {
    final UrlRequest $request;
    int label;
    final UnityAdsUrlRequestCallback this$0;

    UnityAdsUrlRequestCallback$startTimer$1(UnityAdsUrlRequestCallback p0, UrlRequest p1, Continuation p2) {
        this$0 = p0;
        $request = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new UnityAdsUrlRequestCallback$startTimer$1(this$0, $request, p1);
        return new UnityAdsUrlRequestCallback$startTimer$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        UnityAdsUrlRequestCallback$startTimer$1.invoke(p0, p1);
        return UnityAdsUrlRequestCallback$startTimer$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        UnityAdsUrlRequestCallback$startTimer$1.create(p0, p1);
        UnityAdsUrlRequestCallback$startTimer$1.invokeSuspend(Unit.INSTANCE);
        return UnityAdsUrlRequestCallback$startTimer$1.invokeSuspend(..);
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
        this$0.getReadTimeout();
        label = 1;
        DelayKt.delay(UnityAdsUrlRequestCallback.getReadTimeout(..), v4, this);
        if (if-ne(DelayKt.delay(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2c;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2c:
        $request.cancel();
        return Unit.INSTANCE;
    }

}

