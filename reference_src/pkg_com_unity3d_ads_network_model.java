// Package bundle: com.unity3d.ads.network.model (8 classes)

// ============================================================
// CLASS: com.unity3d.ads.network.model.HttpBody
// ============================================================
package com.unity3d.ads.network.model;

public abstract class HttpBody {
}


// ============================================================
// CLASS: com.unity3d.ads.network.model.HttpRequest
// ============================================================
package com.unity3d.ads.network.model;

public final class HttpRequest {
    public static final HttpRequest$Companion Companion = null;
    private static final String DEFAULT_SCHEME = "https";
    private static final int DEFAULT_TIMEOUT = 30000;
    private final String baseURL;
    private final HttpBody body;
    private final int callTimeout;
    private final int connectTimeout;
    private final Map headers;
    private final RequestType method;
    private final Map parameters;
    private final String path;
    private final Integer port;
    private final int readTimeout;
    private final String scheme;
    private final int writeTimeout;

    static <clinit>() {
        new HttpRequest$Companion(0);
        Companion = new HttpRequest$Companion(..);
        return;
    }

    public HttpRequest(String p0) {
        new HttpRequest(p0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4094, 0);
        return;
    }

    public HttpRequest(String p0, String p1) {
        new HttpRequest(p0, p1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4092, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2) {
        new HttpRequest(p0, p1, p2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4088, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, HttpBody p3) {
        new HttpRequest(p0, p1, p2, p3, 0, 0, 0, 0, 0, 0, 0, 0, 4080, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, HttpBody p3, Map p4) {
        new HttpRequest(p0, p1, p2, p3, p4, 0, 0, 0, 0, 0, 0, 0, 4064, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, HttpBody p3, Map p4, Map p5) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, 0, 0, 0, 0, 0, 0, 4032, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, HttpBody p3, Map p4, Map p5, String p6) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, 0, 0, 0, 0, 0, 3968, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, HttpBody p3, Map p4, Map p5, String p6, Integer p7) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, 0, 0, 0, 0, 3840, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, HttpBody p3, Map p4, Map p5, String p6, Integer p7, int p8) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, 0, 0, 0, 3584, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, HttpBody p3, Map p4, Map p5, String p6, Integer p7, int p8, int p9) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, 0, 0, 3072, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, HttpBody p3, Map p4, Map p5, String p6, Integer p7, int p8, int p9, int p10) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, 0, 2048, 0);
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, HttpBody p3, Map p4, Map p5, String p6, Integer p7, int p8, int p9, int p10, int p11) {
        new Object();
        baseURL = p0;
        path = p1;
        method = p2;
        body = p3;
        headers = p4;
        parameters = p5;
        scheme = p6;
        port = p7;
        connectTimeout = p8;
        readTimeout = p9;
        writeTimeout = p10;
        callTimeout = p11;
        return;
    }

    public HttpRequest(String p0, String p1, RequestType p2, HttpBody p3, Map p4, Map p5, String p6, Integer p7, int p8, int p9, int p10, int p11, int p12, DefaultConstructorMarker p13) {
        if (if-eqz(v1)) goto L_9;
      L_9:
      L_a:
        if (if-eqz(v2)) goto L_11;
      L_11:
      L_12:
        if (if-eqz(v3)) goto L_1b;
      L_1b:
      L_1d:
        if (if-eqz(v4)) goto L_26;
        MapsKt.emptyMap();
      L_26:
      L_28:
        if (if-eqz(v5)) goto L_31;
        MapsKt.emptyMap();
      L_31:
      L_33:
        if (if-eqz(v6)) goto L_3a;
      L_3a:
      L_3c:
        if (if-eqz(v7)) goto L_42;
      L_42:
      L_44:
        if (if-eqz(v8)) goto L_4c;
      L_4c:
      L_4e:
        if (if-eqz(v10)) goto L_54;
      L_54:
      L_56:
        if (if-eqz(v11)) goto L_5c;
      L_5c:
      L_5e:
        if (if-eqz(p12)) goto L_63;
      L_63:
      L_65:
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
        return;
    }

    public static HttpRequest copy$default(HttpRequest p0, String p1, String p2, RequestType p3, HttpBody p4, Map p5, Map p6, String p7, Integer p8, int p9, int p10, int p11, int p12, int p13, Object p14) {
        if (if-eqz(v2)) goto L_a;
      L_a:
      L_b:
        if (if-eqz(v3)) goto L_12;
      L_12:
      L_13:
        if (if-eqz(v4)) goto L_1a;
      L_1a:
      L_1c:
        if (if-eqz(v5)) goto L_23;
      L_23:
      L_25:
        if (if-eqz(v6)) goto L_2c;
      L_2c:
      L_2e:
        if (if-eqz(v7)) goto L_35;
      L_35:
      L_37:
        if (if-eqz(v8)) goto L_3e;
      L_3e:
      L_40:
        if (if-eqz(v9)) goto L_47;
      L_47:
      L_49:
        if (if-eqz(v10)) goto L_50;
      L_50:
      L_52:
        if (if-eqz(v11)) goto L_59;
      L_59:
      L_5b:
        if (if-eqz(v12)) goto L_62;
      L_62:
      L_64:
        if (if-eqz(p13)) goto L_6b;
      L_6b:
      L_6d:
        p0.copy(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12);
        return HttpRequest.copy(..);
    }

    public final String component1() {
        return baseURL;
    }

    public final int component10() {
        return readTimeout;
    }

    public final int component11() {
        return writeTimeout;
    }

    public final int component12() {
        return callTimeout;
    }

    public final String component2() {
        return path;
    }

    public final RequestType component3() {
        return method;
    }

    public final HttpBody component4() {
        return body;
    }

    public final Map component5() {
        return headers;
    }

    public final Map component6() {
        return parameters;
    }

    public final String component7() {
        return scheme;
    }

    public final Integer component8() {
        return port;
    }

    public final int component9() {
        return connectTimeout;
    }

    public final HttpRequest copy(String p0, String p1, RequestType p2, HttpBody p3, Map p4, Map p5, String p6, Integer p7, int p8, int p9, int p10, int p11) {
        new HttpRequest(p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
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
        Intrinsics.areEqual(scheme, scheme);
        if (if-nez(Intrinsics.areEqual(..))) goto L_55;
        return 0;
      L_55:
        Intrinsics.areEqual(port, port);
        if (if-nez(Intrinsics.areEqual(..))) goto L_60;
        return 0;
      L_60:
        if (if-eq(connectTimeout, connectTimeout)) goto L_67;
        return 0;
      L_67:
        if (if-eq(readTimeout, readTimeout)) goto L_6e;
        return 0;
      L_6e:
        if (if-eq(writeTimeout, writeTimeout)) goto L_75;
        return 0;
      L_75:
        if (if-eq(callTimeout, callTimeout)) goto L_7c;
        return 0;
      L_7c:
        return 1;
    }

    public final String getBaseURL() {
        return baseURL;
    }

    public final HttpBody getBody() {
        return body;
    }

    public final int getCallTimeout() {
        return callTimeout;
    }

    public final int getConnectTimeout() {
        return connectTimeout;
    }

    public final Map getHeaders() {
        return headers;
    }

    public final RequestType getMethod() {
        return method;
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
        body.hashCode();
        headers.hashCode();
        parameters.hashCode();
        scheme.hashCode();
        if (if-nez(port)) goto L_44;
      L_44:
        0.hashCode();
      L_48:
        return String.hashCode(..);
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
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.network.model.HttpResponse
// ============================================================
package com.unity3d.ads.network.model;

public final class HttpResponse {
    private final Object body;
    private final Map headers;
    private final int statusCode;
    private final String urlString;

    public HttpResponse(Object p0) {
        new HttpResponse(p0, 0, 0, 0, 14, 0);
        return;
    }

    public HttpResponse(Object p0, int p1) {
        new HttpResponse(p0, p1, 0, 0, 12, 0);
        return;
    }

    public HttpResponse(Object p0, int p1, Map p2) {
        new HttpResponse(p0, p1, p2, 0, 8, 0);
        return;
    }

    public HttpResponse(Object p0, int p1, Map p2, String p3) {
        new Object();
        body = p0;
        statusCode = p1;
        headers = p2;
        urlString = p3;
        return;
    }

    public HttpResponse(Object p0, int p1, Map p2, String p3, int p4, DefaultConstructorMarker p5) {
        if (if-eqz(p5)) goto L_6;
      L_6:
        if (if-eqz(p5)) goto L_e;
        MapsKt.emptyMap();
      L_e:
        if (if-eqz(p4)) goto L_14;
      L_14:
        new HttpResponse(p0, 200, MapsKt.emptyMap(..), "");
        return;
    }

    public static HttpResponse copy$default(HttpResponse p0, Object p1, int p2, Map p3, String p4, int p5, Object p6) {
        if (if-eqz(p6)) goto L_6;
      L_6:
        if (if-eqz(p6)) goto L_c;
      L_c:
        if (if-eqz(p6)) goto L_12;
      L_12:
        if (if-eqz(p5)) goto L_18;
      L_18:
        p0.copy(body, statusCode, headers, urlString);
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

    public final HttpResponse copy(Object p0, int p1, Map p2, String p3) {
        new HttpResponse(p0, p1, p2, p3);
        return new HttpResponse(..);
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
        return 1;
    }

    public final Object getBody() {
        return body;
    }

    public final Map getHeaders() {
        return headers;
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
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.network.model.RequestType
// ============================================================
package com.unity3d.ads.network.model;

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
// CLASS: com.unity3d.ads.network.model.HttpBody$ByteArrayBody
// ============================================================
package com.unity3d.ads.network.model;

public final class HttpBody$ByteArrayBody {
    private final byte[] content;

    public HttpBody$ByteArrayBody(byte[] p0) {
        new Object();
        content = p0;
        return;
    }

    public final byte[] getContent() {
        return content;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.network.model.HttpBody$EmptyBody
// ============================================================
package com.unity3d.ads.network.model;

public final class HttpBody$EmptyBody {
    public static final HttpBody$EmptyBody INSTANCE;

    static <clinit>() {
        new HttpBody$EmptyBody();
        INSTANCE = new HttpBody$EmptyBody(..);
        return;
    }

    private HttpBody$EmptyBody() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.network.model.HttpBody$StringBody
// ============================================================
package com.unity3d.ads.network.model;

public final class HttpBody$StringBody {
    private final String content;

    public HttpBody$StringBody(String p0) {
        new Object();
        content = p0;
        return;
    }

    public final String getContent() {
        return content;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.network.model.HttpRequest$Companion
// ============================================================
package com.unity3d.ads.network.model;

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

