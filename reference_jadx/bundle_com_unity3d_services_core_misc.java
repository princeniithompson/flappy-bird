
// ===== FILE: com/unity3d/services/core/misc/EventSubject.java =====
package com.unity3d.services.core.misc;

import com.unity3d.services.core.timer.IIntervalTimer;
import com.unity3d.services.core.timer.IIntervalTimerFactory;
import com.unity3d.services.core.timer.IIntervalTimerListener;
import java.util.Queue;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class EventSubject<T> {
    private IEventListener<T> _eventListener;
    Queue<T> _eventQueue;
    IIntervalTimer _intervalTimer;

    public EventSubject(Queue<T> queue, Integer num, IIntervalTimerFactory iIntervalTimerFactory) {
        this._eventQueue = queue;
        this._intervalTimer = iIntervalTimerFactory.createTimer(num, Integer.valueOf(queue.size()), new IIntervalTimerListener() { // from class: com.unity3d.services.core.misc.EventSubject.1
            @Override // com.unity3d.services.core.timer.IIntervalTimerListener
            public void onNextIntervalTriggered() {
                EventSubject.this.sendNextEvent();
            }
        });
    }

    public void sendNextEvent() {
        IEventListener<T> iEventListener = this._eventListener;
        if (iEventListener != null) {
            iEventListener.onNextEvent(this._eventQueue.remove());
        }
        if (this._eventQueue.size() <= 0) {
            unsubscribe();
        }
    }

    public void subscribe(IEventListener<T> iEventListener) {
        Queue<T> queue = this._eventQueue;
        if (queue == null || queue.size() <= 0 || this._intervalTimer == null || iEventListener == null) {
            return;
        }
        this._eventListener = iEventListener;
        startTimer();
    }

    private void startTimer() {
        IIntervalTimer iIntervalTimer = this._intervalTimer;
        if (iIntervalTimer != null) {
            iIntervalTimer.start(Executors.newSingleThreadScheduledExecutor());
        }
    }

    private void killTimer() {
        IIntervalTimer iIntervalTimer = this._intervalTimer;
        if (iIntervalTimer != null) {
            iIntervalTimer.kill();
            this._intervalTimer = null;
        }
    }

    public void unsubscribe() {
        killTimer();
        this._eventListener = null;
    }

    public boolean eventQueueIsEmpty() {
        return this._eventQueue.isEmpty();
    }
}

// ===== FILE: com/unity3d/services/core/misc/IEventListener.java =====
package com.unity3d.services.core.misc;

/* loaded from: classes.dex */
public interface IEventListener<T> {
    void onNextEvent(T t);
}

// ===== FILE: com/unity3d/services/core/misc/IJsonStorageReader.java =====
package com.unity3d.services.core.misc;

import org.json.JSONObject;

/* loaded from: classes.dex */
public interface IJsonStorageReader {
    Object get(String str);

    JSONObject getData();
}

// ===== FILE: com/unity3d/services/core/misc/IObserver.java =====
package com.unity3d.services.core.misc;

/* loaded from: classes.dex */
public interface IObserver<T> {
    void updated(T t);
}

// ===== FILE: com/unity3d/services/core/misc/JsonFlattener.java =====
package com.unity3d.services.core.misc;

import com.unity3d.services.core.log.DeviceLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonFlattener {
    private final JSONObject _jsonData;

    public JsonFlattener(JSONObject jSONObject) {
        this._jsonData = jSONObject;
    }

    public JSONObject flattenJson(String str, JsonFlattenerRules jsonFlattenerRules) {
        if (jsonFlattenerRules == null) {
            return new JSONObject();
        }
        return flattenJson(str, jsonFlattenerRules.getTopLevelToInclude(), jsonFlattenerRules.getReduceKeys(), jsonFlattenerRules.getSkipKeys());
    }

    public JSONObject flattenJson(String str, List<String> list, List<String> list2, List<String> list3) {
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<String> keys = this._jsonData.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (shouldIncludeKey(next, list, list3)) {
                    Object opt = this._jsonData.opt(next);
                    if (opt instanceof JSONObject) {
                        new JsonFlattener((JSONObject) opt).flattenJson(str, next, jSONObject, list2, list3);
                    } else {
                        jSONObject.put(next, opt);
                    }
                }
            }
        } catch (JSONException e) {
            DeviceLog.error("Could not flatten JSON: %s", e.getMessage());
        }
        return jSONObject;
    }

    public void flattenJson(String str, String str2, JSONObject jSONObject, List<String> list, List<String> list2) throws JSONException {
        Iterator<String> keys = this._jsonData.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!list2.contains(next)) {
                Object obj = this._jsonData.get(next);
                String format = list.contains(next) ? str2 : String.format("%s%s%s", str2, str, next);
                if (obj instanceof JSONObject) {
                    new JsonFlattener((JSONObject) obj).flattenJson(str, format, jSONObject, list, list2);
                } else {
                    jSONObject.put(format, obj);
                }
            }
        }
    }

    private boolean shouldIncludeKey(String str, List<String> list, List<String> list2) {
        if (!list2.contains(str) && list.size() > 0) {
            return list.contains(str);
        }
        return false;
    }
}

// ===== FILE: com/unity3d/services/core/misc/JsonFlattenerRules.java =====
package com.unity3d.services.core.misc;

import java.util.List;

/* loaded from: classes.dex */
public class JsonFlattenerRules {
    List<String> _reduceKeys;
    List<String> _skipKeys;
    List<String> _topLevelToInclude;

    public JsonFlattenerRules(List<String> list, List<String> list2, List<String> list3) {
        this._topLevelToInclude = list;
        this._reduceKeys = list2;
        this._skipKeys = list3;
    }

    public List<String> getTopLevelToInclude() {
        return this._topLevelToInclude;
    }

    public List<String> getReduceKeys() {
        return this._reduceKeys;
    }

    public List<String> getSkipKeys() {
        return this._skipKeys;
    }
}

// ===== FILE: com/unity3d/services/core/misc/JsonStorage.java =====
package com.unity3d.services.core.misc;

import android.text.TextUtils;
import com.unity3d.services.core.log.DeviceLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonStorage implements IJsonStorageReader {
    private JSONObject _data;

    public synchronized boolean initData() {
        if (this._data != null) {
            return false;
        }
        this._data = new JSONObject();
        return true;
    }

    public synchronized void setData(JSONObject jSONObject) {
        this._data = jSONObject;
    }

    @Override // com.unity3d.services.core.misc.IJsonStorageReader
    public synchronized JSONObject getData() {
        return this._data;
    }

    public synchronized boolean hasData() {
        JSONObject jSONObject = this._data;
        if (jSONObject != null) {
            if (jSONObject.length() > 0) {
                return true;
            }
        }
        return false;
    }

    public synchronized void clearData() {
        this._data = null;
    }

    public synchronized boolean set(String str, Object obj) {
        if (this._data != null && str != null && str.length() != 0 && obj != null) {
            createObjectTree(getParentObjectTreeFor(str));
            if (findObject(getParentObjectTreeFor(str)) instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) findObject(getParentObjectTreeFor(str));
                String[] split = str.split("\\.");
                if (jSONObject != null) {
                    try {
                        jSONObject.put(split[split.length - 1], obj);
                    } catch (JSONException e) {
                        DeviceLog.exception("Couldn't set value", e);
                        return false;
                    }
                }
                return true;
            }
            DeviceLog.debug("Cannot set subvalue to an object that is not JSONObject");
            return false;
        }
        DeviceLog.error("Storage not properly initialized or incorrect parameters:" + this._data + ", " + str + ", " + obj);
        return false;
    }

    @Override // com.unity3d.services.core.misc.IJsonStorageReader
    public synchronized Object get(String str) {
        JSONObject jSONObject;
        Object obj = null;
        if (this._data == null) {
            DeviceLog.error("Data is NULL, readStorage probably not called");
            return null;
        }
        String[] split = str.split("\\.");
        if (!(findObject(getParentObjectTreeFor(str)) instanceof JSONObject) || (jSONObject = (JSONObject) findObject(getParentObjectTreeFor(str))) == null) {
            return null;
        }
        try {
            if (jSONObject.has(split[split.length - 1])) {
                obj = jSONObject.get(split[split.length - 1]);
            }
        } catch (Exception e) {
            DeviceLog.exception("Error getting data", e);
        }
        return obj;
    }

    public synchronized List<String> getKeys(String str, boolean z) {
        List<String> list;
        if (!(get(str) instanceof JSONObject)) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) get(str);
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (z) {
                    list = getKeys(str + "." + next, z);
                } else {
                    list = null;
                }
                arrayList.add(next);
                if (list != null) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(next + "." + it.next());
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized boolean delete(String str) {
        JSONObject jSONObject;
        if (this._data == null) {
            DeviceLog.error("Data is NULL, readStorage probably not called");
            return false;
        }
        String[] split = str.split("\\.");
        return (!(findObject(getParentObjectTreeFor(str)) instanceof JSONObject) || (jSONObject = (JSONObject) findObject(getParentObjectTreeFor(str))) == null || jSONObject.remove(split[split.length - 1]) == null) ? false : true;
    }

    private synchronized Object findObject(String str) {
        String[] split = str.split("\\.");
        JSONObject jSONObject = this._data;
        if (str.length() == 0) {
            return jSONObject;
        }
        for (int i = 0; i < split.length; i++) {
            if (!jSONObject.has(split[i])) {
                return null;
            }
            try {
                jSONObject = jSONObject.getJSONObject(split[i]);
            } catch (Exception e) {
                DeviceLog.exception("Couldn't read JSONObject: " + split[i], e);
                return null;
            }
        }
        return jSONObject;
    }

    private synchronized void createObjectTree(String str) {
        String[] split = str.split("\\.");
        JSONObject jSONObject = this._data;
        if (str.length() == 0) {
            return;
        }
        for (int i = 0; i < split.length; i++) {
            if (!jSONObject.has(split[i])) {
                try {
                    jSONObject = jSONObject.put(split[i], new JSONObject()).getJSONObject(split[i]);
                } catch (Exception e) {
                    DeviceLog.exception("Couldn't create new JSONObject", e);
                }
            } else {
                try {
                    jSONObject = jSONObject.getJSONObject(split[i]);
                } catch (Exception e2) {
                    DeviceLog.exception("Couldn't get existing JSONObject", e2);
                }
            }
        }
    }

    private synchronized String getParentObjectTreeFor(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList(Arrays.asList(str.split("\\.")));
        arrayList.remove(arrayList.size() - 1);
        return TextUtils.join(".", arrayList.toArray());
    }
}

// ===== FILE: com/unity3d/services/core/misc/JsonStorageAggregator.java =====
package com.unity3d.services.core.misc;

import com.unity3d.services.core.log.DeviceLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonStorageAggregator implements IJsonStorageReader {
    private final List<IJsonStorageReader> _jsonStorageReaders;

    public JsonStorageAggregator(List<IJsonStorageReader> list) {
        this._jsonStorageReaders = list;
    }

    @Override // com.unity3d.services.core.misc.IJsonStorageReader
    public JSONObject getData() {
        JSONObject jSONObject = new JSONObject();
        for (IJsonStorageReader iJsonStorageReader : this._jsonStorageReaders) {
            if (iJsonStorageReader != null) {
                try {
                    jSONObject = Utilities.mergeJsonObjects(jSONObject, iJsonStorageReader.getData());
                } catch (JSONException unused) {
                    DeviceLog.error("Failed to merge storage: " + iJsonStorageReader);
                }
            }
        }
        return jSONObject;
    }

    @Override // com.unity3d.services.core.misc.IJsonStorageReader
    public Object get(String str) {
        IJsonStorageReader next;
        Iterator<IJsonStorageReader> it = this._jsonStorageReaders.iterator();
        Object obj = null;
        while (it.hasNext() && ((next = it.next()) == null || (obj = next.get(str)) == null)) {
        }
        return obj;
    }
}

// ===== FILE: com/unity3d/services/core/misc/Observable.java =====
package com.unity3d.services.core.misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class Observable<T> {
    private final List<IObserver<T>> _observers = new ArrayList();

    public synchronized void registerObserver(IObserver<T> iObserver) {
        if (this._observers.contains(iObserver)) {
            return;
        }
        this._observers.add(iObserver);
    }

    public synchronized void unregisterObserver(IObserver<T> iObserver) {
        if (this._observers.contains(iObserver)) {
            this._observers.remove(iObserver);
        }
    }

    protected synchronized void notifyObservers(T t) {
        Iterator<IObserver<T>> it = this._observers.iterator();
        while (it.hasNext()) {
            it.next().updated(t);
        }
    }
}

// ===== FILE: com/unity3d/services/core/misc/Utilities.java =====
package com.unity3d.services.core.misc;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.p005di.ServiceProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.UByte;
import kotlin.jvm.JvmClassMappingKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Utilities {
    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0L);
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (j > 0) {
            handler.postDelayed(runnable, j);
        } else {
            handler.post(runnable);
        }
    }

    public static String Sha256(String str) {
        return Sha256(str.getBytes());
    }

    public static String Sha256(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr, 0, bArr.length);
            return toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            DeviceLog.exception("SHA-256 algorithm not found", e);
            return null;
        }
    }

    public static String Sha256(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    return toHexString(messageDigest.digest());
                }
            }
        } catch (NoSuchAlgorithmException e) {
            DeviceLog.exception("SHA-256 algorithm not found", e);
            return null;
        }
    }

    public static String toHexString(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            int i = b & UByte.MAX_VALUE;
            if (i <= 15) {
                str = str + "0";
            }
            str = str + Integer.toHexString(i);
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean writeFile(File file, String str) {
        FileOutputStream fileOutputStream;
        boolean z = false;
        if (file == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                DeviceLog.exception("Error closing FileOutputStream", e2);
            }
            z = true;
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            DeviceLog.exception("Could not write file", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e4) {
                    DeviceLog.exception("Error closing FileOutputStream", e4);
                }
            }
            if (z) {
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (Exception e5) {
                    DeviceLog.exception("Error closing FileOutputStream", e5);
                }
            }
            throw th;
        }
        if (z) {
            DeviceLog.debug("Wrote file: " + file.getAbsolutePath());
        }
        return z;
    }

    public static byte[] readFileBytes(File file) throws IOException {
        FileInputStream fileInputStream = null;
        if (file == null || !file.exists()) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return Files.readAllBytes(file.toPath());
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                int length = (int) file.length();
                byte[] bArr = new byte[length];
                if (fileInputStream2.read(bArr) != length) {
                    throw new IOException("Failed to read all bytes from input file path: " + file.getPath());
                }
                fileInputStream2.close();
                return bArr;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static JSONObject mergeJsonObjects(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 == null) {
            return jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONObject3.put(next, jSONObject2.get(next));
        }
        Iterator<String> keys2 = jSONObject.keys();
        while (keys2.hasNext()) {
            String next2 = keys2.next();
            if (jSONObject3.has(next2) && (jSONObject3.get(next2) instanceof JSONObject) && (jSONObject.get(next2) instanceof JSONObject)) {
                jSONObject3.put(next2, mergeJsonObjects(jSONObject.getJSONObject(next2), jSONObject3.getJSONObject(next2)));
            } else {
                jSONObject3.put(next2, jSONObject.get(next2));
            }
        }
        return jSONObject3;
    }

    public static Map<String, Object> combineJsonIntoMap(Map<String, Object> map, JSONObject jSONObject, String str) {
        HashMap hashMap = new HashMap(map);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(str + next, jSONObject.opt(next));
        }
        return hashMap;
    }

    public static Map<String, Object> combineJsonIntoMap(Map<String, Object> map, JSONObject jSONObject) {
        return combineJsonIntoMap(map, jSONObject, "");
    }

    public static Map<String, Object> convertJsonToMap(JSONObject jSONObject) {
        return combineJsonIntoMap(new HashMap(), jSONObject);
    }

    public static <T> T getService(String str, Class cls) {
        return (T) ServiceProvider.INSTANCE.getRegistry().getService(str, JvmClassMappingKt.getKotlinClass(cls));
    }

    public static <T> T getService(Class cls) {
        return (T) getService("", cls);
    }

    public static void wrapCustomerListener(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            DeviceLog.error("An uncaught exception has occurred in the client application.  Exception: %s", e.getMessage());
        }
    }
}

// ===== FILE: com/unity3d/services/core/misc/ViewUtilities.java =====
package com.unity3d.services.core.misc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.unity3d.services.core.log.DeviceLog;

/* loaded from: classes.dex */
public class ViewUtilities {
    public static void removeViewFromParent(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        try {
            ((ViewGroup) view.getParent()).removeView(view);
        } catch (Exception e) {
            DeviceLog.exception("Error while removing view from it's parent", e);
        }
    }

    public static void setBackground(View view, Drawable drawable) {
        try {
            View.class.getMethod("setBackground", Drawable.class).invoke(view, drawable);
        } catch (Exception e) {
            DeviceLog.exception("Couldn't run".concat("setBackground"), e);
        }
    }

    public static float dpFromPx(Context context, float f) {
        return f / context.getResources().getDisplayMetrics().density;
    }

    public static float pxFromDp(Context context, float f) {
        return f * context.getResources().getDisplayMetrics().density;
    }
}
