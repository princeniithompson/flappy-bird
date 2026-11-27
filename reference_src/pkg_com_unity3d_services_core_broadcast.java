// Package bundle: com.unity3d.services.core.broadcast (4 classes)

// ============================================================
// CLASS: com.unity3d.services.core.broadcast.BroadcastError
// ============================================================
package com.unity3d.services.core.broadcast;

public final class BroadcastError extends Enum {
    private static final BroadcastError[] $VALUES;
    public static final BroadcastError JSON_ERROR;

    private static BroadcastError[] $values() {
        return 1;
    }

    static <clinit>() {
        new BroadcastError("JSON_ERROR", 0);
        JSON_ERROR = new BroadcastError(..);
        BroadcastError.$values();
        $VALUES = BroadcastError.$values(..);
        return;
    }

    private BroadcastError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static BroadcastError valueOf(String p0) {
        Enum.valueOf(BroadcastError.class, p0);
        return Enum.valueOf(..);
    }

    public static BroadcastError[] values() {
        BroadcastError.$VALUES.clone();
        return BroadcastError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.broadcast.BroadcastEvent
// ============================================================
package com.unity3d.services.core.broadcast;

public final class BroadcastEvent extends Enum {
    private static final BroadcastEvent[] $VALUES;
    public static final BroadcastEvent ACTION;

    private static BroadcastEvent[] $values() {
        return 1;
    }

    static <clinit>() {
        new BroadcastEvent("ACTION", 0);
        ACTION = new BroadcastEvent(..);
        BroadcastEvent.$values();
        $VALUES = BroadcastEvent.$values(..);
        return;
    }

    private BroadcastEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static BroadcastEvent valueOf(String p0) {
        Enum.valueOf(BroadcastEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static BroadcastEvent[] values() {
        BroadcastEvent.$VALUES.clone();
        return BroadcastEvent[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.broadcast.BroadcastEventReceiver
// ============================================================
package com.unity3d.services.core.broadcast;

public class BroadcastEventReceiver extends BroadcastReceiver {
    private String _name;

    public BroadcastEventReceiver(String p0) {
        new BroadcastReceiver();
        _name = p0;
        return;
    }

    public void onReceive(Context p0, Intent p1) {
        p1.getAction();
        if (if-nez(Intent.getAction(..))) goto L_7;
        return;
      L_7:
        p1.getDataString();
        if (if-eqz(Intent.getDataString(..))) goto L_12;
        p1.getDataString();
      L_12:
      L_14:
        new JSONObject();
        p1.getExtras();
        if (if-eqz(Intent.getExtras(..))) goto L_5d;
        p1.getExtras();
        Intent.getExtras(..).keySet();
        Bundle.keySet(..).iterator();
      L_2b:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_5d;
        Set.iterator(..).next();
        Intent.getExtras(..).get(Iterator.next(..));
        new JSONObject(..).put(Iterator.next(..), Bundle.get(..));
        new StringBuilder("JSONException when composing extras for broadcast action ");
        new StringBuilder(..).append(Intent.getAction(..));
        new StringBuilder(..).append(": ");
        Intent.getExtras(..).getMessage();
        new StringBuilder(..).append(JSONException.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
      L_5d:
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_82;
        WebViewApp.getCurrentApp(..).isWebAppLoaded();
        if (if-nez(WebViewApp.isWebAppLoaded(..))) goto L_6a;
      L_6a:
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.BROADCAST, BroadcastEvent.ACTION, 4);
      L_82:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.broadcast.BroadcastMonitor
// ============================================================
package com.unity3d.services.core.broadcast;

public class BroadcastMonitor {
    private static BroadcastMonitor _instance;
    private final Context _context;
    private Map _eventReceivers;

    private BroadcastMonitor(Context p0) {
        new Object();
        _context = p0;
        return;
    }

    public static BroadcastMonitor getInstance() {
        if (if-nez(BroadcastMonitor._instance)) goto L_12;
        ClientProperties.getApplicationContext();
        new BroadcastMonitor(ClientProperties.getApplicationContext(..));
        _instance = new BroadcastMonitor(..);
      L_12:
        return BroadcastMonitor._instance;
        throw BroadcastMonitor._instance;
    }

    public void addBroadcastListener(String p0, String p1, String[] p2) {
        BroadcastMonitor.removeBroadcastListener(p0);
        new IntentFilter();
      L_a:
        if (if-ge(0, v1)) goto L_14;
        new IntentFilter(..).addAction(v3);
      L_14:
        if (if-eqz(p1)) goto L_19;
        new IntentFilter(..).addDataScheme(p1);
      L_19:
        if (if-nez(_eventReceivers)) goto L_24;
        new HashMap();
        _eventReceivers = new HashMap(..);
      L_24:
        new BroadcastEventReceiver(p0);
        _eventReceivers.put(p0, new BroadcastEventReceiver(..));
        _context.registerReceiver(new BroadcastEventReceiver(..), new IntentFilter(..));
        return;
    }

    public void removeAllBroadcastListeners() {
        if (if-eqz(_eventReceivers)) goto L_29;
        _eventReceivers.keySet();
        Map.keySet(..).iterator();
      L_c:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_26;
        Set.iterator(..).next();
        _eventReceivers.get(Iterator.next(..));
        _context.unregisterReceiver(Map.get(..));
      L_26:
        _eventReceivers = 0;
      L_29:
        return;
    }

    public void removeBroadcastListener(String p0) {
        if (if-eqz(_eventReceivers)) goto L_1c;
        _eventReceivers.containsKey(p0);
        if (if-eqz(Map.containsKey(..))) goto L_1c;
        _eventReceivers.get(p0);
        _context.unregisterReceiver(Map.get(..));
        _eventReceivers.remove(p0);
      L_1c:
        return;
    }

}

