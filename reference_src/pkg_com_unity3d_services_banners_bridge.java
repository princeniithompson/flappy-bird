// Package bundle: com.unity3d.services.banners.bridge (5 classes)

// ============================================================
// CLASS: com.unity3d.services.banners.bridge.BannerBridge
// ============================================================
package com.unity3d.services.banners.bridge;

public class BannerBridge {
    public BannerBridge() {
        new Object();
        return;
    }

    public static void destroy(String p0) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_13;
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.BANNER_DESTROY_BANNER, 1);
      L_13:
        return;
    }

    public static void didAttach(String p0) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_13;
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.BANNER_ATTACHED, 1);
      L_13:
        return;
    }

    public static void didAttachScarBanner(String p0) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_13;
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.SCAR_BANNER_ATTACHED, 1);
      L_13:
        return;
    }

    public static void didDestroy(String p0) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_13;
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.BANNER_DESTROYED, 1);
      L_13:
        return;
    }

    public static void didDetach(String p0) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_13;
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.BANNER_DETACHED, 1);
      L_13:
        return;
    }

    public static void didDetachScarBanner(String p0) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_13;
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.SCAR_BANNER_DETACHED, 1);
      L_13:
        return;
    }

    public static void didLoad(String p0) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_13;
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.BANNER_LOADED, 1);
      L_13:
        return;
    }

    private static boolean isHeaderBidding(JSONObject p0) {
        if (if-nez(p0)) goto L_4;
        return 0;
      L_4:
        0.has("adMarkup");
        return JSONObject.has(..);
    }

    public static void load(String p0, String p1, UnityBannerSize p2) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_2d;
        p2.getWidth();
        Integer.valueOf(UnityBannerSize.getWidth(..));
        p2.getHeight();
        Integer.valueOf(UnityBannerSize.getHeight(..));
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.BANNER_LOAD_PLACEMENT, 4);
      L_2d:
        BannerViewCache.getInstance();
        BannerViewCache.getInstance(..).getBannerView(3);
        if (if-eqz(BannerViewCache.getBannerView(..))) goto L_4d;
        BannerViewCache.getBannerView(..).getListener();
        if (if-eqz(BannerView.getListener(..))) goto L_4d;
        BannerViewCache.getBannerView(..).getListener();
        new BannerErrorInfo("WebViewApp was not available, this is likely because UnityAds has not been initialized", BannerErrorCode.WEBVIEW_ERROR);
        BannerView.getListener(..).onBannerFailedToLoad(BannerViewCache.getBannerView(..), new BannerErrorInfo(..));
      L_4d:
        return;
    }

    public static void load(String p0, String p1, UnityBannerSize p2, UnityAdsLoadOptions p3) {
        Utilities.getService(SDKMetricsSender.class);
        p3.getData();
        BannerBridge.isHeaderBidding(UnityAdsLoadOptions.getData(..));
        new BannerBridge$1(BannerBridge.isHeaderBidding(..));
        BannerViewCache.getInstance();
        BannerViewCache.getInstance(..).getBannerView(p1);
        if (if-nez(BannerViewCache.getBannerView(..))) goto L_2f;
        new Metric("native_banner_load_not_found", 0, new BannerBridge$1(..));
        Utilities.getService(..).sendMetricWithInitState(new Metric(..));
        return;
      L_2f:
        Utilities.getService(AlternativeFlowReader.class);
        Utilities.getService(..).invoke();
        p3.getObjectId();
        if (if-eqz(UnityAdsLoadOptions.getObjectId(..))) goto L_43;
      L_43:
      L_44:
        if (if-eqz(AlternativeFlowReader.invoke(..))) goto L_4b;
        if (if-nez(0)) goto L_4b;
        p3.setObjectId(p1);
      L_4b:
        BannerViewCache.getBannerView(..).getListener();
        new BannerBridge$2(BannerView.getListener(..), Utilities.getService(..), new BannerBridge$1(..), AlternativeFlowReader.invoke(..), BannerViewCache.getBannerView(..), p3, p1);
        if (if-eqz(AlternativeFlowReader.invoke(..))) goto L_63;
        UnityAdsSDK.INSTANCE.load(p0, p3, new BannerBridge$2, p2);
        return;
      L_63:
        LoadBannerModule.getInstance();
        new WebViewBridgeInvoker();
        new ConfigurationReader();
        new ConfigurationReader(..).getCurrentConfiguration();
        new LoadBannerOperationState(p0, p1, p2, new BannerBridge$2, p3, ConfigurationReader.getCurrentConfiguration(..));
        LoadBannerModule.getInstance(..).executeAdOperation(new WebViewBridgeInvoker(..), new LoadBannerOperationState);
        return;
    }

    public static void resize(String p0, int p1, int p2, int p3, int p4, float p5) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_36;
        Integer.valueOf(p1);
        Integer.valueOf(p2);
        Integer.valueOf(p3);
        Integer.valueOf(p4);
        Float.valueOf(p5);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.BANNER_RESIZED, 6);
      L_36:
        return;
    }

    public static void visibilityChanged(String p0, int p1) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_1a;
        Integer.valueOf(p1);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BANNER, BannerBridge$BannerEvent.BANNER_VISIBILITY_CHANGED, 2);
      L_1a:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.bridge.BannerBridge$1
// ============================================================
package com.unity3d.services.banners.bridge;

class BannerBridge$1 extends HashMap {
    final boolean val$isHB;

    BannerBridge$1(boolean p0) {
        val$isHB = p0;
        new HashMap();
        String.valueOf(p0);
        new HashMap(..).put("is_header_bidding", String.valueOf(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.bridge.BannerBridge$2
// ============================================================
package com.unity3d.services.banners.bridge;

class BannerBridge$2 {
    final String val$bannerAdId;
    final BannerView val$bannerAdView;
    final BannerView$IListener val$bannerListener;
    final boolean val$isAlternativeFlow;
    final UnityAdsLoadOptions val$loadOptions;
    final SDKMetricsSender val$sdkMetricsSender;
    final Map val$tags;

    BannerBridge$2(BannerView$IListener p0, SDKMetricsSender p1, Map p2, boolean p3, BannerView p4, UnityAdsLoadOptions p5, String p6) {
        val$bannerListener = p0;
        val$sdkMetricsSender = p1;
        val$tags = p2;
        val$isAlternativeFlow = p3;
        val$bannerAdView = p4;
        val$loadOptions = p5;
        val$bannerAdId = p6;
        new Object();
        return;
    }

    public void onUnityAdsAdLoaded(String p0) {
        if (if-nez(val$bannerListener)) goto L_13;
        new Metric("native_banner_listener_loaded_not_found", 0, val$tags);
        SDKMetricsSender.sendMetricWithInitState(new Metric(..));
      L_13:
        if (if-eqz(val$isAlternativeFlow)) goto L_38;
        if (if-eqz(val$bannerListener)) goto L_20;
        BannerView$IListener.onBannerLoaded(val$bannerAdView);
      L_20:
        new UnityAdsShowOptions();
        UnityAdsLoadOptions.getObjectId();
        new UnityAdsShowOptions(..).setObjectId(UnityAdsLoadOptions.getObjectId(..));
        new BannerBridge$2$1(this);
        UnityAdsSDK.INSTANCE.show(p0, new UnityAdsShowOptions(..), new BannerBridge$2$1(..));
      L_38:
        return;
    }

    public void onUnityAdsFailedToLoad(String p0, UnityAds$UnityAdsLoadError p1, String p2) {
        BannerViewCache.getInstance();
        BannerViewCache.getInstance(..).getBannerView(val$bannerAdId);
        if (if-eqz(BannerViewCache.getBannerView(..))) goto L_1f;
        BannerViewCache.getBannerView(..).getListener();
        if (if-nez(BannerView.getListener(..))) goto L_13;
      L_13:
        BannerErrorInfo.fromLoadError(p1, p2);
        BannerViewCache.getBannerView(..).getListener();
        BannerView.getListener(..).onBannerFailedToLoad(BannerViewCache.getBannerView(..), BannerErrorInfo.fromLoadError(..));
        return;
      L_1f:
        new Metric("native_banner_listener_load_fail_not_found", 0, val$tags);
        SDKMetricsSender.sendMetricWithInitState(new Metric(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.bridge.BannerBridge$2$1
// ============================================================
package com.unity3d.services.banners.bridge;

class BannerBridge$2$1 {
    final BannerBridge$2 this$0;

    BannerBridge$2$1(BannerBridge$2 p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void onClick(String p0) {
        if (if-eqz(val$bannerListener)) goto L_11;
        BannerView$IListener.onBannerClick(val$bannerAdView);
      L_11:
        return;
    }

    public void onComplete(String p0, UnityAds$UnityAdsShowCompletionState p1) {
        return;
    }

    public void onError(String p0, UnityAds$UnityAdsShowError p1, String p2) {
        return;
    }

    public void onLeftApplication(String p0) {
        if (if-eqz(val$bannerListener)) goto L_11;
        BannerView$IListener.onBannerLeftApplication(val$bannerAdView);
      L_11:
        return;
    }

    public void onStart(String p0) {
        if (if-eqz(val$bannerListener)) goto L_11;
        BannerView$IListener.onBannerShown(val$bannerAdView);
      L_11:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.bridge.BannerBridge$BannerEvent
// ============================================================
package com.unity3d.services.banners.bridge;

public final class BannerBridge$BannerEvent extends Enum {
    private static final BannerBridge$BannerEvent[] $VALUES;
    public static final BannerBridge$BannerEvent BANNER_ATTACHED;
    public static final BannerBridge$BannerEvent BANNER_DESTROYED;
    public static final BannerBridge$BannerEvent BANNER_DESTROY_BANNER;
    public static final BannerBridge$BannerEvent BANNER_DETACHED;
    public static final BannerBridge$BannerEvent BANNER_LOADED;
    public static final BannerBridge$BannerEvent BANNER_LOAD_PLACEMENT;
    public static final BannerBridge$BannerEvent BANNER_RESIZED;
    public static final BannerBridge$BannerEvent BANNER_VISIBILITY_CHANGED;
    public static final BannerBridge$BannerEvent SCAR_BANNER_ATTACHED;
    public static final BannerBridge$BannerEvent SCAR_BANNER_CLICKED;
    public static final BannerBridge$BannerEvent SCAR_BANNER_CLOSED;
    public static final BannerBridge$BannerEvent SCAR_BANNER_DETACHED;
    public static final BannerBridge$BannerEvent SCAR_BANNER_IMPRESSION;
    public static final BannerBridge$BannerEvent SCAR_BANNER_LOADED;
    public static final BannerBridge$BannerEvent SCAR_BANNER_LOAD_FAILED;
    public static final BannerBridge$BannerEvent SCAR_BANNER_OPENED;

    private static BannerBridge$BannerEvent[] $values() {
        return 16;
    }

    static <clinit>() {
        new BannerBridge$BannerEvent("BANNER_VISIBILITY_CHANGED", 0);
        BANNER_VISIBILITY_CHANGED = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("BANNER_RESIZED", 1);
        BANNER_RESIZED = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("BANNER_LOADED", 2);
        BANNER_LOADED = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("BANNER_DESTROYED", 3);
        BANNER_DESTROYED = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("BANNER_ATTACHED", 4);
        BANNER_ATTACHED = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("BANNER_DETACHED", 5);
        BANNER_DETACHED = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("BANNER_LOAD_PLACEMENT", 6);
        BANNER_LOAD_PLACEMENT = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("BANNER_DESTROY_BANNER", 7);
        BANNER_DESTROY_BANNER = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("SCAR_BANNER_LOADED", 8);
        SCAR_BANNER_LOADED = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("SCAR_BANNER_LOAD_FAILED", 9);
        SCAR_BANNER_LOAD_FAILED = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("SCAR_BANNER_ATTACHED", 10);
        SCAR_BANNER_ATTACHED = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("SCAR_BANNER_DETACHED", 11);
        SCAR_BANNER_DETACHED = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("SCAR_BANNER_OPENED", 12);
        SCAR_BANNER_OPENED = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("SCAR_BANNER_CLOSED", 13);
        SCAR_BANNER_CLOSED = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("SCAR_BANNER_IMPRESSION", 14);
        SCAR_BANNER_IMPRESSION = new BannerBridge$BannerEvent(..);
        new BannerBridge$BannerEvent("SCAR_BANNER_CLICKED", 15);
        SCAR_BANNER_CLICKED = new BannerBridge$BannerEvent(..);
        BannerBridge$BannerEvent.$values();
        $VALUES = BannerBridge$BannerEvent.$values(..);
        return;
    }

    private BannerBridge$BannerEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static BannerBridge$BannerEvent valueOf(String p0) {
        Enum.valueOf(BannerBridge$BannerEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static BannerBridge$BannerEvent[] values() {
        BannerBridge$BannerEvent.$VALUES.clone();
        return BannerBridge$BannerEvent[].clone(..);
    }

}

