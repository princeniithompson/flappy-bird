
// ===== FILE: com/unity3d/services/ads/gmascar/handlers/BiddingSignalsHandler.java =====
package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.signals.ISignalCollectionListener;
import com.unity3d.scar.adapter.common.signals.SignalsCollectorBase;
import com.unity3d.services.ads.gmascar.listeners.IBiddingSignalsListener;
import com.unity3d.services.ads.gmascar.models.BiddingSignals;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BiddingSignalsHandler implements ISignalCollectionListener {
    private final boolean isBannerEnabled;
    private final IBiddingSignalsListener listener;

    public BiddingSignalsHandler(boolean z, IBiddingSignalsListener iBiddingSignalsListener) {
        this.listener = iBiddingSignalsListener;
        this.isBannerEnabled = z;
    }

    @Override // com.unity3d.scar.adapter.common.signals.ISignalCollectionListener
    public void onSignalsCollected(String str) {
        this.listener.onSignalsReady(getSignals(str));
    }

    @Override // com.unity3d.scar.adapter.common.signals.ISignalCollectionListener
    public void onSignalsCollectionFailed(String str) {
        this.listener.onSignalsFailure(str);
    }

    private BiddingSignals getSignals(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (this.isBannerEnabled) {
                return new BiddingSignals(getSignalFromJson(jSONObject, SignalsCollectorBase.SCAR_RV_SIGNAL), getSignalFromJson(jSONObject, SignalsCollectorBase.SCAR_INT_SIGNAL), getSignalFromJson(jSONObject, SignalsCollectorBase.SCAR_BAN_SIGNAL));
            }
            return new BiddingSignals(getSignalFromJson(jSONObject, SignalsCollectorBase.SCAR_RV_SIGNAL), getSignalFromJson(jSONObject, SignalsCollectorBase.SCAR_INT_SIGNAL));
        } catch (JSONException unused) {
            return null;
        }
    }

    private String getSignalFromJson(JSONObject jSONObject, String str) {
        return jSONObject.optString(str);
    }
}

// ===== FILE: com/unity3d/services/ads/gmascar/handlers/ScarAdHandlerBase.java =====
package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.IScarAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;
import com.unity3d.services.core.misc.IEventListener;

/* loaded from: classes.dex */
public abstract class ScarAdHandlerBase implements IScarAdListenerWrapper {
    protected final EventSubject<GMAEvent> _eventSubject;
    protected final GMAEventSender _gmaEventSender;
    protected final ScarAdMetadata _scarAdMetadata;

    public ScarAdHandlerBase(ScarAdMetadata scarAdMetadata, EventSubject<GMAEvent> eventSubject, GMAEventSender gMAEventSender) {
        this._scarAdMetadata = scarAdMetadata;
        this._eventSubject = eventSubject;
        this._gmaEventSender = gMAEventSender;
    }

    @Override // com.unity3d.scar.adapter.common.IScarAdListenerWrapper
    public void onAdLoaded() {
        this._gmaEventSender.send(GMAEvent.AD_LOADED, this._scarAdMetadata.getPlacementId(), this._scarAdMetadata.getQueryId());
    }

    @Override // com.unity3d.scar.adapter.common.IScarAdListenerWrapper
    public void onAdFailedToLoad(int i, String str) {
        this._gmaEventSender.send(GMAEvent.LOAD_ERROR, this._scarAdMetadata.getPlacementId(), this._scarAdMetadata.getQueryId(), str, Integer.valueOf(i));
    }

    @Override // com.unity3d.scar.adapter.common.IScarAdListenerWrapper
    public void onAdOpened() {
        this._gmaEventSender.send(GMAEvent.AD_STARTED, new Object[0]);
        this._eventSubject.subscribe(new IEventListener<GMAEvent>() { // from class: com.unity3d.services.ads.gmascar.handlers.ScarAdHandlerBase.1
            @Override // com.unity3d.services.core.misc.IEventListener
            public void onNextEvent(GMAEvent gMAEvent) {
                ScarAdHandlerBase.this._gmaEventSender.send(gMAEvent, new Object[0]);
            }
        });
    }

    @Override // com.unity3d.scar.adapter.common.IScarAdListenerWrapper
    public void onAdClicked() {
        this._gmaEventSender.send(GMAEvent.AD_CLICKED, new Object[0]);
    }

    @Override // com.unity3d.scar.adapter.common.IScarAdListenerWrapper
    public void onAdClosed() {
        this._gmaEventSender.send(GMAEvent.AD_CLOSED, new Object[0]);
        this._eventSubject.unsubscribe();
    }
}

// ===== FILE: com/unity3d/services/ads/gmascar/handlers/ScarBannerAdHandler.java =====
package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.IScarBannerAdListenerWrapper;
import com.unity3d.services.banners.BannerViewCache;
import com.unity3d.services.banners.bridge.BannerBridge;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;

/* loaded from: classes.dex */
public class ScarBannerAdHandler implements IScarBannerAdListenerWrapper {
    private String _operationId;

    public ScarBannerAdHandler(String str) {
        this._operationId = str;
    }

    @Override // com.unity3d.scar.adapter.common.IScarAdListenerWrapper
    public void onAdLoaded() {
        BannerViewCache.getInstance().addScarContainer(this._operationId);
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerBridge.BannerEvent.SCAR_BANNER_LOADED, this._operationId);
    }

    @Override // com.unity3d.scar.adapter.common.IScarAdListenerWrapper
    public void onAdFailedToLoad(int i, String str) {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerBridge.BannerEvent.SCAR_BANNER_LOAD_FAILED, this._operationId, Integer.valueOf(i), str);
    }

    @Override // com.unity3d.scar.adapter.common.IScarAdListenerWrapper
    public void onAdOpened() {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerBridge.BannerEvent.SCAR_BANNER_OPENED, this._operationId);
    }

    @Override // com.unity3d.scar.adapter.common.IScarAdListenerWrapper
    public void onAdClicked() {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerBridge.BannerEvent.SCAR_BANNER_CLICKED, this._operationId);
    }

    @Override // com.unity3d.scar.adapter.common.IScarAdListenerWrapper
    public void onAdClosed() {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerBridge.BannerEvent.SCAR_BANNER_CLOSED, this._operationId);
    }

    @Override // com.unity3d.scar.adapter.common.IScarBannerAdListenerWrapper
    public void onAdImpression() {
        WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.BANNER, BannerBridge.BannerEvent.SCAR_BANNER_IMPRESSION, this._operationId);
    }
}

// ===== FILE: com/unity3d/services/ads/gmascar/handlers/ScarInterstitialAdHandler.java =====
package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;

/* loaded from: classes.dex */
public class ScarInterstitialAdHandler extends ScarAdHandlerBase implements IScarInterstitialAdListenerWrapper {
    public ScarInterstitialAdHandler(ScarAdMetadata scarAdMetadata, EventSubject<GMAEvent> eventSubject, GMAEventSender gMAEventSender) {
        super(scarAdMetadata, eventSubject, gMAEventSender);
    }

    @Override // com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper
    public void onAdFailedToShow(int i, String str) {
        this._gmaEventSender.send(GMAEvent.INTERSTITIAL_SHOW_ERROR, this._scarAdMetadata.getPlacementId(), this._scarAdMetadata.getQueryId(), str, Integer.valueOf(i));
    }

    @Override // com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper
    public void onAdSkipped() {
        this._gmaEventSender.send(GMAEvent.AD_SKIPPED, new Object[0]);
    }

    @Override // com.unity3d.services.ads.gmascar.handlers.ScarAdHandlerBase, com.unity3d.scar.adapter.common.IScarAdListenerWrapper
    public void onAdClosed() {
        if (!this._eventSubject.eventQueueIsEmpty()) {
            onAdSkipped();
        }
        super.onAdClosed();
    }

    @Override // com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper
    public void onAdLeftApplication() {
        this._gmaEventSender.send(GMAEvent.AD_LEFT_APPLICATION, new Object[0]);
    }

    @Override // com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper
    public void onAdImpression() {
        this._gmaEventSender.send(GMAEvent.INTERSTITIAL_IMPRESSION_RECORDED, new Object[0]);
    }
}

// ===== FILE: com/unity3d/services/ads/gmascar/handlers/ScarRewardedAdHandler.java =====
package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;

/* loaded from: classes.dex */
public class ScarRewardedAdHandler extends ScarAdHandlerBase implements IScarRewardedAdListenerWrapper {
    private boolean _hasEarnedReward;

    public ScarRewardedAdHandler(ScarAdMetadata scarAdMetadata, EventSubject<GMAEvent> eventSubject, GMAEventSender gMAEventSender) {
        super(scarAdMetadata, eventSubject, gMAEventSender);
        this._hasEarnedReward = false;
    }

    @Override // com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper
    public void onAdFailedToShow(int i, String str) {
        this._gmaEventSender.send(GMAEvent.REWARDED_SHOW_ERROR, this._scarAdMetadata.getPlacementId(), this._scarAdMetadata.getQueryId(), str, Integer.valueOf(i));
    }

    @Override // com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper
    public void onUserEarnedReward() {
        this._hasEarnedReward = true;
        this._gmaEventSender.send(GMAEvent.AD_EARNED_REWARD, new Object[0]);
    }

    @Override // com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper
    public void onAdSkipped() {
        this._gmaEventSender.send(GMAEvent.AD_SKIPPED, new Object[0]);
    }

    @Override // com.unity3d.services.ads.gmascar.handlers.ScarAdHandlerBase, com.unity3d.scar.adapter.common.IScarAdListenerWrapper
    public void onAdClosed() {
        if (!this._hasEarnedReward) {
            onAdSkipped();
        }
        super.onAdClosed();
    }

    @Override // com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper
    public void onAdImpression() {
        this._gmaEventSender.send(GMAEvent.REWARDED_IMPRESSION_RECORDED, new Object[0]);
    }
}

// ===== FILE: com/unity3d/services/ads/gmascar/handlers/SignalsHandler.java =====
package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.signals.ISignalCollectionListener;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;

/* loaded from: classes.dex */
public class SignalsHandler implements ISignalCollectionListener {
    private GMAEventSender _gmaEventSender;

    public SignalsHandler(GMAEventSender gMAEventSender) {
        this._gmaEventSender = gMAEventSender;
    }

    @Override // com.unity3d.scar.adapter.common.signals.ISignalCollectionListener
    public void onSignalsCollected(String str) {
        this._gmaEventSender.send(GMAEvent.SIGNALS, str);
    }

    @Override // com.unity3d.scar.adapter.common.signals.ISignalCollectionListener
    public void onSignalsCollectionFailed(String str) {
        this._gmaEventSender.send(GMAEvent.SIGNALS_ERROR, str);
    }
}

// ===== FILE: com/unity3d/services/ads/gmascar/handlers/WebViewErrorHandler.java =====
package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.WebViewAdsError;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;

/* loaded from: classes.dex */
public class WebViewErrorHandler implements IAdsErrorHandler<WebViewAdsError> {
    private final IEventSender _eventSender;

    public WebViewErrorHandler() {
        this(SharedInstances.INSTANCE.getWebViewEventSender());
    }

    public WebViewErrorHandler(IEventSender iEventSender) {
        this._eventSender = iEventSender;
    }

    @Override // com.unity3d.scar.adapter.common.IAdsErrorHandler
    public void handleError(WebViewAdsError webViewAdsError) {
        this._eventSender.sendEvent(WebViewEventCategory.valueOf(webViewAdsError.getDomain()), webViewAdsError.getErrorCategory(), webViewAdsError.getErrorArguments());
    }
}
