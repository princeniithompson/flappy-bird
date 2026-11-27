// Package bundle: com.unity3d.services.ads.gmascar.bridges.mobileads (7 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.mobileads.IMobileAdsBridge
// ============================================================
package com.unity3d.services.ads.gmascar.bridges.mobileads;

public abstract class IMobileAdsBridge {
    public abstract ScarAdapterVersion getAdapterVersion(int p0) {
        // native or abstract
    }

    public abstract Object getInitializationStatus() {
        // native or abstract
    }

    public abstract int getVersionCodeIndex() {
        // native or abstract
    }

    public abstract String getVersionMethodName() {
        // native or abstract
    }

    public abstract String getVersionString() {
        // native or abstract
    }

    public abstract void initialize(Context p0, Object p1) {
        // native or abstract
    }

    public abstract boolean shouldInitialize() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge
// ============================================================
package com.unity3d.services.ads.gmascar.bridges.mobileads;

public class MobileAdsBridge extends MobileAdsBridgeBase {
    public static final int CODE_21 = 21;
    public static final String versionMethodName = "getVersion";
    private ConfigurationReader _configurationReader;

    public MobileAdsBridge() {
        new MobileAdsBridge$1();
        new MobileAdsBridgeBase(new MobileAdsBridge$1(..));
        new ConfigurationReader();
        _configurationReader = new ConfigurationReader(..);
        return;
    }

    public ScarAdapterVersion getAdapterVersion(int p0) {
        if (if-ne(p0, -1)) goto L_6;
        return ScarAdapterVersion.NA;
      L_6:
        if (if-ge(ScarAdapterVersion.NA, 23)) goto L_d;
        return ScarAdapterVersion.V21;
      L_d:
        return ScarAdapterVersion.V23;
    }

    public int getVersionCodeIndex() {
        return 0;
    }

    public String getVersionMethodName() {
        return "getVersion";
    }

    public boolean hasSCARBiddingSupport() {
        return 1;
    }

    public boolean shouldInitialize() {
        _configurationReader.getCurrentConfiguration();
        Configuration.getExperiments();
        Configuration.getExperiments(..).isScarInitEnabled();
        return IExperiments.isScarInitEnabled(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase
// ============================================================
package com.unity3d.services.ads.gmascar.bridges.mobileads;

public abstract class MobileAdsBridgeBase extends GenericBridge {
    public static final String initializationStatusMethodName = "getInitializationStatus";
    public static final String initializeMethodName = "initialize";

    public MobileAdsBridgeBase(Map p0) {
        new GenericBridge(p0);
        return;
    }

    public String getClassName() {
        return "com.google.android.gms.ads.MobileAds";
    }

    public Object getInitializationStatus() {
        MobileAdsBridgeBase.callNonVoidMethod("getInitializationStatus", 0, 0);
        return MobileAdsBridgeBase.callNonVoidMethod(..);
    }

    public String getVersionString() {
        MobileAdsBridgeBase.getVersionMethodName();
        MobileAdsBridgeBase.callNonVoidMethod(MobileAdsBridgeBase.getVersionMethodName(..), 0, 0);
        if (if-nez(MobileAdsBridgeBase.callNonVoidMethod(..))) goto L_11;
        return "0.0.0";
      L_11:
        "0.0.0".toString();
        return Object.toString(..);
    }

    public abstract boolean hasSCARBiddingSupport() {
        // native or abstract
    }

    public void initialize(Context p0, Object p1) {
        MobileAdsBridgeBase.callVoidMethod("initialize", 0, 2);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeFactory
// ============================================================
package com.unity3d.services.ads.gmascar.bridges.mobileads;

public class MobileAdsBridgeFactory {
    public MobileAdsBridgeFactory() {
        new Object();
        return;
    }

    public MobileAdsBridgeBase createMobileAdsBridge() {
        new MobileAdsBridge();
        new MobileAdsBridge(..).exists();
        if (if-eqz(MobileAdsBridgeBase.exists(..))) goto L_c;
        return new MobileAdsBridge(..);
      L_c:
        new MobileAdsBridgeLegacy();
        new MobileAdsBridgeLegacy(..).exists();
        if (if-eqz(MobileAdsBridgeLegacy.exists(..))) goto L_18;
        return new MobileAdsBridgeLegacy(..);
      L_18:
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeLegacy
// ============================================================
package com.unity3d.services.ads.gmascar.bridges.mobileads;

public class MobileAdsBridgeLegacy extends MobileAdsBridgeBase {
    public static final int CODE_20_0 = 210402000;
    public static final int CODE_21_0 = 221310000;
    public static final String versionStringMethodName = "getVersionString";

    public MobileAdsBridgeLegacy() {
        new MobileAdsBridgeLegacy$1();
        new MobileAdsBridgeBase(new MobileAdsBridgeLegacy$1(..));
        return;
    }

    public ScarAdapterVersion getAdapterVersion(int p0) {
        if (if-lt(p0, 210402000)) goto L_d;
        if (if-ge(p0, 221310000)) goto L_d;
        return ScarAdapterVersion.V20;
      L_d:
        return ScarAdapterVersion.NA;
    }

    public int getVersionCodeIndex() {
        return 1;
    }

    public String getVersionMethodName() {
        return "getVersionString";
    }

    public boolean hasSCARBiddingSupport() {
        return 0;
    }

    public boolean shouldInitialize() {
        return 1;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge$1
// ============================================================
package com.unity3d.services.ads.gmascar.bridges.mobileads;

class MobileAdsBridge$1 extends HashMap {
    MobileAdsBridge$1() {
        new HashMap();
        Class.forName("com.google.android.gms.ads.initialization.OnInitializationCompleteListener");
        new HashMap(..).put("initialize", 2);
        "initialize".getLocalizedMessage();
        DeviceLog.debug("Could not find class \"com.google.android.gms.ads.initialization.OnInitializationCompleteListener\" %s", 1);
      L_28:
        new HashMap(..).put("getInitializationStatus", "Could not find class \"com.google.android.gms.ads.initialization.OnInitializationCompleteListener\" %s");
        new HashMap(..).put("getVersion", 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeLegacy$1
// ============================================================
package com.unity3d.services.ads.gmascar.bridges.mobileads;

class MobileAdsBridgeLegacy$1 extends HashMap {
    MobileAdsBridgeLegacy$1() {
        new HashMap();
        Class.forName("com.google.android.gms.ads.initialization.OnInitializationCompleteListener");
        new HashMap(..).put("initialize", 2);
        "initialize".getLocalizedMessage();
        DeviceLog.debug("Could not find class \"com.google.android.gms.ads.initialization.OnInitializationCompleteListener\" %s", 1);
      L_28:
        new HashMap(..).put("getInitializationStatus", "Could not find class \"com.google.android.gms.ads.initialization.OnInitializationCompleteListener\" %s");
        new HashMap(..).put("getVersionString", 0);
        return;
    }

}

