// Package bundle: com.unity3d.services.ads.token (19 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.token.AsyncTokenStorage
// ============================================================
package com.unity3d.services.ads.token;

public abstract class AsyncTokenStorage {
    public abstract void getToken(IBiddingManager p0) {
        // native or abstract
    }

    public abstract void onTokenAvailable() {
        // native or abstract
    }

    public abstract void setConfiguration(Configuration p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.INativeTokenGenerator
// ============================================================
package com.unity3d.services.ads.token;

public abstract class INativeTokenGenerator {
    public abstract void generateToken(INativeTokenGeneratorListener p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.INativeTokenGeneratorListener
// ============================================================
package com.unity3d.services.ads.token;

public abstract class INativeTokenGeneratorListener {
    public abstract void onReady(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.InMemoryAsyncTokenStorage
// ============================================================
package com.unity3d.services.ads.token;

public class InMemoryAsyncTokenStorage {
    private Configuration _configuration;
    private boolean _configurationWasSet;
    private DeviceInfoReaderBuilderWithExtras _deviceInfoReaderBuilderWithExtras;
    private final Handler _handler;
    private final InitializationStatusReader _initStatusReader;
    private INativeTokenGenerator _nativeTokenGenerator;
    private final SDKMetricsSender _sdkMetrics;
    private boolean _tokenAvailable;
    private final List _tokenListeners;
    private TokenStorage _tokenStorage;

    public InMemoryAsyncTokenStorage(INativeTokenGenerator p0, Handler p1, SDKMetricsSender p2, TokenStorage p3) {
        new Object();
        new LinkedList();
        _tokenListeners = new LinkedList(..);
        _tokenAvailable = 0;
        _configurationWasSet = 0;
        new Configuration();
        _configuration = new Configuration(..);
        new InitializationStatusReader();
        _initStatusReader = new InitializationStatusReader(..);
        _handler = p1;
        _nativeTokenGenerator = p0;
        _sdkMetrics = p2;
        _tokenStorage = p3;
        return;
    }

    static void access$000(InMemoryAsyncTokenStorage p0, InMemoryAsyncTokenStorage$TokenListenerState p1, String p2) {
        p0.notifyTokenReady(p1, p2);
        return;
    }

    static Handler access$100(InMemoryAsyncTokenStorage p0) {
        return _handler;
    }

    private InMemoryAsyncTokenStorage$TokenListenerState addTimeoutHandler(IBiddingManager p0) {
        new InMemoryAsyncTokenStorage$TokenListenerState(this);
        biddingManager = p0;
        tokenType = TokenType.TOKEN_REMOTE;
        new InMemoryAsyncTokenStorage$1(this, new InMemoryAsyncTokenStorage$TokenListenerState(..));
        runnable = new InMemoryAsyncTokenStorage$1(..);
        _tokenListeners.add(new InMemoryAsyncTokenStorage$TokenListenerState(..));
        _configuration.getTokenTimeout();
        _handler.postDelayed(runnable, Configuration.getTokenTimeout(..), v3);
        return new InMemoryAsyncTokenStorage$TokenListenerState(..);
        throw _handler;
    }

    private Map getMetricTags() {
        new HashMap();
        SdkProperties.getCurrentInitializationState();
        _initStatusReader.getInitializationStateString(SdkProperties.getCurrentInitializationState(..));
        new HashMap(..).put("state", InitializationStatusReader.getInitializationStateString(..));
        return new HashMap(..);
    }

    private void handleTokenInvocation(InMemoryAsyncTokenStorage$TokenListenerState p0) {
        if (if-eqz(invoked)) goto L_5;
        return;
      L_5:
        invoked = 1;
        if (if-nez(_tokenAvailable)) goto L_3e;
        tokenType = TokenType.TOKEN_NATIVE;
        GMA.getInstance();
        GMA.getInstance(..).hasSCARBiddingSupport();
        if (if-eqz(GMA.hasSCARBiddingSupport(..))) goto L_33;
        if (if-eqz(_deviceInfoReaderBuilderWithExtras)) goto L_33;
        new HashMap();
        biddingManager.getTokenIdentifier();
        new HashMap(..).put("tid", IBiddingManager.getTokenIdentifier(..));
        _deviceInfoReaderBuilderWithExtras.setExtras(new HashMap(..));
      L_33:
        new InMemoryAsyncTokenStorage$2(this, p0);
        _nativeTokenGenerator.generateToken(new InMemoryAsyncTokenStorage$2(..));
      L_3e:
        tokenType = TokenType.TOKEN_REMOTE;
        _tokenStorage.getToken();
        if (if-eqz(TokenStorage.getToken(..))) goto L_54;
        TokenStorage.getToken(..).isEmpty();
        if (if-eqz(String.isEmpty(..))) goto L_51;
      L_51:
        InMemoryAsyncTokenStorage.notifyTokenReady(p0, TokenStorage.getToken(..));
      L_54:
        return;
    }

    private boolean isValidConfig(Configuration p0) {
        if (if-eqz(p0)) goto L_4;
      L_4:
      L_5:
        return 0;
    }

    private void notifyListenersTokenReady() {
      L_1:
        _tokenListeners.isEmpty();
        if (if-nez(List.isEmpty(..))) goto L_1f;
        _tokenStorage.getToken();
        if (if-nez(TokenStorage.getToken(..))) goto L_12;
      L_12:
        _tokenListeners.get(0);
        InMemoryAsyncTokenStorage.notifyTokenReady(List.get(..), TokenStorage.getToken(..));
      L_1f:
        return;
        throw TokenStorage.getToken(..);
    }

    private void notifyTokenReady(InMemoryAsyncTokenStorage$TokenListenerState p0, String p1) {
        _tokenListeners.remove(p0);
        if (if-eqz(List.remove(..))) goto L_2a;
        if (if-ne(tokenType, TokenType.TOKEN_REMOTE)) goto L_16;
        biddingManager.getFormattedToken(p1);
      L_16:
      L_17:
        biddingManager.onUnityAdsTokenReady(p1);
        _handler.removeCallbacks(runnable);
        DeviceLog.exception("Failed to remove callback from a handler", _handler);
      L_2a:
        InMemoryAsyncTokenStorage.sendTokenMetrics(p1, tokenType);
        return;
        throw tokenType;
    }

    private void sendNativeTokenMetrics(String p0) {
        if (if-nez(_sdkMetrics)) goto L_5;
        return;
      L_5:
        if (if-nez(p0)) goto L_13;
        InMemoryAsyncTokenStorage.getMetricTags();
        TSIMetric.newNativeGeneratedTokenNull(InMemoryAsyncTokenStorage.getMetricTags(..));
        _sdkMetrics.sendMetric(TSIMetric.newNativeGeneratedTokenNull(..));
      L_13:
        InMemoryAsyncTokenStorage.getMetricTags();
        TSIMetric.newNativeGeneratedTokenAvailable(InMemoryAsyncTokenStorage.getMetricTags(..));
        _sdkMetrics.sendMetric(TSIMetric.newNativeGeneratedTokenAvailable(..));
      L_1e:
        return;
    }

    private void sendRemoteTokenMetrics(String p0) {
        if (if-nez(_sdkMetrics)) goto L_5;
        return;
      L_5:
        if (if-eqz(p0)) goto L_1c;
        p0.isEmpty();
        if (if-eqz(String.isEmpty(..))) goto L_e;
      L_e:
        InMemoryAsyncTokenStorage.getMetricTags();
        TSIMetric.newAsyncTokenAvailable(InMemoryAsyncTokenStorage.getMetricTags(..));
        _sdkMetrics.sendMetric(TSIMetric.newAsyncTokenAvailable(..));
      L_1c:
        InMemoryAsyncTokenStorage.getMetricTags();
        TSIMetric.newAsyncTokenNull(InMemoryAsyncTokenStorage.getMetricTags(..));
        _sdkMetrics.sendMetric(TSIMetric.newAsyncTokenNull(..));
      L_29:
        return;
    }

    private void sendTokenMetrics(String p0, TokenType p1) {
        p1.ordinal();
        if (if-eq(TokenType.ordinal(..), 1)) goto L_18;
        if (if-eq(TokenType.ordinal(..), 2)) goto L_14;
        DeviceLog.error("Unknown token type passed to sendTokenMetrics");
      L_14:
        InMemoryAsyncTokenStorage.sendRemoteTokenMetrics("Unknown token type passed to sendTokenMetrics");
      L_18:
        InMemoryAsyncTokenStorage.sendNativeTokenMetrics("Unknown token type passed to sendTokenMetrics");
      L_1b:
        return;
    }

    public void getToken(IBiddingManager p0) {
        SdkProperties.getCurrentInitializationState();
        if (if-ne(SdkProperties.getCurrentInitializationState(..), SdkProperties$InitializationState.INITIALIZED_FAILED)) goto L_14;
        p0.onUnityAdsTokenReady(0);
        InMemoryAsyncTokenStorage.sendTokenMetrics(0, TokenType.TOKEN_REMOTE);
        return;
      L_14:
        SdkProperties.getCurrentInitializationState();
        if (if-ne(SdkProperties.getCurrentInitializationState(..), SdkProperties$InitializationState.NOT_INITIALIZED)) goto L_26;
        TokenType.TOKEN_REMOTE.onUnityAdsTokenReady(0);
        InMemoryAsyncTokenStorage.sendTokenMetrics(0, TokenType.TOKEN_REMOTE);
        return;
      L_26:
        InMemoryAsyncTokenStorage.addTimeoutHandler(TokenType.TOKEN_REMOTE);
        if (if-nez(_configurationWasSet)) goto L_30;
        return;
      L_30:
        InMemoryAsyncTokenStorage.handleTokenInvocation(InMemoryAsyncTokenStorage.addTimeoutHandler(..));
        return;
        throw InMemoryAsyncTokenStorage.addTimeoutHandler(..);
    }

    public void onTokenAvailable() {
        _tokenAvailable = 1;
        if (if-nez(_configurationWasSet)) goto L_a;
        return;
      L_a:
        InMemoryAsyncTokenStorage.notifyListenersTokenReady();
        return;
        throw _configurationWasSet;
    }

    public void setConfiguration(Configuration p0) {
        _configuration = p0;
        InMemoryAsyncTokenStorage.isValidConfig(p0);
        _configurationWasSet = InMemoryAsyncTokenStorage.isValidConfig(..);
        if (if-nez(InMemoryAsyncTokenStorage.isValidConfig(..))) goto L_d;
        return;
      L_d:
        if (if-nez(_nativeTokenGenerator)) goto L_49;
        new ConfigurationReader();
        PrivacyConfigStorage.getInstance();
        GameSessionIdReader.getInstance();
        new DeviceInfoReaderBuilderWithExtras(new ConfigurationReader(..), PrivacyConfigStorage.getInstance(..), GameSessionIdReader.getInstance(..));
        _deviceInfoReaderBuilderWithExtras = new DeviceInfoReaderBuilderWithExtras(..);
        Executors.newSingleThreadExecutor();
        new NativeTokenGenerator(Executors.newSingleThreadExecutor(..), _deviceInfoReaderBuilderWithExtras);
        _nativeTokenGenerator = new NativeTokenGenerator(..);
        p0.getExperiments();
        Configuration.getExperiments(..).shouldNativeTokenAwaitPrivacy();
        if (if-eqz(IExperiments.shouldNativeTokenAwaitPrivacy(..))) goto L_49;
        p0.getPrivacyRequestWaitTimeout();
        new NativeTokenGeneratorWithPrivacyAwait(Executors.newSingleThreadExecutor(..), _nativeTokenGenerator, Configuration.getPrivacyRequestWaitTimeout(..));
        _nativeTokenGenerator = new NativeTokenGeneratorWithPrivacyAwait(..);
      L_49:
        new ArrayList(_tokenListeners);
        new ArrayList(..).iterator();
      L_54:
        ArrayList.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_64;
        ArrayList.iterator(..).next();
        InMemoryAsyncTokenStorage.handleTokenInvocation(Iterator.next(..));
      L_64:
        return;
        throw ArrayList.iterator(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.InMemoryTokenStorage
// ============================================================
package com.unity3d.services.ads.token;

public final class InMemoryTokenStorage {
    private final MutableStateFlow accessCounter;
    private final Lazy asyncTokenStorage$delegate;
    private final ExecutorService executorService;
    private final MutableStateFlow initToken;
    private final ConcurrentLinkedQueue queue;

    public static void $r8$lambda$SVRJSCOj_uXL4yFhGooj3pEiyp0(String p0) {
        InMemoryTokenStorage._get_nativeGeneratedToken_$lambda$2(p0);
        return;
    }

    public InMemoryTokenStorage() {
        new Object();
        new ConcurrentLinkedQueue();
        queue = new ConcurrentLinkedQueue(..);
        Integer.valueOf(-1);
        StateFlowKt.MutableStateFlow(Integer.valueOf(..));
        accessCounter = StateFlowKt.MutableStateFlow(..);
        StateFlowKt.MutableStateFlow(0);
        initToken = StateFlowKt.MutableStateFlow(..);
        Executors.newSingleThreadExecutor();
        executorService = Executors.newSingleThreadExecutor(..);
        new InMemoryTokenStorage$special$$inlined$inject$default$1(new Object(..), "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new InMemoryTokenStorage$special$$inlined$inject$default$1(..));
        asyncTokenStorage$delegate = LazyKt.lazy(..);
        return;
    }

    private static final void _get_nativeGeneratedToken_$lambda$2(String p0) {
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.TOKEN, TokenEvent.TOKEN_NATIVE_DATA, 1);
        return;
    }

    private final AsyncTokenStorage getAsyncTokenStorage() {
        asyncTokenStorage$delegate.getValue();
        return Lazy.getValue(..);
    }

    private final void triggerTokenAvailable(boolean p0) {
        InitializeEventsMetricSender.getInstance();
        IInitializeEventsMetricSender.sdkTokenDidBecomeAvailableWithConfig(p0);
        return;
    }

    public void appendTokens(JSONArray p0) {
        Integer.valueOf(-1);
        Integer.valueOf(0);
        accessCounter.compareAndSet(Integer.valueOf(..), Integer.valueOf(..));
        p0.length();
      L_19:
        if (if-ge(0, JSONArray.length(..))) goto L_27;
        p0.getString(0);
        queue.add(JSONArray.getString(..));
      L_27:
        if (if-lez(JSONArray.length(..))) goto L_33;
        InMemoryTokenStorage.triggerTokenAvailable(0);
        InMemoryTokenStorage.getAsyncTokenStorage();
        AsyncTokenStorage.onTokenAvailable();
      L_33:
        return;
    }

    public void createTokens(JSONArray p0) {
        InMemoryTokenStorage.deleteTokens();
        InMemoryTokenStorage.appendTokens(p0);
        return;
    }

    public void deleteTokens() {
        queue.clear();
      L_7:
        accessCounter.getValue();
        MutableStateFlow.getValue(..).intValue();
        Integer.valueOf(-1);
        accessCounter.compareAndSet(MutableStateFlow.getValue(..), Integer.valueOf(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_7;
        return;
    }

    public Unit getNativeGeneratedToken() {
        new ConfigurationReader();
        PrivacyConfigStorage.getInstance();
        GameSessionIdReader.getInstance();
        new DeviceInfoReaderBuilder(new ConfigurationReader(..), PrivacyConfigStorage.getInstance(..), GameSessionIdReader.getInstance(..));
        new NativeTokenGenerator(executorService, new DeviceInfoReaderBuilder(..), 0);
        new InMemoryTokenStorage$$ExternalSyntheticLambda0();
        new NativeTokenGenerator(..).generateToken(new InMemoryTokenStorage$$ExternalSyntheticLambda0(..));
        return Unit.INSTANCE;
    }

    public IServiceProvider getServiceProvider() {
        IServiceComponent$DefaultImpls.getServiceProvider(this);
        return IServiceComponent$DefaultImpls.getServiceProvider(..);
    }

    public String getToken() {
        accessCounter.getValue();
        MutableStateFlow.getValue(..).intValue();
        if (if-ne(Number.intValue(..), -1)) goto L_18;
        initToken.getValue();
        return MutableStateFlow.getValue(..);
      L_18:
        queue.isEmpty();
        if (if-eqz(ConcurrentLinkedQueue.isEmpty(..))) goto L_34;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.TOKEN, TokenEvent.QUEUE_EMPTY, 0);
        return 0;
      L_34:
      L_36:
        accessCounter.getValue();
        MutableStateFlow.getValue(..).intValue();
        Integer.valueOf(Number.intValue(..));
        accessCounter.compareAndSet(MutableStateFlow.getValue(..), Integer.valueOf(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_36;
        MutableStateFlow.getValue(..).intValue();
        WebViewApp.getCurrentApp();
        Integer.valueOf(Number.intValue(..));
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.TOKEN, TokenEvent.TOKEN_ACCESS, 1);
        queue.poll();
        return ConcurrentLinkedQueue.poll(..);
    }

    public void setInitToken(String p0) {
        if (if-nez(p0)) goto L_3;
        return;
      L_3:
      L_5:
        initToken.getValue();
        initToken.compareAndSet(MutableStateFlow.getValue(..), p0);
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_5;
        InMemoryTokenStorage.triggerTokenAvailable(1);
        InMemoryTokenStorage.getAsyncTokenStorage();
        AsyncTokenStorage.onTokenAvailable();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.NativeTokenGenerator
// ============================================================
package com.unity3d.services.ads.token;

public class NativeTokenGenerator {
    private static final String DEFAULT_NATIVE_TOKEN_PREFIX = "1:";
    private DeviceInfoReaderBuilder _deviceInfoReaderBuilder;
    private ExecutorService _executorService;
    private String _prependStr;

    public NativeTokenGenerator(ExecutorService p0, DeviceInfoReaderBuilder p1) {
        new NativeTokenGenerator(p0, p1, "1:");
        return;
    }

    public NativeTokenGenerator(ExecutorService p0, DeviceInfoReaderBuilder p1, String p2) {
        new Object();
        _executorService = p0;
        _deviceInfoReaderBuilder = p1;
        _prependStr = p2;
        return;
    }

    static DeviceInfoReaderBuilder access$000(NativeTokenGenerator p0) {
        return _deviceInfoReaderBuilder;
    }

    static String access$100(NativeTokenGenerator p0) {
        return _prependStr;
    }

    public void generateToken(INativeTokenGeneratorListener p0) {
        new NativeTokenGenerator$1(this, p0);
        _executorService.execute(new NativeTokenGenerator$1(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.NativeTokenGeneratorWithPrivacyAwait
// ============================================================
package com.unity3d.services.ads.token;

public class NativeTokenGeneratorWithPrivacyAwait {
    private final ExecutorService _executorService;
    private final INativeTokenGenerator _nativeTokenGenerator;
    private final ConditionVariable _privacyAwait;
    private final int _privacyAwaitTimeout;

    public NativeTokenGeneratorWithPrivacyAwait(ExecutorService p0, INativeTokenGenerator p1, int p2) {
        new Object();
        _executorService = p0;
        _nativeTokenGenerator = p1;
        new ConditionVariable();
        _privacyAwait = new ConditionVariable(..);
        _privacyAwaitTimeout = p2;
        return;
    }

    static ConditionVariable access$000(NativeTokenGeneratorWithPrivacyAwait p0) {
        return _privacyAwait;
    }

    static int access$100(NativeTokenGeneratorWithPrivacyAwait p0) {
        return _privacyAwaitTimeout;
    }

    static INativeTokenGenerator access$200(NativeTokenGeneratorWithPrivacyAwait p0) {
        return _nativeTokenGenerator;
    }

    public void generateToken(INativeTokenGeneratorListener p0) {
        new NativeTokenGeneratorWithPrivacyAwait$1(this);
        PrivacyConfigStorage.getInstance();
        PrivacyConfigStorage.getInstance(..).registerObserver(new NativeTokenGeneratorWithPrivacyAwait$1(..));
        new NativeTokenGeneratorWithPrivacyAwait$2(this, new NativeTokenGeneratorWithPrivacyAwait$1(..), p0);
        _executorService.execute(new NativeTokenGeneratorWithPrivacyAwait$2(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.TokenError
// ============================================================
package com.unity3d.services.ads.token;

public final class TokenError extends Enum {
    private static final TokenError[] $VALUES;
    public static final TokenError JSON_EXCEPTION;

    private static TokenError[] $values() {
        return 1;
    }

    static <clinit>() {
        new TokenError("JSON_EXCEPTION", 0);
        JSON_EXCEPTION = new TokenError(..);
        TokenError.$values();
        $VALUES = TokenError.$values(..);
        return;
    }

    private TokenError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static TokenError valueOf(String p0) {
        Enum.valueOf(TokenError.class, p0);
        return Enum.valueOf(..);
    }

    public static TokenError[] values() {
        TokenError.$VALUES.clone();
        return TokenError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.TokenEvent
// ============================================================
package com.unity3d.services.ads.token;

public final class TokenEvent extends Enum {
    private static final TokenEvent[] $VALUES;
    public static final TokenEvent QUEUE_EMPTY;
    public static final TokenEvent TOKEN_ACCESS;
    public static final TokenEvent TOKEN_NATIVE_DATA;

    private static TokenEvent[] $values() {
        return 3;
    }

    static <clinit>() {
        new TokenEvent("TOKEN_ACCESS", 0);
        TOKEN_ACCESS = new TokenEvent(..);
        new TokenEvent("QUEUE_EMPTY", 1);
        QUEUE_EMPTY = new TokenEvent(..);
        new TokenEvent("TOKEN_NATIVE_DATA", 2);
        TOKEN_NATIVE_DATA = new TokenEvent(..);
        TokenEvent.$values();
        $VALUES = TokenEvent.$values(..);
        return;
    }

    private TokenEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static TokenEvent valueOf(String p0) {
        Enum.valueOf(TokenEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static TokenEvent[] values() {
        TokenEvent.$VALUES.clone();
        return TokenEvent[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.TokenStorage
// ============================================================
package com.unity3d.services.ads.token;

public abstract class TokenStorage {
    public abstract void appendTokens(JSONArray p0) {
        // native or abstract
    }

    public abstract void createTokens(JSONArray p0) {
        // native or abstract
    }

    public abstract void deleteTokens() {
        // native or abstract
    }

    public abstract Unit getNativeGeneratedToken() {
        // native or abstract
    }

    public abstract String getToken() {
        // native or abstract
    }

    public abstract void setInitToken(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.InMemoryAsyncTokenStorage$1
// ============================================================
package com.unity3d.services.ads.token;

class InMemoryAsyncTokenStorage$1 {
    final InMemoryAsyncTokenStorage this$0;
    final InMemoryAsyncTokenStorage$TokenListenerState val$state;

    InMemoryAsyncTokenStorage$1(InMemoryAsyncTokenStorage p0, InMemoryAsyncTokenStorage$TokenListenerState p1) {
        this$0 = p0;
        val$state = p1;
        new Object();
        return;
    }

    public void run() {
        InMemoryAsyncTokenStorage.access$000(this$0, val$state, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.InMemoryAsyncTokenStorage$2
// ============================================================
package com.unity3d.services.ads.token;

class InMemoryAsyncTokenStorage$2 {
    final InMemoryAsyncTokenStorage this$0;
    final InMemoryAsyncTokenStorage$TokenListenerState val$state;

    InMemoryAsyncTokenStorage$2(InMemoryAsyncTokenStorage p0, InMemoryAsyncTokenStorage$TokenListenerState p1) {
        this$0 = p0;
        val$state = p1;
        new Object();
        return;
    }

    public void onReady(String p0) {
        InMemoryAsyncTokenStorage.access$100(this$0);
        new InMemoryAsyncTokenStorage$2$1(this, p0);
        Handler.post(new InMemoryAsyncTokenStorage$2$1(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.InMemoryAsyncTokenStorage$2$1
// ============================================================
package com.unity3d.services.ads.token;

class InMemoryAsyncTokenStorage$2$1 {
    final InMemoryAsyncTokenStorage$2 this$1;
    final String val$token;

    InMemoryAsyncTokenStorage$2$1(InMemoryAsyncTokenStorage$2 p0, String p1) {
        this$1 = p0;
        val$token = p1;
        new Object();
        return;
    }

    public void run() {
        InMemoryAsyncTokenStorage.access$000(this$0, val$state, val$token);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.InMemoryAsyncTokenStorage$3
// ============================================================
package com.unity3d.services.ads.token;

class InMemoryAsyncTokenStorage$3 {
    static final int[] $SwitchMap$com$unity3d$services$core$device$TokenType;

    static <clinit>() {
        TokenType.values();
        $SwitchMap$com$unity3d$services$core$device$TokenType = TokenType.values(..);
        TokenType.TOKEN_NATIVE.ordinal();
        TokenType.TOKEN_REMOTE.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.InMemoryAsyncTokenStorage$TokenListenerState
// ============================================================
package com.unity3d.services.ads.token;

class InMemoryAsyncTokenStorage$TokenListenerState {
    public IBiddingManager biddingManager;
    public boolean invoked;
    public Runnable runnable;
    final InMemoryAsyncTokenStorage this$0;
    public TokenType tokenType;

    InMemoryAsyncTokenStorage$TokenListenerState(InMemoryAsyncTokenStorage p0) {
        this$0 = p0;
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.InMemoryTokenStorage$special$$inlined$inject$default$1
// ============================================================
package com.unity3d.services.ads.token;

public final class InMemoryTokenStorage$special$$inlined$inject$default$1 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public InMemoryTokenStorage$special$$inlined$inject$default$1(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(AsyncTokenStorage.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.NativeTokenGenerator$1
// ============================================================
package com.unity3d.services.ads.token;

class NativeTokenGenerator$1 {
    final NativeTokenGenerator this$0;
    final INativeTokenGeneratorListener val$callback;

    NativeTokenGenerator$1(NativeTokenGenerator p0, INativeTokenGeneratorListener p1) {
        this$0 = p0;
        val$callback = p1;
        new Object();
        return;
    }

    public void run() {
        NativeTokenGenerator.access$000(this$0);
        NativeTokenGenerator.access$000(..).build();
        new DeviceInfoReaderCompressor(DeviceInfoReaderBuilder.build(..));
        new DeviceInfoReaderCompressor(..).getDeviceData();
        Base64.encodeToString(DeviceInfoReaderCompressor.getDeviceData(..), 2);
        NativeTokenGenerator.access$100(this$0);
        if (if-eqz(NativeTokenGenerator.access$100(..))) goto L_56;
        NativeTokenGenerator.access$100(this$0);
        NativeTokenGenerator.access$100(..).isEmpty();
        if (if-nez(String.isEmpty(..))) goto L_56;
        NativeTokenGenerator.access$100(this$0);
        NativeTokenGenerator.access$100(..).length();
        Base64.encodeToString(..).length();
        new StringBuilder(String.length(..));
        NativeTokenGenerator.access$100(this$0);
        new StringBuilder(..).append(NativeTokenGenerator.access$100(..));
        new StringBuilder(..).append(Base64.encodeToString(..));
        new StringBuilder(..).toString();
        INativeTokenGeneratorListener.onReady(StringBuilder.toString(..));
      L_56:
        INativeTokenGeneratorListener.onReady(val$callback);
        DeviceLog.exception("Unity Ads failed to generate token.", val$callback);
        INativeTokenGeneratorListener.onReady(0);
      L_68:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.NativeTokenGeneratorWithPrivacyAwait$1
// ============================================================
package com.unity3d.services.ads.token;

class NativeTokenGeneratorWithPrivacyAwait$1 {
    final NativeTokenGeneratorWithPrivacyAwait this$0;

    NativeTokenGeneratorWithPrivacyAwait$1(NativeTokenGeneratorWithPrivacyAwait p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void updated(PrivacyConfig p0) {
        NativeTokenGeneratorWithPrivacyAwait.access$000(this$0);
        ConditionVariable.open();
        return;
    }

    public void updated(Object p0) {
        NativeTokenGeneratorWithPrivacyAwait$1.updated(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.token.NativeTokenGeneratorWithPrivacyAwait$2
// ============================================================
package com.unity3d.services.ads.token;

class NativeTokenGeneratorWithPrivacyAwait$2 {
    final NativeTokenGeneratorWithPrivacyAwait this$0;
    final INativeTokenGeneratorListener val$callback;
    final IObserver val$privacyConfigObserver;

    NativeTokenGeneratorWithPrivacyAwait$2(NativeTokenGeneratorWithPrivacyAwait p0, IObserver p1, INativeTokenGeneratorListener p2) {
        this$0 = p0;
        val$privacyConfigObserver = p1;
        val$callback = p2;
        new Object();
        return;
    }

    public void run() {
        NativeTokenGeneratorWithPrivacyAwait.access$000(this$0);
        NativeTokenGeneratorWithPrivacyAwait.access$100(this$0);
        ConditionVariable.block(NativeTokenGeneratorWithPrivacyAwait.access$100(..), v2);
        PrivacyConfigStorage.getInstance();
        PrivacyConfigStorage.getInstance(..).unregisterObserver(val$privacyConfigObserver);
        NativeTokenGeneratorWithPrivacyAwait.access$200(this$0);
        INativeTokenGenerator.generateToken(val$callback);
        return;
    }

}

