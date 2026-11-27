// Package bundle: com.unity3d.services.banners (27 classes)

// ============================================================
// CLASS: com.unity3d.services.banners.BannerErrorCode
// ============================================================
package com.unity3d.services.banners;

public final class BannerErrorCode extends Enum {
    private static final BannerErrorCode[] $VALUES;
    public static final BannerErrorCode NATIVE_ERROR;
    public static final BannerErrorCode NO_FILL;
    public static final BannerErrorCode UNKNOWN;
    public static final BannerErrorCode WEBVIEW_ERROR;

    private static BannerErrorCode[] $values() {
        return 4;
    }

    static <clinit>() {
        new BannerErrorCode("UNKNOWN", 0);
        UNKNOWN = new BannerErrorCode(..);
        new BannerErrorCode("NATIVE_ERROR", 1);
        NATIVE_ERROR = new BannerErrorCode(..);
        new BannerErrorCode("WEBVIEW_ERROR", 2);
        WEBVIEW_ERROR = new BannerErrorCode(..);
        new BannerErrorCode("NO_FILL", 3);
        NO_FILL = new BannerErrorCode(..);
        BannerErrorCode.$values();
        $VALUES = BannerErrorCode.$values(..);
        return;
    }

    private BannerErrorCode(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static BannerErrorCode valueOf(String p0) {
        Enum.valueOf(BannerErrorCode.class, p0);
        return Enum.valueOf(..);
    }

    public static BannerErrorCode[] values() {
        BannerErrorCode.$VALUES.clone();
        return BannerErrorCode[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.BannerErrorInfo
// ============================================================
package com.unity3d.services.banners;

public class BannerErrorInfo {
    public BannerErrorCode errorCode;
    public String errorMessage;

    public BannerErrorInfo(String p0, BannerErrorCode p1) {
        new Object();
        errorCode = p1;
        errorMessage = p0;
        return;
    }

    public static BannerErrorInfo fromLoadError(UnityAds$UnityAdsLoadError p0, String p1) {
        p0.ordinal();
        if (if-eq(UnityAds$UnityAdsLoadError.ordinal(..), 1)) goto L_2f;
        if (if-eq(UnityAds$UnityAdsLoadError.ordinal(..), 2)) goto L_2f;
        if (if-eq(UnityAds$UnityAdsLoadError.ordinal(..), 3)) goto L_2f;
        if (if-eq(UnityAds$UnityAdsLoadError.ordinal(..), 4)) goto L_27;
        if (if-eq(UnityAds$UnityAdsLoadError.ordinal(..), 5)) goto L_1f;
        new BannerErrorInfo(p1, BannerErrorCode.UNKNOWN);
        return new BannerErrorInfo(..);
      L_1f:
        new BannerErrorInfo(p1, BannerErrorCode.NO_FILL);
        return new BannerErrorInfo(..);
      L_27:
        new BannerErrorInfo(p1, BannerErrorCode.WEBVIEW_ERROR);
        return new BannerErrorInfo(..);
      L_2f:
        new BannerErrorInfo(p1, BannerErrorCode.NATIVE_ERROR);
        return new BannerErrorInfo(..);
    }

    public UnityAds$UnityAdsLoadError toLoadError() {
        errorCode.ordinal();
        if (if-eq(BannerErrorInfo$1.$SwitchMap$com$unity3d$services$banners$BannerErrorCode, 1)) goto L_1c;
        if (if-eq(BannerErrorInfo$1.$SwitchMap$com$unity3d$services$banners$BannerErrorCode, 2)) goto L_19;
        if (if-eq(BannerErrorInfo$1.$SwitchMap$com$unity3d$services$banners$BannerErrorCode, 3)) goto L_16;
        return UnityAds$UnityAdsLoadError.INTERNAL_ERROR;
      L_16:
        return UnityAds$UnityAdsLoadError.INTERNAL_ERROR;
      L_19:
        return UnityAds$UnityAdsLoadError.NO_FILL;
      L_1c:
        return UnityAds$UnityAdsLoadError.INVALID_ARGUMENT;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.BannerView
// ============================================================
package com.unity3d.services.banners;

public class BannerView extends RelativeLayout {
    private BannerWebPlayerContainer bannerWebPlayerContainer;
    private final GMAScarAdapterBridge gmaScarAdapterBridge;
    private IInitializationListener initializationListener;
    private BannerView$IListener listener;
    private String placementId;
    private ScarBannerContainer scarBannerContainer;
    private UnityBannerSize size;
    private String viewId;

    public BannerView(Activity p0, String p1, UnityBannerSize p2) {
        new RelativeLayout(p0);
        GMA.getInstance();
        GMA.getInstance(..).getBridge();
        gmaScarAdapterBridge = GMA.getBridge(..);
        UUID.randomUUID();
        UUID.randomUUID(..).toString();
        viewId = UUID.toString(..);
        placementId = p1;
        size = p2;
        new RelativeLayout(..).setupLayoutParams();
        new RelativeLayout(..).setBackgroundColor(0);
        ClientProperties.setActivity(p0);
        BannerViewCache.getInstance();
        BannerViewCache.getInstance(..).addBannerView(new RelativeLayout(..));
        return;
    }

    static String access$000(BannerView p0) {
        return viewId;
    }

    static BannerWebPlayerContainer access$100(BannerView p0) {
        return bannerWebPlayerContainer;
    }

    static BannerWebPlayerContainer access$102(BannerView p0, BannerWebPlayerContainer p1) {
        bannerWebPlayerContainer = p1;
        return p1;
    }

    static void access$200(BannerView p0) {
        p0.unregisterInitializeListener();
        return;
    }

    static void access$300(BannerView p0) {
        p0.bridgeLoad();
        return;
    }

    private void bridgeLoad() {
        new UnityAdsLoadOptions();
        BannerBridge.load(placementId, viewId, size, new UnityAdsLoadOptions(..));
        return;
    }

    private void bridgeLoad(UnityAdsLoadOptions p0) {
        if (if-eqz(p0)) goto L_16;
        p0.getObjectId();
        if (if-eqz(UnityAdsLoadOptions.getObjectId(..))) goto L_16;
        BannerViewCache.getInstance();
        BannerViewCache.getInstance(..).removeBannerView(viewId);
        viewId = UnityAdsLoadOptions.getObjectId(..);
        BannerViewCache.getInstance(..).addBannerView(this);
      L_16:
        BannerBridge.load(placementId, viewId, size, p0);
        return;
    }

    private void registerInitializeListener() {
        BannerView.unregisterInitializeListener();
        new BannerView$3(this, this);
        initializationListener = new BannerView$3(..);
        InitializationNotificationCenter.getInstance();
        InitializationNotificationCenter.addListener(initializationListener);
        return;
    }

    private void setupLayoutParams() {
        BannerView.getContext();
        size.getWidth();
        ViewUtilities.pxFromDp(BannerView.getContext(..), UnityBannerSize.getWidth(..));
        Math.round(ViewUtilities.pxFromDp(..));
        BannerView.getContext();
        size.getHeight();
        ViewUtilities.pxFromDp(BannerView.getContext(..), UnityBannerSize.getHeight(..));
        Math.round(ViewUtilities.pxFromDp(..));
        new RelativeLayout$LayoutParams(Math.round(..), Math.round(..));
        BannerView.setLayoutParams(new RelativeLayout$LayoutParams(..));
        BannerView.setGravity(17);
        BannerView.requestLayout();
        return;
    }

    private void unregisterInitializeListener() {
        if (if-eqz(initializationListener)) goto L_d;
        InitializationNotificationCenter.getInstance();
        InitializationNotificationCenter.removeListener(initializationListener);
      L_d:
        initializationListener = 0;
        return;
    }

    public void addScarContainer() {
        BannerView.getContext();
        new ScarBannerContainer(BannerView.getContext(..), viewId);
        scarBannerContainer = new ScarBannerContainer(..);
        new BannerView$$ExternalSyntheticLambda0(this);
        Utilities.runOnUiThread(new BannerView$$ExternalSyntheticLambda0(..));
        return;
    }

    public void destroy() {
        BannerViewCache.getInstance();
        BannerViewCache.getInstance(..).removeBannerView(viewId);
        BannerView.unregisterInitializeListener();
        UnityAdsSDK.INSTANCE.finishOMIDSession(viewId);
        BannerBridge.destroy(placementId);
        new BannerView$1(this, this);
        Utilities.runOnUiThread(new BannerView$1(..));
        if (if-eqz(bannerWebPlayerContainer)) goto L_27;
        bannerWebPlayerContainer.destroy();
      L_27:
        if (if-eqz(scarBannerContainer)) goto L_2e;
        scarBannerContainer.destroy();
      L_2e:
        new StringBuilder("Banner [");
        new StringBuilder(..).append(placementId);
        new StringBuilder(..).append("] was destroyed");
        new StringBuilder(..).toString();
        DeviceLog.info(StringBuilder.toString(..));
        viewId = 0;
        listener = 0;
        bannerWebPlayerContainer = 0;
        return;
    }

    public BannerView$IListener getListener() {
        return listener;
    }

    public String getPlacementId() {
        return placementId;
    }

    public UnityBannerSize getSize() {
        return size;
    }

    String getViewId() {
        return viewId;
    }

    void lambda$addScarContainer$0$com-unity3d-services-banners-BannerView() {
        BannerView.addView(scarBannerContainer);
        return;
    }

    public void load() {
        BannerView.bridgeLoad();
        return;
    }

    public void load(UnityAdsLoadOptions p0) {
        BannerView.bridgeLoad(p0);
        return;
    }

    void loadScarPlayer(String p0, ScarAdMetadata p1, UnityBannerSize p2) {
        BannerView.getContext();
        gmaScarAdapterBridge.loadBanner(BannerView.getContext(..), this, p0, p1, p2);
        return;
    }

    void loadWebPlayer(UnityBannerSize p0) {
        new BannerView$2(this, this, p0);
        Utilities.runOnUiThread(new BannerView$2(..));
        return;
    }

    public void setListener(BannerView$IListener p0) {
        listener = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.BannerViewCache
// ============================================================
package com.unity3d.services.banners;

public class BannerViewCache {
    private static BannerViewCache instance;
    private HashMap _bannerViews;

    public BannerViewCache() {
        new Object();
        new HashMap();
        _bannerViews = new HashMap(..);
        return;
    }

    public static BannerViewCache getInstance() {
        if (if-nez(BannerViewCache.instance)) goto L_b;
        new BannerViewCache();
        instance = new BannerViewCache(..);
      L_b:
        return BannerViewCache.instance;
    }

    public String addBannerView(BannerView p0) {
        new WeakReference(p0);
        p0.getViewId();
        _bannerViews.put(BannerView.getViewId(..), new WeakReference(..));
        p0.getViewId();
        return BannerView.getViewId(..);
        throw BannerView.getViewId(..);
    }

    public void addScarContainer(String p0) {
        BannerViewCache.getBannerView(p0);
        if (if-eqz(BannerViewCache.getBannerView(..))) goto L_a;
        BannerViewCache.getBannerView(..).addScarContainer();
      L_a:
        return;
        throw BannerViewCache.getBannerView(..);
    }

    public BannerView getBannerView(String p0) {
        _bannerViews.get(p0);
        if (if-eqz(HashMap.get(..))) goto L_19;
        HashMap.get(..).get();
        if (if-eqz(WeakReference.get(..))) goto L_19;
        HashMap.get(..).get();
        return WeakReference.get(..);
      L_19:
        return 0;
        throw 0;
    }

    public void loadBanner(LoadBannerOperationState p0) {
        p0.getId();
        p0.getSize();
        p0.isScarAd();
        if (if-eqz(LoadBannerOperationState.isScarAd(..))) goto L_17;
        p0.getScarAdMetadata();
        BannerViewCache.loadScarPlayer(LoadBannerOperationState.getId(..), LoadBannerOperationState.getScarAdMetadata(..), LoadBannerOperationState.getSize(..));
      L_17:
        BannerViewCache.loadWebPlayer(LoadBannerOperationState.getId(..), LoadBannerOperationState.getSize(..));
        if (if-eqz(BannerViewCache.loadWebPlayer(..))) goto L_20;
        BannerBridge.didLoad(LoadBannerOperationState.getId(..));
      L_20:
        return;
        throw BannerViewCache.loadWebPlayer(..);
    }

    public void loadScarPlayer(String p0, ScarAdMetadata p1, UnityBannerSize p2) {
        BannerViewCache.getBannerView(p0);
        if (if-eqz(BannerViewCache.getBannerView(..))) goto L_a;
        BannerViewCache.getBannerView(..).loadScarPlayer(p0, p1, p2);
      L_a:
        return;
        throw p0;
    }

    public boolean loadWebPlayer(String p0, UnityBannerSize p1) {
        BannerViewCache.getBannerView(p0);
        if (if-eqz(BannerViewCache.getBannerView(..))) goto L_d;
        BannerViewCache.getBannerView(..).loadWebPlayer(p1);
        return 1;
      L_d:
        return 0;
        throw 0;
    }

    public void removeBannerView(String p0) {
        _bannerViews.remove(p0);
        return;
        throw p0;
    }

    public void triggerBannerClickEvent(String p0) {
        BannerViewCache.getBannerView(p0);
        if (if-eqz(BannerViewCache.getBannerView(..))) goto L_19;
        BannerViewCache.getBannerView(..).getListener();
        if (if-eqz(BannerView.getListener(..))) goto L_19;
        BannerViewCache.getBannerView(..).getListener();
        new BannerViewCache$3(this, BannerView.getListener(..), BannerViewCache.getBannerView(..));
        Utilities.runOnUiThread(new BannerViewCache$3(..));
      L_19:
        return;
        throw BannerViewCache.getBannerView(..);
    }

    public void triggerBannerErrorEvent(String p0, BannerErrorInfo p1) {
        p1.toLoadError();
        LoadBannerModule.getInstance();
        LoadBannerModule.getInstance(..).onUnityAdsFailedToLoad(p0, BannerErrorInfo.toLoadError(..), errorMessage);
        return;
        throw p0;
    }

    public void triggerBannerLeftApplicationEvent(String p0) {
        BannerViewCache.getBannerView(p0);
        if (if-eqz(BannerViewCache.getBannerView(..))) goto L_19;
        BannerViewCache.getBannerView(..).getListener();
        if (if-eqz(BannerView.getListener(..))) goto L_19;
        BannerViewCache.getBannerView(..).getListener();
        new BannerViewCache$4(this, BannerView.getListener(..), BannerViewCache.getBannerView(..));
        Utilities.runOnUiThread(new BannerViewCache$4(..));
      L_19:
        return;
        throw BannerViewCache.getBannerView(..);
    }

    public void triggerBannerLoadEvent(String p0) {
        BannerViewCache.getBannerView(p0);
        if (if-eqz(BannerViewCache.getBannerView(..))) goto L_20;
        BannerViewCache.getBannerView(..).getListener();
        if (if-eqz(BannerView.getListener(..))) goto L_20;
        LoadBannerModule.getInstance();
        LoadBannerModule.getInstance(..).onUnityAdsAdLoaded(p0);
        BannerViewCache.getBannerView(..).getListener();
        new BannerViewCache$1(this, BannerView.getListener(..), BannerViewCache.getBannerView(..));
        Utilities.runOnUiThread(new BannerViewCache$1(..));
      L_20:
        return;
        throw BannerView.getListener(..);
    }

    public void triggerBannerShowEvent(String p0) {
        BannerViewCache.getBannerView(p0);
        if (if-eqz(BannerViewCache.getBannerView(..))) goto L_19;
        BannerViewCache.getBannerView(..).getListener();
        if (if-eqz(BannerView.getListener(..))) goto L_19;
        BannerViewCache.getBannerView(..).getListener();
        new BannerViewCache$2(this, BannerView.getListener(..), BannerViewCache.getBannerView(..));
        Utilities.runOnUiThread(new BannerViewCache$2(..));
      L_19:
        return;
        throw BannerViewCache.getBannerView(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.IUnityBannerListener
// ============================================================
package com.unity3d.services.banners;

public abstract class IUnityBannerListener {
    public abstract void onUnityBannerClick(String p0) {
        // native or abstract
    }

    public abstract void onUnityBannerError(String p0) {
        // native or abstract
    }

    public abstract void onUnityBannerHide(String p0) {
        // native or abstract
    }

    public abstract void onUnityBannerLoaded(String p0, View p1) {
        // native or abstract
    }

    public abstract void onUnityBannerShow(String p0) {
        // native or abstract
    }

    public abstract void onUnityBannerUnloaded(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.UnityBannerSize
// ============================================================
package com.unity3d.services.banners;

public final class UnityBannerSize {
    public static final UnityBannerSize$Companion Companion;
    private static final UnityBannerSize iabStandard;
    private static final UnityBannerSize leaderboard;
    private static final UnityBannerSize standard;
    private final int height;
    private final int width;

    static <clinit>() {
        new UnityBannerSize$Companion(0);
        Companion = new UnityBannerSize$Companion(..);
        new UnityBannerSize(728, 90);
        leaderboard = new UnityBannerSize(..);
        new UnityBannerSize(468, 60);
        iabStandard = new UnityBannerSize(..);
        new UnityBannerSize(320, 50);
        standard = new UnityBannerSize(..);
        return;
    }

    public UnityBannerSize(int p0, int p1) {
        new Object();
        width = p0;
        height = p1;
        return;
    }

    public static final UnityBannerSize access$getIabStandard$cp() {
        return UnityBannerSize.iabStandard;
    }

    public static final UnityBannerSize access$getLeaderboard$cp() {
        return UnityBannerSize.leaderboard;
    }

    public static final UnityBannerSize access$getStandard$cp() {
        return UnityBannerSize.standard;
    }

    public static final UnityBannerSize getDynamicSize(Context p0) {
        UnityBannerSize.Companion.getDynamicSize(p0);
        return UnityBannerSize$Companion.getDynamicSize(..);
    }

    public final int getHeight() {
        return height;
    }

    public final int getWidth() {
        return width;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.UnityBanners
// ============================================================
package com.unity3d.services.banners;

public final class UnityBanners {
    private static UnityBanners instance;
    private IUnityBannerListener _bannerListener;
    private BannerPosition _currentBannerPosition;
    private UnityBanners$BannerWrapper _currentBannerWrapper;

    private UnityBanners() {
        new Object();
        _currentBannerPosition = BannerPosition.NONE;
        return;
    }

    private void _destroy() {
        if (if-eqz(_currentBannerWrapper)) goto L_a;
        _currentBannerWrapper.destroy();
        _currentBannerWrapper = 0;
      L_a:
        return;
    }

    private void _loadBanner(Activity p0, String p1) {
        if (if-nez(_currentBannerWrapper)) goto L_2a;
        new UnityBannerSize(320, 50);
        new UnityBanners$BannerAdRefreshView(this, p0, p1, new UnityBannerSize(..));
        new UnityBanners$BannerWrapper(this, p0, new UnityBanners$BannerAdRefreshView(..));
        new UnityBanners$BannerWrapper(..).setBannerPosition(_currentBannerPosition);
        _currentBannerWrapper = new UnityBanners$BannerWrapper(..);
        new UnityBanners$1(this, this, new UnityBanners$BannerWrapper(..));
        UnityBanners$BannerAdRefreshView.setListener(new UnityBanners$1(..));
        UnityBanners$BannerAdRefreshView.load();
      L_2a:
        UnityBanners.sendError("A Banner is already in use, please call destroy before loading another banner!");
      L_2f:
        return;
    }

    static IUnityBannerListener access$000(UnityBanners p0) {
        return _bannerListener;
    }

    public static void destroy() {
        UnityBanners.getInstance();
        UnityBanners.getInstance(..)._destroy();
        return;
    }

    public static IUnityBannerListener getBannerListener() {
        UnityBanners.getInstance();
        return _bannerListener;
    }

    private static UnityBanners getInstance() {
        if (if-nez(UnityBanners.instance)) goto L_b;
        new UnityBanners();
        instance = new UnityBanners(..);
      L_b:
        return UnityBanners.instance;
    }

    public static void loadBanner(Activity p0, String p1) {
        DeviceLog.entered();
        UnityAds.isSupported();
        if (if-nez(UnityAds.isSupported(..))) goto L_e;
        UnityBanners.sendError("Unity Ads is not supported on this device.");
      L_e:
        UnityAds.isInitialized();
        if (if-nez(UnityAds.isInitialized(..))) goto L_1a;
        UnityBanners.sendError("UnityAds is not initialized.");
        return;
      L_1a:
        ClientProperties.setActivity("UnityAds is not initialized.");
        UnityBanners.getInstance();
        UnityBanners.getInstance(..)._loadBanner("UnityAds is not initialized.", p1);
        return;
    }

    private static void sendError(String p0) {
        new UnityBanners$2(p0);
        Utilities.runOnUiThread(new UnityBanners$2(..));
        return;
    }

    public static void setBannerListener(IUnityBannerListener p0) {
        UnityBanners.getInstance();
        _bannerListener = p0;
        return;
    }

    public static void setBannerPosition(BannerPosition p0) {
        UnityBanners.getInstance();
        _currentBannerPosition = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.BannerErrorInfo$1
// ============================================================
package com.unity3d.services.banners;

class BannerErrorInfo$1 {
    static final int[] $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError;
    static final int[] $SwitchMap$com$unity3d$services$banners$BannerErrorCode;

    static <clinit>() {
        UnityAds$UnityAdsLoadError.values();
        $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsLoadError = UnityAds$UnityAdsLoadError.values(..);
        UnityAds$UnityAdsLoadError.ordinal();
        UnityAds$UnityAdsLoadError.ordinal();
        UnityAds$UnityAdsLoadError.TIMEOUT.ordinal();
        UnityAds$UnityAdsLoadError.ordinal();
        UnityAds$UnityAdsLoadError.NO_FILL.ordinal();
        BannerErrorCode.values();
        $SwitchMap$com$unity3d$services$banners$BannerErrorCode = BannerErrorCode.values(..);
        BannerErrorCode.NATIVE_ERROR.ordinal();
        BannerErrorCode.NO_FILL.ordinal();
        BannerErrorCode.WEBVIEW_ERROR.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.BannerView$1
// ============================================================
package com.unity3d.services.banners;

class BannerView$1 {
    final BannerView this$0;
    final BannerView val$self;

    BannerView$1(BannerView p0, BannerView p1) {
        this$0 = p0;
        val$self = p1;
        new Object();
        return;
    }

    public void run() {
        BannerView.getParent();
        if (if-eqz(BannerView.getParent(..))) goto L_13;
        if (if-eqz(v1)) goto L_13;
        BannerView.getParent(..).removeView(val$self);
      L_13:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.BannerView$2
// ============================================================
package com.unity3d.services.banners;

class BannerView$2 {
    final BannerView this$0;
    final BannerView val$self;
    final UnityBannerSize val$unityBannerSize;

    BannerView$2(BannerView p0, BannerView p1, UnityBannerSize p2) {
        this$0 = p0;
        val$self = p1;
        val$unityBannerSize = p2;
        new Object();
        return;
    }

    public void run() {
        WebPlayerSettingsCache.getInstance();
        BannerView.access$000(val$self);
        WebPlayerSettingsCache.getWebSettings(BannerView.access$000(..));
        WebPlayerSettingsCache.getInstance();
        BannerView.access$000(val$self);
        WebPlayerSettingsCache.getWebPlayerSettings(BannerView.access$000(..));
        WebPlayerSettingsCache.getInstance();
        BannerView.access$000(val$self);
        WebPlayerSettingsCache.getWebPlayerEventSettings(BannerView.access$000(..));
        BannerView.access$100(val$self);
        if (if-nez(BannerView.access$100(..))) goto L_55;
        BannerView.getContext();
        BannerView.access$000(val$self);
        new BannerWebPlayerContainer(BannerView.getContext(..), BannerView.access$000(..), WebPlayerSettingsCache.getWebSettings(..), WebPlayerSettingsCache.getWebPlayerSettings(..), WebPlayerSettingsCache.getWebPlayerEventSettings(..), val$unityBannerSize);
        BannerView.access$102(val$self, new BannerWebPlayerContainer);
        BannerView.access$100(val$self);
        BannerView.addView(BannerView.access$100(..));
      L_55:
        BannerView.access$100(val$self);
        BannerView.access$100(..).setWebPlayerSettings(WebPlayerSettingsCache.getWebSettings(..), WebPlayerSettingsCache.getWebPlayerSettings(..));
        BannerView.access$100(val$self);
        BannerView.access$100(..).setWebPlayerEventSettings(WebPlayerSettingsCache.getWebPlayerEventSettings(..));
      L_67:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.BannerView$3
// ============================================================
package com.unity3d.services.banners;

class BannerView$3 {
    final BannerView this$0;
    final BannerView val$bannerView;

    BannerView$3(BannerView p0, BannerView p1) {
        this$0 = p0;
        val$bannerView = p1;
        new Object();
        return;
    }

    public void onSdkInitializationFailed(String p0, ErrorState p1, int p2) {
        BannerView.access$200(val$bannerView);
        BannerView.getListener();
        if (if-eqz(BannerView.getListener(..))) goto L_21;
        BannerView.getListener();
        new BannerErrorInfo("UnityAds sdk initialization failed", BannerErrorCode.NATIVE_ERROR);
        BannerView.getListener(..).onBannerFailedToLoad(val$bannerView, new BannerErrorInfo(..));
      L_21:
        return;
    }

    public void onSdkInitialized() {
        BannerView.access$200(val$bannerView);
        BannerView.access$300(val$bannerView);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.BannerView$IListener
// ============================================================
package com.unity3d.services.banners;

public abstract class BannerView$IListener {
    public abstract void onBannerClick(BannerView p0) {
        // native or abstract
    }

    public abstract void onBannerFailedToLoad(BannerView p0, BannerErrorInfo p1) {
        // native or abstract
    }

    public abstract void onBannerLeftApplication(BannerView p0) {
        // native or abstract
    }

    public abstract void onBannerLoaded(BannerView p0) {
        // native or abstract
    }

    public abstract void onBannerShown(BannerView p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.BannerView$Listener
// ============================================================
package com.unity3d.services.banners;

public abstract class BannerView$Listener {
    public BannerView$Listener() {
        new Object();
        return;
    }

    public void onBannerClick(BannerView p0) {
        return;
    }

    public void onBannerFailedToLoad(BannerView p0, BannerErrorInfo p1) {
        return;
    }

    public void onBannerLeftApplication(BannerView p0) {
        return;
    }

    public void onBannerLoaded(BannerView p0) {
        return;
    }

    public void onBannerShown(BannerView p0) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.BannerViewCache$1
// ============================================================
package com.unity3d.services.banners;

class BannerViewCache$1 {
    final BannerViewCache this$0;
    final BannerView val$bannerView;
    final BannerView$IListener val$listener;

    BannerViewCache$1(BannerViewCache p0, BannerView$IListener p1, BannerView p2) {
        this$0 = p0;
        val$listener = p1;
        val$bannerView = p2;
        new Object();
        return;
    }

    public void run() {
        if (if-eqz(val$listener)) goto L_9;
        BannerView$IListener.onBannerLoaded(val$bannerView);
      L_9:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.BannerViewCache$2
// ============================================================
package com.unity3d.services.banners;

class BannerViewCache$2 {
    final BannerViewCache this$0;
    final BannerView val$bannerView;
    final BannerView$IListener val$listener;

    BannerViewCache$2(BannerViewCache p0, BannerView$IListener p1, BannerView p2) {
        this$0 = p0;
        val$listener = p1;
        val$bannerView = p2;
        new Object();
        return;
    }

    public void run() {
        if (if-eqz(val$listener)) goto L_9;
        BannerView$IListener.onBannerShown(val$bannerView);
      L_9:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.BannerViewCache$3
// ============================================================
package com.unity3d.services.banners;

class BannerViewCache$3 {
    final BannerViewCache this$0;
    final BannerView val$bannerView;
    final BannerView$IListener val$listener;

    BannerViewCache$3(BannerViewCache p0, BannerView$IListener p1, BannerView p2) {
        this$0 = p0;
        val$listener = p1;
        val$bannerView = p2;
        new Object();
        return;
    }

    public void run() {
        if (if-eqz(val$listener)) goto L_9;
        BannerView$IListener.onBannerClick(val$bannerView);
      L_9:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.BannerViewCache$4
// ============================================================
package com.unity3d.services.banners;

class BannerViewCache$4 {
    final BannerViewCache this$0;
    final BannerView val$bannerView;
    final BannerView$IListener val$listener;

    BannerViewCache$4(BannerViewCache p0, BannerView$IListener p1, BannerView p2) {
        this$0 = p0;
        val$listener = p1;
        val$bannerView = p2;
        new Object();
        return;
    }

    public void run() {
        if (if-eqz(val$listener)) goto L_9;
        BannerView$IListener.onBannerLeftApplication(val$bannerView);
      L_9:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.UnityBannerSize$Companion
// ============================================================
package com.unity3d.services.banners;

public final class UnityBannerSize$Companion {
    private UnityBannerSize$Companion() {
        new Object();
        return;
    }

    public UnityBannerSize$Companion(DefaultConstructorMarker p0) {
        new UnityBannerSize$Companion();
        return;
    }

    public final UnityBannerSize getDynamicSize(Context p0) {
        p0.getResources();
        Context.getResources(..).getDisplayMetrics();
        ViewUtilities.dpFromPx(p0, widthPixels);
        MathKt.roundToInt(ViewUtilities.dpFromPx(..));
        UnityBannerSize$Companion.getLeaderboard();
        UnityBannerSize.getWidth();
        if (if-lt(MathKt.roundToInt(..), UnityBannerSize.getWidth(..))) goto L_27;
        UnityBannerSize$Companion.getLeaderboard();
      L_27:
        UnityBannerSize$Companion.getIabStandard();
        UnityBannerSize.getWidth();
        if (if-lt(UnityBannerSize$Companion.getLeaderboard(..), UnityBannerSize.getWidth(..))) goto L_36;
        UnityBannerSize$Companion.getIabStandard();
      L_36:
        UnityBannerSize$Companion.getStandard();
      L_3a:
        return UnityBannerSize$Companion.getStandard(..);
    }

    public final UnityBannerSize getIabStandard() {
        UnityBannerSize.access$getIabStandard$cp();
        return UnityBannerSize.access$getIabStandard$cp(..);
    }

    public final UnityBannerSize getLeaderboard() {
        UnityBannerSize.access$getLeaderboard$cp();
        return UnityBannerSize.access$getLeaderboard$cp(..);
    }

    public final UnityBannerSize getStandard() {
        UnityBannerSize.access$getStandard$cp();
        return UnityBannerSize.access$getStandard$cp(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.UnityBanners$1
// ============================================================
package com.unity3d.services.banners;

class UnityBanners$1 extends BannerView$Listener {
    final UnityBanners this$0;
    final UnityBanners$BannerWrapper val$bannerWrapper;
    final UnityBanners val$self;

    UnityBanners$1(UnityBanners p0, UnityBanners p1, UnityBanners$BannerWrapper p2) {
        this$0 = p0;
        val$self = p1;
        val$bannerWrapper = p2;
        new BannerView$Listener();
        return;
    }

    public void onBannerClick(BannerView p0) {
        UnityBanners.access$000(val$self);
        if (if-eqz(UnityBanners.access$000(..))) goto L_15;
        UnityBanners.access$000(val$self);
        p0.getPlacementId();
        UnityBanners.access$000(..).onUnityBannerClick(BannerView.getPlacementId(..));
      L_15:
        return;
    }

    public void onBannerFailedToLoad(BannerView p0, BannerErrorInfo p1) {
        UnityBanners.access$000(val$self);
        if (if-eqz(UnityBanners.access$000(..))) goto L_2b;
        UnityBanners.access$000(val$self);
        new StringBuilder();
        p0.getPlacementId();
        new StringBuilder(..).append(BannerView.getPlacementId(..));
        new StringBuilder(..).append(" ");
        new StringBuilder(..).append(errorMessage);
        new StringBuilder(..).toString();
        UnityBanners.access$000(..).onUnityBannerError(StringBuilder.toString(..));
      L_2b:
        return;
    }

    public void onBannerLoaded(BannerView p0) {
        UnityBanners.access$000(val$self);
        if (if-eqz(UnityBanners.access$000(..))) goto L_17;
        UnityBanners.access$000(val$self);
        p0.getPlacementId();
        UnityBanners.access$000(..).onUnityBannerLoaded(BannerView.getPlacementId(..), val$bannerWrapper);
      L_17:
        return;
    }

    public void onBannerShown(BannerView p0) {
        UnityBanners.access$000(val$self);
        if (if-eqz(UnityBanners.access$000(..))) goto L_15;
        UnityBanners.access$000(val$self);
        p0.getPlacementId();
        UnityBanners.access$000(..).onUnityBannerShow(BannerView.getPlacementId(..));
      L_15:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.UnityBanners$2
// ============================================================
package com.unity3d.services.banners;

class UnityBanners$2 {
    final String val$message;

    UnityBanners$2(String p0) {
        val$message = p0;
        new Object();
        return;
    }

    public void run() {
        UnityBanners.getBannerListener();
        if (if-eqz(UnityBanners.getBannerListener(..))) goto L_b;
        UnityBanners.getBannerListener(..).onUnityBannerError(val$message);
      L_b:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.UnityBanners$BannerAdRefreshView
// ============================================================
package com.unity3d.services.banners;

class UnityBanners$BannerAdRefreshView extends RelativeLayout {
    private BannerView bannerView;
    private boolean didLoad;
    private boolean didShow;
    private boolean didSubscribeToLifecycle;
    private UnityBanners$BannerAdRefreshView$LifecycleListener lifecycleListener;
    private String placementId;
    private Handler refreshHandler;
    private long refreshRate;
    private long refreshTime;
    private Runnable reloadRunnable;
    final UnityBanners this$0;

    public UnityBanners$BannerAdRefreshView(UnityBanners p0, Activity p1, String p2, UnityBannerSize p3) {
        this$0 = p0;
        new RelativeLayout(p1);
        didLoad = 0;
        refreshRate = 30L;
        didShow = 0;
        didSubscribeToLifecycle = 0;
        placementId = p2;
        new Handler();
        refreshHandler = new Handler(..);
        new UnityBanners$BannerAdRefreshView$1(new RelativeLayout(..), p0, new RelativeLayout(..));
        reloadRunnable = new UnityBanners$BannerAdRefreshView$1(..);
        new RelativeLayout(..).setupLayoutParams();
        new RelativeLayout(..).setBackgroundColor(0);
        new BannerView(p1, p2, p3);
        bannerView = new BannerView(..);
        new RelativeLayout(..).addView(new BannerView(..));
        return;
    }

    static void access$100(UnityBanners$BannerAdRefreshView p0) {
        p0.reload();
        return;
    }

    static void access$300(UnityBanners$BannerAdRefreshView p0) {
        p0.stopReloadTask();
        return;
    }

    static void access$400(UnityBanners$BannerAdRefreshView p0) {
        p0.startReloadTask();
        return;
    }

    private void reload() {
        new UnityAdsLoadOptions();
        UUID.randomUUID();
        UUID.randomUUID(..).toString();
        new UnityAdsLoadOptions(..).setObjectId(UUID.toString(..));
        bannerView.load(new UnityAdsLoadOptions(..));
        SystemClock.uptimeMillis();
        TimeUnit.SECONDS.toMillis(refreshRate, v4);
        refreshTime = SystemClock.uptimeMillis(..);
        refreshHandler.postAtTime(reloadRunnable, SystemClock.uptimeMillis(..), bannerView);
        return;
    }

    private void setupLayoutParams() {
        new RelativeLayout$LayoutParams(-2, -2);
        UnityBanners$BannerAdRefreshView.setLayoutParams(new RelativeLayout$LayoutParams(..));
        return;
    }

    private void startReloadTask() {
        SystemClock.uptimeMillis();
        if (if-gez(SystemClock.uptimeMillis(..))) goto L_12;
        refreshHandler.postAtTime(reloadRunnable, refreshTime, v3);
      L_12:
        UnityBanners$BannerAdRefreshView.reload();
      L_15:
        return;
    }

    private void stopReloadTask() {
        if (if-eqz(refreshHandler)) goto L_b;
        if (if-eqz(reloadRunnable)) goto L_b;
        refreshHandler.removeCallbacks(reloadRunnable);
      L_b:
        return;
    }

    private void subscribeToLifecycle() {
        if (if-nez(didSubscribeToLifecycle)) goto L_1d;
        ClientProperties.getApplication();
        if (if-eqz(ClientProperties.getApplication(..))) goto L_1d;
        new UnityBanners$BannerAdRefreshView$3(this, this);
        lifecycleListener = new UnityBanners$BannerAdRefreshView$3(..);
        didSubscribeToLifecycle = 1;
        ClientProperties.getApplication();
        ClientProperties.getApplication(..).registerActivityLifecycleCallbacks(lifecycleListener);
      L_1d:
        return;
    }

    private void unsubscribeFromLifecycle() {
        if (if-eqz(didSubscribeToLifecycle)) goto L_1a;
        if (if-eqz(lifecycleListener)) goto L_1a;
        ClientProperties.getApplication();
        if (if-eqz(ClientProperties.getApplication(..))) goto L_1a;
        didSubscribeToLifecycle = 0;
        ClientProperties.getApplication();
        ClientProperties.getApplication(..).unregisterActivityLifecycleCallbacks(lifecycleListener);
      L_1a:
        return;
    }

    public void destroy() {
        UnityBanners$BannerAdRefreshView.stopReloadTask();
        bannerView.destroy();
        new UnityBanners$BannerAdRefreshView$2(this, this);
        Utilities.runOnUiThread(new UnityBanners$BannerAdRefreshView$2(..));
        bannerView = 0;
        return;
    }

    public BannerView$IListener getListener() {
        bannerView.getListener();
        return BannerView.getListener(..);
    }

    public String getPlacementId() {
        bannerView.getPlacementId();
        return BannerView.getPlacementId(..);
    }

    public UnityBannerSize getSize() {
        bannerView.getSize();
        return BannerView.getSize(..);
    }

    public void load() {
        if (if-nez(didLoad)) goto L_1c;
        didLoad = 1;
        BannerRefreshInfo.getInstance();
        BannerRefreshInfo.getInstance(..).getRefreshRate(placementId);
        if (if-eqz(BannerRefreshInfo.getRefreshRate(..))) goto L_19;
        BannerRefreshInfo.getRefreshRate(..).longValue();
        refreshRate = Integer.longValue(..);
      L_19:
        UnityBanners$BannerAdRefreshView.reload();
      L_1c:
        return;
    }

    protected void onAttachedToWindow() {
        RelativeLayout.onAttachedToWindow();
        UnityBanners$BannerAdRefreshView.subscribeToLifecycle();
        if (if-eqz(didShow)) goto L_e;
        UnityBanners$BannerAdRefreshView.startReloadTask();
      L_e:
        didShow = 1;
      L_11:
        return;
    }

    protected void onDetachedFromWindow() {
        RelativeLayout.onDetachedFromWindow();
        UnityBanners$BannerAdRefreshView.stopReloadTask();
        UnityBanners$BannerAdRefreshView.unsubscribeFromLifecycle();
        return;
    }

    public void setListener(BannerView$IListener p0) {
        bannerView.setListener(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.UnityBanners$BannerAdRefreshView$1
// ============================================================
package com.unity3d.services.banners;

class UnityBanners$BannerAdRefreshView$1 {
    final UnityBanners$BannerAdRefreshView this$1;
    final UnityBanners$BannerAdRefreshView val$self;
    final UnityBanners val$this$0;

    UnityBanners$BannerAdRefreshView$1(UnityBanners$BannerAdRefreshView p0, UnityBanners p1, UnityBanners$BannerAdRefreshView p2) {
        this$1 = p0;
        val$this$0 = p1;
        val$self = p2;
        new Object();
        return;
    }

    public void run() {
        UnityBanners$BannerAdRefreshView.access$100(val$self);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.UnityBanners$BannerAdRefreshView$2
// ============================================================
package com.unity3d.services.banners;

class UnityBanners$BannerAdRefreshView$2 {
    final UnityBanners$BannerAdRefreshView this$1;
    final UnityBanners$BannerAdRefreshView val$self;

    UnityBanners$BannerAdRefreshView$2(UnityBanners$BannerAdRefreshView p0, UnityBanners$BannerAdRefreshView p1) {
        this$1 = p0;
        val$self = p1;
        new Object();
        return;
    }

    public void run() {
        UnityBanners$BannerAdRefreshView.removeAllViews();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.UnityBanners$BannerAdRefreshView$3
// ============================================================
package com.unity3d.services.banners;

class UnityBanners$BannerAdRefreshView$3 extends UnityBanners$BannerAdRefreshView$LifecycleListener {
    final UnityBanners$BannerAdRefreshView this$1;
    final UnityBanners$BannerAdRefreshView val$self;

    UnityBanners$BannerAdRefreshView$3(UnityBanners$BannerAdRefreshView p0, UnityBanners$BannerAdRefreshView p1) {
        this$1 = p0;
        val$self = p1;
        new UnityBanners$BannerAdRefreshView$LifecycleListener(p0, 0);
        return;
    }

    public void onActivityDestroyed(Activity p0) {
        UnityBanners$BannerAdRefreshView.access$300(val$self);
        return;
    }

    public void onActivityPaused(Activity p0) {
        UnityBanners$BannerAdRefreshView.access$300(val$self);
        return;
    }

    public void onActivityResumed(Activity p0) {
        UnityBanners$BannerAdRefreshView.access$400(val$self);
        return;
    }

    public void onActivityStopped(Activity p0) {
        UnityBanners$BannerAdRefreshView.access$300(val$self);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.UnityBanners$BannerAdRefreshView$LifecycleListener
// ============================================================
package com.unity3d.services.banners;

class UnityBanners$BannerAdRefreshView$LifecycleListener {
    final UnityBanners$BannerAdRefreshView this$1;

    private UnityBanners$BannerAdRefreshView$LifecycleListener(UnityBanners$BannerAdRefreshView p0) {
        this$1 = p0;
        new Object();
        return;
    }

    UnityBanners$BannerAdRefreshView$LifecycleListener(UnityBanners$BannerAdRefreshView p0, UnityBanners$1 p1) {
        new UnityBanners$BannerAdRefreshView$LifecycleListener(p0);
        return;
    }

    public void onActivityCreated(Activity p0, Bundle p1) {
        return;
    }

    public void onActivityDestroyed(Activity p0) {
        return;
    }

    public void onActivityPaused(Activity p0) {
        return;
    }

    public void onActivityResumed(Activity p0) {
        return;
    }

    public void onActivitySaveInstanceState(Activity p0, Bundle p1) {
        return;
    }

    public void onActivityStarted(Activity p0) {
        return;
    }

    public void onActivityStopped(Activity p0) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.UnityBanners$BannerWrapper
// ============================================================
package com.unity3d.services.banners;

class UnityBanners$BannerWrapper extends FrameLayout {
    private UnityBanners$BannerAdRefreshView _bannerAdRefreshView;
    private BannerPosition _bannerPosition;
    final UnityBanners this$0;

    public UnityBanners$BannerWrapper(UnityBanners p0, Context p1, UnityBanners$BannerAdRefreshView p2) {
        this$0 = p0;
        new FrameLayout(p1);
        _bannerPosition = BannerPosition.NONE;
        _bannerAdRefreshView = p2;
        new FrameLayout(..).addView(p2);
        new FrameLayout(..).setupLayoutConstraints();
        new FrameLayout(..).setBackgroundColor(0);
        return;
    }

    private void setupLayoutConstraints() {
        new FrameLayout$LayoutParams(-2, -2);
        _bannerPosition.getGravity();
        gravity = BannerPosition.getGravity(..);
        UnityBanners$BannerWrapper.setLayoutParams(new FrameLayout$LayoutParams(..));
        return;
    }

    public void destroy() {
        new UnityBanners$BannerWrapper$1(this, this);
        Utilities.runOnUiThread(new UnityBanners$BannerWrapper$1(..));
        if (if-eqz(_bannerAdRefreshView)) goto L_12;
        _bannerAdRefreshView.destroy();
        _bannerAdRefreshView = 0;
      L_12:
        return;
    }

    public void setBannerPosition(BannerPosition p0) {
        _bannerPosition = p0;
        UnityBanners$BannerWrapper.setupLayoutConstraints();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.UnityBanners$BannerWrapper$1
// ============================================================
package com.unity3d.services.banners;

class UnityBanners$BannerWrapper$1 {
    final UnityBanners$BannerWrapper this$1;
    final UnityBanners$BannerWrapper val$bannerWrapper;

    UnityBanners$BannerWrapper$1(UnityBanners$BannerWrapper p0, UnityBanners$BannerWrapper p1) {
        this$1 = p0;
        val$bannerWrapper = p1;
        new Object();
        return;
    }

    public void run() {
        UnityBanners$BannerWrapper.removeAllViews();
        ViewUtilities.removeViewFromParent(val$bannerWrapper);
        return;
    }

}

