
// ===== FILE: com/unity3d/services/core/request/CancelableThreadPoolExecutor.java =====
package com.unity3d.services.core.request;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class CancelableThreadPoolExecutor extends ThreadPoolExecutor {
    private final List<Runnable> _activeRunnable;

    public CancelableThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        super(i, i2, j, timeUnit, linkedBlockingQueue);
        this._activeRunnable = new LinkedList();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected synchronized void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this._activeRunnable.add(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected synchronized void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        this._activeRunnable.remove(runnable);
    }

    public synchronized void cancel() {
        for (Runnable runnable : this._activeRunnable) {
            if (runnable instanceof WebRequestRunnable) {
                ((WebRequestRunnable) runnable).setCancelStatus(true);
            }
        }
    }
}

// ===== FILE: com/unity3d/services/core/request/IResolveHostListener.java =====
package com.unity3d.services.core.request;

/* loaded from: classes.dex */
public interface IResolveHostListener {
    void onFailed(String str, ResolveHostError resolveHostError, String str2);

    void onResolve(String str, String str2);
}

// ===== FILE: com/unity3d/services/core/request/IWebRequestListener.java =====
package com.unity3d.services.core.request;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface IWebRequestListener {
    void onComplete(String str, String str2, int i, Map<String, List<String>> map);

    void onFailed(String str, String str2);
}

// ===== FILE: com/unity3d/services/core/request/IWebRequestProgressListener.java =====
package com.unity3d.services.core.request;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface IWebRequestProgressListener {
    void onRequestProgress(String str, long j, long j2);

    void onRequestStart(String str, long j, int i, Map<String, List<String>> map);
}

// ===== FILE: com/unity3d/services/core/request/NetworkIOException.java =====
package com.unity3d.services.core.request;

/* loaded from: classes.dex */
public class NetworkIOException extends Exception {
    public NetworkIOException(String str) {
        super(str);
    }
}

// ===== FILE: com/unity3d/services/core/request/ResolveHostError.java =====
package com.unity3d.services.core.request;

/* loaded from: classes.dex */
public enum ResolveHostError {
    INVALID_HOST,
    UNKNOWN_HOST,
    UNEXPECTED_EXCEPTION,
    TIMEOUT
}

// ===== FILE: com/unity3d/services/core/request/ResolveHostEvent.java =====
package com.unity3d.services.core.request;

/* loaded from: classes.dex */
public enum ResolveHostEvent {
    COMPLETE,
    FAILED
}

// ===== FILE: com/unity3d/services/core/request/WebRequest.java =====
package com.unity3d.services.core.request;

import com.unity3d.services.core.log.DeviceLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes.dex */
public class WebRequest {
    private ByteArrayOutputStream _baos;
    private byte[] _body;
    private boolean _canceled;
    private int _connectTimeout;
    private long _contentLength;
    private Map<String, List<String>> _headers;
    private IWebRequestProgressListener _progressListener;
    private int _readTimeout;
    private String _requestType;
    private int _responseCode;
    private Map<String, List<String>> _responseHeaders;
    private URL _url;

    public enum RequestType {
        POST,
        GET,
        HEAD
    }

    public WebRequest(String str, String str2) throws MalformedURLException {
        this(str, str2, null);
    }

    public WebRequest(String str, String str2, Map<String, List<String>> map) throws MalformedURLException {
        this(str, str2, map, 30000, 30000);
    }

    public WebRequest(String str, String str2, Map<String, List<String>> map, int i, int i2) throws MalformedURLException {
        this._responseCode = -1;
        this._contentLength = -1L;
        this._canceled = false;
        this._url = new URL(str);
        this._requestType = str2;
        this._headers = map;
        this._connectTimeout = i;
        this._readTimeout = i2;
    }

    public void cancel() {
        this._canceled = true;
    }

    public boolean isCanceled() {
        return this._canceled;
    }

    public URL getUrl() {
        return this._url;
    }

    public String getRequestType() {
        return this._requestType;
    }

    public byte[] getBody() {
        return this._body;
    }

    public void setBody(String str) {
        this._body = str.getBytes(StandardCharsets.UTF_8);
    }

    public void setBody(byte[] bArr) {
        this._body = bArr;
    }

    public String getQuery() {
        URL url = this._url;
        if (url != null) {
            return url.getQuery();
        }
        return null;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this._responseHeaders;
    }

    public Map<String, List<String>> getHeaders() {
        return this._headers;
    }

    public int getResponseCode() {
        return this._responseCode;
    }

    public long getContentLength() {
        return this._contentLength;
    }

    public int getConnectTimeout() {
        return this._connectTimeout;
    }

    public void setConnectTimeout(int i) {
        this._connectTimeout = i;
    }

    public int getReadTimeout() {
        return this._readTimeout;
    }

    public void setReadTimeout(int i) {
        this._readTimeout = i;
    }

    public void setProgressListener(IWebRequestProgressListener iWebRequestProgressListener) {
        this._progressListener = iWebRequestProgressListener;
    }

    public long makeStreamRequest(OutputStream outputStream) throws Exception {
        InputStream errorStream;
        HttpURLConnection httpUrlConnectionWithHeaders = getHttpUrlConnectionWithHeaders();
        httpUrlConnectionWithHeaders.setDoInput(true);
        if (getRequestType().equals(RequestType.POST.name())) {
            httpUrlConnectionWithHeaders.setDoOutput(true);
            OutputStream outputStream2 = null;
            try {
                try {
                    outputStream2 = httpUrlConnectionWithHeaders.getOutputStream();
                    if (getBody() == null) {
                        String query = getQuery();
                        if (query != null) {
                            outputStream2.write(query.getBytes(StandardCharsets.UTF_8));
                        }
                    } else {
                        outputStream2.write(getBody());
                    }
                    outputStream2.flush();
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e) {
                            DeviceLog.exception("Error closing writer", e);
                        }
                    }
                } catch (IOException e2) {
                    DeviceLog.exception("Error while writing POST params", e2);
                    throw new NetworkIOException("Error writing POST params: " + e2.getMessage());
                }
            } finally {
            }
        }
        try {
            this._responseCode = httpUrlConnectionWithHeaders.getResponseCode();
            long contentLength = httpUrlConnectionWithHeaders.getContentLength();
            this._contentLength = contentLength;
            if (contentLength == -1) {
                this._contentLength = httpUrlConnectionWithHeaders.getHeaderFieldInt("X-OrigLength", -1);
            }
            ByteArrayOutputStream byteArrayOutputStream = this._baos;
            long j = 0;
            OutputStream outputStream3 = outputStream;
            if (byteArrayOutputStream != null && byteArrayOutputStream == outputStream3 && this._contentLength > 0) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream((int) this._contentLength);
                this._baos = byteArrayOutputStream2;
                outputStream3 = byteArrayOutputStream2;
            }
            if (httpUrlConnectionWithHeaders.getHeaderFields() != null) {
                this._responseHeaders = httpUrlConnectionWithHeaders.getHeaderFields();
            }
            try {
                errorStream = httpUrlConnectionWithHeaders.getInputStream();
            } catch (IOException e3) {
                errorStream = httpUrlConnectionWithHeaders.getErrorStream();
                if (errorStream == null) {
                    throw new NetworkIOException("Can't open error stream: " + e3.getMessage());
                }
            }
            IWebRequestProgressListener iWebRequestProgressListener = this._progressListener;
            if (iWebRequestProgressListener != null) {
                iWebRequestProgressListener.onRequestStart(getUrl().toString(), this._contentLength, this._responseCode, this._responseHeaders);
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(errorStream);
            byte[] bArr = new byte[4096];
            int i = 0;
            while (!isCanceled() && i != -1) {
                try {
                    i = bufferedInputStream.read(bArr);
                    if (i > 0) {
                        outputStream3.write(bArr, 0, i);
                        j += i;
                        IWebRequestProgressListener iWebRequestProgressListener2 = this._progressListener;
                        if (iWebRequestProgressListener2 != null) {
                            iWebRequestProgressListener2.onRequestProgress(getUrl().toString(), j, this._contentLength);
                        }
                    }
                } catch (IOException e4) {
                    throw new NetworkIOException("Network exception: " + e4.getMessage());
                } catch (Exception e5) {
                    throw new Exception("Unknown Exception: " + e5.getMessage());
                }
            }
            httpUrlConnectionWithHeaders.disconnect();
            outputStream3.flush();
            return j;
        } catch (IOException | RuntimeException e6) {
            throw new NetworkIOException("Response code: " + e6.getMessage());
        }
    }

    public String makeRequest() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this._baos = byteArrayOutputStream;
        makeStreamRequest(byteArrayOutputStream);
        return this._baos.toString("UTF-8");
    }

    private HttpURLConnection getHttpUrlConnectionWithHeaders() throws NetworkIOException, IllegalArgumentException {
        HttpURLConnection httpURLConnection;
        if (getUrl().toString().startsWith("https://")) {
            try {
                httpURLConnection = (HttpsURLConnection) getUrl().openConnection();
            } catch (IOException e) {
                throw new NetworkIOException("Open HTTPS connection: " + e.getMessage());
            }
        } else if (getUrl().toString().startsWith("http://")) {
            try {
                httpURLConnection = (HttpURLConnection) getUrl().openConnection();
            } catch (IOException e2) {
                throw new NetworkIOException("Open HTTP connection: " + e2.getMessage());
            }
        } else {
            throw new IllegalArgumentException("Invalid url-protocol in url: " + getUrl().toString());
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(getConnectTimeout());
        httpURLConnection.setReadTimeout(getReadTimeout());
        try {
            httpURLConnection.setRequestMethod(getRequestType());
            if (getHeaders() != null && getHeaders().size() > 0) {
                for (String str : getHeaders().keySet()) {
                    for (String str2 : getHeaders().get(str)) {
                        DeviceLog.debug("Setting header: " + str + "=" + str2);
                        httpURLConnection.setRequestProperty(str, str2);
                    }
                }
            }
            return httpURLConnection;
        } catch (ProtocolException e3) {
            throw new NetworkIOException("Set Request Method: " + getRequestType() + ", " + e3.getMessage());
        }
    }
}

// ===== FILE: com/unity3d/services/core/request/WebRequestError.java =====
package com.unity3d.services.core.request;

/* loaded from: classes.dex */
public enum WebRequestError {
    MAPPING_HEADERS_FAILED
}

// ===== FILE: com/unity3d/services/core/request/WebRequestEvent.java =====
package com.unity3d.services.core.request;

/* loaded from: classes.dex */
public enum WebRequestEvent {
    COMPLETE,
    FAILED
}

// ===== FILE: com/unity3d/services/core/request/WebRequestRunnable.java =====
package com.unity3d.services.core.request;

import android.os.Bundle;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class WebRequestRunnable implements Runnable {
    private final String _body;
    private boolean _canceled = false;
    private final int _connectTimeout;
    private WebRequest _currentRequest;
    private final Map<String, List<String>> _headers;
    private final IWebRequestListener _listener;
    private final int _readTimeout;
    private final String _type;
    private final String _url;

    public WebRequestRunnable(String str, String str2, String str3, int i, int i2, Map<String, List<String>> map, IWebRequestListener iWebRequestListener) {
        this._url = str;
        this._type = str2;
        this._body = str3;
        this._connectTimeout = i;
        this._readTimeout = i2;
        this._headers = map;
        this._listener = iWebRequestListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        DeviceLog.debug("Handling request message: " + this._url + " type=" + this._type);
        try {
            makeRequest(this._url, this._type, this._headers, this._body, this._connectTimeout, this._readTimeout);
        } catch (Error unused) {
            DeviceLog.error("Out of memory error while doing web request.");
            ((SDKMetricsSender) Utilities.getService(SDKMetricsSender.class)).sendEvent("native_webview_oom", null, new HashMap<String, String>() { // from class: com.unity3d.services.core.request.WebRequestRunnable.1
                {
                    put("src", "WebRequestRunnable");
                    put("url", WebRequestRunnable.this._url);
                    put("type", WebRequestRunnable.this._type);
                }
            });
            onFailed("Out of memory error while doing web request.");
        } catch (MalformedURLException e) {
            DeviceLog.exception("Malformed URL", e);
            onFailed("Malformed URL");
        }
    }

    public void setCancelStatus(boolean z) {
        WebRequest webRequest;
        this._canceled = z;
        if (!z || (webRequest = this._currentRequest) == null) {
            return;
        }
        webRequest.cancel();
    }

    private void makeRequest(String str, String str2, Map<String, List<String>> map, String str3, int i, int i2) throws MalformedURLException {
        if (this._canceled) {
            return;
        }
        WebRequest webRequest = new WebRequest(str, str2, map, i, i2);
        this._currentRequest = webRequest;
        if (str3 != null) {
            webRequest.setBody(str3);
        }
        try {
            String makeRequest = this._currentRequest.makeRequest();
            if (this._currentRequest.isCanceled()) {
                return;
            }
            Bundle bundle = new Bundle();
            Map<String, List<String>> responseHeaders = this._currentRequest.getResponseHeaders();
            if (responseHeaders != null) {
                for (String str4 : responseHeaders.keySet()) {
                    if (str4 != null && !str4.contentEquals("null")) {
                        String[] strArr = new String[responseHeaders.get(str4).size()];
                        for (int i3 = 0; i3 < responseHeaders.get(str4).size(); i3++) {
                            strArr[i3] = responseHeaders.get(str4).get(i3);
                        }
                        bundle.putStringArray(str4, strArr);
                    }
                }
            }
            if (this._currentRequest.isCanceled()) {
                return;
            }
            onSucceed(makeRequest, this._currentRequest.getResponseCode(), getResponseHeaders(bundle));
        } catch (Exception e) {
            DeviceLog.exception("Error completing request", e);
            onFailed(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    private void onSucceed(String str, int i, Map<String, List<String>> map) {
        this._listener.onComplete(this._url, str, i, map);
    }

    private void onFailed(String str) {
        this._listener.onFailed(this._url, str);
    }

    private Map<String, List<String>> getResponseHeaders(Bundle bundle) {
        if (bundle.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            String[] stringArray = bundle.getStringArray(str);
            if (stringArray != null) {
                hashMap.put(str, new ArrayList(Arrays.asList(stringArray)));
            }
        }
        return hashMap;
    }
}

// ===== FILE: com/unity3d/services/core/request/WebRequestThread.java =====
package com.unity3d.services.core.request;

import android.os.ConditionVariable;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.request.WebRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class WebRequestThread {
    private static int _corePoolSize = 1;
    private static long _keepAliveTime = 1000;
    private static int _maximumPoolSize = 1;
    private static CancelableThreadPoolExecutor _pool;
    private static LinkedBlockingQueue<Runnable> _queue;
    private static boolean _ready;
    private static final Object _readyLock = new Object();

    private static synchronized void init() {
        synchronized (WebRequestThread.class) {
            _queue = new LinkedBlockingQueue<>();
            CancelableThreadPoolExecutor cancelableThreadPoolExecutor = new CancelableThreadPoolExecutor(_corePoolSize, _maximumPoolSize, _keepAliveTime, TimeUnit.MILLISECONDS, _queue);
            _pool = cancelableThreadPoolExecutor;
            cancelableThreadPoolExecutor.prestartAllCoreThreads();
            _queue.add(new Runnable() { // from class: com.unity3d.services.core.request.WebRequestThread.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean unused = WebRequestThread._ready = true;
                    synchronized (WebRequestThread._readyLock) {
                        WebRequestThread._readyLock.notifyAll();
                    }
                }
            });
            while (!_ready) {
                try {
                    Object obj = _readyLock;
                    synchronized (obj) {
                        obj.wait();
                    }
                } catch (InterruptedException unused) {
                    DeviceLog.debug("Couldn't synchronize thread");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public static synchronized void reset() {
        synchronized (WebRequestThread.class) {
            cancel();
            CancelableThreadPoolExecutor cancelableThreadPoolExecutor = _pool;
            if (cancelableThreadPoolExecutor != null) {
                cancelableThreadPoolExecutor.shutdown();
                try {
                    _pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                _queue.clear();
                _pool = null;
                _queue = null;
                _ready = false;
            }
        }
    }

    public static synchronized void cancel() {
        synchronized (WebRequestThread.class) {
            CancelableThreadPoolExecutor cancelableThreadPoolExecutor = _pool;
            if (cancelableThreadPoolExecutor != null) {
                cancelableThreadPoolExecutor.cancel();
                Iterator<Runnable> it = _queue.iterator();
                while (it.hasNext()) {
                    Runnable next = it.next();
                    if (next instanceof WebRequestRunnable) {
                        ((WebRequestRunnable) next).setCancelStatus(true);
                    }
                }
                _queue.clear();
                _pool.purge();
            }
        }
    }

    public static synchronized void request(String str, WebRequest.RequestType requestType, Map<String, List<String>> map, Integer num, Integer num2, IWebRequestListener iWebRequestListener) {
        synchronized (WebRequestThread.class) {
            request(str, requestType, map, null, num, num2, iWebRequestListener);
        }
    }

    public static synchronized void request(String str, WebRequest.RequestType requestType, Map<String, List<String>> map, String str2, Integer num, Integer num2, IWebRequestListener iWebRequestListener) {
        synchronized (WebRequestThread.class) {
            if (!_ready) {
                init();
            }
            if (str != null && str.length() >= 3) {
                _queue.add(new WebRequestRunnable(str, requestType.name(), str2, num.intValue(), num2.intValue(), map, iWebRequestListener));
                return;
            }
            iWebRequestListener.onFailed(str, "Request is NULL or too short");
        }
    }

    public static synchronized void setConcurrentRequestCount(int i) {
        synchronized (WebRequestThread.class) {
            _corePoolSize = i;
            _maximumPoolSize = i;
            CancelableThreadPoolExecutor cancelableThreadPoolExecutor = _pool;
            if (cancelableThreadPoolExecutor != null) {
                cancelableThreadPoolExecutor.setCorePoolSize(i);
                _pool.setMaximumPoolSize(_maximumPoolSize);
            }
        }
    }

    public static synchronized void setMaximumPoolSize(int i) {
        synchronized (WebRequestThread.class) {
            _maximumPoolSize = i;
            CancelableThreadPoolExecutor cancelableThreadPoolExecutor = _pool;
            if (cancelableThreadPoolExecutor != null) {
                cancelableThreadPoolExecutor.setMaximumPoolSize(i);
            }
        }
    }

    public static synchronized void setKeepAliveTime(long j) {
        synchronized (WebRequestThread.class) {
            _keepAliveTime = j;
            CancelableThreadPoolExecutor cancelableThreadPoolExecutor = _pool;
            if (cancelableThreadPoolExecutor != null) {
                cancelableThreadPoolExecutor.setKeepAliveTime(j, TimeUnit.MILLISECONDS);
            }
        }
    }

    public static synchronized boolean resolve(final String str, final IResolveHostListener iResolveHostListener) {
        synchronized (WebRequestThread.class) {
            if (str != null) {
                if (str.length() >= 3) {
                    new Thread(new Runnable() { // from class: com.unity3d.services.core.request.WebRequestThread.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Thread thread;
                            Exception e;
                            final ConditionVariable conditionVariable = new ConditionVariable();
                            try {
                                thread = new Thread(new Runnable() { // from class: com.unity3d.services.core.request.WebRequestThread.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            iResolveHostListener.onResolve(str, InetAddress.getByName(str).getHostAddress());
                                        } catch (UnknownHostException e2) {
                                            DeviceLog.exception("Unknown host", e2);
                                            iResolveHostListener.onFailed(str, ResolveHostError.UNKNOWN_HOST, e2.getMessage());
                                        }
                                        conditionVariable.open();
                                    }
                                });
                            } catch (Exception e2) {
                                thread = null;
                                e = e2;
                            }
                            try {
                                thread.start();
                            } catch (Exception e3) {
                                e = e3;
                                DeviceLog.exception("Exception while resolving host", e);
                                iResolveHostListener.onFailed(str, ResolveHostError.UNEXPECTED_EXCEPTION, e.getMessage());
                                if (conditionVariable.block(20000L)) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            if (conditionVariable.block(20000L) || thread == null) {
                                return;
                            }
                            thread.interrupt();
                            iResolveHostListener.onFailed(str, ResolveHostError.TIMEOUT, AndroidInitializeBoldSDK.MSG_TIMEOUT);
                        }
                    }).start();
                    return true;
                }
            }
            iResolveHostListener.onFailed(str, ResolveHostError.INVALID_HOST, "Host is NULL");
            return false;
        }
    }
}
