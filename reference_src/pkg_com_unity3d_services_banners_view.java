// Package bundle: com.unity3d.services.banners.view (6 classes)

// ============================================================
// CLASS: com.unity3d.services.banners.view.BannerPosition
// ============================================================
package com.unity3d.services.banners.view;

public final class BannerPosition extends Enum {
    private static final BannerPosition[] $VALUES;
    public static final BannerPosition BOTTOM_CENTER;
    public static final BannerPosition BOTTOM_LEFT;
    public static final BannerPosition BOTTOM_RIGHT;
    public static final BannerPosition CENTER;
    public static final BannerPosition NONE;
    public static final BannerPosition TOP_CENTER;
    public static final BannerPosition TOP_LEFT;
    public static final BannerPosition TOP_RIGHT;
    private int _gravity;
    private final int[] _rules;

    private static BannerPosition[] $values() {
        return 8;
    }

    static <clinit>() {
        new BannerPosition("TOP_LEFT", 0, v2, 51);
        TOP_LEFT = new BannerPosition(..);
        new BannerPosition("TOP_CENTER", 1, v2, 49);
        TOP_CENTER = new BannerPosition(..);
        new BannerPosition("TOP_RIGHT", 2, v2, 53);
        TOP_RIGHT = new BannerPosition(..);
        new BannerPosition("BOTTOM_LEFT", 3, v2, 83);
        BOTTOM_LEFT = new BannerPosition(..);
        new BannerPosition("BOTTOM_CENTER", 4, v2, 81);
        BOTTOM_CENTER = new BannerPosition(..);
        new BannerPosition("BOTTOM_RIGHT", 5, 2, 85);
        BOTTOM_RIGHT = new BannerPosition(..);
        new BannerPosition("CENTER", 6, 2, 17);
        CENTER = new BannerPosition(..);
        new BannerPosition("NONE", 7, 17, 0);
        NONE = new BannerPosition(..);
        BannerPosition.$values();
        $VALUES = BannerPosition.$values(..);
        return;
    }

    private BannerPosition(String p0, int p1, int[] p2, int p3) {
        new Enum(p0, p1);
        _rules = p2;
        _gravity = p3;
        return;
    }

    public static BannerPosition fromString(String p0) {
        if (if-eqz(p0)) goto L_5b;
        p0.equals("none");
        if (if-eqz(String.equals(..))) goto L_b;
      L_b:
        p0.equals("topleft");
        if (if-eqz(String.equals(..))) goto L_16;
        return BannerPosition.TOP_LEFT;
      L_16:
        BannerPosition.TOP_LEFT.equals("topright");
        if (if-eqz(String.equals(..))) goto L_21;
        return BannerPosition.TOP_RIGHT;
      L_21:
        BannerPosition.TOP_RIGHT.equals("topcenter");
        if (if-eqz(String.equals(..))) goto L_2c;
        return BannerPosition.TOP_CENTER;
      L_2c:
        BannerPosition.TOP_CENTER.equals("bottomleft");
        if (if-eqz(String.equals(..))) goto L_37;
        return BannerPosition.BOTTOM_LEFT;
      L_37:
        BannerPosition.BOTTOM_LEFT.equals("bottomright");
        if (if-eqz(String.equals(..))) goto L_42;
        return BannerPosition.BOTTOM_RIGHT;
      L_42:
        BannerPosition.BOTTOM_RIGHT.equals("bottomcenter");
        if (if-eqz(String.equals(..))) goto L_4d;
        return BannerPosition.BOTTOM_CENTER;
      L_4d:
        BannerPosition.BOTTOM_CENTER.equals("center");
        if (if-eqz(String.equals(..))) goto L_58;
        return BannerPosition.CENTER;
      L_58:
        return BannerPosition.NONE;
      L_5b:
        return BannerPosition.NONE;
    }

    public static BannerPosition valueOf(String p0) {
        Enum.valueOf(BannerPosition.class, p0);
        return Enum.valueOf(..);
    }

    public static BannerPosition[] values() {
        BannerPosition.$VALUES.clone();
        return BannerPosition[].clone(..);
    }

    public ViewGroup$LayoutParams addLayoutRules(RelativeLayout$LayoutParams p0) {
      L_4:
        if (if-ge(0, v1)) goto L_e;
        p0.addRule(v3);
      L_e:
        return p0;
    }

    public int getGravity() {
        return _gravity;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.view.BannerWebPlayerContainer
// ============================================================
package com.unity3d.services.banners.view;

public class BannerWebPlayerContainer extends RelativeLayout {
    private String _bannerAdId;
    private int _lastVisibility;
    private UnityBannerSize _size;
    private Runnable _unsubscribeLayoutChange;
    private JSONObject _webPlayerEventSettings;
    private JSONObject _webPlayerSettings;
    private WebPlayerView _webPlayerView;
    private JSONObject _webSettings;

    public BannerWebPlayerContainer(Context p0, String p1, JSONObject p2, JSONObject p3, JSONObject p4, UnityBannerSize p5) {
        new RelativeLayout(p0);
        _lastVisibility = -1;
        _unsubscribeLayoutChange = 0;
        _size = p5;
        _bannerAdId = p1;
        _webSettings = p2;
        _webPlayerSettings = p3;
        _webPlayerEventSettings = p4;
        new WebPlayerView(p0, p1, _webSettings, _webPlayerSettings);
        _webPlayerView = new WebPlayerView(..);
        new WebPlayerView(..).setEventSettings(_webPlayerEventSettings);
        new RelativeLayout(..).subscribeOnLayoutChange();
        new RelativeLayout(..).addView(_webPlayerView);
        new RelativeLayout(..).setupLayoutParams();
        return;
    }

    static WebPlayerView access$000(BannerWebPlayerContainer p0) {
        return _webPlayerView;
    }

    static WebPlayerView access$002(BannerWebPlayerContainer p0, WebPlayerView p1) {
        _webPlayerView = p1;
        return p1;
    }

    private void setupLayoutParams() {
        BannerWebPlayerContainer.getContext();
        _size.getWidth();
        ViewUtilities.pxFromDp(BannerWebPlayerContainer.getContext(..), UnityBannerSize.getWidth(..));
        Math.round(ViewUtilities.pxFromDp(..));
        BannerWebPlayerContainer.getContext();
        _size.getHeight();
        ViewUtilities.pxFromDp(BannerWebPlayerContainer.getContext(..), UnityBannerSize.getHeight(..));
        Math.round(ViewUtilities.pxFromDp(..));
        new RelativeLayout$LayoutParams(Math.round(..), Math.round(..));
        BannerWebPlayerContainer.setLayoutParams(new RelativeLayout$LayoutParams(..));
        _webPlayerView.getLayoutParams();
        height = -1;
        width = -1;
        _webPlayerView.setLayoutParams(WebPlayerView.getLayoutParams(..));
        return;
    }

    private void subscribeOnLayoutChange() {
        if (if-eqz(_unsubscribeLayoutChange)) goto L_7;
        _unsubscribeLayoutChange.run();
      L_7:
        new BannerWebPlayerContainer$1(this);
        BannerWebPlayerContainer.addOnLayoutChangeListener(new BannerWebPlayerContainer$1(..));
        new BannerWebPlayerContainer$2(this, new BannerWebPlayerContainer$1(..));
        _unsubscribeLayoutChange = new BannerWebPlayerContainer$2(..);
        return;
    }

    public void destroy() {
        if (if-eqz(_unsubscribeLayoutChange)) goto L_7;
        _unsubscribeLayoutChange.run();
      L_7:
        new BannerWebPlayerContainer$3(this, this);
        Utilities.runOnUiThread(new BannerWebPlayerContainer$3(..));
        return;
    }

    public WebPlayerView getWebPlayer() {
        return _webPlayerView;
    }

    protected void onAttachedToWindow() {
        RelativeLayout.onAttachedToWindow();
        BannerBridge.didAttach(_bannerAdId);
        return;
    }

    protected void onDetachedFromWindow() {
        RelativeLayout.onDetachedFromWindow();
        BannerBridge.didDetach(_bannerAdId);
        return;
    }

    public void onLayoutChange(View p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
        BannerWebPlayerContainer.getAlpha();
        BannerBridge.resize(_bannerAdId, p1, p2, p3, p4, BannerWebPlayerContainer.getAlpha(..));
        BannerWebPlayerContainer.getParent();
        if (if-eqz(BannerWebPlayerContainer.getParent(..))) goto L_34;
        new Rect();
        BannerWebPlayerContainer.getHitRect(new Rect(..));
        BannerWebPlayerContainer.getParent();
        if (if-eqz(BannerWebPlayerContainer.getParent(..))) goto L_34;
        BannerWebPlayerContainer.getParent();
        View.getLocalVisibleRect(new Rect(..));
        if (if-nez(View.getLocalVisibleRect(..))) goto L_34;
        BannerWebPlayerContainer.onVisibilityChanged(this, 8);
      L_34:
        return;
    }

    protected void onSizeChanged(int p0, int p1, int p2, int p3) {
        RelativeLayout.onSizeChanged(p0, p1, p2, p3);
        if (if-nez(p2)) goto L_7;
        if (if-eqz(p3)) goto L_33;
      L_7:
        BannerWebPlayerContainer.getLeft();
        BannerWebPlayerContainer.getRight();
        BannerWebPlayerContainer.getAlpha();
        BannerBridge.resize(_bannerAdId, BannerWebPlayerContainer.getLeft(..), BannerWebPlayerContainer.getRight(..), p0, p1, BannerWebPlayerContainer.getAlpha(..));
        new Rect();
        BannerWebPlayerContainer.getHitRect(new Rect(..));
        BannerWebPlayerContainer.getParent();
        View.getLocalVisibleRect(new Rect(..));
        if (if-eqz(View.getLocalVisibleRect(..))) goto L_33;
        BannerWebPlayerContainer.onVisibilityChanged(this, 8);
      L_33:
        return;
    }

    protected void onVisibilityChanged(View p0, int p1) {
        if (if-ne(p0, this)) goto L_15;
        if (if-ne(_lastVisibility, -1)) goto L_a;
        _lastVisibility = p1;
      L_a:
        if (if-eqz(p1)) goto L_13;
        if (if-nez(_lastVisibility)) goto L_13;
        BannerBridge.visibilityChanged(_bannerAdId, p1);
      L_13:
        _lastVisibility = p1;
      L_15:
        return;
    }

    public void setAlpha(float p0) {
        RelativeLayout.setAlpha(p0);
        BannerWebPlayerContainer.getLeft();
        BannerWebPlayerContainer.getTop();
        BannerWebPlayerContainer.getRight();
        BannerWebPlayerContainer.getBottom();
        BannerWebPlayerContainer.getLeft();
        BannerWebPlayerContainer.getTop();
        BannerWebPlayerContainer.getRight();
        BannerWebPlayerContainer.getBottom();
        BannerWebPlayerContainer.onLayoutChange(this, BannerWebPlayerContainer.getLeft(..), BannerWebPlayerContainer.getTop(..), BannerWebPlayerContainer.getRight(..), BannerWebPlayerContainer.getBottom(..), BannerWebPlayerContainer.getLeft(..), BannerWebPlayerContainer.getTop(..), BannerWebPlayerContainer.getRight(..), BannerWebPlayerContainer.getBottom(..));
        return;
    }

    public void setWebPlayerEventSettings(JSONObject p0) {
        _webPlayerEventSettings = p0;
        return;
    }

    public void setWebPlayerSettings(JSONObject p0, JSONObject p1) {
        _webSettings = p0;
        _webPlayerSettings = p1;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.view.ScarBannerContainer
// ============================================================
package com.unity3d.services.banners.view;

public class ScarBannerContainer extends RelativeLayout {
    private String _bannerAdId;

    public ScarBannerContainer(Context p0, String p1) {
        new RelativeLayout(p0);
        _bannerAdId = p1;
        return;
    }

    static void lambda$destroy$0(ScarBannerContainer p0) {
        p0.removeAllViews();
        p0.getParent();
        if (if-eqz(v1)) goto L_10;
        ScarBannerContainer.getParent(..).removeView(p0);
      L_10:
        return;
    }

    public void destroy() {
        new ScarBannerContainer$$ExternalSyntheticLambda0(this);
        Utilities.runOnUiThread(new ScarBannerContainer$$ExternalSyntheticLambda0(..));
        return;
    }

    protected void onAttachedToWindow() {
        RelativeLayout.onAttachedToWindow();
        BannerBridge.didAttachScarBanner(_bannerAdId);
        return;
    }

    protected void onDetachedFromWindow() {
        RelativeLayout.onDetachedFromWindow();
        BannerBridge.didDetachScarBanner(_bannerAdId);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.view.BannerWebPlayerContainer$1
// ============================================================
package com.unity3d.services.banners.view;

class BannerWebPlayerContainer$1 {
    final BannerWebPlayerContainer this$0;

    BannerWebPlayerContainer$1(BannerWebPlayerContainer p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void onLayoutChange(View p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
        this$0.onLayoutChange(p0, p1, p2, p3, p4, p5, p6, p7, p8);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.view.BannerWebPlayerContainer$2
// ============================================================
package com.unity3d.services.banners.view;

class BannerWebPlayerContainer$2 {
    final BannerWebPlayerContainer this$0;
    final View$OnLayoutChangeListener val$onLayoutChangeListener;

    BannerWebPlayerContainer$2(BannerWebPlayerContainer p0, View$OnLayoutChangeListener p1) {
        this$0 = p0;
        val$onLayoutChangeListener = p1;
        new Object();
        return;
    }

    public void run() {
        this$0.removeOnLayoutChangeListener(val$onLayoutChangeListener);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.banners.view.BannerWebPlayerContainer$3
// ============================================================
package com.unity3d.services.banners.view;

class BannerWebPlayerContainer$3 {
    final BannerWebPlayerContainer this$0;
    final BannerWebPlayerContainer val$self;

    BannerWebPlayerContainer$3(BannerWebPlayerContainer p0, BannerWebPlayerContainer p1) {
        this$0 = p0;
        val$self = p1;
        new Object();
        return;
    }

    public void run() {
        BannerWebPlayerContainer.removeAllViews();
        BannerWebPlayerContainer.getParent();
        if (if-eqz(BannerWebPlayerContainer.getParent(..))) goto L_18;
        if (if-eqz(v1)) goto L_18;
        ViewGroup.removeView(val$self);
      L_18:
        BannerWebPlayerContainer.access$000(val$self);
        if (if-eqz(BannerWebPlayerContainer.access$000(..))) goto L_29;
        BannerWebPlayerContainer.access$000(val$self);
        WebPlayerView.destroy();
      L_29:
        BannerWebPlayerContainer.access$002(val$self, 0);
        return;
    }

}

