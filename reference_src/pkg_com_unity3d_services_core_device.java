// Package bundle: com.unity3d.services.core.device (32 classes)

// ============================================================
// CLASS: com.unity3d.services.core.device.AdvertisingId
// ============================================================
package com.unity3d.services.core.device;

public class AdvertisingId {
    private static final String ADVERTISING_ID_SERVICE_NAME = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
    private static AdvertisingId instance;
    private String advertisingIdentifier;
    private boolean limitedAdvertisingTracking;

    static <clinit>() {
        return;
    }

    public AdvertisingId() {
        new Object();
        advertisingIdentifier = 0;
        limitedAdvertisingTracking = 0;
        return;
    }

    private void fetchAdvertisingId(Context p0) {
        new AdvertisingId$GoogleAdvertisingServiceConnection(this, 0);
        new Intent("com.google.android.gms.ads.identifier.service.START");
        new Intent(..).setPackage("com.google.android.gms");
        p0.bindService(new Intent(..), new AdvertisingId$GoogleAdvertisingServiceConnection(..), 1);
        DeviceLog.exception("Couldn't bind to identifier service intent", Context.bindService(..));
      L_1f:
        if (if-eqz(0)) goto L_47;
        AdvertisingId$GoogleAdvertisingServiceConnection.getBinder();
        AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder.create(AdvertisingId$GoogleAdvertisingServiceConnection.getBinder(..));
        AdvertisingId$GoogleAdvertisingInfo.getId();
        advertisingIdentifier = AdvertisingId$GoogleAdvertisingInfo.getId(..);
        AdvertisingId$GoogleAdvertisingInfo.getEnabled(1);
        limitedAdvertisingTracking = AdvertisingId$GoogleAdvertisingInfo.getEnabled(..);
        DeviceLog.exception("Couldn't get advertising info", AdvertisingId$GoogleAdvertisingInfo.getEnabled(..));
        if (if-eqz(0)) goto L_4c;
      L_41:
        if (if-eqz(0)) goto L_46;
        p0.unbindService(new AdvertisingId$GoogleAdvertisingServiceConnection(..));
      L_46:
        throw AdvertisingId$GoogleAdvertisingInfo.getEnabled(..);
      L_47:
        if (if-eqz(0)) goto L_4c;
      L_49:
        p0.unbindService(new AdvertisingId$GoogleAdvertisingServiceConnection(..));
      L_4c:
        return;
    }

    public static String getAdvertisingTrackingId() {
        AdvertisingId.getInstance();
        return advertisingIdentifier;
    }

    private static AdvertisingId getInstance() {
        if (if-nez(AdvertisingId.instance)) goto L_b;
        new AdvertisingId();
        instance = new AdvertisingId(..);
      L_b:
        return AdvertisingId.instance;
    }

    public static boolean getLimitedAdTracking() {
        AdvertisingId.getInstance();
        return limitedAdvertisingTracking;
    }

    public static void init(Context p0) {
        AdvertisingId.getInstance();
        AdvertisingId.getInstance(..).fetchAdvertisingId(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.Device
// ============================================================
package com.unity3d.services.core.device;

public class Device {
    private static ConcurrentHashMap _reportedWarning;
    private static SDKMetricsSender sdkMetricsSender;

    static <clinit>() {
        new ConcurrentHashMap();
        _reportedWarning = new ConcurrentHashMap(..);
        Utilities.getService(SDKMetricsSender.class);
        sdkMetricsSender = Utilities.getService(..);
        return;
    }

    public Device() {
        new Object();
        return;
    }

    public static String getAdvertisingTrackingId() {
        AdvertisingId.getAdvertisingTrackingId();
        return AdvertisingId.getAdvertisingTrackingId(..);
    }

    public static int getApiLevel() {
        return Build$VERSION.SDK_INT;
    }

    public static String getApkDigest() {
        ClientProperties.getApplicationContext();
        Context.getPackageCodePath();
        System.nanoTime();
        new File(Context.getPackageCodePath(..));
        new File(..).length();
        new FileInputStream(new File(..));
        Utilities.Sha256(new FileInputStream(..));
        new FileInputStream(..).close();
        System.nanoTime();
        TimeUnit.NANOSECONDS.toMillis(System.nanoTime(..), v8);
        if (if-lez(TimeUnit.toMillis(..))) goto L_47;
        Long.valueOf(File.length(..), v6);
        new Metric("native_device_info_apk_digest_timeout", Long.valueOf(..));
        Device.sdkMetricsSender.sendMetric(new Metric(..));
      L_47:
        Long.valueOf(File.length(..), v6);
        new Metric("native_device_info_apk_size", Long.valueOf(..));
        Device.sdkMetricsSender.sendMetric(new Metric(..));
        return Utilities.Sha256(..);
      L_5c:
        if (if-eqz(Device.sdkMetricsSender)) goto L_61;
        Device.sdkMetricsSender.close();
      L_61:
        throw new Metric(..);
    }

    public static String getAuid() {
        AndroidPreferences.getString("supersonic_shared_preferen", "auid");
        return AndroidPreferences.getString(..);
    }

    public static float getBatteryLevel() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_29;
        ClientProperties.getApplicationContext();
        new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Context.registerReceiver(0, new IntentFilter(..));
        if (if-eqz(Context.registerReceiver(..))) goto L_29;
        Context.registerReceiver(..).getIntExtra("level", -1);
        Context.registerReceiver(..).getIntExtra("scale", -1);
        return Intent.getIntExtra(..);
      L_29:
        return -1.0f;
    }

    public static int getBatteryStatus() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_20;
        ClientProperties.getApplicationContext();
        new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Context.registerReceiver(0, new IntentFilter(..));
        if (if-eqz(Context.registerReceiver(..))) goto L_20;
        Context.registerReceiver(..).getIntExtra("status", -1);
        return Intent.getIntExtra(..);
      L_20:
        return -1;
    }

    public static String getBoard() {
        return Build.BOARD;
    }

    public static String getBootloader() {
        return Build.BOOTLOADER;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getBuildId() {
        return Build.ID;
    }

    public static String getBuildVersionIncremental() {
        return Build$VERSION.INCREMENTAL;
    }

    public static long getCPUCount() {
        Runtime.getRuntime();
        Runtime.getRuntime(..).availableProcessors();
        return Runtime.availableProcessors(..);
    }

    public static String getCertificateFingerprint() {
        ClientProperties.getApplicationContext();
        Context.getPackageManager();
        ClientProperties.getApplicationContext();
        Context.getPackageName();
        Context.getPackageManager(..).getPackageInfo(Context.getPackageName(..), 64);
        if (if-eqz(signatures)) goto L_51;
        if (if-lt(Context.getPackageName(..), 1)) goto L_51;
        CertificateFactory.getInstance("X.509");
        signatures.toByteArray();
        new ByteArrayInputStream(Signature.toByteArray(..));
        CertificateFactory.getInstance(..).generateCertificate(new ByteArrayInputStream(..));
        MessageDigest.getInstance("SHA-1");
        X509Certificate.getEncoded();
        MessageDigest.getInstance(..).digest(X509Certificate.getEncoded(..));
        Utilities.toHexString(MessageDigest.digest(..));
        DeviceLog.exception("Exception when signing certificate fingerprint", Utilities.toHexString(..));
      L_51:
        return Utilities.toHexString(..);
    }

    public static String getConnectionType() {
        Device.isUsingWifi();
        if (if-eqz(Device.isUsingWifi(..))) goto L_9;
      L_9:
        Device.isActiveNetworkConnected();
        if (if-eqz(Device.isActiveNetworkConnected(..))) goto L_12;
      L_12:
      L_14:
        return "none";
    }

    public static String getDevice() {
        return Build.DEVICE;
    }

    public static float getDisplayMetricDensity() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_15;
        ClientProperties.getApplicationContext();
        Context.getResources();
        Context.getResources(..).getDisplayMetrics();
        return density;
      L_15:
        return -1.0f;
    }

    public static long getElapsedRealtime() {
        SystemClock.elapsedRealtime();
        return SystemClock.elapsedRealtime(..);
    }

    public static int getExtensionVersion() {
        if (if-lt(Build$VERSION.SDK_INT, 30)) goto L_b;
        SdkExtensions.getExtensionVersion(30);
        return SdkExtensions.getExtensionVersion(..);
      L_b:
        return -1;
    }

    public static String getFingerprint() {
        return Build.FINGERPRINT;
    }

    public static long getFreeMemory() {
        Device.getMemoryInfo(Device$MemoryInfoType.FREE_MEMORY);
        return Device.getMemoryInfo(..);
    }

    public static long getFreeSpace(File p0) {
        if (if-eqz(p0)) goto L_16;
        p0.exists();
        if (if-eqz(File.exists(..))) goto L_16;
        p0.getFreeSpace();
        Math.round(p0);
        return File.getFreeSpace(..);
      L_16:
        return -1L;
    }

    public static String getGLVersion() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_1f;
        ClientProperties.getApplicationContext();
        Context.getSystemService("activity");
        if (if-eqz(Context.getSystemService(..))) goto L_1f;
        Context.getSystemService(..).getDeviceConfigurationInfo();
        if (if-eqz(ActivityManager.getDeviceConfigurationInfo(..))) goto L_1f;
        ConfigurationInfo.getGlEsVersion();
        return ConfigurationInfo.getGlEsVersion(..);
      L_1f:
        return 0;
    }

    public static String getHardware() {
        return Build.HARDWARE;
    }

    public static String getHost() {
        return Build.HOST;
    }

    public static String getIdfi() {
        AndroidPreferences.getString("unityads-installinfo", "unityads-idfi");
        if (if-nez(AndroidPreferences.getString(..))) goto L_e;
        Device.getAuid();
      L_e:
        if (if-nez(Device.getAuid(..))) goto L_17;
        Device.getUniqueEventId();
        AndroidPreferences.setString("unityads-installinfo", "unityads-idfi", Device.getUniqueEventId(..));
      L_17:
        return Device.getUniqueEventId(..);
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    private static long getMemoryInfo(Device$MemoryInfoType p0) {
        p0.ordinal();
        if (if-eq(Device$1.$SwitchMap$com$unity3d$services$core$device$Device$MemoryInfoType, 1)) goto L_11;
        if (if-eq(Device$1.$SwitchMap$com$unity3d$services$core$device$Device$MemoryInfoType, 2)) goto L_11;
      L_11:
        new RandomAccessFile("/proc/meminfo", "r");
      L_1c:
        if (if-ge(0, -1)) goto L_25;
        new RandomAccessFile(..).readLine();
      L_25:
        Device.getMemoryValueFromString(RandomAccessFile.readLine(..));
        new RandomAccessFile(..).close();
        DeviceLog.exception("Error closing RandomAccessFile", p0);
      L_31:
        return Device.getMemoryValueFromString(..);
      L_39:
        new StringBuilder();
        new StringBuilder(..).append("Error while reading memory info: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        DeviceLog.exception(StringBuilder.toString(..), -1);
        if (if-eqz(Device.getMemoryValueFromString(..))) goto L_57;
        Device.getMemoryValueFromString(..).close();
        DeviceLog.exception("Error closing RandomAccessFile", StringBuilder.toString(..));
      L_57:
        return -1L;
      L_5c:
        if (if-eqz(Device.getMemoryValueFromString(..))) goto L_66;
        Device.getMemoryValueFromString(..).close();
        DeviceLog.exception(-1L, Device.getMemoryValueFromString(..));
      L_66:
        throw StringBuilder.toString(..);
    }

    private static long getMemoryValueFromString(String p0) {
        if (if-eqz(p0)) goto L_1f;
        Pattern.compile("(\\d+)");
        Pattern.compile(..).matcher(p0);
      L_e:
        Pattern.matcher(..).find();
        if (if-eqz(Matcher.find(..))) goto L_1a;
        Pattern.matcher(..).group(1);
      L_1a:
        Long.parseLong(Matcher.group(..));
        return Long.parseLong(..);
      L_1f:
        return -1L;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getNetworkCountryISO() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_17;
        ClientProperties.getApplicationContext();
        Context.getSystemService("phone");
        Context.getSystemService(..).getNetworkCountryIso();
        return TelephonyManager.getNetworkCountryIso(..);
      L_17:
        return "";
    }

    public static boolean getNetworkMetered() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_1b;
        ClientProperties.getApplicationContext();
        Context.getSystemService("connectivity");
        if (if-nez(Context.getSystemService(..))) goto L_16;
        return 0;
      L_16:
        Context.getSystemService(..).isActiveNetworkMetered();
        return ConnectivityManager.isActiveNetworkMetered(..);
      L_1b:
        return 0;
    }

    public static String getNetworkOperator() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_17;
        ClientProperties.getApplicationContext();
        Context.getSystemService("phone");
        Context.getSystemService(..).getNetworkOperator();
        return TelephonyManager.getNetworkOperator(..);
      L_17:
        return "";
    }

    public static String getNetworkOperatorName() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_17;
        ClientProperties.getApplicationContext();
        Context.getSystemService("phone");
        Context.getSystemService(..).getNetworkOperatorName();
        return TelephonyManager.getNetworkOperatorName(..);
      L_17:
        return "";
    }

    public static int getNetworkType() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_30;
        ClientProperties.getApplicationContext();
        Context.getSystemService("phone");
        Context.getSystemService(..).getNetworkType();
        return TelephonyManager.getNetworkType(..);
        Device._reportedWarning.containsKey("getNetworkType");
        if (if-nez(ConcurrentHashMap.containsKey(..))) goto L_30;
        DeviceLog.warning("Unity Ads was not able to get current network type due to missing permission");
        Boolean.valueOf(1);
        Device._reportedWarning.put("getNetworkType", Boolean.valueOf(..));
      L_30:
        return -1;
    }

    private static ArrayList getNewAbiList() {
        new ArrayList();
        Arrays.asList(Build.SUPPORTED_ABIS);
        new ArrayList(..).addAll(Arrays.asList(..));
        return new ArrayList(..);
    }

    private static ArrayList getOldAbiList() {
        new ArrayList();
        new ArrayList(..).add(Build.CPU_ABI);
        new ArrayList(..).add(Build.CPU_ABI2);
        return new ArrayList(..);
    }

    public static String getOpenAdvertisingTrackingId() {
        OpenAdvertisingId.getOpenAdvertisingTrackingId();
        return OpenAdvertisingId.getOpenAdvertisingTrackingId(..);
    }

    public static String getOsVersion() {
        return Build$VERSION.RELEASE;
    }

    public static JSONObject getPackageInfo(PackageManager p0) {
        ClientProperties.getAppName();
        p0.getPackageInfo(ClientProperties.getAppName(..), 0);
        new JSONObject();
        p0.getInstallerPackageName(ClientProperties.getAppName(..));
        new JSONObject(..).put("installer", PackageManager.getInstallerPackageName(..));
        new JSONObject(..).put("firstInstallTime", firstInstallTime, v4);
        new JSONObject(..).put("lastUpdateTime", lastUpdateTime, v4);
        new JSONObject(..).put("versionCode", versionCode);
        new JSONObject(..).put("versionName", versionName);
        new JSONObject(..).put("packageName", packageName);
        return new JSONObject(..);
    }

    public static Map getProcessInfo() {
        new HashMap();
        new RandomAccessFile("/proc/self/stat", "r");
        new RandomAccessFile(..).readLine();
        new HashMap(..).put("stat", RandomAccessFile.readLine(..));
        new RandomAccessFile(..).close();
      L_26:
        DeviceLog.exception("Error while reading processor info: ", new RandomAccessFile(..));
        if (if-eqz(RandomAccessFile.readLine(..))) goto L_35;
        RandomAccessFile.readLine(..).close();
        DeviceLog.exception("Error closing RandomAccessFile", new RandomAccessFile(..));
      L_35:
        return new HashMap(..);
      L_38:
        if (if-eqz(RandomAccessFile.readLine(..))) goto L_42;
        RandomAccessFile.readLine(..).close();
        DeviceLog.exception("Error closing RandomAccessFile", RandomAccessFile.readLine(..));
      L_42:
        throw new HashMap(..);
    }

    public static String getProduct() {
        return Build.PRODUCT;
    }

    public static int getRingerMode() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_1b;
        ClientProperties.getApplicationContext();
        Context.getSystemService("audio");
        if (if-eqz(Context.getSystemService(..))) goto L_19;
        Context.getSystemService(..).getRingerMode();
        return AudioManager.getRingerMode(..);
      L_19:
        return -2;
      L_1b:
        return -1;
    }

    public static int getScreenBrightness() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_16;
        ClientProperties.getApplicationContext();
        Context.getContentResolver();
        Settings$System.getInt(Context.getContentResolver(..), "screen_brightness", -1);
        return Settings$System.getInt(..);
      L_16:
        return -1;
    }

    public static int getScreenDensity() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_15;
        ClientProperties.getApplicationContext();
        Context.getResources();
        Context.getResources(..).getDisplayMetrics();
        return densityDpi;
      L_15:
        return -1;
    }

    public static int getScreenHeight() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_15;
        ClientProperties.getApplicationContext();
        Context.getResources();
        Context.getResources(..).getDisplayMetrics();
        return heightPixels;
      L_15:
        return -1;
    }

    public static int getScreenLayout() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_15;
        ClientProperties.getApplicationContext();
        Context.getResources();
        Context.getResources(..).getConfiguration();
        return screenLayout;
      L_15:
        return -1;
    }

    public static int getScreenWidth() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_15;
        ClientProperties.getApplicationContext();
        Context.getResources();
        Context.getResources(..).getDisplayMetrics();
        return widthPixels;
      L_15:
        return -1;
    }

    public static List getSensorList() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_18;
        ClientProperties.getApplicationContext();
        Context.getSystemService("sensor");
        Context.getSystemService(..).getSensorList(-1);
        return SensorManager.getSensorList(..);
      L_18:
        return 0;
    }

    public static int getStreamMaxVolume(int p0) {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_1b;
        ClientProperties.getApplicationContext();
        Context.getSystemService("audio");
        if (if-eqz(Context.getSystemService(..))) goto L_19;
        Context.getSystemService(..).getStreamMaxVolume(p0);
        return AudioManager.getStreamMaxVolume(..);
      L_19:
        return -2;
      L_1b:
        return -1;
    }

    public static int getStreamVolume(int p0) {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_1b;
        ClientProperties.getApplicationContext();
        Context.getSystemService("audio");
        if (if-eqz(Context.getSystemService(..))) goto L_19;
        Context.getSystemService(..).getStreamVolume(p0);
        return AudioManager.getStreamVolume(..);
      L_19:
        return -2;
      L_1b:
        return -1;
    }

    public static ArrayList getSupportedAbis() {
        Device.getApiLevel();
        if (if-ge(Device.getApiLevel(..), 21)) goto L_d;
        Device.getOldAbiList();
        return Device.getOldAbiList(..);
      L_d:
        Device.getNewAbiList();
        return Device.getNewAbiList(..);
    }

    public static String getSystemProperty(String p0, String p1) {
        if (if-eqz(p1)) goto L_7;
        System.getProperty(p0, p1);
        return System.getProperty(..);
      L_7:
        System.getProperty(System.getProperty(..));
        return System.getProperty(..);
    }

    public static long getTotalMemory() {
        Device.getMemoryInfo(Device$MemoryInfoType.TOTAL_MEMORY);
        return Device.getMemoryInfo(..);
    }

    public static long getTotalSpace(File p0) {
        if (if-eqz(p0)) goto L_16;
        p0.exists();
        if (if-eqz(File.exists(..))) goto L_16;
        p0.getTotalSpace();
        Math.round(p0);
        return File.getTotalSpace(..);
      L_16:
        return -1L;
    }

    public static String getUniqueEventId() {
        UUID.randomUUID();
        UUID.randomUUID(..).toString();
        return UUID.toString(..);
    }

    public static long getUptime() {
        SystemClock.uptimeMillis();
        return SystemClock.uptimeMillis(..);
    }

    public static boolean hasAV1Decoder() {
        Device.selectAllDecodeCodecs("video/av01");
        Device.selectAllDecodeCodecs(..).size();
        if (if-lez(List.size(..))) goto L_e;
      L_e:
      L_f:
        return 0;
    }

    public static boolean hasX264Decoder() {
        Device.selectAllDecodeCodecs("video/avc");
        Device.selectAllDecodeCodecs(..).size();
        if (if-lez(List.size(..))) goto L_e;
      L_e:
      L_f:
        return 0;
    }

    public static boolean hasX265Decoder() {
        Device.selectAllDecodeCodecs("video/hevc");
        Device.selectAllDecodeCodecs(..).size();
        if (if-lez(List.size(..))) goto L_e;
      L_e:
      L_f:
        return 0;
    }

    public static boolean isActiveNetworkConnected() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_22;
        ClientProperties.getApplicationContext();
        Context.getSystemService("connectivity");
        if (if-eqz(Context.getSystemService(..))) goto L_22;
        Context.getSystemService(..).getActiveNetworkInfo();
        if (if-eqz(ConnectivityManager.getActiveNetworkInfo(..))) goto L_22;
        NetworkInfo.isConnected();
        if (if-eqz(NetworkInfo.isConnected(..))) goto L_22;
      L_22:
        return 1;
    }

    public static Boolean isAdbEnabled() {
        Device.getApiLevel();
        if (if-ge(Device.getApiLevel(..), 17)) goto L_d;
        Device.oldAdbStatus();
      L_d:
        Device.newAdbStatus();
      L_11:
        return Device.newAdbStatus(..);
    }

    private static boolean isHardwareAccelerated(MediaCodecInfo p0, String p1) {
        Device.getApiLevel();
        if (if-lt(Device.getApiLevel(..), 29)) goto L_d;
        Device.isHardwareAcceleratedV29(p0);
        return Device.isHardwareAcceleratedV29(..);
      L_d:
        Device.isSoftwareOnly(Device.isHardwareAcceleratedV29(..), p1);
        return Device.isSoftwareOnly(..);
    }

    private static boolean isHardwareAcceleratedV29(MediaCodecInfo p0) {
        p0.isHardwareAccelerated();
        return MediaCodecInfo.isHardwareAccelerated(..);
    }

    public static boolean isLimitAdTrackingEnabled() {
        AdvertisingId.getLimitedAdTracking();
        return AdvertisingId.getLimitedAdTracking(..);
    }

    public static boolean isLimitOpenAdTrackingEnabled() {
        OpenAdvertisingId.getLimitedOpenAdTracking();
        return OpenAdvertisingId.getLimitedOpenAdTracking(..);
    }

    public static boolean isRooted() {
        Device.searchPathForBinary("su");
        return Device.searchPathForBinary(..);
        DeviceLog.exception("Rooted check failed", Device.searchPathForBinary(..));
        return 0;
    }

    private static boolean isSoftwareOnly(MediaCodecInfo p0, String p1) {
        Device.getApiLevel();
        if (if-lt(Device.getApiLevel(..), 29)) goto L_d;
        Device.isSoftwareOnlyV29(p0);
        return Device.isSoftwareOnlyV29(..);
      L_d:
        Device.isSoftwareOnlyV29(..).getName();
        MediaCodecInfo.getName(..).toLowerCase();
        String.toLowerCase(..).startsWith("arc.");
        if (if-eqz(String.startsWith(..))) goto L_1f;
        return 0;
      L_1f:
        String.toLowerCase(..).startsWith("omx.google.");
        if (if-nez(String.startsWith(..))) goto L_67;
        String.toLowerCase(..).startsWith("omx.ffmpeg.");
        if (if-nez(String.startsWith(..))) goto L_67;
        String.toLowerCase(..).startsWith("omx.sec.");
        if (if-eqz(String.startsWith(..))) goto L_3f;
        String.toLowerCase(..).contains(".sw.");
        if (if-nez(String.contains(..))) goto L_67;
      L_3f:
        String.toLowerCase(..).equals("omx.qcom.video.decoder.hevcswvdec");
        if (if-nez(String.equals(..))) goto L_67;
        String.toLowerCase(..).startsWith("c2.android.");
        if (if-nez(String.startsWith(..))) goto L_67;
        String.toLowerCase(..).startsWith("c2.google.");
        if (if-nez(String.startsWith(..))) goto L_67;
        String.toLowerCase(..).startsWith("omx.");
        if (if-nez(String.startsWith(..))) goto L_68;
        String.toLowerCase(..).startsWith("c2.");
        if (if-nez(String.startsWith(..))) goto L_68;
      L_67:
      L_68:
        return 1;
    }

    private static boolean isSoftwareOnlyV29(MediaCodecInfo p0) {
        p0.isSoftwareOnly();
        return MediaCodecInfo.isSoftwareOnly(..);
    }

    public static boolean isUSBConnected() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_20;
        ClientProperties.getApplicationContext();
        new IntentFilter("android.hardware.usb.action.USB_STATE");
        Context.registerReceiver(0, new IntentFilter(..));
        if (if-eqz(Context.registerReceiver(..))) goto L_20;
        Context.registerReceiver(..).getBooleanExtra("connected", 0);
        return Intent.getBooleanExtra(..);
      L_20:
        return 0;
    }

    public static boolean isUsingWifi() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_49;
        ClientProperties.getApplicationContext();
        Context.getSystemService("connectivity");
        if (if-nez(Context.getSystemService(..))) goto L_16;
        return 0;
      L_16:
        ClientProperties.getApplicationContext();
        Context.getSystemService("phone");
        Context.getSystemService(..).getActiveNetworkInfo();
        if (if-eqz(ConnectivityManager.getActiveNetworkInfo(..))) goto L_49;
        Context.getSystemService(..).getBackgroundDataSetting();
        if (if-eqz(ConnectivityManager.getBackgroundDataSetting(..))) goto L_49;
        Context.getSystemService(..).getActiveNetworkInfo();
        NetworkInfo.isConnected();
        if (if-eqz(NetworkInfo.isConnected(..))) goto L_49;
        if (if-nez(Context.getSystemService(..))) goto L_3b;
      L_3b:
        NetworkInfo.getType();
        if (if-ne(NetworkInfo.getType(..), 1)) goto L_49;
        NetworkInfo.isConnected();
        if (if-eqz(NetworkInfo.isConnected(..))) goto L_49;
      L_49:
        return 1;
    }

    public static boolean isWiredHeadsetOn() {
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_17;
        ClientProperties.getApplicationContext();
        Context.getSystemService("audio");
        Context.getSystemService(..).isWiredHeadsetOn();
        return AudioManager.isWiredHeadsetOn(..);
      L_17:
        return 0;
    }

    private static Boolean newAdbStatus() {
        ClientProperties.getApplicationContext();
        Context.getContentResolver();
        Settings$Global.getInt(Context.getContentResolver(..), "adb_enabled", 0);
        if (if-ne(1, Settings$Global.getInt(..))) goto L_13;
      L_13:
        Boolean.valueOf(1);
        DeviceLog.exception("Problems fetching adb enabled status", Boolean.valueOf(..));
      L_1f:
        return 0;
    }

    private static Boolean oldAdbStatus() {
        ClientProperties.getApplicationContext();
        Context.getContentResolver();
        Settings$Secure.getInt(Context.getContentResolver(..), "adb_enabled", 0);
        if (if-ne(1, Settings$Secure.getInt(..))) goto L_13;
      L_13:
        Boolean.valueOf(1);
        DeviceLog.exception("Problems fetching adb enabled status", Boolean.valueOf(..));
      L_1f:
        return 0;
    }

    private static boolean searchPathForBinary(String p0) {
        System.getenv("PATH");
        System.getenv(..).split(":");
      L_f:
        if (if-ge(0, ":")) goto L_42;
        new File(v4);
        new File(..).exists();
        if (if-eqz(File.exists(..))) goto L_3f;
        new File(..).isDirectory();
        if (if-eqz(File.isDirectory(..))) goto L_3f;
        new File(..).listFiles();
        if (if-eqz(File.listFiles(..))) goto L_3f;
      L_2c:
        if (if-ge(0, new File(..))) goto L_3f;
        File.getName();
        File.getName(..).equals(p0);
        if (if-eqz(String.equals(..))) goto L_3c;
        return 1;
      L_3c:
      L_3f:
      L_42:
        return 0;
    }

    public static List selectAllDecodeCodecs(String p0) {
        new ArrayList();
        MediaCodecList.getCodecCount();
      L_b:
        if (if-ge(0, MediaCodecList.getCodecCount(..))) goto L_37;
        MediaCodecList.getCodecInfoAt(0);
        MediaCodecList.getCodecInfoAt(..).isEncoder();
        if (if-eqz(MediaCodecInfo.isEncoder(..))) goto L_18;
      L_18:
        MediaCodecList.getCodecInfoAt(..).getSupportedTypes();
      L_1d:
        if (if-ge(0, v7)) goto L_34;
        String.equalsIgnoreCase(p0);
        if (if-eqz(String.equalsIgnoreCase(..))) goto L_31;
        Device.isHardwareAccelerated(MediaCodecList.getCodecInfoAt(..), p0);
        if (if-eqz(Device.isHardwareAccelerated(..))) goto L_31;
        new ArrayList(..).add(MediaCodecList.getCodecInfoAt(..));
      L_31:
      L_34:
      L_37:
        return new ArrayList(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.DeviceError
// ============================================================
package com.unity3d.services.core.device;

public final class DeviceError extends Enum {
    private static final DeviceError[] $VALUES;
    public static final DeviceError APPLICATION_CONTEXT_NULL;
    public static final DeviceError APPLICATION_INFO_NOT_AVAILABLE;
    public static final DeviceError AUDIOMANAGER_NULL;
    public static final DeviceError COULDNT_GET_ADB_STATUS;
    public static final DeviceError COULDNT_GET_DIGEST;
    public static final DeviceError COULDNT_GET_FINGERPRINT;
    public static final DeviceError COULDNT_GET_GL_VERSION;
    public static final DeviceError COULDNT_GET_STORAGE_LOCATION;
    public static final DeviceError INVALID_STORAGETYPE;
    public static final DeviceError JSON_ERROR;

    private static DeviceError[] $values() {
        return 10;
    }

    static <clinit>() {
        new DeviceError("APPLICATION_CONTEXT_NULL", 0);
        APPLICATION_CONTEXT_NULL = new DeviceError(..);
        new DeviceError("APPLICATION_INFO_NOT_AVAILABLE", 1);
        APPLICATION_INFO_NOT_AVAILABLE = new DeviceError(..);
        new DeviceError("AUDIOMANAGER_NULL", 2);
        AUDIOMANAGER_NULL = new DeviceError(..);
        new DeviceError("INVALID_STORAGETYPE", 3);
        INVALID_STORAGETYPE = new DeviceError(..);
        new DeviceError("COULDNT_GET_STORAGE_LOCATION", 4);
        COULDNT_GET_STORAGE_LOCATION = new DeviceError(..);
        new DeviceError("COULDNT_GET_GL_VERSION", 5);
        COULDNT_GET_GL_VERSION = new DeviceError(..);
        new DeviceError("JSON_ERROR", 6);
        JSON_ERROR = new DeviceError(..);
        new DeviceError("COULDNT_GET_DIGEST", 7);
        COULDNT_GET_DIGEST = new DeviceError(..);
        new DeviceError("COULDNT_GET_FINGERPRINT", 8);
        COULDNT_GET_FINGERPRINT = new DeviceError(..);
        new DeviceError("COULDNT_GET_ADB_STATUS", 9);
        COULDNT_GET_ADB_STATUS = new DeviceError(..);
        DeviceError.$values();
        $VALUES = DeviceError.$values(..);
        return;
    }

    private DeviceError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static DeviceError valueOf(String p0) {
        Enum.valueOf(DeviceError.class, p0);
        return Enum.valueOf(..);
    }

    public static DeviceError[] values() {
        DeviceError.$VALUES.clone();
        return DeviceError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.DeviceInfoEvent
// ============================================================
package com.unity3d.services.core.device;

public final class DeviceInfoEvent extends Enum {
    private static final DeviceInfoEvent[] $VALUES;
    public static final DeviceInfoEvent VOLUME_CHANGED;

    private static final DeviceInfoEvent[] $values() {
        return 1;
    }

    static <clinit>() {
        new DeviceInfoEvent("VOLUME_CHANGED", 0);
        VOLUME_CHANGED = new DeviceInfoEvent(..);
        DeviceInfoEvent.$values();
        $VALUES = DeviceInfoEvent.$values(..);
        return;
    }

    private DeviceInfoEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static DeviceInfoEvent valueOf(String p0) {
        Enum.valueOf(DeviceInfoEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static DeviceInfoEvent[] values() {
        DeviceInfoEvent.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.MimeTypes
// ============================================================
package com.unity3d.services.core.device;

public class MimeTypes {
    public static final String BASE_TYPE_AUDIO = "audio";
    public static final String BASE_TYPE_VIDEO = "video";
    public static final String VIDEO_AV1 = "video/av01";
    public static final String VIDEO_H264 = "video/avc";
    public static final String VIDEO_H265 = "video/hevc";
    public static final String VIDEO_WEBM = "video/webm";

    public MimeTypes() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.OpenAdvertisingId
// ============================================================
package com.unity3d.services.core.device;

public class OpenAdvertisingId {
    private static final String HW_DEVICE_NAME = "HUAWEI";
    private static final String HW_OPEN_ADVERTISING_ID_SERVICE_NAME = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
    private static OpenAdvertisingId instance;
    private boolean limitedOpenAdTracking;
    private String openAdvertisingIdentifier;

    static <clinit>() {
        return;
    }

    public OpenAdvertisingId() {
        new Object();
        openAdvertisingIdentifier = 0;
        limitedOpenAdTracking = 0;
        return;
    }

    private void fetchOAId(Context p0) {
        new OpenAdvertisingId$HWAdvertisingServiceConnection(this, 0);
        new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        new Intent(..).setPackage("com.huawei.hwid");
        p0.bindService(new Intent(..), new OpenAdvertisingId$HWAdvertisingServiceConnection(..), 1);
        if (if-nez(Context.bindService(..))) goto L_1a;
        return;
      L_1a:
        OpenAdvertisingId$HWAdvertisingServiceConnection.getBinder();
        OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder.create(OpenAdvertisingId$HWAdvertisingServiceConnection.getBinder(..));
        OpenAdvertisingId$HWAdvertisingInfo.getId();
        openAdvertisingIdentifier = OpenAdvertisingId$HWAdvertisingInfo.getId(..);
        OpenAdvertisingId$HWAdvertisingInfo.getEnabled(1);
        limitedOpenAdTracking = OpenAdvertisingId$HWAdvertisingInfo.getEnabled(..);
        DeviceLog.exception("Couldn't get openAdvertising info", OpenAdvertisingId$HWAdvertisingInfo.getEnabled(..));
      L_37:
        p0.unbindService(new OpenAdvertisingId$HWAdvertisingServiceConnection(..));
        return;
      L_3b:
        p0.unbindService(new OpenAdvertisingId$HWAdvertisingServiceConnection(..));
        throw OpenAdvertisingId$HWAdvertisingInfo.getEnabled(..);
        DeviceLog.exception("Couldn't bind to identifier service intent", p0);
        return;
    }

    private static OpenAdvertisingId getInstance() {
        if (if-nez(OpenAdvertisingId.instance)) goto L_b;
        new OpenAdvertisingId();
        instance = new OpenAdvertisingId(..);
      L_b:
        return OpenAdvertisingId.instance;
    }

    public static boolean getLimitedOpenAdTracking() {
        OpenAdvertisingId.getInstance();
        return limitedOpenAdTracking;
    }

    public static String getOpenAdvertisingTrackingId() {
        OpenAdvertisingId.getInstance();
        return openAdvertisingIdentifier;
    }

    public static void init(Context p0) {
        Build.MANUFACTURER.toUpperCase();
        String.toUpperCase(..).equals("HUAWEI");
        if (if-eqz(String.equals(..))) goto L_15;
        OpenAdvertisingId.getInstance();
        OpenAdvertisingId.getInstance(..).fetchOAId(p0);
      L_15:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.Storage
// ============================================================
package com.unity3d.services.core.device;

public final class Storage extends JsonStorage {
    public static final Storage$Companion Companion;
    private static final MutableStateFlow onStorageEventCallbacks;
    private final String _targetFileName;
    private final StorageManager$StorageType type;

    static <clinit>() {
        new Storage$Companion(0);
        Companion = new Storage$Companion(..);
        CollectionsKt.emptyList();
        StateFlowKt.MutableStateFlow(CollectionsKt.emptyList(..));
        onStorageEventCallbacks = StateFlowKt.MutableStateFlow(..);
        return;
    }

    public Storage(String p0, StorageManager$StorageType p1) {
        new JsonStorage();
        _targetFileName = p0;
        type = p1;
        return;
    }

    public static final MutableStateFlow access$getOnStorageEventCallbacks$cp() {
        return Storage.onStorageEventCallbacks;
    }

    public final boolean clearStorage() {
        Storage.clearData();
        new File(_targetFileName);
        new File(..).delete();
        return File.delete(..);
        throw File.delete(..);
    }

    public final StorageManager$StorageType getType() {
        return type;
    }

    public final boolean initStorage() {
        Storage.readStorage();
        JsonStorage.initData();
        return 1;
        throw 1;
    }

    public final boolean readStorage() {
        new File(_targetFileName);
        Utilities.readFileBytes(new File(..));
        if (if-nez(Utilities.readFileBytes(..))) goto L_12;
        return 0;
      L_12:
        new String(Utilities.readFileBytes(..), Charsets.UTF_8);
        new JSONObject(new String(..));
        Storage.setData(new JSONObject(..));
        DeviceLog.debug("Failed to read storage JSON file:", 1);
        DeviceLog.debug("Storage JSON file not found in local cache:", 1);
      L_37:
      L_38:
        return 0;
        throw new JSONObject(..);
    }

    public final void sendEvent(StorageEvent p0, Object p1) {
        Storage.onStorageEventCallbacks.getValue();
        MutableStateFlow.getValue(..).isEmpty();
        if (if-eqz(Collection.isEmpty(..))) goto L_36;
        Intrinsics.checkNotNull(p0);
        new StorageEventInfo(p0, type, p1);
        MutableStateFlow.getValue(..).iterator();
      L_24:
        Iterable.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_34;
        Iterable.iterator(..).next();
        Iterator.next(..).invoke(new StorageEventInfo(..));
      L_34:
        return;
      L_36:
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_58;
        WebViewApp.getCurrentApp();
        type.name();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.STORAGE, Iterable.iterator(..), 2);
      L_58:
        if (if-nez(WebViewApp.sendEvent(..))) goto L_5f;
        DeviceLog.debug("Couldn't send storage event to WebApp");
      L_5f:
        return;
        throw "Couldn't send storage event to WebApp";
    }

    public final boolean storageFileExists() {
        new File(_targetFileName);
        new File(..).exists();
        return File.exists(..);
        throw File.exists(..);
    }

    public final boolean writeStorage() {
        new File(_targetFileName);
        Storage.getData();
        if (if-eqz(Storage.getData(..))) goto L_1c;
        Storage.getData();
        Storage.getData(..).toString();
        Utilities.writeFile(new File(..), JSONObject.toString(..));
        return Utilities.writeFile(..);
      L_1c:
        return 0;
        throw 0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.StorageError
// ============================================================
package com.unity3d.services.core.device;

public final class StorageError extends Enum {
    private static final StorageError[] $VALUES;
    public static final StorageError COULDNT_CLEAR_STORAGE;
    public static final StorageError COULDNT_DELETE_VALUE;
    public static final StorageError COULDNT_GET_STORAGE;
    public static final StorageError COULDNT_GET_VALUE;
    public static final StorageError COULDNT_SET_VALUE;
    public static final StorageError COULDNT_WRITE_STORAGE_TO_CACHE;

    private static StorageError[] $values() {
        return 6;
    }

    static <clinit>() {
        new StorageError("COULDNT_SET_VALUE", 0);
        COULDNT_SET_VALUE = new StorageError(..);
        new StorageError("COULDNT_GET_VALUE", 1);
        COULDNT_GET_VALUE = new StorageError(..);
        new StorageError("COULDNT_WRITE_STORAGE_TO_CACHE", 2);
        COULDNT_WRITE_STORAGE_TO_CACHE = new StorageError(..);
        new StorageError("COULDNT_CLEAR_STORAGE", 3);
        COULDNT_CLEAR_STORAGE = new StorageError(..);
        new StorageError("COULDNT_GET_STORAGE", 4);
        COULDNT_GET_STORAGE = new StorageError(..);
        new StorageError("COULDNT_DELETE_VALUE", 5);
        COULDNT_DELETE_VALUE = new StorageError(..);
        StorageError.$values();
        $VALUES = StorageError.$values(..);
        return;
    }

    private StorageError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static StorageError valueOf(String p0) {
        Enum.valueOf(StorageError.class, p0);
        return Enum.valueOf(..);
    }

    public static StorageError[] values() {
        StorageError.$VALUES.clone();
        return StorageError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.StorageEvent
// ============================================================
package com.unity3d.services.core.device;

public final class StorageEvent extends Enum {
    private static final StorageEvent[] $VALUES;
    public static final StorageEvent CLEAR;
    public static final StorageEvent DELETE;
    public static final StorageEvent INIT;
    public static final StorageEvent READ;
    public static final StorageEvent SET;
    public static final StorageEvent WRITE;

    private static StorageEvent[] $values() {
        return 6;
    }

    static <clinit>() {
        new StorageEvent("SET", 0);
        SET = new StorageEvent(..);
        new StorageEvent("DELETE", 1);
        DELETE = new StorageEvent(..);
        new StorageEvent("CLEAR", 2);
        CLEAR = new StorageEvent(..);
        new StorageEvent("WRITE", 3);
        WRITE = new StorageEvent(..);
        new StorageEvent("READ", 4);
        READ = new StorageEvent(..);
        new StorageEvent("INIT", 5);
        INIT = new StorageEvent(..);
        StorageEvent.$values();
        $VALUES = StorageEvent.$values(..);
        return;
    }

    private StorageEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static StorageEvent valueOf(String p0) {
        Enum.valueOf(StorageEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static StorageEvent[] values() {
        StorageEvent.$VALUES.clone();
        return StorageEvent[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.StorageEventInfo
// ============================================================
package com.unity3d.services.core.device;

public final class StorageEventInfo {
    private final StorageEvent eventType;
    private final StorageManager$StorageType storageType;
    private final Object value;

    public StorageEventInfo(StorageEvent p0, StorageManager$StorageType p1, Object p2) {
        new Object();
        eventType = p0;
        storageType = p1;
        value = p2;
        return;
    }

    public static StorageEventInfo copy$default(StorageEventInfo p0, StorageEvent p1, StorageManager$StorageType p2, Object p3, int p4, Object p5) {
        if (if-eqz(p5)) goto L_6;
      L_6:
        if (if-eqz(p5)) goto L_c;
      L_c:
        if (if-eqz(p4)) goto L_12;
      L_12:
        p0.copy(eventType, storageType, value);
        return StorageEventInfo.copy(..);
    }

    public final StorageEvent component1() {
        return eventType;
    }

    public final StorageManager$StorageType component2() {
        return storageType;
    }

    public final Object component3() {
        return value;
    }

    public final StorageEventInfo copy(StorageEvent p0, StorageManager$StorageType p1, Object p2) {
        new StorageEventInfo(p0, p1, p2);
        return new StorageEventInfo(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        if (if-eq(eventType, eventType)) goto L_13;
        return 0;
      L_13:
        if (if-eq(storageType, storageType)) goto L_1a;
        return 0;
      L_1a:
        Intrinsics.areEqual(value, value);
        if (if-nez(Intrinsics.areEqual(..))) goto L_25;
        return 0;
      L_25:
        return 1;
    }

    public final StorageEvent getEventType() {
        return eventType;
    }

    public final StorageManager$StorageType getStorageType() {
        return storageType;
    }

    public final Object getValue() {
        return value;
    }

    public int hashCode() {
        eventType.hashCode();
        storageType.hashCode();
        if (if-nez(value)) goto L_17;
      L_17:
        0.hashCode();
      L_1b:
        return StorageEvent.hashCode(..);
    }

    public String toString() {
        new StringBuilder("StorageEventInfo(eventType=");
        new StringBuilder(..).append(eventType);
        new StringBuilder(..).append(", storageType=");
        new StringBuilder(..).append(storageType);
        new StringBuilder(..).append(", value=");
        new StringBuilder(..).append(value);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.StorageManager
// ============================================================
package com.unity3d.services.core.device;

public class StorageManager {
    private static final Map _storageFileMap;
    private static final List _storages;

    static <clinit>() {
        new HashMap();
        Collections.synchronizedMap(new HashMap(..));
        _storageFileMap = Collections.synchronizedMap(..);
        new ArrayList();
        Collections.synchronizedList(new ArrayList(..));
        _storages = Collections.synchronizedList(..);
        return;
    }

    public StorageManager() {
        new Object();
        return;
    }

    public static void addStorageLocation(StorageManager$StorageType p0, String p1) {
        StorageManager._storageFileMap.containsKey(p0);
        if (if-nez(Map.containsKey(..))) goto L_e;
        StorageManager._storageFileMap.put(p0, p1);
      L_e:
        return;
        throw p0;
    }

    public static Storage getStorage(StorageManager$StorageType p0) {
        if (if-eqz(StorageManager._storages)) goto L_26;
        StorageManager._storages.iterator();
      L_9:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_21;
        List.iterator(..).next();
        Iterator.next(..).getType();
        Storage.getType(..).equals(p0);
        if (if-eqz(StorageManager$StorageType.equals(..))) goto L_9;
        return Iterator.next(..);
      L_21:
        throw p0;
      L_26:
        return 0;
    }

    public static boolean hasStorage(StorageManager$StorageType p0) {
        if (if-eqz(StorageManager._storages)) goto L_27;
        StorageManager._storages.iterator();
      L_9:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_22;
        List.iterator(..).next();
        Iterator.next(..).getType();
        Storage.getType(..).equals(p0);
        if (if-eqz(StorageManager$StorageType.equals(..))) goto L_9;
        return 1;
      L_22:
        throw 1;
      L_27:
        return 0;
    }

    public static boolean init(Context p0) {
        if (if-nez(p0)) goto L_4;
        return 0;
      L_4:
        p0.getFilesDir();
        if (if-nez(Context.getFilesDir(..))) goto L_b;
        return 0;
      L_b:
        new StringBuilder();
        new StringBuilder(..).append(Context.getFilesDir(..));
        new StringBuilder(..).append("/");
        SdkProperties.getLocalStorageFilePrefix();
        new StringBuilder(..).append(SdkProperties.getLocalStorageFilePrefix(..));
        new StringBuilder(..).append("public-data.json");
        new StringBuilder(..).toString();
        StorageManager.addStorageLocation(StorageManager$StorageType.PUBLIC, StringBuilder.toString(..));
        StorageManager.setupStorage(StorageManager$StorageType.PUBLIC);
        if (if-nez(StorageManager.setupStorage(..))) goto L_36;
        return 0;
      L_36:
        new StringBuilder();
        new StringBuilder(..).append(Context.getFilesDir(..));
        new StringBuilder(..).append("/");
        SdkProperties.getLocalStorageFilePrefix();
        new StringBuilder(..).append(SdkProperties.getLocalStorageFilePrefix(..));
        new StringBuilder(..).append("private-data.json");
        new StringBuilder(..).toString();
        StorageManager.addStorageLocation(StorageManager$StorageType.PRIVATE, StringBuilder.toString(..));
        StorageManager.setupStorage(StorageManager$StorageType.PRIVATE);
        if (if-nez(StorageManager.setupStorage(..))) goto L_5f;
        return 0;
      L_5f:
        return 1;
    }

    public static void initStorage(StorageManager$StorageType p0) {
        StorageManager.hasStorage(p0);
        if (if-eqz(StorageManager.hasStorage(..))) goto L_10;
        StorageManager.getStorage(p0);
        if (if-eqz(StorageManager.getStorage(..))) goto L_2b;
        StorageManager.getStorage(..).initStorage();
      L_10:
        StorageManager._storageFileMap.containsKey(StorageManager.getStorage(..));
        if (if-eqz(Map.containsKey(..))) goto L_2b;
        StorageManager._storageFileMap.get(StorageManager.getStorage(..));
        new Storage(Map.get(..), StorageManager.getStorage(..));
        new Storage(..).initStorage();
        StorageManager._storages.add(new Storage(..));
      L_2b:
        return;
    }

    public static void removeStorage(StorageManager$StorageType p0) {
        StorageManager.getStorage(p0);
        if (if-eqz(StorageManager.getStorage(..))) goto L_12;
        StorageManager.getStorage(p0);
        StorageManager._storages.remove(StorageManager.getStorage(..));
      L_12:
        if (if-eqz(StorageManager._storageFileMap)) goto L_19;
        StorageManager._storageFileMap.remove(p0);
      L_19:
        return;
        throw p0;
    }

    private static boolean setupStorage(StorageManager$StorageType p0) {
        StorageManager.hasStorage(p0);
        if (if-nez(StorageManager.hasStorage(..))) goto L_1c;
        StorageManager.initStorage(p0);
        StorageManager.getStorage(p0);
        if (if-eqz(StorageManager.getStorage(..))) goto L_18;
        StorageManager.getStorage(..).storageFileExists();
        if (if-nez(Storage.storageFileExists(..))) goto L_18;
        StorageManager.getStorage(..).writeStorage();
      L_18:
        if (if-nez(StorageManager.getStorage(..))) goto L_1c;
        return 0;
      L_1c:
        return 1;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.TokenType
// ============================================================
package com.unity3d.services.core.device;

public final class TokenType extends Enum {
    private static final TokenType[] $VALUES;
    public static final TokenType TOKEN_NATIVE;
    public static final TokenType TOKEN_REMOTE;

    private static TokenType[] $values() {
        return 2;
    }

    static <clinit>() {
        new TokenType("TOKEN_NATIVE", 0);
        TOKEN_NATIVE = new TokenType(..);
        new TokenType("TOKEN_REMOTE", 1);
        TOKEN_REMOTE = new TokenType(..);
        TokenType.$values();
        $VALUES = TokenType.$values(..);
        return;
    }

    private TokenType(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static TokenType valueOf(String p0) {
        Enum.valueOf(TokenType.class, p0);
        return Enum.valueOf(..);
    }

    public static TokenType[] values() {
        TokenType.$VALUES.clone();
        return TokenType[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.VolumeChange
// ============================================================
package com.unity3d.services.core.device;

public abstract class VolumeChange {
    public abstract void clearAllListeners() {
        // native or abstract
    }

    public abstract void registerListener(VolumeChangeListener p0) {
        // native or abstract
    }

    public abstract void startObserving() {
        // native or abstract
    }

    public abstract void stopObserving() {
        // native or abstract
    }

    public abstract void unregisterListener(VolumeChangeListener p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.VolumeChangeContentObserver
// ============================================================
package com.unity3d.services.core.device;

public final class VolumeChangeContentObserver {
    private ContentObserver contentObserver;
    private List listeners;

    public VolumeChangeContentObserver() {
        new Object();
        new ArrayList();
        listeners = new ArrayList(..);
        return;
    }

    public static final void access$triggerListeners(VolumeChangeContentObserver p0) {
        p0.triggerListeners();
        return;
    }

    private final void triggerListeners() {
        listeners.iterator();
      L_7:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_1f;
        List.iterator(..).next();
        Iterator.next(..).getStreamType();
        Device.getStreamVolume(VolumeChangeListener.getStreamType(..));
        Iterator.next(..).onVolumeChanged(Device.getStreamVolume(..));
      L_1f:
        return;
        throw List.iterator(..);
    }

    public void clearAllListeners() {
        listeners.clear();
        VolumeChangeContentObserver.stopObserving();
        return;
        throw listeners;
    }

    public void registerListener(VolumeChangeListener p0) {
        listeners.contains(p0);
        if (if-nez(List.contains(..))) goto L_16;
        VolumeChangeContentObserver.startObserving();
        listeners.add(p0);
      L_16:
        return;
        throw p0;
    }

    public void startObserving() {
        if (if-eqz(contentObserver)) goto L_7;
        return;
      L_7:
        Looper.getMainLooper();
        new Handler(Looper.getMainLooper(..));
        new VolumeChangeContentObserver$startObserving$1(this, new Handler(..));
        contentObserver = new VolumeChangeContentObserver$startObserving$1(..);
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_32;
        Context.getContentResolver();
        if (if-eqz(Context.getContentResolver(..))) goto L_32;
        Intrinsics.checkNotNull(contentObserver, "null cannot be cast to non-null type android.database.ContentObserver");
        Context.getContentResolver(..).registerContentObserver(Settings$System.CONTENT_URI, 1, contentObserver);
      L_32:
        return;
        throw Context.getContentResolver(..);
    }

    public void stopObserving() {
        if (if-nez(contentObserver)) goto L_7;
        return;
      L_7:
        ClientProperties.getApplicationContext();
        if (if-eqz(ClientProperties.getApplicationContext(..))) goto L_1b;
        Context.getContentResolver();
        if (if-eqz(Context.getContentResolver(..))) goto L_1b;
        Intrinsics.checkNotNull(contentObserver);
        Context.getContentResolver(..).unregisterContentObserver(contentObserver);
      L_1b:
        contentObserver = 0;
        return;
        throw 0;
    }

    public void unregisterListener(VolumeChangeListener p0) {
        listeners.remove(p0);
        listeners.isEmpty();
        if (if-eqz(List.isEmpty(..))) goto L_16;
        VolumeChangeContentObserver.stopObserving();
      L_16:
        return;
        throw List.isEmpty(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.VolumeChangeListener
// ============================================================
package com.unity3d.services.core.device;

public abstract class VolumeChangeListener {
    public abstract int getStreamType() {
        // native or abstract
    }

    public abstract void onVolumeChanged(int p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.VolumeChangeMonitor
// ============================================================
package com.unity3d.services.core.device;

public final class VolumeChangeMonitor {
    private final IEventSender eventSender;
    private final VolumeChange volumeChange;
    private final SparseArray volumeChangeListeners;

    public VolumeChangeMonitor(IEventSender p0, VolumeChange p1) {
        new Object();
        eventSender = p0;
        volumeChange = p1;
        new SparseArray();
        volumeChangeListeners = new SparseArray(..);
        return;
    }

    public static final IEventSender access$getEventSender$p(VolumeChangeMonitor p0) {
        return eventSender;
    }

    public final void registerVolumeChangeListener(int p0) {
        SparseArray.get(p0);
        if (if-nez(SparseArray.get(..))) goto L_19;
        new VolumeChangeMonitor$registerVolumeChangeListener$listener$1(this, p0);
        SparseArray.append(p0, new VolumeChangeMonitor$registerVolumeChangeListener$listener$1(..));
        VolumeChange.registerListener(new VolumeChangeMonitor$registerVolumeChangeListener$listener$1(..));
      L_19:
        return;
    }

    public final void unregisterVolumeChangeListener(int p0) {
        SparseArray.get(p0);
        if (if-eqz(SparseArray.get(..))) goto L_1f;
        SparseArray.get(p0);
        VolumeChange.unregisterListener(SparseArray.get(..));
        SparseArray.remove(p0);
      L_1f:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.AdvertisingId$1
// ============================================================
package com.unity3d.services.core.device;

class AdvertisingId$1 {
}


// ============================================================
// CLASS: com.unity3d.services.core.device.AdvertisingId$GoogleAdvertisingInfo
// ============================================================
package com.unity3d.services.core.device;

abstract class AdvertisingId$GoogleAdvertisingInfo {
    public abstract boolean getEnabled(boolean p0) {
        // native or abstract
    }

    public abstract String getId() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder
// ============================================================
package com.unity3d.services.core.device;

public abstract class AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder extends Binder {
    public AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder() {
        new Binder();
        return;
    }

    public static AdvertisingId$GoogleAdvertisingInfo create(IBinder p0) {
        if (if-nez(p0)) goto L_4;
        return 0;
      L_4:
        0.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (if-eqz(IBinder.queryLocalInterface(..))) goto L_13;
        if (if-eqz(v1)) goto L_13;
        return IBinder.queryLocalInterface(..);
      L_13:
        new AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder$GoogleAdvertisingInfoImplementation(0);
        return new AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder$GoogleAdvertisingInfoImplementation(..);
    }

    public boolean onTransact(int p0, Parcel p1, Parcel p2, int p3) {
        if (if-eq(p0, 1)) goto L_24;
        if (if-eq(p0, 2)) goto L_d;
        Binder.onTransact(p0, p1, p2, p3);
        return Binder.onTransact(..);
      L_d:
        p1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        p1.readInt();
        if (if-eqz(Parcel.readInt(..))) goto L_18;
      L_18:
      L_19:
        AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder.getEnabled(0);
        p2.writeNoException();
        p2.writeInt(AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder.getEnabled(..));
        return 1;
      L_24:
        p1.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder.getId();
        p2.writeNoException();
        p2.writeString(AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder.getId(..));
        return 1;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder$GoogleAdvertisingInfoImplementation
// ============================================================
package com.unity3d.services.core.device;

class AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder$GoogleAdvertisingInfoImplementation {
    private final IBinder _binder;

    AdvertisingId$GoogleAdvertisingInfo$GoogleAdvertisingInfoBinder$GoogleAdvertisingInfoImplementation(IBinder p0) {
        new Object();
        _binder = p0;
        return;
    }

    public IBinder asBinder() {
        return _binder;
    }

    public boolean getEnabled(boolean p0) {
        Parcel.obtain();
        Parcel.obtain();
        Parcel.obtain(..).writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (if-eqz(p0)) goto L_13;
      L_13:
      L_14:
        Parcel.obtain(..).writeInt(0);
        _binder.transact(2, Parcel.obtain(..), Parcel.obtain(..), 0);
        Parcel.obtain(..).readException();
        Parcel.obtain(..).readInt();
        if (if-eqz(Parcel.readInt(..))) goto L_27;
      L_27:
      L_28:
        Parcel.obtain(..).recycle();
        Parcel.obtain(..).recycle();
        return 0;
        Parcel.obtain(..).recycle();
        Parcel.obtain(..).recycle();
        throw Parcel.readInt(..);
    }

    public String getId() {
        Parcel.obtain();
        Parcel.obtain();
        Parcel.obtain(..).writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        _binder.transact(1, Parcel.obtain(..), Parcel.obtain(..), 0);
        Parcel.obtain(..).readException();
        Parcel.obtain(..).readString();
        Parcel.obtain(..).recycle();
        Parcel.obtain(..).recycle();
        return Parcel.readString(..);
        Parcel.obtain(..).recycle();
        Parcel.obtain(..).recycle();
        throw Parcel.readString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.AdvertisingId$GoogleAdvertisingServiceConnection
// ============================================================
package com.unity3d.services.core.device;

class AdvertisingId$GoogleAdvertisingServiceConnection {
    private final BlockingQueue _binderQueue;
    boolean _consumed;
    final AdvertisingId this$0;

    private AdvertisingId$GoogleAdvertisingServiceConnection(AdvertisingId p0) {
        this$0 = p0;
        new Object();
        _consumed = 0;
        new LinkedBlockingQueue();
        _binderQueue = new LinkedBlockingQueue(..);
        return;
    }

    AdvertisingId$GoogleAdvertisingServiceConnection(AdvertisingId p0, AdvertisingId$1 p1) {
        new AdvertisingId$GoogleAdvertisingServiceConnection(p0);
        return;
    }

    public IBinder getBinder() {
        if (if-nez(_consumed)) goto L_10;
        _consumed = 1;
        _binderQueue.take();
        return BlockingQueue.take(..);
      L_10:
        new IllegalStateException();
        throw new IllegalStateException(..);
    }

    public void onServiceConnected(ComponentName p0, IBinder p1) {
        _binderQueue.put(p1);
        DeviceLog.debug("Couldn't put service to binder que");
        Thread.currentThread();
        Thread.currentThread(..).interrupt();
      L_12:
        return;
    }

    public void onServiceDisconnected(ComponentName p0) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.Device$1
// ============================================================
package com.unity3d.services.core.device;

class Device$1 {
    static final int[] $SwitchMap$com$unity3d$services$core$device$Device$MemoryInfoType;

    static <clinit>() {
        Device$MemoryInfoType.values();
        $SwitchMap$com$unity3d$services$core$device$Device$MemoryInfoType = Device$MemoryInfoType.values(..);
        Device$MemoryInfoType.TOTAL_MEMORY.ordinal();
        Device$MemoryInfoType.FREE_MEMORY.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.Device$MemoryInfoType
// ============================================================
package com.unity3d.services.core.device;

public final class Device$MemoryInfoType extends Enum {
    private static final Device$MemoryInfoType[] $VALUES;
    public static final Device$MemoryInfoType FREE_MEMORY;
    public static final Device$MemoryInfoType TOTAL_MEMORY;

    private static Device$MemoryInfoType[] $values() {
        return 2;
    }

    static <clinit>() {
        new Device$MemoryInfoType("TOTAL_MEMORY", 0);
        TOTAL_MEMORY = new Device$MemoryInfoType(..);
        new Device$MemoryInfoType("FREE_MEMORY", 1);
        FREE_MEMORY = new Device$MemoryInfoType(..);
        Device$MemoryInfoType.$values();
        $VALUES = Device$MemoryInfoType.$values(..);
        return;
    }

    private Device$MemoryInfoType(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static Device$MemoryInfoType valueOf(String p0) {
        Enum.valueOf(Device$MemoryInfoType.class, p0);
        return Enum.valueOf(..);
    }

    public static Device$MemoryInfoType[] values() {
        Device$MemoryInfoType.$VALUES.clone();
        return Device$MemoryInfoType[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.OpenAdvertisingId$1
// ============================================================
package com.unity3d.services.core.device;

class OpenAdvertisingId$1 {
}


// ============================================================
// CLASS: com.unity3d.services.core.device.OpenAdvertisingId$HWAdvertisingInfo
// ============================================================
package com.unity3d.services.core.device;

abstract class OpenAdvertisingId$HWAdvertisingInfo {
    public abstract boolean getEnabled(boolean p0) {
        // native or abstract
    }

    public abstract String getId() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder
// ============================================================
package com.unity3d.services.core.device;

public abstract class OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder extends Binder {
    public OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder() {
        new Binder();
        return;
    }

    public static OpenAdvertisingId$HWAdvertisingInfo create(IBinder p0) {
        if (if-nez(p0)) goto L_4;
        return 0;
      L_4:
        0.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        if (if-eqz(IBinder.queryLocalInterface(..))) goto L_13;
        if (if-eqz(v1)) goto L_13;
        return IBinder.queryLocalInterface(..);
      L_13:
        new OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder$HWAdvertisingInfoImplementation(0);
        return new OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder$HWAdvertisingInfoImplementation(..);
    }

    public boolean onTransact(int p0, Parcel p1, Parcel p2, int p3) {
        if (if-eq(p0, 1)) goto L_24;
        if (if-eq(p0, 2)) goto L_d;
        Binder.onTransact(p0, p1, p2, p3);
        return Binder.onTransact(..);
      L_d:
        p1.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        p1.readInt();
        if (if-eqz(Parcel.readInt(..))) goto L_18;
      L_18:
      L_19:
        OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder.getEnabled(0);
        p2.writeNoException();
        p2.writeInt(OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder.getEnabled(..));
        return 1;
      L_24:
        p1.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder.getId();
        p2.writeNoException();
        p2.writeString(OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder.getId(..));
        return 1;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder$HWAdvertisingInfoImplementation
// ============================================================
package com.unity3d.services.core.device;

class OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder$HWAdvertisingInfoImplementation {
    private final IBinder _binder;

    OpenAdvertisingId$HWAdvertisingInfo$HWAdvertisingInfoBinder$HWAdvertisingInfoImplementation(IBinder p0) {
        new Object();
        _binder = p0;
        return;
    }

    public IBinder asBinder() {
        return _binder;
    }

    public boolean getEnabled(boolean p0) {
        Parcel.obtain();
        Parcel.obtain();
        Parcel.obtain(..).writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        if (if-eqz(p0)) goto L_13;
      L_13:
      L_14:
        Parcel.obtain(..).writeInt(0);
        _binder.transact(2, Parcel.obtain(..), Parcel.obtain(..), 0);
        Parcel.obtain(..).readException();
        Parcel.obtain(..).readInt();
        if (if-eqz(Parcel.readInt(..))) goto L_27;
      L_27:
      L_28:
        Parcel.obtain(..).recycle();
        Parcel.obtain(..).recycle();
        return 0;
        Parcel.obtain(..).recycle();
        Parcel.obtain(..).recycle();
        throw Parcel.readInt(..);
    }

    public String getId() {
        Parcel.obtain();
        Parcel.obtain();
        Parcel.obtain(..).writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        _binder.transact(1, Parcel.obtain(..), Parcel.obtain(..), 0);
        Parcel.obtain(..).readException();
        Parcel.obtain(..).readString();
        Parcel.obtain(..).recycle();
        Parcel.obtain(..).recycle();
        return Parcel.readString(..);
        Parcel.obtain(..).recycle();
        Parcel.obtain(..).recycle();
        throw Parcel.readString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.OpenAdvertisingId$HWAdvertisingServiceConnection
// ============================================================
package com.unity3d.services.core.device;

class OpenAdvertisingId$HWAdvertisingServiceConnection {
    private final BlockingQueue _binderQueue;
    boolean _consumed;
    final OpenAdvertisingId this$0;

    private OpenAdvertisingId$HWAdvertisingServiceConnection(OpenAdvertisingId p0) {
        this$0 = p0;
        new Object();
        _consumed = 0;
        new LinkedBlockingQueue();
        _binderQueue = new LinkedBlockingQueue(..);
        return;
    }

    OpenAdvertisingId$HWAdvertisingServiceConnection(OpenAdvertisingId p0, OpenAdvertisingId$1 p1) {
        new OpenAdvertisingId$HWAdvertisingServiceConnection(p0);
        return;
    }

    public IBinder getBinder() {
        if (if-nez(_consumed)) goto L_10;
        _consumed = 1;
        _binderQueue.take();
        return BlockingQueue.take(..);
      L_10:
        new IllegalStateException();
        throw new IllegalStateException(..);
    }

    public void onServiceConnected(ComponentName p0, IBinder p1) {
        _binderQueue.put(p1);
        DeviceLog.debug("Couldn't put service to binder que");
        Thread.currentThread();
        Thread.currentThread(..).interrupt();
      L_12:
        return;
    }

    public void onServiceDisconnected(ComponentName p0) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.Storage$Companion
// ============================================================
package com.unity3d.services.core.device;

public final class Storage$Companion {
    private Storage$Companion() {
        new Object();
        return;
    }

    public Storage$Companion(DefaultConstructorMarker p0) {
        new Storage$Companion();
        return;
    }

    public final void addStorageEventCallback(Function1 p0) {
        Storage.access$getOnStorageEventCallbacks$cp();
      L_9:
        MutableStateFlow.getValue();
        CollectionsKt.plus(MutableStateFlow.getValue(..), p0);
        MutableStateFlow.compareAndSet(MutableStateFlow.getValue(..), CollectionsKt.plus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_9;
        return;
    }

    public final void removeStorageEventCallback(Function1 p0) {
        Storage.access$getOnStorageEventCallbacks$cp();
      L_9:
        MutableStateFlow.getValue();
        CollectionsKt.minus(MutableStateFlow.getValue(..), p0);
        MutableStateFlow.compareAndSet(MutableStateFlow.getValue(..), CollectionsKt.minus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_9;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.StorageManager$StorageType
// ============================================================
package com.unity3d.services.core.device;

public final class StorageManager$StorageType extends Enum {
    private static final StorageManager$StorageType[] $VALUES;
    public static final StorageManager$StorageType PRIVATE;
    public static final StorageManager$StorageType PUBLIC;

    private static StorageManager$StorageType[] $values() {
        return 2;
    }

    static <clinit>() {
        new StorageManager$StorageType("PRIVATE", 0);
        PRIVATE = new StorageManager$StorageType(..);
        new StorageManager$StorageType("PUBLIC", 1);
        PUBLIC = new StorageManager$StorageType(..);
        StorageManager$StorageType.$values();
        $VALUES = StorageManager$StorageType.$values(..);
        return;
    }

    private StorageManager$StorageType(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static StorageManager$StorageType valueOf(String p0) {
        Enum.valueOf(StorageManager$StorageType.class, p0);
        return Enum.valueOf(..);
    }

    public static StorageManager$StorageType[] values() {
        StorageManager$StorageType.$VALUES.clone();
        return StorageManager$StorageType[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.VolumeChangeContentObserver$startObserving$1
// ============================================================
package com.unity3d.services.core.device;

public final class VolumeChangeContentObserver$startObserving$1 extends ContentObserver {
    final VolumeChangeContentObserver this$0;

    VolumeChangeContentObserver$startObserving$1(VolumeChangeContentObserver p0, Handler p1) {
        this$0 = p0;
        new ContentObserver(p1);
        return;
    }

    public boolean deliverSelfNotifications() {
        return 0;
    }

    public void onChange(boolean p0, Uri p1) {
        VolumeChangeContentObserver.access$triggerListeners(this$0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.VolumeChangeMonitor$registerVolumeChangeListener$listener$1
// ============================================================
package com.unity3d.services.core.device;

public final class VolumeChangeMonitor$registerVolumeChangeListener$listener$1 {
    final int $streamType;
    final VolumeChangeMonitor this$0;

    VolumeChangeMonitor$registerVolumeChangeListener$listener$1(VolumeChangeMonitor p0, int p1) {
        this$0 = p0;
        $streamType = p1;
        new Object();
        return;
    }

    public int getStreamType() {
        return $streamType;
    }

    public void onVolumeChanged(int p0) {
        VolumeChangeMonitor.access$getEventSender$p(this$0);
        VolumeChangeMonitor$registerVolumeChangeListener$listener$1.getStreamType();
        Integer.valueOf(VolumeChangeMonitor$registerVolumeChangeListener$listener$1.getStreamType(..));
        Integer.valueOf(p0);
        Device.getStreamMaxVolume($streamType);
        Integer.valueOf(Device.getStreamMaxVolume(..));
        IEventSender.sendEvent(WebViewEventCategory.DEVICEINFO, DeviceInfoEvent.VOLUME_CHANGED, 3);
        return;
    }

}

