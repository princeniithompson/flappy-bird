// Package bundle: com.unity3d.services.ads.gmascar.finder (4 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.finder.GMAInitializer
// ============================================================
package com.unity3d.services.ads.gmascar.finder;

public class GMAInitializer {
    private AdapterStatusBridge _adapterStatusBridge;
    private GMAEventSender _gmaEventSender;
    private InitializeListenerBridge _initializationListenerBridge;
    private InitializationStatusBridge _initializationStatusBridge;
    private MobileAdsBridgeBase _mobileAdsBridge;

    public GMAInitializer(MobileAdsBridgeBase p0, InitializeListenerBridge p1, InitializationStatusBridge p2, AdapterStatusBridge p3, GMAEventSender p4) {
        new Object();
        _mobileAdsBridge = p0;
        _initializationListenerBridge = p1;
        _initializationStatusBridge = p2;
        _adapterStatusBridge = p3;
        _gmaEventSender = p4;
        return;
    }

    public InitializeListenerBridge getInitializeListenerBridge() {
        return _initializationListenerBridge;
    }

    public boolean initSuccessful(Object p0) {
        _initializationStatusBridge.getAdapterStatusMap(p0);
        _mobileAdsBridge.getClassName();
        Map.get(MobileAdsBridgeBase.getClassName(..));
        if (if-eqz(Map.get(..))) goto L_2f;
        _adapterStatusBridge.isGMAInitialized(Map.get(..));
        if (if-eqz(AdapterStatusBridge.isGMAInitialized(..))) goto L_26;
        _gmaEventSender.send(GMAEvent.INIT_SUCCESS, 0);
        return 1;
      L_26:
        _gmaEventSender.send(GMAEvent.INIT_ERROR, v2);
      L_2f:
        return 0;
    }

    public void initializeGMA() {
        GMAInitializer.shouldInitialize();
        if (if-eqz(GMAInitializer.shouldInitialize(..))) goto L_15;
        ClientProperties.getApplicationContext();
        _initializationListenerBridge.createInitializeListenerProxy();
        _mobileAdsBridge.initialize(ClientProperties.getApplicationContext(..), InitializeListenerBridge.createInitializeListenerProxy(..));
      L_15:
        return;
    }

    public boolean isInitialized() {
        _mobileAdsBridge.getInitializationStatus();
        GMAInitializer.initSuccessful(MobileAdsBridgeBase.getInitializationStatus(..));
        GMAInitializer.initSuccessful(..).getLocalizedMessage();
        DeviceLog.debug("ERROR: Could not get initialization status of GMA SDK - %s", 1);
      L_1c:
        return 0;
    }

    public boolean shouldInitialize() {
        GMAInitializer.isInitialized();
        if (if-eqz(GMAInitializer.isInitialized(..))) goto L_11;
        _gmaEventSender.send(GMAEvent.ALREADY_INITIALIZED, v3);
        return 0;
      L_11:
        _mobileAdsBridge.shouldInitialize();
        return MobileAdsBridgeBase.shouldInitialize(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.finder.PresenceDetector
// ============================================================
package com.unity3d.services.ads.gmascar.finder;

public class PresenceDetector {
    private AdapterStatusBridge _adapterStatusBridge;
    private InitializeListenerBridge _initializationListenerBridge;
    private InitializationStatusBridge _initializationStatusBridge;
    private MobileAdsBridgeBase _mobileAdsBridge;

    public PresenceDetector(MobileAdsBridgeBase p0, InitializeListenerBridge p1, InitializationStatusBridge p2, AdapterStatusBridge p3) {
        new Object();
        _mobileAdsBridge = p0;
        _initializationListenerBridge = p1;
        _initializationStatusBridge = p2;
        _adapterStatusBridge = p3;
        return;
    }

    public boolean areGMAClassesPresent() {
        if (if-eqz(_mobileAdsBridge)) goto L_31;
        if (if-eqz(_initializationListenerBridge)) goto L_31;
        if (if-eqz(_initializationStatusBridge)) goto L_31;
        if (if-nez(_adapterStatusBridge)) goto L_12;
      L_12:
        _mobileAdsBridge.exists();
        if (if-eqz(MobileAdsBridgeBase.exists(..))) goto L_31;
        _initializationListenerBridge.exists();
        if (if-eqz(InitializeListenerBridge.exists(..))) goto L_31;
        _initializationStatusBridge.exists();
        if (if-eqz(InitializationStatusBridge.exists(..))) goto L_31;
        _adapterStatusBridge.exists();
        if (if-eqz(AdapterStatusBridge.exists(..))) goto L_31;
      L_31:
        return 1;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion
// ============================================================
package com.unity3d.services.ads.gmascar.finder;

public final class ScarAdapterVersion extends Enum {
    private static final ScarAdapterVersion[] $VALUES;
    public static final ScarAdapterVersion NA;
    public static final ScarAdapterVersion V20;
    public static final ScarAdapterVersion V21;
    public static final ScarAdapterVersion V23;

    private static ScarAdapterVersion[] $values() {
        return 4;
    }

    static <clinit>() {
        new ScarAdapterVersion("V20", 0);
        V20 = new ScarAdapterVersion(..);
        new ScarAdapterVersion("V21", 1);
        V21 = new ScarAdapterVersion(..);
        new ScarAdapterVersion("V23", 2);
        V23 = new ScarAdapterVersion(..);
        new ScarAdapterVersion("NA", 3);
        NA = new ScarAdapterVersion(..);
        ScarAdapterVersion.$values();
        $VALUES = ScarAdapterVersion.$values(..);
        return;
    }

    private ScarAdapterVersion(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static ScarAdapterVersion valueOf(String p0) {
        Enum.valueOf(ScarAdapterVersion.class, p0);
        return Enum.valueOf(..);
    }

    public static ScarAdapterVersion[] values() {
        ScarAdapterVersion.$VALUES.clone();
        return ScarAdapterVersion[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.finder.ScarVersionFinder
// ============================================================
package com.unity3d.services.ads.gmascar.finder;

public class ScarVersionFinder {
    private static IMobileAdsBridge _mobileAdsBridge;
    private GMAEventSender _gmaEventSender;
    private GMAInitializer _gmaInitializer;
    private int _gmaSdkVersionCode;
    private PresenceDetector _presenceDetector;

    public ScarVersionFinder(IMobileAdsBridge p0, PresenceDetector p1, GMAInitializer p2, GMAEventSender p3) {
        new Object();
        _gmaSdkVersionCode = -1;
        _mobileAdsBridge = p0;
        _presenceDetector = p1;
        _gmaInitializer = p2;
        _gmaEventSender = p3;
        p2.getInitializeListenerBridge();
        InitializeListenerBridge.setStatusListener(new Object(..));
        return;
    }

    public void findAndSendVersion(boolean p0) {
        if (if-eqz(p0)) goto L_9;
        ScarVersionFinder._mobileAdsBridge.getVersionString();
      L_9:
      L_b:
        _gmaEventSender.sendVersion("0.0.0");
        return;
    }

    public void getVersion() {
        _presenceDetector.areGMAClassesPresent();
        if (if-nez(PresenceDetector.areGMAClassesPresent(..))) goto L_11;
        _gmaEventSender.sendVersion("0.0.0");
        return;
      L_11:
        _gmaInitializer.shouldInitialize();
        if (if-eqz(GMAInitializer.shouldInitialize(..))) goto L_1f;
        _gmaInitializer.initializeGMA();
      L_1f:
        ScarVersionFinder.findAndSendVersion(1);
        _gmaInitializer.getLocalizedMessage();
        DeviceLog.debug("Got exception finding GMA SDK: %s", 1);
      L_32:
        return;
    }

    public int getVersionCode() {
        if (if-ne(_gmaSdkVersionCode, -1)) goto L_46;
        ScarVersionFinder._mobileAdsBridge.getVersionString();
        if (if-eqz(IMobileAdsBridge.getVersionString(..))) goto L_46;
        String.split("\\.");
        ScarVersionFinder._mobileAdsBridge.getVersionCodeIndex();
        if (if-le("\\.", IMobileAdsBridge.getVersionCodeIndex(..))) goto L_46;
        ScarVersionFinder._mobileAdsBridge.getVersionCodeIndex();
        Integer.parseInt(IMobileAdsBridge.getVersionCodeIndex(..));
        _gmaSdkVersionCode = Integer.parseInt(..);
        ScarVersionFinder._mobileAdsBridge.getVersionCodeIndex();
        Integer.parseInt(..).getLocalizedMessage();
        DeviceLog.debug("Could not parse %s to an Integer: %s", 2);
      L_46:
        return _gmaSdkVersionCode;
    }

    public void onInitializationComplete(Object p0) {
        _gmaInitializer.initSuccessful(p0);
        ScarVersionFinder.findAndSendVersion(GMAInitializer.initSuccessful(..));
        return;
    }

}

