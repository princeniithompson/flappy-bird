
// ===== FILE: com/unity3d/services/ads/token/AsyncTokenStorage.java =====
package com.unity3d.services.ads.token;

import com.unity3d.services.ads.gmascar.managers.IBiddingManager;
import com.unity3d.services.core.configuration.Configuration;
import kotlin.Metadata;

/* compiled from: AsyncTokenStorage.kt */
@Metadata(m443d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, m444d2 = {"Lcom/unity3d/services/ads/token/AsyncTokenStorage;", "", "getToken", "", "biddingManager", "Lcom/unity3d/services/ads/gmascar/managers/IBiddingManager;", "onTokenAvailable", "setConfiguration", "configuration", "Lcom/unity3d/services/core/configuration/Configuration;", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface AsyncTokenStorage {
    void getToken(IBiddingManager biddingManager);

    void onTokenAvailable();

    void setConfiguration(Configuration configuration);
}

// ===== FILE: com/unity3d/services/ads/token/INativeTokenGenerator.java =====
package com.unity3d.services.ads.token;

/* loaded from: classes.dex */
public interface INativeTokenGenerator {
    void generateToken(INativeTokenGeneratorListener iNativeTokenGeneratorListener);
}

// ===== FILE: com/unity3d/services/ads/token/INativeTokenGeneratorListener.java =====
package com.unity3d.services.ads.token;

/* loaded from: classes.dex */
public interface INativeTokenGeneratorListener {
    void onReady(String str);
}

// ===== FILE: com/unity3d/services/ads/token/InMemoryAsyncTokenStorage.java =====
package com.unity3d.services.ads.token;

import android.os.Handler;
import com.unity3d.services.ads.gmascar.GMA;
import com.unity3d.services.ads.gmascar.managers.IBiddingManager;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.device.TokenType;
import com.unity3d.services.core.device.reader.GameSessionIdReader;
import com.unity3d.services.core.device.reader.builder.DeviceInfoReaderBuilderWithExtras;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.InitializationStatusReader;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class InMemoryAsyncTokenStorage implements AsyncTokenStorage {
    private DeviceInfoReaderBuilderWithExtras _deviceInfoReaderBuilderWithExtras;
    private final Handler _handler;
    private INativeTokenGenerator _nativeTokenGenerator;
    private final SDKMetricsSender _sdkMetrics;
    private TokenStorage _tokenStorage;
    private final List<TokenListenerState> _tokenListeners = new LinkedList();
    private boolean _tokenAvailable = false;
    private boolean _configurationWasSet = false;
    private Configuration _configuration = new Configuration();
    private final InitializationStatusReader _initStatusReader = new InitializationStatusReader();

    private boolean isValidConfig(Configuration configuration) {
        return configuration != null;
    }

    class TokenListenerState {
        public IBiddingManager biddingManager;
        public boolean invoked;
        public Runnable runnable;
        public TokenType tokenType;

        TokenListenerState() {
        }
    }

    public InMemoryAsyncTokenStorage(INativeTokenGenerator iNativeTokenGenerator, Handler handler, SDKMetricsSender sDKMetricsSender, TokenStorage tokenStorage) {
        this._handler = handler;
        this._nativeTokenGenerator = iNativeTokenGenerator;
        this._sdkMetrics = sDKMetricsSender;
        this._tokenStorage = tokenStorage;
    }

    @Override // com.unity3d.services.ads.token.AsyncTokenStorage
    public synchronized void setConfiguration(Configuration configuration) {
        this._configuration = configuration;
        boolean isValidConfig = isValidConfig(configuration);
        this._configurationWasSet = isValidConfig;
        if (isValidConfig) {
            if (this._nativeTokenGenerator == null) {
                this._deviceInfoReaderBuilderWithExtras = new DeviceInfoReaderBuilderWithExtras(new ConfigurationReader(), PrivacyConfigStorage.getInstance(), GameSessionIdReader.getInstance());
                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                this._nativeTokenGenerator = new NativeTokenGenerator(newSingleThreadExecutor, this._deviceInfoReaderBuilderWithExtras);
                if (configuration.getExperiments().shouldNativeTokenAwaitPrivacy()) {
                    this._nativeTokenGenerator = new NativeTokenGeneratorWithPrivacyAwait(newSingleThreadExecutor, this._nativeTokenGenerator, configuration.getPrivacyRequestWaitTimeout());
                }
            }
            Iterator it = new ArrayList(this._tokenListeners).iterator();
            while (it.hasNext()) {
                handleTokenInvocation((TokenListenerState) it.next());
            }
        }
    }

    @Override // com.unity3d.services.ads.token.AsyncTokenStorage
    public synchronized void onTokenAvailable() {
        this._tokenAvailable = true;
        if (this._configurationWasSet) {
            notifyListenersTokenReady();
        }
    }

    @Override // com.unity3d.services.ads.token.AsyncTokenStorage
    public synchronized void getToken(IBiddingManager iBiddingManager) {
        if (SdkProperties.getCurrentInitializationState() == SdkProperties.InitializationState.INITIALIZED_FAILED) {
            iBiddingManager.onUnityAdsTokenReady(null);
            sendTokenMetrics(null, TokenType.TOKEN_REMOTE);
        } else if (SdkProperties.getCurrentInitializationState() == SdkProperties.InitializationState.NOT_INITIALIZED) {
            iBiddingManager.onUnityAdsTokenReady(null);
            sendTokenMetrics(null, TokenType.TOKEN_REMOTE);
        } else {
            TokenListenerState addTimeoutHandler = addTimeoutHandler(iBiddingManager);
            if (this._configurationWasSet) {
                handleTokenInvocation(addTimeoutHandler);
            }
        }
    }

    private synchronized TokenListenerState addTimeoutHandler(IBiddingManager iBiddingManager) {
        final TokenListenerState tokenListenerState;
        tokenListenerState = new TokenListenerState();
        tokenListenerState.biddingManager = iBiddingManager;
        tokenListenerState.tokenType = TokenType.TOKEN_REMOTE;
        tokenListenerState.runnable = new Runnable() { // from class: com.unity3d.services.ads.token.InMemoryAsyncTokenStorage.1
            @Override // java.lang.Runnable
            public void run() {
                InMemoryAsyncTokenStorage.this.notifyTokenReady(tokenListenerState, null);
            }
        };
        this._tokenListeners.add(tokenListenerState);
        this._handler.postDelayed(tokenListenerState.runnable, this._configuration.getTokenTimeout());
        return tokenListenerState;
    }

    private synchronized void notifyListenersTokenReady() {
        String token;
        while (!this._tokenListeners.isEmpty() && (token = this._tokenStorage.getToken()) != null) {
            notifyTokenReady(this._tokenListeners.get(0), token);
        }
    }

    private void handleTokenInvocation(final TokenListenerState tokenListenerState) {
        if (tokenListenerState.invoked) {
            return;
        }
        tokenListenerState.invoked = true;
        if (!this._tokenAvailable) {
            tokenListenerState.tokenType = TokenType.TOKEN_NATIVE;
            if (GMA.getInstance().hasSCARBiddingSupport() && this._deviceInfoReaderBuilderWithExtras != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(ScarConstants.TOKEN_ID_KEY, tokenListenerState.biddingManager.getTokenIdentifier());
                this._deviceInfoReaderBuilderWithExtras.setExtras(hashMap);
            }
            this._nativeTokenGenerator.generateToken(new INativeTokenGeneratorListener() { // from class: com.unity3d.services.ads.token.InMemoryAsyncTokenStorage.2
                @Override // com.unity3d.services.ads.token.INativeTokenGeneratorListener
                public void onReady(final String str) {
                    InMemoryAsyncTokenStorage.this._handler.post(new Runnable() { // from class: com.unity3d.services.ads.token.InMemoryAsyncTokenStorage.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            InMemoryAsyncTokenStorage.this.notifyTokenReady(tokenListenerState, str);
                        }
                    });
                }
            });
            return;
        }
        tokenListenerState.tokenType = TokenType.TOKEN_REMOTE;
        String token = this._tokenStorage.getToken();
        if (token == null || token.isEmpty()) {
            return;
        }
        notifyTokenReady(tokenListenerState, token);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyTokenReady(TokenListenerState tokenListenerState, String str) {
        if (this._tokenListeners.remove(tokenListenerState)) {
            tokenListenerState.biddingManager.onUnityAdsTokenReady(tokenListenerState.tokenType == TokenType.TOKEN_REMOTE ? tokenListenerState.biddingManager.getFormattedToken(str) : str);
            try {
                this._handler.removeCallbacks(tokenListenerState.runnable);
            } catch (Exception e) {
                DeviceLog.exception("Failed to remove callback from a handler", e);
            }
        }
        sendTokenMetrics(str, tokenListenerState.tokenType);
    }

    /* renamed from: com.unity3d.services.ads.token.InMemoryAsyncTokenStorage$3 */
    static /* synthetic */ class C10863 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$core$device$TokenType;

        static {
            int[] iArr = new int[TokenType.values().length];
            $SwitchMap$com$unity3d$services$core$device$TokenType = iArr;
            try {
                iArr[TokenType.TOKEN_NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$services$core$device$TokenType[TokenType.TOKEN_REMOTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void sendTokenMetrics(String str, TokenType tokenType) {
        int i = C10863.$SwitchMap$com$unity3d$services$core$device$TokenType[tokenType.ordinal()];
        if (i == 1) {
            sendNativeTokenMetrics(str);
        } else if (i == 2) {
            sendRemoteTokenMetrics(str);
        } else {
            DeviceLog.error("Unknown token type passed to sendTokenMetrics");
        }
    }

    private void sendNativeTokenMetrics(String str) {
        SDKMetricsSender sDKMetricsSender = this._sdkMetrics;
        if (sDKMetricsSender == null) {
            return;
        }
        if (str == null) {
            sDKMetricsSender.sendMetric(TSIMetric.newNativeGeneratedTokenNull(getMetricTags()));
        } else {
            sDKMetricsSender.sendMetric(TSIMetric.newNativeGeneratedTokenAvailable(getMetricTags()));
        }
    }

    private void sendRemoteTokenMetrics(String str) {
        if (this._sdkMetrics == null) {
            return;
        }
        if (str == null || str.isEmpty()) {
            this._sdkMetrics.sendMetric(TSIMetric.newAsyncTokenNull(getMetricTags()));
        } else {
            this._sdkMetrics.sendMetric(TSIMetric.newAsyncTokenAvailable(getMetricTags()));
        }
    }

    private Map<String, String> getMetricTags() {
        HashMap hashMap = new HashMap();
        hashMap.put("state", this._initStatusReader.getInitializationStateString(SdkProperties.getCurrentInitializationState()));
        return hashMap;
    }
}

// ===== FILE: com/unity3d/services/ads/token/InMemoryTokenStorage.java =====
package com.unity3d.services.ads.token;

import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.device.reader.GameSessionIdReader;
import com.unity3d.services.core.device.reader.builder.DeviceInfoReaderBuilder;
import com.unity3d.services.core.p005di.IServiceComponent;
import com.unity3d.services.core.p005di.IServiceProvider;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: InMemoryTokenStorage.kt */
@Metadata(m443d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0012\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, m444d2 = {"Lcom/unity3d/services/ads/token/InMemoryTokenStorage;", "Lcom/unity3d/services/ads/token/TokenStorage;", "Lcom/unity3d/services/core/di/IServiceComponent;", "()V", "accessCounter", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "asyncTokenStorage", "Lcom/unity3d/services/ads/token/AsyncTokenStorage;", "getAsyncTokenStorage", "()Lcom/unity3d/services/ads/token/AsyncTokenStorage;", "asyncTokenStorage$delegate", "Lkotlin/Lazy;", "executorService", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "initToken", "", "nativeGeneratedToken", "", "getNativeGeneratedToken", "()Lkotlin/Unit;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "token", "getToken", "()Ljava/lang/String;", "appendTokens", "tokens", "Lorg/json/JSONArray;", "createTokens", "deleteTokens", "setInitToken", "value", "triggerTokenAvailable", "withConfig", "", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class InMemoryTokenStorage implements TokenStorage, IServiceComponent {

    /* renamed from: asyncTokenStorage$delegate, reason: from kotlin metadata */
    private final Lazy asyncTokenStorage;
    private final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    private final MutableStateFlow<Integer> accessCounter = StateFlowKt.MutableStateFlow(-1);
    private final MutableStateFlow<String> initToken = StateFlowKt.MutableStateFlow(null);
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public InMemoryTokenStorage() {
        final InMemoryTokenStorage inMemoryTokenStorage = this;
        final String str = "";
        this.asyncTokenStorage = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<AsyncTokenStorage>() { // from class: com.unity3d.services.ads.token.InMemoryTokenStorage$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.services.ads.token.AsyncTokenStorage, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AsyncTokenStorage invoke() {
                IServiceComponent iServiceComponent = IServiceComponent.this;
                return iServiceComponent.getServiceProvider().getRegistry().getService(str, Reflection.getOrCreateKotlinClass(AsyncTokenStorage.class));
            }
        });
    }

    @Override // com.unity3d.services.core.p005di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    private final AsyncTokenStorage getAsyncTokenStorage() {
        return (AsyncTokenStorage) this.asyncTokenStorage.getValue();
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public void createTokens(JSONArray tokens) throws JSONException {
        Intrinsics.checkNotNullParameter(tokens, "tokens");
        deleteTokens();
        appendTokens(tokens);
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public void appendTokens(JSONArray tokens) throws JSONException {
        Intrinsics.checkNotNullParameter(tokens, "tokens");
        this.accessCounter.compareAndSet(-1, 0);
        int length = tokens.length();
        for (int i = 0; i < length; i++) {
            this.queue.add(tokens.getString(i));
        }
        if (length > 0) {
            triggerTokenAvailable(false);
            getAsyncTokenStorage().onTokenAvailable();
        }
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public void deleteTokens() {
        Integer value;
        this.queue.clear();
        MutableStateFlow<Integer> mutableStateFlow = this.accessCounter;
        do {
            value = mutableStateFlow.getValue();
            value.intValue();
        } while (!mutableStateFlow.compareAndSet(value, -1));
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public String getToken() {
        Integer value;
        Integer num;
        if (this.accessCounter.getValue().intValue() == -1) {
            return this.initToken.getValue();
        }
        if (this.queue.isEmpty()) {
            WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.QUEUE_EMPTY, new Object[0]);
            return null;
        }
        MutableStateFlow<Integer> mutableStateFlow = this.accessCounter;
        do {
            value = mutableStateFlow.getValue();
            num = value;
        } while (!mutableStateFlow.compareAndSet(value, Integer.valueOf(num.intValue() + 1)));
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.TOKEN_ACCESS, Integer.valueOf(num.intValue()));
        return this.queue.poll();
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public Unit getNativeGeneratedToken() {
        new NativeTokenGenerator(this.executorService, new DeviceInfoReaderBuilder(new ConfigurationReader(), PrivacyConfigStorage.getInstance(), GameSessionIdReader.getInstance()), null).generateToken(new INativeTokenGeneratorListener() { // from class: com.unity3d.services.ads.token.InMemoryTokenStorage$$ExternalSyntheticLambda0
            @Override // com.unity3d.services.ads.token.INativeTokenGeneratorListener
            public final void onReady(String str) {
                InMemoryTokenStorage._get_nativeGeneratedToken_$lambda$2(str);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _get_nativeGeneratedToken_$lambda$2(String str) {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.TOKEN, TokenEvent.TOKEN_NATIVE_DATA, str);
    }

    @Override // com.unity3d.services.ads.token.TokenStorage
    public void setInitToken(String value) {
        if (value == null) {
            return;
        }
        MutableStateFlow<String> mutableStateFlow = this.initToken;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), value)) {
        }
        triggerTokenAvailable(true);
        getAsyncTokenStorage().onTokenAvailable();
    }

    private final void triggerTokenAvailable(boolean withConfig) {
        InitializeEventsMetricSender.getInstance().sdkTokenDidBecomeAvailableWithConfig(withConfig);
    }
}

// ===== FILE: com/unity3d/services/ads/token/NativeTokenGenerator.java =====
package com.unity3d.services.ads.token;

import android.util.Base64;
import com.unity3d.services.core.device.reader.DeviceInfoReaderCompressor;
import com.unity3d.services.core.device.reader.builder.DeviceInfoReaderBuilder;
import com.unity3d.services.core.log.DeviceLog;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class NativeTokenGenerator implements INativeTokenGenerator {
    private static final String DEFAULT_NATIVE_TOKEN_PREFIX = "1:";
    private DeviceInfoReaderBuilder _deviceInfoReaderBuilder;
    private ExecutorService _executorService;
    private String _prependStr;

    public NativeTokenGenerator(ExecutorService executorService, DeviceInfoReaderBuilder deviceInfoReaderBuilder) {
        this(executorService, deviceInfoReaderBuilder, DEFAULT_NATIVE_TOKEN_PREFIX);
    }

    public NativeTokenGenerator(ExecutorService executorService, DeviceInfoReaderBuilder deviceInfoReaderBuilder, String str) {
        this._executorService = executorService;
        this._deviceInfoReaderBuilder = deviceInfoReaderBuilder;
        this._prependStr = str;
    }

    @Override // com.unity3d.services.ads.token.INativeTokenGenerator
    public void generateToken(final INativeTokenGeneratorListener iNativeTokenGeneratorListener) {
        this._executorService.execute(new Runnable() { // from class: com.unity3d.services.ads.token.NativeTokenGenerator.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String encodeToString = Base64.encodeToString(new DeviceInfoReaderCompressor(NativeTokenGenerator.this._deviceInfoReaderBuilder.build()).getDeviceData(), 2);
                    if (NativeTokenGenerator.this._prependStr != null && !NativeTokenGenerator.this._prependStr.isEmpty()) {
                        StringBuilder sb = new StringBuilder(NativeTokenGenerator.this._prependStr.length() + encodeToString.length());
                        sb.append(NativeTokenGenerator.this._prependStr);
                        sb.append(encodeToString);
                        iNativeTokenGeneratorListener.onReady(sb.toString());
                    } else {
                        iNativeTokenGeneratorListener.onReady(encodeToString);
                    }
                } catch (Exception e) {
                    DeviceLog.exception("Unity Ads failed to generate token.", e);
                    iNativeTokenGeneratorListener.onReady(null);
                }
            }
        });
    }
}

// ===== FILE: com/unity3d/services/ads/token/NativeTokenGeneratorWithPrivacyAwait.java =====
package com.unity3d.services.ads.token;

import android.os.ConditionVariable;
import com.unity3d.services.core.configuration.PrivacyConfig;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.misc.IObserver;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class NativeTokenGeneratorWithPrivacyAwait implements INativeTokenGenerator {
    private final ExecutorService _executorService;
    private final INativeTokenGenerator _nativeTokenGenerator;
    private final ConditionVariable _privacyAwait = new ConditionVariable();
    private final int _privacyAwaitTimeout;

    public NativeTokenGeneratorWithPrivacyAwait(ExecutorService executorService, INativeTokenGenerator iNativeTokenGenerator, int i) {
        this._executorService = executorService;
        this._nativeTokenGenerator = iNativeTokenGenerator;
        this._privacyAwaitTimeout = i;
    }

    @Override // com.unity3d.services.ads.token.INativeTokenGenerator
    public void generateToken(final INativeTokenGeneratorListener iNativeTokenGeneratorListener) {
        final IObserver<PrivacyConfig> iObserver = new IObserver<PrivacyConfig>() { // from class: com.unity3d.services.ads.token.NativeTokenGeneratorWithPrivacyAwait.1
            @Override // com.unity3d.services.core.misc.IObserver
            public void updated(PrivacyConfig privacyConfig) {
                NativeTokenGeneratorWithPrivacyAwait.this._privacyAwait.open();
            }
        };
        PrivacyConfigStorage.getInstance().registerObserver(iObserver);
        this._executorService.execute(new Runnable() { // from class: com.unity3d.services.ads.token.NativeTokenGeneratorWithPrivacyAwait.2
            @Override // java.lang.Runnable
            public void run() {
                NativeTokenGeneratorWithPrivacyAwait.this._privacyAwait.block(NativeTokenGeneratorWithPrivacyAwait.this._privacyAwaitTimeout);
                PrivacyConfigStorage.getInstance().unregisterObserver(iObserver);
                NativeTokenGeneratorWithPrivacyAwait.this._nativeTokenGenerator.generateToken(iNativeTokenGeneratorListener);
            }
        });
    }
}

// ===== FILE: com/unity3d/services/ads/token/TokenError.java =====
package com.unity3d.services.ads.token;

/* loaded from: classes.dex */
public enum TokenError {
    JSON_EXCEPTION
}

// ===== FILE: com/unity3d/services/ads/token/TokenEvent.java =====
package com.unity3d.services.ads.token;

/* loaded from: classes.dex */
public enum TokenEvent {
    TOKEN_ACCESS,
    QUEUE_EMPTY,
    TOKEN_NATIVE_DATA
}

// ===== FILE: com/unity3d/services/ads/token/TokenStorage.java =====
package com.unity3d.services.ads.token;

import kotlin.Metadata;
import kotlin.Unit;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: TokenStorage.kt */
@Metadata(m443d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, m444d2 = {"Lcom/unity3d/services/ads/token/TokenStorage;", "", "nativeGeneratedToken", "", "getNativeGeneratedToken", "()Lkotlin/Unit;", "token", "", "getToken", "()Ljava/lang/String;", "appendTokens", "tokens", "Lorg/json/JSONArray;", "createTokens", "deleteTokens", "setInitToken", "value", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface TokenStorage {
    void appendTokens(JSONArray tokens) throws JSONException;

    void createTokens(JSONArray tokens) throws JSONException;

    void deleteTokens();

    Unit getNativeGeneratedToken();

    String getToken();

    void setInitToken(String value);
}
