// Package bundle: com.unity3d.services.core.connectivity (6 classes)

// ============================================================
// CLASS: com.unity3d.services.core.connectivity.ConnectivityChangeReceiver
// ============================================================
package com.unity3d.services.core.connectivity;

public class ConnectivityChangeReceiver extends BroadcastReceiver {
    private static ConnectivityChangeReceiver _receiver;

    static <clinit>() {
        return;
    }

    public ConnectivityChangeReceiver() {
        new BroadcastReceiver();
        return;
    }

    public static void register() {
        if (if-nez(ConnectivityChangeReceiver._receiver)) goto L_1b;
        new ConnectivityChangeReceiver();
        _receiver = new ConnectivityChangeReceiver(..);
        ClientProperties.getApplicationContext();
        new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        Context.registerReceiver(ConnectivityChangeReceiver._receiver, new IntentFilter(..));
      L_1b:
        return;
    }

    public static void unregister() {
        if (if-eqz(ConnectivityChangeReceiver._receiver)) goto L_10;
        ClientProperties.getApplicationContext();
        Context.unregisterReceiver(ConnectivityChangeReceiver._receiver);
        _receiver = 0;
      L_10:
        return;
    }

    public void onReceive(Context p0, Intent p1) {
        p1.getBooleanExtra("noConnectivity", 0);
        if (if-eqz(Intent.getBooleanExtra(..))) goto L_d;
        ConnectivityMonitor.disconnected();
        return;
      L_d:
        p0.getSystemService("connectivity");
        if (if-nez(Context.getSystemService(..))) goto L_18;
        return;
      L_18:
        Context.getSystemService(..).getActiveNetworkInfo();
        if (if-eqz(ConnectivityManager.getActiveNetworkInfo(..))) goto L_27;
        NetworkInfo.isConnected();
        if (if-eqz(NetworkInfo.isConnected(..))) goto L_27;
        ConnectivityMonitor.connected();
      L_27:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.connectivity.ConnectivityEvent
// ============================================================
package com.unity3d.services.core.connectivity;

public final class ConnectivityEvent extends Enum {
    private static final ConnectivityEvent[] $VALUES;
    public static final ConnectivityEvent CONNECTED;
    public static final ConnectivityEvent DISCONNECTED;
    public static final ConnectivityEvent NETWORK_CHANGE;

    private static ConnectivityEvent[] $values() {
        return 3;
    }

    static <clinit>() {
        new ConnectivityEvent("CONNECTED", 0);
        CONNECTED = new ConnectivityEvent(..);
        new ConnectivityEvent("DISCONNECTED", 1);
        DISCONNECTED = new ConnectivityEvent(..);
        new ConnectivityEvent("NETWORK_CHANGE", 2);
        NETWORK_CHANGE = new ConnectivityEvent(..);
        ConnectivityEvent.$values();
        $VALUES = ConnectivityEvent.$values(..);
        return;
    }

    private ConnectivityEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static ConnectivityEvent valueOf(String p0) {
        Enum.valueOf(ConnectivityEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static ConnectivityEvent[] values() {
        ConnectivityEvent.$VALUES.clone();
        return ConnectivityEvent[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.connectivity.ConnectivityMonitor
// ============================================================
package com.unity3d.services.core.connectivity;

public class ConnectivityMonitor {
    private static int _connected = 0xFFFFFFFF;
    private static Set _listeners = null;
    private static boolean _listening = false;
    private static int _networkType = 0xFFFFFFFF;
    private static boolean _webappMonitoring;
    private static boolean _wifi;

    static <clinit>() {
        return;
    }

    public ConnectivityMonitor() {
        new Object();
        return;
    }

    public static void addListener(IConnectivityListener p0) {
        if (if-nez(ConnectivityMonitor._listeners)) goto L_f;
        new ConcurrentHashMap();
        Collections.newSetFromMap(new ConcurrentHashMap(..));
        _listeners = Collections.newSetFromMap(..);
      L_f:
        ConnectivityMonitor._listeners.add(p0);
        ConnectivityMonitor.updateListeningStatus();
        return;
    }

    public static void connected() {
        if (if-ne(ConnectivityMonitor._connected, 1)) goto L_6;
        return;
      L_6:
        DeviceLog.debug("Unity Ads connectivity change: connected");
        ConnectivityMonitor.initConnectionStatus();
        if (if-eqz(ConnectivityMonitor._listeners)) goto L_26;
        ConnectivityMonitor._listeners.iterator();
      L_16:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_26;
        Set.iterator(..).next();
        Iterator.next(..).onConnected();
      L_26:
        ConnectivityMonitor.sendToWebview(ConnectivityEvent.CONNECTED, ConnectivityMonitor._wifi, ConnectivityMonitor._networkType);
        return;
    }

    public static void connectionStatusChanged() {
        if (if-eq(ConnectivityMonitor._connected, 1)) goto L_6;
        return;
      L_6:
        ClientProperties.getApplicationContext();
        Context.getSystemService("connectivity");
        Context.getSystemService(..).getActiveNetworkInfo();
        if (if-eqz(ConnectivityManager.getActiveNetworkInfo(..))) goto L_56;
        NetworkInfo.isConnected();
        if (if-eqz(NetworkInfo.isConnected(..))) goto L_56;
        NetworkInfo.getType();
        if (if-ne(NetworkInfo.getType(..), 1)) goto L_25;
      L_25:
      L_26:
        ClientProperties.getApplicationContext();
        Context.getSystemService("phone");
        Context.getSystemService(..).getNetworkType();
        DeviceLog.warning("Unity Ads was not able to get current network type due to missing permission");
      L_3d:
        if (if-ne(0, ConnectivityMonitor._wifi)) goto L_48;
        if (if-eq(-1, ConnectivityMonitor._networkType)) goto L_47;
        if (if-eqz(ConnectivityMonitor._wifi)) goto L_48;
      L_47:
        return;
      L_48:
        _wifi = 0;
        _networkType = -1;
        DeviceLog.debug("Unity Ads connectivity change: network change");
        ConnectivityMonitor.sendToWebview(ConnectivityEvent.NETWORK_CHANGE, 0, -1);
      L_56:
        return;
    }

    public static void disconnected() {
        if (if-nez(ConnectivityMonitor._connected)) goto L_5;
        return;
      L_5:
        _connected = 0;
        DeviceLog.debug("Unity Ads connectivity change: disconnected");
        if (if-eqz(ConnectivityMonitor._listeners)) goto L_25;
        ConnectivityMonitor._listeners.iterator();
      L_15:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_25;
        Set.iterator(..).next();
        Iterator.next(..).onDisconnected();
      L_25:
        ConnectivityMonitor.sendToWebview(ConnectivityEvent.DISCONNECTED, 0, 0);
        return;
    }

    private static void initConnectionStatus() {
        ClientProperties.getApplicationContext();
        Context.getSystemService("connectivity");
        if (if-nez(Context.getSystemService(..))) goto L_f;
        return;
      L_f:
        Context.getSystemService(..).getActiveNetworkInfo();
        if (if-eqz(ConnectivityManager.getActiveNetworkInfo(..))) goto L_43;
        NetworkInfo.isConnected();
        if (if-eqz(NetworkInfo.isConnected(..))) goto L_43;
        _connected = 1;
        NetworkInfo.getType();
        if (if-ne(NetworkInfo.getType(..), 1)) goto L_26;
      L_26:
        _wifi = 1;
        if (if-nez(1)) goto L_45;
        ClientProperties.getApplicationContext();
        Context.getSystemService("phone");
        Context.getSystemService(..).getNetworkType();
        _networkType = TelephonyManager.getNetworkType(..);
        DeviceLog.warning("Unity Ads was not able to get current network type due to missing permission");
      L_43:
        _connected = "phone";
      L_45:
        return;
    }

    public static void removeListener(IConnectivityListener p0) {
        if (if-nez(ConnectivityMonitor._listeners)) goto L_5;
        return;
      L_5:
        ConnectivityMonitor._listeners.remove(p0);
        ConnectivityMonitor.updateListeningStatus();
        return;
    }

    private static void sendToWebview(ConnectivityEvent p0, boolean p1, int p2) {
        if (if-nez(ConnectivityMonitor._webappMonitoring)) goto L_5;
        return;
      L_5:
        WebViewApp.getCurrentApp();
        if (if-eqz(WebViewApp.getCurrentApp(..))) goto L_8b;
        WebViewApp.getCurrentApp(..).isWebAppLoaded();
        if (if-nez(WebViewApp.isWebAppLoaded(..))) goto L_13;
      L_13:
        p0.ordinal();
        if (if-eq(ConnectivityEvent.ordinal(..), 1)) goto L_5e;
        if (if-eq(ConnectivityEvent.ordinal(..), 2)) goto L_54;
        if (if-eq(ConnectivityEvent.ordinal(..), 3)) goto L_26;
      L_26:
        if (if-eqz(p1)) goto L_3e;
        Boolean.valueOf(p1);
        Integer.valueOf(0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.NETWORK_CHANGE, 2);
      L_3e:
        Boolean.valueOf(Integer.valueOf(..));
        Integer.valueOf(ConnectivityEvent.NETWORK_CHANGE);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.NETWORK_CHANGE, 2);
      L_54:
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.DISCONNECTED, ConnectivityEvent.NETWORK_CHANGE);
      L_5e:
        if (if-eqz(ConnectivityEvent.DISCONNECTED)) goto L_76;
        Boolean.valueOf(ConnectivityEvent.DISCONNECTED);
        Integer.valueOf(0);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.CONNECTED, 2);
      L_76:
        Boolean.valueOf(Integer.valueOf(..));
        Integer.valueOf(ConnectivityEvent.CONNECTED);
        WebViewApp.getCurrentApp(..).sendEvent(WebViewEventCategory.CONNECTIVITY, ConnectivityEvent.CONNECTED, 2);
      L_8b:
        return;
    }

    public static void setConnectionMonitoring(boolean p0) {
        _webappMonitoring = p0;
        ConnectivityMonitor.updateListeningStatus();
        return;
    }

    private static void startListening() {
        if (if-eqz(ConnectivityMonitor._listening)) goto L_5;
        return;
      L_5:
        _listening = 1;
        ConnectivityMonitor.initConnectionStatus();
        ConnectivityNetworkCallback.register();
        return;
    }

    public static void stopAll() {
        _listeners = 0;
        _webappMonitoring = 0;
        ConnectivityMonitor.updateListeningStatus();
        return;
    }

    private static void stopListening() {
        if (if-nez(ConnectivityMonitor._listening)) goto L_5;
        return;
      L_5:
        _listening = 0;
        ConnectivityNetworkCallback.unregister();
        return;
    }

    private static void updateListeningStatus() {
        if (if-nez(ConnectivityMonitor._webappMonitoring)) goto L_13;
        if (if-eqz(ConnectivityMonitor._listeners)) goto L_f;
        ConnectivityMonitor._listeners.isEmpty();
        if (if-nez(Set.isEmpty(..))) goto L_f;
      L_f:
        ConnectivityMonitor.stopListening();
      L_13:
        ConnectivityMonitor.startListening();
      L_16:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.connectivity.ConnectivityNetworkCallback
// ============================================================
package com.unity3d.services.core.connectivity;

public class ConnectivityNetworkCallback extends ConnectivityManager$NetworkCallback {
    private static ConnectivityNetworkCallback _impl;

    static <clinit>() {
        return;
    }

    public ConnectivityNetworkCallback() {
        new ConnectivityManager$NetworkCallback();
        return;
    }

    public static void register() {
        if (if-nez(ConnectivityNetworkCallback._impl)) goto L_28;
        new ConnectivityNetworkCallback();
        _impl = new ConnectivityNetworkCallback(..);
        ClientProperties.getApplicationContext();
        Context.getSystemService("connectivity");
        new NetworkRequest$Builder();
        new NetworkRequest$Builder(..).build();
        Context.getSystemService(..).registerNetworkCallback(NetworkRequest$Builder.build(..), ConnectivityNetworkCallback._impl);
      L_28:
        return;
        throw Context.getSystemService(..);
    }

    public static void unregister() {
        if (if-eqz(ConnectivityNetworkCallback._impl)) goto L_1b;
        ClientProperties.getApplicationContext();
        Context.getSystemService("connectivity");
        Context.getSystemService(..).unregisterNetworkCallback(ConnectivityNetworkCallback._impl);
        _impl = 0;
      L_1b:
        return;
        throw 0;
    }

    public void onAvailable(Network p0) {
        ConnectivityMonitor.connected();
        return;
    }

    public void onCapabilitiesChanged(Network p0, NetworkCapabilities p1) {
        ConnectivityMonitor.connectionStatusChanged();
        return;
    }

    public void onLinkPropertiesChanged(Network p0, LinkProperties p1) {
        ConnectivityMonitor.connectionStatusChanged();
        return;
    }

    public void onLost(Network p0) {
        ConnectivityMonitor.disconnected();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.connectivity.IConnectivityListener
// ============================================================
package com.unity3d.services.core.connectivity;

public abstract class IConnectivityListener {
    public abstract void onConnected() {
        // native or abstract
    }

    public abstract void onDisconnected() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.connectivity.ConnectivityMonitor$1
// ============================================================
package com.unity3d.services.core.connectivity;

class ConnectivityMonitor$1 {
    static final int[] $SwitchMap$com$unity3d$services$core$connectivity$ConnectivityEvent;

    static <clinit>() {
        ConnectivityEvent.values();
        $SwitchMap$com$unity3d$services$core$connectivity$ConnectivityEvent = ConnectivityEvent.values(..);
        ConnectivityEvent.CONNECTED.ordinal();
        ConnectivityEvent.DISCONNECTED.ordinal();
        ConnectivityEvent.NETWORK_CHANGE.ordinal();
        return;
    }

}

