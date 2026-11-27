// Package bundle: com.unity3d.ads.core.data.datasource (57 classes)

// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AnalyticsDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public abstract class AnalyticsDataSource {
    public abstract String getUserId() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidAnalyticsDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidAnalyticsDataSource {
    public AndroidAnalyticsDataSource() {
        new Object();
        return;
    }

    public String getUserId() {
        new StringBuilder();
        ClientProperties.getAppName();
        new StringBuilder(..).append(ClientProperties.getAppName(..));
        new StringBuilder(..).append(".v2.playerprefs");
        new StringBuilder(..).toString();
        AndroidPreferences.getString(StringBuilder.toString(..), "unity.cloud_userid");
        return AndroidPreferences.getString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidByteStringDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidByteStringDataSource {
    private final DataStore dataStore;

    public AndroidByteStringDataSource(DataStore p0) {
        new Object();
        dataStore = p0;
        return;
    }

    public Object get(Continuation p0) {
        dataStore.getData();
        new AndroidByteStringDataSource$get$2(0);
        FlowKt.catch(DataStore.getData(..), new AndroidByteStringDataSource$get$2(..));
        FlowKt.first(FlowKt.catch(..), p0);
        return FlowKt.first(..);
    }

    public Object set(ByteString p0, Continuation p1) {
        new AndroidByteStringDataSource$set$2(p0, 0);
        dataStore.updateData(new AndroidByteStringDataSource$set$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(DataStore.updateData(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_15;
        return DataStore.updateData(..);
      L_15:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidDeveloperConsentDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidDeveloperConsentDataSource {
    private final FlattenerRulesUseCase flattenerRulesUseCase;
    private final JsonStorage publicStorage;

    public AndroidDeveloperConsentDataSource(FlattenerRulesUseCase p0, JsonStorage p1) {
        new Object();
        flattenerRulesUseCase = p0;
        publicStorage = p1;
        return;
    }

    private final DeveloperConsentOuterClass$DeveloperConsentOption createDeveloperConsentOption(String p0, boolean p1) {
        DeveloperConsentOuterClass$DeveloperConsentOption.newBuilder();
        DeveloperConsentOptionKt$Dsl$Companion._create(DeveloperConsentOuterClass$DeveloperConsentOption.newBuilder(..));
        AndroidDeveloperConsentDataSource.getDeveloperConsentType(p0);
        DeveloperConsentOptionKt$Dsl.setType(AndroidDeveloperConsentDataSource.getDeveloperConsentType(..));
        DeveloperConsentOptionKt$Dsl.getType();
        if (if-ne(DeveloperConsentOptionKt$Dsl.getType(..), DeveloperConsentOuterClass$DeveloperConsentType.DEVELOPER_CONSENT_TYPE_CUSTOM)) goto L_21;
        DeveloperConsentOptionKt$Dsl.setCustomType(p0);
      L_21:
        Boolean.valueOf(p1);
        AndroidDeveloperConsentDataSource.getDeveloperConsentChoice(Boolean.valueOf(..));
        DeveloperConsentOptionKt$Dsl.setValue(AndroidDeveloperConsentDataSource.getDeveloperConsentChoice(..));
        DeveloperConsentOptionKt$Dsl._build();
        return DeveloperConsentOptionKt$Dsl._build(..);
    }

    private final List developerConsentList() {
        new ArrayList();
        AndroidDeveloperConsentDataSource.fetchData();
        JSONObject.keys();
      L_14:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_6b;
        JSONObject.keys(..).next();
        JSONObject.get(Iterator.next(..));
        if (if-eqz(v5)) goto L_3d;
        JSONObject.get(..).booleanValue();
        AndroidDeveloperConsentDataSource.createDeveloperConsentOption(Iterator.next(..), Boolean.booleanValue(..));
      L_3d:
        if (if-eqz(v5)) goto L_64;
        StringsKt.equals(Boolean.booleanValue(..), "true", 1);
        if (if-nez(StringsKt.equals(..))) goto L_58;
        StringsKt.equals(Boolean.booleanValue(..), "false", 1);
        if (if-eqz(StringsKt.equals(..))) goto L_64;
      L_58:
        Boolean.parseBoolean(Boolean.booleanValue(..));
        AndroidDeveloperConsentDataSource.createDeveloperConsentOption(AndroidDeveloperConsentDataSource.createDeveloperConsentOption(..), Boolean.parseBoolean(..));
      L_64:
      L_65:
        if (if-eqz(0)) goto L_14;
        new ArrayList(..).add(0);
      L_6b:
        return new ArrayList(..);
    }

    private final JSONObject fetchData() {
        publicStorage.getData();
        if (if-eqz(JsonStorage.getData(..))) goto L_25;
        publicStorage.getData();
        new JsonFlattener(JsonStorage.getData(..));
        flattenerRulesUseCase.invoke();
        new JsonFlattener(..).flattenJson(".", FlattenerRulesUseCase.invoke(..));
        return JsonFlattener.flattenJson(..);
      L_25:
        new JSONObject();
        return new JSONObject(..);
    }

    private final DeveloperConsentOuterClass$DeveloperConsentChoice getDeveloperConsentChoice(Boolean p0) {
        Boolean.valueOf(1);
        Intrinsics.areEqual(p0, Boolean.valueOf(..));
        if (if-eqz(Intrinsics.areEqual(..))) goto L_e;
      L_e:
        Boolean.valueOf(0);
        Intrinsics.areEqual(DeveloperConsentOuterClass$DeveloperConsentChoice.DEVELOPER_CONSENT_CHOICE_TRUE, Boolean.valueOf(..));
        if (if-eqz(Intrinsics.areEqual(..))) goto L_1c;
      L_1c:
      L_1e:
        return DeveloperConsentOuterClass$DeveloperConsentChoice.DEVELOPER_CONSENT_CHOICE_UNSPECIFIED;
    }

    private final DeveloperConsentOuterClass$DeveloperConsentType getDeveloperConsentType(String p0) {
        if (if-eqz(p0)) goto L_55;
        p0.hashCode();
        p0.equals("privacy.useroveragelimit");
        if (if-nez(String.equals(..))) goto L_13;
      L_13:
        String.equals("privacy.consent");
        if (if-nez(String.equals(..))) goto L_1f;
      L_1f:
        String.equals("gdpr.consent");
        if (if-nez(String.equals(..))) goto L_2b;
      L_2b:
        String.equals("user.nonBehavioral");
        if (if-nez(String.equals(..))) goto L_37;
      L_37:
        String.equals("pipl.consent");
        if (if-nez(String.equals(..))) goto L_43;
      L_43:
        String.equals("user.nonbehavioral");
        if (if-nez(String.equals(..))) goto L_4f;
      L_4f:
      L_52:
      L_55:
      L_57:
        return DeveloperConsentOuterClass$DeveloperConsentType.DEVELOPER_CONSENT_TYPE_UNSPECIFIED;
    }

    public DeveloperConsentOuterClass$DeveloperConsent getDeveloperConsent() {
        DeveloperConsentOuterClass$DeveloperConsent.newBuilder();
        DeveloperConsentKt$Dsl.Companion._create(DeveloperConsentOuterClass$DeveloperConsent.newBuilder(..));
        DeveloperConsentKt$Dsl.getOptions();
        AndroidDeveloperConsentDataSource.developerConsentList();
        DeveloperConsentKt$Dsl.addAllOptions(DeveloperConsentKt$Dsl.getOptions(..), AndroidDeveloperConsentDataSource.developerConsentList(..));
        DeveloperConsentKt$Dsl._build();
        return DeveloperConsentKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidDynamicDeviceInfoDataSource {
    public static final AndroidDynamicDeviceInfoDataSource$Companion Companion = null;
    public static final String DIRECTORY_MEM_INFO = "/proc/meminfo";
    public static final String DIRECTORY_MODE_READ = "r";
    public static final String DIRECTORY_PROCESS_INFO = "/proc/self/stat";
    public static final String INTENT_USB_STATE = "android.hardware.usb.action.USB_STATE";
    public static final String KEY_STAT_CONTENT = "stat";
    public static final String USB_EXTRA_CONNECTED = "connected";
    private final Context context;
    private final LifecycleDataSource lifecycleDataSource;
    private final MutableStateFlow reportedWarning;
    private final Flow volumeSettingsChange;

    static <clinit>() {
        new AndroidDynamicDeviceInfoDataSource$Companion(0);
        Companion = new AndroidDynamicDeviceInfoDataSource$Companion(..);
        return;
    }

    public AndroidDynamicDeviceInfoDataSource(Context p0, LifecycleDataSource p1) {
        new Object();
        context = p0;
        lifecycleDataSource = p1;
        MapsKt.emptyMap();
        StateFlowKt.MutableStateFlow(MapsKt.emptyMap(..));
        reportedWarning = StateFlowKt.MutableStateFlow(..);
        new AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1(new Object(..), 0);
        FlowKt.callbackFlow(new AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1(..));
        volumeSettingsChange = FlowKt.callbackFlow(..);
        return;
    }

    public static final double access$getStreamVolume(AndroidDynamicDeviceInfoDataSource p0, int p1) {
        p0.getStreamVolume(p1);
        return AndroidDynamicDeviceInfoDataSource.getStreamVolume(..);
    }

    private final boolean adbStatus() {
        context.getContentResolver();
        Settings$Global.getInt(Context.getContentResolver(..), "adb_enabled", 0);
        if (if-ne(1, Settings$Global.getInt(..))) goto L_11;
      L_11:
      L_12:
        Boolean.valueOf(0);
        DeviceLog.exception("Problems fetching adb enabled status", Boolean.valueOf(..));
      L_1e:
        if (if-eqz(0)) goto L_24;
        0.booleanValue();
      L_24:
        return Boolean.booleanValue(..);
    }

    private final DynamicDeviceInfoOuterClass$DynamicDeviceInfo$Android fetchAndroidDynamicDeviceInfo() {
        DynamicDeviceInfoOuterClass$DynamicDeviceInfo$Android.newBuilder();
        DynamicDeviceInfoKt$AndroidKt$Dsl$Companion._create(DynamicDeviceInfoOuterClass$DynamicDeviceInfo$Android.newBuilder(..));
        AndroidDynamicDeviceInfoDataSource.isActiveNetworkConnected();
        DynamicDeviceInfoKt$AndroidKt$Dsl.setNetworkConnected(AndroidDynamicDeviceInfoDataSource.isActiveNetworkConnected(..));
        AndroidDynamicDeviceInfoDataSource.getNetworkType();
        DynamicDeviceInfoKt$AndroidKt$Dsl.setNetworkType(AndroidDynamicDeviceInfoDataSource.getNetworkType(..));
        AndroidDynamicDeviceInfoDataSource.getNetworkMetered();
        DynamicDeviceInfoKt$AndroidKt$Dsl.setNetworkMetered(AndroidDynamicDeviceInfoDataSource.getNetworkMetered(..));
        AndroidDynamicDeviceInfoDataSource.getNetworkType();
        DynamicDeviceInfoKt$AndroidKt$Dsl.setTelephonyManagerNetworkType(AndroidDynamicDeviceInfoDataSource.getNetworkType(..));
        AndroidDynamicDeviceInfoDataSource.isAdbEnabled();
        DynamicDeviceInfoKt$AndroidKt$Dsl.setAdbEnabled(AndroidDynamicDeviceInfoDataSource.isAdbEnabled(..));
        AndroidDynamicDeviceInfoDataSource.isUSBConnected();
        DynamicDeviceInfoKt$AndroidKt$Dsl.setUsbConnected(AndroidDynamicDeviceInfoDataSource.isUSBConnected(..));
        AndroidDynamicDeviceInfoDataSource.getStreamVolume(3);
        DynamicDeviceInfoKt$AndroidKt$Dsl.setVolume(AndroidDynamicDeviceInfoDataSource.getStreamVolume(..), v3);
        AndroidDynamicDeviceInfoDataSource.getStreamMaxVolume(3);
        DynamicDeviceInfoKt$AndroidKt$Dsl.setMaxVolume(AndroidDynamicDeviceInfoDataSource.getStreamMaxVolume(..), AndroidDynamicDeviceInfoDataSource.getStreamVolume(..));
        AndroidDynamicDeviceInfoDataSource.getElapsedRealtime();
        DynamicDeviceInfoKt$AndroidKt$Dsl.setDeviceElapsedRealtime(AndroidDynamicDeviceInfoDataSource.getElapsedRealtime(..), AndroidDynamicDeviceInfoDataSource.getStreamVolume(..));
        AndroidDynamicDeviceInfoDataSource.getUptime();
        DynamicDeviceInfoKt$AndroidKt$Dsl.setDeviceUpTime(AndroidDynamicDeviceInfoDataSource.getUptime(..), AndroidDynamicDeviceInfoDataSource.getStreamVolume(..));
        AndroidDynamicDeviceInfoDataSource.getAirplaneMode();
        DynamicDeviceInfoKt$AndroidKt$Dsl.setAirplaneMode(AndroidDynamicDeviceInfoDataSource.getAirplaneMode(..));
        AndroidDynamicDeviceInfoDataSource.getChargingType();
        DynamicDeviceInfoKt$AndroidKt$Dsl.setChargingType(AndroidDynamicDeviceInfoDataSource.getChargingType(..));
        AndroidDynamicDeviceInfoDataSource.getStayOnWhilePluggedIn();
        DynamicDeviceInfoKt$AndroidKt$Dsl.setStayOnWhilePluggedIn(AndroidDynamicDeviceInfoDataSource.getStayOnWhilePluggedIn(..));
        AndroidDynamicDeviceInfoDataSource.getIsSdCardPresent();
        DynamicDeviceInfoKt$AndroidKt$Dsl.setSdCardPresent(AndroidDynamicDeviceInfoDataSource.getIsSdCardPresent(..));
        AndroidDynamicDeviceInfoDataSource.getNetworkCapabilityTransports();
        DynamicDeviceInfoKt$AndroidKt$Dsl.setNetworkCapabilityTransports(AndroidDynamicDeviceInfoDataSource.getNetworkCapabilityTransports(..));
        DynamicDeviceInfoKt$AndroidKt$Dsl._build();
        return DynamicDeviceInfoKt$AndroidKt$Dsl._build(..);
    }

    private final boolean getAirplaneMode() {
        context.getContentResolver();
        Settings$Global.getInt(Context.getContentResolver(..), "airplane_mode_on", 0);
        if (if-eqz(Settings$Global.getInt(..))) goto L_11;
      L_11:
      L_12:
        Settings$Global.getInt(..).getMessage();
        DeviceLog.error("Problems fetching airplane mode status", 0);
      L_22:
        return 0;
    }

    private final AudioManager getAudioManager() {
        context.getSystemService("audio");
        if (if-eqz("audio")) goto L_f;
      L_f:
      L_10:
        return 0;
    }

    private final double getBatteryLevel() {
        new IntentFilter("android.intent.action.BATTERY_CHANGED");
        context.registerReceiver(0, new IntentFilter(..));
        if (if-eqz(Context.registerReceiver(..))) goto L_21;
        Context.registerReceiver(..).getIntExtra("level", 0);
        Context.registerReceiver(..).getIntExtra("scale", 0);
        return Intent.getIntExtra(..);
      L_21:
        return Color(0xBFF00000);
    }

    private final int getBatteryStatus() {
        new IntentFilter("android.intent.action.BATTERY_CHANGED");
        context.registerReceiver(0, new IntentFilter(..));
        if (if-eqz(Context.registerReceiver(..))) goto L_18;
        Context.registerReceiver(..).getIntExtra("status", 0);
        return Intent.getIntExtra(..);
      L_18:
        return -1;
    }

    private final DynamicDeviceInfoOuterClass$ConnectionType getConnectionType() {
        AndroidDynamicDeviceInfoDataSource.isUsingWifi();
        if (if-eqz(AndroidDynamicDeviceInfoDataSource.isUsingWifi(..))) goto L_9;
      L_9:
        AndroidDynamicDeviceInfoDataSource.isActiveNetworkConnected();
        if (if-eqz(AndroidDynamicDeviceInfoDataSource.isActiveNetworkConnected(..))) goto L_12;
      L_12:
      L_14:
        return DynamicDeviceInfoOuterClass$ConnectionType.CONNECTION_TYPE_UNSPECIFIED;
    }

    private final ConnectivityManager getConnectivityManager() {
        context.getSystemService("connectivity");
        if (if-eqz("connectivity")) goto L_f;
      L_f:
      L_10:
        return 0;
    }

    private final long getElapsedRealtime() {
        SystemClock.elapsedRealtime();
        return SystemClock.elapsedRealtime(..);
    }

    private final long getEventTimeStamp() {
        System.currentTimeMillis();
        return System.currentTimeMillis(..);
    }

    private final long getFreeSpace(File p0) {
        if (if-eqz(p0)) goto L_17;
        p0.exists();
        if (if-eqz(File.exists(..))) goto L_17;
        p0.getFreeSpace();
        MathKt.roundToInt(1024);
      L_17:
      L_19:
        return -1L;
    }

    private final String getLanguage() {
        Locale.getDefault();
        Locale.getDefault(..).toString();
        return Locale.toString(..);
    }

    private final long getMemoryInfo(Device$MemoryInfoType p0) {
        p0.ordinal();
        if (if-eq(Device$MemoryInfoType.ordinal(..), 1)) goto L_f;
        if (if-eq(Device$MemoryInfoType.ordinal(..), 2)) goto L_f;
      L_f:
        new RandomAccessFile("/proc/meminfo", "r");
      L_20:
        if (if-ge(0, -1)) goto L_29;
        new RandomAccessFile(..).readLine();
      L_29:
        CloseableKt.closeFinally(new RandomAccessFile(..), 0);
        AndroidDynamicDeviceInfoDataSource.getMemoryValueFromString(RandomAccessFile.readLine(..));
        return AndroidDynamicDeviceInfoDataSource.getMemoryValueFromString(..);
        throw AndroidDynamicDeviceInfoDataSource.getMemoryValueFromString(..);
        CloseableKt.closeFinally(new RandomAccessFile(..), AndroidDynamicDeviceInfoDataSource.getMemoryValueFromString(..));
        throw new RandomAccessFile(..);
    }

    private final long getMemoryValueFromString(String p0) {
        if (if-eqz(p0)) goto L_23;
        Pattern.compile("(\\d+)");
        Pattern.compile(..).matcher(p0);
      L_11:
        Pattern.matcher(..).find();
        if (if-eqz(Matcher.find(..))) goto L_1d;
        Pattern.matcher(..).group(1);
      L_1d:
        if (if-eqz(Matcher.group(..))) goto L_23;
        Long.parseLong(Matcher.group(..));
      L_23:
        return Long.parseLong(..);
    }

    private final boolean getNetworkMetered() {
        AndroidDynamicDeviceInfoDataSource.getConnectivityManager();
        if (if-eqz(AndroidDynamicDeviceInfoDataSource.getConnectivityManager(..))) goto L_f;
        ConnectivityManager.isActiveNetworkMetered();
        if (if-ne(ConnectivityManager.isActiveNetworkMetered(..), 1)) goto L_f;
      L_f:
        return 1;
    }

    private final String getNetworkOperator() {
        AndroidDynamicDeviceInfoDataSource.getTelephonyManager();
        if (if-eqz(AndroidDynamicDeviceInfoDataSource.getTelephonyManager(..))) goto L_b;
        TelephonyManager.getNetworkOperator();
      L_b:
      L_c:
        if (if-nez(0)) goto L_10;
      L_10:
        return "";
    }

    private final String getNetworkOperatorName() {
        AndroidDynamicDeviceInfoDataSource.getTelephonyManager();
        if (if-eqz(AndroidDynamicDeviceInfoDataSource.getTelephonyManager(..))) goto L_b;
        TelephonyManager.getNetworkOperatorName();
      L_b:
      L_c:
        if (if-nez(0)) goto L_10;
      L_10:
        return "";
    }

    private final int getNetworkType() {
        AndroidDynamicDeviceInfoDataSource.getTelephonyManager();
        if (if-eqz(AndroidDynamicDeviceInfoDataSource.getTelephonyManager(..))) goto L_45;
        TelephonyManager.getNetworkType();
        reportedWarning.getValue();
        MutableStateFlow.getValue(..).get("getNetworkType");
        Boolean.valueOf(1);
        Intrinsics.areEqual(Map.get(..), Boolean.valueOf(..));
        if (if-nez(Intrinsics.areEqual(..))) goto L_45;
      L_27:
        reportedWarning.getValue();
        Boolean.valueOf(1);
        TuplesKt.to("getNetworkType", Boolean.valueOf(..));
        MapsKt.plus(MutableStateFlow.getValue(..), TuplesKt.to(..));
        reportedWarning.compareAndSet(MutableStateFlow.getValue(..), MapsKt.plus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_27;
        DeviceLog.warning("Unity Ads was not able to get current network type due to missing permission");
      L_45:
        return TelephonyManager.getNetworkType(..);
    }

    private final int getScreenHeight() {
        context.getResources();
        if (if-eqz(Context.getResources(..))) goto L_11;
        Context.getResources(..).getDisplayMetrics();
        if (if-eqz(Resources.getDisplayMetrics(..))) goto L_11;
      L_11:
      L_12:
        return -1;
    }

    private final int getScreenWidth() {
        context.getResources();
        if (if-eqz(Context.getResources(..))) goto L_11;
        Context.getResources(..).getDisplayMetrics();
        if (if-eqz(Resources.getDisplayMetrics(..))) goto L_11;
      L_11:
      L_12:
        return -1;
    }

    private final double getStreamVolume(int p0) {
        AndroidDynamicDeviceInfoDataSource.getAudioManager();
        if (if-eqz(AndroidDynamicDeviceInfoDataSource.getAudioManager(..))) goto L_b;
        AudioManager.getStreamVolume(p0);
      L_b:
      L_c:
        return AndroidDynamicDeviceInfoDataSource.getAudioManager(..);
    }

    private final TelephonyManager getTelephonyManager() {
        context.getSystemService("phone");
        if (if-eqz("phone")) goto L_f;
      L_f:
      L_10:
        return 0;
    }

    private final String getTimeZone() {
        TimeZone.getDefault();
        TimeZone.getDefault(..).getDisplayName(0, 0, Locale.US);
        TimeZone.getDisplayName(..).getMessage();
        DeviceLog.error("Could not read timeZone information: %s", 1);
      L_22:
        return "";
    }

    private final long getTimeZoneOffset() {
        TimeZone.getDefault();
        System.currentTimeMillis();
        TimeZone.getDefault(..).getOffset(System.currentTimeMillis(..), v2);
        return TimeZone.getOffset(..);
    }

    private final long getUptime() {
        SystemClock.uptimeMillis();
        return SystemClock.uptimeMillis(..);
    }

    private final long getUsableSpace(File p0) {
        if (if-eqz(p0)) goto L_17;
        p0.exists();
        if (if-eqz(File.exists(..))) goto L_17;
        p0.getUsableSpace();
        MathKt.roundToInt(1024);
      L_17:
      L_19:
        return -1L;
    }

    private final boolean hasInternetConnection() {
        AndroidDynamicDeviceInfoDataSource.getConnectivityManager();
        if (if-nez(AndroidDynamicDeviceInfoDataSource.getConnectivityManager(..))) goto L_8;
        return 0;
      L_8:
        ConnectivityManager.getActiveNetworkInfo();
        if (if-eqz(ConnectivityManager.getActiveNetworkInfo(..))) goto L_16;
        NetworkInfo.isConnected();
        if (if-ne(NetworkInfo.isConnected(..), 1)) goto L_16;
      L_16:
        return 1;
    }

    private final boolean hasInternetConnectionM() {
        AndroidDynamicDeviceInfoDataSource.getConnectivityManager();
        if (if-nez(AndroidDynamicDeviceInfoDataSource.getConnectivityManager(..))) goto L_8;
        return 0;
      L_8:
        ConnectivityManager.getActiveNetwork();
        ConnectivityManager.getNetworkCapabilities(ConnectivityManager.getActiveNetwork(..));
        if (if-eqz(ConnectivityManager.getNetworkCapabilities(..))) goto L_23;
        NetworkCapabilities.hasCapability(12);
        if (if-eqz(NetworkCapabilities.hasCapability(..))) goto L_23;
        NetworkCapabilities.hasCapability(16);
        if (if-eqz(NetworkCapabilities.hasCapability(..))) goto L_23;
      L_23:
        return 1;
    }

    private final boolean isActiveNetworkConnected() {
        AndroidDynamicDeviceInfoDataSource.getConnectivityManager();
        if (if-eqz(AndroidDynamicDeviceInfoDataSource.getConnectivityManager(..))) goto L_b;
        ConnectivityManager.getActiveNetworkInfo();
      L_b:
      L_c:
        if (if-eqz(0)) goto L_16;
        0.isConnected();
        if (if-eqz(NetworkInfo.isConnected(..))) goto L_16;
      L_16:
      L_17:
        return 0;
    }

    private final boolean isAdbEnabled() {
        AndroidDynamicDeviceInfoDataSource.adbStatus();
        return AndroidDynamicDeviceInfoDataSource.adbStatus(..);
    }

    private final boolean isAppActive() {
        lifecycleDataSource.appIsForeground();
        return LifecycleDataSource.appIsForeground(..);
    }

    private final boolean isLimitAdTrackingEnabled() {
        AdvertisingId.getLimitedAdTracking();
        return AdvertisingId.getLimitedAdTracking(..);
    }

    private final boolean isLimitOpenAdTrackingEnabled() {
        OpenAdvertisingId.getLimitedOpenAdTracking();
        return OpenAdvertisingId.getLimitedOpenAdTracking(..);
    }

    private final boolean isUSBConnected() {
        new IntentFilter("android.hardware.usb.action.USB_STATE");
        context.registerReceiver(0, new IntentFilter(..));
        if (if-eqz(Context.registerReceiver(..))) goto L_18;
        Context.registerReceiver(..).getBooleanExtra("connected", 0);
        return Intent.getBooleanExtra(..);
      L_18:
        return 0;
    }

    private final boolean isUsingWifi() {
        AndroidDynamicDeviceInfoDataSource.getConnectivityManager();
        if (if-nez(AndroidDynamicDeviceInfoDataSource.getConnectivityManager(..))) goto L_8;
        return 0;
      L_8:
        AndroidDynamicDeviceInfoDataSource.getTelephonyManager();
        ConnectivityManager.getActiveNetworkInfo();
        if (if-eqz(ConnectivityManager.getActiveNetworkInfo(..))) goto L_2f;
        ConnectivityManager.getBackgroundDataSetting();
        if (if-eqz(ConnectivityManager.getBackgroundDataSetting(..))) goto L_2f;
        NetworkInfo.isConnected();
        if (if-eqz(NetworkInfo.isConnected(..))) goto L_2f;
        if (if-nez(AndroidDynamicDeviceInfoDataSource.getTelephonyManager(..))) goto L_21;
      L_21:
        NetworkInfo.getType();
        if (if-ne(NetworkInfo.getType(..), 1)) goto L_2f;
        NetworkInfo.isConnected();
        if (if-eqz(NetworkInfo.isConnected(..))) goto L_2f;
      L_2f:
        return 1;
    }

    private final boolean isWiredHeadsetOn() {
        AndroidDynamicDeviceInfoDataSource.getAudioManager();
        if (if-eqz(AndroidDynamicDeviceInfoDataSource.getAudioManager(..))) goto L_f;
        AudioManager.isWiredHeadsetOn();
        if (if-ne(AudioManager.isWiredHeadsetOn(..), 1)) goto L_f;
      L_f:
        return 1;
    }

    public DynamicDeviceInfoOuterClass$DynamicDeviceInfo fetch() {
        DynamicDeviceInfoOuterClass$DynamicDeviceInfo.newBuilder();
        DynamicDeviceInfoKt$Dsl.Companion._create(DynamicDeviceInfoOuterClass$DynamicDeviceInfo.newBuilder(..));
        AndroidDynamicDeviceInfoDataSource.getLanguage();
        DynamicDeviceInfoKt$Dsl.setLanguage(AndroidDynamicDeviceInfoDataSource.getLanguage(..));
        AndroidDynamicDeviceInfoDataSource.getNetworkOperator();
        DynamicDeviceInfoKt$Dsl.setNetworkOperator(AndroidDynamicDeviceInfoDataSource.getNetworkOperator(..));
        AndroidDynamicDeviceInfoDataSource.getNetworkOperatorName();
        DynamicDeviceInfoKt$Dsl.setNetworkOperatorName(AndroidDynamicDeviceInfoDataSource.getNetworkOperatorName(..));
        context.getExternalFilesDir(0);
        AndroidDynamicDeviceInfoDataSource.getUsableSpace(Context.getExternalFilesDir(..));
        DynamicDeviceInfoKt$Dsl.setFreeDiskSpace(AndroidDynamicDeviceInfoDataSource.getUsableSpace(..), 0);
        AndroidDynamicDeviceInfoDataSource.getFreeMemory();
        DynamicDeviceInfoKt$Dsl.setFreeRamMemory(AndroidDynamicDeviceInfoDataSource.getFreeMemory(..), 0);
        AndroidDynamicDeviceInfoDataSource.isWiredHeadsetOn();
        DynamicDeviceInfoKt$Dsl.setWiredHeadset(AndroidDynamicDeviceInfoDataSource.isWiredHeadsetOn(..));
        AndroidDynamicDeviceInfoDataSource.getTimeZone();
        DynamicDeviceInfoKt$Dsl.setTimeZone(AndroidDynamicDeviceInfoDataSource.getTimeZone(..));
        AndroidDynamicDeviceInfoDataSource.getTimeZoneOffset();
        DynamicDeviceInfoKt$Dsl.setTimeZoneOffset(AndroidDynamicDeviceInfoDataSource.getTimeZoneOffset(..), 0);
        AndroidDynamicDeviceInfoDataSource.isLimitAdTrackingEnabled();
        DynamicDeviceInfoKt$Dsl.setLimitedTracking(AndroidDynamicDeviceInfoDataSource.isLimitAdTrackingEnabled(..));
        AndroidDynamicDeviceInfoDataSource.isLimitOpenAdTrackingEnabled();
        DynamicDeviceInfoKt$Dsl.setLimitedOpenAdTracking(AndroidDynamicDeviceInfoDataSource.isLimitOpenAdTrackingEnabled(..));
        AndroidDynamicDeviceInfoDataSource.getBatteryLevel();
        DynamicDeviceInfoKt$Dsl.setBatteryLevel(AndroidDynamicDeviceInfoDataSource.getBatteryLevel(..), 0);
        AndroidDynamicDeviceInfoDataSource.getBatteryStatus();
        DynamicDeviceInfoKt$Dsl.setBatteryStatus(AndroidDynamicDeviceInfoDataSource.getBatteryStatus(..));
        AndroidDynamicDeviceInfoDataSource.getConnectionType();
        DynamicDeviceInfoKt$Dsl.setConnectionType(AndroidDynamicDeviceInfoDataSource.getConnectionType(..));
        AndroidDynamicDeviceInfoDataSource.fetchAndroidDynamicDeviceInfo();
        DynamicDeviceInfoKt$Dsl.setAndroid(AndroidDynamicDeviceInfoDataSource.fetchAndroidDynamicDeviceInfo(..));
        AndroidDynamicDeviceInfoDataSource.isAppActive();
        DynamicDeviceInfoKt$Dsl.setAppActive(AndroidDynamicDeviceInfoDataSource.isAppActive(..));
        AndroidDynamicDeviceInfoDataSource.getScreenWidth();
        DynamicDeviceInfoKt$Dsl.setScreenWidth(AndroidDynamicDeviceInfoDataSource.getScreenWidth(..));
        AndroidDynamicDeviceInfoDataSource.getScreenHeight();
        DynamicDeviceInfoKt$Dsl.setScreenHeight(AndroidDynamicDeviceInfoDataSource.getScreenHeight(..));
        DynamicDeviceInfoKt$Dsl._build();
        return DynamicDeviceInfoKt$Dsl._build(..);
    }

    public final int getChargingType() {
        new IntentFilter("android.intent.action.BATTERY_CHANGED");
        context.registerReceiver(0, new IntentFilter(..));
        if (if-eqz(Context.registerReceiver(..))) goto L_17;
        Context.registerReceiver(..).getIntExtra("plugged", -1);
      L_17:
        return Intent.getIntExtra(..);
    }

    public String getConnectionTypeStr() {
        AndroidDynamicDeviceInfoDataSource.getConnectionType();
        DynamicDeviceInfoOuterClass$ConnectionType.ordinal();
        if (if-eq(DynamicDeviceInfoOuterClass$ConnectionType.ordinal(..), 1)) goto L_18;
        if (if-eq(DynamicDeviceInfoOuterClass$ConnectionType.ordinal(..), 2)) goto L_15;
      L_15:
      L_18:
      L_1a:
        return "wifi";
    }

    public final Context getContext() {
        return context;
    }

    public int getCurrentUiTheme() {
        context.getResources();
        Context.getResources(..).getConfiguration();
        return uiMode;
    }

    public final long getFreeMemory() {
        AndroidDynamicDeviceInfoDataSource.getMemoryInfo(Device$MemoryInfoType.FREE_MEMORY);
        return AndroidDynamicDeviceInfoDataSource.getMemoryInfo(..);
    }

    public final boolean getIsSdCardPresent() {
        Environment.getExternalStorageState();
        Intrinsics.areEqual(Environment.getExternalStorageState(..), "mounted");
        return Intrinsics.areEqual(..);
    }

    public List getLocaleList() {
        if (if-lt(Build$VERSION.SDK_INT, 24)) goto L_3b;
        context.getResources();
        Context.getResources(..).getConfiguration();
        Resources.getConfiguration(..).getLocales();
        Configuration.getLocales(..).size();
        new ArrayList(LocaleList.size(..));
      L_23:
        if (if-ge(0, LocaleList.size(..))) goto L_38;
        Configuration.getLocales(..).get(0);
        LocaleList.get(..).toString();
        new ArrayList(..).add(Locale.toString(..));
      L_38:
      L_3b:
        Locale.getAvailableLocales();
        new ArrayList(new ArrayList(..));
      L_4f:
        if (if-ge(0, new ArrayList(..))) goto L_5f;
        Locale.toString(..).toString();
        new ArrayList(..).add(Locale.toString(..));
      L_5f:
      L_62:
        return new ArrayList(..);
    }

    public final NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports getNetworkCapabilityTransports() {
        NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports.newBuilder();
        if (if-ge(Build$VERSION.SDK_INT, 31)) goto L_16;
        NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.build();
        return NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.build(..);
      L_16:
        context.getSystemService("connectivity");
        if (if-eqz("connectivity")) goto L_25;
      L_25:
      L_26:
        if (if-eqz(0)) goto L_86;
        0.getActiveNetwork();
        if (if-nez(ConnectivityManager.getActiveNetwork(..))) goto L_2f;
      L_2f:
        0.getNetworkCapabilities(ConnectivityManager.getActiveNetwork(..));
        if (if-nez(ConnectivityManager.getNetworkCapabilities(..))) goto L_3f;
        NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.build();
        return NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.build(..);
      L_3f:
        NetworkCapabilities.hasTransport(1);
        NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.setWifi(NetworkCapabilities.hasTransport(..));
        NetworkCapabilities.hasTransport(0);
        NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.setCellular(NetworkCapabilities.hasTransport(..));
        NetworkCapabilities.hasTransport(4);
        NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.setVpn(NetworkCapabilities.hasTransport(..));
        NetworkCapabilities.hasTransport(3);
        NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.setEthernet(NetworkCapabilities.hasTransport(..));
        NetworkCapabilities.hasTransport(5);
        NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.setWifiAware(NetworkCapabilities.hasTransport(..));
        NetworkCapabilities.hasTransport(6);
        NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.setLowpan(NetworkCapabilities.hasTransport(..));
        NetworkCapabilities.hasTransport(2);
        NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.setBluetooth(NetworkCapabilities.hasTransport(..));
        NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.build();
        return NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.build(..);
      L_86:
        NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.build();
        return NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports$Builder.build(..);
    }

    public final String getNetworkCountryISO() {
        AndroidDynamicDeviceInfoDataSource.getTelephonyManager();
        if (if-eqz(AndroidDynamicDeviceInfoDataSource.getTelephonyManager(..))) goto L_b;
        TelephonyManager.getNetworkCountryIso();
      L_b:
      L_c:
        if (if-nez(0)) goto L_10;
      L_10:
        return "";
    }

    public String getOrientation() {
        AndroidDynamicDeviceInfoDataSource.getScreenHeight();
        AndroidDynamicDeviceInfoDataSource.getScreenWidth();
        if (if-le(AndroidDynamicDeviceInfoDataSource.getScreenHeight(..), AndroidDynamicDeviceInfoDataSource.getScreenWidth(..))) goto L_d;
      L_d:
      L_f:
        return "landscape";
    }

    public final Map getProcessInfo() {
        new HashMap();
        new RandomAccessFile("/proc/self/stat", "r");
        new RandomAccessFile(..).readLine();
        new HashMap(..).put("stat", RandomAccessFile.readLine(..));
        CloseableKt.closeFinally(new RandomAccessFile(..), 0);
        return new HashMap(..);
        throw new HashMap(..);
        CloseableKt.closeFinally(new RandomAccessFile(..), new HashMap(..));
        throw 0;
    }

    public int getRingerMode() {
        AndroidDynamicDeviceInfoDataSource.getAudioManager();
        if (if-eqz(AndroidDynamicDeviceInfoDataSource.getAudioManager(..))) goto L_b;
        AudioManager.getRingerMode();
      L_b:
      L_c:
        return -2;
    }

    public final int getScreenBrightness() {
        context.getContentResolver();
        Settings$System.getInt(Context.getContentResolver(..), "screen_brightness", -1);
        return Settings$System.getInt(..);
    }

    public final boolean getStayOnWhilePluggedIn() {
        context.getContentResolver();
        Settings$Global.getInt(Context.getContentResolver(..), "stay_on_while_plugged_in", 0);
        if (if-eqz(Settings$Global.getInt(..))) goto L_11;
      L_11:
      L_12:
        Settings$Global.getInt(..).getMessage();
        DeviceLog.error("Problems fetching stay on while plugged in status", 0);
      L_22:
        return 0;
    }

    public final double getStreamMaxVolume(int p0) {
        AndroidDynamicDeviceInfoDataSource.getAudioManager();
        if (if-eqz(AndroidDynamicDeviceInfoDataSource.getAudioManager(..))) goto L_b;
        AudioManager.getStreamMaxVolume(p0);
      L_b:
      L_c:
        return AndroidDynamicDeviceInfoDataSource.getAudioManager(..);
    }

    public final long getTotalMemory() {
        AndroidDynamicDeviceInfoDataSource.getMemoryInfo(Device$MemoryInfoType.TOTAL_MEMORY);
        return AndroidDynamicDeviceInfoDataSource.getMemoryInfo(..);
    }

    public Flow getVolumeSettingsChange() {
        return volumeSettingsChange;
    }

    public boolean hasInternet() {
        AndroidDynamicDeviceInfoDataSource.hasInternetConnectionM();
        return AndroidDynamicDeviceInfoDataSource.hasInternetConnectionM(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidKnownStore
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidKnownStore extends Enum {
    private static final AndroidKnownStore[] $VALUES;
    public static final AndroidKnownStore AMAZON;
    public static final AndroidKnownStore GOOGLE;
    public static final AndroidKnownStore GOOGLE_MARKET;
    public static final AndroidKnownStore HUAWEI;
    public static final AndroidKnownStore OPPO;
    public static final AndroidKnownStore SAMSUNG;
    public static final AndroidKnownStore UNKNOWN;
    public static final AndroidKnownStore VIVO;
    public static final AndroidKnownStore XIAOMI;
    private final String packageName;

    private static final AndroidKnownStore[] $values() {
        return 9;
    }

    static <clinit>() {
        new AndroidKnownStore("GOOGLE", 0, "com.android.vending");
        GOOGLE = new AndroidKnownStore(..);
        new AndroidKnownStore("GOOGLE_MARKET", 1, "com.google.market");
        GOOGLE_MARKET = new AndroidKnownStore(..);
        new AndroidKnownStore("AMAZON", 2, "com.amazon.venezia");
        AMAZON = new AndroidKnownStore(..);
        new AndroidKnownStore("SAMSUNG", 3, "com.sec.android.app.samsungapps");
        SAMSUNG = new AndroidKnownStore(..);
        new AndroidKnownStore("XIAOMI", 4, "com.xiaomi.market");
        XIAOMI = new AndroidKnownStore(..);
        new AndroidKnownStore("HUAWEI", 5, "com.huawei.appmarket");
        HUAWEI = new AndroidKnownStore(..);
        new AndroidKnownStore("OPPO", 6, "com.oppo.market");
        OPPO = new AndroidKnownStore(..);
        new AndroidKnownStore("VIVO", 7, "com.bbk.appstore");
        VIVO = new AndroidKnownStore(..);
        new AndroidKnownStore("UNKNOWN", 8, "unknown");
        UNKNOWN = new AndroidKnownStore(..);
        AndroidKnownStore.$values();
        $VALUES = AndroidKnownStore.$values(..);
        return;
    }

    private AndroidKnownStore(String p0, int p1, String p2) {
        new Enum(p0, p1);
        packageName = p2;
        return;
    }

    public static AndroidKnownStore valueOf(String p0) {
        Enum.valueOf(AndroidKnownStore.class, p0);
        return Enum.valueOf(..);
    }

    public static AndroidKnownStore[] values() {
        AndroidKnownStore.$VALUES.clone();
        return Object[].clone(..);
    }

    public final String getPackageName() {
        return packageName;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidLegacyConfigStoreDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidLegacyConfigStoreDataSource {
    public static final AndroidLegacyConfigStoreDataSource$Companion Companion = null;
    public static final String KEY_CONFIGURATION_STORE = "configuration.store";
    private final StorageManager storageManager;

    static <clinit>() {
        new AndroidLegacyConfigStoreDataSource$Companion(0);
        Companion = new AndroidLegacyConfigStoreDataSource$Companion(..);
        return;
    }

    public AndroidLegacyConfigStoreDataSource(StorageManager p0) {
        new Object();
        storageManager = p0;
        return;
    }

    public Object get(Continuation p0) {
        storageManager.getStorage(StorageManager$StorageType.PRIVATE);
        StorageManager.getStorage(..).get("configuration.store");
        if (if-eqz("configuration.store")) goto L_16;
      L_16:
      L_17:
        if (if-eqz(0)) goto L_21;
        ProtobufExtensionsKt.fromBase64(0, 1);
      L_21:
      L_22:
        Result.constructor-impl(0);
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_32:
        Result.isFailure-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isFailure-impl(..))) goto L_39;
      L_39:
      L_3a:
        ByteStringStoreOuterClass$ByteStringStore.newBuilder();
        ByteStringStoreKt$Dsl.Companion._create(ByteStringStoreOuterClass$ByteStringStore.newBuilder(..));
        if (if-nez(Result.constructor-impl(..))) goto L_54;
      L_54:
        ByteStringStoreKt$Dsl.setData(ByteString.EMPTY);
        ByteStringStoreKt$Dsl._build();
        return ByteStringStoreKt$Dsl._build(..);
    }

    public Object set(ByteString p0, Continuation p1) {
        storageManager.getStorage(StorageManager$StorageType.PRIVATE);
        ProtobufExtensionsKt.toBase64(p0, 1);
        StorageManager.getStorage(..).set("configuration.store", ProtobufExtensionsKt.toBase64(..));
        StorageManager.getStorage(..).writeStorage();
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidLegacyUserConsentDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidLegacyUserConsentDataSource {
    private final FlattenerRulesUseCase flattenerRulesUseCase;
    private final JsonStorage privateStorage;

    public AndroidLegacyUserConsentDataSource(FlattenerRulesUseCase p0, JsonStorage p1) {
        new Object();
        flattenerRulesUseCase = p0;
        privateStorage = p1;
        return;
    }

    public String getPrivacyData() {
        privateStorage.getData();
        if (if-eqz(JsonStorage.getData(..))) goto L_20;
        new JsonFlattener(JsonStorage.getData(..));
        flattenerRulesUseCase.invoke();
        new JsonFlattener(..).flattenJson(".", FlattenerRulesUseCase.invoke(..));
        if (if-eqz(JsonFlattener.flattenJson(..))) goto L_20;
        JsonFlattener.flattenJson(..).toString();
      L_20:
        return JSONObject.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidLifecycleDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidLifecycleDataSource {
    private final MutableStateFlow appActive;

    public AndroidLifecycleDataSource() {
        new Object();
        Boolean.valueOf(1);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        appActive = StateFlowKt.MutableStateFlow(..);
        new Object(..).registerAppLifecycle();
        return;
    }

    private final void registerAppLifecycle() {
        CoroutineScopeKt.MainScope();
        new AndroidLifecycleDataSource$registerAppLifecycle$1(this, 0);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(..), 0, 0, new AndroidLifecycleDataSource$registerAppLifecycle$1(..), 3, 0);
        return;
    }

    public boolean appIsForeground() {
        appActive.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        return Boolean.booleanValue(..);
    }

    public void onStateChanged(LifecycleOwner p0, Lifecycle$Event p1) {
        p1.ordinal();
        if (if-eq(Lifecycle$Event.ordinal(..), 1)) goto L_27;
        if (if-eq(Lifecycle$Event.ordinal(..), 2)) goto L_28;
        appActive.getValue();
        MutableStateFlow.getValue(..).booleanValue();
      L_27:
      L_28:
        Boolean.valueOf(0);
        appActive.setValue(Boolean.valueOf(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidLocalCacheDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidLocalCacheDataSource {
    private final CreateFile createFile;
    private final GetFileExtensionFromUrl getFileExtensionFromUrl;

    public AndroidLocalCacheDataSource(CreateFile p0, GetFileExtensionFromUrl p1) {
        new Object();
        createFile = p0;
        getFileExtensionFromUrl = p1;
        return;
    }

    public final CreateFile getCreateFile() {
        return createFile;
    }

    public Object getFile(File p0, String p1, String p2, Integer p3, Continuation p4) {
        createFile.invoke(p0, p1);
        CreateFile.invoke(..).exists();
        if (if-eqz(File.exists(..))) goto L_60;
        if (if-eqz(p2)) goto L_22;
        p2.length();
        if (if-nez(CharSequence.length(..))) goto L_20;
      L_20:
      L_22:
      L_23:
        if (if-eqz(1)) goto L_27;
      L_27:
        getFileExtensionFromUrl.invoke(p2);
      L_2d:
        if (if-nez(p2)) goto L_37;
      L_37:
      L_38:
        if (if-nez(GetFileExtensionFromUrl.invoke(..))) goto L_3c;
      L_3c:
      L_3d:
        CreateFile.invoke(..).length();
        if (if-eqz(p3)) goto L_49;
        p3.intValue();
      L_49:
      L_4c:
        new CachedFile("", p2, p1, CreateFile.invoke(..), GetFileExtensionFromUrl.invoke(..), File.length(..), v10, 0, 0x7FFFFFFF, 64, 0);
        new CacheResult$Success(new CachedFile, CacheSource.LOCAL);
      L_60:
        new CacheResult$Failure(CacheError.FILE_NOT_FOUND, CacheSource.LOCAL);
      L_6b:
        return new CacheResult$Failure(..);
    }

    public final GetFileExtensionFromUrl getGetFileExtensionFromUrl() {
        return getFileExtensionFromUrl;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidMediationDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidMediationDataSource {
    public static final AndroidMediationDataSource$Companion Companion = null;
    private static final String MEDIATION_NAME = "name";
    public static final String MEDIATION_NAME_KEY = "mediation.name.value";
    private static final String MEDIATION_STORAGE_NAME = "mediation";
    private static final String MEDIATION_VALUE = "value";
    private static final String MEDIATION_VERSION = "version";
    public static final String MEDIATION_VERSION_KEY = "mediation.version.value";
    private final JsonStorage publicStorage;

    static <clinit>() {
        new AndroidMediationDataSource$Companion(0);
        Companion = new AndroidMediationDataSource$Companion(..);
        return;
    }

    public AndroidMediationDataSource(JsonStorage p0) {
        new Object();
        publicStorage = p0;
        return;
    }

    public String getName() {
        publicStorage.get("mediation.name.value");
        return JsonStorage.get(..);
    }

    public String getVersion() {
        publicStorage.get("mediation.version.value");
        return JsonStorage.get(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidPrivacyDeviceInfoDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidPrivacyDeviceInfoDataSource {
    private final Context context;
    private final MutableStateFlow idfaInitialized;

    public AndroidPrivacyDeviceInfoDataSource(Context p0) {
        new Object();
        context = p0;
        Boolean.valueOf(0);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        idfaInitialized = StateFlowKt.MutableStateFlow(..);
        return;
    }

    private final String getAdvertisingTrackingId() {
        AdvertisingId.getAdvertisingTrackingId();
        if (if-nez(AdvertisingId.getAdvertisingTrackingId(..))) goto L_8;
      L_8:
        return "";
    }

    private final String getOpenAdvertisingTrackingId() {
        OpenAdvertisingId.getOpenAdvertisingTrackingId();
        if (if-nez(OpenAdvertisingId.getOpenAdvertisingTrackingId(..))) goto L_8;
      L_8:
        return "";
    }

    public PiiOuterClass$Pii fetch(AllowedPiiOuterClass$AllowedPii p0) {
        idfaInitialized.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        if (if-nez(Boolean.booleanValue(..))) goto L_27;
        Boolean.valueOf(1);
        idfaInitialized.setValue(Boolean.valueOf(..));
        AdvertisingId.init(context);
        OpenAdvertisingId.init(context);
      L_27:
        PiiOuterClass$Pii.newBuilder();
        PiiKt$Dsl.Companion._create(PiiOuterClass$Pii.newBuilder(..));
        p0.getIdfa();
        if (if-eqz(AllowedPiiOuterClass$AllowedPii.getIdfa(..))) goto L_80;
        AndroidPrivacyDeviceInfoDataSource.getAdvertisingTrackingId();
        CharSequence.length();
        if (if-lez(CharSequence.length(..))) goto L_4c;
      L_4c:
      L_4d:
        if (if-eqz(0)) goto L_5f;
        UUID.fromString(AndroidPrivacyDeviceInfoDataSource.getAdvertisingTrackingId(..));
        ProtobufExtensionsKt.toByteString(UUID.fromString(..));
        PiiKt$Dsl$Companion._create(..).setAdvertisingId(ProtobufExtensionsKt.toByteString(..));
      L_5f:
        AndroidPrivacyDeviceInfoDataSource.getOpenAdvertisingTrackingId();
        CharSequence.length();
        if (if-lez(CharSequence.length(..))) goto L_6d;
      L_6d:
      L_6e:
        if (if-eqz(0)) goto L_80;
        UUID.fromString(AndroidPrivacyDeviceInfoDataSource.getOpenAdvertisingTrackingId(..));
        ProtobufExtensionsKt.toByteString(UUID.fromString(..));
        PiiKt$Dsl$Companion._create(..).setOpenAdvertisingTrackingId(ProtobufExtensionsKt.toByteString(..));
      L_80:
        PiiKt$Dsl$Companion._create(..)._build();
        return PiiKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidRemoteCacheDataSource {
    private final HttpClient httpClient;

    public AndroidRemoteCacheDataSource(HttpClient p0) {
        new Object();
        httpClient = p0;
        return;
    }

    public static final Object access$downloadFile(AndroidRemoteCacheDataSource p0, String p1, File p2, Integer p3, Continuation p4) {
        p0.downloadFile(p1, p2, p3, p4);
        return AndroidRemoteCacheDataSource.downloadFile(..);
    }

    private final Object downloadFile(String p0, File p1, Integer p2, Continuation p3) {
        if (if-eqz(p2)) goto L_18;
        p2.intValue();
      L_18:
      L_1b:
        new HttpRequest(p0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        httpClient.execute(new HttpRequest, p3);
        return HttpClient.execute(..);
    }

    private final File setupFile(File p0, String p1) {
        new File(p0, p1);
        new File(..).exists();
        if (if-nez(File.exists(..))) goto L_f;
        new File(..).createNewFile();
      L_f:
        new File(..).delete();
        new File(..).createNewFile();
      L_15:
        return new File(..);
    }

    public Object getFile(File p0, String p1, String p2, Integer p3, Continuation p4) {
        if (if-eqz(v4)) goto L_1c;
        if (if-eqz(label)) goto L_1c;
        label = label;
      L_1c:
        new AndroidRemoteCacheDataSource$getFile$1(this, label);
      L_21:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_4d;
        if (if-ne(label, 1)) goto L_45;
        ResultKt.throwOnFailure(result);
      L_45:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_4d:
        ResultKt.throwOnFailure(result);
        if (if-nez(new IllegalStateException(..))) goto L_5c;
        new CacheResult$Failure(CacheError.MALFORMED_URL, CacheSource.REMOTE);
        return new CacheResult$Failure(..);
      L_5c:
        AndroidRemoteCacheDataSource.setupFile(p0, p1);
        L$0 = p1;
        L$1 = new CacheResult$Failure(..);
        L$2 = CacheError.MALFORMED_URL;
        L$3 = AndroidRemoteCacheDataSource.setupFile(..);
        label = 1;
        AndroidRemoteCacheDataSource.downloadFile(new CacheResult$Failure(..), AndroidRemoteCacheDataSource.setupFile(..), CacheError.MALFORMED_URL, L$0);
        if (if-ne(AndroidRemoteCacheDataSource.downloadFile(..), L$1)) goto L_73;
        return L$1;
      L_73:
      L_77:
        StringsKt.substringBefore$default(new CacheResult$Failure(..), "?", 0, 2, 0);
        StringsKt.substringAfterLast$default(StringsKt.substringBefore$default(..), ".", 0, 2, 0);
        HttpResponse.getContentSize();
        HttpResponse.getProtocol();
        if (if-eqz(CacheError.MALFORMED_URL)) goto L_9a;
        CacheError.MALFORMED_URL.intValue();
      L_9a:
      L_9d:
        new CachedFile("", new CacheResult$Failure(..), p1, AndroidRemoteCacheDataSource.setupFile(..), StringsKt.substringAfterLast$default(..), HttpResponse.getContentSize(..), v13, HttpResponse.getProtocol(..), 0x7FFFFFFF);
        HttpResponseKt.isSuccessful(AndroidRemoteCacheDataSource.downloadFile(..));
        if (if-eqz(HttpResponseKt.isSuccessful(..))) goto L_b2;
        new CacheResult$Success(new CachedFile, CacheSource.REMOTE);
      L_b2:
        new CacheResult$Failure(CacheError.NETWORK_ERROR, CacheSource.REMOTE);
      L_be:
        return new CacheResult$Failure(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidStaticDeviceInfoDataSource {
    public static final String ALGORITHM_SHA1 = "SHA-1";
    public static final String APP_VERSION_FAKE = "FakeVersionName";
    public static final String BINARY_SU = "su";
    public static final String CERTIFICATE_TYPE_X509 = "X.509";
    public static final AndroidStaticDeviceInfoDataSource$Companion Companion = null;
    public static final String ENVIRONMENT_VARIABLE_PATH = "PATH";
    public static final String PLATFORM_ANDROID = "android";
    public static final String STORE_GOOGLE = "google";
    private final X500Principal DEBUG_CERT;
    private final AnalyticsDataSource analyticsDataSource;
    private final Context context;
    private final ByteStringDataSource glInfoStore;
    private StaticDeviceInfoOuterClass$StaticDeviceInfo staticDeviceInfo;
    private final StoreDataSource storeDataSource;

    static <clinit>() {
        new AndroidStaticDeviceInfoDataSource$Companion(0);
        Companion = new AndroidStaticDeviceInfoDataSource$Companion(..);
        return;
    }

    public AndroidStaticDeviceInfoDataSource(Context p0, ByteStringDataSource p1, AnalyticsDataSource p2, StoreDataSource p3) {
        new Object();
        context = p0;
        glInfoStore = p1;
        analyticsDataSource = p2;
        storeDataSource = p3;
        new X500Principal("CN=Android Debug,O=Android,C=US");
        DEBUG_CERT = new X500Principal(..);
        StaticDeviceInfoOuterClass$StaticDeviceInfo.newBuilder();
        StaticDeviceInfoKt$Dsl.Companion._create(StaticDeviceInfoOuterClass$StaticDeviceInfo.newBuilder(..));
        new Object(..).getAppName();
        StaticDeviceInfoKt$Dsl.setBundleId(AndroidStaticDeviceInfoDataSource.getAppName(..));
        new Object(..).getAppVersion();
        StaticDeviceInfoKt$Dsl.setBundleVersion(AndroidStaticDeviceInfoDataSource.getAppVersion(..));
        new Object(..).isAppDebuggable();
        StaticDeviceInfoKt$Dsl.setAppDebuggable(AndroidStaticDeviceInfoDataSource.isAppDebuggable(..));
        new Object(..).isRooted();
        StaticDeviceInfoKt$Dsl.setRooted(AndroidStaticDeviceInfoDataSource.isRooted(..));
        new Object(..).getOsVersion();
        StaticDeviceInfoKt$Dsl.setOsVersion(AndroidStaticDeviceInfoDataSource.getOsVersion(..));
        new Object(..).getManufacturer();
        StaticDeviceInfoKt$Dsl.setDeviceMake(AndroidStaticDeviceInfoDataSource.getManufacturer(..));
        new Object(..).getModel();
        StaticDeviceInfoKt$Dsl.setDeviceModel(AndroidStaticDeviceInfoDataSource.getModel(..));
        new Object(..).getWebViewUserAgent();
        StaticDeviceInfoKt$Dsl.setWebviewUa(AndroidStaticDeviceInfoDataSource.getWebViewUserAgent(..));
        new Object(..).getScreenDensity();
        StaticDeviceInfoKt$Dsl.setScreenDensity(AndroidStaticDeviceInfoDataSource.getScreenDensity(..));
        new Object(..).getScreenWidth();
        StaticDeviceInfoKt$Dsl.setScreenWidth(AndroidStaticDeviceInfoDataSource.getScreenWidth(..));
        new Object(..).getScreenHeight();
        StaticDeviceInfoKt$Dsl.setScreenHeight(AndroidStaticDeviceInfoDataSource.getScreenHeight(..));
        new Object(..).getScreenLayout();
        StaticDeviceInfoKt$Dsl.setScreenSize(AndroidStaticDeviceInfoDataSource.getScreenLayout(..));
        StaticDeviceInfoKt$Dsl.getStores();
        AndroidStaticDeviceInfoDataSource.getStores$default(new Object(..), 0, 1, 0);
        StaticDeviceInfoKt$Dsl.addAllStores(StaticDeviceInfoKt$Dsl.getStores(..), AndroidStaticDeviceInfoDataSource.getStores$default(..));
        new Object(..).getFileForStorageType(StorageType.EXTERNAL);
        new Object(..).getTotalSpace(AndroidStaticDeviceInfoDataSource.getFileForStorageType(..));
        StaticDeviceInfoKt$Dsl.setTotalDiskSpace(AndroidStaticDeviceInfoDataSource.getTotalSpace(..), AndroidStaticDeviceInfoDataSource.getStores$default(..));
        new Object(..).getTotalMemory();
        StaticDeviceInfoKt$Dsl.setTotalRamMemory(AndroidStaticDeviceInfoDataSource.getTotalMemory(..), AndroidStaticDeviceInfoDataSource.getStores$default(..));
        new Object(..).getCPUModel();
        StaticDeviceInfoKt$Dsl.setCpuModel(AndroidStaticDeviceInfoDataSource.getCPUModel(..));
        new Object(..).getCPUCount();
        StaticDeviceInfoKt$Dsl.setCpuCount(AndroidStaticDeviceInfoDataSource.getCPUCount(..), AndroidStaticDeviceInfoDataSource.getStores$default(..));
        new Object(..).fetchAndroidStaticDeviceInfo();
        StaticDeviceInfoKt$Dsl.setAndroid(AndroidStaticDeviceInfoDataSource.fetchAndroidStaticDeviceInfo(..));
        StaticDeviceInfoKt$Dsl._build();
        staticDeviceInfo = StaticDeviceInfoKt$Dsl._build(..);
        return;
    }

    public static final Object access$getGPUModel(AndroidStaticDeviceInfoDataSource p0, Continuation p1) {
        p0.getGPUModel(p1);
        return AndroidStaticDeviceInfoDataSource.getGPUModel(..);
    }

    private final StaticDeviceInfoOuterClass$StaticDeviceInfo$Android fetchAndroidStaticDeviceInfo() {
        StaticDeviceInfoOuterClass$StaticDeviceInfo$Android.newBuilder();
        StaticDeviceInfoKt$AndroidKt$Dsl$Companion._create(StaticDeviceInfoOuterClass$StaticDeviceInfo$Android.newBuilder(..));
        AndroidStaticDeviceInfoDataSource.getApiLevel();
        StaticDeviceInfoKt$AndroidKt$Dsl.setApiLevel(AndroidStaticDeviceInfoDataSource.getApiLevel(..));
        AndroidStaticDeviceInfoDataSource.getVersionCode();
        StaticDeviceInfoKt$AndroidKt$Dsl.setVersionCode(AndroidStaticDeviceInfoDataSource.getVersionCode(..));
        AndroidStaticDeviceInfoDataSource.getFingerprint();
        StaticDeviceInfoKt$AndroidKt$Dsl.setAndroidFingerprint(AndroidStaticDeviceInfoDataSource.getFingerprint(..));
        AndroidStaticDeviceInfoDataSource.getInstallerPackageName();
        StaticDeviceInfoKt$AndroidKt$Dsl.setAppInstaller(AndroidStaticDeviceInfoDataSource.getInstallerPackageName(..));
        AndroidStaticDeviceInfoDataSource.getCertificateFingerprint();
        StaticDeviceInfoKt$AndroidKt$Dsl.setApkDeveloperSigningCertificateHash(AndroidStaticDeviceInfoDataSource.getCertificateFingerprint(..));
        AndroidStaticDeviceInfoDataSource.getBoard();
        StaticDeviceInfoKt$AndroidKt$Dsl.setBuildBoard(AndroidStaticDeviceInfoDataSource.getBoard(..));
        AndroidStaticDeviceInfoDataSource.getBrand();
        StaticDeviceInfoKt$AndroidKt$Dsl.setBuildBrand(AndroidStaticDeviceInfoDataSource.getBrand(..));
        AndroidStaticDeviceInfoDataSource.getDevice();
        StaticDeviceInfoKt$AndroidKt$Dsl.setBuildDevice(AndroidStaticDeviceInfoDataSource.getDevice(..));
        AndroidStaticDeviceInfoDataSource.getDisplay();
        StaticDeviceInfoKt$AndroidKt$Dsl.setBuildDisplay(AndroidStaticDeviceInfoDataSource.getDisplay(..));
        AndroidStaticDeviceInfoDataSource.getFingerprint();
        StaticDeviceInfoKt$AndroidKt$Dsl.setBuildFingerprint(AndroidStaticDeviceInfoDataSource.getFingerprint(..));
        AndroidStaticDeviceInfoDataSource.getHardware();
        StaticDeviceInfoKt$AndroidKt$Dsl.setBuildHardware(AndroidStaticDeviceInfoDataSource.getHardware(..));
        AndroidStaticDeviceInfoDataSource.getHost();
        StaticDeviceInfoKt$AndroidKt$Dsl.setBuildHost(AndroidStaticDeviceInfoDataSource.getHost(..));
        AndroidStaticDeviceInfoDataSource.getBootloader();
        StaticDeviceInfoKt$AndroidKt$Dsl.setBuildBootloader(AndroidStaticDeviceInfoDataSource.getBootloader(..));
        AndroidStaticDeviceInfoDataSource.getProduct();
        StaticDeviceInfoKt$AndroidKt$Dsl.setBuildProduct(AndroidStaticDeviceInfoDataSource.getProduct(..));
        AndroidStaticDeviceInfoDataSource.getExtensionVersion();
        StaticDeviceInfoKt$AndroidKt$Dsl.setExtensionVersion(AndroidStaticDeviceInfoDataSource.getExtensionVersion(..));
        AndroidStaticDeviceInfoDataSource.getBuildId();
        if (if-eqz(AndroidStaticDeviceInfoDataSource.getBuildId(..))) goto L_83;
        StaticDeviceInfoKt$AndroidKt$Dsl.setBuildId(AndroidStaticDeviceInfoDataSource.getBuildId(..));
      L_83:
        AndroidStaticDeviceInfoDataSource.getPhoneType();
        StaticDeviceInfoKt$AndroidKt$Dsl.setPhoneType(AndroidStaticDeviceInfoDataSource.getPhoneType(..));
        AndroidStaticDeviceInfoDataSource.getSimOperator();
        StaticDeviceInfoKt$AndroidKt$Dsl.setSimOperator(AndroidStaticDeviceInfoDataSource.getSimOperator(..));
        StaticDeviceInfoKt$AndroidKt$Dsl._build();
        return StaticDeviceInfoKt$AndroidKt$Dsl._build(..);
    }

    private final int getApiLevel() {
        return Build$VERSION.SDK_INT;
    }

    private final long getAppStartTime() {
        SdkProperties.getInitializationTimeEpoch();
        return SdkProperties.getInitializationTimeEpoch(..);
    }

    private final String getAppVersion() {
        context.getPackageName();
        context.getPackageManager();
        Context.getPackageManager(..).getPackageInfo(Context.getPackageName(..), 0);
        if (if-nez(versionName)) goto L_18;
      L_18:
        Context.getPackageManager(..).getPackageInfo("FakeVersionName", 0);
      L_1e:
        DeviceLog.exception("Error getting package info", versionName);
      L_2e:
        return "";
    }

    private final long getCPUCount() {
        Runtime.getRuntime();
        Runtime.getRuntime(..).availableProcessors();
        return Runtime.availableProcessors(..);
    }

    private final String getCPUModel() {
        if (if-lt(Build$VERSION.SDK_INT, 31)) goto L_e;
      L_e:
        new File("/proc/cpuinfo");
        FilesKt.readLines$default(new File(..), 0, 1, 0);
        CollectionsKt.last(FilesKt.readLines$default(..));
        DeviceLog.exception("Error reading CPU model", CollectionsKt.last(..));
      L_2c:
        return "";
    }

    private final String getCertificateFingerprint() {
        context.getPackageManager();
        context.getPackageName();
        Context.getPackageManager(..).getPackageInfo(Context.getPackageName(..), 64);
        if (if-eqz(signatures)) goto L_5d;
        if (if-nez(Context.getPackageName(..))) goto L_1d;
      L_1d:
      L_1e:
        if (if-eqz(0)) goto L_5d;
        CertificateFactory.getInstance("X.509");
        signatures.toByteArray();
        new ByteArrayInputStream(Signature.toByteArray(..));
        CertificateFactory.getInstance(..).generateCertificate(new ByteArrayInputStream(..));
        Intrinsics.checkNotNull(CertificateFactory.generateCertificate(..), "null cannot be cast to non-null type java.security.cert.X509Certificate");
        MessageDigest.getInstance("SHA-1");
        X509Certificate.getEncoded();
        MessageDigest.getInstance(..).digest(X509Certificate.getEncoded(..));
        Utilities.toHexString(MessageDigest.digest(..));
        return Utilities.toHexString(..);
        DeviceLog.exception("Exception when signing certificate fingerprint", Utilities.toHexString(..));
      L_5d:
        return "";
    }

    private final float getDisplayMetricDensity() {
        context.getResources();
        if (if-eqz(Context.getResources(..))) goto L_11;
        Context.getResources(..).getDisplayMetrics();
        if (if-eqz(Resources.getDisplayMetrics(..))) goto L_11;
      L_11:
      L_12:
        return 0;
    }

    private final int getExtensionVersion() {
        if (if-lt(Build$VERSION.SDK_INT, 30)) goto L_b;
        SdkExtensions.getExtensionVersion(30);
      L_b:
      L_c:
        return -1;
    }

    private final File getFileForStorageType(StorageType p0) {
        p0.ordinal();
        if (if-eq(AndroidStaticDeviceInfoDataSource$WhenMappings.$EnumSwitchMapping$1, 1)) goto L_28;
        if (if-eq(AndroidStaticDeviceInfoDataSource$WhenMappings.$EnumSwitchMapping$1, 2)) goto L_21;
        new StringBuilder("Unhandled storagetype: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
      L_21:
        context.getExternalCacheDir();
      L_28:
        context.getCacheDir();
      L_2e:
        return Context.getCacheDir(..);
    }

    private final String getFingerprint() {
        if (if-nez(Build.FINGERPRINT)) goto L_6;
      L_6:
        return "";
    }

    private final Object getGPUModel(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidStaticDeviceInfoDataSource$getGPUModel$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        label = 1;
        glInfoStore.get("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(ByteStringDataSource.get(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_40;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_40:
        ByteStringDataSource.get(..).getData();
        ByteString.toString(Charsets.ISO_8859_1);
        return ByteString.toString(..);
    }

    private final String getGameId() {
        ClientProperties.getGameId();
        if (if-nez(ClientProperties.getGameId(..))) goto L_8;
      L_8:
        return "";
    }

    private final String getInstallerPackageName() {
        context.getPackageManager();
        context.getPackageName();
        Context.getPackageManager(..).getInstallerPackageName(Context.getPackageName(..));
        if (if-nez(PackageManager.getInstallerPackageName(..))) goto L_14;
      L_14:
        return "";
    }

    private final long getMemoryInfo(Device$MemoryInfoType p0) {
        p0.ordinal();
        if (if-eq(Device$MemoryInfoType.ordinal(..), 1)) goto L_15;
        if (if-ne(Device$MemoryInfoType.ordinal(..), 2)) goto L_f;
      L_f:
        new NoWhenBranchMatchedException();
        throw new NoWhenBranchMatchedException(..);
      L_15:
        new RandomAccessFile("/proc/meminfo", "r");
      L_26:
        if (if-ge(0, 2)) goto L_2f;
        new RandomAccessFile(..).readLine();
      L_2f:
        CloseableKt.closeFinally(new RandomAccessFile(..), 0);
      L_3a:
        throw Unit.INSTANCE;
        CloseableKt.closeFinally(new RandomAccessFile(..), Unit.INSTANCE);
        throw Unit.INSTANCE;
      L_45:
        DeviceLog.exception("Error reading memory info", Unit.INSTANCE);
      L_4c:
        AndroidStaticDeviceInfoDataSource.getMemoryValueFromString(Unit.INSTANCE);
        return AndroidStaticDeviceInfoDataSource.getMemoryValueFromString(..);
    }

    private final long getMemoryValueFromString(String p0) {
        if (if-eqz(p0)) goto L_25;
        Pattern.compile("(\\d+)");
        Pattern.compile(..).matcher(p0);
      L_f:
        Pattern.matcher(..).find();
        if (if-eqz(Matcher.find(..))) goto L_1b;
        Pattern.matcher(..).group(1);
      L_1b:
        if (if-eqz(Matcher.group(..))) goto L_22;
        Long.parseLong(Matcher.group(..));
      L_22:
      L_24:
        return -1L;
      L_25:
        return 0L;
    }

    private final ArrayList getNewAbiList() {
        new ArrayList();
        Arrays.copyOf(Build.SUPPORTED_ABIS, "SUPPORTED_ABIS");
        CollectionsKt.listOf(Arrays.copyOf(..));
        new ArrayList(..).addAll(CollectionsKt.listOf(..));
        return new ArrayList(..);
    }

    private final List getOldAbiList() {
        new ArrayList();
        new ArrayList(..).add(Build.CPU_ABI);
        new ArrayList(..).add(Build.CPU_ABI2);
        return new ArrayList(..);
    }

    private final String getOpenAdvertisingTrackingId() {
        OpenAdvertisingId.getOpenAdvertisingTrackingId();
        if (if-nez(OpenAdvertisingId.getOpenAdvertisingTrackingId(..))) goto L_8;
      L_8:
        return "";
    }

    private final int getPhoneType() {
        context.getSystemService("phone");
        Intrinsics.checkNotNull(Context.getSystemService(..), "null cannot be cast to non-null type android.telephony.TelephonyManager");
        Context.getSystemService(..).getPhoneType();
        return TelephonyManager.getPhoneType(..);
    }

    private final String getPlatform() {
        return "android";
    }

    private final int getScreenDensity() {
        context.getResources();
        if (if-eqz(Context.getResources(..))) goto L_11;
        Context.getResources(..).getDisplayMetrics();
        if (if-eqz(Resources.getDisplayMetrics(..))) goto L_11;
      L_11:
      L_12:
        return -1;
    }

    private final int getScreenHeight() {
        context.getResources();
        if (if-eqz(Context.getResources(..))) goto L_11;
        Context.getResources(..).getDisplayMetrics();
        if (if-eqz(Resources.getDisplayMetrics(..))) goto L_11;
      L_11:
      L_12:
        return -1;
    }

    private final int getScreenLayout() {
        context.getResources();
        Context.getResources(..).getConfiguration();
        return screenLayout;
    }

    private final int getScreenWidth() {
        context.getResources();
        if (if-eqz(Context.getResources(..))) goto L_11;
        Context.getResources(..).getDisplayMetrics();
        if (if-eqz(Resources.getDisplayMetrics(..))) goto L_11;
      L_11:
      L_12:
        return -1;
    }

    private final String getSimOperator() {
        context.getSystemService("phone");
        Intrinsics.checkNotNull(Context.getSystemService(..), "null cannot be cast to non-null type android.telephony.TelephonyManager");
        Context.getSystemService(..).getSimOperator();
        return TelephonyManager.getSimOperator(..);
    }

    private final List getStores(List p0) {
        storeDataSource.fetchStores(p0);
        return StoreDataSource.fetchStores(..);
    }

    static List getStores$default(AndroidStaticDeviceInfoDataSource p0, List p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_8;
        CollectionsKt.emptyList();
      L_8:
        p0.getStores(CollectionsKt.emptyList(..));
        return AndroidStaticDeviceInfoDataSource.getStores(..);
    }

    private final int getVersionCode() {
        return 41205;
    }

    private final String getVersionName() {
        return "4.12.5";
    }

    private final String getWebViewUserAgent() {
        WebSettings.getDefaultUserAgent(context);
        DeviceLog.exception("Exception getting webview user agent", WebSettings.getDefaultUserAgent(..));
      L_14:
        return "";
    }

    private final boolean isAppDebuggable() {
        context.getPackageManager();
        context.getPackageName();
        Context.getPackageManager(..).getApplicationInfo(Context.getPackageName(..), 0);
        flags = flags;
        if (if-eqz(flags)) goto L_30;
      L_30:
        DeviceLog.exception("Could not find name", 0);
      L_3a:
        if (if-eqz(0)) goto L_88;
        Context.getPackageManager(..).getPackageInfo(Context.getPackageName(..), 64);
      L_4a:
        if (if-ge(0, "signatures")) goto L_88;
        CertificateFactory.getInstance("X.509");
        64.toByteArray();
        new ByteArrayInputStream(Signature.toByteArray(..));
        CertificateFactory.getInstance(..).generateCertificate(new ByteArrayInputStream(..));
        Intrinsics.checkNotNull(CertificateFactory.generateCertificate(..), "null cannot be cast to non-null type java.security.cert.X509Certificate");
        X509Certificate.getSubjectX500Principal();
        Intrinsics.areEqual(X509Certificate.getSubjectX500Principal(..), DEBUG_CERT);
        if (if-nez(Intrinsics.areEqual(..))) goto L_88;
        DeviceLog.exception("Certificate exception", "Could not find name");
        DeviceLog.exception("Could not find name", "Certificate exception");
      L_88:
        return Intrinsics.areEqual(..);
    }

    private final boolean isHardwareAccelerated(MediaCodecInfo p0, String p1) {
        AndroidStaticDeviceInfoDataSource.getApiLevel();
        if (if-lt(AndroidStaticDeviceInfoDataSource.getApiLevel(..), 29)) goto L_d;
        AndroidStaticDeviceInfoDataSource.isHardwareAcceleratedV29(p0);
      L_d:
        AndroidStaticDeviceInfoDataSource.isSoftwareOnly(AndroidStaticDeviceInfoDataSource.isHardwareAcceleratedV29(..), p1);
        if (if-nez(AndroidStaticDeviceInfoDataSource.isSoftwareOnly(..))) goto L_15;
      L_15:
      L_16:
        return 0;
    }

    private final boolean isHardwareAcceleratedV29(MediaCodecInfo p0) {
        p0.isHardwareAccelerated();
        return MediaCodecInfo.isHardwareAccelerated(..);
    }

    private final boolean isRooted() {
        AndroidStaticDeviceInfoDataSource.searchPathForBinary("su");
        DeviceLog.exception("Rooted check failed", AndroidStaticDeviceInfoDataSource.searchPathForBinary(..));
      L_e:
        return 0;
    }

    private final boolean isSoftwareOnly(MediaCodecInfo p0, String p1) {
        AndroidStaticDeviceInfoDataSource.getApiLevel();
        if (if-lt(AndroidStaticDeviceInfoDataSource.getApiLevel(..), 29)) goto L_d;
        AndroidStaticDeviceInfoDataSource.isSoftwareOnlyV29(p0);
        return AndroidStaticDeviceInfoDataSource.isSoftwareOnlyV29(..);
      L_d:
        MediaCodecInfo.getName();
        MediaCodecInfo.getName(..).toLowerCase(Locale.ROOT);
        StringsKt.startsWith$default(String.toLowerCase(..), "arc.", 0, 2, 0);
        if (if-eqz(StringsKt.startsWith$default(..))) goto L_32;
      L_32:
        StringsKt.startsWith$default(String.toLowerCase(..), "omx.google.", 0, 2, 0);
        if (if-nez(StringsKt.startsWith$default(..))) goto L_7f;
        StringsKt.startsWith$default(String.toLowerCase(..), "omx.ffmpeg.", 0, 2, 0);
        if (if-nez(StringsKt.startsWith$default(..))) goto L_7f;
        StringsKt.startsWith$default(String.toLowerCase(..), "omx.sec.", 0, 2, 0);
        if (if-eqz(StringsKt.startsWith$default(..))) goto L_57;
        StringsKt.contains$default(String.toLowerCase(..), ".sw.", 0, 2, 0);
        if (if-nez(StringsKt.contains$default(..))) goto L_7f;
      L_57:
        Intrinsics.areEqual(String.toLowerCase(..), "omx.qcom.video.decoder.hevcswvdec");
        if (if-nez(Intrinsics.areEqual(..))) goto L_7f;
        StringsKt.startsWith$default(String.toLowerCase(..), "c2.android.", 0, 2, 0);
        if (if-nez(StringsKt.startsWith$default(..))) goto L_7f;
        StringsKt.startsWith$default(String.toLowerCase(..), "c2.google.", 0, 2, 0);
        if (if-nez(StringsKt.startsWith$default(..))) goto L_7f;
        StringsKt.startsWith$default(String.toLowerCase(..), "omx.", 0, 2, 0);
        if (if-nez(StringsKt.startsWith$default(..))) goto L_80;
        StringsKt.startsWith$default(String.toLowerCase(..), "c2.", 0, 2, 0);
        if (if-nez(StringsKt.startsWith$default(..))) goto L_80;
      L_7f:
      L_80:
        return 1;
    }

    private final boolean isSoftwareOnlyV29(MediaCodecInfo p0) {
        p0.isSoftwareOnly();
        return MediaCodecInfo.isSoftwareOnly(..);
    }

    private final boolean isTestMode() {
        SdkProperties.isTestMode();
        return SdkProperties.isTestMode(..);
    }

    private final boolean searchPathForBinary(String p0) {
        System.getenv("PATH");
        if (if-eqz(System.getenv(..))) goto L_92;
        new Regex(":");
        new Regex(..).split(System.getenv(..), 0);
        if (if-eqz(Regex.split(..))) goto L_92;
        Regex.split(..).isEmpty();
        if (if-nez(List.isEmpty(..))) goto L_4c;
        Regex.split(..).size();
        Regex.split(..).listIterator(List.size(..));
      L_27:
        List.listIterator(..).hasPrevious();
        if (if-eqz(ListIterator.hasPrevious(..))) goto L_4c;
        List.listIterator(..).previous();
        ListIterator.previous(..).length();
        if (if-nez(CharSequence.length(..))) goto L_3d;
      L_3d:
      L_3e:
        if (if-nez(0)) goto L_27;
        List.listIterator(..).nextIndex();
        CollectionsKt.take(Regex.split(..), ListIterator.nextIndex(..));
      L_4c:
        CollectionsKt.emptyList();
      L_50:
        if (if-eqz(CollectionsKt.emptyList(..))) goto L_92;
        CollectionsKt.emptyList(..).toArray(ListIterator.nextIndex(..));
        if (if-eqz(Collection.toArray(..))) goto L_92;
      L_60:
        if (if-ge(0, ListIterator.nextIndex(..))) goto L_92;
        new File(v5);
        new File(..).exists();
        if (if-eqz(File.exists(..))) goto L_8f;
        new File(..).isDirectory();
        if (if-eqz(File.isDirectory(..))) goto L_8f;
        new File(..).listFiles();
        if (if-eqz(File.listFiles(..))) goto L_8f;
      L_7d:
        if (if-ge(0, new File(..))) goto L_8f;
        File.getName();
        Intrinsics.areEqual(File.getName(..), p0);
        if (if-eqz(Intrinsics.areEqual(..))) goto L_8c;
        return 1;
      L_8c:
      L_8f:
      L_92:
        return 0;
    }

    private final List selectAllDecodeCodecs(String p0) {
        new ArrayList();
        MediaCodecList.getCodecCount();
      L_d:
        if (if-ge(0, MediaCodecList.getCodecCount(..))) goto L_3f;
        MediaCodecList.getCodecInfoAt(0);
        MediaCodecList.getCodecInfoAt(..).isEncoder();
        if (if-eqz(MediaCodecInfo.isEncoder(..))) goto L_1a;
      L_1a:
        MediaCodecList.getCodecInfoAt(..).getSupportedTypes();
      L_20:
        if (if-ge(0, v6)) goto L_3c;
        StringsKt.equals(v8, p0, 1);
        if (if-eqz(StringsKt.equals(..))) goto L_39;
        AndroidStaticDeviceInfoDataSource.isHardwareAccelerated(MediaCodecList.getCodecInfoAt(..), p0);
        if (if-eqz(AndroidStaticDeviceInfoDataSource.isHardwareAccelerated(..))) goto L_39;
        new ArrayList(..).add(MediaCodecList.getCodecInfoAt(..));
      L_39:
      L_3c:
      L_3f:
        return new ArrayList(..);
    }

    public Object fetch(List p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidStaticDeviceInfoDataSource$fetch$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_3b;
        if (if-ne(label, 1)) goto L_33;
        ResultKt.throwOnFailure(result);
      L_33:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_3b:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        staticDeviceInfo.getGpuModel();
        if (if-eqz(StaticDeviceInfoOuterClass$StaticDeviceInfo.getGpuModel(..))) goto L_51;
        CharSequence.length();
        if (if-nez(CharSequence.length(..))) goto L_4f;
      L_4f:
      L_51:
      L_52:
        if (if-nez(1)) goto L_57;
        return staticDeviceInfo;
      L_57:
        L$0 = this;
        L$1 = staticDeviceInfo;
        label = 1;
        AndroidStaticDeviceInfoDataSource.getGPUModel(L$0);
        if (if-ne(AndroidStaticDeviceInfoDataSource.getGPUModel(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_64;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_64:
      L_65:
        if (if-eqz(AndroidStaticDeviceInfoDataSource.getGPUModel(..))) goto L_72;
        CharSequence.length();
        if (if-nez(CharSequence.length(..))) goto L_73;
      L_72:
      L_73:
        if (if-eqz(1)) goto L_78;
        return staticDeviceInfo;
      L_78:
        staticDeviceInfo.toBuilder();
        StaticDeviceInfoKt$Dsl.Companion._create(StaticDeviceInfoOuterClass$StaticDeviceInfo.toBuilder(..));
        StaticDeviceInfoKt$Dsl.setGpuModel(AndroidStaticDeviceInfoDataSource.getGPUModel(..));
        StaticDeviceInfoKt$Dsl.getStores();
        StaticDeviceInfoKt$Dsl.clearStores(StaticDeviceInfoKt$Dsl.getStores(..));
        StaticDeviceInfoKt$Dsl.getStores();
        AndroidStaticDeviceInfoDataSource.getStores(staticDeviceInfo);
        StaticDeviceInfoKt$Dsl.addAllStores(StaticDeviceInfoKt$Dsl.getStores(..), AndroidStaticDeviceInfoDataSource.getStores(..));
        StaticDeviceInfoKt$Dsl._build();
        staticDeviceInfo = StaticDeviceInfoKt$Dsl._build(..);
        return StaticDeviceInfoKt$Dsl._build(..);
    }

    public StaticDeviceInfoOuterClass$StaticDeviceInfo fetchCached() {
        return staticDeviceInfo;
    }

    public final String getAdvertisingTrackingId() {
        AdvertisingId.getAdvertisingTrackingId();
        if (if-nez(AdvertisingId.getAdvertisingTrackingId(..))) goto L_8;
      L_8:
        return "";
    }

    public String getAnalyticsUserId() {
        analyticsDataSource.getUserId();
        return AnalyticsDataSource.getUserId(..);
    }

    public String getAppName() {
        context.getPackageName();
        return Context.getPackageName(..);
    }

    public Object getAuid(Continuation p0) {
        AndroidPreferences.getString("supersonic_shared_preferen", "auid");
        if (if-nez(AndroidPreferences.getString(..))) goto L_b;
      L_b:
        return 0;
    }

    public final String getBoard() {
        if (if-nez(Build.BOARD)) goto L_6;
      L_6:
        return "";
    }

    public final String getBootloader() {
        if (if-nez(Build.BOOTLOADER)) goto L_6;
      L_6:
        return "";
    }

    public final String getBrand() {
        if (if-nez(Build.BRAND)) goto L_6;
      L_6:
        return "";
    }

    public final String getBuildId() {
        return Build.ID;
    }

    public final String getBuildVersionIncremental() {
        return Build$VERSION.INCREMENTAL;
    }

    public final Context getContext() {
        return context;
    }

    public final String getDevice() {
        if (if-nez(Build.DEVICE)) goto L_6;
      L_6:
        return "";
    }

    public final String getDisplay() {
        if (if-nez(Build.DISPLAY)) goto L_6;
      L_6:
        return "";
    }

    public final String getHardware() {
        if (if-nez(Build.HARDWARE)) goto L_6;
      L_6:
        return "";
    }

    public final String getHost() {
        if (if-nez(Build.HOST)) goto L_6;
      L_6:
        return "";
    }

    public Object getIdfi(Continuation p0) {
        AndroidPreferences.getString("unityads-installinfo", "unityads-idfi");
        if (if-nez(AndroidPreferences.getString(..))) goto L_b;
      L_b:
        if (if-nez(0)) goto L_18;
        UUID.randomUUID();
        UUID.randomUUID(..).toString();
        AndroidPreferences.setString("unityads-installinfo", "unityads-idfi", UUID.toString(..));
      L_18:
        return UUID.toString(..);
    }

    public String getManufacturer() {
        if (if-nez(Build.MANUFACTURER)) goto L_6;
      L_6:
        return "";
    }

    public String getModel() {
        if (if-nez(Build.MODEL)) goto L_6;
      L_6:
        return "";
    }

    public String getOsVersion() {
        if (if-nez(Build$VERSION.RELEASE)) goto L_6;
      L_6:
        return "";
    }

    public final String getProduct() {
        if (if-nez(Build.PRODUCT)) goto L_6;
      L_6:
        return "";
    }

    public final List getSensorList() {
        context.getSystemService("sensor");
        Intrinsics.checkNotNull(Context.getSystemService(..), "null cannot be cast to non-null type android.hardware.SensorManager");
        Context.getSystemService(..).getSensorList(-1);
        return SensorManager.getSensorList(..);
    }

    public final List getSupportedAbis() {
        AndroidStaticDeviceInfoDataSource.getApiLevel();
        if (if-ge(AndroidStaticDeviceInfoDataSource.getApiLevel(..), 21)) goto L_d;
        AndroidStaticDeviceInfoDataSource.getOldAbiList();
      L_d:
        AndroidStaticDeviceInfoDataSource.getNewAbiList();
      L_13:
        return AndroidStaticDeviceInfoDataSource.getNewAbiList(..);
    }

    public long getSystemBootTime() {
        System.currentTimeMillis();
        SystemClock.elapsedRealtime();
        return System.currentTimeMillis(..);
    }

    public final long getTotalMemory() {
        AndroidStaticDeviceInfoDataSource.getMemoryInfo(Device$MemoryInfoType.TOTAL_MEMORY);
        return AndroidStaticDeviceInfoDataSource.getMemoryInfo(..);
    }

    public final long getTotalSpace(File p0) {
        if (if-eqz(p0)) goto L_17;
        p0.exists();
        if (if-eqz(File.exists(..))) goto L_17;
        p0.getTotalSpace();
        MathKt.roundToInt(1024);
      L_17:
      L_19:
        return -1L;
    }

    public final boolean hasX264Decoder() {
        AndroidStaticDeviceInfoDataSource.selectAllDecodeCodecs("video/avc");
        Collection.isEmpty();
        return Collection.isEmpty(..);
    }

    public final boolean hasX265Decoder() {
        AndroidStaticDeviceInfoDataSource.selectAllDecodeCodecs("video/hevc");
        Collection.isEmpty();
        return Collection.isEmpty(..);
    }

    public final boolean isLimitOpenAdTrackingEnabled() {
        OpenAdvertisingId.getLimitedOpenAdTracking();
        return OpenAdvertisingId.getLimitedOpenAdTracking(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidStoreDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidStoreDataSource {
    private final Context context;

    public AndroidStoreDataSource(Context p0) {
        new Object();
        context = p0;
        return;
    }

    public List fetchStores(List p0) {
        AndroidKnownStore.values();
        new ArrayList(v2);
      L_14:
        if (if-ge(0, v2)) goto L_22;
        AndroidKnownStore.getPackageName();
        new ArrayList(..).add(AndroidKnownStore.getPackageName(..));
      L_22:
        CollectionsKt.plus(new ArrayList(..), p0);
        CollectionsKt.distinct(CollectionsKt.plus(..));
        context.getPackageManager();
        new ArrayList();
        CollectionsKt.distinct(..).iterator();
      L_45:
        Iterable.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_72;
        Iterable.iterator(..).next();
        if (if-lt(Build$VERSION.SDK_INT, 33)) goto L_63;
        PackageManager$PackageInfoFlags.of(0L, 33);
        Context.getPackageManager(..).getPackageInfo(Iterator.next(..), PackageManager$PackageInfoFlags.of(..));
      L_63:
        Context.getPackageManager(..).getPackageInfo(PackageManager.getPackageInfo(..), 0);
      L_67:
        if (if-eqz(PackageManager.getPackageInfo(..))) goto L_6b;
      L_6b:
      L_6c:
        if (if-eqz(0)) goto L_45;
        new ArrayList(..).add(Iterator.next(..));
      L_72:
        return new ArrayList(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidTcfDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidTcfDataSource {
    public static final AndroidTcfDataSource$Companion Companion = null;
    public static final String TCF_TCSTRING_KEY = "IABTCF_TCString";

    static <clinit>() {
        new AndroidTcfDataSource$Companion(0);
        Companion = new AndroidTcfDataSource$Companion(..);
        return;
    }

    public AndroidTcfDataSource() {
        new Object();
        return;
    }

    public String getTcfString() {
        new StringBuilder();
        ClientProperties.getAppName();
        new StringBuilder(..).append(ClientProperties.getAppName(..));
        new StringBuilder(..).append("_settings");
        new StringBuilder(..).toString();
        AndroidPreferences.getString(StringBuilder.toString(..), "IABTCF_TCString");
        return AndroidPreferences.getString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.ByteStringDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public abstract class ByteStringDataSource {
    public abstract Object get(Continuation p0) {
        // native or abstract
    }

    public abstract Object set(ByteString p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.CacheDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public abstract class CacheDataSource {
    public abstract Object getFile(File p0, String p1, String p2, Integer p3, Continuation p4) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.DeveloperConsentDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public abstract class DeveloperConsentDataSource {
    public abstract DeveloperConsentOuterClass$DeveloperConsent getDeveloperConsent() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.DynamicDeviceInfoDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public abstract class DynamicDeviceInfoDataSource {
    public abstract DynamicDeviceInfoOuterClass$DynamicDeviceInfo fetch() {
        // native or abstract
    }

    public abstract String getConnectionTypeStr() {
        // native or abstract
    }

    public abstract int getCurrentUiTheme() {
        // native or abstract
    }

    public abstract List getLocaleList() {
        // native or abstract
    }

    public abstract String getOrientation() {
        // native or abstract
    }

    public abstract int getRingerMode() {
        // native or abstract
    }

    public abstract Flow getVolumeSettingsChange() {
        // native or abstract
    }

    public abstract boolean hasInternet() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.FetchGLInfoDataMigration
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class FetchGLInfoDataMigration {
    private final GetOpenGLRendererInfo getOpenGLRendererInfo;

    public FetchGLInfoDataMigration(GetOpenGLRendererInfo p0) {
        new Object();
        getOpenGLRendererInfo = p0;
        return;
    }

    private final ByteString gatherOpenGLRendererInfo() {
        getOpenGLRendererInfo.invoke();
        return GetOpenGLRendererInfo.invoke(..);
    }

    public Object cleanUp(Continuation p0) {
        return Unit.INSTANCE;
    }

    public Object migrate(ByteStringStoreOuterClass$ByteStringStore p0, Continuation p1) {
        FetchGLInfoDataMigration.gatherOpenGLRendererInfo();
      L_c:
        ByteStringStoreOuterClass$ByteStringStore.newBuilder();
        ByteStringStoreOuterClass$ByteStringStore$Builder.setData(ByteString.EMPTY);
        ByteStringStoreOuterClass$ByteStringStore$Builder.build();
        return ByteStringStoreOuterClass$ByteStringStore$Builder.build(..);
    }

    public Object migrate(Object p0, Continuation p1) {
        FetchGLInfoDataMigration.migrate(p0, p1);
        return FetchGLInfoDataMigration.migrate(..);
    }

    public Object shouldMigrate(ByteStringStoreOuterClass$ByteStringStore p0, Continuation p1) {
        p0.getData();
        ByteString.isEmpty();
        Boxing.boxBoolean(ByteString.isEmpty(..));
        return Boxing.boxBoolean(..);
    }

    public Object shouldMigrate(Object p0, Continuation p1) {
        FetchGLInfoDataMigration.shouldMigrate(p0, p1);
        return FetchGLInfoDataMigration.shouldMigrate(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.ForcefulPreservingByteStringPreferenceMigration
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class ForcefulPreservingByteStringPreferenceMigration {
    private final Context context;
    private final GetByteStringData getByteStringData;
    private final String key;
    private final String name;

    public ForcefulPreservingByteStringPreferenceMigration(Context p0, String p1, String p2, GetByteStringData p3) {
        new Object();
        context = p0;
        name = p1;
        key = p2;
        getByteStringData = p3;
        return;
    }

    public Object cleanUp(Continuation p0) {
        return Unit.INSTANCE;
    }

    public Object migrate(ByteStringStoreOuterClass$ByteStringStore p0, Continuation p1) {
        context.getSharedPreferences(name, 0);
        Context.getSharedPreferences(..).getString(key, 0);
        if (if-eqz(SharedPreferences.getString(..))) goto L_1b;
        SharedPreferences.getString(..).length();
        if (if-nez(CharSequence.length(..))) goto L_1c;
      L_1b:
      L_1c:
        if (if-nez(1)) goto L_35;
        ByteStringStoreOuterClass$ByteStringStore.newBuilder();
        getByteStringData.invoke(SharedPreferences.getString(..));
        ByteStringStoreOuterClass$ByteStringStore$Builder.setData(GetByteStringData.invoke(..));
        ByteStringStoreOuterClass$ByteStringStore$Builder.build();
      L_35:
        return ByteStringStoreOuterClass$ByteStringStore$Builder.build(..);
    }

    public Object migrate(Object p0, Continuation p1) {
        ForcefulPreservingByteStringPreferenceMigration.migrate(p0, p1);
        return ForcefulPreservingByteStringPreferenceMigration.migrate(..);
    }

    public Object shouldMigrate(ByteStringStoreOuterClass$ByteStringStore p0, Continuation p1) {
        Boxing.boxBoolean(1);
        return Boxing.boxBoolean(..);
    }

    public Object shouldMigrate(Object p0, Continuation p1) {
        ForcefulPreservingByteStringPreferenceMigration.shouldMigrate(p0, p1);
        return ForcefulPreservingByteStringPreferenceMigration.shouldMigrate(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.GetByteStringData
// ============================================================
package com.unity3d.ads.core.data.datasource;

public abstract class GetByteStringData {
    public abstract ByteString invoke(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.LegacyUserConsentDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public abstract class LegacyUserConsentDataSource {
    public abstract String getPrivacyData() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.LifecycleDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public abstract class LifecycleDataSource {
    public abstract boolean appIsForeground() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.MediationDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public abstract class MediationDataSource {
    public abstract String getName() {
        // native or abstract
    }

    public abstract String getVersion() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.PreservingByteStringPreferenceMigration
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class PreservingByteStringPreferenceMigration {
    private final Context context;
    private final GetByteStringData getByteStringData;
    private final String key;
    private final String name;

    public PreservingByteStringPreferenceMigration(Context p0, String p1, String p2, GetByteStringData p3) {
        new Object();
        context = p0;
        name = p1;
        key = p2;
        getByteStringData = p3;
        return;
    }

    public Object cleanUp(Continuation p0) {
        return Unit.INSTANCE;
    }

    public Object migrate(ByteStringStoreOuterClass$ByteStringStore p0, Continuation p1) {
        p0.getData();
        ByteString.isEmpty();
        if (if-eqz(ByteString.isEmpty(..))) goto L_3f;
        context.getSharedPreferences(name, 0);
        Context.getSharedPreferences(..).getString(key, 0);
        if (if-eqz(SharedPreferences.getString(..))) goto L_25;
        SharedPreferences.getString(..).length();
        if (if-nez(CharSequence.length(..))) goto L_26;
      L_25:
      L_26:
        if (if-nez(1)) goto L_3f;
        ByteStringStoreOuterClass$ByteStringStore.newBuilder();
        getByteStringData.invoke(SharedPreferences.getString(..));
        ByteStringStoreOuterClass$ByteStringStore$Builder.setData(GetByteStringData.invoke(..));
        ByteStringStoreOuterClass$ByteStringStore$Builder.build();
      L_3f:
        return ByteStringStoreOuterClass$ByteStringStore$Builder.build(..);
    }

    public Object migrate(Object p0, Continuation p1) {
        PreservingByteStringPreferenceMigration.migrate(p0, p1);
        return PreservingByteStringPreferenceMigration.migrate(..);
    }

    public Object shouldMigrate(ByteStringStoreOuterClass$ByteStringStore p0, Continuation p1) {
        p0.getData();
        ByteString.isEmpty();
        Boxing.boxBoolean(ByteString.isEmpty(..));
        return Boxing.boxBoolean(..);
    }

    public Object shouldMigrate(Object p0, Continuation p1) {
        PreservingByteStringPreferenceMigration.shouldMigrate(p0, p1);
        return PreservingByteStringPreferenceMigration.shouldMigrate(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.PrivacyDeviceInfoDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public abstract class PrivacyDeviceInfoDataSource {
    public abstract PiiOuterClass$Pii fetch(AllowedPiiOuterClass$AllowedPii p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.StaticDeviceInfoDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public abstract class StaticDeviceInfoDataSource {
    public abstract Object fetch(List p0, Continuation p1) {
        // native or abstract
    }

    public abstract StaticDeviceInfoOuterClass$StaticDeviceInfo fetchCached() {
        // native or abstract
    }

    public abstract String getAnalyticsUserId() {
        // native or abstract
    }

    public abstract String getAppName() {
        // native or abstract
    }

    public abstract Object getAuid(Continuation p0) {
        // native or abstract
    }

    public abstract Object getIdfi(Continuation p0) {
        // native or abstract
    }

    public abstract String getManufacturer() {
        // native or abstract
    }

    public abstract String getModel() {
        // native or abstract
    }

    public abstract String getOsVersion() {
        // native or abstract
    }

    public abstract long getSystemBootTime() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.StoreDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public abstract class StoreDataSource {
    public abstract List fetchStores(List p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.TcfDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public abstract class TcfDataSource {
    public abstract String getTcfString() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.UniversalRequestDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class UniversalRequestDataSource {
    private final DataStore universalRequestStore;

    public UniversalRequestDataSource(DataStore p0) {
        new Object();
        universalRequestStore = p0;
        return;
    }

    public final Object get(Continuation p0) {
        universalRequestStore.getData();
        new UniversalRequestDataSource$get$2(0);
        FlowKt.catch(DataStore.getData(..), new UniversalRequestDataSource$get$2(..));
        FlowKt.first(FlowKt.catch(..), p0);
        return FlowKt.first(..);
    }

    public final Object remove(String p0, Continuation p1) {
        new UniversalRequestDataSource$remove$2(p0, 0);
        universalRequestStore.updateData(new UniversalRequestDataSource$remove$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(DataStore.updateData(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_15;
        return DataStore.updateData(..);
      L_15:
        return Unit.INSTANCE;
    }

    public final Object set(String p0, ByteString p1, Continuation p2) {
        new UniversalRequestDataSource$set$2(p0, p1, 0);
        universalRequestStore.updateData(new UniversalRequestDataSource$set$2(..), p2);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(DataStore.updateData(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_15;
        return DataStore.updateData(..);
      L_15:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.VolumeSettingsChange
// ============================================================
package com.unity3d.ads.core.data.datasource;

public abstract class VolumeSettingsChange {
    private VolumeSettingsChange() {
        new Object();
        return;
    }

    public VolumeSettingsChange(DefaultConstructorMarker p0) {
        new VolumeSettingsChange();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.WebviewConfigurationDataSource
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class WebviewConfigurationDataSource {
    private final DataStore webviewConfigurationStore;

    public WebviewConfigurationDataSource(DataStore p0) {
        new Object();
        webviewConfigurationStore = p0;
        return;
    }

    public final Object get(Continuation p0) {
        webviewConfigurationStore.getData();
        new WebviewConfigurationDataSource$get$2(0);
        FlowKt.catch(DataStore.getData(..), new WebviewConfigurationDataSource$get$2(..));
        FlowKt.first(FlowKt.catch(..), p0);
        return FlowKt.first(..);
    }

    public final Object set(WebviewConfigurationStore$WebViewConfigurationStore p0, Continuation p1) {
        new WebviewConfigurationDataSource$set$2(p0, 0);
        webviewConfigurationStore.updateData(new WebviewConfigurationDataSource$set$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(DataStore.updateData(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_15;
        return DataStore.updateData(..);
      L_15:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidByteStringDataSource$get$2
// ============================================================
package com.unity3d.ads.core.data.datasource;

final class AndroidByteStringDataSource$get$2 extends SuspendLambda {
    private Object L$0;
    Object L$1;
    int label;

    AndroidByteStringDataSource$get$2(Continuation p0) {
        new SuspendLambda(3, p0);
        return;
    }

    public Object invoke(Object p0, Object p1, Object p2) {
        AndroidByteStringDataSource$get$2.invoke(p0, p1, p2);
        return AndroidByteStringDataSource$get$2.invoke(..);
    }

    public final Object invoke(FlowCollector p0, Throwable p1, Continuation p2) {
        new AndroidByteStringDataSource$get$2(p2);
        L$0 = p0;
        L$1 = p1;
        AndroidByteStringDataSource$get$2.invokeSuspend(Unit.INSTANCE);
        return AndroidByteStringDataSource$get$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        if (if-eqz(v3)) goto L_55;
        ByteStringStoreOuterClass$ByteStringStore.newBuilder();
        ByteStringStoreKt$Dsl.Companion._create(ByteStringStoreOuterClass$ByteStringStore.newBuilder(..));
        ByteStringStoreKt$Dsl.setData(ByteString.EMPTY);
        ByteStringStoreKt$Dsl._build();
        L$0 = 0;
        label = 1;
        L$0.emit(ByteStringStoreKt$Dsl._build(..), this);
        if (if-ne(FlowCollector.emit(..), "call to 'resume' before 'invoke' with coroutine")) goto L_52;
        return "call to 'resume' before 'invoke' with coroutine";
      L_52:
        return Unit.INSTANCE;
      L_55:
        throw ByteStringStoreKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidByteStringDataSource$set$2
// ============================================================
package com.unity3d.ads.core.data.datasource;

final class AndroidByteStringDataSource$set$2 extends SuspendLambda {
    final ByteString $data;
    Object L$0;
    int label;

    AndroidByteStringDataSource$set$2(ByteString p0, Continuation p1) {
        $data = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidByteStringDataSource$set$2($data, p1);
        L$0 = p0;
        return new AndroidByteStringDataSource$set$2(..);
    }

    public final Object invoke(ByteStringStoreOuterClass$ByteStringStore p0, Continuation p1) {
        AndroidByteStringDataSource$set$2.create(p0, p1);
        AndroidByteStringDataSource$set$2.invokeSuspend(Unit.INSTANCE);
        return AndroidByteStringDataSource$set$2.invokeSuspend(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidByteStringDataSource$set$2.invoke(p0, p1);
        return AndroidByteStringDataSource$set$2.invoke(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_24;
        ResultKt.throwOnFailure(p0);
        L$0.toBuilder();
        ByteStringStoreOuterClass$ByteStringStore$Builder.setData($data);
        ByteStringStoreOuterClass$ByteStringStore$Builder.build();
        return ByteStringStoreOuterClass$ByteStringStore$Builder.build(..);
      L_24:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource$Companion
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidDynamicDeviceInfoDataSource$Companion {
    private AndroidDynamicDeviceInfoDataSource$Companion() {
        new Object();
        return;
    }

    public AndroidDynamicDeviceInfoDataSource$Companion(DefaultConstructorMarker p0) {
        new AndroidDynamicDeviceInfoDataSource$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1
// ============================================================
package com.unity3d.ads.core.data.datasource;

final class AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1 extends SuspendLambda {
    private Object L$0;
    int label;
    final AndroidDynamicDeviceInfoDataSource this$0;

    AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1(AndroidDynamicDeviceInfoDataSource p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1(this$0, p1);
        L$0 = p0;
        return new AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1.invoke(p0, p1);
        return AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1.invoke(..);
    }

    public final Object invoke(ProducerScope p0, Continuation p1) {
        AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1.create(p0, p1);
        AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1.invokeSuspend(Unit.INSTANCE);
        return AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        new Ref$DoubleRef();
        AndroidDynamicDeviceInfoDataSource.access$getStreamVolume(this$0, 3);
        element = AndroidDynamicDeviceInfoDataSource.access$getStreamVolume(..);
        new VolumeSettingsChange$VolumeChange(element, v6);
        ChannelsKt.trySendBlocking(L$0, new VolumeSettingsChange$VolumeChange(..));
        new Ref$IntRef();
        this$0.getRingerMode();
        element = AndroidDynamicDeviceInfoDataSource.getRingerMode(..);
        if (if-nez(element)) goto L_4e;
      L_4e:
      L_4f:
        new VolumeSettingsChange$MuteChange(0);
        ChannelsKt.trySendBlocking(L$0, new VolumeSettingsChange$MuteChange(..));
        new AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1(this$0, new Ref$DoubleRef(..), L$0, new Ref$IntRef(..));
        this$0.getContext();
        Context.getContentResolver();
        Context.getContentResolver(..).registerContentObserver(Settings$System.CONTENT_URI, 1, new AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1(..));
        new AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$1(this$0, new AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1(..));
        label = 1;
        ProduceKt.awaitClose(L$0, new AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$1(..), this);
        if (if-ne(ProduceKt.awaitClose(..), "call to 'resume' before 'invoke' with coroutine")) goto L_83;
        return "call to 'resume' before 'invoke' with coroutine";
      L_83:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$1
// ============================================================
package com.unity3d.ads.core.data.datasource;

final class AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$1 extends Lambda {
    final AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1 $contentObserver;
    final AndroidDynamicDeviceInfoDataSource this$0;

    AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$1(AndroidDynamicDeviceInfoDataSource p0, AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1 p1) {
        this$0 = p0;
        $contentObserver = p1;
        new Lambda(0);
        return;
    }

    public Object invoke() {
        AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$1.invoke();
        return Unit.INSTANCE;
    }

    public final void invoke() {
        this$0.getContext();
        Context.getContentResolver();
        Context.getContentResolver(..).unregisterContentObserver($contentObserver);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1 extends ContentObserver {
    final ProducerScope $$this$callbackFlow;
    final Ref$IntRef $currentRingerMode;
    final Ref$DoubleRef $currentVolume;
    final AndroidDynamicDeviceInfoDataSource this$0;

    AndroidDynamicDeviceInfoDataSource$volumeSettingsChange$1$contentObserver$1(AndroidDynamicDeviceInfoDataSource p0, Ref$DoubleRef p1, ProducerScope p2, Ref$IntRef p3) {
        this$0 = p0;
        $currentVolume = p1;
        $$this$callbackFlow = p2;
        $currentRingerMode = p3;
        new ContentObserver(0);
        return;
    }

    public void onChange(boolean p0) {
        ContentObserver.onChange(p0);
        AndroidDynamicDeviceInfoDataSource.access$getStreamVolume(this$0, 3);
        if (if-nez($currentVolume)) goto L_16;
      L_16:
      L_17:
        if (if-nez(0)) goto L_29;
        element = AndroidDynamicDeviceInfoDataSource.access$getStreamVolume(..);
        new VolumeSettingsChange$VolumeChange(AndroidDynamicDeviceInfoDataSource.access$getStreamVolume(..), v1);
        ChannelsKt.trySendBlocking($$this$callbackFlow, new VolumeSettingsChange$VolumeChange(..));
      L_29:
        this$0.getRingerMode();
        if (if-eq(AndroidDynamicDeviceInfoDataSource.getRingerMode(..), element)) goto L_49;
        element = AndroidDynamicDeviceInfoDataSource.getRingerMode(..);
        if (if-nez(AndroidDynamicDeviceInfoDataSource.getRingerMode(..))) goto L_42;
      L_42:
      L_43:
        new VolumeSettingsChange$MuteChange(0);
        ChannelsKt.trySendBlocking($$this$callbackFlow, new VolumeSettingsChange$MuteChange(..));
      L_49:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidLegacyConfigStoreDataSource$Companion
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidLegacyConfigStoreDataSource$Companion {
    private AndroidLegacyConfigStoreDataSource$Companion() {
        new Object();
        return;
    }

    public AndroidLegacyConfigStoreDataSource$Companion(DefaultConstructorMarker p0) {
        new AndroidLegacyConfigStoreDataSource$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidLifecycleDataSource$registerAppLifecycle$1
// ============================================================
package com.unity3d.ads.core.data.datasource;

final class AndroidLifecycleDataSource$registerAppLifecycle$1 extends SuspendLambda {
    int label;
    final AndroidLifecycleDataSource this$0;

    AndroidLifecycleDataSource$registerAppLifecycle$1(AndroidLifecycleDataSource p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidLifecycleDataSource$registerAppLifecycle$1(this$0, p1);
        return new AndroidLifecycleDataSource$registerAppLifecycle$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidLifecycleDataSource$registerAppLifecycle$1.invoke(p0, p1);
        return AndroidLifecycleDataSource$registerAppLifecycle$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidLifecycleDataSource$registerAppLifecycle$1.create(p0, p1);
        AndroidLifecycleDataSource$registerAppLifecycle$1.invokeSuspend(Unit.INSTANCE);
        return AndroidLifecycleDataSource$registerAppLifecycle$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_1e;
        ResultKt.throwOnFailure(p0);
        ProcessLifecycleOwner.Companion.get();
        LifecycleOwner.getLifecycle();
        LifecycleOwner.getLifecycle(..).addObserver(this$0);
        return Unit.INSTANCE;
      L_1e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidMediationDataSource$Companion
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidMediationDataSource$Companion {
    private AndroidMediationDataSource$Companion() {
        new Object();
        return;
    }

    public AndroidMediationDataSource$Companion(DefaultConstructorMarker p0) {
        new AndroidMediationDataSource$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidRemoteCacheDataSource$getFile$1
// ============================================================
package com.unity3d.ads.core.data.datasource;

final class AndroidRemoteCacheDataSource$getFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    Object result;
    final AndroidRemoteCacheDataSource this$0;

    AndroidRemoteCacheDataSource$getFile$1(AndroidRemoteCacheDataSource p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.getFile(0, 0, 0, 0, this);
        return AndroidRemoteCacheDataSource.getFile(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$Companion
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidStaticDeviceInfoDataSource$Companion {
    private AndroidStaticDeviceInfoDataSource$Companion() {
        new Object();
        return;
    }

    public AndroidStaticDeviceInfoDataSource$Companion(DefaultConstructorMarker p0) {
        new AndroidStaticDeviceInfoDataSource$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$fetch$1
// ============================================================
package com.unity3d.ads.core.data.datasource;

final class AndroidStaticDeviceInfoDataSource$fetch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final AndroidStaticDeviceInfoDataSource this$0;

    AndroidStaticDeviceInfoDataSource$fetch$1(AndroidStaticDeviceInfoDataSource p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.fetch(0, this);
        return AndroidStaticDeviceInfoDataSource.fetch(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource$getGPUModel$1
// ============================================================
package com.unity3d.ads.core.data.datasource;

final class AndroidStaticDeviceInfoDataSource$getGPUModel$1 extends ContinuationImpl {
    int label;
    Object result;
    final AndroidStaticDeviceInfoDataSource this$0;

    AndroidStaticDeviceInfoDataSource$getGPUModel$1(AndroidStaticDeviceInfoDataSource p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        AndroidStaticDeviceInfoDataSource.access$getGPUModel(this$0, this);
        return AndroidStaticDeviceInfoDataSource.access$getGPUModel(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.AndroidTcfDataSource$Companion
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class AndroidTcfDataSource$Companion {
    private AndroidTcfDataSource$Companion() {
        new Object();
        return;
    }

    public AndroidTcfDataSource$Companion(DefaultConstructorMarker p0) {
        new AndroidTcfDataSource$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.CacheDataSource$DefaultImpls
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class CacheDataSource$DefaultImpls {
    public static Object getFile$default(CacheDataSource p0, File p1, String p2, String p3, Integer p4, Continuation p5, int p6, Object p7) {
        if (if-nez(p7)) goto L_1d;
        if (if-eqz(p7)) goto L_7;
      L_7:
        if (if-eqz(0)) goto L_13;
        Integer.valueOf(0x7FFFFFFF);
      L_13:
        p0.getFile(p1, p2, 0, Integer.valueOf(..), p5);
        return CacheDataSource.getFile(..);
      L_1d:
        new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFile");
        throw new UnsupportedOperationException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.PrivacyDeviceInfoDataSource$DefaultImpls
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class PrivacyDeviceInfoDataSource$DefaultImpls {
    public static PiiOuterClass$Pii fetch$default(PrivacyDeviceInfoDataSource p0, AllowedPiiOuterClass$AllowedPii p1, int p2, Object p3) {
        if (if-nez(p3)) goto L_14;
        if (if-eqz(p2)) goto L_f;
        AllowedPiiOuterClass$AllowedPii.getDefaultInstance();
      L_f:
        p0.fetch(AllowedPiiOuterClass$AllowedPii.getDefaultInstance(..));
        return PrivacyDeviceInfoDataSource.fetch(..);
      L_14:
        new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetch");
        throw new UnsupportedOperationException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$get$2
// ============================================================
package com.unity3d.ads.core.data.datasource;

final class UniversalRequestDataSource$get$2 extends SuspendLambda {
    private Object L$0;
    Object L$1;
    int label;

    UniversalRequestDataSource$get$2(Continuation p0) {
        new SuspendLambda(3, p0);
        return;
    }

    public Object invoke(Object p0, Object p1, Object p2) {
        UniversalRequestDataSource$get$2.invoke(p0, p1, p2);
        return UniversalRequestDataSource$get$2.invoke(..);
    }

    public final Object invoke(FlowCollector p0, Throwable p1, Continuation p2) {
        new UniversalRequestDataSource$get$2(p2);
        L$0 = p0;
        L$1 = p1;
        UniversalRequestDataSource$get$2.invokeSuspend(Unit.INSTANCE);
        return UniversalRequestDataSource$get$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        if (if-eqz(v3)) goto L_41;
        UniversalRequestStoreOuterClass$UniversalRequestStore.getDefaultInstance();
        L$0 = 0;
        label = 1;
        L$0.emit(UniversalRequestStoreOuterClass$UniversalRequestStore.getDefaultInstance(..), this);
        if (if-ne(FlowCollector.emit(..), "call to 'resume' before 'invoke' with coroutine")) goto L_3e;
        return "call to 'resume' before 'invoke' with coroutine";
      L_3e:
        return Unit.INSTANCE;
      L_41:
        throw UniversalRequestStoreOuterClass$UniversalRequestStore.getDefaultInstance(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$remove$2
// ============================================================
package com.unity3d.ads.core.data.datasource;

final class UniversalRequestDataSource$remove$2 extends SuspendLambda {
    final String $key;
    Object L$0;
    int label;

    UniversalRequestDataSource$remove$2(String p0, Continuation p1) {
        $key = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new UniversalRequestDataSource$remove$2($key, p1);
        L$0 = p0;
        return new UniversalRequestDataSource$remove$2(..);
    }

    public final Object invoke(UniversalRequestStoreOuterClass$UniversalRequestStore p0, Continuation p1) {
        UniversalRequestDataSource$remove$2.create(p0, p1);
        UniversalRequestDataSource$remove$2.invokeSuspend(Unit.INSTANCE);
        return UniversalRequestDataSource$remove$2.invokeSuspend(..);
    }

    public Object invoke(Object p0, Object p1) {
        UniversalRequestDataSource$remove$2.invoke(p0, p1);
        return UniversalRequestDataSource$remove$2.invoke(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_23;
        ResultKt.throwOnFailure(p0);
        L$0.toBuilder();
        UniversalRequestStoreOuterClass$UniversalRequestStore$Builder.removeUniversalRequestMap($key);
        UniversalRequestStoreOuterClass$UniversalRequestStore$Builder.build();
        return UniversalRequestStoreOuterClass$UniversalRequestStore$Builder.build(..);
      L_23:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$set$2
// ============================================================
package com.unity3d.ads.core.data.datasource;

final class UniversalRequestDataSource$set$2 extends SuspendLambda {
    final ByteString $data;
    final String $key;
    Object L$0;
    int label;

    UniversalRequestDataSource$set$2(String p0, ByteString p1, Continuation p2) {
        $key = p0;
        $data = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new UniversalRequestDataSource$set$2($key, $data, p1);
        L$0 = p0;
        return new UniversalRequestDataSource$set$2(..);
    }

    public final Object invoke(UniversalRequestStoreOuterClass$UniversalRequestStore p0, Continuation p1) {
        UniversalRequestDataSource$set$2.create(p0, p1);
        UniversalRequestDataSource$set$2.invokeSuspend(Unit.INSTANCE);
        return UniversalRequestDataSource$set$2.invokeSuspend(..);
    }

    public Object invoke(Object p0, Object p1) {
        UniversalRequestDataSource$set$2.invoke(p0, p1);
        return UniversalRequestDataSource$set$2.invoke(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_25;
        ResultKt.throwOnFailure(p0);
        L$0.toBuilder();
        UniversalRequestStoreOuterClass$UniversalRequestStore$Builder.putUniversalRequestMap($key, $data);
        UniversalRequestStoreOuterClass$UniversalRequestStore$Builder.build();
        return UniversalRequestStoreOuterClass$UniversalRequestStore$Builder.build(..);
      L_25:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.VolumeSettingsChange$MuteChange
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class VolumeSettingsChange$MuteChange extends VolumeSettingsChange {
    private final boolean isMuted;

    public VolumeSettingsChange$MuteChange(boolean p0) {
        new VolumeSettingsChange(0);
        isMuted = p0;
        return;
    }

    public static VolumeSettingsChange$MuteChange copy$default(VolumeSettingsChange$MuteChange p0, boolean p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        p0.copy(isMuted);
        return VolumeSettingsChange$MuteChange.copy(..);
    }

    public final boolean component1() {
        return isMuted;
    }

    public final VolumeSettingsChange$MuteChange copy(boolean p0) {
        new VolumeSettingsChange$MuteChange(p0);
        return new VolumeSettingsChange$MuteChange(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        if (if-eq(isMuted, isMuted)) goto L_13;
        return 0;
      L_13:
        return 1;
    }

    public int hashCode() {
        if (if-eqz(isMuted)) goto L_5;
      L_5:
        return 1;
    }

    public final boolean isMuted() {
        return isMuted;
    }

    public String toString() {
        new StringBuilder("MuteChange(isMuted=");
        new StringBuilder(..).append(isMuted);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.VolumeSettingsChange$VolumeChange
// ============================================================
package com.unity3d.ads.core.data.datasource;

public final class VolumeSettingsChange$VolumeChange extends VolumeSettingsChange {
    private final double volume;

    public VolumeSettingsChange$VolumeChange(double p0) {
        new VolumeSettingsChange(0);
        volume = p0;
        return;
    }

    public static VolumeSettingsChange$VolumeChange copy$default(VolumeSettingsChange$VolumeChange p0, double p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        p0.copy(volume, v2);
        return VolumeSettingsChange$VolumeChange.copy(..);
    }

    public final double component1() {
        return volume;
    }

    public final VolumeSettingsChange$VolumeChange copy(double p0) {
        new VolumeSettingsChange$VolumeChange(p0, v3);
        return new VolumeSettingsChange$VolumeChange(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Double.compare(volume, v4, volume, v6);
        if (if-eqz(Double.compare(..))) goto L_17;
        return 0;
      L_17:
        return 1;
    }

    public final double getVolume() {
        return volume;
    }

    public int hashCode() {
        UByte$$ExternalSyntheticBackport0.m(volume, v1);
        return UByte$$ExternalSyntheticBackport0.m(..);
    }

    public String toString() {
        new StringBuilder("VolumeChange(volume=");
        new StringBuilder(..).append(volume, v2);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.WebviewConfigurationDataSource$get$2
// ============================================================
package com.unity3d.ads.core.data.datasource;

final class WebviewConfigurationDataSource$get$2 extends SuspendLambda {
    private Object L$0;
    Object L$1;
    int label;

    WebviewConfigurationDataSource$get$2(Continuation p0) {
        new SuspendLambda(3, p0);
        return;
    }

    public Object invoke(Object p0, Object p1, Object p2) {
        WebviewConfigurationDataSource$get$2.invoke(p0, p1, p2);
        return WebviewConfigurationDataSource$get$2.invoke(..);
    }

    public final Object invoke(FlowCollector p0, Throwable p1, Continuation p2) {
        new WebviewConfigurationDataSource$get$2(p2);
        L$0 = p0;
        L$1 = p1;
        WebviewConfigurationDataSource$get$2.invokeSuspend(Unit.INSTANCE);
        return WebviewConfigurationDataSource$get$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        if (if-eqz(v3)) goto L_41;
        WebviewConfigurationStore$WebViewConfigurationStore.getDefaultInstance();
        L$0 = 0;
        label = 1;
        L$0.emit(WebviewConfigurationStore$WebViewConfigurationStore.getDefaultInstance(..), this);
        if (if-ne(FlowCollector.emit(..), "call to 'resume' before 'invoke' with coroutine")) goto L_3e;
        return "call to 'resume' before 'invoke' with coroutine";
      L_3e:
        return Unit.INSTANCE;
      L_41:
        throw WebviewConfigurationStore$WebViewConfigurationStore.getDefaultInstance(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.datasource.WebviewConfigurationDataSource$set$2
// ============================================================
package com.unity3d.ads.core.data.datasource;

final class WebviewConfigurationDataSource$set$2 extends SuspendLambda {
    final WebviewConfigurationStore$WebViewConfigurationStore $data;
    int label;

    WebviewConfigurationDataSource$set$2(WebviewConfigurationStore$WebViewConfigurationStore p0, Continuation p1) {
        $data = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new WebviewConfigurationDataSource$set$2($data, p1);
        return new WebviewConfigurationDataSource$set$2(..);
    }

    public final Object invoke(WebviewConfigurationStore$WebViewConfigurationStore p0, Continuation p1) {
        WebviewConfigurationDataSource$set$2.create(p0, p1);
        WebviewConfigurationDataSource$set$2.invokeSuspend(Unit.INSTANCE);
        return WebviewConfigurationDataSource$set$2.invokeSuspend(..);
    }

    public Object invoke(Object p0, Object p1) {
        WebviewConfigurationDataSource$set$2.invoke(p0, p1);
        return WebviewConfigurationDataSource$set$2.invoke(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_d;
        ResultKt.throwOnFailure(p0);
        return $data;
      L_d:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}

