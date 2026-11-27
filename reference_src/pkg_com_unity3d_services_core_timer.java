// Package bundle: com.unity3d.services.core.timer (10 classes)

// ============================================================
// CLASS: com.unity3d.services.core.timer.BaseTimer
// ============================================================
package com.unity3d.services.core.timer;

public class BaseTimer {
    final Integer _delayMs;
    private final AtomicBoolean _hasPaused;
    private final AtomicBoolean _isRunning;
    private final LifecycleCache _lifecycleCache;
    Integer _remainingDurationMs;
    private ScheduledFuture _task;
    private ITimerListener _timerListener;
    private ScheduledExecutorService _timerService;
    final Integer _totalDurationMs;

    public BaseTimer(Integer p0, ITimerListener p1) {
        CachedLifecycle.getLifecycleListener();
        new BaseTimer(p0, p1, CachedLifecycle.getLifecycleListener(..));
        return;
    }

    public BaseTimer(Integer p0, ITimerListener p1, LifecycleCache p2) {
        new Object();
        Integer.valueOf(1000);
        _delayMs = Integer.valueOf(..);
        new AtomicBoolean(0);
        _isRunning = new AtomicBoolean(..);
        new AtomicBoolean(0);
        _hasPaused = new AtomicBoolean(..);
        _totalDurationMs = p0;
        _remainingDurationMs = p0;
        _timerListener = p1;
        _lifecycleCache = p2;
        new Object(..).addLifecycleListener();
        return;
    }

    static AtomicBoolean access$000(BaseTimer p0) {
        return _hasPaused;
    }

    private void addLifecycleListener() {
        if (if-nez(_lifecycleCache)) goto L_5;
        return;
      L_5:
        new BaseTimer$1(this);
        _lifecycleCache.addActiveListener(new BaseTimer$1(..));
        return;
    }

    private void notifyListeners() {
        if (if-eqz(_timerListener)) goto L_7;
        _timerListener.onTimerFinished();
      L_7:
        return;
    }

    private void schedule() {
        new BaseTimer$2(this);
        _delayMs.intValue();
        _delayMs.intValue();
        _timerService.scheduleAtFixedRate(new BaseTimer$2(..), Integer.intValue(..), v3, Integer.intValue(..), v5, TimeUnit.MILLISECONDS);
        _task = ScheduledExecutorService.scheduleAtFixedRate(..);
      L_25:
        new StringBuilder("ERROR: IntervalTimer failed to start due to exception ");
        RuntimeException.getLocalizedMessage();
        new StringBuilder(..).append(RuntimeException.getLocalizedMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
      L_3a:
        return;
    }

    public boolean isRunning() {
        _isRunning.get();
        return AtomicBoolean.get(..);
    }

    public void kill() {
        BaseTimer.stop();
        _timerListener = 0;
        return;
    }

    public void onStep() {
        _remainingDurationMs.intValue();
        if (if-gtz(Integer.intValue(..))) goto L_e;
        BaseTimer.notifyListeners();
        BaseTimer.kill();
      L_e:
        return;
    }

    public boolean pause() {
        if (if-eqz(_task)) goto L_15;
        _task.isCancelled();
        if (if-nez(ScheduledFuture.isCancelled(..))) goto L_15;
        _task.cancel(1);
        _task = 0;
      L_15:
      L_16:
        _isRunning.getAndSet(0);
        return 0;
    }

    public void restart(ScheduledExecutorService p0) {
        if (if-eqz(_timerService)) goto L_a;
        _timerService.isShutdown();
        if (if-eqz(ScheduledExecutorService.isShutdown(..))) goto L_c;
      L_a:
        _timerService = p0;
      L_c:
        _remainingDurationMs = _totalDurationMs;
        BaseTimer.schedule();
        _isRunning.getAndSet(1);
        return;
    }

    public boolean resume() {
        if (if-eqz(_timerService)) goto L_f;
        _timerService.isShutdown();
        if (if-nez(ScheduledExecutorService.isShutdown(..))) goto L_f;
        BaseTimer.schedule();
      L_f:
      L_10:
        _isRunning.getAndSet(0);
        return 0;
    }

    public void start(ScheduledExecutorService p0) {
        _isRunning.compareAndSet(0, 1);
        if (if-eqz(AtomicBoolean.compareAndSet(..))) goto L_f;
        _timerService = p0;
        BaseTimer.schedule();
      L_f:
        return;
    }

    public void stop() {
        if (if-eqz(_timerService)) goto L_12;
        _timerService.isShutdown();
        if (if-nez(ScheduledExecutorService.isShutdown(..))) goto L_12;
        _timerService.shutdown();
        _timerService = 0;
      L_12:
        _isRunning.getAndSet(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.timer.DefaultIntervalTimerFactory
// ============================================================
package com.unity3d.services.core.timer;

public class DefaultIntervalTimerFactory {
    public DefaultIntervalTimerFactory() {
        new Object();
        return;
    }

    public IIntervalTimer createTimer(Integer p0, Integer p1, IIntervalTimerListener p2) {
        CachedLifecycle.getLifecycleListener();
        new IntervalTimer(p0, p1, p2, CachedLifecycle.getLifecycleListener(..));
        return new IntervalTimer(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.timer.IBaseTimer
// ============================================================
package com.unity3d.services.core.timer;

public abstract class IBaseTimer {
    public abstract void kill() {
        // native or abstract
    }

    public abstract boolean pause() {
        // native or abstract
    }

    public abstract boolean resume() {
        // native or abstract
    }

    public abstract void start(ScheduledExecutorService p0) {
        // native or abstract
    }

    public abstract void stop() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.timer.IIntervalTimer
// ============================================================
package com.unity3d.services.core.timer;

public abstract class IIntervalTimer {
    public abstract void onNextInterval() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.timer.IIntervalTimerFactory
// ============================================================
package com.unity3d.services.core.timer;

public abstract class IIntervalTimerFactory {
    public abstract IIntervalTimer createTimer(Integer p0, Integer p1, IIntervalTimerListener p2) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.timer.IIntervalTimerListener
// ============================================================
package com.unity3d.services.core.timer;

public abstract class IIntervalTimerListener {
    public abstract void onNextIntervalTriggered() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.timer.ITimerListener
// ============================================================
package com.unity3d.services.core.timer;

public abstract class ITimerListener {
    public abstract void onTimerFinished() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.timer.IntervalTimer
// ============================================================
package com.unity3d.services.core.timer;

public class IntervalTimer extends BaseTimer {
    private final AtomicInteger _currentPosition;
    private final Integer _intervalDuration;
    private Integer _nextInterval;
    private IIntervalTimerListener _timerListener;
    private final Integer _totalIntervals;

    public IntervalTimer(Integer p0, Integer p1, IIntervalTimerListener p2, LifecycleCache p3) {
        new BaseTimer(p0, 0, p3);
        new AtomicInteger(0);
        _currentPosition = new AtomicInteger(..);
        _totalIntervals = p1;
        _timerListener = p2;
        p1.intValue();
        p0.intValue();
        if (if-nez(Integer.intValue(..))) goto L_1b;
      L_1b:
        p1.intValue();
      L_20:
        Integer.valueOf(Integer.intValue(..));
        _intervalDuration = Integer.valueOf(..);
        _nextInterval = Integer.valueOf(..);
        return;
    }

    public void kill() {
        BaseTimer.kill();
        _timerListener = 0;
        return;
    }

    public void onNextInterval() {
        if (if-eqz(_timerListener)) goto L_7;
        _timerListener.onNextIntervalTriggered();
      L_7:
        _nextInterval.intValue();
        _intervalDuration.intValue();
        Integer.valueOf(Integer.intValue(..));
        _nextInterval = Integer.valueOf(..);
        return;
    }

    public void onStep() {
        _delayMs.intValue();
        _currentPosition.addAndGet(Integer.intValue(..));
        _nextInterval.intValue();
        if (if-lt(AtomicInteger.addAndGet(..), Integer.intValue(..))) goto L_17;
        IntervalTimer.onNextInterval();
      L_17:
        BaseTimer.onStep();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.timer.BaseTimer$1
// ============================================================
package com.unity3d.services.core.timer;

class BaseTimer$1 {
    final BaseTimer this$0;

    BaseTimer$1(BaseTimer p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void onAppStateChanged(boolean p0) {
        if (if-eqz(p0)) goto L_1e;
        BaseTimer.access$000(this$0);
        BaseTimer.access$000(..).get();
        if (if-eqz(AtomicBoolean.get(..))) goto L_35;
        BaseTimer.access$000(this$0);
        BaseTimer.access$000(..).getAndSet(0);
        this$0.resume();
      L_1e:
        this$0.isRunning();
        if (if-eqz(BaseTimer.isRunning(..))) goto L_35;
        this$0.pause();
        BaseTimer.access$000(this$0);
        BaseTimer.access$000(..).getAndSet(1);
      L_35:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.timer.BaseTimer$2
// ============================================================
package com.unity3d.services.core.timer;

class BaseTimer$2 {
    final BaseTimer this$0;

    BaseTimer$2(BaseTimer p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void run() {
        _remainingDurationMs.intValue();
        _delayMs.intValue();
        Integer.valueOf(Integer.intValue(..));
        _remainingDurationMs = Integer.valueOf(..);
        this$0.onStep();
        return;
    }

}

