// Package bundle: com.unity3d.ads.network.mapper (1 classes)

// ============================================================
// CLASS: com.unity3d.ads.network.mapper.HttpRequestToOkHttpRequestKt
// ============================================================
package com.unity3d.ads.network.mapper;

public final class HttpRequestToOkHttpRequestKt {
    private static final RequestBody generateOkHttpBody(HttpBody p0) {
        if (if-eqz(v0)) goto L_15;
        MediaType.parse("text/plain;charset=utf-8");
        p0.getContent();
        RequestBody.create(MediaType.parse(..), HttpBody$StringBody.getContent(..));
      L_15:
        if (if-eqz(MediaType.parse(..))) goto L_28;
        MediaType.parse("text/plain;charset=utf-8");
        RequestBody.create(..).getContent();
        RequestBody.create(MediaType.parse(..), HttpBody$ByteArrayBody.getContent(..));
      L_28:
        if (if-eqz(RequestBody.create(..))) goto L_2e;
      L_2d:
        return 0;
      L_2e:
        new NoWhenBranchMatchedException();
        throw new NoWhenBranchMatchedException(..);
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
        HttpRequestToOkHttpRequestKt.generateOkHttpBody(HttpRequest.getBody(..));
        Request$Builder.url(..).method(RequestType.toString(..), HttpRequestToOkHttpRequestKt.generateOkHttpBody(..));
        HttpRequestToOkHttpRequestKt.generateOkHttpHeaders(p0);
        Request$Builder.method(..).headers(HttpRequestToOkHttpRequestKt.generateOkHttpHeaders(..));
        Request$Builder.headers(..).build();
        return Request$Builder.build(..);
    }

}

