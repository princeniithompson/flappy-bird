// Package bundle: com.unity3d.ads.core.domain.work (14 classes)

// ============================================================
// CLASS: com.unity3d.ads.core.domain.work.BackgroundWorker
// ============================================================
package com.unity3d.ads.core.domain.work;

public final class BackgroundWorker {
    private final WorkManager workManager;

    public BackgroundWorker(Context p0) {
        new Object();
        WorkManager.getInstance(p0);
        workManager = WorkManager.getInstance(..);
        return;
    }

    public final WorkManager getWorkManager() {
        return workManager;
    }

    public final void invoke(UniversalRequestWorkerData p0) {
        new Constraints$Builder();
        new Constraints$Builder(..).setRequiredNetworkType(NetworkType.CONNECTED);
        Constraints$Builder.build();
        Intrinsics.reifiedOperationMarker(4, "T");
        new OneTimeWorkRequest$Builder(ListenableWorker.class);
        new OneTimeWorkRequest$Builder(..).setConstraints(Constraints$Builder.build(..));
        p0.invoke();
        OneTimeWorkRequest$Builder.setInputData(UniversalRequestWorkerData.invoke(..));
        OneTimeWorkRequest$Builder.build();
        BackgroundWorker.getWorkManager();
        BackgroundWorker.getWorkManager(..).enqueue(OneTimeWorkRequest$Builder.build(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.work.DiagnosticEventJob
// ============================================================
package com.unity3d.ads.core.domain.work;

public final class DiagnosticEventJob extends UniversalRequestJob {
    private final Lazy diagnosticEventRequestWorkModifier$delegate;
    private final Lazy getDiagnosticRequestPolicy$delegate;

    public DiagnosticEventJob(Context p0, WorkerParameters p1) {
        new UniversalRequestJob(p0, p1);
        new DiagnosticEventJob$special$$inlined$inject$default$1(new UniversalRequestJob(..), "other_req");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new DiagnosticEventJob$special$$inlined$inject$default$1(..));
        getDiagnosticRequestPolicy$delegate = LazyKt.lazy(..);
        new DiagnosticEventJob$special$$inlined$inject$default$2(new UniversalRequestJob(..), "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new DiagnosticEventJob$special$$inlined$inject$default$2(..));
        diagnosticEventRequestWorkModifier$delegate = LazyKt.lazy(..);
        return;
    }

    private final DiagnosticEventRequestWorkModifier getDiagnosticEventRequestWorkModifier() {
        Lazy.getValue();
        return Lazy.getValue(..);
    }

    private final GetRequestPolicy getGetDiagnosticRequestPolicy() {
        getDiagnosticRequestPolicy$delegate.getValue();
        return Lazy.getValue(..);
    }

    public Object doWork(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new DiagnosticEventJob$doWork$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_4e;
        if (if-eq(label, 1)) goto L_42;
        if (if-eq(label, 2)) goto L_3a;
        if (if-ne(label, 3)) goto L_32;
        ResultKt.throwOnFailure(result);
      L_32:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_3a:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_42:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_4e:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        DiagnosticEventJob.getWorkerParams();
        WorkerParameters.getInputData();
        WorkerParameters.getInputData(..).getString("universalRequestId");
        if (if-nez(Data.getString(..))) goto L_6b;
        ListenableWorker$Result.success();
        return ListenableWorker$Result.success(..);
      L_6b:
        DiagnosticEventJob.getUniversalRequestDataSource();
        L$0 = this;
        L$1 = Data.getString(..);
        label = L$0;
        UniversalRequestDataSource.get("success()");
        if (if-ne(UniversalRequestDataSource.get(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_7c;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_7c:
      L_7d:
        UniversalRequestDataSource.get(..).getUniversalRequestMapOrThrow(Data.getString(..));
        UniversalRequestOuterClass$UniversalRequest.parseFrom(UniversalRequestStoreOuterClass$UniversalRequestStore.getUniversalRequestMapOrThrow(..));
        DiagnosticEventJob.getDiagnosticEventRequestWorkModifier();
        DiagnosticEventRequestWorkModifier.invoke(UniversalRequestOuterClass$UniversalRequest.parseFrom(..));
        DiagnosticEventJob.getUniversalRequestDataSource();
        UniversalRequestOuterClass$UniversalRequest.toByteString();
        L$0 = this;
        L$1 = 0;
        label = 2;
        UniversalRequestDataSource.set(Data.getString(..), UniversalRequestOuterClass$UniversalRequest.toByteString(..), "success()");
        if (if-ne(UniversalRequestDataSource.set(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_ae;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_ae:
      L_af:
        DiagnosticEventJob.getGetDiagnosticRequestPolicy();
        GetRequestPolicy.invoke();
        DiagnosticEventJob.setRequestPolicy(GetRequestPolicy.invoke(..));
        L$0 = 0;
        label = 3;
        UniversalRequestJob.doWork("success()");
        if (if-ne(UniversalRequestJob.doWork(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_c5;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_c5:
        return UniversalRequestJob.doWork(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.work.DiagnosticEventRequestWorkModifier
// ============================================================
package com.unity3d.ads.core.domain.work;

public final class DiagnosticEventRequestWorkModifier {
    private final LifecycleDataSource lifecycleDataSource;
    private final SessionRepository sessionRepository;

    public DiagnosticEventRequestWorkModifier(SessionRepository p0, LifecycleDataSource p1) {
        new Object();
        sessionRepository = p0;
        lifecycleDataSource = p1;
        return;
    }

    public final UniversalRequestOuterClass$UniversalRequest invoke(UniversalRequestOuterClass$UniversalRequest p0) {
        p0.toBuilder();
        UniversalRequestKt$Dsl.Companion._create(UniversalRequestOuterClass$UniversalRequest.toBuilder(..));
        UniversalRequestKt$Dsl.getPayload();
        UniversalRequestOuterClass$UniversalRequest$Payload.toBuilder();
        UniversalRequestKt$PayloadKt$Dsl$Companion._create(UniversalRequestOuterClass$UniversalRequest$Payload.toBuilder(..));
        UniversalRequestKt$PayloadKt$Dsl.getDiagnosticEventRequest();
        DiagnosticEventRequestOuterClass$DiagnosticEventRequest.toBuilder();
        DiagnosticEventRequestKt$Dsl$Companion._create(DiagnosticEventRequestOuterClass$DiagnosticEventRequest.toBuilder(..));
        DiagnosticEventRequestKt$Dsl.getBatch();
        CollectionsKt.collectionSizeOrDefault(DiagnosticEventRequestKt$Dsl.getBatch(..), 10);
        new ArrayList(CollectionsKt.collectionSizeOrDefault(..));
        Iterable.iterator();
      L_53:
        Iterable.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_a8;
        Iterable.iterator(..).next();
        Iterator.next(..).toBuilder();
        DiagnosticEventKt$Dsl.Companion._create(DiagnosticEventRequestOuterClass$DiagnosticEvent.toBuilder(..));
        DiagnosticEventKt$Dsl.getStringTagsMap();
        p0.getSharedData();
        UniversalRequestOuterClass$UniversalRequest$SharedData.getSessionToken();
        sessionRepository.getSessionToken();
        Intrinsics.areEqual(UniversalRequestOuterClass$UniversalRequest$SharedData.getSessionToken(..), SessionRepository.getSessionToken(..));
        String.valueOf(Intrinsics.areEqual(..));
        DiagnosticEventKt$Dsl.putStringTags(DiagnosticEventKt$Dsl.getStringTagsMap(..), "same_session", String.valueOf(..));
        DiagnosticEventKt$Dsl.getStringTagsMap();
        lifecycleDataSource.appIsForeground();
        String.valueOf(LifecycleDataSource.appIsForeground(..));
        DiagnosticEventKt$Dsl.putStringTags(DiagnosticEventKt$Dsl.getStringTagsMap(..), "app_active", String.valueOf(..));
        DiagnosticEventKt$Dsl._build();
        new ArrayList(..).add(DiagnosticEventKt$Dsl._build(..));
      L_a8:
        DiagnosticEventRequestKt$Dsl.getBatch();
        DiagnosticEventRequestKt$Dsl.clearBatch(DiagnosticEventRequestKt$Dsl.getBatch(..));
        DiagnosticEventRequestKt$Dsl.getBatch();
        DiagnosticEventRequestKt$Dsl.addAllBatch(DiagnosticEventRequestKt$Dsl.getBatch(..), new ArrayList(..));
        DiagnosticEventRequestKt$Dsl._build();
        UniversalRequestKt$PayloadKt$Dsl.setDiagnosticEventRequest(DiagnosticEventRequestKt$Dsl._build(..));
        UniversalRequestKt$PayloadKt$Dsl._build();
        UniversalRequestKt$Dsl.setPayload(UniversalRequestKt$PayloadKt$Dsl._build(..));
        UniversalRequestKt$Dsl._build();
        return UniversalRequestKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.work.OperativeEventJob
// ============================================================
package com.unity3d.ads.core.domain.work;

public final class OperativeEventJob extends UniversalRequestJob {
    private final Lazy getOperativeRequestPolicy$delegate;

    public OperativeEventJob(Context p0, WorkerParameters p1) {
        new UniversalRequestJob(p0, p1);
        new OperativeEventJob$special$$inlined$inject$default$1(new UniversalRequestJob(..), "op_event_req");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new OperativeEventJob$special$$inlined$inject$default$1(..));
        getOperativeRequestPolicy$delegate = LazyKt.lazy(..);
        return;
    }

    private final GetRequestPolicy getGetOperativeRequestPolicy() {
        getOperativeRequestPolicy$delegate.getValue();
        return Lazy.getValue(..);
    }

    public Object doWork(Continuation p0) {
        OperativeEventJob.getGetOperativeRequestPolicy();
        GetRequestPolicy.invoke();
        OperativeEventJob.setRequestPolicy(GetRequestPolicy.invoke(..));
        UniversalRequestJob.doWork(p0);
        return UniversalRequestJob.doWork(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.work.UniversalRequestJob
// ============================================================
package com.unity3d.ads.core.domain.work;

public abstract class UniversalRequestJob extends CoroutineWorker {
    public RequestPolicy requestPolicy;
    private final Lazy universalRequestDataSource$delegate;
    private final Lazy universalRequestEventSender$delegate;
    private final WorkerParameters workerParams;

    public UniversalRequestJob(Context p0, WorkerParameters p1) {
        new CoroutineWorker(p0, p1);
        workerParams = p1;
        new UniversalRequestJob$special$$inlined$inject$default$1(new CoroutineWorker(..), "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UniversalRequestJob$special$$inlined$inject$default$1(..));
        universalRequestEventSender$delegate = LazyKt.lazy(..);
        new UniversalRequestJob$special$$inlined$inject$default$2(new CoroutineWorker(..), "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UniversalRequestJob$special$$inlined$inject$default$2(..));
        universalRequestDataSource$delegate = LazyKt.lazy(..);
        return;
    }

    static Object doWork$suspendImpl(UniversalRequestJob p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new UniversalRequestJob$doWork$1(p0, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_53;
        if (if-eq(label, 1)) goto L_47;
        if (if-eq(label, 2)) goto L_39;
        if (if-ne(label, 3)) goto L_31;
        ResultKt.throwOnFailure(result);
      L_31:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_39:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_47:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_53:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        workerParams.getInputData();
        WorkerParameters.getInputData(..).getString("universalRequestId");
        if (if-nez(Data.getString(..))) goto L_6e;
        ListenableWorker$Result.success();
        return ListenableWorker$Result.success(..);
      L_6e:
        ListenableWorker$Result.success(..).getUniversalRequestDataSource();
        L$0 = ListenableWorker$Result.success(..);
        L$1 = "success()";
        label = 1;
        UniversalRequestDataSource.get(new UniversalRequestJob$doWork$1(..));
        if (if-ne(UniversalRequestDataSource.get(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_7f;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_7f:
      L_83:
        UniversalRequestDataSource.get(..).getUniversalRequestMapOrThrow("success()");
        UniversalRequestOuterClass$UniversalRequest.parseFrom(UniversalRequestStoreOuterClass$UniversalRequestStore.getUniversalRequestMapOrThrow(..));
        ListenableWorker$Result.success(..).getUniversalRequestEventSender();
        ListenableWorker$Result.success(..).getRequestPolicy();
        L$0 = ListenableWorker$Result.success(..);
        L$1 = "success()";
        label = 2;
        UniversalRequestEventSender.invoke(UniversalRequestOuterClass$UniversalRequest.parseFrom(..), UniversalRequestJob.getRequestPolicy(..), new UniversalRequestJob$doWork$1(..));
        if (if-ne(UniversalRequestEventSender.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_a9;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_a9:
        Result.constructor-impl(Unit.INSTANCE);
      L_b0:
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_ba:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_dc;
        ListenableWorker$Result.success(..).getUniversalRequestDataSource();
        L$0 = 0;
        L$1 = 0;
        label = 3;
        UniversalRequestDataSource.remove("success()", new UniversalRequestJob$doWork$1(..));
        if (if-ne(UniversalRequestDataSource.remove(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_d2;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_d2:
        ListenableWorker$Result.success();
      L_dc:
        ListenableWorker$Result.retry();
      L_e5:
        return ListenableWorker$Result.retry(..);
    }

    public Object doWork(Continuation p0) {
        UniversalRequestJob.doWork$suspendImpl(this, p0);
        return UniversalRequestJob.doWork$suspendImpl(..);
    }

    public final RequestPolicy getRequestPolicy() {
        if (if-eqz(requestPolicy)) goto L_5;
        return requestPolicy;
      L_5:
        Intrinsics.throwUninitializedPropertyAccessException("requestPolicy");
        return 0;
    }

    public IServiceProvider getServiceProvider() {
        IServiceComponent$DefaultImpls.getServiceProvider(this);
        return IServiceComponent$DefaultImpls.getServiceProvider(..);
    }

    public final UniversalRequestDataSource getUniversalRequestDataSource() {
        universalRequestDataSource$delegate.getValue();
        return Lazy.getValue(..);
    }

    public final UniversalRequestEventSender getUniversalRequestEventSender() {
        universalRequestEventSender$delegate.getValue();
        return Lazy.getValue(..);
    }

    protected final WorkerParameters getWorkerParams() {
        return workerParams;
    }

    public final void setRequestPolicy(RequestPolicy p0) {
        requestPolicy = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.work.UniversalRequestWorkerData
// ============================================================
package com.unity3d.ads.core.domain.work;

public final class UniversalRequestWorkerData {
    public static final UniversalRequestWorkerData$Companion Companion = null;
    public static final String KEY_UNIVERSAL_REQUEST_ID = "universalRequestId";
    private final String universalRequestId;

    static <clinit>() {
        new UniversalRequestWorkerData$Companion(0);
        Companion = new UniversalRequestWorkerData$Companion(..);
        return;
    }

    public UniversalRequestWorkerData(String p0) {
        new Object();
        universalRequestId = p0;
        return;
    }

    public final Data invoke() {
        new Data$Builder();
        new Data$Builder(..).putString("universalRequestId", universalRequestId);
        Data$Builder.putString(..).build();
        return Data$Builder.build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.work.DiagnosticEventJob$doWork$1
// ============================================================
package com.unity3d.ads.core.domain.work;

final class DiagnosticEventJob$doWork$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final DiagnosticEventJob this$0;

    DiagnosticEventJob$doWork$1(DiagnosticEventJob p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.doWork(this);
        return DiagnosticEventJob.doWork(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.work.DiagnosticEventJob$special$$inlined$inject$default$1
// ============================================================
package com.unity3d.ads.core.domain.work;

public final class DiagnosticEventJob$special$$inlined$inject$default$1 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public DiagnosticEventJob$special$$inlined$inject$default$1(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(GetRequestPolicy.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.work.DiagnosticEventJob$special$$inlined$inject$default$2
// ============================================================
package com.unity3d.ads.core.domain.work;

public final class DiagnosticEventJob$special$$inlined$inject$default$2 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public DiagnosticEventJob$special$$inlined$inject$default$2(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(DiagnosticEventRequestWorkModifier.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.work.OperativeEventJob$special$$inlined$inject$default$1
// ============================================================
package com.unity3d.ads.core.domain.work;

public final class OperativeEventJob$special$$inlined$inject$default$1 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public OperativeEventJob$special$$inlined$inject$default$1(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(GetRequestPolicy.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.work.UniversalRequestJob$doWork$1
// ============================================================
package com.unity3d.ads.core.domain.work;

final class UniversalRequestJob$doWork$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final UniversalRequestJob this$0;

    UniversalRequestJob$doWork$1(UniversalRequestJob p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        UniversalRequestJob.doWork$suspendImpl(this$0, this);
        return UniversalRequestJob.doWork$suspendImpl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.work.UniversalRequestJob$special$$inlined$inject$default$1
// ============================================================
package com.unity3d.ads.core.domain.work;

public final class UniversalRequestJob$special$$inlined$inject$default$1 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UniversalRequestJob$special$$inlined$inject$default$1(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(UniversalRequestEventSender.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.work.UniversalRequestJob$special$$inlined$inject$default$2
// ============================================================
package com.unity3d.ads.core.domain.work;

public final class UniversalRequestJob$special$$inlined$inject$default$2 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UniversalRequestJob$special$$inlined$inject$default$2(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(UniversalRequestDataSource.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.work.UniversalRequestWorkerData$Companion
// ============================================================
package com.unity3d.ads.core.domain.work;

public final class UniversalRequestWorkerData$Companion {
    private UniversalRequestWorkerData$Companion() {
        new Object();
        return;
    }

    public UniversalRequestWorkerData$Companion(DefaultConstructorMarker p0) {
        new UniversalRequestWorkerData$Companion();
        return;
    }

}

