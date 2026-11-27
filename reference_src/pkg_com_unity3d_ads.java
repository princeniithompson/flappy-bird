// Package bundle: com.unity3d.ads (14 classes)

// ============================================================
// CLASS: com.unity3d.ads.BuildConfig
// ============================================================
package com.unity3d.ads;

public final class BuildConfig {
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String LIBRARY_PACKAGE_NAME = "com.unity3d.ads";
    public static final int VERSION_CODE = 41205;
    public static final String VERSION_NAME = "4.12.5";
    public static final String WEBVIEW_BRANCH = "4.12.5";

    public BuildConfig() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.IUnityAdsInitializationListener
// ============================================================
package com.unity3d.ads;

public abstract class IUnityAdsInitializationListener {
    public abstract void onInitializationComplete() {
        // native or abstract
    }

    public abstract void onInitializationFailed(UnityAds$UnityAdsInitializationError p0, String p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.IUnityAdsLoadListener
// ============================================================
package com.unity3d.ads;

public abstract class IUnityAdsLoadListener {
    public abstract void onUnityAdsAdLoaded(String p0) {
        // native or abstract
    }

    public abstract void onUnityAdsFailedToLoad(String p0, UnityAds$UnityAdsLoadError p1, String p2) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.IUnityAdsShowListener
// ============================================================
package com.unity3d.ads;

public abstract class IUnityAdsShowListener {
    public abstract void onUnityAdsShowClick(String p0) {
        // native or abstract
    }

    public abstract void onUnityAdsShowComplete(String p0, UnityAds$UnityAdsShowCompletionState p1) {
        // native or abstract
    }

    public abstract void onUnityAdsShowFailure(String p0, UnityAds$UnityAdsShowError p1, String p2) {
        // native or abstract
    }

    public abstract void onUnityAdsShowStart(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.IUnityAdsTokenListener
// ============================================================
package com.unity3d.ads;

public abstract class IUnityAdsTokenListener {
    public abstract void onUnityAdsTokenReady(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.UnityAds
// ============================================================
package com.unity3d.ads;

public final class UnityAds {
    public static final UnityAds INSTANCE;

    static <clinit>() {
        new UnityAds();
        INSTANCE = new UnityAds(..);
        return;
    }

    private UnityAds() {
        new Object();
        return;
    }

    public static final boolean getDebugMode() {
        UnityAdsImplementation.getInstance();
        IUnityAds.getDebugMode();
        return IUnityAds.getDebugMode(..);
    }

    public static void getDebugMode$annotations() {
        return;
    }

    public static final String getToken() {
        UnityAdsImplementation.getInstance();
        IUnityAds.getToken();
        return IUnityAds.getToken(..);
    }

    public static final void getToken(IUnityAdsTokenListener p0) {
        UnityAdsImplementation.getInstance();
        IUnityAds.getToken(p0);
        return;
    }

    public static void getToken$annotations() {
        return;
    }

    public static final String getVersion() {
        UnityAdsImplementation.getInstance();
        IUnityAds.getVersion();
        return IUnityAds.getVersion(..);
    }

    public static void getVersion$annotations() {
        return;
    }

    public static final void initialize(Context p0, String p1) {
        UnityAdsImplementation.getInstance();
        IUnityAds.initialize(p0, p1, 0, 0);
        return;
    }

    public static final void initialize(Context p0, String p1, IUnityAdsInitializationListener p2) {
        UnityAdsImplementation.getInstance();
        IUnityAds.initialize(p0, p1, 0, p2);
        return;
    }

    public static final void initialize(Context p0, String p1, boolean p2) {
        UnityAdsImplementation.getInstance();
        IUnityAds.initialize(p0, p1, p2, 0);
        return;
    }

    public static final void initialize(Context p0, String p1, boolean p2, IUnityAdsInitializationListener p3) {
        UnityAdsImplementation.getInstance();
        IUnityAds.initialize(p0, p1, p2, p3);
        return;
    }

    public static final boolean isInitialized() {
        UnityAdsImplementation.getInstance();
        IUnityAds.isInitialized();
        return IUnityAds.isInitialized(..);
    }

    public static void isInitialized$annotations() {
        return;
    }

    public static final boolean isSupported() {
        UnityAdsImplementation.getInstance();
        IUnityAds.isSupported();
        return IUnityAds.isSupported(..);
    }

    public static void isSupported$annotations() {
        return;
    }

    public static final void load(String p0) {
        new UnityAds$load$1();
        UnityAds.load(p0, new UnityAds$load$1(..));
        return;
    }

    public static final void load(String p0, IUnityAdsLoadListener p1) {
        UnityAdsImplementation.getInstance();
        new UnityAdsLoadOptions();
        IUnityAds.load(p0, new UnityAdsLoadOptions(..), p1);
        return;
    }

    public static final void load(String p0, UnityAdsLoadOptions p1, IUnityAdsLoadListener p2) {
        UnityAdsImplementation.getInstance();
        if (if-nez(p1)) goto L_b;
        new UnityAdsLoadOptions();
      L_b:
        IUnityAds.load(p0, new UnityAdsLoadOptions(..), p2);
        return;
    }

    public static final void setDebugMode(boolean p0) {
        UnityAdsImplementation.getInstance();
        IUnityAds.setDebugMode(p0);
        return;
    }

    public static final void show(Activity p0, String p1) {
        UnityAdsImplementation.getInstance();
        new UnityAdsShowOptions();
        IUnityAds.show(p0, p1, new UnityAdsShowOptions(..), 0);
        return;
    }

    public static final void show(Activity p0, String p1, IUnityAdsShowListener p2) {
        UnityAdsImplementation.getInstance();
        new UnityAdsShowOptions();
        IUnityAds.show(p0, p1, new UnityAdsShowOptions(..), p2);
        return;
    }

    public static final void show(Activity p0, String p1, UnityAdsShowOptions p2) {
        UnityAdsImplementation.getInstance();
        IUnityAds.show(p0, p1, p2, 0);
        return;
    }

    public static final void show(Activity p0, String p1, UnityAdsShowOptions p2, IUnityAdsShowListener p3) {
        UnityAdsImplementation.getInstance();
        IUnityAds.show(p0, p1, p2, p3);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.UnityAdsBaseOptions
// ============================================================
package com.unity3d.ads;

public class UnityAdsBaseOptions {
    private String OBJECT_ID;
    private JSONObject _data;

    public UnityAdsBaseOptions() {
        new Object();
        OBJECT_ID = "objectId";
        new JSONObject();
        _data = new JSONObject(..);
        return;
    }

    public JSONObject getData() {
        return _data;
    }

    public String getObjectId() {
        _data.getString(OBJECT_ID);
        return JSONObject.getString(..);
        return 0;
    }

    public void set(String p0, String p1) {
        if (if-eqz(p0)) goto L_10;
        if (if-eqz(p1)) goto L_10;
        _data.put(p0, p1);
        DeviceLog.exception("Failed to set Unity Ads options", p0);
      L_10:
        return;
    }

    public void setObjectId(String p0) {
        UnityAdsBaseOptions.set(OBJECT_ID, p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.UnityAdsLoadOptions
// ============================================================
package com.unity3d.ads;

public class UnityAdsLoadOptions extends UnityAdsBaseOptions {
    private String AD_MARKUP;

    public UnityAdsLoadOptions() {
        new UnityAdsBaseOptions();
        AD_MARKUP = "adMarkup";
        return;
    }

    public void setAdMarkup(String p0) {
        UnityAdsLoadOptions.set(AD_MARKUP, p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.UnityAdsShowOptions
// ============================================================
package com.unity3d.ads;

public class UnityAdsShowOptions extends UnityAdsBaseOptions {
    public UnityAdsShowOptions() {
        new UnityAdsBaseOptions();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.UnityAds$UnityAdsInitializationError
// ============================================================
package com.unity3d.ads;

public final class UnityAds$UnityAdsInitializationError extends Enum {
    private static final UnityAds$UnityAdsInitializationError[] $VALUES;
    public static final UnityAds$UnityAdsInitializationError AD_BLOCKER_DETECTED;
    public static final UnityAds$UnityAdsInitializationError INTERNAL_ERROR;
    public static final UnityAds$UnityAdsInitializationError INVALID_ARGUMENT;

    private static final UnityAds$UnityAdsInitializationError[] $values() {
        return 3;
    }

    static <clinit>() {
        new UnityAds$UnityAdsInitializationError("INTERNAL_ERROR", 0);
        INTERNAL_ERROR = new UnityAds$UnityAdsInitializationError(..);
        new UnityAds$UnityAdsInitializationError("INVALID_ARGUMENT", 1);
        INVALID_ARGUMENT = new UnityAds$UnityAdsInitializationError(..);
        new UnityAds$UnityAdsInitializationError("AD_BLOCKER_DETECTED", 2);
        AD_BLOCKER_DETECTED = new UnityAds$UnityAdsInitializationError(..);
        UnityAds$UnityAdsInitializationError.$values();
        $VALUES = UnityAds$UnityAdsInitializationError.$values(..);
        return;
    }

    private UnityAds$UnityAdsInitializationError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static UnityAds$UnityAdsInitializationError valueOf(String p0) {
        Enum.valueOf(UnityAds$UnityAdsInitializationError.class, p0);
        return Enum.valueOf(..);
    }

    public static UnityAds$UnityAdsInitializationError[] values() {
        Object[].clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.UnityAds$UnityAdsLoadError
// ============================================================
package com.unity3d.ads;

public final class UnityAds$UnityAdsLoadError extends Enum {
    private static final UnityAds$UnityAdsLoadError[] $VALUES;
    public static final UnityAds$UnityAdsLoadError INITIALIZE_FAILED;
    public static final UnityAds$UnityAdsLoadError INTERNAL_ERROR;
    public static final UnityAds$UnityAdsLoadError INVALID_ARGUMENT;
    public static final UnityAds$UnityAdsLoadError NO_FILL;
    public static final UnityAds$UnityAdsLoadError TIMEOUT;

    private static final UnityAds$UnityAdsLoadError[] $values() {
        return 5;
    }

    static <clinit>() {
        new UnityAds$UnityAdsLoadError("INITIALIZE_FAILED", 0);
        INITIALIZE_FAILED = new UnityAds$UnityAdsLoadError(..);
        new UnityAds$UnityAdsLoadError("INTERNAL_ERROR", 1);
        INTERNAL_ERROR = new UnityAds$UnityAdsLoadError(..);
        new UnityAds$UnityAdsLoadError("INVALID_ARGUMENT", 2);
        INVALID_ARGUMENT = new UnityAds$UnityAdsLoadError(..);
        new UnityAds$UnityAdsLoadError("NO_FILL", 3);
        NO_FILL = new UnityAds$UnityAdsLoadError(..);
        new UnityAds$UnityAdsLoadError("TIMEOUT", 4);
        TIMEOUT = new UnityAds$UnityAdsLoadError(..);
        UnityAds$UnityAdsLoadError.$values();
        $VALUES = UnityAds$UnityAdsLoadError.$values(..);
        return;
    }

    private UnityAds$UnityAdsLoadError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static UnityAds$UnityAdsLoadError valueOf(String p0) {
        Enum.valueOf(UnityAds$UnityAdsLoadError.class, p0);
        return Enum.valueOf(..);
    }

    public static UnityAds$UnityAdsLoadError[] values() {
        UnityAds$UnityAdsLoadError.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.UnityAds$UnityAdsShowCompletionState
// ============================================================
package com.unity3d.ads;

public final class UnityAds$UnityAdsShowCompletionState extends Enum {
    private static final UnityAds$UnityAdsShowCompletionState[] $VALUES;
    public static final UnityAds$UnityAdsShowCompletionState COMPLETED;
    public static final UnityAds$UnityAdsShowCompletionState SKIPPED;

    private static final UnityAds$UnityAdsShowCompletionState[] $values() {
        return 2;
    }

    static <clinit>() {
        new UnityAds$UnityAdsShowCompletionState("SKIPPED", 0);
        SKIPPED = new UnityAds$UnityAdsShowCompletionState(..);
        new UnityAds$UnityAdsShowCompletionState("COMPLETED", 1);
        COMPLETED = new UnityAds$UnityAdsShowCompletionState(..);
        UnityAds$UnityAdsShowCompletionState.$values();
        $VALUES = UnityAds$UnityAdsShowCompletionState.$values(..);
        return;
    }

    private UnityAds$UnityAdsShowCompletionState(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static UnityAds$UnityAdsShowCompletionState valueOf(String p0) {
        Enum.valueOf(UnityAds$UnityAdsShowCompletionState.class, p0);
        return Enum.valueOf(..);
    }

    public static UnityAds$UnityAdsShowCompletionState[] values() {
        Object[].clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.UnityAds$UnityAdsShowError
// ============================================================
package com.unity3d.ads;

public final class UnityAds$UnityAdsShowError extends Enum {
    private static final UnityAds$UnityAdsShowError[] $VALUES;
    public static final UnityAds$UnityAdsShowError ALREADY_SHOWING;
    public static final UnityAds$UnityAdsShowError INTERNAL_ERROR;
    public static final UnityAds$UnityAdsShowError INVALID_ARGUMENT;
    public static final UnityAds$UnityAdsShowError NOT_INITIALIZED;
    public static final UnityAds$UnityAdsShowError NOT_READY;
    public static final UnityAds$UnityAdsShowError NO_CONNECTION;
    public static final UnityAds$UnityAdsShowError TIMEOUT;
    public static final UnityAds$UnityAdsShowError VIDEO_PLAYER_ERROR;

    private static final UnityAds$UnityAdsShowError[] $values() {
        return 8;
    }

    static <clinit>() {
        new UnityAds$UnityAdsShowError("NOT_INITIALIZED", 0);
        NOT_INITIALIZED = new UnityAds$UnityAdsShowError(..);
        new UnityAds$UnityAdsShowError("NOT_READY", 1);
        NOT_READY = new UnityAds$UnityAdsShowError(..);
        new UnityAds$UnityAdsShowError("VIDEO_PLAYER_ERROR", 2);
        VIDEO_PLAYER_ERROR = new UnityAds$UnityAdsShowError(..);
        new UnityAds$UnityAdsShowError("INVALID_ARGUMENT", 3);
        INVALID_ARGUMENT = new UnityAds$UnityAdsShowError(..);
        new UnityAds$UnityAdsShowError("NO_CONNECTION", 4);
        NO_CONNECTION = new UnityAds$UnityAdsShowError(..);
        new UnityAds$UnityAdsShowError("ALREADY_SHOWING", 5);
        ALREADY_SHOWING = new UnityAds$UnityAdsShowError(..);
        new UnityAds$UnityAdsShowError("INTERNAL_ERROR", 6);
        INTERNAL_ERROR = new UnityAds$UnityAdsShowError(..);
        new UnityAds$UnityAdsShowError("TIMEOUT", 7);
        TIMEOUT = new UnityAds$UnityAdsShowError(..);
        UnityAds$UnityAdsShowError.$values();
        $VALUES = UnityAds$UnityAdsShowError.$values(..);
        return;
    }

    private UnityAds$UnityAdsShowError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static UnityAds$UnityAdsShowError valueOf(String p0) {
        Enum.valueOf(UnityAds$UnityAdsShowError.class, p0);
        return Enum.valueOf(..);
    }

    public static UnityAds$UnityAdsShowError[] values() {
        UnityAds$UnityAdsShowError.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.UnityAds$load$1
// ============================================================
package com.unity3d.ads;

public final class UnityAds$load$1 {
    UnityAds$load$1() {
        new Object();
        return;
    }

    public void onUnityAdsAdLoaded(String p0) {
        return;
    }

    public void onUnityAdsFailedToLoad(String p0, UnityAds$UnityAdsLoadError p1, String p2) {
        return;
    }

}

