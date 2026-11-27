
// ===== FILE: com/unity3d/services/core/domain/ISDKDispatchers.java =====
package com.unity3d.services.core.domain;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: ISDKDispatchers.kt */
@Metadata(m443d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\n"}, m444d2 = {"Lcom/unity3d/services/core/domain/ISDKDispatchers;", "", "default", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "io", "getIo", "main", "getMain", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface ISDKDispatchers {
    CoroutineDispatcher getDefault();

    CoroutineDispatcher getIo();

    CoroutineDispatcher getMain();
}

// ===== FILE: com/unity3d/services/core/domain/ResultExtensionsKt.java =====
package com.unity3d.services.core.domain;

import com.unity3d.services.core.domain.task.InitializationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultExtensions.kt */
@Metadata(m443d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u000e\b\u0000\u0010\u0001\u0018\u0001*\u00060\u0002j\u0002`\u0003*\u0006\u0012\u0002\b\u00030\u0004H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a)\u0010\u0006\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001\u0018\u0001*\u00060\u0002j\u0002`\u0003*\u0006\u0012\u0002\b\u00030\u0004H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b*\u0006\u0012\u0002\b\u00030\u0004ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u0016\u0010\n\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u0004ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m444d2 = {"getCustomExceptionOrNull", "E", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Exception;", "getCustomExceptionOrThrow", "getInitializationExceptionOrNull", "Lcom/unity3d/services/core/domain/task/InitializationException;", "(Ljava/lang/Object;)Lcom/unity3d/services/core/domain/task/InitializationException;", "getInitializationExceptionOrThrow", "unity-ads_release"}, m445k = 2, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class ResultExtensionsKt {
    public static final /* synthetic */ <E extends Exception> E getCustomExceptionOrNull(Object obj) {
        Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(obj);
        Intrinsics.reifiedOperationMarker(3, "E");
        if (m748exceptionOrNullimpl instanceof Exception) {
            return (E) m748exceptionOrNullimpl;
        }
        return null;
    }

    public static final /* synthetic */ <E extends Exception> E getCustomExceptionOrThrow(Object obj) {
        Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(obj);
        Intrinsics.reifiedOperationMarker(3, "E");
        if (m748exceptionOrNullimpl instanceof Exception) {
            return (E) m748exceptionOrNullimpl;
        }
        throw new IllegalArgumentException("Wrong Exception type found");
    }

    public static final InitializationException getInitializationExceptionOrNull(Object obj) {
        Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(obj);
        if (m748exceptionOrNullimpl instanceof InitializationException) {
            return (InitializationException) m748exceptionOrNullimpl;
        }
        return null;
    }

    public static final InitializationException getInitializationExceptionOrThrow(Object obj) {
        Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(obj);
        if (m748exceptionOrNullimpl instanceof InitializationException) {
            return (InitializationException) m748exceptionOrNullimpl;
        }
        throw new IllegalArgumentException("Wrong Exception type found");
    }
}

// ===== FILE: com/unity3d/services/core/domain/SDKDispatchers.java =====
package com.unity3d.services.core.domain;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* compiled from: SDKDispatchers.kt */
@Metadata(m443d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, m444d2 = {"Lcom/unity3d/services/core/domain/SDKDispatchers;", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "()V", "default", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "io", "getIo", "main", "getMain", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class SDKDispatchers implements ISDKDispatchers {
    private final CoroutineDispatcher io = Dispatchers.getIO();
    private final CoroutineDispatcher default = Dispatchers.getDefault();
    private final CoroutineDispatcher main = Dispatchers.getMain();

    @Override // com.unity3d.services.core.domain.ISDKDispatchers
    public CoroutineDispatcher getIo() {
        return this.io;
    }

    @Override // com.unity3d.services.core.domain.ISDKDispatchers
    public CoroutineDispatcher getDefault() {
        return this.default;
    }

    @Override // com.unity3d.services.core.domain.ISDKDispatchers
    public CoroutineDispatcher getMain() {
        return this.main;
    }
}
