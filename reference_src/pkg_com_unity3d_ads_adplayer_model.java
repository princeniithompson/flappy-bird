// Package bundle: com.unity3d.ads.adplayer.model (20 classes)

// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.ErrorReason
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class ErrorReason extends Enum {
    private static final ErrorReason[] $VALUES;
    public static final ErrorReason REASON_UNKNOWN;
    public static final ErrorReason REASON_WEBVIEW_RENDER_PROCESS_GONE;
    public static final ErrorReason REASON_WEB_BLANK;
    public static final ErrorReason REASON_WEB_ERROR_AUTHENTICATION;
    public static final ErrorReason REASON_WEB_ERROR_BAD_URL;
    public static final ErrorReason REASON_WEB_ERROR_CONNECT;
    public static final ErrorReason REASON_WEB_ERROR_FAILED_SSL_HANDSHAKE;
    public static final ErrorReason REASON_WEB_ERROR_FILE;
    public static final ErrorReason REASON_WEB_ERROR_FILE_NOT_FOUND;
    public static final ErrorReason REASON_WEB_ERROR_HOST_LOOKUP;
    public static final ErrorReason REASON_WEB_ERROR_IO;
    public static final ErrorReason REASON_WEB_ERROR_PROXY_AUTHENTICATION;
    public static final ErrorReason REASON_WEB_ERROR_RECEIVED_HTTP;
    public static final ErrorReason REASON_WEB_ERROR_REDIRECT_LOOP;
    public static final ErrorReason REASON_WEB_ERROR_TIMEOUT;
    public static final ErrorReason REASON_WEB_ERROR_TOO_MANY_REQUESTS;
    public static final ErrorReason REASON_WEB_ERROR_UNKNOWN;
    public static final ErrorReason REASON_WEB_ERROR_UNSAFE_RESOURCE;
    public static final ErrorReason REASON_WEB_ERROR_UNSUPPORTED_AUTH_SCHEME;
    public static final ErrorReason REASON_WEB_ERROR_UNSUPPORTED_SCHEME;
    private final int code;

    private static final ErrorReason[] $values() {
        return 20;
    }

    static <clinit>() {
        new ErrorReason("REASON_UNKNOWN", 0, 0);
        REASON_UNKNOWN = new ErrorReason(..);
        new ErrorReason("REASON_WEB_BLANK", 1, 1);
        REASON_WEB_BLANK = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_UNKNOWN", 2, 2);
        REASON_WEB_ERROR_UNKNOWN = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_HOST_LOOKUP", 3, 3);
        REASON_WEB_ERROR_HOST_LOOKUP = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_UNSUPPORTED_AUTH_SCHEME", 4, 4);
        REASON_WEB_ERROR_UNSUPPORTED_AUTH_SCHEME = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_AUTHENTICATION", 5, 5);
        REASON_WEB_ERROR_AUTHENTICATION = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_PROXY_AUTHENTICATION", 6, 6);
        REASON_WEB_ERROR_PROXY_AUTHENTICATION = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_CONNECT", 7, 7);
        REASON_WEB_ERROR_CONNECT = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_IO", 8, 8);
        REASON_WEB_ERROR_IO = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_TIMEOUT", 9, 9);
        REASON_WEB_ERROR_TIMEOUT = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_REDIRECT_LOOP", 10, 10);
        REASON_WEB_ERROR_REDIRECT_LOOP = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_UNSUPPORTED_SCHEME", 11, 11);
        REASON_WEB_ERROR_UNSUPPORTED_SCHEME = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_FAILED_SSL_HANDSHAKE", 12, 12);
        REASON_WEB_ERROR_FAILED_SSL_HANDSHAKE = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_BAD_URL", 13, 13);
        REASON_WEB_ERROR_BAD_URL = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_FILE", 14, 14);
        REASON_WEB_ERROR_FILE = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_FILE_NOT_FOUND", 15, 15);
        REASON_WEB_ERROR_FILE_NOT_FOUND = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_TOO_MANY_REQUESTS", 16, 16);
        REASON_WEB_ERROR_TOO_MANY_REQUESTS = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_UNSAFE_RESOURCE", 17, 17);
        REASON_WEB_ERROR_UNSAFE_RESOURCE = new ErrorReason(..);
        new ErrorReason("REASON_WEB_ERROR_RECEIVED_HTTP", 18, 18);
        REASON_WEB_ERROR_RECEIVED_HTTP = new ErrorReason(..);
        new ErrorReason("REASON_WEBVIEW_RENDER_PROCESS_GONE", 19, 19);
        REASON_WEBVIEW_RENDER_PROCESS_GONE = new ErrorReason(..);
        ErrorReason.$values();
        $VALUES = ErrorReason.$values(..);
        return;
    }

    private ErrorReason(String p0, int p1, int p2) {
        new Enum(p0, p1);
        code = p2;
        return;
    }

    public static ErrorReason valueOf(String p0) {
        Enum.valueOf(ErrorReason.class, p0);
        return Enum.valueOf(..);
    }

    public static ErrorReason[] values() {
        ErrorReason.$VALUES.clone();
        return Object[].clone(..);
    }

    public final int getCode() {
        return code;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.LoadEvent
// ============================================================
package com.unity3d.ads.adplayer.model;

public abstract class LoadEvent {
    private LoadEvent() {
        new Object();
        return;
    }

    public LoadEvent(DefaultConstructorMarker p0) {
        new LoadEvent();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.OnActivityDestroyedEvent
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class OnActivityDestroyedEvent {
    private final String category;
    private final String name;
    private final Object[] parameters;

    public OnActivityDestroyedEvent() {
        new Object();
        category = "ADVIEWER";
        name = "ON_ACTIVITY_DESTROY";
        parameters = 0;
        return;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Object[] getParameters() {
        return parameters;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.OnAllowedPiiChangeEvent
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class OnAllowedPiiChangeEvent {
    private final String category;
    private final String name;
    private final Object[] parameters;

    public OnAllowedPiiChangeEvent(String p0) {
        new Object();
        category = "ADVIEWER";
        name = "ON_ALLOWED_PII_CHANGE";
        parameters = 1;
        return;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Object[] getParameters() {
        return parameters;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.OnBroadcastEvent
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class OnBroadcastEvent {
    private final String category;
    private final String name;
    private final Object[] parameters;

    public OnBroadcastEvent(String p0, String p1) {
        new Object();
        name = p0;
        category = "ADVIEWER";
        parameters = 1;
        return;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Object[] getParameters() {
        return parameters;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.OnFocusChangeEvent
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class OnFocusChangeEvent {
    private final String category;
    private final String name;
    private final Object[] parameters;

    public OnFocusChangeEvent(boolean p0) {
        new Object();
        category = "ADVIEWER";
        name = "ON_FOCUS_CHANGE";
        Boolean.valueOf(p0);
        parameters = 1;
        return;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Object[] getParameters() {
        return parameters;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.OnMuteChangeEvent
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class OnMuteChangeEvent {
    private final String category;
    private final String name;
    private final Object[] parameters;

    public OnMuteChangeEvent(boolean p0) {
        new Object();
        category = "ADVIEWER";
        name = "ON_MUTE_CHANGE";
        Boolean.valueOf(p0);
        parameters = 1;
        return;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Object[] getParameters() {
        return parameters;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.OnPrivacyFsmChangeEvent
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class OnPrivacyFsmChangeEvent {
    private final String category;
    private final String name;
    private final Object[] parameters;

    public OnPrivacyFsmChangeEvent(String p0) {
        new Object();
        category = "ADVIEWER";
        name = "ON_PRIVACY_FSM_CHANGE";
        parameters = 1;
        return;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Object[] getParameters() {
        return parameters;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.OnStorageEvent
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class OnStorageEvent {
    private final String category;
    private final String name;
    private final Object[] parameters;

    public OnStorageEvent(StorageEvent p0, StorageManager$StorageType p1, Object p2) {
        new Object();
        category = "STORAGE";
        p0.name();
        name = StorageEvent.name(..);
        p1.name();
        parameters = 2;
        return;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Object[] getParameters() {
        return parameters;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.OnUserConsentChangeEvent
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class OnUserConsentChangeEvent {
    private final String category;
    private final String name;
    private final Object[] parameters;

    public OnUserConsentChangeEvent(String p0) {
        new Object();
        category = "ADVIEWER";
        name = "ON_USER_CONSENT_CHANGE";
        parameters = 1;
        return;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Object[] getParameters() {
        return parameters;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.OnVisibilityChangeEvent
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class OnVisibilityChangeEvent {
    private final String category;
    private final String name;
    private final Object[] parameters;

    public OnVisibilityChangeEvent(boolean p0) {
        new Object();
        category = "ADVIEWER";
        name = "ON_VISIBILITY_CHANGE";
        Boolean.valueOf(p0);
        parameters = 1;
        return;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Object[] getParameters() {
        return parameters;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.OnVolumeChangeEvent
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class OnVolumeChangeEvent {
    private final String category;
    private final String name;
    private final Object[] parameters;

    public OnVolumeChangeEvent(double p0) {
        new Object();
        category = "ADVIEWER";
        name = "ON_VOLUME_CHANGE";
        Double.valueOf(p0, v4);
        parameters = 1;
        return;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Object[] getParameters() {
        return parameters;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.OnWebRequestComplete
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class OnWebRequestComplete {
    private final String category;
    private final String name;
    private final Object[] parameters;

    public OnWebRequestComplete(List p0) {
        new Object();
        category = "REQUEST";
        name = "COMPLETE";
        p0.toArray(0);
        parameters = Collection.toArray(..);
        return;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Object[] getParameters() {
        return parameters;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.OnWebRequestFailed
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class OnWebRequestFailed {
    private final String category;
    private final String name;
    private final Object[] parameters;

    public OnWebRequestFailed(List p0) {
        new Object();
        category = "REQUEST";
        name = "FAILED";
        p0.toArray(0);
        parameters = Collection.toArray(..);
        return;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Object[] getParameters() {
        return parameters;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.ShowStatus
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class ShowStatus extends Enum {
    private static final ShowStatus[] $VALUES;
    public static final ShowStatus COMPLETED;
    public static final ShowStatus ERROR;
    public static final ShowStatus SKIPPED;

    private static final ShowStatus[] $values() {
        return 3;
    }

    static <clinit>() {
        new ShowStatus("COMPLETED", 0);
        COMPLETED = new ShowStatus(..);
        new ShowStatus("SKIPPED", 1);
        SKIPPED = new ShowStatus(..);
        new ShowStatus("ERROR", 2);
        ERROR = new ShowStatus(..);
        ShowStatus.$values();
        $VALUES = ShowStatus.$values(..);
        return;
    }

    private ShowStatus(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static ShowStatus valueOf(String p0) {
        Enum.valueOf(ShowStatus.class, p0);
        return Enum.valueOf(..);
    }

    public static ShowStatus[] values() {
        ShowStatus.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.WebViewBridgeInterface
// ============================================================
package com.unity3d.ads.adplayer.model;

public abstract class WebViewBridgeInterface {
    public abstract void handleCallback(String p0, String p1, String p2) {
        // native or abstract
    }

    public abstract void handleInvocation(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.WebViewClientError
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class WebViewClientError {
    private final ErrorReason reason;
    private final Integer statusCode;
    private final String url;

    public WebViewClientError(String p0, ErrorReason p1, Integer p2) {
        new Object();
        url = p0;
        reason = p1;
        statusCode = p2;
        return;
    }

    public WebViewClientError(String p0, ErrorReason p1, Integer p2, int p3, DefaultConstructorMarker p4) {
        if (if-eqz(p4)) goto L_6;
      L_6:
        if (if-eqz(p3)) goto L_b;
      L_b:
        new WebViewClientError(0, p1, 0);
        return;
    }

    public static WebViewClientError copy$default(WebViewClientError p0, String p1, ErrorReason p2, Integer p3, int p4, Object p5) {
        if (if-eqz(p5)) goto L_6;
      L_6:
        if (if-eqz(p5)) goto L_c;
      L_c:
        if (if-eqz(p4)) goto L_12;
      L_12:
        p0.copy(url, reason, statusCode);
        return WebViewClientError.copy(..);
    }

    public final String component1() {
        return url;
    }

    public final ErrorReason component2() {
        return reason;
    }

    public final Integer component3() {
        return statusCode;
    }

    public final WebViewClientError copy(String p0, ErrorReason p1, Integer p2) {
        new WebViewClientError(p0, p1, p2);
        return new WebViewClientError(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(url, url);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        if (if-eq(reason, reason)) goto L_1e;
        return 0;
      L_1e:
        Intrinsics.areEqual(statusCode, statusCode);
        if (if-nez(Intrinsics.areEqual(..))) goto L_29;
        return 0;
      L_29:
        return 1;
    }

    public final ErrorReason getReason() {
        return reason;
    }

    public final Integer getStatusCode() {
        return statusCode;
    }

    public final String getUrl() {
        return url;
    }

    public int hashCode() {
        if (if-nez(url)) goto L_7;
      L_7:
        0.hashCode();
      L_b:
        reason.hashCode();
        if (if-nez(statusCode)) goto L_1b;
      L_1b:
        statusCode.hashCode();
      L_1f:
        return String.hashCode(..);
    }

    public String toString() {
        new StringBuilder("WebViewClientError(url=");
        new StringBuilder(..).append(url);
        new StringBuilder(..).append(", reason=");
        new StringBuilder(..).append(reason);
        new StringBuilder(..).append(", statusCode=");
        new StringBuilder(..).append(statusCode);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.WebViewEvent
// ============================================================
package com.unity3d.ads.adplayer.model;

public abstract class WebViewEvent {
    public abstract String getCategory() {
        // native or abstract
    }

    public abstract String getName() {
        // native or abstract
    }

    public abstract Object[] getParameters() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.LoadEvent$Completed
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class LoadEvent$Completed extends LoadEvent {
    public static final LoadEvent$Completed INSTANCE;

    static <clinit>() {
        new LoadEvent$Completed();
        INSTANCE = new LoadEvent$Completed(..);
        return;
    }

    private LoadEvent$Completed() {
        new LoadEvent(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.adplayer.model.LoadEvent$Error
// ============================================================
package com.unity3d.ads.adplayer.model;

public final class LoadEvent$Error extends LoadEvent {
    private final int errorCode;
    private final String message;

    public LoadEvent$Error(String p0, int p1) {
        new LoadEvent(0);
        message = p0;
        errorCode = p1;
        return;
    }

    public static LoadEvent$Error copy$default(LoadEvent$Error p0, String p1, int p2, int p3, Object p4) {
        if (if-eqz(p4)) goto L_6;
      L_6:
        if (if-eqz(p3)) goto L_c;
      L_c:
        p0.copy(message, errorCode);
        return LoadEvent$Error.copy(..);
    }

    public final String component1() {
        return message;
    }

    public final int component2() {
        return errorCode;
    }

    public final LoadEvent$Error copy(String p0, int p1) {
        new LoadEvent$Error(p0, p1);
        return new LoadEvent$Error(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(message, message);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        if (if-eq(errorCode, errorCode)) goto L_1e;
        return 0;
      L_1e:
        return 1;
    }

    public final int getErrorCode() {
        return errorCode;
    }

    public final String getMessage() {
        return message;
    }

    public int hashCode() {
        message.hashCode();
        return String.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Error(message=");
        new StringBuilder(..).append(message);
        new StringBuilder(..).append(", errorCode=");
        new StringBuilder(..).append(errorCode);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}

