
// ===== FILE: com/google/androidgamesdk/C0524b.java =====
package com.google.androidgamesdk;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* renamed from: com.google.androidgamesdk.b */
/* loaded from: classes.dex */
final class C0524b extends Thread {

    /* renamed from: a */
    public Handler f104a;

    private C0524b() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Log.i("ChoreographerCallback", "Starting looper thread");
        Looper.prepare();
        this.f104a = new Handler();
        Looper.loop();
        Log.i("ChoreographerCallback", "Terminating looper thread");
    }
}

// ===== FILE: com/google/androidgamesdk/C0526d.java =====
package com.google.androidgamesdk;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.androidgamesdk.d */
/* loaded from: classes.dex */
final class C0526d extends Thread {

    /* renamed from: a */
    public Handler f107a;

    /* renamed from: b */
    private ReentrantLock f108b;

    /* renamed from: c */
    private Condition f109c;

    private C0526d() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f108b = reentrantLock;
        this.f109c = reentrantLock.newCondition();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Log.i("SwappyDisplayManager", "Starting looper thread");
        this.f108b.lock();
        Looper.prepare();
        this.f107a = new Handler();
        this.f109c.signal();
        this.f108b.unlock();
        Looper.loop();
        Log.i("SwappyDisplayManager", "Terminating looper thread");
    }

    @Override // java.lang.Thread
    public final void start() {
        this.f108b.lock();
        super.start();
        try {
            this.f109c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.f108b.unlock();
    }
}

// ===== FILE: com/google/androidgamesdk/ChoreographerCallback.java =====
package com.google.androidgamesdk;

import android.view.Choreographer;

/* loaded from: classes.dex */
public class ChoreographerCallback implements Choreographer.FrameCallback {
    private static final String LOG_TAG = "ChoreographerCallback";
    private long mCookie;
    private C0524b mLooper;

    public ChoreographerCallback(long j) {
        this.mCookie = j;
        C0524b c0524b = new C0524b();
        this.mLooper = c0524b;
        c0524b.start();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        nOnChoreographer(this.mCookie, j);
    }

    public native void nOnChoreographer(long j, long j2);

    public void postFrameCallback() {
        this.mLooper.f104a.post(new RunnableC0523a(this));
    }

    public void postFrameCallbackDelayed(long j) {
        Choreographer.getInstance().postFrameCallbackDelayed(this, j);
    }

    public void terminate() {
        this.mLooper.f104a.getLooper().quit();
    }
}

// ===== FILE: com/google/androidgamesdk/RunnableC0523a.java =====
package com.google.androidgamesdk;

import android.view.Choreographer;

/* renamed from: com.google.androidgamesdk.a */
/* loaded from: classes.dex */
final class RunnableC0523a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ChoreographerCallback f103a;

    RunnableC0523a(ChoreographerCallback choreographerCallback) {
        this.f103a = choreographerCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Choreographer.getInstance().postFrameCallback(this.f103a);
    }
}

// ===== FILE: com/google/androidgamesdk/RunnableC0525c.java =====
package com.google.androidgamesdk;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

/* renamed from: com.google.androidgamesdk.c */
/* loaded from: classes.dex */
final class RunnableC0525c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f105a;

    /* renamed from: b */
    final /* synthetic */ SwappyDisplayManager f106b;

    RunnableC0525c(SwappyDisplayManager swappyDisplayManager, int i) {
        this.f106b = swappyDisplayManager;
        this.f105a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        activity = this.f106b.mActivity;
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.preferredDisplayModeId = this.f105a;
        window.setAttributes(attributes);
    }
}

// ===== FILE: com/google/androidgamesdk/SwappyDisplayManager.java =====
package com.google.androidgamesdk;

import android.app.Activity;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class SwappyDisplayManager implements DisplayManager.DisplayListener {
    private Activity mActivity;
    private long mCookie;
    private Display.Mode mCurrentMode;
    private C0526d mLooper;
    private WindowManager mWindowManager;
    private final String LOG_TAG = "SwappyDisplayManager";
    private final boolean DEBUG = false;
    private final long ONE_MS_IN_NS = 1000000;
    private final long ONE_S_IN_NS = 1000000000;

    public SwappyDisplayManager(long j, Activity activity) {
        String string;
        try {
            Bundle bundle = activity.getPackageManager().getActivityInfo(activity.getIntent().getComponent(), 128).metaData;
            if (bundle != null && (string = bundle.getString("android.app.lib_name")) != null) {
                System.loadLibrary(string);
            }
        } catch (Throwable th) {
            Log.e("SwappyDisplayManager", th.getMessage());
        }
        this.mCookie = j;
        this.mActivity = activity;
        WindowManager windowManager = (WindowManager) activity.getSystemService(WindowManager.class);
        this.mWindowManager = windowManager;
        Display defaultDisplay = windowManager.getDefaultDisplay();
        this.mCurrentMode = defaultDisplay.getMode();
        updateSupportedRefreshRates(defaultDisplay);
        DisplayManager displayManager = (DisplayManager) this.mActivity.getSystemService(DisplayManager.class);
        synchronized (this) {
            C0526d c0526d = new C0526d();
            this.mLooper = c0526d;
            c0526d.start();
            displayManager.registerDisplayListener(this, this.mLooper.f107a);
        }
    }

    private boolean modeMatchesCurrentResolution(Display.Mode mode) {
        return mode.getPhysicalHeight() == this.mCurrentMode.getPhysicalHeight() && mode.getPhysicalWidth() == this.mCurrentMode.getPhysicalWidth();
    }

    private native void nOnRefreshPeriodChanged(long j, long j2, long j3, long j4);

    private native void nSetSupportedRefreshPeriods(long j, long[] jArr, int[] iArr);

    private void updateSupportedRefreshRates(Display display) {
        Display.Mode[] supportedModes = display.getSupportedModes();
        int i = 0;
        for (Display.Mode mode : supportedModes) {
            if (modeMatchesCurrentResolution(mode)) {
                i++;
            }
        }
        long[] jArr = new long[i];
        int[] iArr = new int[i];
        int i2 = 0;
        for (int i3 = 0; i3 < supportedModes.length; i3++) {
            if (modeMatchesCurrentResolution(supportedModes[i3])) {
                jArr[i2] = (long) (1.0E9f / supportedModes[i3].getRefreshRate());
                iArr[i2] = supportedModes[i3].getModeId();
                i2++;
            }
        }
        nSetSupportedRefreshPeriods(this.mCookie, jArr, iArr);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int i) {
        synchronized (this) {
            Display defaultDisplay = this.mWindowManager.getDefaultDisplay();
            float refreshRate = defaultDisplay.getRefreshRate();
            Display.Mode mode = defaultDisplay.getMode();
            boolean z = true;
            boolean z2 = (mode.getPhysicalWidth() != this.mCurrentMode.getPhysicalWidth()) | (mode.getPhysicalHeight() != this.mCurrentMode.getPhysicalHeight());
            if (refreshRate == this.mCurrentMode.getRefreshRate()) {
                z = false;
            }
            this.mCurrentMode = mode;
            if (z2) {
                updateSupportedRefreshRates(defaultDisplay);
            }
            if (z) {
                long j = (long) (1.0E9f / refreshRate);
                nOnRefreshPeriodChanged(this.mCookie, j, defaultDisplay.getAppVsyncOffsetNanos(), j - (this.mWindowManager.getDefaultDisplay().getPresentationDeadlineNanos() - 1000000));
            }
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int i) {
    }

    public void setPreferredDisplayModeId(int i) {
        this.mActivity.runOnUiThread(new RunnableC0525c(this, i));
    }

    public void terminate() {
        this.mLooper.f107a.getLooper().quit();
    }
}
