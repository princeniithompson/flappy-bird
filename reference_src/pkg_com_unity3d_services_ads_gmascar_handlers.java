// Package bundle: com.unity3d.services.ads.gmascar.handlers (8 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.handlers.BiddingSignalsHandler
// ============================================================
package com.unity3d.services.ads.gmascar.handlers;

public class BiddingSignalsHandler {
    private final boolean isBannerEnabled;
    private final IBiddingSignalsListener listener;

    public BiddingSignalsHandler(boolean p0, IBiddingSignalsListener p1) {
        new Object();
        listener = p1;
        isBannerEnabled = p0;
        return;
    }

    private String getSignalFromJson(JSONObject p0, String p1) {
        p0.optString(p1);
        return JSONObject.optString(..);
    }

    private BiddingSignals getSignals(String p0) {
        new JSONObject(p0);
        if (if-eqz(isBannerEnabled)) goto L_21;
        BiddingSignalsHandler.getSignalFromJson(new JSONObject(..), "gmaScarBiddingRewardedSignal");
        BiddingSignalsHandler.getSignalFromJson(new JSONObject(..), "gmaScarBiddingInterstitialSignal");
        BiddingSignalsHandler.getSignalFromJson(new JSONObject(..), "gmaScarBiddingBannerSignal");
        new BiddingSignals(BiddingSignalsHandler.getSignalFromJson(..), BiddingSignalsHandler.getSignalFromJson(..), BiddingSignalsHandler.getSignalFromJson(..));
        return new BiddingSignals(..);
      L_21:
        BiddingSignalsHandler.getSignalFromJson(BiddingSignalsHandler.getSignalFromJson(..), BiddingSignalsHandler.getSignalFromJson(..));
        BiddingSignalsHandler.getSignalFromJson(BiddingSignalsHandler.getSignalFromJson(..), BiddingSignalsHandler.getSignalFromJson(..));
        new BiddingSignals(BiddingSignalsHandler.getSignalFromJson(..), BiddingSignalsHandler.getSignalFromJson(..));
        return new BiddingSignals(..);
        return 0;
    }

    public void onSignalsCollected(String p0) {
        BiddingSignalsHandler.getSignals(p0);
        listener.onSignalsReady(BiddingSignalsHandler.getSignals(..));
        return;
    }

    public void onSignalsCollectionFailed(String p0) {
        listener.onSignalsFailure(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.handlers.ScarAdHandlerBase
// ============================================================
package com.unity3d.services.ads.gmascar.handlers;

public abstract class ScarAdHandlerBase {
    protected final EventSubject _eventSubject;
    protected final GMAEventSender _gmaEventSender;
    protected final ScarAdMetadata _scarAdMetadata;

    public ScarAdHandlerBase(ScarAdMetadata p0, EventSubject p1, GMAEventSender p2) {
        new Object();
        _scarAdMetadata = p0;
        _eventSubject = p1;
        _gmaEventSender = p2;
        return;
    }

    public void onAdClicked() {
        _gmaEventSender.send(GMAEvent.AD_CLICKED, 0);
        return;
    }

    public void onAdClosed() {
        _gmaEventSender.send(GMAEvent.AD_CLOSED, 0);
        _eventSubject.unsubscribe();
        return;
    }

    public void onAdFailedToLoad(int p0, String p1) {
        _scarAdMetadata.getPlacementId();
        _scarAdMetadata.getQueryId();
        Integer.valueOf(p0);
        _gmaEventSender.send(GMAEvent.LOAD_ERROR, 4);
        return;
    }

    public void onAdLoaded() {
        _scarAdMetadata.getPlacementId();
        _scarAdMetadata.getQueryId();
        _gmaEventSender.send(GMAEvent.AD_LOADED, 2);
        return;
    }

    public void onAdOpened() {
        _gmaEventSender.send(GMAEvent.AD_STARTED, 0);
        new ScarAdHandlerBase$1(this);
        _eventSubject.subscribe(new ScarAdHandlerBase$1(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.handlers.ScarBannerAdHandler
// ============================================================
package com.unity3d.services.ads.gmascar.handlers;

public class ScarBannerAdHandler {
    private String _operationId;

    public ScarBannerAdHandler(String p0) {
        new Object();
        _operationId = p0;
        return;
    }

    public void onAdClicked() {
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.SCAR_BANNER_CLICKED, 1);
        return;
    }

    public void onAdClosed() {
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.SCAR_BANNER_CLOSED, 1);
        return;
    }

    public void onAdFailedToLoad(int p0, String p1) {
        WebViewApp.getCurrentApp();
        Integer.valueOf(p0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.SCAR_BANNER_LOAD_FAILED, 3);
        return;
    }

    public void onAdImpression() {
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.SCAR_BANNER_IMPRESSION, 1);
        return;
    }

    public void onAdLoaded() {
        BannerViewCache.getInstance();
        BannerViewCache.getInstance(..).addScarContainer(_operationId);
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.SCAR_BANNER_LOADED, 1);
        return;
    }

    public void onAdOpened() {
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.SCAR_BANNER_OPENED, 1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.handlers.ScarInterstitialAdHandler
// ============================================================
package com.unity3d.services.ads.gmascar.handlers;

public class ScarInterstitialAdHandler extends ScarAdHandlerBase {
    public ScarInterstitialAdHandler(ScarAdMetadata p0, EventSubject p1, GMAEventSender p2) {
        new ScarAdHandlerBase(p0, p1, p2);
        return;
    }

    public void onAdClosed() {
        _eventSubject.eventQueueIsEmpty();
        if (if-nez(EventSubject.eventQueueIsEmpty(..))) goto L_b;
        ScarInterstitialAdHandler.onAdSkipped();
      L_b:
        ScarAdHandlerBase.onAdClosed();
        return;
    }

    public void onAdFailedToShow(int p0, String p1) {
        _scarAdMetadata.getPlacementId();
        _scarAdMetadata.getQueryId();
        Integer.valueOf(p0);
        _gmaEventSender.send(GMAEvent.INTERSTITIAL_SHOW_ERROR, 4);
        return;
    }

    public void onAdImpression() {
        _gmaEventSender.send(GMAEvent.INTERSTITIAL_IMPRESSION_RECORDED, 0);
        return;
    }

    public void onAdLeftApplication() {
        _gmaEventSender.send(GMAEvent.AD_LEFT_APPLICATION, 0);
        return;
    }

    public void onAdSkipped() {
        _gmaEventSender.send(GMAEvent.AD_SKIPPED, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.handlers.ScarRewardedAdHandler
// ============================================================
package com.unity3d.services.ads.gmascar.handlers;

public class ScarRewardedAdHandler extends ScarAdHandlerBase {
    private boolean _hasEarnedReward;

    public ScarRewardedAdHandler(ScarAdMetadata p0, EventSubject p1, GMAEventSender p2) {
        new ScarAdHandlerBase(p0, p1, p2);
        _hasEarnedReward = 0;
        return;
    }

    public void onAdClosed() {
        if (if-nez(_hasEarnedReward)) goto L_7;
        ScarRewardedAdHandler.onAdSkipped();
      L_7:
        ScarAdHandlerBase.onAdClosed();
        return;
    }

    public void onAdFailedToShow(int p0, String p1) {
        _scarAdMetadata.getPlacementId();
        _scarAdMetadata.getQueryId();
        Integer.valueOf(p0);
        _gmaEventSender.send(GMAEvent.REWARDED_SHOW_ERROR, 4);
        return;
    }

    public void onAdImpression() {
        _gmaEventSender.send(GMAEvent.REWARDED_IMPRESSION_RECORDED, 0);
        return;
    }

    public void onAdSkipped() {
        _gmaEventSender.send(GMAEvent.AD_SKIPPED, 0);
        return;
    }

    public void onUserEarnedReward() {
        _hasEarnedReward = 1;
        _gmaEventSender.send(GMAEvent.AD_EARNED_REWARD, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.handlers.SignalsHandler
// ============================================================
package com.unity3d.services.ads.gmascar.handlers;

public class SignalsHandler {
    private GMAEventSender _gmaEventSender;

    public SignalsHandler(GMAEventSender p0) {
        new Object();
        _gmaEventSender = p0;
        return;
    }

    public void onSignalsCollected(String p0) {
        _gmaEventSender.send(GMAEvent.SIGNALS, 1);
        return;
    }

    public void onSignalsCollectionFailed(String p0) {
        _gmaEventSender.send(GMAEvent.SIGNALS_ERROR, 1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.handlers.WebViewErrorHandler
// ============================================================
package com.unity3d.services.ads.gmascar.handlers;

public class WebViewErrorHandler {
    private final IEventSender _eventSender;

    public WebViewErrorHandler() {
        SharedInstances.INSTANCE.getWebViewEventSender();
        new WebViewErrorHandler(SharedInstances.getWebViewEventSender(..));
        return;
    }

    public WebViewErrorHandler(IEventSender p0) {
        new Object();
        _eventSender = p0;
        return;
    }

    public void handleError(IUnityAdsError p0) {
        WebViewErrorHandler.handleError(p0);
        return;
    }

    public void handleError(WebViewAdsError p0) {
        p0.getDomain();
        WebViewEventCategory.valueOf(WebViewAdsError.getDomain(..));
        p0.getErrorCategory();
        p0.getErrorArguments();
        _eventSender.sendEvent(WebViewEventCategory.valueOf(..), WebViewAdsError.getErrorCategory(..), WebViewAdsError.getErrorArguments(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.handlers.ScarAdHandlerBase$1
// ============================================================
package com.unity3d.services.ads.gmascar.handlers;

class ScarAdHandlerBase$1 {
    final ScarAdHandlerBase this$0;

    ScarAdHandlerBase$1(ScarAdHandlerBase p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void onNextEvent(GMAEvent p0) {
        _gmaEventSender.send(p0, 0);
        return;
    }

    public void onNextEvent(Object p0) {
        ScarAdHandlerBase$1.onNextEvent(p0);
        return;
    }

}

