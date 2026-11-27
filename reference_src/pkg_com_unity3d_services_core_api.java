// Package bundle: com.unity3d.services.core.api (25 classes)

// ============================================================
// CLASS: com.unity3d.services.core.api.Broadcast
// ============================================================
package com.unity3d.services.core.api;

public class Broadcast {
    public Broadcast() {
        new Object();
        return;
    }

    public static void addBroadcastListener(String p0, String p1, JSONArray p2, WebViewCallback p3) {
        p2.length();
        if (if-lez(JSONArray.length(..))) goto L_24;
        p2.length();
      L_e:
        p2.length();
        if (if-ge(0, JSONArray.length(..))) goto L_1d;
        p2.getString(0);
      L_1d:
        BroadcastMonitor.getInstance();
        BroadcastMonitor.getInstance(..).addBroadcastListener(p0, p1, JSONArray.length(..));
      L_24:
        p3.invoke(p0);
        return;
        p3.error(BroadcastError.JSON_ERROR, p1);
        return;
    }

    public static void addBroadcastListener(String p0, JSONArray p1, WebViewCallback p2) {
        Broadcast.addBroadcastListener(p0, 0, p1, p2);
        return;
    }

    public static void removeAllBroadcastListeners(WebViewCallback p0) {
        BroadcastMonitor.getInstance();
        BroadcastMonitor.getInstance(..).removeAllBroadcastListeners();
        p0.invoke(0);
        return;
    }

    public static void removeBroadcastListener(String p0, WebViewCallback p1) {
        BroadcastMonitor.getInstance();
        BroadcastMonitor.getInstance(..).removeBroadcastListener(p0);
        p1.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Cache
// ============================================================
package com.unity3d.services.core.api;

public class Cache {
    public Cache() {
        new Object();
        return;
    }

    public static void deleteFile(String p0, WebViewCallback p1) {
        Cache.fileIdToFilename(p0);
        new File(Cache.fileIdToFilename(..));
        new File(..).delete();
        if (if-eqz(File.delete(..))) goto L_16;
        p1.invoke(File.delete(..));
      L_16:
        p1.error(CacheError.FILE_IO_ERROR, 0);
      L_1d:
        return;
    }

    public static void download(String p0, String p1, JSONArray p2, Boolean p3, WebViewCallback p4) {
        CacheThread.isActive();
        if (if-eqz(CacheThread.isActive(..))) goto L_f;
        p4.error(CacheError.FILE_ALREADY_CACHING, p1);
        return;
      L_f:
        Device.isActiveNetworkConnected();
        if (if-nez(Device.isActiveNetworkConnected(..))) goto L_1d;
        p4.error(CacheError.NO_INTERNET, p1);
        return;
      L_1d:
        Request.getHeadersMap(p2);
        Cache.fileIdToFilename(p1);
        p3.booleanValue();
        SharedInstances.INSTANCE.getWebViewEventSender();
        CacheThread.download(CacheError.NO_INTERNET, Cache.fileIdToFilename(..), Request.getHeadersMap(..), Boolean.booleanValue(..), SharedInstances.getWebViewEventSender(..));
        p4.invoke(CacheError.NO_INTERNET);
        return;
        DeviceLog.exception("Error mapping headers for the request", Request.getHeadersMap(..));
        p4.error(WebRequestError.MAPPING_HEADERS_FAILED, 2);
        return;
    }

    private static String fileIdToFilename(String p0) {
        SdkProperties.getCacheDirectory();
        if (if-nez(SdkProperties.getCacheDirectory(..))) goto L_9;
        return "";
      L_9:
        new StringBuilder();
        SdkProperties.getCacheDirectory();
        new StringBuilder(..).append(SdkProperties.getCacheDirectory(..));
        new StringBuilder(..).append("/");
        SdkProperties.getCacheFilePrefix();
        new StringBuilder(..).append(SdkProperties.getCacheFilePrefix(..));
        new StringBuilder(..).append("");
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    public static void getCacheDirectoryExists(WebViewCallback p0) {
        SdkProperties.getCacheDirectory();
        if (if-nez(SdkProperties.getCacheDirectory(..))) goto L_f;
        p0.error(CacheError.CACHE_DIRECTORY_NULL, 0);
        return;
      L_f:
        CacheError.CACHE_DIRECTORY_NULL.exists();
        Boolean.valueOf(File.exists(..));
        p0.invoke(1);
        return;
    }

    public static void getCacheDirectoryType(WebViewCallback p0) {
        SdkProperties.getCacheDirectoryObject();
        if (if-eqz(SdkProperties.getCacheDirectoryObject(..))) goto L_43;
        ClientProperties.getApplicationContext();
        CacheDirectory.getCacheDirectory(ClientProperties.getApplicationContext(..));
        if (if-nez(CacheDirectory.getCacheDirectory(..))) goto L_12;
      L_12:
        ClientProperties.getApplicationContext();
        CacheDirectory.getCacheDirectory(ClientProperties.getApplicationContext(..));
        CacheDirectory.getCacheDirectory(..).exists();
        if (if-nez(File.exists(..))) goto L_28;
        p0.error(CacheError.CACHE_DIRECTORY_DOESNT_EXIST, 0);
        return;
      L_28:
        CacheDirectory.getType();
        if (if-nez(CacheDirectory.getType(..))) goto L_36;
        p0.error(CacheError.CACHE_DIRECTORY_TYPE_NULL, 0);
        return;
      L_36:
        CacheError.CACHE_DIRECTORY_TYPE_NULL.name();
        p0.invoke(1);
        return;
      L_43:
        p0.error(CacheError.CACHE_DIRECTORY_NULL, 0);
        return;
    }

    public static void getFileContent(String p0, String p1, WebViewCallback p2) {
        Cache.fileIdToFilename(p0);
        new File(Cache.fileIdToFilename(..));
        new File(..).exists();
        if (if-nez(File.exists(..))) goto L_1e;
        p2.error(CacheError.FILE_NOT_FOUND, new File(..));
        return;
      L_1e:
        Utilities.readFileBytes(new File(..));
        if (if-nez(CacheError.FILE_NOT_FOUND)) goto L_33;
        p2.error(CacheError.UNSUPPORTED_ENCODING, 3);
        return;
      L_33:
        CacheError.FILE_NOT_FOUND.equals("UTF-8");
        if (if-eqz(String.equals(..))) goto L_4c;
        ByteBuffer.wrap(CacheError.UNSUPPORTED_ENCODING);
        Charset.forName("UTF-8");
        Charset.forName(..).decode(ByteBuffer.wrap(..));
        Charset.decode(..).toString();
      L_4c:
        Charset.forName(..).equals("Base64");
        if (if-eqz(String.equals(..))) goto L_60;
        Base64.encodeToString(CacheError.UNSUPPORTED_ENCODING, 2);
      L_58:
        p2.invoke(Charset.forName(..));
        return;
      L_60:
        p2.error(CacheError.UNSUPPORTED_ENCODING, 3);
        return;
        new StringBuilder();
        Charset.forName(..).getMessage();
        new StringBuilder(..).append(IOException.getMessage(..));
        new StringBuilder(..).append(", ");
        Charset.forName(..).getClass();
        Object.getClass(..).getName();
        new StringBuilder(..).append(Class.getName(..));
        new StringBuilder(..).toString();
        p2.error(CacheError.FILE_IO_ERROR, 3);
        return;
    }

    public static void getFileInfo(String p0, WebViewCallback p1) {
        Cache.getFileJson(p0);
        p1.invoke(1);
        DeviceLog.exception("Error creating JSON", Cache.getFileJson(..));
        p1.error(CacheError.JSON_ERROR, 0);
      L_1b:
        return;
    }

    private static JSONObject getFileJson(String p0) {
        new JSONObject();
        new JSONObject(..).put("id", p0);
        Cache.fileIdToFilename(p0);
        new File(Cache.fileIdToFilename(..));
        new File(..).exists();
        if (if-eqz(File.exists(..))) goto L_32;
        new JSONObject(..).put("found", 1);
        new File(..).length();
        new JSONObject(..).put("size", File.length(..), v3);
        new File(..).lastModified();
        new JSONObject(..).put("mtime", File.lastModified(..), File.length(..));
      L_32:
        new JSONObject(..).put(File.length(..), 0);
      L_36:
        return new JSONObject(..);
    }

    public static void getFilePath(String p0, WebViewCallback p1) {
        Cache.fileIdToFilename(p0);
        new File(Cache.fileIdToFilename(..));
        new File(..).exists();
        if (if-eqz(File.exists(..))) goto L_1d;
        Cache.fileIdToFilename(p0);
        p1.invoke(1);
      L_1d:
        p1.error(CacheError.FILE_NOT_FOUND, 1);
      L_24:
        return;
    }

    public static void getFiles(WebViewCallback p0) {
        SdkProperties.getCacheDirectory();
        if (if-nez(SdkProperties.getCacheDirectory(..))) goto L_7;
        return;
      L_7:
        DeviceLog.debug("Unity Ads cache: checking app directory for Unity Ads cached files");
        new Cache$1();
        SdkProperties.getCacheDirectory(..).listFiles(new Cache$1(..));
        if (if-eqz(File.listFiles(..))) goto L_1c;
        if (if-nez(v3)) goto L_28;
      L_1c:
        new JSONArray();
        p0.invoke(v3);
      L_28:
        new JSONArray();
      L_2f:
        if (if-ge(0, new JSONArray(..))) goto L_72;
        File.getName();
        SdkProperties.getCacheFilePrefix();
        SdkProperties.getCacheFilePrefix(..).length();
        File.getName(..).substring(String.length(..));
        new StringBuilder();
        new StringBuilder(..).append("Unity Ads cache: found ");
        new StringBuilder(..).append(String.substring(..));
        new StringBuilder(..).append(", ");
        File.length();
        new StringBuilder(..).append(File.length(..), v10);
        new StringBuilder(..).append(" bytes");
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        Cache.getFileJson(String.substring(..));
        new JSONArray(..).put(Cache.getFileJson(..));
      L_72:
        p0.invoke(File.listFiles(..));
        DeviceLog.exception("Error creating JSON", File.listFiles(..));
        p0.error(CacheError.JSON_ERROR, "Error creating JSON");
      L_87:
        return;
    }

    public static void getFreeSpace(WebViewCallback p0) {
        SdkProperties.getCacheDirectory();
        Device.getFreeSpace(SdkProperties.getCacheDirectory(..));
        Long.valueOf(Device.getFreeSpace(..), v2);
        p0.invoke(1);
        return;
    }

    public static void getHash(String p0, WebViewCallback p1) {
        Utilities.Sha256(p0);
        p1.invoke(1);
        return;
    }

    private static SparseArray getMetaData(String p0, JSONArray p1) {
        new File(p0);
        new SparseArray();
        new File(..).exists();
        if (if-eqz(File.exists(..))) goto L_34;
        new MediaMetadataRetriever();
        new File(..).getAbsolutePath();
        new MediaMetadataRetriever(..).setDataSource(File.getAbsolutePath(..));
      L_1d:
        p1.length();
        if (if-ge(0, JSONArray.length(..))) goto L_33;
        p1.getInt(0);
        new MediaMetadataRetriever(..).extractMetadata(JSONArray.getInt(..));
        if (if-eqz(MediaMetadataRetriever.extractMetadata(..))) goto L_30;
        new SparseArray(..).put(JSONArray.getInt(..), MediaMetadataRetriever.extractMetadata(..));
      L_30:
      L_33:
        return new SparseArray(..);
      L_34:
        new StringBuilder("File: ");
        0.getAbsolutePath();
        new StringBuilder(..).append(File.getAbsolutePath(..));
        new StringBuilder(..).append(" doesn't exist");
        new StringBuilder(..).toString();
        new IOException(StringBuilder.toString(..));
        throw new IOException(..);
    }

    public static void getMetaData(String p0, JSONArray p1, WebViewCallback p2) {
        Cache.fileIdToFilename(p0);
        Cache.getMetaData(Cache.fileIdToFilename(..), p1);
        new JSONArray();
      L_10:
        Cache.getMetaData(..).size();
        if (if-ge(0, SparseArray.size(..))) goto L_2f;
        new JSONArray();
        Cache.getMetaData(..).keyAt(0);
        new JSONArray(..).put(SparseArray.keyAt(..));
        Cache.getMetaData(..).valueAt(0);
        new JSONArray(..).put(SparseArray.valueAt(..));
        new JSONArray(..).put(new JSONArray(..));
      L_2f:
        p2.invoke(Cache.getMetaData(..));
        return;
        Cache.getMetaData(..).getMessage();
        p2.error(CacheError.FILE_IO_ERROR, 1);
        return;
        IOException.getMessage(..).getMessage();
        p2.error(CacheError.INVALID_ARGUMENT, 1);
        return;
        RuntimeException.getMessage(..).getMessage();
        p2.error(CacheError.JSON_ERROR, 1);
        return;
    }

    public static void getProgressInterval(WebViewCallback p0) {
        CacheThread.getProgressInterval();
        Integer.valueOf(CacheThread.getProgressInterval(..));
        p0.invoke(1);
        return;
    }

    public static void getTimeouts(WebViewCallback p0) {
        CacheThread.getConnectTimeout();
        Integer.valueOf(CacheThread.getConnectTimeout(..));
        CacheThread.getReadTimeout();
        Integer.valueOf(CacheThread.getReadTimeout(..));
        p0.invoke(2);
        return;
    }

    public static void getTotalSpace(WebViewCallback p0) {
        SdkProperties.getCacheDirectory();
        Device.getTotalSpace(SdkProperties.getCacheDirectory(..));
        Long.valueOf(Device.getTotalSpace(..), v2);
        p0.invoke(1);
        return;
    }

    public static void isCaching(WebViewCallback p0) {
        CacheThread.isActive();
        Boolean.valueOf(CacheThread.isActive(..));
        p0.invoke(1);
        return;
    }

    public static void recreateCacheDirectory(WebViewCallback p0) {
        SdkProperties.getCacheDirectory();
        SdkProperties.getCacheDirectory(..).exists();
        if (if-eqz(File.exists(..))) goto L_13;
        p0.error(CacheError.CACHE_DIRECTORY_EXISTS, 0);
        return;
      L_13:
        SdkProperties.setCacheDirectory(0);
        SdkProperties.getCacheDirectory();
        if (if-nez(SdkProperties.getCacheDirectory(..))) goto L_25;
        p0.error(CacheError.CACHE_DIRECTORY_NULL, 0);
        return;
      L_25:
        p0.invoke(CacheError.CACHE_DIRECTORY_NULL);
        return;
    }

    public static void setFileContent(String p0, String p1, String p2, WebViewCallback p3) {
        Cache.fileIdToFilename(p0);
        p2.getBytes("UTF-8");
        if (if-eqz(p1)) goto L_3a;
        p1.length();
        if (if-lez(String.length(..))) goto L_3a;
        p1.equals("Base64");
        if (if-eqz(String.equals(..))) goto L_25;
        Base64.decode(p2, 2);
      L_25:
        p1.equals("UTF-8");
        if (if-eqz(String.equals(..))) goto L_2c;
      L_2c:
        p3.error(CacheError.UNSUPPORTED_ENCODING, "UTF-8");
        return;
      L_3a:
        new FileOutputStream(Cache.fileIdToFilename(..));
        new FileOutputStream(..).write(Base64.decode(..));
        new FileOutputStream(..).flush();
        new FileOutputStream(..).close();
        DeviceLog.exception("Error closing FileOutputStream", p0);
      L_58:
        p3.error(CacheError.FILE_IO_ERROR, 3);
        if (if-eqz(new FileOutputStream(..))) goto L_82;
        new FileOutputStream(..).close();
      L_6b:
        p3.error(CacheError.FILE_NOT_FOUND, 3);
        if (if-eqz(new FileOutputStream(..))) goto L_82;
        new FileOutputStream(..).close();
        DeviceLog.exception("Error closing FileOutputStream", p0);
      L_82:
      L_83:
        if (if-eqz(0)) goto L_8a;
        p3.invoke(p0);
      L_8a:
        return;
      L_8b:
        if (if-eqz(new FileOutputStream(..))) goto L_95;
        new FileOutputStream(..).close();
        DeviceLog.exception("Error closing FileOutputStream", p1);
      L_95:
        throw p0;
        p3.error(CacheError.UNSUPPORTED_ENCODING, CacheError.FILE_NOT_FOUND);
        return;
    }

    public static void setProgressInterval(Integer p0, WebViewCallback p1) {
        p0.intValue();
        CacheThread.setProgressInterval(Integer.intValue(..));
        p1.invoke(0);
        return;
    }

    public static void setTimeouts(Integer p0, Integer p1, WebViewCallback p2) {
        p0.intValue();
        CacheThread.setConnectTimeout(Integer.intValue(..));
        p1.intValue();
        CacheThread.setReadTimeout(Integer.intValue(..));
        p2.invoke(0);
        return;
    }

    public static void stop(WebViewCallback p0) {
        CacheThread.isActive();
        if (if-nez(CacheThread.isActive(..))) goto L_f;
        p0.error(CacheError.NOT_CACHING, 0);
        return;
      L_f:
        CacheThread.cancel();
        p0.invoke(CacheError.NOT_CACHING);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.ClassDetection
// ============================================================
package com.unity3d.services.core.api;

public class ClassDetection {
    public ClassDetection() {
        new Object();
        return;
    }

    public static void isMadeWithUnity(WebViewCallback p0) {
        MadeWithUnityDetector.isMadeWithUnity();
        Boolean.valueOf(MadeWithUnityDetector.isMadeWithUnity(..));
        p0.invoke(1);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Connectivity
// ============================================================
package com.unity3d.services.core.api;

public class Connectivity {
    public Connectivity() {
        new Object();
        return;
    }

    public static void setConnectionMonitoring(Boolean p0, WebViewCallback p1) {
        p0.booleanValue();
        ConnectivityMonitor.setConnectionMonitoring(Boolean.booleanValue(..));
        p1.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.DeviceInfo
// ============================================================
package com.unity3d.services.core.api;

public class DeviceInfo {
    private static final VolumeChangeMonitor volumeChangeMonitor;

    static <clinit>() {
        Utilities.getService(VolumeChangeMonitor.class);
        volumeChangeMonitor = Utilities.getService(..);
        return;
    }

    public DeviceInfo() {
        new Object();
        return;
    }

    public static void getAdvertisingTrackingId(WebViewCallback p0) {
        Device.getAdvertisingTrackingId();
        p0.invoke(1);
        return;
    }

    public static void getApiLevel(WebViewCallback p0) {
        Device.getApiLevel();
        Integer.valueOf(Device.getApiLevel(..));
        p0.invoke(1);
        return;
    }

    public static void getApkDigest(WebViewCallback p0) {
        Device.getApkDigest();
        p0.invoke(v2);
        Exception.toString();
        p0.error(DeviceError.COULDNT_GET_DIGEST, 1);
      L_1c:
        return;
    }

    public static void getBatteryLevel(WebViewCallback p0) {
        Device.getBatteryLevel();
        Float.valueOf(Device.getBatteryLevel(..));
        p0.invoke(1);
        return;
    }

    public static void getBatteryStatus(WebViewCallback p0) {
        Device.getBatteryStatus();
        Integer.valueOf(Device.getBatteryStatus(..));
        p0.invoke(1);
        return;
    }

    public static void getBoard(WebViewCallback p0) {
        Device.getBoard();
        p0.invoke(1);
        return;
    }

    public static void getBootloader(WebViewCallback p0) {
        Device.getBootloader();
        p0.invoke(1);
        return;
    }

    public static void getBrand(WebViewCallback p0) {
        Device.getBrand();
        p0.invoke(1);
        return;
    }

    public static void getBuildId(WebViewCallback p0) {
        Device.getBuildId();
        p0.invoke(1);
        return;
    }

    public static void getBuildVersionIncremental(WebViewCallback p0) {
        Device.getBuildVersionIncremental();
        p0.invoke(1);
        return;
    }

    public static void getCPUCount(WebViewCallback p0) {
        Device.getCPUCount();
        Long.valueOf(Device.getCPUCount(..), v2);
        p0.invoke(1);
        return;
    }

    public static void getCertificateFingerprint(WebViewCallback p0) {
        Device.getCertificateFingerprint();
        if (if-eqz(Device.getCertificateFingerprint(..))) goto L_10;
        p0.invoke(1);
      L_10:
        p0.error(DeviceError.COULDNT_GET_FINGERPRINT, 0);
      L_17:
        return;
    }

    public static void getConnectionType(WebViewCallback p0) {
        Device.getConnectionType();
        p0.invoke(1);
        return;
    }

    public static void getDevice(WebViewCallback p0) {
        Device.getDevice();
        p0.invoke(1);
        return;
    }

    public static void getDeviceMaxVolume(Integer p0, WebViewCallback p1) {
        p0.intValue();
        Device.getStreamMaxVolume(Integer.intValue(..));
        if (if-le(Device.getStreamMaxVolume(..), -1)) goto L_19;
        Integer.valueOf(Device.getStreamMaxVolume(..));
        p1.invoke(1);
      L_19:
        if (if-eq(Integer.valueOf(..), -2)) goto L_3e;
        if (if-eq(Integer.valueOf(..), -1)) goto L_30;
        new StringBuilder("Unhandled deviceMaxVolume error: ");
        new StringBuilder(..).append(Integer.valueOf(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
      L_30:
        Integer.valueOf(StringBuilder.toString(..));
        new StringBuilder(..).error(DeviceError.APPLICATION_CONTEXT_NULL, 1);
      L_3e:
        Integer.valueOf(Integer.valueOf(..));
        new StringBuilder(..).error(DeviceError.AUDIOMANAGER_NULL, 1);
      L_4b:
        return;
    }

    public static void getDeviceVolume(Integer p0, WebViewCallback p1) {
        p0.intValue();
        Device.getStreamVolume(Integer.intValue(..));
        if (if-le(Device.getStreamVolume(..), -1)) goto L_19;
        Integer.valueOf(Device.getStreamVolume(..));
        p1.invoke(1);
      L_19:
        if (if-eq(Integer.valueOf(..), -2)) goto L_3e;
        if (if-eq(Integer.valueOf(..), -1)) goto L_30;
        new StringBuilder("Unhandled deviceVolume error: ");
        new StringBuilder(..).append(Integer.valueOf(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
      L_30:
        Integer.valueOf(StringBuilder.toString(..));
        new StringBuilder(..).error(DeviceError.APPLICATION_CONTEXT_NULL, 1);
      L_3e:
        Integer.valueOf(Integer.valueOf(..));
        new StringBuilder(..).error(DeviceError.AUDIOMANAGER_NULL, 1);
      L_4b:
        return;
    }

    public static void getDisplayMetricDensity(WebViewCallback p0) {
        Device.getDisplayMetricDensity();
        Float.valueOf(Device.getDisplayMetricDensity(..));
        p0.invoke(1);
        return;
    }

    public static void getElapsedRealtime(WebViewCallback p0) {
        Device.getElapsedRealtime();
        Long.valueOf(Device.getElapsedRealtime(..), v2);
        p0.invoke(1);
        return;
    }

    public static void getExtensionVersion(WebViewCallback p0) {
        Device.getExtensionVersion();
        Integer.valueOf(Device.getExtensionVersion(..));
        p0.invoke(1);
        return;
    }

    private static File getFileForStorageType(DeviceInfo$StorageType p0) {
        p0.ordinal();
        if (if-eq(DeviceInfo$1.$SwitchMap$com$unity3d$services$core$api$DeviceInfo$StorageType, 1)) goto L_2a;
        if (if-eq(DeviceInfo$1.$SwitchMap$com$unity3d$services$core$api$DeviceInfo$StorageType, 2)) goto L_21;
        new StringBuilder("Unhandled storagetype: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
        return 0;
      L_21:
        ClientProperties.getApplicationContext();
        Context.getExternalCacheDir();
        return Context.getExternalCacheDir(..);
      L_2a:
        ClientProperties.getApplicationContext();
        Context.getCacheDir();
        return Context.getCacheDir(..);
    }

    public static void getFingerprint(WebViewCallback p0) {
        Device.getFingerprint();
        p0.invoke(1);
        return;
    }

    public static void getFreeMemory(WebViewCallback p0) {
        Device.getFreeMemory();
        Long.valueOf(Device.getFreeMemory(..), v2);
        p0.invoke(1);
        return;
    }

    public static void getFreeSpace(String p0, WebViewCallback p1) {
        DeviceInfo.getStorageTypeFromString(p0);
        if (if-nez(DeviceInfo.getStorageTypeFromString(..))) goto L_12;
        p1.error(DeviceError.INVALID_STORAGETYPE, 1);
        return;
      L_12:
        DeviceInfo.getFileForStorageType(DeviceError.INVALID_STORAGETYPE);
        Device.getFreeSpace(DeviceInfo.getFileForStorageType(..));
        if (if-lez(DeviceInfo.getFileForStorageType(..))) goto L_2c;
        Long.valueOf(Device.getFreeSpace(..), v4);
        p1.invoke(DeviceInfo.getFileForStorageType(..));
      L_2c:
        Long.valueOf(Device.getFreeSpace(..), v4);
        p1.error(DeviceError.COULDNT_GET_STORAGE_LOCATION, Long.valueOf(..));
      L_39:
        return;
    }

    public static void getGLVersion(WebViewCallback p0) {
        Device.getGLVersion();
        if (if-eqz(Device.getGLVersion(..))) goto L_10;
        p0.invoke(1);
      L_10:
        p0.error(DeviceError.COULDNT_GET_GL_VERSION, 0);
      L_17:
        return;
    }

    public static void getHardware(WebViewCallback p0) {
        Device.getHardware();
        p0.invoke(1);
        return;
    }

    public static void getHeadset(WebViewCallback p0) {
        Device.isWiredHeadsetOn();
        Boolean.valueOf(Device.isWiredHeadsetOn(..));
        p0.invoke(1);
        return;
    }

    public static void getHost(WebViewCallback p0) {
        Device.getHost();
        p0.invoke(1);
        return;
    }

    public static void getLimitAdTrackingFlag(WebViewCallback p0) {
        Device.isLimitAdTrackingEnabled();
        Boolean.valueOf(Device.isLimitAdTrackingEnabled(..));
        p0.invoke(1);
        return;
    }

    public static void getLimitOpenAdTrackingFlag(WebViewCallback p0) {
        Device.isLimitOpenAdTrackingEnabled();
        Boolean.valueOf(Device.isLimitOpenAdTrackingEnabled(..));
        p0.invoke(1);
        return;
    }

    public static void getManufacturer(WebViewCallback p0) {
        Device.getManufacturer();
        p0.invoke(1);
        return;
    }

    public static void getModel(WebViewCallback p0) {
        Device.getModel();
        p0.invoke(1);
        return;
    }

    public static void getNetworkCountryISO(WebViewCallback p0) {
        Device.getNetworkCountryISO();
        p0.invoke(1);
        return;
    }

    public static void getNetworkMetered(WebViewCallback p0) {
        Device.getNetworkMetered();
        Boolean.valueOf(Device.getNetworkMetered(..));
        p0.invoke(1);
        return;
    }

    public static void getNetworkOperator(WebViewCallback p0) {
        Device.getNetworkOperator();
        p0.invoke(1);
        return;
    }

    public static void getNetworkOperatorName(WebViewCallback p0) {
        Device.getNetworkOperatorName();
        p0.invoke(1);
        return;
    }

    public static void getNetworkType(WebViewCallback p0) {
        Device.getNetworkType();
        Integer.valueOf(Device.getNetworkType(..));
        p0.invoke(1);
        return;
    }

    public static void getOpenAdvertisingTrackingId(WebViewCallback p0) {
        Device.getOpenAdvertisingTrackingId();
        p0.invoke(1);
        return;
    }

    public static void getOsVersion(WebViewCallback p0) {
        Device.getOsVersion();
        p0.invoke(1);
        return;
    }

    public static void getPackageInfo(WebViewCallback p0) {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_39;
        ClientProperties.getAppName();
        ClientProperties.getApplicationContext();
        Context.getPackageManager();
        Device.getPackageInfo(Context.getPackageManager(..));
        p0.invoke(v4);
        ClientProperties.getAppName(..).getMessage();
        p0.error(DeviceError.JSON_ERROR, 1);
        p0.error(DeviceError.APPLICATION_INFO_NOT_AVAILABLE, 1);
      L_39:
        p0.error(DeviceError.APPLICATION_CONTEXT_NULL, 0);
      L_40:
        return;
    }

    public static void getProcessInfo(WebViewCallback p0) {
        new JSONObject();
        Device.getProcessInfo();
        if (if-eqz(Device.getProcessInfo(..))) goto L_30;
        Device.getProcessInfo(..).containsKey("stat");
        if (if-eqz(Map.containsKey(..))) goto L_1c;
        Device.getProcessInfo(..).get("stat");
        new JSONObject(..).put("stat", Map.get(..));
      L_1c:
        Device.getProcessInfo(..).containsKey("uptime");
        if (if-eqz(Map.containsKey(..))) goto L_30;
        Device.getProcessInfo(..).get("uptime");
        new JSONObject(..).put("uptime", Map.get(..));
        DeviceLog.exception("Error while constructing process info", "uptime");
      L_30:
        p0.invoke(1);
        return;
    }

    public static void getProduct(WebViewCallback p0) {
        Device.getProduct();
        p0.invoke(1);
        return;
    }

    public static void getRingerMode(WebViewCallback p0) {
        Device.getRingerMode();
        if (if-le(Device.getRingerMode(..), -1)) goto L_15;
        Integer.valueOf(Device.getRingerMode(..));
        p0.invoke(1);
      L_15:
        if (if-eq(Integer.valueOf(..), -2)) goto L_3a;
        if (if-eq(Integer.valueOf(..), -1)) goto L_2c;
        new StringBuilder("Unhandled ringerMode error: ");
        new StringBuilder(..).append(Integer.valueOf(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
      L_2c:
        Integer.valueOf(Integer.valueOf(..));
        StringBuilder.toString(..).error(DeviceError.APPLICATION_CONTEXT_NULL, 1);
      L_3a:
        Integer.valueOf(Integer.valueOf(..));
        StringBuilder.toString(..).error(DeviceError.AUDIOMANAGER_NULL, 1);
      L_47:
        return;
    }

    public static void getScreenBrightness(WebViewCallback p0) {
        Device.getScreenBrightness();
        if (if-le(Device.getScreenBrightness(..), -1)) goto L_15;
        Integer.valueOf(Device.getScreenBrightness(..));
        p0.invoke(1);
      L_15:
        if (if-eq(Integer.valueOf(..), -1)) goto L_29;
        new StringBuilder("Unhandled screenBrightness error: ");
        new StringBuilder(..).append(Integer.valueOf(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
      L_29:
        Integer.valueOf(Integer.valueOf(..));
        StringBuilder.toString(..).error(DeviceError.APPLICATION_CONTEXT_NULL, 1);
      L_36:
        return;
    }

    public static void getScreenDensity(WebViewCallback p0) {
        Device.getScreenDensity();
        Integer.valueOf(Device.getScreenDensity(..));
        p0.invoke(1);
        return;
    }

    public static void getScreenHeight(WebViewCallback p0) {
        Device.getScreenHeight();
        Integer.valueOf(Device.getScreenHeight(..));
        p0.invoke(1);
        return;
    }

    public static void getScreenLayout(WebViewCallback p0) {
        Device.getScreenLayout();
        Integer.valueOf(Device.getScreenLayout(..));
        p0.invoke(1);
        return;
    }

    public static void getScreenWidth(WebViewCallback p0) {
        Device.getScreenWidth();
        Integer.valueOf(Device.getScreenWidth(..));
        p0.invoke(1);
        return;
    }

    public static void getSensorList(WebViewCallback p0) {
        new JSONArray();
        Device.getSensorList();
        if (if-eqz(Device.getSensorList(..))) goto L_80;
        Device.getSensorList(..).iterator();
      L_11:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_80;
        List.iterator(..).next();
        new JSONObject();
        Iterator.next(..).getName();
        new JSONObject(..).put("name", Sensor.getName(..));
        Iterator.next(..).getType();
        new JSONObject(..).put("type", Sensor.getType(..));
        Iterator.next(..).getVendor();
        new JSONObject(..).put("vendor", Sensor.getVendor(..));
        Iterator.next(..).getMaximumRange();
        new JSONObject(..).put("maximumRange", Sensor.getMaximumRange(..), v8);
        Iterator.next(..).getPower();
        new JSONObject(..).put("power", Sensor.getPower(..), v8);
        Iterator.next(..).getVersion();
        new JSONObject(..).put("version", Sensor.getVersion(..));
        Iterator.next(..).getResolution();
        new JSONObject(..).put("resolution", Sensor.getResolution(..), v8);
        Iterator.next(..).getMinDelay();
        new JSONObject(..).put("minDelay", Sensor.getMinDelay(..));
        new JSONArray(..).put(new JSONObject(..));
        new JSONArray(..).getMessage();
        p0.error(DeviceError.JSON_ERROR, 1);
        return;
      L_80:
        p0.invoke(DeviceError.JSON_ERROR);
        return;
    }

    private static DeviceInfo$StorageType getStorageTypeFromString(String p0) {
        DeviceInfo$StorageType.valueOf(p0);
        return DeviceInfo$StorageType.valueOf(..);
        new StringBuilder("Illegal argument: ");
        new StringBuilder(..).append(DeviceInfo$StorageType.valueOf(..));
        new StringBuilder(..).toString();
        DeviceLog.exception(StringBuilder.toString(..), v0);
        return 0;
    }

    public static void getSupportedAbis(WebViewCallback p0) {
        new JSONArray();
        Device.getSupportedAbis();
        Device.getSupportedAbis(..).iterator();
      L_d:
        ArrayList.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_1d;
        ArrayList.iterator(..).next();
        new JSONArray(..).put(Iterator.next(..));
      L_1d:
        p0.invoke(1);
        return;
    }

    public static void getSystemLanguage(WebViewCallback p0) {
        Locale.getDefault();
        Locale.getDefault(..).toString();
        p0.invoke(1);
        return;
    }

    public static void getSystemProperty(String p0, String p1, WebViewCallback p2) {
        Device.getSystemProperty(p0, p1);
        p2.invoke(1);
        return;
    }

    public static void getTimeZone(Boolean p0, WebViewCallback p1) {
        TimeZone.getDefault();
        p0.booleanValue();
        TimeZone.getDefault(..).getDisplayName(Boolean.booleanValue(..), 0, Locale.US);
        p1.invoke(1);
        return;
    }

    public static void getTimeZoneOffset(WebViewCallback p0) {
        TimeZone.getDefault();
        System.currentTimeMillis();
        TimeZone.getDefault(..).getOffset(System.currentTimeMillis(..), v3);
        Integer.valueOf(TimeZone.getOffset(..));
        p0.invoke(1);
        return;
    }

    public static void getTotalMemory(WebViewCallback p0) {
        Device.getTotalMemory();
        Long.valueOf(Device.getTotalMemory(..), v2);
        p0.invoke(1);
        return;
    }

    public static void getTotalSpace(String p0, WebViewCallback p1) {
        DeviceInfo.getStorageTypeFromString(p0);
        if (if-nez(DeviceInfo.getStorageTypeFromString(..))) goto L_12;
        p1.error(DeviceError.INVALID_STORAGETYPE, 1);
        return;
      L_12:
        DeviceInfo.getFileForStorageType(DeviceError.INVALID_STORAGETYPE);
        Device.getTotalSpace(DeviceInfo.getFileForStorageType(..));
        if (if-lez(DeviceInfo.getFileForStorageType(..))) goto L_2c;
        Long.valueOf(Device.getTotalSpace(..), v4);
        p1.invoke(DeviceInfo.getFileForStorageType(..));
      L_2c:
        Long.valueOf(Device.getTotalSpace(..), v4);
        p1.error(DeviceError.COULDNT_GET_STORAGE_LOCATION, Long.valueOf(..));
      L_39:
        return;
    }

    public static void getUniqueEventId(WebViewCallback p0) {
        Device.getUniqueEventId();
        p0.invoke(1);
        return;
    }

    public static void getUptime(WebViewCallback p0) {
        Device.getUptime();
        Long.valueOf(Device.getUptime(..), v2);
        p0.invoke(1);
        return;
    }

    public static void hasAV1HWDecoder(WebViewCallback p0) {
        Device.hasAV1Decoder();
        Boolean.valueOf(Device.hasAV1Decoder(..));
        p0.invoke(1);
        return;
    }

    public static void hasX264HWDecoder(WebViewCallback p0) {
        Device.hasX264Decoder();
        Boolean.valueOf(Device.hasX264Decoder(..));
        p0.invoke(1);
        return;
    }

    public static void hasX265HWDecoder(WebViewCallback p0) {
        Device.hasX265Decoder();
        Boolean.valueOf(Device.hasX265Decoder(..));
        p0.invoke(1);
        return;
    }

    public static void isAdbEnabled(WebViewCallback p0) {
        Device.isAdbEnabled();
        if (if-eqz(Device.isAdbEnabled(..))) goto L_10;
        p0.invoke(1);
      L_10:
        p0.error(DeviceError.COULDNT_GET_ADB_STATUS, 0);
      L_17:
        return;
    }

    public static void isRooted(WebViewCallback p0) {
        Device.isRooted();
        Boolean.valueOf(Device.isRooted(..));
        p0.invoke(1);
        return;
    }

    public static void isUSBConnected(WebViewCallback p0) {
        Device.isUSBConnected();
        Boolean.valueOf(Device.isUSBConnected(..));
        p0.invoke(1);
        return;
    }

    public static void registerVolumeChangeListener(Integer p0, WebViewCallback p1) {
        p0.intValue();
        DeviceInfo.volumeChangeMonitor.registerVolumeChangeListener(Integer.intValue(..));
        p1.invoke(0);
        return;
    }

    public static void unregisterVolumeChangeListener(Integer p0, WebViewCallback p1) {
        p0.intValue();
        DeviceInfo.volumeChangeMonitor.unregisterVolumeChangeListener(Integer.intValue(..));
        p1.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.DownloadLatestWebViewStatus
// ============================================================
package com.unity3d.services.core.api;

public final class DownloadLatestWebViewStatus extends Enum {
    private static final DownloadLatestWebViewStatus[] $VALUES;
    public static final DownloadLatestWebViewStatus BACKGROUND_DOWNLOAD_STARTED;
    public static final DownloadLatestWebViewStatus INIT_QUEUE_NOT_EMPTY;
    public static final DownloadLatestWebViewStatus INIT_QUEUE_NULL;
    public static final DownloadLatestWebViewStatus MISSING_LATEST_CONFIG;
    private final int value;

    private static DownloadLatestWebViewStatus[] $values() {
        return 4;
    }

    static <clinit>() {
        new DownloadLatestWebViewStatus("INIT_QUEUE_NULL", 0, 0);
        INIT_QUEUE_NULL = new DownloadLatestWebViewStatus(..);
        new DownloadLatestWebViewStatus("INIT_QUEUE_NOT_EMPTY", 1, 1);
        INIT_QUEUE_NOT_EMPTY = new DownloadLatestWebViewStatus(..);
        new DownloadLatestWebViewStatus("MISSING_LATEST_CONFIG", 2, 2);
        MISSING_LATEST_CONFIG = new DownloadLatestWebViewStatus(..);
        new DownloadLatestWebViewStatus("BACKGROUND_DOWNLOAD_STARTED", 3, 3);
        BACKGROUND_DOWNLOAD_STARTED = new DownloadLatestWebViewStatus(..);
        DownloadLatestWebViewStatus.$values();
        $VALUES = DownloadLatestWebViewStatus.$values(..);
        return;
    }

    private DownloadLatestWebViewStatus(String p0, int p1, int p2) {
        new Enum(p0, p1);
        value = p2;
        return;
    }

    public static DownloadLatestWebViewStatus valueOf(String p0) {
        Enum.valueOf(DownloadLatestWebViewStatus.class, p0);
        return Enum.valueOf(..);
    }

    public static DownloadLatestWebViewStatus[] values() {
        DownloadLatestWebViewStatus.$VALUES.clone();
        return DownloadLatestWebViewStatus[].clone(..);
    }

    public int getValue() {
        return value;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Intent
// ============================================================
package com.unity3d.services.core.api;

public class Intent {
    private static WeakReference _activeActivity;

    public Intent() {
        new Object();
        return;
    }

    public static void canOpenIntent(JSONObject p0, WebViewCallback p1) {
        Intent.intentFromMetadata(p0);
        Intent.checkIntentResolvable(Intent.intentFromMetadata(..));
        Boolean.valueOf(Intent.checkIntentResolvable(..));
        p1.invoke(v2);
        DeviceLog.exception("Couldn't resolve intent", Boolean.valueOf(..));
        Boolean.valueOf(..).getError();
        Boolean.valueOf(..).getField();
        p1.error(Intent$IntentException.getError(..), 1);
      L_2b:
        return;
    }

    public static void canOpenIntents(JSONArray p0, WebViewCallback p1) {
        new JSONObject();
        p0.length();
      L_b:
        if (if-ge(0, JSONArray.length(..))) goto L_4b;
        p0.optJSONObject(0);
        JSONArray.optJSONObject(..).optString("id");
        Intent.intentFromMetadata(JSONArray.optJSONObject(..));
        Intent.checkIntentResolvable(Intent.intentFromMetadata(..));
        new JSONObject(..).put(JSONObject.optString(..), Intent.checkIntentResolvable(..));
        p0.getMessage();
        p1.error(Intent$IntentError.JSON_EXCEPTION, JSONArray.length(..));
        return;
        DeviceLog.exception("Exception parsing intent", JSONException.getMessage(..));
        JSONException.getMessage(..).getError();
        JSONException.getMessage(..).getField();
        p1.error(Intent$IntentException.getError(..), JSONArray.length(..));
        return;
      L_4b:
        p1.invoke(Intent$IntentException.getField(..));
        return;
    }

    private static boolean checkIntentResolvable(Intent p0) {
        ClientProperties.getApplicationContext();
        Context.getPackageManager();
        Context.getPackageManager(..).resolveActivity(p0, 0);
        if (if-eqz(PackageManager.resolveActivity(..))) goto L_10;
      L_10:
        return 1;
    }

    private static Activity getStartingActivity() {
        if (if-eqz(Intent._activeActivity)) goto L_13;
        Intent._activeActivity.get();
        if (if-eqz(WeakReference.get(..))) goto L_13;
        Intent._activeActivity.get();
      L_13:
        ClientProperties.getActivity();
        if (if-eqz(ClientProperties.getActivity(..))) goto L_1e;
        ClientProperties.getActivity();
      L_1e:
      L_1f:
        return 0;
    }

    private static Intent intentFromMetadata(JSONObject p0) {
        p0.opt("className");
        p0.opt("packageName");
        p0.opt("action");
        p0.opt("uri");
        p0.opt("mimeType");
        p0.opt("categories");
        p0.opt("flags");
        p0.opt("extras");
        if (if-eqz(JSONObject.opt(..))) goto L_65;
        if (if-nez(JSONObject.opt(..))) goto L_65;
        if (if-nez(JSONObject.opt(..))) goto L_65;
        if (if-nez(JSONObject.opt(..))) goto L_65;
        ClientProperties.getApplicationContext();
        Context.getPackageManager();
        Context.getPackageManager(..).getLaunchIntentForPackage(JSONObject.opt(..));
        if (if-eqz(PackageManager.getLaunchIntentForPackage(..))) goto L_a0;
        JSONObject.opt(..).intValue();
        if (if-le(Integer.intValue(..), -1)) goto L_a0;
        JSONObject.opt(..).intValue();
        Intent.addFlags(Integer.intValue(..));
      L_65:
        new Intent();
        if (if-eqz(Integer.intValue(..))) goto L_71;
        if (if-eqz(JSONObject.opt(..))) goto L_71;
        new Intent(..).setClassName(JSONObject.opt(..), Integer.intValue(..));
      L_71:
        if (if-eqz(JSONObject.opt(..))) goto L_76;
        new Intent(..).setAction(JSONObject.opt(..));
      L_76:
        if (if-eqz(JSONObject.opt(..))) goto L_7f;
        Uri.parse(JSONObject.opt(..));
        new Intent(..).setData(Uri.parse(..));
      L_7f:
        if (if-eqz(JSONObject.opt(..))) goto L_84;
        new Intent(..).setType(JSONObject.opt(..));
      L_84:
        if (if-eqz(JSONObject.opt(..))) goto L_93;
        JSONObject.opt(..).intValue();
        if (if-le(Integer.intValue(..), -1)) goto L_93;
        JSONObject.opt(..).intValue();
        new Intent(..).setFlags(Integer.intValue(..));
      L_93:
        Intent.setCategories(new Intent(..), JSONObject.opt(..));
        if (if-eqz(Intent.setCategories(..))) goto L_a9;
        Intent.setExtras(new Intent(..), PackageManager.getLaunchIntentForPackage(..));
        if (if-eqz(Intent.setExtras(..))) goto L_a1;
      L_a0:
        return new Intent(..);
      L_a1:
        new Intent$IntentException(Intent$IntentError.COULDNT_PARSE_EXTRAS, new Intent(..));
        throw new Intent$IntentException(..);
      L_a9:
        new Intent$IntentException(Intent$IntentError.COULDNT_PARSE_CATEGORIES, JSONObject.opt(..));
        throw new Intent$IntentException(..);
    }

    public static void launch(JSONObject p0, WebViewCallback p1) {
        p0.opt("className");
        p0.opt("packageName");
        p0.opt("action");
        p0.opt("uri");
        p0.opt("mimeType");
        p0.opt("categories");
        p0.opt("flags");
        p0.opt("extras");
        if (if-eqz(JSONObject.opt(..))) goto L_66;
        if (if-nez(JSONObject.opt(..))) goto L_66;
        if (if-nez(JSONObject.opt(..))) goto L_66;
        if (if-nez(JSONObject.opt(..))) goto L_66;
        ClientProperties.getApplicationContext();
        Context.getPackageManager();
        Context.getPackageManager(..).getLaunchIntentForPackage(JSONObject.opt(..));
        if (if-eqz(PackageManager.getLaunchIntentForPackage(..))) goto L_c7;
        JSONObject.opt(..).intValue();
        if (if-le(Integer.intValue(..), -1)) goto L_c7;
        JSONObject.opt(..).intValue();
        Intent.addFlags(Integer.intValue(..));
      L_66:
        new Intent();
        if (if-eqz(Integer.intValue(..))) goto L_73;
        if (if-eqz(JSONObject.opt(..))) goto L_73;
        new Intent(..).setClassName(JSONObject.opt(..), Integer.intValue(..));
      L_73:
        if (if-eqz(JSONObject.opt(..))) goto L_78;
        new Intent(..).setPackage(JSONObject.opt(..));
      L_78:
        if (if-eqz(JSONObject.opt(..))) goto L_7d;
        new Intent(..).setAction(JSONObject.opt(..));
      L_7d:
        if (if-eqz(JSONObject.opt(..))) goto L_89;
        if (if-eqz(JSONObject.opt(..))) goto L_89;
        Uri.parse(JSONObject.opt(..));
        new Intent(..).setDataAndType(Uri.parse(..), JSONObject.opt(..));
      L_89:
        if (if-eqz(JSONObject.opt(..))) goto L_93;
        Uri.parse(JSONObject.opt(..));
        new Intent(..).setData(Uri.parse(..));
      L_93:
        if (if-eqz(JSONObject.opt(..))) goto L_98;
        new Intent(..).setType(JSONObject.opt(..));
      L_98:
        if (if-eqz(JSONObject.opt(..))) goto L_a7;
        JSONObject.opt(..).intValue();
        if (if-le(Integer.intValue(..), -1)) goto L_a7;
        JSONObject.opt(..).intValue();
        new Intent(..).setFlags(Integer.intValue(..));
      L_a7:
        Intent.setCategories(new Intent(..), JSONObject.opt(..));
        if (if-nez(Intent.setCategories(..))) goto L_b7;
        p1.error(Intent$IntentError.COULDNT_PARSE_CATEGORIES, JSONObject.opt(..));
      L_b7:
        Intent.setExtras(new Intent(..), PackageManager.getLaunchIntentForPackage(..));
        if (if-nez(Intent.setExtras(..))) goto L_c6;
        p1.error(Intent$IntentError.COULDNT_PARSE_EXTRAS, 1);
      L_c6:
      L_c7:
        if (if-eqz(new Intent(..))) goto L_e4;
        Intent.getStartingActivity();
        if (if-eqz(Intent.getStartingActivity(..))) goto L_dc;
        Intent.getStartingActivity();
        Intent.getStartingActivity(..).startActivity(new Intent(..));
        p1.invoke(new Intent(..));
      L_dc:
        p1.error(Intent$IntentError.ACTIVITY_WAS_NULL, Intent.getStartingActivity(..));
      L_e4:
        p1.error(Intent$IntentError.INTENT_WAS_NULL, Intent.getStartingActivity(..));
      L_eb:
        return;
    }

    public static void removeActiveActivity(Activity p0) {
        if (if-eqz(Intent._activeActivity)) goto L_1b;
        Intent._activeActivity.get();
        if (if-eqz(WeakReference.get(..))) goto L_1b;
        if (if-eqz(p0)) goto L_1b;
        Intent._activeActivity.get();
        p0.equals(WeakReference.get(..));
        if (if-eqz(Object.equals(..))) goto L_1b;
        _activeActivity = 0;
      L_1b:
        return;
    }

    public static void setActiveActivity(Activity p0) {
        if (if-nez(p0)) goto L_6;
        _activeActivity = 0;
      L_6:
        new WeakReference(0);
        _activeActivity = new WeakReference(..);
      L_d:
        return;
    }

    private static boolean setCategories(Intent p0, JSONArray p1) {
        if (if-eqz(p1)) goto L_21;
        p1.length();
        if (if-lez(JSONArray.length(..))) goto L_21;
      L_a:
        p1.length();
        if (if-ge(0, JSONArray.length(..))) goto L_21;
        p1.getString(0);
        p0.addCategory(JSONArray.getString(..));
        DeviceLog.exception("Couldn't parse categories for intent", p0);
        return 0;
      L_21:
        return 1;
    }

    private static boolean setExtra(Intent p0, String p1, Object p2) {
        if (if-eqz(v0)) goto L_a;
        p0.putExtra(p1, p2);
      L_a:
        if (if-eqz(v0)) goto L_18;
        p2.intValue();
        p0.putExtra(p1, Integer.intValue(..));
      L_18:
        if (if-eqz(v0)) goto L_26;
        Integer.intValue(..).doubleValue();
        p0.putExtra(p1, Double.doubleValue(..), v1);
      L_26:
        if (if-eqz(Double.doubleValue(..))) goto L_35;
        Integer.intValue(..).booleanValue();
        p0.putExtra(p1, Boolean.booleanValue(..));
      L_33:
        return 1;
      L_35:
        new StringBuilder("Unable to parse launch intent extra ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
        return 0;
    }

    private static boolean setExtras(Intent p0, JSONArray p1) {
        if (if-eqz(p1)) goto L_2b;
      L_4:
        p1.length();
        if (if-ge(0, JSONArray.length(..))) goto L_2b;
        p1.getJSONObject(0);
        JSONArray.getJSONObject(..).getString("key");
        JSONArray.getJSONObject(..).get("value");
        Intent.setExtra(p0, JSONObject.getString(..), JSONObject.get(..));
        if (if-nez(Intent.setExtra(..))) goto L_21;
        return 0;
      L_21:
        DeviceLog.exception("Couldn't parse extras", p0);
        return 0;
      L_2b:
        return 1;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Lifecycle
// ============================================================
package com.unity3d.services.core.api;

public class Lifecycle {
    private static LifecycleListener _listener;

    public Lifecycle() {
        new Object();
        return;
    }

    public static LifecycleListener getLifecycleListener() {
        return Lifecycle._listener;
    }

    public static void register(JSONArray p0, WebViewCallback p1) {
        ClientProperties.getApplication();
        if (if-eqz(ClientProperties.getApplication(..))) goto L_4e;
        Lifecycle.getLifecycleListener();
        if (if-nez(Lifecycle.getLifecycleListener(..))) goto L_46;
        new ArrayList();
      L_13:
        p0.length();
        if (if-ge(0, JSONArray.length(..))) goto L_2d;
        p0.get(0);
        new ArrayList(..).add(JSONArray.get(..));
        p1.error(LifecycleError.JSON_ERROR, new ArrayList(..));
        return;
      L_2d:
        new LifecycleListener(new ArrayList(..));
        Lifecycle.setLifecycleListener(new LifecycleListener(..));
        ClientProperties.getApplication();
        Lifecycle.getLifecycleListener();
        ClientProperties.getApplication(..).registerActivityLifecycleCallbacks(Lifecycle.getLifecycleListener(..));
        p1.invoke(ClientProperties.getApplication(..));
      L_46:
        p1.error(LifecycleError.LISTENER_NOT_NULL, Lifecycle.getLifecycleListener(..));
      L_4e:
        p1.error(LifecycleError.APPLICATION_NULL, Lifecycle.getLifecycleListener(..));
      L_55:
        return;
    }

    public static void setLifecycleListener(LifecycleListener p0) {
        _listener = p0;
        return;
    }

    public static void unregister(WebViewCallback p0) {
        ClientProperties.getApplication();
        if (if-eqz(ClientProperties.getApplication(..))) goto L_22;
        Lifecycle.getLifecycleListener();
        if (if-eqz(Lifecycle.getLifecycleListener(..))) goto L_1c;
        ClientProperties.getApplication();
        Lifecycle.getLifecycleListener();
        ClientProperties.getApplication(..).unregisterActivityLifecycleCallbacks(Lifecycle.getLifecycleListener(..));
        Lifecycle.setLifecycleListener(0);
      L_1c:
        p0.invoke(0);
      L_22:
        p0.error(LifecycleError.APPLICATION_NULL, 0);
      L_29:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Permissions
// ============================================================
package com.unity3d.services.core.api;

public class Permissions {
    public Permissions() {
        new Object();
        return;
    }

    public static void checkPermission(String p0, WebViewCallback p1) {
        ClientProperties.getApplicationContext();
        if (if-nez(ClientProperties.getApplicationContext(..))) goto L_f;
        p1.error(DeviceError.APPLICATION_CONTEXT_NULL, ClientProperties.getApplicationContext(..));
        return;
      L_f:
        ClientProperties.getApplicationContext();
        Context.getPackageManager();
        Context.getPackageName();
        Context.getPackageManager(..).checkPermission(DeviceError.APPLICATION_CONTEXT_NULL, Context.getPackageName(..));
        Integer.valueOf(PackageManager.checkPermission(..));
        p1.invoke(Context.getPackageName(..));
        Integer.valueOf(..).getMessage();
        p1.error(PermissionsError.ERROR_CHECKING_PERMISSION, 1);
      L_3a:
        return;
    }

    public static void getPermissions(WebViewCallback p0) {
        ClientProperties.getApplicationContext();
        if (if-nez(ClientProperties.getApplicationContext(..))) goto L_f;
        p0.error(DeviceError.APPLICATION_CONTEXT_NULL, 0);
        return;
      L_f:
        new JSONArray();
        ClientProperties.getApplicationContext();
        Context.getPackageManager();
        Context.getPackageName();
        Context.getPackageManager(..).getPackageInfo(Context.getPackageName(..), 4096);
        if (if-eqz(requestedPermissions)) goto L_41;
      L_2f:
        if (if-ge(0, requestedPermissions)) goto L_39;
        new JSONArray(..).put(v6);
      L_39:
        p0.invoke(requestedPermissions);
      L_41:
        p0.error(PermissionsError.NO_REQUESTED_PERMISSIONS, requestedPermissions);
        Exception.getMessage();
        p0.error(PermissionsError.COULDNT_GET_PERMISSIONS, 1);
      L_57:
        return;
    }

    public static void requestPermissions(JSONArray p0, Integer p1, WebViewCallback p2) {
        AdUnit.getAdUnitActivity();
        if (if-nez(AdUnit.getAdUnitActivity(..))) goto L_f;
        p2.error(AdUnitError.ADUNIT_NULL, p1);
        return;
      L_f:
        if (if-eqz(AdUnitError.ADUNIT_NULL)) goto L_5b;
        AdUnitError.ADUNIT_NULL.length();
        if (if-ge(JSONArray.length(..), 1)) goto L_19;
      L_19:
        new ArrayList();
      L_1f:
        AdUnitError.ADUNIT_NULL.length();
        if (if-ge(0, JSONArray.length(..))) goto L_2f;
        AdUnitError.ADUNIT_NULL.getString(0);
        new ArrayList(..).add(JSONArray.getString(..));
      L_2f:
        new ArrayList(..).size();
        AdUnit.getAdUnitActivity();
        new ArrayList(..).toArray(List.size(..));
        p1.intValue();
        AdUnit.getAdUnitActivity(..).requestPermissions(List.toArray(..), Integer.intValue(..));
        p2.invoke(List.toArray(..));
        List.toArray(..).getMessage();
        p2.error(PermissionsError.ERROR_REQUESTING_PERMISSIONS, new ArrayList(..));
      L_5a:
        return;
      L_5b:
        p2.error(PermissionsError.NO_REQUESTED_PERMISSIONS, PermissionsError.ERROR_REQUESTING_PERMISSIONS);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.PermissionsError
// ============================================================
package com.unity3d.services.core.api;

final class PermissionsError extends Enum {
    private static final PermissionsError[] $VALUES;
    public static final PermissionsError COULDNT_GET_PERMISSIONS;
    public static final PermissionsError ERROR_CHECKING_PERMISSION;
    public static final PermissionsError ERROR_REQUESTING_PERMISSIONS;
    public static final PermissionsError NO_REQUESTED_PERMISSIONS;

    private static PermissionsError[] $values() {
        return 4;
    }

    static <clinit>() {
        new PermissionsError("COULDNT_GET_PERMISSIONS", 0);
        COULDNT_GET_PERMISSIONS = new PermissionsError(..);
        new PermissionsError("NO_REQUESTED_PERMISSIONS", 1);
        NO_REQUESTED_PERMISSIONS = new PermissionsError(..);
        new PermissionsError("ERROR_CHECKING_PERMISSION", 2);
        ERROR_CHECKING_PERMISSION = new PermissionsError(..);
        new PermissionsError("ERROR_REQUESTING_PERMISSIONS", 3);
        ERROR_REQUESTING_PERMISSIONS = new PermissionsError(..);
        PermissionsError.$values();
        $VALUES = PermissionsError.$values(..);
        return;
    }

    private PermissionsError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static PermissionsError valueOf(String p0) {
        Enum.valueOf(PermissionsError.class, p0);
        return Enum.valueOf(..);
    }

    public static PermissionsError[] values() {
        PermissionsError.$VALUES.clone();
        return PermissionsError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Preferences
// ============================================================
package com.unity3d.services.core.api;

public class Preferences {
    public Preferences() {
        new Object();
        return;
    }

    public static void getBoolean(String p0, String p1, WebViewCallback p2) {
        AndroidPreferences.getBoolean(p0, p1);
        if (if-eqz(AndroidPreferences.getBoolean(..))) goto L_10;
        p2.invoke(p0);
      L_10:
        p2.error(PreferencesError.COULDNT_GET_VALUE, 2);
      L_1c:
        return;
    }

    public static void getFloat(String p0, String p1, WebViewCallback p2) {
        AndroidPreferences.getFloat(p0, p1);
        if (if-eqz(AndroidPreferences.getFloat(..))) goto L_10;
        p2.invoke(p0);
      L_10:
        p2.error(PreferencesError.COULDNT_GET_VALUE, 2);
      L_1c:
        return;
    }

    public static void getInt(String p0, String p1, WebViewCallback p2) {
        AndroidPreferences.getInteger(p0, p1);
        if (if-eqz(AndroidPreferences.getInteger(..))) goto L_10;
        p2.invoke(p0);
      L_10:
        p2.error(PreferencesError.COULDNT_GET_VALUE, 2);
      L_1c:
        return;
    }

    public static void getLong(String p0, String p1, WebViewCallback p2) {
        AndroidPreferences.getLong(p0, p1);
        if (if-eqz(AndroidPreferences.getLong(..))) goto L_10;
        p2.invoke(p0);
      L_10:
        p2.error(PreferencesError.COULDNT_GET_VALUE, 2);
      L_1c:
        return;
    }

    public static void getString(String p0, String p1, WebViewCallback p2) {
        AndroidPreferences.getString(p0, p1);
        if (if-eqz(AndroidPreferences.getString(..))) goto L_10;
        p2.invoke(p0);
      L_10:
        p2.error(PreferencesError.COULDNT_GET_VALUE, 2);
      L_1c:
        return;
    }

    public static void hasKey(String p0, String p1, WebViewCallback p2) {
        AndroidPreferences.hasKey(p0, p1);
        Boolean.valueOf(AndroidPreferences.hasKey(..));
        p2.invoke(1);
        return;
    }

    public static void removeKey(String p0, String p1, WebViewCallback p2) {
        AndroidPreferences.removeKey(p0, p1);
        p2.invoke(0);
        return;
    }

    public static void setBoolean(String p0, String p1, Boolean p2, WebViewCallback p3) {
        AndroidPreferences.setBoolean(p0, p1, p2);
        p3.invoke(0);
        return;
    }

    public static void setFloat(String p0, String p1, Double p2, WebViewCallback p3) {
        AndroidPreferences.setFloat(p0, p1, p2);
        p3.invoke(0);
        return;
    }

    public static void setInt(String p0, String p1, Integer p2, WebViewCallback p3) {
        AndroidPreferences.setInteger(p0, p1, p2);
        p3.invoke(0);
        return;
    }

    public static void setLong(String p0, String p1, Long p2, WebViewCallback p3) {
        AndroidPreferences.setLong(p0, p1, p2);
        p3.invoke(0);
        return;
    }

    public static void setString(String p0, String p1, String p2, WebViewCallback p3) {
        AndroidPreferences.setString(p0, p1, p2);
        p3.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Request
// ============================================================
package com.unity3d.services.core.api;

public class Request {
    public Request() {
        new Object();
        return;
    }

    public static void get(String p0, String p1, JSONArray p2, Integer p3, Integer p4, WebViewCallback p5) {
        if (if-eqz(p2)) goto L_9;
        p2.length();
        if (if-nez(JSONArray.length(..))) goto L_9;
      L_9:
        Request.getHeadersMap(0);
        new Request$1(p0);
        WebRequestThread.request(p1, WebRequest$RequestType.GET, Request.getHeadersMap(..), 0, p3, p4, new Request$1(..));
        p5.invoke(p1);
        return;
        DeviceLog.exception("Error mapping headers for the request", p1);
        p5.error(WebRequestError.MAPPING_HEADERS_FAILED, "Error mapping headers for the request");
        return;
    }

    public static HashMap getHeadersMap(JSONArray p0) {
        if (if-eqz(p0)) goto L_38;
        new HashMap();
      L_9:
        p0.length();
        if (if-ge(0, JSONArray.length(..))) goto L_39;
        p0.get(0);
        JSONArray.get(..).getString(0);
        new HashMap(..).get(JSONArray.getString(..));
        if (if-nez(HashMap.get(..))) goto L_26;
        new ArrayList();
      L_26:
        JSONArray.get(..).getString(1);
        new ArrayList(..).add(JSONArray.getString(..));
        JSONArray.get(..).getString(0);
        new HashMap(..).put(JSONArray.getString(..), new ArrayList(..));
      L_38:
      L_39:
        return 0;
    }

    public static JSONArray getResponseHeadersMap(Map p0) {
        new JSONArray();
        if (if-eqz(p0)) goto L_49;
        p0.size();
        if (if-lez(Map.size(..))) goto L_49;
        p0.keySet();
        Map.keySet(..).iterator();
      L_15:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_49;
        Set.iterator(..).next();
        p0.get(Iterator.next(..));
        Map.get(..).iterator();
      L_2c:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_45;
        List.iterator(..).next();
        new JSONArray();
        new JSONArray(..).put(Iterator.next(..));
        new JSONArray(..).put(Iterator.next(..));
      L_45:
        new JSONArray(..).put(new JSONArray(..));
      L_49:
        return new JSONArray(..);
    }

    public static void head(String p0, String p1, JSONArray p2, Integer p3, Integer p4, WebViewCallback p5) {
        if (if-eqz(p2)) goto L_9;
        p2.length();
        if (if-nez(JSONArray.length(..))) goto L_9;
      L_9:
        Request.getHeadersMap(0);
        new Request$3(p0);
        WebRequestThread.request(p1, WebRequest$RequestType.HEAD, Request.getHeadersMap(..), p3, p4, new Request$3(..));
        p5.invoke(p1);
        return;
        DeviceLog.exception("Error mapping headers for the request", p1);
        p5.error(WebRequestError.MAPPING_HEADERS_FAILED, "Error mapping headers for the request");
        return;
    }

    public static void post(String p0, String p1, String p2, JSONArray p3, Integer p4, Integer p5, WebViewCallback p6) {
        if (if-eqz(p2)) goto L_b;
        p2.length();
        if (if-nez(String.length(..))) goto L_b;
      L_b:
      L_c:
        if (if-eqz(p3)) goto L_15;
        p3.length();
        if (if-nez(JSONArray.length(..))) goto L_15;
      L_15:
        Request.getHeadersMap(0);
        new Request$2(p0);
        WebRequestThread.request(p1, WebRequest$RequestType.POST, Request.getHeadersMap(..), p2, p4, p5, new Request$2(..));
        p6.invoke(p1);
        return;
        DeviceLog.exception("Error mapping headers for the request", p1);
        p6.error(WebRequestError.MAPPING_HEADERS_FAILED, "Error mapping headers for the request");
        return;
    }

    public static void setConcurrentRequestCount(Integer p0, WebViewCallback p1) {
        p0.intValue();
        WebRequestThread.setConcurrentRequestCount(Integer.intValue(..));
        p1.invoke(0);
        return;
    }

    public static void setKeepAliveTime(Integer p0, WebViewCallback p1) {
        p0.longValue();
        WebRequestThread.setKeepAliveTime(Integer.longValue(..), v1);
        p1.invoke(0);
        return;
    }

    public static void setMaximumPoolSize(Integer p0, WebViewCallback p1) {
        p0.intValue();
        WebRequestThread.setMaximumPoolSize(Integer.intValue(..));
        p1.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Resolve
// ============================================================
package com.unity3d.services.core.api;

public class Resolve {
    public Resolve() {
        new Object();
        return;
    }

    public static void resolve(String p0, String p1, WebViewCallback p2) {
        new Resolve$1(p0);
        WebRequestThread.resolve(p1, new Resolve$1(..));
        if (if-eqz(WebRequestThread.resolve(..))) goto L_15;
        p2.invoke(WebRequestThread.resolve(..));
      L_15:
        p2.error(ResolveHostError.INVALID_HOST, 1);
      L_1e:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Sdk
// ============================================================
package com.unity3d.services.core.api;

public class Sdk {
    public Sdk() {
        new Object();
        return;
    }

    public static void downloadLatestWebView(WebViewCallback p0) {
        DeviceLog.debug("Unity Ads init: WebView called download");
        InitializeThread.downloadLatestWebView();
        DownloadLatestWebViewStatus.getValue();
        Integer.valueOf(DownloadLatestWebViewStatus.getValue(..));
        p0.invoke(1);
        return;
    }

    public static void getDebugMode(WebViewCallback p0) {
        SdkProperties.getDebugMode();
        Boolean.valueOf(SdkProperties.getDebugMode(..));
        p0.invoke(1);
        return;
    }

    public static void getSharedSessionID(WebViewCallback p0) {
        Session.Default.getId();
        p0.invoke(1);
        return;
    }

    public static void getTrrData(WebViewCallback p0) {
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getConfiguration();
        WebViewApp.getConfiguration(..).getRawConfigData();
        Configuration.getRawConfigData(..).toString();
        p0.invoke(1);
        return;
    }

    public static void initComplete(WebViewCallback p0) {
        DeviceLog.debug("Web Application initialized");
        SdkProperties.setInitialized(1);
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).setWebAppInitialized(1);
        p0.invoke(0);
        return;
    }

    public static void initError(String p0, Integer p1, WebViewCallback p2) {
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).setWebAppFailureMessage(p0);
        WebViewApp.getCurrentApp();
        p1.intValue();
        WebViewApp.getCurrentApp(..).setWebAppFailureCode(Integer.intValue(..));
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).setWebAppInitialized(0);
        p2.invoke(WebViewApp.getCurrentApp(..));
        return;
    }

    public static void loadComplete(WebViewCallback p0) {
        DeviceLog.debug("Web Application loaded");
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).setWebAppLoaded(1);
        ClientProperties.getGameId();
        SdkProperties.isTestMode();
        Boolean.valueOf(SdkProperties.isTestMode(..));
        ClientProperties.getAppName();
        ClientProperties.getAppVersion();
        SdkProperties.getVersionCode();
        Integer.valueOf(SdkProperties.getVersionCode(..));
        SdkProperties.getVersionName();
        ClientProperties.isAppDebuggable();
        Boolean.valueOf(ClientProperties.isAppDebuggable(..));
        SdkProperties.getConfigUrl();
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getConfiguration();
        WebViewApp.getConfiguration(..).getWebViewUrl();
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getConfiguration();
        WebViewApp.getConfiguration(..).getWebViewHash();
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getConfiguration();
        WebViewApp.getConfiguration(..).getWebViewVersion();
        SdkProperties.getInitializationTime();
        Long.valueOf(SdkProperties.getInitializationTime(..), v5);
        SdkProperties.isReinitialized();
        Boolean.valueOf(SdkProperties.isReinitialized(..));
        Boolean.valueOf(1);
        SdkProperties.getLatestConfiguration();
        if (if-eqz(SdkProperties.getLatestConfiguration(..))) goto L_ab;
      L_ab:
      L_ac:
        Boolean.valueOf(0);
        Device.getElapsedRealtime();
        Long.valueOf(Device.getElapsedRealtime(..), 14);
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getConfiguration();
        WebViewApp.getConfiguration(..).getStateId();
        PrivacyConfigStorage.getInstance();
        PrivacyConfigStorage.getInstance(..).getPrivacyConfig();
        PrivacyConfig.getPrivacyStatus();
        PrivacyConfig.getPrivacyStatus(..).toLowerCase();
        p0.invoke(18);
        return;
    }

    public static void logDebug(String p0, WebViewCallback p1) {
        DeviceLog.debug(p0);
        p1.invoke(0);
        return;
    }

    public static void logError(String p0, WebViewCallback p1) {
        DeviceLog.error(p0);
        p1.invoke(0);
        return;
    }

    public static void logInfo(String p0, WebViewCallback p1) {
        DeviceLog.info(p0);
        p1.invoke(0);
        return;
    }

    public static void logWarning(String p0, WebViewCallback p1) {
        DeviceLog.warning(p0);
        p1.invoke(0);
        return;
    }

    public static void reinitialize(WebViewCallback p0) {
        SdkProperties.setReinitialized(1);
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).getConfiguration();
        InitializeThread.initialize(WebViewApp.getConfiguration(..));
        return;
    }

    public static void setDebugMode(Boolean p0, WebViewCallback p1) {
        p0.booleanValue();
        SdkProperties.setDebugMode(Boolean.booleanValue(..));
        p1.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.SensorInfo
// ============================================================
package com.unity3d.services.core.api;

public class SensorInfo {
    public SensorInfo() {
        new Object();
        return;
    }

    public static void getAccelerometerData(WebViewCallback p0) {
        SensorInfoListener.getAccelerometerData();
        if (if-eqz(SensorInfoListener.getAccelerometerData(..))) goto L_10;
        p0.invoke(1);
      L_10:
        p0.error(SensorInfoError.ACCELEROMETER_DATA_NOT_AVAILABLE, 0);
      L_17:
        return;
    }

    public static void isAccelerometerActive(WebViewCallback p0) {
        SensorInfoListener.isAccelerometerListenerActive();
        Boolean.valueOf(SensorInfoListener.isAccelerometerListenerActive(..));
        p0.invoke(1);
        return;
    }

    public static void startAccelerometerUpdates(Integer p0, WebViewCallback p1) {
        p0.intValue();
        SensorInfoListener.startAccelerometerListener(Integer.intValue(..));
        Boolean.valueOf(SensorInfoListener.startAccelerometerListener(..));
        p1.invoke(1);
        return;
    }

    public static void stopAccelerometerUpdates(WebViewCallback p0) {
        SensorInfoListener.stopAccelerometerListener();
        p0.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Storage
// ============================================================
package com.unity3d.services.core.api;

public class Storage {
    public Storage() {
        new Object();
        return;
    }

    public static void clear(String p0, WebViewCallback p1) {
        Storage.getStorage(p0);
        if (if-eqz(Storage.getStorage(..))) goto L_20;
        Storage.getStorage(..).clearStorage();
        if (if-eqz(Storage.clearStorage(..))) goto L_16;
        p1.invoke(Storage.clearStorage(..));
      L_16:
        p1.error(StorageError.COULDNT_CLEAR_STORAGE, 1);
      L_20:
        p1.error(StorageError.COULDNT_GET_STORAGE, 1);
      L_29:
        return;
    }

    public static void delete(String p0, String p1, WebViewCallback p2) {
        Storage.getStorage(p0);
        if (if-eqz(Storage.getStorage(..))) goto L_20;
        Storage.getStorage(..).delete(p1);
        if (if-eqz(Storage.delete(..))) goto L_16;
        p2.invoke(Storage.delete(..));
      L_16:
        p2.error(StorageError.COULDNT_DELETE_VALUE, Storage.getStorage(..));
      L_20:
        p2.error(StorageError.COULDNT_GET_STORAGE, Storage.getStorage(..));
      L_29:
        return;
    }

    public static void get(String p0, String p1, WebViewCallback p2) {
        Storage.getStorage(p0);
        if (if-eqz(Storage.getStorage(..))) goto L_20;
        Storage.getStorage(..).get(p1);
        if (if-nez(Storage.get(..))) goto L_18;
        p2.error(StorageError.COULDNT_GET_VALUE, Storage.getStorage(..));
      L_18:
        p2.invoke(p1);
      L_20:
        p2.error(StorageError.COULDNT_GET_STORAGE, 2);
      L_2c:
        return;
    }

    public static void getKeys(String p0, String p1, Boolean p2, WebViewCallback p3) {
        Storage.getStorage(p0);
        if (if-eqz(Storage.getStorage(..))) goto L_2c;
        p2.booleanValue();
        Storage.getStorage(..).getKeys(p1, Boolean.booleanValue(..));
        if (if-eqz(Storage.getKeys(..))) goto L_1f;
        new JSONArray(Storage.getKeys(..));
        p3.invoke(p1);
      L_1f:
        new JSONArray();
        p3.invoke(Storage.getKeys(..));
      L_2c:
        p3.error(StorageError.COULDNT_GET_STORAGE, 2);
      L_38:
        return;
    }

    private static Storage getStorage(String p0) {
        StorageManager$StorageType.valueOf(p0);
        StorageManager.getStorage(StorageManager$StorageType.valueOf(..));
        return StorageManager.getStorage(..);
    }

    public static void read(String p0, WebViewCallback p1) {
        Storage.getStorage(p0);
        if (if-eqz(Storage.getStorage(..))) goto L_13;
        Storage.getStorage(..).readStorage();
        p1.invoke(Storage.getStorage(..));
      L_13:
        p1.error(StorageError.COULDNT_GET_STORAGE, 1);
      L_1c:
        return;
    }

    public static void set(String p0, String p1, Boolean p2, WebViewCallback p3) {
        Storage.set(p0, p1, p2, p3);
        return;
    }

    public static void set(String p0, String p1, Double p2, WebViewCallback p3) {
        Storage.set(p0, p1, p2, p3);
        return;
    }

    public static void set(String p0, String p1, Integer p2, WebViewCallback p3) {
        Storage.set(p0, p1, p2, p3);
        return;
    }

    public static void set(String p0, String p1, Long p2, WebViewCallback p3) {
        Storage.set(p0, p1, p2, p3);
        return;
    }

    public static void set(String p0, String p1, Object p2, WebViewCallback p3) {
        Storage.getStorage(p0);
        if (if-eqz(Storage.getStorage(..))) goto L_20;
        Storage.getStorage(..).set(p1, p2);
        if (if-eqz(Storage.set(..))) goto L_16;
        p3.invoke(Storage.set(..));
      L_16:
        p3.error(StorageError.COULDNT_SET_VALUE, p2);
      L_20:
        p3.error(StorageError.COULDNT_GET_STORAGE, 2);
      L_2c:
        return;
    }

    public static void set(String p0, String p1, String p2, WebViewCallback p3) {
        Storage.set(p0, p1, p2, p3);
        return;
    }

    public static void set(String p0, String p1, JSONArray p2, WebViewCallback p3) {
        Storage.set(p0, p1, p2, p3);
        return;
    }

    public static void set(String p0, String p1, JSONObject p2, WebViewCallback p3) {
        Storage.set(p0, p1, p2, p3);
        return;
    }

    public static void write(String p0, WebViewCallback p1) {
        Storage.getStorage(p0);
        if (if-eqz(Storage.getStorage(..))) goto L_20;
        Storage.getStorage(..).writeStorage();
        if (if-eqz(Storage.writeStorage(..))) goto L_16;
        p1.invoke(Storage.writeStorage(..));
      L_16:
        p1.error(StorageError.COULDNT_WRITE_STORAGE_TO_CACHE, 1);
      L_20:
        p1.error(StorageError.COULDNT_GET_STORAGE, 1);
      L_29:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Cache$1
// ============================================================
package com.unity3d.services.core.api;

class Cache$1 {
    Cache$1() {
        new Object();
        return;
    }

    public boolean accept(File p0, String p1) {
        SdkProperties.getCacheFilePrefix();
        p1.startsWith(SdkProperties.getCacheFilePrefix(..));
        return String.startsWith(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.DeviceInfo$1
// ============================================================
package com.unity3d.services.core.api;

class DeviceInfo$1 {
    static final int[] $SwitchMap$com$unity3d$services$core$api$DeviceInfo$StorageType;

    static <clinit>() {
        DeviceInfo$StorageType.values();
        $SwitchMap$com$unity3d$services$core$api$DeviceInfo$StorageType = DeviceInfo$StorageType.values(..);
        DeviceInfo$StorageType.INTERNAL.ordinal();
        DeviceInfo$StorageType.EXTERNAL.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.DeviceInfo$StorageType
// ============================================================
package com.unity3d.services.core.api;

public final class DeviceInfo$StorageType extends Enum {
    private static final DeviceInfo$StorageType[] $VALUES;
    public static final DeviceInfo$StorageType EXTERNAL;
    public static final DeviceInfo$StorageType INTERNAL;

    private static DeviceInfo$StorageType[] $values() {
        return 2;
    }

    static <clinit>() {
        new DeviceInfo$StorageType("EXTERNAL", 0);
        EXTERNAL = new DeviceInfo$StorageType(..);
        new DeviceInfo$StorageType("INTERNAL", 1);
        INTERNAL = new DeviceInfo$StorageType(..);
        DeviceInfo$StorageType.$values();
        $VALUES = DeviceInfo$StorageType.$values(..);
        return;
    }

    private DeviceInfo$StorageType(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static DeviceInfo$StorageType valueOf(String p0) {
        Enum.valueOf(DeviceInfo$StorageType.class, p0);
        return Enum.valueOf(..);
    }

    public static DeviceInfo$StorageType[] values() {
        DeviceInfo$StorageType.$VALUES.clone();
        return DeviceInfo$StorageType[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Intent$IntentError
// ============================================================
package com.unity3d.services.core.api;

public final class Intent$IntentError extends Enum {
    private static final Intent$IntentError[] $VALUES;
    public static final Intent$IntentError ACTIVITY_WAS_NULL;
    public static final Intent$IntentError COULDNT_PARSE_CATEGORIES;
    public static final Intent$IntentError COULDNT_PARSE_EXTRAS;
    public static final Intent$IntentError INTENT_WAS_NULL;
    public static final Intent$IntentError JSON_EXCEPTION;

    private static Intent$IntentError[] $values() {
        return 5;
    }

    static <clinit>() {
        new Intent$IntentError("COULDNT_PARSE_EXTRAS", 0);
        COULDNT_PARSE_EXTRAS = new Intent$IntentError(..);
        new Intent$IntentError("COULDNT_PARSE_CATEGORIES", 1);
        COULDNT_PARSE_CATEGORIES = new Intent$IntentError(..);
        new Intent$IntentError("INTENT_WAS_NULL", 2);
        INTENT_WAS_NULL = new Intent$IntentError(..);
        new Intent$IntentError("JSON_EXCEPTION", 3);
        JSON_EXCEPTION = new Intent$IntentError(..);
        new Intent$IntentError("ACTIVITY_WAS_NULL", 4);
        ACTIVITY_WAS_NULL = new Intent$IntentError(..);
        Intent$IntentError.$values();
        $VALUES = Intent$IntentError.$values(..);
        return;
    }

    private Intent$IntentError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static Intent$IntentError valueOf(String p0) {
        Enum.valueOf(Intent$IntentError.class, p0);
        return Enum.valueOf(..);
    }

    public static Intent$IntentError[] values() {
        Intent$IntentError.$VALUES.clone();
        return Intent$IntentError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Intent$IntentException
// ============================================================
package com.unity3d.services.core.api;

class Intent$IntentException extends Exception {
    private Intent$IntentError error;
    private Object field;

    public Intent$IntentException(Intent$IntentError p0, Object p1) {
        new Exception();
        error = p0;
        field = p1;
        return;
    }

    public Intent$IntentError getError() {
        return error;
    }

    public Object getField() {
        return field;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Request$1
// ============================================================
package com.unity3d.services.core.api;

class Request$1 {
    final String val$id;

    Request$1(String p0) {
        val$id = p0;
        new Object();
        return;
    }

    public void onComplete(String p0, String p1, int p2, Map p3) {
        Request.getResponseHeadersMap(p3);
        WebViewApp.getCurrentApp();
        Integer.valueOf(p2);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.REQUEST, WebRequestEvent.COMPLETE, 5);
        return;
        DeviceLog.exception("Error parsing response headers", p1);
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.REQUEST, WebRequestEvent.FAILED, 3);
        return;
    }

    public void onFailed(String p0, String p1) {
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.REQUEST, WebRequestEvent.FAILED, 3);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Request$2
// ============================================================
package com.unity3d.services.core.api;

class Request$2 {
    final String val$id;

    Request$2(String p0) {
        val$id = p0;
        new Object();
        return;
    }

    public void onComplete(String p0, String p1, int p2, Map p3) {
        Request.getResponseHeadersMap(p3);
        WebViewApp.getCurrentApp();
        Integer.valueOf(p2);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.REQUEST, WebRequestEvent.COMPLETE, 5);
        return;
        DeviceLog.exception("Error parsing response headers", p1);
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.REQUEST, WebRequestEvent.FAILED, 3);
        return;
    }

    public void onFailed(String p0, String p1) {
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.REQUEST, WebRequestEvent.FAILED, 3);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Request$3
// ============================================================
package com.unity3d.services.core.api;

class Request$3 {
    final String val$id;

    Request$3(String p0) {
        val$id = p0;
        new Object();
        return;
    }

    public void onComplete(String p0, String p1, int p2, Map p3) {
        Request.getResponseHeadersMap(p3);
        WebViewApp.getCurrentApp();
        Integer.valueOf(p2);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.REQUEST, WebRequestEvent.COMPLETE, 5);
        return;
        DeviceLog.exception("Error parsing response headers", p1);
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.REQUEST, WebRequestEvent.FAILED, 3);
        return;
    }

    public void onFailed(String p0, String p1) {
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.REQUEST, WebRequestEvent.FAILED, 3);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.api.Resolve$1
// ============================================================
package com.unity3d.services.core.api;

class Resolve$1 {
    final String val$id;

    Resolve$1(String p0) {
        val$id = p0;
        new Object();
        return;
    }

    public void onFailed(String p0, ResolveHostError p1, String p2) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_26;
        WebViewApp.getCurrentApp();
        p1.name();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.RESOLVE, ResolveHostEvent.FAILED, 4);
      L_26:
        return;
    }

    public void onResolve(String p0, String p1) {
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_1f;
        WebViewApp.getCurrentApp();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.RESOLVE, ResolveHostEvent.COMPLETE, 3);
      L_1f:
        return;
    }

}

