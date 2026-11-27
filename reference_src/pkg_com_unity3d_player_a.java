// Package bundle: com.unity3d.player.a (5 classes)

// ============================================================
// CLASS: com.unity3d.player.a.AppClass_099 (orig: a)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppCanvasView_047.AppClass_099
package com.unity3d.player.AppCanvasView_047;

public abstract class AppClass_099 /* orig: a */ {
    public static final int[] a;

    static <clinit>() {
        a = 3;
        return;
    }

    public static int a(int p0) {
        if (if-eqz(p0)) goto L_5;
        return p0;
      L_5:
        throw 0;
    }

    public static int[] b(int p0) {
        System.arraycopy(a.a, 0, v0, 0, p0);
        return v0;
    }

}


// ============================================================
// CLASS: com.unity3d.player.a.AppClass_100 (orig: b)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppCanvasView_047.AppClass_100
package com.unity3d.player.AppCanvasView_047;

public abstract class AppClass_100 /* orig: b */ {
}


// ============================================================
// CLASS: com.unity3d.player.a.AppClass_101 (orig: c)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppCanvasView_047.AppClass_101
package com.unity3d.player.AppCanvasView_047;

public abstract class AppClass_101 /* orig: c */ {
    public static int a(int p0) {
        if (if-ne(p0, 1)) goto L_5;
        return -1;
      L_5:
        if (if-ne(-1, 2)) goto L_a;
        return 0;
      L_a:
        if (if-ne(0, 3)) goto L_e;
        return 1;
      L_e:
        throw 0;
    }

}


// ============================================================
// CLASS: com.unity3d.player.a.AppClass_102 (orig: d)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppCanvasView_047.AppClass_102
package com.unity3d.player.AppCanvasView_047;

public abstract class AppClass_102 /* orig: d */ {
    public static int[] a() {
        a.b(3);
        return a.b(..);
    }

}


// ============================================================
// CLASS: com.unity3d.player.a.AppView_103 (orig: e)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppCanvasView_047.AppView_103
package com.unity3d.player.AppCanvasView_047;

public final class AppView_103 /* orig: e */ extends View {
    final int a;
    final int b;
    int c;
    Bitmap d;
    Bitmap e;

    public e(Context p0, int p1) {
        new View(p0);
        c = 0xff000000;
        a = p1;
        new View(..).getResources();
        new View(..).getContext();
        View.getContext(..).getPackageName();
        View.getResources(..).getIdentifier("unity_static_splash", "drawable", Context.getPackageName(..));
        b = Resources.getIdentifier(..);
        if (if-eqz(Resources.getIdentifier(..))) goto L_24;
        new View(..).forceLayout();
      L_24:
        new View(..).getResources();
        new View(..).getContext();
        View.getContext(..).getPackageName();
        View.getResources(..).getIdentifier("staticSplashScreenBackgroundColor", "color", Context.getPackageName(..));
        if (if-eqz(Resources.getIdentifier(..))) goto L_44;
        new View(..).getResources();
        View.getResources(..).getColor(Resources.getIdentifier(..));
        c = Resources.getColor(..);
      L_44:
        new View(..).setBackgroundColor(c);
        return;
    }

    public final void onDetachedFromWindow() {
        View.onDetachedFromWindow();
        if (if-eqz(d)) goto L_d;
        d.recycle();
        d = 0;
      L_d:
        if (if-eqz(e)) goto L_16;
        e.recycle();
        e = 0;
      L_16:
        return;
    }

    public final void onLayout(boolean p0, int p1, int p2, int p3, int p4) {
        if (if-nez(b)) goto L_5;
        return;
      L_5:
        if (if-nez(d)) goto L_1d;
        new BitmapFactory$Options();
        inScaled = 0;
        View.getResources();
        BitmapFactory.decodeResource(View.getResources(..), b, new BitmapFactory$Options(..));
        d = BitmapFactory.decodeResource(..);
      L_1d:
        d.getWidth();
        d.getHeight();
        View.getWidth();
        View.getHeight();
        if (if-eqz(View.getWidth(..))) goto L_c6;
        if (if-nez(View.getHeight(..))) goto L_37;
      L_37:
        if (if-gtz(v3)) goto L_45;
      L_45:
      L_46:
        a.a(a);
        if (if-eqz(a.a(..))) goto L_63;
        if (if-eq(a.a(..), 1)) goto L_54;
        if (if-eq(a.a(..), 2)) goto L_54;
      L_54:
        if (if-ne(a, 3)) goto L_5b;
      L_5b:
      L_5c:
        if (if-eqz(0)) goto L_6a;
      L_63:
        if (if-ge(View.getWidth(..), View.getWidth(..))) goto L_68;
      L_68:
        if (if-ge(View.getHeight(..), 3)) goto L_6d;
      L_6a:
      L_6d:
        if (if-eqz(e)) goto L_8c;
        e.getWidth();
        if (if-ne(Bitmap.getWidth(..), View.getWidth(..))) goto L_80;
        e.getHeight();
        if (if-ne(Bitmap.getHeight(..), View.getHeight(..))) goto L_80;
        return;
      L_80:
        if (if-eq(e, d)) goto L_8c;
        e.recycle();
        e = 0;
      L_8c:
        Bitmap.createScaledBitmap(d, View.getWidth(..), View.getHeight(..), 1);
        e = Bitmap.createScaledBitmap(..);
        View.getResources();
        View.getResources(..).getDisplayMetrics();
        Bitmap.createScaledBitmap(..).setDensity(densityDpi);
        new ColorDrawable(c);
        View.getResources();
        new BitmapDrawable(View.getResources(..), e);
        new BitmapDrawable(..).setGravity(17);
        new LayerDrawable(e);
        View.setBackground(new LayerDrawable(..));
      L_c6:
        return;
    }

}

