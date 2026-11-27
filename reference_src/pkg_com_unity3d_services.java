// Package bundle: com.unity3d.services (39 classes)

// ============================================================
// CLASS: com.unity3d.services.SDKErrorHandler
// ============================================================
package com.unity3d.services;

public final class SDKErrorHandler {
    public static final SDKErrorHandler$Companion Companion = null;
    public static final String UNITY_PACKAGE = "com.unity3d";
    public static final String UNKNOWN_FILE = "unknown";
    private final AlternativeFlowReader alternativeFlowReader;
    private final CoroutineDispatcher ioDispatcher;
    private final CoroutineExceptionHandler$Key key;
    private final CoroutineScope scope;
    private final SDKMetricsSender sdkMetricsSender;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    static <clinit>() {
        new SDKErrorHandler$Companion(0);
        Companion = new SDKErrorHandler$Companion(..);
        return;
    }

    public SDKErrorHandler(CoroutineDispatcher p0, AlternativeFlowReader p1, SendDiagnosticEvent p2, SDKMetricsSender p3) {
        new Object();
        ioDispatcher = p0;
        alternativeFlowReader = p1;
        sendDiagnosticEvent = p2;
        sdkMetricsSender = p3;
        CoroutineScopeKt.CoroutineScope(p0);
        new CoroutineName("SDKErrorHandler");
        CoroutineScopeKt.plus(CoroutineScopeKt.CoroutineScope(..), new CoroutineName(..));
        scope = CoroutineScopeKt.plus(..);
        key = CoroutineExceptionHandler.Key;
        return;
    }

    public static final SendDiagnosticEvent access$getSendDiagnosticEvent$p(SDKErrorHandler p0) {
        return sendDiagnosticEvent;
    }

    private final String getShortenedStackTrace(Throwable p0, int p1) {
        new StringWriter();
        new PrintWriter(new StringWriter(..));
        p0.printStackTrace(new PrintWriter(..));
        new StringWriter(..).toString();
        StringsKt.trim(StringWriter.toString(..));
        StringsKt.trim(..).toString();
        StringsKt.lineSequence(Object.toString(..));
        SequencesKt.take(StringsKt.lineSequence(..), p1);
        SequencesKt.joinToString$default(SequencesKt.take(..), "\n", 0, 0, 0, 0, 0, 62, 0);
        return SequencesKt.joinToString$default(..);
        return "";
    }

    private final String retrieveCoroutineName(CoroutineContext p0) {
        p0.get(CoroutineName.Key);
        if (if-eqz(CoroutineContext.get(..))) goto L_12;
        CoroutineContext.get(..).getName();
        if (if-nez(CoroutineName.getName(..))) goto L_14;
      L_12:
      L_14:
        return "unknown";
    }

    private final void sendDiagnostic(String p0, String p1, String p2, String p3) {
        new SDKErrorHandler$sendDiagnostic$1(this, p0, p1, p3, p2, 0);
        BuildersKt.launch$default(scope, 0, 0, new SDKErrorHandler$sendDiagnostic$1, 3, 0);
        return;
    }

    private final void sendMetric(Metric p0) {
        sdkMetricsSender.sendMetric(p0);
        return;
    }

    public Object fold(Object p0, Function2 p1) {
        CoroutineExceptionHandler$DefaultImpls.fold(this, p0, p1);
        return CoroutineExceptionHandler$DefaultImpls.fold(..);
    }

    public CoroutineContext$Element get(CoroutineContext$Key p0) {
        CoroutineExceptionHandler$DefaultImpls.get(this, p0);
        return CoroutineExceptionHandler$DefaultImpls.get(..);
    }

    public CoroutineContext$Key getKey() {
        SDKErrorHandler.getKey();
        return SDKErrorHandler.getKey(..);
    }

    public CoroutineExceptionHandler$Key getKey() {
        return key;
    }

    public void handleException(CoroutineContext p0, Throwable p1) {
        SDKErrorHandler.retrieveCoroutineName(p0);
        if (if-eqz("exception")) goto L_16;
      L_14:
      L_16:
        if (if-eqz("native_exception_npe")) goto L_1d;
      L_1d:
        if (if-eqz("native_exception_oom")) goto L_24;
      L_24:
        if (if-eqz("native_exception_ise")) goto L_2b;
      L_2b:
        if (if-eqz("native_exception_se")) goto L_32;
      L_32:
      L_35:
        alternativeFlowReader.invoke();
        ExceptionExtensionsKt.retrieveUnityCrashValue(p1);
        new StringBuilder("Unity Ads SDK encountered an exception: ");
        new StringBuilder(..).append(ExceptionExtensionsKt.retrieveUnityCrashValue(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
        if (if-eqz(AlternativeFlowReader.invoke(..))) goto L_5c;
        SDKErrorHandler.getShortenedStackTrace(p1, 15);
        SDKErrorHandler.sendDiagnostic("native_exception_npe", ExceptionExtensionsKt.retrieveUnityCrashValue(..), SDKErrorHandler.retrieveCoroutineName(..), SDKErrorHandler.getShortenedStackTrace(..));
      L_5c:
        new Metric("native_exception_npe", ExceptionExtensionsKt.retrieveUnityCrashValue(..), 0, 4, 0);
        SDKErrorHandler.sendMetric(new Metric);
      L_68:
        return;
    }

    public CoroutineContext minusKey(CoroutineContext$Key p0) {
        CoroutineExceptionHandler$DefaultImpls.minusKey(this, p0);
        return CoroutineExceptionHandler$DefaultImpls.minusKey(..);
    }

    public CoroutineContext plus(CoroutineContext p0) {
        CoroutineExceptionHandler$DefaultImpls.plus(this, p0);
        return CoroutineExceptionHandler$DefaultImpls.plus(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsConstants
// ============================================================
package com.unity3d.services;

public final class UnityAdsConstants {
    public static final UnityAdsConstants INSTANCE;

    static <clinit>() {
        new UnityAdsConstants();
        INSTANCE = new UnityAdsConstants(..);
        return;
    }

    private UnityAdsConstants() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK {
    public static final UnityAdsSDK INSTANCE;

    static <clinit>() {
        new UnityAdsSDK();
        INSTANCE = new UnityAdsSDK(..);
        return;
    }

    private UnityAdsSDK() {
        new Object();
        return;
    }

    public static final Object access$fetchToken(UnityAdsSDK p0, String p1, Continuation p2) {
        p0.fetchToken(p1, p2);
        return UnityAdsSDK.fetchToken(..);
    }

    public static final GetAdObject access$finishOMIDSession$lambda$14(Lazy p0) {
        UnityAdsSDK.finishOMIDSession$lambda$14(p0);
        return UnityAdsSDK.finishOMIDSession$lambda$14(..);
    }

    public static final OmFinishSession access$finishOMIDSession$lambda$15(Lazy p0) {
        UnityAdsSDK.finishOMIDSession$lambda$15(p0);
        return UnityAdsSDK.finishOMIDSession$lambda$15(..);
    }

    public static final AlternativeFlowReader access$finishOMIDSession$lambda$16(Lazy p0) {
        UnityAdsSDK.finishOMIDSession$lambda$16(p0);
        return UnityAdsSDK.finishOMIDSession$lambda$16(..);
    }

    public static final GetAsyncHeaderBiddingToken access$getToken$lambda$7(Lazy p0) {
        UnityAdsSDK.getToken$lambda$7(p0);
        return UnityAdsSDK.getToken$lambda$7(..);
    }

    public static final AlternativeFlowReader access$initialize$lambda$0(Lazy p0) {
        UnityAdsSDK.initialize$lambda$0(p0);
        return UnityAdsSDK.initialize$lambda$0(..);
    }

    public static final InitializeSDK access$initialize$lambda$2(Lazy p0) {
        UnityAdsSDK.initialize$lambda$2(p0);
        return UnityAdsSDK.initialize$lambda$2(..);
    }

    public static final InitializeBoldSDK access$initialize$lambda$3(Lazy p0) {
        UnityAdsSDK.initialize$lambda$3(p0);
        return UnityAdsSDK.initialize$lambda$3(..);
    }

    public static final Context access$load$lambda$5(Lazy p0) {
        UnityAdsSDK.load$lambda$5(p0);
        return UnityAdsSDK.load$lambda$5(..);
    }

    public static final Context access$show$lambda$6(Lazy p0) {
        UnityAdsSDK.show$lambda$6(p0);
        return UnityAdsSDK.show$lambda$6(..);
    }

    private final Object fetchToken(String p0, Continuation p1) {
        if (if-eqz(v3)) goto L_1a;
        if (if-eqz(label)) goto L_1a;
        label = label;
      L_1a:
        new UnityAdsSDK$fetchToken$1(this, label);
      L_1f:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_5a;
        if (if-ne(label, 1)) goto L_52;
        ResultKt.throwOnFailure(result);
      L_52:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_5a:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        new UnityAdsSDK$fetchToken$$inlined$inject$default$1(this, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$fetchToken$$inlined$inject$default$1(..));
        new UnityAdsSDK$fetchToken$$inlined$inject$default$2(this, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$fetchToken$$inlined$inject$default$2(..));
        new UnityAdsSDK$fetchToken$$inlined$inject$default$3(this, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$fetchToken$$inlined$inject$default$3(..));
        TimeSource$Monotonic.INSTANCE.markNow-z9LOYto();
        UnityAdsSDK.fetchToken$lambda$10(LazyKt.lazy(..));
        TuplesKt.to("sync", "call to 'resume' before 'invoke' with coroutine");
        UnityAdsSDK.fetchToken$lambda$9(LazyKt.lazy(..));
        UnityAdsSDK.fetchToken$lambda$9(..).invoke();
        GetInitializationState.invoke(..).toString();
        TuplesKt.to("state", InitializationState.toString(..));
        MapsKt.mapOf(2);
        SendDiagnosticEvent$DefaultImpls.invoke$default(UnityAdsSDK.fetchToken$lambda$10(..), "native_gateway_token_started", 0, MapsKt.mapOf(..), 0, 0, 26, 0);
        new Ref$ObjectRef();
        new Ref$ObjectRef();
        UnityAdsSDK.fetchToken$lambda$9(LazyKt.lazy(..));
        UnityAdsSDK.fetchToken$lambda$9(..).invoke();
        if (if-eq(GetInitializationState.invoke(..), InitializationState.INITIALIZED)) goto L_e0;
        element = "not_initialized";
      L_e0:
        UnityAdsSDK.fetchToken$lambda$8(LazyKt.lazy(..));
        L$0 = "call to 'resume' before 'invoke' with coroutine";
        L$1 = LazyKt.lazy(..);
        L$2 = LazyKt.lazy(..);
        L$3 = 0;
        L$4 = new Ref$ObjectRef(..);
        J$0 = TimeSource$Monotonic.markNow-z9LOYto(..);
        label = new Ref$ObjectRef(..);
        UnityAdsSDK.fetchToken$lambda$8(..).invoke(L$0);
        if (if-ne(GetHeaderBiddingToken.invoke(..), J$0)) goto L_f9;
        return J$0;
      L_f9:
      L_100:
      L_10f:
        element = "uncaught_exception";
        ExceptionExtensionsKt.retrieveUnityCrashValue(GetHeaderBiddingToken.invoke(..));
        element = ExceptionExtensionsKt.retrieveUnityCrashValue(..);
      L_11d:
      L_122:
        UnityAdsSDK.fetchToken$lambda$10(LazyKt.lazy(..));
        if (if-nez(0)) goto L_12b;
      L_12b:
      L_12d:
        TimeSource$Monotonic$ValueTimeMark.box-impl(TimeSource$Monotonic.markNow-z9LOYto(..), new UnityAdsSDK$fetchToken$$inlined$inject$default$3(..));
        TimeExtensionsKt.elapsedMillis(TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), TimeSource$Monotonic.markNow-z9LOYto(..));
        MapsKt.createMapBuilder();
        MapsKt.createMapBuilder(..).put("sync", "call to 'resume' before 'invoke' with coroutine");
        UnityAdsSDK.fetchToken$lambda$9(LazyKt.lazy(..));
        UnityAdsSDK.fetchToken$lambda$9(..).invoke();
        GetInitializationState.invoke(..).toString();
        MapsKt.createMapBuilder(..).put("state", InitializationState.toString(..));
        if (if-eqz(element)) goto L_161;
        MapsKt.createMapBuilder(..).put("reason", element);
      L_161:
        if (if-eqz(element)) goto L_16e;
        MapsKt.createMapBuilder(..).put("reason_debug", element);
      L_16e:
        MapsKt.build(MapsKt.createMapBuilder(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default(UnityAdsSDK.fetchToken$lambda$10(..), "native_gateway_token_success_time", Boxing.boxDouble(..), MapsKt.build(..), 0, 0, 24, 0);
        return 0;
    }

    private static final SendDiagnosticEvent fetchToken$lambda$10(Lazy p0) {
        p0.getValue();
        return Lazy.getValue(..);
    }

    private static final GetHeaderBiddingToken fetchToken$lambda$8(Lazy p0) {
        p0.getValue();
        return Lazy.getValue(..);
    }

    private static final GetInitializationState fetchToken$lambda$9(Lazy p0) {
        p0.getValue();
        return Lazy.getValue(..);
    }

    private static final GetAdObject finishOMIDSession$lambda$14(Lazy p0) {
        p0.getValue();
        return Lazy.getValue(..);
    }

    private static final OmFinishSession finishOMIDSession$lambda$15(Lazy p0) {
        p0.getValue();
        return Lazy.getValue(..);
    }

    private static final AlternativeFlowReader finishOMIDSession$lambda$16(Lazy p0) {
        p0.getValue();
        return Lazy.getValue(..);
    }

    private static final GetAsyncHeaderBiddingToken getToken$lambda$7(Lazy p0) {
        p0.getValue();
        return Lazy.getValue(..);
    }

    private static final AlternativeFlowReader initialize$lambda$0(Lazy p0) {
        p0.getValue();
        return Lazy.getValue(..);
    }

    private static final SetInitializationState initialize$lambda$1(Lazy p0) {
        p0.getValue();
        return Lazy.getValue(..);
    }

    private static final InitializeSDK initialize$lambda$2(Lazy p0) {
        p0.getValue();
        return Lazy.getValue(..);
    }

    private static final InitializeBoldSDK initialize$lambda$3(Lazy p0) {
        p0.getValue();
        return Lazy.getValue(..);
    }

    private static final AlternativeFlowReader isAlternativeFlowEnabled$lambda$4(Lazy p0) {
        p0.getValue();
        return Lazy.getValue(..);
    }

    public static Job load$default(UnityAdsSDK p0, String p1, UnityAdsLoadOptions p2, IUnityAdsLoadListener p3, UnityBannerSize p4, int p5, Object p6) {
        if (if-eqz(p5)) goto L_5;
      L_5:
        p0.load(p1, p2, p3, 0);
        return UnityAdsSDK.load(..);
    }

    private static final Context load$lambda$5(Lazy p0) {
        p0.getValue();
        return Lazy.getValue(..);
    }

    private static final Context show$lambda$6(Lazy p0) {
        p0.getValue();
        return Lazy.getValue(..);
    }

    public final Job finishOMIDSession(String p0) {
        new UnityAdsSDK$finishOMIDSession$$inlined$inject$default$1(this, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$finishOMIDSession$$inlined$inject$default$1(..));
        new UnityAdsSDK$finishOMIDSession$$inlined$inject$default$2(this, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$finishOMIDSession$$inlined$inject$default$2(..));
        new UnityAdsSDK$finishOMIDSession$$inlined$inject$default$3(this, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$finishOMIDSession$$inlined$inject$default$3(..));
        IServiceComponent.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(CoroutineScope.class);
        IServiceProvider.getRegistry(..).getService("omid_scope", Reflection.getOrCreateKotlinClass(..));
        new UnityAdsSDK$finishOMIDSession$1(p0, IServicesRegistry.getService(..), LazyKt.lazy(..), LazyKt.lazy(..), LazyKt.lazy(..), 0);
        BuildersKt.launch$default(IServicesRegistry.getService(..), 0, 0, new UnityAdsSDK$finishOMIDSession$1, 3, 0);
        return BuildersKt.launch$default(..);
    }

    public IServiceProvider getServiceProvider() {
        IServiceComponent$DefaultImpls.getServiceProvider(this);
        return IServiceComponent$DefaultImpls.getServiceProvider(..);
    }

    public final String getToken() {
        new UnityAdsSDK$getToken$1(0);
        BuildersKt.runBlocking$default(0, new UnityAdsSDK$getToken$1(..), 1, 0);
        return BuildersKt.runBlocking$default(..);
    }

    public final Job getToken(IUnityAdsTokenListener p0) {
        new UnityAdsSDK$getToken$$inlined$inject$default$1(this, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$getToken$$inlined$inject$default$1(..));
        IServiceComponent.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(CoroutineScope.class);
        IServiceProvider.getRegistry(..).getService("get_token_scope", Reflection.getOrCreateKotlinClass(..));
        new UnityAdsSDK$getToken$2(p0, IServicesRegistry.getService(..), LazyKt.lazy(..), 0);
        BuildersKt.launch$default(IServicesRegistry.getService(..), 0, 0, new UnityAdsSDK$getToken$2(..), 3, 0);
        return BuildersKt.launch$default(..);
    }

    public final Job initialize() {
        new UnityAdsSDK$initialize$$inlined$inject$default$1(this, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$initialize$$inlined$inject$default$1(..));
        new UnityAdsSDK$initialize$$inlined$inject$default$2(this, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$initialize$$inlined$inject$default$2(..));
        new UnityAdsSDK$initialize$$inlined$inject$default$3(this, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$initialize$$inlined$inject$default$3(..));
        new UnityAdsSDK$initialize$$inlined$inject$default$4(this, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$initialize$$inlined$inject$default$4(..));
        UnityAdsSDK.initialize$lambda$1(LazyKt.lazy(..));
        UnityAdsSDK.initialize$lambda$1(..).invoke(InitializationState.INITIALIZING);
        IServiceComponent.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(CoroutineScope.class);
        IServiceProvider.getRegistry(..).getService("init_scope", Reflection.getOrCreateKotlinClass(..));
        new UnityAdsSDK$initialize$1(IServicesRegistry.getService(..), LazyKt.lazy(..), LazyKt.lazy(..), LazyKt.lazy(..), 0);
        BuildersKt.launch$default(IServicesRegistry.getService(..), 0, 0, new UnityAdsSDK$initialize$1, 3, 0);
        return BuildersKt.launch$default(..);
    }

    public final boolean isAlternativeFlowEnabled() {
        new UnityAdsSDK$isAlternativeFlowEnabled$$inlined$inject$default$1(this, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$isAlternativeFlowEnabled$$inlined$inject$default$1(..));
        UnityAdsSDK.isAlternativeFlowEnabled$lambda$4(LazyKt.lazy(..));
        AlternativeFlowReader.invoke();
        return AlternativeFlowReader.invoke(..);
    }

    public final Job load(String p0, UnityAdsLoadOptions p1, IUnityAdsLoadListener p2, UnityBannerSize p3) {
        IServiceComponent.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(CoroutineScope.class);
        IServiceProvider.getRegistry(..).getService("load_scope", Reflection.getOrCreateKotlinClass(..));
        new UnityAdsSDK$load$$inlined$inject$default$1(this, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$load$$inlined$inject$default$1(..));
        new UnityAdsSDK$load$1(p0, p1, p2, p3, IServicesRegistry.getService(..), LazyKt.lazy(..), 0);
        BuildersKt.launch$default(IServicesRegistry.getService(..), 0, 0, new UnityAdsSDK$load$1, 3, 0);
        return BuildersKt.launch$default(..);
    }

    public final Job show(String p0, UnityAdsShowOptions p1, Listeners p2) {
        IServiceComponent.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(CoroutineScope.class);
        IServiceProvider.getRegistry(..).getService("show_scope", Reflection.getOrCreateKotlinClass(..));
        IServiceComponent.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(LegacyShowUseCase.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        new UnityAdsSDK$show$$inlined$inject$default$1(this, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$show$$inlined$inject$default$1(..));
        new UnityAdsSDK$show$1(IServicesRegistry.getService(..), p0, p1, p2, IServicesRegistry.getService(..), LazyKt.lazy(..), 0);
        BuildersKt.launch$default(IServicesRegistry.getService(..), 0, 0, new UnityAdsSDK$show$1, 3, 0);
        return BuildersKt.launch$default(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityServices
// ============================================================
package com.unity3d.services;

public final class UnityServices {
    public static final UnityServices INSTANCE;
    private static final boolean isSupported;

    static <clinit>() {
        new UnityServices();
        INSTANCE = new UnityServices(..);
        isSupported = 1;
        return;
    }

    private UnityServices() {
        new Object();
        return;
    }

    private final String createExpectedParametersString(String p0, Object p1, Object p2) {
        new StringBuilder("- ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" Current: ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(" | Received: ");
        new StringBuilder(..).append(p2);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    public static final boolean getDebugMode() {
        SdkProperties.getDebugMode();
        return SdkProperties.getDebugMode(..);
    }

    public static void getDebugMode$annotations() {
        return;
    }

    public static final String getVersion() {
        SdkProperties.getVersionName();
        return SdkProperties.getVersionName(..);
    }

    public static void getVersion$annotations() {
        return;
    }

    public static final void initialize(Context p0, String p1, boolean p2, IUnityAdsInitializationListener p3) {
        DeviceLog.entered();
        if (if-eqz(p1)) goto L_243;
        StringsKt.toIntOrNull(p1);
        if (if-eqz(StringsKt.toIntOrNull(..))) goto L_243;
        StringsKt.toIntOrNull(..).intValue();
        SdkProperties.getCurrentInitializationState();
        if (if-eq(SdkProperties.getCurrentInitializationState(..), SdkProperties$InitializationState.NOT_INITIALIZED)) goto L_fa;
        ClientProperties.getGameId();
        SdkProperties.isTestMode();
        new StringBuilder();
        if (if-eqz(ClientProperties.getGameId(..))) goto L_53;
        Intrinsics.areEqual(ClientProperties.getGameId(..), p1);
        if (if-nez(Intrinsics.areEqual(..))) goto L_53;
        InitializeEventsMetricSender.getInstance();
        InitMetric.newInitGameIdChanged(ClientProperties.getGameId(..), p1);
        IInitializeEventsMetricSender.sendMetric(InitMetric.newInitGameIdChanged(..));
        UnityServices.INSTANCE.createExpectedParametersString("Game ID", ClientProperties.getGameId(..), p1);
        new StringBuilder(..).append(UnityServices.createExpectedParametersString(..));
        new StringBuilder(..).append(10);
      L_53:
        InitializeEventsMetricSender.getInstance();
        InitMetric.newInitGameIdSame(UnityServices.createExpectedParametersString(..), p1);
        IInitializeEventsMetricSender.sendMetric(InitMetric.newInitGameIdSame(..));
      L_5e:
        if (if-eq(SdkProperties.isTestMode(..), p2)) goto L_90;
        InitializeEventsMetricSender.getInstance();
        Boolean.valueOf(SdkProperties.isTestMode(..));
        Boolean.valueOf(p2);
        InitMetric.newInitTestModeChanged(Boolean.valueOf(..), Boolean.valueOf(..));
        IInitializeEventsMetricSender.sendMetric(InitMetric.newInitTestModeChanged(..));
        Boolean.valueOf(SdkProperties.isTestMode(..));
        Boolean.valueOf(p2);
        UnityServices.INSTANCE.createExpectedParametersString("Test Mode", Boolean.valueOf(..), Boolean.valueOf(..));
        new StringBuilder(..).append(UnityServices.createExpectedParametersString(..));
        new StringBuilder(..).append(10);
      L_90:
        InitializeEventsMetricSender.getInstance();
        Boolean.valueOf(Boolean.valueOf(..));
        Boolean.valueOf(p2);
        InitMetric.newInitTestModeSame(Boolean.valueOf(..), Boolean.valueOf(..));
        IInitializeEventsMetricSender.sendMetric(InitMetric.newInitTestModeSame(..));
      L_a3:
        new StringBuilder(..).toString();
        StringBuilder.toString(..).length();
        if (if-lez(CharSequence.length(..))) goto L_b7;
      L_b7:
      L_b8:
        if (if-eqz(0)) goto L_c9;
        new StringBuilder("different parameters: \n");
        new StringBuilder(..).append(StringBuilder.toString(..));
        new StringBuilder(..).toString();
      L_c9:
        new StringBuilder("the same Game ID: ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(" and Test Mode: ");
        new StringBuilder(..).append(p2);
        new StringBuilder(..).append(" values.");
        new StringBuilder(..).toString();
      L_e4:
        new StringBuilder("Unity Ads SDK initialize has already been called with ");
        new StringBuilder(..).append(StringBuilder.toString(..));
        new StringBuilder(..).append(" Responding with first initialization result.");
        new StringBuilder(..).toString();
        DeviceLog.warning(StringBuilder.toString(..));
      L_fa:
        SdkProperties.addInitializationListener(p3);
        SdkProperties.getCurrentInitializationState();
        if (if-nez(SdkProperties.getCurrentInitializationState(..))) goto L_105;
      L_105:
        -1.ordinal();
      L_10d:
        if (if-eq(SdkProperties$InitializationState.ordinal(..), 1)) goto L_23f;
        if (if-eq(SdkProperties$InitializationState.ordinal(..), 2)) goto L_11c;
        if (if-eq(SdkProperties$InitializationState.ordinal(..), 3)) goto L_11b;
        SdkProperties.setInitializeState(SdkProperties$InitializationState.INITIALIZING);
      L_11b:
        return;
      L_11c:
        UnityAdsSDK.INSTANCE.isAlternativeFlowEnabled();
        if (if-nez(UnityAdsSDK.isAlternativeFlowEnabled(..))) goto L_12c;
        SdkProperties.notifyInitializationFailed(UnityAds$UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to previous failed reason");
        return;
      L_12c:
        SdkProperties.setInitializeState(SdkProperties$InitializationState.INITIALIZING);
      L_131:
        ClientProperties.setGameId("Unity Ads SDK failed to initialize due to previous failed reason");
        SdkProperties.setTestMode(p2);
        if (if-nez(UnityServices.isSupported)) goto L_148;
        DeviceLog.error("Error while initializing Unity Services: device is not supported");
        SdkProperties.notifyInitializationFailed(UnityAds$UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to device is not supported");
        return;
      L_148:
        Device.getElapsedRealtime();
        SdkProperties.setInitializationTime(Device.getElapsedRealtime(..), new StringBuilder(..));
        System.currentTimeMillis();
        SdkProperties.setInitializationTimeSinceEpoch(System.currentTimeMillis(..), new StringBuilder(..));
        CharSequence.length();
        if (if-nez(CharSequence.length(..))) goto L_160;
      L_160:
        if (if-eqz(1)) goto L_16f;
        DeviceLog.error("Error while initializing Unity Services: empty game ID, halting Unity Ads init");
        SdkProperties.notifyInitializationFailed(UnityAds$UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to empty game ID");
        return;
      L_16f:
        if (if-nez(UnityAds$UnityAdsInitializationError.INVALID_ARGUMENT)) goto L_17e;
        DeviceLog.error("Error while initializing Unity Services: null context, halting Unity Ads init");
        SdkProperties.notifyInitializationFailed(UnityAds$UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to null context");
        return;
      L_17e:
        if (if-eqz(CharSequence.length(..))) goto L_189;
        ClientProperties.setApplication(UnityAds$UnityAdsInitializationError.INVALID_ARGUMENT);
      L_189:
        if (if-eqz(UnityAds$UnityAdsInitializationError.INVALID_ARGUMENT)) goto L_232;
        Activity.getApplication();
        if (if-eqz(Activity.getApplication(..))) goto L_225;
        Activity.getApplication();
        ClientProperties.setApplication(Activity.getApplication(..));
      L_19d:
        if (if-eqz(p2)) goto L_1a2;
      L_1a2:
      L_1a4:
        new StringBuilder("Initializing Unity Services ");
        SdkProperties.getVersionName();
        new StringBuilder(..).append(SdkProperties.getVersionName(..));
        new StringBuilder(..).append(" (");
        SdkProperties.getVersionCode();
        new StringBuilder(..).append(SdkProperties.getVersionCode(..));
        new StringBuilder(..).append(") with game id ");
        new StringBuilder(..).append("Unity Ads SDK failed to initialize due to null context");
        new StringBuilder(..).append(" in ");
        new StringBuilder(..).append("production mode");
        new StringBuilder(..).append(", session ");
        Session.Default.getId();
        new StringBuilder(..).append(Session$Default.getId(..));
        new StringBuilder(..).toString();
        DeviceLog.info(StringBuilder.toString(..));
        SdkProperties.getDebugMode();
        SdkProperties.setDebugMode(SdkProperties.getDebugMode(..));
        Context.getApplicationContext();
        if (if-eqz(Context.getApplicationContext(..))) goto L_218;
        Context.getApplicationContext();
        ClientProperties.setApplicationContext(Context.getApplicationContext(..));
        EnvironmentCheck.isEnvironmentOk();
        if (if-nez(EnvironmentCheck.isEnvironmentOk(..))) goto L_20a;
        DeviceLog.error("Error during Unity Services environment check, halting Unity Services init");
        SdkProperties.notifyInitializationFailed(UnityAds$UnityAdsInitializationError.INTERNAL_ERROR, "Unity Ads SDK failed to initialize due to environment check failed");
        return;
      L_20a:
        DeviceLog.info("Unity Services environment check OK");
        CachedLifecycle.register();
        UnityAdsSDK.INSTANCE.initialize();
        return;
      L_218:
        DeviceLog.error("Error while initializing Unity Services: cannot retrieve application context, halting Unity Ads init");
        SdkProperties.notifyInitializationFailed(UnityAds$UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to inability to retrieve application context");
        return;
      L_225:
        DeviceLog.error("Error while initializing Unity Services: cannot retrieve application from context, halting Unity Ads init");
        SdkProperties.notifyInitializationFailed(UnityAds$UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to inability to retrieve application from context");
        return;
      L_232:
        DeviceLog.error("Error while initializing Unity Services: invalid context, halting Unity Ads init");
        SdkProperties.notifyInitializationFailed(UnityAds$UnityAdsInitializationError.INVALID_ARGUMENT, "Unity Ads SDK failed to initialize due to invalid context");
        return;
      L_23f:
        SdkProperties.notifyInitializationComplete();
        return;
      L_243:
        if (if-eqz(new StringBuilder(..))) goto L_25d;
        new StringBuilder("gameId \"");
        new StringBuilder(..).append("Unity Ads SDK failed to initialize due to invalid context");
        new StringBuilder(..).append("\" should be a number.");
        new StringBuilder(..).toString();
        new StringBuilder(..).onInitializationFailed(UnityAds$UnityAdsInitializationError.INVALID_ARGUMENT, StringBuilder.toString(..));
      L_25d:
        return;
    }

    public static final boolean isInitialized() {
        SdkProperties.isInitialized();
        return SdkProperties.isInitialized(..);
    }

    public static void isInitialized$annotations() {
        return;
    }

    public static final boolean isSupported() {
        return UnityServices.isSupported;
    }

    public static void isSupported$annotations() {
        return;
    }

    public static final void setDebugMode(boolean p0) {
        SdkProperties.setDebugMode(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.SDKErrorHandler$Companion
// ============================================================
package com.unity3d.services;

public final class SDKErrorHandler$Companion {
    private SDKErrorHandler$Companion() {
        new Object();
        return;
    }

    public SDKErrorHandler$Companion(DefaultConstructorMarker p0) {
        new SDKErrorHandler$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.SDKErrorHandler$sendDiagnostic$1
// ============================================================
package com.unity3d.services;

final class SDKErrorHandler$sendDiagnostic$1 extends SuspendLambda {
    final String $name;
    final String $reason;
    final String $scopeName;
    final String $stackTrace;
    int label;
    final SDKErrorHandler this$0;

    SDKErrorHandler$sendDiagnostic$1(SDKErrorHandler p0, String p1, String p2, String p3, String p4, Continuation p5) {
        this$0 = p0;
        $name = p1;
        $reason = p2;
        $stackTrace = p3;
        $scopeName = p4;
        new SuspendLambda(2, p5);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new SDKErrorHandler$sendDiagnostic$1(this$0, $name, $reason, $stackTrace, $scopeName, p1);
        return new SDKErrorHandler$sendDiagnostic$1;
    }

    public Object invoke(Object p0, Object p1) {
        SDKErrorHandler$sendDiagnostic$1.invoke(p0, p1);
        return SDKErrorHandler$sendDiagnostic$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        SDKErrorHandler$sendDiagnostic$1.create(p0, p1);
        SDKErrorHandler$sendDiagnostic$1.invokeSuspend(Unit.INSTANCE);
        return SDKErrorHandler$sendDiagnostic$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_46;
        ResultKt.throwOnFailure(p0);
        SDKErrorHandler.access$getSendDiagnosticEvent$p(this$0);
        TuplesKt.to("reason", $reason);
        TuplesKt.to("reason_debug", $stackTrace);
        TuplesKt.to("coroutine_name", $scopeName);
        MapsKt.mapOf(3);
        SendDiagnosticEvent$DefaultImpls.invoke$default(SDKErrorHandler.access$getSendDiagnosticEvent$p(..), $name, 0, MapsKt.mapOf(..), 0, 0, 26, 0);
        return Unit.INSTANCE;
      L_46:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsConstants$AdOperations
// ============================================================
package com.unity3d.services;

public final class UnityAdsConstants$AdOperations {
    public static final int GET_TOKEN_TIMEOUT_MS = 2750;
    public static final UnityAdsConstants$AdOperations INSTANCE = null;
    public static final int LOAD_TIMEOUT_MS = 30000;
    public static final int SHOW_TIMEOUT_MS = 10000;

    static <clinit>() {
        new UnityAdsConstants$AdOperations();
        INSTANCE = new UnityAdsConstants$AdOperations(..);
        return;
    }

    private UnityAdsConstants$AdOperations() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsConstants$Cache
// ============================================================
package com.unity3d.services;

public final class UnityAdsConstants$Cache {
    public static final String CACHE_SCHEME = "unity-ads-cache";
    public static final String DATASTORE_PATH = "unityAdsDatastore/";
    public static final UnityAdsConstants$Cache INSTANCE;

    static <clinit>() {
        new UnityAdsConstants$Cache();
        INSTANCE = new UnityAdsConstants$Cache(..);
        return;
    }

    private UnityAdsConstants$Cache() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsConstants$ClientInfo
// ============================================================
package com.unity3d.services;

public final class UnityAdsConstants$ClientInfo {
    public static final UnityAdsConstants$ClientInfo INSTANCE = null;
    public static final int SDK_VERSION = 41205;
    public static final String SDK_VERSION_NAME = "4.12.5";

    static <clinit>() {
        new UnityAdsConstants$ClientInfo();
        INSTANCE = new UnityAdsConstants$ClientInfo(..);
        return;
    }

    private UnityAdsConstants$ClientInfo() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsConstants$DefaultUrls
// ============================================================
package com.unity3d.services;

public final class UnityAdsConstants$DefaultUrls {
    public static final String AD_ASSET_DOMAIN = "unity.ads.asset";
    public static final String AD_ASSET_PATH = "/";
    public static final String AD_CACHE_DOMAIN = "unity.ads.cache";
    public static final String AD_PLAYER_QUERY_PARAMS = "?platform=android&";
    public static final String ASSET_DOMAIN = "cdn-creatives-cf-prd.acquire.unity3dusercontent.com";
    public static final String CACHE_DIR_NAME = "UnityAdsCache";
    public static final String GATEWAY_URL = "https://gateway.unityads.unity3d.com/v1";
    public static final String HTTP_CACHE_DIR_NAME = "UnityAdsHttpCache";
    public static final UnityAdsConstants$DefaultUrls INSTANCE = null;
    public static final String WEBVIEW_ASSET_PATH = "/unity-ads-sdk-webview/";
    public static final String WEBVIEW_DOMAIN = "config.unityads.unity3d.com";

    static <clinit>() {
        new UnityAdsConstants$DefaultUrls();
        INSTANCE = new UnityAdsConstants$DefaultUrls(..);
        return;
    }

    private UnityAdsConstants$DefaultUrls() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsConstants$ErrorHandler
// ============================================================
package com.unity3d.services;

public final class UnityAdsConstants$ErrorHandler {
    public static final int ERROR_HANDLER_STACK_TRACE_LINES_MAX = 15;
    public static final UnityAdsConstants$ErrorHandler INSTANCE;

    static <clinit>() {
        new UnityAdsConstants$ErrorHandler();
        INSTANCE = new UnityAdsConstants$ErrorHandler(..);
        return;
    }

    private UnityAdsConstants$ErrorHandler() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsConstants$Messages
// ============================================================
package com.unity3d.services;

public final class UnityAdsConstants$Messages {
    public static final UnityAdsConstants$Messages INSTANCE = null;
    public static final String MSG_INTERNAL_ERROR = "Internal error";
    public static final String MSG_UNITY_BASE = "[Unity Ads] ";

    static <clinit>() {
        new UnityAdsConstants$Messages();
        INSTANCE = new UnityAdsConstants$Messages(..);
        return;
    }

    private UnityAdsConstants$Messages() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsConstants$OpenMeasurement
// ============================================================
package com.unity3d.services;

public final class UnityAdsConstants$OpenMeasurement {
    public static final UnityAdsConstants$OpenMeasurement INSTANCE = null;
    public static final String OM_JS_SERVICE_FILENAME = "ad-viewer/omsdk-v1.js";
    public static final String OM_JS_SESSION_FILENAME = "ad-viewer/omid-session-client-v1.js";
    public static final String OM_JS_URL_SERVICE = "unity-ads-cache://unity.ads.asset/ad-viewer/omsdk-v1.js";
    public static final String OM_JS_URL_SESSION = "unity-ads-cache://unity.ads.asset/ad-viewer/omid-session-client-v1.js";
    public static final String OM_PARTNER_NAME = "Unity3d";
    public static final String OM_PARTNER_VERSION = "1";
    public static final long OM_SESSION_FINISH_DELAY_MS = 1000L;

    static <clinit>() {
        new UnityAdsConstants$OpenMeasurement();
        INSTANCE = new UnityAdsConstants$OpenMeasurement(..);
        return;
    }

    private UnityAdsConstants$OpenMeasurement() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsConstants$Preferences
// ============================================================
package com.unity3d.services;

public final class UnityAdsConstants$Preferences {
    public static final UnityAdsConstants$Preferences INSTANCE = null;
    public static final String PREF_KEY_AUID = "auid";
    public static final String PREF_KEY_IDFI = "unityads-idfi";
    public static final String PREF_NAME_AUID = "supersonic_shared_preferen";
    public static final String PREF_NAME_IDFI = "unityads-installinfo";

    static <clinit>() {
        new UnityAdsConstants$Preferences();
        INSTANCE = new UnityAdsConstants$Preferences(..);
        return;
    }

    private UnityAdsConstants$Preferences() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsConstants$RequestPolicy
// ============================================================
package com.unity3d.services;

public final class UnityAdsConstants$RequestPolicy {
    public static final int CONNECT_TIMEOUT_MS = 10000;
    public static final UnityAdsConstants$RequestPolicy INSTANCE = null;
    public static final int OVERALL_TIMEOUT_MS = 20000;
    public static final int READ_TIMEOUT_MS = 10000;
    public static final float RETRY_JITTER_PCT = 0.1f;
    public static final int RETRY_MAX_DURATION = 120000;
    public static final int RETRY_MAX_INTERVAL = 1000;
    public static final float RETRY_SCALING_FACTOR = 2.0f;
    public static final int RETRY_WAIT_BASE = 500;
    public static final boolean SHOULD_STORE_LOCALLY = false;
    public static final int WRITE_TIMEOUT_MS = 10000;

    static <clinit>() {
        new UnityAdsConstants$RequestPolicy();
        INSTANCE = new UnityAdsConstants$RequestPolicy(..);
        return;
    }

    private UnityAdsConstants$RequestPolicy() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsConstants$SharedFlow
// ============================================================
package com.unity3d.services;

public final class UnityAdsConstants$SharedFlow {
    public static final int EXTRA_CAPACITY = 10;
    public static final UnityAdsConstants$SharedFlow INSTANCE = null;
    public static final int REPLAY = 10;

    static <clinit>() {
        new UnityAdsConstants$SharedFlow();
        INSTANCE = new UnityAdsConstants$SharedFlow(..);
        return;
    }

    private UnityAdsConstants$SharedFlow() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsConstants$Timeout
// ============================================================
package com.unity3d.services;

public final class UnityAdsConstants$Timeout {
    public static final long INIT_TIMEOUT_MS = 120000L;
    public static final UnityAdsConstants$Timeout INSTANCE;

    static <clinit>() {
        new UnityAdsConstants$Timeout();
        INSTANCE = new UnityAdsConstants$Timeout(..);
        return;
    }

    private UnityAdsConstants$Timeout() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$fetchToken$$inlined$inject$default$1
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK$fetchToken$$inlined$inject$default$1 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UnityAdsSDK$fetchToken$$inlined$inject$default$1(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(GetHeaderBiddingToken.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$fetchToken$$inlined$inject$default$2
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK$fetchToken$$inlined$inject$default$2 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UnityAdsSDK$fetchToken$$inlined$inject$default$2(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(GetInitializationState.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$fetchToken$$inlined$inject$default$3
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK$fetchToken$$inlined$inject$default$3 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UnityAdsSDK$fetchToken$$inlined$inject$default$3(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$fetchToken$1
// ============================================================
package com.unity3d.services;

final class UnityAdsSDK$fetchToken$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    Object result;
    final UnityAdsSDK this$0;

    UnityAdsSDK$fetchToken$1(UnityAdsSDK p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        UnityAdsSDK.access$fetchToken(this$0, 0, this);
        return UnityAdsSDK.access$fetchToken(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$finishOMIDSession$$inlined$inject$default$1
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK$finishOMIDSession$$inlined$inject$default$1 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UnityAdsSDK$finishOMIDSession$$inlined$inject$default$1(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(GetAdObject.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$finishOMIDSession$$inlined$inject$default$2
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK$finishOMIDSession$$inlined$inject$default$2 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UnityAdsSDK$finishOMIDSession$$inlined$inject$default$2(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(OmFinishSession.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$finishOMIDSession$$inlined$inject$default$3
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK$finishOMIDSession$$inlined$inject$default$3 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UnityAdsSDK$finishOMIDSession$$inlined$inject$default$3(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$finishOMIDSession$1
// ============================================================
package com.unity3d.services;

final class UnityAdsSDK$finishOMIDSession$1 extends SuspendLambda {
    final Lazy $alternativeFlowReader$delegate;
    final Lazy $getAdObject$delegate;
    final Lazy $omFinishSession$delegate;
    final CoroutineScope $omidScope;
    final String $opportunityId;
    int label;

    UnityAdsSDK$finishOMIDSession$1(String p0, CoroutineScope p1, Lazy p2, Lazy p3, Lazy p4, Continuation p5) {
        $opportunityId = p0;
        $omidScope = p1;
        $alternativeFlowReader$delegate = p2;
        $getAdObject$delegate = p3;
        $omFinishSession$delegate = p4;
        new SuspendLambda(2, p5);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new UnityAdsSDK$finishOMIDSession$1($opportunityId, $omidScope, $alternativeFlowReader$delegate, $getAdObject$delegate, $omFinishSession$delegate, p1);
        return new UnityAdsSDK$finishOMIDSession$1;
    }

    public Object invoke(Object p0, Object p1) {
        UnityAdsSDK$finishOMIDSession$1.invoke(p0, p1);
        return UnityAdsSDK$finishOMIDSession$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        UnityAdsSDK$finishOMIDSession$1.create(p0, p1);
        UnityAdsSDK$finishOMIDSession$1.invokeSuspend(Unit.INSTANCE);
        return UnityAdsSDK$finishOMIDSession$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_1e;
        if (if-eq(label, 1)) goto L_1a;
        if (if-ne(label, 2)) goto L_12;
        ResultKt.throwOnFailure(p0);
      L_12:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1a:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_1e:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        UnityAdsSDK.access$finishOMIDSession$lambda$16($alternativeFlowReader$delegate);
        AlternativeFlowReader.invoke();
        if (if-eqz(AlternativeFlowReader.invoke(..))) goto L_54;
        UnityAdsSDK.access$finishOMIDSession$lambda$14($getAdObject$delegate);
        label = 1;
        GetAdObject.invoke($opportunityId, this);
        if (if-ne(GetAdObject.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_41;
        return "call to 'resume' before 'invoke' with coroutine";
      L_41:
        if (if-eqz(GetAdObject.invoke(..))) goto L_54;
        UnityAdsSDK.access$finishOMIDSession$lambda$15($omFinishSession$delegate);
        label = 2;
        OmFinishSession.invoke(GetAdObject.invoke(..), this);
        if (if-ne(OmFinishSession.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_54;
        return "call to 'resume' before 'invoke' with coroutine";
      L_54:
        CoroutineScopeKt.cancel$default($omidScope, 0, 1, 0);
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$getToken$$inlined$inject$default$1
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK$getToken$$inlined$inject$default$1 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UnityAdsSDK$getToken$$inlined$inject$default$1(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(GetAsyncHeaderBiddingToken.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$getToken$1
// ============================================================
package com.unity3d.services;

final class UnityAdsSDK$getToken$1 extends SuspendLambda {
    int label;

    UnityAdsSDK$getToken$1(Continuation p0) {
        new SuspendLambda(2, p0);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new UnityAdsSDK$getToken$1(p1);
        return new UnityAdsSDK$getToken$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        UnityAdsSDK$getToken$1.invoke(p0, p1);
        return UnityAdsSDK$getToken$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        UnityAdsSDK$getToken$1.create(p0, p1);
        UnityAdsSDK$getToken$1.create(..).invokeSuspend(Unit.INSTANCE);
        return UnityAdsSDK$getToken$1.invokeSuspend(..);
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
        UnityAdsSDK.access$fetchToken(UnityAdsSDK.INSTANCE, "true", this);
        if (if-ne(UnityAdsSDK.access$fetchToken(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2a;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2a:
        return UnityAdsSDK.access$fetchToken(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$getToken$2
// ============================================================
package com.unity3d.services;

final class UnityAdsSDK$getToken$2 extends SuspendLambda {
    final Lazy $getAsyncHeaderBiddingToken$delegate;
    final CoroutineScope $getTokenScope;
    final IUnityAdsTokenListener $listener;
    int label;

    UnityAdsSDK$getToken$2(IUnityAdsTokenListener p0, CoroutineScope p1, Lazy p2, Continuation p3) {
        $listener = p0;
        $getTokenScope = p1;
        $getAsyncHeaderBiddingToken$delegate = p2;
        new SuspendLambda(2, p3);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new UnityAdsSDK$getToken$2($listener, $getTokenScope, $getAsyncHeaderBiddingToken$delegate, p1);
        return new UnityAdsSDK$getToken$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        UnityAdsSDK$getToken$2.invoke(p0, p1);
        return UnityAdsSDK$getToken$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        UnityAdsSDK$getToken$2.create(p0, p1);
        UnityAdsSDK$getToken$2.create(..).invokeSuspend(Unit.INSTANCE);
        return UnityAdsSDK$getToken$2.invokeSuspend(..);
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
        UnityAdsSDK.access$getToken$lambda$7($getAsyncHeaderBiddingToken$delegate);
        label = 1;
        GetAsyncHeaderBiddingToken.invoke($listener, this);
        if (if-ne(GetAsyncHeaderBiddingToken.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2e;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2e:
        CoroutineScopeKt.cancel$default($getTokenScope, 0, 1, 0);
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$initialize$$inlined$inject$default$1
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK$initialize$$inlined$inject$default$1 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UnityAdsSDK$initialize$$inlined$inject$default$1(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$initialize$$inlined$inject$default$2
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK$initialize$$inlined$inject$default$2 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UnityAdsSDK$initialize$$inlined$inject$default$2(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SetInitializationState.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$initialize$$inlined$inject$default$3
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK$initialize$$inlined$inject$default$3 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UnityAdsSDK$initialize$$inlined$inject$default$3(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(InitializeSDK.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$initialize$$inlined$inject$default$4
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK$initialize$$inlined$inject$default$4 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UnityAdsSDK$initialize$$inlined$inject$default$4(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(InitializeBoldSDK.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$initialize$1
// ============================================================
package com.unity3d.services;

final class UnityAdsSDK$initialize$1 extends SuspendLambda {
    final Lazy $alternativeFlowReader$delegate;
    final CoroutineScope $initScope;
    final Lazy $initializeBoldSDK$delegate;
    final Lazy $initializeSDK$delegate;
    int label;

    UnityAdsSDK$initialize$1(CoroutineScope p0, Lazy p1, Lazy p2, Lazy p3, Continuation p4) {
        $initScope = p0;
        $alternativeFlowReader$delegate = p1;
        $initializeBoldSDK$delegate = p2;
        $initializeSDK$delegate = p3;
        new SuspendLambda(2, p4);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new UnityAdsSDK$initialize$1($initScope, $alternativeFlowReader$delegate, $initializeBoldSDK$delegate, $initializeSDK$delegate, p1);
        return new UnityAdsSDK$initialize$1;
    }

    public Object invoke(Object p0, Object p1) {
        UnityAdsSDK$initialize$1.invoke(p0, p1);
        return UnityAdsSDK$initialize$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        UnityAdsSDK$initialize$1.create(p0, p1);
        UnityAdsSDK$initialize$1.create(..).invokeSuspend(Unit.INSTANCE);
        return UnityAdsSDK$initialize$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_23;
        if (if-eq(label, 1)) goto L_1f;
        if (if-ne(label, 2)) goto L_17;
        ResultKt.throwOnFailure(p0);
        p0.unbox-impl();
      L_17:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1f:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_23:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        UnityAdsSDK.access$initialize$lambda$0($alternativeFlowReader$delegate);
        AlternativeFlowReader.invoke();
        if (if-eqz(AlternativeFlowReader.invoke(..))) goto L_44;
        UnityAdsSDK.access$initialize$lambda$3($initializeBoldSDK$delegate);
        label = 1;
        InitializeBoldSDK.invoke(this);
        if (if-ne(InitializeBoldSDK.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_5a;
        return "call to 'resume' before 'invoke' with coroutine";
      L_44:
        UnityAdsSDK.access$initialize$lambda$2($initializeSDK$delegate);
        label = 2;
        InitializeSDK.invoke-gIAlu-s(EmptyParams.INSTANCE, this);
        if (if-ne(InitializeSDK.invoke-gIAlu-s(..), "call to 'resume' before 'invoke' with coroutine")) goto L_5a;
        return "call to 'resume' before 'invoke' with coroutine";
      L_5a:
        CoroutineScopeKt.cancel$default($initScope, 0, 1, 0);
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$isAlternativeFlowEnabled$$inlined$inject$default$1
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK$isAlternativeFlowEnabled$$inlined$inject$default$1 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UnityAdsSDK$isAlternativeFlowEnabled$$inlined$inject$default$1(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$load$$inlined$inject$default$1
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK$load$$inlined$inject$default$1 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UnityAdsSDK$load$$inlined$inject$default$1(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(Context.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$load$1
// ============================================================
package com.unity3d.services;

final class UnityAdsSDK$load$1 extends SuspendLambda {
    final UnityBannerSize $bannerSize;
    final Lazy $context$delegate;
    final IUnityAdsLoadListener $listener;
    final UnityAdsLoadOptions $loadOptions;
    final CoroutineScope $loadScope;
    final String $placementId;
    int label;

    UnityAdsSDK$load$1(String p0, UnityAdsLoadOptions p1, IUnityAdsLoadListener p2, UnityBannerSize p3, CoroutineScope p4, Lazy p5, Continuation p6) {
        $placementId = p0;
        $loadOptions = p1;
        $listener = p2;
        $bannerSize = p3;
        $loadScope = p4;
        $context$delegate = p5;
        new SuspendLambda(2, p6);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new UnityAdsSDK$load$1($placementId, $loadOptions, $listener, $bannerSize, $loadScope, $context$delegate, p1);
        return new UnityAdsSDK$load$1;
    }

    public Object invoke(Object p0, Object p1) {
        UnityAdsSDK$load$1.invoke(p0, p1);
        return UnityAdsSDK$load$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        UnityAdsSDK$load$1.create(p0, p1);
        UnityAdsSDK$load$1.create(..).invokeSuspend(Unit.INSTANCE);
        return UnityAdsSDK$load$1.invokeSuspend(..);
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
        UnityAdsSDK.INSTANCE.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(LegacyLoadUseCase.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        UnityAdsSDK.access$load$lambda$5($context$delegate);
        label = 1;
        IServicesRegistry.getService(..).invoke(UnityAdsSDK.access$load$lambda$5(..), $placementId, $loadOptions, $listener, $bannerSize, this);
        if (if-ne(LegacyLoadUseCase.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_4f;
        return "call to 'resume' before 'invoke' with coroutine";
      L_4f:
        CoroutineScopeKt.cancel$default($loadScope, 0, 1, 0);
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$show$$inlined$inject$default$1
// ============================================================
package com.unity3d.services;

public final class UnityAdsSDK$show$$inlined$inject$default$1 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public UnityAdsSDK$show$$inlined$inject$default$1(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(Context.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityAdsSDK$show$1
// ============================================================
package com.unity3d.services;

final class UnityAdsSDK$show$1 extends SuspendLambda {
    final Lazy $context$delegate;
    final Listeners $listener;
    final String $placementId;
    final LegacyShowUseCase $showBoldSDK;
    final UnityAdsShowOptions $showOptions;
    final CoroutineScope $showScope;
    int label;

    UnityAdsSDK$show$1(LegacyShowUseCase p0, String p1, UnityAdsShowOptions p2, Listeners p3, CoroutineScope p4, Lazy p5, Continuation p6) {
        $showBoldSDK = p0;
        $placementId = p1;
        $showOptions = p2;
        $listener = p3;
        $showScope = p4;
        $context$delegate = p5;
        new SuspendLambda(2, p6);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new UnityAdsSDK$show$1($showBoldSDK, $placementId, $showOptions, $listener, $showScope, $context$delegate, p1);
        return new UnityAdsSDK$show$1;
    }

    public Object invoke(Object p0, Object p1) {
        UnityAdsSDK$show$1.invoke(p0, p1);
        return UnityAdsSDK$show$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        UnityAdsSDK$show$1.create(p0, p1);
        UnityAdsSDK$show$1.create(..).invokeSuspend(Unit.INSTANCE);
        return UnityAdsSDK$show$1.invokeSuspend(..);
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
        UnityAdsSDK.access$show$lambda$6($context$delegate);
        label = 1;
        $showBoldSDK.invoke(UnityAdsSDK.access$show$lambda$6(..), $placementId, $showOptions, $listener, this);
        if (if-ne(LegacyShowUseCase.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_34;
        return "call to 'resume' before 'invoke' with coroutine";
      L_34:
        CoroutineScopeKt.cancel$default($showScope, 0, 1, 0);
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.services.UnityServices$UnityServicesError
// ============================================================
package com.unity3d.services;

public final class UnityServices$UnityServicesError extends Enum {
    private static final UnityServices$UnityServicesError[] $VALUES;
    public static final UnityServices$UnityServicesError INIT_SANITY_CHECK_FAIL;
    public static final UnityServices$UnityServicesError INVALID_ARGUMENT;

    private static final UnityServices$UnityServicesError[] $values() {
        return 2;
    }

    static <clinit>() {
        new UnityServices$UnityServicesError("INVALID_ARGUMENT", 0);
        INVALID_ARGUMENT = new UnityServices$UnityServicesError(..);
        new UnityServices$UnityServicesError("INIT_SANITY_CHECK_FAIL", 1);
        INIT_SANITY_CHECK_FAIL = new UnityServices$UnityServicesError(..);
        UnityServices$UnityServicesError.$values();
        $VALUES = UnityServices$UnityServicesError.$values(..);
        return;
    }

    private UnityServices$UnityServicesError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static UnityServices$UnityServicesError valueOf(String p0) {
        Enum.valueOf(UnityServices$UnityServicesError.class, p0);
        return Enum.valueOf(..);
    }

    public static UnityServices$UnityServicesError[] values() {
        Object[].clone();
        return Object[].clone(..);
    }

}

