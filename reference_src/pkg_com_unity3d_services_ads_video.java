// Package bundle: com.unity3d.services.ads.video (9 classes)

// ============================================================
// CLASS: com.unity3d.services.ads.video.VideoPlayerError
// ============================================================
package com.unity3d.services.ads.video;

public final class VideoPlayerError extends Enum {
    private static final VideoPlayerError[] $VALUES;
    public static final VideoPlayerError API_LEVEL_ERROR;
    public static final VideoPlayerError PREPARE;
    public static final VideoPlayerError VIDEOVIEW_NULL;

    private static VideoPlayerError[] $values() {
        return 3;
    }

    static <clinit>() {
        new VideoPlayerError("VIDEOVIEW_NULL", 0);
        VIDEOVIEW_NULL = new VideoPlayerError(..);
        new VideoPlayerError("PREPARE", 1);
        PREPARE = new VideoPlayerError(..);
        new VideoPlayerError("API_LEVEL_ERROR", 2);
        API_LEVEL_ERROR = new VideoPlayerError(..);
        VideoPlayerError.$values();
        $VALUES = VideoPlayerError.$values(..);
        return;
    }

    private VideoPlayerError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static VideoPlayerError valueOf(String p0) {
        Enum.valueOf(VideoPlayerError.class, p0);
        return Enum.valueOf(..);
    }

    public static VideoPlayerError[] values() {
        VideoPlayerError.$VALUES.clone();
        return VideoPlayerError[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.video.VideoPlayerEvent
// ============================================================
package com.unity3d.services.ads.video;

public final class VideoPlayerEvent extends Enum {
    private static final VideoPlayerEvent[] $VALUES;
    public static final VideoPlayerEvent COMPLETED;
    public static final VideoPlayerEvent GENERIC_ERROR;
    public static final VideoPlayerEvent ILLEGAL_STATE;
    public static final VideoPlayerEvent INFO;
    public static final VideoPlayerEvent PAUSE;
    public static final VideoPlayerEvent PAUSE_ERROR;
    public static final VideoPlayerEvent PLAY;
    public static final VideoPlayerEvent PREPARED;
    public static final VideoPlayerEvent PREPARE_ERROR;
    public static final VideoPlayerEvent PREPARE_TIMEOUT;
    public static final VideoPlayerEvent PROGRESS;
    public static final VideoPlayerEvent SEEKTO;
    public static final VideoPlayerEvent SEEKTO_ERROR;
    public static final VideoPlayerEvent STOP;

    private static VideoPlayerEvent[] $values() {
        return 14;
    }

    static <clinit>() {
        new VideoPlayerEvent("GENERIC_ERROR", 0);
        GENERIC_ERROR = new VideoPlayerEvent(..);
        new VideoPlayerEvent("PROGRESS", 1);
        PROGRESS = new VideoPlayerEvent(..);
        new VideoPlayerEvent("INFO", 2);
        INFO = new VideoPlayerEvent(..);
        new VideoPlayerEvent("COMPLETED", 3);
        COMPLETED = new VideoPlayerEvent(..);
        new VideoPlayerEvent("PREPARED", 4);
        PREPARED = new VideoPlayerEvent(..);
        new VideoPlayerEvent("PREPARE_ERROR", 5);
        PREPARE_ERROR = new VideoPlayerEvent(..);
        new VideoPlayerEvent("PREPARE_TIMEOUT", 6);
        PREPARE_TIMEOUT = new VideoPlayerEvent(..);
        new VideoPlayerEvent("PLAY", 7);
        PLAY = new VideoPlayerEvent(..);
        new VideoPlayerEvent("PAUSE_ERROR", 8);
        PAUSE_ERROR = new VideoPlayerEvent(..);
        new VideoPlayerEvent("PAUSE", 9);
        PAUSE = new VideoPlayerEvent(..);
        new VideoPlayerEvent("SEEKTO_ERROR", 10);
        SEEKTO_ERROR = new VideoPlayerEvent(..);
        new VideoPlayerEvent("SEEKTO", 11);
        SEEKTO = new VideoPlayerEvent(..);
        new VideoPlayerEvent("STOP", 12);
        STOP = new VideoPlayerEvent(..);
        new VideoPlayerEvent("ILLEGAL_STATE", 13);
        ILLEGAL_STATE = new VideoPlayerEvent(..);
        VideoPlayerEvent.$values();
        $VALUES = VideoPlayerEvent.$values(..);
        return;
    }

    private VideoPlayerEvent(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static VideoPlayerEvent valueOf(String p0) {
        Enum.valueOf(VideoPlayerEvent.class, p0);
        return Enum.valueOf(..);
    }

    public static VideoPlayerEvent[] values() {
        VideoPlayerEvent.$VALUES.clone();
        return VideoPlayerEvent[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.video.VideoPlayerView
// ============================================================
package com.unity3d.services.ads.video;

public class VideoPlayerView extends VideoView {
    private AudioManager _audioManager;
    private final IEventSender _eventSender;
    private boolean _infoListenerEnabled;
    private MediaPlayer _mediaPlayer;
    private Timer _prepareTimer;
    private int _progressEventInterval;
    private Timer _videoTimer;
    private String _videoUrl;
    private Float _volume;

    public VideoPlayerView(Context p0) {
        SharedInstances.INSTANCE.getWebViewEventSender();
        new VideoPlayerView(p0, SharedInstances.getWebViewEventSender(..));
        return;
    }

    public VideoPlayerView(Context p0, IEventSender p1) {
        new VideoView(p0);
        _progressEventInterval = 500;
        _mediaPlayer = 0;
        _volume = 0;
        _infoListenerEnabled = 1;
        _audioManager = 0;
        _eventSender = p1;
        return;
    }

    static IEventSender access$000(VideoPlayerView p0) {
        return _eventSender;
    }

    static String access$100(VideoPlayerView p0) {
        return _videoUrl;
    }

    static MediaPlayer access$202(VideoPlayerView p0, MediaPlayer p1) {
        _mediaPlayer = p1;
        return p1;
    }

    private void startPrepareTimer(long p0) {
        new Timer();
        _prepareTimer = new Timer(..);
        new VideoPlayerView$2(this);
        new Timer(..).schedule(new VideoPlayerView$2(..), p0, v4);
        return;
    }

    private void startVideoProgressTimer() {
        new Timer();
        _videoTimer = new Timer(..);
        new VideoPlayerView$1(this);
        new Timer(..).scheduleAtFixedRate(new VideoPlayerView$1(..), v3, v3, v5, v5);
        return;
    }

    public int getProgressEventInterval() {
        return _progressEventInterval;
    }

    public int[] getVideoViewRectangle() {
        VideoPlayerView.getLocationInWindow(v1);
        VideoPlayerView.getMeasuredWidth();
        VideoPlayerView.getMeasuredHeight();
        return 4;
    }

    public float getVolume() {
        _volume.floatValue();
        return Float.floatValue(..);
    }

    public void pause() {
        VideoView.pause();
        if (if-ge(Build$VERSION.SDK_INT, 26)) goto L_14;
        if (if-eqz(_audioManager)) goto L_17;
        _audioManager.abandonAudioFocus(0);
      L_14:
        VideoPlayerView.setAudioFocusRequest(0);
      L_17:
        VideoPlayerView.stopVideoProgressTimer();
        _eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PAUSE, 1);
        return;
        _eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PAUSE_ERROR, 1);
        DeviceLog.exception("Error pausing video", _eventSender);
        return;
    }

    public void play() {
        DeviceLog.entered();
        new VideoPlayerView$5(this);
        VideoPlayerView.setOnCompletionListener(new VideoPlayerView$5(..));
        VideoPlayerView.start();
        VideoPlayerView.stopVideoProgressTimer();
        VideoPlayerView.startVideoProgressTimer();
        _eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PLAY, v5);
        Boolean.valueOf(0);
        _eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.ILLEGAL_STATE, 2);
      L_3c:
        return;
    }

    public boolean prepare(String p0, float p1, int p2) {
        DeviceLog.entered();
        _videoUrl = p0;
        new VideoPlayerView$3(this, p1);
        VideoPlayerView.setOnPreparedListener(new VideoPlayerView$3(..));
        new VideoPlayerView$4(this);
        VideoPlayerView.setOnErrorListener(new VideoPlayerView$4(..));
        VideoPlayerView.setInfoListenerEnabled(_infoListenerEnabled);
        if (if-lez(p2)) goto L_20;
        VideoPlayerView.startPrepareTimer(_infoListenerEnabled, p1);
      L_20:
        if (if-ge(Build$VERSION.SDK_INT, 26)) goto L_3e;
        VideoPlayerView.getContext();
        VideoPlayerView.getContext(..).getSystemService("audio");
        _audioManager = Context.getSystemService(..);
        if (if-eqz(Context.getSystemService(..))) goto L_41;
        Context.getSystemService(..).requestAudioFocus(0, 3, 2);
      L_3e:
        VideoPlayerView.setAudioFocusRequest(2);
      L_41:
        VideoPlayerView.setVideoPath(_videoUrl);
        return 1;
        _eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PREPARE_ERROR, 1);
        new StringBuilder("Error preparing video: ");
        new StringBuilder(..).append(_videoUrl);
        new StringBuilder(..).toString();
        DeviceLog.exception(StringBuilder.toString(..), _videoUrl);
        return 0;
    }

    public void seekTo(int p0) {
        VideoView.seekTo(p0);
        _eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.SEEKTO, 1);
        return;
        _eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.SEEKTO_ERROR, 1);
        DeviceLog.exception("Error seeking video", _eventSender);
        return;
    }

    public void setInfoListenerEnabled(boolean p0) {
        _infoListenerEnabled = p0;
        if (if-eqz(_infoListenerEnabled)) goto L_f;
        new VideoPlayerView$6(this);
        VideoPlayerView.setOnInfoListener(new VideoPlayerView$6(..));
      L_f:
        VideoPlayerView.setOnInfoListener(0);
      L_13:
        return;
    }

    public void setProgressEventInterval(int p0) {
        _progressEventInterval = p0;
        if (if-eqz(_videoTimer)) goto L_c;
        VideoPlayerView.stopVideoProgressTimer();
        VideoPlayerView.startVideoProgressTimer();
      L_c:
        return;
    }

    public void setVolume(Float p0) {
        p0.floatValue();
        p0.floatValue();
        _mediaPlayer.setVolume(Float.floatValue(..), Float.floatValue(..));
        _volume = p0;
        return;
        DeviceLog.exception("MediaPlayer generic error", p0);
        return;
    }

    public void stop() {
        VideoPlayerView.stopPlayback();
        VideoPlayerView.stopVideoProgressTimer();
        if (if-ge(Build$VERSION.SDK_INT, 26)) goto L_16;
        if (if-eqz(_audioManager)) goto L_19;
        _audioManager.abandonAudioFocus(0);
      L_16:
        VideoPlayerView.setAudioFocusRequest(0);
      L_19:
        _eventSender.sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.STOP, 1);
        return;
    }

    public void stopPrepareTimer() {
        if (if-eqz(_prepareTimer)) goto L_f;
        _prepareTimer.cancel();
        _prepareTimer.purge();
        _prepareTimer = 0;
      L_f:
        return;
    }

    public void stopVideoProgressTimer() {
        if (if-eqz(_videoTimer)) goto L_f;
        _videoTimer.cancel();
        _videoTimer.purge();
        _videoTimer = 0;
      L_f:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.video.VideoPlayerView$1
// ============================================================
package com.unity3d.services.ads.video;

class VideoPlayerView$1 extends TimerTask {
    final VideoPlayerView this$0;

    VideoPlayerView$1(VideoPlayerView p0) {
        this$0 = p0;
        new TimerTask();
        return;
    }

    public void run() {
        this$0.isPlaying();
        VideoPlayerView.access$000(this$0);
        this$0.getCurrentPosition();
        Integer.valueOf(VideoPlayerView.getCurrentPosition(..));
        VideoPlayerView.access$000(..).sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PROGRESS, v6);
      L_28:
        DeviceLog.exception("Exception while sending current position to webapp", VideoPlayerView.access$000(..));
        VideoPlayerView.access$000(this$0);
        VideoPlayerView.access$100(this$0);
        Boolean.valueOf(0);
        VideoPlayerView.access$000(..).sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.ILLEGAL_STATE, 3);
      L_50:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.video.VideoPlayerView$2
// ============================================================
package com.unity3d.services.ads.video;

class VideoPlayerView$2 extends TimerTask {
    final VideoPlayerView this$0;

    VideoPlayerView$2(VideoPlayerView p0) {
        this$0 = p0;
        new TimerTask();
        return;
    }

    public void run() {
        this$0.isPlaying();
        if (if-nez(VideoPlayerView.isPlaying(..))) goto L_65;
        VideoPlayerView.access$000(this$0);
        VideoPlayerView.access$100(this$0);
        VideoPlayerView.access$000(..).sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PREPARE_TIMEOUT, v7);
        new StringBuilder("Video player prepare timeout: ");
        VideoPlayerView.access$100(this$0);
        new StringBuilder(..).append(VideoPlayerView.access$100(..));
        new StringBuilder(..).toString();
        DeviceLog.error(StringBuilder.toString(..));
      L_3d:
        DeviceLog.exception("Exception while preparing timer", StringBuilder.toString(..));
        VideoPlayerView.access$000(this$0);
        VideoPlayerView.access$100(this$0);
        Boolean.valueOf(0);
        VideoPlayerView.access$000(..).sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.ILLEGAL_STATE, 3);
      L_65:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.video.VideoPlayerView$3
// ============================================================
package com.unity3d.services.ads.video;

class VideoPlayerView$3 {
    final VideoPlayerView this$0;
    final float val$initialVolume;

    VideoPlayerView$3(VideoPlayerView p0, float p1) {
        this$0 = p0;
        val$initialVolume = p1;
        new Object();
        return;
    }

    public void onPrepared(MediaPlayer p0) {
        this$0.stopPrepareTimer();
        if (if-eqz(p0)) goto L_c;
        VideoPlayerView.access$202(this$0, p0);
      L_c:
        Float.valueOf(val$initialVolume);
        this$0.setVolume(Float.valueOf(..));
        VideoPlayerView.access$000(this$0);
        VideoPlayerView.access$100(this$0);
        p0.getDuration();
        Integer.valueOf(MediaPlayer.getDuration(..));
        p0.getVideoWidth();
        Integer.valueOf(MediaPlayer.getVideoWidth(..));
        p0.getVideoHeight();
        Integer.valueOf(MediaPlayer.getVideoHeight(..));
        VideoPlayerView.access$000(..).sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.PREPARED, 4);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.video.VideoPlayerView$4
// ============================================================
package com.unity3d.services.ads.video;

class VideoPlayerView$4 {
    final VideoPlayerView this$0;

    VideoPlayerView$4(VideoPlayerView p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public boolean onError(MediaPlayer p0, int p1, int p2) {
        this$0.stopPrepareTimer();
        if (if-eqz(p0)) goto L_c;
        VideoPlayerView.access$202(this$0, p0);
      L_c:
        VideoPlayerView.access$000(this$0);
        VideoPlayerView.access$100(this$0);
        Integer.valueOf(p1);
        Integer.valueOf(p2);
        VideoPlayerView.access$000(..).sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.GENERIC_ERROR, 3);
        this$0.stopVideoProgressTimer();
        return 1;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.video.VideoPlayerView$5
// ============================================================
package com.unity3d.services.ads.video;

class VideoPlayerView$5 {
    final VideoPlayerView this$0;

    VideoPlayerView$5(VideoPlayerView p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public void onCompletion(MediaPlayer p0) {
        if (if-eqz(p0)) goto L_7;
        VideoPlayerView.access$202(this$0, p0);
      L_7:
        VideoPlayerView.access$000(this$0);
        VideoPlayerView.access$100(this$0);
        VideoPlayerView.access$000(..).sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.COMPLETED, 1);
        this$0.stopVideoProgressTimer();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.ads.video.VideoPlayerView$6
// ============================================================
package com.unity3d.services.ads.video;

class VideoPlayerView$6 {
    final VideoPlayerView this$0;

    VideoPlayerView$6(VideoPlayerView p0) {
        this$0 = p0;
        new Object();
        return;
    }

    public boolean onInfo(MediaPlayer p0, int p1, int p2) {
        VideoPlayerView.access$000(this$0);
        VideoPlayerView.access$100(this$0);
        Integer.valueOf(p1);
        Integer.valueOf(p2);
        VideoPlayerView.access$000(..).sendEvent(WebViewEventCategory.VIDEOPLAYER, VideoPlayerEvent.INFO, 3);
        return 1;
    }

}

