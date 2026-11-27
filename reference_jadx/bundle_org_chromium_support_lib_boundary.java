
// ===== FILE: org/chromium/support_lib_boundary/DropDataContentProviderBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import android.content.ContentProvider;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;

/* loaded from: classes2.dex */
public interface DropDataContentProviderBoundaryInterface {
    Uri cache(byte[] bArr, String str, String str2);

    Bundle call(String str, String str2, Bundle bundle);

    String[] getStreamTypes(Uri uri, String str);

    String getType(Uri uri);

    boolean onCreate();

    void onDragEnd(boolean z);

    ParcelFileDescriptor openFile(ContentProvider contentProvider, Uri uri) throws FileNotFoundException;

    Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    void setClearCachedDataIntervalMs(int i);
}

// ===== FILE: org/chromium/support_lib_boundary/FeatureFlagHolderBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

/* loaded from: classes2.dex */
public interface FeatureFlagHolderBoundaryInterface {
    String[] getSupportedFeatures();
}

// ===== FILE: org/chromium/support_lib_boundary/IsomorphicObjectBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public interface IsomorphicObjectBoundaryInterface {
    Object getOrCreatePeer(Callable<Object> callable);
}

// ===== FILE: org/chromium/support_lib_boundary/JsReplyProxyBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

/* loaded from: classes2.dex */
public interface JsReplyProxyBoundaryInterface extends IsomorphicObjectBoundaryInterface {
    void postMessage(String str);
}

// ===== FILE: org/chromium/support_lib_boundary/ProcessGlobalConfigConstants.java =====
package org.chromium.support_lib_boundary;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes2.dex */
public final class ProcessGlobalConfigConstants {
    public static final String DATA_DIRECTORY_SUFFIX = "DATA_DIRECTORY_SUFFIX";

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProcessGlobalConfigMapKey {
    }

    private ProcessGlobalConfigConstants() {
    }
}

// ===== FILE: org/chromium/support_lib_boundary/ProxyControllerBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public interface ProxyControllerBoundaryInterface {
    void clearProxyOverride(Runnable runnable, Executor executor);

    void setProxyOverride(String[][] strArr, String[] strArr2, Runnable runnable, Executor executor);

    void setProxyOverride(String[][] strArr, String[] strArr2, Runnable runnable, Executor executor, boolean z);
}

// ===== FILE: org/chromium/support_lib_boundary/SafeBrowsingResponseBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

/* loaded from: classes2.dex */
public interface SafeBrowsingResponseBoundaryInterface {
    void backToSafety(boolean z);

    void proceed(boolean z);

    void showInterstitial(boolean z);
}

// ===== FILE: org/chromium/support_lib_boundary/ScriptHandlerBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

/* loaded from: classes2.dex */
public interface ScriptHandlerBoundaryInterface {
    void remove();
}

// ===== FILE: org/chromium/support_lib_boundary/ServiceWorkerClientBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

/* loaded from: classes2.dex */
public interface ServiceWorkerClientBoundaryInterface extends FeatureFlagHolderBoundaryInterface {
    WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest);
}

// ===== FILE: org/chromium/support_lib_boundary/ServiceWorkerControllerBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import java.lang.reflect.InvocationHandler;

/* loaded from: classes2.dex */
public interface ServiceWorkerControllerBoundaryInterface {
    InvocationHandler getServiceWorkerWebSettings();

    void setServiceWorkerClient(InvocationHandler invocationHandler);
}

// ===== FILE: org/chromium/support_lib_boundary/ServiceWorkerWebSettingsBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import java.util.Set;

/* loaded from: classes2.dex */
public interface ServiceWorkerWebSettingsBoundaryInterface {
    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getBlockNetworkLoads();

    int getCacheMode();

    Set<String> getRequestedWithHeaderOriginAllowList();

    void setAllowContentAccess(boolean z);

    void setAllowFileAccess(boolean z);

    void setBlockNetworkLoads(boolean z);

    void setCacheMode(int i);

    void setRequestedWithHeaderOriginAllowList(Set<String> set);
}

// ===== FILE: org/chromium/support_lib_boundary/StaticsBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import android.content.Context;
import android.net.Uri;
import android.webkit.ValueCallback;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public interface StaticsBoundaryInterface {
    Uri getSafeBrowsingPrivacyPolicyUrl();

    String getVariationsHeader();

    void initSafeBrowsing(Context context, ValueCallback<Boolean> valueCallback);

    boolean isMultiProcessEnabled();

    void setSafeBrowsingAllowlist(Set<String> set, ValueCallback<Boolean> valueCallback);

    void setSafeBrowsingWhitelist(List<String> list, ValueCallback<Boolean> valueCallback);
}

// ===== FILE: org/chromium/support_lib_boundary/TracingControllerBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import java.io.OutputStream;
import java.util.Collection;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public interface TracingControllerBoundaryInterface {
    boolean isTracing();

    void start(int i, Collection<String> collection, int i2) throws IllegalStateException, IllegalArgumentException;

    boolean stop(OutputStream outputStream, Executor executor);
}

// ===== FILE: org/chromium/support_lib_boundary/VisualStateCallbackBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

/* loaded from: classes2.dex */
public interface VisualStateCallbackBoundaryInterface {
    void onComplete(long j);
}

// ===== FILE: org/chromium/support_lib_boundary/WebAuthnCallbackBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import android.content.Intent;

/* loaded from: classes2.dex */
public interface WebAuthnCallbackBoundaryInterface {
    void onResult(int i, Intent intent);
}

// ===== FILE: org/chromium/support_lib_boundary/WebMessageBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import java.lang.reflect.InvocationHandler;

/* loaded from: classes2.dex */
public interface WebMessageBoundaryInterface extends FeatureFlagHolderBoundaryInterface {
    @Deprecated
    String getData();

    InvocationHandler getMessagePayload();

    InvocationHandler[] getPorts();
}

// ===== FILE: org/chromium/support_lib_boundary/WebMessageCallbackBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import java.lang.reflect.InvocationHandler;

/* loaded from: classes2.dex */
public interface WebMessageCallbackBoundaryInterface extends FeatureFlagHolderBoundaryInterface {
    void onMessage(InvocationHandler invocationHandler, InvocationHandler invocationHandler2);
}

// ===== FILE: org/chromium/support_lib_boundary/WebMessageListenerBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import android.net.Uri;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;

/* loaded from: classes2.dex */
public interface WebMessageListenerBoundaryInterface extends FeatureFlagHolderBoundaryInterface {
    void onPostMessage(WebView webView, InvocationHandler invocationHandler, Uri uri, boolean z, InvocationHandler invocationHandler2);
}

// ===== FILE: org/chromium/support_lib_boundary/WebMessagePayloadBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public interface WebMessagePayloadBoundaryInterface extends FeatureFlagHolderBoundaryInterface {

    @Retention(RetentionPolicy.SOURCE)
    public @interface WebMessagePayloadType {
        public static final int TYPE_ARRAY_BUFFER = 1;
        public static final int TYPE_STRING = 0;
    }

    byte[] getAsArrayBuffer();

    String getAsString();

    int getType();
}

// ===== FILE: org/chromium/support_lib_boundary/WebMessagePortBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import android.os.Handler;
import java.lang.reflect.InvocationHandler;

/* loaded from: classes2.dex */
public interface WebMessagePortBoundaryInterface {
    void close();

    void postMessage(InvocationHandler invocationHandler);

    void setWebMessageCallback(InvocationHandler invocationHandler);

    void setWebMessageCallback(InvocationHandler invocationHandler, Handler handler);
}

// ===== FILE: org/chromium/support_lib_boundary/WebResourceErrorBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

/* loaded from: classes2.dex */
public interface WebResourceErrorBoundaryInterface {
    CharSequence getDescription();

    int getErrorCode();
}

// ===== FILE: org/chromium/support_lib_boundary/WebResourceRequestBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

/* loaded from: classes2.dex */
public interface WebResourceRequestBoundaryInterface {
    boolean isRedirect();
}

// ===== FILE: org/chromium/support_lib_boundary/WebSettingsBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

/* loaded from: classes2.dex */
public interface WebSettingsBoundaryInterface {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ForceDarkBehavior {
        public static final int FORCE_DARK_ONLY = 0;
        public static final int MEDIA_QUERY_ONLY = 1;
        public static final int PREFER_MEDIA_QUERY_OVER_FORCE_DARK = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface WebAuthnSupport {
        public static final int APP = 1;
        public static final int BROWSER = 2;
        public static final int NONE = 0;
    }

    int getDisabledActionModeMenuItems();

    boolean getEnterpriseAuthenticationAppLinkPolicyEnabled();

    int getForceDark();

    int getForceDarkBehavior();

    boolean getOffscreenPreRaster();

    Set<String> getRequestedWithHeaderOriginAllowList();

    boolean getSafeBrowsingEnabled();

    int getWebAuthnSupport();

    boolean getWillSuppressErrorPage();

    boolean isAlgorithmicDarkeningAllowed();

    void setAlgorithmicDarkeningAllowed(boolean z);

    void setDisabledActionModeMenuItems(int i);

    void setEnterpriseAuthenticationAppLinkPolicyEnabled(boolean z);

    void setForceDark(int i);

    void setForceDarkBehavior(int i);

    void setOffscreenPreRaster(boolean z);

    void setRequestedWithHeaderOriginAllowList(Set<String> set);

    void setSafeBrowsingEnabled(boolean z);

    void setWebAuthnSupport(int i);

    void setWillSuppressErrorPage(boolean z);
}

// ===== FILE: org/chromium/support_lib_boundary/WebViewClientBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import android.app.PendingIntent;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;

/* loaded from: classes2.dex */
public interface WebViewClientBoundaryInterface extends FeatureFlagHolderBoundaryInterface {
    void onPageCommitVisible(WebView webView, String str);

    void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, InvocationHandler invocationHandler);

    void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse);

    void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, InvocationHandler invocationHandler);

    boolean onWebAuthnIntent(WebView webView, PendingIntent pendingIntent, InvocationHandler invocationHandler);

    boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest);
}

// ===== FILE: org/chromium/support_lib_boundary/WebViewCookieManagerBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import java.util.List;

/* loaded from: classes2.dex */
public interface WebViewCookieManagerBoundaryInterface {
    List<String> getCookieInfo(String str);
}

// ===== FILE: org/chromium/support_lib_boundary/WebViewProviderBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import android.net.Uri;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import java.lang.reflect.InvocationHandler;

/* loaded from: classes2.dex */
public interface WebViewProviderBoundaryInterface {
    InvocationHandler addDocumentStartJavaScript(String str, String[] strArr);

    void addWebMessageListener(String str, String[] strArr, InvocationHandler invocationHandler);

    InvocationHandler[] createWebMessageChannel();

    WebChromeClient getWebChromeClient();

    WebViewClient getWebViewClient();

    InvocationHandler getWebViewRenderer();

    InvocationHandler getWebViewRendererClient();

    void insertVisualStateCallback(long j, InvocationHandler invocationHandler);

    void postMessageToMainFrame(InvocationHandler invocationHandler, Uri uri);

    void removeWebMessageListener(String str);

    void setWebViewRendererClient(InvocationHandler invocationHandler);
}

// ===== FILE: org/chromium/support_lib_boundary/WebViewProviderFactoryBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;

/* loaded from: classes2.dex */
public interface WebViewProviderFactoryBoundaryInterface {
    InvocationHandler createWebView(WebView webView);

    InvocationHandler getDropDataProvider();

    InvocationHandler getProxyController();

    InvocationHandler getServiceWorkerController();

    InvocationHandler getStatics();

    String[] getSupportedFeatures();

    InvocationHandler getTracingController();

    InvocationHandler getWebkitToCompatConverter();

    void setSupportLibraryVersion(String str);
}

// ===== FILE: org/chromium/support_lib_boundary/WebViewRendererBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

/* loaded from: classes2.dex */
public interface WebViewRendererBoundaryInterface extends IsomorphicObjectBoundaryInterface {
    boolean terminate();
}

// ===== FILE: org/chromium/support_lib_boundary/WebViewRendererClientBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;

/* loaded from: classes2.dex */
public interface WebViewRendererClientBoundaryInterface extends FeatureFlagHolderBoundaryInterface {
    void onRendererResponsive(WebView webView, InvocationHandler invocationHandler);

    void onRendererUnresponsive(WebView webView, InvocationHandler invocationHandler);
}

// ===== FILE: org/chromium/support_lib_boundary/WebkitToCompatConverterBoundaryInterface.java =====
package org.chromium.support_lib_boundary;

import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import java.lang.reflect.InvocationHandler;

/* loaded from: classes2.dex */
public interface WebkitToCompatConverterBoundaryInterface {
    InvocationHandler convertCookieManager(Object obj);

    Object convertSafeBrowsingResponse(InvocationHandler invocationHandler);

    InvocationHandler convertSafeBrowsingResponse(Object obj);

    Object convertServiceWorkerSettings(InvocationHandler invocationHandler);

    InvocationHandler convertServiceWorkerSettings(Object obj);

    InvocationHandler convertSettings(WebSettings webSettings);

    Object convertWebMessagePort(InvocationHandler invocationHandler);

    InvocationHandler convertWebMessagePort(Object obj);

    Object convertWebResourceError(InvocationHandler invocationHandler);

    InvocationHandler convertWebResourceError(Object obj);

    InvocationHandler convertWebResourceRequest(WebResourceRequest webResourceRequest);
}
