
// ===== FILE: com/unity3d/services/core/cache/CacheDirectory.java =====
package com.unity3d.services.core.cache;

import android.content.Context;
import android.os.Environment;
import com.unity3d.services.core.log.DeviceLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public class CacheDirectory {
    private static final String TEST_FILE_NAME = "UnityAdsTest.txt";
    private String _cacheDirName;
    private File _cacheDirectory;
    private boolean _initialized;
    private final boolean _preferExternalStorage;
    private CacheDirectoryType _type;

    public CacheDirectory(String str) {
        this._initialized = false;
        this._cacheDirectory = null;
        this._type = null;
        this._cacheDirName = str;
        this._preferExternalStorage = true;
    }

    public CacheDirectory(String str, boolean z) {
        this._initialized = false;
        this._cacheDirectory = null;
        this._type = null;
        this._preferExternalStorage = z;
        this._cacheDirName = str;
    }

    public synchronized File getCacheDirectory(Context context) {
        if (context == null) {
            return null;
        }
        if (this._initialized) {
            return this._cacheDirectory;
        }
        this._initialized = true;
        if (this._preferExternalStorage) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                try {
                    File createCacheDirectory = createCacheDirectory(context.getExternalCacheDir(), this._cacheDirName);
                    if (testCacheDirectory(createCacheDirectory)) {
                        createNoMediaFile(createCacheDirectory);
                        this._cacheDirectory = createCacheDirectory;
                        this._type = CacheDirectoryType.EXTERNAL;
                        DeviceLog.debug("Unity Ads is using external cache directory: " + createCacheDirectory.getAbsolutePath());
                        return this._cacheDirectory;
                    }
                } catch (Exception e) {
                    DeviceLog.exception("Creating external cache directory failed", e);
                    return null;
                }
            } else {
                DeviceLog.debug("External media not mounted");
            }
        }
        File createCacheDirectory2 = createCacheDirectory(context.getNoBackupFilesDir(), this._cacheDirName);
        if (testCacheDirectory(createCacheDirectory2)) {
            this._cacheDirectory = createCacheDirectory2;
            this._type = CacheDirectoryType.INTERNAL;
            DeviceLog.debug("Unity Ads is using internal cache directory: " + createCacheDirectory2.getAbsolutePath());
            return this._cacheDirectory;
        }
        DeviceLog.error("Unity Ads failed to initialize cache directory");
        return null;
    }

    public CacheDirectoryType getType() {
        return this._type;
    }

    public File createCacheDirectory(File file, String str) {
        if (file == null) {
            return null;
        }
        File file2 = new File(file, str);
        file2.mkdirs();
        if (file2.isDirectory()) {
            return file2;
        }
        return null;
    }

    public boolean testCacheDirectory(File file) {
        if (file != null && file.isDirectory()) {
            try {
                byte[] bytes = "test".getBytes("UTF-8");
                int length = bytes.length;
                byte[] bArr = new byte[length];
                File file2 = new File(file, TEST_FILE_NAME);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(bytes);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    try {
                        int read = fileInputStream.read(bArr, 0, length);
                        fileInputStream.close();
                        if (!file2.delete()) {
                            DeviceLog.debug("Failed to delete testfile " + file2.getAbsoluteFile());
                            return false;
                        }
                        if (read != length) {
                            DeviceLog.debug("Read buffer size mismatch");
                            return false;
                        }
                        if (new String(bArr, "UTF-8").equals("test")) {
                            return true;
                        }
                        DeviceLog.debug("Read buffer content mismatch");
                        return false;
                    } finally {
                    }
                } finally {
                }
            } catch (Exception e) {
                DeviceLog.debug("Unity Ads exception while testing cache directory " + file.getAbsolutePath() + ": " + e.getMessage());
            }
        }
        return false;
    }

    private void createNoMediaFile(File file) {
        try {
            if (new File(file, ".nomedia").createNewFile()) {
                DeviceLog.debug("Successfully created .nomedia file");
            } else {
                DeviceLog.debug("Using existing .nomedia file");
            }
        } catch (Exception e) {
            DeviceLog.exception("Failed to create .nomedia file", e);
        }
    }
}

// ===== FILE: com/unity3d/services/core/cache/CacheDirectoryType.java =====
package com.unity3d.services.core.cache;

/* loaded from: classes.dex */
public enum CacheDirectoryType {
    EXTERNAL,
    INTERNAL
}

// ===== FILE: com/unity3d/services/core/cache/CacheError.java =====
package com.unity3d.services.core.cache;

/* loaded from: classes.dex */
public enum CacheError {
    FILE_IO_ERROR,
    FILE_NOT_FOUND,
    FILE_ALREADY_CACHING,
    NOT_CACHING,
    JSON_ERROR,
    NO_INTERNET,
    MALFORMED_URL,
    NETWORK_ERROR,
    ILLEGAL_STATE,
    INVALID_ARGUMENT,
    UNSUPPORTED_ENCODING,
    FILE_STATE_WRONG,
    CACHE_DIRECTORY_NULL,
    CACHE_DIRECTORY_TYPE_NULL,
    CACHE_DIRECTORY_EXISTS,
    CACHE_DIRECTORY_DOESNT_EXIST,
    UNKNOWN_ERROR
}

// ===== FILE: com/unity3d/services/core/cache/CacheEvent.java =====
package com.unity3d.services.core.cache;

/* loaded from: classes.dex */
public enum CacheEvent {
    DOWNLOAD_STARTED,
    DOWNLOAD_PROGRESS,
    DOWNLOAD_END,
    DOWNLOAD_STOPPED,
    DOWNLOAD_ERROR
}

// ===== FILE: com/unity3d/services/core/cache/CacheEventSender.java =====
package com.unity3d.services.core.cache;

import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CacheEventSender.kt */
@Metadata(m443d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J'\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m444d2 = {"Lcom/unity3d/services/core/cache/CacheEventSender;", "Ljava/io/Serializable;", "eventSender", "Lcom/unity3d/services/core/webview/bridge/IEventSender;", "(Lcom/unity3d/services/core/webview/bridge/IEventSender;)V", "sendEvent", "", "eventId", "Lcom/unity3d/services/core/cache/CacheEvent;", "params", "", "", "(Lcom/unity3d/services/core/cache/CacheEvent;[Ljava/lang/Object;)Z", "unity-ads_release"}, m445k = 1, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class CacheEventSender implements Serializable {
    private final IEventSender eventSender;

    public CacheEventSender(IEventSender eventSender) {
        Intrinsics.checkNotNullParameter(eventSender, "eventSender");
        this.eventSender = eventSender;
    }

    public final boolean sendEvent(CacheEvent eventId, Object... params) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(params, "params");
        return this.eventSender.sendEvent(WebViewEventCategory.CACHE, eventId, Arrays.copyOf(params, params.length));
    }
}

// ===== FILE: com/unity3d/services/core/cache/CacheThread.java =====
package com.unity3d.services.core.cache;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.bridge.IEventSender;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class CacheThread extends Thread {
    public static final int MSG_DOWNLOAD = 1;
    private static int _connectTimeout = 30000;
    private static CacheThreadHandler _handler = null;
    private static int _progressInterval = 0;
    private static int _readTimeout = 30000;
    private static boolean _ready;
    private static final Object _readyLock = new Object();

    private static void init() {
        CacheThread cacheThread = new CacheThread();
        cacheThread.setName("UnityAdsCacheThread");
        cacheThread.start();
        while (!_ready) {
            try {
                Object obj = _readyLock;
                synchronized (obj) {
                    obj.wait();
                }
            } catch (InterruptedException unused) {
                DeviceLog.debug("Couldn't synchronize thread");
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        _handler = new CacheThreadHandler();
        _ready = true;
        Object obj = _readyLock;
        synchronized (obj) {
            obj.notifyAll();
        }
        Looper.loop();
    }

    public static synchronized void download(String str, String str2, HashMap<String, List<String>> hashMap, boolean z, IEventSender iEventSender) {
        synchronized (CacheThread.class) {
            if (!_ready) {
                init();
            }
            Bundle bundle = new Bundle();
            bundle.putString("source", str);
            bundle.putString(TypedValues.AttributesType.S_TARGET, str2);
            bundle.putInt("connectTimeout", _connectTimeout);
            bundle.putInt("readTimeout", _readTimeout);
            bundle.putInt("progressInterval", _progressInterval);
            bundle.putBoolean("append", z);
            bundle.putSerializable("cacheEventSender", new CacheEventSender(iEventSender));
            if (hashMap != null) {
                for (String str3 : hashMap.keySet()) {
                    bundle.putStringArray(str3, (String[]) hashMap.get(str3).toArray(new String[hashMap.get(str3).size()]));
                }
            }
            Message message = new Message();
            message.what = 1;
            message.setData(bundle);
            _handler.setCancelStatus(false);
            _handler.sendMessage(message);
        }
    }

    public static boolean isActive() {
        if (_ready) {
            return _handler.isActive();
        }
        return false;
    }

    public static void cancel() {
        if (_ready) {
            _handler.removeMessages(1);
            _handler.setCancelStatus(true);
        }
    }

    public static void setProgressInterval(int i) {
        _progressInterval = i;
    }

    public static int getProgressInterval() {
        return _progressInterval;
    }

    public static void setConnectTimeout(int i) {
        _connectTimeout = i;
    }

    public static void setReadTimeout(int i) {
        _readTimeout = i;
    }

    public static int getConnectTimeout() {
        return _connectTimeout;
    }

    public static int getReadTimeout() {
        return _readTimeout;
    }
}

// ===== FILE: com/unity3d/services/core/cache/CacheThreadHandler.java =====
package com.unity3d.services.core.cache;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.unity3d.services.core.api.Request;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.request.WebRequest;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class CacheThreadHandler extends Handler {
    private WebRequest _currentRequest = null;
    private boolean _canceled = false;
    private boolean _active = false;

    CacheThreadHandler() {
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HashMap<String, List<String>> hashMap;
        Bundle data = message.getData();
        String string = data.getString("source");
        data.remove("source");
        String string2 = data.getString(TypedValues.AttributesType.S_TARGET);
        data.remove(TypedValues.AttributesType.S_TARGET);
        int i = data.getInt("connectTimeout");
        data.remove("connectTimeout");
        int i2 = data.getInt("readTimeout");
        data.remove("readTimeout");
        int i3 = data.getInt("progressInterval");
        data.remove("progressInterval");
        boolean z = data.getBoolean("append", false);
        data.remove("append");
        CacheEventSender cacheEventSender = (CacheEventSender) data.getSerializable("cacheEventSender");
        data.remove("cacheEventSender");
        if (data.size() > 0) {
            DeviceLog.debug("There are headers left in data, reading them");
            HashMap<String, List<String>> hashMap2 = new HashMap<>();
            for (String str : data.keySet()) {
                hashMap2.put(str, Arrays.asList(data.getStringArray(str)));
            }
            hashMap = hashMap2;
        } else {
            hashMap = null;
        }
        File file = new File(string2);
        if ((z && !file.exists()) || (!z && file.exists())) {
            this._active = false;
            cacheEventSender.sendEvent(CacheEvent.DOWNLOAD_ERROR, CacheError.FILE_STATE_WRONG, string, string2, Boolean.valueOf(z), Boolean.valueOf(file.exists()));
        } else {
            if (message.what != 1) {
                return;
            }
            downloadFile(string, string2, i, i2, i3, hashMap, z, cacheEventSender);
        }
    }

    public void setCancelStatus(boolean z) {
        WebRequest webRequest;
        this._canceled = z;
        if (!z || (webRequest = this._currentRequest) == null) {
            return;
        }
        this._active = false;
        webRequest.cancel();
    }

    public boolean isActive() {
        return this._active;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private void downloadFile(java.lang.String r25, java.lang.String r26, int r27, int r28, int r29, java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> r30, boolean r31, com.unity3d.services.core.cache.CacheEventSender r32) {
        /*
            Method dump skipped, instructions count: 903
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.cache.CacheThreadHandler.downloadFile(java.lang.String, java.lang.String, int, int, int, java.util.HashMap, boolean, com.unity3d.services.core.cache.CacheEventSender):void");
    }

    private void postProcessDownload(long j, String str, File file, long j2, long j3, boolean z, int i, Map<String, List<String>> map, CacheEventSender cacheEventSender) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (!file.setReadable(true, false)) {
            DeviceLog.debug("Unity Ads cache: could not set file readable!");
        }
        if (!z) {
            DeviceLog.debug("Unity Ads cache: File " + file.getName() + " of " + j2 + " bytes downloaded in " + elapsedRealtime + "ms");
            cacheEventSender.sendEvent(CacheEvent.DOWNLOAD_END, str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(elapsedRealtime), Integer.valueOf(i), Request.getResponseHeadersMap(map));
            return;
        }
        DeviceLog.debug("Unity Ads cache: downloading of " + str + " stopped");
        cacheEventSender.sendEvent(CacheEvent.DOWNLOAD_STOPPED, str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(elapsedRealtime), Integer.valueOf(i), Request.getResponseHeadersMap(map));
    }

    private WebRequest getWebRequest(String str, int i, int i2, HashMap<String, List<String>> hashMap) throws MalformedURLException {
        HashMap hashMap2 = new HashMap();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        return new WebRequest(str, ShareTarget.METHOD_GET, hashMap2, i, i2);
    }
}
