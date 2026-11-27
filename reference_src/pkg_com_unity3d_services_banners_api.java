// Package bundle: com.unity3d.services.banners.api (4 classes)

// ============================================================
// CLASS: com.unity3d.services.banners.api.Banner
// ============================================================
package com.unity3d.services.banners.api;

public class Banner {
    public Banner() {
        new Object();
        return;
    }

    private static LoadBannerOperationState getBannerOperationState(String p0) {
        LoadBannerModule.getInstance();
        LoadBannerModule.getInstance(..).get(p0);
        if (if-eqz(ILoadModule.get(..))) goto L_2b;
        ILoadModule.get(..).getLoadOperationState();
        if (if-nez(ILoadOperation.getLoadOperationState(..))) goto L_14;
      L_14:
        ILoadModule.get(..).getLoadOperationState();
        if (if-eqz(ILoadOperation.getLoadOperationState(..))) goto L_1f;
        return ILoadOperation.getLoadOperationState(..);
      L_1f:
        LoadBannerModule.getInstance();
        LoadBannerModule.getInstance(..).onUnityAdsFailedToLoad(p0, UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "Operation state found is not for banner ad");
        return 0;
      L_2b:
        LoadBannerModule.getInstance();
        LoadBannerModule.getInstance(..).onUnityAdsFailedToLoad(p0, UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "No operation found for requested banner");
        return 0;
    }

    public static void load(String p0, Integer p1, Integer p2, String p3, WebViewCallback p4) {
        Banner$BannerViewType.fromString(p0);
        Banner$BannerViewType.fromString(..).ordinal();
        if (if-eq(Banner$BannerViewType.ordinal(..), 1)) goto L_1f;
        if (if-eq(Banner$BannerViewType.ordinal(..), 2)) goto L_13;
      L_13:
        LoadBannerModule.getInstance();
        LoadBannerModule.getInstance(..).onUnityAdsFailedToLoad(p3, UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "Unknown banner type");
      L_1f:
        Banner.getBannerOperationState(p3);
        if (if-nez(Banner.getBannerOperationState(..))) goto L_26;
      L_26:
        Integer.intValue();
        "Unknown banner type".intValue();
        new UnityBannerSize(Integer.intValue(..), Integer.intValue(..));
        Banner.getBannerOperationState(..).setSize(new UnityBannerSize(..));
        BannerViewCache.getInstance();
        BannerViewCache.getInstance(..).loadBanner(Banner.getBannerOperationState(..));
      L_3d:
        p4.invoke(0);
        return;
    }

    public static void loadScar(String p0, String p1, String p2, String p3, String p4, Integer p5, Integer p6, WebViewCallback p7) {
        Banner.getBannerOperationState(p0);
        if (if-nez(Banner.getBannerOperationState(..))) goto L_d;
        p7.invoke(Banner.getBannerOperationState(..));
        return;
      L_d:
        p5.intValue();
        p6.intValue();
        new UnityBannerSize(Integer.intValue(..), Integer.intValue(..));
        Banner.getBannerOperationState(..).setSize(new UnityBannerSize(..));
        Integer.valueOf(0);
        new ScarAdMetadata(p1, p2, p3, p4, Integer.valueOf(..));
        Banner.getBannerOperationState(..).setScarAdMetadata(new ScarAdMetadata);
        BannerViewCache.getInstance();
        BannerViewCache.getInstance(..).loadBanner(Banner.getBannerOperationState(..));
        p7.invoke(Banner.getBannerOperationState(..));
        return;
    }

    public static void setRefreshRate(String p0, Integer p1, WebViewCallback p2) {
        if (if-eqz(p0)) goto L_b;
        if (if-eqz(p1)) goto L_b;
        BannerRefreshInfo.getInstance();
        BannerRefreshInfo.getInstance(..).setRefreshRate(p0, p1);
      L_b:
        p2.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.api.BannerListener
// ============================================================
package com.unity3d.services.banners.api;

public class BannerListener {
    public BannerListener() {
        new Object();
        return;
    }

    public static void sendClickEvent(String p0, WebViewCallback p1) {
        BannerViewCache.getInstance();
        BannerViewCache.getInstance(..).triggerBannerClickEvent(p0);
        p1.invoke(0);
        return;
    }

    public static void sendErrorEvent(String p0, Integer p1, String p2, WebViewCallback p3) {
        BannerErrorCode.values();
        p1.intValue();
        new BannerErrorInfo(p2, Integer.intValue(..));
        BannerViewCache.getInstance();
        BannerViewCache.getInstance(..).triggerBannerErrorEvent(p0, new BannerErrorInfo(..));
        p3.invoke(0);
        return;
    }

    public static void sendLeaveApplicationEvent(String p0, WebViewCallback p1) {
        BannerViewCache.getInstance();
        BannerViewCache.getInstance(..).triggerBannerLeftApplicationEvent(p0);
        p1.invoke(0);
        return;
    }

    public static void sendLoadEvent(String p0, WebViewCallback p1) {
        BannerViewCache.getInstance();
        BannerViewCache.getInstance(..).triggerBannerLoadEvent(p0);
        p1.invoke(0);
        return;
    }

    public static void sendShowEvent(String p0, WebViewCallback p1) {
        BannerViewCache.getInstance();
        BannerViewCache.getInstance(..).triggerBannerShowEvent(p0);
        p1.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.api.Banner$1
// ============================================================
package com.unity3d.services.banners.api;

class Banner$1 {
    static final int[] $SwitchMap$com$unity3d$services$banners$api$Banner$BannerViewType;

    static <clinit>() {
        Banner$BannerViewType.values();
        $SwitchMap$com$unity3d$services$banners$api$Banner$BannerViewType = Banner$BannerViewType.values(..);
        Banner$BannerViewType.WEB_PLAYER.ordinal();
        Banner$BannerViewType.UNKNOWN.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.api.Banner$BannerViewType
// ============================================================
package com.unity3d.services.banners.api;

final class Banner$BannerViewType extends Enum {
    private static final Banner$BannerViewType[] $VALUES;
    public static final Banner$BannerViewType UNKNOWN;
    public static final Banner$BannerViewType WEB_PLAYER;

    private static Banner$BannerViewType[] $values() {
        return 2;
    }

    static <clinit>() {
        new Banner$BannerViewType("WEB_PLAYER", 0);
        WEB_PLAYER = new Banner$BannerViewType(..);
        new Banner$BannerViewType("UNKNOWN", 1);
        UNKNOWN = new Banner$BannerViewType(..);
        Banner$BannerViewType.$values();
        $VALUES = Banner$BannerViewType.$values(..);
        return;
    }

    private Banner$BannerViewType(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static Banner$BannerViewType fromString(String p0) {
        Banner$BannerViewType.valueOf(p0);
        return Banner$BannerViewType.valueOf(..);
        return Banner$BannerViewType.UNKNOWN;
    }

    public static Banner$BannerViewType valueOf(String p0) {
        Enum.valueOf(Banner$BannerViewType.class, p0);
        return Enum.valueOf(..);
    }

    public static Banner$BannerViewType[] values() {
        Banner$BannerViewType.$VALUES.clone();
        return Banner$BannerViewType[].clone(..);
    }

}

