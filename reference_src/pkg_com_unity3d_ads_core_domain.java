// Package bundle: com.unity3d.ads.core.domain (226 classes)

// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidBuildHeaderBiddingToken
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidBuildHeaderBiddingToken {
    private final CampaignRepository campaignRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetByteStringId generateId;
    private final GetClientInfo getClientInfo;
    private final GetInitializationData getInitializationData;
    private final GetLimitedSessionToken getLimitedSessionToken;
    private final GetSharedDataTimestamps getTimestamps;
    private final SessionRepository sessionRepository;
    private final TcfRepository tcfRepository;

    public AndroidBuildHeaderBiddingToken(GetByteStringId p0, GetClientInfo p1, GetSharedDataTimestamps p2, GetLimitedSessionToken p3, GetInitializationData p4, DeviceInfoRepository p5, SessionRepository p6, CampaignRepository p7, TcfRepository p8) {
        new Object();
        generateId = p0;
        getClientInfo = p1;
        getTimestamps = p2;
        getLimitedSessionToken = p3;
        getInitializationData = p4;
        deviceInfoRepository = p5;
        sessionRepository = p6;
        campaignRepository = p7;
        tcfRepository = p8;
        return;
    }

    public Object invoke(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidBuildHeaderBiddingToken$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_7d;
        if (if-eq(label, 1)) goto L_64;
        if (if-eq(label, 2)) goto L_4b;
        if (if-ne(label, 3)) goto L_43;
        ResultKt.throwOnFailure(result);
      L_43:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_4b:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_64:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_7d:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        sessionRepository.getTokenCounters();
        sessionRepository.getSessionToken();
        sessionRepository.incrementTokenSequenceNumber();
        HeaderBiddingTokenOuterClass$HeaderBiddingToken.newBuilder();
        HeaderBiddingTokenKt$Dsl.Companion._create(HeaderBiddingTokenOuterClass$HeaderBiddingToken.newBuilder(..));
        generateId.invoke();
        HeaderBiddingTokenKt$Dsl.setTokenId(GetByteStringId.invoke(..));
        sessionRepository.getHeaderBiddingTokenCounter();
        HeaderBiddingTokenKt$Dsl.setTokenNumber(SessionRepository.getHeaderBiddingTokenCounter(..));
        getClientInfo.invoke();
        HeaderBiddingTokenKt$Dsl.setClientInfo(GetClientInfo.invoke(..));
        getTimestamps.invoke();
        HeaderBiddingTokenKt$Dsl.setTimestamps(GetSharedDataTimestamps.invoke(..));
        sessionRepository.getSessionCounters();
        HeaderBiddingTokenKt$Dsl.setSessionCounters(SessionRepository.getSessionCounters(..));
        deviceInfoRepository.getDynamicDeviceInfo();
        HeaderBiddingTokenKt$Dsl.setDynamicDeviceInfo(DeviceInfoRepository.getDynamicDeviceInfo(..));
        deviceInfoRepository.getPiiData();
        DeviceInfoRepository.getPiiData(..).getAdvertisingId();
        ByteString.isEmpty();
        if (if-eqz(ByteString.isEmpty(..))) goto L_ee;
        DeviceInfoRepository.getPiiData(..).getOpenAdvertisingTrackingId();
        ByteString.isEmpty();
        if (if-nez(ByteString.isEmpty(..))) goto L_f1;
      L_ee:
        HeaderBiddingTokenKt$Dsl.setPii(DeviceInfoRepository.getPiiData(..));
      L_f1:
        campaignRepository.getCampaignState();
        HeaderBiddingTokenKt$Dsl.setCampaignState(CampaignRepository.getCampaignState(..));
        tcfRepository.getTcfString();
        if (if-eqz(TcfRepository.getTcfString(..))) goto L_109;
        ProtobufExtensionsKt.toISO8859ByteString(TcfRepository.getTcfString(..));
        HeaderBiddingTokenKt$Dsl.setTcf(ProtobufExtensionsKt.toISO8859ByteString(..));
      L_109:
        ByteString.isEmpty();
        if (if-eqz(ByteString.isEmpty(..))) goto L_184;
        sessionRepository.getGameId();
        if (if-eqz(SessionRepository.getGameId(..))) goto L_126;
        SessionRepository.getGameId(..).length();
        if (if-lez(CharSequence.length(..))) goto L_122;
      L_122:
      L_123:
        if (if-ne(0, L$2)) goto L_126;
      L_126:
        if (if-eqz(L$2)) goto L_146;
        L$0 = this;
        L$1 = SessionRepository.getTokenCounters(..);
        L$2 = HeaderBiddingTokenKt$Dsl$Companion._create(..);
        L$3 = HeaderBiddingTokenKt$Dsl$Companion._create(..);
        L$4 = HeaderBiddingTokenKt$Dsl$Companion._create(..);
        label = L$2;
        getInitializationData.invoke("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(GetInitializationData.invoke(..), L$3)) goto L_13d;
        return L$3;
      L_13d:
      L_140:
        HeaderBiddingTokenKt$Dsl.setInitializationData(GetInitializationData.invoke(..));
      L_146:
        L$0 = this;
        L$1 = SessionRepository.getTokenCounters(..);
        L$2 = HeaderBiddingTokenKt$Dsl$Companion._create(..);
        L$3 = HeaderBiddingTokenKt$Dsl$Companion._create(..);
        L$4 = HeaderBiddingTokenKt$Dsl$Companion._create(..);
        label = HeaderBiddingTokenKt$Dsl$Companion._create(..);
        getLimitedSessionToken.invoke("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(GetLimitedSessionToken.invoke(..), L$3)) goto L_15b;
        return L$3;
      L_15b:
      L_15e:
        HeaderBiddingTokenKt$Dsl.setLimitedSessionToken(GetLimitedSessionToken.invoke(..));
      L_163:
        L$0 = SessionRepository.getTokenCounters(..);
        L$1 = HeaderBiddingTokenKt$Dsl$Companion._create(..);
        L$2 = HeaderBiddingTokenKt$Dsl$Companion._create(..);
        L$3 = HeaderBiddingTokenKt$Dsl$Companion._create(..);
        L$4 = 0;
        label = L$1;
        deviceInfoRepository.staticDeviceInfo("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(DeviceInfoRepository.staticDeviceInfo(..), L$3)) goto L_179;
        return L$3;
      L_179:
      L_17d:
        HeaderBiddingTokenKt$Dsl.setStaticDeviceInfo(DeviceInfoRepository.staticDeviceInfo(..));
      L_184:
        sessionRepository.getSessionToken();
        HeaderBiddingTokenKt$Dsl.setSessionToken(SessionRepository.getSessionToken(..));
        deviceInfoRepository.cachedStaticDeviceInfo();
        HeaderBiddingTokenKt$Dsl.setStaticDeviceInfo(DeviceInfoRepository.cachedStaticDeviceInfo(..));
      L_197:
        HeaderBiddingTokenOuterClass$TokenCounters.newBuilder();
        TokenCountersKt$Dsl.Companion._create(HeaderBiddingTokenOuterClass$TokenCounters.newBuilder(..));
        TokenCounters.getSeq();
        TokenCountersKt$Dsl.setSeq(TokenCounters.getSeq(..));
        TokenCounters.getWins();
        TokenCountersKt$Dsl.setWins(TokenCounters.getWins(..));
        TokenCounters.getStarts();
        TokenCountersKt$Dsl.setStarts(TokenCounters.getStarts(..));
        TokenCountersKt$Dsl._build();
        HeaderBiddingTokenKt$Dsl.setTokenCounters(TokenCountersKt$Dsl._build(..));
        HeaderBiddingTokenKt$Dsl._build();
        return HeaderBiddingTokenKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidExecuteAdViewerRequest
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidExecuteAdViewerRequest {
    private final HttpClient httpClient;
    private final CoroutineDispatcher ioDispatcher;

    public AndroidExecuteAdViewerRequest(CoroutineDispatcher p0, HttpClient p1) {
        new Object();
        ioDispatcher = p0;
        httpClient = p1;
        return;
    }

    public static final HttpRequest access$createRequest(AndroidExecuteAdViewerRequest p0, RequestType p1, Object[] p2) {
        p0.createRequest(p1, p2);
        return AndroidExecuteAdViewerRequest.createRequest(..);
    }

    public static final HttpClient access$getHttpClient$p(AndroidExecuteAdViewerRequest p0) {
        return httpClient;
    }

    private final HttpRequest createRequest(RequestType p0, Object[] p1) {
        ArraysKt.getOrNull(p1, 1);
        if (if-eqz(ArraysKt.getOrNull(..))) goto L_18;
        ArraysKt.getOrNull(..).length();
        if (if-nez(CharSequence.length(..))) goto L_16;
      L_16:
      L_18:
      L_19:
        if (if-eqz(1)) goto L_e0;
        p0.ordinal();
        if (if-eq(AndroidExecuteAdViewerRequest$WhenMappings.$EnumSwitchMapping$0, 1)) goto L_8c;
        if (if-eq(AndroidExecuteAdViewerRequest$WhenMappings.$EnumSwitchMapping$0, 2)) goto L_8c;
        if (if-ne(AndroidExecuteAdViewerRequest$WhenMappings.$EnumSwitchMapping$0, 3)) goto L_86;
        ArraysKt.getOrNull(p1, 2);
        ArraysKt.getOrNull(p1, 3);
        ArraysKt.getOrNull(p1, 4);
        ArraysKt.getOrNull(p1, 5);
        if (if-eqz(ArraysKt.getOrNull(..))) goto L_50;
        JSONArrayExtensionsKt.getHeadersMap(ArraysKt.getOrNull(..));
        if (if-nez(JSONArrayExtensionsKt.getHeadersMap(..))) goto L_54;
      L_50:
        MapsKt.emptyMap();
      L_54:
        if (if-eqz(ArraysKt.getOrNull(..))) goto L_5d;
        ArraysKt.getOrNull(..).intValue();
      L_5d:
      L_5e:
        if (if-eqz(ArraysKt.getOrNull(..))) goto L_66;
        ArraysKt.getOrNull(..).intValue();
      L_66:
      L_67:
        new HttpRequest(ArraysKt.getOrNull(..), 0, p0, ArraysKt.getOrNull(..), MapsKt.emptyMap(..), 0, 0, 0, 0, 30000, 30000, 0, 0, 0, 0);
      L_86:
        new NoWhenBranchMatchedException();
        throw new NoWhenBranchMatchedException(..);
      L_8c:
        ArraysKt.getOrNull(new NoWhenBranchMatchedException(..), p0);
        ArraysKt.getOrNull(new NoWhenBranchMatchedException(..), 0);
        ArraysKt.getOrNull(new NoWhenBranchMatchedException(..), new HttpRequest(..));
        if (if-eqz(ArraysKt.getOrNull(..))) goto L_aa;
        JSONArrayExtensionsKt.getHeadersMap(ArraysKt.getOrNull(..));
        if (if-nez(JSONArrayExtensionsKt.getHeadersMap(..))) goto L_ae;
      L_aa:
        MapsKt.emptyMap();
      L_ae:
        if (if-eqz(ArraysKt.getOrNull(..))) goto L_ba;
        ArraysKt.getOrNull(..).intValue();
      L_ba:
      L_bb:
        if (if-eqz(ArraysKt.getOrNull(..))) goto L_c3;
        ArraysKt.getOrNull(..).intValue();
      L_c3:
      L_c4:
        new HttpRequest(ArraysKt.getOrNull(..), 0, p0, 0, MapsKt.emptyMap(..), 0, 0, 0, 0, ArraysKt.getOrNull(..), ArraysKt.getOrNull(..), 0, 0, 0, 0);
      L_df:
        return new HttpRequest;
      L_e0:
        "Failed requirement.".toString();
        new IllegalArgumentException(Object.toString(..));
        throw new IllegalArgumentException(..);
    }

    public Object invoke(RequestType p0, Object[] p1, Continuation p2) {
        new AndroidExecuteAdViewerRequest$invoke$2(this, p0, p1, 0);
        BuildersKt.withContext(ioDispatcher, new AndroidExecuteAdViewerRequest$invoke$2(..), p2);
        return BuildersKt.withContext(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGenerateByteStringId
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGenerateByteStringId {
    public AndroidGenerateByteStringId() {
        new Object();
        return;
    }

    public ByteString invoke() {
        UUID.randomUUID();
        ProtobufExtensionsKt.toByteString(UUID.randomUUID(..));
        return ProtobufExtensionsKt.toByteString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetAdDataRefreshRequest
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetAdDataRefreshRequest {
    private final CampaignRepository campaignRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
    private final SessionRepository sessionRepository;

    public AndroidGetAdDataRefreshRequest(GetUniversalRequestForPayLoad p0, SessionRepository p1, DeviceInfoRepository p2, CampaignRepository p3) {
        new Object();
        getUniversalRequestForPayLoad = p0;
        sessionRepository = p1;
        deviceInfoRepository = p2;
        campaignRepository = p3;
        return;
    }

    public Object invoke(ByteString p0, ByteString p1, Continuation p2) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidGetAdDataRefreshRequest$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_54;
        if (if-eq(label, 1)) goto L_38;
        if (if-ne(label, 2)) goto L_30;
        ResultKt.throwOnFailure(result);
      L_30:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_38:
        ResultKt.throwOnFailure(result);
      L_54:
        ResultKt.throwOnFailure(result);
        AdDataRefreshRequestOuterClass$AdDataRefreshRequest.newBuilder();
        AdDataRefreshRequestKt$Dsl.Companion._create(AdDataRefreshRequestOuterClass$AdDataRefreshRequest.newBuilder(..));
        sessionRepository.getSessionCounters();
        AdDataRefreshRequestKt$Dsl.setSessionCounters(SessionRepository.getSessionCounters(..));
        L$0 = this;
        L$1 = L$5;
        L$2 = L$4;
        L$3 = AdDataRefreshRequestKt$Dsl$Companion._create(..);
        L$4 = AdDataRefreshRequestKt$Dsl$Companion._create(..);
        L$5 = AdDataRefreshRequestKt$Dsl$Companion._create(..);
        label = L$2;
        deviceInfoRepository.staticDeviceInfo(new AndroidGetAdDataRefreshRequest$invoke$1(..));
        if (if-ne(DeviceInfoRepository.staticDeviceInfo(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_84;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_84:
      L_8b:
        AdDataRefreshRequestKt$Dsl.setStaticDeviceInfo(DeviceInfoRepository.staticDeviceInfo(..));
        deviceInfoRepository.getDynamicDeviceInfo();
        AdDataRefreshRequestKt$Dsl.setDynamicDeviceInfo(DeviceInfoRepository.getDynamicDeviceInfo(..));
        AdDataRefreshRequestKt$Dsl.setImpressionOpportunityId(L$5);
        campaignRepository.getCampaignState();
        AdDataRefreshRequestKt$Dsl.setCampaignState(CampaignRepository.getCampaignState(..));
        L$4.isEmpty();
        if (if-nez(ByteString.isEmpty(..))) goto L_ae;
        AdDataRefreshRequestKt$Dsl.setAdDataRefreshToken(L$4);
      L_ae:
        AdDataRefreshRequestKt$Dsl._build();
        UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder();
        UniversalRequestKt$PayloadKt$Dsl$Companion._create(UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder(..));
        UniversalRequestKt$PayloadKt$Dsl.setAdDataRefreshRequest(AdDataRefreshRequestKt$Dsl._build(..));
        UniversalRequestKt$PayloadKt$Dsl._build();
        L$0 = 0;
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        L$4 = 0;
        L$5 = 0;
        label = 2;
        getUniversalRequestForPayLoad.invoke(UniversalRequestKt$PayloadKt$Dsl._build(..), new AndroidGetAdDataRefreshRequest$invoke$1(..));
        if (if-ne(GetUniversalRequestForPayLoad.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_e0;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_e0:
        return GetUniversalRequestForPayLoad.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetAdPlayerConfigRequest
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetAdPlayerConfigRequest {
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    public AndroidGetAdPlayerConfigRequest(GetUniversalRequestForPayLoad p0) {
        new Object();
        getUniversalRequestForPayLoad = p0;
        return;
    }

    public Object invoke(String p0, ByteString p1, ByteString p2, Continuation p3) {
        AdPlayerConfigRequestOuterClass$AdPlayerConfigRequest.newBuilder();
        AdPlayerConfigRequestKt$Dsl$Companion._create(AdPlayerConfigRequestOuterClass$AdPlayerConfigRequest.newBuilder(..));
        AdPlayerConfigRequestKt$Dsl.setConfigurationToken(p2);
        AdPlayerConfigRequestKt$Dsl.setPlacementId(p0);
        AdPlayerConfigRequestKt$Dsl.setImpressionOpportunityId(p1);
        AdPlayerConfigRequestKt$Dsl._build();
        UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder();
        UniversalRequestKt$PayloadKt$Dsl$Companion._create(UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder(..));
        UniversalRequestKt$PayloadKt$Dsl.setAdPlayerConfigRequest(AdPlayerConfigRequestKt$Dsl._build(..));
        UniversalRequestKt$PayloadKt$Dsl._build();
        getUniversalRequestForPayLoad.invoke(UniversalRequestKt$PayloadKt$Dsl._build(..), p3);
        return GetUniversalRequestForPayLoad.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetAdPlayerContext
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetAdPlayerContext {
    public static final AndroidGetAdPlayerContext$Companion Companion = null;
    public static final String KEY_GAME_ID = "gameId";
    private final DeviceInfoRepository deviceInfoRepository;
    private final SessionRepository sessionRepository;

    static <clinit>() {
        new AndroidGetAdPlayerContext$Companion(0);
        Companion = new AndroidGetAdPlayerContext$Companion(..);
        return;
    }

    public AndroidGetAdPlayerContext(DeviceInfoRepository p0, SessionRepository p1) {
        new Object();
        deviceInfoRepository = p0;
        sessionRepository = p1;
        return;
    }

    public final Object invoke(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidGetAdPlayerContext$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_36;
        if (if-ne(label, 1)) goto L_2e;
        ResultKt.throwOnFailure(result);
      L_2e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_36:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        L$0 = this;
        label = 1;
        deviceInfoRepository.staticDeviceInfo("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(DeviceInfoRepository.staticDeviceInfo(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_46;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_46:
      L_47:
        deviceInfoRepository.getDynamicDeviceInfo();
        sessionRepository.getGameId();
        if (if-nez(SessionRepository.getGameId(..))) goto L_59;
      L_59:
        StaticDeviceInfoOuterClass$StaticDeviceInfo.getBundleId();
        TuplesKt.to("bundleId", StaticDeviceInfoOuterClass$StaticDeviceInfo.getBundleId(..));
        StaticDeviceInfoOuterClass$StaticDeviceInfo.getBundleVersion();
        TuplesKt.to("bundleVersion", StaticDeviceInfoOuterClass$StaticDeviceInfo.getBundleVersion(..));
        TuplesKt.to("webviewHash", "unknown");
        SdkProperties.getVersionCode();
        Boxing.boxInt(SdkProperties.getVersionCode(..));
        TuplesKt.to("sdkVersion", Boxing.boxInt(..));
        SdkProperties.getVersionName();
        TuplesKt.to("sdkVersionName", SdkProperties.getVersionName(..));
        StaticDeviceInfoOuterClass$StaticDeviceInfo.getOsVersion();
        TuplesKt.to("osVersion", StaticDeviceInfoOuterClass$StaticDeviceInfo.getOsVersion(..));
        Locale.getDefault();
        Locale.getDefault(..).toString();
        TuplesKt.to("systemLanguage", Locale.toString(..));
        StaticDeviceInfoOuterClass$StaticDeviceInfo.getDeviceModel();
        TuplesKt.to("deviceModel", StaticDeviceInfoOuterClass$StaticDeviceInfo.getDeviceModel(..));
        DynamicDeviceInfoOuterClass$DynamicDeviceInfo.getLimitedTracking();
        Boxing.boxBoolean(DynamicDeviceInfoOuterClass$DynamicDeviceInfo.getLimitedTracking(..));
        TuplesKt.to("limitAdTracking", Boxing.boxBoolean(..));
        DynamicDeviceInfoOuterClass$DynamicDeviceInfo.getAndroid();
        DynamicDeviceInfoOuterClass$DynamicDeviceInfo$Android.getMaxVolume();
        Boxing.boxDouble(DynamicDeviceInfoOuterClass$DynamicDeviceInfo$Android.getMaxVolume(..), 6);
        TuplesKt.to("maxVolume", Boxing.boxDouble(..));
        TuplesKt.to("gameId", "");
        MapsKt.mapOf(11);
        return MapsKt.mapOf(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetAdRequest
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetAdRequest {
    private final CampaignRepository campaignRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
    private final SessionRepository sessionRepository;
    private final TcfRepository tcfRepository;
    private final WebviewConfigurationDataSource webViewConfigurationDataSource;

    public AndroidGetAdRequest(GetUniversalRequestForPayLoad p0, SessionRepository p1, DeviceInfoRepository p2, CampaignRepository p3, WebviewConfigurationDataSource p4, TcfRepository p5) {
        new Object();
        getUniversalRequestForPayLoad = p0;
        sessionRepository = p1;
        deviceInfoRepository = p2;
        campaignRepository = p3;
        webViewConfigurationDataSource = p4;
        tcfRepository = p5;
        return;
    }

    public Object invoke(String p0, ByteString p1, AdRequestOuterClass$BannerSize p2, Continuation p3) {
        if (if-eqz(v2)) goto L_18;
        if (if-eqz(label)) goto L_18;
        label = label;
      L_18:
        new AndroidGetAdRequest$invoke$1(this, label);
      L_1d:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_7e;
        if (if-eq(label, 1)) goto L_59;
        if (if-eq(label, 2)) goto L_40;
        if (if-ne(label, 3)) goto L_38;
        ResultKt.throwOnFailure(result);
      L_38:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_40:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_59:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_7e:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        AdRequestOuterClass$AdRequest.newBuilder();
        AdRequestKt$Dsl.Companion._create(AdRequestOuterClass$AdRequest.newBuilder(..));
        sessionRepository.getSessionCounters();
        AdRequestKt$Dsl.setSessionCounters(SessionRepository.getSessionCounters(..));
        L$0 = this;
        L$1 = p0;
        L$2 = p1;
        L$3 = p2;
        L$4 = AdRequestKt$Dsl$Companion._create(..);
        L$5 = AdRequestKt$Dsl$Companion._create(..);
        L$6 = AdRequestKt$Dsl$Companion._create(..);
        label = L$2;
        deviceInfoRepository.staticDeviceInfo("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(DeviceInfoRepository.staticDeviceInfo(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_b6;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_b6:
      L_ba:
        AdRequestKt$Dsl.setStaticDeviceInfo(DeviceInfoRepository.staticDeviceInfo(..));
        deviceInfoRepository.getDynamicDeviceInfo();
        AdRequestKt$Dsl.setDynamicDeviceInfo(DeviceInfoRepository.getDynamicDeviceInfo(..));
        AdRequestKt$Dsl.setImpressionOpportunityId(p1);
        AdRequestKt$Dsl.setPlacementId(p0);
        AdRequestKt$Dsl.setRequestImpressionConfiguration(L$2);
        L$0 = this;
        L$1 = p2;
        L$2 = AdRequestKt$Dsl$Companion._create(..);
        L$3 = AdRequestKt$Dsl$Companion._create(..);
        L$4 = AdRequestKt$Dsl$Companion._create(..);
        L$5 = 0;
        L$6 = 0;
        label = L$3;
        webViewConfigurationDataSource.get("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(WebviewConfigurationDataSource.get(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_ea;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_ea:
      L_ef:
        WebviewConfigurationStore$WebViewConfigurationStore.getVersion();
        AdRequestKt$Dsl.setWebviewVersion(WebviewConfigurationStore$WebViewConfigurationStore.getVersion(..));
        campaignRepository.getCampaignState();
        AdRequestKt$Dsl.setCampaignState(CampaignRepository.getCampaignState(..));
        if (if-nez(p2)) goto L_109;
        AdRequestKt$Dsl.setAdRequestType(AdRequestOuterClass$AdRequestType.AD_REQUEST_TYPE_FULLSCREEN);
      L_109:
        AdRequestKt$Dsl.setAdRequestType(AdRequestOuterClass$AdRequestType.AD_REQUEST_TYPE_BANNER);
        AdRequestKt$Dsl.setBannerSize(p2);
      L_111:
        tcfRepository.getTcfString();
        if (if-eqz(TcfRepository.getTcfString(..))) goto L_120;
        ProtobufExtensionsKt.toISO8859ByteString(TcfRepository.getTcfString(..));
        AdRequestKt$Dsl.setTcf(ProtobufExtensionsKt.toISO8859ByteString(..));
      L_120:
        AdRequestKt$Dsl._build();
        UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder();
        UniversalRequestKt$PayloadKt$Dsl$Companion._create(UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder(..));
        UniversalRequestKt$PayloadKt$Dsl.setAdRequest(AdRequestKt$Dsl._build(..));
        UniversalRequestKt$PayloadKt$Dsl._build();
        L$0 = 0;
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        L$4 = 0;
        label = 3;
        getUniversalRequestForPayLoad.invoke(UniversalRequestKt$PayloadKt$Dsl._build(..), "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(GetUniversalRequestForPayLoad.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14f;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_14f:
        return GetUniversalRequestForPayLoad.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetAdRequestPolicy
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetAdRequestPolicy {
    private final SessionRepository sessionRepository;

    public AndroidGetAdRequestPolicy(SessionRepository p0) {
        new Object();
        sessionRepository = p0;
        return;
    }

    public RequestPolicy invoke() {
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getAdPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getMaxDuration();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getAdPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getRetryMaxInterval();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getAdPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getRetryWaitBase();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getAdPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getRetryJitterPct();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getAdPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getConnectTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getAdPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getReadTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getAdPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getWriteTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getAdPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getOverallTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getAdPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getShouldStoreLocally();
        new RequestPolicy(NativeConfigurationOuterClass$RequestRetryPolicy.getMaxDuration(..), NativeConfigurationOuterClass$RequestRetryPolicy.getRetryMaxInterval(..), NativeConfigurationOuterClass$RequestRetryPolicy.getRetryWaitBase(..), NativeConfigurationOuterClass$RequestRetryPolicy.getRetryJitterPct(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getConnectTimeoutMs(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getReadTimeoutMs(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getWriteTimeoutMs(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getOverallTimeoutMs(..), NativeConfigurationOuterClass$RequestRetryPolicy.getShouldStoreLocally(..));
        return new RequestPolicy;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetClientInfo
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetClientInfo {
    private final MediationRepository mediationRepository;
    private final OmidManager omidManager;
    private final SessionRepository sessionRepository;

    public AndroidGetClientInfo(SessionRepository p0, MediationRepository p1, OmidManager p2) {
        new Object();
        sessionRepository = p0;
        mediationRepository = p1;
        omidManager = p2;
        return;
    }

    public ClientInfoOuterClass$ClientInfo invoke() {
        ClientInfoOuterClass$ClientInfo.newBuilder();
        ClientInfoKt$Dsl.Companion._create(ClientInfoOuterClass$ClientInfo.newBuilder(..));
        ClientInfoKt$Dsl.setSdkVersion(41205);
        ClientInfoKt$Dsl.setSdkVersionName("4.12.5");
        sessionRepository.getGameId();
        if (if-eqz(SessionRepository.getGameId(..))) goto L_25;
        ClientInfoKt$Dsl.setGameId(SessionRepository.getGameId(..));
      L_25:
        sessionRepository.isTestModeEnabled();
        ClientInfoKt$Dsl.setTest(SessionRepository.isTestModeEnabled(..));
        ClientInfoKt$Dsl.setPlatform(ClientInfoOuterClass$Platform.PLATFORM_ANDROID);
        mediationRepository.getMediationProvider();
        Function0.invoke();
        ClientInfoKt$Dsl.setMediationProvider(Function0.invoke(..));
        mediationRepository.getName();
        if (if-eqz(MediationRepository.getName(..))) goto L_55;
        ClientInfoKt$Dsl.getMediationProvider();
        if (if-ne(ClientInfoKt$Dsl.getMediationProvider(..), ClientInfoOuterClass$MediationProvider.MEDIATION_PROVIDER_CUSTOM)) goto L_55;
        ClientInfoKt$Dsl.setCustomMediationName(MediationRepository.getName(..));
      L_55:
        mediationRepository.getVersion();
        if (if-eqz(MediationRepository.getVersion(..))) goto L_60;
        ClientInfoKt$Dsl.setMediationVersion(MediationRepository.getVersion(..));
      L_60:
        omidManager.getVersion();
        ClientInfoKt$Dsl.setOmidVersion(OmidManager.getVersion(..));
        ClientInfoKt$Dsl.setOmidPartnerVersion("1");
        MadeWithUnityDetector.isMadeWithUnity();
        if (if-eqz(MadeWithUnityDetector.isMadeWithUnity(..))) goto L_77;
      L_77:
      L_79:
        ClientInfoKt$Dsl.setSdkDevelopmentPlatform("");
        ClientInfoKt$Dsl._build();
        return ClientInfoKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetInitializationCompletedRequest
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetInitializationCompletedRequest {
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    public AndroidGetInitializationCompletedRequest(GetUniversalRequestForPayLoad p0, DeviceInfoRepository p1) {
        new Object();
        getUniversalRequestForPayLoad = p0;
        deviceInfoRepository = p1;
        return;
    }

    public Object invoke(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidGetInitializationCompletedRequest$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_4c;
        if (if-eq(label, 1)) goto L_38;
        if (if-ne(label, 2)) goto L_30;
        ResultKt.throwOnFailure(result);
      L_30:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_38:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_4c:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        InitializationCompletedEventRequestOuterClass$InitializationCompletedEventRequest.newBuilder();
        InitializationCompletedEventRequestKt$Dsl$Companion._create(InitializationCompletedEventRequestOuterClass$InitializationCompletedEventRequest.newBuilder(..));
        L$0 = this;
        L$1 = InitializationCompletedEventRequestKt$Dsl$Companion._create(..);
        L$2 = InitializationCompletedEventRequestKt$Dsl$Companion._create(..);
        L$3 = InitializationCompletedEventRequestKt$Dsl$Companion._create(..);
        label = L$2;
        deviceInfoRepository.staticDeviceInfo("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(DeviceInfoRepository.staticDeviceInfo(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_6f;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_6f:
      L_72:
        InitializationCompletedEventRequestKt$Dsl.setStaticDeviceInfo(DeviceInfoRepository.staticDeviceInfo(..));
        deviceInfoRepository.getDynamicDeviceInfo();
        InitializationCompletedEventRequestKt$Dsl.setDynamicDeviceInfo(DeviceInfoRepository.getDynamicDeviceInfo(..));
        InitializationCompletedEventRequestKt$Dsl._build();
        UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder();
        UniversalRequestKt$PayloadKt$Dsl$Companion._create(UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder(..));
        UniversalRequestKt$PayloadKt$Dsl.setInitializationCompletedEventRequest(InitializationCompletedEventRequestKt$Dsl._build(..));
        UniversalRequestKt$PayloadKt$Dsl._build();
        L$0 = 0;
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        label = 2;
        getUniversalRequestForPayLoad.invoke(UniversalRequestKt$PayloadKt$Dsl._build(..), "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(GetUniversalRequestForPayLoad.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_ae;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_ae:
        return GetUniversalRequestForPayLoad.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetInitializationData
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetInitializationData {
    private final GetInitializationRequestPayload getInitializeRequestPayload;
    private final GetUniversalRequestSharedData getUniversalRequestSharedData;

    public AndroidGetInitializationData(GetInitializationRequestPayload p0, GetUniversalRequestSharedData p1) {
        new Object();
        getInitializeRequestPayload = p0;
        getUniversalRequestSharedData = p1;
        return;
    }

    public Object invoke(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidGetInitializationData$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_54;
        if (if-eq(label, 1)) goto L_3d;
        if (if-ne(label, 2)) goto L_35;
        ResultKt.throwOnFailure(result);
      L_35:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_3d:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_54:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        InitializationDataOuterClass$InitializationData.newBuilder();
        InitializationDataKt$Dsl.Companion._create(InitializationDataOuterClass$InitializationData.newBuilder(..));
        L$0 = this;
        L$1 = InitializationDataKt$Dsl$Companion._create(..);
        L$2 = InitializationDataKt$Dsl$Companion._create(..);
        L$3 = InitializationDataKt$Dsl$Companion._create(..);
        label = L$2;
        getInitializeRequestPayload.invoke("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(GetInitializationRequestPayload.invoke(..), L$1)) goto L_79;
        return L$1;
      L_79:
      L_7c:
        InitializationDataKt$Dsl.setInitializationRequest(GetInitializationRequestPayload.invoke(..));
        L$0 = InitializationDataKt$Dsl$Companion._create(..);
        L$1 = InitializationDataKt$Dsl$Companion._create(..);
        L$2 = 0;
        L$3 = 0;
        label = 2;
        getUniversalRequestSharedData.invoke("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(GetUniversalRequestSharedData.invoke(..), L$1)) goto L_95;
        return L$1;
      L_95:
      L_97:
        InitializationDataKt$Dsl.setSharedData(GetUniversalRequestSharedData.invoke(..));
        InitializationDataKt$Dsl._build();
        return InitializationDataKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetInitializationRequest
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetInitializationRequest {
    private final GetInitializationRequestPayload getInitializationRequestPayload;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    public AndroidGetInitializationRequest(GetInitializationRequestPayload p0, GetUniversalRequestForPayLoad p1) {
        new Object();
        getInitializationRequestPayload = p0;
        getUniversalRequestForPayLoad = p1;
        return;
    }

    public Object invoke(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidGetInitializationRequest$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_3d;
        if (if-eq(label, 1)) goto L_35;
        if (if-ne(label, 2)) goto L_2d;
        ResultKt.throwOnFailure(result);
      L_2d:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_35:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_3d:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        L$0 = this;
        label = 1;
        getInitializationRequestPayload.invoke("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(GetInitializationRequestPayload.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4d;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4d:
      L_4e:
        UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder();
        UniversalRequestKt$PayloadKt$Dsl$Companion._create(UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder(..));
        UniversalRequestKt$PayloadKt$Dsl.setInitializationRequest(GetInitializationRequestPayload.invoke(..));
        UniversalRequestKt$PayloadKt$Dsl._build();
        L$0 = 0;
        label = 2;
        getUniversalRequestForPayLoad.invoke(UniversalRequestKt$PayloadKt$Dsl._build(..), "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(GetUniversalRequestForPayLoad.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_76;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_76:
        return GetUniversalRequestForPayLoad.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetInitializationRequestPayload {
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetClientInfo getClientInfo;
    private final LegacyUserConsentRepository legacyUserConsentRepository;
    private final SessionRepository sessionRepository;

    public AndroidGetInitializationRequestPayload(GetClientInfo p0, SessionRepository p1, DeviceInfoRepository p2, LegacyUserConsentRepository p3) {
        new Object();
        getClientInfo = p0;
        sessionRepository = p1;
        deviceInfoRepository = p2;
        legacyUserConsentRepository = p3;
        return;
    }

    public Object invoke(Continuation p0) {
        if (if-eqz(v2)) goto L_18;
        if (if-eqz(label)) goto L_18;
        label = label;
      L_18:
        new AndroidGetInitializationRequestPayload$invoke$1(this, label);
      L_1d:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
        ResultKt.throwOnFailure(new IllegalStateException(..));
        ResultKt.throwOnFailure(new IllegalStateException(..));
        ResultKt.throwOnFailure(new IllegalStateException(..));
        ResultKt.throwOnFailure(new IllegalStateException(..));
        ResultKt.throwOnFailure(new IllegalStateException(..));
        ResultKt.throwOnFailure(new IllegalStateException(..));
        ResultKt.throwOnFailure(new IllegalStateException(..));
        ResultKt.throwOnFailure(new IllegalStateException(..));
        InitializationRequestOuterClass$InitializationRequest.newBuilder();
        InitializationRequestKt$Dsl$Companion._create(InitializationRequestOuterClass$InitializationRequest.newBuilder(..));
        StorageManager.getStorage(StorageManager$StorageType.PRIVATE);
        StorageManager.getStorage(..).readStorage();
        if (if-eqz(Storage.readStorage(..))) goto L_105;
        StorageManager.getStorage(..).get("configuration.hasInitialized");
        if (if-eqz("configuration.hasInitialized")) goto L_f8;
      L_f8:
      L_f9:
        if (if-eqz(L$0)) goto L_100;
        L$0.booleanValue();
      L_100:
      L_101:
        if (if-eqz(L$0)) goto L_105;
      L_105:
      L_106:
        InitializationRequestKt$Dsl.setIsFirstInit(L$0);
        getClientInfo.invoke();
        InitializationRequestKt$Dsl.setClientInfo(GetClientInfo.invoke(..));
        L$0 = this;
        L$1 = InitializationRequestKt$Dsl$Companion._create(..);
        L$2 = InitializationRequestKt$Dsl$Companion._create(..);
        L$3 = InitializationRequestKt$Dsl$Companion._create(..);
        label = 1;
        deviceInfoRepository.getIdfi(L$0);
        if (if-ne(DeviceInfoRepository.getIdfi(..), L$2)) goto L_126;
        return L$2;
      L_126:
      L_129:
        InitializationRequestKt$Dsl.setIdfi(DeviceInfoRepository.getIdfi(..));
        deviceInfoRepository.getAnalyticsUserId();
        if (if-eqz(DeviceInfoRepository.getAnalyticsUserId(..))) goto L_139;
        InitializationRequestKt$Dsl.setAnalyticsUserId(DeviceInfoRepository.getAnalyticsUserId(..));
      L_139:
        sessionRepository.getSessionId();
        InitializationRequestKt$Dsl.setSessionId(SessionRepository.getSessionId(..));
        InitializationRequestOuterClass$InitializationDeviceInfo.newBuilder();
        InitializationDeviceInfoKt$Dsl$Companion._create(InitializationRequestOuterClass$InitializationDeviceInfo.newBuilder(..));
        deviceInfoRepository.getAppName();
        InitializationDeviceInfoKt$Dsl.setBundleId(DeviceInfoRepository.getAppName(..));
        deviceInfoRepository.getModel();
        InitializationDeviceInfoKt$Dsl.setDeviceModel(DeviceInfoRepository.getModel(..));
        deviceInfoRepository.getManufacturer();
        InitializationDeviceInfoKt$Dsl.setDeviceMake(DeviceInfoRepository.getManufacturer(..));
        deviceInfoRepository.getOsVersion();
        InitializationDeviceInfoKt$Dsl.setOsVersion(DeviceInfoRepository.getOsVersion(..));
        L$0 = this;
        L$1 = InitializationRequestKt$Dsl$Companion._create(..);
        L$2 = InitializationRequestKt$Dsl$Companion._create(..);
        L$3 = InitializationDeviceInfoKt$Dsl$Companion._create(..);
        L$4 = InitializationRequestKt$Dsl$Companion._create(..);
        L$5 = InitializationDeviceInfoKt$Dsl$Companion._create(..);
        L$6 = InitializationDeviceInfoKt$Dsl$Companion._create(..);
        label = 2;
        deviceInfoRepository.staticDeviceInfo(L$0);
        if (if-ne(DeviceInfoRepository.staticDeviceInfo(..), L$2)) goto L_18d;
        return L$2;
      L_18d:
      L_192:
        StaticDeviceInfoOuterClass$StaticDeviceInfo.getTotalDiskSpace();
        InitializationDeviceInfoKt$Dsl.setTotalDiskSpace(StaticDeviceInfoOuterClass$StaticDeviceInfo.getTotalDiskSpace(..), v15);
        L$0 = this;
        L$1 = InitializationRequestKt$Dsl$Companion._create(..);
        L$2 = InitializationRequestKt$Dsl$Companion._create(..);
        L$3 = InitializationDeviceInfoKt$Dsl$Companion._create(..);
        L$4 = InitializationRequestKt$Dsl$Companion._create(..);
        L$5 = InitializationDeviceInfoKt$Dsl$Companion._create(..);
        L$6 = InitializationDeviceInfoKt$Dsl$Companion._create(..);
        label = 3;
        deviceInfoRepository.staticDeviceInfo(L$0);
        if (if-ne(DeviceInfoRepository.staticDeviceInfo(..), L$2)) goto L_1b5;
        return L$2;
      L_1b5:
      L_1b6:
        StaticDeviceInfoOuterClass$StaticDeviceInfo.getTotalRamMemory();
        InitializationDeviceInfoKt$Dsl.setTotalRamMemory(StaticDeviceInfoOuterClass$StaticDeviceInfo.getTotalRamMemory(..), v15);
        deviceInfoRepository.getCurrentUiTheme();
        InitializationDeviceInfoKt$Dsl.setCurrentUiTheme(StaticDeviceInfoOuterClass$StaticDeviceInfo.getTotalRamMemory(..), v15);
        deviceInfoRepository.getDynamicDeviceInfo();
        DynamicDeviceInfoOuterClass$DynamicDeviceInfo.getNetworkOperator();
        InitializationDeviceInfoKt$Dsl.setNetworkOperator(DynamicDeviceInfoOuterClass$DynamicDeviceInfo.getNetworkOperator(..));
        deviceInfoRepository.getDynamicDeviceInfo();
        DynamicDeviceInfoOuterClass$DynamicDeviceInfo.getBatteryLevel();
        InitializationDeviceInfoKt$Dsl.setBatteryLevel(DynamicDeviceInfoOuterClass$DynamicDeviceInfo.getBatteryLevel(..), v15);
        deviceInfoRepository.getDynamicDeviceInfo();
        DynamicDeviceInfoOuterClass$DynamicDeviceInfo.getBatteryStatus();
        InitializationDeviceInfoKt$Dsl.setBatteryStatus(DynamicDeviceInfoOuterClass$DynamicDeviceInfo.getBatteryStatus(..));
        deviceInfoRepository.getSystemBootTime();
        InitializationDeviceInfoKt$Dsl.setSystemBootTime(DeviceInfoRepository.getSystemBootTime(..), v15);
        deviceInfoRepository.getDynamicDeviceInfo();
        DynamicDeviceInfoOuterClass$DynamicDeviceInfo.getLanguage();
        InitializationDeviceInfoKt$Dsl.setLanguage(DynamicDeviceInfoOuterClass$DynamicDeviceInfo.getLanguage(..));
        deviceInfoRepository.getLocaleList();
        CollectionsKt.joinToString$default(DeviceInfoRepository.getLocaleList(..), ",", 0, 0, 0, 0, 0, 62, 0);
        InitializationDeviceInfoKt$Dsl.setLocalList(CollectionsKt.joinToString$default(..));
        deviceInfoRepository.getConnectionTypeStr();
        InitializationDeviceInfoKt$Dsl.setConnectionType(DeviceInfoRepository.getConnectionTypeStr(..));
        InitializationDeviceInfoKt$Dsl._build();
        InitializationRequestKt$Dsl.setDeviceInfo(InitializationDeviceInfoKt$Dsl._build(..));
        L$0 = this;
        L$1 = InitializationRequestKt$Dsl$Companion._create(..);
        L$2 = InitializationRequestKt$Dsl$Companion._create(..);
        L$3 = L$0;
        L$4 = L$0;
        L$5 = L$0;
        L$6 = L$0;
        label = 4;
        deviceInfoRepository.getAuidByteString(L$0);
        if (if-ne(DeviceInfoRepository.getAuidByteString(..), L$2)) goto L_25d;
        return L$2;
      L_25d:
      L_260:
        if (if-eqz(DeviceInfoRepository.getAuidByteString(..))) goto L_267;
        InitializationRequestKt$Dsl.setAuid(DeviceInfoRepository.getAuidByteString(..));
      L_267:
        L$0 = this;
        L$1 = InitializationRequestKt$Dsl$Companion._create(..);
        L$2 = InitializationRequestKt$Dsl$Companion._create(..);
        label = 5;
        deviceInfoRepository.getAuidString(L$0);
        if (if-ne(DeviceInfoRepository.getAuidString(..), L$2)) goto L_279;
        return L$2;
      L_279:
        if (if-eqz(DeviceInfoRepository.getAuidString(..))) goto L_286;
        CharSequence.length();
        if (if-nez(CharSequence.length(..))) goto L_287;
      L_286:
      L_287:
        if (if-nez(1)) goto L_28c;
        InitializationRequestKt$Dsl.setAuidString(DeviceInfoRepository.getAuidString(..));
      L_28c:
        L$0 = this;
        L$1 = InitializationRequestKt$Dsl$Companion._create(..);
        L$2 = InitializationRequestKt$Dsl$Companion._create(..);
        label = 6;
        sessionRepository.getPrivacy(L$0);
        if (if-ne(SessionRepository.getPrivacy(..), L$2)) goto L_29e;
        return L$2;
      L_29e:
      L_29f:
        SessionRepository.getPrivacy(..).isEmpty();
        if (if-nez(ByteString.isEmpty(..))) goto L_2aa;
        InitializationRequestKt$Dsl.setPrivacy(SessionRepository.getPrivacy(..));
      L_2aa:
        L$0 = this;
        L$1 = InitializationRequestKt$Dsl$Companion._create(..);
        L$2 = InitializationRequestKt$Dsl$Companion._create(..);
        label = 7;
        sessionRepository.getGatewayCache(L$0);
        if (if-ne(SessionRepository.getGatewayCache(..), L$2)) goto L_2bc;
        return L$2;
      L_2bc:
      L_2bf:
        ByteString.isEmpty();
        if (if-nez(ByteString.isEmpty(..))) goto L_2ca;
        InitializationRequestKt$Dsl.setCache(SessionRepository.getGatewayCache(..));
      L_2ca:
        legacyUserConsentRepository.getLegacyFlowUserConsent();
        if (if-eqz(LegacyUserConsentRepository.getLegacyFlowUserConsent(..))) goto L_2d5;
        InitializationRequestKt$Dsl.setLegacyFlowUserConsent(LegacyUserConsentRepository.getLegacyFlowUserConsent(..));
      L_2d5:
        InitializationRequestKt$Dsl._build();
        return InitializationRequestKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetLimitedSessionToken
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetLimitedSessionToken {
    private final DeviceInfoRepository deviceInfoRepository;
    private final MediationRepository mediationRepository;
    private final SessionRepository sessionRepository;

    public AndroidGetLimitedSessionToken(DeviceInfoRepository p0, SessionRepository p1, MediationRepository p2) {
        new Object();
        deviceInfoRepository = p0;
        sessionRepository = p1;
        mediationRepository = p2;
        return;
    }

    public Object invoke(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidGetLimitedSessionToken$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_89;
        if (if-eq(label, 1)) goto L_75;
        if (if-eq(label, 2)) goto L_61;
        if (if-eq(label, 3)) goto L_4c;
        if (if-ne(label, 4)) goto L_44;
        ResultKt.throwOnFailure(result);
      L_44:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_4c:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_61:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_75:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_89:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        UniversalRequestOuterClass$LimitedSessionToken.newBuilder();
        LimitedSessionTokenKt$Dsl.Companion._create(UniversalRequestOuterClass$LimitedSessionToken.newBuilder(..));
        sessionRepository.getSessionId();
        LimitedSessionTokenKt$Dsl.setSessionId(SessionRepository.getSessionId(..));
        L$0 = this;
        L$1 = LimitedSessionTokenKt$Dsl$Companion._create(..);
        L$2 = LimitedSessionTokenKt$Dsl$Companion._create(..);
        L$3 = LimitedSessionTokenKt$Dsl$Companion._create(..);
        label = L$2;
        deviceInfoRepository.staticDeviceInfo("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(DeviceInfoRepository.staticDeviceInfo(..), L$3)) goto L_b7;
        return L$3;
      L_b7:
      L_ba:
        StaticDeviceInfoOuterClass$StaticDeviceInfo.getDeviceMake();
        LimitedSessionTokenKt$Dsl.setDeviceMake(StaticDeviceInfoOuterClass$StaticDeviceInfo.getDeviceMake(..));
        L$0 = this;
        L$1 = LimitedSessionTokenKt$Dsl$Companion._create(..);
        L$2 = LimitedSessionTokenKt$Dsl$Companion._create(..);
        L$3 = LimitedSessionTokenKt$Dsl$Companion._create(..);
        label = L$2;
        deviceInfoRepository.staticDeviceInfo("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(DeviceInfoRepository.staticDeviceInfo(..), L$3)) goto L_db;
        return L$3;
      L_db:
      L_df:
        StaticDeviceInfoOuterClass$StaticDeviceInfo.getDeviceModel();
        LimitedSessionTokenKt$Dsl.setDeviceModel(StaticDeviceInfoOuterClass$StaticDeviceInfo.getDeviceModel(..));
        L$0 = this;
        L$1 = LimitedSessionTokenKt$Dsl$Companion._create(..);
        L$2 = LimitedSessionTokenKt$Dsl$Companion._create(..);
        L$3 = LimitedSessionTokenKt$Dsl$Companion._create(..);
        label = L$2;
        deviceInfoRepository.staticDeviceInfo("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(DeviceInfoRepository.staticDeviceInfo(..), L$3)) goto L_100;
        return L$3;
      L_100:
      L_104:
        StaticDeviceInfoOuterClass$StaticDeviceInfo.getOsVersion();
        LimitedSessionTokenKt$Dsl.setOsVersion(StaticDeviceInfoOuterClass$StaticDeviceInfo.getOsVersion(..));
        L$0 = this;
        L$1 = LimitedSessionTokenKt$Dsl$Companion._create(..);
        L$2 = LimitedSessionTokenKt$Dsl$Companion._create(..);
        L$3 = LimitedSessionTokenKt$Dsl$Companion._create(..);
        label = L$1;
        deviceInfoRepository.getIdfi("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(DeviceInfoRepository.getIdfi(..), L$3)) goto L_125;
        return L$3;
      L_125:
      L_129:
        LimitedSessionTokenKt$Dsl.setIdfi(DeviceInfoRepository.getIdfi(..));
        LimitedSessionTokenKt$Dsl.setSdkVersion(41205);
        LimitedSessionTokenKt$Dsl.setSdkVersionName("4.12.5");
        sessionRepository.getGameId();
        if (if-eqz(SessionRepository.getGameId(..))) goto L_144;
        LimitedSessionTokenKt$Dsl.setGameId(SessionRepository.getGameId(..));
      L_144:
        LimitedSessionTokenKt$Dsl.setPlatform(ClientInfoOuterClass$Platform.PLATFORM_ANDROID);
        mediationRepository.getMediationProvider();
        Function0.invoke();
        LimitedSessionTokenKt$Dsl.setMediationProvider(Function0.invoke(..));
        mediationRepository.getName();
        if (if-eqz(MediationRepository.getName(..))) goto L_16b;
        LimitedSessionTokenKt$Dsl.getMediationProvider();
        if (if-ne(LimitedSessionTokenKt$Dsl.getMediationProvider(..), ClientInfoOuterClass$MediationProvider.MEDIATION_PROVIDER_CUSTOM)) goto L_16b;
        LimitedSessionTokenKt$Dsl.setCustomMediationName(MediationRepository.getName(..));
      L_16b:
        mediationRepository.getVersion();
        if (if-eqz(MediationRepository.getVersion(..))) goto L_176;
        LimitedSessionTokenKt$Dsl.setMediationVersion(MediationRepository.getVersion(..));
      L_176:
        LimitedSessionTokenKt$Dsl._build();
        return LimitedSessionTokenKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetOpenGLRendererInfo
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetOpenGLRendererInfo {
    private final SessionRepository sessionRepository;

    public AndroidGetOpenGLRendererInfo(SessionRepository p0) {
        new Object();
        sessionRepository = p0;
        return;
    }

    public ByteString invoke() {
        sessionRepository.getFeatureFlags();
        NativeConfigurationOuterClass$FeatureFlags.getOpenglGpuEnabled();
        if (if-eqz(NativeConfigurationOuterClass$FeatureFlags.getOpenglGpuEnabled(..))) goto L_42;
        new EglCore(0, 2);
        new OffscreenSurface(new EglCore(..), 1, 1);
        new OffscreenSurface(..).makeCurrent();
        GLES20.glGetString(7937);
        GLES20.glGetString(..).getBytes(Charsets.ISO_8859_1);
        ByteString.copyFrom(String.getBytes(..));
        new OffscreenSurface(..).release();
        new EglCore(..).release();
      L_42:
        ByteString.empty();
      L_4b:
        return ByteString.empty(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetSharedDataTimestamps
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetSharedDataTimestamps {
    public AndroidGetSharedDataTimestamps() {
        new Object();
        return;
    }

    public TimestampsOuterClass$Timestamps invoke() {
        TimestampsOuterClass$Timestamps.newBuilder();
        TimestampsKt$Dsl.Companion._create(TimestampsOuterClass$Timestamps.newBuilder(..));
        System.currentTimeMillis();
        TimestampExtensionsKt.fromMillis(System.currentTimeMillis(..), "newBuilder()");
        TimestampsKt$Dsl.setTimestamp(TimestampExtensionsKt.fromMillis(..));
        SystemClock.elapsedRealtime();
        SdkProperties.getInitializationTime();
        TimestampsKt$Dsl.setSessionTimestamp(SystemClock.elapsedRealtime(..), "newBuilder()");
        TimestampsKt$Dsl._build();
        return TimestampsKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetUniversalRequestForPayLoad
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetUniversalRequestForPayLoad {
    private final GetUniversalRequestSharedData getUniversalRequestSharedData;

    public AndroidGetUniversalRequestForPayLoad(GetUniversalRequestSharedData p0) {
        new Object();
        getUniversalRequestSharedData = p0;
        return;
    }

    public Object invoke(UniversalRequestOuterClass$UniversalRequest$Payload p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidGetUniversalRequestForPayLoad$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_42;
        if (if-ne(label, 1)) goto L_3a;
        ResultKt.throwOnFailure(result);
      L_3a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_42:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        UniversalRequestOuterClass$UniversalRequest.newBuilder();
        UniversalRequestKt$Dsl.Companion._create(UniversalRequestOuterClass$UniversalRequest.newBuilder(..));
        L$0 = new IllegalStateException(..);
        L$1 = UniversalRequestKt$Dsl$Companion._create(..);
        L$2 = UniversalRequestKt$Dsl$Companion._create(..);
        L$3 = UniversalRequestKt$Dsl$Companion._create(..);
        label = 1;
        getUniversalRequestSharedData.invoke(L$0);
        if (if-ne(GetUniversalRequestSharedData.invoke(..), L$2)) goto L_67;
        return L$2;
      L_67:
      L_6c:
        UniversalRequestKt$Dsl.setSharedData(GetUniversalRequestSharedData.invoke(..));
        UniversalRequestKt$Dsl.setPayload(new IllegalStateException(..));
        UniversalRequestKt$Dsl._build();
        return UniversalRequestKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetUniversalRequestSharedData
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetUniversalRequestSharedData {
    private final DeveloperConsentRepository developerConsentRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetLimitedSessionToken getLimitedSessionToken;
    private final GetSharedDataTimestamps getSharedDataTimestamps;
    private final SessionRepository sessionRepository;

    public AndroidGetUniversalRequestSharedData(GetSharedDataTimestamps p0, SessionRepository p1, DeviceInfoRepository p2, GetLimitedSessionToken p3, DeveloperConsentRepository p4) {
        new Object();
        getSharedDataTimestamps = p0;
        sessionRepository = p1;
        deviceInfoRepository = p2;
        getLimitedSessionToken = p3;
        developerConsentRepository = p4;
        return;
    }

    public Object invoke(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidGetUniversalRequestSharedData$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_42;
        if (if-ne(label, 1)) goto L_3a;
        ResultKt.throwOnFailure(result);
      L_3a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_42:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        UniversalRequestOuterClass$UniversalRequest$SharedData.newBuilder();
        UniversalRequestKt$SharedDataKt$Dsl$Companion._create(UniversalRequestOuterClass$UniversalRequest$SharedData.newBuilder(..));
        sessionRepository.getSessionToken();
        ByteString.isEmpty();
        if (if-nez(ByteString.isEmpty(..))) goto L_68;
        UniversalRequestKt$SharedDataKt$Dsl.setSessionToken(SessionRepository.getSessionToken(..));
      L_68:
        L$0 = this;
        L$1 = UniversalRequestKt$SharedDataKt$Dsl$Companion._create(..);
        L$2 = UniversalRequestKt$SharedDataKt$Dsl$Companion._create(..);
        L$3 = UniversalRequestKt$SharedDataKt$Dsl$Companion._create(..);
        label = UniversalRequestKt$SharedDataKt$Dsl$Companion._create(..);
        getLimitedSessionToken.invoke(this);
        if (if-ne(GetLimitedSessionToken.invoke(..), L$3)) goto L_7b;
        return L$3;
      L_7b:
      L_80:
        UniversalRequestKt$SharedDataKt$Dsl.setLimitedSessionToken(GetLimitedSessionToken.invoke(..));
      L_86:
        getSharedDataTimestamps.invoke();
        UniversalRequestKt$SharedDataKt$Dsl.setTimestamps(GetSharedDataTimestamps.invoke(..));
        SdkProperties.getInitializationTimeEpoch();
        TimestampExtensionsKt.fromMillis(SdkProperties.getInitializationTimeEpoch(..), UniversalRequestKt$SharedDataKt$Dsl$Companion._create(..));
        UniversalRequestKt$SharedDataKt$Dsl.setSdkStartTime(TimestampExtensionsKt.fromMillis(..));
        SdkProperties.getAppInitializationTimeSinceEpoch();
        TimestampExtensionsKt.fromMillis(SdkProperties.getAppInitializationTimeSinceEpoch(..), UniversalRequestKt$SharedDataKt$Dsl$Companion._create(..));
        UniversalRequestKt$SharedDataKt$Dsl.setAppStartTime(TimestampExtensionsKt.fromMillis(..));
        developerConsentRepository.getDeveloperConsent();
        UniversalRequestKt$SharedDataKt$Dsl.setDeveloperConsent(DeveloperConsentRepository.getDeveloperConsent(..));
        deviceInfoRepository.getPiiData();
        DeviceInfoRepository.getPiiData(..).getAdvertisingId();
        ByteString.isEmpty();
        if (if-eqz(ByteString.isEmpty(..))) goto L_c8;
        DeviceInfoRepository.getPiiData(..).getOpenAdvertisingTrackingId();
        ByteString.isEmpty();
        if (if-nez(ByteString.isEmpty(..))) goto L_cb;
      L_c8:
        UniversalRequestKt$SharedDataKt$Dsl.setPii(DeviceInfoRepository.getPiiData(..));
      L_cb:
        UniversalRequestKt$SharedDataKt$Dsl._build();
        return UniversalRequestKt$SharedDataKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetWebViewContainerUseCase {
    private final AndroidWebViewClient androidWebViewClient;
    private final Context context;
    private final CoroutineDispatcher defaultDispatcher;
    private final CoroutineDispatcher mainDispatcher;
    private final SendWebViewClientErrorDiagnostics sendWebViewClientErrorDiagnostics;

    public AndroidGetWebViewContainerUseCase(Context p0, AndroidWebViewClient p1, SendWebViewClientErrorDiagnostics p2, CoroutineDispatcher p3, CoroutineDispatcher p4) {
        new Object();
        context = p0;
        androidWebViewClient = p1;
        sendWebViewClientErrorDiagnostics = p2;
        mainDispatcher = p3;
        defaultDispatcher = p4;
        return;
    }

    public static final AndroidWebViewClient access$getAndroidWebViewClient$p(AndroidGetWebViewContainerUseCase p0) {
        return androidWebViewClient;
    }

    public static final Context access$getContext$p(AndroidGetWebViewContainerUseCase p0) {
        return context;
    }

    public Object invoke(CoroutineScope p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidGetWebViewContainerUseCase$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_3a;
        if (if-ne(label, 1)) goto L_32;
        ResultKt.throwOnFailure(result);
      L_32:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_3a:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        new AndroidGetWebViewContainerUseCase$invoke$webview$1(this, 0);
        L$0 = this;
        L$1 = new IllegalStateException(..);
        label = 1;
        BuildersKt.withContext(mainDispatcher, new AndroidGetWebViewContainerUseCase$invoke$webview$1(..), L$0);
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_56;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_56:
      L_57:
        new AndroidWebViewContainer(BuildersKt.withContext(..), androidWebViewClient, sendWebViewClientErrorDiagnostics, mainDispatcher, defaultDispatcher, new IllegalStateException(..));
        return new AndroidWebViewContainer;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidHandleGatewayAdResponse {
    private final AdPlayerScope adPlayerScope;
    private final AdRepository adRepository;
    private final CampaignRepository campaignRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetAdPlayer getAdPlayer;
    private final HandleInvocationsFromAdViewer getHandleInvocationsFromAdViewer;
    private final GetLatestWebViewConfiguration getLatestWebViewConfiguration;
    private final GetOperativeEventApi getOperativeEventApi;
    private final GetWebViewBridgeUseCase getWebViewBridge;
    private final AndroidGetWebViewContainerUseCase getWebViewContainerUseCase;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public AndroidHandleGatewayAdResponse(AdRepository p0, AndroidGetWebViewContainerUseCase p1, GetWebViewBridgeUseCase p2, DeviceInfoRepository p3, HandleInvocationsFromAdViewer p4, CampaignRepository p5, SendDiagnosticEvent p6, GetOperativeEventApi p7, GetLatestWebViewConfiguration p8, AdPlayerScope p9, GetAdPlayer p10) {
        new Object();
        adRepository = p0;
        getWebViewContainerUseCase = p1;
        getWebViewBridge = p2;
        deviceInfoRepository = p3;
        getHandleInvocationsFromAdViewer = p4;
        campaignRepository = p5;
        sendDiagnosticEvent = p6;
        getOperativeEventApi = p7;
        getLatestWebViewConfiguration = p8;
        adPlayerScope = p9;
        getAdPlayer = p10;
        return;
    }

    public static final Object access$cleanup(AndroidHandleGatewayAdResponse p0, Throwable p1, ByteString p2, AdResponseOuterClass$AdResponse p3, AdPlayer p4, Continuation p5) {
        p0.cleanup(p1, p2, p3, p4, p5);
        return AndroidHandleGatewayAdResponse.cleanup(..);
    }

    public static final CampaignRepository access$getCampaignRepository$p(AndroidHandleGatewayAdResponse p0) {
        return campaignRepository;
    }

    private final Object cleanup(Throwable p0, ByteString p1, AdResponseOuterClass$AdResponse p2, AdPlayer p3, Continuation p4) {
        if (if-eqz(v2)) goto L_17;
        if (if-eqz(label)) goto L_17;
        label = label;
      L_17:
        new AndroidHandleGatewayAdResponse$cleanup$1(this, label);
      L_1c:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_42;
        if (if-eq(label, 1)) goto L_39;
        if (if-ne(label, 2)) goto L_31;
        ResultKt.throwOnFailure(result);
      L_31:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_39:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_42:
        ResultKt.throwOnFailure(L$0);
        OperativeEventRequestOuterClass$OperativeEventErrorData.newBuilder();
        OperativeEventErrorDataKt$Dsl$Companion._create(OperativeEventRequestOuterClass$OperativeEventErrorData.newBuilder(..));
        OperativeEventErrorDataKt$Dsl.setErrorType(OperativeEventRequestOuterClass$OperativeEventErrorType.OPERATIVE_EVENT_ERROR_TYPE_UNSPECIFIED);
        p0.getCause();
        if (if-eqz(Throwable.getCause(..))) goto L_65;
        Throwable.getCause(..).getMessage();
        if (if-nez(Throwable.getMessage(..))) goto L_6d;
      L_65:
        p0.getMessage();
        if (if-nez(Throwable.getMessage(..))) goto L_6d;
      L_6d:
        OperativeEventErrorDataKt$Dsl.setMessage("");
        OperativeEventErrorDataKt$Dsl._build();
        p2.getTrackingToken();
        OperativeEventRequestOuterClass$OperativeEventErrorData.toByteString();
        L$0 = p3;
        label = 1;
        GetOperativeEventApi.invoke$default(getOperativeEventApi, OperativeEventRequestOuterClass$OperativeEventType.OPERATIVE_EVENT_TYPE_LOAD_ERROR, p1, AdResponseOuterClass$AdResponse.getTrackingToken(..), OperativeEventRequestOuterClass$OperativeEventErrorData.toByteString(..), 0, "call to 'resume' before 'invoke' with coroutine", 16, 0);
        if (if-ne(GetOperativeEventApi.invoke$default(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_9f;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_9f:
        if (if-eqz(p3)) goto L_b0;
        L$0 = 0;
        label = 2;
        p3.destroy("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(AdPlayer.destroy(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_ad;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_ad:
        return Unit.INSTANCE;
      L_b0:
        return Unit.INSTANCE;
    }

    public Object invoke(UnityAdsLoadOptions p0, ByteString p1, AdResponseOuterClass$AdResponse p2, Context p3, String p4, DiagnosticEventRequestOuterClass$DiagnosticAdType p5, boolean p6, Continuation p7) {
        if (if-eqz(v3)) goto L_1a;
        if (if-eqz(label)) goto L_1a;
        label = label;
      L_1a:
        new AndroidHandleGatewayAdResponse$invoke$1(this, label);
      L_1f:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
        ResultKt.throwOnFailure(new IllegalStateException(..));
        ResultKt.throwOnFailure(new IllegalStateException(..));
        ResultKt.throwOnFailure(new IllegalStateException(..));
        ResultKt.throwOnFailure(new IllegalStateException(..));
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_ac:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_11b:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        new Ref$ObjectRef();
        p2.hasError();
        if (if-eqz(AdResponseOuterClass$AdResponse.hasError(..))) goto L_14f;
        p2.getError();
        ErrorOuterClass$Error.getErrorText();
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "[UnityAds] Internal communication failure", 0, "gateway", ErrorOuterClass$Error.getErrorText(..), 4, 0);
        return new LoadResult$Failure;
      L_14f:
        p2.getAdData();
        ByteString.isEmpty();
        if (if-eqz(ByteString.isEmpty(..))) goto L_16c;
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.NO_FILL, "[UnityAds] No fill", 0, "no_fill", 0, 20, 0);
        return new LoadResult$Failure;
      L_16c:
        p2.getWebviewConfiguration();
        WebviewConfiguration$WebViewConfiguration.getEntryPoint();
        p2.getWebviewConfiguration();
        WebviewConfiguration$WebViewConfiguration.getVersion();
        Boxing.boxInt(WebviewConfiguration$WebViewConfiguration.getVersion(..));
        p2.getWebviewConfiguration();
        WebviewConfiguration$WebViewConfiguration.getAdditionalFilesList();
        L$0 = IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
        L$1 = p0;
        L$2 = p1;
        L$3 = p2;
        L$4 = p4;
        L$5 = p5;
        L$6 = new Ref$ObjectRef(..);
        Z$0 = p6;
        label = L$7;
        getLatestWebViewConfiguration.invoke(WebviewConfiguration$WebViewConfiguration.getEntryPoint(..), Boxing.boxInt(..), WebviewConfiguration$WebViewConfiguration.getAdditionalFilesList(..), new AndroidHandleGatewayAdResponse$invoke$1(..));
        if (if-ne(GetLatestWebViewConfiguration.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1af;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_1af:
      L_1b2:
        WebViewConfiguration.getEntryPoint();
        CharSequence.length();
        if (if-nez(CharSequence.length(..))) goto L_1c2;
      L_1c2:
      L_1c3:
        if (if-eqz(0)) goto L_1e0;
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "[UnityAds] Internal communication failure", 0, "no_webview_entry_point", 0, 20, 0);
        return new LoadResult$Failure;
      L_1e0:
        SdkProperties.getConfigUrl();
        StringsKt.endsWith$default(SdkProperties.getConfigUrl(..), ".html", 0, 2, 0);
        if (if-eqz(StringsKt.endsWith$default(..))) goto L_1f7;
      L_1f7:
      L_1f8:
        if (if-nez(0)) goto L_206;
        new LoadResult$Failure.getEntryPoint();
      L_206:
        new URI(WebViewConfiguration.getEntryPoint(..));
        new StringBuilder(new LoadResult$Failure);
        new URI(..).getQuery();
        new StringBuilder(..).append(URI.getQuery(..));
        new StringBuilder(..).toString();
        new StringBuilder();
        StringsKt.substringBeforeLast$default(WebViewConfiguration.getEntryPoint(..), "?", 0, 2, 0);
        new StringBuilder(..).append(StringsKt.substringBeforeLast$default(..));
        new StringBuilder(..).append(StringBuilder.toString(..));
        new StringBuilder(..).toString();
        p2.getImpressionConfiguration();
        ByteString.toByteArray();
        Base64.encodeToString(ByteString.toByteArray(..), 2);
        L$0 = IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
        L$1 = p0;
        L$2 = p1;
        L$3 = p2;
        L$4 = p4;
        L$5 = IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
        L$6 = new Ref$ObjectRef(..);
        L$7 = StringBuilder.toString(..);
        L$8 = Base64.encodeToString(..);
        Z$0 = p6;
        label = 2;
        getWebViewContainerUseCase.invoke(adPlayerScope, new AndroidHandleGatewayAdResponse$invoke$1(..));
        if (if-ne(AndroidGetWebViewContainerUseCase.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_262;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_262:
      L_26a:
        getWebViewBridge.invoke(AndroidGetWebViewContainerUseCase.invoke(..), adPlayerScope);
        getAdPlayer.invoke(GetWebViewBridgeUseCase.invoke(..), AndroidGetWebViewContainerUseCase.invoke(..), p1);
        element = GetAdPlayer.invoke(..);
        deviceInfoRepository.getAllowedPii();
        new AndroidHandleGatewayAdResponse$invoke$2(new Ref$ObjectRef(..), 0);
        FlowKt.onEach(DeviceInfoRepository.getAllowedPii(..), new AndroidHandleGatewayAdResponse$invoke$2(..));
        element.getScope();
        FlowKt.launchIn(FlowKt.onEach(..), AdPlayer.getScope(..));
        element.getUpdateCampaignState();
        new AndroidHandleGatewayAdResponse$invoke$3(IntrinsicsKt.getCOROUTINE_SUSPENDED(..), p1, p4, 0);
        FlowKt.onEach(AdPlayer.getUpdateCampaignState(..), new AndroidHandleGatewayAdResponse$invoke$3(..));
        element.getScope();
        FlowKt.launchIn(FlowKt.onEach(..), AdPlayer.getScope(..));
        p2.getTrackingToken();
        if (if-eqz(p6)) goto L_2d3;
      L_2d3:
      L_2d4:
        Boxing.boxBoolean(0);
        new AdObject(p1, p4, AdResponseOuterClass$AdResponse.getTrackingToken(..), element, 0, p0, Boxing.boxBoolean(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..), 16, 0);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_load_started_ad_viewer", 0, 0, 0, new AdObject, 14, 0);
        GetWebViewBridgeUseCase.invoke(..).getOnInvocation();
        p2.getAdData();
        ProtobufExtensionsKt.toBase64$default(AdResponseOuterClass$AdResponse.getAdData(..), 0, 1, 0);
        p2.getAdDataRefreshToken();
        ProtobufExtensionsKt.toBase64$default(AdResponseOuterClass$AdResponse.getAdDataRefreshToken(..), 0, 1, 0);
        new AndroidHandleGatewayAdResponse$invoke$4(AndroidGetWebViewContainerUseCase.invoke(..), StringBuilder.toString(..), 0);
        L$0 = IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
        L$1 = p1;
        L$2 = p2;
        L$3 = new Ref$ObjectRef(..);
        L$4 = new AdObject;
        L$5 = 0;
        L$6 = 0;
        L$7 = 0;
        L$8 = 0;
        label = 3;
        getHandleInvocationsFromAdViewer.invoke(WebViewBridge.getOnInvocation(..), ProtobufExtensionsKt.toBase64$default(..), ProtobufExtensionsKt.toBase64$default(..), Base64.encodeToString(..), new AdObject, new AndroidHandleGatewayAdResponse$invoke$4(..), new AndroidHandleGatewayAdResponse$invoke$1(..));
        if (if-ne(HandleInvocationsFromAdViewer.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_35f;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_35f:
      L_361:
        element.getScope();
        FlowKt.launchIn(HandleInvocationsFromAdViewer.invoke(..), AdPlayer.getScope(..));
        element.getOnLoadEvent();
        L$0 = IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
        L$1 = p1;
        L$2 = p2;
        L$3 = new Ref$ObjectRef(..);
        L$4 = new AdObject;
        label = 4;
        FlowKt.single(AdPlayer.getOnLoadEvent(..), new AndroidHandleGatewayAdResponse$invoke$1(..));
        if (if-ne(FlowKt.single(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_38a;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_38a:
        if (if-eqz(4)) goto L_3e4;
        new AndroidHandleGatewayAdResponse$invoke$5(IntrinsicsKt.getCOROUTINE_SUSPENDED(..), FlowKt.single(..), p1, p2, new Ref$ObjectRef(..), 0);
        L$0 = IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
        L$1 = p1;
        L$2 = p2;
        L$3 = new Ref$ObjectRef(..);
        L$4 = FlowKt.single(..);
        label = 5;
        BuildersKt.withContext(NonCancellable.INSTANCE, new AndroidHandleGatewayAdResponse$invoke$5, new AndroidHandleGatewayAdResponse$invoke$1(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_3be;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_3be:
      L_3bf:
        FlowKt.single(..).getMessage();
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "Internal error", 0, "adviewer", LoadEvent$Error.getMessage(..), 4, 0);
        return new LoadResult$Failure;
      L_3e4:
        campaignRepository.setLoadTimestamp(p1);
        L$0 = IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
        L$1 = p1;
        L$2 = p2;
        L$3 = new Ref$ObjectRef(..);
        L$4 = LoadEvent$Error.getMessage(..);
        label = 6;
        adRepository.addAd(p1, LoadEvent$Error.getMessage(..), new AndroidHandleGatewayAdResponse$invoke$1(..));
        if (if-ne(AdRepository.addAd(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_3ff;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_3ff:
        new LoadResult$Success(LoadEvent$Error.getMessage(..));
        return new LoadResult$Success(..);
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "[UnityAds] Internal communication failure", 0, "invalid_url", p1, 4, 0);
        return new LoadResult$Failure;
      L_430:
      L_43a:
      L_43c:
      L_43f:
      L_440:
        new AndroidHandleGatewayAdResponse$invoke$6(this, new LoadResult$Failure, UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "Internal error", new Ref$ObjectRef(..), 0);
        L$0 = new LoadResult$Failure;
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        L$4 = 0;
        L$5 = 0;
        L$6 = 0;
        L$7 = 0;
        L$8 = 0;
        label = 7;
        BuildersKt.withContext(NonCancellable.INSTANCE, new AndroidHandleGatewayAdResponse$invoke$6, new AndroidHandleGatewayAdResponse$invoke$1(..));
        if (if-ne(BuildersKt.withContext(..), 6)) goto L_477;
        return 6;
      L_477:
        new LoadResult$Failure.getCause();
        if (if-nez(CancellationException.getCause(..))) goto L_480;
      L_480:
        throw new LoadResult$Failure;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHandleGatewayInitializationResponse
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidHandleGatewayInitializationResponse {
    private final CoroutineScope sdkScope;
    private final SessionRepository sessionRepository;
    private final TransactionEventManager transactionEventManager;
    private final TriggerInitializationCompletedRequest triggerInitializationCompletedRequest;

    public AndroidHandleGatewayInitializationResponse(TransactionEventManager p0, TriggerInitializationCompletedRequest p1, SessionRepository p2, CoroutineScope p3) {
        new Object();
        transactionEventManager = p0;
        triggerInitializationCompletedRequest = p1;
        sessionRepository = p2;
        sdkScope = p3;
        return;
    }

    public static final TriggerInitializationCompletedRequest access$getTriggerInitializationCompletedRequest$p(AndroidHandleGatewayInitializationResponse p0) {
        return triggerInitializationCompletedRequest;
    }

    public Object invoke(InitializationResponseOuterClass$InitializationResponse p0, Continuation p1) {
        p0.hasError();
        if (if-nez(InitializationResponseOuterClass$InitializationResponse.hasError(..))) goto L_66;
        p0.getNativeConfiguration();
        sessionRepository.setNativeConfiguration(InitializationResponseOuterClass$InitializationResponse.getNativeConfiguration(..));
        p0.hasUniversalRequestUrl();
        if (if-eqz(InitializationResponseOuterClass$InitializationResponse.hasUniversalRequestUrl(..))) goto L_3c;
        p0.getUniversalRequestUrl();
        if (if-eqz(InitializationResponseOuterClass$InitializationResponse.getUniversalRequestUrl(..))) goto L_2b;
        CharSequence.length();
        if (if-nez(CharSequence.length(..))) goto L_29;
      L_29:
      L_2b:
      L_2c:
        if (if-nez(1)) goto L_3c;
        p0.getUniversalRequestUrl();
        sessionRepository.setGatewayUrl(InitializationResponseOuterClass$InitializationResponse.getUniversalRequestUrl(..));
      L_3c:
        p0.getTriggerInitializationCompletedRequest();
        if (if-eqz(InitializationResponseOuterClass$InitializationResponse.getTriggerInitializationCompletedRequest(..))) goto L_54;
        new AndroidHandleGatewayInitializationResponse$invoke$2(this, 0);
        BuildersKt.launch$default(sdkScope, 0, 0, new AndroidHandleGatewayInitializationResponse$invoke$2(..), 3, 0);
      L_54:
        p0.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getEnableIapEvent();
        if (if-eqz(NativeConfigurationOuterClass$NativeConfiguration.getEnableIapEvent(..))) goto L_63;
        transactionEventManager.invoke();
      L_63:
        return Unit.INSTANCE;
      L_66:
        Unit.INSTANCE.getError();
        ErrorOuterClass$Error.getErrorText();
        Unit.INSTANCE.getError();
        ErrorOuterClass$Error.getErrorText();
        new IllegalStateException(ErrorOuterClass$Error.getErrorText(..));
        Unit.INSTANCE.getError();
        ErrorOuterClass$Error.getErrorText();
        new GatewayException(ErrorOuterClass$Error.getErrorText(..), new IllegalStateException(..), "gateway_initialization", ErrorOuterClass$Error.getErrorText(..));
        throw new GatewayException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHandleGatewayUniversalResponse
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidHandleGatewayUniversalResponse {
    private final DeviceInfoRepository deviceInfoRepository;
    private final SessionRepository sessionRepository;

    public AndroidHandleGatewayUniversalResponse(SessionRepository p0, DeviceInfoRepository p1) {
        new Object();
        sessionRepository = p0;
        deviceInfoRepository = p1;
        return;
    }

    public Object invoke(UniversalResponseOuterClass$UniversalResponse p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidHandleGatewayUniversalResponse$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_52;
        if (if-eq(label, 1)) goto L_46;
        if (if-eq(label, 2)) goto L_39;
        if (if-ne(label, 3)) goto L_31;
        ResultKt.throwOnFailure(result);
      L_31:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_39:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_46:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_52:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        L$1.hasError();
        if (if-nez(UniversalResponseOuterClass$UniversalResponse.hasError(..))) goto L_119;
        L$1.hasMutableData();
        if (if-eqz(UniversalResponseOuterClass$UniversalResponse.hasMutableData(..))) goto L_116;
        L$1.getMutableData();
        deviceInfoRepository.getAllowedPii();
      L_6b:
        MutableStateFlow.getValue();
        MutableDataOuterClass$MutableData.getAllowedPii();
        MutableStateFlow.compareAndSet(MutableStateFlow.getValue(..), MutableDataOuterClass$MutableData.getAllowedPii(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_6b;
        MutableDataOuterClass$MutableData.getCurrentState();
        sessionRepository.setGatewayState(MutableDataOuterClass$MutableData.getCurrentState(..));
        MutableDataOuterClass$MutableData.hasSessionToken();
        if (if-eqz(MutableDataOuterClass$MutableData.hasSessionToken(..))) goto L_a3;
        MutableDataOuterClass$MutableData.getSessionToken();
        sessionRepository.setSessionToken(MutableDataOuterClass$MutableData.getSessionToken(..));
      L_a3:
        MutableDataOuterClass$MutableData.hasPrivacy();
        if (if-eqz(MutableDataOuterClass$MutableData.hasPrivacy(..))) goto L_c1;
        MutableDataOuterClass$MutableData.getPrivacy();
        L$0 = this;
        L$1 = UniversalResponseOuterClass$UniversalResponse.getMutableData(..);
        label = 1;
        sessionRepository.setPrivacy(MutableDataOuterClass$MutableData.getPrivacy(..), new AndroidHandleGatewayUniversalResponse$invoke$1(..));
        if (if-ne(SessionRepository.setPrivacy(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_c1;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_c1:
      L_c2:
        MutableDataOuterClass$MutableData.hasSessionCounters();
        if (if-eqz(MutableDataOuterClass$MutableData.hasSessionCounters(..))) goto L_d6;
        MutableDataOuterClass$MutableData.getSessionCounters();
        sessionRepository.setSessionCounters(MutableDataOuterClass$MutableData.getSessionCounters(..));
      L_d6:
        MutableDataOuterClass$MutableData.hasCache();
        if (if-eqz(MutableDataOuterClass$MutableData.hasCache(..))) goto L_f4;
        MutableDataOuterClass$MutableData.getCache();
        L$0 = this;
        L$1 = UniversalResponseOuterClass$UniversalResponse.getMutableData(..);
        label = 2;
        sessionRepository.setGatewayCache(MutableDataOuterClass$MutableData.getCache(..), new AndroidHandleGatewayUniversalResponse$invoke$1(..));
        if (if-ne(SessionRepository.setGatewayCache(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_f4;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_f4:
        MutableDataOuterClass$MutableData.hasPrivacyFsm();
        if (if-eqz(MutableDataOuterClass$MutableData.hasPrivacyFsm(..))) goto L_116;
        MutableDataOuterClass$MutableData.getPrivacyFsm();
        L$0 = 0;
        L$1 = 0;
        label = 3;
        sessionRepository.setPrivacyFsm(MutableDataOuterClass$MutableData.getPrivacyFsm(..), new AndroidHandleGatewayUniversalResponse$invoke$1(..));
        if (if-ne(SessionRepository.setPrivacyFsm(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_113;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_113:
        return Unit.INSTANCE;
      L_116:
        return Unit.INSTANCE;
      L_119:
        sessionRepository.setShouldInitialize(0);
        Unit.INSTANCE.getError();
        ErrorOuterClass$Error.getErrorText();
        Unit.INSTANCE.getError();
        ErrorOuterClass$Error.getErrorText();
        new IllegalStateException(ErrorOuterClass$Error.getErrorText(..));
        Unit.INSTANCE.getError();
        ErrorOuterClass$Error.getErrorText();
        new GatewayException(ErrorOuterClass$Error.getErrorText(..), new IllegalStateException(..), "gateway_universal", ErrorOuterClass$Error.getErrorText(..));
        throw new GatewayException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHandleOpenUrl
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidHandleOpenUrl {
    private final Context context;

    public AndroidHandleOpenUrl(Context p0) {
        new Object();
        context = p0;
        return;
    }

    public void invoke(String p0, String p1) {
        new Intent();
        if (if-eqz(p1)) goto L_1c;
        p1.length();
        if (if-lez(CharSequence.length(..))) goto L_18;
      L_18:
      L_19:
        if (if-eqz(0)) goto L_1c;
      L_1c:
      L_1d:
        new Intent(..).setPackage(0);
        new Intent(..).setAction("android.intent.action.VIEW");
        Uri.parse(p0);
        new Intent(..).setData(Uri.parse(..));
        new Intent(..).setFlags(0x10000000);
        context.startActivity(new Intent(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHttpClientProvider
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidHttpClientProvider {
    private final AlternativeFlowReader alternativeFlowReader;
    private final ConfigFileFromLocalStorage configFileFromLocalStorage;
    private final Context context;
    private final CronetEngineBuilderFactory cronetEngineBuilderFactory;
    private final ISDKDispatchers dispatchers;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public AndroidHttpClientProvider(ConfigFileFromLocalStorage p0, AlternativeFlowReader p1, ISDKDispatchers p2, SendDiagnosticEvent p3, Context p4, CronetEngineBuilderFactory p5) {
        new Object();
        configFileFromLocalStorage = p0;
        alternativeFlowReader = p1;
        dispatchers = p2;
        sendDiagnosticEvent = p3;
        context = p4;
        cronetEngineBuilderFactory = p5;
        return;
    }

    public static final String access$buildCronetCachePath(AndroidHttpClientProvider p0, Context p1) {
        p0.buildCronetCachePath(p1);
        return AndroidHttpClientProvider.buildCronetCachePath(..);
    }

    public static final Object access$buildNetworkClient(AndroidHttpClientProvider p0, Context p1, ISDKDispatchers p2, Continuation p3) {
        p0.buildNetworkClient(p1, p2, p3);
        return AndroidHttpClientProvider.buildNetworkClient(..);
    }

    public static final ConfigFileFromLocalStorage access$getConfigFileFromLocalStorage$p(AndroidHttpClientProvider p0) {
        return configFileFromLocalStorage;
    }

    public static final Context access$getContext$p(AndroidHttpClientProvider p0) {
        return context;
    }

    public static final CronetEngineBuilderFactory access$getCronetEngineBuilderFactory$p(AndroidHttpClientProvider p0) {
        return cronetEngineBuilderFactory;
    }

    public static final ISDKDispatchers access$getDispatchers$p(AndroidHttpClientProvider p0) {
        return dispatchers;
    }

    private final String buildCronetCachePath(Context p0) {
        p0.getFilesDir();
        FilesKt.resolve(Context.getFilesDir(..), "UnityAdsHttpCache");
        FilesKt.resolve(..).exists();
        if (if-nez(File.exists(..))) goto L_18;
        FilesKt.resolve(..).mkdirs();
      L_18:
        FilesKt.resolve(..).getAbsolutePath();
        return File.getAbsolutePath(..);
    }

    private final Object buildNetworkClient(Context p0, ISDKDispatchers p1, Continuation p2) {
        IntrinsicsKt.intercepted(p2);
        new CancellableContinuationImpl(IntrinsicsKt.intercepted(..), 1);
        new CancellableContinuationImpl(..).initCancellability();
        CronetProviderInstaller.installProvider(p0);
        new AndroidHttpClientProvider$buildNetworkClient$2$1(this, p0, new CancellableContinuationImpl(..), p1);
        Task.addOnCompleteListener(new AndroidHttpClientProvider$buildNetworkClient$2$1(..));
        new CancellableContinuationImpl(..).getResult();
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(CancellableContinuationImpl.getResult(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_2b;
        DebugProbesKt.probeCoroutineSuspended(p2);
      L_2b:
        return CancellableContinuationImpl.getResult(..);
    }

    public Object invoke(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidHttpClientProvider$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_38;
        if (if-ne(label, 1)) goto L_30;
        ResultKt.throwOnFailure(result);
      L_30:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_38:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        alternativeFlowReader.invoke();
        if (if-eqz(AlternativeFlowReader.invoke(..))) goto L_96;
        TimeSource$Monotonic.INSTANCE.markNow-z9LOYto();
        new AndroidHttpClientProvider$invoke$client$1(this, 0);
        L$0 = this;
        J$0 = TimeSource$Monotonic.markNow-z9LOYto(..);
        label = 1;
        TimeoutKt.withTimeoutOrNull(500L, 1, new AndroidHttpClientProvider$invoke$client$1(..), "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(TimeoutKt.withTimeoutOrNull(..), J$0)) goto L_60;
        return J$0;
      L_60:
      L_62:
        if (if-nez(TimeoutKt.withTimeoutOrNull(..))) goto L_69;
      L_69:
      L_6b:
        TimeSource$Monotonic$ValueTimeMark.elapsedNow-UwyO8pc(TimeSource$Monotonic.markNow-z9LOYto(..), 500L);
        Duration.toDouble-impl(TimeSource$Monotonic$ValueTimeMark.elapsedNow-UwyO8pc(..), 500L, DurationUnit.MILLISECONDS);
        Boxing.boxDouble(Duration.toDouble-impl(..), 500L);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_cronet_success_time", Boxing.boxDouble(..), 0, 0, 0, 28, 0);
        if (if-nez(TimeoutKt.withTimeoutOrNull(..))) goto L_ce;
        new OkHttpClient();
        new OkHttp3Client(dispatchers, new OkHttpClient(..));
      L_96:
        new AndroidHttpClientProvider$invoke$config$1(this, 500L);
        BuildersKt.runBlocking$default(500L, new AndroidHttpClientProvider$invoke$config$1(..), DurationUnit.MILLISECONDS, 500L);
        if (if-eqz(BuildersKt.runBlocking$default(..))) goto L_b3;
        BuildersKt.runBlocking$default(..).getExperiments();
        if (if-eqz(Configuration.getExperiments(..))) goto L_b3;
        Configuration.getExperiments(..).isOkHttpEnabled();
        if (if-ne(IExperiments.isOkHttpEnabled(..), DurationUnit.MILLISECONDS)) goto L_b3;
      L_b3:
      L_b4:
        if (if-eqz(0)) goto L_c5;
        new OkHttpClient();
        new OkHttp3Client(dispatchers, new OkHttpClient(..));
      L_c5:
        new LegacyHttpClient(dispatchers);
      L_ce:
        return new LegacyHttpClient(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidInitializeBoldSDK
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidInitializeBoldSDK {
    public static final AndroidInitializeBoldSDK$Companion Companion = null;
    public static final String MSG_GATEWAY_DENIED = "Gateway communication failure";
    public static final String MSG_NETWORK = "Network";
    public static final String MSG_TIMEOUT = "Timeout";
    public static final String MSG_UNKNOWN = "Initialization failure";
    private final ClearCache clearCache;
    private final CoroutineDispatcher defaultDispatcher;
    private final DiagnosticEventRepository diagnosticEventRepository;
    private final EventObservers eventObservers;
    private final GatewayClient gatewayClient;
    private final GetInitializationRequest getInitializeRequest;
    private final GetRequestPolicy getRequestPolicy;
    private final HandleGatewayInitializationResponse handleGatewayInitializationResponse;
    private final InitializeOMSDK initializeOM;
    private final ConfigurationReader legacyConfigurationReader;
    private final SDKPropertiesManager sdkPropertiesManager;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private final StorageManager storageManager;
    private final TriggerInitializeListener triggerInitializeListener;

    static <clinit>() {
        new AndroidInitializeBoldSDK$Companion(0);
        Companion = new AndroidInitializeBoldSDK$Companion(..);
        return;
    }

    public AndroidInitializeBoldSDK(CoroutineDispatcher p0, InitializeOMSDK p1, GetInitializationRequest p2, GetRequestPolicy p3, ClearCache p4, HandleGatewayInitializationResponse p5, GatewayClient p6, SessionRepository p7, EventObservers p8, TriggerInitializeListener p9, SendDiagnosticEvent p10, DiagnosticEventRepository p11, StorageManager p12, ConfigurationReader p13, SDKPropertiesManager p14) {
        new Object();
        defaultDispatcher = p0;
        initializeOM = p1;
        getInitializeRequest = p2;
        getRequestPolicy = p3;
        clearCache = p4;
        handleGatewayInitializationResponse = p5;
        gatewayClient = p6;
        sessionRepository = p7;
        eventObservers = p8;
        triggerInitializeListener = p9;
        sendDiagnosticEvent = p10;
        diagnosticEventRepository = p11;
        storageManager = p12;
        legacyConfigurationReader = p13;
        sdkPropertiesManager = p14;
        return;
    }

    public static final void access$checkCanInitialize(AndroidInitializeBoldSDK p0) {
        p0.checkCanInitialize();
        return;
    }

    public static final GatewayClient access$getGatewayClient$p(AndroidInitializeBoldSDK p0) {
        return gatewayClient;
    }

    public static final GetInitializationRequest access$getGetInitializeRequest$p(AndroidInitializeBoldSDK p0) {
        return getInitializeRequest;
    }

    public static final GetRequestPolicy access$getGetRequestPolicy$p(AndroidInitializeBoldSDK p0) {
        return getRequestPolicy;
    }

    public static final HandleGatewayInitializationResponse access$getHandleGatewayInitializationResponse$p(AndroidInitializeBoldSDK p0) {
        return handleGatewayInitializationResponse;
    }

    public static final void access$initializationFailure(AndroidInitializeBoldSDK p0, TimeMark p1, InitializationException p2) {
        p0.initializationFailure(p1, p2);
        return;
    }

    public static final Object access$initializationStart(AndroidInitializeBoldSDK p0, Continuation p1) {
        p0.initializationStart(p1);
        return AndroidInitializeBoldSDK.initializationStart(..);
    }

    public static final Object access$initializationSuccess(AndroidInitializeBoldSDK p0, TimeMark p1, Continuation p2) {
        p0.initializationSuccess(p1, p2);
        return AndroidInitializeBoldSDK.initializationSuccess(..);
    }

    private final void checkCanInitialize() {
        sessionRepository.getShouldInitialize();
        if (if-eqz(SessionRepository.getShouldInitialize(..))) goto L_9;
        return;
      L_9:
        new InitializationException("Gateway communication failure", 0, "gateway", "!sessionRepository.shouldInitialize", 2, 0);
        throw new InitializationException;
    }

    private final Map getTags(InitializationException p0) {
        MapsKt.createMapBuilder();
        OperationType.INITIALIZATION.toString();
        MapsKt.createMapBuilder(..).put("operation", OperationType.toString(..));
        p0.getReason();
        MapsKt.createMapBuilder(..).put("reason", InitializationException.getReason(..));
        p0.getReasonDebug();
        if (if-eqz(InitializationException.getReasonDebug(..))) goto L_27;
        p0.getReasonDebug();
        MapsKt.createMapBuilder(..).put("reason_debug", InitializationException.getReasonDebug(..));
      L_27:
        MapsKt.build(MapsKt.createMapBuilder(..));
        return MapsKt.build(..);
    }

    private final void initializationFailure(TimeMark p0, InitializationException p1) {
        new StringBuilder("Unity Ads Initialization Failure: ");
        p1.getMessage();
        new StringBuilder(..).append(InitializationException.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        TimeExtensionsKt.elapsedMillis(p0);
        Double.valueOf(TimeExtensionsKt.elapsedMillis(..), v4);
        AndroidInitializeBoldSDK.getTags(p1);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_initialize_task_failure_time", Double.valueOf(..), AndroidInitializeBoldSDK.getTags(..), 0, 0, 24, 0);
        sessionRepository.setInitializationState(InitializationState.FAILED);
        sdkPropertiesManager.setInitialized(0);
        p1.getMessage();
        triggerInitializeListener.error(UnityAds$UnityAdsInitializationError.INTERNAL_ERROR, InitializationException.getMessage(..));
        AndroidInitializeBoldSDK.setupDiagnosticEvents();
        return;
    }

    private final Object initializationStart(Continuation p0) {
        DeviceLog.debug("Unity Ads Initialization Start");
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_initialization_started", 0, 0, 0, 0, 30, 0);
        sessionRepository.setInitializationState(InitializationState.INITIALIZING);
        eventObservers.invoke(p0);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(EventObservers.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_27;
        return EventObservers.invoke(..);
      L_27:
        return Unit.INSTANCE;
    }

    private final Object initializationSuccess(TimeMark p0, Continuation p1) {
        if (if-eqz(v2)) goto L_18;
        if (if-eqz(label)) goto L_18;
        label = label;
      L_18:
        new AndroidInitializeBoldSDK$initializationSuccess$1(this, label);
      L_1d:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_50;
        if (if-eq(label, 1)) goto L_48;
        if (if-eq(label, 2)) goto L_40;
        if (if-ne(label, 3)) goto L_38;
        ResultKt.throwOnFailure(result);
      L_38:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_40:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_48:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_50:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        DeviceLog.debug("Unity Ads Initialization Success");
        TimeExtensionsKt.elapsedMillis(p0);
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), v11);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_initialize_task_success_time", Boxing.boxDouble(..), 0, 0, 0, 28, 0);
        storageManager.hasInitialized();
        L$0 = this;
        label = 1;
        initializeOM.invoke("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(InitializeOMSDK.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_7f;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_7f:
      L_80:
        L$0 = this;
        label = 2;
        clearCache.invoke("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(ClearCache.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_8d;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_8d:
        L$0 = this;
        label = 3;
        sessionRepository.persistNativeConfiguration("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(SessionRepository.persistNativeConfiguration(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_9a;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_9a:
      L_9b:
        legacyConfigurationReader.getCurrentConfiguration();
        Configuration.deleteFromDisk();
        sessionRepository.setInitializationState(InitializationState.INITIALIZED);
        sdkPropertiesManager.setInitialized(1);
        triggerInitializeListener.success();
        AndroidInitializeBoldSDK.setupDiagnosticEvents();
        return Unit.INSTANCE;
    }

    private final void setupDiagnosticEvents() {
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getDiagnosticEvents();
        diagnosticEventRepository.configure(NativeConfigurationOuterClass$NativeConfiguration.getDiagnosticEvents(..));
        return;
    }

    public Object invoke(Continuation p0) {
        new AndroidInitializeBoldSDK$invoke$2(this, 0);
        BuildersKt.withContext(defaultDispatcher, new AndroidInitializeBoldSDK$invoke$2(..), p0);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_17;
        return BuildersKt.withContext(..);
      L_17:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidLoad
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidLoad {
    private final AdRepository adRepository;
    private final CoroutineDispatcher defaultDispatcher;
    private final GatewayClient gatewayClient;
    private final GetAdPlayerConfigRequest getAdPlayerConfigRequest;
    private final GetAdRequest getAdRequest;
    private final GetRequestPolicy getRequestPolicy;
    private final HandleGatewayAdResponse handleGatewayAdResponse;
    private final SessionRepository sessionRepository;

    public AndroidLoad(CoroutineDispatcher p0, GetAdRequest p1, GetAdPlayerConfigRequest p2, GetRequestPolicy p3, HandleGatewayAdResponse p4, SessionRepository p5, GatewayClient p6, AdRepository p7) {
        new Object();
        defaultDispatcher = p0;
        getAdRequest = p1;
        getAdPlayerConfigRequest = p2;
        getRequestPolicy = p3;
        handleGatewayAdResponse = p4;
        sessionRepository = p5;
        gatewayClient = p6;
        adRepository = p7;
        return;
    }

    public static final AdRepository access$getAdRepository$p(AndroidLoad p0) {
        return adRepository;
    }

    public static final GatewayClient access$getGatewayClient$p(AndroidLoad p0) {
        return gatewayClient;
    }

    public static final GetAdPlayerConfigRequest access$getGetAdPlayerConfigRequest$p(AndroidLoad p0) {
        return getAdPlayerConfigRequest;
    }

    public static final GetAdRequest access$getGetAdRequest$p(AndroidLoad p0) {
        return getAdRequest;
    }

    public static final GetRequestPolicy access$getGetRequestPolicy$p(AndroidLoad p0) {
        return getRequestPolicy;
    }

    public static final HandleGatewayAdResponse access$getHandleGatewayAdResponse$p(AndroidLoad p0) {
        return handleGatewayAdResponse;
    }

    public static final SessionRepository access$getSessionRepository$p(AndroidLoad p0) {
        return sessionRepository;
    }

    public static final void access$incrementLoadRequestAdmCount(AndroidLoad p0, boolean p1) {
        p0.incrementLoadRequestAdmCount(p1);
        return;
    }

    public static final void access$incrementLoadRequestCount(AndroidLoad p0, boolean p1) {
        p0.incrementLoadRequestCount(p1);
        return;
    }

    private final void incrementLoadRequestAdmCount(boolean p0) {
        if (if-eqz(p0)) goto L_8;
        sessionRepository.incrementBannerLoadRequestAdmCount();
      L_8:
        sessionRepository.incrementLoadRequestAdmCount();
      L_d:
        return;
    }

    private final void incrementLoadRequestCount(boolean p0) {
        if (if-eqz(p0)) goto L_8;
        sessionRepository.incrementBannerLoadRequestCount();
      L_8:
        sessionRepository.incrementLoadRequestCount();
      L_d:
        return;
    }

    public Object invoke(Context p0, String p1, ByteString p2, HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup p3, AdRequestOuterClass$BannerSize p4, UnityAdsLoadOptions p5, Continuation p6) {
        new AndroidLoad$invoke$2(this, p4, p3, p1, p2, p5, p0, 0);
        BuildersKt.withContext(defaultDispatcher, new AndroidLoad$invoke$2, p6);
        return BuildersKt.withContext(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidRefresh
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidRefresh {
    private final CoroutineDispatcher defaultDispatcher;
    private final GatewayClient gatewayClient;
    private final GetAdDataRefreshRequest getAdDataRefreshRequest;
    private final GetRequestPolicy getRequestPolicy;

    public AndroidRefresh(CoroutineDispatcher p0, GetAdDataRefreshRequest p1, GetRequestPolicy p2, GatewayClient p3) {
        new Object();
        defaultDispatcher = p0;
        getAdDataRefreshRequest = p1;
        getRequestPolicy = p2;
        gatewayClient = p3;
        return;
    }

    public static final GatewayClient access$getGatewayClient$p(AndroidRefresh p0) {
        return gatewayClient;
    }

    public static final GetAdDataRefreshRequest access$getGetAdDataRefreshRequest$p(AndroidRefresh p0) {
        return getAdDataRefreshRequest;
    }

    public static final GetRequestPolicy access$getGetRequestPolicy$p(AndroidRefresh p0) {
        return getRequestPolicy;
    }

    public Object invoke(ByteString p0, ByteString p1, Continuation p2) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidRefresh$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure(result);
        new AndroidRefresh$invoke$2(this, "call to 'resume' before 'invoke' with coroutine", new IllegalStateException(..), 0);
        label = 1;
        BuildersKt.withContext(defaultDispatcher, new AndroidRefresh$invoke$2(..), new AndroidRefresh$invoke$1(..));
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4a;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4a:
        return BuildersKt.withContext(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidRemoveUrlQuery
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidRemoveUrlQuery {
    public AndroidRemoveUrlQuery() {
        new Object();
        return;
    }

    public String invoke(String p0) {
        Uri.parse(p0);
        Uri.parse(..).buildUpon();
        Uri.buildUpon(..).clearQuery();
        Uri$Builder.clearQuery(..).build();
        Uri$Builder.build(..).toString();
        return Uri.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidSendDiagnosticEvent
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidSendDiagnosticEvent {
    private final DiagnosticEventRepository diagnosticEventRepository;
    private final GetDiagnosticEventRequest getDiagnosticEventRequest;

    public AndroidSendDiagnosticEvent(DiagnosticEventRepository p0, GetDiagnosticEventRequest p1) {
        new Object();
        diagnosticEventRepository = p0;
        getDiagnosticEventRequest = p1;
        return;
    }

    public void invoke(String p0, Double p1, Map p2, Map p3, AdObject p4) {
        if (if-eqz(p4)) goto L_10;
        p4.isHeaderBidding();
      L_10:
      L_11:
        if (if-eqz(p4)) goto L_19;
        p4.getOpportunityId();
      L_19:
      L_1a:
        if (if-eqz(p4)) goto L_22;
        p4.getPlacementId();
      L_22:
      L_23:
        if (if-eqz(p4)) goto L_29;
        p4.getAdType();
      L_29:
        getDiagnosticEventRequest.invoke(p0, p2, p3, p1, 0, 0, 0, AdObject.getAdType(..));
        diagnosticEventRepository.addDiagnosticEvent(GetDiagnosticEventRequest.invoke(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidSendWebViewClientErrorDiagnostics
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidSendWebViewClientErrorDiagnostics {
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public AndroidSendWebViewClientErrorDiagnostics(SendDiagnosticEvent p0) {
        new Object();
        sendDiagnosticEvent = p0;
        return;
    }

    public void invoke(List p0) {
        p0.iterator();
      L_b:
        Iterable.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_74;
        Iterable.iterator(..).next();
        Iterator.next(..).getUrl();
        if (if-eqz(WebViewClientError.getUrl(..))) goto L_2a;
        WebViewClientError.getUrl(..).length();
        if (if-nez(CharSequence.length(..))) goto L_28;
      L_28:
      L_2a:
      L_2b:
        if (if-nez(1)) goto L_3c;
        Iterator.next(..).getUrl();
        TuplesKt.to("webview_url", WebViewClientError.getUrl(..));
        MapsKt.mapOf(TuplesKt.to(..));
      L_3c:
      L_3d:
        Iterator.next(..).getReason();
        WebViewClientError.getReason(..).getCode();
        Integer.valueOf(ErrorReason.getCode(..));
        TuplesKt.to("reason", Integer.valueOf(..));
        MapsKt.mutableMapOf(0);
        Iterator.next(..).getStatusCode();
        if (if-eqz(WebViewClientError.getStatusCode(..))) goto L_67;
        Iterator.next(..).getStatusCode();
        MapsKt.mutableMapOf(..).put("webview_error_code", WebViewClientError.getStatusCode(..));
      L_67:
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "webview_error", 0, 0, MapsKt.mutableMapOf(..), 0, 18, 0);
      L_74:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidShow
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidShow {
    private final AdRepository adRepository;
    private final GameServerIdReader gameServerIdReader;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public AndroidShow(AdRepository p0, GameServerIdReader p1, SendDiagnosticEvent p2) {
        new Object();
        adRepository = p0;
        gameServerIdReader = p1;
        sendDiagnosticEvent = p2;
        return;
    }

    public static final AdRepository access$getAdRepository$p(AndroidShow p0) {
        return adRepository;
    }

    public static final GameServerIdReader access$getGameServerIdReader$p(AndroidShow p0) {
        return gameServerIdReader;
    }

    public static final SendDiagnosticEvent access$getSendDiagnosticEvent$p(AndroidShow p0) {
        return sendDiagnosticEvent;
    }

    public Flow invoke(Context p0, AdObject p1, UnityAdsShowOptions p2) {
        new AndroidShow$invoke$1(p1, this, p0, p2, 0);
        FlowKt.flow(new AndroidShow$invoke$1);
        return FlowKt.flow(..);
    }

    public Object terminate(AdObject p0, Continuation p1) {
        p0.getAdPlayer();
        if (if-eqz(AdObject.getAdPlayer(..))) goto L_14;
        AdObject.getAdPlayer(..).destroy(p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(AdPlayer.destroy(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_11;
        return AdPlayer.destroy(..);
      L_11:
        return Unit.INSTANCE;
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidTriggerInitializationCompletedRequest
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidTriggerInitializationCompletedRequest {
    private final GatewayClient gatewayClient;
    private final GetInitializationCompletedRequest getInitializationCompletedRequest;
    private final GetRequestPolicy getRequestPolicy;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public AndroidTriggerInitializationCompletedRequest(GetInitializationCompletedRequest p0, GetRequestPolicy p1, GatewayClient p2, SendDiagnosticEvent p3) {
        new Object();
        getInitializationCompletedRequest = p0;
        getRequestPolicy = p1;
        gatewayClient = p2;
        sendDiagnosticEvent = p3;
        return;
    }

    public Object invoke(Continuation p0) {
        if (if-eqz(v2)) goto L_18;
        if (if-eqz(label)) goto L_18;
        label = label;
      L_18:
        new AndroidTriggerInitializationCompletedRequest$invoke$1(this, label);
      L_1d:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_63;
        if (if-eq(label, 1)) goto L_4f;
        if (if-ne(label, 2)) goto L_47;
        ResultKt.throwOnFailure(result);
      L_47:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_4f:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_58:
      L_5d:
      L_63:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        TimeSource$Monotonic.INSTANCE.markNow-z9LOYto();
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_initialization_completed_started", 0, 0, 0, 0, 30, 0);
        L$0 = this;
        J$0 = TimeSource$Monotonic.markNow-z9LOYto(..);
        label = 1;
        getInitializationCompletedRequest.invoke(new AndroidTriggerInitializationCompletedRequest$invoke$1(..));
        if (if-ne(GetInitializationCompletedRequest.invoke(..), J$0)) goto L_90;
        return J$0;
      L_90:
      L_92:
        getRequestPolicy.invoke();
        L$0 = this;
        J$0 = J$0;
        label = 2;
        GatewayClient$DefaultImpls.request$default(gatewayClient, 0, GetInitializationCompletedRequest.invoke(..), GetRequestPolicy.invoke(..), OperationType.INITIALIZATION_COMPLETED, new AndroidTriggerInitializationCompletedRequest$invoke$1(..), 1, 0);
        if (if-ne(GatewayClient$DefaultImpls.request$default(..), J$0)) goto L_c1;
        return J$0;
      L_c1:
      L_c5:
        UniversalResponseOuterClass$UniversalResponse.hasError();
        if (if-eqz(UniversalResponseOuterClass$UniversalResponse.hasError(..))) goto L_171;
        TimeSource$Monotonic$ValueTimeMark.box-impl(J$0, gatewayClient);
        TimeExtensionsKt.elapsedMillis(TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), OperationType.INITIALIZATION_COMPLETED);
        OperationType.toString();
        TuplesKt.to("operation", OperationType.toString(..));
        TuplesKt.to("reason", "gateway");
        UniversalResponseOuterClass$UniversalResponse.getError();
        ErrorOuterClass$Error.getErrorText();
        TuplesKt.to("reason_debug", ErrorOuterClass$Error.getErrorText(..));
        MapsKt.mapOf(TimeExtensionsKt.elapsedMillis(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_initialize_completed_task_failure_time", Boxing.boxDouble(..), MapsKt.mapOf(..), 0, 0, 24, 0);
      L_120:
      L_12c:
        TimeSource$Monotonic$ValueTimeMark.box-impl(gatewayClient, gatewayClient);
        TimeExtensionsKt.elapsedMillis(TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), TuplesKt.to(..));
        OperationType.toString();
        TuplesKt.to("operation", OperationType.toString(..));
        TuplesKt.to("reason", "uncaught_exception");
        TuplesKt.to(..).getMessage();
        if (if-nez(Exception.getMessage(..))) goto L_15a;
      L_15a:
        TuplesKt.to("reason_debug", "unknown");
        MapsKt.mapOf(TimeExtensionsKt.elapsedMillis(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_initialize_completed_task_failure_time", Boxing.boxDouble(..), MapsKt.mapOf(..), 0, 0, 24, 0);
      L_171:
        TimeSource$Monotonic$ValueTimeMark.box-impl(gatewayClient, gatewayClient);
        TimeExtensionsKt.elapsedMillis(TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), gatewayClient);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_initialize_completed_task_success_time", Boxing.boxDouble(..), 0, 0, 0, 28, 0);
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AwaitInitialization
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class AwaitInitialization {
    public abstract Object invoke(long p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.BuildHeaderBiddingToken
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class BuildHeaderBiddingToken {
    public abstract Object invoke(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CacheFile
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class CacheFile {
    public abstract Object invoke(String p0, AdObject p1, JSONArray p2, int p3, Continuation p4) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.ClearCache
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class ClearCache {
    public abstract Object invoke(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonAwaitInitialization
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonAwaitInitialization {
    private final SessionRepository sessionRepository;

    public CommonAwaitInitialization(SessionRepository p0) {
        new Object();
        sessionRepository = p0;
        return;
    }

    public static final SessionRepository access$getSessionRepository$p(CommonAwaitInitialization p0) {
        return sessionRepository;
    }

    public Object invoke(long p0, Continuation p1) {
        new CommonAwaitInitialization$invoke$2(this, 0);
        TimeoutKt.withTimeoutOrNull(p0, v4, new CommonAwaitInitialization$invoke$2(..), p1);
        return TimeoutKt.withTimeoutOrNull(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonCacheFile
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonCacheFile {
    private final CacheRepository cacheRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public CommonCacheFile(CacheRepository p0, SendDiagnosticEvent p1) {
        new Object();
        cacheRepository = p0;
        sendDiagnosticEvent = p1;
        return;
    }

    public Object invoke(String p0, AdObject p1, JSONArray p2, int p3, Continuation p4) {
        if (if-eqz(v2)) goto L_18;
        if (if-eqz(label)) goto L_18;
        label = label;
      L_18:
        new CommonCacheFile$invoke$1(this, label);
      L_1d:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_49;
        if (if-ne(label, 1)) goto L_41;
        ResultKt.throwOnFailure(result);
      L_41:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_49:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        TimeSource$Monotonic.INSTANCE.markNow-z9LOYto();
        p1.getOpportunityId();
        ProtobufExtensionsKt.toISO8859String(AdObject.getOpportunityId(..));
        L$0 = this;
        L$1 = p0;
        L$2 = p1;
        J$0 = TimeSource$Monotonic.markNow-z9LOYto(..);
        label = 1;
        cacheRepository.getFile(p0, ProtobufExtensionsKt.toISO8859String(..), p2, p3, new CommonCacheFile$invoke$1(..));
        if (if-ne(CacheRepository.getFile(..), "call to 'resume' before 'invoke' with coroutine")) goto L_77;
        return "call to 'resume' before 'invoke' with coroutine";
      L_77:
      L_79:
        if (if-eqz("call to 'resume' before 'invoke' with coroutine")) goto L_e7;
        TimeSource$Monotonic$ValueTimeMark.box-impl(TimeSource$Monotonic.markNow-z9LOYto(..), v11);
        TimeExtensionsKt.elapsedMillis(TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), v11);
        CacheRepository.getFile(..).getSource();
        CacheResult$Success.getSource(..).toString();
        TuplesKt.to("cache_source", CacheSource.toString(..));
        TuplesKt.to("url", p0);
        CacheRepository.getFile(..).getCachedFile();
        CachedFile.getProtocol();
        TuplesKt.to("protocol", CachedFile.getProtocol(..));
        MapsKt.mapOf(v11);
        CacheRepository.getFile(..).getCachedFile();
        CachedFile.getContentLength();
        Boxing.boxInt(1024);
        TuplesKt.to("size_kb", Boxing.boxInt(..));
        MapsKt.mapOf(TuplesKt.to(..));
        sendDiagnosticEvent.invoke("native_load_cache_success_time", Boxing.boxDouble(..), MapsKt.mapOf(..), MapsKt.mapOf(..), p1);
      L_e7:
        if (if-eqz(sendDiagnosticEvent)) goto L_134;
        TimeSource$Monotonic$ValueTimeMark.box-impl(Boxing.boxDouble(..), v11);
        TimeExtensionsKt.elapsedMillis(TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), v11);
        CacheRepository.getFile(..).getSource();
        CacheResult$Failure.getSource(..).toString();
        TuplesKt.to(MapsKt.mapOf(..), CacheSource.toString(..));
        TuplesKt.to(Boxing.boxDouble(..), MapsKt.mapOf(..));
        CacheRepository.getFile(..).getError();
        CacheResult$Failure.getError(..).toString();
        TuplesKt.to("reason", CacheError.toString(..));
        MapsKt.mapOf(TimeExtensionsKt.elapsedMillis(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_load_cache_failure_time", Boxing.boxDouble(..), MapsKt.mapOf(..), 0, p1, 8, 0);
      L_134:
        return CacheRepository.getFile(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonClearCache
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonClearCache {
    private final CacheRepository cacheRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public CommonClearCache(CacheRepository p0, SendDiagnosticEvent p1) {
        new Object();
        cacheRepository = p0;
        sendDiagnosticEvent = p1;
        return;
    }

    public Object invoke(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new CommonClearCache$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_47;
        if (if-eq(label, 1)) goto L_3d;
        if (if-ne(label, 2)) goto L_35;
        ResultKt.throwOnFailure(result);
      L_35:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_3d:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_47:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        TimeSource$Monotonic.INSTANCE.markNow-z9LOYto();
        L$0 = this;
        J$0 = TimeSource$Monotonic.markNow-z9LOYto(..);
        label = J$0;
        cacheRepository.getCacheSize("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(CacheRepository.getCacheSize(..), J$1)) goto L_5f;
        return J$1;
      L_5f:
      L_61:
        CacheRepository.getCacheSize(..).longValue();
        L$0 = this;
        J$0 = TimeSource$Monotonic.markNow-z9LOYto(..);
        J$1 = Number.longValue(..);
        label = J$0;
        cacheRepository.clearCache("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(CacheRepository.clearCache(..), J$1)) goto L_78;
        return J$1;
      L_78:
      L_7b:
        TimeSource$Monotonic$ValueTimeMark.box-impl(TimeSource$Monotonic.markNow-z9LOYto(..), TimeSource$Monotonic.markNow-z9LOYto(..));
        TimeExtensionsKt.elapsedMillis(TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), TimeSource$Monotonic.markNow-z9LOYto(..));
        Boxing.boxInt(1024);
        TuplesKt.to("size_kb", Boxing.boxInt(..));
        MapsKt.mapOf(TuplesKt.to(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_initialize_clear_cache_time", Boxing.boxDouble(..), 0, MapsKt.mapOf(..), 0, 20, 0);
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonCreateFile
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonCreateFile {
    public CommonCreateFile() {
        new Object();
        return;
    }

    public File invoke(File p0, String p1) {
        new File(p0, p1);
        return new File(..);
    }

    public File invoke(String p0) {
        new File(p0);
        return new File(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonGetAdObject
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonGetAdObject {
    private final AdRepository adRepository;

    public CommonGetAdObject(AdRepository p0) {
        new Object();
        adRepository = p0;
        return;
    }

    public Object invoke(String p0, Continuation p1) {
        ProtobufExtensionsKt.toISO8859ByteString(p0);
        adRepository.getAd(ProtobufExtensionsKt.toISO8859ByteString(..), p1);
        return AdRepository.getAd(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonGetAdPlayer
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonGetAdPlayer {
    private final CoroutineScope adPlayerScope;
    private final CoroutineDispatcher defaultDispatcher;
    private final DeviceInfoRepository deviceInfoRepository;
    private final ExecuteAdViewerRequest executeAdViewerRequest;
    private final OpenMeasurementRepository openMeasurementRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;

    public CommonGetAdPlayer(DeviceInfoRepository p0, SessionRepository p1, ExecuteAdViewerRequest p2, SendDiagnosticEvent p3, CoroutineDispatcher p4, CoroutineScope p5, OpenMeasurementRepository p6) {
        new Object();
        deviceInfoRepository = p0;
        sessionRepository = p1;
        executeAdViewerRequest = p2;
        sendDiagnosticEvent = p3;
        defaultDispatcher = p4;
        adPlayerScope = p5;
        openMeasurementRepository = p6;
        return;
    }

    public AdPlayer invoke(WebViewBridge p0, AndroidWebViewContainer p1, ByteString p2) {
        new WebViewAdPlayer(p0, deviceInfoRepository, sessionRepository, executeAdViewerRequest, defaultDispatcher, sendDiagnosticEvent, p1, adPlayerScope);
        BannerViewCache.getInstance();
        ProtobufExtensionsKt.toUUID(p2);
        ProtobufExtensionsKt.toUUID(..).toString();
        BannerViewCache.getInstance(..).getBannerView(UUID.toString(..));
        if (if-nez(BannerViewCache.getBannerView(..))) goto L_4c;
        ProtobufExtensionsKt.toISO8859String(p2);
        new AndroidFullscreenWebViewAdPlayer(new WebViewAdPlayer, ProtobufExtensionsKt.toISO8859String(..), p1, deviceInfoRepository, sessionRepository, openMeasurementRepository);
      L_4c:
        ProtobufExtensionsKt.toISO8859String(p2);
        new AndroidEmbeddableWebViewAdPlayer(new WebViewAdPlayer, ProtobufExtensionsKt.toISO8859String(..), p1, openMeasurementRepository);
      L_5a:
        return new AndroidEmbeddableWebViewAdPlayer(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonGetCacheDirectory
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonGetCacheDirectory {
    public CommonGetCacheDirectory() {
        new Object();
        return;
    }

    public File invoke(File p0, String p1) {
        new File(p0, p1);
        return new File(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonGetFileExtensionFromUrl
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonGetFileExtensionFromUrl {
    private final RemoveUrlQuery removeUrlQuery;

    public CommonGetFileExtensionFromUrl(RemoveUrlQuery p0) {
        new Object();
        removeUrlQuery = p0;
        return;
    }

    public final RemoveUrlQuery getRemoveUrlQuery() {
        return removeUrlQuery;
    }

    public String invoke(String p0) {
        removeUrlQuery.invoke(p0);
        if (if-nez(RemoveUrlQuery.invoke(..))) goto L_f;
        return 0;
      L_f:
        StringsKt.substringAfterLast$default(RemoveUrlQuery.invoke(..), 47, 0, 2, 0);
        StringsKt.contains$default(StringsKt.substringAfterLast$default(..), 46, 0, 2, 0);
        if (if-eqz(StringsKt.contains$default(..))) goto L_35;
        StringsKt.substringAfterLast$default(StringsKt.substringAfterLast$default(..), 46, 0, 2, 0);
        CharSequence.length();
        if (if-nez(CharSequence.length(..))) goto L_2f;
      L_2f:
        if (if-eqz(1)) goto L_32;
      L_32:
      L_33:
      L_35:
        return StringsKt.substringAfterLast$default(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonGetHeaderBiddingToken
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonGetHeaderBiddingToken {
    public static final CommonGetHeaderBiddingToken$Companion Companion = null;
    public static final String HB_TOKEN_VERSION = "2";
    private final BuildHeaderBiddingToken buildHeaderBiddingToken;

    static <clinit>() {
        new CommonGetHeaderBiddingToken$Companion(0);
        Companion = new CommonGetHeaderBiddingToken$Companion(..);
        return;
    }

    public CommonGetHeaderBiddingToken(BuildHeaderBiddingToken p0) {
        new Object();
        buildHeaderBiddingToken = p0;
        return;
    }

    public Object invoke(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new CommonGetHeaderBiddingToken$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        label = 1;
        buildHeaderBiddingToken.invoke("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(BuildHeaderBiddingToken.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_40;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_40:
        BuildHeaderBiddingToken.invoke(..).toByteString();
        ProtobufExtensionsKt.toBase64$default(HeaderBiddingTokenOuterClass$HeaderBiddingToken.toByteString(..), 0, 1, 0);
        new StringBuilder("2:");
        new StringBuilder(..).append(ProtobufExtensionsKt.toBase64$default(..));
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonGetInitializationState
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonGetInitializationState {
    private final SessionRepository sessionRepository;

    public CommonGetInitializationState(SessionRepository p0) {
        new Object();
        sessionRepository = p0;
        return;
    }

    public InitializationState invoke() {
        sessionRepository.getInitializationState();
        return SessionRepository.getInitializationState(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonGetIsFileCache
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonGetIsFileCache {
    private final CacheRepository cacheRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public CommonGetIsFileCache(CacheRepository p0, SendDiagnosticEvent p1) {
        new Object();
        cacheRepository = p0;
        sendDiagnosticEvent = p1;
        return;
    }

    public Object invoke(String p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new CommonGetIsFileCache$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_3c;
        if (if-ne(label, 1)) goto L_34;
        ResultKt.throwOnFailure(result);
      L_34:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_3c:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        TimeSource$Monotonic.INSTANCE.markNow-z9LOYto();
        StringsKt.substringAfterLast$default(new IllegalStateException(..), "/", 0, 2, 0);
        StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(..), ".", 0, 2, 0);
        L$0 = this;
        L$1 = new IllegalStateException(..);
        J$0 = TimeSource$Monotonic.markNow-z9LOYto(..);
        label = 1;
        cacheRepository.doesFileExist(StringsKt.substringBefore$default(..), L$0);
        if (if-ne(CacheRepository.doesFileExist(..), J$0)) goto L_64;
        return J$0;
      L_64:
      L_66:
        CacheRepository.doesFileExist(..).booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_73;
      L_73:
      L_75:
        TimeSource$Monotonic$ValueTimeMark.box-impl(TimeSource$Monotonic.markNow-z9LOYto(..), cacheRepository);
        TimeExtensionsKt.elapsedMillis(TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), TimeSource$Monotonic.markNow-z9LOYto(..));
        TuplesKt.to("url", new IllegalStateException(..));
        MapsKt.mapOf(TuplesKt.to(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_show_is_file_cached_failure_time", Boxing.boxDouble(..), MapsKt.mapOf(..), 0, 0, 24, 0);
        Boxing.boxBoolean(Boolean.booleanValue(..));
        return Boxing.boxBoolean(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonGetWebViewBridgeUseCase
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonGetWebViewBridgeUseCase {
    private final CoroutineDispatcher dispatcher;

    public CommonGetWebViewBridgeUseCase() {
        new CommonGetWebViewBridgeUseCase(0, 1, 0);
        return;
    }

    public CommonGetWebViewBridgeUseCase(CoroutineDispatcher p0) {
        new Object();
        dispatcher = p0;
        return;
    }

    public CommonGetWebViewBridgeUseCase(CoroutineDispatcher p0, int p1, DefaultConstructorMarker p2) {
        if (if-eqz(p1)) goto L_8;
        Dispatchers.getDefault();
      L_8:
        new CommonGetWebViewBridgeUseCase(Dispatchers.getDefault(..));
        return;
    }

    public WebViewBridge invoke(AndroidWebViewContainer p0, CoroutineScope p1) {
        new CommonWebViewBridge(dispatcher, p0, p1);
        return new CommonWebViewBridge(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonInitAwaitingGetHeaderBiddingToken {
    private final AwaitInitialization awaitInitialization;
    private boolean didAwaitInit;
    private final GetHeaderBiddingToken getHeaderBiddingToken;
    private final GetInitializationState getInitializationState;
    private IUnityAdsTokenListener listener;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private InitializationState startState;
    private final long startTime;

    public static void $r8$lambda$-AfHawnLQpk-Suye7u4OtGZ4wbk(CommonInitAwaitingGetHeaderBiddingToken p0) {
        CommonInitAwaitingGetHeaderBiddingToken.tokenFailure$lambda$4(p0);
        return;
    }

    public static void $r8$lambda$pM-OI0vad3zaBa-QVq1l2RdiVNo(CommonInitAwaitingGetHeaderBiddingToken p0, String p1) {
        CommonInitAwaitingGetHeaderBiddingToken.tokenSuccess$lambda$0(p0, p1);
        return;
    }

    public CommonInitAwaitingGetHeaderBiddingToken(GetHeaderBiddingToken p0, SendDiagnosticEvent p1, GetInitializationState p2, AwaitInitialization p3, SessionRepository p4) {
        new Object();
        getHeaderBiddingToken = p0;
        sendDiagnosticEvent = p1;
        getInitializationState = p2;
        awaitInitialization = p3;
        sessionRepository = p4;
        TimeSource$Monotonic.INSTANCE.markNow-z9LOYto();
        startTime = TimeSource$Monotonic.markNow-z9LOYto(..);
        return;
    }

    public static final Object access$fetchToken(CommonInitAwaitingGetHeaderBiddingToken p0, Continuation p1) {
        p0.fetchToken(p1);
        return CommonInitAwaitingGetHeaderBiddingToken.fetchToken(..);
    }

    public static final void access$setDidAwaitInit$p(CommonInitAwaitingGetHeaderBiddingToken p0, boolean p1) {
        didAwaitInit = p1;
        return;
    }

    public static final void access$tokenFailure(CommonInitAwaitingGetHeaderBiddingToken p0, String p1, String p2) {
        p0.tokenFailure(p1, p2);
        return;
    }

    private final Object fetchToken(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_39;
        if (if-ne(label, 1)) goto L_31;
        ResultKt.throwOnFailure(result);
      L_31:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_39:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        L$0 = this;
        label = 1;
        getHeaderBiddingToken.invoke("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(GetHeaderBiddingToken.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_49;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_49:
      L_4a:
      L_52:
        ExceptionExtensionsKt.retrieveUnityCrashValue(0);
      L_5a:
        if (if-nez(GetHeaderBiddingToken.invoke(..))) goto L_60;
        CommonInitAwaitingGetHeaderBiddingToken.tokenFailure("uncaught_exception", ExceptionExtensionsKt.retrieveUnityCrashValue(..));
      L_60:
        CommonInitAwaitingGetHeaderBiddingToken.tokenSuccess(GetHeaderBiddingToken.invoke(..));
      L_63:
        return Unit.INSTANCE;
    }

    private final void tokenFailure(String p0, String p1) {
        TimeSource$Monotonic$ValueTimeMark.box-impl(startTime, v3);
        TimeExtensionsKt.elapsedMillis(TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        Double.valueOf(TimeExtensionsKt.elapsedMillis(..), v3);
        MapsKt.createMapBuilder();
        MapsKt.createMapBuilder(..).put("sync", "false");
        String.valueOf(startState);
        MapsKt.createMapBuilder(..).put("state", String.valueOf(..));
        getInitializationState.invoke();
        GetInitializationState.invoke(..).toString();
        MapsKt.createMapBuilder(..).put("complete_state", InitializationState.toString(..));
        String.valueOf(didAwaitInit);
        MapsKt.createMapBuilder(..).put("awaited_init", String.valueOf(..));
        if (if-eqz(p0)) goto L_4c;
        MapsKt.createMapBuilder(..).put("reason", p0);
      L_4c:
        if (if-eqz(p1)) goto L_53;
        MapsKt.createMapBuilder(..).put("reason_debug", p1);
      L_53:
        MapsKt.build(MapsKt.createMapBuilder(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_gateway_token_failure_time", Double.valueOf(..), MapsKt.build(..), 0, 0, 24, 0);
        new CommonInitAwaitingGetHeaderBiddingToken$$ExternalSyntheticLambda0(this);
        Utilities.wrapCustomerListener(new CommonInitAwaitingGetHeaderBiddingToken$$ExternalSyntheticLambda0(..));
        return;
    }

    static void tokenFailure$default(CommonInitAwaitingGetHeaderBiddingToken p0, String p1, String p2, int p3, Object p4) {
        if (if-eqz(p3)) goto L_5;
      L_5:
        p0.tokenFailure(p1, 0);
        return;
    }

    private static final void tokenFailure$lambda$4(CommonInitAwaitingGetHeaderBiddingToken p0) {
        if (if-eqz(listener)) goto L_d;
        listener.onUnityAdsTokenReady(0);
      L_d:
        return;
    }

    private final void tokenStart() {
        getInitializationState.invoke();
        startState = GetInitializationState.invoke(..);
        TuplesKt.to("sync", "false");
        String.valueOf(startState);
        TuplesKt.to("state", String.valueOf(..));
        MapsKt.mapOf(2);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_gateway_token_started", 0, MapsKt.mapOf(..), 0, 0, 26, 0);
        return;
    }

    private final void tokenSuccess(String p0) {
        TimeSource$Monotonic$ValueTimeMark.box-impl(startTime, v3);
        TimeExtensionsKt.elapsedMillis(TimeSource$Monotonic$ValueTimeMark.box-impl(..));
        Double.valueOf(TimeExtensionsKt.elapsedMillis(..), v3);
        TuplesKt.to("sync", "false");
        String.valueOf(startState);
        TuplesKt.to("state", String.valueOf(..));
        getInitializationState.invoke();
        GetInitializationState.invoke(..).toString();
        TuplesKt.to("complete_state", InitializationState.toString(..));
        String.valueOf(didAwaitInit);
        TuplesKt.to("awaited_init", String.valueOf(..));
        MapsKt.mapOf(4);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_gateway_token_success_time", Double.valueOf(..), MapsKt.mapOf(..), 0, 0, 24, 0);
        new CommonInitAwaitingGetHeaderBiddingToken$$ExternalSyntheticLambda1(this, p0);
        Utilities.wrapCustomerListener(new CommonInitAwaitingGetHeaderBiddingToken$$ExternalSyntheticLambda1(..));
        return;
    }

    private static final void tokenSuccess$lambda$0(CommonInitAwaitingGetHeaderBiddingToken p0, String p1) {
        if (if-eqz(listener)) goto L_11;
        listener.onUnityAdsTokenReady(p1);
      L_11:
        return;
    }

    public final AwaitInitialization getAwaitInitialization() {
        return awaitInitialization;
    }

    public final GetHeaderBiddingToken getGetHeaderBiddingToken() {
        return getHeaderBiddingToken;
    }

    public final GetInitializationState getGetInitializationState() {
        return getInitializationState;
    }

    public final IUnityAdsTokenListener getListener() {
        return listener;
    }

    public final SendDiagnosticEvent getSendDiagnosticEvent() {
        return sendDiagnosticEvent;
    }

    public final SessionRepository getSessionRepository() {
        return sessionRepository;
    }

    public final long getStartTime-z9LOYto() {
        return startTime;
    }

    public Object invoke(IUnityAdsTokenListener p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new CommonInitAwaitingGetHeaderBiddingToken$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_3e;
        if (if-eq(label, 1)) goto L_36;
        if (if-ne(label, 2)) goto L_2e;
        ResultKt.throwOnFailure(result);
      L_2e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_36:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_3e:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        listener = L$0;
        CommonInitAwaitingGetHeaderBiddingToken.tokenStart();
        if (if-nez(L$0)) goto L_52;
        CommonInitAwaitingGetHeaderBiddingToken.tokenFailure("listener_null", "IUnityAdsTokenListener is null");
        return Unit.INSTANCE;
      L_52:
        sessionRepository.getShouldInitialize();
        if (if-nez(SessionRepository.getShouldInitialize(..))) goto L_64;
        CommonInitAwaitingGetHeaderBiddingToken.tokenFailure("gateway", "!sessionRepository.shouldInitialize");
        return Unit.INSTANCE;
      L_64:
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getAdOperations();
        NativeConfigurationOuterClass$AdOperationsConfiguration.getGetTokenTimeoutMs();
        new CommonInitAwaitingGetHeaderBiddingToken$invoke$2(this, 0);
        L$0 = this;
        label = 1;
        TimeoutKt.withTimeout(NativeConfigurationOuterClass$AdOperationsConfiguration.getGetTokenTimeoutMs(..), "!sessionRepository.shouldInitialize", new CommonInitAwaitingGetHeaderBiddingToken$invoke$2(..), new CommonInitAwaitingGetHeaderBiddingToken$invoke$1(..));
        if (if-ne(TimeoutKt.withTimeout(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_91;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
        L$0 = 0;
        label = 2;
        CommonInitAwaitingGetHeaderBiddingToken.fetchToken(new CommonInitAwaitingGetHeaderBiddingToken$invoke$1(..));
        if (if-ne(CommonInitAwaitingGetHeaderBiddingToken.fetchToken(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_91;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_91:
        return Unit.INSTANCE;
    }

    public final void setListener(IUnityAdsTokenListener p0) {
        listener = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonSetInitializationState
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonSetInitializationState {
    private final SessionRepository sessionRepository;

    public CommonSetInitializationState(SessionRepository p0) {
        new Object();
        sessionRepository = p0;
        return;
    }

    public void invoke(InitializationState p0) {
        sessionRepository.setInitializationState(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CreateFile
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class CreateFile {
    public abstract File invoke(File p0, String p1) {
        // native or abstract
    }

    public abstract File invoke(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.ExecuteAdViewerRequest
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class ExecuteAdViewerRequest {
    public abstract Object invoke(RequestType p0, Object[] p1, Continuation p2) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetAdDataRefreshRequest
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetAdDataRefreshRequest {
    public abstract Object invoke(ByteString p0, ByteString p1, Continuation p2) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetAdObject
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetAdObject {
    public abstract Object invoke(String p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetAdPlayer
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetAdPlayer {
    public abstract AdPlayer invoke(WebViewBridge p0, AndroidWebViewContainer p1, ByteString p2) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetAdPlayerConfigRequest
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetAdPlayerConfigRequest {
    public abstract Object invoke(String p0, ByteString p1, ByteString p2, Continuation p3) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetAdRequest
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetAdRequest {
    public abstract Object invoke(String p0, ByteString p1, AdRequestOuterClass$BannerSize p2, Continuation p3) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetAsyncHeaderBiddingToken
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetAsyncHeaderBiddingToken {
    public abstract Object invoke(IUnityAdsTokenListener p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetByteStringId
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetByteStringId {
    public abstract ByteString invoke() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetCacheDirectory
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetCacheDirectory {
    public abstract File invoke(File p0, String p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetCachedAsset
// ============================================================
package com.unity3d.ads.core.domain;

public final class GetCachedAsset {
    private final CacheRepository cacheRepository;
    private final Context context;

    public GetCachedAsset(CacheRepository p0, Context p1) {
        new Object();
        cacheRepository = p0;
        context = p1;
        return;
    }

    private final WebResourceResponse getBundledAsset(Uri p0) {
        p0.getPath();
        String.valueOf(Uri.getPath(..));
        StringsKt.substringAfter$default(String.valueOf(..), "/", 0, 2, 0);
        context.getAssets();
        Context.getAssets(..).open(StringsKt.substringAfter$default(..));
        GetWebViewAssetLoaderKt.guessMimeType(StringsKt.substringAfter$default(..));
        new WebResourceResponse(GetWebViewAssetLoaderKt.guessMimeType(..), 0, AssetManager.open(..));
        return new WebResourceResponse(..);
    }

    private final WebResourceResponse getCachedAsset(Uri p0) {
        p0.toString();
        StringsKt.substringAfterLast$default(Uri.toString(..), "/", 0, 2, 0);
        StringsKt.substringBeforeLast$default(StringsKt.substringAfterLast$default(..), ".", 0, 2, 0);
        cacheRepository.retrieveFile(StringsKt.substringBeforeLast$default(..));
        if (if-eqz(cacheRepository)) goto L_5f;
        CacheRepository.retrieveFile(..).getCachedFile();
        CachedFile.getFile();
        if (if-nez(CachedFile.getFile(..))) goto L_2e;
        return 0;
      L_2e:
        new FileInputStream(CachedFile.getFile(..));
        new StringBuilder();
        CachedFile.getFile(..).getAbsolutePath();
        new StringBuilder(..).append(File.getAbsolutePath(..));
        new StringBuilder(..).append(46);
        CacheRepository.retrieveFile(..).getCachedFile();
        CachedFile.getExtension();
        new StringBuilder(..).append(CachedFile.getExtension(..));
        new StringBuilder(..).toString();
        GetWebViewAssetLoaderKt.guessMimeType(StringBuilder.toString(..));
        new WebResourceResponse(GetWebViewAssetLoaderKt.guessMimeType(..), 0, new FileInputStream(..));
      L_5f:
        return new WebResourceResponse(..);
    }

    public final WebResourceResponse invoke(Uri p0) {
        p0.getHost();
        if (if-eqz(Uri.getHost(..))) goto L_36;
        Uri.getHost(..).hashCode();
        if (if-eq(String.hashCode(..), -1921537799)) goto L_28;
        if (if-eq(String.hashCode(..), -1920242293)) goto L_1a;
      L_1a:
        Uri.getHost(..).equals("unity.ads.cache");
        if (if-nez(String.equals(..))) goto L_23;
      L_23:
        GetCachedAsset.getCachedAsset(p0);
      L_28:
        String.equals(..).equals("unity.ads.asset");
        if (if-nez(String.equals(..))) goto L_31;
      L_31:
        GetCachedAsset.getBundledAsset(GetCachedAsset.getCachedAsset(..));
      L_36:
      L_37:
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetClientInfo
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetClientInfo {
    public abstract ClientInfoOuterClass$ClientInfo invoke() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetFileExtensionFromUrl
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetFileExtensionFromUrl {
    public abstract String invoke(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetHeaderBiddingToken
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetHeaderBiddingToken {
    public abstract Object invoke(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetInitRequestPolicy
// ============================================================
package com.unity3d.ads.core.domain;

public final class GetInitRequestPolicy {
    private final SessionRepository sessionRepository;

    public GetInitRequestPolicy(SessionRepository p0) {
        new Object();
        sessionRepository = p0;
        return;
    }

    public RequestPolicy invoke() {
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getInitPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getMaxDuration();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getInitPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getRetryMaxInterval();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getInitPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getRetryWaitBase();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getInitPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getRetryJitterPct();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getInitPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getConnectTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getInitPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getReadTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getInitPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getWriteTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getInitPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getOverallTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getInitPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getShouldStoreLocally();
        new RequestPolicy(NativeConfigurationOuterClass$RequestRetryPolicy.getMaxDuration(..), NativeConfigurationOuterClass$RequestRetryPolicy.getRetryMaxInterval(..), NativeConfigurationOuterClass$RequestRetryPolicy.getRetryWaitBase(..), NativeConfigurationOuterClass$RequestRetryPolicy.getRetryJitterPct(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getConnectTimeoutMs(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getReadTimeoutMs(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getWriteTimeoutMs(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getOverallTimeoutMs(..), NativeConfigurationOuterClass$RequestRetryPolicy.getShouldStoreLocally(..));
        return new RequestPolicy;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetInitializationCompletedRequest
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetInitializationCompletedRequest {
    public abstract Object invoke(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetInitializationData
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetInitializationData {
    public abstract Object invoke(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetInitializationRequest
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetInitializationRequest {
    public abstract Object invoke(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetInitializationRequestPayload
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetInitializationRequestPayload {
    public abstract Object invoke(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetInitializationState
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetInitializationState {
    public abstract InitializationState invoke() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetIsFileCache
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetIsFileCache {
    public abstract Object invoke(String p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetLatestWebViewConfiguration
// ============================================================
package com.unity3d.ads.core.domain;

public final class GetLatestWebViewConfiguration {
    private final WebviewConfigurationDataSource webviewConfigurationDataSource;

    public GetLatestWebViewConfiguration(WebviewConfigurationDataSource p0) {
        new Object();
        webviewConfigurationDataSource = p0;
        return;
    }

    public static Object invoke$default(GetLatestWebViewConfiguration p0, String p1, Integer p2, List p3, Continuation p4, int p5, Object p6) {
        if (if-eqz(p6)) goto L_6;
      L_6:
        if (if-eqz(p6)) goto L_b;
      L_b:
        if (if-eqz(p5)) goto L_10;
      L_10:
        p0.invoke(0, 0, 0, p4);
        return GetLatestWebViewConfiguration.invoke(..);
    }

    public final Object invoke(String p0, Integer p1, List p2, Continuation p3) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new GetLatestWebViewConfiguration$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_50;
        if (if-eq(label, 1)) goto L_3a;
        if (if-ne(label, 2)) goto L_32;
        ResultKt.throwOnFailure(result);
      L_32:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_3a:
        ResultKt.throwOnFailure(result);
      L_50:
        ResultKt.throwOnFailure(result);
        L$0 = this;
        L$1 = L$1;
        L$2 = L$2;
        L$3 = L$3;
        label = 1;
        webviewConfigurationDataSource.get(new GetLatestWebViewConfiguration$invoke$1(..));
        if (if-ne(WebviewConfigurationDataSource.get(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_66;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_66:
      L_67:
        WebviewConfigurationStore$WebViewConfigurationStore.getVersion();
        WebviewConfigurationStore$WebViewConfigurationStore.getEntryPoint();
        WebviewConfigurationStore$WebViewConfigurationStore.getAdditionalFilesList();
        new WebViewConfiguration(WebviewConfigurationStore$WebViewConfigurationStore.getVersion(..), WebviewConfigurationStore$WebViewConfigurationStore.getEntryPoint(..), WebviewConfigurationStore$WebViewConfigurationStore.getAdditionalFilesList(..));
        if (if-nez(L$1)) goto L_8b;
        if (if-nez(L$2)) goto L_8b;
        if (if-nez(L$3)) goto L_8b;
        return new WebViewConfiguration(..);
      L_8b:
        if (if-eqz(L$2)) goto L_94;
        L$2.intValue();
      L_94:
        new WebViewConfiguration(..).getVersion();
      L_98:
        if (if-nez(L$1)) goto L_9e;
        new WebViewConfiguration(..).getEntryPoint();
      L_9e:
        if (if-nez(L$3)) goto L_a4;
        new WebViewConfiguration(..).getAdditionalFiles();
      L_a4:
        new WebViewConfiguration(WebViewConfiguration.getVersion(..), WebViewConfiguration.getEntryPoint(..), WebViewConfiguration.getAdditionalFiles(..));
        Intrinsics.areEqual(new WebViewConfiguration(..), new WebViewConfiguration(..));
        if (if-nez(Intrinsics.areEqual(..))) goto L_e9;
        WebviewConfigurationStore$WebViewConfigurationStore.newBuilder();
        new WebViewConfiguration(..).getVersion();
        WebviewConfigurationStore$WebViewConfigurationStore$Builder.setVersion(WebViewConfiguration.getVersion(..));
        new WebViewConfiguration(..).getEntryPoint();
        WebviewConfigurationStore$WebViewConfigurationStore$Builder.setEntryPoint(WebViewConfiguration.getEntryPoint(..));
        new WebViewConfiguration(..).getAdditionalFiles();
        WebviewConfigurationStore$WebViewConfigurationStore$Builder.addAllAdditionalFiles(WebViewConfiguration.getAdditionalFiles(..));
        WebviewConfigurationStore$WebViewConfigurationStore$Builder.build();
        L$0 = new WebViewConfiguration(..);
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        label = 2;
        webviewConfigurationDataSource.set(WebviewConfigurationStore$WebViewConfigurationStore$Builder.build(..), new GetLatestWebViewConfiguration$invoke$1(..));
        if (if-ne(WebviewConfigurationDataSource.set(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_e7;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_e7:
      L_e8:
      L_e9:
        return new WebViewConfiguration(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetLimitedSessionToken
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetLimitedSessionToken {
    public abstract Object invoke(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetOpenGLRendererInfo
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetOpenGLRendererInfo {
    public abstract ByteString invoke() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetOperativeEventRequestPolicy
// ============================================================
package com.unity3d.ads.core.domain;

public final class GetOperativeEventRequestPolicy {
    private final SessionRepository sessionRepository;

    public GetOperativeEventRequestPolicy(SessionRepository p0) {
        new Object();
        sessionRepository = p0;
        return;
    }

    public RequestPolicy invoke() {
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOperativeEventPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getMaxDuration();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOperativeEventPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getRetryMaxInterval();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOperativeEventPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getRetryWaitBase();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOperativeEventPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getRetryJitterPct();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOperativeEventPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getConnectTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOperativeEventPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getReadTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOperativeEventPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getWriteTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOperativeEventPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getOverallTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOperativeEventPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getShouldStoreLocally();
        new RequestPolicy(NativeConfigurationOuterClass$RequestRetryPolicy.getMaxDuration(..), NativeConfigurationOuterClass$RequestRetryPolicy.getRetryMaxInterval(..), NativeConfigurationOuterClass$RequestRetryPolicy.getRetryWaitBase(..), NativeConfigurationOuterClass$RequestRetryPolicy.getRetryJitterPct(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getConnectTimeoutMs(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getReadTimeoutMs(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getWriteTimeoutMs(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getOverallTimeoutMs(..), NativeConfigurationOuterClass$RequestRetryPolicy.getShouldStoreLocally(..));
        return new RequestPolicy;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetOtherRequestPolicy
// ============================================================
package com.unity3d.ads.core.domain;

public final class GetOtherRequestPolicy {
    private final SessionRepository sessionRepository;

    public GetOtherRequestPolicy(SessionRepository p0) {
        new Object();
        sessionRepository = p0;
        return;
    }

    public RequestPolicy invoke() {
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOtherPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getMaxDuration();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOtherPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getRetryMaxInterval();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOtherPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getRetryWaitBase();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOtherPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getRetryJitterPct();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOtherPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getConnectTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOtherPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getReadTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOtherPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getWriteTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOtherPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getTimeoutPolicy();
        NativeConfigurationOuterClass$RequestTimeoutPolicy.getOverallTimeoutMs();
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getOtherPolicy();
        NativeConfigurationOuterClass$RequestPolicy.getRetryPolicy();
        NativeConfigurationOuterClass$RequestRetryPolicy.getShouldStoreLocally();
        new RequestPolicy(NativeConfigurationOuterClass$RequestRetryPolicy.getMaxDuration(..), NativeConfigurationOuterClass$RequestRetryPolicy.getRetryMaxInterval(..), NativeConfigurationOuterClass$RequestRetryPolicy.getRetryWaitBase(..), NativeConfigurationOuterClass$RequestRetryPolicy.getRetryJitterPct(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getConnectTimeoutMs(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getReadTimeoutMs(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getWriteTimeoutMs(..), NativeConfigurationOuterClass$RequestTimeoutPolicy.getOverallTimeoutMs(..), NativeConfigurationOuterClass$RequestRetryPolicy.getShouldStoreLocally(..));
        return new RequestPolicy;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetPrivacyUpdateRequest
// ============================================================
package com.unity3d.ads.core.domain;

public final class GetPrivacyUpdateRequest {
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    public GetPrivacyUpdateRequest(GetUniversalRequestForPayLoad p0) {
        new Object();
        getUniversalRequestForPayLoad = p0;
        return;
    }

    public final Object invoke(int p0, ByteString p1, Continuation p2) {
        PrivacyUpdateRequestOuterClass$PrivacyUpdateRequest.newBuilder();
        PrivacyUpdateRequestKt$Dsl.Companion._create(PrivacyUpdateRequestOuterClass$PrivacyUpdateRequest.newBuilder(..));
        PrivacyUpdateRequestKt$Dsl.setVersion(p0);
        PrivacyUpdateRequestKt$Dsl.setContent(p1);
        PrivacyUpdateRequestKt$Dsl._build();
        UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder();
        UniversalRequestKt$PayloadKt$Dsl$Companion._create(UniversalRequestOuterClass$UniversalRequest$Payload.newBuilder(..));
        UniversalRequestKt$PayloadKt$Dsl.setPrivacyUpdateRequest(PrivacyUpdateRequestKt$Dsl._build(..));
        UniversalRequestKt$PayloadKt$Dsl._build();
        getUniversalRequestForPayLoad.invoke(UniversalRequestKt$PayloadKt$Dsl._build(..), p2);
        return GetUniversalRequestForPayLoad.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetRequestPolicy
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetRequestPolicy {
    public abstract RequestPolicy invoke() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetSharedDataTimestamps
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetSharedDataTimestamps {
    public abstract TimestampsOuterClass$Timestamps invoke() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetUniversalRequestForPayLoad {
    public abstract Object invoke(UniversalRequestOuterClass$UniversalRequest$Payload p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetUniversalRequestSharedData
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetUniversalRequestSharedData {
    public abstract Object invoke(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetWebViewBridgeUseCase
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetWebViewBridgeUseCase {
    public abstract WebViewBridge invoke(AndroidWebViewContainer p0, CoroutineScope p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetWebViewContainerUseCase
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class GetWebViewContainerUseCase {
    public abstract Object invoke(CoroutineScope p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleGatewayAdResponse
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class HandleGatewayAdResponse {
    public abstract Object invoke(UnityAdsLoadOptions p0, ByteString p1, AdResponseOuterClass$AdResponse p2, Context p3, String p4, DiagnosticEventRequestOuterClass$DiagnosticAdType p5, boolean p6, Continuation p7) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleGatewayInitializationResponse
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class HandleGatewayInitializationResponse {
    public abstract Object invoke(InitializationResponseOuterClass$InitializationResponse p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleGatewayUniversalResponse
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class HandleGatewayUniversalResponse {
    public abstract Object invoke(UniversalResponseOuterClass$UniversalResponse p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer
// ============================================================
package com.unity3d.ads.core.domain;

public final class HandleInvocationsFromAdViewer {
    public static final HandleInvocationsFromAdViewer$Companion Companion = null;
    public static final String KEY_AD_DATA = "adData";
    public static final String KEY_AD_DATA_REFRESH_TOKEN = "adDataRefreshToken";
    public static final String KEY_DOWNLOAD_PRIORITY = "priority";
    public static final String KEY_DOWNLOAD_URL = "url";
    public static final String KEY_IMPRESSION_CONFIG = "impressionConfig";
    public static final String KEY_IS_HEADER_BIDDING = "isHeaderBidding";
    public static final String KEY_LOAD_OPTIONS = "loadOptions";
    public static final String KEY_NATIVE_CONTEXT = "nativeContext";
    public static final String KEY_OMID = "openMeasurement";
    public static final String KEY_OMJS_SERVICE = "serviceFilePath";
    public static final String KEY_OMJS_SESSION = "sessionFilePath";
    public static final String KEY_OM_PARTNER = "partnerName";
    public static final String KEY_OM_PARTNER_VERSION = "partnerVersion";
    public static final String KEY_OM_VERSION = "version";
    public static final String KEY_PACKAGE_NAME = "packageName";
    public static final String KEY_PRIVACY_UPDATE_CONTENT = "content";
    public static final String KEY_PRIVACY_UPDATE_VERSION = "version";
    public static final String KEY_TRACKING_TOKEN = "trackingToken";

    static <clinit>() {
        new HandleInvocationsFromAdViewer$Companion(0);
        Companion = new HandleInvocationsFromAdViewer$Companion(..);
        return;
    }

    public HandleInvocationsFromAdViewer() {
        new Object();
        return;
    }

    public IServiceProvider getServiceProvider() {
        IServiceComponent$DefaultImpls.getServiceProvider(this);
        return IServiceComponent$DefaultImpls.getServiceProvider(..);
    }

    public final Object invoke(SharedFlow p0, String p1, String p2, String p3, AdObject p4, Function1 p5, Continuation p6) {
        AdData.constructor-impl(p1);
        ImpressionConfig.constructor-impl(p3);
        AdDataRefreshToken.constructor-impl(p2);
        new HandleInvocationsFromAdViewer$invoke$definition$1(this, AdData.constructor-impl(..), ImpressionConfig.constructor-impl(..), AdDataRefreshToken.constructor-impl(..), p4);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.getAdContext", new HandleInvocationsFromAdViewer$invoke$definition$1);
        new HandleInvocationsFromAdViewer$invoke$definition$2(this);
        TuplesKt.to("com.unity3d.services.core.api.DeviceInfo.getConnectionType", new HandleInvocationsFromAdViewer$invoke$definition$2(..));
        new HandleInvocationsFromAdViewer$invoke$definition$3(this);
        TuplesKt.to("com.unity3d.services.core.api.DeviceInfo.getDeviceVolume", new HandleInvocationsFromAdViewer$invoke$definition$3(..));
        new HandleInvocationsFromAdViewer$invoke$definition$4(this);
        TuplesKt.to("com.unity3d.services.core.api.DeviceInfo.getDeviceMaxVolume", new HandleInvocationsFromAdViewer$invoke$definition$4(..));
        new HandleInvocationsFromAdViewer$invoke$definition$5(this);
        TuplesKt.to("com.unity3d.services.core.api.DeviceInfo.getScreenHeight", new HandleInvocationsFromAdViewer$invoke$definition$5(..));
        new HandleInvocationsFromAdViewer$invoke$definition$6(this);
        TuplesKt.to("com.unity3d.services.core.api.DeviceInfo.getScreenWidth", new HandleInvocationsFromAdViewer$invoke$definition$6(..));
        new HandleInvocationsFromAdViewer$invoke$definition$7(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.openUrl", new HandleInvocationsFromAdViewer$invoke$definition$7(..));
        new HandleInvocationsFromAdViewer$invoke$definition$8(this, p4);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.sendOperativeEvent", new HandleInvocationsFromAdViewer$invoke$definition$8(..));
        TuplesKt.to("com.unity3d.services.core.api.Storage.write", HandleInvocationsFromAdViewer$invoke$definition$9.INSTANCE);
        TuplesKt.to("com.unity3d.services.core.api.Storage.read", HandleInvocationsFromAdViewer$invoke$definition$10.INSTANCE);
        TuplesKt.to("com.unity3d.services.core.api.Storage.delete", HandleInvocationsFromAdViewer$invoke$definition$11.INSTANCE);
        TuplesKt.to("com.unity3d.services.core.api.Storage.clear", HandleInvocationsFromAdViewer$invoke$definition$12.INSTANCE);
        TuplesKt.to("com.unity3d.services.core.api.Storage.getKeys", HandleInvocationsFromAdViewer$invoke$definition$13.INSTANCE);
        TuplesKt.to("com.unity3d.services.core.api.Storage.get", HandleInvocationsFromAdViewer$invoke$definition$14.INSTANCE);
        TuplesKt.to("com.unity3d.services.core.api.Storage.set", HandleInvocationsFromAdViewer$invoke$definition$15.INSTANCE);
        new HandleInvocationsFromAdViewer$invoke$definition$16(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.getPrivacyFsm", new HandleInvocationsFromAdViewer$invoke$definition$16(..));
        new HandleInvocationsFromAdViewer$invoke$definition$17(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.setPrivacyFsm", new HandleInvocationsFromAdViewer$invoke$definition$17(..));
        new HandleInvocationsFromAdViewer$invoke$definition$18(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.getPrivacyPayload", new HandleInvocationsFromAdViewer$invoke$definition$18(..));
        new HandleInvocationsFromAdViewer$invoke$definition$19(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.setPrivacyPayload", new HandleInvocationsFromAdViewer$invoke$definition$19(..));
        new HandleInvocationsFromAdViewer$invoke$definition$20(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.getPrivacyAllowedPii", new HandleInvocationsFromAdViewer$invoke$definition$20(..));
        new HandleInvocationsFromAdViewer$invoke$definition$21(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.setPrivacyAllowedPii", new HandleInvocationsFromAdViewer$invoke$definition$21(..));
        new HandleInvocationsFromAdViewer$invoke$definition$22(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.getSessionToken", new HandleInvocationsFromAdViewer$invoke$definition$22(..));
        new HandleInvocationsFromAdViewer$invoke$definition$23(this, p4);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.markCampaignStateAsShown", new HandleInvocationsFromAdViewer$invoke$definition$23(..));
        new HandleInvocationsFromAdViewer$invoke$definition$24(this, p4);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.refreshAdData", new HandleInvocationsFromAdViewer$invoke$definition$24(..));
        new HandleInvocationsFromAdViewer$invoke$definition$25(p4);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.updateTrackingToken", new HandleInvocationsFromAdViewer$invoke$definition$25(..));
        new HandleInvocationsFromAdViewer$invoke$definition$26(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.sendPrivacyUpdateRequest", new HandleInvocationsFromAdViewer$invoke$definition$26(..));
        new HandleInvocationsFromAdViewer$invoke$definition$27(this, p4);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.sendDiagnosticEvent", new HandleInvocationsFromAdViewer$invoke$definition$27(..));
        new HandleInvocationsFromAdViewer$invoke$definition$28(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.incrementBannerImpressionCount", new HandleInvocationsFromAdViewer$invoke$definition$28(..));
        new HandleInvocationsFromAdViewer$invoke$definition$29(this, p4);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.download", new HandleInvocationsFromAdViewer$invoke$definition$29(..));
        new HandleInvocationsFromAdViewer$invoke$definition$30(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.isFileCached", new HandleInvocationsFromAdViewer$invoke$definition$30(..));
        new HandleInvocationsFromAdViewer$invoke$definition$31(this, p4);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.omidStartSession", new HandleInvocationsFromAdViewer$invoke$definition$31(..));
        new HandleInvocationsFromAdViewer$invoke$definition$32(this, p4);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.omidFinishSession", new HandleInvocationsFromAdViewer$invoke$definition$32(..));
        new HandleInvocationsFromAdViewer$invoke$definition$33(this, p4);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.omidImpression", new HandleInvocationsFromAdViewer$invoke$definition$33(..));
        new HandleInvocationsFromAdViewer$invoke$definition$34(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.omidGetData", new HandleInvocationsFromAdViewer$invoke$definition$34(..));
        new HandleInvocationsFromAdViewer$invoke$definition$35(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.isAttributionAvailable", new HandleInvocationsFromAdViewer$invoke$definition$35(..));
        new HandleInvocationsFromAdViewer$invoke$definition$36(this, p4);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.attributionRegisterView", new HandleInvocationsFromAdViewer$invoke$definition$36(..));
        new HandleInvocationsFromAdViewer$invoke$definition$37(this, p4);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.attributionRegisterClick", new HandleInvocationsFromAdViewer$invoke$definition$37(..));
        new HandleInvocationsFromAdViewer$invoke$definition$38(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.hbTokenIncrementWins", new HandleInvocationsFromAdViewer$invoke$definition$38(..));
        new HandleInvocationsFromAdViewer$invoke$definition$39(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.hbTokenIncrementStarts", new HandleInvocationsFromAdViewer$invoke$definition$39(..));
        new HandleInvocationsFromAdViewer$invoke$definition$40(this);
        TuplesKt.to("com.unity3d.services.ads.api.AdViewer.hbTokenReset", new HandleInvocationsFromAdViewer$invoke$definition$40(..));
        MapsKt.mapOf(40);
        new HandleInvocationsFromAdViewer$invoke$2(p5, 0);
        FlowKt.onSubscription(p0, new HandleInvocationsFromAdViewer$invoke$2(..));
        new HandleInvocationsFromAdViewer$invoke$3(MapsKt.mapOf(..), 0);
        FlowKt.onEach(FlowKt.onSubscription(..), new HandleInvocationsFromAdViewer$invoke$3(..));
        return FlowKt.onEach(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleOpenUrl
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class HandleOpenUrl {
    public abstract void invoke(String p0, String p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HttpClientProvider
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class HttpClientProvider {
    public abstract Object invoke(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.InitializeBoldSDK
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class InitializeBoldSDK {
    public abstract Object invoke(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyLoadUseCase
// ============================================================
package com.unity3d.ads.core.domain;

public final class LegacyLoadUseCase {
    public static final LegacyLoadUseCase$Companion Companion = null;
    public static final String KEY_AD_MARKUP = "adMarkup";
    public static final String KEY_OBJECT_ID = "objectId";
    private final AdRepository adRepository;
    private final AwaitInitialization awaitInitialization;
    private final CoroutineDispatcher dispatcher;
    private final GetInitializationState getInitializationState;
    private boolean isBanner;
    private boolean isHeaderBidding;
    private IUnityAdsLoadListener listener;
    private final Load load;
    private UnityAdsLoadOptions loadOptions;
    private ByteString opportunity;
    private String placement;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private TimeMark startTime;

    static <clinit>() {
        new LegacyLoadUseCase$Companion(0);
        Companion = new LegacyLoadUseCase$Companion(..);
        return;
    }

    public LegacyLoadUseCase(CoroutineDispatcher p0, Load p1, SendDiagnosticEvent p2, GetInitializationState p3, AwaitInitialization p4, SessionRepository p5, AdRepository p6) {
        new Object();
        dispatcher = p0;
        load = p1;
        sendDiagnosticEvent = p2;
        getInitializationState = p3;
        awaitInitialization = p4;
        sessionRepository = p5;
        adRepository = p6;
        return;
    }

    public static final AdRepository access$getAdRepository$p(LegacyLoadUseCase p0) {
        return adRepository;
    }

    public static final AwaitInitialization access$getAwaitInitialization$p(LegacyLoadUseCase p0) {
        return awaitInitialization;
    }

    public static final GetInitializationState access$getGetInitializationState$p(LegacyLoadUseCase p0) {
        return getInitializationState;
    }

    public static final HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup access$getHeaderBiddingAdMarkup(LegacyLoadUseCase p0, String p1) {
        p0.getHeaderBiddingAdMarkup(p1);
        return LegacyLoadUseCase.getHeaderBiddingAdMarkup(..);
    }

    public static final IUnityAdsLoadListener access$getListener$p(LegacyLoadUseCase p0) {
        return listener;
    }

    public static final Load access$getLoad$p(LegacyLoadUseCase p0) {
        return load;
    }

    public static final String access$getOpportunityId(LegacyLoadUseCase p0, UnityAdsLoadOptions p1) {
        p0.getOpportunityId(p1);
        return LegacyLoadUseCase.getOpportunityId(..);
    }

    public static final String access$getPlacement$p(LegacyLoadUseCase p0) {
        return placement;
    }

    public static final Object access$loadFailure(LegacyLoadUseCase p0, LoadResult$Failure p1, Continuation p2) {
        p0.loadFailure(p1, p2);
        return LegacyLoadUseCase.loadFailure(..);
    }

    public static final Object access$loadSuccess(LegacyLoadUseCase p0, AdObject p1, Continuation p2) {
        p0.loadSuccess(p1, p2);
        return LegacyLoadUseCase.loadSuccess(..);
    }

    public static final void access$setOpportunity$p(LegacyLoadUseCase p0, ByteString p1) {
        opportunity = p1;
        return;
    }

    private final String getAdMarkup(UnityAdsLoadOptions p0) {
        p0.getData();
        if (if-eqz(UnityAdsLoadOptions.getData(..))) goto L_13;
        UnityAdsLoadOptions.getData(..).opt("adMarkup");
        if (if-eqz(JSONObject.opt(..))) goto L_13;
        JSONObject.opt(..).toString();
      L_13:
      L_14:
        return 0;
    }

    private final DiagnosticEventRequestOuterClass$DiagnosticAdType getAdType() {
        if (if-eqz(isBanner)) goto L_7;
      L_7:
      L_9:
        return DiagnosticEventRequestOuterClass$DiagnosticAdType.DIAGNOSTIC_AD_TYPE_FULLSCREEN;
    }

    private final AdRequestOuterClass$BannerSize getBannerSize(UnityBannerSize p0) {
        if (if-eqz(p0)) goto L_24;
        AdRequestOuterClass$BannerSize.newBuilder();
        BannerSizeKt$Dsl.Companion._create(AdRequestOuterClass$BannerSize.newBuilder(..));
        p0.getWidth();
        BannerSizeKt$Dsl.setWidth(UnityBannerSize.getWidth(..));
        p0.getHeight();
        BannerSizeKt$Dsl.setHeight(UnityBannerSize.getHeight(..));
        BannerSizeKt$Dsl._build();
      L_24:
      L_25:
        return 0;
    }

    private final HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup getHeaderBiddingAdMarkup(String p0) {
        if (if-eqz(p0)) goto L_10;
        StringsKt.isBlank(p0);
        if (if-eqz(StringsKt.isBlank(..))) goto L_e;
      L_e:
      L_10:
      L_11:
        if (if-nez(1)) goto L_22;
        ProtobufExtensionsKt.fromBase64$default(p0, 0, 1, 0);
        ByteString.toByteArray();
        HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup.parseFrom(ByteString.toByteArray(..));
        return 0;
      L_22:
        HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup.getDefaultInstance();
      L_26:
        return HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup.getDefaultInstance(..);
    }

    private final String getOpportunityId(UnityAdsLoadOptions p0) {
        p0.getData();
        if (if-eqz(UnityAdsLoadOptions.getData(..))) goto L_13;
        UnityAdsLoadOptions.getData(..).opt("objectId");
        if (if-eqz(JSONObject.opt(..))) goto L_13;
        JSONObject.opt(..).toString();
      L_13:
      L_14:
        return 0;
    }

    private final Map getTags(String p0, String p1) {
        getInitializationState.invoke();
        GetInitializationState.invoke(..).toString();
        TuplesKt.to("state", InitializationState.toString(..));
        OperationType.LOAD.toString();
        TuplesKt.to("operation", OperationType.toString(..));
        MapsKt.mutableMapOf(2);
        if (if-eqz(p0)) goto L_37;
        p0.length();
        if (if-nez(CharSequence.length(..))) goto L_35;
      L_35:
      L_37:
      L_38:
        if (if-nez(1)) goto L_3f;
        MapsKt.mutableMapOf(..).put("reason", p0);
      L_3f:
        if (if-eqz(p1)) goto L_4a;
        p1.length();
        if (if-nez(CharSequence.length(..))) goto L_4b;
      L_4a:
      L_4b:
        if (if-nez(1)) goto L_52;
        MapsKt.mutableMapOf(..).put("reason_debug", p1);
      L_52:
        return MapsKt.mutableMapOf(..);
    }

    static Map getTags$default(LegacyLoadUseCase p0, String p1, String p2, int p3, Object p4) {
        if (if-eqz(p4)) goto L_6;
      L_6:
        if (if-eqz(p3)) goto L_b;
      L_b:
        p0.getTags(0, 0);
        return LegacyLoadUseCase.getTags(..);
    }

    private final AdObject getTmpAdObject() {
        if (if-nez(opportunity)) goto L_8;
      L_8:
        if (if-nez(placement)) goto L_14;
      L_14:
        if (if-nez(loadOptions)) goto L_27;
        new UnityAdsLoadOptions();
      L_27:
        Boolean.valueOf(isHeaderBidding);
        LegacyLoadUseCase.getAdType();
        new AdObject(ByteString.EMPTY, "", ByteString.EMPTY, 0, 0, new UnityAdsLoadOptions(..), Boolean.valueOf(..), LegacyLoadUseCase.getAdType(..), 16, 0);
        return new AdObject;
    }

    public static Object invoke$default(LegacyLoadUseCase p0, Context p1, String p2, UnityAdsLoadOptions p3, IUnityAdsLoadListener p4, UnityBannerSize p5, Continuation p6, int p7, Object p8) {
        if (if-eqz(p7)) goto L_5;
      L_5:
        p0.invoke(p1, p2, p3, p4, 0, p6);
        return LegacyLoadUseCase.invoke(..);
    }

    private final Object loadFailure(LoadResult$Failure p0, Continuation p1) {
        new StringBuilder("Unity Ads Load Failure for placement: ");
        new StringBuilder(..).append(placement);
        new StringBuilder(..).append(" reason: ");
        p0.getError();
        new StringBuilder(..).append(LoadResult$Failure.getError(..));
        new StringBuilder(..).append(" :: ");
        p0.getMessage();
        new StringBuilder(..).append(LoadResult$Failure.getMessage(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        if (if-eqz(startTime)) goto L_3e;
        TimeExtensionsKt.elapsedMillis(startTime);
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), v4);
      L_3e:
      L_3f:
        p0.getReason();
        p0.getReasonDebug();
        LegacyLoadUseCase.getTags(LoadResult$Failure.getReason(..), LoadResult$Failure.getReasonDebug(..));
        LegacyLoadUseCase.getTmpAdObject();
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_load_failure_time", 0, LegacyLoadUseCase.getTags(..), 0, LegacyLoadUseCase.getTmpAdObject(..), 8, 0);
        new LegacyLoadUseCase$loadFailure$2(this, p0, 0);
        BuildersKt.withContext(dispatcher, new LegacyLoadUseCase$loadFailure$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_6c;
        return BuildersKt.withContext(..);
      L_6c:
        return Unit.INSTANCE;
    }

    private final TimeMark loadStart() {
        TimeSource$Monotonic.INSTANCE.markNow-z9LOYto();
        LegacyLoadUseCase.getTags$default(this, 0, 0, 3, 0);
        LegacyLoadUseCase.getTmpAdObject();
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_load_started", 0, LegacyLoadUseCase.getTags$default(..), 0, LegacyLoadUseCase.getTmpAdObject(..), 10, 0);
        TimeSource$Monotonic$ValueTimeMark.box-impl(TimeSource$Monotonic.markNow-z9LOYto(..), v1);
        return TimeSource$Monotonic$ValueTimeMark.box-impl(..);
    }

    private final Object loadSuccess(AdObject p0, Continuation p1) {
        new StringBuilder("Unity Ads Load Success for placement: ");
        new StringBuilder(..).append(placement);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        if (if-eqz(startTime)) goto L_26;
        TimeExtensionsKt.elapsedMillis(startTime);
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), v4);
      L_26:
      L_27:
        LegacyLoadUseCase.getTags$default(this, 0, 0, 3, 0);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_load_success_time", 0, LegacyLoadUseCase.getTags$default(..), 0, p0, 8, 0);
        new LegacyLoadUseCase$loadSuccess$2(this, 0);
        BuildersKt.withContext(dispatcher, new LegacyLoadUseCase$loadSuccess$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4a;
        return BuildersKt.withContext(..);
      L_4a:
        return Unit.INSTANCE;
    }

    public final Object invoke(Context p0, String p1, UnityAdsLoadOptions p2, IUnityAdsLoadListener p3, UnityBannerSize p4, Continuation p5) {
        if (if-eqz(v3)) goto L_20;
        if (if-eqz(label)) goto L_20;
        label = label;
      L_20:
        new LegacyLoadUseCase$invoke$1(this, label);
      L_25:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_6d;
        if (if-eq(label, 1)) goto L_5a;
        if (if-eq(label, 2)) goto L_54;
        if (if-eq(label, 3)) goto L_4a;
        if (if-ne(label, 4)) goto L_42;
        ResultKt.throwOnFailure(result);
      L_42:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_4a:
      L_4f:
        ResultKt.throwOnFailure(result);
      L_54:
      L_5a:
        ResultKt.throwOnFailure(result);
      L_6d:
        ResultKt.throwOnFailure(result);
        new StringBuilder("Unity Ads Load Start for placement ");
        new StringBuilder(..).append(L$1);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        LegacyLoadUseCase.getAdMarkup(p2);
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getAdOperations();
        NativeConfigurationOuterClass$AdOperationsConfiguration.getLoadTimeoutMs();
        LegacyLoadUseCase.getBannerSize(L$0);
        if (if-eqz(LegacyLoadUseCase.getAdMarkup(..))) goto L_a9;
        StringsKt.isBlank(LegacyLoadUseCase.getAdMarkup(..));
        if (if-eqz(StringsKt.isBlank(..))) goto L_a6;
      L_a6:
      L_a9:
      L_aa:
        isHeaderBidding = 1;
        if (if-eqz(L$0)) goto L_b1;
      L_b1:
      L_b3:
        isBanner = 0;
        listener = p3;
        placement = L$1;
        loadOptions = p2;
        LegacyLoadUseCase.loadStart();
        startTime = LegacyLoadUseCase.loadStart(..);
        new LegacyLoadUseCase$invoke$loadResult$1(p1, this, p2, LegacyLoadUseCase.getAdMarkup(..), p0, LegacyLoadUseCase.getBannerSize(..), 0);
        L$0 = this;
        L$1 = L$1;
        label = 1;
        TimeoutKt.withTimeoutOrNull(NativeConfigurationOuterClass$AdOperationsConfiguration.getLoadTimeoutMs(..), 3, new LegacyLoadUseCase$invoke$loadResult$1, new LegacyLoadUseCase$invoke$1(..));
        if (if-ne(TimeoutKt.withTimeoutOrNull(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_eb;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_eb:
      L_ec:
        if (if-nez(TimeoutKt.withTimeoutOrNull(..))) goto L_117;
        new StringBuilder("[UnityAds] Timeout while loading ");
        new StringBuilder(..).append(L$1);
        new StringBuilder(..).toString();
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.TIMEOUT, StringBuilder.toString(..), 0, "timeout", 0, 20, 0);
      L_117:
        if (if-eqz(L$1)) goto L_130;
        new LoadResult$Failure.getAdObject();
        L$0 = this;
        L$1 = 0;
        label = 2;
        LegacyLoadUseCase.loadSuccess(LoadResult$Success.getAdObject(..), new LegacyLoadUseCase$invoke$1(..));
        if (if-ne(LegacyLoadUseCase.loadSuccess(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_172;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_130:
        if (if-eqz(LegacyLoadUseCase.loadSuccess(..))) goto L_172;
        L$0 = this;
        L$1 = 0;
        label = 3;
        LegacyLoadUseCase.loadFailure(2, new LegacyLoadUseCase$invoke$1(..));
        if (if-ne(LegacyLoadUseCase.loadFailure(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_172;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_149:
      L_151:
      L_154:
        ExceptionExtensionsKt.retrieveUnityCrashValue(LegacyLoadUseCase.loadFailure(..));
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "Internal error", LegacyLoadUseCase.loadFailure(..), "uncaught_exception", ExceptionExtensionsKt.retrieveUnityCrashValue(..));
        L$0 = 0;
        L$1 = 0;
        label = 4;
        LegacyLoadUseCase.loadFailure(new LoadResult$Failure, new LegacyLoadUseCase$invoke$1(..));
        if (if-ne(LegacyLoadUseCase.loadFailure(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_172;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_172:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyShowUseCase
// ============================================================
package com.unity3d.ads.core.domain;

public final class LegacyShowUseCase {
    public static final LegacyShowUseCase$Companion Companion = null;
    public static final String KEY_OBJECT_ID = "objectId";
    public static final String MESSAGE_AD_PLAYER_UNAVAILABLE = "Ad player is unavailable.";
    public static final String MESSAGE_ALREADY_SHOWING = "Can't show a new ad unit when ad unit is already open";
    public static final String MESSAGE_NO_AD_OBJECT = "No ad object found for opportunity id: ";
    public static final String MESSAGE_OPPORTUNITY_ID = "No valid opportunity id provided";
    public static final String MESSAGE_OPT_TIMEOUT = "timeout";
    public static final String MESSAGE_TIMEOUT = "[UnityAds] Timeout while trying to show ";
    public static final String MSG_OPPORTUNITY_AND_PLACEMENT_NOT_MATCHING = "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad";
    private static boolean isFullscreenAdShowing;
    private AdObject adObject;
    private final AdRepository adRepository;
    private final CoroutineDispatcher dispatcher;
    private final GetInitializationState getInitializationState;
    private final GetOperativeEventApi getOperativeEventApi;
    private final MutableStateFlow hasStarted;
    private String placement;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private final Show show;
    private final MutableStateFlow timeoutCancellationRequested;
    private UnityAdsShowOptions unityAdsShowOptions;

    static <clinit>() {
        new LegacyShowUseCase$Companion(0);
        Companion = new LegacyShowUseCase$Companion(..);
        return;
    }

    public LegacyShowUseCase(CoroutineDispatcher p0, Show p1, AdRepository p2, SendDiagnosticEvent p3, GetOperativeEventApi p4, GetInitializationState p5, SessionRepository p6) {
        new Object();
        dispatcher = p0;
        show = p1;
        adRepository = p2;
        sendDiagnosticEvent = p3;
        getOperativeEventApi = p4;
        getInitializationState = p5;
        sessionRepository = p6;
        Boolean.valueOf(0);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        hasStarted = StateFlowKt.MutableStateFlow(..);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        timeoutCancellationRequested = StateFlowKt.MutableStateFlow(..);
        return;
    }

    public static final void access$bannerLeftApplication(LegacyShowUseCase p0, TimeMark p1, String p2, Listeners p3) {
        p0.bannerLeftApplication(p1, p2, p3);
        return;
    }

    public static final void access$cancelTimeout(LegacyShowUseCase p0, TimeMark p1) {
        p0.cancelTimeout(p1);
        return;
    }

    public static final AdObject access$getAdObject$p(LegacyShowUseCase p0) {
        return adObject;
    }

    public static final CoroutineDispatcher access$getDispatcher$p(LegacyShowUseCase p0) {
        return dispatcher;
    }

    public static final MutableStateFlow access$getHasStarted$p(LegacyShowUseCase p0) {
        return hasStarted;
    }

    public static final SendDiagnosticEvent access$getSendDiagnosticEvent$p(LegacyShowUseCase p0) {
        return sendDiagnosticEvent;
    }

    public static final Show access$getShow$p(LegacyShowUseCase p0) {
        return show;
    }

    public static final Map access$getTags(LegacyShowUseCase p0, String p1, Integer p2, String p3) {
        p0.getTags(p1, p2, p3);
        return LegacyShowUseCase.getTags(..);
    }

    public static final MutableStateFlow access$getTimeoutCancellationRequested$p(LegacyShowUseCase p0) {
        return timeoutCancellationRequested;
    }

    public static final Object access$getTmpAdObject(LegacyShowUseCase p0, Continuation p1) {
        p0.getTmpAdObject(p1);
        return LegacyShowUseCase.getTmpAdObject(..);
    }

    public static final Object access$sendOperativeError(LegacyShowUseCase p0, OperativeEventRequestOuterClass$OperativeEventErrorType p1, String p2, AdObject p3, Continuation p4) {
        p0.sendOperativeError(p1, p2, p3, p4);
        return LegacyShowUseCase.sendOperativeError(..);
    }

    public static final void access$setFullscreenAdShowing$cp(boolean p0) {
        isFullscreenAdShowing = p0;
        return;
    }

    public static final Object access$showClicked(LegacyShowUseCase p0, TimeMark p1, String p2, Listeners p3, Continuation p4) {
        p0.showClicked(p1, p2, p3, p4);
        return LegacyShowUseCase.showClicked(..);
    }

    public static final Object access$showCompleted(LegacyShowUseCase p0, TimeMark p1, String p2, ShowStatus p3, Listeners p4, Continuation p5) {
        p0.showCompleted(p1, p2, p3, p4, p5);
        return LegacyShowUseCase.showCompleted(..);
    }

    public static final Object access$showStart(LegacyShowUseCase p0, Continuation p1) {
        p0.showStart(p1);
        return LegacyShowUseCase.showStart(..);
    }

    public static final Object access$showStarted(LegacyShowUseCase p0, TimeMark p1, String p2, Listeners p3, Continuation p4) {
        p0.showStarted(p1, p2, p3, p4);
        return LegacyShowUseCase.showStarted(..);
    }

    private final void bannerLeftApplication(TimeMark p0, String p1, Listeners p2) {
        new StringBuilder("Unity Ads Show Left Application for placement ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        TimeExtensionsKt.elapsedMillis(p0);
        Double.valueOf(TimeExtensionsKt.elapsedMillis(..), v4);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_show_left_app", Double.valueOf(..), 0, 0, adObject, 12, 0);
        p2.onLeftApplication(p1);
        return;
    }

    private final void cancelTimeout(TimeMark p0) {
        Boolean.valueOf(1);
        timeoutCancellationRequested.setValue(Boolean.valueOf(..));
        TimeExtensionsKt.elapsedMillis(p0);
        Double.valueOf(TimeExtensionsKt.elapsedMillis(..), Boolean.valueOf(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_show_cancel_timeout", Double.valueOf(..), 0, 0, adObject, 12, 0);
        return;
    }

    private final String getOpportunityId(UnityAdsShowOptions p0) {
        p0.getData();
        if (if-eqz(UnityAdsShowOptions.getData(..))) goto L_14;
        UnityAdsShowOptions.getData(..).opt("objectId");
        if (if-eqz(JSONObject.opt(..))) goto L_14;
        JSONObject.opt(..).toString();
      L_14:
      L_15:
        UUID.fromString(0);
        UUID.fromString(..).toString();
        return UUID.toString(..);
    }

    private final Map getTags(String p0, Integer p1, String p2) {
        OperationType.SHOW.toString();
        TuplesKt.to("operation", OperationType.toString(..));
        TuplesKt.to("reason", p0);
        hasStarted.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        String.valueOf(Boolean.booleanValue(..));
        TuplesKt.to("show_has_started", String.valueOf(..));
        MapsKt.mutableMapOf(3);
        if (if-eqz(p1)) goto L_4c;
        p1.intValue();
        String.valueOf(Number.intValue(..));
        MapsKt.mutableMapOf(..).put("reason_code", String.valueOf(..));
      L_4c:
        if (if-eqz(p2)) goto L_53;
        MapsKt.mutableMapOf(..).put("reason_debug", p2);
      L_53:
        return MapsKt.mutableMapOf(..);
    }

    private final Object getTmpAdObject(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new LegacyShowUseCase$getTmpAdObject$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_36;
        if (if-ne(label, 1)) goto L_2e;
        ResultKt.throwOnFailure(result);
      L_2e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_36:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        if (if-eqz(unityAdsShowOptions)) goto L_42;
        LegacyShowUseCase.getOpportunityId(unityAdsShowOptions);
      L_42:
      L_43:
        UUID.fromString(0);
        ProtobufExtensionsKt.toByteString(UUID.fromString(..));
        L$0 = this;
        label = 1;
        adRepository.getAd(ProtobufExtensionsKt.toByteString(..), "call to 'resume' before 'invoke' with coroutine");
        if (if-ne(AdRepository.getAd(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_5d;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_5d:
      L_5e:
        if (if-eqz(AdRepository.getAd(..))) goto L_63;
        return AdRepository.getAd(..);
      L_63:
        if (if-nez(unityAdsShowOptions)) goto L_6c;
        new UnityAdsShowOptions();
      L_6c:
        LegacyShowUseCase.getOpportunityId(new UnityAdsShowOptions(..));
        if (if-eqz(LegacyShowUseCase.getOpportunityId(..))) goto L_7a;
        ProtobufExtensionsKt.toISO8859ByteString(LegacyShowUseCase.getOpportunityId(..));
        if (if-nez(ProtobufExtensionsKt.toISO8859ByteString(..))) goto L_7c;
      L_7a:
      L_7c:
        if (if-nez(placement)) goto L_88;
      L_88:
        new UnityAdsLoadOptions();
        Boxing.boxBoolean(0);
        new AdObject(ByteString.EMPTY, "", ByteString.EMPTY, 0, 0, new UnityAdsLoadOptions(..), Boxing.boxBoolean(..), DiagnosticEventRequestOuterClass$DiagnosticAdType.DIAGNOSTIC_AD_TYPE_UNSPECIFIED, 16, 0);
        return new AdObject;
    }

    private final Object sendOperativeError(OperativeEventRequestOuterClass$OperativeEventErrorType p0, String p1, AdObject p2, Continuation p3) {
        OperativeEventRequestOuterClass$OperativeEventErrorData.newBuilder();
        OperativeEventErrorDataKt$Dsl$Companion._create(OperativeEventRequestOuterClass$OperativeEventErrorData.newBuilder(..));
        OperativeEventErrorDataKt$Dsl.setErrorType(p0);
        OperativeEventErrorDataKt$Dsl.setMessage(p1);
        OperativeEventErrorDataKt$Dsl._build();
        OperativeEventRequestOuterClass$OperativeEventErrorData.toByteString();
        getOperativeEventApi.invoke(OperativeEventRequestOuterClass$OperativeEventType.OPERATIVE_EVENT_TYPE_SHOW_ERROR, p2, OperativeEventRequestOuterClass$OperativeEventErrorData.toByteString(..), p3);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(GetOperativeEventApi.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_31;
        return GetOperativeEventApi.invoke(..);
      L_31:
        return Unit.INSTANCE;
    }

    private final Object showClicked(TimeMark p0, String p1, Listeners p2, Continuation p3) {
        new StringBuilder("Unity Ads Show Clicked for placement ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        TimeExtensionsKt.elapsedMillis(p0);
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), v4);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_show_clicked", Boxing.boxDouble(..), 0, 0, adObject, 12, 0);
        new LegacyShowUseCase$showClicked$2(p2, p1, 0);
        BuildersKt.withContext(dispatcher, new LegacyShowUseCase$showClicked$2(..), p3);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_3e;
        return BuildersKt.withContext(..);
      L_3e:
        return Unit.INSTANCE;
    }

    private final Object showCompleted(TimeMark p0, String p1, ShowStatus p2, Listeners p3, Continuation p4) {
        new StringBuilder("Unity Ads Show Completed for placement ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        TimeExtensionsKt.elapsedMillis(p0);
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), v4);
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_show_success_time", Boxing.boxDouble(..), 0, 0, adObject, 12, 0);
        new LegacyShowUseCase$showCompleted$2(p3, p1, p2, 0);
        BuildersKt.withContext(dispatcher, new LegacyShowUseCase$showCompleted$2(..), p4);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_3e;
        return BuildersKt.withContext(..);
      L_3e:
        return Unit.INSTANCE;
    }

    private final Function6 showError(TimeMark p0, String p1, Listeners p2) {
        new LegacyShowUseCase$showError$1(p1, this, p0, p2, 0);
        return new LegacyShowUseCase$showError$1;
    }

    private final Object showStart(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new LegacyShowUseCase$showStart$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_3a;
        if (if-ne(label, 1)) goto L_32;
        ResultKt.throwOnFailure(result);
      L_32:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_3a:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        L$0 = sendDiagnosticEvent;
        L$1 = "native_show_started";
        label = 1;
        LegacyShowUseCase.getTmpAdObject("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(LegacyShowUseCase.getTmpAdObject(..), L$1)) goto L_4e;
        return L$1;
      L_4e:
      L_52:
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_show_started", 0, 0, 0, LegacyShowUseCase.getTmpAdObject(..), 14, 0);
        return Unit.INSTANCE;
    }

    private final Object showStarted(TimeMark p0, String p1, Listeners p2, Continuation p3) {
        new StringBuilder("Unity Ads Show WV Start for placement ");
        new StringBuilder(..).append(p1);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        Boxing.boxBoolean(1);
        hasStarted.setValue(Boxing.boxBoolean(..));
        TimeExtensionsKt.elapsedMillis(p0);
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), Boxing.boxBoolean(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default(sendDiagnosticEvent, "native_show_wv_started", Boxing.boxDouble(..), 0, 0, adObject, 12, 0);
        new LegacyShowUseCase$showStarted$2(p2, p1, 0);
        BuildersKt.withContext(dispatcher, new LegacyShowUseCase$showStarted$2(..), p3);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(BuildersKt.withContext(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_48;
        return BuildersKt.withContext(..);
      L_48:
        return Unit.INSTANCE;
    }

    public final Object invoke(Context p0, String p1, UnityAdsShowOptions p2, Listeners p3, Continuation p4) {
        if (if-eqz(v4)) goto L_1c;
        if (if-eqz(label)) goto L_1c;
        label = label;
      L_1c:
        new LegacyShowUseCase$invoke$1(this, label);
      L_21:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
        ResultKt.throwOnFailure(result);
        ResultKt.throwOnFailure(result);
        ResultKt.throwOnFailure(result);
        ResultKt.throwOnFailure(result);
        ResultKt.throwOnFailure(result);
        ResultKt.throwOnFailure(result);
        ResultKt.throwOnFailure(result);
        ResultKt.throwOnFailure(result);
        ResultKt.throwOnFailure(result);
        ResultKt.throwOnFailure(result);
        ResultKt.throwOnFailure(result);
        TimeSource$Monotonic.INSTANCE.markNow-z9LOYto();
        placement = J$0;
        unityAdsShowOptions = L$3;
        new StringBuilder("Unity Ads Show Start for placement ");
        new StringBuilder(..).append(J$0);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        L$0 = this;
        L$1 = p0;
        L$2 = J$0;
        L$3 = L$3;
        L$4 = p3;
        J$0 = TimeSource$Monotonic.markNow-z9LOYto(..);
        label = 1;
        LegacyShowUseCase.showStart(new LegacyShowUseCase$invoke$1(..));
        if (if-ne(LegacyShowUseCase.showStart(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_dc;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_dc:
      L_e0:
        TimeSource$Monotonic$ValueTimeMark.box-impl(TimeSource$Monotonic.markNow-z9LOYto(..), L$1);
        if (if-nez(J$0)) goto L_e9;
      L_e9:
      L_ea:
        LegacyShowUseCase.showError(TimeSource$Monotonic$ValueTimeMark.box-impl(..), J$0, p3);
        if (if-nez(J$0)) goto L_111;
        L$0 = 0;
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        L$4 = 0;
        label = 2;
        LegacyShowUseCase.showError(..).invoke("placement_null", UnityAds$UnityAdsShowError.INVALID_ARGUMENT, "[UnityAds] Placement ID cannot be null", 0, 0, new LegacyShowUseCase$invoke$1(..));
        if (if-ne(Function6.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_10e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_10e:
        return Unit.INSTANCE;
      L_111:
        getInitializationState.invoke();
        if (if-eq(GetInitializationState.invoke(..), InitializationState.INITIALIZED)) goto L_13c;
        L$0 = "[UnityAds] Placement ID cannot be null";
        L$1 = "[UnityAds] Placement ID cannot be null";
        L$2 = "[UnityAds] Placement ID cannot be null";
        L$3 = "[UnityAds] Placement ID cannot be null";
        L$4 = "[UnityAds] Placement ID cannot be null";
        label = 3;
        Unit.INSTANCE.invoke("not_initialized", UnityAds$UnityAdsShowError.NOT_INITIALIZED, "[UnityAds] SDK not initialized", 0, 0, new LegacyShowUseCase$invoke$1(..));
        if (if-ne(Function6.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_139;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_139:
        return Unit.INSTANCE;
      L_13c:
        if (if-eqz("[UnityAds] SDK not initialized")) goto L_143;
        LegacyShowUseCase.getOpportunityId("[UnityAds] SDK not initialized");
      L_143:
      L_144:
        if (if-nez("[UnityAds] SDK not initialized")) goto L_167;
        L$0 = "[UnityAds] SDK not initialized";
        L$1 = "[UnityAds] SDK not initialized";
        L$2 = "[UnityAds] SDK not initialized";
        L$3 = "[UnityAds] SDK not initialized";
        L$4 = "[UnityAds] SDK not initialized";
        label = 4;
        Unit.INSTANCE.invoke("no_opportunity_id", UnityAds$UnityAdsShowError.INVALID_ARGUMENT, "No valid opportunity id provided", 0, 0, new LegacyShowUseCase$invoke$1(..));
        if (if-ne(Function6.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_164;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_164:
        return Unit.INSTANCE;
      L_167:
        UUID.fromString(4);
        ProtobufExtensionsKt.toByteString(UUID.fromString(..));
        L$0 = this;
        L$1 = p0;
        L$2 = 0;
        L$3 = "No valid opportunity id provided";
        L$4 = Unit.INSTANCE;
        L$5 = Unit.INSTANCE;
        L$6 = 4;
        J$0 = TimeSource$Monotonic.markNow-z9LOYto(..);
        label = 5;
        adRepository.getAd(ProtobufExtensionsKt.toByteString(..), new LegacyShowUseCase$invoke$1(..));
        if (if-ne(AdRepository.getAd(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_190;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_190:
      L_198:
        adObject = AdRepository.getAd(..);
        if (if-nez(AdRepository.getAd(..))) goto L_1d1;
        new StringBuilder("No ad object found for opportunity id: ");
        new StringBuilder(..).append(4);
        new StringBuilder(..).toString();
        L$0 = "No valid opportunity id provided";
        L$1 = "No valid opportunity id provided";
        L$2 = "No valid opportunity id provided";
        L$3 = "No valid opportunity id provided";
        L$4 = "No valid opportunity id provided";
        L$5 = "No valid opportunity id provided";
        L$6 = "No valid opportunity id provided";
        label = 6;
        Unit.INSTANCE.invoke("ad_object_not_found", UnityAds$UnityAdsShowError.INTERNAL_ERROR, StringBuilder.toString(..), 0, 0, new LegacyShowUseCase$invoke$1(..));
        if (if-ne(Function6.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1ce;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_1ce:
        return Unit.INSTANCE;
      L_1d1:
        0.getAdPlayer();
        if (if-eqz(AdObject.getAdPlayer(..))) goto L_1e5;
        AdObject.getAdPlayer(..).getScope();
        if (if-eqz(AdPlayer.getScope(..))) goto L_1e5;
        CoroutineScopeKt.isActive(AdPlayer.getScope(..));
        if (if-nez(CoroutineScopeKt.isActive(..))) goto L_1e5;
      L_1e5:
      L_1e6:
        if (if-eqz(0)) goto L_20e;
        L$0 = StringBuilder.toString(..);
        L$1 = StringBuilder.toString(..);
        L$2 = StringBuilder.toString(..);
        L$3 = StringBuilder.toString(..);
        L$4 = StringBuilder.toString(..);
        L$5 = StringBuilder.toString(..);
        L$6 = StringBuilder.toString(..);
        label = 7;
        0.invoke("ad_player_scope_not_active", UnityAds$UnityAdsShowError.INTERNAL_ERROR, "Ad player is unavailable.", 0, 0, new LegacyShowUseCase$invoke$1(..));
        if (if-ne(Function6.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_20b;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_20b:
        return Unit.INSTANCE;
      L_20e:
        0.getAdPlayer();
        if (if-nez(AdObject.getAdPlayer(..))) goto L_241;
        if (if-eqz(LegacyShowUseCase.isFullscreenAdShowing)) goto L_241;
        L$0 = "Ad player is unavailable.";
        L$1 = "Ad player is unavailable.";
        L$2 = "Ad player is unavailable.";
        L$3 = "Ad player is unavailable.";
        L$4 = "Ad player is unavailable.";
        L$5 = "Ad player is unavailable.";
        L$6 = "Ad player is unavailable.";
        label = 8;
        0.invoke("already_showing", UnityAds$UnityAdsShowError.ALREADY_SHOWING, "Can't show a new ad unit when ad unit is already open", 0, 0, new LegacyShowUseCase$invoke$1(..));
        if (if-ne(Function6.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_23e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_23e:
        return Unit.INSTANCE;
      L_241:
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getFeatureFlags();
        NativeConfigurationOuterClass$FeatureFlags.getOpportunityIdPlacementValidation();
        if (if-eqz(NativeConfigurationOuterClass$FeatureFlags.getOpportunityIdPlacementValidation(..))) goto L_282;
        0.getPlacementId();
        Intrinsics.areEqual(AdObject.getPlacementId(..), 0);
        if (if-nez(Intrinsics.areEqual(..))) goto L_282;
        L$0 = "Can't show a new ad unit when ad unit is already open";
        L$1 = "Can't show a new ad unit when ad unit is already open";
        L$2 = "Can't show a new ad unit when ad unit is already open";
        L$3 = "Can't show a new ad unit when ad unit is already open";
        L$4 = "Can't show a new ad unit when ad unit is already open";
        L$5 = "Can't show a new ad unit when ad unit is already open";
        L$6 = "Can't show a new ad unit when ad unit is already open";
        label = 9;
        0.invoke("placement_validation", UnityAds$UnityAdsShowError.INVALID_ARGUMENT, "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad", 0, 0, new LegacyShowUseCase$invoke$1(..));
        if (if-ne(Function6.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_27f;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_27f:
        return Unit.INSTANCE;
      L_282:
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getAdOperations();
        NativeConfigurationOuterClass$AdOperationsConfiguration.getShowTimeoutMs();
        if (if-nez(9)) goto L_296;
        isFullscreenAdShowing = 1;
      L_296:
        show.invoke(p0, 0, "No valid opportunity id provided");
        new LegacyShowUseCase$invoke$2(this, 9, 0, 1, 0, 0, 0);
        FlowExtensionsKt.timeoutAfter$default(Show.invoke(..), NativeConfigurationOuterClass$AdOperationsConfiguration.getShowTimeoutMs(..), 9, 0, new LegacyShowUseCase$invoke$2, 2, 0);
        new LegacyShowUseCase$invoke$3(0, 9, "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad");
        FlowKt.catch(FlowExtensionsKt.timeoutAfter$default(..), new LegacyShowUseCase$invoke$3(..));
        new LegacyShowUseCase$invoke$4(this, TimeSource$Monotonic.markNow-z9LOYto(..), v19, 0, Unit.INSTANCE, 0, 0);
        L$0 = "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad";
        L$1 = "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad";
        L$2 = "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad";
        L$3 = "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad";
        L$4 = "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad";
        L$5 = "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad";
        L$6 = "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad";
        I$0 = 9;
        label = 10;
        FlowKt.catch(..).collect(new LegacyShowUseCase$invoke$4, new LegacyShowUseCase$invoke$1(..));
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_2fd;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_2fd:
      L_2fe:
        if (if-nez(9)) goto L_303;
        isFullscreenAdShowing = 0;
      L_303:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.Load
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class Load {
    public abstract Object invoke(Context p0, String p1, ByteString p2, HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup p3, AdRequestOuterClass$BannerSize p4, UnityAdsLoadOptions p5, Continuation p6) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.Refresh
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class Refresh {
    public abstract Object invoke(ByteString p0, ByteString p1, Continuation p2) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.RemoveUrlQuery
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class RemoveUrlQuery {
    public abstract String invoke(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.SendDiagnosticEvent
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class SendDiagnosticEvent {
    public static final String APP_ACTIVE = "app_active";
    public static final String ATTEMPT_INSERT_NULL_DIAGNOSTIC_EVENT = "attempt_insert_null_diagnostic_event";
    public static final String AWAITED_INIT = "awaited_init";
    public static final String BILLING_SERVICE_UNAVAILABLE = "billing_service_unavailable";
    public static final String BRIDGE_SEND_EVENT_FAILED = "bridge_send_event_failed";
    public static final String CACHE_SOURCE = "cache_source";
    public static final String COMPLETE_STATE = "complete_state";
    public static final String COROUTINE_NAME = "coroutine_name";
    public static final SendDiagnosticEvent$Companion Companion = null;
    public static final String HB_FAILURE = "native_gateway_token_failure_time";
    public static final String HB_STARTED = "native_gateway_token_started";
    public static final String HB_SUCCESS = "native_gateway_token_success_time";
    public static final String INIT_CLEAR_CACHE = "native_initialize_clear_cache_time";
    public static final String INIT_COMPLETED_FAILURE = "native_initialize_completed_task_failure_time";
    public static final String INIT_COMPLETED_STARTED = "native_initialization_completed_started";
    public static final String INIT_COMPLETED_SUCCESS = "native_initialize_completed_task_success_time";
    public static final String INIT_FAILURE = "native_initialize_task_failure_time";
    public static final String INIT_MISSED_NATIVE_PARSING = "native_initialize_missed_native_parsing";
    public static final String INIT_STARTED = "native_initialization_started";
    public static final String INIT_SUCCESS = "native_initialize_task_success_time";
    public static final String LOAD_CACHE_FAILURE = "native_load_cache_failure_time";
    public static final String LOAD_CACHE_SUCCESS = "native_load_cache_success_time";
    public static final String LOAD_FAILURE = "native_load_failure_time";
    public static final String LOAD_STARTED = "native_load_started";
    public static final String LOAD_STARTED_AD_VIEWER = "native_load_started_ad_viewer";
    public static final String LOAD_SUCCESS = "native_load_success_time";
    public static final String NETWORK_CLIENT = "network_client";
    public static final String NETWORK_FAILURE = "native_network_failure_time";
    public static final String NETWORK_PARSE = "native_network_parse_failure";
    public static final String NETWORK_SUCCESS = "native_network_success_time";
    public static final String NULL_DIAGNOSTIC_EVENT = "null_diagnostic_event";
    public static final String OM_ACTIVATE_FAILURE = "om_activate_failure_time";
    public static final String OM_ACTIVATE_STARTED = "om_activate_started";
    public static final String OM_ACTIVATE_SUCCESS = "om_activate_success_time";
    public static final String OM_IMPRESSION_OCCURRED_FAILURE = "om_impression_occurred_failure";
    public static final String OM_IMPRESSION_OCCURRED_SUCCESS = "om_impression_occurred_success";
    public static final String OM_SESSION_FINISH_FAILURE = "om_session_finish_failure";
    public static final String OM_SESSION_FINISH_SUCCESS = "om_session_finish_success";
    public static final String OM_SESSION_START_FAILURE = "om_session_start_failure";
    public static final String OM_SESSION_START_SUCCESS = "om_session_start_success";
    public static final String OPERATION = "operation";
    public static final String PROTOCOL = "protocol";
    public static final String REASON = "reason";
    public static final String REASON_AD_MARKUP_PARSE = "invalid_admarkup";
    public static final String REASON_AD_OBJECT_NOT_FOUND = "ad_object_not_found";
    public static final String REASON_AD_PLAYER_SCOPE = "ad_player_scope_not_active";
    public static final String REASON_AD_VIEWER = "adviewer";
    public static final String REASON_ALREADY_SHOWING = "already_showing";
    public static final String REASON_CODE = "reason_code";
    public static final String REASON_DEBUG = "reason_debug";
    public static final String REASON_GATEWAY = "gateway";
    public static final String REASON_INVALID_ENTRY_POINT = "invalid_url";
    public static final String REASON_LISTENER_NULL = "listener_null";
    public static final String REASON_NETWORK = "network";
    public static final String REASON_NOT_INITIALIZED = "not_initialized";
    public static final String REASON_NO_FILL = "no_fill";
    public static final String REASON_NO_WEBVIEW_ENTRY_POINT = "no_webview_entry_point";
    public static final String REASON_OM_ALREADY_ACTIVE = "om_already_active";
    public static final String REASON_OM_CREATIVE_TYPE_INVALID = "om_creative_type_invalid";
    public static final String REASON_OM_CREATIVE_TYPE_NULL = "om_creative_type_null";
    public static final String REASON_OM_NOT_ACTIVE = "om_not_active";
    public static final String REASON_OM_SESSION_ALREADY_EXISTS = "om_session_already_exists";
    public static final String REASON_OM_SESSION_NOT_FOUND = "om_session_not_found";
    public static final String REASON_OPPORTUNITY_ID = "no_opportunity_id";
    public static final String REASON_OPPORTUNITY_USED = "opportunity_id_used";
    public static final String REASON_PLACEMENT_NULL = "placement_null";
    public static final String REASON_PLACEMENT_VALIDATION = "placement_validation";
    public static final String REASON_PROTOBUF_PARSING = "protobuf_parsing";
    public static final String REASON_TIMEOUT = "timeout";
    public static final String REASON_UNCAUGHT_EXCEPTION = "uncaught_exception";
    public static final String REASON_UNKNOWN = "unknown";
    public static final String RETRIES = "retries";
    public static final String SAME_SESSION = "same_session";
    public static final String SHOW_CANCEL_TIMEOUT = "native_show_cancel_timeout";
    public static final String SHOW_CLICKED = "native_show_clicked";
    public static final String SHOW_FAILURE = "native_show_failure_time";
    public static final String SHOW_HAS_STARTED = "show_has_started";
    public static final String SHOW_IS_FILE_CACHED_FAILURE = "native_show_is_file_cached_failure_time";
    public static final String SHOW_IS_FILE_CACHED_SUCCESS = "native_show_is_file_cached_success_time";
    public static final String SHOW_LEFT_APPLICATION = "native_show_left_app";
    public static final String SHOW_STARTED = "native_show_started";
    public static final String SHOW_STARTED_AD_VIEWER = "native_show_started_ad_viewer";
    public static final String SHOW_SUCCESS = "native_show_success_time";
    public static final String SHOW_WV_STARTED = "native_show_wv_started";
    public static final String SIZE_KB = "size_kb";
    public static final String STATE = "state";
    public static final String SYNC = "sync";
    public static final String SYSTEM_CRONET_FAILURE = "native_cronet_failure_time";
    public static final String SYSTEM_CRONET_SUCCESS = "native_cronet_success_time";
    public static final String URL = "url";
    public static final String WEBVIEW_ERROR = "webview_error";
    public static final String WEBVIEW_ERROR_CODE = "webview_error_code";
    public static final String WEBVIEW_URL = "webview_url";

    static <clinit>() {
        Companion = SendDiagnosticEvent$Companion.$$INSTANCE;
        return;
    }

    public abstract void invoke(String p0, Double p1, Map p2, Map p3, AdObject p4) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.SendPrivacyUpdateRequest
// ============================================================
package com.unity3d.ads.core.domain;

public final class SendPrivacyUpdateRequest {
    private final GatewayClient gatewayClient;
    private final GetPrivacyUpdateRequest getPrivacyUpdateRequest;
    private final GetRequestPolicy getRequestPolicy;

    public SendPrivacyUpdateRequest(GetPrivacyUpdateRequest p0, GetRequestPolicy p1, GatewayClient p2) {
        new Object();
        getPrivacyUpdateRequest = p0;
        getRequestPolicy = p1;
        gatewayClient = p2;
        return;
    }

    public final Object invoke(int p0, ByteString p1, Continuation p2) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new SendPrivacyUpdateRequest$invoke$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_3e;
        if (if-eq(label, 1)) goto L_36;
        if (if-ne(label, 2)) goto L_2e;
        ResultKt.throwOnFailure(result);
      L_2e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_36:
        ResultKt.throwOnFailure(result);
      L_3e:
        ResultKt.throwOnFailure(result);
        L$0 = this;
        label = 1;
        getPrivacyUpdateRequest.invoke(L$0, "call to 'resume' before 'invoke' with coroutine", new SendPrivacyUpdateRequest$invoke$1(..));
        if (if-ne(GetPrivacyUpdateRequest.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_4e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_4e:
      L_4f:
        getRequestPolicy.invoke();
        L$0 = 0;
        label = 2;
        GatewayClient$DefaultImpls.request$default(gatewayClient, 0, GetPrivacyUpdateRequest.invoke(..), GetRequestPolicy.invoke(..), OperationType.PRIVACY_UPDATE, new SendPrivacyUpdateRequest$invoke$1(..), 1, 0);
        if (if-ne(GatewayClient$DefaultImpls.request$default(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_6c;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_6c:
        UniversalResponseOuterClass$UniversalResponse.getPayload();
        UniversalResponseOuterClass$UniversalResponse$Payload.getPrivacyUpdateResponse();
        return UniversalResponseOuterClass$UniversalResponse$Payload.getPrivacyUpdateResponse(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.SendWebViewClientErrorDiagnostics
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class SendWebViewClientErrorDiagnostics {
    public abstract void invoke(List p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.SetInitializationState
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class SetInitializationState {
    public abstract void invoke(InitializationState p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.Show
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class Show {
    public abstract Flow invoke(Context p0, AdObject p1, UnityAdsShowOptions p2) {
        // native or abstract
    }

    public abstract Object terminate(AdObject p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.TriggerInitializationCompletedRequest
// ============================================================
package com.unity3d.ads.core.domain;

public abstract class TriggerInitializationCompletedRequest {
    public abstract Object invoke(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.TriggerInitializeListener
// ============================================================
package com.unity3d.ads.core.domain;

public final class TriggerInitializeListener {
    private final CoroutineDispatcher coroutineDispatcher;

    public TriggerInitializeListener(CoroutineDispatcher p0) {
        new Object();
        coroutineDispatcher = p0;
        return;
    }

    public final void error(UnityAds$UnityAdsInitializationError p0, String p1) {
        CoroutineScopeKt.CoroutineScope(coroutineDispatcher);
        new TriggerInitializeListener$error$1(p0, p1, 0);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(..), 0, 0, new TriggerInitializeListener$error$1(..), 3, 0);
        return;
    }

    public final void success() {
        CoroutineScopeKt.CoroutineScope(coroutineDispatcher);
        new TriggerInitializeListener$success$1(0);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(..), 0, 0, new TriggerInitializeListener$success$1(..), 3, 0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidBuildHeaderBiddingToken$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidBuildHeaderBiddingToken$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    Object result;
    final AndroidBuildHeaderBiddingToken this$0;

    AndroidBuildHeaderBiddingToken$invoke$1(AndroidBuildHeaderBiddingToken p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(this);
        return AndroidBuildHeaderBiddingToken.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidExecuteAdViewerRequest$invoke$2
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidExecuteAdViewerRequest$invoke$2 extends SuspendLambda {
    final Object[] $parameters;
    final RequestType $type;
    int label;
    final AndroidExecuteAdViewerRequest this$0;

    AndroidExecuteAdViewerRequest$invoke$2(AndroidExecuteAdViewerRequest p0, RequestType p1, Object[] p2, Continuation p3) {
        this$0 = p0;
        $type = p1;
        $parameters = p2;
        new SuspendLambda(2, p3);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidExecuteAdViewerRequest$invoke$2(this$0, $type, $parameters, p1);
        return new AndroidExecuteAdViewerRequest$invoke$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidExecuteAdViewerRequest$invoke$2.invoke(p0, p1);
        return AndroidExecuteAdViewerRequest$invoke$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidExecuteAdViewerRequest$invoke$2.create(p0, p1);
        AndroidExecuteAdViewerRequest$invoke$2.invokeSuspend(Unit.INSTANCE);
        return AndroidExecuteAdViewerRequest$invoke$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        AndroidExecuteAdViewerRequest.access$createRequest(this$0, $type, $parameters);
        AndroidExecuteAdViewerRequest.access$getHttpClient$p(this$0);
        label = 1;
        HttpClient.execute(AndroidExecuteAdViewerRequest.access$createRequest(..), this);
        if (if-ne(HttpClient.execute(..), "call to 'resume' before 'invoke' with coroutine")) goto L_36;
        return "call to 'resume' before 'invoke' with coroutine";
      L_36:
        return HttpClient.execute(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetAdDataRefreshRequest$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidGetAdDataRefreshRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    Object result;
    final AndroidGetAdDataRefreshRequest this$0;

    AndroidGetAdDataRefreshRequest$invoke$1(AndroidGetAdDataRefreshRequest p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, 0, this);
        return AndroidGetAdDataRefreshRequest.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetAdPlayerContext$Companion
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidGetAdPlayerContext$Companion {
    private AndroidGetAdPlayerContext$Companion() {
        new Object();
        return;
    }

    public AndroidGetAdPlayerContext$Companion(DefaultConstructorMarker p0) {
        new AndroidGetAdPlayerContext$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetAdPlayerContext$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidGetAdPlayerContext$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final AndroidGetAdPlayerContext this$0;

    AndroidGetAdPlayerContext$invoke$1(AndroidGetAdPlayerContext p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(this);
        return AndroidGetAdPlayerContext.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetAdRequest$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidGetAdRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    Object result;
    final AndroidGetAdRequest this$0;

    AndroidGetAdRequest$invoke$1(AndroidGetAdRequest p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, 0, 0, this);
        return AndroidGetAdRequest.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetInitializationCompletedRequest$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidGetInitializationCompletedRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    Object result;
    final AndroidGetInitializationCompletedRequest this$0;

    AndroidGetInitializationCompletedRequest$invoke$1(AndroidGetInitializationCompletedRequest p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(this);
        return AndroidGetInitializationCompletedRequest.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetInitializationData$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidGetInitializationData$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    Object result;
    final AndroidGetInitializationData this$0;

    AndroidGetInitializationData$invoke$1(AndroidGetInitializationData p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(this);
        return AndroidGetInitializationData.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetInitializationRequest$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidGetInitializationRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final AndroidGetInitializationRequest this$0;

    AndroidGetInitializationRequest$invoke$1(AndroidGetInitializationRequest p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(this);
        return AndroidGetInitializationRequest.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetInitializationRequestPayload$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidGetInitializationRequestPayload$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    Object result;
    final AndroidGetInitializationRequestPayload this$0;

    AndroidGetInitializationRequestPayload$invoke$1(AndroidGetInitializationRequestPayload p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(this);
        return AndroidGetInitializationRequestPayload.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetLimitedSessionToken$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidGetLimitedSessionToken$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    Object result;
    final AndroidGetLimitedSessionToken this$0;

    AndroidGetLimitedSessionToken$invoke$1(AndroidGetLimitedSessionToken p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(this);
        return AndroidGetLimitedSessionToken.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetUniversalRequestForPayLoad$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidGetUniversalRequestForPayLoad$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    Object result;
    final AndroidGetUniversalRequestForPayLoad this$0;

    AndroidGetUniversalRequestForPayLoad$invoke$1(AndroidGetUniversalRequestForPayLoad p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, this);
        return AndroidGetUniversalRequestForPayLoad.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetUniversalRequestSharedData$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidGetUniversalRequestSharedData$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    Object result;
    final AndroidGetUniversalRequestSharedData this$0;

    AndroidGetUniversalRequestSharedData$invoke$1(AndroidGetUniversalRequestSharedData p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(this);
        return AndroidGetUniversalRequestSharedData.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidGetWebViewContainerUseCase$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final AndroidGetWebViewContainerUseCase this$0;

    AndroidGetWebViewContainerUseCase$invoke$1(AndroidGetWebViewContainerUseCase p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, this);
        return AndroidGetWebViewContainerUseCase.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase$invoke$webview$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidGetWebViewContainerUseCase$invoke$webview$1 extends SuspendLambda {
    int label;
    final AndroidGetWebViewContainerUseCase this$0;

    AndroidGetWebViewContainerUseCase$invoke$webview$1(AndroidGetWebViewContainerUseCase p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidGetWebViewContainerUseCase$invoke$webview$1(this$0, p1);
        return new AndroidGetWebViewContainerUseCase$invoke$webview$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidGetWebViewContainerUseCase$invoke$webview$1.invoke(p0, p1);
        return AndroidGetWebViewContainerUseCase$invoke$webview$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidGetWebViewContainerUseCase$invoke$webview$1.create(p0, p1);
        AndroidGetWebViewContainerUseCase$invoke$webview$1.invokeSuspend(Unit.INSTANCE);
        return AndroidGetWebViewContainerUseCase$invoke$webview$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_73;
        ResultKt.throwOnFailure(p0);
        AndroidGetWebViewContainerUseCase.access$getContext$p(this$0);
        new WebView(AndroidGetWebViewContainerUseCase.access$getContext$p(..));
        new WebView(..).getSettings();
        WebView.getSettings(..).setAllowFileAccess(0);
        WebView.getSettings(..).setBlockNetworkImage(0);
        WebView.getSettings(..).setBlockNetworkLoads(0);
        WebView.getSettings(..).setBuiltInZoomControls(0);
        WebView.getSettings(..).setCacheMode(-1);
        WebView.getSettings(..).setDatabaseEnabled(0);
        WebView.getSettings(..).setDisplayZoomControls(0);
        WebView.getSettings(..).setDomStorageEnabled(0);
        WebView.getSettings(..).setGeolocationEnabled(0);
        WebView.getSettings(..).setJavaScriptCanOpenWindowsAutomatically(0);
        WebView.getSettings(..).setJavaScriptEnabled(1);
        WebView.getSettings(..).setLoadWithOverviewMode(0);
        WebView.getSettings(..).setLoadsImagesAutomatically(1);
        WebView.getSettings(..).setMediaPlaybackRequiresUserGesture(0);
        WebView.getSettings(..).setMixedContentMode(1);
        WebView.getSettings(..).setNeedInitialFocus(1);
        WebView.getSettings(..).setSupportMultipleWindows(0);
        WebView.getSettings(..).setSupportZoom(0);
        WebView.getSettings(..).setUseWideViewPort(1);
        WebView.getSettings(..).setMediaPlaybackRequiresUserGesture(0);
        AndroidGetWebViewContainerUseCase.access$getAndroidWebViewClient$p(this$0);
        new WebView(..).setWebViewClient(AndroidGetWebViewContainerUseCase.access$getAndroidWebViewClient$p(..));
        new WebView(..).setHorizontalScrollBarEnabled(0);
        new WebView(..).setVerticalScrollBarEnabled(0);
        new WebView(..).setInitialScale(0);
        new WebView(..).setBackgroundColor(0);
        new WebView(..).setBackgroundResource(0);
        return new WebView(..);
      L_73:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$cleanup$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidHandleGatewayAdResponse$cleanup$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final AndroidHandleGatewayAdResponse this$0;

    AndroidHandleGatewayAdResponse$cleanup$1(AndroidHandleGatewayAdResponse p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        AndroidHandleGatewayAdResponse.access$cleanup(this$0, 0, 0, 0, 0, this);
        return AndroidHandleGatewayAdResponse.access$cleanup(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidHandleGatewayAdResponse$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    boolean Z$0;
    int label;
    Object result;
    final AndroidHandleGatewayAdResponse this$0;

    AndroidHandleGatewayAdResponse$invoke$1(AndroidHandleGatewayAdResponse p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, 0, 0, 0, 0, 0, 0, this);
        return AndroidHandleGatewayAdResponse.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$2
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidHandleGatewayAdResponse$invoke$2 extends SuspendLambda {
    final Ref$ObjectRef $adPlayer;
    Object L$0;
    int label;

    AndroidHandleGatewayAdResponse$invoke$2(Ref$ObjectRef p0, Continuation p1) {
        $adPlayer = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidHandleGatewayAdResponse$invoke$2($adPlayer, p1);
        L$0 = p0;
        return new AndroidHandleGatewayAdResponse$invoke$2(..);
    }

    public final Object invoke(AllowedPiiOuterClass$AllowedPii p0, Continuation p1) {
        AndroidHandleGatewayAdResponse$invoke$2.create(p0, p1);
        AndroidHandleGatewayAdResponse$invoke$2.invokeSuspend(Unit.INSTANCE);
        return AndroidHandleGatewayAdResponse$invoke$2.invokeSuspend(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidHandleGatewayAdResponse$invoke$2.invoke(p0, p1);
        return AndroidHandleGatewayAdResponse$invoke$2.invoke(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        L$0.toByteArray();
        label = 1;
        element.onAllowedPiiChange(AllowedPiiOuterClass$AllowedPii.toByteArray(..), this);
        if (if-ne(AdPlayer.onAllowedPiiChange(..), "call to 'resume' before 'invoke' with coroutine")) goto L_39;
        return "call to 'resume' before 'invoke' with coroutine";
      L_39:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$3
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidHandleGatewayAdResponse$invoke$3 extends SuspendLambda {
    final ByteString $opportunityId;
    final String $placementId;
    Object L$0;
    int label;
    final AndroidHandleGatewayAdResponse this$0;

    AndroidHandleGatewayAdResponse$invoke$3(AndroidHandleGatewayAdResponse p0, ByteString p1, String p2, Continuation p3) {
        this$0 = p0;
        $opportunityId = p1;
        $placementId = p2;
        new SuspendLambda(2, p3);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidHandleGatewayAdResponse$invoke$3(this$0, $opportunityId, $placementId, p1);
        L$0 = p0;
        return new AndroidHandleGatewayAdResponse$invoke$3(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidHandleGatewayAdResponse$invoke$3.invoke(p0, p1);
        return AndroidHandleGatewayAdResponse$invoke$3.invoke(..);
    }

    public final Object invoke(Pair p0, Continuation p1) {
        AndroidHandleGatewayAdResponse$invoke$3.create(p0, p1);
        AndroidHandleGatewayAdResponse$invoke$3.invokeSuspend(Unit.INSTANCE);
        return AndroidHandleGatewayAdResponse$invoke$3.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_94;
        ResultKt.throwOnFailure(p0);
        L$0.component1();
        L$0.component2();
        Pair.component2(..).intValue();
        AndroidHandleGatewayAdResponse.access$getCampaignRepository$p(this$0);
        CampaignRepository.getCampaign($opportunityId);
        if (if-eqz(CampaignRepository.getCampaign(..))) goto L_58;
        CampaignRepository.getCampaign(..).toBuilder();
        CampaignKt$Dsl.Companion._create(CampaignStateOuterClass$Campaign.toBuilder(..));
        new String(Pair.component1(..), Charsets.ISO_8859_1);
        ProtobufExtensionsKt.fromBase64$default(new String(..), 0, 1, 0);
        CampaignKt$Dsl$Companion._create(..).setData(ProtobufExtensionsKt.fromBase64$default(..));
        CampaignKt$Dsl$Companion._create(..).setDataVersion(Number.intValue(..));
        CampaignKt$Dsl$Companion._create(..)._build();
        if (if-eqz(CampaignKt$Dsl._build(..))) goto L_58;
      L_58:
        CampaignStateOuterClass$Campaign.newBuilder();
        CampaignKt$Dsl.Companion._create(CampaignStateOuterClass$Campaign.newBuilder(..));
        new String(Pair.component1(..), Charsets.ISO_8859_1);
        ProtobufExtensionsKt.fromBase64$default(new String(..), 0, 1, 0);
        CampaignKt$Dsl$Companion._create(..).setData(ProtobufExtensionsKt.fromBase64$default(..));
        CampaignKt$Dsl$Companion._create(..).setDataVersion(Number.intValue(..));
        CampaignKt$Dsl$Companion._create(..).setPlacementId($placementId);
        CampaignKt$Dsl$Companion._create(..).setImpressionOpportunityId($opportunityId);
        CampaignKt$Dsl$Companion._create(..)._build();
      L_86:
        AndroidHandleGatewayAdResponse.access$getCampaignRepository$p(this$0);
        CampaignRepository.setCampaign($opportunityId, CampaignKt$Dsl._build(..));
        return Unit.INSTANCE;
      L_94:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$4
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidHandleGatewayAdResponse$invoke$4 extends SuspendLambda {
    final String $webViewUrl;
    final AndroidWebViewContainer $webviewContainer;
    int label;

    AndroidHandleGatewayAdResponse$invoke$4(AndroidWebViewContainer p0, String p1, Continuation p2) {
        $webviewContainer = p0;
        $webViewUrl = p1;
        new SuspendLambda(1, p2);
        return;
    }

    public final Continuation create(Continuation p0) {
        new AndroidHandleGatewayAdResponse$invoke$4($webviewContainer, $webViewUrl, p0);
        return new AndroidHandleGatewayAdResponse$invoke$4(..);
    }

    public Object invoke(Object p0) {
        AndroidHandleGatewayAdResponse$invoke$4.invoke(p0);
        return AndroidHandleGatewayAdResponse$invoke$4.invoke(..);
    }

    public final Object invoke(Continuation p0) {
        AndroidHandleGatewayAdResponse$invoke$4.create(p0);
        AndroidHandleGatewayAdResponse$invoke$4.invokeSuspend(Unit.INSTANCE);
        return AndroidHandleGatewayAdResponse$invoke$4.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        label = 1;
        $webviewContainer.loadUrl($webViewUrl, this);
        if (if-ne(AndroidWebViewContainer.loadUrl(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2a;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2a:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$5
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidHandleGatewayAdResponse$invoke$5 extends SuspendLambda {
    final Ref$ObjectRef $adPlayer;
    final LoadEvent $loadEvent;
    final ByteString $opportunityId;
    final AdResponseOuterClass$AdResponse $response;
    int label;
    final AndroidHandleGatewayAdResponse this$0;

    AndroidHandleGatewayAdResponse$invoke$5(AndroidHandleGatewayAdResponse p0, LoadEvent p1, ByteString p2, AdResponseOuterClass$AdResponse p3, Ref$ObjectRef p4, Continuation p5) {
        this$0 = p0;
        $loadEvent = p1;
        $opportunityId = p2;
        $response = p3;
        $adPlayer = p4;
        new SuspendLambda(2, p5);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidHandleGatewayAdResponse$invoke$5(this$0, $loadEvent, $opportunityId, $response, $adPlayer, p1);
        return new AndroidHandleGatewayAdResponse$invoke$5;
    }

    public Object invoke(Object p0, Object p1) {
        AndroidHandleGatewayAdResponse$invoke$5.invoke(p0, p1);
        return AndroidHandleGatewayAdResponse$invoke$5.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidHandleGatewayAdResponse$invoke$5.create(p0, p1);
        AndroidHandleGatewayAdResponse$invoke$5.invokeSuspend(Unit.INSTANCE);
        return AndroidHandleGatewayAdResponse$invoke$5.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        $loadEvent.getMessage();
        new Error(LoadEvent$Error.getMessage(..));
        label = 1;
        AndroidHandleGatewayAdResponse.access$cleanup(this$0, new Error(..), $opportunityId, $response, element, this);
        if (if-ne(AndroidHandleGatewayAdResponse.access$cleanup(..), "call to 'resume' before 'invoke' with coroutine")) goto L_42;
        return "call to 'resume' before 'invoke' with coroutine";
      L_42:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHandleGatewayAdResponse$invoke$6
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidHandleGatewayAdResponse$invoke$6 extends SuspendLambda {
    final Ref$ObjectRef $adPlayer;
    final ByteString $opportunityId;
    final AdResponseOuterClass$AdResponse $response;
    final CancellationException $t;
    int label;
    final AndroidHandleGatewayAdResponse this$0;

    AndroidHandleGatewayAdResponse$invoke$6(AndroidHandleGatewayAdResponse p0, CancellationException p1, ByteString p2, AdResponseOuterClass$AdResponse p3, Ref$ObjectRef p4, Continuation p5) {
        this$0 = p0;
        $t = p1;
        $opportunityId = p2;
        $response = p3;
        $adPlayer = p4;
        new SuspendLambda(2, p5);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidHandleGatewayAdResponse$invoke$6(this$0, $t, $opportunityId, $response, $adPlayer, p1);
        return new AndroidHandleGatewayAdResponse$invoke$6;
    }

    public Object invoke(Object p0, Object p1) {
        AndroidHandleGatewayAdResponse$invoke$6.invoke(p0, p1);
        return AndroidHandleGatewayAdResponse$invoke$6.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidHandleGatewayAdResponse$invoke$6.create(p0, p1);
        AndroidHandleGatewayAdResponse$invoke$6.invokeSuspend(Unit.INSTANCE);
        return AndroidHandleGatewayAdResponse$invoke$6.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        label = 1;
        AndroidHandleGatewayAdResponse.access$cleanup(this$0, $t, $opportunityId, $response, element, this);
        if (if-ne(AndroidHandleGatewayAdResponse.access$cleanup(..), "call to 'resume' before 'invoke' with coroutine")) goto L_37;
        return "call to 'resume' before 'invoke' with coroutine";
      L_37:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHandleGatewayInitializationResponse$invoke$2
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidHandleGatewayInitializationResponse$invoke$2 extends SuspendLambda {
    int label;
    final AndroidHandleGatewayInitializationResponse this$0;

    AndroidHandleGatewayInitializationResponse$invoke$2(AndroidHandleGatewayInitializationResponse p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidHandleGatewayInitializationResponse$invoke$2(this$0, p1);
        return new AndroidHandleGatewayInitializationResponse$invoke$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidHandleGatewayInitializationResponse$invoke$2.invoke(p0, p1);
        return AndroidHandleGatewayInitializationResponse$invoke$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidHandleGatewayInitializationResponse$invoke$2.create(p0, p1);
        AndroidHandleGatewayInitializationResponse$invoke$2.invokeSuspend(Unit.INSTANCE);
        return AndroidHandleGatewayInitializationResponse$invoke$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        AndroidHandleGatewayInitializationResponse.access$getTriggerInitializationCompletedRequest$p(this$0);
        label = 1;
        TriggerInitializationCompletedRequest.invoke(this);
        if (if-ne(TriggerInitializationCompletedRequest.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2c;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2c:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHandleGatewayUniversalResponse$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidHandleGatewayUniversalResponse$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final AndroidHandleGatewayUniversalResponse this$0;

    AndroidHandleGatewayUniversalResponse$invoke$1(AndroidHandleGatewayUniversalResponse p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, this);
        return AndroidHandleGatewayUniversalResponse.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHttpClientProvider$buildNetworkClient$2$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidHttpClientProvider$buildNetworkClient$2$1 {
    final Context $context;
    final CancellableContinuation $continuation;
    final ISDKDispatchers $dispatchers;
    final AndroidHttpClientProvider this$0;

    AndroidHttpClientProvider$buildNetworkClient$2$1(AndroidHttpClientProvider p0, Context p1, CancellableContinuation p2, ISDKDispatchers p3) {
        this$0 = p0;
        $context = p1;
        $continuation = p2;
        $dispatchers = p3;
        new Object();
        return;
    }

    public final void onComplete(Task p0) {
        p0.isSuccessful();
        if (if-eqz(Task.isSuccessful(..))) goto L_76;
        AndroidHttpClientProvider.access$getCronetEngineBuilderFactory$p(this$0);
        CronetEngineBuilderFactory.createCronetEngineBuilder($context);
        AndroidHttpClientProvider.access$buildCronetCachePath(this$0, $context);
        CronetEngine$Builder.setStoragePath(AndroidHttpClientProvider.access$buildCronetCachePath(..));
        CronetEngine$Builder.enableHttpCache(3, 5242880L, v2);
        CronetEngine$Builder.enableQuic(1);
        CronetEngine$Builder.enableQuic(..).addQuicHint("gateway.unityads.unity3d.com", 443, 443);
        CronetEngine$Builder.addQuicHint(..).addQuicHint("cdn-creatives-cf-prd.acquire.unity3dusercontent.com", 443, 443);
        CronetEngine$Builder.addQuicHint(..).build();
        new CronetClient(CronetEngine$Builder.build(..), $dispatchers);
        Result.constructor-impl(new CronetClient(..));
        $continuation.resumeWith(Result.constructor-impl(..));
        new OkHttpClient();
        new OkHttp3Client($dispatchers, new OkHttpClient(..));
        Result.constructor-impl(new OkHttp3Client(..));
        $continuation.resumeWith(Result.constructor-impl(..));
      L_76:
        new OkHttpClient();
        new OkHttp3Client($dispatchers, new OkHttpClient(..));
        Result.constructor-impl(new OkHttp3Client(..));
        $continuation.resumeWith(Result.constructor-impl(..));
      L_8f:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHttpClientProvider$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidHttpClientProvider$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    Object result;
    final AndroidHttpClientProvider this$0;

    AndroidHttpClientProvider$invoke$1(AndroidHttpClientProvider p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(this);
        return AndroidHttpClientProvider.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHttpClientProvider$invoke$client$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidHttpClientProvider$invoke$client$1 extends SuspendLambda {
    int label;
    final AndroidHttpClientProvider this$0;

    AndroidHttpClientProvider$invoke$client$1(AndroidHttpClientProvider p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidHttpClientProvider$invoke$client$1(this$0, p1);
        return new AndroidHttpClientProvider$invoke$client$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidHttpClientProvider$invoke$client$1.invoke(p0, p1);
        return AndroidHttpClientProvider$invoke$client$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidHttpClientProvider$invoke$client$1.create(p0, p1);
        AndroidHttpClientProvider$invoke$client$1.invokeSuspend(Unit.INSTANCE);
        return AndroidHttpClientProvider$invoke$client$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        AndroidHttpClientProvider.access$getContext$p(this$0);
        AndroidHttpClientProvider.access$getDispatchers$p(this$0);
        label = 1;
        AndroidHttpClientProvider.access$buildNetworkClient(this$0, AndroidHttpClientProvider.access$getContext$p(..), AndroidHttpClientProvider.access$getDispatchers$p(..), this);
        if (if-ne(AndroidHttpClientProvider.access$buildNetworkClient(..), "call to 'resume' before 'invoke' with coroutine")) goto L_32;
        return "call to 'resume' before 'invoke' with coroutine";
      L_32:
        return AndroidHttpClientProvider.access$buildNetworkClient(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidHttpClientProvider$invoke$config$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidHttpClientProvider$invoke$config$1 extends SuspendLambda {
    private Object L$0;
    int label;
    final AndroidHttpClientProvider this$0;

    AndroidHttpClientProvider$invoke$config$1(AndroidHttpClientProvider p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidHttpClientProvider$invoke$config$1(this$0, p1);
        L$0 = p0;
        return new AndroidHttpClientProvider$invoke$config$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidHttpClientProvider$invoke$config$1.invoke(p0, p1);
        return AndroidHttpClientProvider$invoke$config$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidHttpClientProvider$invoke$config$1.create(p0, p1);
        AndroidHttpClientProvider$invoke$config$1.invokeSuspend(Unit.INSTANCE);
        return AndroidHttpClientProvider$invoke$config$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_1e;
        if (if-ne(label, 1)) goto L_16;
        ResultKt.throwOnFailure(p0);
        p0.unbox-impl();
      L_16:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1e:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        AndroidHttpClientProvider.access$getConfigFileFromLocalStorage$p(this$0);
        new ConfigFileFromLocalStorage$Params(0, 1, 0);
        label = 1;
        ConfigFileFromLocalStorage.invoke-gIAlu-s(new ConfigFileFromLocalStorage$Params(..), this);
        if (if-ne(ConfigFileFromLocalStorage.invoke-gIAlu-s(..), "call to 'resume' before 'invoke' with coroutine")) goto L_3d;
        return "call to 'resume' before 'invoke' with coroutine";
      L_3d:
        Result.box-impl(ConfigFileFromLocalStorage.invoke-gIAlu-s(..));
        Result.constructor-impl(Result.box-impl(..));
        ResultKt.createFailure(Result.constructor-impl(..));
        Result.constructor-impl(ResultKt.createFailure(..));
      L_51:
        Result.isFailure-impl(Result.constructor-impl(..));
        if (if-eqz(Result.isFailure-impl(..))) goto L_58;
      L_58:
        if (if-eqz(0)) goto L_6a;
        0.unbox-impl();
        Result.isFailure-impl(Result.unbox-impl(..));
        if (if-eqz(Result.isFailure-impl(..))) goto L_67;
      L_67:
      L_68:
      L_6a:
        return Result.unbox-impl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$Companion
// ============================================================
package com.unity3d.ads.core.domain;

public final class AndroidInitializeBoldSDK$Companion {
    private AndroidInitializeBoldSDK$Companion() {
        new Object();
        return;
    }

    public AndroidInitializeBoldSDK$Companion(DefaultConstructorMarker p0) {
        new AndroidInitializeBoldSDK$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$initializationSuccess$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidInitializeBoldSDK$initializationSuccess$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final AndroidInitializeBoldSDK this$0;

    AndroidInitializeBoldSDK$initializationSuccess$1(AndroidInitializeBoldSDK p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        AndroidInitializeBoldSDK.access$initializationSuccess(this$0, 0, this);
        return AndroidInitializeBoldSDK.access$initializationSuccess(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$invoke$2
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidInitializeBoldSDK$invoke$2 extends SuspendLambda {
    long J$0;
    int label;
    final AndroidInitializeBoldSDK this$0;

    AndroidInitializeBoldSDK$invoke$2(AndroidInitializeBoldSDK p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidInitializeBoldSDK$invoke$2(this$0, p1);
        return new AndroidInitializeBoldSDK$invoke$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidInitializeBoldSDK$invoke$2.invoke(p0, p1);
        return AndroidInitializeBoldSDK$invoke$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidInitializeBoldSDK$invoke$2.create(p0, p1);
        AndroidInitializeBoldSDK$invoke$2.invokeSuspend(Unit.INSTANCE);
        return AndroidInitializeBoldSDK$invoke$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_22;
        if (if-eq(label, 1)) goto L_1a;
        if (if-ne(label, 2)) goto L_12;
        ResultKt.throwOnFailure(p0);
      L_12:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1a:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_22:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        TimeSource$Monotonic.INSTANCE.markNow-z9LOYto();
        new AndroidInitializeBoldSDK$invoke$2$1(this$0, 0);
        J$0 = TimeSource$Monotonic.markNow-z9LOYto(..);
        label = J$0;
        TimeoutKt.withTimeout(120000L, v7, new AndroidInitializeBoldSDK$invoke$2$1(..), this);
        if (if-ne(TimeoutKt.withTimeout(..), "call to 'resume' before 'invoke' with coroutine")) goto L_46;
        return "call to 'resume' before 'invoke' with coroutine";
      L_46:
      L_47:
        TimeSource$Monotonic$ValueTimeMark.box-impl(TimeSource$Monotonic.markNow-z9LOYto(..), TimeSource$Monotonic.markNow-z9LOYto(..));
        label = 2;
        AndroidInitializeBoldSDK.access$initializationSuccess(this$0, TimeSource$Monotonic$ValueTimeMark.box-impl(..), this);
        if (if-ne(AndroidInitializeBoldSDK.access$initializationSuccess(..), "call to 'resume' before 'invoke' with coroutine")) goto L_59;
        return "call to 'resume' before 'invoke' with coroutine";
      L_59:
        return Unit.INSTANCE;
      L_5e:
        InitializationException.Companion.parseFrom(Unit.INSTANCE);
        TimeSource$Monotonic$ValueTimeMark.box-impl(TimeSource$Monotonic.markNow-z9LOYto(..), TimeSource$Monotonic.markNow-z9LOYto(..));
        AndroidInitializeBoldSDK.access$initializationFailure(this$0, TimeSource$Monotonic$ValueTimeMark.box-impl(..), InitializationException$Companion.parseFrom(..));
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidInitializeBoldSDK$invoke$2$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidInitializeBoldSDK$invoke$2$1 extends SuspendLambda {
    int label;
    final AndroidInitializeBoldSDK this$0;

    AndroidInitializeBoldSDK$invoke$2$1(AndroidInitializeBoldSDK p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidInitializeBoldSDK$invoke$2$1(this$0, p1);
        return new AndroidInitializeBoldSDK$invoke$2$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidInitializeBoldSDK$invoke$2$1.invoke(p0, p1);
        return AndroidInitializeBoldSDK$invoke$2$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidInitializeBoldSDK$invoke$2$1.create(p0, p1);
        AndroidInitializeBoldSDK$invoke$2$1.invokeSuspend(Unit.INSTANCE);
        return AndroidInitializeBoldSDK$invoke$2$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_2d;
        if (if-eq(label, 1)) goto L_29;
        if (if-eq(label, 2)) goto L_25;
        if (if-eq(label, 3)) goto L_21;
        if (if-ne(label, 4)) goto L_19;
        ResultKt.throwOnFailure(p0);
      L_19:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_21:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_25:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_29:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_2d:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        label = 1;
        AndroidInitializeBoldSDK.access$initializationStart(this$0, this);
        if (if-ne(AndroidInitializeBoldSDK.access$initializationStart(..), "call to 'resume' before 'invoke' with coroutine")) goto L_3e;
        return "call to 'resume' before 'invoke' with coroutine";
      L_3e:
        AndroidInitializeBoldSDK.access$checkCanInitialize(this$0);
        AndroidInitializeBoldSDK.access$getGetInitializeRequest$p(this$0);
        label = 2;
        GetInitializationRequest.invoke(this);
        if (if-ne(GetInitializationRequest.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_55;
        return "call to 'resume' before 'invoke' with coroutine";
      L_55:
        AndroidInitializeBoldSDK.access$getGetRequestPolicy$p(this$0);
        GetRequestPolicy.invoke();
        AndroidInitializeBoldSDK.access$getGatewayClient$p(this$0);
        label = 3;
        GatewayClient$DefaultImpls.request$default(AndroidInitializeBoldSDK.access$getGatewayClient$p(..), 0, GetInitializationRequest.invoke(..), GetRequestPolicy.invoke(..), OperationType.INITIALIZATION, this, 1, 0);
        if (if-ne(GatewayClient$DefaultImpls.request$default(..), "call to 'resume' before 'invoke' with coroutine")) goto L_79;
        return "call to 'resume' before 'invoke' with coroutine";
      L_79:
        AndroidInitializeBoldSDK.access$getHandleGatewayInitializationResponse$p(this$0);
        UniversalResponseOuterClass$UniversalResponse.getPayload();
        UniversalResponseOuterClass$UniversalResponse$Payload.getInitializationResponse();
        label = 4;
        HandleGatewayInitializationResponse.invoke(UniversalResponseOuterClass$UniversalResponse$Payload.getInitializationResponse(..), this);
        if (if-ne(HandleGatewayInitializationResponse.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_9a;
        return "call to 'resume' before 'invoke' with coroutine";
      L_9a:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidLoad$invoke$2
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidLoad$invoke$2 extends SuspendLambda {
    final AdRequestOuterClass$BannerSize $bannerSize;
    final Context $context;
    final HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup $headerBiddingAdMarkup;
    final UnityAdsLoadOptions $loadOptions;
    final ByteString $opportunityId;
    final String $placement;
    int I$0;
    Object L$0;
    int label;
    final AndroidLoad this$0;

    AndroidLoad$invoke$2(AndroidLoad p0, AdRequestOuterClass$BannerSize p1, HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup p2, String p3, ByteString p4, UnityAdsLoadOptions p5, Context p6, Continuation p7) {
        this$0 = p0;
        $bannerSize = p1;
        $headerBiddingAdMarkup = p2;
        $placement = p3;
        $opportunityId = p4;
        $loadOptions = p5;
        $context = p6;
        new SuspendLambda(2, p7);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidLoad$invoke$2(this$0, $bannerSize, $headerBiddingAdMarkup, $placement, $opportunityId, $loadOptions, $context, p1);
        return new AndroidLoad$invoke$2;
    }

    public Object invoke(Object p0, Object p1) {
        AndroidLoad$invoke$2.invoke(p0, p1);
        return AndroidLoad$invoke$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidLoad$invoke$2.create(p0, p1);
        AndroidLoad$invoke$2.create(..).invokeSuspend(Unit.INSTANCE);
        return AndroidLoad$invoke$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
        ResultKt.throwOnFailure(p0);
        ResultKt.throwOnFailure(p0);
        ResultKt.throwOnFailure(p0);
        ResultKt.throwOnFailure(p0);
        ResultKt.throwOnFailure(p0);
        ResultKt.throwOnFailure(p0);
        ResultKt.throwOnFailure(p0);
        AndroidLoad.access$getSessionRepository$p(this$0);
        SessionRepository.isSdkInitialized();
        if (if-nez(SessionRepository.isSdkInitialized(..))) goto L_7a;
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.INITIALIZE_FAILED, 0, 0, "not_initialized", 0, 22, 0);
        return new LoadResult$Failure;
      L_7a:
        if (if-eqz($bannerSize)) goto L_80;
      L_80:
      L_81:
        if (if-eqz(0)) goto L_86;
      L_86:
      L_88:
        $headerBiddingAdMarkup.getAdData();
        ByteString.isEmpty();
        if (if-nez(ByteString.isEmpty(..))) goto L_ed;
        AndroidLoad.access$incrementLoadRequestCount(this$0, 0);
        AndroidLoad.access$getGetAdRequest$p(this$0);
        L$0 = DiagnosticEventRequestOuterClass$DiagnosticAdType.DIAGNOSTIC_AD_TYPE_FULLSCREEN;
        I$0 = ByteString.isEmpty(..);
        label = 1;
        GetAdRequest.invoke($placement, $opportunityId, $bannerSize, this);
        if (if-ne(GetAdRequest.invoke(..), new LoadResult$Failure)) goto L_b6;
        return new LoadResult$Failure;
      L_b6:
        AndroidLoad.access$getGetRequestPolicy$p(this$0);
        GetRequestPolicy.invoke();
        AndroidLoad.access$getGatewayClient$p(this$0);
        L$0 = DiagnosticEventRequestOuterClass$DiagnosticAdType.DIAGNOSTIC_AD_TYPE_FULLSCREEN;
        I$0 = ByteString.isEmpty(..);
        label = 2;
        GatewayClient$DefaultImpls.request$default(AndroidLoad.access$getGatewayClient$p(..), 0, GetAdRequest.invoke(..), GetRequestPolicy.invoke(..), OperationType.LOAD, this, 1, 0);
        if (if-ne(GatewayClient$DefaultImpls.request$default(..), new LoadResult$Failure)) goto L_df;
        return new LoadResult$Failure;
      L_df:
        UniversalResponseOuterClass$UniversalResponse.getPayload();
        UniversalResponseOuterClass$UniversalResponse$Payload.getAdResponse();
      L_e9:
      L_ed:
        AndroidLoad.access$incrementLoadRequestAdmCount(this$0, UniversalResponseOuterClass$UniversalResponse$Payload.getAdResponse(..));
        AndroidLoad.access$getGetAdPlayerConfigRequest$p(this$0);
        $headerBiddingAdMarkup.getConfigurationToken();
        L$0 = DiagnosticEventRequestOuterClass$DiagnosticAdType.DIAGNOSTIC_AD_TYPE_FULLSCREEN;
        I$0 = ByteString.isEmpty(..);
        label = 3;
        GetAdPlayerConfigRequest.invoke($placement, $opportunityId, HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup.getConfigurationToken(..), this);
        if (if-ne(GetAdPlayerConfigRequest.invoke(..), new LoadResult$Failure)) goto L_118;
        return new LoadResult$Failure;
      L_118:
        AndroidLoad.access$getGetRequestPolicy$p(this$0);
        GetRequestPolicy.invoke();
        AndroidLoad.access$getGatewayClient$p(this$0);
        L$0 = DiagnosticEventRequestOuterClass$DiagnosticAdType.DIAGNOSTIC_AD_TYPE_FULLSCREEN;
        I$0 = ByteString.isEmpty(..);
        label = 4;
        GatewayClient$DefaultImpls.request$default(AndroidLoad.access$getGatewayClient$p(..), 0, GetAdPlayerConfigRequest.invoke(..), GetRequestPolicy.invoke(..), OperationType.LOAD_HEADER_BIDDING, this, 1, 0);
        if (if-ne(GatewayClient$DefaultImpls.request$default(..), new LoadResult$Failure)) goto L_141;
        return new LoadResult$Failure;
      L_141:
        UniversalResponseOuterClass$UniversalResponse.hasError();
        if (if-eqz(UniversalResponseOuterClass$UniversalResponse.hasError(..))) goto L_161;
        UniversalResponseOuterClass$UniversalResponse.getError();
        ErrorOuterClass$Error.getErrorText();
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "Internal error", 0, "gateway", ErrorOuterClass$Error.getErrorText(..), 4, 0);
        return new LoadResult$Failure;
      L_161:
        UniversalResponseOuterClass$UniversalResponse.getPayload();
        UniversalResponseOuterClass$UniversalResponse$Payload.getAdPlayerConfigResponse();
        AdResponseOuterClass$AdResponse.newBuilder();
        AdResponseKt$Dsl.Companion._create(AdResponseOuterClass$AdResponse.newBuilder(..));
        $headerBiddingAdMarkup.getAdData();
        AdResponseKt$Dsl.setAdData(HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup.getAdData(..));
        $headerBiddingAdMarkup.getAdDataVersion();
        AdResponseKt$Dsl.setAdDataVersion(HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup.getAdDataVersion(..));
        AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse.getTrackingToken();
        AdResponseKt$Dsl.setTrackingToken(AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse.getTrackingToken(..));
        AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse.getImpressionConfiguration();
        AdResponseKt$Dsl.setImpressionConfiguration(AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse.getImpressionConfiguration(..));
        AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse.getImpressionConfigurationVersion();
        AdResponseKt$Dsl.setImpressionConfigurationVersion(AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse.getImpressionConfigurationVersion(..));
        AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse.getWebviewConfiguration();
        AdResponseKt$Dsl.setWebviewConfiguration(AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse.getWebviewConfiguration(..));
        AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse.getAdDataRefreshToken();
        AdResponseKt$Dsl.setAdDataRefreshToken(AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse.getAdDataRefreshToken(..));
        AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse.hasError();
        if (if-eqz(AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse.hasError(..))) goto L_1d6;
        AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse.getError();
        AdResponseKt$Dsl.setError(AdPlayerConfigResponseOuterClass$AdPlayerConfigResponse.getError(..));
      L_1d6:
        AdResponseKt$Dsl._build();
      L_1dc:
        AndroidLoad.access$getHandleGatewayAdResponse$p(this$0);
        if (if-eqz(ByteString.isEmpty(..))) goto L_1f3;
      L_1f3:
      L_1f4:
        L$0 = 0;
        label = 5;
        HandleGatewayAdResponse.invoke($loadOptions, $opportunityId, "headerBiddingAdMarkup.adData", $context, $placement, ErrorOuterClass$Error.getErrorText(..), 0, this);
        if (if-ne(HandleGatewayAdResponse.invoke(..), new LoadResult$Failure)) goto L_204;
        return new LoadResult$Failure;
      L_204:
        if (if-eqz(0)) goto L_241;
        AndroidLoad.access$getAdRepository$p(this$0);
        label = 6;
        AdRepository.getAd($opportunityId, this);
        if (if-ne(AdRepository.getAd(..), new LoadResult$Failure)) goto L_21f;
        return new LoadResult$Failure;
      L_21f:
        if (if-nez(AdRepository.getAd(..))) goto L_238;
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "[UnityAds] Ad not found", 0, "ad_object_not_found", 0, 20, 0);
      L_238:
        new LoadResult$Success(new LoadResult$Failure);
      L_241:
        if (if-eqz(new LoadResult$Success(..))) goto L_246;
      L_245:
        return new LoadResult$Success(..);
      L_246:
        new NoWhenBranchMatchedException();
        throw new NoWhenBranchMatchedException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidRefresh$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidRefresh$invoke$1 extends ContinuationImpl {
    int label;
    Object result;
    final AndroidRefresh this$0;

    AndroidRefresh$invoke$1(AndroidRefresh p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, 0, this);
        return AndroidRefresh.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidRefresh$invoke$2
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidRefresh$invoke$2 extends SuspendLambda {
    final ByteString $adDataRefreshToken;
    final ByteString $opportunityId;
    int label;
    final AndroidRefresh this$0;

    AndroidRefresh$invoke$2(AndroidRefresh p0, ByteString p1, ByteString p2, Continuation p3) {
        this$0 = p0;
        $adDataRefreshToken = p1;
        $opportunityId = p2;
        new SuspendLambda(2, p3);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidRefresh$invoke$2(this$0, $adDataRefreshToken, $opportunityId, p1);
        return new AndroidRefresh$invoke$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidRefresh$invoke$2.invoke(p0, p1);
        return AndroidRefresh$invoke$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidRefresh$invoke$2.create(p0, p1);
        AndroidRefresh$invoke$2.create(..).invokeSuspend(Unit.INSTANCE);
        return AndroidRefresh$invoke$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_1e;
        if (if-eq(label, 1)) goto L_1a;
        if (if-ne(label, 2)) goto L_12;
        ResultKt.throwOnFailure(p0);
      L_12:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1a:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_1e:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        AndroidRefresh.access$getGetAdDataRefreshRequest$p(this$0);
        label = 1;
        GetAdDataRefreshRequest.invoke($adDataRefreshToken, $opportunityId, this);
        if (if-ne(GetAdDataRefreshRequest.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_37;
        return "call to 'resume' before 'invoke' with coroutine";
      L_37:
        AndroidRefresh.access$getGetRequestPolicy$p(this$0);
        GetRequestPolicy.invoke();
        AndroidRefresh.access$getGatewayClient$p(this$0);
        label = 2;
        GatewayClient$DefaultImpls.request$default(AndroidRefresh.access$getGatewayClient$p(..), 0, GetAdDataRefreshRequest.invoke(..), GetRequestPolicy.invoke(..), OperationType.REFRESH, this, 1, 0);
        if (if-ne(GatewayClient$DefaultImpls.request$default(..), "call to 'resume' before 'invoke' with coroutine")) goto L_5b;
        return "call to 'resume' before 'invoke' with coroutine";
      L_5b:
        UniversalResponseOuterClass$UniversalResponse.getPayload();
        UniversalResponseOuterClass$UniversalResponse$Payload.getAdDataRefreshResponse();
        return UniversalResponseOuterClass$UniversalResponse$Payload.getAdDataRefreshResponse(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidShow$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidShow$invoke$1 extends SuspendLambda {
    final AdObject $adObject;
    final Context $context;
    final UnityAdsShowOptions $showOptions;
    private Object L$0;
    Object L$1;
    int label;
    final AndroidShow this$0;

    AndroidShow$invoke$1(AdObject p0, AndroidShow p1, Context p2, UnityAdsShowOptions p3, Continuation p4) {
        $adObject = p0;
        this$0 = p1;
        $context = p2;
        $showOptions = p3;
        new SuspendLambda(2, p4);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidShow$invoke$1($adObject, this$0, $context, $showOptions, p1);
        L$0 = p0;
        return new AndroidShow$invoke$1;
    }

    public Object invoke(Object p0, Object p1) {
        AndroidShow$invoke$1.invoke(p0, p1);
        return AndroidShow$invoke$1.invoke(..);
    }

    public final Object invoke(FlowCollector p0, Continuation p1) {
        AndroidShow$invoke$1.create(p0, p1);
        AndroidShow$invoke$1.create(..).invokeSuspend(Unit.INSTANCE);
        return AndroidShow$invoke$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_2c;
        if (if-eq(label, 1)) goto L_1d;
        if (if-ne(label, 2)) goto L_15;
        ResultKt.throwOnFailure(p0);
      L_15:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1d:
        ResultKt.throwOnFailure(p0);
      L_2c:
        ResultKt.throwOnFailure(p0);
        $adObject.getOpportunityId();
        AdObject.getOpportunityId(..).isEmpty();
        if (if-eqz(ByteString.isEmpty(..))) goto L_d9;
        $adObject.getOpportunityId();
        AndroidShow.access$getAdRepository$p(this$0);
        L$0 = L$0;
        L$1 = AdObject.getOpportunityId(..);
        label = p0;
        AdRepository.getAd(AdObject.getOpportunityId(..), this);
        if (if-ne(AdRepository.getAd(..), new IllegalStateException(..))) goto L_5c;
        return new IllegalStateException(..);
      L_5c:
      L_61:
        if (if-eqz(AdRepository.getAd(..))) goto L_d1;
        AndroidShow.access$getSendDiagnosticEvent$p(this$0);
        SendDiagnosticEvent$DefaultImpls.invoke$default(AndroidShow.access$getSendDiagnosticEvent$p(..), "native_show_started_ad_viewer", 0, 0, 0, $adObject, 14, 0);
        AdRepository.getAd(..).getAdPlayer();
        if (if-eqz(AdObject.getAdPlayer(..))) goto L_c9;
        AdObject.getAdPlayer(..).getOnShowEvent();
        new AndroidShow$invoke$1$2(AdRepository.getAd(..), this$0, $context, $showOptions, 0);
        FlowKt.onStart(AdPlayer.getOnShowEvent(..), new AndroidShow$invoke$1$2);
        new AndroidShow$invoke$1$3(this$0, AdObject.getOpportunityId(..), 0);
        FlowKt.onCompletion(FlowKt.onStart(..), new AndroidShow$invoke$1$3(..));
        new AndroidShow$invoke$1$4(0);
        FlowKt.transformWhile(FlowKt.onCompletion(..), new AndroidShow$invoke$1$4(..));
        new AndroidShow$invoke$1$5(L$0);
        L$0 = 0;
        L$1 = 0;
        label = 2;
        FlowKt.transformWhile(..).collect(new AndroidShow$invoke$1$5(..), this);
        if (if-ne(Flow.collect(..), new IllegalStateException(..))) goto L_c6;
        return new IllegalStateException(..);
      L_c6:
        return Unit.INSTANCE;
      L_c9:
        new IllegalStateException("No adPlayer associated with ad");
        throw new IllegalStateException(..);
      L_d1:
        new IllegalStateException("No ad associated with opportunityId");
        throw new IllegalStateException(..);
      L_d9:
        "No opportunityId".toString();
        new IllegalArgumentException(Object.toString(..));
        throw new IllegalArgumentException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidShow$invoke$1$2
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidShow$invoke$1$2 extends SuspendLambda {
    final AdObject $ad;
    final Context $context;
    final UnityAdsShowOptions $showOptions;
    int label;
    final AndroidShow this$0;

    AndroidShow$invoke$1$2(AdObject p0, AndroidShow p1, Context p2, UnityAdsShowOptions p3, Continuation p4) {
        $ad = p0;
        this$0 = p1;
        $context = p2;
        $showOptions = p3;
        new SuspendLambda(2, p4);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidShow$invoke$1$2($ad, this$0, $context, $showOptions, p1);
        return new AndroidShow$invoke$1$2;
    }

    public Object invoke(Object p0, Object p1) {
        AndroidShow$invoke$1$2.invoke(p0, p1);
        return AndroidShow$invoke$1$2.invoke(..);
    }

    public final Object invoke(FlowCollector p0, Continuation p1) {
        AndroidShow$invoke$1$2.create(p0, p1);
        AndroidShow$invoke$1$2.create(..).invokeSuspend(Unit.INSTANCE);
        return AndroidShow$invoke$1$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_73;
        ResultKt.throwOnFailure(p0);
        AndroidShow.access$getGameServerIdReader$p(this$0);
        MetadataReader.getJsonStorage();
        MetadataReader.getKey();
        MetadataReader.getJsonStorage(..).get(MetadataReader.getKey(..));
        if (if-eqz(JsonStorage.get(..))) goto L_30;
        if (if-eqz(v4)) goto L_2d;
      L_2d:
      L_2e:
        if (if-nez(0)) goto L_31;
      L_30:
      L_31:
        MetadataReader.getJsonStorage();
        MetadataReader.getKey();
        MetadataReader.getJsonStorage(..).get(MetadataReader.getKey(..));
        if (if-eqz(JsonStorage.get(..))) goto L_4d;
        MetadataReader.getJsonStorage();
        MetadataReader.getKey();
        MetadataReader.getJsonStorage(..).delete(MetadataReader.getKey(..));
      L_4d:
        $ad.setPlayerServerId(0);
        $ad.getAdPlayer();
        $showOptions.getData();
        if (if-eqz(UnityAdsShowOptions.getData(..))) goto L_68;
        JSONObjectExtensionsKt.toBuiltInMap(UnityAdsShowOptions.getData(..));
      L_68:
        new AndroidShowOptions($context, JSONObjectExtensionsKt.toBuiltInMap(..));
        AdObject.getAdPlayer(..).show(new AndroidShowOptions(..));
        return Unit.INSTANCE;
      L_73:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidShow$invoke$1$3
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidShow$invoke$1$3 extends SuspendLambda {
    final ByteString $opportunityId;
    int label;
    final AndroidShow this$0;

    AndroidShow$invoke$1$3(AndroidShow p0, ByteString p1, Continuation p2) {
        this$0 = p0;
        $opportunityId = p1;
        new SuspendLambda(3, p2);
        return;
    }

    public Object invoke(Object p0, Object p1, Object p2) {
        AndroidShow$invoke$1$3.invoke(p0, p1, p2);
        return AndroidShow$invoke$1$3.invoke(..);
    }

    public final Object invoke(FlowCollector p0, Throwable p1, Continuation p2) {
        new AndroidShow$invoke$1$3(this$0, $opportunityId, p2);
        new AndroidShow$invoke$1$3(..).invokeSuspend(Unit.INSTANCE);
        return AndroidShow$invoke$1$3.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        AndroidShow.access$getAdRepository$p(this$0);
        label = 1;
        AdRepository.removeAd($opportunityId, this);
        if (if-ne(AdRepository.removeAd(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2e;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2e:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidShow$invoke$1$4
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidShow$invoke$1$4 extends SuspendLambda {
    private Object L$0;
    Object L$1;
    int label;

    AndroidShow$invoke$1$4(Continuation p0) {
        new SuspendLambda(3, p0);
        return;
    }

    public Object invoke(Object p0, Object p1, Object p2) {
        AndroidShow$invoke$1$4.invoke(p0, p1, p2);
        return AndroidShow$invoke$1$4.invoke(..);
    }

    public final Object invoke(FlowCollector p0, ShowEvent p1, Continuation p2) {
        new AndroidShow$invoke$1$4(p2);
        L$0 = p0;
        L$1 = p1;
        new AndroidShow$invoke$1$4(..).invokeSuspend(Unit.INSTANCE);
        return AndroidShow$invoke$1$4.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_1b;
        if (if-ne(label, 1)) goto L_13;
        ResultKt.throwOnFailure(p0);
      L_13:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1b:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        L$0 = L$1;
        label = 1;
        L$0.emit(L$1, this);
        if (if-ne(FlowCollector.emit(..), "call to 'resume' before 'invoke' with coroutine")) goto L_34;
        return "call to 'resume' before 'invoke' with coroutine";
      L_34:
      L_35:
        if (if-nez(FlowCollector.emit(..))) goto L_3e;
        if (if-nez(FlowCollector.emit(..))) goto L_3e;
      L_3e:
      L_3f:
        Boxing.boxBoolean(0);
        return Boxing.boxBoolean(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidShow$invoke$1$5
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidShow$invoke$1$5 {
    final FlowCollector $$this$flow;

    AndroidShow$invoke$1$5(FlowCollector p0) {
        $$this$flow = p0;
        new Object();
        return;
    }

    public final Object emit(ShowEvent p0, Continuation p1) {
        $$this$flow.emit(p0, p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_d;
        return FlowCollector.emit(..);
      L_d:
        return Unit.INSTANCE;
    }

    public Object emit(Object p0, Continuation p1) {
        AndroidShow$invoke$1$5.emit(p0, p1);
        return AndroidShow$invoke$1$5.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AndroidTriggerInitializationCompletedRequest$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class AndroidTriggerInitializationCompletedRequest$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    Object result;
    final AndroidTriggerInitializationCompletedRequest this$0;

    AndroidTriggerInitializationCompletedRequest$invoke$1(AndroidTriggerInitializationCompletedRequest p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(this);
        return AndroidTriggerInitializationCompletedRequest.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.AwaitInitialization$DefaultImpls
// ============================================================
package com.unity3d.ads.core.domain;

public final class AwaitInitialization$DefaultImpls {
    public static Object invoke$default(AwaitInitialization p0, long p1, Continuation p2, int p3, Object p4) {
        if (if-nez(p4)) goto L_10;
        if (if-eqz(p3)) goto L_b;
      L_b:
        p0.invoke(0x7fffffffffffffffL, v2, p2);
        return AwaitInitialization.invoke(..);
      L_10:
        new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        throw new UnsupportedOperationException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2
// ============================================================
package com.unity3d.ads.core.domain;

final class CommonAwaitInitialization$invoke$2 extends SuspendLambda {
    int label;
    final CommonAwaitInitialization this$0;

    CommonAwaitInitialization$invoke$2(CommonAwaitInitialization p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new CommonAwaitInitialization$invoke$2(this$0, p1);
        return new CommonAwaitInitialization$invoke$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        CommonAwaitInitialization$invoke$2.invoke(p0, p1);
        return CommonAwaitInitialization$invoke$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        CommonAwaitInitialization$invoke$2.create(p0, p1);
        CommonAwaitInitialization$invoke$2.invokeSuspend(Unit.INSTANCE);
        return CommonAwaitInitialization$invoke$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        CommonAwaitInitialization.access$getSessionRepository$p(this$0);
        SessionRepository.getObserveInitializationState();
        new CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1(SessionRepository.getObserveInitializationState(..));
        label = 1;
        FlowKt.first(new CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1(..), this);
        if (if-ne(FlowKt.first(..), "call to 'resume' before 'invoke' with coroutine")) goto L_37;
        return "call to 'resume' before 'invoke' with coroutine";
      L_37:
        return FlowKt.first(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1 {
    final Flow $this_unsafeTransform$inlined;

    public CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1(Flow p0) {
        $this_unsafeTransform$inlined = p0;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2(p0);
        $this_unsafeTransform$inlined.collect(new CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14;
        return Flow.collect(..);
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2 {
    final FlowCollector $this_unsafeFlow;

    public CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2(FlowCollector p0) {
        $this_unsafeFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-ne(label, 1)) goto L_2a;
        ResultKt.throwOnFailure(result);
      L_2a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_32:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        if (if-eq(new IllegalStateException(..), InitializationState.INITIALIZED)) goto L_48;
        if (if-ne(new IllegalStateException(..), InitializationState.FAILED)) goto L_46;
      L_46:
      L_48:
      L_49:
        if (if-eqz(1)) goto L_54;
        label = 1;
        $this_unsafeFlow.emit(new IllegalStateException(..), new CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_54;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_54:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2$1
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2 this$0;

    public CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2$1(CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return CommonAwaitInitialization$invoke$2$invokeSuspend$$inlined$filter$1$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonCacheFile$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class CommonCacheFile$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    Object result;
    final CommonCacheFile this$0;

    CommonCacheFile$invoke$1(CommonCacheFile p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, 0, 0, 0, this);
        return CommonCacheFile.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonClearCache$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class CommonClearCache$invoke$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    Object result;
    final CommonClearCache this$0;

    CommonClearCache$invoke$1(CommonClearCache p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(this);
        return CommonClearCache.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonGetHeaderBiddingToken$Companion
// ============================================================
package com.unity3d.ads.core.domain;

public final class CommonGetHeaderBiddingToken$Companion {
    private CommonGetHeaderBiddingToken$Companion() {
        new Object();
        return;
    }

    public CommonGetHeaderBiddingToken$Companion(DefaultConstructorMarker p0) {
        new CommonGetHeaderBiddingToken$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonGetHeaderBiddingToken$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class CommonGetHeaderBiddingToken$invoke$1 extends ContinuationImpl {
    int label;
    Object result;
    final CommonGetHeaderBiddingToken this$0;

    CommonGetHeaderBiddingToken$invoke$1(CommonGetHeaderBiddingToken p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(this);
        return CommonGetHeaderBiddingToken.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonGetIsFileCache$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class CommonGetIsFileCache$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final CommonGetIsFileCache this$0;

    CommonGetIsFileCache$invoke$1(CommonGetIsFileCache p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, this);
        return CommonGetIsFileCache.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1
// ============================================================
package com.unity3d.ads.core.domain;

final class CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final CommonInitAwaitingGetHeaderBiddingToken this$0;

    CommonInitAwaitingGetHeaderBiddingToken$fetchToken$1(CommonInitAwaitingGetHeaderBiddingToken p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        CommonInitAwaitingGetHeaderBiddingToken.access$fetchToken(this$0, this);
        return CommonInitAwaitingGetHeaderBiddingToken.access$fetchToken(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class CommonInitAwaitingGetHeaderBiddingToken$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final CommonInitAwaitingGetHeaderBiddingToken this$0;

    CommonInitAwaitingGetHeaderBiddingToken$invoke$1(CommonInitAwaitingGetHeaderBiddingToken p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, this);
        return CommonInitAwaitingGetHeaderBiddingToken.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.CommonInitAwaitingGetHeaderBiddingToken$invoke$2
// ============================================================
package com.unity3d.ads.core.domain;

final class CommonInitAwaitingGetHeaderBiddingToken$invoke$2 extends SuspendLambda {
    int label;
    final CommonInitAwaitingGetHeaderBiddingToken this$0;

    CommonInitAwaitingGetHeaderBiddingToken$invoke$2(CommonInitAwaitingGetHeaderBiddingToken p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new CommonInitAwaitingGetHeaderBiddingToken$invoke$2(this$0, p1);
        return new CommonInitAwaitingGetHeaderBiddingToken$invoke$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        CommonInitAwaitingGetHeaderBiddingToken$invoke$2.invoke(p0, p1);
        return CommonInitAwaitingGetHeaderBiddingToken$invoke$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        CommonInitAwaitingGetHeaderBiddingToken$invoke$2.create(p0, p1);
        CommonInitAwaitingGetHeaderBiddingToken$invoke$2.invokeSuspend(Unit.INSTANCE);
        return CommonInitAwaitingGetHeaderBiddingToken$invoke$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_22;
        if (if-eq(label, 1)) goto L_11;
        if (if-eq(label, 2)) goto L_1e;
        if (if-ne(label, 3)) goto L_16;
      L_11:
        ResultKt.throwOnFailure(p0);
      L_16:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1e:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_22:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        this$0.getGetInitializationState();
        GetInitializationState.invoke();
        GetInitializationState.invoke(..).ordinal();
        if (if-eq(InitializationState.ordinal(..), 1)) goto L_80;
        if (if-eq(InitializationState.ordinal(..), 2)) goto L_80;
        if (if-eq(InitializationState.ordinal(..), 3)) goto L_41;
        if (if-eq(InitializationState.ordinal(..), 4)) goto L_41;
      L_41:
        CommonInitAwaitingGetHeaderBiddingToken.access$setDidAwaitInit$p(this$0, 1);
        this$0.getAwaitInitialization();
        label = 2;
        AwaitInitialization$DefaultImpls.invoke$default(CommonInitAwaitingGetHeaderBiddingToken.getAwaitInitialization(..), 0L, v6, this, 1, 0);
        if (if-ne(AwaitInitialization$DefaultImpls.invoke$default(..), "call to 'resume' before 'invoke' with coroutine")) goto L_5c;
        return "call to 'resume' before 'invoke' with coroutine";
      L_5c:
        this$0.getSessionRepository();
        SessionRepository.getShouldInitialize();
        if (if-nez(SessionRepository.getShouldInitialize(..))) goto L_72;
        CommonInitAwaitingGetHeaderBiddingToken.access$tokenFailure(this$0, "gateway", "!sessionRepository.shouldInitialize");
      L_72:
        label = 3;
        CommonInitAwaitingGetHeaderBiddingToken.access$fetchToken(this$0, this);
        if (if-ne(CommonInitAwaitingGetHeaderBiddingToken.access$fetchToken(..), "gateway")) goto L_8e;
        return "gateway";
      L_80:
        label = CommonInitAwaitingGetHeaderBiddingToken.getAwaitInitialization(..);
        CommonInitAwaitingGetHeaderBiddingToken.access$fetchToken(this$0, this);
        if (if-ne(CommonInitAwaitingGetHeaderBiddingToken.access$fetchToken(..), "gateway")) goto L_8e;
        return "gateway";
      L_8e:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetAdRequest$DefaultImpls
// ============================================================
package com.unity3d.ads.core.domain;

public final class GetAdRequest$DefaultImpls {
    public static Object invoke$default(GetAdRequest p0, String p1, ByteString p2, AdRequestOuterClass$BannerSize p3, Continuation p4, int p5, Object p6) {
        if (if-nez(p6)) goto L_c;
        if (if-eqz(p5)) goto L_7;
      L_7:
        p0.invoke(p1, p2, 0, p4);
        return GetAdRequest.invoke(..);
      L_c:
        new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        throw new UnsupportedOperationException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.GetLatestWebViewConfiguration$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class GetLatestWebViewConfiguration$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    Object result;
    final GetLatestWebViewConfiguration this$0;

    GetLatestWebViewConfiguration$invoke$1(GetLatestWebViewConfiguration p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, 0, 0, this);
        return GetLatestWebViewConfiguration.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$Companion
// ============================================================
package com.unity3d.ads.core.domain;

public final class HandleInvocationsFromAdViewer$Companion {
    private HandleInvocationsFromAdViewer$Companion() {
        new Object();
        return;
    }

    public HandleInvocationsFromAdViewer$Companion(DefaultConstructorMarker p0) {
        new HandleInvocationsFromAdViewer$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$2
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$2 extends SuspendLambda {
    final Function1 $onSubscription;
    int label;

    HandleInvocationsFromAdViewer$invoke$2(Function1 p0, Continuation p1) {
        $onSubscription = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new HandleInvocationsFromAdViewer$invoke$2($onSubscription, p1);
        return new HandleInvocationsFromAdViewer$invoke$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        HandleInvocationsFromAdViewer$invoke$2.invoke(p0, p1);
        return HandleInvocationsFromAdViewer$invoke$2.invoke(..);
    }

    public final Object invoke(FlowCollector p0, Continuation p1) {
        HandleInvocationsFromAdViewer$invoke$2.create(p0, p1);
        HandleInvocationsFromAdViewer$invoke$2.invokeSuspend(Unit.INSTANCE);
        return HandleInvocationsFromAdViewer$invoke$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        label = 1;
        $onSubscription.invoke(this);
        if (if-ne(Function1.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_25;
        return "call to 'resume' before 'invoke' with coroutine";
      L_25:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$3
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$3 extends SuspendLambda {
    final Map $definition;
    Object L$0;
    int label;

    HandleInvocationsFromAdViewer$invoke$3(Map p0, Continuation p1) {
        $definition = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new HandleInvocationsFromAdViewer$invoke$3($definition, p1);
        L$0 = p0;
        return new HandleInvocationsFromAdViewer$invoke$3(..);
    }

    public final Object invoke(Invocation p0, Continuation p1) {
        HandleInvocationsFromAdViewer$invoke$3.create(p0, p1);
        HandleInvocationsFromAdViewer$invoke$3.invokeSuspend(Unit.INSTANCE);
        return HandleInvocationsFromAdViewer$invoke$3.invokeSuspend(..);
    }

    public Object invoke(Object p0, Object p1) {
        HandleInvocationsFromAdViewer$invoke$3.invoke(p0, p1);
        return HandleInvocationsFromAdViewer$invoke$3.invoke(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        L$0.getLocation();
        $definition.get(Invocation.getLocation(..));
        if (if-eqz(Map.get(..))) goto L_4c;
        Map.get(..).invoke();
        if (if-nez(Function0.invoke(..))) goto L_35;
      L_35:
        new HandleInvocationsFromAdViewer$invoke$3$1(Function0.invoke(..), L$0, 0);
        label = 1;
        L$0.handle(new HandleInvocationsFromAdViewer$invoke$3$1(..), this);
        if (if-ne(Invocation.handle(..), "call to 'resume' before 'invoke' with coroutine")) goto L_49;
        return "call to 'resume' before 'invoke' with coroutine";
      L_49:
        return Unit.INSTANCE;
      L_4c:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$3$1
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$3$1 extends SuspendLambda {
    final ExposedFunction $exposedFunction;
    final Invocation $it;
    int label;

    HandleInvocationsFromAdViewer$invoke$3$1(ExposedFunction p0, Invocation p1, Continuation p2) {
        $exposedFunction = p0;
        $it = p1;
        new SuspendLambda(1, p2);
        return;
    }

    public final Continuation create(Continuation p0) {
        new HandleInvocationsFromAdViewer$invoke$3$1($exposedFunction, $it, p0);
        return new HandleInvocationsFromAdViewer$invoke$3$1(..);
    }

    public Object invoke(Object p0) {
        HandleInvocationsFromAdViewer$invoke$3$1.invoke(p0);
        return HandleInvocationsFromAdViewer$invoke$3$1.invoke(..);
    }

    public final Object invoke(Continuation p0) {
        HandleInvocationsFromAdViewer$invoke$3$1.create(p0);
        HandleInvocationsFromAdViewer$invoke$3$1.invokeSuspend(Unit.INSTANCE);
        return HandleInvocationsFromAdViewer$invoke$3$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        $it.getParameters();
        label = 1;
        $exposedFunction.invoke(Invocation.getParameters(..), this);
        if (if-ne(ExposedFunction.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2b;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2b:
        return ExposedFunction.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$1
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$1 extends Lambda {
    final String $adDataObject;
    final String $adDataRefreshTokenObject;
    final AdObject $adObject;
    final String $impressionConfigObject;
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$1(HandleInvocationsFromAdViewer p0, String p1, String p2, String p3, AdObject p4) {
        this$0 = p0;
        $adDataObject = p1;
        $impressionConfigObject = p2;
        $adDataRefreshTokenObject = p3;
        $adObject = p4;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(AndroidGetAdPlayerContext.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(IsOMActivated.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.getAdContext-yLuu4LI(IServicesRegistry.getService(..), $adDataObject, $impressionConfigObject, $adDataRefreshTokenObject, IServicesRegistry.getService(..), $adObject);
        return CommonAdViewerExposedFunctionsKt.getAdContext-yLuu4LI(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$1.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$1.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$10
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$10 extends Lambda {
    public static final HandleInvocationsFromAdViewer$invoke$definition$10 INSTANCE;

    static <clinit>() {
        new HandleInvocationsFromAdViewer$invoke$definition$10();
        INSTANCE = new HandleInvocationsFromAdViewer$invoke$definition$10(..);
        return;
    }

    HandleInvocationsFromAdViewer$invoke$definition$10() {
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        CommonAdViewerExposedFunctionsKt.readStorage();
        return CommonAdViewerExposedFunctionsKt.readStorage(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$10.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$10.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$11
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$11 extends Lambda {
    public static final HandleInvocationsFromAdViewer$invoke$definition$11 INSTANCE;

    static <clinit>() {
        new HandleInvocationsFromAdViewer$invoke$definition$11();
        INSTANCE = new HandleInvocationsFromAdViewer$invoke$definition$11(..);
        return;
    }

    HandleInvocationsFromAdViewer$invoke$definition$11() {
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        CommonAdViewerExposedFunctionsKt.deleteStorage();
        return CommonAdViewerExposedFunctionsKt.deleteStorage(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$11.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$11.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$12
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$12 extends Lambda {
    public static final HandleInvocationsFromAdViewer$invoke$definition$12 INSTANCE;

    static <clinit>() {
        new HandleInvocationsFromAdViewer$invoke$definition$12();
        INSTANCE = new HandleInvocationsFromAdViewer$invoke$definition$12(..);
        return;
    }

    HandleInvocationsFromAdViewer$invoke$definition$12() {
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        CommonAdViewerExposedFunctionsKt.clearStorage();
        return CommonAdViewerExposedFunctionsKt.clearStorage(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$12.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$12.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$13
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$13 extends Lambda {
    public static final HandleInvocationsFromAdViewer$invoke$definition$13 INSTANCE;

    static <clinit>() {
        new HandleInvocationsFromAdViewer$invoke$definition$13();
        INSTANCE = new HandleInvocationsFromAdViewer$invoke$definition$13(..);
        return;
    }

    HandleInvocationsFromAdViewer$invoke$definition$13() {
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        CommonAdViewerExposedFunctionsKt.getKeysStorage();
        return CommonAdViewerExposedFunctionsKt.getKeysStorage(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$13.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$13.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$14
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$14 extends Lambda {
    public static final HandleInvocationsFromAdViewer$invoke$definition$14 INSTANCE;

    static <clinit>() {
        new HandleInvocationsFromAdViewer$invoke$definition$14();
        INSTANCE = new HandleInvocationsFromAdViewer$invoke$definition$14(..);
        return;
    }

    HandleInvocationsFromAdViewer$invoke$definition$14() {
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        CommonAdViewerExposedFunctionsKt.getStorage();
        return CommonAdViewerExposedFunctionsKt.getStorage(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$14.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$14.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$15
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$15 extends Lambda {
    public static final HandleInvocationsFromAdViewer$invoke$definition$15 INSTANCE;

    static <clinit>() {
        new HandleInvocationsFromAdViewer$invoke$definition$15();
        INSTANCE = new HandleInvocationsFromAdViewer$invoke$definition$15(..);
        return;
    }

    HandleInvocationsFromAdViewer$invoke$definition$15() {
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        CommonAdViewerExposedFunctionsKt.setStorage();
        return CommonAdViewerExposedFunctionsKt.setStorage(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$15.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$15.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$16
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$16 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$16(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.getPrivacyFsm(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.getPrivacyFsm(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$16.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$16.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$17
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$17 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$17(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.setPrivacyFsm(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.setPrivacyFsm(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$17.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$17.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$18
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$18 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$18(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.getPrivacy(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.getPrivacy(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$18.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$18.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$19
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$19 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$19(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.setPrivacy(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.setPrivacy(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$19.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$19.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$2
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$2 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$2(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.getConnectionType(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.getConnectionType(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$2.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$2.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$20
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$20 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$20(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.getAllowedPii(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.getAllowedPii(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$20.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$20.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$21
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$21 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$21(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.setAllowedPii(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.setAllowedPii(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$21.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$21.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$22
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$22 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$22(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.getSessionToken(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.getSessionToken(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$22.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$22.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$23
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$23 extends Lambda {
    final AdObject $adObject;
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$23(HandleInvocationsFromAdViewer p0, AdObject p1) {
        this$0 = p0;
        $adObject = p1;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(CampaignRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.markCampaignStateShown(IServicesRegistry.getService(..), $adObject);
        return CommonAdViewerExposedFunctionsKt.markCampaignStateShown(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$23.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$23.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$24
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$24 extends Lambda {
    final AdObject $adObject;
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$24(HandleInvocationsFromAdViewer p0, AdObject p1) {
        this$0 = p0;
        $adObject = p1;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(Refresh.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.refreshAdData(IServicesRegistry.getService(..), $adObject);
        return CommonAdViewerExposedFunctionsKt.refreshAdData(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$24.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$24.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$25
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$25 extends Lambda {
    final AdObject $adObject;

    HandleInvocationsFromAdViewer$invoke$definition$25(AdObject p0) {
        $adObject = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        CommonAdViewerExposedFunctionsKt.updateTrackingToken($adObject);
        return CommonAdViewerExposedFunctionsKt.updateTrackingToken(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$25.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$25.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$26
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$26 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$26(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SendPrivacyUpdateRequest.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.sendPrivacyUpdateRequest(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.sendPrivacyUpdateRequest(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$26.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$26.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$27
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$27 extends Lambda {
    final AdObject $adObject;
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$27(HandleInvocationsFromAdViewer p0, AdObject p1) {
        this$0 = p0;
        $adObject = p1;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.sendDiagnosticEvent(IServicesRegistry.getService(..), $adObject);
        return CommonAdViewerExposedFunctionsKt.sendDiagnosticEvent(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$27.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$27.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$28
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$28 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$28(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.incrementBannerImpressionCount(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.incrementBannerImpressionCount(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$28.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$28.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$29
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$29 extends Lambda {
    final AdObject $adObject;
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$29(HandleInvocationsFromAdViewer p0, AdObject p1) {
        this$0 = p0;
        $adObject = p1;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(CacheFile.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.download(IServicesRegistry.getService(..), $adObject);
        return CommonAdViewerExposedFunctionsKt.download(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$29.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$29.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$3
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$3 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$3(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.getDeviceVolume(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.getDeviceVolume(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$3.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$3.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$30
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$30 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$30(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(GetIsFileCache.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.isFileCached(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.isFileCached(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$30.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$30.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$31
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$31 extends Lambda {
    final AdObject $adObject;
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$31(HandleInvocationsFromAdViewer p0, AdObject p1) {
        this$0 = p0;
        $adObject = p1;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(AndroidOmStartSession.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.omStartSession(IServicesRegistry.getService(..), $adObject);
        return CommonAdViewerExposedFunctionsKt.omStartSession(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$31.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$31.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$32
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$32 extends Lambda {
    final AdObject $adObject;
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$32(HandleInvocationsFromAdViewer p0, AdObject p1) {
        this$0 = p0;
        $adObject = p1;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(OmFinishSession.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.omFinishSession(IServicesRegistry.getService(..), $adObject);
        return CommonAdViewerExposedFunctionsKt.omFinishSession(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$32.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$32.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$33
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$33 extends Lambda {
    final AdObject $adObject;
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$33(HandleInvocationsFromAdViewer p0, AdObject p1) {
        this$0 = p0;
        $adObject = p1;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(OmImpressionOccurred.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.omImpression(IServicesRegistry.getService(..), $adObject);
        return CommonAdViewerExposedFunctionsKt.omImpression(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$33.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$33.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$34
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$34 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$34(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(GetOmData.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.omGetData(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.omGetData(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$34.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$34.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$35
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$35 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$35(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(AndroidAttribution.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.isAttributionAvailable(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.isAttributionAvailable(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$35.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$35.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$36
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$36 extends Lambda {
    final AdObject $adObject;
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$36(HandleInvocationsFromAdViewer p0, AdObject p1) {
        this$0 = p0;
        $adObject = p1;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(AndroidAttribution.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.attributionRegisterView(IServicesRegistry.getService(..), $adObject);
        return CommonAdViewerExposedFunctionsKt.attributionRegisterView(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$36.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$36.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$37
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$37 extends Lambda {
    final AdObject $adObject;
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$37(HandleInvocationsFromAdViewer p0, AdObject p1) {
        this$0 = p0;
        $adObject = p1;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(AndroidAttribution.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.attributionRegisterClick(IServicesRegistry.getService(..), $adObject);
        return CommonAdViewerExposedFunctionsKt.attributionRegisterClick(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$37.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$37.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$38
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$38 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$38(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.hbTokenIncrementWins(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.hbTokenIncrementWins(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$38.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$38.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$39
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$39 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$39(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.hbTokenIncrementStarts(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.hbTokenIncrementStarts(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$39.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$39.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$4
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$4 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$4(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.getDeviceMaxVolume(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.getDeviceMaxVolume(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$4.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$4.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$40
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$40 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$40(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.hbTokenReset(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.hbTokenReset(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$40.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$40.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$5
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$5 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$5(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.getScreenHeight(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.getScreenHeight(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$5.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$5.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$6
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$6 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$6(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.getScreenWidth(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.getScreenWidth(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$6.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$6.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$7
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$7 extends Lambda {
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$7(HandleInvocationsFromAdViewer p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(HandleOpenUrl.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.openUrl(IServicesRegistry.getService(..));
        return CommonAdViewerExposedFunctionsKt.openUrl(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$7.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$7.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$8
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$8 extends Lambda {
    final AdObject $adObject;
    final HandleInvocationsFromAdViewer this$0;

    HandleInvocationsFromAdViewer$invoke$definition$8(HandleInvocationsFromAdViewer p0, AdObject p1) {
        this$0 = p0;
        $adObject = p1;
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        this$0.getServiceProvider();
        IServiceProvider.getRegistry();
        Reflection.getOrCreateKotlinClass(GetOperativeEventApi.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        CommonAdViewerExposedFunctionsKt.sendOperativeEvent(IServicesRegistry.getService(..), $adObject);
        return CommonAdViewerExposedFunctionsKt.sendOperativeEvent(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$8.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$8.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer$invoke$definition$9
// ============================================================
package com.unity3d.ads.core.domain;

final class HandleInvocationsFromAdViewer$invoke$definition$9 extends Lambda {
    public static final HandleInvocationsFromAdViewer$invoke$definition$9 INSTANCE;

    static <clinit>() {
        new HandleInvocationsFromAdViewer$invoke$definition$9();
        INSTANCE = new HandleInvocationsFromAdViewer$invoke$definition$9(..);
        return;
    }

    HandleInvocationsFromAdViewer$invoke$definition$9() {
        new Lambda(0);
        return;
    }

    public final ExposedFunction invoke() {
        CommonAdViewerExposedFunctionsKt.writeStorage();
        return CommonAdViewerExposedFunctionsKt.writeStorage(..);
    }

    public Object invoke() {
        HandleInvocationsFromAdViewer$invoke$definition$9.invoke();
        return HandleInvocationsFromAdViewer$invoke$definition$9.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyLoadUseCase$Companion
// ============================================================
package com.unity3d.ads.core.domain;

public final class LegacyLoadUseCase$Companion {
    private LegacyLoadUseCase$Companion() {
        new Object();
        return;
    }

    public LegacyLoadUseCase$Companion(DefaultConstructorMarker p0) {
        new LegacyLoadUseCase$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyLoadUseCase$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final LegacyLoadUseCase this$0;

    LegacyLoadUseCase$invoke$1(LegacyLoadUseCase p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, 0, 0, 0, 0, this);
        return LegacyLoadUseCase.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$loadResult$1
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyLoadUseCase$invoke$loadResult$1 extends SuspendLambda {
    final String $adMarkup;
    final Context $context;
    final AdRequestOuterClass$BannerSize $gatewayBannerSize;
    final UnityAdsLoadOptions $loadOptions;
    final String $placement;
    Object L$0;
    Object L$1;
    int label;
    final LegacyLoadUseCase this$0;

    LegacyLoadUseCase$invoke$loadResult$1(String p0, LegacyLoadUseCase p1, UnityAdsLoadOptions p2, String p3, Context p4, AdRequestOuterClass$BannerSize p5, Continuation p6) {
        $placement = p0;
        this$0 = p1;
        $loadOptions = p2;
        $adMarkup = p3;
        $context = p4;
        $gatewayBannerSize = p5;
        new SuspendLambda(2, p6);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new LegacyLoadUseCase$invoke$loadResult$1($placement, this$0, $loadOptions, $adMarkup, $context, $gatewayBannerSize, p1);
        return new LegacyLoadUseCase$invoke$loadResult$1;
    }

    public Object invoke(Object p0, Object p1) {
        LegacyLoadUseCase$invoke$loadResult$1.invoke(p0, p1);
        return LegacyLoadUseCase$invoke$loadResult$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        LegacyLoadUseCase$invoke$loadResult$1.create(p0, p1);
        LegacyLoadUseCase$invoke$loadResult$1.invokeSuspend(Unit.INSTANCE);
        return LegacyLoadUseCase$invoke$loadResult$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_49;
        if (if-eq(label, 1)) goto L_3e;
        if (if-eq(label, 2)) goto L_37;
        if (if-eq(label, 3)) goto L_26;
        if (if-ne(label, 4)) goto L_1e;
        ResultKt.throwOnFailure(p0);
      L_1e:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_26:
        ResultKt.throwOnFailure(p0);
      L_37:
        ResultKt.throwOnFailure(p0);
      L_3e:
        ResultKt.throwOnFailure(p0);
      L_47:
      L_49:
        ResultKt.throwOnFailure(p0);
        if (if-nez($placement)) goto L_62;
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.INVALID_ARGUMENT, "[UnityAds] Placement ID cannot be null", 0, "placement_null", 0, 20, 0);
        return new LoadResult$Failure;
      L_62:
        LegacyLoadUseCase.access$getOpportunityId(this$0, $loadOptions);
        if (if-nez(LegacyLoadUseCase.access$getOpportunityId(..))) goto L_7e;
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.INVALID_ARGUMENT, "[UnityAds] Object ID cannot be null", 0, "no_opportunity_id", 0, 20, 0);
        return new LoadResult$Failure;
      L_7e:
        UUID.fromString(LegacyLoadUseCase.access$getOpportunityId(..));
        ProtobufExtensionsKt.toByteString(UUID.fromString(..));
        LegacyLoadUseCase.access$setOpportunity$p(this$0, ProtobufExtensionsKt.toByteString(..));
        LegacyLoadUseCase.access$getAdRepository$p(this$0);
        L$0 = ProtobufExtensionsKt.toByteString(..);
        label = 1;
        AdRepository.hasOpportunityId(ProtobufExtensionsKt.toByteString(..), this);
        if (if-ne(AdRepository.hasOpportunityId(..), new LoadResult$Failure)) goto L_47;
        return new LoadResult$Failure;
      L_a4:
        AdRepository.hasOpportunityId(..).booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_bf;
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.INVALID_ARGUMENT, "[UnityAds] Object ID already used", 0, "opportunity_id_used", 0, 20, 0);
      L_bf:
        LegacyLoadUseCase.access$getHeaderBiddingAdMarkup(this$0, $adMarkup);
        if (if-nez(LegacyLoadUseCase.access$getHeaderBiddingAdMarkup(..))) goto L_e4;
        if (if-nez($adMarkup)) goto L_d9;
      L_d9:
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.INTERNAL_ERROR, "[UnityAds] Could not parse Ad Markup", 0, "invalid_admarkup", "", 4, 0);
        return new LoadResult$Failure;
      L_e4:
        LegacyLoadUseCase.access$getGetInitializationState$p(this$0);
        GetInitializationState.invoke();
        GetInitializationState.invoke(..).ordinal();
        if (if-eq(InitializationState.ordinal(..), 1)) goto L_188;
        if (if-eq(InitializationState.ordinal(..), 2)) goto L_176;
        if (if-eq(InitializationState.ordinal(..), L$0)) goto L_176;
        if (if-ne(InitializationState.ordinal(..), 4)) goto L_170;
        LegacyLoadUseCase.access$getAwaitInitialization$p(this$0);
        L$0 = "no_opportunity_id";
        L$1 = LegacyLoadUseCase.access$getHeaderBiddingAdMarkup(..);
        label = L$0;
        AwaitInitialization$DefaultImpls.invoke$default(LegacyLoadUseCase.access$getAwaitInitialization$p(..), 0L, "[UnityAds] Could not parse Ad Markup", this, 1, 0);
        if (if-ne(AwaitInitialization$DefaultImpls.invoke$default(..), new LoadResult$Failure)) goto L_11b;
        return new LoadResult$Failure;
      L_11b:
      L_11d:
        if (if-nez(AwaitInitialization$DefaultImpls.invoke$default(..))) goto L_123;
      L_123:
        -1.ordinal();
      L_12b:
        if (if-eq(InitializationState.ordinal(..), 1)) goto L_14e;
        if (if-ne(InitializationState.ordinal(..), 2)) goto L_146;
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.INITIALIZE_FAILED, "[UnityAds] SDK not initialized", 0, "not_initialized", 0, 20, 0);
      L_146:
        new IllegalStateException("awaitInitialization timeout");
        throw new IllegalStateException(..);
      L_14e:
        LegacyLoadUseCase.access$getLoad$p(this$0);
        L$0 = 0;
        L$1 = 0;
        label = 4;
        Load.invoke($context, $placement, "no_opportunity_id", LegacyLoadUseCase.access$getHeaderBiddingAdMarkup(..), $gatewayBannerSize, $loadOptions, this);
        if (if-ne(Load.invoke(..), new IllegalStateException(..))) goto L_16c;
        return new IllegalStateException(..);
      L_16c:
      L_170:
        new NoWhenBranchMatchedException();
        throw new NoWhenBranchMatchedException(..);
      L_176:
        new LoadResult$Failure(UnityAds$UnityAdsLoadError.INITIALIZE_FAILED, "[UnityAds] SDK not initialized", 0, "not_initialized", 0, 20, 0);
        return new LoadResult$Failure;
      L_188:
        LegacyLoadUseCase.access$getLoad$p(this$0);
        L$0 = UnityAds$UnityAdsLoadError.INITIALIZE_FAILED;
        label = "not_initialized";
        Load.invoke($context, $placement, LegacyLoadUseCase.access$getHeaderBiddingAdMarkup(..), $gatewayBannerSize, $gatewayBannerSize, $loadOptions, this);
        if (if-ne(Load.invoke(..), new LoadResult$Failure)) goto L_1a5;
        return new LoadResult$Failure;
      L_1a5:
      L_1a8:
        return Load.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyLoadUseCase$loadFailure$2
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyLoadUseCase$loadFailure$2 extends SuspendLambda {
    final LoadResult$Failure $loadResult;
    int label;
    final LegacyLoadUseCase this$0;

    public static void $r8$lambda$F46s5Zp_zDk14WhLIPNzG4s_KQ4(LegacyLoadUseCase p0, LoadResult$Failure p1) {
        LegacyLoadUseCase$loadFailure$2.invokeSuspend$lambda$0(p0, p1);
        return;
    }

    LegacyLoadUseCase$loadFailure$2(LegacyLoadUseCase p0, LoadResult$Failure p1, Continuation p2) {
        this$0 = p0;
        $loadResult = p1;
        new SuspendLambda(2, p2);
        return;
    }

    private static final void invokeSuspend$lambda$0(LegacyLoadUseCase p0, LoadResult$Failure p1) {
        LegacyLoadUseCase.access$getListener$p(p0);
        if (if-eqz(LegacyLoadUseCase.access$getListener$p(..))) goto L_15;
        LegacyLoadUseCase.access$getPlacement$p(p0);
        p1.getError();
        p1.getMessage();
        IUnityAdsLoadListener.onUnityAdsFailedToLoad(LegacyLoadUseCase.access$getPlacement$p(..), LoadResult$Failure.getError(..), LoadResult$Failure.getMessage(..));
      L_15:
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new LegacyLoadUseCase$loadFailure$2(this$0, $loadResult, p1);
        return new LegacyLoadUseCase$loadFailure$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        LegacyLoadUseCase$loadFailure$2.invoke(p0, p1);
        return LegacyLoadUseCase$loadFailure$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        LegacyLoadUseCase$loadFailure$2.create(p0, p1);
        LegacyLoadUseCase$loadFailure$2.invokeSuspend(Unit.INSTANCE);
        return LegacyLoadUseCase$loadFailure$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_19;
        ResultKt.throwOnFailure(p0);
        new LegacyLoadUseCase$loadFailure$2$$ExternalSyntheticLambda0(this$0, $loadResult);
        Utilities.wrapCustomerListener(new LegacyLoadUseCase$loadFailure$2$$ExternalSyntheticLambda0(..));
        return Unit.INSTANCE;
      L_19:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyLoadUseCase$loadSuccess$2
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyLoadUseCase$loadSuccess$2 extends SuspendLambda {
    int label;
    final LegacyLoadUseCase this$0;

    public static void $r8$lambda$4WORRfaZ72-qQV4m3zKTm7RmTEU(LegacyLoadUseCase p0) {
        LegacyLoadUseCase$loadSuccess$2.invokeSuspend$lambda$0(p0);
        return;
    }

    LegacyLoadUseCase$loadSuccess$2(LegacyLoadUseCase p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    private static final void invokeSuspend$lambda$0(LegacyLoadUseCase p0) {
        LegacyLoadUseCase.access$getListener$p(p0);
        if (if-eqz(LegacyLoadUseCase.access$getListener$p(..))) goto L_d;
        LegacyLoadUseCase.access$getPlacement$p(p0);
        IUnityAdsLoadListener.onUnityAdsAdLoaded(LegacyLoadUseCase.access$getPlacement$p(..));
      L_d:
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new LegacyLoadUseCase$loadSuccess$2(this$0, p1);
        return new LegacyLoadUseCase$loadSuccess$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        LegacyLoadUseCase$loadSuccess$2.invoke(p0, p1);
        return LegacyLoadUseCase$loadSuccess$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        LegacyLoadUseCase$loadSuccess$2.create(p0, p1);
        LegacyLoadUseCase$loadSuccess$2.invokeSuspend(Unit.INSTANCE);
        return LegacyLoadUseCase$loadSuccess$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_17;
        ResultKt.throwOnFailure(p0);
        new LegacyLoadUseCase$loadSuccess$2$$ExternalSyntheticLambda0(this$0);
        Utilities.wrapCustomerListener(new LegacyLoadUseCase$loadSuccess$2$$ExternalSyntheticLambda0(..));
        return Unit.INSTANCE;
      L_17:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyShowUseCase$Companion
// ============================================================
package com.unity3d.ads.core.domain;

public final class LegacyShowUseCase$Companion {
    private LegacyShowUseCase$Companion() {
        new Object();
        return;
    }

    public LegacyShowUseCase$Companion(DefaultConstructorMarker p0) {
        new LegacyShowUseCase$Companion();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyShowUseCase$getTmpAdObject$1
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyShowUseCase$getTmpAdObject$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final LegacyShowUseCase this$0;

    LegacyShowUseCase$getTmpAdObject$1(LegacyShowUseCase p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        LegacyShowUseCase.access$getTmpAdObject(this$0, this);
        return LegacyShowUseCase.access$getTmpAdObject(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyShowUseCase$invoke$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    Object result;
    final LegacyShowUseCase this$0;

    LegacyShowUseCase$invoke$1(LegacyShowUseCase p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, 0, 0, 0, this);
        return LegacyShowUseCase.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$2
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyShowUseCase$invoke$2 extends SuspendLambda {
    final AdObject $adObject;
    final boolean $isBanner;
    final String $placement;
    final Function6 $reportShowError;
    final boolean $useTimeout;
    Object L$0;
    int label;
    final LegacyShowUseCase this$0;

    LegacyShowUseCase$invoke$2(LegacyShowUseCase p0, boolean p1, AdObject p2, boolean p3, Function6 p4, String p5, Continuation p6) {
        this$0 = p0;
        $isBanner = p1;
        $adObject = p2;
        $useTimeout = p3;
        $reportShowError = p4;
        $placement = p5;
        new SuspendLambda(2, p6);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new LegacyShowUseCase$invoke$2(this$0, $isBanner, $adObject, $useTimeout, $reportShowError, $placement, p1);
        L$0 = p0;
        return new LegacyShowUseCase$invoke$2;
    }

    public Object invoke(Object p0, Object p1) {
        LegacyShowUseCase$invoke$2.invoke(p0, p1);
        return LegacyShowUseCase$invoke$2.invoke(..);
    }

    public final Object invoke(Function0 p0, Continuation p1) {
        LegacyShowUseCase$invoke$2.create(p0, p1);
        LegacyShowUseCase$invoke$2.invokeSuspend(Unit.INSTANCE);
        return LegacyShowUseCase$invoke$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_32;
        if (if-eq(label, 1)) goto L_2a;
        if (if-eq(label, 2)) goto L_22;
        if (if-ne(label, 3)) goto L_1a;
        ResultKt.throwOnFailure(p0);
      L_1a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_22:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_2a:
        ResultKt.throwOnFailure(new IllegalStateException(..));
      L_32:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        LegacyShowUseCase.access$getHasStarted$p(this$0);
        MutableStateFlow.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        if (if-nez(Boolean.booleanValue(..))) goto L_be;
        LegacyShowUseCase.access$getTimeoutCancellationRequested$p(this$0);
        MutableStateFlow.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        if (if-nez(Boolean.booleanValue(..))) goto L_be;
        if (if-eqz($isBanner)) goto L_63;
      L_63:
        L$0 = L$0;
        label = 1;
        LegacyShowUseCase.access$sendOperativeError(this$0, OperativeEventRequestOuterClass$OperativeEventErrorType.OPERATIVE_EVENT_ERROR_TYPE_TIMEOUT, "timeout", $adObject, this);
        if (if-ne(LegacyShowUseCase.access$sendOperativeError(..), "call to 'resume' before 'invoke' with coroutine")) goto L_79;
        return "call to 'resume' before 'invoke' with coroutine";
      L_79:
        if (if-eqz($useTimeout)) goto L_bb;
        LegacyShowUseCase.access$getShow$p(this$0);
        L$0 = L$0;
        label = 2;
        Show.terminate($adObject, this);
        if (if-ne(Show.terminate(..), "call to 'resume' before 'invoke' with coroutine")) goto L_93;
        return "call to 'resume' before 'invoke' with coroutine";
      L_93:
        new StringBuilder("[UnityAds] Timeout while trying to show ");
        new StringBuilder(..).append($placement);
        new StringBuilder(..).toString();
        L$0 = L$0;
        label = 3;
        $reportShowError.invoke("timeout", UnityAds$UnityAdsShowError.TIMEOUT, StringBuilder.toString(..), 0, 0, this);
        if (if-ne(Function6.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_b7;
        return "call to 'resume' before 'invoke' with coroutine";
      L_b7:
      L_b8:
        L$0.invoke();
      L_bb:
        return Unit.INSTANCE;
      L_be:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$3
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyShowUseCase$invoke$3 extends SuspendLambda {
    final boolean $isBanner;
    final Function6 $reportShowError;
    Object L$0;
    int label;

    LegacyShowUseCase$invoke$3(Function6 p0, boolean p1, Continuation p2) {
        $reportShowError = p0;
        $isBanner = p1;
        new SuspendLambda(3, p2);
        return;
    }

    public Object invoke(Object p0, Object p1, Object p2) {
        LegacyShowUseCase$invoke$3.invoke(p0, p1, p2);
        return LegacyShowUseCase$invoke$3.invoke(..);
    }

    public final Object invoke(FlowCollector p0, Throwable p1, Continuation p2) {
        new LegacyShowUseCase$invoke$3($reportShowError, $isBanner, p2);
        L$0 = p1;
        new LegacyShowUseCase$invoke$3(..).invokeSuspend(Unit.INSTANCE);
        return LegacyShowUseCase$invoke$3.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_17;
        if (if-ne(label, 1)) goto L_f;
        ResultKt.throwOnFailure(p0);
      L_f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_17:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        L$0.getMessage();
        if (if-nez(Throwable.getMessage(..))) goto L_2c;
      L_2c:
        label = 1;
        $reportShowError.invoke("uncaught_exception", UnityAds$UnityAdsShowError.INTERNAL_ERROR, "", 0, 0, this);
        if (if-ne(Function6.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_39;
        return "call to 'resume' before 'invoke' with coroutine";
      L_39:
        if (if-nez($isBanner)) goto L_43;
        LegacyShowUseCase.access$setFullscreenAdShowing$cp(0);
      L_43:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyShowUseCase$invoke$4 {
    final AdObject $adObject;
    final Listeners $listeners;
    final String $placement;
    final Function6 $reportShowError;
    final long $startTime;
    final LegacyShowUseCase this$0;

    LegacyShowUseCase$invoke$4(LegacyShowUseCase p0, long p1, String p2, Listeners p3, AdObject p4, Function6 p5) {
        this$0 = p0;
        $startTime = p1;
        $placement = p2;
        $listeners = p3;
        $adObject = p4;
        $reportShowError = p5;
        new Object();
        return;
    }

    public final Object emit(ShowEvent p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new LegacyShowUseCase$invoke$4$emit$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_59;
        if (if-eq(label, 1)) goto L_55;
        if (if-eq(label, 2)) goto L_51;
        if (if-eq(label, 3)) goto L_4d;
        if (if-eq(label, 4)) goto L_40;
        if (if-ne(label, 5)) goto L_38;
        ResultKt.throwOnFailure(result);
      L_38:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_40:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_4d:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_51:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_55:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_59:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        if (if-eqz("call to 'resume' before 'invoke' with coroutine")) goto L_78;
        TimeSource$Monotonic$ValueTimeMark.box-impl($startTime, 5);
        label = 1;
        LegacyShowUseCase.access$showStarted(this$0, TimeSource$Monotonic$ValueTimeMark.box-impl(..), $placement, $listeners, new LegacyShowUseCase$invoke$4$emit$1(..));
        if (if-ne(LegacyShowUseCase.access$showStarted(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_75;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_75:
        return Unit.INSTANCE;
      L_78:
        if (if-eqz(TimeSource$Monotonic$ValueTimeMark.box-impl(..))) goto L_94;
        TimeSource$Monotonic$ValueTimeMark.box-impl($startTime, $listeners);
        label = 2;
        LegacyShowUseCase.access$showClicked(this$0, TimeSource$Monotonic$ValueTimeMark.box-impl(..), $placement, $listeners, new LegacyShowUseCase$invoke$4$emit$1(..));
        if (if-ne(LegacyShowUseCase.access$showClicked(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_91;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_91:
        return Unit.INSTANCE;
      L_94:
        if (if-eqz(TimeSource$Monotonic$ValueTimeMark.box-impl(..))) goto L_b8;
        TimeSource$Monotonic$ValueTimeMark.box-impl($startTime, 4);
        Unit.INSTANCE.getStatus();
        label = 3;
        LegacyShowUseCase.access$showCompleted(this$0, TimeSource$Monotonic$ValueTimeMark.box-impl(..), $placement, ShowEvent$Completed.getStatus(..), $listeners, new LegacyShowUseCase$invoke$4$emit$1(..));
        if (if-ne(LegacyShowUseCase.access$showCompleted(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_b5;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_b5:
        return Unit.INSTANCE;
      L_b8:
        if (if-eqz(TimeSource$Monotonic$ValueTimeMark.box-impl(..))) goto L_103;
        Unit.INSTANCE.getMessage();
        L$0 = this;
        L$1 = Unit.INSTANCE;
        label = $placement;
        LegacyShowUseCase.access$sendOperativeError(this$0, OperativeEventRequestOuterClass$OperativeEventErrorType.OPERATIVE_EVENT_ERROR_TYPE_UNSPECIFIED, ShowEvent$Error.getMessage(..), $adObject, new LegacyShowUseCase$invoke$4$emit$1(..));
        if (if-ne(LegacyShowUseCase.access$sendOperativeError(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_d6;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_d6:
      L_d7:
        Unit.INSTANCE.getReason();
        Unit.INSTANCE.getMessage();
        Unit.INSTANCE.getErrorCode();
        Boxing.boxInt(ShowEvent$Error.getErrorCode(..));
        Unit.INSTANCE.getMessage();
        L$0 = 0;
        L$1 = 0;
        label = TimeSource$Monotonic$ValueTimeMark.box-impl(..);
        $reportShowError.invoke(ShowEvent$Error.getReason(..), UnityAds$UnityAdsShowError.INTERNAL_ERROR, ShowEvent$Error.getMessage(..), Boxing.boxInt(..), ShowEvent$Error.getMessage(..), new LegacyShowUseCase$invoke$4$emit$1(..));
        if (if-ne(Function6.invoke(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_100;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_100:
        return Unit.INSTANCE;
      L_103:
        if (if-eqz(ShowEvent$Error.getReason(..))) goto L_113;
        TimeSource$Monotonic$ValueTimeMark.box-impl($startTime, $reportShowError);
        LegacyShowUseCase.access$cancelTimeout(this$0, TimeSource$Monotonic$ValueTimeMark.box-impl(..));
      L_113:
        if (if-eqz(this$0)) goto L_126;
        TimeSource$Monotonic$ValueTimeMark.box-impl($startTime, $reportShowError);
        LegacyShowUseCase.access$bannerLeftApplication(this$0, TimeSource$Monotonic$ValueTimeMark.box-impl(..), $placement, $listeners);
      L_126:
        return Unit.INSTANCE;
    }

    public Object emit(Object p0, Continuation p1) {
        LegacyShowUseCase$invoke$4.emit(p0, p1);
        return LegacyShowUseCase$invoke$4.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4$emit$1
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyShowUseCase$invoke$4$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final LegacyShowUseCase$invoke$4 this$0;

    LegacyShowUseCase$invoke$4$emit$1(LegacyShowUseCase$invoke$4 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return LegacyShowUseCase$invoke$4.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyShowUseCase$showClicked$2
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyShowUseCase$showClicked$2 extends SuspendLambda {
    final Listeners $listeners;
    final String $placement;
    int label;

    LegacyShowUseCase$showClicked$2(Listeners p0, String p1, Continuation p2) {
        $listeners = p0;
        $placement = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new LegacyShowUseCase$showClicked$2($listeners, $placement, p1);
        return new LegacyShowUseCase$showClicked$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        LegacyShowUseCase$showClicked$2.invoke(p0, p1);
        return LegacyShowUseCase$showClicked$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        LegacyShowUseCase$showClicked$2.create(p0, p1);
        LegacyShowUseCase$showClicked$2.invokeSuspend(Unit.INSTANCE);
        return LegacyShowUseCase$showClicked$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_14;
        ResultKt.throwOnFailure(p0);
        $listeners.onClick($placement);
        return Unit.INSTANCE;
      L_14:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyShowUseCase$showCompleted$2
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyShowUseCase$showCompleted$2 extends SuspendLambda {
    final Listeners $listeners;
    final String $placement;
    final ShowStatus $status;
    int label;

    LegacyShowUseCase$showCompleted$2(Listeners p0, String p1, ShowStatus p2, Continuation p3) {
        $listeners = p0;
        $placement = p1;
        $status = p2;
        new SuspendLambda(2, p3);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new LegacyShowUseCase$showCompleted$2($listeners, $placement, $status, p1);
        return new LegacyShowUseCase$showCompleted$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        LegacyShowUseCase$showCompleted$2.invoke(p0, p1);
        return LegacyShowUseCase$showCompleted$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        LegacyShowUseCase$showCompleted$2.create(p0, p1);
        LegacyShowUseCase$showCompleted$2.invokeSuspend(Unit.INSTANCE);
        return LegacyShowUseCase$showCompleted$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_1a;
        ResultKt.throwOnFailure(p0);
        ShowStatusExtensionsKt.toUnityAdsShowCompletionState($status);
        $listeners.onComplete($placement, ShowStatusExtensionsKt.toUnityAdsShowCompletionState(..));
        return Unit.INSTANCE;
      L_1a:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyShowUseCase$showError$1 extends SuspendLambda {
    final Listeners $listeners;
    final String $placement;
    final TimeMark $startTime;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final LegacyShowUseCase this$0;

    LegacyShowUseCase$showError$1(String p0, LegacyShowUseCase p1, TimeMark p2, Listeners p3, Continuation p4) {
        $placement = p0;
        this$0 = p1;
        $startTime = p2;
        $listeners = p3;
        new SuspendLambda(6, p4);
        return;
    }

    public Object invoke(Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        LegacyShowUseCase$showError$1.invoke(p0, p1, p2, p3, p4, p5);
        return LegacyShowUseCase$showError$1.invoke(..);
    }

    public final Object invoke(String p0, UnityAds$UnityAdsShowError p1, String p2, Integer p3, String p4, Continuation p5) {
        new LegacyShowUseCase$showError$1($placement, this$0, $startTime, $listeners, p5);
        L$0 = p0;
        L$1 = p1;
        L$2 = p2;
        L$3 = p3;
        L$4 = p4;
        new LegacyShowUseCase$showError$1.invokeSuspend(Unit.INSTANCE);
        return LegacyShowUseCase$showError$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_1a;
        if (if-ne(label, 1)) goto L_12;
        ResultKt.throwOnFailure(p0);
      L_12:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_1a:
        ResultKt.throwOnFailure(p0);
        new StringBuilder("Unity Ads Show Failed for placement ");
        new StringBuilder(..).append($placement);
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        LegacyShowUseCase.access$getSendDiagnosticEvent$p(this$0);
        TimeExtensionsKt.elapsedMillis($startTime);
        Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(..), $placement);
        LegacyShowUseCase.access$getTags(this$0, L$0, L$3, L$4);
        LegacyShowUseCase.access$getAdObject$p(this$0);
        SendDiagnosticEvent$DefaultImpls.invoke$default(LegacyShowUseCase.access$getSendDiagnosticEvent$p(..), "native_show_failure_time", Boxing.boxDouble(..), LegacyShowUseCase.access$getTags(..), 0, LegacyShowUseCase.access$getAdObject$p(..), 8, 0);
        LegacyShowUseCase.access$getDispatcher$p(this$0);
        new LegacyShowUseCase$showError$1$1($listeners, $placement, L$1, L$2, 0);
        L$0 = 0;
        L$1 = 0;
        L$2 = 0;
        L$3 = 0;
        label = 1;
        BuildersKt.withContext(LegacyShowUseCase.access$getDispatcher$p(..), new LegacyShowUseCase$showError$1$1, this);
        if (if-ne(BuildersKt.withContext(..), new IllegalStateException(..))) goto L_96;
        return new IllegalStateException(..);
      L_96:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1$1
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyShowUseCase$showError$1$1 extends SuspendLambda {
    final Listeners $listeners;
    final String $message;
    final String $placement;
    final UnityAds$UnityAdsShowError $reason;
    int label;

    LegacyShowUseCase$showError$1$1(Listeners p0, String p1, UnityAds$UnityAdsShowError p2, String p3, Continuation p4) {
        $listeners = p0;
        $placement = p1;
        $reason = p2;
        $message = p3;
        new SuspendLambda(2, p4);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new LegacyShowUseCase$showError$1$1($listeners, $placement, $reason, $message, p1);
        return new LegacyShowUseCase$showError$1$1;
    }

    public Object invoke(Object p0, Object p1) {
        LegacyShowUseCase$showError$1$1.invoke(p0, p1);
        return LegacyShowUseCase$showError$1$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        LegacyShowUseCase$showError$1$1.create(p0, p1);
        LegacyShowUseCase$showError$1$1.invokeSuspend(Unit.INSTANCE);
        return LegacyShowUseCase$showError$1$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_18;
        ResultKt.throwOnFailure(p0);
        $listeners.onError($placement, $reason, $message);
        return Unit.INSTANCE;
      L_18:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyShowUseCase$showStart$1
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyShowUseCase$showStart$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final LegacyShowUseCase this$0;

    LegacyShowUseCase$showStart$1(LegacyShowUseCase p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        LegacyShowUseCase.access$showStart(this$0, this);
        return LegacyShowUseCase.access$showStart(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.LegacyShowUseCase$showStarted$2
// ============================================================
package com.unity3d.ads.core.domain;

final class LegacyShowUseCase$showStarted$2 extends SuspendLambda {
    final Listeners $listeners;
    final String $placement;
    int label;

    LegacyShowUseCase$showStarted$2(Listeners p0, String p1, Continuation p2) {
        $listeners = p0;
        $placement = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new LegacyShowUseCase$showStarted$2($listeners, $placement, p1);
        return new LegacyShowUseCase$showStarted$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        LegacyShowUseCase$showStarted$2.invoke(p0, p1);
        return LegacyShowUseCase$showStarted$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        LegacyShowUseCase$showStarted$2.create(p0, p1);
        LegacyShowUseCase$showStarted$2.invokeSuspend(Unit.INSTANCE);
        return LegacyShowUseCase$showStarted$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_14;
        ResultKt.throwOnFailure(p0);
        $listeners.onStart($placement);
        return Unit.INSTANCE;
      L_14:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.Load$DefaultImpls
// ============================================================
package com.unity3d.ads.core.domain;

public final class Load$DefaultImpls {
    public static Object invoke$default(Load p0, Context p1, String p2, ByteString p3, HeaderBiddingAdMarkupOuterClass$HeaderBiddingAdMarkup p4, AdRequestOuterClass$BannerSize p5, UnityAdsLoadOptions p6, Continuation p7, int p8, Object p9) {
        if (if-nez(p9)) goto L_17;
        if (if-eqz(v0)) goto L_9;
      L_9:
      L_a:
        p0.invoke(p1, p2, p3, p4, p5, p6, p7);
        return Load.invoke(..);
      L_17:
        new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        throw new UnsupportedOperationException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.SendDiagnosticEvent$Companion
// ============================================================
package com.unity3d.ads.core.domain;

public final class SendDiagnosticEvent$Companion {
    static final SendDiagnosticEvent$Companion $$INSTANCE = null;
    public static final String APP_ACTIVE = "app_active";
    public static final String ATTEMPT_INSERT_NULL_DIAGNOSTIC_EVENT = "attempt_insert_null_diagnostic_event";
    public static final String AWAITED_INIT = "awaited_init";
    public static final String BILLING_SERVICE_UNAVAILABLE = "billing_service_unavailable";
    public static final String BRIDGE_SEND_EVENT_FAILED = "bridge_send_event_failed";
    public static final String CACHE_SOURCE = "cache_source";
    public static final String COMPLETE_STATE = "complete_state";
    public static final String COROUTINE_NAME = "coroutine_name";
    public static final String HB_FAILURE = "native_gateway_token_failure_time";
    public static final String HB_STARTED = "native_gateway_token_started";
    public static final String HB_SUCCESS = "native_gateway_token_success_time";
    public static final String INIT_CLEAR_CACHE = "native_initialize_clear_cache_time";
    public static final String INIT_COMPLETED_FAILURE = "native_initialize_completed_task_failure_time";
    public static final String INIT_COMPLETED_STARTED = "native_initialization_completed_started";
    public static final String INIT_COMPLETED_SUCCESS = "native_initialize_completed_task_success_time";
    public static final String INIT_FAILURE = "native_initialize_task_failure_time";
    public static final String INIT_MISSED_NATIVE_PARSING = "native_initialize_missed_native_parsing";
    public static final String INIT_STARTED = "native_initialization_started";
    public static final String INIT_SUCCESS = "native_initialize_task_success_time";
    public static final String LOAD_CACHE_FAILURE = "native_load_cache_failure_time";
    public static final String LOAD_CACHE_SUCCESS = "native_load_cache_success_time";
    public static final String LOAD_FAILURE = "native_load_failure_time";
    public static final String LOAD_STARTED = "native_load_started";
    public static final String LOAD_STARTED_AD_VIEWER = "native_load_started_ad_viewer";
    public static final String LOAD_SUCCESS = "native_load_success_time";
    public static final String NETWORK_CLIENT = "network_client";
    public static final String NETWORK_FAILURE = "native_network_failure_time";
    public static final String NETWORK_PARSE = "native_network_parse_failure";
    public static final String NETWORK_SUCCESS = "native_network_success_time";
    public static final String NULL_DIAGNOSTIC_EVENT = "null_diagnostic_event";
    public static final String OM_ACTIVATE_FAILURE = "om_activate_failure_time";
    public static final String OM_ACTIVATE_STARTED = "om_activate_started";
    public static final String OM_ACTIVATE_SUCCESS = "om_activate_success_time";
    public static final String OM_IMPRESSION_OCCURRED_FAILURE = "om_impression_occurred_failure";
    public static final String OM_IMPRESSION_OCCURRED_SUCCESS = "om_impression_occurred_success";
    public static final String OM_SESSION_FINISH_FAILURE = "om_session_finish_failure";
    public static final String OM_SESSION_FINISH_SUCCESS = "om_session_finish_success";
    public static final String OM_SESSION_START_FAILURE = "om_session_start_failure";
    public static final String OM_SESSION_START_SUCCESS = "om_session_start_success";
    public static final String OPERATION = "operation";
    public static final String PROTOCOL = "protocol";
    public static final String REASON = "reason";
    public static final String REASON_AD_MARKUP_PARSE = "invalid_admarkup";
    public static final String REASON_AD_OBJECT_NOT_FOUND = "ad_object_not_found";
    public static final String REASON_AD_PLAYER_SCOPE = "ad_player_scope_not_active";
    public static final String REASON_AD_VIEWER = "adviewer";
    public static final String REASON_ALREADY_SHOWING = "already_showing";
    public static final String REASON_CODE = "reason_code";
    public static final String REASON_DEBUG = "reason_debug";
    public static final String REASON_GATEWAY = "gateway";
    public static final String REASON_INVALID_ENTRY_POINT = "invalid_url";
    public static final String REASON_LISTENER_NULL = "listener_null";
    public static final String REASON_NETWORK = "network";
    public static final String REASON_NOT_INITIALIZED = "not_initialized";
    public static final String REASON_NO_FILL = "no_fill";
    public static final String REASON_NO_WEBVIEW_ENTRY_POINT = "no_webview_entry_point";
    public static final String REASON_OM_ALREADY_ACTIVE = "om_already_active";
    public static final String REASON_OM_CREATIVE_TYPE_INVALID = "om_creative_type_invalid";
    public static final String REASON_OM_CREATIVE_TYPE_NULL = "om_creative_type_null";
    public static final String REASON_OM_NOT_ACTIVE = "om_not_active";
    public static final String REASON_OM_SESSION_ALREADY_EXISTS = "om_session_already_exists";
    public static final String REASON_OM_SESSION_NOT_FOUND = "om_session_not_found";
    public static final String REASON_OPPORTUNITY_ID = "no_opportunity_id";
    public static final String REASON_OPPORTUNITY_USED = "opportunity_id_used";
    public static final String REASON_PLACEMENT_NULL = "placement_null";
    public static final String REASON_PLACEMENT_VALIDATION = "placement_validation";
    public static final String REASON_PROTOBUF_PARSING = "protobuf_parsing";
    public static final String REASON_TIMEOUT = "timeout";
    public static final String REASON_UNCAUGHT_EXCEPTION = "uncaught_exception";
    public static final String REASON_UNKNOWN = "unknown";
    public static final String RETRIES = "retries";
    public static final String SAME_SESSION = "same_session";
    public static final String SHOW_CANCEL_TIMEOUT = "native_show_cancel_timeout";
    public static final String SHOW_CLICKED = "native_show_clicked";
    public static final String SHOW_FAILURE = "native_show_failure_time";
    public static final String SHOW_HAS_STARTED = "show_has_started";
    public static final String SHOW_IS_FILE_CACHED_FAILURE = "native_show_is_file_cached_failure_time";
    public static final String SHOW_IS_FILE_CACHED_SUCCESS = "native_show_is_file_cached_success_time";
    public static final String SHOW_LEFT_APPLICATION = "native_show_left_app";
    public static final String SHOW_STARTED = "native_show_started";
    public static final String SHOW_STARTED_AD_VIEWER = "native_show_started_ad_viewer";
    public static final String SHOW_SUCCESS = "native_show_success_time";
    public static final String SHOW_WV_STARTED = "native_show_wv_started";
    public static final String SIZE_KB = "size_kb";
    public static final String STATE = "state";
    public static final String SYNC = "sync";
    public static final String SYSTEM_CRONET_FAILURE = "native_cronet_failure_time";
    public static final String SYSTEM_CRONET_SUCCESS = "native_cronet_success_time";
    public static final String URL = "url";
    public static final String WEBVIEW_ERROR = "webview_error";
    public static final String WEBVIEW_ERROR_CODE = "webview_error_code";
    public static final String WEBVIEW_URL = "webview_url";

    static <clinit>() {
        new SendDiagnosticEvent$Companion();
        $$INSTANCE = new SendDiagnosticEvent$Companion(..);
        return;
    }

    private SendDiagnosticEvent$Companion() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.SendDiagnosticEvent$DefaultImpls
// ============================================================
package com.unity3d.ads.core.domain;

public final class SendDiagnosticEvent$DefaultImpls {
    public static void invoke$default(SendDiagnosticEvent p0, String p1, Double p2, Map p3, Map p4, AdObject p5, int p6, Object p7) {
        if (if-nez(p7)) goto L_25;
        if (if-eqz(p7)) goto L_9;
      L_9:
      L_a:
        if (if-eqz(p2)) goto L_10;
      L_10:
      L_11:
        if (if-eqz(p2)) goto L_17;
      L_17:
      L_18:
        if (if-eqz(p2)) goto L_1e;
      L_1e:
      L_1f:
        p0.invoke(p1, p2, p3, p4, p5);
        return;
      L_25:
        new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
        throw new UnsupportedOperationException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.SendPrivacyUpdateRequest$invoke$1
// ============================================================
package com.unity3d.ads.core.domain;

final class SendPrivacyUpdateRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final SendPrivacyUpdateRequest this$0;

    SendPrivacyUpdateRequest$invoke$1(SendPrivacyUpdateRequest p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.invoke(0, 0, this);
        return SendPrivacyUpdateRequest.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.TriggerInitializeListener$error$1
// ============================================================
package com.unity3d.ads.core.domain;

final class TriggerInitializeListener$error$1 extends SuspendLambda {
    final String $errorMsg;
    final UnityAds$UnityAdsInitializationError $unityAdsInitializationError;
    int label;

    TriggerInitializeListener$error$1(UnityAds$UnityAdsInitializationError p0, String p1, Continuation p2) {
        $unityAdsInitializationError = p0;
        $errorMsg = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new TriggerInitializeListener$error$1($unityAdsInitializationError, $errorMsg, p1);
        return new TriggerInitializeListener$error$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        TriggerInitializeListener$error$1.invoke(p0, p1);
        return TriggerInitializeListener$error$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        TriggerInitializeListener$error$1.create(p0, p1);
        TriggerInitializeListener$error$1.invokeSuspend(Unit.INSTANCE);
        return TriggerInitializeListener$error$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_14;
        ResultKt.throwOnFailure(p0);
        SdkProperties.notifyInitializationFailed($unityAdsInitializationError, $errorMsg);
        return Unit.INSTANCE;
      L_14:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.domain.TriggerInitializeListener$success$1
// ============================================================
package com.unity3d.ads.core.domain;

final class TriggerInitializeListener$success$1 extends SuspendLambda {
    int label;

    TriggerInitializeListener$success$1(Continuation p0) {
        new SuspendLambda(2, p0);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new TriggerInitializeListener$success$1(p1);
        return new TriggerInitializeListener$success$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        TriggerInitializeListener$success$1.invoke(p0, p1);
        return TriggerInitializeListener$success$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        TriggerInitializeListener$success$1.create(p0, p1);
        TriggerInitializeListener$success$1.invokeSuspend(Unit.INSTANCE);
        return TriggerInitializeListener$success$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_10;
        ResultKt.throwOnFailure(p0);
        SdkProperties.notifyInitializationComplete();
        return Unit.INSTANCE;
      L_10:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}

