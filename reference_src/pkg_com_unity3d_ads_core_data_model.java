// Package bundle: com.unity3d.ads.core.data.model (40 classes)

// ============================================================
// CLASS: com.unity3d.ads.core.data.model.AdData
// ============================================================
package com.unity3d.ads.core.data.model;

public final class AdData {
    private final String data;

    private AdData(String p0) {
        new Object();
        data = p0;
        return;
    }

    public static final AdData box-impl(String p0) {
        new AdData(p0);
        return new AdData(..);
    }

    public static String constructor-impl(String p0) {
        return p0;
    }

    public static boolean equals-impl(String p0, Object p1) {
        if (if-nez(v0)) goto L_6;
        return 0;
      L_6:
        p1.unbox-impl();
        Intrinsics.areEqual(p0, AdData.unbox-impl(..));
        if (if-nez(Intrinsics.areEqual(..))) goto L_13;
        return 0;
      L_13:
        return 1;
    }

    public static final boolean equals-impl0(String p0, String p1) {
        Intrinsics.areEqual(p0, p1);
        return Intrinsics.areEqual(..);
    }

    public static int hashCode-impl(String p0) {
        p0.hashCode();
        return String.hashCode(..);
    }

    public static String toString-impl(String p0) {
        new StringBuilder("AdData(data=");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    public boolean equals(Object p0) {
        AdData.equals-impl(data, p0);
        return AdData.equals-impl(..);
    }

    public final String getData() {
        return data;
    }

    public int hashCode() {
        AdData.hashCode-impl(data);
        return AdData.hashCode-impl(..);
    }

    public String toString() {
        AdData.toString-impl(data);
        return AdData.toString-impl(..);
    }

    public final String unbox-impl() {
        return data;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.AdDataRefreshToken
// ============================================================
package com.unity3d.ads.core.data.model;

public final class AdDataRefreshToken {
    private final String data;

    private AdDataRefreshToken(String p0) {
        new Object();
        data = p0;
        return;
    }

    public static final AdDataRefreshToken box-impl(String p0) {
        new AdDataRefreshToken(p0);
        return new AdDataRefreshToken(..);
    }

    public static String constructor-impl(String p0) {
        return p0;
    }

    public static boolean equals-impl(String p0, Object p1) {
        if (if-nez(v0)) goto L_6;
        return 0;
      L_6:
        p1.unbox-impl();
        Intrinsics.areEqual(p0, AdDataRefreshToken.unbox-impl(..));
        if (if-nez(Intrinsics.areEqual(..))) goto L_13;
        return 0;
      L_13:
        return 1;
    }

    public static final boolean equals-impl0(String p0, String p1) {
        Intrinsics.areEqual(p0, p1);
        return Intrinsics.areEqual(..);
    }

    public static int hashCode-impl(String p0) {
        p0.hashCode();
        return String.hashCode(..);
    }

    public static String toString-impl(String p0) {
        new StringBuilder("AdDataRefreshToken(data=");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    public boolean equals(Object p0) {
        AdDataRefreshToken.equals-impl(data, p0);
        return AdDataRefreshToken.equals-impl(..);
    }

    public final String getData() {
        return data;
    }

    public int hashCode() {
        AdDataRefreshToken.hashCode-impl(data);
        return AdDataRefreshToken.hashCode-impl(..);
    }

    public String toString() {
        AdDataRefreshToken.toString-impl(data);
        return AdDataRefreshToken.toString-impl(..);
    }

    public final String unbox-impl() {
        return data;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.AdObject
// ============================================================
package com.unity3d.ads.core.data.model;

public final class AdObject {
    private final AdPlayer adPlayer;
    private final DiagnosticEventRequestOuterClass$DiagnosticAdType adType;
    private final Boolean isHeaderBidding;
    private final UnityAdsLoadOptions loadOptions;
    private final ByteString opportunityId;
    private final String placementId;
    private String playerServerId;
    private ByteString trackingToken;

    public AdObject(ByteString p0, String p1, ByteString p2, AdPlayer p3, String p4, UnityAdsLoadOptions p5, Boolean p6, DiagnosticEventRequestOuterClass$DiagnosticAdType p7) {
        new Object();
        opportunityId = p0;
        placementId = p1;
        trackingToken = p2;
        adPlayer = p3;
        playerServerId = p4;
        loadOptions = p5;
        isHeaderBidding = p6;
        adType = p7;
        return;
    }

    public AdObject(ByteString p0, String p1, ByteString p2, AdPlayer p3, String p4, UnityAdsLoadOptions p5, Boolean p6, DiagnosticEventRequestOuterClass$DiagnosticAdType p7, int p8, DefaultConstructorMarker p9) {
        if (if-eqz(v0)) goto L_7;
      L_7:
      L_8:
        if (if-eqz(v0)) goto L_e;
      L_e:
      L_10:
        if (if-eqz(v0)) goto L_16;
      L_16:
      L_18:
        new AdObject(p0, p1, p2, p3, p4, p5, p6, p7);
        return;
    }

    public static AdObject copy$default(AdObject p0, ByteString p1, String p2, ByteString p3, AdPlayer p4, String p5, UnityAdsLoadOptions p6, Boolean p7, DiagnosticEventRequestOuterClass$DiagnosticAdType p8, int p9, Object p10) {
        if (if-eqz(v2)) goto L_a;
      L_a:
      L_b:
        if (if-eqz(v3)) goto L_12;
      L_12:
      L_13:
        if (if-eqz(v4)) goto L_1a;
      L_1a:
      L_1b:
        if (if-eqz(v5)) goto L_22;
      L_22:
      L_23:
        if (if-eqz(v6)) goto L_2a;
      L_2a:
      L_2b:
        if (if-eqz(v7)) goto L_32;
      L_32:
      L_33:
        if (if-eqz(v8)) goto L_3a;
      L_3a:
      L_3c:
        if (if-eqz(p9)) goto L_43;
      L_43:
      L_45:
        p0.copy(p1, p2, p3, p4, p5, p6, p7, p8);
        return AdObject.copy(..);
    }

    public final ByteString component1() {
        return opportunityId;
    }

    public final String component2() {
        return placementId;
    }

    public final ByteString component3() {
        return trackingToken;
    }

    public final AdPlayer component4() {
        return adPlayer;
    }

    public final String component5() {
        return playerServerId;
    }

    public final UnityAdsLoadOptions component6() {
        return loadOptions;
    }

    public final Boolean component7() {
        return isHeaderBidding;
    }

    public final DiagnosticEventRequestOuterClass$DiagnosticAdType component8() {
        return adType;
    }

    public final AdObject copy(ByteString p0, String p1, ByteString p2, AdPlayer p3, String p4, UnityAdsLoadOptions p5, Boolean p6, DiagnosticEventRequestOuterClass$DiagnosticAdType p7) {
        new AdObject(p0, p1, p2, p3, p4, p5, p6, p7);
        return new AdObject;
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(opportunityId, opportunityId);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        Intrinsics.areEqual(placementId, placementId);
        if (if-nez(Intrinsics.areEqual(..))) goto L_22;
        return 0;
      L_22:
        Intrinsics.areEqual(trackingToken, trackingToken);
        if (if-nez(Intrinsics.areEqual(..))) goto L_2d;
        return 0;
      L_2d:
        Intrinsics.areEqual(adPlayer, adPlayer);
        if (if-nez(Intrinsics.areEqual(..))) goto L_38;
        return 0;
      L_38:
        Intrinsics.areEqual(playerServerId, playerServerId);
        if (if-nez(Intrinsics.areEqual(..))) goto L_43;
        return 0;
      L_43:
        Intrinsics.areEqual(loadOptions, loadOptions);
        if (if-nez(Intrinsics.areEqual(..))) goto L_4e;
        return 0;
      L_4e:
        Intrinsics.areEqual(isHeaderBidding, isHeaderBidding);
        if (if-nez(Intrinsics.areEqual(..))) goto L_59;
        return 0;
      L_59:
        if (if-eq(adType, adType)) goto L_60;
        return 0;
      L_60:
        return 1;
    }

    public final AdPlayer getAdPlayer() {
        return adPlayer;
    }

    public final DiagnosticEventRequestOuterClass$DiagnosticAdType getAdType() {
        return adType;
    }

    public final UnityAdsLoadOptions getLoadOptions() {
        return loadOptions;
    }

    public final ByteString getOpportunityId() {
        return opportunityId;
    }

    public final String getPlacementId() {
        return placementId;
    }

    public final String getPlayerServerId() {
        return playerServerId;
    }

    public final ByteString getTrackingToken() {
        return trackingToken;
    }

    public int hashCode() {
        opportunityId.hashCode();
        placementId.hashCode();
        trackingToken.hashCode();
        if (if-nez(adPlayer)) goto L_21;
      L_21:
        0.hashCode();
      L_25:
        if (if-nez(playerServerId)) goto L_2e;
      L_2e:
        0.hashCode();
      L_32:
        loadOptions.hashCode();
        if (if-nez(isHeaderBidding)) goto L_43;
      L_43:
        isHeaderBidding.hashCode();
      L_47:
        adType.hashCode();
        return ByteString.hashCode(..);
    }

    public final Boolean isHeaderBidding() {
        return isHeaderBidding;
    }

    public final void setPlayerServerId(String p0) {
        playerServerId = p0;
        return;
    }

    public final void setTrackingToken(ByteString p0) {
        trackingToken = p0;
        return;
    }

    public String toString() {
        new StringBuilder("AdObject(opportunityId=");
        new StringBuilder(..).append(opportunityId);
        new StringBuilder(..).append(", placementId=");
        new StringBuilder(..).append(placementId);
        new StringBuilder(..).append(", trackingToken=");
        new StringBuilder(..).append(trackingToken);
        new StringBuilder(..).append(", adPlayer=");
        new StringBuilder(..).append(adPlayer);
        new StringBuilder(..).append(", playerServerId=");
        new StringBuilder(..).append(playerServerId);
        new StringBuilder(..).append(", loadOptions=");
        new StringBuilder(..).append(loadOptions);
        new StringBuilder(..).append(", isHeaderBidding=");
        new StringBuilder(..).append(isHeaderBidding);
        new StringBuilder(..).append(", adType=");
        new StringBuilder(..).append(adType);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.ByteStringSerializer
// ============================================================
package com.unity3d.ads.core.data.model;

public final class ByteStringSerializer {
    private final ByteStringStoreOuterClass$ByteStringStore defaultValue;

    public ByteStringSerializer() {
        new Object();
        ByteStringStoreOuterClass$ByteStringStore.getDefaultInstance();
        defaultValue = ByteStringStoreOuterClass$ByteStringStore.getDefaultInstance(..);
        return;
    }

    public ByteStringStoreOuterClass$ByteStringStore getDefaultValue() {
        return defaultValue;
    }

    public Object getDefaultValue() {
        ByteStringSerializer.getDefaultValue();
        return ByteStringSerializer.getDefaultValue(..);
    }

    public Object readFrom(InputStream p0, Continuation p1) {
        ByteStringStoreOuterClass$ByteStringStore.parseFrom(p0);
        return ByteStringStoreOuterClass$ByteStringStore.parseFrom(..);
        new CorruptionException("Cannot read proto.", ByteStringStoreOuterClass$ByteStringStore.parseFrom(..));
        throw new CorruptionException(..);
    }

    public Object writeTo(ByteStringStoreOuterClass$ByteStringStore p0, OutputStream p1, Continuation p2) {
        p0.writeTo(p1);
        return Unit.INSTANCE;
    }

    public Object writeTo(Object p0, OutputStream p1, Continuation p2) {
        ByteStringSerializer.writeTo(p0, p1, p2);
        return ByteStringSerializer.writeTo(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.CacheError
// ============================================================
package com.unity3d.ads.core.data.model;

public final class CacheError extends Enum {
    private static final CacheError[] $VALUES;
    public static final CacheError CACHE_DIRECTORY_DOESNT_EXIST;
    public static final CacheError CACHE_DIRECTORY_EXISTS;
    public static final CacheError CACHE_DIRECTORY_NULL;
    public static final CacheError CACHE_DIRECTORY_TYPE_NULL;
    public static final CacheError FILE_ALREADY_CACHING;
    public static final CacheError FILE_IO_CREATE;
    public static final CacheError FILE_IO_ERROR;
    public static final CacheError FILE_NOT_FOUND;
    public static final CacheError FILE_STATE_WRONG;
    public static final CacheError ILLEGAL_STATE;
    public static final CacheError INVALID_ARGUMENT;
    public static final CacheError JSON_ERROR;
    public static final CacheError MALFORMED_URL;
    public static final CacheError NETWORK_ERROR;
    public static final CacheError NOT_CACHING;
    public static final CacheError NO_INTERNET;
    public static final CacheError UNKNOWN_ERROR;
    public static final CacheError UNSUPPORTED_ENCODING;

    private static final CacheError[] $values() {
        return 18;
    }

    static <clinit>() {
        new CacheError("FILE_IO_CREATE", 0);
        FILE_IO_CREATE = new CacheError(..);
        new CacheError("FILE_IO_ERROR", 1);
        FILE_IO_ERROR = new CacheError(..);
        new CacheError("FILE_NOT_FOUND", 2);
        FILE_NOT_FOUND = new CacheError(..);
        new CacheError("FILE_ALREADY_CACHING", 3);
        FILE_ALREADY_CACHING = new CacheError(..);
        new CacheError("NOT_CACHING", 4);
        NOT_CACHING = new CacheError(..);
        new CacheError("JSON_ERROR", 5);
        JSON_ERROR = new CacheError(..);
        new CacheError("NO_INTERNET", 6);
        NO_INTERNET = new CacheError(..);
        new CacheError("MALFORMED_URL", 7);
        MALFORMED_URL = new CacheError(..);
        new CacheError("NETWORK_ERROR", 8);
        NETWORK_ERROR = new CacheError(..);
        new CacheError("ILLEGAL_STATE", 9);
        ILLEGAL_STATE = new CacheError(..);
        new CacheError("INVALID_ARGUMENT", 10);
        INVALID_ARGUMENT = new CacheError(..);
        new CacheError("UNSUPPORTED_ENCODING", 11);
        UNSUPPORTED_ENCODING = new CacheError(..);
        new CacheError("FILE_STATE_WRONG", 12);
        FILE_STATE_WRONG = new CacheError(..);
        new CacheError("CACHE_DIRECTORY_NULL", 13);
        CACHE_DIRECTORY_NULL = new CacheError(..);
        new CacheError("CACHE_DIRECTORY_TYPE_NULL", 14);
        CACHE_DIRECTORY_TYPE_NULL = new CacheError(..);
        new CacheError("CACHE_DIRECTORY_EXISTS", 15);
        CACHE_DIRECTORY_EXISTS = new CacheError(..);
        new CacheError("CACHE_DIRECTORY_DOESNT_EXIST", 16);
        CACHE_DIRECTORY_DOESNT_EXIST = new CacheError(..);
        new CacheError("UNKNOWN_ERROR", 17);
        UNKNOWN_ERROR = new CacheError(..);
        CacheError.$values();
        $VALUES = CacheError.$values(..);
        return;
    }

    private CacheError(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static CacheError valueOf(String p0) {
        Enum.valueOf(CacheError.class, p0);
        return Enum.valueOf(..);
    }

    public static CacheError[] values() {
        CacheError.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.CacheResult
// ============================================================
package com.unity3d.ads.core.data.model;

public abstract class CacheResult {
    private CacheResult() {
        new Object();
        return;
    }

    public CacheResult(DefaultConstructorMarker p0) {
        new CacheResult();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.CacheSource
// ============================================================
package com.unity3d.ads.core.data.model;

public final class CacheSource extends Enum {
    private static final CacheSource[] $VALUES;
    public static final CacheSource LOCAL;
    public static final CacheSource REMOTE;

    private static final CacheSource[] $values() {
        return 2;
    }

    static <clinit>() {
        new CacheSource("LOCAL", 0);
        LOCAL = new CacheSource(..);
        new CacheSource("REMOTE", 1);
        REMOTE = new CacheSource(..);
        CacheSource.$values();
        $VALUES = CacheSource.$values(..);
        return;
    }

    private CacheSource(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static CacheSource valueOf(String p0) {
        Enum.valueOf(CacheSource.class, p0);
        return Enum.valueOf(..);
    }

    public static CacheSource[] values() {
        CacheSource.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.CachedFile
// ============================================================
package com.unity3d.ads.core.data.model;

public final class CachedFile {
    private final long contentLength;
    private final String extension;
    private final File file;
    private final String name;
    private final String objectId;
    private final int priority;
    private final String protocol;
    private final String url;

    public CachedFile(String p0, String p1, String p2, File p3, String p4, long p5, String p6, int p7) {
        new Object();
        objectId = p0;
        url = p1;
        name = p2;
        file = p3;
        extension = p4;
        contentLength = p5;
        protocol = p6;
        priority = p7;
        return;
    }

    public CachedFile(String p0, String p1, String p2, File p3, String p4, long p5, String p6, int p7, int p8, DefaultConstructorMarker p9) {
        if (if-eqz(v1)) goto L_9;
      L_9:
      L_b:
        if (if-eqz(0)) goto L_13;
      L_13:
      L_15:
        if (if-eqz(0)) goto L_1d;
      L_1d:
      L_1f:
        if (if-eqz(0)) goto L_25;
      L_25:
      L_27:
        if (if-eqz(p8)) goto L_30;
      L_30:
      L_32:
        new CachedFile(p0, p1, p2, p3, p4, p5, v9, p6, p7);
        return;
    }

    public static CachedFile copy$default(CachedFile p0, String p1, String p2, String p3, File p4, String p5, long p6, String p7, int p8, int p9, Object p10) {
        if (if-eqz(v2)) goto L_a;
      L_a:
      L_b:
        if (if-eqz(v3)) goto L_12;
      L_12:
      L_13:
        if (if-eqz(v4)) goto L_1a;
      L_1a:
      L_1b:
        if (if-eqz(v5)) goto L_22;
      L_22:
      L_23:
        if (if-eqz(v6)) goto L_2a;
      L_2a:
      L_2b:
        if (if-eqz(v7)) goto L_32;
      L_32:
      L_34:
        if (if-eqz(v9)) goto L_3b;
      L_3b:
      L_3d:
        if (if-eqz(p9)) goto L_44;
      L_44:
      L_46:
        p0.copy(p1, p2, p3, p4, p5, p6, v17, p7, p8);
        return CachedFile.copy(..);
    }

    public final String component1() {
        return objectId;
    }

    public final String component2() {
        return url;
    }

    public final String component3() {
        return name;
    }

    public final File component4() {
        return file;
    }

    public final String component5() {
        return extension;
    }

    public final long component6() {
        return contentLength;
    }

    public final String component7() {
        return protocol;
    }

    public final int component8() {
        return priority;
    }

    public final CachedFile copy(String p0, String p1, String p2, File p3, String p4, long p5, String p6, int p7) {
        new CachedFile(p0, p1, p2, p3, p4, p5, v8, p6, p7);
        return new CachedFile;
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(objectId, objectId);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        Intrinsics.areEqual(url, url);
        if (if-nez(Intrinsics.areEqual(..))) goto L_22;
        return 0;
      L_22:
        Intrinsics.areEqual(name, name);
        if (if-nez(Intrinsics.areEqual(..))) goto L_2d;
        return 0;
      L_2d:
        Intrinsics.areEqual(file, file);
        if (if-nez(Intrinsics.areEqual(..))) goto L_38;
        return 0;
      L_38:
        Intrinsics.areEqual(extension, extension);
        if (if-nez(Intrinsics.areEqual(..))) goto L_43;
        return 0;
      L_43:
        if (if-eqz(Intrinsics.areEqual(..))) goto L_4c;
        return 0;
      L_4c:
        Intrinsics.areEqual(protocol, protocol);
        if (if-nez(Intrinsics.areEqual(..))) goto L_57;
        return 0;
      L_57:
        if (if-eq(priority, priority)) goto L_5e;
        return 0;
      L_5e:
        return 1;
    }

    public final long getContentLength() {
        return contentLength;
    }

    public final String getExtension() {
        return extension;
    }

    public final File getFile() {
        return file;
    }

    public final String getName() {
        return name;
    }

    public final String getObjectId() {
        return objectId;
    }

    public final int getPriority() {
        return priority;
    }

    public final String getProtocol() {
        return protocol;
    }

    public final String getUrl() {
        return url;
    }

    public int hashCode() {
        objectId.hashCode();
        url.hashCode();
        name.hashCode();
        if (if-nez(file)) goto L_21;
      L_21:
        0.hashCode();
      L_25:
        if (if-nez(extension)) goto L_2d;
      L_2d:
        extension.hashCode();
      L_31:
        UByte$$ExternalSyntheticBackport0.m(contentLength, String.hashCode(..));
        protocol.hashCode();
        return String.hashCode(..);
    }

    public String toString() {
        new StringBuilder("CachedFile(objectId=");
        new StringBuilder(..).append(objectId);
        new StringBuilder(..).append(", url=");
        new StringBuilder(..).append(url);
        new StringBuilder(..).append(", name=");
        new StringBuilder(..).append(name);
        new StringBuilder(..).append(", file=");
        new StringBuilder(..).append(file);
        new StringBuilder(..).append(", extension=");
        new StringBuilder(..).append(extension);
        new StringBuilder(..).append(", contentLength=");
        new StringBuilder(..).append(contentLength, v2);
        new StringBuilder(..).append(", protocol=");
        new StringBuilder(..).append(protocol);
        new StringBuilder(..).append(", priority=");
        new StringBuilder(..).append(priority);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.ImpressionConfig
// ============================================================
package com.unity3d.ads.core.data.model;

public final class ImpressionConfig {
    private final String data;

    private ImpressionConfig(String p0) {
        new Object();
        data = p0;
        return;
    }

    public static final ImpressionConfig box-impl(String p0) {
        new ImpressionConfig(p0);
        return new ImpressionConfig(..);
    }

    public static String constructor-impl(String p0) {
        return p0;
    }

    public static boolean equals-impl(String p0, Object p1) {
        if (if-nez(v0)) goto L_6;
        return 0;
      L_6:
        p1.unbox-impl();
        Intrinsics.areEqual(p0, ImpressionConfig.unbox-impl(..));
        if (if-nez(Intrinsics.areEqual(..))) goto L_13;
        return 0;
      L_13:
        return 1;
    }

    public static final boolean equals-impl0(String p0, String p1) {
        Intrinsics.areEqual(p0, p1);
        return Intrinsics.areEqual(..);
    }

    public static int hashCode-impl(String p0) {
        p0.hashCode();
        return String.hashCode(..);
    }

    public static String toString-impl(String p0) {
        new StringBuilder("ImpressionConfig(data=");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    public boolean equals(Object p0) {
        ImpressionConfig.equals-impl(data, p0);
        return ImpressionConfig.equals-impl(..);
    }

    public final String getData() {
        return data;
    }

    public int hashCode() {
        ImpressionConfig.hashCode-impl(data);
        return ImpressionConfig.hashCode-impl(..);
    }

    public String toString() {
        ImpressionConfig.toString-impl(data);
        return ImpressionConfig.toString-impl(..);
    }

    public final String unbox-impl() {
        return data;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.InitializationState
// ============================================================
package com.unity3d.ads.core.data.model;

public final class InitializationState extends Enum {
    private static final InitializationState[] $VALUES;
    public static final InitializationState FAILED;
    public static final InitializationState INITIALIZED;
    public static final InitializationState INITIALIZING;
    public static final InitializationState NOT_INITIALIZED;

    private static final InitializationState[] $values() {
        return 4;
    }

    static <clinit>() {
        new InitializationState("NOT_INITIALIZED", 0);
        NOT_INITIALIZED = new InitializationState(..);
        new InitializationState("INITIALIZING", 1);
        INITIALIZING = new InitializationState(..);
        new InitializationState("INITIALIZED", 2);
        INITIALIZED = new InitializationState(..);
        new InitializationState("FAILED", 3);
        FAILED = new InitializationState(..);
        InitializationState.$values();
        $VALUES = InitializationState.$values(..);
        return;
    }

    private InitializationState(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static InitializationState valueOf(String p0) {
        Enum.valueOf(InitializationState.class, p0);
        return Enum.valueOf(..);
    }

    public static InitializationState[] values() {
        InitializationState.$VALUES.clone();
        return Object[].clone(..);
    }

    public String toString() {
        Enum.toString();
        Locale.getDefault();
        Enum.toString(..).toLowerCase(Locale.getDefault(..));
        return String.toLowerCase(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.Listeners
// ============================================================
package com.unity3d.ads.core.data.model;

public abstract class Listeners {
    public abstract void onClick(String p0) {
        // native or abstract
    }

    public abstract void onComplete(String p0, UnityAds$UnityAdsShowCompletionState p1) {
        // native or abstract
    }

    public abstract void onError(String p0, UnityAds$UnityAdsShowError p1, String p2) {
        // native or abstract
    }

    public abstract void onLeftApplication(String p0) {
        // native or abstract
    }

    public abstract void onStart(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.LoadResult
// ============================================================
package com.unity3d.ads.core.data.model;

public abstract class LoadResult {
    public static final LoadResult$Companion Companion = null;
    public static final String MSG_AD_MARKUP_PARSING = "[UnityAds] Could not parse Ad Markup";
    public static final String MSG_AD_OBJECT = "[UnityAds] Ad not found";
    public static final String MSG_COMMUNICATION_FAILURE = "[UnityAds] Internal communication failure";
    public static final String MSG_COMMUNICATION_FAILURE_WITH_DETAILS = "[UnityAds] Internal communication failure: %s";
    public static final String MSG_COMMUNICATION_TIMEOUT = "[UnityAds] Internal communication timeout";
    public static final String MSG_CREATE_REQUEST = "[UnityAds] Failed to create load request";
    public static final String MSG_INIT_FAILED = "[UnityAds] SDK Initialization Failed";
    public static final String MSG_INIT_FAILURE = "[UnityAds] SDK Initialization Failure";
    public static final String MSG_NOT_INITIALIZED = "[UnityAds] SDK not initialized";
    public static final String MSG_NO_FILL = "[UnityAds] No fill";
    public static final String MSG_OPPORTUNITY_ID = "[UnityAds] Object ID cannot be null";
    public static final String MSG_OPPORTUNITY_ID_USED = "[UnityAds] Object ID already used";
    public static final String MSG_PLACEMENT_NULL = "[UnityAds] Placement ID cannot be null";
    public static final String MSG_TIMEOUT = "[UnityAds] Timeout while loading ";

    static <clinit>() {
        new LoadResult$Companion(0);
        Companion = new LoadResult$Companion(..);
        return;
    }

    private LoadResult() {
        new Object();
        return;
    }

    public LoadResult(DefaultConstructorMarker p0) {
        new LoadResult();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.OMData
// ============================================================
package com.unity3d.ads.core.data.model;

public final class OMData {
    private final String partnerName;
    private final String partnerVersion;
    private final String version;

    public OMData(String p0, String p1, String p2) {
        new Object();
        version = p0;
        partnerName = p1;
        partnerVersion = p2;
        return;
    }

    public static OMData copy$default(OMData p0, String p1, String p2, String p3, int p4, Object p5) {
        if (if-eqz(p5)) goto L_6;
      L_6:
        if (if-eqz(p5)) goto L_c;
      L_c:
        if (if-eqz(p4)) goto L_12;
      L_12:
        p0.copy(version, partnerName, partnerVersion);
        return OMData.copy(..);
    }

    public final String component1() {
        return version;
    }

    public final String component2() {
        return partnerName;
    }

    public final String component3() {
        return partnerVersion;
    }

    public final OMData copy(String p0, String p1, String p2) {
        new OMData(p0, p1, p2);
        return new OMData(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(version, version);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        Intrinsics.areEqual(partnerName, partnerName);
        if (if-nez(Intrinsics.areEqual(..))) goto L_22;
        return 0;
      L_22:
        Intrinsics.areEqual(partnerVersion, partnerVersion);
        if (if-nez(Intrinsics.areEqual(..))) goto L_2d;
        return 0;
      L_2d:
        return 1;
    }

    public final String getPartnerName() {
        return partnerName;
    }

    public final String getPartnerVersion() {
        return partnerVersion;
    }

    public final String getVersion() {
        return version;
    }

    public int hashCode() {
        String.hashCode();
        partnerName.hashCode();
        partnerVersion.hashCode();
        return String.hashCode(..);
    }

    public String toString() {
        new StringBuilder("OMData(version=");
        new StringBuilder(..).append(version);
        new StringBuilder(..).append(", partnerName=");
        new StringBuilder(..).append(partnerName);
        new StringBuilder(..).append(", partnerVersion=");
        new StringBuilder(..).append(partnerVersion);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.OMResult
// ============================================================
package com.unity3d.ads.core.data.model;

public abstract class OMResult {
    private OMResult() {
        new Object();
        return;
    }

    public OMResult(DefaultConstructorMarker p0) {
        new OMResult();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.OmidOptions
// ============================================================
package com.unity3d.ads.core.data.model;

public final class OmidOptions {
    private final CreativeType creativeType;
    private final String customReferenceData;
    private final Owner impressionOwner;
    private final ImpressionType impressionType;
    private final boolean isolateVerificationScripts;
    private final Owner mediaEventsOwner;
    private final Owner videoEventsOwner;

    public OmidOptions() {
        new OmidOptions(0, 0, 0, 0, 0, 0, 0, 127, 0);
        return;
    }

    public OmidOptions(boolean p0, Owner p1, Owner p2, String p3, ImpressionType p4, CreativeType p5, Owner p6) {
        new Object();
        isolateVerificationScripts = p0;
        impressionOwner = p1;
        videoEventsOwner = p2;
        customReferenceData = p3;
        impressionType = p4;
        creativeType = p5;
        mediaEventsOwner = p6;
        return;
    }

    public OmidOptions(boolean p0, Owner p1, Owner p2, String p3, ImpressionType p4, CreativeType p5, Owner p6, int p7, DefaultConstructorMarker p8) {
        if (if-eqz(p8)) goto L_5;
      L_5:
        if (if-eqz(p8)) goto L_c;
      L_c:
      L_d:
        if (if-eqz(p1)) goto L_13;
      L_13:
      L_14:
        if (if-eqz(p1)) goto L_1a;
      L_1a:
      L_1b:
        if (if-eqz(p1)) goto L_21;
      L_21:
      L_22:
        if (if-eqz(p1)) goto L_28;
      L_28:
      L_29:
        if (if-eqz(p1)) goto L_2e;
      L_2e:
      L_2f:
        new OmidOptions(0, p1, p2, p3, p4, p5, p6);
        return;
    }

    public static OmidOptions copy$default(OmidOptions p0, boolean p1, Owner p2, Owner p3, String p4, ImpressionType p5, CreativeType p6, Owner p7, int p8, Object p9) {
        if (if-eqz(p9)) goto L_6;
      L_6:
        if (if-eqz(p9)) goto L_c;
      L_c:
        if (if-eqz(impressionOwner)) goto L_13;
      L_13:
        if (if-eqz(impressionOwner)) goto L_1a;
      L_1a:
        if (if-eqz(impressionOwner)) goto L_21;
      L_21:
        if (if-eqz(impressionOwner)) goto L_28;
      L_28:
        if (if-eqz(impressionOwner)) goto L_2f;
      L_2f:
        p0.copy(isolateVerificationScripts, impressionOwner, videoEventsOwner, customReferenceData, impressionType, creativeType, mediaEventsOwner);
        return OmidOptions.copy(..);
    }

    public final boolean component1() {
        return isolateVerificationScripts;
    }

    public final Owner component2() {
        return impressionOwner;
    }

    public final Owner component3() {
        return videoEventsOwner;
    }

    public final String component4() {
        return customReferenceData;
    }

    public final ImpressionType component5() {
        return impressionType;
    }

    public final CreativeType component6() {
        return creativeType;
    }

    public final Owner component7() {
        return mediaEventsOwner;
    }

    public final OmidOptions copy(boolean p0, Owner p1, Owner p2, String p3, ImpressionType p4, CreativeType p5, Owner p6) {
        new OmidOptions(p0, p1, p2, p3, p4, p5, p6);
        return new OmidOptions;
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        if (if-eq(isolateVerificationScripts, isolateVerificationScripts)) goto L_13;
        return 0;
      L_13:
        if (if-eq(impressionOwner, impressionOwner)) goto L_1a;
        return 0;
      L_1a:
        if (if-eq(videoEventsOwner, videoEventsOwner)) goto L_21;
        return 0;
      L_21:
        Intrinsics.areEqual(customReferenceData, customReferenceData);
        if (if-nez(Intrinsics.areEqual(..))) goto L_2c;
        return 0;
      L_2c:
        if (if-eq(impressionType, impressionType)) goto L_33;
        return 0;
      L_33:
        if (if-eq(creativeType, creativeType)) goto L_3a;
        return 0;
      L_3a:
        if (if-eq(mediaEventsOwner, mediaEventsOwner)) goto L_41;
        return 0;
      L_41:
        return 1;
    }

    public final CreativeType getCreativeType() {
        return creativeType;
    }

    public final String getCustomReferenceData() {
        return customReferenceData;
    }

    public final Owner getImpressionOwner() {
        return impressionOwner;
    }

    public final ImpressionType getImpressionType() {
        return impressionType;
    }

    public final boolean getIsolateVerificationScripts() {
        return isolateVerificationScripts;
    }

    public final Owner getMediaEventsOwner() {
        return mediaEventsOwner;
    }

    public final Owner getVideoEventsOwner() {
        return videoEventsOwner;
    }

    public int hashCode() {
        if (if-eqz(isolateVerificationScripts)) goto L_5;
      L_5:
        if (if-nez(impressionOwner)) goto L_e;
      L_e:
        0.hashCode();
      L_12:
        if (if-nez(videoEventsOwner)) goto L_1b;
      L_1b:
        0.hashCode();
      L_1f:
        if (if-nez(customReferenceData)) goto L_28;
      L_28:
        0.hashCode();
      L_2c:
        if (if-nez(impressionType)) goto L_35;
      L_35:
        0.hashCode();
      L_39:
        if (if-nez(creativeType)) goto L_42;
      L_42:
        0.hashCode();
      L_46:
        if (if-nez(mediaEventsOwner)) goto L_4e;
      L_4e:
        mediaEventsOwner.hashCode();
      L_52:
        return 1;
    }

    public String toString() {
        new StringBuilder("OmidOptions(isolateVerificationScripts=");
        new StringBuilder(..).append(isolateVerificationScripts);
        new StringBuilder(..).append(", impressionOwner=");
        new StringBuilder(..).append(impressionOwner);
        new StringBuilder(..).append(", videoEventsOwner=");
        new StringBuilder(..).append(videoEventsOwner);
        new StringBuilder(..).append(", customReferenceData=");
        new StringBuilder(..).append(customReferenceData);
        new StringBuilder(..).append(", impressionType=");
        new StringBuilder(..).append(impressionType);
        new StringBuilder(..).append(", creativeType=");
        new StringBuilder(..).append(creativeType);
        new StringBuilder(..).append(", mediaEventsOwner=");
        new StringBuilder(..).append(mediaEventsOwner);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.OperationType
// ============================================================
package com.unity3d.ads.core.data.model;

public final class OperationType extends Enum {
    private static final OperationType[] $VALUES;
    public static final OperationType INITIALIZATION;
    public static final OperationType INITIALIZATION_COMPLETED;
    public static final OperationType LOAD;
    public static final OperationType LOAD_HEADER_BIDDING;
    public static final OperationType PRIVACY_UPDATE;
    public static final OperationType REFRESH;
    public static final OperationType SHOW;
    public static final OperationType TRANSACTION_EVENT;
    public static final OperationType UNIVERSAL_EVENT;
    public static final OperationType UNKNOWN;

    private static final OperationType[] $values() {
        return 10;
    }

    static <clinit>() {
        new OperationType("UNKNOWN", 0);
        UNKNOWN = new OperationType(..);
        new OperationType("INITIALIZATION", 1);
        INITIALIZATION = new OperationType(..);
        new OperationType("LOAD", 2);
        LOAD = new OperationType(..);
        new OperationType("LOAD_HEADER_BIDDING", 3);
        LOAD_HEADER_BIDDING = new OperationType(..);
        new OperationType("SHOW", 4);
        SHOW = new OperationType(..);
        new OperationType("REFRESH", 5);
        REFRESH = new OperationType(..);
        new OperationType("PRIVACY_UPDATE", 6);
        PRIVACY_UPDATE = new OperationType(..);
        new OperationType("INITIALIZATION_COMPLETED", 7);
        INITIALIZATION_COMPLETED = new OperationType(..);
        new OperationType("TRANSACTION_EVENT", 8);
        TRANSACTION_EVENT = new OperationType(..);
        new OperationType("UNIVERSAL_EVENT", 9);
        UNIVERSAL_EVENT = new OperationType(..);
        OperationType.$values();
        $VALUES = OperationType.$values(..);
        return;
    }

    private OperationType(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static OperationType valueOf(String p0) {
        Enum.valueOf(OperationType.class, p0);
        return Enum.valueOf(..);
    }

    public static OperationType[] values() {
        OperationType.$VALUES.clone();
        return Object[].clone(..);
    }

    public String toString() {
        Enum.toString();
        Locale.getDefault();
        Enum.toString(..).toLowerCase(Locale.getDefault(..));
        return String.toLowerCase(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.SessionChange
// ============================================================
package com.unity3d.ads.core.data.model;

public abstract class SessionChange {
    private SessionChange() {
        new Object();
        return;
    }

    public SessionChange(DefaultConstructorMarker p0) {
        new SessionChange();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.ShowEvent
// ============================================================
package com.unity3d.ads.core.data.model;

public abstract class ShowEvent {
    private ShowEvent() {
        new Object();
        return;
    }

    public ShowEvent(DefaultConstructorMarker p0) {
        new ShowEvent();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.StorageType
// ============================================================
package com.unity3d.ads.core.data.model;

public final class StorageType extends Enum {
    private static final StorageType[] $VALUES;
    public static final StorageType EXTERNAL;
    public static final StorageType INTERNAL;

    private static final StorageType[] $values() {
        return 2;
    }

    static <clinit>() {
        new StorageType("EXTERNAL", 0);
        EXTERNAL = new StorageType(..);
        new StorageType("INTERNAL", 1);
        INTERNAL = new StorageType(..);
        StorageType.$values();
        $VALUES = StorageType.$values(..);
        return;
    }

    private StorageType(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static StorageType valueOf(String p0) {
        Enum.valueOf(StorageType.class, p0);
        return Enum.valueOf(..);
    }

    public static StorageType[] values() {
        StorageType.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.TokenCounters
// ============================================================
package com.unity3d.ads.core.data.model;

public final class TokenCounters {
    private int seq;
    private int starts;
    private int wins;

    public TokenCounters(int p0, int p1, int p2) {
        new Object();
        seq = p0;
        wins = p1;
        starts = p2;
        return;
    }

    public static TokenCounters copy$default(TokenCounters p0, int p1, int p2, int p3, int p4, Object p5) {
        if (if-eqz(p5)) goto L_6;
      L_6:
        if (if-eqz(p5)) goto L_c;
      L_c:
        if (if-eqz(p4)) goto L_12;
      L_12:
        p0.copy(seq, wins, starts);
        return TokenCounters.copy(..);
    }

    public final int component1() {
        return seq;
    }

    public final int component2() {
        return wins;
    }

    public final int component3() {
        return starts;
    }

    public final TokenCounters copy(int p0, int p1, int p2) {
        new TokenCounters(p0, p1, p2);
        return new TokenCounters(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        if (if-eq(seq, seq)) goto L_13;
        return 0;
      L_13:
        if (if-eq(wins, wins)) goto L_1a;
        return 0;
      L_1a:
        if (if-eq(starts, starts)) goto L_21;
        return 0;
      L_21:
        return 1;
    }

    public final int getSeq() {
        return seq;
    }

    public final int getStarts() {
        return starts;
    }

    public final int getWins() {
        return wins;
    }

    public int hashCode() {
        return seq;
    }

    public final void setSeq(int p0) {
        seq = p0;
        return;
    }

    public final void setStarts(int p0) {
        starts = p0;
        return;
    }

    public final void setWins(int p0) {
        wins = p0;
        return;
    }

    public String toString() {
        new StringBuilder("TokenCounters(seq=");
        new StringBuilder(..).append(seq);
        new StringBuilder(..).append(", wins=");
        new StringBuilder(..).append(wins);
        new StringBuilder(..).append(", starts=");
        new StringBuilder(..).append(starts);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.UnityAdsShowResult
// ============================================================
package com.unity3d.ads.core.data.model;

public final class UnityAdsShowResult extends Enum {
    private static final UnityAdsShowResult[] $VALUES;
    public static final UnityAdsShowResult ALREADY_SHOWING;
    public static final UnityAdsShowResult FAILURE;
    public static final UnityAdsShowResult INTERNAL_ERROR;
    public static final UnityAdsShowResult INVALID_ARGUMENT;
    public static final UnityAdsShowResult NOT_INITIALIZED;
    public static final UnityAdsShowResult NOT_READY;
    public static final UnityAdsShowResult NO_CONNECTION;
    public static final UnityAdsShowResult SUCCESS;
    public static final UnityAdsShowResult TIMEOUT;
    public static final UnityAdsShowResult VIDEO_PLAYER_ERROR;

    private static final UnityAdsShowResult[] $values() {
        return 10;
    }

    static <clinit>() {
        new UnityAdsShowResult("NOT_INITIALIZED", 0);
        NOT_INITIALIZED = new UnityAdsShowResult(..);
        new UnityAdsShowResult("NOT_READY", 1);
        NOT_READY = new UnityAdsShowResult(..);
        new UnityAdsShowResult("VIDEO_PLAYER_ERROR", 2);
        VIDEO_PLAYER_ERROR = new UnityAdsShowResult(..);
        new UnityAdsShowResult("INVALID_ARGUMENT", 3);
        INVALID_ARGUMENT = new UnityAdsShowResult(..);
        new UnityAdsShowResult("NO_CONNECTION", 4);
        NO_CONNECTION = new UnityAdsShowResult(..);
        new UnityAdsShowResult("ALREADY_SHOWING", 5);
        ALREADY_SHOWING = new UnityAdsShowResult(..);
        new UnityAdsShowResult("INTERNAL_ERROR", 6);
        INTERNAL_ERROR = new UnityAdsShowResult(..);
        new UnityAdsShowResult("TIMEOUT", 7);
        TIMEOUT = new UnityAdsShowResult(..);
        new UnityAdsShowResult("SUCCESS", 8);
        SUCCESS = new UnityAdsShowResult(..);
        new UnityAdsShowResult("FAILURE", 9);
        FAILURE = new UnityAdsShowResult(..);
        UnityAdsShowResult.$values();
        $VALUES = UnityAdsShowResult.$values(..);
        return;
    }

    private UnityAdsShowResult(String p0, int p1) {
        new Enum(p0, p1);
        return;
    }

    public static UnityAdsShowResult valueOf(String p0) {
        Enum.valueOf(UnityAdsShowResult.class, p0);
        return Enum.valueOf(..);
    }

    public static UnityAdsShowResult[] values() {
        UnityAdsShowResult.$VALUES.clone();
        return Object[].clone(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.UniversalRequestStoreSerializer
// ============================================================
package com.unity3d.ads.core.data.model;

public final class UniversalRequestStoreSerializer {
    private final UniversalRequestStoreOuterClass$UniversalRequestStore defaultValue;

    public UniversalRequestStoreSerializer() {
        new Object();
        UniversalRequestStoreOuterClass$UniversalRequestStore.getDefaultInstance();
        defaultValue = UniversalRequestStoreOuterClass$UniversalRequestStore.getDefaultInstance(..);
        return;
    }

    public UniversalRequestStoreOuterClass$UniversalRequestStore getDefaultValue() {
        return defaultValue;
    }

    public Object getDefaultValue() {
        UniversalRequestStoreSerializer.getDefaultValue();
        return UniversalRequestStoreSerializer.getDefaultValue(..);
    }

    public Object readFrom(InputStream p0, Continuation p1) {
        UniversalRequestStoreOuterClass$UniversalRequestStore.parseFrom(p0);
        return UniversalRequestStoreOuterClass$UniversalRequestStore.parseFrom(..);
        new CorruptionException("Cannot read proto.", UniversalRequestStoreOuterClass$UniversalRequestStore.parseFrom(..));
        throw new CorruptionException(..);
    }

    public Object writeTo(UniversalRequestStoreOuterClass$UniversalRequestStore p0, OutputStream p1, Continuation p2) {
        p0.writeTo(p1);
        return Unit.INSTANCE;
    }

    public Object writeTo(Object p0, OutputStream p1, Continuation p2) {
        UniversalRequestStoreSerializer.writeTo(p0, p1, p2);
        return UniversalRequestStoreSerializer.writeTo(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.WebViewConfiguration
// ============================================================
package com.unity3d.ads.core.data.model;

public final class WebViewConfiguration {
    private final List additionalFiles;
    private final String entryPoint;
    private final int version;

    public WebViewConfiguration(int p0, String p1, List p2) {
        new Object();
        version = p0;
        entryPoint = p1;
        additionalFiles = p2;
        return;
    }

    public static WebViewConfiguration copy$default(WebViewConfiguration p0, int p1, String p2, List p3, int p4, Object p5) {
        if (if-eqz(p5)) goto L_6;
      L_6:
        if (if-eqz(p5)) goto L_c;
      L_c:
        if (if-eqz(p4)) goto L_12;
      L_12:
        p0.copy(version, entryPoint, additionalFiles);
        return WebViewConfiguration.copy(..);
    }

    public final int component1() {
        return version;
    }

    public final String component2() {
        return entryPoint;
    }

    public final List component3() {
        return additionalFiles;
    }

    public final WebViewConfiguration copy(int p0, String p1, List p2) {
        new WebViewConfiguration(p0, p1, p2);
        return new WebViewConfiguration(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        if (if-eq(version, version)) goto L_13;
        return 0;
      L_13:
        Intrinsics.areEqual(entryPoint, entryPoint);
        if (if-nez(Intrinsics.areEqual(..))) goto L_1e;
        return 0;
      L_1e:
        Intrinsics.areEqual(additionalFiles, additionalFiles);
        if (if-nez(Intrinsics.areEqual(..))) goto L_29;
        return 0;
      L_29:
        return 1;
    }

    public final List getAdditionalFiles() {
        return additionalFiles;
    }

    public final String getEntryPoint() {
        return entryPoint;
    }

    public final int getVersion() {
        return version;
    }

    public int hashCode() {
        entryPoint.hashCode();
        additionalFiles.hashCode();
        return version;
    }

    public String toString() {
        new StringBuilder("WebViewConfiguration(version=");
        new StringBuilder(..).append(version);
        new StringBuilder(..).append(", entryPoint=");
        new StringBuilder(..).append(entryPoint);
        new StringBuilder(..).append(", additionalFiles=");
        new StringBuilder(..).append(additionalFiles);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.WebViewConfigurationStoreSerializer
// ============================================================
package com.unity3d.ads.core.data.model;

public final class WebViewConfigurationStoreSerializer {
    private final WebviewConfigurationStore$WebViewConfigurationStore defaultValue;

    public WebViewConfigurationStoreSerializer() {
        new Object();
        WebviewConfigurationStore$WebViewConfigurationStore.getDefaultInstance();
        defaultValue = WebviewConfigurationStore$WebViewConfigurationStore.getDefaultInstance(..);
        return;
    }

    public WebviewConfigurationStore$WebViewConfigurationStore getDefaultValue() {
        return defaultValue;
    }

    public Object getDefaultValue() {
        WebViewConfigurationStoreSerializer.getDefaultValue();
        return WebViewConfigurationStoreSerializer.getDefaultValue(..);
    }

    public Object readFrom(InputStream p0, Continuation p1) {
        WebviewConfigurationStore$WebViewConfigurationStore.parseFrom(p0);
        return WebviewConfigurationStore$WebViewConfigurationStore.parseFrom(..);
        new CorruptionException("Cannot read proto.", WebviewConfigurationStore$WebViewConfigurationStore.parseFrom(..));
        throw new CorruptionException(..);
    }

    public Object writeTo(WebviewConfigurationStore$WebViewConfigurationStore p0, OutputStream p1, Continuation p2) {
        p0.writeTo(p1);
        return Unit.INSTANCE;
    }

    public Object writeTo(Object p0, OutputStream p1, Continuation p2) {
        WebViewConfigurationStoreSerializer.writeTo(p0, p1, p2);
        return WebViewConfigurationStoreSerializer.writeTo(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.CacheResult$Failure
// ============================================================
package com.unity3d.ads.core.data.model;

public final class CacheResult$Failure extends CacheResult {
    private final CacheError error;
    private final CacheSource source;

    public CacheResult$Failure(CacheError p0, CacheSource p1) {
        new CacheResult(0);
        error = p0;
        source = p1;
        return;
    }

    public CacheResult$Failure(CacheError p0, CacheSource p1, int p2, DefaultConstructorMarker p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        new CacheResult$Failure(p0, CacheSource.LOCAL);
        return;
    }

    public static CacheResult$Failure copy$default(CacheResult$Failure p0, CacheError p1, CacheSource p2, int p3, Object p4) {
        if (if-eqz(p4)) goto L_6;
      L_6:
        if (if-eqz(p3)) goto L_c;
      L_c:
        p0.copy(error, source);
        return CacheResult$Failure.copy(..);
    }

    public final CacheError component1() {
        return error;
    }

    public final CacheSource component2() {
        return source;
    }

    public final CacheResult$Failure copy(CacheError p0, CacheSource p1) {
        new CacheResult$Failure(p0, p1);
        return new CacheResult$Failure(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        if (if-eq(error, error)) goto L_13;
        return 0;
      L_13:
        if (if-eq(source, source)) goto L_1a;
        return 0;
      L_1a:
        return 1;
    }

    public final CacheError getError() {
        return error;
    }

    public final CacheSource getSource() {
        return source;
    }

    public int hashCode() {
        error.hashCode();
        source.hashCode();
        return CacheError.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Failure(error=");
        new StringBuilder(..).append(error);
        new StringBuilder(..).append(", source=");
        new StringBuilder(..).append(source);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.CacheResult$Success
// ============================================================
package com.unity3d.ads.core.data.model;

public final class CacheResult$Success extends CacheResult {
    private final CachedFile cachedFile;
    private final CacheSource source;

    public CacheResult$Success(CachedFile p0, CacheSource p1) {
        new CacheResult(0);
        cachedFile = p0;
        source = p1;
        return;
    }

    public static CacheResult$Success copy$default(CacheResult$Success p0, CachedFile p1, CacheSource p2, int p3, Object p4) {
        if (if-eqz(p4)) goto L_6;
      L_6:
        if (if-eqz(p3)) goto L_c;
      L_c:
        p0.copy(cachedFile, source);
        return CacheResult$Success.copy(..);
    }

    public final CachedFile component1() {
        return cachedFile;
    }

    public final CacheSource component2() {
        return source;
    }

    public final CacheResult$Success copy(CachedFile p0, CacheSource p1) {
        new CacheResult$Success(p0, p1);
        return new CacheResult$Success(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(cachedFile, cachedFile);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        if (if-eq(source, source)) goto L_1e;
        return 0;
      L_1e:
        return 1;
    }

    public final CachedFile getCachedFile() {
        return cachedFile;
    }

    public final CacheSource getSource() {
        return source;
    }

    public int hashCode() {
        cachedFile.hashCode();
        source.hashCode();
        return CachedFile.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Success(cachedFile=");
        new StringBuilder(..).append(cachedFile);
        new StringBuilder(..).append(", source=");
        new StringBuilder(..).append(source);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.Listeners$DefaultImpls
// ============================================================
package com.unity3d.ads.core.data.model;

public final class Listeners$DefaultImpls {
    public static void onClick(Listeners p0, String p1) {
        return;
    }

    public static void onComplete(Listeners p0, String p1, UnityAds$UnityAdsShowCompletionState p2) {
        return;
    }

    public static void onError(Listeners p0, String p1, UnityAds$UnityAdsShowError p2, String p3) {
        return;
    }

    public static void onLeftApplication(Listeners p0, String p1) {
        return;
    }

    public static void onStart(Listeners p0, String p1) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.LoadResult$Companion
// ============================================================
package com.unity3d.ads.core.data.model;

public final class LoadResult$Companion {
    private LoadResult$Companion() {
        new Object();
        return;
    }

    public LoadResult$Companion(DefaultConstructorMarker p0) {
        new LoadResult$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.LoadResult$Failure
// ============================================================
package com.unity3d.ads.core.data.model;

public final class LoadResult$Failure extends LoadResult {
    private final UnityAds$UnityAdsLoadError error;
    private final String message;
    private final String reason;
    private final String reasonDebug;
    private final Throwable throwable;

    public LoadResult$Failure(UnityAds$UnityAdsLoadError p0, String p1, Throwable p2, String p3, String p4) {
        new LoadResult(0);
        error = p0;
        message = p1;
        throwable = p2;
        reason = p3;
        reasonDebug = p4;
        return;
    }

    public LoadResult$Failure(UnityAds$UnityAdsLoadError p0, String p1, Throwable p2, String p3, String p4, int p5, DefaultConstructorMarker p6) {
        if (if-eqz(p6)) goto L_7;
      L_7:
      L_8:
        if (if-eqz(p1)) goto L_e;
      L_e:
      L_f:
        if (if-eqz(p1)) goto L_15;
      L_15:
      L_16:
        new LoadResult$Failure(p0, p1, p2, p3, p4);
        return;
    }

    public static LoadResult$Failure copy$default(LoadResult$Failure p0, UnityAds$UnityAdsLoadError p1, String p2, Throwable p3, String p4, String p5, int p6, Object p7) {
        if (if-eqz(p7)) goto L_6;
      L_6:
        if (if-eqz(p7)) goto L_c;
      L_c:
        if (if-eqz(message)) goto L_13;
      L_13:
        if (if-eqz(message)) goto L_1a;
      L_1a:
        if (if-eqz(message)) goto L_21;
      L_21:
        p0.copy(error, message, throwable, reason, reasonDebug);
        return LoadResult$Failure.copy(..);
    }

    public final UnityAds$UnityAdsLoadError component1() {
        return error;
    }

    public final String component2() {
        return message;
    }

    public final Throwable component3() {
        return throwable;
    }

    public final String component4() {
        return reason;
    }

    public final String component5() {
        return reasonDebug;
    }

    public final LoadResult$Failure copy(UnityAds$UnityAdsLoadError p0, String p1, Throwable p2, String p3, String p4) {
        new LoadResult$Failure(p0, p1, p2, p3, p4);
        return new LoadResult$Failure;
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        if (if-eq(error, error)) goto L_13;
        return 0;
      L_13:
        Intrinsics.areEqual(message, message);
        if (if-nez(Intrinsics.areEqual(..))) goto L_1e;
        return 0;
      L_1e:
        Intrinsics.areEqual(throwable, throwable);
        if (if-nez(Intrinsics.areEqual(..))) goto L_29;
        return 0;
      L_29:
        Intrinsics.areEqual(reason, reason);
        if (if-nez(Intrinsics.areEqual(..))) goto L_34;
        return 0;
      L_34:
        Intrinsics.areEqual(reasonDebug, reasonDebug);
        if (if-nez(Intrinsics.areEqual(..))) goto L_3f;
        return 0;
      L_3f:
        return 1;
    }

    public final UnityAds$UnityAdsLoadError getError() {
        return error;
    }

    public final String getMessage() {
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
        error.hashCode();
        if (if-nez(message)) goto L_f;
      L_f:
        0.hashCode();
      L_13:
        if (if-nez(throwable)) goto L_1c;
      L_1c:
        0.hashCode();
      L_20:
        reason.hashCode();
        if (if-nez(reasonDebug)) goto L_31;
      L_31:
        reasonDebug.hashCode();
      L_35:
        return UnityAds$UnityAdsLoadError.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Failure(error=");
        new StringBuilder(..).append(error);
        new StringBuilder(..).append(", message=");
        new StringBuilder(..).append(message);
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
// CLASS: com.unity3d.ads.core.data.model.LoadResult$Success
// ============================================================
package com.unity3d.ads.core.data.model;

public final class LoadResult$Success extends LoadResult {
    private final AdObject adObject;

    public LoadResult$Success(AdObject p0) {
        new LoadResult(0);
        adObject = p0;
        return;
    }

    public static LoadResult$Success copy$default(LoadResult$Success p0, AdObject p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        p0.copy(adObject);
        return LoadResult$Success.copy(..);
    }

    public final AdObject component1() {
        return adObject;
    }

    public final LoadResult$Success copy(AdObject p0) {
        new LoadResult$Success(p0);
        return new LoadResult$Success(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(adObject, adObject);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        return 1;
    }

    public final AdObject getAdObject() {
        return adObject;
    }

    public int hashCode() {
        adObject.hashCode();
        return AdObject.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Success(adObject=");
        new StringBuilder(..).append(adObject);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.OMResult$Failure
// ============================================================
package com.unity3d.ads.core.data.model;

public final class OMResult$Failure extends OMResult {
    private final String reason;
    private final String reasonDebug;

    public OMResult$Failure(String p0, String p1) {
        new OMResult(0);
        reason = p0;
        reasonDebug = p1;
        return;
    }

    public OMResult$Failure(String p0, String p1, int p2, DefaultConstructorMarker p3) {
        if (if-eqz(p2)) goto L_5;
      L_5:
        new OMResult$Failure(p0, 0);
        return;
    }

    public static OMResult$Failure copy$default(OMResult$Failure p0, String p1, String p2, int p3, Object p4) {
        if (if-eqz(p4)) goto L_6;
      L_6:
        if (if-eqz(p3)) goto L_c;
      L_c:
        p0.copy(reason, reasonDebug);
        return OMResult$Failure.copy(..);
    }

    public final String component1() {
        return reason;
    }

    public final String component2() {
        return reasonDebug;
    }

    public final OMResult$Failure copy(String p0, String p1) {
        new OMResult$Failure(p0, p1);
        return new OMResult$Failure(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(reason, reason);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        Intrinsics.areEqual(reasonDebug, reasonDebug);
        if (if-nez(Intrinsics.areEqual(..))) goto L_22;
        return 0;
      L_22:
        return 1;
    }

    public final String getReason() {
        return reason;
    }

    public final String getReasonDebug() {
        return reasonDebug;
    }

    public int hashCode() {
        reason.hashCode();
        if (if-nez(reasonDebug)) goto L_e;
      L_e:
        0.hashCode();
      L_12:
        return String.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Failure(reason=");
        new StringBuilder(..).append(reason);
        new StringBuilder(..).append(", reasonDebug=");
        new StringBuilder(..).append(reasonDebug);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.OMResult$Success
// ============================================================
package com.unity3d.ads.core.data.model;

public final class OMResult$Success extends OMResult {
    public static final OMResult$Success INSTANCE;

    static <clinit>() {
        new OMResult$Success();
        INSTANCE = new OMResult$Success(..);
        return;
    }

    private OMResult$Success() {
        new OMResult(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.SessionChange$PrivacyFsmChange
// ============================================================
package com.unity3d.ads.core.data.model;

public final class SessionChange$PrivacyFsmChange extends SessionChange {
    private final ByteString value;

    public SessionChange$PrivacyFsmChange(ByteString p0) {
        new SessionChange(0);
        value = p0;
        return;
    }

    public static SessionChange$PrivacyFsmChange copy$default(SessionChange$PrivacyFsmChange p0, ByteString p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        p0.copy(value);
        return SessionChange$PrivacyFsmChange.copy(..);
    }

    public final ByteString component1() {
        return value;
    }

    public final SessionChange$PrivacyFsmChange copy(ByteString p0) {
        new SessionChange$PrivacyFsmChange(p0);
        return new SessionChange$PrivacyFsmChange(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(value, value);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        return 1;
    }

    public final ByteString getValue() {
        return value;
    }

    public int hashCode() {
        ByteString.hashCode();
        return ByteString.hashCode(..);
    }

    public String toString() {
        new StringBuilder("PrivacyFsmChange(value=");
        new StringBuilder(..).append(value);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.SessionChange$UserConsentChange
// ============================================================
package com.unity3d.ads.core.data.model;

public final class SessionChange$UserConsentChange extends SessionChange {
    private final ByteString value;

    public SessionChange$UserConsentChange(ByteString p0) {
        new SessionChange(0);
        value = p0;
        return;
    }

    public static SessionChange$UserConsentChange copy$default(SessionChange$UserConsentChange p0, ByteString p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        p0.copy(value);
        return SessionChange$UserConsentChange.copy(..);
    }

    public final ByteString component1() {
        return value;
    }

    public final SessionChange$UserConsentChange copy(ByteString p0) {
        new SessionChange$UserConsentChange(p0);
        return new SessionChange$UserConsentChange(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(value, value);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        return 1;
    }

    public final ByteString getValue() {
        return value;
    }

    public int hashCode() {
        ByteString.hashCode();
        return ByteString.hashCode(..);
    }

    public String toString() {
        new StringBuilder("UserConsentChange(value=");
        new StringBuilder(..).append(value);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.ShowEvent$CancelTimeout
// ============================================================
package com.unity3d.ads.core.data.model;

public final class ShowEvent$CancelTimeout extends ShowEvent {
    public static final ShowEvent$CancelTimeout INSTANCE;

    static <clinit>() {
        new ShowEvent$CancelTimeout();
        INSTANCE = new ShowEvent$CancelTimeout(..);
        return;
    }

    private ShowEvent$CancelTimeout() {
        new ShowEvent(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.ShowEvent$Clicked
// ============================================================
package com.unity3d.ads.core.data.model;

public final class ShowEvent$Clicked extends ShowEvent {
    public static final ShowEvent$Clicked INSTANCE;

    static <clinit>() {
        new ShowEvent$Clicked();
        INSTANCE = new ShowEvent$Clicked(..);
        return;
    }

    private ShowEvent$Clicked() {
        new ShowEvent(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.ShowEvent$Completed
// ============================================================
package com.unity3d.ads.core.data.model;

public final class ShowEvent$Completed extends ShowEvent {
    private final ShowStatus status;

    public ShowEvent$Completed(ShowStatus p0) {
        new ShowEvent(0);
        status = p0;
        return;
    }

    public static ShowEvent$Completed copy$default(ShowEvent$Completed p0, ShowStatus p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        p0.copy(status);
        return ShowEvent$Completed.copy(..);
    }

    public final ShowStatus component1() {
        return status;
    }

    public final ShowEvent$Completed copy(ShowStatus p0) {
        new ShowEvent$Completed(p0);
        return new ShowEvent$Completed(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        if (if-eq(status, status)) goto L_13;
        return 0;
      L_13:
        return 1;
    }

    public final ShowStatus getStatus() {
        return status;
    }

    public int hashCode() {
        status.hashCode();
        return ShowStatus.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Completed(status=");
        new StringBuilder(..).append(status);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.ShowEvent$Error
// ============================================================
package com.unity3d.ads.core.data.model;

public final class ShowEvent$Error extends ShowEvent {
    private final int errorCode;
    private final String message;
    private final String reason;

    public ShowEvent$Error(String p0, int p1, String p2) {
        new ShowEvent(0);
        message = p0;
        errorCode = p1;
        reason = p2;
        return;
    }

    public static ShowEvent$Error copy$default(ShowEvent$Error p0, String p1, int p2, String p3, int p4, Object p5) {
        if (if-eqz(p5)) goto L_6;
      L_6:
        if (if-eqz(p5)) goto L_c;
      L_c:
        if (if-eqz(p4)) goto L_12;
      L_12:
        p0.copy(message, errorCode, reason);
        return ShowEvent$Error.copy(..);
    }

    public final String component1() {
        return message;
    }

    public final int component2() {
        return errorCode;
    }

    public final String component3() {
        return reason;
    }

    public final ShowEvent$Error copy(String p0, int p1, String p2) {
        new ShowEvent$Error(p0, p1, p2);
        return new ShowEvent$Error(..);
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
        Intrinsics.areEqual(reason, reason);
        if (if-nez(Intrinsics.areEqual(..))) goto L_29;
        return 0;
      L_29:
        return 1;
    }

    public final int getErrorCode() {
        return errorCode;
    }

    public final String getMessage() {
        return message;
    }

    public final String getReason() {
        return reason;
    }

    public int hashCode() {
        message.hashCode();
        reason.hashCode();
        return String.hashCode(..);
    }

    public String toString() {
        new StringBuilder("Error(message=");
        new StringBuilder(..).append(message);
        new StringBuilder(..).append(", errorCode=");
        new StringBuilder(..).append(errorCode);
        new StringBuilder(..).append(", reason=");
        new StringBuilder(..).append(reason);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.ShowEvent$LeftApplication
// ============================================================
package com.unity3d.ads.core.data.model;

public final class ShowEvent$LeftApplication extends ShowEvent {
    public static final ShowEvent$LeftApplication INSTANCE;

    static <clinit>() {
        new ShowEvent$LeftApplication();
        INSTANCE = new ShowEvent$LeftApplication(..);
        return;
    }

    private ShowEvent$LeftApplication() {
        new ShowEvent(0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.model.ShowEvent$Started
// ============================================================
package com.unity3d.ads.core.data.model;

public final class ShowEvent$Started extends ShowEvent {
    public static final ShowEvent$Started INSTANCE;

    static <clinit>() {
        new ShowEvent$Started();
        INSTANCE = new ShowEvent$Started(..);
        return;
    }

    private ShowEvent$Started() {
        new ShowEvent(0);
        return;
    }

}

