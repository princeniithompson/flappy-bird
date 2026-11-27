// Package bundle: com.unity3d.ads.core.data.model.exception (8 classes)

// ============================================================
// CLASS: com.unity3d.ads.core.data.model.exception.ExposureException
// ============================================================
package com.unity3d.ads.core.data.model.exception;

public final class ExposureException extends Exception {
    private final Object[] parameters;

    public ExposureException(String p0, Object[] p1) {
        new Exception(p0);
        parameters = p1;
        return;
    }

    public final Object[] getParameters() {
        return parameters;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.exception.GatewayException
// ============================================================
package com.unity3d.ads.core.data.model.exception;

public final class GatewayException extends Exception {
    public static final GatewayException$Companion Companion = null;
    public static final String GATEWAY_RESPONSE_DEPTH_INITIALIZATION = "initialization";
    public static final String GATEWAY_RESPONSE_DEPTH_UNIVERSAL = "universal";
    private final String message;
    private final String reason;
    private final String reasonDebug;
    private final Throwable throwable;

    static <clinit>() {
        new GatewayException$Companion(0);
        Companion = new GatewayException$Companion(..);
        return;
    }

    public GatewayException(String p0, Throwable p1, String p2, String p3) {
        new Exception(p0);
        message = p0;
        throwable = p1;
        reason = p2;
        reasonDebug = p3;
        return;
    }

    public GatewayException(String p0, Throwable p1, String p2, String p3, int p4, DefaultConstructorMarker p5) {
        if (if-eqz(p5)) goto L_6;
      L_6:
        if (if-eqz(p5)) goto L_c;
      L_c:
        if (if-eqz(p4)) goto L_11;
      L_11:
        new GatewayException(p0, 0, "gateway", 0);
        return;
    }

    public static GatewayException copy$default(GatewayException p0, String p1, Throwable p2, String p3, String p4, int p5, Object p6) {
        if (if-eqz(p6)) goto L_8;
        p0.getMessage();
      L_8:
        if (if-eqz(p6)) goto L_e;
      L_e:
        if (if-eqz(p6)) goto L_14;
      L_14:
        if (if-eqz(p5)) goto L_1a;
      L_1a:
        p0.copy(GatewayException.getMessage(..), throwable, reason, reasonDebug);
        return GatewayException.copy(..);
    }

    public final String component1() {
        GatewayException.getMessage();
        return GatewayException.getMessage(..);
    }

    public final Throwable component2() {
        return throwable;
    }

    public final String component3() {
        return reason;
    }

    public final String component4() {
        return reasonDebug;
    }

    public final GatewayException copy(String p0, Throwable p1, String p2, String p3) {
        new GatewayException(p0, p1, p2, p3);
        return new GatewayException(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        GatewayException.getMessage();
        p0.getMessage();
        Intrinsics.areEqual(GatewayException.getMessage(..), GatewayException.getMessage(..));
        if (if-nez(Intrinsics.areEqual(..))) goto L_1b;
        return 0;
      L_1b:
        Intrinsics.areEqual(throwable, throwable);
        if (if-nez(Intrinsics.areEqual(..))) goto L_26;
        return 0;
      L_26:
        Intrinsics.areEqual(reason, reason);
        if (if-nez(Intrinsics.areEqual(..))) goto L_31;
        return 0;
      L_31:
        Intrinsics.areEqual(reasonDebug, reasonDebug);
        if (if-nez(Intrinsics.areEqual(..))) goto L_3c;
        return 0;
      L_3c:
        return 1;
    }

    public String getMessage() {
        return message;
    }

    public final String getReason() {
        return reason;
    }

    public final String getReasonDebug() {
        return reasonDebug;
    }

    public final Throwable getThrowable() {
        return throwable;
    }

    public int hashCode() {
        GatewayException.getMessage();
        GatewayException.getMessage(..).hashCode();
        if (if-nez(throwable)) goto L_11;
      L_11:
        0.hashCode();
      L_15:
        reason.hashCode();
        if (if-nez(reasonDebug)) goto L_26;
      L_26:
        reasonDebug.hashCode();
      L_2a:
        return String.hashCode(..);
    }

    public String toString() {
        new StringBuilder("GatewayException(message=");
        GatewayException.getMessage();
        new StringBuilder(..).append(GatewayException.getMessage(..));
        new StringBuilder(..).append(", throwable=");
        new StringBuilder(..).append(throwable);
        new StringBuilder(..).append(", reason=");
        new StringBuilder(..).append(reason);
        new StringBuilder(..).append(", reasonDebug=");
        new StringBuilder(..).append(reasonDebug);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.exception.InitializationException
// ============================================================
package com.unity3d.ads.core.data.model.exception;

public final class InitializationException extends Exception {
    public static final InitializationException$Companion Companion;
    private final String message;
    private final String reason;
    private final String reasonDebug;
    private final Throwable throwable;

    static <clinit>() {
        new InitializationException$Companion(0);
        Companion = new InitializationException$Companion(..);
        return;
    }

    public InitializationException(String p0, Throwable p1, String p2, String p3) {
        new Exception(p0);
        message = p0;
        throwable = p1;
        reason = p2;
        reasonDebug = p3;
        return;
    }

    public InitializationException(String p0, Throwable p1, String p2, String p3, int p4, DefaultConstructorMarker p5) {
        if (if-eqz(p5)) goto L_6;
      L_6:
        if (if-eqz(p5)) goto L_c;
      L_c:
        if (if-eqz(p4)) goto L_11;
      L_11:
        new InitializationException(p0, 0, "gateway", 0);
        return;
    }

    public static InitializationException copy$default(InitializationException p0, String p1, Throwable p2, String p3, String p4, int p5, Object p6) {
        if (if-eqz(p6)) goto L_8;
        p0.getMessage();
      L_8:
        if (if-eqz(p6)) goto L_e;
      L_e:
        if (if-eqz(p6)) goto L_14;
      L_14:
        if (if-eqz(p5)) goto L_1a;
      L_1a:
        p0.copy(InitializationException.getMessage(..), throwable, reason, reasonDebug);
        return InitializationException.copy(..);
    }

    public final String component1() {
        InitializationException.getMessage();
        return InitializationException.getMessage(..);
    }

    public final Throwable component2() {
        return throwable;
    }

    public final String component3() {
        return reason;
    }

    public final String component4() {
        return reasonDebug;
    }

    public final InitializationException copy(String p0, Throwable p1, String p2, String p3) {
        new InitializationException(p0, p1, p2, p3);
        return new InitializationException(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        InitializationException.getMessage();
        p0.getMessage();
        Intrinsics.areEqual(InitializationException.getMessage(..), InitializationException.getMessage(..));
        if (if-nez(Intrinsics.areEqual(..))) goto L_1b;
        return 0;
      L_1b:
        Intrinsics.areEqual(throwable, throwable);
        if (if-nez(Intrinsics.areEqual(..))) goto L_26;
        return 0;
      L_26:
        Intrinsics.areEqual(reason, reason);
        if (if-nez(Intrinsics.areEqual(..))) goto L_31;
        return 0;
      L_31:
        Intrinsics.areEqual(reasonDebug, reasonDebug);
        if (if-nez(Intrinsics.areEqual(..))) goto L_3c;
        return 0;
      L_3c:
        return 1;
    }

    public String getMessage() {
        return message;
    }

    public final String getReason() {
        return reason;
    }

    public final String getReasonDebug() {
        return reasonDebug;
    }

    public final Throwable getThrowable() {
        return throwable;
    }

    public int hashCode() {
        InitializationException.getMessage();
        String.hashCode();
        if (if-nez(throwable)) goto L_11;
      L_11:
        0.hashCode();
      L_15:
        reason.hashCode();
        if (if-nez(reasonDebug)) goto L_26;
      L_26:
        reasonDebug.hashCode();
      L_2a:
        return String.hashCode(..);
    }

    public String toString() {
        new StringBuilder("InitializationException(message=");
        InitializationException.getMessage();
        new StringBuilder(..).append(InitializationException.getMessage(..));
        new StringBuilder(..).append(", throwable=");
        new StringBuilder(..).append(throwable);
        new StringBuilder(..).append(", reason=");
        new StringBuilder(..).append(reason);
        new StringBuilder(..).append(", reasonDebug=");
        new StringBuilder(..).append(reasonDebug);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.exception.LoadException
// ============================================================
package com.unity3d.ads.core.data.model.exception;

public final class LoadException extends Exception {
    private final int errorCode;

    public LoadException(int p0, String p1) {
        new Exception(p1);
        errorCode = p0;
        return;
    }

    public final int getErrorCode() {
        return errorCode;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.exception.TransactionException
// ============================================================
package com.unity3d.ads.core.data.model.exception;

public final class TransactionException extends Exception {
    public TransactionException(String p0) {
        new Exception(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException
// ============================================================
package com.unity3d.ads.core.data.model.exception;

public final class UnityAdsNetworkException extends Exception {
    private final String client;
    private final Integer code;
    private final Integer cronetCode;
    private final String message;
    private final String protocol;
    private final OperationType type;
    private final String url;

    public UnityAdsNetworkException(String p0, OperationType p1, Integer p2, String p3, String p4, Integer p5, String p6) {
        new Exception(p0);
        message = p0;
        type = p1;
        code = p2;
        url = p3;
        protocol = p4;
        cronetCode = p5;
        client = p6;
        return;
    }

    public UnityAdsNetworkException(String p0, OperationType p1, Integer p2, String p3, String p4, Integer p5, String p6, int p7, DefaultConstructorMarker p8) {
        if (if-eqz(v0)) goto L_7;
      L_7:
      L_8:
        if (if-eqz(v1)) goto L_f;
      L_f:
      L_10:
        if (if-eqz(v3)) goto L_16;
      L_16:
      L_17:
        if (if-eqz(v4)) goto L_1d;
      L_1d:
      L_1e:
        if (if-eqz(v5)) goto L_24;
      L_24:
      L_25:
        if (if-eqz(v6)) goto L_2a;
      L_2a:
      L_2b:
        new UnityAdsNetworkException(p0, p1, p2, p3, p4, p5, p6);
        return;
    }

    public static UnityAdsNetworkException copy$default(UnityAdsNetworkException p0, String p1, OperationType p2, Integer p3, String p4, String p5, Integer p6, String p7, int p8, Object p9) {
        if (if-eqz(p9)) goto L_8;
        p0.getMessage();
      L_8:
        if (if-eqz(p9)) goto L_e;
      L_e:
        if (if-eqz(type)) goto L_15;
      L_15:
        if (if-eqz(type)) goto L_1c;
      L_1c:
        if (if-eqz(type)) goto L_23;
      L_23:
        if (if-eqz(type)) goto L_2a;
      L_2a:
        if (if-eqz(type)) goto L_31;
      L_31:
        p0.copy(UnityAdsNetworkException.getMessage(..), type, code, url, protocol, cronetCode, client);
        return UnityAdsNetworkException.copy(..);
    }

    public final String component1() {
        UnityAdsNetworkException.getMessage();
        return UnityAdsNetworkException.getMessage(..);
    }

    public final OperationType component2() {
        return type;
    }

    public final Integer component3() {
        return code;
    }

    public final String component4() {
        return url;
    }

    public final String component5() {
        return protocol;
    }

    public final Integer component6() {
        return cronetCode;
    }

    public final String component7() {
        return client;
    }

    public final UnityAdsNetworkException copy(String p0, OperationType p1, Integer p2, String p3, String p4, Integer p5, String p6) {
        new UnityAdsNetworkException(p0, p1, p2, p3, p4, p5, p6);
        return new UnityAdsNetworkException;
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        UnityAdsNetworkException.getMessage();
        p0.getMessage();
        Intrinsics.areEqual(UnityAdsNetworkException.getMessage(..), UnityAdsNetworkException.getMessage(..));
        if (if-nez(Intrinsics.areEqual(..))) goto L_1b;
        return 0;
      L_1b:
        if (if-eq(type, type)) goto L_22;
        return 0;
      L_22:
        Intrinsics.areEqual(code, code);
        if (if-nez(Intrinsics.areEqual(..))) goto L_2d;
        return 0;
      L_2d:
        Intrinsics.areEqual(url, url);
        if (if-nez(Intrinsics.areEqual(..))) goto L_38;
        return 0;
      L_38:
        Intrinsics.areEqual(protocol, protocol);
        if (if-nez(Intrinsics.areEqual(..))) goto L_43;
        return 0;
      L_43:
        Intrinsics.areEqual(cronetCode, cronetCode);
        if (if-nez(Intrinsics.areEqual(..))) goto L_4e;
        return 0;
      L_4e:
        Intrinsics.areEqual(client, client);
        if (if-nez(Intrinsics.areEqual(..))) goto L_59;
        return 0;
      L_59:
        return 1;
    }

    public final String getClient() {
        return client;
    }

    public final Integer getCode() {
        return code;
    }

    public final Integer getCronetCode() {
        return cronetCode;
    }

    public String getMessage() {
        return message;
    }

    public final String getProtocol() {
        return protocol;
    }

    public final OperationType getType() {
        return type;
    }

    public final String getUrl() {
        return url;
    }

    public int hashCode() {
        UnityAdsNetworkException.getMessage();
        String.hashCode();
        type.hashCode();
        if (if-nez(code)) goto L_1a;
      L_1a:
        0.hashCode();
      L_1e:
        if (if-nez(url)) goto L_27;
      L_27:
        0.hashCode();
      L_2b:
        if (if-nez(protocol)) goto L_34;
      L_34:
        0.hashCode();
      L_38:
        if (if-nez(cronetCode)) goto L_41;
      L_41:
        0.hashCode();
      L_45:
        if (if-nez(client)) goto L_4d;
      L_4d:
        client.hashCode();
      L_51:
        return String.hashCode(..);
    }

    public String toString() {
        new StringBuilder("UnityAdsNetworkException(message=");
        UnityAdsNetworkException.getMessage();
        new StringBuilder(..).append(UnityAdsNetworkException.getMessage(..));
        new StringBuilder(..).append(", type=");
        new StringBuilder(..).append(type);
        new StringBuilder(..).append(", code=");
        new StringBuilder(..).append(code);
        new StringBuilder(..).append(", url=");
        new StringBuilder(..).append(url);
        new StringBuilder(..).append(", protocol=");
        new StringBuilder(..).append(protocol);
        new StringBuilder(..).append(", cronetCode=");
        new StringBuilder(..).append(cronetCode);
        new StringBuilder(..).append(", client=");
        new StringBuilder(..).append(client);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.exception.GatewayException$Companion
// ============================================================
package com.unity3d.ads.core.data.model.exception;

public final class GatewayException$Companion {
    private GatewayException$Companion() {
        new Object();
        return;
    }

    public GatewayException$Companion(DefaultConstructorMarker p0) {
        new GatewayException$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.exception.InitializationException$Companion
// ============================================================
package com.unity3d.ads.core.data.model.exception;

public final class InitializationException$Companion {
    private InitializationException$Companion() {
        new Object();
        return;
    }

    public InitializationException$Companion(DefaultConstructorMarker p0) {
        new InitializationException$Companion();
        return;
    }

    public final InitializationException parseFrom(Exception p0) {
        if (if-eqz("e")) goto L_1a;
        p0.getMessage();
        new InitializationException("Timeout", p0, "timeout", Exception.getMessage(..));
      L_1a:
        if (if-eqz(new InitializationException(..))) goto L_41;
        new StringBuilder("network.");
        Exception.getMessage(..).getCode();
        new StringBuilder(..).append(UnityAdsNetworkException.getCode(..));
        new StringBuilder(..).toString();
        Exception.getMessage(..).getMessage();
        new InitializationException("Network", Exception.getMessage(..), StringBuilder.toString(..), UnityAdsNetworkException.getMessage(..));
      L_41:
        if (if-eqz(new InitializationException(..))) goto L_5b;
        GatewayException.getThrowable();
        GatewayException.getReason();
        GatewayException.getReasonDebug();
        new InitializationException("Initialization failure", GatewayException.getThrowable(..), GatewayException.getReason(..), GatewayException.getReasonDebug(..));
      L_5b:
        if (if-eqz(new InitializationException(..))) goto L_63;
      L_63:
        GatewayException.getReasonDebug(..).getMessage();
        new InitializationException("Initialization failure", GatewayException.getReasonDebug(..), "unknown", Exception.getMessage(..));
      L_71:
        return new InitializationException(..);
    }

}

