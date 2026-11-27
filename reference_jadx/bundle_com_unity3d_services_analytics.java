
// ===== FILE: com/unity3d/services/analytics/AcquisitionType.java =====
package com.unity3d.services.analytics;

/* loaded from: classes.dex */
public enum AcquisitionType {
    SOFT,
    PREMIUM;

    /* renamed from: com.unity3d.services.analytics.AcquisitionType$1 */
    static /* synthetic */ class C10991 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$analytics$AcquisitionType;

        static {
            int[] iArr = new int[AcquisitionType.values().length];
            $SwitchMap$com$unity3d$services$analytics$AcquisitionType = iArr;
            try {
                iArr[AcquisitionType.SOFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$services$analytics$AcquisitionType[AcquisitionType.PREMIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = C10991.$SwitchMap$com$unity3d$services$analytics$AcquisitionType[ordinal()];
        return i != 1 ? i != 2 ? "" : "premium" : "soft";
    }
}

// ===== FILE: com/unity3d/services/analytics/UnityAnalytics.java =====
package com.unity3d.services.analytics;

import androidx.core.app.NotificationCompat;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class UnityAnalytics {
    protected static JSONArray eventQueue = new JSONArray();

    private enum AnalyticsEventType {
        POSTEVENT
    }

    private static JSONObject createItemAcquired(String str, Float f, String str2, Float f2, String str3, String str4, String str5, AcquisitionType acquisitionType) {
        HashMap hashMap = new HashMap();
        hashMap.put("currency_type", acquisitionType.toString());
        hashMap.put("transaction_context", str);
        hashMap.put("amount", f);
        hashMap.put("item_id", str2);
        hashMap.put("balance", f2);
        hashMap.put("item_type", str3);
        hashMap.put("level", str4);
        hashMap.put("transaction_id", str5);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("custom_params", hashMap);
        hashMap2.put("ts", 1533594423477L);
        hashMap2.put(MediationMetaData.KEY_NAME, "item_acquired");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("type", "analytics.custom.v1");
        hashMap3.put(NotificationCompat.CATEGORY_MESSAGE, hashMap2);
        return new JSONObject(hashMap3);
    }

    private static JSONObject createItemSpent(String str, Float f, String str2, Float f2, String str3, String str4, String str5, AcquisitionType acquisitionType) {
        HashMap hashMap = new HashMap();
        hashMap.put("currency_type", acquisitionType.toString());
        hashMap.put("transaction_context", str);
        hashMap.put("amount", f);
        hashMap.put("item_id", str2);
        hashMap.put("balance", f2);
        hashMap.put("item_type", str3);
        hashMap.put("level", str4);
        hashMap.put("transaction_id", str5);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("custom_params", hashMap);
        hashMap2.put("ts", Long.valueOf(new Date().getTime()));
        hashMap2.put(MediationMetaData.KEY_NAME, "item_spent");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("type", "analytics.custom.v1");
        hashMap3.put(NotificationCompat.CATEGORY_MESSAGE, hashMap2);
        return new JSONObject(hashMap3);
    }

    private static JSONObject createLevelFail(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("level_index", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("custom_params", hashMap);
        hashMap2.put("ts", Long.valueOf(new Date().getTime()));
        hashMap2.put(MediationMetaData.KEY_NAME, "level_fail");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("type", "analytics.custom.v1");
        hashMap3.put(NotificationCompat.CATEGORY_MESSAGE, hashMap2);
        return new JSONObject(hashMap3);
    }

    private static JSONObject createLevelUp(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("new_level_index", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("custom_params", hashMap);
        hashMap2.put("ts", Long.valueOf(new Date().getTime()));
        hashMap2.put(MediationMetaData.KEY_NAME, "level_up");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("type", "analytics.custom.v1");
        hashMap3.put(NotificationCompat.CATEGORY_MESSAGE, hashMap2);
        return new JSONObject(hashMap3);
    }

    private static JSONObject createAdComplete(String str, String str2, Boolean bool) {
        HashMap hashMap = new HashMap();
        hashMap.put("rewarded", bool);
        hashMap.put("network", str);
        hashMap.put("placement_id", str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("custom_params", hashMap);
        hashMap2.put("ts", Long.valueOf(new Date().getTime()));
        hashMap2.put(MediationMetaData.KEY_NAME, "ad_complete");
        HashMap hashMap3 = new HashMap();
        hashMap3.put("type", "analytics.custom.v1");
        hashMap3.put(NotificationCompat.CATEGORY_MESSAGE, hashMap2);
        return new JSONObject(hashMap3);
    }

    private static JSONObject createIapTransaction(String str, Float f, String str2, Boolean bool, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("ts", Long.valueOf(new Date().getTime()));
        hashMap.put("productid", str);
        hashMap.put("amount", f);
        hashMap.put(InAppPurchaseMetaData.KEY_CURRENCY, str2);
        hashMap.put(NotificationCompat.CATEGORY_PROMO, bool);
        hashMap.put("receipt", str3);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("type", "analytics.transaction.v1");
        hashMap2.put(NotificationCompat.CATEGORY_MESSAGE, hashMap);
        return new JSONObject(hashMap2);
    }

    public static void onItemAcquired(String str, Float f, String str2, Float f2, String str3, String str4, String str5, AcquisitionType acquisitionType) {
        postEvent(createItemAcquired(str, f, str2, f2, str3, str4, str5, acquisitionType));
    }

    public static void onItemSpent(String str, Float f, String str2, Float f2, String str3, String str4, String str5, AcquisitionType acquisitionType) {
        postEvent(createItemSpent(str, f, str2, f2, str3, str4, str5, acquisitionType));
    }

    public static void onLevelFail(String str) {
        postEvent(createLevelFail(str));
    }

    public static void onLevelUp(String str) {
        postEvent(createLevelUp(str));
    }

    public static void onAdComplete(String str, String str2, Boolean bool) {
        postEvent(createAdComplete(str, str2, bool));
    }

    public static void onIapTransaction(String str, Float f, String str2, Boolean bool, String str3) {
        postEvent(createIapTransaction(str, f, str2, bool, str3));
    }

    public static void onEvent(JSONObject jSONObject) {
        postEvent(jSONObject);
    }

    private static synchronized void postEvent(JSONObject jSONObject) {
        synchronized (UnityAnalytics.class) {
            if (eventQueue.length() < 200) {
                eventQueue.put(jSONObject);
            }
            WebViewApp currentApp = WebViewApp.getCurrentApp();
            if (currentApp != null && Boolean.valueOf(currentApp.sendEvent(WebViewEventCategory.ANALYTICS, AnalyticsEventType.POSTEVENT, eventQueue.toString())).booleanValue()) {
                eventQueue = new JSONArray();
            }
        }
    }
}
