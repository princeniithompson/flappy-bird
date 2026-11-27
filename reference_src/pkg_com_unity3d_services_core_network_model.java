// Package bundle: com.unity3d.services.core.network.model (6 classes)

// ============================================================
// CLASS: com.unity3d.services.core.network.model.BodyType
// ============================================================
package com.unity3d.services.core.network.model;

public final class BodyType extends Enum {
    private static final BodyType[] $VALUES;
    public static final BodyType STRING;
    public static final BodyType UNKNOWN;

    private static final BodyType[] $values() {
        return 2;
    }

    static <clinit>() {
        new BodyType("UNKNOWN", 0);
        UNKNOWN = new BodyType(..);
        new BodyType("STRING", 1);
        STRING = new BodyType(..);
        BodyType.$values();
        $VALUES = BodyType.$values(..);
        return;
    }

    private BodyType(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static BodyType valueOf(String p0) {
        Enum.valueOf(BodyType.class, p0);
        return Enum.valueOf(..);
    }

    public static BodyType[] values() {
        BodyType.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.model.HttpRequest
// ============================================================
package com.unity3d.services.core.network.model;

public final class HttpRequest {
    public static final HttpRequest$Companion Companion = null;
    public static final String DEFAULT_SCHEME = "https";
    public static final int DEFAULT_TIMEOUT = 30000;
    private final String baseURL;
    private final Object body;
    private final BodyType bodyType;
    private final int callTimeout;
    private final int connectTimeout;
    private final File downloadDestination;
    private final Map headers;
    private final boolean isProtobuf;
    private final RequestType method;
    private final OperationType operationType;
    private final Map parameters;
    private final String path;
    private final Integer port;
    private final int priority;
    private final int readTimeout;
    private final String scheme;
    private final int writeTimeout;

    static <clinit>() {
        new HttpRequest$Companion(0);
        Companion = new HttpRequest$Companion(..);
        return;
    }

    public HttpRequest(String p0) {
        new HttpRequest(p0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        return;
    }

    public HttpRequest(String p0, String p1) {
        new HttpRequest(p0, p1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2) {
        new HttpRequest(p0, p1, p2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3) {
        new HttpRequest(p0, p1, p2, p3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3, Map p4) {
        new HttpRequest(p0, p1, p2, p3, p4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3, Map p4, Map p5) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3, Map p4, Map p5, BodyType p6) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, 0, 0, 0, 0, 0, 0, 0, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3, Map p4, Map p5, BodyType p6, String p7) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, 0, 0, 0, 0, 0, 0, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3, Map p4, Map p5, BodyType p6, String p7, Integer p8) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, 0, 0, 0, 0, 0, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3, Map p4, Map p5, BodyType p6, String p7, Integer p8, int p9) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, 0, 0, 0, 0, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3, Map p4, Map p5, BodyType p6, String p7, Integer p8, int p9, int p10) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, 0, 0, 0, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3, Map p4, Map p5, BodyType p6, String p7, Integer p8, int p9, int p10, int p11) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, 0, 0, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3, Map p4, Map p5, BodyType p6, String p7, Integer p8, int p9, int p10, int p11, int p12) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, 0, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3, Map p4, Map p5, BodyType p6, String p7, Integer p8, int p9, int p10, int p11, int p12, boolean p13) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3, Map p4, Map p5, BodyType p6, String p7, Integer p8, int p9, int p10, int p11, int p12, boolean p13, OperationType p14) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3, Map p4, Map p5, BodyType p6, String p7, Integer p8, int p9, int p10, int p11, int p12, boolean p13, OperationType p14, File p15) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3, Map p4, Map p5, BodyType p6, String p7, Integer p8, int p9, int p10, int p11, int p12, boolean p13, OperationType p14, File p15, int p16) {
        new Object();
        baseURL = p0;
        path = p1;
        method = p2;
        body = p3;
        headers = p4;
        parameters = p5;
        bodyType = p6;
        scheme = p7;
        port = p8;
        connectTimeout = p9;
        readTimeout = p10;
        writeTimeout = p11;
        callTimeout = p12;
        isProtobuf = p13;
        operationType = p14;
        downloadDestination = p15;
        priority = p16;
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, Object p3, Map p4, Map p5, BodyType p6, String p7, Integer p8, int p9, int p10, int p11, int p12, boolean p13, OperationType p14, File p15, int p16, int p17, DefaultConstructorMarker p18) {
        if (if-eqz(v1)) goto L_9;
      L_9:
      L_b:
        if (if-eqz(v2)) goto L_12;
      L_12:
      L_14:
        if (if-eqz(v3)) goto L_1a;
      L_1a:
      L_1c:
        if (if-eqz(v5)) goto L_25;
        MapsKt.emptyMap();
      L_25:
      L_27:
        if (if-eqz(v6)) goto L_30;
        MapsKt.emptyMap();
      L_30:
      L_32:
        if (if-eqz(v7)) goto L_39;
      L_39:
      L_3b:
        if (if-eqz(v8)) goto L_42;
      L_42:
      L_44:
        if (if-eqz(v9)) goto L_4a;
      L_4a:
      L_4c:
        if (if-eqz(v10)) goto L_54;
      L_54:
      L_56:
        if (if-eqz(v12)) goto L_5c;
      L_5c:
      L_5e:
        if (if-eqz(v13)) goto L_64;
      L_64:
      L_66:
        if (if-eqz(v14)) goto L_6b;
      L_6b:
      L_6d:
        if (if-eqz(v14)) goto L_74;
      L_74:
      L_76:
        if (if-eqz(v4)) goto L_7d;
      L_7d:
      L_7f:
        if (if-eqz(32768)) goto L_89;
      L_89:
      L_8b:
        if (if-eqz(p17)) goto L_92;
      L_92:
      L_94:
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14);
        return;
    }

    public static HttpRequest copy$default(HttpRequest p0, String p1, String p2, RequestType p3, Object p4, Map p5, Map p6, BodyType p7, String p8, Integer p9, int p10, int p11, int p12, int p13, boolean p14, OperationType p15, File p16, int p17, int p18, Object p19) {
        if (if-eqz(v2)) goto L_b;
      L_b:
      L_d:
        if (if-eqz(v3)) goto L_14;
      L_14:
      L_16:
        if (if-eqz(v4)) goto L_1d;
      L_1d:
      L_1f:
        if (if-eqz(v5)) goto L_26;
      L_26:
      L_28:
        if (if-eqz(v6)) goto L_2f;
      L_2f:
      L_31:
        if (if-eqz(v7)) goto L_38;
      L_38:
      L_3a:
        if (if-eqz(v8)) goto L_41;
      L_41:
      L_43:
        if (if-eqz(v9)) goto L_4a;
      L_4a:
      L_4c:
        if (if-eqz(v10)) goto L_53;
      L_53:
      L_55:
        if (if-eqz(v11)) goto L_5c;
      L_5c:
      L_5e:
        if (if-eqz(v12)) goto L_65;
      L_65:
      L_67:
        if (if-eqz(v13)) goto L_6e;
      L_6e:
      L_70:
        if (if-eqz(v14)) goto L_77;
      L_77:
      L_79:
        if (if-eqz(v15)) goto L_80;
      L_80:
      L_82:
        if (if-eqz(p14)) goto L_8b;
      L_8b:
      L_8d:
        if (if-eqz(32768)) goto L_99;
      L_99:
      L_9b:
        if (if-eqz(p18)) goto L_a4;
      L_a4:
      L_a6:
        p0.copy(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15);
        return HttpRequest.copy(..);
    }

    public final String component1() {
        return baseURL;
    }

    public final int component10() {
        return connectTimeout;
    }

    public final int component11() {
        return readTimeout;
    }

    public final int component12() {
        return writeTimeout;
    }

    public final int component13() {
        return callTimeout;
    }

    public final boolean component14() {
        return isProtobuf;
    }

    public final OperationType component15() {
        return operationType;
    }

    public final File component16() {
        return downloadDestination;
    }

    public final int component17() {
        return priority;
    }

    public final String component2() {
        return path;
    }

    public final RequestType component3() {
        return method;
    }

    public final Object component4() {
        return body;
    }

    public final Map component5() {
        return headers;
    }

    public final Map component6() {
        return parameters;
    }

    public final BodyType component7() {
        return bodyType;
    }

    public final String component8() {
        return scheme;
    }

    public final Integer component9() {
        return port;
    }

    public final HttpRequest copy(String p0, String p1, RequestType p2, Object p3, Map p4, Map p5, BodyType p6, String p7, Integer p8, int p9, int p10, int p11, int p12, boolean p13, OperationType p14, File p15, int p16) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14);
        return new HttpRequest;
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(baseURL, baseURL);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        Intrinsics.areEqual(path, path);
        if (if-nez(Intrinsics.areEqual(..))) goto L_22;
        return 0;
      L_22:
        if (if-eq(method, method)) goto L_29;
        return 0;
      L_29:
        Intrinsics.areEqual(body, body);
        if (if-nez(Intrinsics.areEqual(..))) goto L_34;
        return 0;
      L_34:
        Intrinsics.areEqual(headers, headers);
        if (if-nez(Intrinsics.areEqual(..))) goto L_3f;
        return 0;
      L_3f:
        Intrinsics.areEqual(parameters, parameters);
        if (if-nez(Intrinsics.areEqual(..))) goto L_4a;
        return 0;
      L_4a:
        if (if-eq(bodyType, bodyType)) goto L_51;
        return 0;
      L_51:
        Intrinsics.areEqual(scheme, scheme);
        if (if-nez(Intrinsics.areEqual(..))) goto L_5c;
        return 0;
      L_5c:
        Intrinsics.areEqual(port, port);
        if (if-nez(Intrinsics.areEqual(..))) goto L_67;
        return 0;
      L_67:
        if (if-eq(connectTimeout, connectTimeout)) goto L_6e;
        return 0;
      L_6e:
        if (if-eq(readTimeout, readTimeout)) goto L_75;
        return 0;
      L_75:
        if (if-eq(writeTimeout, writeTimeout)) goto L_7c;
        return 0;
      L_7c:
        if (if-eq(callTimeout, callTimeout)) goto L_83;
        return 0;
      L_83:
        if (if-eq(isProtobuf, isProtobuf)) goto L_8a;
        return 0;
      L_8a:
        if (if-eq(operationType, operationType)) goto L_91;
        return 0;
      L_91:
        Intrinsics.areEqual(downloadDestination, downloadDestination);
        if (if-nez(Intrinsics.areEqual(..))) goto L_9c;
        return 0;
      L_9c:
        if (if-eq(priority, priority)) goto L_a3;
        return 0;
      L_a3:
        return 1;
    }

    public final String getBaseURL() {
        return baseURL;
    }

    public final Object getBody() {
        return body;
    }

    public final BodyType getBodyType() {
        return bodyType;
    }

    public final int getCallTimeout() {
        return callTimeout;
    }

    public final int getConnectTimeout() {
        return connectTimeout;
    }

    public final File getDownloadDestination() {
        return downloadDestination;
    }

    public final Map getHeaders() {
        return headers;
    }

    public final RequestType getMethod() {
        return method;
    }

    public final OperationType getOperationType() {
        return operationType;
    }

    public final Map getParameters() {
        return parameters;
    }

    public final String getPath() {
        return path;
    }

    public final Integer getPort() {
        return port;
    }

    public final int getPriority() {
        return priority;
    }

    public final int getReadTimeout() {
        return readTimeout;
    }

    public final String getScheme() {
        return scheme;
    }

    public final int getWriteTimeout() {
        return writeTimeout;
    }

    public int hashCode() {
        baseURL.hashCode();
        path.hashCode();
        method.hashCode();
        if (if-nez(body)) goto L_21;
      L_21:
        0.hashCode();
      L_25:
        headers.hashCode();
        parameters.hashCode();
        bodyType.hashCode();
        scheme.hashCode();
        if (if-nez(port)) goto L_52;
      L_52:
        0.hashCode();
      L_56:
        if (if-eqz(isProtobuf)) goto L_72;
      L_72:
        operationType.hashCode();
        if (if-nez(downloadDestination)) goto L_83;
      L_83:
        downloadDestination.hashCode();
      L_87:
        return String.hashCode(..);
    }

    public final boolean isProtobuf() {
        return isProtobuf;
    }

    public String toString() {
        new StringBuilder("HttpRequest(baseURL=");
        new StringBuilder(..).append(baseURL);
        new StringBuilder(..).append(", path=");
        new StringBuilder(..).append(path);
        new StringBuilder(..).append(", method=");
        new StringBuilder(..).append(method);
        new StringBuilder(..).append(", body=");
        new StringBuilder(..).append(body);
        new StringBuilder(..).append(", headers=");
        new StringBuilder(..).append(headers);
        new StringBuilder(..).append(", parameters=");
        new StringBuilder(..).append(parameters);
        new StringBuilder(..).append(", bodyType=");
        new StringBuilder(..).append(bodyType);
        new StringBuilder(..).append(", scheme=");
        new StringBuilder(..).append(scheme);
        new StringBuilder(..).append(", port=");
        new StringBuilder(..).append(port);
        new StringBuilder(..).append(", connectTimeout=");
        new StringBuilder(..).append(connectTimeout);
        new StringBuilder(..).append(", readTimeout=");
        new StringBuilder(..).append(readTimeout);
        new StringBuilder(..).append(", writeTimeout=");
        new StringBuilder(..).append(writeTimeout);
        new StringBuilder(..).append(", callTimeout=");
        new StringBuilder(..).append(callTimeout);
        new StringBuilder(..).append(", isProtobuf=");
        new StringBuilder(..).append(isProtobuf);
        new StringBuilder(..).append(", operationType=");
        new StringBuilder(..).append(operationType);
        new StringBuilder(..).append(", downloadDestination=");
        new StringBuilder(..).append(downloadDestination);
        new StringBuilder(..).append(", priority=");
        new StringBuilder(..).append(priority);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.model.HttpResponse
// ============================================================
package com.unity3d.services.core.network.model;

public final class HttpResponse {
    private final Object body;
    private final String client;
    private final long contentSize;
    private final Map headers;
    private final String protocol;
    private final int statusCode;
    private final String urlString;

    public HttpResponse(Object p0) {
        new HttpResponse(p0, 0, 0, 0, 0, 0, 0L, v9, 126, 0);
        return;
    }

    public HttpResponse(Object p0, int p1) {
        new HttpResponse(p0, p1, 0, 0, 0, 0, 0L, v9, 124, 0);
        return;
    }

    public HttpResponse(Object p0, int p1, Map p2) {
        new HttpResponse(p0, p1, p2, 0, 0, 0, 0L, v9, 120, 0);
        return;
    }

    public HttpResponse(Object p0, int p1, Map p2, String p3) {
        new HttpResponse(p0, p1, p2, p3, 0, 0, 0L, v9, 112, 0);
        return;
    }

    public HttpResponse(Object p0, int p1, Map p2, String p3, String p4) {
        new HttpResponse(p0, p1, p2, p3, p4, 0, 0L, v9, 96, 0);
        return;
    }

    public HttpResponse(Object p0, int p1, Map p2, String p3, String p4, String p5) {
        new HttpResponse(p0, p1, p2, p3, p4, p5, 0L, v9, 64, 0);
        return;
    }

    public HttpResponse(Object p0, int p1, Map p2, String p3, String p4, String p5, long p6) {
        new Object();
        body = p0;
        statusCode = p1;
        headers = p2;
        urlString = p3;
        protocol = p4;
        client = p5;
        contentSize = p6;
        return;
    }

    public HttpResponse(Object p0, int p1, Map p2, String p3, String p4, String p5, long p6, int p7, DefaultConstructorMarker p8) {
        if (if-eqz(v0)) goto L_7;
      L_7:
      L_8:
        if (if-eqz(v1)) goto L_11;
        MapsKt.emptyMap();
      L_11:
      L_12:
        if (if-eqz(v2)) goto L_1a;
      L_1a:
      L_1b:
        if (if-eqz(v4)) goto L_20;
      L_20:
      L_21:
        if (if-eqz(v4)) goto L_28;
      L_28:
      L_29:
        if (if-eqz(v5)) goto L_30;
      L_30:
      L_31:
        new HttpResponse(p0, p1, p2, p3, p4, p5, p6, p8);
        return;
    }

    public static HttpResponse copy$default(HttpResponse p0, Object p1, int p2, Map p3, String p4, String p5, String p6, long p7, int p8, Object p9) {
        if (if-eqz(v1)) goto L_8;
      L_8:
      L_9:
        if (if-eqz(v2)) goto L_10;
      L_10:
      L_11:
        if (if-eqz(v3)) goto L_18;
      L_18:
      L_19:
        if (if-eqz(v4)) goto L_20;
      L_20:
      L_21:
        if (if-eqz(v5)) goto L_28;
      L_28:
      L_29:
        if (if-eqz(v6)) goto L_30;
      L_30:
      L_31:
        if (if-eqz(v7)) goto L_38;
      L_38:
      L_3a:
        p0.copy(p1, p2, p3, p4, p5, p6, p7, v17);
        return HttpResponse.copy(..);
    }

    public final Object component1() {
        return body;
    }

    public final int component2() {
        return statusCode;
    }

    public final Map component3() {
        return headers;
    }

    public final String component4() {
        return urlString;
    }

    public final String component5() {
        return protocol;
    }

    public final String component6() {
        return client;
    }

    public final long component7() {
        return contentSize;
    }

    public final HttpResponse copy(Object p0, int p1, Map p2, String p3, String p4, String p5, long p6) {
        new HttpResponse(p0, p1, p2, p3, p4, p5, p6, v9);
        return new HttpResponse;
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(body, body);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        if (if-eq(statusCode, statusCode)) goto L_1e;
        return 0;
      L_1e:
        Intrinsics.areEqual(headers, headers);
        if (if-nez(Intrinsics.areEqual(..))) goto L_29;
        return 0;
      L_29:
        Intrinsics.areEqual(urlString, urlString);
        if (if-nez(Intrinsics.areEqual(..))) goto L_34;
        return 0;
      L_34:
        Intrinsics.areEqual(protocol, protocol);
        if (if-nez(Intrinsics.areEqual(..))) goto L_3f;
        return 0;
      L_3f:
        Intrinsics.areEqual(client, client);
        if (if-nez(Intrinsics.areEqual(..))) goto L_4a;
        return 0;
      L_4a:
        if (if-eqz(p0)) goto L_53;
        return 0;
      L_53:
        return 1;
    }

    public final Object getBody() {
        return body;
    }

    public final String getClient() {
        return client;
    }

    public final long getContentSize() {
        return contentSize;
    }

    public final Map getHeaders() {
        return headers;
    }

    public final String getProtocol() {
        return protocol;
    }

    public final int getStatusCode() {
        return statusCode;
    }

    public final String getUrlString() {
        return urlString;
    }

    public int hashCode() {
        body.hashCode();
        headers.hashCode();
        urlString.hashCode();
        protocol.hashCode();
        client.hashCode();
        UByte$$ExternalSyntheticBackport0.m(contentSize, v2);
        return Object.hashCode(..);
    }

    public String toString() {
        new StringBuilder("HttpResponse(body=");
        new StringBuilder(..).append(body);
        new StringBuilder(..).append(", statusCode=");
        new StringBuilder(..).append(statusCode);
        new StringBuilder(..).append(", headers=");
        new StringBuilder(..).append(headers);
        new StringBuilder(..).append(", urlString=");
        new StringBuilder(..).append(urlString);
        new StringBuilder(..).append(", protocol=");
        new StringBuilder(..).append(protocol);
        new StringBuilder(..).append(", client=");
        new StringBuilder(..).append(client);
        new StringBuilder(..).append(", contentSize=");
        new StringBuilder(..).append(contentSize, v2);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.model.HttpResponseKt
// ============================================================
package com.unity3d.services.core.network.model;

public final class HttpResponseKt {
    public static final boolean isSuccessful(HttpResponse p0) {
        p0.getStatusCode();
        if (if-gt(200, HttpResponse.getStatusCode(..))) goto L_13;
        if (if-ge(HttpResponse.getStatusCode(..), 300)) goto L_13;
      L_13:
        return 1;
    }

    public static final HttpResponse toHttpResponse(UnityAdsNetworkException p0) {
        p0.getCode();
        if (if-eqz(UnityAdsNetworkException.getCode(..))) goto L_14;
        UnityAdsNetworkException.getCode(..).intValue();
      L_14:
      L_16:
        MapsKt.emptyMap();
        p0.getUrl();
        if (if-nez(UnityAdsNetworkException.getUrl(..))) goto L_25;
      L_25:
      L_26:
        p0.getProtocol();
        if (if-nez(UnityAdsNetworkException.getProtocol(..))) goto L_2e;
      L_2e:
      L_2f:
        p0.getClient();
        if (if-nez(UnityAdsNetworkException.getClient(..))) goto L_37;
      L_37:
        new HttpResponse("", 520, MapsKt.emptyMap(..), UnityAdsNetworkException.getUrl(..), UnityAdsNetworkException.getProtocol(..), "unknown", 0L, v9, 64, 0);
        return new HttpResponse;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.model.RequestType
// ============================================================
package com.unity3d.services.core.network.model;

public final class RequestType extends Enum {
    private static final RequestType[] $VALUES;
    public static final RequestType GET;
    public static final RequestType HEAD;
    public static final RequestType POST;

    private static final RequestType[] $values() {
        return 3;
    }

    static <clinit>() {
        new RequestType("POST", 0);
        POST = new RequestType(..);
        new RequestType("GET", 1);
        GET = new RequestType(..);
        new RequestType("HEAD", 2);
        HEAD = new RequestType(..);
        RequestType.$values();
        $VALUES = RequestType.$values(..);
        return;
    }

    private RequestType(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static RequestType valueOf(String p0) {
        Enum.valueOf(RequestType.class, p0);
        return Enum.valueOf(..);
    }

    public static RequestType[] values() {
        RequestType.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.model.HttpRequest$Companion
// ============================================================
package com.unity3d.services.core.network.model;

public final class HttpRequest$Companion {
    private HttpRequest$Companion() {
        new Object();
        return;
    }

    public HttpRequest$Companion(DefaultConstructorMarker p0) {
        new HttpRequest$Companion();
        return;
    }

}

