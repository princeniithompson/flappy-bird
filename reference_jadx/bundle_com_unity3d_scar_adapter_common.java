
// ===== FILE: com/unity3d/scar/adapter/common/C1004R.java =====
package com.unity3d.scar.adapter.common;

/* renamed from: com.unity3d.scar.adapter.common.R */
/* loaded from: classes.dex */
public final class C1004R {
    private C1004R() {
    }
}

// ===== FILE: com/unity3d/scar/adapter/common/DispatchGroup.java =====
package com.unity3d.scar.adapter.common;

/* loaded from: classes.dex */
public class DispatchGroup {
    private Runnable _runnable;
    private int _threadCount = 0;

    public synchronized void enter() {
        this._threadCount++;
    }

    public synchronized void leave() {
        this._threadCount--;
        notifyGroup();
    }

    public void notify(Runnable runnable) {
        this._runnable = runnable;
        notifyGroup();
    }

    private void notifyGroup() {
        Runnable runnable;
        if (this._threadCount > 0 || (runnable = this._runnable) == null) {
            return;
        }
        runnable.run();
    }
}

// ===== FILE: com/unity3d/scar/adapter/common/GMAAdsError.java =====
package com.unity3d.scar.adapter.common;

import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;

/* loaded from: classes.dex */
public class GMAAdsError extends WebViewAdsError {
    public static final String AD_NOT_LOADED_MESSAGE = "Cannot show ad that is not loaded for placement %s";
    public static final String MISSING_QUERYINFO_MESSAGE = "Missing queryInfoMetadata for ad %s";

    @Override // com.unity3d.scar.adapter.common.WebViewAdsError, com.unity3d.scar.adapter.common.IUnityAdsError
    public String getDomain() {
        return "GMA";
    }

    public GMAAdsError(GMAEvent gMAEvent, Object... objArr) {
        super(gMAEvent, null, objArr);
    }

    public GMAAdsError(GMAEvent gMAEvent, String str, Object... objArr) {
        super(gMAEvent, str, objArr);
    }

    public static GMAAdsError AdapterCreationError(String str) {
        return new GMAAdsError(GMAEvent.SCAR_UNSUPPORTED, str, new Object[0]);
    }

    public static GMAAdsError NoAdsError(String str, String str2, String str3) {
        return new GMAAdsError(GMAEvent.NO_AD_ERROR, str3, str, str2, str3);
    }

    public static GMAAdsError AdNotLoadedError(ScarAdMetadata scarAdMetadata) {
        String format = String.format(AD_NOT_LOADED_MESSAGE, scarAdMetadata.getPlacementId());
        return new GMAAdsError(GMAEvent.AD_NOT_LOADED_ERROR, format, scarAdMetadata.getPlacementId(), scarAdMetadata.getQueryId(), format);
    }

    public static GMAAdsError InternalShowError(ScarAdMetadata scarAdMetadata, String str) {
        return new GMAAdsError(GMAEvent.INTERNAL_SHOW_ERROR, str, scarAdMetadata.getPlacementId(), scarAdMetadata.getQueryId(), str);
    }

    public static GMAAdsError QueryNotFoundError(ScarAdMetadata scarAdMetadata) {
        String format = String.format(MISSING_QUERYINFO_MESSAGE, scarAdMetadata.getPlacementId());
        return new GMAAdsError(GMAEvent.QUERY_NOT_FOUND_ERROR, format, scarAdMetadata.getPlacementId(), scarAdMetadata.getQueryId(), format);
    }

    public static GMAAdsError InternalLoadError(ScarAdMetadata scarAdMetadata, String str) {
        return new GMAAdsError(GMAEvent.INTERNAL_LOAD_ERROR, str, scarAdMetadata.getPlacementId(), scarAdMetadata.getQueryId(), str);
    }

    public static GMAAdsError InternalSignalsError(String str) {
        return new GMAAdsError(GMAEvent.INTERNAL_SIGNALS_ERROR, str, str);
    }
}

// ===== FILE: com/unity3d/scar/adapter/common/GMAEvent.java =====
package com.unity3d.scar.adapter.common;

/* loaded from: classes.dex */
public enum GMAEvent {
    SCAR_PRESENT,
    SCAR_NOT_PRESENT,
    ALREADY_INITIALIZED,
    INIT_SUCCESS,
    INIT_ERROR,
    VERSION,
    SCAR_UNSUPPORTED,
    SIGNALS,
    SIGNALS_ERROR,
    INTERNAL_SIGNALS_ERROR,
    AD_LOADED,
    INTERSTITIAL_IMPRESSION_RECORDED,
    REWARDED_IMPRESSION_RECORDED,
    INTERNAL_LOAD_ERROR,
    QUERY_NOT_FOUND_ERROR,
    LOAD_ERROR,
    NO_AD_ERROR,
    AD_STARTED,
    INTERNAL_SHOW_ERROR,
    AD_NOT_LOADED_ERROR,
    REWARDED_SHOW_ERROR,
    INTERSTITIAL_SHOW_ERROR,
    FIRST_QUARTILE,
    MIDPOINT,
    THIRD_QUARTILE,
    LAST_QUARTILE,
    AD_EARNED_REWARD,
    AD_CLICKED,
    AD_SKIPPED,
    AD_LEFT_APPLICATION,
    AD_CLOSED,
    METHOD_ERROR
}

// ===== FILE: com/unity3d/scar/adapter/common/IAdsErrorHandler.java =====
package com.unity3d.scar.adapter.common;

import com.unity3d.scar.adapter.common.IUnityAdsError;

/* loaded from: classes.dex */
public interface IAdsErrorHandler<T extends IUnityAdsError> {
    void handleError(T t);
}

// ===== FILE: com/unity3d/scar/adapter/common/IScarAdListenerWrapper.java =====
package com.unity3d.scar.adapter.common;

/* loaded from: classes.dex */
public interface IScarAdListenerWrapper {
    void onAdClicked();

    void onAdClosed();

    void onAdFailedToLoad(int i, String str);

    void onAdLoaded();

    void onAdOpened();
}

// ===== FILE: com/unity3d/scar/adapter/common/IScarAdapter.java =====
package com.unity3d.scar.adapter.common;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.common.scarads.UnityAdFormat;
import com.unity3d.scar.adapter.common.signals.ISignalCollectionListener;

/* loaded from: classes.dex */
public interface IScarAdapter {
    void getSCARBiddingSignals(Context context, boolean z, ISignalCollectionListener iSignalCollectionListener);

    void getSCARSignal(Context context, String str, UnityAdFormat unityAdFormat, ISignalCollectionListener iSignalCollectionListener);

    void loadBannerAd(Context context, RelativeLayout relativeLayout, ScarAdMetadata scarAdMetadata, int i, int i2, IScarBannerAdListenerWrapper iScarBannerAdListenerWrapper);

    void loadInterstitialAd(Context context, ScarAdMetadata scarAdMetadata, IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper);

    void loadRewardedAd(Context context, ScarAdMetadata scarAdMetadata, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper);

    void show(Activity activity, String str, String str2);
}

// ===== FILE: com/unity3d/scar/adapter/common/IScarBannerAdListenerWrapper.java =====
package com.unity3d.scar.adapter.common;

/* loaded from: classes.dex */
public interface IScarBannerAdListenerWrapper extends IScarAdListenerWrapper {
    void onAdImpression();
}

// ===== FILE: com/unity3d/scar/adapter/common/IScarInterstitialAdListenerWrapper.java =====
package com.unity3d.scar.adapter.common;

/* loaded from: classes.dex */
public interface IScarInterstitialAdListenerWrapper extends IScarAdListenerWrapper {
    void onAdFailedToShow(int i, String str);

    void onAdImpression();

    void onAdLeftApplication();

    void onAdSkipped();
}

// ===== FILE: com/unity3d/scar/adapter/common/IScarRewardedAdListenerWrapper.java =====
package com.unity3d.scar.adapter.common;

/* loaded from: classes.dex */
public interface IScarRewardedAdListenerWrapper extends IScarAdListenerWrapper {
    void onAdFailedToShow(int i, String str);

    void onAdImpression();

    void onAdSkipped();

    void onUserEarnedReward();
}

// ===== FILE: com/unity3d/scar/adapter/common/IUnityAdsError.java =====
package com.unity3d.scar.adapter.common;

/* loaded from: classes.dex */
public interface IUnityAdsError {
    int getCode();

    String getDescription();

    String getDomain();
}

// ===== FILE: com/unity3d/scar/adapter/common/ScarAdapterBase.java =====
package com.unity3d.scar.adapter.common;

import android.app.Activity;
import android.content.Context;
import com.unity3d.scar.adapter.common.scarads.IScarFullScreenAd;
import com.unity3d.scar.adapter.common.scarads.UnityAdFormat;
import com.unity3d.scar.adapter.common.signals.ISignalCollectionListener;
import com.unity3d.scar.adapter.common.signals.ISignalsCollector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class ScarAdapterBase implements IScarAdapter {
    protected IAdsErrorHandler<WebViewAdsError> _adsErrorHandler;
    protected IScarFullScreenAd _currentAdReference;
    protected Map<String, IScarFullScreenAd> _loadedAds = new ConcurrentHashMap();
    protected ISignalsCollector _signalCollector;

    public ScarAdapterBase(IAdsErrorHandler<WebViewAdsError> iAdsErrorHandler) {
        this._adsErrorHandler = iAdsErrorHandler;
    }

    @Override // com.unity3d.scar.adapter.common.IScarAdapter
    public void getSCARBiddingSignals(Context context, boolean z, ISignalCollectionListener iSignalCollectionListener) {
        this._signalCollector.getSCARBiddingSignals(context, z, iSignalCollectionListener);
    }

    @Override // com.unity3d.scar.adapter.common.IScarAdapter
    public void getSCARSignal(Context context, String str, UnityAdFormat unityAdFormat, ISignalCollectionListener iSignalCollectionListener) {
        this._signalCollector.getSCARSignal(context, str, unityAdFormat, iSignalCollectionListener);
    }

    @Override // com.unity3d.scar.adapter.common.IScarAdapter
    public void show(final Activity activity, String str, String str2) {
        IScarFullScreenAd iScarFullScreenAd = this._loadedAds.get(str2);
        if (iScarFullScreenAd == null) {
            this._adsErrorHandler.handleError(GMAAdsError.NoAdsError(str2, str, "Could not find ad for placement '" + str2 + "'."));
            return;
        }
        this._currentAdReference = iScarFullScreenAd;
        Utils.runOnUiThread(new Runnable() { // from class: com.unity3d.scar.adapter.common.ScarAdapterBase.1
            @Override // java.lang.Runnable
            public void run() {
                ScarAdapterBase.this._currentAdReference.show(activity);
            }
        });
    }
}

// ===== FILE: com/unity3d/scar/adapter/common/Utils.java =====
package com.unity3d.scar.adapter.common;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class Utils {
    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0L);
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        new Handler(Looper.getMainLooper()).postDelayed(runnable, j);
    }
}

// ===== FILE: com/unity3d/scar/adapter/common/WebViewAdsError.java =====
package com.unity3d.scar.adapter.common;

/* loaded from: classes.dex */
public class WebViewAdsError implements IUnityAdsError {
    protected String _description;
    protected Object[] _errorArguments;
    private Enum _errorCategory;

    @Override // com.unity3d.scar.adapter.common.IUnityAdsError
    public int getCode() {
        return -1;
    }

    @Override // com.unity3d.scar.adapter.common.IUnityAdsError
    public String getDomain() {
        return null;
    }

    public WebViewAdsError(Enum<?> r1, String str, Object... objArr) {
        this._errorCategory = r1;
        this._description = str;
        this._errorArguments = objArr;
    }

    @Override // com.unity3d.scar.adapter.common.IUnityAdsError
    public String getDescription() {
        return this._description;
    }

    public Enum<?> getErrorCategory() {
        return this._errorCategory;
    }

    public Object[] getErrorArguments() {
        return this._errorArguments;
    }
}
