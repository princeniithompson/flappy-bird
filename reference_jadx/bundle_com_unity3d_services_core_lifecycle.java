
// ===== FILE: com/unity3d/services/core/lifecycle/CachedLifecycle.java =====
package com.unity3d.services.core.lifecycle;

import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.properties.ClientProperties;

/* loaded from: classes.dex */
public class CachedLifecycle {
    private static LifecycleCache _listener;

    public static void register() {
        if (ClientProperties.getApplication() == null || getLifecycleListener() != null) {
            return;
        }
        setLifecycleListener(new LifecycleCache(new ConfigurationReader()));
        ClientProperties.getApplication().registerActivityLifecycleCallbacks(getLifecycleListener());
    }

    public static void unregister() {
        if (ClientProperties.getApplication() == null || getLifecycleListener() == null) {
            return;
        }
        ClientProperties.getApplication().unregisterActivityLifecycleCallbacks(getLifecycleListener());
        setLifecycleListener(null);
    }

    public static LifecycleCache getLifecycleListener() {
        return _listener;
    }

    public static void setLifecycleListener(LifecycleCache lifecycleCache) {
        _listener = lifecycleCache;
    }
}

// ===== FILE: com/unity3d/services/core/lifecycle/IAppActiveListener.java =====
package com.unity3d.services.core.lifecycle;

/* loaded from: classes.dex */
public interface IAppActiveListener {
    void onAppStateChanged(boolean z);
}

// ===== FILE: com/unity3d/services/core/lifecycle/IAppEventListener.java =====
package com.unity3d.services.core.lifecycle;

/* loaded from: classes.dex */
public interface IAppEventListener {
    void onLifecycleEvent(LifecycleEvent lifecycleEvent);
}

// ===== FILE: com/unity3d/services/core/lifecycle/LifecycleCache.java =====
package com.unity3d.services.core.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.unity3d.scar.adapter.common.Utils;
import com.unity3d.services.core.configuration.ConfigurationReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class LifecycleCache implements Application.ActivityLifecycleCallbacks, LifecycleEventObserver {
    private boolean _newLifecycle;
    private LifecycleEvent _currentState = LifecycleEvent.RESUMED;
    private boolean _appActive = true;
    private boolean _lifecycleAppActive = true;
    private int _numStarted = 0;
    private final Set<IAppActiveListener> _appActiveListeners = new HashSet();
    private final Set<IAppEventListener> _appStateListeners = new HashSet();

    LifecycleCache(ConfigurationReader configurationReader) {
        this._newLifecycle = false;
        this._newLifecycle = configurationReader.getCurrentConfiguration().getExperiments().isJetpackLifecycle();
        startProcessLifecycleObserving();
    }

    private void startProcessLifecycleObserving() {
        Utils.runOnUiThread(new Runnable() { // from class: com.unity3d.services.core.lifecycle.LifecycleCache.1
            @Override // java.lang.Runnable
            public void run() {
                LifecycleCache.this.registerLifecycleObserver();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerLifecycleObserver() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this._currentState = LifecycleEvent.CREATED;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this._currentState = LifecycleEvent.STARTED;
        if (this._numStarted == 0) {
            this._appActive = true;
            if (!this._newLifecycle) {
                notifyActiveListeners();
            }
        }
        this._numStarted++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this._currentState = LifecycleEvent.RESUMED;
        notifyStateListeners(LifecycleEvent.RESUMED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this._currentState = LifecycleEvent.PAUSED;
        notifyStateListeners(LifecycleEvent.PAUSED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this._currentState = LifecycleEvent.STOPPED;
        int i = this._numStarted - 1;
        this._numStarted = i;
        if (i <= 0) {
            this._numStarted = 0;
            this._appActive = false;
            if (this._newLifecycle) {
                return;
            }
            notifyActiveListeners();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this._currentState = LifecycleEvent.SAVE_INSTANCE_STATE;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this._currentState = LifecycleEvent.DESTROYED;
    }

    public LifecycleEvent getCurrentState() {
        return this._currentState;
    }

    public boolean isAppActive() {
        return this._newLifecycle ? this._lifecycleAppActive : this._appActive;
    }

    public synchronized void notifyStateListeners(LifecycleEvent lifecycleEvent) {
        Iterator<IAppEventListener> it = this._appStateListeners.iterator();
        while (it.hasNext()) {
            it.next().onLifecycleEvent(lifecycleEvent);
        }
    }

    public synchronized void notifyActiveListeners() {
        Iterator<IAppActiveListener> it = this._appActiveListeners.iterator();
        while (it.hasNext()) {
            it.next().onAppStateChanged(this._appActive);
        }
    }

    public synchronized void addActiveListener(IAppActiveListener iAppActiveListener) {
        this._appActiveListeners.add(iAppActiveListener);
    }

    public synchronized void removeActiveListener(IAppActiveListener iAppActiveListener) {
        this._appActiveListeners.remove(iAppActiveListener);
    }

    public synchronized void addStateListener(IAppEventListener iAppEventListener) {
        this._appStateListeners.add(iAppEventListener);
    }

    public synchronized void removeStateListener(IAppEventListener iAppEventListener) {
        this._appStateListeners.remove(iAppEventListener);
    }

    /* renamed from: com.unity3d.services.core.lifecycle.LifecycleCache$2 */
    static /* synthetic */ class C12482 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i = C12482.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()];
        if (i == 1) {
            this._lifecycleAppActive = false;
            if (this._newLifecycle) {
                notifyActiveListeners();
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        this._lifecycleAppActive = true;
        if (this._newLifecycle) {
            notifyActiveListeners();
        }
    }
}

// ===== FILE: com/unity3d/services/core/lifecycle/LifecycleError.java =====
package com.unity3d.services.core.lifecycle;

/* loaded from: classes.dex */
public enum LifecycleError {
    APPLICATION_NULL,
    LISTENER_NOT_NULL,
    JSON_ERROR
}

// ===== FILE: com/unity3d/services/core/lifecycle/LifecycleEvent.java =====
package com.unity3d.services.core.lifecycle;

/* loaded from: classes.dex */
public enum LifecycleEvent {
    CREATED,
    STARTED,
    RESUMED,
    PAUSED,
    STOPPED,
    SAVE_INSTANCE_STATE,
    DESTROYED
}

// ===== FILE: com/unity3d/services/core/lifecycle/LifecycleListener.java =====
package com.unity3d.services.core.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import com.unity3d.services.core.webview.bridge.SharedInstances;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class LifecycleListener implements Application.ActivityLifecycleCallbacks {
    private final IEventSender _eventSender;
    private final ArrayList<String> _events;

    public LifecycleListener(ArrayList<String> arrayList) {
        this(arrayList, SharedInstances.INSTANCE.getWebViewEventSender());
    }

    public LifecycleListener(ArrayList<String> arrayList, IEventSender iEventSender) {
        this._events = arrayList;
        this._eventSender = iEventSender;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this._events.contains("onActivityCreated") && this._eventSender.canSend()) {
            this._eventSender.sendEvent(WebViewEventCategory.LIFECYCLE, LifecycleEvent.CREATED, activity.getClass().getName());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (this._events.contains("onActivityStarted") && this._eventSender.canSend()) {
            this._eventSender.sendEvent(WebViewEventCategory.LIFECYCLE, LifecycleEvent.STARTED, activity.getClass().getName());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (this._events.contains("onActivityResumed") && this._eventSender.canSend()) {
            this._eventSender.sendEvent(WebViewEventCategory.LIFECYCLE, LifecycleEvent.RESUMED, activity.getClass().getName());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this._events.contains("onActivityPaused") && this._eventSender.canSend()) {
            this._eventSender.sendEvent(WebViewEventCategory.LIFECYCLE, LifecycleEvent.PAUSED, activity.getClass().getName());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this._events.contains("onActivityStopped") && this._eventSender.canSend()) {
            this._eventSender.sendEvent(WebViewEventCategory.LIFECYCLE, LifecycleEvent.STOPPED, activity.getClass().getName());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (this._events.contains("onActivitySaveInstanceState") && this._eventSender.canSend()) {
            this._eventSender.sendEvent(WebViewEventCategory.LIFECYCLE, LifecycleEvent.SAVE_INSTANCE_STATE, activity.getClass().getName());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this._events.contains("onActivityDestroyed") && this._eventSender.canSend()) {
            this._eventSender.sendEvent(WebViewEventCategory.LIFECYCLE, LifecycleEvent.DESTROYED, activity.getClass().getName());
        }
    }
}
