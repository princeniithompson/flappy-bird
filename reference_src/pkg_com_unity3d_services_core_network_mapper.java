// Package bundle: com.unity3d.services.core.network.mapper (4 classes)

// ============================================================
// CLASS: com.unity3d.services.core.network.mapper.HttpRequestToOkHttpRequestKt
// ============================================================
package com.unity3d.services.core.network.mapper;

public final class HttpRequestToOkHttpRequestKt {
    private static final RequestBody generateOkHttpBody(Object p0) {
        if (if-eqz(v0)) goto L_16;
        MediaType.parse("text/plain;charset=utf-8");
        RequestBody.create(MediaType.parse(..), p0);
      L_16:
        if (if-eqz(MediaType.parse(..))) goto L_28;
        MediaType.parse("text/plain;charset=utf-8");
        RequestBody.create(MediaType.parse(..), RequestBody.create(..));
      L_28:
        MediaType.parse("text/plain;charset=utf-8");
        RequestBody.create(MediaType.parse(..), "");
      L_37:
        return RequestBody.create(..);
    }

    private static final Headers generateOkHttpHeaders(HttpRequest p0) {
        new Headers$Builder();
        p0.getHeaders();
        HttpRequest.getHeaders(..).entrySet();
        Map.entrySet(..).iterator();
      L_11:
        Set.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_41;
        Set.iterator(..).next();
        Iterator.next(..).getKey();
        Iterator.next(..).getValue();
        CollectionsKt.joinToString$default(Map$Entry.getValue(..), ",", 0, 0, 0, 0, 0, 62, 0);
        new Headers$Builder(..).add(Map$Entry.getKey(..), CollectionsKt.joinToString$default(..));
      L_41:
        new Headers$Builder(..).build();
        return Headers$Builder.build(..);
    }

    private static final RequestBody generateOkHttpProtobufBody(Object p0) {
        if (if-eqz(v0)) goto L_16;
        MediaType.parse("application/x-protobuf");
        RequestBody.create(MediaType.parse(..), p0);
      L_16:
        if (if-eqz(MediaType.parse(..))) goto L_28;
        MediaType.parse("application/x-protobuf");
        RequestBody.create(MediaType.parse(..), RequestBody.create(..));
      L_28:
        MediaType.parse("application/x-protobuf");
        RequestBody.create(MediaType.parse(..), "");
      L_37:
        return RequestBody.create(..);
    }

    public static final Request toOkHttpProtoRequest(HttpRequest p0) {
        new Request$Builder();
        new StringBuilder();
        p0.getBaseURL();
        StringsKt.trim(HttpRequest.getBaseURL(..), v4);
        new StringBuilder(..).append(StringsKt.trim(..));
        new StringBuilder(..).append(47);
        p0.getPath();
        StringsKt.trim(HttpRequest.getPath(..), 1);
        new StringBuilder(..).append(StringsKt.trim(..));
        new StringBuilder(..).toString();
        StringsKt.removeSuffix(StringBuilder.toString(..), "/");
        new Request$Builder(..).url(StringsKt.removeSuffix(..));
        p0.getMethod();
        HttpRequest.getMethod(..).toString();
        p0.getBody();
        if (if-eqz(HttpRequest.getBody(..))) goto L_57;
        HttpRequestToOkHttpRequestKt.generateOkHttpProtobufBody(HttpRequest.getBody(..));
      L_57:
      L_58:
        Request$Builder.url(..).method(RequestType.toString(..), 0);
        HttpRequestToOkHttpRequestKt.generateOkHttpHeaders(p0);
        Request$Builder.method(..).headers(HttpRequestToOkHttpRequestKt.generateOkHttpHeaders(..));
        Request$Builder.headers(..).build();
        return Request$Builder.build(..);
    }

    public static final Request toOkHttpRequest(HttpRequest p0) {
        new Request$Builder();
        new StringBuilder();
        p0.getBaseURL();
        StringsKt.trim(HttpRequest.getBaseURL(..), v4);
        new StringBuilder(..).append(StringsKt.trim(..));
        new StringBuilder(..).append(47);
        p0.getPath();
        StringsKt.trim(HttpRequest.getPath(..), 1);
        new StringBuilder(..).append(StringsKt.trim(..));
        new StringBuilder(..).toString();
        StringsKt.removeSuffix(StringBuilder.toString(..), "/");
        new Request$Builder(..).url(StringsKt.removeSuffix(..));
        p0.getMethod();
        HttpRequest.getMethod(..).toString();
        p0.getBody();
        if (if-eqz(HttpRequest.getBody(..))) goto L_57;
        HttpRequestToOkHttpRequestKt.generateOkHttpBody(HttpRequest.getBody(..));
      L_57:
      L_58:
        Request$Builder.url(..).method(RequestType.toString(..), 0);
        HttpRequestToOkHttpRequestKt.generateOkHttpHeaders(p0);
        Request$Builder.method(..).headers(HttpRequestToOkHttpRequestKt.generateOkHttpHeaders(..));
        Request$Builder.headers(..).build();
        return Request$Builder.build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.mapper.HttpRequestToWebRequestKt
// ============================================================
package com.unity3d.services.core.network.mapper;

public final class HttpRequestToWebRequestKt {
    public static final WebRequest toWebRequest(HttpRequest p0) {
        p0.getBaseURL();
        p0.getMethod();
        HttpRequest.getMethod(..).toString();
        p0.getHeaders();
        p0.getConnectTimeout();
        p0.getReadTimeout();
        new WebRequest(HttpRequest.getBaseURL(..), RequestType.toString(..), HttpRequest.getHeaders(..), HttpRequest.getConnectTimeout(..), HttpRequest.getReadTimeout(..));
        p0.getBody();
        if (if-eqz(HttpRequest.getBaseURL(..))) goto L_35;
        p0.getBody();
        new WebRequest.setBody(HttpRequest.getBody(..));
      L_35:
        if (if-eqz(HttpRequest.getBody(..))) goto L_42;
        HttpRequest.getBody(..).getBody();
        new WebRequest.setBody(HttpRequest.getBody(..));
      L_42:
        return new WebRequest;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.mapper.HttpResponseHeaderToJSONArrayKt
// ============================================================
package com.unity3d.services.core.network.mapper;

public final class HttpResponseHeaderToJSONArrayKt {
    public static final JSONArray toResponseHeadersMap(Map p0) {
        if (if-eqz(p0)) goto L_4b;
        p0.entrySet();
        if (if-eqz(Map.entrySet(..))) goto L_4b;
        new JSONArray();
        Map.entrySet(..).iterator();
      L_13:
        Iterable.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_49;
        Iterable.iterator(..).next();
        Iterator.next(..).getKey();
        Iterator.next(..).getValue();
        CollectionsKt.listOf(2);
        new JSONArray(CollectionsKt.listOf(..));
        new JSONArray(..).put(new JSONArray(..));
      L_49:
        if (if-nez(JSONArray.put(..))) goto L_50;
      L_4b:
        new JSONArray();
      L_50:
        return new JSONArray(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.network.mapper.WebRequestToHttpRequestKt
// ============================================================
package com.unity3d.services.core.network.mapper;

public final class WebRequestToHttpRequestKt {
    public static final HttpRequest toHttpRequest(WebRequest p0) {
        p0.getUrl();
        WebRequest.getUrl(..).toString();
        p0.getRequestType();
        RequestType.valueOf(WebRequest.getRequestType(..));
        p0.getHeaders();
        p0.getBody();
        new HttpRequest(URL.toString(..), 0, RequestType.valueOf(..), WebRequest.getBody(..), WebRequest.getHeaders(..), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        return new HttpRequest;
    }

}

