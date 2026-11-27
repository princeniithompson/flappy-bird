
// ===== FILE: com/unity3d/player/AbstractC0916I.java =====
package com.unity3d.player;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.EditText;

/* renamed from: com.unity3d.player.I */
/* loaded from: classes.dex */
abstract class AbstractC0916I implements TextWatcher {

    /* renamed from: a */
    protected Context f437a;

    /* renamed from: b */
    protected UnityPlayer f438b;

    /* renamed from: c */
    protected EditText f439c = createEditText(this);

    /* renamed from: d */
    protected boolean f440d;

    /* renamed from: e */
    protected boolean f441e;

    /* renamed from: f */
    protected InterfaceC0996w f442f;

    /* renamed from: g */
    protected InterfaceC0998x f443g;

    public AbstractC0916I(Context context, UnityPlayer unityPlayer) {
        this.f437a = context;
        this.f438b = unityPlayer;
    }

    /* renamed from: a */
    public final String m338a() {
        InputMethodSubtype currentInputMethodSubtype = ((InputMethodManager) this.f437a.getSystemService("input_method")).getCurrentInputMethodSubtype();
        if (currentInputMethodSubtype == null) {
            return null;
        }
        String locale = currentInputMethodSubtype.getLocale();
        if (locale != null && !locale.equals("")) {
            return locale;
        }
        return currentInputMethodSubtype.getMode() + " " + currentInputMethodSubtype.getExtraValue();
    }

    /* renamed from: a */
    public void mo339a(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6) {
        this.f441e = z6;
        setupTextInput(str, i, z, z2, z3, z4, str2, i2);
        mo341a(z5);
    }

    /* renamed from: a */
    public final void m340a(String str, boolean z) {
        this.f439c.setSelection(0, 0);
        this.f438b.reportSoftInputStr(str, 1, z);
    }

    /* renamed from: a */
    public abstract void mo341a(boolean z);

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f438b.reportSoftInputStr(editable.toString(), 0, false);
        int selectionStart = this.f439c.getSelectionStart();
        this.f438b.reportSoftInputSelection(selectionStart, this.f439c.getSelectionEnd() - selectionStart);
    }

    /* renamed from: b */
    public final String m342b() {
        EditText editText = this.f439c;
        if (editText == null) {
            return null;
        }
        return editText.getText().toString();
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* renamed from: c */
    public abstract void mo343c();

    protected abstract EditText createEditText(AbstractC0916I abstractC0916I);

    /* renamed from: d */
    public boolean mo344d() {
        return this.f441e;
    }

    /* renamed from: e */
    public abstract void mo345e();

    /* renamed from: f */
    public final void m346f() {
        ((InputMethodManager) this.f437a.getSystemService("input_method")).showSoftInput(this.f439c, 0);
    }

    protected void invokeOnClose() {
        InterfaceC0998x interfaceC0998x = this.f443g;
        if (interfaceC0998x != null) {
            ((C0961e0) interfaceC0998x).m397a();
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    protected void setupTextInput(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2) {
        this.f439c.setOnEditorActionListener(new C0913H(this));
        this.f439c.setBackgroundColor(-1);
        this.f439c.setImeOptions(6);
        this.f439c.setText(str);
        this.f439c.setHint(str2);
        this.f439c.setHintTextColor(1627389952);
        EditText editText = this.f439c;
        int i3 = (z ? 32768 : 524288) | (z2 ? 131072 : 0) | (z3 ? 128 : 0);
        if (i >= 0 && i <= 11) {
            int i4 = new int[]{1, 16385, 12290, 17, 2, 3, 8289, 33, 1, 16417, 17, 8194}[i];
            if ((i4 & 2) != 0) {
                i3 = (z3 ? 16 : 0) | i4;
            } else {
                i3 |= i4;
            }
        }
        editText.setInputType(i3);
        this.f439c.setImeOptions(33554432);
        if (i2 > 0) {
            this.f439c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        }
        this.f439c.addTextChangedListener(this);
        EditText editText2 = this.f439c;
        editText2.setSelection(editText2.getText().length());
        this.f439c.setClickable(true);
    }
}

// ===== FILE: com/unity3d/player/AbstractC0988s.java =====
package com.unity3d.player;

import android.app.Activity;
import android.content.pm.ApplicationInfo;

/* renamed from: com.unity3d.player.s */
/* loaded from: classes.dex */
abstract class AbstractC0988s {
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        if (r0 == false) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m431a(Activity activity) {
        int i;
        boolean z;
        if (activity == null || activity.getWindow() == null || !PlatformSupport.PIE_SUPPORT) {
            return;
        }
        if (!PlatformSupport.VANILLA_ICE_CREAM_SUPPORT) {
            i = 0;
            i = 0;
            i = 0;
            if (PlatformSupport.RED_VELVET_CAKE_SUPPORT) {
                try {
                    ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 128);
                    if (applicationInfo != null) {
                        z = applicationInfo.metaData.getBoolean("unity.render-outside-safearea");
                    }
                } catch (Exception unused) {
                }
                z = false;
            } else {
                try {
                    ApplicationInfo applicationInfo2 = activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 128);
                    if (applicationInfo2 != null) {
                        i = applicationInfo2.metaData.getBoolean("unity.render-outside-safearea");
                    }
                } catch (Exception unused2) {
                }
            }
            activity.getWindow().getAttributes().layoutInDisplayCutoutMode = i;
        }
        i = 3;
        activity.getWindow().getAttributes().layoutInDisplayCutoutMode = i;
    }
}

// ===== FILE: com/unity3d/player/AbstractC0990t.java =====
package com.unity3d.player;

import android.util.Log;

/* renamed from: com.unity3d.player.t */
/* loaded from: classes.dex */
abstract class AbstractC0990t {

    /* renamed from: a */
    protected static boolean f666a;

    protected static void Log(int i, String str) {
        if (f666a) {
            return;
        }
        if (i == 6) {
            Log.e("Unity", str);
        }
        if (i == 5) {
            Log.w("Unity", str);
        }
    }
}

// ===== FILE: com/unity3d/player/AbstractRunnableC0917I0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.I0 */
/* loaded from: classes.dex */
abstract class AbstractRunnableC0917I0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f444a;

    private AbstractRunnableC0917I0(UnityPlayer unityPlayer) {
        this.f444a = unityPlayer;
    }

    /* renamed from: a */
    public abstract void mo347a();

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f444a.isFinishing()) {
            return;
        }
        mo347a();
    }
}

// ===== FILE: com/unity3d/player/AudioVolumeHandler.java =====
package com.unity3d.player;

import android.content.Context;

/* loaded from: classes.dex */
public class AudioVolumeHandler implements InterfaceC0972k {

    /* renamed from: a */
    private C0974l f382a;

    AudioVolumeHandler(Context context) {
        C0974l c0974l = new C0974l(context);
        this.f382a = c0974l;
        c0974l.m408a(this);
    }

    /* renamed from: a */
    public final void m330a() {
        this.f382a.m407a();
        this.f382a = null;
    }

    @Override // com.unity3d.player.InterfaceC0972k
    public final native void onAudioVolumeChanged(int i);
}

// ===== FILE: com/unity3d/player/C0901B.java =====
package com.unity3d.player;

import android.content.Context;

/* renamed from: com.unity3d.player.B */
/* loaded from: classes.dex */
final class C0901B {

    /* renamed from: a */
    Context f383a;

    /* renamed from: b */
    PixelCopyOnPixelCopyFinishedListenerC0899A f384b = null;

    C0901B(Context context) {
        this.f383a = context;
    }
}

// ===== FILE: com/unity3d/player/C0903C.java =====
package com.unity3d.player;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* renamed from: com.unity3d.player.C */
/* loaded from: classes.dex */
final class C0903C implements InvocationHandler {

    /* renamed from: a */
    private Runnable f387a;

    /* renamed from: b */
    private UnityPlayer f388b;

    /* renamed from: c */
    private long f389c;

    /* renamed from: d */
    final /* synthetic */ long f390d;

    C0903C(UnityPlayer unityPlayer, long j) {
        long j2;
        this.f390d = j;
        j2 = ReflectionHelper.f516b;
        this.f387a = new RunnableC0909F(j2, j);
        this.f388b = unityPlayer;
        this.f389c = j2;
    }

    /* renamed from: a */
    private static Object m331a(Object obj, Method method, Object[] objArr, C0907E c0907e) {
        long j;
        long j2;
        if (objArr == null) {
            try {
                try {
                    objArr = new Object[0];
                } catch (NoClassDefFoundError unused) {
                    AbstractC0990t.Log(6, String.format("Java interface default methods are only supported since Android Oreo", new Object[0]));
                    j2 = c0907e.f399a;
                    ReflectionHelper.nativeProxyLogJNIInvokeException(j2);
                    c0907e.f399a = 0L;
                    return null;
                }
            } finally {
                j = c0907e.f399a;
                if (j != 0) {
                    ReflectionHelper.nativeProxyJNIFreeGCHandle(j);
                }
            }
        }
        Class<?> declaringClass = method.getDeclaringClass();
        Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
        declaredConstructor.setAccessible(true);
        return ((MethodHandles.Lookup) declaredConstructor.newInstance(declaringClass, 2)).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
    }

    protected void finalize() {
        this.f388b.queueGLThreadEvent(this.f387a);
        super.finalize();
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object nativeProxyInvoke;
        boolean z;
        long j;
        if (!ReflectionHelper.beginProxyCall(this.f389c)) {
            AbstractC0990t.Log(6, "Scripting proxy object was destroyed, because Unity player was unloaded.");
            return null;
        }
        try {
            nativeProxyInvoke = ReflectionHelper.nativeProxyInvoke(this.f390d, method.getName(), objArr);
            if (!(nativeProxyInvoke instanceof C0907E)) {
                return nativeProxyInvoke;
            }
            C0907E c0907e = (C0907E) nativeProxyInvoke;
            z = c0907e.f400b;
            if (z && (method.getModifiers() & 1024) == 0) {
                return m331a(obj, method, objArr, c0907e);
            }
            j = c0907e.f399a;
            ReflectionHelper.nativeProxyLogJNIInvokeException(j);
            return null;
        } finally {
            ReflectionHelper.endProxyCall();
        }
    }
}

// ===== FILE: com/unity3d/player/C0905D.java =====
package com.unity3d.player;

import java.lang.reflect.Member;

/* renamed from: com.unity3d.player.D */
/* loaded from: classes.dex */
final class C0905D {

    /* renamed from: a */
    private final Class f394a;

    /* renamed from: b */
    private final String f395b;

    /* renamed from: c */
    private final String f396c;

    /* renamed from: d */
    private final int f397d;

    /* renamed from: e */
    public volatile Member f398e;

    C0905D(Class cls, String str, String str2) {
        this.f394a = cls;
        this.f395b = str;
        this.f396c = str2;
        this.f397d = str2.hashCode() + ((str.hashCode() + ((cls.hashCode() + 527) * 31)) * 31);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0905D)) {
            return false;
        }
        C0905D c0905d = (C0905D) obj;
        return this.f397d == c0905d.f397d && this.f396c.equals(c0905d.f396c) && this.f395b.equals(c0905d.f395b) && this.f394a.equals(c0905d.f394a);
    }

    public final int hashCode() {
        return this.f397d;
    }
}

// ===== FILE: com/unity3d/player/C0906D0.java =====
package com.unity3d.player;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* renamed from: com.unity3d.player.D0 */
/* loaded from: classes.dex */
final class C0906D0 implements SensorEventListener {
    C0906D0() {
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
    }
}

// ===== FILE: com/unity3d/player/C0907E.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.E */
/* loaded from: classes.dex */
final class C0907E {

    /* renamed from: a */
    private long f399a;

    /* renamed from: b */
    private boolean f400b;

    public C0907E(long j, boolean z) {
        this.f399a = j;
        this.f400b = z;
    }
}

// ===== FILE: com/unity3d/player/C0908E0.java =====
package com.unity3d.player;

import android.telephony.PhoneStateListener;

/* renamed from: com.unity3d.player.E0 */
/* loaded from: classes.dex */
final class C0908E0 extends PhoneStateListener {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f401a;

    private C0908E0(UnityPlayer unityPlayer) {
        this.f401a = unityPlayer;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int i, String str) {
        this.f401a.nativeMuteMasterAudio(i == 1);
    }
}

// ===== FILE: com/unity3d/player/C0911G.java =====
package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* renamed from: com.unity3d.player.G */
/* loaded from: classes.dex */
final class C0911G extends RelativeLayout {

    /* renamed from: a */
    protected Button f414a;

    /* renamed from: b */
    protected EditText f415b;

    /* renamed from: c */
    protected Context f416c;

    /* renamed from: d */
    protected Rect f417d;

    /* renamed from: e */
    protected Rect f418e;

    public C0911G(Context context, EditText editText) {
        super(context);
        this.f415b = editText;
        this.f416c = context;
        this.f417d = new Rect(16, 16, 16, 16);
        this.f418e = new Rect(0, 0, 0, 0);
        createUI();
        setBackgroundColor(-1);
    }

    protected void createUI() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Button button = new Button(this.f416c);
        this.f414a = button;
        button.setId(View.generateViewId());
        this.f414a.setText(this.f416c.getResources().getIdentifier("ok", TypedValues.Custom.S_STRING, "android"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        this.f414a.setLayoutParams(layoutParams);
        this.f414a.setBackgroundColor(0);
        addView(this.f414a);
        this.f415b.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, this.f414a.getId());
        this.f415b.setLayoutParams(layoutParams2);
        addView(this.f415b);
        Rect rect = this.f417d;
        setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f414a.setOnClickListener(onClickListener);
    }
}

// ===== FILE: com/unity3d/player/C0912G0.java =====
package com.unity3d.player;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.unity3d.player.G0 */
/* loaded from: classes.dex */
final class C0912G0 implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C0914H0 f419a;

    C0912G0(C0914H0 c0914h0) {
        this.f419a = c0914h0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00bd, code lost:
    
        if (r7.f424d == 3) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e1, code lost:
    
        r7.f429i.nativeFocusChanged(true);
        r6.f419a.f424d = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00df, code lost:
    
        if (r7.f423c != false) goto L59;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean handleMessage(Message message) {
        C0914H0 c0914h0;
        boolean haveAndroidWindowSupport;
        boolean nativeRender;
        boolean splashEnabled;
        Activity activity;
        boolean autoReportFullyDrawnEnabled;
        Activity activity2;
        if (message.what != 2269) {
            return false;
        }
        EnumC0910F0 enumC0910F0 = (EnumC0910F0) message.obj;
        EnumC0910F0 enumC0910F02 = EnumC0910F0.f411h;
        if (enumC0910F0 == enumC0910F02) {
            C0914H0 c0914h02 = this.f419a;
            c0914h02.f425e--;
            c0914h02.f429i.executeGLThreadJobs();
            C0914H0 c0914h03 = this.f419a;
            if (!c0914h03.f422b) {
                return true;
            }
            haveAndroidWindowSupport = c0914h03.f429i.getHaveAndroidWindowSupport();
            if (haveAndroidWindowSupport && !this.f419a.f423c) {
                return true;
            }
            C0914H0 c0914h04 = this.f419a;
            int i = c0914h04.f428h;
            if (i >= 0) {
                if (i == 0) {
                    splashEnabled = c0914h04.f429i.getSplashEnabled();
                    if (splashEnabled) {
                        this.f419a.f429i.DisableStaticSplashScreen();
                    }
                    UnityPlayer unityPlayer = this.f419a.f429i;
                    activity = unityPlayer.mActivity;
                    if (activity != null) {
                        autoReportFullyDrawnEnabled = unityPlayer.getAutoReportFullyDrawnEnabled();
                        if (autoReportFullyDrawnEnabled) {
                            activity2 = this.f419a.f429i.mActivity;
                            activity2.reportFullyDrawn();
                        }
                    }
                }
                this.f419a.f428h--;
            }
            if (!this.f419a.f429i.isFinishing()) {
                nativeRender = this.f419a.f429i.nativeRender();
                if (!nativeRender) {
                    this.f419a.f429i.finish();
                }
            }
        } else if (enumC0910F0 == EnumC0910F0.f406c) {
            Looper.myLooper().quit();
        } else if (enumC0910F0 == EnumC0910F0.f405b) {
            this.f419a.f422b = true;
        } else if (enumC0910F0 == EnumC0910F0.f404a) {
            this.f419a.f422b = false;
        } else if (enumC0910F0 == EnumC0910F0.f407d) {
            this.f419a.f423c = false;
        } else if (enumC0910F0 == EnumC0910F0.f408e) {
            c0914h0 = this.f419a;
            c0914h0.f423c = true;
        } else if (enumC0910F0 == EnumC0910F0.f409f) {
            C0914H0 c0914h05 = this.f419a;
            if (c0914h05.f424d == 1) {
                c0914h05.f429i.nativeFocusChanged(false);
            }
            this.f419a.f424d = 2;
        } else if (enumC0910F0 == EnumC0910F0.f410g) {
            c0914h0 = this.f419a;
            c0914h0.f424d = 3;
        } else if (enumC0910F0 == EnumC0910F0.f412i) {
            UnityPlayer unityPlayer2 = this.f419a.f429i;
            unityPlayer2.nativeSetLaunchURL(unityPlayer2.getLaunchURL());
        } else if (enumC0910F0 == EnumC0910F0.f413j) {
            C0914H0 c0914h06 = this.f419a;
            c0914h06.f429i.nativeOrientationChanged(c0914h06.f426f, c0914h06.f427g);
        }
        C0914H0 c0914h07 = this.f419a;
        if (c0914h07.f422b && c0914h07.f425e <= 0) {
            Message.obtain(c0914h07.f421a, 2269, enumC0910F02).sendToTarget();
            this.f419a.f425e++;
        }
        return true;
    }
}

// ===== FILE: com/unity3d/player/C0913H.java =====
package com.unity3d.player;

import android.view.KeyEvent;
import android.widget.TextView;

/* renamed from: com.unity3d.player.H */
/* loaded from: classes.dex */
final class C0913H implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ AbstractC0916I f420a;

    C0913H(AbstractC0916I abstractC0916I) {
        this.f420a = abstractC0916I;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            AbstractC0916I abstractC0916I = this.f420a;
            abstractC0916I.m340a(abstractC0916I.m342b(), false);
        }
        return false;
    }
}

// ===== FILE: com/unity3d/player/C0914H0.java =====
package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.unity3d.player.H0 */
/* loaded from: classes.dex */
final class C0914H0 extends Thread {

    /* renamed from: a */
    Handler f421a;

    /* renamed from: b */
    boolean f422b;

    /* renamed from: c */
    boolean f423c;

    /* renamed from: d */
    int f424d;

    /* renamed from: e */
    int f425e;

    /* renamed from: f */
    int f426f;

    /* renamed from: g */
    int f427g;

    /* renamed from: h */
    int f428h;

    /* renamed from: i */
    final /* synthetic */ UnityPlayer f429i;

    private C0914H0(UnityPlayer unityPlayer) {
        this.f429i = unityPlayer;
        this.f422b = false;
        this.f423c = false;
        this.f424d = 2;
        this.f425e = 0;
        this.f428h = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m335a(EnumC0910F0 enumC0910F0) {
        Handler handler = this.f421a;
        if (handler != null) {
            Message.obtain(handler, 2269, enumC0910F0).sendToTarget();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        setName("UnityMain");
        Looper.prepare();
        this.f421a = new Handler(Looper.myLooper(), new C0912G0(this));
        Looper.loop();
    }
}

// ===== FILE: com/unity3d/player/C0919J0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.J0 */
/* loaded from: classes.dex */
final class C0919J0 {

    /* renamed from: e */
    private static boolean f449e;

    /* renamed from: a */
    private boolean f450a = false;

    /* renamed from: b */
    private boolean f451b = false;

    /* renamed from: c */
    private boolean f452c = true;

    /* renamed from: d */
    private boolean f453d = false;

    C0919J0() {
    }

    /* renamed from: d */
    static boolean m351d() {
        return f449e;
    }

    /* renamed from: e */
    static void m352e() {
        f449e = true;
    }

    /* renamed from: f */
    static void m353f() {
        f449e = false;
    }

    /* renamed from: a */
    final boolean m354a() {
        return this.f453d;
    }

    /* renamed from: a */
    final boolean m355a(boolean z) {
        return f449e && !((!z && !this.f450a) || this.f452c || this.f451b);
    }

    /* renamed from: b */
    final void m356b(boolean z) {
        this.f450a = z;
    }

    /* renamed from: b */
    final boolean m357b() {
        return this.f452c;
    }

    /* renamed from: c */
    final void m358c(boolean z) {
        this.f451b = z;
    }

    /* renamed from: c */
    final boolean m359c() {
        return this.f451b;
    }

    /* renamed from: d */
    final void m360d(boolean z) {
        this.f453d = z;
    }

    /* renamed from: e */
    final void m361e(boolean z) {
        this.f452c = z;
    }

    public final String toString() {
        return super.toString();
    }
}

// ===== FILE: com/unity3d/player/C0922L.java =====
package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;

/* renamed from: com.unity3d.player.L */
/* loaded from: classes.dex */
final class C0922L extends EditText {

    /* renamed from: a */
    final /* synthetic */ AbstractC0916I f455a;

    /* renamed from: b */
    final /* synthetic */ C0924M f456b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0922L(C0924M c0924m, Context context, AbstractC0916I abstractC0916I) {
        super(context);
        this.f456b = c0924m;
        this.f455a = abstractC0916I;
    }

    @Override // android.widget.TextView
    public final void onEditorAction(int i) {
        if (i == 6) {
            AbstractC0916I abstractC0916I = this.f455a;
            abstractC0916I.m340a(abstractC0916I.m342b(), false);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4) {
            C0924M c0924m = this.f456b;
            c0924m.m340a(c0924m.m342b(), true);
            return true;
        }
        if (i == 84) {
            return true;
        }
        if (i != 66 || keyEvent.getAction() != 0 || (getInputType() & 131072) != 0) {
            return super.onKeyPreIme(i, keyEvent);
        }
        AbstractC0916I abstractC0916I = this.f455a;
        abstractC0916I.m340a(abstractC0916I.m342b(), false);
        return true;
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        this.f455a.f438b.reportSoftInputSelection(i, i2 - i);
    }
}

// ===== FILE: com/unity3d/player/C0924M.java =====
package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;

/* renamed from: com.unity3d.player.M */
/* loaded from: classes.dex */
final class C0924M extends AbstractC0916I {

    /* renamed from: h */
    private boolean f459h;

    /* renamed from: i */
    private Handler f460i;

    /* renamed from: j */
    private Runnable f461j;

    public C0924M(Context context, UnityPlayer unityPlayer) {
        super(context, unityPlayer);
        this.f459h = false;
    }

    @Override // com.unity3d.player.AbstractC0916I
    /* renamed from: a */
    public final void mo341a(boolean z) {
        EditText editText;
        int i;
        this.f440d = z;
        if (z) {
            editText = this.f439c;
            i = 4;
        } else {
            editText = this.f439c;
            i = 0;
        }
        editText.setVisibility(i);
        this.f439c.invalidate();
        this.f439c.requestLayout();
    }

    @Override // com.unity3d.player.AbstractC0916I
    /* renamed from: c */
    public final void mo343c() {
        Runnable runnable;
        Handler handler = this.f460i;
        if (handler != null && (runnable = this.f461j) != null) {
            handler.removeCallbacks(runnable);
        }
        this.f438b.removeView(this.f439c);
        this.f459h = false;
        invokeOnClose();
    }

    @Override // com.unity3d.player.AbstractC0916I
    protected EditText createEditText(AbstractC0916I abstractC0916I) {
        return new C0922L(this, this.f437a, abstractC0916I);
    }

    @Override // com.unity3d.player.AbstractC0916I
    /* renamed from: d */
    public final boolean mo344d() {
        return false;
    }

    @Override // com.unity3d.player.AbstractC0916I
    /* renamed from: e */
    public final void mo345e() {
        if (this.f459h) {
            return;
        }
        this.f438b.addView(this.f439c);
        this.f438b.bringChildToFront(this.f439c);
        this.f439c.setVisibility(0);
        this.f439c.requestFocus();
        this.f461j = new RunnableC0920K(this);
        Handler handler = new Handler(Looper.getMainLooper());
        this.f460i = handler;
        handler.postDelayed(this.f461j, 400L);
        this.f459h = true;
    }
}

// ===== FILE: com/unity3d/player/C0929O0.java =====
package com.unity3d.player;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.unity3d.player.O0 */
/* loaded from: classes.dex */
final class C0929O0 implements InterfaceC0921K0 {

    /* renamed from: a */
    final /* synthetic */ RunnableC0931P0 f494a;

    C0929O0(RunnableC0931P0 runnableC0931P0) {
        this.f494a = runnableC0931P0;
    }

    /* renamed from: a */
    public final void m366a(int i) {
        ReentrantLock reentrantLock;
        ReentrantLock reentrantLock2;
        Semaphore semaphore;
        boolean z;
        reentrantLock = this.f494a.f505h.f526e;
        reentrantLock.lock();
        C0941U0 c0941u0 = this.f494a.f505h;
        c0941u0.f528g = i;
        if (i == 3) {
            z = c0941u0.f530i;
            if (z) {
                c0941u0.runOnUiThread(new RunnableC0927N0(this));
            }
        }
        if (i != 0) {
            semaphore = this.f494a.f505h.f525d;
            semaphore.release();
        }
        reentrantLock2 = this.f494a.f505h.f526e;
        reentrantLock2.unlock();
    }
}

// ===== FILE: com/unity3d/player/C0932Q.java =====
package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;

/* renamed from: com.unity3d.player.Q */
/* loaded from: classes.dex */
final class C0932Q extends EditText {

    /* renamed from: a */
    final /* synthetic */ AbstractC0916I f508a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0932Q(Context context, AbstractC0916I abstractC0916I) {
        super(context);
        this.f508a = abstractC0916I;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4) {
            AbstractC0916I abstractC0916I = this.f508a;
            abstractC0916I.m340a(abstractC0916I.m342b(), true);
            return true;
        }
        if (i == 84) {
            return true;
        }
        if (i == 66 && keyEvent.getAction() == 0 && (getInputType() & 131072) == 0) {
            AbstractC0916I abstractC0916I2 = this.f508a;
            abstractC0916I2.m340a(abstractC0916I2.m342b(), false);
            return true;
        }
        if (i != 111 || keyEvent.getAction() != 0) {
            return super.onKeyPreIme(i, keyEvent);
        }
        AbstractC0916I abstractC0916I3 = this.f508a;
        abstractC0916I3.m340a(abstractC0916I3.m342b(), true);
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            requestFocus();
            this.f508a.m346f();
        }
    }
}

// ===== FILE: com/unity3d/player/C0934R.java =====
package com.unity3d.player;

import epic.org.flappybird.C1287R;

/* renamed from: com.unity3d.player.R */
/* loaded from: classes.dex */
public final class C0934R {

    /* renamed from: com.unity3d.player.R$anim */
    public static final class anim {
        public static final int abc_fade_in = 2130771968;
        public static final int abc_fade_out = 2130771969;
        public static final int abc_grow_fade_in_from_bottom = 2130771970;
        public static final int abc_popup_enter = 2130771971;
        public static final int abc_popup_exit = 2130771972;
        public static final int abc_shrink_fade_out_from_bottom = 2130771973;
        public static final int abc_slide_in_bottom = 2130771974;
        public static final int abc_slide_in_top = 2130771975;
        public static final int abc_slide_out_bottom = 2130771976;
        public static final int abc_slide_out_top = 2130771977;
        public static final int abc_tooltip_enter = 2130771978;
        public static final int abc_tooltip_exit = 2130771979;
        public static final int btn_checkbox_to_checked_box_inner_merged_animation = 2130771980;
        public static final int btn_checkbox_to_checked_box_outer_merged_animation = 2130771981;
        public static final int btn_checkbox_to_checked_icon_null_animation = 2130771982;
        public static final int btn_checkbox_to_unchecked_box_inner_merged_animation = 2130771983;
        public static final int btn_checkbox_to_unchecked_check_path_merged_animation = 2130771984;
        public static final int btn_checkbox_to_unchecked_icon_null_animation = 2130771985;
        public static final int btn_radio_to_off_mtrl_dot_group_animation = 2130771986;
        public static final int btn_radio_to_off_mtrl_ring_outer_animation = 2130771987;
        public static final int btn_radio_to_off_mtrl_ring_outer_path_animation = 2130771988;
        public static final int btn_radio_to_on_mtrl_dot_group_animation = 2130771989;
        public static final int btn_radio_to_on_mtrl_ring_outer_animation = 2130771990;
        public static final int btn_radio_to_on_mtrl_ring_outer_path_animation = 2130771991;
        public static final int fragment_fast_out_extra_slow_in = 2130771992;

        private anim() {
        }
    }

    /* renamed from: com.unity3d.player.R$animator */
    public static final class animator {
        public static final int fragment_close_enter = 2130837504;
        public static final int fragment_close_exit = 2130837505;
        public static final int fragment_fade_enter = 2130837506;
        public static final int fragment_fade_exit = 2130837507;
        public static final int fragment_open_enter = 2130837508;
        public static final int fragment_open_exit = 2130837509;

        private animator() {
        }
    }

    /* renamed from: com.unity3d.player.R$attr */
    public static final class attr {
        public static final int SharedValue = 2130903040;
        public static final int SharedValueId = 2130903041;
        public static final int actionBarDivider = 2130903042;
        public static final int actionBarItemBackground = 2130903043;
        public static final int actionBarPopupTheme = 2130903044;
        public static final int actionBarSize = 2130903045;
        public static final int actionBarSplitStyle = 2130903046;
        public static final int actionBarStyle = 2130903047;
        public static final int actionBarTabBarStyle = 2130903048;
        public static final int actionBarTabStyle = 2130903049;
        public static final int actionBarTabTextStyle = 2130903050;
        public static final int actionBarTheme = 2130903051;
        public static final int actionBarWidgetTheme = 2130903052;
        public static final int actionButtonStyle = 2130903053;
        public static final int actionDropDownStyle = 2130903054;
        public static final int actionLayout = 2130903055;
        public static final int actionMenuTextAppearance = 2130903056;
        public static final int actionMenuTextColor = 2130903057;
        public static final int actionModeBackground = 2130903058;
        public static final int actionModeCloseButtonStyle = 2130903059;
        public static final int actionModeCloseContentDescription = 2130903060;
        public static final int actionModeCloseDrawable = 2130903061;
        public static final int actionModeCopyDrawable = 2130903062;
        public static final int actionModeCutDrawable = 2130903063;
        public static final int actionModeFindDrawable = 2130903064;
        public static final int actionModePasteDrawable = 2130903065;
        public static final int actionModePopupWindowStyle = 2130903066;
        public static final int actionModeSelectAllDrawable = 2130903067;
        public static final int actionModeShareDrawable = 2130903068;
        public static final int actionModeSplitBackground = 2130903069;
        public static final int actionModeStyle = 2130903070;
        public static final int actionModeTheme = 2130903071;
        public static final int actionModeWebSearchDrawable = 2130903072;
        public static final int actionOverflowButtonStyle = 2130903073;
        public static final int actionOverflowMenuStyle = 2130903074;
        public static final int actionProviderClass = 2130903075;
        public static final int actionViewClass = 2130903076;
        public static final int activityChooserViewStyle = 2130903077;
        public static final int alertDialogButtonGroupStyle = 2130903078;
        public static final int alertDialogCenterButtons = 2130903079;
        public static final int alertDialogStyle = 2130903080;
        public static final int alertDialogTheme = 2130903081;
        public static final int allowStacking = 2130903082;
        public static final int alpha = 2130903083;
        public static final int alphabeticModifiers = 2130903084;
        public static final int altSrc = 2130903085;
        public static final int animateCircleAngleTo = 2130903086;
        public static final int animateRelativeTo = 2130903087;
        public static final int applyMotionScene = 2130903088;
        public static final int arcMode = 2130903089;
        public static final int arrowHeadLength = 2130903090;
        public static final int arrowShaftLength = 2130903091;
        public static final int attributeName = 2130903092;
        public static final int autoCompleteMode = 2130903093;
        public static final int autoCompleteTextViewStyle = 2130903094;
        public static final int autoSizeMaxTextSize = 2130903095;
        public static final int autoSizeMinTextSize = 2130903096;
        public static final int autoSizePresetSizes = 2130903097;
        public static final int autoSizeStepGranularity = 2130903098;
        public static final int autoSizeTextType = 2130903099;
        public static final int autoTransition = 2130903100;
        public static final int background = 2130903101;
        public static final int backgroundSplit = 2130903102;
        public static final int backgroundStacked = 2130903103;
        public static final int backgroundTint = 2130903104;
        public static final int backgroundTintMode = 2130903105;
        public static final int barLength = 2130903106;
        public static final int barrierAllowsGoneWidgets = 2130903107;
        public static final int barrierDirection = 2130903108;
        public static final int barrierMargin = 2130903109;
        public static final int blendSrc = 2130903110;
        public static final int borderRound = 2130903111;
        public static final int borderRoundPercent = 2130903112;
        public static final int borderlessButtonStyle = 2130903113;
        public static final int brightness = 2130903114;
        public static final int buttonBarButtonStyle = 2130903115;
        public static final int buttonBarNegativeButtonStyle = 2130903116;
        public static final int buttonBarNeutralButtonStyle = 2130903117;
        public static final int buttonBarPositiveButtonStyle = 2130903118;
        public static final int buttonBarStyle = 2130903119;
        public static final int buttonCompat = 2130903120;
        public static final int buttonGravity = 2130903121;
        public static final int buttonIconDimen = 2130903122;
        public static final int buttonPanelSideLayout = 2130903123;
        public static final int buttonSize = 2130903124;
        public static final int buttonStyle = 2130903125;
        public static final int buttonStyleSmall = 2130903126;
        public static final int buttonTint = 2130903127;
        public static final int buttonTintMode = 2130903128;
        public static final int carousel_backwardTransition = 2130903129;
        public static final int carousel_emptyViewsBehavior = 2130903130;
        public static final int carousel_firstView = 2130903131;
        public static final int carousel_forwardTransition = 2130903132;
        public static final int carousel_infinite = 2130903133;
        public static final int carousel_nextState = 2130903134;
        public static final int carousel_previousState = 2130903135;
        public static final int carousel_touchUpMode = 2130903136;
        public static final int carousel_touchUp_dampeningFactor = 2130903137;
        public static final int carousel_touchUp_velocityThreshold = 2130903138;
        public static final int chainUseRtl = 2130903139;
        public static final int checkMarkCompat = 2130903140;
        public static final int checkMarkTint = 2130903141;
        public static final int checkMarkTintMode = 2130903142;
        public static final int checkboxStyle = 2130903143;
        public static final int checkedTextViewStyle = 2130903144;
        public static final int circleCrop = 2130903145;
        public static final int circleRadius = 2130903146;
        public static final int circularflow_angles = 2130903147;
        public static final int circularflow_defaultAngle = 2130903148;
        public static final int circularflow_defaultRadius = 2130903149;
        public static final int circularflow_radiusInDP = 2130903150;
        public static final int circularflow_viewCenter = 2130903151;
        public static final int clearsTag = 2130903152;
        public static final int clickAction = 2130903153;
        public static final int closeIcon = 2130903154;
        public static final int closeItemLayout = 2130903155;
        public static final int collapseContentDescription = 2130903156;
        public static final int collapseIcon = 2130903157;
        public static final int color = 2130903158;
        public static final int colorAccent = 2130903159;
        public static final int colorBackgroundFloating = 2130903160;
        public static final int colorButtonNormal = 2130903161;
        public static final int colorControlActivated = 2130903162;
        public static final int colorControlHighlight = 2130903163;
        public static final int colorControlNormal = 2130903164;
        public static final int colorError = 2130903165;
        public static final int colorPrimary = 2130903166;
        public static final int colorPrimaryDark = 2130903167;
        public static final int colorScheme = 2130903168;
        public static final int colorSwitchThumbNormal = 2130903169;
        public static final int commitIcon = 2130903170;
        public static final int constraintRotate = 2130903171;
        public static final int constraintSet = 2130903172;
        public static final int constraintSetEnd = 2130903173;
        public static final int constraintSetStart = 2130903174;
        public static final int constraint_referenced_ids = 2130903175;
        public static final int constraint_referenced_tags = 2130903176;
        public static final int constraints = 2130903177;
        public static final int content = 2130903178;
        public static final int contentDescription = 2130903179;
        public static final int contentInsetEnd = 2130903180;
        public static final int contentInsetEndWithActions = 2130903181;
        public static final int contentInsetLeft = 2130903182;
        public static final int contentInsetRight = 2130903183;
        public static final int contentInsetStart = 2130903184;
        public static final int contentInsetStartWithNavigation = 2130903185;
        public static final int contrast = 2130903186;
        public static final int controlBackground = 2130903187;
        public static final int crossfade = 2130903188;
        public static final int currentState = 2130903189;
        public static final int curveFit = 2130903190;
        public static final int customBoolean = 2130903191;
        public static final int customColorDrawableValue = 2130903192;
        public static final int customColorValue = 2130903193;
        public static final int customDimension = 2130903194;
        public static final int customFloatValue = 2130903195;
        public static final int customIntegerValue = 2130903196;
        public static final int customNavigationLayout = 2130903197;
        public static final int customPixelDimension = 2130903198;
        public static final int customReference = 2130903199;
        public static final int customStringValue = 2130903200;
        public static final int defaultDuration = 2130903201;
        public static final int defaultQueryHint = 2130903202;
        public static final int defaultState = 2130903203;
        public static final int deltaPolarAngle = 2130903204;
        public static final int deltaPolarRadius = 2130903205;
        public static final int deriveConstraintsFrom = 2130903206;
        public static final int dialogCornerRadius = 2130903207;
        public static final int dialogPreferredPadding = 2130903208;
        public static final int dialogTheme = 2130903209;
        public static final int displayOptions = 2130903210;
        public static final int divider = 2130903211;
        public static final int dividerHorizontal = 2130903212;
        public static final int dividerPadding = 2130903213;
        public static final int dividerVertical = 2130903214;
        public static final int dragDirection = 2130903215;
        public static final int dragScale = 2130903216;
        public static final int dragThreshold = 2130903217;
        public static final int drawPath = 2130903218;
        public static final int drawableBottomCompat = 2130903219;
        public static final int drawableEndCompat = 2130903220;
        public static final int drawableLeftCompat = 2130903221;
        public static final int drawableRightCompat = 2130903222;
        public static final int drawableSize = 2130903223;
        public static final int drawableStartCompat = 2130903224;
        public static final int drawableTint = 2130903225;
        public static final int drawableTintMode = 2130903226;
        public static final int drawableTopCompat = 2130903227;
        public static final int drawerArrowStyle = 2130903228;
        public static final int dropDownListViewStyle = 2130903229;
        public static final int dropdownListPreferredItemHeight = 2130903230;
        public static final int duration = 2130903231;
        public static final int editTextBackground = 2130903232;
        public static final int editTextColor = 2130903233;
        public static final int editTextStyle = 2130903234;
        public static final int elevation = 2130903235;
        public static final int emojiCompatEnabled = 2130903236;
        public static final int expandActivityOverflowButtonDrawable = 2130903237;
        public static final int firstBaselineToTopHeight = 2130903238;
        public static final int flow_firstHorizontalBias = 2130903239;
        public static final int flow_firstHorizontalStyle = 2130903240;
        public static final int flow_firstVerticalBias = 2130903241;
        public static final int flow_firstVerticalStyle = 2130903242;
        public static final int flow_horizontalAlign = 2130903243;
        public static final int flow_horizontalBias = 2130903244;
        public static final int flow_horizontalGap = 2130903245;
        public static final int flow_horizontalStyle = 2130903246;
        public static final int flow_lastHorizontalBias = 2130903247;
        public static final int flow_lastHorizontalStyle = 2130903248;
        public static final int flow_lastVerticalBias = 2130903249;
        public static final int flow_lastVerticalStyle = 2130903250;
        public static final int flow_maxElementsWrap = 2130903251;
        public static final int flow_padding = 2130903252;
        public static final int flow_verticalAlign = 2130903253;
        public static final int flow_verticalBias = 2130903254;
        public static final int flow_verticalGap = 2130903255;
        public static final int flow_verticalStyle = 2130903256;
        public static final int flow_wrapMode = 2130903257;
        public static final int font = 2130903258;
        public static final int fontFamily = 2130903259;
        public static final int fontProviderAuthority = 2130903260;
        public static final int fontProviderCerts = 2130903261;
        public static final int fontProviderFetchStrategy = 2130903262;
        public static final int fontProviderFetchTimeout = 2130903263;
        public static final int fontProviderPackage = 2130903264;
        public static final int fontProviderQuery = 2130903265;
        public static final int fontProviderSystemFontFamily = 2130903266;
        public static final int fontStyle = 2130903267;
        public static final int fontVariationSettings = 2130903268;
        public static final int fontWeight = 2130903269;
        public static final int framePosition = 2130903270;
        public static final int gapBetweenBars = 2130903271;
        public static final int goIcon = 2130903272;
        public static final int guidelineUseRtl = 2130903273;
        public static final int height = 2130903274;
        public static final int hideOnContentScroll = 2130903275;
        public static final int homeAsUpIndicator = 2130903276;
        public static final int homeLayout = 2130903277;
        public static final int icon = 2130903278;
        public static final int iconTint = 2130903279;
        public static final int iconTintMode = 2130903280;
        public static final int iconifiedByDefault = 2130903281;
        public static final int ifTagNotSet = 2130903282;
        public static final int ifTagSet = 2130903283;
        public static final int imageAspectRatio = 2130903284;
        public static final int imageAspectRatioAdjust = 2130903285;
        public static final int imageButtonStyle = 2130903286;
        public static final int imagePanX = 2130903287;
        public static final int imagePanY = 2130903288;
        public static final int imageRotate = 2130903289;
        public static final int imageZoom = 2130903290;
        public static final int indeterminateProgressStyle = 2130903291;
        public static final int initialActivityCount = 2130903292;
        public static final int isLightTheme = 2130903293;
        public static final int itemPadding = 2130903294;
        public static final int keyPositionType = 2130903295;
        public static final int lStar = 2130903296;
        public static final int lastBaselineToBottomHeight = 2130903297;
        public static final int layout = 2130903298;
        public static final int layoutDescription = 2130903299;
        public static final int layoutDuringTransition = 2130903300;
        public static final int layout_constrainedHeight = 2130903301;
        public static final int layout_constrainedWidth = 2130903302;
        public static final int layout_constraintBaseline_creator = 2130903303;
        public static final int layout_constraintBaseline_toBaselineOf = 2130903304;
        public static final int layout_constraintBaseline_toBottomOf = 2130903305;
        public static final int layout_constraintBaseline_toTopOf = 2130903306;
        public static final int layout_constraintBottom_creator = 2130903307;
        public static final int layout_constraintBottom_toBottomOf = 2130903308;
        public static final int layout_constraintBottom_toTopOf = 2130903309;
        public static final int layout_constraintCircle = 2130903310;
        public static final int layout_constraintCircleAngle = 2130903311;
        public static final int layout_constraintCircleRadius = 2130903312;
        public static final int layout_constraintDimensionRatio = 2130903313;
        public static final int layout_constraintEnd_toEndOf = 2130903314;
        public static final int layout_constraintEnd_toStartOf = 2130903315;
        public static final int layout_constraintGuide_begin = 2130903316;
        public static final int layout_constraintGuide_end = 2130903317;
        public static final int layout_constraintGuide_percent = 2130903318;
        public static final int layout_constraintHeight = 2130903319;
        public static final int layout_constraintHeight_default = 2130903320;
        public static final int layout_constraintHeight_max = 2130903321;
        public static final int layout_constraintHeight_min = 2130903322;
        public static final int layout_constraintHeight_percent = 2130903323;
        public static final int layout_constraintHorizontal_bias = 2130903324;
        public static final int layout_constraintHorizontal_chainStyle = 2130903325;
        public static final int layout_constraintHorizontal_weight = 2130903326;
        public static final int layout_constraintLeft_creator = 2130903327;
        public static final int layout_constraintLeft_toLeftOf = 2130903328;
        public static final int layout_constraintLeft_toRightOf = 2130903329;
        public static final int layout_constraintRight_creator = 2130903330;
        public static final int layout_constraintRight_toLeftOf = 2130903331;
        public static final int layout_constraintRight_toRightOf = 2130903332;
        public static final int layout_constraintStart_toEndOf = 2130903333;
        public static final int layout_constraintStart_toStartOf = 2130903334;
        public static final int layout_constraintTag = 2130903335;
        public static final int layout_constraintTop_creator = 2130903336;
        public static final int layout_constraintTop_toBottomOf = 2130903337;
        public static final int layout_constraintTop_toTopOf = 2130903338;
        public static final int layout_constraintVertical_bias = 2130903339;
        public static final int layout_constraintVertical_chainStyle = 2130903340;
        public static final int layout_constraintVertical_weight = 2130903341;
        public static final int layout_constraintWidth = 2130903342;
        public static final int layout_constraintWidth_default = 2130903343;
        public static final int layout_constraintWidth_max = 2130903344;
        public static final int layout_constraintWidth_min = 2130903345;
        public static final int layout_constraintWidth_percent = 2130903346;
        public static final int layout_editor_absoluteX = 2130903347;
        public static final int layout_editor_absoluteY = 2130903348;
        public static final int layout_goneMarginBaseline = 2130903349;
        public static final int layout_goneMarginBottom = 2130903350;
        public static final int layout_goneMarginEnd = 2130903351;
        public static final int layout_goneMarginLeft = 2130903352;
        public static final int layout_goneMarginRight = 2130903353;
        public static final int layout_goneMarginStart = 2130903354;
        public static final int layout_goneMarginTop = 2130903355;
        public static final int layout_marginBaseline = 2130903356;
        public static final int layout_optimizationLevel = 2130903357;
        public static final int layout_wrapBehaviorInParent = 2130903358;
        public static final int limitBoundsTo = 2130903359;
        public static final int lineHeight = 2130903360;
        public static final int listChoiceBackgroundIndicator = 2130903361;
        public static final int listChoiceIndicatorMultipleAnimated = 2130903362;
        public static final int listChoiceIndicatorSingleAnimated = 2130903363;
        public static final int listDividerAlertDialog = 2130903364;
        public static final int listItemLayout = 2130903365;
        public static final int listLayout = 2130903366;
        public static final int listMenuViewStyle = 2130903367;
        public static final int listPopupWindowStyle = 2130903368;
        public static final int listPreferredItemHeight = 2130903369;
        public static final int listPreferredItemHeightLarge = 2130903370;
        public static final int listPreferredItemHeightSmall = 2130903371;
        public static final int listPreferredItemPaddingEnd = 2130903372;
        public static final int listPreferredItemPaddingLeft = 2130903373;
        public static final int listPreferredItemPaddingRight = 2130903374;
        public static final int listPreferredItemPaddingStart = 2130903375;
        public static final int logo = 2130903376;
        public static final int logoDescription = 2130903377;
        public static final int maxAcceleration = 2130903378;
        public static final int maxButtonHeight = 2130903379;
        public static final int maxHeight = 2130903380;
        public static final int maxVelocity = 2130903381;
        public static final int maxWidth = 2130903382;
        public static final int measureWithLargestChild = 2130903383;
        public static final int menu = 2130903384;
        public static final int methodName = 2130903385;
        public static final int minHeight = 2130903386;
        public static final int minWidth = 2130903387;
        public static final int mock_diagonalsColor = 2130903388;
        public static final int mock_label = 2130903389;
        public static final int mock_labelBackgroundColor = 2130903390;
        public static final int mock_labelColor = 2130903391;
        public static final int mock_showDiagonals = 2130903392;
        public static final int mock_showLabel = 2130903393;
        public static final int motionDebug = 2130903394;
        public static final int motionEffect_alpha = 2130903395;
        public static final int motionEffect_end = 2130903396;
        public static final int motionEffect_move = 2130903397;
        public static final int motionEffect_start = 2130903398;
        public static final int motionEffect_strict = 2130903399;
        public static final int motionEffect_translationX = 2130903400;
        public static final int motionEffect_translationY = 2130903401;
        public static final int motionEffect_viewTransition = 2130903402;
        public static final int motionInterpolator = 2130903403;
        public static final int motionPathRotate = 2130903404;
        public static final int motionProgress = 2130903405;
        public static final int motionStagger = 2130903406;
        public static final int motionTarget = 2130903407;
        public static final int motion_postLayoutCollision = 2130903408;
        public static final int motion_triggerOnCollision = 2130903409;
        public static final int moveWhenScrollAtTop = 2130903410;
        public static final int multiChoiceItemLayout = 2130903411;
        public static final int navigationContentDescription = 2130903412;
        public static final int navigationIcon = 2130903413;
        public static final int navigationMode = 2130903414;
        public static final int nestedScrollFlags = 2130903415;
        public static final int nestedScrollViewStyle = 2130903416;
        public static final int numericModifiers = 2130903417;
        public static final int onCross = 2130903418;
        public static final int onHide = 2130903419;
        public static final int onNegativeCross = 2130903420;
        public static final int onPositiveCross = 2130903421;
        public static final int onShow = 2130903422;
        public static final int onStateTransition = 2130903423;
        public static final int onTouchUp = 2130903424;
        public static final int overlapAnchor = 2130903425;
        public static final int overlay = 2130903426;
        public static final int paddingBottomNoButtons = 2130903427;
        public static final int paddingEnd = 2130903428;
        public static final int paddingStart = 2130903429;
        public static final int paddingTopNoTitle = 2130903430;
        public static final int panelBackground = 2130903431;
        public static final int panelMenuListTheme = 2130903432;
        public static final int panelMenuListWidth = 2130903433;
        public static final int pathMotionArc = 2130903434;
        public static final int path_percent = 2130903435;
        public static final int percentHeight = 2130903436;
        public static final int percentWidth = 2130903437;
        public static final int percentX = 2130903438;
        public static final int percentY = 2130903439;
        public static final int perpendicularPath_percent = 2130903440;
        public static final int pivotAnchor = 2130903441;
        public static final int placeholder_emptyVisibility = 2130903442;
        public static final int polarRelativeTo = 2130903443;
        public static final int popupMenuStyle = 2130903444;
        public static final int popupTheme = 2130903445;
        public static final int popupWindowStyle = 2130903446;
        public static final int preserveIconSpacing = 2130903447;
        public static final int progressBarPadding = 2130903448;
        public static final int progressBarStyle = 2130903449;
        public static final int quantizeMotionInterpolator = 2130903450;
        public static final int quantizeMotionPhase = 2130903451;
        public static final int quantizeMotionSteps = 2130903452;
        public static final int queryBackground = 2130903453;
        public static final int queryHint = 2130903454;
        public static final int queryPatterns = 2130903455;
        public static final int radioButtonStyle = 2130903456;
        public static final int ratingBarStyle = 2130903457;
        public static final int ratingBarStyleIndicator = 2130903458;
        public static final int ratingBarStyleSmall = 2130903459;
        public static final int reactiveGuide_animateChange = 2130903460;
        public static final int reactiveGuide_applyToAllConstraintSets = 2130903461;
        public static final int reactiveGuide_applyToConstraintSet = 2130903462;
        public static final int reactiveGuide_valueId = 2130903463;
        public static final int region_heightLessThan = 2130903464;
        public static final int region_heightMoreThan = 2130903465;
        public static final int region_widthLessThan = 2130903466;
        public static final int region_widthMoreThan = 2130903467;
        public static final int rotationCenterId = 2130903468;
        public static final int round = 2130903469;
        public static final int roundPercent = 2130903470;
        public static final int saturation = 2130903471;
        public static final int scaleFromTextSize = 2130903472;
        public static final int scopeUris = 2130903473;
        public static final int searchHintIcon = 2130903474;
        public static final int searchIcon = 2130903475;
        public static final int searchViewStyle = 2130903476;
        public static final int seekBarStyle = 2130903477;
        public static final int selectableItemBackground = 2130903478;
        public static final int selectableItemBackgroundBorderless = 2130903479;
        public static final int setsTag = 2130903480;
        public static final int shortcutMatchRequired = 2130903481;
        public static final int showAsAction = 2130903482;
        public static final int showDividers = 2130903483;
        public static final int showPaths = 2130903484;
        public static final int showText = 2130903485;
        public static final int showTitle = 2130903486;
        public static final int singleChoiceItemLayout = 2130903487;
        public static final int sizePercent = 2130903488;
        public static final int spinBars = 2130903489;
        public static final int spinnerDropDownItemStyle = 2130903490;
        public static final int spinnerStyle = 2130903491;
        public static final int splitTrack = 2130903492;
        public static final int springBoundary = 2130903493;
        public static final int springDamping = 2130903494;
        public static final int springMass = 2130903495;
        public static final int springStiffness = 2130903496;
        public static final int springStopThreshold = 2130903497;
        public static final int srcCompat = 2130903498;
        public static final int staggered = 2130903499;
        public static final int state_above_anchor = 2130903500;
        public static final int subMenuArrow = 2130903501;
        public static final int submitBackground = 2130903502;
        public static final int subtitle = 2130903503;
        public static final int subtitleTextAppearance = 2130903504;
        public static final int subtitleTextColor = 2130903505;
        public static final int subtitleTextStyle = 2130903506;
        public static final int suggestionRowLayout = 2130903507;
        public static final int switchMinWidth = 2130903508;
        public static final int switchPadding = 2130903509;
        public static final int switchStyle = 2130903510;
        public static final int switchTextAppearance = 2130903511;
        public static final int targetId = 2130903512;
        public static final int telltales_tailColor = 2130903513;
        public static final int telltales_tailScale = 2130903514;
        public static final int telltales_velocityMode = 2130903515;
        public static final int textAllCaps = 2130903516;
        public static final int textAppearanceLargePopupMenu = 2130903517;
        public static final int textAppearanceListItem = 2130903518;
        public static final int textAppearanceListItemSecondary = 2130903519;
        public static final int textAppearanceListItemSmall = 2130903520;
        public static final int textAppearancePopupMenuHeader = 2130903521;
        public static final int textAppearanceSearchResultSubtitle = 2130903522;
        public static final int textAppearanceSearchResultTitle = 2130903523;
        public static final int textAppearanceSmallPopupMenu = 2130903524;
        public static final int textBackground = 2130903525;
        public static final int textBackgroundPanX = 2130903526;
        public static final int textBackgroundPanY = 2130903527;
        public static final int textBackgroundRotate = 2130903528;
        public static final int textBackgroundZoom = 2130903529;
        public static final int textColorAlertDialogListItem = 2130903530;
        public static final int textColorSearchUrl = 2130903531;
        public static final int textFillColor = 2130903532;
        public static final int textLocale = 2130903533;
        public static final int textOutlineColor = 2130903534;
        public static final int textOutlineThickness = 2130903535;
        public static final int textPanX = 2130903536;
        public static final int textPanY = 2130903537;
        public static final int textureBlurFactor = 2130903538;
        public static final int textureEffect = 2130903539;
        public static final int textureHeight = 2130903540;
        public static final int textureWidth = 2130903541;
        public static final int theme = 2130903542;
        public static final int thickness = 2130903543;
        public static final int thumbTextPadding = 2130903544;
        public static final int thumbTint = 2130903545;
        public static final int thumbTintMode = 2130903546;
        public static final int tickMark = 2130903547;
        public static final int tickMarkTint = 2130903548;
        public static final int tickMarkTintMode = 2130903549;
        public static final int tint = 2130903550;
        public static final int tintMode = 2130903551;
        public static final int title = 2130903552;
        public static final int titleMargin = 2130903553;
        public static final int titleMarginBottom = 2130903554;
        public static final int titleMarginEnd = 2130903555;
        public static final int titleMarginStart = 2130903556;
        public static final int titleMarginTop = 2130903557;
        public static final int titleMargins = 2130903558;
        public static final int titleTextAppearance = 2130903559;
        public static final int titleTextColor = 2130903560;
        public static final int titleTextStyle = 2130903561;
        public static final int toolbarNavigationButtonStyle = 2130903562;
        public static final int toolbarStyle = 2130903563;
        public static final int tooltipForegroundColor = 2130903564;
        public static final int tooltipFrameBackground = 2130903565;
        public static final int tooltipText = 2130903566;
        public static final int touchAnchorId = 2130903567;
        public static final int touchAnchorSide = 2130903568;
        public static final int touchRegionId = 2130903569;
        public static final int track = 2130903570;
        public static final int trackTint = 2130903571;
        public static final int trackTintMode = 2130903572;
        public static final int transformPivotTarget = 2130903573;
        public static final int transitionDisable = 2130903574;
        public static final int transitionEasing = 2130903575;
        public static final int transitionFlags = 2130903576;
        public static final int transitionPathRotate = 2130903577;
        public static final int triggerId = 2130903578;
        public static final int triggerReceiver = 2130903579;
        public static final int triggerSlack = 2130903580;
        public static final int ttcIndex = 2130903581;
        public static final int upDuration = 2130903582;
        public static final int viewInflaterClass = 2130903583;
        public static final int viewTransitionMode = 2130903584;
        public static final int viewTransitionOnCross = 2130903585;
        public static final int viewTransitionOnNegativeCross = 2130903586;
        public static final int viewTransitionOnPositiveCross = 2130903587;
        public static final int visibilityMode = 2130903588;
        public static final int voiceIcon = 2130903589;
        public static final int warmth = 2130903590;
        public static final int waveDecay = 2130903591;
        public static final int waveOffset = 2130903592;
        public static final int wavePeriod = 2130903593;
        public static final int wavePhase = 2130903594;
        public static final int waveShape = 2130903595;
        public static final int waveVariesBy = 2130903596;
        public static final int windowActionBar = 2130903597;
        public static final int windowActionBarOverlay = 2130903598;
        public static final int windowActionModeOverlay = 2130903599;
        public static final int windowFixedHeightMajor = 2130903600;
        public static final int windowFixedHeightMinor = 2130903601;
        public static final int windowFixedWidthMajor = 2130903602;
        public static final int windowFixedWidthMinor = 2130903603;
        public static final int windowMinWidthMajor = 2130903604;
        public static final int windowMinWidthMinor = 2130903605;
        public static final int windowNoTitle = 2130903606;

        private attr() {
        }
    }

    /* renamed from: com.unity3d.player.R$bool */
    public static final class bool {
        public static final int abc_action_bar_embed_tabs = 2130968576;
        public static final int abc_config_actionMenuItemAllCaps = 2130968577;
        public static final int enable_system_alarm_service_default = 2130968578;
        public static final int enable_system_foreground_service_default = 2130968579;
        public static final int enable_system_job_service_default = 2130968580;
        public static final int workmanager_test_configuration = 2130968581;

        private bool() {
        }
    }

    /* renamed from: com.unity3d.player.R$color */
    public static final class color {
        public static final int abc_background_cache_hint_selector_material_dark = 2131034112;
        public static final int abc_background_cache_hint_selector_material_light = 2131034113;
        public static final int abc_btn_colored_borderless_text_material = 2131034114;
        public static final int abc_btn_colored_text_material = 2131034115;
        public static final int abc_color_highlight_material = 2131034116;
        public static final int abc_decor_view_status_guard = 2131034117;
        public static final int abc_decor_view_status_guard_light = 2131034118;
        public static final int abc_hint_foreground_material_dark = 2131034119;
        public static final int abc_hint_foreground_material_light = 2131034120;
        public static final int abc_primary_text_disable_only_material_dark = 2131034121;
        public static final int abc_primary_text_disable_only_material_light = 2131034122;
        public static final int abc_primary_text_material_dark = 2131034123;
        public static final int abc_primary_text_material_light = 2131034124;
        public static final int abc_search_url_text = 2131034125;
        public static final int abc_search_url_text_normal = 2131034126;
        public static final int abc_search_url_text_pressed = 2131034127;
        public static final int abc_search_url_text_selected = 2131034128;
        public static final int abc_secondary_text_material_dark = 2131034129;
        public static final int abc_secondary_text_material_light = 2131034130;
        public static final int abc_tint_btn_checkable = 2131034131;
        public static final int abc_tint_default = 2131034132;
        public static final int abc_tint_edittext = 2131034133;
        public static final int abc_tint_seek_thumb = 2131034134;
        public static final int abc_tint_spinner = 2131034135;
        public static final int abc_tint_switch_track = 2131034136;
        public static final int accent_material_dark = 2131034137;
        public static final int accent_material_light = 2131034138;
        public static final int androidx_core_ripple_material_light = 2131034139;
        public static final int androidx_core_secondary_text_default_material_light = 2131034140;
        public static final int background_floating_material_dark = 2131034141;
        public static final int background_floating_material_light = 2131034142;
        public static final int background_material_dark = 2131034143;
        public static final int background_material_light = 2131034144;
        public static final int bright_foreground_disabled_material_dark = 2131034145;
        public static final int bright_foreground_disabled_material_light = 2131034146;
        public static final int bright_foreground_inverse_material_dark = 2131034147;
        public static final int bright_foreground_inverse_material_light = 2131034148;
        public static final int bright_foreground_material_dark = 2131034149;
        public static final int bright_foreground_material_light = 2131034150;
        public static final int browser_actions_bg_grey = 2131034151;
        public static final int browser_actions_divider_color = 2131034152;
        public static final int browser_actions_text_color = 2131034153;
        public static final int browser_actions_title_color = 2131034154;
        public static final int button_material_dark = 2131034155;
        public static final int button_material_light = 2131034156;
        public static final int common_google_signin_btn_text_dark = 2131034157;
        public static final int common_google_signin_btn_text_dark_default = 2131034158;
        public static final int common_google_signin_btn_text_dark_disabled = 2131034159;
        public static final int common_google_signin_btn_text_dark_focused = 2131034160;
        public static final int common_google_signin_btn_text_dark_pressed = 2131034161;
        public static final int common_google_signin_btn_text_light = 2131034162;
        public static final int common_google_signin_btn_text_light_default = 2131034163;
        public static final int common_google_signin_btn_text_light_disabled = 2131034164;
        public static final int common_google_signin_btn_text_light_focused = 2131034165;
        public static final int common_google_signin_btn_text_light_pressed = 2131034166;
        public static final int common_google_signin_btn_tint = 2131034167;
        public static final int dim_foreground_disabled_material_dark = 2131034168;
        public static final int dim_foreground_disabled_material_light = 2131034169;
        public static final int dim_foreground_material_dark = 2131034170;
        public static final int dim_foreground_material_light = 2131034171;
        public static final int eos_customTabToolbarColor = 2131034172;
        public static final int error_color_material_dark = 2131034173;
        public static final int error_color_material_light = 2131034174;
        public static final int foreground_material_dark = 2131034175;
        public static final int foreground_material_light = 2131034176;
        public static final int highlighted_text_material_dark = 2131034177;
        public static final int highlighted_text_material_light = 2131034178;
        public static final int material_blue_grey_800 = 2131034179;
        public static final int material_blue_grey_900 = 2131034180;
        public static final int material_blue_grey_950 = 2131034181;
        public static final int material_deep_teal_200 = 2131034182;
        public static final int material_deep_teal_500 = 2131034183;
        public static final int material_grey_100 = 2131034184;
        public static final int material_grey_300 = 2131034185;
        public static final int material_grey_50 = 2131034186;
        public static final int material_grey_600 = 2131034187;
        public static final int material_grey_800 = 2131034188;
        public static final int material_grey_850 = 2131034189;
        public static final int material_grey_900 = 2131034190;
        public static final int notification_action_color_filter = 2131034191;
        public static final int notification_icon_bg_color = 2131034192;
        public static final int primary_dark_material_dark = 2131034193;
        public static final int primary_dark_material_light = 2131034194;
        public static final int primary_material_dark = 2131034195;
        public static final int primary_material_light = 2131034196;
        public static final int primary_text_default_material_dark = 2131034197;
        public static final int primary_text_default_material_light = 2131034198;
        public static final int primary_text_disabled_material_dark = 2131034199;
        public static final int primary_text_disabled_material_light = 2131034200;
        public static final int ripple_material_dark = 2131034201;
        public static final int ripple_material_light = 2131034202;
        public static final int secondary_text_default_material_dark = 2131034203;
        public static final int secondary_text_default_material_light = 2131034204;
        public static final int secondary_text_disabled_material_dark = 2131034205;
        public static final int secondary_text_disabled_material_light = 2131034206;
        public static final int staticSplashScreenBackgroundColor = 2131034207;
        public static final int switch_thumb_disabled_material_dark = 2131034208;
        public static final int switch_thumb_disabled_material_light = 2131034209;
        public static final int switch_thumb_material_dark = 2131034210;
        public static final int switch_thumb_material_light = 2131034211;
        public static final int switch_thumb_normal_material_dark = 2131034212;
        public static final int switch_thumb_normal_material_light = 2131034213;
        public static final int tooltip_background_dark = 2131034214;
        public static final int tooltip_background_light = 2131034215;

        private color() {
        }
    }

    /* renamed from: com.unity3d.player.R$dimen */
    public static final class dimen {
        public static final int abc_action_bar_content_inset_material = 2131099648;
        public static final int abc_action_bar_content_inset_with_nav = 2131099649;
        public static final int abc_action_bar_default_height_material = 2131099650;
        public static final int abc_action_bar_default_padding_end_material = 2131099651;
        public static final int abc_action_bar_default_padding_start_material = 2131099652;
        public static final int abc_action_bar_elevation_material = 2131099653;
        public static final int abc_action_bar_icon_vertical_padding_material = 2131099654;
        public static final int abc_action_bar_overflow_padding_end_material = 2131099655;
        public static final int abc_action_bar_overflow_padding_start_material = 2131099656;
        public static final int abc_action_bar_stacked_max_height = 2131099657;
        public static final int abc_action_bar_stacked_tab_max_width = 2131099658;
        public static final int abc_action_bar_subtitle_bottom_margin_material = 2131099659;
        public static final int abc_action_bar_subtitle_top_margin_material = 2131099660;
        public static final int abc_action_button_min_height_material = 2131099661;
        public static final int abc_action_button_min_width_material = 2131099662;
        public static final int abc_action_button_min_width_overflow_material = 2131099663;
        public static final int abc_alert_dialog_button_bar_height = 2131099664;
        public static final int abc_alert_dialog_button_dimen = 2131099665;
        public static final int abc_button_inset_horizontal_material = 2131099666;
        public static final int abc_button_inset_vertical_material = 2131099667;
        public static final int abc_button_padding_horizontal_material = 2131099668;
        public static final int abc_button_padding_vertical_material = 2131099669;
        public static final int abc_cascading_menus_min_smallest_width = 2131099670;
        public static final int abc_config_prefDialogWidth = 2131099671;
        public static final int abc_control_corner_material = 2131099672;
        public static final int abc_control_inset_material = 2131099673;
        public static final int abc_control_padding_material = 2131099674;
        public static final int abc_dialog_corner_radius_material = 2131099675;
        public static final int abc_dialog_fixed_height_major = 2131099676;
        public static final int abc_dialog_fixed_height_minor = 2131099677;
        public static final int abc_dialog_fixed_width_major = 2131099678;
        public static final int abc_dialog_fixed_width_minor = 2131099679;
        public static final int abc_dialog_list_padding_bottom_no_buttons = 2131099680;
        public static final int abc_dialog_list_padding_top_no_title = 2131099681;
        public static final int abc_dialog_min_width_major = 2131099682;
        public static final int abc_dialog_min_width_minor = 2131099683;
        public static final int abc_dialog_padding_material = 2131099684;
        public static final int abc_dialog_padding_top_material = 2131099685;
        public static final int abc_dialog_title_divider_material = 2131099686;
        public static final int abc_disabled_alpha_material_dark = 2131099687;
        public static final int abc_disabled_alpha_material_light = 2131099688;
        public static final int abc_dropdownitem_icon_width = 2131099689;
        public static final int abc_dropdownitem_text_padding_left = 2131099690;
        public static final int abc_dropdownitem_text_padding_right = 2131099691;
        public static final int abc_edit_text_inset_bottom_material = 2131099692;
        public static final int abc_edit_text_inset_horizontal_material = 2131099693;
        public static final int abc_edit_text_inset_top_material = 2131099694;
        public static final int abc_floating_window_z = 2131099695;
        public static final int abc_list_item_height_large_material = 2131099696;
        public static final int abc_list_item_height_material = 2131099697;
        public static final int abc_list_item_height_small_material = 2131099698;
        public static final int abc_list_item_padding_horizontal_material = 2131099699;
        public static final int abc_panel_menu_list_width = 2131099700;
        public static final int abc_progress_bar_height_material = 2131099701;
        public static final int abc_search_view_preferred_height = 2131099702;
        public static final int abc_search_view_preferred_width = 2131099703;
        public static final int abc_seekbar_track_background_height_material = 2131099704;
        public static final int abc_seekbar_track_progress_height_material = 2131099705;
        public static final int abc_select_dialog_padding_start_material = 2131099706;
        public static final int abc_star_big = 2131099707;
        public static final int abc_star_medium = 2131099708;
        public static final int abc_star_small = 2131099709;
        public static final int abc_switch_padding = 2131099710;
        public static final int abc_text_size_body_1_material = 2131099711;
        public static final int abc_text_size_body_2_material = 2131099712;
        public static final int abc_text_size_button_material = 2131099713;
        public static final int abc_text_size_caption_material = 2131099714;
        public static final int abc_text_size_display_1_material = 2131099715;
        public static final int abc_text_size_display_2_material = 2131099716;
        public static final int abc_text_size_display_3_material = 2131099717;
        public static final int abc_text_size_display_4_material = 2131099718;
        public static final int abc_text_size_headline_material = 2131099719;
        public static final int abc_text_size_large_material = 2131099720;
        public static final int abc_text_size_medium_material = 2131099721;
        public static final int abc_text_size_menu_header_material = 2131099722;
        public static final int abc_text_size_menu_material = 2131099723;
        public static final int abc_text_size_small_material = 2131099724;
        public static final int abc_text_size_subhead_material = 2131099725;
        public static final int abc_text_size_subtitle_material_toolbar = 2131099726;
        public static final int abc_text_size_title_material = 2131099727;
        public static final int abc_text_size_title_material_toolbar = 2131099728;
        public static final int browser_actions_context_menu_max_width = 2131099729;
        public static final int browser_actions_context_menu_min_padding = 2131099730;
        public static final int compat_button_inset_horizontal_material = 2131099731;
        public static final int compat_button_inset_vertical_material = 2131099732;
        public static final int compat_button_padding_horizontal_material = 2131099733;
        public static final int compat_button_padding_vertical_material = 2131099734;
        public static final int compat_control_corner_material = 2131099735;
        public static final int compat_notification_large_icon_max_height = 2131099736;
        public static final int compat_notification_large_icon_max_width = 2131099737;
        public static final int disabled_alpha_material_dark = 2131099738;
        public static final int disabled_alpha_material_light = 2131099739;
        public static final int highlight_alpha_material_colored = 2131099740;
        public static final int highlight_alpha_material_dark = 2131099741;
        public static final int highlight_alpha_material_light = 2131099742;
        public static final int hint_alpha_material_dark = 2131099743;
        public static final int hint_alpha_material_light = 2131099744;
        public static final int hint_pressed_alpha_material_dark = 2131099745;
        public static final int hint_pressed_alpha_material_light = 2131099746;
        public static final int notification_action_icon_size = 2131099747;
        public static final int notification_action_text_size = 2131099748;
        public static final int notification_big_circle_margin = 2131099749;
        public static final int notification_content_margin_start = 2131099750;
        public static final int notification_large_icon_height = 2131099751;
        public static final int notification_large_icon_width = 2131099752;
        public static final int notification_main_column_padding_top = 2131099753;
        public static final int notification_media_narrow_margin = 2131099754;
        public static final int notification_right_icon_size = 2131099755;
        public static final int notification_right_side_padding_top = 2131099756;
        public static final int notification_small_icon_background_padding = 2131099757;
        public static final int notification_small_icon_size_as_large = 2131099758;
        public static final int notification_subtext_size = 2131099759;
        public static final int notification_top_pad = 2131099760;
        public static final int notification_top_pad_large_text = 2131099761;
        public static final int tooltip_corner_radius = 2131099762;
        public static final int tooltip_horizontal_padding = 2131099763;
        public static final int tooltip_margin = 2131099764;
        public static final int tooltip_precise_anchor_extra_offset = 2131099765;
        public static final int tooltip_precise_anchor_threshold = 2131099766;
        public static final int tooltip_vertical_padding = 2131099767;
        public static final int tooltip_y_offset_non_touch = 2131099768;
        public static final int tooltip_y_offset_touch = 2131099769;

        private dimen() {
        }
    }

    /* renamed from: com.unity3d.player.R$drawable */
    public static final class drawable {
        public static final int abc_ab_share_pack_mtrl_alpha = 2131165184;
        public static final int abc_action_bar_item_background_material = 2131165185;
        public static final int abc_btn_borderless_material = 2131165186;
        public static final int abc_btn_check_material = 2131165187;
        public static final int abc_btn_check_material_anim = 2131165188;
        public static final int abc_btn_check_to_on_mtrl_000 = 2131165189;
        public static final int abc_btn_check_to_on_mtrl_015 = 2131165190;
        public static final int abc_btn_colored_material = 2131165191;
        public static final int abc_btn_default_mtrl_shape = 2131165192;
        public static final int abc_btn_radio_material = 2131165193;
        public static final int abc_btn_radio_material_anim = 2131165194;
        public static final int abc_btn_radio_to_on_mtrl_000 = 2131165195;
        public static final int abc_btn_radio_to_on_mtrl_015 = 2131165196;
        public static final int abc_btn_switch_to_on_mtrl_00001 = 2131165197;
        public static final int abc_btn_switch_to_on_mtrl_00012 = 2131165198;
        public static final int abc_cab_background_internal_bg = 2131165199;
        public static final int abc_cab_background_top_material = 2131165200;
        public static final int abc_cab_background_top_mtrl_alpha = 2131165201;
        public static final int abc_control_background_material = 2131165202;
        public static final int abc_dialog_material_background = 2131165203;
        public static final int abc_edit_text_material = 2131165204;
        public static final int abc_ic_ab_back_material = 2131165205;
        public static final int abc_ic_arrow_drop_right_black_24dp = 2131165206;
        public static final int abc_ic_clear_material = 2131165207;
        public static final int abc_ic_commit_search_api_mtrl_alpha = 2131165208;
        public static final int abc_ic_go_search_api_material = 2131165209;
        public static final int abc_ic_menu_copy_mtrl_am_alpha = 2131165210;
        public static final int abc_ic_menu_cut_mtrl_alpha = 2131165211;
        public static final int abc_ic_menu_overflow_material = 2131165212;
        public static final int abc_ic_menu_paste_mtrl_am_alpha = 2131165213;
        public static final int abc_ic_menu_selectall_mtrl_alpha = 2131165214;
        public static final int abc_ic_menu_share_mtrl_alpha = 2131165215;
        public static final int abc_ic_search_api_material = 2131165216;
        public static final int abc_ic_voice_search_api_material = 2131165217;
        public static final int abc_item_background_holo_dark = 2131165218;
        public static final int abc_item_background_holo_light = 2131165219;
        public static final int abc_list_divider_material = 2131165220;
        public static final int abc_list_divider_mtrl_alpha = 2131165221;
        public static final int abc_list_focused_holo = 2131165222;
        public static final int abc_list_longpressed_holo = 2131165223;
        public static final int abc_list_pressed_holo_dark = 2131165224;
        public static final int abc_list_pressed_holo_light = 2131165225;
        public static final int abc_list_selector_background_transition_holo_dark = 2131165226;
        public static final int abc_list_selector_background_transition_holo_light = 2131165227;
        public static final int abc_list_selector_disabled_holo_dark = 2131165228;
        public static final int abc_list_selector_disabled_holo_light = 2131165229;
        public static final int abc_list_selector_holo_dark = 2131165230;
        public static final int abc_list_selector_holo_light = 2131165231;
        public static final int abc_menu_hardkey_panel_mtrl_mult = 2131165232;
        public static final int abc_popup_background_mtrl_mult = 2131165233;
        public static final int abc_ratingbar_indicator_material = 2131165234;
        public static final int abc_ratingbar_material = 2131165235;
        public static final int abc_ratingbar_small_material = 2131165236;
        public static final int abc_scrubber_control_off_mtrl_alpha = 2131165237;
        public static final int abc_scrubber_control_to_pressed_mtrl_000 = 2131165238;
        public static final int abc_scrubber_control_to_pressed_mtrl_005 = 2131165239;
        public static final int abc_scrubber_primary_mtrl_alpha = 2131165240;
        public static final int abc_scrubber_track_mtrl_alpha = 2131165241;
        public static final int abc_seekbar_thumb_material = 2131165242;
        public static final int abc_seekbar_tick_mark_material = 2131165243;
        public static final int abc_seekbar_track_material = 2131165244;
        public static final int abc_spinner_mtrl_am_alpha = 2131165245;
        public static final int abc_spinner_textfield_background_material = 2131165246;
        public static final int abc_star_black_48dp = 2131165247;
        public static final int abc_star_half_black_48dp = 2131165248;
        public static final int abc_switch_thumb_material = 2131165249;
        public static final int abc_switch_track_mtrl_alpha = 2131165250;
        public static final int abc_tab_indicator_material = 2131165251;
        public static final int abc_tab_indicator_mtrl_alpha = 2131165252;
        public static final int abc_text_cursor_material = 2131165253;
        public static final int abc_text_select_handle_left_mtrl = 2131165254;
        public static final int abc_text_select_handle_middle_mtrl = 2131165255;
        public static final int abc_text_select_handle_right_mtrl = 2131165256;
        public static final int abc_textfield_activated_mtrl_alpha = 2131165257;
        public static final int abc_textfield_default_mtrl_alpha = 2131165258;
        public static final int abc_textfield_search_activated_mtrl_alpha = 2131165259;
        public static final int abc_textfield_search_default_mtrl_alpha = 2131165260;
        public static final int abc_textfield_search_material = 2131165261;
        public static final int abc_vector_test = 2131165262;
        public static final int btn_checkbox_checked_mtrl = 2131165263;
        public static final int btn_checkbox_checked_to_unchecked_mtrl_animation = 2131165264;
        public static final int btn_checkbox_unchecked_mtrl = 2131165265;
        public static final int btn_checkbox_unchecked_to_checked_mtrl_animation = 2131165266;
        public static final int btn_radio_off_mtrl = 2131165267;
        public static final int btn_radio_off_to_on_mtrl_animation = 2131165268;
        public static final int btn_radio_on_mtrl = 2131165269;
        public static final int btn_radio_on_to_off_mtrl_animation = 2131165270;
        public static final int close_24px = 2131165271;
        public static final int common_full_open_on_phone = 2131165272;
        public static final int common_google_signin_btn_icon_dark = 2131165273;
        public static final int common_google_signin_btn_icon_dark_focused = 2131165274;
        public static final int common_google_signin_btn_icon_dark_normal = 2131165275;
        public static final int common_google_signin_btn_icon_dark_normal_background = 2131165276;
        public static final int common_google_signin_btn_icon_disabled = 2131165277;
        public static final int common_google_signin_btn_icon_light = 2131165278;
        public static final int common_google_signin_btn_icon_light_focused = 2131165279;
        public static final int common_google_signin_btn_icon_light_normal = 2131165280;
        public static final int common_google_signin_btn_icon_light_normal_background = 2131165281;
        public static final int common_google_signin_btn_text_dark = 2131165282;
        public static final int common_google_signin_btn_text_dark_focused = 2131165283;
        public static final int common_google_signin_btn_text_dark_normal = 2131165284;
        public static final int common_google_signin_btn_text_dark_normal_background = 2131165285;
        public static final int common_google_signin_btn_text_disabled = 2131165286;
        public static final int common_google_signin_btn_text_light = 2131165287;
        public static final int common_google_signin_btn_text_light_focused = 2131165288;
        public static final int common_google_signin_btn_text_light_normal = 2131165289;
        public static final int common_google_signin_btn_text_light_normal_background = 2131165290;
        public static final int googleg_disabled_color_18 = 2131165291;
        public static final int googleg_standard_color_18 = 2131165292;
        public static final int notification_action_background = 2131165293;
        public static final int notification_bg = 2131165294;
        public static final int notification_bg_low = 2131165295;
        public static final int notification_bg_low_normal = 2131165296;
        public static final int notification_bg_low_pressed = 2131165297;
        public static final int notification_bg_normal = 2131165298;
        public static final int notification_bg_normal_pressed = 2131165299;
        public static final int notification_icon_background = 2131165300;
        public static final int notification_template_icon_bg = 2131165301;
        public static final int notification_template_icon_low_bg = 2131165302;
        public static final int notification_tile_bg = 2131165303;
        public static final int notify_panel_notification_icon_bg = 2131165304;
        public static final int test_level_drawable = 2131165305;
        public static final int tooltip_frame_dark = 2131165306;
        public static final int tooltip_frame_light = 2131165307;

        private drawable() {
        }
    }

    /* renamed from: com.unity3d.player.R$id */
    public static final class id {
        public static final int NO_DEBUG = 2131230724;
        public static final int SHOW_ALL = 2131230726;
        public static final int SHOW_PATH = 2131230727;
        public static final int SHOW_PROGRESS = 2131230728;
        public static final int accelerate = 2131230730;
        public static final int accessibility_action_clickable_span = 2131230731;
        public static final int accessibility_custom_action_0 = 2131230732;
        public static final int accessibility_custom_action_1 = 2131230733;
        public static final int accessibility_custom_action_10 = 2131230734;
        public static final int accessibility_custom_action_11 = 2131230735;
        public static final int accessibility_custom_action_12 = 2131230736;
        public static final int accessibility_custom_action_13 = 2131230737;
        public static final int accessibility_custom_action_14 = 2131230738;
        public static final int accessibility_custom_action_15 = 2131230739;
        public static final int accessibility_custom_action_16 = 2131230740;
        public static final int accessibility_custom_action_17 = 2131230741;
        public static final int accessibility_custom_action_18 = 2131230742;
        public static final int accessibility_custom_action_19 = 2131230743;
        public static final int accessibility_custom_action_2 = 2131230744;
        public static final int accessibility_custom_action_20 = 2131230745;
        public static final int accessibility_custom_action_21 = 2131230746;
        public static final int accessibility_custom_action_22 = 2131230747;
        public static final int accessibility_custom_action_23 = 2131230748;
        public static final int accessibility_custom_action_24 = 2131230749;
        public static final int accessibility_custom_action_25 = 2131230750;
        public static final int accessibility_custom_action_26 = 2131230751;
        public static final int accessibility_custom_action_27 = 2131230752;
        public static final int accessibility_custom_action_28 = 2131230753;
        public static final int accessibility_custom_action_29 = 2131230754;
        public static final int accessibility_custom_action_3 = 2131230755;
        public static final int accessibility_custom_action_30 = 2131230756;
        public static final int accessibility_custom_action_31 = 2131230757;
        public static final int accessibility_custom_action_4 = 2131230758;
        public static final int accessibility_custom_action_5 = 2131230759;
        public static final int accessibility_custom_action_6 = 2131230760;
        public static final int accessibility_custom_action_7 = 2131230761;
        public static final int accessibility_custom_action_8 = 2131230762;
        public static final int accessibility_custom_action_9 = 2131230763;
        public static final int actionDown = 2131230764;
        public static final int actionDownUp = 2131230765;
        public static final int actionUp = 2131230766;
        public static final int action_bar = 2131230767;
        public static final int action_bar_activity_content = 2131230768;
        public static final int action_bar_container = 2131230769;
        public static final int action_bar_root = 2131230770;
        public static final int action_bar_spinner = 2131230771;
        public static final int action_bar_subtitle = 2131230772;
        public static final int action_bar_title = 2131230773;
        public static final int action_container = 2131230774;
        public static final int action_context_bar = 2131230775;
        public static final int action_divider = 2131230776;
        public static final int action_image = 2131230777;
        public static final int action_menu_divider = 2131230778;
        public static final int action_menu_presenter = 2131230779;
        public static final int action_mode_bar = 2131230780;
        public static final int action_mode_bar_stub = 2131230781;
        public static final int action_mode_close_button = 2131230782;
        public static final int action_text = 2131230783;
        public static final int actions = 2131230784;
        public static final int activity_chooser_view_content = 2131230785;
        public static final int add = 2131230786;
        public static final int adjust_height = 2131230787;
        public static final int adjust_width = 2131230788;
        public static final int alertTitle = 2131230789;
        public static final int aligned = 2131230790;
        public static final int allStates = 2131230791;
        public static final int animateToEnd = 2131230793;
        public static final int animateToStart = 2131230794;
        public static final int antiClockwise = 2131230795;
        public static final int anticipate = 2131230796;
        public static final int asConfigured = 2131230797;
        public static final int async = 2131230798;
        public static final int auto = 2131230799;
        public static final int autoComplete = 2131230800;
        public static final int autoCompleteToEnd = 2131230801;
        public static final int autoCompleteToStart = 2131230802;
        public static final int baseline = 2131230804;
        public static final int bestChoice = 2131230807;
        public static final int blocking = 2131230808;
        public static final int bottom = 2131230809;
        public static final int bounce = 2131230810;
        public static final int browser_actions_header_text = 2131230814;
        public static final int browser_actions_menu_item_icon = 2131230815;
        public static final int browser_actions_menu_item_text = 2131230816;
        public static final int browser_actions_menu_items = 2131230817;
        public static final int browser_actions_menu_view = 2131230818;
        public static final int buttonPanel = 2131230819;
        public static final int callMeasure = 2131230821;
        public static final int carryVelocity = 2131230822;
        public static final int center = 2131230823;
        public static final int chain = 2131230825;
        public static final int chain2 = 2131230826;
        public static final int checkbox = 2131230828;
        public static final int checked = 2131230829;
        public static final int chronometer = 2131230830;
        public static final int clockwise = 2131230831;
        public static final int closest = 2131230832;
        public static final int constraint = 2131230834;
        public static final int content = 2131230835;
        public static final int contentPanel = 2131230836;
        public static final int continuousVelocity = 2131230837;
        public static final int cos = 2131230838;
        public static final int currentState = 2131230839;
        public static final int custom = 2131230840;
        public static final int customPanel = 2131230841;
        public static final int dark = 2131230842;
        public static final int decelerate = 2131230843;
        public static final int decelerateAndComplete = 2131230844;
        public static final int decor_content_parent = 2131230845;
        public static final int default_activity_button = 2131230846;
        public static final int deltaRelative = 2131230847;
        public static final int dialog_button = 2131230849;
        public static final int dragAnticlockwise = 2131230856;
        public static final int dragClockwise = 2131230857;
        public static final int dragDown = 2131230858;
        public static final int dragEnd = 2131230859;
        public static final int dragLeft = 2131230860;
        public static final int dragRight = 2131230861;
        public static final int dragStart = 2131230862;
        public static final int dragUp = 2131230863;
        public static final int easeIn = 2131230864;
        public static final int easeInOut = 2131230865;
        public static final int easeOut = 2131230866;
        public static final int east = 2131230867;
        public static final int edit_query = 2131230868;
        public static final int end = 2131230869;
        public static final int expand_activities_button = 2131230870;
        public static final int expanded_menu = 2131230871;
        public static final int flip = 2131230872;
        public static final int forever = 2131230873;
        public static final int fragment_container_view_tag = 2131230874;
        public static final int frost = 2131230875;
        public static final int gone = 2131230876;
        public static final int group_divider = 2131230879;
        public static final int home = 2131230882;
        public static final int honorRequest = 2131230884;
        public static final int horizontal_only = 2131230885;
        public static final int icon = 2131230886;
        public static final int icon_group = 2131230887;
        public static final int icon_only = 2131230888;
        public static final int ignore = 2131230890;
        public static final int ignoreRequest = 2131230891;
        public static final int image = 2131230892;
        public static final int immediateStop = 2131230893;
        public static final int included = 2131230894;
        public static final int info = 2131230895;
        public static final int invisible = 2131230896;
        public static final int italic = 2131230897;
        public static final int jumpToEnd = 2131230898;
        public static final int jumpToStart = 2131230899;
        public static final int layout = 2131230900;
        public static final int left = 2131230901;
        public static final int light = 2131230903;
        public static final int line1 = 2131230904;
        public static final int line3 = 2131230905;
        public static final int linear = 2131230906;
        public static final int listMode = 2131230907;
        public static final int list_item = 2131230908;
        public static final int match_constraint = 2131230909;
        public static final int match_parent = 2131230910;
        public static final int message = 2131230911;
        public static final int middle = 2131230912;
        public static final int motion_base = 2131230913;
        public static final int multiply = 2131230914;
        public static final int native_share_app_icon = 2131230915;
        public static final int native_share_app_name = 2131230916;
        public static final int native_share_grid_view_holder = 2131230917;
        public static final int neverCompleteToEnd = 2131230919;
        public static final int neverCompleteToStart = 2131230920;
        public static final int noState = 2131230921;
        public static final int none = 2131230922;
        public static final int normal = 2131230923;
        public static final int north = 2131230924;
        public static final int notification_background = 2131230925;
        public static final int notification_main_column = 2131230926;
        public static final int notification_main_column_container = 2131230927;
        public static final int off = 2131230928;

        /* renamed from: on */
        public static final int f510on = 2131230929;
        public static final int overshoot = 2131230931;
        public static final int packed = 2131230932;
        public static final int parent = 2131230933;
        public static final int parentPanel = 2131230934;
        public static final int parentRelative = 2131230935;
        public static final int path = 2131230936;
        public static final int pathRelative = 2131230937;
        public static final int percent = 2131230938;
        public static final int position = 2131230939;
        public static final int postLayout = 2131230940;
        public static final int progress_circular = 2131230941;
        public static final int progress_horizontal = 2131230942;
        public static final int radio = 2131230943;
        public static final int rectangles = 2131230945;
        public static final int report_drawn = 2131230946;
        public static final int reverseSawtooth = 2131230947;
        public static final int right = 2131230948;
        public static final int right_icon = 2131230949;
        public static final int right_side = 2131230950;
        public static final int sawtooth = 2131230951;
        public static final int screen = 2131230952;
        public static final int scrollIndicatorDown = 2131230953;
        public static final int scrollIndicatorUp = 2131230954;
        public static final int scrollView = 2131230955;
        public static final int search_badge = 2131230956;
        public static final int search_bar = 2131230957;
        public static final int search_button = 2131230958;
        public static final int search_close_btn = 2131230959;
        public static final int search_edit_frame = 2131230960;
        public static final int search_go_btn = 2131230961;
        public static final int search_mag_icon = 2131230962;
        public static final int search_plate = 2131230963;
        public static final int search_src_text = 2131230964;
        public static final int search_voice_btn = 2131230965;
        public static final int select_dialog_listview = 2131230966;
        public static final int sharedValueSet = 2131230967;
        public static final int sharedValueUnset = 2131230968;
        public static final int shortcut = 2131230969;
        public static final int sin = 2131230973;
        public static final int skipped = 2131230974;
        public static final int south = 2131230975;
        public static final int spacer = 2131230976;
        public static final int special_effects_controller_view_tag = 2131230977;
        public static final int spline = 2131230978;
        public static final int split_action_bar = 2131230979;
        public static final int spread = 2131230980;
        public static final int spread_inside = 2131230981;
        public static final int spring = 2131230982;
        public static final int square = 2131230983;
        public static final int src_atop = 2131230984;
        public static final int src_in = 2131230985;
        public static final int src_over = 2131230986;
        public static final int standard = 2131230987;
        public static final int start = 2131230988;
        public static final int startHorizontal = 2131230989;
        public static final int startVertical = 2131230990;
        public static final int staticLayout = 2131230991;
        public static final int staticPostLayout = 2131230992;
        public static final int stop = 2131230993;
        public static final int submenuarrow = 2131230994;
        public static final int submit_area = 2131230995;
        public static final int tabMode = 2131230997;
        public static final int tag_accessibility_actions = 2131230998;
        public static final int tag_accessibility_clickable_spans = 2131230999;
        public static final int tag_accessibility_heading = 2131231000;
        public static final int tag_accessibility_pane_title = 2131231001;
        public static final int tag_on_apply_window_listener = 2131231002;
        public static final int tag_on_receive_content_listener = 2131231003;
        public static final int tag_on_receive_content_mime_types = 2131231004;
        public static final int tag_screen_reader_focusable = 2131231005;
        public static final int tag_state_description = 2131231006;
        public static final int tag_transition_group = 2131231007;
        public static final int tag_unhandled_key_event_manager = 2131231008;
        public static final int tag_unhandled_key_listeners = 2131231009;
        public static final int tag_window_insets_animation_callback = 2131231010;
        public static final int text = 2131231011;
        public static final int text2 = 2131231012;
        public static final int textSpacerNoButtons = 2131231013;
        public static final int textSpacerNoTitle = 2131231014;
        public static final int time = 2131231015;
        public static final int title = 2131231016;
        public static final int titleDividerNoCustom = 2131231017;
        public static final int title_template = 2131231018;
        public static final int top = 2131231020;
        public static final int topPanel = 2131231021;
        public static final int triangle = 2131231024;
        public static final int unchecked = 2131231025;
        public static final int uniform = 2131231026;
        public static final int unitySurfaceView = 2131231027;

        /* renamed from: up */
        public static final int f511up = 2131231028;
        public static final int vertical_only = 2131231030;
        public static final int view_transition = 2131231031;
        public static final int view_tree_lifecycle_owner = 2131231032;
        public static final int view_tree_on_back_pressed_dispatcher_owner = 2131231033;
        public static final int view_tree_saved_state_registry_owner = 2131231034;
        public static final int view_tree_view_model_store_owner = 2131231035;
        public static final int visible = 2131231036;
        public static final int visible_removing_fragment_view_tag = 2131231037;
        public static final int west = 2131231038;
        public static final int wide = 2131231039;
        public static final int wrap = 2131231041;
        public static final int wrap_content = 2131231042;
        public static final int wrap_content_constrained = 2131231043;
        public static final int x_left = 2131231044;
        public static final int x_right = 2131231045;

        private id() {
        }
    }

    /* renamed from: com.unity3d.player.R$integer */
    public static final class integer {
        public static final int abc_config_activityDefaultDur = 2131296256;
        public static final int abc_config_activityShortDur = 2131296257;
        public static final int cancel_button_image_alpha = 2131296258;
        public static final int config_tooltipAnimTime = 2131296259;
        public static final int google_play_services_version = 2131296260;
        public static final int status_bar_notification_info_maxnum = 2131296261;

        private integer() {
        }
    }

    /* renamed from: com.unity3d.player.R$interpolator */
    public static final class interpolator {
        public static final int btn_checkbox_checked_mtrl_animation_interpolator_0 = 2131361792;
        public static final int btn_checkbox_checked_mtrl_animation_interpolator_1 = 2131361793;
        public static final int btn_checkbox_unchecked_mtrl_animation_interpolator_0 = 2131361794;
        public static final int btn_checkbox_unchecked_mtrl_animation_interpolator_1 = 2131361795;
        public static final int btn_radio_to_off_mtrl_animation_interpolator_0 = 2131361796;
        public static final int btn_radio_to_on_mtrl_animation_interpolator_0 = 2131361797;
        public static final int fast_out_slow_in = 2131361798;

        private interpolator() {
        }
    }

    /* renamed from: com.unity3d.player.R$layout */
    public static final class layout {
        public static final int abc_action_bar_title_item = 2131427328;
        public static final int abc_action_bar_up_container = 2131427329;
        public static final int abc_action_menu_item_layout = 2131427330;
        public static final int abc_action_menu_layout = 2131427331;
        public static final int abc_action_mode_bar = 2131427332;
        public static final int abc_action_mode_close_item_material = 2131427333;
        public static final int abc_activity_chooser_view = 2131427334;
        public static final int abc_activity_chooser_view_list_item = 2131427335;
        public static final int abc_alert_dialog_button_bar_material = 2131427336;
        public static final int abc_alert_dialog_material = 2131427337;
        public static final int abc_alert_dialog_title_material = 2131427338;
        public static final int abc_cascading_menu_item_layout = 2131427339;
        public static final int abc_dialog_title_material = 2131427340;
        public static final int abc_expanded_menu_layout = 2131427341;
        public static final int abc_list_menu_item_checkbox = 2131427342;
        public static final int abc_list_menu_item_icon = 2131427343;
        public static final int abc_list_menu_item_layout = 2131427344;
        public static final int abc_list_menu_item_radio = 2131427345;
        public static final int abc_popup_menu_header_item_layout = 2131427346;
        public static final int abc_popup_menu_item_layout = 2131427347;
        public static final int abc_screen_content_include = 2131427348;
        public static final int abc_screen_simple = 2131427349;
        public static final int abc_screen_simple_overlay_action_mode = 2131427350;
        public static final int abc_screen_toolbar = 2131427351;
        public static final int abc_search_dropdown_item_icons_2line = 2131427352;
        public static final int abc_search_view = 2131427353;
        public static final int abc_select_dialog_material = 2131427354;
        public static final int abc_tooltip = 2131427355;
        public static final int browser_actions_context_menu_page = 2131427356;
        public static final int browser_actions_context_menu_row = 2131427357;
        public static final int custom_dialog = 2131427358;
        public static final int native_share_custom_dialog_holder = 2131427359;
        public static final int native_share_grid_element = 2131427360;
        public static final int native_share_grid_view = 2131427361;
        public static final int notification_action = 2131427362;
        public static final int notification_action_tombstone = 2131427363;
        public static final int notification_template_custom_big = 2131427364;
        public static final int notification_template_icon_group = 2131427365;
        public static final int notification_template_part_chronometer = 2131427366;
        public static final int notification_template_part_time = 2131427367;
        public static final int select_dialog_item_material = 2131427368;
        public static final int select_dialog_multichoice_material = 2131427369;
        public static final int select_dialog_singlechoice_material = 2131427370;
        public static final int support_simple_spinner_dropdown_item = 2131427371;

        private layout() {
        }
    }

    /* renamed from: com.unity3d.player.R$raw */
    public static final class raw {
        public static final int keep_cronet_api = 2131558400;

        private raw() {
        }
    }

    /* renamed from: com.unity3d.player.R$string */
    public static final class string {
        public static final int CronetProviderClassName = 2131623936;
        public static final int FreeformWindowOrientation_landscape = 2131623937;
        public static final int FreeformWindowOrientation_portrait = 2131623938;
        public static final int FreeformWindowSize_maximize = 2131623939;
        public static final int FreeformWindowSize_phone = 2131623940;
        public static final int FreeformWindowSize_tablet = 2131623941;
        public static final int abc_action_bar_home_description = 2131623942;
        public static final int abc_action_bar_up_description = 2131623943;
        public static final int abc_action_menu_overflow_description = 2131623944;
        public static final int abc_action_mode_done = 2131623945;
        public static final int abc_activity_chooser_view_see_all = 2131623946;
        public static final int abc_activitychooserview_choose_application = 2131623947;
        public static final int abc_capital_off = 2131623948;
        public static final int abc_capital_on = 2131623949;
        public static final int abc_menu_alt_shortcut_label = 2131623950;
        public static final int abc_menu_ctrl_shortcut_label = 2131623951;
        public static final int abc_menu_delete_shortcut_label = 2131623952;
        public static final int abc_menu_enter_shortcut_label = 2131623953;
        public static final int abc_menu_function_shortcut_label = 2131623954;
        public static final int abc_menu_meta_shortcut_label = 2131623955;
        public static final int abc_menu_shift_shortcut_label = 2131623956;
        public static final int abc_menu_space_shortcut_label = 2131623957;
        public static final int abc_menu_sym_shortcut_label = 2131623958;
        public static final int abc_prepend_shortcut_label = 2131623959;
        public static final int abc_search_hint = 2131623960;
        public static final int abc_searchview_description_clear = 2131623961;
        public static final int abc_searchview_description_query = 2131623962;
        public static final int abc_searchview_description_search = 2131623963;
        public static final int abc_searchview_description_submit = 2131623964;
        public static final int abc_searchview_description_voice = 2131623965;
        public static final int abc_shareactionprovider_share_with = 2131623966;
        public static final int abc_shareactionprovider_share_with_application = 2131623967;
        public static final int abc_toolbar_collapse_description = 2131623968;
        public static final int androidx_startup = 2131623969;
        public static final int app_name = 2131623970;
        public static final int common_google_play_services_enable_button = 2131623971;
        public static final int common_google_play_services_enable_text = 2131623972;
        public static final int common_google_play_services_enable_title = 2131623973;
        public static final int common_google_play_services_install_button = 2131623974;
        public static final int common_google_play_services_install_text = 2131623975;
        public static final int common_google_play_services_install_title = 2131623976;
        public static final int common_google_play_services_notification_channel_name = 2131623977;
        public static final int common_google_play_services_notification_ticker = 2131623978;
        public static final int common_google_play_services_unknown_issue = 2131623979;
        public static final int common_google_play_services_unsupported_text = 2131623980;
        public static final int common_google_play_services_update_button = 2131623981;
        public static final int common_google_play_services_update_text = 2131623982;
        public static final int common_google_play_services_update_title = 2131623983;
        public static final int common_google_play_services_updating_text = 2131623984;
        public static final int common_google_play_services_wear_update_text = 2131623985;
        public static final int common_open_on_phone = 2131623986;
        public static final int common_signin_button_text = 2131623987;
        public static final int common_signin_button_text_long = 2131623988;
        public static final int copy_toast_msg = 2131623989;
        public static final int eos_login_protocol_scheme = 2131623990;
        public static final int fallback_menu_item_copy_link = 2131623991;
        public static final int fallback_menu_item_open_in_browser = 2131623992;
        public static final int fallback_menu_item_share_link = 2131623993;
        public static final int search_menu_title = 2131623995;
        public static final int status_bar_notification_info_overflow = 2131623996;

        private string() {
        }
    }

    /* renamed from: com.unity3d.player.R$style */
    public static final class style {
        public static final int AlertDialog_AppCompat = 2131689472;
        public static final int AlertDialog_AppCompat_Light = 2131689473;
        public static final int Animation_AppCompat_Dialog = 2131689474;
        public static final int Animation_AppCompat_DropDownUp = 2131689475;
        public static final int Animation_AppCompat_Tooltip = 2131689476;
        public static final int BaseUnityTheme = 2131689633;
        public static final int Base_AlertDialog_AppCompat = 2131689477;
        public static final int Base_AlertDialog_AppCompat_Light = 2131689478;
        public static final int Base_Animation_AppCompat_Dialog = 2131689479;
        public static final int Base_Animation_AppCompat_DropDownUp = 2131689480;
        public static final int Base_Animation_AppCompat_Tooltip = 2131689481;
        public static final int Base_DialogWindowTitleBackground_AppCompat = 2131689483;
        public static final int Base_DialogWindowTitle_AppCompat = 2131689482;
        public static final int Base_TextAppearance_AppCompat = 2131689484;
        public static final int Base_TextAppearance_AppCompat_Body1 = 2131689485;
        public static final int Base_TextAppearance_AppCompat_Body2 = 2131689486;
        public static final int Base_TextAppearance_AppCompat_Button = 2131689487;
        public static final int Base_TextAppearance_AppCompat_Caption = 2131689488;
        public static final int Base_TextAppearance_AppCompat_Display1 = 2131689489;
        public static final int Base_TextAppearance_AppCompat_Display2 = 2131689490;
        public static final int Base_TextAppearance_AppCompat_Display3 = 2131689491;
        public static final int Base_TextAppearance_AppCompat_Display4 = 2131689492;
        public static final int Base_TextAppearance_AppCompat_Headline = 2131689493;
        public static final int Base_TextAppearance_AppCompat_Inverse = 2131689494;
        public static final int Base_TextAppearance_AppCompat_Large = 2131689495;
        public static final int Base_TextAppearance_AppCompat_Large_Inverse = 2131689496;
        public static final int Base_TextAppearance_AppCompat_Light_Widget_PopupMenu_Large = 2131689497;
        public static final int Base_TextAppearance_AppCompat_Light_Widget_PopupMenu_Small = 2131689498;
        public static final int Base_TextAppearance_AppCompat_Medium = 2131689499;
        public static final int Base_TextAppearance_AppCompat_Medium_Inverse = 2131689500;
        public static final int Base_TextAppearance_AppCompat_Menu = 2131689501;
        public static final int Base_TextAppearance_AppCompat_SearchResult = 2131689502;
        public static final int Base_TextAppearance_AppCompat_SearchResult_Subtitle = 2131689503;
        public static final int Base_TextAppearance_AppCompat_SearchResult_Title = 2131689504;
        public static final int Base_TextAppearance_AppCompat_Small = 2131689505;
        public static final int Base_TextAppearance_AppCompat_Small_Inverse = 2131689506;
        public static final int Base_TextAppearance_AppCompat_Subhead = 2131689507;
        public static final int Base_TextAppearance_AppCompat_Subhead_Inverse = 2131689508;
        public static final int Base_TextAppearance_AppCompat_Title = 2131689509;
        public static final int Base_TextAppearance_AppCompat_Title_Inverse = 2131689510;
        public static final int Base_TextAppearance_AppCompat_Tooltip = 2131689511;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Menu = 2131689512;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Subtitle = 2131689513;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Subtitle_Inverse = 2131689514;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Title = 2131689515;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Title_Inverse = 2131689516;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionMode_Subtitle = 2131689517;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionMode_Title = 2131689518;
        public static final int Base_TextAppearance_AppCompat_Widget_Button = 2131689519;
        public static final int Base_TextAppearance_AppCompat_Widget_Button_Borderless_Colored = 2131689520;
        public static final int Base_TextAppearance_AppCompat_Widget_Button_Colored = 2131689521;
        public static final int Base_TextAppearance_AppCompat_Widget_Button_Inverse = 2131689522;
        public static final int Base_TextAppearance_AppCompat_Widget_DropDownItem = 2131689523;
        public static final int Base_TextAppearance_AppCompat_Widget_PopupMenu_Header = 2131689524;
        public static final int Base_TextAppearance_AppCompat_Widget_PopupMenu_Large = 2131689525;
        public static final int Base_TextAppearance_AppCompat_Widget_PopupMenu_Small = 2131689526;
        public static final int Base_TextAppearance_AppCompat_Widget_Switch = 2131689527;
        public static final int Base_TextAppearance_AppCompat_Widget_TextView_SpinnerItem = 2131689528;
        public static final int Base_TextAppearance_Widget_AppCompat_ExpandedMenu_Item = 2131689529;
        public static final int Base_TextAppearance_Widget_AppCompat_Toolbar_Subtitle = 2131689530;
        public static final int Base_TextAppearance_Widget_AppCompat_Toolbar_Title = 2131689531;
        public static final int Base_ThemeOverlay_AppCompat = 2131689546;
        public static final int Base_ThemeOverlay_AppCompat_ActionBar = 2131689547;
        public static final int Base_ThemeOverlay_AppCompat_Dark = 2131689548;
        public static final int Base_ThemeOverlay_AppCompat_Dark_ActionBar = 2131689549;
        public static final int Base_ThemeOverlay_AppCompat_Dialog = 2131689550;
        public static final int Base_ThemeOverlay_AppCompat_Dialog_Alert = 2131689551;
        public static final int Base_ThemeOverlay_AppCompat_Light = 2131689552;
        public static final int Base_Theme_AppCompat = 2131689532;
        public static final int Base_Theme_AppCompat_CompactMenu = 2131689533;
        public static final int Base_Theme_AppCompat_Dialog = 2131689534;
        public static final int Base_Theme_AppCompat_DialogWhenLarge = 2131689538;
        public static final int Base_Theme_AppCompat_Dialog_Alert = 2131689535;
        public static final int Base_Theme_AppCompat_Dialog_FixedSize = 2131689536;
        public static final int Base_Theme_AppCompat_Dialog_MinWidth = 2131689537;
        public static final int Base_Theme_AppCompat_Light = 2131689539;
        public static final int Base_Theme_AppCompat_Light_DarkActionBar = 2131689540;
        public static final int Base_Theme_AppCompat_Light_Dialog = 2131689541;
        public static final int Base_Theme_AppCompat_Light_DialogWhenLarge = 2131689545;
        public static final int Base_Theme_AppCompat_Light_Dialog_Alert = 2131689542;
        public static final int Base_Theme_AppCompat_Light_Dialog_FixedSize = 2131689543;
        public static final int Base_Theme_AppCompat_Light_Dialog_MinWidth = 2131689544;
        public static final int Base_V21_ThemeOverlay_AppCompat_Dialog = 2131689557;
        public static final int Base_V21_Theme_AppCompat = 2131689553;
        public static final int Base_V21_Theme_AppCompat_Dialog = 2131689554;
        public static final int Base_V21_Theme_AppCompat_Light = 2131689555;
        public static final int Base_V21_Theme_AppCompat_Light_Dialog = 2131689556;
        public static final int Base_V22_Theme_AppCompat = 2131689558;
        public static final int Base_V22_Theme_AppCompat_Light = 2131689559;
        public static final int Base_V23_Theme_AppCompat = 2131689560;
        public static final int Base_V23_Theme_AppCompat_Light = 2131689561;
        public static final int Base_V26_Theme_AppCompat = 2131689562;
        public static final int Base_V26_Theme_AppCompat_Light = 2131689563;
        public static final int Base_V26_Widget_AppCompat_Toolbar = 2131689564;
        public static final int Base_V28_Theme_AppCompat = 2131689565;
        public static final int Base_V28_Theme_AppCompat_Light = 2131689566;
        public static final int Base_V7_ThemeOverlay_AppCompat_Dialog = 2131689571;
        public static final int Base_V7_Theme_AppCompat = 2131689567;
        public static final int Base_V7_Theme_AppCompat_Dialog = 2131689568;
        public static final int Base_V7_Theme_AppCompat_Light = 2131689569;
        public static final int Base_V7_Theme_AppCompat_Light_Dialog = 2131689570;
        public static final int Base_V7_Widget_AppCompat_AutoCompleteTextView = 2131689572;
        public static final int Base_V7_Widget_AppCompat_EditText = 2131689573;
        public static final int Base_V7_Widget_AppCompat_Toolbar = 2131689574;
        public static final int Base_Widget_AppCompat_ActionBar = 2131689575;
        public static final int Base_Widget_AppCompat_ActionBar_Solid = 2131689576;
        public static final int Base_Widget_AppCompat_ActionBar_TabBar = 2131689577;
        public static final int Base_Widget_AppCompat_ActionBar_TabText = 2131689578;
        public static final int Base_Widget_AppCompat_ActionBar_TabView = 2131689579;
        public static final int Base_Widget_AppCompat_ActionButton = 2131689580;
        public static final int Base_Widget_AppCompat_ActionButton_CloseMode = 2131689581;
        public static final int Base_Widget_AppCompat_ActionButton_Overflow = 2131689582;
        public static final int Base_Widget_AppCompat_ActionMode = 2131689583;
        public static final int Base_Widget_AppCompat_ActivityChooserView = 2131689584;
        public static final int Base_Widget_AppCompat_AutoCompleteTextView = 2131689585;
        public static final int Base_Widget_AppCompat_Button = 2131689586;
        public static final int Base_Widget_AppCompat_ButtonBar = 2131689592;
        public static final int Base_Widget_AppCompat_ButtonBar_AlertDialog = 2131689593;
        public static final int Base_Widget_AppCompat_Button_Borderless = 2131689587;
        public static final int Base_Widget_AppCompat_Button_Borderless_Colored = 2131689588;
        public static final int Base_Widget_AppCompat_Button_ButtonBar_AlertDialog = 2131689589;
        public static final int Base_Widget_AppCompat_Button_Colored = 2131689590;
        public static final int Base_Widget_AppCompat_Button_Small = 2131689591;
        public static final int Base_Widget_AppCompat_CompoundButton_CheckBox = 2131689594;
        public static final int Base_Widget_AppCompat_CompoundButton_RadioButton = 2131689595;
        public static final int Base_Widget_AppCompat_CompoundButton_Switch = 2131689596;
        public static final int Base_Widget_AppCompat_DrawerArrowToggle = 2131689597;
        public static final int Base_Widget_AppCompat_DrawerArrowToggle_Common = 2131689598;
        public static final int Base_Widget_AppCompat_DropDownItem_Spinner = 2131689599;
        public static final int Base_Widget_AppCompat_EditText = 2131689600;
        public static final int Base_Widget_AppCompat_ImageButton = 2131689601;
        public static final int Base_Widget_AppCompat_Light_ActionBar = 2131689602;
        public static final int Base_Widget_AppCompat_Light_ActionBar_Solid = 2131689603;
        public static final int Base_Widget_AppCompat_Light_ActionBar_TabBar = 2131689604;
        public static final int Base_Widget_AppCompat_Light_ActionBar_TabText = 2131689605;
        public static final int Base_Widget_AppCompat_Light_ActionBar_TabText_Inverse = 2131689606;
        public static final int Base_Widget_AppCompat_Light_ActionBar_TabView = 2131689607;
        public static final int Base_Widget_AppCompat_Light_PopupMenu = 2131689608;
        public static final int Base_Widget_AppCompat_Light_PopupMenu_Overflow = 2131689609;
        public static final int Base_Widget_AppCompat_ListMenuView = 2131689610;
        public static final int Base_Widget_AppCompat_ListPopupWindow = 2131689611;
        public static final int Base_Widget_AppCompat_ListView = 2131689612;
        public static final int Base_Widget_AppCompat_ListView_DropDown = 2131689613;
        public static final int Base_Widget_AppCompat_ListView_Menu = 2131689614;
        public static final int Base_Widget_AppCompat_PopupMenu = 2131689615;
        public static final int Base_Widget_AppCompat_PopupMenu_Overflow = 2131689616;
        public static final int Base_Widget_AppCompat_PopupWindow = 2131689617;
        public static final int Base_Widget_AppCompat_ProgressBar = 2131689618;
        public static final int Base_Widget_AppCompat_ProgressBar_Horizontal = 2131689619;
        public static final int Base_Widget_AppCompat_RatingBar = 2131689620;
        public static final int Base_Widget_AppCompat_RatingBar_Indicator = 2131689621;
        public static final int Base_Widget_AppCompat_RatingBar_Small = 2131689622;
        public static final int Base_Widget_AppCompat_SearchView = 2131689623;
        public static final int Base_Widget_AppCompat_SearchView_ActionBar = 2131689624;
        public static final int Base_Widget_AppCompat_SeekBar = 2131689625;
        public static final int Base_Widget_AppCompat_SeekBar_Discrete = 2131689626;
        public static final int Base_Widget_AppCompat_Spinner = 2131689627;
        public static final int Base_Widget_AppCompat_Spinner_Underlined = 2131689628;
        public static final int Base_Widget_AppCompat_TextView = 2131689629;
        public static final int Base_Widget_AppCompat_TextView_SpinnerItem = 2131689630;
        public static final int Base_Widget_AppCompat_Toolbar = 2131689631;
        public static final int Base_Widget_AppCompat_Toolbar_Button_Navigation = 2131689632;
        public static final int Platform_AppCompat = 2131689634;
        public static final int Platform_AppCompat_Light = 2131689635;
        public static final int Platform_ThemeOverlay_AppCompat = 2131689636;
        public static final int Platform_ThemeOverlay_AppCompat_Dark = 2131689637;
        public static final int Platform_ThemeOverlay_AppCompat_Light = 2131689638;
        public static final int Platform_V21_AppCompat = 2131689639;
        public static final int Platform_V21_AppCompat_Light = 2131689640;
        public static final int Platform_V25_AppCompat = 2131689641;
        public static final int Platform_V25_AppCompat_Light = 2131689642;
        public static final int Platform_Widget_AppCompat_Spinner = 2131689643;
        public static final int RtlOverlay_DialogWindowTitle_AppCompat = 2131689644;
        public static final int RtlOverlay_Widget_AppCompat_ActionBar_TitleItem = 2131689645;
        public static final int RtlOverlay_Widget_AppCompat_DialogTitle_Icon = 2131689646;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem = 2131689647;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem_InternalGroup = 2131689648;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem_Shortcut = 2131689649;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem_SubmenuArrow = 2131689650;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem_Text = 2131689651;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem_Title = 2131689652;
        public static final int RtlOverlay_Widget_AppCompat_SearchView_MagIcon = 2131689658;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown = 2131689653;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown_Icon1 = 2131689654;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown_Icon2 = 2131689655;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown_Query = 2131689656;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown_Text = 2131689657;
        public static final int RtlUnderlay_Widget_AppCompat_ActionButton = 2131689659;
        public static final int RtlUnderlay_Widget_AppCompat_ActionButton_Overflow = 2131689660;
        public static final int TextAppearance_AppCompat = 2131689661;
        public static final int TextAppearance_AppCompat_Body1 = 2131689662;
        public static final int TextAppearance_AppCompat_Body2 = 2131689663;
        public static final int TextAppearance_AppCompat_Button = 2131689664;
        public static final int TextAppearance_AppCompat_Caption = 2131689665;
        public static final int TextAppearance_AppCompat_Display1 = 2131689666;
        public static final int TextAppearance_AppCompat_Display2 = 2131689667;
        public static final int TextAppearance_AppCompat_Display3 = 2131689668;
        public static final int TextAppearance_AppCompat_Display4 = 2131689669;
        public static final int TextAppearance_AppCompat_Headline = 2131689670;
        public static final int TextAppearance_AppCompat_Inverse = 2131689671;
        public static final int TextAppearance_AppCompat_Large = 2131689672;
        public static final int TextAppearance_AppCompat_Large_Inverse = 2131689673;
        public static final int TextAppearance_AppCompat_Light_SearchResult_Subtitle = 2131689674;
        public static final int TextAppearance_AppCompat_Light_SearchResult_Title = 2131689675;
        public static final int TextAppearance_AppCompat_Light_Widget_PopupMenu_Large = 2131689676;
        public static final int TextAppearance_AppCompat_Light_Widget_PopupMenu_Small = 2131689677;
        public static final int TextAppearance_AppCompat_Medium = 2131689678;
        public static final int TextAppearance_AppCompat_Medium_Inverse = 2131689679;
        public static final int TextAppearance_AppCompat_Menu = 2131689680;
        public static final int TextAppearance_AppCompat_SearchResult_Subtitle = 2131689681;
        public static final int TextAppearance_AppCompat_SearchResult_Title = 2131689682;
        public static final int TextAppearance_AppCompat_Small = 2131689683;
        public static final int TextAppearance_AppCompat_Small_Inverse = 2131689684;
        public static final int TextAppearance_AppCompat_Subhead = 2131689685;
        public static final int TextAppearance_AppCompat_Subhead_Inverse = 2131689686;
        public static final int TextAppearance_AppCompat_Title = 2131689687;
        public static final int TextAppearance_AppCompat_Title_Inverse = 2131689688;
        public static final int TextAppearance_AppCompat_Tooltip = 2131689689;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Menu = 2131689690;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Subtitle = 2131689691;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Subtitle_Inverse = 2131689692;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Title = 2131689693;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Title_Inverse = 2131689694;
        public static final int TextAppearance_AppCompat_Widget_ActionMode_Subtitle = 2131689695;
        public static final int TextAppearance_AppCompat_Widget_ActionMode_Subtitle_Inverse = 2131689696;
        public static final int TextAppearance_AppCompat_Widget_ActionMode_Title = 2131689697;
        public static final int TextAppearance_AppCompat_Widget_ActionMode_Title_Inverse = 2131689698;
        public static final int TextAppearance_AppCompat_Widget_Button = 2131689699;
        public static final int TextAppearance_AppCompat_Widget_Button_Borderless_Colored = 2131689700;
        public static final int TextAppearance_AppCompat_Widget_Button_Colored = 2131689701;
        public static final int TextAppearance_AppCompat_Widget_Button_Inverse = 2131689702;
        public static final int TextAppearance_AppCompat_Widget_DropDownItem = 2131689703;
        public static final int TextAppearance_AppCompat_Widget_PopupMenu_Header = 2131689704;
        public static final int TextAppearance_AppCompat_Widget_PopupMenu_Large = 2131689705;
        public static final int TextAppearance_AppCompat_Widget_PopupMenu_Small = 2131689706;
        public static final int TextAppearance_AppCompat_Widget_Switch = 2131689707;
        public static final int TextAppearance_AppCompat_Widget_TextView_SpinnerItem = 2131689708;
        public static final int TextAppearance_Compat_Notification = 2131689709;
        public static final int TextAppearance_Compat_Notification_Info = 2131689710;
        public static final int TextAppearance_Compat_Notification_Line2 = 2131689711;
        public static final int TextAppearance_Compat_Notification_Time = 2131689712;
        public static final int TextAppearance_Compat_Notification_Title = 2131689713;
        public static final int TextAppearance_Widget_AppCompat_ExpandedMenu_Item = 2131689714;
        public static final int TextAppearance_Widget_AppCompat_Toolbar_Subtitle = 2131689715;
        public static final int TextAppearance_Widget_AppCompat_Toolbar_Title = 2131689716;
        public static final int ThemeOverlay_AppCompat = 2131689741;
        public static final int ThemeOverlay_AppCompat_ActionBar = 2131689742;
        public static final int ThemeOverlay_AppCompat_Dark = 2131689743;
        public static final int ThemeOverlay_AppCompat_Dark_ActionBar = 2131689744;
        public static final int ThemeOverlay_AppCompat_DayNight = 2131689745;
        public static final int ThemeOverlay_AppCompat_DayNight_ActionBar = 2131689746;
        public static final int ThemeOverlay_AppCompat_Dialog = 2131689747;
        public static final int ThemeOverlay_AppCompat_Dialog_Alert = 2131689748;
        public static final int ThemeOverlay_AppCompat_Light = 2131689749;
        public static final int Theme_AppCompat = 2131689717;
        public static final int Theme_AppCompat_CompactMenu = 2131689718;
        public static final int Theme_AppCompat_DayNight = 2131689719;
        public static final int Theme_AppCompat_DayNight_DarkActionBar = 2131689720;
        public static final int Theme_AppCompat_DayNight_Dialog = 2131689721;
        public static final int Theme_AppCompat_DayNight_DialogWhenLarge = 2131689724;
        public static final int Theme_AppCompat_DayNight_Dialog_Alert = 2131689722;
        public static final int Theme_AppCompat_DayNight_Dialog_MinWidth = 2131689723;
        public static final int Theme_AppCompat_DayNight_NoActionBar = 2131689725;
        public static final int Theme_AppCompat_Dialog = 2131689726;
        public static final int Theme_AppCompat_DialogWhenLarge = 2131689729;
        public static final int Theme_AppCompat_Dialog_Alert = 2131689727;
        public static final int Theme_AppCompat_Dialog_MinWidth = 2131689728;
        public static final int Theme_AppCompat_Empty = 2131689730;
        public static final int Theme_AppCompat_Light = 2131689731;
        public static final int Theme_AppCompat_Light_DarkActionBar = 2131689732;
        public static final int Theme_AppCompat_Light_Dialog = 2131689733;
        public static final int Theme_AppCompat_Light_DialogWhenLarge = 2131689736;
        public static final int Theme_AppCompat_Light_Dialog_Alert = 2131689734;
        public static final int Theme_AppCompat_Light_Dialog_MinWidth = 2131689735;
        public static final int Theme_AppCompat_Light_NoActionBar = 2131689737;
        public static final int Theme_AppCompat_Light_NoActionBar_FullScreen = 2131689738;
        public static final int Theme_AppCompat_NoActionBar = 2131689739;
        public static final int Theme_NativeShareTransparent = 2131689740;
        public static final int UnityThemeSelector = 2131689750;
        public static final int UnityThemeSelector_Translucent = 2131689751;
        public static final int Widget_AppCompat_ActionBar = 2131689752;
        public static final int Widget_AppCompat_ActionBar_Solid = 2131689753;
        public static final int Widget_AppCompat_ActionBar_TabBar = 2131689754;
        public static final int Widget_AppCompat_ActionBar_TabText = 2131689755;
        public static final int Widget_AppCompat_ActionBar_TabView = 2131689756;
        public static final int Widget_AppCompat_ActionButton = 2131689757;
        public static final int Widget_AppCompat_ActionButton_CloseMode = 2131689758;
        public static final int Widget_AppCompat_ActionButton_Overflow = 2131689759;
        public static final int Widget_AppCompat_ActionMode = 2131689760;
        public static final int Widget_AppCompat_ActivityChooserView = 2131689761;
        public static final int Widget_AppCompat_AutoCompleteTextView = 2131689762;
        public static final int Widget_AppCompat_Button = 2131689763;
        public static final int Widget_AppCompat_ButtonBar = 2131689769;
        public static final int Widget_AppCompat_ButtonBar_AlertDialog = 2131689770;
        public static final int Widget_AppCompat_Button_Borderless = 2131689764;
        public static final int Widget_AppCompat_Button_Borderless_Colored = 2131689765;
        public static final int Widget_AppCompat_Button_ButtonBar_AlertDialog = 2131689766;
        public static final int Widget_AppCompat_Button_Colored = 2131689767;
        public static final int Widget_AppCompat_Button_Small = 2131689768;
        public static final int Widget_AppCompat_CompoundButton_CheckBox = 2131689771;
        public static final int Widget_AppCompat_CompoundButton_RadioButton = 2131689772;
        public static final int Widget_AppCompat_CompoundButton_Switch = 2131689773;
        public static final int Widget_AppCompat_DrawerArrowToggle = 2131689774;
        public static final int Widget_AppCompat_DropDownItem_Spinner = 2131689775;
        public static final int Widget_AppCompat_EditText = 2131689776;
        public static final int Widget_AppCompat_ImageButton = 2131689777;
        public static final int Widget_AppCompat_Light_ActionBar = 2131689778;
        public static final int Widget_AppCompat_Light_ActionBar_Solid = 2131689779;
        public static final int Widget_AppCompat_Light_ActionBar_Solid_Inverse = 2131689780;
        public static final int Widget_AppCompat_Light_ActionBar_TabBar = 2131689781;
        public static final int Widget_AppCompat_Light_ActionBar_TabBar_Inverse = 2131689782;
        public static final int Widget_AppCompat_Light_ActionBar_TabText = 2131689783;
        public static final int Widget_AppCompat_Light_ActionBar_TabText_Inverse = 2131689784;
        public static final int Widget_AppCompat_Light_ActionBar_TabView = 2131689785;
        public static final int Widget_AppCompat_Light_ActionBar_TabView_Inverse = 2131689786;
        public static final int Widget_AppCompat_Light_ActionButton = 2131689787;
        public static final int Widget_AppCompat_Light_ActionButton_CloseMode = 2131689788;
        public static final int Widget_AppCompat_Light_ActionButton_Overflow = 2131689789;
        public static final int Widget_AppCompat_Light_ActionMode_Inverse = 2131689790;
        public static final int Widget_AppCompat_Light_ActivityChooserView = 2131689791;
        public static final int Widget_AppCompat_Light_AutoCompleteTextView = 2131689792;
        public static final int Widget_AppCompat_Light_DropDownItem_Spinner = 2131689793;
        public static final int Widget_AppCompat_Light_ListPopupWindow = 2131689794;
        public static final int Widget_AppCompat_Light_ListView_DropDown = 2131689795;
        public static final int Widget_AppCompat_Light_PopupMenu = 2131689796;
        public static final int Widget_AppCompat_Light_PopupMenu_Overflow = 2131689797;
        public static final int Widget_AppCompat_Light_SearchView = 2131689798;
        public static final int Widget_AppCompat_Light_Spinner_DropDown_ActionBar = 2131689799;
        public static final int Widget_AppCompat_ListMenuView = 2131689800;
        public static final int Widget_AppCompat_ListPopupWindow = 2131689801;
        public static final int Widget_AppCompat_ListView = 2131689802;
        public static final int Widget_AppCompat_ListView_DropDown = 2131689803;
        public static final int Widget_AppCompat_ListView_Menu = 2131689804;
        public static final int Widget_AppCompat_PopupMenu = 2131689805;
        public static final int Widget_AppCompat_PopupMenu_Overflow = 2131689806;
        public static final int Widget_AppCompat_PopupWindow = 2131689807;
        public static final int Widget_AppCompat_ProgressBar = 2131689808;
        public static final int Widget_AppCompat_ProgressBar_Horizontal = 2131689809;
        public static final int Widget_AppCompat_RatingBar = 2131689810;
        public static final int Widget_AppCompat_RatingBar_Indicator = 2131689811;
        public static final int Widget_AppCompat_RatingBar_Small = 2131689812;
        public static final int Widget_AppCompat_SearchView = 2131689813;
        public static final int Widget_AppCompat_SearchView_ActionBar = 2131689814;
        public static final int Widget_AppCompat_SeekBar = 2131689815;
        public static final int Widget_AppCompat_SeekBar_Discrete = 2131689816;
        public static final int Widget_AppCompat_Spinner = 2131689817;
        public static final int Widget_AppCompat_Spinner_DropDown = 2131689818;
        public static final int Widget_AppCompat_Spinner_DropDown_ActionBar = 2131689819;
        public static final int Widget_AppCompat_Spinner_Underlined = 2131689820;
        public static final int Widget_AppCompat_TextView = 2131689821;
        public static final int Widget_AppCompat_TextView_SpinnerItem = 2131689822;
        public static final int Widget_AppCompat_Toolbar = 2131689823;
        public static final int Widget_AppCompat_Toolbar_Button_Navigation = 2131689824;
        public static final int Widget_Compat_NotificationActionContainer = 2131689825;
        public static final int Widget_Compat_NotificationActionText = 2131689826;

        private style() {
        }
    }

    /* renamed from: com.unity3d.player.R$styleable */
    public static final class styleable {
        public static final int ActionBarLayout_android_layout_gravity = 0;
        public static final int ActionBar_background = 0;
        public static final int ActionBar_backgroundSplit = 1;
        public static final int ActionBar_backgroundStacked = 2;
        public static final int ActionBar_contentInsetEnd = 3;
        public static final int ActionBar_contentInsetEndWithActions = 4;
        public static final int ActionBar_contentInsetLeft = 5;
        public static final int ActionBar_contentInsetRight = 6;
        public static final int ActionBar_contentInsetStart = 7;
        public static final int ActionBar_contentInsetStartWithNavigation = 8;
        public static final int ActionBar_customNavigationLayout = 9;
        public static final int ActionBar_displayOptions = 10;
        public static final int ActionBar_divider = 11;
        public static final int ActionBar_elevation = 12;
        public static final int ActionBar_height = 13;
        public static final int ActionBar_hideOnContentScroll = 14;
        public static final int ActionBar_homeAsUpIndicator = 15;
        public static final int ActionBar_homeLayout = 16;
        public static final int ActionBar_icon = 17;
        public static final int ActionBar_indeterminateProgressStyle = 18;
        public static final int ActionBar_itemPadding = 19;
        public static final int ActionBar_logo = 20;
        public static final int ActionBar_navigationMode = 21;
        public static final int ActionBar_popupTheme = 22;
        public static final int ActionBar_progressBarPadding = 23;
        public static final int ActionBar_progressBarStyle = 24;
        public static final int ActionBar_subtitle = 25;
        public static final int ActionBar_subtitleTextStyle = 26;
        public static final int ActionBar_title = 27;
        public static final int ActionBar_titleTextStyle = 28;
        public static final int ActionMenuItemView_android_minWidth = 0;
        public static final int ActionMode_background = 0;
        public static final int ActionMode_backgroundSplit = 1;
        public static final int ActionMode_closeItemLayout = 2;
        public static final int ActionMode_height = 3;
        public static final int ActionMode_subtitleTextStyle = 4;
        public static final int ActionMode_titleTextStyle = 5;
        public static final int ActivityChooserView_expandActivityOverflowButtonDrawable = 0;
        public static final int ActivityChooserView_initialActivityCount = 1;
        public static final int AlertDialog_android_layout = 0;
        public static final int AlertDialog_buttonIconDimen = 1;
        public static final int AlertDialog_buttonPanelSideLayout = 2;
        public static final int AlertDialog_listItemLayout = 3;
        public static final int AlertDialog_listLayout = 4;
        public static final int AlertDialog_multiChoiceItemLayout = 5;
        public static final int AlertDialog_showTitle = 6;
        public static final int AlertDialog_singleChoiceItemLayout = 7;
        public static final int AnimatedStateListDrawableCompat_android_constantSize = 3;
        public static final int AnimatedStateListDrawableCompat_android_dither = 0;
        public static final int AnimatedStateListDrawableCompat_android_enterFadeDuration = 4;
        public static final int AnimatedStateListDrawableCompat_android_exitFadeDuration = 5;
        public static final int AnimatedStateListDrawableCompat_android_variablePadding = 2;
        public static final int AnimatedStateListDrawableCompat_android_visible = 1;
        public static final int AnimatedStateListDrawableItem_android_drawable = 1;
        public static final int AnimatedStateListDrawableItem_android_id = 0;
        public static final int AnimatedStateListDrawableTransition_android_drawable = 0;
        public static final int AnimatedStateListDrawableTransition_android_fromId = 2;
        public static final int AnimatedStateListDrawableTransition_android_reversible = 3;
        public static final int AnimatedStateListDrawableTransition_android_toId = 1;
        public static final int AppCompatImageView_android_src = 0;
        public static final int AppCompatImageView_srcCompat = 1;
        public static final int AppCompatImageView_tint = 2;
        public static final int AppCompatImageView_tintMode = 3;
        public static final int AppCompatSeekBar_android_thumb = 0;
        public static final int AppCompatSeekBar_tickMark = 1;
        public static final int AppCompatSeekBar_tickMarkTint = 2;
        public static final int AppCompatSeekBar_tickMarkTintMode = 3;
        public static final int AppCompatTextHelper_android_drawableBottom = 2;
        public static final int AppCompatTextHelper_android_drawableEnd = 6;
        public static final int AppCompatTextHelper_android_drawableLeft = 3;
        public static final int AppCompatTextHelper_android_drawableRight = 4;
        public static final int AppCompatTextHelper_android_drawableStart = 5;
        public static final int AppCompatTextHelper_android_drawableTop = 1;
        public static final int AppCompatTextHelper_android_textAppearance = 0;
        public static final int AppCompatTextView_android_textAppearance = 0;
        public static final int AppCompatTextView_autoSizeMaxTextSize = 1;
        public static final int AppCompatTextView_autoSizeMinTextSize = 2;
        public static final int AppCompatTextView_autoSizePresetSizes = 3;
        public static final int AppCompatTextView_autoSizeStepGranularity = 4;
        public static final int AppCompatTextView_autoSizeTextType = 5;
        public static final int AppCompatTextView_drawableBottomCompat = 6;
        public static final int AppCompatTextView_drawableEndCompat = 7;
        public static final int AppCompatTextView_drawableLeftCompat = 8;
        public static final int AppCompatTextView_drawableRightCompat = 9;
        public static final int AppCompatTextView_drawableStartCompat = 10;
        public static final int AppCompatTextView_drawableTint = 11;
        public static final int AppCompatTextView_drawableTintMode = 12;
        public static final int AppCompatTextView_drawableTopCompat = 13;
        public static final int AppCompatTextView_emojiCompatEnabled = 14;
        public static final int AppCompatTextView_firstBaselineToTopHeight = 15;
        public static final int AppCompatTextView_fontFamily = 16;
        public static final int AppCompatTextView_fontVariationSettings = 17;
        public static final int AppCompatTextView_lastBaselineToBottomHeight = 18;
        public static final int AppCompatTextView_lineHeight = 19;
        public static final int AppCompatTextView_textAllCaps = 20;
        public static final int AppCompatTextView_textLocale = 21;
        public static final int AppCompatTheme_actionBarDivider = 2;
        public static final int AppCompatTheme_actionBarItemBackground = 3;
        public static final int AppCompatTheme_actionBarPopupTheme = 4;
        public static final int AppCompatTheme_actionBarSize = 5;
        public static final int AppCompatTheme_actionBarSplitStyle = 6;
        public static final int AppCompatTheme_actionBarStyle = 7;
        public static final int AppCompatTheme_actionBarTabBarStyle = 8;
        public static final int AppCompatTheme_actionBarTabStyle = 9;
        public static final int AppCompatTheme_actionBarTabTextStyle = 10;
        public static final int AppCompatTheme_actionBarTheme = 11;
        public static final int AppCompatTheme_actionBarWidgetTheme = 12;
        public static final int AppCompatTheme_actionButtonStyle = 13;
        public static final int AppCompatTheme_actionDropDownStyle = 14;
        public static final int AppCompatTheme_actionMenuTextAppearance = 15;
        public static final int AppCompatTheme_actionMenuTextColor = 16;
        public static final int AppCompatTheme_actionModeBackground = 17;
        public static final int AppCompatTheme_actionModeCloseButtonStyle = 18;
        public static final int AppCompatTheme_actionModeCloseContentDescription = 19;
        public static final int AppCompatTheme_actionModeCloseDrawable = 20;
        public static final int AppCompatTheme_actionModeCopyDrawable = 21;
        public static final int AppCompatTheme_actionModeCutDrawable = 22;
        public static final int AppCompatTheme_actionModeFindDrawable = 23;
        public static final int AppCompatTheme_actionModePasteDrawable = 24;
        public static final int AppCompatTheme_actionModePopupWindowStyle = 25;
        public static final int AppCompatTheme_actionModeSelectAllDrawable = 26;
        public static final int AppCompatTheme_actionModeShareDrawable = 27;
        public static final int AppCompatTheme_actionModeSplitBackground = 28;
        public static final int AppCompatTheme_actionModeStyle = 29;
        public static final int AppCompatTheme_actionModeTheme = 30;
        public static final int AppCompatTheme_actionModeWebSearchDrawable = 31;
        public static final int AppCompatTheme_actionOverflowButtonStyle = 32;
        public static final int AppCompatTheme_actionOverflowMenuStyle = 33;
        public static final int AppCompatTheme_activityChooserViewStyle = 34;
        public static final int AppCompatTheme_alertDialogButtonGroupStyle = 35;
        public static final int AppCompatTheme_alertDialogCenterButtons = 36;
        public static final int AppCompatTheme_alertDialogStyle = 37;
        public static final int AppCompatTheme_alertDialogTheme = 38;
        public static final int AppCompatTheme_android_windowAnimationStyle = 1;
        public static final int AppCompatTheme_android_windowIsFloating = 0;
        public static final int AppCompatTheme_autoCompleteTextViewStyle = 39;
        public static final int AppCompatTheme_borderlessButtonStyle = 40;
        public static final int AppCompatTheme_buttonBarButtonStyle = 41;
        public static final int AppCompatTheme_buttonBarNegativeButtonStyle = 42;
        public static final int AppCompatTheme_buttonBarNeutralButtonStyle = 43;
        public static final int AppCompatTheme_buttonBarPositiveButtonStyle = 44;
        public static final int AppCompatTheme_buttonBarStyle = 45;
        public static final int AppCompatTheme_buttonStyle = 46;
        public static final int AppCompatTheme_buttonStyleSmall = 47;
        public static final int AppCompatTheme_checkboxStyle = 48;
        public static final int AppCompatTheme_checkedTextViewStyle = 49;
        public static final int AppCompatTheme_colorAccent = 50;
        public static final int AppCompatTheme_colorBackgroundFloating = 51;
        public static final int AppCompatTheme_colorButtonNormal = 52;
        public static final int AppCompatTheme_colorControlActivated = 53;
        public static final int AppCompatTheme_colorControlHighlight = 54;
        public static final int AppCompatTheme_colorControlNormal = 55;
        public static final int AppCompatTheme_colorError = 56;
        public static final int AppCompatTheme_colorPrimary = 57;
        public static final int AppCompatTheme_colorPrimaryDark = 58;
        public static final int AppCompatTheme_colorSwitchThumbNormal = 59;
        public static final int AppCompatTheme_controlBackground = 60;
        public static final int AppCompatTheme_dialogCornerRadius = 61;
        public static final int AppCompatTheme_dialogPreferredPadding = 62;
        public static final int AppCompatTheme_dialogTheme = 63;
        public static final int AppCompatTheme_dividerHorizontal = 64;
        public static final int AppCompatTheme_dividerVertical = 65;
        public static final int AppCompatTheme_dropDownListViewStyle = 66;
        public static final int AppCompatTheme_dropdownListPreferredItemHeight = 67;
        public static final int AppCompatTheme_editTextBackground = 68;
        public static final int AppCompatTheme_editTextColor = 69;
        public static final int AppCompatTheme_editTextStyle = 70;
        public static final int AppCompatTheme_homeAsUpIndicator = 71;
        public static final int AppCompatTheme_imageButtonStyle = 72;
        public static final int AppCompatTheme_listChoiceBackgroundIndicator = 73;
        public static final int AppCompatTheme_listChoiceIndicatorMultipleAnimated = 74;
        public static final int AppCompatTheme_listChoiceIndicatorSingleAnimated = 75;
        public static final int AppCompatTheme_listDividerAlertDialog = 76;
        public static final int AppCompatTheme_listMenuViewStyle = 77;
        public static final int AppCompatTheme_listPopupWindowStyle = 78;
        public static final int AppCompatTheme_listPreferredItemHeight = 79;
        public static final int AppCompatTheme_listPreferredItemHeightLarge = 80;
        public static final int AppCompatTheme_listPreferredItemHeightSmall = 81;
        public static final int AppCompatTheme_listPreferredItemPaddingEnd = 82;
        public static final int AppCompatTheme_listPreferredItemPaddingLeft = 83;
        public static final int AppCompatTheme_listPreferredItemPaddingRight = 84;
        public static final int AppCompatTheme_listPreferredItemPaddingStart = 85;
        public static final int AppCompatTheme_panelBackground = 86;
        public static final int AppCompatTheme_panelMenuListTheme = 87;
        public static final int AppCompatTheme_panelMenuListWidth = 88;
        public static final int AppCompatTheme_popupMenuStyle = 89;
        public static final int AppCompatTheme_popupWindowStyle = 90;
        public static final int AppCompatTheme_radioButtonStyle = 91;
        public static final int AppCompatTheme_ratingBarStyle = 92;
        public static final int AppCompatTheme_ratingBarStyleIndicator = 93;
        public static final int AppCompatTheme_ratingBarStyleSmall = 94;
        public static final int AppCompatTheme_searchViewStyle = 95;
        public static final int AppCompatTheme_seekBarStyle = 96;
        public static final int AppCompatTheme_selectableItemBackground = 97;
        public static final int AppCompatTheme_selectableItemBackgroundBorderless = 98;
        public static final int AppCompatTheme_spinnerDropDownItemStyle = 99;
        public static final int AppCompatTheme_spinnerStyle = 100;
        public static final int AppCompatTheme_switchStyle = 101;
        public static final int AppCompatTheme_textAppearanceLargePopupMenu = 102;
        public static final int AppCompatTheme_textAppearanceListItem = 103;
        public static final int AppCompatTheme_textAppearanceListItemSecondary = 104;
        public static final int AppCompatTheme_textAppearanceListItemSmall = 105;
        public static final int AppCompatTheme_textAppearancePopupMenuHeader = 106;
        public static final int AppCompatTheme_textAppearanceSearchResultSubtitle = 107;
        public static final int AppCompatTheme_textAppearanceSearchResultTitle = 108;
        public static final int AppCompatTheme_textAppearanceSmallPopupMenu = 109;
        public static final int AppCompatTheme_textColorAlertDialogListItem = 110;
        public static final int AppCompatTheme_textColorSearchUrl = 111;
        public static final int AppCompatTheme_toolbarNavigationButtonStyle = 112;
        public static final int AppCompatTheme_toolbarStyle = 113;
        public static final int AppCompatTheme_tooltipForegroundColor = 114;
        public static final int AppCompatTheme_tooltipFrameBackground = 115;
        public static final int AppCompatTheme_viewInflaterClass = 116;
        public static final int AppCompatTheme_windowActionBar = 117;
        public static final int AppCompatTheme_windowActionBarOverlay = 118;
        public static final int AppCompatTheme_windowActionModeOverlay = 119;
        public static final int AppCompatTheme_windowFixedHeightMajor = 120;
        public static final int AppCompatTheme_windowFixedHeightMinor = 121;
        public static final int AppCompatTheme_windowFixedWidthMajor = 122;
        public static final int AppCompatTheme_windowFixedWidthMinor = 123;
        public static final int AppCompatTheme_windowMinWidthMajor = 124;
        public static final int AppCompatTheme_windowMinWidthMinor = 125;
        public static final int AppCompatTheme_windowNoTitle = 126;
        public static final int ButtonBarLayout_allowStacking = 0;
        public static final int Capability_queryPatterns = 0;
        public static final int Capability_shortcutMatchRequired = 1;
        public static final int Carousel_carousel_backwardTransition = 0;
        public static final int Carousel_carousel_emptyViewsBehavior = 1;
        public static final int Carousel_carousel_firstView = 2;
        public static final int Carousel_carousel_forwardTransition = 3;
        public static final int Carousel_carousel_infinite = 4;
        public static final int Carousel_carousel_nextState = 5;
        public static final int Carousel_carousel_previousState = 6;
        public static final int Carousel_carousel_touchUpMode = 7;
        public static final int Carousel_carousel_touchUp_dampeningFactor = 8;
        public static final int Carousel_carousel_touchUp_velocityThreshold = 9;
        public static final int CheckedTextView_android_checkMark = 0;
        public static final int CheckedTextView_checkMarkCompat = 1;
        public static final int CheckedTextView_checkMarkTint = 2;
        public static final int CheckedTextView_checkMarkTintMode = 3;
        public static final int ColorStateListItem_alpha = 3;
        public static final int ColorStateListItem_android_alpha = 1;
        public static final int ColorStateListItem_android_color = 0;
        public static final int ColorStateListItem_android_lStar = 2;
        public static final int ColorStateListItem_lStar = 4;
        public static final int CompoundButton_android_button = 0;
        public static final int CompoundButton_buttonCompat = 1;
        public static final int CompoundButton_buttonTint = 2;
        public static final int CompoundButton_buttonTintMode = 3;
        public static final int ConstraintLayout_Layout_android_elevation = 22;
        public static final int ConstraintLayout_Layout_android_layout_height = 8;
        public static final int ConstraintLayout_Layout_android_layout_margin = 9;
        public static final int ConstraintLayout_Layout_android_layout_marginBottom = 13;
        public static final int ConstraintLayout_Layout_android_layout_marginEnd = 21;
        public static final int ConstraintLayout_Layout_android_layout_marginHorizontal = 23;
        public static final int ConstraintLayout_Layout_android_layout_marginLeft = 10;
        public static final int ConstraintLayout_Layout_android_layout_marginRight = 12;
        public static final int ConstraintLayout_Layout_android_layout_marginStart = 20;
        public static final int ConstraintLayout_Layout_android_layout_marginTop = 11;
        public static final int ConstraintLayout_Layout_android_layout_marginVertical = 24;
        public static final int ConstraintLayout_Layout_android_layout_width = 7;
        public static final int ConstraintLayout_Layout_android_maxHeight = 15;
        public static final int ConstraintLayout_Layout_android_maxWidth = 14;
        public static final int ConstraintLayout_Layout_android_minHeight = 17;
        public static final int ConstraintLayout_Layout_android_minWidth = 16;
        public static final int ConstraintLayout_Layout_android_orientation = 0;
        public static final int ConstraintLayout_Layout_android_padding = 1;
        public static final int ConstraintLayout_Layout_android_paddingBottom = 5;
        public static final int ConstraintLayout_Layout_android_paddingEnd = 19;
        public static final int ConstraintLayout_Layout_android_paddingLeft = 2;
        public static final int ConstraintLayout_Layout_android_paddingRight = 4;
        public static final int ConstraintLayout_Layout_android_paddingStart = 18;
        public static final int ConstraintLayout_Layout_android_paddingTop = 3;
        public static final int ConstraintLayout_Layout_android_visibility = 6;
        public static final int ConstraintLayout_Layout_barrierAllowsGoneWidgets = 25;
        public static final int ConstraintLayout_Layout_barrierDirection = 26;
        public static final int ConstraintLayout_Layout_barrierMargin = 27;
        public static final int ConstraintLayout_Layout_chainUseRtl = 28;
        public static final int ConstraintLayout_Layout_circularflow_angles = 29;
        public static final int ConstraintLayout_Layout_circularflow_defaultAngle = 30;
        public static final int ConstraintLayout_Layout_circularflow_defaultRadius = 31;
        public static final int ConstraintLayout_Layout_circularflow_radiusInDP = 32;
        public static final int ConstraintLayout_Layout_circularflow_viewCenter = 33;
        public static final int ConstraintLayout_Layout_constraintSet = 34;
        public static final int ConstraintLayout_Layout_constraint_referenced_ids = 35;
        public static final int ConstraintLayout_Layout_constraint_referenced_tags = 36;
        public static final int ConstraintLayout_Layout_flow_firstHorizontalBias = 37;
        public static final int ConstraintLayout_Layout_flow_firstHorizontalStyle = 38;
        public static final int ConstraintLayout_Layout_flow_firstVerticalBias = 39;
        public static final int ConstraintLayout_Layout_flow_firstVerticalStyle = 40;
        public static final int ConstraintLayout_Layout_flow_horizontalAlign = 41;
        public static final int ConstraintLayout_Layout_flow_horizontalBias = 42;
        public static final int ConstraintLayout_Layout_flow_horizontalGap = 43;
        public static final int ConstraintLayout_Layout_flow_horizontalStyle = 44;
        public static final int ConstraintLayout_Layout_flow_lastHorizontalBias = 45;
        public static final int ConstraintLayout_Layout_flow_lastHorizontalStyle = 46;
        public static final int ConstraintLayout_Layout_flow_lastVerticalBias = 47;
        public static final int ConstraintLayout_Layout_flow_lastVerticalStyle = 48;
        public static final int ConstraintLayout_Layout_flow_maxElementsWrap = 49;
        public static final int ConstraintLayout_Layout_flow_verticalAlign = 50;
        public static final int ConstraintLayout_Layout_flow_verticalBias = 51;
        public static final int ConstraintLayout_Layout_flow_verticalGap = 52;
        public static final int ConstraintLayout_Layout_flow_verticalStyle = 53;
        public static final int ConstraintLayout_Layout_flow_wrapMode = 54;
        public static final int ConstraintLayout_Layout_guidelineUseRtl = 55;
        public static final int ConstraintLayout_Layout_layoutDescription = 56;
        public static final int ConstraintLayout_Layout_layout_constrainedHeight = 57;
        public static final int ConstraintLayout_Layout_layout_constrainedWidth = 58;
        public static final int ConstraintLayout_Layout_layout_constraintBaseline_creator = 59;
        public static final int ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf = 60;
        public static final int ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf = 61;
        public static final int ConstraintLayout_Layout_layout_constraintBaseline_toTopOf = 62;
        public static final int ConstraintLayout_Layout_layout_constraintBottom_creator = 63;
        public static final int ConstraintLayout_Layout_layout_constraintBottom_toBottomOf = 64;
        public static final int ConstraintLayout_Layout_layout_constraintBottom_toTopOf = 65;
        public static final int ConstraintLayout_Layout_layout_constraintCircle = 66;
        public static final int ConstraintLayout_Layout_layout_constraintCircleAngle = 67;
        public static final int ConstraintLayout_Layout_layout_constraintCircleRadius = 68;
        public static final int ConstraintLayout_Layout_layout_constraintDimensionRatio = 69;
        public static final int ConstraintLayout_Layout_layout_constraintEnd_toEndOf = 70;
        public static final int ConstraintLayout_Layout_layout_constraintEnd_toStartOf = 71;
        public static final int ConstraintLayout_Layout_layout_constraintGuide_begin = 72;
        public static final int ConstraintLayout_Layout_layout_constraintGuide_end = 73;
        public static final int ConstraintLayout_Layout_layout_constraintGuide_percent = 74;
        public static final int ConstraintLayout_Layout_layout_constraintHeight = 75;
        public static final int ConstraintLayout_Layout_layout_constraintHeight_default = 76;
        public static final int ConstraintLayout_Layout_layout_constraintHeight_max = 77;
        public static final int ConstraintLayout_Layout_layout_constraintHeight_min = 78;
        public static final int ConstraintLayout_Layout_layout_constraintHeight_percent = 79;
        public static final int ConstraintLayout_Layout_layout_constraintHorizontal_bias = 80;
        public static final int ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle = 81;
        public static final int ConstraintLayout_Layout_layout_constraintHorizontal_weight = 82;
        public static final int ConstraintLayout_Layout_layout_constraintLeft_creator = 83;
        public static final int ConstraintLayout_Layout_layout_constraintLeft_toLeftOf = 84;
        public static final int ConstraintLayout_Layout_layout_constraintLeft_toRightOf = 85;
        public static final int ConstraintLayout_Layout_layout_constraintRight_creator = 86;
        public static final int ConstraintLayout_Layout_layout_constraintRight_toLeftOf = 87;
        public static final int ConstraintLayout_Layout_layout_constraintRight_toRightOf = 88;
        public static final int ConstraintLayout_Layout_layout_constraintStart_toEndOf = 89;
        public static final int ConstraintLayout_Layout_layout_constraintStart_toStartOf = 90;
        public static final int ConstraintLayout_Layout_layout_constraintTag = 91;
        public static final int ConstraintLayout_Layout_layout_constraintTop_creator = 92;
        public static final int ConstraintLayout_Layout_layout_constraintTop_toBottomOf = 93;
        public static final int ConstraintLayout_Layout_layout_constraintTop_toTopOf = 94;
        public static final int ConstraintLayout_Layout_layout_constraintVertical_bias = 95;
        public static final int ConstraintLayout_Layout_layout_constraintVertical_chainStyle = 96;
        public static final int ConstraintLayout_Layout_layout_constraintVertical_weight = 97;
        public static final int ConstraintLayout_Layout_layout_constraintWidth = 98;
        public static final int ConstraintLayout_Layout_layout_constraintWidth_default = 99;
        public static final int ConstraintLayout_Layout_layout_constraintWidth_max = 100;
        public static final int ConstraintLayout_Layout_layout_constraintWidth_min = 101;
        public static final int ConstraintLayout_Layout_layout_constraintWidth_percent = 102;
        public static final int ConstraintLayout_Layout_layout_editor_absoluteX = 103;
        public static final int ConstraintLayout_Layout_layout_editor_absoluteY = 104;
        public static final int ConstraintLayout_Layout_layout_goneMarginBaseline = 105;
        public static final int ConstraintLayout_Layout_layout_goneMarginBottom = 106;
        public static final int ConstraintLayout_Layout_layout_goneMarginEnd = 107;
        public static final int ConstraintLayout_Layout_layout_goneMarginLeft = 108;
        public static final int ConstraintLayout_Layout_layout_goneMarginRight = 109;
        public static final int ConstraintLayout_Layout_layout_goneMarginStart = 110;
        public static final int ConstraintLayout_Layout_layout_goneMarginTop = 111;
        public static final int ConstraintLayout_Layout_layout_marginBaseline = 112;
        public static final int ConstraintLayout_Layout_layout_optimizationLevel = 113;
        public static final int ConstraintLayout_Layout_layout_wrapBehaviorInParent = 114;
        public static final int ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange = 0;

        /* renamed from: ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets */
        public static final int f512xfdeff96 = 1;

        /* renamed from: ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet */
        public static final int f513x2694048c = 2;
        public static final int ConstraintLayout_ReactiveGuide_reactiveGuide_valueId = 3;
        public static final int ConstraintLayout_placeholder_content = 0;
        public static final int ConstraintLayout_placeholder_placeholder_emptyVisibility = 1;
        public static final int ConstraintOverride_android_alpha = 13;
        public static final int ConstraintOverride_android_elevation = 26;
        public static final int ConstraintOverride_android_id = 1;
        public static final int ConstraintOverride_android_layout_height = 4;
        public static final int ConstraintOverride_android_layout_marginBottom = 8;
        public static final int ConstraintOverride_android_layout_marginEnd = 24;
        public static final int ConstraintOverride_android_layout_marginLeft = 5;
        public static final int ConstraintOverride_android_layout_marginRight = 7;
        public static final int ConstraintOverride_android_layout_marginStart = 23;
        public static final int ConstraintOverride_android_layout_marginTop = 6;
        public static final int ConstraintOverride_android_layout_width = 3;
        public static final int ConstraintOverride_android_maxHeight = 10;
        public static final int ConstraintOverride_android_maxWidth = 9;
        public static final int ConstraintOverride_android_minHeight = 12;
        public static final int ConstraintOverride_android_minWidth = 11;
        public static final int ConstraintOverride_android_orientation = 0;
        public static final int ConstraintOverride_android_rotation = 20;
        public static final int ConstraintOverride_android_rotationX = 21;
        public static final int ConstraintOverride_android_rotationY = 22;
        public static final int ConstraintOverride_android_scaleX = 18;
        public static final int ConstraintOverride_android_scaleY = 19;
        public static final int ConstraintOverride_android_transformPivotX = 14;
        public static final int ConstraintOverride_android_transformPivotY = 15;
        public static final int ConstraintOverride_android_translationX = 16;
        public static final int ConstraintOverride_android_translationY = 17;
        public static final int ConstraintOverride_android_translationZ = 25;
        public static final int ConstraintOverride_android_visibility = 2;
        public static final int ConstraintOverride_animateCircleAngleTo = 27;
        public static final int ConstraintOverride_animateRelativeTo = 28;
        public static final int ConstraintOverride_barrierAllowsGoneWidgets = 29;
        public static final int ConstraintOverride_barrierDirection = 30;
        public static final int ConstraintOverride_barrierMargin = 31;
        public static final int ConstraintOverride_chainUseRtl = 32;
        public static final int ConstraintOverride_constraint_referenced_ids = 33;
        public static final int ConstraintOverride_drawPath = 34;
        public static final int ConstraintOverride_flow_firstHorizontalBias = 35;
        public static final int ConstraintOverride_flow_firstHorizontalStyle = 36;
        public static final int ConstraintOverride_flow_firstVerticalBias = 37;
        public static final int ConstraintOverride_flow_firstVerticalStyle = 38;
        public static final int ConstraintOverride_flow_horizontalAlign = 39;
        public static final int ConstraintOverride_flow_horizontalBias = 40;
        public static final int ConstraintOverride_flow_horizontalGap = 41;
        public static final int ConstraintOverride_flow_horizontalStyle = 42;
        public static final int ConstraintOverride_flow_lastHorizontalBias = 43;
        public static final int ConstraintOverride_flow_lastHorizontalStyle = 44;
        public static final int ConstraintOverride_flow_lastVerticalBias = 45;
        public static final int ConstraintOverride_flow_lastVerticalStyle = 46;
        public static final int ConstraintOverride_flow_maxElementsWrap = 47;
        public static final int ConstraintOverride_flow_verticalAlign = 48;
        public static final int ConstraintOverride_flow_verticalBias = 49;
        public static final int ConstraintOverride_flow_verticalGap = 50;
        public static final int ConstraintOverride_flow_verticalStyle = 51;
        public static final int ConstraintOverride_flow_wrapMode = 52;
        public static final int ConstraintOverride_guidelineUseRtl = 53;
        public static final int ConstraintOverride_layout_constrainedHeight = 54;
        public static final int ConstraintOverride_layout_constrainedWidth = 55;
        public static final int ConstraintOverride_layout_constraintBaseline_creator = 56;
        public static final int ConstraintOverride_layout_constraintBottom_creator = 57;
        public static final int ConstraintOverride_layout_constraintCircleAngle = 58;
        public static final int ConstraintOverride_layout_constraintCircleRadius = 59;
        public static final int ConstraintOverride_layout_constraintDimensionRatio = 60;
        public static final int ConstraintOverride_layout_constraintGuide_begin = 61;
        public static final int ConstraintOverride_layout_constraintGuide_end = 62;
        public static final int ConstraintOverride_layout_constraintGuide_percent = 63;
        public static final int ConstraintOverride_layout_constraintHeight = 64;
        public static final int ConstraintOverride_layout_constraintHeight_default = 65;
        public static final int ConstraintOverride_layout_constraintHeight_max = 66;
        public static final int ConstraintOverride_layout_constraintHeight_min = 67;
        public static final int ConstraintOverride_layout_constraintHeight_percent = 68;
        public static final int ConstraintOverride_layout_constraintHorizontal_bias = 69;
        public static final int ConstraintOverride_layout_constraintHorizontal_chainStyle = 70;
        public static final int ConstraintOverride_layout_constraintHorizontal_weight = 71;
        public static final int ConstraintOverride_layout_constraintLeft_creator = 72;
        public static final int ConstraintOverride_layout_constraintRight_creator = 73;
        public static final int ConstraintOverride_layout_constraintTag = 74;
        public static final int ConstraintOverride_layout_constraintTop_creator = 75;
        public static final int ConstraintOverride_layout_constraintVertical_bias = 76;
        public static final int ConstraintOverride_layout_constraintVertical_chainStyle = 77;
        public static final int ConstraintOverride_layout_constraintVertical_weight = 78;
        public static final int ConstraintOverride_layout_constraintWidth = 79;
        public static final int ConstraintOverride_layout_constraintWidth_default = 80;
        public static final int ConstraintOverride_layout_constraintWidth_max = 81;
        public static final int ConstraintOverride_layout_constraintWidth_min = 82;
        public static final int ConstraintOverride_layout_constraintWidth_percent = 83;
        public static final int ConstraintOverride_layout_editor_absoluteX = 84;
        public static final int ConstraintOverride_layout_editor_absoluteY = 85;
        public static final int ConstraintOverride_layout_goneMarginBaseline = 86;
        public static final int ConstraintOverride_layout_goneMarginBottom = 87;
        public static final int ConstraintOverride_layout_goneMarginEnd = 88;
        public static final int ConstraintOverride_layout_goneMarginLeft = 89;
        public static final int ConstraintOverride_layout_goneMarginRight = 90;
        public static final int ConstraintOverride_layout_goneMarginStart = 91;
        public static final int ConstraintOverride_layout_goneMarginTop = 92;
        public static final int ConstraintOverride_layout_marginBaseline = 93;
        public static final int ConstraintOverride_layout_wrapBehaviorInParent = 94;
        public static final int ConstraintOverride_motionProgress = 95;
        public static final int ConstraintOverride_motionStagger = 96;
        public static final int ConstraintOverride_motionTarget = 97;
        public static final int ConstraintOverride_pathMotionArc = 98;
        public static final int ConstraintOverride_pivotAnchor = 99;
        public static final int ConstraintOverride_polarRelativeTo = 100;
        public static final int ConstraintOverride_quantizeMotionInterpolator = 101;
        public static final int ConstraintOverride_quantizeMotionPhase = 102;
        public static final int ConstraintOverride_quantizeMotionSteps = 103;
        public static final int ConstraintOverride_transformPivotTarget = 104;
        public static final int ConstraintOverride_transitionEasing = 105;
        public static final int ConstraintOverride_transitionPathRotate = 106;
        public static final int ConstraintOverride_visibilityMode = 107;
        public static final int ConstraintSet_android_alpha = 15;
        public static final int ConstraintSet_android_elevation = 28;
        public static final int ConstraintSet_android_id = 1;
        public static final int ConstraintSet_android_layout_height = 4;
        public static final int ConstraintSet_android_layout_marginBottom = 8;
        public static final int ConstraintSet_android_layout_marginEnd = 26;
        public static final int ConstraintSet_android_layout_marginLeft = 5;
        public static final int ConstraintSet_android_layout_marginRight = 7;
        public static final int ConstraintSet_android_layout_marginStart = 25;
        public static final int ConstraintSet_android_layout_marginTop = 6;
        public static final int ConstraintSet_android_layout_width = 3;
        public static final int ConstraintSet_android_maxHeight = 10;
        public static final int ConstraintSet_android_maxWidth = 9;
        public static final int ConstraintSet_android_minHeight = 12;
        public static final int ConstraintSet_android_minWidth = 11;
        public static final int ConstraintSet_android_orientation = 0;
        public static final int ConstraintSet_android_pivotX = 13;
        public static final int ConstraintSet_android_pivotY = 14;
        public static final int ConstraintSet_android_rotation = 22;
        public static final int ConstraintSet_android_rotationX = 23;
        public static final int ConstraintSet_android_rotationY = 24;
        public static final int ConstraintSet_android_scaleX = 20;
        public static final int ConstraintSet_android_scaleY = 21;
        public static final int ConstraintSet_android_transformPivotX = 16;
        public static final int ConstraintSet_android_transformPivotY = 17;
        public static final int ConstraintSet_android_translationX = 18;
        public static final int ConstraintSet_android_translationY = 19;
        public static final int ConstraintSet_android_translationZ = 27;
        public static final int ConstraintSet_android_visibility = 2;
        public static final int ConstraintSet_animateCircleAngleTo = 29;
        public static final int ConstraintSet_animateRelativeTo = 30;
        public static final int ConstraintSet_barrierAllowsGoneWidgets = 31;
        public static final int ConstraintSet_barrierDirection = 32;
        public static final int ConstraintSet_barrierMargin = 33;
        public static final int ConstraintSet_chainUseRtl = 34;
        public static final int ConstraintSet_constraintRotate = 35;
        public static final int ConstraintSet_constraint_referenced_ids = 36;
        public static final int ConstraintSet_constraint_referenced_tags = 37;
        public static final int ConstraintSet_deriveConstraintsFrom = 38;
        public static final int ConstraintSet_drawPath = 39;
        public static final int ConstraintSet_flow_firstHorizontalBias = 40;
        public static final int ConstraintSet_flow_firstHorizontalStyle = 41;
        public static final int ConstraintSet_flow_firstVerticalBias = 42;
        public static final int ConstraintSet_flow_firstVerticalStyle = 43;
        public static final int ConstraintSet_flow_horizontalAlign = 44;
        public static final int ConstraintSet_flow_horizontalBias = 45;
        public static final int ConstraintSet_flow_horizontalGap = 46;
        public static final int ConstraintSet_flow_horizontalStyle = 47;
        public static final int ConstraintSet_flow_lastHorizontalBias = 48;
        public static final int ConstraintSet_flow_lastHorizontalStyle = 49;
        public static final int ConstraintSet_flow_lastVerticalBias = 50;
        public static final int ConstraintSet_flow_lastVerticalStyle = 51;
        public static final int ConstraintSet_flow_maxElementsWrap = 52;
        public static final int ConstraintSet_flow_verticalAlign = 53;
        public static final int ConstraintSet_flow_verticalBias = 54;
        public static final int ConstraintSet_flow_verticalGap = 55;
        public static final int ConstraintSet_flow_verticalStyle = 56;
        public static final int ConstraintSet_flow_wrapMode = 57;
        public static final int ConstraintSet_guidelineUseRtl = 58;
        public static final int ConstraintSet_layout_constrainedHeight = 59;
        public static final int ConstraintSet_layout_constrainedWidth = 60;
        public static final int ConstraintSet_layout_constraintBaseline_creator = 61;
        public static final int ConstraintSet_layout_constraintBaseline_toBaselineOf = 62;
        public static final int ConstraintSet_layout_constraintBaseline_toBottomOf = 63;
        public static final int ConstraintSet_layout_constraintBaseline_toTopOf = 64;
        public static final int ConstraintSet_layout_constraintBottom_creator = 65;
        public static final int ConstraintSet_layout_constraintBottom_toBottomOf = 66;
        public static final int ConstraintSet_layout_constraintBottom_toTopOf = 67;
        public static final int ConstraintSet_layout_constraintCircle = 68;
        public static final int ConstraintSet_layout_constraintCircleAngle = 69;
        public static final int ConstraintSet_layout_constraintCircleRadius = 70;
        public static final int ConstraintSet_layout_constraintDimensionRatio = 71;
        public static final int ConstraintSet_layout_constraintEnd_toEndOf = 72;
        public static final int ConstraintSet_layout_constraintEnd_toStartOf = 73;
        public static final int ConstraintSet_layout_constraintGuide_begin = 74;
        public static final int ConstraintSet_layout_constraintGuide_end = 75;
        public static final int ConstraintSet_layout_constraintGuide_percent = 76;
        public static final int ConstraintSet_layout_constraintHeight_default = 77;
        public static final int ConstraintSet_layout_constraintHeight_max = 78;
        public static final int ConstraintSet_layout_constraintHeight_min = 79;
        public static final int ConstraintSet_layout_constraintHeight_percent = 80;
        public static final int ConstraintSet_layout_constraintHorizontal_bias = 81;
        public static final int ConstraintSet_layout_constraintHorizontal_chainStyle = 82;
        public static final int ConstraintSet_layout_constraintHorizontal_weight = 83;
        public static final int ConstraintSet_layout_constraintLeft_creator = 84;
        public static final int ConstraintSet_layout_constraintLeft_toLeftOf = 85;
        public static final int ConstraintSet_layout_constraintLeft_toRightOf = 86;
        public static final int ConstraintSet_layout_constraintRight_creator = 87;
        public static final int ConstraintSet_layout_constraintRight_toLeftOf = 88;
        public static final int ConstraintSet_layout_constraintRight_toRightOf = 89;
        public static final int ConstraintSet_layout_constraintStart_toEndOf = 90;
        public static final int ConstraintSet_layout_constraintStart_toStartOf = 91;
        public static final int ConstraintSet_layout_constraintTag = 92;
        public static final int ConstraintSet_layout_constraintTop_creator = 93;
        public static final int ConstraintSet_layout_constraintTop_toBottomOf = 94;
        public static final int ConstraintSet_layout_constraintTop_toTopOf = 95;
        public static final int ConstraintSet_layout_constraintVertical_bias = 96;
        public static final int ConstraintSet_layout_constraintVertical_chainStyle = 97;
        public static final int ConstraintSet_layout_constraintVertical_weight = 98;
        public static final int ConstraintSet_layout_constraintWidth_default = 99;
        public static final int ConstraintSet_layout_constraintWidth_max = 100;
        public static final int ConstraintSet_layout_constraintWidth_min = 101;
        public static final int ConstraintSet_layout_constraintWidth_percent = 102;
        public static final int ConstraintSet_layout_editor_absoluteX = 103;
        public static final int ConstraintSet_layout_editor_absoluteY = 104;
        public static final int ConstraintSet_layout_goneMarginBaseline = 105;
        public static final int ConstraintSet_layout_goneMarginBottom = 106;
        public static final int ConstraintSet_layout_goneMarginEnd = 107;
        public static final int ConstraintSet_layout_goneMarginLeft = 108;
        public static final int ConstraintSet_layout_goneMarginRight = 109;
        public static final int ConstraintSet_layout_goneMarginStart = 110;
        public static final int ConstraintSet_layout_goneMarginTop = 111;
        public static final int ConstraintSet_layout_marginBaseline = 112;
        public static final int ConstraintSet_layout_wrapBehaviorInParent = 113;
        public static final int ConstraintSet_motionProgress = 114;
        public static final int ConstraintSet_motionStagger = 115;
        public static final int ConstraintSet_pathMotionArc = 116;
        public static final int ConstraintSet_pivotAnchor = 117;
        public static final int ConstraintSet_polarRelativeTo = 118;
        public static final int ConstraintSet_quantizeMotionSteps = 119;
        public static final int ConstraintSet_transitionEasing = 120;
        public static final int ConstraintSet_transitionPathRotate = 121;
        public static final int Constraint_android_alpha = 13;
        public static final int Constraint_android_elevation = 26;
        public static final int Constraint_android_id = 1;
        public static final int Constraint_android_layout_height = 4;
        public static final int Constraint_android_layout_marginBottom = 8;
        public static final int Constraint_android_layout_marginEnd = 24;
        public static final int Constraint_android_layout_marginLeft = 5;
        public static final int Constraint_android_layout_marginRight = 7;
        public static final int Constraint_android_layout_marginStart = 23;
        public static final int Constraint_android_layout_marginTop = 6;
        public static final int Constraint_android_layout_width = 3;
        public static final int Constraint_android_maxHeight = 10;
        public static final int Constraint_android_maxWidth = 9;
        public static final int Constraint_android_minHeight = 12;
        public static final int Constraint_android_minWidth = 11;
        public static final int Constraint_android_orientation = 0;
        public static final int Constraint_android_rotation = 20;
        public static final int Constraint_android_rotationX = 21;
        public static final int Constraint_android_rotationY = 22;
        public static final int Constraint_android_scaleX = 18;
        public static final int Constraint_android_scaleY = 19;
        public static final int Constraint_android_transformPivotX = 14;
        public static final int Constraint_android_transformPivotY = 15;
        public static final int Constraint_android_translationX = 16;
        public static final int Constraint_android_translationY = 17;
        public static final int Constraint_android_translationZ = 25;
        public static final int Constraint_android_visibility = 2;
        public static final int Constraint_animateCircleAngleTo = 27;
        public static final int Constraint_animateRelativeTo = 28;
        public static final int Constraint_barrierAllowsGoneWidgets = 29;
        public static final int Constraint_barrierDirection = 30;
        public static final int Constraint_barrierMargin = 31;
        public static final int Constraint_chainUseRtl = 32;
        public static final int Constraint_constraint_referenced_ids = 33;
        public static final int Constraint_constraint_referenced_tags = 34;
        public static final int Constraint_drawPath = 35;
        public static final int Constraint_flow_firstHorizontalBias = 36;
        public static final int Constraint_flow_firstHorizontalStyle = 37;
        public static final int Constraint_flow_firstVerticalBias = 38;
        public static final int Constraint_flow_firstVerticalStyle = 39;
        public static final int Constraint_flow_horizontalAlign = 40;
        public static final int Constraint_flow_horizontalBias = 41;
        public static final int Constraint_flow_horizontalGap = 42;
        public static final int Constraint_flow_horizontalStyle = 43;
        public static final int Constraint_flow_lastHorizontalBias = 44;
        public static final int Constraint_flow_lastHorizontalStyle = 45;
        public static final int Constraint_flow_lastVerticalBias = 46;
        public static final int Constraint_flow_lastVerticalStyle = 47;
        public static final int Constraint_flow_maxElementsWrap = 48;
        public static final int Constraint_flow_verticalAlign = 49;
        public static final int Constraint_flow_verticalBias = 50;
        public static final int Constraint_flow_verticalGap = 51;
        public static final int Constraint_flow_verticalStyle = 52;
        public static final int Constraint_flow_wrapMode = 53;
        public static final int Constraint_guidelineUseRtl = 54;
        public static final int Constraint_layout_constrainedHeight = 55;
        public static final int Constraint_layout_constrainedWidth = 56;
        public static final int Constraint_layout_constraintBaseline_creator = 57;
        public static final int Constraint_layout_constraintBaseline_toBaselineOf = 58;
        public static final int Constraint_layout_constraintBaseline_toBottomOf = 59;
        public static final int Constraint_layout_constraintBaseline_toTopOf = 60;
        public static final int Constraint_layout_constraintBottom_creator = 61;
        public static final int Constraint_layout_constraintBottom_toBottomOf = 62;
        public static final int Constraint_layout_constraintBottom_toTopOf = 63;
        public static final int Constraint_layout_constraintCircle = 64;
        public static final int Constraint_layout_constraintCircleAngle = 65;
        public static final int Constraint_layout_constraintCircleRadius = 66;
        public static final int Constraint_layout_constraintDimensionRatio = 67;
        public static final int Constraint_layout_constraintEnd_toEndOf = 68;
        public static final int Constraint_layout_constraintEnd_toStartOf = 69;
        public static final int Constraint_layout_constraintGuide_begin = 70;
        public static final int Constraint_layout_constraintGuide_end = 71;
        public static final int Constraint_layout_constraintGuide_percent = 72;
        public static final int Constraint_layout_constraintHeight = 73;
        public static final int Constraint_layout_constraintHeight_default = 74;
        public static final int Constraint_layout_constraintHeight_max = 75;
        public static final int Constraint_layout_constraintHeight_min = 76;
        public static final int Constraint_layout_constraintHeight_percent = 77;
        public static final int Constraint_layout_constraintHorizontal_bias = 78;
        public static final int Constraint_layout_constraintHorizontal_chainStyle = 79;
        public static final int Constraint_layout_constraintHorizontal_weight = 80;
        public static final int Constraint_layout_constraintLeft_creator = 81;
        public static final int Constraint_layout_constraintLeft_toLeftOf = 82;
        public static final int Constraint_layout_constraintLeft_toRightOf = 83;
        public static final int Constraint_layout_constraintRight_creator = 84;
        public static final int Constraint_layout_constraintRight_toLeftOf = 85;
        public static final int Constraint_layout_constraintRight_toRightOf = 86;
        public static final int Constraint_layout_constraintStart_toEndOf = 87;
        public static final int Constraint_layout_constraintStart_toStartOf = 88;
        public static final int Constraint_layout_constraintTag = 89;
        public static final int Constraint_layout_constraintTop_creator = 90;
        public static final int Constraint_layout_constraintTop_toBottomOf = 91;
        public static final int Constraint_layout_constraintTop_toTopOf = 92;
        public static final int Constraint_layout_constraintVertical_bias = 93;
        public static final int Constraint_layout_constraintVertical_chainStyle = 94;
        public static final int Constraint_layout_constraintVertical_weight = 95;
        public static final int Constraint_layout_constraintWidth = 96;
        public static final int Constraint_layout_constraintWidth_default = 97;
        public static final int Constraint_layout_constraintWidth_max = 98;
        public static final int Constraint_layout_constraintWidth_min = 99;
        public static final int Constraint_layout_constraintWidth_percent = 100;
        public static final int Constraint_layout_editor_absoluteX = 101;
        public static final int Constraint_layout_editor_absoluteY = 102;
        public static final int Constraint_layout_goneMarginBaseline = 103;
        public static final int Constraint_layout_goneMarginBottom = 104;
        public static final int Constraint_layout_goneMarginEnd = 105;
        public static final int Constraint_layout_goneMarginLeft = 106;
        public static final int Constraint_layout_goneMarginRight = 107;
        public static final int Constraint_layout_goneMarginStart = 108;
        public static final int Constraint_layout_goneMarginTop = 109;
        public static final int Constraint_layout_marginBaseline = 110;
        public static final int Constraint_layout_wrapBehaviorInParent = 111;
        public static final int Constraint_motionProgress = 112;
        public static final int Constraint_motionStagger = 113;
        public static final int Constraint_pathMotionArc = 114;
        public static final int Constraint_pivotAnchor = 115;
        public static final int Constraint_polarRelativeTo = 116;
        public static final int Constraint_quantizeMotionInterpolator = 117;
        public static final int Constraint_quantizeMotionPhase = 118;
        public static final int Constraint_quantizeMotionSteps = 119;
        public static final int Constraint_transformPivotTarget = 120;
        public static final int Constraint_transitionEasing = 121;
        public static final int Constraint_transitionPathRotate = 122;
        public static final int Constraint_visibilityMode = 123;
        public static final int CustomAttribute_attributeName = 0;
        public static final int CustomAttribute_customBoolean = 1;
        public static final int CustomAttribute_customColorDrawableValue = 2;
        public static final int CustomAttribute_customColorValue = 3;
        public static final int CustomAttribute_customDimension = 4;
        public static final int CustomAttribute_customFloatValue = 5;
        public static final int CustomAttribute_customIntegerValue = 6;
        public static final int CustomAttribute_customPixelDimension = 7;
        public static final int CustomAttribute_customReference = 8;
        public static final int CustomAttribute_customStringValue = 9;
        public static final int CustomAttribute_methodName = 10;
        public static final int DrawerArrowToggle_arrowHeadLength = 0;
        public static final int DrawerArrowToggle_arrowShaftLength = 1;
        public static final int DrawerArrowToggle_barLength = 2;
        public static final int DrawerArrowToggle_color = 3;
        public static final int DrawerArrowToggle_drawableSize = 4;
        public static final int DrawerArrowToggle_gapBetweenBars = 5;
        public static final int DrawerArrowToggle_spinBars = 6;
        public static final int DrawerArrowToggle_thickness = 7;
        public static final int FontFamilyFont_android_font = 0;
        public static final int FontFamilyFont_android_fontStyle = 2;
        public static final int FontFamilyFont_android_fontVariationSettings = 4;
        public static final int FontFamilyFont_android_fontWeight = 1;
        public static final int FontFamilyFont_android_ttcIndex = 3;
        public static final int FontFamilyFont_font = 5;
        public static final int FontFamilyFont_fontStyle = 6;
        public static final int FontFamilyFont_fontVariationSettings = 7;
        public static final int FontFamilyFont_fontWeight = 8;
        public static final int FontFamilyFont_ttcIndex = 9;
        public static final int FontFamily_fontProviderAuthority = 0;
        public static final int FontFamily_fontProviderCerts = 1;
        public static final int FontFamily_fontProviderFetchStrategy = 2;
        public static final int FontFamily_fontProviderFetchTimeout = 3;
        public static final int FontFamily_fontProviderPackage = 4;
        public static final int FontFamily_fontProviderQuery = 5;
        public static final int FontFamily_fontProviderSystemFontFamily = 6;
        public static final int FragmentContainerView_android_name = 0;
        public static final int FragmentContainerView_android_tag = 1;
        public static final int Fragment_android_id = 1;
        public static final int Fragment_android_name = 0;
        public static final int Fragment_android_tag = 2;
        public static final int GradientColorItem_android_color = 0;
        public static final int GradientColorItem_android_offset = 1;
        public static final int GradientColor_android_centerColor = 7;
        public static final int GradientColor_android_centerX = 3;
        public static final int GradientColor_android_centerY = 4;
        public static final int GradientColor_android_endColor = 1;
        public static final int GradientColor_android_endX = 10;
        public static final int GradientColor_android_endY = 11;
        public static final int GradientColor_android_gradientRadius = 5;
        public static final int GradientColor_android_startColor = 0;
        public static final int GradientColor_android_startX = 8;
        public static final int GradientColor_android_startY = 9;
        public static final int GradientColor_android_tileMode = 6;
        public static final int GradientColor_android_type = 2;
        public static final int ImageFilterView_altSrc = 0;
        public static final int ImageFilterView_blendSrc = 1;
        public static final int ImageFilterView_brightness = 2;
        public static final int ImageFilterView_contrast = 3;
        public static final int ImageFilterView_crossfade = 4;
        public static final int ImageFilterView_imagePanX = 5;
        public static final int ImageFilterView_imagePanY = 6;
        public static final int ImageFilterView_imageRotate = 7;
        public static final int ImageFilterView_imageZoom = 8;
        public static final int ImageFilterView_overlay = 9;
        public static final int ImageFilterView_round = 10;
        public static final int ImageFilterView_roundPercent = 11;
        public static final int ImageFilterView_saturation = 12;
        public static final int ImageFilterView_warmth = 13;
        public static final int KeyAttribute_android_alpha = 0;
        public static final int KeyAttribute_android_elevation = 11;
        public static final int KeyAttribute_android_rotation = 7;
        public static final int KeyAttribute_android_rotationX = 8;
        public static final int KeyAttribute_android_rotationY = 9;
        public static final int KeyAttribute_android_scaleX = 5;
        public static final int KeyAttribute_android_scaleY = 6;
        public static final int KeyAttribute_android_transformPivotX = 1;
        public static final int KeyAttribute_android_transformPivotY = 2;
        public static final int KeyAttribute_android_translationX = 3;
        public static final int KeyAttribute_android_translationY = 4;
        public static final int KeyAttribute_android_translationZ = 10;
        public static final int KeyAttribute_curveFit = 12;
        public static final int KeyAttribute_framePosition = 13;
        public static final int KeyAttribute_motionProgress = 14;
        public static final int KeyAttribute_motionTarget = 15;
        public static final int KeyAttribute_transformPivotTarget = 16;
        public static final int KeyAttribute_transitionEasing = 17;
        public static final int KeyAttribute_transitionPathRotate = 18;
        public static final int KeyCycle_android_alpha = 0;
        public static final int KeyCycle_android_elevation = 9;
        public static final int KeyCycle_android_rotation = 5;
        public static final int KeyCycle_android_rotationX = 6;
        public static final int KeyCycle_android_rotationY = 7;
        public static final int KeyCycle_android_scaleX = 3;
        public static final int KeyCycle_android_scaleY = 4;
        public static final int KeyCycle_android_translationX = 1;
        public static final int KeyCycle_android_translationY = 2;
        public static final int KeyCycle_android_translationZ = 8;
        public static final int KeyCycle_curveFit = 10;
        public static final int KeyCycle_framePosition = 11;
        public static final int KeyCycle_motionProgress = 12;
        public static final int KeyCycle_motionTarget = 13;
        public static final int KeyCycle_transitionEasing = 14;
        public static final int KeyCycle_transitionPathRotate = 15;
        public static final int KeyCycle_waveOffset = 16;
        public static final int KeyCycle_wavePeriod = 17;
        public static final int KeyCycle_wavePhase = 18;
        public static final int KeyCycle_waveShape = 19;
        public static final int KeyCycle_waveVariesBy = 20;
        public static final int KeyPosition_curveFit = 0;
        public static final int KeyPosition_drawPath = 1;
        public static final int KeyPosition_framePosition = 2;
        public static final int KeyPosition_keyPositionType = 3;
        public static final int KeyPosition_motionTarget = 4;
        public static final int KeyPosition_pathMotionArc = 5;
        public static final int KeyPosition_percentHeight = 6;
        public static final int KeyPosition_percentWidth = 7;
        public static final int KeyPosition_percentX = 8;
        public static final int KeyPosition_percentY = 9;
        public static final int KeyPosition_sizePercent = 10;
        public static final int KeyPosition_transitionEasing = 11;
        public static final int KeyTimeCycle_android_alpha = 0;
        public static final int KeyTimeCycle_android_elevation = 9;
        public static final int KeyTimeCycle_android_rotation = 5;
        public static final int KeyTimeCycle_android_rotationX = 6;
        public static final int KeyTimeCycle_android_rotationY = 7;
        public static final int KeyTimeCycle_android_scaleX = 3;
        public static final int KeyTimeCycle_android_scaleY = 4;
        public static final int KeyTimeCycle_android_translationX = 1;
        public static final int KeyTimeCycle_android_translationY = 2;
        public static final int KeyTimeCycle_android_translationZ = 8;
        public static final int KeyTimeCycle_curveFit = 10;
        public static final int KeyTimeCycle_framePosition = 11;
        public static final int KeyTimeCycle_motionProgress = 12;
        public static final int KeyTimeCycle_motionTarget = 13;
        public static final int KeyTimeCycle_transitionEasing = 14;
        public static final int KeyTimeCycle_transitionPathRotate = 15;
        public static final int KeyTimeCycle_waveDecay = 16;
        public static final int KeyTimeCycle_waveOffset = 17;
        public static final int KeyTimeCycle_wavePeriod = 18;
        public static final int KeyTimeCycle_wavePhase = 19;
        public static final int KeyTimeCycle_waveShape = 20;
        public static final int KeyTrigger_framePosition = 0;
        public static final int KeyTrigger_motionTarget = 1;
        public static final int KeyTrigger_motion_postLayoutCollision = 2;
        public static final int KeyTrigger_motion_triggerOnCollision = 3;
        public static final int KeyTrigger_onCross = 4;
        public static final int KeyTrigger_onNegativeCross = 5;
        public static final int KeyTrigger_onPositiveCross = 6;
        public static final int KeyTrigger_triggerId = 7;
        public static final int KeyTrigger_triggerReceiver = 8;
        public static final int KeyTrigger_triggerSlack = 9;
        public static final int KeyTrigger_viewTransitionOnCross = 10;
        public static final int KeyTrigger_viewTransitionOnNegativeCross = 11;
        public static final int KeyTrigger_viewTransitionOnPositiveCross = 12;
        public static final int Layout_android_layout_height = 2;
        public static final int Layout_android_layout_marginBottom = 6;
        public static final int Layout_android_layout_marginEnd = 8;
        public static final int Layout_android_layout_marginLeft = 3;
        public static final int Layout_android_layout_marginRight = 5;
        public static final int Layout_android_layout_marginStart = 7;
        public static final int Layout_android_layout_marginTop = 4;
        public static final int Layout_android_layout_width = 1;
        public static final int Layout_android_orientation = 0;
        public static final int Layout_barrierAllowsGoneWidgets = 9;
        public static final int Layout_barrierDirection = 10;
        public static final int Layout_barrierMargin = 11;
        public static final int Layout_chainUseRtl = 12;
        public static final int Layout_constraint_referenced_ids = 13;
        public static final int Layout_constraint_referenced_tags = 14;
        public static final int Layout_guidelineUseRtl = 15;
        public static final int Layout_layout_constrainedHeight = 16;
        public static final int Layout_layout_constrainedWidth = 17;
        public static final int Layout_layout_constraintBaseline_creator = 18;
        public static final int Layout_layout_constraintBaseline_toBaselineOf = 19;
        public static final int Layout_layout_constraintBaseline_toBottomOf = 20;
        public static final int Layout_layout_constraintBaseline_toTopOf = 21;
        public static final int Layout_layout_constraintBottom_creator = 22;
        public static final int Layout_layout_constraintBottom_toBottomOf = 23;
        public static final int Layout_layout_constraintBottom_toTopOf = 24;
        public static final int Layout_layout_constraintCircle = 25;
        public static final int Layout_layout_constraintCircleAngle = 26;
        public static final int Layout_layout_constraintCircleRadius = 27;
        public static final int Layout_layout_constraintDimensionRatio = 28;
        public static final int Layout_layout_constraintEnd_toEndOf = 29;
        public static final int Layout_layout_constraintEnd_toStartOf = 30;
        public static final int Layout_layout_constraintGuide_begin = 31;
        public static final int Layout_layout_constraintGuide_end = 32;
        public static final int Layout_layout_constraintGuide_percent = 33;
        public static final int Layout_layout_constraintHeight = 34;
        public static final int Layout_layout_constraintHeight_default = 35;
        public static final int Layout_layout_constraintHeight_max = 36;
        public static final int Layout_layout_constraintHeight_min = 37;
        public static final int Layout_layout_constraintHeight_percent = 38;
        public static final int Layout_layout_constraintHorizontal_bias = 39;
        public static final int Layout_layout_constraintHorizontal_chainStyle = 40;
        public static final int Layout_layout_constraintHorizontal_weight = 41;
        public static final int Layout_layout_constraintLeft_creator = 42;
        public static final int Layout_layout_constraintLeft_toLeftOf = 43;
        public static final int Layout_layout_constraintLeft_toRightOf = 44;
        public static final int Layout_layout_constraintRight_creator = 45;
        public static final int Layout_layout_constraintRight_toLeftOf = 46;
        public static final int Layout_layout_constraintRight_toRightOf = 47;
        public static final int Layout_layout_constraintStart_toEndOf = 48;
        public static final int Layout_layout_constraintStart_toStartOf = 49;
        public static final int Layout_layout_constraintTop_creator = 50;
        public static final int Layout_layout_constraintTop_toBottomOf = 51;
        public static final int Layout_layout_constraintTop_toTopOf = 52;
        public static final int Layout_layout_constraintVertical_bias = 53;
        public static final int Layout_layout_constraintVertical_chainStyle = 54;
        public static final int Layout_layout_constraintVertical_weight = 55;
        public static final int Layout_layout_constraintWidth = 56;
        public static final int Layout_layout_constraintWidth_default = 57;
        public static final int Layout_layout_constraintWidth_max = 58;
        public static final int Layout_layout_constraintWidth_min = 59;
        public static final int Layout_layout_constraintWidth_percent = 60;
        public static final int Layout_layout_editor_absoluteX = 61;
        public static final int Layout_layout_editor_absoluteY = 62;
        public static final int Layout_layout_goneMarginBaseline = 63;
        public static final int Layout_layout_goneMarginBottom = 64;
        public static final int Layout_layout_goneMarginEnd = 65;
        public static final int Layout_layout_goneMarginLeft = 66;
        public static final int Layout_layout_goneMarginRight = 67;
        public static final int Layout_layout_goneMarginStart = 68;
        public static final int Layout_layout_goneMarginTop = 69;
        public static final int Layout_layout_marginBaseline = 70;
        public static final int Layout_layout_wrapBehaviorInParent = 71;
        public static final int Layout_maxHeight = 72;
        public static final int Layout_maxWidth = 73;
        public static final int Layout_minHeight = 74;
        public static final int Layout_minWidth = 75;
        public static final int LinearLayoutCompat_Layout_android_layout_gravity = 0;
        public static final int LinearLayoutCompat_Layout_android_layout_height = 2;
        public static final int LinearLayoutCompat_Layout_android_layout_weight = 3;
        public static final int LinearLayoutCompat_Layout_android_layout_width = 1;
        public static final int LinearLayoutCompat_android_baselineAligned = 2;
        public static final int LinearLayoutCompat_android_baselineAlignedChildIndex = 3;
        public static final int LinearLayoutCompat_android_gravity = 0;
        public static final int LinearLayoutCompat_android_orientation = 1;
        public static final int LinearLayoutCompat_android_weightSum = 4;
        public static final int LinearLayoutCompat_divider = 5;
        public static final int LinearLayoutCompat_dividerPadding = 6;
        public static final int LinearLayoutCompat_measureWithLargestChild = 7;
        public static final int LinearLayoutCompat_showDividers = 8;
        public static final int ListPopupWindow_android_dropDownHorizontalOffset = 0;
        public static final int ListPopupWindow_android_dropDownVerticalOffset = 1;
        public static final int LoadingImageView_circleCrop = 0;
        public static final int LoadingImageView_imageAspectRatio = 1;
        public static final int LoadingImageView_imageAspectRatioAdjust = 2;
        public static final int MenuGroup_android_checkableBehavior = 5;
        public static final int MenuGroup_android_enabled = 0;
        public static final int MenuGroup_android_id = 1;
        public static final int MenuGroup_android_menuCategory = 3;
        public static final int MenuGroup_android_orderInCategory = 4;
        public static final int MenuGroup_android_visible = 2;
        public static final int MenuItem_actionLayout = 13;
        public static final int MenuItem_actionProviderClass = 14;
        public static final int MenuItem_actionViewClass = 15;
        public static final int MenuItem_alphabeticModifiers = 16;
        public static final int MenuItem_android_alphabeticShortcut = 9;
        public static final int MenuItem_android_checkable = 11;
        public static final int MenuItem_android_checked = 3;
        public static final int MenuItem_android_enabled = 1;
        public static final int MenuItem_android_icon = 0;
        public static final int MenuItem_android_id = 2;
        public static final int MenuItem_android_menuCategory = 5;
        public static final int MenuItem_android_numericShortcut = 10;
        public static final int MenuItem_android_onClick = 12;
        public static final int MenuItem_android_orderInCategory = 6;
        public static final int MenuItem_android_title = 7;
        public static final int MenuItem_android_titleCondensed = 8;
        public static final int MenuItem_android_visible = 4;
        public static final int MenuItem_contentDescription = 17;
        public static final int MenuItem_iconTint = 18;
        public static final int MenuItem_iconTintMode = 19;
        public static final int MenuItem_numericModifiers = 20;
        public static final int MenuItem_showAsAction = 21;
        public static final int MenuItem_tooltipText = 22;
        public static final int MenuView_android_headerBackground = 4;
        public static final int MenuView_android_horizontalDivider = 2;
        public static final int MenuView_android_itemBackground = 5;
        public static final int MenuView_android_itemIconDisabledAlpha = 6;
        public static final int MenuView_android_itemTextAppearance = 1;
        public static final int MenuView_android_verticalDivider = 3;
        public static final int MenuView_android_windowAnimationStyle = 0;
        public static final int MenuView_preserveIconSpacing = 7;
        public static final int MenuView_subMenuArrow = 8;
        public static final int MockView_mock_diagonalsColor = 0;
        public static final int MockView_mock_label = 1;
        public static final int MockView_mock_labelBackgroundColor = 2;
        public static final int MockView_mock_labelColor = 3;
        public static final int MockView_mock_showDiagonals = 4;
        public static final int MockView_mock_showLabel = 5;
        public static final int MotionEffect_motionEffect_alpha = 0;
        public static final int MotionEffect_motionEffect_end = 1;
        public static final int MotionEffect_motionEffect_move = 2;
        public static final int MotionEffect_motionEffect_start = 3;
        public static final int MotionEffect_motionEffect_strict = 4;
        public static final int MotionEffect_motionEffect_translationX = 5;
        public static final int MotionEffect_motionEffect_translationY = 6;
        public static final int MotionEffect_motionEffect_viewTransition = 7;
        public static final int MotionHelper_onHide = 0;
        public static final int MotionHelper_onShow = 1;
        public static final int MotionLabel_android_autoSizeTextType = 8;
        public static final int MotionLabel_android_fontFamily = 7;
        public static final int MotionLabel_android_gravity = 4;
        public static final int MotionLabel_android_shadowRadius = 6;
        public static final int MotionLabel_android_text = 5;
        public static final int MotionLabel_android_textColor = 3;
        public static final int MotionLabel_android_textSize = 0;
        public static final int MotionLabel_android_textStyle = 2;
        public static final int MotionLabel_android_typeface = 1;
        public static final int MotionLabel_borderRound = 9;
        public static final int MotionLabel_borderRoundPercent = 10;
        public static final int MotionLabel_scaleFromTextSize = 11;
        public static final int MotionLabel_textBackground = 12;
        public static final int MotionLabel_textBackgroundPanX = 13;
        public static final int MotionLabel_textBackgroundPanY = 14;
        public static final int MotionLabel_textBackgroundRotate = 15;
        public static final int MotionLabel_textBackgroundZoom = 16;
        public static final int MotionLabel_textOutlineColor = 17;
        public static final int MotionLabel_textOutlineThickness = 18;
        public static final int MotionLabel_textPanX = 19;
        public static final int MotionLabel_textPanY = 20;
        public static final int MotionLabel_textureBlurFactor = 21;
        public static final int MotionLabel_textureEffect = 22;
        public static final int MotionLabel_textureHeight = 23;
        public static final int MotionLabel_textureWidth = 24;
        public static final int MotionLayout_applyMotionScene = 0;
        public static final int MotionLayout_currentState = 1;
        public static final int MotionLayout_layoutDescription = 2;
        public static final int MotionLayout_motionDebug = 3;
        public static final int MotionLayout_motionProgress = 4;
        public static final int MotionLayout_showPaths = 5;
        public static final int MotionScene_defaultDuration = 0;
        public static final int MotionScene_layoutDuringTransition = 1;
        public static final int MotionTelltales_telltales_tailColor = 0;
        public static final int MotionTelltales_telltales_tailScale = 1;
        public static final int MotionTelltales_telltales_velocityMode = 2;
        public static final int Motion_animateCircleAngleTo = 0;
        public static final int Motion_animateRelativeTo = 1;
        public static final int Motion_drawPath = 2;
        public static final int Motion_motionPathRotate = 3;
        public static final int Motion_motionStagger = 4;
        public static final int Motion_pathMotionArc = 5;
        public static final int Motion_quantizeMotionInterpolator = 6;
        public static final int Motion_quantizeMotionPhase = 7;
        public static final int Motion_quantizeMotionSteps = 8;
        public static final int Motion_transitionEasing = 9;
        public static final int OnClick_clickAction = 0;
        public static final int OnClick_targetId = 1;
        public static final int OnSwipe_autoCompleteMode = 0;
        public static final int OnSwipe_dragDirection = 1;
        public static final int OnSwipe_dragScale = 2;
        public static final int OnSwipe_dragThreshold = 3;
        public static final int OnSwipe_limitBoundsTo = 4;
        public static final int OnSwipe_maxAcceleration = 5;
        public static final int OnSwipe_maxVelocity = 6;
        public static final int OnSwipe_moveWhenScrollAtTop = 7;
        public static final int OnSwipe_nestedScrollFlags = 8;
        public static final int OnSwipe_onTouchUp = 9;
        public static final int OnSwipe_rotationCenterId = 10;
        public static final int OnSwipe_springBoundary = 11;
        public static final int OnSwipe_springDamping = 12;
        public static final int OnSwipe_springMass = 13;
        public static final int OnSwipe_springStiffness = 14;
        public static final int OnSwipe_springStopThreshold = 15;
        public static final int OnSwipe_touchAnchorId = 16;
        public static final int OnSwipe_touchAnchorSide = 17;
        public static final int OnSwipe_touchRegionId = 18;
        public static final int PopupWindowBackgroundState_state_above_anchor = 0;
        public static final int PopupWindow_android_popupAnimationStyle = 1;
        public static final int PopupWindow_android_popupBackground = 0;
        public static final int PopupWindow_overlapAnchor = 2;
        public static final int PropertySet_android_alpha = 1;
        public static final int PropertySet_android_visibility = 0;
        public static final int PropertySet_layout_constraintTag = 2;
        public static final int PropertySet_motionProgress = 3;
        public static final int PropertySet_visibilityMode = 4;
        public static final int RecycleListView_paddingBottomNoButtons = 0;
        public static final int RecycleListView_paddingTopNoTitle = 1;
        public static final int SearchView_android_focusable = 0;
        public static final int SearchView_android_imeOptions = 3;
        public static final int SearchView_android_inputType = 2;
        public static final int SearchView_android_maxWidth = 1;
        public static final int SearchView_closeIcon = 4;
        public static final int SearchView_commitIcon = 5;
        public static final int SearchView_defaultQueryHint = 6;
        public static final int SearchView_goIcon = 7;
        public static final int SearchView_iconifiedByDefault = 8;
        public static final int SearchView_layout = 9;
        public static final int SearchView_queryBackground = 10;
        public static final int SearchView_queryHint = 11;
        public static final int SearchView_searchHintIcon = 12;
        public static final int SearchView_searchIcon = 13;
        public static final int SearchView_submitBackground = 14;
        public static final int SearchView_suggestionRowLayout = 15;
        public static final int SearchView_voiceIcon = 16;
        public static final int SignInButton_buttonSize = 0;
        public static final int SignInButton_colorScheme = 1;
        public static final int SignInButton_scopeUris = 2;
        public static final int Spinner_android_dropDownWidth = 3;
        public static final int Spinner_android_entries = 0;
        public static final int Spinner_android_popupBackground = 1;
        public static final int Spinner_android_prompt = 2;
        public static final int Spinner_popupTheme = 4;
        public static final int StateListDrawableItem_android_drawable = 0;
        public static final int StateListDrawable_android_constantSize = 3;
        public static final int StateListDrawable_android_dither = 0;
        public static final int StateListDrawable_android_enterFadeDuration = 4;
        public static final int StateListDrawable_android_exitFadeDuration = 5;
        public static final int StateListDrawable_android_variablePadding = 2;
        public static final int StateListDrawable_android_visible = 1;
        public static final int StateSet_defaultState = 0;
        public static final int State_android_id = 0;
        public static final int State_constraints = 1;
        public static final int SwitchCompat_android_textOff = 1;
        public static final int SwitchCompat_android_textOn = 0;
        public static final int SwitchCompat_android_thumb = 2;
        public static final int SwitchCompat_showText = 3;
        public static final int SwitchCompat_splitTrack = 4;
        public static final int SwitchCompat_switchMinWidth = 5;
        public static final int SwitchCompat_switchPadding = 6;
        public static final int SwitchCompat_switchTextAppearance = 7;
        public static final int SwitchCompat_thumbTextPadding = 8;
        public static final int SwitchCompat_thumbTint = 9;
        public static final int SwitchCompat_thumbTintMode = 10;
        public static final int SwitchCompat_track = 11;
        public static final int SwitchCompat_trackTint = 12;
        public static final int SwitchCompat_trackTintMode = 13;
        public static final int TextAppearance_android_fontFamily = 10;
        public static final int TextAppearance_android_shadowColor = 6;
        public static final int TextAppearance_android_shadowDx = 7;
        public static final int TextAppearance_android_shadowDy = 8;
        public static final int TextAppearance_android_shadowRadius = 9;
        public static final int TextAppearance_android_textColor = 3;
        public static final int TextAppearance_android_textColorHint = 4;
        public static final int TextAppearance_android_textColorLink = 5;
        public static final int TextAppearance_android_textFontWeight = 11;
        public static final int TextAppearance_android_textSize = 0;
        public static final int TextAppearance_android_textStyle = 2;
        public static final int TextAppearance_android_typeface = 1;
        public static final int TextAppearance_fontFamily = 12;
        public static final int TextAppearance_fontVariationSettings = 13;
        public static final int TextAppearance_textAllCaps = 14;
        public static final int TextAppearance_textLocale = 15;
        public static final int TextEffects_android_fontFamily = 8;
        public static final int TextEffects_android_shadowColor = 4;
        public static final int TextEffects_android_shadowDx = 5;
        public static final int TextEffects_android_shadowDy = 6;
        public static final int TextEffects_android_shadowRadius = 7;
        public static final int TextEffects_android_text = 3;
        public static final int TextEffects_android_textSize = 0;
        public static final int TextEffects_android_textStyle = 2;
        public static final int TextEffects_android_typeface = 1;
        public static final int TextEffects_borderRound = 9;
        public static final int TextEffects_borderRoundPercent = 10;
        public static final int TextEffects_textFillColor = 11;
        public static final int TextEffects_textOutlineColor = 12;
        public static final int TextEffects_textOutlineThickness = 13;
        public static final int Toolbar_android_gravity = 0;
        public static final int Toolbar_android_minHeight = 1;
        public static final int Toolbar_buttonGravity = 2;
        public static final int Toolbar_collapseContentDescription = 3;
        public static final int Toolbar_collapseIcon = 4;
        public static final int Toolbar_contentInsetEnd = 5;
        public static final int Toolbar_contentInsetEndWithActions = 6;
        public static final int Toolbar_contentInsetLeft = 7;
        public static final int Toolbar_contentInsetRight = 8;
        public static final int Toolbar_contentInsetStart = 9;
        public static final int Toolbar_contentInsetStartWithNavigation = 10;
        public static final int Toolbar_logo = 11;
        public static final int Toolbar_logoDescription = 12;
        public static final int Toolbar_maxButtonHeight = 13;
        public static final int Toolbar_menu = 14;
        public static final int Toolbar_navigationContentDescription = 15;
        public static final int Toolbar_navigationIcon = 16;
        public static final int Toolbar_popupTheme = 17;
        public static final int Toolbar_subtitle = 18;
        public static final int Toolbar_subtitleTextAppearance = 19;
        public static final int Toolbar_subtitleTextColor = 20;
        public static final int Toolbar_title = 21;
        public static final int Toolbar_titleMargin = 22;
        public static final int Toolbar_titleMarginBottom = 23;
        public static final int Toolbar_titleMarginEnd = 24;
        public static final int Toolbar_titleMarginStart = 25;
        public static final int Toolbar_titleMarginTop = 26;
        public static final int Toolbar_titleMargins = 27;
        public static final int Toolbar_titleTextAppearance = 28;
        public static final int Toolbar_titleTextColor = 29;
        public static final int Transform_android_elevation = 10;
        public static final int Transform_android_rotation = 6;
        public static final int Transform_android_rotationX = 7;
        public static final int Transform_android_rotationY = 8;
        public static final int Transform_android_scaleX = 4;
        public static final int Transform_android_scaleY = 5;
        public static final int Transform_android_transformPivotX = 0;
        public static final int Transform_android_transformPivotY = 1;
        public static final int Transform_android_translationX = 2;
        public static final int Transform_android_translationY = 3;
        public static final int Transform_android_translationZ = 9;
        public static final int Transform_transformPivotTarget = 11;
        public static final int Transition_android_id = 0;
        public static final int Transition_autoTransition = 1;
        public static final int Transition_constraintSetEnd = 2;
        public static final int Transition_constraintSetStart = 3;
        public static final int Transition_duration = 4;
        public static final int Transition_layoutDuringTransition = 5;
        public static final int Transition_motionInterpolator = 6;
        public static final int Transition_pathMotionArc = 7;
        public static final int Transition_staggered = 8;
        public static final int Transition_transitionDisable = 9;
        public static final int Transition_transitionFlags = 10;
        public static final int Variant_constraints = 0;
        public static final int Variant_region_heightLessThan = 1;
        public static final int Variant_region_heightMoreThan = 2;
        public static final int Variant_region_widthLessThan = 3;
        public static final int Variant_region_widthMoreThan = 4;
        public static final int ViewBackgroundHelper_android_background = 0;
        public static final int ViewBackgroundHelper_backgroundTint = 1;
        public static final int ViewBackgroundHelper_backgroundTintMode = 2;
        public static final int ViewStubCompat_android_id = 0;
        public static final int ViewStubCompat_android_inflatedId = 2;
        public static final int ViewStubCompat_android_layout = 1;
        public static final int ViewTransition_SharedValue = 1;
        public static final int ViewTransition_SharedValueId = 2;
        public static final int ViewTransition_android_id = 0;
        public static final int ViewTransition_clearsTag = 3;
        public static final int ViewTransition_duration = 4;
        public static final int ViewTransition_ifTagNotSet = 5;
        public static final int ViewTransition_ifTagSet = 6;
        public static final int ViewTransition_motionInterpolator = 7;
        public static final int ViewTransition_motionTarget = 8;
        public static final int ViewTransition_onStateTransition = 9;
        public static final int ViewTransition_pathMotionArc = 10;
        public static final int ViewTransition_setsTag = 11;
        public static final int ViewTransition_transitionDisable = 12;
        public static final int ViewTransition_upDuration = 13;
        public static final int ViewTransition_viewTransitionMode = 14;
        public static final int View_android_focusable = 1;
        public static final int View_android_theme = 0;
        public static final int View_paddingEnd = 2;
        public static final int View_paddingStart = 3;
        public static final int View_theme = 4;
        public static final int include_constraintSet = 0;
        public static final int[] ActionBar = {C1287R.attr.background, C1287R.attr.backgroundSplit, C1287R.attr.backgroundStacked, C1287R.attr.contentInsetEnd, C1287R.attr.contentInsetEndWithActions, C1287R.attr.contentInsetLeft, C1287R.attr.contentInsetRight, C1287R.attr.contentInsetStart, C1287R.attr.contentInsetStartWithNavigation, C1287R.attr.customNavigationLayout, C1287R.attr.displayOptions, C1287R.attr.divider, C1287R.attr.elevation, C1287R.attr.height, C1287R.attr.hideOnContentScroll, C1287R.attr.homeAsUpIndicator, C1287R.attr.homeLayout, C1287R.attr.icon, C1287R.attr.indeterminateProgressStyle, C1287R.attr.itemPadding, C1287R.attr.logo, C1287R.attr.navigationMode, C1287R.attr.popupTheme, C1287R.attr.progressBarPadding, C1287R.attr.progressBarStyle, C1287R.attr.subtitle, C1287R.attr.subtitleTextStyle, C1287R.attr.title, C1287R.attr.titleTextStyle};
        public static final int[] ActionBarLayout = {android.R.attr.layout_gravity};
        public static final int[] ActionMenuItemView = {android.R.attr.minWidth};
        public static final int[] ActionMenuView = new int[0];
        public static final int[] ActionMode = {C1287R.attr.background, C1287R.attr.backgroundSplit, C1287R.attr.closeItemLayout, C1287R.attr.height, C1287R.attr.subtitleTextStyle, C1287R.attr.titleTextStyle};
        public static final int[] ActivityChooserView = {C1287R.attr.expandActivityOverflowButtonDrawable, C1287R.attr.initialActivityCount};
        public static final int[] AlertDialog = {android.R.attr.layout, C1287R.attr.buttonIconDimen, C1287R.attr.buttonPanelSideLayout, C1287R.attr.listItemLayout, C1287R.attr.listLayout, C1287R.attr.multiChoiceItemLayout, C1287R.attr.showTitle, C1287R.attr.singleChoiceItemLayout};
        public static final int[] AnimatedStateListDrawableCompat = {android.R.attr.dither, android.R.attr.visible, android.R.attr.variablePadding, android.R.attr.constantSize, android.R.attr.enterFadeDuration, android.R.attr.exitFadeDuration};
        public static final int[] AnimatedStateListDrawableItem = {android.R.attr.id, android.R.attr.drawable};
        public static final int[] AnimatedStateListDrawableTransition = {android.R.attr.drawable, android.R.attr.toId, android.R.attr.fromId, android.R.attr.reversible};
        public static final int[] AppCompatEmojiHelper = new int[0];
        public static final int[] AppCompatImageView = {android.R.attr.src, C1287R.attr.srcCompat, C1287R.attr.tint, C1287R.attr.tintMode};
        public static final int[] AppCompatSeekBar = {android.R.attr.thumb, C1287R.attr.tickMark, C1287R.attr.tickMarkTint, C1287R.attr.tickMarkTintMode};
        public static final int[] AppCompatTextHelper = {android.R.attr.textAppearance, android.R.attr.drawableTop, android.R.attr.drawableBottom, android.R.attr.drawableLeft, android.R.attr.drawableRight, android.R.attr.drawableStart, android.R.attr.drawableEnd};
        public static final int[] AppCompatTextView = {android.R.attr.textAppearance, C1287R.attr.autoSizeMaxTextSize, C1287R.attr.autoSizeMinTextSize, C1287R.attr.autoSizePresetSizes, C1287R.attr.autoSizeStepGranularity, C1287R.attr.autoSizeTextType, C1287R.attr.drawableBottomCompat, C1287R.attr.drawableEndCompat, C1287R.attr.drawableLeftCompat, C1287R.attr.drawableRightCompat, C1287R.attr.drawableStartCompat, C1287R.attr.drawableTint, C1287R.attr.drawableTintMode, C1287R.attr.drawableTopCompat, C1287R.attr.emojiCompatEnabled, C1287R.attr.firstBaselineToTopHeight, C1287R.attr.fontFamily, C1287R.attr.fontVariationSettings, C1287R.attr.lastBaselineToBottomHeight, C1287R.attr.lineHeight, C1287R.attr.textAllCaps, C1287R.attr.textLocale};
        public static final int[] AppCompatTheme = {android.R.attr.windowIsFloating, android.R.attr.windowAnimationStyle, C1287R.attr.actionBarDivider, C1287R.attr.actionBarItemBackground, C1287R.attr.actionBarPopupTheme, C1287R.attr.actionBarSize, C1287R.attr.actionBarSplitStyle, C1287R.attr.actionBarStyle, C1287R.attr.actionBarTabBarStyle, C1287R.attr.actionBarTabStyle, C1287R.attr.actionBarTabTextStyle, C1287R.attr.actionBarTheme, C1287R.attr.actionBarWidgetTheme, C1287R.attr.actionButtonStyle, C1287R.attr.actionDropDownStyle, C1287R.attr.actionMenuTextAppearance, C1287R.attr.actionMenuTextColor, C1287R.attr.actionModeBackground, C1287R.attr.actionModeCloseButtonStyle, C1287R.attr.actionModeCloseContentDescription, C1287R.attr.actionModeCloseDrawable, C1287R.attr.actionModeCopyDrawable, C1287R.attr.actionModeCutDrawable, C1287R.attr.actionModeFindDrawable, C1287R.attr.actionModePasteDrawable, C1287R.attr.actionModePopupWindowStyle, C1287R.attr.actionModeSelectAllDrawable, C1287R.attr.actionModeShareDrawable, C1287R.attr.actionModeSplitBackground, C1287R.attr.actionModeStyle, C1287R.attr.actionModeTheme, C1287R.attr.actionModeWebSearchDrawable, C1287R.attr.actionOverflowButtonStyle, C1287R.attr.actionOverflowMenuStyle, C1287R.attr.activityChooserViewStyle, C1287R.attr.alertDialogButtonGroupStyle, C1287R.attr.alertDialogCenterButtons, C1287R.attr.alertDialogStyle, C1287R.attr.alertDialogTheme, C1287R.attr.autoCompleteTextViewStyle, C1287R.attr.borderlessButtonStyle, C1287R.attr.buttonBarButtonStyle, C1287R.attr.buttonBarNegativeButtonStyle, C1287R.attr.buttonBarNeutralButtonStyle, C1287R.attr.buttonBarPositiveButtonStyle, C1287R.attr.buttonBarStyle, C1287R.attr.buttonStyle, C1287R.attr.buttonStyleSmall, C1287R.attr.checkboxStyle, C1287R.attr.checkedTextViewStyle, C1287R.attr.colorAccent, C1287R.attr.colorBackgroundFloating, C1287R.attr.colorButtonNormal, C1287R.attr.colorControlActivated, C1287R.attr.colorControlHighlight, C1287R.attr.colorControlNormal, C1287R.attr.colorError, C1287R.attr.colorPrimary, C1287R.attr.colorPrimaryDark, C1287R.attr.colorSwitchThumbNormal, C1287R.attr.controlBackground, C1287R.attr.dialogCornerRadius, C1287R.attr.dialogPreferredPadding, C1287R.attr.dialogTheme, C1287R.attr.dividerHorizontal, C1287R.attr.dividerVertical, C1287R.attr.dropDownListViewStyle, C1287R.attr.dropdownListPreferredItemHeight, C1287R.attr.editTextBackground, C1287R.attr.editTextColor, C1287R.attr.editTextStyle, C1287R.attr.homeAsUpIndicator, C1287R.attr.imageButtonStyle, C1287R.attr.listChoiceBackgroundIndicator, C1287R.attr.listChoiceIndicatorMultipleAnimated, C1287R.attr.listChoiceIndicatorSingleAnimated, C1287R.attr.listDividerAlertDialog, C1287R.attr.listMenuViewStyle, C1287R.attr.listPopupWindowStyle, C1287R.attr.listPreferredItemHeight, C1287R.attr.listPreferredItemHeightLarge, C1287R.attr.listPreferredItemHeightSmall, C1287R.attr.listPreferredItemPaddingEnd, C1287R.attr.listPreferredItemPaddingLeft, C1287R.attr.listPreferredItemPaddingRight, C1287R.attr.listPreferredItemPaddingStart, C1287R.attr.panelBackground, C1287R.attr.panelMenuListTheme, C1287R.attr.panelMenuListWidth, C1287R.attr.popupMenuStyle, C1287R.attr.popupWindowStyle, C1287R.attr.radioButtonStyle, C1287R.attr.ratingBarStyle, C1287R.attr.ratingBarStyleIndicator, C1287R.attr.ratingBarStyleSmall, C1287R.attr.searchViewStyle, C1287R.attr.seekBarStyle, C1287R.attr.selectableItemBackground, C1287R.attr.selectableItemBackgroundBorderless, C1287R.attr.spinnerDropDownItemStyle, C1287R.attr.spinnerStyle, C1287R.attr.switchStyle, C1287R.attr.textAppearanceLargePopupMenu, C1287R.attr.textAppearanceListItem, C1287R.attr.textAppearanceListItemSecondary, C1287R.attr.textAppearanceListItemSmall, C1287R.attr.textAppearancePopupMenuHeader, C1287R.attr.textAppearanceSearchResultSubtitle, C1287R.attr.textAppearanceSearchResultTitle, C1287R.attr.textAppearanceSmallPopupMenu, C1287R.attr.textColorAlertDialogListItem, C1287R.attr.textColorSearchUrl, C1287R.attr.toolbarNavigationButtonStyle, C1287R.attr.toolbarStyle, C1287R.attr.tooltipForegroundColor, C1287R.attr.tooltipFrameBackground, C1287R.attr.viewInflaterClass, C1287R.attr.windowActionBar, C1287R.attr.windowActionBarOverlay, C1287R.attr.windowActionModeOverlay, C1287R.attr.windowFixedHeightMajor, C1287R.attr.windowFixedHeightMinor, C1287R.attr.windowFixedWidthMajor, C1287R.attr.windowFixedWidthMinor, C1287R.attr.windowMinWidthMajor, C1287R.attr.windowMinWidthMinor, C1287R.attr.windowNoTitle};
        public static final int[] ButtonBarLayout = {C1287R.attr.allowStacking};
        public static final int[] Capability = {C1287R.attr.queryPatterns, C1287R.attr.shortcutMatchRequired};
        public static final int[] Carousel = {C1287R.attr.carousel_backwardTransition, C1287R.attr.carousel_emptyViewsBehavior, C1287R.attr.carousel_firstView, C1287R.attr.carousel_forwardTransition, C1287R.attr.carousel_infinite, C1287R.attr.carousel_nextState, C1287R.attr.carousel_previousState, C1287R.attr.carousel_touchUpMode, C1287R.attr.carousel_touchUp_dampeningFactor, C1287R.attr.carousel_touchUp_velocityThreshold};
        public static final int[] CheckedTextView = {android.R.attr.checkMark, C1287R.attr.checkMarkCompat, C1287R.attr.checkMarkTint, C1287R.attr.checkMarkTintMode};
        public static final int[] ColorStateListItem = {android.R.attr.color, android.R.attr.alpha, android.R.attr.lStar, C1287R.attr.alpha, C1287R.attr.lStar};
        public static final int[] CompoundButton = {android.R.attr.button, C1287R.attr.buttonCompat, C1287R.attr.buttonTint, C1287R.attr.buttonTintMode};
        public static final int[] Constraint = {android.R.attr.orientation, android.R.attr.id, android.R.attr.visibility, android.R.attr.layout_width, android.R.attr.layout_height, android.R.attr.layout_marginLeft, android.R.attr.layout_marginTop, android.R.attr.layout_marginRight, android.R.attr.layout_marginBottom, android.R.attr.maxWidth, android.R.attr.maxHeight, android.R.attr.minWidth, android.R.attr.minHeight, android.R.attr.alpha, android.R.attr.transformPivotX, android.R.attr.transformPivotY, android.R.attr.translationX, android.R.attr.translationY, android.R.attr.scaleX, android.R.attr.scaleY, android.R.attr.rotation, android.R.attr.rotationX, android.R.attr.rotationY, android.R.attr.layout_marginStart, android.R.attr.layout_marginEnd, android.R.attr.translationZ, android.R.attr.elevation, C1287R.attr.animateCircleAngleTo, C1287R.attr.animateRelativeTo, C1287R.attr.barrierAllowsGoneWidgets, C1287R.attr.barrierDirection, C1287R.attr.barrierMargin, C1287R.attr.chainUseRtl, C1287R.attr.constraint_referenced_ids, C1287R.attr.constraint_referenced_tags, C1287R.attr.drawPath, C1287R.attr.flow_firstHorizontalBias, C1287R.attr.flow_firstHorizontalStyle, C1287R.attr.flow_firstVerticalBias, C1287R.attr.flow_firstVerticalStyle, C1287R.attr.flow_horizontalAlign, C1287R.attr.flow_horizontalBias, C1287R.attr.flow_horizontalGap, C1287R.attr.flow_horizontalStyle, C1287R.attr.flow_lastHorizontalBias, C1287R.attr.flow_lastHorizontalStyle, C1287R.attr.flow_lastVerticalBias, C1287R.attr.flow_lastVerticalStyle, C1287R.attr.flow_maxElementsWrap, C1287R.attr.flow_verticalAlign, C1287R.attr.flow_verticalBias, C1287R.attr.flow_verticalGap, C1287R.attr.flow_verticalStyle, C1287R.attr.flow_wrapMode, C1287R.attr.guidelineUseRtl, C1287R.attr.layout_constrainedHeight, C1287R.attr.layout_constrainedWidth, C1287R.attr.layout_constraintBaseline_creator, C1287R.attr.layout_constraintBaseline_toBaselineOf, C1287R.attr.layout_constraintBaseline_toBottomOf, C1287R.attr.layout_constraintBaseline_toTopOf, C1287R.attr.layout_constraintBottom_creator, C1287R.attr.layout_constraintBottom_toBottomOf, C1287R.attr.layout_constraintBottom_toTopOf, C1287R.attr.layout_constraintCircle, C1287R.attr.layout_constraintCircleAngle, C1287R.attr.layout_constraintCircleRadius, C1287R.attr.layout_constraintDimensionRatio, C1287R.attr.layout_constraintEnd_toEndOf, C1287R.attr.layout_constraintEnd_toStartOf, C1287R.attr.layout_constraintGuide_begin, C1287R.attr.layout_constraintGuide_end, C1287R.attr.layout_constraintGuide_percent, C1287R.attr.layout_constraintHeight, C1287R.attr.layout_constraintHeight_default, C1287R.attr.layout_constraintHeight_max, C1287R.attr.layout_constraintHeight_min, C1287R.attr.layout_constraintHeight_percent, C1287R.attr.layout_constraintHorizontal_bias, C1287R.attr.layout_constraintHorizontal_chainStyle, C1287R.attr.layout_constraintHorizontal_weight, C1287R.attr.layout_constraintLeft_creator, C1287R.attr.layout_constraintLeft_toLeftOf, C1287R.attr.layout_constraintLeft_toRightOf, C1287R.attr.layout_constraintRight_creator, C1287R.attr.layout_constraintRight_toLeftOf, C1287R.attr.layout_constraintRight_toRightOf, C1287R.attr.layout_constraintStart_toEndOf, C1287R.attr.layout_constraintStart_toStartOf, C1287R.attr.layout_constraintTag, C1287R.attr.layout_constraintTop_creator, C1287R.attr.layout_constraintTop_toBottomOf, C1287R.attr.layout_constraintTop_toTopOf, C1287R.attr.layout_constraintVertical_bias, C1287R.attr.layout_constraintVertical_chainStyle, C1287R.attr.layout_constraintVertical_weight, C1287R.attr.layout_constraintWidth, C1287R.attr.layout_constraintWidth_default, C1287R.attr.layout_constraintWidth_max, C1287R.attr.layout_constraintWidth_min, C1287R.attr.layout_constraintWidth_percent, C1287R.attr.layout_editor_absoluteX, C1287R.attr.layout_editor_absoluteY, C1287R.attr.layout_goneMarginBaseline, C1287R.attr.layout_goneMarginBottom, C1287R.attr.layout_goneMarginEnd, C1287R.attr.layout_goneMarginLeft, C1287R.attr.layout_goneMarginRight, C1287R.attr.layout_goneMarginStart, C1287R.attr.layout_goneMarginTop, C1287R.attr.layout_marginBaseline, C1287R.attr.layout_wrapBehaviorInParent, C1287R.attr.motionProgress, C1287R.attr.motionStagger, C1287R.attr.pathMotionArc, C1287R.attr.pivotAnchor, C1287R.attr.polarRelativeTo, C1287R.attr.quantizeMotionInterpolator, C1287R.attr.quantizeMotionPhase, C1287R.attr.quantizeMotionSteps, C1287R.attr.transformPivotTarget, C1287R.attr.transitionEasing, C1287R.attr.transitionPathRotate, C1287R.attr.visibilityMode};
        public static final int[] ConstraintLayout_Layout = {android.R.attr.orientation, android.R.attr.padding, android.R.attr.paddingLeft, android.R.attr.paddingTop, android.R.attr.paddingRight, android.R.attr.paddingBottom, android.R.attr.visibility, android.R.attr.layout_width, android.R.attr.layout_height, android.R.attr.layout_margin, android.R.attr.layout_marginLeft, android.R.attr.layout_marginTop, android.R.attr.layout_marginRight, android.R.attr.layout_marginBottom, android.R.attr.maxWidth, android.R.attr.maxHeight, android.R.attr.minWidth, android.R.attr.minHeight, android.R.attr.paddingStart, android.R.attr.paddingEnd, android.R.attr.layout_marginStart, android.R.attr.layout_marginEnd, android.R.attr.elevation, android.R.attr.layout_marginHorizontal, android.R.attr.layout_marginVertical, C1287R.attr.barrierAllowsGoneWidgets, C1287R.attr.barrierDirection, C1287R.attr.barrierMargin, C1287R.attr.chainUseRtl, C1287R.attr.circularflow_angles, C1287R.attr.circularflow_defaultAngle, C1287R.attr.circularflow_defaultRadius, C1287R.attr.circularflow_radiusInDP, C1287R.attr.circularflow_viewCenter, C1287R.attr.constraintSet, C1287R.attr.constraint_referenced_ids, C1287R.attr.constraint_referenced_tags, C1287R.attr.flow_firstHorizontalBias, C1287R.attr.flow_firstHorizontalStyle, C1287R.attr.flow_firstVerticalBias, C1287R.attr.flow_firstVerticalStyle, C1287R.attr.flow_horizontalAlign, C1287R.attr.flow_horizontalBias, C1287R.attr.flow_horizontalGap, C1287R.attr.flow_horizontalStyle, C1287R.attr.flow_lastHorizontalBias, C1287R.attr.flow_lastHorizontalStyle, C1287R.attr.flow_lastVerticalBias, C1287R.attr.flow_lastVerticalStyle, C1287R.attr.flow_maxElementsWrap, C1287R.attr.flow_verticalAlign, C1287R.attr.flow_verticalBias, C1287R.attr.flow_verticalGap, C1287R.attr.flow_verticalStyle, C1287R.attr.flow_wrapMode, C1287R.attr.guidelineUseRtl, C1287R.attr.layoutDescription, C1287R.attr.layout_constrainedHeight, C1287R.attr.layout_constrainedWidth, C1287R.attr.layout_constraintBaseline_creator, C1287R.attr.layout_constraintBaseline_toBaselineOf, C1287R.attr.layout_constraintBaseline_toBottomOf, C1287R.attr.layout_constraintBaseline_toTopOf, C1287R.attr.layout_constraintBottom_creator, C1287R.attr.layout_constraintBottom_toBottomOf, C1287R.attr.layout_constraintBottom_toTopOf, C1287R.attr.layout_constraintCircle, C1287R.attr.layout_constraintCircleAngle, C1287R.attr.layout_constraintCircleRadius, C1287R.attr.layout_constraintDimensionRatio, C1287R.attr.layout_constraintEnd_toEndOf, C1287R.attr.layout_constraintEnd_toStartOf, C1287R.attr.layout_constraintGuide_begin, C1287R.attr.layout_constraintGuide_end, C1287R.attr.layout_constraintGuide_percent, C1287R.attr.layout_constraintHeight, C1287R.attr.layout_constraintHeight_default, C1287R.attr.layout_constraintHeight_max, C1287R.attr.layout_constraintHeight_min, C1287R.attr.layout_constraintHeight_percent, C1287R.attr.layout_constraintHorizontal_bias, C1287R.attr.layout_constraintHorizontal_chainStyle, C1287R.attr.layout_constraintHorizontal_weight, C1287R.attr.layout_constraintLeft_creator, C1287R.attr.layout_constraintLeft_toLeftOf, C1287R.attr.layout_constraintLeft_toRightOf, C1287R.attr.layout_constraintRight_creator, C1287R.attr.layout_constraintRight_toLeftOf, C1287R.attr.layout_constraintRight_toRightOf, C1287R.attr.layout_constraintStart_toEndOf, C1287R.attr.layout_constraintStart_toStartOf, C1287R.attr.layout_constraintTag, C1287R.attr.layout_constraintTop_creator, C1287R.attr.layout_constraintTop_toBottomOf, C1287R.attr.layout_constraintTop_toTopOf, C1287R.attr.layout_constraintVertical_bias, C1287R.attr.layout_constraintVertical_chainStyle, C1287R.attr.layout_constraintVertical_weight, C1287R.attr.layout_constraintWidth, C1287R.attr.layout_constraintWidth_default, C1287R.attr.layout_constraintWidth_max, C1287R.attr.layout_constraintWidth_min, C1287R.attr.layout_constraintWidth_percent, C1287R.attr.layout_editor_absoluteX, C1287R.attr.layout_editor_absoluteY, C1287R.attr.layout_goneMarginBaseline, C1287R.attr.layout_goneMarginBottom, C1287R.attr.layout_goneMarginEnd, C1287R.attr.layout_goneMarginLeft, C1287R.attr.layout_goneMarginRight, C1287R.attr.layout_goneMarginStart, C1287R.attr.layout_goneMarginTop, C1287R.attr.layout_marginBaseline, C1287R.attr.layout_optimizationLevel, C1287R.attr.layout_wrapBehaviorInParent};
        public static final int[] ConstraintLayout_ReactiveGuide = {C1287R.attr.reactiveGuide_animateChange, C1287R.attr.reactiveGuide_applyToAllConstraintSets, C1287R.attr.reactiveGuide_applyToConstraintSet, C1287R.attr.reactiveGuide_valueId};
        public static final int[] ConstraintLayout_placeholder = {C1287R.attr.content, C1287R.attr.placeholder_emptyVisibility};
        public static final int[] ConstraintOverride = {android.R.attr.orientation, android.R.attr.id, android.R.attr.visibility, android.R.attr.layout_width, android.R.attr.layout_height, android.R.attr.layout_marginLeft, android.R.attr.layout_marginTop, android.R.attr.layout_marginRight, android.R.attr.layout_marginBottom, android.R.attr.maxWidth, android.R.attr.maxHeight, android.R.attr.minWidth, android.R.attr.minHeight, android.R.attr.alpha, android.R.attr.transformPivotX, android.R.attr.transformPivotY, android.R.attr.translationX, android.R.attr.translationY, android.R.attr.scaleX, android.R.attr.scaleY, android.R.attr.rotation, android.R.attr.rotationX, android.R.attr.rotationY, android.R.attr.layout_marginStart, android.R.attr.layout_marginEnd, android.R.attr.translationZ, android.R.attr.elevation, C1287R.attr.animateCircleAngleTo, C1287R.attr.animateRelativeTo, C1287R.attr.barrierAllowsGoneWidgets, C1287R.attr.barrierDirection, C1287R.attr.barrierMargin, C1287R.attr.chainUseRtl, C1287R.attr.constraint_referenced_ids, C1287R.attr.drawPath, C1287R.attr.flow_firstHorizontalBias, C1287R.attr.flow_firstHorizontalStyle, C1287R.attr.flow_firstVerticalBias, C1287R.attr.flow_firstVerticalStyle, C1287R.attr.flow_horizontalAlign, C1287R.attr.flow_horizontalBias, C1287R.attr.flow_horizontalGap, C1287R.attr.flow_horizontalStyle, C1287R.attr.flow_lastHorizontalBias, C1287R.attr.flow_lastHorizontalStyle, C1287R.attr.flow_lastVerticalBias, C1287R.attr.flow_lastVerticalStyle, C1287R.attr.flow_maxElementsWrap, C1287R.attr.flow_verticalAlign, C1287R.attr.flow_verticalBias, C1287R.attr.flow_verticalGap, C1287R.attr.flow_verticalStyle, C1287R.attr.flow_wrapMode, C1287R.attr.guidelineUseRtl, C1287R.attr.layout_constrainedHeight, C1287R.attr.layout_constrainedWidth, C1287R.attr.layout_constraintBaseline_creator, C1287R.attr.layout_constraintBottom_creator, C1287R.attr.layout_constraintCircleAngle, C1287R.attr.layout_constraintCircleRadius, C1287R.attr.layout_constraintDimensionRatio, C1287R.attr.layout_constraintGuide_begin, C1287R.attr.layout_constraintGuide_end, C1287R.attr.layout_constraintGuide_percent, C1287R.attr.layout_constraintHeight, C1287R.attr.layout_constraintHeight_default, C1287R.attr.layout_constraintHeight_max, C1287R.attr.layout_constraintHeight_min, C1287R.attr.layout_constraintHeight_percent, C1287R.attr.layout_constraintHorizontal_bias, C1287R.attr.layout_constraintHorizontal_chainStyle, C1287R.attr.layout_constraintHorizontal_weight, C1287R.attr.layout_constraintLeft_creator, C1287R.attr.layout_constraintRight_creator, C1287R.attr.layout_constraintTag, C1287R.attr.layout_constraintTop_creator, C1287R.attr.layout_constraintVertical_bias, C1287R.attr.layout_constraintVertical_chainStyle, C1287R.attr.layout_constraintVertical_weight, C1287R.attr.layout_constraintWidth, C1287R.attr.layout_constraintWidth_default, C1287R.attr.layout_constraintWidth_max, C1287R.attr.layout_constraintWidth_min, C1287R.attr.layout_constraintWidth_percent, C1287R.attr.layout_editor_absoluteX, C1287R.attr.layout_editor_absoluteY, C1287R.attr.layout_goneMarginBaseline, C1287R.attr.layout_goneMarginBottom, C1287R.attr.layout_goneMarginEnd, C1287R.attr.layout_goneMarginLeft, C1287R.attr.layout_goneMarginRight, C1287R.attr.layout_goneMarginStart, C1287R.attr.layout_goneMarginTop, C1287R.attr.layout_marginBaseline, C1287R.attr.layout_wrapBehaviorInParent, C1287R.attr.motionProgress, C1287R.attr.motionStagger, C1287R.attr.motionTarget, C1287R.attr.pathMotionArc, C1287R.attr.pivotAnchor, C1287R.attr.polarRelativeTo, C1287R.attr.quantizeMotionInterpolator, C1287R.attr.quantizeMotionPhase, C1287R.attr.quantizeMotionSteps, C1287R.attr.transformPivotTarget, C1287R.attr.transitionEasing, C1287R.attr.transitionPathRotate, C1287R.attr.visibilityMode};
        public static final int[] ConstraintSet = {android.R.attr.orientation, android.R.attr.id, android.R.attr.visibility, android.R.attr.layout_width, android.R.attr.layout_height, android.R.attr.layout_marginLeft, android.R.attr.layout_marginTop, android.R.attr.layout_marginRight, android.R.attr.layout_marginBottom, android.R.attr.maxWidth, android.R.attr.maxHeight, android.R.attr.minWidth, android.R.attr.minHeight, android.R.attr.pivotX, android.R.attr.pivotY, android.R.attr.alpha, android.R.attr.transformPivotX, android.R.attr.transformPivotY, android.R.attr.translationX, android.R.attr.translationY, android.R.attr.scaleX, android.R.attr.scaleY, android.R.attr.rotation, android.R.attr.rotationX, android.R.attr.rotationY, android.R.attr.layout_marginStart, android.R.attr.layout_marginEnd, android.R.attr.translationZ, android.R.attr.elevation, C1287R.attr.animateCircleAngleTo, C1287R.attr.animateRelativeTo, C1287R.attr.barrierAllowsGoneWidgets, C1287R.attr.barrierDirection, C1287R.attr.barrierMargin, C1287R.attr.chainUseRtl, C1287R.attr.constraintRotate, C1287R.attr.constraint_referenced_ids, C1287R.attr.constraint_referenced_tags, C1287R.attr.deriveConstraintsFrom, C1287R.attr.drawPath, C1287R.attr.flow_firstHorizontalBias, C1287R.attr.flow_firstHorizontalStyle, C1287R.attr.flow_firstVerticalBias, C1287R.attr.flow_firstVerticalStyle, C1287R.attr.flow_horizontalAlign, C1287R.attr.flow_horizontalBias, C1287R.attr.flow_horizontalGap, C1287R.attr.flow_horizontalStyle, C1287R.attr.flow_lastHorizontalBias, C1287R.attr.flow_lastHorizontalStyle, C1287R.attr.flow_lastVerticalBias, C1287R.attr.flow_lastVerticalStyle, C1287R.attr.flow_maxElementsWrap, C1287R.attr.flow_verticalAlign, C1287R.attr.flow_verticalBias, C1287R.attr.flow_verticalGap, C1287R.attr.flow_verticalStyle, C1287R.attr.flow_wrapMode, C1287R.attr.guidelineUseRtl, C1287R.attr.layout_constrainedHeight, C1287R.attr.layout_constrainedWidth, C1287R.attr.layout_constraintBaseline_creator, C1287R.attr.layout_constraintBaseline_toBaselineOf, C1287R.attr.layout_constraintBaseline_toBottomOf, C1287R.attr.layout_constraintBaseline_toTopOf, C1287R.attr.layout_constraintBottom_creator, C1287R.attr.layout_constraintBottom_toBottomOf, C1287R.attr.layout_constraintBottom_toTopOf, C1287R.attr.layout_constraintCircle, C1287R.attr.layout_constraintCircleAngle, C1287R.attr.layout_constraintCircleRadius, C1287R.attr.layout_constraintDimensionRatio, C1287R.attr.layout_constraintEnd_toEndOf, C1287R.attr.layout_constraintEnd_toStartOf, C1287R.attr.layout_constraintGuide_begin, C1287R.attr.layout_constraintGuide_end, C1287R.attr.layout_constraintGuide_percent, C1287R.attr.layout_constraintHeight_default, C1287R.attr.layout_constraintHeight_max, C1287R.attr.layout_constraintHeight_min, C1287R.attr.layout_constraintHeight_percent, C1287R.attr.layout_constraintHorizontal_bias, C1287R.attr.layout_constraintHorizontal_chainStyle, C1287R.attr.layout_constraintHorizontal_weight, C1287R.attr.layout_constraintLeft_creator, C1287R.attr.layout_constraintLeft_toLeftOf, C1287R.attr.layout_constraintLeft_toRightOf, C1287R.attr.layout_constraintRight_creator, C1287R.attr.layout_constraintRight_toLeftOf, C1287R.attr.layout_constraintRight_toRightOf, C1287R.attr.layout_constraintStart_toEndOf, C1287R.attr.layout_constraintStart_toStartOf, C1287R.attr.layout_constraintTag, C1287R.attr.layout_constraintTop_creator, C1287R.attr.layout_constraintTop_toBottomOf, C1287R.attr.layout_constraintTop_toTopOf, C1287R.attr.layout_constraintVertical_bias, C1287R.attr.layout_constraintVertical_chainStyle, C1287R.attr.layout_constraintVertical_weight, C1287R.attr.layout_constraintWidth_default, C1287R.attr.layout_constraintWidth_max, C1287R.attr.layout_constraintWidth_min, C1287R.attr.layout_constraintWidth_percent, C1287R.attr.layout_editor_absoluteX, C1287R.attr.layout_editor_absoluteY, C1287R.attr.layout_goneMarginBaseline, C1287R.attr.layout_goneMarginBottom, C1287R.attr.layout_goneMarginEnd, C1287R.attr.layout_goneMarginLeft, C1287R.attr.layout_goneMarginRight, C1287R.attr.layout_goneMarginStart, C1287R.attr.layout_goneMarginTop, C1287R.attr.layout_marginBaseline, C1287R.attr.layout_wrapBehaviorInParent, C1287R.attr.motionProgress, C1287R.attr.motionStagger, C1287R.attr.pathMotionArc, C1287R.attr.pivotAnchor, C1287R.attr.polarRelativeTo, C1287R.attr.quantizeMotionSteps, C1287R.attr.transitionEasing, C1287R.attr.transitionPathRotate};
        public static final int[] CustomAttribute = {C1287R.attr.attributeName, C1287R.attr.customBoolean, C1287R.attr.customColorDrawableValue, C1287R.attr.customColorValue, C1287R.attr.customDimension, C1287R.attr.customFloatValue, C1287R.attr.customIntegerValue, C1287R.attr.customPixelDimension, C1287R.attr.customReference, C1287R.attr.customStringValue, C1287R.attr.methodName};
        public static final int[] DrawerArrowToggle = {C1287R.attr.arrowHeadLength, C1287R.attr.arrowShaftLength, C1287R.attr.barLength, C1287R.attr.color, C1287R.attr.drawableSize, C1287R.attr.gapBetweenBars, C1287R.attr.spinBars, C1287R.attr.thickness};
        public static final int[] FontFamily = {C1287R.attr.fontProviderAuthority, C1287R.attr.fontProviderCerts, C1287R.attr.fontProviderFetchStrategy, C1287R.attr.fontProviderFetchTimeout, C1287R.attr.fontProviderPackage, C1287R.attr.fontProviderQuery, C1287R.attr.fontProviderSystemFontFamily};
        public static final int[] FontFamilyFont = {android.R.attr.font, android.R.attr.fontWeight, android.R.attr.fontStyle, android.R.attr.ttcIndex, android.R.attr.fontVariationSettings, C1287R.attr.font, C1287R.attr.fontStyle, C1287R.attr.fontVariationSettings, C1287R.attr.fontWeight, C1287R.attr.ttcIndex};
        public static final int[] Fragment = {android.R.attr.name, android.R.attr.id, android.R.attr.tag};
        public static final int[] FragmentContainerView = {android.R.attr.name, android.R.attr.tag};
        public static final int[] GradientColor = {android.R.attr.startColor, android.R.attr.endColor, android.R.attr.type, android.R.attr.centerX, android.R.attr.centerY, android.R.attr.gradientRadius, android.R.attr.tileMode, android.R.attr.centerColor, android.R.attr.startX, android.R.attr.startY, android.R.attr.endX, android.R.attr.endY};
        public static final int[] GradientColorItem = {android.R.attr.color, android.R.attr.offset};
        public static final int[] ImageFilterView = {C1287R.attr.altSrc, C1287R.attr.blendSrc, C1287R.attr.brightness, C1287R.attr.contrast, C1287R.attr.crossfade, C1287R.attr.imagePanX, C1287R.attr.imagePanY, C1287R.attr.imageRotate, C1287R.attr.imageZoom, C1287R.attr.overlay, C1287R.attr.round, C1287R.attr.roundPercent, C1287R.attr.saturation, C1287R.attr.warmth};
        public static final int[] KeyAttribute = {android.R.attr.alpha, android.R.attr.transformPivotX, android.R.attr.transformPivotY, android.R.attr.translationX, android.R.attr.translationY, android.R.attr.scaleX, android.R.attr.scaleY, android.R.attr.rotation, android.R.attr.rotationX, android.R.attr.rotationY, android.R.attr.translationZ, android.R.attr.elevation, C1287R.attr.curveFit, C1287R.attr.framePosition, C1287R.attr.motionProgress, C1287R.attr.motionTarget, C1287R.attr.transformPivotTarget, C1287R.attr.transitionEasing, C1287R.attr.transitionPathRotate};
        public static final int[] KeyCycle = {android.R.attr.alpha, android.R.attr.translationX, android.R.attr.translationY, android.R.attr.scaleX, android.R.attr.scaleY, android.R.attr.rotation, android.R.attr.rotationX, android.R.attr.rotationY, android.R.attr.translationZ, android.R.attr.elevation, C1287R.attr.curveFit, C1287R.attr.framePosition, C1287R.attr.motionProgress, C1287R.attr.motionTarget, C1287R.attr.transitionEasing, C1287R.attr.transitionPathRotate, C1287R.attr.waveOffset, C1287R.attr.wavePeriod, C1287R.attr.wavePhase, C1287R.attr.waveShape, C1287R.attr.waveVariesBy};
        public static final int[] KeyFrame = new int[0];
        public static final int[] KeyFramesAcceleration = new int[0];
        public static final int[] KeyFramesVelocity = new int[0];
        public static final int[] KeyPosition = {C1287R.attr.curveFit, C1287R.attr.drawPath, C1287R.attr.framePosition, C1287R.attr.keyPositionType, C1287R.attr.motionTarget, C1287R.attr.pathMotionArc, C1287R.attr.percentHeight, C1287R.attr.percentWidth, C1287R.attr.percentX, C1287R.attr.percentY, C1287R.attr.sizePercent, C1287R.attr.transitionEasing};
        public static final int[] KeyTimeCycle = {android.R.attr.alpha, android.R.attr.translationX, android.R.attr.translationY, android.R.attr.scaleX, android.R.attr.scaleY, android.R.attr.rotation, android.R.attr.rotationX, android.R.attr.rotationY, android.R.attr.translationZ, android.R.attr.elevation, C1287R.attr.curveFit, C1287R.attr.framePosition, C1287R.attr.motionProgress, C1287R.attr.motionTarget, C1287R.attr.transitionEasing, C1287R.attr.transitionPathRotate, C1287R.attr.waveDecay, C1287R.attr.waveOffset, C1287R.attr.wavePeriod, C1287R.attr.wavePhase, C1287R.attr.waveShape};
        public static final int[] KeyTrigger = {C1287R.attr.framePosition, C1287R.attr.motionTarget, C1287R.attr.motion_postLayoutCollision, C1287R.attr.motion_triggerOnCollision, C1287R.attr.onCross, C1287R.attr.onNegativeCross, C1287R.attr.onPositiveCross, C1287R.attr.triggerId, C1287R.attr.triggerReceiver, C1287R.attr.triggerSlack, C1287R.attr.viewTransitionOnCross, C1287R.attr.viewTransitionOnNegativeCross, C1287R.attr.viewTransitionOnPositiveCross};
        public static final int[] Layout = {android.R.attr.orientation, android.R.attr.layout_width, android.R.attr.layout_height, android.R.attr.layout_marginLeft, android.R.attr.layout_marginTop, android.R.attr.layout_marginRight, android.R.attr.layout_marginBottom, android.R.attr.layout_marginStart, android.R.attr.layout_marginEnd, C1287R.attr.barrierAllowsGoneWidgets, C1287R.attr.barrierDirection, C1287R.attr.barrierMargin, C1287R.attr.chainUseRtl, C1287R.attr.constraint_referenced_ids, C1287R.attr.constraint_referenced_tags, C1287R.attr.guidelineUseRtl, C1287R.attr.layout_constrainedHeight, C1287R.attr.layout_constrainedWidth, C1287R.attr.layout_constraintBaseline_creator, C1287R.attr.layout_constraintBaseline_toBaselineOf, C1287R.attr.layout_constraintBaseline_toBottomOf, C1287R.attr.layout_constraintBaseline_toTopOf, C1287R.attr.layout_constraintBottom_creator, C1287R.attr.layout_constraintBottom_toBottomOf, C1287R.attr.layout_constraintBottom_toTopOf, C1287R.attr.layout_constraintCircle, C1287R.attr.layout_constraintCircleAngle, C1287R.attr.layout_constraintCircleRadius, C1287R.attr.layout_constraintDimensionRatio, C1287R.attr.layout_constraintEnd_toEndOf, C1287R.attr.layout_constraintEnd_toStartOf, C1287R.attr.layout_constraintGuide_begin, C1287R.attr.layout_constraintGuide_end, C1287R.attr.layout_constraintGuide_percent, C1287R.attr.layout_constraintHeight, C1287R.attr.layout_constraintHeight_default, C1287R.attr.layout_constraintHeight_max, C1287R.attr.layout_constraintHeight_min, C1287R.attr.layout_constraintHeight_percent, C1287R.attr.layout_constraintHorizontal_bias, C1287R.attr.layout_constraintHorizontal_chainStyle, C1287R.attr.layout_constraintHorizontal_weight, C1287R.attr.layout_constraintLeft_creator, C1287R.attr.layout_constraintLeft_toLeftOf, C1287R.attr.layout_constraintLeft_toRightOf, C1287R.attr.layout_constraintRight_creator, C1287R.attr.layout_constraintRight_toLeftOf, C1287R.attr.layout_constraintRight_toRightOf, C1287R.attr.layout_constraintStart_toEndOf, C1287R.attr.layout_constraintStart_toStartOf, C1287R.attr.layout_constraintTop_creator, C1287R.attr.layout_constraintTop_toBottomOf, C1287R.attr.layout_constraintTop_toTopOf, C1287R.attr.layout_constraintVertical_bias, C1287R.attr.layout_constraintVertical_chainStyle, C1287R.attr.layout_constraintVertical_weight, C1287R.attr.layout_constraintWidth, C1287R.attr.layout_constraintWidth_default, C1287R.attr.layout_constraintWidth_max, C1287R.attr.layout_constraintWidth_min, C1287R.attr.layout_constraintWidth_percent, C1287R.attr.layout_editor_absoluteX, C1287R.attr.layout_editor_absoluteY, C1287R.attr.layout_goneMarginBaseline, C1287R.attr.layout_goneMarginBottom, C1287R.attr.layout_goneMarginEnd, C1287R.attr.layout_goneMarginLeft, C1287R.attr.layout_goneMarginRight, C1287R.attr.layout_goneMarginStart, C1287R.attr.layout_goneMarginTop, C1287R.attr.layout_marginBaseline, C1287R.attr.layout_wrapBehaviorInParent, C1287R.attr.maxHeight, C1287R.attr.maxWidth, C1287R.attr.minHeight, C1287R.attr.minWidth};
        public static final int[] LinearLayoutCompat = {android.R.attr.gravity, android.R.attr.orientation, android.R.attr.baselineAligned, android.R.attr.baselineAlignedChildIndex, android.R.attr.weightSum, C1287R.attr.divider, C1287R.attr.dividerPadding, C1287R.attr.measureWithLargestChild, C1287R.attr.showDividers};
        public static final int[] LinearLayoutCompat_Layout = {android.R.attr.layout_gravity, android.R.attr.layout_width, android.R.attr.layout_height, android.R.attr.layout_weight};
        public static final int[] ListPopupWindow = {android.R.attr.dropDownHorizontalOffset, android.R.attr.dropDownVerticalOffset};
        public static final int[] LoadingImageView = {C1287R.attr.circleCrop, C1287R.attr.imageAspectRatio, C1287R.attr.imageAspectRatioAdjust};
        public static final int[] MenuGroup = {android.R.attr.enabled, android.R.attr.id, android.R.attr.visible, android.R.attr.menuCategory, android.R.attr.orderInCategory, android.R.attr.checkableBehavior};
        public static final int[] MenuItem = {android.R.attr.icon, android.R.attr.enabled, android.R.attr.id, android.R.attr.checked, android.R.attr.visible, android.R.attr.menuCategory, android.R.attr.orderInCategory, android.R.attr.title, android.R.attr.titleCondensed, android.R.attr.alphabeticShortcut, android.R.attr.numericShortcut, android.R.attr.checkable, android.R.attr.onClick, C1287R.attr.actionLayout, C1287R.attr.actionProviderClass, C1287R.attr.actionViewClass, C1287R.attr.alphabeticModifiers, C1287R.attr.contentDescription, C1287R.attr.iconTint, C1287R.attr.iconTintMode, C1287R.attr.numericModifiers, C1287R.attr.showAsAction, C1287R.attr.tooltipText};
        public static final int[] MenuView = {android.R.attr.windowAnimationStyle, android.R.attr.itemTextAppearance, android.R.attr.horizontalDivider, android.R.attr.verticalDivider, android.R.attr.headerBackground, android.R.attr.itemBackground, android.R.attr.itemIconDisabledAlpha, C1287R.attr.preserveIconSpacing, C1287R.attr.subMenuArrow};
        public static final int[] MockView = {C1287R.attr.mock_diagonalsColor, C1287R.attr.mock_label, C1287R.attr.mock_labelBackgroundColor, C1287R.attr.mock_labelColor, C1287R.attr.mock_showDiagonals, C1287R.attr.mock_showLabel};
        public static final int[] Motion = {C1287R.attr.animateCircleAngleTo, C1287R.attr.animateRelativeTo, C1287R.attr.drawPath, C1287R.attr.motionPathRotate, C1287R.attr.motionStagger, C1287R.attr.pathMotionArc, C1287R.attr.quantizeMotionInterpolator, C1287R.attr.quantizeMotionPhase, C1287R.attr.quantizeMotionSteps, C1287R.attr.transitionEasing};
        public static final int[] MotionEffect = {C1287R.attr.motionEffect_alpha, C1287R.attr.motionEffect_end, C1287R.attr.motionEffect_move, C1287R.attr.motionEffect_start, C1287R.attr.motionEffect_strict, C1287R.attr.motionEffect_translationX, C1287R.attr.motionEffect_translationY, C1287R.attr.motionEffect_viewTransition};
        public static final int[] MotionHelper = {C1287R.attr.onHide, C1287R.attr.onShow};
        public static final int[] MotionLabel = {android.R.attr.textSize, android.R.attr.typeface, android.R.attr.textStyle, android.R.attr.textColor, android.R.attr.gravity, android.R.attr.text, android.R.attr.shadowRadius, android.R.attr.fontFamily, android.R.attr.autoSizeTextType, C1287R.attr.borderRound, C1287R.attr.borderRoundPercent, C1287R.attr.scaleFromTextSize, C1287R.attr.textBackground, C1287R.attr.textBackgroundPanX, C1287R.attr.textBackgroundPanY, C1287R.attr.textBackgroundRotate, C1287R.attr.textBackgroundZoom, C1287R.attr.textOutlineColor, C1287R.attr.textOutlineThickness, C1287R.attr.textPanX, C1287R.attr.textPanY, C1287R.attr.textureBlurFactor, C1287R.attr.textureEffect, C1287R.attr.textureHeight, C1287R.attr.textureWidth};
        public static final int[] MotionLayout = {C1287R.attr.applyMotionScene, C1287R.attr.currentState, C1287R.attr.layoutDescription, C1287R.attr.motionDebug, C1287R.attr.motionProgress, C1287R.attr.showPaths};
        public static final int[] MotionScene = {C1287R.attr.defaultDuration, C1287R.attr.layoutDuringTransition};
        public static final int[] MotionTelltales = {C1287R.attr.telltales_tailColor, C1287R.attr.telltales_tailScale, C1287R.attr.telltales_velocityMode};
        public static final int[] OnClick = {C1287R.attr.clickAction, C1287R.attr.targetId};
        public static final int[] OnSwipe = {C1287R.attr.autoCompleteMode, C1287R.attr.dragDirection, C1287R.attr.dragScale, C1287R.attr.dragThreshold, C1287R.attr.limitBoundsTo, C1287R.attr.maxAcceleration, C1287R.attr.maxVelocity, C1287R.attr.moveWhenScrollAtTop, C1287R.attr.nestedScrollFlags, C1287R.attr.onTouchUp, C1287R.attr.rotationCenterId, C1287R.attr.springBoundary, C1287R.attr.springDamping, C1287R.attr.springMass, C1287R.attr.springStiffness, C1287R.attr.springStopThreshold, C1287R.attr.touchAnchorId, C1287R.attr.touchAnchorSide, C1287R.attr.touchRegionId};
        public static final int[] PopupWindow = {android.R.attr.popupBackground, android.R.attr.popupAnimationStyle, C1287R.attr.overlapAnchor};
        public static final int[] PopupWindowBackgroundState = {C1287R.attr.state_above_anchor};
        public static final int[] PropertySet = {android.R.attr.visibility, android.R.attr.alpha, C1287R.attr.layout_constraintTag, C1287R.attr.motionProgress, C1287R.attr.visibilityMode};
        public static final int[] RecycleListView = {C1287R.attr.paddingBottomNoButtons, C1287R.attr.paddingTopNoTitle};
        public static final int[] SearchView = {android.R.attr.focusable, android.R.attr.maxWidth, android.R.attr.inputType, android.R.attr.imeOptions, C1287R.attr.closeIcon, C1287R.attr.commitIcon, C1287R.attr.defaultQueryHint, C1287R.attr.goIcon, C1287R.attr.iconifiedByDefault, C1287R.attr.layout, C1287R.attr.queryBackground, C1287R.attr.queryHint, C1287R.attr.searchHintIcon, C1287R.attr.searchIcon, C1287R.attr.submitBackground, C1287R.attr.suggestionRowLayout, C1287R.attr.voiceIcon};
        public static final int[] SignInButton = {C1287R.attr.buttonSize, C1287R.attr.colorScheme, C1287R.attr.scopeUris};
        public static final int[] Spinner = {android.R.attr.entries, android.R.attr.popupBackground, android.R.attr.prompt, android.R.attr.dropDownWidth, C1287R.attr.popupTheme};
        public static final int[] State = {android.R.attr.id, C1287R.attr.constraints};
        public static final int[] StateListDrawable = {android.R.attr.dither, android.R.attr.visible, android.R.attr.variablePadding, android.R.attr.constantSize, android.R.attr.enterFadeDuration, android.R.attr.exitFadeDuration};
        public static final int[] StateListDrawableItem = {android.R.attr.drawable};
        public static final int[] StateSet = {C1287R.attr.defaultState};
        public static final int[] SwitchCompat = {android.R.attr.textOn, android.R.attr.textOff, android.R.attr.thumb, C1287R.attr.showText, C1287R.attr.splitTrack, C1287R.attr.switchMinWidth, C1287R.attr.switchPadding, C1287R.attr.switchTextAppearance, C1287R.attr.thumbTextPadding, C1287R.attr.thumbTint, C1287R.attr.thumbTintMode, C1287R.attr.track, C1287R.attr.trackTint, C1287R.attr.trackTintMode};
        public static final int[] TextAppearance = {android.R.attr.textSize, android.R.attr.typeface, android.R.attr.textStyle, android.R.attr.textColor, android.R.attr.textColorHint, android.R.attr.textColorLink, android.R.attr.shadowColor, android.R.attr.shadowDx, android.R.attr.shadowDy, android.R.attr.shadowRadius, android.R.attr.fontFamily, android.R.attr.textFontWeight, C1287R.attr.fontFamily, C1287R.attr.fontVariationSettings, C1287R.attr.textAllCaps, C1287R.attr.textLocale};
        public static final int[] TextEffects = {android.R.attr.textSize, android.R.attr.typeface, android.R.attr.textStyle, android.R.attr.text, android.R.attr.shadowColor, android.R.attr.shadowDx, android.R.attr.shadowDy, android.R.attr.shadowRadius, android.R.attr.fontFamily, C1287R.attr.borderRound, C1287R.attr.borderRoundPercent, C1287R.attr.textFillColor, C1287R.attr.textOutlineColor, C1287R.attr.textOutlineThickness};
        public static final int[] Toolbar = {android.R.attr.gravity, android.R.attr.minHeight, C1287R.attr.buttonGravity, C1287R.attr.collapseContentDescription, C1287R.attr.collapseIcon, C1287R.attr.contentInsetEnd, C1287R.attr.contentInsetEndWithActions, C1287R.attr.contentInsetLeft, C1287R.attr.contentInsetRight, C1287R.attr.contentInsetStart, C1287R.attr.contentInsetStartWithNavigation, C1287R.attr.logo, C1287R.attr.logoDescription, C1287R.attr.maxButtonHeight, C1287R.attr.menu, C1287R.attr.navigationContentDescription, C1287R.attr.navigationIcon, C1287R.attr.popupTheme, C1287R.attr.subtitle, C1287R.attr.subtitleTextAppearance, C1287R.attr.subtitleTextColor, C1287R.attr.title, C1287R.attr.titleMargin, C1287R.attr.titleMarginBottom, C1287R.attr.titleMarginEnd, C1287R.attr.titleMarginStart, C1287R.attr.titleMarginTop, C1287R.attr.titleMargins, C1287R.attr.titleTextAppearance, C1287R.attr.titleTextColor};
        public static final int[] Transform = {android.R.attr.transformPivotX, android.R.attr.transformPivotY, android.R.attr.translationX, android.R.attr.translationY, android.R.attr.scaleX, android.R.attr.scaleY, android.R.attr.rotation, android.R.attr.rotationX, android.R.attr.rotationY, android.R.attr.translationZ, android.R.attr.elevation, C1287R.attr.transformPivotTarget};
        public static final int[] Transition = {android.R.attr.id, C1287R.attr.autoTransition, C1287R.attr.constraintSetEnd, C1287R.attr.constraintSetStart, C1287R.attr.duration, C1287R.attr.layoutDuringTransition, C1287R.attr.motionInterpolator, C1287R.attr.pathMotionArc, C1287R.attr.staggered, C1287R.attr.transitionDisable, C1287R.attr.transitionFlags};
        public static final int[] Variant = {C1287R.attr.constraints, C1287R.attr.region_heightLessThan, C1287R.attr.region_heightMoreThan, C1287R.attr.region_widthLessThan, C1287R.attr.region_widthMoreThan};
        public static final int[] View = {android.R.attr.theme, android.R.attr.focusable, C1287R.attr.paddingEnd, C1287R.attr.paddingStart, C1287R.attr.theme};
        public static final int[] ViewBackgroundHelper = {android.R.attr.background, C1287R.attr.backgroundTint, C1287R.attr.backgroundTintMode};
        public static final int[] ViewStubCompat = {android.R.attr.id, android.R.attr.layout, android.R.attr.inflatedId};
        public static final int[] ViewTransition = {android.R.attr.id, C1287R.attr.SharedValue, C1287R.attr.SharedValueId, C1287R.attr.clearsTag, C1287R.attr.duration, C1287R.attr.ifTagNotSet, C1287R.attr.ifTagSet, C1287R.attr.motionInterpolator, C1287R.attr.motionTarget, C1287R.attr.onStateTransition, C1287R.attr.pathMotionArc, C1287R.attr.setsTag, C1287R.attr.transitionDisable, C1287R.attr.upDuration, C1287R.attr.viewTransitionMode};
        public static final int[] include = {C1287R.attr.constraintSet};

        private styleable() {
        }
    }

    /* renamed from: com.unity3d.player.R$xml */
    public static final class xml {
        public static final int eossdk_backup_rules = 2131820544;
        public static final int image_share_filepaths = 2131820545;

        private xml() {
        }
    }

    private C0934R() {
    }
}

// ===== FILE: com/unity3d/player/C0936S.java =====
package com.unity3d.player;

import android.content.Context;
import android.widget.EditText;

/* renamed from: com.unity3d.player.S */
/* loaded from: classes.dex */
final class C0936S extends AbstractC0916I {

    /* renamed from: h */
    DialogC0918J f519h;

    public C0936S(Context context, UnityPlayer unityPlayer) {
        super(context, unityPlayer);
    }

    @Override // com.unity3d.player.AbstractC0916I
    /* renamed from: a */
    public final void mo339a(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6) {
        DialogC0918J dialogC0918J = new DialogC0918J(this.f437a, this.f438b);
        this.f519h = dialogC0918J;
        dialogC0918J.m349a(this, z5, z6);
        this.f519h.setOnDismissListener(new DialogInterfaceOnDismissListenerC0926N(this));
        super.mo339a(str, i, z, z2, z3, z4, str2, i2, z5, z6);
        this.f438b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0928O(this));
        this.f439c.requestFocus();
        this.f519h.setOnCancelListener(new DialogInterfaceOnCancelListenerC0930P(this));
    }

    @Override // com.unity3d.player.AbstractC0916I
    /* renamed from: a */
    public final void mo341a(boolean z) {
        this.f440d = z;
        this.f519h.m350a(z);
    }

    @Override // com.unity3d.player.AbstractC0916I
    /* renamed from: c */
    public final void mo343c() {
        this.f519h.dismiss();
    }

    @Override // com.unity3d.player.AbstractC0916I
    protected EditText createEditText(AbstractC0916I abstractC0916I) {
        return new C0932Q(this.f437a, abstractC0916I);
    }

    @Override // com.unity3d.player.AbstractC0916I
    /* renamed from: e */
    public final void mo345e() {
        this.f519h.show();
    }

    protected void reportSoftInputArea() {
        if (this.f519h.isShowing()) {
            this.f438b.reportSoftInputArea(this.f519h.m348a());
        }
    }
}

// ===== FILE: com/unity3d/player/C0940U.java =====
package com.unity3d.player;

import android.database.ContentObserver;
import android.os.Handler;

/* renamed from: com.unity3d.player.U */
/* loaded from: classes.dex */
final class C0940U extends ContentObserver {

    /* renamed from: a */
    private InterfaceC0938T f521a;

    public C0940U(Handler handler, InterfaceC0938T interfaceC0938T) {
        super(handler);
        this.f521a = interfaceC0938T;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        InterfaceC0938T interfaceC0938T = this.f521a;
        if (interfaceC0938T != null) {
            ((OrientationLockListener) interfaceC0938T).m368b();
        }
    }
}

// ===== FILE: com/unity3d/player/C0941U0.java =====
package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.unity3d.player.U0 */
/* loaded from: classes.dex */
final class C0941U0 {

    /* renamed from: a */
    private UnityPlayer f522a;

    /* renamed from: c */
    private InterfaceC0939T0 f524c;

    /* renamed from: b */
    private Context f523b = null;

    /* renamed from: d */
    private final Semaphore f525d = new Semaphore(0);

    /* renamed from: e */
    private final ReentrantLock f526e = new ReentrantLock();

    /* renamed from: f */
    private SurfaceHolderCallbackC0925M0 f527f = null;

    /* renamed from: g */
    private int f528g = 2;

    /* renamed from: h */
    private boolean f529h = false;

    /* renamed from: i */
    private boolean f530i = false;

    C0941U0(UnityPlayer unityPlayer) {
        this.f522a = null;
        this.f522a = unityPlayer;
    }

    /* renamed from: a */
    public final void m376a() {
        this.f526e.lock();
        SurfaceHolderCallbackC0925M0 surfaceHolderCallbackC0925M0 = this.f527f;
        if (surfaceHolderCallbackC0925M0 != null) {
            surfaceHolderCallbackC0925M0.updateVideoLayout();
        }
        this.f526e.unlock();
    }

    /* renamed from: a */
    public final boolean m377a(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, InterfaceC0939T0 interfaceC0939T0) {
        this.f526e.lock();
        this.f524c = interfaceC0939T0;
        this.f523b = context;
        this.f525d.drainPermits();
        this.f528g = 2;
        runOnUiThread(new RunnableC0931P0(this, str, i, i2, i3, z, j, j2));
        boolean z2 = false;
        try {
            this.f526e.unlock();
            this.f525d.acquire();
            this.f526e.lock();
            if (this.f528g != 2) {
                z2 = true;
            }
        } catch (InterruptedException unused) {
        }
        runOnUiThread(new RunnableC0933Q0(this));
        runOnUiThread((!z2 || this.f528g == 3) ? new RunnableC0937S0(this) : new RunnableC0935R0(this));
        this.f526e.unlock();
        return z2;
    }

    /* renamed from: b */
    public final void m378b() {
        this.f526e.lock();
        SurfaceHolderCallbackC0925M0 surfaceHolderCallbackC0925M0 = this.f527f;
        if (surfaceHolderCallbackC0925M0 != null) {
            if (this.f528g == 0) {
                surfaceHolderCallbackC0925M0.cancelOnPrepare();
            } else if (this.f530i) {
                boolean m363a = surfaceHolderCallbackC0925M0.m363a();
                this.f529h = m363a;
                if (!m363a) {
                    this.f527f.pause();
                }
            }
        }
        this.f526e.unlock();
    }

    /* renamed from: c */
    public final void m379c() {
        this.f526e.lock();
        SurfaceHolderCallbackC0925M0 surfaceHolderCallbackC0925M0 = this.f527f;
        if (surfaceHolderCallbackC0925M0 != null && this.f530i && !this.f529h) {
            surfaceHolderCallbackC0925M0.start();
        }
        this.f526e.unlock();
    }

    protected void runOnUiThread(Runnable runnable) {
        Context context = this.f523b;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            AbstractC0990t.Log(5, "Not running from an Activity; Ignoring execution request...");
        }
    }
}

// ===== FILE: com/unity3d/player/C0942V.java =====
package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;

/* renamed from: com.unity3d.player.V */
/* loaded from: classes.dex */
final class C0942V {

    /* renamed from: a */
    private Context f531a;

    /* renamed from: b */
    private C0940U f532b;

    public C0942V(Context context) {
        this.f531a = context;
    }

    /* renamed from: a */
    public final void m380a() {
        if (this.f532b != null) {
            this.f531a.getContentResolver().unregisterContentObserver(this.f532b);
            this.f532b = null;
        }
    }

    /* renamed from: a */
    public final void m381a(InterfaceC0938T interfaceC0938T) {
        this.f532b = new C0940U(new Handler(Looper.getMainLooper()), interfaceC0938T);
        this.f531a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.f532b);
    }
}

// ===== FILE: com/unity3d/player/C0943W.java =====
package com.unity3d.player;

import android.os.Build;
import java.lang.Thread;
import java.util.Arrays;

/* renamed from: com.unity3d.player.W */
/* loaded from: classes.dex */
final class C0943W implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private volatile Thread.UncaughtExceptionHandler f533a;

    /* renamed from: b */
    private String f534b;

    C0943W() {
    }

    /* renamed from: a */
    static void m382a(String str) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof C0943W) {
            C0943W c0943w = (C0943W) defaultUncaughtExceptionHandler;
            int i = -1;
            int i2 = -1;
            while (true) {
                int indexOf = str.indexOf(47, i + 1);
                if (indexOf == -1) {
                    break;
                }
                i2 = i;
                i = indexOf;
            }
            c0943w.f534b = i2 < 0 ? "Unknown" : str.substring(i2 + 1);
        }
    }

    /* renamed from: a */
    final synchronized void m383a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == this) {
            return;
        }
        this.f533a = defaultUncaughtExceptionHandler;
        this.f534b = "Unknown";
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        try {
            Error error = new Error(String.format("FATAL EXCEPTION [%s]\n", thread.getName()) + String.format("Unity version     : %s\n", "2022.3.52f1") + String.format("Device model      : %s %s\n", Build.MANUFACTURER, Build.MODEL) + String.format("Device fingerprint: %s\n", Build.FINGERPRINT) + String.format("CPU supported ABI : %s\n", Arrays.toString(Build.SUPPORTED_ABIS)) + String.format("Build Type        : %s\n", "Release") + String.format("Scripting Backend : %s\n", "IL2CPP") + String.format("Libs loaded from  : %s\n", this.f534b) + String.format("Strip Engine Code : %s\n", Boolean.TRUE));
            error.setStackTrace(new StackTraceElement[0]);
            error.initCause(th);
            this.f533a.uncaughtException(thread, error);
        } catch (Throwable unused) {
            this.f533a.uncaughtException(thread, th);
        }
    }
}

// ===== FILE: com/unity3d/player/C0945Y.java =====
package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;

/* renamed from: com.unity3d.player.Y */
/* loaded from: classes.dex */
final class C0945Y extends FrameLayout {

    /* renamed from: a */
    private C0947a f536a;

    /* renamed from: b */
    private UnityPlayer f537b;

    /* renamed from: c */
    private C0901B f538c;

    public C0945Y(Context context, UnityPlayer unityPlayer) {
        super(context);
        int i;
        this.f538c = new C0901B(context);
        this.f537b = unityPlayer;
        C0947a c0947a = new C0947a(context, unityPlayer);
        this.f536a = c0947a;
        c0947a.setId(context.getResources().getIdentifier("unitySurfaceView", "id", context.getPackageName()));
        if (m385a()) {
            this.f536a.getHolder().setFormat(-3);
            this.f536a.setZOrderOnTop(true);
            i = 0;
        } else {
            this.f536a.getHolder().setFormat(-1);
            i = ViewCompat.MEASURED_STATE_MASK;
        }
        setBackgroundColor(i);
        this.f536a.getHolder().addCallback(new SurfaceHolderCallbackC0944X(this));
        this.f536a.setFocusable(true);
        this.f536a.setFocusableInTouchMode(true);
        this.f536a.setContentDescription(m384a(context));
        addView(this.f536a, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    /* renamed from: a */
    private static String m384a(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", TypedValues.Custom.S_STRING, context.getPackageName()));
    }

    /* renamed from: a */
    private static boolean m385a() {
        Activity activity = UnityPlayer.currentActivity;
        if (activity == null) {
            return false;
        }
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowIsTranslucent});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* renamed from: a */
    final void m386a(float f) {
        this.f536a.m389a(f);
    }

    /* renamed from: b */
    public final void m387b() {
        C0901B c0901b = this.f538c;
        UnityPlayer unityPlayer = this.f537b;
        PixelCopyOnPixelCopyFinishedListenerC0899A pixelCopyOnPixelCopyFinishedListenerC0899A = c0901b.f384b;
        if (pixelCopyOnPixelCopyFinishedListenerC0899A != null && pixelCopyOnPixelCopyFinishedListenerC0899A.getParent() != null) {
            unityPlayer.removeView(c0901b.f384b);
        }
        this.f538c.f384b = null;
    }

    /* renamed from: c */
    public final boolean m388c() {
        C0947a c0947a = this.f536a;
        return c0947a != null && c0947a.m390a();
    }
}

// ===== FILE: com/unity3d/player/C0947a.java =====
package com.unity3d.player;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.unity3d.player.a */
/* loaded from: classes.dex */
final class C0947a extends SurfaceView {

    /* renamed from: a */
    private float f540a;

    /* renamed from: b */
    private UnityPlayer f541b;

    public C0947a(Context context, UnityPlayer unityPlayer) {
        super(context);
        this.f541b = unityPlayer;
    }

    /* renamed from: a */
    public final void m389a(float f) {
        this.f540a = f;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i = f <= 0.0f ? -1 : -2;
        layoutParams.width = i;
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public final boolean m390a() {
        return this.f540a > 0.0f;
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (m390a()) {
            return this.f541b.injectEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f540a <= 0.0f) {
            super.onMeasure(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size <= 0 || size2 <= 0 || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            super.onMeasure(i, i2);
            return;
        }
        float f = size;
        float f2 = size2;
        float f3 = f / f2;
        float f4 = this.f540a;
        if (f3 < f4) {
            size2 = (int) (f / f4);
        } else {
            size = (int) (f2 * f4);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (m390a()) {
            return this.f541b.injectEvent(motionEvent);
        }
        return false;
    }
}

// ===== FILE: com/unity3d/player/C0953a0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.a0 */
/* loaded from: classes.dex */
final class C0953a0 implements InterfaceC0996w {

    /* renamed from: a */
    final /* synthetic */ RunnableC0955b0 f548a;

    C0953a0(RunnableC0955b0 runnableC0955b0) {
        this.f548a = runnableC0955b0;
    }

    /* renamed from: a */
    public final void m395a() {
        this.f548a.f568m.nativeSoftInputLostFocus();
        this.f548a.f568m.reportSoftInputStr(null, 1, false);
    }
}

// ===== FILE: com/unity3d/player/C0956c.java =====
package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStateUpdateListener;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.unity3d.player.c */
/* loaded from: classes.dex */
final class C0956c implements AssetPackStateUpdateListener {

    /* renamed from: a */
    private HashSet f569a;

    /* renamed from: b */
    private Looper f570b;

    /* renamed from: c */
    final /* synthetic */ C0968i f571c;

    public C0956c(C0968i c0968i, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback, Looper looper) {
        this.f571c = c0968i;
        HashSet hashSet = new HashSet();
        this.f569a = hashSet;
        hashSet.add(iAssetPackManagerDownloadStatusCallback);
        this.f570b = looper;
    }

    /* renamed from: a */
    public final synchronized void m396a(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.f569a.add(iAssetPackManagerDownloadStatusCallback);
    }

    public final void onStateUpdate(Object obj) {
        C0968i c0968i;
        HashSet hashSet;
        HashSet hashSet2;
        Object obj2;
        AssetPackState assetPackState = (AssetPackState) obj;
        synchronized (this) {
            if (assetPackState.status() == 4 || assetPackState.status() == 5 || assetPackState.status() == 0) {
                c0968i = C0968i.f599d;
                synchronized (c0968i) {
                    hashSet = this.f571c.f601b;
                    hashSet.remove(assetPackState.name());
                    hashSet2 = this.f571c.f601b;
                    if (hashSet2.isEmpty()) {
                        C0968i c0968i2 = this.f571c;
                        obj2 = c0968i2.f602c;
                        c0968i2.m402a(obj2);
                        this.f571c.f602c = null;
                    }
                }
            }
            if (this.f569a.size() != 0) {
                new Handler(this.f570b).post(new RunnableC0954b((Set) this.f569a.clone(), assetPackState.name(), assetPackState.status(), assetPackState.totalBytesToDownload(), assetPackState.bytesDownloaded(), assetPackState.transferProgressPercentage(), assetPackState.errorCode()));
            }
        }
    }
}

// ===== FILE: com/unity3d/player/C0959d0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.d0 */
/* loaded from: classes.dex */
final class C0959d0 implements InterfaceC0994v {

    /* renamed from: a */
    final /* synthetic */ RunnableC0963f0 f575a;

    C0959d0(RunnableC0963f0 runnableC0963f0) {
        this.f575a = runnableC0963f0;
    }
}

// ===== FILE: com/unity3d/player/C0960e.java =====
package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnSuccessListener;

/* renamed from: com.unity3d.player.e */
/* loaded from: classes.dex */
final class C0960e implements OnSuccessListener {

    /* renamed from: a */
    private IAssetPackManagerMobileDataConfirmationCallback f576a;

    /* renamed from: b */
    private Looper f577b = Looper.myLooper();

    public C0960e(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        this.f576a = iAssetPackManagerMobileDataConfirmationCallback;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        Integer num = (Integer) obj;
        if (this.f576a != null) {
            new Handler(this.f577b).post(new RunnableC0958d(this.f576a, num.intValue() == -1));
        }
    }
}

// ===== FILE: com/unity3d/player/C0961e0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.e0 */
/* loaded from: classes.dex */
final class C0961e0 implements InterfaceC0998x {

    /* renamed from: a */
    final /* synthetic */ RunnableC0963f0 f578a;

    C0961e0(RunnableC0963f0 runnableC0963f0) {
        this.f578a = runnableC0963f0;
    }

    /* renamed from: a */
    public final void m397a() {
        RunnableC0963f0 runnableC0963f0 = this.f578a;
        runnableC0963f0.f582a = true;
        if (runnableC0963f0.f583b) {
            runnableC0963f0.f584c.release();
        }
    }
}

// ===== FILE: com/unity3d/player/C0962f.java =====
package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.unity3d.player.f */
/* loaded from: classes.dex */
final class C0962f implements OnCompleteListener {

    /* renamed from: a */
    private IAssetPackManagerDownloadStatusCallback f579a;

    /* renamed from: b */
    private Looper f580b = Looper.myLooper();

    /* renamed from: c */
    private String f581c;

    public C0962f(String str, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.f579a = iAssetPackManagerDownloadStatusCallback;
        this.f581c = str;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        int errorCode;
        C0968i c0968i;
        C0968i c0968i2;
        Object obj;
        HashSet hashSet;
        AssetPackManager assetPackManager;
        AssetPackManager assetPackManager2;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map packStates = assetPackStates.packStates();
            if (packStates.size() == 0) {
                return;
            }
            for (AssetPackState assetPackState : packStates.values()) {
                if (assetPackState.errorCode() != 0 || assetPackState.status() == 4 || assetPackState.status() == 5 || assetPackState.status() == 0) {
                    String name = assetPackState.name();
                    int status = assetPackState.status();
                    int errorCode2 = assetPackState.errorCode();
                    long j = assetPackStates.totalBytes();
                    new Handler(this.f580b).post(new RunnableC0954b(Collections.singleton(this.f579a), name, status, j, status == 4 ? j : 0L, 0, errorCode2));
                } else {
                    c0968i = C0968i.f599d;
                    String name2 = assetPackState.name();
                    IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback = this.f579a;
                    Looper looper = this.f580b;
                    c0968i.getClass();
                    c0968i2 = C0968i.f599d;
                    synchronized (c0968i2) {
                        obj = c0968i.f602c;
                        if (obj == null) {
                            C0956c c0956c = new C0956c(c0968i, iAssetPackManagerDownloadStatusCallback, looper);
                            assetPackManager2 = c0968i.f600a;
                            assetPackManager2.registerListener(c0956c);
                            c0968i.f602c = c0956c;
                        } else {
                            ((C0956c) obj).m396a(iAssetPackManagerDownloadStatusCallback);
                        }
                        hashSet = c0968i.f601b;
                        hashSet.add(name2);
                        assetPackManager = c0968i.f600a;
                        assetPackManager.fetch(Collections.singletonList(name2));
                    }
                }
            }
        } catch (RuntimeExecutionException e) {
            e = e;
            String str = this.f581c;
            while (true) {
                if (e instanceof AssetPackException) {
                    errorCode = e.getErrorCode();
                    break;
                }
                e = e.getCause();
                if (e == null) {
                    errorCode = -100;
                    break;
                }
            }
            new Handler(this.f580b).post(new RunnableC0954b(Collections.singleton(this.f579a), str, 0, 0L, 0L, 0, errorCode));
        }
    }
}

// ===== FILE: com/unity3d/player/C0966h.java =====
package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Map;

/* renamed from: com.unity3d.player.h */
/* loaded from: classes.dex */
final class C0966h implements OnCompleteListener {

    /* renamed from: a */
    private IAssetPackManagerStatusQueryCallback f594a;

    /* renamed from: b */
    private Looper f595b = Looper.myLooper();

    /* renamed from: c */
    private String[] f596c;

    public C0966h(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        this.f594a = iAssetPackManagerStatusQueryCallback;
        this.f596c = strArr;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        int errorCode;
        if (this.f594a == null) {
            return;
        }
        int i = 0;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map packStates = assetPackStates.packStates();
            int size = packStates.size();
            String[] strArr = new String[size];
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            for (AssetPackState assetPackState : packStates.values()) {
                strArr[i] = assetPackState.name();
                iArr[i] = assetPackState.status();
                iArr2[i] = assetPackState.errorCode();
                i++;
            }
            new Handler(this.f595b).post(new RunnableC0964g(this.f594a, assetPackStates.totalBytes(), strArr, iArr, iArr2));
        } catch (RuntimeExecutionException e) {
            e = e;
            String message = e.getMessage();
            String[] strArr2 = this.f596c;
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                int i3 = -100;
                if (i2 >= length) {
                    String[] strArr3 = this.f596c;
                    int[] iArr3 = new int[strArr3.length];
                    int[] iArr4 = new int[strArr3.length];
                    for (int i4 = 0; i4 < this.f596c.length; i4++) {
                        iArr3[i4] = 0;
                        AssetPackException assetPackException = e;
                        while (true) {
                            if (assetPackException instanceof AssetPackException) {
                                errorCode = assetPackException.getErrorCode();
                                break;
                            }
                            assetPackException = assetPackException.getCause();
                            if (assetPackException == null) {
                                errorCode = -100;
                                break;
                            }
                        }
                        iArr4[i4] = errorCode;
                    }
                    new Handler(this.f595b).post(new RunnableC0964g(this.f594a, 0L, this.f596c, iArr3, iArr4));
                    return;
                }
                String str = strArr2[i2];
                if (message.contains(str)) {
                    Handler handler = new Handler(this.f595b);
                    IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback = this.f594a;
                    String[] strArr4 = {str};
                    int[] iArr5 = {0};
                    int[] iArr6 = new int[1];
                    while (true) {
                        if (!(e instanceof AssetPackException)) {
                            e = e.getCause();
                            if (e == null) {
                                break;
                            }
                        } else {
                            i3 = e.getErrorCode();
                            break;
                        }
                    }
                    iArr6[0] = i3;
                    handler.post(new RunnableC0964g(iAssetPackManagerStatusQueryCallback, 0L, strArr4, iArr5, iArr6));
                    return;
                }
                i2++;
            }
        }
    }
}

// ===== FILE: com/unity3d/player/C0968i.java =====
package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackLocation;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackManagerFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/* renamed from: com.unity3d.player.i */
/* loaded from: classes.dex */
final class C0968i {

    /* renamed from: d */
    private static C0968i f599d;

    /* renamed from: a */
    private AssetPackManager f600a;

    /* renamed from: b */
    private HashSet f601b;

    /* renamed from: c */
    private Object f602c;

    private C0968i(Context context) {
        if (f599d != null) {
            throw new RuntimeException("AssetPackManagerWrapper should be created only once. Use getInstance() instead.");
        }
        this.f600a = AssetPackManagerFactory.getInstance(context);
        this.f601b = new HashSet();
    }

    /* renamed from: a */
    public static C0968i m398a(Context context) {
        if (f599d == null) {
            f599d = new C0968i(context);
        }
        return f599d;
    }

    /* renamed from: a */
    public final Object m399a(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        C0956c c0956c = new C0956c(this, iAssetPackManagerDownloadStatusCallback, Looper.myLooper());
        this.f600a.registerListener(c0956c);
        return c0956c;
    }

    /* renamed from: a */
    public final String m400a(String str) {
        AssetPackLocation packLocation = this.f600a.getPackLocation(str);
        return packLocation == null ? "" : packLocation.assetsPath();
    }

    /* renamed from: a */
    public final void m401a(Activity activity, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        this.f600a.showCellularDataConfirmation(activity).addOnSuccessListener(new C0960e(iAssetPackManagerMobileDataConfirmationCallback));
    }

    /* renamed from: a */
    public final void m402a(Object obj) {
        if (obj instanceof C0956c) {
            this.f600a.unregisterListener((C0956c) obj);
        }
    }

    /* renamed from: a */
    public final void m403a(String[] strArr) {
        this.f600a.cancel(Arrays.asList(strArr));
    }

    /* renamed from: a */
    public final void m404a(String[] strArr, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        for (String str : strArr) {
            this.f600a.getPackStates(Collections.singletonList(str)).addOnCompleteListener(new C0962f(str, iAssetPackManagerDownloadStatusCallback));
        }
    }

    /* renamed from: a */
    public final void m405a(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        this.f600a.getPackStates(Arrays.asList(strArr)).addOnCompleteListener(new C0966h(strArr, iAssetPackManagerStatusQueryCallback));
    }

    /* renamed from: b */
    public final void m406b(String str) {
        this.f600a.removePack(str);
    }
}

// ===== FILE: com/unity3d/player/C0970j.java =====
package com.unity3d.player;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;

/* renamed from: com.unity3d.player.j */
/* loaded from: classes.dex */
final class C0970j extends ContentObserver {

    /* renamed from: a */
    private final InterfaceC0972k f605a;

    /* renamed from: b */
    private final AudioManager f606b;

    /* renamed from: c */
    private final int f607c;

    /* renamed from: d */
    private int f608d;

    public C0970j(Handler handler, AudioManager audioManager, InterfaceC0972k interfaceC0972k) {
        super(handler);
        this.f606b = audioManager;
        this.f607c = 3;
        this.f605a = interfaceC0972k;
        this.f608d = audioManager.getStreamVolume(3);
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri) {
        int streamVolume;
        AudioManager audioManager = this.f606b;
        if (audioManager == null || this.f605a == null || (streamVolume = audioManager.getStreamVolume(this.f607c)) == this.f608d) {
            return;
        }
        this.f608d = streamVolume;
        this.f605a.onAudioVolumeChanged(streamVolume);
    }
}

// ===== FILE: com/unity3d/player/C0973k0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.k0 */
/* loaded from: classes.dex */
final class C0973k0 extends AbstractRunnableC0917I0 {

    /* renamed from: b */
    final /* synthetic */ boolean f612b;

    /* renamed from: c */
    final /* synthetic */ String f613c;

    /* renamed from: d */
    final /* synthetic */ int f614d;

    /* renamed from: e */
    final /* synthetic */ UnityPlayer f615e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0973k0(UnityPlayer unityPlayer, boolean z, String str, int i) {
        super(unityPlayer);
        this.f615e = unityPlayer;
        this.f612b = z;
        this.f613c = str;
        this.f614d = i;
    }

    @Override // com.unity3d.player.AbstractRunnableC0917I0
    /* renamed from: a */
    public final void mo347a() {
        if (this.f612b) {
            this.f615e.nativeSoftInputCanceled();
        } else {
            String str = this.f613c;
            if (str != null) {
                this.f615e.nativeSetInputString(str);
            }
        }
        if (this.f614d == 1) {
            this.f615e.nativeSoftInputClosed();
        }
    }
}

// ===== FILE: com/unity3d/player/C0974l.java =====
package com.unity3d.player;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.unity3d.services.core.device.MimeTypes;

/* renamed from: com.unity3d.player.l */
/* loaded from: classes.dex */
final class C0974l {

    /* renamed from: a */
    private final Context f616a;

    /* renamed from: b */
    private final AudioManager f617b;

    /* renamed from: c */
    private C0970j f618c;

    public C0974l(Context context) {
        this.f616a = context;
        this.f617b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    /* renamed from: a */
    public final void m407a() {
        if (this.f618c != null) {
            this.f616a.getContentResolver().unregisterContentObserver(this.f618c);
            this.f618c = null;
        }
    }

    /* renamed from: a */
    public final void m408a(InterfaceC0972k interfaceC0972k) {
        this.f618c = new C0970j(new Handler(Looper.getMainLooper()), this.f617b, interfaceC0972k);
        this.f616a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.f618c);
    }
}

// ===== FILE: com/unity3d/player/C0975l0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.l0 */
/* loaded from: classes.dex */
final class C0975l0 extends AbstractRunnableC0917I0 {

    /* renamed from: b */
    final /* synthetic */ int f619b;

    /* renamed from: c */
    final /* synthetic */ int f620c;

    /* renamed from: d */
    final /* synthetic */ UnityPlayer f621d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0975l0(UnityPlayer unityPlayer, int i, int i2) {
        super(unityPlayer);
        this.f621d = unityPlayer;
        this.f619b = i;
        this.f620c = i2;
    }

    @Override // com.unity3d.player.AbstractRunnableC0917I0
    /* renamed from: a */
    public final void mo347a() {
        this.f621d.nativeSetInputSelection(this.f619b, this.f620c);
    }
}

// ===== FILE: com/unity3d/player/C0976m.java =====
package com.unity3d.player;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;

/* renamed from: com.unity3d.player.m */
/* loaded from: classes.dex */
final class C0976m extends CameraCaptureSession.CaptureCallback {

    /* renamed from: a */
    final /* synthetic */ C0986r f622a;

    C0976m(C0986r c0986r) {
        this.f622a = c0986r;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        this.f622a.m413a(captureRequest.getTag());
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public final void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        AbstractC0990t.Log(5, "Camera2: Capture session failed " + captureRequest.getTag() + " reason " + captureFailure.getReason());
        this.f622a.m413a(captureRequest.getTag());
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public final void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public final void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
    }
}

// ===== FILE: com/unity3d/player/C0978n.java =====
package com.unity3d.player;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import android.view.Surface;

/* renamed from: com.unity3d.player.n */
/* loaded from: classes.dex */
final class C0978n extends CameraCaptureSession.StateCallback {

    /* renamed from: a */
    final /* synthetic */ C0986r f624a;

    C0978n(C0986r c0986r) {
        this.f624a = c0986r;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        AbstractC0990t.Log(6, "Camera2: CaptureSession configuration failed.");
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        CameraDevice cameraDevice;
        Object obj;
        String str;
        CameraDevice cameraDevice2;
        CaptureRequest.Builder builder;
        Surface surface;
        CaptureRequest.Builder builder2;
        Range range;
        C0986r c0986r = this.f624a;
        cameraDevice = c0986r.f639b;
        if (cameraDevice == null) {
            return;
        }
        obj = c0986r.f656s;
        synchronized (obj) {
            C0986r c0986r2 = this.f624a;
            c0986r2.f655r = cameraCaptureSession;
            try {
                cameraDevice2 = c0986r2.f639b;
                c0986r2.f654q = cameraDevice2.createCaptureRequest(1);
                C0986r c0986r3 = this.f624a;
                builder = c0986r3.f654q;
                surface = c0986r3.f659v;
                builder.addTarget(surface);
                C0986r c0986r4 = this.f624a;
                builder2 = c0986r4.f654q;
                CaptureRequest.Key key = CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE;
                range = c0986r4.f651n;
                builder2.set(key, range);
                this.f624a.m423g();
            } catch (CameraAccessException e) {
                str = "Camera2: CameraAccessException " + e;
                AbstractC0990t.Log(6, str);
            } catch (IllegalStateException e2) {
                str = "Camera2: IllegalStateException " + e2;
                AbstractC0990t.Log(6, str);
            }
        }
    }
}

// ===== FILE: com/unity3d/player/C0979n0.java =====
package com.unity3d.player;

import android.graphics.Rect;

/* renamed from: com.unity3d.player.n0 */
/* loaded from: classes.dex */
final class C0979n0 extends AbstractRunnableC0917I0 {

    /* renamed from: b */
    final /* synthetic */ Rect f625b;

    /* renamed from: c */
    final /* synthetic */ UnityPlayer f626c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0979n0(UnityPlayer unityPlayer, Rect rect) {
        super(unityPlayer);
        this.f626c = unityPlayer;
        this.f625b = rect;
    }

    @Override // com.unity3d.player.AbstractRunnableC0917I0
    /* renamed from: a */
    public final void mo347a() {
        UnityPlayer unityPlayer = this.f626c;
        Rect rect = this.f625b;
        unityPlayer.nativeSetInputArea(rect.left, rect.top, rect.right, rect.bottom);
    }
}

// ===== FILE: com/unity3d/player/C0980o.java =====
package com.unity3d.player;

import android.hardware.camera2.CameraDevice;
import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.o */
/* loaded from: classes.dex */
final class C0980o extends CameraDevice.StateCallback {

    /* renamed from: a */
    final /* synthetic */ C0986r f627a;

    C0980o(C0986r c0986r) {
        this.f627a = c0986r;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onClosed(CameraDevice cameraDevice) {
        Semaphore semaphore;
        semaphore = C0986r.f636D;
        semaphore.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        Semaphore semaphore;
        AbstractC0990t.Log(5, "Camera2: CameraDevice disconnected.");
        this.f627a.m412a(cameraDevice);
        semaphore = C0986r.f636D;
        semaphore.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i) {
        Semaphore semaphore;
        AbstractC0990t.Log(6, "Camera2: Error opeining CameraDevice " + i);
        this.f627a.m412a(cameraDevice);
        semaphore = C0986r.f636D;
        semaphore.release();
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        Semaphore semaphore;
        this.f627a.f639b = cameraDevice;
        semaphore = C0986r.f636D;
        semaphore.release();
    }
}

// ===== FILE: com/unity3d/player/C0981o0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.o0 */
/* loaded from: classes.dex */
final class C0981o0 extends AbstractRunnableC0917I0 {

    /* renamed from: b */
    final /* synthetic */ boolean f628b;

    /* renamed from: c */
    final /* synthetic */ UnityPlayer f629c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0981o0(UnityPlayer unityPlayer, boolean z) {
        super(unityPlayer);
        this.f629c = unityPlayer;
        this.f628b = z;
    }

    @Override // com.unity3d.player.AbstractRunnableC0917I0
    /* renamed from: a */
    public final void mo347a() {
        this.f629c.nativeSetKeyboardIsVisible(this.f628b);
    }
}

// ===== FILE: com/unity3d/player/C0982p.java =====
package com.unity3d.player;

import android.media.Image;
import android.media.ImageReader;
import com.unity3d.player.p004a.InterfaceC0949b;
import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.p */
/* loaded from: classes.dex */
final class C0982p implements ImageReader.OnImageAvailableListener {

    /* renamed from: a */
    final /* synthetic */ C0986r f630a;

    C0982p(C0986r c0986r) {
        this.f630a = c0986r;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader imageReader) {
        Semaphore semaphore;
        Semaphore semaphore2;
        Image image;
        InterfaceC0949b interfaceC0949b;
        semaphore = C0986r.f636D;
        if (semaphore.tryAcquire()) {
            Image acquireNextImage = imageReader.acquireNextImage();
            if (acquireNextImage != null) {
                Image.Plane[] planes = acquireNextImage.getPlanes();
                if (acquireNextImage.getFormat() == 35 && planes != null && planes.length == 3) {
                    interfaceC0949b = this.f630a.f638a;
                    ((Camera2Wrapper) interfaceC0949b).m334a(planes[0].getBuffer(), planes[1].getBuffer(), planes[2].getBuffer(), planes[0].getRowStride(), planes[1].getRowStride(), planes[1].getPixelStride());
                } else {
                    AbstractC0990t.Log(6, "Camera2: Wrong image format.");
                }
                image = this.f630a.f653p;
                if (image != null) {
                    image.close();
                }
                this.f630a.f653p = acquireNextImage;
            }
            semaphore2 = C0986r.f636D;
            semaphore2.release();
        }
    }
}

// ===== FILE: com/unity3d/player/C0983p0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.p0 */
/* loaded from: classes.dex */
final class C0983p0 implements InterfaceC0939T0 {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f631a;

    C0983p0(UnityPlayer unityPlayer) {
        this.f631a = unityPlayer;
    }

    /* renamed from: a */
    public final void m409a() {
        this.f631a.mVideoPlayerProxy = null;
    }
}

// ===== FILE: com/unity3d/player/C0984q.java =====
package com.unity3d.player;

import android.graphics.SurfaceTexture;
import com.unity3d.player.p004a.InterfaceC0949b;

/* renamed from: com.unity3d.player.q */
/* loaded from: classes.dex */
final class C0984q implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a */
    final /* synthetic */ C0986r f632a;

    C0984q(C0986r c0986r) {
        this.f632a = c0986r;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        InterfaceC0949b interfaceC0949b;
        interfaceC0949b = this.f632a.f638a;
        ((Camera2Wrapper) interfaceC0949b).m333a(surfaceTexture);
    }
}

// ===== FILE: com/unity3d/player/C0986r.java =====
package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.Size;
import android.util.SizeF;
import android.view.Surface;
import androidx.room.RoomDatabase;
import com.unity3d.player.p004a.InterfaceC0949b;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: com.unity3d.player.r */
/* loaded from: classes.dex */
public final class C0986r {

    /* renamed from: B */
    private static CameraManager f634B;

    /* renamed from: C */
    private static String[] f635C;

    /* renamed from: D */
    private static Semaphore f636D = new Semaphore(1);

    /* renamed from: a */
    private InterfaceC0949b f638a;

    /* renamed from: b */
    private CameraDevice f639b;

    /* renamed from: c */
    private HandlerThread f640c;

    /* renamed from: d */
    private Handler f641d;

    /* renamed from: e */
    private Rect f642e;

    /* renamed from: f */
    private Rect f643f;

    /* renamed from: g */
    private int f644g;

    /* renamed from: h */
    private int f645h;

    /* renamed from: k */
    private int f648k;

    /* renamed from: l */
    private int f649l;

    /* renamed from: n */
    private Range f651n;

    /* renamed from: p */
    private Image f653p;

    /* renamed from: q */
    private CaptureRequest.Builder f654q;

    /* renamed from: t */
    private int f657t;

    /* renamed from: u */
    private SurfaceTexture f658u;

    /* renamed from: i */
    private float f646i = -1.0f;

    /* renamed from: j */
    private float f647j = -1.0f;

    /* renamed from: m */
    private boolean f650m = false;

    /* renamed from: o */
    private ImageReader f652o = null;

    /* renamed from: r */
    private CameraCaptureSession f655r = null;

    /* renamed from: s */
    private Object f656s = new Object();

    /* renamed from: v */
    private Surface f659v = null;

    /* renamed from: A */
    private int f637A = 3;

    /* renamed from: w */
    private CameraCaptureSession.CaptureCallback f660w = new C0976m(this);

    /* renamed from: x */
    private final CameraDevice.StateCallback f661x = new C0980o(this);

    /* renamed from: y */
    private final ImageReader.OnImageAvailableListener f662y = new C0982p(this);

    /* renamed from: z */
    private final SurfaceTexture.OnFrameAvailableListener f663z = new C0984q(this);

    protected C0986r(InterfaceC0949b interfaceC0949b) {
        this.f638a = null;
        this.f638a = interfaceC0949b;
        m420e();
    }

    /* renamed from: a */
    public static int m410a(Context context) {
        return m416b(context).length;
    }

    /* renamed from: a */
    public static int m411a(Context context, int i) {
        try {
            CameraCharacteristics cameraCharacteristics = m418c(context).getCameraCharacteristics(m416b(context)[i]);
            float[] fArr = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
            SizeF sizeF = (SizeF) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
            if (fArr.length > 0) {
                return (int) ((fArr[0] * 36.0f) / sizeF.getWidth());
            }
        } catch (CameraAccessException e) {
            AbstractC0990t.Log(6, "Camera2: CameraAccessException " + e);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m412a(CameraDevice cameraDevice) {
        synchronized (this.f656s) {
            this.f655r = null;
        }
        cameraDevice.close();
        this.f639b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m413a(Object obj) {
        if (obj != "Focus") {
            if (obj == "Cancel focus") {
                synchronized (this.f656s) {
                    if (this.f655r != null) {
                        m423g();
                    }
                }
                return;
            }
            return;
        }
        this.f650m = false;
        synchronized (this.f656s) {
            if (this.f655r != null) {
                try {
                    this.f654q.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                    this.f654q.setTag("Regular");
                    this.f655r.setRepeatingRequest(this.f654q.build(), this.f660w, this.f641d);
                } catch (CameraAccessException e) {
                    AbstractC0990t.Log(6, "Camera2: CameraAccessException " + e);
                }
            }
        }
    }

    /* renamed from: b */
    private void m414b() {
        try {
            Semaphore semaphore = f636D;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!semaphore.tryAcquire(4L, timeUnit)) {
                AbstractC0990t.Log(5, "Camera2: Timeout waiting to lock camera for closing.");
                return;
            }
            this.f639b.close();
            try {
                if (!f636D.tryAcquire(4L, timeUnit)) {
                    AbstractC0990t.Log(5, "Camera2: Timeout waiting to close camera.");
                }
            } catch (InterruptedException e) {
                AbstractC0990t.Log(6, "Camera2: Interrupted while waiting to close camera " + e);
            }
            this.f639b = null;
            f636D.release();
        } catch (InterruptedException e2) {
            AbstractC0990t.Log(6, "Camera2: Interrupted while trying to lock camera for closing " + e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
    
        if (r3.length != 0) goto L13;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] m415b(Context context, int i) {
        Size[] outputSizes;
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) m418c(context).getCameraCharacteristics(m416b(context)[i]).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                AbstractC0990t.Log(6, "Camera2: configuration map is not available.");
            } else {
                outputSizes = streamConfigurationMap.getOutputSizes(35);
                if (outputSizes != null) {
                }
            }
            outputSizes = null;
            if (outputSizes == null) {
                return null;
            }
            int[] iArr = new int[outputSizes.length * 2];
            for (int i2 = 0; i2 < outputSizes.length; i2++) {
                int i3 = i2 * 2;
                iArr[i3] = outputSizes[i2].getWidth();
                iArr[i3 + 1] = outputSizes[i2].getHeight();
            }
            return iArr;
        } catch (CameraAccessException e) {
            AbstractC0990t.Log(6, "Camera2: CameraAccessException " + e);
            return null;
        }
    }

    /* renamed from: b */
    private static String[] m416b(Context context) {
        if (f635C == null) {
            try {
                f635C = m418c(context).getCameraIdList();
            } catch (CameraAccessException e) {
                AbstractC0990t.Log(6, "Camera2: CameraAccessException " + e);
                f635C = new String[0];
            }
        }
        return f635C;
    }

    /* renamed from: c */
    public static int m417c(Context context, int i) {
        try {
            return ((Integer) m418c(context).getCameraCharacteristics(m416b(context)[i]).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        } catch (CameraAccessException e) {
            AbstractC0990t.Log(6, "Camera2: CameraAccessException " + e);
            return 0;
        }
    }

    /* renamed from: c */
    private static CameraManager m418c(Context context) {
        if (f634B == null) {
            f634B = (CameraManager) context.getSystemService("camera");
        }
        return f634B;
    }

    /* renamed from: d */
    public static boolean m419d(Context context, int i) {
        try {
            return ((Integer) m418c(context).getCameraCharacteristics(m416b(context)[i]).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() > 0;
        } catch (CameraAccessException e) {
            AbstractC0990t.Log(6, "Camera2: CameraAccessException " + e);
            return false;
        }
    }

    /* renamed from: e */
    private void m420e() {
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.f640c = handlerThread;
        handlerThread.start();
        this.f641d = new Handler(this.f640c.getLooper());
    }

    /* renamed from: e */
    public static boolean m421e(Context context, int i) {
        try {
            return ((Integer) m418c(context).getCameraCharacteristics(m416b(context)[i]).get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
        } catch (CameraAccessException e) {
            AbstractC0990t.Log(6, "Camera2: CameraAccessException " + e);
            return false;
        }
    }

    /* renamed from: f */
    private void m422f() {
        try {
            CameraCaptureSession cameraCaptureSession = this.f655r;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.stopRepeating();
                this.f654q.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                this.f654q.set(CaptureRequest.CONTROL_AF_MODE, 0);
                this.f654q.setTag("Cancel focus");
                this.f655r.capture(this.f654q.build(), this.f660w, this.f641d);
            }
        } catch (CameraAccessException e) {
            AbstractC0990t.Log(6, "Camera2: CameraAccessException " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m423g() {
        try {
            if (this.f645h != 0) {
                float f = this.f646i;
                if (f >= 0.0f && f <= 1.0f) {
                    float f2 = this.f647j;
                    if (f2 >= 0.0f && f2 <= 1.0f) {
                        this.f650m = true;
                        int width = this.f643f.width();
                        int i = (int) (((width - (r2 * 2)) * this.f646i) + this.f648k);
                        int height = this.f643f.height();
                        int i2 = (int) (((1.0d - this.f647j) * (height - (r3 * 2))) + this.f649l);
                        int max = Math.max(this.f644g + 1, Math.min(i, (this.f643f.width() - this.f644g) - 1));
                        int max2 = Math.max(this.f644g + 1, Math.min(i2, (this.f643f.height() - this.f644g) - 1));
                        CaptureRequest.Builder builder = this.f654q;
                        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
                        int i3 = this.f644g;
                        int i4 = i3 * 2;
                        builder.set(key, new MeteringRectangle[]{new MeteringRectangle(max - i3, max2 - i3, i4, i4, RoomDatabase.MAX_BIND_PARAMETER_CNT)});
                        this.f654q.set(CaptureRequest.CONTROL_AF_MODE, 1);
                        this.f654q.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                        this.f654q.setTag("Focus");
                        this.f655r.capture(this.f654q.build(), this.f660w, this.f641d);
                    }
                }
            }
            this.f654q.set(CaptureRequest.CONTROL_AF_MODE, 4);
            this.f654q.setTag("Regular");
            CameraCaptureSession cameraCaptureSession = this.f655r;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.setRepeatingRequest(this.f654q.build(), this.f660w, this.f641d);
            }
        } catch (CameraAccessException e) {
            AbstractC0990t.Log(6, "Camera2: CameraAccessException " + e);
        }
    }

    /* renamed from: a */
    public final void m424a() {
        if (this.f639b != null) {
            m430i();
            m414b();
            this.f660w = null;
            this.f659v = null;
            this.f658u = null;
            Image image = this.f653p;
            if (image != null) {
                image.close();
                this.f653p = null;
            }
            ImageReader imageReader = this.f652o;
            if (imageReader != null) {
                imageReader.close();
                this.f652o = null;
            }
        }
        this.f640c.quit();
        try {
            this.f640c.join(4000L);
            this.f640c = null;
            this.f641d = null;
        } catch (InterruptedException e) {
            this.f640c.interrupt();
            AbstractC0990t.Log(6, "Camera2: Interrupted while waiting for the background thread to finish " + e);
        }
    }

    /* renamed from: a */
    public final boolean m425a(float f, float f2) {
        if (this.f645h <= 0) {
            return false;
        }
        if (this.f650m) {
            AbstractC0990t.Log(5, "Camera2: Setting manual focus point already started.");
            return false;
        }
        this.f646i = f;
        this.f647j = f2;
        synchronized (this.f656s) {
            if (this.f655r != null && this.f637A != 2) {
                m422f();
            }
        }
        return true;
    }

    /* renamed from: a */
    public final boolean m426a(Context context, int i, int i2, int i3, int i4, int i5, Surface surface) {
        int i6 = i4;
        try {
            CameraCharacteristics cameraCharacteristics = f634B.getCameraCharacteristics(m416b(context)[i]);
            if (((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                AbstractC0990t.Log(5, "Camera2: only LEGACY hardware level is supported.");
            }
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            Size[] sizeArr = null;
            if (streamConfigurationMap == null) {
                AbstractC0990t.Log(6, "Camera2: configuration map is not available.");
            } else {
                Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
                if (outputSizes != null && outputSizes.length != 0) {
                    sizeArr = outputSizes;
                }
            }
            if (sizeArr == null || sizeArr.length == 0) {
                return false;
            }
            double d = i2;
            double d2 = i3;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            double d3 = Double.MAX_VALUE;
            while (i7 < sizeArr.length) {
                int width = sizeArr[i7].getWidth();
                int height = sizeArr[i7].getHeight();
                CameraCharacteristics cameraCharacteristics2 = cameraCharacteristics;
                double d4 = d;
                double abs = Math.abs(Math.log(d2 / height)) + Math.abs(Math.log(d / width));
                if (abs < d3) {
                    i8 = height;
                    d3 = abs;
                    i9 = width;
                }
                i7++;
                cameraCharacteristics = cameraCharacteristics2;
                d = d4;
            }
            CameraCharacteristics cameraCharacteristics3 = cameraCharacteristics;
            this.f642e = new Rect(0, 0, i9, i8);
            Range[] rangeArr = (Range[]) cameraCharacteristics3.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            if (rangeArr == null || rangeArr.length == 0) {
                AbstractC0990t.Log(6, "Camera2: target FPS ranges are not avialable.");
                return false;
            }
            int i10 = -1;
            int i11 = 0;
            double d5 = Double.MAX_VALUE;
            while (true) {
                if (i11 < rangeArr.length) {
                    int intValue = ((Integer) rangeArr[i11].getLower()).intValue();
                    int intValue2 = ((Integer) rangeArr[i11].getUpper()).intValue();
                    float f = i6;
                    if (f + 0.1f > intValue && f - 0.1f < intValue2) {
                        break;
                    }
                    if (r7 < d5) {
                        i10 = i11;
                        d5 = r7;
                    }
                    i11++;
                } else {
                    i6 = ((Integer) (i6 > ((Integer) rangeArr[i10].getUpper()).intValue() ? rangeArr[i10].getUpper() : rangeArr[i10].getLower())).intValue();
                }
            }
            this.f651n = new Range(Integer.valueOf(i6), Integer.valueOf(i6));
            try {
                Semaphore semaphore = f636D;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                if (!semaphore.tryAcquire(4L, timeUnit)) {
                    AbstractC0990t.Log(5, "Camera2: Timeout waiting to lock camera for opening.");
                    return false;
                }
                try {
                    f634B.openCamera(m416b(context)[i], this.f661x, this.f641d);
                    try {
                    } catch (InterruptedException e) {
                        AbstractC0990t.Log(6, "Camera2: Interrupted while waiting to open camera " + e);
                    }
                    if (!f636D.tryAcquire(4L, timeUnit)) {
                        AbstractC0990t.Log(5, "Camera2: Timeout waiting to open camera.");
                        return false;
                    }
                    f636D.release();
                    this.f657t = i5;
                    this.f659v = surface;
                    int intValue3 = ((Integer) cameraCharacteristics3.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue();
                    this.f645h = intValue3;
                    if (intValue3 > 0) {
                        this.f643f = (Rect) cameraCharacteristics3.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                        float width2 = this.f642e.width() / this.f642e.height();
                        if (width2 > r0.width() / this.f643f.height()) {
                            this.f648k = 0;
                            this.f649l = (int) ((this.f643f.height() - (this.f643f.width() / width2)) / 2.0f);
                        } else {
                            this.f649l = 0;
                            this.f648k = (int) ((this.f643f.width() - (this.f643f.height() * width2)) / 2.0f);
                        }
                        this.f644g = Math.min(this.f643f.width(), this.f643f.height()) / 20;
                    }
                    return this.f639b != null;
                } catch (CameraAccessException e2) {
                    AbstractC0990t.Log(6, "Camera2: CameraAccessException " + e2);
                    f636D.release();
                    return false;
                }
            } catch (InterruptedException e3) {
                AbstractC0990t.Log(6, "Camera2: Interrupted while trying to lock camera for opening " + e3);
                return false;
            }
        } catch (CameraAccessException e4) {
            AbstractC0990t.Log(6, "Camera2: CameraAccessException " + e4);
            return false;
        }
    }

    /* renamed from: c */
    public final Rect m427c() {
        return this.f642e;
    }

    /* renamed from: d */
    public final void m428d() {
        synchronized (this.f656s) {
            CameraCaptureSession cameraCaptureSession = this.f655r;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.stopRepeating();
                    this.f637A = 2;
                } catch (CameraAccessException e) {
                    AbstractC0990t.Log(6, "Camera2: CameraAccessException " + e);
                }
            }
        }
    }

    /* renamed from: h */
    public void m429h() {
        Surface surface;
        if (this.f657t != 0) {
            if (this.f659v == null) {
                SurfaceTexture surfaceTexture = new SurfaceTexture(this.f657t);
                this.f658u = surfaceTexture;
                surfaceTexture.setDefaultBufferSize(this.f642e.width(), this.f642e.height());
                this.f658u.setOnFrameAvailableListener(this.f663z, this.f641d);
                surface = new Surface(this.f658u);
                this.f659v = surface;
            }
        } else if (this.f659v == null && this.f652o == null) {
            ImageReader newInstance = ImageReader.newInstance(this.f642e.width(), this.f642e.height(), 35, 2);
            this.f652o = newInstance;
            newInstance.setOnImageAvailableListener(this.f662y, this.f641d);
            this.f653p = null;
            surface = this.f652o.getSurface();
            this.f659v = surface;
        }
        try {
            CameraCaptureSession cameraCaptureSession = this.f655r;
            if (cameraCaptureSession == null) {
                this.f639b.createCaptureSession(Arrays.asList(this.f659v), new C0978n(this), this.f641d);
            } else if (this.f637A == 2) {
                cameraCaptureSession.setRepeatingRequest(this.f654q.build(), this.f660w, this.f641d);
            }
            this.f637A = 1;
        } catch (CameraAccessException e) {
            AbstractC0990t.Log(6, "Camera2: CameraAccessException " + e);
        }
    }

    /* renamed from: i */
    public final void m430i() {
        synchronized (this.f656s) {
            CameraCaptureSession cameraCaptureSession = this.f655r;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.abortCaptures();
                } catch (CameraAccessException e) {
                    AbstractC0990t.Log(6, "Camera2: CameraAccessException " + e);
                }
                this.f655r.close();
                this.f655r = null;
                this.f637A = 3;
            }
        }
    }
}

// ===== FILE: com/unity3d/player/C0989s0.java =====
package com.unity3d.player;

import android.content.Context;
import android.view.OrientationEventListener;

/* renamed from: com.unity3d.player.s0 */
/* loaded from: classes.dex */
final class C0989s0 extends OrientationEventListener {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f665a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0989s0(UnityPlayer unityPlayer, Context context, int i) {
        super(context, i);
        this.f665a = unityPlayer;
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i) {
        int i2;
        UnityPlayer unityPlayer = this.f665a;
        C0914H0 c0914h0 = unityPlayer.m_MainThread;
        i2 = unityPlayer.mNaturalOrientation;
        c0914h0.f426f = i2;
        c0914h0.f427g = i;
        c0914h0.m335a(EnumC0910F0.f413j);
    }
}

// ===== FILE: com/unity3d/player/C0992u.java =====
package com.unity3d.player;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* renamed from: com.unity3d.player.u */
/* loaded from: classes.dex */
final class C0992u extends ConnectivityManager.NetworkCallback {

    /* renamed from: a */
    final /* synthetic */ NetworkConnectivityNougat f669a;

    C0992u(NetworkConnectivityNougat networkConnectivityNougat) {
        this.f669a = networkConnectivityNougat;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        NetworkConnectivityNougat networkConnectivityNougat;
        int i;
        super.onCapabilitiesChanged(network, networkCapabilities);
        if (networkCapabilities.hasTransport(0)) {
            networkConnectivityNougat = this.f669a;
            i = 1;
        } else {
            networkConnectivityNougat = this.f669a;
            i = 2;
        }
        networkConnectivityNougat.f491b = i;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        super.onLost(network);
        this.f669a.f491b = 0;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        super.onUnavailable();
        this.f669a.f491b = 0;
    }
}

// ===== FILE: com/unity3d/player/Camera2Wrapper.java =====
package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.view.Surface;
import com.unity3d.player.p004a.InterfaceC0949b;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class Camera2Wrapper implements InterfaceC0949b {

    /* renamed from: a */
    private Context f392a;

    /* renamed from: b */
    private C0986r f393b = null;

    public Camera2Wrapper(Context context) {
        this.f392a = context;
        initCamera2Jni();
    }

    private final native void deinitCamera2Jni();

    private final native void initCamera2Jni();

    private final native void nativeFrameReady(Object obj, Object obj2, Object obj3, int i, int i2, int i3);

    private final native void nativeSurfaceTextureReady(Object obj);

    /* renamed from: a */
    public final void m332a() {
        deinitCamera2Jni();
        closeCamera2();
    }

    /* renamed from: a */
    public final void m333a(Object obj) {
        nativeSurfaceTextureReady(obj);
    }

    /* renamed from: a */
    public final void m334a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3) {
        nativeFrameReady(byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3);
    }

    protected void closeCamera2() {
        C0986r c0986r = this.f393b;
        if (c0986r != null) {
            c0986r.m424a();
        }
        this.f393b = null;
    }

    protected int getCamera2Count() {
        return C0986r.m410a(this.f392a);
    }

    protected int getCamera2FocalLengthEquivalent(int i) {
        return C0986r.m411a(this.f392a, i);
    }

    protected int[] getCamera2Resolutions(int i) {
        return C0986r.m415b(this.f392a, i);
    }

    protected int getCamera2SensorOrientation(int i) {
        return C0986r.m417c(this.f392a, i);
    }

    protected Rect getFrameSizeCamera2() {
        C0986r c0986r = this.f393b;
        return c0986r != null ? c0986r.m427c() : new Rect();
    }

    protected boolean initializeCamera2(int i, int i2, int i3, int i4, int i5, Surface surface) {
        if (this.f393b != null || UnityPlayer.currentActivity == null) {
            return false;
        }
        C0986r c0986r = new C0986r(this);
        this.f393b = c0986r;
        return c0986r.m426a(this.f392a, i, i2, i3, i4, i5, surface);
    }

    protected boolean isCamera2AutoFocusPointSupported(int i) {
        return C0986r.m419d(this.f392a, i);
    }

    protected boolean isCamera2FrontFacing(int i) {
        return C0986r.m421e(this.f392a, i);
    }

    protected void pauseCamera2() {
        C0986r c0986r = this.f393b;
        if (c0986r != null) {
            c0986r.m428d();
        }
    }

    protected boolean setAutoFocusPoint(float f, float f2) {
        C0986r c0986r = this.f393b;
        if (c0986r != null) {
            return c0986r.m425a(f, f2);
        }
        return false;
    }

    protected void startCamera2() {
        C0986r c0986r = this.f393b;
        if (c0986r != null) {
            c0986r.m429h();
        }
    }

    protected void stopCamera2() {
        C0986r c0986r = this.f393b;
        if (c0986r != null) {
            c0986r.m430i();
        }
    }
}

// ===== FILE: com/unity3d/player/DialogC0918J.java =====
package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;

/* renamed from: com.unity3d.player.J */
/* loaded from: classes.dex */
final class DialogC0918J extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    protected Context f445a;

    /* renamed from: b */
    protected UnityPlayer f446b;

    /* renamed from: c */
    protected C0911G f447c;

    /* renamed from: d */
    protected AbstractC0916I f448d;

    public DialogC0918J(Context context, UnityPlayer unityPlayer) {
        super(context);
        this.f447c = null;
        this.f448d = null;
        this.f445a = context;
        this.f446b = unityPlayer;
    }

    /* renamed from: a */
    public final Rect m348a() {
        Rect rect = new Rect();
        this.f446b.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        this.f446b.getLocationOnScreen(iArr);
        Point point = new Point(rect.left - iArr[0], rect.height() - this.f447c.getHeight());
        Point point2 = new Point();
        getWindow().getWindowManager().getDefaultDisplay().getSize(point2);
        int height = this.f446b.getHeight();
        int i = height - point2.y;
        int i2 = height - point.y;
        int height2 = this.f447c.getHeight() + i;
        UnityPlayer unityPlayer = this.f446b;
        if (i2 != height2) {
            unityPlayer.reportSoftInputIsVisible(true);
        } else {
            unityPlayer.reportSoftInputIsVisible(false);
        }
        return new Rect(point.x, point.y, this.f447c.getWidth(), i2);
    }

    /* renamed from: a */
    public final void m349a(AbstractC0916I abstractC0916I, boolean z, boolean z2) {
        this.f448d = abstractC0916I;
        Window window = getWindow();
        window.requestFeature(1);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
        this.f447c = createSoftInputView(this.f448d.f439c);
        window.setLayout(-1, -2);
        window.clearFlags(2);
        window.clearFlags(134217728);
        window.clearFlags(67108864);
        if (!z2) {
            window.addFlags(32);
            window.addFlags(262144);
        }
        m350a(z);
        getWindow().setSoftInputMode(5);
    }

    /* renamed from: a */
    public final void m350a(boolean z) {
        C0911G c0911g = this.f447c;
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c0911g.f415b.getLayoutParams();
            layoutParams.height = 1;
            c0911g.f415b.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c0911g.f414a.getLayoutParams();
            layoutParams2.height = 1;
            c0911g.f414a.setLayoutParams(layoutParams2);
            Rect rect = c0911g.f418e;
            c0911g.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            c0911g.setVisibility(4);
        } else {
            c0911g.setVisibility(0);
            Rect rect2 = c0911g.f417d;
            c0911g.setPadding(rect2.left, rect2.top, rect2.right, rect2.bottom);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c0911g.f415b.getLayoutParams();
            layoutParams3.height = -2;
            c0911g.f415b.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c0911g.f414a.getLayoutParams();
            layoutParams4.height = -2;
            c0911g.f414a.setLayoutParams(layoutParams4);
        }
        c0911g.invalidate();
        c0911g.requestLayout();
    }

    protected C0911G createSoftInputView(EditText editText) {
        C0911G c0911g = new C0911G(this.f445a, editText);
        c0911g.f414a.setOnClickListener(this);
        setContentView(c0911g);
        return c0911g;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f448d.mo344d() || !(motionEvent.getAction() == 4 || this.f448d.f440d)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AbstractC0916I abstractC0916I = this.f448d;
        abstractC0916I.m340a(abstractC0916I.m342b(), false);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
    }
}

// ===== FILE: com/unity3d/player/DialogInterfaceOnCancelListenerC0930P.java =====
package com.unity3d.player;

import android.content.DialogInterface;

/* renamed from: com.unity3d.player.P */
/* loaded from: classes.dex */
final class DialogInterfaceOnCancelListenerC0930P implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ C0936S f497a;

    DialogInterfaceOnCancelListenerC0930P(C0936S c0936s) {
        this.f497a = c0936s;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        InterfaceC0996w interfaceC0996w = this.f497a.f442f;
        if (interfaceC0996w != null) {
            ((C0953a0) interfaceC0996w).m395a();
        }
    }
}

// ===== FILE: com/unity3d/player/DialogInterfaceOnClickListenerC0977m0.java =====
package com.unity3d.player;

import android.content.DialogInterface;

/* renamed from: com.unity3d.player.m0 */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC0977m0 implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f623a;

    DialogInterfaceOnClickListenerC0977m0(UnityPlayer unityPlayer) {
        this.f623a = unityPlayer;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f623a.finish();
    }
}

// ===== FILE: com/unity3d/player/DialogInterfaceOnDismissListenerC0926N.java =====
package com.unity3d.player;

import android.content.DialogInterface;

/* renamed from: com.unity3d.player.N */
/* loaded from: classes.dex */
final class DialogInterfaceOnDismissListenerC0926N implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ C0936S f488a;

    DialogInterfaceOnDismissListenerC0926N(C0936S c0936s) {
        this.f488a = c0936s;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f488a.invokeOnClose();
    }
}

// ===== FILE: com/unity3d/player/EnumC0910F0.java =====
package com.unity3d.player;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: com.unity3d.player.F0 */
/* loaded from: classes.dex */
final class EnumC0910F0 {

    /* renamed from: a */
    public static final EnumC0910F0 f404a = new EnumC0910F0(0, "PAUSE");

    /* renamed from: b */
    public static final EnumC0910F0 f405b = new EnumC0910F0(1, "RESUME");

    /* renamed from: c */
    public static final EnumC0910F0 f406c = new EnumC0910F0(2, "QUIT");

    /* renamed from: d */
    public static final EnumC0910F0 f407d = new EnumC0910F0(3, "SURFACE_LOST");

    /* renamed from: e */
    public static final EnumC0910F0 f408e = new EnumC0910F0(4, "SURFACE_ACQUIRED");

    /* renamed from: f */
    public static final EnumC0910F0 f409f = new EnumC0910F0(5, "FOCUS_LOST");

    /* renamed from: g */
    public static final EnumC0910F0 f410g = new EnumC0910F0(6, "FOCUS_GAINED");

    /* renamed from: h */
    public static final EnumC0910F0 f411h = new EnumC0910F0(7, "NEXT_FRAME");

    /* renamed from: i */
    public static final EnumC0910F0 f412i = new EnumC0910F0(8, "URL_ACTIVATED");

    /* renamed from: j */
    public static final EnumC0910F0 f413j = new EnumC0910F0(9, "ORIENTATION_ANGLE_CHANGE");

    private EnumC0910F0(int i, String str) {
    }
}

// ===== FILE: com/unity3d/player/GoogleARCoreApi.java =====
package com.unity3d.player;

import android.app.Activity;

/* loaded from: classes.dex */
public class GoogleARCoreApi {
    public final native void initializeARCore(Activity activity);

    public final native void pauseARCore();

    public final native void resumeARCore();
}

// ===== FILE: com/unity3d/player/HFPStatus.java =====
package com.unity3d.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.unity3d.services.core.device.MimeTypes;

/* loaded from: classes.dex */
public class HFPStatus {

    /* renamed from: a */
    private Context f430a;

    /* renamed from: d */
    private AudioManager f433d;

    /* renamed from: b */
    private BroadcastReceiver f431b = null;

    /* renamed from: c */
    private boolean f432c = false;

    /* renamed from: e */
    private boolean f434e = false;

    /* renamed from: f */
    private int f435f = 1;

    public HFPStatus(Context context) {
        this.f433d = null;
        this.f430a = context;
        this.f433d = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        initHFPStatusJni();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m336a() {
        if (this.f434e) {
            this.f434e = false;
            this.f433d.stopBluetoothSco();
        }
    }

    private final native void deinitHFPStatusJni();

    private final native void initHFPStatusJni();

    /* renamed from: b */
    public final void m337b() {
        clearHFPStat();
        deinitHFPStatusJni();
    }

    protected void clearHFPStat() {
        BroadcastReceiver broadcastReceiver = this.f431b;
        if (broadcastReceiver != null) {
            this.f430a.unregisterReceiver(broadcastReceiver);
            this.f431b = null;
        }
        this.f435f = 1;
        m336a();
    }

    protected boolean getHFPStat() {
        return this.f435f == 2;
    }

    protected void requestHFPStat() {
        clearHFPStat();
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.unity3d.player.HFPStatus.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1) != 1) {
                    return;
                }
                HFPStatus hFPStatus = HFPStatus.this;
                hFPStatus.f435f = 2;
                hFPStatus.m336a();
                HFPStatus hFPStatus2 = HFPStatus.this;
                if (hFPStatus2.f432c) {
                    hFPStatus2.f433d.setMode(3);
                }
            }
        };
        this.f431b = broadcastReceiver;
        this.f430a.registerReceiver(broadcastReceiver, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
        try {
            this.f434e = true;
            this.f433d.startBluetoothSco();
        } catch (NullPointerException unused) {
            AbstractC0990t.Log(5, "startBluetoothSco() failed. no bluetooth device connected.");
        }
    }

    protected void setHFPRecordingStat(boolean z) {
        this.f432c = z;
        if (z) {
            return;
        }
        this.f433d.setMode(0);
    }
}

// ===== FILE: com/unity3d/player/IAssetPackManagerDownloadStatusCallback.java =====
package com.unity3d.player;

/* loaded from: classes.dex */
interface IAssetPackManagerDownloadStatusCallback {
    void onStatusUpdate(String str, int i, long j, long j2, int i2, int i3);
}

// ===== FILE: com/unity3d/player/IAssetPackManagerMobileDataConfirmationCallback.java =====
package com.unity3d.player;

/* loaded from: classes.dex */
interface IAssetPackManagerMobileDataConfirmationCallback {
    void onMobileDataConfirmationResult(boolean z);
}

// ===== FILE: com/unity3d/player/IAssetPackManagerStatusQueryCallback.java =====
package com.unity3d.player;

/* loaded from: classes.dex */
interface IAssetPackManagerStatusQueryCallback {
    void onStatusResult(long j, String[] strArr, int[] iArr, int[] iArr2);
}

// ===== FILE: com/unity3d/player/IPermissionRequestCallbacks.java =====
package com.unity3d.player;

/* loaded from: classes.dex */
public interface IPermissionRequestCallbacks {
    void onPermissionDenied(String str);

    void onPermissionDeniedAndDontAskAgain(String str);

    void onPermissionGranted(String str);
}

// ===== FILE: com/unity3d/player/IUnityPlayerLifecycleEvents.java =====
package com.unity3d.player;

/* loaded from: classes.dex */
public interface IUnityPlayerLifecycleEvents {
    void onUnityPlayerQuitted();

    void onUnityPlayerUnloaded();
}

// ===== FILE: com/unity3d/player/InterfaceC0921K0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.K0 */
/* loaded from: classes.dex */
public interface InterfaceC0921K0 {
}

// ===== FILE: com/unity3d/player/InterfaceC0938T.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.T */
/* loaded from: classes.dex */
public interface InterfaceC0938T {
}

// ===== FILE: com/unity3d/player/InterfaceC0939T0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.T0 */
/* loaded from: classes.dex */
public interface InterfaceC0939T0 {
}

// ===== FILE: com/unity3d/player/InterfaceC0972k.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.k */
/* loaded from: classes.dex */
public interface InterfaceC0972k {
    void onAudioVolumeChanged(int i);
}

// ===== FILE: com/unity3d/player/InterfaceC0994v.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.v */
/* loaded from: classes.dex */
interface InterfaceC0994v {
}

// ===== FILE: com/unity3d/player/InterfaceC0996w.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.w */
/* loaded from: classes.dex */
interface InterfaceC0996w {
}

// ===== FILE: com/unity3d/player/InterfaceC0998x.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.x */
/* loaded from: classes.dex */
interface InterfaceC0998x {
}

// ===== FILE: com/unity3d/player/MultiWindowSupport.java =====
package com.unity3d.player;

import android.app.Activity;

/* loaded from: classes.dex */
public class MultiWindowSupport {
    private static boolean s_LastMultiWindowMode;

    public static boolean isInMultiWindowMode(Activity activity) {
        if (activity != null && PlatformSupport.NOUGAT_SUPPORT) {
            return activity.isInMultiWindowMode();
        }
        return false;
    }

    public static boolean isMultiWindowModeChangedToTrue(Activity activity) {
        return !s_LastMultiWindowMode && isInMultiWindowMode(activity);
    }

    public static void saveMultiWindowMode(Activity activity) {
        s_LastMultiWindowMode = isInMultiWindowMode(activity);
    }
}

// ===== FILE: com/unity3d/player/NativeLoader.java =====
package com.unity3d.player;

/* loaded from: classes.dex */
public abstract class NativeLoader {
    static final native boolean load(String str);

    static final native boolean unload();
}

// ===== FILE: com/unity3d/player/NetworkConnectivity.java =====
package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* loaded from: classes.dex */
public class NetworkConnectivity extends Activity {

    /* renamed from: a */
    protected ConnectivityManager f490a;

    public NetworkConnectivity(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.f490a = connectivityManager;
        if (connectivityManager == null) {
            AbstractC0990t.Log(6, "NetworkConnectivity: ConnectivityManager not found");
        }
    }

    /* renamed from: a */
    public void mo364a() {
    }

    /* renamed from: b */
    public int mo365b() {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = this.f490a;
        if (connectivityManager == null) {
            return 0;
        }
        if (PlatformSupport.MARSHMALLOW_SUPPORT) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && (networkCapabilities = this.f490a.getNetworkCapabilities(activeNetwork)) != null) {
                return networkCapabilities.hasTransport(0) ? 1 : 2;
            }
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 0 ? 1 : 2;
            }
        }
        return 0;
    }
}

// ===== FILE: com/unity3d/player/NetworkConnectivityNougat.java =====
package com.unity3d.player;

import android.content.Context;
import android.net.ConnectivityManager;

/* loaded from: classes.dex */
public class NetworkConnectivityNougat extends NetworkConnectivity {

    /* renamed from: b */
    private int f491b;

    /* renamed from: c */
    private final ConnectivityManager.NetworkCallback f492c;

    public NetworkConnectivityNougat(Context context) {
        super(context);
        this.f491b = 0;
        C0992u c0992u = new C0992u(this);
        this.f492c = c0992u;
        if (this.f490a == null) {
            return;
        }
        this.f491b = super.mo365b();
        this.f490a.registerDefaultNetworkCallback(c0992u);
    }

    @Override // com.unity3d.player.NetworkConnectivity
    /* renamed from: a */
    public final void mo364a() {
        ConnectivityManager connectivityManager = this.f490a;
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(this.f492c);
    }

    @Override // com.unity3d.player.NetworkConnectivity
    /* renamed from: b */
    public final int mo365b() {
        return this.f491b;
    }
}

// ===== FILE: com/unity3d/player/OrientationLockListener.java =====
package com.unity3d.player;

import android.content.Context;
import android.provider.Settings;

/* loaded from: classes.dex */
public class OrientationLockListener implements InterfaceC0938T {

    /* renamed from: a */
    private C0942V f495a;

    /* renamed from: b */
    private Context f496b;

    OrientationLockListener(Context context) {
        this.f496b = context;
        this.f495a = new C0942V(context);
        nativeUpdateOrientationLockState(Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0));
        this.f495a.m381a(this);
    }

    /* renamed from: a */
    public final void m367a() {
        this.f495a.m380a();
        this.f495a = null;
    }

    /* renamed from: b */
    public final void m368b() {
        nativeUpdateOrientationLockState(Settings.System.getInt(this.f496b.getContentResolver(), "accelerometer_rotation", 0));
    }

    public final native void nativeUpdateOrientationLockState(int i);
}

// ===== FILE: com/unity3d/player/PermissionFragment.java =====
package com.unity3d.player;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.unity3d.player.UnityPermissions;

/* loaded from: classes.dex */
public class PermissionFragment extends Fragment {
    public static final String PERMISSION_NAMES = "PermissionNames";
    public static final int UNITY_PERMISSION_REQUEST_CODE = 96489;
    private final Activity m_Activity;
    private final Looper m_Looper;
    private final IPermissionRequestCallbacks m_ResultCallbacks;

    public PermissionFragment() {
        this.m_ResultCallbacks = null;
        this.m_Activity = null;
        this.m_Looper = null;
    }

    public PermissionFragment(Activity activity, IPermissionRequestCallbacks iPermissionRequestCallbacks) {
        this.m_ResultCallbacks = iPermissionRequestCallbacks;
        this.m_Activity = activity;
        this.m_Looper = Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAllDenied(String[] strArr) {
        for (String str : strArr) {
            this.m_ResultCallbacks.onPermissionDenied(str);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestPermissions(getArguments().getStringArray(PERMISSION_NAMES), UNITY_PERMISSION_REQUEST_CODE);
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 96489) {
            return;
        }
        if (strArr.length != 0) {
            for (int i2 = 0; i2 < strArr.length && i2 < iArr.length; i2++) {
                int i3 = iArr[i2];
                IPermissionRequestCallbacks iPermissionRequestCallbacks = this.m_ResultCallbacks;
                if (iPermissionRequestCallbacks != null && this.m_Activity != null && this.m_Looper != null) {
                    if (iPermissionRequestCallbacks instanceof UnityPermissions.ModalWaitForPermissionResponse) {
                        iPermissionRequestCallbacks.onPermissionGranted(strArr[i2]);
                    } else {
                        String str = strArr[i2];
                        if (str == null) {
                            str = "<null>";
                        }
                        new Handler(this.m_Looper).post(new RunnableC1002z(this.m_ResultCallbacks, str, iArr[i2], this.m_Activity.shouldShowRequestPermissionRationale(str)));
                    }
                }
            }
        } else if (this.m_ResultCallbacks != null && this.m_Activity != null && this.m_Looper != null) {
            String[] stringArray = getArguments().getStringArray(PERMISSION_NAMES);
            if (this.m_ResultCallbacks instanceof UnityPermissions.ModalWaitForPermissionResponse) {
                reportAllDenied(stringArray);
            } else {
                new Handler(this.m_Looper).post(new RunnableC1000y(this, stringArray));
            }
        }
        FragmentTransaction beginTransaction = getActivity().getFragmentManager().beginTransaction();
        beginTransaction.remove(this);
        beginTransaction.commit();
    }
}

// ===== FILE: com/unity3d/player/PixelCopyOnPixelCopyFinishedListenerC0899A.java =====
package com.unity3d.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import androidx.core.view.ViewCompat;

/* renamed from: com.unity3d.player.A */
/* loaded from: classes.dex */
final class PixelCopyOnPixelCopyFinishedListenerC0899A extends View implements PixelCopy.OnPixelCopyFinishedListener {

    /* renamed from: a */
    Bitmap f379a;

    PixelCopyOnPixelCopyFinishedListenerC0899A(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final void m329a(SurfaceView surfaceView) {
        Bitmap createBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        this.f379a = createBitmap;
        PixelCopy.request(surfaceView, createBitmap, this, new Handler(Looper.getMainLooper()));
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int i) {
        if (i == 0) {
            setBackground(new LayerDrawable(new Drawable[]{new ColorDrawable(ViewCompat.MEASURED_STATE_MASK), new BitmapDrawable(getResources(), this.f379a)}));
        }
    }
}

// ===== FILE: com/unity3d/player/PlatformSupport.java =====
package com.unity3d.player;

import android.os.Build;

/* loaded from: classes.dex */
public class PlatformSupport {
    static final boolean MARSHMALLOW_SUPPORT;
    static final boolean NOUGAT_SUPPORT;
    static final boolean PIE_SUPPORT;
    static final boolean RED_VELVET_CAKE_SUPPORT;
    static final boolean SNOW_CONE_SUPPORT;
    static final boolean TIRAMISU_SUPPORT;
    static final boolean UPSIDE_DOWN_CAKE_SUPPORT;
    static final boolean VANILLA_ICE_CREAM_SUPPORT;

    static {
        int i = Build.VERSION.SDK_INT;
        MARSHMALLOW_SUPPORT = true;
        NOUGAT_SUPPORT = i >= 24;
        PIE_SUPPORT = i >= 28;
        RED_VELVET_CAKE_SUPPORT = i >= 30;
        SNOW_CONE_SUPPORT = i >= 31;
        TIRAMISU_SUPPORT = i >= 33;
        UPSIDE_DOWN_CAKE_SUPPORT = i >= 34;
        VANILLA_ICE_CREAM_SUPPORT = i >= 35;
    }
}

// ===== FILE: com/unity3d/player/PlayAssetDeliveryUnityWrapper.java =====
package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import java.util.List;

/* loaded from: classes.dex */
class PlayAssetDeliveryUnityWrapper {

    /* renamed from: b */
    private static PlayAssetDeliveryUnityWrapper f506b;

    /* renamed from: a */
    private C0968i f507a;

    private PlayAssetDeliveryUnityWrapper(Context context) {
        this.f507a = null;
        if (f506b != null) {
            throw new RuntimeException("PlayAssetDeliveryUnityWrapper should be created only once. Use getInstance() instead.");
        }
        try {
            if (getClass().getClassLoader().loadClass("com.google.android.play.core.assetpacks.AssetPackManager").getMethod("getPackStates", List.class).getReturnType().getName().equals("com.google.android.gms.tasks.Task")) {
                this.f507a = m369a(context);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException unused) {
        }
    }

    /* renamed from: a */
    private static C0968i m369a(Context context) {
        return C0968i.m398a(context);
    }

    /* renamed from: a */
    private void m370a() {
        if (playCoreApiMissing()) {
            throw new RuntimeException("AssetPackManager API is not available! Make sure your gradle project includes 'com.google.android.play:asset-delivery' dependency.");
        }
    }

    public static synchronized PlayAssetDeliveryUnityWrapper getInstance() {
        PlayAssetDeliveryUnityWrapper playAssetDeliveryUnityWrapper;
        synchronized (PlayAssetDeliveryUnityWrapper.class) {
            while (true) {
                playAssetDeliveryUnityWrapper = f506b;
                if (playAssetDeliveryUnityWrapper != null) {
                    break;
                }
                try {
                    PlayAssetDeliveryUnityWrapper.class.wait(3000L);
                } catch (InterruptedException e) {
                    AbstractC0990t.Log(6, e.getMessage());
                }
            }
            if (playAssetDeliveryUnityWrapper == null) {
                throw new RuntimeException("PlayAssetDeliveryUnityWrapper is not yet initialised.");
            }
        }
        return playAssetDeliveryUnityWrapper;
    }

    public static synchronized PlayAssetDeliveryUnityWrapper init(Context context) {
        PlayAssetDeliveryUnityWrapper playAssetDeliveryUnityWrapper;
        synchronized (PlayAssetDeliveryUnityWrapper.class) {
            if (f506b != null) {
                throw new RuntimeException("PlayAssetDeliveryUnityWrapper.init() should be called only once. Use getInstance() instead.");
            }
            f506b = new PlayAssetDeliveryUnityWrapper(context);
            PlayAssetDeliveryUnityWrapper.class.notifyAll();
            playAssetDeliveryUnityWrapper = f506b;
        }
        return playAssetDeliveryUnityWrapper;
    }

    public void cancelAssetPackDownload(String str) {
        cancelAssetPackDownloads(new String[]{str});
    }

    public void cancelAssetPackDownloads(String[] strArr) {
        m370a();
        this.f507a.m403a(strArr);
    }

    public void downloadAssetPack(String str, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        downloadAssetPacks(new String[]{str}, iAssetPackManagerDownloadStatusCallback);
    }

    public void downloadAssetPacks(String[] strArr, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        m370a();
        this.f507a.m404a(strArr, iAssetPackManagerDownloadStatusCallback);
    }

    public String getAssetPackPath(String str) {
        m370a();
        return this.f507a.m400a(str);
    }

    public void getAssetPackState(String str, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        getAssetPackStates(new String[]{str}, iAssetPackManagerStatusQueryCallback);
    }

    public void getAssetPackStates(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        m370a();
        this.f507a.m405a(strArr, iAssetPackManagerStatusQueryCallback);
    }

    public boolean playCoreApiMissing() {
        return this.f507a == null;
    }

    public Object registerDownloadStatusListener(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        m370a();
        return this.f507a.m399a(iAssetPackManagerDownloadStatusCallback);
    }

    public void removeAssetPack(String str) {
        m370a();
        this.f507a.m406b(str);
    }

    public void requestToUseMobileData(Activity activity, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        m370a();
        this.f507a.m401a(activity, iAssetPackManagerMobileDataConfirmationCallback);
    }

    public void unregisterDownloadStatusListener(Object obj) {
        m370a();
        this.f507a.m402a(obj);
    }
}

// ===== FILE: com/unity3d/player/ReflectionHelper.java =====
package com.unity3d.player;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
final class ReflectionHelper {
    protected static boolean LOG;
    protected static final boolean LOGV = false;

    /* renamed from: a */
    private static C0905D[] f515a = new C0905D[4096];

    /* renamed from: b */
    private static long f516b;

    /* renamed from: c */
    private static long f517c;

    /* renamed from: d */
    private static boolean f518d;

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0075, code lost:
    
        if (r12.asSubclass(r11) != null) goto L46;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static float m371a(Class cls, Class[] clsArr, Class[] clsArr2) {
        float f;
        float f2;
        float f3 = 0.1f;
        if (clsArr2.length == 0) {
            return 0.1f;
        }
        int i = 0;
        if ((clsArr == null ? 0 : clsArr.length) + 1 != clsArr2.length) {
            return 0.0f;
        }
        if (clsArr != null) {
            int length = clsArr.length;
            int i2 = 0;
            f = 1.0f;
            while (i < length) {
                Class cls2 = clsArr[i];
                int i3 = i2 + 1;
                Class cls3 = clsArr2[i2];
                if (cls2.equals(cls3)) {
                    f2 = 1.0f;
                } else {
                    if (!cls2.isPrimitive() && !cls3.isPrimitive()) {
                        try {
                            if (cls2.asSubclass(cls3) != null) {
                                f2 = 0.5f;
                            }
                        } catch (ClassCastException unused) {
                        }
                        try {
                            if (cls3.asSubclass(cls2) != null) {
                                f2 = 0.1f;
                            }
                        } catch (ClassCastException unused2) {
                        }
                    }
                    f2 = 0.0f;
                }
                f *= f2;
                i++;
                i2 = i3;
            }
        } else {
            f = 1.0f;
        }
        Class cls4 = clsArr2[clsArr2.length - 1];
        if (cls.equals(cls4)) {
            f3 = 1.0f;
        } else {
            if (!cls.isPrimitive() && !cls4.isPrimitive()) {
                try {
                    if (cls.asSubclass(cls4) != null) {
                        f3 = 0.5f;
                    }
                } catch (ClassCastException unused3) {
                }
            }
            f3 = 0.0f;
        }
        return f * f3;
    }

    /* renamed from: a */
    private static Class m372a(String str, int[] iArr) {
        while (iArr[0] < str.length()) {
            int i = iArr[0];
            iArr[0] = i + 1;
            char charAt = str.charAt(i);
            if (charAt != '(' && charAt != ')') {
                if (charAt == 'L') {
                    int indexOf = str.indexOf(59, iArr[0]);
                    if (indexOf == -1) {
                        return null;
                    }
                    String substring = str.substring(iArr[0], indexOf);
                    iArr[0] = indexOf + 1;
                    try {
                        return Class.forName(substring.replace('/', '.'));
                    } catch (ClassNotFoundException unused) {
                        return null;
                    }
                }
                if (charAt == 'Z') {
                    return Boolean.TYPE;
                }
                if (charAt == 'I') {
                    return Integer.TYPE;
                }
                if (charAt == 'F') {
                    return Float.TYPE;
                }
                if (charAt == 'V') {
                    return Void.TYPE;
                }
                if (charAt == 'B') {
                    return Byte.TYPE;
                }
                if (charAt == 'C') {
                    return Character.TYPE;
                }
                if (charAt == 'S') {
                    return Short.TYPE;
                }
                if (charAt == 'J') {
                    return Long.TYPE;
                }
                if (charAt == 'D') {
                    return Double.TYPE;
                }
                if (charAt == '[') {
                    return Array.newInstance((Class<?>) m372a(str, iArr), 0).getClass();
                }
                AbstractC0990t.Log(5, "! parseType; " + charAt + " is not known!");
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static synchronized boolean m373a(C0905D c0905d) {
        int i;
        synchronized (ReflectionHelper.class) {
            C0905D[] c0905dArr = f515a;
            i = c0905d.f397d;
            C0905D c0905d2 = c0905dArr[i & 4095];
            if (!c0905d.equals(c0905d2)) {
                return false;
            }
            c0905d.f398e = c0905d2.f398e;
            return true;
        }
    }

    /* renamed from: a */
    private static Class[] m374a(String str) {
        Class m372a;
        int i = 0;
        int[] iArr = {0};
        ArrayList arrayList = new ArrayList();
        while (iArr[0] < str.length() && (m372a = m372a(str, iArr)) != null) {
            arrayList.add(m372a);
        }
        Class[] clsArr = new Class[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            clsArr[i] = (Class) it.next();
            i++;
        }
        return clsArr;
    }

    protected static synchronized boolean beginProxyCall(long j) {
        synchronized (ReflectionHelper.class) {
            if (j != f516b) {
                return false;
            }
            f517c++;
            return true;
        }
    }

    protected static Object createInvocationError(long j, boolean z) {
        return new C0907E(j, z);
    }

    protected static synchronized void endProxyCall() {
        synchronized (ReflectionHelper.class) {
            long j = f517c - 1;
            f517c = j;
            if (0 == j && f518d) {
                ReflectionHelper.class.notifyAll();
            }
        }
    }

    protected static synchronized void endUnityLaunch() {
        synchronized (ReflectionHelper.class) {
            try {
                f516b++;
                f518d = true;
                while (f517c > 0) {
                    ReflectionHelper.class.wait();
                }
            } catch (InterruptedException unused) {
                AbstractC0990t.Log(6, "Interrupted while waiting for all proxies to exit.");
            }
            f518d = false;
        }
    }

    protected static Constructor getConstructorID(Class cls, String str) {
        int i;
        Constructor<?> constructor;
        C0905D c0905d = new C0905D(cls, "", str);
        if (m373a(c0905d)) {
            constructor = (Constructor) c0905d.f398e;
        } else {
            Class[] m374a = m374a(str);
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            Constructor<?> constructor2 = null;
            float f = 0.0f;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Constructor<?> constructor3 = constructors[i2];
                float m371a = m371a(Void.TYPE, constructor3.getParameterTypes(), m374a);
                if (m371a > f) {
                    if (m371a == 1.0f) {
                        constructor2 = constructor3;
                        break;
                    }
                    constructor2 = constructor3;
                    f = m371a;
                }
                i2++;
            }
            synchronized (ReflectionHelper.class) {
                c0905d.f398e = constructor2;
                C0905D[] c0905dArr = f515a;
                i = c0905d.f397d;
                c0905dArr[i & 4095] = c0905d;
            }
            constructor = constructor2;
        }
        if (constructor != null) {
            return constructor;
        }
        throw new NoSuchMethodError("<init>" + str + " in class " + cls.getName());
    }

    protected static Field getFieldID(Class cls, String str, String str2, boolean z) {
        int i;
        Field field;
        Class cls2 = cls;
        C0905D c0905d = new C0905D(cls2, str, str2);
        if (m373a(c0905d)) {
            field = (Field) c0905d.f398e;
        } else {
            Class[] m374a = m374a(str2);
            float f = 0.0f;
            Field field2 = null;
            while (cls2 != null) {
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Field field3 = declaredFields[i2];
                    if (z == Modifier.isStatic(field3.getModifiers()) && field3.getName().compareTo(str) == 0) {
                        float m371a = m371a(field3.getType(), null, m374a);
                        if (m371a > f) {
                            field2 = field3;
                            if (m371a == 1.0f) {
                                f = m371a;
                                break;
                            }
                            f = m371a;
                        } else {
                            continue;
                        }
                    }
                    i2++;
                }
                if (f == 1.0f || cls2.isPrimitive() || cls2.isInterface() || cls2.equals(Object.class) || cls2.equals(Void.TYPE)) {
                    break;
                }
                cls2 = cls2.getSuperclass();
            }
            synchronized (ReflectionHelper.class) {
                c0905d.f398e = field2;
                C0905D[] c0905dArr = f515a;
                i = c0905d.f397d;
                c0905dArr[i & 4095] = c0905d;
            }
            field = field2;
        }
        if (field != null) {
            return field;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z ? "static" : "non-static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls2.getName();
        throw new NoSuchFieldError(String.format("no %s field with name='%s' signature='%s' in class L%s;", objArr));
    }

    protected static String getFieldSignature(Field field) {
        Class<?> type = field.getType();
        if (type.isPrimitive()) {
            String name = type.getName();
            return TypedValues.Custom.S_BOOLEAN.equals(name) ? "Z" : "byte".equals(name) ? "B" : "char".equals(name) ? "C" : "double".equals(name) ? "D" : TypedValues.Custom.S_FLOAT.equals(name) ? "F" : "int".equals(name) ? "I" : "long".equals(name) ? "J" : "short".equals(name) ? "S" : name;
        }
        if (type.isArray()) {
            return type.getName().replace('.', '/');
        }
        return "L" + type.getName().replace('.', '/') + ";";
    }

    protected static Method getMethodID(Class cls, String str, String str2, boolean z) {
        int i;
        Method method;
        C0905D c0905d = new C0905D(cls, str, str2);
        if (m373a(c0905d)) {
            method = (Method) c0905d.f398e;
        } else {
            Class[] m374a = m374a(str2);
            Method method2 = null;
            float f = 0.0f;
            while (cls != null) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Method method3 = declaredMethods[i2];
                    if (z == Modifier.isStatic(method3.getModifiers()) && method3.getName().compareTo(str) == 0) {
                        float m371a = m371a(method3.getReturnType(), method3.getParameterTypes(), m374a);
                        if (m371a <= f) {
                            continue;
                        } else {
                            if (m371a == 1.0f) {
                                method2 = method3;
                                f = m371a;
                                break;
                            }
                            method2 = method3;
                            f = m371a;
                        }
                    }
                    i2++;
                }
                if (f == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            synchronized (ReflectionHelper.class) {
                c0905d.f398e = method2;
                C0905D[] c0905dArr = f515a;
                i = c0905d.f397d;
                c0905dArr[i & 4095] = c0905d;
            }
            method = method2;
        }
        if (method != null) {
            return method;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z ? "static" : "non-static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls.getName();
        throw new NoSuchMethodError(String.format("no %s method with name='%s' signature='%s' in class L%s;", objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyFinalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native Object nativeProxyInvoke(long j, String str, Object[] objArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyJNIFreeGCHandle(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyLogJNIInvokeException(long j);

    protected static Object newProxyInstance(UnityPlayer unityPlayer, long j, Class cls) {
        return newProxyInstance(unityPlayer, j, new Class[]{cls});
    }

    protected static Object newProxyInstance(UnityPlayer unityPlayer, long j, Class[] clsArr) {
        return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), clsArr, new C0903C(unityPlayer, j));
    }
}

// ===== FILE: com/unity3d/player/RunnableC0900A0.java =====
package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.A0 */
/* loaded from: classes.dex */
final class RunnableC0900A0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Semaphore f380a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f381b;

    RunnableC0900A0(UnityPlayer unityPlayer, Semaphore semaphore) {
        this.f381b = unityPlayer;
        this.f380a = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f381b.shutdown();
        this.f380a.release();
    }
}

// ===== FILE: com/unity3d/player/RunnableC0902B0.java =====
package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.B0 */
/* loaded from: classes.dex */
final class RunnableC0902B0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Semaphore f385a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f386b;

    RunnableC0902B0(UnityPlayer unityPlayer, Semaphore semaphore) {
        this.f386b = unityPlayer;
        this.f385a = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean nativePause;
        nativePause = this.f386b.nativePause();
        if (nativePause) {
            UnityPlayer unityPlayer = this.f386b;
            unityPlayer.mQuitting = true;
            unityPlayer.shutdown();
            this.f386b.queueDestroy();
        }
        this.f385a.release();
    }
}

// ===== FILE: com/unity3d/player/RunnableC0904C0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.C0 */
/* loaded from: classes.dex */
final class RunnableC0904C0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f391a;

    RunnableC0904C0(UnityPlayer unityPlayer) {
        this.f391a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f391a.nativeLowMemory();
    }
}

// ===== FILE: com/unity3d/player/RunnableC0909F.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.F */
/* loaded from: classes.dex */
final class RunnableC0909F implements Runnable {

    /* renamed from: a */
    final long f402a;

    /* renamed from: b */
    final long f403b;

    public RunnableC0909F(long j, long j2) {
        this.f402a = j;
        this.f403b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (ReflectionHelper.beginProxyCall(this.f402a)) {
            try {
                ReflectionHelper.nativeProxyFinalize(this.f403b);
            } finally {
                ReflectionHelper.endProxyCall();
            }
        }
    }
}

// ===== FILE: com/unity3d/player/RunnableC0920K.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.K */
/* loaded from: classes.dex */
final class RunnableC0920K implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0924M f454a;

    RunnableC0920K(C0924M c0924m) {
        this.f454a = c0924m;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f454a.f439c.requestFocus();
        this.f454a.m346f();
    }
}

// ===== FILE: com/unity3d/player/RunnableC0923L0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.L0 */
/* loaded from: classes.dex */
public final class RunnableC0923L0 implements Runnable {

    /* renamed from: a */
    private SurfaceHolderCallbackC0925M0 f457a;

    /* renamed from: b */
    private boolean f458b = false;

    public RunnableC0923L0(SurfaceHolderCallbackC0925M0 surfaceHolderCallbackC0925M0) {
        this.f457a = surfaceHolderCallbackC0925M0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        if (this.f458b) {
            return;
        }
        int i = SurfaceHolderCallbackC0925M0.f462z;
        this.f457a.cancelOnPrepare();
    }
}

// ===== FILE: com/unity3d/player/RunnableC0927N0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.N0 */
/* loaded from: classes.dex */
final class RunnableC0927N0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0929O0 f489a;

    RunnableC0927N0(C0929O0 c0929o0) {
        this.f489a = c0929o0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceHolderCallbackC0925M0 surfaceHolderCallbackC0925M0;
        UnityPlayer unityPlayer;
        UnityPlayer unityPlayer2;
        SurfaceHolderCallbackC0925M0 surfaceHolderCallbackC0925M02;
        InterfaceC0939T0 interfaceC0939T0;
        C0941U0 c0941u0 = this.f489a.f494a.f505h;
        surfaceHolderCallbackC0925M0 = c0941u0.f527f;
        if (surfaceHolderCallbackC0925M0 != null) {
            unityPlayer2 = c0941u0.f522a;
            unityPlayer2.removeViewFromPlayer(surfaceHolderCallbackC0925M0);
            c0941u0.f530i = false;
            surfaceHolderCallbackC0925M02 = c0941u0.f527f;
            surfaceHolderCallbackC0925M02.destroyPlayer();
            c0941u0.f527f = null;
            interfaceC0939T0 = c0941u0.f524c;
            if (interfaceC0939T0 != null) {
                ((C0983p0) interfaceC0939T0).m409a();
            }
        }
        unityPlayer = this.f489a.f494a.f505h.f522a;
        unityPlayer.onResume();
    }
}

// ===== FILE: com/unity3d/player/RunnableC0931P0.java =====
package com.unity3d.player;

import android.content.Context;
import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.P0 */
/* loaded from: classes.dex */
final class RunnableC0931P0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f498a;

    /* renamed from: b */
    final /* synthetic */ int f499b;

    /* renamed from: c */
    final /* synthetic */ int f500c;

    /* renamed from: d */
    final /* synthetic */ int f501d;

    /* renamed from: e */
    final /* synthetic */ boolean f502e;

    /* renamed from: f */
    final /* synthetic */ long f503f;

    /* renamed from: g */
    final /* synthetic */ long f504g;

    /* renamed from: h */
    final /* synthetic */ C0941U0 f505h;

    RunnableC0931P0(C0941U0 c0941u0, String str, int i, int i2, int i3, boolean z, long j, long j2) {
        this.f505h = c0941u0;
        this.f498a = str;
        this.f499b = i;
        this.f500c = i2;
        this.f501d = i3;
        this.f502e = z;
        this.f503f = j;
        this.f504g = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceHolderCallbackC0925M0 surfaceHolderCallbackC0925M0;
        Context context;
        SurfaceHolderCallbackC0925M0 surfaceHolderCallbackC0925M02;
        UnityPlayer unityPlayer;
        UnityPlayer unityPlayer2;
        SurfaceHolderCallbackC0925M0 surfaceHolderCallbackC0925M03;
        Semaphore semaphore;
        C0941U0 c0941u0 = this.f505h;
        surfaceHolderCallbackC0925M0 = c0941u0.f527f;
        if (surfaceHolderCallbackC0925M0 != null) {
            AbstractC0990t.Log(5, "Video already playing");
            C0941U0 c0941u02 = this.f505h;
            c0941u02.f528g = 2;
            semaphore = c0941u02.f525d;
            semaphore.release();
            return;
        }
        context = this.f505h.f523b;
        c0941u0.f527f = new SurfaceHolderCallbackC0925M0(context, this.f498a, this.f499b, this.f500c, this.f501d, this.f502e, this.f503f, this.f504g, new C0929O0(this));
        C0941U0 c0941u03 = this.f505h;
        surfaceHolderCallbackC0925M02 = c0941u03.f527f;
        if (surfaceHolderCallbackC0925M02 != null) {
            unityPlayer = c0941u03.f522a;
            unityPlayer.bringToFront();
            C0941U0 c0941u04 = this.f505h;
            unityPlayer2 = c0941u04.f522a;
            surfaceHolderCallbackC0925M03 = c0941u04.f527f;
            unityPlayer2.addView(surfaceHolderCallbackC0925M03);
        }
    }
}

// ===== FILE: com/unity3d/player/RunnableC0933Q0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.Q0 */
/* loaded from: classes.dex */
final class RunnableC0933Q0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0941U0 f509a;

    RunnableC0933Q0(C0941U0 c0941u0) {
        this.f509a = c0941u0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer unityPlayer;
        unityPlayer = this.f509a.f522a;
        unityPlayer.onPause();
    }
}

// ===== FILE: com/unity3d/player/RunnableC0935R0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.R0 */
/* loaded from: classes.dex */
final class RunnableC0935R0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0941U0 f514a;

    RunnableC0935R0(C0941U0 c0941u0) {
        this.f514a = c0941u0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceHolderCallbackC0925M0 surfaceHolderCallbackC0925M0;
        UnityPlayer unityPlayer;
        SurfaceHolderCallbackC0925M0 surfaceHolderCallbackC0925M02;
        C0941U0 c0941u0 = this.f514a;
        surfaceHolderCallbackC0925M0 = c0941u0.f527f;
        if (surfaceHolderCallbackC0925M0 != null) {
            unityPlayer = c0941u0.f522a;
            unityPlayer.addViewToPlayer(surfaceHolderCallbackC0925M0, true);
            C0941U0 c0941u02 = this.f514a;
            c0941u02.f530i = true;
            surfaceHolderCallbackC0925M02 = c0941u02.f527f;
            surfaceHolderCallbackC0925M02.requestFocus();
        }
    }
}

// ===== FILE: com/unity3d/player/RunnableC0937S0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.S0 */
/* loaded from: classes.dex */
final class RunnableC0937S0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0941U0 f520a;

    RunnableC0937S0(C0941U0 c0941u0) {
        this.f520a = c0941u0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceHolderCallbackC0925M0 surfaceHolderCallbackC0925M0;
        UnityPlayer unityPlayer;
        UnityPlayer unityPlayer2;
        SurfaceHolderCallbackC0925M0 surfaceHolderCallbackC0925M02;
        InterfaceC0939T0 interfaceC0939T0;
        C0941U0 c0941u0 = this.f520a;
        surfaceHolderCallbackC0925M0 = c0941u0.f527f;
        if (surfaceHolderCallbackC0925M0 != null) {
            unityPlayer2 = c0941u0.f522a;
            unityPlayer2.removeViewFromPlayer(surfaceHolderCallbackC0925M0);
            c0941u0.f530i = false;
            surfaceHolderCallbackC0925M02 = c0941u0.f527f;
            surfaceHolderCallbackC0925M02.destroyPlayer();
            c0941u0.f527f = null;
            interfaceC0939T0 = c0941u0.f524c;
            if (interfaceC0939T0 != null) {
                ((C0983p0) interfaceC0939T0).m409a();
            }
        }
        unityPlayer = this.f520a.f522a;
        unityPlayer.onResume();
    }
}

// ===== FILE: com/unity3d/player/RunnableC0946Z.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.Z */
/* loaded from: classes.dex */
final class RunnableC0946Z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f539a;

    RunnableC0946Z(UnityPlayer unityPlayer) {
        this.f539a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f539a.nativeResume();
    }
}

// ===== FILE: com/unity3d/player/RunnableC0954b.java =====
package com.unity3d.player;

import java.util.Iterator;
import java.util.Set;

/* renamed from: com.unity3d.player.b */
/* loaded from: classes.dex */
final class RunnableC0954b implements Runnable {

    /* renamed from: a */
    private Set f549a;

    /* renamed from: b */
    private String f550b;

    /* renamed from: c */
    private int f551c;

    /* renamed from: d */
    private long f552d;

    /* renamed from: e */
    private long f553e;

    /* renamed from: f */
    private int f554f;

    /* renamed from: g */
    private int f555g;

    RunnableC0954b(Set set, String str, int i, long j, long j2, int i2, int i3) {
        this.f549a = set;
        this.f550b = str;
        this.f551c = i;
        this.f552d = j;
        this.f553e = j2;
        this.f554f = i2;
        this.f555g = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.f549a.iterator();
        while (it.hasNext()) {
            ((IAssetPackManagerDownloadStatusCallback) it.next()).onStatusUpdate(this.f550b, this.f551c, this.f552d, this.f553e, this.f554f, this.f555g);
        }
    }
}

// ===== FILE: com/unity3d/player/RunnableC0955b0.java =====
package com.unity3d.player;

import android.content.Context;
import com.unity3d.player.p004a.AbstractC0948a;
import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.b0 */
/* loaded from: classes.dex */
final class RunnableC0955b0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f556a;

    /* renamed from: b */
    final /* synthetic */ String f557b;

    /* renamed from: c */
    final /* synthetic */ int f558c;

    /* renamed from: d */
    final /* synthetic */ boolean f559d;

    /* renamed from: e */
    final /* synthetic */ boolean f560e;

    /* renamed from: f */
    final /* synthetic */ boolean f561f;

    /* renamed from: g */
    final /* synthetic */ boolean f562g;

    /* renamed from: h */
    final /* synthetic */ String f563h;

    /* renamed from: i */
    final /* synthetic */ int f564i;

    /* renamed from: j */
    final /* synthetic */ boolean f565j;

    /* renamed from: k */
    final /* synthetic */ boolean f566k;

    /* renamed from: l */
    final /* synthetic */ Semaphore f567l;

    /* renamed from: m */
    final /* synthetic */ UnityPlayer f568m;

    RunnableC0955b0(UnityPlayer unityPlayer, UnityPlayer unityPlayer2, String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6, Semaphore semaphore) {
        this.f568m = unityPlayer;
        this.f556a = unityPlayer2;
        this.f557b = str;
        this.f558c = i;
        this.f559d = z;
        this.f560e = z2;
        this.f561f = z3;
        this.f562g = z4;
        this.f563h = str2;
        this.f564i = i2;
        this.f565j = z5;
        this.f566k = z6;
        this.f567l = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        try {
            try {
                UnityPlayer unityPlayer = this.f568m;
                if (unityPlayer.mSoftInput != null) {
                    unityPlayer.dismissSoftInput();
                }
                UnityPlayer unityPlayer2 = this.f568m;
                int m375a = SoftInputProvider.m375a();
                context = this.f568m.mContext;
                UnityPlayer unityPlayer3 = this.f556a;
                unityPlayer2.mSoftInput = AbstractC0948a.m391a(m375a) != 2 ? new C0936S(context, unityPlayer3) : new C0924M(context, unityPlayer3);
                this.f568m.mSoftInput.mo339a(this.f557b, this.f558c, this.f559d, this.f560e, this.f561f, this.f562g, this.f563h, this.f564i, this.f565j, this.f566k);
                AbstractC0916I abstractC0916I = this.f568m.mSoftInput;
                abstractC0916I.f442f = new C0953a0(this);
                abstractC0916I.mo345e();
                this.f568m.nativeReportKeyboardConfigChanged();
            } catch (Exception e) {
                AbstractC0990t.Log(6, "Exception when opening Softinput " + e);
            }
        } finally {
            this.f567l.release();
        }
    }
}

// ===== FILE: com/unity3d/player/RunnableC0957c0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.c0 */
/* loaded from: classes.dex */
final class RunnableC0957c0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f572a;

    RunnableC0957c0(UnityPlayer unityPlayer) {
        this.f572a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0945Y c0945y;
        c0945y = this.f572a.mGlView;
        if (c0945y != null) {
            c0945y.m387b();
        }
    }
}

// ===== FILE: com/unity3d/player/RunnableC0958d.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.d */
/* loaded from: classes.dex */
final class RunnableC0958d implements Runnable {

    /* renamed from: a */
    private IAssetPackManagerMobileDataConfirmationCallback f573a;

    /* renamed from: b */
    private boolean f574b;

    RunnableC0958d(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback, boolean z) {
        this.f573a = iAssetPackManagerMobileDataConfirmationCallback;
        this.f574b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f573a.onMobileDataConfirmationResult(this.f574b);
    }
}

// ===== FILE: com/unity3d/player/RunnableC0963f0.java =====
package com.unity3d.player;

import android.graphics.Rect;
import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.f0 */
/* loaded from: classes.dex */
final class RunnableC0963f0 implements Runnable {

    /* renamed from: a */
    boolean f582a = false;

    /* renamed from: b */
    boolean f583b = false;

    /* renamed from: c */
    final /* synthetic */ Semaphore f584c;

    /* renamed from: d */
    final /* synthetic */ UnityPlayer f585d;

    /* renamed from: e */
    final /* synthetic */ UnityPlayer f586e;

    RunnableC0963f0(UnityPlayer unityPlayer, Semaphore semaphore, UnityPlayer unityPlayer2) {
        this.f586e = unityPlayer;
        this.f584c = semaphore;
        this.f585d = unityPlayer2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f586e.reportSoftInputArea(new Rect());
        this.f586e.reportSoftInputIsVisible(false);
        if (this.f586e.mSoftInput != null) {
            this.f585d.setOnHandleFocusListener(new C0959d0(this));
            UnityPlayer unityPlayer = this.f586e;
            unityPlayer.mSoftInput.f443g = new C0961e0(this);
            unityPlayer.dismissSoftInput();
        }
    }
}

// ===== FILE: com/unity3d/player/RunnableC0964g.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.g */
/* loaded from: classes.dex */
final class RunnableC0964g implements Runnable {

    /* renamed from: a */
    private IAssetPackManagerStatusQueryCallback f587a;

    /* renamed from: b */
    private long f588b;

    /* renamed from: c */
    private String[] f589c;

    /* renamed from: d */
    private int[] f590d;

    /* renamed from: e */
    private int[] f591e;

    RunnableC0964g(IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback, long j, String[] strArr, int[] iArr, int[] iArr2) {
        this.f587a = iAssetPackManagerStatusQueryCallback;
        this.f588b = j;
        this.f589c = strArr;
        this.f590d = iArr;
        this.f591e = iArr2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f587a.onStatusResult(this.f588b, this.f589c, this.f590d, this.f591e);
    }
}

// ===== FILE: com/unity3d/player/RunnableC0965g0.java =====
package com.unity3d.player;

import android.widget.EditText;

/* renamed from: com.unity3d.player.g0 */
/* loaded from: classes.dex */
final class RunnableC0965g0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f592a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f593b;

    RunnableC0965g0(UnityPlayer unityPlayer, String str) {
        this.f593b = unityPlayer;
        this.f592a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        EditText editText;
        AbstractC0916I abstractC0916I = this.f593b.mSoftInput;
        if (abstractC0916I == null || (str = this.f592a) == null || (editText = abstractC0916I.f439c) == null) {
            return;
        }
        editText.setText(str);
        abstractC0916I.f439c.setSelection(str.length());
    }
}

// ===== FILE: com/unity3d/player/RunnableC0967h0.java =====
package com.unity3d.player;

import android.text.InputFilter;
import android.widget.EditText;

/* renamed from: com.unity3d.player.h0 */
/* loaded from: classes.dex */
final class RunnableC0967h0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f597a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f598b;

    RunnableC0967h0(UnityPlayer unityPlayer, int i) {
        this.f598b = unityPlayer;
        this.f597a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC0916I abstractC0916I = this.f598b.mSoftInput;
        if (abstractC0916I != null) {
            int i = this.f597a;
            EditText editText = abstractC0916I.f439c;
            if (editText != null) {
                if (i > 0) {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
                } else {
                    editText.setFilters(new InputFilter[0]);
                }
            }
        }
    }
}

// ===== FILE: com/unity3d/player/RunnableC0969i0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.i0 */
/* loaded from: classes.dex */
final class RunnableC0969i0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f603a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f604b;

    RunnableC0969i0(UnityPlayer unityPlayer, boolean z) {
        this.f604b = unityPlayer;
        this.f603a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC0916I abstractC0916I = this.f604b.mSoftInput;
        if (abstractC0916I != null) {
            abstractC0916I.mo341a(this.f603a);
        }
    }
}

// ===== FILE: com/unity3d/player/RunnableC0971j0.java =====
package com.unity3d.player;

import android.widget.EditText;

/* renamed from: com.unity3d.player.j0 */
/* loaded from: classes.dex */
final class RunnableC0971j0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f609a;

    /* renamed from: b */
    final /* synthetic */ int f610b;

    /* renamed from: c */
    final /* synthetic */ UnityPlayer f611c;

    RunnableC0971j0(UnityPlayer unityPlayer, int i, int i2) {
        this.f611c = unityPlayer;
        this.f609a = i;
        this.f610b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        AbstractC0916I abstractC0916I = this.f611c.mSoftInput;
        if (abstractC0916I != null) {
            int i2 = this.f609a;
            int i3 = this.f610b;
            EditText editText = abstractC0916I.f439c;
            if (editText == null || editText.getText().length() < (i = i3 + i2)) {
                return;
            }
            abstractC0916I.f439c.setSelection(i2, i);
        }
    }
}

// ===== FILE: com/unity3d/player/RunnableC0985q0.java =====
package com.unity3d.player;

import android.app.Activity;

/* renamed from: com.unity3d.player.q0 */
/* loaded from: classes.dex */
final class RunnableC0985q0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f633a;

    RunnableC0985q0(UnityPlayer unityPlayer) {
        this.f633a = unityPlayer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
    
        r1 = (r0 = r2.f633a).mActivity;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean nativeIsAutorotationOn;
        UnityPlayer unityPlayer;
        Activity activity;
        int i;
        nativeIsAutorotationOn = this.f633a.nativeIsAutorotationOn();
        if (!nativeIsAutorotationOn || activity == null) {
            return;
        }
        i = unityPlayer.mInitialScreenOrientation;
        activity.setRequestedOrientation(i);
    }
}

// ===== FILE: com/unity3d/player/RunnableC0987r0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.r0 */
/* loaded from: classes.dex */
final class RunnableC0987r0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f664a;

    RunnableC0987r0(UnityPlayer unityPlayer) {
        this.f664a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents;
        this.f664a.setupUnityToBePaused();
        this.f664a.windowFocusChanged(false);
        iUnityPlayerLifecycleEvents = this.f664a.m_UnityPlayerLifecycleEvents;
        iUnityPlayerLifecycleEvents.onUnityPlayerUnloaded();
    }
}

// ===== FILE: com/unity3d/player/RunnableC0991t0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.t0 */
/* loaded from: classes.dex */
final class RunnableC0991t0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ float f667a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f668b;

    RunnableC0991t0(UnityPlayer unityPlayer, float f) {
        this.f668b = unityPlayer;
        this.f667a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0945Y c0945y;
        c0945y = this.f668b.mGlView;
        c0945y.m386a(this.f667a);
    }
}

// ===== FILE: com/unity3d/player/RunnableC0993u0.java =====
package com.unity3d.player;

import android.view.WindowManager;

/* renamed from: com.unity3d.player.u0 */
/* loaded from: classes.dex */
final class RunnableC0993u0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ float f670a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f671b;

    RunnableC0993u0(UnityPlayer unityPlayer, float f) {
        this.f671b = unityPlayer;
        this.f670a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowManager.LayoutParams attributes = this.f671b.m_Window.getAttributes();
        attributes.screenBrightness = this.f670a;
        this.f671b.m_Window.setAttributes(attributes);
    }
}

// ===== FILE: com/unity3d/player/RunnableC0995v0.java =====
package com.unity3d.player;

import com.unity3d.player.p004a.C0952e;

/* renamed from: com.unity3d.player.v0 */
/* loaded from: classes.dex */
final class RunnableC0995v0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f672a;

    RunnableC0995v0(UnityPlayer unityPlayer) {
        this.f672a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0952e c0952e;
        UnityPlayer unityPlayer = this.f672a;
        c0952e = unityPlayer.m_SplashScreen;
        unityPlayer.removeView(c0952e);
        this.f672a.m_SplashScreen = null;
    }
}

// ===== FILE: com/unity3d/player/RunnableC0997w0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.w0 */
/* loaded from: classes.dex */
final class RunnableC0997w0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f673a;

    RunnableC0997w0(UnityPlayer unityPlayer) {
        this.f673a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f673a.nativeSendSurfaceChangedEvent();
    }
}

// ===== FILE: com/unity3d/player/RunnableC0999x0.java =====
package com.unity3d.player;

import android.view.Surface;
import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.x0 */
/* loaded from: classes.dex */
final class RunnableC0999x0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f674a;

    /* renamed from: b */
    final /* synthetic */ Surface f675b;

    /* renamed from: c */
    final /* synthetic */ Semaphore f676c;

    /* renamed from: d */
    final /* synthetic */ UnityPlayer f677d;

    RunnableC0999x0(UnityPlayer unityPlayer, int i, Surface surface, Semaphore semaphore) {
        this.f677d = unityPlayer;
        this.f674a = i;
        this.f675b = surface;
        this.f676c = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f677d.nativeRecreateGfxState(this.f674a, this.f675b);
        this.f676c.release();
    }
}

// ===== FILE: com/unity3d/player/RunnableC1000y.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.y */
/* loaded from: classes.dex */
final class RunnableC1000y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String[] f678a;

    /* renamed from: b */
    final /* synthetic */ PermissionFragment f679b;

    RunnableC1000y(PermissionFragment permissionFragment, String[] strArr) {
        this.f679b = permissionFragment;
        this.f678a = strArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f679b.reportAllDenied(this.f678a);
    }
}

// ===== FILE: com/unity3d/player/RunnableC1001y0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.y0 */
/* loaded from: classes.dex */
final class RunnableC1001y0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f680a;

    RunnableC1001y0(UnityPlayer unityPlayer) {
        this.f680a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        C0945Y c0945y;
        C0945Y c0945y2;
        C0945Y c0945y3;
        UnityPlayer unityPlayer = this.f680a;
        z = unityPlayer.mMainDisplayOverride;
        if (z) {
            c0945y3 = unityPlayer.mGlView;
            unityPlayer.removeView(c0945y3);
            return;
        }
        c0945y = unityPlayer.mGlView;
        if (c0945y.getParent() != null) {
            AbstractC0990t.Log(5, "Couldn't add view, because it's already assigned to another parent");
            return;
        }
        UnityPlayer unityPlayer2 = this.f680a;
        c0945y2 = unityPlayer2.mGlView;
        unityPlayer2.addView(c0945y2);
    }
}

// ===== FILE: com/unity3d/player/RunnableC1002z.java =====
package com.unity3d.player;

import android.os.Build;

/* renamed from: com.unity3d.player.z */
/* loaded from: classes.dex */
final class RunnableC1002z implements Runnable {

    /* renamed from: a */
    private IPermissionRequestCallbacks f681a;

    /* renamed from: b */
    private String f682b;

    /* renamed from: c */
    private int f683c;

    /* renamed from: d */
    private boolean f684d;

    RunnableC1002z(IPermissionRequestCallbacks iPermissionRequestCallbacks, String str, int i, boolean z) {
        this.f681a = iPermissionRequestCallbacks;
        this.f682b = str;
        this.f683c = i;
        this.f684d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f683c;
        if (i != -1) {
            if (i == 0) {
                this.f681a.onPermissionGranted(this.f682b);
            }
        } else if (Build.VERSION.SDK_INT >= 30 || this.f684d) {
            this.f681a.onPermissionDenied(this.f682b);
        } else {
            this.f681a.onPermissionDeniedAndDontAskAgain(this.f682b);
        }
    }
}

// ===== FILE: com/unity3d/player/RunnableC1003z0.java =====
package com.unity3d.player;

/* renamed from: com.unity3d.player.z0 */
/* loaded from: classes.dex */
final class RunnableC1003z0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f685a;

    RunnableC1003z0(UnityPlayer unityPlayer) {
        this.f685a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f685a.destroy();
    }
}

// ===== FILE: com/unity3d/player/SoftInputProvider.java =====
package com.unity3d.player;

import com.unity3d.player.p004a.AbstractC0948a;
import com.unity3d.player.p004a.AbstractC0950c;

/* loaded from: classes.dex */
abstract class SoftInputProvider {
    /* renamed from: a */
    public static int m375a() {
        int nativeGetSoftInputType = nativeGetSoftInputType();
        for (int i : AbstractC0948a.m392b(3)) {
            if (AbstractC0950c.m393a(i) == nativeGetSoftInputType) {
                return i;
            }
        }
        return 1;
    }

    private static final native int nativeGetSoftInputType();
}

// ===== FILE: com/unity3d/player/SurfaceHolderCallbackC0925M0.java =====
package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;
import java.io.FileInputStream;
import java.io.IOException;

/* renamed from: com.unity3d.player.M0 */
/* loaded from: classes.dex */
public final class SurfaceHolderCallbackC0925M0 extends FrameLayout implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, MediaController.MediaPlayerControl {

    /* renamed from: z */
    public static final /* synthetic */ int f462z = 0;

    /* renamed from: a */
    private final Context f463a;

    /* renamed from: b */
    private final SurfaceView f464b;

    /* renamed from: c */
    private final SurfaceHolder f465c;

    /* renamed from: d */
    private final String f466d;

    /* renamed from: e */
    private final int f467e;

    /* renamed from: f */
    private final int f468f;

    /* renamed from: g */
    private final boolean f469g;

    /* renamed from: h */
    private final long f470h;

    /* renamed from: i */
    private final long f471i;

    /* renamed from: j */
    private final SurfaceHolderCallbackC0925M0 f472j;

    /* renamed from: k */
    private int f473k;

    /* renamed from: l */
    private int f474l;

    /* renamed from: m */
    private int f475m;

    /* renamed from: n */
    private int f476n;

    /* renamed from: o */
    private MediaPlayer f477o;

    /* renamed from: p */
    private MediaController f478p;

    /* renamed from: q */
    private boolean f479q;

    /* renamed from: r */
    private boolean f480r;

    /* renamed from: s */
    private int f481s;

    /* renamed from: t */
    private boolean f482t;

    /* renamed from: u */
    private int f483u;

    /* renamed from: v */
    private boolean f484v;

    /* renamed from: w */
    private InterfaceC0921K0 f485w;

    /* renamed from: x */
    private RunnableC0923L0 f486x;

    /* renamed from: y */
    private volatile int f487y;

    protected SurfaceHolderCallbackC0925M0(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, InterfaceC0921K0 interfaceC0921K0) {
        super(context);
        this.f479q = false;
        this.f480r = false;
        this.f481s = 0;
        this.f482t = false;
        this.f483u = 0;
        this.f484v = false;
        this.f487y = 0;
        this.f485w = interfaceC0921K0;
        this.f463a = context;
        this.f472j = this;
        SurfaceView surfaceView = new SurfaceView(context);
        this.f464b = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.f465c = holder;
        holder.addCallback(this);
        setBackgroundColor(i);
        addView(surfaceView);
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.f466d = str;
        this.f467e = i2;
        this.f468f = i3;
        this.f469g = z;
        this.f470h = j;
        this.f471i = j2;
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    /* renamed from: a */
    private void m362a(int i) {
        this.f487y = i;
        InterfaceC0921K0 interfaceC0921K0 = this.f485w;
        if (interfaceC0921K0 != null) {
            ((C0929O0) interfaceC0921K0).m366a(this.f487y);
        }
    }

    /* renamed from: a */
    final boolean m363a() {
        return this.f482t;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return true;
    }

    public void cancelOnPrepare() {
        m362a(2);
    }

    protected void destroyPlayer() {
        if (!this.f482t) {
            pause();
        }
        doCleanUp();
    }

    protected void doCleanUp() {
        RunnableC0923L0 runnableC0923L0 = this.f486x;
        if (runnableC0923L0 != null) {
            runnableC0923L0.f458b = true;
            this.f486x = null;
        }
        MediaPlayer mediaPlayer = this.f477o;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f477o.release();
            this.f477o = null;
        }
        this.f475m = 0;
        this.f476n = 0;
        this.f480r = false;
        this.f479q = false;
    }

    public boolean exitOnKeypress(int i, KeyEvent keyEvent) {
        if (i != 4 && (this.f467e != 2 || i == 0 || keyEvent.isSystem())) {
            return false;
        }
        destroyPlayer();
        m362a(3);
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        MediaPlayer mediaPlayer = this.f477o;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getAudioSessionId();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.f469g) {
            return this.f481s;
        }
        return 100;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f477o;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        MediaPlayer mediaPlayer = this.f477o;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        boolean z = this.f480r && this.f479q;
        MediaPlayer mediaPlayer = this.f477o;
        return mediaPlayer == null ? !z : mediaPlayer.isPlaying() || !z;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.f481s = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        destroyPlayer();
        m362a(3);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (exitOnKeypress(i, keyEvent)) {
            return true;
        }
        MediaController mediaController = this.f478p;
        return mediaController != null ? mediaController.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (exitOnKeypress(i, keyEvent)) {
            return true;
        }
        MediaController mediaController = this.f478p;
        return mediaController != null ? mediaController.onKeyUp(i, keyEvent) : super.onKeyUp(i, keyEvent);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        RunnableC0923L0 runnableC0923L0 = this.f486x;
        if (runnableC0923L0 != null) {
            runnableC0923L0.f458b = true;
            this.f486x = null;
        }
        int i = this.f467e;
        if (i == 0 || i == 1) {
            MediaController mediaController = new MediaController(this.f463a);
            this.f478p = mediaController;
            mediaController.setMediaPlayer(this);
            this.f478p.setAnchorView(this);
            this.f478p.setEnabled(true);
            Context context = this.f463a;
            if (context instanceof Activity) {
                this.f478p.setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility());
            }
            this.f478p.show();
        }
        this.f480r = true;
        if (!this.f479q || isPlaying()) {
            return;
        }
        m362a(1);
        updateVideoLayout();
        if (this.f482t) {
            return;
        }
        start();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f467e != 2 || action != 0) {
            MediaController mediaController = this.f478p;
            return mediaController != null ? mediaController.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
        }
        destroyPlayer();
        m362a(3);
        return true;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.f479q = true;
        this.f475m = i;
        this.f476n = i2;
        if (!this.f480r || isPlaying()) {
            return;
        }
        m362a(1);
        updateVideoLayout();
        if (this.f482t) {
            return;
        }
        start();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        MediaPlayer mediaPlayer = this.f477o;
        if (mediaPlayer == null) {
            return;
        }
        if (this.f484v) {
            this.f483u = mediaPlayer.getCurrentPosition();
            this.f477o.pause();
        }
        this.f482t = true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        MediaPlayer mediaPlayer = this.f477o;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.seekTo(i);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        MediaPlayer mediaPlayer = this.f477o;
        if (mediaPlayer == null) {
            return;
        }
        if (this.f484v) {
            int i = this.f483u;
            if (i > 0) {
                mediaPlayer.seekTo(i);
            }
            this.f477o.start();
            this.f483u = 0;
        }
        this.f482t = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.f473k == i2 && this.f474l == i3) {
            return;
        }
        this.f473k = i2;
        this.f474l = i3;
        if (this.f484v) {
            updateVideoLayout();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        FileInputStream fileInputStream;
        this.f484v = true;
        if (this.f482t) {
            MediaPlayer mediaPlayer = this.f477o;
            if (mediaPlayer == null || this.f483u <= 0) {
                return;
            }
            mediaPlayer.setDisplay(this.f465c);
            this.f477o.seekTo(this.f483u);
            return;
        }
        MediaPlayer mediaPlayer2 = this.f477o;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setDisplay(this.f465c);
            if (this.f482t) {
                return;
            }
            int i = this.f483u;
            if (i > 0) {
                this.f477o.seekTo(i);
            }
            this.f477o.start();
            this.f483u = 0;
            return;
        }
        m362a(0);
        doCleanUp();
        try {
            MediaPlayer mediaPlayer3 = new MediaPlayer();
            this.f477o = mediaPlayer3;
            if (this.f469g) {
                mediaPlayer3.setDataSource(this.f463a, Uri.parse(this.f466d));
            } else {
                if (this.f471i != 0) {
                    fileInputStream = new FileInputStream(this.f466d);
                    this.f477o.setDataSource(fileInputStream.getFD(), this.f470h, this.f471i);
                } else {
                    try {
                        AssetFileDescriptor openFd = getResources().getAssets().openFd(this.f466d);
                        this.f477o.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        openFd.close();
                    } catch (IOException unused) {
                        fileInputStream = new FileInputStream(this.f466d);
                        this.f477o.setDataSource(fileInputStream.getFD());
                    }
                }
                fileInputStream.close();
            }
            this.f477o.setDisplay(this.f465c);
            this.f477o.setScreenOnWhilePlaying(true);
            this.f477o.setOnBufferingUpdateListener(this);
            this.f477o.setOnCompletionListener(this);
            this.f477o.setOnPreparedListener(this);
            this.f477o.setOnVideoSizeChangedListener(this);
            this.f477o.setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build());
            this.f477o.prepareAsync();
            this.f486x = new RunnableC0923L0(this);
            new Thread(this.f486x).start();
        } catch (Exception unused2) {
            m362a(2);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f484v = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        if (r7 <= r3) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
    
        r2 = (int) (r6 * r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        r4 = (int) (r5 / r3);
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        if (r7 >= r3) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        if (r8 == 0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void updateVideoLayout() {
        int i;
        int i2;
        int i3;
        if (this.f477o == null) {
            return;
        }
        WindowManager windowManager = (WindowManager) this.f463a.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i4 = displayMetrics.widthPixels;
        if (i4 > 0 && (i3 = displayMetrics.heightPixels) > 0) {
            this.f473k = i4;
            this.f474l = i3;
        }
        int i5 = this.f473k;
        int i6 = this.f474l;
        if (this.f479q) {
            i = this.f475m;
            i2 = this.f476n;
            float f = i / i2;
            float f2 = i5;
            float f3 = i6;
            float f4 = f2 / f3;
            int i7 = this.f468f;
            if (i7 != 1) {
                if (i7 == 2) {
                }
            }
        }
        i = i5;
        i2 = i6;
        if (i5 == i && i6 == i2) {
            return;
        }
        this.f472j.updateViewLayout(this.f464b, new FrameLayout.LayoutParams(i, i2, 17));
    }
}

// ===== FILE: com/unity3d/player/SurfaceHolderCallbackC0944X.java =====
package com.unity3d.player;

import android.view.SurfaceHolder;

/* renamed from: com.unity3d.player.X */
/* loaded from: classes.dex */
final class SurfaceHolderCallbackC0944X implements SurfaceHolder.Callback {

    /* renamed from: a */
    final /* synthetic */ C0945Y f535a;

    SurfaceHolderCallbackC0944X(C0945Y c0945y) {
        this.f535a = c0945y;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        UnityPlayer unityPlayer;
        UnityPlayer unityPlayer2;
        unityPlayer = this.f535a.f537b;
        unityPlayer.updateGLDisplay(0, surfaceHolder.getSurface());
        unityPlayer2 = this.f535a.f537b;
        unityPlayer2.sendSurfaceChangedEvent();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        UnityPlayer unityPlayer;
        C0901B c0901b;
        UnityPlayer unityPlayer2;
        unityPlayer = this.f535a.f537b;
        unityPlayer.updateGLDisplay(0, surfaceHolder.getSurface());
        C0945Y c0945y = this.f535a;
        c0901b = c0945y.f538c;
        unityPlayer2 = c0945y.f537b;
        PixelCopyOnPixelCopyFinishedListenerC0899A pixelCopyOnPixelCopyFinishedListenerC0899A = c0901b.f384b;
        if (pixelCopyOnPixelCopyFinishedListenerC0899A == null || pixelCopyOnPixelCopyFinishedListenerC0899A.getParent() != null) {
            return;
        }
        unityPlayer2.addView(c0901b.f384b);
        unityPlayer2.bringChildToFront(c0901b.f384b);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C0901B c0901b;
        C0947a c0947a;
        UnityPlayer unityPlayer;
        C0945Y c0945y = this.f535a;
        c0901b = c0945y.f538c;
        c0947a = c0945y.f536a;
        c0901b.getClass();
        if (PlatformSupport.NOUGAT_SUPPORT && c0901b.f383a != null) {
            if (c0901b.f384b == null) {
                c0901b.f384b = new PixelCopyOnPixelCopyFinishedListenerC0899A(c0901b.f383a);
            }
            c0901b.f384b.m329a(c0947a);
        }
        unityPlayer = this.f535a.f537b;
        unityPlayer.updateGLDisplay(0, null);
    }
}

// ===== FILE: com/unity3d/player/UnityCoreAssetPacksStatusCallbacks.java =====
package com.unity3d.player;

/* loaded from: classes.dex */
class UnityCoreAssetPacksStatusCallbacks implements IAssetPackManagerDownloadStatusCallback, IAssetPackManagerStatusQueryCallback {
    private final native void nativeStatusQueryResult(String str, int i, int i2);

    @Override // com.unity3d.player.IAssetPackManagerStatusQueryCallback
    public void onStatusResult(long j, String[] strArr, int[] iArr, int[] iArr2) {
        for (int i = 0; i < iArr.length; i++) {
            nativeStatusQueryResult(strArr[i], iArr[i], iArr2[i]);
        }
    }

    @Override // com.unity3d.player.IAssetPackManagerDownloadStatusCallback
    public void onStatusUpdate(String str, int i, long j, long j2, int i2, int i3) {
        nativeStatusQueryResult(str, i, i3);
    }
}

// ===== FILE: com/unity3d/player/UnityPermissions.java =====
package com.unity3d.player;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* loaded from: classes.dex */
public class UnityPermissions {
    private static final String SKIP_DIALOG_METADATA_NAME = "unityplayer.SkipPermissionsDialog";

    public static class ModalWaitForPermissionResponse implements IPermissionRequestCallbacks {
        private boolean haveResponse = false;

        @Override // com.unity3d.player.IPermissionRequestCallbacks
        public synchronized void onPermissionDenied(String str) {
            this.haveResponse = true;
            notify();
        }

        @Override // com.unity3d.player.IPermissionRequestCallbacks
        public synchronized void onPermissionDeniedAndDontAskAgain(String str) {
            this.haveResponse = true;
            notify();
        }

        @Override // com.unity3d.player.IPermissionRequestCallbacks
        public synchronized void onPermissionGranted(String str) {
            this.haveResponse = true;
            notify();
        }

        public synchronized void waitForResponse() {
            if (this.haveResponse) {
                return;
            }
            wait();
        }
    }

    private static boolean checkInfoForMetadata(PackageItemInfo packageItemInfo) {
        try {
            return packageItemInfo.metaData.getBoolean(SKIP_DIALOG_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean hasUserAuthorizedPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static void requestUserPermissions(Activity activity, String[] strArr, IPermissionRequestCallbacks iPermissionRequestCallbacks) {
        if (!PlatformSupport.MARSHMALLOW_SUPPORT || activity == null || strArr == null) {
            return;
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        String valueOf = String.valueOf(PermissionFragment.UNITY_PERMISSION_REQUEST_CODE);
        if (fragmentManager.findFragmentByTag(valueOf) == null) {
            PermissionFragment permissionFragment = new PermissionFragment(activity, iPermissionRequestCallbacks);
            Bundle bundle = new Bundle();
            bundle.putStringArray(PermissionFragment.PERMISSION_NAMES, strArr);
            permissionFragment.setArguments(bundle);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(0, permissionFragment, valueOf);
            beginTransaction.commit();
        }
    }

    public static boolean skipPermissionsDialog(Activity activity) {
        ActivityInfo activityInfo;
        ApplicationInfo applicationInfo;
        if (!PlatformSupport.MARSHMALLOW_SUPPORT) {
            return false;
        }
        try {
            PackageManager packageManager = activity.getPackageManager();
            activityInfo = packageManager.getActivityInfo(activity.getComponentName(), 128);
            applicationInfo = packageManager.getApplicationInfo(activity.getPackageName(), 128);
        } catch (Exception unused) {
        }
        if (checkInfoForMetadata(activityInfo)) {
            return true;
        }
        return checkInfoForMetadata(applicationInfo);
    }
}

// ===== FILE: com/unity3d/player/UnityPlayer.java =====
package com.unity3d.player;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.unity3d.player.UnityPermissions;
import com.unity3d.player.p004a.AbstractC0951d;
import com.unity3d.player.p004a.C0952e;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class UnityPlayer extends FrameLayout implements IUnityPlayerLifecycleEvents {
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
    private C0945Y mGlView;
    Handler mHandler;
    private int mInitialScreenOrientation;
    private boolean mIsFullscreen;
    private boolean mMainDisplayOverride;
    private int mNaturalOrientation;
    private InterfaceC0994v mOnHandleFocusListener;
    private OrientationEventListener mOrientationListener;
    private boolean mProcessKillRequested;
    private boolean mQuitting;
    AbstractC0916I mSoftInput;
    private long mSoftInputTimeoutMilliSeconds;
    private C0919J0 mState;
    private C0941U0 mVideoPlayerProxy;
    private GoogleARCoreApi m_ARCoreApi;
    private boolean m_AddPhoneCallListener;
    private AudioVolumeHandler m_AudioVolumeHandler;
    private Camera2Wrapper m_Camera2Wrapper;
    private ClipboardManager m_ClipboardManager;
    private final ConcurrentLinkedQueue m_Events;
    private C0906D0 m_FakeListener;
    private HFPStatus m_HFPStatus;
    private int m_IsNoWindowMode;
    C0914H0 m_MainThread;
    private NetworkConnectivity m_NetworkConnectivity;
    private OrientationLockListener m_OrientationLockListener;
    private C0908E0 m_PhoneCallListener;
    private C0952e m_SplashScreen;
    private TelephonyManager m_TelephonyManager;
    private IUnityPlayerLifecycleEvents m_UnityPlayerLifecycleEvents;
    Window m_Window;
    private Uri m_launchUri;
    private Configuration prevConfig;

    public enum SynchronizationTimeout {
        Pause(0),
        SurfaceDetach(1),
        Destroy(2);

        private int m_TimeoutMilliseconds = 2000;
        final int value;

        SynchronizationTimeout(int i) {
            this.value = i;
        }

        public static void setTimeoutForAll(int i) {
            for (SynchronizationTimeout synchronizationTimeout : (SynchronizationTimeout[]) SynchronizationTimeout.class.getEnumConstants()) {
                synchronizationTimeout.setTimeout(i);
            }
        }

        public int getTimeout() {
            return this.m_TimeoutMilliseconds;
        }

        public void setTimeout(int i) {
            this.m_TimeoutMilliseconds = i;
        }
    }

    static {
        new C0943W().m383a();
    }

    public UnityPlayer(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UnityPlayer(Context context, IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents) {
        super(context);
        this.mHandler = new Handler();
        this.mInitialScreenOrientation = -1;
        this.mMainDisplayOverride = false;
        this.mIsFullscreen = true;
        this.mState = new C0919J0();
        this.m_Events = new ConcurrentLinkedQueue();
        this.mOrientationListener = null;
        this.m_MainThread = new C0914H0(this);
        this.m_AddPhoneCallListener = false;
        this.m_PhoneCallListener = new C0908E0(this);
        this.m_ARCoreApi = null;
        this.m_FakeListener = new C0906D0();
        this.m_Camera2Wrapper = null;
        this.m_HFPStatus = null;
        this.m_AudioVolumeHandler = null;
        this.m_OrientationLockListener = null;
        this.m_launchUri = null;
        this.m_NetworkConnectivity = null;
        this.m_UnityPlayerLifecycleEvents = null;
        this.m_IsNoWindowMode = -1;
        this.mSoftInputTimeoutMilliSeconds = 1000L;
        this.mProcessKillRequested = true;
        this.mSoftInput = null;
        this.m_UnityPlayerLifecycleEvents = iUnityPlayerLifecycleEvents == null ? this : iUnityPlayerLifecycleEvents;
        C0943W.m382a(getUnityNativeLibraryPath(context));
        currentContext = context;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.mActivity = activity;
            currentActivity = activity;
            this.mInitialScreenOrientation = activity.getRequestedOrientation();
            this.m_launchUri = this.mActivity.getIntent().getData();
        }
        this.mContext = context;
        EarlyEnableFullScreenIfEnabled();
        Configuration configuration = getResources().getConfiguration();
        this.prevConfig = configuration;
        this.mNaturalOrientation = getNaturalOrientation(configuration.orientation);
        if (this.mActivity != null && getSplashEnabled()) {
            C0952e c0952e = new C0952e(this.mContext, AbstractC0951d.m394a()[getSplashMode()]);
            this.m_SplashScreen = c0952e;
            addView(c0952e);
        }
        preloadJavaPlugins();
        String loadNative = loadNative(getUnityNativeLibraryPath(this.mContext));
        if (!C0919J0.m351d()) {
            AbstractC0990t.Log(6, "Your hardware does not support this application.");
            AlertDialog create = new AlertDialog.Builder(this.mContext).setTitle("Failure to initialize!").setPositiveButton("OK", new DialogInterfaceOnClickListenerC0977m0(this)).setMessage("Your hardware does not support this application.\n\n" + loadNative + "\n\n Press OK to quit.").create();
            create.setCancelable(false);
            create.show();
            return;
        }
        initJni(context);
        this.mState.m360d(true);
        C0945Y c0945y = new C0945Y(context, this);
        this.mGlView = c0945y;
        addView(c0945y);
        bringChildToFront(this.m_SplashScreen);
        this.mQuitting = false;
        Activity activity2 = this.mActivity;
        if (activity2 != null) {
            this.m_Window = activity2.getWindow();
        }
        hideStatusBar();
        this.m_TelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
        this.m_ClipboardManager = (ClipboardManager) this.mContext.getSystemService("clipboard");
        this.m_Camera2Wrapper = new Camera2Wrapper(this.mContext);
        this.m_HFPStatus = new HFPStatus(this.mContext);
        this.m_MainThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DisableStaticSplashScreen() {
        runOnUiThread(new RunnableC0995v0(this));
    }

    private void EarlyEnableFullScreenIfEnabled() {
        View decorView;
        Activity activity = this.mActivity;
        if (activity != null && activity.getWindow() != null && ((getLaunchFullscreen() || this.mActivity.getIntent().getBooleanExtra("android.intent.extra.VR_LAUNCH", false)) && (decorView = this.mActivity.getWindow().getDecorView()) != null)) {
            decorView.setSystemUiVisibility(7);
        }
        AbstractC0988s.m431a(this.mActivity);
    }

    private String GetGlViewContentDescription(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", TypedValues.Custom.S_STRING, context.getPackageName()));
    }

    private boolean IsWindowTranslucent() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return false;
        }
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowIsTranslucent});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public static void UnitySendMessage(String str, String str2, String str3) {
        if (C0919J0.m351d()) {
            try {
                nativeUnitySendMessage(str, str2, str3.getBytes("UTF-8"));
                return;
            } catch (UnsupportedEncodingException unused) {
                return;
            }
        }
        AbstractC0990t.Log(5, "Native libraries not loaded - dropping message for " + str + "." + str2);
    }

    private void checkResumePlayer() {
        Activity activity = this.mActivity;
        if (this.mState.m355a(activity != null ? MultiWindowSupport.isInMultiWindowMode(activity) : false)) {
            this.mState.m358c(true);
            queueGLThreadEvent(new RunnableC0946Z(this));
            this.m_MainThread.m335a(EnumC0910F0.f405b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissSoftInput() {
        AbstractC0916I abstractC0916I = this.mSoftInput;
        if (abstractC0916I != null) {
            abstractC0916I.mo343c();
            nativeReportKeyboardConfigChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.mActivity.finish();
    }

    private boolean getARCoreEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(ARCORE_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    private ActivityInfo getActivityInfo() {
        return this.mActivity.getPackageManager().getActivityInfo(this.mActivity.getComponentName(), 128);
    }

    private ApplicationInfo getApplicationInfo() {
        return this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getAutoReportFullyDrawnEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(AUTO_REPORT_FULLY_DRAWN_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getHaveAndroidWindowSupport() {
        if (this.m_IsNoWindowMode == -1) {
            this.m_IsNoWindowMode = nativeGetNoWindowMode() ? 1 : 0;
        }
        return this.m_IsNoWindowMode == 1;
    }

    private boolean getLaunchFullscreen() {
        try {
            return getApplicationInfo().metaData.getBoolean(LAUNCH_FULLSCREEN);
        } catch (Exception unused) {
            return false;
        }
    }

    private int getNaturalOrientation(int i) {
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if ((rotation == 0 || rotation == 2) && i == 2) {
            return 0;
        }
        return ((rotation == 1 || rotation == 3) && i == 1) ? 0 : 1;
    }

    private String getProcessName() {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    private long getSoftInputTimeout() {
        return Math.round(this.mSoftInputTimeoutMilliSeconds * Math.max(1.0f, Settings.System.getFloat(this.mContext.getContentResolver(), "animator_duration_scale", 0.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getSplashEnabled() {
        try {
            return getApplicationInfo().metaData.getBoolean(SPLASH_ENABLE_METADATA_NAME);
        } catch (Exception unused) {
            return false;
        }
    }

    private static String getUnityNativeLibraryPath(Context context) {
        return context.getApplicationInfo().nativeLibraryDir;
    }

    private void hidePreservedContent() {
        runOnUiThread(new RunnableC0957c0(this));
    }

    private void hideStatusBar() {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.getWindow().setFlags(1024, 1024);
        }
    }

    private final native void initJni(Context context);

    private static String loadNative(String str) {
        String str2 = str + "/libmain.so";
        try {
            try {
                try {
                    System.load(str2);
                } catch (SecurityException e) {
                    return logLoadLibMainError(str2, e.toString());
                }
            } catch (UnsatisfiedLinkError e2) {
                return logLoadLibMainError(str2, e2.toString());
            }
        } catch (UnsatisfiedLinkError unused) {
            System.loadLibrary("main");
        }
        if (NativeLoader.load(str)) {
            C0919J0.m352e();
            return "";
        }
        AbstractC0990t.Log(6, "NativeLoader.load failure, Unity libraries were not loaded.");
        return "NativeLoader.load failure, Unity libraries were not loaded.";
    }

    private static String logLoadLibMainError(String str, String str2) {
        String str3 = "Failed to load 'libmain.so'\n\n" + str2;
        AbstractC0990t.Log(6, str3);
        return str3;
    }

    private final native void nativeApplicationUnload();

    private final native boolean nativeDone();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeFocusChanged(boolean z);

    private final native boolean nativeGetNoWindowMode();

    private final native void nativeHidePreservedContent();

    private final native boolean nativeInjectEvent(InputEvent inputEvent, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativeIsAutorotationOn();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeLowMemory();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeMuteMasterAudio(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeOrientationChanged(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativePause();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeRecreateGfxState(int i, Surface surface);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativeRender();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeReportKeyboardConfigChanged();

    private final native void nativeRestartActivityIndicator();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeResume();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSendSurfaceChangedEvent();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputArea(int i, int i2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputSelection(int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputString(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetKeyboardIsVisible(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetLaunchURL(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSoftInputCanceled();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSoftInputClosed();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSoftInputLostFocus();

    private static native void nativeUnitySendMessage(String str, String str2, byte[] bArr);

    private void pauseUnity() {
        reportSoftInputStr(null, 1, true);
        if (!this.mState.m359c() || this.mState.m357b()) {
            return;
        }
        if (C0919J0.m351d()) {
            Semaphore semaphore = new Semaphore(0);
            Runnable runnableC0900A0 = isFinishing() ? new RunnableC0900A0(this, semaphore) : new RunnableC0902B0(this, semaphore);
            C0914H0 c0914h0 = this.m_MainThread;
            if (c0914h0.f421a != null) {
                c0914h0.m335a(EnumC0910F0.f404a);
                Message.obtain(c0914h0.f421a, runnableC0900A0).sendToTarget();
            }
            try {
                SynchronizationTimeout synchronizationTimeout = SynchronizationTimeout.Pause;
                if (!semaphore.tryAcquire(synchronizationTimeout.getTimeout(), TimeUnit.MILLISECONDS)) {
                    AbstractC0990t.Log(5, "Timeout (" + synchronizationTimeout.getTimeout() + " ms) while trying to pause the Unity Engine.");
                }
            } catch (InterruptedException unused) {
                AbstractC0990t.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
            }
        }
        this.mState.m358c(false);
        this.mState.m361e(true);
        if (this.m_AddPhoneCallListener) {
            this.m_TelephonyManager.listen(this.m_PhoneCallListener, 0);
        }
    }

    private static void preloadJavaPlugins() {
        try {
            Class.forName("com.unity3d.JavaPluginPreloader");
        } catch (ClassNotFoundException unused) {
        } catch (LinkageError e) {
            AbstractC0990t.Log(6, "Java class preloading failed: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queueDestroy() {
        AbstractC0990t.Log(4, "Queue Destroy");
        runOnUiThread(new RunnableC1003z0(this));
    }

    private void queueGLThreadEvent(AbstractRunnableC0917I0 abstractRunnableC0917I0) {
        if (isFinishing()) {
            return;
        }
        queueGLThreadEvent((Runnable) abstractRunnableC0917I0);
    }

    private void raiseFocusListener(boolean z) {
        InterfaceC0994v interfaceC0994v = this.mOnHandleFocusListener;
        if (interfaceC0994v != null) {
            RunnableC0963f0 runnableC0963f0 = ((C0959d0) interfaceC0994v).f575a;
            runnableC0963f0.f583b = true;
            if (runnableC0963f0.f582a) {
                runnableC0963f0.f584c.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdown() {
        this.mProcessKillRequested = nativeDone();
        this.mState.m360d(false);
    }

    private void swapViews(View view, View view2) {
        boolean z;
        if (this.mState.m357b()) {
            z = false;
        } else {
            setupUnityToBePaused();
            z = true;
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof UnityPlayer) || ((UnityPlayer) parent) != this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                addView(view);
                bringChildToFront(view);
                view.setVisibility(0);
            }
        }
        if (view2 != null && view2.getParent() == this) {
            view2.setVisibility(8);
            removeView(view2);
        }
        if (z) {
            setupUnityToBeResumed();
        }
    }

    private static void unloadNative() {
        if (C0919J0.m351d()) {
            if (!NativeLoader.unload()) {
                throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
            }
            C0919J0.m353f();
        }
    }

    private boolean updateDisplayInternal(int i, Surface surface) {
        if (!C0919J0.m351d() || !this.mState.m354a()) {
            return false;
        }
        Semaphore semaphore = new Semaphore(0);
        RunnableC0999x0 runnableC0999x0 = new RunnableC0999x0(this, i, surface, semaphore);
        if (i == 0) {
            C0914H0 c0914h0 = this.m_MainThread;
            Handler handler = c0914h0.f421a;
            if (surface == null) {
                if (handler != null) {
                    c0914h0.m335a(EnumC0910F0.f407d);
                    Message.obtain(c0914h0.f421a, runnableC0999x0).sendToTarget();
                }
            } else if (handler != null) {
                Message.obtain(handler, runnableC0999x0).sendToTarget();
                c0914h0.m335a(EnumC0910F0.f408e);
            }
        } else {
            runnableC0999x0.run();
        }
        if (surface != null || i != 0) {
            return true;
        }
        try {
            SynchronizationTimeout synchronizationTimeout = SynchronizationTimeout.SurfaceDetach;
            if (semaphore.tryAcquire(synchronizationTimeout.getTimeout(), TimeUnit.MILLISECONDS)) {
                return true;
            }
            AbstractC0990t.Log(5, "Timeout (" + synchronizationTimeout.getTimeout() + " ms) while trying detaching primary window.");
            return true;
        } catch (InterruptedException unused) {
            AbstractC0990t.Log(5, "UI thread got interrupted while trying to detach the primary window from the Unity Engine.");
            return true;
        }
    }

    protected void addPhoneCallListener() {
        this.m_AddPhoneCallListener = true;
        this.m_TelephonyManager.listen(this.m_PhoneCallListener, 32);
    }

    public boolean addViewToPlayer(View view, boolean z) {
        swapViews(view, z ? this.mGlView : null);
        boolean z2 = true;
        boolean z3 = view.getParent() == this;
        boolean z4 = z && this.mGlView.getParent() == null;
        boolean z5 = this.mGlView.getParent() == this;
        if (!z3 || (!z4 && !z5)) {
            z2 = false;
        }
        if (!z2) {
            if (!z3) {
                AbstractC0990t.Log(6, "addViewToPlayer: Failure adding view to hierarchy");
            }
            if (!z4 && !z5) {
                AbstractC0990t.Log(6, "addViewToPlayer: Failure removing old view from hierarchy");
            }
        }
        return z2;
    }

    public void configurationChanged(Configuration configuration) {
        int diff = this.prevConfig.diff(configuration);
        if ((diff & 256) != 0 || (diff & 1024) != 0 || (diff & 2048) != 0 || (diff & 128) != 0) {
            nativeHidePreservedContent();
        }
        this.prevConfig = new Configuration(configuration);
        C0941U0 c0941u0 = this.mVideoPlayerProxy;
        if (c0941u0 != null) {
            c0941u0.m376a();
        }
    }

    public void destroy() {
        Camera2Wrapper camera2Wrapper = this.m_Camera2Wrapper;
        if (camera2Wrapper != null) {
            camera2Wrapper.m332a();
            this.m_Camera2Wrapper = null;
        }
        HFPStatus hFPStatus = this.m_HFPStatus;
        if (hFPStatus != null) {
            hFPStatus.m337b();
            this.m_HFPStatus = null;
        }
        NetworkConnectivity networkConnectivity = this.m_NetworkConnectivity;
        if (networkConnectivity != null) {
            networkConnectivity.mo364a();
            this.m_NetworkConnectivity = null;
        }
        this.mQuitting = true;
        if (!this.mState.m357b()) {
            setupUnityToBePaused();
        }
        this.m_MainThread.m335a(EnumC0910F0.f406c);
        try {
            this.m_MainThread.join(SynchronizationTimeout.Destroy.getTimeout());
        } catch (InterruptedException unused) {
            this.m_MainThread.interrupt();
        }
        if (C0919J0.m351d()) {
            removeAllViews();
        }
        if (this.mProcessKillRequested) {
            this.m_UnityPlayerLifecycleEvents.onUnityPlayerQuitted();
            kill();
        }
        unloadNative();
    }

    protected void disableLogger() {
        AbstractC0990t.f666a = true;
    }

    public boolean displayChanged(int i, Surface surface) {
        if (i == 0) {
            this.mMainDisplayOverride = surface != null;
            runOnUiThread(new RunnableC1001y0(this));
        }
        return updateDisplayInternal(i, surface);
    }

    protected void executeGLThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.m_Events.poll();
            if (runnable == null) {
                return;
            } else {
                runnable.run();
            }
        }
    }

    protected String getClipboardText() {
        ClipData primaryClip = this.m_ClipboardManager.getPrimaryClip();
        return primaryClip != null ? primaryClip.getItemAt(0).coerceToText(this.mContext).toString() : "";
    }

    protected String getKeyboardLayout() {
        AbstractC0916I abstractC0916I = this.mSoftInput;
        if (abstractC0916I == null) {
            return null;
        }
        return abstractC0916I.m338a();
    }

    protected String getLaunchURL() {
        Uri uri = this.m_launchUri;
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    protected int getNetworkConnectivity() {
        NetworkConnectivity networkConnectivity = this.m_NetworkConnectivity;
        if (networkConnectivity != null) {
            return networkConnectivity.mo365b();
        }
        this.m_NetworkConnectivity = PlatformSupport.NOUGAT_SUPPORT ? new NetworkConnectivityNougat(this.mContext) : new NetworkConnectivity(this.mContext);
        return this.m_NetworkConnectivity.mo365b();
    }

    public String getNetworkProxySettings(String str) {
        String str2;
        String str3;
        if (!str.startsWith("http:")) {
            if (str.startsWith("https:")) {
                str2 = "https.proxyHost";
                str3 = "https.proxyPort";
            }
            return null;
        }
        str2 = "http.proxyHost";
        str3 = "http.proxyPort";
        String property = System.getProperties().getProperty(str2);
        if (property != null && !"".equals(property)) {
            StringBuilder sb = new StringBuilder(property);
            String property2 = System.getProperties().getProperty(str3);
            if (property2 != null && !"".equals(property2)) {
                sb.append(":");
                sb.append(property2);
            }
            String property3 = System.getProperties().getProperty("http.nonProxyHosts");
            if (property3 != null && !"".equals(property3)) {
                sb.append('\n');
                sb.append(property3);
            }
            return sb.toString();
        }
        return null;
    }

    public float getScreenBrightness() {
        Window window = this.m_Window;
        if (window == null) {
            return 1.0f;
        }
        float f = window.getAttributes().screenBrightness;
        if (f >= 0.0f) {
            return f;
        }
        int i = Settings.System.getInt(getContext().getContentResolver(), "screen_brightness", 255);
        return PlatformSupport.PIE_SUPPORT ? (float) Math.max(0.0d, Math.min(1.0d, ((Math.log(i) * 19.811d) - 9.411d) / 100.0d)) : i / 255.0f;
    }

    public Bundle getSettings() {
        return Bundle.EMPTY;
    }

    protected int getSplashMode() {
        try {
            return getApplicationInfo().metaData.getInt(SPLASH_MODE_METADATA_NAME);
        } catch (Exception unused) {
            return 0;
        }
    }

    protected int getUaaLLaunchProcessType() {
        String processName = getProcessName();
        return (processName == null || processName.equals(this.mContext.getPackageName())) ? 0 : 1;
    }

    public View getView() {
        return this;
    }

    protected void hideSoftInput() {
        if (this.mSoftInput == null) {
            return;
        }
        reportSoftInputArea(new Rect());
        reportSoftInputIsVisible(false);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            dismissSoftInput();
            return;
        }
        Semaphore semaphore = new Semaphore(0);
        postOnUiThread(new RunnableC0963f0(this, semaphore, this));
        try {
            try {
                if (!semaphore.tryAcquire(getSoftInputTimeout(), TimeUnit.MILLISECONDS)) {
                    AbstractC0990t.Log(6, "Timeout (" + getSoftInputTimeout() + " ms) while waiting softinput hiding operation.");
                }
            } catch (InterruptedException unused) {
                AbstractC0990t.Log(6, "UI thread got interrupted while waiting softinput hiding operation.");
            }
        } finally {
            this.mSoftInput = null;
        }
    }

    public void init(int i, boolean z) {
    }

    protected boolean initializeGoogleAr() {
        if (this.m_ARCoreApi != null || this.mActivity == null || !getARCoreEnabled()) {
            return false;
        }
        GoogleARCoreApi googleARCoreApi = new GoogleARCoreApi();
        this.m_ARCoreApi = googleARCoreApi;
        googleARCoreApi.initializeARCore(this.mActivity);
        if (this.mState.m357b()) {
            return false;
        }
        this.m_ARCoreApi.resumeARCore();
        return false;
    }

    public boolean injectEvent(InputEvent inputEvent) {
        return injectEvent(inputEvent, 0);
    }

    public boolean injectEvent(InputEvent inputEvent, int i) {
        if (C0919J0.m351d()) {
            return nativeInjectEvent(inputEvent, i);
        }
        return false;
    }

    protected boolean isFinishing() {
        if (this.mQuitting) {
            return true;
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            this.mQuitting = activity.isFinishing();
        }
        return this.mQuitting;
    }

    protected boolean isUaaLUseCase() {
        String callingPackage;
        Activity activity = this.mActivity;
        return (activity == null || (callingPackage = activity.getCallingPackage()) == null || !callingPackage.equals(this.mContext.getPackageName())) ? false : true;
    }

    protected void kill() {
        Process.killProcess(Process.myPid());
    }

    protected boolean loadLibrary(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Exception | UnsatisfiedLinkError unused) {
            return false;
        }
    }

    public void lowMemory() {
        if (C0919J0.m351d()) {
            queueGLThreadEvent(new RunnableC0904C0(this));
        }
    }

    public void newIntent(Intent intent) {
        this.m_launchUri = intent.getData();
        this.m_MainThread.m335a(EnumC0910F0.f412i);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (this.mGlView.m388c()) {
            return false;
        }
        return injectEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public void onPause() {
        MultiWindowSupport.saveMultiWindowMode(this.mActivity);
        if (MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            return;
        }
        setupUnityToBePaused();
    }

    public void onResume() {
        if (!MultiWindowSupport.isInMultiWindowMode(this.mActivity) || MultiWindowSupport.isMultiWindowModeChangedToTrue(this.mActivity)) {
            setupUnityToBeResumed();
        }
    }

    public void onStart() {
        if (MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            setupUnityToBeResumed();
        }
    }

    public void onStop() {
        if (MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            setupUnityToBePaused();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mGlView.m388c()) {
            return false;
        }
        return injectEvent(motionEvent);
    }

    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerQuitted() {
    }

    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerUnloaded() {
    }

    public void pause() {
        setupUnityToBePaused();
    }

    protected void pauseJavaAndCallUnloadCallback() {
        runOnUiThread(new RunnableC0987r0(this));
    }

    void postOnUiThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    void queueGLThreadEvent(Runnable runnable) {
        if (C0919J0.m351d()) {
            if (Thread.currentThread() == this.m_MainThread) {
                runnable.run();
            } else {
                this.m_Events.add(runnable);
            }
        }
    }

    public void quit() {
        destroy();
    }

    public void removeViewFromPlayer(View view) {
        swapViews(this.mGlView, view);
        boolean z = view.getParent() == null;
        boolean z2 = this.mGlView.getParent() == this;
        if (z && z2) {
            return;
        }
        if (!z) {
            AbstractC0990t.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy");
        }
        if (z2) {
            return;
        }
        AbstractC0990t.Log(6, "removeVireFromPlayer: Failure agging old view to hierarchy");
    }

    public void reportError(String str, String str2) {
        AbstractC0990t.Log(6, str + ": " + str2);
    }

    protected void reportSoftInputArea(Rect rect) {
        queueGLThreadEvent((AbstractRunnableC0917I0) new C0979n0(this, rect));
    }

    protected void reportSoftInputIsVisible(boolean z) {
        queueGLThreadEvent((AbstractRunnableC0917I0) new C0981o0(this, z));
    }

    protected void reportSoftInputSelection(int i, int i2) {
        queueGLThreadEvent((AbstractRunnableC0917I0) new C0975l0(this, i, i2));
    }

    protected void reportSoftInputStr(String str, int i, boolean z) {
        if (i == 1) {
            hideSoftInput();
        }
        queueGLThreadEvent((AbstractRunnableC0917I0) new C0973k0(this, z, str, i));
    }

    protected void requestUserAuthorization(String str) {
        if (str == null || str.isEmpty() || this.mActivity == null) {
            return;
        }
        UnityPermissions.ModalWaitForPermissionResponse modalWaitForPermissionResponse = new UnityPermissions.ModalWaitForPermissionResponse();
        UnityPermissions.requestUserPermissions(this.mActivity, new String[]{str}, modalWaitForPermissionResponse);
        modalWaitForPermissionResponse.waitForResponse();
    }

    public void resume() {
        setupUnityToBeResumed();
    }

    void runOnAnonymousThread(Runnable runnable) {
        new Thread(runnable).start();
    }

    void runOnUiThread(Runnable runnable) {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.runOnUiThread(runnable);
        } else if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    void sendSurfaceChangedEvent() {
        if (C0919J0.m351d() && this.mState.m354a()) {
            RunnableC0997w0 runnableC0997w0 = new RunnableC0997w0(this);
            Handler handler = this.m_MainThread.f421a;
            if (handler != null) {
                Message.obtain(handler, runnableC0997w0).sendToTarget();
            }
        }
    }

    protected void setCharacterLimit(int i) {
        runOnUiThread(new RunnableC0967h0(this, i));
    }

    protected void setClipboardText(String str) {
        this.m_ClipboardManager.setPrimaryClip(ClipData.newPlainText("Text", str));
    }

    protected void setHideInputField(boolean z) {
        runOnUiThread(new RunnableC0969i0(this, z));
    }

    public void setMainSurfaceViewAspectRatio(float f) {
        if (this.mGlView != null) {
            runOnUiThread(new RunnableC0991t0(this, f));
        }
    }

    public void setOnHandleFocusListener(InterfaceC0994v interfaceC0994v) {
        this.mOnHandleFocusListener = interfaceC0994v;
    }

    public void setScreenBrightness(float f) {
        float max = Math.max(0.04f, f);
        if (this.m_Window == null || getScreenBrightness() == max) {
            return;
        }
        runOnUiThread(new RunnableC0993u0(this, max));
    }

    protected void setSelection(int i, int i2) {
        runOnUiThread(new RunnableC0971j0(this, i, i2));
    }

    protected void setSoftInputStr(String str) {
        runOnUiThread(new RunnableC0965g0(this, str));
    }

    protected void setupUnityToBePaused() {
        GoogleARCoreApi googleARCoreApi = this.m_ARCoreApi;
        if (googleARCoreApi != null) {
            googleARCoreApi.pauseARCore();
        }
        C0941U0 c0941u0 = this.mVideoPlayerProxy;
        if (c0941u0 != null) {
            c0941u0.m378b();
        }
        AudioVolumeHandler audioVolumeHandler = this.m_AudioVolumeHandler;
        if (audioVolumeHandler != null) {
            audioVolumeHandler.m330a();
            this.m_AudioVolumeHandler = null;
        }
        OrientationLockListener orientationLockListener = this.m_OrientationLockListener;
        if (orientationLockListener != null) {
            orientationLockListener.m367a();
            this.m_OrientationLockListener = null;
        }
        pauseUnity();
    }

    protected void setupUnityToBeResumed() {
        GoogleARCoreApi googleARCoreApi = this.m_ARCoreApi;
        if (googleARCoreApi != null) {
            googleARCoreApi.resumeARCore();
        }
        this.mState.m361e(false);
        C0941U0 c0941u0 = this.mVideoPlayerProxy;
        if (c0941u0 != null) {
            c0941u0.m379c();
        }
        checkResumePlayer();
        if (C0919J0.m351d()) {
            nativeRestartActivityIndicator();
        }
        if (this.m_AudioVolumeHandler == null) {
            this.m_AudioVolumeHandler = new AudioVolumeHandler(this.mContext);
        }
        if (this.m_OrientationLockListener == null && C0919J0.m351d()) {
            this.m_OrientationLockListener = new OrientationLockListener(this.mContext);
        }
        this.prevConfig = getResources().getConfiguration();
    }

    protected void showSoftInput(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6) {
        Semaphore semaphore = new Semaphore(0);
        postOnUiThread(new RunnableC0955b0(this, this, str, i, z, z2, z3, z4, str2, i2, z5, z6, semaphore));
        try {
            if (semaphore.tryAcquire(getSoftInputTimeout(), TimeUnit.MILLISECONDS)) {
                return;
            }
            AbstractC0990t.Log(6, "Timeout (" + getSoftInputTimeout() + " ms) while waiting softinput showing operation.");
        } catch (InterruptedException unused) {
            AbstractC0990t.Log(6, "UI thread got interrupted while waiting softinput showing operation.");
        }
    }

    protected boolean showVideoPlayer(String str, int i, int i2, int i3, boolean z, int i4, int i5) {
        if (this.mVideoPlayerProxy == null) {
            this.mVideoPlayerProxy = new C0941U0(this);
        }
        boolean m377a = this.mVideoPlayerProxy.m377a(this.mContext, str, i, i2, i3, z, i4, i5, new C0983p0(this));
        if (m377a) {
            runOnUiThread(new RunnableC0985q0(this));
        }
        return m377a;
    }

    protected boolean skipPermissionsDialog() {
        Activity activity = this.mActivity;
        if (activity != null) {
            return UnityPermissions.skipPermissionsDialog(activity);
        }
        return false;
    }

    public boolean startOrientationListener(int i) {
        String str;
        if (this.mOrientationListener != null) {
            str = "Orientation Listener already started.";
        } else {
            C0989s0 c0989s0 = new C0989s0(this, this.mContext, i);
            this.mOrientationListener = c0989s0;
            if (c0989s0.canDetectOrientation()) {
                this.mOrientationListener.enable();
                return true;
            }
            str = "Orientation Listener cannot detect orientation.";
        }
        AbstractC0990t.Log(5, str);
        return false;
    }

    public boolean stopOrientationListener() {
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener == null) {
            AbstractC0990t.Log(5, "Orientation Listener was not started.");
            return false;
        }
        orientationEventListener.disable();
        this.mOrientationListener = null;
        return true;
    }

    protected void toggleGyroscopeSensor(boolean z) {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        if (z) {
            sensorManager.registerListener(this.m_FakeListener, defaultSensor, 1);
        } else {
            sensorManager.unregisterListener(this.m_FakeListener);
        }
    }

    public void unload() {
        nativeApplicationUnload();
    }

    void updateGLDisplay(int i, Surface surface) {
        if (this.mMainDisplayOverride) {
            return;
        }
        updateDisplayInternal(i, surface);
    }

    public void windowFocusChanged(boolean z) {
        AbstractC0916I abstractC0916I;
        this.mState.m356b(z);
        if (!this.mState.m354a() || ((abstractC0916I = this.mSoftInput) != null && !abstractC0916I.mo344d())) {
            raiseFocusListener(z);
            return;
        }
        this.m_MainThread.m335a(z ? EnumC0910F0.f410g : EnumC0910F0.f409f);
        raiseFocusListener(z);
        checkResumePlayer();
    }
}

// ===== FILE: com/unity3d/player/UnityPlayerActivity.java =====
package com.unity3d.player;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public class UnityPlayerActivity extends Activity implements IUnityPlayerLifecycleEvents {
    protected UnityPlayer mUnityPlayer;

    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerQuitted() {
    }

    protected String updateUnityCommandLineArguments(String str) {
        return str;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getIntent().putExtra("unity", updateUnityCommandLineArguments(getIntent().getStringExtra("unity")));
        UnityPlayer unityPlayer = new UnityPlayer(this, this);
        this.mUnityPlayer = unityPlayer;
        setContentView(unityPlayer);
        this.mUnityPlayer.requestFocus();
    }

    @Override // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerUnloaded() {
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        this.mUnityPlayer.newIntent(intent);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.mUnityPlayer.destroy();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mUnityPlayer.onStop();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mUnityPlayer.onStart();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mUnityPlayer.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mUnityPlayer.onResume();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mUnityPlayer.lowMemory();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (i == 15) {
            this.mUnityPlayer.lowMemory();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mUnityPlayer.configurationChanged(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.mUnityPlayer.windowFocusChanged(z);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 2) {
            return this.mUnityPlayer.injectEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mUnityPlayer.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mUnityPlayer.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mUnityPlayer.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return this.mUnityPlayer.onGenericMotionEvent(motionEvent);
    }
}

// ===== FILE: com/unity3d/player/ViewTreeObserverOnGlobalLayoutListenerC0928O.java =====
package com.unity3d.player;

import android.view.ViewTreeObserver;

/* renamed from: com.unity3d.player.O */
/* loaded from: classes.dex */
final class ViewTreeObserverOnGlobalLayoutListenerC0928O implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ C0936S f493a;

    ViewTreeObserverOnGlobalLayoutListenerC0928O(C0936S c0936s) {
        this.f493a = c0936s;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f493a.reportSoftInputArea();
    }
}
