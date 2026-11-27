// Package bundle: com.unity3d.ads.core.utils (4 classes)

// ============================================================
// CLASS: com.unity3d.ads.core.utils.CommonCoroutineTimer
// ============================================================
package com.unity3d.ads.core.utils;

public final class CommonCoroutineTimer {
    private final CoroutineDispatcher dispatcher;
    private final CompletableJob job;
    private final CoroutineScope scope;

    public CommonCoroutineTimer(CoroutineDispatcher p0) {
        new Object();
        dispatcher = p0;
        SupervisorKt.SupervisorJob$default(0, 1, 0);
        job = SupervisorKt.SupervisorJob$default(..);
        p0.plus(SupervisorKt.SupervisorJob$default(..));
        CoroutineScopeKt.CoroutineScope(CoroutineDispatcher.plus(..));
        scope = CoroutineScopeKt.CoroutineScope(..);
        return;
    }

    public Job start(long p0, long p1, Function0 p2) {
        new CommonCoroutineTimer$start$1(p0, v4, p2, p1, v7, 0);
        BuildersKt.launch$default(scope, dispatcher, 0, new CommonCoroutineTimer$start$1, 2, 0);
        return BuildersKt.launch$default(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.utils.ContinuationFromCallback
// ============================================================
package com.unity3d.ads.core.utils;

public final class ContinuationFromCallback extends WebViewCallback {
    private final Continuation continuation;

    public ContinuationFromCallback(Continuation p0) {
        new WebViewCallback("", 0);
        continuation = p0;
        return;
    }

    public void error(Enum p0, Object[] p1) {
        new StringBuilder("Invocation failed with: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        new ExposureException(StringBuilder.toString(..), p1);
        ResultKt.createFailure(new ExposureException(..));
        Result.constructor-impl(ResultKt.createFailure(..));
        continuation.resumeWith(Result.constructor-impl(..));
        return;
    }

    public void invoke(Object[] p0) {
        Result.constructor-impl(p0);
        continuation.resumeWith(Result.constructor-impl(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.utils.CoroutineTimer
// ============================================================
package com.unity3d.ads.core.utils;

public abstract class CoroutineTimer {
    public abstract Job start(long p0, long p1, Function0 p2) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.utils.CommonCoroutineTimer$start$1
// ============================================================
package com.unity3d.ads.core.utils;

final class CommonCoroutineTimer$start$1 extends SuspendLambda {
    final Function0 $action;
    final long $delayStartMillis;
    final long $repeatMillis;
    private Object L$0;
    int label;

    CommonCoroutineTimer$start$1(long p0, Function0 p1, long p2, Continuation p3) {
        $delayStartMillis = p0;
        $action = p1;
        $repeatMillis = p2;
        new SuspendLambda(2, p3);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new CommonCoroutineTimer$start$1($delayStartMillis, v2, $action, $repeatMillis, v5, p1);
        L$0 = p0;
        return new CommonCoroutineTimer$start$1;
    }

    public Object invoke(Object p0, Object p1) {
        CommonCoroutineTimer$start$1.invoke(p0, p1);
        return CommonCoroutineTimer$start$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        CommonCoroutineTimer$start$1.create(p0, p1);
        CommonCoroutineTimer$start$1.invokeSuspend(Unit.INSTANCE);
        return CommonCoroutineTimer$start$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_1e;
        if (if-eq(label, 1)) goto L_e;
        if (if-ne(label, 2)) goto L_16;
      L_e:
        ResultKt.throwOnFailure(p0);
      L_16:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1e:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        L$0 = L$0;
        label = 1;
        DelayKt.delay($delayStartMillis, v5, this);
        if (if-ne(DelayKt.delay(..), "call to 'resume' before 'invoke' with coroutine")) goto L_36;
        return "call to 'resume' before 'invoke' with coroutine";
      L_36:
      L_37:
        CoroutineScopeKt.isActive(L$0);
        if (if-eqz(CoroutineScopeKt.isActive(..))) goto L_52;
        $action.invoke();
        L$0 = L$0;
        label = 2;
        DelayKt.delay($repeatMillis, $delayStartMillis, this);
        if (if-ne(DelayKt.delay(..), "call to 'resume' before 'invoke' with coroutine")) goto L_37;
        return "call to 'resume' before 'invoke' with coroutine";
      L_52:
        return Unit.INSTANCE;
    }

}

