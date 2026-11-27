
// ===== FILE: com/unity3d/services/core/broadcast/BroadcastError.java =====
package com.unity3d.services.core.broadcast;

/* loaded from: classes.dex */
public enum BroadcastError {
    JSON_ERROR
}

// ===== FILE: com/unity3d/services/core/broadcast/BroadcastEvent.java =====
package com.unity3d.services.core.broadcast;

/* loaded from: classes.dex */
public enum BroadcastEvent {
    ACTION
}

// ===== FILE: com/unity3d/services/core/broadcast/BroadcastEventReceiver.java =====
package com.unity3d.services.core.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BroadcastEventReceiver extends BroadcastReceiver {
    private String _name;

    public BroadcastEventReceiver(String str) {
        this._name = str;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        String dataString = intent.getDataString() != null ? intent.getDataString() : "";
        JSONObject jSONObject = new JSONObject();
        try {
            if (intent.getExtras() != null) {
                Bundle extras = intent.getExtras();
                for (String str : extras.keySet()) {
                    jSONObject.put(str, extras.get(str));
                }
            }
        } catch (JSONException e) {
            DeviceLog.debug("JSONException when composing extras for broadcast action " + action + ": " + e.getMessage());
        }
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp == null || !currentApp.isWebAppLoaded()) {
            return;
        }
        currentApp.sendEvent(WebViewEventCategory.BROADCAST, BroadcastEvent.ACTION, this._name, action, dataString, jSONObject);
    }
}

// ===== FILE: com/unity3d/services/core/broadcast/BroadcastMonitor.java =====
package com.unity3d.services.core.broadcast;

import android.content.Context;
import android.content.IntentFilter;
import com.unity3d.services.core.properties.ClientProperties;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class BroadcastMonitor {
    private static BroadcastMonitor _instance;
    private final Context _context;
    private Map<String, BroadcastEventReceiver> _eventReceivers;

    public static synchronized BroadcastMonitor getInstance() {
        BroadcastMonitor broadcastMonitor;
        synchronized (BroadcastMonitor.class) {
            if (_instance == null) {
                _instance = new BroadcastMonitor(ClientProperties.getApplicationContext());
            }
            broadcastMonitor = _instance;
        }
        return broadcastMonitor;
    }

    private BroadcastMonitor(Context context) {
        this._context = context;
    }

    public void addBroadcastListener(String str, String str2, String[] strArr) {
        removeBroadcastListener(str);
        IntentFilter intentFilter = new IntentFilter();
        for (String str3 : strArr) {
            intentFilter.addAction(str3);
        }
        if (str2 != null) {
            intentFilter.addDataScheme(str2);
        }
        if (this._eventReceivers == null) {
            this._eventReceivers = new HashMap();
        }
        BroadcastEventReceiver broadcastEventReceiver = new BroadcastEventReceiver(str);
        this._eventReceivers.put(str, broadcastEventReceiver);
        this._context.registerReceiver(broadcastEventReceiver, intentFilter);
    }

    public void removeBroadcastListener(String str) {
        Map<String, BroadcastEventReceiver> map = this._eventReceivers;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this._context.unregisterReceiver(this._eventReceivers.get(str));
        this._eventReceivers.remove(str);
    }

    public void removeAllBroadcastListeners() {
        Map<String, BroadcastEventReceiver> map = this._eventReceivers;
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                this._context.unregisterReceiver(this._eventReceivers.get(it.next()));
            }
            this._eventReceivers = null;
        }
    }
}
