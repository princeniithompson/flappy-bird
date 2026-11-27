// Package bundle: com.unity3d.services.analytics (4 classes)

// ============================================================
// CLASS: com.unity3d.services.analytics.AcquisitionType
// ============================================================
package com.unity3d.services.analytics;

public final class AcquisitionType extends Enum {
    private static final AcquisitionType[] $VALUES;
    public static final AcquisitionType PREMIUM;
    public static final AcquisitionType SOFT;

    private static AcquisitionType[] $values() {
        return 2;
    }

    static <clinit>() {
        new AcquisitionType("SOFT", 0);
        SOFT = new AcquisitionType(..);
        new AcquisitionType("PREMIUM", 1);
        PREMIUM = new AcquisitionType(..);
        AcquisitionType.$values();
        $VALUES = AcquisitionType.$values(..);
        return;
    }

    private AcquisitionType(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static AcquisitionType valueOf(String p0) {
        Enum.valueOf(AcquisitionType.class, p0);
        return Enum.valueOf(..);
    }

    public static AcquisitionType[] values() {
        AcquisitionType.$VALUES.clone();
        return AcquisitionType[].clone(..);
    }

    public String toString() {
        AcquisitionType.ordinal();
        if (if-eq(AcquisitionType$1.$SwitchMap$com$unity3d$services$analytics$AcquisitionType, 1)) goto L_14;
        if (if-eq(AcquisitionType$1.$SwitchMap$com$unity3d$services$analytics$AcquisitionType, 2)) goto L_11;
        return "";
      L_11:
        return "premium";
      L_14:
        return "soft";
    }

}


// ============================================================
// CLASS: com.unity3d.services.analytics.UnityAnalytics
// ============================================================
package com.unity3d.services.analytics;

public class UnityAnalytics {
    protected static JSONArray eventQueue;

    static <clinit>() {
        new JSONArray();
        eventQueue = new JSONArray(..);
        return;
    }

    public UnityAnalytics() {
        new Object();
        return;
    }

    private static JSONObject createAdComplete(String p0, String p1, Boolean p2) {
        new HashMap();
        new HashMap(..).put("rewarded", p2);
        new HashMap(..).put("network", p0);
        new HashMap(..).put("placement_id", p1);
        new HashMap();
        new HashMap(..).put("custom_params", new HashMap(..));
        new Date();
        new Date(..).getTime();
        Long.valueOf(Date.getTime(..), "network");
        new HashMap(..).put("ts", Long.valueOf(..));
        new HashMap(..).put("name", "ad_complete");
        new HashMap();
        new HashMap(..).put("type", "analytics.custom.v1");
        new HashMap(..).put("msg", new HashMap(..));
        new JSONObject(new HashMap(..));
        return new JSONObject(..);
    }

    private static JSONObject createIapTransaction(String p0, Float p1, String p2, Boolean p3, String p4) {
        new HashMap();
        new Date();
        new Date(..).getTime();
        Long.valueOf(Date.getTime(..), v2);
        new HashMap(..).put("ts", Long.valueOf(..));
        new HashMap(..).put("productid", p0);
        new HashMap(..).put("amount", p1);
        new HashMap(..).put("currency", p2);
        new HashMap(..).put("promo", p3);
        new HashMap(..).put("receipt", p4);
        new HashMap();
        new HashMap(..).put("type", "analytics.transaction.v1");
        new HashMap(..).put("msg", new HashMap(..));
        new JSONObject(new HashMap(..));
        return new JSONObject(..);
    }

    private static JSONObject createItemAcquired(String p0, Float p1, String p2, Float p3, String p4, String p5, String p6, AcquisitionType p7) {
        new HashMap();
        p7.toString();
        new HashMap(..).put("currency_type", AcquisitionType.toString(..));
        new HashMap(..).put("transaction_context", p0);
        new HashMap(..).put("amount", p1);
        new HashMap(..).put("item_id", p2);
        new HashMap(..).put("balance", p3);
        new HashMap(..).put("item_type", p4);
        new HashMap(..).put("level", p5);
        new HashMap(..).put("transaction_id", p6);
        new HashMap();
        new HashMap(..).put("custom_params", new HashMap(..));
        Long.valueOf(0x1651159d0b5L, p2);
        new HashMap(..).put("ts", Long.valueOf(..));
        new HashMap(..).put("name", "item_acquired");
        new HashMap();
        new HashMap(..).put("type", "analytics.custom.v1");
        new HashMap(..).put("msg", new HashMap(..));
        new JSONObject(new HashMap(..));
        return new JSONObject(..);
    }

    private static JSONObject createItemSpent(String p0, Float p1, String p2, Float p3, String p4, String p5, String p6, AcquisitionType p7) {
        new HashMap();
        p7.toString();
        new HashMap(..).put("currency_type", AcquisitionType.toString(..));
        new HashMap(..).put("transaction_context", p0);
        new HashMap(..).put("amount", p1);
        new HashMap(..).put("item_id", p2);
        new HashMap(..).put("balance", p3);
        new HashMap(..).put("item_type", p4);
        new HashMap(..).put("level", p5);
        new HashMap(..).put("transaction_id", p6);
        new HashMap();
        new HashMap(..).put("custom_params", new HashMap(..));
        new Date();
        new Date(..).getTime();
        Long.valueOf(Date.getTime(..), p2);
        new HashMap(..).put("ts", Long.valueOf(..));
        new HashMap(..).put("name", "item_spent");
        new HashMap();
        new HashMap(..).put("type", "analytics.custom.v1");
        new HashMap(..).put("msg", new HashMap(..));
        new JSONObject(new HashMap(..));
        return new JSONObject(..);
    }

    private static JSONObject createLevelFail(String p0) {
        new HashMap();
        new HashMap(..).put("level_index", p0);
        new HashMap();
        new HashMap(..).put("custom_params", new HashMap(..));
        new Date();
        new Date(..).getTime();
        Long.valueOf(Date.getTime(..), "custom_params");
        new HashMap(..).put("ts", Long.valueOf(..));
        new HashMap(..).put("name", "level_fail");
        new HashMap();
        new HashMap(..).put("type", "analytics.custom.v1");
        new HashMap(..).put("msg", new HashMap(..));
        new JSONObject(new HashMap(..));
        return new JSONObject(..);
    }

    private static JSONObject createLevelUp(String p0) {
        new HashMap();
        new HashMap(..).put("new_level_index", p0);
        new HashMap();
        new HashMap(..).put("custom_params", new HashMap(..));
        new Date();
        new Date(..).getTime();
        Long.valueOf(Date.getTime(..), "custom_params");
        new HashMap(..).put("ts", Long.valueOf(..));
        new HashMap(..).put("name", "level_up");
        new HashMap();
        new HashMap(..).put("type", "analytics.custom.v1");
        new HashMap(..).put("msg", new HashMap(..));
        new JSONObject(new HashMap(..));
        return new JSONObject(..);
    }

    public static void onAdComplete(String p0, String p1, Boolean p2) {
        UnityAnalytics.createAdComplete(p0, p1, p2);
        UnityAnalytics.postEvent(UnityAnalytics.createAdComplete(..));
        return;
    }

    public static void onEvent(JSONObject p0) {
        UnityAnalytics.postEvent(p0);
        return;
    }

    public static void onIapTransaction(String p0, Float p1, String p2, Boolean p3, String p4) {
        UnityAnalytics.createIapTransaction(p0, p1, p2, p3, p4);
        UnityAnalytics.postEvent(UnityAnalytics.createIapTransaction(..));
        return;
    }

    public static void onItemAcquired(String p0, Float p1, String p2, Float p3, String p4, String p5, String p6, AcquisitionType p7) {
        UnityAnalytics.createItemAcquired(p0, p1, p2, p3, p4, p5, p6, p7);
        UnityAnalytics.postEvent(UnityAnalytics.createItemAcquired(..));
        return;
    }

    public static void onItemSpent(String p0, Float p1, String p2, Float p3, String p4, String p5, String p6, AcquisitionType p7) {
        UnityAnalytics.createItemSpent(p0, p1, p2, p3, p4, p5, p6, p7);
        UnityAnalytics.postEvent(UnityAnalytics.createItemSpent(..));
        return;
    }

    public static void onLevelFail(String p0) {
        UnityAnalytics.createLevelFail(p0);
        UnityAnalytics.postEvent(UnityAnalytics.createLevelFail(..));
        return;
    }

    public static void onLevelUp(String p0) {
        UnityAnalytics.createLevelUp(p0);
        UnityAnalytics.postEvent(UnityAnalytics.createLevelUp(..));
        return;
    }

    private static void postEvent(JSONObject p0) {
        UnityAnalytics.eventQueue.length();
        if (if-ge(JSONArray.length(..), 200)) goto L_12;
        UnityAnalytics.eventQueue.put(p0);
      L_12:
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_3d;
        UnityAnalytics.eventQueue.toString();
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.ANALYTICS, UnityAnalytics$AnalyticsEventType.POSTEVENT, 1);
        Boolean.valueOf(WebViewApp.sendEvent(..));
        Boolean.valueOf(..).booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_3d;
        new JSONArray();
        eventQueue = new JSONArray(..);
      L_3d:
        return;
        throw new JSONArray(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.analytics.AcquisitionType$1
// ============================================================
package com.unity3d.services.analytics;

class AcquisitionType$1 {
    static final int[] $SwitchMap$com$unity3d$services$analytics$AcquisitionType;

    static <clinit>() {
        AcquisitionType.values();
        $SwitchMap$com$unity3d$services$analytics$AcquisitionType = AcquisitionType.values(..);
        AcquisitionType.SOFT.ordinal();
        AcquisitionType.PREMIUM.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.analytics.UnityAnalytics$AnalyticsEventType
// ============================================================
package com.unity3d.services.analytics;

final class UnityAnalytics$AnalyticsEventType extends Enum {
    private static final UnityAnalytics$AnalyticsEventType[] $VALUES;
    public static final UnityAnalytics$AnalyticsEventType POSTEVENT;

    private static UnityAnalytics$AnalyticsEventType[] $values() {
        return 1;
    }

    static <clinit>() {
        new UnityAnalytics$AnalyticsEventType("POSTEVENT", 0);
        POSTEVENT = new UnityAnalytics$AnalyticsEventType(..);
        UnityAnalytics$AnalyticsEventType.$values();
        $VALUES = UnityAnalytics$AnalyticsEventType.$values(..);
        return;
    }

    private UnityAnalytics$AnalyticsEventType(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static UnityAnalytics$AnalyticsEventType valueOf(String p0) {
        Enum.valueOf(UnityAnalytics$AnalyticsEventType.class, p0);
        return Enum.valueOf(..);
    }

    public static UnityAnalytics$AnalyticsEventType[] values() {
        UnityAnalytics$AnalyticsEventType[].clone();
        return UnityAnalytics$AnalyticsEventType[].clone(..);
    }

}

