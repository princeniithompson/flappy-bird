// Package bundle: com.unity3d.services.core.misc (12 classes)

// ============================================================
// CLASS: com.unity3d.services.core.misc.EventSubject
// ============================================================
package com.unity3d.services.core.misc;

public class EventSubject {
    private IEventListener _eventListener;
    Queue _eventQueue;
    IIntervalTimer _intervalTimer;

    public EventSubject(Queue p0, Integer p1, IIntervalTimerFactory p2) {
        new Object();
        _eventQueue = p0;
        p0.size();
        Integer.valueOf(Queue.size(..));
        new EventSubject$1(new Object(..));
        p2.createTimer(p1, Integer.valueOf(..), new EventSubject$1(..));
        _intervalTimer = IIntervalTimerFactory.createTimer(..);
        return;
    }

    private void killTimer() {
        if (if-eqz(_intervalTimer)) goto L_a;
        _intervalTimer.kill();
        _intervalTimer = 0;
      L_a:
        return;
    }

    private void startTimer() {
        if (if-eqz(_intervalTimer)) goto L_b;
        Executors.newSingleThreadScheduledExecutor();
        _intervalTimer.start(Executors.newSingleThreadScheduledExecutor(..));
      L_b:
        return;
    }

    public boolean eventQueueIsEmpty() {
        _eventQueue.isEmpty();
        return Queue.isEmpty(..);
    }

    public void sendNextEvent() {
        if (if-eqz(_eventListener)) goto L_d;
        _eventQueue.remove();
        _eventListener.onNextEvent(Queue.remove(..));
      L_d:
        _eventQueue.size();
        if (if-gtz(Queue.size(..))) goto L_18;
        EventSubject.unsubscribe();
      L_18:
        return;
    }

    public void subscribe(IEventListener p0) {
        if (if-eqz(_eventQueue)) goto L_16;
        _eventQueue.size();
        if (if-lez(Queue.size(..))) goto L_16;
        if (if-eqz(_intervalTimer)) goto L_16;
        if (if-nez(p0)) goto L_11;
      L_11:
        _eventListener = p0;
        EventSubject.startTimer();
      L_16:
        return;
    }

    public void unsubscribe() {
        EventSubject.killTimer();
        _eventListener = 0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.misc.IEventListener
// ============================================================
package com.unity3d.services.core.misc;

public abstract class IEventListener {
    public abstract void onNextEvent(Object p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.misc.IJsonStorageReader
// ============================================================
package com.unity3d.services.core.misc;

public abstract class IJsonStorageReader {
    public abstract Object get(String p0) {
        // native or abstract
    }

    public abstract JSONObject getData() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.misc.IObserver
// ============================================================
package com.unity3d.services.core.misc;

public abstract class IObserver {
    public abstract void updated(Object p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.misc.JsonFlattener
// ============================================================
package com.unity3d.services.core.misc;

public class JsonFlattener {
    private final JSONObject _jsonData;

    public JsonFlattener(JSONObject p0) {
        new Object();
        _jsonData = p0;
        return;
    }

    private boolean shouldIncludeKey(String p0, List p1, List p2) {
        p2.contains(p0);
        if (if-eqz(List.contains(..))) goto L_8;
        return 0;
      L_8:
        p1.size();
        if (if-gtz(List.size(..))) goto L_f;
        return 0;
      L_f:
        p1.contains(p0);
        return List.contains(..);
    }

    public JSONObject flattenJson(String p0, JsonFlattenerRules p1) {
        if (if-nez(p1)) goto L_8;
        new JSONObject();
        return new JSONObject(..);
      L_8:
        p1.getTopLevelToInclude();
        p1.getReduceKeys();
        p1.getSkipKeys();
        JsonFlattener.flattenJson(new JSONObject(..), JsonFlattenerRules.getTopLevelToInclude(..), JsonFlattenerRules.getReduceKeys(..), JsonFlattenerRules.getSkipKeys(..));
        return JsonFlattener.flattenJson(..);
    }

    public JSONObject flattenJson(String p0, List p1, List p2, List p3) {
        new JSONObject();
        _jsonData.keys();
      L_b:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_4d;
        JSONObject.keys(..).next();
        JsonFlattener.shouldIncludeKey(Iterator.next(..), p1, p3);
        if (if-nez(JsonFlattener.shouldIncludeKey(..))) goto L_1f;
      L_1f:
        _jsonData.opt(Iterator.next(..));
        if (if-eqz(v1)) goto L_39;
        new JsonFlattener(JSONObject.opt(..));
        new JsonFlattener(..).flattenJson(p0, Iterator.next(..), new JSONObject(..), p2, p3);
      L_39:
        new JSONObject(..).put(Iterator.next(..), new JsonFlattener(..));
        p0.getMessage();
        DeviceLog.error("Could not flatten JSON: %s", 1);
      L_4d:
        return new JSONObject(..);
    }

    public void flattenJson(String p0, String p1, JSONObject p2, List p3, List p4) {
        _jsonData.keys();
      L_6:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_51;
        JSONObject.keys(..).next();
        p4.contains(Iterator.next(..));
        if (if-eqz(List.contains(..))) goto L_19;
      L_19:
        _jsonData.get(Iterator.next(..));
        p3.contains(Iterator.next(..));
        if (if-eqz(List.contains(..))) goto L_27;
      L_27:
        String.format("%s%s%s", 3);
      L_3a:
        if (if-eqz(String.format(..))) goto L_4d;
        new JsonFlattener(JSONObject.get(..));
        new JsonFlattener(..).flattenJson(p0, String.format(..), p2, p3, p4);
      L_4d:
        p2.put(String.format(..), JSONObject.get(..));
      L_51:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.misc.JsonFlattenerRules
// ============================================================
package com.unity3d.services.core.misc;

public class JsonFlattenerRules {
    List _reduceKeys;
    List _skipKeys;
    List _topLevelToInclude;

    public JsonFlattenerRules(List p0, List p1, List p2) {
        new Object();
        _topLevelToInclude = p0;
        _reduceKeys = p1;
        _skipKeys = p2;
        return;
    }

    public List getReduceKeys() {
        return _reduceKeys;
    }

    public List getSkipKeys() {
        return _skipKeys;
    }

    public List getTopLevelToInclude() {
        return _topLevelToInclude;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.misc.JsonStorage
// ============================================================
package com.unity3d.services.core.misc;

public class JsonStorage {
    private JSONObject _data;

    public JsonStorage() {
        new Object();
        return;
    }

    private void createObjectTree(String p0) {
        p0.split("\\.");
        p0.length();
        if (if-nez(String.length(..))) goto L_11;
        return;
      L_11:
      L_12:
        if (if-ge(0, v2)) goto L_46;
        _data.has(v2);
        if (if-nez(JSONObject.has(..))) goto L_36;
        new JSONObject();
        _data.put(JSONObject.has(..), new JSONObject(..));
        JSONObject.put(..).getJSONObject(JSONObject.has(..));
        DeviceLog.exception("Couldn't create new JSONObject", JSONObject.has(..));
      L_36:
        JSONObject.getJSONObject(..).getJSONObject(JSONObject.has(..));
        DeviceLog.exception("Couldn't get existing JSONObject", JSONObject.has(..));
      L_43:
      L_46:
        return;
        throw 0;
    }

    private Object findObject(String p0) {
        p0.split("\\.");
        p0.length();
        if (if-nez(String.length(..))) goto L_11;
        return _data;
      L_11:
      L_12:
        if (if-ge(0, v2)) goto L_42;
        _data.has(v2);
        if (if-eqz(JSONObject.has(..))) goto L_40;
        _data.getJSONObject(JSONObject.has(..));
        new StringBuilder();
        new StringBuilder(..).append("Couldn't read JSONObject: ");
        new StringBuilder(..).append(0);
        new StringBuilder(..).toString();
        DeviceLog.exception(StringBuilder.toString(..), JSONObject.getJSONObject(..));
        return 0;
      L_40:
        return 0;
      L_42:
        return JSONObject.getJSONObject(..);
        throw StringBuilder.toString(..);
    }

    private String getParentObjectTreeFor(String p0) {
        p0.split("\\.");
        Arrays.asList(String.split(..));
        new ArrayList(Arrays.asList(..));
        new ArrayList(..).size();
        new ArrayList(..).remove(ArrayList.size(..));
        new ArrayList(..).toArray();
        TextUtils.join(".", ArrayList.toArray(..));
        return TextUtils.join(..);
        throw TextUtils.join(..);
    }

    public void clearData() {
        _data = 0;
        return;
        throw 0;
    }

    public boolean delete(String p0) {
        if (if-nez(_data)) goto L_d;
        DeviceLog.error("Data is NULL, readStorage probably not called");
        return 0;
      L_d:
        String.split("\\.");
        JsonStorage.getParentObjectTreeFor("Data is NULL, readStorage probably not called");
        JsonStorage.findObject(JsonStorage.getParentObjectTreeFor(..));
        if (if-eqz(JsonStorage.findObject(..))) goto L_38;
        JsonStorage.getParentObjectTreeFor("Data is NULL, readStorage probably not called");
        JsonStorage.findObject(JsonStorage.getParentObjectTreeFor(..));
        if (if-eqz(JsonStorage.findObject(..))) goto L_38;
        JsonStorage.findObject(..).remove(String.split(..));
        if (if-eqz(JSONObject.remove(..))) goto L_38;
        return 1;
      L_38:
        return 0;
        throw JSONObject.remove(..);
    }

    public Object get(String p0) {
        if (if-nez(_data)) goto L_d;
        DeviceLog.error("Data is NULL, readStorage probably not called");
        return 0;
      L_d:
        String.split("\\.");
        JsonStorage.getParentObjectTreeFor("Data is NULL, readStorage probably not called");
        JsonStorage.findObject(JsonStorage.getParentObjectTreeFor(..));
        if (if-eqz(JsonStorage.findObject(..))) goto L_49;
        JsonStorage.getParentObjectTreeFor("Data is NULL, readStorage probably not called");
        JsonStorage.findObject(JsonStorage.getParentObjectTreeFor(..));
        if (if-eqz(JsonStorage.findObject(..))) goto L_49;
        JsonStorage.findObject(..).has(JsonStorage.findObject(..));
        if (if-eqz(JSONObject.has(..))) goto L_47;
        JsonStorage.findObject(..).get(String.split(..));
        DeviceLog.exception("Error getting data", JSONObject.get(..));
      L_47:
        return JSONObject.get(..);
      L_49:
        return JSONObject.get(..);
        throw JSONObject.get(..);
    }

    public JSONObject getData() {
        return _data;
        throw _data;
    }

    public List getKeys(String p0, boolean p1) {
        JsonStorage.get(p0);
        if (if-eqz(JsonStorage.get(..))) goto L_72;
        JsonStorage.get(p0);
        new ArrayList();
        if (if-eqz(JsonStorage.get(..))) goto L_70;
        JsonStorage.get(..).keys();
      L_1b:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_70;
        JSONObject.keys(..).next();
        if (if-eqz(p1)) goto L_42;
        new StringBuilder();
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(".");
        new StringBuilder(..).append(Iterator.next(..));
        new StringBuilder(..).toString();
        JsonStorage.getKeys(StringBuilder.toString(..), p1);
      L_42:
      L_43:
        new ArrayList(..).add(Iterator.next(..));
        if (if-eqz(0)) goto L_1b;
        0.iterator();
      L_4c:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_1b;
        List.iterator(..).next();
        new StringBuilder();
        new StringBuilder(..).append(Iterator.next(..));
        new StringBuilder(..).append(".");
        new StringBuilder(..).append(Iterator.next(..));
        new StringBuilder(..).toString();
        new ArrayList(..).add(StringBuilder.toString(..));
      L_70:
        return new ArrayList(..);
      L_72:
        return 0;
        throw p0;
    }

    public boolean hasData() {
        if (if-eqz(_data)) goto L_e;
        _data.length();
        if (if-lez(JSONObject.length(..))) goto L_e;
        return 1;
      L_e:
        return 0;
        throw 0;
    }

    public boolean initData() {
        if (if-nez(_data)) goto L_f;
        new JSONObject();
        _data = new JSONObject(..);
        return 1;
      L_f:
        return 0;
        throw 0;
    }

    public boolean set(String p0, Object p1) {
        if (if-eqz(_data)) goto L_52;
        if (if-eqz(p0)) goto L_52;
        p0.length();
        if (if-eqz(String.length(..))) goto L_52;
        if (if-nez(p1)) goto L_13;
      L_13:
        JsonStorage.getParentObjectTreeFor(p0);
        JsonStorage.createObjectTree(JsonStorage.getParentObjectTreeFor(..));
        JsonStorage.getParentObjectTreeFor(p0);
        JsonStorage.findObject(JsonStorage.getParentObjectTreeFor(..));
        if (if-eqz(JsonStorage.findObject(..))) goto L_4b;
        JsonStorage.getParentObjectTreeFor(p0);
        JsonStorage.findObject(JsonStorage.getParentObjectTreeFor(..));
        p0.split("\\.");
        if (if-eqz(JsonStorage.findObject(..))) goto L_49;
        JsonStorage.findObject(..).put(String.split(..), p1);
        DeviceLog.exception("Couldn't set value", String.split(..));
        return 0;
      L_49:
        return 1;
      L_4b:
        DeviceLog.debug("Cannot set subvalue to an object that is not JSONObject");
        return 0;
      L_52:
        new StringBuilder(JsonStorage.findObject(..));
        new StringBuilder(..).append(_data);
        new StringBuilder(..).append(", ");
        new StringBuilder(..).append("Cannot set subvalue to an object that is not JSONObject");
        new StringBuilder(..).append(", ");
        new StringBuilder(..).append("Couldn't set value");
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
        return 0;
        throw StringBuilder.toString(..);
    }

    public void setData(JSONObject p0) {
        _data = p0;
        return;
        throw p0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.misc.JsonStorageAggregator
// ============================================================
package com.unity3d.services.core.misc;

public class JsonStorageAggregator {
    private final List _jsonStorageReaders;

    public JsonStorageAggregator(List p0) {
        new Object();
        _jsonStorageReaders = p0;
        return;
    }

    public Object get(String p0) {
        _jsonStorageReaders.iterator();
      L_7:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_1c;
        List.iterator(..).next();
        if (if-nez(Iterator.next(..))) goto L_16;
      L_16:
        Iterator.next(..).get(p0);
        if (if-eqz(IJsonStorageReader.get(..))) goto L_7;
      L_1c:
        return IJsonStorageReader.get(..);
    }

    public JSONObject getData() {
        new JSONObject();
        _jsonStorageReaders.iterator();
      L_b:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_34;
        List.iterator(..).next();
        if (if-eqz(Iterator.next(..))) goto L_b;
        Iterator.next(..).getData();
        Utilities.mergeJsonObjects(new JSONObject(..), IJsonStorageReader.getData(..));
        new StringBuilder("Failed to merge storage: ");
        new StringBuilder(..).append(Iterator.next(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
      L_34:
        return Utilities.mergeJsonObjects(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.misc.Observable
// ============================================================
package com.unity3d.services.core.misc;

public abstract class Observable {
    private final List _observers;

    public Observable() {
        new Object();
        new ArrayList();
        _observers = new ArrayList(..);
        return;
    }

    protected void notifyObservers(Object p0) {
        _observers.iterator();
      L_7:
        List.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_17;
        List.iterator(..).next();
        Iterator.next(..).updated(p0);
      L_17:
        return;
        throw p0;
    }

    public void registerObserver(IObserver p0) {
        _observers.contains(p0);
        if (if-eqz(List.contains(..))) goto L_b;
        return;
      L_b:
        _observers.add(p0);
        return;
        throw p0;
    }

    public void unregisterObserver(IObserver p0) {
        _observers.contains(p0);
        if (if-eqz(List.contains(..))) goto L_e;
        _observers.remove(p0);
      L_e:
        return;
        throw p0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.misc.Utilities
// ============================================================
package com.unity3d.services.core.misc;

public class Utilities {
    public Utilities() {
        new Object();
        return;
    }

    public static String Sha256(InputStream p0) {
        if (if-nez(p0)) goto L_4;
        return 0;
      L_4:
        MessageDigest.getInstance("SHA-256");
      L_e:
        p0.read(4096);
        if (if-eq(InputStream.read(..), -1)) goto L_1a;
        MessageDigest.getInstance(..).update(4096, 0, InputStream.read(..));
      L_1a:
        MessageDigest.getInstance(..).digest();
        Utilities.toHexString(MessageDigest.digest(..));
        return Utilities.toHexString(..);
        DeviceLog.exception("SHA-256 algorithm not found", Utilities.toHexString(..));
        return MessageDigest.getInstance(..);
    }

    public static String Sha256(String p0) {
        p0.getBytes();
        Utilities.Sha256(String.getBytes(..));
        return Utilities.Sha256(..);
    }

    public static String Sha256(byte[] p0) {
        if (if-nez(p0)) goto L_4;
        return 0;
      L_4:
        MessageDigest.getInstance("SHA-256");
        MessageDigest.getInstance(..).update(p0, 0, v2);
        MessageDigest.getInstance(..).digest();
        Utilities.toHexString(MessageDigest.digest(..));
        return Utilities.toHexString(..);
        DeviceLog.exception("SHA-256 algorithm not found", Utilities.toHexString(..));
        return MessageDigest.getInstance(..);
    }

    public static Map combineJsonIntoMap(Map p0, JSONObject p1) {
        Utilities.combineJsonIntoMap(p0, p1, "");
        return Utilities.combineJsonIntoMap(..);
    }

    public static Map combineJsonIntoMap(Map p0, JSONObject p1, String p2) {
        new HashMap(p0);
        p1.keys();
      L_9:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_2c;
        JSONObject.keys(..).next();
        new StringBuilder();
        new StringBuilder(..).append(p2);
        new StringBuilder(..).append(Iterator.next(..));
        new StringBuilder(..).toString();
        p1.opt(Iterator.next(..));
        new HashMap(..).put(StringBuilder.toString(..), JSONObject.opt(..));
      L_2c:
        return new HashMap(..);
    }

    public static Map convertJsonToMap(JSONObject p0) {
        new HashMap();
        Utilities.combineJsonIntoMap(new HashMap(..), p0);
        return Utilities.combineJsonIntoMap(..);
    }

    public static Object getService(Class p0) {
        Utilities.getService("", p0);
        return Utilities.getService(..);
    }

    public static Object getService(String p0, Class p1) {
        ServiceProvider.INSTANCE.getRegistry();
        JvmClassMappingKt.getKotlinClass(p1);
        ServiceProvider.getRegistry(..).getService(p0, JvmClassMappingKt.getKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

    public static JSONObject mergeJsonObjects(JSONObject p0, JSONObject p1) {
        if (if-nez(p0)) goto L_3;
        return p1;
      L_3:
        if (if-nez(p1)) goto L_6;
        return p0;
      L_6:
        new JSONObject();
        p1.keys();
      L_f:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_23;
        JSONObject.keys(..).next();
        p1.get(Iterator.next(..));
        new JSONObject(..).put(Iterator.next(..), JSONObject.get(..));
      L_23:
        p0.keys();
      L_27:
        JSONObject.keys(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_61;
        JSONObject.keys(..).next();
        new JSONObject(..).has(Iterator.next(..));
        if (if-eqz(JSONObject.has(..))) goto L_59;
        new JSONObject(..).get(Iterator.next(..));
        if (if-eqz(JSONObject.get(..))) goto L_59;
        p0.get(Iterator.next(..));
        if (if-eqz(JSONObject.get(..))) goto L_59;
        p0.getJSONObject(Iterator.next(..));
        new JSONObject(..).getJSONObject(Iterator.next(..));
        Utilities.mergeJsonObjects(JSONObject.getJSONObject(..), JSONObject.getJSONObject(..));
        new JSONObject(..).put(Iterator.next(..), Utilities.mergeJsonObjects(..));
      L_59:
        p0.get(Iterator.next(..));
        new JSONObject(..).put(Iterator.next(..), JSONObject.get(..));
      L_61:
        return new JSONObject(..);
    }

    public static byte[] readFileBytes(File p0) {
        if (if-eqz(p0)) goto L_51;
        p0.exists();
        if (if-nez(File.exists(..))) goto L_c;
      L_c:
        if (if-lt(Build$VERSION.SDK_INT, 26)) goto L_1b;
        p0.toPath();
        Files.readAllBytes(File.toPath(..));
        return Files.readAllBytes(..);
      L_1b:
        new FileInputStream(Files.readAllBytes(..));
        Files.readAllBytes(..).length();
        new FileInputStream(..).read(File.length(..));
        if (if-ne(InputStream.read(..), 0)) goto L_31;
        new FileInputStream(..).close();
        return File.length(..);
      L_31:
        new StringBuilder("Failed to read all bytes from input file path: ");
        Files.readAllBytes(..).getPath();
        new StringBuilder(..).append(File.getPath(..));
        new StringBuilder(..).toString();
        new IOException(StringBuilder.toString(..));
        throw new IOException(..);
      L_4b:
        if (if-eqz(new FileInputStream(..))) goto L_50;
        new FileInputStream(..).close();
      L_50:
        throw StringBuilder.toString(..);
      L_51:
        return new FileInputStream(..);
    }

    public static void runOnUiThread(Runnable p0) {
        Utilities.runOnUiThread(p0, 0L, v1);
        return;
    }

    public static void runOnUiThread(Runnable p0, long p1) {
        Looper.getMainLooper();
        new Handler(Looper.getMainLooper(..));
        if (if-lez(0L)) goto L_13;
        new Handler(..).postDelayed(p0, p1, v5);
      L_13:
        new Handler(..).post(p0);
      L_16:
        return;
    }

    public static String toHexString(byte[] p0) {
      L_4:
        if (if-ge(0, v0)) goto L_35;
        if (if-gt(v3, 15)) goto L_1f;
        new StringBuilder();
        new StringBuilder(..).append("");
        new StringBuilder(..).append("0");
        new StringBuilder(..).toString();
      L_1f:
        new StringBuilder();
        new StringBuilder(..).append(StringBuilder.toString(..));
        Integer.toHexString(v3);
        new StringBuilder(..).append(Integer.toHexString(..));
        new StringBuilder(..).toString();
      L_35:
        return StringBuilder.toString(..);
    }

    public static void wrapCustomerListener(Runnable p0) {
        p0.run();
        p0.getMessage();
        DeviceLog.error("An uncaught exception has occurred in the client application.  Exception: %s", 1);
      L_14:
        return;
    }

    public static boolean writeFile(File p0, String p1) {
        if (if-nez(p0)) goto L_6;
        return 0;
      L_6:
        new FileOutputStream(p0);
        p1.getBytes();
        new FileOutputStream(..).write(String.getBytes(..));
        new FileOutputStream(..).flush();
        new FileOutputStream(..).close();
        DeviceLog.exception("Error closing FileOutputStream", String.getBytes(..));
      L_1e:
      L_29:
        DeviceLog.exception("Could not write file", String.getBytes(..));
        if (if-eqz(new FileOutputStream(..))) goto L_38;
        new FileOutputStream(..).close();
        DeviceLog.exception("Error closing FileOutputStream", String.getBytes(..));
      L_38:
        if (if-eqz(1)) goto L_4f;
        new StringBuilder("Wrote file: ");
        p0.getAbsolutePath();
        new StringBuilder(..).append(File.getAbsolutePath(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
      L_4f:
        return 1;
      L_50:
        if (if-eqz(new FileOutputStream(..))) goto L_5a;
        new FileOutputStream(..).close();
        DeviceLog.exception("Wrote file: ", new StringBuilder(..));
      L_5a:
        throw StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.misc.ViewUtilities
// ============================================================
package com.unity3d.services.core.misc;

public class ViewUtilities {
    public ViewUtilities() {
        new Object();
        return;
    }

    public static float dpFromPx(Context p0, float p1) {
        p0.getResources();
        Context.getResources(..).getDisplayMetrics();
        return p1;
    }

    public static float pxFromDp(Context p0, float p1) {
        p0.getResources();
        Context.getResources(..).getDisplayMetrics();
        return p1;
    }

    public static void removeViewFromParent(View p0) {
        if (if-eqz(p0)) goto L_18;
        p0.getParent();
        if (if-eqz(View.getParent(..))) goto L_18;
        p0.getParent();
        View.getParent(..).removeView(p0);
        DeviceLog.exception("Error while removing view from it's parent", p0);
      L_18:
        return;
    }

    public static void setBackground(View p0, Drawable p1) {
        View.class.getMethod("setBackground", v3);
        Class.getMethod(..).invoke(p0, 1);
        "Couldn't run".concat("setBackground");
        DeviceLog.exception(String.concat(..), p0);
      L_22:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.misc.EventSubject$1
// ============================================================
package com.unity3d.services.core.misc;

class EventSubject$1 {
    final EventSubject this$0;

    EventSubject$1(EventSubject p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void onNextIntervalTriggered() {
        this$0.sendNextEvent();
        return;
    }

}

