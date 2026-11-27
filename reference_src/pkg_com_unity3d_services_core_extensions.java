// Package bundle: com.unity3d.services.core.extensions (8 classes)

// ============================================================
// CLASS: com.unity3d.services.core.extensions.AbortRetryException
// ============================================================
package com.unity3d.services.core.extensions;

public final class AbortRetryException extends Exception {
    private final String reason;

    public AbortRetryException(String p0) {
        new Exception(p0);
        reason = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.extensions.CoroutineExtensionsKt
// ============================================================
package com.unity3d.services.core.extensions;

public final class CoroutineExtensionsKt {
    private static final LinkedHashMap deferreds;
    private static final Mutex mutex;

    static <clinit>() {
        new CoroutineExtensionsKt$deferreds$1();
        deferreds = new CoroutineExtensionsKt$deferreds$1(..);
        MutexKt.Mutex$default(0, 1, 0);
        mutex = MutexKt.Mutex$default(..);
        return;
    }

    public static final LinkedHashMap getDeferreds() {
        return CoroutineExtensionsKt.deferreds;
    }

    public static final Mutex getMutex() {
        return CoroutineExtensionsKt.mutex;
    }

    public static final Object memoize(Object p0, Function1 p1, Continuation p2) {
        new CoroutineExtensionsKt$memoize$2(p0, p1, 0);
        CoroutineScopeKt.coroutineScope(new CoroutineExtensionsKt$memoize$2(..), p2);
        return CoroutineScopeKt.coroutineScope(..);
    }

    private static final Object memoize$$forInline(Object p0, Function1 p1, Continuation p2) {
        new CoroutineExtensionsKt$memoize$2(p0, p1, 0);
        InlineMarker.mark(0);
        CoroutineScopeKt.coroutineScope(new CoroutineExtensionsKt$memoize$2(..), p2);
        InlineMarker.mark(1);
        return CoroutineScopeKt.coroutineScope(..);
    }

    public static final Object runReturnSuspendCatching(Function0 p0) {
        p0.invoke();
        Result.constructor-impl(Function0.invoke(..));
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_1b:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_28;
        Result.constructor-impl(Result.constructor-impl(..));
        return Result.constructor-impl(..);
      L_28:
        Result.exceptionOrNull-impl(Result.constructor-impl(..));
        if (if-eqz(Result.exceptionOrNull-impl(..))) goto L_38;
        ResultKt.createFailure(Result.exceptionOrNull-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_38:
        return Result.constructor-impl(..);
        throw Result.constructor-impl(..);
    }

    public static final Object runSuspendCatching(Function0 p0) {
        p0.invoke();
        Result.constructor-impl(Function0.invoke(..));
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_1b:
        return Result.constructor-impl(..);
        throw Result.constructor-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.extensions.StringExtensionsKt
// ============================================================
package com.unity3d.services.core.extensions;

public final class StringExtensionsKt {
    public static final String toUnityMessage(String p0) {
        if (if-eqz(p0)) goto L_e;
        p0.length();
        if (if-nez(CharSequence.length(..))) goto L_c;
      L_c:
      L_e:
      L_f:
        if (if-eqz(1)) goto L_14;
        return "[Unity Ads] Internal error";
      L_14:
        new StringBuilder("[Unity Ads] ");
        new StringBuilder(..).append("[Unity Ads] Internal error");
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.extensions.TaskExtensionsKt
// ============================================================
package com.unity3d.services.core.extensions;

public final class TaskExtensionsKt {
    public static final Object withRetry(long p0, int p1, double p2, Exception p3, Function2 p4, Continuation p5) {
        if (if-eqz(v1)) goto L_16;
        if (if-eqz(label)) goto L_16;
        label = label;
      L_16:
        new TaskExtensionsKt$withRetry$1(label);
      L_1b:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_69;
        if (if-eq(label, 1)) goto L_4c;
        if (if-ne(label, 2)) goto L_44;
        ResultKt.throwOnFailure(result);
      L_44:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_4c:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_69:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        new Ref$LongRef();
        element = p0;
      L_82:
        if (if-ge(0, p1)) goto L_155;
        Boxing.boxInt(0);
        L$0 = p3;
        L$1 = p4;
        L$2 = new Ref$LongRef(..);
        J$0 = p0;
        I$0 = p1;
        D$0 = p2;
        I$1 = 0;
        I$2 = 0;
        label = 1;
        p4.invoke(Boxing.boxInt(..), "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(Function2.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_a3;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_a3:
      L_b6:
        Result.constructor-impl(Function2.invoke(..));
      L_cf:
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_d9:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_e8;
        ResultKt.throwOnFailure(Result.constructor-impl(..));
        return Result.constructor-impl(..);
      L_e8:
        Result.isFailure-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isFailure-impl(..))) goto L_145;
        Result.exceptionOrNull-impl(Result.constructor-impl(..));
        if (if-nez(Result.isFailure-impl(..))) goto L_144;
        if (if-eq(new Ref$LongRef(..), "call to 'resume' before 'invoke' with coroutine")) goto L_143;
        new StringBuilder("Unity Ads init: retrying in ");
        new StringBuilder(..).append(element, "Unity Ads init: retrying in ");
        new StringBuilder(..).append(" milliseconds");
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        L$0 = p3;
        L$1 = p1;
        L$2 = p4;
        J$0 = 0;
        I$0 = "call to 'resume' before 'invoke' with coroutine";
        D$0 = IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
        I$1 = new Ref$LongRef(..);
        label = 2;
        DelayKt.delay(element, "Unity Ads init: retrying in ", p0);
        if (if-ne(DelayKt.delay(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_12a;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_12a:
      L_130:
        element = p3;
      L_143:
        throw p3;
      L_144:
        throw new Ref$LongRef(..);
      L_145:
      L_151:
      L_155:
        new IllegalStateException("Unknown exception from withRetry");
        throw new IllegalStateException(..);
    }

    public static Object withRetry$default(long p0, int p1, double p2, Exception p3, Function2 p4, Continuation p5, int p6, Object p7) {
        if (if-eqz(v0)) goto L_8;
      L_8:
      L_9:
        if (if-eqz(5000L)) goto L_10;
      L_10:
      L_11:
        if (if-eqz(6)) goto L_19;
      L_19:
      L_1a:
        TaskExtensionsKt.withRetry(p0, v3, p1, p2, v6, p3, p4, p5);
        return TaskExtensionsKt.withRetry(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.extensions.CoroutineExtensionsKt$deferreds$1
// ============================================================
package com.unity3d.services.core.extensions;

public final class CoroutineExtensionsKt$deferreds$1 extends LinkedHashMap {
    CoroutineExtensionsKt$deferreds$1() {
        new LinkedHashMap(101);
        return;
    }

    public final boolean containsValue(Object p0) {
        if (if-nez(v0)) goto L_6;
        return 0;
      L_6:
        CoroutineExtensionsKt$deferreds$1.containsValue(0);
        return CoroutineExtensionsKt$deferreds$1.containsValue(..);
    }

    public boolean containsValue(Deferred p0) {
        LinkedHashMap.containsValue(p0);
        return LinkedHashMap.containsValue(..);
    }

    public final Set entrySet() {
        CoroutineExtensionsKt$deferreds$1.getEntries();
        return CoroutineExtensionsKt$deferreds$1.getEntries(..);
    }

    public Set getEntries() {
        LinkedHashMap.entrySet();
        return LinkedHashMap.entrySet(..);
    }

    public Set getKeys() {
        LinkedHashMap.keySet();
        return LinkedHashMap.keySet(..);
    }

    public int getSize() {
        LinkedHashMap.size();
        return LinkedHashMap.size(..);
    }

    public Collection getValues() {
        LinkedHashMap.values();
        return LinkedHashMap.values(..);
    }

    public final Set keySet() {
        CoroutineExtensionsKt$deferreds$1.getKeys();
        return CoroutineExtensionsKt$deferreds$1.getKeys(..);
    }

    public final boolean remove(Object p0, Object p1) {
        if (if-nez(p0)) goto L_4;
        return 0;
      L_4:
        if (if-nez(v1)) goto L_9;
        return 0;
      L_9:
        CoroutineExtensionsKt$deferreds$1.remove(p0, p1);
        return CoroutineExtensionsKt$deferreds$1.remove(..);
    }

    public boolean remove(Object p0, Deferred p1) {
        LinkedHashMap.remove(p0, p1);
        return LinkedHashMap.remove(..);
    }

    protected boolean removeEldestEntry(Map$Entry p0) {
        CoroutineExtensionsKt$deferreds$1.size();
        if (if-le(CoroutineExtensionsKt$deferreds$1.size(..), 100)) goto L_f;
      L_f:
      L_10:
        return 0;
    }

    public final int size() {
        CoroutineExtensionsKt$deferreds$1.getSize();
        return CoroutineExtensionsKt$deferreds$1.getSize(..);
    }

    public final Collection values() {
        CoroutineExtensionsKt$deferreds$1.getValues();
        return CoroutineExtensionsKt$deferreds$1.getValues(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2
// ============================================================
package com.unity3d.services.core.extensions;

public final class CoroutineExtensionsKt$memoize$2 extends SuspendLambda {
    final Function1 $action;
    final Object $key;
    private Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public CoroutineExtensionsKt$memoize$2(Object p0, Function1 p1, Continuation p2) {
        $key = p0;
        $action = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new CoroutineExtensionsKt$memoize$2($key, $action, p1);
        L$0 = p0;
        return new CoroutineExtensionsKt$memoize$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        CoroutineExtensionsKt$memoize$2.invoke(p0, p1);
        return CoroutineExtensionsKt$memoize$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        CoroutineExtensionsKt$memoize$2.create(p0, p1);
        CoroutineExtensionsKt$memoize$2.invokeSuspend(Unit.INSTANCE);
        return CoroutineExtensionsKt$memoize$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_2e;
        if (if-eq(label, 1)) goto L_1c;
        if (if-ne(label, 2)) goto L_14;
        ResultKt.throwOnFailure(p0);
      L_14:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1c:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_2e:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        CoroutineExtensionsKt.getMutex();
        L$0 = L$0;
        L$1 = CoroutineExtensionsKt.getMutex(..);
        L$2 = $key;
        L$3 = $action;
        label = L$2;
        CoroutineExtensionsKt.getMutex(..).lock(0, this);
        if (if-ne(Mutex.lock(..), "call to 'resume' before 'invoke' with coroutine")) goto L_52;
        return "call to 'resume' before 'invoke' with coroutine";
      L_52:
      L_53:
        CoroutineExtensionsKt.getDeferreds();
        Map.get($key);
        if (if-nez(Map.get(..))) goto L_71;
        new CoroutineExtensionsKt$memoize$2$deferred$1$1$1($action, 0);
        BuildersKt.async$default(L$0, 0, 0, new CoroutineExtensionsKt$memoize$2$deferred$1$1$1(..), 3, 0);
        Map.put($key, BuildersKt.async$default(..));
      L_71:
        CoroutineExtensionsKt.getMutex(..).unlock(0);
        L$0 = 0;
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        label = 2;
        BuildersKt.async$default(..).await(this);
        if (if-ne(Deferred.await(..), "call to 'resume' before 'invoke' with coroutine")) goto L_8a;
        return "call to 'resume' before 'invoke' with coroutine";
      L_8a:
        return Deferred.await(..);
        CoroutineExtensionsKt.getMutex(..).unlock(0);
        throw Deferred.await(..);
    }

    public final Object invokeSuspend$$forInline(Object p0) {
        CoroutineExtensionsKt.getMutex();
        InlineMarker.mark(0);
        CoroutineExtensionsKt.getMutex(..).lock(0, this);
        InlineMarker.mark(1);
        CoroutineExtensionsKt.getDeferreds();
        Map.get($key);
        if (if-nez(Map.get(..))) goto L_40;
        new CoroutineExtensionsKt$memoize$2$deferred$1$1$1($action, 0);
        BuildersKt.async$default(L$0, 0, 0, new CoroutineExtensionsKt$memoize$2$deferred$1$1$1(..), 3, 0);
        Map.put($key, BuildersKt.async$default(..));
      L_40:
        CoroutineExtensionsKt.getMutex(..).unlock(0);
        InlineMarker.mark(0);
        BuildersKt.async$default(..).await(this);
        InlineMarker.mark(1);
        return Deferred.await(..);
        Deferred.await(..).unlock(0);
        throw Deferred.await(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2$deferred$1$1$1
// ============================================================
package com.unity3d.services.core.extensions;

public final class CoroutineExtensionsKt$memoize$2$deferred$1$1$1 extends SuspendLambda {
    final Function1 $action;
    int label;

    public CoroutineExtensionsKt$memoize$2$deferred$1$1$1(Function1 p0, Continuation p1) {
        $action = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new CoroutineExtensionsKt$memoize$2$deferred$1$1$1($action, p1);
        return new CoroutineExtensionsKt$memoize$2$deferred$1$1$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        CoroutineExtensionsKt$memoize$2$deferred$1$1$1.invoke(p0, p1);
        return CoroutineExtensionsKt$memoize$2$deferred$1$1$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        CoroutineExtensionsKt$memoize$2$deferred$1$1$1.create(p0, p1);
        CoroutineExtensionsKt$memoize$2$deferred$1$1$1.invokeSuspend(Unit.INSTANCE);
        return CoroutineExtensionsKt$memoize$2$deferred$1$1$1.invokeSuspend(..);
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
        $action.invoke(this);
        if (if-ne(Function1.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_25;
        return "call to 'resume' before 'invoke' with coroutine";
      L_25:
        return Function1.invoke(..);
    }

    public final Object invokeSuspend$$forInline(Object p0) {
        $action.invoke(this);
        return Function1.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.extensions.TaskExtensionsKt$withRetry$1
// ============================================================
package com.unity3d.services.core.extensions;

final class TaskExtensionsKt$withRetry$1 extends ContinuationImpl {
    double D$0;
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    Object result;

    TaskExtensionsKt$withRetry$1(Continuation p0) {
        new ContinuationImpl(p0);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        TaskExtensionsKt.withRetry(0L, v1, 0, 0L, v4, 0, 0, this);
        return TaskExtensionsKt.withRetry(..);
    }

}

