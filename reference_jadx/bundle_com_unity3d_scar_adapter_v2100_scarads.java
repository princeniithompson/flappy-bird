
// ===== FILE: com/unity3d/scar/adapter/v2100/scarads/ScarAdBase.java =====
package com.unity3d.scar.adapter.v2100.scarads;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.scarads.IScarAd;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.v2100.requests.AdRequestFactory;

/* loaded from: classes.dex */
public abstract class ScarAdBase<T> implements IScarAd {
    protected T _adObj;
    protected AdRequestFactory _adRequestFactory;
    protected IAdsErrorHandler _adsErrorHandler;
    protected Context _context;
    protected ScarAdListener _scarAdListener;
    protected ScarAdMetadata _scarAdMetadata;

    protected abstract void loadAdInternal(AdRequest adRequest, IScarLoadListener iScarLoadListener);

    public ScarAdBase(Context context, ScarAdMetadata scarAdMetadata, AdRequestFactory adRequestFactory, IAdsErrorHandler iAdsErrorHandler) {
        this._context = context;
        this._scarAdMetadata = scarAdMetadata;
        this._adRequestFactory = adRequestFactory;
        this._adsErrorHandler = iAdsErrorHandler;
    }

    public void setGmaAd(T t) {
        this._adObj = t;
    }

    @Override // com.unity3d.scar.adapter.common.scarads.IScarAd
    public void loadAd(IScarLoadListener iScarLoadListener) {
        AdRequest buildAdRequestWithAdString = this._adRequestFactory.buildAdRequestWithAdString(this._scarAdMetadata.getAdString());
        if (iScarLoadListener != null) {
            this._scarAdListener.setLoadListener(iScarLoadListener);
        }
        loadAdInternal(buildAdRequestWithAdString, iScarLoadListener);
    }
}

// ===== FILE: com/unity3d/scar/adapter/v2100/scarads/ScarAdListener.java =====
package com.unity3d.scar.adapter.v2100.scarads;

import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;

/* loaded from: classes.dex */
public class ScarAdListener {
    protected IScarLoadListener _loadListener;

    public void setLoadListener(IScarLoadListener iScarLoadListener) {
        this._loadListener = iScarLoadListener;
    }
}

// ===== FILE: com/unity3d/scar/adapter/v2100/scarads/ScarBannerAd.java =====
package com.unity3d.scar.adapter.v2100.scarads;

import android.content.Context;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarBannerAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.v2100.requests.AdRequestFactory;

/* loaded from: classes.dex */
public class ScarBannerAd extends ScarAdBase<AdView> {
    private AdView _adView;
    private RelativeLayout _bannerView;
    private int _height;
    private int _width;

    public ScarBannerAd(Context context, RelativeLayout relativeLayout, AdRequestFactory adRequestFactory, ScarAdMetadata scarAdMetadata, int i, int i2, IAdsErrorHandler iAdsErrorHandler, IScarBannerAdListenerWrapper iScarBannerAdListenerWrapper) {
        super(context, scarAdMetadata, adRequestFactory, iAdsErrorHandler);
        this._bannerView = relativeLayout;
        this._width = i;
        this._height = i2;
        this._adView = new AdView(this._context);
        this._scarAdListener = new ScarBannerAdListener(iScarBannerAdListenerWrapper, this);
    }

    public void removeAdView() {
        AdView adView;
        RelativeLayout relativeLayout = this._bannerView;
        if (relativeLayout == null || (adView = this._adView) == null) {
            return;
        }
        relativeLayout.removeView(adView);
    }

    @Override // com.unity3d.scar.adapter.v2100.scarads.ScarAdBase
    protected void loadAdInternal(AdRequest adRequest, IScarLoadListener iScarLoadListener) {
        AdView adView;
        RelativeLayout relativeLayout = this._bannerView;
        if (relativeLayout == null || (adView = this._adView) == null) {
            return;
        }
        relativeLayout.addView(adView);
        this._adView.setAdSize(new AdSize(this._width, this._height));
        this._adView.setAdUnitId(this._scarAdMetadata.getAdUnitId());
        this._adView.setAdListener(((ScarBannerAdListener) this._scarAdListener).getAdListener());
        this._adView.loadAd(adRequest);
    }
}

// ===== FILE: com/unity3d/scar/adapter/v2100/scarads/ScarBannerAdListener.java =====
package com.unity3d.scar.adapter.v2100.scarads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.unity3d.scar.adapter.common.IScarBannerAdListenerWrapper;

/* loaded from: classes.dex */
public class ScarBannerAdListener extends ScarAdListener {
    private final AdListener _adListener = new AdListener() { // from class: com.unity3d.scar.adapter.v2100.scarads.ScarBannerAdListener.1
        public void onAdClicked() {
            super.onAdClicked();
            ScarBannerAdListener.this._adListenerWrapper.onAdClicked();
        }

        public void onAdClosed() {
            super.onAdClosed();
            ScarBannerAdListener.this._adListenerWrapper.onAdClosed();
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            ScarBannerAdListener.this._scarBannerAd.removeAdView();
            ScarBannerAdListener.this._adListenerWrapper.onAdFailedToLoad(loadAdError.getCode(), loadAdError.getMessage());
        }

        public void onAdImpression() {
            super.onAdImpression();
            ScarBannerAdListener.this._adListenerWrapper.onAdImpression();
        }

        public void onAdLoaded() {
            super.onAdLoaded();
            ScarBannerAdListener.this._adListenerWrapper.onAdLoaded();
        }

        public void onAdOpened() {
            super.onAdOpened();
            ScarBannerAdListener.this._adListenerWrapper.onAdOpened();
        }
    };
    private final IScarBannerAdListenerWrapper _adListenerWrapper;
    private final ScarBannerAd _scarBannerAd;

    public ScarBannerAdListener(IScarBannerAdListenerWrapper iScarBannerAdListenerWrapper, ScarBannerAd scarBannerAd) {
        this._adListenerWrapper = iScarBannerAdListenerWrapper;
        this._scarBannerAd = scarBannerAd;
    }

    public AdListener getAdListener() {
        return this._adListener;
    }
}

// ===== FILE: com/unity3d/scar/adapter/v2100/scarads/ScarInterstitialAd.java =====
package com.unity3d.scar.adapter.v2100.scarads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarFullScreenAd;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.v2100.requests.AdRequestFactory;

/* loaded from: classes.dex */
public class ScarInterstitialAd extends ScarAdBase<InterstitialAd> implements IScarFullScreenAd {
    public ScarInterstitialAd(Context context, AdRequestFactory adRequestFactory, ScarAdMetadata scarAdMetadata, IAdsErrorHandler iAdsErrorHandler, IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper) {
        super(context, scarAdMetadata, adRequestFactory, iAdsErrorHandler);
        this._scarAdListener = new ScarInterstitialAdListener(iScarInterstitialAdListenerWrapper, this);
    }

    @Override // com.unity3d.scar.adapter.v2100.scarads.ScarAdBase
    protected void loadAdInternal(AdRequest adRequest, IScarLoadListener iScarLoadListener) {
        InterstitialAd.load(this._context, this._scarAdMetadata.getAdUnitId(), adRequest, ((ScarInterstitialAdListener) this._scarAdListener).getAdLoadListener());
    }

    @Override // com.unity3d.scar.adapter.common.scarads.IScarFullScreenAd
    public void show(Activity activity) {
        if (this._adObj != 0) {
            ((InterstitialAd) this._adObj).show(activity);
        } else {
            this._adsErrorHandler.handleError(GMAAdsError.AdNotLoadedError(this._scarAdMetadata));
        }
    }
}

// ===== FILE: com/unity3d/scar/adapter/v2100/scarads/ScarInterstitialAdListener.java =====
package com.unity3d.scar.adapter.v2100.scarads;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;

/* loaded from: classes.dex */
public class ScarInterstitialAdListener extends ScarAdListener {
    private final IScarInterstitialAdListenerWrapper _adListenerWrapper;
    private final InterstitialAdLoadCallback _adLoadCallback = new InterstitialAdLoadCallback() { // from class: com.unity3d.scar.adapter.v2100.scarads.ScarInterstitialAdListener.1
        public void onAdLoaded(InterstitialAd interstitialAd) {
            super.onAdLoaded(interstitialAd);
            ScarInterstitialAdListener.this._adListenerWrapper.onAdLoaded();
            interstitialAd.setFullScreenContentCallback(ScarInterstitialAdListener.this._fullScreenContentCallback);
            ScarInterstitialAdListener.this._scarInterstitialAd.setGmaAd(interstitialAd);
            if (ScarInterstitialAdListener.this._loadListener != null) {
                ScarInterstitialAdListener.this._loadListener.onAdLoaded();
            }
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            ScarInterstitialAdListener.this._adListenerWrapper.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
        }
    };
    private final FullScreenContentCallback _fullScreenContentCallback = new FullScreenContentCallback() { // from class: com.unity3d.scar.adapter.v2100.scarads.ScarInterstitialAdListener.2
        public void onAdFailedToShowFullScreenContent(AdError adError) {
            super.onAdFailedToShowFullScreenContent(adError);
            ScarInterstitialAdListener.this._adListenerWrapper.onAdFailedToShow(adError.getCode(), adError.toString());
        }

        public void onAdShowedFullScreenContent() {
            super.onAdShowedFullScreenContent();
            ScarInterstitialAdListener.this._adListenerWrapper.onAdOpened();
        }

        public void onAdDismissedFullScreenContent() {
            super.onAdDismissedFullScreenContent();
            ScarInterstitialAdListener.this._adListenerWrapper.onAdClosed();
        }

        public void onAdImpression() {
            super.onAdImpression();
            ScarInterstitialAdListener.this._adListenerWrapper.onAdImpression();
        }

        public void onAdClicked() {
            super.onAdClicked();
            ScarInterstitialAdListener.this._adListenerWrapper.onAdClicked();
        }
    };
    private final ScarInterstitialAd _scarInterstitialAd;

    public ScarInterstitialAdListener(IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper, ScarInterstitialAd scarInterstitialAd) {
        this._adListenerWrapper = iScarInterstitialAdListenerWrapper;
        this._scarInterstitialAd = scarInterstitialAd;
    }

    public InterstitialAdLoadCallback getAdLoadListener() {
        return this._adLoadCallback;
    }
}

// ===== FILE: com/unity3d/scar/adapter/v2100/scarads/ScarRewardedAd.java =====
package com.unity3d.scar.adapter.v2100.scarads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarFullScreenAd;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.v2100.requests.AdRequestFactory;

/* loaded from: classes.dex */
public class ScarRewardedAd extends ScarAdBase<RewardedAd> implements IScarFullScreenAd {
    public ScarRewardedAd(Context context, AdRequestFactory adRequestFactory, ScarAdMetadata scarAdMetadata, IAdsErrorHandler iAdsErrorHandler, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper) {
        super(context, scarAdMetadata, adRequestFactory, iAdsErrorHandler);
        this._scarAdListener = new ScarRewardedAdListener(iScarRewardedAdListenerWrapper, this);
    }

    @Override // com.unity3d.scar.adapter.v2100.scarads.ScarAdBase
    protected void loadAdInternal(AdRequest adRequest, IScarLoadListener iScarLoadListener) {
        RewardedAd.load(this._context, this._scarAdMetadata.getAdUnitId(), adRequest, ((ScarRewardedAdListener) this._scarAdListener).getAdLoadListener());
    }

    @Override // com.unity3d.scar.adapter.common.scarads.IScarFullScreenAd
    public void show(Activity activity) {
        if (this._adObj != 0) {
            ((RewardedAd) this._adObj).show(activity, ((ScarRewardedAdListener) this._scarAdListener).getOnUserEarnedRewardListener());
        } else {
            this._adsErrorHandler.handleError(GMAAdsError.AdNotLoadedError(this._scarAdMetadata));
        }
    }
}

// ===== FILE: com/unity3d/scar/adapter/v2100/scarads/ScarRewardedAdListener.java =====
package com.unity3d.scar.adapter.v2100.scarads;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;

/* loaded from: classes.dex */
public class ScarRewardedAdListener extends ScarAdListener {
    private final IScarRewardedAdListenerWrapper _adListenerWrapper;
    private final ScarRewardedAd _scarRewardedAd;
    private final RewardedAdLoadCallback _adLoadCallback = new RewardedAdLoadCallback() { // from class: com.unity3d.scar.adapter.v2100.scarads.ScarRewardedAdListener.1
        public void onAdLoaded(RewardedAd rewardedAd) {
            super.onAdLoaded(rewardedAd);
            ScarRewardedAdListener.this._adListenerWrapper.onAdLoaded();
            rewardedAd.setFullScreenContentCallback(ScarRewardedAdListener.this._fullScreenContentCallback);
            ScarRewardedAdListener.this._scarRewardedAd.setGmaAd(rewardedAd);
            if (ScarRewardedAdListener.this._loadListener != null) {
                ScarRewardedAdListener.this._loadListener.onAdLoaded();
            }
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            ScarRewardedAdListener.this._adListenerWrapper.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
        }
    };
    private final OnUserEarnedRewardListener _onUserEarnedRewardListener = new OnUserEarnedRewardListener() { // from class: com.unity3d.scar.adapter.v2100.scarads.ScarRewardedAdListener.2
        public void onUserEarnedReward(RewardItem rewardItem) {
            ScarRewardedAdListener.this._adListenerWrapper.onUserEarnedReward();
        }
    };
    private final FullScreenContentCallback _fullScreenContentCallback = new FullScreenContentCallback() { // from class: com.unity3d.scar.adapter.v2100.scarads.ScarRewardedAdListener.3
        public void onAdFailedToShowFullScreenContent(AdError adError) {
            super.onAdFailedToShowFullScreenContent(adError);
            ScarRewardedAdListener.this._adListenerWrapper.onAdFailedToShow(adError.getCode(), adError.toString());
        }

        public void onAdShowedFullScreenContent() {
            super.onAdShowedFullScreenContent();
            ScarRewardedAdListener.this._adListenerWrapper.onAdOpened();
        }

        public void onAdDismissedFullScreenContent() {
            super.onAdDismissedFullScreenContent();
            ScarRewardedAdListener.this._adListenerWrapper.onAdClosed();
        }

        public void onAdImpression() {
            super.onAdImpression();
            ScarRewardedAdListener.this._adListenerWrapper.onAdImpression();
        }

        public void onAdClicked() {
            super.onAdClicked();
            ScarRewardedAdListener.this._adListenerWrapper.onAdClicked();
        }
    };

    public ScarRewardedAdListener(IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper, ScarRewardedAd scarRewardedAd) {
        this._adListenerWrapper = iScarRewardedAdListenerWrapper;
        this._scarRewardedAd = scarRewardedAd;
    }

    public OnUserEarnedRewardListener getOnUserEarnedRewardListener() {
        return this._onUserEarnedRewardListener;
    }

    public RewardedAdLoadCallback getAdLoadListener() {
        return this._adLoadCallback;
    }
}
