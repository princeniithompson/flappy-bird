
// ===== FILE: com/unity3d/services/store/gpbl/bridges/BillingResultBridge.java =====
package com.unity3d.services.store.gpbl.bridges;

import com.unity3d.services.core.reflection.GenericBridge;
import com.unity3d.services.store.gpbl.BillingResultResponseCode;
import java.util.HashMap;

/* loaded from: classes.dex */
public class BillingResultBridge extends GenericBridge {
    private static final String getResponseCodeMethodName = "getResponseCode";
    private final Object _billingResult;

    @Override // com.unity3d.services.core.reflection.GenericBridge
    protected String getClassName() {
        return "com.android.billingclient.api.BillingResult";
    }

    public BillingResultBridge(Object obj) {
        super(new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.BillingResultBridge.1
            {
                put(BillingResultBridge.getResponseCodeMethodName, new Class[0]);
            }
        });
        this._billingResult = obj;
    }

    public BillingResultResponseCode getResponseCode() {
        return BillingResultResponseCode.fromResponseCode(((Integer) callNonVoidMethod(getResponseCodeMethodName, this._billingResult, new Object[0])).intValue());
    }
}

// ===== FILE: com/unity3d/services/store/gpbl/bridges/CommonJsonResponseBridge.java =====
package com.unity3d.services.store.gpbl.bridges;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.reflection.GenericBridge;
import com.unity3d.services.store.JsonSerializable;
import com.unity3d.services.store.gpbl.IBillingResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class CommonJsonResponseBridge extends GenericBridge implements IBillingResponse, JsonSerializable {
    private static final String getOriginalJsonMethodName = "getOriginalJson";
    private final Object _internalBridgeRef;

    protected CommonJsonResponseBridge(Object obj) {
        this(obj, new HashMap());
    }

    protected CommonJsonResponseBridge(Object obj, Map<String, Class<?>[]> map) {
        super(appendCommonResponseMethods(map));
        this._internalBridgeRef = obj;
    }

    private static Map<String, Class<?>[]> appendCommonResponseMethods(Map<String, Class<?>[]> map) {
        map.putAll(new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.CommonJsonResponseBridge.1
            {
                put(CommonJsonResponseBridge.getOriginalJsonMethodName, new Class[0]);
            }
        });
        return map;
    }

    @Override // com.unity3d.services.store.gpbl.IBillingResponse
    public JSONObject getOriginalJson() {
        try {
            return new JSONObject((String) callNonVoidMethod(getOriginalJsonMethodName, this._internalBridgeRef, new Object[0]));
        } catch (JSONException e) {
            DeviceLog.error("Couldn't parse BillingResponse JSON : %s", e.getMessage());
            return null;
        }
    }

    @Override // com.unity3d.services.store.JsonSerializable
    public JSONObject toJson() {
        return getOriginalJson();
    }
}

// ===== FILE: com/unity3d/services/store/gpbl/bridges/PurchaseBridge.java =====
package com.unity3d.services.store.gpbl.bridges;

import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.unity3d.services.core.log.DeviceLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PurchaseBridge extends CommonJsonResponseBridge {
    private static final String getSignatureMethodName = "getSignature";
    private final Object _purchase;

    @Override // com.unity3d.services.core.reflection.GenericBridge
    protected String getClassName() {
        return "com.android.billingclient.api.Purchase";
    }

    public PurchaseBridge(Object obj) {
        super(obj, new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.PurchaseBridge.1
            {
                put(PurchaseBridge.getSignatureMethodName, new Class[0]);
            }
        });
        this._purchase = obj;
    }

    public String getSignature() {
        return (String) callNonVoidMethod(getSignatureMethodName, this._purchase, new Object[0]);
    }

    @Override // com.unity3d.services.store.gpbl.bridges.CommonJsonResponseBridge, com.unity3d.services.store.JsonSerializable
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("purchaseData", getOriginalJson());
            jSONObject.put(InAppPurchaseMetaData.KEY_SIGNATURE, getSignature());
        } catch (JSONException e) {
            DeviceLog.warning("Could not build Purchase result Json: ", e.getMessage());
        }
        return jSONObject;
    }
}

// ===== FILE: com/unity3d/services/store/gpbl/bridges/PurchaseHistoryRecordBridge.java =====
package com.unity3d.services.store.gpbl.bridges;

/* loaded from: classes.dex */
public class PurchaseHistoryRecordBridge extends CommonJsonResponseBridge {
    @Override // com.unity3d.services.core.reflection.GenericBridge
    protected String getClassName() {
        return "com.android.billingclient.api.PurchaseHistoryRecord";
    }

    public PurchaseHistoryRecordBridge(Object obj) {
        super(obj);
    }
}

// ===== FILE: com/unity3d/services/store/gpbl/bridges/PurchasesResultBridge.java =====
package com.unity3d.services.store.gpbl.bridges;

import com.unity3d.services.core.reflection.GenericBridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class PurchasesResultBridge extends GenericBridge {
    private static final String getBillingResultMethodName = "getBillingResult";
    private static final String getPurchasesListMethodName = "getPurchasesList";
    private final Object _purchasesResult;

    @Override // com.unity3d.services.core.reflection.GenericBridge
    protected String getClassName() {
        return "com.android.billingclient.api.Purchase$PurchasesResult";
    }

    public PurchasesResultBridge(Object obj) {
        super(new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.PurchasesResultBridge.1
            {
                put(PurchasesResultBridge.getBillingResultMethodName, new Class[0]);
                put(PurchasesResultBridge.getPurchasesListMethodName, new Class[0]);
            }
        });
        this._purchasesResult = obj;
    }

    public BillingResultBridge getBillingResult() {
        return new BillingResultBridge(callNonVoidMethod(getBillingResultMethodName, this._purchasesResult, new Object[0]));
    }

    public List<PurchaseBridge> getPurchasesList() {
        List list = (List) callNonVoidMethod(getPurchasesListMethodName, this._purchasesResult, new Object[0]);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new PurchaseBridge(it.next()));
            }
        }
        return arrayList;
    }
}

// ===== FILE: com/unity3d/services/store/gpbl/bridges/SkuDetailsBridge.java =====
package com.unity3d.services.store.gpbl.bridges;

/* loaded from: classes.dex */
public class SkuDetailsBridge extends CommonJsonResponseBridge {
    @Override // com.unity3d.services.core.reflection.GenericBridge
    protected String getClassName() {
        return "com.android.billingclient.api.SkuDetails";
    }

    public SkuDetailsBridge(Object obj) {
        super(obj);
    }
}

// ===== FILE: com/unity3d/services/store/gpbl/bridges/SkuDetailsParamsBridge.java =====
package com.unity3d.services.store.gpbl.bridges;

import com.unity3d.services.core.reflection.GenericBridge;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class SkuDetailsParamsBridge extends GenericBridge {
    private static final String newBuilderMethodName = "newBuilder";
    private static final Map<String, Class<?>[]> staticMethods = new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge.1
        {
            put(SkuDetailsParamsBridge.newBuilderMethodName, new Class[0]);
        }
    };
    private final Object _skuDetailsParamsInternalInstance;

    @Override // com.unity3d.services.core.reflection.GenericBridge
    protected String getClassName() {
        return "com.android.billingclient.api.SkuDetailsParams";
    }

    public SkuDetailsParamsBridge(Object obj) {
        super(new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge.2
            {
                put(SkuDetailsParamsBridge.newBuilderMethodName, new Class[0]);
            }
        });
        this._skuDetailsParamsInternalInstance = obj;
    }

    public Object getInternalInstance() {
        return this._skuDetailsParamsInternalInstance;
    }

    public static BuilderBridge newBuilder() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        return new BuilderBridge(callNonVoidStaticMethod(newBuilderMethodName, new Object[0]));
    }

    public static Object callNonVoidStaticMethod(String str, Object... objArr) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        return getClassForBridge().getMethod(str, staticMethods.get(str)).invoke(null, objArr);
    }

    public static Class<?> getClassForBridge() throws ClassNotFoundException {
        return Class.forName("com.android.billingclient.api.SkuDetailsParams");
    }

    public static class BuilderBridge extends GenericBridge {
        private static final String buildMethodName = "build";
        private static final String setSkusListMethodName = "setSkusList";
        private static final String setTypeMethodName = "setType";
        private Object _skuDetailsParamsBuilderInternalInstance;

        @Override // com.unity3d.services.core.reflection.GenericBridge
        protected String getClassName() {
            return "com.android.billingclient.api.SkuDetailsParams$Builder";
        }

        public BuilderBridge(Object obj) {
            super(new HashMap<String, Class<?>[]>() { // from class: com.unity3d.services.store.gpbl.bridges.SkuDetailsParamsBridge.BuilderBridge.1
                {
                    put(BuilderBridge.buildMethodName, new Class[0]);
                    put(BuilderBridge.setSkusListMethodName, new Class[]{List.class});
                    put(BuilderBridge.setTypeMethodName, new Class[]{String.class});
                }
            });
            this._skuDetailsParamsBuilderInternalInstance = obj;
        }

        public BuilderBridge setSkuList(List<String> list) {
            this._skuDetailsParamsBuilderInternalInstance = callNonVoidMethod(setSkusListMethodName, this._skuDetailsParamsBuilderInternalInstance, list);
            return this;
        }

        public BuilderBridge setType(String str) {
            this._skuDetailsParamsBuilderInternalInstance = callNonVoidMethod(setTypeMethodName, this._skuDetailsParamsBuilderInternalInstance, str);
            return this;
        }

        public SkuDetailsParamsBridge build() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
            return new SkuDetailsParamsBridge(callNonVoidMethod(buildMethodName, this._skuDetailsParamsBuilderInternalInstance, new Object[0]));
        }
    }
}
