// Package bundle: com.unity3d.services.core.request (17 classes)

// ============================================================
// CLASS: com.unity3d.services.core.request.CancelableThreadPoolExecutor
// ============================================================
package com.unity3d.services.core.request;

public class CancelableThreadPoolExecutor extends ThreadPoolExecutor {
    private final List _activeRunnable;

    public CancelableThreadPoolExecutor(int p0, int p1, long p2, TimeUnit p3, LinkedBlockingQueue p4) {
        new ThreadPoolExecutor(p0, p1, p2, v4, p3, p4);
        new LinkedList();
        _activeRunnable = new LinkedList(..);
        return;
    }

    protected void afterExecute(Runnable p0, Throwable p1) {
        ThreadPoolExecutor.afterExecute(p0, p1);
        _activeRunnable.remove(p0);
        return;
        throw p0;
    }

    protected void beforeExecute(Thread p0, Runnable p1) {
        ThreadPoolExecutor.beforeExecute(p0, p1);
        _activeRunnable.add(p1);
        return;
        throw _activeRunnable;
    }

    public void cancel() {
        _activeRunnable.iterator();
      L_7:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_1e;
        List.iterator(..).next();
        if (if-eqz(v2)) goto L_7;
        Iterator.next(..).setCancelStatus(1);
      L_1e:
        return;
        throw List.iterator(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.IResolveHostListener
// ============================================================
package com.unity3d.services.core.request;

public abstract class IResolveHostListener {
    public abstract void onFailed(String p0, ResolveHostError p1, String p2) {
        // native or abstract
    }

    public abstract void onResolve(String p0, String p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.IWebRequestListener
// ============================================================
package com.unity3d.services.core.request;

public abstract class IWebRequestListener {
    public abstract void onComplete(String p0, String p1, int p2, Map p3) {
        // native or abstract
    }

    public abstract void onFailed(String p0, String p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.IWebRequestProgressListener
// ============================================================
package com.unity3d.services.core.request;

public abstract class IWebRequestProgressListener {
    public abstract void onRequestProgress(String p0, long p1, long p2) {
        // native or abstract
    }

    public abstract void onRequestStart(String p0, long p1, int p2, Map p3) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.NetworkIOException
// ============================================================
package com.unity3d.services.core.request;

public class NetworkIOException extends Exception {
    public NetworkIOException(String p0) {
        new Exception(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.ResolveHostError
// ============================================================
package com.unity3d.services.core.request;

public final class ResolveHostError extends Enum {
    private static final ResolveHostError[] $VALUES;
    public static final ResolveHostError INVALID_HOST;
    public static final ResolveHostError TIMEOUT;
    public static final ResolveHostError UNEXPECTED_EXCEPTION;
    public static final ResolveHostError UNKNOWN_HOST;

    private static ResolveHostError[] $values() {
        return 4;
    }

    static <clinit>() {
        new ResolveHostError("INVALID_HOST", 0);
        INVALID_HOST = new ResolveHostError(..);
        new ResolveHostError("UNKNOWN_HOST", 1);
        UNKNOWN_HOST = new ResolveHostError(..);
        new ResolveHostError("UNEXPECTED_EXCEPTION", 2);
        UNEXPECTED_EXCEPTION = new ResolveHostError(..);
        new ResolveHostError("TIMEOUT", 3);
        TIMEOUT = new ResolveHostError(..);
        ResolveHostError.$values();
        $VALUES = ResolveHostError.$values(..);
        return;
    }

    private ResolveHostError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static ResolveHostError valueOf(String p0) {
        Enum.valueOf(ResolveHostError.class, p0);
        return Enum.valueOf(..);
    }

    public static ResolveHostError[] values() {
        ResolveHostError.$VALUES.clone();
        return ResolveHostError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.ResolveHostEvent
// ============================================================
package com.unity3d.services.core.request;

public final class ResolveHostEvent extends Enum {
    private static final ResolveHostEvent[] $VALUES;
    public static final ResolveHostEvent COMPLETE;
    public static final ResolveHostEvent FAILED;

    private static ResolveHostEvent[] $values() {
        return 2;
    }

    static <clinit>() {
        new ResolveHostEvent("COMPLETE", 0);
        COMPLETE = new ResolveHostEvent(..);
        new ResolveHostEvent("FAILED", 1);
        FAILED = new ResolveHostEvent(..);
        ResolveHostEvent.$values();
        $VALUES = ResolveHostEvent.$values(..);
        return;
    }

    private ResolveHostEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static ResolveHostEvent valueOf(String p0) {
        Enum.valueOf(ResolveHostEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static ResolveHostEvent[] values() {
        ResolveHostEvent.$VALUES.clone();
        return ResolveHostEvent[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.WebRequest
// ============================================================
package com.unity3d.services.core.request;

public class WebRequest {
    private ByteArrayOutputStream _baos;
    private byte[] _body;
    private boolean _canceled;
    private int _connectTimeout;
    private long _contentLength;
    private Map _headers;
    private IWebRequestProgressListener _progressListener;
    private int _readTimeout;
    private String _requestType;
    private int _responseCode;
    private Map _responseHeaders;
    private URL _url;

    public WebRequest(String p0, String p1) {
        new WebRequest(p0, p1, 0);
        return;
    }

    public WebRequest(String p0, String p1, Map p2) {
        new WebRequest(p0, p1, p2, 30000, 30000);
        return;
    }

    public WebRequest(String p0, String p1, Map p2, int p3, int p4) {
        new Object();
        _responseCode = -1;
        _contentLength = -1L;
        _canceled = 0;
        new URL(p0);
        _url = new URL(..);
        _requestType = p1;
        _headers = p2;
        _connectTimeout = p3;
        _readTimeout = p4;
        return;
    }

    private HttpURLConnection getHttpUrlConnectionWithHeaders() {
        WebRequest.getUrl();
        WebRequest.getUrl(..).toString();
        URL.toString(..).startsWith("https://");
        if (if-eqz(String.startsWith(..))) goto L_34;
        WebRequest.getUrl();
        WebRequest.getUrl(..).openConnection();
        new StringBuilder("Open HTTPS connection: ");
        URL.openConnection(..).getMessage();
        new StringBuilder(..).append(IOException.getMessage(..));
        new StringBuilder(..).toString();
        new NetworkIOException(StringBuilder.toString(..));
        throw new NetworkIOException(..);
      L_34:
        WebRequest.getUrl();
        WebRequest.getUrl(..).toString();
        URL.toString(..).startsWith("http://");
        if (if-eqz(String.startsWith(..))) goto L_105;
        WebRequest.getUrl();
        WebRequest.getUrl(..).openConnection();
      L_4e:
        URL.openConnection(..).setInstanceFollowRedirects(0);
        WebRequest.getConnectTimeout();
        URL.openConnection(..).setConnectTimeout(WebRequest.getConnectTimeout(..));
        WebRequest.getReadTimeout();
        URL.openConnection(..).setReadTimeout(WebRequest.getReadTimeout(..));
        WebRequest.getRequestType();
        URL.openConnection(..).setRequestMethod(WebRequest.getRequestType(..));
        WebRequest.getHeaders();
        if (if-eqz(WebRequest.getHeaders(..))) goto L_c6;
        WebRequest.getHeaders();
        WebRequest.getHeaders(..).size();
        if (if-lez(Map.size(..))) goto L_c6;
        WebRequest.getHeaders();
        WebRequest.getHeaders(..).keySet();
        Map.keySet(..).iterator();
      L_83:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_c6;
        Set.iterator(..).next();
        WebRequest.getHeaders();
        WebRequest.getHeaders(..).get(Iterator.next(..));
        Map.get(..).iterator();
      L_9d:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_83;
        List.iterator(..).next();
        new StringBuilder("Setting header: ");
        new StringBuilder(..).append(Iterator.next(..));
        new StringBuilder(..).append("=");
        new StringBuilder(..).append(Iterator.next(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        URL.openConnection(..).setRequestProperty(Iterator.next(..), Iterator.next(..));
      L_c6:
        return URL.openConnection(..);
        new StringBuilder("Set Request Method: ");
        WebRequest.getRequestType();
        new StringBuilder(..).append(WebRequest.getRequestType(..));
        new StringBuilder(..).append(", ");
        URL.openConnection(..).getMessage();
        new StringBuilder(..).append(ProtocolException.getMessage(..));
        new StringBuilder(..).toString();
        new NetworkIOException(StringBuilder.toString(..));
        throw new NetworkIOException(..);
        new StringBuilder("Open HTTP connection: ");
        StringBuilder.toString(..).getMessage();
        new StringBuilder(..).append(IOException.getMessage(..));
        new StringBuilder(..).toString();
        new NetworkIOException(StringBuilder.toString(..));
        throw new NetworkIOException(..);
      L_105:
        new StringBuilder("Invalid url-protocol in url: ");
        WebRequest.getUrl();
        WebRequest.getUrl(..).toString();
        new StringBuilder(..).append(URL.toString(..));
        new StringBuilder(..).toString();
        new IllegalArgumentException(StringBuilder.toString(..));
        throw new IllegalArgumentException(..);
    }

    public void cancel() {
        _canceled = 1;
        return;
    }

    public byte[] getBody() {
        return _body;
    }

    public int getConnectTimeout() {
        return _connectTimeout;
    }

    public long getContentLength() {
        return _contentLength;
    }

    public Map getHeaders() {
        return _headers;
    }

    public String getQuery() {
        if (if-eqz(_url)) goto L_9;
        _url.getQuery();
        return URL.getQuery(..);
      L_9:
        return 0;
    }

    public int getReadTimeout() {
        return _readTimeout;
    }

    public String getRequestType() {
        return _requestType;
    }

    public int getResponseCode() {
        return _responseCode;
    }

    public Map getResponseHeaders() {
        return _responseHeaders;
    }

    public URL getUrl() {
        return _url;
    }

    public boolean isCanceled() {
        return _canceled;
    }

    public String makeRequest() {
        new ByteArrayOutputStream();
        _baos = new ByteArrayOutputStream(..);
        WebRequest.makeStreamRequest(new ByteArrayOutputStream(..));
        _baos.toString("UTF-8");
        return ByteArrayOutputStream.toString(..);
    }

    public long makeStreamRequest(OutputStream p0) {
        WebRequest.getHttpUrlConnectionWithHeaders();
        HttpURLConnection.setDoInput(1);
        WebRequest.getRequestType();
        WebRequest$RequestType.POST.name();
        WebRequest.getRequestType(..).equals(WebRequest$RequestType.name(..));
        if (if-eqz(String.equals(..))) goto L_7d;
        HttpURLConnection.setDoOutput(1);
        HttpURLConnection.getOutputStream();
        WebRequest.getBody();
        if (if-nez(WebRequest.getBody(..))) goto L_3c;
        WebRequest.getQuery();
        if (if-eqz(WebRequest.getQuery(..))) goto L_43;
        WebRequest.getQuery(..).getBytes(StandardCharsets.UTF_8);
        OutputStream.write(String.getBytes(..));
      L_3c:
        WebRequest.getBody();
        OutputStream.write(WebRequest.getBody(..));
      L_43:
        OutputStream.flush();
        if (if-eqz(HttpURLConnection.getOutputStream(..))) goto L_7d;
        OutputStream.close();
        DeviceLog.exception("Error closing writer", WebRequest.getBody(..));
        DeviceLog.exception("Error while writing POST params", WebRequest.getBody(..));
        new StringBuilder(WebRequest.getBody(..));
        WebRequest.getBody(..).getMessage();
        new StringBuilder(..).append(IOException.getMessage(..));
        new StringBuilder(..).toString();
        new NetworkIOException(StringBuilder.toString(..));
        throw new NetworkIOException(..);
      L_71:
        if (if-eqz(HttpURLConnection.getOutputStream(..))) goto L_7c;
        OutputStream.close();
        DeviceLog.exception("Error closing writer", StringBuilder.toString(..));
      L_7c:
        throw WebRequest.getBody(..);
      L_7d:
        StringBuilder.toString(..).getResponseCode();
        _responseCode = HttpURLConnection.getResponseCode(..);
        StringBuilder.toString(..).getContentLength();
        _contentLength = "Error closing writer";
        if (if-nez(HttpURLConnection.getContentLength(..))) goto L_9a;
        StringBuilder.toString(..).getHeaderFieldInt("X-OrigLength", -1);
        _contentLength = -1L;
      L_9a:
        if (if-eqz(_baos)) goto L_b5;
        if (if-ne(_baos, p0)) goto L_b5;
        if (if-lez(_baos)) goto L_b5;
        new ByteArrayOutputStream(p0);
        _baos = new ByteArrayOutputStream(..);
      L_b5:
        StringBuilder.toString(..).getHeaderFields();
        if (if-eqz(HttpURLConnection.getHeaderFields(..))) goto L_c1;
        StringBuilder.toString(..).getHeaderFields();
        _responseHeaders = HttpURLConnection.getHeaderFields(..);
      L_c1:
        StringBuilder.toString(..).getInputStream();
        StringBuilder.toString(..).getErrorStream();
        if (if-eqz(HttpURLConnection.getErrorStream(..))) goto L_151;
      L_ce:
        if (if-eqz(_progressListener)) goto L_e3;
        WebRequest.getUrl();
        WebRequest.getUrl(..).toString();
        _progressListener.onRequestStart(URL.toString(..), _contentLength, v10, _responseCode, _responseHeaders);
      L_e3:
        new BufferedInputStream(HttpURLConnection.getErrorStream(..));
      L_ee:
        WebRequest.isCanceled();
        if (if-nez(WebRequest.isCanceled(..))) goto L_14a;
        if (if-eq(0, -1)) goto L_14a;
        new BufferedInputStream(..).read(4096);
        if (if-lez(BufferedInputStream.read(..))) goto L_ee;
        new ByteArrayOutputStream(..).write(4096, 0, BufferedInputStream.read(..));
        if (if-eqz(_progressListener)) goto L_ee;
        WebRequest.getUrl();
        WebRequest.getUrl(..).toString();
        _progressListener.onRequestProgress(URL.toString(..), 0L, v15, _contentLength, v17);
        new StringBuilder("Unknown Exception: ");
        4096.getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
        new Exception(StringBuilder.toString(..));
        throw new Exception(..);
        new StringBuilder("Network exception: ");
        new Exception(..).getMessage();
        new StringBuilder(..).append(IOException.getMessage(..));
        new StringBuilder(..).toString();
        new NetworkIOException(StringBuilder.toString(..));
        throw new NetworkIOException(..);
      L_14a:
        "Network exception: ".disconnect();
        new StringBuilder(..).flush();
        return 0L;
      L_151:
        new StringBuilder("Can't open error stream: ");
        new BufferedInputStream(..).getMessage();
        new StringBuilder(..).append(IOException.getMessage(..));
        new StringBuilder(..).toString();
        new NetworkIOException(StringBuilder.toString(..));
        throw new NetworkIOException(..);
      L_16c:
        new StringBuilder("Response code: ");
        new NetworkIOException(..).getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
        new NetworkIOException(StringBuilder.toString(..));
        throw new NetworkIOException(..);
    }

    public void setBody(String p0) {
        p0.getBytes(StandardCharsets.UTF_8);
        _body = String.getBytes(..);
        return;
    }

    public void setBody(byte[] p0) {
        _body = p0;
        return;
    }

    public void setConnectTimeout(int p0) {
        _connectTimeout = p0;
        return;
    }

    public void setProgressListener(IWebRequestProgressListener p0) {
        _progressListener = p0;
        return;
    }

    public void setReadTimeout(int p0) {
        _readTimeout = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.WebRequestError
// ============================================================
package com.unity3d.services.core.request;

public final class WebRequestError extends Enum {
    private static final WebRequestError[] $VALUES;
    public static final WebRequestError MAPPING_HEADERS_FAILED;

    private static WebRequestError[] $values() {
        return 1;
    }

    static <clinit>() {
        new WebRequestError("MAPPING_HEADERS_FAILED", 0);
        MAPPING_HEADERS_FAILED = new WebRequestError(..);
        WebRequestError.$values();
        $VALUES = WebRequestError.$values(..);
        return;
    }

    private WebRequestError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static WebRequestError valueOf(String p0) {
        Enum.valueOf(WebRequestError.class, p0);
        return Enum.valueOf(..);
    }

    public static WebRequestError[] values() {
        WebRequestError.$VALUES.clone();
        return WebRequestError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.WebRequestEvent
// ============================================================
package com.unity3d.services.core.request;

public final class WebRequestEvent extends Enum {
    private static final WebRequestEvent[] $VALUES;
    public static final WebRequestEvent COMPLETE;
    public static final WebRequestEvent FAILED;

    private static WebRequestEvent[] $values() {
        return 2;
    }

    static <clinit>() {
        new WebRequestEvent("COMPLETE", 0);
        COMPLETE = new WebRequestEvent(..);
        new WebRequestEvent("FAILED", 1);
        FAILED = new WebRequestEvent(..);
        WebRequestEvent.$values();
        $VALUES = WebRequestEvent.$values(..);
        return;
    }

    private WebRequestEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static WebRequestEvent valueOf(String p0) {
        Enum.valueOf(WebRequestEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static WebRequestEvent[] values() {
        WebRequestEvent.$VALUES.clone();
        return WebRequestEvent[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.WebRequestRunnable
// ============================================================
package com.unity3d.services.core.request;

public class WebRequestRunnable {
    private final String _body;
    private boolean _canceled;
    private final int _connectTimeout;
    private WebRequest _currentRequest;
    private final Map _headers;
    private final IWebRequestListener _listener;
    private final int _readTimeout;
    private final String _type;
    private final String _url;

    public WebRequestRunnable(String p0, String p1, String p2, int p3, int p4, Map p5, IWebRequestListener p6) {
        new Object();
        _canceled = 0;
        _url = p0;
        _type = p1;
        _body = p2;
        _connectTimeout = p3;
        _readTimeout = p4;
        _headers = p5;
        _listener = p6;
        return;
    }

    static String access$000(WebRequestRunnable p0) {
        return _url;
    }

    static String access$100(WebRequestRunnable p0) {
        return _type;
    }

    private Map getResponseHeaders(Bundle p0) {
        p0.isEmpty();
        if (if-nez(Bundle.isEmpty(..))) goto L_32;
        new HashMap();
        p0.keySet();
        Bundle.keySet(..).iterator();
      L_13:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_33;
        Set.iterator(..).next();
        p0.getStringArray(Iterator.next(..));
        if (if-eqz(Bundle.getStringArray(..))) goto L_13;
        Arrays.asList(Bundle.getStringArray(..));
        new ArrayList(Arrays.asList(..));
        new HashMap(..).put(Iterator.next(..), new ArrayList(..));
      L_32:
      L_33:
        return 0;
    }

    private void makeRequest(String p0, String p1, Map p2, String p3, int p4, int p5) {
        if (if-eqz(_canceled)) goto L_5;
        return;
      L_5:
        new WebRequest(p0, p1, p2, p4, p5);
        _currentRequest = new WebRequest;
        if (if-eqz(p3)) goto L_17;
        new WebRequest.setBody(p3);
      L_17:
        _currentRequest.makeRequest();
        _currentRequest.isCanceled();
        if (if-eqz(WebRequest.isCanceled(..))) goto L_26;
        return;
      L_26:
        new Bundle();
        _currentRequest.getResponseHeaders();
        if (if-eqz(WebRequest.getResponseHeaders(..))) goto L_80;
        WebRequest.getResponseHeaders(..).keySet();
        Map.keySet(..).iterator();
      L_3b:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_80;
        Set.iterator(..).next();
        if (if-eqz(Iterator.next(..))) goto L_3b;
        Iterator.next(..).contentEquals("null");
        if (if-eqz(String.contentEquals(..))) goto L_52;
      L_52:
        WebRequest.getResponseHeaders(..).get(Iterator.next(..));
        Map.get(..).size();
      L_5f:
        WebRequest.getResponseHeaders(..).get(Iterator.next(..));
        Map.get(..).size();
        if (if-ge(0, List.size(..))) goto L_7c;
        WebRequest.getResponseHeaders(..).get(Iterator.next(..));
        Map.get(..).get(0);
      L_7c:
        new Bundle(..).putStringArray(Iterator.next(..), List.size(..));
      L_80:
        _currentRequest.isCanceled();
        if (if-eqz(WebRequest.isCanceled(..))) goto L_89;
        return;
      L_89:
        _currentRequest.getResponseCode();
        WebRequestRunnable.getResponseHeaders(new Bundle(..));
        WebRequestRunnable.onSucceed(WebRequest.makeRequest(..), WebRequest.getResponseCode(..), WebRequestRunnable.getResponseHeaders(..));
        return;
        DeviceLog.exception("Error completing request", WebRequest.makeRequest(..));
        new StringBuilder();
        WebRequest.makeRequest(..).getClass();
        Object.getClass(..).getName();
        new StringBuilder(..).append(Class.getName(..));
        new StringBuilder(..).append(": ");
        WebRequest.makeRequest(..).getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
        WebRequestRunnable.onFailed(StringBuilder.toString(..));
        return;
    }

    private void onFailed(String p0) {
        _listener.onFailed(_url, p0);
        return;
    }

    private void onSucceed(String p0, int p1, Map p2) {
        _listener.onComplete(_url, p0, p1, p2);
        return;
    }

    public void run() {
        new StringBuilder("Handling request message: ");
        new StringBuilder(..).append(_url);
        new StringBuilder(..).append(" type=");
        new StringBuilder(..).append(_type);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        WebRequestRunnable.makeRequest(_url, _type, _headers, _body, _connectTimeout, _readTimeout);
        DeviceLog.error("Out of memory error while doing web request.");
        Utilities.getService(SDKMetricsSender.class);
        new WebRequestRunnable$1(this);
        Utilities.getService(..).sendEvent("native_webview_oom", 0, new WebRequestRunnable$1(..));
        WebRequestRunnable.onFailed("Out of memory error while doing web request.");
        DeviceLog.exception("Malformed URL", "Out of memory error while doing web request.");
        WebRequestRunnable.onFailed("Malformed URL");
      L_53:
        return;
    }

    public void setCancelStatus(boolean p0) {
        _canceled = p0;
        if (if-eqz(p0)) goto L_b;
        if (if-eqz(_currentRequest)) goto L_b;
        _currentRequest.cancel();
      L_b:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.WebRequestThread
// ============================================================
package com.unity3d.services.core.request;

public class WebRequestThread {
    private static int _corePoolSize = 1;
    private static long _keepAliveTime = 1000L;
    private static int _maximumPoolSize = 1;
    private static CancelableThreadPoolExecutor _pool;
    private static LinkedBlockingQueue _queue;
    private static boolean _ready;
    private static final Object _readyLock;

    static <clinit>() {
        new Object();
        _readyLock = new Object(..);
        return;
    }

    public WebRequestThread() {
        new Object();
        return;
    }

    static boolean access$002(boolean p0) {
        _ready = p0;
        return p0;
    }

    static Object access$100() {
        return WebRequestThread._readyLock;
    }

    public static void cancel() {
        if (if-eqz(WebRequestThread._pool)) goto L_31;
        WebRequestThread._pool.cancel();
        WebRequestThread._queue.iterator();
      L_10:
        LinkedBlockingQueue.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_27;
        LinkedBlockingQueue.iterator(..).next();
        if (if-eqz(v3)) goto L_10;
        Iterator.next(..).setCancelStatus(1);
      L_27:
        WebRequestThread._queue.clear();
        WebRequestThread._pool.purge();
      L_31:
        return;
        throw WebRequestThread._pool;
    }

    private static void init() {
        new LinkedBlockingQueue();
        _queue = new LinkedBlockingQueue(..);
        new CancelableThreadPoolExecutor(WebRequestThread._corePoolSize, WebRequestThread._maximumPoolSize, WebRequestThread._keepAliveTime, v6, TimeUnit.MILLISECONDS, WebRequestThread._queue);
        _pool = new CancelableThreadPoolExecutor;
        new CancelableThreadPoolExecutor.prestartAllCoreThreads();
        new WebRequestThread$1();
        WebRequestThread._queue.add(new WebRequestThread$1(..));
      L_29:
        if (if-nez(WebRequestThread._ready)) goto L_46;
        WebRequestThread._readyLock.wait();
        throw new WebRequestThread$1(..);
        DeviceLog.debug("Couldn't synchronize thread");
        Thread.currentThread();
        Thread.currentThread(..).interrupt();
        return;
      L_46:
        return;
        throw Thread.currentThread(..);
    }

    public static void request(String p0, WebRequest$RequestType p1, Map p2, Integer p3, Integer p4, IWebRequestListener p5) {
        WebRequestThread.request(p0, p1, p2, 0, p3, p4, p5);
        return;
        throw p0;
    }

    public static void request(String p0, WebRequest$RequestType p1, Map p2, String p3, Integer p4, Integer p5, IWebRequestListener p6) {
        if (if-nez(WebRequestThread._ready)) goto L_b;
        WebRequestThread.init();
      L_b:
        if (if-eqz(p0)) goto L_33;
        p0.length();
        if (if-ge(String.length(..), 3)) goto L_15;
      L_15:
        p1.name();
        p4.intValue();
        p5.intValue();
        new WebRequestRunnable(p0, WebRequest$RequestType.name(..), p3, Integer.intValue(..), Integer.intValue(..), p2, p6);
        WebRequestThread._queue.add(new WebRequestRunnable);
        return;
      L_33:
        p6.onFailed(p0, "Request is NULL or too short");
        return;
        throw p0;
    }

    public static void reset() {
        WebRequestThread.cancel();
        if (if-eqz(WebRequestThread._pool)) goto L_2e;
        WebRequestThread._pool.shutdown();
        WebRequestThread._pool.awaitTermination(0x7fffffffffffffffL, v4, TimeUnit.NANOSECONDS);
        Thread.currentThread();
        Thread.currentThread(..).interrupt();
      L_21:
        WebRequestThread._queue.clear();
        _pool = 0;
        _queue = 0;
        _ready = 0;
      L_2e:
        return;
        throw 0;
    }

    public static boolean resolve(String p0, IResolveHostListener p1) {
        if (if-eqz(p0)) goto L_1d;
        p0.length();
        if (if-ge(String.length(..), 3)) goto L_d;
      L_d:
        new WebRequestThread$2(p0, p1);
        new Thread(new WebRequestThread$2(..));
        new Thread(..).start();
        return 1;
      L_1d:
        p1.onFailed(1, ResolveHostError.INVALID_HOST, "Host is NULL");
        return 0;
        throw 0;
    }

    public static void setConcurrentRequestCount(int p0) {
        _corePoolSize = p0;
        _maximumPoolSize = p0;
        if (if-eqz(WebRequestThread._pool)) goto L_15;
        WebRequestThread._pool.setCorePoolSize(p0);
        WebRequestThread._pool.setMaximumPoolSize(WebRequestThread._maximumPoolSize);
      L_15:
        return;
        throw WebRequestThread._pool;
    }

    public static void setKeepAliveTime(long p0) {
        _keepAliveTime = p0;
        if (if-eqz(WebRequestThread._pool)) goto L_e;
        WebRequestThread._pool.setKeepAliveTime(p0, v4, TimeUnit.MILLISECONDS);
      L_e:
        return;
        throw p0;
    }

    public static void setMaximumPoolSize(int p0) {
        _maximumPoolSize = p0;
        if (if-eqz(WebRequestThread._pool)) goto L_c;
        WebRequestThread._pool.setMaximumPoolSize(p0);
      L_c:
        return;
        throw p0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.WebRequest$RequestType
// ============================================================
package com.unity3d.services.core.request;

public final class WebRequest$RequestType extends Enum {
    private static final WebRequest$RequestType[] $VALUES;
    public static final WebRequest$RequestType GET;
    public static final WebRequest$RequestType HEAD;
    public static final WebRequest$RequestType POST;

    private static WebRequest$RequestType[] $values() {
        return 3;
    }

    static <clinit>() {
        new WebRequest$RequestType("POST", 0);
        POST = new WebRequest$RequestType(..);
        new WebRequest$RequestType("GET", 1);
        GET = new WebRequest$RequestType(..);
        new WebRequest$RequestType("HEAD", 2);
        HEAD = new WebRequest$RequestType(..);
        WebRequest$RequestType.$values();
        $VALUES = WebRequest$RequestType.$values(..);
        return;
    }

    private WebRequest$RequestType(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static WebRequest$RequestType valueOf(String p0) {
        Enum.valueOf(WebRequest$RequestType.class, p0);
        return Enum.valueOf(..);
    }

    public static WebRequest$RequestType[] values() {
        WebRequest$RequestType.$VALUES.clone();
        return WebRequest$RequestType[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.WebRequestRunnable$1
// ============================================================
package com.unity3d.services.core.request;

class WebRequestRunnable$1 extends HashMap {
    final WebRequestRunnable this$0;

    WebRequestRunnable$1(WebRequestRunnable p0) {
        this$0 = p0;
        new HashMap();
        new HashMap(..).put("src", "WebRequestRunnable");
        WebRequestRunnable.access$000(p0);
        new HashMap(..).put("url", WebRequestRunnable.access$000(..));
        WebRequestRunnable.access$100(p0);
        new HashMap(..).put("type", WebRequestRunnable.access$100(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.WebRequestThread$1
// ============================================================
package com.unity3d.services.core.request;

class WebRequestThread$1 {
    WebRequestThread$1() {
        new Object();
        return;
    }

    public void run() {
        WebRequestThread.access$002(1);
        WebRequestThread.access$100();
        WebRequestThread.access$100();
        WebRequestThread.access$100(..).notifyAll();
        return;
        throw WebRequestThread.access$100(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.WebRequestThread$2
// ============================================================
package com.unity3d.services.core.request;

class WebRequestThread$2 {
    final String val$host;
    final IResolveHostListener val$listener;

    WebRequestThread$2(String p0, IResolveHostListener p1) {
        val$host = p0;
        val$listener = p1;
        new Object();
        return;
    }

    public void run() {
        new ConditionVariable();
        new WebRequestThread$2$1(this, new ConditionVariable(..));
        new Thread(new WebRequestThread$2$1(..));
        new Thread(..).start();
      L_1a:
        DeviceLog.exception("Exception while resolving host", new Thread(..));
        new Thread(..).getMessage();
        IResolveHostListener.onFailed(val$host, ResolveHostError.UNEXPECTED_EXCEPTION, Exception.getMessage(..));
      L_2c:
        new ConditionVariable(..).block(20000L, val$host);
        if (if-nez(ConditionVariable.block(..))) goto L_44;
        if (if-eqz(0)) goto L_44;
        0.interrupt();
        IResolveHostListener.onFailed(val$host, ResolveHostError.TIMEOUT, "Timeout");
      L_44:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.request.WebRequestThread$2$1
// ============================================================
package com.unity3d.services.core.request;

class WebRequestThread$2$1 {
    final WebRequestThread$2 this$0;
    final ConditionVariable val$cv;

    WebRequestThread$2$1(WebRequestThread$2 p0, ConditionVariable p1) {
        this$0 = p0;
        val$cv = p1;
        new Object();
        return;
    }

    public void run() {
        InetAddress.getByName(val$host);
        InetAddress.getByName(..).getHostAddress();
        IResolveHostListener.onResolve(val$host, InetAddress.getHostAddress(..));
        DeviceLog.exception("Unknown host", InetAddress.getHostAddress(..));
        InetAddress.getHostAddress(..).getMessage();
        IResolveHostListener.onFailed(val$host, ResolveHostError.UNKNOWN_HOST, UnknownHostException.getMessage(..));
      L_2f:
        ConditionVariable.open();
        return;
    }

}

