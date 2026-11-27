
// ===== FILE: org/chromium/support_lib_boundary/util/BoundaryInterfaceReflectionUtil.java =====
package org.chromium.support_lib_boundary.util;

import android.os.Build;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes2.dex */
public class BoundaryInterfaceReflectionUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static boolean instanceOfInOwnClassLoader(Object obj, String str) {
        try {
            return Class.forName(str, false, obj.getClass().getClassLoader()).isInstance(obj);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Method dupeMethod(Method method, ClassLoader classLoader) throws ClassNotFoundException, NoSuchMethodException {
        return Class.forName(method.getDeclaringClass().getName(), true, classLoader).getDeclaredMethod(method.getName(), method.getParameterTypes());
    }

    public static <T> T castToSuppLibClass(Class<T> cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(BoundaryInterfaceReflectionUtil.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static InvocationHandler createInvocationHandlerFor(Object obj) {
        if (obj == null) {
            return null;
        }
        return new InvocationHandlerWithDelegateGetter(obj);
    }

    public static InvocationHandler[] createInvocationHandlersForArray(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        int length = objArr.length;
        InvocationHandler[] invocationHandlerArr = new InvocationHandler[length];
        for (int i = 0; i < length; i++) {
            invocationHandlerArr[i] = createInvocationHandlerFor(objArr[i]);
        }
        return invocationHandlerArr;
    }

    public static Object getDelegateFromInvocationHandler(InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return ((InvocationHandlerWithDelegateGetter) invocationHandler).getDelegate();
    }

    private static class InvocationHandlerWithDelegateGetter implements InvocationHandler {
        private final Object mDelegate;

        public InvocationHandlerWithDelegateGetter(Object obj) {
            this.mDelegate = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                return BoundaryInterfaceReflectionUtil.dupeMethod(method, this.mDelegate.getClass().getClassLoader()).invoke(this.mDelegate, objArr);
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            } catch (ReflectiveOperationException e2) {
                throw new RuntimeException("Reflection failed for method " + method, e2);
            }
        }

        public Object getDelegate() {
            return this.mDelegate;
        }
    }

    private static boolean isDebuggable() {
        return "eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE);
    }

    public static boolean containsFeature(Collection<String> collection, String str) {
        if (!collection.contains(str)) {
            if (isDebuggable()) {
                if (collection.contains(str + Features.DEV_SUFFIX)) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean containsFeature(String[] strArr, String str) {
        return containsFeature(Arrays.asList(strArr), str);
    }
}

// ===== FILE: org/chromium/support_lib_boundary/util/Features.java =====
package org.chromium.support_lib_boundary.util;

/* loaded from: classes2.dex */
public class Features {
    public static final String ALGORITHMIC_DARKENING = "ALGORITHMIC_DARKENING";
    public static final String CREATE_WEB_MESSAGE_CHANNEL = "CREATE_WEB_MESSAGE_CHANNEL";
    public static final String DEV_SUFFIX = ":dev";
    public static final String DISABLED_ACTION_MODE_MENU_ITEMS = "DISABLED_ACTION_MODE_MENU_ITEMS";
    public static final String DOCUMENT_START_SCRIPT = "DOCUMENT_START_SCRIPT:1";
    public static final String ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY = "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY";
    public static final String FORCE_DARK = "FORCE_DARK";
    public static final String FORCE_DARK_BEHAVIOR = "FORCE_DARK_BEHAVIOR";
    public static final String GET_COOKIE_INFO = "GET_COOKIE_INFO";
    public static final String GET_VARIATIONS_HEADER = "GET_VARIATIONS_HEADER";
    public static final String GET_WEB_CHROME_CLIENT = "GET_WEB_CHROME_CLIENT";
    public static final String GET_WEB_VIEW_CLIENT = "GET_WEB_VIEW_CLIENT";
    public static final String GET_WEB_VIEW_RENDERER = "GET_WEB_VIEW_RENDERER";
    public static final String IMAGE_DRAG_DROP = "IMAGE_DRAG_DROP";
    public static final String MULTI_PROCESS_QUERY = "MULTI_PROCESS_QUERY";
    public static final String OFF_SCREEN_PRERASTER = "OFF_SCREEN_PRERASTER";
    public static final String POST_WEB_MESSAGE = "POST_WEB_MESSAGE";
    public static final String PROXY_OVERRIDE = "PROXY_OVERRIDE:3";
    public static final String PROXY_OVERRIDE_REVERSE_BYPASS = "PROXY_OVERRIDE_REVERSE_BYPASS";
    public static final String RECEIVE_HTTP_ERROR = "RECEIVE_HTTP_ERROR";
    public static final String RECEIVE_WEB_RESOURCE_ERROR = "RECEIVE_WEB_RESOURCE_ERROR";
    public static final String REQUESTED_WITH_HEADER_ALLOW_LIST = "REQUESTED_WITH_HEADER_ALLOW_LIST";

    @Deprecated
    public static final String REQUESTED_WITH_HEADER_CONTROL = "REQUESTED_WITH_HEADER_CONTROL";
    public static final String SAFE_BROWSING_ALLOWLIST = "SAFE_BROWSING_ALLOWLIST";
    public static final String SAFE_BROWSING_ENABLE = "SAFE_BROWSING_ENABLE";
    public static final String SAFE_BROWSING_HIT = "SAFE_BROWSING_HIT";
    public static final String SAFE_BROWSING_PRIVACY_POLICY_URL = "SAFE_BROWSING_PRIVACY_POLICY_URL";
    public static final String SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY = "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY";
    public static final String SAFE_BROWSING_RESPONSE_PROCEED = "SAFE_BROWSING_RESPONSE_PROCEED";
    public static final String SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL = "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL";
    public static final String SAFE_BROWSING_WHITELIST = "SAFE_BROWSING_WHITELIST";
    public static final String SERVICE_WORKER_BASIC_USAGE = "SERVICE_WORKER_BASIC_USAGE";
    public static final String SERVICE_WORKER_BLOCK_NETWORK_LOADS = "SERVICE_WORKER_BLOCK_NETWORK_LOADS";
    public static final String SERVICE_WORKER_CACHE_MODE = "SERVICE_WORKER_CACHE_MODE";
    public static final String SERVICE_WORKER_CONTENT_ACCESS = "SERVICE_WORKER_CONTENT_ACCESS";
    public static final String SERVICE_WORKER_FILE_ACCESS = "SERVICE_WORKER_FILE_ACCESS";
    public static final String SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST = "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST";
    public static final String SET_SUPPORT_LIBRARY_VERSION = "SET_SUPPORT_LIBRARY_VERSION";
    public static final String SHOULD_OVERRIDE_WITH_REDIRECTS = "SHOULD_OVERRIDE_WITH_REDIRECTS";
    public static final String START_SAFE_BROWSING = "START_SAFE_BROWSING";
    public static final String SUPPRESS_ERROR_PAGE = "SUPPRESS_ERROR_PAGE";
    public static final String TRACING_CONTROLLER_BASIC_USAGE = "TRACING_CONTROLLER_BASIC_USAGE";
    public static final String VISUAL_STATE_CALLBACK = "VISUAL_STATE_CALLBACK";
    public static final String WEB_AUTHENTICATION = "WEB_AUTHENTICATION";
    public static final String WEB_MESSAGE_CALLBACK_ON_MESSAGE = "WEB_MESSAGE_CALLBACK_ON_MESSAGE";
    public static final String WEB_MESSAGE_GET_MESSAGE_PAYLOAD = "WEB_MESSAGE_GET_MESSAGE_PAYLOAD";
    public static final String WEB_MESSAGE_LISTENER = "WEB_MESSAGE_LISTENER";
    public static final String WEB_MESSAGE_PORT_CLOSE = "WEB_MESSAGE_PORT_CLOSE";
    public static final String WEB_MESSAGE_PORT_POST_MESSAGE = "WEB_MESSAGE_PORT_POST_MESSAGE";
    public static final String WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK = "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK";
    public static final String WEB_RESOURCE_ERROR_GET_CODE = "WEB_RESOURCE_ERROR_GET_CODE";
    public static final String WEB_RESOURCE_ERROR_GET_DESCRIPTION = "WEB_RESOURCE_ERROR_GET_DESCRIPTION";
    public static final String WEB_RESOURCE_REQUEST_IS_REDIRECT = "WEB_RESOURCE_REQUEST_IS_REDIRECT";
    public static final String WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE = "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE";
    public static final String WEB_VIEW_RENDERER_TERMINATE = "WEB_VIEW_RENDERER_TERMINATE";

    private Features() {
    }
}
