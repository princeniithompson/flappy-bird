// Package bundle: com.unity3d.services.store.gpbl.bridges (15 classes)

// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.BillingResultBridge
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

public class BillingResultBridge extends GenericBridge {
    private static final String getResponseCodeMethodName = "getResponseCode";
    private final Object _billingResult;

    public BillingResultBridge(Object p0) {
        new BillingResultBridge$1();
        new GenericBridge(new BillingResultBridge$1(..));
        _billingResult = p0;
        return;
    }

    protected String getClassName() {
        return "com.android.billingclient.api.BillingResult";
    }

    public BillingResultResponseCode getResponseCode() {
        BillingResultBridge.callNonVoidMethod("getResponseCode", _billingResult, 0);
        Integer.intValue();
        BillingResultResponseCode.fromResponseCode(Integer.intValue(..));
        return BillingResultResponseCode.fromResponseCode(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.CommonJsonResponseBridge
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

public abstract class CommonJsonResponseBridge extends GenericBridge {
    private static final String getOriginalJsonMethodName = "getOriginalJson";
    private final Object _internalBridgeRef;

    protected CommonJsonResponseBridge(Object p0) {
        new HashMap();
        new CommonJsonResponseBridge(p0, new HashMap(..));
        return;
    }

    protected CommonJsonResponseBridge(Object p0, Map p1) {
        CommonJsonResponseBridge.appendCommonResponseMethods(p1);
        new GenericBridge(CommonJsonResponseBridge.appendCommonResponseMethods(..));
        _internalBridgeRef = p0;
        return;
    }

    private static Map appendCommonResponseMethods(Map p0) {
        new CommonJsonResponseBridge$1();
        p0.putAll(new CommonJsonResponseBridge$1(..));
        return p0;
    }

    public JSONObject getOriginalJson() {
        CommonJsonResponseBridge.callNonVoidMethod("getOriginalJson", _internalBridgeRef, v2);
        new JSONObject(CommonJsonResponseBridge.callNonVoidMethod(..));
        JSONException.getMessage();
        DeviceLog.error("Couldn't parse BillingResponse JSON : %s", 1);
      L_23:
        return 0;
    }

    public JSONObject toJson() {
        CommonJsonResponseBridge.getOriginalJson();
        return CommonJsonResponseBridge.getOriginalJson(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.PurchaseBridge
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

public class PurchaseBridge extends CommonJsonResponseBridge {
    private static final String getSignatureMethodName = "getSignature";
    private final Object _purchase;

    public PurchaseBridge(Object p0) {
        new PurchaseBridge$1();
        new CommonJsonResponseBridge(p0, new PurchaseBridge$1(..));
        _purchase = p0;
        return;
    }

    protected String getClassName() {
        return "com.android.billingclient.api.Purchase";
    }

    public String getSignature() {
        PurchaseBridge.callNonVoidMethod("getSignature", _purchase, 0);
        return PurchaseBridge.callNonVoidMethod(..);
    }

    public JSONObject toJson() {
        new JSONObject();
        PurchaseBridge.getOriginalJson();
        new JSONObject(..).put("purchaseData", PurchaseBridge.getOriginalJson(..));
        PurchaseBridge.getSignature();
        new JSONObject(..).put("signature", PurchaseBridge.getSignature(..));
        "signature".getMessage();
        DeviceLog.warning("Could not build Purchase result Json: ", 1);
      L_28:
        return new JSONObject(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.PurchaseHistoryRecordBridge
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

public class PurchaseHistoryRecordBridge extends CommonJsonResponseBridge {
    public PurchaseHistoryRecordBridge(Object p0) {
        new CommonJsonResponseBridge(p0);
        return;
    }

    protected String getClassName() {
        return "com.android.billingclient.api.PurchaseHistoryRecord";
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.PurchasesResultBridge
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

public class PurchasesResultBridge extends GenericBridge {
    private static final String getBillingResultMethodName = "getBillingResult";
    private static final String getPurchasesListMethodName = "getPurchasesList";
    private final Object _purchasesResult;

    public PurchasesResultBridge(Object p0) {
        new PurchasesResultBridge$1();
        new GenericBridge(new PurchasesResultBridge$1(..));
        _purchasesResult = p0;
        return;
    }

    public BillingResultBridge getBillingResult() {
        PurchasesResultBridge.callNonVoidMethod("getBillingResult", _purchasesResult, 0);
        new BillingResultBridge(PurchasesResultBridge.callNonVoidMethod(..));
        return new BillingResultBridge(..);
    }

    protected String getClassName() {
        return "com.android.billingclient.api.Purchase$PurchasesResult";
    }

    public List getPurchasesList() {
        PurchasesResultBridge.callNonVoidMethod("getPurchasesList", _purchasesResult, 0);
        new ArrayList();
        if (if-eqz(PurchasesResultBridge.callNonVoidMethod(..))) goto L_2b;
        List.iterator();
      L_18:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_2b;
        List.iterator(..).next();
        new PurchaseBridge(Iterator.next(..));
        new ArrayList(..).add(new PurchaseBridge(..));
      L_2b:
        return new ArrayList(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.SkuDetailsBridge
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

public class SkuDetailsBridge extends CommonJsonResponseBridge {
    public SkuDetailsBridge(Object p0) {
        new CommonJsonResponseBridge(p0);
        return;
    }

    protected String getClassName() {
        return "com.android.billingclient.api.SkuDetails";
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

public class SkuDetailsParamsBridge extends GenericBridge {
    private static final String newBuilderMethodName = "newBuilder";
    private static final Map staticMethods;
    private final Object _skuDetailsParamsInternalInstance;

    static <clinit>() {
        new SkuDetailsParamsBridge$1();
        staticMethods = new SkuDetailsParamsBridge$1(..);
        return;
    }

    public SkuDetailsParamsBridge(Object p0) {
        new SkuDetailsParamsBridge$2();
        new GenericBridge(new SkuDetailsParamsBridge$2(..));
        _skuDetailsParamsInternalInstance = p0;
        return;
    }

    public static Object callNonVoidStaticMethod(String p0, Object[] p1) {
        SkuDetailsParamsBridge.getClassForBridge();
        SkuDetailsParamsBridge.staticMethods.get(p0);
        Class.getMethod(p0, Map.get(..));
        Class.getMethod(..).invoke(0, p1);
        return Method.invoke(..);
    }

    public static Class getClassForBridge() {
        Class.forName("com.android.billingclient.api.SkuDetailsParams");
        return Class.forName(..);
    }

    public static SkuDetailsParamsBridge$BuilderBridge newBuilder() {
        SkuDetailsParamsBridge.callNonVoidStaticMethod("newBuilder", 0);
        new SkuDetailsParamsBridge$BuilderBridge(SkuDetailsParamsBridge.callNonVoidStaticMethod(..));
        return new SkuDetailsParamsBridge$BuilderBridge(..);
    }

    protected String getClassName() {
        return "com.android.billingclient.api.SkuDetailsParams";
    }

    public Object getInternalInstance() {
        return _skuDetailsParamsInternalInstance;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.BillingResultBridge$1
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

class BillingResultBridge$1 extends HashMap {
    BillingResultBridge$1() {
        new HashMap();
        new HashMap(..).put("getResponseCode", 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.CommonJsonResponseBridge$1
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

class CommonJsonResponseBridge$1 extends HashMap {
    CommonJsonResponseBridge$1() {
        new HashMap();
        new HashMap(..).put("getOriginalJson", 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.PurchaseBridge$1
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

class PurchaseBridge$1 extends HashMap {
    PurchaseBridge$1() {
        new HashMap();
        new HashMap(..).put("getSignature", 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.PurchasesResultBridge$1
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

class PurchasesResultBridge$1 extends HashMap {
    PurchasesResultBridge$1() {
        new HashMap();
        new HashMap(..).put("getBillingResult", v1);
        new HashMap(..).put("getPurchasesList", 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge$1
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

class SkuDetailsParamsBridge$1 extends HashMap {
    SkuDetailsParamsBridge$1() {
        new HashMap();
        new HashMap(..).put("newBuilder", 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge$2
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

class SkuDetailsParamsBridge$2 extends HashMap {
    SkuDetailsParamsBridge$2() {
        new HashMap();
        new HashMap(..).put("newBuilder", 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge$BuilderBridge
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

public class SkuDetailsParamsBridge$BuilderBridge extends GenericBridge {
    private static final String buildMethodName = "build";
    private static final String setSkusListMethodName = "setSkusList";
    private static final String setTypeMethodName = "setType";
    private Object _skuDetailsParamsBuilderInternalInstance;

    public SkuDetailsParamsBridge$BuilderBridge(Object p0) {
        new SkuDetailsParamsBridge$BuilderBridge$1();
        new GenericBridge(new SkuDetailsParamsBridge$BuilderBridge$1(..));
        _skuDetailsParamsBuilderInternalInstance = p0;
        return;
    }

    public SkuDetailsParamsBridge build() {
        SkuDetailsParamsBridge$BuilderBridge.callNonVoidMethod("build", _skuDetailsParamsBuilderInternalInstance, 0);
        new SkuDetailsParamsBridge(SkuDetailsParamsBridge$BuilderBridge.callNonVoidMethod(..));
        return new SkuDetailsParamsBridge(..);
    }

    protected String getClassName() {
        return "com.android.billingclient.api.SkuDetailsParams$Builder";
    }

    public SkuDetailsParamsBridge$BuilderBridge setSkuList(List p0) {
        SkuDetailsParamsBridge$BuilderBridge.callNonVoidMethod("setSkusList", _skuDetailsParamsBuilderInternalInstance, 1);
        _skuDetailsParamsBuilderInternalInstance = SkuDetailsParamsBridge$BuilderBridge.callNonVoidMethod(..);
        return this;
    }

    public SkuDetailsParamsBridge$BuilderBridge setType(String p0) {
        SkuDetailsParamsBridge$BuilderBridge.callNonVoidMethod("setType", _skuDetailsParamsBuilderInternalInstance, 1);
        _skuDetailsParamsBuilderInternalInstance = SkuDetailsParamsBridge$BuilderBridge.callNonVoidMethod(..);
        return this;
    }

}


// ============================================================
// CLASS: com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge$BuilderBridge$1
// ============================================================
package com.unity3d.services.store.gpbl.bridges;

class SkuDetailsParamsBridge$BuilderBridge$1 extends HashMap {
    SkuDetailsParamsBridge$BuilderBridge$1() {
        new HashMap();
        new HashMap(..).put("build", v1);
        new HashMap(..).put("setSkusList", "build");
        new HashMap(..).put("setType", 1);
        return;
    }

}

