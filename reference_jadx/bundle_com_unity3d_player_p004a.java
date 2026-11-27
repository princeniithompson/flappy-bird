
// ===== FILE: com/unity3d/player/p004a/AbstractC0948a.java =====
package com.unity3d.player.p004a;

/* renamed from: com.unity3d.player.a.a */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0948a {

    /* renamed from: a */
    public static final /* synthetic */ int[] f542a = {1, 2, 3};

    /* renamed from: a */
    public static /* synthetic */ int m391a(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    /* renamed from: b */
    public static /* synthetic */ int[] m392b(int i) {
        int[] iArr = new int[i];
        System.arraycopy(f542a, 0, iArr, 0, i);
        return iArr;
    }
}

// ===== FILE: com/unity3d/player/p004a/AbstractC0950c.java =====
package com.unity3d.player.p004a;

/* renamed from: com.unity3d.player.a.c */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0950c {
    /* renamed from: a */
    public static /* synthetic */ int m393a(int i) {
        if (i == 1) {
            return -1;
        }
        if (i == 2) {
            return 0;
        }
        if (i == 3) {
            return 1;
        }
        throw null;
    }
}

// ===== FILE: com/unity3d/player/p004a/AbstractC0951d.java =====
package com.unity3d.player.p004a;

/* renamed from: com.unity3d.player.a.d */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0951d {
    /* renamed from: a */
    public static int[] m394a() {
        return AbstractC0948a.m392b(3);
    }
}

// ===== FILE: com/unity3d/player/p004a/C0952e.java =====
package com.unity3d.player.p004a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;

/* renamed from: com.unity3d.player.a.e */
/* loaded from: classes.dex */
public final class C0952e extends View {

    /* renamed from: a */
    final int f543a;

    /* renamed from: b */
    final int f544b;

    /* renamed from: c */
    int f545c;

    /* renamed from: d */
    Bitmap f546d;

    /* renamed from: e */
    Bitmap f547e;

    public C0952e(Context context, int i) {
        super(context);
        this.f545c = ViewCompat.MEASURED_STATE_MASK;
        this.f543a = i;
        int identifier = getResources().getIdentifier("unity_static_splash", "drawable", getContext().getPackageName());
        this.f544b = identifier;
        if (identifier != 0) {
            forceLayout();
        }
        int identifier2 = getResources().getIdentifier("staticSplashScreenBackgroundColor", TypedValues.Custom.S_COLOR, getContext().getPackageName());
        if (identifier2 != 0) {
            this.f545c = getResources().getColor(identifier2);
        }
        setBackgroundColor(this.f545c);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.f546d;
        if (bitmap != null) {
            bitmap.recycle();
            this.f546d = null;
        }
        Bitmap bitmap2 = this.f547e;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f547e = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0068, code lost:
    
        if (r12 < r10) goto L31;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f544b == 0) {
            return;
        }
        if (this.f546d == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            this.f546d = BitmapFactory.decodeResource(getResources(), this.f544b, options);
        }
        int width = this.f546d.getWidth();
        int height = this.f546d.getHeight();
        int width2 = getWidth();
        int height2 = getHeight();
        if (width2 == 0 || height2 == 0) {
            return;
        }
        float f = width / height;
        float f2 = width2;
        float f3 = height2;
        boolean z2 = f2 / f3 <= f;
        int m391a = AbstractC0948a.m391a(this.f543a);
        if (m391a != 0) {
            if (m391a == 1 || m391a == 2) {
                if ((this.f543a == 3) ^ z2) {
                    height = (int) (f2 / f);
                    width = width2;
                }
                width = (int) (f3 * f);
                height = height2;
            }
        } else if (width2 < width) {
            height = (int) (f2 / f);
            width = width2;
        }
        Bitmap bitmap = this.f547e;
        if (bitmap != null) {
            if (bitmap.getWidth() == width && this.f547e.getHeight() == height) {
                return;
            }
            Bitmap bitmap2 = this.f547e;
            if (bitmap2 != this.f546d) {
                bitmap2.recycle();
                this.f547e = null;
            }
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.f546d, width, height, true);
        this.f547e = createScaledBitmap;
        createScaledBitmap.setDensity(getResources().getDisplayMetrics().densityDpi);
        ColorDrawable colorDrawable = new ColorDrawable(this.f545c);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), this.f547e);
        bitmapDrawable.setGravity(17);
        setBackground(new LayerDrawable(new Drawable[]{colorDrawable, bitmapDrawable}));
    }
}

// ===== FILE: com/unity3d/player/p004a/InterfaceC0949b.java =====
package com.unity3d.player.p004a;

/* renamed from: com.unity3d.player.a.b */
/* loaded from: classes.dex */
public interface InterfaceC0949b {
}
