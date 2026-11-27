
// ===== FILE: com/unity3d/services/core/network/mapper/HttpRequestToOkHttpRequestKt.java =====
package com.unity3d.services.core.network.mapper;

import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.network.model.HttpRequest;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* compiled from: HttpRequestToOkHttpRequest.kt */
@Metadata(m443d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0007\u001a\n\u0010\n\u001a\u00020\t*\u00020\u0007¨\u0006\u000b"}, m444d2 = {"generateOkHttpBody", "Lokhttp3/RequestBody;", "body", "", "generateOkHttpProtobufBody", "generateOkHttpHeaders", "Lokhttp3/Headers;", "Lcom/unity3d/services/core/network/model/HttpRequest;", "toOkHttpProtoRequest", "Lokhttp3/Request;", "toOkHttpRequest", "unity-ads_release"}, m445k = 2, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class HttpRequestToOkHttpRequestKt {
    private static final RequestBody generateOkHttpBody(Object obj) {
        if (obj instanceof byte[]) {
            RequestBody create = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), (byte[]) obj);
            Intrinsics.checkNotNullExpressionValue(create, "create(MediaType.parse(\"…in;charset=utf-8\"), body)");
            return create;
        }
        if (obj instanceof String) {
            RequestBody create2 = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), (String) obj);
            Intrinsics.checkNotNullExpressionValue(create2, "create(MediaType.parse(\"…in;charset=utf-8\"), body)");
            return create2;
        }
        RequestBody create3 = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), "");
        Intrinsics.checkNotNullExpressionValue(create3, "create(MediaType.parse(\"…lain;charset=utf-8\"), \"\")");
        return create3;
    }

    private static final RequestBody generateOkHttpProtobufBody(Object obj) {
        if (obj instanceof byte[]) {
            RequestBody create = RequestBody.create(MediaType.parse(CommonGatewayClient.HEADER_PROTOBUF), (byte[]) obj);
            Intrinsics.checkNotNullExpressionValue(create, "create(MediaType.parse(\"…ation/x-protobuf\"), body)");
            return create;
        }
        if (obj instanceof String) {
            RequestBody create2 = RequestBody.create(MediaType.parse(CommonGatewayClient.HEADER_PROTOBUF), (String) obj);
            Intrinsics.checkNotNullExpressionValue(create2, "create(MediaType.parse(\"…ation/x-protobuf\"), body)");
            return create2;
        }
        RequestBody create3 = RequestBody.create(MediaType.parse(CommonGatewayClient.HEADER_PROTOBUF), "");
        Intrinsics.checkNotNullExpressionValue(create3, "create(MediaType.parse(\"…ication/x-protobuf\"), \"\")");
        return create3;
    }

    private static final Headers generateOkHttpHeaders(HttpRequest httpRequest) {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry<String, List<String>> entry : httpRequest.getHeaders().entrySet()) {
            builder.add(entry.getKey(), CollectionsKt.joinToString$default(entry.getValue(), ",", null, null, 0, null, null, 62, null));
        }
        Headers build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n    .also { he…ng(\",\")) } }\n    .build()");
        return build;
    }

    public static final Request toOkHttpRequest(HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(httpRequest, "<this>");
        Request.Builder url = new Request.Builder().url(StringsKt.removeSuffix(StringsKt.trim(httpRequest.getBaseURL(), '/') + '/' + StringsKt.trim(httpRequest.getPath(), '/'), (CharSequence) UnityAdsConstants.DefaultUrls.AD_ASSET_PATH));
        String requestType = httpRequest.getMethod().toString();
        Object body = httpRequest.getBody();
        Request build = url.method(requestType, body != null ? generateOkHttpBody(body) : null).headers(generateOkHttpHeaders(httpRequest)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n    .url(\"${ba…tpHeaders())\n    .build()");
        return build;
    }

    public static final Request toOkHttpProtoRequest(HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(httpRequest, "<this>");
        Request.Builder url = new Request.Builder().url(StringsKt.removeSuffix(StringsKt.trim(httpRequest.getBaseURL(), '/') + '/' + StringsKt.trim(httpRequest.getPath(), '/'), (CharSequence) UnityAdsConstants.DefaultUrls.AD_ASSET_PATH));
        String requestType = httpRequest.getMethod().toString();
        Object body = httpRequest.getBody();
        Request build = url.method(requestType, body != null ? generateOkHttpProtobufBody(body) : null).headers(generateOkHttpHeaders(httpRequest)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n    .url(\"${ba…tpHeaders())\n    .build()");
        return build;
    }
}

// ===== FILE: com/unity3d/services/core/network/mapper/HttpRequestToWebRequestKt.java =====
package com.unity3d.services.core.network.mapper;

import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.request.WebRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpRequestToWebRequest.kt */
@Metadata(m443d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m444d2 = {"toWebRequest", "Lcom/unity3d/services/core/request/WebRequest;", "Lcom/unity3d/services/core/network/model/HttpRequest;", "unity-ads_release"}, m445k = 2, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class HttpRequestToWebRequestKt {
    public static final WebRequest toWebRequest(HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(httpRequest, "<this>");
        WebRequest webRequest = new WebRequest(httpRequest.getBaseURL(), httpRequest.getMethod().toString(), httpRequest.getHeaders(), httpRequest.getConnectTimeout(), httpRequest.getReadTimeout());
        Object body = httpRequest.getBody();
        if (body instanceof String) {
            webRequest.setBody((String) httpRequest.getBody());
        } else if (body instanceof byte[]) {
            webRequest.setBody((byte[]) httpRequest.getBody());
        }
        return webRequest;
    }
}

// ===== FILE: com/unity3d/services/core/network/mapper/HttpResponseHeaderToJSONArrayKt.java =====
package com.unity3d.services.core.network.mapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* compiled from: HttpResponseHeaderToJSONArray.kt */
@Metadata(m443d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0004\u0018\u00010\u0002¨\u0006\u0005"}, m444d2 = {"toResponseHeadersMap", "Lorg/json/JSONArray;", "", "", "", "unity-ads_release"}, m445k = 2, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class HttpResponseHeaderToJSONArrayKt {
    public static final JSONArray toResponseHeadersMap(Map<String, ? extends List<String>> map) {
        Set<Map.Entry<String, ? extends List<String>>> entrySet;
        if (map != null && (entrySet = map.entrySet()) != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                jSONArray = jSONArray.put(new JSONArray((Collection) CollectionsKt.listOf((String) entry.getKey(), (List) entry.getValue())));
                Intrinsics.checkNotNullExpressionValue(jSONArray, "acc.put(JSONArray(listOf(key, value)))");
            }
            if (jSONArray != null) {
                return jSONArray;
            }
        }
        return new JSONArray();
    }
}

// ===== FILE: com/unity3d/services/core/network/mapper/WebRequestToHttpRequestKt.java =====
package com.unity3d.services.core.network.mapper;

import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.RequestType;
import com.unity3d.services.core.request.WebRequest;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebRequestToHttpRequest.kt */
@Metadata(m443d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m444d2 = {"toHttpRequest", "Lcom/unity3d/services/core/network/model/HttpRequest;", "Lcom/unity3d/services/core/request/WebRequest;", "unity-ads_release"}, m445k = 2, m446mv = {1, 8, 0}, m448xi = 48)
/* loaded from: classes.dex */
public final class WebRequestToHttpRequestKt {
    public static final HttpRequest toHttpRequest(WebRequest webRequest) {
        Intrinsics.checkNotNullParameter(webRequest, "<this>");
        String url = webRequest.getUrl().toString();
        String requestType = webRequest.getRequestType();
        Intrinsics.checkNotNullExpressionValue(requestType, "requestType");
        RequestType valueOf = RequestType.valueOf(requestType);
        Map<String, List<String>> headers = webRequest.getHeaders();
        byte[] body = webRequest.getBody();
        Intrinsics.checkNotNullExpressionValue(url, "toString()");
        Intrinsics.checkNotNullExpressionValue(headers, "headers");
        return new HttpRequest(url, null, valueOf, body, headers, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131042, null);
    }
}
