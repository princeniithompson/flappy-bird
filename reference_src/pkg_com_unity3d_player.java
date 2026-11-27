// Package bundle: com.unity3d.player (128 classes)

// ============================================================
// CLASS: com.unity3d.player.AppView_001 (orig: A)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppView_001
package com.unity3d.player;

final class AppView_001 /* orig: A */ extends View {
    Bitmap a;

    A(Context p0) {
        new View(p0);
        return;
    }

    public final void a(SurfaceView p0) {
        p0.getWidth();
        p0.getHeight();
        Bitmap.createBitmap(View.getWidth(..), View.getHeight(..), Bitmap$Config.ARGB_8888);
        a = Bitmap.createBitmap(..);
        Looper.getMainLooper();
        new Handler(Looper.getMainLooper(..));
        PixelCopy.request(p0, Bitmap.createBitmap(..), this, new Handler(..));
        return;
    }

    public final void onPixelCopyFinished(int p0) {
        if (if-nez(p0)) goto L_25;
        new ColorDrawable(0xff000000);
        View.getResources();
        new BitmapDrawable(View.getResources(..), a);
        new LayerDrawable(2);
        View.setBackground(new LayerDrawable(..));
      L_25:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_002 (orig: A0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_002
package com.unity3d.player;

final class AppClass_002 /* orig: A0 */ {
    final Semaphore a;
    final UnityPlayer b;

    A0(UnityPlayer p0, Semaphore p1) {
        b = p0;
        a = p1;
        new Object();
        return;
    }

    public final void run() {
        UnityPlayer.-$$Nest$mshutdown(b);
        a.release();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AudioVolumeHandler
// ============================================================
package com.unity3d.player;

public class AudioVolumeHandler {
    private l a;

    AudioVolumeHandler(Context p0) {
        new Object();
        new l(p0);
        a = new l(..);
        new l(..).a(new Object(..));
        return;
    }

    public final void a() {
        a.a();
        a = 0;
        return;
    }

    public final void onAudioVolumeChanged(int p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_003 (orig: B)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_003
package com.unity3d.player;

final class AppClass_003 /* orig: B */ {
    Context a;
    A b;

    B(Context p0) {
        new Object();
        b = 0;
        a = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_004 (orig: B0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_004
package com.unity3d.player;

final class AppClass_004 /* orig: B0 */ {
    final Semaphore a;
    final UnityPlayer b;

    B0(UnityPlayer p0, Semaphore p1) {
        b = p0;
        a = p1;
        new Object();
        return;
    }

    public final void run() {
        UnityPlayer.-$$Nest$mnativePause(b);
        if (if-eqz(UnityPlayer.-$$Nest$mnativePause(..))) goto L_16;
        UnityPlayer.-$$Nest$fputmQuitting(b, 1);
        UnityPlayer.-$$Nest$mshutdown(b);
        UnityPlayer.-$$Nest$mqueueDestroy(b);
      L_16:
        a.release();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.BuildConfig
// ============================================================
package com.unity3d.player;

public final class BuildConfig {
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String LIBRARY_PACKAGE_NAME = "com.unity3d.player";

    public BuildConfig() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_005 (orig: C)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_005
package com.unity3d.player;

final class AppClass_005 /* orig: C */ {
    private Runnable a;
    private UnityPlayer b;
    private long c;
    final long d;

    C(UnityPlayer p0, long p1) {
        d = p1;
        new Object();
        ReflectionHelper.-$$Nest$sfgetb();
        new F(ReflectionHelper.-$$Nest$sfgetb(..), v2, p1, v6);
        a = new F(..);
        b = p0;
        c = ReflectionHelper.-$$Nest$sfgetb(..);
        return;
    }

    private static Object a(Object p0, Method p1, Object[] p2, E p3) {
        if (if-nez(p2)) goto L_7;
      L_7:
        p1.getDeclaringClass();
        MethodHandles$Lookup.class.getDeclaredConstructor(v6);
        Class.getDeclaredConstructor(..).setAccessible(1);
        Integer.valueOf(2);
        Class.getDeclaredConstructor(..).newInstance(v6);
        Constructor.newInstance(..).in(Method.getDeclaringClass(..));
        MethodHandles$Lookup.in(..).unreflectSpecial(p1, Method.getDeclaringClass(..));
        MethodHandle.bindTo(p0);
        MethodHandle.bindTo(..).invokeWithArguments(p2);
        E.-$$Nest$fgeta(p3);
        if (if-eqz(p3)) goto L_4b;
        ReflectionHelper.-$$Nest$smnativeProxyJNIFreeGCHandle(E.-$$Nest$fgeta(..), p2);
      L_4b:
        return MethodHandle.invokeWithArguments(..);
        String.format("Java interface default methods are only supported since Android Oreo", E.-$$Nest$fgeta(..));
        t.Log(6, String.format(..));
        E.-$$Nest$fgeta(p3);
        ReflectionHelper.-$$Nest$smnativeProxyLogJNIInvokeException(E.-$$Nest$fgeta(..), 6);
        E.-$$Nest$fputa(p3, 0L, v1);
        return 0;
      L_66:
        E.-$$Nest$fgeta(p3);
        if (if-eqz(p3)) goto L_71;
        ReflectionHelper.-$$Nest$smnativeProxyJNIFreeGCHandle(E.-$$Nest$fgeta(..), p2);
      L_71:
        throw 0;
    }

    protected void finalize() {
        b.queueGLThreadEvent(a);
        Object.finalize();
        return;
    }

    public final Object invoke(Object p0, Method p1, Object[] p2) {
        ReflectionHelper.beginProxyCall(c, v1);
        if (if-nez(ReflectionHelper.beginProxyCall(..))) goto L_10;
        t.Log(6, "Scripting proxy object was destroyed, because Unity player was unloaded.");
        return 0;
      L_10:
        Method.getName();
        ReflectionHelper.-$$Nest$smnativeProxyInvoke(d, v3, Method.getName(..), p2);
        if (if-eqz(d)) goto L_41;
        E.-$$Nest$fgetb(ReflectionHelper.-$$Nest$smnativeProxyInvoke(..));
        if (if-eqz(E.-$$Nest$fgetb(..))) goto L_36;
        Method.getModifiers();
        if (if-nez(Method.getModifiers(..))) goto L_36;
        C.a(6, "Scripting proxy object was destroyed, because Unity player was unloaded.", p2, ReflectionHelper.-$$Nest$smnativeProxyInvoke(..));
        ReflectionHelper.endProxyCall();
        return C.a(..);
      L_36:
        E.-$$Nest$fgeta(ReflectionHelper.-$$Nest$smnativeProxyInvoke(..));
        ReflectionHelper.-$$Nest$smnativeProxyLogJNIInvokeException(E.-$$Nest$fgeta(..), "Scripting proxy object was destroyed, because Unity player was unloaded.");
        ReflectionHelper.endProxyCall();
        return 0;
      L_41:
        ReflectionHelper.endProxyCall();
        return ReflectionHelper.-$$Nest$smnativeProxyInvoke(..);
        ReflectionHelper.endProxyCall();
        throw E.-$$Nest$fgeta(..);
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_006 (orig: C0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_006
package com.unity3d.player;

final class AppClass_006 /* orig: C0 */ {
    final UnityPlayer a;

    C0(UnityPlayer p0) {
        a = p0;
        new Object();
        return;
    }

    public final void run() {
        UnityPlayer.-$$Nest$mnativeLowMemory(a);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.Camera2Wrapper
// ============================================================
package com.unity3d.player;

public class Camera2Wrapper {
    private Context a;
    private r b;

    public Camera2Wrapper(Context p0) {
        new Object();
        b = 0;
        a = p0;
        new Object(..).initCamera2Jni();
        return;
    }

    private final void deinitCamera2Jni() {
        // native or abstract
    }

    private final void initCamera2Jni() {
        // native or abstract
    }

    private final void nativeFrameReady(Object p0, Object p1, Object p2, int p3, int p4, int p5) {
        // native or abstract
    }

    private final void nativeSurfaceTextureReady(Object p0) {
        // native or abstract
    }

    public final void a() {
        Camera2Wrapper.deinitCamera2Jni();
        Camera2Wrapper.closeCamera2();
        return;
    }

    public final void a(Object p0) {
        Camera2Wrapper.nativeSurfaceTextureReady(p0);
        return;
    }

    public final void a(ByteBuffer p0, ByteBuffer p1, ByteBuffer p2, int p3, int p4, int p5) {
        Camera2Wrapper.nativeFrameReady(p0, p1, p2, p3, p4, p5);
        return;
    }

    protected void closeCamera2() {
        if (if-eqz(b)) goto L_7;
        b.a();
      L_7:
        b = 0;
        return;
    }

    protected int getCamera2Count() {
        r.a(a);
        return r.a(..);
    }

    protected int getCamera2FocalLengthEquivalent(int p0) {
        r.a(a, p0);
        return r.a(..);
    }

    protected int[] getCamera2Resolutions(int p0) {
        r.b(a, p0);
        return r.b(..);
    }

    protected int getCamera2SensorOrientation(int p0) {
        r.c(a, p0);
        return r.c(..);
    }

    protected Rect getFrameSizeCamera2() {
        if (if-eqz(b)) goto L_9;
        b.c();
      L_9:
        new Rect();
      L_e:
        return new Rect(..);
    }

    protected boolean initializeCamera2(int p0, int p1, int p2, int p3, int p4, Surface p5) {
        if (if-nez(b)) goto L_1c;
        if (if-eqz(UnityPlayer.currentActivity)) goto L_1c;
        new r(this);
        b = new r(..);
        new r(..).a(a, p0, p1, p2, p3, p4, p5);
        return r.a(..);
      L_1c:
        return 0;
    }

    protected boolean isCamera2AutoFocusPointSupported(int p0) {
        r.d(a, p0);
        return r.d(..);
    }

    protected boolean isCamera2FrontFacing(int p0) {
        r.e(a, p0);
        return r.e(..);
    }

    protected void pauseCamera2() {
        if (if-eqz(b)) goto L_7;
        b.d();
      L_7:
        return;
    }

    protected boolean setAutoFocusPoint(float p0, float p1) {
        if (if-eqz(b)) goto L_9;
        b.a(p0, p1);
        return r.a(..);
      L_9:
        return 0;
    }

    protected void startCamera2() {
        if (if-eqz(b)) goto L_7;
        b.h();
      L_7:
        return;
    }

    protected void stopCamera2() {
        if (if-eqz(b)) goto L_7;
        b.i();
      L_7:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_007 (orig: D)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_007
package com.unity3d.player;

final class AppClass_007 /* orig: D */ {
    private final Class a;
    private final String b;
    private final String c;
    private final int d;
    public Member e;

    static int -$$Nest$fgetd(D p0) {
        return d;
    }

    D(Class p0, String p1, String p2) {
        new Object();
        a = p0;
        b = p1;
        c = p2;
        p0.hashCode();
        p1.hashCode();
        p2.hashCode();
        d = String.hashCode(..);
        return;
    }

    public final boolean equals(Object p0) {
        if (if-ne(p0, this)) goto L_4;
        return 1;
      L_4:
        if (if-eqz(v1)) goto L_32;
        if (if-ne(d, d)) goto L_30;
        c.equals(c);
        if (if-eqz(String.equals(..))) goto L_30;
        b.equals(b);
        if (if-eqz(String.equals(..))) goto L_30;
        a.equals(a);
        if (if-eqz(Object.equals(..))) goto L_30;
      L_30:
      L_31:
        return 0;
      L_32:
        return 0;
    }

    public final int hashCode() {
        return d;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_008 (orig: D0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_008
package com.unity3d.player;

final class AppClass_008 /* orig: D0 */ {
    D0() {
        new Object();
        return;
    }

    public final void onAccuracyChanged(Sensor p0, int p1) {
        return;
    }

    public final void onSensorChanged(SensorEvent p0) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_009 (orig: E)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_009
package com.unity3d.player;

final class AppClass_009 /* orig: E */ {
    private long a;
    private boolean b;

    static long -$$Nest$fgeta(E p0) {
        return a;
    }

    static boolean -$$Nest$fgetb(E p0) {
        return b;
    }

    static void -$$Nest$fputa(E p0, long p1) {
        a = p1;
        return;
    }

    public E(long p0, boolean p1) {
        new Object();
        a = p0;
        b = p1;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_010 (orig: E0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_010
package com.unity3d.player;

final class AppClass_010 /* orig: E0 */ extends PhoneStateListener {
    final UnityPlayer a;

    private E0(UnityPlayer p0) {
        a = p0;
        new PhoneStateListener();
        return;
    }

    E0(UnityPlayer p0, E0-IA p1) {
        new E0(p0);
        return;
    }

    public final void onCallStateChanged(int p0, String p1) {
        if (if-ne(p0, 1)) goto L_6;
      L_6:
      L_7:
        UnityPlayer.-$$Nest$mnativeMuteMasterAudio(a, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.E0-IA
// ============================================================
package com.unity3d.player;

public final class E0-IA {
}


// ============================================================
// CLASS: com.unity3d.player.AppClass_011 (orig: F)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_011
package com.unity3d.player;

final class AppClass_011 /* orig: F */ {
    final long a;
    final long b;

    public F(long p0, long p1) {
        new Object();
        a = p0;
        b = p1;
        return;
    }

    public final void run() {
        ReflectionHelper.beginProxyCall(a, v1);
        if (if-nez(ReflectionHelper.beginProxyCall(..))) goto L_9;
        return;
      L_9:
        ReflectionHelper.-$$Nest$smnativeProxyFinalize(b, v1);
        ReflectionHelper.endProxyCall();
        return;
        ReflectionHelper.endProxyCall();
        throw b;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_012 (orig: F0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_012
package com.unity3d.player;

final class AppClass_012 /* orig: F0 */ extends Enum {
    public static final F0 a;
    public static final F0 b;
    public static final F0 c;
    public static final F0 d;
    public static final F0 e;
    public static final F0 f;
    public static final F0 g;
    public static final F0 h;
    public static final F0 i;
    public static final F0 j;

    static <clinit>() {
        new F0(0, "PAUSE");
        a = new F0(..);
        new F0(1, "RESUME");
        b = new F0(..);
        new F0(2, "QUIT");
        c = new F0(..);
        new F0(3, "SURFACE_LOST");
        d = new F0(..);
        new F0(4, "SURFACE_ACQUIRED");
        e = new F0(..);
        new F0(5, "FOCUS_LOST");
        f = new F0(..);
        new F0(6, "FOCUS_GAINED");
        g = new F0(..);
        new F0(7, "NEXT_FRAME");
        h = new F0(..);
        new F0(8, "URL_ACTIVATED");
        i = new F0(..);
        new F0(9, "ORIENTATION_ANGLE_CHANGE");
        j = new F0(..);
        return;
    }

    private F0(int p0, String p1) {
        new Enum(p1, p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_013 (orig: G)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_013
package com.unity3d.player;

final class AppClass_013 /* orig: G */ extends RelativeLayout {
    protected Button a;
    protected EditText b;
    protected Context c;
    protected Rect d;
    protected Rect e;

    public G(Context p0, EditText p1) {
        new RelativeLayout(p0);
        b = p1;
        c = p0;
        new Rect(16, 16, 16, 16);
        d = new Rect(..);
        new Rect(0, 0, 0, 0);
        e = new Rect(..);
        new RelativeLayout(..).createUI();
        new RelativeLayout(..).setBackgroundColor(-1);
        return;
    }

    protected void createUI() {
        new ViewGroup$LayoutParams(-1, -1);
        View.setLayoutParams(new ViewGroup$LayoutParams(..));
        new Button(c);
        a = new Button(..);
        View.generateViewId();
        new Button(..).setId(View.generateViewId(..));
        c.getResources();
        Context.getResources(..).getIdentifier("ok", "string", "android");
        a.setText(Resources.getIdentifier(..));
        new RelativeLayout$LayoutParams(-2, -2);
        new RelativeLayout$LayoutParams(..).addRule(15);
        new RelativeLayout$LayoutParams(..).addRule(11);
        a.setLayoutParams(new RelativeLayout$LayoutParams(..));
        a.setBackgroundColor(0);
        ViewGroup.addView(a);
        View.generateViewId();
        b.setId(View.generateViewId(..));
        new RelativeLayout$LayoutParams(-1, -2);
        new RelativeLayout$LayoutParams(..).addRule(15);
        a.getId();
        new RelativeLayout$LayoutParams(..).addRule(0, View.getId(..));
        b.setLayoutParams(new RelativeLayout$LayoutParams(..));
        ViewGroup.addView(b);
        View.setPadding(left, top, right, bottom);
        return;
    }

    public final void setOnClickListener(View$OnClickListener p0) {
        a.setOnClickListener(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_014 (orig: G0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_014
package com.unity3d.player;

final class AppClass_014 /* orig: G0 */ {
    final H0 a;

    G0(H0 p0) {
        a = p0;
        new Object();
        return;
    }

    public final boolean handleMessage(Message p0) {
        if (if-eq(what, 2269)) goto L_8;
        return 0;
      L_8:
        if (if-ne(obj, F0.h)) goto L_89;
        e = e;
        i.executeGLThreadJobs();
        if (if-nez(b)) goto L_24;
        return 1;
      L_24:
        UnityPlayer.-$$Nest$mgetHaveAndroidWindowSupport(i);
        if (if-eqz(UnityPlayer.-$$Nest$mgetHaveAndroidWindowSupport(..))) goto L_33;
        if (if-nez(c)) goto L_33;
        return 1;
      L_33:
        if (if-ltz(h)) goto L_6c;
        if (if-nez(h)) goto L_65;
        UnityPlayer.-$$Nest$mgetSplashEnabled(i);
        if (if-eqz(UnityPlayer.-$$Nest$mgetSplashEnabled(..))) goto L_4a;
        UnityPlayer.-$$Nest$mDisableStaticSplashScreen(i);
      L_4a:
        UnityPlayer.-$$Nest$fgetmActivity(i);
        if (if-eqz(UnityPlayer.-$$Nest$fgetmActivity(..))) goto L_65;
        UnityPlayer.-$$Nest$mgetAutoReportFullyDrawnEnabled(i);
        if (if-eqz(UnityPlayer.-$$Nest$mgetAutoReportFullyDrawnEnabled(..))) goto L_65;
        UnityPlayer.-$$Nest$fgetmActivity(i);
        Activity.reportFullyDrawn();
      L_65:
        h = h;
      L_6c:
        i.isFinishing();
        if (if-nez(UnityPlayer.isFinishing(..))) goto L_10a;
        UnityPlayer.-$$Nest$mnativeRender(i);
        if (if-nez(UnityPlayer.-$$Nest$mnativeRender(..))) goto L_10a;
        UnityPlayer.-$$Nest$mfinish(i);
      L_89:
        if (if-ne(i, F0.c)) goto L_96;
        Looper.myLooper();
        Looper.myLooper(..).quit();
      L_96:
        if (if-ne(Looper.myLooper(..), F0.b)) goto L_a0;
        b = 1;
      L_a0:
        if (if-ne(a, F0.a)) goto L_a9;
        b = h;
      L_a9:
        if (if-ne(a, F0.d)) goto L_b2;
        c = h;
      L_b2:
        if (if-ne(a, F0.e)) goto L_c0;
        c = 1;
        if (if-ne(d, 3)) goto L_10a;
      L_c0:
        if (if-ne(a, F0.f)) goto L_d5;
        if (if-ne(d, 1)) goto L_cf;
        UnityPlayer.-$$Nest$mnativeFocusChanged(i, d);
      L_cf:
        d = 2;
      L_d5:
        if (if-ne(a, F0.g)) goto L_eb;
        d = 3;
        if (if-eqz(c)) goto L_10a;
      L_e1:
        UnityPlayer.-$$Nest$mnativeFocusChanged(i, 1);
        d = 1;
      L_eb:
        if (if-ne(a, F0.i)) goto L_fb;
        i.getLaunchURL();
        UnityPlayer.-$$Nest$mnativeSetLaunchURL(i, UnityPlayer.getLaunchURL(..));
      L_fb:
        if (if-ne(i, F0.j)) goto L_10a;
        UnityPlayer.-$$Nest$mnativeOrientationChanged(i, f, g);
      L_10a:
        if (if-eqz(b)) goto L_124;
        if (if-gtz(e)) goto L_124;
        Message.obtain(a, 2269, F0.h);
        Message.obtain(..).sendToTarget();
        e = e;
      L_124:
        return 1;
    }

}


// ============================================================
// CLASS: com.unity3d.player.GoogleARCoreApi
// ============================================================
package com.unity3d.player;

public class GoogleARCoreApi {
    public GoogleARCoreApi() {
        new Object();
        return;
    }

    public final void initializeARCore(Activity p0) {
        // native or abstract
    }

    public final void pauseARCore() {
        // native or abstract
    }

    public final void resumeARCore() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_015 (orig: H)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_015
package com.unity3d.player;

final class AppClass_015 /* orig: H */ {
    final I a;

    H(I p0) {
        a = p0;
        new Object();
        return;
    }

    public final boolean onEditorAction(TextView p0, int p1, KeyEvent p2) {
        if (if-ne(p1, 6)) goto L_d;
        a.b();
        a.a(I.b(..), 0);
      L_d:
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppWorker_016 (orig: H0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppWorker_016
package com.unity3d.player;

final class AppWorker_016 /* orig: H0 */ extends Thread {
    Handler a;
    boolean b;
    boolean c;
    int d;
    int e;
    int f;
    int g;
    int h;
    final UnityPlayer i;

    static void -$$Nest$ma(H0 p0, F0 p1) {
        p0.a(p1);
        return;
    }

    private H0(UnityPlayer p0) {
        i = p0;
        new Thread();
        b = 0;
        c = 0;
        d = 2;
        e = 0;
        h = 5;
        return;
    }

    H0(UnityPlayer p0, H0-IA p1) {
        new H0(p0);
        return;
    }

    private void a(F0 p0) {
        if (if-eqz(a)) goto L_d;
        Message.obtain(a, 2269, p0);
        Message.obtain(..).sendToTarget();
      L_d:
        return;
    }

    public final void run() {
        Thread.setName("UnityMain");
        Looper.prepare();
        Looper.myLooper();
        new G0(this);
        new Handler(Looper.myLooper(..), new G0(..));
        a = new Handler(..);
        Looper.loop();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.H0-IA
// ============================================================
package com.unity3d.player;

public final class H0-IA {
}


// ============================================================
// CLASS: com.unity3d.player.HFPStatus
// ============================================================
package com.unity3d.player;

public class HFPStatus {
    private Context a;
    private BroadcastReceiver b;
    private boolean c;
    private AudioManager d;
    private boolean e;
    private int f;

    static boolean -$$Nest$fgetc(HFPStatus p0) {
        return c;
    }

    static AudioManager -$$Nest$fgetd(HFPStatus p0) {
        return d;
    }

    static void -$$Nest$fputf(HFPStatus p0, int p1) {
        f = p1;
        return;
    }

    static void -$$Nest$ma(HFPStatus p0) {
        p0.a();
        return;
    }

    public HFPStatus(Context p0) {
        new Object();
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        f = 1;
        a = p0;
        p0.getSystemService("audio");
        d = Context.getSystemService(..);
        new Object(..).initHFPStatusJni();
        return;
    }

    private void a() {
        if (if-eqz(e)) goto L_c;
        e = 0;
        d.stopBluetoothSco();
      L_c:
        return;
    }

    private final void deinitHFPStatusJni() {
        // native or abstract
    }

    private final void initHFPStatusJni() {
        // native or abstract
    }

    public final void b() {
        HFPStatus.clearHFPStat();
        HFPStatus.deinitHFPStatusJni();
        return;
    }

    protected void clearHFPStat() {
        if (if-eqz(b)) goto L_c;
        a.unregisterReceiver(b);
        b = 0;
      L_c:
        f = 1;
        HFPStatus.a();
        return;
    }

    protected boolean getHFPStat() {
        if (if-ne(f, 2)) goto L_7;
      L_7:
      L_8:
        return 0;
    }

    protected void requestHFPStat() {
        HFPStatus.clearHFPStat();
        new HFPStatus$1(this);
        b = new HFPStatus$1(..);
        new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
        a.registerReceiver(new HFPStatus$1(..), new IntentFilter(..));
        e = 1;
        d.startBluetoothSco();
        t.Log(5, "startBluetoothSco() failed. no bluetooth device connected.");
      L_25:
        return;
    }

    protected void setHFPRecordingStat(boolean p0) {
        c = p0;
        if (if-nez(p0)) goto L_a;
        d.setMode(0);
      L_a:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_017 (orig: I)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_017
package com.unity3d.player;

abstract class AppClass_017 /* orig: I */ {
    protected Context a;
    protected UnityPlayer b;
    protected EditText c;
    protected boolean d;
    protected boolean e;
    protected w f;
    protected x g;

    public I(Context p0, UnityPlayer p1) {
        new Object();
        a = p0;
        b = p1;
        new Object(..).createEditText(new Object(..));
        c = I.createEditText(..);
        return;
    }

    public final String a() {
        a.getSystemService("input_method");
        Context.getSystemService(..).getCurrentInputMethodSubtype();
        if (if-nez(InputMethodManager.getCurrentInputMethodSubtype(..))) goto L_12;
        return 0;
      L_12:
        0.getLocale();
        if (if-eqz(InputMethodSubtype.getLocale(..))) goto L_21;
        InputMethodSubtype.getLocale(..).equals("");
        if (if-nez(String.equals(..))) goto L_21;
        return InputMethodSubtype.getLocale(..);
      L_21:
        0.getMode();
        0.getExtraValue();
        new StringBuilder();
        new StringBuilder(..).append(InputMethodSubtype.getMode(..));
        new StringBuilder(..).append(" ");
        new StringBuilder(..).append(InputMethodSubtype.getExtraValue(..));
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    public void a(String p0, int p1, boolean p2, boolean p3, boolean p4, boolean p5, String p6, int p7, boolean p8, boolean p9) {
        e = p9;
        I.setupTextInput(p0, p1, p2, p3, p4, p5, p6, p7);
        I.a(p8);
        return;
    }

    public final void a(String p0, boolean p1) {
        c.setSelection(0, 0);
        b.reportSoftInputStr(p0, 1, p1);
        return;
    }

    public abstract void a(boolean p0) {
        // native or abstract
    }

    public final void afterTextChanged(Editable p0) {
        p0.toString();
        b.reportSoftInputStr(Object.toString(..), 0, 0);
        c.getSelectionStart();
        c.getSelectionEnd();
        b.reportSoftInputSelection(TextView.getSelectionStart(..), TextView.getSelectionEnd(..));
        return;
    }

    public final String b() {
        if (if-nez(c)) goto L_6;
        return 0;
      L_6:
        0.getText();
        EditText.getText(..).toString();
        return Object.toString(..);
    }

    public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
        return;
    }

    public abstract void c() {
        // native or abstract
    }

    protected abstract EditText createEditText(I p0) {
        // native or abstract
    }

    public boolean d() {
        return e;
    }

    public abstract void e() {
        // native or abstract
    }

    public final void f() {
        a.getSystemService("input_method");
        Context.getSystemService(..).showSoftInput(c, 0);
        return;
    }

    protected void invokeOnClose() {
        if (if-eqz(g)) goto L_9;
        g.a();
      L_9:
        return;
    }

    public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
        return;
    }

    protected void setupTextInput(String p0, int p1, boolean p2, boolean p3, boolean p4, boolean p5, String p6, int p7) {
        new H(this);
        c.setOnEditorActionListener(new H(..));
        c.setBackgroundColor(-1);
        c.setImeOptions(6);
        c.setText(p0);
        c.setHint(p6);
        c.setHintTextColor(0x61000000);
        if (if-eqz(p2)) goto L_2f;
      L_2f:
      L_31:
        if (if-eqz(p3)) goto L_37;
      L_37:
      L_38:
        if (if-eqz(p4)) goto L_3e;
      L_3e:
      L_3f:
        if (if-ltz(p1)) goto L_5d;
        if (if-le(p1, 11)) goto L_47;
      L_47:
        if (if-eqz(12)) goto L_5c;
        if (if-eqz(p4)) goto L_59;
      L_59:
      L_5a:
      L_5c:
      L_5d:
        c.setInputType(0);
        c.setImeOptions(0x2000000);
        if (if-lez(p7)) goto L_78;
        new InputFilter$LengthFilter(p7);
        c.setFilters(0);
      L_78:
        c.addTextChangedListener(this);
        c.getText();
        EditText.getText(..).length();
        c.setSelection(CharSequence.length(..));
        c.setClickable(1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_018 (orig: I0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_018
package com.unity3d.player;

abstract class AppClass_018 /* orig: I0 */ {
    final UnityPlayer a;

    private I0(UnityPlayer p0) {
        a = p0;
        new Object();
        return;
    }

    I0(UnityPlayer p0, I0-IA p1) {
        new I0(p0);
        return;
    }

    public abstract void a() {
        // native or abstract
    }

    public final void run() {
        a.isFinishing();
        if (if-nez(UnityPlayer.isFinishing(..))) goto L_b;
        I0.a();
      L_b:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.I0-IA
// ============================================================
package com.unity3d.player;

public final class I0-IA {
}


// ============================================================
// CLASS: com.unity3d.player.IAssetPackManagerDownloadStatusCallback
// ============================================================
package com.unity3d.player;

abstract class IAssetPackManagerDownloadStatusCallback {
    public abstract void onStatusUpdate(String p0, int p1, long p2, long p3, int p4, int p5) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.player.IAssetPackManagerMobileDataConfirmationCallback
// ============================================================
package com.unity3d.player;

abstract class IAssetPackManagerMobileDataConfirmationCallback {
    public abstract void onMobileDataConfirmationResult(boolean p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.player.IAssetPackManagerStatusQueryCallback
// ============================================================
package com.unity3d.player;

abstract class IAssetPackManagerStatusQueryCallback {
    public abstract void onStatusResult(long p0, String[] p1, int[] p2, int[] p3) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.player.IPermissionRequestCallbacks
// ============================================================
package com.unity3d.player;

public abstract class IPermissionRequestCallbacks {
    public abstract void onPermissionDenied(String p0) {
        // native or abstract
    }

    public abstract void onPermissionDeniedAndDontAskAgain(String p0) {
        // native or abstract
    }

    public abstract void onPermissionGranted(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.player.IUnityPlayerLifecycleEvents
// ============================================================
package com.unity3d.player;

public abstract class IUnityPlayerLifecycleEvents {
    public abstract void onUnityPlayerQuitted() {
        // native or abstract
    }

    public abstract void onUnityPlayerUnloaded() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppDialog_019 (orig: J)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppDialog_019
package com.unity3d.player;

final class AppDialog_019 /* orig: J */ extends Dialog {
    protected Context a;
    protected UnityPlayer b;
    protected G c;
    protected I d;

    public J(Context p0, UnityPlayer p1) {
        new Dialog(p0);
        c = 0;
        d = 0;
        a = p0;
        b = p1;
        return;
    }

    public final Rect a() {
        new Rect();
        b.getWindowVisibleDisplayFrame(new Rect(..));
        b.getLocationOnScreen(2);
        new Rect(..).height();
        c.getHeight();
        new Point(left, Rect.height(..));
        new Point();
        Dialog.getWindow();
        Dialog.getWindow(..).getWindowManager();
        Window.getWindowManager(..).getDefaultDisplay();
        WindowManager.getDefaultDisplay(..).getSize(new Point(..));
        b.getHeight();
        c.getHeight();
        if (if-eq(View.getHeight(..), View.getHeight(..))) goto L_59;
        b.reportSoftInputIsVisible(1);
      L_59:
        b.reportSoftInputIsVisible(0);
      L_5c:
        c.getWidth();
        new Rect(x, y, View.getWidth(..), View.getHeight(..));
        return new Rect(..);
    }

    public final void a(I p0, boolean p1, boolean p2) {
        d = p0;
        Dialog.getWindow();
        Dialog.getWindow(..).requestFeature(1);
        Dialog.getWindow(..).getAttributes();
        gravity = 80;
        x = 0;
        y = 0;
        Dialog.getWindow(..).setAttributes(Window.getAttributes(..));
        new ColorDrawable(0);
        Dialog.getWindow(..).setBackgroundDrawable(new ColorDrawable(..));
        J.createSoftInputView(c);
        c = J.createSoftInputView(..);
        Dialog.getWindow(..).setLayout(-1, -2);
        Dialog.getWindow(..).clearFlags(2);
        Dialog.getWindow(..).clearFlags(0x8000000);
        Dialog.getWindow(..).clearFlags(0x4000000);
        if (if-nez(p2)) goto L_4b;
        Dialog.getWindow(..).addFlags(32);
        Dialog.getWindow(..).addFlags(0x40000);
      L_4b:
        J.a(p1);
        Dialog.getWindow();
        Dialog.getWindow(..).setSoftInputMode(5);
        return;
    }

    public final void a(boolean p0) {
        if (if-eqz(p0)) goto L_35;
        b.getLayoutParams();
        height = 1;
        b.setLayoutParams(View.getLayoutParams(..));
        a.getLayoutParams();
        height = 1;
        a.setLayoutParams(View.getLayoutParams(..));
        c.setPadding(left, top, right, bottom);
        c.setVisibility(4);
      L_35:
        c.setVisibility(0);
        c.setPadding(left, top, right, bottom);
        b.getLayoutParams();
        height = -2;
        b.setLayoutParams(View.getLayoutParams(..));
        a.getLayoutParams();
        height = -2;
        a.setLayoutParams(View.getLayoutParams(..));
      L_65:
        c.invalidate();
        c.requestLayout();
        return;
    }

    protected G createSoftInputView(EditText p0) {
        new G(a, p0);
        a.setOnClickListener(this);
        Dialog.setContentView(new G(..));
        return new G(..);
    }

    public final boolean dispatchTouchEvent(MotionEvent p0) {
        d.d();
        if (if-nez(I.d(..))) goto L_17;
        p0.getAction();
        if (if-eq(MotionEvent.getAction(..), 4)) goto L_15;
        if (if-eqz(d)) goto L_17;
      L_15:
        return 1;
      L_17:
        Dialog.dispatchTouchEvent(1);
        return Dialog.dispatchTouchEvent(..);
    }

    public final void onClick(View p0) {
        d.b();
        d.a(I.b(..), 0);
        return;
    }

    public final void onStop() {
        Dialog.onStop();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_020 (orig: J0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_020
package com.unity3d.player;

final class AppClass_020 /* orig: J0 */ {
    private static boolean e;
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;

    J0() {
        new Object();
        a = 0;
        b = 0;
        c = 1;
        d = 0;
        return;
    }

    static boolean d() {
        return J0.e;
    }

    static void e() {
        e = 1;
        return;
    }

    static void f() {
        e = 0;
        return;
    }

    final boolean a() {
        return d;
    }

    final boolean a(boolean p0) {
        if (if-eqz(J0.e)) goto L_15;
        if (if-eqz(p0)) goto L_7;
      L_7:
        if (if-eqz(a)) goto L_15;
      L_b:
        if (if-nez(c)) goto L_15;
        if (if-nez(b)) goto L_15;
      L_15:
      L_16:
        return 0;
    }

    final void b(boolean p0) {
        a = p0;
        return;
    }

    final boolean b() {
        return c;
    }

    final void c(boolean p0) {
        b = p0;
        return;
    }

    final boolean c() {
        return b;
    }

    final void d(boolean p0) {
        d = p0;
        return;
    }

    final void e(boolean p0) {
        c = p0;
        return;
    }

    public final String toString() {
        Object.toString();
        return Object.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_021 (orig: K)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_021
package com.unity3d.player;

final class AppClass_021 /* orig: K */ {
    final M a;

    K(M p0) {
        a = p0;
        new Object();
        return;
    }

    public final void run() {
        c.requestFocus();
        a.f();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_022 (orig: K0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_022
package com.unity3d.player;

public abstract class AppClass_022 /* orig: K0 */ {
}


// ============================================================
// CLASS: com.unity3d.player.AppClass_023 (orig: L)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_023
package com.unity3d.player;

final class AppClass_023 /* orig: L */ extends EditText {
    final I a;
    final M b;

    L(M p0, Context p1, I p2) {
        b = p0;
        a = p2;
        new EditText(p1);
        return;
    }

    public final void onEditorAction(int p0) {
        if (if-ne(p0, 6)) goto L_d;
        a.b();
        a.a(I.b(..), 0);
      L_d:
        return;
    }

    public final boolean onKeyPreIme(int p0, KeyEvent p1) {
        if (if-ne(p0, 4)) goto L_e;
        b.b();
        b.a(I.b(..), 1);
        return 1;
      L_e:
        if (if-ne(b, 84)) goto L_13;
        return 1;
      L_13:
        if (if-ne(b, 66)) goto L_31;
        I.b(..).getAction();
        if (if-nez(KeyEvent.getAction(..))) goto L_31;
        EditText.getInputType();
        if (if-nez(EditText.getInputType(..))) goto L_31;
        a.b();
        a.a(I.b(..), 0);
        return 1;
      L_31:
        EditText.onKeyPreIme(a, 0);
        return EditText.onKeyPreIme(..);
    }

    protected void onSelectionChanged(int p0, int p1) {
        EditText.onSelectionChanged(p0, p1);
        b.reportSoftInputSelection(p0, p1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_024 (orig: L0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_024
package com.unity3d.player;

public final class AppClass_024 /* orig: L0 */ {
    private M0 a;
    private boolean b;

    static void -$$Nest$fputb(L0 p0, boolean p1) {
        b = p1;
        return;
    }

    public L0(M0 p0) {
        new Object();
        a = p0;
        b = 0;
        return;
    }

    public final void run() {
        Thread.sleep(5000L, v1);
        Thread.currentThread();
        Thread.currentThread(..).interrupt();
      L_d:
        if (if-nez(b)) goto L_18;
        a.cancelOnPrepare();
      L_18:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_025 (orig: M)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_025
package com.unity3d.player;

final class AppClass_025 /* orig: M */ extends I {
    private boolean h;
    private Handler i;
    private Runnable j;

    public M(Context p0, UnityPlayer p1) {
        new I(p0, p1);
        h = 0;
        return;
    }

    public final void a(boolean p0) {
        d = p0;
        if (if-eqz(p0)) goto L_8;
      L_8:
      L_b:
        c.setVisibility(0);
        c.invalidate();
        c.requestLayout();
        return;
    }

    public final void c() {
        if (if-eqz(i)) goto L_b;
        if (if-eqz(j)) goto L_b;
        i.removeCallbacks(j);
      L_b:
        b.removeView(c);
        h = 0;
        I.invokeOnClose();
        return;
    }

    protected EditText createEditText(I p0) {
        new L(this, a, p0);
        return new L(..);
    }

    public final boolean d() {
        return 0;
    }

    public final void e() {
        if (if-eqz(h)) goto L_5;
        return;
      L_5:
        b.addView(c);
        b.bringChildToFront(c);
        c.setVisibility(0);
        c.requestFocus();
        new K(this);
        j = new K(..);
        Looper.getMainLooper();
        new Handler(Looper.getMainLooper(..));
        i = new Handler(..);
        new Handler(..).postDelayed(j, 400L, v3);
        h = 1;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_026 (orig: M0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_026
package com.unity3d.player;

public final class AppClass_026 /* orig: M0 */ extends FrameLayout {
    public static final int z;
    private final Context a;
    private final SurfaceView b;
    private final SurfaceHolder c;
    private final String d;
    private final int e;
    private final int f;
    private final boolean g;
    private final long h;
    private final long i;
    private final M0 j;
    private int k;
    private int l;
    private int m;
    private int n;
    private MediaPlayer o;
    private MediaController p;
    private boolean q;
    private boolean r;
    private int s;
    private boolean t;
    private int u;
    private boolean v;
    private K0 w;
    private L0 x;
    private int y;

    protected M0(Context p0, String p1, int p2, int p3, int p4, boolean p5, long p6, long p7, K0 p8) {
        new FrameLayout(p0);
        q = 0;
        r = 0;
        s = 0;
        t = 0;
        u = 0;
        v = 0;
        y = 0;
        w = p8;
        a = p0;
        j = new FrameLayout(..);
        new SurfaceView(p0);
        b = new SurfaceView(..);
        new SurfaceView(..).getHolder();
        c = SurfaceView.getHolder(..);
        SurfaceView.getHolder(..).addCallback(new FrameLayout(..));
        new FrameLayout(..).setBackgroundColor(p2);
        new FrameLayout(..).addView(new SurfaceView(..));
        p0.getSystemService("window");
        Context.getSystemService(..).getDefaultDisplay();
        d = p1;
        e = p3;
        f = p4;
        g = p5;
        h = p6;
        i = p7;
        new FrameLayout(..).setFocusable(1);
        new FrameLayout(..).setFocusableInTouchMode(1);
        return;
    }

    private void a(int p0) {
        y = p0;
        if (if-eqz(w)) goto L_d;
        w.a(y);
      L_d:
        return;
    }

    final boolean a() {
        return t;
    }

    public boolean canPause() {
        return 1;
    }

    public boolean canSeekBackward() {
        return 1;
    }

    public boolean canSeekForward() {
        return 1;
    }

    public void cancelOnPrepare() {
        M0.a(2);
        return;
    }

    protected void destroyPlayer() {
        if (if-nez(t)) goto L_7;
        M0.pause();
      L_7:
        M0.doCleanUp();
        return;
    }

    protected void doCleanUp() {
        if (if-eqz(x)) goto L_b;
        L0.-$$Nest$fputb(x, 1);
        x = 0;
      L_b:
        if (if-eqz(o)) goto L_19;
        o.reset();
        o.release();
        o = 0;
      L_19:
        m = 0;
        n = 0;
        r = 0;
        q = 0;
        return;
    }

    public boolean exitOnKeypress(int p0, KeyEvent p1) {
        if (if-eq(p0, 4)) goto L_13;
        if (if-ne(e, 2)) goto L_11;
        if (if-eqz(p0)) goto L_11;
        p1.isSystem();
        if (if-nez(KeyEvent.isSystem(..))) goto L_11;
      L_11:
        return 0;
      L_13:
        M0.destroyPlayer();
        M0.a(3);
        return 1;
    }

    public int getAudioSessionId() {
        if (if-nez(o)) goto L_6;
      L_6:
        0.getAudioSessionId();
      L_a:
        return MediaPlayer.getAudioSessionId(..);
    }

    public int getBufferPercentage() {
        if (if-eqz(g)) goto L_7;
      L_7:
      L_9:
        return 100;
    }

    public int getCurrentPosition() {
        if (if-nez(o)) goto L_6;
        return 0;
      L_6:
        0.getCurrentPosition();
        return MediaPlayer.getCurrentPosition(..);
    }

    public int getDuration() {
        if (if-nez(o)) goto L_6;
        return 0;
      L_6:
        0.getDuration();
        return MediaPlayer.getDuration(..);
    }

    public boolean isPlaying() {
        if (if-eqz(r)) goto L_c;
        if (if-eqz(q)) goto L_c;
      L_c:
      L_d:
        if (if-nez(o)) goto L_13;
        return 0;
      L_13:
        o.isPlaying();
        if (if-nez(MediaPlayer.isPlaying(..))) goto L_1b;
        if (if-nez(0)) goto L_1c;
      L_1b:
      L_1c:
        return 1;
    }

    public void onBufferingUpdate(MediaPlayer p0, int p1) {
        s = p1;
        return;
    }

    public void onCompletion(MediaPlayer p0) {
        M0.destroyPlayer();
        M0.a(3);
        return;
    }

    public boolean onKeyDown(int p0, KeyEvent p1) {
        M0.exitOnKeypress(p0, p1);
        if (if-eqz(M0.exitOnKeypress(..))) goto L_8;
        return 1;
      L_8:
        if (if-eqz(p)) goto L_11;
        p.onKeyDown(1, p1);
      L_11:
        FrameLayout.onKeyDown(View.onKeyDown(..), p1);
      L_15:
        return FrameLayout.onKeyDown(..);
    }

    public boolean onKeyUp(int p0, KeyEvent p1) {
        M0.exitOnKeypress(p0, p1);
        if (if-eqz(M0.exitOnKeypress(..))) goto L_8;
        return 1;
      L_8:
        if (if-eqz(p)) goto L_11;
        p.onKeyUp(1, p1);
      L_11:
        FrameLayout.onKeyUp(View.onKeyUp(..), p1);
      L_15:
        return FrameLayout.onKeyUp(..);
    }

    public void onPrepared(MediaPlayer p0) {
        if (if-eqz(x)) goto L_b;
        L0.-$$Nest$fputb(x, 1);
        x = 0;
      L_b:
        if (if-eqz(e)) goto L_11;
        if (if-ne(e, 1)) goto L_45;
      L_11:
        new MediaController(a);
        p = new MediaController(..);
        new MediaController(..).setMediaPlayer(this);
        p.setAnchorView(this);
        p.setEnabled(1);
        if (if-eqz(a)) goto L_40;
        a.getWindow();
        Activity.getWindow(..).getDecorView();
        Window.getDecorView(..).getSystemUiVisibility();
        p.setSystemUiVisibility(View.getSystemUiVisibility(..));
      L_40:
        p.show();
      L_45:
        r = 1;
        if (if-eqz(q)) goto L_5f;
        M0.isPlaying();
        if (if-eqz(M0.isPlaying(..))) goto L_52;
      L_52:
        M0.a(1);
        M0.updateVideoLayout();
        if (if-nez(t)) goto L_5f;
        M0.start();
      L_5f:
        return;
    }

    public boolean onTouchEvent(MotionEvent p0) {
        p0.getAction();
        if (if-ne(e, 2)) goto L_16;
        if (if-nez(MotionEvent.getAction(..))) goto L_16;
        M0.destroyPlayer();
        M0.a(3);
        return 1;
      L_16:
        if (if-eqz(p)) goto L_1f;
        p.onTouchEvent(1);
      L_1f:
        FrameLayout.onTouchEvent(MediaController.onTouchEvent(..));
      L_23:
        return FrameLayout.onTouchEvent(..);
    }

    public void onVideoSizeChanged(MediaPlayer p0, int p1, int p2) {
        if (if-eqz(p1)) goto L_24;
        if (if-nez(p2)) goto L_5;
      L_5:
        q = 1;
        m = p1;
        n = p2;
        if (if-eqz(r)) goto L_24;
        M0.isPlaying();
        if (if-eqz(M0.isPlaying(..))) goto L_17;
      L_17:
        M0.a(1);
        M0.updateVideoLayout();
        if (if-nez(t)) goto L_24;
        M0.start();
      L_24:
        return;
    }

    public void pause() {
        if (if-nez(o)) goto L_5;
        return;
      L_5:
        if (if-eqz(v)) goto L_14;
        o.getCurrentPosition();
        u = MediaPlayer.getCurrentPosition(..);
        o.pause();
      L_14:
        t = 1;
        return;
    }

    public void seekTo(int p0) {
        if (if-nez(o)) goto L_5;
        return;
      L_5:
        o.seekTo(p0);
        return;
    }

    public void start() {
        if (if-nez(o)) goto L_5;
        return;
      L_5:
        if (if-eqz(v)) goto L_18;
        if (if-lez(u)) goto L_11;
        o.seekTo(u);
      L_11:
        o.start();
        u = 0;
      L_18:
        t = 0;
        return;
    }

    public void surfaceChanged(SurfaceHolder p0, int p1, int p2, int p3) {
        if (if-ne(k, p2)) goto L_8;
        if (if-eq(l, p3)) goto L_13;
      L_8:
        k = p2;
        l = p3;
        if (if-eqz(v)) goto L_13;
        M0.updateVideoLayout();
      L_13:
        return;
    }

    public void surfaceCreated(SurfaceHolder p0) {
        v = 1;
        if (if-eqz(t)) goto L_1d;
        if (if-eqz(o)) goto L_ff;
        if (if-lez(u)) goto L_ff;
        o.setDisplay(c);
        o.seekTo(u);
      L_1d:
        if (if-eqz(o)) goto L_3d;
        o.setDisplay(c);
        if (if-nez(t)) goto L_ff;
        if (if-lez(u)) goto L_34;
        o.seekTo(u);
      L_34:
        o.start();
        u = 0;
      L_3d:
        M0.a(0);
        M0.doCleanUp();
        new MediaPlayer();
        o = new MediaPlayer(..);
        if (if-eqz(g)) goto L_5a;
        Uri.parse(d);
        new MediaPlayer(..).setDataSource(a, Uri.parse(..));
      L_5a:
        if (if-eqz(i)) goto L_77;
        new FileInputStream(d);
        new FileInputStream(..).getFD();
        o.setDataSource(FileInputStream.getFD(..), h, v5, i, v7);
      L_77:
        View.getResources();
        View.getResources(..).getAssets();
        Resources.getAssets(..).openFd(d);
        AssetManager.openFd(..).getFileDescriptor();
        AssetManager.openFd(..).getStartOffset();
        AssetManager.openFd(..).getLength();
        o.setDataSource(AssetFileDescriptor.getFileDescriptor(..), AssetFileDescriptor.getStartOffset(..), h, AssetFileDescriptor.getLength(..), i);
        AssetManager.openFd(..).close();
        new FileInputStream(d);
        new FileInputStream(..).getFD();
        o.setDataSource(FileInputStream.getFD(..));
      L_aa:
        new FileInputStream(..).close();
      L_ad:
        o.setDisplay(c);
        o.setScreenOnWhilePlaying(o);
        o.setOnBufferingUpdateListener(this);
        o.setOnCompletionListener(this);
        o.setOnPreparedListener(this);
        o.setOnVideoSizeChangedListener(this);
        new AudioAttributes$Builder();
        new AudioAttributes$Builder(..).setUsage(o);
        AudioAttributes$Builder.setUsage(..).setContentType(3);
        AudioAttributes$Builder.build();
        o.setAudioAttributes(AudioAttributes$Builder.build(..));
        o.prepareAsync();
        new L0(this);
        x = new L0(..);
        new Thread(x);
        new Thread(..).start();
        M0.a(2);
      L_ff:
        return;
    }

    public void surfaceDestroyed(SurfaceHolder p0) {
        v = 0;
        return;
    }

    protected void updateVideoLayout() {
        if (if-nez(o)) goto L_5;
        return;
      L_5:
        a.getSystemService("window");
        new DisplayMetrics();
        Context.getSystemService(..).getDefaultDisplay();
        WindowManager.getDefaultDisplay(..).getMetrics(new DisplayMetrics(..));
        if (if-lez(widthPixels)) goto L_27;
        if (if-lez(heightPixels)) goto L_27;
        k = widthPixels;
        l = heightPixels;
      L_27:
        if (if-eqz(q)) goto L_55;
        if (if-ne(f, 1)) goto L_44;
        if (if-gtz(m)) goto L_4f;
      L_44:
        if (if-ne(f, 2)) goto L_52;
        if (if-ltz(m)) goto L_4f;
      L_4b:
      L_4f:
      L_52:
        if (if-nez(f)) goto L_55;
      L_55:
      L_56:
      L_57:
        if (if-ne(k, k)) goto L_5b;
        if (if-eq(l, l)) goto L_69;
      L_5b:
        new FrameLayout$LayoutParams(k, l, 17);
        j.updateViewLayout(b, new FrameLayout$LayoutParams(..));
      L_69:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.MultiWindowSupport
// ============================================================
package com.unity3d.player;

public class MultiWindowSupport {
    private static boolean s_LastMultiWindowMode;

    public MultiWindowSupport() {
        new Object();
        return;
    }

    public static boolean isInMultiWindowMode(Activity p0) {
        if (if-nez(p0)) goto L_4;
        return 0;
      L_4:
        if (if-eqz(PlatformSupport.NOUGAT_SUPPORT)) goto L_d;
        p0.isInMultiWindowMode();
        return Activity.isInMultiWindowMode(..);
      L_d:
        return 0;
    }

    public static boolean isMultiWindowModeChangedToTrue(Activity p0) {
        if (if-nez(MultiWindowSupport.s_LastMultiWindowMode)) goto L_c;
        MultiWindowSupport.isInMultiWindowMode(p0);
        if (if-eqz(MultiWindowSupport.isInMultiWindowMode(..))) goto L_c;
      L_c:
      L_d:
        return 0;
    }

    public static void saveMultiWindowMode(Activity p0) {
        MultiWindowSupport.isInMultiWindowMode(p0);
        s_LastMultiWindowMode = MultiWindowSupport.isInMultiWindowMode(..);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_027 (orig: N)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_027
package com.unity3d.player;

final class AppClass_027 /* orig: N */ {
    final S a;

    N(S p0) {
        a = p0;
        new Object();
        return;
    }

    public final void onDismiss(DialogInterface p0) {
        a.invokeOnClose();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_028 (orig: N0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_028
package com.unity3d.player;

final class AppClass_028 /* orig: N0 */ {
    final O0 a;

    N0(O0 p0) {
        a = p0;
        new Object();
        return;
    }

    public final void run() {
        U0.-$$Nest$fgetf(h);
        if (if-eqz(U0.-$$Nest$fgetf(..))) goto L_2d;
        U0.-$$Nest$fgeta(h);
        U0.-$$Nest$fgeta(..).removeViewFromPlayer(U0.-$$Nest$fgetf(..));
        U0.-$$Nest$fputi(h, 0);
        U0.-$$Nest$fgetf(h);
        U0.-$$Nest$fgetf(..).destroyPlayer();
        U0.-$$Nest$fputf(h, 0);
        U0.-$$Nest$fgetc(h);
        if (if-eqz(U0.-$$Nest$fgetc(..))) goto L_2d;
        U0.-$$Nest$fgetc(..).a();
      L_2d:
        U0.-$$Nest$fgeta(h);
        U0.-$$Nest$fgeta(..).onResume();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.NativeLoader
// ============================================================
package com.unity3d.player;

public abstract class NativeLoader {
    static final boolean load(String p0) {
        // native or abstract
    }

    static final boolean unload() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.player.NetworkConnectivity
// ============================================================
package com.unity3d.player;

public class NetworkConnectivity extends Activity {
    protected ConnectivityManager a;

    public NetworkConnectivity(Context p0) {
        new Activity();
        p0.getSystemService("connectivity");
        a = Context.getSystemService(..);
        if (if-nez(Context.getSystemService(..))) goto L_15;
        t.Log(6, "NetworkConnectivity: ConnectivityManager not found");
      L_15:
        return;
    }

    public void a() {
        return;
    }

    public int b() {
        if (if-nez(a)) goto L_6;
        return 0;
      L_6:
        if (if-eqz(PlatformSupport.MARSHMALLOW_SUPPORT)) goto L_24;
        a.getActiveNetwork();
        if (if-nez(ConnectivityManager.getActiveNetwork(..))) goto L_13;
        return 0;
      L_13:
        a.getNetworkCapabilities(ConnectivityManager.getActiveNetwork(..));
        if (if-eqz(ConnectivityManager.getNetworkCapabilities(..))) goto L_39;
        NetworkCapabilities.hasTransport(0);
        if (if-eqz(NetworkCapabilities.hasTransport(..))) goto L_22;
      L_22:
      L_23:
        return 2;
      L_24:
        NetworkCapabilities.hasTransport(..).getActiveNetworkInfo();
        if (if-eqz(ConnectivityManager.getActiveNetworkInfo(..))) goto L_39;
        NetworkInfo.isConnected();
        if (if-eqz(NetworkInfo.isConnected(..))) goto L_39;
        NetworkInfo.getType();
        if (if-nez(NetworkInfo.getType(..))) goto L_37;
      L_37:
      L_38:
        return 2;
      L_39:
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.player.NetworkConnectivityNougat
// ============================================================
package com.unity3d.player;

public class NetworkConnectivityNougat extends NetworkConnectivity {
    private int b;
    private final ConnectivityManager$NetworkCallback c;

    static void -$$Nest$fputb(NetworkConnectivityNougat p0, int p1) {
        b = p1;
        return;
    }

    public NetworkConnectivityNougat(Context p0) {
        new NetworkConnectivity(p0);
        b = 0;
        new u(new NetworkConnectivity(..));
        c = new u(..);
        if (if-nez(a)) goto L_12;
        return;
      L_12:
        new NetworkConnectivity(..).b();
        b = NetworkConnectivity.b(..);
        a.registerDefaultNetworkCallback(new u(..));
        return;
    }

    public final void a() {
        if (if-nez(a)) goto L_5;
        return;
      L_5:
        a.unregisterNetworkCallback(c);
        return;
    }

    public final int b() {
        return b;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_029 (orig: O)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_029
package com.unity3d.player;

final class AppClass_029 /* orig: O */ {
    final S a;

    O(S p0) {
        a = p0;
        new Object();
        return;
    }

    public final void onGlobalLayout() {
        a.reportSoftInputArea();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_030 (orig: O0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_030
package com.unity3d.player;

final class AppClass_030 /* orig: O0 */ {
    final P0 a;

    O0(P0 p0) {
        a = p0;
        new Object();
        return;
    }

    public final void a(int p0) {
        U0.-$$Nest$fgete(h);
        U0.-$$Nest$fgete(..).lock();
        U0.-$$Nest$fputg(h, p0);
        if (if-ne(p0, 3)) goto L_23;
        U0.-$$Nest$fgeti(h);
        if (if-eqz(U0.-$$Nest$fgeti(..))) goto L_23;
        new N0(this);
        h.runOnUiThread(new N0(..));
      L_23:
        if (if-eqz(p0)) goto L_30;
        U0.-$$Nest$fgetd(h);
        U0.-$$Nest$fgetd(..).release();
      L_30:
        U0.-$$Nest$fgete(h);
        U0.-$$Nest$fgete(..).unlock();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.OrientationLockListener
// ============================================================
package com.unity3d.player;

public class OrientationLockListener {
    private V a;
    private Context b;

    OrientationLockListener(Context p0) {
        new Object();
        b = p0;
        new V(p0);
        a = new V(..);
        p0.getContentResolver();
        Settings$System.getInt(Context.getContentResolver(..), "accelerometer_rotation", 0);
        new Object(..).nativeUpdateOrientationLockState(Settings$System.getInt(..));
        a.a(new Object(..));
        return;
    }

    public final void a() {
        a.a();
        a = 0;
        return;
    }

    public final void b() {
        b.getContentResolver();
        Settings$System.getInt(Context.getContentResolver(..), "accelerometer_rotation", 0);
        OrientationLockListener.nativeUpdateOrientationLockState(Settings$System.getInt(..));
        return;
    }

    public final void nativeUpdateOrientationLockState(int p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_031 (orig: P)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_031
package com.unity3d.player;

final class AppClass_031 /* orig: P */ {
    final S a;

    P(S p0) {
        a = p0;
        new Object();
        return;
    }

    public final void onCancel(DialogInterface p0) {
        if (if-eqz(f)) goto L_b;
        f.a();
      L_b:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_032 (orig: P0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_032
package com.unity3d.player;

final class AppClass_032 /* orig: P0 */ {
    final String a;
    final int b;
    final int c;
    final int d;
    final boolean e;
    final long f;
    final long g;
    final U0 h;

    P0(U0 p0, String p1, int p2, int p3, int p4, boolean p5, long p6, long p7) {
        h = p0;
        a = p1;
        b = p2;
        c = p3;
        d = p4;
        e = p5;
        f = p6;
        g = p7;
        new Object();
        return;
    }

    public final void run() {
        U0.-$$Nest$fgetf(h);
        if (if-eqz(U0.-$$Nest$fgetf(..))) goto L_1c;
        t.Log(5, "Video already playing");
        U0.-$$Nest$fputg(h, 2);
        U0.-$$Nest$fgetd(h);
        U0.-$$Nest$fgetd(..).release();
        return;
      L_1c:
        U0.-$$Nest$fgetb(h);
        new O0(this);
        new M0(U0.-$$Nest$fgetb(..), a, b, c, d, e, f, v9, g, v11, new O0(..));
        U0.-$$Nest$fputf(U0.-$$Nest$fgetd(..), new M0);
        U0.-$$Nest$fgetf(h);
        if (if-eqz(U0.-$$Nest$fgetf(..))) goto L_5a;
        U0.-$$Nest$fgeta(h);
        U0.-$$Nest$fgeta(..).bringToFront();
        U0.-$$Nest$fgeta(h);
        U0.-$$Nest$fgetf(h);
        U0.-$$Nest$fgeta(..).addView(U0.-$$Nest$fgetf(..));
      L_5a:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.PermissionFragment
// ============================================================
package com.unity3d.player;

public class PermissionFragment extends Fragment {
    public static final String PERMISSION_NAMES = "PermissionNames";
    public static final int UNITY_PERMISSION_REQUEST_CODE = 96489;
    private final Activity m_Activity;
    private final Looper m_Looper;
    private final IPermissionRequestCallbacks m_ResultCallbacks;

    static void -$$Nest$mreportAllDenied(PermissionFragment p0, String[] p1) {
        p0.reportAllDenied(p1);
        return;
    }

    public PermissionFragment() {
        new Fragment();
        m_ResultCallbacks = 0;
        m_Activity = 0;
        m_Looper = 0;
        return;
    }

    public PermissionFragment(Activity p0, IPermissionRequestCallbacks p1) {
        new Fragment();
        m_ResultCallbacks = p1;
        m_Activity = p0;
        Looper.myLooper();
        m_Looper = Looper.myLooper(..);
        return;
    }

    private void reportAllDenied(String[] p0) {
      L_2:
        if (if-ge(0, v0)) goto L_e;
        m_ResultCallbacks.onPermissionDenied(v2);
      L_e:
        return;
    }

    public void onCreate(Bundle p0) {
        Fragment.onCreate(p0);
        Fragment.getArguments();
        Fragment.getArguments(..).getStringArray("PermissionNames");
        Fragment.requestPermissions(Bundle.getStringArray(..), 96489);
        return;
    }

    public void onRequestPermissionsResult(int p0, String[] p1, int[] p2) {
        if (if-eq(p0, 96489)) goto L_6;
        return;
      L_6:
        if (if-nez(p0)) goto L_39;
        if (if-eqz(m_ResultCallbacks)) goto L_7a;
        if (if-eqz(m_Activity)) goto L_7a;
        if (if-eqz(m_Looper)) goto L_7a;
        Fragment.getArguments();
        Fragment.getArguments(..).getStringArray("PermissionNames");
        if (if-eqz(m_ResultCallbacks)) goto L_29;
        PermissionFragment.reportAllDenied(Bundle.getStringArray(..));
      L_29:
        new Handler(m_Looper);
        new y(this, Bundle.getStringArray(..));
        new Handler(..).post(new y(..));
      L_39:
      L_3a:
        if (if-ge(0, 96489)) goto L_7a;
        if (if-ge(0, 96489)) goto L_7a;
        if (if-eqz(m_ResultCallbacks)) goto L_77;
        if (if-eqz(m_Activity)) goto L_77;
        if (if-eqz(m_Looper)) goto L_77;
        if (if-eqz(m_Looper)) goto L_58;
        m_ResultCallbacks.onPermissionGranted(m_Looper);
      L_58:
        if (if-nez(m_ResultCallbacks)) goto L_5e;
      L_5e:
        new Handler(m_Looper);
        m_Activity.shouldShowRequestPermissionRationale("<null>");
        new z(m_ResultCallbacks, "<null>", v4, Activity.shouldShowRequestPermissionRationale(..));
        new Handler(..).post(new z(..));
      L_77:
      L_7a:
        Fragment.getActivity();
        Fragment.getActivity(..).getFragmentManager();
        Activity.getFragmentManager(..).beginTransaction();
        FragmentManager.beginTransaction(..).remove(this);
        FragmentManager.beginTransaction(..).commit();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.PlatformSupport
// ============================================================
package com.unity3d.player;

public class PlatformSupport {
    static final boolean MARSHMALLOW_SUPPORT;
    static final boolean NOUGAT_SUPPORT;
    static final boolean PIE_SUPPORT;
    static final boolean RED_VELVET_CAKE_SUPPORT;
    static final boolean SNOW_CONE_SUPPORT;
    static final boolean TIRAMISU_SUPPORT;
    static final boolean UPSIDE_DOWN_CAKE_SUPPORT;
    static final boolean VANILLA_ICE_CREAM_SUPPORT;

    static <clinit>() {
        MARSHMALLOW_SUPPORT = 1;
        if (if-lt(Build$VERSION.SDK_INT, 24)) goto L_c;
      L_c:
      L_d:
        NOUGAT_SUPPORT = 0;
        if (if-lt(Build$VERSION.SDK_INT, 28)) goto L_15;
      L_15:
      L_16:
        PIE_SUPPORT = 0;
        if (if-lt(Build$VERSION.SDK_INT, 30)) goto L_1e;
      L_1e:
      L_1f:
        RED_VELVET_CAKE_SUPPORT = 0;
        if (if-lt(Build$VERSION.SDK_INT, 31)) goto L_27;
      L_27:
      L_28:
        SNOW_CONE_SUPPORT = 0;
        if (if-lt(Build$VERSION.SDK_INT, 33)) goto L_30;
      L_30:
      L_31:
        TIRAMISU_SUPPORT = 0;
        if (if-lt(Build$VERSION.SDK_INT, 34)) goto L_39;
      L_39:
      L_3a:
        UPSIDE_DOWN_CAKE_SUPPORT = 0;
        if (if-lt(Build$VERSION.SDK_INT, 35)) goto L_41;
      L_41:
      L_42:
        VANILLA_ICE_CREAM_SUPPORT = 0;
        return;
    }

    public PlatformSupport() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.PlayAssetDeliveryUnityWrapper
// ============================================================
package com.unity3d.player;

class PlayAssetDeliveryUnityWrapper {
    private static PlayAssetDeliveryUnityWrapper b;
    private i a;

    private PlayAssetDeliveryUnityWrapper(Context p0) {
        new Object();
        a = 0;
        if (if-nez(PlayAssetDeliveryUnityWrapper.b)) goto L_3d;
        new Object(..).getClass();
        Object.getClass(..).getClassLoader();
        Class.getClassLoader(..).loadClass("com.google.android.play.core.assetpacks.AssetPackManager");
        ClassLoader.loadClass(..).getMethod("getPackStates", 1);
        Class.getMethod(..).getReturnType();
        Method.getReturnType(..).getName();
        Class.getName(..).equals("com.google.android.gms.tasks.Task");
        if (if-eqz(String.equals(..))) goto L_3c;
        PlayAssetDeliveryUnityWrapper.a(p0);
        a = PlayAssetDeliveryUnityWrapper.a(..);
      L_3c:
        return;
      L_3d:
        new RuntimeException("PlayAssetDeliveryUnityWrapper should be created only once. Use getInstance() instead.");
        throw new RuntimeException(..);
    }

    private static i a(Context p0) {
        i.a(p0);
        return i.a(..);
    }

    private void a() {
        PlayAssetDeliveryUnityWrapper.playCoreApiMissing();
        if (if-nez(PlayAssetDeliveryUnityWrapper.playCoreApiMissing(..))) goto L_7;
        return;
      L_7:
        new RuntimeException("AssetPackManager API is not available! Make sure your gradle project includes 'com.google.android.play:asset-delivery' dependency.");
        throw new RuntimeException(..);
    }

    public static PlayAssetDeliveryUnityWrapper getInstance() {
      L_3:
        if (if-nez(PlayAssetDeliveryUnityWrapper.b)) goto L_19;
        PlayAssetDeliveryUnityWrapper.class.wait(3000L, v3);
        PlayAssetDeliveryUnityWrapper.class.getMessage();
        t.Log(6, Throwable.getMessage(..));
      L_19:
        if (if-eqz(Throwable.getMessage(..))) goto L_1d;
        return Throwable.getMessage(..);
      L_1d:
        new RuntimeException("PlayAssetDeliveryUnityWrapper is not yet initialised.");
        throw new RuntimeException(..);
        throw new RuntimeException(..);
    }

    public static PlayAssetDeliveryUnityWrapper init(Context p0) {
        if (if-nez(PlayAssetDeliveryUnityWrapper.b)) goto L_17;
        new PlayAssetDeliveryUnityWrapper(p0);
        b = new PlayAssetDeliveryUnityWrapper(..);
        PlayAssetDeliveryUnityWrapper.class.notifyAll();
        return PlayAssetDeliveryUnityWrapper.b;
      L_17:
        new RuntimeException("PlayAssetDeliveryUnityWrapper.init() should be called only once. Use getInstance() instead.");
        throw new RuntimeException(..);
        throw new RuntimeException(..);
    }

    public void cancelAssetPackDownload(String p0) {
        PlayAssetDeliveryUnityWrapper.cancelAssetPackDownloads(1);
        return;
    }

    public void cancelAssetPackDownloads(String[] p0) {
        PlayAssetDeliveryUnityWrapper.a();
        a.a(p0);
        return;
    }

    public void downloadAssetPack(String p0, IAssetPackManagerDownloadStatusCallback p1) {
        PlayAssetDeliveryUnityWrapper.downloadAssetPacks(1, p1);
        return;
    }

    public void downloadAssetPacks(String[] p0, IAssetPackManagerDownloadStatusCallback p1) {
        PlayAssetDeliveryUnityWrapper.a();
        a.a(p0, p1);
        return;
    }

    public String getAssetPackPath(String p0) {
        PlayAssetDeliveryUnityWrapper.a();
        a.a(p0);
        return i.a(..);
    }

    public void getAssetPackState(String p0, IAssetPackManagerStatusQueryCallback p1) {
        PlayAssetDeliveryUnityWrapper.getAssetPackStates(1, p1);
        return;
    }

    public void getAssetPackStates(String[] p0, IAssetPackManagerStatusQueryCallback p1) {
        PlayAssetDeliveryUnityWrapper.a();
        a.a(p0, p1);
        return;
    }

    public boolean playCoreApiMissing() {
        if (if-nez(a)) goto L_6;
      L_6:
      L_7:
        return 0;
    }

    public Object registerDownloadStatusListener(IAssetPackManagerDownloadStatusCallback p0) {
        PlayAssetDeliveryUnityWrapper.a();
        a.a(p0);
        return i.a(..);
    }

    public void removeAssetPack(String p0) {
        PlayAssetDeliveryUnityWrapper.a();
        a.b(p0);
        return;
    }

    public void requestToUseMobileData(Activity p0, IAssetPackManagerMobileDataConfirmationCallback p1) {
        PlayAssetDeliveryUnityWrapper.a();
        a.a(p0, p1);
        return;
    }

    public void unregisterDownloadStatusListener(Object p0) {
        PlayAssetDeliveryUnityWrapper.a();
        a.a(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_033 (orig: Q)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_033
package com.unity3d.player;

final class AppClass_033 /* orig: Q */ extends EditText {
    final I a;

    Q(Context p0, I p1) {
        a = p1;
        new EditText(p0);
        return;
    }

    public final boolean onKeyPreIme(int p0, KeyEvent p1) {
        if (if-ne(p0, 4)) goto L_e;
        a.b();
        a.a(I.b(..), 1);
        return 1;
      L_e:
        if (if-ne(a, 84)) goto L_13;
        return 1;
      L_13:
        if (if-ne(a, 66)) goto L_31;
        I.b(..).getAction();
        if (if-nez(KeyEvent.getAction(..))) goto L_31;
        EditText.getInputType();
        if (if-nez(EditText.getInputType(..))) goto L_31;
        a.b();
        a.a(I.b(..), 0);
        return 1;
      L_31:
        if (if-ne(a, 111)) goto L_45;
        0.getAction();
        if (if-nez(KeyEvent.getAction(..))) goto L_45;
        a.b();
        a.a(I.b(..), 1);
        return 1;
      L_45:
        EditText.onKeyPreIme(a, I.b(..));
        return EditText.onKeyPreIme(..);
    }

    public final void onWindowFocusChanged(boolean p0) {
        EditText.onWindowFocusChanged(p0);
        if (if-eqz(p0)) goto L_d;
        View.requestFocus();
        a.f();
      L_d:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_034 (orig: Q0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_034
package com.unity3d.player;

final class AppClass_034 /* orig: Q0 */ {
    final U0 a;

    Q0(U0 p0) {
        a = p0;
        new Object();
        return;
    }

    public final void run() {
        U0.-$$Nest$fgeta(a);
        U0.-$$Nest$fgeta(..).onPause();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_035 (orig: R0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_035
package com.unity3d.player;

final class AppClass_035 /* orig: R0 */ {
    final U0 a;

    R0(U0 p0) {
        a = p0;
        new Object();
        return;
    }

    public final void run() {
        U0.-$$Nest$fgetf(a);
        if (if-eqz(U0.-$$Nest$fgetf(..))) goto L_1c;
        U0.-$$Nest$fgeta(a);
        U0.-$$Nest$fgeta(..).addViewToPlayer(U0.-$$Nest$fgetf(..), 1);
        U0.-$$Nest$fputi(a, 1);
        U0.-$$Nest$fgetf(a);
        U0.-$$Nest$fgetf(..).requestFocus();
      L_1c:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.ReflectionHelper
// ============================================================
package com.unity3d.player;

final class ReflectionHelper {
    protected static boolean LOG;
    protected static final boolean LOGV;
    private static D[] a;
    private static long b;
    private static long c;
    private static boolean d;

    static long -$$Nest$sfgetb() {
        return ReflectionHelper.b;
    }

    static void -$$Nest$smnativeProxyFinalize(long p0) {
        ReflectionHelper.nativeProxyFinalize(p0, v1);
        return;
    }

    static Object -$$Nest$smnativeProxyInvoke(long p0, String p1, Object[] p2) {
        ReflectionHelper.nativeProxyInvoke(p0, v1, p1, p2);
        return ReflectionHelper.nativeProxyInvoke(..);
    }

    static void -$$Nest$smnativeProxyJNIFreeGCHandle(long p0) {
        ReflectionHelper.nativeProxyJNIFreeGCHandle(p0, v1);
        return;
    }

    static void -$$Nest$smnativeProxyLogJNIInvokeException(long p0) {
        ReflectionHelper.nativeProxyLogJNIInvokeException(p0, v1);
        return;
    }

    static <clinit>() {
        a = 4096;
        return;
    }

    private static float a(Class p0, Class[] p1, Class[] p2) {
        if (if-nez(v0)) goto L_7;
        return 1036831949;
      L_7:
        if (if-nez(p1)) goto L_c;
      L_c:
      L_d:
        if (if-eq(0, v3)) goto L_14;
        return 0;
      L_14:
        if (if-eqz(p1)) goto L_4f;
      L_1d:
        if (if-ge(0, v5)) goto L_50;
        Object.equals(0);
        if (if-eqz(Object.equals(..))) goto L_2d;
      L_2d:
        Class.isPrimitive();
        if (if-nez(Class.isPrimitive(..))) goto L_49;
        1.0f.isPrimitive();
        if (if-nez(Class.isPrimitive(..))) goto L_49;
        Class.asSubclass(1.0f);
        if (if-eqz(Class.asSubclass(..))) goto L_41;
      L_41:
        0.5f.asSubclass(v8);
        if (if-eqz(Class.asSubclass(..))) goto L_49;
      L_49:
      L_4a:
      L_4f:
      L_50:
        p0.equals(p1);
        if (if-eqz(Object.equals(..))) goto L_5d;
      L_5d:
        p0.isPrimitive();
        if (if-nez(Class.isPrimitive(..))) goto L_78;
        p1.isPrimitive();
        if (if-nez(Class.isPrimitive(..))) goto L_78;
        p0.asSubclass(p1);
        if (if-eqz(Class.asSubclass(..))) goto L_71;
      L_71:
        p1.asSubclass(p0);
        if (if-eqz(Class.asSubclass(..))) goto L_78;
      L_78:
      L_79:
        return 1.0f;
    }

    private static Class a(String p0, int[] p1) {
      L_0:
        p0.length();
        if (if-ge(v1, String.length(..))) goto L_ac;
        p0.charAt(v1);
        if (if-ne(String.charAt(..), 40)) goto L_18;
      L_18:
        if (if-ne(String.charAt(..), 41)) goto L_1d;
      L_1d:
        if (if-ne(String.charAt(..), 76)) goto L_45;
        p0.indexOf(59, String.charAt(..));
        if (if-ne(String.indexOf(..), -1)) goto L_2e;
      L_2e:
        p0.substring(-1, String.indexOf(..));
        String.substring(..).replace(47, 46);
        Class.forName(String.replace(..));
        return Class.forName(..);
      L_45:
        if (if-ne(String.indexOf(..), 90)) goto L_4c;
        return Boolean.TYPE;
      L_4c:
        if (if-ne(String.indexOf(..), 73)) goto L_53;
        return Integer.TYPE;
      L_53:
        if (if-ne(String.indexOf(..), 70)) goto L_5a;
        return Float.TYPE;
      L_5a:
        if (if-ne(String.indexOf(..), 86)) goto L_61;
        return Void.TYPE;
      L_61:
        if (if-ne(String.indexOf(..), 66)) goto L_68;
        return Byte.TYPE;
      L_68:
        if (if-ne(String.indexOf(..), 67)) goto L_6f;
        return Character.TYPE;
      L_6f:
        if (if-ne(String.indexOf(..), 83)) goto L_76;
        return Short.TYPE;
      L_76:
        if (if-ne(String.indexOf(..), 74)) goto L_7d;
        return Long.TYPE;
      L_7d:
        if (if-ne(String.indexOf(..), 68)) goto L_84;
        return Double.TYPE;
      L_84:
        if (if-ne(String.indexOf(..), 91)) goto L_95;
        ReflectionHelper.a(Double.TYPE, 47);
        Array.newInstance(ReflectionHelper.a(..), 46);
        Array.newInstance(..).getClass();
        return Object.getClass(..);
      L_95:
        new StringBuilder("! parseType; ");
        new StringBuilder(..).append(String.indexOf(..));
        new StringBuilder(..).append(" is not known!");
        new StringBuilder(..).toString();
        t.Log(5, StringBuilder.toString(..));
      L_ac:
        return 0;
    }

    private static boolean a(D p0) {
        D.-$$Nest$fgetd(p0);
        p0.equals(ReflectionHelper.a);
        if (if-nez(D.equals(..))) goto L_16;
        return 0;
      L_16:
        e = e;
        return 1;
        throw 1;
    }

    private static Class[] a(String p0) {
        new ArrayList();
      L_b:
        p0.length();
        if (if-ge(v3, String.length(..))) goto L_1e;
        ReflectionHelper.a(p0, 1);
        if (if-nez(ReflectionHelper.a(..))) goto L_1a;
      L_1a:
        new ArrayList(..).add(ReflectionHelper.a(..));
      L_1e:
        new ArrayList(..).size();
        new ArrayList(..).iterator();
      L_28:
        ArrayList.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_3a;
        ArrayList.iterator(..).next();
      L_3a:
        return ArrayList.size(..);
    }

    protected static boolean beginProxyCall(long p0) {
        if (if-nez(p0)) goto L_13;
        c = ReflectionHelper.c;
        return 1;
      L_13:
        return 0;
        throw 0;
    }

    protected static Object createInvocationError(long p0, boolean p1) {
        new E(p0, v2, p1);
        return new E(..);
    }

    protected static void endProxyCall() {
        c = ReflectionHelper.c;
        if (if-nez(ReflectionHelper.c)) goto L_19;
        if (if-eqz(ReflectionHelper.d)) goto L_19;
        ReflectionHelper.class.notifyAll();
      L_19:
        return;
        throw ReflectionHelper.class;
    }

    protected static void endUnityLaunch() {
        b = ReflectionHelper.b;
        d = 1;
      L_d:
        if (if-lez(ReflectionHelper.c)) goto L_23;
        ReflectionHelper.class.wait();
        t.Log(6, "Interrupted while waiting for all proxies to exit.");
      L_23:
        d = 0;
        return;
      L_28:
        throw 0;
    }

    protected static Constructor getConstructorID(Class p0, String p1) {
        new D(p0, "", p1);
        ReflectionHelper.a(new D(..));
        if (if-eqz(ReflectionHelper.a(..))) goto L_12;
      L_12:
        ReflectionHelper.a(p1);
        p0.getConstructors();
      L_1e:
        if (if-ge(0, v3)) goto L_3d;
        Constructor.getParameterTypes();
        ReflectionHelper.a(Void.TYPE, Constructor.getParameterTypes(..), ReflectionHelper.a(..));
        if (if-lez(Constructor.getParameterTypes(..))) goto L_3a;
        if (if-nez(1.0f)) goto L_38;
      L_38:
      L_3a:
      L_3d:
        e = v7;
        D.-$$Nest$fgetd(e);
      L_4e:
        if (if-eqz(v7)) goto L_51;
        return v7;
      L_51:
        new StringBuilder("<init>");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(" in class ");
        p0.getName();
        new StringBuilder(..).append(Class.getName(..));
        new StringBuilder(..).toString();
        new NoSuchMethodError(StringBuilder.toString(..));
        throw new NoSuchMethodError(..);
        throw StringBuilder.toString(..);
    }

    protected static Field getFieldID(Class p0, String p1, String p2, boolean p3) {
        new D(p0, p1, p2);
        ReflectionHelper.a(new D(..));
        if (if-eqz(ReflectionHelper.a(..))) goto L_1a;
      L_1a:
        ReflectionHelper.a(p2);
      L_21:
        if (if-eqz(p0)) goto L_83;
        p0.getDeclaredFields();
      L_29:
        if (if-ge(0, v11)) goto L_5c;
        Field.getModifiers();
        Modifier.isStatic(Field.getModifiers(..));
        if (if-eq(p3, Modifier.isStatic(..))) goto L_3a;
      L_3a:
        Field.getName();
        Field.getName(..).compareTo(p1);
        if (if-eqz(String.compareTo(..))) goto L_45;
      L_45:
        Field.getType();
        ReflectionHelper.a(Field.getType(..), 0, ReflectionHelper.a(..));
        if (if-lez(v16)) goto L_59;
        if (if-nez(0)) goto L_58;
      L_58:
      L_59:
      L_5c:
        if (if-nez(Class.getDeclaredFields(..))) goto L_61;
      L_61:
        p0.isPrimitive();
        if (if-nez(Class.isPrimitive(..))) goto L_83;
        p0.isInterface();
        if (if-nez(Class.isInterface(..))) goto L_83;
        p0.equals(Object.class);
        if (if-nez(Object.equals(..))) goto L_83;
        p0.equals(Void.TYPE);
        if (if-eqz(Object.equals(..))) goto L_7e;
      L_7e:
        p0.getSuperclass();
      L_83:
        e = v14;
        D.-$$Nest$fgetd(e);
      L_94:
        if (if-nez(v14)) goto L_bb;
        if (if-eqz(p3)) goto L_a2;
      L_a2:
      L_a4:
        Class.getSuperclass(..).getName();
        String.format("no %s field with name='%s' signature='%s' in class L%s;", 4);
        new NoSuchFieldError(String.format(..));
        throw new NoSuchFieldError(..);
      L_bb:
        return new NoSuchFieldError(..);
        throw String.format(..);
    }

    protected static String getFieldSignature(Field p0) {
        p0.getType();
        Field.getType(..).isPrimitive();
        if (if-eqz(Class.isPrimitive(..))) goto L_66;
        Field.getType(..).getName();
        "boolean".equals(Class.getName(..));
        if (if-eqz(String.equals(..))) goto L_19;
        return "Z";
      L_19:
        "byte".equals("Z");
        if (if-eqz(String.equals(..))) goto L_24;
        return "B";
      L_24:
        "char".equals("B");
        if (if-eqz(String.equals(..))) goto L_2f;
        return "C";
      L_2f:
        "double".equals("C");
        if (if-eqz(String.equals(..))) goto L_3a;
        return "D";
      L_3a:
        "float".equals("D");
        if (if-eqz(String.equals(..))) goto L_45;
        return "F";
      L_45:
        "int".equals("F");
        if (if-eqz(String.equals(..))) goto L_50;
        return "I";
      L_50:
        "long".equals("I");
        if (if-eqz(String.equals(..))) goto L_5b;
        return "J";
      L_5b:
        "short".equals("J");
        if (if-eqz(String.equals(..))) goto L_65;
      L_65:
        return "S";
      L_66:
        "S".isArray();
        if (if-eqz(Class.isArray(..))) goto L_79;
        "S".getName();
        Class.getName(..).replace(46, 47);
        return String.replace(..);
      L_79:
        new StringBuilder("L");
        String.replace(..).getName();
        Class.getName(..).replace(46, 47);
        new StringBuilder(..).append(String.replace(..));
        new StringBuilder(..).append(";");
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    protected static Method getMethodID(Class p0, String p1, String p2, boolean p3) {
        new D(p0, p1, p2);
        ReflectionHelper.a(new D(..));
        if (if-eqz(ReflectionHelper.a(..))) goto L_12;
      L_12:
        ReflectionHelper.a(p2);
      L_18:
        if (if-eqz(p0)) goto L_7f;
        p0.getDeclaredMethods();
      L_20:
        if (if-ge(0, v6)) goto L_58;
        Method.getModifiers();
        Modifier.isStatic(Method.getModifiers(..));
        if (if-eq(p3, Modifier.isStatic(..))) goto L_31;
      L_31:
        Method.getName();
        Method.getName(..).compareTo(p1);
        if (if-eqz(String.compareTo(..))) goto L_3c;
      L_3c:
        Method.getReturnType();
        Method.getParameterTypes();
        ReflectionHelper.a(Method.getReturnType(..), Method.getParameterTypes(..), ReflectionHelper.a(..));
        if (if-lez(Method.getParameterTypes(..))) goto L_55;
        if (if-nez(0)) goto L_53;
      L_53:
      L_55:
      L_58:
        if (if-nez(Class.getDeclaredMethods(..))) goto L_5d;
      L_5d:
        p0.isPrimitive();
        if (if-nez(Class.isPrimitive(..))) goto L_7f;
        p0.isInterface();
        if (if-nez(Class.isInterface(..))) goto L_7f;
        p0.equals(Object.class);
        if (if-nez(Object.equals(..))) goto L_7f;
        p0.equals(Void.TYPE);
        if (if-eqz(Object.equals(..))) goto L_7a;
      L_7a:
        p0.getSuperclass();
      L_7f:
        e = v9;
        D.-$$Nest$fgetd(e);
      L_90:
        if (if-nez(v9)) goto L_b7;
        if (if-eqz(p3)) goto L_9e;
      L_9e:
      L_a0:
        Class.getSuperclass(..).getName();
        String.format("no %s method with name='%s' signature='%s' in class L%s;", 4);
        new NoSuchMethodError(String.format(..));
        throw new NoSuchMethodError(..);
      L_b7:
        return new NoSuchMethodError(..);
        throw String.format(..);
    }

    private static void nativeProxyFinalize(long p0) {
        // native or abstract
    }

    private static Object nativeProxyInvoke(long p0, String p1, Object[] p2) {
        // native or abstract
    }

    private static void nativeProxyJNIFreeGCHandle(long p0) {
        // native or abstract
    }

    private static void nativeProxyLogJNIInvokeException(long p0) {
        // native or abstract
    }

    protected static Object newProxyInstance(UnityPlayer p0, long p1, Class p2) {
        ReflectionHelper.newProxyInstance(p0, p1, v4, 1);
        return ReflectionHelper.newProxyInstance(..);
    }

    protected static Object newProxyInstance(UnityPlayer p0, long p1, Class[] p2) {
        ReflectionHelper.class.getClassLoader();
        new C(p0, p1, v4);
        Proxy.newProxyInstance(Class.getClassLoader(..), p2, new C(..));
        return Proxy.newProxyInstance(..);
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_036 (orig: S)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_036
package com.unity3d.player;

final class AppClass_036 /* orig: S */ extends I {
    J h;

    public S(Context p0, UnityPlayer p1) {
        new I(p0, p1);
        return;
    }

    public final void a(String p0, int p1, boolean p2, boolean p3, boolean p4, boolean p5, String p6, int p7, boolean p8, boolean p9) {
        new J(a, b);
        h = new J(..);
        new J(..).a(this, p8, p9);
        new N(this);
        h.setOnDismissListener(new N(..));
        I.a(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        b.getViewTreeObserver();
        new O(this);
        View.getViewTreeObserver(..).addOnGlobalLayoutListener(new O(..));
        c.requestFocus();
        new P(this);
        h.setOnCancelListener(new P(..));
        return;
    }

    public final void a(boolean p0) {
        d = p0;
        h.a(p0);
        return;
    }

    public final void c() {
        h.dismiss();
        return;
    }

    protected EditText createEditText(I p0) {
        new Q(a, p0);
        return new Q(..);
    }

    public final void e() {
        h.show();
        return;
    }

    protected void reportSoftInputArea() {
        h.isShowing();
        if (if-eqz(Dialog.isShowing(..))) goto L_13;
        h.a();
        b.reportSoftInputArea(J.a(..));
      L_13:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_037 (orig: S0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_037
package com.unity3d.player;

final class AppClass_037 /* orig: S0 */ {
    final U0 a;

    S0(U0 p0) {
        a = p0;
        new Object();
        return;
    }

    public final void run() {
        U0.-$$Nest$fgetf(a);
        if (if-eqz(U0.-$$Nest$fgetf(..))) goto L_29;
        U0.-$$Nest$fgeta(a);
        U0.-$$Nest$fgeta(..).removeViewFromPlayer(U0.-$$Nest$fgetf(..));
        U0.-$$Nest$fputi(a, 0);
        U0.-$$Nest$fgetf(a);
        U0.-$$Nest$fgetf(..).destroyPlayer();
        U0.-$$Nest$fputf(a, 0);
        U0.-$$Nest$fgetc(a);
        if (if-eqz(U0.-$$Nest$fgetc(..))) goto L_29;
        U0.-$$Nest$fgetc(..).a();
      L_29:
        U0.-$$Nest$fgeta(a);
        U0.-$$Nest$fgeta(..).onResume();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.SoftInputProvider
// ============================================================
package com.unity3d.player;

abstract class SoftInputProvider {
    public static int a() {
        SoftInputProvider.nativeGetSoftInputType();
        a.b(3);
      L_b:
        if (if-ge(0, v2)) goto L_19;
        c.a(v4);
        if (if-ne(c.a(..), SoftInputProvider.nativeGetSoftInputType(..))) goto L_16;
      L_16:
      L_19:
      L_1a:
        return 1;
    }

    private static final int nativeGetSoftInputType() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_038 (orig: T)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_038
package com.unity3d.player;

public abstract class AppClass_038 /* orig: T */ {
}


// ============================================================
// CLASS: com.unity3d.player.AppClass_039 (orig: T0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_039
package com.unity3d.player;

public abstract class AppClass_039 /* orig: T0 */ {
}


// ============================================================
// CLASS: com.unity3d.player.AppClass_040 (orig: U)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_040
package com.unity3d.player;

final class AppClass_040 /* orig: U */ extends ContentObserver {
    private T a;

    public U(Handler p0, T p1) {
        new ContentObserver(p0);
        a = p1;
        return;
    }

    public final boolean deliverSelfNotifications() {
        ContentObserver.deliverSelfNotifications();
        return ContentObserver.deliverSelfNotifications(..);
    }

    public final void onChange(boolean p0) {
        if (if-eqz(a)) goto L_9;
        a.b();
      L_9:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_041 (orig: U0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_041
package com.unity3d.player;

final class AppClass_041 /* orig: U0 */ {
    private UnityPlayer a;
    private Context b;
    private T0 c;
    private final Semaphore d;
    private final ReentrantLock e;
    private M0 f;
    private int g;
    private boolean h;
    private boolean i;

    static UnityPlayer -$$Nest$fgeta(U0 p0) {
        return a;
    }

    static Context -$$Nest$fgetb(U0 p0) {
        return b;
    }

    static T0 -$$Nest$fgetc(U0 p0) {
        return c;
    }

    static Semaphore -$$Nest$fgetd(U0 p0) {
        return d;
    }

    static ReentrantLock -$$Nest$fgete(U0 p0) {
        return e;
    }

    static M0 -$$Nest$fgetf(U0 p0) {
        return f;
    }

    static boolean -$$Nest$fgeti(U0 p0) {
        return i;
    }

    static void -$$Nest$fputf(U0 p0, M0 p1) {
        f = p1;
        return;
    }

    static void -$$Nest$fputg(U0 p0, int p1) {
        g = p1;
        return;
    }

    static void -$$Nest$fputi(U0 p0, boolean p1) {
        i = p1;
        return;
    }

    U0(UnityPlayer p0) {
        new Object();
        a = 0;
        b = 0;
        new Semaphore(0);
        d = new Semaphore(..);
        new ReentrantLock();
        e = new ReentrantLock(..);
        f = 0;
        g = 2;
        h = 0;
        i = 0;
        a = p0;
        return;
    }

    public final void a() {
        e.lock();
        if (if-eqz(f)) goto L_c;
        f.updateVideoLayout();
      L_c:
        e.unlock();
        return;
    }

    public final boolean a(Context p0, String p1, int p2, int p3, int p4, boolean p5, long p6, long p7, T0 p8) {
        e.lock();
        c = p8;
        b = p0;
        d.drainPermits();
        g = 2;
        new P0(this, p1, p2, p3, p4, p5, p6, v8, p7, v10);
        U0.runOnUiThread(new P0);
        e.unlock();
        d.acquire();
        e.lock();
        if (if-eq(g, 2)) goto L_42;
      L_42:
        new Q0(this);
        U0.runOnUiThread(new Q0(..));
        if (if-eqz(1)) goto L_57;
        if (if-eq(g, 3)) goto L_57;
        new R0(this);
      L_57:
        new S0(this);
      L_5c:
        U0.runOnUiThread(new S0(..));
        e.unlock();
        return 1;
    }

    public final void b() {
        e.lock();
        if (if-eqz(f)) goto L_22;
        if (if-nez(g)) goto L_11;
        f.cancelOnPrepare();
      L_11:
        if (if-eqz(i)) goto L_22;
        f.a();
        h = M0.a(..);
        if (if-nez(M0.a(..))) goto L_22;
        f.pause();
      L_22:
        e.unlock();
        return;
    }

    public final void c() {
        e.lock();
        if (if-eqz(f)) goto L_14;
        if (if-eqz(i)) goto L_14;
        if (if-nez(h)) goto L_14;
        f.start();
      L_14:
        e.unlock();
        return;
    }

    protected void runOnUiThread(Runnable p0) {
        if (if-eqz(v1)) goto L_c;
        b.runOnUiThread(p0);
      L_c:
        t.Log(5, "Not running from an Activity; Ignoring execution request...");
      L_12:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.UnityCoreAssetPacksStatusCallbacks
// ============================================================
package com.unity3d.player;

class UnityCoreAssetPacksStatusCallbacks {
    public UnityCoreAssetPacksStatusCallbacks() {
        new Object();
        return;
    }

    private final void nativeStatusQueryResult(String p0, int p1, int p2) {
        // native or abstract
    }

    public void onStatusResult(long p0, String[] p1, int[] p2, int[] p3) {
      L_1:
        if (if-ge(0, v4)) goto L_10;
        UnityCoreAssetPacksStatusCallbacks.nativeStatusQueryResult(v4, v0, v1);
      L_10:
        return;
    }

    public void onStatusUpdate(String p0, int p1, long p2, long p3, int p4, int p5) {
        UnityCoreAssetPacksStatusCallbacks.nativeStatusQueryResult(p0, p1, p5);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.UnityPermissions
// ============================================================
package com.unity3d.player;

public class UnityPermissions {
    private static final String SKIP_DIALOG_METADATA_NAME = "unityplayer.SkipPermissionsDialog";

    public UnityPermissions() {
        new Object();
        return;
    }

    private static boolean checkInfoForMetadata(PackageItemInfo p0) {
        metaData.getBoolean("unityplayer.SkipPermissionsDialog");
        return Bundle.getBoolean(..);
        return 0;
    }

    public static boolean hasUserAuthorizedPermission(Context p0, String p1) {
        p0.checkCallingOrSelfPermission(p1);
        if (if-nez(Context.checkCallingOrSelfPermission(..))) goto L_8;
      L_8:
      L_9:
        return 0;
    }

    public static void requestUserPermissions(Activity p0, String[] p1, IPermissionRequestCallbacks p2) {
        if (if-nez(PlatformSupport.MARSHMALLOW_SUPPORT)) goto L_5;
        return;
      L_5:
        if (if-eqz(p0)) goto L_38;
        if (if-nez(p1)) goto L_a;
      L_a:
        p0.getFragmentManager();
        String.valueOf(96489);
        Activity.getFragmentManager(..).findFragmentByTag(String.valueOf(..));
        if (if-nez(FragmentManager.findFragmentByTag(..))) goto L_38;
        new PermissionFragment(p0, p2);
        new Bundle();
        new Bundle(..).putStringArray("PermissionNames", p1);
        new PermissionFragment(..).setArguments(new Bundle(..));
        Activity.getFragmentManager(..).beginTransaction();
        FragmentManager.beginTransaction(..).add(0, new PermissionFragment(..), String.valueOf(..));
        FragmentManager.beginTransaction(..).commit();
      L_38:
        return;
    }

    public static boolean skipPermissionsDialog(Activity p0) {
        if (if-nez(PlatformSupport.MARSHMALLOW_SUPPORT)) goto L_6;
        return 0;
      L_6:
        p0.getPackageManager();
        p0.getComponentName();
        Context.getPackageManager(..).getActivityInfo(Activity.getComponentName(..), 128);
        p0.getPackageName();
        Context.getPackageManager(..).getApplicationInfo(Context.getPackageName(..), 128);
        UnityPermissions.checkInfoForMetadata(PackageManager.getActivityInfo(..));
        if (if-nez(UnityPermissions.checkInfoForMetadata(..))) goto L_28;
        UnityPermissions.checkInfoForMetadata(PackageManager.getApplicationInfo(..));
        if (if-eqz(UnityPermissions.checkInfoForMetadata(..))) goto L_2a;
      L_28:
        return 1;
      L_2a:
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.player.UnityPlayer
// ============================================================
package com.unity3d.player;

public class UnityPlayer extends FrameLayout {
    private static final String ARCORE_ENABLE_METADATA_NAME = "unity.arcore-enable";
    private static final String AUTO_REPORT_FULLY_DRAWN_ENABLE_METADATA_NAME = "unity.auto-report-fully-drawn";
    private static final String LAUNCH_FULLSCREEN = "unity.launch-fullscreen";
    private static final int RUN_STATE_CHANGED_MSG_CODE = 2269;
    private static final String SPLASH_ENABLE_METADATA_NAME = "unity.splash-enable";
    private static final String SPLASH_MODE_METADATA_NAME = "unity.splash-mode";
    public static Activity currentActivity;
    public static Context currentContext;
    private Activity mActivity;
    private Context mContext;
    private Y mGlView;
    Handler mHandler;
    private int mInitialScreenOrientation;
    private boolean mIsFullscreen;
    private boolean mMainDisplayOverride;
    private int mNaturalOrientation;
    private v mOnHandleFocusListener;
    private OrientationEventListener mOrientationListener;
    private boolean mProcessKillRequested;
    private boolean mQuitting;
    I mSoftInput;
    private long mSoftInputTimeoutMilliSeconds;
    private J0 mState;
    private U0 mVideoPlayerProxy;
    private GoogleARCoreApi m_ARCoreApi;
    private boolean m_AddPhoneCallListener;
    private AudioVolumeHandler m_AudioVolumeHandler;
    private Camera2Wrapper m_Camera2Wrapper;
    private ClipboardManager m_ClipboardManager;
    private final ConcurrentLinkedQueue m_Events;
    private D0 m_FakeListener;
    private HFPStatus m_HFPStatus;
    private int m_IsNoWindowMode;
    H0 m_MainThread;
    private NetworkConnectivity m_NetworkConnectivity;
    private OrientationLockListener m_OrientationLockListener;
    private E0 m_PhoneCallListener;
    private e m_SplashScreen;
    private TelephonyManager m_TelephonyManager;
    private IUnityPlayerLifecycleEvents m_UnityPlayerLifecycleEvents;
    Window m_Window;
    private Uri m_launchUri;
    private Configuration prevConfig;

    static Activity -$$Nest$fgetmActivity(UnityPlayer p0) {
        return mActivity;
    }

    static Context -$$Nest$fgetmContext(UnityPlayer p0) {
        return mContext;
    }

    static Y -$$Nest$fgetmGlView(UnityPlayer p0) {
        return mGlView;
    }

    static int -$$Nest$fgetmInitialScreenOrientation(UnityPlayer p0) {
        return mInitialScreenOrientation;
    }

    static boolean -$$Nest$fgetmMainDisplayOverride(UnityPlayer p0) {
        return mMainDisplayOverride;
    }

    static int -$$Nest$fgetmNaturalOrientation(UnityPlayer p0) {
        return mNaturalOrientation;
    }

    static e -$$Nest$fgetm_SplashScreen(UnityPlayer p0) {
        return m_SplashScreen;
    }

    static IUnityPlayerLifecycleEvents -$$Nest$fgetm_UnityPlayerLifecycleEvents(UnityPlayer p0) {
        return m_UnityPlayerLifecycleEvents;
    }

    static void -$$Nest$fputmQuitting(UnityPlayer p0, boolean p1) {
        mQuitting = p1;
        return;
    }

    static void -$$Nest$fputmVideoPlayerProxy(UnityPlayer p0, U0 p1) {
        mVideoPlayerProxy = p1;
        return;
    }

    static void -$$Nest$fputm_SplashScreen(UnityPlayer p0, e p1) {
        m_SplashScreen = p1;
        return;
    }

    static void -$$Nest$mDisableStaticSplashScreen(UnityPlayer p0) {
        p0.DisableStaticSplashScreen();
        return;
    }

    static void -$$Nest$mdismissSoftInput(UnityPlayer p0) {
        p0.dismissSoftInput();
        return;
    }

    static void -$$Nest$mfinish(UnityPlayer p0) {
        p0.finish();
        return;
    }

    static boolean -$$Nest$mgetAutoReportFullyDrawnEnabled(UnityPlayer p0) {
        p0.getAutoReportFullyDrawnEnabled();
        return UnityPlayer.getAutoReportFullyDrawnEnabled(..);
    }

    static boolean -$$Nest$mgetHaveAndroidWindowSupport(UnityPlayer p0) {
        p0.getHaveAndroidWindowSupport();
        return UnityPlayer.getHaveAndroidWindowSupport(..);
    }

    static boolean -$$Nest$mgetSplashEnabled(UnityPlayer p0) {
        p0.getSplashEnabled();
        return UnityPlayer.getSplashEnabled(..);
    }

    static void -$$Nest$mnativeFocusChanged(UnityPlayer p0, boolean p1) {
        p0.nativeFocusChanged(p1);
        return;
    }

    static boolean -$$Nest$mnativeIsAutorotationOn(UnityPlayer p0) {
        p0.nativeIsAutorotationOn();
        return UnityPlayer.nativeIsAutorotationOn(..);
    }

    static void -$$Nest$mnativeLowMemory(UnityPlayer p0) {
        p0.nativeLowMemory();
        return;
    }

    static void -$$Nest$mnativeMuteMasterAudio(UnityPlayer p0, boolean p1) {
        p0.nativeMuteMasterAudio(p1);
        return;
    }

    static void -$$Nest$mnativeOrientationChanged(UnityPlayer p0, int p1, int p2) {
        p0.nativeOrientationChanged(p1, p2);
        return;
    }

    static boolean -$$Nest$mnativePause(UnityPlayer p0) {
        p0.nativePause();
        return UnityPlayer.nativePause(..);
    }

    static void -$$Nest$mnativeRecreateGfxState(UnityPlayer p0, int p1, Surface p2) {
        p0.nativeRecreateGfxState(p1, p2);
        return;
    }

    static boolean -$$Nest$mnativeRender(UnityPlayer p0) {
        p0.nativeRender();
        return UnityPlayer.nativeRender(..);
    }

    static void -$$Nest$mnativeReportKeyboardConfigChanged(UnityPlayer p0) {
        p0.nativeReportKeyboardConfigChanged();
        return;
    }

    static void -$$Nest$mnativeResume(UnityPlayer p0) {
        p0.nativeResume();
        return;
    }

    static void -$$Nest$mnativeSendSurfaceChangedEvent(UnityPlayer p0) {
        p0.nativeSendSurfaceChangedEvent();
        return;
    }

    static void -$$Nest$mnativeSetInputArea(UnityPlayer p0, int p1, int p2, int p3, int p4) {
        p0.nativeSetInputArea(p1, p2, p3, p4);
        return;
    }

    static void -$$Nest$mnativeSetInputSelection(UnityPlayer p0, int p1, int p2) {
        p0.nativeSetInputSelection(p1, p2);
        return;
    }

    static void -$$Nest$mnativeSetInputString(UnityPlayer p0, String p1) {
        p0.nativeSetInputString(p1);
        return;
    }

    static void -$$Nest$mnativeSetKeyboardIsVisible(UnityPlayer p0, boolean p1) {
        p0.nativeSetKeyboardIsVisible(p1);
        return;
    }

    static void -$$Nest$mnativeSetLaunchURL(UnityPlayer p0, String p1) {
        p0.nativeSetLaunchURL(p1);
        return;
    }

    static void -$$Nest$mnativeSoftInputCanceled(UnityPlayer p0) {
        p0.nativeSoftInputCanceled();
        return;
    }

    static void -$$Nest$mnativeSoftInputClosed(UnityPlayer p0) {
        p0.nativeSoftInputClosed();
        return;
    }

    static void -$$Nest$mnativeSoftInputLostFocus(UnityPlayer p0) {
        p0.nativeSoftInputLostFocus();
        return;
    }

    static void -$$Nest$mqueueDestroy(UnityPlayer p0) {
        p0.queueDestroy();
        return;
    }

    static void -$$Nest$mshutdown(UnityPlayer p0) {
        p0.shutdown();
        return;
    }

    static <clinit>() {
        new W();
        new W(..).a();
        return;
    }

    public UnityPlayer(Context p0) {
        new UnityPlayer(p0, 0);
        return;
    }

    public UnityPlayer(Context p0, IUnityPlayerLifecycleEvents p1) {
        new FrameLayout(p0);
        new Handler();
        mHandler = new Handler(..);
        mInitialScreenOrientation = -1;
        mMainDisplayOverride = 0;
        mIsFullscreen = 1;
        new J0();
        mState = new J0(..);
        new ConcurrentLinkedQueue();
        m_Events = new ConcurrentLinkedQueue(..);
        mOrientationListener = 0;
        new H0(new FrameLayout(..), 0);
        m_MainThread = new H0(..);
        m_AddPhoneCallListener = 0;
        new E0(new FrameLayout(..), 0);
        m_PhoneCallListener = new E0(..);
        m_ARCoreApi = 0;
        new D0();
        m_FakeListener = new D0(..);
        m_Camera2Wrapper = 0;
        m_HFPStatus = 0;
        m_AudioVolumeHandler = 0;
        m_OrientationLockListener = 0;
        m_launchUri = 0;
        m_NetworkConnectivity = 0;
        m_UnityPlayerLifecycleEvents = 0;
        m_IsNoWindowMode = -1;
        mSoftInputTimeoutMilliSeconds = 1000L;
        mProcessKillRequested = 1;
        mSoftInput = 0;
        if (if-eqz(p1)) goto L_58;
      L_58:
      L_59:
        m_UnityPlayerLifecycleEvents = new FrameLayout(..);
        UnityPlayer.getUnityNativeLibraryPath(p0);
        W.a(UnityPlayer.getUnityNativeLibraryPath(..));
        currentContext = p0;
        if (if-eqz(UnityPlayer.getUnityNativeLibraryPath(..))) goto L_81;
        mActivity = p0;
        currentActivity = p0;
        p0.getRequestedOrientation();
        mInitialScreenOrientation = Activity.getRequestedOrientation(..);
        mActivity.getIntent();
        Activity.getIntent(..).getData();
        m_launchUri = Intent.getData(..);
      L_81:
        mContext = p0;
        new FrameLayout(..).EarlyEnableFullScreenIfEnabled();
        new FrameLayout(..).getResources();
        View.getResources(..).getConfiguration();
        prevConfig = Resources.getConfiguration(..);
        new FrameLayout(..).getNaturalOrientation(orientation);
        mNaturalOrientation = UnityPlayer.getNaturalOrientation(..);
        if (if-eqz(mActivity)) goto L_b8;
        new FrameLayout(..).getSplashEnabled();
        if (if-eqz(UnityPlayer.getSplashEnabled(..))) goto L_b8;
        d.a();
        new FrameLayout(..).getSplashMode();
        new e(mContext, d.a(..));
        m_SplashScreen = new e(..);
        new FrameLayout(..).addView(new e(..));
      L_b8:
        UnityPlayer.preloadJavaPlugins();
        UnityPlayer.getUnityNativeLibraryPath(mContext);
        UnityPlayer.loadNative(UnityPlayer.getUnityNativeLibraryPath(..));
        J0.d();
        if (if-nez(J0.d(..))) goto L_10b;
        t.Log(6, "Your hardware does not support this application.");
        new AlertDialog$Builder(mContext);
        new AlertDialog$Builder(..).setTitle("Failure to initialize!");
        new m0(new FrameLayout(..));
        AlertDialog$Builder.setTitle(..).setPositiveButton("OK", new m0(..));
        new StringBuilder("Your hardware does not support this application.\n\n");
        new StringBuilder(..).append(UnityPlayer.loadNative(..));
        new StringBuilder(..).append("\n\n Press OK to quit.");
        new StringBuilder(..).toString();
        AlertDialog$Builder.setMessage(StringBuilder.toString(..));
        AlertDialog$Builder.setMessage(..).create();
        AlertDialog$Builder.create(..).setCancelable(0);
        AlertDialog$Builder.create(..).show();
        return;
      L_10b:
        new FrameLayout(..).initJni(AlertDialog$Builder.create(..));
        mState.d("Your hardware does not support this application.\n\n");
        new Y(AlertDialog$Builder.create(..), new FrameLayout(..));
        mGlView = new Y(..);
        new FrameLayout(..).addView(new Y(..));
        new FrameLayout(..).bringChildToFront(m_SplashScreen);
        mQuitting = 0;
        if (if-eqz(mActivity)) goto L_12e;
        mActivity.getWindow();
        m_Window = Activity.getWindow(..);
      L_12e:
        new FrameLayout(..).hideStatusBar();
        mContext.getSystemService("phone");
        m_TelephonyManager = Context.getSystemService(..);
        mContext.getSystemService("clipboard");
        m_ClipboardManager = Context.getSystemService(..);
        new Camera2Wrapper(mContext);
        m_Camera2Wrapper = new Camera2Wrapper(..);
        new HFPStatus(mContext);
        m_HFPStatus = new HFPStatus(..);
        m_MainThread.start();
        return;
    }

    private void DisableStaticSplashScreen() {
        new v0(this);
        UnityPlayer.runOnUiThread(new v0(..));
        return;
    }

    private void EarlyEnableFullScreenIfEnabled() {
        if (if-eqz(mActivity)) goto L_2f;
        mActivity.getWindow();
        if (if-eqz(Activity.getWindow(..))) goto L_2f;
        UnityPlayer.getLaunchFullscreen();
        if (if-nez(UnityPlayer.getLaunchFullscreen(..))) goto L_1f;
        mActivity.getIntent();
        Activity.getIntent(..).getBooleanExtra("android.intent.extra.VR_LAUNCH", 0);
        if (if-eqz(Intent.getBooleanExtra(..))) goto L_2f;
      L_1f:
        mActivity.getWindow();
        Activity.getWindow(..).getDecorView();
        if (if-eqz(Window.getDecorView(..))) goto L_2f;
        Window.getDecorView(..).setSystemUiVisibility(7);
      L_2f:
        s.a(mActivity);
        return;
    }

    private String GetGlViewContentDescription(Context p0) {
        p0.getResources();
        p0.getResources();
        p0.getPackageName();
        Context.getResources(..).getIdentifier("game_view_content_description", "string", Context.getPackageName(..));
        Context.getResources(..).getString(Resources.getIdentifier(..));
        return Resources.getString(..);
    }

    private boolean IsWindowTranslucent() {
        if (if-nez(mActivity)) goto L_6;
        return 0;
      L_6:
        mActivity.getTheme();
        Context.getTheme(..).obtainStyledAttributes(1);
        TypedArray.getBoolean(0, 0);
        TypedArray.recycle();
        return TypedArray.getBoolean(..);
    }

    public static void UnitySendMessage(String p0, String p1, String p2) {
        J0.d();
        if (if-nez(J0.d(..))) goto L_21;
        new StringBuilder("Native libraries not loaded - dropping message for ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(".");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        t.Log(5, StringBuilder.toString(..));
        return;
      L_21:
        new StringBuilder(..).getBytes("UTF-8");
        UnityPlayer.nativeUnitySendMessage(StringBuilder.toString(..), 5, String.getBytes(..));
        return;
    }

    private void checkResumePlayer() {
        if (if-eqz(mActivity)) goto L_9;
        MultiWindowSupport.isInMultiWindowMode(mActivity);
      L_9:
      L_a:
        mState.a(0);
        if (if-nez(J0.a(..))) goto L_13;
        return;
      L_13:
        mState.c(1);
        new Z(this);
        UnityPlayer.queueGLThreadEvent(new Z(..));
        H0.-$$Nest$ma(m_MainThread, F0.b);
        return;
    }

    private void dismissSoftInput() {
        if (if-eqz(mSoftInput)) goto L_a;
        mSoftInput.c();
        UnityPlayer.nativeReportKeyboardConfigChanged();
      L_a:
        return;
    }

    private void finish() {
        if (if-eqz(mActivity)) goto L_f;
        mActivity.isFinishing();
        if (if-nez(Activity.isFinishing(..))) goto L_f;
        mActivity.finish();
      L_f:
        return;
    }

    private boolean getARCoreEnabled() {
        UnityPlayer.getApplicationInfo();
        metaData.getBoolean("unity.arcore-enable");
        return Bundle.getBoolean(..);
        return 0;
    }

    private ActivityInfo getActivityInfo() {
        mActivity.getPackageManager();
        mActivity.getComponentName();
        Context.getPackageManager(..).getActivityInfo(Activity.getComponentName(..), 128);
        return PackageManager.getActivityInfo(..);
    }

    private ApplicationInfo getApplicationInfo() {
        mContext.getPackageManager();
        mContext.getPackageName();
        Context.getPackageManager(..).getApplicationInfo(Context.getPackageName(..), 128);
        return PackageManager.getApplicationInfo(..);
    }

    private boolean getAutoReportFullyDrawnEnabled() {
        UnityPlayer.getApplicationInfo();
        metaData.getBoolean("unity.auto-report-fully-drawn");
        return Bundle.getBoolean(..);
        return 0;
    }

    private boolean getHaveAndroidWindowSupport() {
        if (if-ne(m_IsNoWindowMode, -1)) goto L_b;
        UnityPlayer.nativeGetNoWindowMode();
        m_IsNoWindowMode = UnityPlayer.nativeGetNoWindowMode(..);
      L_b:
        if (if-ne(m_IsNoWindowMode, 1)) goto L_11;
      L_11:
      L_12:
        return 0;
    }

    private boolean getLaunchFullscreen() {
        UnityPlayer.getApplicationInfo();
        metaData.getBoolean("unity.launch-fullscreen");
        return Bundle.getBoolean(..);
        return 0;
    }

    private int getNaturalOrientation(int p0) {
        mContext.getSystemService("window");
        Context.getSystemService(..).getDefaultDisplay();
        WindowManager.getDefaultDisplay(..).getRotation();
        if (if-eqz(Display.getRotation(..))) goto L_17;
        if (if-ne(Display.getRotation(..), 2)) goto L_19;
      L_17:
        if (if-eq(p0, 2)) goto L_23;
      L_19:
        if (if-eq(Display.getRotation(..), 1)) goto L_1f;
        if (if-ne(Display.getRotation(..), 3)) goto L_22;
      L_1f:
        if (if-ne(p0, 1)) goto L_22;
      L_22:
        return 1;
      L_23:
        return 0;
    }

    private String getProcessName() {
        Process.myPid();
        mContext.getSystemService("activity");
        Context.getSystemService(..).getRunningAppProcesses();
        if (if-nez(ActivityManager.getRunningAppProcesses(..))) goto L_16;
        return 0;
      L_16:
        List.iterator();
      L_1a:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_2d;
        List.iterator(..).next();
        if (if-ne(pid, Process.myPid(..))) goto L_1a;
        return processName;
      L_2d:
        return 0;
    }

    private long getSoftInputTimeout() {
        mContext.getContentResolver();
        Settings$System.getFloat(Context.getContentResolver(..), "animator_duration_scale", 0);
        Math.max(1.0f, Settings$System.getFloat(..));
        Math.round(mSoftInputTimeoutMilliSeconds, v3);
        return Math.round(..);
    }

    private boolean getSplashEnabled() {
        UnityPlayer.getApplicationInfo();
        metaData.getBoolean("unity.splash-enable");
        return Bundle.getBoolean(..);
        return 0;
    }

    private static String getUnityNativeLibraryPath(Context p0) {
        p0.getApplicationInfo();
        return nativeLibraryDir;
    }

    private void hidePreservedContent() {
        new c0(this);
        UnityPlayer.runOnUiThread(new c0(..));
        return;
    }

    private void hideStatusBar() {
        if (if-eqz(mActivity)) goto L_d;
        mActivity.getWindow();
        Activity.getWindow(..).setFlags(1024, 1024);
      L_d:
        return;
    }

    private final void initJni(Context p0) {
        // native or abstract
    }

    private static String loadNative(String p0) {
        new StringBuilder();
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append("/libmain.so");
        new StringBuilder(..).toString();
        System.load(StringBuilder.toString(..));
        System.loadLibrary("main");
      L_1c:
        NativeLoader.load(p0);
        if (if-eqz(NativeLoader.load(..))) goto L_28;
        J0.e();
        return "";
      L_28:
        t.Log(6, "NativeLoader.load failure, Unity libraries were not loaded.");
        return "NativeLoader.load failure, Unity libraries were not loaded.";
      L_2f:
        6.toString();
        UnityPlayer.logLoadLibMainError("NativeLoader.load failure, Unity libraries were not loaded.", Object.toString(..));
        return UnityPlayer.logLoadLibMainError(..);
        UnityPlayer.logLoadLibMainError(..).toString();
        UnityPlayer.logLoadLibMainError("NativeLoader.load failure, Unity libraries were not loaded.", Object.toString(..));
        return UnityPlayer.logLoadLibMainError(..);
    }

    private static String logLoadLibMainError(String p0, String p1) {
        new StringBuilder("Failed to load 'libmain.so'\n\n");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
        return StringBuilder.toString(..);
    }

    private final void nativeApplicationUnload() {
        // native or abstract
    }

    private final boolean nativeDone() {
        // native or abstract
    }

    private final void nativeFocusChanged(boolean p0) {
        // native or abstract
    }

    private final boolean nativeGetNoWindowMode() {
        // native or abstract
    }

    private final void nativeHidePreservedContent() {
        // native or abstract
    }

    private final boolean nativeInjectEvent(InputEvent p0, int p1) {
        // native or abstract
    }

    private final boolean nativeIsAutorotationOn() {
        // native or abstract
    }

    private final void nativeLowMemory() {
        // native or abstract
    }

    private final void nativeMuteMasterAudio(boolean p0) {
        // native or abstract
    }

    private final void nativeOrientationChanged(int p0, int p1) {
        // native or abstract
    }

    private final boolean nativePause() {
        // native or abstract
    }

    private final void nativeRecreateGfxState(int p0, Surface p1) {
        // native or abstract
    }

    private final boolean nativeRender() {
        // native or abstract
    }

    private final void nativeReportKeyboardConfigChanged() {
        // native or abstract
    }

    private final void nativeRestartActivityIndicator() {
        // native or abstract
    }

    private final void nativeResume() {
        // native or abstract
    }

    private final void nativeSendSurfaceChangedEvent() {
        // native or abstract
    }

    private final void nativeSetInputArea(int p0, int p1, int p2, int p3) {
        // native or abstract
    }

    private final void nativeSetInputSelection(int p0, int p1) {
        // native or abstract
    }

    private final void nativeSetInputString(String p0) {
        // native or abstract
    }

    private final void nativeSetKeyboardIsVisible(boolean p0) {
        // native or abstract
    }

    private final void nativeSetLaunchURL(String p0) {
        // native or abstract
    }

    private final void nativeSoftInputCanceled() {
        // native or abstract
    }

    private final void nativeSoftInputClosed() {
        // native or abstract
    }

    private final void nativeSoftInputLostFocus() {
        // native or abstract
    }

    private static void nativeUnitySendMessage(String p0, String p1, byte[] p2) {
        // native or abstract
    }

    private void pauseUnity() {
        UnityPlayer.reportSoftInputStr(0, 1, 1);
        mState.c();
        if (if-eqz(J0.c(..))) goto L_8e;
        mState.b();
        if (if-eqz(J0.b(..))) goto L_19;
      L_19:
        J0.d();
        if (if-eqz(J0.d(..))) goto L_79;
        new Semaphore(0);
        UnityPlayer.isFinishing();
        if (if-eqz(UnityPlayer.isFinishing(..))) goto L_31;
        new A0(this, new Semaphore(..));
      L_31:
        new B0(this, new Semaphore(..));
      L_36:
        if (if-nez(a)) goto L_3d;
      L_3d:
        H0.-$$Nest$ma(m_MainThread, F0.a);
        Message.obtain(a, new B0(..));
        Message.obtain(..).sendToTarget();
      L_4b:
        UnityPlayer$SynchronizationTimeout.getTimeout();
        new Semaphore(..).tryAcquire(UnityPlayer$SynchronizationTimeout.getTimeout(..), v7, TimeUnit.MILLISECONDS);
        if (if-nez(Semaphore.tryAcquire(..))) goto L_79;
        new StringBuilder("Timeout (");
        UnityPlayer$SynchronizationTimeout.getTimeout();
        new StringBuilder(..).append(UnityPlayer$SynchronizationTimeout.getTimeout(..));
        new StringBuilder(..).append(" ms) while trying to pause the Unity Engine.");
        new StringBuilder(..).toString();
        t.Log(5, StringBuilder.toString(..));
        t.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
      L_79:
        mState.c(0);
        mState.e(1);
        if (if-eqz(m_AddPhoneCallListener)) goto L_8e;
        m_TelephonyManager.listen(m_PhoneCallListener, 0);
      L_8e:
        return;
    }

    private static void preloadJavaPlugins() {
        Class.forName("com.unity3d.JavaPluginPreloader");
        new StringBuilder("Java class preloading failed: ");
        "com.unity3d.JavaPluginPreloader".getMessage();
        new StringBuilder(..).append(Throwable.getMessage(..));
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
      L_1d:
        return;
    }

    private void queueDestroy() {
        t.Log(4, "Queue Destroy");
        new z0(this);
        UnityPlayer.runOnUiThread(new z0(..));
        return;
    }

    private void queueGLThreadEvent(I0 p0) {
        UnityPlayer.isFinishing();
        if (if-eqz(UnityPlayer.isFinishing(..))) goto L_7;
        return;
      L_7:
        UnityPlayer.queueGLThreadEvent(p0);
        return;
    }

    private void raiseFocusListener(boolean p0) {
        if (if-eqz(mOnHandleFocusListener)) goto L_14;
        b = 1;
        if (if-eqz(a)) goto L_14;
        c.release();
      L_14:
        return;
    }

    private void shutdown() {
        UnityPlayer.nativeDone();
        mProcessKillRequested = UnityPlayer.nativeDone(..);
        mState.d(0);
        return;
    }

    private void swapViews(View p0, View p1) {
        mState.b();
        if (if-nez(J0.b(..))) goto L_e;
        UnityPlayer.setupUnityToBePaused();
      L_e:
      L_f:
        if (if-eqz(p0)) goto L_30;
        p0.getParent();
        if (if-eqz(v3)) goto L_1e;
        if (if-eq(View.getParent(..), this)) goto L_30;
      L_1e:
        if (if-eqz(View.getParent(..))) goto L_27;
        View.getParent(..).removeView(p0);
      L_27:
        ViewGroup.addView(p0);
        ViewGroup.bringChildToFront(p0);
        p0.setVisibility(0);
      L_30:
        if (if-eqz(p1)) goto L_40;
        p1.getParent();
        if (if-ne(View.getParent(..), this)) goto L_40;
        p1.setVisibility(8);
        ViewGroup.removeView(p1);
      L_40:
        if (if-eqz(0)) goto L_45;
        UnityPlayer.setupUnityToBeResumed();
      L_45:
        return;
    }

    private static void unloadNative() {
        J0.d();
        if (if-nez(J0.d(..))) goto L_7;
        return;
      L_7:
        NativeLoader.unload();
        if (if-eqz(NativeLoader.unload(..))) goto L_11;
        J0.f();
        return;
      L_11:
        new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
        throw new UnsatisfiedLinkError(..);
    }

    private boolean updateDisplayInternal(int p0, Surface p1) {
        J0.d();
        if (if-eqz(J0.d(..))) goto L_7d;
        mState.a();
        if (if-nez(J0.a(..))) goto L_12;
      L_12:
        new Semaphore(0);
        new x0(this, p0, p1, new Semaphore(..));
        if (if-nez(p0)) goto L_46;
        if (if-nez(p1)) goto L_36;
        if (if-nez(a)) goto L_27;
      L_27:
        H0.-$$Nest$ma(m_MainThread, F0.d);
        Message.obtain(a, new x0(..));
        Message.obtain(..).sendToTarget();
      L_36:
        if (if-nez(F0.d)) goto L_39;
      L_39:
        Message.obtain(F0.d, Message.obtain(..));
        Message.obtain(..).sendToTarget();
        H0.-$$Nest$ma(a, F0.e);
      L_46:
        F0.e.run();
      L_49:
        if (if-nez(p1)) goto L_7b;
        if (if-nez(p0)) goto L_7b;
        UnityPlayer$SynchronizationTimeout.getTimeout();
        new Semaphore(..).tryAcquire(UnityPlayer$SynchronizationTimeout.getTimeout(..), a, TimeUnit.MILLISECONDS);
        if (if-nez(Semaphore.tryAcquire(..))) goto L_7b;
        new StringBuilder("Timeout (");
        UnityPlayer$SynchronizationTimeout.getTimeout();
        new StringBuilder(..).append(UnityPlayer$SynchronizationTimeout.getTimeout(..));
        new StringBuilder(..).append(" ms) while trying detaching primary window.");
        new StringBuilder(..).toString();
        t.Log(5, StringBuilder.toString(..));
        t.Log(5, "UI thread got interrupted while trying to detach the primary window from the Unity Engine.");
      L_7b:
        return 1;
      L_7d:
        return UnityPlayer$SynchronizationTimeout.getTimeout(..);
    }

    protected void addPhoneCallListener() {
        m_AddPhoneCallListener = 1;
        m_TelephonyManager.listen(m_PhoneCallListener, 32);
        return;
    }

    public boolean addViewToPlayer(View p0, boolean p1) {
        if (if-eqz(p1)) goto L_5;
      L_5:
      L_6:
        UnityPlayer.swapViews(p0, 0);
        p0.getParent();
        if (if-ne(View.getParent(..), this)) goto L_13;
      L_13:
      L_14:
        if (if-eqz(p1)) goto L_20;
        mGlView.getParent();
        if (if-nez(View.getParent(..))) goto L_20;
      L_20:
      L_21:
        mGlView.getParent();
        if (if-ne(View.getParent(..), this)) goto L_2b;
      L_2b:
      L_2c:
        if (if-eqz(0)) goto L_33;
        if (if-nez(0)) goto L_34;
        if (if-eqz(0)) goto L_33;
      L_33:
      L_34:
        if (if-nez(0)) goto L_47;
        if (if-nez(0)) goto L_3e;
        t.Log(6, "addViewToPlayer: Failure adding view to hierarchy");
      L_3e:
        if (if-nez(0)) goto L_47;
        if (if-nez(0)) goto L_47;
        t.Log(6, "addViewToPlayer: Failure removing old view from hierarchy");
      L_47:
        return 0;
    }

    public void configurationChanged(Configuration p0) {
        prevConfig.diff(p0);
        if (if-nez(v1)) goto L_16;
        if (if-nez(v1)) goto L_16;
        if (if-nez(v1)) goto L_16;
        if (if-eqz(Configuration.diff(..))) goto L_19;
      L_16:
        UnityPlayer.nativeHidePreservedContent();
      L_19:
        new Configuration(p0);
        prevConfig = new Configuration(..);
        if (if-eqz(mVideoPlayerProxy)) goto L_27;
        mVideoPlayerProxy.a();
      L_27:
        return;
    }

    public void destroy() {
        if (if-eqz(m_Camera2Wrapper)) goto L_a;
        m_Camera2Wrapper.a();
        m_Camera2Wrapper = 0;
      L_a:
        if (if-eqz(m_HFPStatus)) goto L_13;
        m_HFPStatus.b();
        m_HFPStatus = 0;
      L_13:
        if (if-eqz(m_NetworkConnectivity)) goto L_1c;
        m_NetworkConnectivity.a();
        m_NetworkConnectivity = 0;
      L_1c:
        mQuitting = 1;
        mState.b();
        if (if-nez(J0.b(..))) goto L_2a;
        UnityPlayer.setupUnityToBePaused();
      L_2a:
        H0.-$$Nest$ma(m_MainThread, F0.c);
        UnityPlayer$SynchronizationTimeout.getTimeout();
        m_MainThread.join(UnityPlayer$SynchronizationTimeout.getTimeout(..), v2);
        m_MainThread.interrupt();
      L_43:
        J0.d();
        if (if-eqz(J0.d(..))) goto L_4c;
        ViewGroup.removeAllViews();
      L_4c:
        if (if-eqz(mProcessKillRequested)) goto L_58;
        m_UnityPlayerLifecycleEvents.onUnityPlayerQuitted();
        UnityPlayer.kill();
      L_58:
        UnityPlayer.unloadNative();
        return;
    }

    protected void disableLogger() {
        a = 1;
        return;
    }

    public boolean displayChanged(int p0, Surface p1) {
        if (if-nez(p0)) goto L_11;
        if (if-eqz(p1)) goto L_6;
      L_6:
      L_7:
        mMainDisplayOverride = 0;
        new y0(this);
        UnityPlayer.runOnUiThread(new y0(..));
      L_11:
        UnityPlayer.updateDisplayInternal(p0, p1);
        return UnityPlayer.updateDisplayInternal(..);
    }

    protected void executeGLThreadJobs() {
      L_0:
        m_Events.poll();
        if (if-eqz(ConcurrentLinkedQueue.poll(..))) goto L_e;
        ConcurrentLinkedQueue.poll(..).run();
      L_e:
        return;
    }

    protected String getClipboardText() {
        m_ClipboardManager.getPrimaryClip();
        if (if-eqz(ClipboardManager.getPrimaryClip(..))) goto L_18;
        ClipboardManager.getPrimaryClip(..).getItemAt(0);
        ClipData.getItemAt(..).coerceToText(mContext);
        ClipData$Item.coerceToText(..).toString();
      L_18:
      L_1a:
        return "";
    }

    protected String getKeyboardLayout() {
        if (if-nez(mSoftInput)) goto L_6;
        return 0;
      L_6:
        0.a();
        return I.a(..);
    }

    protected String getLaunchURL() {
        if (if-eqz(m_launchUri)) goto L_9;
        m_launchUri.toString();
      L_9:
      L_a:
        return 0;
    }

    protected int getNetworkConnectivity() {
        if (if-eqz(m_NetworkConnectivity)) goto L_9;
        m_NetworkConnectivity.b();
        return NetworkConnectivity.b(..);
      L_9:
        if (if-eqz(PlatformSupport.NOUGAT_SUPPORT)) goto L_15;
        new NetworkConnectivityNougat(mContext);
      L_15:
        new NetworkConnectivity(mContext);
      L_1c:
        m_NetworkConnectivity = new NetworkConnectivity(..);
        m_NetworkConnectivity.b();
        return NetworkConnectivity.b(..);
    }

    public String getNetworkProxySettings(String p0) {
        p0.startsWith("http:");
        if (if-eqz(String.startsWith(..))) goto L_e;
      L_e:
        "http.proxyHost".startsWith("https:");
        if (if-eqz(String.startsWith(..))) goto L_69;
      L_1a:
        System.getProperties();
        System.getProperties(..).getProperty("https.proxyHost");
        if (if-eqz(Properties.getProperty(..))) goto L_69;
        "".equals(Properties.getProperty(..));
        if (if-eqz(String.equals(..))) goto L_2d;
      L_2d:
        new StringBuilder(Properties.getProperty(..));
        System.getProperties();
        System.getProperties(..).getProperty("https.proxyPort");
        if (if-eqz(Properties.getProperty(..))) goto L_4a;
        "".equals(Properties.getProperty(..));
        if (if-nez(String.equals(..))) goto L_4a;
        new StringBuilder(..).append(":");
        new StringBuilder(..).append(Properties.getProperty(..));
      L_4a:
        System.getProperties();
        System.getProperties(..).getProperty("http.nonProxyHosts");
        if (if-eqz(Properties.getProperty(..))) goto L_64;
        "".equals(Properties.getProperty(..));
        if (if-nez(String.equals(..))) goto L_64;
        new StringBuilder(..).append(10);
        new StringBuilder(..).append(Properties.getProperty(..));
      L_64:
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
      L_69:
        return new StringBuilder(..);
    }

    public float getScreenBrightness() {
        if (if-nez(m_Window)) goto L_7;
        return 1.0f;
      L_7:
        1.0f.getAttributes();
        if (if-gez(0)) goto L_4c;
        View.getContext();
        View.getContext(..).getContentResolver();
        Settings$System.getInt(Context.getContentResolver(..), "screen_brightness", 255);
        if (if-eqz(PlatformSupport.PIE_SUPPORT)) goto L_48;
        Math.log(Settings$System.getInt(..), PlatformSupport.PIE_SUPPORT);
        Math.min(Color(0x3FF00000), v3, Math.log(..), PlatformSupport.PIE_SUPPORT);
        Math.max(0L, v3, Math.min(..), PlatformSupport.PIE_SUPPORT);
        return Math.max(..);
      L_48:
      L_4c:
        return Math.max(..);
    }

    public Bundle getSettings() {
        return Bundle.EMPTY;
    }

    protected int getSplashMode() {
        UnityPlayer.getApplicationInfo();
        metaData.getInt("unity.splash-mode");
        return Bundle.getInt(..);
        return 0;
    }

    protected int getUaaLLaunchProcessType() {
        UnityPlayer.getProcessName();
        if (if-eqz(UnityPlayer.getProcessName(..))) goto L_14;
        mContext.getPackageName();
        UnityPlayer.getProcessName(..).equals(Context.getPackageName(..));
        if (if-nez(String.equals(..))) goto L_14;
      L_14:
      L_15:
        return 0;
    }

    public View getView() {
        return this;
    }

    protected void hideSoftInput() {
        if (if-nez(mSoftInput)) goto L_7;
        return;
      L_7:
        new Rect();
        UnityPlayer.reportSoftInputArea(new Rect(..));
        UnityPlayer.reportSoftInputIsVisible(0);
        Thread.currentThread();
        Looper.getMainLooper();
        Looper.getMainLooper(..).getThread();
        if (if-ne(Thread.currentThread(..), Looper.getThread(..))) goto L_28;
        UnityPlayer.dismissSoftInput();
        mSoftInput = 0;
        return;
      L_28:
        new Semaphore(0);
        new f0(this, new Semaphore(..), this);
        UnityPlayer.postOnUiThread(new f0(..));
        UnityPlayer.getSoftInputTimeout();
        new Semaphore(..).tryAcquire(UnityPlayer.getSoftInputTimeout(..), v6, TimeUnit.MILLISECONDS);
        if (if-nez(Semaphore.tryAcquire(..))) goto L_5a;
        new StringBuilder("Timeout (");
        UnityPlayer.getSoftInputTimeout();
        new StringBuilder(..).append(UnityPlayer.getSoftInputTimeout(..), v6);
        new StringBuilder(..).append(" ms) while waiting softinput hiding operation.");
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
      L_5a:
        mSoftInput = 0;
        t.Log(6, "UI thread got interrupted while waiting softinput hiding operation.");
      L_65:
        return;
      L_66:
        mSoftInput = 0;
        throw "UI thread got interrupted while waiting softinput hiding operation.";
    }

    public void init(int p0, boolean p1) {
        return;
    }

    protected boolean initializeGoogleAr() {
        if (if-nez(m_ARCoreApi)) goto L_27;
        if (if-eqz(mActivity)) goto L_27;
        UnityPlayer.getARCoreEnabled();
        if (if-eqz(UnityPlayer.getARCoreEnabled(..))) goto L_27;
        new GoogleARCoreApi();
        m_ARCoreApi = new GoogleARCoreApi(..);
        new GoogleARCoreApi(..).initializeARCore(mActivity);
        mState.b();
        if (if-nez(J0.b(..))) goto L_27;
        m_ARCoreApi.resumeARCore();
      L_27:
        return 0;
    }

    public boolean injectEvent(InputEvent p0) {
        UnityPlayer.injectEvent(p0, 0);
        return UnityPlayer.injectEvent(..);
    }

    public boolean injectEvent(InputEvent p0, int p1) {
        J0.d();
        if (if-nez(J0.d(..))) goto L_8;
        return 0;
      L_8:
        UnityPlayer.nativeInjectEvent(0, p1);
        return UnityPlayer.nativeInjectEvent(..);
    }

    protected boolean isFinishing() {
        if (if-eqz(mQuitting)) goto L_6;
        return 1;
      L_6:
        if (if-eqz(mActivity)) goto L_10;
        mActivity.isFinishing();
        mQuitting = Activity.isFinishing(..);
      L_10:
        return mQuitting;
    }

    protected boolean isUaaLUseCase() {
        if (if-eqz(mActivity)) goto L_18;
        mActivity.getCallingPackage();
        if (if-eqz(Activity.getCallingPackage(..))) goto L_18;
        mContext.getPackageName();
        Activity.getCallingPackage(..).equals(Context.getPackageName(..));
        if (if-eqz(String.equals(..))) goto L_18;
      L_18:
        return 1;
    }

    protected void kill() {
        Process.myPid();
        Process.killProcess(Process.myPid(..));
        return;
    }

    protected boolean loadLibrary(String p0) {
        System.loadLibrary(p0);
        return 1;
        return 0;
    }

    public void lowMemory() {
        J0.d();
        if (if-nez(J0.d(..))) goto L_7;
        return;
      L_7:
        new C0(this);
        UnityPlayer.queueGLThreadEvent(new C0(..));
        return;
    }

    public void newIntent(Intent p0) {
        p0.getData();
        m_launchUri = Intent.getData(..);
        H0.-$$Nest$ma(m_MainThread, F0.i);
        return;
    }

    public boolean onGenericMotionEvent(MotionEvent p0) {
        mGlView.c();
        if (if-nez(Y.c(..))) goto L_d;
        UnityPlayer.injectEvent(p0);
      L_d:
      L_e:
        return 0;
    }

    public boolean onKeyDown(int p0, KeyEvent p1) {
        UnityPlayer.injectEvent(p1);
        return UnityPlayer.injectEvent(..);
    }

    public boolean onKeyLongPress(int p0, KeyEvent p1) {
        UnityPlayer.injectEvent(p1);
        return UnityPlayer.injectEvent(..);
    }

    public boolean onKeyMultiple(int p0, int p1, KeyEvent p2) {
        UnityPlayer.injectEvent(p2);
        return UnityPlayer.injectEvent(..);
    }

    public boolean onKeyUp(int p0, KeyEvent p1) {
        UnityPlayer.injectEvent(p1);
        return UnityPlayer.injectEvent(..);
    }

    public void onPause() {
        MultiWindowSupport.saveMultiWindowMode(mActivity);
        MultiWindowSupport.isInMultiWindowMode(mActivity);
        if (if-eqz(MultiWindowSupport.isInMultiWindowMode(..))) goto L_e;
        return;
      L_e:
        UnityPlayer.setupUnityToBePaused();
        return;
    }

    public void onResume() {
        MultiWindowSupport.isInMultiWindowMode(mActivity);
        if (if-eqz(MultiWindowSupport.isInMultiWindowMode(..))) goto L_11;
        MultiWindowSupport.isMultiWindowModeChangedToTrue(mActivity);
        if (if-nez(MultiWindowSupport.isMultiWindowModeChangedToTrue(..))) goto L_11;
        return;
      L_11:
        UnityPlayer.setupUnityToBeResumed();
        return;
    }

    public void onStart() {
        MultiWindowSupport.isInMultiWindowMode(mActivity);
        if (if-nez(MultiWindowSupport.isInMultiWindowMode(..))) goto L_9;
        return;
      L_9:
        UnityPlayer.setupUnityToBeResumed();
        return;
    }

    public void onStop() {
        MultiWindowSupport.isInMultiWindowMode(mActivity);
        if (if-nez(MultiWindowSupport.isInMultiWindowMode(..))) goto L_9;
        return;
      L_9:
        UnityPlayer.setupUnityToBePaused();
        return;
    }

    public boolean onTouchEvent(MotionEvent p0) {
        mGlView.c();
        if (if-nez(Y.c(..))) goto L_d;
        UnityPlayer.injectEvent(p0);
      L_d:
      L_e:
        return 0;
    }

    public void onUnityPlayerQuitted() {
        return;
    }

    public void onUnityPlayerUnloaded() {
        return;
    }

    public void pause() {
        UnityPlayer.setupUnityToBePaused();
        return;
    }

    protected void pauseJavaAndCallUnloadCallback() {
        new r0(this);
        UnityPlayer.runOnUiThread(new r0(..));
        return;
    }

    void postOnUiThread(Runnable p0) {
        Looper.getMainLooper();
        new Handler(Looper.getMainLooper(..));
        new Handler(..).post(p0);
        return;
    }

    void queueGLThreadEvent(Runnable p0) {
        J0.d();
        if (if-nez(J0.d(..))) goto L_7;
        return;
      L_7:
        Thread.currentThread();
        if (if-ne(Thread.currentThread(..), m_MainThread)) goto L_13;
        p0.run();
      L_13:
        m_Events.add(p0);
      L_18:
        return;
    }

    public void quit() {
        UnityPlayer.destroy();
        return;
    }

    public void removeViewFromPlayer(View p0) {
        UnityPlayer.swapViews(mGlView, p0);
        p0.getParent();
        if (if-nez(View.getParent(..))) goto L_f;
      L_f:
      L_10:
        mGlView.getParent();
        if (if-ne(View.getParent(..), this)) goto L_1a;
      L_1a:
      L_1b:
        if (if-eqz(0)) goto L_20;
        if (if-eqz(0)) goto L_20;
      L_20:
      L_21:
        if (if-nez(0)) goto L_32;
        if (if-nez(0)) goto L_2b;
        t.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy");
      L_2b:
        if (if-nez(0)) goto L_32;
        t.Log(6, "removeVireFromPlayer: Failure agging old view to hierarchy");
      L_32:
        return;
    }

    public void reportError(String p0, String p1) {
        new StringBuilder();
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(": ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
        return;
    }

    protected void reportSoftInputArea(Rect p0) {
        new n0(this, p0);
        UnityPlayer.queueGLThreadEvent(new n0(..));
        return;
    }

    protected void reportSoftInputIsVisible(boolean p0) {
        new o0(this, p0);
        UnityPlayer.queueGLThreadEvent(new o0(..));
        return;
    }

    protected void reportSoftInputSelection(int p0, int p1) {
        new l0(this, p0, p1);
        UnityPlayer.queueGLThreadEvent(new l0(..));
        return;
    }

    protected void reportSoftInputStr(String p0, int p1, boolean p2) {
        if (if-ne(p1, 1)) goto L_6;
        UnityPlayer.hideSoftInput();
      L_6:
        new k0(this, p2, p0, p1);
        UnityPlayer.queueGLThreadEvent(new k0(..));
        return;
    }

    protected void requestUserAuthorization(String p0) {
        if (if-eqz(p0)) goto L_1f;
        p0.isEmpty();
        if (if-nez(String.isEmpty(..))) goto L_1f;
        if (if-eqz(mActivity)) goto L_1f;
        new UnityPermissions$ModalWaitForPermissionResponse();
        UnityPermissions.requestUserPermissions(mActivity, 1, new UnityPermissions$ModalWaitForPermissionResponse(..));
        UnityPermissions$ModalWaitForPermissionResponse.waitForResponse();
      L_1f:
        return;
    }

    public void resume() {
        UnityPlayer.setupUnityToBeResumed();
        return;
    }

    void runOnAnonymousThread(Runnable p0) {
        new Thread(p0);
        new Thread(..).start();
        return;
    }

    void runOnUiThread(Runnable p0) {
        if (if-eqz(mActivity)) goto L_8;
        mActivity.runOnUiThread(p0);
      L_8:
        Thread.currentThread();
        Looper.getMainLooper();
        Looper.getMainLooper(..).getThread();
        if (if-eq(Thread.currentThread(..), Looper.getThread(..))) goto L_1c;
        mHandler.post(p0);
      L_1c:
        p0.run();
      L_1f:
        return;
    }

    void sendSurfaceChangedEvent() {
        J0.d();
        if (if-eqz(J0.d(..))) goto L_21;
        mState.a();
        if (if-nez(J0.a(..))) goto L_f;
      L_f:
        new w0(this);
        if (if-eqz(a)) goto L_21;
        Message.obtain(a, new w0(..));
        Message.obtain(..).sendToTarget();
      L_21:
        return;
    }

    protected void setCharacterLimit(int p0) {
        new h0(this, p0);
        UnityPlayer.runOnUiThread(new h0(..));
        return;
    }

    protected void setClipboardText(String p0) {
        ClipData.newPlainText("Text", p0);
        m_ClipboardManager.setPrimaryClip(ClipData.newPlainText(..));
        return;
    }

    protected void setHideInputField(boolean p0) {
        new i0(this, p0);
        UnityPlayer.runOnUiThread(new i0(..));
        return;
    }

    public void setMainSurfaceViewAspectRatio(float p0) {
        if (if-eqz(mGlView)) goto L_c;
        new t0(this, p0);
        UnityPlayer.runOnUiThread(new t0(..));
      L_c:
        return;
    }

    public void setOnHandleFocusListener(v p0) {
        mOnHandleFocusListener = p0;
        return;
    }

    public void setScreenBrightness(float p0) {
        Math.max(1025758986, p0);
        if (if-eqz(m_Window)) goto L_1c;
        UnityPlayer.getScreenBrightness();
        if (if-nez(UnityPlayer.getScreenBrightness(..))) goto L_14;
      L_14:
        new u0(this, Math.max(..));
        UnityPlayer.runOnUiThread(new u0(..));
      L_1c:
        return;
    }

    protected void setSelection(int p0, int p1) {
        new j0(this, p0, p1);
        UnityPlayer.runOnUiThread(new j0(..));
        return;
    }

    protected void setSoftInputStr(String p0) {
        new g0(this, p0);
        UnityPlayer.runOnUiThread(new g0(..));
        return;
    }

    protected void setupUnityToBePaused() {
        if (if-eqz(m_ARCoreApi)) goto L_7;
        m_ARCoreApi.pauseARCore();
      L_7:
        if (if-eqz(mVideoPlayerProxy)) goto L_e;
        mVideoPlayerProxy.b();
      L_e:
        if (if-eqz(m_AudioVolumeHandler)) goto L_18;
        m_AudioVolumeHandler.a();
        m_AudioVolumeHandler = 0;
      L_18:
        if (if-eqz(m_OrientationLockListener)) goto L_21;
        m_OrientationLockListener.a();
        m_OrientationLockListener = 0;
      L_21:
        UnityPlayer.pauseUnity();
        return;
    }

    protected void setupUnityToBeResumed() {
        if (if-eqz(m_ARCoreApi)) goto L_7;
        m_ARCoreApi.resumeARCore();
      L_7:
        mState.e(0);
        if (if-eqz(mVideoPlayerProxy)) goto L_14;
        mVideoPlayerProxy.c();
      L_14:
        UnityPlayer.checkResumePlayer();
        J0.d();
        if (if-eqz(J0.d(..))) goto L_20;
        UnityPlayer.nativeRestartActivityIndicator();
      L_20:
        if (if-nez(m_AudioVolumeHandler)) goto L_2d;
        new AudioVolumeHandler(mContext);
        m_AudioVolumeHandler = new AudioVolumeHandler(..);
      L_2d:
        if (if-nez(m_OrientationLockListener)) goto L_40;
        J0.d();
        if (if-eqz(J0.d(..))) goto L_40;
        new OrientationLockListener(mContext);
        m_OrientationLockListener = new OrientationLockListener(..);
      L_40:
        View.getResources();
        View.getResources(..).getConfiguration();
        prevConfig = Resources.getConfiguration(..);
        return;
    }

    protected void showSoftInput(String p0, int p1, boolean p2, boolean p3, boolean p4, boolean p5, String p6, int p7, boolean p8, boolean p9) {
        new Semaphore(0);
        new b0(this, this, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, new Semaphore(..));
        UnityPlayer.postOnUiThread(new b0);
        UnityPlayer.getSoftInputTimeout();
        new Semaphore(..).tryAcquire(UnityPlayer.getSoftInputTimeout(..), this, TimeUnit.MILLISECONDS);
        if (if-nez(Semaphore.tryAcquire(..))) goto L_5c;
        new StringBuilder("Timeout (");
        UnityPlayer.getSoftInputTimeout();
        new StringBuilder(..).append(UnityPlayer.getSoftInputTimeout(..), TimeUnit.MILLISECONDS);
        new StringBuilder(..).append(" ms) while waiting softinput showing operation.");
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
        t.Log(6, "UI thread got interrupted while waiting softinput showing operation.");
      L_5c:
        return;
    }

    protected boolean showVideoPlayer(String p0, int p1, int p2, int p3, boolean p4, int p5, int p6) {
        if (if-nez(mVideoPlayerProxy)) goto L_c;
        new U0(this);
        mVideoPlayerProxy = new U0(..);
      L_c:
        new p0(this);
        mVideoPlayerProxy.a(mContext, p0, p1, p2, p3, p4, v9, v10, v11, v12, new p0(..));
        if (if-eqz(U0.a(..))) goto L_32;
        new q0(this);
        UnityPlayer.runOnUiThread(new q0(..));
      L_32:
        return U0.a(..);
    }

    protected boolean skipPermissionsDialog() {
        if (if-eqz(mActivity)) goto L_9;
        UnityPermissions.skipPermissionsDialog(mActivity);
        return UnityPermissions.skipPermissionsDialog(..);
      L_9:
        return 0;
    }

    public boolean startOrientationListener(int p0) {
        if (if-eqz(mOrientationListener)) goto L_c;
      L_8:
        t.Log(5, "Orientation Listener already started.");
        return 0;
      L_c:
        new s0(this, mContext, "Orientation Listener already started.");
        mOrientationListener = new s0(..);
        new s0(..).canDetectOrientation();
        if (if-eqz(OrientationEventListener.canDetectOrientation(..))) goto L_22;
        mOrientationListener.enable();
        return 1;
      L_22:
    }

    public boolean stopOrientationListener() {
        if (if-nez(mOrientationListener)) goto L_c;
        t.Log(5, "Orientation Listener was not started.");
        return 0;
      L_c:
        0.disable();
        mOrientationListener = 0;
        return 1;
    }

    protected void toggleGyroscopeSensor(boolean p0) {
        mContext.getSystemService("sensor");
        Context.getSystemService(..).getDefaultSensor(11);
        if (if-eqz(p0)) goto L_19;
        Context.getSystemService(..).registerListener(m_FakeListener, SensorManager.getDefaultSensor(..), 1);
      L_19:
        Context.getSystemService(..).unregisterListener(m_FakeListener);
      L_1e:
        return;
    }

    public void unload() {
        UnityPlayer.nativeApplicationUnload();
        return;
    }

    void updateGLDisplay(int p0, Surface p1) {
        if (if-eqz(mMainDisplayOverride)) goto L_5;
        return;
      L_5:
        UnityPlayer.updateDisplayInternal(p0, p1);
        return;
    }

    public void windowFocusChanged(boolean p0) {
        mState.b(p0);
        mState.a();
        if (if-eqz(J0.a(..))) goto L_2b;
        if (if-eqz(mSoftInput)) goto L_18;
        mSoftInput.d();
        if (if-nez(I.d(..))) goto L_18;
      L_18:
        if (if-eqz(p0)) goto L_1f;
      L_1f:
      L_21:
        H0.-$$Nest$ma(m_MainThread, F0.f);
        UnityPlayer.raiseFocusListener(p0);
        UnityPlayer.checkResumePlayer();
        return;
      L_2b:
        UnityPlayer.raiseFocusListener(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.UnityPlayerActivity
// ============================================================
package com.unity3d.player;

public class UnityPlayerActivity extends Activity {
    protected UnityPlayer mUnityPlayer;

    public UnityPlayerActivity() {
        new Activity();
        return;
    }

    public boolean dispatchKeyEvent(KeyEvent p0) {
        p0.getAction();
        if (if-ne(KeyEvent.getAction(..), 2)) goto L_e;
        mUnityPlayer.injectEvent(p0);
        return UnityPlayer.injectEvent(..);
      L_e:
        Activity.dispatchKeyEvent(UnityPlayer.injectEvent(..));
        return Activity.dispatchKeyEvent(..);
    }

    public void onConfigurationChanged(Configuration p0) {
        Activity.onConfigurationChanged(p0);
        mUnityPlayer.configurationChanged(p0);
        return;
    }

    protected void onCreate(Bundle p0) {
        UnityPlayerActivity.requestWindowFeature(1);
        Activity.onCreate(p0);
        UnityPlayerActivity.getIntent();
        UnityPlayerActivity.getIntent(..).getStringExtra("unity");
        UnityPlayerActivity.updateUnityCommandLineArguments(Intent.getStringExtra(..));
        UnityPlayerActivity.getIntent();
        UnityPlayerActivity.getIntent(..).putExtra("unity", UnityPlayerActivity.updateUnityCommandLineArguments(..));
        new UnityPlayer(this, this);
        mUnityPlayer = new UnityPlayer(..);
        UnityPlayerActivity.setContentView(new UnityPlayer(..));
        mUnityPlayer.requestFocus();
        return;
    }

    protected void onDestroy() {
        mUnityPlayer.destroy();
        Activity.onDestroy();
        return;
    }

    public boolean onGenericMotionEvent(MotionEvent p0) {
        mUnityPlayer.onGenericMotionEvent(p0);
        return UnityPlayer.onGenericMotionEvent(..);
    }

    public boolean onKeyDown(int p0, KeyEvent p1) {
        mUnityPlayer.onKeyDown(p0, p1);
        return UnityPlayer.onKeyDown(..);
    }

    public boolean onKeyUp(int p0, KeyEvent p1) {
        mUnityPlayer.onKeyUp(p0, p1);
        return UnityPlayer.onKeyUp(..);
    }

    public void onLowMemory() {
        Activity.onLowMemory();
        mUnityPlayer.lowMemory();
        return;
    }

    protected void onNewIntent(Intent p0) {
        UnityPlayerActivity.setIntent(p0);
        mUnityPlayer.newIntent(p0);
        return;
    }

    protected void onPause() {
        Activity.onPause();
        mUnityPlayer.onPause();
        return;
    }

    protected void onResume() {
        Activity.onResume();
        mUnityPlayer.onResume();
        return;
    }

    protected void onStart() {
        Activity.onStart();
        mUnityPlayer.onStart();
        return;
    }

    protected void onStop() {
        Activity.onStop();
        mUnityPlayer.onStop();
        return;
    }

    public boolean onTouchEvent(MotionEvent p0) {
        mUnityPlayer.onTouchEvent(p0);
        return UnityPlayer.onTouchEvent(..);
    }

    public void onTrimMemory(int p0) {
        Activity.onTrimMemory(p0);
        if (if-ne(p0, 15)) goto L_c;
        mUnityPlayer.lowMemory();
      L_c:
        return;
    }

    public void onUnityPlayerQuitted() {
        return;
    }

    public void onUnityPlayerUnloaded() {
        UnityPlayerActivity.moveTaskToBack(1);
        return;
    }

    public void onWindowFocusChanged(boolean p0) {
        Activity.onWindowFocusChanged(p0);
        mUnityPlayer.windowFocusChanged(p0);
        return;
    }

    protected String updateUnityCommandLineArguments(String p0) {
        return p0;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_042 (orig: V)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_042
package com.unity3d.player;

final class AppClass_042 /* orig: V */ {
    private Context a;
    private U b;

    public V(Context p0) {
        new Object();
        a = p0;
        return;
    }

    public final void a() {
        if (if-eqz(b)) goto L_12;
        a.getContentResolver();
        Context.getContentResolver(..).unregisterContentObserver(b);
        b = 0;
      L_12:
        return;
    }

    public final void a(T p0) {
        Looper.getMainLooper();
        new Handler(Looper.getMainLooper(..));
        new U(new Handler(..), p0);
        b = new U(..);
        a.getContentResolver();
        Settings$System.getUriFor("accelerometer_rotation");
        Context.getContentResolver(..).registerContentObserver(Settings$System.getUriFor(..), 1, b);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_043 (orig: W)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_043
package com.unity3d.player;

final class AppClass_043 /* orig: W */ {
    private Thread$UncaughtExceptionHandler a;
    private String b;

    W() {
        new Object();
        return;
    }

    static void a(String p0) {
        Thread.getDefaultUncaughtExceptionHandler();
        if (if-eqz(v1)) goto L_28;
      L_d:
        p0.indexOf(47, v4);
        if (if-ne(String.indexOf(..), -1)) goto L_25;
        if (if-gez(-1)) goto L_1c;
      L_1c:
        "Unknown".substring(-1);
      L_22:
        b = String.substring(..);
      L_25:
      L_28:
        return;
    }

    final void a() {
        Thread.getDefaultUncaughtExceptionHandler();
        if (if-ne(Thread.getDefaultUncaughtExceptionHandler(..), this)) goto L_9;
        return;
      L_9:
        a = Thread.getDefaultUncaughtExceptionHandler(..);
        b = "Unknown";
        Thread.setDefaultUncaughtExceptionHandler(this);
        return;
        throw "Unknown";
    }

    public final void uncaughtException(Thread p0, Throwable p1) {
        new StringBuilder();
        p0.getName();
        String.format("FATAL EXCEPTION [%s]\n", v4);
        new StringBuilder(..).append(String.format(..));
        String.format("Unity version     : %s\n", v4);
        new StringBuilder(..).append(String.format(..));
        String.format("Device model      : %s %s\n", 2);
        new StringBuilder(..).append(String.format(..));
        String.format("Device fingerprint: %s\n", 2);
        new StringBuilder(..).append(String.format(..));
        Arrays.toString(Build.SUPPORTED_ABIS);
        String.format("CPU supported ABI : %s\n", 2);
        new StringBuilder(..).append(String.format(..));
        String.format("Build Type        : %s\n", 2);
        new StringBuilder(..).append(String.format(..));
        String.format("Scripting Backend : %s\n", 2);
        new StringBuilder(..).append(String.format(..));
        String.format("Libs loaded from  : %s\n", 2);
        new StringBuilder(..).append(String.format(..));
        String.format("Strip Engine Code : %s\n", 1);
        new StringBuilder(..).append(String.format(..));
        new StringBuilder(..).toString();
        new Error(StringBuilder.toString(..));
        new Error(..).setStackTrace(StringBuilder.toString(..));
        new Error(..).initCause(p1);
        a.uncaughtException(p0, new Error(..));
        a.uncaughtException(p0, p1);
      L_b6:
        return;
        throw p0;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_044 (orig: X)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_044
package com.unity3d.player;

final class AppClass_044 /* orig: X */ {
    final Y a;

    X(Y p0) {
        a = p0;
        new Object();
        return;
    }

    public final void surfaceChanged(SurfaceHolder p0, int p1, int p2, int p3) {
        Y.-$$Nest$fgetb(a);
        p0.getSurface();
        Y.-$$Nest$fgetb(..).updateGLDisplay(0, SurfaceHolder.getSurface(..));
        Y.-$$Nest$fgetb(a);
        Y.-$$Nest$fgetb(..).sendSurfaceChangedEvent();
        return;
    }

    public final void surfaceCreated(SurfaceHolder p0) {
        Y.-$$Nest$fgetb(a);
        p0.getSurface();
        Y.-$$Nest$fgetb(..).updateGLDisplay(0, SurfaceHolder.getSurface(..));
        Y.-$$Nest$fgetc(a);
        Y.-$$Nest$fgetb(a);
        if (if-eqz(b)) goto L_2c;
        b.getParent();
        if (if-nez(View.getParent(..))) goto L_2c;
        Y.-$$Nest$fgetb(..).addView(b);
        Y.-$$Nest$fgetb(..).bringChildToFront(b);
      L_2c:
        return;
    }

    public final void surfaceDestroyed(SurfaceHolder p0) {
        Y.-$$Nest$fgetc(a);
        Y.-$$Nest$fgeta(a);
        Y.-$$Nest$fgetc(..).getClass();
        if (if-eqz(PlatformSupport.NOUGAT_SUPPORT)) goto L_27;
        if (if-eqz(a)) goto L_27;
        if (if-nez(b)) goto L_22;
        new A(a);
        b = new A(..);
      L_22:
        b.a(Y.-$$Nest$fgeta(..));
      L_27:
        Y.-$$Nest$fgetb(a);
        Y.-$$Nest$fgetb(..).updateGLDisplay(0, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_045 (orig: Y)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_045
package com.unity3d.player;

final class AppClass_045 /* orig: Y */ extends FrameLayout {
    private a a;
    private UnityPlayer b;
    private B c;

    static a -$$Nest$fgeta(Y p0) {
        return a;
    }

    static UnityPlayer -$$Nest$fgetb(Y p0) {
        return b;
    }

    static B -$$Nest$fgetc(Y p0) {
        return c;
    }

    public Y(Context p0, UnityPlayer p1) {
        new FrameLayout(p0);
        new B(p0);
        c = new B(..);
        b = p1;
        new a(p0, p1);
        a = new a(..);
        p0.getResources();
        p0.getPackageName();
        Context.getResources(..).getIdentifier("unitySurfaceView", "id", Context.getPackageName(..));
        new a(..).setId(Resources.getIdentifier(..));
        Y.a();
        if (if-eqz(Y.a(..))) goto L_3f;
        a.getHolder();
        SurfaceView.getHolder(..).setFormat(-3);
        a.setZOrderOnTop(1);
      L_3f:
        a.getHolder();
        SurfaceView.getHolder(..).setFormat(-1);
      L_4a:
        new FrameLayout(..).setBackgroundColor(0xff000000);
        a.getHolder();
        new X(new FrameLayout(..));
        SurfaceView.getHolder(..).addCallback(new X(..));
        a.setFocusable(1);
        a.setFocusableInTouchMode(1);
        Y.a(p0);
        a.setContentDescription(Y.a(..));
        new FrameLayout$LayoutParams(-1, -1, 17);
        new FrameLayout(..).addView(a, new FrameLayout$LayoutParams(..));
        return;
    }

    private static String a(Context p0) {
        p0.getResources();
        p0.getResources();
        p0.getPackageName();
        Context.getResources(..).getIdentifier("game_view_content_description", "string", Context.getPackageName(..));
        Context.getResources(..).getString(Resources.getIdentifier(..));
        return Resources.getString(..);
    }

    private static boolean a() {
        if (if-nez(UnityPlayer.currentActivity)) goto L_6;
        return 0;
      L_6:
        UnityPlayer.currentActivity.getTheme();
        Context.getTheme(..).obtainStyledAttributes(1);
        TypedArray.getBoolean(0, 0);
        TypedArray.recycle();
        return TypedArray.getBoolean(..);
    }

    final void a(float p0) {
        a.a(p0);
        return;
    }

    public final void b() {
        if (if-eqz(b)) goto L_13;
        b.getParent();
        if (if-eqz(View.getParent(..))) goto L_13;
        b.removeView(b);
      L_13:
        b = 0;
        return;
    }

    public final boolean c() {
        if (if-eqz(a)) goto L_c;
        a.a();
        if (if-eqz(a.a(..))) goto L_c;
      L_c:
      L_d:
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_046 (orig: Z)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_046
package com.unity3d.player;

final class AppClass_046 /* orig: Z */ {
    final UnityPlayer a;

    Z(UnityPlayer p0) {
        a = p0;
        new Object();
        return;
    }

    public final void run() {
        UnityPlayer.-$$Nest$mnativeResume(a);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppCanvasView_047 (orig: a)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppCanvasView_047
package com.unity3d.player;

final class AppCanvasView_047 /* orig: a */ extends SurfaceView {
    private float a;
    private UnityPlayer b;

    public a(Context p0, UnityPlayer p1) {
        new SurfaceView(p0);
        b = p1;
        return;
    }

    public final void a(float p0) {
        a = p0;
        View.getLayoutParams();
        if (if-gtz(p0)) goto L_d;
      L_d:
      L_e:
        width = -2;
        height = -2;
        View.setLayoutParams(View.getLayoutParams(..));
        return;
    }

    public final boolean a() {
        if (if-lez(a)) goto L_9;
      L_9:
      L_a:
        return 0;
    }

    public final boolean onGenericMotionEvent(MotionEvent p0) {
        a.a();
        if (if-eqz(a.a(..))) goto L_d;
        b.injectEvent(p0);
      L_d:
      L_e:
        return 0;
    }

    protected void onMeasure(int p0, int p1) {
        if (if-gtz(a)) goto L_b;
        SurfaceView.onMeasure(p0, p1);
        return;
      L_b:
        View$MeasureSpec.getSize(p0);
        View$MeasureSpec.getSize(p1);
        if (if-lez(View$MeasureSpec.getSize(..))) goto L_39;
        if (if-lez(View$MeasureSpec.getSize(..))) goto L_39;
        View$MeasureSpec.getMode(p0);
        if (if-ne(View$MeasureSpec.getMode(..), 0x80000000)) goto L_39;
        View$MeasureSpec.getMode(p1);
        if (if-eq(View$MeasureSpec.getMode(..), 0x80000000)) goto L_26;
      L_26:
        if (if-gez(View$MeasureSpec.getMode(..))) goto L_33;
      L_33:
      L_35:
        View.setMeasuredDimension(View$MeasureSpec.getSize(..), View$MeasureSpec.getSize(..));
        return;
      L_39:
        SurfaceView.onMeasure(p0, p1);
        return;
    }

    public final boolean onTouchEvent(MotionEvent p0) {
        a.a();
        if (if-eqz(a.a(..))) goto L_d;
        b.injectEvent(p0);
      L_d:
      L_e:
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_048 (orig: a0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_048
package com.unity3d.player;

final class AppClass_048 /* orig: a0 */ {
    final b0 a;

    a0(b0 p0) {
        a = p0;
        new Object();
        return;
    }

    public final void a() {
        UnityPlayer.-$$Nest$mnativeSoftInputLostFocus(m);
        m.reportSoftInputStr(0, 1, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_049 (orig: b)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_049
package com.unity3d.player;

final class AppClass_049 /* orig: b */ {
    private Set a;
    private String b;
    private int c;
    private long d;
    private long e;
    private int f;
    private int g;

    b(Set p0, String p1, int p2, long p3, long p4, int p5, int p6) {
        new Object();
        a = p0;
        b = p1;
        c = p2;
        d = p3;
        e = p4;
        f = p5;
        g = p6;
        return;
    }

    public final void run() {
        a.iterator();
      L_6:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_23;
        Set.iterator(..).next();
        Iterator.next(..).onStatusUpdate(b, c, d, v6, e, v8, f, g);
      L_23:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_050 (orig: b0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_050
package com.unity3d.player;

final class AppClass_050 /* orig: b0 */ {
    final UnityPlayer a;
    final String b;
    final int c;
    final boolean d;
    final boolean e;
    final boolean f;
    final boolean g;
    final String h;
    final int i;
    final boolean j;
    final boolean k;
    final Semaphore l;
    final UnityPlayer m;

    b0(UnityPlayer p0, UnityPlayer p1, String p2, int p3, boolean p4, boolean p5, boolean p6, boolean p7, String p8, int p9, boolean p10, boolean p11, Semaphore p12) {
        m = p0;
        a = p1;
        b = p2;
        c = p3;
        d = p4;
        e = p5;
        f = p6;
        g = p7;
        h = p8;
        i = p9;
        j = p10;
        k = p11;
        l = p12;
        new Object();
        return;
    }

    public final void run() {
        if (if-eqz(mSoftInput)) goto L_b;
        UnityPlayer.-$$Nest$mdismissSoftInput(m);
      L_b:
        SoftInputProvider.a();
        UnityPlayer.-$$Nest$fgetmContext(m);
        a.a(SoftInputProvider.a(..));
        if (if-eq(a.a(..), 2)) goto L_26;
        new S(UnityPlayer.-$$Nest$fgetmContext(..), a);
      L_26:
        new M(UnityPlayer.-$$Nest$fgetmContext(..), a);
      L_2b:
        mSoftInput = new M(..);
        mSoftInput.a(b, c, d, e, f, g, h, i, j, k);
        new a0(this);
        f = new a0(..);
        mSoftInput.e();
        UnityPlayer.-$$Nest$mnativeReportKeyboardConfigChanged(m);
        new StringBuilder("Exception when opening Softinput ");
        new StringBuilder(..).append(m);
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
      L_6f:
        l.release();
        return;
      L_75:
        l.release();
        throw l;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_051 (orig: c)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_051
package com.unity3d.player;

final class AppClass_051 /* orig: c */ {
    private HashSet a;
    private Looper b;
    final i c;

    public c(i p0, IAssetPackManagerDownloadStatusCallback p1, Looper p2) {
        c = p0;
        new Object();
        new HashSet();
        a = new HashSet(..);
        new HashSet(..).add(p1);
        b = p2;
        return;
    }

    public final void a(IAssetPackManagerDownloadStatusCallback p0) {
        a.add(p0);
        return;
        throw p0;
    }

    public final void onStateUpdate(Object p0) {
        p0.status();
        if (if-eq(AssetPackState.status(..), 4)) goto L_17;
        p0.status();
        if (if-eq(AssetPackState.status(..), 5)) goto L_17;
        p0.status();
        if (if-nez(AssetPackState.status(..))) goto L_45;
      L_17:
        i.-$$Nest$sfgetd();
        i.-$$Nest$fgetb(c);
        p0.name();
        i.-$$Nest$fgetb(..).remove(AssetPackState.name(..));
        i.-$$Nest$fgetb(c);
        i.-$$Nest$fgetb(..).isEmpty();
        if (if-eqz(HashSet.isEmpty(..))) goto L_44;
        i.-$$Nest$fgetc(c);
        c.a(i.-$$Nest$fgetc(..));
        i.-$$Nest$fputc(c, 0);
      L_44:
      L_45:
        a.size();
        if (if-nez(HashSet.size(..))) goto L_4f;
      L_4d:
      L_4f:
        new Handler(b);
        a.clone();
        p0.name();
        p0.status();
        p0.totalBytesToDownload();
        p0.bytesDownloaded();
        p0.transferProgressPercentage();
        p0.errorCode();
        new b(HashSet.clone(..), AssetPackState.name(..), AssetPackState.status(..), AssetPackState.totalBytesToDownload(..), v7, AssetPackState.bytesDownloaded(..), v9, AssetPackState.transferProgressPercentage(..), AssetPackState.errorCode(..));
        new Handler(..).post(new b);
      L_81:
        return;
        throw p0;
        throw p0;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_052 (orig: c0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_052
package com.unity3d.player;

final class AppClass_052 /* orig: c0 */ {
    final UnityPlayer a;

    c0(UnityPlayer p0) {
        a = p0;
        new Object();
        return;
    }

    public final void run() {
        UnityPlayer.-$$Nest$fgetmGlView(a);
        if (if-eqz(UnityPlayer.-$$Nest$fgetmGlView(..))) goto L_b;
        UnityPlayer.-$$Nest$fgetmGlView(..).b();
      L_b:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_053 (orig: d)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_053
package com.unity3d.player;

final class AppClass_053 /* orig: d */ {
    private IAssetPackManagerMobileDataConfirmationCallback a;
    private boolean b;

    d(IAssetPackManagerMobileDataConfirmationCallback p0, boolean p1) {
        new Object();
        a = p0;
        b = p1;
        return;
    }

    public final void run() {
        a.onMobileDataConfirmationResult(b);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_054 (orig: d0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_054
package com.unity3d.player;

final class AppClass_054 /* orig: d0 */ {
    final f0 a;

    d0(f0 p0) {
        a = p0;
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_055 (orig: e)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_055
package com.unity3d.player;

final class AppClass_055 /* orig: e */ {
    private IAssetPackManagerMobileDataConfirmationCallback a;
    private Looper b;

    public e(IAssetPackManagerMobileDataConfirmationCallback p0) {
        new Object();
        a = p0;
        Looper.myLooper();
        b = Looper.myLooper(..);
        return;
    }

    public final void onSuccess(Object p0) {
        if (if-eqz(a)) goto L_21;
        new Handler(b);
        p0.intValue();
        if (if-ne(Integer.intValue(..), -1)) goto L_1a;
      L_1a:
      L_1b:
        new d(a, 0);
        new Handler(..).post(new d(..));
      L_21:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_056 (orig: e0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_056
package com.unity3d.player;

final class AppClass_056 /* orig: e0 */ {
    final f0 a;

    e0(f0 p0) {
        a = p0;
        new Object();
        return;
    }

    public final void a() {
        a = 1;
        if (if-eqz(b)) goto L_e;
        c.release();
      L_e:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_057 (orig: f)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_057
package com.unity3d.player;

final class AppClass_057 /* orig: f */ {
    private IAssetPackManagerDownloadStatusCallback a;
    private Looper b;
    private String c;

    public f(String p0, IAssetPackManagerDownloadStatusCallback p1) {
        new Object();
        a = p1;
        Looper.myLooper();
        b = Looper.myLooper(..);
        c = p0;
        return;
    }

    public final void onComplete(Task p0) {
        p0.getResult();
        Task.getResult(..).packStates();
        AssetPackStates.packStates(..).size();
        if (if-nez(Map.size(..))) goto L_13;
        return;
      L_13:
        AssetPackStates.packStates(..).values();
        Map.values(..).iterator();
      L_1b:
        Collection.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_b9;
        Collection.iterator(..).next();
        Iterator.next(..).errorCode();
        if (if-nez(AssetPackState.errorCode(..))) goto L_88;
        Iterator.next(..).status();
        if (if-eq(AssetPackState.status(..), 4)) goto L_88;
        Iterator.next(..).status();
        if (if-eq(AssetPackState.status(..), 5)) goto L_88;
        Iterator.next(..).status();
        if (if-nez(AssetPackState.status(..))) goto L_42;
      L_42:
        i.-$$Nest$sfgetd();
        Iterator.next(..).name();
        i.-$$Nest$sfgetd(..).getClass();
        i.-$$Nest$sfgetd();
        i.-$$Nest$fgetc(i.-$$Nest$sfgetd(..));
        if (if-nez(i.-$$Nest$fgetc(..))) goto L_6c;
        new c(i.-$$Nest$sfgetd(..), a, b);
        i.-$$Nest$fgeta(i.-$$Nest$sfgetd(..));
        i.-$$Nest$fgeta(..).registerListener(new c(..));
        i.-$$Nest$fputc(i.-$$Nest$sfgetd(..), new c(..));
      L_6c:
        new c(..).a(i.-$$Nest$fgeta(..));
      L_71:
        i.-$$Nest$fgetb(i.-$$Nest$sfgetd(..));
        i.-$$Nest$fgetb(..).add(AssetPackState.name(..));
        i.-$$Nest$fgeta(i.-$$Nest$sfgetd(..));
        Collections.singletonList(AssetPackState.name(..));
        i.-$$Nest$fgeta(..).fetch(Collections.singletonList(..));
        throw Task.getResult(..);
      L_88:
        Collections.singletonList(..).name();
        Collections.singletonList(..).status();
        Collections.singletonList(..).errorCode();
        Task.getResult(..).totalBytes();
        if (if-ne(AssetPackState.status(..), i.-$$Nest$fgetb(..))) goto L_9c;
      L_9c:
      L_9f:
        new Handler(b);
        Collections.singleton(a);
        new b(Collections.singleton(..), AssetPackState.name(..), AssetPackState.status(..), AssetPackStates.totalBytes(..), v13, 0L, v15, 0, AssetPackState.errorCode(..));
        new Handler(..).post(new b);
      L_b9:
        return;
      L_bd:
        if (if-eqz(Collection.iterator(..))) goto L_c9;
        Task.getResult(..).getErrorCode();
      L_c7:
      L_c9:
        AssetPackException.getErrorCode(..).getCause();
        if (if-nez(Throwable.getCause(..))) goto L_bd;
      L_d2:
        new Handler(b);
        Collections.singleton(a);
        new b(Collections.singleton(..), c, 0, 0L, i.-$$Nest$sfgetd(..), 0L, Collections.singleton(..), 0, AssetPackException.getErrorCode(..));
        new Handler(..).post(new b);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_058 (orig: f0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_058
package com.unity3d.player;

final class AppClass_058 /* orig: f0 */ {
    boolean a;
    boolean b;
    final Semaphore c;
    final UnityPlayer d;
    final UnityPlayer e;

    f0(UnityPlayer p0, Semaphore p1, UnityPlayer p2) {
        e = p0;
        c = p1;
        d = p2;
        new Object();
        a = 0;
        b = 0;
        return;
    }

    public final void run() {
        new Rect();
        e.reportSoftInputArea(new Rect(..));
        e.reportSoftInputIsVisible(0);
        if (if-eqz(mSoftInput)) goto L_2e;
        new d0(this);
        d.setOnHandleFocusListener(new d0(..));
        new e0(this);
        g = new e0(..);
        UnityPlayer.-$$Nest$mdismissSoftInput(e);
      L_2e:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_059 (orig: g)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_059
package com.unity3d.player;

final class AppClass_059 /* orig: g */ {
    private IAssetPackManagerStatusQueryCallback a;
    private long b;
    private String[] c;
    private int[] d;
    private int[] e;

    g(IAssetPackManagerStatusQueryCallback p0, long p1, String[] p2, int[] p3, int[] p4) {
        new Object();
        a = p0;
        b = p1;
        c = p2;
        d = p3;
        e = p4;
        return;
    }

    public final void run() {
        a.onStatusResult(b, v2, c, d, e);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_060 (orig: g0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_060
package com.unity3d.player;

final class AppClass_060 /* orig: g0 */ {
    final String a;
    final UnityPlayer b;

    g0(UnityPlayer p0, String p1) {
        b = p0;
        a = p1;
        new Object();
        return;
    }

    public final void run() {
        if (if-eqz(mSoftInput)) goto L_1a;
        if (if-eqz(a)) goto L_1a;
        if (if-eqz(c)) goto L_1a;
        c.setText(a);
        a.length();
        c.setSelection(String.length(..));
      L_1a:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_061 (orig: h)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_061
package com.unity3d.player;

final class AppClass_061 /* orig: h */ {
    private IAssetPackManagerStatusQueryCallback a;
    private Looper b;
    private String[] c;

    public h(String[] p0, IAssetPackManagerStatusQueryCallback p1) {
        new Object();
        a = p1;
        Looper.myLooper();
        b = Looper.myLooper(..);
        c = p0;
        return;
    }

    public final void onComplete(Task p0) {
        if (if-nez(a)) goto L_7;
        return;
      L_7:
        p0.getResult();
        Task.getResult(..).packStates();
        AssetPackStates.packStates(..).size();
        AssetPackStates.packStates(..).values();
        Map.values(..).iterator();
      L_25:
        Collection.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_45;
        Collection.iterator(..).next();
        Iterator.next(..).name();
        Iterator.next(..).status();
        Iterator.next(..).errorCode();
      L_45:
        new Handler(b);
        Task.getResult(..).totalBytes();
        new g(a, AssetPackStates.totalBytes(..), v9, v10, v11, v12);
        new Handler(..).post(new g);
        return;
        Task.getResult(..).getMessage();
      L_65:
        if (if-ge(new g, new g(..))) goto L_aa;
        Throwable.getMessage(..).contains(v9);
        if (if-eqz(String.contains(..))) goto L_a7;
        new Handler(b);
      L_86:
        if (if-eqz(c)) goto L_91;
        Task.getResult(..).getErrorCode();
      L_91:
        Task.getResult(..).getCause();
        if (if-nez(Throwable.getCause(..))) goto L_86;
      L_97:
        new g(a, 0L, v14, v15, v9, new Handler(..));
        new Handler(..).post(new g);
        return;
      L_a7:
      L_aa:
      L_b3:
        if (if-ge(new g, c)) goto L_d2;
      L_bb:
        if (if-eqz(c)) goto L_c6;
        Throwable.getCause(..).getErrorCode();
      L_c6:
        AssetPackException.getErrorCode(..).getCause();
        if (if-nez(Throwable.getCause(..))) goto L_bb;
      L_cd:
      L_d2:
        new Handler(b);
        new g(a, 0L, a, c, v14, v15);
        new Handler(..).post(new g);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_062 (orig: h0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_062
package com.unity3d.player;

final class AppClass_062 /* orig: h0 */ {
    final int a;
    final UnityPlayer b;

    h0(UnityPlayer p0, int p1) {
        b = p0;
        a = p1;
        new Object();
        return;
    }

    public final void run() {
        if (if-eqz(mSoftInput)) goto L_22;
        if (if-eqz(c)) goto L_22;
        if (if-lez(a)) goto L_1d;
        new InputFilter$LengthFilter(a);
        c.setFilters(1);
      L_1d:
        c.setFilters(a);
      L_22:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_063 (orig: i)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_063
package com.unity3d.player;

final class AppClass_063 /* orig: i */ {
    private static i d;
    private AssetPackManager a;
    private HashSet b;
    private Object c;

    static AssetPackManager -$$Nest$fgeta(i p0) {
        return a;
    }

    static HashSet -$$Nest$fgetb(i p0) {
        return b;
    }

    static Object -$$Nest$fgetc(i p0) {
        return c;
    }

    static void -$$Nest$fputc(i p0, Object p1) {
        c = p1;
        return;
    }

    static i -$$Nest$sfgetd() {
        return i.d;
    }

    private i(Context p0) {
        new Object();
        if (if-nez(i.d)) goto L_15;
        AssetPackManagerFactory.getInstance(p0);
        a = AssetPackManagerFactory.getInstance(..);
        new HashSet();
        b = new HashSet(..);
        return;
      L_15:
        new RuntimeException("AssetPackManagerWrapper should be created only once. Use getInstance() instead.");
        throw new RuntimeException(..);
    }

    public static i a(Context p0) {
        if (if-nez(i.d)) goto L_b;
        new i(p0);
        d = new i(..);
      L_b:
        return i.d;
    }

    public final Object a(IAssetPackManagerDownloadStatusCallback p0) {
        Looper.myLooper();
        new c(this, p0, Looper.myLooper(..));
        a.registerListener(new c(..));
        return new c(..);
    }

    public final String a(String p0) {
        a.getPackLocation(p0);
        if (if-nez(AssetPackManager.getPackLocation(..))) goto L_b;
        return "";
      L_b:
        "".assetsPath();
        return AssetPackLocation.assetsPath(..);
    }

    public final void a(Activity p0, IAssetPackManagerMobileDataConfirmationCallback p1) {
        a.showCellularDataConfirmation(p0);
        new e(p1);
        Task.addOnSuccessListener(new e(..));
        return;
    }

    public final void a(Object p0) {
        if (if-nez(v0)) goto L_5;
        return;
      L_5:
        a.unregisterListener(p0);
        return;
    }

    public final void a(String[] p0) {
        Arrays.asList(p0);
        a.cancel(Arrays.asList(..));
        return;
    }

    public final void a(String[] p0, IAssetPackManagerDownloadStatusCallback p1) {
      L_2:
        if (if-ge(0, v0)) goto L_1b;
        Collections.singletonList(v2);
        a.getPackStates(Collections.singletonList(..));
        new f(v2, p1);
        AssetPackManager.getPackStates(..).addOnCompleteListener(new f(..));
      L_1b:
        return;
    }

    public final void a(String[] p0, IAssetPackManagerStatusQueryCallback p1) {
        Arrays.asList(p0);
        a.getPackStates(Arrays.asList(..));
        new h(p0, p1);
        AssetPackManager.getPackStates(..).addOnCompleteListener(new h(..));
        return;
    }

    public final void b(String p0) {
        a.removePack(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_064 (orig: i0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_064
package com.unity3d.player;

final class AppClass_064 /* orig: i0 */ {
    final boolean a;
    final UnityPlayer b;

    i0(UnityPlayer p0, boolean p1) {
        b = p0;
        a = p1;
        new Object();
        return;
    }

    public final void run() {
        if (if-eqz(mSoftInput)) goto L_b;
        mSoftInput.a(a);
      L_b:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_065 (orig: j)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_065
package com.unity3d.player;

final class AppClass_065 /* orig: j */ extends ContentObserver {
    private final k a;
    private final AudioManager b;
    private final int c;
    private int d;

    public j(Handler p0, AudioManager p1, k p2) {
        new ContentObserver(p0);
        b = p1;
        c = 3;
        a = p2;
        p1.getStreamVolume(3);
        d = AudioManager.getStreamVolume(..);
        return;
    }

    public final boolean deliverSelfNotifications() {
        ContentObserver.deliverSelfNotifications();
        return ContentObserver.deliverSelfNotifications(..);
    }

    public final void onChange(boolean p0, Uri p1) {
        if (if-eqz(b)) goto L_19;
        if (if-eqz(a)) goto L_19;
        b.getStreamVolume(c);
        if (if-eq(AudioManager.getStreamVolume(..), d)) goto L_19;
        d = AudioManager.getStreamVolume(..);
        a.onAudioVolumeChanged(AudioManager.getStreamVolume(..));
      L_19:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_066 (orig: j0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_066
package com.unity3d.player;

final class AppClass_066 /* orig: j0 */ {
    final int a;
    final int b;
    final UnityPlayer c;

    j0(UnityPlayer p0, int p1, int p2) {
        c = p0;
        a = p1;
        b = p2;
        new Object();
        return;
    }

    public final void run() {
        if (if-eqz(mSoftInput)) goto L_1e;
        if (if-eqz(c)) goto L_1e;
        c.getText();
        EditText.getText(..).length();
        if (if-lt(CharSequence.length(..), b)) goto L_1e;
        c.setSelection(a, b);
      L_1e:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_067 (orig: k)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_067
package com.unity3d.player;

public abstract class AppClass_067 /* orig: k */ {
    public abstract void onAudioVolumeChanged(int p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_068 (orig: k0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_068
package com.unity3d.player;

final class AppClass_068 /* orig: k0 */ extends I0 {
    final boolean b;
    final String c;
    final int d;
    final UnityPlayer e;

    k0(UnityPlayer p0, boolean p1, String p2, int p3) {
        e = p0;
        b = p1;
        c = p2;
        d = p3;
        new I0(p0, 0);
        return;
    }

    public final void a() {
        if (if-eqz(b)) goto L_a;
        UnityPlayer.-$$Nest$mnativeSoftInputCanceled(e);
      L_a:
        if (if-eqz(c)) goto L_13;
        UnityPlayer.-$$Nest$mnativeSetInputString(e, c);
      L_13:
        if (if-ne(d, 1)) goto L_1d;
        UnityPlayer.-$$Nest$mnativeSoftInputClosed(e);
      L_1d:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_069 (orig: l)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_069
package com.unity3d.player;

final class AppClass_069 /* orig: l */ {
    private final Context a;
    private final AudioManager b;
    private j c;

    public l(Context p0) {
        new Object();
        a = p0;
        p0.getSystemService("audio");
        b = Context.getSystemService(..);
        return;
    }

    public final void a() {
        if (if-eqz(c)) goto L_12;
        a.getContentResolver();
        Context.getContentResolver(..).unregisterContentObserver(c);
        c = 0;
      L_12:
        return;
    }

    public final void a(k p0) {
        Looper.getMainLooper();
        new Handler(Looper.getMainLooper(..));
        new j(new Handler(..), b, p0);
        c = new j(..);
        a.getContentResolver();
        Context.getContentResolver(..).registerContentObserver(Settings$System.CONTENT_URI, 1, c);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_070 (orig: l0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_070
package com.unity3d.player;

final class AppClass_070 /* orig: l0 */ extends I0 {
    final int b;
    final int c;
    final UnityPlayer d;

    l0(UnityPlayer p0, int p1, int p2) {
        d = p0;
        b = p1;
        c = p2;
        new I0(p0, 0);
        return;
    }

    public final void a() {
        UnityPlayer.-$$Nest$mnativeSetInputSelection(d, b, c);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_071 (orig: m)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_071
package com.unity3d.player;

final class AppClass_071 /* orig: m */ extends CameraCaptureSession$CaptureCallback {
    final r a;

    m(r p0) {
        a = p0;
        new CameraCaptureSession$CaptureCallback();
        return;
    }

    public final void onCaptureCompleted(CameraCaptureSession p0, CaptureRequest p1, TotalCaptureResult p2) {
        p1.getTag();
        r.-$$Nest$ma(a, CaptureRequest.getTag(..));
        return;
    }

    public final void onCaptureFailed(CameraCaptureSession p0, CaptureRequest p1, CaptureFailure p2) {
        new StringBuilder("Camera2: Capture session failed ");
        p1.getTag();
        new StringBuilder(..).append(CaptureRequest.getTag(..));
        new StringBuilder(..).append(" reason ");
        p2.getReason();
        new StringBuilder(..).append(CaptureFailure.getReason(..));
        new StringBuilder(..).toString();
        t.Log(5, StringBuilder.toString(..));
        p1.getTag();
        r.-$$Nest$ma(a, CaptureRequest.getTag(..));
        return;
    }

    public final void onCaptureSequenceAborted(CameraCaptureSession p0, int p1) {
        return;
    }

    public final void onCaptureSequenceCompleted(CameraCaptureSession p0, int p1, long p2) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_072 (orig: m0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_072
package com.unity3d.player;

final class AppClass_072 /* orig: m0 */ {
    final UnityPlayer a;

    m0(UnityPlayer p0) {
        a = p0;
        new Object();
        return;
    }

    public final void onClick(DialogInterface p0, int p1) {
        UnityPlayer.-$$Nest$mfinish(a);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_073 (orig: n)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_073
package com.unity3d.player;

final class AppClass_073 /* orig: n */ extends CameraCaptureSession$StateCallback {
    final r a;

    n(r p0) {
        a = p0;
        new CameraCaptureSession$StateCallback();
        return;
    }

    public final void onConfigureFailed(CameraCaptureSession p0) {
        t.Log(6, "Camera2: CaptureSession configuration failed.");
        return;
    }

    public void onConfigured(CameraCaptureSession p0) {
        r.-$$Nest$fgetb(a);
        if (if-nez(r.-$$Nest$fgetb(..))) goto L_d;
        return;
      L_d:
        r.-$$Nest$fgets(a);
        r.-$$Nest$fputr(a, p0);
        r.-$$Nest$fgetb(a);
        r.-$$Nest$fgetb(..).createCaptureRequest(1);
        r.-$$Nest$fputq(a, CameraDevice.createCaptureRequest(..));
        r.-$$Nest$fgetq(a);
        r.-$$Nest$fgetv(a);
        r.-$$Nest$fgetq(..).addTarget(r.-$$Nest$fgetv(..));
        r.-$$Nest$fgetq(a);
        r.-$$Nest$fgetn(a);
        r.-$$Nest$fgetq(..).set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, r.-$$Nest$fgetn(..));
        r.-$$Nest$mg(a);
        new StringBuilder("Camera2: IllegalStateException ");
        new StringBuilder(..).append(a);
        new StringBuilder(..).toString();
        new StringBuilder(new StringBuilder(..));
        new StringBuilder(..).append(StringBuilder.toString(..));
        new StringBuilder(..).toString();
      L_60:
        t.Log(6, StringBuilder.toString(..));
      L_64:
        return;
        throw StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_074 (orig: n0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_074
package com.unity3d.player;

final class AppClass_074 /* orig: n0 */ extends I0 {
    final Rect b;
    final UnityPlayer c;

    n0(UnityPlayer p0, Rect p1) {
        c = p0;
        b = p1;
        new I0(p0, 0);
        return;
    }

    public final void a() {
        UnityPlayer.-$$Nest$mnativeSetInputArea(c, left, top, right, bottom);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_075 (orig: o)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_075
package com.unity3d.player;

final class AppClass_075 /* orig: o */ extends CameraDevice$StateCallback {
    final r a;

    o(r p0) {
        a = p0;
        new CameraDevice$StateCallback();
        return;
    }

    public final void onClosed(CameraDevice p0) {
        r.-$$Nest$sfgetD();
        r.-$$Nest$sfgetD(..).release();
        return;
    }

    public final void onDisconnected(CameraDevice p0) {
        t.Log(5, "Camera2: CameraDevice disconnected.");
        r.-$$Nest$ma(a, p0);
        r.-$$Nest$sfgetD();
        r.-$$Nest$sfgetD(..).release();
        return;
    }

    public final void onError(CameraDevice p0, int p1) {
        new StringBuilder("Camera2: Error opeining CameraDevice ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
        r.-$$Nest$ma(a, p0);
        r.-$$Nest$sfgetD();
        r.-$$Nest$sfgetD(..).release();
        return;
    }

    public final void onOpened(CameraDevice p0) {
        r.-$$Nest$fputb(a, p0);
        r.-$$Nest$sfgetD();
        r.-$$Nest$sfgetD(..).release();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_076 (orig: o0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_076
package com.unity3d.player;

final class AppClass_076 /* orig: o0 */ extends I0 {
    final boolean b;
    final UnityPlayer c;

    o0(UnityPlayer p0, boolean p1) {
        c = p0;
        b = p1;
        new I0(p0, 0);
        return;
    }

    public final void a() {
        UnityPlayer.-$$Nest$mnativeSetKeyboardIsVisible(c, b);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_077 (orig: p)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_077
package com.unity3d.player;

final class AppClass_077 /* orig: p */ {
    final r a;

    p(r p0) {
        a = p0;
        new Object();
        return;
    }

    public final void onImageAvailable(ImageReader p0) {
        r.-$$Nest$sfgetD();
        r.-$$Nest$sfgetD(..).tryAcquire();
        if (if-eqz(Semaphore.tryAcquire(..))) goto L_73;
        p0.acquireNextImage();
        if (if-eqz(ImageReader.acquireNextImage(..))) goto L_6c;
        ImageReader.acquireNextImage(..).getPlanes();
        ImageReader.acquireNextImage(..).getFormat();
        if (if-ne(Image.getFormat(..), 35)) goto L_56;
        if (if-eqz(Image.getPlanes(..))) goto L_56;
        if (if-ne(Image.getFormat(..), 3)) goto L_56;
        r.-$$Nest$fgeta(a);
        Image$Plane.getBuffer();
        Image$Plane.getBuffer();
        2.getBuffer();
        0.getRowStride();
        0.getRowStride();
        Image.getPlanes(..).getPixelStride();
        r.-$$Nest$fgeta(..).a(Image$Plane.getBuffer(..), Image$Plane.getBuffer(..), Image$Plane.getBuffer(..), Image$Plane.getRowStride(..), Image$Plane.getRowStride(..), Image$Plane.getPixelStride(..));
      L_56:
        t.Log(6, "Camera2: Wrong image format.");
      L_5c:
        r.-$$Nest$fgetp(a);
        if (if-eqz(r.-$$Nest$fgetp(..))) goto L_67;
        r.-$$Nest$fgetp(..).close();
      L_67:
        r.-$$Nest$fputp(a, ImageReader.acquireNextImage(..));
      L_6c:
        r.-$$Nest$sfgetD();
        r.-$$Nest$sfgetD(..).release();
      L_73:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_078 (orig: p0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_078
package com.unity3d.player;

final class AppClass_078 /* orig: p0 */ {
    final UnityPlayer a;

    p0(UnityPlayer p0) {
        a = p0;
        new Object();
        return;
    }

    public final void a() {
        UnityPlayer.-$$Nest$fputmVideoPlayerProxy(a, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_079 (orig: q)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_079
package com.unity3d.player;

final class AppClass_079 /* orig: q */ {
    final r a;

    q(r p0) {
        a = p0;
        new Object();
        return;
    }

    public final void onFrameAvailable(SurfaceTexture p0) {
        r.-$$Nest$fgeta(a);
        r.-$$Nest$fgeta(..).a(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_080 (orig: q0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_080
package com.unity3d.player;

final class AppClass_080 /* orig: q0 */ {
    final UnityPlayer a;

    q0(UnityPlayer p0) {
        a = p0;
        new Object();
        return;
    }

    public final void run() {
        UnityPlayer.-$$Nest$mnativeIsAutorotationOn(a);
        if (if-eqz(UnityPlayer.-$$Nest$mnativeIsAutorotationOn(..))) goto L_17;
        UnityPlayer.-$$Nest$fgetmActivity(a);
        if (if-eqz(UnityPlayer.-$$Nest$fgetmActivity(..))) goto L_17;
        UnityPlayer.-$$Nest$fgetmInitialScreenOrientation(a);
        Activity.setRequestedOrientation(UnityPlayer.-$$Nest$fgetmInitialScreenOrientation(..));
      L_17:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_081 (orig: r)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_081
package com.unity3d.player;

public final class AppClass_081 /* orig: r */ {
    private static CameraManager B;
    private static String[] C;
    private static Semaphore D;
    private int A;
    private b a;
    private CameraDevice b;
    private HandlerThread c;
    private Handler d;
    private Rect e;
    private Rect f;
    private int g;
    private int h;
    private float i;
    private float j;
    private int k;
    private int l;
    private boolean m;
    private Range n;
    private ImageReader o;
    private Image p;
    private CaptureRequest$Builder q;
    private CameraCaptureSession r;
    private Object s;
    private int t;
    private SurfaceTexture u;
    private Surface v;
    private CameraCaptureSession$CaptureCallback w;
    private final CameraDevice$StateCallback x;
    private final ImageReader$OnImageAvailableListener y;
    private final SurfaceTexture$OnFrameAvailableListener z;

    static b -$$Nest$fgeta(r p0) {
        return a;
    }

    static CameraDevice -$$Nest$fgetb(r p0) {
        return b;
    }

    static Range -$$Nest$fgetn(r p0) {
        return n;
    }

    static Image -$$Nest$fgetp(r p0) {
        return p;
    }

    static CaptureRequest$Builder -$$Nest$fgetq(r p0) {
        return q;
    }

    static Object -$$Nest$fgets(r p0) {
        return s;
    }

    static Surface -$$Nest$fgetv(r p0) {
        return v;
    }

    static void -$$Nest$fputb(r p0, CameraDevice p1) {
        b = p1;
        return;
    }

    static void -$$Nest$fputp(r p0, Image p1) {
        p = p1;
        return;
    }

    static void -$$Nest$fputq(r p0, CaptureRequest$Builder p1) {
        q = p1;
        return;
    }

    static void -$$Nest$fputr(r p0, CameraCaptureSession p1) {
        r = p1;
        return;
    }

    static void -$$Nest$ma(r p0, CameraDevice p1) {
        p0.a(p1);
        return;
    }

    static void -$$Nest$ma(r p0, Object p1) {
        p0.a(p1);
        return;
    }

    static void -$$Nest$mg(r p0) {
        p0.g();
        return;
    }

    static Semaphore -$$Nest$sfgetD() {
        return r.D;
    }

    static <clinit>() {
        new Semaphore(1);
        D = new Semaphore(..);
        return;
    }

    protected r(b p0) {
        new Object();
        a = 0;
        i = -1.0f;
        j = -1.0f;
        m = 0;
        o = 0;
        r = 0;
        new Object();
        s = new Object(..);
        v = 0;
        A = 3;
        new m(new Object(..));
        w = new m(..);
        new o(new Object(..));
        x = new o(..);
        new p(new Object(..));
        y = new p(..);
        new q(new Object(..));
        z = new q(..);
        a = p0;
        new Object(..).e();
        return;
    }

    public static int a(Context p0) {
        r.b(p0);
        return r.b(..);
    }

    public static int a(Context p0, int p1) {
        r.c(p0);
        r.b(p0);
        r.c(..).getCameraCharacteristics(r.b(..));
        CameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
        CameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
        if (if-lez(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE)) goto L_41;
        CameraCharacteristics.get(..).getWidth();
        return SizeF.getWidth(..);
        new StringBuilder("Camera2: CameraAccessException ");
        new StringBuilder(..).append(SizeF.getWidth(..));
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
      L_41:
        return 0;
    }

    private void a(CameraDevice p0) {
        r = 0;
        p0.close();
        b = 0;
        return;
        throw p0;
    }

    private void a(Object p0) {
        if (if-ne(p0, "Focus")) goto L_48;
        m = 0;
        if (if-eqz(r)) goto L_43;
        Integer.valueOf(0);
        q.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(..));
        q.setTag("Regular");
        q.build();
        r.setRepeatingRequest(CaptureRequest$Builder.build(..), w, d);
        new StringBuilder("Camera2: CameraAccessException ");
        new StringBuilder(..).append(r);
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
      L_43:
        throw StringBuilder.toString(..);
      L_48:
        if (if-ne(StringBuilder.toString(..), "Cancel focus")) goto L_5b;
        if (if-eqz(r)) goto L_56;
        r.g();
      L_56:
        throw r;
      L_5b:
        return;
    }

    private void b() {
        r.D.tryAcquire(4L, v4, TimeUnit.SECONDS);
        if (if-nez(Semaphore.tryAcquire(..))) goto L_14;
        t.Log(5, "Camera2: Timeout waiting to lock camera for closing.");
        return;
      L_14:
        b.close();
        r.D.tryAcquire(4L, v4, TimeUnit.SECONDS);
        if (if-nez(Semaphore.tryAcquire(..))) goto L_39;
        t.Log(5, "Camera2: Timeout waiting to close camera.");
        new StringBuilder("Camera2: Interrupted while waiting to close camera ");
        new StringBuilder(..).append("Camera2: Timeout waiting to close camera.");
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
      L_39:
        b = 0;
        r.D.release();
        return;
        new StringBuilder("Camera2: Interrupted while trying to lock camera for closing ");
        new StringBuilder(..).append(StringBuilder.toString(..));
        new StringBuilder(..).toString();
        t.Log(r.D, StringBuilder.toString(..));
        return;
    }

    public static int[] b(Context p0, int p1) {
        r.c(p0);
        r.b(p0);
        r.c(..).getCameraCharacteristics(r.b(..));
        CameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (if-nez(CameraCharacteristics.get(..))) goto L_21;
        t.Log(6, "Camera2: configuration map is not available.");
      L_1f:
      L_21:
        0.getOutputSizes(35);
        if (if-eqz(StreamConfigurationMap.getOutputSizes(..))) goto L_1f;
        if (if-nez(35)) goto L_2d;
      L_2d:
        if (if-eqz(StreamConfigurationMap.getOutputSizes(..))) goto L_50;
      L_35:
        if (if-ge(0, 0)) goto L_4f;
        r.c(..).getWidth();
        Size.getWidth(..).getHeight();
      L_4f:
        return 35;
      L_50:
        return 0;
        new StringBuilder("Camera2: CameraAccessException ");
        new StringBuilder(..).append(StreamConfigurationMap.getOutputSizes(..));
        new StringBuilder(..).toString();
        t.Log(0, StringBuilder.toString(..));
        return 0;
    }

    private static String[] b(Context p0) {
        if (if-nez(r.C)) goto L_27;
        r.c(p0);
        r.c(..).getCameraIdList();
        C = CameraManager.getCameraIdList(..);
        new StringBuilder("Camera2: CameraAccessException ");
        new StringBuilder(..).append(CameraManager.getCameraIdList(..));
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
        C = 0;
      L_27:
        return r.C;
    }

    public static int c(Context p0, int p1) {
        r.c(p0);
        r.b(p0);
        r.c(..).getCameraCharacteristics(r.b(..));
        CameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
        CameraCharacteristics.get(..).intValue();
        return Integer.intValue(..);
        new StringBuilder("Camera2: CameraAccessException ");
        new StringBuilder(..).append(Integer.intValue(..));
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
        return 0;
    }

    private static CameraManager c(Context p0) {
        if (if-nez(r.B)) goto L_e;
        p0.getSystemService("camera");
        B = Context.getSystemService(..);
      L_e:
        return r.B;
    }

    public static boolean d(Context p0, int p1) {
        r.c(p0);
        r.b(p0);
        r.c(..).getCameraCharacteristics(r.b(..));
        CameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        CameraCharacteristics.get(..).intValue();
        if (if-lez(Integer.intValue(..))) goto L_1e;
      L_1e:
        return 1;
        new StringBuilder("Camera2: CameraAccessException ");
        new StringBuilder(..).append(Integer.intValue(..));
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
        return 1;
    }

    private void e() {
        new HandlerThread("CameraBackground");
        c = new HandlerThread(..);
        new HandlerThread(..).start();
        c.getLooper();
        new Handler(HandlerThread.getLooper(..));
        d = new Handler(..);
        return;
    }

    public static boolean e(Context p0, int p1) {
        r.c(p0);
        r.b(p0);
        r.c(..).getCameraCharacteristics(r.b(..));
        CameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
        CameraCharacteristics.get(..).intValue();
        if (if-nez(Integer.intValue(..))) goto L_1e;
      L_1e:
        return 1;
        new StringBuilder("Camera2: CameraAccessException ");
        new StringBuilder(..).append(Integer.intValue(..));
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
        return 1;
    }

    private void f() {
        if (if-eqz(r)) goto L_49;
        r.stopRepeating();
        Integer.valueOf(2);
        q.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(..));
        Integer.valueOf(0);
        q.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(..));
        q.setTag("Cancel focus");
        q.build();
        r.capture(CaptureRequest$Builder.build(..), w, d);
        new StringBuilder("Camera2: CameraAccessException ");
        new StringBuilder(..).append(r);
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
      L_49:
        return;
    }

    private void g() {
        if (if-eqz(h)) goto L_bc;
        if (if-ltz(v2)) goto L_bc;
        if (if-gtz(i)) goto L_bc;
        if (if-ltz(0)) goto L_bc;
        if (if-lez(j)) goto L_1d;
      L_1d:
        m = 1;
        f.width();
        f.height();
        f.width();
        Math.min(Rect.width(..), Rect.width(..));
        Math.max(g, Math.min(..));
        f.height();
        Math.min(j, Rect.height(..));
        Math.max(g, Math.min(..));
        new MeteringRectangle(v7, Color(0x3FF00000), v10, v10, 999);
        q.set(CaptureRequest.CONTROL_AF_REGIONS, g);
        Integer.valueOf(1);
        q.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(..));
        Integer.valueOf(1);
        q.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(..));
        q.setTag("Focus");
        q.build();
        r.capture(CaptureRequest$Builder.build(..), w, d);
      L_bc:
        Integer.valueOf(4);
        q.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(..));
        q.setTag("Regular");
        if (if-eqz(r)) goto L_f4;
        q.build();
        r.setRepeatingRequest(CaptureRequest$Builder.build(..), w, d);
        new StringBuilder("Camera2: CameraAccessException ");
        new StringBuilder(..).append(r);
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
      L_f4:
        return;
    }

    public final void a() {
        if (if-eqz(b)) goto L_23;
        r.i();
        r.b();
        w = 0;
        v = 0;
        u = 0;
        if (if-eqz(p)) goto L_1a;
        p.close();
        p = 0;
      L_1a:
        if (if-eqz(o)) goto L_23;
        o.close();
        o = 0;
      L_23:
        c.quit();
        c.join(4000L, v3);
        c = 0;
        d = 0;
        c.interrupt();
        new StringBuilder("Camera2: Interrupted while waiting for the background thread to finish ");
        new StringBuilder(..).append(c);
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
      L_4c:
        return;
    }

    public final boolean a(float p0, float p1) {
        if (if-lez(h)) goto L_27;
        if (if-nez(m)) goto L_21;
        i = p0;
        j = p1;
        if (if-eqz(r)) goto L_1b;
        if (if-eq(A, 2)) goto L_1b;
        r.f();
      L_1b:
        return 1;
        throw A;
      L_21:
        t.Log(5, "Camera2: Setting manual focus point already started.");
      L_27:
        return 0;
    }

    public final boolean a(Context p0, int p1, int p2, int p3, int p4, int p5, Surface p6) {
        r.b(p0);
        r.B.getCameraCharacteristics(r.b(..));
        CameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        CameraCharacteristics.get(..).intValue();
        if (if-ne(Integer.intValue(..), 2)) goto L_28;
        t.Log(5, "Camera2: only LEGACY hardware level is supported.");
      L_28:
        CameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (if-nez(CameraCharacteristics.get(..))) goto L_39;
        t.Log(6, "Camera2: configuration map is not available.");
      L_39:
        StreamConfigurationMap.getOutputSizes(35);
        if (if-eqz(StreamConfigurationMap.getOutputSizes(..))) goto L_46;
        if (if-nez(35)) goto L_45;
      L_45:
      L_46:
        if (if-eqz(StreamConfigurationMap.getOutputSizes(..))) goto L_23f;
        if (if-nez(StreamConfigurationMap.getOutputSizes(..))) goto L_4d;
      L_4d:
      L_5b:
        if (if-ge(0, v14)) goto L_96;
        Size.getWidth();
        Size.getHeight();
        Math.log(v4, CameraManager.getCameraCharacteristics(..));
        Math.abs(Math.log(..), CameraManager.getCameraCharacteristics(..));
        Math.log(5, 35);
        Math.abs(Math.log(..), 35);
        if (if-gez(Math.abs(..))) goto L_8d;
      L_8d:
      L_96:
        new Rect(0, 0, Size.getWidth(..), Size.getHeight(..));
        e = new Rect(..);
        CameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (if-eqz(CameraCharacteristics.get(..))) goto L_237;
        if (if-nez(CameraManager.getCameraCharacteristics(..))) goto L_b1;
      L_b1:
      L_b8:
        if (if-ge(0, StreamConfigurationMap.getOutputSizes(..))) goto L_100;
        Range.getLower();
        Range.getLower(..).intValue();
        5.getUpper();
        Range.getUpper(..).intValue();
        if (if-lez(v11)) goto L_e5;
        if (if-gez(35)) goto L_e5;
      L_e5:
        Math.abs(Integer.intValue(..));
        Math.abs(Integer.intValue(..));
        Math.min(Math.abs(..), Math.abs(..));
        if (if-gez(35)) goto L_fd;
      L_fd:
      L_100:
        0.getUpper();
        Range.getUpper(..).intValue();
        if (if-le(p4, Integer.intValue(..))) goto L_115;
        p4.getUpper();
      L_115:
        Range.getUpper(..).getLower();
      L_11b:
        Range.getLower(..).intValue();
      L_121:
        Integer.valueOf(Integer.intValue(..));
        Integer.valueOf(Integer.intValue(..));
        new Range(Integer.valueOf(..), Integer.valueOf(..));
        n = new Range(..);
        r.D.tryAcquire(4L, Integer.intValue(..), TimeUnit.SECONDS);
        if (if-nez(Semaphore.tryAcquire(..))) goto L_144;
        t.Log(5, "Camera2: Timeout waiting to lock camera for opening.");
        return 0;
      L_144:
        r.b(p0);
        r.B.openCamera(r.b(..), x, d);
        r.D.tryAcquire(4L, Integer.intValue(..), TimeUnit.SECONDS);
        if (if-nez(Semaphore.tryAcquire(..))) goto L_163;
        t.Log(5, "Camera2: Timeout waiting to open camera.");
        return 0;
      L_163:
        r.D.release();
        new StringBuilder("Camera2: Interrupted while waiting to open camera ");
        new StringBuilder(..).append(r.D);
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
      L_17c:
        t = p5;
        v = p6;
        CameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        CameraCharacteristics.get(..).intValue();
        h = Integer.intValue(..);
        if (if-lez(Integer.intValue(..))) goto L_202;
        CameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        f = CameraCharacteristics.get(..);
        CameraCharacteristics.get(..).width();
        f.height();
        e.width();
        e.height();
        if (if-lez(Rect.width(..))) goto L_1d8;
        k = 0;
        f.height();
        f.width();
        l = Rect.height(..);
      L_1d8:
        l = Rect.width(..);
        f.width();
        f.height();
        k = Rect.width(..);
      L_1ee:
        f.width();
        f.height();
        Math.min(Rect.width(..), Rect.height(..));
        g = Math.min(..);
      L_202:
        if (if-eqz(b)) goto L_208;
      L_208:
      L_209:
        return 0;
        new StringBuilder(Rect.height(..));
        new StringBuilder(..).append(b);
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
        r.D.release();
      L_220:
        return 0;
        new StringBuilder("Camera2: Interrupted while trying to lock camera for opening ");
        new StringBuilder(..).append(r.D);
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
        return 0;
      L_237:
        t.Log(6, "Camera2: target FPS ranges are not avialable.");
        return 0;
      L_23f:
        return 0;
        new StringBuilder(6);
        new StringBuilder(..).append("Camera2: target FPS ranges are not avialable.");
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
    }

    public final Rect c() {
        return e;
    }

    public final void d() {
        if (if-eqz(r)) goto L_21;
        r.stopRepeating();
        A = 2;
        new StringBuilder("Camera2: CameraAccessException ");
        new StringBuilder(..).append(2);
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
      L_21:
        return;
        throw StringBuilder.toString(..);
    }

    public void h() {
        if (if-eqz(t)) goto L_34;
        if (if-nez(v)) goto L_61;
        new SurfaceTexture(t);
        u = new SurfaceTexture(..);
        e.width();
        e.height();
        new SurfaceTexture(..).setDefaultBufferSize(Rect.width(..), Rect.height(..));
        u.setOnFrameAvailableListener(z, d);
        new Surface(u);
      L_31:
        v = new Surface(..);
      L_34:
        if (if-nez(v)) goto L_61;
        if (if-nez(o)) goto L_61;
        e.width();
        e.height();
        ImageReader.newInstance(Rect.width(..), Rect.height(..), 35, 2);
        o = ImageReader.newInstance(..);
        ImageReader.newInstance(..).setOnImageAvailableListener(y, d);
        p = 0;
        o.getSurface();
      L_61:
        if (if-eqz(r)) goto L_78;
        if (if-ne(A, 2)) goto L_8f;
        q.build();
        r.setRepeatingRequest(CaptureRequest$Builder.build(..), w, d);
      L_78:
        Arrays.asList(CaptureRequest$Builder.build(..));
        new n(this);
        b.createCaptureSession(Arrays.asList(..), new n(..), d);
      L_8f:
        A = 1;
        new StringBuilder("Camera2: CameraAccessException ");
        new StringBuilder(..).append(b);
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
      L_a5:
        return;
    }

    public final void i() {
        if (if-eqz(r)) goto L_29;
        r.abortCaptures();
        new StringBuilder("Camera2: CameraAccessException ");
        new StringBuilder(..).append(r);
        new StringBuilder(..).toString();
        t.Log(6, StringBuilder.toString(..));
      L_1e:
        r.close();
        r = 0;
        A = 3;
      L_29:
        return;
        throw 3;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_082 (orig: r0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_082
package com.unity3d.player;

final class AppClass_082 /* orig: r0 */ {
    final UnityPlayer a;

    r0(UnityPlayer p0) {
        a = p0;
        new Object();
        return;
    }

    public final void run() {
        a.setupUnityToBePaused();
        a.windowFocusChanged(0);
        UnityPlayer.-$$Nest$fgetm_UnityPlayerLifecycleEvents(a);
        IUnityPlayerLifecycleEvents.onUnityPlayerUnloaded();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_083 (orig: s)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_083
package com.unity3d.player;

abstract class AppClass_083 /* orig: s */ {
    public static void a(Activity p0) {
        if (if-eqz(p0)) goto L_52;
        p0.getWindow();
        if (if-eqz(Activity.getWindow(..))) goto L_52;
        if (if-eqz(PlatformSupport.PIE_SUPPORT)) goto L_52;
        if (if-eqz(PlatformSupport.VANILLA_ICE_CREAM_SUPPORT)) goto L_11;
      L_11:
        if (if-eqz(PlatformSupport.RED_VELVET_CAKE_SUPPORT)) goto L_34;
        p0.getPackageManager();
        p0.getPackageName();
        Context.getPackageManager(..).getApplicationInfo(Context.getPackageName(..), 128);
        if (if-eqz(PackageManager.getApplicationInfo(..))) goto L_2f;
        metaData.getBoolean("unity.render-outside-safearea");
      L_2f:
      L_30:
        if (if-eqz(0)) goto L_48;
      L_32:
      L_34:
        p0.getPackageManager();
        p0.getPackageName();
        Context.getPackageManager(..).getApplicationInfo(Context.getPackageName(..), 128);
        if (if-eqz(PackageManager.getApplicationInfo(..))) goto L_48;
        metaData.getBoolean("unity.render-outside-safearea");
      L_48:
        p0.getWindow();
        Activity.getWindow(..).getAttributes();
        layoutInDisplayCutoutMode = Bundle.getBoolean(..);
      L_52:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_084 (orig: s0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_084
package com.unity3d.player;

final class AppClass_084 /* orig: s0 */ extends OrientationEventListener {
    final UnityPlayer a;

    s0(UnityPlayer p0, Context p1, int p2) {
        a = p0;
        new OrientationEventListener(p1, p2);
        return;
    }

    public final void onOrientationChanged(int p0) {
        UnityPlayer.-$$Nest$fgetmNaturalOrientation(a);
        f = UnityPlayer.-$$Nest$fgetmNaturalOrientation(..);
        g = p0;
        H0.-$$Nest$ma(m_MainThread, F0.j);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_085 (orig: t)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_085
package com.unity3d.player;

abstract class AppClass_085 /* orig: t */ {
    protected static boolean a;

    protected static void Log(int p0, String p1) {
        if (if-eqz(t.a)) goto L_5;
        return;
      L_5:
        if (if-ne(p0, 6)) goto L_d;
        Log.e("Unity", p1);
      L_d:
        if (if-ne(p0, 5)) goto L_13;
        Log.w("Unity", p1);
      L_13:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_086 (orig: t0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_086
package com.unity3d.player;

final class AppClass_086 /* orig: t0 */ {
    final float a;
    final UnityPlayer b;

    t0(UnityPlayer p0, float p1) {
        b = p0;
        a = p1;
        new Object();
        return;
    }

    public final void run() {
        UnityPlayer.-$$Nest$fgetmGlView(b);
        UnityPlayer.-$$Nest$fgetmGlView(..).a(a);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_087 (orig: u)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_087
package com.unity3d.player;

final class AppClass_087 /* orig: u */ extends ConnectivityManager$NetworkCallback {
    final NetworkConnectivityNougat a;

    u(NetworkConnectivityNougat p0) {
        a = p0;
        new ConnectivityManager$NetworkCallback();
        return;
    }

    public final void onAvailable(Network p0) {
        ConnectivityManager$NetworkCallback.onAvailable(p0);
        return;
    }

    public final void onCapabilitiesChanged(Network p0, NetworkCapabilities p1) {
        ConnectivityManager$NetworkCallback.onCapabilitiesChanged(p0, p1);
        p1.hasTransport(0);
        if (if-eqz(NetworkCapabilities.hasTransport(..))) goto L_e;
      L_e:
      L_11:
        NetworkConnectivityNougat.-$$Nest$fputb(a, 2);
        return;
    }

    public final void onLost(Network p0) {
        ConnectivityManager$NetworkCallback.onLost(p0);
        NetworkConnectivityNougat.-$$Nest$fputb(a, 0);
        return;
    }

    public final void onUnavailable() {
        ConnectivityManager$NetworkCallback.onUnavailable();
        NetworkConnectivityNougat.-$$Nest$fputb(a, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_088 (orig: u0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_088
package com.unity3d.player;

final class AppClass_088 /* orig: u0 */ {
    final float a;
    final UnityPlayer b;

    u0(UnityPlayer p0, float p1) {
        b = p0;
        a = p1;
        new Object();
        return;
    }

    public final void run() {
        m_Window.getAttributes();
        screenBrightness = a;
        m_Window.setAttributes(Window.getAttributes(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_089 (orig: v)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_089
package com.unity3d.player;

abstract class AppClass_089 /* orig: v */ {
}


// ============================================================
// CLASS: com.unity3d.player.AppClass_090 (orig: v0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_090
package com.unity3d.player;

final class AppClass_090 /* orig: v0 */ {
    final UnityPlayer a;

    v0(UnityPlayer p0) {
        a = p0;
        new Object();
        return;
    }

    public final void run() {
        UnityPlayer.-$$Nest$fgetm_SplashScreen(a);
        a.removeView(UnityPlayer.-$$Nest$fgetm_SplashScreen(..));
        UnityPlayer.-$$Nest$fputm_SplashScreen(a, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_091 (orig: w)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_091
package com.unity3d.player;

abstract class AppClass_091 /* orig: w */ {
}


// ============================================================
// CLASS: com.unity3d.player.AppClass_092 (orig: w0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_092
package com.unity3d.player;

final class AppClass_092 /* orig: w0 */ {
    final UnityPlayer a;

    w0(UnityPlayer p0) {
        a = p0;
        new Object();
        return;
    }

    public final void run() {
        UnityPlayer.-$$Nest$mnativeSendSurfaceChangedEvent(a);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_093 (orig: x)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_093
package com.unity3d.player;

abstract class AppClass_093 /* orig: x */ {
}


// ============================================================
// CLASS: com.unity3d.player.AppClass_094 (orig: x0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_094
package com.unity3d.player;

final class AppClass_094 /* orig: x0 */ {
    final int a;
    final Surface b;
    final Semaphore c;
    final UnityPlayer d;

    x0(UnityPlayer p0, int p1, Surface p2, Semaphore p3) {
        d = p0;
        a = p1;
        b = p2;
        c = p3;
        new Object();
        return;
    }

    public final void run() {
        UnityPlayer.-$$Nest$mnativeRecreateGfxState(d, a, b);
        c.release();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_095 (orig: y)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_095
package com.unity3d.player;

final class AppClass_095 /* orig: y */ {
    final String[] a;
    final PermissionFragment b;

    y(PermissionFragment p0, String[] p1) {
        b = p0;
        a = p1;
        new Object();
        return;
    }

    public final void run() {
        PermissionFragment.-$$Nest$mreportAllDenied(b, a);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_096 (orig: y0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_096
package com.unity3d.player;

final class AppClass_096 /* orig: y0 */ {
    final UnityPlayer a;

    y0(UnityPlayer p0) {
        a = p0;
        new Object();
        return;
    }

    public final void run() {
        UnityPlayer.-$$Nest$fgetmMainDisplayOverride(a);
        if (if-eqz(UnityPlayer.-$$Nest$fgetmMainDisplayOverride(..))) goto L_10;
        UnityPlayer.-$$Nest$fgetmGlView(a);
        a.removeView(UnityPlayer.-$$Nest$fgetmGlView(..));
      L_10:
        UnityPlayer.-$$Nest$fgetmGlView(a);
        UnityPlayer.-$$Nest$fgetmGlView(..).getParent();
        if (if-nez(View.getParent(..))) goto L_24;
        UnityPlayer.-$$Nest$fgetmGlView(a);
        a.addView(UnityPlayer.-$$Nest$fgetmGlView(..));
      L_24:
        t.Log(5, "Couldn't add view, because it's already assigned to another parent");
      L_2a:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_097 (orig: z)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_097
package com.unity3d.player;

final class AppClass_097 /* orig: z */ {
    private IPermissionRequestCallbacks a;
    private String b;
    private int c;
    private boolean d;

    z(IPermissionRequestCallbacks p0, String p1, int p2, boolean p3) {
        new Object();
        a = p0;
        b = p1;
        c = p2;
        d = p3;
        return;
    }

    public final void run() {
        if (if-ne(c, -1)) goto L_20;
        if (if-ge(Build$VERSION.SDK_INT, 30)) goto L_18;
        if (if-eqz(d)) goto L_10;
      L_10:
        a.onPermissionDeniedAndDontAskAgain(b);
      L_18:
        a.onPermissionDenied(b);
      L_20:
        if (if-nez(a)) goto L_29;
        a.onPermissionGranted(b);
      L_29:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.AppClass_098 (orig: z0)
// ============================================================
// Original DEX symbol: com.unity3d.player.AppClass_098
package com.unity3d.player;

final class AppClass_098 /* orig: z0 */ {
    final UnityPlayer a;

    z0(UnityPlayer p0) {
        a = p0;
        new Object();
        return;
    }

    public final void run() {
        a.destroy();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.HFPStatus$1
// ============================================================
package com.unity3d.player;

class HFPStatus$1 extends BroadcastReceiver {
    final HFPStatus a;

    HFPStatus$1(HFPStatus p0) {
        a = p0;
        new BroadcastReceiver();
        return;
    }

    public final void onReceive(Context p0, Intent p1) {
        p1.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        if (if-eq(Intent.getIntExtra(..), 1)) goto L_b;
      L_b:
        HFPStatus.-$$Nest$fputf(a, 2);
        HFPStatus.-$$Nest$ma(a);
        HFPStatus.-$$Nest$fgetc(a);
        if (if-eqz(HFPStatus.-$$Nest$fgetc(..))) goto L_24;
        HFPStatus.-$$Nest$fgetd(a);
        HFPStatus.-$$Nest$fgetd(..).setMode(3);
      L_24:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.UnityPermissions$ModalWaitForPermissionResponse
// ============================================================
package com.unity3d.player;

public class UnityPermissions$ModalWaitForPermissionResponse {
    private boolean haveResponse;

    public UnityPermissions$ModalWaitForPermissionResponse() {
        new Object();
        haveResponse = 0;
        return;
    }

    public void onPermissionDenied(String p0) {
        haveResponse = 1;
        Object.notify();
        return;
        throw 1;
    }

    public void onPermissionDeniedAndDontAskAgain(String p0) {
        haveResponse = 1;
        Object.notify();
        return;
        throw 1;
    }

    public void onPermissionGranted(String p0) {
        haveResponse = 1;
        Object.notify();
        return;
        throw 1;
    }

    public void waitForResponse() {
        if (if-eqz(haveResponse)) goto L_7;
        return;
      L_7:
        Object.wait();
        throw haveResponse;
      L_e:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.player.UnityPlayer$SynchronizationTimeout
// ============================================================
package com.unity3d.player;

public final class UnityPlayer$SynchronizationTimeout extends Enum {
    private static final UnityPlayer$SynchronizationTimeout[] $VALUES;
    public static final UnityPlayer$SynchronizationTimeout Destroy;
    public static final UnityPlayer$SynchronizationTimeout Pause;
    public static final UnityPlayer$SynchronizationTimeout SurfaceDetach;
    private int m_TimeoutMilliseconds;
    final int value;

    static <clinit>() {
        new UnityPlayer$SynchronizationTimeout("Pause", 0, 0);
        Pause = new UnityPlayer$SynchronizationTimeout(..);
        new UnityPlayer$SynchronizationTimeout("SurfaceDetach", 1, 1);
        SurfaceDetach = new UnityPlayer$SynchronizationTimeout(..);
        new UnityPlayer$SynchronizationTimeout("Destroy", 2, 2);
        Destroy = new UnityPlayer$SynchronizationTimeout(..);
        $VALUES = 3;
        return;
    }

    private UnityPlayer$SynchronizationTimeout(String p0, int p1, int p2) {
        new Enum(p0, p1);
        value = p2;
        m_TimeoutMilliseconds = 2000;
        return;
    }

    public static void setTimeoutForAll(int p0) {
        Class.getEnumConstants();
      L_a:
        if (if-ge(0, v1)) goto L_14;
        UnityPlayer$SynchronizationTimeout.setTimeout(p0);
      L_14:
        return;
    }

    public static UnityPlayer$SynchronizationTimeout valueOf(String p0) {
        Enum.valueOf(UnityPlayer$SynchronizationTimeout.class, p0);
        return Enum.valueOf(..);
    }

    public static UnityPlayer$SynchronizationTimeout[] values() {
        UnityPlayer$SynchronizationTimeout[].clone();
        return UnityPlayer$SynchronizationTimeout[].clone(..);
    }

    public int getTimeout() {
        return m_TimeoutMilliseconds;
    }

    public void setTimeout(int p0) {
        m_TimeoutMilliseconds = p0;
        return;
    }

}

