// Package bundle: com.unity3d.services.core.domain (3 classes)

// ============================================================
// CLASS: com.unity3d.services.core.domain.ISDKDispatchers
// ============================================================
package com.unity3d.services.core.domain;

public abstract class ISDKDispatchers {
    public abstract CoroutineDispatcher getDefault() {
        // native or abstract
    }

    public abstract CoroutineDispatcher getIo() {
        // native or abstract
    }

    public abstract CoroutineDispatcher getMain() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.ResultExtensionsKt
// ============================================================
package com.unity3d.services.core.domain;

public final class ResultExtensionsKt {
    public static final Exception getCustomExceptionOrNull(Object p0) {
        Result.exceptionOrNull-impl(p0);
        Intrinsics.reifiedOperationMarker(3, "E");
        if (if-eqz(3)) goto L_11;
      L_11:
      L_15:
        return 0;
    }

    public static final Exception getCustomExceptionOrThrow(Object p0) {
        Result.exceptionOrNull-impl(p0);
        Intrinsics.reifiedOperationMarker(3, "E");
        if (if-eqz(3)) goto L_11;
        return Result.exceptionOrNull-impl(..);
      L_11:
        new IllegalArgumentException("Wrong Exception type found");
        throw new IllegalArgumentException(..);
    }

    public static final InitializationException getInitializationExceptionOrNull(Object p0) {
        Result.exceptionOrNull-impl(p0);
        if (if-eqz(v0)) goto L_b;
      L_b:
      L_c:
        return 0;
    }

    public static final InitializationException getInitializationExceptionOrThrow(Object p0) {
        Result.exceptionOrNull-impl(p0);
        if (if-eqz(v0)) goto L_b;
        return Result.exceptionOrNull-impl(..);
      L_b:
        new IllegalArgumentException("Wrong Exception type found");
        throw new IllegalArgumentException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.SDKDispatchers
// ============================================================
package com.unity3d.services.core.domain;

public final class SDKDispatchers {
    private final CoroutineDispatcher default;
    private final CoroutineDispatcher io;
    private final CoroutineDispatcher main;

    public SDKDispatchers() {
        new Object();
        Dispatchers.getIO();
        io = Dispatchers.getIO(..);
        Dispatchers.getDefault();
        default = Dispatchers.getDefault(..);
        Dispatchers.getMain();
        main = Dispatchers.getMain(..);
        return;
    }

    public CoroutineDispatcher getDefault() {
        return default;
    }

    public CoroutineDispatcher getIo() {
        return io;
    }

    public CoroutineDispatcher getMain() {
        return main;
    }

}

