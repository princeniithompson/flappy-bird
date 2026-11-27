// Package bundle: com.unity3d.services.core.cache (8 classes)

// ============================================================
// CLASS: com.unity3d.services.core.cache.CacheDirectory
// ============================================================
package com.unity3d.services.core.cache;

public class CacheDirectory {
    private static final String TEST_FILE_NAME = "UnityAdsTest.txt";
    private String _cacheDirName;
    private File _cacheDirectory;
    private boolean _initialized;
    private final boolean _preferExternalStorage;
    private CacheDirectoryType _type;

    public CacheDirectory(String p0) {
        new Object();
        _initialized = 0;
        _cacheDirectory = 0;
        _type = 0;
        _cacheDirName = p0;
        _preferExternalStorage = 1;
        return;
    }

    public CacheDirectory(String p0, boolean p1) {
        new Object();
        _initialized = 0;
        _cacheDirectory = 0;
        _type = 0;
        _preferExternalStorage = p1;
        _cacheDirName = p0;
        return;
    }

    private void createNoMediaFile(File p0) {
        new File(p0, ".nomedia");
        new File(..).createNewFile();
        if (if-eqz(File.createNewFile(..))) goto L_13;
        DeviceLog.debug("Successfully created .nomedia file");
      L_13:
        DeviceLog.debug("Using existing .nomedia file");
        DeviceLog.exception("Failed to create .nomedia file", "Using existing .nomedia file");
      L_1f:
        return;
    }

    public File createCacheDirectory(File p0, String p1) {
        if (if-nez(p0)) goto L_4;
        return 0;
      L_4:
        new File(p0, p1);
        new File(..).mkdirs();
        new File(..).isDirectory();
        if (if-eqz(File.isDirectory(..))) goto L_13;
        return new File(..);
      L_13:
        return 0;
    }

    public File getCacheDirectory(Context p0) {
        if (if-nez(p0)) goto L_a;
        return 0;
      L_a:
        if (if-eqz(_initialized)) goto L_12;
        return _cacheDirectory;
      L_12:
        _initialized = 1;
        if (if-eqz(_preferExternalStorage)) goto L_62;
        Environment.getExternalStorageState();
        "mounted".equals(Environment.getExternalStorageState(..));
        if (if-eqz(String.equals(..))) goto L_5d;
        _cacheDirectory.getExternalCacheDir();
        CacheDirectory.createCacheDirectory(Context.getExternalCacheDir(..), _cacheDirName);
        CacheDirectory.testCacheDirectory(CacheDirectory.createCacheDirectory(..));
        if (if-eqz(CacheDirectory.testCacheDirectory(..))) goto L_62;
        CacheDirectory.createNoMediaFile(CacheDirectory.createCacheDirectory(..));
        _cacheDirectory = CacheDirectory.createCacheDirectory(..);
        _type = CacheDirectoryType.EXTERNAL;
        new StringBuilder("Unity Ads is using external cache directory: ");
        File.getAbsolutePath();
        new StringBuilder(..).append(File.getAbsolutePath(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        return _cacheDirectory;
        DeviceLog.exception("Creating external cache directory failed", _cacheDirectory);
        return 0;
      L_5d:
        DeviceLog.debug("External media not mounted");
      L_62:
        _cacheDirectory.getNoBackupFilesDir();
        CacheDirectory.createCacheDirectory(Context.getNoBackupFilesDir(..), _cacheDirName);
        CacheDirectory.testCacheDirectory(CacheDirectory.createCacheDirectory(..));
        if (if-eqz(CacheDirectory.testCacheDirectory(..))) goto L_8f;
        _cacheDirectory = CacheDirectory.createCacheDirectory(..);
        _type = CacheDirectoryType.INTERNAL;
        new StringBuilder("Unity Ads is using internal cache directory: ");
        File.getAbsolutePath();
        new StringBuilder(..).append(File.getAbsolutePath(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        return _cacheDirectory;
      L_8f:
        DeviceLog.error("Unity Ads failed to initialize cache directory");
        return 0;
        throw "Unity Ads failed to initialize cache directory";
    }

    public CacheDirectoryType getType() {
        return _type;
    }

    public boolean testCacheDirectory(File p0) {
        if (if-eqz(p0)) goto L_a4;
        p0.isDirectory();
        if (if-nez(File.isDirectory(..))) goto L_11;
      L_11:
        "test".getBytes("UTF-8");
        new File(p0, "UnityAdsTest.txt");
        new FileOutputStream(new File(..));
        new FileOutputStream(..).write(String.getBytes(..));
        new FileOutputStream(..).flush();
        new FileOutputStream(..).close();
        new FileInputStream(new File(..));
        new FileInputStream(..).read(v6, 0, v5);
        new FileInputStream(..).close();
        new File(..).delete();
        if (if-nez(File.delete(..))) goto L_53;
        new StringBuilder("Failed to delete testfile ");
        new File(..).getAbsoluteFile();
        new StringBuilder(..).append(File.getAbsoluteFile(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        return 0;
      L_53:
        if (if-eq(FileInputStream.read(..), v5)) goto L_5b;
        DeviceLog.debug("Read buffer size mismatch");
        return 0;
      L_5b:
        new String(v6, "Read buffer size mismatch");
        new String(..).equals(File.getAbsoluteFile(..));
        if (if-eqz(String.equals(..))) goto L_68;
        return 1;
      L_68:
        DeviceLog.debug("Read buffer content mismatch");
        return 0;
        File.delete(..).close();
        "Read buffer content mismatch".addSuppressed(File.getAbsoluteFile(..));
      L_77:
        throw "Read buffer content mismatch";
        FileInputStream.read(..).close();
        "Read buffer content mismatch".addSuppressed(File.getAbsoluteFile(..));
      L_81:
        throw "Read buffer content mismatch";
        new StringBuilder("Unity Ads exception while testing cache directory ");
        1.getAbsolutePath();
        new StringBuilder(..).append(File.getAbsolutePath(..));
        new StringBuilder(..).append(": ");
        "Read buffer content mismatch".getMessage();
        new StringBuilder(..).append(Exception.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
      L_a4:
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.cache.CacheDirectoryType
// ============================================================
package com.unity3d.services.core.cache;

public final class CacheDirectoryType extends Enum {
    private static final CacheDirectoryType[] $VALUES;
    public static final CacheDirectoryType EXTERNAL;
    public static final CacheDirectoryType INTERNAL;

    private static CacheDirectoryType[] $values() {
        return 2;
    }

    static <clinit>() {
        new CacheDirectoryType("EXTERNAL", 0);
        EXTERNAL = new CacheDirectoryType(..);
        new CacheDirectoryType("INTERNAL", 1);
        INTERNAL = new CacheDirectoryType(..);
        CacheDirectoryType.$values();
        $VALUES = CacheDirectoryType.$values(..);
        return;
    }

    private CacheDirectoryType(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static CacheDirectoryType valueOf(String p0) {
        Enum.valueOf(CacheDirectoryType.class, p0);
        return Enum.valueOf(..);
    }

    public static CacheDirectoryType[] values() {
        CacheDirectoryType.$VALUES.clone();
        return CacheDirectoryType[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.cache.CacheError
// ============================================================
package com.unity3d.services.core.cache;

public final class CacheError extends Enum {
    private static final CacheError[] $VALUES;
    public static final CacheError CACHE_DIRECTORY_DOESNT_EXIST;
    public static final CacheError CACHE_DIRECTORY_EXISTS;
    public static final CacheError CACHE_DIRECTORY_NULL;
    public static final CacheError CACHE_DIRECTORY_TYPE_NULL;
    public static final CacheError FILE_ALREADY_CACHING;
    public static final CacheError FILE_IO_ERROR;
    public static final CacheError FILE_NOT_FOUND;
    public static final CacheError FILE_STATE_WRONG;
    public static final CacheError ILLEGAL_STATE;
    public static final CacheError INVALID_ARGUMENT;
    public static final CacheError JSON_ERROR;
    public static final CacheError MALFORMED_URL;
    public static final CacheError NETWORK_ERROR;
    public static final CacheError NOT_CACHING;
    public static final CacheError NO_INTERNET;
    public static final CacheError UNKNOWN_ERROR;
    public static final CacheError UNSUPPORTED_ENCODING;

    private static CacheError[] $values() {
        return 17;
    }

    static <clinit>() {
        new CacheError("FILE_IO_ERROR", 0);
        FILE_IO_ERROR = new CacheError(..);
        new CacheError("FILE_NOT_FOUND", 1);
        FILE_NOT_FOUND = new CacheError(..);
        new CacheError("FILE_ALREADY_CACHING", 2);
        FILE_ALREADY_CACHING = new CacheError(..);
        new CacheError("NOT_CACHING", 3);
        NOT_CACHING = new CacheError(..);
        new CacheError("JSON_ERROR", 4);
        JSON_ERROR = new CacheError(..);
        new CacheError("NO_INTERNET", 5);
        NO_INTERNET = new CacheError(..);
        new CacheError("MALFORMED_URL", 6);
        MALFORMED_URL = new CacheError(..);
        new CacheError("NETWORK_ERROR", 7);
        NETWORK_ERROR = new CacheError(..);
        new CacheError("ILLEGAL_STATE", 8);
        ILLEGAL_STATE = new CacheError(..);
        new CacheError("INVALID_ARGUMENT", 9);
        INVALID_ARGUMENT = new CacheError(..);
        new CacheError("UNSUPPORTED_ENCODING", 10);
        UNSUPPORTED_ENCODING = new CacheError(..);
        new CacheError("FILE_STATE_WRONG", 11);
        FILE_STATE_WRONG = new CacheError(..);
        new CacheError("CACHE_DIRECTORY_NULL", 12);
        CACHE_DIRECTORY_NULL = new CacheError(..);
        new CacheError("CACHE_DIRECTORY_TYPE_NULL", 13);
        CACHE_DIRECTORY_TYPE_NULL = new CacheError(..);
        new CacheError("CACHE_DIRECTORY_EXISTS", 14);
        CACHE_DIRECTORY_EXISTS = new CacheError(..);
        new CacheError("CACHE_DIRECTORY_DOESNT_EXIST", 15);
        CACHE_DIRECTORY_DOESNT_EXIST = new CacheError(..);
        new CacheError("UNKNOWN_ERROR", 16);
        UNKNOWN_ERROR = new CacheError(..);
        CacheError.$values();
        $VALUES = CacheError.$values(..);
        return;
    }

    private CacheError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static CacheError valueOf(String p0) {
        Enum.valueOf(CacheError.class, p0);
        return Enum.valueOf(..);
    }

    public static CacheError[] values() {
        CacheError.$VALUES.clone();
        return CacheError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.cache.CacheEvent
// ============================================================
package com.unity3d.services.core.cache;

public final class CacheEvent extends Enum {
    private static final CacheEvent[] $VALUES;
    public static final CacheEvent DOWNLOAD_END;
    public static final CacheEvent DOWNLOAD_ERROR;
    public static final CacheEvent DOWNLOAD_PROGRESS;
    public static final CacheEvent DOWNLOAD_STARTED;
    public static final CacheEvent DOWNLOAD_STOPPED;

    private static CacheEvent[] $values() {
        return 5;
    }

    static <clinit>() {
        new CacheEvent("DOWNLOAD_STARTED", 0);
        DOWNLOAD_STARTED = new CacheEvent(..);
        new CacheEvent("DOWNLOAD_PROGRESS", 1);
        DOWNLOAD_PROGRESS = new CacheEvent(..);
        new CacheEvent("DOWNLOAD_END", 2);
        DOWNLOAD_END = new CacheEvent(..);
        new CacheEvent("DOWNLOAD_STOPPED", 3);
        DOWNLOAD_STOPPED = new CacheEvent(..);
        new CacheEvent("DOWNLOAD_ERROR", 4);
        DOWNLOAD_ERROR = new CacheEvent(..);
        CacheEvent.$values();
        $VALUES = CacheEvent.$values(..);
        return;
    }

    private CacheEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static CacheEvent valueOf(String p0) {
        Enum.valueOf(CacheEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static CacheEvent[] values() {
        CacheEvent.$VALUES.clone();
        return CacheEvent[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.cache.CacheEventSender
// ============================================================
package com.unity3d.services.core.cache;

public final class CacheEventSender {
    private final IEventSender eventSender;

    public CacheEventSender(IEventSender p0) {
        new Object();
        eventSender = p0;
        return;
    }

    public final boolean sendEvent(CacheEvent p0, Object[] p1) {
        Arrays.copyOf(p1, v2);
        eventSender.sendEvent(WebViewEventCategory.CACHE, p0, Arrays.copyOf(..));
        return IEventSender.sendEvent(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.cache.CacheThread
// ============================================================
package com.unity3d.services.core.cache;

public class CacheThread extends Thread {
    public static final int MSG_DOWNLOAD = 1;
    private static int _connectTimeout = 30000;
    private static CacheThreadHandler _handler = null;
    private static int _progressInterval = 0;
    private static int _readTimeout = 30000;
    private static boolean _ready;
    private static final Object _readyLock;

    static <clinit>() {
        new Object();
        _readyLock = new Object(..);
        return;
    }

    public CacheThread() {
        new Thread();
        return;
    }

    public static void cancel() {
        if (if-nez(CacheThread._ready)) goto L_5;
        return;
      L_5:
        CacheThread._handler.removeMessages(1);
        CacheThread._handler.setCancelStatus(1);
        return;
    }

    public static void download(String p0, String p1, HashMap p2, boolean p3, IEventSender p4) {
        if (if-nez(CacheThread._ready)) goto L_a;
        CacheThread.init();
      L_a:
        new Bundle();
        new Bundle(..).putString("source", p0);
        new Bundle(..).putString("target", p1);
        new Bundle(..).putInt("connectTimeout", CacheThread._connectTimeout);
        new Bundle(..).putInt("readTimeout", CacheThread._readTimeout);
        new Bundle(..).putInt("progressInterval", CacheThread._progressInterval);
        new Bundle(..).putBoolean("append", p3);
        new CacheEventSender(p4);
        new Bundle(..).putSerializable("cacheEventSender", new CacheEventSender(..));
        if (if-eqz(p2)) goto L_6f;
        p2.keySet();
        HashMap.keySet(..).iterator();
      L_47:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_6f;
        Set.iterator(..).next();
        p2.get(Iterator.next(..));
        HashMap.get(..).size();
        p2.get(Iterator.next(..));
        HashMap.get(..).toArray(List.size(..));
        new Bundle(..).putStringArray(Iterator.next(..), List.toArray(..));
      L_6f:
        new Message();
        what = 1;
        new Message(..).setData(new Bundle(..));
        CacheThread._handler.setCancelStatus(0);
        CacheThread._handler.sendMessage(new Message(..));
        return;
        throw new Message(..);
    }

    public static int getConnectTimeout() {
        return CacheThread._connectTimeout;
    }

    public static int getProgressInterval() {
        return CacheThread._progressInterval;
    }

    public static int getReadTimeout() {
        return CacheThread._readTimeout;
    }

    private static void init() {
        new CacheThread();
        new CacheThread(..).setName("UnityAdsCacheThread");
        new CacheThread(..).start();
      L_d:
        if (if-nez(CacheThread._ready)) goto L_29;
        CacheThread._readyLock.wait();
        throw "UnityAdsCacheThread";
        DeviceLog.debug("Couldn't synchronize thread");
        Thread.currentThread();
        Thread.currentThread(..).interrupt();
      L_29:
        return;
    }

    public static boolean isActive() {
        if (if-nez(CacheThread._ready)) goto L_6;
        return 0;
      L_6:
        CacheThread._handler.isActive();
        return CacheThreadHandler.isActive(..);
    }

    public static void setConnectTimeout(int p0) {
        _connectTimeout = p0;
        return;
    }

    public static void setProgressInterval(int p0) {
        _progressInterval = p0;
        return;
    }

    public static void setReadTimeout(int p0) {
        _readTimeout = p0;
        return;
    }

    public void run() {
        Looper.prepare();
        new CacheThreadHandler();
        _handler = new CacheThreadHandler(..);
        _ready = 1;
        CacheThread._readyLock.notifyAll();
        Looper.loop();
        return;
        throw v1;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.cache.CacheThreadHandler
// ============================================================
package com.unity3d.services.core.cache;

class CacheThreadHandler extends Handler {
    private boolean _active;
    private boolean _canceled;
    private WebRequest _currentRequest;

    CacheThreadHandler() {
        new Handler();
        _currentRequest = 0;
        _canceled = 0;
        _active = 0;
        return;
    }

    private void downloadFile(String p0, String p1, int p2, int p3, int p4, HashMap p5, boolean p6, CacheEventSender p7) {
        if (if-nez(_canceled)) goto L_386;
        if (if-eqz(p0)) goto L_386;
        if (if-nez(p1)) goto L_16;
      L_16:
        new File(p1);
        if (if-eqz(p6)) goto L_48;
        new StringBuilder("Unity Ads cache: resuming download ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" to ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).append(" at ");
        new File(..).length();
        new StringBuilder(..).append(File.length(..), v7);
        new StringBuilder(..).append(" bytes");
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
      L_48:
        new StringBuilder("Unity Ads cache: start downloading ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(" to ");
        new StringBuilder(..).append(StringBuilder.toString(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
      L_5f:
        Device.isActiveNetworkConnected();
        if (if-nez(Device.isActiveNetworkConnected(..))) goto L_7b;
        DeviceLog.debug("Unity Ads cache: download cancelled, no internet connection available");
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, p6);
        return;
      L_7b:
        _active = 1;
        SystemClock.elapsedRealtime();
        new FileOutputStream(new File(..), p6);
        CacheThreadHandler.getWebRequest(p0, p2, p3, p5);
        _currentRequest = CacheThreadHandler.getWebRequest(..);
        new CacheThreadHandler$1(this, p7, new File(..), p4);
        CacheThreadHandler.getWebRequest(..).setProgressListener(new CacheThreadHandler$1(..));
        _currentRequest.makeStreamRequest(new FileOutputStream(..));
        _active = 0;
        _currentRequest.getContentLength();
        _currentRequest.isCanceled();
        _currentRequest.getResponseCode();
        _currentRequest.getResponseHeaders();
        CacheThreadHandler.postProcessDownload(SystemClock.elapsedRealtime(..), new StringBuilder(..), p0, new File(..), WebRequest.makeStreamRequest(..), new FileOutputStream(..), WebRequest.getContentLength(..), 0, WebRequest.isCanceled(..), WebRequest.getResponseCode(..), WebRequest.getResponseHeaders(..), p7);
        _currentRequest = 0;
        new FileOutputStream(..).close();
        DeviceLog.exception("Error closing stream", WebRequest.isCanceled(..));
        WebRequest.isCanceled(..).getMessage();
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, 3);
      L_14a:
      L_15b:
      L_16b:
      L_17b:
      L_18b:
      L_19b:
      L_1ab:
      L_1b9:
      L_1c6:
        DeviceLog.exception("Unknown error", CacheEvent.DOWNLOAD_ERROR);
        _active = WebRequest.getContentLength(..);
        CacheEvent.DOWNLOAD_ERROR.getMessage();
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, WebRequest.makeStreamRequest(..));
        _currentRequest = new FileOutputStream(..);
        if (if-eqz(new FileOutputStream(..))) goto L_361;
        new FileOutputStream(..).close();
        DeviceLog.exception(WebRequest.getResponseHeaders(..), Exception.getMessage(..));
        Exception.getMessage(..).getMessage();
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, WebRequest.getResponseHeaders(..));
      L_20d:
        DeviceLog.exception("Network error", CacheEvent.DOWNLOAD_ERROR);
        _active = WebRequest.getContentLength(..);
        CacheEvent.DOWNLOAD_ERROR.getMessage();
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, WebRequest.makeStreamRequest(..));
        _currentRequest = new FileOutputStream(..);
        if (if-eqz(new FileOutputStream(..))) goto L_361;
        new FileOutputStream(..).close();
        DeviceLog.exception(WebRequest.getResponseHeaders(..), NetworkIOException.getMessage(..));
        NetworkIOException.getMessage(..).getMessage();
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, WebRequest.getResponseHeaders(..));
      L_254:
        DeviceLog.exception("Illegal state", CacheEvent.DOWNLOAD_ERROR);
        _active = WebRequest.getContentLength(..);
        CacheEvent.DOWNLOAD_ERROR.getMessage();
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, WebRequest.makeStreamRequest(..));
        _currentRequest = new FileOutputStream(..);
        if (if-eqz(new FileOutputStream(..))) goto L_361;
        new FileOutputStream(..).close();
        DeviceLog.exception(WebRequest.getResponseHeaders(..), IllegalStateException.getMessage(..));
        IllegalStateException.getMessage(..).getMessage();
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, WebRequest.getResponseHeaders(..));
      L_29b:
        DeviceLog.exception("Couldn't request stream", CacheEvent.DOWNLOAD_ERROR);
        _active = WebRequest.getContentLength(..);
        CacheEvent.DOWNLOAD_ERROR.getMessage();
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, WebRequest.makeStreamRequest(..));
        _currentRequest = new FileOutputStream(..);
        if (if-eqz(new FileOutputStream(..))) goto L_361;
        new FileOutputStream(..).close();
        DeviceLog.exception(WebRequest.getResponseHeaders(..), IOException.getMessage(..));
        IOException.getMessage(..).getMessage();
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, WebRequest.getResponseHeaders(..));
      L_2e2:
        DeviceLog.exception("Malformed URL", CacheEvent.DOWNLOAD_ERROR);
        _active = WebRequest.getContentLength(..);
        CacheEvent.DOWNLOAD_ERROR.getMessage();
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, WebRequest.makeStreamRequest(..));
        _currentRequest = new FileOutputStream(..);
        if (if-eqz(new FileOutputStream(..))) goto L_361;
        new FileOutputStream(..).close();
        DeviceLog.exception(WebRequest.getResponseHeaders(..), MalformedURLException.getMessage(..));
        MalformedURLException.getMessage(..).getMessage();
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, WebRequest.getResponseHeaders(..));
      L_327:
        DeviceLog.exception("Couldn't create target file", CacheEvent.DOWNLOAD_ERROR);
        _active = WebRequest.getContentLength(..);
        CacheEvent.DOWNLOAD_ERROR.getMessage();
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, WebRequest.makeStreamRequest(..));
        _currentRequest = new FileOutputStream(..);
        if (if-eqz(new FileOutputStream(..))) goto L_361;
        new FileOutputStream(..).close();
        DeviceLog.exception(WebRequest.getResponseHeaders(..), FileNotFoundException.getMessage(..));
        FileNotFoundException.getMessage(..).getMessage();
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, WebRequest.getResponseHeaders(..));
      L_361:
        return;
      L_365:
        _currentRequest = new FileOutputStream(..);
        if (if-eqz(new FileOutputStream(..))) goto L_385;
        new FileOutputStream(..).close();
        DeviceLog.exception(WebRequest.getResponseHeaders(..), CacheEvent.DOWNLOAD_ERROR);
        CacheEvent.DOWNLOAD_ERROR.getMessage();
        p7.sendEvent(CacheEvent.DOWNLOAD_ERROR, WebRequest.getResponseHeaders(..));
      L_385:
        throw FileNotFoundException.getMessage(..);
      L_386:
        return;
    }

    private WebRequest getWebRequest(String p0, int p1, int p2, HashMap p3) {
        new HashMap();
        if (if-eqz(p3)) goto L_a;
        new HashMap(..).putAll(p3);
      L_a:
        new WebRequest(p0, "GET", new HashMap(..), p1, p2);
        return new WebRequest;
    }

    private void postProcessDownload(long p0, String p1, File p2, long p3, long p4, boolean p5, int p6, Map p7, CacheEventSender p8) {
        SystemClock.elapsedRealtime();
        p2.setReadable(1, 0);
        if (if-nez(File.setReadable(..))) goto L_19;
        DeviceLog.debug("Unity Ads cache: could not set file readable!");
      L_19:
        if (if-nez(p5)) goto L_74;
        new StringBuilder("Unity Ads cache: File ");
        p2.getName();
        new StringBuilder(..).append(File.getName(..));
        new StringBuilder(..).append(" of ");
        new StringBuilder(..).append(p3, v14);
        new StringBuilder(..).append(" bytes downloaded in ");
        new StringBuilder(..).append(SystemClock.elapsedRealtime(..), v3);
        new StringBuilder(..).append("ms");
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        Long.valueOf(p3, v21);
        Long.valueOf(p4, v23);
        Long.valueOf(SystemClock.elapsedRealtime(..), v3);
        Integer.valueOf(p6);
        Request.getResponseHeadersMap(p7);
        p8.sendEvent(CacheEvent.DOWNLOAD_END, 6);
      L_74:
        new StringBuilder("Unity Ads cache: downloading of ");
        new StringBuilder(..).append(Request.getResponseHeadersMap(..));
        new StringBuilder(..).append(" stopped");
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        Long.valueOf(p3, v21);
        Long.valueOf(p4, v23);
        Long.valueOf(SystemClock.elapsedRealtime(..), v3);
        Integer.valueOf(p6);
        Request.getResponseHeadersMap(p7);
        p8.sendEvent(CacheEvent.DOWNLOAD_STOPPED, 6);
      L_b3:
        return;
    }

    public void handleMessage(Message p0) {
        p0.getData();
        Message.getData(..).getString("source");
        Message.getData(..).remove("source");
        Message.getData(..).getString("target");
        Message.getData(..).remove("target");
        Message.getData(..).getInt("connectTimeout");
        Message.getData(..).remove("connectTimeout");
        Message.getData(..).getInt("readTimeout");
        Message.getData(..).remove("readTimeout");
        Message.getData(..).getInt("progressInterval");
        Message.getData(..).remove("progressInterval");
        Message.getData(..).getBoolean("append", 0);
        Message.getData(..).remove("append");
        Message.getData(..).getSerializable("cacheEventSender");
        Message.getData(..).remove("cacheEventSender");
        Message.getData(..).size();
        if (if-lez(Bundle.size(..))) goto L_79;
        DeviceLog.debug("There are headers left in data, reading them");
        new HashMap();
        Message.getData(..).keySet();
        Bundle.keySet(..).iterator();
      L_5f:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_77;
        Set.iterator(..).next();
        Message.getData(..).getStringArray(Iterator.next(..));
        Arrays.asList(Bundle.getStringArray(..));
        new HashMap(..).put(Iterator.next(..), Arrays.asList(..));
      L_77:
      L_79:
      L_7b:
        new File(Bundle.getString(..));
        if (if-eqz(Bundle.getBoolean(..))) goto L_89;
        new File(..).exists();
        if (if-eqz(File.exists(..))) goto L_91;
      L_89:
        if (if-nez(Bundle.getBoolean(..))) goto L_b7;
        new File(..).exists();
        if (if-eqz(File.exists(..))) goto L_b7;
      L_91:
        _active = 0;
        Boolean.valueOf(Bundle.getBoolean(..));
        new File(..).exists();
        Boolean.valueOf(File.exists(..));
        Bundle.getSerializable(..).sendEvent(CacheEvent.DOWNLOAD_ERROR, 5);
        return;
      L_b7:
        if (if-eq(what, 4)) goto L_bc;
      L_bc:
        CacheThreadHandler.downloadFile(Bundle.getString(..), Bundle.getString(..), 5, CacheError.FILE_STATE_WRONG, Bundle.getInt(..), 0, Bundle.getBoolean(..), Bundle.getSerializable(..));
      L_c0:
        return;
    }

    public boolean isActive() {
        return _active;
    }

    public void setCancelStatus(boolean p0) {
        _canceled = p0;
        if (if-eqz(p0)) goto L_e;
        if (if-eqz(_currentRequest)) goto L_e;
        _active = 0;
        _currentRequest.cancel();
      L_e:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.cache.CacheThreadHandler$1
// ============================================================
package com.unity3d.services.core.cache;

class CacheThreadHandler$1 {
    private long lastProgressEventTime;
    final CacheThreadHandler this$0;
    final CacheEventSender val$cacheThreadBinder;
    final int val$progressInterval;
    final File val$targetFile;

    CacheThreadHandler$1(CacheThreadHandler p0, CacheEventSender p1, File p2, int p3) {
        this$0 = p0;
        val$cacheThreadBinder = p1;
        val$targetFile = p2;
        val$progressInterval = p3;
        new Object();
        System.currentTimeMillis();
        lastProgressEventTime = System.currentTimeMillis(..);
        return;
    }

    public void onRequestProgress(String p0, long p1, long p2) {
        if (if-lez(val$progressInterval)) goto L_33;
        System.currentTimeMillis();
        if (if-lez(System.currentTimeMillis(..))) goto L_33;
        System.currentTimeMillis();
        lastProgressEventTime = System.currentTimeMillis(..);
        Long.valueOf(p1, v7);
        Long.valueOf(p2, v9);
        CacheEventSender.sendEvent(CacheEvent.DOWNLOAD_PROGRESS, 3);
      L_33:
        return;
    }

    public void onRequestStart(String p0, long p1, int p2, Map p3) {
        File.length();
        Long.valueOf(File.length(..), v4);
        File.length();
        Long.valueOf(p1, v8);
        Integer.valueOf(p2);
        Request.getResponseHeadersMap(p3);
        CacheEventSender.sendEvent(CacheEvent.DOWNLOAD_STARTED, 5);
        return;
    }

}

