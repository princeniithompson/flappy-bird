
// ===== FILE: com/unity3d/services/banners/BannerErrorCode.java =====
package com.unity3d.services.banners;

/* loaded from: classes.dex */
public enum BannerErrorCode {
    UNKNOWN,
    NATIVE_ERROR,
    WEBVIEW_ERROR,
    NO_FILL
}

// ===== FILE: com/unity3d/services/banners/BannerErrorInfo.java =====
package com.unity3d.services.banners;

import com.unity3d.ads.UnityAds;

/* loaded from: classes.dex */
public class BannerErrorInfo {
    public BannerErrorCode errorCode;
    public String errorMessage;

    public BannerErrorInfo(String str, BannerErrorCode bannerErrorCode) {
        this.errorCode = bannerErrorCode;
        this.errorMessage = str;
    }

    public UnityAds.UnityAdsLoadError toLoadError() {
        int i = C11011.$SwitchMap$com$unity3d$services$banners$BannerErrorCode[this.errorCode.ordinal()];
        if (i == 1) {
            return UnityAds.UnityAdsLoadError.INVALID_ARGUMENT;
        }
        if (i == 2) {
            return UnityAds.UnityAdsLoadError.NO_FILL;
        }
        if (i == 3) {
            return UnityAds.UnityAdsLoadError.INTERNAL_ERROR;
        }
        return UnityAds.UnityAdsLoadError.INTERNAL_ERROR;
    }

    /* renamed from: com.unity3d.services.banners.BannerErrorInfo$1 */
    static /* synthetic */ class C11011 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError;
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$banners$BannerErrorCode;

        static {
            int[] iArr = new int[UnityAds.UnityAdsLoadError.values().length];
            $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError = iArr;
            try {
                iArr[UnityAds.UnityAdsLoadError.INITIALIZE_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.INVALID_ARGUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.TIMEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.INTERNAL_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[UnityAds.UnityAdsLoadError.NO_FILL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[BannerErrorCode.values().length];
            $SwitchMap$com$unity3d$services$banners$BannerErrorCode = iArr2;
            try {
                iArr2[BannerErrorCode.NATIVE_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$unity3d$services$banners$BannerErrorCode[BannerErrorCode.NO_FILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$unity3d$services$banners$BannerErrorCode[BannerErrorCode.WEBVIEW_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static BannerErrorInfo fromLoadError(UnityAds.UnityAdsLoadError unityAdsLoadError, String str) {
        int i = C11011.$SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError[unityAdsLoadError.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return new BannerErrorInfo(str, BannerErrorCode.NATIVE_ERROR);
        }
        if (i == 4) {
            return new BannerErrorInfo(str, BannerErrorCode.WEBVIEW_ERROR);
        }
        if (i == 5) {
            return new BannerErrorInfo(str, BannerErrorCode.NO_FILL);
        }
        return new BannerErrorInfo(str, BannerErrorCode.UNKNOWN);
    }
}

// ===== FILE: com/unity3d/services/banners/BannerView.java =====
package com.unity3d.services.banners;

import android.app.Activity;
import android.view.ViewManager;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.services.UnityAdsSDK;
import com.unity3d.services.ads.gmascar.GMA;
import com.unity3d.services.ads.gmascar.GMAScarAdapterBridge;
import com.unity3d.services.ads.webplayer.WebPlayerSettingsCache;
import com.unity3d.services.banners.bridge.BannerBridge;
import com.unity3d.services.banners.view.BannerWebPlayerContainer;
import com.unity3d.services.banners.view.ScarBannerContainer;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.IInitializationListener;
import com.unity3d.services.core.configuration.InitializationNotificationCenter;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.properties.ClientProperties;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    private BannerWebPlayerContainer bannerWebPlayerContainer;
    private final GMAScarAdapterBridge gmaScarAdapterBridge;
    private IInitializationListener initializationListener;
    private IListener listener;
    private String placementId;
    private ScarBannerContainer scarBannerContainer;
    private UnityBannerSize size;
    private String viewId;

    public interface IListener {
        void onBannerClick(BannerView bannerView);

        void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo);

        void onBannerLeftApplication(BannerView bannerView);

        void onBannerLoaded(BannerView bannerView);

        void onBannerShown(BannerView bannerView);
    }

    public static abstract class Listener implements IListener {
        @Override // com.unity3d.services.banners.BannerView.IListener
        public void onBannerClick(BannerView bannerView) {
        }

        @Override // com.unity3d.services.banners.BannerView.IListener
        public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
        }

        @Override // com.unity3d.services.banners.BannerView.IListener
        public void onBannerLeftApplication(BannerView bannerView) {
        }

        @Override // com.unity3d.services.banners.BannerView.IListener
        public void onBannerLoaded(BannerView bannerView) {
        }

        @Override // com.unity3d.services.banners.BannerView.IListener
        public void onBannerShown(BannerView bannerView) {
        }
    }

    public BannerView(Activity activity, String str, UnityBannerSize unityBannerSize) {
        super(activity);
        this.gmaScarAdapterBridge = GMA.getInstance().getBridge();
        this.viewId = UUID.randomUUID().toString();
        this.placementId = str;
        this.size = unityBannerSize;
        setupLayoutParams();
        setBackgroundColor(0);
        ClientProperties.setActivity(activity);
        BannerViewCache.getInstance().addBannerView(this);
    }

    public String getPlacementId() {
        return this.placementId;
    }

    public UnityBannerSize getSize() {
        return this.size;
    }

    public void setListener(IListener iListener) {
        this.listener = iListener;
    }

    public IListener getListener() {
        return this.listener;
    }

    public void load() {
        bridgeLoad();
    }

    public void load(UnityAdsLoadOptions unityAdsLoadOptions) {
        bridgeLoad(unityAdsLoadOptions);
    }

    public void destroy() {
        BannerViewCache.getInstance().removeBannerView(this.viewId);
        unregisterInitializeListener();
        UnityAdsSDK.INSTANCE.finishOMIDSession(this.viewId);
        BannerBridge.destroy(this.placementId);
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.banners.BannerView.1
            @Override // java.lang.Runnable
            public void run() {
                ViewParent parent = this.getParent();
                if (parent == null || !(parent instanceof ViewManager)) {
                    return;
                }
                ((ViewManager) parent).removeView(this);
            }
        });
        BannerWebPlayerContainer bannerWebPlayerContainer = this.bannerWebPlayerContainer;
        if (bannerWebPlayerContainer != null) {
            bannerWebPlayerContainer.destroy();
        }
        ScarBannerContainer scarBannerContainer = this.scarBannerContainer;
        if (scarBannerContainer != null) {
            scarBannerContainer.destroy();
        }
        DeviceLog.info("Banner [" + this.placementId + "] was destroyed");
        this.viewId = null;
        this.listener = null;
        this.bannerWebPlayerContainer = null;
    }

    void loadScarPlayer(String str, ScarAdMetadata scarAdMetadata, UnityBannerSize unityBannerSize) {
        this.gmaScarAdapterBridge.loadBanner(getContext(), this, str, scarAdMetadata, unityBannerSize);
    }

    public void addScarContainer() {
        this.scarBannerContainer = new ScarBannerContainer(getContext(), this.viewId);
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.banners.BannerView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BannerView.this.m441x2c39d1d7();
            }
        });
    }

    /* renamed from: lambda$addScarContainer$0$com-unity3d-services-banners-BannerView */
    /* synthetic */ void m441x2c39d1d7() {
        addView(this.scarBannerContainer);
    }

    void loadWebPlayer(final UnityBannerSize unityBannerSize) {
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.banners.BannerView.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject webSettings = WebPlayerSettingsCache.getInstance().getWebSettings(this.viewId);
                JSONObject webPlayerSettings = WebPlayerSettingsCache.getInstance().getWebPlayerSettings(this.viewId);
                JSONObject webPlayerEventSettings = WebPlayerSettingsCache.getInstance().getWebPlayerEventSettings(this.viewId);
                if (this.bannerWebPlayerContainer != null) {
                    this.bannerWebPlayerContainer.setWebPlayerSettings(webSettings, webPlayerSettings);
                    this.bannerWebPlayerContainer.setWebPlayerEventSettings(webPlayerEventSettings);
                } else {
                    this.bannerWebPlayerContainer = new BannerWebPlayerContainer(this.getContext(), this.viewId, webSettings, webPlayerSettings, webPlayerEventSettings, unityBannerSize);
                    BannerView bannerView = this;
                    bannerView.addView(bannerView.bannerWebPlayerContainer);
                }
            }
        });
    }

    String getViewId() {
        return this.viewId;
    }

    private void registerInitializeListener() {
        unregisterInitializeListener();
        this.initializationListener = new IInitializationListener() { // from class: com.unity3d.services.banners.BannerView.3
            @Override // com.unity3d.services.core.configuration.IInitializationListener
            public void onSdkInitialized() {
                this.unregisterInitializeListener();
                this.bridgeLoad();
            }

            @Override // com.unity3d.services.core.configuration.IInitializationListener
            public void onSdkInitializationFailed(String str, ErrorState errorState, int i) {
                this.unregisterInitializeListener();
                if (this.getListener() != null) {
                    this.getListener().onBannerFailedToLoad(this, new BannerErrorInfo("UnityAds sdk initialization failed", BannerErrorCode.NATIVE_ERROR));
                }
            }
        };
        InitializationNotificationCenter.getInstance().addListener(this.initializationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterInitializeListener() {
        if (this.initializationListener != null) {
            InitializationNotificationCenter.getInstance().removeListener(this.initializationListener);
        }
        this.initializationListener = null;
    }

    private void setupLayoutParams() {
        setLayoutParams(new RelativeLayout.LayoutParams(Math.round(ViewUtilities.pxFromDp(getContext(), this.size.getWidth())), Math.round(ViewUtilities.pxFromDp(getContext(), this.size.getHeight()))));
        setGravity(17);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bridgeLoad() {
        BannerBridge.load(this.placementId, this.viewId, this.size, new UnityAdsLoadOptions());
    }

    private void bridgeLoad(UnityAdsLoadOptions unityAdsLoadOptions) {
        String objectId;
        if (unityAdsLoadOptions != null && (objectId = unityAdsLoadOptions.getObjectId()) != null) {
            BannerViewCache bannerViewCache = BannerViewCache.getInstance();
            bannerViewCache.removeBannerView(this.viewId);
            this.viewId = objectId;
            bannerViewCache.addBannerView(this);
        }
        BannerBridge.load(this.placementId, this.viewId, this.size, unityAdsLoadOptions);
    }
}

// ===== FILE: com/unity3d/services/banners/BannerViewCache.java =====
package com.unity3d.services.banners;

import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.services.ads.operation.load.LoadBannerModule;
import com.unity3d.services.ads.operation.load.LoadBannerOperationState;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.bridge.BannerBridge;
import com.unity3d.services.core.misc.Utilities;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes.dex */
public class BannerViewCache {
    private static BannerViewCache instance;
    private HashMap<String, WeakReference<BannerView>> _bannerViews = new HashMap<>();

    public static BannerViewCache getInstance() {
        if (instance == null) {
            instance = new BannerViewCache();
        }
        return instance;
    }

    public synchronized String addBannerView(BannerView bannerView) {
        this._bannerViews.put(bannerView.getViewId(), new WeakReference<>(bannerView));
        return bannerView.getViewId();
    }

    public synchronized BannerView getBannerView(String str) {
        WeakReference<BannerView> weakReference = this._bannerViews.get(str);
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return weakReference.get();
    }

    public synchronized void removeBannerView(String str) {
        this._bannerViews.remove(str);
    }

    public synchronized void loadBanner(LoadBannerOperationState loadBannerOperationState) {
        String id = loadBannerOperationState.getId();
        UnityBannerSize size = loadBannerOperationState.getSize();
        if (loadBannerOperationState.isScarAd()) {
            loadScarPlayer(id, loadBannerOperationState.getScarAdMetadata(), size);
        } else if (loadWebPlayer(id, size)) {
            BannerBridge.didLoad(id);
        }
    }

    public synchronized void loadScarPlayer(String str, ScarAdMetadata scarAdMetadata, UnityBannerSize unityBannerSize) {
        BannerView bannerView = getBannerView(str);
        if (bannerView != null) {
            bannerView.loadScarPlayer(str, scarAdMetadata, unityBannerSize);
        }
    }

    public synchronized void addScarContainer(String str) {
        BannerView bannerView = getBannerView(str);
        if (bannerView != null) {
            bannerView.addScarContainer();
        }
    }

    public synchronized boolean loadWebPlayer(String str, UnityBannerSize unityBannerSize) {
        BannerView bannerView = getBannerView(str);
        if (bannerView == null) {
            return false;
        }
        bannerView.loadWebPlayer(unityBannerSize);
        return true;
    }

    public synchronized void triggerBannerLoadEvent(String str) {
        final BannerView bannerView = getBannerView(str);
        if (bannerView != null && bannerView.getListener() != null) {
            LoadBannerModule.getInstance().onUnityAdsAdLoaded(str);
            final BannerView.IListener listener = bannerView.getListener();
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.banners.BannerViewCache.1
                @Override // java.lang.Runnable
                public void run() {
                    BannerView.IListener iListener = listener;
                    if (iListener != null) {
                        iListener.onBannerLoaded(bannerView);
                    }
                }
            });
        }
    }

    public synchronized void triggerBannerShowEvent(String str) {
        final BannerView bannerView = getBannerView(str);
        if (bannerView != null && bannerView.getListener() != null) {
            final BannerView.IListener listener = bannerView.getListener();
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.banners.BannerViewCache.2
                @Override // java.lang.Runnable
                public void run() {
                    BannerView.IListener iListener = listener;
                    if (iListener != null) {
                        iListener.onBannerShown(bannerView);
                    }
                }
            });
        }
    }

    public synchronized void triggerBannerClickEvent(String str) {
        final BannerView bannerView = getBannerView(str);
        if (bannerView != null && bannerView.getListener() != null) {
            final BannerView.IListener listener = bannerView.getListener();
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.banners.BannerViewCache.3
                @Override // java.lang.Runnable
                public void run() {
                    BannerView.IListener iListener = listener;
                    if (iListener != null) {
                        iListener.onBannerClick(bannerView);
                    }
                }
            });
        }
    }

    public synchronized void triggerBannerErrorEvent(String str, BannerErrorInfo bannerErrorInfo) {
        LoadBannerModule.getInstance().onUnityAdsFailedToLoad(str, bannerErrorInfo.toLoadError(), bannerErrorInfo.errorMessage);
    }

    public synchronized void triggerBannerLeftApplicationEvent(String str) {
        final BannerView bannerView = getBannerView(str);
        if (bannerView != null && bannerView.getListener() != null) {
            final BannerView.IListener listener = bannerView.getListener();
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.banners.BannerViewCache.4
                @Override // java.lang.Runnable
                public void run() {
                    BannerView.IListener iListener = listener;
                    if (iListener != null) {
                        iListener.onBannerLeftApplication(bannerView);
                    }
                }
            });
        }
    }
}

// ===== FILE: com/unity3d/services/banners/IUnityBannerListener.java =====
package com.unity3d.services.banners;

import android.view.View;

/* loaded from: classes.dex */
public interface IUnityBannerListener {
    void onUnityBannerClick(String str);

    void onUnityBannerError(String str);

    void onUnityBannerHide(String str);

    void onUnityBannerLoaded(String str, View view);

    void onUnityBannerShow(String str);

    void onUnityBannerUnloaded(String str);
}

// ===== FILE: com/unity3d/services/banners/UnityBannerSize.java =====
package com.unity3d.services.banners;

import android.content.Context;
import com.unity3d.services.core.misc.ViewUtilities;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: UnityBannerSize.kt */
@Metadata(m443d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, m444d2 = {"Lcom/unity3d/services/banners/UnityBannerSize;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "Companion", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class UnityBannerSize {
    private final int height;
    private final int width;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UnityBannerSize leaderboard = new UnityBannerSize(728, 90);
    private static final UnityBannerSize iabStandard = new UnityBannerSize(468, 60);
    private static final UnityBannerSize standard = new UnityBannerSize(320, 50);

    @JvmStatic
    public static final UnityBannerSize getDynamicSize(Context context) {
        return INSTANCE.getDynamicSize(context);
    }

    /* compiled from: UnityBannerSize.kt */
    @Metadata(m443d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000e"}, m444d2 = {"Lcom/unity3d/services/banners/UnityBannerSize$Companion;", "", "()V", "iabStandard", "Lcom/unity3d/services/banners/UnityBannerSize;", "getIabStandard", "()Lcom/unity3d/services/banners/UnityBannerSize;", "leaderboard", "getLeaderboard", "standard", "getStandard", "getDynamicSize", "context", "Landroid/content/Context;", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UnityBannerSize getLeaderboard() {
            return UnityBannerSize.leaderboard;
        }

        public final UnityBannerSize getIabStandard() {
            return UnityBannerSize.iabStandard;
        }

        public final UnityBannerSize getStandard() {
            return UnityBannerSize.standard;
        }

        @JvmStatic
        public final UnityBannerSize getDynamicSize(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            int roundToInt = MathKt.roundToInt(ViewUtilities.dpFromPx(context, context.getResources().getDisplayMetrics().widthPixels));
            return roundToInt >= getLeaderboard().getWidth() ? getLeaderboard() : roundToInt >= getIabStandard().getWidth() ? getIabStandard() : getStandard();
        }
    }

    public UnityBannerSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }
}

// ===== FILE: com/unity3d/services/banners/UnityBanners.java =====
package com.unity3d.services.banners;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.properties.BannerRefreshInfo;
import com.unity3d.services.banners.view.BannerPosition;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.properties.ClientProperties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class UnityBanners {
    private static UnityBanners instance;
    private IUnityBannerListener _bannerListener;
    private BannerPosition _currentBannerPosition = BannerPosition.NONE;
    private BannerWrapper _currentBannerWrapper;

    private static UnityBanners getInstance() {
        if (instance == null) {
            instance = new UnityBanners();
        }
        return instance;
    }

    private class BannerWrapper extends FrameLayout {
        private BannerAdRefreshView _bannerAdRefreshView;
        private BannerPosition _bannerPosition;

        public BannerWrapper(Context context, BannerAdRefreshView bannerAdRefreshView) {
            super(context);
            this._bannerPosition = BannerPosition.NONE;
            this._bannerAdRefreshView = bannerAdRefreshView;
            addView(bannerAdRefreshView);
            setupLayoutConstraints();
            setBackgroundColor(0);
        }

        public void setBannerPosition(BannerPosition bannerPosition) {
            this._bannerPosition = bannerPosition;
            setupLayoutConstraints();
        }

        private void setupLayoutConstraints() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = this._bannerPosition.getGravity();
            setLayoutParams(layoutParams);
        }

        public void destroy() {
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.banners.UnityBanners.BannerWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    this.removeAllViews();
                    ViewUtilities.removeViewFromParent(this);
                }
            });
            BannerAdRefreshView bannerAdRefreshView = this._bannerAdRefreshView;
            if (bannerAdRefreshView != null) {
                bannerAdRefreshView.destroy();
                this._bannerAdRefreshView = null;
            }
        }
    }

    private UnityBanners() {
    }

    private void _loadBanner(Activity activity, String str) {
        if (this._currentBannerWrapper == null) {
            BannerAdRefreshView bannerAdRefreshView = new BannerAdRefreshView(activity, str, new UnityBannerSize(320, 50));
            final BannerWrapper bannerWrapper = new BannerWrapper(activity, bannerAdRefreshView);
            bannerWrapper.setBannerPosition(this._currentBannerPosition);
            this._currentBannerWrapper = bannerWrapper;
            bannerAdRefreshView.setListener(new BannerView.Listener() { // from class: com.unity3d.services.banners.UnityBanners.1
                @Override // com.unity3d.services.banners.BannerView.Listener, com.unity3d.services.banners.BannerView.IListener
                public void onBannerLoaded(BannerView bannerView) {
                    if (this._bannerListener != null) {
                        this._bannerListener.onUnityBannerLoaded(bannerView.getPlacementId(), bannerWrapper);
                    }
                }

                @Override // com.unity3d.services.banners.BannerView.Listener, com.unity3d.services.banners.BannerView.IListener
                public void onBannerShown(BannerView bannerView) {
                    if (this._bannerListener != null) {
                        this._bannerListener.onUnityBannerShow(bannerView.getPlacementId());
                    }
                }

                @Override // com.unity3d.services.banners.BannerView.Listener, com.unity3d.services.banners.BannerView.IListener
                public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
                    if (this._bannerListener != null) {
                        this._bannerListener.onUnityBannerError(bannerView.getPlacementId() + " " + bannerErrorInfo.errorMessage);
                    }
                }

                @Override // com.unity3d.services.banners.BannerView.Listener, com.unity3d.services.banners.BannerView.IListener
                public void onBannerClick(BannerView bannerView) {
                    if (this._bannerListener != null) {
                        this._bannerListener.onUnityBannerClick(bannerView.getPlacementId());
                    }
                }
            });
            bannerAdRefreshView.load();
            return;
        }
        sendError("A Banner is already in use, please call destroy before loading another banner!");
    }

    private void _destroy() {
        BannerWrapper bannerWrapper = this._currentBannerWrapper;
        if (bannerWrapper != null) {
            bannerWrapper.destroy();
            this._currentBannerWrapper = null;
        }
    }

    private static void sendError(final String str) {
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.banners.UnityBanners.2
            @Override // java.lang.Runnable
            public void run() {
                IUnityBannerListener bannerListener = UnityBanners.getBannerListener();
                if (bannerListener != null) {
                    bannerListener.onUnityBannerError(str);
                }
            }
        });
    }

    @Deprecated
    public static void loadBanner(Activity activity, String str) {
        DeviceLog.entered();
        if (!UnityAds.isSupported()) {
            sendError("Unity Ads is not supported on this device.");
        }
        if (!UnityAds.isInitialized()) {
            sendError("UnityAds is not initialized.");
        } else {
            ClientProperties.setActivity(activity);
            getInstance()._loadBanner(activity, str);
        }
    }

    @Deprecated
    public static void destroy() {
        getInstance()._destroy();
    }

    @Deprecated
    public static void setBannerListener(IUnityBannerListener iUnityBannerListener) {
        getInstance()._bannerListener = iUnityBannerListener;
    }

    @Deprecated
    public static IUnityBannerListener getBannerListener() {
        return getInstance()._bannerListener;
    }

    @Deprecated
    public static void setBannerPosition(BannerPosition bannerPosition) {
        getInstance()._currentBannerPosition = bannerPosition;
    }

    private class BannerAdRefreshView extends RelativeLayout {
        private BannerView bannerView;
        private boolean didLoad;
        private boolean didShow;
        private boolean didSubscribeToLifecycle;
        private LifecycleListener lifecycleListener;
        private String placementId;
        private Handler refreshHandler;
        private long refreshRate;
        private long refreshTime;
        private Runnable reloadRunnable;

        public BannerAdRefreshView(Activity activity, String str, UnityBannerSize unityBannerSize) {
            super(activity);
            this.didLoad = false;
            this.refreshRate = 30L;
            this.didShow = false;
            this.didSubscribeToLifecycle = false;
            this.placementId = str;
            this.refreshHandler = new Handler();
            this.reloadRunnable = new Runnable() { // from class: com.unity3d.services.banners.UnityBanners.BannerAdRefreshView.1
                @Override // java.lang.Runnable
                public void run() {
                    this.reload();
                }
            };
            setupLayoutParams();
            setBackgroundColor(0);
            BannerView bannerView = new BannerView(activity, str, unityBannerSize);
            this.bannerView = bannerView;
            addView(bannerView);
        }

        public String getPlacementId() {
            return this.bannerView.getPlacementId();
        }

        public UnityBannerSize getSize() {
            return this.bannerView.getSize();
        }

        public void setListener(BannerView.IListener iListener) {
            this.bannerView.setListener(iListener);
        }

        public BannerView.IListener getListener() {
            return this.bannerView.getListener();
        }

        public void load() {
            if (this.didLoad) {
                return;
            }
            this.didLoad = true;
            Integer refreshRate = BannerRefreshInfo.getInstance().getRefreshRate(this.placementId);
            if (refreshRate != null) {
                this.refreshRate = refreshRate.longValue();
            }
            reload();
        }

        public void destroy() {
            stopReloadTask();
            this.bannerView.destroy();
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.banners.UnityBanners.BannerAdRefreshView.2
                @Override // java.lang.Runnable
                public void run() {
                    this.removeAllViews();
                }
            });
            this.bannerView = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startReloadTask() {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = this.refreshTime;
            if (uptimeMillis < j) {
                this.refreshHandler.postAtTime(this.reloadRunnable, j);
            } else {
                reload();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stopReloadTask() {
            Runnable runnable;
            Handler handler = this.refreshHandler;
            if (handler == null || (runnable = this.reloadRunnable) == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reload() {
            UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
            unityAdsLoadOptions.setObjectId(UUID.randomUUID().toString());
            this.bannerView.load(unityAdsLoadOptions);
            long uptimeMillis = SystemClock.uptimeMillis() + TimeUnit.SECONDS.toMillis(this.refreshRate);
            this.refreshTime = uptimeMillis;
            this.refreshHandler.postAtTime(this.reloadRunnable, uptimeMillis);
        }

        private void subscribeToLifecycle() {
            if (this.didSubscribeToLifecycle || ClientProperties.getApplication() == null) {
                return;
            }
            this.lifecycleListener = new LifecycleListener() { // from class: com.unity3d.services.banners.UnityBanners.BannerAdRefreshView.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.unity3d.services.banners.UnityBanners.BannerAdRefreshView.LifecycleListener, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    this.stopReloadTask();
                }

                @Override // com.unity3d.services.banners.UnityBanners.BannerAdRefreshView.LifecycleListener, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    this.stopReloadTask();
                }

                @Override // com.unity3d.services.banners.UnityBanners.BannerAdRefreshView.LifecycleListener, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    this.stopReloadTask();
                }

                @Override // com.unity3d.services.banners.UnityBanners.BannerAdRefreshView.LifecycleListener, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    this.startReloadTask();
                }
            };
            this.didSubscribeToLifecycle = true;
            ClientProperties.getApplication().registerActivityLifecycleCallbacks(this.lifecycleListener);
        }

        private void unsubscribeFromLifecycle() {
            if (!this.didSubscribeToLifecycle || this.lifecycleListener == null || ClientProperties.getApplication() == null) {
                return;
            }
            this.didSubscribeToLifecycle = false;
            ClientProperties.getApplication().unregisterActivityLifecycleCallbacks(this.lifecycleListener);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            stopReloadTask();
            unsubscribeFromLifecycle();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            subscribeToLifecycle();
            if (this.didShow) {
                startReloadTask();
            } else {
                this.didShow = true;
            }
        }

        private void setupLayoutParams() {
            setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }

        private class LifecycleListener implements Application.ActivityLifecycleCallbacks {
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }

            private LifecycleListener() {
            }
        }
    }
}
