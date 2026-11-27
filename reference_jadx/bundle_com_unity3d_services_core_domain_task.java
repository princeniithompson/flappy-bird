
// ===== FILE: com/unity3d/services/core/domain/task/BaseParams.java =====
package com.unity3d.services.core.domain.task;

import kotlin.Metadata;

/* compiled from: BaseParams.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/BaseParams;", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface BaseParams {
}

// ===== FILE: com/unity3d/services/core/domain/task/BaseTask$invoke$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.BaseParams;
import com.unity3d.services.core.domain.task.BaseTask;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BaseTask.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.BaseTask$DefaultImpls", m464f = "BaseTask.kt", m465i = {}, m466l = {11}, m467m = "invoke-gIAlu-s", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class BaseTask$invoke$1<P extends BaseParams, R> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    BaseTask$invoke$1(Continuation<? super BaseTask$invoke$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m665invokegIAlus = BaseTask.DefaultImpls.m665invokegIAlus(null, null, this);
        return m665invokegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m665invokegIAlus : Result.m744boximpl(m665invokegIAlus);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/BaseTask.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.BaseParams;
import com.unity3d.services.core.p005di.IServiceComponent;
import com.unity3d.services.core.p005di.IServiceProvider;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: BaseTask.kt */
@Metadata(m443d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004J*\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\u0007\u001a\u00028\u0000H¦@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\b\u0010\tJ*\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0096Bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\t\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/BaseTask;", "P", "Lcom/unity3d/services/core/domain/task/BaseParams;", "R", "Lcom/unity3d/services/core/di/IServiceComponent;", "doWork", "Lkotlin/Result;", "params", "doWork-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/BaseParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "invoke-gIAlu-s", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface BaseTask<P extends BaseParams, R> extends IServiceComponent {
    /* renamed from: doWork-gIAlu-s, reason: not valid java name */
    Object mo663doWorkgIAlus(P p, Continuation<? super Result<? extends R>> continuation);

    /* renamed from: invoke-gIAlu-s, reason: not valid java name */
    Object mo664invokegIAlus(P p, Continuation<? super Result<? extends R>> continuation);

    /* compiled from: BaseTask.kt */
    @Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class DefaultImpls {
        public static <P extends BaseParams, R> IServiceProvider getServiceProvider(BaseTask<? super P, R> baseTask) {
            return IServiceComponent.DefaultImpls.getServiceProvider(baseTask);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        /* renamed from: invoke-gIAlu-s, reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static <P extends BaseParams, R> Object m665invokegIAlus(BaseTask<? super P, R> baseTask, P p, Continuation<? super Result<? extends R>> continuation) {
            BaseTask$invoke$1 baseTask$invoke$1;
            int i;
            if (continuation instanceof BaseTask$invoke$1) {
                baseTask$invoke$1 = (BaseTask$invoke$1) continuation;
                if ((baseTask$invoke$1.label & Integer.MIN_VALUE) != 0) {
                    baseTask$invoke$1.label -= Integer.MIN_VALUE;
                    Object obj = baseTask$invoke$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = baseTask$invoke$1.label;
                    if (i == 0) {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return ((Result) obj).getValue();
                    }
                    ResultKt.throwOnFailure(obj);
                    baseTask$invoke$1.label = 1;
                    Object mo663doWorkgIAlus = baseTask.mo663doWorkgIAlus(p, baseTask$invoke$1);
                    return mo663doWorkgIAlus == coroutine_suspended ? coroutine_suspended : mo663doWorkgIAlus;
                }
            }
            baseTask$invoke$1 = new BaseTask$invoke$1(continuation);
            Object obj2 = baseTask$invoke$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = baseTask$invoke$1.label;
            if (i == 0) {
            }
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/ConfigFileFromLocalStorage$doWork$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ConfigFileFromLocalStorage.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage", m464f = "ConfigFileFromLocalStorage.kt", m465i = {}, m466l = {27}, m467m = "doWork-gIAlu-s", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class ConfigFileFromLocalStorage$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConfigFileFromLocalStorage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigFileFromLocalStorage$doWork$1(ConfigFileFromLocalStorage configFileFromLocalStorage, Continuation<? super ConfigFileFromLocalStorage$doWork$1> continuation) {
        super(continuation);
        this.this$0 = configFileFromLocalStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m666doWorkgIAlus = this.this$0.m666doWorkgIAlus((ConfigFileFromLocalStorage.Params) null, (Continuation<? super Result<? extends Configuration>>) this);
        return m666doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m666doWorkgIAlus : Result.m744boximpl(m666doWorkgIAlus);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/ConfigFileFromLocalStorage$doWork$2.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.properties.SdkProperties;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.p008io.FilesKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* compiled from: ConfigFileFromLocalStorage.kt */
@Metadata(m443d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "Lcom/unity3d/services/core/configuration/Configuration;", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$doWork$2", m464f = "ConfigFileFromLocalStorage.kt", m465i = {}, m466l = {}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class ConfigFileFromLocalStorage$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Configuration>>, Object> {
    final /* synthetic */ ConfigFileFromLocalStorage.Params $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigFileFromLocalStorage$doWork$2(ConfigFileFromLocalStorage.Params params, Continuation<? super ConfigFileFromLocalStorage$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConfigFileFromLocalStorage$doWork$2(this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Configuration>> continuation) {
        return ((ConfigFileFromLocalStorage$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m745constructorimpl;
        Configuration configuration;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ConfigFileFromLocalStorage.Params params = this.$params;
        try {
            Result.Companion companion = Result.INSTANCE;
            File file = new File(SdkProperties.getLocalConfigurationFilepath());
            if (!file.exists()) {
                configuration = params.getDefaultConfiguration();
            } else {
                configuration = new Configuration(new JSONObject(FilesKt.readText$default(file, null, 1, null)));
            }
            m745constructorimpl = Result.m745constructorimpl(configuration);
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m752isSuccessimpl(m745constructorimpl)) {
            Result.Companion companion3 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(m745constructorimpl);
        } else {
            Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(m745constructorimpl);
            if (m748exceptionOrNullimpl != null) {
                Result.Companion companion4 = Result.INSTANCE;
                m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(m748exceptionOrNullimpl));
            }
        }
        return Result.m744boximpl(m745constructorimpl);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/ConfigFileFromLocalStorage.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: ConfigFileFromLocalStorage.kt */
@Metadata(m443d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\u0002H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage;", "Lcom/unity3d/services/core/domain/task/MetricTask;", "Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage$Params;", "Lcom/unity3d/services/core/configuration/Configuration;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;)V", "doWork", "Lkotlin/Result;", "params", "doWork-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetricName", "", "Params", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class ConfigFileFromLocalStorage extends MetricTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: doWork-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo663doWorkgIAlus(BaseParams baseParams, Continuation continuation) {
        return m666doWorkgIAlus((Params) baseParams, (Continuation<? super Result<? extends Configuration>>) continuation);
    }

    public ConfigFileFromLocalStorage(ISDKDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.dispatchers = dispatchers;
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("read_local_config");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: doWork-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m666doWorkgIAlus(Params params, Continuation<? super Result<? extends Configuration>> continuation) {
        ConfigFileFromLocalStorage$doWork$1 configFileFromLocalStorage$doWork$1;
        int i;
        if (continuation instanceof ConfigFileFromLocalStorage$doWork$1) {
            configFileFromLocalStorage$doWork$1 = (ConfigFileFromLocalStorage$doWork$1) continuation;
            if ((configFileFromLocalStorage$doWork$1.label & Integer.MIN_VALUE) != 0) {
                configFileFromLocalStorage$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = configFileFromLocalStorage$doWork$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = configFileFromLocalStorage$doWork$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher io = this.dispatchers.getIo();
                    ConfigFileFromLocalStorage$doWork$2 configFileFromLocalStorage$doWork$2 = new ConfigFileFromLocalStorage$doWork$2(params, null);
                    configFileFromLocalStorage$doWork$1.label = 1;
                    obj = BuildersKt.withContext(io, configFileFromLocalStorage$doWork$2, configFileFromLocalStorage$doWork$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        configFileFromLocalStorage$doWork$1 = new ConfigFileFromLocalStorage$doWork$1(this, continuation);
        Object obj2 = configFileFromLocalStorage$doWork$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = configFileFromLocalStorage$doWork$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* compiled from: ConfigFileFromLocalStorage.kt */
    @Metadata(m443d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage$Params;", "Lcom/unity3d/services/core/domain/task/BaseParams;", "defaultConfiguration", "Lcom/unity3d/services/core/configuration/Configuration;", "(Lcom/unity3d/services/core/configuration/Configuration;)V", "getDefaultConfiguration", "()Lcom/unity3d/services/core/configuration/Configuration;", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class Params implements BaseParams {
        private final Configuration defaultConfiguration;

        /* JADX WARN: Multi-variable type inference failed */
        public Params() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public Params(Configuration defaultConfiguration) {
            Intrinsics.checkNotNullParameter(defaultConfiguration, "defaultConfiguration");
            this.defaultConfiguration = defaultConfiguration;
        }

        public /* synthetic */ Params(Configuration configuration, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new Configuration() : configuration);
        }

        public final Configuration getDefaultConfiguration() {
            return this.defaultConfiguration;
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/EmptyParams.java =====
package com.unity3d.services.core.domain.task;

import kotlin.Metadata;

/* compiled from: EmptyParams.kt */
@Metadata(m443d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/EmptyParams;", "Lcom/unity3d/services/core/domain/task/BaseParams;", "()V", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class EmptyParams implements BaseParams {
    public static final EmptyParams INSTANCE = new EmptyParams();

    private EmptyParams() {
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializationException.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitializationException.kt */
@Metadata(m443d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\r\u0010\u0010\u001a\u00060\u0001j\u0002`\u0002HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\b\u0002\u0010\u0005\u001a\u00060\u0001j\u0002`\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorState", "Lcom/unity3d/services/core/configuration/ErrorState;", "originalException", "config", "Lcom/unity3d/services/core/configuration/Configuration;", "(Lcom/unity3d/services/core/configuration/ErrorState;Ljava/lang/Exception;Lcom/unity3d/services/core/configuration/Configuration;)V", "getConfig", "()Lcom/unity3d/services/core/configuration/Configuration;", "getErrorState", "()Lcom/unity3d/services/core/configuration/ErrorState;", "getOriginalException", "()Ljava/lang/Exception;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final /* data */ class InitializationException extends Exception {
    private final Configuration config;
    private final ErrorState errorState;
    private final Exception originalException;

    public static /* synthetic */ InitializationException copy$default(InitializationException initializationException, ErrorState errorState, Exception exc, Configuration configuration, int i, Object obj) {
        if ((i & 1) != 0) {
            errorState = initializationException.errorState;
        }
        if ((i & 2) != 0) {
            exc = initializationException.originalException;
        }
        if ((i & 4) != 0) {
            configuration = initializationException.config;
        }
        return initializationException.copy(errorState, exc, configuration);
    }

    /* renamed from: component1, reason: from getter */
    public final ErrorState getErrorState() {
        return this.errorState;
    }

    /* renamed from: component2, reason: from getter */
    public final Exception getOriginalException() {
        return this.originalException;
    }

    /* renamed from: component3, reason: from getter */
    public final Configuration getConfig() {
        return this.config;
    }

    public final InitializationException copy(ErrorState errorState, Exception originalException, Configuration config) {
        Intrinsics.checkNotNullParameter(errorState, "errorState");
        Intrinsics.checkNotNullParameter(originalException, "originalException");
        Intrinsics.checkNotNullParameter(config, "config");
        return new InitializationException(errorState, originalException, config);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InitializationException)) {
            return false;
        }
        InitializationException initializationException = (InitializationException) other;
        return this.errorState == initializationException.errorState && Intrinsics.areEqual(this.originalException, initializationException.originalException) && Intrinsics.areEqual(this.config, initializationException.config);
    }

    public int hashCode() {
        return (((this.errorState.hashCode() * 31) + this.originalException.hashCode()) * 31) + this.config.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "InitializationException(errorState=" + this.errorState + ", originalException=" + this.originalException + ", config=" + this.config + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializationException(ErrorState errorState, Exception originalException, Configuration config) {
        super(originalException);
        Intrinsics.checkNotNullParameter(errorState, "errorState");
        Intrinsics.checkNotNullParameter(originalException, "originalException");
        Intrinsics.checkNotNullParameter(config, "config");
        this.errorState = errorState;
        this.originalException = originalException;
        this.config = config;
    }

    public final Configuration getConfig() {
        return this.config;
    }

    public final ErrorState getErrorState() {
        return this.errorState;
    }

    public final Exception getOriginalException() {
        return this.originalException;
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeSDK$doWork$1.java =====
package com.unity3d.services.core.domain.task;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeSDK.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeSDK", m464f = "InitializeSDK.kt", m465i = {}, m466l = {37}, m467m = "doWork-gIAlu-s", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeSDK$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$1(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m669doWorkgIAlus = this.this$0.m669doWorkgIAlus((EmptyParams) null, (Continuation<? super Result<Unit>>) this);
        return m669doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m669doWorkgIAlus : Result.m744boximpl(m669doWorkgIAlus);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeSDK$doWork$2$1$webViewData$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeSDK.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2$1$webViewData$1", m464f = "InitializeSDK.kt", m465i = {}, m466l = {75}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeSDK$doWork$2$1$webViewData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $configResult;
    int label;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$2$1$webViewData$1(InitializeSDK initializeSDK, Object obj, Continuation<? super InitializeSDK$doWork$2$1$webViewData$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeSDK;
        this.$configResult = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeSDK$doWork$2$1$webViewData$1(this.this$0, this.$configResult, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeSDK$doWork$2$1$webViewData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InitializeStateLoadWeb initializeStateLoadWeb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            initializeStateLoadWeb = this.this$0.initializeStateLoadWeb;
            Object obj2 = this.$configResult;
            ResultKt.throwOnFailure(obj2);
            this.label = 1;
            if (initializeStateLoadWeb.mo664invokegIAlus(new InitializeStateLoadWeb.Params((Configuration) obj2), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((Result) obj).getValue();
        }
        return Unit.INSTANCE;
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeSDK$doWork$2.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.domain.ResultExtensionsKt;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.domain.task.InitializeStateComplete;
import com.unity3d.services.core.domain.task.InitializeStateConfig;
import com.unity3d.services.core.domain.task.InitializeStateCreate;
import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import com.unity3d.services.core.domain.task.InitializeStateReset;
import com.unity3d.services.core.lifecycle.CachedLifecycle;
import com.unity3d.services.core.log.DeviceLog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeSDK.kt */
@Metadata(m443d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2", m464f = "InitializeSDK.kt", m465i = {0, 1, 1, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10}, m466l = {44, 49, 51, 56, 58, 62, 65, 80, 83, 91, 94, 97}, m467m = "invokeSuspend", m468n = {"$this$withContext", "$this$withContext", "configuration", "resetResult", "$this$withContext", "configuration", "$this$withContext", "configResult", "configuration", "$this$withContext", "configResult", "configuration", "loadCacheResult", "configResult", "configResult", "loadWebResult", "configResult", "configResult"}, m469s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$2", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0", "L$1", "L$1", "L$2", "L$1", "L$1"})
/* loaded from: classes.dex */
final class InitializeSDK$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$2(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeSDK$doWork$2 initializeSDK$doWork$2 = new InitializeSDK$doWork$2(this.this$0, continuation);
        initializeSDK$doWork$2.L$0 = obj;
        return initializeSDK$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((InitializeSDK$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0192 A[Catch: all -> 0x031d, CancellationException -> 0x034a, TryCatch #2 {CancellationException -> 0x034a, all -> 0x031d, blocks: (B:7:0x0014, B:8:0x0307, B:18:0x0025, B:19:0x02e8, B:23:0x0030, B:24:0x02cf, B:26:0x02d5, B:30:0x0043, B:31:0x0299, B:32:0x02a9, B:37:0x004e, B:40:0x027e, B:42:0x0284, B:46:0x005e, B:47:0x020e, B:49:0x0214, B:50:0x0221, B:53:0x0076, B:55:0x01f0, B:57:0x01f6, B:60:0x0222, B:62:0x022d, B:64:0x0237, B:66:0x023d, B:67:0x025a, B:70:0x02a3, B:72:0x0311, B:73:0x031c, B:75:0x0092, B:76:0x01cd, B:80:0x00a3, B:82:0x01b1, B:84:0x01b7, B:88:0x00b3, B:89:0x017e, B:91:0x0184, B:92:0x0191, B:95:0x00c9, B:97:0x0162, B:99:0x0168, B:102:0x0192, B:107:0x00df, B:108:0x011f, B:110:0x0125, B:111:0x0138, B:114:0x0144, B:118:0x00f2), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0125 A[Catch: all -> 0x031d, CancellationException -> 0x034a, TryCatch #2 {CancellationException -> 0x034a, all -> 0x031d, blocks: (B:7:0x0014, B:8:0x0307, B:18:0x0025, B:19:0x02e8, B:23:0x0030, B:24:0x02cf, B:26:0x02d5, B:30:0x0043, B:31:0x0299, B:32:0x02a9, B:37:0x004e, B:40:0x027e, B:42:0x0284, B:46:0x005e, B:47:0x020e, B:49:0x0214, B:50:0x0221, B:53:0x0076, B:55:0x01f0, B:57:0x01f6, B:60:0x0222, B:62:0x022d, B:64:0x0237, B:66:0x023d, B:67:0x025a, B:70:0x02a3, B:72:0x0311, B:73:0x031c, B:75:0x0092, B:76:0x01cd, B:80:0x00a3, B:82:0x01b1, B:84:0x01b7, B:88:0x00b3, B:89:0x017e, B:91:0x0184, B:92:0x0191, B:95:0x00c9, B:97:0x0162, B:99:0x0168, B:102:0x0192, B:107:0x00df, B:108:0x011f, B:110:0x0125, B:111:0x0138, B:114:0x0144, B:118:0x00f2), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0161 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0306 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x02d5 A[Catch: all -> 0x031d, CancellationException -> 0x034a, TryCatch #2 {CancellationException -> 0x034a, all -> 0x031d, blocks: (B:7:0x0014, B:8:0x0307, B:18:0x0025, B:19:0x02e8, B:23:0x0030, B:24:0x02cf, B:26:0x02d5, B:30:0x0043, B:31:0x0299, B:32:0x02a9, B:37:0x004e, B:40:0x027e, B:42:0x0284, B:46:0x005e, B:47:0x020e, B:49:0x0214, B:50:0x0221, B:53:0x0076, B:55:0x01f0, B:57:0x01f6, B:60:0x0222, B:62:0x022d, B:64:0x0237, B:66:0x023d, B:67:0x025a, B:70:0x02a3, B:72:0x0311, B:73:0x031c, B:75:0x0092, B:76:0x01cd, B:80:0x00a3, B:82:0x01b1, B:84:0x01b7, B:88:0x00b3, B:89:0x017e, B:91:0x0184, B:92:0x0191, B:95:0x00c9, B:97:0x0162, B:99:0x0168, B:102:0x0192, B:107:0x00df, B:108:0x011f, B:110:0x0125, B:111:0x0138, B:114:0x0144, B:118:0x00f2), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0284 A[Catch: all -> 0x031d, CancellationException -> 0x034a, TryCatch #2 {CancellationException -> 0x034a, all -> 0x031d, blocks: (B:7:0x0014, B:8:0x0307, B:18:0x0025, B:19:0x02e8, B:23:0x0030, B:24:0x02cf, B:26:0x02d5, B:30:0x0043, B:31:0x0299, B:32:0x02a9, B:37:0x004e, B:40:0x027e, B:42:0x0284, B:46:0x005e, B:47:0x020e, B:49:0x0214, B:50:0x0221, B:53:0x0076, B:55:0x01f0, B:57:0x01f6, B:60:0x0222, B:62:0x022d, B:64:0x0237, B:66:0x023d, B:67:0x025a, B:70:0x02a3, B:72:0x0311, B:73:0x031c, B:75:0x0092, B:76:0x01cd, B:80:0x00a3, B:82:0x01b1, B:84:0x01b7, B:88:0x00b3, B:89:0x017e, B:91:0x0184, B:92:0x0191, B:95:0x00c9, B:97:0x0162, B:99:0x0168, B:102:0x0192, B:107:0x00df, B:108:0x011f, B:110:0x0125, B:111:0x0138, B:114:0x0144, B:118:0x00f2), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0214 A[Catch: all -> 0x031d, CancellationException -> 0x034a, TryCatch #2 {CancellationException -> 0x034a, all -> 0x031d, blocks: (B:7:0x0014, B:8:0x0307, B:18:0x0025, B:19:0x02e8, B:23:0x0030, B:24:0x02cf, B:26:0x02d5, B:30:0x0043, B:31:0x0299, B:32:0x02a9, B:37:0x004e, B:40:0x027e, B:42:0x0284, B:46:0x005e, B:47:0x020e, B:49:0x0214, B:50:0x0221, B:53:0x0076, B:55:0x01f0, B:57:0x01f6, B:60:0x0222, B:62:0x022d, B:64:0x0237, B:66:0x023d, B:67:0x025a, B:70:0x02a3, B:72:0x0311, B:73:0x031c, B:75:0x0092, B:76:0x01cd, B:80:0x00a3, B:82:0x01b1, B:84:0x01b7, B:88:0x00b3, B:89:0x017e, B:91:0x0184, B:92:0x0191, B:95:0x00c9, B:97:0x0162, B:99:0x0168, B:102:0x0192, B:107:0x00df, B:108:0x011f, B:110:0x0125, B:111:0x0138, B:114:0x0144, B:118:0x00f2), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f6 A[Catch: all -> 0x031d, CancellationException -> 0x034a, TryCatch #2 {CancellationException -> 0x034a, all -> 0x031d, blocks: (B:7:0x0014, B:8:0x0307, B:18:0x0025, B:19:0x02e8, B:23:0x0030, B:24:0x02cf, B:26:0x02d5, B:30:0x0043, B:31:0x0299, B:32:0x02a9, B:37:0x004e, B:40:0x027e, B:42:0x0284, B:46:0x005e, B:47:0x020e, B:49:0x0214, B:50:0x0221, B:53:0x0076, B:55:0x01f0, B:57:0x01f6, B:60:0x0222, B:62:0x022d, B:64:0x0237, B:66:0x023d, B:67:0x025a, B:70:0x02a3, B:72:0x0311, B:73:0x031c, B:75:0x0092, B:76:0x01cd, B:80:0x00a3, B:82:0x01b1, B:84:0x01b7, B:88:0x00b3, B:89:0x017e, B:91:0x0184, B:92:0x0191, B:95:0x00c9, B:97:0x0162, B:99:0x0168, B:102:0x0192, B:107:0x00df, B:108:0x011f, B:110:0x0125, B:111:0x0138, B:114:0x0144, B:118:0x00f2), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0222 A[Catch: all -> 0x031d, CancellationException -> 0x034a, TryCatch #2 {CancellationException -> 0x034a, all -> 0x031d, blocks: (B:7:0x0014, B:8:0x0307, B:18:0x0025, B:19:0x02e8, B:23:0x0030, B:24:0x02cf, B:26:0x02d5, B:30:0x0043, B:31:0x0299, B:32:0x02a9, B:37:0x004e, B:40:0x027e, B:42:0x0284, B:46:0x005e, B:47:0x020e, B:49:0x0214, B:50:0x0221, B:53:0x0076, B:55:0x01f0, B:57:0x01f6, B:60:0x0222, B:62:0x022d, B:64:0x0237, B:66:0x023d, B:67:0x025a, B:70:0x02a3, B:72:0x0311, B:73:0x031c, B:75:0x0092, B:76:0x01cd, B:80:0x00a3, B:82:0x01b1, B:84:0x01b7, B:88:0x00b3, B:89:0x017e, B:91:0x0184, B:92:0x0191, B:95:0x00c9, B:97:0x0162, B:99:0x0168, B:102:0x0192, B:107:0x00df, B:108:0x011f, B:110:0x0125, B:111:0x0138, B:114:0x0144, B:118:0x00f2), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b7 A[Catch: all -> 0x031d, CancellationException -> 0x034a, TryCatch #2 {CancellationException -> 0x034a, all -> 0x031d, blocks: (B:7:0x0014, B:8:0x0307, B:18:0x0025, B:19:0x02e8, B:23:0x0030, B:24:0x02cf, B:26:0x02d5, B:30:0x0043, B:31:0x0299, B:32:0x02a9, B:37:0x004e, B:40:0x027e, B:42:0x0284, B:46:0x005e, B:47:0x020e, B:49:0x0214, B:50:0x0221, B:53:0x0076, B:55:0x01f0, B:57:0x01f6, B:60:0x0222, B:62:0x022d, B:64:0x0237, B:66:0x023d, B:67:0x025a, B:70:0x02a3, B:72:0x0311, B:73:0x031c, B:75:0x0092, B:76:0x01cd, B:80:0x00a3, B:82:0x01b1, B:84:0x01b7, B:88:0x00b3, B:89:0x017e, B:91:0x0184, B:92:0x0191, B:95:0x00c9, B:97:0x0162, B:99:0x0168, B:102:0x0192, B:107:0x00df, B:108:0x011f, B:110:0x0125, B:111:0x0138, B:114:0x0144, B:118:0x00f2), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0184 A[Catch: all -> 0x031d, CancellationException -> 0x034a, TryCatch #2 {CancellationException -> 0x034a, all -> 0x031d, blocks: (B:7:0x0014, B:8:0x0307, B:18:0x0025, B:19:0x02e8, B:23:0x0030, B:24:0x02cf, B:26:0x02d5, B:30:0x0043, B:31:0x0299, B:32:0x02a9, B:37:0x004e, B:40:0x027e, B:42:0x0284, B:46:0x005e, B:47:0x020e, B:49:0x0214, B:50:0x0221, B:53:0x0076, B:55:0x01f0, B:57:0x01f6, B:60:0x0222, B:62:0x022d, B:64:0x0237, B:66:0x023d, B:67:0x025a, B:70:0x02a3, B:72:0x0311, B:73:0x031c, B:75:0x0092, B:76:0x01cd, B:80:0x00a3, B:82:0x01b1, B:84:0x01b7, B:88:0x00b3, B:89:0x017e, B:91:0x0184, B:92:0x0191, B:95:0x00c9, B:97:0x0162, B:99:0x0168, B:102:0x0192, B:107:0x00df, B:108:0x011f, B:110:0x0125, B:111:0x0138, B:114:0x0144, B:118:0x00f2), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0168 A[Catch: all -> 0x031d, CancellationException -> 0x034a, TryCatch #2 {CancellationException -> 0x034a, all -> 0x031d, blocks: (B:7:0x0014, B:8:0x0307, B:18:0x0025, B:19:0x02e8, B:23:0x0030, B:24:0x02cf, B:26:0x02d5, B:30:0x0043, B:31:0x0299, B:32:0x02a9, B:37:0x004e, B:40:0x027e, B:42:0x0284, B:46:0x005e, B:47:0x020e, B:49:0x0214, B:50:0x0221, B:53:0x0076, B:55:0x01f0, B:57:0x01f6, B:60:0x0222, B:62:0x022d, B:64:0x0237, B:66:0x023d, B:67:0x025a, B:70:0x02a3, B:72:0x0311, B:73:0x031c, B:75:0x0092, B:76:0x01cd, B:80:0x00a3, B:82:0x01b1, B:84:0x01b7, B:88:0x00b3, B:89:0x017e, B:91:0x0184, B:92:0x0191, B:95:0x00c9, B:97:0x0162, B:99:0x0168, B:102:0x0192, B:107:0x00df, B:108:0x011f, B:110:0x0125, B:111:0x0138, B:114:0x0144, B:118:0x00f2), top: B:2:0x0009 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m745constructorimpl;
        InitializeSDK initializeSDK;
        ConfigFileFromLocalStorage configFileFromLocalStorage;
        CoroutineScope coroutineScope;
        Object obj2;
        Throwable m748exceptionOrNullimpl;
        Configuration configuration;
        InitializeStateReset initializeStateReset;
        Object obj3;
        Object obj4;
        InitializeStateConfig initializeStateConfig;
        CoroutineScope coroutineScope2;
        InitializeSDK initializeSDK2;
        Object obj5;
        Configuration configuration2;
        Object m668executeErrorStateBWLJW6A;
        Throwable m748exceptionOrNullimpl2;
        Object handleInitializationException;
        InitializeStateLoadCache initializeStateLoadCache;
        Object obj6;
        Object obj7;
        String webViewData;
        InitializeStateLoadWeb initializeStateLoadWeb;
        Object obj8;
        Object m668executeErrorStateBWLJW6A2;
        Throwable m748exceptionOrNullimpl3;
        Object obj9;
        Object handleInitializationException2;
        InitializeStateCreate initializeStateCreate;
        Object obj10;
        Object obj11;
        InitializeSDK initializeSDK3;
        Object handleInitializationException3;
        InitializeStateComplete initializeStateComplete;
        Object obj12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th));
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                initializeSDK = this.this$0;
                Result.Companion companion2 = Result.INSTANCE;
                InitializeEventsMetricSender.getInstance().didInitStart();
                CachedLifecycle.register();
                DeviceLog.debug("Unity Ads Init: Loading Config File From Local Storage");
                configFileFromLocalStorage = initializeSDK.configFileFromLocalStorage;
                ConfigFileFromLocalStorage.Params params = new ConfigFileFromLocalStorage.Params(null, 1, null);
                this.L$0 = coroutineScope3;
                this.L$1 = initializeSDK;
                this.label = 1;
                Object obj13 = configFileFromLocalStorage.mo664invokegIAlus(params, this);
                if (obj13 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope3;
                obj2 = obj13;
                m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(obj2);
                if (m748exceptionOrNullimpl != null) {
                    DeviceLog.debug("Unity Ads Init: Could not load config file from local storage: " + m748exceptionOrNullimpl.getMessage());
                }
                Configuration configuration3 = new Configuration();
                if (Result.m751isFailureimpl(obj2)) {
                    obj2 = configuration3;
                }
                configuration = (Configuration) obj2;
                initializeStateReset = initializeSDK.initializeStateReset;
                InitializeStateReset.Params params2 = new InitializeStateReset.Params(configuration);
                this.L$0 = coroutineScope;
                this.L$1 = initializeSDK;
                this.L$2 = configuration;
                this.label = 2;
                obj3 = initializeStateReset.mo664invokegIAlus(params2, this);
                if (obj3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Configuration configuration4 = configuration;
                obj4 = obj3;
                if (!Result.m751isFailureimpl(obj4)) {
                    initializeStateConfig = initializeSDK.initializeStateConfig;
                    InitializeStateConfig.Params params3 = new InitializeStateConfig.Params(configuration4);
                    this.L$0 = coroutineScope;
                    this.L$1 = initializeSDK;
                    this.L$2 = configuration4;
                    this.label = 4;
                    Object obj14 = initializeStateConfig.mo664invokegIAlus(params3, this);
                    if (obj14 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope2 = coroutineScope;
                    initializeSDK2 = initializeSDK;
                    obj5 = obj14;
                    configuration2 = configuration4;
                    if (Result.m751isFailureimpl(obj5)) {
                        InitializationException initializationExceptionOrThrow = ResultExtensionsKt.getInitializationExceptionOrThrow(obj5);
                        this.L$0 = coroutineScope2;
                        this.L$1 = initializeSDK2;
                        this.L$2 = obj5;
                        this.L$3 = configuration2;
                        this.label = 5;
                        handleInitializationException = initializeSDK2.handleInitializationException(initializationExceptionOrThrow, this);
                        if (handleInitializationException == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    initializeStateLoadCache = initializeSDK2.initializeStateLoadCache;
                    ResultKt.throwOnFailure(obj5);
                    InitializeStateLoadCache.Params params4 = new InitializeStateLoadCache.Params((Configuration) obj5);
                    this.L$0 = coroutineScope2;
                    this.L$1 = initializeSDK2;
                    this.L$2 = obj5;
                    this.L$3 = configuration2;
                    this.label = 6;
                    obj6 = initializeStateLoadCache.mo664invokegIAlus(params4, this);
                    if (obj6 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Configuration configuration5 = configuration2;
                    obj7 = obj6;
                    if (!Result.m751isFailureimpl(obj7)) {
                        ErrorState errorState = ErrorState.LoadCache;
                        Throwable m748exceptionOrNullimpl4 = Result.m748exceptionOrNullimpl(obj7);
                        this.L$0 = obj7;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 7;
                        m668executeErrorStateBWLJW6A2 = initializeSDK2.m668executeErrorStateBWLJW6A(errorState, m748exceptionOrNullimpl4, configuration5, this);
                        if (m668executeErrorStateBWLJW6A2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        m748exceptionOrNullimpl3 = Result.m748exceptionOrNullimpl(obj7);
                        if (m748exceptionOrNullimpl3 != null) {
                            throw new Exception(ErrorState.LoadCache.toString());
                        }
                        throw m748exceptionOrNullimpl3;
                    }
                    ResultKt.throwOnFailure(obj7);
                    InitializeStateLoadCache.LoadCacheResult loadCacheResult = (InitializeStateLoadCache.LoadCacheResult) obj7;
                    if (loadCacheResult.getHasHashMismatch()) {
                        if (configuration5.getExperiments().isWebViewAsyncDownloadEnabled() && loadCacheResult.getWebViewData() != null) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, new CoroutineName("LaunchLoadWeb"), null, new InitializeSDK$doWork$2$1$webViewData$1(initializeSDK2, obj5, null), 2, null);
                            webViewData = loadCacheResult.getWebViewData();
                        } else {
                            initializeStateLoadWeb = initializeSDK2.initializeStateLoadWeb;
                            ResultKt.throwOnFailure(obj5);
                            InitializeStateLoadWeb.Params params5 = new InitializeStateLoadWeb.Params((Configuration) obj5);
                            this.L$0 = initializeSDK2;
                            this.L$1 = obj5;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 8;
                            obj8 = initializeStateLoadWeb.mo664invokegIAlus(params5, this);
                            if (obj8 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj9 = obj8;
                            if (Result.m751isFailureimpl(obj9)) {
                                InitializationException initializationExceptionOrThrow2 = ResultExtensionsKt.getInitializationExceptionOrThrow(obj9);
                                this.L$0 = initializeSDK2;
                                this.L$1 = obj5;
                                this.L$2 = obj9;
                                this.label = 9;
                                handleInitializationException2 = initializeSDK2.handleInitializationException(initializationExceptionOrThrow2, this);
                                if (handleInitializationException2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            ResultKt.throwOnFailure(obj9);
                            webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj9).getWebViewDataString();
                        }
                    } else {
                        webViewData = loadCacheResult.getWebViewData();
                        if (webViewData == null) {
                            throw new IllegalStateException("WebView is missing.".toString());
                        }
                    }
                    initializeStateCreate = initializeSDK2.initializeStateCreate;
                    ResultKt.throwOnFailure(obj5);
                    InitializeStateCreate.Params params6 = new InitializeStateCreate.Params((Configuration) obj5, webViewData);
                    this.L$0 = initializeSDK2;
                    this.L$1 = obj5;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 10;
                    obj10 = initializeStateCreate.mo664invokegIAlus(params6, this);
                    if (obj10 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj11 = obj5;
                    initializeSDK3 = initializeSDK2;
                    if (Result.m751isFailureimpl(obj10)) {
                        InitializationException initializationExceptionOrThrow3 = ResultExtensionsKt.getInitializationExceptionOrThrow(obj10);
                        this.L$0 = initializeSDK3;
                        this.L$1 = obj11;
                        this.label = 11;
                        handleInitializationException3 = initializeSDK3.handleInitializationException(initializationExceptionOrThrow3, this);
                        if (handleInitializationException3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    initializeStateComplete = initializeSDK3.initializeStateComplete;
                    ResultKt.throwOnFailure(obj11);
                    InitializeStateComplete.Params params7 = new InitializeStateComplete.Params((Configuration) obj11);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 12;
                    obj12 = initializeStateComplete.mo664invokegIAlus(params7, this);
                    if (obj12 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ResultKt.throwOnFailure(obj12);
                    m745constructorimpl = Result.m745constructorimpl(Unit.INSTANCE);
                    if (Result.m752isSuccessimpl(m745constructorimpl)) {
                        Throwable m748exceptionOrNullimpl5 = Result.m748exceptionOrNullimpl(m745constructorimpl);
                        if (m748exceptionOrNullimpl5 != null) {
                            Result.Companion companion3 = Result.INSTANCE;
                            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(m748exceptionOrNullimpl5));
                        }
                    } else {
                        Result.Companion companion4 = Result.INSTANCE;
                        m745constructorimpl = Result.m745constructorimpl(m745constructorimpl);
                    }
                    return Result.m744boximpl(m745constructorimpl);
                }
                ErrorState errorState2 = ErrorState.ResetWebApp;
                Throwable m748exceptionOrNullimpl6 = Result.m748exceptionOrNullimpl(obj4);
                this.L$0 = obj4;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 3;
                m668executeErrorStateBWLJW6A = initializeSDK.m668executeErrorStateBWLJW6A(errorState2, m748exceptionOrNullimpl6, configuration4, this);
                if (m668executeErrorStateBWLJW6A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                m748exceptionOrNullimpl2 = Result.m748exceptionOrNullimpl(obj4);
                if (m748exceptionOrNullimpl2 != null) {
                    throw new Exception(ErrorState.ResetWebApp.toString());
                }
                throw m748exceptionOrNullimpl2;
            case 1:
                initializeSDK = (InitializeSDK) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = ((Result) obj).getValue();
                m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(obj2);
                if (m748exceptionOrNullimpl != null) {
                }
                Configuration configuration32 = new Configuration();
                if (Result.m751isFailureimpl(obj2)) {
                }
                configuration = (Configuration) obj2;
                initializeStateReset = initializeSDK.initializeStateReset;
                InitializeStateReset.Params params22 = new InitializeStateReset.Params(configuration);
                this.L$0 = coroutineScope;
                this.L$1 = initializeSDK;
                this.L$2 = configuration;
                this.label = 2;
                obj3 = initializeStateReset.mo664invokegIAlus(params22, this);
                if (obj3 == coroutine_suspended) {
                }
                Configuration configuration42 = configuration;
                obj4 = obj3;
                if (!Result.m751isFailureimpl(obj4)) {
                }
                break;
            case 2:
                configuration = (Configuration) this.L$2;
                initializeSDK = (InitializeSDK) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj3 = ((Result) obj).getValue();
                Configuration configuration422 = configuration;
                obj4 = obj3;
                if (!Result.m751isFailureimpl(obj4)) {
                }
                break;
            case 3:
                obj4 = this.L$0;
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getValue();
                m748exceptionOrNullimpl2 = Result.m748exceptionOrNullimpl(obj4);
                if (m748exceptionOrNullimpl2 != null) {
                }
                break;
            case 4:
                configuration2 = (Configuration) this.L$2;
                InitializeSDK initializeSDK4 = (InitializeSDK) this.L$1;
                CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope2 = coroutineScope4;
                initializeSDK2 = initializeSDK4;
                obj5 = ((Result) obj).getValue();
                if (Result.m751isFailureimpl(obj5)) {
                }
                initializeStateLoadCache = initializeSDK2.initializeStateLoadCache;
                ResultKt.throwOnFailure(obj5);
                InitializeStateLoadCache.Params params42 = new InitializeStateLoadCache.Params((Configuration) obj5);
                this.L$0 = coroutineScope2;
                this.L$1 = initializeSDK2;
                this.L$2 = obj5;
                this.L$3 = configuration2;
                this.label = 6;
                obj6 = initializeStateLoadCache.mo664invokegIAlus(params42, this);
                if (obj6 == coroutine_suspended) {
                }
                Configuration configuration52 = configuration2;
                obj7 = obj6;
                if (!Result.m751isFailureimpl(obj7)) {
                }
                break;
            case 5:
                configuration2 = (Configuration) this.L$3;
                obj5 = this.L$2;
                initializeSDK2 = (InitializeSDK) this.L$1;
                coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                initializeStateLoadCache = initializeSDK2.initializeStateLoadCache;
                ResultKt.throwOnFailure(obj5);
                InitializeStateLoadCache.Params params422 = new InitializeStateLoadCache.Params((Configuration) obj5);
                this.L$0 = coroutineScope2;
                this.L$1 = initializeSDK2;
                this.L$2 = obj5;
                this.L$3 = configuration2;
                this.label = 6;
                obj6 = initializeStateLoadCache.mo664invokegIAlus(params422, this);
                if (obj6 == coroutine_suspended) {
                }
                Configuration configuration522 = configuration2;
                obj7 = obj6;
                if (!Result.m751isFailureimpl(obj7)) {
                }
                break;
            case 6:
                configuration2 = (Configuration) this.L$3;
                obj5 = this.L$2;
                initializeSDK2 = (InitializeSDK) this.L$1;
                coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj6 = ((Result) obj).getValue();
                Configuration configuration5222 = configuration2;
                obj7 = obj6;
                if (!Result.m751isFailureimpl(obj7)) {
                }
                break;
            case 7:
                obj7 = this.L$0;
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getValue();
                m748exceptionOrNullimpl3 = Result.m748exceptionOrNullimpl(obj7);
                if (m748exceptionOrNullimpl3 != null) {
                }
                break;
            case 8:
                Object obj15 = this.L$1;
                InitializeSDK initializeSDK5 = (InitializeSDK) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj8 = ((Result) obj).getValue();
                initializeSDK2 = initializeSDK5;
                obj5 = obj15;
                obj9 = obj8;
                if (Result.m751isFailureimpl(obj9)) {
                }
                ResultKt.throwOnFailure(obj9);
                webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj9).getWebViewDataString();
                initializeStateCreate = initializeSDK2.initializeStateCreate;
                ResultKt.throwOnFailure(obj5);
                InitializeStateCreate.Params params62 = new InitializeStateCreate.Params((Configuration) obj5, webViewData);
                this.L$0 = initializeSDK2;
                this.L$1 = obj5;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 10;
                obj10 = initializeStateCreate.mo664invokegIAlus(params62, this);
                if (obj10 == coroutine_suspended) {
                }
                break;
            case 9:
                obj9 = this.L$2;
                obj5 = this.L$1;
                initializeSDK2 = (InitializeSDK) this.L$0;
                ResultKt.throwOnFailure(obj);
                ResultKt.throwOnFailure(obj9);
                webViewData = ((InitializeStateLoadWeb.LoadWebResult) obj9).getWebViewDataString();
                initializeStateCreate = initializeSDK2.initializeStateCreate;
                ResultKt.throwOnFailure(obj5);
                InitializeStateCreate.Params params622 = new InitializeStateCreate.Params((Configuration) obj5, webViewData);
                this.L$0 = initializeSDK2;
                this.L$1 = obj5;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 10;
                obj10 = initializeStateCreate.mo664invokegIAlus(params622, this);
                if (obj10 == coroutine_suspended) {
                }
                break;
            case 10:
                obj11 = this.L$1;
                initializeSDK3 = (InitializeSDK) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj10 = ((Result) obj).getValue();
                if (Result.m751isFailureimpl(obj10)) {
                }
                initializeStateComplete = initializeSDK3.initializeStateComplete;
                ResultKt.throwOnFailure(obj11);
                InitializeStateComplete.Params params72 = new InitializeStateComplete.Params((Configuration) obj11);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 12;
                obj12 = initializeStateComplete.mo664invokegIAlus(params72, this);
                if (obj12 == coroutine_suspended) {
                }
                ResultKt.throwOnFailure(obj12);
                m745constructorimpl = Result.m745constructorimpl(Unit.INSTANCE);
                if (Result.m752isSuccessimpl(m745constructorimpl)) {
                }
                return Result.m744boximpl(m745constructorimpl);
            case 11:
                obj11 = this.L$1;
                initializeSDK3 = (InitializeSDK) this.L$0;
                ResultKt.throwOnFailure(obj);
                initializeStateComplete = initializeSDK3.initializeStateComplete;
                ResultKt.throwOnFailure(obj11);
                InitializeStateComplete.Params params722 = new InitializeStateComplete.Params((Configuration) obj11);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 12;
                obj12 = initializeStateComplete.mo664invokegIAlus(params722, this);
                if (obj12 == coroutine_suspended) {
                }
                ResultKt.throwOnFailure(obj12);
                m745constructorimpl = Result.m745constructorimpl(Unit.INSTANCE);
                if (Result.m752isSuccessimpl(m745constructorimpl)) {
                }
                return Result.m744boximpl(m745constructorimpl);
            case 12:
                ResultKt.throwOnFailure(obj);
                obj12 = ((Result) obj).getValue();
                ResultKt.throwOnFailure(obj12);
                m745constructorimpl = Result.m745constructorimpl(Unit.INSTANCE);
                if (Result.m752isSuccessimpl(m745constructorimpl)) {
                }
                return Result.m744boximpl(m745constructorimpl);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeSDK$executeErrorState$1.java =====
package com.unity3d.services.core.domain.task;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeSDK.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeSDK", m464f = "InitializeSDK.kt", m465i = {}, m466l = {111}, m467m = "executeErrorState-BWLJW6A", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeSDK$executeErrorState$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeSDK$executeErrorState$1(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$executeErrorState$1> continuation) {
        super(continuation);
        this.this$0 = initializeSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m668executeErrorStateBWLJW6A;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m668executeErrorStateBWLJW6A = this.this$0.m668executeErrorStateBWLJW6A(null, null, null, this);
        return m668executeErrorStateBWLJW6A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m668executeErrorStateBWLJW6A : Result.m744boximpl(m668executeErrorStateBWLJW6A);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeSDK$handleInitializationException$1.java =====
package com.unity3d.services.core.domain.task;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeSDK.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeSDK", m464f = "InitializeSDK.kt", m465i = {0}, m466l = {102}, m467m = "handleInitializationException", m468n = {"exception"}, m469s = {"L$0"})
/* loaded from: classes.dex */
final class InitializeSDK$handleInitializationException$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeSDK$handleInitializationException$1(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$handleInitializationException$1> continuation) {
        super(continuation);
        this.this$0 = initializeSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object handleInitializationException;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleInitializationException = this.this$0.handleInitializationException(null, this);
        return handleInitializationException;
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeSDK.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.InitializeStateError;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: InitializeSDK.kt */
@Metadata(m443d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BM\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J*\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ<\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0082@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b#\u0010$J\b\u0010%\u001a\u00020&H\u0016J\u0019\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0082@ø\u0001\u0002¢\u0006\u0002\u0010*R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006+"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeSDK;", "Lcom/unity3d/services/core/domain/task/MetricTask;", "Lcom/unity3d/services/core/domain/task/EmptyParams;", "", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "configFileFromLocalStorage", "Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage;", "initializeStateReset", "Lcom/unity3d/services/core/domain/task/InitializeStateReset;", "initializeStateError", "Lcom/unity3d/services/core/domain/task/InitializeStateError;", "initializeStateConfig", "Lcom/unity3d/services/core/domain/task/InitializeStateConfig;", "initializeStateCreate", "Lcom/unity3d/services/core/domain/task/InitializeStateCreate;", "initializeStateLoadCache", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadCache;", "initializeStateLoadWeb", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb;", "initializeStateComplete", "Lcom/unity3d/services/core/domain/task/InitializeStateComplete;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage;Lcom/unity3d/services/core/domain/task/InitializeStateReset;Lcom/unity3d/services/core/domain/task/InitializeStateError;Lcom/unity3d/services/core/domain/task/InitializeStateConfig;Lcom/unity3d/services/core/domain/task/InitializeStateCreate;Lcom/unity3d/services/core/domain/task/InitializeStateLoadCache;Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb;Lcom/unity3d/services/core/domain/task/InitializeStateComplete;)V", "doWork", "Lkotlin/Result;", "params", "doWork-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/EmptyParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeErrorState", "errorState", "Lcom/unity3d/services/core/configuration/ErrorState;", "taskException", "", "configuration", "Lcom/unity3d/services/core/configuration/Configuration;", "executeErrorState-BWLJW6A", "(Lcom/unity3d/services/core/configuration/ErrorState;Ljava/lang/Throwable;Lcom/unity3d/services/core/configuration/Configuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetricName", "", "handleInitializationException", "exception", "Lcom/unity3d/services/core/domain/task/InitializationException;", "(Lcom/unity3d/services/core/domain/task/InitializationException;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class InitializeSDK extends MetricTask<EmptyParams, Unit> {
    private final ConfigFileFromLocalStorage configFileFromLocalStorage;
    private final ISDKDispatchers dispatchers;
    private final InitializeStateComplete initializeStateComplete;
    private final InitializeStateConfig initializeStateConfig;
    private final InitializeStateCreate initializeStateCreate;
    private final InitializeStateError initializeStateError;
    private final InitializeStateLoadCache initializeStateLoadCache;
    private final InitializeStateLoadWeb initializeStateLoadWeb;
    private final InitializeStateReset initializeStateReset;

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: doWork-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo663doWorkgIAlus(BaseParams baseParams, Continuation continuation) {
        return m669doWorkgIAlus((EmptyParams) baseParams, (Continuation<? super Result<Unit>>) continuation);
    }

    public InitializeSDK(ISDKDispatchers dispatchers, ConfigFileFromLocalStorage configFileFromLocalStorage, InitializeStateReset initializeStateReset, InitializeStateError initializeStateError, InitializeStateConfig initializeStateConfig, InitializeStateCreate initializeStateCreate, InitializeStateLoadCache initializeStateLoadCache, InitializeStateLoadWeb initializeStateLoadWeb, InitializeStateComplete initializeStateComplete) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(configFileFromLocalStorage, "configFileFromLocalStorage");
        Intrinsics.checkNotNullParameter(initializeStateReset, "initializeStateReset");
        Intrinsics.checkNotNullParameter(initializeStateError, "initializeStateError");
        Intrinsics.checkNotNullParameter(initializeStateConfig, "initializeStateConfig");
        Intrinsics.checkNotNullParameter(initializeStateCreate, "initializeStateCreate");
        Intrinsics.checkNotNullParameter(initializeStateLoadCache, "initializeStateLoadCache");
        Intrinsics.checkNotNullParameter(initializeStateLoadWeb, "initializeStateLoadWeb");
        Intrinsics.checkNotNullParameter(initializeStateComplete, "initializeStateComplete");
        this.dispatchers = dispatchers;
        this.configFileFromLocalStorage = configFileFromLocalStorage;
        this.initializeStateReset = initializeStateReset;
        this.initializeStateError = initializeStateError;
        this.initializeStateConfig = initializeStateConfig;
        this.initializeStateCreate = initializeStateCreate;
        this.initializeStateLoadCache = initializeStateLoadCache;
        this.initializeStateLoadWeb = initializeStateLoadWeb;
        this.initializeStateComplete = initializeStateComplete;
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask(MobileAdsBridgeBase.initializeMethodName);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: doWork-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m669doWorkgIAlus(EmptyParams emptyParams, Continuation<? super Result<Unit>> continuation) {
        InitializeSDK$doWork$1 initializeSDK$doWork$1;
        int i;
        if (continuation instanceof InitializeSDK$doWork$1) {
            initializeSDK$doWork$1 = (InitializeSDK$doWork$1) continuation;
            if ((initializeSDK$doWork$1.label & Integer.MIN_VALUE) != 0) {
                initializeSDK$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = initializeSDK$doWork$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeSDK$doWork$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = this.dispatchers.getDefault();
                    InitializeSDK$doWork$2 initializeSDK$doWork$2 = new InitializeSDK$doWork$2(this, null);
                    initializeSDK$doWork$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, initializeSDK$doWork$2, initializeSDK$doWork$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        initializeSDK$doWork$1 = new InitializeSDK$doWork$1(this, continuation);
        Object obj2 = initializeSDK$doWork$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeSDK$doWork$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleInitializationException(InitializationException initializationException, Continuation<? super Unit> continuation) {
        InitializeSDK$handleInitializationException$1 initializeSDK$handleInitializationException$1;
        int i;
        if (continuation instanceof InitializeSDK$handleInitializationException$1) {
            initializeSDK$handleInitializationException$1 = (InitializeSDK$handleInitializationException$1) continuation;
            if ((initializeSDK$handleInitializationException$1.label & Integer.MIN_VALUE) != 0) {
                initializeSDK$handleInitializationException$1.label -= Integer.MIN_VALUE;
                Object obj = initializeSDK$handleInitializationException$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeSDK$handleInitializationException$1.label;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    InitializationException initializationException2 = (InitializationException) initializeSDK$handleInitializationException$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                    throw initializationException2;
                }
                ResultKt.throwOnFailure(obj);
                ErrorState errorState = initializationException.getErrorState();
                Throwable originalException = initializationException.getOriginalException();
                Configuration config = initializationException.getConfig();
                initializeSDK$handleInitializationException$1.L$0 = initializationException;
                initializeSDK$handleInitializationException$1.label = 1;
                if (m668executeErrorStateBWLJW6A(errorState, originalException, config, initializeSDK$handleInitializationException$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                throw initializationException;
            }
        }
        initializeSDK$handleInitializationException$1 = new InitializeSDK$handleInitializationException$1(this, continuation);
        Object obj2 = initializeSDK$handleInitializationException$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeSDK$handleInitializationException$1.label;
        if (i == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: executeErrorState-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m668executeErrorStateBWLJW6A(ErrorState errorState, Throwable th, Configuration configuration, Continuation<? super Result<Unit>> continuation) {
        InitializeSDK$executeErrorState$1 initializeSDK$executeErrorState$1;
        int i;
        if (continuation instanceof InitializeSDK$executeErrorState$1) {
            initializeSDK$executeErrorState$1 = (InitializeSDK$executeErrorState$1) continuation;
            if ((initializeSDK$executeErrorState$1.label & Integer.MIN_VALUE) != 0) {
                initializeSDK$executeErrorState$1.label -= Integer.MIN_VALUE;
                Object obj = initializeSDK$executeErrorState$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeSDK$executeErrorState$1.label;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return ((Result) obj).getValue();
                }
                ResultKt.throwOnFailure(obj);
                InitializeStateError initializeStateError = this.initializeStateError;
                InitializeStateError.Params params = new InitializeStateError.Params(errorState, new Exception(th != null ? th.getMessage() : null), configuration);
                initializeSDK$executeErrorState$1.label = 1;
                Object obj2 = initializeStateError.mo664invokegIAlus(params, initializeSDK$executeErrorState$1);
                return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
            }
        }
        initializeSDK$executeErrorState$1 = new InitializeSDK$executeErrorState$1(this, continuation);
        Object obj3 = initializeSDK$executeErrorState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeSDK$executeErrorState$1.label;
        if (i == 0) {
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateComplete$doWork$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateComplete;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeStateComplete.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateComplete", m464f = "InitializeStateComplete.kt", m465i = {}, m466l = {18}, m467m = "doWork-gIAlu-s", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateComplete$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateComplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateComplete$doWork$1(InitializeStateComplete initializeStateComplete, Continuation<? super InitializeStateComplete$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateComplete;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m670doWorkgIAlus = this.this$0.m670doWorkgIAlus((InitializeStateComplete.Params) null, (Continuation<? super Result<Unit>>) this);
        return m670doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m670doWorkgIAlus : Result.m744boximpl(m670doWorkgIAlus);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateComplete$doWork$2.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.IModuleConfiguration;
import com.unity3d.services.core.domain.task.InitializeStateComplete;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateComplete.kt */
@Metadata(m443d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateComplete$doWork$2", m464f = "InitializeStateComplete.kt", m465i = {}, m466l = {}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateComplete$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ InitializeStateComplete.Params $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateComplete$doWork$2(InitializeStateComplete.Params params, Continuation<? super InitializeStateComplete$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateComplete$doWork$2(this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((InitializeStateComplete$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m745constructorimpl;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        InitializeStateComplete.Params params = this.$params;
        try {
            Result.Companion companion = Result.INSTANCE;
            Class[] moduleConfigurationList = params.getConfig().getModuleConfigurationList();
            Intrinsics.checkNotNullExpressionValue(moduleConfigurationList, "params.config.moduleConfigurationList");
            for (Class cls : moduleConfigurationList) {
                IModuleConfiguration moduleConfiguration = params.getConfig().getModuleConfiguration(cls);
                if (moduleConfiguration != null) {
                    Boxing.boxBoolean(moduleConfiguration.initCompleteState(params.getConfig()));
                }
            }
            m745constructorimpl = Result.m745constructorimpl(Unit.INSTANCE);
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m752isSuccessimpl(m745constructorimpl)) {
            Result.Companion companion3 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(m745constructorimpl);
        } else {
            Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(m745constructorimpl);
            if (m748exceptionOrNullimpl != null) {
                Result.Companion companion4 = Result.INSTANCE;
                m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(m748exceptionOrNullimpl));
            }
        }
        return Result.m744boximpl(m745constructorimpl);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateComplete.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: InitializeStateComplete.kt */
@Metadata(m443d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\u0002H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateComplete;", "Lcom/unity3d/services/core/domain/task/MetricTask;", "Lcom/unity3d/services/core/domain/task/InitializeStateComplete$Params;", "", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;)V", "doWork", "Lkotlin/Result;", "params", "doWork-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/InitializeStateComplete$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetricName", "", "Params", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class InitializeStateComplete extends MetricTask<Params, Unit> {
    private final ISDKDispatchers dispatchers;

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: doWork-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo663doWorkgIAlus(BaseParams baseParams, Continuation continuation) {
        return m670doWorkgIAlus((Params) baseParams, (Continuation<? super Result<Unit>>) continuation);
    }

    public InitializeStateComplete(ISDKDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.dispatchers = dispatchers;
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("completion");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: doWork-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m670doWorkgIAlus(Params params, Continuation<? super Result<Unit>> continuation) {
        InitializeStateComplete$doWork$1 initializeStateComplete$doWork$1;
        int i;
        if (continuation instanceof InitializeStateComplete$doWork$1) {
            initializeStateComplete$doWork$1 = (InitializeStateComplete$doWork$1) continuation;
            if ((initializeStateComplete$doWork$1.label & Integer.MIN_VALUE) != 0) {
                initializeStateComplete$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = initializeStateComplete$doWork$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeStateComplete$doWork$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = this.dispatchers.getDefault();
                    InitializeStateComplete$doWork$2 initializeStateComplete$doWork$2 = new InitializeStateComplete$doWork$2(params, null);
                    initializeStateComplete$doWork$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, initializeStateComplete$doWork$2, initializeStateComplete$doWork$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        initializeStateComplete$doWork$1 = new InitializeStateComplete$doWork$1(this, continuation);
        Object obj2 = initializeStateComplete$doWork$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeStateComplete$doWork$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* compiled from: InitializeStateComplete.kt */
    @Metadata(m443d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateComplete$Params;", "Lcom/unity3d/services/core/domain/task/BaseParams;", "config", "Lcom/unity3d/services/core/configuration/Configuration;", "(Lcom/unity3d/services/core/configuration/Configuration;)V", "getConfig", "()Lcom/unity3d/services/core/configuration/Configuration;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final /* data */ class Params implements BaseParams {
        private final Configuration config;

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, int i, Object obj) {
            if ((i & 1) != 0) {
                configuration = params.config;
            }
            return params.copy(configuration);
        }

        /* renamed from: component1, reason: from getter */
        public final Configuration getConfig() {
            return this.config;
        }

        public final Params copy(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new Params(config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.config, ((Params) other).config);
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Params(config=" + this.config + ')';
        }

        public Params(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
        }

        public final Configuration getConfig() {
            return this.config;
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateConfig$doWork$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeStateConfig.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateConfig", m464f = "InitializeStateConfig.kt", m465i = {}, m466l = {24}, m467m = "doWork-gIAlu-s", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateConfig$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateConfig this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateConfig$doWork$1(InitializeStateConfig initializeStateConfig, Continuation<? super InitializeStateConfig$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m671doWorkgIAlus = this.this$0.m671doWorkgIAlus((InitializeStateConfig.Params) null, (Continuation<? super Result<? extends Configuration>>) this);
        return m671doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m671doWorkgIAlus : Result.m744boximpl(m671doWorkgIAlus);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateConfig$doWork$2.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.task.InitializeStateConfig;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.NetworkIOException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateConfig.kt */
@Metadata(m443d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "Lcom/unity3d/services/core/configuration/Configuration;", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$2", m464f = "InitializeStateConfig.kt", m465i = {0}, m466l = {32}, m467m = "invokeSuspend", m468n = {"configuration"}, m469s = {"L$0"})
/* loaded from: classes.dex */
final class InitializeStateConfig$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Configuration>>, Object> {
    final /* synthetic */ InitializeStateConfig.Params $params;
    Object L$0;
    int label;
    final /* synthetic */ InitializeStateConfig this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateConfig$doWork$2(InitializeStateConfig.Params params, InitializeStateConfig initializeStateConfig, Continuation<? super InitializeStateConfig$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateConfig$doWork$2(this.$params, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Configuration>> continuation) {
        return ((InitializeStateConfig$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m745constructorimpl;
        InitializeStateConfigWithLoader initializeStateConfigWithLoader;
        Object mo664invokegIAlus;
        Configuration configuration = "Unity Ads init: load configuration from ";
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    InitializeStateConfig.Params params = this.$params;
                    InitializeStateConfig initializeStateConfig = this.this$0;
                    Result.Companion companion = Result.INSTANCE;
                    DeviceLog.info("Unity Ads init: load configuration from " + SdkProperties.getConfigUrl());
                    Configuration configuration2 = new Configuration(SdkProperties.getConfigUrl(), params.getConfig().getExperimentsReader());
                    initializeStateConfigWithLoader = initializeStateConfig.initializeStateConfigWithLoader;
                    InitializeStateConfigWithLoader.Params params2 = new InitializeStateConfigWithLoader.Params(configuration2);
                    this.L$0 = configuration2;
                    this.label = 1;
                    mo664invokegIAlus = initializeStateConfigWithLoader.mo664invokegIAlus(params2, (Continuation<? super Result<? extends Configuration>>) this);
                    configuration = configuration2;
                    if (mo664invokegIAlus == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Configuration configuration3 = (Configuration) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mo664invokegIAlus = ((Result) obj).getValue();
                    configuration = configuration3;
                }
                ResultKt.throwOnFailure(mo664invokegIAlus);
                m745constructorimpl = Result.m745constructorimpl((Configuration) mo664invokegIAlus);
            } catch (NetworkIOException e) {
                throw new InitializationException(ErrorState.NetworkConfigRequest, e, configuration);
            }
        } catch (CancellationException e2) {
            throw e2;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m752isSuccessimpl(m745constructorimpl)) {
            Result.Companion companion3 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(m745constructorimpl);
        } else {
            Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(m745constructorimpl);
            if (m748exceptionOrNullimpl != null) {
                Result.Companion companion4 = Result.INSTANCE;
                m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(m748exceptionOrNullimpl));
            }
        }
        return Result.m744boximpl(m745constructorimpl);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateConfig.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: InitializeStateConfig.kt */
@Metadata(m443d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateConfig;", "Lcom/unity3d/services/core/domain/task/MetricTask;", "Lcom/unity3d/services/core/domain/task/InitializeStateConfig$Params;", "Lcom/unity3d/services/core/configuration/Configuration;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "initializeStateConfigWithLoader", "Lcom/unity3d/services/core/domain/task/InitializeStateConfigWithLoader;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;Lcom/unity3d/services/core/domain/task/InitializeStateConfigWithLoader;)V", "doWork", "Lkotlin/Result;", "params", "doWork-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/InitializeStateConfig$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetricName", "", "Params", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class InitializeStateConfig extends MetricTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;
    private final InitializeStateConfigWithLoader initializeStateConfigWithLoader;

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: doWork-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo663doWorkgIAlus(BaseParams baseParams, Continuation continuation) {
        return m671doWorkgIAlus((Params) baseParams, (Continuation<? super Result<? extends Configuration>>) continuation);
    }

    public InitializeStateConfig(ISDKDispatchers dispatchers, InitializeStateConfigWithLoader initializeStateConfigWithLoader) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(initializeStateConfigWithLoader, "initializeStateConfigWithLoader");
        this.dispatchers = dispatchers;
        this.initializeStateConfigWithLoader = initializeStateConfigWithLoader;
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("config_fetch");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: doWork-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m671doWorkgIAlus(Params params, Continuation<? super Result<? extends Configuration>> continuation) {
        InitializeStateConfig$doWork$1 initializeStateConfig$doWork$1;
        int i;
        if (continuation instanceof InitializeStateConfig$doWork$1) {
            initializeStateConfig$doWork$1 = (InitializeStateConfig$doWork$1) continuation;
            if ((initializeStateConfig$doWork$1.label & Integer.MIN_VALUE) != 0) {
                initializeStateConfig$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = initializeStateConfig$doWork$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeStateConfig$doWork$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = this.dispatchers.getDefault();
                    InitializeStateConfig$doWork$2 initializeStateConfig$doWork$2 = new InitializeStateConfig$doWork$2(params, this, null);
                    initializeStateConfig$doWork$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, initializeStateConfig$doWork$2, initializeStateConfig$doWork$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        initializeStateConfig$doWork$1 = new InitializeStateConfig$doWork$1(this, continuation);
        Object obj2 = initializeStateConfig$doWork$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeStateConfig$doWork$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* compiled from: InitializeStateConfig.kt */
    @Metadata(m443d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateConfig$Params;", "Lcom/unity3d/services/core/domain/task/BaseParams;", "config", "Lcom/unity3d/services/core/configuration/Configuration;", "(Lcom/unity3d/services/core/configuration/Configuration;)V", "getConfig", "()Lcom/unity3d/services/core/configuration/Configuration;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final /* data */ class Params implements BaseParams {
        private final Configuration config;

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, int i, Object obj) {
            if ((i & 1) != 0) {
                configuration = params.config;
            }
            return params.copy(configuration);
        }

        /* renamed from: component1, reason: from getter */
        public final Configuration getConfig() {
            return this.config;
        }

        public final Params copy(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new Params(config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.config, ((Params) other).config);
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Params(config=" + this.config + ')';
        }

        public Params(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
        }

        public final Configuration getConfig() {
            return this.config;
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateConfigWithLoader$doWork$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeStateConfigWithLoader.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader", m464f = "InitializeStateConfigWithLoader.kt", m465i = {}, m466l = {33}, m467m = "doWork-gIAlu-s", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateConfigWithLoader$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateConfigWithLoader$doWork$1(InitializeStateConfigWithLoader initializeStateConfigWithLoader, Continuation<? super InitializeStateConfigWithLoader$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateConfigWithLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo663doWorkgIAlus = this.this$0.mo663doWorkgIAlus((InitializeStateConfigWithLoader.Params) null, (Continuation<? super Result<? extends Configuration>>) this);
        return mo663doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo663doWorkgIAlus : Result.m744boximpl(mo663doWorkgIAlus);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateConfigWithLoader$doWork$2$1$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.IConfigurationLoader;
import com.unity3d.services.core.configuration.IConfigurationLoaderListener;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateConfigWithLoader.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$1", m464f = "InitializeStateConfigWithLoader.kt", m465i = {}, m466l = {}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateConfigWithLoader$doWork$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Configuration> $config;
    final /* synthetic */ Ref.ObjectRef<IConfigurationLoader> $configurationLoader;
    final /* synthetic */ InitializeStateConfigWithLoader.Params $params;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateConfigWithLoader$doWork$2$1$1(Ref.ObjectRef<IConfigurationLoader> objectRef, Ref.ObjectRef<Configuration> objectRef2, InitializeStateConfigWithLoader initializeStateConfigWithLoader, InitializeStateConfigWithLoader.Params params, Continuation<? super InitializeStateConfigWithLoader$doWork$2$1$1> continuation) {
        super(2, continuation);
        this.$configurationLoader = objectRef;
        this.$config = objectRef2;
        this.this$0 = initializeStateConfigWithLoader;
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateConfigWithLoader$doWork$2$1$1(this.$configurationLoader, this.$config, this.this$0, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeStateConfigWithLoader$doWork$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        IConfigurationLoader iConfigurationLoader = this.$configurationLoader.element;
        final Ref.ObjectRef<Configuration> objectRef = this.$config;
        final InitializeStateConfigWithLoader initializeStateConfigWithLoader = this.this$0;
        final InitializeStateConfigWithLoader.Params params = this.$params;
        iConfigurationLoader.loadConfiguration(new IConfigurationLoaderListener() { // from class: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$1.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.unity3d.services.core.configuration.IConfigurationLoaderListener
            public void onSuccess(Configuration configuration) {
                TokenStorage tokenStorage;
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                objectRef.element = configuration;
                objectRef.element.saveToDisk();
                tokenStorage = initializeStateConfigWithLoader.tokenStorage;
                tokenStorage.setInitToken(objectRef.element.getUnifiedAuctionToken());
            }

            @Override // com.unity3d.services.core.configuration.IConfigurationLoaderListener
            public void onError(String errorMsg) {
                SDKMetricsSender sDKMetricsSender;
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                sDKMetricsSender = initializeStateConfigWithLoader.sdkMetricsSender;
                Metric newEmergencySwitchOff = TSIMetric.newEmergencySwitchOff();
                Intrinsics.checkNotNullExpressionValue(newEmergencySwitchOff, "newEmergencySwitchOff()");
                sDKMetricsSender.sendMetric(newEmergencySwitchOff);
                throw new InitializationException(ErrorState.NetworkConfigRequest, new Exception(errorMsg), params.getConfig());
            }
        });
        return Unit.INSTANCE;
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IConfigurationLoader;
import com.unity3d.services.core.configuration.IConfigurationLoaderListener;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.extensions.AbortRetryException;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateConfigWithLoader.kt */
@Metadata(m443d1 = {"\u0000\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m444d2 = {"", "it", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1", m464f = "InitializeStateConfigWithLoader.kt", m465i = {}, m466l = {69}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Configuration> $config;
    final /* synthetic */ Ref.ObjectRef<IConfigurationLoader> $configurationLoader;
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1(InitializeStateConfigWithLoader initializeStateConfigWithLoader, Ref.ObjectRef<IConfigurationLoader> objectRef, Ref.ObjectRef<Configuration> objectRef2, Continuation<? super InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateConfigWithLoader;
        this.$configurationLoader = objectRef;
        this.$config = objectRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1 initializeStateConfigWithLoader$doWork$2$1$configResult$1$1 = new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1(this.this$0, this.$configurationLoader, this.$config, continuation);
        initializeStateConfigWithLoader$doWork$2$1$configResult$1$1.I$0 = ((Number) obj).intValue();
        return initializeStateConfigWithLoader$doWork$2$1$configResult$1$1;
    }

    public final Object invoke(int i, Continuation<? super Unit> continuation) {
        return ((InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
        return invoke(num.intValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISDKDispatchers iSDKDispatchers;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.I$0 > 0) {
                InitializeEventsMetricSender.getInstance().onRetryConfig();
            }
            iSDKDispatchers = this.this$0.dispatchers;
            this.label = 1;
            if (BuildersKt.withContext(iSDKDispatchers.getIo(), new C12441(this.$configurationLoader, this.$config, this.this$0, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: InitializeStateConfigWithLoader.kt */
    @Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
    @DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1", m464f = "InitializeStateConfigWithLoader.kt", m465i = {}, m466l = {}, m467m = "invokeSuspend", m468n = {}, m469s = {})
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1$1 */
    static final class C12441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<Configuration> $config;
        final /* synthetic */ Ref.ObjectRef<IConfigurationLoader> $configurationLoader;
        int label;
        final /* synthetic */ InitializeStateConfigWithLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12441(Ref.ObjectRef<IConfigurationLoader> objectRef, Ref.ObjectRef<Configuration> objectRef2, InitializeStateConfigWithLoader initializeStateConfigWithLoader, Continuation<? super C12441> continuation) {
            super(2, continuation);
            this.$configurationLoader = objectRef;
            this.$config = objectRef2;
            this.this$0 = initializeStateConfigWithLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C12441(this.$configurationLoader, this.$config, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            IConfigurationLoader iConfigurationLoader = this.$configurationLoader.element;
            final Ref.ObjectRef<Configuration> objectRef = this.$config;
            final InitializeStateConfigWithLoader initializeStateConfigWithLoader = this.this$0;
            iConfigurationLoader.loadConfiguration(new IConfigurationLoaderListener() { // from class: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader.doWork.2.1.configResult.1.1.1.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.unity3d.services.core.configuration.IConfigurationLoaderListener
                public void onSuccess(Configuration configuration) {
                    TokenStorage tokenStorage;
                    Intrinsics.checkNotNullParameter(configuration, "configuration");
                    objectRef.element = configuration;
                    objectRef.element.saveToDisk();
                    tokenStorage = initializeStateConfigWithLoader.tokenStorage;
                    tokenStorage.setInitToken(objectRef.element.getUnifiedAuctionToken());
                }

                @Override // com.unity3d.services.core.configuration.IConfigurationLoaderListener
                public void onError(String errorMsg) {
                    SDKMetricsSender sDKMetricsSender;
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    sDKMetricsSender = initializeStateConfigWithLoader.sdkMetricsSender;
                    Metric newEmergencySwitchOff = TSIMetric.newEmergencySwitchOff();
                    Intrinsics.checkNotNullExpressionValue(newEmergencySwitchOff, "newEmergencySwitchOff()");
                    sDKMetricsSender.sendMetric(newEmergencySwitchOff);
                    throw new AbortRetryException(errorMsg);
                }
            });
            return Unit.INSTANCE;
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateConfigWithLoader$doWork$2.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ConfigurationLoader;
import com.unity3d.services.core.configuration.ConfigurationRequestFactory;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.IConfigurationLoader;
import com.unity3d.services.core.configuration.InitRequestType;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.configuration.PrivacyConfigurationLoader;
import com.unity3d.services.core.device.reader.DeviceInfoDataFactory;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.extensions.AbortRetryException;
import com.unity3d.services.core.extensions.TaskExtensionsKt;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateConfigWithLoader.kt */
@Metadata(m443d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "Lcom/unity3d/services/core/configuration/Configuration;", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2", m464f = "InitializeStateConfigWithLoader.kt", m465i = {0, 0, 0, 1, 1, 2}, m466l = {58, 101, 109}, m467m = "invokeSuspend", m468n = {"$this$withContext", "configurationLoader", "config", "configurationLoader", "config", "config"}, m469s = {"L$0", "L$3", "L$4", "L$2", "L$3", "L$0"})
/* loaded from: classes.dex */
final class InitializeStateConfigWithLoader$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Configuration>>, Object> {
    final /* synthetic */ InitializeStateConfigWithLoader.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateConfigWithLoader$doWork$2(InitializeStateConfigWithLoader initializeStateConfigWithLoader, InitializeStateConfigWithLoader.Params params, Continuation<? super InitializeStateConfigWithLoader$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateConfigWithLoader;
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateConfigWithLoader$doWork$2 initializeStateConfigWithLoader$doWork$2 = new InitializeStateConfigWithLoader$doWork$2(this.this$0, this.$params, continuation);
        initializeStateConfigWithLoader$doWork$2.L$0 = obj;
        return initializeStateConfigWithLoader$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Configuration>> continuation) {
        return ((InitializeStateConfigWithLoader$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01c0 A[Catch: all -> 0x022e, CancellationException -> 0x025b, TryCatch #7 {CancellationException -> 0x025b, all -> 0x022e, blocks: (B:8:0x001d, B:9:0x01f2, B:10:0x0223, B:26:0x01b8, B:28:0x01c0, B:32:0x01fc, B:33:0x020e, B:36:0x01ae, B:41:0x016c, B:43:0x0175, B:45:0x020f, B:46:0x021c, B:55:0x021d, B:58:0x0162, B:60:0x007e), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01fc A[Catch: all -> 0x022e, CancellationException -> 0x025b, TryCatch #7 {CancellationException -> 0x025b, all -> 0x022e, blocks: (B:8:0x001d, B:9:0x01f2, B:10:0x0223, B:26:0x01b8, B:28:0x01c0, B:32:0x01fc, B:33:0x020e, B:36:0x01ae, B:41:0x016c, B:43:0x0175, B:45:0x020f, B:46:0x021c, B:55:0x021d, B:58:0x0162, B:60:0x007e), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0175 A[Catch: all -> 0x022e, CancellationException -> 0x025b, TRY_LEAVE, TryCatch #7 {CancellationException -> 0x025b, all -> 0x022e, blocks: (B:8:0x001d, B:9:0x01f2, B:10:0x0223, B:26:0x01b8, B:28:0x01c0, B:32:0x01fc, B:33:0x020e, B:36:0x01ae, B:41:0x016c, B:43:0x0175, B:45:0x020f, B:46:0x021c, B:55:0x021d, B:58:0x0162, B:60:0x007e), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x021d A[Catch: all -> 0x022e, CancellationException -> 0x025b, TryCatch #7 {CancellationException -> 0x025b, all -> 0x022e, blocks: (B:8:0x001d, B:9:0x01f2, B:10:0x0223, B:26:0x01b8, B:28:0x01c0, B:32:0x01fc, B:33:0x020e, B:36:0x01ae, B:41:0x016c, B:43:0x0175, B:45:0x020f, B:46:0x021c, B:55:0x021d, B:58:0x0162, B:60:0x007e), top: B:2:0x000d }] */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, com.unity3d.services.core.configuration.Configuration] */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, com.unity3d.services.core.configuration.ConfigurationLoader] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, com.unity3d.services.core.configuration.PrivacyConfigurationLoader] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m745constructorimpl;
        SDKMetricsSender sDKMetricsSender;
        SDKMetricsSender sDKMetricsSender2;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        InitializeStateConfigWithLoader initializeStateConfigWithLoader;
        InitializeStateConfigWithLoader.Params params;
        Object m745constructorimpl2;
        InitializeStateConfigWithLoader initializeStateConfigWithLoader2;
        InitializeStateConfigWithLoader.Params params2;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Ref.ObjectRef objectRef6;
        InitializeStateNetworkError initializeStateNetworkError;
        Object obj2;
        Object m745constructorimpl3;
        ISDKDispatchers iSDKDispatchers;
        Ref.ObjectRef objectRef7;
        Ref.ObjectRef objectRef8;
        T t;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            InitializeStateConfigWithLoader initializeStateConfigWithLoader3 = this.this$0;
            InitializeStateConfigWithLoader.Params params3 = this.$params;
            Result.Companion companion2 = Result.INSTANCE;
            PrivacyConfigStorage privacyConfigStorage = PrivacyConfigStorage.getInstance();
            sDKMetricsSender = initializeStateConfigWithLoader3.sdkMetricsSender;
            DeviceInfoDataFactory deviceInfoDataFactory = new DeviceInfoDataFactory(sDKMetricsSender);
            Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
            ConfigurationRequestFactory configurationRequestFactory = new ConfigurationRequestFactory(params3.getConfig(), deviceInfoDataFactory.getDeviceInfoData(InitRequestType.TOKEN));
            sDKMetricsSender2 = initializeStateConfigWithLoader3.sdkMetricsSender;
            objectRef9.element = new ConfigurationLoader(configurationRequestFactory, sDKMetricsSender2, (HttpClient) initializeStateConfigWithLoader3.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(HttpClient.class)));
            objectRef9.element = new PrivacyConfigurationLoader((IConfigurationLoader) objectRef9.element, new ConfigurationRequestFactory(params3.getConfig(), deviceInfoDataFactory.getDeviceInfoData(InitRequestType.PRIVACY)), privacyConfigStorage, (HttpClient) initializeStateConfigWithLoader3.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(HttpClient.class)));
            Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
            objectRef10.element = new Configuration();
            try {
                Result.Companion companion3 = Result.INSTANCE;
                int maxRetries = params3.getConfig().getMaxRetries();
                double retryScalingFactor = params3.getConfig().getRetryScalingFactor();
                long retryDelay = params3.getConfig().getRetryDelay();
                InitializationException initializationException = new InitializationException(ErrorState.NetworkConfigRequest, new Exception(), params3.getConfig());
                InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1 initializeStateConfigWithLoader$doWork$2$1$configResult$1$1 = new InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1(initializeStateConfigWithLoader3, objectRef9, objectRef10, null);
                this.L$0 = coroutineScope;
                this.L$1 = initializeStateConfigWithLoader3;
                this.L$2 = params3;
                this.L$3 = objectRef9;
                this.L$4 = objectRef10;
                this.label = 1;
                objectRef = objectRef9;
                try {
                    if (TaskExtensionsKt.withRetry(retryDelay, maxRetries, retryScalingFactor, initializationException, initializeStateConfigWithLoader$doWork$2$1$configResult$1$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef2 = objectRef10;
                    objectRef3 = objectRef;
                    initializeStateConfigWithLoader = initializeStateConfigWithLoader3;
                    params = params3;
                } catch (Throwable th2) {
                    th = th2;
                    objectRef2 = objectRef10;
                    objectRef3 = objectRef;
                    initializeStateConfigWithLoader = initializeStateConfigWithLoader3;
                    params = params3;
                    Result.Companion companion4 = Result.INSTANCE;
                    m745constructorimpl2 = Result.m745constructorimpl(ResultKt.createFailure(th));
                    initializeStateConfigWithLoader2 = initializeStateConfigWithLoader;
                    params2 = params;
                    objectRef4 = objectRef3;
                    if (Result.m751isFailureimpl(m745constructorimpl2)) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                objectRef = objectRef9;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef7 = (Ref.ObjectRef) this.L$1;
                    objectRef8 = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Configuration configuration = (Configuration) objectRef8.element;
                    Ref.ObjectRef objectRef11 = objectRef8;
                    objectRef2 = objectRef7;
                    objectRef5 = objectRef11;
                    t = configuration;
                    objectRef2.element = t;
                    m745constructorimpl = Result.m745constructorimpl((Configuration) objectRef5.element);
                    if (Result.m752isSuccessimpl(m745constructorimpl)) {
                        Result.Companion companion5 = Result.INSTANCE;
                        m745constructorimpl = Result.m745constructorimpl(m745constructorimpl);
                    } else {
                        Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(m745constructorimpl);
                        if (m748exceptionOrNullimpl != null) {
                            Result.Companion companion6 = Result.INSTANCE;
                            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(m748exceptionOrNullimpl));
                        }
                    }
                    return Result.m744boximpl(m745constructorimpl);
                }
                objectRef2 = (Ref.ObjectRef) this.L$4;
                objectRef6 = (Ref.ObjectRef) this.L$3;
                objectRef4 = (Ref.ObjectRef) this.L$2;
                params2 = (InitializeStateConfigWithLoader.Params) this.L$1;
                initializeStateConfigWithLoader2 = (InitializeStateConfigWithLoader) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    obj2 = ((Result) obj).getValue();
                    m745constructorimpl3 = Result.m745constructorimpl(Result.m744boximpl(obj2));
                } catch (Throwable th4) {
                    th = th4;
                    Result.Companion companion7 = Result.INSTANCE;
                    m745constructorimpl3 = Result.m745constructorimpl(ResultKt.createFailure(th));
                    Ref.ObjectRef objectRef12 = objectRef6;
                    InitializeStateConfigWithLoader.Params params4 = params2;
                    if (!Result.m752isSuccessimpl(m745constructorimpl3)) {
                    }
                }
                Ref.ObjectRef objectRef122 = objectRef6;
                InitializeStateConfigWithLoader.Params params42 = params2;
                if (!Result.m752isSuccessimpl(m745constructorimpl3)) {
                    InitializeEventsMetricSender.getInstance().onRetryConfig();
                    iSDKDispatchers = initializeStateConfigWithLoader2.dispatchers;
                    CoroutineDispatcher io = iSDKDispatchers.getIo();
                    InitializeStateConfigWithLoader$doWork$2$1$1 initializeStateConfigWithLoader$doWork$2$1$1 = new InitializeStateConfigWithLoader$doWork$2$1$1(objectRef4, objectRef122, initializeStateConfigWithLoader2, params42, null);
                    this.L$0 = objectRef122;
                    this.L$1 = objectRef2;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.label = 3;
                    if (BuildersKt.withContext(io, initializeStateConfigWithLoader$doWork$2$1$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef7 = objectRef2;
                    objectRef8 = objectRef122;
                    Configuration configuration2 = (Configuration) objectRef8.element;
                    Ref.ObjectRef objectRef112 = objectRef8;
                    objectRef2 = objectRef7;
                    objectRef5 = objectRef112;
                    t = configuration2;
                    objectRef2.element = t;
                    m745constructorimpl = Result.m745constructorimpl((Configuration) objectRef5.element);
                    if (Result.m752isSuccessimpl(m745constructorimpl)) {
                    }
                    return Result.m744boximpl(m745constructorimpl);
                }
                throw new InitializationException(ErrorState.NetworkConfigRequest, new Exception("No connected events within the timeout!"), params42.getConfig());
            }
            objectRef2 = (Ref.ObjectRef) this.L$4;
            objectRef3 = (Ref.ObjectRef) this.L$3;
            params = (InitializeStateConfigWithLoader.Params) this.L$2;
            initializeStateConfigWithLoader = (InitializeStateConfigWithLoader) this.L$1;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th5) {
                th = th5;
                Result.Companion companion42 = Result.INSTANCE;
                m745constructorimpl2 = Result.m745constructorimpl(ResultKt.createFailure(th));
                initializeStateConfigWithLoader2 = initializeStateConfigWithLoader;
                params2 = params;
                objectRef4 = objectRef3;
                if (Result.m751isFailureimpl(m745constructorimpl2)) {
                }
            }
        }
        m745constructorimpl2 = Result.m745constructorimpl(Unit.INSTANCE);
        initializeStateConfigWithLoader2 = initializeStateConfigWithLoader;
        params2 = params;
        objectRef4 = objectRef3;
        if (Result.m751isFailureimpl(m745constructorimpl2)) {
            Throwable m748exceptionOrNullimpl2 = Result.m748exceptionOrNullimpl(m745constructorimpl2);
            if (m748exceptionOrNullimpl2 instanceof AbortRetryException) {
                throw new InitializationException(ErrorState.NetworkConfigRequest, (Exception) m748exceptionOrNullimpl2, params2.getConfig());
            }
            try {
                Result.Companion companion8 = Result.INSTANCE;
                initializeStateNetworkError = initializeStateConfigWithLoader2.initializeStateNetworkError;
                InitializeStateNetworkError.Params params5 = new InitializeStateNetworkError.Params(params2.getConfig());
                this.L$0 = initializeStateConfigWithLoader2;
                this.L$1 = params2;
                this.L$2 = objectRef4;
                this.L$3 = objectRef2;
                this.L$4 = objectRef2;
                this.label = 2;
                obj2 = initializeStateNetworkError.mo664invokegIAlus(params5, this);
            } catch (Throwable th6) {
                th = th6;
                objectRef6 = objectRef2;
                Result.Companion companion72 = Result.INSTANCE;
                m745constructorimpl3 = Result.m745constructorimpl(ResultKt.createFailure(th));
                Ref.ObjectRef objectRef1222 = objectRef6;
                InitializeStateConfigWithLoader.Params params422 = params2;
                if (!Result.m752isSuccessimpl(m745constructorimpl3)) {
                }
            }
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef6 = objectRef2;
            m745constructorimpl3 = Result.m745constructorimpl(Result.m744boximpl(obj2));
            Ref.ObjectRef objectRef12222 = objectRef6;
            InitializeStateConfigWithLoader.Params params4222 = params2;
            if (!Result.m752isSuccessimpl(m745constructorimpl3)) {
            }
        } else {
            objectRef5 = objectRef2;
            t = (Configuration) objectRef2.element;
            objectRef2.element = t;
            m745constructorimpl = Result.m745constructorimpl((Configuration) objectRef5.element);
            if (Result.m752isSuccessimpl(m745constructorimpl)) {
            }
            return Result.m744boximpl(m745constructorimpl);
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateConfigWithLoader.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.BaseTask;
import com.unity3d.services.core.p005di.IServiceProvider;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: InitializeStateConfigWithLoader.kt */
@Metadata(m443d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateConfigWithLoader;", "Lcom/unity3d/services/core/domain/task/BaseTask;", "Lcom/unity3d/services/core/domain/task/InitializeStateConfigWithLoader$Params;", "Lcom/unity3d/services/core/configuration/Configuration;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "initializeStateNetworkError", "Lcom/unity3d/services/core/domain/task/InitializeStateNetworkError;", "tokenStorage", "Lcom/unity3d/services/ads/token/TokenStorage;", "sdkMetricsSender", "Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;Lcom/unity3d/services/core/domain/task/InitializeStateNetworkError;Lcom/unity3d/services/ads/token/TokenStorage;Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;)V", "doWork", "Lkotlin/Result;", "params", "doWork-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/InitializeStateConfigWithLoader$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Params", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class InitializeStateConfigWithLoader implements BaseTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;
    private final InitializeStateNetworkError initializeStateNetworkError;
    private final SDKMetricsSender sdkMetricsSender;
    private final TokenStorage tokenStorage;

    public InitializeStateConfigWithLoader(ISDKDispatchers dispatchers, InitializeStateNetworkError initializeStateNetworkError, TokenStorage tokenStorage, SDKMetricsSender sdkMetricsSender) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(initializeStateNetworkError, "initializeStateNetworkError");
        Intrinsics.checkNotNullParameter(tokenStorage, "tokenStorage");
        Intrinsics.checkNotNullParameter(sdkMetricsSender, "sdkMetricsSender");
        this.dispatchers = dispatchers;
        this.initializeStateNetworkError = initializeStateNetworkError;
        this.tokenStorage = tokenStorage;
        this.sdkMetricsSender = sdkMetricsSender;
    }

    @Override // com.unity3d.services.core.p005di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return BaseTask.DefaultImpls.getServiceProvider(this);
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: invoke-gIAlu-s, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public Object mo664invokegIAlus(Params params, Continuation<? super Result<? extends Configuration>> continuation) {
        return BaseTask.DefaultImpls.m665invokegIAlus(this, params, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: doWork-gIAlu-s, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo663doWorkgIAlus(Params params, Continuation<? super Result<? extends Configuration>> continuation) {
        InitializeStateConfigWithLoader$doWork$1 initializeStateConfigWithLoader$doWork$1;
        int i;
        if (continuation instanceof InitializeStateConfigWithLoader$doWork$1) {
            initializeStateConfigWithLoader$doWork$1 = (InitializeStateConfigWithLoader$doWork$1) continuation;
            if ((initializeStateConfigWithLoader$doWork$1.label & Integer.MIN_VALUE) != 0) {
                initializeStateConfigWithLoader$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = initializeStateConfigWithLoader$doWork$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeStateConfigWithLoader$doWork$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = this.dispatchers.getDefault();
                    InitializeStateConfigWithLoader$doWork$2 initializeStateConfigWithLoader$doWork$2 = new InitializeStateConfigWithLoader$doWork$2(this, params, null);
                    initializeStateConfigWithLoader$doWork$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, initializeStateConfigWithLoader$doWork$2, initializeStateConfigWithLoader$doWork$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        initializeStateConfigWithLoader$doWork$1 = new InitializeStateConfigWithLoader$doWork$1(this, continuation);
        Object obj2 = initializeStateConfigWithLoader$doWork$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeStateConfigWithLoader$doWork$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* compiled from: InitializeStateConfigWithLoader.kt */
    @Metadata(m443d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateConfigWithLoader$Params;", "Lcom/unity3d/services/core/domain/task/BaseParams;", "config", "Lcom/unity3d/services/core/configuration/Configuration;", "(Lcom/unity3d/services/core/configuration/Configuration;)V", "getConfig", "()Lcom/unity3d/services/core/configuration/Configuration;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final /* data */ class Params implements BaseParams {
        private final Configuration config;

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, int i, Object obj) {
            if ((i & 1) != 0) {
                configuration = params.config;
            }
            return params.copy(configuration);
        }

        /* renamed from: component1, reason: from getter */
        public final Configuration getConfig() {
            return this.config;
        }

        public final Params copy(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new Params(config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.config, ((Params) other).config);
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Params(config=" + this.config + ')';
        }

        public Params(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
        }

        public final Configuration getConfig() {
            return this.config;
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateCreate$doWork$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateCreate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeStateCreate.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateCreate", m464f = "InitializeStateCreate.kt", m465i = {}, m466l = {28}, m467m = "doWork-gIAlu-s", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateCreate$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateCreate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateCreate$doWork$1(InitializeStateCreate initializeStateCreate, Continuation<? super InitializeStateCreate$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateCreate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m674doWorkgIAlus = this.this$0.m674doWorkgIAlus((InitializeStateCreate.Params) null, (Continuation<? super Result<? extends Configuration>>) this);
        return m674doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m674doWorkgIAlus : Result.m744boximpl(m674doWorkgIAlus);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateCreate$doWork$2.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.task.InitializeStateCreate;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateCreate.kt */
@Metadata(m443d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "Lcom/unity3d/services/core/configuration/Configuration;", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateCreate$doWork$2", m464f = "InitializeStateCreate.kt", m465i = {}, m466l = {}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateCreate$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Configuration>>, Object> {
    final /* synthetic */ InitializeStateCreate.Params $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateCreate$doWork$2(InitializeStateCreate.Params params, Continuation<? super InitializeStateCreate$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateCreate$doWork$2(this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Configuration>> continuation) {
        return ((InitializeStateCreate$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m745constructorimpl;
        Configuration config;
        ErrorState create;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        InitializeStateCreate.Params params = this.$params;
        try {
            Result.Companion companion = Result.INSTANCE;
            DeviceLog.debug("Unity Ads init: creating webapp");
            config = params.getConfig();
            config.setWebViewData(params.getWebViewData());
            try {
                create = WebViewApp.create(config, false);
            } catch (IllegalThreadStateException e) {
                DeviceLog.exception("Illegal Thread", e);
                throw new InitializationException(ErrorState.CreateWebApp, e, config);
            }
        } catch (CancellationException e2) {
            throw e2;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th));
        }
        if (create != null) {
            String webAppFailureMessage = WebViewApp.getCurrentApp().getWebAppFailureMessage() != null ? WebViewApp.getCurrentApp().getWebAppFailureMessage() : "Unity Ads WebApp creation failed";
            DeviceLog.error(webAppFailureMessage);
            throw new InitializationException(create, new Exception(webAppFailureMessage), config);
        }
        m745constructorimpl = Result.m745constructorimpl(config);
        if (Result.m752isSuccessimpl(m745constructorimpl)) {
            Result.Companion companion3 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(m745constructorimpl);
        } else {
            Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(m745constructorimpl);
            if (m748exceptionOrNullimpl != null) {
                Result.Companion companion4 = Result.INSTANCE;
                m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(m748exceptionOrNullimpl));
            }
        }
        return Result.m744boximpl(m745constructorimpl);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateCreate.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: InitializeStateCreate.kt */
@Metadata(m443d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\u0002H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateCreate;", "Lcom/unity3d/services/core/domain/task/MetricTask;", "Lcom/unity3d/services/core/domain/task/InitializeStateCreate$Params;", "Lcom/unity3d/services/core/configuration/Configuration;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;)V", "doWork", "Lkotlin/Result;", "params", "doWork-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/InitializeStateCreate$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetricName", "", "Params", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class InitializeStateCreate extends MetricTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: doWork-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo663doWorkgIAlus(BaseParams baseParams, Continuation continuation) {
        return m674doWorkgIAlus((Params) baseParams, (Continuation<? super Result<? extends Configuration>>) continuation);
    }

    public InitializeStateCreate(ISDKDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.dispatchers = dispatchers;
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("create_web_view");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: doWork-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m674doWorkgIAlus(Params params, Continuation<? super Result<? extends Configuration>> continuation) {
        InitializeStateCreate$doWork$1 initializeStateCreate$doWork$1;
        int i;
        if (continuation instanceof InitializeStateCreate$doWork$1) {
            initializeStateCreate$doWork$1 = (InitializeStateCreate$doWork$1) continuation;
            if ((initializeStateCreate$doWork$1.label & Integer.MIN_VALUE) != 0) {
                initializeStateCreate$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = initializeStateCreate$doWork$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeStateCreate$doWork$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = this.dispatchers.getDefault();
                    InitializeStateCreate$doWork$2 initializeStateCreate$doWork$2 = new InitializeStateCreate$doWork$2(params, null);
                    initializeStateCreate$doWork$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, initializeStateCreate$doWork$2, initializeStateCreate$doWork$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        initializeStateCreate$doWork$1 = new InitializeStateCreate$doWork$1(this, continuation);
        Object obj2 = initializeStateCreate$doWork$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeStateCreate$doWork$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* compiled from: InitializeStateCreate.kt */
    @Metadata(m443d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateCreate$Params;", "Lcom/unity3d/services/core/domain/task/BaseParams;", "config", "Lcom/unity3d/services/core/configuration/Configuration;", "webViewData", "", "(Lcom/unity3d/services/core/configuration/Configuration;Ljava/lang/String;)V", "getConfig", "()Lcom/unity3d/services/core/configuration/Configuration;", "getWebViewData", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final /* data */ class Params implements BaseParams {
        private final Configuration config;
        private final String webViewData;

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                configuration = params.config;
            }
            if ((i & 2) != 0) {
                str = params.webViewData;
            }
            return params.copy(configuration, str);
        }

        /* renamed from: component1, reason: from getter */
        public final Configuration getConfig() {
            return this.config;
        }

        /* renamed from: component2, reason: from getter */
        public final String getWebViewData() {
            return this.webViewData;
        }

        public final Params copy(Configuration config, String webViewData) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(webViewData, "webViewData");
            return new Params(config, webViewData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Params)) {
                return false;
            }
            Params params = (Params) other;
            return Intrinsics.areEqual(this.config, params.config) && Intrinsics.areEqual(this.webViewData, params.webViewData);
        }

        public int hashCode() {
            return (this.config.hashCode() * 31) + this.webViewData.hashCode();
        }

        public String toString() {
            return "Params(config=" + this.config + ", webViewData=" + this.webViewData + ')';
        }

        public Params(Configuration config, String webViewData) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(webViewData, "webViewData");
            this.config = config;
            this.webViewData = webViewData;
        }

        public final Configuration getConfig() {
            return this.config;
        }

        public final String getWebViewData() {
            return this.webViewData;
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateError$doWork$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateError;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeStateError.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateError", m464f = "InitializeStateError.kt", m465i = {}, m466l = {27}, m467m = "doWork-gIAlu-s", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateError$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateError this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateError$doWork$1(InitializeStateError initializeStateError, Continuation<? super InitializeStateError$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateError;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m675doWorkgIAlus = this.this$0.m675doWorkgIAlus((InitializeStateError.Params) null, (Continuation<? super Result<Unit>>) this);
        return m675doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m675doWorkgIAlus : Result.m744boximpl(m675doWorkgIAlus);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateError$doWork$2.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.IModuleConfiguration;
import com.unity3d.services.core.domain.task.InitializeStateError;
import com.unity3d.services.core.log.DeviceLog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateError.kt */
@Metadata(m443d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateError$doWork$2", m464f = "InitializeStateError.kt", m465i = {}, m466l = {}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateError$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ InitializeStateError.Params $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateError$doWork$2(InitializeStateError.Params params, Continuation<? super InitializeStateError$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateError$doWork$2(this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((InitializeStateError$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m745constructorimpl;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        InitializeStateError.Params params = this.$params;
        try {
            Result.Companion companion = Result.INSTANCE;
            DeviceLog.error("Unity Ads init: halting init in " + params.getErrorState().getMetricName() + ": " + params.getException().getMessage());
            Class[] moduleConfigurationList = params.getConfig().getModuleConfigurationList();
            if (moduleConfigurationList == null) {
                moduleConfigurationList = new Class[0];
            }
            for (Class cls : moduleConfigurationList) {
                IModuleConfiguration moduleConfiguration = params.getConfig().getModuleConfiguration(cls);
                if (moduleConfiguration != null) {
                    Boxing.boxBoolean(moduleConfiguration.initErrorState(params.getConfig(), params.getErrorState(), params.getException().getMessage()));
                }
            }
            m745constructorimpl = Result.m745constructorimpl(Unit.INSTANCE);
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m752isSuccessimpl(m745constructorimpl)) {
            Result.Companion companion3 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(m745constructorimpl);
        } else {
            Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(m745constructorimpl);
            if (m748exceptionOrNullimpl != null) {
                Result.Companion companion4 = Result.INSTANCE;
                m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(m748exceptionOrNullimpl));
            }
        }
        return Result.m744boximpl(m745constructorimpl);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateError.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.ISDKDispatchers;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: InitializeStateError.kt */
@Metadata(m443d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\u0002H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateError;", "Lcom/unity3d/services/core/domain/task/MetricTask;", "Lcom/unity3d/services/core/domain/task/InitializeStateError$Params;", "", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;)V", "doWork", "Lkotlin/Result;", "params", "doWork-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/InitializeStateError$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetricName", "", "Params", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class InitializeStateError extends MetricTask<Params, Unit> {
    private final ISDKDispatchers dispatchers;

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: doWork-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo663doWorkgIAlus(BaseParams baseParams, Continuation continuation) {
        return m675doWorkgIAlus((Params) baseParams, (Continuation<? super Result<Unit>>) continuation);
    }

    public InitializeStateError(ISDKDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.dispatchers = dispatchers;
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("error");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: doWork-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m675doWorkgIAlus(Params params, Continuation<? super Result<Unit>> continuation) {
        InitializeStateError$doWork$1 initializeStateError$doWork$1;
        int i;
        if (continuation instanceof InitializeStateError$doWork$1) {
            initializeStateError$doWork$1 = (InitializeStateError$doWork$1) continuation;
            if ((initializeStateError$doWork$1.label & Integer.MIN_VALUE) != 0) {
                initializeStateError$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = initializeStateError$doWork$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeStateError$doWork$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = this.dispatchers.getDefault();
                    InitializeStateError$doWork$2 initializeStateError$doWork$2 = new InitializeStateError$doWork$2(params, null);
                    initializeStateError$doWork$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, initializeStateError$doWork$2, initializeStateError$doWork$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        initializeStateError$doWork$1 = new InitializeStateError$doWork$1(this, continuation);
        Object obj2 = initializeStateError$doWork$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeStateError$doWork$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* compiled from: InitializeStateError.kt */
    @Metadata(m443d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\r\u0010\u0011\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateError$Params;", "Lcom/unity3d/services/core/domain/task/BaseParams;", "errorState", "Lcom/unity3d/services/core/configuration/ErrorState;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "config", "Lcom/unity3d/services/core/configuration/Configuration;", "(Lcom/unity3d/services/core/configuration/ErrorState;Ljava/lang/Exception;Lcom/unity3d/services/core/configuration/Configuration;)V", "getConfig", "()Lcom/unity3d/services/core/configuration/Configuration;", "getErrorState", "()Lcom/unity3d/services/core/configuration/ErrorState;", "getException", "()Ljava/lang/Exception;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final /* data */ class Params implements BaseParams {
        private final Configuration config;
        private final ErrorState errorState;
        private final Exception exception;

        public static /* synthetic */ Params copy$default(Params params, ErrorState errorState, Exception exc, Configuration configuration, int i, Object obj) {
            if ((i & 1) != 0) {
                errorState = params.errorState;
            }
            if ((i & 2) != 0) {
                exc = params.exception;
            }
            if ((i & 4) != 0) {
                configuration = params.config;
            }
            return params.copy(errorState, exc, configuration);
        }

        /* renamed from: component1, reason: from getter */
        public final ErrorState getErrorState() {
            return this.errorState;
        }

        /* renamed from: component2, reason: from getter */
        public final Exception getException() {
            return this.exception;
        }

        /* renamed from: component3, reason: from getter */
        public final Configuration getConfig() {
            return this.config;
        }

        public final Params copy(ErrorState errorState, Exception exception, Configuration config) {
            Intrinsics.checkNotNullParameter(errorState, "errorState");
            Intrinsics.checkNotNullParameter(exception, "exception");
            Intrinsics.checkNotNullParameter(config, "config");
            return new Params(errorState, exception, config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Params)) {
                return false;
            }
            Params params = (Params) other;
            return this.errorState == params.errorState && Intrinsics.areEqual(this.exception, params.exception) && Intrinsics.areEqual(this.config, params.config);
        }

        public int hashCode() {
            return (((this.errorState.hashCode() * 31) + this.exception.hashCode()) * 31) + this.config.hashCode();
        }

        public String toString() {
            return "Params(errorState=" + this.errorState + ", exception=" + this.exception + ", config=" + this.config + ')';
        }

        public Params(ErrorState errorState, Exception exception, Configuration config) {
            Intrinsics.checkNotNullParameter(errorState, "errorState");
            Intrinsics.checkNotNullParameter(exception, "exception");
            Intrinsics.checkNotNullParameter(config, "config");
            this.errorState = errorState;
            this.exception = exception;
            this.config = config;
        }

        public final Configuration getConfig() {
            return this.config;
        }

        public final ErrorState getErrorState() {
            return this.errorState;
        }

        public final Exception getException() {
            return this.exception;
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateLoadCache$doWork$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeStateLoadCache.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateLoadCache", m464f = "InitializeStateLoadCache.kt", m465i = {}, m466l = {32}, m467m = "doWork-gIAlu-s", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateLoadCache$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateLoadCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadCache$doWork$1(InitializeStateLoadCache initializeStateLoadCache, Continuation<? super InitializeStateLoadCache$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateLoadCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m676doWorkgIAlus = this.this$0.m676doWorkgIAlus((InitializeStateLoadCache.Params) null, (Continuation<? super Result<InitializeStateLoadCache.LoadCacheResult>>) this);
        return m676doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m676doWorkgIAlus : Result.m744boximpl(m676doWorkgIAlus);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateLoadCache$doWork$2.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateLoadCache.kt */
@Metadata(m443d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadCache$LoadCacheResult;", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$2", m464f = "InitializeStateLoadCache.kt", m465i = {}, m466l = {}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateLoadCache$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends InitializeStateLoadCache.LoadCacheResult>>, Object> {
    final /* synthetic */ InitializeStateLoadCache.Params $params;
    int label;
    final /* synthetic */ InitializeStateLoadCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadCache$doWork$2(InitializeStateLoadCache initializeStateLoadCache, InitializeStateLoadCache.Params params, Continuation<? super InitializeStateLoadCache$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateLoadCache;
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateLoadCache$doWork$2(this.this$0, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends InitializeStateLoadCache.LoadCacheResult>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<InitializeStateLoadCache.LoadCacheResult>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<InitializeStateLoadCache.LoadCacheResult>> continuation) {
        return ((InitializeStateLoadCache$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004f A[Catch: all -> 0x0063, CancellationException -> 0x0090, TryCatch #2 {CancellationException -> 0x0090, all -> 0x0063, blocks: (B:5:0x000e, B:7:0x001c, B:8:0x005e, B:19:0x0024, B:21:0x003b, B:26:0x004f, B:27:0x0054, B:30:0x005a), top: B:4:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m745constructorimpl;
        byte[] webViewData;
        boolean z;
        InitializeStateLoadCache.LoadCacheResult loadCacheResult;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        InitializeStateLoadCache initializeStateLoadCache = this.this$0;
        InitializeStateLoadCache.Params params = this.$params;
        try {
            Result.Companion companion = Result.INSTANCE;
            DeviceLog.debug("Unity Ads init: check if webapp can be loaded from local cache");
            webViewData = initializeStateLoadCache.getWebViewData();
            boolean z2 = true;
            if (webViewData == null) {
                loadCacheResult = new InitializeStateLoadCache.LoadCacheResult(true, null, 2, null);
            } else {
                String Sha256 = Utilities.Sha256(webViewData);
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
                String str = new String(webViewData, forName);
                if (Sha256 != null && Intrinsics.areEqual(Sha256, params.getConfig().getWebViewHash())) {
                    z = false;
                    if (!z) {
                        DeviceLog.info("Unity Ads init: webapp loaded from local cache");
                    }
                    if (z) {
                        z2 = false;
                    }
                    loadCacheResult = new InitializeStateLoadCache.LoadCacheResult(z2, str);
                }
                z = true;
                if (!z) {
                }
                if (z) {
                }
                loadCacheResult = new InitializeStateLoadCache.LoadCacheResult(z2, str);
            }
            m745constructorimpl = Result.m745constructorimpl(loadCacheResult);
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m752isSuccessimpl(m745constructorimpl)) {
            Result.Companion companion3 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(m745constructorimpl);
        } else {
            Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(m745constructorimpl);
            if (m748exceptionOrNullimpl != null) {
                Result.Companion companion4 = Result.INSTANCE;
                m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(m748exceptionOrNullimpl));
            }
        }
        return Result.m744boximpl(m745constructorimpl);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateLoadCache.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.SdkProperties;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: InitializeStateLoadCache.kt */
@Metadata(m443d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0010\u0011B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\u0002H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateLoadCache;", "Lcom/unity3d/services/core/domain/task/MetricTask;", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadCache$Params;", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadCache$LoadCacheResult;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;)V", "doWork", "Lkotlin/Result;", "params", "doWork-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/InitializeStateLoadCache$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetricName", "", "getWebViewData", "", "LoadCacheResult", "Params", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class InitializeStateLoadCache extends MetricTask<Params, LoadCacheResult> {
    private final ISDKDispatchers dispatchers;

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: doWork-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo663doWorkgIAlus(BaseParams baseParams, Continuation continuation) {
        return m676doWorkgIAlus((Params) baseParams, (Continuation<? super Result<LoadCacheResult>>) continuation);
    }

    public InitializeStateLoadCache(ISDKDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.dispatchers = dispatchers;
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("read_local_webview");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: doWork-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m676doWorkgIAlus(Params params, Continuation<? super Result<LoadCacheResult>> continuation) {
        InitializeStateLoadCache$doWork$1 initializeStateLoadCache$doWork$1;
        int i;
        if (continuation instanceof InitializeStateLoadCache$doWork$1) {
            initializeStateLoadCache$doWork$1 = (InitializeStateLoadCache$doWork$1) continuation;
            if ((initializeStateLoadCache$doWork$1.label & Integer.MIN_VALUE) != 0) {
                initializeStateLoadCache$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = initializeStateLoadCache$doWork$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeStateLoadCache$doWork$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = this.dispatchers.getDefault();
                    InitializeStateLoadCache$doWork$2 initializeStateLoadCache$doWork$2 = new InitializeStateLoadCache$doWork$2(this, params, null);
                    initializeStateLoadCache$doWork$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, initializeStateLoadCache$doWork$2, initializeStateLoadCache$doWork$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        initializeStateLoadCache$doWork$1 = new InitializeStateLoadCache$doWork$1(this, continuation);
        Object obj2 = initializeStateLoadCache$doWork$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeStateLoadCache$doWork$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* compiled from: InitializeStateLoadCache.kt */
    @Metadata(m443d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateLoadCache$Params;", "Lcom/unity3d/services/core/domain/task/BaseParams;", "config", "Lcom/unity3d/services/core/configuration/Configuration;", "(Lcom/unity3d/services/core/configuration/Configuration;)V", "getConfig", "()Lcom/unity3d/services/core/configuration/Configuration;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final /* data */ class Params implements BaseParams {
        private final Configuration config;

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, int i, Object obj) {
            if ((i & 1) != 0) {
                configuration = params.config;
            }
            return params.copy(configuration);
        }

        /* renamed from: component1, reason: from getter */
        public final Configuration getConfig() {
            return this.config;
        }

        public final Params copy(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new Params(config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.config, ((Params) other).config);
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Params(config=" + this.config + ')';
        }

        public Params(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
        }

        public final Configuration getConfig() {
            return this.config;
        }
    }

    /* compiled from: InitializeStateLoadCache.kt */
    @Metadata(m443d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateLoadCache$LoadCacheResult;", "", "hasHashMismatch", "", "webViewData", "", "(ZLjava/lang/String;)V", "getHasHashMismatch", "()Z", "getWebViewData", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final /* data */ class LoadCacheResult {
        private final boolean hasHashMismatch;
        private final String webViewData;

        public static /* synthetic */ LoadCacheResult copy$default(LoadCacheResult loadCacheResult, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = loadCacheResult.hasHashMismatch;
            }
            if ((i & 2) != 0) {
                str = loadCacheResult.webViewData;
            }
            return loadCacheResult.copy(z, str);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getHasHashMismatch() {
            return this.hasHashMismatch;
        }

        /* renamed from: component2, reason: from getter */
        public final String getWebViewData() {
            return this.webViewData;
        }

        public final LoadCacheResult copy(boolean hasHashMismatch, String webViewData) {
            return new LoadCacheResult(hasHashMismatch, webViewData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadCacheResult)) {
                return false;
            }
            LoadCacheResult loadCacheResult = (LoadCacheResult) other;
            return this.hasHashMismatch == loadCacheResult.hasHashMismatch && Intrinsics.areEqual(this.webViewData, loadCacheResult.webViewData);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z = this.hasHashMismatch;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            String str = this.webViewData;
            return i + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "LoadCacheResult(hasHashMismatch=" + this.hasHashMismatch + ", webViewData=" + this.webViewData + ')';
        }

        public LoadCacheResult(boolean z, String str) {
            this.hasHashMismatch = z;
            this.webViewData = str;
        }

        public /* synthetic */ LoadCacheResult(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : str);
        }

        public final boolean getHasHashMismatch() {
            return this.hasHashMismatch;
        }

        public final String getWebViewData() {
            return this.webViewData;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] getWebViewData() {
        try {
            return Utilities.readFileBytes(new File(SdkProperties.getLocalWebViewFile()));
        } catch (Exception e) {
            DeviceLog.debug("Unity Ads init: webapp not found in local cache: " + e.getMessage());
            return null;
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateLoadWeb$doWork$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeStateLoadWeb.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb", m464f = "InitializeStateLoadWeb.kt", m465i = {}, m466l = {39}, m467m = "doWork-gIAlu-s", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateLoadWeb$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$1(InitializeStateLoadWeb initializeStateLoadWeb, Continuation<? super InitializeStateLoadWeb$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateLoadWeb;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m677doWorkgIAlus = this.this$0.m677doWorkgIAlus((InitializeStateLoadWeb.Params) null, (Continuation<? super Result<InitializeStateLoadWeb.LoadWebResult>>) this);
        return m677doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m677doWorkgIAlus : Result.m744boximpl(m677doWorkgIAlus);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateLoadWeb$doWork$2$1$webViewData$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateLoadWeb.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$1$webViewData$1", m464f = "InitializeStateLoadWeb.kt", m465i = {}, m466l = {71}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateLoadWeb$doWork$2$1$webViewData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ HttpRequest $request;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$2$1$webViewData$1(InitializeStateLoadWeb initializeStateLoadWeb, HttpRequest httpRequest, Continuation<? super InitializeStateLoadWeb$doWork$2$1$webViewData$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateLoadWeb;
        this.$request = httpRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateLoadWeb$doWork$2$1$webViewData$1(this.this$0, this.$request, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((InitializeStateLoadWeb$doWork$2$1$webViewData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpClient httpClient;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            httpClient = this.this$0.httpClient;
            this.label = 1;
            obj = httpClient.execute(this.$request, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return ((HttpResponse) obj).getBody().toString();
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateLoadWeb.kt */
@Metadata(m443d1 = {"\u0000\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, m444d2 = {"", "it", "Lcom/unity3d/services/core/network/model/HttpResponse;", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1", m464f = "InitializeStateLoadWeb.kt", m465i = {}, m466l = {57}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1 extends SuspendLambda implements Function2<Integer, Continuation<? super HttpResponse>, Object> {
    final /* synthetic */ HttpRequest $request;
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1(InitializeStateLoadWeb initializeStateLoadWeb, HttpRequest httpRequest, Continuation<? super InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateLoadWeb;
        this.$request = httpRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1 initializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1 = new InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1(this.this$0, this.$request, continuation);
        initializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1.I$0 = ((Number) obj).intValue();
        return initializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1;
    }

    public final Object invoke(int i, Continuation<? super HttpResponse> continuation) {
        return ((InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super HttpResponse> continuation) {
        return invoke(num.intValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISDKDispatchers iSDKDispatchers;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.I$0 > 0) {
                InitializeEventsMetricSender.getInstance().onRetryWebview();
            }
            iSDKDispatchers = this.this$0.dispatchers;
            this.label = 1;
            obj = BuildersKt.withContext(iSDKDispatchers.getIo(), new C12451(this.this$0, this.$request, null), this);
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

    /* compiled from: InitializeStateLoadWeb.kt */
    @Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/unity3d/services/core/network/model/HttpResponse;", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
    @DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1", m464f = "InitializeStateLoadWeb.kt", m465i = {}, m466l = {57}, m467m = "invokeSuspend", m468n = {}, m469s = {})
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1$1 */
    static final class C12451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponse>, Object> {
        final /* synthetic */ HttpRequest $request;
        int label;
        final /* synthetic */ InitializeStateLoadWeb this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12451(InitializeStateLoadWeb initializeStateLoadWeb, HttpRequest httpRequest, Continuation<? super C12451> continuation) {
            super(2, continuation);
            this.this$0 = initializeStateLoadWeb;
            this.$request = httpRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C12451(this.this$0, this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpResponse> continuation) {
            return ((C12451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            HttpClient httpClient;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                httpClient = this.this$0.httpClient;
                this.label = 1;
                obj = httpClient.execute(this.$request, this);
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
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateLoadWeb$doWork$2.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.extensions.TaskExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateLoadWeb.kt */
@Metadata(m443d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb$LoadWebResult;", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2", m464f = "InitializeStateLoadWeb.kt", m465i = {0, 0, 1}, m466l = {46, 64, 71}, m467m = "invokeSuspend", m468n = {"$this$withContext", "request", "request"}, m469s = {"L$0", "L$3", "L$2"})
/* loaded from: classes.dex */
final class InitializeStateLoadWeb$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends InitializeStateLoadWeb.LoadWebResult>>, Object> {
    final /* synthetic */ InitializeStateLoadWeb.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$2(InitializeStateLoadWeb.Params params, InitializeStateLoadWeb initializeStateLoadWeb, Continuation<? super InitializeStateLoadWeb$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateLoadWeb;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateLoadWeb$doWork$2 initializeStateLoadWeb$doWork$2 = new InitializeStateLoadWeb$doWork$2(this.$params, this.this$0, continuation);
        initializeStateLoadWeb$doWork$2.L$0 = obj;
        return initializeStateLoadWeb$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends InitializeStateLoadWeb.LoadWebResult>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<InitializeStateLoadWeb.LoadWebResult>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<InitializeStateLoadWeb.LoadWebResult>> continuation) {
        return ((InitializeStateLoadWeb$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x01de, code lost:
    
        com.unity3d.services.core.misc.Utilities.writeFile(new java.io.File(com.unity3d.services.core.properties.SdkProperties.getLocalWebViewFile()), r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x01be A[Catch: all -> 0x01f8, CancellationException -> 0x0225, TryCatch #6 {CancellationException -> 0x0225, all -> 0x01f8, blocks: (B:8:0x001a, B:10:0x0191, B:11:0x01b4, B:13:0x01be, B:16:0x01c9, B:17:0x01db, B:20:0x01de, B:21:0x01ea, B:35:0x0168, B:37:0x016e, B:40:0x0194, B:41:0x01a6, B:74:0x015e, B:48:0x012c, B:53:0x01a7, B:56:0x0122, B:58:0x0071, B:33:0x0039, B:34:0x0155, B:50:0x0132), top: B:2:0x000e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x016e A[Catch: all -> 0x01f8, CancellationException -> 0x0225, TryCatch #6 {CancellationException -> 0x0225, all -> 0x01f8, blocks: (B:8:0x001a, B:10:0x0191, B:11:0x01b4, B:13:0x01be, B:16:0x01c9, B:17:0x01db, B:20:0x01de, B:21:0x01ea, B:35:0x0168, B:37:0x016e, B:40:0x0194, B:41:0x01a6, B:74:0x015e, B:48:0x012c, B:53:0x01a7, B:56:0x0122, B:58:0x0071, B:33:0x0039, B:34:0x0155, B:50:0x0132), top: B:2:0x000e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0194 A[Catch: all -> 0x01f8, CancellationException -> 0x0225, TryCatch #6 {CancellationException -> 0x0225, all -> 0x01f8, blocks: (B:8:0x001a, B:10:0x0191, B:11:0x01b4, B:13:0x01be, B:16:0x01c9, B:17:0x01db, B:20:0x01de, B:21:0x01ea, B:35:0x0168, B:37:0x016e, B:40:0x0194, B:41:0x01a6, B:74:0x015e, B:48:0x012c, B:53:0x01a7, B:56:0x0122, B:58:0x0071, B:33:0x0039, B:34:0x0155, B:50:0x0132), top: B:2:0x000e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0132 A[Catch: all -> 0x0046, TRY_ENTER, TryCatch #1 {all -> 0x0046, blocks: (B:33:0x0039, B:34:0x0155, B:50:0x0132), top: B:2:0x000e, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a7 A[Catch: all -> 0x01f8, CancellationException -> 0x0225, TryCatch #6 {CancellationException -> 0x0225, all -> 0x01f8, blocks: (B:8:0x001a, B:10:0x0191, B:11:0x01b4, B:13:0x01be, B:16:0x01c9, B:17:0x01db, B:20:0x01de, B:21:0x01ea, B:35:0x0168, B:37:0x016e, B:40:0x0194, B:41:0x01a6, B:74:0x015e, B:48:0x012c, B:53:0x01a7, B:56:0x0122, B:58:0x0071, B:33:0x0039, B:34:0x0155, B:50:0x0132), top: B:2:0x000e, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v28, types: [com.unity3d.services.core.network.model.HttpRequest] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.unity3d.services.core.network.model.HttpRequest] */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m745constructorimpl;
        Object m745constructorimpl2;
        InitializeStateLoadWeb initializeStateLoadWeb;
        ?? r1;
        ISDKDispatchers iSDKDispatchers;
        Object withContext;
        InitializeStateLoadWeb.Params params;
        String str;
        String webViewHash;
        HttpRequest httpRequest;
        HttpRequest httpRequest2;
        InitializeStateLoadWeb initializeStateLoadWeb2;
        Object withRetry;
        Object m745constructorimpl3;
        InitializeStateLoadWeb initializeStateLoadWeb3;
        ?? r12;
        InitializeStateNetworkError initializeStateNetworkError;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        ?? r2 = 1;
        try {
            try {
            } catch (Throwable th) {
                Result.Companion companion = Result.INSTANCE;
                m745constructorimpl2 = Result.m745constructorimpl(ResultKt.createFailure(th));
                r1 = i;
                initializeStateLoadWeb = r2;
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th2));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            InitializeStateLoadWeb.Params params2 = this.$params;
            InitializeStateLoadWeb initializeStateLoadWeb4 = this.this$0;
            Result.Companion companion3 = Result.INSTANCE;
            DeviceLog.info("Unity Ads init: loading webapp from " + params2.getConfig().getWebViewUrl());
            String webViewUrl = params2.getConfig().getWebViewUrl();
            Intrinsics.checkNotNullExpressionValue(webViewUrl, "params.config.webViewUrl");
            HttpRequest httpRequest3 = new HttpRequest(webViewUrl, null, RequestType.GET, null, null, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131066, null);
            try {
                Result.Companion companion4 = Result.INSTANCE;
                int maxRetries = params2.getConfig().getMaxRetries();
                double retryScalingFactor = params2.getConfig().getRetryScalingFactor();
                long retryDelay = params2.getConfig().getRetryDelay();
                InitializationException initializationException = new InitializationException(ErrorState.NetworkWebviewRequest, new Exception(), params2.getConfig());
                InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1 initializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1 = new InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1(initializeStateLoadWeb4, httpRequest3, null);
                this.L$0 = coroutineScope;
                this.L$1 = params2;
                this.L$2 = initializeStateLoadWeb4;
                this.L$3 = httpRequest3;
                this.label = 1;
                httpRequest = httpRequest3;
                try {
                    withRetry = TaskExtensionsKt.withRetry(retryDelay, maxRetries, retryScalingFactor, initializationException, initializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1, this);
                    if (withRetry == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    httpRequest2 = httpRequest;
                    params = params2;
                    initializeStateLoadWeb2 = initializeStateLoadWeb4;
                } catch (Throwable th3) {
                    th = th3;
                    httpRequest2 = httpRequest;
                    params = params2;
                    initializeStateLoadWeb2 = initializeStateLoadWeb4;
                    Result.Companion companion5 = Result.INSTANCE;
                    m745constructorimpl3 = Result.m745constructorimpl(ResultKt.createFailure(th));
                    r12 = httpRequest2;
                    initializeStateLoadWeb3 = initializeStateLoadWeb2;
                    if (Result.m751isFailureimpl(m745constructorimpl3)) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                httpRequest = httpRequest3;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    InitializeStateLoadWeb.Params params3 = (InitializeStateLoadWeb.Params) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    params = params3;
                    withContext = obj;
                    str = (String) withContext;
                    webViewHash = params.getConfig().getWebViewHash();
                    if (webViewHash != null && !Intrinsics.areEqual(Utilities.Sha256(str), webViewHash)) {
                        throw new InitializationException(ErrorState.InvalidHash, new Exception("Invalid webViewHash"), params.getConfig());
                    }
                    m745constructorimpl = Result.m745constructorimpl(new InitializeStateLoadWeb.LoadWebResult(params.getConfig(), str));
                    if (Result.m752isSuccessimpl(m745constructorimpl)) {
                        Result.Companion companion6 = Result.INSTANCE;
                        m745constructorimpl = Result.m745constructorimpl(m745constructorimpl);
                    } else {
                        Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(m745constructorimpl);
                        if (m748exceptionOrNullimpl != null) {
                            Result.Companion companion7 = Result.INSTANCE;
                            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(m748exceptionOrNullimpl));
                        }
                    }
                    return Result.m744boximpl(m745constructorimpl);
                }
                ?? r13 = (HttpRequest) this.L$2;
                InitializeStateLoadWeb initializeStateLoadWeb5 = (InitializeStateLoadWeb) this.L$1;
                params = (InitializeStateLoadWeb.Params) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = ((Result) obj).getValue();
                i = r13;
                r2 = initializeStateLoadWeb5;
                m745constructorimpl2 = Result.m745constructorimpl(Result.m744boximpl(obj2));
                r1 = i;
                initializeStateLoadWeb = r2;
                if (!Result.m752isSuccessimpl(m745constructorimpl2)) {
                    iSDKDispatchers = initializeStateLoadWeb.dispatchers;
                    CoroutineDispatcher io = iSDKDispatchers.getIo();
                    InitializeStateLoadWeb$doWork$2$1$webViewData$1 initializeStateLoadWeb$doWork$2$1$webViewData$1 = new InitializeStateLoadWeb$doWork$2$1$webViewData$1(initializeStateLoadWeb, r1, null);
                    this.L$0 = params;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 3;
                    withContext = BuildersKt.withContext(io, initializeStateLoadWeb$doWork$2$1$webViewData$1, this);
                    if (withContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = (String) withContext;
                    webViewHash = params.getConfig().getWebViewHash();
                    if (webViewHash != null) {
                        throw new InitializationException(ErrorState.InvalidHash, new Exception("Invalid webViewHash"), params.getConfig());
                    }
                    m745constructorimpl = Result.m745constructorimpl(new InitializeStateLoadWeb.LoadWebResult(params.getConfig(), str));
                    if (Result.m752isSuccessimpl(m745constructorimpl)) {
                    }
                    return Result.m744boximpl(m745constructorimpl);
                }
                throw new InitializationException(ErrorState.NetworkWebviewRequest, new Exception("No connected events within the timeout!"), params.getConfig());
            }
            httpRequest2 = (HttpRequest) this.L$3;
            initializeStateLoadWeb2 = (InitializeStateLoadWeb) this.L$2;
            params = (InitializeStateLoadWeb.Params) this.L$1;
            try {
                ResultKt.throwOnFailure(obj);
                withRetry = obj;
                httpRequest2 = httpRequest2;
                initializeStateLoadWeb2 = initializeStateLoadWeb2;
            } catch (Throwable th5) {
                th = th5;
                Result.Companion companion52 = Result.INSTANCE;
                m745constructorimpl3 = Result.m745constructorimpl(ResultKt.createFailure(th));
                r12 = httpRequest2;
                initializeStateLoadWeb3 = initializeStateLoadWeb2;
                if (Result.m751isFailureimpl(m745constructorimpl3)) {
                }
            }
        }
        m745constructorimpl3 = Result.m745constructorimpl((HttpResponse) withRetry);
        r12 = httpRequest2;
        initializeStateLoadWeb3 = initializeStateLoadWeb2;
        if (Result.m751isFailureimpl(m745constructorimpl3)) {
            Result.Companion companion8 = Result.INSTANCE;
            initializeStateNetworkError = initializeStateLoadWeb3.initializeStateNetworkError;
            InitializeStateNetworkError.Params params4 = new InitializeStateNetworkError.Params(params.getConfig());
            this.L$0 = params;
            this.L$1 = initializeStateLoadWeb3;
            this.L$2 = r12;
            this.L$3 = null;
            this.label = 2;
            obj2 = initializeStateNetworkError.mo664invokegIAlus(params4, this);
            i = r12;
            r2 = initializeStateLoadWeb3;
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            m745constructorimpl2 = Result.m745constructorimpl(Result.m744boximpl(obj2));
            r1 = i;
            initializeStateLoadWeb = r2;
            if (!Result.m752isSuccessimpl(m745constructorimpl2)) {
            }
        } else {
            ResultKt.throwOnFailure(m745constructorimpl3);
            str = ((HttpResponse) m745constructorimpl3).getBody().toString();
            webViewHash = params.getConfig().getWebViewHash();
            if (webViewHash != null) {
            }
            m745constructorimpl = Result.m745constructorimpl(new InitializeStateLoadWeb.LoadWebResult(params.getConfig(), str));
            if (Result.m752isSuccessimpl(m745constructorimpl)) {
            }
            return Result.m744boximpl(m745constructorimpl);
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateLoadWeb.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.core.HttpClient;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: InitializeStateLoadWeb.kt */
@Metadata(m443d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb;", "Lcom/unity3d/services/core/domain/task/MetricTask;", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb$Params;", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb$LoadWebResult;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "initializeStateNetworkError", "Lcom/unity3d/services/core/domain/task/InitializeStateNetworkError;", "httpClient", "Lcom/unity3d/services/core/network/core/HttpClient;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;Lcom/unity3d/services/core/domain/task/InitializeStateNetworkError;Lcom/unity3d/services/core/network/core/HttpClient;)V", "doWork", "Lkotlin/Result;", "params", "doWork-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetricName", "", "LoadWebResult", "Params", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class InitializeStateLoadWeb extends MetricTask<Params, LoadWebResult> {
    private final ISDKDispatchers dispatchers;
    private final HttpClient httpClient;
    private final InitializeStateNetworkError initializeStateNetworkError;

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: doWork-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo663doWorkgIAlus(BaseParams baseParams, Continuation continuation) {
        return m677doWorkgIAlus((Params) baseParams, (Continuation<? super Result<LoadWebResult>>) continuation);
    }

    public InitializeStateLoadWeb(ISDKDispatchers dispatchers, InitializeStateNetworkError initializeStateNetworkError, HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(initializeStateNetworkError, "initializeStateNetworkError");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.dispatchers = dispatchers;
        this.initializeStateNetworkError = initializeStateNetworkError;
        this.httpClient = httpClient;
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("download_web_view");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: doWork-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m677doWorkgIAlus(Params params, Continuation<? super Result<LoadWebResult>> continuation) {
        InitializeStateLoadWeb$doWork$1 initializeStateLoadWeb$doWork$1;
        int i;
        if (continuation instanceof InitializeStateLoadWeb$doWork$1) {
            initializeStateLoadWeb$doWork$1 = (InitializeStateLoadWeb$doWork$1) continuation;
            if ((initializeStateLoadWeb$doWork$1.label & Integer.MIN_VALUE) != 0) {
                initializeStateLoadWeb$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = initializeStateLoadWeb$doWork$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeStateLoadWeb$doWork$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = this.dispatchers.getDefault();
                    InitializeStateLoadWeb$doWork$2 initializeStateLoadWeb$doWork$2 = new InitializeStateLoadWeb$doWork$2(params, this, null);
                    initializeStateLoadWeb$doWork$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, initializeStateLoadWeb$doWork$2, initializeStateLoadWeb$doWork$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        initializeStateLoadWeb$doWork$1 = new InitializeStateLoadWeb$doWork$1(this, continuation);
        Object obj2 = initializeStateLoadWeb$doWork$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeStateLoadWeb$doWork$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* compiled from: InitializeStateLoadWeb.kt */
    @Metadata(m443d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb$Params;", "Lcom/unity3d/services/core/domain/task/BaseParams;", "config", "Lcom/unity3d/services/core/configuration/Configuration;", "(Lcom/unity3d/services/core/configuration/Configuration;)V", "getConfig", "()Lcom/unity3d/services/core/configuration/Configuration;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final /* data */ class Params implements BaseParams {
        private final Configuration config;

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, int i, Object obj) {
            if ((i & 1) != 0) {
                configuration = params.config;
            }
            return params.copy(configuration);
        }

        /* renamed from: component1, reason: from getter */
        public final Configuration getConfig() {
            return this.config;
        }

        public final Params copy(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new Params(config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.config, ((Params) other).config);
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Params(config=" + this.config + ')';
        }

        public Params(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
        }

        public final Configuration getConfig() {
            return this.config;
        }
    }

    /* compiled from: InitializeStateLoadWeb.kt */
    @Metadata(m443d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb$LoadWebResult;", "", "config", "Lcom/unity3d/services/core/configuration/Configuration;", "webViewDataString", "", "(Lcom/unity3d/services/core/configuration/Configuration;Ljava/lang/String;)V", "getConfig", "()Lcom/unity3d/services/core/configuration/Configuration;", "getWebViewDataString", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final /* data */ class LoadWebResult {
        private final Configuration config;
        private final String webViewDataString;

        public static /* synthetic */ LoadWebResult copy$default(LoadWebResult loadWebResult, Configuration configuration, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                configuration = loadWebResult.config;
            }
            if ((i & 2) != 0) {
                str = loadWebResult.webViewDataString;
            }
            return loadWebResult.copy(configuration, str);
        }

        /* renamed from: component1, reason: from getter */
        public final Configuration getConfig() {
            return this.config;
        }

        /* renamed from: component2, reason: from getter */
        public final String getWebViewDataString() {
            return this.webViewDataString;
        }

        public final LoadWebResult copy(Configuration config, String webViewDataString) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(webViewDataString, "webViewDataString");
            return new LoadWebResult(config, webViewDataString);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadWebResult)) {
                return false;
            }
            LoadWebResult loadWebResult = (LoadWebResult) other;
            return Intrinsics.areEqual(this.config, loadWebResult.config) && Intrinsics.areEqual(this.webViewDataString, loadWebResult.webViewDataString);
        }

        public int hashCode() {
            return (this.config.hashCode() * 31) + this.webViewDataString.hashCode();
        }

        public String toString() {
            return "LoadWebResult(config=" + this.config + ", webViewDataString=" + this.webViewDataString + ')';
        }

        public LoadWebResult(Configuration config, String webViewDataString) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(webViewDataString, "webViewDataString");
            this.config = config;
            this.webViewDataString = webViewDataString;
        }

        public final Configuration getConfig() {
            return this.config;
        }

        public final String getWebViewDataString() {
            return this.webViewDataString;
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateNetworkError$doWork$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeStateNetworkError.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateNetworkError", m464f = "InitializeStateNetworkError.kt", m465i = {}, m466l = {33}, m467m = "doWork-gIAlu-s", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateNetworkError$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateNetworkError this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateNetworkError$doWork$1(InitializeStateNetworkError initializeStateNetworkError, Continuation<? super InitializeStateNetworkError$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateNetworkError;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m678doWorkgIAlus = this.this$0.m678doWorkgIAlus((InitializeStateNetworkError.Params) null, (Continuation<? super Result<Unit>>) this);
        return m678doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m678doWorkgIAlus : Result.m744boximpl(m678doWorkgIAlus);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateNetworkError$doWork$2$1$success$1.java =====
package com.unity3d.services.core.domain.task;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateNetworkError.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2$1$success$1", m464f = "InitializeStateNetworkError.kt", m465i = {}, m466l = {82}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateNetworkError$doWork$2$1$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ InitializeStateNetworkError this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateNetworkError$doWork$2$1$success$1(InitializeStateNetworkError initializeStateNetworkError, Continuation<? super InitializeStateNetworkError$doWork$2$1$success$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateNetworkError;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateNetworkError$doWork$2$1$success$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeStateNetworkError$doWork$2$1$success$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InitializeStateNetworkError initializeStateNetworkError = this.this$0;
            this.L$0 = initializeStateNetworkError;
            this.label = 1;
            InitializeStateNetworkError$doWork$2$1$success$1 initializeStateNetworkError$doWork$2$1$success$1 = this;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(initializeStateNetworkError$doWork$2$1$success$1), 1);
            cancellableContinuationImpl.initCancellability();
            initializeStateNetworkError.startListening(cancellableContinuationImpl);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(initializeStateNetworkError$doWork$2$1$success$1);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateNetworkError$doWork$2.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.connectivity.ConnectivityMonitor;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.log.DeviceLog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: InitializeStateNetworkError.kt */
@Metadata(m443d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2", m464f = "InitializeStateNetworkError.kt", m465i = {}, m466l = {39}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateNetworkError$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ InitializeStateNetworkError.Params $params;
    Object L$0;
    int label;
    final /* synthetic */ InitializeStateNetworkError this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateNetworkError$doWork$2(InitializeStateNetworkError initializeStateNetworkError, InitializeStateNetworkError.Params params, Continuation<? super InitializeStateNetworkError$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateNetworkError;
        this.$params = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateNetworkError$doWork$2(this.this$0, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((InitializeStateNetworkError$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m745constructorimpl;
        InitializeStateNetworkError initializeStateNetworkError;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InitializeStateNetworkError initializeStateNetworkError2 = this.this$0;
                InitializeStateNetworkError.Params params = this.$params;
                Result.Companion companion = Result.INSTANCE;
                DeviceLog.error("Unity Ads init: network error, waiting for connection events");
                initializeStateNetworkError2.maximumConnectedEvents = params.getConfig().getMaximumConnectedEvents();
                initializeStateNetworkError2.connectedEventThreshold = params.getConfig().getConnectedEventThreshold();
                long networkErrorTimeout = params.getConfig().getNetworkErrorTimeout();
                InitializeStateNetworkError$doWork$2$1$success$1 initializeStateNetworkError$doWork$2$1$success$1 = new InitializeStateNetworkError$doWork$2$1$success$1(initializeStateNetworkError2, null);
                this.L$0 = initializeStateNetworkError2;
                this.label = 1;
                Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(networkErrorTimeout, initializeStateNetworkError$doWork$2$1$success$1, this);
                if (withTimeoutOrNull == coroutine_suspended) {
                    return coroutine_suspended;
                }
                initializeStateNetworkError = initializeStateNetworkError2;
                obj = withTimeoutOrNull;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                initializeStateNetworkError = (InitializeStateNetworkError) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th));
        }
        if (((Unit) obj) == null) {
            ConnectivityMonitor.removeListener(initializeStateNetworkError);
            throw new Exception("No connected events within the timeout!");
        }
        m745constructorimpl = Result.m745constructorimpl(Unit.INSTANCE);
        if (Result.m752isSuccessimpl(m745constructorimpl)) {
            Result.Companion companion3 = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(m745constructorimpl);
        } else {
            Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(m745constructorimpl);
            if (m748exceptionOrNullimpl != null) {
                Result.Companion companion4 = Result.INSTANCE;
                m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(m748exceptionOrNullimpl));
            }
        }
        return Result.m744boximpl(m745constructorimpl);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateNetworkError.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.connectivity.ConnectivityMonitor;
import com.unity3d.services.core.connectivity.IConnectivityListener;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: InitializeStateNetworkError.kt */
@Metadata(m443d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001cB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0016\u0010\u001b\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001d"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateNetworkError;", "Lcom/unity3d/services/core/domain/task/MetricTask;", "Lcom/unity3d/services/core/domain/task/InitializeStateNetworkError$Params;", "", "Lcom/unity3d/services/core/connectivity/IConnectivityListener;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;)V", "connectedEventThreshold", "", "continuation", "Lkotlin/coroutines/Continuation;", "lastConnectedEventTimeMs", "", "maximumConnectedEvents", "receivedConnectedEvents", "doWork", "Lkotlin/Result;", "params", "doWork-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/InitializeStateNetworkError$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetricName", "", "onConnected", "onDisconnected", "shouldHandleConnectedEvent", "", "startListening", "Params", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class InitializeStateNetworkError extends MetricTask<Params, Unit> implements IConnectivityListener {
    private int connectedEventThreshold;
    private Continuation<? super Unit> continuation;
    private final ISDKDispatchers dispatchers;
    private long lastConnectedEventTimeMs;
    private int maximumConnectedEvents;
    private int receivedConnectedEvents;

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: doWork-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo663doWorkgIAlus(BaseParams baseParams, Continuation continuation) {
        return m678doWorkgIAlus((Params) baseParams, (Continuation<? super Result<Unit>>) continuation);
    }

    public InitializeStateNetworkError(ISDKDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.dispatchers = dispatchers;
        this.maximumConnectedEvents = UnityAdsConstants.RequestPolicy.RETRY_WAIT_BASE;
        this.connectedEventThreshold = 10000;
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("error_network");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: doWork-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m678doWorkgIAlus(Params params, Continuation<? super Result<Unit>> continuation) {
        InitializeStateNetworkError$doWork$1 initializeStateNetworkError$doWork$1;
        int i;
        if (continuation instanceof InitializeStateNetworkError$doWork$1) {
            initializeStateNetworkError$doWork$1 = (InitializeStateNetworkError$doWork$1) continuation;
            if ((initializeStateNetworkError$doWork$1.label & Integer.MIN_VALUE) != 0) {
                initializeStateNetworkError$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = initializeStateNetworkError$doWork$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeStateNetworkError$doWork$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = this.dispatchers.getDefault();
                    InitializeStateNetworkError$doWork$2 initializeStateNetworkError$doWork$2 = new InitializeStateNetworkError$doWork$2(this, params, null);
                    initializeStateNetworkError$doWork$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, initializeStateNetworkError$doWork$2, initializeStateNetworkError$doWork$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        initializeStateNetworkError$doWork$1 = new InitializeStateNetworkError$doWork$1(this, continuation);
        Object obj2 = initializeStateNetworkError$doWork$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeStateNetworkError$doWork$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startListening(Continuation<? super Unit> continuation) {
        this.continuation = continuation;
        ConnectivityMonitor.addListener(this);
    }

    @Override // com.unity3d.services.core.connectivity.IConnectivityListener
    public void onConnected() {
        this.receivedConnectedEvents++;
        DeviceLog.debug("Unity Ads init got connected event");
        if (shouldHandleConnectedEvent()) {
            Continuation<? super Unit> continuation = this.continuation;
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m745constructorimpl(Unit.INSTANCE));
            }
            this.continuation = null;
        }
        if (this.receivedConnectedEvents > this.maximumConnectedEvents) {
            ConnectivityMonitor.removeListener(this);
        }
        this.lastConnectedEventTimeMs = System.currentTimeMillis();
    }

    @Override // com.unity3d.services.core.connectivity.IConnectivityListener
    public void onDisconnected() {
        DeviceLog.debug("Unity Ads init got disconnected event");
    }

    private final boolean shouldHandleConnectedEvent() {
        return System.currentTimeMillis() - this.lastConnectedEventTimeMs >= ((long) this.connectedEventThreshold) && this.receivedConnectedEvents <= this.maximumConnectedEvents;
    }

    /* compiled from: InitializeStateNetworkError.kt */
    @Metadata(m443d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateNetworkError$Params;", "Lcom/unity3d/services/core/domain/task/BaseParams;", "config", "Lcom/unity3d/services/core/configuration/Configuration;", "(Lcom/unity3d/services/core/configuration/Configuration;)V", "getConfig", "()Lcom/unity3d/services/core/configuration/Configuration;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final /* data */ class Params implements BaseParams {
        private final Configuration config;

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, int i, Object obj) {
            if ((i & 1) != 0) {
                configuration = params.config;
            }
            return params.copy(configuration);
        }

        /* renamed from: component1, reason: from getter */
        public final Configuration getConfig() {
            return this.config;
        }

        public final Params copy(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new Params(config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.config, ((Params) other).config);
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Params(config=" + this.config + ')';
        }

        public Params(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
        }

        public final Configuration getConfig() {
            return this.config;
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateReset$doWork$1.java =====
package com.unity3d.services.core.domain.task;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: InitializeStateReset.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateReset", m464f = "InitializeStateReset.kt", m465i = {}, m466l = {33}, m467m = "doWork-gIAlu-s$suspendImpl", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateReset$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateReset this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateReset$doWork$1(InitializeStateReset initializeStateReset, Continuation<? super InitializeStateReset$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateReset;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m679doWorkgIAlus$suspendImpl = InitializeStateReset.m679doWorkgIAlus$suspendImpl(this.this$0, null, this);
        return m679doWorkgIAlus$suspendImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m679doWorkgIAlus$suspendImpl : Result.m744boximpl(m679doWorkgIAlus$suspendImpl);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateReset$doWork$2$1$success$1.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.webview.WebView;
import com.unity3d.services.core.webview.WebViewApp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InitializeStateReset.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$1$success$1", m464f = "InitializeStateReset.kt", m465i = {}, m466l = {42}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateReset$doWork$2$1$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WebViewApp $currentApp;
    int label;
    final /* synthetic */ InitializeStateReset this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateReset$doWork$2$1$success$1(InitializeStateReset initializeStateReset, WebViewApp webViewApp, Continuation<? super InitializeStateReset$doWork$2$1$success$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateReset;
        this.$currentApp = webViewApp;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateReset$doWork$2$1$success$1(this.this$0, this.$currentApp, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeStateReset$doWork$2$1$success$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: InitializeStateReset.kt */
    @Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
    @DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$1$success$1$1", m464f = "InitializeStateReset.kt", m465i = {}, m466l = {}, m467m = "invokeSuspend", m468n = {}, m469s = {})
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$1$success$1$1 */
    static final class C12461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WebViewApp $currentApp;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12461(WebViewApp webViewApp, Continuation<? super C12461> continuation) {
            super(2, continuation);
            this.$currentApp = webViewApp;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C12461(this.$currentApp, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C12461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            WebView webView = this.$currentApp.getWebView();
            if (webView != null) {
                webView.destroy();
            }
            this.$currentApp.setWebView(null);
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISDKDispatchers iSDKDispatchers;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            iSDKDispatchers = this.this$0.dispatchers;
            this.label = 1;
            if (BuildersKt.withContext(iSDKDispatchers.getMain(), new C12461(this.$currentApp, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateReset$doWork$2.java =====
package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IModuleConfiguration;
import com.unity3d.services.core.domain.task.InitializeStateReset;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.webview.WebViewApp;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: InitializeStateReset.kt */
@Metadata(m443d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "Lcom/unity3d/services/core/configuration/Configuration;", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2", m464f = "InitializeStateReset.kt", m465i = {}, m466l = {41}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class InitializeStateReset$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Configuration>>, Object> {
    final /* synthetic */ InitializeStateReset.Params $params;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ InitializeStateReset this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateReset$doWork$2(InitializeStateReset.Params params, InitializeStateReset initializeStateReset, Continuation<? super InitializeStateReset$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateReset;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateReset$doWork$2(this.$params, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Configuration>> continuation) {
        return ((InitializeStateReset$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007c A[Catch: all -> 0x00c8, CancellationException -> 0x00f5, TryCatch #2 {CancellationException -> 0x00f5, all -> 0x00c8, blocks: (B:6:0x0014, B:7:0x005f, B:10:0x006d, B:12:0x007c, B:14:0x0082, B:16:0x0090, B:17:0x0092, B:19:0x0095, B:21:0x00a1, B:23:0x00ac, B:26:0x00af, B:36:0x00b8, B:37:0x00bf, B:38:0x00c0, B:39:0x00c7, B:40:0x0065, B:41:0x006c, B:45:0x0027, B:47:0x0034, B:49:0x0039, B:51:0x0041), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0 A[Catch: all -> 0x00c8, CancellationException -> 0x00f5, TryCatch #2 {CancellationException -> 0x00f5, all -> 0x00c8, blocks: (B:6:0x0014, B:7:0x005f, B:10:0x006d, B:12:0x007c, B:14:0x0082, B:16:0x0090, B:17:0x0092, B:19:0x0095, B:21:0x00a1, B:23:0x00ac, B:26:0x00af, B:36:0x00b8, B:37:0x00bf, B:38:0x00c0, B:39:0x00c7, B:40:0x0065, B:41:0x006c, B:45:0x0027, B:47:0x0034, B:49:0x0039, B:51:0x0041), top: B:2:0x0008 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m745constructorimpl;
        InitializeStateReset.Params params;
        InitializeStateReset initializeStateReset;
        InitializeStateReset initializeStateReset2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            Result.Companion companion = Result.INSTANCE;
            m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(th));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            params = this.$params;
            initializeStateReset = this.this$0;
            Result.Companion companion2 = Result.INSTANCE;
            DeviceLog.debug("Unity Ads init: starting init");
            WebViewApp currentApp = WebViewApp.getCurrentApp();
            if (currentApp != null) {
                currentApp.resetWebViewAppInitialization();
            }
            if ((currentApp != null ? currentApp.getWebView() : null) != null) {
                long webViewAppCreateTimeout = params.getConfig().getWebViewAppCreateTimeout();
                InitializeStateReset$doWork$2$1$success$1 initializeStateReset$doWork$2$1$success$1 = new InitializeStateReset$doWork$2$1$success$1(initializeStateReset, currentApp, null);
                this.L$0 = params;
                this.L$1 = initializeStateReset;
                this.label = 1;
                Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(webViewAppCreateTimeout, initializeStateReset$doWork$2$1$success$1, this);
                if (withTimeoutOrNull == coroutine_suspended) {
                    return coroutine_suspended;
                }
                initializeStateReset2 = initializeStateReset;
                obj = withTimeoutOrNull;
            }
            initializeStateReset.unregisterLifecycleCallbacks();
            SdkProperties.setCacheDirectory(null);
            SdkProperties.setWebViewCacheDirectory(null);
            if (SdkProperties.getCacheDirectory() != null) {
                throw new Exception("Cache directory is NULL");
            }
            if (SdkProperties.getWebViewCacheDirectory() == null) {
                throw new Exception("WebView cache directory is NULL");
            }
            SdkProperties.setInitialized(false);
            Class[] moduleConfigurationList = params.getConfig().getModuleConfigurationList();
            if (moduleConfigurationList == null) {
                moduleConfigurationList = new Class[0];
            }
            for (Class cls : moduleConfigurationList) {
                IModuleConfiguration moduleConfiguration = params.getConfig().getModuleConfiguration(cls);
                if (moduleConfiguration != null) {
                    Boxing.boxBoolean(moduleConfiguration.resetState(params.getConfig()));
                }
            }
            m745constructorimpl = Result.m745constructorimpl(params.getConfig());
            if (Result.m752isSuccessimpl(m745constructorimpl)) {
                Result.Companion companion3 = Result.INSTANCE;
                m745constructorimpl = Result.m745constructorimpl(m745constructorimpl);
            } else {
                Throwable m748exceptionOrNullimpl = Result.m748exceptionOrNullimpl(m745constructorimpl);
                if (m748exceptionOrNullimpl != null) {
                    Result.Companion companion4 = Result.INSTANCE;
                    m745constructorimpl = Result.m745constructorimpl(ResultKt.createFailure(m748exceptionOrNullimpl));
                }
            }
            return Result.m744boximpl(m745constructorimpl);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        initializeStateReset2 = (InitializeStateReset) this.L$1;
        params = (InitializeStateReset.Params) this.L$0;
        ResultKt.throwOnFailure(obj);
        if (((Unit) obj) != null) {
            initializeStateReset = initializeStateReset2;
            initializeStateReset.unregisterLifecycleCallbacks();
            SdkProperties.setCacheDirectory(null);
            SdkProperties.setWebViewCacheDirectory(null);
            if (SdkProperties.getCacheDirectory() != null) {
            }
        } else {
            throw new Exception("Reset failed on opening ConditionVariable");
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/InitializeStateReset.java =====
package com.unity3d.services.core.domain.task;

import android.app.Application;
import com.unity3d.services.core.api.Lifecycle;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.properties.ClientProperties;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: InitializeStateReset.kt */
@Metadata(m443d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\u0002H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateReset;", "Lcom/unity3d/services/core/domain/task/MetricTask;", "Lcom/unity3d/services/core/domain/task/InitializeStateReset$Params;", "Lcom/unity3d/services/core/configuration/Configuration;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;)V", "doWork", "Lkotlin/Result;", "params", "doWork-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/InitializeStateReset$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetricName", "", "unregisterLifecycleCallbacks", "", "Params", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public class InitializeStateReset extends MetricTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;

    /* renamed from: doWork-gIAlu-s, reason: not valid java name */
    public Object m680doWorkgIAlus(Params params, Continuation<? super Result<? extends Configuration>> continuation) {
        return m679doWorkgIAlus$suspendImpl(this, params, continuation);
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: doWork-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo663doWorkgIAlus(BaseParams baseParams, Continuation continuation) {
        return m680doWorkgIAlus((Params) baseParams, (Continuation<? super Result<? extends Configuration>>) continuation);
    }

    public InitializeStateReset(ISDKDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.dispatchers = dispatchers;
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("reset");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: doWork-gIAlu-s$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object m679doWorkgIAlus$suspendImpl(InitializeStateReset initializeStateReset, Params params, Continuation<? super Result<? extends Configuration>> continuation) {
        InitializeStateReset$doWork$1 initializeStateReset$doWork$1;
        int i;
        if (continuation instanceof InitializeStateReset$doWork$1) {
            initializeStateReset$doWork$1 = (InitializeStateReset$doWork$1) continuation;
            if ((initializeStateReset$doWork$1.label & Integer.MIN_VALUE) != 0) {
                initializeStateReset$doWork$1.label -= Integer.MIN_VALUE;
                Object obj = initializeStateReset$doWork$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = initializeStateReset$doWork$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = initializeStateReset.dispatchers.getDefault();
                    InitializeStateReset$doWork$2 initializeStateReset$doWork$2 = new InitializeStateReset$doWork$2(params, initializeStateReset, null);
                    initializeStateReset$doWork$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, initializeStateReset$doWork$2, initializeStateReset$doWork$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        initializeStateReset$doWork$1 = new InitializeStateReset$doWork$1(initializeStateReset, continuation);
        Object obj2 = initializeStateReset$doWork$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = initializeStateReset$doWork$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterLifecycleCallbacks() {
        if (Lifecycle.getLifecycleListener() != null) {
            Application application = ClientProperties.getApplication();
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(Lifecycle.getLifecycleListener());
            }
            Lifecycle.setLifecycleListener(null);
        }
    }

    /* compiled from: InitializeStateReset.kt */
    @Metadata(m443d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/InitializeStateReset$Params;", "Lcom/unity3d/services/core/domain/task/BaseParams;", "config", "Lcom/unity3d/services/core/configuration/Configuration;", "(Lcom/unity3d/services/core/configuration/Configuration;)V", "getConfig", "()Lcom/unity3d/services/core/configuration/Configuration;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final /* data */ class Params implements BaseParams {
        private final Configuration config;

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, int i, Object obj) {
            if ((i & 1) != 0) {
                configuration = params.config;
            }
            return params.copy(configuration);
        }

        /* renamed from: component1, reason: from getter */
        public final Configuration getConfig() {
            return this.config;
        }

        public final Params copy(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            return new Params(config);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.config, ((Params) other).config);
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Params(config=" + this.config + ')';
        }

        public Params(Configuration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.config = config;
        }

        public final Configuration getConfig() {
            return this.config;
        }
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/MetricTask$invoke$1.java =====
package com.unity3d.services.core.domain.task;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: MetricTask.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.core.domain.task.MetricTask", m464f = "MetricTask.kt", m465i = {0, 0, 0}, m466l = {24}, m467m = "invoke-gIAlu-s$suspendImpl", m468n = {"$this", "result", "start$iv"}, m469s = {"L$0", "L$1", "J$0"})
/* loaded from: classes.dex */
final class MetricTask$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MetricTask<P, R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MetricTask$invoke$1(MetricTask<? super P, R> metricTask, Continuation<? super MetricTask$invoke$1> continuation) {
        super(continuation);
        this.this$0 = metricTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m681invokegIAlus$suspendImpl = MetricTask.m681invokegIAlus$suspendImpl(this.this$0, null, this);
        return m681invokegIAlus$suspendImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m681invokegIAlus$suspendImpl : Result.m744boximpl(m681invokegIAlus$suspendImpl);
    }
}

// ===== FILE: com/unity3d/services/core/domain/task/MetricTask.java =====
package com.unity3d.services.core.domain.task;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.domain.task.BaseParams;
import com.unity3d.services.core.domain.task.BaseTask;
import com.unity3d.services.core.p005di.IServiceProvider;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* compiled from: MetricTask.kt */
@Metadata(m443d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0 H\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020$H\u0002J*\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010\u00152\u0006\u0010&\u001a\u00028\u0000H\u0096Bø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\b\u0010)\u001a\u00020\u0013H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006*"}, m444d2 = {"Lcom/unity3d/services/core/domain/task/MetricTask;", "P", "Lcom/unity3d/services/core/domain/task/BaseParams;", "R", "Lcom/unity3d/services/core/domain/task/BaseTask;", "()V", TypedValues.TransitionType.S_DURATION, "", "getDuration", "()J", "setDuration", "(J)V", "taskStatus", "", "getTaskStatus", "()Ljava/lang/String;", "setTaskStatus", "(Ljava/lang/String;)V", "captureMetric", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "getMetric", "Lcom/unity3d/services/core/request/metrics/Metric;", "getMetricName", "getMetricNameForInitializeTask", MediationMetaData.KEY_NAME, "getMetricNameForTask", "task", "", "getMetricTagsForState", "", "getSDKMetrics", "Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "getStatePrefixLength", "", "invoke", "params", "invoke-gIAlu-s", "(Lcom/unity3d/services/core/domain/task/BaseParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMetric", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public abstract class MetricTask<P extends BaseParams, R> implements BaseTask<P, R> {
    private long duration;
    private String taskStatus = "unknown";

    private final int getStatePrefixLength() {
        return 15;
    }

    public String getMetricName() {
        return null;
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* renamed from: invoke-gIAlu-s */
    public Object mo664invokegIAlus(P p, Continuation<? super Result<? extends R>> continuation) {
        return m681invokegIAlus$suspendImpl(this, p, continuation);
    }

    @Override // com.unity3d.services.core.p005di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return BaseTask.DefaultImpls.getServiceProvider(this);
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final String getTaskStatus() {
        return this.taskStatus;
    }

    public final void setTaskStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.taskStatus = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: invoke-gIAlu-s$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object m681invokegIAlus$suspendImpl(MetricTask<? super P, R> metricTask, P p, Continuation<? super Result<? extends R>> continuation) {
        MetricTask$invoke$1 metricTask$invoke$1;
        int i;
        long nanoTime;
        MetricTask<? super P, R> metricTask2;
        Ref.ObjectRef objectRef;
        TimeUnit timeUnit;
        T t;
        Ref.ObjectRef objectRef2;
        if (continuation instanceof MetricTask$invoke$1) {
            metricTask$invoke$1 = (MetricTask$invoke$1) continuation;
            if ((metricTask$invoke$1.label & Integer.MIN_VALUE) != 0) {
                metricTask$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = metricTask$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = metricTask$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                    TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                    nanoTime = System.nanoTime();
                    metricTask$invoke$1.L$0 = metricTask;
                    metricTask$invoke$1.L$1 = objectRef3;
                    metricTask$invoke$1.L$2 = objectRef3;
                    metricTask$invoke$1.L$3 = metricTask;
                    metricTask$invoke$1.L$4 = timeUnit2;
                    metricTask$invoke$1.J$0 = nanoTime;
                    metricTask$invoke$1.label = 1;
                    Object m665invokegIAlus = BaseTask.DefaultImpls.m665invokegIAlus(metricTask, p, metricTask$invoke$1);
                    if (m665invokegIAlus == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    metricTask2 = metricTask;
                    objectRef = objectRef3;
                    timeUnit = timeUnit2;
                    t = m665invokegIAlus;
                    objectRef2 = objectRef;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j = metricTask$invoke$1.J$0;
                    timeUnit = (TimeUnit) metricTask$invoke$1.L$4;
                    MetricTask<? super P, R> metricTask3 = (MetricTask) metricTask$invoke$1.L$3;
                    objectRef = (Ref.ObjectRef) metricTask$invoke$1.L$2;
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) metricTask$invoke$1.L$1;
                    metricTask2 = (MetricTask) metricTask$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    metricTask = metricTask3;
                    objectRef2 = objectRef4;
                    nanoTime = j;
                    t = ((Result) obj).getValue();
                }
                objectRef.element = t;
                Unit unit = Unit.INSTANCE;
                ((MetricTask) metricTask).duration = timeUnit.toMillis(System.nanoTime() - nanoTime);
                metricTask2.captureMetric(objectRef2.element);
                return objectRef2.element;
            }
        }
        metricTask$invoke$1 = new MetricTask$invoke$1(metricTask, continuation);
        Object obj2 = metricTask$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = metricTask$invoke$1.label;
        if (i != 0) {
        }
        objectRef.element = t;
        Unit unit2 = Unit.INSTANCE;
        ((MetricTask) metricTask).duration = timeUnit.toMillis(System.nanoTime() - nanoTime);
        metricTask2.captureMetric(objectRef2.element);
        return objectRef2.element;
    }

    private final void captureMetric(Object result) {
        this.taskStatus = Result.m752isSuccessimpl(result) ? "success" : "failure";
        sendMetric();
    }

    private final void sendMetric() {
        String metricName = getMetricName();
        if (metricName == null || metricName.length() == 0) {
            return;
        }
        getSDKMetrics().sendMetric(getMetric());
    }

    private final Metric getMetric() {
        return new Metric(getMetricName(), Long.valueOf(this.duration), getMetricTagsForState());
    }

    private final Map<String, String> getMetricTagsForState() {
        Map<String, String> retryTags = InitializeEventsMetricSender.getInstance().getRetryTags();
        Intrinsics.checkNotNullExpressionValue(retryTags, "getInstance().retryTags");
        return retryTags;
    }

    private final SDKMetricsSender getSDKMetrics() {
        return (SDKMetricsSender) getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(SDKMetricsSender.class));
    }

    public final String getMetricNameForTask(Object task) {
        Intrinsics.checkNotNullParameter(task, "task");
        String className = task.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(className, "className");
        if (className.length() == 0) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(className, "className");
        String substring = className.substring(getStatePrefixLength());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        String lowerCase = substring.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        StringBuilder sb = new StringBuilder(7 + lowerCase.length() + 6);
        sb.append("native_");
        sb.append(lowerCase);
        sb.append("_state");
        return sb.toString();
    }

    public final String getMetricNameForInitializeTask(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return "native_" + name + "_task_" + this.taskStatus + "_time";
    }
}
