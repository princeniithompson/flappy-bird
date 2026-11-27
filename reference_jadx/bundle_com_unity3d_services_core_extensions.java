
// ===== FILE: com/unity3d/services/core/extensions/AbortRetryException.java =====
package com.unity3d.services.core.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskExtensions.kt */
@Metadata(m443d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m444d2 = {"Lcom/unity3d/services/core/extensions/AbortRetryException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "reason", "", "(Ljava/lang/String;)V", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class AbortRetryException extends Exception {
    private final String reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbortRetryException(String reason) {
        super(reason);
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.reason = reason;
    }
}

// ===== FILE: com/unity3d/services/core/extensions/CoroutineExtensionsKt$memoize$2$deferred$1$1$1.java =====
package com.unity3d.services.core.extensions;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: CoroutineExtensions.kt */
@Metadata(m443d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, m444d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2$deferred$1$1$1", m464f = "CoroutineExtensions.kt", m465i = {}, m466l = {41}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
public final class CoroutineExtensionsKt$memoize$2$deferred$1$1$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Function1<Continuation<? super T>, Object> $action;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineExtensionsKt$memoize$2$deferred$1$1$1(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super CoroutineExtensionsKt$memoize$2$deferred$1$1$1> continuation) {
        super(2, continuation);
        this.$action = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineExtensionsKt$memoize$2$deferred$1$1$1(this.$action, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return ((CoroutineExtensionsKt$memoize$2$deferred$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super T>, Object> function1 = this.$action;
            this.label = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        return this.$action.invoke(this);
    }
}

// ===== FILE: com/unity3d/services/core/extensions/CoroutineExtensionsKt$memoize$2.java =====
package com.unity3d.services.core.extensions;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: CoroutineExtensions.kt */
@Metadata(m443d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, m444d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2", m464f = "CoroutineExtensions.kt", m465i = {0, 0}, m466l = {52, 45}, m467m = "invokeSuspend", m468n = {"$this$coroutineScope", "$this$withLock_u24default$iv"}, m469s = {"L$0", "L$1"})
/* loaded from: classes.dex */
public final class CoroutineExtensionsKt$memoize$2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Function1<Continuation<? super T>, Object> $action;
    final /* synthetic */ Object $key;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineExtensionsKt$memoize$2(Object obj, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super CoroutineExtensionsKt$memoize$2> continuation) {
        super(2, continuation);
        this.$key = obj;
        this.$action = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CoroutineExtensionsKt$memoize$2 coroutineExtensionsKt$memoize$2 = new CoroutineExtensionsKt$memoize$2(this.$key, this.$action, continuation);
        coroutineExtensionsKt$memoize$2.L$0 = obj;
        return coroutineExtensionsKt$memoize$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return ((CoroutineExtensionsKt$memoize$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Mutex mutex;
        Function1<Continuation<? super T>, Object> function1;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                mutex = CoroutineExtensionsKt.getMutex();
                Object obj3 = this.$key;
                function1 = this.$action;
                this.L$0 = coroutineScope;
                this.L$1 = mutex;
                this.L$2 = obj3;
                this.L$3 = function1;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = obj3;
            } else {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function1 = (Function1) this.L$3;
                obj2 = this.L$2;
                mutex = (Mutex) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            LinkedHashMap<Object, Deferred<?>> deferreds = CoroutineExtensionsKt.getDeferreds();
            Deferred<?> deferred = deferreds.get(obj2);
            if (deferred == null) {
                deferred = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new CoroutineExtensionsKt$memoize$2$deferred$1$1$1(function1, null), 3, null);
                deferreds.put(obj2, deferred);
            }
            Deferred<?> deferred2 = deferred;
            mutex.unlock(null);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 2;
            obj = deferred2.await(this);
            return obj == coroutine_suspended ? coroutine_suspended : obj;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Mutex mutex = CoroutineExtensionsKt.getMutex();
        Object obj2 = this.$key;
        Function1<Continuation<? super T>, Object> function1 = this.$action;
        CoroutineExtensionsKt$memoize$2<T> coroutineExtensionsKt$memoize$2 = this;
        InlineMarker.mark(0);
        mutex.lock(null, coroutineExtensionsKt$memoize$2);
        InlineMarker.mark(1);
        try {
            LinkedHashMap<Object, Deferred<?>> deferreds = CoroutineExtensionsKt.getDeferreds();
            Deferred<?> deferred = deferreds.get(obj2);
            if (deferred == null) {
                deferred = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new CoroutineExtensionsKt$memoize$2$deferred$1$1$1(function1, null), 3, null);
                deferreds.put(obj2, deferred);
            }
            Deferred<?> deferred2 = deferred;
            mutex.unlock(null);
            InlineMarker.mark(0);
            Object await = deferred2.await(coroutineExtensionsKt$memoize$2);
            InlineMarker.mark(1);
            return await;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }
}

// ===== FILE: com/unity3d/services/core/extensions/CoroutineExtensionsKt.java =====
package com.unity3d.services.core.extensions;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: CoroutineExtensions.kt */
@Metadata(m443d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u00022\u001e\b\u0004\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000fH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a.\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0016H\u0086\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a.\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0016H\u0086\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0017\"5\u0010\u0000\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006\u0019"}, m444d2 = {"deferreds", "Ljava/util/LinkedHashMap;", "", "Lkotlinx/coroutines/Deferred;", "Lkotlin/collections/LinkedHashMap;", "getDeferreds", "()Ljava/util/LinkedHashMap;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getMutex", "()Lkotlinx/coroutines/sync/Mutex;", "memoize", "T", "key", "action", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runReturnSuspendCatching", "Lkotlin/Result;", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runSuspendCatching", "unity-ads_release"}, m445k = 2, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class CoroutineExtensionsKt {
    private static final LinkedHashMap<Object, Deferred<?>> deferreds = new LinkedHashMap<Object, Deferred<?>>() { // from class: com.unity3d.services.core.extensions.CoroutineExtensionsKt$deferreds$1
        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof Deferred) {
                return containsValue((Deferred<?>) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(Deferred<?> deferred) {
            return super.containsValue((Object) deferred);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<Object, Deferred<?>>> entrySet() {
            return getEntries();
        }

        public /* bridge */ Set<Map.Entry<Object, Deferred<?>>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<Object> getKeys() {
            return super.keySet();
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<Deferred<?>> getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Object> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if (obj != null && (obj2 instanceof Deferred)) {
                return remove(obj, (Deferred<?>) obj2);
            }
            return false;
        }

        public /* bridge */ boolean remove(Object obj, Deferred<?> deferred) {
            return super.remove(obj, (Object) deferred);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<Deferred<?>> values() {
            return getValues();
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Object, Deferred<?>> eldest) {
            Intrinsics.checkNotNullParameter(eldest, "eldest");
            return size() > 100;
        }
    };
    private static final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    public static final <R> Object runSuspendCatching(Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m745constructorimpl(block.invoke());
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m745constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final LinkedHashMap<Object, Deferred<?>> getDeferreds() {
        return deferreds;
    }

    public static final Mutex getMutex() {
        return mutex;
    }

    public static final <T> Object memoize(Object obj, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        return CoroutineScopeKt.coroutineScope(new CoroutineExtensionsKt$memoize$2(obj, function1, null), continuation);
    }

    private static final <T> Object memoize$$forInline(Object obj, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        CoroutineExtensionsKt$memoize$2 coroutineExtensionsKt$memoize$2 = new CoroutineExtensionsKt$memoize$2(obj, function1, null);
        InlineMarker.mark(0);
        Object coroutineScope = CoroutineScopeKt.coroutineScope(coroutineExtensionsKt$memoize$2, continuation);
        InlineMarker.mark(1);
        return coroutineScope;
    }

    public static final <R> Object runReturnSuspendCatching(Function0<? extends R> block) {
        Object m745constructorimpl;
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            Result.Companion companion = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(block.invoke());
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m752isSuccessimpl(m745constructorimpl)) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m745constructorimpl(m745constructorimpl);
        }
        Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(m745constructorimpl);
        if (m748exceptionOrNullimpl == null) {
            return m745constructorimpl;
        }
        Result.Companion companion4 = Result.INSTANCE;
        return Result.m745constructorimpl(ResultKt.createFailure(m748exceptionOrNullimpl));
    }
}

// ===== FILE: com/unity3d/services/core/extensions/StringExtensionsKt.java =====
package com.unity3d.services.core.extensions;

import com.unity3d.services.UnityAdsConstants;
import kotlin.Metadata;

/* compiled from: StringExtensions.kt */
@Metadata(m443d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0001¨\u0006\u0002"}, m444d2 = {"toUnityMessage", "", "unity-ads_release"}, m445k = 2, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class StringExtensionsKt {
    public static final String toUnityMessage(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return "[Unity Ads] Internal error";
        }
        return UnityAdsConstants.Messages.MSG_UNITY_BASE + str;
    }
}

// ===== FILE: com/unity3d/services/core/extensions/TaskExtensionsKt$withRetry$1.java =====
package com.unity3d.services.core.extensions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: TaskExtensions.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.extensions.TaskExtensionsKt", m464f = "TaskExtensions.kt", m465i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, m466l = {17, 30}, m467m = "withRetry", m468n = {"fallbackException", "block", "nextDelay", "retryDelay", "retries", "scalingFactor", "attempt", "fallbackException", "block", "nextDelay", "retryDelay", "retries", "scalingFactor"}, m469s = {"L$0", "L$1", "L$2", "J$0", "I$0", "D$0", "I$2", "L$0", "L$1", "L$2", "J$0", "I$0", "D$0"})
/* loaded from: classes.dex */
final class TaskExtensionsKt$withRetry$1<T> extends ContinuationImpl {
    double D$0;
    int I$0;
    int I$1;
    int I$2;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    TaskExtensionsKt$withRetry$1(Continuation<? super TaskExtensionsKt$withRetry$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TaskExtensionsKt.withRetry(0L, 0, 0.0d, null, null, this);
    }
}

// ===== FILE: com/unity3d/services/core/extensions/TaskExtensionsKt.java =====
package com.unity3d.services.core.extensions;

import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.log.DeviceLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DelayKt;

/* compiled from: TaskExtensions.kt */
@Metadata(m443d1 = {"\u00008\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001at\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\n21\u0010\u000b\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, m444d2 = {"withRetry", "T", "retryDelay", "", "retries", "", "scalingFactor", "", "fallbackException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", MediationMetaData.KEY_NAME, "attempt", "Lkotlin/coroutines/Continuation;", "", "(JIDLjava/lang/Exception;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, m445k = 2, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class TaskExtensionsKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x012a -> B:11:0x0130). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0145 -> B:12:0x0151). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withRetry(long j, int i, double d, Exception exc, Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        TaskExtensionsKt$withRetry$1 taskExtensionsKt$withRetry$1;
        int i2;
        long j2;
        Exception exc2;
        Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> function22;
        Ref.LongRef longRef;
        TaskExtensionsKt$withRetry$1 taskExtensionsKt$withRetry$12;
        Object obj;
        int i3;
        int i4;
        double d2;
        Exception exc3;
        Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> function23;
        Ref.LongRef longRef2;
        long j3;
        int i5;
        double d3;
        int i6;
        int i7;
        Throwable th;
        Object m745constructorimpl;
        int i8;
        if (continuation instanceof TaskExtensionsKt$withRetry$1) {
            taskExtensionsKt$withRetry$1 = (TaskExtensionsKt$withRetry$1) continuation;
            if ((taskExtensionsKt$withRetry$1.label & Integer.MIN_VALUE) != 0) {
                taskExtensionsKt$withRetry$1.label -= Integer.MIN_VALUE;
                Object obj2 = taskExtensionsKt$withRetry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = taskExtensionsKt$withRetry$1.label;
                int i9 = 1;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.LongRef longRef3 = new Ref.LongRef();
                    j2 = j;
                    longRef3.element = j2;
                    exc2 = exc;
                    function22 = function2;
                    longRef = longRef3;
                    taskExtensionsKt$withRetry$12 = taskExtensionsKt$withRetry$1;
                    obj = coroutine_suspended;
                    i3 = 0;
                    i4 = i;
                    d2 = d;
                    if (i3 >= i4) {
                    }
                } else if (i2 == 1) {
                    i7 = taskExtensionsKt$withRetry$1.I$2;
                    i6 = taskExtensionsKt$withRetry$1.I$1;
                    d3 = taskExtensionsKt$withRetry$1.D$0;
                    i5 = taskExtensionsKt$withRetry$1.I$0;
                    j3 = taskExtensionsKt$withRetry$1.J$0;
                    longRef2 = (Ref.LongRef) taskExtensionsKt$withRetry$1.L$2;
                    function23 = (Function2) taskExtensionsKt$withRetry$1.L$1;
                    exc3 = (Exception) taskExtensionsKt$withRetry$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion = Result.INSTANCE;
                        m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th));
                        int i10 = i6;
                        int i11 = i7;
                        i8 = i10;
                        if (Result.m752isSuccessimpl(m745constructorimpl)) {
                        }
                    }
                    m745constructorimpl = Result.m745constructorimpl(obj2);
                    int i102 = i6;
                    int i112 = i7;
                    i8 = i102;
                    if (Result.m752isSuccessimpl(m745constructorimpl)) {
                    }
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i8 = taskExtensionsKt$withRetry$1.I$1;
                    double d4 = taskExtensionsKt$withRetry$1.D$0;
                    int i12 = taskExtensionsKt$withRetry$1.I$0;
                    long j4 = taskExtensionsKt$withRetry$1.J$0;
                    Ref.LongRef longRef4 = (Ref.LongRef) taskExtensionsKt$withRetry$1.L$2;
                    Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> function24 = (Function2) taskExtensionsKt$withRetry$1.L$1;
                    Exception exc4 = (Exception) taskExtensionsKt$withRetry$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    longRef4.element = (long) (j4 * d4);
                    int i13 = i8;
                    i9 = 1;
                    long j5 = j4;
                    taskExtensionsKt$withRetry$12 = taskExtensionsKt$withRetry$1;
                    i4 = i12;
                    function22 = function24;
                    exc2 = exc4;
                    longRef = longRef4;
                    obj = coroutine_suspended;
                    d2 = d4;
                    j2 = j5;
                    i3 = i13 + 1;
                    if (i3 >= i4) {
                        try {
                        } catch (Throwable th3) {
                            th = th3;
                            exc3 = exc2;
                            Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> function25 = function22;
                            i5 = i4;
                            taskExtensionsKt$withRetry$1 = taskExtensionsKt$withRetry$12;
                            Ref.LongRef longRef5 = longRef;
                            function23 = function25;
                            double d5 = d2;
                            coroutine_suspended = obj;
                            j3 = j2;
                            i7 = i3;
                            i6 = i7;
                            longRef2 = longRef5;
                            d3 = d5;
                            Result.Companion companion2 = Result.INSTANCE;
                            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th));
                            int i1022 = i6;
                            int i1122 = i7;
                            i8 = i1022;
                            if (Result.m752isSuccessimpl(m745constructorimpl)) {
                            }
                        }
                        Result.Companion companion3 = Result.INSTANCE;
                        Integer boxInt = Boxing.boxInt(i3);
                        taskExtensionsKt$withRetry$12.L$0 = exc2;
                        taskExtensionsKt$withRetry$12.L$1 = function22;
                        taskExtensionsKt$withRetry$12.L$2 = longRef;
                        taskExtensionsKt$withRetry$12.J$0 = j2;
                        taskExtensionsKt$withRetry$12.I$0 = i4;
                        taskExtensionsKt$withRetry$12.D$0 = d2;
                        taskExtensionsKt$withRetry$12.I$1 = i3;
                        taskExtensionsKt$withRetry$12.I$2 = i3;
                        taskExtensionsKt$withRetry$12.label = i9;
                        obj2 = function22.invoke(boxInt, taskExtensionsKt$withRetry$12);
                        if (obj2 == obj) {
                            return obj;
                        }
                        exc3 = exc2;
                        Function2<? super Integer, ? super Continuation<? super T>, ? extends Object> function26 = function22;
                        i5 = i4;
                        taskExtensionsKt$withRetry$1 = taskExtensionsKt$withRetry$12;
                        Ref.LongRef longRef6 = longRef;
                        function23 = function26;
                        double d6 = d2;
                        coroutine_suspended = obj;
                        j3 = j2;
                        i7 = i3;
                        i6 = i7;
                        longRef2 = longRef6;
                        d3 = d6;
                        m745constructorimpl = Result.m745constructorimpl(obj2);
                        int i10222 = i6;
                        int i11222 = i7;
                        i8 = i10222;
                        if (Result.m752isSuccessimpl(m745constructorimpl)) {
                            ResultKt.throwOnFailure(m745constructorimpl);
                            return m745constructorimpl;
                        }
                        if (Result.m751isFailureimpl(m745constructorimpl)) {
                            Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(m745constructorimpl);
                            if (m748exceptionOrNullimpl instanceof AbortRetryException) {
                                throw m748exceptionOrNullimpl;
                            }
                            if (i11222 + i9 == i5) {
                                throw exc3;
                            }
                            DeviceLog.debug("Unity Ads init: retrying in " + longRef2.element + " milliseconds");
                            long j6 = longRef2.element;
                            taskExtensionsKt$withRetry$1.L$0 = exc3;
                            taskExtensionsKt$withRetry$1.L$1 = function23;
                            taskExtensionsKt$withRetry$1.L$2 = longRef2;
                            taskExtensionsKt$withRetry$1.J$0 = j3;
                            taskExtensionsKt$withRetry$1.I$0 = i5;
                            taskExtensionsKt$withRetry$1.D$0 = d3;
                            taskExtensionsKt$withRetry$1.I$1 = i8;
                            taskExtensionsKt$withRetry$1.label = 2;
                            if (DelayKt.delay(j6, taskExtensionsKt$withRetry$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            d4 = d3;
                            i12 = i5;
                            j4 = j3;
                            longRef4 = longRef2;
                            function24 = function23;
                            exc4 = exc3;
                            longRef4.element = (long) (j4 * d4);
                            int i132 = i8;
                            i9 = 1;
                            long j52 = j4;
                            taskExtensionsKt$withRetry$12 = taskExtensionsKt$withRetry$1;
                            i4 = i12;
                            function22 = function24;
                            exc2 = exc4;
                            longRef = longRef4;
                            obj = coroutine_suspended;
                            d2 = d4;
                            j2 = j52;
                            i3 = i132 + 1;
                            if (i3 >= i4) {
                                throw new IllegalStateException("Unknown exception from withRetry");
                            }
                        } else {
                            i132 = i8;
                            long j7 = j3;
                            taskExtensionsKt$withRetry$12 = taskExtensionsKt$withRetry$1;
                            obj = coroutine_suspended;
                            d2 = d3;
                            i4 = i5;
                            j2 = j7;
                            function22 = function23;
                            exc2 = exc3;
                            longRef = longRef2;
                            i3 = i132 + 1;
                            if (i3 >= i4) {
                            }
                        }
                    }
                }
            }
        }
        taskExtensionsKt$withRetry$1 = new TaskExtensionsKt$withRetry$1(continuation);
        Object obj22 = taskExtensionsKt$withRetry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = taskExtensionsKt$withRetry$1.label;
        int i92 = 1;
        if (i2 != 0) {
        }
    }
}
