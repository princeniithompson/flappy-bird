// Package bundle: com.unity3d.ads.gl (4 classes)

// ============================================================
// CLASS: com.unity3d.ads.gl.EglCore
// ============================================================
package com.unity3d.ads.gl;

public final class EglCore {
    public static final EglCore$Companion Companion = null;
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;
    private int glVersion;
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;

    static <clinit>() {
        new EglCore$Companion(0);
        Companion = new EglCore$Companion(..);
        return;
    }

    public EglCore() {
        new EglCore(0, 0, 3, 0);
        return;
    }

    public EglCore(EGLContext p0, int p1) {
        new Object();
        mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        mEGLContext = EGL14.EGL_NO_CONTEXT;
        glVersion = -1;
        if (if-ne(mEGLDisplay, EGL14.EGL_NO_DISPLAY)) goto L_9d;
        if (if-nez(p0)) goto L_18;
      L_18:
        EGL14.eglGetDisplay(0);
        mEGLDisplay = EGL14.eglGetDisplay(..);
        if (if-eq(EGL14.eglGetDisplay(..), EGL14.EGL_NO_DISPLAY)) goto L_95;
        EGL14.eglInitialize(mEGLDisplay, EGL14.EGL_NO_DISPLAY, 0, EGL14.EGL_NO_DISPLAY, 1);
        if (if-eqz(EGL14.eglInitialize(..))) goto L_8a;
        if (if-eqz(EGL14.eglInitialize(..))) goto L_53;
        new Object(..).getConfig(p1, 3);
        if (if-eqz(EglCore.getConfig(..))) goto L_53;
        EGL14.eglCreateContext(mEGLDisplay, EglCore.getConfig(..), EGL14.EGL_NO_CONTEXT, v5, 0);
        EGL14.eglGetError();
        if (if-ne(EGL14.eglGetError(..), 12288)) goto L_53;
        mEGLConfig = EglCore.getConfig(..);
        mEGLContext = EGL14.eglCreateContext(..);
        glVersion = 3;
      L_53:
        if (if-ne(mEGLContext, EGL14.EGL_NO_CONTEXT)) goto L_7e;
        new Object(..).getConfig(p1, 2);
        if (if-eqz(EglCore.getConfig(..))) goto L_76;
        EGL14.eglCreateContext(mEGLDisplay, EglCore.getConfig(..), EGL14.EGL_NO_CONTEXT, mEGLContext, 0);
        new Object(..).checkEglError("eglCreateContext");
        mEGLConfig = EglCore.getConfig(..);
        mEGLContext = EGL14.eglCreateContext(..);
        glVersion = 2;
      L_76:
        new RuntimeException("Unable to find a suitable EGLConfig");
        throw new RuntimeException(..);
      L_7e:
        EGL14.eglQueryContext(mEGLDisplay, mEGLContext, 12440, new RuntimeException(..), 0);
        return;
      L_8a:
        mEGLDisplay = 0;
        new RuntimeException("unable to initialize EGL14");
        throw new RuntimeException(..);
      L_95:
        new RuntimeException("unable to get EGL14 display");
        throw new RuntimeException(..);
      L_9d:
        new RuntimeException("EGL already set up");
        throw new RuntimeException(..);
    }

    public EglCore(EGLContext p0, int p1, int p2, DefaultConstructorMarker p3) {
        if (if-eqz(p3)) goto L_5;
      L_5:
        if (if-eqz(p2)) goto L_a;
      L_a:
        new EglCore(0, 0);
        return;
    }

    private final void checkEglError(String p0) {
        EGL14.eglGetError();
        if (if-ne(EGL14.eglGetError(..), 12288)) goto L_9;
        return;
      L_9:
        new StringBuilder();
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(": EGL error: 0x");
        Integer.toHexString(EGL14.eglGetError(..));
        new StringBuilder(..).append(Integer.toHexString(..));
        new StringBuilder(..).toString();
        new RuntimeException(StringBuilder.toString(..));
        throw new RuntimeException(..);
    }

    private final EGLConfig getConfig(int p0, int p1) {
        if (if-lt(p1, 3)) goto L_7;
      L_7:
      L_8:
        if (if-eqz(p0)) goto L_4b;
      L_4b:
        EGL14.eglChooseConfig(mEGLDisplay, v4, 0, 12610, 0, 1, v9, 0);
        if (if-nez(EGL14.eglChooseConfig(..))) goto L_5e;
        return 0;
      L_5e:
        return 0;
    }

    public final EGLSurface createOffscreenSurface(int p0, int p1) {
        EGL14.eglCreatePbufferSurface(mEGLDisplay, mEGLConfig, 5, 0);
        EglCore.checkEglError("eglCreatePbufferSurface");
        if (if-eqz(EGL14.eglCreatePbufferSurface(..))) goto L_28;
        return EGL14.eglCreatePbufferSurface(..);
      L_28:
        new RuntimeException("surface was null");
        throw new RuntimeException(..);
    }

    protected final void finalize() {
        if (if-eq(mEGLDisplay, EGL14.EGL_NO_DISPLAY)) goto L_9;
        EglCore.release();
      L_9:
        return;
    }

    public final int getGlVersion() {
        return glVersion;
    }

    public final void makeCurrent(EGLSurface p0) {
        EGL14.eglMakeCurrent(mEGLDisplay, p0, p0, mEGLContext);
        if (if-eqz(EGL14.eglMakeCurrent(..))) goto L_b;
        return;
      L_b:
        new RuntimeException("eglMakeCurrent failed");
        throw new RuntimeException(..);
    }

    public final void release() {
        if (if-eq(mEGLDisplay, EGL14.EGL_NO_DISPLAY)) goto L_20;
        EGL14.eglMakeCurrent(mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroyContext(mEGLDisplay, mEGLContext);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(mEGLDisplay);
      L_20:
        mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        mEGLContext = EGL14.EGL_NO_CONTEXT;
        mEGLConfig = 0;
        return;
    }

    public final boolean releaseSurface(EGLSurface p0) {
        EGL14.eglDestroySurface(mEGLDisplay, p0);
        return EGL14.eglDestroySurface(..);
    }

    public final void setGlVersion(int p0) {
        glVersion = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.gl.EglSurfaceBase
// ============================================================
package com.unity3d.ads.gl;

public class EglSurfaceBase {
    private EGLSurface mEGLSurface;
    private EglCore mEglCore;
    private int mHeight;
    private int mWidth;

    protected EglSurfaceBase(EglCore p0) {
        new Object();
        mEGLSurface = EGL14.EGL_NO_SURFACE;
        mWidth = -1;
        mHeight = -1;
        mEglCore = p0;
        return;
    }

    public final void createOffscreenSurface(int p0, int p1) {
        if (if-ne(mEGLSurface, EGL14.EGL_NO_SURFACE)) goto L_8;
      L_8:
      L_9:
        if (if-eqz(0)) goto L_18;
        mEglCore.createOffscreenSurface(p0, p1);
        mEGLSurface = EglCore.createOffscreenSurface(..);
        mWidth = p0;
        mHeight = p1;
        return;
      L_18:
        "surface already created".toString();
        new IllegalStateException(Object.toString(..));
        throw new IllegalStateException(..);
    }

    public final void makeCurrent() {
        mEglCore.makeCurrent(mEGLSurface);
        return;
    }

    public final void releaseEglSurface() {
        mEglCore.releaseSurface(mEGLSurface);
        mEGLSurface = EGL14.EGL_NO_SURFACE;
        mHeight = -1;
        mWidth = -1;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.gl.OffscreenSurface
// ============================================================
package com.unity3d.ads.gl;

public final class OffscreenSurface extends EglSurfaceBase {
    public OffscreenSurface(EglCore p0, int p1, int p2) {
        new EglSurfaceBase(p0);
        new EglSurfaceBase(..).createOffscreenSurface(p1, p2);
        return;
    }

    public final void release() {
        OffscreenSurface.releaseEglSurface();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.gl.EglCore$Companion
// ============================================================
package com.unity3d.ads.gl;

public final class EglCore$Companion {
    private EglCore$Companion() {
        new Object();
        return;
    }

    public EglCore$Companion(DefaultConstructorMarker p0) {
        new EglCore$Companion();
        return;
    }

}

