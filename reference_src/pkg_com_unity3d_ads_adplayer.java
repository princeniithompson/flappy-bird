// Package bundle: com.unity3d.ads.adplayer (138 classes)

// ============================================================
// CLASS: com.unity3d.ads.adplayer.AdPlayer
// ============================================================
package com.unity3d.ads.adplayer;

public abstract class AdPlayer {
    public static final AdPlayer$Companion Companion;

    static <clinit>() {
        Companion = AdPlayer$Companion.$$INSTANCE;
        return;
    }

    public abstract Object destroy(Continuation p0) {
        // native or abstract
    }

    public abstract void dispatchShowCompleted() {
        // native or abstract
    }

    public abstract Flow getOnLoadEvent() {
        // native or abstract
    }

    public abstract Flow getOnShowEvent() {
        // native or abstract
    }

    public abstract CoroutineScope getScope() {
        // native or abstract
    }

    public abstract Flow getUpdateCampaignState() {
        // native or abstract
    }

    public abstract WebViewContainer getWebViewContainer() {
        // native or abstract
    }

    public abstract Object onAllowedPiiChange(byte[] p0, Continuation p1) {
        // native or abstract
    }

    public abstract Object onBroadcastEvent(String p0, Continuation p1) {
        // native or abstract
    }

    public abstract Object requestShow(Map p0, Continuation p1) {
        // native or abstract
    }

    public abstract Object sendActivityDestroyed(Continuation p0) {
        // native or abstract
    }

    public abstract Object sendFocusChange(boolean p0, Continuation p1) {
        // native or abstract
    }

    public abstract Object sendMuteChange(boolean p0, Continuation p1) {
        // native or abstract
    }

    public abstract Object sendPrivacyFsmChange(byte[] p0, Continuation p1) {
        // native or abstract
    }

    public abstract Object sendUserConsentChange(byte[] p0, Continuation p1) {
        // native or abstract
    }

    public abstract Object sendVisibilityChange(boolean p0, Continuation p1) {
        // native or abstract
    }

    public abstract Object sendVolumeChange(double p0, Continuation p1) {
        // native or abstract
    }

    public abstract void show(ShowOptions p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AdPlayerError
// ============================================================
package com.unity3d.ads.adplayer;

public abstract class AdPlayerError extends Exception {
    private AdPlayerError(String p0) {
        new Exception(p0);
        return;
    }

    public AdPlayerError(String p0, DefaultConstructorMarker p1) {
        new AdPlayerError(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AdPlayerScope
// ============================================================
package com.unity3d.ads.adplayer;

public final class AdPlayerScope {
    private final CoroutineScope $$delegate_0;
    private final CoroutineDispatcher defaultDispatcher;

    public AdPlayerScope(CoroutineDispatcher p0) {
        new Object();
        defaultDispatcher = p0;
        CoroutineScopeKt.CoroutineScope(p0);
        $$delegate_0 = CoroutineScopeKt.CoroutineScope(..);
        return;
    }

    public CoroutineContext getCoroutineContext() {
        $$delegate_0.getCoroutineContext();
        return CoroutineScope.getCoroutineContext(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidEmbeddableWebViewAdPlayer {
    private final OpenMeasurementRepository openMeasurementRepository;
    private final String opportunityId;
    private final WebViewAdPlayer webViewAdPlayer;
    private final AndroidWebViewContainer webViewContainer;

    public AndroidEmbeddableWebViewAdPlayer(WebViewAdPlayer p0, String p1, AndroidWebViewContainer p2, OpenMeasurementRepository p3) {
        new Object();
        webViewAdPlayer = p0;
        opportunityId = p1;
        webViewContainer = p2;
        openMeasurementRepository = p3;
        return;
    }

    public static final WebViewAdPlayer access$getWebViewAdPlayer$p(AndroidEmbeddableWebViewAdPlayer p0) {
        return webViewAdPlayer;
    }

    public Object destroy(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidEmbeddableWebViewAdPlayer$destroy$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_48;
        if (if-eq(label, 1)) goto L_40;
        if (if-eq(label, 2)) goto L_38;
        if (if-ne(label, 3)) goto L_30;
        ResultKt.throwOnFailure(result);
      L_30:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_38:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_40:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_48:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        webViewAdPlayer.dispatchShowCompleted();
        ProtobufExtensionsKt.toISO8859ByteString(opportunityId);
        openMeasurementRepository.hasSessionFinished(ProtobufExtensionsKt.toISO8859ByteString(..));
        if (if-eqz(OpenMeasurementRepository.hasSessionFinished(..))) goto L_6b;
        L$0 = this;
        label = 1;
        DelayKt.delay(1000L, v6, "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(DelayKt.delay(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_6b;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_6b:
      L_6c:
        AndroidEmbeddableWebViewAdPlayer.getWebViewContainer();
        L$0 = this;
        label = 2;
        AndroidWebViewContainer.destroy("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(AndroidWebViewContainer.destroy(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_7b;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_7b:
        L$0 = 0;
        label = 3;
        AdPlayer$DefaultImpls.destroy(this, "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(AdPlayer$DefaultImpls.destroy(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_87;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_87:
        return Unit.INSTANCE;
    }

    public void dispatchShowCompleted() {
        webViewAdPlayer.dispatchShowCompleted();
        return;
    }

    public Flow getOnLoadEvent() {
        webViewAdPlayer.getOnLoadEvent();
        return WebViewAdPlayer.getOnLoadEvent(..);
    }

    public Flow getOnShowEvent() {
        webViewAdPlayer.getOnShowEvent();
        return WebViewAdPlayer.getOnShowEvent(..);
    }

    public CoroutineScope getScope() {
        webViewAdPlayer.getScope();
        return WebViewAdPlayer.getScope(..);
    }

    public Flow getUpdateCampaignState() {
        webViewAdPlayer.getUpdateCampaignState();
        return WebViewAdPlayer.getUpdateCampaignState(..);
    }

    public AndroidWebViewContainer getWebViewContainer() {
        return webViewContainer;
    }

    public WebViewContainer getWebViewContainer() {
        AndroidEmbeddableWebViewAdPlayer.getWebViewContainer();
        return AndroidEmbeddableWebViewAdPlayer.getWebViewContainer(..);
    }

    public Object onAllowedPiiChange(byte[] p0, Continuation p1) {
        webViewAdPlayer.onAllowedPiiChange(p0, p1);
        return WebViewAdPlayer.onAllowedPiiChange(..);
    }

    public Object onBroadcastEvent(String p0, Continuation p1) {
        webViewAdPlayer.onBroadcastEvent(p0, p1);
        return WebViewAdPlayer.onBroadcastEvent(..);
    }

    public Object requestShow(Map p0, Continuation p1) {
        webViewAdPlayer.requestShow(p0, p1);
        return WebViewAdPlayer.requestShow(..);
    }

    public Object sendActivityDestroyed(Continuation p0) {
        webViewAdPlayer.sendActivityDestroyed(p0);
        return WebViewAdPlayer.sendActivityDestroyed(..);
    }

    public Object sendFocusChange(boolean p0, Continuation p1) {
        webViewAdPlayer.sendFocusChange(p0, p1);
        return WebViewAdPlayer.sendFocusChange(..);
    }

    public Object sendMuteChange(boolean p0, Continuation p1) {
        webViewAdPlayer.sendMuteChange(p0, p1);
        return WebViewAdPlayer.sendMuteChange(..);
    }

    public Object sendPrivacyFsmChange(byte[] p0, Continuation p1) {
        webViewAdPlayer.sendPrivacyFsmChange(p0, p1);
        return WebViewAdPlayer.sendPrivacyFsmChange(..);
    }

    public Object sendUserConsentChange(byte[] p0, Continuation p1) {
        webViewAdPlayer.sendUserConsentChange(p0, p1);
        return WebViewAdPlayer.sendUserConsentChange(..);
    }

    public Object sendVisibilityChange(boolean p0, Continuation p1) {
        webViewAdPlayer.sendVisibilityChange(p0, p1);
        return WebViewAdPlayer.sendVisibilityChange(..);
    }

    public Object sendVolumeChange(double p0, Continuation p1) {
        webViewAdPlayer.sendVolumeChange(p0, v3, p1);
        return WebViewAdPlayer.sendVolumeChange(..);
    }

    public void show(ShowOptions p0) {
        if (if-eqz("showOptions")) goto L_c9;
        p0.getContext();
        BannerViewCache.getInstance();
        ProtobufExtensionsKt.toISO8859ByteString(opportunityId);
        ProtobufExtensionsKt.toUUID(ProtobufExtensionsKt.toISO8859ByteString(..));
        ProtobufExtensionsKt.toUUID(..).toString();
        BannerViewCache.getInstance(..).getBannerView(UUID.toString(..));
        if (if-eqz(BannerViewCache.getBannerView(..))) goto L_af;
        CoroutineScopeKt.MainScope();
        new AndroidEmbeddableWebViewAdPlayer$show$1(this, AndroidShowOptions.getContext(..), BannerViewCache.getBannerView(..), 0);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(..), 0, 0, new AndroidEmbeddableWebViewAdPlayer$show$1(..), 3, 0);
        AndroidEmbeddableWebViewAdPlayer.getWebViewContainer();
        AndroidWebViewContainer.getWebView();
        ViewCompat.isAttachedToWindow(AndroidWebViewContainer.getWebView(..));
        if (if-eqz(ViewCompat.isAttachedToWindow(..))) goto L_90;
        AndroidEmbeddableWebViewAdPlayer.access$getWebViewAdPlayer$p(this);
        WebViewAdPlayer.getScope();
        new AndroidEmbeddableWebViewAdPlayer$show$2$1(this, p0, 0);
        BuildersKt.launch$default(WebViewAdPlayer.getScope(..), 0, 0, new AndroidEmbeddableWebViewAdPlayer$show$2$1(..), 3, 0);
        ViewCompat.isAttachedToWindow(AndroidWebViewContainer.getWebView(..));
        if (if-nez(ViewCompat.isAttachedToWindow(..))) goto L_85;
        AndroidEmbeddableWebViewAdPlayer.access$getWebViewAdPlayer$p(this);
        WebViewAdPlayer.getScope();
        new AndroidEmbeddableWebViewAdPlayer$show$2$2$1(this, 0);
        BuildersKt.launch$default(WebViewAdPlayer.getScope(..), 0, 0, new AndroidEmbeddableWebViewAdPlayer$show$2$2$1(..), 3, 0);
      L_85:
        new AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1(AndroidWebViewContainer.getWebView(..), this);
        View.addOnAttachStateChangeListener(new AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1(..));
      L_90:
        new AndroidEmbeddableWebViewAdPlayer$show$$inlined$doOnAttach$1(AndroidWebViewContainer.getWebView(..), this, new AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1(..));
        View.addOnAttachStateChangeListener(new AndroidEmbeddableWebViewAdPlayer$show$$inlined$doOnAttach$1(..));
      L_9a:
        CoroutineScopeKt.MainScope();
        new AndroidEmbeddableWebViewAdPlayer$show$3(BannerViewCache.getBannerView(..), this, 0);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(..), 0, 0, new AndroidEmbeddableWebViewAdPlayer$show$3(..), 3, 0);
        return;
      L_af:
        new StringBuilder("BannerView not found for opportunityId: ");
        new StringBuilder(..).append(opportunityId);
        new StringBuilder(..).toString();
        StringBuilder.toString(..).toString();
        new IllegalStateException(Object.toString(..));
        throw new IllegalStateException(..);
      L_c9:
        "Failed requirement.".toString();
        new IllegalArgumentException(Object.toString(..));
        throw new IllegalArgumentException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidFullscreenWebViewAdPlayer {
    public static final AndroidFullscreenWebViewAdPlayer$Companion Companion;
    private static final MutableSharedFlow displayMessages;
    private final DeviceInfoRepository deviceInfoRepository;
    private final OpenMeasurementRepository openMeasurementRepository;
    private final String opportunityId;
    private final SessionRepository sessionRepository;
    private final WebViewAdPlayer webViewAdPlayer;
    private final AndroidWebViewContainer webViewContainer;

    static <clinit>() {
        new AndroidFullscreenWebViewAdPlayer$Companion(0);
        Companion = new AndroidFullscreenWebViewAdPlayer$Companion(..);
        SharedFlowKt.MutableSharedFlow$default(0, 0, 0, 7, 0);
        displayMessages = SharedFlowKt.MutableSharedFlow$default(..);
        return;
    }

    public AndroidFullscreenWebViewAdPlayer(WebViewAdPlayer p0, String p1, AndroidWebViewContainer p2, DeviceInfoRepository p3, SessionRepository p4, OpenMeasurementRepository p5) {
        new Object();
        webViewAdPlayer = p0;
        opportunityId = p1;
        webViewContainer = p2;
        deviceInfoRepository = p3;
        sessionRepository = p4;
        openMeasurementRepository = p5;
        return;
    }

    public static final MutableSharedFlow access$getDisplayMessages$cp() {
        return AndroidFullscreenWebViewAdPlayer.displayMessages;
    }

    public static final String access$getOpportunityId$p(AndroidFullscreenWebViewAdPlayer p0) {
        return opportunityId;
    }

    public static final WebViewAdPlayer access$getWebViewAdPlayer$p(AndroidFullscreenWebViewAdPlayer p0) {
        return webViewAdPlayer;
    }

    public static final Object access$handleSessionChange(AndroidFullscreenWebViewAdPlayer p0, SessionChange p1, Continuation p2) {
        p0.handleSessionChange(p1, p2);
        return AndroidFullscreenWebViewAdPlayer.handleSessionChange(..);
    }

    public static final Object access$handleVolumeSettingsChange(AndroidFullscreenWebViewAdPlayer p0, VolumeSettingsChange p1, Continuation p2) {
        p0.handleVolumeSettingsChange(p1, p2);
        return AndroidFullscreenWebViewAdPlayer.handleVolumeSettingsChange(..);
    }

    public static final Object access$show$displayEventsRouter(AndroidFullscreenWebViewAdPlayer p0, DisplayMessage p1, Continuation p2) {
        AndroidFullscreenWebViewAdPlayer.show$displayEventsRouter(p0, p1, p2);
        return AndroidFullscreenWebViewAdPlayer.show$displayEventsRouter(..);
    }

    private final Job displayEventsRouter(DisplayMessage p0) {
        AndroidFullscreenWebViewAdPlayer.getScope();
        new AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1(p0, this, 0);
        BuildersKt.launch$default(AndroidFullscreenWebViewAdPlayer.getScope(..), 0, 0, new AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1(..), 3, 0);
        return BuildersKt.launch$default(..);
    }

    private final Object handleSessionChange(SessionChange p0, Continuation p1) {
        if (if-eqz(v0)) goto L_23;
        p0.getValue();
        ByteString.toByteArray();
        webViewAdPlayer.sendUserConsentChange(ByteString.toByteArray(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(WebViewAdPlayer.sendUserConsentChange(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_20;
        return WebViewAdPlayer.sendUserConsentChange(..);
      L_20:
        return Unit.INSTANCE;
      L_23:
        if (if-eqz(webViewAdPlayer)) goto L_44;
        Unit.INSTANCE.getValue();
        ByteString.toByteArray();
        webViewAdPlayer.sendPrivacyFsmChange(ByteString.toByteArray(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..));
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(WebViewAdPlayer.sendPrivacyFsmChange(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_41;
        return WebViewAdPlayer.sendPrivacyFsmChange(..);
      L_41:
        return Unit.INSTANCE;
      L_44:
        return Unit.INSTANCE;
    }

    private final Object handleVolumeSettingsChange(VolumeSettingsChange p0, Continuation p1) {
        if (if-eqz(v0)) goto L_1a;
        p0.isMuted();
        webViewAdPlayer.sendMuteChange(VolumeSettingsChange$MuteChange.isMuted(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(WebViewAdPlayer.sendMuteChange(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_17;
        return WebViewAdPlayer.sendMuteChange(..);
      L_17:
        return Unit.INSTANCE;
      L_1a:
        if (if-eqz(webViewAdPlayer)) goto L_34;
        Unit.INSTANCE.getVolume();
        webViewAdPlayer.sendVolumeChange(VolumeSettingsChange$VolumeChange.getVolume(..), v2, IntrinsicsKt.getCOROUTINE_SUSPENDED(..));
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(WebViewAdPlayer.sendVolumeChange(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_31;
        return WebViewAdPlayer.sendVolumeChange(..);
      L_31:
        return Unit.INSTANCE;
      L_34:
        return Unit.INSTANCE;
    }

    private static final Object show$displayEventsRouter(AndroidFullscreenWebViewAdPlayer p0, DisplayMessage p1, Continuation p2) {
        p0.displayEventsRouter(p1);
        return Unit.INSTANCE;
    }

    public Object destroy(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidFullscreenWebViewAdPlayer$destroy$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_53;
        if (if-eq(label, 1)) goto L_4b;
        if (if-eq(label, 2)) goto L_43;
        if (if-eq(label, 3)) goto L_3b;
        if (if-ne(label, 4)) goto L_33;
        ResultKt.throwOnFailure(result);
      L_33:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_3b:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_43:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_4b:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_53:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        new DisplayMessage$DisplayFinishRequest(opportunityId);
        L$0 = this;
        label = 1;
        MutableSharedFlow.emit(new DisplayMessage$DisplayFinishRequest(..), "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(MutableSharedFlow.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_6a;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_6a:
      L_6b:
        ProtobufExtensionsKt.toISO8859ByteString(opportunityId);
        openMeasurementRepository.hasSessionFinished(ProtobufExtensionsKt.toISO8859ByteString(..));
        if (if-eqz(OpenMeasurementRepository.hasSessionFinished(..))) goto L_86;
        L$0 = this;
        label = 2;
        DelayKt.delay(1000L, ProtobufExtensionsKt.toISO8859ByteString(..), "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(DelayKt.delay(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_86;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_86:
        AndroidFullscreenWebViewAdPlayer.getWebViewContainer();
        L$0 = this;
        label = 3;
        AndroidWebViewContainer.destroy("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(AndroidWebViewContainer.destroy(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_95;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_95:
        L$0 = 0;
        label = 4;
        AdPlayer$DefaultImpls.destroy(this, "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(AdPlayer$DefaultImpls.destroy(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_a1;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_a1:
        return Unit.INSTANCE;
    }

    public void dispatchShowCompleted() {
        webViewAdPlayer.dispatchShowCompleted();
        return;
    }

    public Flow getOnLoadEvent() {
        webViewAdPlayer.getOnLoadEvent();
        return WebViewAdPlayer.getOnLoadEvent(..);
    }

    public Flow getOnShowEvent() {
        webViewAdPlayer.getOnShowEvent();
        return WebViewAdPlayer.getOnShowEvent(..);
    }

    public CoroutineScope getScope() {
        webViewAdPlayer.getScope();
        return WebViewAdPlayer.getScope(..);
    }

    public Flow getUpdateCampaignState() {
        webViewAdPlayer.getUpdateCampaignState();
        return WebViewAdPlayer.getUpdateCampaignState(..);
    }

    public AndroidWebViewContainer getWebViewContainer() {
        return webViewContainer;
    }

    public WebViewContainer getWebViewContainer() {
        AndroidFullscreenWebViewAdPlayer.getWebViewContainer();
        return AndroidFullscreenWebViewAdPlayer.getWebViewContainer(..);
    }

    public Object onAllowedPiiChange(byte[] p0, Continuation p1) {
        webViewAdPlayer.onAllowedPiiChange(p0, p1);
        return WebViewAdPlayer.onAllowedPiiChange(..);
    }

    public Object onBroadcastEvent(String p0, Continuation p1) {
        webViewAdPlayer.onBroadcastEvent(p0, p1);
        return WebViewAdPlayer.onBroadcastEvent(..);
    }

    public Object requestShow(Map p0, Continuation p1) {
        webViewAdPlayer.requestShow(p0, p1);
        return WebViewAdPlayer.requestShow(..);
    }

    public Object sendActivityDestroyed(Continuation p0) {
        webViewAdPlayer.sendActivityDestroyed(p0);
        return WebViewAdPlayer.sendActivityDestroyed(..);
    }

    public Object sendFocusChange(boolean p0, Continuation p1) {
        webViewAdPlayer.sendFocusChange(p0, p1);
        return WebViewAdPlayer.sendFocusChange(..);
    }

    public Object sendMuteChange(boolean p0, Continuation p1) {
        webViewAdPlayer.sendMuteChange(p0, p1);
        return WebViewAdPlayer.sendMuteChange(..);
    }

    public Object sendPrivacyFsmChange(byte[] p0, Continuation p1) {
        webViewAdPlayer.sendPrivacyFsmChange(p0, p1);
        return WebViewAdPlayer.sendPrivacyFsmChange(..);
    }

    public Object sendUserConsentChange(byte[] p0, Continuation p1) {
        webViewAdPlayer.sendUserConsentChange(p0, p1);
        return WebViewAdPlayer.sendUserConsentChange(..);
    }

    public Object sendVisibilityChange(boolean p0, Continuation p1) {
        webViewAdPlayer.sendVisibilityChange(p0, p1);
        return WebViewAdPlayer.sendVisibilityChange(..);
    }

    public Object sendVolumeChange(double p0, Continuation p1) {
        webViewAdPlayer.sendVolumeChange(p0, v3, p1);
        return WebViewAdPlayer.sendVolumeChange(..);
    }

    public void show(ShowOptions p0) {
        if (if-eqz(v1)) goto L_b6;
        p0.getContext();
        new Intent(AndroidShowOptions.getContext(..), FullScreenWebViewDisplay.class);
        new Intent(..).putExtra("opportunityId", opportunityId);
        p0.getUnityAdsShowOptions();
        if (if-eqz(AndroidShowOptions.getUnityAdsShowOptions(..))) goto L_2f;
        new JSONObject(AndroidShowOptions.getUnityAdsShowOptions(..));
        new JSONObject(..).toString();
        new Intent(..).putExtra("showOptions", JSONObject.toString(..));
      L_2f:
        new Intent(..).addFlags(0x10010000);
        AndroidShowOptions.getContext(..).getResources();
        Context.getResources(..).getConfiguration();
        new Intent(..).putExtra("orientation", orientation);
        new AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1(AndroidFullscreenWebViewAdPlayer.displayMessages, this);
        new AndroidFullscreenWebViewAdPlayer$show$2(this);
        FlowKt.onEach(new AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1(..), new AndroidFullscreenWebViewAdPlayer$show$2(..));
        AndroidFullscreenWebViewAdPlayer.getScope();
        FlowKt.launchIn(FlowKt.onEach(..), AndroidFullscreenWebViewAdPlayer.getScope(..));
        deviceInfoRepository.getVolumeSettingsChange();
        new AndroidFullscreenWebViewAdPlayer$show$3(this);
        FlowKt.onEach(DeviceInfoRepository.getVolumeSettingsChange(..), new AndroidFullscreenWebViewAdPlayer$show$3(..));
        AndroidFullscreenWebViewAdPlayer.getScope();
        FlowKt.launchIn(FlowKt.onEach(..), AndroidFullscreenWebViewAdPlayer.getScope(..));
        webViewAdPlayer.getOnShowEvent();
        new AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2(WebViewAdPlayer.getOnShowEvent(..));
        new AndroidFullscreenWebViewAdPlayer$show$5(this, 0);
        FlowKt.onEach(new AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2(..), new AndroidFullscreenWebViewAdPlayer$show$5(..));
        AndroidFullscreenWebViewAdPlayer.getScope();
        FlowKt.launchIn(FlowKt.onEach(..), AndroidFullscreenWebViewAdPlayer.getScope(..));
        sessionRepository.getOnChange();
        new AndroidFullscreenWebViewAdPlayer$show$6(this);
        FlowKt.onEach(SessionRepository.getOnChange(..), new AndroidFullscreenWebViewAdPlayer$show$6(..));
        AndroidFullscreenWebViewAdPlayer.getScope();
        FlowKt.launchIn(FlowKt.onEach(..), AndroidFullscreenWebViewAdPlayer.getScope(..));
        AndroidShowOptions.getContext(..).startActivity(new Intent(..));
        return;
      L_b6:
        "Failed requirement.".toString();
        new IllegalArgumentException(Object.toString(..));
        throw new IllegalArgumentException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidShowOptions
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidShowOptions {
    private final Context context;
    private final Map unityAdsShowOptions;

    public AndroidShowOptions(Context p0, Map p1) {
        new Object();
        context = p0;
        unityAdsShowOptions = p1;
        return;
    }

    public static AndroidShowOptions copy$default(AndroidShowOptions p0, Context p1, Map p2, int p3, Object p4) {
        if (if-eqz(p4)) goto L_6;
      L_6:
        if (if-eqz(p3)) goto L_c;
      L_c:
        p0.copy(context, unityAdsShowOptions);
        return AndroidShowOptions.copy(..);
    }

    public final Context component1() {
        return context;
    }

    public final Map component2() {
        return unityAdsShowOptions;
    }

    public final AndroidShowOptions copy(Context p0, Map p1) {
        new AndroidShowOptions(p0, p1);
        return new AndroidShowOptions(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(context, context);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        Intrinsics.areEqual(unityAdsShowOptions, unityAdsShowOptions);
        if (if-nez(Intrinsics.areEqual(..))) goto L_22;
        return 0;
      L_22:
        return 1;
    }

    public final Context getContext() {
        return context;
    }

    public final Map getUnityAdsShowOptions() {
        return unityAdsShowOptions;
    }

    public int hashCode() {
        context.hashCode();
        if (if-nez(unityAdsShowOptions)) goto L_e;
      L_e:
        0.hashCode();
      L_12:
        return Context.hashCode(..);
    }

    public String toString() {
        new StringBuilder("AndroidShowOptions(context=");
        new StringBuilder(..).append(context);
        new StringBuilder(..).append(", unityAdsShowOptions=");
        new StringBuilder(..).append(unityAdsShowOptions);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewClient
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidWebViewClient extends WebViewClientCompat {
    public static final String BLANK_PAGE = "about:blank";
    public static final AndroidWebViewClient$Companion Companion;
    private final MutableStateFlow _isRenderProcessGone;
    private final CompletableDeferred _onLoadFinished;
    private final WebViewAssetLoader adAssetLoader;
    private final GetCachedAsset getCachedAsset;
    private final StateFlow isRenderProcessGone;
    private final MutableStateFlow loadErrors;
    private final Deferred onLoadFinished;
    private final WebViewAssetLoader webViewAssetLoader;

    static <clinit>() {
        new AndroidWebViewClient$Companion(0);
        Companion = new AndroidWebViewClient$Companion(..);
        return;
    }

    public AndroidWebViewClient(GetWebViewCacheAssetLoader p0, GetAdAssetLoader p1, GetCachedAsset p2) {
        new WebViewClientCompat();
        getCachedAsset = p2;
        p0.invoke();
        webViewAssetLoader = GetWebViewCacheAssetLoader.invoke(..);
        p1.invoke();
        adAssetLoader = GetAdAssetLoader.invoke(..);
        CollectionsKt.emptyList();
        StateFlowKt.MutableStateFlow(CollectionsKt.emptyList(..));
        loadErrors = StateFlowKt.MutableStateFlow(..);
        CompletableDeferredKt.CompletableDeferred$default(0, 1, 0);
        _onLoadFinished = CompletableDeferredKt.CompletableDeferred$default(..);
        onLoadFinished = CompletableDeferredKt.CompletableDeferred$default(..);
        Boolean.valueOf(0);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        _isRenderProcessGone = StateFlowKt.MutableStateFlow(..);
        FlowKt.asStateFlow(StateFlowKt.MutableStateFlow(..));
        isRenderProcessGone = FlowKt.asStateFlow(..);
        return;
    }

    public final Deferred getOnLoadFinished() {
        return onLoadFinished;
    }

    public final StateFlow isRenderProcessGone() {
        return isRenderProcessGone;
    }

    public void onPageFinished(WebView p0, String p1) {
        Intrinsics.areEqual(p1, "about:blank");
        if (if-eqz(Intrinsics.areEqual(..))) goto L_33;
      L_14:
        loadErrors.getValue();
        new WebViewClientError(p1, ErrorReason.REASON_WEB_BLANK, 0, 4, 0);
        CollectionsKt.plus(MutableStateFlow.getValue(..), new WebViewClientError);
        loadErrors.compareAndSet(MutableStateFlow.getValue(..), CollectionsKt.plus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_14;
      L_33:
        WebViewClientCompat.onPageFinished(p0, p1);
        loadErrors.getValue();
        _onLoadFinished.complete(MutableStateFlow.getValue(..));
        return;
    }

    public void onReceivedError(WebView p0, WebResourceRequest p1, WebResourceErrorCompat p2) {
        WebViewClientCompat.onReceivedError(p0, p1, p2);
        WebViewFeature.isFeatureSupported("WEB_RESOURCE_ERROR_GET_CODE");
        if (if-eqz(WebViewFeature.isFeatureSupported(..))) goto L_23;
        p2.getErrorCode();
        IntExtensionKt.webResourceToErrorReason(WebResourceErrorCompat.getErrorCode(..));
      L_23:
      L_25:
      L_27:
        loadErrors.getValue();
        p1.getUrl();
        WebResourceRequest.getUrl(..).toString();
        new WebViewClientError(Uri.toString(..), ErrorReason.REASON_UNKNOWN, 0, 4, 0);
        CollectionsKt.plus(MutableStateFlow.getValue(..), new WebViewClientError);
        loadErrors.compareAndSet(MutableStateFlow.getValue(..), CollectionsKt.plus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_27;
        return;
    }

    public void onReceivedHttpError(WebView p0, WebResourceRequest p1, WebResourceResponse p2) {
        WebViewClientCompat.onReceivedHttpError(p0, p1, p2);
        p1.getUrl();
        WebResourceRequest.getUrl(..).toString();
        p2.getStatusCode();
        Integer.valueOf(WebResourceResponse.getStatusCode(..));
        new WebViewClientError(Uri.toString(..), ErrorReason.REASON_WEB_ERROR_RECEIVED_HTTP, Integer.valueOf(..));
      L_2b:
        loadErrors.getValue();
        CollectionsKt.plus(MutableStateFlow.getValue(..), new WebViewClientError(..));
        loadErrors.compareAndSet(MutableStateFlow.getValue(..), CollectionsKt.plus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2b;
        return;
    }

    public boolean onRenderProcessGone(WebView p0, RenderProcessGoneDetail p1) {
        ViewExtensionsKt.removeViewFromParent(p0);
        p0.destroy();
        _onLoadFinished.isCompleted();
        if (if-nez(CompletableDeferred.isCompleted(..))) goto L_50;
      L_1e:
        loadErrors.getValue();
        p0.getUrl();
        String.valueOf(WebView.getUrl(..));
        new WebViewClientError(String.valueOf(..), ErrorReason.REASON_WEBVIEW_RENDER_PROCESS_GONE, 0, 4, 0);
        CollectionsKt.plus(MutableStateFlow.getValue(..), new WebViewClientError);
        loadErrors.compareAndSet(MutableStateFlow.getValue(..), CollectionsKt.plus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_1e;
        loadErrors.getValue();
        _onLoadFinished.complete(MutableStateFlow.getValue(..));
      L_50:
        Boolean.valueOf(1);
        _isRenderProcessGone.setValue(Boolean.valueOf(..));
      L_59:
        return 1;
    }

    public WebResourceResponse shouldInterceptRequest(WebView p0, WebResourceRequest p1) {
        p1.getUrl();
        if (if-nez(WebResourceRequest.getUrl(..))) goto L_15;
        WebViewClientCompat.shouldInterceptRequest(p0, p1);
        return WebViewClientCompat.shouldInterceptRequest(..);
      L_15:
        WebResourceRequest.getUrl(..).getLastPathSegment();
        Intrinsics.areEqual(Uri.getLastPathSegment(..), "favicon.ico");
        if (if-eqz(Intrinsics.areEqual(..))) goto L_2a;
        new WebResourceResponse("image/png", 0, 0);
        return new WebResourceResponse(..);
      L_2a:
        0.getScheme();
        Intrinsics.areEqual(Uri.getScheme(..), "unity-ads-cache");
        if (if-eqz(Intrinsics.areEqual(..))) goto L_46;
        "image/png".getUrl();
        getCachedAsset.invoke(WebResourceRequest.getUrl(..));
        return GetCachedAsset.invoke(..);
      L_46:
        "request.url".getHost();
        if (if-eqz(Uri.getHost(..))) goto L_7b;
        Uri.getHost(..).hashCode();
        if (if-eq(String.hashCode(..), -598289184)) goto L_6b;
        if (if-eq(String.hashCode(..), 380656434)) goto L_5b;
      L_5b:
        Uri.getHost(..).equals("config.unityads.unity3d.com");
        if (if-nez(String.equals(..))) goto L_64;
      L_64:
        webViewAssetLoader.shouldInterceptRequest("request.url");
      L_6b:
        String.equals(..).equals("cdn-creatives-cf-prd.acquire.unity3dusercontent.com");
        if (if-nez(String.equals(..))) goto L_74;
      L_74:
        adAssetLoader.shouldInterceptRequest("request.url");
      L_7b:
        WebViewClientCompat.shouldInterceptRequest(WebViewAssetLoader.shouldInterceptRequest(..), WebResourceRequest.getUrl(..));
      L_7f:
        return WebViewClientCompat.shouldInterceptRequest(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidWebViewContainer {
    private final MutableStateFlow _lastInputEvent;
    private final StateFlow lastInputEvent;
    private final CoroutineScope scope;
    private final SendWebViewClientErrorDiagnostics sendWebViewClientErrorDiagnostics;
    private final WebView webView;
    private final AndroidWebViewClient webViewClient;

    public static boolean $r8$lambda$_3YY2a52SkBfEwm1Nb9pl4chmSs(AndroidWebViewContainer p0, View p1, MotionEvent p2) {
        AndroidWebViewContainer._init_$lambda$1(p0, p1, p2);
        return AndroidWebViewContainer._init_$lambda$1(..);
    }

    public AndroidWebViewContainer(WebView p0, AndroidWebViewClient p1, SendWebViewClientErrorDiagnostics p2, CoroutineDispatcher p3, CoroutineDispatcher p4, CoroutineScope p5) {
        new Object();
        webView = p0;
        webViewClient = p1;
        sendWebViewClientErrorDiagnostics = p2;
        CoroutineScopeKt.plus(p5, p3);
        new CoroutineName("AndroidWebViewContainer");
        CoroutineScopeKt.plus(CoroutineScopeKt.plus(..), new CoroutineName(..));
        scope = CoroutineScopeKt.plus(..);
        StateFlowKt.MutableStateFlow(0);
        _lastInputEvent = StateFlowKt.MutableStateFlow(..);
        FlowKt.asStateFlow(StateFlowKt.MutableStateFlow(..));
        lastInputEvent = FlowKt.asStateFlow(..);
        p1.isRenderProcessGone();
        new AndroidWebViewContainer$special$$inlined$filter$1(AndroidWebViewClient.isRenderProcessGone(..));
        new AndroidWebViewContainer$2(new Object(..), 0);
        FlowKt.onEach(new AndroidWebViewContainer$special$$inlined$filter$1(..), new AndroidWebViewContainer$2(..));
        CoroutineScopeKt.plus(CoroutineScopeKt.plus(..), p4);
        FlowKt.launchIn(FlowKt.onEach(..), CoroutineScopeKt.plus(..));
        new AndroidWebViewContainer$$ExternalSyntheticLambda0(new Object(..));
        p0.setOnTouchListener(new AndroidWebViewContainer$$ExternalSyntheticLambda0(..));
        return;
    }

    private static final boolean _init_$lambda$1(AndroidWebViewContainer p0, View p1, MotionEvent p2) {
        p2.getActionMasked();
        if (if-eqz(MotionEvent.getActionMasked(..))) goto L_15;
        if (if-eq(MotionEvent.getActionMasked(..), 1)) goto L_15;
        if (if-eq(MotionEvent.getActionMasked(..), 5)) goto L_15;
        if (if-eq(MotionEvent.getActionMasked(..), 6)) goto L_15;
      L_15:
        _lastInputEvent.setValue(p2);
      L_1a:
        return 0;
    }

    public static final Object access$onRenderProcessGone(AndroidWebViewContainer p0, Continuation p1) {
        p0.onRenderProcessGone(p1);
        return AndroidWebViewContainer.onRenderProcessGone(..);
    }

    private final Object onRenderProcessGone(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidWebViewContainer$onRenderProcessGone$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_36;
        if (if-ne(label, 1)) goto L_2e;
        ResultKt.throwOnFailure(result);
      L_2e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_36:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        L$0 = this;
        label = 1;
        AndroidWebViewContainer.destroy("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(AndroidWebViewContainer.destroy(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_44;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_44:
      L_45:
        new WebViewClientError("Render process gone", ErrorReason.REASON_WEBVIEW_RENDER_PROCESS_GONE, 0, 4, 0);
        CollectionsKt.listOf(new WebViewClientError);
        sendWebViewClientErrorDiagnostics.invoke(CollectionsKt.listOf(..));
        return Unit.INSTANCE;
    }

    public Object addJavascriptInterface(WebViewBridge p0, String p1, Continuation p2) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidWebViewContainer$addJavascriptInterface$1(this, label);
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
        scope.getCoroutineContext();
        new AndroidWebViewContainer$addJavascriptInterface$2(this, "call to 'resume' before 'invoke' with coroutine", new IllegalStateException(..), 0);
        label = 1;
        BuildersKt.withContext(CoroutineScope.getCoroutineContext(..), new AndroidWebViewContainer$addJavascriptInterface$2(..), new AndroidWebViewContainer$addJavascriptInterface$1(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4c;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4c:
        return Unit.INSTANCE;
    }

    public Object destroy(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidWebViewContainer$destroy$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_37;
        if (if-ne(label, 1)) goto L_2f;
        ResultKt.throwOnFailure(result);
      L_2f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_37:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        scope.getCoroutineContext();
        CoroutineContext.plus(NonCancellable.INSTANCE);
        new AndroidWebViewContainer$destroy$2(this, 0);
        L$0 = this;
        label = 1;
        BuildersKt.withContext(CoroutineContext.plus(..), new AndroidWebViewContainer$destroy$2(..), "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_5a;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_5a:
      L_5b:
        CoroutineScopeKt.cancel$default(scope, 0, 1, 0);
        return Unit.INSTANCE;
    }

    public Object evaluateJavascript(String p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidWebViewContainer$evaluateJavascript$1(this, label);
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
        scope.getCoroutineContext();
        new AndroidWebViewContainer$evaluateJavascript$2(this, new IllegalStateException(..), 0);
        label = 1;
        BuildersKt.withContext(CoroutineScope.getCoroutineContext(..), new AndroidWebViewContainer$evaluateJavascript$2(..), new AndroidWebViewContainer$evaluateJavascript$1(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4c;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4c:
        return Unit.INSTANCE;
    }

    public StateFlow getLastInputEvent() {
        return lastInputEvent;
    }

    public final CoroutineScope getScope() {
        return scope;
    }

    public final WebView getWebView() {
        return webView;
    }

    public final MutableStateFlow get_lastInputEvent() {
        return _lastInputEvent;
    }

    public Object loadUrl(String p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidWebViewContainer$loadUrl$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_50;
        if (if-eq(label, 1)) goto L_48;
        if (if-eq(label, 2)) goto L_40;
        if (if-eq(label, 3)) goto L_34;
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_34:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_40:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_48:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_50:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        scope.getCoroutineContext();
        new AndroidWebViewContainer$loadUrl$2(this, L$0, 0);
        L$0 = this;
        label = 1;
        BuildersKt.withContext(CoroutineScope.getCoroutineContext(..), new AndroidWebViewContainer$loadUrl$2(..), L$0);
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_6c;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_6c:
      L_6d:
        webViewClient.getOnLoadFinished();
        L$0 = this;
        label = 2;
        Deferred.await(L$0);
        if (if-ne(Deferred.await(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_7e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_7e:
        Deferred.await(..).isEmpty();
        if (if-eqz(Collection.isEmpty(..))) goto L_a4;
        L$0 = this;
        L$1 = Deferred.await(..);
        label = 3;
        AndroidWebViewContainer.destroy(L$0);
        if (if-ne(AndroidWebViewContainer.destroy(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_97;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_97:
      L_99:
        sendWebViewClientErrorDiagnostics.invoke(Deferred.await(..));
        new LoadWebViewError(Deferred.await(..));
        throw new LoadWebViewError(..);
      L_a4:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.CommonWebViewBridge
// ============================================================
package com.unity3d.ads.adplayer;

public final class CommonWebViewBridge {
    private final MutableSharedFlow _onInvocation;
    private final MutableStateFlow callbacks;
    private final SharedFlow onInvocation;
    private final CoroutineScope scope;
    private final WebViewContainer webViewContainer;

    public CommonWebViewBridge(CoroutineDispatcher p0, WebViewContainer p1, CoroutineScope p2) {
        new Object();
        webViewContainer = p1;
        CoroutineScopeKt.plus(p2, p0);
        new CoroutineName("CommonWebViewBridge");
        CoroutineScopeKt.plus(CoroutineScopeKt.plus(..), new CoroutineName(..));
        scope = CoroutineScopeKt.plus(..);
        SetsKt.emptySet();
        StateFlowKt.MutableStateFlow(SetsKt.emptySet(..));
        callbacks = StateFlowKt.MutableStateFlow(..);
        SharedFlowKt.MutableSharedFlow$default(0, 0, 0, 7, 0);
        _onInvocation = SharedFlowKt.MutableSharedFlow$default(..);
        FlowKt.asSharedFlow(SharedFlowKt.MutableSharedFlow$default(..));
        onInvocation = FlowKt.asSharedFlow(..);
        new CommonWebViewBridge$1(new Object(..), 0);
        BuildersKt.launch$default(CoroutineScopeKt.plus(..), 0, 0, new CommonWebViewBridge$1(..), 3, 0);
        return;
    }

    public static final Object access$execute(CommonWebViewBridge p0, HandlerType p1, String p2, Continuation p3) {
        p0.execute(p1, p2, p3);
        return CommonWebViewBridge.execute(..);
    }

    public static final WebViewContainer access$getWebViewContainer$p(CommonWebViewBridge p0) {
        return webViewContainer;
    }

    public static final MutableSharedFlow access$get_onInvocation$p(CommonWebViewBridge p0) {
        return _onInvocation;
    }

    public static final Object access$respond(CommonWebViewBridge p0, String p1, String p2, Object[] p3, Continuation p4) {
        p0.respond(p1, p2, p3, p4);
        return CommonWebViewBridge.respond(..);
    }

    private final Object execute(HandlerType p0, String p1, Continuation p2) {
        new StringBuilder("window.nativebridge.");
        p0.getJsPath();
        new StringBuilder(..).append(HandlerType.getJsPath(..));
        new StringBuilder(..).append(40);
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(");");
        new StringBuilder(..).toString();
        webViewContainer.evaluateJavascript(StringBuilder.toString(..), p2);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(WebViewContainer.evaluateJavascript(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_2c;
        return WebViewContainer.evaluateJavascript(..);
      L_2c:
        return Unit.INSTANCE;
    }

    private final Object respond(String p0, String p1, Object[] p2, Continuation p3) {
        new JSONArray();
        new JSONArray(..).put(p0);
        new JSONArray(..).put(p1);
        new JSONArray(p2);
        new JSONArray(..).put(new JSONArray(..));
        new StringBuilder("[");
        new StringBuilder(..).append(new JSONArray(..));
        new StringBuilder(..).append(93);
        new StringBuilder(..).toString();
        CommonWebViewBridge.execute(HandlerType.CALLBACK, StringBuilder.toString(..), p3);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(CommonWebViewBridge.execute(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_33;
        return CommonWebViewBridge.execute(..);
      L_33:
        return Unit.INSTANCE;
    }

    public SharedFlow getOnInvocation() {
        return onInvocation;
    }

    public final CoroutineScope getScope() {
        return scope;
    }

    public void handleCallback(String p0, String p1, String p2) {
        new JSONArray(p2);
        JSONArrayExtensionsKt.toTypedArray(new JSONArray(..));
        callbacks.getValue();
        MutableStateFlow.getValue(..).iterator();
      L_24:
        Iterable.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_3e;
        Iterable.iterator(..).next();
        Iterator.next(..).component1();
        Intrinsics.areEqual(Pair.component1(..), p0);
        if (if-eqz(Intrinsics.areEqual(..))) goto L_24;
      L_3e:
      L_3f:
        if (if-nez(0)) goto L_44;
        return;
      L_44:
        0.component2();
        Intrinsics.areEqual(p1, "success");
        if (if-eqz(Intrinsics.areEqual(..))) goto L_56;
        Pair.component2(..).complete(JSONArrayExtensionsKt.toTypedArray(..));
      L_56:
        Intrinsics.areEqual(p1, "error");
        if (if-eqz(Intrinsics.areEqual(..))) goto L_72;
        Intrinsics.checkNotNull(JSONArrayExtensionsKt.toTypedArray(..), "null cannot be cast to non-null type kotlin.String");
        new Exception(JSONArrayExtensionsKt.toTypedArray(..));
        Pair.component2(..).completeExceptionally(new Exception(..));
      L_72:
      L_74:
        callbacks.getValue();
        SetsKt.minus(MutableStateFlow.getValue(..), 0);
        callbacks.compareAndSet(MutableStateFlow.getValue(..), SetsKt.minus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_74;
        return;
    }

    public void handleInvocation(String p0) {
        new JSONArray(p0);
        new JSONArray(..).length();
      L_12:
        if (if-ge(0, JSONArray.length(..))) goto L_9c;
        new JSONArray(..).get(0);
        Intrinsics.checkNotNull(JSONArray.get(..), "null cannot be cast to non-null type org.json.JSONArray");
        JSONArray.get(..).get(0);
        Intrinsics.checkNotNull(JSONArray.get(..), "null cannot be cast to non-null type kotlin.String");
        JSONArray.get(..).get(1);
        Intrinsics.checkNotNull(JSONArray.get(..), "null cannot be cast to non-null type kotlin.String");
        JSONArray.get(..).get(2);
        Intrinsics.checkNotNull(JSONArray.get(..), "null cannot be cast to non-null type org.json.JSONArray");
        JSONArray.get(..).get(3);
        Intrinsics.checkNotNull(JSONArray.get(..), "null cannot be cast to non-null type kotlin.String");
        new StringBuilder("Unity Ads WebView calling for: ");
        new StringBuilder(..).append(JSONArray.get(..));
        new StringBuilder(..).append(46);
        new StringBuilder(..).append(JSONArray.get(..));
        new StringBuilder(..).append(40);
        new StringBuilder(..).append(JSONArray.get(..));
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        new StringBuilder();
        new StringBuilder(..).append(JSONArray.get(..));
        new StringBuilder(..).append(46);
        new StringBuilder(..).append(JSONArray.get(..));
        new StringBuilder(..).toString();
        new CommonWebViewBridge$handleInvocation$1(StringBuilder.toString(..), JSONArray.get(..), this, JSONArray.get(..), 0);
        BuildersKt.launch$default(scope, 0, 0, new CommonWebViewBridge$handleInvocation$1, 3, 0);
      L_9c:
        return;
    }

    public Object request(String p0, String p1, Object[] p2, Continuation p3) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new CommonWebViewBridge$request$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_3e;
        if (if-eq(label, 1)) goto L_36;
        if (if-ne(label, 2)) goto L_2e;
        ResultKt.throwOnFailure(result);
      L_2e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_36:
        ResultKt.throwOnFailure(result);
      L_3e:
        ResultKt.throwOnFailure(result);
        CompletableDeferredKt.CompletableDeferred$default(0, 1, 0);
        Object.hashCode();
        String.valueOf(Object.hashCode(..));
      L_4f:
        callbacks.getValue();
        TuplesKt.to(String.valueOf(..), CompletableDeferredKt.CompletableDeferred$default(..));
        SetsKt.plus(MutableStateFlow.getValue(..), TuplesKt.to(..));
        callbacks.compareAndSet(MutableStateFlow.getValue(..), SetsKt.plus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_4f;
        new JSONArray();
        new JSONArray(..).put(L$0);
        new JSONArray(..).put("call to 'resume' before 'invoke' with coroutine");
        new JSONArray(..).put(String.valueOf(..));
      L_74:
        if (if-ge(0, L$0)) goto L_7e;
        new JSONArray(..).put(String.valueOf(..));
      L_7e:
        new JSONArray(..).toString();
        L$0 = CompletableDeferredKt.CompletableDeferred$default(..);
        label = 1;
        CommonWebViewBridge.execute(HandlerType.INVOCATION, JSONArray.toString(..), new CommonWebViewBridge$request$1(..));
        if (if-ne(CommonWebViewBridge.execute(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_94;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_94:
      L_95:
        L$0 = 0;
        label = 2;
        CompletableDeferred.await(new CommonWebViewBridge$request$1(..));
        if (if-ne(CompletableDeferred.await(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_a0;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_a0:
        return CompletableDeferred.await(..);
    }

    public Object sendEvent(WebViewEvent p0, Continuation p1) {
        new JSONArray();
        p0.getCategory();
        new JSONArray(..).put(WebViewEvent.getCategory(..));
        p0.getName();
        new JSONArray(..).put(WebViewEvent.getName(..));
        p0.getParameters();
      L_19:
        if (if-ge(0, WebViewEvent.getName(..))) goto L_23;
        new JSONArray(..).put(v3);
      L_23:
        new JSONArray(..).toString();
        CommonWebViewBridge.execute(HandlerType.EVENT, JSONArray.toString(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(CommonWebViewBridge.execute(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_39;
        return CommonWebViewBridge.execute(..);
      L_39:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.DisplayMessage
// ============================================================
package com.unity3d.ads.adplayer;

public abstract class DisplayMessage {
    private final String opportunityId;

    private DisplayMessage(String p0) {
        new Object();
        opportunityId = p0;
        return;
    }

    public DisplayMessage(String p0, DefaultConstructorMarker p1) {
        new DisplayMessage(p0);
        return;
    }

    public final String getOpportunityId() {
        return opportunityId;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.EmbeddableAdPlayer
// ============================================================
package com.unity3d.ads.adplayer;

public abstract class EmbeddableAdPlayer {
}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.ExposedFunction
// ============================================================
package com.unity3d.ads.adplayer;

public abstract class ExposedFunction {
}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.ExposedFunctionLocation
// ============================================================
package com.unity3d.ads.adplayer;

public final class ExposedFunctionLocation {
    public static final String ATTRIBUTION_REGISTER_CLICK = "com.unity3d.services.ads.api.AdViewer.attributionRegisterClick";
    public static final String ATTRIBUTION_REGISTER_VIEW = "com.unity3d.services.ads.api.AdViewer.attributionRegisterView";
    public static final String BROADCAST_EVENT = "com.unity3d.services.ads.api.AdViewer.broadcastEvent";
    public static final String CANCEL_SHOW_TIMEOUT = "com.unity3d.services.ads.api.AdViewer.cancelShowTimeout";
    public static final String CLICKED = "com.unity3d.services.ads.api.AdViewer.clicked";
    public static final String COMPLETED = "com.unity3d.services.ads.api.AdViewer.completed";
    public static final String DOWNLOAD = "com.unity3d.services.ads.api.AdViewer.download";
    public static final String FAILED = "com.unity3d.services.ads.api.AdViewer.failed";
    public static final String GET_AD_CONTEXT = "com.unity3d.services.ads.api.AdViewer.getAdContext";
    public static final String GET_ALLOWED_PII = "com.unity3d.services.ads.api.AdViewer.getPrivacyAllowedPii";
    public static final String GET_CONNECTION_TYPE = "com.unity3d.services.core.api.DeviceInfo.getConnectionType";
    public static final String GET_DEVICE_MAX_VOLUME = "com.unity3d.services.core.api.DeviceInfo.getDeviceMaxVolume";
    public static final String GET_DEVICE_VOLUME = "com.unity3d.services.core.api.DeviceInfo.getDeviceVolume";
    public static final String GET_PRIVACY = "com.unity3d.services.ads.api.AdViewer.getPrivacyPayload";
    public static final String GET_PRIVACY_FSM = "com.unity3d.services.ads.api.AdViewer.getPrivacyFsm";
    public static final String GET_SCREEN_HEIGHT = "com.unity3d.services.core.api.DeviceInfo.getScreenHeight";
    public static final String GET_SCREEN_WIDTH = "com.unity3d.services.core.api.DeviceInfo.getScreenWidth";
    public static final String GET_SESSION_TOKEN = "com.unity3d.services.ads.api.AdViewer.getSessionToken";
    public static final String HEADER_BIDDING_TOKEN_INCREMENT_STARTS = "com.unity3d.services.ads.api.AdViewer.hbTokenIncrementStarts";
    public static final String HEADER_BIDDING_TOKEN_INCREMENT_WINS = "com.unity3d.services.ads.api.AdViewer.hbTokenIncrementWins";
    public static final String HEADER_BIDDING_TOKEN_RESET = "com.unity3d.services.ads.api.AdViewer.hbTokenReset";
    public static final String INCREMENT_BANNER_IMPRESSION_COUNT = "com.unity3d.services.ads.api.AdViewer.incrementBannerImpressionCount";
    public static final ExposedFunctionLocation INSTANCE = null;
    public static final String IS_ATTRIBUTION_AVAILABLE = "com.unity3d.services.ads.api.AdViewer.isAttributionAvailable";
    public static final String IS_FILE_CACHED = "com.unity3d.services.ads.api.AdViewer.isFileCached";
    public static final String LEFT_APPLICATION = "com.unity3d.services.ads.api.AdViewer.leftApplication";
    public static final String LOAD_COMPLETE = "com.unity3d.services.ads.api.AdViewer.loadComplete";
    public static final String LOAD_ERROR = "com.unity3d.services.ads.api.AdViewer.loadError";
    public static final String MARK_CAMPAIGN_STATE_SHOWN = "com.unity3d.services.ads.api.AdViewer.markCampaignStateAsShown";
    public static final String OM_FINISH_SESSION = "com.unity3d.services.ads.api.AdViewer.omidFinishSession";
    public static final String OM_GET_DATA = "com.unity3d.services.ads.api.AdViewer.omidGetData";
    public static final String OM_IMPRESSION = "com.unity3d.services.ads.api.AdViewer.omidImpression";
    public static final String OM_START_SESSION = "com.unity3d.services.ads.api.AdViewer.omidStartSession";
    public static final String OPEN_URL = "com.unity3d.services.ads.api.AdViewer.openUrl";
    public static final String REFRESH_AD_DATA = "com.unity3d.services.ads.api.AdViewer.refreshAdData";
    public static final String REQUEST_GET = "com.unity3d.services.core.api.Request.get";
    public static final String REQUEST_HEAD = "com.unity3d.services.core.api.Request.head";
    public static final String REQUEST_POST = "com.unity3d.services.core.api.Request.post";
    public static final String SEND_DIAGNOSTIC_EVENT = "com.unity3d.services.ads.api.AdViewer.sendDiagnosticEvent";
    public static final String SEND_OPERATIVE_EVENT = "com.unity3d.services.ads.api.AdViewer.sendOperativeEvent";
    public static final String SEND_PRIVACY_UPDATE_REQUEST = "com.unity3d.services.ads.api.AdViewer.sendPrivacyUpdateRequest";
    public static final String SET_ALLOWED_PII = "com.unity3d.services.ads.api.AdViewer.setPrivacyAllowedPii";
    public static final String SET_PRIVACY = "com.unity3d.services.ads.api.AdViewer.setPrivacyPayload";
    public static final String SET_PRIVACY_FSM = "com.unity3d.services.ads.api.AdViewer.setPrivacyFsm";
    public static final String STARTED = "com.unity3d.services.ads.api.AdViewer.started";
    public static final String STORAGE_CLEAR = "com.unity3d.services.core.api.Storage.clear";
    public static final String STORAGE_DELETE = "com.unity3d.services.core.api.Storage.delete";
    public static final String STORAGE_GET = "com.unity3d.services.core.api.Storage.get";
    public static final String STORAGE_GET_KEYS = "com.unity3d.services.core.api.Storage.getKeys";
    public static final String STORAGE_READ = "com.unity3d.services.core.api.Storage.read";
    public static final String STORAGE_SET = "com.unity3d.services.core.api.Storage.set";
    public static final String STORAGE_WRITE = "com.unity3d.services.core.api.Storage.write";
    public static final String UPDATE_CAMPAIGN_STATE = "com.unity3d.services.ads.api.AdViewer.updateCampaignState";
    public static final String UPDATE_TRACKING_TOKEN = "com.unity3d.services.ads.api.AdViewer.updateTrackingToken";

    static <clinit>() {
        new ExposedFunctionLocation();
        INSTANCE = new ExposedFunctionLocation(..);
        return;
    }

    private ExposedFunctionLocation() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.FullScreenWebViewDisplay
// ============================================================
package com.unity3d.ads.adplayer;

public final class FullScreenWebViewDisplay extends ComponentActivity {
    private String opportunityId;
    private Map showOptions;

    public FullScreenWebViewDisplay() {
        new ComponentActivity();
        opportunityId = "";
        return;
    }

    public static final String access$getOpportunityId$p(FullScreenWebViewDisplay p0) {
        return opportunityId;
    }

    public static final Map access$getShowOptions$p(FullScreenWebViewDisplay p0) {
        return showOptions;
    }

    public static final void access$loadWebView(FullScreenWebViewDisplay p0, WebView p1) {
        p0.loadWebView(p1);
        return;
    }

    private final void listenToAdPlayerEvents() {
        AndroidFullscreenWebViewAdPlayer$Companion.getDisplayMessages();
        new FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1(AndroidFullscreenWebViewAdPlayer$Companion.getDisplayMessages(..), this);
        new FullScreenWebViewDisplay$listenToAdPlayerEvents$2(this, 0);
        FlowKt.onEach(new FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1(..), new FullScreenWebViewDisplay$listenToAdPlayerEvents$2(..));
        LifecycleOwnerKt.getLifecycleScope(this);
        FlowKt.launchIn(FlowKt.onEach(..), LifecycleOwnerKt.getLifecycleScope(..));
        return;
    }

    private final void loadWebView(WebView p0) {
        LifecycleOwnerKt.getLifecycleScope(this);
        new FullScreenWebViewDisplay$loadWebView$1(this, p0, 0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(..), 0, 0, new FullScreenWebViewDisplay$loadWebView$1(..), 3, 0);
        return;
    }

    protected void onCreate(Bundle p0) {
        ComponentActivity.onCreate(p0);
        FullScreenWebViewDisplay.getIntent();
        Intent.getStringExtra("opportunityId");
        if (if-nez(Intent.getStringExtra(..))) goto L_34;
        FullScreenWebViewDisplay.setResult(0);
        FullScreenWebViewDisplay.finish();
        LifecycleOwnerKt.getLifecycleScope(this);
        new FullScreenWebViewDisplay$onCreate$1$1(this, 0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(..), 0, 0, new FullScreenWebViewDisplay$onCreate$1$1(..), 3, 0);
        return;
      L_34:
        opportunityId = new FullScreenWebViewDisplay$onCreate$1$1(..);
        FullScreenWebViewDisplay.getIntent();
        Intent.getIntExtra("orientation", -1);
        Integer.valueOf(Intent.getIntExtra(..));
        Integer.valueOf(..).intValue();
        if (if-eq(Number.intValue(..), 1)) goto L_50;
      L_50:
        if (if-eqz(1)) goto L_53;
      L_53:
      L_54:
        if (if-eqz(0)) goto L_5f;
        0.intValue();
        FullScreenWebViewDisplay.setRequestedOrientation(Number.intValue(..));
      L_5f:
        FullScreenWebViewDisplay.getIntent();
        Intent.getStringExtra("showOptions");
        if (if-eqz(Intent.getStringExtra(..))) goto L_75;
        new JSONObject(Intent.getStringExtra(..));
        JSONObjectExtensionsKt.toBuiltInMap(new JSONObject(..));
      L_75:
      L_76:
        showOptions = 0;
        FullScreenWebViewDisplay.listenToAdPlayerEvents();
        LifecycleOwnerKt.getLifecycleScope(this);
        new FullScreenWebViewDisplay$onCreate$5(this, 0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(..), 0, 0, new FullScreenWebViewDisplay$onCreate$5(..), 3, 0);
        return;
    }

    protected void onDestroy() {
        ComponentActivity.onDestroy();
        Dispatchers.getMain();
        CoroutineScopeKt.CoroutineScope(Dispatchers.getMain(..));
        new FullScreenWebViewDisplay$onDestroy$1(this, 0);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(..), 0, 0, new FullScreenWebViewDisplay$onDestroy$1(..), 3, 0);
        return;
    }

    public boolean onKeyDown(int p0, KeyEvent p1) {
        if (if-ne(p0, 4)) goto L_5;
      L_5:
      L_6:
        return 0;
    }

    protected void onPause() {
        ComponentActivity.onPause();
        LifecycleOwnerKt.getLifecycleScope(this);
        new FullScreenWebViewDisplay$onPause$1(this, 0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(..), 0, 0, new FullScreenWebViewDisplay$onPause$1(..), 3, 0);
        return;
    }

    protected void onResume() {
        ComponentActivity.onResume();
        LifecycleOwnerKt.getLifecycleScope(this);
        new FullScreenWebViewDisplay$onResume$1(this, 0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(..), 0, 0, new FullScreenWebViewDisplay$onResume$1(..), 3, 0);
        return;
    }

    public void onWindowFocusChanged(boolean p0) {
        ComponentActivity.onWindowFocusChanged(p0);
        LifecycleOwnerKt.getLifecycleScope(this);
        new FullScreenWebViewDisplay$onWindowFocusChanged$1(this, p0, 0);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(..), 0, 0, new FullScreenWebViewDisplay$onWindowFocusChanged$1(..), 3, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.FullscreenAdPlayer
// ============================================================
package com.unity3d.ads.adplayer;

public abstract class FullscreenAdPlayer {
}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.GetAdAssetLoader
// ============================================================
package com.unity3d.ads.adplayer;

public abstract class GetAdAssetLoader {
}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.GetAdAssetLoaderKt
// ============================================================
package com.unity3d.ads.adplayer;

public final class GetAdAssetLoaderKt {
    public static WebViewAssetLoader $r8$lambda$3rnFRfGiURr6r6g3bsEQePYpSR8(Context p0) {
        GetAdAssetLoaderKt.provideGetAdCacheAssetLoader$lambda$1(p0);
        return GetAdAssetLoaderKt.provideGetAdCacheAssetLoader$lambda$1(..);
    }

    public static WebResourceResponse $r8$lambda$Fp4RIwbmj25xuj0HDqNvnDG3cvk(Context p0, String p1) {
        GetAdAssetLoaderKt.provideGetAdCacheAssetLoader$lambda$1$lambda$0(p0, p1);
        return GetAdAssetLoaderKt.provideGetAdCacheAssetLoader$lambda$1$lambda$0(..);
    }

    public static final GetAdAssetLoader provideGetAdCacheAssetLoader(Context p0) {
        new GetAdAssetLoaderKt$$ExternalSyntheticLambda1(p0);
        return new GetAdAssetLoaderKt$$ExternalSyntheticLambda1(..);
    }

    private static final WebViewAssetLoader provideGetAdCacheAssetLoader$lambda$1(Context p0) {
        new WebViewAssetLoader$Builder();
        new GetAdAssetLoaderKt$$ExternalSyntheticLambda0(p0);
        new WebViewAssetLoader$Builder(..).addPathHandler("/", new GetAdAssetLoaderKt$$ExternalSyntheticLambda0(..));
        WebViewAssetLoader$Builder.setDomain("cdn-creatives-cf-prd.acquire.unity3dusercontent.com");
        WebViewAssetLoader$Builder.build();
        return WebViewAssetLoader$Builder.build(..);
    }

    private static final WebResourceResponse provideGetAdCacheAssetLoader$lambda$1$lambda$0(Context p0, String p1) {
        p0.getFilesDir();
        new StringBuilder("unityads/");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        new File(Context.getFilesDir(..), StringBuilder.toString(..));
        new FileInputStream(new File(..));
        GetWebViewAssetLoaderKt.guessMimeType(p1);
        new WebResourceResponse(GetWebViewAssetLoaderKt.guessMimeType(..), 0, new FileInputStream(..));
        DeviceLog.debug("Ad Asset not found: %s", 1);
      L_3f:
        return new WebResourceResponse(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.GetWebViewAssetLoaderKt
// ============================================================
package com.unity3d.ads.adplayer;

public final class GetWebViewAssetLoaderKt {
    public static WebViewAssetLoader $r8$lambda$BjKqhtUeajU8MVqxhIl8EQm9Uuo(Context p0) {
        GetWebViewAssetLoaderKt.provideGetWebViewCacheAssetLoader$lambda$1(p0);
        return GetWebViewAssetLoaderKt.provideGetWebViewCacheAssetLoader$lambda$1(..);
    }

    public static WebResourceResponse $r8$lambda$dEc7UJjvjy9roFmw2ztrgySEuJY(Context p0, String p1) {
        GetWebViewAssetLoaderKt.provideGetWebViewCacheAssetLoader$lambda$1$lambda$0(p0, p1);
        return GetWebViewAssetLoaderKt.provideGetWebViewCacheAssetLoader$lambda$1$lambda$0(..);
    }

    public static final String guessMimeType(String p0) {
        URLConnection.guessContentTypeFromName(p0);
        return URLConnection.guessContentTypeFromName(..);
    }

    public static final GetWebViewCacheAssetLoader provideGetWebViewCacheAssetLoader(Context p0) {
        new GetWebViewAssetLoaderKt$$ExternalSyntheticLambda0(p0);
        return new GetWebViewAssetLoaderKt$$ExternalSyntheticLambda0(..);
    }

    private static final WebViewAssetLoader provideGetWebViewCacheAssetLoader$lambda$1(Context p0) {
        new WebViewAssetLoader$Builder();
        new GetWebViewAssetLoaderKt$$ExternalSyntheticLambda1(p0);
        new WebViewAssetLoader$Builder(..).addPathHandler("/unity-ads-sdk-webview/", new GetWebViewAssetLoaderKt$$ExternalSyntheticLambda1(..));
        WebViewAssetLoader$Builder.setDomain("config.unityads.unity3d.com");
        WebViewAssetLoader$Builder.build();
        return WebViewAssetLoader$Builder.build(..);
    }

    private static final WebResourceResponse provideGetWebViewCacheAssetLoader$lambda$1$lambda$0(Context p0, String p1) {
        p0.getAssets();
        Context.getAssets(..).open(p1);
        GetWebViewAssetLoaderKt.guessMimeType(p1);
        new WebResourceResponse(GetWebViewAssetLoaderKt.guessMimeType(..), 0, AssetManager.open(..));
        DeviceLog.debug("Webview Asset not found: %s", 1);
      L_2e:
        return new WebResourceResponse(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.GetWebViewCacheAssetLoader
// ============================================================
package com.unity3d.ads.adplayer;

public abstract class GetWebViewCacheAssetLoader {
}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.HandlerType
// ============================================================
package com.unity3d.ads.adplayer;

public final class HandlerType extends Enum {
    private static final HandlerType[] $VALUES;
    public static final HandlerType CALLBACK;
    public static final HandlerType EVENT;
    public static final HandlerType INVOCATION;
    private final String jsPath;

    private static final HandlerType[] $values() {
        return 3;
    }

    static <clinit>() {
        new HandlerType("CALLBACK", 0, "handleCallback");
        CALLBACK = new HandlerType(..);
        new HandlerType("INVOCATION", 1, "handleInvocation");
        INVOCATION = new HandlerType(..);
        new HandlerType("EVENT", 2, "handleEvent");
        EVENT = new HandlerType(..);
        HandlerType.$values();
        $VALUES = HandlerType.$values(..);
        return;
    }

    private HandlerType(String p0, int p1, String p2) {
        new Enum(p0, p1);
        jsPath = p2;
        return;
    }

    public static HandlerType valueOf(String p0) {
        Enum.valueOf(HandlerType.class, p0);
        return Enum.valueOf(..);
    }

    public static HandlerType[] values() {
        HandlerType.$VALUES.clone();
        return Object[].clone(..);
    }

    public final String getJsPath() {
        return jsPath;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.Invocation
// ============================================================
package com.unity3d.ads.adplayer;

public final class Invocation {
    private final CompletableDeferred _isHandled;
    private final CompletableDeferred completableDeferred;
    private final String location;
    private final Object[] parameters;

    public Invocation(String p0, Object[] p1) {
        new Object();
        location = p0;
        parameters = p1;
        CompletableDeferredKt.CompletableDeferred$default(0, 1, 0);
        _isHandled = CompletableDeferredKt.CompletableDeferred$default(..);
        CompletableDeferredKt.CompletableDeferred$default(0, 1, 0);
        completableDeferred = CompletableDeferredKt.CompletableDeferred$default(..);
        return;
    }

    public static final CompletableDeferred access$getCompletableDeferred$p(Invocation p0) {
        return completableDeferred;
    }

    public static Object handle$default(Invocation p0, Function1 p1, Continuation p2, int p3, Object p4) {
        if (if-eqz(p3)) goto L_c;
        new Invocation$handle$2(0);
      L_c:
        p0.handle(new Invocation$handle$2(..), p2);
        return Invocation.handle(..);
    }

    public final String getLocation() {
        return location;
    }

    public final Object[] getParameters() {
        return parameters;
    }

    public final Object getResult(Continuation p0) {
        completableDeferred.await(p0);
        return CompletableDeferred.await(..);
    }

    public final Object handle(Function1 p0, Continuation p1) {
        _isHandled.complete(Unit.INSTANCE);
        p1.getContext();
        CoroutineScopeKt.CoroutineScope(Continuation.getContext(..));
        new Invocation$handle$3(p0, this, 0);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(..), 0, 0, new Invocation$handle$3(..), 3, 0);
        return Unit.INSTANCE;
    }

    public final Deferred isHandled() {
        return _isHandled;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.LoadWebViewError
// ============================================================
package com.unity3d.ads.adplayer;

public final class LoadWebViewError extends AdPlayerError {
    private final List errors;

    public LoadWebViewError(List p0) {
        new AdPlayerError("AdPlayer was not able to load the webview.", 0);
        errors = p0;
        return;
    }

    public final List getErrors() {
        return errors;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.ShowOptions
// ============================================================
package com.unity3d.ads.adplayer;

public abstract class ShowOptions {
}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer {
    private final WebViewBridge bridge;
    private final DeviceInfoRepository deviceInfoRepository;
    private final CoroutineDispatcher dispatcher;
    private final ExecuteAdViewerRequest executeAdViewerRequest;
    private final MutableStateFlow isCompletedManually;
    private final Flow onBroadcastEvents;
    private final Flow onLoadEvent;
    private final Flow onRequestEvents;
    private final Flow onShowEvent;
    private final CoroutineScope scope;
    private final CoroutineExceptionHandler scopeCancellationHandler;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private final Function1 storageEventCallback;
    private final Flow updateCampaignState;
    private final WebViewContainer webViewContainer;

    public WebViewAdPlayer(WebViewBridge p0, DeviceInfoRepository p1, SessionRepository p2, ExecuteAdViewerRequest p3, CoroutineDispatcher p4, SendDiagnosticEvent p5, WebViewContainer p6, CoroutineScope p7) {
        new Object();
        bridge = p0;
        deviceInfoRepository = p1;
        sessionRepository = p2;
        executeAdViewerRequest = p3;
        dispatcher = p4;
        sendDiagnosticEvent = p5;
        webViewContainer = p6;
        Boolean.valueOf(0);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        isCompletedManually = StateFlowKt.MutableStateFlow(..);
        new WebViewAdPlayer$storageEventCallback$1(new Object(..));
        storageEventCallback = new WebViewAdPlayer$storageEventCallback$1(..);
        new WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, new Object(..));
        scopeCancellationHandler = new WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1(..);
        CoroutineScopeKt.plus(p7, p4);
        new CoroutineName("WebViewAdPlayer");
        CoroutineScopeKt.plus(CoroutineScopeKt.plus(..), new CoroutineName(..));
        CoroutineScopeKt.plus(CoroutineScopeKt.plus(..), new WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1(..));
        scope = CoroutineScopeKt.plus(..);
        p0.getOnInvocation();
        new WebViewAdPlayer$special$$inlined$filter$1(WebViewBridge.getOnInvocation(..));
        new WebViewAdPlayer$special$$inlined$map$1(new WebViewAdPlayer$special$$inlined$filter$1(..));
        new WebViewAdPlayer$onShowEvent$3(0);
        FlowKt.flowCombine(new WebViewAdPlayer$special$$inlined$map$1(..), StateFlowKt.MutableStateFlow(..), new WebViewAdPlayer$onShowEvent$3(..));
        onShowEvent = FlowKt.flowCombine(..);
        p0.getOnInvocation();
        new WebViewAdPlayer$special$$inlined$filter$2(WebViewBridge.getOnInvocation(..));
        new WebViewAdPlayer$special$$inlined$map$2(new WebViewAdPlayer$special$$inlined$filter$2(..));
        new Object(..).getScope();
        SharingStarted.Companion.getEagerly();
        FlowKt.shareIn(new WebViewAdPlayer$special$$inlined$map$2(..), WebViewAdPlayer.getScope(..), SharingStarted$Companion.getEagerly(..), 1);
        FlowKt.take(FlowKt.shareIn(..), 1);
        onLoadEvent = FlowKt.take(..);
        p0.getOnInvocation();
        new WebViewAdPlayer$special$$inlined$filter$3(WebViewBridge.getOnInvocation(..));
        new WebViewAdPlayer$special$$inlined$map$3(new WebViewAdPlayer$special$$inlined$filter$3(..));
        updateCampaignState = new WebViewAdPlayer$special$$inlined$map$3(..);
        p0.getOnInvocation();
        new WebViewAdPlayer$special$$inlined$filter$4(WebViewBridge.getOnInvocation(..));
        new WebViewAdPlayer$special$$inlined$map$4(new WebViewAdPlayer$special$$inlined$filter$4(..));
        onBroadcastEvents = new WebViewAdPlayer$special$$inlined$map$4(..);
        p0.getOnInvocation();
        new WebViewAdPlayer$special$$inlined$filter$5(WebViewBridge.getOnInvocation(..));
        new WebViewAdPlayer$special$$inlined$map$5(new WebViewAdPlayer$special$$inlined$filter$5(..), new Object(..));
        onRequestEvents = new WebViewAdPlayer$special$$inlined$map$5(..);
        Storage.Companion.addStorageEventCallback(new WebViewAdPlayer$storageEventCallback$1(..));
        AdPlayer.Companion.getBroadcastEventChannel();
        new WebViewAdPlayer$1(AdPlayer$Companion.getBroadcastEventChannel(..));
        FlowKt.onEach(new WebViewAdPlayer$special$$inlined$map$4(..), new WebViewAdPlayer$1(..));
        new Object(..).getScope();
        FlowKt.launchIn(FlowKt.onEach(..), WebViewAdPlayer.getScope(..));
        new Object(..).getScope();
        FlowKt.launchIn(new WebViewAdPlayer$special$$inlined$map$5(..), WebViewAdPlayer.getScope(..));
        AdPlayer.Companion.getBroadcastEventChannel();
        new WebViewAdPlayer$2(new Object(..));
        FlowKt.onEach(AdPlayer$Companion.getBroadcastEventChannel(..), new WebViewAdPlayer$2(..));
        new Object(..).getScope();
        FlowKt.launchIn(FlowKt.onEach(..), WebViewAdPlayer.getScope(..));
        return;
    }

    public static final WebViewBridge access$getBridge$p(WebViewAdPlayer p0) {
        return bridge;
    }

    public static final ExecuteAdViewerRequest access$getExecuteAdViewerRequest$p(WebViewAdPlayer p0) {
        return executeAdViewerRequest;
    }

    public static final Function1 access$getStorageEventCallback$p(WebViewAdPlayer p0) {
        return storageEventCallback;
    }

    public static final Object access$sendEvent(WebViewAdPlayer p0, Function0 p1, Continuation p2) {
        p0.sendEvent(p1, p2);
        return WebViewAdPlayer.sendEvent(..);
    }

    private final Object sendEvent(Function0 p0, Continuation p1) {
        if (if-eqz(v2)) goto L_18;
        if (if-eqz(label)) goto L_18;
        label = label;
      L_18:
        new WebViewAdPlayer$sendEvent$1(this, label);
      L_1d:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_46;
        if (if-eq(label, 1)) goto L_3a;
        if (if-ne(label, 2)) goto L_32;
        ResultKt.throwOnFailure(result);
      L_32:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_3a:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_46:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        WebViewAdPlayer.getOnLoadEvent();
        L$0 = this;
        L$1 = p0;
        label = 1;
        FlowKt.single(WebViewAdPlayer.getOnLoadEvent(..), "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(FlowKt.single(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_5c;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_5c:
      L_5d:
        if (if-eqz(v8)) goto L_a4;
        TuplesKt.to("reason", "adviewer");
        FlowKt.single(..).getMessage();
        TuplesKt.to("reason_debug", LoadEvent$Error.getMessage(..));
        FlowKt.single(..).getErrorCode();
        String.valueOf(LoadEvent$Error.getErrorCode(..));
        TuplesKt.to("reason_code", String.valueOf(..));
        MapsKt.mapOf(3);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "bridge_send_event_failed", 0, MapsKt.mapOf(..), 0, 0, 26, 0);
        return Unit.INSTANCE;
      L_a4:
        "reason_debug".invoke();
        L$0 = 0;
        L$1 = 0;
        label = 2;
        bridge.sendEvent(Function0.invoke(..), 3);
        if (if-ne(WebViewBridge.sendEvent(..), "reason_code")) goto L_ba;
        return "reason_code";
      L_ba:
        return Unit.INSTANCE;
    }

    public Object destroy(Continuation p0) {
        AdPlayer$DefaultImpls.destroy(this, p0);
        return AdPlayer$DefaultImpls.destroy(..);
    }

    public void dispatchShowCompleted() {
        Boolean.valueOf(1);
        isCompletedManually.setValue(Boolean.valueOf(..));
        return;
    }

    public Flow getOnLoadEvent() {
        return onLoadEvent;
    }

    public final Flow getOnRequestEvents() {
        return onRequestEvents;
    }

    public Flow getOnShowEvent() {
        return onShowEvent;
    }

    public CoroutineScope getScope() {
        return scope;
    }

    public Flow getUpdateCampaignState() {
        return updateCampaignState;
    }

    public WebViewContainer getWebViewContainer() {
        return webViewContainer;
    }

    public Object onAllowedPiiChange(byte[] p0, Continuation p1) {
        new WebViewAdPlayer$onAllowedPiiChange$2(p0);
        WebViewAdPlayer.sendEvent(new WebViewAdPlayer$onAllowedPiiChange$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(WebViewAdPlayer.sendEvent(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_12;
        return WebViewAdPlayer.sendEvent(..);
      L_12:
        return Unit.INSTANCE;
    }

    public Object onBroadcastEvent(String p0, Continuation p1) {
        new WebViewAdPlayer$onBroadcastEvent$2(p0);
        WebViewAdPlayer.sendEvent(new WebViewAdPlayer$onBroadcastEvent$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(WebViewAdPlayer.sendEvent(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_12;
        return WebViewAdPlayer.sendEvent(..);
      L_12:
        return Unit.INSTANCE;
    }

    public Object requestShow(Map p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new WebViewAdPlayer$requestShow$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_77;
        if (if-eq(label, 1)) goto L_58;
        if (if-eq(label, 2)) goto L_3b;
        if (if-ne(label, 3)) goto L_33;
        ResultKt.throwOnFailure(result);
      L_33:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_3b:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_58:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_77:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        deviceInfoRepository.getDynamicDeviceInfo();
        new JSONObject();
        deviceInfoRepository.getOrientation();
        new JSONObject(..).put("orientation", DeviceInfoRepository.getOrientation(..));
        deviceInfoRepository.getConnectionTypeStr();
        new JSONObject(..).put("connectionType", DeviceInfoRepository.getConnectionTypeStr(..));
        deviceInfoRepository.getRingerMode();
        if (if-eq(DeviceInfoRepository.getRingerMode(..), L$3)) goto L_a5;
      L_a5:
      L_a6:
        new JSONObject(..).put("isMuted", 0);
        DynamicDeviceInfoOuterClass$DynamicDeviceInfo.getAndroid();
        DynamicDeviceInfoOuterClass$DynamicDeviceInfo$Android.getVolume();
        new JSONObject(..).put("volume", DynamicDeviceInfoOuterClass$DynamicDeviceInfo$Android.getVolume(..), "isMuted");
        L$0 = this;
        L$1 = L$5;
        L$2 = new JSONObject(..);
        L$3 = new JSONObject(..);
        L$4 = "privacy";
        L$5 = new JSONObject(..);
        label = 1;
        sessionRepository.getPrivacy(new WebViewAdPlayer$requestShow$1(..));
        if (if-ne(SessionRepository.getPrivacy(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_d1;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_d1:
      L_d5:
        ProtobufExtensionsKt.toBase64$default(SessionRepository.getPrivacy(..), 0, 1, 0);
        new JSONObject(..).put("privacy", ProtobufExtensionsKt.toBase64$default(..));
        L$0 = this;
        L$1 = L$5;
        L$2 = new JSONObject(..);
        L$3 = new JSONObject(..);
        L$4 = "privacyFsm";
        L$5 = new JSONObject(..);
        label = L$3;
        sessionRepository.getPrivacyFsm(new WebViewAdPlayer$requestShow$1(..));
        if (if-ne(SessionRepository.getPrivacyFsm(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_f7;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_f7:
      L_fe:
        ProtobufExtensionsKt.toBase64$default(SessionRepository.getPrivacyFsm(..), 0, 1, 0);
        new JSONObject(..).put("privacyFsm", ProtobufExtensionsKt.toBase64$default(..));
        deviceInfoRepository.getAllowedPii();
        MutableStateFlow.getValue();
        MutableStateFlow.getValue(..).toByteString();
        ProtobufExtensionsKt.toBase64$default(AllowedPiiOuterClass$AllowedPii.toByteString(..), 0, 1, 0);
        new JSONObject(..).put("allowedPii", ProtobufExtensionsKt.toBase64$default(..));
        if (if-eqz(L$5)) goto L_16c;
        new LinkedHashMap();
        L$5.entrySet();
        Map.entrySet(..).iterator();
      L_136:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_15b;
        Set.iterator(..).next();
        Iterator.next(..).getKey();
        Intrinsics.areEqual(Map$Entry.getKey(..), "objectId");
        if (if-eqz(Intrinsics.areEqual(..))) goto L_136;
        Iterator.next(..).getKey();
        Iterator.next(..).getValue();
        new LinkedHashMap(..).put(Map$Entry.getKey(..), Map$Entry.getValue(..));
      L_15b:
        new LinkedHashMap(..).isEmpty();
        if (if-eqz(Map.isEmpty(..))) goto L_16c;
        new JSONObject(new LinkedHashMap(..));
        new JSONObject(..).put("showOptions", new JSONObject(..));
      L_16c:
        L$0 = 0;
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        L$4 = 0;
        L$5 = 0;
        label = 3;
        bridge.request("webview", "show", new JSONObject(..), new WebViewAdPlayer$requestShow$1(..));
        if (if-ne(WebViewBridge.request(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_18b;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_18b:
        return Unit.INSTANCE;
    }

    public Object sendActivityDestroyed(Continuation p0) {
        WebViewAdPlayer.sendEvent(WebViewAdPlayer$sendActivityDestroyed$2.INSTANCE, p0);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(WebViewAdPlayer.sendEvent(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_f;
        return WebViewAdPlayer.sendEvent(..);
      L_f:
        return Unit.INSTANCE;
    }

    public Object sendFocusChange(boolean p0, Continuation p1) {
        new WebViewAdPlayer$sendFocusChange$2(p0);
        WebViewAdPlayer.sendEvent(new WebViewAdPlayer$sendFocusChange$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(WebViewAdPlayer.sendEvent(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_12;
        return WebViewAdPlayer.sendEvent(..);
      L_12:
        return Unit.INSTANCE;
    }

    public Object sendMuteChange(boolean p0, Continuation p1) {
        new WebViewAdPlayer$sendMuteChange$2(p0);
        WebViewAdPlayer.sendEvent(new WebViewAdPlayer$sendMuteChange$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(WebViewAdPlayer.sendEvent(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_12;
        return WebViewAdPlayer.sendEvent(..);
      L_12:
        return Unit.INSTANCE;
    }

    public Object sendPrivacyFsmChange(byte[] p0, Continuation p1) {
        new WebViewAdPlayer$sendPrivacyFsmChange$2(p0);
        WebViewAdPlayer.sendEvent(new WebViewAdPlayer$sendPrivacyFsmChange$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(WebViewAdPlayer.sendEvent(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_12;
        return WebViewAdPlayer.sendEvent(..);
      L_12:
        return Unit.INSTANCE;
    }

    public Object sendUserConsentChange(byte[] p0, Continuation p1) {
        new WebViewAdPlayer$sendUserConsentChange$2(p0);
        WebViewAdPlayer.sendEvent(new WebViewAdPlayer$sendUserConsentChange$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(WebViewAdPlayer.sendEvent(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_12;
        return WebViewAdPlayer.sendEvent(..);
      L_12:
        return Unit.INSTANCE;
    }

    public Object sendVisibilityChange(boolean p0, Continuation p1) {
        new WebViewAdPlayer$sendVisibilityChange$2(p0);
        WebViewAdPlayer.sendEvent(new WebViewAdPlayer$sendVisibilityChange$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(WebViewAdPlayer.sendEvent(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_12;
        return WebViewAdPlayer.sendEvent(..);
      L_12:
        return Unit.INSTANCE;
    }

    public Object sendVolumeChange(double p0, Continuation p1) {
        new WebViewAdPlayer$sendVolumeChange$2(p0, v3);
        WebViewAdPlayer.sendEvent(new WebViewAdPlayer$sendVolumeChange$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(WebViewAdPlayer.sendEvent(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_12;
        return WebViewAdPlayer.sendEvent(..);
      L_12:
        return Unit.INSTANCE;
    }

    public void show(ShowOptions p0) {
        AdPlayer$DefaultImpls.show(this, p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayerKt
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayerKt {
    private static final String[] LOAD_EVENTS;
    private static final String[] REQUEST_EVENTS;
    private static final String[] SHOW_EVENTS;

    static <clinit>() {
        SHOW_EVENTS = v0;
        LOAD_EVENTS = v0;
        REQUEST_EVENTS = v0;
        return;
    }

    public static final String[] access$getLOAD_EVENTS$p() {
        return WebViewAdPlayerKt.LOAD_EVENTS;
    }

    public static final String[] access$getREQUEST_EVENTS$p() {
        return WebViewAdPlayerKt.REQUEST_EVENTS;
    }

    public static final String[] access$getSHOW_EVENTS$p() {
        return WebViewAdPlayerKt.SHOW_EVENTS;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewBridge
// ============================================================
package com.unity3d.ads.adplayer;

public abstract class WebViewBridge {
    public abstract SharedFlow getOnInvocation() {
        // native or abstract
    }

    public abstract void handleCallback(String p0, String p1, String p2) {
        // native or abstract
    }

    public abstract void handleInvocation(String p0) {
        // native or abstract
    }

    public abstract Object request(String p0, String p1, Object[] p2, Continuation p3) {
        // native or abstract
    }

    public abstract Object sendEvent(WebViewEvent p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewContainer
// ============================================================
package com.unity3d.ads.adplayer;

public abstract class WebViewContainer {
    public abstract Object addJavascriptInterface(WebViewBridge p0, String p1, Continuation p2) {
        // native or abstract
    }

    public abstract Object destroy(Continuation p0) {
        // native or abstract
    }

    public abstract Object evaluateJavascript(String p0, Continuation p1) {
        // native or abstract
    }

    public abstract StateFlow getLastInputEvent() {
        // native or abstract
    }

    public abstract Object loadUrl(String p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AdPlayer$Companion
// ============================================================
package com.unity3d.ads.adplayer;

public final class AdPlayer$Companion {
    static final AdPlayer$Companion $$INSTANCE;
    private static final MutableSharedFlow broadcastEventChannel;

    static <clinit>() {
        new AdPlayer$Companion();
        $$INSTANCE = new AdPlayer$Companion(..);
        SharedFlowKt.MutableSharedFlow$default(0, 0, 0, 7, 0);
        broadcastEventChannel = SharedFlowKt.MutableSharedFlow$default(..);
        return;
    }

    private AdPlayer$Companion() {
        new Object();
        return;
    }

    public final MutableSharedFlow getBroadcastEventChannel() {
        return AdPlayer$Companion.broadcastEventChannel;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AdPlayer$DefaultImpls
// ============================================================
package com.unity3d.ads.adplayer;

public final class AdPlayer$DefaultImpls {
    public static Object destroy(AdPlayer p0, Continuation p1) {
        p0.getScope();
        CoroutineScopeKt.cancel$default(AdPlayer.getScope(..), 0, 1, 0);
        return Unit.INSTANCE;
    }

    public static void show(AdPlayer p0, ShowOptions p1) {
        new NotImplementedError(0, 1, 0);
        throw new NotImplementedError(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$destroy$1
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidEmbeddableWebViewAdPlayer$destroy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final AndroidEmbeddableWebViewAdPlayer this$0;

    AndroidEmbeddableWebViewAdPlayer$destroy$1(AndroidEmbeddableWebViewAdPlayer p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.destroy(this);
        return AndroidEmbeddableWebViewAdPlayer.destroy(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$$inlined$doOnAttach$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidEmbeddableWebViewAdPlayer$show$$inlined$doOnAttach$1 {
    final ShowOptions $showOptions$inlined;
    final View $this_doOnAttach;
    final AndroidEmbeddableWebViewAdPlayer this$0;

    public AndroidEmbeddableWebViewAdPlayer$show$$inlined$doOnAttach$1(View p0, AndroidEmbeddableWebViewAdPlayer p1, ShowOptions p2) {
        $this_doOnAttach = p0;
        this$0 = p1;
        $showOptions$inlined = p2;
        new Object();
        return;
    }

    public void onViewAttachedToWindow(View p0) {
        $this_doOnAttach.removeOnAttachStateChangeListener(this);
        AndroidEmbeddableWebViewAdPlayer.access$getWebViewAdPlayer$p(this$0);
        WebViewAdPlayer.getScope();
        new AndroidEmbeddableWebViewAdPlayer$show$2$1(this$0, $showOptions$inlined, 0);
        BuildersKt.launch$default(WebViewAdPlayer.getScope(..), 0, 0, new AndroidEmbeddableWebViewAdPlayer$show$2$1(..), 3, 0);
        ViewCompat.isAttachedToWindow(p0);
        if (if-nez(ViewCompat.isAttachedToWindow(..))) goto L_4d;
        AndroidEmbeddableWebViewAdPlayer.access$getWebViewAdPlayer$p(this$0);
        WebViewAdPlayer.getScope();
        new AndroidEmbeddableWebViewAdPlayer$show$2$2$1(this$0, 0);
        BuildersKt.launch$default(WebViewAdPlayer.getScope(..), 0, 0, new AndroidEmbeddableWebViewAdPlayer$show$2$2$1(..), 3, 0);
      L_4d:
        new AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1(new AndroidEmbeddableWebViewAdPlayer$show$2$2$1(..), this$0);
        View.addOnAttachStateChangeListener(new AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1(..));
      L_59:
        return;
    }

    public void onViewDetachedFromWindow(View p0) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$1
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidEmbeddableWebViewAdPlayer$show$1 extends SuspendLambda {
    final BannerView $bannerView;
    final Context $context;
    int label;
    final AndroidEmbeddableWebViewAdPlayer this$0;

    AndroidEmbeddableWebViewAdPlayer$show$1(AndroidEmbeddableWebViewAdPlayer p0, Context p1, BannerView p2, Continuation p3) {
        this$0 = p0;
        $context = p1;
        $bannerView = p2;
        new SuspendLambda(2, p3);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidEmbeddableWebViewAdPlayer$show$1(this$0, $context, $bannerView, p1);
        return new AndroidEmbeddableWebViewAdPlayer$show$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidEmbeddableWebViewAdPlayer$show$1.invoke(p0, p1);
        return AndroidEmbeddableWebViewAdPlayer$show$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidEmbeddableWebViewAdPlayer$show$1.create(p0, p1);
        AndroidEmbeddableWebViewAdPlayer$show$1.invokeSuspend(Unit.INSTANCE);
        return AndroidEmbeddableWebViewAdPlayer$show$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_43;
        ResultKt.throwOnFailure(p0);
        this$0.getWebViewContainer();
        AndroidWebViewContainer.getWebView();
        $bannerView.getSize();
        BannerView.getSize(..).getWidth();
        ViewUtilities.pxFromDp($context, UnityBannerSize.getWidth(..));
        $bannerView.getSize();
        BannerView.getSize(..).getHeight();
        ViewUtilities.pxFromDp($context, UnityBannerSize.getHeight(..));
        new ViewGroup$LayoutParams(ViewUtilities.pxFromDp(..), ViewUtilities.pxFromDp(..));
        WebView.setLayoutParams(new ViewGroup$LayoutParams(..));
        return Unit.INSTANCE;
      L_43:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$2$1
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidEmbeddableWebViewAdPlayer$show$2$1 extends SuspendLambda {
    final ShowOptions $showOptions;
    int label;
    final AndroidEmbeddableWebViewAdPlayer this$0;

    AndroidEmbeddableWebViewAdPlayer$show$2$1(AndroidEmbeddableWebViewAdPlayer p0, ShowOptions p1, Continuation p2) {
        this$0 = p0;
        $showOptions = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidEmbeddableWebViewAdPlayer$show$2$1(this$0, $showOptions, p1);
        return new AndroidEmbeddableWebViewAdPlayer$show$2$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidEmbeddableWebViewAdPlayer$show$2$1.invoke(p0, p1);
        return AndroidEmbeddableWebViewAdPlayer$show$2$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidEmbeddableWebViewAdPlayer$show$2$1.create(p0, p1);
        AndroidEmbeddableWebViewAdPlayer$show$2$1.invokeSuspend(Unit.INSTANCE);
        return AndroidEmbeddableWebViewAdPlayer$show$2$1.invokeSuspend(..);
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
        AndroidEmbeddableWebViewAdPlayer.access$getWebViewAdPlayer$p(this$0);
        $showOptions.getUnityAdsShowOptions();
        label = 1;
        WebViewAdPlayer.requestShow(AndroidShowOptions.getUnityAdsShowOptions(..), this);
        if (if-ne(WebViewAdPlayer.requestShow(..), "call to 'resume' before 'invoke' with coroutine")) goto L_34;
        return "call to 'resume' before 'invoke' with coroutine";
      L_34:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$2$2$1
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidEmbeddableWebViewAdPlayer$show$2$2$1 extends SuspendLambda {
    int label;
    final AndroidEmbeddableWebViewAdPlayer this$0;

    AndroidEmbeddableWebViewAdPlayer$show$2$2$1(AndroidEmbeddableWebViewAdPlayer p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidEmbeddableWebViewAdPlayer$show$2$2$1(this$0, p1);
        return new AndroidEmbeddableWebViewAdPlayer$show$2$2$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidEmbeddableWebViewAdPlayer$show$2$2$1.invoke(p0, p1);
        return AndroidEmbeddableWebViewAdPlayer$show$2$2$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidEmbeddableWebViewAdPlayer$show$2$2$1.create(p0, p1);
        AndroidEmbeddableWebViewAdPlayer$show$2$2$1.invokeSuspend(Unit.INSTANCE);
        return AndroidEmbeddableWebViewAdPlayer$show$2$2$1.invokeSuspend(..);
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
        this$0.destroy(this);
        if (if-ne(AndroidEmbeddableWebViewAdPlayer.destroy(..), "call to 'resume' before 'invoke' with coroutine")) goto L_28;
        return "call to 'resume' before 'invoke' with coroutine";
      L_28:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$3
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidEmbeddableWebViewAdPlayer$show$3 extends SuspendLambda {
    final BannerView $bannerView;
    int label;
    final AndroidEmbeddableWebViewAdPlayer this$0;

    AndroidEmbeddableWebViewAdPlayer$show$3(BannerView p0, AndroidEmbeddableWebViewAdPlayer p1, Continuation p2) {
        $bannerView = p0;
        this$0 = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidEmbeddableWebViewAdPlayer$show$3($bannerView, this$0, p1);
        return new AndroidEmbeddableWebViewAdPlayer$show$3(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidEmbeddableWebViewAdPlayer$show$3.invoke(p0, p1);
        return AndroidEmbeddableWebViewAdPlayer$show$3.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidEmbeddableWebViewAdPlayer$show$3.create(p0, p1);
        AndroidEmbeddableWebViewAdPlayer$show$3.invokeSuspend(Unit.INSTANCE);
        return AndroidEmbeddableWebViewAdPlayer$show$3.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_1e;
        ResultKt.throwOnFailure(p0);
        this$0.getWebViewContainer();
        AndroidWebViewContainer.getWebView();
        $bannerView.addView(AndroidWebViewContainer.getWebView(..));
        return Unit.INSTANCE;
      L_1e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1 {
    final View $this_doOnDetach;
    final AndroidEmbeddableWebViewAdPlayer this$0;

    public AndroidEmbeddableWebViewAdPlayer$show$lambda$2$$inlined$doOnDetach$1(View p0, AndroidEmbeddableWebViewAdPlayer p1) {
        $this_doOnDetach = p0;
        this$0 = p1;
        new Object();
        return;
    }

    public void onViewAttachedToWindow(View p0) {
        return;
    }

    public void onViewDetachedFromWindow(View p0) {
        $this_doOnDetach.removeOnAttachStateChangeListener(this);
        AndroidEmbeddableWebViewAdPlayer.access$getWebViewAdPlayer$p(this$0);
        WebViewAdPlayer.getScope();
        new AndroidEmbeddableWebViewAdPlayer$show$2$2$1(this$0, 0);
        BuildersKt.launch$default(WebViewAdPlayer.getScope(..), 0, 0, new AndroidEmbeddableWebViewAdPlayer$show$2$2$1(..), 3, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$Companion
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidFullscreenWebViewAdPlayer$Companion {
    private AndroidFullscreenWebViewAdPlayer$Companion() {
        new Object();
        return;
    }

    public AndroidFullscreenWebViewAdPlayer$Companion(DefaultConstructorMarker p0) {
        new AndroidFullscreenWebViewAdPlayer$Companion();
        return;
    }

    public final MutableSharedFlow getDisplayMessages() {
        AndroidFullscreenWebViewAdPlayer.access$getDisplayMessages$cp();
        return AndroidFullscreenWebViewAdPlayer.access$getDisplayMessages$cp(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$destroy$1
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidFullscreenWebViewAdPlayer$destroy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final AndroidFullscreenWebViewAdPlayer this$0;

    AndroidFullscreenWebViewAdPlayer$destroy$1(AndroidFullscreenWebViewAdPlayer p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.destroy(this);
        return AndroidFullscreenWebViewAdPlayer.destroy(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1 extends SuspendLambda {
    final DisplayMessage $displayMessage;
    int label;
    final AndroidFullscreenWebViewAdPlayer this$0;

    AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1(DisplayMessage p0, AndroidFullscreenWebViewAdPlayer p1, Continuation p2) {
        $displayMessage = p0;
        this$0 = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1($displayMessage, this$0, p1);
        return new AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1.invoke(p0, p1);
        return AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1.create(p0, p1);
        AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1.invokeSuspend(Unit.INSTANCE);
        return AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
        ResultKt.throwOnFailure(new IllegalStateException(..));
        ResultKt.throwOnFailure(new IllegalStateException(..));
        if (if-eqz(label)) goto L_3a;
        AndroidFullscreenWebViewAdPlayer.access$getWebViewAdPlayer$p(this$0);
        $displayMessage.getShowOptions();
        label = 1;
        WebViewAdPlayer.requestShow(DisplayMessage$DisplayReady.getShowOptions(..), this);
        if (if-ne(WebViewAdPlayer.requestShow(..), "call to 'resume' before 'invoke' with coroutine")) goto L_ce;
        return "call to 'resume' before 'invoke' with coroutine";
      L_3a:
        if (if-eqz(DisplayMessage$DisplayReady.getShowOptions(..))) goto L_66;
        AndroidFullscreenWebViewAdPlayer$Companion.getDisplayMessages();
        $displayMessage.getOpportunityId();
        this$0.getWebViewContainer();
        AndroidWebViewContainer.getWebView();
        new DisplayMessage$WebViewInstanceResponse(DisplayMessage.getOpportunityId(..), AndroidWebViewContainer.getWebView(..));
        label = 2;
        MutableSharedFlow.emit(new DisplayMessage$WebViewInstanceResponse(..), this);
        if (if-ne(MutableSharedFlow.emit(..), "call to 'resume' before 'invoke' with coroutine")) goto L_ce;
        return "call to 'resume' before 'invoke' with coroutine";
      L_66:
        if (if-eqz(new DisplayMessage$WebViewInstanceResponse(..))) goto L_85;
        AndroidFullscreenWebViewAdPlayer.access$getWebViewAdPlayer$p(this$0);
        $displayMessage.isVisible();
        label = 3;
        WebViewAdPlayer.sendVisibilityChange(DisplayMessage$VisibilityChanged.isVisible(..), this);
        if (if-ne(WebViewAdPlayer.sendVisibilityChange(..), "call to 'resume' before 'invoke' with coroutine")) goto L_ce;
        return "call to 'resume' before 'invoke' with coroutine";
      L_85:
        if (if-eqz(DisplayMessage$VisibilityChanged.isVisible(..))) goto L_a4;
        AndroidFullscreenWebViewAdPlayer.access$getWebViewAdPlayer$p(this$0);
        $displayMessage.isFocused();
        label = 4;
        WebViewAdPlayer.sendFocusChange(DisplayMessage$FocusChanged.isFocused(..), this);
        if (if-ne(WebViewAdPlayer.sendFocusChange(..), "call to 'resume' before 'invoke' with coroutine")) goto L_ce;
        return "call to 'resume' before 'invoke' with coroutine";
      L_a4:
        if (if-eqz(DisplayMessage$FocusChanged.isFocused(..))) goto L_bb;
        AndroidFullscreenWebViewAdPlayer.access$getWebViewAdPlayer$p(this$0);
        label = 5;
        WebViewAdPlayer.sendActivityDestroyed(this);
        if (if-ne(WebViewAdPlayer.sendActivityDestroyed(..), "call to 'resume' before 'invoke' with coroutine")) goto L_ce;
        return "call to 'resume' before 'invoke' with coroutine";
      L_bb:
        if (if-eqz(WebViewAdPlayer.sendActivityDestroyed(..))) goto L_ce;
        label = 6;
        this$0.destroy(this);
        if (if-ne(AndroidFullscreenWebViewAdPlayer.destroy(..), "call to 'resume' before 'invoke' with coroutine")) goto L_ce;
        return "call to 'resume' before 'invoke' with coroutine";
      L_ce:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1 {
    final Flow $this_unsafeTransform$inlined;
    final AndroidFullscreenWebViewAdPlayer this$0;

    public AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1(Flow p0, AndroidFullscreenWebViewAdPlayer p1) {
        $this_unsafeTransform$inlined = p0;
        this$0 = p1;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2(p0, this$0);
        $this_unsafeTransform$inlined.collect(new AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_16;
        return Flow.collect(..);
      L_16:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2 {
    final FlowCollector $this_unsafeFlow;
    final AndroidFullscreenWebViewAdPlayer this$0;

    public AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2(FlowCollector p0, AndroidFullscreenWebViewAdPlayer p1) {
        $this_unsafeFlow = p0;
        this$0 = p1;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2$1(this, label);
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
        new IllegalStateException(..).getOpportunityId();
        AndroidFullscreenWebViewAdPlayer.access$getOpportunityId$p(this$0);
        Intrinsics.areEqual(DisplayMessage.getOpportunityId(..), AndroidFullscreenWebViewAdPlayer.access$getOpportunityId$p(..));
        if (if-eqz(Intrinsics.areEqual(..))) goto L_56;
        label = 1;
        $this_unsafeFlow.emit(new IllegalStateException(..), new AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_56;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_56:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2 this$0;

    public AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2$1(AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2 {
    final Flow $this_unsafeTransform$inlined;

    public AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2(Flow p0) {
        $this_unsafeTransform$inlined = p0;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2(p0);
        $this_unsafeTransform$inlined.collect(new AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14;
        return Flow.collect(..);
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2 {
    final FlowCollector $this_unsafeFlow;

    public AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2(FlowCollector p0) {
        $this_unsafeFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2$1(this, label);
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
        if (if-nez(v4)) goto L_48;
        if (if-eqz(new IllegalStateException(..))) goto L_46;
      L_46:
      L_48:
      L_49:
        if (if-eqz(1)) goto L_54;
        label = 1;
        $this_unsafeFlow.emit(new IllegalStateException(..), new AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_54;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_54:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2 this$0;

    public AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2$1(AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$2
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidFullscreenWebViewAdPlayer$show$2 extends AdaptedFunctionReference {
    AndroidFullscreenWebViewAdPlayer$show$2(Object p0) {
        new AdaptedFunctionReference(2, p0, AndroidFullscreenWebViewAdPlayer.class, "displayEventsRouter", "displayEventsRouter(Lcom/unity3d/ads/adplayer/DisplayMessage;)Lkotlinx/coroutines/Job;", 12);
        return;
    }

    public static final Object access$getReceiver$p(AndroidFullscreenWebViewAdPlayer$show$2 p0) {
        return receiver;
    }

    public final Object invoke(DisplayMessage p0, Continuation p1) {
        AndroidFullscreenWebViewAdPlayer$show$2.access$getReceiver$p(this);
        AndroidFullscreenWebViewAdPlayer.access$show$displayEventsRouter(AndroidFullscreenWebViewAdPlayer$show$2.access$getReceiver$p(..), p0, p1);
        return AndroidFullscreenWebViewAdPlayer.access$show$displayEventsRouter(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidFullscreenWebViewAdPlayer$show$2.invoke(p0, p1);
        return AndroidFullscreenWebViewAdPlayer$show$2.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$3
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidFullscreenWebViewAdPlayer$show$3 extends FunctionReferenceImpl {
    AndroidFullscreenWebViewAdPlayer$show$3(Object p0) {
        new FunctionReferenceImpl(2, p0, AndroidFullscreenWebViewAdPlayer.class, "handleVolumeSettingsChange", "handleVolumeSettingsChange(Lcom/unity3d/ads/core/data/datasource/VolumeSettingsChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        return;
    }

    public final Object invoke(VolumeSettingsChange p0, Continuation p1) {
        AndroidFullscreenWebViewAdPlayer.access$handleVolumeSettingsChange(receiver, p0, p1);
        return AndroidFullscreenWebViewAdPlayer.access$handleVolumeSettingsChange(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidFullscreenWebViewAdPlayer$show$3.invoke(p0, p1);
        return AndroidFullscreenWebViewAdPlayer$show$3.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$5
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidFullscreenWebViewAdPlayer$show$5 extends SuspendLambda {
    int label;
    final AndroidFullscreenWebViewAdPlayer this$0;

    AndroidFullscreenWebViewAdPlayer$show$5(AndroidFullscreenWebViewAdPlayer p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidFullscreenWebViewAdPlayer$show$5(this$0, p1);
        return new AndroidFullscreenWebViewAdPlayer$show$5(..);
    }

    public final Object invoke(ShowEvent p0, Continuation p1) {
        AndroidFullscreenWebViewAdPlayer$show$5.create(p0, p1);
        AndroidFullscreenWebViewAdPlayer$show$5.invokeSuspend(Unit.INSTANCE);
        return AndroidFullscreenWebViewAdPlayer$show$5.invokeSuspend(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidFullscreenWebViewAdPlayer$show$5.invoke(p0, p1);
        return AndroidFullscreenWebViewAdPlayer$show$5.invoke(..);
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
        this$0.destroy(this);
        if (if-ne(AndroidFullscreenWebViewAdPlayer.destroy(..), "call to 'resume' before 'invoke' with coroutine")) goto L_28;
        return "call to 'resume' before 'invoke' with coroutine";
      L_28:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$6
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidFullscreenWebViewAdPlayer$show$6 extends FunctionReferenceImpl {
    AndroidFullscreenWebViewAdPlayer$show$6(Object p0) {
        new FunctionReferenceImpl(2, p0, AndroidFullscreenWebViewAdPlayer.class, "handleSessionChange", "handleSessionChange(Lcom/unity3d/ads/core/data/model/SessionChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        return;
    }

    public final Object invoke(SessionChange p0, Continuation p1) {
        AndroidFullscreenWebViewAdPlayer.access$handleSessionChange(receiver, p0, p1);
        return AndroidFullscreenWebViewAdPlayer.access$handleSessionChange(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidFullscreenWebViewAdPlayer$show$6.invoke(p0, p1);
        return AndroidFullscreenWebViewAdPlayer$show$6.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewClient$Companion
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidWebViewClient$Companion {
    private AndroidWebViewClient$Companion() {
        new Object();
        return;
    }

    public AndroidWebViewClient$Companion(DefaultConstructorMarker p0) {
        new AndroidWebViewClient$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer$2
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidWebViewContainer$2 extends SuspendLambda {
    int label;
    final AndroidWebViewContainer this$0;

    AndroidWebViewContainer$2(AndroidWebViewContainer p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidWebViewContainer$2(this$0, p1);
        return new AndroidWebViewContainer$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        p0.booleanValue();
        AndroidWebViewContainer$2.invoke(Boolean.booleanValue(..), p1);
        return AndroidWebViewContainer$2.invoke(..);
    }

    public final Object invoke(boolean p0, Continuation p1) {
        Boolean.valueOf(p0);
        AndroidWebViewContainer$2.create(Boolean.valueOf(..), p1);
        AndroidWebViewContainer$2.create(..).invokeSuspend(Unit.INSTANCE);
        return AndroidWebViewContainer$2.invokeSuspend(..);
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
        AndroidWebViewContainer.access$onRenderProcessGone(this$0, this);
        if (if-ne(AndroidWebViewContainer.access$onRenderProcessGone(..), "call to 'resume' before 'invoke' with coroutine")) goto L_28;
        return "call to 'resume' before 'invoke' with coroutine";
      L_28:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer$addJavascriptInterface$1
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidWebViewContainer$addJavascriptInterface$1 extends ContinuationImpl {
    int label;
    Object result;
    final AndroidWebViewContainer this$0;

    AndroidWebViewContainer$addJavascriptInterface$1(AndroidWebViewContainer p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.addJavascriptInterface(0, 0, this);
        return AndroidWebViewContainer.addJavascriptInterface(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer$addJavascriptInterface$2
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidWebViewContainer$addJavascriptInterface$2 extends SuspendLambda {
    final String $name;
    final WebViewBridge $webViewBridgeInterface;
    int label;
    final AndroidWebViewContainer this$0;

    AndroidWebViewContainer$addJavascriptInterface$2(AndroidWebViewContainer p0, String p1, WebViewBridge p2, Continuation p3) {
        this$0 = p0;
        $name = p1;
        $webViewBridgeInterface = p2;
        new SuspendLambda(2, p3);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidWebViewContainer$addJavascriptInterface$2(this$0, $name, $webViewBridgeInterface, p1);
        return new AndroidWebViewContainer$addJavascriptInterface$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidWebViewContainer$addJavascriptInterface$2.invoke(p0, p1);
        return AndroidWebViewContainer$addJavascriptInterface$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidWebViewContainer$addJavascriptInterface$2.create(p0, p1);
        AndroidWebViewContainer$addJavascriptInterface$2.invokeSuspend(Unit.INSTANCE);
        return AndroidWebViewContainer$addJavascriptInterface$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_1f;
        ResultKt.throwOnFailure(p0);
        new AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1($webViewBridgeInterface);
        this$0.getWebView();
        WebView.addJavascriptInterface(new AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1(..), $name);
        return Unit.INSTANCE;
      L_1f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1 {
    final WebViewBridge $webViewBridgeInterface;

    AndroidWebViewContainer$addJavascriptInterface$2$wrapper$1(WebViewBridge p0) {
        $webViewBridgeInterface = p0;
        new Object();
        return;
    }

    public void handleCallback(String p0, String p1, String p2) {
        $webViewBridgeInterface.handleCallback(p0, p1, p2);
        return;
    }

    public void handleInvocation(String p0) {
        $webViewBridgeInterface.handleInvocation(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer$destroy$1
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidWebViewContainer$destroy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final AndroidWebViewContainer this$0;

    AndroidWebViewContainer$destroy$1(AndroidWebViewContainer p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.destroy(this);
        return AndroidWebViewContainer.destroy(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer$destroy$2
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidWebViewContainer$destroy$2 extends SuspendLambda {
    int label;
    final AndroidWebViewContainer this$0;

    AndroidWebViewContainer$destroy$2(AndroidWebViewContainer p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidWebViewContainer$destroy$2(this$0, p1);
        return new AndroidWebViewContainer$destroy$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidWebViewContainer$destroy$2.invoke(p0, p1);
        return AndroidWebViewContainer$destroy$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidWebViewContainer$destroy$2.create(p0, p1);
        AndroidWebViewContainer$destroy$2.invokeSuspend(Unit.INSTANCE);
        return AndroidWebViewContainer$destroy$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_35;
        ResultKt.throwOnFailure(p0);
        this$0.getWebView();
        WebView.getParent();
        if (if-eqz(label)) goto L_1b;
      L_1b:
      L_1c:
        if (if-eqz(0)) goto L_29;
        this$0.getWebView();
        0.removeView(AndroidWebViewContainer.getWebView(..));
      L_29:
        this$0.getWebView();
        WebView.destroy();
        return Unit.INSTANCE;
      L_35:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer$evaluateJavascript$1
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidWebViewContainer$evaluateJavascript$1 extends ContinuationImpl {
    int label;
    Object result;
    final AndroidWebViewContainer this$0;

    AndroidWebViewContainer$evaluateJavascript$1(AndroidWebViewContainer p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.evaluateJavascript(0, this);
        return AndroidWebViewContainer.evaluateJavascript(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer$evaluateJavascript$2
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidWebViewContainer$evaluateJavascript$2 extends SuspendLambda {
    final String $script;
    int label;
    final AndroidWebViewContainer this$0;

    AndroidWebViewContainer$evaluateJavascript$2(AndroidWebViewContainer p0, String p1, Continuation p2) {
        this$0 = p0;
        $script = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidWebViewContainer$evaluateJavascript$2(this$0, $script, p1);
        return new AndroidWebViewContainer$evaluateJavascript$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidWebViewContainer$evaluateJavascript$2.invoke(p0, p1);
        return AndroidWebViewContainer$evaluateJavascript$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidWebViewContainer$evaluateJavascript$2.create(p0, p1);
        AndroidWebViewContainer$evaluateJavascript$2.invokeSuspend(Unit.INSTANCE);
        return AndroidWebViewContainer$evaluateJavascript$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_27;
        ResultKt.throwOnFailure(p0);
        this$0.getWebView();
        new StringBuilder("javascript:");
        new StringBuilder(..).append($script);
        new StringBuilder(..).toString();
        WebView.evaluateJavascript(StringBuilder.toString(..), 0);
        return Unit.INSTANCE;
      L_27:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer$loadUrl$1
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidWebViewContainer$loadUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final AndroidWebViewContainer this$0;

    AndroidWebViewContainer$loadUrl$1(AndroidWebViewContainer p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.loadUrl(0, this);
        return AndroidWebViewContainer.loadUrl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer$loadUrl$2
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidWebViewContainer$loadUrl$2 extends SuspendLambda {
    final String $url;
    int label;
    final AndroidWebViewContainer this$0;

    AndroidWebViewContainer$loadUrl$2(AndroidWebViewContainer p0, String p1, Continuation p2) {
        this$0 = p0;
        $url = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidWebViewContainer$loadUrl$2(this$0, $url, p1);
        return new AndroidWebViewContainer$loadUrl$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidWebViewContainer$loadUrl$2.invoke(p0, p1);
        return AndroidWebViewContainer$loadUrl$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidWebViewContainer$loadUrl$2.create(p0, p1);
        AndroidWebViewContainer$loadUrl$2.invokeSuspend(Unit.INSTANCE);
        return AndroidWebViewContainer$loadUrl$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_18;
        ResultKt.throwOnFailure(p0);
        this$0.getWebView();
        WebView.loadUrl($url);
        return Unit.INSTANCE;
      L_18:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer$onRenderProcessGone$1
// ============================================================
package com.unity3d.ads.adplayer;

final class AndroidWebViewContainer$onRenderProcessGone$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final AndroidWebViewContainer this$0;

    AndroidWebViewContainer$onRenderProcessGone$1(AndroidWebViewContainer p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        AndroidWebViewContainer.access$onRenderProcessGone(this$0, this);
        return AndroidWebViewContainer.access$onRenderProcessGone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer$special$$inlined$filter$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidWebViewContainer$special$$inlined$filter$1 {
    final Flow $this_unsafeTransform$inlined;

    public AndroidWebViewContainer$special$$inlined$filter$1(Flow p0) {
        $this_unsafeTransform$inlined = p0;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new AndroidWebViewContainer$special$$inlined$filter$1$2(p0);
        $this_unsafeTransform$inlined.collect(new AndroidWebViewContainer$special$$inlined$filter$1$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14;
        return Flow.collect(..);
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer$special$$inlined$filter$1$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidWebViewContainer$special$$inlined$filter$1$2 {
    final FlowCollector $this_unsafeFlow;

    public AndroidWebViewContainer$special$$inlined$filter$1$2(FlowCollector p0) {
        $this_unsafeFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidWebViewContainer$special$$inlined$filter$1$2$1(this, label);
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
        new IllegalStateException(..).booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_4c;
        label = 1;
        $this_unsafeFlow.emit(new IllegalStateException(..), new AndroidWebViewContainer$special$$inlined$filter$1$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4c;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4c:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.AndroidWebViewContainer$special$$inlined$filter$1$2$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class AndroidWebViewContainer$special$$inlined$filter$1$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final AndroidWebViewContainer$special$$inlined$filter$1$2 this$0;

    public AndroidWebViewContainer$special$$inlined$filter$1$2$1(AndroidWebViewContainer$special$$inlined$filter$1$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return AndroidWebViewContainer$special$$inlined$filter$1$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.CommonWebViewBridge$1
// ============================================================
package com.unity3d.ads.adplayer;

final class CommonWebViewBridge$1 extends SuspendLambda {
    int label;
    final CommonWebViewBridge this$0;

    CommonWebViewBridge$1(CommonWebViewBridge p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new CommonWebViewBridge$1(this$0, p1);
        return new CommonWebViewBridge$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        CommonWebViewBridge$1.invoke(p0, p1);
        return CommonWebViewBridge$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        CommonWebViewBridge$1.create(p0, p1);
        CommonWebViewBridge$1.create(..).invokeSuspend(Unit.INSTANCE);
        return CommonWebViewBridge$1.invokeSuspend(..);
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
        CommonWebViewBridge.access$getWebViewContainer$p(this$0);
        label = 1;
        WebViewContainer.addJavascriptInterface(this$0, "webviewbridge", this);
        if (if-ne(WebViewContainer.addJavascriptInterface(..), "call to 'resume' before 'invoke' with coroutine")) goto L_32;
        return "call to 'resume' before 'invoke' with coroutine";
      L_32:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.CommonWebViewBridge$handleInvocation$1
// ============================================================
package com.unity3d.ads.adplayer;

final class CommonWebViewBridge$handleInvocation$1 extends SuspendLambda {
    final String $callback;
    final String $location;
    final JSONArray $parameters;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final CommonWebViewBridge this$0;

    CommonWebViewBridge$handleInvocation$1(String p0, JSONArray p1, CommonWebViewBridge p2, String p3, Continuation p4) {
        $location = p0;
        $parameters = p1;
        this$0 = p2;
        $callback = p3;
        new SuspendLambda(2, p4);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new CommonWebViewBridge$handleInvocation$1($location, $parameters, this$0, $callback, p1);
        return new CommonWebViewBridge$handleInvocation$1;
    }

    public Object invoke(Object p0, Object p1) {
        CommonWebViewBridge$handleInvocation$1.invoke(p0, p1);
        return CommonWebViewBridge$handleInvocation$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        CommonWebViewBridge$handleInvocation$1.create(p0, p1);
        CommonWebViewBridge$handleInvocation$1.invokeSuspend(Unit.INSTANCE);
        return CommonWebViewBridge$handleInvocation$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_59;
        if (if-eq(label, 1)) goto L_51;
        if (if-eq(label, 2)) goto L_49;
        if (if-eq(label, 3)) goto L_2e;
        if (if-eq(label, 4)) goto L_26;
        if (if-ne(label, 5)) goto L_1e;
        ResultKt.throwOnFailure(p0);
      L_1e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_26:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_2e:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_49:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_51:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_59:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        JSONArrayExtensionsKt.toTypedArray($parameters);
        new Invocation($location, JSONArrayExtensionsKt.toTypedArray(..));
        CommonWebViewBridge.access$get_onInvocation$p(this$0);
        L$0 = new Invocation(..);
        label = 1;
        MutableSharedFlow.emit(new Invocation(..), this);
        if (if-ne(MutableSharedFlow.emit(..), "call to 'resume' before 'invoke' with coroutine")) goto L_7d;
        return "call to 'resume' before 'invoke' with coroutine";
      L_7d:
      L_7e:
        new CommonWebViewBridge$handleInvocation$1$1(new Invocation(..), 0);
        L$0 = new Invocation(..);
        label = L$3;
        TimeoutKt.withTimeout(5000L, L$0, new CommonWebViewBridge$handleInvocation$1$1(..), this);
        if (if-ne(TimeoutKt.withTimeout(..), "call to 'resume' before 'invoke' with coroutine")) goto L_95;
        return "call to 'resume' before 'invoke' with coroutine";
      L_95:
        L$0 = TimeoutKt.withTimeout(..);
        L$1 = this$0;
        L$2 = $callback;
        L$3 = "OK";
        L$4 = TimeoutKt.withTimeout(..);
        I$0 = 0;
        label = L$4;
        new Invocation(..).getResult(this);
        if (if-ne(Invocation.getResult(..), "call to 'resume' before 'invoke' with coroutine")) goto L_b5;
        return "call to 'resume' before 'invoke' with coroutine";
      L_b5:
      L_b9:
        L$0 = 0;
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        L$4 = 0;
        label = 4;
        CommonWebViewBridge.access$respond(this$0, $callback, "OK", TimeoutKt.withTimeout(..), this);
        if (if-ne(CommonWebViewBridge.access$respond(..), "call to 'resume' before 'invoke' with coroutine")) goto L_113;
        return "call to 'resume' before 'invoke' with coroutine";
      L_d1:
        if (if-eqz(0)) goto L_eb;
        new StringBuilder("Invocation(");
        new StringBuilder(..).append($location);
        new StringBuilder(..).append(") is not handled");
        new StringBuilder(..).toString();
      L_eb:
        StringBuilder.toString(..).getMessage();
        if (if-nez(Exception.getMessage(..))) goto L_f3;
      L_f3:
        L$0 = 0;
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        L$4 = 0;
        label = 5;
        CommonWebViewBridge.access$respond(this$0, $callback, "ERROR", TimeoutKt.withTimeout(..), this);
        if (if-ne(CommonWebViewBridge.access$respond(..), "call to 'resume' before 'invoke' with coroutine")) goto L_113;
        return "call to 'resume' before 'invoke' with coroutine";
      L_113:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.CommonWebViewBridge$handleInvocation$1$1
// ============================================================
package com.unity3d.ads.adplayer;

final class CommonWebViewBridge$handleInvocation$1$1 extends SuspendLambda {
    final Invocation $invocation;
    int label;

    CommonWebViewBridge$handleInvocation$1$1(Invocation p0, Continuation p1) {
        $invocation = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new CommonWebViewBridge$handleInvocation$1$1($invocation, p1);
        return new CommonWebViewBridge$handleInvocation$1$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        CommonWebViewBridge$handleInvocation$1$1.invoke(p0, p1);
        return CommonWebViewBridge$handleInvocation$1$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        CommonWebViewBridge$handleInvocation$1$1.create(p0, p1);
        CommonWebViewBridge$handleInvocation$1$1.invokeSuspend(Unit.INSTANCE);
        return CommonWebViewBridge$handleInvocation$1$1.invokeSuspend(..);
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
        $invocation.isHandled();
        label = 1;
        Invocation.isHandled(..).await(this);
        if (if-ne(Deferred.await(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2c;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2c:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.CommonWebViewBridge$request$1
// ============================================================
package com.unity3d.ads.adplayer;

final class CommonWebViewBridge$request$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final CommonWebViewBridge this$0;

    CommonWebViewBridge$request$1(CommonWebViewBridge p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.request(0, 0, 0, this);
        return CommonWebViewBridge.request(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.DisplayMessage$DisplayDestroyed
// ============================================================
package com.unity3d.ads.adplayer;

public final class DisplayMessage$DisplayDestroyed extends DisplayMessage {
    public DisplayMessage$DisplayDestroyed(String p0) {
        new DisplayMessage(p0, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.DisplayMessage$DisplayError
// ============================================================
package com.unity3d.ads.adplayer;

public final class DisplayMessage$DisplayError extends DisplayMessage {
    private final String reason;

    public DisplayMessage$DisplayError(String p0, String p1) {
        new DisplayMessage(p0, 0);
        reason = p1;
        return;
    }

    public final String getReason() {
        return reason;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.DisplayMessage$DisplayFinishRequest
// ============================================================
package com.unity3d.ads.adplayer;

public final class DisplayMessage$DisplayFinishRequest extends DisplayMessage {
    public DisplayMessage$DisplayFinishRequest(String p0) {
        new DisplayMessage(p0, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.DisplayMessage$DisplayReady
// ============================================================
package com.unity3d.ads.adplayer;

public final class DisplayMessage$DisplayReady extends DisplayMessage {
    private final Map showOptions;

    public DisplayMessage$DisplayReady(String p0, Map p1) {
        new DisplayMessage(p0, 0);
        showOptions = p1;
        return;
    }

    public DisplayMessage$DisplayReady(String p0, Map p1, int p2, DefaultConstructorMarker p3) {
        if (if-eqz(p2)) goto L_5;
      L_5:
        new DisplayMessage$DisplayReady(p0, 0);
        return;
    }

    public final Map getShowOptions() {
        return showOptions;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.DisplayMessage$FocusChanged
// ============================================================
package com.unity3d.ads.adplayer;

public final class DisplayMessage$FocusChanged extends DisplayMessage {
    private final boolean isFocused;

    public DisplayMessage$FocusChanged(String p0, boolean p1) {
        new DisplayMessage(p0, 0);
        isFocused = p1;
        return;
    }

    public final boolean isFocused() {
        return isFocused;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.DisplayMessage$VisibilityChanged
// ============================================================
package com.unity3d.ads.adplayer;

public final class DisplayMessage$VisibilityChanged extends DisplayMessage {
    private final boolean isVisible;

    public DisplayMessage$VisibilityChanged(String p0, boolean p1) {
        new DisplayMessage(p0, 0);
        isVisible = p1;
        return;
    }

    public final boolean isVisible() {
        return isVisible;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.DisplayMessage$WebViewInstanceRequest
// ============================================================
package com.unity3d.ads.adplayer;

public final class DisplayMessage$WebViewInstanceRequest extends DisplayMessage {
    public DisplayMessage$WebViewInstanceRequest(String p0) {
        new DisplayMessage(p0, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.DisplayMessage$WebViewInstanceResponse
// ============================================================
package com.unity3d.ads.adplayer;

public final class DisplayMessage$WebViewInstanceResponse extends DisplayMessage {
    private final WebView webView;

    public DisplayMessage$WebViewInstanceResponse(String p0, WebView p1) {
        new DisplayMessage(p0, 0);
        webView = p1;
        return;
    }

    public final WebView getWebView() {
        return webView;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.EmbeddableAdPlayer$DefaultImpls
// ============================================================
package com.unity3d.ads.adplayer;

public final class EmbeddableAdPlayer$DefaultImpls {
    public static Object destroy(EmbeddableAdPlayer p0, Continuation p1) {
        AdPlayer$DefaultImpls.destroy(p0, p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(AdPlayer$DefaultImpls.destroy(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_d;
        return AdPlayer$DefaultImpls.destroy(..);
      L_d:
        return Unit.INSTANCE;
    }

    public static void show(EmbeddableAdPlayer p0, ShowOptions p1) {
        AdPlayer$DefaultImpls.show(p0, p1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1 {
    final Flow $this_unsafeTransform$inlined;
    final FullScreenWebViewDisplay this$0;

    public FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1(Flow p0, FullScreenWebViewDisplay p1) {
        $this_unsafeTransform$inlined = p0;
        this$0 = p1;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2(p0, this$0);
        $this_unsafeTransform$inlined.collect(new FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_16;
        return Flow.collect(..);
      L_16:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2 {
    final FlowCollector $this_unsafeFlow;
    final FullScreenWebViewDisplay this$0;

    public FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2(FlowCollector p0, FullScreenWebViewDisplay p1) {
        $this_unsafeFlow = p0;
        this$0 = p1;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2$1(this, label);
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
        new IllegalStateException(..).getOpportunityId();
        FullScreenWebViewDisplay.access$getOpportunityId$p(this$0);
        Intrinsics.areEqual(DisplayMessage.getOpportunityId(..), FullScreenWebViewDisplay.access$getOpportunityId$p(..));
        if (if-eqz(Intrinsics.areEqual(..))) goto L_56;
        label = 1;
        $this_unsafeFlow.emit(new IllegalStateException(..), new FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_56;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_56:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2 this$0;

    public FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2$1(FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return FullScreenWebViewDisplay$listenToAdPlayerEvents$$inlined$filter$1$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$listenToAdPlayerEvents$2
// ============================================================
package com.unity3d.ads.adplayer;

final class FullScreenWebViewDisplay$listenToAdPlayerEvents$2 extends SuspendLambda {
    Object L$0;
    int label;
    final FullScreenWebViewDisplay this$0;

    FullScreenWebViewDisplay$listenToAdPlayerEvents$2(FullScreenWebViewDisplay p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new FullScreenWebViewDisplay$listenToAdPlayerEvents$2(this$0, p1);
        L$0 = p0;
        return new FullScreenWebViewDisplay$listenToAdPlayerEvents$2(..);
    }

    public final Object invoke(DisplayMessage p0, Continuation p1) {
        FullScreenWebViewDisplay$listenToAdPlayerEvents$2.create(p0, p1);
        FullScreenWebViewDisplay$listenToAdPlayerEvents$2.invokeSuspend(Unit.INSTANCE);
        return FullScreenWebViewDisplay$listenToAdPlayerEvents$2.invokeSuspend(..);
    }

    public Object invoke(Object p0, Object p1) {
        FullScreenWebViewDisplay$listenToAdPlayerEvents$2.invoke(p0, p1);
        return FullScreenWebViewDisplay$listenToAdPlayerEvents$2.invoke(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_2a;
        ResultKt.throwOnFailure(p0);
        if (if-eqz(label)) goto L_18;
        this$0.finish();
      L_18:
        if (if-eqz(label)) goto L_27;
        this$0.getWebView();
        FullScreenWebViewDisplay.access$loadWebView(this$0, DisplayMessage$WebViewInstanceResponse.getWebView(..));
      L_27:
        return Unit.INSTANCE;
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$loadWebView$1
// ============================================================
package com.unity3d.ads.adplayer;

final class FullScreenWebViewDisplay$loadWebView$1 extends SuspendLambda {
    final WebView $webView;
    int label;
    final FullScreenWebViewDisplay this$0;

    FullScreenWebViewDisplay$loadWebView$1(FullScreenWebViewDisplay p0, WebView p1, Continuation p2) {
        this$0 = p0;
        $webView = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new FullScreenWebViewDisplay$loadWebView$1(this$0, $webView, p1);
        return new FullScreenWebViewDisplay$loadWebView$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        FullScreenWebViewDisplay$loadWebView$1.invoke(p0, p1);
        return FullScreenWebViewDisplay$loadWebView$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        FullScreenWebViewDisplay$loadWebView$1.create(p0, p1);
        FullScreenWebViewDisplay$loadWebView$1.invokeSuspend(Unit.INSTANCE);
        return FullScreenWebViewDisplay$loadWebView$1.invokeSuspend(..);
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
        this$0.setContentView($webView);
        AndroidFullscreenWebViewAdPlayer$Companion.getDisplayMessages();
        FullScreenWebViewDisplay.access$getOpportunityId$p(this$0);
        FullScreenWebViewDisplay.access$getShowOptions$p(this$0);
        new DisplayMessage$DisplayReady(FullScreenWebViewDisplay.access$getOpportunityId$p(..), FullScreenWebViewDisplay.access$getShowOptions$p(..));
        label = 1;
        MutableSharedFlow.emit(new DisplayMessage$DisplayReady(..), this);
        if (if-ne(MutableSharedFlow.emit(..), "call to 'resume' before 'invoke' with coroutine")) goto L_46;
        return "call to 'resume' before 'invoke' with coroutine";
      L_46:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onCreate$1$1
// ============================================================
package com.unity3d.ads.adplayer;

final class FullScreenWebViewDisplay$onCreate$1$1 extends SuspendLambda {
    final FullScreenWebViewDisplay $this_run;
    int label;

    FullScreenWebViewDisplay$onCreate$1$1(FullScreenWebViewDisplay p0, Continuation p1) {
        $this_run = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new FullScreenWebViewDisplay$onCreate$1$1($this_run, p1);
        return new FullScreenWebViewDisplay$onCreate$1$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        FullScreenWebViewDisplay$onCreate$1$1.invoke(p0, p1);
        return FullScreenWebViewDisplay$onCreate$1$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        FullScreenWebViewDisplay$onCreate$1$1.create(p0, p1);
        FullScreenWebViewDisplay$onCreate$1$1.invokeSuspend(Unit.INSTANCE);
        return FullScreenWebViewDisplay$onCreate$1$1.invokeSuspend(..);
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
        AndroidFullscreenWebViewAdPlayer$Companion.getDisplayMessages();
        FullScreenWebViewDisplay.access$getOpportunityId$p($this_run);
        new DisplayMessage$DisplayError(FullScreenWebViewDisplay.access$getOpportunityId$p(..), "Opportunity ID not found");
        label = 1;
        MutableSharedFlow.emit(new DisplayMessage$DisplayError(..), this);
        if (if-ne(MutableSharedFlow.emit(..), "call to 'resume' before 'invoke' with coroutine")) goto L_39;
        return "call to 'resume' before 'invoke' with coroutine";
      L_39:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onCreate$5
// ============================================================
package com.unity3d.ads.adplayer;

final class FullScreenWebViewDisplay$onCreate$5 extends SuspendLambda {
    int label;
    final FullScreenWebViewDisplay this$0;

    FullScreenWebViewDisplay$onCreate$5(FullScreenWebViewDisplay p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new FullScreenWebViewDisplay$onCreate$5(this$0, p1);
        return new FullScreenWebViewDisplay$onCreate$5(..);
    }

    public Object invoke(Object p0, Object p1) {
        FullScreenWebViewDisplay$onCreate$5.invoke(p0, p1);
        return FullScreenWebViewDisplay$onCreate$5.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        FullScreenWebViewDisplay$onCreate$5.create(p0, p1);
        FullScreenWebViewDisplay$onCreate$5.invokeSuspend(Unit.INSTANCE);
        return FullScreenWebViewDisplay$onCreate$5.invokeSuspend(..);
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
        AndroidFullscreenWebViewAdPlayer$Companion.getDisplayMessages();
        FullScreenWebViewDisplay.access$getOpportunityId$p(this$0);
        new DisplayMessage$WebViewInstanceRequest(FullScreenWebViewDisplay.access$getOpportunityId$p(..));
        label = 1;
        MutableSharedFlow.emit(new DisplayMessage$WebViewInstanceRequest(..), this);
        if (if-ne(MutableSharedFlow.emit(..), "call to 'resume' before 'invoke' with coroutine")) goto L_37;
        return "call to 'resume' before 'invoke' with coroutine";
      L_37:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onDestroy$1
// ============================================================
package com.unity3d.ads.adplayer;

final class FullScreenWebViewDisplay$onDestroy$1 extends SuspendLambda {
    int label;
    final FullScreenWebViewDisplay this$0;

    FullScreenWebViewDisplay$onDestroy$1(FullScreenWebViewDisplay p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new FullScreenWebViewDisplay$onDestroy$1(this$0, p1);
        return new FullScreenWebViewDisplay$onDestroy$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        FullScreenWebViewDisplay$onDestroy$1.invoke(p0, p1);
        return FullScreenWebViewDisplay$onDestroy$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        FullScreenWebViewDisplay$onDestroy$1.create(p0, p1);
        FullScreenWebViewDisplay$onDestroy$1.invokeSuspend(Unit.INSTANCE);
        return FullScreenWebViewDisplay$onDestroy$1.invokeSuspend(..);
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
        AndroidFullscreenWebViewAdPlayer$Companion.getDisplayMessages();
        FullScreenWebViewDisplay.access$getOpportunityId$p(this$0);
        new DisplayMessage$DisplayDestroyed(FullScreenWebViewDisplay.access$getOpportunityId$p(..));
        label = 1;
        MutableSharedFlow.emit(new DisplayMessage$DisplayDestroyed(..), this);
        if (if-ne(MutableSharedFlow.emit(..), "call to 'resume' before 'invoke' with coroutine")) goto L_37;
        return "call to 'resume' before 'invoke' with coroutine";
      L_37:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onPause$1
// ============================================================
package com.unity3d.ads.adplayer;

final class FullScreenWebViewDisplay$onPause$1 extends SuspendLambda {
    int label;
    final FullScreenWebViewDisplay this$0;

    FullScreenWebViewDisplay$onPause$1(FullScreenWebViewDisplay p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new FullScreenWebViewDisplay$onPause$1(this$0, p1);
        return new FullScreenWebViewDisplay$onPause$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        FullScreenWebViewDisplay$onPause$1.invoke(p0, p1);
        return FullScreenWebViewDisplay$onPause$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        FullScreenWebViewDisplay$onPause$1.create(p0, p1);
        FullScreenWebViewDisplay$onPause$1.invokeSuspend(Unit.INSTANCE);
        return FullScreenWebViewDisplay$onPause$1.invokeSuspend(..);
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
        AndroidFullscreenWebViewAdPlayer$Companion.getDisplayMessages();
        FullScreenWebViewDisplay.access$getOpportunityId$p(this$0);
        new DisplayMessage$VisibilityChanged(FullScreenWebViewDisplay.access$getOpportunityId$p(..), 0);
        label = 1;
        MutableSharedFlow.emit(new DisplayMessage$VisibilityChanged(..), this);
        if (if-ne(MutableSharedFlow.emit(..), "call to 'resume' before 'invoke' with coroutine")) goto L_38;
        return "call to 'resume' before 'invoke' with coroutine";
      L_38:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onResume$1
// ============================================================
package com.unity3d.ads.adplayer;

final class FullScreenWebViewDisplay$onResume$1 extends SuspendLambda {
    int label;
    final FullScreenWebViewDisplay this$0;

    FullScreenWebViewDisplay$onResume$1(FullScreenWebViewDisplay p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new FullScreenWebViewDisplay$onResume$1(this$0, p1);
        return new FullScreenWebViewDisplay$onResume$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        FullScreenWebViewDisplay$onResume$1.invoke(p0, p1);
        return FullScreenWebViewDisplay$onResume$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        FullScreenWebViewDisplay$onResume$1.create(p0, p1);
        FullScreenWebViewDisplay$onResume$1.invokeSuspend(Unit.INSTANCE);
        return FullScreenWebViewDisplay$onResume$1.invokeSuspend(..);
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
        AndroidFullscreenWebViewAdPlayer$Companion.getDisplayMessages();
        FullScreenWebViewDisplay.access$getOpportunityId$p(this$0);
        new DisplayMessage$VisibilityChanged(FullScreenWebViewDisplay.access$getOpportunityId$p(..), 1);
        label = 1;
        MutableSharedFlow.emit(new DisplayMessage$VisibilityChanged(..), this);
        if (if-ne(MutableSharedFlow.emit(..), "call to 'resume' before 'invoke' with coroutine")) goto L_37;
        return "call to 'resume' before 'invoke' with coroutine";
      L_37:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$onWindowFocusChanged$1
// ============================================================
package com.unity3d.ads.adplayer;

final class FullScreenWebViewDisplay$onWindowFocusChanged$1 extends SuspendLambda {
    final boolean $hasFocus;
    int label;
    final FullScreenWebViewDisplay this$0;

    FullScreenWebViewDisplay$onWindowFocusChanged$1(FullScreenWebViewDisplay p0, boolean p1, Continuation p2) {
        this$0 = p0;
        $hasFocus = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new FullScreenWebViewDisplay$onWindowFocusChanged$1(this$0, $hasFocus, p1);
        return new FullScreenWebViewDisplay$onWindowFocusChanged$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        FullScreenWebViewDisplay$onWindowFocusChanged$1.invoke(p0, p1);
        return FullScreenWebViewDisplay$onWindowFocusChanged$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        FullScreenWebViewDisplay$onWindowFocusChanged$1.create(p0, p1);
        FullScreenWebViewDisplay$onWindowFocusChanged$1.invokeSuspend(Unit.INSTANCE);
        return FullScreenWebViewDisplay$onWindowFocusChanged$1.invokeSuspend(..);
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
        AndroidFullscreenWebViewAdPlayer$Companion.getDisplayMessages();
        FullScreenWebViewDisplay.access$getOpportunityId$p(this$0);
        new DisplayMessage$FocusChanged(FullScreenWebViewDisplay.access$getOpportunityId$p(..), $hasFocus);
        label = 1;
        MutableSharedFlow.emit(new DisplayMessage$FocusChanged(..), this);
        if (if-ne(MutableSharedFlow.emit(..), "call to 'resume' before 'invoke' with coroutine")) goto L_39;
        return "call to 'resume' before 'invoke' with coroutine";
      L_39:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.FullscreenAdPlayer$DefaultImpls
// ============================================================
package com.unity3d.ads.adplayer;

public final class FullscreenAdPlayer$DefaultImpls {
    public static Object destroy(FullscreenAdPlayer p0, Continuation p1) {
        AdPlayer$DefaultImpls.destroy(p0, p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(AdPlayer$DefaultImpls.destroy(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_d;
        return AdPlayer$DefaultImpls.destroy(..);
      L_d:
        return Unit.INSTANCE;
    }

    public static void show(FullscreenAdPlayer p0, ShowOptions p1) {
        AdPlayer$DefaultImpls.show(p0, p1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.Invocation$handle$2
// ============================================================
package com.unity3d.ads.adplayer;

final class Invocation$handle$2 extends SuspendLambda {
    int label;

    Invocation$handle$2(Continuation p0) {
        new SuspendLambda(1, p0);
        return;
    }

    public final Continuation create(Continuation p0) {
        new Invocation$handle$2(p0);
        return new Invocation$handle$2(..);
    }

    public Object invoke(Object p0) {
        Invocation$handle$2.invoke(p0);
        return Invocation$handle$2.invoke(..);
    }

    public final Object invoke(Continuation p0) {
        Invocation$handle$2.create(p0);
        Invocation$handle$2.create(..).invokeSuspend(Unit.INSTANCE);
        return Invocation$handle$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_d;
        ResultKt.throwOnFailure(p0);
        return Unit.INSTANCE;
      L_d:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.Invocation$handle$3
// ============================================================
package com.unity3d.ads.adplayer;

final class Invocation$handle$3 extends SuspendLambda {
    final Function1 $handler;
    int label;
    final Invocation this$0;

    Invocation$handle$3(Function1 p0, Invocation p1, Continuation p2) {
        $handler = p0;
        this$0 = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new Invocation$handle$3($handler, this$0, p1);
        return new Invocation$handle$3(..);
    }

    public Object invoke(Object p0, Object p1) {
        Invocation$handle$3.invoke(p0, p1);
        return Invocation$handle$3.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        Invocation$handle$3.create(p0, p1);
        Invocation$handle$3.create(..).invokeSuspend(Unit.INSTANCE);
        return Invocation$handle$3.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_19;
        if (if-ne(label, 1)) goto L_11;
        ResultKt.throwOnFailure(p0);
      L_11:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_19:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        label = 1;
        $handler.invoke(this);
        if (if-ne(Function1.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_27;
        return "call to 'resume' before 'invoke' with coroutine";
      L_27:
        Invocation.access$getCompletableDeferred$p(this$0);
        CompletableDeferred.complete(Function1.invoke(..));
      L_31:
        Invocation.access$getCompletableDeferred$p(this$0);
        CompletableDeferred.completeExceptionally(Function1.invoke(..));
      L_3a:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$1
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$1 extends FunctionReferenceImpl {
    WebViewAdPlayer$1(Object p0) {
        new FunctionReferenceImpl(2, p0, MutableSharedFlow.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        return;
    }

    public Object invoke(Object p0, Object p1) {
        WebViewAdPlayer$1.invoke(p0, p1);
        return WebViewAdPlayer$1.invoke(..);
    }

    public final Object invoke(String p0, Continuation p1) {
        receiver.emit(p0, p1);
        return MutableSharedFlow.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$2
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$2 extends FunctionReferenceImpl {
    WebViewAdPlayer$2(Object p0) {
        new FunctionReferenceImpl(2, p0, WebViewAdPlayer.class, "onBroadcastEvent", "onBroadcastEvent(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        return;
    }

    public Object invoke(Object p0, Object p1) {
        WebViewAdPlayer$2.invoke(p0, p1);
        return WebViewAdPlayer$2.invoke(..);
    }

    public final Object invoke(String p0, Continuation p1) {
        receiver.onBroadcastEvent(p0, p1);
        return WebViewAdPlayer.onBroadcastEvent(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$onAllowedPiiChange$2
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$onAllowedPiiChange$2 extends Lambda {
    final byte[] $value;

    WebViewAdPlayer$onAllowedPiiChange$2(byte[] p0) {
        $value = p0;
        new Lambda(0);
        return;
    }

    public final WebViewEvent invoke() {
        Base64.encodeToString($value, 2);
        new OnAllowedPiiChangeEvent(Base64.encodeToString(..));
        return new OnAllowedPiiChangeEvent(..);
    }

    public Object invoke() {
        WebViewAdPlayer$onAllowedPiiChange$2.invoke();
        return WebViewAdPlayer$onAllowedPiiChange$2.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$onBroadcastEvent$2
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$onBroadcastEvent$2 extends Lambda {
    final String $event;

    WebViewAdPlayer$onBroadcastEvent$2(String p0) {
        $event = p0;
        new Lambda(0);
        return;
    }

    public final WebViewEvent invoke() {
        new JSONObject($event);
        new JSONObject(..).getString("eventType");
        new JSONObject(..).optString("data");
        new OnBroadcastEvent(JSONObject.getString(..), JSONObject.optString(..));
        return new OnBroadcastEvent(..);
    }

    public Object invoke() {
        WebViewAdPlayer$onBroadcastEvent$2.invoke();
        return WebViewAdPlayer$onBroadcastEvent$2.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$onShowEvent$3
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$onShowEvent$3 extends SuspendLambda {
    Object L$0;
    boolean Z$0;
    int label;

    WebViewAdPlayer$onShowEvent$3(Continuation p0) {
        new SuspendLambda(3, p0);
        return;
    }

    public final Object invoke(ShowEvent p0, boolean p1, Continuation p2) {
        new WebViewAdPlayer$onShowEvent$3(p2);
        L$0 = p0;
        Z$0 = p1;
        WebViewAdPlayer$onShowEvent$3.invokeSuspend(Unit.INSTANCE);
        return WebViewAdPlayer$onShowEvent$3.invokeSuspend(..);
    }

    public Object invoke(Object p0, Object p1, Object p2) {
        p1.booleanValue();
        WebViewAdPlayer$onShowEvent$3.invoke(p0, Boolean.booleanValue(..), p2);
        return WebViewAdPlayer$onShowEvent$3.invoke(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_1c;
        ResultKt.throwOnFailure(p0);
        if (if-eqz(Z$0)) goto L_1b;
        new ShowEvent$Completed(ShowStatus.COMPLETED);
      L_1b:
        return new ShowEvent$Completed(..);
      L_1c:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$requestShow$1
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$requestShow$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    Object result;
    final WebViewAdPlayer this$0;

    WebViewAdPlayer$requestShow$1(WebViewAdPlayer p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.requestShow(0, this);
        return WebViewAdPlayer.requestShow(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$sendActivityDestroyed$2
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$sendActivityDestroyed$2 extends Lambda {
    public static final WebViewAdPlayer$sendActivityDestroyed$2 INSTANCE;

    static <clinit>() {
        new WebViewAdPlayer$sendActivityDestroyed$2();
        INSTANCE = new WebViewAdPlayer$sendActivityDestroyed$2(..);
        return;
    }

    WebViewAdPlayer$sendActivityDestroyed$2() {
        new Lambda(0);
        return;
    }

    public final WebViewEvent invoke() {
        new OnActivityDestroyedEvent();
        return new OnActivityDestroyedEvent(..);
    }

    public Object invoke() {
        WebViewAdPlayer$sendActivityDestroyed$2.invoke();
        return WebViewAdPlayer$sendActivityDestroyed$2.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$sendEvent$1
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$sendEvent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final WebViewAdPlayer this$0;

    WebViewAdPlayer$sendEvent$1(WebViewAdPlayer p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        WebViewAdPlayer.access$sendEvent(this$0, 0, this);
        return WebViewAdPlayer.access$sendEvent(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$sendFocusChange$2
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$sendFocusChange$2 extends Lambda {
    final boolean $isFocused;

    WebViewAdPlayer$sendFocusChange$2(boolean p0) {
        $isFocused = p0;
        new Lambda(0);
        return;
    }

    public final WebViewEvent invoke() {
        new OnFocusChangeEvent($isFocused);
        return new OnFocusChangeEvent(..);
    }

    public Object invoke() {
        WebViewAdPlayer$sendFocusChange$2.invoke();
        return WebViewAdPlayer$sendFocusChange$2.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$sendMuteChange$2
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$sendMuteChange$2 extends Lambda {
    final boolean $isMuted;

    WebViewAdPlayer$sendMuteChange$2(boolean p0) {
        $isMuted = p0;
        new Lambda(0);
        return;
    }

    public final WebViewEvent invoke() {
        new OnMuteChangeEvent($isMuted);
        return new OnMuteChangeEvent(..);
    }

    public Object invoke() {
        WebViewAdPlayer$sendMuteChange$2.invoke();
        return WebViewAdPlayer$sendMuteChange$2.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$sendPrivacyFsmChange$2
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$sendPrivacyFsmChange$2 extends Lambda {
    final byte[] $value;

    WebViewAdPlayer$sendPrivacyFsmChange$2(byte[] p0) {
        $value = p0;
        new Lambda(0);
        return;
    }

    public final WebViewEvent invoke() {
        Base64.encodeToString($value, 2);
        new OnPrivacyFsmChangeEvent(Base64.encodeToString(..));
        return new OnPrivacyFsmChangeEvent(..);
    }

    public Object invoke() {
        WebViewAdPlayer$sendPrivacyFsmChange$2.invoke();
        return WebViewAdPlayer$sendPrivacyFsmChange$2.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$sendUserConsentChange$2
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$sendUserConsentChange$2 extends Lambda {
    final byte[] $value;

    WebViewAdPlayer$sendUserConsentChange$2(byte[] p0) {
        $value = p0;
        new Lambda(0);
        return;
    }

    public final WebViewEvent invoke() {
        Base64.encodeToString($value, 2);
        new OnUserConsentChangeEvent(Base64.encodeToString(..));
        return new OnUserConsentChangeEvent(..);
    }

    public Object invoke() {
        WebViewAdPlayer$sendUserConsentChange$2.invoke();
        return WebViewAdPlayer$sendUserConsentChange$2.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$sendVisibilityChange$2
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$sendVisibilityChange$2 extends Lambda {
    final boolean $isVisible;

    WebViewAdPlayer$sendVisibilityChange$2(boolean p0) {
        $isVisible = p0;
        new Lambda(0);
        return;
    }

    public final WebViewEvent invoke() {
        new OnVisibilityChangeEvent($isVisible);
        return new OnVisibilityChangeEvent(..);
    }

    public Object invoke() {
        WebViewAdPlayer$sendVisibilityChange$2.invoke();
        return WebViewAdPlayer$sendVisibilityChange$2.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$sendVolumeChange$2
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$sendVolumeChange$2 extends Lambda {
    final double $volume;

    WebViewAdPlayer$sendVolumeChange$2(double p0) {
        $volume = p0;
        new Lambda(0);
        return;
    }

    public final WebViewEvent invoke() {
        new OnVolumeChangeEvent($volume, v2);
        return new OnVolumeChangeEvent(..);
    }

    public Object invoke() {
        WebViewAdPlayer$sendVolumeChange$2.invoke();
        return WebViewAdPlayer$sendVolumeChange$2.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement {
    final WebViewAdPlayer this$0;

    public WebViewAdPlayer$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler$Key p0, WebViewAdPlayer p1) {
        this$0 = p1;
        new AbstractCoroutineContextElement(p0);
        return;
    }

    public void handleException(CoroutineContext p0, Throwable p1) {
        WebViewAdPlayer.access$getStorageEventCallback$p(this$0);
        Storage.Companion.removeStorageEventCallback(WebViewAdPlayer.access$getStorageEventCallback$p(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$1 {
    final Flow $this_unsafeTransform$inlined;

    public WebViewAdPlayer$special$$inlined$filter$1(Flow p0) {
        $this_unsafeTransform$inlined = p0;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new WebViewAdPlayer$special$$inlined$filter$1$2(p0);
        $this_unsafeTransform$inlined.collect(new WebViewAdPlayer$special$$inlined$filter$1$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14;
        return Flow.collect(..);
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$1$2 {
    final FlowCollector $this_unsafeFlow;

    public WebViewAdPlayer$special$$inlined$filter$1$2(FlowCollector p0) {
        $this_unsafeFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new WebViewAdPlayer$special$$inlined$filter$1$2$1(this, label);
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
        WebViewAdPlayerKt.access$getSHOW_EVENTS$p();
        new IllegalStateException(..).getLocation();
        ArraysKt.contains(WebViewAdPlayerKt.access$getSHOW_EVENTS$p(..), Invocation.getLocation(..));
        if (if-eqz(ArraysKt.contains(..))) goto L_54;
        label = 1;
        $this_unsafeFlow.emit(new IllegalStateException(..), new WebViewAdPlayer$special$$inlined$filter$1$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_54;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_54:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$1$2$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$1$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final WebViewAdPlayer$special$$inlined$filter$1$2 this$0;

    public WebViewAdPlayer$special$$inlined$filter$1$2$1(WebViewAdPlayer$special$$inlined$filter$1$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return WebViewAdPlayer$special$$inlined$filter$1$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$2 {
    final Flow $this_unsafeTransform$inlined;

    public WebViewAdPlayer$special$$inlined$filter$2(Flow p0) {
        $this_unsafeTransform$inlined = p0;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new WebViewAdPlayer$special$$inlined$filter$2$2(p0);
        $this_unsafeTransform$inlined.collect(new WebViewAdPlayer$special$$inlined$filter$2$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14;
        return Flow.collect(..);
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$2$2 {
    final FlowCollector $this_unsafeFlow;

    public WebViewAdPlayer$special$$inlined$filter$2$2(FlowCollector p0) {
        $this_unsafeFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new WebViewAdPlayer$special$$inlined$filter$2$2$1(this, label);
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
        WebViewAdPlayerKt.access$getLOAD_EVENTS$p();
        new IllegalStateException(..).getLocation();
        ArraysKt.contains(WebViewAdPlayerKt.access$getLOAD_EVENTS$p(..), Invocation.getLocation(..));
        if (if-eqz(ArraysKt.contains(..))) goto L_54;
        label = 1;
        $this_unsafeFlow.emit(new IllegalStateException(..), new WebViewAdPlayer$special$$inlined$filter$2$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_54;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_54:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$2$2$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$2$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final WebViewAdPlayer$special$$inlined$filter$2$2 this$0;

    public WebViewAdPlayer$special$$inlined$filter$2$2$1(WebViewAdPlayer$special$$inlined$filter$2$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return WebViewAdPlayer$special$$inlined$filter$2$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$3 {
    final Flow $this_unsafeTransform$inlined;

    public WebViewAdPlayer$special$$inlined$filter$3(Flow p0) {
        $this_unsafeTransform$inlined = p0;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new WebViewAdPlayer$special$$inlined$filter$3$2(p0);
        $this_unsafeTransform$inlined.collect(new WebViewAdPlayer$special$$inlined$filter$3$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14;
        return Flow.collect(..);
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$3$2 {
    final FlowCollector $this_unsafeFlow;

    public WebViewAdPlayer$special$$inlined$filter$3$2(FlowCollector p0) {
        $this_unsafeFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new WebViewAdPlayer$special$$inlined$filter$3$2$1(this, label);
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
        new IllegalStateException(..).getLocation();
        Intrinsics.areEqual(Invocation.getLocation(..), "com.unity3d.services.ads.api.AdViewer.updateCampaignState");
        if (if-eqz(Intrinsics.areEqual(..))) goto L_52;
        label = 1;
        $this_unsafeFlow.emit(new IllegalStateException(..), new WebViewAdPlayer$special$$inlined$filter$3$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_52;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_52:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$3$2$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$3$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final WebViewAdPlayer$special$$inlined$filter$3$2 this$0;

    public WebViewAdPlayer$special$$inlined$filter$3$2$1(WebViewAdPlayer$special$$inlined$filter$3$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return WebViewAdPlayer$special$$inlined$filter$3$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$4 {
    final Flow $this_unsafeTransform$inlined;

    public WebViewAdPlayer$special$$inlined$filter$4(Flow p0) {
        $this_unsafeTransform$inlined = p0;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new WebViewAdPlayer$special$$inlined$filter$4$2(p0);
        $this_unsafeTransform$inlined.collect(new WebViewAdPlayer$special$$inlined$filter$4$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14;
        return Flow.collect(..);
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$4$2 {
    final FlowCollector $this_unsafeFlow;

    public WebViewAdPlayer$special$$inlined$filter$4$2(FlowCollector p0) {
        $this_unsafeFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new WebViewAdPlayer$special$$inlined$filter$4$2$1(this, label);
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
        new IllegalStateException(..).getLocation();
        Intrinsics.areEqual(Invocation.getLocation(..), "com.unity3d.services.ads.api.AdViewer.broadcastEvent");
        if (if-eqz(Intrinsics.areEqual(..))) goto L_52;
        label = 1;
        $this_unsafeFlow.emit(new IllegalStateException(..), new WebViewAdPlayer$special$$inlined$filter$4$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_52;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_52:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$4$2$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$4$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final WebViewAdPlayer$special$$inlined$filter$4$2 this$0;

    public WebViewAdPlayer$special$$inlined$filter$4$2$1(WebViewAdPlayer$special$$inlined$filter$4$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return WebViewAdPlayer$special$$inlined$filter$4$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$5 {
    final Flow $this_unsafeTransform$inlined;

    public WebViewAdPlayer$special$$inlined$filter$5(Flow p0) {
        $this_unsafeTransform$inlined = p0;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new WebViewAdPlayer$special$$inlined$filter$5$2(p0);
        $this_unsafeTransform$inlined.collect(new WebViewAdPlayer$special$$inlined$filter$5$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14;
        return Flow.collect(..);
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$5$2 {
    final FlowCollector $this_unsafeFlow;

    public WebViewAdPlayer$special$$inlined$filter$5$2(FlowCollector p0) {
        $this_unsafeFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new WebViewAdPlayer$special$$inlined$filter$5$2$1(this, label);
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
        WebViewAdPlayerKt.access$getREQUEST_EVENTS$p();
        new IllegalStateException(..).getLocation();
        ArraysKt.contains(WebViewAdPlayerKt.access$getREQUEST_EVENTS$p(..), Invocation.getLocation(..));
        if (if-eqz(ArraysKt.contains(..))) goto L_54;
        label = 1;
        $this_unsafeFlow.emit(new IllegalStateException(..), new WebViewAdPlayer$special$$inlined$filter$5$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_54;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_54:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$filter$5$2$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$filter$5$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final WebViewAdPlayer$special$$inlined$filter$5$2 this$0;

    public WebViewAdPlayer$special$$inlined$filter$5$2$1(WebViewAdPlayer$special$$inlined$filter$5$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return WebViewAdPlayer$special$$inlined$filter$5$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$1 {
    final Flow $this_unsafeTransform$inlined;

    public WebViewAdPlayer$special$$inlined$map$1(Flow p0) {
        $this_unsafeTransform$inlined = p0;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new WebViewAdPlayer$special$$inlined$map$1$2(p0);
        $this_unsafeTransform$inlined.collect(new WebViewAdPlayer$special$$inlined$map$1$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14;
        return Flow.collect(..);
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$1$2 {
    final FlowCollector $this_unsafeFlow;

    public WebViewAdPlayer$special$$inlined$map$1$2(FlowCollector p0) {
        $this_unsafeFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new WebViewAdPlayer$special$$inlined$map$1$2$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_44;
        if (if-eq(label, 1)) goto L_37;
        if (if-ne(label, 2)) goto L_2f;
        ResultKt.throwOnFailure(result);
      L_2f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_37:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_44:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        L$1.getLocation();
        Invocation.getLocation(..).hashCode();
        Invocation.getLocation(..).equals("com.unity3d.services.ads.api.AdViewer.failed");
        if (if-eqz(String.equals(..))) goto L_118;
        L$1.getParameters();
        ArraysKt.first(Invocation.getParameters(..));
        Intrinsics.checkNotNull(ArraysKt.first(..), "null cannot be cast to non-null type org.json.JSONObject");
        ArraysKt.first(..).optInt("code");
        ArraysKt.first(..).optString("message");
        new ShowEvent$Error(JSONObject.optString(..), JSONObject.optInt(..), "adviewer");
        new ShowEvent$Error(..).equals("com.unity3d.services.ads.api.AdViewer.started");
        if (if-eqz(String.equals(..))) goto L_118;
        ShowEvent$Started.INSTANCE.equals("com.unity3d.services.ads.api.AdViewer.clicked");
        if (if-eqz(String.equals(..))) goto L_118;
        ShowEvent$Clicked.INSTANCE.equals("com.unity3d.services.ads.api.AdViewer.leftApplication");
        if (if-eqz(String.equals(..))) goto L_118;
        ShowEvent$LeftApplication.INSTANCE.equals("com.unity3d.services.ads.api.AdViewer.completed");
        if (if-eqz(String.equals(..))) goto L_118;
        L$1.getParameters();
        ArraysKt.first(Invocation.getParameters(..));
        if (if-eqz(new ShowEvent$Error(..))) goto L_cf;
      L_cf:
      L_d0:
        Intrinsics.areEqual(0, "COMPLETED");
        if (if-eqz(Intrinsics.areEqual(..))) goto L_db;
      L_db:
        Intrinsics.areEqual(ShowStatus.COMPLETED, "SKIPPED");
        if (if-eqz(Intrinsics.areEqual(..))) goto L_e6;
      L_e6:
      L_e8:
        new ShowEvent$Completed(ShowStatus.ERROR);
        new ShowEvent$Completed(..).equals("com.unity3d.services.ads.api.AdViewer.cancelShowTimeout");
        if (if-eqz(String.equals(..))) goto L_118;
      L_fa:
        L$0 = $this_unsafeFlow;
        L$1 = ShowEvent$CancelTimeout.INSTANCE;
        label = 1;
        Invocation.handle$default(L$1, 0, new WebViewAdPlayer$special$$inlined$map$1$2$1(..), 1, 0);
        if (if-ne(Invocation.handle$default(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_107;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_107:
      L_108:
        L$0 = 0;
        L$1 = 0;
        label = 2;
        $this_unsafeFlow.emit(ShowEvent$CancelTimeout.INSTANCE, new WebViewAdPlayer$special$$inlined$map$1$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_115;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_115:
        return Unit.INSTANCE;
      L_118:
        new StringBuilder("Unexpected location: ");
        Unit.INSTANCE.getLocation();
        new StringBuilder(..).append(Invocation.getLocation(..));
        new StringBuilder(..).toString();
        new IllegalStateException(StringBuilder.toString(..));
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1$2$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$1$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final WebViewAdPlayer$special$$inlined$map$1$2 this$0;

    public WebViewAdPlayer$special$$inlined$map$1$2$1(WebViewAdPlayer$special$$inlined$map$1$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return WebViewAdPlayer$special$$inlined$map$1$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$2 {
    final Flow $this_unsafeTransform$inlined;

    public WebViewAdPlayer$special$$inlined$map$2(Flow p0) {
        $this_unsafeTransform$inlined = p0;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new WebViewAdPlayer$special$$inlined$map$2$2(p0);
        $this_unsafeTransform$inlined.collect(new WebViewAdPlayer$special$$inlined$map$2$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14;
        return Flow.collect(..);
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$2$2 {
    final FlowCollector $this_unsafeFlow;

    public WebViewAdPlayer$special$$inlined$map$2$2(FlowCollector p0) {
        $this_unsafeFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new WebViewAdPlayer$special$$inlined$map$2$2$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_42;
        if (if-eq(label, 1)) goto L_36;
        if (if-ne(label, 2)) goto L_2e;
        ResultKt.throwOnFailure(result);
      L_2e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_36:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_42:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        L$0 = $this_unsafeFlow;
        L$1 = L$1;
        label = 1;
        Invocation.handle$default(L$1, 0, new WebViewAdPlayer$special$$inlined$map$2$2$1(..), 1, 0);
        if (if-ne(Invocation.handle$default(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_59;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_59:
        L$1.getLocation();
        Intrinsics.areEqual(Invocation.getLocation(..), "com.unity3d.services.ads.api.AdViewer.loadError");
        if (if-eqz(Intrinsics.areEqual(..))) goto L_8d;
        L$1.getParameters();
        ArraysKt.first(Invocation.getParameters(..));
        Intrinsics.checkNotNull(ArraysKt.first(..), "null cannot be cast to non-null type org.json.JSONObject");
        ArraysKt.first(..).optInt("code");
        ArraysKt.first(..).optString("message");
        new LoadEvent$Error(JSONObject.optString(..), JSONObject.optInt(..));
      L_8d:
      L_92:
        L$0 = 0;
        L$1 = 0;
        label = 2;
        $this_unsafeFlow.emit(LoadEvent$Completed.INSTANCE, new WebViewAdPlayer$special$$inlined$map$2$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_9f;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_9f:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$2$2$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$2$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final WebViewAdPlayer$special$$inlined$map$2$2 this$0;

    public WebViewAdPlayer$special$$inlined$map$2$2$1(WebViewAdPlayer$special$$inlined$map$2$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return WebViewAdPlayer$special$$inlined$map$2$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$3 {
    final Flow $this_unsafeTransform$inlined;

    public WebViewAdPlayer$special$$inlined$map$3(Flow p0) {
        $this_unsafeTransform$inlined = p0;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new WebViewAdPlayer$special$$inlined$map$3$2(p0);
        $this_unsafeTransform$inlined.collect(new WebViewAdPlayer$special$$inlined$map$3$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14;
        return Flow.collect(..);
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$3$2 {
    final FlowCollector $this_unsafeFlow;

    public WebViewAdPlayer$special$$inlined$map$3$2(FlowCollector p0) {
        $this_unsafeFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new WebViewAdPlayer$special$$inlined$map$3$2$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_42;
        if (if-eq(label, 1)) goto L_36;
        if (if-ne(label, 2)) goto L_2e;
        ResultKt.throwOnFailure(result);
      L_2e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_36:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_42:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        L$0 = $this_unsafeFlow;
        L$1 = L$1;
        label = 1;
        Invocation.handle$default(L$1, 0, new WebViewAdPlayer$special$$inlined$map$3$2$1(..), 1, 0);
        if (if-ne(Invocation.handle$default(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_59;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_59:
        L$1.getParameters();
        ArraysKt.first(Invocation.getParameters(..));
        Intrinsics.checkNotNull(ArraysKt.first(..), "null cannot be cast to non-null type org.json.JSONObject");
        ArraysKt.first(..).optString("data");
        JSONObject.optString(..).getBytes(Charsets.ISO_8859_1);
        ArraysKt.first(..).optInt("dataVersion");
        Boxing.boxInt(JSONObject.optInt(..));
        TuplesKt.to(String.getBytes(..), Boxing.boxInt(..));
        L$0 = 0;
        L$1 = 0;
        label = 2;
        $this_unsafeFlow.emit(TuplesKt.to(..), new WebViewAdPlayer$special$$inlined$map$3$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_97;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_97:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$3$2$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$3$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final WebViewAdPlayer$special$$inlined$map$3$2 this$0;

    public WebViewAdPlayer$special$$inlined$map$3$2$1(WebViewAdPlayer$special$$inlined$map$3$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return WebViewAdPlayer$special$$inlined$map$3$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$4 {
    final Flow $this_unsafeTransform$inlined;

    public WebViewAdPlayer$special$$inlined$map$4(Flow p0) {
        $this_unsafeTransform$inlined = p0;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new WebViewAdPlayer$special$$inlined$map$4$2(p0);
        $this_unsafeTransform$inlined.collect(new WebViewAdPlayer$special$$inlined$map$4$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14;
        return Flow.collect(..);
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$4$2 {
    final FlowCollector $this_unsafeFlow;

    public WebViewAdPlayer$special$$inlined$map$4$2(FlowCollector p0) {
        $this_unsafeFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new WebViewAdPlayer$special$$inlined$map$4$2$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_42;
        if (if-eq(label, 1)) goto L_36;
        if (if-ne(label, 2)) goto L_2e;
        ResultKt.throwOnFailure(result);
      L_2e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_36:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_42:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        L$0 = $this_unsafeFlow;
        L$1 = L$1;
        label = 1;
        Invocation.handle$default(L$1, 0, new WebViewAdPlayer$special$$inlined$map$4$2$1(..), 1, 0);
        if (if-ne(Invocation.handle$default(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_59;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_59:
        L$1.getParameters();
        ArraysKt.first(Invocation.getParameters(..));
        ArraysKt.first(..).toString();
        L$0 = 0;
        L$1 = 0;
        label = 2;
        $this_unsafeFlow.emit(Object.toString(..), new WebViewAdPlayer$special$$inlined$map$4$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_72;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_72:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$4$2$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$4$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final WebViewAdPlayer$special$$inlined$map$4$2 this$0;

    public WebViewAdPlayer$special$$inlined$map$4$2$1(WebViewAdPlayer$special$$inlined$map$4$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return WebViewAdPlayer$special$$inlined$map$4$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$5 {
    final Flow $this_unsafeTransform$inlined;
    final WebViewAdPlayer this$0;

    public WebViewAdPlayer$special$$inlined$map$5(Flow p0, WebViewAdPlayer p1) {
        $this_unsafeTransform$inlined = p0;
        this$0 = p1;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new WebViewAdPlayer$special$$inlined$map$5$2(p0, this$0);
        $this_unsafeTransform$inlined.collect(new WebViewAdPlayer$special$$inlined$map$5$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_16;
        return Flow.collect(..);
      L_16:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5$2
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$5$2 {
    final FlowCollector $this_unsafeFlow;
    final WebViewAdPlayer this$0;

    public WebViewAdPlayer$special$$inlined$map$5$2(FlowCollector p0, WebViewAdPlayer p1) {
        $this_unsafeFlow = p0;
        this$0 = p1;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v2)) goto L_18;
        if (if-eqz(label)) goto L_18;
        label = label;
      L_18:
        new WebViewAdPlayer$special$$inlined$map$5$2$1(this, label);
      L_1d:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_8d;
        if (if-eq(label, 1)) goto L_7c;
        if (if-eq(label, 2)) goto L_64;
        if (if-eq(label, 3)) goto L_4f;
        if (if-eq(label, 4)) goto L_45;
        if (if-ne(label, 5)) goto L_3d;
        ResultKt.throwOnFailure(result);
      L_3d:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_45:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_4f:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_64:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_7c:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_8d:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        L$0 = this;
        L$1 = $this_unsafeFlow;
        L$2 = p0;
        label = 1;
        Invocation.handle$default(p0, 0, "call to 'resume' before 'invoke' with coroutine", 1, 0);
        if (if-ne(Invocation.handle$default(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_a8;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_a8:
      L_a9:
        p0.getParameters();
        ArraysKt.first(Invocation.getParameters(..));
        Intrinsics.checkNotNull(ArraysKt.first(..), "null cannot be cast to non-null type kotlin.String");
        p0.getParameters();
        ArraysKt.getOrNull(Invocation.getParameters(..), 1);
        p0.getLocation();
        Invocation.getLocation(..).hashCode();
        if (if-eq(String.hashCode(..), -934922905)) goto L_f1;
        if (if-eq(String.hashCode(..), -934674393)) goto L_e6;
        if (if-ne(String.hashCode(..), -445801745)) goto L_1cb;
        Invocation.getLocation(..).equals("com.unity3d.services.core.api.Request.get");
        if (if-eqz(String.equals(..))) goto L_1cb;
      L_e6:
        RequestType.GET.equals("com.unity3d.services.core.api.Request.post");
        if (if-eqz(String.equals(..))) goto L_1cb;
      L_f1:
        RequestType.POST.equals("com.unity3d.services.core.api.Request.head");
        if (if-eqz(String.equals(..))) goto L_1cb;
      L_fb:
        WebViewAdPlayer.access$getExecuteAdViewerRequest$p(this$0);
        p0.getParameters();
        L$0 = this;
        L$1 = $this_unsafeFlow;
        L$2 = ArraysKt.getOrNull(..);
        L$3 = ArraysKt.first(..);
        label = 2;
        ExecuteAdViewerRequest.invoke(RequestType.HEAD, Invocation.getParameters(..), "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(ExecuteAdViewerRequest.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_116;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_116:
      L_119:
        ExecuteAdViewerRequest.invoke(..).getBody();
        if (if-eqz(String.hashCode(..))) goto L_126;
      L_126:
        if (if-eqz(String.hashCode(..))) goto L_135;
        new String(HttpResponse.getBody(..), Charsets.UTF_8);
      L_135:
      L_136:
        ExecuteAdViewerRequest.invoke(..).getUrlString();
        ExecuteAdViewerRequest.invoke(..).getStatusCode();
        Boxing.boxInt(HttpResponse.getStatusCode(..));
        ExecuteAdViewerRequest.invoke(..).getHeaders();
        HttpResponseHeaderToJSONArrayKt.toResponseHeadersMap(HttpResponse.getHeaders(..));
        CollectionsKt.listOf(new String(..));
        WebViewAdPlayer.access$getBridge$p(this$0);
        new OnWebRequestComplete(CollectionsKt.listOf(..));
        L$0 = this;
        L$1 = $this_unsafeFlow;
        L$2 = ArraysKt.getOrNull(..);
        L$3 = ArraysKt.first(..);
        label = 3;
        WebViewBridge.sendEvent(new OnWebRequestComplete(..), "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(WebViewBridge.sendEvent(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_179;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_179:
      L_17f:
        WebViewBridge.sendEvent(..).getMessage();
        if (if-nez(Exception.getMessage(..))) goto L_18d;
      L_18d:
        CollectionsKt.listOf(0);
        WebViewAdPlayer.access$getBridge$p(this$0);
        new OnWebRequestFailed(CollectionsKt.listOf(..));
        L$0 = ArraysKt.getOrNull(..);
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        label = 4;
        WebViewBridge.sendEvent(new OnWebRequestFailed(..), "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(WebViewBridge.sendEvent(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1b3;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_1b3:
      L_1b4:
      L_1b5:
        L$0 = 0;
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        label = 5;
        ArraysKt.getOrNull(..).emit(Unit.INSTANCE, "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1c8;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_1c8:
        return Unit.INSTANCE;
      L_1cb:
        new StringBuilder("Unexpected location: ");
        ArraysKt.getOrNull(..).getLocation();
        new StringBuilder(..).append(Invocation.getLocation(..));
        new StringBuilder(..).toString();
        new IllegalStateException(StringBuilder.toString(..));
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5$2$1
// ============================================================
package com.unity3d.ads.adplayer;

public final class WebViewAdPlayer$special$$inlined$map$5$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    Object result;
    final WebViewAdPlayer$special$$inlined$map$5$2 this$0;

    public WebViewAdPlayer$special$$inlined$map$5$2$1(WebViewAdPlayer$special$$inlined$map$5$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return WebViewAdPlayer$special$$inlined$map$5$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$storageEventCallback$1
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$storageEventCallback$1 extends Lambda {
    final WebViewAdPlayer this$0;

    WebViewAdPlayer$storageEventCallback$1(WebViewAdPlayer p0) {
        this$0 = p0;
        new Lambda(1);
        return;
    }

    public Object invoke(Object p0) {
        WebViewAdPlayer$storageEventCallback$1.invoke(p0);
        return Unit.INSTANCE;
    }

    public final void invoke(StorageEventInfo p0) {
        this$0.getScope();
        new WebViewAdPlayer$storageEventCallback$1$1(this$0, p0, 0);
        BuildersKt.launch$default(WebViewAdPlayer.getScope(..), 0, 0, new WebViewAdPlayer$storageEventCallback$1$1(..), 3, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.WebViewAdPlayer$storageEventCallback$1$1
// ============================================================
package com.unity3d.ads.adplayer;

final class WebViewAdPlayer$storageEventCallback$1$1 extends SuspendLambda {
    final StorageEventInfo $it;
    int label;
    final WebViewAdPlayer this$0;

    WebViewAdPlayer$storageEventCallback$1$1(WebViewAdPlayer p0, StorageEventInfo p1, Continuation p2) {
        this$0 = p0;
        $it = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new WebViewAdPlayer$storageEventCallback$1$1(this$0, $it, p1);
        return new WebViewAdPlayer$storageEventCallback$1$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        WebViewAdPlayer$storageEventCallback$1$1.invoke(p0, p1);
        return WebViewAdPlayer$storageEventCallback$1$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        WebViewAdPlayer$storageEventCallback$1$1.create(p0, p1);
        WebViewAdPlayer$storageEventCallback$1$1.invokeSuspend(Unit.INSTANCE);
        return WebViewAdPlayer$storageEventCallback$1$1.invokeSuspend(..);
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
        WebViewAdPlayer.access$getBridge$p(this$0);
        $it.getEventType();
        $it.getStorageType();
        $it.getValue();
        new OnStorageEvent(StorageEventInfo.getEventType(..), StorageEventInfo.getStorageType(..), StorageEventInfo.getValue(..));
        label = 1;
        WebViewBridge.sendEvent(new OnStorageEvent(..), this);
        if (if-ne(WebViewBridge.sendEvent(..), "call to 'resume' before 'invoke' with coroutine")) goto L_45;
        return "call to 'resume' before 'invoke' with coroutine";
      L_45:
        return Unit.INSTANCE;
    }

}

