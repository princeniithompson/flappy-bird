// Package bundle: com.unity3d.services.core.lifecycle (9 classes)

// ============================================================
// CLASS: com.unity3d.services.core.lifecycle.CachedLifecycle
// ============================================================
package com.unity3d.services.core.lifecycle;

public class CachedLifecycle {
    private static LifecycleCache _listener;

    public CachedLifecycle() {
        new Object();
        return;
    }

    public static LifecycleCache getLifecycleListener() {
        return CachedLifecycle._listener;
    }

    public static void register() {
        ClientProperties.getApplication();
        if (if-eqz(ClientProperties.getApplication(..))) goto L_24;
        CachedLifecycle.getLifecycleListener();
        if (if-nez(CachedLifecycle.getLifecycleListener(..))) goto L_24;
        new ConfigurationReader();
        new LifecycleCache(new ConfigurationReader(..));
        CachedLifecycle.setLifecycleListener(new LifecycleCache(..));
        ClientProperties.getApplication();
        CachedLifecycle.getLifecycleListener();
        ClientProperties.getApplication(..).registerActivityLifecycleCallbacks(CachedLifecycle.getLifecycleListener(..));
      L_24:
        return;
    }

    public static void setLifecycleListener(LifecycleCache p0) {
        _listener = p0;
        return;
    }

    public static void unregister() {
        ClientProperties.getApplication();
        if (if-eqz(ClientProperties.getApplication(..))) goto L_1b;
        CachedLifecycle.getLifecycleListener();
        if (if-eqz(CachedLifecycle.getLifecycleListener(..))) goto L_1b;
        ClientProperties.getApplication();
        CachedLifecycle.getLifecycleListener();
        ClientProperties.getApplication(..).unregisterActivityLifecycleCallbacks(CachedLifecycle.getLifecycleListener(..));
        CachedLifecycle.setLifecycleListener(0);
      L_1b:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.lifecycle.IAppActiveListener
// ============================================================
package com.unity3d.services.core.lifecycle;

public abstract class IAppActiveListener {
    public abstract void onAppStateChanged(boolean p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.lifecycle.IAppEventListener
// ============================================================
package com.unity3d.services.core.lifecycle;

public abstract class IAppEventListener {
    public abstract void onLifecycleEvent(LifecycleEvent p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.lifecycle.LifecycleCache
// ============================================================
package com.unity3d.services.core.lifecycle;

public class LifecycleCache {
    private boolean _appActive;
    private final Set _appActiveListeners;
    private final Set _appStateListeners;
    private LifecycleEvent _currentState;
    private boolean _lifecycleAppActive;
    private boolean _newLifecycle;
    private int _numStarted;

    LifecycleCache(ConfigurationReader p0) {
        new Object();
        _currentState = LifecycleEvent.RESUMED;
        _appActive = 1;
        _lifecycleAppActive = 1;
        _numStarted = 0;
        _newLifecycle = 0;
        new HashSet();
        _appActiveListeners = new HashSet(..);
        new HashSet();
        _appStateListeners = new HashSet(..);
        p0.getCurrentConfiguration();
        Configuration.getExperiments();
        Configuration.getExperiments(..).isJetpackLifecycle();
        _newLifecycle = IExperiments.isJetpackLifecycle(..);
        new Object(..).startProcessLifecycleObserving();
        return;
    }

    static void access$000(LifecycleCache p0) {
        p0.registerLifecycleObserver();
        return;
    }

    private void registerLifecycleObserver() {
        ProcessLifecycleOwner.get();
        ProcessLifecycleOwner.get(..).getLifecycle();
        LifecycleOwner.getLifecycle(..).addObserver(this);
        return;
    }

    private void startProcessLifecycleObserving() {
        new LifecycleCache$1(this);
        Utils.runOnUiThread(new LifecycleCache$1(..));
        return;
    }

    public void addActiveListener(IAppActiveListener p0) {
        _appActiveListeners.add(p0);
        return;
        throw p0;
    }

    public void addStateListener(IAppEventListener p0) {
        _appStateListeners.add(p0);
        return;
        throw p0;
    }

    public LifecycleEvent getCurrentState() {
        return _currentState;
    }

    public boolean isAppActive() {
        if (if-eqz(_newLifecycle)) goto L_7;
      L_7:
      L_9:
        return _appActive;
    }

    public void notifyActiveListeners() {
        _appActiveListeners.iterator();
      L_7:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_19;
        Set.iterator(..).next();
        Iterator.next(..).onAppStateChanged(_appActive);
      L_19:
        return;
        throw Set.iterator(..);
    }

    public void notifyStateListeners(LifecycleEvent p0) {
        _appStateListeners.iterator();
      L_7:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_17;
        Set.iterator(..).next();
        Iterator.next(..).onLifecycleEvent(p0);
      L_17:
        return;
        throw p0;
    }

    public void onActivityCreated(Activity p0, Bundle p1) {
        _currentState = LifecycleEvent.CREATED;
        return;
    }

    public void onActivityDestroyed(Activity p0) {
        _currentState = LifecycleEvent.DESTROYED;
        return;
    }

    public void onActivityPaused(Activity p0) {
        _currentState = LifecycleEvent.PAUSED;
        LifecycleCache.notifyStateListeners(LifecycleEvent.PAUSED);
        return;
    }

    public void onActivityResumed(Activity p0) {
        _currentState = LifecycleEvent.RESUMED;
        LifecycleCache.notifyStateListeners(LifecycleEvent.RESUMED);
        return;
    }

    public void onActivitySaveInstanceState(Activity p0, Bundle p1) {
        _currentState = LifecycleEvent.SAVE_INSTANCE_STATE;
        return;
    }

    public void onActivityStarted(Activity p0) {
        _currentState = LifecycleEvent.STARTED;
        if (if-nez(_numStarted)) goto L_12;
        _appActive = 1;
        if (if-nez(_newLifecycle)) goto L_12;
        LifecycleCache.notifyActiveListeners();
      L_12:
        _numStarted = _numStarted;
        return;
    }

    public void onActivityStopped(Activity p0) {
        _currentState = LifecycleEvent.STOPPED;
        _numStarted = _numStarted;
        if (if-gtz(_numStarted)) goto L_18;
        _numStarted = 0;
        _appActive = 0;
        if (if-nez(_newLifecycle)) goto L_18;
        LifecycleCache.notifyActiveListeners();
      L_18:
        return;
    }

    public void onStateChanged(LifecycleOwner p0, Lifecycle$Event p1) {
        p1.ordinal();
        if (if-eq(LifecycleCache$2.$SwitchMap$androidx$lifecycle$Lifecycle$Event, 1)) goto L_19;
        if (if-eq(LifecycleCache$2.$SwitchMap$androidx$lifecycle$Lifecycle$Event, 2)) goto L_f;
      L_f:
        _lifecycleAppActive = 1;
        if (if-eqz(_newLifecycle)) goto L_23;
        LifecycleCache.notifyActiveListeners();
      L_19:
        _lifecycleAppActive = 0;
        if (if-eqz(_newLifecycle)) goto L_23;
        LifecycleCache.notifyActiveListeners();
      L_23:
        return;
    }

    public void removeActiveListener(IAppActiveListener p0) {
        _appActiveListeners.remove(p0);
        return;
        throw p0;
    }

    public void removeStateListener(IAppEventListener p0) {
        _appStateListeners.remove(p0);
        return;
        throw p0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.lifecycle.LifecycleError
// ============================================================
package com.unity3d.services.core.lifecycle;

public final class LifecycleError extends Enum {
    private static final LifecycleError[] $VALUES;
    public static final LifecycleError APPLICATION_NULL;
    public static final LifecycleError JSON_ERROR;
    public static final LifecycleError LISTENER_NOT_NULL;

    private static LifecycleError[] $values() {
        return 3;
    }

    static <clinit>() {
        new LifecycleError("APPLICATION_NULL", 0);
        APPLICATION_NULL = new LifecycleError(..);
        new LifecycleError("LISTENER_NOT_NULL", 1);
        LISTENER_NOT_NULL = new LifecycleError(..);
        new LifecycleError("JSON_ERROR", 2);
        JSON_ERROR = new LifecycleError(..);
        LifecycleError.$values();
        $VALUES = LifecycleError.$values(..);
        return;
    }

    private LifecycleError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static LifecycleError valueOf(String p0) {
        Enum.valueOf(LifecycleError.class, p0);
        return Enum.valueOf(..);
    }

    public static LifecycleError[] values() {
        LifecycleError.$VALUES.clone();
        return LifecycleError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.lifecycle.LifecycleEvent
// ============================================================
package com.unity3d.services.core.lifecycle;

public final class LifecycleEvent extends Enum {
    private static final LifecycleEvent[] $VALUES;
    public static final LifecycleEvent CREATED;
    public static final LifecycleEvent DESTROYED;
    public static final LifecycleEvent PAUSED;
    public static final LifecycleEvent RESUMED;
    public static final LifecycleEvent SAVE_INSTANCE_STATE;
    public static final LifecycleEvent STARTED;
    public static final LifecycleEvent STOPPED;

    private static LifecycleEvent[] $values() {
        return 7;
    }

    static <clinit>() {
        new LifecycleEvent("CREATED", 0);
        CREATED = new LifecycleEvent(..);
        new LifecycleEvent("STARTED", 1);
        STARTED = new LifecycleEvent(..);
        new LifecycleEvent("RESUMED", 2);
        RESUMED = new LifecycleEvent(..);
        new LifecycleEvent("PAUSED", 3);
        PAUSED = new LifecycleEvent(..);
        new LifecycleEvent("STOPPED", 4);
        STOPPED = new LifecycleEvent(..);
        new LifecycleEvent("SAVE_INSTANCE_STATE", 5);
        SAVE_INSTANCE_STATE = new LifecycleEvent(..);
        new LifecycleEvent("DESTROYED", 6);
        DESTROYED = new LifecycleEvent(..);
        LifecycleEvent.$values();
        $VALUES = LifecycleEvent.$values(..);
        return;
    }

    private LifecycleEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static LifecycleEvent valueOf(String p0) {
        Enum.valueOf(LifecycleEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static LifecycleEvent[] values() {
        LifecycleEvent.$VALUES.clone();
        return LifecycleEvent[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.lifecycle.LifecycleListener
// ============================================================
package com.unity3d.services.core.lifecycle;

public class LifecycleListener {
    private final IEventSender _eventSender;
    private final ArrayList _events;

    public LifecycleListener(ArrayList p0) {
        SharedInstances.INSTANCE.getWebViewEventSender();
        new LifecycleListener(p0, SharedInstances.getWebViewEventSender(..));
        return;
    }

    public LifecycleListener(ArrayList p0, IEventSender p1) {
        new Object();
        _events = p0;
        _eventSender = p1;
        return;
    }

    public void onActivityCreated(Activity p0, Bundle p1) {
        _events.contains("onActivityCreated");
        if (if-eqz(ArrayList.contains(..))) goto L_29;
        _eventSender.canSend();
        if (if-eqz(IEventSender.canSend(..))) goto L_29;
        p0.getClass();
        Object.getClass(..).getName();
        _eventSender.sendEvent(WebViewEventCategory.LIFECYCLE, LifecycleEvent.CREATED, 1);
      L_29:
        return;
    }

    public void onActivityDestroyed(Activity p0) {
        _events.contains("onActivityDestroyed");
        if (if-eqz(ArrayList.contains(..))) goto L_29;
        _eventSender.canSend();
        if (if-eqz(IEventSender.canSend(..))) goto L_29;
        p0.getClass();
        Object.getClass(..).getName();
        _eventSender.sendEvent(WebViewEventCategory.LIFECYCLE, LifecycleEvent.DESTROYED, 1);
      L_29:
        return;
    }

    public void onActivityPaused(Activity p0) {
        _events.contains("onActivityPaused");
        if (if-eqz(ArrayList.contains(..))) goto L_29;
        _eventSender.canSend();
        if (if-eqz(IEventSender.canSend(..))) goto L_29;
        p0.getClass();
        Object.getClass(..).getName();
        _eventSender.sendEvent(WebViewEventCategory.LIFECYCLE, LifecycleEvent.PAUSED, 1);
      L_29:
        return;
    }

    public void onActivityResumed(Activity p0) {
        _events.contains("onActivityResumed");
        if (if-eqz(ArrayList.contains(..))) goto L_29;
        _eventSender.canSend();
        if (if-eqz(IEventSender.canSend(..))) goto L_29;
        p0.getClass();
        Object.getClass(..).getName();
        _eventSender.sendEvent(WebViewEventCategory.LIFECYCLE, LifecycleEvent.RESUMED, 1);
      L_29:
        return;
    }

    public void onActivitySaveInstanceState(Activity p0, Bundle p1) {
        _events.contains("onActivitySaveInstanceState");
        if (if-eqz(ArrayList.contains(..))) goto L_29;
        _eventSender.canSend();
        if (if-eqz(IEventSender.canSend(..))) goto L_29;
        p0.getClass();
        Object.getClass(..).getName();
        _eventSender.sendEvent(WebViewEventCategory.LIFECYCLE, LifecycleEvent.SAVE_INSTANCE_STATE, 1);
      L_29:
        return;
    }

    public void onActivityStarted(Activity p0) {
        _events.contains("onActivityStarted");
        if (if-eqz(ArrayList.contains(..))) goto L_29;
        _eventSender.canSend();
        if (if-eqz(IEventSender.canSend(..))) goto L_29;
        p0.getClass();
        Object.getClass(..).getName();
        _eventSender.sendEvent(WebViewEventCategory.LIFECYCLE, LifecycleEvent.STARTED, 1);
      L_29:
        return;
    }

    public void onActivityStopped(Activity p0) {
        _events.contains("onActivityStopped");
        if (if-eqz(ArrayList.contains(..))) goto L_29;
        _eventSender.canSend();
        if (if-eqz(IEventSender.canSend(..))) goto L_29;
        p0.getClass();
        Object.getClass(..).getName();
        _eventSender.sendEvent(WebViewEventCategory.LIFECYCLE, LifecycleEvent.STOPPED, 1);
      L_29:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.lifecycle.LifecycleCache$1
// ============================================================
package com.unity3d.services.core.lifecycle;

class LifecycleCache$1 {
    final LifecycleCache this$0;

    LifecycleCache$1(LifecycleCache p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void run() {
        LifecycleCache.access$000(this$0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.lifecycle.LifecycleCache$2
// ============================================================
package com.unity3d.services.core.lifecycle;

class LifecycleCache$2 {
    static final int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

    static <clinit>() {
        Lifecycle$Event.values();
        $SwitchMap$androidx$lifecycle$Lifecycle$Event = Lifecycle$Event.values(..);
        Lifecycle$Event.ON_STOP.ordinal();
        Lifecycle$Event.ON_START.ordinal();
        return;
    }

}

