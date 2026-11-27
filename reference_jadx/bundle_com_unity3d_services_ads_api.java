
// ===== FILE: com/unity3d/services/ads/api/AdUnit.java =====
package com.unity3d.services.ads.api;

import android.content.Intent;
import android.os.Build;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.WindowInsets;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.unity3d.services.ads.adunit.AdUnitError;
import com.unity3d.services.ads.adunit.AdUnitMotionEvent;
import com.unity3d.services.ads.adunit.AdUnitSoftwareActivity;
import com.unity3d.services.ads.adunit.AdUnitTransparentActivity;
import com.unity3d.services.ads.adunit.AdUnitTransparentSoftwareActivity;
import com.unity3d.services.ads.adunit.IAdUnitActivity;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdUnit {
    private static IAdUnitActivity _adUnitActivity = null;
    private static int _currentActivityId = -1;

    private AdUnit() {
    }

    public static void setAdUnitActivity(IAdUnitActivity iAdUnitActivity) {
        _adUnitActivity = iAdUnitActivity;
    }

    public static IAdUnitActivity getAdUnitActivity() {
        return _adUnitActivity;
    }

    public static int getCurrentAdUnitActivityId() {
        return _currentActivityId;
    }

    public static void setCurrentAdUnitActivityId(int i) {
        _currentActivityId = i;
    }

    @WebViewExposed
    public static void open(Integer num, JSONArray jSONArray, Integer num2, WebViewCallback webViewCallback) {
        open(num, jSONArray, num2, null, webViewCallback);
    }

    @WebViewExposed
    public static void open(Integer num, JSONArray jSONArray, Integer num2, JSONArray jSONArray2, WebViewCallback webViewCallback) {
        open(num, jSONArray, num2, jSONArray2, 0, true, webViewCallback);
    }

    @WebViewExposed
    public static void open(Integer num, JSONArray jSONArray, Integer num2, JSONArray jSONArray2, Integer num3, Boolean bool, WebViewCallback webViewCallback) {
        open(num, jSONArray, num2, jSONArray2, num3, bool, false, webViewCallback);
    }

    @WebViewExposed
    public static void open(Integer num, JSONArray jSONArray, Integer num2, JSONArray jSONArray2, Integer num3, Boolean bool, Boolean bool2, WebViewCallback webViewCallback) {
        open(num, jSONArray, num2, jSONArray2, num3, bool, bool2, 0, webViewCallback);
    }

    @WebViewExposed
    public static void open(Integer num, JSONArray jSONArray, Integer num2, JSONArray jSONArray2, Integer num3, Boolean bool, Boolean bool2, Integer num4, WebViewCallback webViewCallback) {
        Intent intent;
        if (!bool.booleanValue() && bool2.booleanValue()) {
            DeviceLog.debug("Unity Ads opening new transparent ad unit activity, hardware acceleration disabled");
            intent = new Intent(ClientProperties.getActivity(), (Class<?>) AdUnitTransparentSoftwareActivity.class);
        } else if (bool.booleanValue() && !bool2.booleanValue()) {
            DeviceLog.debug("Unity Ads opening new hardware accelerated ad unit activity");
            intent = new Intent(ClientProperties.getActivity(), (Class<?>) AdUnitActivity.class);
        } else if (bool.booleanValue() && bool2.booleanValue()) {
            DeviceLog.debug("Unity Ads opening new hardware accelerated transparent ad unit activity");
            intent = new Intent(ClientProperties.getActivity(), (Class<?>) AdUnitTransparentActivity.class);
        } else {
            DeviceLog.debug("Unity Ads opening new ad unit activity, hardware acceleration disabled");
            intent = new Intent(ClientProperties.getActivity(), (Class<?>) AdUnitSoftwareActivity.class);
        }
        intent.addFlags(268500992);
        if (num != null) {
            try {
                intent.putExtra(AdUnitActivity.EXTRA_ACTIVITY_ID, num.intValue());
                setCurrentAdUnitActivityId(num.intValue());
                try {
                    intent.putExtra(AdUnitActivity.EXTRA_VIEWS, getViewList(jSONArray));
                    if (jSONArray2 != null) {
                        try {
                            intent.putExtra(AdUnitActivity.EXTRA_KEY_EVENT_LIST, getKeyEventList(jSONArray2));
                        } catch (Exception e) {
                            DeviceLog.exception("Error parsing views from viewList", e);
                            webViewCallback.error(AdUnitError.CORRUPTED_KEYEVENTLIST, jSONArray2, e.getMessage());
                            return;
                        }
                    }
                    intent.putExtra(AdUnitActivity.EXTRA_SYSTEM_UI_VISIBILITY, num3);
                    intent.putExtra(AdUnitActivity.EXTRA_ORIENTATION, num2);
                    intent.putExtra(AdUnitActivity.EXTRA_DISPLAY_CUTOUT_MODE, num4);
                    ClientProperties.getActivity().startActivity(intent);
                    DeviceLog.debug("Opened AdUnitActivity with: " + jSONArray.toString());
                    webViewCallback.invoke(new Object[0]);
                    return;
                } catch (Exception e2) {
                    DeviceLog.exception("Error parsing views from viewList", e2);
                    webViewCallback.error(AdUnitError.CORRUPTED_VIEWLIST, jSONArray, e2.getMessage());
                    return;
                }
            } catch (Exception e3) {
                DeviceLog.exception("Could not set activityId for intent", e3);
                webViewCallback.error(AdUnitError.ACTIVITY_ID, Integer.valueOf(num.intValue()), e3.getMessage());
                return;
            }
        }
        DeviceLog.error("Activity ID is NULL");
        webViewCallback.error(AdUnitError.ACTIVITY_ID, "Activity ID NULL");
    }

    @WebViewExposed
    public static void close(WebViewCallback webViewCallback) {
        if (getAdUnitActivity() != null) {
            getAdUnitActivity().finish();
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setViews(final JSONArray jSONArray, WebViewCallback webViewCallback) {
        boolean z;
        try {
            getViewList(jSONArray);
            z = false;
        } catch (JSONException unused) {
            webViewCallback.error(AdUnitError.CORRUPTED_VIEWLIST, jSONArray);
            z = true;
        }
        if (!z) {
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.AdUnit.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AdUnit.getAdUnitActivity() != null) {
                        try {
                            AdUnit.getAdUnitActivity().setViews(AdUnit.getViewList(jSONArray));
                        } catch (Exception e) {
                            DeviceLog.exception("Corrupted viewlist", e);
                        }
                    }
                }
            });
        }
        if (getAdUnitActivity() != null) {
            webViewCallback.invoke(jSONArray);
        } else {
            webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getViews(WebViewCallback webViewCallback) {
        if (getAdUnitActivity() != null) {
            webViewCallback.invoke(new JSONArray((Collection) Arrays.asList(getAdUnitActivity().getViews())));
        } else {
            webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setOrientation(final Integer num, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.AdUnit.2
            @Override // java.lang.Runnable
            public void run() {
                if (AdUnit.getAdUnitActivity() != null) {
                    AdUnit.getAdUnitActivity().setOrientation(num.intValue());
                }
            }
        });
        if (getAdUnitActivity() != null) {
            webViewCallback.invoke(num);
        } else {
            webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getOrientation(WebViewCallback webViewCallback) {
        if (getAdUnitActivity() != null) {
            webViewCallback.invoke(Integer.valueOf(getAdUnitActivity().getRequestedOrientation()));
        } else {
            webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setKeepScreenOn(final Boolean bool, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.AdUnit.3
            @Override // java.lang.Runnable
            public void run() {
                if (AdUnit.getAdUnitActivity() != null) {
                    AdUnit.getAdUnitActivity().setKeepScreenOn(bool.booleanValue());
                }
            }
        });
        if (getAdUnitActivity() != null) {
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setSystemUiVisibility(final Integer num, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.AdUnit.4
            @Override // java.lang.Runnable
            public void run() {
                if (AdUnit.getAdUnitActivity() != null) {
                    AdUnit.getAdUnitActivity().setSystemUiVisibility(num.intValue());
                }
            }
        });
        if (getAdUnitActivity() != null) {
            webViewCallback.invoke(num);
        } else {
            webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setKeyEventList(JSONArray jSONArray, WebViewCallback webViewCallback) {
        if (getAdUnitActivity() != null) {
            try {
                getAdUnitActivity().setKeyEventList(getKeyEventList(jSONArray));
                webViewCallback.invoke(jSONArray);
                return;
            } catch (Exception e) {
                DeviceLog.exception("Error parsing views from viewList", e);
                webViewCallback.error(AdUnitError.CORRUPTED_KEYEVENTLIST, jSONArray, e.getMessage());
                return;
            }
        }
        webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void setViewFrame(final String str, final Integer num, final Integer num2, final Integer num3, final Integer num4, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.AdUnit.5
            @Override // java.lang.Runnable
            public void run() {
                if (AdUnit.getAdUnitActivity() != null) {
                    AdUnit.getAdUnitActivity().setViewFrame(str, num.intValue(), num2.intValue(), num3.intValue(), num4.intValue());
                }
            }
        });
        if (getAdUnitActivity() != null) {
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getViewFrame(String str, WebViewCallback webViewCallback) {
        if (getAdUnitActivity() != null) {
            if (getAdUnitActivity().getViewFrame(str) != null) {
                Map<String, Integer> viewFrame = getAdUnitActivity().getViewFrame(str);
                webViewCallback.invoke(viewFrame.get("x"), viewFrame.get("y"), viewFrame.get("width"), viewFrame.get("height"));
                return;
            } else {
                webViewCallback.error(AdUnitError.UNKNOWN_VIEW, new Object[0]);
                return;
            }
        }
        webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void startMotionEventCapture(Integer num, WebViewCallback webViewCallback) {
        if (getAdUnitActivity() != null) {
            if (getAdUnitActivity().getLayout() != null) {
                getAdUnitActivity().getLayout().startCapture(num.intValue());
                webViewCallback.invoke(new Object[0]);
                return;
            } else {
                webViewCallback.error(AdUnitError.LAYOUT_NULL, new Object[0]);
                return;
            }
        }
        webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void endMotionEventCapture(WebViewCallback webViewCallback) {
        if (getAdUnitActivity() != null) {
            if (getAdUnitActivity().getLayout() != null) {
                getAdUnitActivity().getLayout().endCapture();
                webViewCallback.invoke(new Object[0]);
                return;
            } else {
                webViewCallback.error(AdUnitError.LAYOUT_NULL, new Object[0]);
                return;
            }
        }
        webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void clearMotionEventCapture(WebViewCallback webViewCallback) {
        if (getAdUnitActivity() != null) {
            if (getAdUnitActivity().getLayout() != null) {
                getAdUnitActivity().getLayout().clearCapture();
                webViewCallback.invoke(new Object[0]);
                return;
            } else {
                webViewCallback.error(AdUnitError.LAYOUT_NULL, new Object[0]);
                return;
            }
        }
        webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void getMotionEventCount(JSONArray jSONArray, WebViewCallback webViewCallback) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
            } catch (Exception e) {
                DeviceLog.exception("Error retrieving int from eventTypes", e);
            }
        }
        if (getAdUnitActivity() != null) {
            if (getAdUnitActivity().getLayout() != null) {
                if (getAdUnitActivity().getLayout().getCurrentEventCount() >= getAdUnitActivity().getLayout().getMaxEventCount()) {
                    webViewCallback.error(AdUnitError.MAX_MOTION_EVENT_COUNT_REACHED, new Object[0]);
                    return;
                }
                SparseIntArray eventCount = getAdUnitActivity().getLayout().getEventCount(arrayList);
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < eventCount.size(); i2++) {
                    int keyAt = eventCount.keyAt(i2);
                    try {
                        jSONObject.put(Integer.toString(keyAt), eventCount.get(keyAt));
                    } catch (Exception e2) {
                        DeviceLog.exception("Error building response JSON", e2);
                    }
                }
                webViewCallback.invoke(jSONObject);
                return;
            }
            webViewCallback.error(AdUnitError.LAYOUT_NULL, new Object[0]);
            return;
        }
        webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void getMotionEventData(JSONObject jSONObject, WebViewCallback webViewCallback) {
        JSONArray jSONArray;
        Iterator<String> keys = jSONObject.keys();
        SparseArray<ArrayList<Integer>> sparseArray = new SparseArray<>();
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            String next = keys.next();
            int parseInt = Integer.parseInt(next);
            if (sparseArray.get(parseInt) == null) {
                sparseArray.put(parseInt, new ArrayList<>());
            }
            try {
                jSONArray = jSONObject.getJSONArray(next);
            } catch (Exception e) {
                DeviceLog.exception("Couldn't fetch keyIndices", e);
                jSONArray = null;
            }
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        sparseArray.get(parseInt).add(Integer.valueOf(jSONArray.getInt(i)));
                    } catch (Exception e2) {
                        DeviceLog.exception("Couldn't add value to requested infos", e2);
                    }
                }
            }
        }
        if (getAdUnitActivity() != null) {
            if (getAdUnitActivity().getLayout() != null) {
                if (getAdUnitActivity().getLayout().getCurrentEventCount() >= getAdUnitActivity().getLayout().getMaxEventCount()) {
                    webViewCallback.error(AdUnitError.MAX_MOTION_EVENT_COUNT_REACHED, new Object[0]);
                    return;
                }
                SparseArray<SparseArray<AdUnitMotionEvent>> events = getAdUnitActivity().getLayout().getEvents(sparseArray);
                JSONObject jSONObject2 = new JSONObject();
                for (int i2 = 0; i2 < events.size(); i2++) {
                    int keyAt = events.keyAt(i2);
                    SparseArray<AdUnitMotionEvent> sparseArray2 = events.get(keyAt);
                    JSONObject jSONObject3 = new JSONObject();
                    for (int i3 = 0; i3 < sparseArray2.size(); i3++) {
                        JSONObject jSONObject4 = new JSONObject();
                        int keyAt2 = sparseArray2.keyAt(i3);
                        AdUnitMotionEvent adUnitMotionEvent = sparseArray2.get(keyAt2);
                        try {
                            jSONObject4.put("action", adUnitMotionEvent.getAction());
                            jSONObject4.put("isObscured", adUnitMotionEvent.isObscured());
                            jSONObject4.put("toolType", adUnitMotionEvent.getToolType());
                            jSONObject4.put("source", adUnitMotionEvent.getSource());
                            jSONObject4.put("deviceId", adUnitMotionEvent.getDeviceId());
                            jSONObject4.put("x", adUnitMotionEvent.getX());
                            jSONObject4.put("y", adUnitMotionEvent.getY());
                            jSONObject4.put("eventTime", adUnitMotionEvent.getEventTime());
                            jSONObject4.put("pressure", adUnitMotionEvent.getPressure());
                            jSONObject4.put("size", adUnitMotionEvent.getSize());
                            jSONObject3.put(Integer.toString(keyAt2), jSONObject4);
                        } catch (Exception e3) {
                            DeviceLog.debug("Couldn't construct event info", e3);
                        }
                    }
                    try {
                        jSONObject2.put(Integer.toString(keyAt), jSONObject3);
                    } catch (Exception e4) {
                        DeviceLog.debug("Couldn't construct info object", e4);
                    }
                }
                webViewCallback.invoke(jSONObject2);
                return;
            }
            webViewCallback.error(AdUnitError.LAYOUT_NULL, new Object[0]);
            return;
        }
        webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void getCurrentMotionEventCount(WebViewCallback webViewCallback) {
        if (getAdUnitActivity() != null) {
            if (getAdUnitActivity().getLayout() != null) {
                webViewCallback.invoke(Integer.valueOf(getAdUnitActivity().getLayout().getCurrentEventCount()));
                return;
            } else {
                webViewCallback.error(AdUnitError.LAYOUT_NULL, new Object[0]);
                return;
            }
        }
        webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void getSafeAreaInsets(WebViewCallback webViewCallback) {
        if (getAdUnitActivity() != null && getAdUnitActivity().getLayout() != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowInsets rootWindowInsets = getAdUnitActivity().getLayout().getRootWindowInsets();
                if (rootWindowInsets != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        Object invoke = rootWindowInsets.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(rootWindowInsets, new Object[0]);
                        if (invoke != null) {
                            Object invoke2 = invoke.getClass().getMethod("getSafeInsetTop", new Class[0]).invoke(invoke, new Object[0]);
                            Object invoke3 = invoke.getClass().getMethod("getSafeInsetRight", new Class[0]).invoke(invoke, new Object[0]);
                            Object invoke4 = invoke.getClass().getMethod("getSafeInsetBottom", new Class[0]).invoke(invoke, new Object[0]);
                            Object invoke5 = invoke.getClass().getMethod("getSafeInsetLeft", new Class[0]).invoke(invoke, new Object[0]);
                            jSONObject.put("top", invoke2);
                            jSONObject.put("right", invoke3);
                            jSONObject.put("bottom", invoke4);
                            jSONObject.put("left", invoke5);
                            webViewCallback.invoke(jSONObject);
                        } else {
                            webViewCallback.error(AdUnitError.NO_DISPLAY_CUTOUT_AVAILABLE, new Object[0]);
                        }
                        return;
                    } catch (IllegalAccessException e) {
                        e = e;
                        webViewCallback.error(AdUnitError.DISPLAY_CUTOUT_INVOKE_FAILED, new Object[0]);
                        DeviceLog.debug("Error while calling displayCutout getter", e);
                        return;
                    } catch (NoSuchMethodException e2) {
                        webViewCallback.error(AdUnitError.DISPLAY_CUTOUT_METHOD_NOT_AVAILABLE, new Object[0]);
                        DeviceLog.debug("Method getDisplayCutout not found", e2);
                        return;
                    } catch (InvocationTargetException e3) {
                        e = e3;
                        webViewCallback.error(AdUnitError.DISPLAY_CUTOUT_INVOKE_FAILED, new Object[0]);
                        DeviceLog.debug("Error while calling displayCutout getter", e);
                        return;
                    } catch (JSONException e4) {
                        webViewCallback.error(AdUnitError.DISPLAY_CUTOUT_JSON_ERROR, new Object[0]);
                        DeviceLog.debug("JSON error while constructing display cutout object", e4);
                        return;
                    }
                }
                webViewCallback.error(AdUnitError.NO_DISPLAY_CUTOUT_AVAILABLE, new Object[0]);
                return;
            }
            webViewCallback.error(AdUnitError.API_LEVEL_ERROR, new Object[0]);
            return;
        }
        webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void setLayoutInDisplayCutoutMode(final Integer num, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.AdUnit.6
            @Override // java.lang.Runnable
            public void run() {
                if (AdUnit.getAdUnitActivity() != null) {
                    AdUnit.getAdUnitActivity().setLayoutInDisplayCutoutMode(num.intValue());
                }
            }
        });
        if (getAdUnitActivity() != null) {
            webViewCallback.invoke(num);
        } else {
            webViewCallback.error(AdUnitError.ADUNIT_NULL, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] getViewList(JSONArray jSONArray) throws JSONException {
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.getString(i);
        }
        return strArr;
    }

    private static ArrayList<Integer> getKeyEventList(JSONArray jSONArray) throws JSONException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            Integer valueOf = Integer.valueOf(i);
            if (valueOf.intValue() >= jSONArray.length()) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(jSONArray.getInt(valueOf.intValue())));
            i = valueOf.intValue() + 1;
        }
    }
}

// ===== FILE: com/unity3d/services/ads/api/GMAScar.java =====
package com.unity3d.services.ads.api;

import com.unity3d.scar.adapter.common.scarads.UnityAdFormat;
import com.unity3d.services.ads.gmascar.GMA;
import com.unity3d.services.ads.gmascar.GMAScarAdapterBridge;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

/* loaded from: classes.dex */
public class GMAScar {
    private static final GMAScarAdapterBridge gmaScarAdapterBridge = GMA.getInstance().getBridge();

    @WebViewExposed
    public static void initializeScar(WebViewCallback webViewCallback) {
        gmaScarAdapterBridge.initializeScar();
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void getVersion(WebViewCallback webViewCallback) {
        gmaScarAdapterBridge.getVersion();
        webViewCallback.invoke(new Object[0]);
    }

    public static void isInitialized(WebViewCallback webViewCallback) {
        gmaScarAdapterBridge.isInitialized();
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void getSCARSignal(String str, String str2, WebViewCallback webViewCallback) {
        gmaScarAdapterBridge.getSCARSignal(str, UnityAdFormat.valueOf(str2.toUpperCase()));
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void load(String str, String str2, Boolean bool, String str3, String str4, Integer num, WebViewCallback webViewCallback) {
        gmaScarAdapterBridge.load(bool.booleanValue(), str, str2, str4, str3, num.intValue());
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void show(String str, String str2, Boolean bool, WebViewCallback webViewCallback) {
        gmaScarAdapterBridge.show(str, str2, bool.booleanValue());
        webViewCallback.invoke(new Object[0]);
    }
}

// ===== FILE: com/unity3d/services/ads/api/Load.java =====
package com.unity3d.services.ads.api;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.load.LoadModule;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

/* loaded from: classes.dex */
public class Load {
    @WebViewExposed
    public static void sendAdLoaded(String str, String str2, WebViewCallback webViewCallback) {
        LoadModule.getInstance().onUnityAdsAdLoaded(str2);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendAdFailedToLoad(String str, String str2, String str3, String str4, WebViewCallback webViewCallback) {
        LoadModule.getInstance().onUnityAdsFailedToLoad(str2, UnityAds.UnityAdsLoadError.valueOf(str3), str4);
        webViewCallback.invoke(new Object[0]);
    }
}

// ===== FILE: com/unity3d/services/ads/api/Measurements.java =====
package com.unity3d.services.ads.api;

import android.view.InputEvent;
import com.unity3d.services.ads.measurements.MeasurementsErrors;
import com.unity3d.services.ads.measurements.MeasurementsService;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

/* loaded from: classes.dex */
public class Measurements {
    private static final MeasurementsService measurementsService = (MeasurementsService) Utilities.getService(MeasurementsService.class);

    @WebViewExposed
    public static void checkAvailability(WebViewCallback webViewCallback) {
        measurementsService.checkAvailability();
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void registerView(String str, WebViewCallback webViewCallback) {
        measurementsService.registerView(str);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void registerClick(String str, WebViewCallback webViewCallback) {
        if (AdUnit.getAdUnitActivity() == null) {
            webViewCallback.error(MeasurementsErrors.ERROR_AD_UNIT_NULL, new Object[0]);
            return;
        }
        if (AdUnit.getAdUnitActivity().getLayout() == null) {
            webViewCallback.error(MeasurementsErrors.ERROR_LAYOUT_NULL, new Object[0]);
            return;
        }
        InputEvent lastInputEvent = AdUnit.getAdUnitActivity().getLayout().getLastInputEvent();
        if (lastInputEvent == null) {
            webViewCallback.error(MeasurementsErrors.ERROR_LAST_INPUT_EVENT_NULL, new Object[0]);
        } else {
            measurementsService.registerClick(str, lastInputEvent);
            webViewCallback.invoke(new Object[0]);
        }
    }
}

// ===== FILE: com/unity3d/services/ads/api/Show.java =====
package com.unity3d.services.ads.api;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.show.ShowModule;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

/* loaded from: classes.dex */
public class Show {
    @WebViewExposed
    public static void sendShowFailedEvent(String str, String str2, String str3, String str4, WebViewCallback webViewCallback) {
        ShowModule.getInstance().onUnityAdsShowFailure(str2, UnityAds.UnityAdsShowError.valueOf(str3), str4);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendShowConsentEvent(String str, String str2, WebViewCallback webViewCallback) {
        ShowModule.getInstance().onUnityAdsShowConsent(str2);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendShowStartEvent(String str, String str2, WebViewCallback webViewCallback) {
        ShowModule.getInstance().onUnityAdsShowStart(str2);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendShowClickEvent(String str, String str2, WebViewCallback webViewCallback) {
        ShowModule.getInstance().onUnityAdsShowClick(str2);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void sendShowCompleteEvent(String str, String str2, String str3, WebViewCallback webViewCallback) {
        ShowModule.getInstance().onUnityAdsShowComplete(str2, UnityAds.UnityAdsShowCompletionState.valueOf(str3));
        webViewCallback.invoke(new Object[0]);
    }
}

// ===== FILE: com/unity3d/services/ads/api/Token.java =====
package com.unity3d.services.ads.api;

import com.unity3d.services.ads.token.TokenError;
import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class Token {
    private static final TokenStorage tokenStorage = (TokenStorage) Utilities.getService(TokenStorage.class);

    @WebViewExposed
    public static void createTokens(JSONArray jSONArray, WebViewCallback webViewCallback) {
        try {
            tokenStorage.createTokens(jSONArray);
            webViewCallback.invoke(new Object[0]);
        } catch (JSONException e) {
            webViewCallback.error(TokenError.JSON_EXCEPTION, e.getMessage());
        }
    }

    @WebViewExposed
    public static void appendTokens(JSONArray jSONArray, WebViewCallback webViewCallback) {
        try {
            tokenStorage.appendTokens(jSONArray);
            webViewCallback.invoke(new Object[0]);
        } catch (JSONException e) {
            webViewCallback.error(TokenError.JSON_EXCEPTION, e.getMessage());
        }
    }

    @WebViewExposed
    public static void deleteTokens(WebViewCallback webViewCallback) {
        tokenStorage.deleteTokens();
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void getNativeGeneratedToken(WebViewCallback webViewCallback) {
        tokenStorage.getNativeGeneratedToken();
        webViewCallback.invoke(new Object[0]);
    }
}

// ===== FILE: com/unity3d/services/ads/api/Topics.java =====
package com.unity3d.services.ads.api;

import com.unity3d.services.ads.topics.TopicsService;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

/* loaded from: classes.dex */
public class Topics {
    private static final TopicsService topicsService = (TopicsService) Utilities.getService(TopicsService.class);

    @WebViewExposed
    public static void checkAvailability(WebViewCallback webViewCallback) {
        webViewCallback.invoke(topicsService.checkAvailability());
    }

    @WebViewExposed
    public static void getTopics(String str, Boolean bool, WebViewCallback webViewCallback) {
        topicsService.getTopics(str, bool.booleanValue());
        webViewCallback.invoke(new Object[0]);
    }
}

// ===== FILE: com/unity3d/services/ads/api/VideoPlayer.java =====
package com.unity3d.services.ads.api;

import com.unity3d.services.ads.video.VideoPlayerError;
import com.unity3d.services.ads.video.VideoPlayerEvent;
import com.unity3d.services.ads.video.VideoPlayerView;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

/* loaded from: classes.dex */
public class VideoPlayer {
    private static VideoPlayerView _videoPlayerView;

    public static void setVideoPlayerView(VideoPlayerView videoPlayerView) {
        _videoPlayerView = videoPlayerView;
    }

    public static VideoPlayerView getVideoPlayerView() {
        return _videoPlayerView;
    }

    @WebViewExposed
    public static void setProgressEventInterval(final Integer num, WebViewCallback webViewCallback) {
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.VideoPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.getVideoPlayerView() != null) {
                    VideoPlayer.getVideoPlayerView().setProgressEventInterval(num.intValue());
                }
            }
        });
        if (getVideoPlayerView() != null) {
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(VideoPlayerError.VIDEOVIEW_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getProgressEventInterval(WebViewCallback webViewCallback) {
        if (getVideoPlayerView() != null) {
            webViewCallback.invoke(Integer.valueOf(getVideoPlayerView().getProgressEventInterval()));
        } else {
            webViewCallback.error(VideoPlayerError.VIDEOVIEW_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void prepare(String str, Double d, WebViewCallback webViewCallback) {
        prepare(str, d, 0, webViewCallback);
    }

    @WebViewExposed
    public static void prepare(final String str, final Double d, final Integer num, WebViewCallback webViewCallback) {
        DeviceLog.debug("Preparing video for playback: " + str);
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.getVideoPlayerView() != null) {
                    VideoPlayer.getVideoPlayerView().prepare(str, d.floatValue(), num.intValue());
                }
            }
        });
        if (getVideoPlayerView() != null) {
            webViewCallback.invoke(str);
        } else {
            webViewCallback.error(VideoPlayerError.VIDEOVIEW_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void play(WebViewCallback webViewCallback) {
        DeviceLog.debug("Starting playback of prepared video");
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.VideoPlayer.3
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.getVideoPlayerView() != null) {
                    VideoPlayer.getVideoPlayerView().play();
                }
            }
        });
        if (getVideoPlayerView() != null) {
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(VideoPlayerError.VIDEOVIEW_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void pause(WebViewCallback webViewCallback) {
        DeviceLog.debug("Pausing current video");
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.VideoPlayer.4
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.getVideoPlayerView() != null) {
                    VideoPlayer.getVideoPlayerView().pause();
                }
            }
        });
        if (getVideoPlayerView() != null) {
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(VideoPlayerError.VIDEOVIEW_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void stop(WebViewCallback webViewCallback) {
        DeviceLog.debug("Stopping current video");
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.VideoPlayer.5
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.getVideoPlayerView() != null) {
                    VideoPlayer.getVideoPlayerView().stop();
                }
            }
        });
        if (getVideoPlayerView() != null) {
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(VideoPlayerError.VIDEOVIEW_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void seekTo(final Integer num, WebViewCallback webViewCallback) {
        DeviceLog.debug("Seeking video to time: " + num);
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.VideoPlayer.6
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.getVideoPlayerView() != null) {
                    VideoPlayer.getVideoPlayerView().seekTo(num.intValue());
                }
            }
        });
        if (getVideoPlayerView() != null) {
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(VideoPlayerError.VIDEOVIEW_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getCurrentPosition(WebViewCallback webViewCallback) {
        if (getVideoPlayerView() != null) {
            webViewCallback.invoke(Integer.valueOf(getVideoPlayerView().getCurrentPosition()));
        } else {
            webViewCallback.error(VideoPlayerError.VIDEOVIEW_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getVolume(WebViewCallback webViewCallback) {
        if (getVideoPlayerView() != null) {
            webViewCallback.invoke(Float.valueOf(getVideoPlayerView().getVolume()));
        } else {
            webViewCallback.error(VideoPlayerError.VIDEOVIEW_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setVolume(Double d, WebViewCallback webViewCallback) {
        DeviceLog.debug("Setting video volume: " + d);
        if (getVideoPlayerView() != null) {
            getVideoPlayerView().setVolume(Float.valueOf(d.floatValue()));
            webViewCallback.invoke(d);
        } else {
            webViewCallback.error(VideoPlayerError.VIDEOVIEW_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setInfoListenerEnabled(boolean z, WebViewCallback webViewCallback) {
        if (getVideoPlayerView() != null) {
            getVideoPlayerView().setInfoListenerEnabled(z);
            webViewCallback.invoke(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.INFO, Boolean.valueOf(z));
        } else {
            webViewCallback.error(VideoPlayerError.VIDEOVIEW_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getVideoViewRectangle(WebViewCallback webViewCallback) {
        VideoPlayerView videoPlayerView = getVideoPlayerView();
        if (videoPlayerView != null) {
            int[] videoViewRectangle = videoPlayerView.getVideoViewRectangle();
            webViewCallback.invoke(Integer.valueOf(videoViewRectangle[0]), Integer.valueOf(videoViewRectangle[1]), Integer.valueOf(videoViewRectangle[2]), Integer.valueOf(videoViewRectangle[3]));
        } else {
            webViewCallback.error(VideoPlayerError.VIDEOVIEW_NULL, new Object[0]);
        }
    }
}

// ===== FILE: com/unity3d/services/ads/api/WebPlayer.java =====
package com.unity3d.services.ads.api;

import com.unity3d.services.ads.webplayer.WebPlayerError;
import com.unity3d.services.ads.webplayer.WebPlayerEventBridge;
import com.unity3d.services.ads.webplayer.WebPlayerSettingsCache;
import com.unity3d.services.ads.webplayer.WebPlayerView;
import com.unity3d.services.ads.webplayer.WebPlayerViewCache;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class WebPlayer {
    @WebViewExposed
    public static void setUrl(final String str, String str2, WebViewCallback webViewCallback) {
        final WebPlayerView webPlayer = WebPlayerViewCache.getInstance().getWebPlayer(str2);
        if (webPlayer != null) {
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.WebPlayer.1
                @Override // java.lang.Runnable
                public void run() {
                    WebPlayerView.this.loadUrl(str);
                }
            });
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(WebPlayerError.WEBPLAYER_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setData(final String str, final String str2, final String str3, String str4, WebViewCallback webViewCallback) {
        final WebPlayerView webPlayer = WebPlayerViewCache.getInstance().getWebPlayer(str4);
        if (webPlayer != null) {
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.WebPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    WebPlayerView.this.loadData(str, str2, str3);
                }
            });
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(WebPlayerError.WEBPLAYER_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setDataWithUrl(final String str, final String str2, final String str3, final String str4, String str5, WebViewCallback webViewCallback) {
        final WebPlayerView webPlayer = WebPlayerViewCache.getInstance().getWebPlayer(str5);
        if (webPlayer != null) {
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.WebPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    WebPlayerView.this.loadDataWithBaseURL(str, str2, str3, str4, null);
                }
            });
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(WebPlayerError.WEBPLAYER_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setSettings(final JSONObject jSONObject, final JSONObject jSONObject2, String str, WebViewCallback webViewCallback) {
        WebPlayerSettingsCache.getInstance().addWebSettings(str, jSONObject);
        WebPlayerSettingsCache.getInstance().addWebPlayerSettings(str, jSONObject2);
        final WebPlayerView webPlayer = WebPlayerViewCache.getInstance().getWebPlayer(str);
        if (webPlayer != null) {
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.WebPlayer.4
                @Override // java.lang.Runnable
                public void run() {
                    WebPlayerView.this.setSettings(jSONObject, jSONObject2);
                }
            });
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(WebPlayerError.WEBPLAYER_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void setEventSettings(final JSONObject jSONObject, String str, WebViewCallback webViewCallback) {
        WebPlayerSettingsCache.getInstance().addWebPlayerEventSettings(str, jSONObject);
        final WebPlayerView webPlayer = WebPlayerViewCache.getInstance().getWebPlayer(str);
        if (webPlayer != null) {
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.WebPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    WebPlayerView.this.setEventSettings(jSONObject);
                }
            });
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(WebPlayerError.WEBPLAYER_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void clearSettings(String str, WebViewCallback webViewCallback) {
        WebPlayerSettingsCache webPlayerSettingsCache = WebPlayerSettingsCache.getInstance();
        webPlayerSettingsCache.removeWebSettings(str);
        webPlayerSettingsCache.removeWebPlayerSettings(str);
        webPlayerSettingsCache.removeWebPlayerEventSettings(str);
        final WebPlayerView webPlayer = WebPlayerViewCache.getInstance().getWebPlayer(str);
        if (webPlayer != null) {
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.WebPlayer.6
                @Override // java.lang.Runnable
                public void run() {
                    WebPlayerView.this.setSettings(new JSONObject(), new JSONObject());
                    WebPlayerView.this.setEventSettings(new JSONObject());
                }
            });
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(WebPlayerError.WEBPLAYER_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getErroredSettings(String str, WebViewCallback webViewCallback) {
        WebPlayerView webPlayer = WebPlayerViewCache.getInstance().getWebPlayer(str);
        if (webPlayer != null) {
            Map<String, String> erroredSettings = webPlayer.getErroredSettings();
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : erroredSettings.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception e) {
                DeviceLog.exception("Error forming JSON object", e);
            }
            webViewCallback.invoke(jSONObject);
            webViewCallback.invoke(new Object[0]);
            return;
        }
        webViewCallback.error(WebPlayerError.WEBPLAYER_NULL, new Object[0]);
    }

    @WebViewExposed
    public static void sendEvent(JSONArray jSONArray, String str, WebViewCallback webViewCallback) {
        WebPlayerView webPlayer = WebPlayerViewCache.getInstance().getWebPlayer(str);
        if (webPlayer != null) {
            webPlayer.sendEvent(jSONArray);
            webViewCallback.invoke(new Object[0]);
        } else {
            webViewCallback.error(WebPlayerError.WEBPLAYER_NULL, new Object[0]);
        }
    }

    @WebViewExposed
    public static void getFrame(final String str, final String str2, WebViewCallback webViewCallback) {
        webViewCallback.invoke(new Object[0]);
        final WebPlayerView webPlayer = WebPlayerViewCache.getInstance().getWebPlayer(str2);
        if (webPlayer != null) {
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.api.WebPlayer.7
                @Override // java.lang.Runnable
                public void run() {
                    int[] iArr = new int[2];
                    WebPlayerView.this.getLocationOnScreen(iArr);
                    WebPlayerEventBridge.sendGetFrameResponse(str, str2, iArr[0], iArr[1], WebPlayerView.this.getWidth(), WebPlayerView.this.getHeight(), WebPlayerView.this.getAlpha());
                }
            });
        }
    }
}
