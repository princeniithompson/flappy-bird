// Package bundle: com.unity3d.ads.metadata (4 classes)

// ============================================================
// CLASS: com.unity3d.ads.metadata.InAppPurchaseMetaData
// ============================================================
package com.unity3d.ads.metadata;

public class InAppPurchaseMetaData extends MetaData {
    public static final String IAP_KEY = "iap";
    public static final String KEY_CURRENCY = "currency";
    public static final String KEY_PRICE = "price";
    public static final String KEY_PRODUCT_ID = "productId";
    public static final String KEY_RECEIPT_PURCHASE_DATA = "receiptPurchaseData";
    public static final String KEY_SIGNATURE = "signature";

    public InAppPurchaseMetaData(Context p0) {
        new MetaData(p0);
        return;
    }

    public void commit() {
        StorageManager.init(_context);
        if (if-eqz(StorageManager.init(..))) goto L_54;
        StorageManager.getStorage(StorageManager$StorageType.PUBLIC);
        InAppPurchaseMetaData.getData();
        if (if-eqz(InAppPurchaseMetaData.getData(..))) goto L_59;
        if (if-eqz(StorageManager.getStorage(..))) goto L_59;
        StorageManager.getStorage(..).get("iap.purchases");
        if (if-eqz(Storage.get(..))) goto L_26;
        DeviceLog.error("Invalid object type for purchases");
      L_26:
      L_27:
        if (if-nez(0)) goto L_2e;
        new JSONArray();
      L_2e:
        InAppPurchaseMetaData.getData();
        System.currentTimeMillis();
        InAppPurchaseMetaData.getData(..).put("ts", System.currentTimeMillis(..), v6);
        new JSONArray(..).put(InAppPurchaseMetaData.getData(..));
        StorageManager.getStorage(..).set("iap.purchases", new JSONArray(..));
        StorageManager.getStorage(..).writeStorage();
        StorageManager.getStorage(..).get("iap.purchases");
        StorageManager.getStorage(..).sendEvent(StorageEvent.SET, Storage.get(..));
        DeviceLog.error("Error constructing purchase object");
        return;
      L_54:
        DeviceLog.error("Unity Ads could not commit metadata due to storage error or the data is null");
      L_59:
        return;
    }

    public boolean set(String p0, Object p1) {
        InAppPurchaseMetaData.setRaw(p0, p1);
        return InAppPurchaseMetaData.setRaw(..);
        throw InAppPurchaseMetaData.setRaw(..);
    }

    public void setCurrency(String p0) {
        InAppPurchaseMetaData.set("currency", p0);
        return;
    }

    public void setPrice(Double p0) {
        InAppPurchaseMetaData.set("price", p0);
        return;
    }

    public void setProductId(String p0) {
        InAppPurchaseMetaData.set("productId", p0);
        return;
    }

    public void setReceiptPurchaseData(String p0) {
        InAppPurchaseMetaData.set("receiptPurchaseData", p0);
        return;
    }

    public void setSignature(String p0) {
        InAppPurchaseMetaData.set("signature", p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.metadata.MediationMetaData
// ============================================================
package com.unity3d.ads.metadata;

public class MediationMetaData extends MetaData {
    public static final String KEY_MISSED_IMPRESSION_ORDINAL = "missedImpressionOrdinal";
    public static final String KEY_NAME = "name";
    public static final String KEY_ORDINAL = "ordinal";
    public static final String KEY_VERSION = "version";

    public MediationMetaData(Context p0) {
        new MetaData(p0);
        new MetaData(..).setCategory("mediation");
        return;
    }

    public void setMissedImpressionOrdinal(int p0) {
        Integer.valueOf(p0);
        MediationMetaData.set("missedImpressionOrdinal", Integer.valueOf(..));
        return;
    }

    public void setName(String p0) {
        MediationMetaData.set("name", p0);
        return;
    }

    public void setOrdinal(int p0) {
        Integer.valueOf(p0);
        MediationMetaData.set("ordinal", Integer.valueOf(..));
        return;
    }

    public void setVersion(String p0) {
        MediationMetaData.set("version", p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.metadata.MetaData
// ============================================================
package com.unity3d.ads.metadata;

public class MetaData extends JsonStorage {
    private String _category;
    protected Context _context;

    public MetaData(Context p0) {
        new JsonStorage();
        p0.getApplicationContext();
        _context = Context.getApplicationContext(..);
        return;
    }

    private String getActualKey(String p0) {
        MetaData.getCategory();
        if (if-eqz(MetaData.getCategory(..))) goto L_1e;
        new StringBuilder();
        MetaData.getCategory();
        new StringBuilder(..).append(MetaData.getCategory(..));
        new StringBuilder(..).append(".");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
      L_1e:
        return StringBuilder.toString(..);
    }

    private boolean set(String p0, int p1) {
        Integer.valueOf(p1);
        MetaData.set(p0, Integer.valueOf(..));
        return MetaData.set(..);
        throw MetaData.set(..);
    }

    private boolean set(String p0, long p1) {
        Long.valueOf(p1, v3);
        MetaData.set(p0, Long.valueOf(..));
        return MetaData.set(..);
        throw MetaData.set(..);
    }

    private boolean set(String p0, boolean p1) {
        Boolean.valueOf(p1);
        MetaData.set(p0, Boolean.valueOf(..));
        return MetaData.set(..);
        throw MetaData.set(..);
    }

    public void commit() {
        StorageManager.init(_context);
        if (if-eqz(StorageManager.init(..))) goto L_69;
        StorageManager.getStorage(StorageManager$StorageType.PUBLIC);
        MetaData.getData();
        if (if-eqz(MetaData.getData(..))) goto L_6e;
        if (if-eqz(StorageManager.getStorage(..))) goto L_6e;
        MetaData.getData();
        MetaData.getData(..).keys();
      L_1e:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_5c;
        JSONObject.keys(..).next();
        MetaData.get(Iterator.next(..));
        StorageManager.getStorage(..).get(Iterator.next(..));
        if (if-eqz(Storage.get(..))) goto L_58;
        StorageManager.getStorage(..).get(Iterator.next(..));
        if (if-eqz(Storage.get(..))) goto L_58;
        MetaData.get(Iterator.next(..));
        if (if-eqz(MetaData.get(..))) goto L_58;
        StorageManager.getStorage(..).get(Iterator.next(..));
        Utilities.mergeJsonObjects(MetaData.get(..), Storage.get(..));
        DeviceLog.exception("Exception merging JSONs", MetaData.get(..));
      L_58:
        StorageManager.getStorage(..).set(Iterator.next(..), Utilities.mergeJsonObjects(..));
      L_5c:
        StorageManager.getStorage(..).writeStorage();
        MetaData.getData();
        StorageManager.getStorage(..).sendEvent(StorageEvent.SET, MetaData.getData(..));
      L_69:
        DeviceLog.error("Unity Ads could not commit metadata due to storage error");
      L_6e:
        return;
    }

    public String getCategory() {
        return _category;
    }

    public boolean set(String p0, Object p1) {
        MetaData.initData();
        new StringBuilder();
        MetaData.getActualKey(p0);
        new StringBuilder(..).append(MetaData.getActualKey(..));
        new StringBuilder(..).append(".value");
        new StringBuilder(..).toString();
        JsonStorage.set(StringBuilder.toString(..), p1);
        if (if-eqz(JsonStorage.set(..))) goto L_44;
        new StringBuilder();
        MetaData.getActualKey(p0);
        new StringBuilder(..).append(MetaData.getActualKey(..));
        new StringBuilder(..).append(".ts");
        new StringBuilder(..).toString();
        System.currentTimeMillis();
        Long.valueOf(System.currentTimeMillis(..), ".value");
        JsonStorage.set(StringBuilder.toString(..), Long.valueOf(..));
        if (if-eqz(JsonStorage.set(..))) goto L_44;
      L_44:
      L_45:
        return 0;
        throw 0;
    }

    public void setCategory(String p0) {
        _category = p0;
        return;
    }

    protected boolean setRaw(String p0, Object p1) {
        MetaData.initData();
        MetaData.getActualKey(p0);
        JsonStorage.set(MetaData.getActualKey(..), p1);
        return JsonStorage.set(..);
        throw JsonStorage.set(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.metadata.PlayerMetaData
// ============================================================
package com.unity3d.ads.metadata;

public class PlayerMetaData extends MetaData {
    public static final String KEY_SERVER_ID = "server_id";

    public PlayerMetaData(Context p0) {
        new MetaData(p0);
        new MetaData(..).setCategory("player");
        return;
    }

    public void setServerId(String p0) {
        PlayerMetaData.set("server_id", p0);
        return;
    }

}

