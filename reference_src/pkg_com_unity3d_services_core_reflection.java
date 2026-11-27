// Package bundle: com.unity3d.services.core.reflection (2 classes)

// ============================================================
// CLASS: com.unity3d.services.core.reflection.GenericBridge
// ============================================================
package com.unity3d.services.core.reflection;

public abstract class GenericBridge {
    private final String _className;
    private final Map _functionAndParameters;
    private final Map _methodMap;
    private boolean _methodMapBuilt;

    public GenericBridge(Map p0) {
        new Object();
        _methodMapBuilt = 0;
        new Object(..).getClassName();
        _className = GenericBridge.getClassName(..);
        _functionAndParameters = p0;
        new HashMap();
        _methodMap = new HashMap(..);
        new Object(..).buildMethodMap();
        return;
    }

    private void buildMethodMap() {
        GenericBridge.getFunctionMap();
        GenericBridge.getFunctionMap(..).entrySet();
        Map.entrySet(..).iterator();
      L_e:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_54;
        Set.iterator(..).next();
        Iterator.next(..).getValue();
        GenericBridge.classForName();
        Iterator.next(..).getKey();
        GenericBridge.getReflectiveMethod(GenericBridge.classForName(..), Map$Entry.getKey(..), Map$Entry.getValue(..));
        if (if-eqz(GenericBridge.getReflectiveMethod(..))) goto L_e;
        Iterator.next(..).getKey();
        _methodMap.put(Map$Entry.getKey(..), GenericBridge.getReflectiveMethod(..));
        Iterator.next(..).getKey();
        DeviceLog.debug("ERROR: Could not find %s class with method %s and parameters : %s", 3);
      L_54:
        _methodMapBuilt = 0;
        return;
    }

    private Method getMethod(String p0) {
        _methodMap.get(p0);
        return Map.get(..);
    }

    private Method getReflectiveMethod(Class p0, String p1, Class[] p2) {
        p0.getDeclaredMethod(p1, p2);
        new StringBuilder();
        Class.getDeclaredMethod(..).getName();
        new StringBuilder(..).append(Class.getName(..));
        new StringBuilder(..).append(" ");
        p2.getLocalizedMessage();
        new StringBuilder(..).append(Exception.getLocalizedMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.debug("ERROR: Could not find method %s in %s", 2);
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.GMA, GMAEvent.METHOD_ERROR, 2);
      L_3e:
        return 0;
    }

    public Object callNonVoidMethod(String p0, Object p1, Object[] p2) {
        GenericBridge.getMethod(p0);
        if (if-nez(GenericBridge.getMethod(..))) goto L_13;
        DeviceLog.debug("ERROR: Could not find method %s", p1);
        return 0;
      L_13:
        GenericBridge.getMethod(..).invoke(p1, p2);
        return Method.invoke(..);
        p1.getLocalizedMessage();
        DeviceLog.debug("ERROR: Could not invoke method %s : %s", 2);
        return 0;
    }

    public void callVoidMethod(String p0, Object p1, Object[] p2) {
        GenericBridge.getMethod(p0);
        if (if-nez(GenericBridge.getMethod(..))) goto L_12;
        DeviceLog.debug("ERROR: Could not find method %s", p1);
        return;
      L_12:
        GenericBridge.getMethod(..).invoke(p1, p2);
        p1.getLocalizedMessage();
        DeviceLog.debug("ERROR: Could not invoke method %s : %s", 2);
      L_27:
        return;
    }

    public Class classForName() {
        Class.forName(_className);
        return Class.forName(..);
        Class.forName(..).getLocalizedMessage();
        DeviceLog.debug("ERROR: Could not find Class %s %s", 2);
        return 0;
    }

    public boolean exists() {
        GenericBridge.classForName();
        if (if-nez(GenericBridge.classForName(..))) goto L_14;
        DeviceLog.debug("ERROR: Could not find class %s", GenericBridge.classForName(..));
        return 0;
      L_14:
        if (if-nez(_methodMapBuilt)) goto L_1b;
        GenericBridge.buildMethodMap();
      L_1b:
        _methodMap.size();
        GenericBridge.getFunctionMap();
        GenericBridge.getFunctionMap(..).size();
        if (if-ne(Map.size(..), Map.size(..))) goto L_2c;
      L_2c:
      L_2d:
        return 0;
    }

    protected abstract String getClassName() {
        // native or abstract
    }

    public Map getFunctionMap() {
        return _functionAndParameters;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.reflection.GenericListenerProxy
// ============================================================
package com.unity3d.services.core.reflection;

public abstract class GenericListenerProxy {
    public GenericListenerProxy() {
        new Object();
        return;
    }

    public abstract Class getProxyClass() {
        // native or abstract
    }

    public Object getProxyInstance() {
        GenericListenerProxy.getProxyClass();
        Class.getClassLoader();
        GenericListenerProxy.getProxyClass();
        Proxy.newProxyInstance(Class.getClassLoader(..), 1, this);
        return Proxy.newProxyInstance(..);
    }

    public Object invoke(Object p0, Method p1, Object[] p2) {
        p1.invoke(this, p2);
        return Method.invoke(..);
    }

}

