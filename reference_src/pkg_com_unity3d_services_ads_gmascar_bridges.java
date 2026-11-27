// Package bundle: com.unity3d.services.ads.gmascar.bridges (8 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.AdapterStatusBridge
// ============================================================
package com.unity3d.services.ads.gmascar.bridges;

public class AdapterStatusBridge extends GenericBridge {
    private static final String initializeStateMethodName = "getInitializationState";
    private Class _adapterStateClass;

    public AdapterStatusBridge() {
        new AdapterStatusBridge$1();
        new GenericBridge(new AdapterStatusBridge$1(..));
        new AdapterStatusStateBridge();
        new AdapterStatusStateBridge(..).getClassName();
        Class.forName(AdapterStatusStateBridge.getClassName(..));
        _adapterStateClass = Class.forName(..);
        new AdapterStatusStateBridge(..).getClassName();
        Class.forName(..).getLocalizedMessage();
        DeviceLog.debug("ERROR: Could not find class %s %s", 2);
      L_2f:
        return;
    }

    public Object[] getAdapterStatesEnum() {
        _adapterStateClass.getEnumConstants();
        return Class.getEnumConstants(..);
    }

    protected String getClassName() {
        return "com.google.android.gms.ads.initialization.AdapterStatus";
    }

    public boolean isGMAInitialized(Object p0) {
        AdapterStatusBridge.getAdapterStatesEnum();
        if (if-nez(AdapterStatusBridge.getAdapterStatesEnum(..))) goto L_d;
        DeviceLog.debug("ERROR: Could not get adapter states enum from AdapterStatus.State");
        return 0;
      L_d:
        AdapterStatusBridge.callNonVoidMethod("getInitializationState", "ERROR: Could not get adapter states enum from AdapterStatus.State", v3);
        if (if-ne(AdapterStatusBridge.callNonVoidMethod(..), AdapterStatusBridge.getAdapterStatesEnum(..))) goto L_1b;
      L_1b:
        return 1;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.AdapterStatusStateBridge
// ============================================================
package com.unity3d.services.ads.gmascar.bridges;

public class AdapterStatusStateBridge {
    public AdapterStatusStateBridge() {
        new Object();
        return;
    }

    public String getClassName() {
        return "com.google.android.gms.ads.initialization.AdapterStatus$State";
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.InitializationStatusBridge
// ============================================================
package com.unity3d.services.ads.gmascar.bridges;

public class InitializationStatusBridge extends GenericBridge {
    private static final String adapterStatusMapMethodName = "getAdapterStatusMap";

    public InitializationStatusBridge() {
        new InitializationStatusBridge$1();
        new GenericBridge(new InitializationStatusBridge$1(..));
        return;
    }

    public Map getAdapterStatusMap(Object p0) {
        InitializationStatusBridge.callNonVoidMethod("getAdapterStatusMap", p0, 0);
        return InitializationStatusBridge.callNonVoidMethod(..);
    }

    public String getClassName() {
        return "com.google.android.gms.ads.initialization.InitializationStatus";
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.InitializeListenerBridge
// ============================================================
package com.unity3d.services.ads.gmascar.bridges;

public class InitializeListenerBridge extends GenericBridge {
    private static final String initializationCompleteMethodName = "onInitializationComplete";
    private IInitializationStatusListener _initializationStatusListener;

    public InitializeListenerBridge() {
        new InitializeListenerBridge$1();
        new GenericBridge(new InitializeListenerBridge$1(..));
        return;
    }

    static IInitializationStatusListener access$000(InitializeListenerBridge p0) {
        return _initializationStatusListener;
    }

    public Object createInitializeListenerProxy() {
        InitializeListenerBridge.classForName();
        Class.getClassLoader();
        InitializeListenerBridge.classForName();
        new InitializeListenerBridge$2(this);
        Proxy.newProxyInstance(Class.getClassLoader(..), 1, new InitializeListenerBridge$2(..));
        return Proxy.newProxyInstance(..);
        DeviceLog.debug("ERROR: Could not create InitializeCompletionListener");
        return 0;
    }

    public String getClassName() {
        return "com.google.android.gms.ads.initialization.OnInitializationCompleteListener";
    }

    public void setStatusListener(IInitializationStatusListener p0) {
        _initializationStatusListener = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.AdapterStatusBridge$1
// ============================================================
package com.unity3d.services.ads.gmascar.bridges;

class AdapterStatusBridge$1 extends HashMap {
    AdapterStatusBridge$1() {
        new HashMap();
        new HashMap(..).put("getInitializationState", 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.InitializationStatusBridge$1
// ============================================================
package com.unity3d.services.ads.gmascar.bridges;

class InitializationStatusBridge$1 extends HashMap {
    InitializationStatusBridge$1() {
        new HashMap();
        new HashMap(..).put("getAdapterStatusMap", 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.InitializeListenerBridge$1
// ============================================================
package com.unity3d.services.ads.gmascar.bridges;

class InitializeListenerBridge$1 extends HashMap {
    InitializeListenerBridge$1() {
        new HashMap();
        Class.forName("com.google.android.gms.ads.initialization.InitializationStatus");
        new HashMap(..).put("onInitializationComplete", v3);
        "onInitializationComplete".getLocalizedMessage();
        DeviceLog.debug("Could not find class \"com.google.android.gms.ads.initialization.InitializationStatus\" %s", 1);
      L_23:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.gmascar.bridges.InitializeListenerBridge$2
// ============================================================
package com.unity3d.services.ads.gmascar.bridges;

class InitializeListenerBridge$2 {
    final InitializeListenerBridge this$0;

    InitializeListenerBridge$2(InitializeListenerBridge p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public Object invoke(Object p0, Method p1, Object[] p2) {
        p1.getName();
        Method.getName(..).equals("onInitializationComplete");
        if (if-eqz(String.equals(..))) goto L_20;
        InitializeListenerBridge.access$000(this$0);
        if (if-eqz(InitializeListenerBridge.access$000(..))) goto L_20;
        InitializeListenerBridge.access$000(this$0);
        IInitializationStatusListener.onInitializationComplete(0);
      L_20:
        return 0;
    }

}

