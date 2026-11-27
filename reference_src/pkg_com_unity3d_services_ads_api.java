// Package bundle: com.unity3d.services.ads.api (28 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.api.AdUnit
// ============================================================
package com.unity3d.services.ads.api;

public class AdUnit {
    private static IAdUnitActivity _adUnitActivity = null;
    private static int _currentActivityId = 0xFFFFFFFF;

    static <clinit>() {
        return;
    }

    private AdUnit() {
        new Object();
        return;
    }

    static String[] access$000(JSONArray p0) {
        AdUnit.getViewList(p0);
        return AdUnit.getViewList(..);
    }

    public static void clearMotionEventCapture(WebViewCallback p0) {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_2a;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        if (if-eqz(IAdUnitActivity.getLayout(..))) goto L_22;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        IAdUnitActivity.getLayout(..).clearCapture();
        p0.invoke(IAdUnitActivity.getLayout(..));
      L_22:
        p0.error(AdUnitError.LAYOUT_NULL, 0);
      L_2a:
        p0.error(AdUnitError.ADUNIT_NULL, 0);
      L_31:
        return;
    }

    public static void close(WebViewCallback p0) {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_14;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).finish();
        p0.invoke(AdUnit.getAdUnitActivity(..));
      L_14:
        p0.error(AdUnitError.ADUNIT_NULL, 0);
      L_1b:
        return;
    }

    public static void endMotionEventCapture(WebViewCallback p0) {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_2a;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        if (if-eqz(IAdUnitActivity.getLayout(..))) goto L_22;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        IAdUnitActivity.getLayout(..).endCapture();
        p0.invoke(IAdUnitActivity.getLayout(..));
      L_22:
        p0.error(AdUnitError.LAYOUT_NULL, 0);
      L_2a:
        p0.error(AdUnitError.ADUNIT_NULL, 0);
      L_31:
        return;
    }

    public static IAdUnitActivity getAdUnitActivity() {
        return AdUnit._adUnitActivity;
    }

    public static int getCurrentAdUnitActivityId() {
        return AdUnit._currentActivityId;
    }

    public static void getCurrentMotionEventCount(WebViewCallback p0) {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_32;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        if (if-eqz(IAdUnitActivity.getLayout(..))) goto L_2a;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        IAdUnitActivity.getLayout(..).getCurrentEventCount();
        Integer.valueOf(AdUnitRelativeLayout.getCurrentEventCount(..));
        p0.invoke(1);
      L_2a:
        p0.error(AdUnitError.LAYOUT_NULL, 0);
      L_32:
        p0.error(AdUnitError.ADUNIT_NULL, 0);
      L_39:
        return;
    }

    private static ArrayList getKeyEventList(JSONArray p0) {
        new ArrayList();
      L_6:
        Integer.valueOf(0);
        Integer.valueOf(..).intValue();
        p0.length();
        if (if-ge(Integer.intValue(..), JSONArray.length(..))) goto L_2a;
        Integer.valueOf(..).intValue();
        p0.getInt(Integer.intValue(..));
        Integer.valueOf(JSONArray.getInt(..));
        new ArrayList(..).add(Integer.valueOf(..));
        Integer.valueOf(..).intValue();
      L_2a:
        return new ArrayList(..);
    }

    public static void getMotionEventCount(JSONArray p0, WebViewCallback p1) {
        new ArrayList();
      L_7:
        p0.length();
        if (if-ge(0, JSONArray.length(..))) goto L_22;
        p0.getInt(0);
        Integer.valueOf(JSONArray.getInt(..));
        new ArrayList(..).add(Integer.valueOf(..));
        DeviceLog.exception("Error retrieving int from eventTypes", Integer.valueOf(..));
      L_1f:
      L_22:
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_96;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        if (if-eqz(IAdUnitActivity.getLayout(..))) goto L_8e;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        IAdUnitActivity.getLayout(..).getCurrentEventCount();
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        IAdUnitActivity.getLayout(..).getMaxEventCount();
        if (if-lt(AdUnitRelativeLayout.getCurrentEventCount(..), AdUnitRelativeLayout.getMaxEventCount(..))) goto L_54;
        p1.error(AdUnitError.MAX_MOTION_EVENT_COUNT_REACHED, new ArrayList(..));
        return;
      L_54:
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        IAdUnitActivity.getLayout(..).getEventCount(new ArrayList(..));
        new JSONObject();
      L_66:
        SparseIntArray.size();
        if (if-ge(0, SparseIntArray.size(..))) goto L_85;
        SparseIntArray.keyAt(0);
        SparseIntArray.get(SparseIntArray.keyAt(..));
        Integer.toString(SparseIntArray.keyAt(..));
        new JSONObject(..).put(Integer.toString(..), SparseIntArray.get(..));
        DeviceLog.exception("Error building response JSON", Integer.toString(..));
      L_82:
      L_85:
        p1.invoke(1);
      L_8e:
        p1.error(AdUnitError.LAYOUT_NULL, new JSONObject(..));
      L_96:
        p1.error(AdUnitError.ADUNIT_NULL, new JSONObject(..));
      L_9d:
        return;
    }

    public static void getMotionEventData(JSONObject p0, WebViewCallback p1) {
        p0.keys();
        new SparseArray();
      L_9:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_57;
        JSONObject.keys(..).next();
        Integer.parseInt(Iterator.next(..));
        new SparseArray(..).get(Integer.parseInt(..));
        if (if-nez(SparseArray.get(..))) goto L_28;
        new ArrayList();
        new SparseArray(..).put(Integer.parseInt(..), new ArrayList(..));
      L_28:
        p0.getJSONArray(Iterator.next(..));
        DeviceLog.exception("Couldn't fetch keyIndices", JSONObject.getJSONArray(..));
      L_34:
        if (if-eqz(0)) goto L_9;
      L_36:
        0.length();
        if (if-ge(0, JSONArray.length(..))) goto L_9;
        new SparseArray(..).get(Integer.parseInt(..));
        0.getInt(0);
        Integer.valueOf(JSONArray.getInt(..));
        SparseArray.get(..).add(Integer.valueOf(..));
        DeviceLog.exception("Couldn't add value to requested infos", SparseArray.get(..));
      L_54:
      L_57:
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_161;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        if (if-eqz(IAdUnitActivity.getLayout(..))) goto L_159;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        IAdUnitActivity.getLayout(..).getCurrentEventCount();
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        IAdUnitActivity.getLayout(..).getMaxEventCount();
        if (if-lt(AdUnitRelativeLayout.getCurrentEventCount(..), AdUnitRelativeLayout.getMaxEventCount(..))) goto L_89;
        p1.error(AdUnitError.MAX_MOTION_EVENT_COUNT_REACHED, AdUnitRelativeLayout.getMaxEventCount(..));
        return;
      L_89:
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        IAdUnitActivity.getLayout(..).getEvents(new SparseArray(..));
        new JSONObject();
      L_9b:
        AdUnitRelativeLayout.getEvents(..).size();
        if (if-ge(0, SparseArray.size(..))) goto L_151;
        AdUnitRelativeLayout.getEvents(..).keyAt(0);
        AdUnitRelativeLayout.getEvents(..).get(SparseArray.keyAt(..));
        new JSONObject();
      L_b2:
        SparseArray.get(..).size();
        if (if-ge(0, SparseArray.size(..))) goto L_13b;
        new JSONObject();
        SparseArray.get(..).keyAt(0);
        SparseArray.get(..).get(SparseArray.keyAt(..));
        SparseArray.get(..).getAction();
        new JSONObject(..).put("action", AdUnitMotionEvent.getAction(..));
        SparseArray.get(..).isObscured();
        new JSONObject(..).put("isObscured", AdUnitMotionEvent.isObscured(..));
        SparseArray.get(..).getToolType();
        new JSONObject(..).put("toolType", AdUnitMotionEvent.getToolType(..));
        SparseArray.get(..).getSource();
        new JSONObject(..).put("source", AdUnitMotionEvent.getSource(..));
        SparseArray.get(..).getDeviceId();
        new JSONObject(..).put("deviceId", AdUnitMotionEvent.getDeviceId(..));
        SparseArray.get(..).getX();
        new JSONObject(..).put("x", AdUnitMotionEvent.getX(..), v13);
        SparseArray.get(..).getY();
        new JSONObject(..).put("y", AdUnitMotionEvent.getY(..), v13);
        SparseArray.get(..).getEventTime();
        new JSONObject(..).put("eventTime", AdUnitMotionEvent.getEventTime(..), v13);
        SparseArray.get(..).getPressure();
        new JSONObject(..).put("pressure", AdUnitMotionEvent.getPressure(..), v13);
        SparseArray.get(..).getSize();
        new JSONObject(..).put("size", AdUnitMotionEvent.getPressure(..), v13);
        Integer.toString(SparseArray.keyAt(..));
        new JSONObject(..).put(Integer.toString(..), new JSONObject(..));
        DeviceLog.debug("Couldn't construct event info", Integer.toString(..));
      L_137:
      L_13b:
        Integer.toString(SparseArray.keyAt(..));
        new JSONObject(..).put(Integer.toString(..), new JSONObject(..));
        DeviceLog.debug("Couldn't construct info object", 1);
      L_14d:
      L_151:
        p1.invoke(AdUnitRelativeLayout.getEvents(..));
      L_159:
        p1.error(AdUnitError.LAYOUT_NULL, new JSONObject(..));
      L_161:
        p1.error(AdUnitError.ADUNIT_NULL, new JSONObject(..));
      L_168:
        return;
    }

    public static void getOrientation(WebViewCallback p0) {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_1c;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getRequestedOrientation();
        Integer.valueOf(IAdUnitActivity.getRequestedOrientation(..));
        p0.invoke(1);
      L_1c:
        p0.error(AdUnitError.ADUNIT_NULL, 0);
      L_23:
        return;
    }

    public static void getSafeAreaInsets(WebViewCallback p0) {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_f3;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        if (if-eqz(IAdUnitActivity.getLayout(..))) goto L_f3;
        if (if-lt(Build$VERSION.SDK_INT, 28)) goto L_eb;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        IAdUnitActivity.getLayout(..).getRootWindowInsets();
        if (if-eqz(AdUnitRelativeLayout.getRootWindowInsets(..))) goto L_e3;
        new JSONObject();
        Object.getClass();
        Object.getClass(..).getMethod("getDisplayCutout", v6);
        Class.getMethod(..).invoke(AdUnitRelativeLayout.getRootWindowInsets(..), "getDisplayCutout");
        if (if-eqz(Method.invoke(..))) goto L_a3;
        Method.invoke(..).getClass();
        Object.getClass(..).getMethod("getSafeInsetTop", v6);
        Class.getMethod(..).invoke(Method.invoke(..), "getSafeInsetTop");
        Method.invoke(..).getClass();
        Object.getClass(..).getMethod("getSafeInsetRight", v7);
        Class.getMethod(..).invoke(Method.invoke(..), "getSafeInsetRight");
        Method.invoke(..).getClass();
        Object.getClass(..).getMethod("getSafeInsetBottom", v8);
        Class.getMethod(..).invoke(Method.invoke(..), "getSafeInsetBottom");
        Method.invoke(..).getClass();
        Object.getClass(..).getMethod("getSafeInsetLeft", v9);
        Class.getMethod(..).invoke(Method.invoke(..), "getSafeInsetLeft");
        new JSONObject(..).put("top", Method.invoke(..));
        new JSONObject(..).put("right", Method.invoke(..));
        new JSONObject(..).put("bottom", Method.invoke(..));
        new JSONObject(..).put("left", Method.invoke(..));
        p0.invoke(Method.invoke(..));
      L_a3:
        p0.error(AdUnitError.NO_DISPLAY_CUTOUT_AVAILABLE, new JSONObject(..));
        p0.error(AdUnitError.DISPLAY_CUTOUT_JSON_ERROR, "left");
        DeviceLog.debug("JSON error while constructing display cutout object", p0);
      L_c0:
        p0.error(AdUnitError.DISPLAY_CUTOUT_INVOKE_FAILED, "left");
        DeviceLog.debug("Error while calling displayCutout getter", p0);
        p0.error(AdUnitError.DISPLAY_CUTOUT_METHOD_NOT_AVAILABLE, "left");
        DeviceLog.debug("Method getDisplayCutout not found", p0);
      L_e3:
        p0.error(AdUnitError.NO_DISPLAY_CUTOUT_AVAILABLE, 0);
      L_eb:
        p0.error(AdUnitError.API_LEVEL_ERROR, 0);
      L_f3:
        p0.error(AdUnitError.ADUNIT_NULL, 0);
      L_fa:
        return;
    }

    public static void getViewFrame(String p0, WebViewCallback p1) {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_4b;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getViewFrame(p0);
        if (if-eqz(IAdUnitActivity.getViewFrame(..))) goto L_43;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getViewFrame(p0);
        IAdUnitActivity.getViewFrame(..).get("x");
        IAdUnitActivity.getViewFrame(..).get("y");
        IAdUnitActivity.getViewFrame(..).get("width");
        IAdUnitActivity.getViewFrame(..).get("height");
        p1.invoke(4);
      L_43:
        p1.error(AdUnitError.UNKNOWN_VIEW, 4);
      L_4b:
        p1.error(AdUnitError.ADUNIT_NULL, 4);
      L_52:
        return;
    }

    private static String[] getViewList(JSONArray p0) {
        p0.length();
      L_7:
        p0.length();
        if (if-ge(0, JSONArray.length(..))) goto L_16;
        p0.getString(0);
      L_16:
        return JSONArray.length(..);
    }

    public static void getViews(WebViewCallback p0) {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_21;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getViews();
        Arrays.asList(IAdUnitActivity.getViews(..));
        new JSONArray(Arrays.asList(..));
        p0.invoke(1);
      L_21:
        p0.error(AdUnitError.ADUNIT_NULL, 0);
      L_28:
        return;
    }

    public static void open(Integer p0, JSONArray p1, Integer p2, WebViewCallback p3) {
        AdUnit.open(p0, p1, p2, 0, p3);
        return;
    }

    public static void open(Integer p0, JSONArray p1, Integer p2, JSONArray p3, WebViewCallback p4) {
        Integer.valueOf(0);
        Boolean.valueOf(1);
        AdUnit.open(p0, p1, p2, p3, Integer.valueOf(..), Boolean.valueOf(..), p4);
        return;
    }

    public static void open(Integer p0, JSONArray p1, Integer p2, JSONArray p3, Integer p4, Boolean p5, WebViewCallback p6) {
        Boolean.valueOf(0);
        AdUnit.open(p0, p1, p2, p3, p4, p5, Boolean.valueOf(..), p6);
        return;
    }

    public static void open(Integer p0, JSONArray p1, Integer p2, JSONArray p3, Integer p4, Boolean p5, Boolean p6, WebViewCallback p7) {
        Integer.valueOf(0);
        AdUnit.open(p0, p1, p2, p3, p4, p5, p6, Integer.valueOf(..), p7);
        return;
    }

    public static void open(Integer p0, JSONArray p1, Integer p2, JSONArray p3, Integer p4, Boolean p5, Boolean p6, Integer p7, WebViewCallback p8) {
        p5.booleanValue();
        if (if-nez(Boolean.booleanValue(..))) goto L_1f;
        p6.booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_1f;
        DeviceLog.debug("Unity Ads opening new transparent ad unit activity, hardware acceleration disabled");
        ClientProperties.getActivity();
        new Intent(ClientProperties.getActivity(..), AdUnitTransparentSoftwareActivity.class);
      L_1f:
        new Intent(..).booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_3c;
        ClientProperties.getActivity(..).booleanValue();
        if (if-nez(Boolean.booleanValue(..))) goto L_3c;
        DeviceLog.debug("Unity Ads opening new hardware accelerated ad unit activity");
        ClientProperties.getActivity();
        new Intent(ClientProperties.getActivity(..), AdUnitActivity.class);
      L_3c:
        new Intent(..).booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_59;
        ClientProperties.getActivity(..).booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_59;
        DeviceLog.debug("Unity Ads opening new hardware accelerated transparent ad unit activity");
        ClientProperties.getActivity();
        new Intent(ClientProperties.getActivity(..), AdUnitTransparentActivity.class);
      L_59:
        DeviceLog.debug("Unity Ads opening new ad unit activity, hardware acceleration disabled");
        ClientProperties.getActivity();
        new Intent(ClientProperties.getActivity(..), AdUnitSoftwareActivity.class);
      L_69:
        new Intent(..).addFlags(0x10010000);
        if (if-eqz(p0)) goto L_10f;
        p0.intValue();
        new Intent(..).putExtra("activityId", Integer.intValue(..));
        p0.intValue();
        AdUnit.setCurrentAdUnitActivityId(Integer.intValue(..));
        AdUnit.getViewList(p1);
        new Intent(..).putExtra("views", AdUnit.getViewList(..));
        if (if-eqz(p3)) goto L_ac;
        AdUnit.getKeyEventList(p3);
        new Intent(..).putExtra("keyEvents", AdUnit.getKeyEventList(..));
        DeviceLog.exception("Error parsing views from viewList", "keyEvents");
        "keyEvents".getMessage();
        p8.error(AdUnitError.CORRUPTED_KEYEVENTLIST, p2);
        return;
      L_ac:
        new Intent(..).putExtra("systemUiVisibility", p4);
        new Intent(..).putExtra("orientation", p2);
        new Intent(..).putExtra("displayCutoutMode", p7);
        ClientProperties.getActivity();
        ClientProperties.getActivity(..).startActivity(new Intent(..));
        new StringBuilder("Opened AdUnitActivity with: ");
        AdUnitError.CORRUPTED_KEYEVENTLIST.toString();
        new StringBuilder(..).append(JSONArray.toString(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        p8.invoke(StringBuilder.toString(..));
        return;
        DeviceLog.exception("Error parsing views from viewList", StringBuilder.toString(..));
        StringBuilder.toString(..).getMessage();
        p8.error(AdUnitError.CORRUPTED_VIEWLIST, p3);
        return;
        DeviceLog.exception("Could not set activityId for intent", JSONArray.toString(..));
        Exception.getMessage(..).intValue();
        Integer.valueOf(Integer.intValue(..));
        JSONArray.toString(..).getMessage();
        p8.error(AdUnitError.ACTIVITY_ID, p3);
        return;
      L_10f:
        DeviceLog.error("Activity ID is NULL");
        p8.error(AdUnitError.ACTIVITY_ID, JSONArray.toString(..));
        return;
    }

    public static void setAdUnitActivity(IAdUnitActivity p0) {
        _adUnitActivity = p0;
        return;
    }

    public static void setCurrentAdUnitActivityId(int p0) {
        _currentActivityId = p0;
        return;
    }

    public static void setKeepScreenOn(Boolean p0, WebViewCallback p1) {
        new AdUnit$3(p0);
        Utilities.runOnUiThread(new AdUnit$3(..));
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_15;
        p1.invoke(AdUnit.getAdUnitActivity(..));
      L_15:
        p1.error(AdUnitError.ADUNIT_NULL, 0);
      L_1c:
        return;
    }

    public static void setKeyEventList(JSONArray p0, WebViewCallback p1) {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_32;
        AdUnit.getAdUnitActivity();
        AdUnit.getKeyEventList(p0);
        AdUnit.getAdUnitActivity(..).setKeyEventList(AdUnit.getKeyEventList(..));
        p1.invoke(AdUnit.getAdUnitActivity(..));
        DeviceLog.exception("Error parsing views from viewList", AdUnit.getAdUnitActivity(..));
        AdUnit.getAdUnitActivity(..).getMessage();
        p1.error(AdUnitError.CORRUPTED_KEYEVENTLIST, 2);
      L_32:
        p1.error(AdUnitError.ADUNIT_NULL, 1);
      L_39:
        return;
    }

    public static void setLayoutInDisplayCutoutMode(Integer p0, WebViewCallback p1) {
        new AdUnit$6(p0);
        Utilities.runOnUiThread(new AdUnit$6(..));
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_18;
        p1.invoke(1);
      L_18:
        p1.error(AdUnitError.ADUNIT_NULL, 1);
      L_1f:
        return;
    }

    public static void setOrientation(Integer p0, WebViewCallback p1) {
        new AdUnit$2(p0);
        Utilities.runOnUiThread(new AdUnit$2(..));
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_18;
        p1.invoke(1);
      L_18:
        p1.error(AdUnitError.ADUNIT_NULL, 1);
      L_1f:
        return;
    }

    public static void setSystemUiVisibility(Integer p0, WebViewCallback p1) {
        new AdUnit$4(p0);
        Utilities.runOnUiThread(new AdUnit$4(..));
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_18;
        p1.invoke(1);
      L_18:
        p1.error(AdUnitError.ADUNIT_NULL, 1);
      L_1f:
        return;
    }

    public static void setViewFrame(String p0, Integer p1, Integer p2, Integer p3, Integer p4, WebViewCallback p5) {
        new AdUnit$5(p0, p1, p2, p3, p4);
        Utilities.runOnUiThread(new AdUnit$5);
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_1b;
        p5.invoke(AdUnit.getAdUnitActivity(..));
      L_1b:
        p5.error(AdUnitError.ADUNIT_NULL, 0);
      L_22:
        return;
    }

    public static void setViews(JSONArray p0, WebViewCallback p1) {
        AdUnit.getViewList(p0);
        p1.error(AdUnitError.CORRUPTED_VIEWLIST, v3);
      L_11:
        if (if-nez(1)) goto L_1b;
        new AdUnit$1(p0);
        Utilities.runOnUiThread(new AdUnit$1(..));
      L_1b:
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_29;
        p1.invoke(1);
      L_29:
        p1.error(AdUnitError.ADUNIT_NULL, 1);
      L_30:
        return;
    }

    public static void startMotionEventCapture(Integer p0, WebViewCallback p1) {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_2e;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        if (if-eqz(IAdUnitActivity.getLayout(..))) goto L_26;
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        p0.intValue();
        IAdUnitActivity.getLayout(..).startCapture(Integer.intValue(..));
        p1.invoke(Integer.intValue(..));
      L_26:
        p1.error(AdUnitError.LAYOUT_NULL, IAdUnitActivity.getLayout(..));
      L_2e:
        p1.error(AdUnitError.ADUNIT_NULL, IAdUnitActivity.getLayout(..));
      L_35:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.GMAScar
// ============================================================
package com.unity3d.services.ads.api;

public class GMAScar {
    private static final GMAScarAdapterBridge gmaScarAdapterBridge;

    static <clinit>() {
        GMA.getInstance();
        GMA.getInstance(..).getBridge();
        gmaScarAdapterBridge = GMA.getBridge(..);
        return;
    }

    public GMAScar() {
        new Object();
        return;
    }

    public static void getSCARSignal(String p0, String p1, WebViewCallback p2) {
        p1.toUpperCase();
        UnityAdFormat.valueOf(String.toUpperCase(..));
        GMAScar.gmaScarAdapterBridge.getSCARSignal(p0, UnityAdFormat.valueOf(..));
        p2.invoke(0);
        return;
    }

    public static void getVersion(WebViewCallback p0) {
        GMAScar.gmaScarAdapterBridge.getVersion();
        p0.invoke(0);
        return;
    }

    public static void initializeScar(WebViewCallback p0) {
        GMAScar.gmaScarAdapterBridge.initializeScar();
        p0.invoke(0);
        return;
    }

    public static void isInitialized(WebViewCallback p0) {
        GMAScar.gmaScarAdapterBridge.isInitialized();
        p0.invoke(0);
        return;
    }

    public static void load(String p0, String p1, Boolean p2, String p3, String p4, Integer p5, WebViewCallback p6) {
        p2.booleanValue();
        p5.intValue();
        GMAScar.gmaScarAdapterBridge.load(Boolean.booleanValue(..), p0, p1, p4, p3, Integer.intValue(..));
        p6.invoke(0);
        return;
    }

    public static void show(String p0, String p1, Boolean p2, WebViewCallback p3) {
        p2.booleanValue();
        GMAScar.gmaScarAdapterBridge.show(p0, p1, Boolean.booleanValue(..));
        p3.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.Load
// ============================================================
package com.unity3d.services.ads.api;

public class Load {
    public Load() {
        new Object();
        return;
    }

    public static void sendAdFailedToLoad(String p0, String p1, String p2, String p3, WebViewCallback p4) {
        LoadModule.getInstance();
        UnityAds$UnityAdsLoadError.valueOf(p2);
        LoadModule.getInstance(..).onUnityAdsFailedToLoad(p1, UnityAds$UnityAdsLoadError.valueOf(..), p3);
        p4.invoke(0);
        return;
    }

    public static void sendAdLoaded(String p0, String p1, WebViewCallback p2) {
        LoadModule.getInstance();
        LoadModule.getInstance(..).onUnityAdsAdLoaded(p1);
        p2.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.Measurements
// ============================================================
package com.unity3d.services.ads.api;

public class Measurements {
    private static final MeasurementsService measurementsService;

    static <clinit>() {
        Utilities.getService(MeasurementsService.class);
        measurementsService = Utilities.getService(..);
        return;
    }

    public Measurements() {
        new Object();
        return;
    }

    public static void checkAvailability(WebViewCallback p0) {
        Measurements.measurementsService.checkAvailability();
        p0.invoke(0);
        return;
    }

    public static void registerClick(String p0, WebViewCallback p1) {
        AdUnit.getAdUnitActivity();
        if (if-nez(AdUnit.getAdUnitActivity(..))) goto L_f;
        p1.error(MeasurementsErrors.ERROR_AD_UNIT_NULL, AdUnit.getAdUnitActivity(..));
        return;
      L_f:
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        if (if-nez(IAdUnitActivity.getLayout(..))) goto L_21;
        p1.error(MeasurementsErrors.ERROR_LAYOUT_NULL, IAdUnitActivity.getLayout(..));
        return;
      L_21:
        AdUnit.getAdUnitActivity();
        AdUnit.getAdUnitActivity(..).getLayout();
        IAdUnitActivity.getLayout(..).getLastInputEvent();
        if (if-nez(AdUnitRelativeLayout.getLastInputEvent(..))) goto L_37;
        p1.error(MeasurementsErrors.ERROR_LAST_INPUT_EVENT_NULL, AdUnitRelativeLayout.getLastInputEvent(..));
        return;
      L_37:
        Measurements.measurementsService.registerClick(MeasurementsErrors.ERROR_LAST_INPUT_EVENT_NULL, AdUnitRelativeLayout.getLastInputEvent(..));
        p1.invoke(MeasurementsErrors.ERROR_LAST_INPUT_EVENT_NULL);
        return;
    }

    public static void registerView(String p0, WebViewCallback p1) {
        Measurements.measurementsService.registerView(p0);
        p1.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.Show
// ============================================================
package com.unity3d.services.ads.api;

public class Show {
    public Show() {
        new Object();
        return;
    }

    public static void sendShowClickEvent(String p0, String p1, WebViewCallback p2) {
        ShowModule.getInstance();
        ShowModule.getInstance(..).onUnityAdsShowClick(p1);
        p2.invoke(0);
        return;
    }

    public static void sendShowCompleteEvent(String p0, String p1, String p2, WebViewCallback p3) {
        ShowModule.getInstance();
        UnityAds$UnityAdsShowCompletionState.valueOf(p2);
        ShowModule.getInstance(..).onUnityAdsShowComplete(p1, UnityAds$UnityAdsShowCompletionState.valueOf(..));
        p3.invoke(0);
        return;
    }

    public static void sendShowConsentEvent(String p0, String p1, WebViewCallback p2) {
        ShowModule.getInstance();
        ShowModule.getInstance(..).onUnityAdsShowConsent(p1);
        p2.invoke(0);
        return;
    }

    public static void sendShowFailedEvent(String p0, String p1, String p2, String p3, WebViewCallback p4) {
        ShowModule.getInstance();
        UnityAds$UnityAdsShowError.valueOf(p2);
        ShowModule.getInstance(..).onUnityAdsShowFailure(p1, UnityAds$UnityAdsShowError.valueOf(..), p3);
        p4.invoke(0);
        return;
    }

    public static void sendShowStartEvent(String p0, String p1, WebViewCallback p2) {
        ShowModule.getInstance();
        ShowModule.getInstance(..).onUnityAdsShowStart(p1);
        p2.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.Token
// ============================================================
package com.unity3d.services.ads.api;

public class Token {
    private static final TokenStorage tokenStorage;

    static <clinit>() {
        Utilities.getService(TokenStorage.class);
        tokenStorage = Utilities.getService(..);
        return;
    }

    public Token() {
        new Object();
        return;
    }

    public static void appendTokens(JSONArray p0, WebViewCallback p1) {
        Token.tokenStorage.appendTokens(p0);
        p1.invoke(p0);
        return;
        p0.getMessage();
        p1.error(TokenError.JSON_EXCEPTION, 1);
        return;
    }

    public static void createTokens(JSONArray p0, WebViewCallback p1) {
        Token.tokenStorage.createTokens(p0);
        p1.invoke(p0);
        return;
        p0.getMessage();
        p1.error(TokenError.JSON_EXCEPTION, 1);
        return;
    }

    public static void deleteTokens(WebViewCallback p0) {
        Token.tokenStorage.deleteTokens();
        p0.invoke(0);
        return;
    }

    public static void getNativeGeneratedToken(WebViewCallback p0) {
        Token.tokenStorage.getNativeGeneratedToken();
        p0.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.Topics
// ============================================================
package com.unity3d.services.ads.api;

public class Topics {
    private static final TopicsService topicsService;

    static <clinit>() {
        Utilities.getService(TopicsService.class);
        topicsService = Utilities.getService(..);
        return;
    }

    public Topics() {
        new Object();
        return;
    }

    public static void checkAvailability(WebViewCallback p0) {
        Topics.topicsService.checkAvailability();
        p0.invoke(1);
        return;
    }

    public static void getTopics(String p0, Boolean p1, WebViewCallback p2) {
        p1.booleanValue();
        Topics.topicsService.getTopics(p0, Boolean.booleanValue(..));
        p2.invoke(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.VideoPlayer
// ============================================================
package com.unity3d.services.ads.api;

public class VideoPlayer {
    private static VideoPlayerView _videoPlayerView;

    public VideoPlayer() {
        new Object();
        return;
    }

    public static void getCurrentPosition(WebViewCallback p0) {
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_1c;
        VideoPlayer.getVideoPlayerView();
        VideoPlayer.getVideoPlayerView(..).getCurrentPosition();
        Integer.valueOf(VideoPlayerView.getCurrentPosition(..));
        p0.invoke(1);
      L_1c:
        p0.error(VideoPlayerError.VIDEOVIEW_NULL, 0);
      L_23:
        return;
    }

    public static void getProgressEventInterval(WebViewCallback p0) {
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_1c;
        VideoPlayer.getVideoPlayerView();
        VideoPlayer.getVideoPlayerView(..).getProgressEventInterval();
        Integer.valueOf(VideoPlayerView.getProgressEventInterval(..));
        p0.invoke(1);
      L_1c:
        p0.error(VideoPlayerError.VIDEOVIEW_NULL, 0);
      L_23:
        return;
    }

    public static VideoPlayerView getVideoPlayerView() {
        return VideoPlayer._videoPlayerView;
    }

    public static void getVideoViewRectangle(WebViewCallback p0) {
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_35;
        VideoPlayer.getVideoPlayerView(..).getVideoViewRectangle();
        Integer.valueOf(v3);
        Integer.valueOf(Integer.valueOf(..));
        Integer.valueOf(Integer.valueOf(..));
        Integer.valueOf(VideoPlayerView.getVideoViewRectangle(..));
        p0.invoke(4);
      L_35:
        p0.error(VideoPlayerError.VIDEOVIEW_NULL, 3);
      L_3c:
        return;
    }

    public static void getVolume(WebViewCallback p0) {
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_1c;
        VideoPlayer.getVideoPlayerView();
        VideoPlayer.getVideoPlayerView(..).getVolume();
        Float.valueOf(VideoPlayerView.getVolume(..));
        p0.invoke(1);
      L_1c:
        p0.error(VideoPlayerError.VIDEOVIEW_NULL, 0);
      L_23:
        return;
    }

    public static void pause(WebViewCallback p0) {
        DeviceLog.debug("Pausing current video");
        new VideoPlayer$4();
        Utilities.runOnUiThread(new VideoPlayer$4(..));
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_1a;
        p0.invoke(VideoPlayer.getVideoPlayerView(..));
      L_1a:
        p0.error(VideoPlayerError.VIDEOVIEW_NULL, 0);
      L_21:
        return;
    }

    public static void play(WebViewCallback p0) {
        DeviceLog.debug("Starting playback of prepared video");
        new VideoPlayer$3();
        Utilities.runOnUiThread(new VideoPlayer$3(..));
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_1a;
        p0.invoke(VideoPlayer.getVideoPlayerView(..));
      L_1a:
        p0.error(VideoPlayerError.VIDEOVIEW_NULL, 0);
      L_21:
        return;
    }

    public static void prepare(String p0, Double p1, WebViewCallback p2) {
        Integer.valueOf(0);
        VideoPlayer.prepare(p0, p1, Integer.valueOf(..), p2);
        return;
    }

    public static void prepare(String p0, Double p1, Integer p2, WebViewCallback p3) {
        new StringBuilder("Preparing video for playback: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        new VideoPlayer$2(p0, p1, p2);
        Utilities.runOnUiThread(new VideoPlayer$2(..));
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_29;
        p3.invoke(1);
      L_29:
        p3.error(VideoPlayerError.VIDEOVIEW_NULL, 1);
      L_30:
        return;
    }

    public static void seekTo(Integer p0, WebViewCallback p1) {
        new StringBuilder("Seeking video to time: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        new VideoPlayer$6(p0);
        Utilities.runOnUiThread(new VideoPlayer$6(..));
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_26;
        p1.invoke(VideoPlayer.getVideoPlayerView(..));
      L_26:
        p1.error(VideoPlayerError.VIDEOVIEW_NULL, 0);
      L_2d:
        return;
    }

    public static void setInfoListenerEnabled(boolean p0, WebViewCallback p1) {
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_25;
        VideoPlayer.getVideoPlayerView();
        VideoPlayer.getVideoPlayerView(..).setInfoListenerEnabled(p0);
        Boolean.valueOf(p0);
        p1.invoke(3);
      L_25:
        p1.error(VideoPlayerError.VIDEOVIEW_NULL, 3);
      L_2c:
        return;
    }

    public static void setProgressEventInterval(Integer p0, WebViewCallback p1) {
        new VideoPlayer$1(p0);
        Utilities.runOnUiThread(new VideoPlayer$1(..));
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_15;
        p1.invoke(VideoPlayer.getVideoPlayerView(..));
      L_15:
        p1.error(VideoPlayerError.VIDEOVIEW_NULL, 0);
      L_1c:
        return;
    }

    public static void setVideoPlayerView(VideoPlayerView p0) {
        _videoPlayerView = p0;
        return;
    }

    public static void setVolume(Double p0, WebViewCallback p1) {
        new StringBuilder("Setting video volume: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_30;
        VideoPlayer.getVideoPlayerView();
        p0.floatValue();
        Float.valueOf(Double.floatValue(..));
        VideoPlayer.getVideoPlayerView(..).setVolume(Float.valueOf(..));
        p1.invoke(1);
      L_30:
        p1.error(VideoPlayerError.VIDEOVIEW_NULL, 1);
      L_37:
        return;
    }

    public static void stop(WebViewCallback p0) {
        DeviceLog.debug("Stopping current video");
        new VideoPlayer$5();
        Utilities.runOnUiThread(new VideoPlayer$5(..));
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_1a;
        p0.invoke(VideoPlayer.getVideoPlayerView(..));
      L_1a:
        p0.error(VideoPlayerError.VIDEOVIEW_NULL, 0);
      L_21:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.WebPlayer
// ============================================================
package com.unity3d.services.ads.api;

public class WebPlayer {
    public WebPlayer() {
        new Object();
        return;
    }

    public static void clearSettings(String p0, WebViewCallback p1) {
        WebPlayerSettingsCache.getInstance();
        WebPlayerSettingsCache.removeWebSettings(p0);
        WebPlayerSettingsCache.removeWebPlayerSettings(p0);
        WebPlayerSettingsCache.removeWebPlayerEventSettings(p0);
        WebPlayerViewCache.getInstance();
        WebPlayerViewCache.getInstance(..).getWebPlayer(p0);
        if (if-eqz(WebPlayerViewCache.getWebPlayer(..))) goto L_26;
        new WebPlayer$6(WebPlayerViewCache.getWebPlayer(..));
        Utilities.runOnUiThread(new WebPlayer$6(..));
        p1.invoke(WebPlayerViewCache.getWebPlayer(..));
      L_26:
        p1.error(WebPlayerError.WEBPLAYER_NULL, 0);
      L_2d:
        return;
    }

    public static void getErroredSettings(String p0, WebViewCallback p1) {
        WebPlayerViewCache.getInstance();
        WebPlayerViewCache.getInstance(..).getWebPlayer(p0);
        if (if-eqz(WebPlayerViewCache.getWebPlayer(..))) goto L_4a;
        WebPlayerViewCache.getWebPlayer(..).getErroredSettings();
        new JSONObject();
        WebPlayerView.getErroredSettings(..).entrySet();
        Map.entrySet(..).iterator();
      L_1c:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_3c;
        Set.iterator(..).next();
        Iterator.next(..).getKey();
        Iterator.next(..).getValue();
        new JSONObject(..).put(Map$Entry.getKey(..), Map$Entry.getValue(..));
        DeviceLog.exception("Error forming JSON object", Set.iterator(..));
      L_3c:
        p1.invoke(1);
        p1.invoke(1);
      L_4a:
        p1.error(WebPlayerError.WEBPLAYER_NULL, 0);
      L_51:
        return;
    }

    public static void getFrame(String p0, String p1, WebViewCallback p2) {
        p2.invoke(0);
        WebPlayerViewCache.getInstance();
        WebPlayerViewCache.getInstance(..).getWebPlayer(p1);
        if (if-eqz(WebPlayerViewCache.getWebPlayer(..))) goto L_18;
        new WebPlayer$7(WebPlayerViewCache.getWebPlayer(..), p0, p1);
        Utilities.runOnUiThread(new WebPlayer$7(..));
      L_18:
        return;
    }

    public static void sendEvent(JSONArray p0, String p1, WebViewCallback p2) {
        WebPlayerViewCache.getInstance();
        WebPlayerViewCache.getInstance(..).getWebPlayer(p1);
        if (if-eqz(WebPlayerViewCache.getWebPlayer(..))) goto L_14;
        WebPlayerViewCache.getWebPlayer(..).sendEvent(p0);
        p2.invoke(p0);
      L_14:
        p2.error(WebPlayerError.WEBPLAYER_NULL, WebPlayerViewCache.getWebPlayer(..));
      L_1b:
        return;
    }

    public static void setData(String p0, String p1, String p2, String p3, WebViewCallback p4) {
        WebPlayerViewCache.getInstance();
        WebPlayerViewCache.getInstance(..).getWebPlayer(p3);
        if (if-eqz(WebPlayerViewCache.getWebPlayer(..))) goto L_19;
        new WebPlayer$2(WebPlayerViewCache.getWebPlayer(..), p0, p1, p2);
        Utilities.runOnUiThread(new WebPlayer$2(..));
        p4.invoke(p0);
      L_19:
        p4.error(WebPlayerError.WEBPLAYER_NULL, p1);
      L_20:
        return;
    }

    public static void setDataWithUrl(String p0, String p1, String p2, String p3, String p4, WebViewCallback p5) {
        WebPlayerViewCache.getInstance();
        WebPlayerViewCache.getInstance(..).getWebPlayer(p4);
        if (if-eqz(WebPlayerViewCache.getWebPlayer(..))) goto L_1e;
        new WebPlayer$3(WebPlayerViewCache.getWebPlayer(..), p0, p1, p2, p3);
        Utilities.runOnUiThread(new WebPlayer$3);
        p5.invoke(p0);
      L_1e:
        p5.error(WebPlayerError.WEBPLAYER_NULL, p1);
      L_25:
        return;
    }

    public static void setEventSettings(JSONObject p0, String p1, WebViewCallback p2) {
        WebPlayerSettingsCache.getInstance();
        WebPlayerSettingsCache.addWebPlayerEventSettings(p1, p0);
        WebPlayerViewCache.getInstance();
        WebPlayerViewCache.getInstance(..).getWebPlayer(p1);
        if (if-eqz(WebPlayerViewCache.getWebPlayer(..))) goto L_20;
        new WebPlayer$5(WebPlayerViewCache.getWebPlayer(..), p0);
        Utilities.runOnUiThread(new WebPlayer$5(..));
        p2.invoke(p0);
      L_20:
        p2.error(WebPlayerError.WEBPLAYER_NULL, WebPlayerViewCache.getWebPlayer(..));
      L_27:
        return;
    }

    public static void setSettings(JSONObject p0, JSONObject p1, String p2, WebViewCallback p3) {
        WebPlayerSettingsCache.getInstance();
        WebPlayerSettingsCache.addWebSettings(p2, p0);
        WebPlayerSettingsCache.getInstance();
        WebPlayerSettingsCache.addWebPlayerSettings(p2, p1);
        WebPlayerViewCache.getInstance();
        WebPlayerViewCache.getInstance(..).getWebPlayer(p2);
        if (if-eqz(WebPlayerViewCache.getWebPlayer(..))) goto L_27;
        new WebPlayer$4(WebPlayerViewCache.getWebPlayer(..), p0, p1);
        Utilities.runOnUiThread(new WebPlayer$4(..));
        p3.invoke(p0);
      L_27:
        p3.error(WebPlayerError.WEBPLAYER_NULL, p1);
      L_2e:
        return;
    }

    public static void setUrl(String p0, String p1, WebViewCallback p2) {
        WebPlayerViewCache.getInstance();
        WebPlayerViewCache.getInstance(..).getWebPlayer(p1);
        if (if-eqz(WebPlayerViewCache.getWebPlayer(..))) goto L_19;
        new WebPlayer$1(WebPlayerViewCache.getWebPlayer(..), p0);
        Utilities.runOnUiThread(new WebPlayer$1(..));
        p2.invoke(p0);
      L_19:
        p2.error(WebPlayerError.WEBPLAYER_NULL, WebPlayerViewCache.getWebPlayer(..));
      L_20:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.AdUnit$1
// ============================================================
package com.unity3d.services.ads.api;

class AdUnit$1 {
    final JSONArray val$views;

    AdUnit$1(JSONArray p0) {
        val$views = p0;
        new Object();
        return;
    }

    public void run() {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_1a;
        AdUnit.getAdUnitActivity();
        AdUnit.access$000(val$views);
        AdUnit.getAdUnitActivity(..).setViews(AdUnit.access$000(..));
        DeviceLog.exception("Corrupted viewlist", AdUnit.getAdUnitActivity(..));
      L_1a:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.AdUnit$2
// ============================================================
package com.unity3d.services.ads.api;

class AdUnit$2 {
    final Integer val$orientation;

    AdUnit$2(Integer p0) {
        val$orientation = p0;
        new Object();
        return;
    }

    public void run() {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_13;
        AdUnit.getAdUnitActivity();
        Integer.intValue();
        AdUnit.getAdUnitActivity(..).setOrientation(Integer.intValue(..));
      L_13:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.AdUnit$3
// ============================================================
package com.unity3d.services.ads.api;

class AdUnit$3 {
    final Boolean val$screenOn;

    AdUnit$3(Boolean p0) {
        val$screenOn = p0;
        new Object();
        return;
    }

    public void run() {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_13;
        AdUnit.getAdUnitActivity();
        Boolean.booleanValue();
        AdUnit.getAdUnitActivity(..).setKeepScreenOn(Boolean.booleanValue(..));
      L_13:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.AdUnit$4
// ============================================================
package com.unity3d.services.ads.api;

class AdUnit$4 {
    final Integer val$systemUiVisibility;

    AdUnit$4(Integer p0) {
        val$systemUiVisibility = p0;
        new Object();
        return;
    }

    public void run() {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_13;
        AdUnit.getAdUnitActivity();
        Integer.intValue();
        AdUnit.getAdUnitActivity(..).setSystemUiVisibility(Integer.intValue(..));
      L_13:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.AdUnit$5
// ============================================================
package com.unity3d.services.ads.api;

class AdUnit$5 {
    final Integer val$height;
    final String val$view;
    final Integer val$width;
    final Integer val$x;
    final Integer val$y;

    AdUnit$5(String p0, Integer p1, Integer p2, Integer p3, Integer p4) {
        val$view = p0;
        val$x = p1;
        val$y = p2;
        val$width = p3;
        val$height = p4;
        new Object();
        return;
    }

    public void run() {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_27;
        AdUnit.getAdUnitActivity();
        Integer.intValue();
        Integer.intValue();
        Integer.intValue();
        Integer.intValue();
        AdUnit.getAdUnitActivity(..).setViewFrame(val$view, Integer.intValue(..), Integer.intValue(..), Integer.intValue(..), Integer.intValue(..));
      L_27:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.AdUnit$6
// ============================================================
package com.unity3d.services.ads.api;

class AdUnit$6 {
    final Integer val$displayCutoutMode;

    AdUnit$6(Integer p0) {
        val$displayCutoutMode = p0;
        new Object();
        return;
    }

    public void run() {
        AdUnit.getAdUnitActivity();
        if (if-eqz(AdUnit.getAdUnitActivity(..))) goto L_13;
        AdUnit.getAdUnitActivity();
        Integer.intValue();
        AdUnit.getAdUnitActivity(..).setLayoutInDisplayCutoutMode(Integer.intValue(..));
      L_13:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.VideoPlayer$1
// ============================================================
package com.unity3d.services.ads.api;

class VideoPlayer$1 {
    final Integer val$milliseconds;

    VideoPlayer$1(Integer p0) {
        val$milliseconds = p0;
        new Object();
        return;
    }

    public void run() {
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_13;
        VideoPlayer.getVideoPlayerView();
        Integer.intValue();
        VideoPlayer.getVideoPlayerView(..).setProgressEventInterval(Integer.intValue(..));
      L_13:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.VideoPlayer$2
// ============================================================
package com.unity3d.services.ads.api;

class VideoPlayer$2 {
    final Double val$initialVolume;
    final Integer val$timeout;
    final String val$url;

    VideoPlayer$2(String p0, Double p1, Integer p2) {
        val$url = p0;
        val$initialVolume = p1;
        val$timeout = p2;
        new Object();
        return;
    }

    public void run() {
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_1b;
        VideoPlayer.getVideoPlayerView();
        Double.floatValue();
        Integer.intValue();
        VideoPlayer.getVideoPlayerView(..).prepare(val$url, Double.floatValue(..), Integer.intValue(..));
      L_1b:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.VideoPlayer$3
// ============================================================
package com.unity3d.services.ads.api;

class VideoPlayer$3 {
    VideoPlayer$3() {
        new Object();
        return;
    }

    public void run() {
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_d;
        VideoPlayer.getVideoPlayerView();
        VideoPlayer.getVideoPlayerView(..).play();
      L_d:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.VideoPlayer$4
// ============================================================
package com.unity3d.services.ads.api;

class VideoPlayer$4 {
    VideoPlayer$4() {
        new Object();
        return;
    }

    public void run() {
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_d;
        VideoPlayer.getVideoPlayerView();
        VideoPlayer.getVideoPlayerView(..).pause();
      L_d:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.VideoPlayer$5
// ============================================================
package com.unity3d.services.ads.api;

class VideoPlayer$5 {
    VideoPlayer$5() {
        new Object();
        return;
    }

    public void run() {
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_d;
        VideoPlayer.getVideoPlayerView();
        VideoPlayer.getVideoPlayerView(..).stop();
      L_d:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.VideoPlayer$6
// ============================================================
package com.unity3d.services.ads.api;

class VideoPlayer$6 {
    final Integer val$time;

    VideoPlayer$6(Integer p0) {
        val$time = p0;
        new Object();
        return;
    }

    public void run() {
        VideoPlayer.getVideoPlayerView();
        if (if-eqz(VideoPlayer.getVideoPlayerView(..))) goto L_13;
        VideoPlayer.getVideoPlayerView();
        Integer.intValue();
        VideoPlayer.getVideoPlayerView(..).seekTo(Integer.intValue(..));
      L_13:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.WebPlayer$1
// ============================================================
package com.unity3d.services.ads.api;

class WebPlayer$1 {
    final String val$url;
    final WebPlayerView val$webPlayerView;

    WebPlayer$1(WebPlayerView p0, String p1) {
        val$webPlayerView = p0;
        val$url = p1;
        new Object();
        return;
    }

    public void run() {
        WebPlayerView.loadUrl(val$url);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.WebPlayer$2
// ============================================================
package com.unity3d.services.ads.api;

class WebPlayer$2 {
    final String val$data;
    final String val$encoding;
    final String val$mimeType;
    final WebPlayerView val$webPlayerView;

    WebPlayer$2(WebPlayerView p0, String p1, String p2, String p3) {
        val$webPlayerView = p0;
        val$data = p1;
        val$mimeType = p2;
        val$encoding = p3;
        new Object();
        return;
    }

    public void run() {
        WebPlayerView.loadData(val$data, val$mimeType, val$encoding);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.WebPlayer$3
// ============================================================
package com.unity3d.services.ads.api;

class WebPlayer$3 {
    final String val$baseUrl;
    final String val$data;
    final String val$encoding;
    final String val$mimeType;
    final WebPlayerView val$webPlayerView;

    WebPlayer$3(WebPlayerView p0, String p1, String p2, String p3, String p4) {
        val$webPlayerView = p0;
        val$baseUrl = p1;
        val$data = p2;
        val$mimeType = p3;
        val$encoding = p4;
        new Object();
        return;
    }

    public void run() {
        WebPlayerView.loadDataWithBaseURL(val$baseUrl, val$data, val$mimeType, val$encoding, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.WebPlayer$4
// ============================================================
package com.unity3d.services.ads.api;

class WebPlayer$4 {
    final JSONObject val$webPlayerSettings;
    final WebPlayerView val$webPlayerView;
    final JSONObject val$webSettings;

    WebPlayer$4(WebPlayerView p0, JSONObject p1, JSONObject p2) {
        val$webPlayerView = p0;
        val$webSettings = p1;
        val$webPlayerSettings = p2;
        new Object();
        return;
    }

    public void run() {
        WebPlayerView.setSettings(val$webSettings, val$webPlayerSettings);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.WebPlayer$5
// ============================================================
package com.unity3d.services.ads.api;

class WebPlayer$5 {
    final JSONObject val$eventSettings;
    final WebPlayerView val$webPlayerView;

    WebPlayer$5(WebPlayerView p0, JSONObject p1) {
        val$webPlayerView = p0;
        val$eventSettings = p1;
        new Object();
        return;
    }

    public void run() {
        WebPlayerView.setEventSettings(val$eventSettings);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.WebPlayer$6
// ============================================================
package com.unity3d.services.ads.api;

class WebPlayer$6 {
    final WebPlayerView val$webPlayerView;

    WebPlayer$6(WebPlayerView p0) {
        val$webPlayerView = p0;
        new Object();
        return;
    }

    public void run() {
        new JSONObject();
        new JSONObject();
        WebPlayerView.setSettings(new JSONObject(..), new JSONObject(..));
        new JSONObject();
        WebPlayerView.setEventSettings(new JSONObject(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.api.WebPlayer$7
// ============================================================
package com.unity3d.services.ads.api;

class WebPlayer$7 {
    final String val$callId;
    final String val$viewId;
    final WebPlayerView val$webPlayerView;

    WebPlayer$7(WebPlayerView p0, String p1, String p2) {
        val$webPlayerView = p0;
        val$callId = p1;
        val$viewId = p2;
        new Object();
        return;
    }

    public void run() {
        WebPlayerView.getLocationOnScreen(2);
        WebPlayerView.getWidth();
        WebPlayerView.getHeight();
        WebPlayerView.getAlpha();
        WebPlayerEventBridge.sendGetFrameResponse(val$callId, val$viewId, v4, v5, WebPlayerView.getWidth(..), WebPlayerView.getHeight(..), WebPlayerView.getAlpha(..));
        return;
    }

}

