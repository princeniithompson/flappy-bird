
// ===== FILE: com/unity3d/services/ads/gmascar/bridges/AdapterStatusBridge.java =====
package com.unity3d.services.ads.gmascar.bridges;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.reflection.GenericBridge;
import java.util.HashMap;

/* loaded from: classes.dex */
public class AdapterStatusBridge extends GenericBridge {
    private static final String initializeStateMethodName = "getInitializationState";
    private Class _adapterStateClass;

    @Override // com.unity3d.services.core.reflection.GenericBridge
    protected String getClassName() {
        return "com.google.android.gms.ads.initialization.AdapterStatus";
    }

    public AdapterStatusBridge() {
        super(new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.ads.gmascar.bridges.AdapterStatusBridge.1
            {
                put(AdapterStatusBridge.initializeStateMethodName, new Class[0]);
            }
        });
        AdapterStatusStateBridge adapterStatusStateBridge = new AdapterStatusStateBridge();
        try {
            this._adapterStateClass = Class.forName(adapterStatusStateBridge.getClassName());
        } catch (ClassNotFoundException e) {
            DeviceLog.debug("ERROR: Could not find class %s %s", adapterStatusStateBridge.getClassName(), e.getLocalizedMessage());
        }
    }

    public boolean isGMAInitialized(Object obj) {
        Object[] adapterStatesEnum = getAdapterStatesEnum();
        if (adapterStatesEnum != null) {
            return callNonVoidMethod(initializeStateMethodName, obj, new Object[0]) == adapterStatesEnum[1];
        }
        DeviceLog.debug("ERROR: Could not get adapter states enum from AdapterStatus.State");
        return false;
    }

    public Object[] getAdapterStatesEnum() {
        return this._adapterStateClass.getEnumConstants();
    }
}

// ===== FILE: com/unity3d/services/ads/gmascar/bridges/AdapterStatusStateBridge.java =====
package com.unity3d.services.ads.gmascar.bridges;

/* loaded from: classes.dex */
public class AdapterStatusStateBridge {
    public String getClassName() {
        return "com.google.android.gms.ads.initialization.AdapterStatus$State";
    }
}

// ===== FILE: com/unity3d/services/ads/gmascar/bridges/InitializationStatusBridge.java =====
package com.unity3d.services.ads.gmascar.bridges;

import com.unity3d.services.core.reflection.GenericBridge;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class InitializationStatusBridge extends GenericBridge {
    private static final String adapterStatusMapMethodName = "getAdapterStatusMap";

    @Override // com.unity3d.services.core.reflection.GenericBridge
    public String getClassName() {
        return "com.google.android.gms.ads.initialization.InitializationStatus";
    }

    public InitializationStatusBridge() {
        super(new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.ads.gmascar.bridges.InitializationStatusBridge.1
            {
                put(InitializationStatusBridge.adapterStatusMapMethodName, new Class[0]);
            }
        });
    }

    public Map<String, Object> getAdapterStatusMap(Object obj) {
        return (Map) callNonVoidMethod(adapterStatusMapMethodName, obj, new Object[0]);
    }
}

// ===== FILE: com/unity3d/services/ads/gmascar/bridges/InitializeListenerBridge.java =====
package com.unity3d.services.ads.gmascar.bridges;

import com.unity3d.services.ads.gmascar.listeners.IInitializationStatusListener;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.reflection.GenericBridge;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/* loaded from: classes.dex */
public class InitializeListenerBridge extends GenericBridge {
    private static final String initializationCompleteMethodName = "onInitializationComplete";
    private IInitializationStatusListener _initializationStatusListener;

    @Override // com.unity3d.services.core.reflection.GenericBridge
    public String getClassName() {
        return "com.google.android.gms.ads.initialization.OnInitializationCompleteListener";
    }

    public InitializeListenerBridge() {
        super(new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.ads.gmascar.bridges.InitializeListenerBridge.1
            {
                try {
                    put(InitializeListenerBridge.initializationCompleteMethodName, new Class[]{Class.forName("com.google.android.gms.ads.initialization.InitializationStatus")});
                } catch (ClassNotFoundException e) {
                    DeviceLog.debug("Could not find class \"com.google.android.gms.ads.initialization.InitializationStatus\" %s", e.getLocalizedMessage());
                }
            }
        });
    }

    public void setStatusListener(IInitializationStatusListener iInitializationStatusListener) {
        this._initializationStatusListener = iInitializationStatusListener;
    }

    public Object createInitializeListenerProxy() {
        try {
            return Proxy.newProxyInstance(classForName().getClassLoader(), new Class[]{classForName()}, new InvocationHandler() { // from class: com.unity3d.services.ads.gmascar.bridges.InitializeListenerBridge.2
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if (!method.getName().equals(InitializeListenerBridge.initializationCompleteMethodName) || InitializeListenerBridge.this._initializationStatusListener == null) {
                        return null;
                    }
                    InitializeListenerBridge.this._initializationStatusListener.onInitializationComplete(objArr[0]);
                    return null;
                }
            });
        } catch (Exception unused) {
            DeviceLog.debug("ERROR: Could not create InitializeCompletionListener");
            return null;
        }
    }
}
