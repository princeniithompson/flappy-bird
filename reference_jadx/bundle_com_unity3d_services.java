
// ===== FILE: com/unity3d/services/SDKErrorHandler$sendDiagnostic$1.java =====
package com.unity3d.services;

import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SDKErrorHandler.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.SDKErrorHandler$sendDiagnostic$1", m464f = "SDKErrorHandler.kt", m465i = {}, m466l = {}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class SDKErrorHandler$sendDiagnostic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ String $reason;
    final /* synthetic */ String $scopeName;
    final /* synthetic */ String $stackTrace;
    int label;
    final /* synthetic */ SDKErrorHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SDKErrorHandler$sendDiagnostic$1(SDKErrorHandler sDKErrorHandler, String str, String str2, String str3, String str4, Continuation<? super SDKErrorHandler$sendDiagnostic$1> continuation) {
        super(2, continuation);
        this.this$0 = sDKErrorHandler;
        this.$name = str;
        this.$reason = str2;
        this.$stackTrace = str3;
        this.$scopeName = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SDKErrorHandler$sendDiagnostic$1(this.this$0, this.$name, this.$reason, this.$stackTrace, this.$scopeName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SDKErrorHandler$sendDiagnostic$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SendDiagnosticEvent sendDiagnosticEvent;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            sendDiagnosticEvent = this.this$0.sendDiagnosticEvent;
            SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, this.$name, null, MapsKt.mapOf(TuplesKt.m451to("reason", this.$reason), TuplesKt.m451to("reason_debug", this.$stackTrace), TuplesKt.m451to("coroutine_name", this.$scopeName)), null, null, 26, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

// ===== FILE: com/unity3d/services/SDKErrorHandler.java =====
package com.unity3d.services;

import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.ExceptionExtensionsKt;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: SDKErrorHandler.kt */
@Metadata(m443d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J(\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012H\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m444d2 = {"Lcom/unity3d/services/SDKErrorHandler;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "alternativeFlowReader", "Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "sdkMetricsSender", "Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;)V", "key", "Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "getKey", "()Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getShortenedStackTrace", "", "e", "", "maxLines", "", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "retrieveCoroutineName", "sendDiagnostic", MediationMetaData.KEY_NAME, "reason", "scopeName", "stackTrace", "sendMetric", "metric", "Lcom/unity3d/services/core/request/metrics/Metric;", "Companion", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class SDKErrorHandler implements CoroutineExceptionHandler {
    public static final String UNITY_PACKAGE = "com.unity3d";
    public static final String UNKNOWN_FILE = "unknown";
    private final AlternativeFlowReader alternativeFlowReader;
    private final CoroutineDispatcher ioDispatcher;
    private final CoroutineExceptionHandler.Companion key;
    private final CoroutineScope scope;
    private final SDKMetricsSender sdkMetricsSender;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public SDKErrorHandler(CoroutineDispatcher ioDispatcher, AlternativeFlowReader alternativeFlowReader, SendDiagnosticEvent sendDiagnosticEvent, SDKMetricsSender sdkMetricsSender) {
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(alternativeFlowReader, "alternativeFlowReader");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(sdkMetricsSender, "sdkMetricsSender");
        this.ioDispatcher = ioDispatcher;
        this.alternativeFlowReader = alternativeFlowReader;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.sdkMetricsSender = sdkMetricsSender;
        this.scope = CoroutineScopeKt.plus(CoroutineScopeKt.CoroutineScope(ioDispatcher), new CoroutineName("SDKErrorHandler"));
        this.key = CoroutineExceptionHandler.INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) CoroutineExceptionHandler.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) CoroutineExceptionHandler.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineExceptionHandler.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineExceptionHandler.DefaultImpls.plus(this, coroutineContext);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineExceptionHandler.Companion getKey() {
        return this.key;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext context, Throwable exception) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(exception, "exception");
        String retrieveCoroutineName = retrieveCoroutineName(context);
        if (exception instanceof NullPointerException) {
            str = "native_exception_npe";
        } else if (exception instanceof OutOfMemoryError) {
            str = "native_exception_oom";
        } else if (exception instanceof IllegalStateException) {
            str = "native_exception_ise";
        } else if (exception instanceof SecurityException) {
            str = "native_exception_se";
        } else {
            str = exception instanceof RuntimeException ? "native_exception_re" : "native_exception";
        }
        String str2 = str;
        boolean invoke = this.alternativeFlowReader.invoke();
        String retrieveUnityCrashValue = ExceptionExtensionsKt.retrieveUnityCrashValue(exception);
        DeviceLog.error("Unity Ads SDK encountered an exception: " + retrieveUnityCrashValue);
        if (invoke) {
            sendDiagnostic(str2, retrieveUnityCrashValue, retrieveCoroutineName, getShortenedStackTrace(exception, 15));
        } else {
            sendMetric(new Metric(str2, retrieveUnityCrashValue, null, 4, null));
        }
    }

    private final void sendDiagnostic(String name, String reason, String scopeName, String stackTrace) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new SDKErrorHandler$sendDiagnostic$1(this, name, reason, stackTrace, scopeName, null), 3, null);
    }

    private final void sendMetric(Metric metric) {
        this.sdkMetricsSender.sendMetric(metric);
    }

    private final String retrieveCoroutineName(CoroutineContext context) {
        String name;
        CoroutineName coroutineName = (CoroutineName) context.get(CoroutineName.INSTANCE);
        return (coroutineName == null || (name = coroutineName.getName()) == null) ? "unknown" : name;
    }

    private final String getShortenedStackTrace(Throwable e, int maxLines) {
        try {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, "writer.toString()");
            return SequencesKt.joinToString$default(SequencesKt.take(StringsKt.lineSequence(StringsKt.trim((CharSequence) stringWriter2).toString()), maxLines), "\n", null, null, 0, null, null, 62, null);
        } catch (Throwable unused) {
            return "";
        }
    }
}

// ===== FILE: com/unity3d/services/UnityAdsConstants.java =====
package com.unity3d.services;

import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import kotlin.Metadata;

/* compiled from: UnityAdsConstants.kt */
@Metadata(m443d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u000b\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u000e"}, m444d2 = {"Lcom/unity3d/services/UnityAdsConstants;", "", "()V", "AdOperations", "Cache", "ClientInfo", "DefaultUrls", "ErrorHandler", "Messages", "OpenMeasurement", "Preferences", "RequestPolicy", "SharedFlow", AndroidInitializeBoldSDK.MSG_TIMEOUT, "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class UnityAdsConstants {
    public static final UnityAdsConstants INSTANCE = new UnityAdsConstants();

    private UnityAdsConstants() {
    }

    /* compiled from: UnityAdsConstants.kt */
    @Metadata(m443d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m444d2 = {"Lcom/unity3d/services/UnityAdsConstants$Messages;", "", "()V", "MSG_INTERNAL_ERROR", "", "MSG_UNITY_BASE", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class Messages {
        public static final Messages INSTANCE = new Messages();
        public static final String MSG_INTERNAL_ERROR = "Internal error";
        public static final String MSG_UNITY_BASE = "[Unity Ads] ";

        private Messages() {
        }
    }

    /* compiled from: UnityAdsConstants.kt */
    @Metadata(m443d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m444d2 = {"Lcom/unity3d/services/UnityAdsConstants$Timeout;", "", "()V", "INIT_TIMEOUT_MS", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class Timeout {
        public static final long INIT_TIMEOUT_MS = 120000;
        public static final Timeout INSTANCE = new Timeout();

        private Timeout() {
        }
    }

    /* compiled from: UnityAdsConstants.kt */
    @Metadata(m443d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m444d2 = {"Lcom/unity3d/services/UnityAdsConstants$RequestPolicy;", "", "()V", "CONNECT_TIMEOUT_MS", "", "OVERALL_TIMEOUT_MS", "READ_TIMEOUT_MS", "RETRY_JITTER_PCT", "", "RETRY_MAX_DURATION", "RETRY_MAX_INTERVAL", "RETRY_SCALING_FACTOR", "RETRY_WAIT_BASE", "SHOULD_STORE_LOCALLY", "", "WRITE_TIMEOUT_MS", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class RequestPolicy {
        public static final int CONNECT_TIMEOUT_MS = 10000;
        public static final RequestPolicy INSTANCE = new RequestPolicy();
        public static final int OVERALL_TIMEOUT_MS = 20000;
        public static final int READ_TIMEOUT_MS = 10000;
        public static final float RETRY_JITTER_PCT = 0.1f;
        public static final int RETRY_MAX_DURATION = 120000;
        public static final int RETRY_MAX_INTERVAL = 1000;
        public static final float RETRY_SCALING_FACTOR = 2.0f;
        public static final int RETRY_WAIT_BASE = 500;
        public static final boolean SHOULD_STORE_LOCALLY = false;
        public static final int WRITE_TIMEOUT_MS = 10000;

        private RequestPolicy() {
        }
    }

    /* compiled from: UnityAdsConstants.kt */
    @Metadata(m443d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m444d2 = {"Lcom/unity3d/services/UnityAdsConstants$SharedFlow;", "", "()V", "EXTRA_CAPACITY", "", "REPLAY", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class SharedFlow {
        public static final int EXTRA_CAPACITY = 10;
        public static final SharedFlow INSTANCE = new SharedFlow();
        public static final int REPLAY = 10;

        private SharedFlow() {
        }
    }

    /* compiled from: UnityAdsConstants.kt */
    @Metadata(m443d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m444d2 = {"Lcom/unity3d/services/UnityAdsConstants$DefaultUrls;", "", "()V", "AD_ASSET_DOMAIN", "", "AD_ASSET_PATH", "AD_CACHE_DOMAIN", "AD_PLAYER_QUERY_PARAMS", "ASSET_DOMAIN", "CACHE_DIR_NAME", "GATEWAY_URL", "HTTP_CACHE_DIR_NAME", "WEBVIEW_ASSET_PATH", "WEBVIEW_DOMAIN", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class DefaultUrls {
        public static final String AD_ASSET_DOMAIN = "unity.ads.asset";
        public static final String AD_ASSET_PATH = "/";
        public static final String AD_CACHE_DOMAIN = "unity.ads.cache";
        public static final String AD_PLAYER_QUERY_PARAMS = "?platform=android&";
        public static final String ASSET_DOMAIN = "cdn-creatives-cf-prd.acquire.unity3dusercontent.com";
        public static final String CACHE_DIR_NAME = "UnityAdsCache";
        public static final String GATEWAY_URL = "https://gateway.unityads.unity3d.com/v1";
        public static final String HTTP_CACHE_DIR_NAME = "UnityAdsHttpCache";
        public static final DefaultUrls INSTANCE = new DefaultUrls();
        public static final String WEBVIEW_ASSET_PATH = "/unity-ads-sdk-webview/";
        public static final String WEBVIEW_DOMAIN = "config.unityads.unity3d.com";

        private DefaultUrls() {
        }
    }

    /* compiled from: UnityAdsConstants.kt */
    @Metadata(m443d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m444d2 = {"Lcom/unity3d/services/UnityAdsConstants$ClientInfo;", "", "()V", "SDK_VERSION", "", "SDK_VERSION_NAME", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class ClientInfo {
        public static final ClientInfo INSTANCE = new ClientInfo();
        public static final int SDK_VERSION = 41205;
        public static final String SDK_VERSION_NAME = "4.12.5";

        private ClientInfo() {
        }
    }

    /* compiled from: UnityAdsConstants.kt */
    @Metadata(m443d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m444d2 = {"Lcom/unity3d/services/UnityAdsConstants$OpenMeasurement;", "", "()V", "OM_JS_SERVICE_FILENAME", "", "OM_JS_SESSION_FILENAME", "OM_JS_URL_SERVICE", "OM_JS_URL_SESSION", "OM_PARTNER_NAME", "OM_PARTNER_VERSION", "OM_SESSION_FINISH_DELAY_MS", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class OpenMeasurement {
        public static final OpenMeasurement INSTANCE = new OpenMeasurement();
        public static final String OM_JS_SERVICE_FILENAME = "ad-viewer/omsdk-v1.js";
        public static final String OM_JS_SESSION_FILENAME = "ad-viewer/omid-session-client-v1.js";
        public static final String OM_JS_URL_SERVICE = "unity-ads-cache://unity.ads.asset/ad-viewer/omsdk-v1.js";
        public static final String OM_JS_URL_SESSION = "unity-ads-cache://unity.ads.asset/ad-viewer/omid-session-client-v1.js";
        public static final String OM_PARTNER_NAME = "Unity3d";
        public static final String OM_PARTNER_VERSION = "1";
        public static final long OM_SESSION_FINISH_DELAY_MS = 1000;

        private OpenMeasurement() {
        }
    }

    /* compiled from: UnityAdsConstants.kt */
    @Metadata(m443d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m444d2 = {"Lcom/unity3d/services/UnityAdsConstants$Cache;", "", "()V", "CACHE_SCHEME", "", "DATASTORE_PATH", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class Cache {
        public static final String CACHE_SCHEME = "unity-ads-cache";
        public static final String DATASTORE_PATH = "unityAdsDatastore/";
        public static final Cache INSTANCE = new Cache();

        private Cache() {
        }
    }

    /* compiled from: UnityAdsConstants.kt */
    @Metadata(m443d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m444d2 = {"Lcom/unity3d/services/UnityAdsConstants$AdOperations;", "", "()V", "GET_TOKEN_TIMEOUT_MS", "", "LOAD_TIMEOUT_MS", "SHOW_TIMEOUT_MS", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class AdOperations {
        public static final int GET_TOKEN_TIMEOUT_MS = 2750;
        public static final AdOperations INSTANCE = new AdOperations();
        public static final int LOAD_TIMEOUT_MS = 30000;
        public static final int SHOW_TIMEOUT_MS = 10000;

        private AdOperations() {
        }
    }

    /* compiled from: UnityAdsConstants.kt */
    @Metadata(m443d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m444d2 = {"Lcom/unity3d/services/UnityAdsConstants$Preferences;", "", "()V", "PREF_KEY_AUID", "", "PREF_KEY_IDFI", "PREF_NAME_AUID", "PREF_NAME_IDFI", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class Preferences {
        public static final Preferences INSTANCE = new Preferences();
        public static final String PREF_KEY_AUID = "auid";
        public static final String PREF_KEY_IDFI = "unityads-idfi";
        public static final String PREF_NAME_AUID = "supersonic_shared_preferen";
        public static final String PREF_NAME_IDFI = "unityads-installinfo";

        private Preferences() {
        }
    }

    /* compiled from: UnityAdsConstants.kt */
    @Metadata(m443d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m444d2 = {"Lcom/unity3d/services/UnityAdsConstants$ErrorHandler;", "", "()V", "ERROR_HANDLER_STACK_TRACE_LINES_MAX", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class ErrorHandler {
        public static final int ERROR_HANDLER_STACK_TRACE_LINES_MAX = 15;
        public static final ErrorHandler INSTANCE = new ErrorHandler();

        private ErrorHandler() {
        }
    }
}

// ===== FILE: com/unity3d/services/UnityAdsSDK$fetchToken$1.java =====
package com.unity3d.services;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: UnityAdsSDK.kt */
@Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
@DebugMetadata(m463c = "com.unity3d.services.UnityAdsSDK", m464f = "UnityAdsSDK.kt", m465i = {0, 0, 0, 0, 0, 0}, m466l = {141}, m467m = "fetchToken", m468n = {"sync", "getInitializationState$delegate", "sendDiagnosticEvent$delegate", "reason", "reasonDebug", "startTime"}, m469s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0"})
/* loaded from: classes.dex */
final class UnityAdsSDK$fetchToken$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UnityAdsSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UnityAdsSDK$fetchToken$1(UnityAdsSDK unityAdsSDK, Continuation<? super UnityAdsSDK$fetchToken$1> continuation) {
        super(continuation);
        this.this$0 = unityAdsSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fetchToken;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchToken = this.this$0.fetchToken(null, this);
        return fetchToken;
    }
}

// ===== FILE: com/unity3d/services/UnityAdsSDK$finishOMIDSession$1.java =====
package com.unity3d.services;

import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.domain.GetAdObject;
import com.unity3d.ads.core.domain.p002om.OmFinishSession;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: UnityAdsSDK.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.UnityAdsSDK$finishOMIDSession$1", m464f = "UnityAdsSDK.kt", m465i = {}, m466l = {171, 172}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class UnityAdsSDK$finishOMIDSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lazy<AlternativeFlowReader> $alternativeFlowReader$delegate;
    final /* synthetic */ Lazy<GetAdObject> $getAdObject$delegate;
    final /* synthetic */ Lazy<OmFinishSession> $omFinishSession$delegate;
    final /* synthetic */ CoroutineScope $omidScope;
    final /* synthetic */ String $opportunityId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UnityAdsSDK$finishOMIDSession$1(String str, CoroutineScope coroutineScope, Lazy<AlternativeFlowReader> lazy, Lazy<? extends GetAdObject> lazy2, Lazy<? extends OmFinishSession> lazy3, Continuation<? super UnityAdsSDK$finishOMIDSession$1> continuation) {
        super(2, continuation);
        this.$opportunityId = str;
        this.$omidScope = coroutineScope;
        this.$alternativeFlowReader$delegate = lazy;
        this.$getAdObject$delegate = lazy2;
        this.$omFinishSession$delegate = lazy3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnityAdsSDK$finishOMIDSession$1(this.$opportunityId, this.$omidScope, this.$alternativeFlowReader$delegate, this.$getAdObject$delegate, this.$omFinishSession$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnityAdsSDK$finishOMIDSession$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AlternativeFlowReader finishOMIDSession$lambda$16;
        GetAdObject finishOMIDSession$lambda$14;
        AdObject adObject;
        OmFinishSession finishOMIDSession$lambda$15;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            finishOMIDSession$lambda$16 = UnityAdsSDK.finishOMIDSession$lambda$16(this.$alternativeFlowReader$delegate);
            if (finishOMIDSession$lambda$16.invoke()) {
                finishOMIDSession$lambda$14 = UnityAdsSDK.finishOMIDSession$lambda$14(this.$getAdObject$delegate);
                this.label = 1;
                obj = finishOMIDSession$lambda$14.invoke(this.$opportunityId, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                adObject = (AdObject) obj;
                if (adObject != null) {
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            adObject = (AdObject) obj;
            if (adObject != null) {
                finishOMIDSession$lambda$15 = UnityAdsSDK.finishOMIDSession$lambda$15(this.$omFinishSession$delegate);
                this.label = 2;
                if (finishOMIDSession$lambda$15.invoke(adObject, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CoroutineScopeKt.cancel$default(this.$omidScope, null, 1, null);
        return Unit.INSTANCE;
    }
}

// ===== FILE: com/unity3d/services/UnityAdsSDK$getToken$1.java =====
package com.unity3d.services;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: UnityAdsSDK.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.UnityAdsSDK$getToken$1", m464f = "UnityAdsSDK.kt", m465i = {}, m466l = {111}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class UnityAdsSDK$getToken$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    UnityAdsSDK$getToken$1(Continuation<? super UnityAdsSDK$getToken$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnityAdsSDK$getToken$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((UnityAdsSDK$getToken$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = UnityAdsSDK.INSTANCE.fetchToken("true", this);
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

// ===== FILE: com/unity3d/services/UnityAdsSDK$getToken$2.java =====
package com.unity3d.services;

import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: UnityAdsSDK.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.UnityAdsSDK$getToken$2", m464f = "UnityAdsSDK.kt", m465i = {}, m466l = {118}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class UnityAdsSDK$getToken$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lazy<GetAsyncHeaderBiddingToken> $getAsyncHeaderBiddingToken$delegate;
    final /* synthetic */ CoroutineScope $getTokenScope;
    final /* synthetic */ IUnityAdsTokenListener $listener;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UnityAdsSDK$getToken$2(IUnityAdsTokenListener iUnityAdsTokenListener, CoroutineScope coroutineScope, Lazy<? extends GetAsyncHeaderBiddingToken> lazy, Continuation<? super UnityAdsSDK$getToken$2> continuation) {
        super(2, continuation);
        this.$listener = iUnityAdsTokenListener;
        this.$getTokenScope = coroutineScope;
        this.$getAsyncHeaderBiddingToken$delegate = lazy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnityAdsSDK$getToken$2(this.$listener, this.$getTokenScope, this.$getAsyncHeaderBiddingToken$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnityAdsSDK$getToken$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GetAsyncHeaderBiddingToken token$lambda$7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            token$lambda$7 = UnityAdsSDK.getToken$lambda$7(this.$getAsyncHeaderBiddingToken$delegate);
            this.label = 1;
            if (token$lambda$7.invoke(this.$listener, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CoroutineScopeKt.cancel$default(this.$getTokenScope, null, 1, null);
        return Unit.INSTANCE;
    }
}

// ===== FILE: com/unity3d/services/UnityAdsSDK$initialize$1.java =====
package com.unity3d.services;

import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.domain.InitializeBoldSDK;
import com.unity3d.services.core.domain.task.EmptyParams;
import com.unity3d.services.core.domain.task.InitializeSDK;
import kotlin.Lazy;
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
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: UnityAdsSDK.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.UnityAdsSDK$initialize$1", m464f = "UnityAdsSDK.kt", m465i = {}, m466l = {64, 66}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class UnityAdsSDK$initialize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lazy<AlternativeFlowReader> $alternativeFlowReader$delegate;
    final /* synthetic */ CoroutineScope $initScope;
    final /* synthetic */ Lazy<InitializeBoldSDK> $initializeBoldSDK$delegate;
    final /* synthetic */ Lazy<InitializeSDK> $initializeSDK$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UnityAdsSDK$initialize$1(CoroutineScope coroutineScope, Lazy<AlternativeFlowReader> lazy, Lazy<? extends InitializeBoldSDK> lazy2, Lazy<InitializeSDK> lazy3, Continuation<? super UnityAdsSDK$initialize$1> continuation) {
        super(2, continuation);
        this.$initScope = coroutineScope;
        this.$alternativeFlowReader$delegate = lazy;
        this.$initializeBoldSDK$delegate = lazy2;
        this.$initializeSDK$delegate = lazy3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnityAdsSDK$initialize$1(this.$initScope, this.$alternativeFlowReader$delegate, this.$initializeBoldSDK$delegate, this.$initializeSDK$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnityAdsSDK$initialize$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AlternativeFlowReader initialize$lambda$0;
        InitializeSDK initialize$lambda$2;
        InitializeBoldSDK initialize$lambda$3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            initialize$lambda$0 = UnityAdsSDK.initialize$lambda$0(this.$alternativeFlowReader$delegate);
            if (initialize$lambda$0.invoke()) {
                initialize$lambda$3 = UnityAdsSDK.initialize$lambda$3(this.$initializeBoldSDK$delegate);
                this.label = 1;
                if (initialize$lambda$3.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                initialize$lambda$2 = UnityAdsSDK.initialize$lambda$2(this.$initializeSDK$delegate);
                this.label = 2;
                if (initialize$lambda$2.mo664invokegIAlus(EmptyParams.INSTANCE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((Result) obj).getValue();
        }
        CoroutineScopeKt.cancel$default(this.$initScope, null, 1, null);
        return Unit.INSTANCE;
    }
}

// ===== FILE: com/unity3d/services/UnityAdsSDK$load$1.java =====
package com.unity3d.services;

import android.content.Context;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.domain.LegacyLoadUseCase;
import com.unity3d.services.banners.UnityBannerSize;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: UnityAdsSDK.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.UnityAdsSDK$load$1", m464f = "UnityAdsSDK.kt", m465i = {}, m466l = {89}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class UnityAdsSDK$load$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UnityBannerSize $bannerSize;
    final /* synthetic */ Lazy<Context> $context$delegate;
    final /* synthetic */ IUnityAdsLoadListener $listener;
    final /* synthetic */ UnityAdsLoadOptions $loadOptions;
    final /* synthetic */ CoroutineScope $loadScope;
    final /* synthetic */ String $placementId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UnityAdsSDK$load$1(String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener, UnityBannerSize unityBannerSize, CoroutineScope coroutineScope, Lazy<? extends Context> lazy, Continuation<? super UnityAdsSDK$load$1> continuation) {
        super(2, continuation);
        this.$placementId = str;
        this.$loadOptions = unityAdsLoadOptions;
        this.$listener = iUnityAdsLoadListener;
        this.$bannerSize = unityBannerSize;
        this.$loadScope = coroutineScope;
        this.$context$delegate = lazy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnityAdsSDK$load$1(this.$placementId, this.$loadOptions, this.$listener, this.$bannerSize, this.$loadScope, this.$context$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnityAdsSDK$load$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context load$lambda$5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LegacyLoadUseCase legacyLoadUseCase = (LegacyLoadUseCase) UnityAdsSDK.INSTANCE.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(LegacyLoadUseCase.class));
            load$lambda$5 = UnityAdsSDK.load$lambda$5(this.$context$delegate);
            this.label = 1;
            if (legacyLoadUseCase.invoke(load$lambda$5, this.$placementId, this.$loadOptions, this.$listener, this.$bannerSize, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CoroutineScopeKt.cancel$default(this.$loadScope, null, 1, null);
        return Unit.INSTANCE;
    }
}

// ===== FILE: com/unity3d/services/UnityAdsSDK$show$1.java =====
package com.unity3d.services;

import android.content.Context;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.core.data.model.Listeners;
import com.unity3d.ads.core.domain.LegacyShowUseCase;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: UnityAdsSDK.kt */
@Metadata(m443d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, m444d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, m445k = 3, m446mv = {1, 8, 0})
@DebugMetadata(m463c = "com.unity3d.services.UnityAdsSDK$show$1", m464f = "UnityAdsSDK.kt", m465i = {}, m466l = {100}, m467m = "invokeSuspend", m468n = {}, m469s = {})
/* loaded from: classes.dex */
final class UnityAdsSDK$show$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lazy<Context> $context$delegate;
    final /* synthetic */ Listeners $listener;
    final /* synthetic */ String $placementId;
    final /* synthetic */ LegacyShowUseCase $showBoldSDK;
    final /* synthetic */ UnityAdsShowOptions $showOptions;
    final /* synthetic */ CoroutineScope $showScope;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UnityAdsSDK$show$1(LegacyShowUseCase legacyShowUseCase, String str, UnityAdsShowOptions unityAdsShowOptions, Listeners listeners, CoroutineScope coroutineScope, Lazy<? extends Context> lazy, Continuation<? super UnityAdsSDK$show$1> continuation) {
        super(2, continuation);
        this.$showBoldSDK = legacyShowUseCase;
        this.$placementId = str;
        this.$showOptions = unityAdsShowOptions;
        this.$listener = listeners;
        this.$showScope = coroutineScope;
        this.$context$delegate = lazy;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnityAdsSDK$show$1(this.$showBoldSDK, this.$placementId, this.$showOptions, this.$listener, this.$showScope, this.$context$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnityAdsSDK$show$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context show$lambda$6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LegacyShowUseCase legacyShowUseCase = this.$showBoldSDK;
            show$lambda$6 = UnityAdsSDK.show$lambda$6(this.$context$delegate);
            this.label = 1;
            if (legacyShowUseCase.invoke(show$lambda$6, this.$placementId, this.$showOptions, this.$listener, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CoroutineScopeKt.cancel$default(this.$showScope, null, 1, null);
        return Unit.INSTANCE;
    }
}

// ===== FILE: com/unity3d/services/UnityAdsSDK.java =====
package com.unity3d.services;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.Listeners;
import com.unity3d.ads.core.domain.GetAdObject;
import com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken;
import com.unity3d.ads.core.domain.GetHeaderBiddingToken;
import com.unity3d.ads.core.domain.GetInitializationState;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.InitializeBoldSDK;
import com.unity3d.ads.core.domain.LegacyShowUseCase;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.SetInitializationState;
import com.unity3d.ads.core.domain.p002om.OmFinishSession;
import com.unity3d.ads.core.extensions.ExceptionExtensionsKt;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.core.domain.task.InitializeSDK;
import com.unity3d.services.core.p005di.IServiceComponent;
import com.unity3d.services.core.p005di.IServiceProvider;
import com.unity3d.services.core.p005di.ServiceProvider;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.time.TimeSource;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: UnityAdsSDK.kt */
@Metadata(m443d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ.\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\"\u0010\u0017\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000b\u001a\u00020\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020#X\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020'X\u008a\u0084\u0002²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020+X\u008a\u0084\u0002²\u0006\n\u0010,\u001a\u00020-X\u008a\u0084\u0002²\u0006\n\u0010.\u001a\u00020/X\u008a\u0084\u0002²\u0006\n\u00100\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001dX\u008a\u0084\u0002"}, m444d2 = {"Lcom/unity3d/services/UnityAdsSDK;", "Lcom/unity3d/services/core/di/IServiceComponent;", "()V", "fetchToken", "", "sync", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finishOMIDSession", "Lkotlinx/coroutines/Job;", "opportunityId", "getToken", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/unity3d/ads/IUnityAdsTokenListener;", MobileAdsBridgeBase.initializeMethodName, "isAlternativeFlowEnabled", "", "load", "placementId", HandleInvocationsFromAdViewer.KEY_LOAD_OPTIONS, "Lcom/unity3d/ads/UnityAdsLoadOptions;", "Lcom/unity3d/ads/IUnityAdsLoadListener;", "bannerSize", "Lcom/unity3d/services/banners/UnityBannerSize;", "show", "showOptions", "Lcom/unity3d/ads/UnityAdsShowOptions;", "Lcom/unity3d/ads/core/data/model/Listeners;", "unity-ads_release", "alternativeFlowReader", "Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;", "setInitializationState", "Lcom/unity3d/ads/core/domain/SetInitializationState;", "initializeSDK", "Lcom/unity3d/services/core/domain/task/InitializeSDK;", "initializeBoldSDK", "Lcom/unity3d/ads/core/domain/InitializeBoldSDK;", "context", "Landroid/content/Context;", "getAsyncHeaderBiddingToken", "Lcom/unity3d/ads/core/domain/GetAsyncHeaderBiddingToken;", "getHeaderBiddingToken", "Lcom/unity3d/ads/core/domain/GetHeaderBiddingToken;", "getInitializationState", "Lcom/unity3d/ads/core/domain/GetInitializationState;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "getAdObject", "Lcom/unity3d/ads/core/domain/GetAdObject;", "omFinishSession", "Lcom/unity3d/ads/core/domain/om/OmFinishSession;"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class UnityAdsSDK implements IServiceComponent {
    public static final UnityAdsSDK INSTANCE = new UnityAdsSDK();

    private UnityAdsSDK() {
    }

    @Override // com.unity3d.services.core.p005di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AlternativeFlowReader initialize$lambda$0(Lazy<AlternativeFlowReader> lazy) {
        return lazy.getValue();
    }

    public final Job initialize() {
        Job launch$default;
        final UnityAdsSDK unityAdsSDK = this;
        final String str = "";
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<AlternativeFlowReader>() { // from class: com.unity3d.services.UnityAdsSDK$initialize$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.configuration.AlternativeFlowReader, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AlternativeFlowReader invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class));
            }
        });
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SetInitializationState>() { // from class: com.unity3d.services.UnityAdsSDK$initialize$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.SetInitializationState, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SetInitializationState invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(SetInitializationState.class));
            }
        });
        Lazy lazy3 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<InitializeSDK>() { // from class: com.unity3d.services.UnityAdsSDK$initialize$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.services.core.domain.task.InitializeSDK, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final InitializeSDK invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(InitializeSDK.class));
            }
        });
        Lazy lazy4 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<InitializeBoldSDK>() { // from class: com.unity3d.services.UnityAdsSDK$initialize$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.InitializeBoldSDK, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final InitializeBoldSDK invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(InitializeBoldSDK.class));
            }
        });
        initialize$lambda$1(lazy2).invoke(InitializationState.INITIALIZING);
        CoroutineScope coroutineScope = (CoroutineScope) unityAdsSDK.getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_INIT_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class));
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new UnityAdsSDK$initialize$1(coroutineScope, lazy, lazy4, lazy3, null), 3, null);
        return launch$default;
    }

    private static final SetInitializationState initialize$lambda$1(Lazy<? extends SetInitializationState> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InitializeSDK initialize$lambda$2(Lazy<InitializeSDK> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InitializeBoldSDK initialize$lambda$3(Lazy<? extends InitializeBoldSDK> lazy) {
        return lazy.getValue();
    }

    private static final AlternativeFlowReader isAlternativeFlowEnabled$lambda$4(Lazy<AlternativeFlowReader> lazy) {
        return lazy.getValue();
    }

    public final boolean isAlternativeFlowEnabled() {
        final UnityAdsSDK unityAdsSDK = this;
        final String str = "";
        return isAlternativeFlowEnabled$lambda$4(LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<AlternativeFlowReader>() { // from class: com.unity3d.services.UnityAdsSDK$isAlternativeFlowEnabled$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.configuration.AlternativeFlowReader, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AlternativeFlowReader invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class));
            }
        })).invoke();
    }

    public static /* synthetic */ Job load$default(UnityAdsSDK unityAdsSDK, String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener, UnityBannerSize unityBannerSize, int i, Object obj) {
        if ((i & 8) != 0) {
            unityBannerSize = null;
        }
        return unityAdsSDK.load(str, unityAdsLoadOptions, iUnityAdsLoadListener, unityBannerSize);
    }

    public final Job load(String placementId, UnityAdsLoadOptions loadOptions, IUnityAdsLoadListener listener, UnityBannerSize bannerSize) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(loadOptions, "loadOptions");
        final UnityAdsSDK unityAdsSDK = this;
        CoroutineScope coroutineScope = (CoroutineScope) unityAdsSDK.getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_LOAD_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class));
        final String str = "";
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new UnityAdsSDK$load$1(placementId, loadOptions, listener, bannerSize, coroutineScope, LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Context>() { // from class: com.unity3d.services.UnityAdsSDK$load$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [android.content.Context, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final Context invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(Context.class));
            }
        }), null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context load$lambda$5(Lazy<? extends Context> lazy) {
        return lazy.getValue();
    }

    public final Job show(String placementId, UnityAdsShowOptions showOptions, Listeners listener) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(listener, "listener");
        final UnityAdsSDK unityAdsSDK = this;
        CoroutineScope coroutineScope = (CoroutineScope) unityAdsSDK.getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_SHOW_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class));
        final String str = "";
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new UnityAdsSDK$show$1((LegacyShowUseCase) unityAdsSDK.getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(LegacyShowUseCase.class)), placementId, showOptions, listener, coroutineScope, LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Context>() { // from class: com.unity3d.services.UnityAdsSDK$show$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [android.content.Context, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final Context invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(Context.class));
            }
        }), null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context show$lambda$6(Lazy<? extends Context> lazy) {
        return lazy.getValue();
    }

    public final String getToken() {
        Object runBlocking$default;
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new UnityAdsSDK$getToken$1(null), 1, null);
        return (String) runBlocking$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetAsyncHeaderBiddingToken getToken$lambda$7(Lazy<? extends GetAsyncHeaderBiddingToken> lazy) {
        return lazy.getValue();
    }

    public final Job getToken(IUnityAdsTokenListener listener) {
        Job launch$default;
        final UnityAdsSDK unityAdsSDK = this;
        final String str = "";
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GetAsyncHeaderBiddingToken>() { // from class: com.unity3d.services.UnityAdsSDK$getToken$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GetAsyncHeaderBiddingToken invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(GetAsyncHeaderBiddingToken.class));
            }
        });
        CoroutineScope coroutineScope = (CoroutineScope) unityAdsSDK.getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_GET_TOKEN_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class));
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new UnityAdsSDK$getToken$2(listener, coroutineScope, lazy, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(19:0|1|(2:3|(15:5|6|(1:(4:9|10|11|12)(2:36|37))(2:38|(9:40|17|(1:19)(1:29)|20|(1:22)|23|(1:25)|26|27)(3:41|42|(1:44)(1:45)))|13|14|15|16|17|(0)(0)|20|(0)|23|(0)|26|27))|49|6|(0)(0)|13|14|15|16|17|(0)(0)|20|(0)|23|(0)|26|27|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0105, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARN: Type inference failed for: r0v15, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchToken(String str, Continuation<? super String> continuation) {
        UnityAdsSDK$fetchToken$1 unityAdsSDK$fetchToken$1;
        int i;
        Lazy lazy;
        Lazy lazy2;
        long m2209markNowz9LOYto;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        long j;
        Lazy lazy3;
        Lazy lazy4;
        String str2;
        String str3 = str;
        if (continuation instanceof UnityAdsSDK$fetchToken$1) {
            unityAdsSDK$fetchToken$1 = (UnityAdsSDK$fetchToken$1) continuation;
            if ((unityAdsSDK$fetchToken$1.label & Integer.MIN_VALUE) != 0) {
                unityAdsSDK$fetchToken$1.label -= Integer.MIN_VALUE;
                Object obj = unityAdsSDK$fetchToken$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = unityAdsSDK$fetchToken$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final UnityAdsSDK unityAdsSDK = this;
                    final String str4 = "";
                    Lazy lazy5 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GetHeaderBiddingToken>() { // from class: com.unity3d.services.UnityAdsSDK$fetchToken$$inlined$inject$default$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.GetHeaderBiddingToken, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        public final GetHeaderBiddingToken invoke() {
                            IServiceComponent iServiceComponent = IServiceComponent.this;
                            return iServiceComponent.getServiceProvider().getRegistry().getService(str4, Reflection.getOrCreateKotlinClass(GetHeaderBiddingToken.class));
                        }
                    });
                    lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GetInitializationState>() { // from class: com.unity3d.services.UnityAdsSDK$fetchToken$$inlined$inject$default$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.GetInitializationState, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        public final GetInitializationState invoke() {
                            IServiceComponent iServiceComponent = IServiceComponent.this;
                            return iServiceComponent.getServiceProvider().getRegistry().getService(str4, Reflection.getOrCreateKotlinClass(GetInitializationState.class));
                        }
                    });
                    lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SendDiagnosticEvent>() { // from class: com.unity3d.services.UnityAdsSDK$fetchToken$$inlined$inject$default$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.SendDiagnosticEvent, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function0
                        public final SendDiagnosticEvent invoke() {
                            IServiceComponent iServiceComponent = IServiceComponent.this;
                            return iServiceComponent.getServiceProvider().getRegistry().getService(str4, Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class));
                        }
                    });
                    m2209markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m2209markNowz9LOYto();
                    SendDiagnosticEvent.DefaultImpls.invoke$default(fetchToken$lambda$10(lazy2), "native_gateway_token_started", null, MapsKt.mapOf(TuplesKt.m451to("sync", str3), TuplesKt.m451to("state", fetchToken$lambda$9(lazy).invoke().toString())), null, null, 26, null);
                    Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                    objectRef = new Ref.ObjectRef();
                    if (fetchToken$lambda$9(lazy).invoke() != InitializationState.INITIALIZED) {
                        objectRef3.element = "not_initialized";
                        objectRef2 = objectRef3;
                        str2 = null;
                        SendDiagnosticEvent fetchToken$lambda$10 = fetchToken$lambda$10(lazy2);
                        String str5 = str2 != null ? "native_gateway_token_failure_time" : "native_gateway_token_success_time";
                        Double boxDouble = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m2210boximpl(m2209markNowz9LOYto)));
                        Map createMapBuilder = MapsKt.createMapBuilder();
                        createMapBuilder.put("sync", str3);
                        createMapBuilder.put("state", fetchToken$lambda$9(lazy).invoke().toString());
                        if (((String) objectRef2.element) != null) {
                        }
                        if (((String) objectRef.element) != null) {
                            createMapBuilder.put("reason_debug", objectRef.element);
                        }
                        Unit unit = Unit.INSTANCE;
                        SendDiagnosticEvent.DefaultImpls.invoke$default(fetchToken$lambda$10, str5, boxDouble, MapsKt.build(createMapBuilder), null, null, 24, null);
                        return str2;
                    }
                    try {
                        GetHeaderBiddingToken fetchToken$lambda$8 = fetchToken$lambda$8(lazy5);
                        unityAdsSDK$fetchToken$1.L$0 = str3;
                        unityAdsSDK$fetchToken$1.L$1 = lazy;
                        unityAdsSDK$fetchToken$1.L$2 = lazy2;
                        unityAdsSDK$fetchToken$1.L$3 = objectRef3;
                        unityAdsSDK$fetchToken$1.L$4 = objectRef;
                        unityAdsSDK$fetchToken$1.J$0 = m2209markNowz9LOYto;
                        unityAdsSDK$fetchToken$1.label = 1;
                        obj = fetchToken$lambda$8.invoke(unityAdsSDK$fetchToken$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef2 = objectRef3;
                        j = m2209markNowz9LOYto;
                        lazy3 = lazy;
                        lazy4 = lazy2;
                    } catch (Exception e) {
                        e = e;
                        objectRef2 = objectRef3;
                        j = m2209markNowz9LOYto;
                        lazy3 = lazy;
                        lazy4 = lazy2;
                        objectRef2.element = "uncaught_exception";
                        objectRef.element = ExceptionExtensionsKt.retrieveUnityCrashValue(e);
                        m2209markNowz9LOYto = j;
                        str2 = null;
                        Lazy lazy6 = lazy3;
                        lazy2 = lazy4;
                        lazy = lazy6;
                        SendDiagnosticEvent fetchToken$lambda$102 = fetchToken$lambda$10(lazy2);
                        String str52 = str2 != null ? "native_gateway_token_failure_time" : "native_gateway_token_success_time";
                        Double boxDouble2 = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m2210boximpl(m2209markNowz9LOYto)));
                        Map createMapBuilder2 = MapsKt.createMapBuilder();
                        createMapBuilder2.put("sync", str3);
                        createMapBuilder2.put("state", fetchToken$lambda$9(lazy).invoke().toString());
                        if (((String) objectRef2.element) != null) {
                        }
                        if (((String) objectRef.element) != null) {
                        }
                        Unit unit2 = Unit.INSTANCE;
                        SendDiagnosticEvent.DefaultImpls.invoke$default(fetchToken$lambda$102, str52, boxDouble2, MapsKt.build(createMapBuilder2), null, null, 24, null);
                        return str2;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = unityAdsSDK$fetchToken$1.J$0;
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) unityAdsSDK$fetchToken$1.L$4;
                    objectRef2 = (Ref.ObjectRef) unityAdsSDK$fetchToken$1.L$3;
                    lazy4 = (Lazy) unityAdsSDK$fetchToken$1.L$2;
                    lazy3 = (Lazy) unityAdsSDK$fetchToken$1.L$1;
                    String str6 = (String) unityAdsSDK$fetchToken$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        objectRef = objectRef4;
                        str3 = str6;
                    } catch (Exception e2) {
                        e = e2;
                        objectRef = objectRef4;
                        str3 = str6;
                        objectRef2.element = "uncaught_exception";
                        objectRef.element = ExceptionExtensionsKt.retrieveUnityCrashValue(e);
                        m2209markNowz9LOYto = j;
                        str2 = null;
                        Lazy lazy62 = lazy3;
                        lazy2 = lazy4;
                        lazy = lazy62;
                        SendDiagnosticEvent fetchToken$lambda$1022 = fetchToken$lambda$10(lazy2);
                        String str522 = str2 != null ? "native_gateway_token_failure_time" : "native_gateway_token_success_time";
                        Double boxDouble22 = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m2210boximpl(m2209markNowz9LOYto)));
                        Map createMapBuilder22 = MapsKt.createMapBuilder();
                        createMapBuilder22.put("sync", str3);
                        createMapBuilder22.put("state", fetchToken$lambda$9(lazy).invoke().toString());
                        if (((String) objectRef2.element) != null) {
                        }
                        if (((String) objectRef.element) != null) {
                        }
                        Unit unit22 = Unit.INSTANCE;
                        SendDiagnosticEvent.DefaultImpls.invoke$default(fetchToken$lambda$1022, str522, boxDouble22, MapsKt.build(createMapBuilder22), null, null, 24, null);
                        return str2;
                    }
                }
                str2 = (String) obj;
                m2209markNowz9LOYto = j;
                Lazy lazy622 = lazy3;
                lazy2 = lazy4;
                lazy = lazy622;
                SendDiagnosticEvent fetchToken$lambda$10222 = fetchToken$lambda$10(lazy2);
                String str5222 = str2 != null ? "native_gateway_token_failure_time" : "native_gateway_token_success_time";
                Double boxDouble222 = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m2210boximpl(m2209markNowz9LOYto)));
                Map createMapBuilder222 = MapsKt.createMapBuilder();
                createMapBuilder222.put("sync", str3);
                createMapBuilder222.put("state", fetchToken$lambda$9(lazy).invoke().toString());
                if (((String) objectRef2.element) != null) {
                }
                if (((String) objectRef.element) != null) {
                }
                Unit unit222 = Unit.INSTANCE;
                SendDiagnosticEvent.DefaultImpls.invoke$default(fetchToken$lambda$10222, str5222, boxDouble222, MapsKt.build(createMapBuilder222), null, null, 24, null);
                return str2;
            }
        }
        unityAdsSDK$fetchToken$1 = new UnityAdsSDK$fetchToken$1(this, continuation);
        Object obj2 = unityAdsSDK$fetchToken$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = unityAdsSDK$fetchToken$1.label;
        if (i != 0) {
        }
        str2 = (String) obj2;
        m2209markNowz9LOYto = j;
        Lazy lazy6222 = lazy3;
        lazy2 = lazy4;
        lazy = lazy6222;
        SendDiagnosticEvent fetchToken$lambda$102222 = fetchToken$lambda$10(lazy2);
        String str52222 = str2 != null ? "native_gateway_token_failure_time" : "native_gateway_token_success_time";
        Double boxDouble2222 = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m2210boximpl(m2209markNowz9LOYto)));
        Map createMapBuilder2222 = MapsKt.createMapBuilder();
        createMapBuilder2222.put("sync", str3);
        createMapBuilder2222.put("state", fetchToken$lambda$9(lazy).invoke().toString());
        if (((String) objectRef2.element) != null) {
        }
        if (((String) objectRef.element) != null) {
        }
        Unit unit2222 = Unit.INSTANCE;
        SendDiagnosticEvent.DefaultImpls.invoke$default(fetchToken$lambda$102222, str52222, boxDouble2222, MapsKt.build(createMapBuilder2222), null, null, 24, null);
        return str2;
    }

    private static final GetHeaderBiddingToken fetchToken$lambda$8(Lazy<? extends GetHeaderBiddingToken> lazy) {
        return lazy.getValue();
    }

    private static final GetInitializationState fetchToken$lambda$9(Lazy<? extends GetInitializationState> lazy) {
        return lazy.getValue();
    }

    private static final SendDiagnosticEvent fetchToken$lambda$10(Lazy<? extends SendDiagnosticEvent> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GetAdObject finishOMIDSession$lambda$14(Lazy<? extends GetAdObject> lazy) {
        return lazy.getValue();
    }

    public final Job finishOMIDSession(String opportunityId) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(opportunityId, "opportunityId");
        final UnityAdsSDK unityAdsSDK = this;
        final String str = "";
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GetAdObject>() { // from class: com.unity3d.services.UnityAdsSDK$finishOMIDSession$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.GetAdObject, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GetAdObject invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(GetAdObject.class));
            }
        });
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<OmFinishSession>() { // from class: com.unity3d.services.UnityAdsSDK$finishOMIDSession$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.domain.om.OmFinishSession, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final OmFinishSession invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(OmFinishSession.class));
            }
        });
        Lazy lazy3 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<AlternativeFlowReader>() { // from class: com.unity3d.services.UnityAdsSDK$finishOMIDSession$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.ads.core.configuration.AlternativeFlowReader, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AlternativeFlowReader invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class));
            }
        });
        CoroutineScope coroutineScope = (CoroutineScope) unityAdsSDK.getServiceProvider().getRegistry().getService(ServiceProvider.NAMED_OMID_SCOPE, Reflection.getOrCreateKotlinClass(CoroutineScope.class));
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new UnityAdsSDK$finishOMIDSession$1(opportunityId, coroutineScope, lazy3, lazy, lazy2, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OmFinishSession finishOMIDSession$lambda$15(Lazy<? extends OmFinishSession> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AlternativeFlowReader finishOMIDSession$lambda$16(Lazy<AlternativeFlowReader> lazy) {
        return lazy.getValue();
    }
}

// ===== FILE: com/unity3d/services/UnityServices.java =====
package com.unity3d.services;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.core.configuration.EnvironmentCheck;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.lifecycle.CachedLifecycle;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.properties.Session;
import com.unity3d.services.core.request.metrics.InitMetric;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UnityServices.kt */
@Metadata(m443d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002J.\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007R*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\f\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, m444d2 = {"Lcom/unity3d/services/UnityServices;", "", "()V", "debugMode", "", "getDebugMode$annotations", "getDebugMode", "()Z", "setDebugMode", "(Z)V", "isInitialized", "isInitialized$annotations", "isSupported", "isSupported$annotations", "version", "", "getVersion$annotations", MobileAdsBridge.versionMethodName, "()Ljava/lang/String;", "createExpectedParametersString", "fieldName", "current", "received", MobileAdsBridgeBase.initializeMethodName, "", "context", "Landroid/content/Context;", AndroidGetAdPlayerContext.KEY_GAME_ID, "testMode", "initializationListener", "Lcom/unity3d/ads/IUnityAdsInitializationListener;", "UnityServicesError", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class UnityServices {
    public static final UnityServices INSTANCE = new UnityServices();
    private static final boolean isSupported = true;

    /* compiled from: UnityServices.kt */
    @Metadata(m443d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m444d2 = {"Lcom/unity3d/services/UnityServices$UnityServicesError;", "", "(Ljava/lang/String;I)V", "INVALID_ARGUMENT", "INIT_SANITY_CHECK_FAIL", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public enum UnityServicesError {
        INVALID_ARGUMENT,
        INIT_SANITY_CHECK_FAIL
    }

    /* compiled from: UnityServices.kt */
    @Metadata(m445k = 3, m446mv = {1, 8, 0}, m448xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SdkProperties.InitializationState.values().length];
            try {
                iArr[SdkProperties.InitializationState.INITIALIZED_SUCCESSFULLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SdkProperties.InitializationState.INITIALIZED_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SdkProperties.InitializationState.INITIALIZING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static /* synthetic */ void getDebugMode$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getVersion$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isInitialized$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isSupported$annotations() {
    }

    private UnityServices() {
    }

    @JvmStatic
    public static final void initialize(Context context, String gameId, boolean testMode, IUnityAdsInitializationListener initializationListener) {
        Integer intOrNull;
        String str;
        DeviceLog.entered();
        if (gameId == null || (intOrNull = StringsKt.toIntOrNull(gameId)) == null) {
            if (initializationListener != null) {
                initializationListener.onInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "gameId \"" + gameId + "\" should be a number.");
                return;
            }
            return;
        }
        intOrNull.intValue();
        if (SdkProperties.getCurrentInitializationState() != SdkProperties.InitializationState.NOT_INITIALIZED) {
            String gameId2 = ClientProperties.getGameId();
            boolean isTestMode = SdkProperties.isTestMode();
            StringBuilder sb = new StringBuilder();
            if (gameId2 != null && !Intrinsics.areEqual(gameId2, gameId)) {
                InitializeEventsMetricSender.getInstance().sendMetric(InitMetric.newInitGameIdChanged(gameId2, gameId));
                sb.append(INSTANCE.createExpectedParametersString("Game ID", gameId2, gameId));
                Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
                sb.append('\n');
                Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
            } else {
                InitializeEventsMetricSender.getInstance().sendMetric(InitMetric.newInitGameIdSame(gameId2, gameId));
            }
            if (isTestMode != testMode) {
                InitializeEventsMetricSender.getInstance().sendMetric(InitMetric.newInitTestModeChanged(Boolean.valueOf(isTestMode), Boolean.valueOf(testMode)));
                sb.append(INSTANCE.createExpectedParametersString("Test Mode", Boolean.valueOf(isTestMode), Boolean.valueOf(testMode)));
                Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
                sb.append('\n');
                Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
            } else {
                InitializeEventsMetricSender.getInstance().sendMetric(InitMetric.newInitTestModeSame(Boolean.valueOf(isTestMode), Boolean.valueOf(testMode)));
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            if (sb2.length() > 0) {
                str = "different parameters: \n" + sb2;
            } else {
                str = "the same Game ID: " + gameId + " and Test Mode: " + testMode + " values.";
            }
            DeviceLog.warning("Unity Ads SDK initialize has already been called with " + str + " Responding with first initialization result.");
        }
        SdkProperties.addInitializationListener(initializationListener);
        SdkProperties.InitializationState currentInitializationState = SdkProperties.getCurrentInitializationState();
        int i = currentInitializationState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[currentInitializationState.ordinal()];
        if (i == 1) {
            SdkProperties.notifyInitializationComplete();
            return;
        }
        if (i != 2) {
            if (i == 3) {
                return;
            } else {
                SdkProperties.setInitializeState(SdkProperties.InitializationState.INITIALIZING);
            }
        } else {
            if (!UnityAdsSDK.INSTANCE.isAlternativeFlowEnabled()) {
                SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to previous failed reason");
                return;
            }
            SdkProperties.setInitializeState(SdkProperties.InitializationState.INITIALIZING);
        }
        ClientProperties.setGameId(gameId);
        SdkProperties.setTestMode(testMode);
        if (!isSupported) {
            DeviceLog.error("Error while initializing Unity Services: device is not supported");
            SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to device is not supported");
            return;
        }
        SdkProperties.setInitializationTime(Device.getElapsedRealtime());
        SdkProperties.setInitializationTimeSinceEpoch(System.currentTimeMillis());
        if (gameId.length() == 0) {
            DeviceLog.error("Error while initializing Unity Services: empty game ID, halting Unity Ads init");
            SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to empty game ID");
            return;
        }
        if (context == null) {
            DeviceLog.error("Error while initializing Unity Services: null context, halting Unity Ads init");
            SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to null context");
            return;
        }
        if (context instanceof Application) {
            ClientProperties.setApplication((Application) context);
        } else if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.getApplication() != null) {
                ClientProperties.setApplication(activity.getApplication());
            } else {
                DeviceLog.error("Error while initializing Unity Services: cannot retrieve application from context, halting Unity Ads init");
                SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to inability to retrieve application from context");
                return;
            }
        } else {
            DeviceLog.error("Error while initializing Unity Services: invalid context, halting Unity Ads init");
            SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to invalid context");
            return;
        }
        DeviceLog.info("Initializing Unity Services " + SdkProperties.getVersionName() + " (" + SdkProperties.getVersionCode() + ") with game id " + gameId + " in " + (testMode ? "test mode" : "production mode") + ", session " + Session.INSTANCE.getId());
        SdkProperties.setDebugMode(SdkProperties.getDebugMode());
        if (context.getApplicationContext() != null) {
            ClientProperties.setApplicationContext(context.getApplicationContext());
            if (!EnvironmentCheck.isEnvironmentOk()) {
                DeviceLog.error("Error during Unity Services environment check, halting Unity Services init");
                SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to environment check failed");
                return;
            } else {
                DeviceLog.info("Unity Services environment check OK");
                CachedLifecycle.register();
                UnityAdsSDK.INSTANCE.initialize();
                return;
            }
        }
        DeviceLog.error("Error while initializing Unity Services: cannot retrieve application context, halting Unity Ads init");
        SdkProperties.notifyInitializationFailed(UnityAds.UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to inability to retrieve application context");
    }

    public static final boolean isSupported() {
        return isSupported;
    }

    public static final boolean isInitialized() {
        return SdkProperties.isInitialized();
    }

    public static final String getVersion() {
        String versionName = SdkProperties.getVersionName();
        Intrinsics.checkNotNullExpressionValue(versionName, "getVersionName()");
        return versionName;
    }

    public static final boolean getDebugMode() {
        return SdkProperties.getDebugMode();
    }

    public static final void setDebugMode(boolean z) {
        SdkProperties.setDebugMode(z);
    }

    private final String createExpectedParametersString(String fieldName, Object current, Object received) {
        return "- " + fieldName + " Current: " + current + " | Received: " + received;
    }
}
