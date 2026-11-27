// Package bundle: com.unity3d.services.core.domain.task (67 classes)

// ============================================================
// CLASS: com.unity3d.services.core.domain.task.BaseParams
// ============================================================
package com.unity3d.services.core.domain.task;

public abstract class BaseParams {
}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.BaseTask
// ============================================================
package com.unity3d.services.core.domain.task;

public abstract class BaseTask {
    public abstract Object doWork-gIAlu-s(BaseParams p0, Continuation p1) {
        // native or abstract
    }

    public abstract Object invoke-gIAlu-s(BaseParams p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage
// ============================================================
package com.unity3d.services.core.domain.task;

public final class ConfigFileFromLocalStorage extends MetricTask {
    private final ISDKDispatchers dispatchers;

    public ConfigFileFromLocalStorage(ISDKDispatchers p0) {
        new MetricTask();
        dispatchers = p0;
        return;
    }

    public Object doWork-gIAlu-s(BaseParams p0, Continuation p1) {
        ConfigFileFromLocalStorage.doWork-gIAlu-s(p0, p1);
        return ConfigFileFromLocalStorage.doWork-gIAlu-s(..);
    }

    public Object doWork-gIAlu-s(ConfigFileFromLocalStorage$Params p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new ConfigFileFromLocalStorage$doWork$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        dispatchers.getIo();
        new ConfigFileFromLocalStorage$doWork$2(new IllegalStateException(..), 0);
        label = 1;
        BuildersKt.withContext(ISDKDispatchers.getIo(..), new ConfigFileFromLocalStorage$doWork$2(..), new ConfigFileFromLocalStorage$doWork$1(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4e:
        BuildersKt.withContext(..).unbox-impl();
        return Result.unbox-impl(..);
    }

    public String getMetricName() {
        ConfigFileFromLocalStorage.getMetricNameForInitializeTask("read_local_config");
        return ConfigFileFromLocalStorage.getMetricNameForInitializeTask(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.EmptyParams
// ============================================================
package com.unity3d.services.core.domain.task;

public final class EmptyParams {
    public static final EmptyParams INSTANCE;

    static <clinit>() {
        new EmptyParams();
        INSTANCE = new EmptyParams(..);
        return;
    }

    private EmptyParams() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializationException
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializationException extends Exception {
    private final Configuration config;
    private final ErrorState errorState;
    private final Exception originalException;

    public InitializationException(ErrorState p0, Exception p1, Configuration p2) {
        new Exception(p1);
        errorState = p0;
        originalException = p1;
        config = p2;
        return;
    }

    public static InitializationException copy$default(InitializationException p0, ErrorState p1, Exception p2, Configuration p3, int p4, Object p5) {
        if (if-eqz(p5)) goto L_6;
      L_6:
        if (if-eqz(p5)) goto L_c;
      L_c:
        if (if-eqz(p4)) goto L_12;
      L_12:
        p0.copy(errorState, originalException, config);
        return InitializationException.copy(..);
    }

    public final ErrorState component1() {
        return errorState;
    }

    public final Exception component2() {
        return originalException;
    }

    public final Configuration component3() {
        return config;
    }

    public final InitializationException copy(ErrorState p0, Exception p1, Configuration p2) {
        new InitializationException(p0, p1, p2);
        return new InitializationException(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        if (if-eq(errorState, errorState)) goto L_13;
        return 0;
      L_13:
        Intrinsics.areEqual(originalException, originalException);
        if (if-nez(Intrinsics.areEqual(..))) goto L_1e;
        return 0;
      L_1e:
        Intrinsics.areEqual(config, config);
        if (if-nez(Intrinsics.areEqual(..))) goto L_29;
        return 0;
      L_29:
        return 1;
    }

    public final Configuration getConfig() {
        return config;
    }

    public final ErrorState getErrorState() {
        return errorState;
    }

    public final Exception getOriginalException() {
        return originalException;
    }

    public int hashCode() {
        errorState.hashCode();
        originalException.hashCode();
        config.hashCode();
        return ErrorState.hashCode(..);
    }

    public String toString() {
        new StringBuilder("InitializationException(errorState=");
        new StringBuilder(..).append(errorState);
        new StringBuilder(..).append(", originalException=");
        new StringBuilder(..).append(originalException);
        new StringBuilder(..).append(", config=");
        new StringBuilder(..).append(config);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeSDK
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeSDK extends MetricTask {
    private final ConfigFileFromLocalStorage configFileFromLocalStorage;
    private final ISDKDispatchers dispatchers;
    private final InitializeStateComplete initializeStateComplete;
    private final InitializeStateConfig initializeStateConfig;
    private final InitializeStateCreate initializeStateCreate;
    private final InitializeStateError initializeStateError;
    private final InitializeStateLoadCache initializeStateLoadCache;
    private final InitializeStateLoadWeb initializeStateLoadWeb;
    private final InitializeStateReset initializeStateReset;

    public InitializeSDK(ISDKDispatchers p0, ConfigFileFromLocalStorage p1, InitializeStateReset p2, InitializeStateError p3, InitializeStateConfig p4, InitializeStateCreate p5, InitializeStateLoadCache p6, InitializeStateLoadWeb p7, InitializeStateComplete p8) {
        new MetricTask();
        dispatchers = p0;
        configFileFromLocalStorage = p1;
        initializeStateReset = p2;
        initializeStateError = p3;
        initializeStateConfig = p4;
        initializeStateCreate = p5;
        initializeStateLoadCache = p6;
        initializeStateLoadWeb = p7;
        initializeStateComplete = p8;
        return;
    }

    public static final Object access$executeErrorState-BWLJW6A(InitializeSDK p0, ErrorState p1, Throwable p2, Configuration p3, Continuation p4) {
        p0.executeErrorState-BWLJW6A(p1, p2, p3, p4);
        return InitializeSDK.executeErrorState-BWLJW6A(..);
    }

    public static final ConfigFileFromLocalStorage access$getConfigFileFromLocalStorage$p(InitializeSDK p0) {
        return configFileFromLocalStorage;
    }

    public static final InitializeStateComplete access$getInitializeStateComplete$p(InitializeSDK p0) {
        return initializeStateComplete;
    }

    public static final InitializeStateConfig access$getInitializeStateConfig$p(InitializeSDK p0) {
        return initializeStateConfig;
    }

    public static final InitializeStateCreate access$getInitializeStateCreate$p(InitializeSDK p0) {
        return initializeStateCreate;
    }

    public static final InitializeStateLoadCache access$getInitializeStateLoadCache$p(InitializeSDK p0) {
        return initializeStateLoadCache;
    }

    public static final InitializeStateLoadWeb access$getInitializeStateLoadWeb$p(InitializeSDK p0) {
        return initializeStateLoadWeb;
    }

    public static final InitializeStateReset access$getInitializeStateReset$p(InitializeSDK p0) {
        return initializeStateReset;
    }

    public static final Object access$handleInitializationException(InitializeSDK p0, InitializationException p1, Continuation p2) {
        p0.handleInitializationException(p1, p2);
        return InitializeSDK.handleInitializationException(..);
    }

    private final Object executeErrorState-BWLJW6A(ErrorState p0, Throwable p1, Configuration p2, Continuation p3) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new InitializeSDK$executeErrorState$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_38;
        if (if-ne(label, 1)) goto L_30;
        ResultKt.throwOnFailure(result);
        result.unbox-impl();
      L_30:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_38:
        ResultKt.throwOnFailure(result);
        if (if-eqz("call to 'resume' before 'invoke' with coroutine")) goto L_48;
        Throwable.getMessage();
      L_48:
      L_49:
        new Exception(0);
        new InitializeStateError$Params(new IllegalStateException(..), new Exception(..), p2);
        label = 1;
        initializeStateError.invoke-gIAlu-s(new InitializeStateError$Params(..), new InitializeSDK$executeErrorState$1(..));
        if (if-ne(InitializeStateError.invoke-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_5a;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_5a:
        return InitializeStateError.invoke-gIAlu-s(..);
    }

    private final Object handleInitializationException(InitializationException p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new InitializeSDK$handleInitializationException$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_3b;
        if (if-eq(label, 1)) goto L_2e;
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_2e:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        Result.unbox-impl();
      L_3b:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        L$0.getErrorState();
        L$0.getOriginalException();
        L$0.getConfig();
        L$0 = L$0;
        label = 1;
        InitializeSDK.executeErrorState-BWLJW6A(InitializationException.getErrorState(..), InitializationException.getOriginalException(..), InitializationException.getConfig(..), new InitializeSDK$handleInitializationException$1(..));
        if (if-ne(InitializeSDK.executeErrorState-BWLJW6A(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_57;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_57:
        throw L$0;
    }

    public Object doWork-gIAlu-s(BaseParams p0, Continuation p1) {
        InitializeSDK.doWork-gIAlu-s(p0, p1);
        return InitializeSDK.doWork-gIAlu-s(..);
    }

    public Object doWork-gIAlu-s(EmptyParams p0, Continuation p1) {
        if (if-eqz(p0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new InitializeSDK$doWork$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        dispatchers.getDefault();
        new InitializeSDK$doWork$2(this, 0);
        label = 1;
        BuildersKt.withContext(ISDKDispatchers.getDefault(..), new InitializeSDK$doWork$2(..), new IllegalStateException(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4e:
        BuildersKt.withContext(..).unbox-impl();
        return Result.unbox-impl(..);
    }

    public String getMetricName() {
        InitializeSDK.getMetricNameForInitializeTask("initialize");
        return InitializeSDK.getMetricNameForInitializeTask(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateComplete
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateComplete extends MetricTask {
    private final ISDKDispatchers dispatchers;

    public InitializeStateComplete(ISDKDispatchers p0) {
        new MetricTask();
        dispatchers = p0;
        return;
    }

    public Object doWork-gIAlu-s(BaseParams p0, Continuation p1) {
        InitializeStateComplete.doWork-gIAlu-s(p0, p1);
        return InitializeStateComplete.doWork-gIAlu-s(..);
    }

    public Object doWork-gIAlu-s(InitializeStateComplete$Params p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new InitializeStateComplete$doWork$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        dispatchers.getDefault();
        new InitializeStateComplete$doWork$2(new IllegalStateException(..), 0);
        label = 1;
        BuildersKt.withContext(ISDKDispatchers.getDefault(..), new InitializeStateComplete$doWork$2(..), new InitializeStateComplete$doWork$1(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4e:
        BuildersKt.withContext(..).unbox-impl();
        return Result.unbox-impl(..);
    }

    public String getMetricName() {
        InitializeStateComplete.getMetricNameForInitializeTask("completion");
        return InitializeStateComplete.getMetricNameForInitializeTask(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateConfig
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateConfig extends MetricTask {
    private final ISDKDispatchers dispatchers;
    private final InitializeStateConfigWithLoader initializeStateConfigWithLoader;

    public InitializeStateConfig(ISDKDispatchers p0, InitializeStateConfigWithLoader p1) {
        new MetricTask();
        dispatchers = p0;
        initializeStateConfigWithLoader = p1;
        return;
    }

    public static final InitializeStateConfigWithLoader access$getInitializeStateConfigWithLoader$p(InitializeStateConfig p0) {
        return initializeStateConfigWithLoader;
    }

    public Object doWork-gIAlu-s(BaseParams p0, Continuation p1) {
        InitializeStateConfig.doWork-gIAlu-s(p0, p1);
        return InitializeStateConfig.doWork-gIAlu-s(..);
    }

    public Object doWork-gIAlu-s(InitializeStateConfig$Params p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new InitializeStateConfig$doWork$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        dispatchers.getDefault();
        new InitializeStateConfig$doWork$2(new IllegalStateException(..), this, 0);
        label = 1;
        BuildersKt.withContext(ISDKDispatchers.getDefault(..), new InitializeStateConfig$doWork$2(..), new InitializeStateConfig$doWork$1(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4e:
        BuildersKt.withContext(..).unbox-impl();
        return Result.unbox-impl(..);
    }

    public String getMetricName() {
        InitializeStateConfig.getMetricNameForInitializeTask("config_fetch");
        return InitializeStateConfig.getMetricNameForInitializeTask(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateConfigWithLoader {
    private final ISDKDispatchers dispatchers;
    private final InitializeStateNetworkError initializeStateNetworkError;
    private final SDKMetricsSender sdkMetricsSender;
    private final TokenStorage tokenStorage;

    public InitializeStateConfigWithLoader(ISDKDispatchers p0, InitializeStateNetworkError p1, TokenStorage p2, SDKMetricsSender p3) {
        new Object();
        dispatchers = p0;
        initializeStateNetworkError = p1;
        tokenStorage = p2;
        sdkMetricsSender = p3;
        return;
    }

    public static final ISDKDispatchers access$getDispatchers$p(InitializeStateConfigWithLoader p0) {
        return dispatchers;
    }

    public static final InitializeStateNetworkError access$getInitializeStateNetworkError$p(InitializeStateConfigWithLoader p0) {
        return initializeStateNetworkError;
    }

    public static final SDKMetricsSender access$getSdkMetricsSender$p(InitializeStateConfigWithLoader p0) {
        return sdkMetricsSender;
    }

    public static final TokenStorage access$getTokenStorage$p(InitializeStateConfigWithLoader p0) {
        return tokenStorage;
    }

    public Object doWork-gIAlu-s(BaseParams p0, Continuation p1) {
        InitializeStateConfigWithLoader.doWork-gIAlu-s(p0, p1);
        return InitializeStateConfigWithLoader.doWork-gIAlu-s(..);
    }

    public Object doWork-gIAlu-s(InitializeStateConfigWithLoader$Params p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new InitializeStateConfigWithLoader$doWork$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        dispatchers.getDefault();
        new InitializeStateConfigWithLoader$doWork$2(this, new IllegalStateException(..), 0);
        label = 1;
        BuildersKt.withContext(ISDKDispatchers.getDefault(..), new InitializeStateConfigWithLoader$doWork$2(..), new InitializeStateConfigWithLoader$doWork$1(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4e:
        BuildersKt.withContext(..).unbox-impl();
        return Result.unbox-impl(..);
    }

    public IServiceProvider getServiceProvider() {
        BaseTask$DefaultImpls.getServiceProvider(this);
        return BaseTask$DefaultImpls.getServiceProvider(..);
    }

    public Object invoke-gIAlu-s(BaseParams p0, Continuation p1) {
        InitializeStateConfigWithLoader.invoke-gIAlu-s(p0, p1);
        return InitializeStateConfigWithLoader.invoke-gIAlu-s(..);
    }

    public Object invoke-gIAlu-s(InitializeStateConfigWithLoader$Params p0, Continuation p1) {
        BaseTask$DefaultImpls.invoke-gIAlu-s(this, p0, p1);
        return BaseTask$DefaultImpls.invoke-gIAlu-s(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateCreate
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateCreate extends MetricTask {
    private final ISDKDispatchers dispatchers;

    public InitializeStateCreate(ISDKDispatchers p0) {
        new MetricTask();
        dispatchers = p0;
        return;
    }

    public Object doWork-gIAlu-s(BaseParams p0, Continuation p1) {
        InitializeStateCreate.doWork-gIAlu-s(p0, p1);
        return InitializeStateCreate.doWork-gIAlu-s(..);
    }

    public Object doWork-gIAlu-s(InitializeStateCreate$Params p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new InitializeStateCreate$doWork$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        dispatchers.getDefault();
        new InitializeStateCreate$doWork$2(new IllegalStateException(..), 0);
        label = 1;
        BuildersKt.withContext(ISDKDispatchers.getDefault(..), new InitializeStateCreate$doWork$2(..), new InitializeStateCreate$doWork$1(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4e:
        BuildersKt.withContext(..).unbox-impl();
        return Result.unbox-impl(..);
    }

    public String getMetricName() {
        InitializeStateCreate.getMetricNameForInitializeTask("create_web_view");
        return InitializeStateCreate.getMetricNameForInitializeTask(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateError
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateError extends MetricTask {
    private final ISDKDispatchers dispatchers;

    public InitializeStateError(ISDKDispatchers p0) {
        new MetricTask();
        dispatchers = p0;
        return;
    }

    public Object doWork-gIAlu-s(BaseParams p0, Continuation p1) {
        InitializeStateError.doWork-gIAlu-s(p0, p1);
        return InitializeStateError.doWork-gIAlu-s(..);
    }

    public Object doWork-gIAlu-s(InitializeStateError$Params p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new InitializeStateError$doWork$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        dispatchers.getDefault();
        new InitializeStateError$doWork$2(new IllegalStateException(..), 0);
        label = 1;
        BuildersKt.withContext(ISDKDispatchers.getDefault(..), new InitializeStateError$doWork$2(..), new InitializeStateError$doWork$1(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4e:
        BuildersKt.withContext(..).unbox-impl();
        return Result.unbox-impl(..);
    }

    public String getMetricName() {
        InitializeStateError.getMetricNameForInitializeTask("error");
        return InitializeStateError.getMetricNameForInitializeTask(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateLoadCache
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateLoadCache extends MetricTask {
    private final ISDKDispatchers dispatchers;

    public InitializeStateLoadCache(ISDKDispatchers p0) {
        new MetricTask();
        dispatchers = p0;
        return;
    }

    public static final byte[] access$getWebViewData(InitializeStateLoadCache p0) {
        p0.getWebViewData();
        return InitializeStateLoadCache.getWebViewData(..);
    }

    private final byte[] getWebViewData() {
        SdkProperties.getLocalWebViewFile();
        new File(SdkProperties.getLocalWebViewFile(..));
        Utilities.readFileBytes(new File(..));
        new StringBuilder("Unity Ads init: webapp not found in local cache: ");
        Utilities.readFileBytes(..).getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
      L_25:
        return 0;
    }

    public Object doWork-gIAlu-s(BaseParams p0, Continuation p1) {
        InitializeStateLoadCache.doWork-gIAlu-s(p0, p1);
        return InitializeStateLoadCache.doWork-gIAlu-s(..);
    }

    public Object doWork-gIAlu-s(InitializeStateLoadCache$Params p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new InitializeStateLoadCache$doWork$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        dispatchers.getDefault();
        new InitializeStateLoadCache$doWork$2(this, new IllegalStateException(..), 0);
        label = 1;
        BuildersKt.withContext(ISDKDispatchers.getDefault(..), new InitializeStateLoadCache$doWork$2(..), new InitializeStateLoadCache$doWork$1(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4e:
        BuildersKt.withContext(..).unbox-impl();
        return Result.unbox-impl(..);
    }

    public String getMetricName() {
        InitializeStateLoadCache.getMetricNameForInitializeTask("read_local_webview");
        return InitializeStateLoadCache.getMetricNameForInitializeTask(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateLoadWeb
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateLoadWeb extends MetricTask {
    private final ISDKDispatchers dispatchers;
    private final HttpClient httpClient;
    private final InitializeStateNetworkError initializeStateNetworkError;

    public InitializeStateLoadWeb(ISDKDispatchers p0, InitializeStateNetworkError p1, HttpClient p2) {
        new MetricTask();
        dispatchers = p0;
        initializeStateNetworkError = p1;
        httpClient = p2;
        return;
    }

    public static final ISDKDispatchers access$getDispatchers$p(InitializeStateLoadWeb p0) {
        return dispatchers;
    }

    public static final HttpClient access$getHttpClient$p(InitializeStateLoadWeb p0) {
        return httpClient;
    }

    public static final InitializeStateNetworkError access$getInitializeStateNetworkError$p(InitializeStateLoadWeb p0) {
        return initializeStateNetworkError;
    }

    public Object doWork-gIAlu-s(BaseParams p0, Continuation p1) {
        InitializeStateLoadWeb.doWork-gIAlu-s(p0, p1);
        return InitializeStateLoadWeb.doWork-gIAlu-s(..);
    }

    public Object doWork-gIAlu-s(InitializeStateLoadWeb$Params p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new InitializeStateLoadWeb$doWork$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        dispatchers.getDefault();
        new InitializeStateLoadWeb$doWork$2(new IllegalStateException(..), this, 0);
        label = 1;
        BuildersKt.withContext(ISDKDispatchers.getDefault(..), new InitializeStateLoadWeb$doWork$2(..), new InitializeStateLoadWeb$doWork$1(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4e:
        BuildersKt.withContext(..).unbox-impl();
        return Result.unbox-impl(..);
    }

    public String getMetricName() {
        InitializeStateLoadWeb.getMetricNameForInitializeTask("download_web_view");
        return InitializeStateLoadWeb.getMetricNameForInitializeTask(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateNetworkError
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateNetworkError extends MetricTask {
    private int connectedEventThreshold;
    private Continuation continuation;
    private final ISDKDispatchers dispatchers;
    private long lastConnectedEventTimeMs;
    private int maximumConnectedEvents;
    private int receivedConnectedEvents;

    public InitializeStateNetworkError(ISDKDispatchers p0) {
        new MetricTask();
        dispatchers = p0;
        maximumConnectedEvents = 500;
        connectedEventThreshold = 10000;
        return;
    }

    public static final void access$setConnectedEventThreshold$p(InitializeStateNetworkError p0, int p1) {
        connectedEventThreshold = p1;
        return;
    }

    public static final void access$setMaximumConnectedEvents$p(InitializeStateNetworkError p0, int p1) {
        maximumConnectedEvents = p1;
        return;
    }

    public static final void access$startListening(InitializeStateNetworkError p0, Continuation p1) {
        p0.startListening(p1);
        return;
    }

    private final boolean shouldHandleConnectedEvent() {
        System.currentTimeMillis();
        if (if-ltz(System.currentTimeMillis(..))) goto L_16;
        if (if-gt(receivedConnectedEvents, maximumConnectedEvents)) goto L_16;
      L_16:
      L_17:
        return 0;
    }

    private final void startListening(Continuation p0) {
        continuation = p0;
        ConnectivityMonitor.addListener(this);
        return;
    }

    public Object doWork-gIAlu-s(BaseParams p0, Continuation p1) {
        InitializeStateNetworkError.doWork-gIAlu-s(p0, p1);
        return InitializeStateNetworkError.doWork-gIAlu-s(..);
    }

    public Object doWork-gIAlu-s(InitializeStateNetworkError$Params p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new InitializeStateNetworkError$doWork$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        dispatchers.getDefault();
        new InitializeStateNetworkError$doWork$2(this, new IllegalStateException(..), 0);
        label = 1;
        BuildersKt.withContext(ISDKDispatchers.getDefault(..), new InitializeStateNetworkError$doWork$2(..), new InitializeStateNetworkError$doWork$1(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4e:
        BuildersKt.withContext(..).unbox-impl();
        return Result.unbox-impl(..);
    }

    public String getMetricName() {
        InitializeStateNetworkError.getMetricNameForInitializeTask("error_network");
        return InitializeStateNetworkError.getMetricNameForInitializeTask(..);
    }

    public void onConnected() {
        receivedConnectedEvents = receivedConnectedEvents;
        DeviceLog.debug("Unity Ads init got connected event");
        InitializeStateNetworkError.shouldHandleConnectedEvent();
        if (if-eqz(InitializeStateNetworkError.shouldHandleConnectedEvent(..))) goto L_23;
        if (if-eqz(continuation)) goto L_20;
        Result.constructor-impl(Unit.INSTANCE);
        continuation.resumeWith(Result.constructor-impl(..));
      L_20:
        continuation = 0;
      L_23:
        if (if-le(receivedConnectedEvents, maximumConnectedEvents)) goto L_2f;
        ConnectivityMonitor.removeListener(this);
      L_2f:
        System.currentTimeMillis();
        lastConnectedEventTimeMs = System.currentTimeMillis(..);
        return;
    }

    public void onDisconnected() {
        DeviceLog.debug("Unity Ads init got disconnected event");
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateReset
// ============================================================
package com.unity3d.services.core.domain.task;

public class InitializeStateReset extends MetricTask {
    private final ISDKDispatchers dispatchers;

    public InitializeStateReset(ISDKDispatchers p0) {
        new MetricTask();
        dispatchers = p0;
        return;
    }

    public static final ISDKDispatchers access$getDispatchers$p(InitializeStateReset p0) {
        return dispatchers;
    }

    public static final void access$unregisterLifecycleCallbacks(InitializeStateReset p0) {
        p0.unregisterLifecycleCallbacks();
        return;
    }

    static Object doWork-gIAlu-s$suspendImpl(InitializeStateReset p0, InitializeStateReset$Params p1, Continuation p2) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new InitializeStateReset$doWork$1(p0, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure(result);
        dispatchers.getDefault();
        new InitializeStateReset$doWork$2("call to 'resume' before 'invoke' with coroutine", new IllegalStateException(..), 0);
        label = 1;
        BuildersKt.withContext(ISDKDispatchers.getDefault(..), new InitializeStateReset$doWork$2(..), new InitializeStateReset$doWork$1(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4e:
        BuildersKt.withContext(..).unbox-impl();
        return Result.unbox-impl(..);
    }

    private final void unregisterLifecycleCallbacks() {
        Lifecycle.getLifecycleListener();
        if (if-eqz(Lifecycle.getLifecycleListener(..))) goto L_19;
        ClientProperties.getApplication();
        if (if-eqz(ClientProperties.getApplication(..))) goto L_15;
        Lifecycle.getLifecycleListener();
        ClientProperties.getApplication(..).unregisterActivityLifecycleCallbacks(Lifecycle.getLifecycleListener(..));
      L_15:
        Lifecycle.setLifecycleListener(0);
      L_19:
        return;
    }

    public Object doWork-gIAlu-s(BaseParams p0, Continuation p1) {
        InitializeStateReset.doWork-gIAlu-s(p0, p1);
        return InitializeStateReset.doWork-gIAlu-s(..);
    }

    public Object doWork-gIAlu-s(InitializeStateReset$Params p0, Continuation p1) {
        InitializeStateReset.doWork-gIAlu-s$suspendImpl(this, p0, p1);
        return InitializeStateReset.doWork-gIAlu-s$suspendImpl(..);
    }

    public String getMetricName() {
        InitializeStateReset.getMetricNameForInitializeTask("reset");
        return InitializeStateReset.getMetricNameForInitializeTask(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.MetricTask
// ============================================================
package com.unity3d.services.core.domain.task;

public abstract class MetricTask {
    private long duration;
    private String taskStatus;

    public MetricTask() {
        new Object();
        taskStatus = "unknown";
        return;
    }

    private final void captureMetric(Object p0) {
        Result.isSuccess-impl(p0);
        if (if-eqz(Result.isSuccess-impl(..))) goto L_9;
      L_9:
      L_b:
        taskStatus = "failure";
        MetricTask.sendMetric();
        return;
    }

    private final Metric getMetric() {
        MetricTask.getMetricName();
        Long.valueOf(duration, v3);
        MetricTask.getMetricTagsForState();
        new Metric(MetricTask.getMetricName(..), Long.valueOf(..), MetricTask.getMetricTagsForState(..));
        return new Metric(..);
    }

    private final Map getMetricTagsForState() {
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.getRetryTags();
        return IInitializeEventsMetricSender.getRetryTags(..);
    }

    private final SDKMetricsSender getSDKMetrics() {
        IServiceComponent.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SDKMetricsSender.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

    private final int getStatePrefixLength() {
        return 15;
    }

    static Object invoke-gIAlu-s$suspendImpl(MetricTask p0, BaseParams p1, Continuation p2) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new MetricTask$invoke$1(p0, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_52;
        if (if-ne(label, 1)) goto L_4a;
        ResultKt.throwOnFailure(result);
        result.unbox-impl();
      L_4a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_52:
        ResultKt.throwOnFailure(Result.unbox-impl(..));
        new Ref$ObjectRef();
        System.nanoTime();
        L$0 = new IllegalStateException(..);
        L$1 = new Ref$ObjectRef(..);
        L$2 = new Ref$ObjectRef(..);
        L$3 = new IllegalStateException(..);
        L$4 = TimeUnit.NANOSECONDS;
        J$0 = System.nanoTime(..);
        label = L$2;
        BaseTask$DefaultImpls.invoke-gIAlu-s(new IllegalStateException(..), "call to 'resume' before 'invoke' with coroutine", L$0);
        if (if-ne(BaseTask$DefaultImpls.invoke-gIAlu-s(..), L$4)) goto L_75;
        return L$4;
      L_75:
      L_7a:
        element = BaseTask$DefaultImpls.invoke-gIAlu-s(..);
        System.nanoTime();
        TimeUnit.NANOSECONDS.toMillis(System.nanoTime(..), new Ref$ObjectRef(..));
        duration = TimeUnit.toMillis(..);
        new IllegalStateException(..).captureMetric(element);
        return element;
    }

    private final void sendMetric() {
        MetricTask.getMetricName();
        if (if-eqz(MetricTask.getMetricName(..))) goto L_11;
        MetricTask.getMetricName(..).length();
        if (if-nez(CharSequence.length(..))) goto L_f;
      L_f:
      L_11:
      L_12:
        if (if-eqz(1)) goto L_15;
        return;
      L_15:
        MetricTask.getSDKMetrics();
        MetricTask.getMetric();
        MetricTask.getSDKMetrics(..).sendMetric(MetricTask.getMetric(..));
        return;
    }

    public final long getDuration() {
        return duration;
    }

    public String getMetricName() {
        return 0;
    }

    public final String getMetricNameForInitializeTask(String p0) {
        new StringBuilder("native_");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append("_task_");
        new StringBuilder(..).append(taskStatus);
        new StringBuilder(..).append("_time");
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    public final String getMetricNameForTask(Object p0) {
        p0.getClass();
        Object.getClass(..).getSimpleName();
        Class.getSimpleName(..).length();
        if (if-nez(CharSequence.length(..))) goto L_1d;
      L_1d:
      L_1e:
        if (if-eqz(0)) goto L_22;
        return 0;
      L_22:
        MetricTask.getStatePrefixLength();
        0.substring(MetricTask.getStatePrefixLength(..));
        String.substring(..).toLowerCase(Locale.ROOT);
        String.toLowerCase(..).length();
        new StringBuilder(7);
        new StringBuilder(..).append("native_");
        new StringBuilder(..).append(String.toLowerCase(..));
        new StringBuilder(..).append("_state");
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    public IServiceProvider getServiceProvider() {
        BaseTask$DefaultImpls.getServiceProvider(this);
        return BaseTask$DefaultImpls.getServiceProvider(..);
    }

    public final String getTaskStatus() {
        return taskStatus;
    }

    public Object invoke-gIAlu-s(BaseParams p0, Continuation p1) {
        MetricTask.invoke-gIAlu-s$suspendImpl(this, p0, p1);
        return MetricTask.invoke-gIAlu-s$suspendImpl(..);
    }

    public final void setDuration(long p0) {
        duration = p0;
        return;
    }

    public final void setTaskStatus(String p0) {
        taskStatus = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.BaseTask$DefaultImpls
// ============================================================
package com.unity3d.services.core.domain.task;

public final class BaseTask$DefaultImpls {
    public static IServiceProvider getServiceProvider(BaseTask p0) {
        IServiceComponent$DefaultImpls.getServiceProvider(p0);
        return IServiceComponent$DefaultImpls.getServiceProvider(..);
    }

    public static Object invoke-gIAlu-s(BaseTask p0, BaseParams p1, Continuation p2) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new BaseTask$invoke$1(label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_38;
        if (if-ne(label, 1)) goto L_30;
        ResultKt.throwOnFailure(result);
        result.unbox-impl();
      L_30:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_38:
        ResultKt.throwOnFailure(result);
        label = 1;
        new IllegalStateException(..).doWork-gIAlu-s("call to 'resume' before 'invoke' with coroutine", new BaseTask$invoke$1(..));
        if (if-ne(BaseTask.doWork-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_44;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_44:
        return BaseTask.doWork-gIAlu-s(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.BaseTask$invoke$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class BaseTask$invoke$1 extends ContinuationImpl {
    int label;
    Object result;

    BaseTask$invoke$1(Continuation p0) {
        new ContinuationImpl(p0);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        BaseTask$DefaultImpls.invoke-gIAlu-s(0, 0, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(BaseTask$DefaultImpls.invoke-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_18;
        return BaseTask$DefaultImpls.invoke-gIAlu-s(..);
      L_18:
        Result.box-impl(BaseTask$DefaultImpls.invoke-gIAlu-s(..));
        return Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$Params
// ============================================================
package com.unity3d.services.core.domain.task;

public final class ConfigFileFromLocalStorage$Params {
    private final Configuration defaultConfiguration;

    public ConfigFileFromLocalStorage$Params() {
        new ConfigFileFromLocalStorage$Params(0, 1, 0);
        return;
    }

    public ConfigFileFromLocalStorage$Params(Configuration p0) {
        new Object();
        defaultConfiguration = p0;
        return;
    }

    public ConfigFileFromLocalStorage$Params(Configuration p0, int p1, DefaultConstructorMarker p2) {
        if (if-eqz(p1)) goto L_9;
        new Configuration();
      L_9:
        new ConfigFileFromLocalStorage$Params(new Configuration(..));
        return;
    }

    public final Configuration getDefaultConfiguration() {
        return defaultConfiguration;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$doWork$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class ConfigFileFromLocalStorage$doWork$1 extends ContinuationImpl {
    int label;
    Object result;
    final ConfigFileFromLocalStorage this$0;

    ConfigFileFromLocalStorage$doWork$1(ConfigFileFromLocalStorage p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.doWork-gIAlu-s(0, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(ConfigFileFromLocalStorage.doWork-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a;
        return ConfigFileFromLocalStorage.doWork-gIAlu-s(..);
      L_1a:
        Result.box-impl(ConfigFileFromLocalStorage.doWork-gIAlu-s(..));
        return Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$doWork$2
// ============================================================
package com.unity3d.services.core.domain.task;

final class ConfigFileFromLocalStorage$doWork$2 extends SuspendLambda {
    final ConfigFileFromLocalStorage$Params $params;
    int label;

    ConfigFileFromLocalStorage$doWork$2(ConfigFileFromLocalStorage$Params p0, Continuation p1) {
        $params = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new ConfigFileFromLocalStorage$doWork$2($params, p1);
        return new ConfigFileFromLocalStorage$doWork$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        ConfigFileFromLocalStorage$doWork$2.invoke(p0, p1);
        return ConfigFileFromLocalStorage$doWork$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        ConfigFileFromLocalStorage$doWork$2.create(p0, p1);
        ConfigFileFromLocalStorage$doWork$2.invokeSuspend(Unit.INSTANCE);
        return ConfigFileFromLocalStorage$doWork$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_66;
        ResultKt.throwOnFailure(p0);
        SdkProperties.getLocalConfigurationFilepath();
        new File(SdkProperties.getLocalConfigurationFilepath(..));
        new File(..).exists();
        if (if-nez(File.exists(..))) goto L_22;
        $params.getDefaultConfiguration();
      L_22:
        FilesKt.readText$default(new File(..), 0, 1, 0);
        new JSONObject(FilesKt.readText$default(..));
        new Configuration(new JSONObject(..));
      L_32:
        Result.constructor-impl(new Configuration(..));
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_42:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_4f;
        Result.constructor-impl(Result.constructor-impl(..));
      L_4f:
        Result.exceptionOrNull-impl(Result.constructor-impl(..));
        if (if-eqz(Result.exceptionOrNull-impl(..))) goto L_5f;
        ResultKt.createFailure(Result.exceptionOrNull-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_5f:
        Result.box-impl(Result.constructor-impl(..));
        return Result.box-impl(..);
        throw Result.box-impl(..);
      L_66:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeSDK$doWork$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeSDK$doWork$1 extends ContinuationImpl {
    int label;
    Object result;
    final InitializeSDK this$0;

    InitializeSDK$doWork$1(InitializeSDK p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.doWork-gIAlu-s(0, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(InitializeSDK.doWork-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a;
        return InitializeSDK.doWork-gIAlu-s(..);
      L_1a:
        Result.box-impl(InitializeSDK.doWork-gIAlu-s(..));
        return Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeSDK$doWork$2
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeSDK$doWork$2 extends SuspendLambda {
    private Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final InitializeSDK this$0;

    InitializeSDK$doWork$2(InitializeSDK p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeSDK$doWork$2(this$0, p1);
        L$0 = p0;
        return new InitializeSDK$doWork$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeSDK$doWork$2.invoke(p0, p1);
        return InitializeSDK$doWork$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeSDK$doWork$2.create(p0, p1);
        InitializeSDK$doWork$2.create(..).invokeSuspend(Unit.INSTANCE);
        return InitializeSDK$doWork$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
        ResultKt.throwOnFailure(new IllegalStateException(..));
        new IllegalStateException(..).unbox-impl();
        ResultKt.throwOnFailure(Result.unbox-impl(..));
        ResultKt.throwOnFailure(Result.unbox-impl(..));
        Result.unbox-impl(..).unbox-impl();
        ResultKt.throwOnFailure(Result.unbox-impl(..));
        ResultKt.throwOnFailure(Result.unbox-impl(..));
        Result.unbox-impl(..).unbox-impl();
      L_59:
        ResultKt.throwOnFailure(Result.unbox-impl(..));
        Result.unbox-impl(..).unbox-impl();
        ResultKt.throwOnFailure(Result.unbox-impl(..));
        Result.unbox-impl(..).unbox-impl();
      L_7f:
        ResultKt.throwOnFailure(L$3);
        ResultKt.throwOnFailure(L$3);
        L$3.unbox-impl();
        ResultKt.throwOnFailure(Result.unbox-impl(..));
        Result.unbox-impl(..).unbox-impl();
        ResultKt.throwOnFailure(Result.unbox-impl(..));
        Result.unbox-impl(..).unbox-impl();
      L_d2:
        ResultKt.throwOnFailure(L$2);
        L$2.unbox-impl();
        ResultKt.throwOnFailure(Result.unbox-impl(..));
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.didInitStart();
        CachedLifecycle.register();
        DeviceLog.debug("Unity Ads Init: Loading Config File From Local Storage");
        InitializeSDK.access$getConfigFileFromLocalStorage$p(this$0);
        new ConfigFileFromLocalStorage$Params(0, 1, 0);
        L$0 = L$0;
        L$1 = this$0;
        label = 1;
        ConfigFileFromLocalStorage.invoke-gIAlu-s(new ConfigFileFromLocalStorage$Params(..), this);
        if (if-ne(ConfigFileFromLocalStorage.invoke-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_11c;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_11c:
      L_11f:
        Result.exceptionOrNull-impl(ConfigFileFromLocalStorage.invoke-gIAlu-s(..));
        if (if-eqz(Result.exceptionOrNull-impl(..))) goto L_138;
        new StringBuilder(Result.unbox-impl(..));
        Result.exceptionOrNull-impl(..).getMessage();
        new StringBuilder(..).append(Throwable.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
      L_138:
        new Configuration();
        Result.isFailure-impl(ConfigFileFromLocalStorage.invoke-gIAlu-s(..));
        if (if-eqz(Result.isFailure-impl(..))) goto L_144;
      L_144:
        InitializeSDK.access$getInitializeStateReset$p(this$0);
        new InitializeStateReset$Params(new Configuration(..));
        L$0 = L$0;
        L$1 = this$0;
        L$2 = new Configuration(..);
        label = 2;
        InitializeStateReset.invoke-gIAlu-s(new InitializeStateReset$Params(..), this);
        if (if-ne(InitializeStateReset.invoke-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_d2;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_162:
        Result.isFailure-impl(new Configuration(..));
        if (if-eqz(Result.isFailure-impl(..))) goto L_192;
        Result.exceptionOrNull-impl(new Configuration(..));
        L$0 = new Configuration(..);
        L$1 = 0;
        L$2 = 0;
        label = 3;
        InitializeSDK.access$executeErrorState-BWLJW6A(this$0, ErrorState.ResetWebApp, Result.exceptionOrNull-impl(..), InitializeStateReset.invoke-gIAlu-s(..), this);
        if (if-ne(InitializeSDK.access$executeErrorState-BWLJW6A(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_17e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_17e:
        Result.exceptionOrNull-impl(new Configuration(..));
        if (if-nez(Result.exceptionOrNull-impl(..))) goto L_191;
        ErrorState.ResetWebApp.toString();
        new Exception(ErrorState.toString(..));
      L_191:
        throw new Exception(..);
      L_192:
        InitializeSDK.access$getInitializeStateConfig$p(this$0);
        new InitializeStateConfig$Params(new Exception(..));
        L$0 = ErrorState.ResetWebApp;
        L$1 = this$0;
        L$2 = new Exception(..);
        label = 4;
        InitializeStateConfig.invoke-gIAlu-s(new InitializeStateConfig$Params(..), this);
        if (if-ne(InitializeStateConfig.invoke-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1ad;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_1ad:
      L_1b1:
        Result.isFailure-impl(InitializeStateConfig.invoke-gIAlu-s(..));
        if (if-eqz(Result.isFailure-impl(..))) goto L_1cd;
        ResultExtensionsKt.getInitializationExceptionOrThrow(InitializeStateConfig.invoke-gIAlu-s(..));
        L$0 = ErrorState.ResetWebApp;
        L$1 = this$0;
        L$2 = InitializeStateConfig.invoke-gIAlu-s(..);
        L$3 = new Exception(..);
        label = 5;
        InitializeSDK.access$handleInitializationException(this$0, ResultExtensionsKt.getInitializationExceptionOrThrow(..), this);
        if (if-ne(InitializeSDK.access$handleInitializationException(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1cd;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_1cd:
        InitializeSDK.access$getInitializeStateLoadCache$p(this$0);
        ResultKt.throwOnFailure(InitializeStateConfig.invoke-gIAlu-s(..));
        new InitializeStateLoadCache$Params(InitializeStateConfig.invoke-gIAlu-s(..));
        L$0 = ErrorState.ResetWebApp;
        L$1 = this$0;
        L$2 = InitializeStateConfig.invoke-gIAlu-s(..);
        L$3 = new Exception(..);
        label = 6;
        InitializeStateLoadCache.invoke-gIAlu-s(new InitializeStateLoadCache$Params(..), this);
        if (if-ne(InitializeStateLoadCache.invoke-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_7f;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_1f0:
        Result.isFailure-impl(new Exception(..));
        if (if-eqz(Result.isFailure-impl(..))) goto L_222;
        Result.exceptionOrNull-impl(new Exception(..));
        L$0 = new Exception(..);
        L$1 = 3;
        L$2 = 3;
        L$3 = 3;
        label = 7;
        InitializeSDK.access$executeErrorState-BWLJW6A(this$0, ErrorState.LoadCache, Result.exceptionOrNull-impl(..), InitializeStateLoadCache.invoke-gIAlu-s(..), this);
        if (if-ne(InitializeSDK.access$executeErrorState-BWLJW6A(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_20e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_20e:
        Result.exceptionOrNull-impl(new Exception(..));
        if (if-nez(Result.exceptionOrNull-impl(..))) goto L_221;
        ErrorState.LoadCache.toString();
        new Exception(ErrorState.toString(..));
      L_221:
        throw new Exception(..);
      L_222:
        ResultKt.throwOnFailure(ErrorState.toString(..));
        ErrorState.toString(..).getHasHashMismatch();
        if (if-eqz(InitializeStateLoadCache$LoadCacheResult.getHasHashMismatch(..))) goto L_2a3;
        new Exception(..).getExperiments();
        Configuration.getExperiments(..).isWebViewAsyncDownloadEnabled();
        if (if-eqz(IExperiments.isWebViewAsyncDownloadEnabled(..))) goto L_25a;
        ErrorState.toString(..).getWebViewData();
        if (if-eqz(InitializeStateLoadCache$LoadCacheResult.getWebViewData(..))) goto L_25a;
        new CoroutineName("LaunchLoadWeb");
        new InitializeSDK$doWork$2$1$webViewData$1(this$0, ErrorState.LoadCache, 7);
        BuildersKt.launch$default(Result.exceptionOrNull-impl(..), new CoroutineName(..), 0, new InitializeSDK$doWork$2$1$webViewData$1(..), 2, 0);
        ErrorState.toString(..).getWebViewData();
      L_25a:
        InitializeSDK.access$getInitializeStateLoadWeb$p(this$0);
        ResultKt.throwOnFailure(ErrorState.LoadCache);
        new InitializeStateLoadWeb$Params(ErrorState.LoadCache);
        L$0 = this$0;
        L$1 = ErrorState.LoadCache;
        L$2 = 7;
        L$3 = 7;
        label = 8;
        InitializeStateLoadWeb.invoke-gIAlu-s(new InitializeStateLoadWeb$Params(..), this);
        if (if-ne(InitializeStateLoadWeb.invoke-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_59;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_27e:
        Result.isFailure-impl(new InitializeStateLoadWeb$Params(..));
        if (if-eqz(Result.isFailure-impl(..))) goto L_299;
        ResultExtensionsKt.getInitializationExceptionOrThrow(new InitializeStateLoadWeb$Params(..));
        L$0 = this$0;
        L$1 = ErrorState.LoadCache;
        L$2 = new InitializeStateLoadWeb$Params(..);
        label = 9;
        InitializeSDK.access$handleInitializationException(this$0, ResultExtensionsKt.getInitializationExceptionOrThrow(..), this);
        if (if-ne(InitializeSDK.access$handleInitializationException(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_299;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_299:
        ResultKt.throwOnFailure(new InitializeStateLoadWeb$Params(..));
        InitializeStateLoadWeb$LoadWebResult.getWebViewDataString();
      L_2a3:
        InitializeStateLoadCache$LoadCacheResult.getWebViewData();
        if (if-eqz(InitializeStateLoadCache$LoadCacheResult.getWebViewData(..))) goto L_311;
      L_2a9:
        InitializeSDK.access$getInitializeStateCreate$p(this$0);
        ResultKt.throwOnFailure(ErrorState.LoadCache);
        new InitializeStateCreate$Params(ErrorState.LoadCache, InitializeStateLoadCache$LoadCacheResult.getWebViewData(..));
        L$0 = this$0;
        L$1 = ErrorState.LoadCache;
        L$2 = 7;
        L$3 = 7;
        label = 10;
        InitializeStateCreate.invoke-gIAlu-s(new InitializeStateCreate$Params(..), this);
        if (if-ne(InitializeStateCreate.invoke-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_2cd;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_2cd:
      L_2cf:
        Result.isFailure-impl(InitializeStateCreate.invoke-gIAlu-s(..));
        if (if-eqz(Result.isFailure-impl(..))) goto L_2e8;
        ResultExtensionsKt.getInitializationExceptionOrThrow(InitializeStateCreate.invoke-gIAlu-s(..));
        L$0 = this$0;
        L$1 = ErrorState.LoadCache;
        label = 11;
        InitializeSDK.access$handleInitializationException(this$0, ResultExtensionsKt.getInitializationExceptionOrThrow(..), this);
        if (if-ne(InitializeSDK.access$handleInitializationException(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_2e8;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_2e8:
        InitializeSDK.access$getInitializeStateComplete$p(this$0);
        ResultKt.throwOnFailure(ErrorState.LoadCache);
        new InitializeStateComplete$Params(ErrorState.LoadCache);
        L$0 = 7;
        L$1 = 7;
        label = 12;
        InitializeStateComplete.invoke-gIAlu-s(new InitializeStateComplete$Params(..), this);
        if (if-ne(InitializeStateComplete.invoke-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_307;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_307:
        ResultKt.throwOnFailure(InitializeStateComplete.invoke-gIAlu-s(..));
        Result.constructor-impl(Unit.INSTANCE);
      L_311:
        "WebView is missing.".toString();
        new IllegalStateException(Object.toString(..));
        throw new IllegalStateException(..);
        ResultKt.createFailure(Object.toString(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_328:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_335;
        Result.constructor-impl(Result.constructor-impl(..));
      L_335:
        Result.exceptionOrNull-impl(Result.constructor-impl(..));
        if (if-eqz(Result.exceptionOrNull-impl(..))) goto L_345;
        ResultKt.createFailure(Result.exceptionOrNull-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_345:
        Result.box-impl(Result.constructor-impl(..));
        return Result.box-impl(..);
        throw Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeSDK$doWork$2$1$webViewData$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeSDK$doWork$2$1$webViewData$1 extends SuspendLambda {
    final Object $configResult;
    int label;
    final InitializeSDK this$0;

    InitializeSDK$doWork$2$1$webViewData$1(InitializeSDK p0, Object p1, Continuation p2) {
        this$0 = p0;
        $configResult = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeSDK$doWork$2$1$webViewData$1(this$0, $configResult, p1);
        return new InitializeSDK$doWork$2$1$webViewData$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeSDK$doWork$2$1$webViewData$1.invoke(p0, p1);
        return InitializeSDK$doWork$2$1$webViewData$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeSDK$doWork$2$1$webViewData$1.create(p0, p1);
        InitializeSDK$doWork$2$1$webViewData$1.invokeSuspend(Unit.INSTANCE);
        return InitializeSDK$doWork$2$1$webViewData$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_1c;
        if (if-ne(label, 1)) goto L_14;
        ResultKt.throwOnFailure(p0);
        p0.unbox-impl();
      L_14:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1c:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        InitializeSDK.access$getInitializeStateLoadWeb$p(this$0);
        ResultKt.throwOnFailure($configResult);
        new InitializeStateLoadWeb$Params($configResult);
        label = 1;
        InitializeStateLoadWeb.invoke-gIAlu-s(new InitializeStateLoadWeb$Params(..), this);
        if (if-ne(InitializeStateLoadWeb.invoke-gIAlu-s(..), "call to 'resume' before 'invoke' with coroutine")) goto L_3f;
        return "call to 'resume' before 'invoke' with coroutine";
      L_3f:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeSDK$executeErrorState$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeSDK$executeErrorState$1 extends ContinuationImpl {
    int label;
    Object result;
    final InitializeSDK this$0;

    InitializeSDK$executeErrorState$1(InitializeSDK p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        InitializeSDK.access$executeErrorState-BWLJW6A(this$0, 0, 0, 0, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(InitializeSDK.access$executeErrorState-BWLJW6A(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a;
        return InitializeSDK.access$executeErrorState-BWLJW6A(..);
      L_1a:
        Result.box-impl(InitializeSDK.access$executeErrorState-BWLJW6A(..));
        return Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeSDK$handleInitializationException$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final InitializeSDK this$0;

    InitializeSDK$handleInitializationException$1(InitializeSDK p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        InitializeSDK.access$handleInitializationException(this$0, 0, this);
        return InitializeSDK.access$handleInitializationException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateComplete$Params
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateComplete$Params {
    private final Configuration config;

    public InitializeStateComplete$Params(Configuration p0) {
        new Object();
        config = p0;
        return;
    }

    public static InitializeStateComplete$Params copy$default(InitializeStateComplete$Params p0, Configuration p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        p0.copy(config);
        return InitializeStateComplete$Params.copy(..);
    }

    public final Configuration component1() {
        return config;
    }

    public final InitializeStateComplete$Params copy(Configuration p0) {
        new InitializeStateComplete$Params(p0);
        return new InitializeStateComplete$Params(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(config, config);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        return 1;
    }

    public final Configuration getConfig() {
        return config;
    }

    public int hashCode() {
        config.hashCode();
        return Configuration.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Params(config=");
        new StringBuilder(..).append(config);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateComplete$doWork$1 extends ContinuationImpl {
    int label;
    Object result;
    final InitializeStateComplete this$0;

    InitializeStateComplete$doWork$1(InitializeStateComplete p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.doWork-gIAlu-s(0, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(InitializeStateComplete.doWork-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a;
        return InitializeStateComplete.doWork-gIAlu-s(..);
      L_1a:
        Result.box-impl(InitializeStateComplete.doWork-gIAlu-s(..));
        return Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$2
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateComplete$doWork$2 extends SuspendLambda {
    final InitializeStateComplete$Params $params;
    int label;

    InitializeStateComplete$doWork$2(InitializeStateComplete$Params p0, Continuation p1) {
        $params = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateComplete$doWork$2($params, p1);
        return new InitializeStateComplete$doWork$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateComplete$doWork$2.invoke(p0, p1);
        return InitializeStateComplete$doWork$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateComplete$doWork$2.create(p0, p1);
        InitializeStateComplete$doWork$2.invokeSuspend(Unit.INSTANCE);
        return InitializeStateComplete$doWork$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_6f;
        ResultKt.throwOnFailure(p0);
        $params.getConfig();
        Configuration.getModuleConfigurationList();
      L_1d:
        if (if-ge(0, "params.config.moduleConfigurationList")) goto L_39;
        $params.getConfig();
        Configuration.getModuleConfiguration(v3);
        if (if-eqz(Configuration.getModuleConfiguration(..))) goto L_36;
        $params.getConfig();
        IModuleConfiguration.initCompleteState(InitializeStateComplete$Params.getConfig(..));
        Boxing.boxBoolean(IModuleConfiguration.initCompleteState(..));
      L_36:
      L_39:
        Result.constructor-impl(Unit.INSTANCE);
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_4b:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_58;
        Result.constructor-impl(Result.constructor-impl(..));
      L_58:
        Result.exceptionOrNull-impl(Result.constructor-impl(..));
        if (if-eqz(Result.exceptionOrNull-impl(..))) goto L_68;
        ResultKt.createFailure(Result.exceptionOrNull-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_68:
        Result.box-impl(Result.constructor-impl(..));
        return Result.box-impl(..);
        throw Result.box-impl(..);
      L_6f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateConfig$Params
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateConfig$Params {
    private final Configuration config;

    public InitializeStateConfig$Params(Configuration p0) {
        new Object();
        config = p0;
        return;
    }

    public static InitializeStateConfig$Params copy$default(InitializeStateConfig$Params p0, Configuration p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        p0.copy(config);
        return InitializeStateConfig$Params.copy(..);
    }

    public final Configuration component1() {
        return config;
    }

    public final InitializeStateConfig$Params copy(Configuration p0) {
        new InitializeStateConfig$Params(p0);
        return new InitializeStateConfig$Params(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(config, config);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        return 1;
    }

    public final Configuration getConfig() {
        return config;
    }

    public int hashCode() {
        config.hashCode();
        return Configuration.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Params(config=");
        new StringBuilder(..).append(config);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateConfig$doWork$1 extends ContinuationImpl {
    int label;
    Object result;
    final InitializeStateConfig this$0;

    InitializeStateConfig$doWork$1(InitializeStateConfig p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.doWork-gIAlu-s(0, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(InitializeStateConfig.doWork-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a;
        return InitializeStateConfig.doWork-gIAlu-s(..);
      L_1a:
        Result.box-impl(InitializeStateConfig.doWork-gIAlu-s(..));
        return Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$2
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateConfig$doWork$2 extends SuspendLambda {
    final InitializeStateConfig$Params $params;
    Object L$0;
    int label;
    final InitializeStateConfig this$0;

    InitializeStateConfig$doWork$2(InitializeStateConfig$Params p0, InitializeStateConfig p1, Continuation p2) {
        $params = p0;
        this$0 = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateConfig$doWork$2($params, this$0, p1);
        return new InitializeStateConfig$doWork$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateConfig$doWork$2.invoke(p0, p1);
        return InitializeStateConfig$doWork$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateConfig$doWork$2.create(p0, p1);
        InitializeStateConfig$doWork$2.invokeSuspend(Unit.INSTANCE);
        return InitializeStateConfig$doWork$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_25;
        if (if-ne(label, 1)) goto L_1d;
        ResultKt.throwOnFailure(p0);
        p0.unbox-impl();
      L_1d:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_25:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        new StringBuilder("call to 'resume' before 'invoke' with coroutine");
        SdkProperties.getConfigUrl();
        new StringBuilder(..).append(SdkProperties.getConfigUrl(..));
        new StringBuilder(..).toString();
        DeviceLog.info(StringBuilder.toString(..));
        SdkProperties.getConfigUrl();
        $params.getConfig();
        Configuration.getExperimentsReader();
        new Configuration(SdkProperties.getConfigUrl(..), Configuration.getExperimentsReader(..));
        InitializeStateConfig.access$getInitializeStateConfigWithLoader$p(this$0);
        new InitializeStateConfigWithLoader$Params(new Configuration(..));
        L$0 = new Configuration(..);
        label = 1;
        InitializeStateConfigWithLoader.invoke-gIAlu-s(new InitializeStateConfigWithLoader$Params(..), this);
        if (if-ne(InitializeStateConfigWithLoader.invoke-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_68;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_68:
        ResultKt.throwOnFailure(InitializeStateConfigWithLoader.invoke-gIAlu-s(..));
        Result.constructor-impl(InitializeStateConfigWithLoader.invoke-gIAlu-s(..));
      L_72:
        new InitializationException(ErrorState.NetworkConfigRequest, Result.constructor-impl(..), new Configuration(..));
        throw new InitializationException(..);
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_87:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_94;
        Result.constructor-impl(Result.constructor-impl(..));
      L_94:
        Result.exceptionOrNull-impl(Result.constructor-impl(..));
        if (if-eqz(Result.exceptionOrNull-impl(..))) goto L_a4;
        ResultKt.createFailure(Result.exceptionOrNull-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_a4:
        Result.box-impl(Result.constructor-impl(..));
        return Result.box-impl(..);
        throw Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateConfigWithLoader$Params {
    private final Configuration config;

    public InitializeStateConfigWithLoader$Params(Configuration p0) {
        new Object();
        config = p0;
        return;
    }

    public static InitializeStateConfigWithLoader$Params copy$default(InitializeStateConfigWithLoader$Params p0, Configuration p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        p0.copy(config);
        return InitializeStateConfigWithLoader$Params.copy(..);
    }

    public final Configuration component1() {
        return config;
    }

    public final InitializeStateConfigWithLoader$Params copy(Configuration p0) {
        new InitializeStateConfigWithLoader$Params(p0);
        return new InitializeStateConfigWithLoader$Params(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(config, config);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        return 1;
    }

    public final Configuration getConfig() {
        return config;
    }

    public int hashCode() {
        config.hashCode();
        return Configuration.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Params(config=");
        new StringBuilder(..).append(config);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateConfigWithLoader$doWork$1 extends ContinuationImpl {
    int label;
    Object result;
    final InitializeStateConfigWithLoader this$0;

    InitializeStateConfigWithLoader$doWork$1(InitializeStateConfigWithLoader p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.doWork-gIAlu-s(0, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(InitializeStateConfigWithLoader.doWork-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a;
        return InitializeStateConfigWithLoader.doWork-gIAlu-s(..);
      L_1a:
        Result.box-impl(InitializeStateConfigWithLoader.doWork-gIAlu-s(..));
        return Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateConfigWithLoader$doWork$2 extends SuspendLambda {
    final InitializeStateConfigWithLoader$Params $params;
    private Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final InitializeStateConfigWithLoader this$0;

    InitializeStateConfigWithLoader$doWork$2(InitializeStateConfigWithLoader p0, InitializeStateConfigWithLoader$Params p1, Continuation p2) {
        this$0 = p0;
        $params = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateConfigWithLoader$doWork$2(this$0, $params, p1);
        L$0 = p0;
        return new InitializeStateConfigWithLoader$doWork$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateConfigWithLoader$doWork$2.invoke(p0, p1);
        return InitializeStateConfigWithLoader$doWork$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateConfigWithLoader$doWork$2.create(p0, p1);
        InitializeStateConfigWithLoader$doWork$2.invokeSuspend(Unit.INSTANCE);
        return InitializeStateConfigWithLoader$doWork$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_73;
        if (if-eq(label, 1)) goto L_53;
        if (if-eq(label, 2)) goto L_2a;
        if (if-ne(label, 3)) goto L_22;
        ResultKt.throwOnFailure(p0);
      L_22:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_2a:
        ResultKt.throwOnFailure(p0);
        p0.unbox-impl();
      L_53:
        ResultKt.throwOnFailure(p0);
      L_73:
        ResultKt.throwOnFailure(p0);
        PrivacyConfigStorage.getInstance();
        InitializeStateConfigWithLoader.access$getSdkMetricsSender$p(this$0);
        new DeviceInfoDataFactory(InitializeStateConfigWithLoader.access$getSdkMetricsSender$p(..));
        new Ref$ObjectRef();
        $params.getConfig();
        new DeviceInfoDataFactory(..).getDeviceInfoData(InitRequestType.TOKEN);
        new ConfigurationRequestFactory(InitializeStateConfigWithLoader$Params.getConfig(..), DeviceInfoDataFactory.getDeviceInfoData(..));
        InitializeStateConfigWithLoader.access$getSdkMetricsSender$p(this$0);
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(HttpClient.class);
        IServiceProvider.getRegistry(..).getService(L$0, Reflection.getOrCreateKotlinClass(..));
        new ConfigurationLoader(new ConfigurationRequestFactory(..), InitializeStateConfigWithLoader.access$getSdkMetricsSender$p(..), IServicesRegistry.getService(..));
        element = new ConfigurationLoader(..);
        $params.getConfig();
        new DeviceInfoDataFactory(..).getDeviceInfoData(InitRequestType.PRIVACY);
        new ConfigurationRequestFactory(InitializeStateConfigWithLoader$Params.getConfig(..), DeviceInfoDataFactory.getDeviceInfoData(..));
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(HttpClient.class);
        IServiceProvider.getRegistry(..).getService(L$0, Reflection.getOrCreateKotlinClass(..));
        new PrivacyConfigurationLoader(element, new ConfigurationRequestFactory(..), PrivacyConfigStorage.getInstance(..), IServicesRegistry.getService(..));
        element = new PrivacyConfigurationLoader(..);
        new Ref$ObjectRef();
        new Configuration();
        element = new Configuration(..);
        $params.getConfig();
        Configuration.getMaxRetries();
        $params.getConfig();
        Configuration.getRetryScalingFactor();
        $params.getConfig();
        Configuration.getRetryDelay();
        new Exception();
        $params.getConfig();
        new InitializationException(ErrorState.NetworkConfigRequest, new Exception(..), InitializeStateConfigWithLoader$Params.getConfig(..));
        new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1(this$0, new Ref$ObjectRef(..), new Ref$ObjectRef(..), 0);
        L$0 = L$0;
        L$1 = this$0;
        L$2 = $params;
        L$3 = new Ref$ObjectRef(..);
        L$4 = new Ref$ObjectRef(..);
        label = 1;
        TaskExtensionsKt.withRetry(Configuration.getRetryDelay(..), new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1(..), Configuration.getMaxRetries(..), Configuration.getRetryScalingFactor(..), new PrivacyConfigurationLoader(..), new InitializationException(..), new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1(..), this);
        if (if-ne(TaskExtensionsKt.withRetry(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14f;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_14f:
      L_153:
        Result.constructor-impl(Unit.INSTANCE);
      L_15e:
      L_162:
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_16c:
        Result.isFailure-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isFailure-impl(..))) goto L_21d;
        Result.exceptionOrNull-impl(Result.constructor-impl(..));
        if (if-nez(Result.isFailure-impl(..))) goto L_20f;
        InitializeStateConfigWithLoader.access$getInitializeStateNetworkError$p(this$0);
        $params.getConfig();
        new InitializeStateNetworkError$Params(InitializeStateConfigWithLoader$Params.getConfig(..));
        L$0 = this$0;
        L$1 = $params;
        L$2 = this;
        L$3 = new Ref$ObjectRef(..);
        L$4 = new Ref$ObjectRef(..);
        label = 2;
        InitializeStateNetworkError.invoke-gIAlu-s(new InitializeStateNetworkError$Params(..), this);
        if (if-ne(InitializeStateNetworkError.invoke-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a2;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_1a2:
      L_1a3:
        Result.box-impl(InitializeStateNetworkError.invoke-gIAlu-s(..));
        Result.constructor-impl(Result.box-impl(..));
      L_1ae:
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_1b8:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_1fc;
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.onRetryConfig();
        InitializeStateConfigWithLoader.access$getDispatchers$p(this$0);
        ISDKDispatchers.getIo();
        new InitializeStateConfigWithLoader$doWork$2$1$1(this, new Ref$ObjectRef(..), this$0, $params, 0);
        L$0 = new Ref$ObjectRef(..);
        L$1 = new Ref$ObjectRef(..);
        L$2 = 0;
        L$3 = 0;
        L$4 = 0;
        label = 3;
        BuildersKt.withContext(ISDKDispatchers.getIo(..), new InitializeStateConfigWithLoader$doWork$2$1$1, this);
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1f0;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_1f0:
      L_1f2:
      L_1fc:
        new Exception("No connected events within the timeout!");
        $params.getConfig();
        new InitializationException(ErrorState.NetworkConfigRequest, new Exception(..), InitializeStateConfigWithLoader$Params.getConfig(..));
        throw new InitializationException(..);
      L_20f:
        new Ref$ObjectRef(..).getConfig();
        new InitializationException(ErrorState.NetworkConfigRequest, new InitializationException(..), InitializeStateConfigWithLoader$Params.getConfig(..));
        throw new InitializationException(..);
      L_21d:
      L_223:
        element = element;
        Result.constructor-impl(element);
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_239:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_246;
        Result.constructor-impl(Result.constructor-impl(..));
      L_246:
        Result.exceptionOrNull-impl(Result.constructor-impl(..));
        if (if-eqz(Result.exceptionOrNull-impl(..))) goto L_256;
        ResultKt.createFailure(Result.exceptionOrNull-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_256:
        Result.box-impl(Result.constructor-impl(..));
        return Result.box-impl(..);
        throw Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateConfigWithLoader$doWork$2$1$1 extends SuspendLambda {
    final Ref$ObjectRef $config;
    final Ref$ObjectRef $configurationLoader;
    final InitializeStateConfigWithLoader$Params $params;
    int label;
    final InitializeStateConfigWithLoader this$0;

    InitializeStateConfigWithLoader$doWork$2$1$1(Ref$ObjectRef p0, Ref$ObjectRef p1, InitializeStateConfigWithLoader p2, InitializeStateConfigWithLoader$Params p3, Continuation p4) {
        $configurationLoader = p0;
        $config = p1;
        this$0 = p2;
        $params = p3;
        new SuspendLambda(2, p4);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateConfigWithLoader$doWork$2$1$1($configurationLoader, $config, this$0, $params, p1);
        return new InitializeStateConfigWithLoader$doWork$2$1$1;
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateConfigWithLoader$doWork$2$1$1.invoke(p0, p1);
        return InitializeStateConfigWithLoader$doWork$2$1$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateConfigWithLoader$doWork$2$1$1.create(p0, p1);
        InitializeStateConfigWithLoader$doWork$2$1$1.invokeSuspend(Unit.INSTANCE);
        return InitializeStateConfigWithLoader$doWork$2$1$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_23;
        ResultKt.throwOnFailure(p0);
        new InitializeStateConfigWithLoader$doWork$2$1$1$1($config, this$0, $params);
        element.loadConfiguration(new InitializeStateConfigWithLoader$doWork$2$1$1$1(..));
        return Unit.INSTANCE;
      L_23:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$1$1
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateConfigWithLoader$doWork$2$1$1$1 {
    final Ref$ObjectRef $config;
    final InitializeStateConfigWithLoader$Params $params;
    final InitializeStateConfigWithLoader this$0;

    InitializeStateConfigWithLoader$doWork$2$1$1$1(Ref$ObjectRef p0, InitializeStateConfigWithLoader p1, InitializeStateConfigWithLoader$Params p2) {
        $config = p0;
        this$0 = p1;
        $params = p2;
        new Object();
        return;
    }

    public void onError(String p0) {
        InitializeStateConfigWithLoader.access$getSdkMetricsSender$p(this$0);
        TSIMetric.newEmergencySwitchOff();
        SDKMetricsSender.sendMetric(TSIMetric.newEmergencySwitchOff(..));
        new Exception(p0);
        $params.getConfig();
        new InitializationException(ErrorState.NetworkConfigRequest, new Exception(..), InitializeStateConfigWithLoader$Params.getConfig(..));
        throw new InitializationException(..);
    }

    public void onSuccess(Configuration p0) {
        element = p0;
        element.saveToDisk();
        InitializeStateConfigWithLoader.access$getTokenStorage$p(this$0);
        element.getUnifiedAuctionToken();
        TokenStorage.setInitToken(Configuration.getUnifiedAuctionToken(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1 extends SuspendLambda {
    final Ref$ObjectRef $config;
    final Ref$ObjectRef $configurationLoader;
    int I$0;
    int label;
    final InitializeStateConfigWithLoader this$0;

    InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1(InitializeStateConfigWithLoader p0, Ref$ObjectRef p1, Ref$ObjectRef p2, Continuation p3) {
        this$0 = p0;
        $configurationLoader = p1;
        $config = p2;
        new SuspendLambda(2, p3);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1(this$0, $configurationLoader, $config, p1);
        p0.intValue();
        I$0 = Number.intValue(..);
        return new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1(..);
    }

    public final Object invoke(int p0, Continuation p1) {
        Integer.valueOf(p0);
        InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1.create(Integer.valueOf(..), p1);
        InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1.invokeSuspend(Unit.INSTANCE);
        return InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1.invokeSuspend(..);
    }

    public Object invoke(Object p0, Object p1) {
        p0.intValue();
        InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1.invoke(Number.intValue(..), p1);
        return InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1.invoke(..);
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
        if (if-lez(I$0)) goto L_25;
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.onRetryConfig();
      L_25:
        InitializeStateConfigWithLoader.access$getDispatchers$p(this$0);
        ISDKDispatchers.getIo();
        new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1($configurationLoader, $config, this$0, 0);
        label = 1;
        BuildersKt.withContext(ISDKDispatchers.getIo(..), new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1(..), this);
        if (if-ne(BuildersKt.withContext(..), "call to 'resume' before 'invoke' with coroutine")) goto L_4b;
        return "call to 'resume' before 'invoke' with coroutine";
      L_4b:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1 extends SuspendLambda {
    final Ref$ObjectRef $config;
    final Ref$ObjectRef $configurationLoader;
    int label;
    final InitializeStateConfigWithLoader this$0;

    InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1(Ref$ObjectRef p0, Ref$ObjectRef p1, InitializeStateConfigWithLoader p2, Continuation p3) {
        $configurationLoader = p0;
        $config = p1;
        this$0 = p2;
        new SuspendLambda(2, p3);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1($configurationLoader, $config, this$0, p1);
        return new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1.invoke(p0, p1);
        return InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1.create(p0, p1);
        InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1.invokeSuspend(Unit.INSTANCE);
        return InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_21;
        ResultKt.throwOnFailure(p0);
        new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1$1($config, this$0);
        element.loadConfiguration(new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1$1(..));
        return Unit.INSTANCE;
      L_21:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1$1
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1$1 {
    final Ref$ObjectRef $config;
    final InitializeStateConfigWithLoader this$0;

    InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1$1(Ref$ObjectRef p0, InitializeStateConfigWithLoader p1) {
        $config = p0;
        this$0 = p1;
        new Object();
        return;
    }

    public void onError(String p0) {
        InitializeStateConfigWithLoader.access$getSdkMetricsSender$p(this$0);
        TSIMetric.newEmergencySwitchOff();
        SDKMetricsSender.sendMetric(TSIMetric.newEmergencySwitchOff(..));
        new AbortRetryException(p0);
        throw new AbortRetryException(..);
    }

    public void onSuccess(Configuration p0) {
        element = p0;
        element.saveToDisk();
        InitializeStateConfigWithLoader.access$getTokenStorage$p(this$0);
        element.getUnifiedAuctionToken();
        TokenStorage.setInitToken(Configuration.getUnifiedAuctionToken(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateCreate$Params
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateCreate$Params {
    private final Configuration config;
    private final String webViewData;

    public InitializeStateCreate$Params(Configuration p0, String p1) {
        new Object();
        config = p0;
        webViewData = p1;
        return;
    }

    public static InitializeStateCreate$Params copy$default(InitializeStateCreate$Params p0, Configuration p1, String p2, int p3, Object p4) {
        if (if-eqz(p4)) goto L_6;
      L_6:
        if (if-eqz(p3)) goto L_c;
      L_c:
        p0.copy(config, webViewData);
        return InitializeStateCreate$Params.copy(..);
    }

    public final Configuration component1() {
        return config;
    }

    public final String component2() {
        return webViewData;
    }

    public final InitializeStateCreate$Params copy(Configuration p0, String p1) {
        new InitializeStateCreate$Params(p0, p1);
        return new InitializeStateCreate$Params(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(config, config);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        Intrinsics.areEqual(webViewData, webViewData);
        if (if-nez(Intrinsics.areEqual(..))) goto L_22;
        return 0;
      L_22:
        return 1;
    }

    public final Configuration getConfig() {
        return config;
    }

    public final String getWebViewData() {
        return webViewData;
    }

    public int hashCode() {
        config.hashCode();
        webViewData.hashCode();
        return Configuration.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Params(config=");
        new StringBuilder(..).append(config);
        new StringBuilder(..).append(", webViewData=");
        new StringBuilder(..).append(webViewData);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateCreate$doWork$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateCreate$doWork$1 extends ContinuationImpl {
    int label;
    Object result;
    final InitializeStateCreate this$0;

    InitializeStateCreate$doWork$1(InitializeStateCreate p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.doWork-gIAlu-s(0, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(InitializeStateCreate.doWork-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a;
        return InitializeStateCreate.doWork-gIAlu-s(..);
      L_1a:
        Result.box-impl(InitializeStateCreate.doWork-gIAlu-s(..));
        return Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateCreate$doWork$2
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateCreate$doWork$2 extends SuspendLambda {
    final InitializeStateCreate$Params $params;
    int label;

    InitializeStateCreate$doWork$2(InitializeStateCreate$Params p0, Continuation p1) {
        $params = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateCreate$doWork$2($params, p1);
        return new InitializeStateCreate$doWork$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateCreate$doWork$2.invoke(p0, p1);
        return InitializeStateCreate$doWork$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateCreate$doWork$2.create(p0, p1);
        InitializeStateCreate$doWork$2.invokeSuspend(Unit.INSTANCE);
        return InitializeStateCreate$doWork$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_8e;
        ResultKt.throwOnFailure(p0);
        DeviceLog.debug("Unity Ads init: creating webapp");
        $params.getConfig();
        $params.getWebViewData();
        Configuration.setWebViewData(InitializeStateCreate$Params.getWebViewData(..));
        WebViewApp.create(InitializeStateCreate$Params.getConfig(..), 0);
        if (if-nez(WebViewApp.create(..))) goto L_2a;
        Result.constructor-impl(InitializeStateCreate$Params.getConfig(..));
      L_2a:
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getWebAppFailureMessage();
        if (if-eqz(WebViewApp.getWebAppFailureMessage(..))) goto L_3e;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getWebAppFailureMessage();
      L_3e:
        DeviceLog.error(WebViewApp.getWebAppFailureMessage(..));
        new Exception(WebViewApp.getWebAppFailureMessage(..));
        new InitializationException(Result.constructor-impl(..), new Exception(..), InitializeStateCreate$Params.getConfig(..));
        throw new InitializationException(..);
        DeviceLog.exception("Illegal Thread", Result.constructor-impl(..));
        new InitializationException(ErrorState.CreateWebApp, Result.constructor-impl(..), InitializeStateCreate$Params.getConfig(..));
        throw new InitializationException(..);
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_6a:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_77;
        Result.constructor-impl(Result.constructor-impl(..));
      L_77:
        Result.exceptionOrNull-impl(Result.constructor-impl(..));
        if (if-eqz(Result.exceptionOrNull-impl(..))) goto L_87;
        ResultKt.createFailure(Result.exceptionOrNull-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_87:
        Result.box-impl(Result.constructor-impl(..));
        return Result.box-impl(..);
        throw Result.box-impl(..);
      L_8e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateError$Params
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateError$Params {
    private final Configuration config;
    private final ErrorState errorState;
    private final Exception exception;

    public InitializeStateError$Params(ErrorState p0, Exception p1, Configuration p2) {
        new Object();
        errorState = p0;
        exception = p1;
        config = p2;
        return;
    }

    public static InitializeStateError$Params copy$default(InitializeStateError$Params p0, ErrorState p1, Exception p2, Configuration p3, int p4, Object p5) {
        if (if-eqz(p5)) goto L_6;
      L_6:
        if (if-eqz(p5)) goto L_c;
      L_c:
        if (if-eqz(p4)) goto L_12;
      L_12:
        p0.copy(errorState, exception, config);
        return InitializeStateError$Params.copy(..);
    }

    public final ErrorState component1() {
        return errorState;
    }

    public final Exception component2() {
        return exception;
    }

    public final Configuration component3() {
        return config;
    }

    public final InitializeStateError$Params copy(ErrorState p0, Exception p1, Configuration p2) {
        new InitializeStateError$Params(p0, p1, p2);
        return new InitializeStateError$Params(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        if (if-eq(errorState, errorState)) goto L_13;
        return 0;
      L_13:
        Intrinsics.areEqual(exception, exception);
        if (if-nez(Intrinsics.areEqual(..))) goto L_1e;
        return 0;
      L_1e:
        Intrinsics.areEqual(config, config);
        if (if-nez(Intrinsics.areEqual(..))) goto L_29;
        return 0;
      L_29:
        return 1;
    }

    public final Configuration getConfig() {
        return config;
    }

    public final ErrorState getErrorState() {
        return errorState;
    }

    public final Exception getException() {
        return exception;
    }

    public int hashCode() {
        errorState.hashCode();
        exception.hashCode();
        config.hashCode();
        return ErrorState.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Params(errorState=");
        new StringBuilder(..).append(errorState);
        new StringBuilder(..).append(", exception=");
        new StringBuilder(..).append(exception);
        new StringBuilder(..).append(", config=");
        new StringBuilder(..).append(config);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateError$doWork$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateError$doWork$1 extends ContinuationImpl {
    int label;
    Object result;
    final InitializeStateError this$0;

    InitializeStateError$doWork$1(InitializeStateError p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.doWork-gIAlu-s(0, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(InitializeStateError.doWork-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a;
        return InitializeStateError.doWork-gIAlu-s(..);
      L_1a:
        Result.box-impl(InitializeStateError.doWork-gIAlu-s(..));
        return Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateError$doWork$2
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateError$doWork$2 extends SuspendLambda {
    final InitializeStateError$Params $params;
    int label;

    InitializeStateError$doWork$2(InitializeStateError$Params p0, Continuation p1) {
        $params = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateError$doWork$2($params, p1);
        return new InitializeStateError$doWork$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateError$doWork$2.invoke(p0, p1);
        return InitializeStateError$doWork$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateError$doWork$2.create(p0, p1);
        InitializeStateError$doWork$2.invokeSuspend(Unit.INSTANCE);
        return InitializeStateError$doWork$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_a3;
        ResultKt.throwOnFailure(p0);
        new StringBuilder("Unity Ads init: halting init in ");
        $params.getErrorState();
        ErrorState.getMetricName();
        new StringBuilder(..).append(ErrorState.getMetricName(..));
        new StringBuilder(..).append(": ");
        $params.getException();
        Exception.getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
        $params.getConfig();
        Configuration.getModuleConfigurationList();
        if (if-nez(Configuration.getModuleConfigurationList(..))) goto L_44;
      L_44:
      L_45:
        if (if-ge(0, v2)) goto L_6d;
        $params.getConfig();
        Configuration.getModuleConfiguration(v3);
        if (if-eqz(Configuration.getModuleConfiguration(..))) goto L_6a;
        $params.getConfig();
        $params.getErrorState();
        $params.getException();
        Exception.getMessage();
        IModuleConfiguration.initErrorState(InitializeStateError$Params.getConfig(..), InitializeStateError$Params.getErrorState(..), Exception.getMessage(..));
        Boxing.boxBoolean(IModuleConfiguration.initErrorState(..));
      L_6a:
      L_6d:
        Result.constructor-impl(Unit.INSTANCE);
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_7f:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_8c;
        Result.constructor-impl(Result.constructor-impl(..));
      L_8c:
        Result.exceptionOrNull-impl(Result.constructor-impl(..));
        if (if-eqz(Result.exceptionOrNull-impl(..))) goto L_9c;
        ResultKt.createFailure(Result.exceptionOrNull-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_9c:
        Result.box-impl(Result.constructor-impl(..));
        return Result.box-impl(..);
        throw Result.box-impl(..);
      L_a3:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateLoadCache$LoadCacheResult
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateLoadCache$LoadCacheResult {
    private final boolean hasHashMismatch;
    private final String webViewData;

    public InitializeStateLoadCache$LoadCacheResult(boolean p0, String p1) {
        new Object();
        hasHashMismatch = p0;
        webViewData = p1;
        return;
    }

    public InitializeStateLoadCache$LoadCacheResult(boolean p0, String p1, int p2, DefaultConstructorMarker p3) {
        if (if-eqz(p2)) goto L_5;
      L_5:
        new InitializeStateLoadCache$LoadCacheResult(p0, 0);
        return;
    }

    public static InitializeStateLoadCache$LoadCacheResult copy$default(InitializeStateLoadCache$LoadCacheResult p0, boolean p1, String p2, int p3, Object p4) {
        if (if-eqz(p4)) goto L_6;
      L_6:
        if (if-eqz(p3)) goto L_c;
      L_c:
        p0.copy(hasHashMismatch, webViewData);
        return InitializeStateLoadCache$LoadCacheResult.copy(..);
    }

    public final boolean component1() {
        return hasHashMismatch;
    }

    public final String component2() {
        return webViewData;
    }

    public final InitializeStateLoadCache$LoadCacheResult copy(boolean p0, String p1) {
        new InitializeStateLoadCache$LoadCacheResult(p0, p1);
        return new InitializeStateLoadCache$LoadCacheResult(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        if (if-eq(hasHashMismatch, hasHashMismatch)) goto L_13;
        return 0;
      L_13:
        Intrinsics.areEqual(webViewData, webViewData);
        if (if-nez(Intrinsics.areEqual(..))) goto L_1e;
        return 0;
      L_1e:
        return 1;
    }

    public final boolean getHasHashMismatch() {
        return hasHashMismatch;
    }

    public final String getWebViewData() {
        return webViewData;
    }

    public int hashCode() {
        if (if-eqz(hasHashMismatch)) goto L_5;
      L_5:
        if (if-nez(webViewData)) goto L_d;
      L_d:
        0.hashCode();
      L_11:
        return 1;
    }

    public String toString() {
        new StringBuilder("LoadCacheResult(hasHashMismatch=");
        new StringBuilder(..).append(hasHashMismatch);
        new StringBuilder(..).append(", webViewData=");
        new StringBuilder(..).append(webViewData);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateLoadCache$Params
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateLoadCache$Params {
    private final Configuration config;

    public InitializeStateLoadCache$Params(Configuration p0) {
        new Object();
        config = p0;
        return;
    }

    public static InitializeStateLoadCache$Params copy$default(InitializeStateLoadCache$Params p0, Configuration p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        p0.copy(config);
        return InitializeStateLoadCache$Params.copy(..);
    }

    public final Configuration component1() {
        return config;
    }

    public final InitializeStateLoadCache$Params copy(Configuration p0) {
        new InitializeStateLoadCache$Params(p0);
        return new InitializeStateLoadCache$Params(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(config, config);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        return 1;
    }

    public final Configuration getConfig() {
        return config;
    }

    public int hashCode() {
        config.hashCode();
        return Configuration.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Params(config=");
        new StringBuilder(..).append(config);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateLoadCache$doWork$1 extends ContinuationImpl {
    int label;
    Object result;
    final InitializeStateLoadCache this$0;

    InitializeStateLoadCache$doWork$1(InitializeStateLoadCache p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.doWork-gIAlu-s(0, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(InitializeStateLoadCache.doWork-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a;
        return InitializeStateLoadCache.doWork-gIAlu-s(..);
      L_1a:
        Result.box-impl(InitializeStateLoadCache.doWork-gIAlu-s(..));
        return Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$2
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateLoadCache$doWork$2 extends SuspendLambda {
    final InitializeStateLoadCache$Params $params;
    int label;
    final InitializeStateLoadCache this$0;

    InitializeStateLoadCache$doWork$2(InitializeStateLoadCache p0, InitializeStateLoadCache$Params p1, Continuation p2) {
        this$0 = p0;
        $params = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateLoadCache$doWork$2(this$0, $params, p1);
        return new InitializeStateLoadCache$doWork$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateLoadCache$doWork$2.invoke(p0, p1);
        return InitializeStateLoadCache$doWork$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateLoadCache$doWork$2.create(p0, p1);
        InitializeStateLoadCache$doWork$2.invokeSuspend(Unit.INSTANCE);
        return InitializeStateLoadCache$doWork$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_92;
        ResultKt.throwOnFailure(p0);
        DeviceLog.debug("Unity Ads init: check if webapp can be loaded from local cache");
        InitializeStateLoadCache.access$getWebViewData(this$0);
        if (if-nez(InitializeStateLoadCache.access$getWebViewData(..))) goto L_24;
        new InitializeStateLoadCache$LoadCacheResult(1, 0, 2, 0);
      L_24:
        Utilities.Sha256(new InitializeStateLoadCache$LoadCacheResult(..));
        Charset.forName("UTF-8");
        new String(new InitializeStateLoadCache$LoadCacheResult(..), Charset.forName(..));
        if (if-eqz(Utilities.Sha256(..))) goto L_4c;
        2.getConfig();
        Configuration.getWebViewHash();
        Intrinsics.areEqual(Utilities.Sha256(..), Configuration.getWebViewHash(..));
        if (if-nez(Intrinsics.areEqual(..))) goto L_4a;
      L_4a:
      L_4c:
      L_4d:
        if (if-nez(1)) goto L_54;
        DeviceLog.info("Unity Ads init: webapp loaded from local cache");
      L_54:
        if (if-eqz(1)) goto L_59;
      L_59:
      L_5a:
        new InitializeStateLoadCache$LoadCacheResult(0, new String(..));
      L_5e:
        Result.constructor-impl(new InitializeStateLoadCache$LoadCacheResult(..));
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_6e:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_7b;
        Result.constructor-impl(Result.constructor-impl(..));
      L_7b:
        Result.exceptionOrNull-impl(Result.constructor-impl(..));
        if (if-eqz(Result.exceptionOrNull-impl(..))) goto L_8b;
        ResultKt.createFailure(Result.exceptionOrNull-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_8b:
        Result.box-impl(Result.constructor-impl(..));
        return Result.box-impl(..);
        throw Result.box-impl(..);
      L_92:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$LoadWebResult
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateLoadWeb$LoadWebResult {
    private final Configuration config;
    private final String webViewDataString;

    public InitializeStateLoadWeb$LoadWebResult(Configuration p0, String p1) {
        new Object();
        config = p0;
        webViewDataString = p1;
        return;
    }

    public static InitializeStateLoadWeb$LoadWebResult copy$default(InitializeStateLoadWeb$LoadWebResult p0, Configuration p1, String p2, int p3, Object p4) {
        if (if-eqz(p4)) goto L_6;
      L_6:
        if (if-eqz(p3)) goto L_c;
      L_c:
        p0.copy(config, webViewDataString);
        return InitializeStateLoadWeb$LoadWebResult.copy(..);
    }

    public final Configuration component1() {
        return config;
    }

    public final String component2() {
        return webViewDataString;
    }

    public final InitializeStateLoadWeb$LoadWebResult copy(Configuration p0, String p1) {
        new InitializeStateLoadWeb$LoadWebResult(p0, p1);
        return new InitializeStateLoadWeb$LoadWebResult(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(config, config);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        Intrinsics.areEqual(webViewDataString, webViewDataString);
        if (if-nez(Intrinsics.areEqual(..))) goto L_22;
        return 0;
      L_22:
        return 1;
    }

    public final Configuration getConfig() {
        return config;
    }

    public final String getWebViewDataString() {
        return webViewDataString;
    }

    public int hashCode() {
        config.hashCode();
        webViewDataString.hashCode();
        return Configuration.hashCode(..);
    }

    public String toString() {
        new StringBuilder("LoadWebResult(config=");
        new StringBuilder(..).append(config);
        new StringBuilder(..).append(", webViewDataString=");
        new StringBuilder(..).append(webViewDataString);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateLoadWeb$Params {
    private final Configuration config;

    public InitializeStateLoadWeb$Params(Configuration p0) {
        new Object();
        config = p0;
        return;
    }

    public static InitializeStateLoadWeb$Params copy$default(InitializeStateLoadWeb$Params p0, Configuration p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        p0.copy(config);
        return InitializeStateLoadWeb$Params.copy(..);
    }

    public final Configuration component1() {
        return config;
    }

    public final InitializeStateLoadWeb$Params copy(Configuration p0) {
        new InitializeStateLoadWeb$Params(p0);
        return new InitializeStateLoadWeb$Params(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(config, config);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        return 1;
    }

    public final Configuration getConfig() {
        return config;
    }

    public int hashCode() {
        config.hashCode();
        return Configuration.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Params(config=");
        new StringBuilder(..).append(config);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateLoadWeb$doWork$1 extends ContinuationImpl {
    int label;
    Object result;
    final InitializeStateLoadWeb this$0;

    InitializeStateLoadWeb$doWork$1(InitializeStateLoadWeb p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.doWork-gIAlu-s(0, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(InitializeStateLoadWeb.doWork-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a;
        return InitializeStateLoadWeb.doWork-gIAlu-s(..);
      L_1a:
        Result.box-impl(InitializeStateLoadWeb.doWork-gIAlu-s(..));
        return Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateLoadWeb$doWork$2 extends SuspendLambda {
    final InitializeStateLoadWeb$Params $params;
    private Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final InitializeStateLoadWeb this$0;

    InitializeStateLoadWeb$doWork$2(InitializeStateLoadWeb$Params p0, InitializeStateLoadWeb p1, Continuation p2) {
        $params = p0;
        this$0 = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateLoadWeb$doWork$2($params, this$0, p1);
        L$0 = p0;
        return new InitializeStateLoadWeb$doWork$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateLoadWeb$doWork$2.invoke(p0, p1);
        return InitializeStateLoadWeb$doWork$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateLoadWeb$doWork$2.create(p0, p1);
        InitializeStateLoadWeb$doWork$2.invokeSuspend(Unit.INSTANCE);
        return InitializeStateLoadWeb$doWork$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_66;
        if (if-eq(label, 1)) goto L_49;
        if (if-eq(label, 2)) goto L_2a;
        if (if-ne(label, 3)) goto L_22;
        ResultKt.throwOnFailure(p0);
      L_22:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_2a:
        ResultKt.throwOnFailure(p0);
        p0.unbox-impl();
      L_49:
        ResultKt.throwOnFailure(p0);
      L_66:
        ResultKt.throwOnFailure(p0);
        new StringBuilder(p0);
        $params.getConfig();
        Configuration.getWebViewUrl();
        new StringBuilder(..).append(Configuration.getWebViewUrl(..));
        new StringBuilder(..).toString();
        DeviceLog.info(StringBuilder.toString(..));
        $params.getConfig();
        Configuration.getWebViewUrl();
        new HttpRequest(Configuration.getWebViewUrl(..), 0, RequestType.GET, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        $params.getConfig();
        Configuration.getMaxRetries();
        $params.getConfig();
        Configuration.getRetryScalingFactor();
        $params.getConfig();
        Configuration.getRetryDelay();
        new Exception();
        $params.getConfig();
        new InitializationException(ErrorState.NetworkWebviewRequest, new Exception(..), InitializeStateLoadWeb$Params.getConfig(..));
        new InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1(this$0, new HttpRequest, 0);
        L$0 = L$0;
        L$1 = $params;
        L$2 = this$0;
        L$3 = new HttpRequest;
        label = 1;
        TaskExtensionsKt.withRetry(Configuration.getRetryDelay(..), new InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1(..), Configuration.getMaxRetries(..), Configuration.getRetryScalingFactor(..), v5, new InitializationException(..), new InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1(..), this);
        if (if-ne(TaskExtensionsKt.withRetry(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_111;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_111:
      L_114:
        Result.constructor-impl(TaskExtensionsKt.withRetry(..));
      L_11f:
      L_122:
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_12c:
        Result.isFailure-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isFailure-impl(..))) goto L_1a7;
        InitializeStateLoadWeb.access$getInitializeStateNetworkError$p(this$0);
        $params.getConfig();
        new InitializeStateNetworkError$Params(InitializeStateLoadWeb$Params.getConfig(..));
        L$0 = $params;
        L$1 = this$0;
        L$2 = this;
        L$3 = 0;
        label = 2;
        InitializeStateNetworkError.invoke-gIAlu-s(new InitializeStateNetworkError$Params(..), this);
        if (if-ne(InitializeStateNetworkError.invoke-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_155;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_155:
        Result.box-impl(InitializeStateNetworkError.invoke-gIAlu-s(..));
        Result.constructor-impl(Result.box-impl(..));
      L_15e:
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_168:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_194;
        InitializeStateLoadWeb.access$getDispatchers$p(this$0);
        ISDKDispatchers.getIo();
        new InitializeStateLoadWeb$doWork$2$1$webViewData$1(this$0, this, 0);
        L$0 = $params;
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        label = 3;
        BuildersKt.withContext(ISDKDispatchers.getIo(..), new InitializeStateLoadWeb$doWork$2$1$webViewData$1(..), this);
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_191;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_191:
      L_194:
        new Exception("No connected events within the timeout!");
        $params.getConfig();
        new InitializationException(ErrorState.NetworkWebviewRequest, new Exception(..), InitializeStateLoadWeb$Params.getConfig(..));
        throw new InitializationException(..);
      L_1a7:
        ResultKt.throwOnFailure(new InitializationException(..));
        new InitializationException(..).getBody();
        HttpResponse.getBody(..).toString();
      L_1b4:
        InitializeStateLoadWeb$Params.getConfig();
        Configuration.getWebViewHash();
        if (if-eqz(Configuration.getWebViewHash(..))) goto L_1dc;
        Utilities.Sha256(Object.toString(..));
        Intrinsics.areEqual(Utilities.Sha256(..), Configuration.getWebViewHash(..));
        if (if-eqz(Intrinsics.areEqual(..))) goto L_1c9;
      L_1c9:
        new Exception("Invalid webViewHash");
        InitializeStateLoadWeb$Params.getConfig();
        new InitializationException(ErrorState.InvalidHash, new Exception(..), InitializeStateLoadWeb$Params.getConfig(..));
        throw new InitializationException(..);
      L_1dc:
        if (if-eqz(ErrorState.InvalidHash)) goto L_1ea;
        SdkProperties.getLocalWebViewFile();
        new File(SdkProperties.getLocalWebViewFile(..));
        Utilities.writeFile(new File(..), new InitializationException(..));
      L_1ea:
        InitializeStateLoadWeb$Params.getConfig();
        new InitializeStateLoadWeb$LoadWebResult(InitializeStateLoadWeb$Params.getConfig(..), new InitializationException(..));
        Result.constructor-impl(new InitializeStateLoadWeb$LoadWebResult(..));
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_203:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_210;
        Result.constructor-impl(Result.constructor-impl(..));
      L_210:
        Result.exceptionOrNull-impl(Result.constructor-impl(..));
        if (if-eqz(Result.exceptionOrNull-impl(..))) goto L_220;
        ResultKt.createFailure(Result.exceptionOrNull-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_220:
        Result.box-impl(Result.constructor-impl(..));
        return Result.box-impl(..);
        throw Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$1$webViewData$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateLoadWeb$doWork$2$1$webViewData$1 extends SuspendLambda {
    final HttpRequest $request;
    int label;
    final InitializeStateLoadWeb this$0;

    InitializeStateLoadWeb$doWork$2$1$webViewData$1(InitializeStateLoadWeb p0, HttpRequest p1, Continuation p2) {
        this$0 = p0;
        $request = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateLoadWeb$doWork$2$1$webViewData$1(this$0, $request, p1);
        return new InitializeStateLoadWeb$doWork$2$1$webViewData$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateLoadWeb$doWork$2$1$webViewData$1.invoke(p0, p1);
        return InitializeStateLoadWeb$doWork$2$1$webViewData$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateLoadWeb$doWork$2$1$webViewData$1.create(p0, p1);
        InitializeStateLoadWeb$doWork$2$1$webViewData$1.invokeSuspend(Unit.INSTANCE);
        return InitializeStateLoadWeb$doWork$2$1$webViewData$1.invokeSuspend(..);
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
        InitializeStateLoadWeb.access$getHttpClient$p(this$0);
        label = 1;
        HttpClient.execute($request, this);
        if (if-ne(HttpClient.execute(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2e;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2e:
        HttpClient.execute(..).getBody();
        HttpResponse.getBody(..).toString();
        return Object.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1 extends SuspendLambda {
    final HttpRequest $request;
    int I$0;
    int label;
    final InitializeStateLoadWeb this$0;

    InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1(InitializeStateLoadWeb p0, HttpRequest p1, Continuation p2) {
        this$0 = p0;
        $request = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1(this$0, $request, p1);
        p0.intValue();
        I$0 = Number.intValue(..);
        return new InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1(..);
    }

    public final Object invoke(int p0, Continuation p1) {
        Integer.valueOf(p0);
        InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1.create(Integer.valueOf(..), p1);
        InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1.invokeSuspend(Unit.INSTANCE);
        return InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1.invokeSuspend(..);
    }

    public Object invoke(Object p0, Object p1) {
        p0.intValue();
        InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1.invoke(Number.intValue(..), p1);
        return InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1.invoke(..);
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
        if (if-lez(I$0)) goto L_25;
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.onRetryWebview();
      L_25:
        InitializeStateLoadWeb.access$getDispatchers$p(this$0);
        ISDKDispatchers.getIo();
        new InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1(this$0, $request, 0);
        label = 1;
        BuildersKt.withContext(ISDKDispatchers.getIo(..), new InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1(..), this);
        if (if-ne(BuildersKt.withContext(..), "call to 'resume' before 'invoke' with coroutine")) goto L_49;
        return "call to 'resume' before 'invoke' with coroutine";
      L_49:
        return BuildersKt.withContext(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1 extends SuspendLambda {
    final HttpRequest $request;
    int label;
    final InitializeStateLoadWeb this$0;

    InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1(InitializeStateLoadWeb p0, HttpRequest p1, Continuation p2) {
        this$0 = p0;
        $request = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1(this$0, $request, p1);
        return new InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1.invoke(p0, p1);
        return InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1.create(p0, p1);
        InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1.invokeSuspend(Unit.INSTANCE);
        return InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1.invokeSuspend(..);
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
        InitializeStateLoadWeb.access$getHttpClient$p(this$0);
        label = 1;
        HttpClient.execute($request, this);
        if (if-ne(HttpClient.execute(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2e;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2e:
        return HttpClient.execute(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateNetworkError$Params
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateNetworkError$Params {
    private final Configuration config;

    public InitializeStateNetworkError$Params(Configuration p0) {
        new Object();
        config = p0;
        return;
    }

    public static InitializeStateNetworkError$Params copy$default(InitializeStateNetworkError$Params p0, Configuration p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        p0.copy(config);
        return InitializeStateNetworkError$Params.copy(..);
    }

    public final Configuration component1() {
        return config;
    }

    public final InitializeStateNetworkError$Params copy(Configuration p0) {
        new InitializeStateNetworkError$Params(p0);
        return new InitializeStateNetworkError$Params(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(config, config);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        return 1;
    }

    public final Configuration getConfig() {
        return config;
    }

    public int hashCode() {
        config.hashCode();
        return Configuration.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Params(config=");
        new StringBuilder(..).append(config);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateNetworkError$doWork$1 extends ContinuationImpl {
    int label;
    Object result;
    final InitializeStateNetworkError this$0;

    InitializeStateNetworkError$doWork$1(InitializeStateNetworkError p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.doWork-gIAlu-s(0, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(InitializeStateNetworkError.doWork-gIAlu-s(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a;
        return InitializeStateNetworkError.doWork-gIAlu-s(..);
      L_1a:
        Result.box-impl(InitializeStateNetworkError.doWork-gIAlu-s(..));
        return Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateNetworkError$doWork$2 extends SuspendLambda {
    final InitializeStateNetworkError$Params $params;
    Object L$0;
    int label;
    final InitializeStateNetworkError this$0;

    InitializeStateNetworkError$doWork$2(InitializeStateNetworkError p0, InitializeStateNetworkError$Params p1, Continuation p2) {
        this$0 = p0;
        $params = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateNetworkError$doWork$2(this$0, $params, p1);
        return new InitializeStateNetworkError$doWork$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateNetworkError$doWork$2.invoke(p0, p1);
        return InitializeStateNetworkError$doWork$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateNetworkError$doWork$2.create(p0, p1);
        InitializeStateNetworkError$doWork$2.invokeSuspend(Unit.INSTANCE);
        return InitializeStateNetworkError$doWork$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_1b;
        if (if-ne(label, 1)) goto L_13;
        ResultKt.throwOnFailure(p0);
      L_13:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1b:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        DeviceLog.error("Unity Ads init: network error, waiting for connection events");
        $params.getConfig();
        Configuration.getMaximumConnectedEvents();
        InitializeStateNetworkError.access$setMaximumConnectedEvents$p(this$0, Configuration.getMaximumConnectedEvents(..));
        $params.getConfig();
        Configuration.getConnectedEventThreshold();
        InitializeStateNetworkError.access$setConnectedEventThreshold$p(this$0, Configuration.getConnectedEventThreshold(..));
        $params.getConfig();
        Configuration.getNetworkErrorTimeout();
        new InitializeStateNetworkError$doWork$2$1$success$1(this$0, 0);
        L$0 = this$0;
        label = 1;
        TimeoutKt.withTimeoutOrNull(Configuration.getNetworkErrorTimeout(..), v4, new InitializeStateNetworkError$doWork$2$1$success$1(..), this);
        if (if-ne(TimeoutKt.withTimeoutOrNull(..), "call to 'resume' before 'invoke' with coroutine")) goto L_5a;
        return "call to 'resume' before 'invoke' with coroutine";
      L_5a:
      L_5c:
        if (if-eqz(TimeoutKt.withTimeoutOrNull(..))) goto L_67;
        Result.constructor-impl(Unit.INSTANCE);
      L_67:
        ConnectivityMonitor.removeListener(this$0);
        new Exception("No connected events within the timeout!");
        throw new Exception(..);
        ResultKt.createFailure(new Exception(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_7f:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_8c;
        Result.constructor-impl(Result.constructor-impl(..));
      L_8c:
        Result.exceptionOrNull-impl(Result.constructor-impl(..));
        if (if-eqz(Result.exceptionOrNull-impl(..))) goto L_9c;
        ResultKt.createFailure(Result.exceptionOrNull-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_9c:
        Result.box-impl(Result.constructor-impl(..));
        return Result.box-impl(..);
        throw Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2$1$success$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateNetworkError$doWork$2$1$success$1 extends SuspendLambda {
    Object L$0;
    int label;
    final InitializeStateNetworkError this$0;

    InitializeStateNetworkError$doWork$2$1$success$1(InitializeStateNetworkError p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateNetworkError$doWork$2$1$success$1(this$0, p1);
        return new InitializeStateNetworkError$doWork$2$1$success$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateNetworkError$doWork$2$1$success$1.invoke(p0, p1);
        return InitializeStateNetworkError$doWork$2$1$success$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateNetworkError$doWork$2$1$success$1.create(p0, p1);
        InitializeStateNetworkError$doWork$2$1$success$1.invokeSuspend(Unit.INSTANCE);
        return InitializeStateNetworkError$doWork$2$1$success$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_1b;
        if (if-ne(label, 1)) goto L_13;
        ResultKt.throwOnFailure(p0);
      L_13:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1b:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        L$0 = this$0;
        label = 1;
        IntrinsicsKt.intercepted(this);
        new CancellableContinuationImpl(IntrinsicsKt.intercepted(..), 1);
        new CancellableContinuationImpl(..).initCancellability();
        InitializeStateNetworkError.access$startListening(this$0, new CancellableContinuationImpl(..));
        new CancellableContinuationImpl(..).getResult();
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(CancellableContinuationImpl.getResult(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_48;
        DebugProbesKt.probeCoroutineSuspended(this);
      L_48:
        if (if-ne(CancellableContinuationImpl.getResult(..), "call to 'resume' before 'invoke' with coroutine")) goto L_4b;
        return "call to 'resume' before 'invoke' with coroutine";
      L_4b:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateReset$Params
// ============================================================
package com.unity3d.services.core.domain.task;

public final class InitializeStateReset$Params {
    private final Configuration config;

    public InitializeStateReset$Params(Configuration p0) {
        new Object();
        config = p0;
        return;
    }

    public static InitializeStateReset$Params copy$default(InitializeStateReset$Params p0, Configuration p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        p0.copy(config);
        return InitializeStateReset$Params.copy(..);
    }

    public final Configuration component1() {
        return config;
    }

    public final InitializeStateReset$Params copy(Configuration p0) {
        new InitializeStateReset$Params(p0);
        return new InitializeStateReset$Params(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(config, config);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        return 1;
    }

    public final Configuration getConfig() {
        return config;
    }

    public int hashCode() {
        config.hashCode();
        return Configuration.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Params(config=");
        new StringBuilder(..).append(config);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateReset$doWork$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateReset$doWork$1 extends ContinuationImpl {
    int label;
    Object result;
    final InitializeStateReset this$0;

    InitializeStateReset$doWork$1(InitializeStateReset p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        InitializeStateReset.doWork-gIAlu-s$suspendImpl(this$0, 0, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(InitializeStateReset.doWork-gIAlu-s$suspendImpl(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a;
        return InitializeStateReset.doWork-gIAlu-s$suspendImpl(..);
      L_1a:
        Result.box-impl(InitializeStateReset.doWork-gIAlu-s$suspendImpl(..));
        return Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateReset$doWork$2 extends SuspendLambda {
    final InitializeStateReset$Params $params;
    Object L$0;
    Object L$1;
    int label;
    final InitializeStateReset this$0;

    InitializeStateReset$doWork$2(InitializeStateReset$Params p0, InitializeStateReset p1, Continuation p2) {
        $params = p0;
        this$0 = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateReset$doWork$2($params, this$0, p1);
        return new InitializeStateReset$doWork$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateReset$doWork$2.invoke(p0, p1);
        return InitializeStateReset$doWork$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateReset$doWork$2.create(p0, p1);
        InitializeStateReset$doWork$2.invokeSuspend(Unit.INSTANCE);
        return InitializeStateReset$doWork$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_20;
        if (if-ne(label, 1)) goto L_18;
        ResultKt.throwOnFailure(p0);
      L_18:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_20:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        DeviceLog.debug("Unity Ads init: starting init");
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_37;
        WebViewApp.getCurrentApp(..).resetWebViewAppInitialization();
      L_37:
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_3e;
        WebViewApp.getCurrentApp(..).getWebView();
      L_3e:
      L_3f:
        if (if-eqz(0)) goto L_6d;
        $params.getConfig();
        Configuration.getWebViewAppCreateTimeout();
        new InitializeStateReset$doWork$2$1$success$1(this$0, WebViewApp.getCurrentApp(..), 0);
        L$0 = $params;
        L$1 = this$0;
        label = 1;
        TimeoutKt.withTimeoutOrNull(Configuration.getWebViewAppCreateTimeout(..), v6, new InitializeStateReset$doWork$2$1$success$1(..), this);
        if (if-ne(TimeoutKt.withTimeoutOrNull(..), "call to 'resume' before 'invoke' with coroutine")) goto L_5d;
        return "call to 'resume' before 'invoke' with coroutine";
      L_5d:
      L_5f:
        if (if-eqz(TimeoutKt.withTimeoutOrNull(..))) goto L_65;
      L_65:
        new Exception("Reset failed on opening ConditionVariable");
        throw new Exception(..);
      L_6d:
        InitializeStateReset.access$unregisterLifecycleCallbacks(new Exception(..));
        SdkProperties.setCacheDirectory(0);
        SdkProperties.setWebViewCacheDirectory(0);
        SdkProperties.getCacheDirectory();
        if (if-eqz(SdkProperties.getCacheDirectory(..))) goto L_c0;
        SdkProperties.getWebViewCacheDirectory();
        if (if-eqz(SdkProperties.getWebViewCacheDirectory(..))) goto L_b8;
        SdkProperties.setInitialized(0);
        $params.getConfig();
        Configuration.getModuleConfigurationList();
        if (if-nez(Configuration.getModuleConfigurationList(..))) goto L_92;
      L_92:
      L_93:
        if (if-ge(0, TimeoutKt.withTimeoutOrNull(..))) goto L_af;
        $params.getConfig();
        Configuration.getModuleConfiguration(0);
        if (if-eqz(Configuration.getModuleConfiguration(..))) goto L_ac;
        $params.getConfig();
        IModuleConfiguration.resetState(InitializeStateReset$Params.getConfig(..));
        Boxing.boxBoolean(IModuleConfiguration.resetState(..));
      L_ac:
      L_af:
        $params.getConfig();
        Result.constructor-impl(InitializeStateReset$Params.getConfig(..));
      L_b8:
        new Exception("WebView cache directory is NULL");
        throw new Exception(..);
      L_c0:
        new Exception("Cache directory is NULL");
        throw new Exception(..);
        ResultKt.createFailure(new Exception(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_d3:
        Result.isSuccess-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isSuccess-impl(..))) goto L_e0;
        Result.constructor-impl(Result.constructor-impl(..));
      L_e0:
        Result.exceptionOrNull-impl(Result.constructor-impl(..));
        if (if-eqz(Result.exceptionOrNull-impl(..))) goto L_f0;
        ResultKt.createFailure(Result.exceptionOrNull-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_f0:
        Result.box-impl(Result.constructor-impl(..));
        return Result.box-impl(..);
        throw Result.box-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$1$success$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateReset$doWork$2$1$success$1 extends SuspendLambda {
    final WebViewApp $currentApp;
    int label;
    final InitializeStateReset this$0;

    InitializeStateReset$doWork$2$1$success$1(InitializeStateReset p0, WebViewApp p1, Continuation p2) {
        this$0 = p0;
        $currentApp = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateReset$doWork$2$1$success$1(this$0, $currentApp, p1);
        return new InitializeStateReset$doWork$2$1$success$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateReset$doWork$2$1$success$1.invoke(p0, p1);
        return InitializeStateReset$doWork$2$1$success$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateReset$doWork$2$1$success$1.create(p0, p1);
        InitializeStateReset$doWork$2$1$success$1.invokeSuspend(Unit.INSTANCE);
        return InitializeStateReset$doWork$2$1$success$1.invokeSuspend(..);
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
        InitializeStateReset.access$getDispatchers$p(this$0);
        ISDKDispatchers.getMain();
        new InitializeStateReset$doWork$2$1$success$1$1($currentApp, 0);
        label = 1;
        BuildersKt.withContext(ISDKDispatchers.getMain(..), new InitializeStateReset$doWork$2$1$success$1$1(..), this);
        if (if-ne(BuildersKt.withContext(..), "call to 'resume' before 'invoke' with coroutine")) goto L_3c;
        return "call to 'resume' before 'invoke' with coroutine";
      L_3c:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$1$success$1$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class InitializeStateReset$doWork$2$1$success$1$1 extends SuspendLambda {
    final WebViewApp $currentApp;
    int label;

    InitializeStateReset$doWork$2$1$success$1$1(WebViewApp p0, Continuation p1) {
        $currentApp = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new InitializeStateReset$doWork$2$1$success$1$1($currentApp, p1);
        return new InitializeStateReset$doWork$2$1$success$1$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        InitializeStateReset$doWork$2$1$success$1$1.invoke(p0, p1);
        return InitializeStateReset$doWork$2$1$success$1$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        InitializeStateReset$doWork$2$1$success$1$1.create(p0, p1);
        InitializeStateReset$doWork$2$1$success$1$1.invokeSuspend(Unit.INSTANCE);
        return InitializeStateReset$doWork$2$1$success$1$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_1e;
        ResultKt.throwOnFailure(p0);
        $currentApp.getWebView();
        if (if-eqz(WebViewApp.getWebView(..))) goto L_15;
        WebViewApp.getWebView(..).destroy();
      L_15:
        $currentApp.setWebView(0);
        return Unit.INSTANCE;
      L_1e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.domain.task.MetricTask$invoke$1
// ============================================================
package com.unity3d.services.core.domain.task;

final class MetricTask$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    Object result;
    final MetricTask this$0;

    MetricTask$invoke$1(MetricTask p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        MetricTask.invoke-gIAlu-s$suspendImpl(this$0, 0, this);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(MetricTask.invoke-gIAlu-s$suspendImpl(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a;
        return MetricTask.invoke-gIAlu-s$suspendImpl(..);
      L_1a:
        Result.box-impl(MetricTask.invoke-gIAlu-s$suspendImpl(..));
        return Result.box-impl(..);
    }

}

