
// ===== FILE: com/unity3d/services/core/webview/bridge/CallbackStatus.java =====
package com.unity3d.services.core.webview.bridge;

/* loaded from: classes.dex */
public enum CallbackStatus {
    OK,
    ERROR
}

// ===== FILE: com/unity3d/services/core/webview/bridge/IEventSender.java =====
package com.unity3d.services.core.webview.bridge;

import kotlin.Metadata;

/* compiled from: IEventSender.kt */
@Metadata(m443d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J9\u0010\u0004\u001a\u00020\u00032\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t\"\u00020\u0001H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m444d2 = {"Lcom/unity3d/services/core/webview/bridge/IEventSender;", "", "canSend", "", "sendEvent", "eventCategory", "", "eventId", "params", "", "(Ljava/lang/Enum;Ljava/lang/Enum;[Ljava/lang/Object;)Z", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface IEventSender {
    boolean canSend();

    boolean sendEvent(Enum<?> eventCategory, Enum<?> eventId, Object... params);
}

// ===== FILE: com/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker.java =====
package com.unity3d.services.core.webview.bridge;

import kotlin.Metadata;

/* compiled from: IInvocationCallbackInvoker.kt */
@Metadata(m443d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m444d2 = {"Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;", "", "invokeCallback", "", "invocation", "Lcom/unity3d/services/core/webview/bridge/Invocation;", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface IInvocationCallbackInvoker {
    void invokeCallback(Invocation invocation);
}

// ===== FILE: com/unity3d/services/core/webview/bridge/INativeCallbackSubject.java =====
package com.unity3d.services.core.webview.bridge;

import kotlin.Metadata;

/* compiled from: INativeCallbackSubject.kt */
@Metadata(m443d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, m444d2 = {"Lcom/unity3d/services/core/webview/bridge/INativeCallbackSubject;", "", "getCallback", "Lcom/unity3d/services/core/webview/bridge/NativeCallback;", "callbackId", "", "remove", "", "callback", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface INativeCallbackSubject {
    NativeCallback getCallback(String callbackId);

    void remove(NativeCallback callback);
}

// ===== FILE: com/unity3d/services/core/webview/bridge/IWebViewBridge.java =====
package com.unity3d.services.core.webview.bridge;

import kotlin.Metadata;

/* compiled from: IWebViewBridge.kt */
@Metadata(m443d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bH&¢\u0006\u0002\u0010\tJ=\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m444d2 = {"Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;", "", "handleCallback", "", "callbackId", "", "callbackStatus", "parameters", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "handleInvocation", "className", "methodName", "callback", "Lcom/unity3d/services/core/webview/bridge/WebViewCallback;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;Lcom/unity3d/services/core/webview/bridge/WebViewCallback;)V", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public interface IWebViewBridge {
    void handleCallback(String callbackId, String callbackStatus, Object[] parameters) throws Exception;

    void handleInvocation(String className, String methodName, Object[] parameters, WebViewCallback callback) throws Exception;
}

// ===== FILE: com/unity3d/services/core/webview/bridge/IWebViewBridgeInvoker.java =====
package com.unity3d.services.core.webview.bridge;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public interface IWebViewBridgeInvoker {
    boolean invokeMethod(String str, String str2, Method method, Object... objArr);
}

// ===== FILE: com/unity3d/services/core/webview/bridge/IWebViewBridgeSharedObjectStore.java =====
package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;

/* loaded from: classes.dex */
public interface IWebViewBridgeSharedObjectStore<T extends IWebViewSharedObject> {
    T get(String str);

    void remove(String str);

    void set(T t);
}

// ===== FILE: com/unity3d/services/core/webview/bridge/IWebViewSharedObject.java =====
package com.unity3d.services.core.webview.bridge;

/* loaded from: classes.dex */
public interface IWebViewSharedObject {
    String getId();
}

// ===== FILE: com/unity3d/services/core/webview/bridge/Invocation.java =====
package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.log.DeviceLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class Invocation {
    private static AtomicInteger _idCount = new AtomicInteger(0);
    private static Map<Integer, Invocation> _invocationSets;
    private IInvocationCallbackInvoker _invocationCallbackInvoker;
    private int _invocationId;
    private ArrayList<ArrayList<Object>> _invocations;
    private ArrayList<ArrayList<Object>> _responses;
    private final IWebViewBridge _webViewBridge;

    public Invocation() {
        this(SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker(), SharedInstances.INSTANCE.getWebViewBridge());
    }

    public Invocation(IWebViewBridge iWebViewBridge) {
        this(SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker(), iWebViewBridge);
    }

    public Invocation(IInvocationCallbackInvoker iInvocationCallbackInvoker, IWebViewBridge iWebViewBridge) {
        this._invocationCallbackInvoker = iInvocationCallbackInvoker;
        this._webViewBridge = iWebViewBridge;
        this._invocationId = _idCount.getAndIncrement();
        if (_invocationSets == null) {
            _invocationSets = new HashMap();
        }
        _invocationSets.put(Integer.valueOf(this._invocationId), this);
    }

    public void addInvocation(String str, String str2, Object[] objArr, WebViewCallback webViewCallback) {
        if (this._invocations == null) {
            this._invocations = new ArrayList<>();
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(str);
        arrayList.add(str2);
        arrayList.add(objArr);
        arrayList.add(webViewCallback);
        this._invocations.add(arrayList);
    }

    public boolean nextInvocation() {
        ArrayList<ArrayList<Object>> arrayList = this._invocations;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        ArrayList<Object> remove = this._invocations.remove(0);
        String str = (String) remove.get(0);
        String str2 = (String) remove.get(1);
        Object[] objArr = (Object[]) remove.get(2);
        try {
            this._webViewBridge.handleInvocation(str, str2, objArr, (WebViewCallback) remove.get(3));
        } catch (Exception e) {
            DeviceLog.exception(String.format("Error handling invocation %s.%s(%s)", str, str2, Arrays.toString(objArr)), e);
        }
        return true;
    }

    public void setInvocationResponse(CallbackStatus callbackStatus, Enum r3, Object... objArr) {
        if (this._responses == null) {
            this._responses = new ArrayList<>();
        }
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(callbackStatus);
        arrayList.add(r3);
        arrayList.add(objArr);
        this._responses.add(arrayList);
    }

    public void sendInvocationCallback() {
        _invocationSets.remove(Integer.valueOf(getId()));
        this._invocationCallbackInvoker.invokeCallback(this);
    }

    public int getId() {
        return this._invocationId;
    }

    public ArrayList<ArrayList<Object>> getResponses() {
        return this._responses;
    }

    public static synchronized Invocation getInvocationById(int i) {
        synchronized (Invocation.class) {
            Map<Integer, Invocation> map = _invocationSets;
            if (map == null || !map.containsKey(Integer.valueOf(i))) {
                return null;
            }
            return _invocationSets.get(Integer.valueOf(i));
        }
    }
}

// ===== FILE: com/unity3d/services/core/webview/bridge/NativeCallback.java =====
package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.log.DeviceLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class NativeCallback {
    private static AtomicInteger _callbackCount = new AtomicInteger(0);
    private Method _callback;
    private String _id;
    private final INativeCallbackSubject _nativeCallbackSubject;

    public NativeCallback(Method method) {
        this(method, SharedInstances.INSTANCE.getWebViewAppNativeCallbackSubject());
    }

    public NativeCallback(Method method, INativeCallbackSubject iNativeCallbackSubject) {
        this._callback = method;
        this._id = this._callback.getName().toUpperCase(Locale.US) + "_" + _callbackCount.getAndIncrement();
        this._nativeCallbackSubject = iNativeCallbackSubject;
    }

    public String getId() {
        return this._id;
    }

    public void invoke(String str, Object... objArr) throws InvocationTargetException, IllegalAccessException, IllegalArgumentException {
        Object[] array;
        try {
            CallbackStatus valueOf = CallbackStatus.valueOf(str);
            if (objArr == null) {
                array = new Object[]{valueOf};
            } else {
                ArrayList arrayList = new ArrayList(Arrays.asList(objArr));
                arrayList.add(0, valueOf);
                array = arrayList.toArray();
            }
            this._callback.invoke(null, array);
            this._nativeCallbackSubject.remove(this);
        } catch (Exception e) {
            DeviceLog.error("Illegal status");
            this._nativeCallbackSubject.remove(this);
            throw e;
        }
    }
}

// ===== FILE: com/unity3d/services/core/webview/bridge/SharedInstances.java =====
package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.webview.WebViewApp;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedInstances.kt */
@Metadata(m443d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m444d2 = {"Lcom/unity3d/services/core/webview/bridge/SharedInstances;", "", "()V", "webViewAppInvocationCallbackInvoker", "Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;", "getWebViewAppInvocationCallbackInvoker", "()Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;", "webViewAppNativeCallbackSubject", "Lcom/unity3d/services/core/webview/bridge/INativeCallbackSubject;", "getWebViewAppNativeCallbackSubject", "()Lcom/unity3d/services/core/webview/bridge/INativeCallbackSubject;", "webViewBridge", "Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;", "getWebViewBridge", "()Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;", "webViewEventSender", "Lcom/unity3d/services/core/webview/bridge/IEventSender;", "getWebViewEventSender", "()Lcom/unity3d/services/core/webview/bridge/IEventSender;", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class SharedInstances {
    public static final SharedInstances INSTANCE = new SharedInstances();
    private static final IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker = new IInvocationCallbackInvoker() { // from class: com.unity3d.services.core.webview.bridge.SharedInstances$$ExternalSyntheticLambda0
        @Override // com.unity3d.services.core.webview.bridge.IInvocationCallbackInvoker
        public final void invokeCallback(Invocation invocation) {
            SharedInstances.webViewAppInvocationCallbackInvoker$lambda$0(invocation);
        }
    };
    private static final INativeCallbackSubject webViewAppNativeCallbackSubject = new INativeCallbackSubject() { // from class: com.unity3d.services.core.webview.bridge.SharedInstances$webViewAppNativeCallbackSubject$1
        @Override // com.unity3d.services.core.webview.bridge.INativeCallbackSubject
        public void remove(NativeCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            WebViewApp.getCurrentApp().removeCallback(callback);
        }

        @Override // com.unity3d.services.core.webview.bridge.INativeCallbackSubject
        public NativeCallback getCallback(String callbackId) {
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            NativeCallback callback = WebViewApp.getCurrentApp().getCallback(callbackId);
            Intrinsics.checkNotNullExpressionValue(callback, "getCurrentApp().getCallback(callbackId)");
            return callback;
        }
    };
    private static final IEventSender webViewEventSender = new IEventSender() { // from class: com.unity3d.services.core.webview.bridge.SharedInstances$webViewEventSender$1
        @Override // com.unity3d.services.core.webview.bridge.IEventSender
        public boolean sendEvent(Enum<?> eventCategory, Enum<?> eventId, Object... params) {
            Intrinsics.checkNotNullParameter(eventCategory, "eventCategory");
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(params, "params");
            WebViewApp currentApp = WebViewApp.getCurrentApp();
            if (currentApp != null) {
                return currentApp.sendEvent(eventCategory, eventId, Arrays.copyOf(params, params.length));
            }
            return false;
        }

        @Override // com.unity3d.services.core.webview.bridge.IEventSender
        public boolean canSend() {
            return WebViewApp.getCurrentApp() != null;
        }
    };
    private static final IWebViewBridge webViewBridge = new IWebViewBridge() { // from class: com.unity3d.services.core.webview.bridge.SharedInstances$webViewBridge$1
        @Override // com.unity3d.services.core.webview.bridge.IWebViewBridge
        public void handleInvocation(String className, String methodName, Object[] parameters, WebViewCallback callback) throws Exception {
            WebViewBridge.getInstance().handleInvocation(className, methodName, parameters, callback);
        }

        @Override // com.unity3d.services.core.webview.bridge.IWebViewBridge
        public void handleCallback(String callbackId, String callbackStatus, Object[] parameters) throws Exception {
            WebViewBridge.getInstance().handleCallback(callbackId, callbackStatus, parameters);
        }
    };

    private SharedInstances() {
    }

    public final IInvocationCallbackInvoker getWebViewAppInvocationCallbackInvoker() {
        return webViewAppInvocationCallbackInvoker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void webViewAppInvocationCallbackInvoker$lambda$0(Invocation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        WebViewApp.getCurrentApp().invokeCallback(it);
    }

    public final INativeCallbackSubject getWebViewAppNativeCallbackSubject() {
        return webViewAppNativeCallbackSubject;
    }

    public final IEventSender getWebViewEventSender() {
        return webViewEventSender;
    }

    public final IWebViewBridge getWebViewBridge() {
        return webViewBridge;
    }
}

// ===== FILE: com/unity3d/services/core/webview/bridge/WebViewBridge.java =====
package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.log.DeviceLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;

/* loaded from: classes.dex */
public class WebViewBridge implements IWebViewBridge {
    private static IWebViewBridge _instance;
    private HashMap<String, HashMap<String, HashMap<Integer, Method>>> _classTable;
    private final INativeCallbackSubject nativeCallbackSubject;

    public static void setClassTable(Class[] clsArr) {
        _instance = new WebViewBridge(clsArr, SharedInstances.INSTANCE.getWebViewAppNativeCallbackSubject());
    }

    public static IWebViewBridge getInstance() {
        return _instance;
    }

    private WebViewBridge(Class[] clsArr, INativeCallbackSubject iNativeCallbackSubject) {
        HashMap<Integer, Method> hashMap;
        this.nativeCallbackSubject = iNativeCallbackSubject;
        if (clsArr == null) {
            return;
        }
        this._classTable = new HashMap<>();
        for (Class cls : clsArr) {
            if (cls != null && (cls.getPackage().getName().startsWith("com.unity3d.services") || cls.getPackage().getName().startsWith("com.unity3d.ads.test"))) {
                HashMap<String, HashMap<Integer, Method>> hashMap2 = new HashMap<>();
                for (Method method : cls.getMethods()) {
                    if (method.getAnnotation(WebViewExposed.class) != null) {
                        String name = method.getName();
                        if (hashMap2.containsKey(name)) {
                            hashMap = hashMap2.get(name);
                        } else {
                            hashMap = new HashMap<>();
                        }
                        hashMap.put(Integer.valueOf(Arrays.deepHashCode(method.getParameterTypes())), method);
                        hashMap2.put(name, hashMap);
                    }
                }
                this._classTable.put(cls.getName(), hashMap2);
            }
        }
    }

    private Method findMethod(String str, String str2, Object[] objArr) throws JSONException, NoSuchMethodException {
        if (!this._classTable.containsKey(str)) {
            throw new NoSuchMethodException();
        }
        HashMap<String, HashMap<Integer, Method>> hashMap = this._classTable.get(str);
        if (!hashMap.containsKey(str2)) {
            throw new NoSuchMethodException();
        }
        return hashMap.get(str2).get(Integer.valueOf(Arrays.deepHashCode(getTypes(objArr))));
    }

    private Class<?>[] getTypes(Object[] objArr) throws JSONException {
        Class<?>[] clsArr = objArr == null ? new Class[1] : new Class[objArr.length + 1];
        if (objArr != null) {
            for (int i = 0; i < objArr.length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
        }
        clsArr[clsArr.length - 1] = WebViewCallback.class;
        return clsArr;
    }

    private Object[] getValues(Object[] objArr, WebViewCallback webViewCallback) throws JSONException {
        Object[] objArr2;
        if (objArr != null) {
            objArr2 = new Object[objArr.length + (webViewCallback != null ? 1 : 0)];
        } else {
            if (webViewCallback == null) {
                return null;
            }
            objArr2 = new Object[1];
        }
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
        if (webViewCallback != null) {
            objArr2[objArr2.length - 1] = webViewCallback;
        }
        return objArr2;
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridge
    public void handleInvocation(String str, String str2, Object[] objArr, WebViewCallback webViewCallback) throws Exception {
        try {
            try {
                findMethod(str, str2, objArr).invoke(null, getValues(objArr, webViewCallback));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | JSONException e) {
                if (webViewCallback != null) {
                    webViewCallback.error(WebViewBridgeError.INVOCATION_FAILED, str, str2, objArr, e.getMessage());
                }
                throw e;
            }
        } catch (NoSuchMethodException | JSONException e2) {
            webViewCallback.error(WebViewBridgeError.METHOD_NOT_FOUND, str, str2, objArr);
            throw e2;
        }
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridge
    public void handleCallback(String str, String str2, Object[] objArr) throws Exception {
        try {
            this.nativeCallbackSubject.getCallback(str).invoke(str2, getValues(objArr, null));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | JSONException e) {
            DeviceLog.error("Error while invoking method");
            throw e;
        }
    }
}

// ===== FILE: com/unity3d/services/core/webview/bridge/WebViewBridgeError.java =====
package com.unity3d.services.core.webview.bridge;

/* loaded from: classes.dex */
public enum WebViewBridgeError {
    CLASS_NOT_FOUND,
    CLASS_NOT_EXPOSED,
    GETALLOWEDMETHODS_NOT_FOUND,
    GETALLOWEDMETHODS_INVOCATION_FAILED,
    METHOD_NOT_FOUND,
    METHOD_UNALLOWED,
    DATA_JSON_PARSE_FAILED,
    DATA_GET_PARAMETER_VALUE_FAILED,
    DATA_PARAMETER_NULL,
    INVOCATION_FAILED
}

// ===== FILE: com/unity3d/services/core/webview/bridge/WebViewBridgeInterface.java =====
package com.unity3d.services.core.webview.bridge;

import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import com.unity3d.ads.core.extensions.JSONArrayExtensionsKt;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.unity3d.services.core.log.DeviceLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WebViewBridgeInterface.kt */
@Metadata(m443d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007J.\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J.\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m444d2 = {"Lcom/unity3d/services/core/webview/bridge/WebViewBridgeInterface;", "", "webViewBridge", "Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;", "webViewAppInvocationCallbackInvoker", "Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;", "(Lcom/unity3d/services/core/webview/bridge/IWebViewBridge;Lcom/unity3d/services/core/webview/bridge/IInvocationCallbackInvoker;)V", "handleCallback", "", "callbackId", "", "callbackStatus", "rawParameters", "handleInvocation", JsonStorageKeyNames.DATA_KEY, "onHandleCallback", "view", "Landroid/webkit/WebView;", "message", "Landroidx/webkit/WebMessageCompat;", "sourceOrigin", "Landroid/net/Uri;", "isMainFrame", "", "replyProxy", "Landroidx/webkit/JavaScriptReplyProxy;", "onHandleInvocation", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class WebViewBridgeInterface {
    private final IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker;
    private final IWebViewBridge webViewBridge;

    /* JADX WARN: Multi-variable type inference failed */
    public WebViewBridgeInterface() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public WebViewBridgeInterface(IWebViewBridge webViewBridge, IInvocationCallbackInvoker webViewAppInvocationCallbackInvoker) {
        Intrinsics.checkNotNullParameter(webViewBridge, "webViewBridge");
        Intrinsics.checkNotNullParameter(webViewAppInvocationCallbackInvoker, "webViewAppInvocationCallbackInvoker");
        this.webViewBridge = webViewBridge;
        this.webViewAppInvocationCallbackInvoker = webViewAppInvocationCallbackInvoker;
    }

    public /* synthetic */ WebViewBridgeInterface(IWebViewBridge iWebViewBridge, IInvocationCallbackInvoker iInvocationCallbackInvoker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SharedInstances.INSTANCE.getWebViewBridge() : iWebViewBridge, (i & 2) != 0 ? SharedInstances.INSTANCE.getWebViewAppInvocationCallbackInvoker() : iInvocationCallbackInvoker);
    }

    @JavascriptInterface
    public final void handleInvocation(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        DeviceLog.debug("handleInvocation " + data);
        JSONArray jSONArray = new JSONArray(data);
        Invocation invocation = new Invocation(this.webViewAppInvocationCallbackInvoker, this.webViewBridge);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArray.get(i);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray2 = (JSONArray) obj;
            Object obj2 = jSONArray2.get(0);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = jSONArray2.get(1);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            Object obj4 = jSONArray2.get(2);
            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type org.json.JSONArray");
            Object obj5 = jSONArray2.get(3);
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
            invocation.addInvocation((String) obj2, (String) obj3, JSONArrayExtensionsKt.toTypedArray((JSONArray) obj4), new WebViewCallback((String) obj5, invocation.getId()));
            invocation.nextInvocation();
        }
        invocation.sendInvocationCallback();
    }

    @JavascriptInterface
    public final void handleCallback(String callbackId, String callbackStatus, String rawParameters) {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(callbackStatus, "callbackStatus");
        Intrinsics.checkNotNullParameter(rawParameters, "rawParameters");
        DeviceLog.debug("handleCallback " + callbackId + ' ' + callbackStatus + ' ' + rawParameters);
        this.webViewBridge.handleCallback(callbackId, callbackStatus, JSONArrayExtensionsKt.toTypedArray(new JSONArray(rawParameters)));
    }

    public final void onHandleInvocation(WebView view, WebMessageCompat message, Uri sourceOrigin, boolean isMainFrame, JavaScriptReplyProxy replyProxy) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(sourceOrigin, "sourceOrigin");
        Intrinsics.checkNotNullParameter(replyProxy, "replyProxy");
        String data = message.getData();
        if (isMainFrame) {
            String str = data;
            if (str == null || StringsKt.isBlank(str)) {
                return;
            }
            handleInvocation(data);
        }
    }

    public final void onHandleCallback(WebView view, WebMessageCompat message, Uri sourceOrigin, boolean isMainFrame, JavaScriptReplyProxy replyProxy) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(sourceOrigin, "sourceOrigin");
        Intrinsics.checkNotNullParameter(replyProxy, "replyProxy");
        String data = message.getData();
        if (isMainFrame) {
            String str = data;
            if (str == null || StringsKt.isBlank(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(data);
            String callbackId = jSONObject.getString("id");
            String callbackStatus = jSONObject.getString(NotificationCompat.CATEGORY_STATUS);
            String rawParameters = jSONObject.getString("parameters");
            Intrinsics.checkNotNullExpressionValue(callbackId, "callbackId");
            Intrinsics.checkNotNullExpressionValue(callbackStatus, "callbackStatus");
            Intrinsics.checkNotNullExpressionValue(rawParameters, "rawParameters");
            handleCallback(callbackId, callbackStatus, rawParameters);
        }
    }
}

// ===== FILE: com/unity3d/services/core/webview/bridge/WebViewBridgeInvoker.java =====
package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.webview.WebViewApp;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class WebViewBridgeInvoker implements IWebViewBridgeInvoker {
    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridgeInvoker
    public boolean invokeMethod(String str, String str2, Method method, Object... objArr) {
        return WebViewApp.getCurrentApp().invokeMethod(str, str2, method, objArr);
    }
}

// ===== FILE: com/unity3d/services/core/webview/bridge/WebViewBridgeSharedObjectStore.java =====
package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.webview.bridge.IWebViewSharedObject;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class WebViewBridgeSharedObjectStore<T extends IWebViewSharedObject> implements IWebViewBridgeSharedObjectStore<T> {
    private ConcurrentHashMap<String, T> _sharedObjects = new ConcurrentHashMap<>();

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore
    public T get(String str) {
        if (str == null) {
            return null;
        }
        return this._sharedObjects.get(str);
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore
    public void set(T t) {
        if (t == null) {
            return;
        }
        this._sharedObjects.put(t.getId(), t);
    }

    public void remove(T t) {
        if (t == null) {
            return;
        }
        remove(t.getId());
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewBridgeSharedObjectStore
    public void remove(String str) {
        this._sharedObjects.remove(str);
    }
}

// ===== FILE: com/unity3d/services/core/webview/bridge/WebViewCallback.java =====
package com.unity3d.services.core.webview.bridge;

import android.os.Parcel;
import android.os.Parcelable;
import com.unity3d.services.core.log.DeviceLog;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class WebViewCallback implements Parcelable {
    public static final Parcelable.Creator<WebViewCallback> CREATOR = new Parcelable.Creator<WebViewCallback>() { // from class: com.unity3d.services.core.webview.bridge.WebViewCallback.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WebViewCallback createFromParcel(Parcel parcel) {
            return new WebViewCallback(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WebViewCallback[] newArray(int i) {
            return new WebViewCallback[i];
        }
    };
    private String _callbackId;
    private int _invocationId;
    private boolean _invoked;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 45678;
    }

    public WebViewCallback(String str, int i) {
        this._callbackId = str;
        this._invocationId = i;
    }

    public WebViewCallback(Parcel parcel) {
        this._callbackId = parcel.readString();
        this._invoked = parcel.readByte() != 0;
        this._invocationId = parcel.readInt();
    }

    public void invoke(Object... objArr) {
        invoke(CallbackStatus.OK, null, objArr);
    }

    private void invoke(CallbackStatus callbackStatus, Enum r4, Object... objArr) {
        String str;
        if (this._invoked || (str = this._callbackId) == null || str.length() == 0) {
            return;
        }
        this._invoked = true;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(objArr));
        arrayList.add(0, this._callbackId);
        Invocation invocationById = Invocation.getInvocationById(this._invocationId);
        if (invocationById == null) {
            DeviceLog.error("Couldn't get batch with id: " + getInvocationId());
            return;
        }
        invocationById.setInvocationResponse(callbackStatus, r4, arrayList.toArray());
    }

    public void error(Enum r2, Object... objArr) {
        invoke(CallbackStatus.ERROR, r2, objArr);
    }

    public int getInvocationId() {
        return this._invocationId;
    }

    public String getCallbackId() {
        return this._callbackId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this._callbackId);
        parcel.writeByte(this._invoked ? (byte) 1 : (byte) 0);
        parcel.writeInt(this._invocationId);
    }
}

// ===== FILE: com/unity3d/services/core/webview/bridge/WebViewExposed.java =====
package com.unity3d.services.core.webview.bridge;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface WebViewExposed {
}
