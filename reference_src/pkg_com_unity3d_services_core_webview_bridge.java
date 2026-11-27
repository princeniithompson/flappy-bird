// Package bundle: com.unity3d.services.core.webview.bridge (22 classes)

// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.CallbackStatus
// ============================================================
package com.unity3d.services.core.webview.bridge;

public final class CallbackStatus extends Enum {
    private static final CallbackStatus[] $VALUES;
    public static final CallbackStatus ERROR;
    public static final CallbackStatus OK;

    private static CallbackStatus[] $values() {
        return 2;
    }

    static <clinit>() {
        new CallbackStatus("OK", 0);
        OK = new CallbackStatus(..);
        new CallbackStatus("ERROR", 1);
        ERROR = new CallbackStatus(..);
        CallbackStatus.$values();
        $VALUES = CallbackStatus.$values(..);
        return;
    }

    private CallbackStatus(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static CallbackStatus valueOf(String p0) {
        Enum.valueOf(CallbackStatus.class, p0);
        return Enum.valueOf(..);
    }

    public static CallbackStatus[] values() {
        CallbackStatus.$VALUES.clone();
        return CallbackStatus[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.IEventSender
// ============================================================
package com.unity3d.services.core.webview.bridge;

public abstract class IEventSender {
    public abstract boolean canSend() {
        // native or abstract
    }

    public abstract boolean sendEvent(Enum p0, Enum p1, Object[] p2) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.IInvocationCallbackInvoker
// ============================================================
package com.unity3d.services.core.webview.bridge;

public abstract class IInvocationCallbackInvoker {
    public abstract void invokeCallback(Invocation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.INativeCallbackSubject
// ============================================================
package com.unity3d.services.core.webview.bridge;

public abstract class INativeCallbackSubject {
    public abstract NativeCallback getCallback(String p0) {
        // native or abstract
    }

    public abstract void remove(NativeCallback p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.IWebViewBridge
// ============================================================
package com.unity3d.services.core.webview.bridge;

public abstract class IWebViewBridge {
    public abstract void handleCallback(String p0, String p1, Object[] p2) {
        // native or abstract
    }

    public abstract void handleInvocation(String p0, String p1, Object[] p2, WebViewCallback p3) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker
// ============================================================
package com.unity3d.services.core.webview.bridge;

public abstract class IWebViewBridgeInvoker {
    public abstract boolean invokeMethod(String p0, String p1, Method p2, Object[] p3) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore
// ============================================================
package com.unity3d.services.core.webview.bridge;

public abstract class IWebViewBridgeSharedObjectStore {
    public abstract IWebViewSharedObject get(String p0) {
        // native or abstract
    }

    public abstract void remove(String p0) {
        // native or abstract
    }

    public abstract void set(IWebViewSharedObject p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.IWebViewSharedObject
// ============================================================
package com.unity3d.services.core.webview.bridge;

public abstract class IWebViewSharedObject {
    public abstract String getId() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.Invocation
// ============================================================
package com.unity3d.services.core.webview.bridge;

public class Invocation {
    private static AtomicInteger _idCount;
    private static Map _invocationSets;
    private IInvocationCallbackInvoker _invocationCallbackInvoker;
    private int _invocationId;
    private ArrayList _invocations;
    private ArrayList _responses;
    private final IWebViewBridge _webViewBridge;

    static <clinit>() {
        new AtomicInteger(0);
        _idCount = new AtomicInteger(..);
        return;
    }

    public Invocation() {
        SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker();
        SharedInstances.INSTANCE.getWebViewBridge();
        new Invocation(SharedInstances.getWebViewAppInvocationCallbackInvoker(..), SharedInstances.getWebViewBridge(..));
        return;
    }

    public Invocation(IInvocationCallbackInvoker p0, IWebViewBridge p1) {
        new Object();
        _invocationCallbackInvoker = p0;
        _webViewBridge = p1;
        Invocation._idCount.getAndIncrement();
        _invocationId = AtomicInteger.getAndIncrement(..);
        if (if-nez(Invocation._invocationSets)) goto L_1a;
        new HashMap();
        _invocationSets = new HashMap(..);
      L_1a:
        Integer.valueOf(_invocationId);
        Invocation._invocationSets.put(Integer.valueOf(..), new Object(..));
        return;
    }

    public Invocation(IWebViewBridge p0) {
        SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker();
        new Invocation(SharedInstances.getWebViewAppInvocationCallbackInvoker(..), p0);
        return;
    }

    public static Invocation getInvocationById(int p0) {
        if (if-eqz(Invocation._invocationSets)) goto L_1f;
        Integer.valueOf(p0);
        Invocation._invocationSets.containsKey(Integer.valueOf(..));
        if (if-eqz(Map.containsKey(..))) goto L_1f;
        Integer.valueOf(p0);
        Invocation._invocationSets.get(Integer.valueOf(..));
        return Map.get(..);
      L_1f:
        return 0;
        throw 0;
    }

    public void addInvocation(String p0, String p1, Object[] p2, WebViewCallback p3) {
        if (if-nez(_invocations)) goto L_b;
        new ArrayList();
        _invocations = new ArrayList(..);
      L_b:
        new ArrayList();
        new ArrayList(..).add(p0);
        new ArrayList(..).add(p1);
        new ArrayList(..).add(p2);
        new ArrayList(..).add(p3);
        _invocations.add(new ArrayList(..));
        return;
    }

    public int getId() {
        return _invocationId;
    }

    public ArrayList getResponses() {
        return _responses;
    }

    public boolean nextInvocation() {
        if (if-eqz(_invocations)) goto L_4b;
        _invocations.size();
        if (if-lez(ArrayList.size(..))) goto L_4b;
        _invocations.remove(0);
        ArrayList.remove(..).get(0);
        ArrayList.remove(..).get(1);
        ArrayList.remove(..).get(2);
        ArrayList.remove(..).get(3);
        _webViewBridge.handleInvocation(ArrayList.get(..), ArrayList.get(..), ArrayList.get(..), ArrayList.get(..));
        Arrays.toString(ArrayList.get(..));
        String.format("Error handling invocation %s.%s(%s)", 3);
        DeviceLog.exception(String.format(..), ArrayList.get(..));
      L_4a:
        return 1;
      L_4b:
        return String.format(..);
    }

    public void sendInvocationCallback() {
        Invocation.getId();
        Integer.valueOf(Invocation.getId(..));
        Invocation._invocationSets.remove(Integer.valueOf(..));
        _invocationCallbackInvoker.invokeCallback(this);
        return;
    }

    public void setInvocationResponse(CallbackStatus p0, Enum p1, Object[] p2) {
        if (if-nez(_responses)) goto L_b;
        new ArrayList();
        _responses = new ArrayList(..);
      L_b:
        new ArrayList();
        new ArrayList(..).add(p0);
        new ArrayList(..).add(p1);
        new ArrayList(..).add(p2);
        _responses.add(new ArrayList(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.NativeCallback
// ============================================================
package com.unity3d.services.core.webview.bridge;

public class NativeCallback {
    private static AtomicInteger _callbackCount;
    private Method _callback;
    private String _id;
    private final INativeCallbackSubject _nativeCallbackSubject;

    static <clinit>() {
        new AtomicInteger(0);
        _callbackCount = new AtomicInteger(..);
        return;
    }

    public NativeCallback(Method p0) {
        SharedInstances.INSTANCE.getWebViewAppNativeCallbackSubject();
        new NativeCallback(p0, SharedInstances.getWebViewAppNativeCallbackSubject(..));
        return;
    }

    public NativeCallback(Method p0, INativeCallbackSubject p1) {
        new Object();
        _callback = p0;
        new StringBuilder();
        _callback.getName();
        Method.getName(..).toUpperCase(Locale.US);
        new StringBuilder(..).append(String.toUpperCase(..));
        new StringBuilder(..).append("_");
        NativeCallback._callbackCount.getAndIncrement();
        new StringBuilder(..).append(AtomicInteger.getAndIncrement(..));
        new StringBuilder(..).toString();
        _id = StringBuilder.toString(..);
        _nativeCallbackSubject = p1;
        return;
    }

    public String getId() {
        return _id;
    }

    public void invoke(String p0, Object[] p1) {
        CallbackStatus.valueOf(p0);
        if (if-nez(p1)) goto L_d;
      L_d:
        Arrays.asList(1);
        new ArrayList(Arrays.asList(..));
        new ArrayList(..).add(0, CallbackStatus.valueOf(..));
        new ArrayList(..).toArray();
      L_1d:
        _callback.invoke(0, ArrayList.toArray(..));
        _nativeCallbackSubject.remove(this);
        return;
        DeviceLog.error("Illegal status");
        _nativeCallbackSubject.remove(this);
        throw _nativeCallbackSubject;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.SharedInstances
// ============================================================
package com.unity3d.services.core.webview.bridge;

public final class SharedInstances {
    public static final SharedInstances INSTANCE;
    private static final IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker;
    private static final INativeCallbackSubject webViewAppNativeCallbackSubject;
    private static final IWebViewBridge webViewBridge;
    private static final IEventSender webViewEventSender;

    public static void $r8$lambda$xUJZA025WfMDcZh-3wQeftClsiE(Invocation p0) {
        SharedInstances.webViewAppInvocationCallbackInvoker$lambda$0(p0);
        return;
    }

    static <clinit>() {
        new SharedInstances();
        INSTANCE = new SharedInstances(..);
        new SharedInstances$$ExternalSyntheticLambda0();
        webViewAppInvocationCallbackInvoker = new SharedInstances$$ExternalSyntheticLambda0(..);
        new SharedInstances$webViewAppNativeCallbackSubject$1();
        webViewAppNativeCallbackSubject = new SharedInstances$webViewAppNativeCallbackSubject$1(..);
        new SharedInstances$webViewEventSender$1();
        webViewEventSender = new SharedInstances$webViewEventSender$1(..);
        new SharedInstances$webViewBridge$1();
        webViewBridge = new SharedInstances$webViewBridge$1(..);
        return;
    }

    private SharedInstances() {
        new Object();
        return;
    }

    private static final void webViewAppInvocationCallbackInvoker$lambda$0(Invocation p0) {
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).invokeCallback(p0);
        return;
    }

    public final IInvocationCallbackInvoker getWebViewAppInvocationCallbackInvoker() {
        return SharedInstances.webViewAppInvocationCallbackInvoker;
    }

    public final INativeCallbackSubject getWebViewAppNativeCallbackSubject() {
        return SharedInstances.webViewAppNativeCallbackSubject;
    }

    public final IWebViewBridge getWebViewBridge() {
        return SharedInstances.webViewBridge;
    }

    public final IEventSender getWebViewEventSender() {
        return SharedInstances.webViewEventSender;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.WebViewBridge
// ============================================================
package com.unity3d.services.core.webview.bridge;

public class WebViewBridge {
    private static IWebViewBridge _instance;
    private HashMap _classTable;
    private final INativeCallbackSubject nativeCallbackSubject;

    private WebViewBridge(Class[] p0, INativeCallbackSubject p1) {
        new Object();
        nativeCallbackSubject = p1;
        if (if-nez(p0)) goto L_8;
        return;
      L_8:
        new HashMap();
        _classTable = new HashMap(..);
      L_12:
        if (if-ge(0, new HashMap(..))) goto L_87;
        if (if-eqz(v2)) goto L_84;
        Class.getPackage();
        Class.getPackage(..).getName();
        Package.getName(..).startsWith("com.unity3d.services");
        if (if-nez(String.startsWith(..))) goto L_39;
        Class.getPackage();
        Class.getPackage(..).getName();
        Package.getName(..).startsWith("com.unity3d.ads.test");
        if (if-nez(String.startsWith(..))) goto L_39;
      L_39:
        new HashMap();
        Class.getMethods();
      L_44:
        if (if-ge(0, v5)) goto L_7b;
        Method.getAnnotation(WebViewExposed.class);
        if (if-eqz(Method.getAnnotation(..))) goto L_78;
        Method.getName();
        new HashMap(..).containsKey(Method.getName(..));
        if (if-eqz(HashMap.containsKey(..))) goto L_61;
        new HashMap(..).get(Method.getName(..));
      L_61:
        new HashMap();
      L_66:
        Method.getParameterTypes();
        Arrays.deepHashCode(Method.getParameterTypes(..));
        Integer.valueOf(Arrays.deepHashCode(..));
        new HashMap(..).put(Integer.valueOf(..), v7);
        new HashMap(..).put(Method.getName(..), new HashMap(..));
      L_78:
      L_7b:
        Class.getName();
        _classTable.put(Class.getName(..), new HashMap(..));
      L_84:
      L_87:
        return;
    }

    private Method findMethod(String p0, String p1, Object[] p2) {
        _classTable.containsKey(p0);
        if (if-eqz(HashMap.containsKey(..))) goto L_35;
        _classTable.get(p0);
        HashMap.get(..).containsKey(p1);
        if (if-eqz(HashMap.containsKey(..))) goto L_2f;
        HashMap.get(..).get(p1);
        WebViewBridge.getTypes(p2);
        Arrays.deepHashCode(WebViewBridge.getTypes(..));
        Integer.valueOf(Arrays.deepHashCode(..));
        HashMap.get(..).get(Integer.valueOf(..));
        return HashMap.get(..);
      L_2f:
        new NoSuchMethodException();
        throw new NoSuchMethodException(..);
      L_35:
        new NoSuchMethodException();
        throw new NoSuchMethodException(..);
    }

    public static IWebViewBridge getInstance() {
        return WebViewBridge._instance;
    }

    private Class[] getTypes(Object[] p0) {
        if (if-nez(p0)) goto L_6;
      L_6:
      L_a:
        if (if-eqz(p0)) goto L_1b;
      L_d:
        if (if-ge(0, v3)) goto L_1b;
        Object.getClass();
      L_1b:
        return v1;
    }

    private Object[] getValues(Object[] p0, WebViewCallback p1) {
        if (if-nez(p0)) goto L_b;
        if (if-nez(p1)) goto L_8;
        return 0;
      L_8:
      L_b:
        if (if-eqz(p1)) goto L_10;
      L_10:
      L_11:
      L_14:
        if (if-eqz(0)) goto L_1a;
        System.arraycopy(0, 0, v2, 0, 0);
      L_1a:
        if (if-eqz(p1)) goto L_20;
      L_20:
        return v2;
    }

    public static void setClassTable(Class[] p0) {
        SharedInstances.INSTANCE.getWebViewAppNativeCallbackSubject();
        new WebViewBridge(p0, SharedInstances.getWebViewAppNativeCallbackSubject(..));
        _instance = new WebViewBridge(..);
        return;
    }

    public void handleCallback(String p0, String p1, Object[] p2) {
        nativeCallbackSubject.getCallback(p0);
        WebViewBridge.getValues(p2, 0);
        NativeCallback.invoke(p1, WebViewBridge.getValues(..));
        return;
      L_16:
        DeviceLog.error("Error while invoking method");
        throw INativeCallbackSubject.getCallback(..);
    }

    public void handleInvocation(String p0, String p1, Object[] p2, WebViewCallback p3) {
        WebViewBridge.findMethod(p0, p1, p2);
        WebViewBridge.getValues(p2, p3);
        WebViewBridge.findMethod(..).invoke(0, WebViewBridge.getValues(..));
        return;
      L_18:
        if (if-eqz(p3)) goto L_2e;
        WebViewBridge.findMethod(..).getMessage();
        p3.error(WebViewBridgeError.INVOCATION_FAILED, 4);
      L_2e:
        throw WebViewBridge.findMethod(..);
      L_32:
        p3.error(WebViewBridgeError.METHOD_NOT_FOUND, 3);
        throw WebViewBridge.findMethod(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.WebViewBridgeError
// ============================================================
package com.unity3d.services.core.webview.bridge;

public final class WebViewBridgeError extends Enum {
    private static final WebViewBridgeError[] $VALUES;
    public static final WebViewBridgeError CLASS_NOT_EXPOSED;
    public static final WebViewBridgeError CLASS_NOT_FOUND;
    public static final WebViewBridgeError DATA_GET_PARAMETER_VALUE_FAILED;
    public static final WebViewBridgeError DATA_JSON_PARSE_FAILED;
    public static final WebViewBridgeError DATA_PARAMETER_NULL;
    public static final WebViewBridgeError GETALLOWEDMETHODS_INVOCATION_FAILED;
    public static final WebViewBridgeError GETALLOWEDMETHODS_NOT_FOUND;
    public static final WebViewBridgeError INVOCATION_FAILED;
    public static final WebViewBridgeError METHOD_NOT_FOUND;
    public static final WebViewBridgeError METHOD_UNALLOWED;

    private static WebViewBridgeError[] $values() {
        return 10;
    }

    static <clinit>() {
        new WebViewBridgeError("CLASS_NOT_FOUND", 0);
        CLASS_NOT_FOUND = new WebViewBridgeError(..);
        new WebViewBridgeError("CLASS_NOT_EXPOSED", 1);
        CLASS_NOT_EXPOSED = new WebViewBridgeError(..);
        new WebViewBridgeError("GETALLOWEDMETHODS_NOT_FOUND", 2);
        GETALLOWEDMETHODS_NOT_FOUND = new WebViewBridgeError(..);
        new WebViewBridgeError("GETALLOWEDMETHODS_INVOCATION_FAILED", 3);
        GETALLOWEDMETHODS_INVOCATION_FAILED = new WebViewBridgeError(..);
        new WebViewBridgeError("METHOD_NOT_FOUND", 4);
        METHOD_NOT_FOUND = new WebViewBridgeError(..);
        new WebViewBridgeError("METHOD_UNALLOWED", 5);
        METHOD_UNALLOWED = new WebViewBridgeError(..);
        new WebViewBridgeError("DATA_JSON_PARSE_FAILED", 6);
        DATA_JSON_PARSE_FAILED = new WebViewBridgeError(..);
        new WebViewBridgeError("DATA_GET_PARAMETER_VALUE_FAILED", 7);
        DATA_GET_PARAMETER_VALUE_FAILED = new WebViewBridgeError(..);
        new WebViewBridgeError("DATA_PARAMETER_NULL", 8);
        DATA_PARAMETER_NULL = new WebViewBridgeError(..);
        new WebViewBridgeError("INVOCATION_FAILED", 9);
        INVOCATION_FAILED = new WebViewBridgeError(..);
        WebViewBridgeError.$values();
        $VALUES = WebViewBridgeError.$values(..);
        return;
    }

    private WebViewBridgeError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static WebViewBridgeError valueOf(String p0) {
        Enum.valueOf(WebViewBridgeError.class, p0);
        return Enum.valueOf(..);
    }

    public static WebViewBridgeError[] values() {
        WebViewBridgeError.$VALUES.clone();
        return WebViewBridgeError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.WebViewBridgeInterface
// ============================================================
package com.unity3d.services.core.webview.bridge;

public final class WebViewBridgeInterface {
    private final IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker;
    private final IWebViewBridge webViewBridge;

    public WebViewBridgeInterface() {
        new WebViewBridgeInterface(0, 0, 3, 0);
        return;
    }

    public WebViewBridgeInterface(IWebViewBridge p0, IInvocationCallbackInvoker p1) {
        new Object();
        webViewBridge = p0;
        webViewAppInvocationCallbackInvoker = p1;
        return;
    }

    public WebViewBridgeInterface(IWebViewBridge p0, IInvocationCallbackInvoker p1, int p2, DefaultConstructorMarker p3) {
        if (if-eqz(p3)) goto L_a;
        SharedInstances.INSTANCE.getWebViewBridge();
      L_a:
        if (if-eqz(p2)) goto L_14;
        SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker();
      L_14:
        new WebViewBridgeInterface(SharedInstances.getWebViewBridge(..), SharedInstances.getWebViewAppInvocationCallbackInvoker(..));
        return;
    }

    public final void handleCallback(String p0, String p1, String p2) {
        new StringBuilder("handleCallback ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(32);
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(32);
        new StringBuilder(..).append(p2);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        new JSONArray(p2);
        JSONArrayExtensionsKt.toTypedArray(new JSONArray(..));
        webViewBridge.handleCallback(p0, p1, JSONArrayExtensionsKt.toTypedArray(..));
        return;
    }

    public final void handleInvocation(String p0) {
        new StringBuilder("handleInvocation ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        new JSONArray(p0);
        new Invocation(webViewAppInvocationCallbackInvoker, webViewBridge);
        new JSONArray(..).length();
      L_2a:
        if (if-ge(0, JSONArray.length(..))) goto L_76;
        new JSONArray(..).get(0);
        Intrinsics.checkNotNull(JSONArray.get(..), "null cannot be cast to non-null type org.json.JSONArray");
        JSONArray.get(..).get(0);
        Intrinsics.checkNotNull(JSONArray.get(..), "null cannot be cast to non-null type kotlin.String");
        JSONArray.get(..).get(1);
        Intrinsics.checkNotNull(JSONArray.get(..), "null cannot be cast to non-null type kotlin.String");
        JSONArray.get(..).get(2);
        Intrinsics.checkNotNull(JSONArray.get(..), "null cannot be cast to non-null type org.json.JSONArray");
        JSONArray.get(..).get(3);
        Intrinsics.checkNotNull(JSONArray.get(..), "null cannot be cast to non-null type kotlin.String");
        JSONArrayExtensionsKt.toTypedArray(JSONArray.get(..));
        new Invocation(..).getId();
        new WebViewCallback(JSONArray.get(..), Invocation.getId(..));
        new Invocation(..).addInvocation(JSONArray.get(..), JSONArray.get(..), JSONArrayExtensionsKt.toTypedArray(..), new WebViewCallback(..));
        new Invocation(..).nextInvocation();
      L_76:
        new Invocation(..).sendInvocationCallback();
        return;
    }

    public final void onHandleCallback(WebView p0, WebMessageCompat p1, Uri p2, boolean p3, JavaScriptReplyProxy p4) {
        p1.getData();
        if (if-eqz(p3)) goto L_55;
        if (if-eqz(WebMessageCompat.getData(..))) goto L_28;
        StringsKt.isBlank(WebMessageCompat.getData(..));
        if (if-eqz(StringsKt.isBlank(..))) goto L_26;
      L_26:
      L_28:
      L_29:
        if (if-eqz(1)) goto L_2c;
      L_2c:
        new JSONObject(WebMessageCompat.getData(..));
        new JSONObject(..).getString("id");
        new JSONObject(..).getString("status");
        new JSONObject(..).getString("parameters");
        WebViewBridgeInterface.handleCallback(JSONObject.getString(..), JSONObject.getString(..), JSONObject.getString(..));
      L_55:
        return;
    }

    public final void onHandleInvocation(WebView p0, WebMessageCompat p1, Uri p2, boolean p3, JavaScriptReplyProxy p4) {
        p1.getData();
        if (if-eqz(p3)) goto L_2f;
        if (if-eqz(WebMessageCompat.getData(..))) goto L_28;
        StringsKt.isBlank(WebMessageCompat.getData(..));
        if (if-eqz(StringsKt.isBlank(..))) goto L_26;
      L_26:
      L_28:
      L_29:
        if (if-eqz(1)) goto L_2c;
      L_2c:
        WebViewBridgeInterface.handleInvocation(WebMessageCompat.getData(..));
      L_2f:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.WebViewBridgeInvoker
// ============================================================
package com.unity3d.services.core.webview.bridge;

public class WebViewBridgeInvoker {
    public WebViewBridgeInvoker() {
        new Object();
        return;
    }

    public boolean invokeMethod(String p0, String p1, Method p2, Object[] p3) {
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).invokeMethod(p0, p1, p2, p3);
        return WebViewApp.invokeMethod(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.WebViewBridgeSharedObjectStore
// ============================================================
package com.unity3d.services.core.webview.bridge;

public abstract class WebViewBridgeSharedObjectStore {
    private ConcurrentHashMap _sharedObjects;

    public WebViewBridgeSharedObjectStore() {
        new Object();
        new ConcurrentHashMap();
        _sharedObjects = new ConcurrentHashMap(..);
        return;
    }

    public IWebViewSharedObject get(String p0) {
        if (if-nez(p0)) goto L_4;
        return 0;
      L_4:
        _sharedObjects.get(0);
        return ConcurrentHashMap.get(..);
    }

    public void remove(IWebViewSharedObject p0) {
        if (if-nez(p0)) goto L_3;
        return;
      L_3:
        p0.getId();
        WebViewBridgeSharedObjectStore.remove(IWebViewSharedObject.getId(..));
        return;
    }

    public void remove(String p0) {
        _sharedObjects.remove(p0);
        return;
    }

    public void set(IWebViewSharedObject p0) {
        if (if-nez(p0)) goto L_3;
        return;
      L_3:
        p0.getId();
        _sharedObjects.put(IWebViewSharedObject.getId(..), p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.WebViewCallback
// ============================================================
package com.unity3d.services.core.webview.bridge;

public class WebViewCallback {
    public static final Parcelable$Creator CREATOR;
    private String _callbackId;
    private int _invocationId;
    private boolean _invoked;

    static <clinit>() {
        new WebViewCallback$1();
        CREATOR = new WebViewCallback$1(..);
        return;
    }

    public WebViewCallback(Parcel p0) {
        new Object();
        p0.readString();
        _callbackId = Parcel.readString(..);
        p0.readByte();
        if (if-eqz(Parcel.readByte(..))) goto L_11;
      L_11:
      L_12:
        _invoked = 0;
        p0.readInt();
        _invocationId = Parcel.readInt(..);
        return;
    }

    public WebViewCallback(String p0, int p1) {
        new Object();
        _callbackId = p0;
        _invocationId = p1;
        return;
    }

    private void invoke(CallbackStatus p0, Enum p1, Object[] p2) {
        if (if-nez(_invoked)) goto L_49;
        if (if-eqz(_callbackId)) goto L_49;
        _callbackId.length();
        if (if-nez(String.length(..))) goto L_f;
      L_f:
        _invoked = 1;
        new ArrayList();
        Arrays.asList(p2);
        new ArrayList(..).addAll(Arrays.asList(..));
        new ArrayList(..).add(0, _callbackId);
        Invocation.getInvocationById(_invocationId);
        if (if-nez(Invocation.getInvocationById(..))) goto L_42;
        new StringBuilder("Couldn't get batch with id: ");
        WebViewCallback.getInvocationId();
        new StringBuilder(..).append(WebViewCallback.getInvocationId(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
        return;
      L_42:
        new ArrayList(..).toArray();
        Invocation.getInvocationById(..).setInvocationResponse(StringBuilder.toString(..), WebViewCallback.getInvocationId(..), ArrayList.toArray(..));
      L_49:
        return;
    }

    public int describeContents() {
        return 45678;
    }

    public void error(Enum p0, Object[] p1) {
        WebViewCallback.invoke(CallbackStatus.ERROR, p0, p1);
        return;
    }

    public String getCallbackId() {
        return _callbackId;
    }

    public int getInvocationId() {
        return _invocationId;
    }

    public void invoke(Object[] p0) {
        WebViewCallback.invoke(CallbackStatus.OK, 0, p0);
        return;
    }

    public void writeToParcel(Parcel p0, int p1) {
        p0.writeString(_callbackId);
        p0.writeByte(_invoked);
        p0.writeInt(_invocationId);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.WebViewExposed
// ============================================================
package com.unity3d.services.core.webview.bridge;

public abstract class WebViewExposed {
}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.SharedInstances$webViewAppNativeCallbackSubject$1
// ============================================================
package com.unity3d.services.core.webview.bridge;

public final class SharedInstances$webViewAppNativeCallbackSubject$1 {
    SharedInstances$webViewAppNativeCallbackSubject$1() {
        new Object();
        return;
    }

    public NativeCallback getCallback(String p0) {
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getCallback(p0);
        return WebViewApp.getCallback(..);
    }

    public void remove(NativeCallback p0) {
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).removeCallback(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.SharedInstances$webViewBridge$1
// ============================================================
package com.unity3d.services.core.webview.bridge;

public final class SharedInstances$webViewBridge$1 {
    SharedInstances$webViewBridge$1() {
        new Object();
        return;
    }

    public void handleCallback(String p0, String p1, Object[] p2) {
        WebViewBridge.getInstance();
        WebViewBridge.getInstance(..).handleCallback(p0, p1, p2);
        return;
    }

    public void handleInvocation(String p0, String p1, Object[] p2, WebViewCallback p3) {
        WebViewBridge.getInstance();
        WebViewBridge.getInstance(..).handleInvocation(p0, p1, p2, p3);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.SharedInstances$webViewEventSender$1
// ============================================================
package com.unity3d.services.core.webview.bridge;

public final class SharedInstances$webViewEventSender$1 {
    SharedInstances$webViewEventSender$1() {
        new Object();
        return;
    }

    public boolean canSend() {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_8;
      L_8:
      L_9:
        return 0;
    }

    public boolean sendEvent(Enum p0, Enum p1, Object[] p2) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_1f;
        Arrays.copyOf(p2, v1);
        WebViewApp.getCurrentApp(..).sendEvent(p0, p1, Arrays.copyOf(..));
      L_1f:
      L_20:
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.webview.bridge.WebViewCallback$1
// ============================================================
package com.unity3d.services.core.webview.bridge;

class WebViewCallback$1 {
    WebViewCallback$1() {
        new Object();
        return;
    }

    public WebViewCallback createFromParcel(Parcel p0) {
        new WebViewCallback(p0);
        return new WebViewCallback(..);
    }

    public Object createFromParcel(Parcel p0) {
        WebViewCallback$1.createFromParcel(p0);
        return WebViewCallback$1.createFromParcel(..);
    }

    public WebViewCallback[] newArray(int p0) {
        return p0;
    }

    public Object[] newArray(int p0) {
        WebViewCallback$1.newArray(p0);
        return WebViewCallback$1.newArray(..);
    }

}

