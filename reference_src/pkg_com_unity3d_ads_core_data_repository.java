// Package bundle: com.unity3d.ads.core.data.repository (55 classes)

// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AdRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public abstract class AdRepository {
    public abstract Object addAd(ByteString p0, AdObject p1, Continuation p2) {
        // native or abstract
    }

    public abstract Object getAd(ByteString p0, Continuation p1) {
        // native or abstract
    }

    public abstract Object hasOpportunityId(ByteString p0, Continuation p1) {
        // native or abstract
    }

    public abstract Object removeAd(ByteString p0, Continuation p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidAdRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidAdRepository {
    private final ConcurrentHashMap loadedAds;

    public AndroidAdRepository() {
        new Object();
        new ConcurrentHashMap();
        loadedAds = new ConcurrentHashMap(..);
        return;
    }

    public Object addAd(ByteString p0, AdObject p1, Continuation p2) {
        loadedAds.put(p0, p1);
        return Unit.INSTANCE;
    }

    public Object getAd(ByteString p0, Continuation p1) {
        loadedAds.get(p0);
        return ConcurrentHashMap.get(..);
    }

    public Object hasOpportunityId(ByteString p0, Continuation p1) {
        loadedAds.containsKey(p0);
        Boxing.boxBoolean(ConcurrentHashMap.containsKey(..));
        return Boxing.boxBoolean(..);
    }

    public Object removeAd(ByteString p0, Continuation p1) {
        loadedAds.remove(p0);
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidCacheRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidCacheRepository {
    private final File cacheDir;
    private final ConcurrentHashMap cachedFiles;
    private final Context context;
    private final CreateFile createFile;
    private final GetCacheDirectory getCacheDirectory;
    private final ConcurrentHashMap neededFiles;
    private final CacheDataSource remoteCacheDataSource;
    private final CoroutineScope scope;

    public AndroidCacheRepository(CoroutineDispatcher p0, GetCacheDirectory p1, CreateFile p2, CacheDataSource p3, Context p4) {
        new Object();
        getCacheDirectory = p1;
        createFile = p2;
        remoteCacheDataSource = p3;
        context = p4;
        CoroutineScopeKt.CoroutineScope(p0);
        new CoroutineName("CacheRepository");
        CoroutineScopeKt.plus(CoroutineScopeKt.CoroutineScope(..), new CoroutineName(..));
        CoroutineScopeKt.plus(CoroutineScopeKt.plus(..), NonCancellable.INSTANCE);
        scope = CoroutineScopeKt.plus(..);
        new ConcurrentHashMap();
        cachedFiles = new ConcurrentHashMap(..);
        new ConcurrentHashMap();
        neededFiles = new ConcurrentHashMap(..);
        new Object(..).initCacheDir();
        cacheDir = AndroidCacheRepository.initCacheDir(..);
        return;
    }

    public static final void access$addFileToCache(AndroidCacheRepository p0, CachedFile p1) {
        p0.addFileToCache(p1);
        return;
    }

    public static final File access$getCacheDir$p(AndroidCacheRepository p0) {
        return cacheDir;
    }

    public static final CreateFile access$getCreateFile$p(AndroidCacheRepository p0) {
        return createFile;
    }

    public static final String access$getFilePath(AndroidCacheRepository p0, String p1) {
        p0.getFilePath(p1);
        return AndroidCacheRepository.getFilePath(..);
    }

    public static final CacheDataSource access$getRemoteCacheDataSource$p(AndroidCacheRepository p0) {
        return remoteCacheDataSource;
    }

    private final void addFileToCache(CachedFile p0) {
        p0.getName();
        cachedFiles.put(CachedFile.getName(..), p0);
        p0.getName();
        neededFiles.get(CachedFile.getName(..));
        if (if-nez(ConcurrentHashMap.get(..))) goto L_20;
        new LinkedHashSet();
      L_20:
        p0.getObjectId();
        new LinkedHashSet(..).add(CachedFile.getObjectId(..));
        p0.getName();
        neededFiles.put(CachedFile.getName(..), new LinkedHashSet(..));
        return;
    }

    private final File getCacheDirBase() {
        context.getCacheDir();
        return Context.getCacheDir(..);
    }

    private final String getCacheDirPath() {
        return "UnityAdsCache";
    }

    private final String getFilePath(String p0) {
        new StringBuilder();
        cacheDir.getAbsolutePath();
        new StringBuilder(..).append(File.getAbsolutePath(..));
        new StringBuilder(..).append(File.separator);
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

    private final File initCacheDir() {
        AndroidCacheRepository.getCacheDirBase();
        AndroidCacheRepository.getCacheDirPath();
        getCacheDirectory.invoke(AndroidCacheRepository.getCacheDirBase(..), AndroidCacheRepository.getCacheDirPath(..));
        GetCacheDirectory.invoke(..).mkdirs();
        return GetCacheDirectory.invoke(..);
    }

    public Object clearCache(Continuation p0) {
        scope.getCoroutineContext();
        new AndroidCacheRepository$clearCache$2(this, 0);
        BuildersKt.withContext(CoroutineScope.getCoroutineContext(..), new AndroidCacheRepository$clearCache$2(..), p0);
        return BuildersKt.withContext(..);
    }

    public Object doesFileExist(String p0, Continuation p1) {
        cachedFiles.containsKey(p0);
        Boxing.boxBoolean(ConcurrentHashMap.containsKey(..));
        return Boxing.boxBoolean(..);
    }

    public Object getCacheSize(Continuation p0) {
        scope.getCoroutineContext();
        new AndroidCacheRepository$getCacheSize$2(this, 0);
        BuildersKt.withContext(CoroutineScope.getCoroutineContext(..), new AndroidCacheRepository$getCacheSize$2(..), p0);
        return BuildersKt.withContext(..);
    }

    public final ConcurrentHashMap getCachedFiles() {
        return cachedFiles;
    }

    public Object getFile(String p0, String p1, JSONArray p2, int p3, Continuation p4) {
        scope.getCoroutineContext();
        new AndroidCacheRepository$getFile$2(this, p0, p1, p3, 0);
        BuildersKt.withContext(CoroutineScope.getCoroutineContext(..), new AndroidCacheRepository$getFile$2, p4);
        return BuildersKt.withContext(..);
    }

    public final String getFilename(String p0) {
        StringExtensionsKt.getSHA256Hash(p0);
        return StringExtensionsKt.getSHA256Hash(..);
    }

    public final ConcurrentHashMap getNeededFiles() {
        return neededFiles;
    }

    public boolean removeFile(CachedFile p0) {
        p0.getName();
        cachedFiles.remove(CachedFile.getName(..));
        p0.getName();
        neededFiles.get(CachedFile.getName(..));
        if (if-eqz(ConcurrentHashMap.get(..))) goto L_23;
        p0.getObjectId();
        ConcurrentHashMap.get(..).remove(CachedFile.getObjectId(..));
      L_23:
        p0.getFile();
        if (if-eqz(CachedFile.getFile(..))) goto L_38;
        CachedFile.getFile(..).exists();
        if (if-eqz(File.exists(..))) goto L_30;
      L_30:
      L_31:
        if (if-eqz(0)) goto L_38;
        0.delete();
      L_38:
      L_39:
        return 0;
    }

    public CacheResult retrieveFile(String p0) {
        cachedFiles.get(p0);
        if (if-eqz(ConcurrentHashMap.get(..))) goto L_19;
        new CacheResult$Success(ConcurrentHashMap.get(..), CacheSource.LOCAL);
      L_19:
        new CacheResult$Failure(CacheError.FILE_NOT_FOUND, CacheSource.LOCAL);
      L_25:
        return new CacheResult$Failure(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidCampaignRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidCampaignRepository {
    private final MutableStateFlow campaigns;
    private final GetSharedDataTimestamps getSharedDataTimestamps;

    public AndroidCampaignRepository(GetSharedDataTimestamps p0) {
        new Object();
        getSharedDataTimestamps = p0;
        MapsKt.emptyMap();
        StateFlowKt.MutableStateFlow(MapsKt.emptyMap(..));
        campaigns = StateFlowKt.MutableStateFlow(..);
        return;
    }

    public CampaignStateOuterClass$Campaign getCampaign(ByteString p0) {
        campaigns.getValue();
        p0.toStringUtf8();
        MutableStateFlow.getValue(..).get(ByteString.toStringUtf8(..));
        return Map.get(..);
    }

    public CampaignStateOuterClass$CampaignState getCampaignState() {
        campaigns.getValue();
        MutableStateFlow.getValue(..).values();
        new ArrayList();
        new ArrayList();
        Map.values(..).iterator();
      L_1c:
        Iterable.iterator(..).hasNext();
        if (if-eqz(Iterator.hasNext(..))) goto L_37;
        Iterable.iterator(..).next();
        Iterator.next(..).hasShowTimestamp();
        if (if-eqz(CampaignStateOuterClass$Campaign.hasShowTimestamp(..))) goto L_33;
        new ArrayList(..).add(Iterator.next(..));
      L_33:
        new ArrayList(..).add(Iterator.next(..));
      L_37:
        new Pair(new ArrayList(..), new ArrayList(..));
        new Pair(..).component1();
        new Pair(..).component2();
        CampaignStateOuterClass$CampaignState.newBuilder();
        CampaignStateKt$Dsl.Companion._create(CampaignStateOuterClass$CampaignState.newBuilder(..));
        CampaignStateKt$Dsl.getShownCampaigns();
        CampaignStateKt$Dsl.addAllShownCampaigns(CampaignStateKt$Dsl.getShownCampaigns(..), Pair.component1(..));
        CampaignStateKt$Dsl.getLoadedCampaigns();
        CampaignStateKt$Dsl.addAllLoadedCampaigns(CampaignStateKt$Dsl.getLoadedCampaigns(..), Pair.component2(..));
        CampaignStateKt$Dsl._build();
        return CampaignStateKt$Dsl._build(..);
    }

    public void removeState(ByteString p0) {
      L_7:
        campaigns.getValue();
        p0.toStringUtf8();
        MapsKt.minus(MutableStateFlow.getValue(..), ByteString.toStringUtf8(..));
        campaigns.compareAndSet(MutableStateFlow.getValue(..), MapsKt.minus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_7;
        return;
    }

    public void setCampaign(ByteString p0, CampaignStateOuterClass$Campaign p1) {
      L_c:
        campaigns.getValue();
        p0.toStringUtf8();
        TuplesKt.to(ByteString.toStringUtf8(..), p1);
        MapsKt.plus(MutableStateFlow.getValue(..), TuplesKt.to(..));
        campaigns.compareAndSet(MutableStateFlow.getValue(..), MapsKt.plus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_c;
        return;
    }

    public void setLoadTimestamp(ByteString p0) {
        AndroidCampaignRepository.getCampaign(p0);
        if (if-eqz(AndroidCampaignRepository.getCampaign(..))) goto L_2e;
        CampaignStateOuterClass$Campaign.toBuilder();
        CampaignKt$Dsl.Companion._create(CampaignStateOuterClass$Campaign.toBuilder(..));
        getSharedDataTimestamps.invoke();
        CampaignKt$Dsl$Companion._create(..).setLoadTimestamp(GetSharedDataTimestamps.invoke(..));
        CampaignKt$Dsl$Companion._create(..)._build();
        AndroidCampaignRepository.setCampaign(p0, CampaignKt$Dsl._build(..));
      L_2e:
        return;
    }

    public void setShowTimestamp(ByteString p0) {
        AndroidCampaignRepository.getCampaign(p0);
        if (if-eqz(AndroidCampaignRepository.getCampaign(..))) goto L_2e;
        CampaignStateOuterClass$Campaign.toBuilder();
        CampaignKt$Dsl.Companion._create(CampaignStateOuterClass$Campaign.toBuilder(..));
        getSharedDataTimestamps.invoke();
        CampaignKt$Dsl$Companion._create(..).setShowTimestamp(GetSharedDataTimestamps.invoke(..));
        CampaignKt$Dsl$Companion._create(..)._build();
        AndroidCampaignRepository.setCampaign(p0, CampaignKt$Dsl._build(..));
      L_2e:
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidDeveloperConsentRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidDeveloperConsentRepository {
    private final DeveloperConsentOuterClass$DeveloperConsent developerConsent;

    public AndroidDeveloperConsentRepository(DeveloperConsentDataSource p0) {
        new Object();
        p0.getDeveloperConsent();
        developerConsent = DeveloperConsentDataSource.getDeveloperConsent(..);
        return;
    }

    public DeveloperConsentOuterClass$DeveloperConsent getDeveloperConsent() {
        return developerConsent;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidDeviceInfoRepository {
    private final MutableStateFlow allowedPii;
    private final String analyticsUserId;
    private final DynamicDeviceInfoDataSource dynamicDeviceInfoDataSource;
    private final PrivacyDeviceInfoDataSource privacyDeviceInfoDataSource;
    private final SessionRepository sessionRepository;
    private final StaticDeviceInfoDataSource staticDeviceInfoDataSource;
    private final Flow volumeSettingsChange;

    public AndroidDeviceInfoRepository(StaticDeviceInfoDataSource p0, DynamicDeviceInfoDataSource p1, PrivacyDeviceInfoDataSource p2, SessionRepository p3) {
        new Object();
        staticDeviceInfoDataSource = p0;
        dynamicDeviceInfoDataSource = p1;
        privacyDeviceInfoDataSource = p2;
        sessionRepository = p3;
        AllowedPiiOuterClass$AllowedPii.getDefaultInstance();
        StateFlowKt.MutableStateFlow(AllowedPiiOuterClass$AllowedPii.getDefaultInstance(..));
        allowedPii = StateFlowKt.MutableStateFlow(..);
        p0.getAnalyticsUserId();
        analyticsUserId = StaticDeviceInfoDataSource.getAnalyticsUserId(..);
        p1.getVolumeSettingsChange();
        volumeSettingsChange = DynamicDeviceInfoDataSource.getVolumeSettingsChange(..);
        return;
    }

    public StaticDeviceInfoOuterClass$StaticDeviceInfo cachedStaticDeviceInfo() {
        staticDeviceInfoDataSource.fetchCached();
        return StaticDeviceInfoDataSource.fetchCached(..);
    }

    public MutableStateFlow getAllowedPii() {
        return allowedPii;
    }

    public String getAnalyticsUserId() {
        return analyticsUserId;
    }

    public String getAppName() {
        staticDeviceInfoDataSource.getAppName();
        return StaticDeviceInfoDataSource.getAppName(..);
    }

    public Object getAuidByteString(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidDeviceInfoRepository$getAuidByteString$1(this, label);
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
        AndroidDeviceInfoRepository.getAuidString("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(AndroidDeviceInfoRepository.getAuidString(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_3e;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_3e:
        if (if-nez(AndroidDeviceInfoRepository.getAuidString(..))) goto L_44;
        return 0;
      L_44:
        UUID.fromString(AndroidDeviceInfoRepository.getAuidString(..));
        ProtobufExtensionsKt.toByteString(UUID.fromString(..));
        return ProtobufExtensionsKt.toByteString(..);
    }

    public Object getAuidString(Continuation p0) {
        staticDeviceInfoDataSource.getAuid(p0);
        return StaticDeviceInfoDataSource.getAuid(..);
    }

    public String getConnectionTypeStr() {
        dynamicDeviceInfoDataSource.getConnectionTypeStr();
        return DynamicDeviceInfoDataSource.getConnectionTypeStr(..);
    }

    public int getCurrentUiTheme() {
        dynamicDeviceInfoDataSource.getCurrentUiTheme();
        return DynamicDeviceInfoDataSource.getCurrentUiTheme(..);
    }

    public DynamicDeviceInfoOuterClass$DynamicDeviceInfo getDynamicDeviceInfo() {
        dynamicDeviceInfoDataSource.fetch();
        return DynamicDeviceInfoDataSource.fetch(..);
    }

    public boolean getHasInternet() {
        dynamicDeviceInfoDataSource.hasInternet();
        return DynamicDeviceInfoDataSource.hasInternet(..);
    }

    public Object getIdfi(Continuation p0) {
        staticDeviceInfoDataSource.getIdfi(p0);
        return StaticDeviceInfoDataSource.getIdfi(..);
    }

    public List getLocaleList() {
        dynamicDeviceInfoDataSource.getLocaleList();
        return DynamicDeviceInfoDataSource.getLocaleList(..);
    }

    public String getManufacturer() {
        staticDeviceInfoDataSource.getManufacturer();
        return StaticDeviceInfoDataSource.getManufacturer(..);
    }

    public String getModel() {
        staticDeviceInfoDataSource.getModel();
        return StaticDeviceInfoDataSource.getModel(..);
    }

    public String getOrientation() {
        dynamicDeviceInfoDataSource.getOrientation();
        return DynamicDeviceInfoDataSource.getOrientation(..);
    }

    public String getOsVersion() {
        staticDeviceInfoDataSource.getOsVersion();
        return StaticDeviceInfoDataSource.getOsVersion(..);
    }

    public PiiOuterClass$Pii getPiiData() {
        AndroidDeviceInfoRepository.getAllowedPii();
        MutableStateFlow.getValue();
        privacyDeviceInfoDataSource.fetch(MutableStateFlow.getValue(..));
        return PrivacyDeviceInfoDataSource.fetch(..);
    }

    public int getRingerMode() {
        dynamicDeviceInfoDataSource.getRingerMode();
        return DynamicDeviceInfoDataSource.getRingerMode(..);
    }

    public long getSystemBootTime() {
        staticDeviceInfoDataSource.getSystemBootTime();
        return StaticDeviceInfoDataSource.getSystemBootTime(..);
    }

    public Flow getVolumeSettingsChange() {
        return volumeSettingsChange;
    }

    public Object staticDeviceInfo(Continuation p0) {
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getAdditionalStorePackagesList();
        staticDeviceInfoDataSource.fetch(NativeConfigurationOuterClass$NativeConfiguration.getAdditionalStorePackagesList(..), p0);
        return StaticDeviceInfoDataSource.fetch(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidDiagnosticEventRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidDiagnosticEventRepository {
    private final MutableSharedFlow _diagnosticEvents;
    private final Set allowedEvents;
    private final MutableStateFlow batch;
    private final Set blockedEvents;
    private final MutableStateFlow configured;
    private final SharedFlow diagnosticEvents;
    private final MutableStateFlow enabled;
    private final CoroutineTimer flushTimer;
    private final GetDiagnosticEventRequest getDiagnosticEventRequest;
    private int maxBatchSize;

    public AndroidDiagnosticEventRepository(CoroutineTimer p0, GetDiagnosticEventRequest p1) {
        new Object();
        flushTimer = p0;
        getDiagnosticEventRequest = p1;
        new ArrayList();
        Collections.synchronizedList(new ArrayList(..));
        StateFlowKt.MutableStateFlow(Collections.synchronizedList(..));
        batch = StateFlowKt.MutableStateFlow(..);
        maxBatchSize = 0x7FFFFFFF;
        new LinkedHashSet();
        Collections.synchronizedSet(new LinkedHashSet(..));
        allowedEvents = Collections.synchronizedSet(..);
        new LinkedHashSet();
        Collections.synchronizedSet(new LinkedHashSet(..));
        blockedEvents = Collections.synchronizedSet(..);
        Boolean.valueOf(0);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        enabled = StateFlowKt.MutableStateFlow(..);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        configured = StateFlowKt.MutableStateFlow(..);
        SharedFlowKt.MutableSharedFlow(10, 10, BufferOverflow.DROP_OLDEST);
        _diagnosticEvents = SharedFlowKt.MutableSharedFlow(..);
        FlowKt.asSharedFlow(SharedFlowKt.MutableSharedFlow(..));
        diagnosticEvents = FlowKt.asSharedFlow(..);
        return;
    }

    public static final Set access$getAllowedEvents$p(AndroidDiagnosticEventRepository p0) {
        return allowedEvents;
    }

    public static final Set access$getBlockedEvents$p(AndroidDiagnosticEventRepository p0) {
        return blockedEvents;
    }

    public static final GetDiagnosticEventRequest access$getGetDiagnosticEventRequest$p(AndroidDiagnosticEventRepository p0) {
        return getDiagnosticEventRequest;
    }

    public void addDiagnosticEvent(DiagnosticEventRequestOuterClass$DiagnosticEvent p0) {
        configured.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        if (if-nez(Boolean.booleanValue(..))) goto L_26;
      L_15:
        batch.getValue();
        MutableStateFlow.getValue(..).add(p0);
        batch.compareAndSet(MutableStateFlow.getValue(..), MutableStateFlow.getValue(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_15;
      L_26:
        enabled.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        if (if-nez(Boolean.booleanValue(..))) goto L_35;
        return;
      L_35:
      L_37:
        batch.getValue();
        MutableStateFlow.getValue(..).add(p0);
        batch.compareAndSet(MutableStateFlow.getValue(..), MutableStateFlow.getValue(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_37;
        batch.getValue();
        MutableStateFlow.getValue(..).size();
        if (if-lt(List.size(..), maxBatchSize)) goto L_5a;
        AndroidDiagnosticEventRepository.flush();
      L_5a:
        return;
    }

    public void clear() {
      L_2:
        batch.getValue();
        new ArrayList();
        batch.compareAndSet(MutableStateFlow.getValue(..), new ArrayList(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    public void configure(NativeConfigurationOuterClass$DiagnosticEventsConfiguration p0) {
        Boolean.valueOf(1);
        configured.setValue(Boolean.valueOf(..));
        p0.getEnabled();
        Boolean.valueOf(NativeConfigurationOuterClass$DiagnosticEventsConfiguration.getEnabled(..));
        enabled.setValue(Boolean.valueOf(..));
        enabled.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        if (if-nez(Boolean.booleanValue(..))) goto L_2e;
        AndroidDiagnosticEventRepository.clear();
        return;
      L_2e:
        p0.getMaxBatchSize();
        maxBatchSize = NativeConfigurationOuterClass$DiagnosticEventsConfiguration.getMaxBatchSize(..);
        p0.getAllowedEventsList();
        allowedEvents.addAll(NativeConfigurationOuterClass$DiagnosticEventsConfiguration.getAllowedEventsList(..));
        p0.getBlockedEventsList();
        blockedEvents.addAll(NativeConfigurationOuterClass$DiagnosticEventsConfiguration.getBlockedEventsList(..));
        p0.getMaxBatchIntervalMs();
        new AndroidDiagnosticEventRepository$configure$1(this);
        flushTimer.start(0L, "diagnosticsEventsConfiguration.blockedEventsList", v3, v4, new AndroidDiagnosticEventRepository$configure$1(..));
        return;
    }

    public void flush() {
      L_2:
        batch.getValue();
        new ArrayList();
        batch.compareAndSet(MutableStateFlow.getValue(..), new ArrayList(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        CollectionsKt.asSequence(MutableStateFlow.getValue(..));
        new AndroidDiagnosticEventRepository$flush$events$2(this);
        SequencesKt.map(CollectionsKt.asSequence(..), new AndroidDiagnosticEventRepository$flush$events$2(..));
        new AndroidDiagnosticEventRepository$flush$events$3(this);
        SequencesKt.filter(SequencesKt.map(..), new AndroidDiagnosticEventRepository$flush$events$3(..));
        new AndroidDiagnosticEventRepository$flush$events$4(this);
        SequencesKt.filter(SequencesKt.filter(..), new AndroidDiagnosticEventRepository$flush$events$4(..));
        SequencesKt.toList(SequencesKt.filter(..));
        SequencesKt.toList(..).isEmpty();
        if (if-eqz(Collection.isEmpty(..))) goto L_82;
        new StringBuilder("Unity Ads Sending diagnostic batch enabled: ");
        enabled.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        new StringBuilder(..).append(Boolean.booleanValue(..));
        new StringBuilder(..).append(" size: ");
        SequencesKt.toList(..).size();
        new StringBuilder(..).append(List.size(..));
        new StringBuilder(..).append(" :: ");
        new StringBuilder(..).append(SequencesKt.toList(..));
        new StringBuilder(..).toString();
        DeviceLog.debug(StringBuilder.toString(..));
        _diagnosticEvents.tryEmit(SequencesKt.toList(..));
      L_82:
        return;
    }

    public SharedFlow getDiagnosticEvents() {
        return diagnosticEvents;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidLegacyUserConsentRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidLegacyUserConsentRepository {
    private final LegacyUserConsentDataSource legacyUserConsentDataSource;

    public AndroidLegacyUserConsentRepository(LegacyUserConsentDataSource p0) {
        new Object();
        legacyUserConsentDataSource = p0;
        return;
    }

    public String getLegacyFlowUserConsent() {
        legacyUserConsentDataSource.getPrivacyData();
        return LegacyUserConsentDataSource.getPrivacyData(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidMediationRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidMediationRepository {
    private final MediationDataSource mediationDataSource;

    public AndroidMediationRepository(MediationDataSource p0) {
        new Object();
        mediationDataSource = p0;
        return;
    }

    public Function0 getMediationProvider() {
        new AndroidMediationRepository$mediationProvider$1(this);
        return new AndroidMediationRepository$mediationProvider$1(..);
    }

    public String getName() {
        mediationDataSource.getName();
        return MediationDataSource.getName(..);
    }

    public String getVersion() {
        mediationDataSource.getVersion();
        return MediationDataSource.getVersion(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidOpenMeasurementRepository {
    private final MutableStateFlow _isOMActive;
    private final MutableStateFlow activeSessions;
    private final MutableStateFlow finishedSessions;
    private final CoroutineDispatcher mainDispatcher;
    private final OmidManager omidManager;
    private final Partner partner;

    public AndroidOpenMeasurementRepository(CoroutineDispatcher p0, OmidManager p1) {
        new Object();
        mainDispatcher = p0;
        omidManager = p1;
        Partner.createPartner("Unity3d", "4.12.5");
        partner = Partner.createPartner(..);
        MapsKt.emptyMap();
        StateFlowKt.MutableStateFlow(MapsKt.emptyMap(..));
        activeSessions = StateFlowKt.MutableStateFlow(..);
        SetsKt.emptySet();
        StateFlowKt.MutableStateFlow(SetsKt.emptySet(..));
        finishedSessions = StateFlowKt.MutableStateFlow(..);
        Boolean.valueOf(0);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        _isOMActive = StateFlowKt.MutableStateFlow(..);
        return;
    }

    public static final void access$addSession(AndroidOpenMeasurementRepository p0, ByteString p1, AdSession p2) {
        p0.addSession(p1, p2);
        return;
    }

    public static final MutableStateFlow access$getActiveSessions$p(AndroidOpenMeasurementRepository p0) {
        return activeSessions;
    }

    public static final OmidManager access$getOmidManager$p(AndroidOpenMeasurementRepository p0) {
        return omidManager;
    }

    public static final Partner access$getPartner$p(AndroidOpenMeasurementRepository p0) {
        return partner;
    }

    public static final AdSession access$getSession(AndroidOpenMeasurementRepository p0, ByteString p1) {
        p0.getSession(p1);
        return AndroidOpenMeasurementRepository.getSession(..);
    }

    public static final void access$sessionFinished(AndroidOpenMeasurementRepository p0, ByteString p1) {
        p0.sessionFinished(p1);
        return;
    }

    private final void addSession(ByteString p0, AdSession p1) {
      L_2:
        activeSessions.getValue();
        ProtobufExtensionsKt.toISO8859String(p0);
        TuplesKt.to(ProtobufExtensionsKt.toISO8859String(..), p1);
        MapsKt.plus(MutableStateFlow.getValue(..), TuplesKt.to(..));
        activeSessions.compareAndSet(MutableStateFlow.getValue(..), MapsKt.plus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    private final OMData buildOmData() {
        omidManager.getVersion();
        new OMData(OmidManager.getVersion(..), "Unity3d", "1");
        return new OMData(..);
    }

    private final AdSession getSession(ByteString p0) {
        activeSessions.getValue();
        ProtobufExtensionsKt.toISO8859String(p0);
        MutableStateFlow.getValue(..).get(ProtobufExtensionsKt.toISO8859String(..));
        return Map.get(..);
    }

    private final void removeSession(ByteString p0) {
      L_2:
        activeSessions.getValue();
        ProtobufExtensionsKt.toISO8859String(p0);
        MapsKt.minus(MutableStateFlow.getValue(..), ProtobufExtensionsKt.toISO8859String(..));
        activeSessions.compareAndSet(MutableStateFlow.getValue(..), MapsKt.minus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    private final void sessionFinished(ByteString p0) {
      L_2:
        finishedSessions.getValue();
        ProtobufExtensionsKt.toISO8859String(p0);
        SetsKt.plus(MutableStateFlow.getValue(..), ProtobufExtensionsKt.toISO8859String(..));
        finishedSessions.compareAndSet(MutableStateFlow.getValue(..), SetsKt.plus(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        AndroidOpenMeasurementRepository.removeSession(p0);
        return;
    }

    public Object activateOM(Context p0, Continuation p1) {
        new AndroidOpenMeasurementRepository$activateOM$2(this, p0, 0);
        BuildersKt.withContext(mainDispatcher, new AndroidOpenMeasurementRepository$activateOM$2(..), p1);
        return BuildersKt.withContext(..);
    }

    public Object finishSession(ByteString p0, Continuation p1) {
        new AndroidOpenMeasurementRepository$finishSession$2(this, p0, 0);
        BuildersKt.withContext(mainDispatcher, new AndroidOpenMeasurementRepository$finishSession$2(..), p1);
        return BuildersKt.withContext(..);
    }

    public OMData getOmData() {
        AndroidOpenMeasurementRepository.buildOmData();
        return AndroidOpenMeasurementRepository.buildOmData(..);
    }

    public boolean hasSessionFinished(ByteString p0) {
        finishedSessions.getValue();
        ProtobufExtensionsKt.toISO8859String(p0);
        MutableStateFlow.getValue(..).contains(ProtobufExtensionsKt.toISO8859String(..));
        return Set.contains(..);
    }

    public Object impressionOccurred(ByteString p0, boolean p1, Continuation p2) {
        new AndroidOpenMeasurementRepository$impressionOccurred$2(this, p0, p1, 0);
        BuildersKt.withContext(mainDispatcher, new AndroidOpenMeasurementRepository$impressionOccurred$2(..), p2);
        return BuildersKt.withContext(..);
    }

    public boolean isOMActive() {
        _isOMActive.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        return Boolean.booleanValue(..);
    }

    public void setOMActive(boolean p0) {
      L_2:
        _isOMActive.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        Boolean.valueOf(p0);
        _isOMActive.compareAndSet(MutableStateFlow.getValue(..), Boolean.valueOf(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    public Object startSession(ByteString p0, WebView p1, OmidOptions p2, Continuation p3) {
        new AndroidOpenMeasurementRepository$startSession$2(this, p0, p2, p1, 0);
        BuildersKt.withContext(mainDispatcher, new AndroidOpenMeasurementRepository$startSession$2, p3);
        return BuildersKt.withContext(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidSessionRepository {
    private final MutableStateFlow _currentState;
    private MutableStateFlow _gameId;
    private final MutableStateFlow _gatewayUrl;
    private final MutableStateFlow _headerBiddingTokenCounter;
    private final MutableStateFlow _initializationState;
    private final MutableStateFlow _isTestModeEnabled;
    private MutableSharedFlow _onChange;
    private final MutableStateFlow _sdkConfiguration;
    private final MutableStateFlow _sessionCounters;
    private final MutableStateFlow _sessionId;
    private final MutableStateFlow _sessionToken;
    private final MutableStateFlow _shouldInitialize;
    private final MutableStateFlow _tokenCounters;
    private final ByteStringDataSource fsmDataSource;
    private final ByteStringDataSource gatewayCacheDataSource;
    private final MutableStateFlow isInit;
    private final ByteStringDataSource nativeConfigDataSource;
    private final SharedFlow onChange;
    private final Flow persistedNativeConfiguration;
    private final ByteStringDataSource privacyDataSource;

    public AndroidSessionRepository(ByteStringDataSource p0, ByteStringDataSource p1, ByteStringDataSource p2, ByteStringDataSource p3, NativeConfigurationOuterClass$NativeConfiguration p4, CoroutineDispatcher p5, SendDiagnosticEvent p6) {
        new Object();
        gatewayCacheDataSource = p0;
        privacyDataSource = p1;
        fsmDataSource = p2;
        nativeConfigDataSource = p3;
        StateFlowKt.MutableStateFlow(p4);
        _sdkConfiguration = StateFlowKt.MutableStateFlow(..);
        Boolean.valueOf(0);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        isInit = StateFlowKt.MutableStateFlow(..);
        CoroutineScopeKt.CoroutineScope(p5);
        new AndroidSessionRepository$1(new Object(..), p6, 0);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(..), 0, 0, new AndroidSessionRepository$1(..), 3, 0);
        new AndroidSessionRepository$persistedNativeConfiguration$1(0);
        FlowKt.flowCombine(StateFlowKt.MutableStateFlow(..), StateFlowKt.MutableStateFlow(..), new AndroidSessionRepository$persistedNativeConfiguration$1(..));
        new AndroidSessionRepository$special$$inlined$filter$1(FlowKt.flowCombine(..));
        new AndroidSessionRepository$special$$inlined$map$1(new AndroidSessionRepository$special$$inlined$filter$1(..));
        persistedNativeConfiguration = new AndroidSessionRepository$special$$inlined$map$1(..);
        SharedFlowKt.MutableSharedFlow$default(0, 0, 0, 7, 0);
        _onChange = SharedFlowKt.MutableSharedFlow$default(..);
        FlowKt.asSharedFlow(SharedFlowKt.MutableSharedFlow$default(..));
        onChange = FlowKt.asSharedFlow(..);
        ClientProperties.getGameId();
        if (if-nez(ClientProperties.getGameId(..))) goto L_88;
      L_88:
      L_89:
        StateFlowKt.MutableStateFlow(ClientProperties.getGameId(..));
        _gameId = StateFlowKt.MutableStateFlow(..);
        UUID.randomUUID();
        ProtobufExtensionsKt.toByteString(UUID.randomUUID(..));
        StateFlowKt.MutableStateFlow(ProtobufExtensionsKt.toByteString(..));
        _sessionId = StateFlowKt.MutableStateFlow(..);
        SdkProperties.isTestMode();
        Boolean.valueOf(SdkProperties.isTestMode(..));
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        _isTestModeEnabled = StateFlowKt.MutableStateFlow(..);
        SessionCountersOuterClass$SessionCounters.newBuilder();
        SessionCountersOuterClass$SessionCounters$Builder.build();
        StateFlowKt.MutableStateFlow(SessionCountersOuterClass$SessionCounters$Builder.build(..));
        _sessionCounters = StateFlowKt.MutableStateFlow(..);
        new TokenCounters(0, 0, 0);
        StateFlowKt.MutableStateFlow(new TokenCounters(..));
        _tokenCounters = StateFlowKt.MutableStateFlow(..);
        StateFlowKt.MutableStateFlow(ByteString.EMPTY);
        _sessionToken = StateFlowKt.MutableStateFlow(..);
        StateFlowKt.MutableStateFlow(ByteString.EMPTY);
        _currentState = StateFlowKt.MutableStateFlow(..);
        StateFlowKt.MutableStateFlow("https://gateway.unityads.unity3d.com/v1");
        _gatewayUrl = StateFlowKt.MutableStateFlow(..);
        StateFlowKt.MutableStateFlow(InitializationState.NOT_INITIALIZED);
        _initializationState = StateFlowKt.MutableStateFlow(..);
        Integer.valueOf(0);
        StateFlowKt.MutableStateFlow(Integer.valueOf(..));
        _headerBiddingTokenCounter = StateFlowKt.MutableStateFlow(..);
        Boolean.valueOf(1);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        _shouldInitialize = StateFlowKt.MutableStateFlow(..);
        return;
    }

    public static final ByteStringDataSource access$getNativeConfigDataSource$p(AndroidSessionRepository p0) {
        return nativeConfigDataSource;
    }

    public static final Flow access$getPersistedNativeConfiguration$p(AndroidSessionRepository p0) {
        return persistedNativeConfiguration;
    }

    public static final MutableStateFlow access$get_sdkConfiguration$p(AndroidSessionRepository p0) {
        return _sdkConfiguration;
    }

    public static final MutableStateFlow access$isInit$p(AndroidSessionRepository p0) {
        return isInit;
    }

    public NativeConfigurationOuterClass$FeatureFlags getFeatureFlags() {
        AndroidSessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getFeatureFlags();
        return NativeConfigurationOuterClass$NativeConfiguration.getFeatureFlags(..);
    }

    public String getGameId() {
      L_2:
        _gameId.getValue();
        ClientProperties.getGameId();
        if (if-nez(ClientProperties.getGameId(..))) goto L_10;
      L_10:
        _gameId.compareAndSet(MutableStateFlow.getValue(..), 0);
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return 0;
    }

    public Object getGatewayCache(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidSessionRepository$getGatewayCache$1(this, label);
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
        gatewayCacheDataSource.get("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(ByteStringDataSource.get(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_40;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_40:
        ByteStringDataSource.get(..).getData();
        return ByteStringStoreOuterClass$ByteStringStore.getData(..);
    }

    public ByteString getGatewayState() {
        _currentState.getValue();
        return MutableStateFlow.getValue(..);
    }

    public String getGatewayUrl() {
        _gatewayUrl.getValue();
        return MutableStateFlow.getValue(..);
    }

    public int getHeaderBiddingTokenCounter() {
      L_2:
        _headerBiddingTokenCounter.getValue();
        MutableStateFlow.getValue(..).intValue();
        Integer.valueOf(Number.intValue(..));
        _headerBiddingTokenCounter.compareAndSet(MutableStateFlow.getValue(..), Integer.valueOf(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        MutableStateFlow.getValue(..).intValue();
        return Number.intValue(..);
    }

    public InitializationState getInitializationState() {
        _initializationState.getValue();
        return MutableStateFlow.getValue(..);
    }

    public NativeConfigurationOuterClass$NativeConfiguration getNativeConfiguration() {
        isInit.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        if (if-nez(Boolean.booleanValue(..))) goto L_1e;
        new AndroidSessionRepository$nativeConfiguration$1(this, 0);
        BuildersKt.runBlocking$default(0, new AndroidSessionRepository$nativeConfiguration$1(..), 1, 0);
      L_1e:
        _sdkConfiguration.getValue();
      L_26:
        return MutableStateFlow.getValue(..);
    }

    public Flow getObserveInitializationState() {
        return _initializationState;
    }

    public SharedFlow getOnChange() {
        return onChange;
    }

    public Object getPrivacy(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidSessionRepository$getPrivacy$1(this, label);
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
        privacyDataSource.get("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(ByteStringDataSource.get(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_40;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_40:
        ByteStringDataSource.get(..).getData();
        return ByteStringStoreOuterClass$ByteStringStore.getData(..);
    }

    public Object getPrivacyFsm(Continuation p0) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidSessionRepository$getPrivacyFsm$1(this, label);
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
        fsmDataSource.get("call to 'resume' before 'invoke' with coroutine");
        if (if-ne(ByteStringDataSource.get(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_40;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_40:
        ByteStringDataSource.get(..).getData();
        return ByteStringStoreOuterClass$ByteStringStore.getData(..);
    }

    public SessionCountersOuterClass$SessionCounters getSessionCounters() {
        _sessionCounters.getValue();
        return MutableStateFlow.getValue(..);
    }

    public ByteString getSessionId() {
        _sessionId.getValue();
        return MutableStateFlow.getValue(..);
    }

    public ByteString getSessionToken() {
        _sessionToken.getValue();
        return MutableStateFlow.getValue(..);
    }

    public boolean getShouldInitialize() {
        _shouldInitialize.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        return Boolean.booleanValue(..);
    }

    public TokenCounters getTokenCounters() {
        _tokenCounters.getValue();
        return MutableStateFlow.getValue(..);
    }

    public void incrementBannerImpressionCount() {
      L_2:
        _sessionCounters.getValue();
        MutableStateFlow.getValue(..).toBuilder();
        SessionCountersKt$Dsl.Companion._create(SessionCountersOuterClass$SessionCounters.toBuilder(..));
        SessionCountersKt$Dsl.getBannerImpressions();
        SessionCountersKt$Dsl.setBannerImpressions(SessionCountersKt$Dsl.getBannerImpressions(..));
        SessionCountersKt$Dsl._build();
        _sessionCounters.compareAndSet(MutableStateFlow.getValue(..), SessionCountersKt$Dsl._build(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    public void incrementBannerLoadRequestAdmCount() {
      L_2:
        _sessionCounters.getValue();
        MutableStateFlow.getValue(..).toBuilder();
        SessionCountersKt$Dsl.Companion._create(SessionCountersOuterClass$SessionCounters.toBuilder(..));
        SessionCountersKt$Dsl.getBannerRequestsAdm();
        SessionCountersKt$Dsl.setBannerRequestsAdm(SessionCountersKt$Dsl.getBannerRequestsAdm(..));
        SessionCountersKt$Dsl._build();
        _sessionCounters.compareAndSet(MutableStateFlow.getValue(..), SessionCountersKt$Dsl._build(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    public void incrementBannerLoadRequestCount() {
      L_2:
        _sessionCounters.getValue();
        MutableStateFlow.getValue(..).toBuilder();
        SessionCountersKt$Dsl.Companion._create(SessionCountersOuterClass$SessionCounters.toBuilder(..));
        SessionCountersKt$Dsl.getBannerLoadRequests();
        SessionCountersKt$Dsl.setBannerLoadRequests(SessionCountersKt$Dsl.getBannerLoadRequests(..));
        SessionCountersKt$Dsl._build();
        _sessionCounters.compareAndSet(MutableStateFlow.getValue(..), SessionCountersKt$Dsl._build(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    public void incrementLoadRequestAdmCount() {
      L_2:
        _sessionCounters.getValue();
        MutableStateFlow.getValue(..).toBuilder();
        SessionCountersKt$Dsl.Companion._create(SessionCountersOuterClass$SessionCounters.toBuilder(..));
        SessionCountersKt$Dsl.getLoadRequestsAdm();
        SessionCountersKt$Dsl.setLoadRequestsAdm(SessionCountersKt$Dsl.getLoadRequestsAdm(..));
        SessionCountersKt$Dsl._build();
        _sessionCounters.compareAndSet(MutableStateFlow.getValue(..), SessionCountersKt$Dsl._build(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    public void incrementLoadRequestCount() {
      L_2:
        _sessionCounters.getValue();
        MutableStateFlow.getValue(..).toBuilder();
        SessionCountersKt$Dsl.Companion._create(SessionCountersOuterClass$SessionCounters.toBuilder(..));
        SessionCountersKt$Dsl.getLoadRequests();
        SessionCountersKt$Dsl.setLoadRequests(SessionCountersKt$Dsl.getLoadRequests(..));
        SessionCountersKt$Dsl._build();
        _sessionCounters.compareAndSet(MutableStateFlow.getValue(..), SessionCountersKt$Dsl._build(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    public void incrementTokenSequenceNumber() {
      L_2:
        _tokenCounters.getValue();
        MutableStateFlow.getValue(..).getSeq();
        TokenCounters.copy$default(MutableStateFlow.getValue(..), TokenCounters.getSeq(..), 0, 0, 6, 0);
        _tokenCounters.compareAndSet(MutableStateFlow.getValue(..), TokenCounters.copy$default(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    public void incrementTokenStartsCount() {
      L_2:
        _tokenCounters.getValue();
        MutableStateFlow.getValue(..).getStarts();
        TokenCounters.copy$default(MutableStateFlow.getValue(..), 0, 0, TokenCounters.getStarts(..), 3, 0);
        _tokenCounters.compareAndSet(MutableStateFlow.getValue(..), TokenCounters.copy$default(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    public void incrementTokenWinsCount() {
      L_2:
        _tokenCounters.getValue();
        MutableStateFlow.getValue(..).getWins();
        TokenCounters.copy$default(MutableStateFlow.getValue(..), 0, TokenCounters.getWins(..), 0, 5, 0);
        _tokenCounters.compareAndSet(MutableStateFlow.getValue(..), TokenCounters.copy$default(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    public boolean isDiagnosticsEnabled() {
        AndroidSessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getDiagnosticEvents();
        NativeConfigurationOuterClass$DiagnosticEventsConfiguration.getEnabled();
        return NativeConfigurationOuterClass$DiagnosticEventsConfiguration.getEnabled(..);
    }

    public boolean isOmEnabled() {
        AndroidSessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getEnableOm();
        return NativeConfigurationOuterClass$NativeConfiguration.getEnableOm(..);
    }

    public boolean isSdkInitialized() {
        AndroidSessionRepository.getInitializationState();
        if (if-ne(AndroidSessionRepository.getInitializationState(..), InitializationState.INITIALIZED)) goto L_a;
      L_a:
      L_b:
        return 0;
    }

    public boolean isTestModeEnabled() {
      L_2:
        _isTestModeEnabled.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        SdkProperties.isTestMode();
        Boolean.valueOf(SdkProperties.isTestMode(..));
        _isTestModeEnabled.compareAndSet(MutableStateFlow.getValue(..), Boolean.valueOf(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        Boolean.valueOf(..).booleanValue();
        return Boolean.booleanValue(..);
    }

    public Object persistNativeConfiguration(Continuation p0) {
        AndroidSessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.toByteString();
        nativeConfigDataSource.set(NativeConfigurationOuterClass$NativeConfiguration.toByteString(..), p0);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(ByteStringDataSource.set(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_1a;
        return ByteStringDataSource.set(..);
      L_1a:
        return Unit.INSTANCE;
    }

    public void resetTokenCounters() {
      L_2:
        _tokenCounters.getValue();
        new TokenCounters(0, 0, 0);
        _tokenCounters.compareAndSet(MutableStateFlow.getValue(..), new TokenCounters(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    public void setGameId(String p0) {
      L_2:
        _gameId.getValue();
        ClientProperties.setGameId(p0);
        _gameId.compareAndSet(MutableStateFlow.getValue(..), p0);
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    public Object setGatewayCache(ByteString p0, Continuation p1) {
        gatewayCacheDataSource.set(p0, p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(ByteStringDataSource.set(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_d;
        return ByteStringDataSource.set(..);
      L_d:
        return Unit.INSTANCE;
    }

    public void setGatewayState(ByteString p0) {
      L_7:
        _currentState.getValue();
        _currentState.compareAndSet(MutableStateFlow.getValue(..), p0);
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_7;
        return;
    }

    public void setGatewayUrl(String p0) {
      L_7:
        _gatewayUrl.getValue();
        _gatewayUrl.compareAndSet(MutableStateFlow.getValue(..), p0);
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_7;
        return;
    }

    public void setInitializationState(InitializationState p0) {
      L_7:
        _initializationState.getValue();
        _initializationState.compareAndSet(MutableStateFlow.getValue(..), p0);
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_7;
        return;
    }

    public void setNativeConfiguration(NativeConfigurationOuterClass$NativeConfiguration p0) {
      L_7:
        _sdkConfiguration.getValue();
        _sdkConfiguration.compareAndSet(MutableStateFlow.getValue(..), p0);
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_7;
        return;
    }

    public Object setPrivacy(ByteString p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidSessionRepository$setPrivacy$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_41;
        if (if-eq(label, 1)) goto L_35;
        if (if-ne(label, 2)) goto L_2d;
        ResultKt.throwOnFailure(result);
      L_2d:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_35:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_41:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        L$0 = this;
        L$1 = L$1;
        label = 1;
        privacyDataSource.set(L$1, new AndroidSessionRepository$setPrivacy$1(..));
        if (if-ne(ByteStringDataSource.set(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_53;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_53:
      L_54:
        new SessionChange$UserConsentChange(L$1);
        L$0 = 0;
        L$1 = 0;
        label = 2;
        _onChange.emit(new SessionChange$UserConsentChange(..), new AndroidSessionRepository$setPrivacy$1(..));
        if (if-ne(MutableSharedFlow.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_69;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_69:
        return Unit.INSTANCE;
    }

    public Object setPrivacyFsm(ByteString p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidSessionRepository$setPrivacyFsm$1(this, label);
      L_19:
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_41;
        if (if-eq(label, 1)) goto L_35;
        if (if-ne(label, 2)) goto L_2d;
        ResultKt.throwOnFailure(result);
      L_2d:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_35:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
      L_41:
        ResultKt.throwOnFailure("call to 'resume' before 'invoke' with coroutine");
        L$0 = this;
        L$1 = L$1;
        label = 1;
        fsmDataSource.set(L$1, new AndroidSessionRepository$setPrivacyFsm$1(..));
        if (if-ne(ByteStringDataSource.set(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_53;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_53:
      L_54:
        new SessionChange$PrivacyFsmChange(L$1);
        L$0 = 0;
        L$1 = 0;
        label = 2;
        _onChange.emit(new SessionChange$PrivacyFsmChange(..), new AndroidSessionRepository$setPrivacyFsm$1(..));
        if (if-ne(MutableSharedFlow.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_69;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_69:
        return Unit.INSTANCE;
    }

    public void setSessionCounters(SessionCountersOuterClass$SessionCounters p0) {
      L_7:
        _sessionCounters.getValue();
        _sessionCounters.compareAndSet(MutableStateFlow.getValue(..), p0);
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_7;
        return;
    }

    public void setSessionToken(ByteString p0) {
      L_7:
        _sessionToken.getValue();
        _sessionToken.compareAndSet(MutableStateFlow.getValue(..), p0);
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_7;
        return;
    }

    public void setShouldInitialize(boolean p0) {
      L_2:
        _shouldInitialize.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        Boolean.valueOf(p0);
        _shouldInitialize.compareAndSet(MutableStateFlow.getValue(..), Boolean.valueOf(..));
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_2;
        return;
    }

    public void setTokenCounters(TokenCounters p0) {
      L_7:
        _tokenCounters.getValue();
        _tokenCounters.compareAndSet(MutableStateFlow.getValue(..), p0);
        if (if-eqz(MutableStateFlow.compareAndSet(..))) goto L_7;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidTcfRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidTcfRepository {
    private final TcfDataSource tcfDataSource;

    public AndroidTcfRepository(TcfDataSource p0) {
        new Object();
        tcfDataSource = p0;
        return;
    }

    public final TcfDataSource getTcfDataSource() {
        return tcfDataSource;
    }

    public String getTcfString() {
        tcfDataSource.getTcfString();
        return TcfDataSource.getTcfString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidTransactionEventRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidTransactionEventRepository {
    private final MutableSharedFlow _transactionEvents;
    private final SharedFlow transactionEvents;

    public AndroidTransactionEventRepository() {
        new Object();
        SharedFlowKt.MutableSharedFlow(10, 10, BufferOverflow.DROP_OLDEST);
        _transactionEvents = SharedFlowKt.MutableSharedFlow(..);
        FlowKt.asSharedFlow(SharedFlowKt.MutableSharedFlow(..));
        transactionEvents = FlowKt.asSharedFlow(..);
        return;
    }

    public void addTransactionEvent(TransactionEventRequestOuterClass$TransactionEventRequest p0) {
        _transactionEvents.tryEmit(p0);
        return;
    }

    public SharedFlow getTransactionEvents() {
        return transactionEvents;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.CacheRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public abstract class CacheRepository {
    public abstract Object clearCache(Continuation p0) {
        // native or abstract
    }

    public abstract Object doesFileExist(String p0, Continuation p1) {
        // native or abstract
    }

    public abstract Object getCacheSize(Continuation p0) {
        // native or abstract
    }

    public abstract Object getFile(String p0, String p1, JSONArray p2, int p3, Continuation p4) {
        // native or abstract
    }

    public abstract boolean removeFile(CachedFile p0) {
        // native or abstract
    }

    public abstract CacheResult retrieveFile(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.CampaignRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public abstract class CampaignRepository {
    public abstract CampaignStateOuterClass$Campaign getCampaign(ByteString p0) {
        // native or abstract
    }

    public abstract CampaignStateOuterClass$CampaignState getCampaignState() {
        // native or abstract
    }

    public abstract void removeState(ByteString p0) {
        // native or abstract
    }

    public abstract void setCampaign(ByteString p0, CampaignStateOuterClass$Campaign p1) {
        // native or abstract
    }

    public abstract void setLoadTimestamp(ByteString p0) {
        // native or abstract
    }

    public abstract void setShowTimestamp(ByteString p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.DeveloperConsentRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public abstract class DeveloperConsentRepository {
    public abstract DeveloperConsentOuterClass$DeveloperConsent getDeveloperConsent() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.DeviceInfoRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public abstract class DeviceInfoRepository {
    public abstract StaticDeviceInfoOuterClass$StaticDeviceInfo cachedStaticDeviceInfo() {
        // native or abstract
    }

    public abstract MutableStateFlow getAllowedPii() {
        // native or abstract
    }

    public abstract String getAnalyticsUserId() {
        // native or abstract
    }

    public abstract String getAppName() {
        // native or abstract
    }

    public abstract Object getAuidByteString(Continuation p0) {
        // native or abstract
    }

    public abstract Object getAuidString(Continuation p0) {
        // native or abstract
    }

    public abstract String getConnectionTypeStr() {
        // native or abstract
    }

    public abstract int getCurrentUiTheme() {
        // native or abstract
    }

    public abstract DynamicDeviceInfoOuterClass$DynamicDeviceInfo getDynamicDeviceInfo() {
        // native or abstract
    }

    public abstract boolean getHasInternet() {
        // native or abstract
    }

    public abstract Object getIdfi(Continuation p0) {
        // native or abstract
    }

    public abstract List getLocaleList() {
        // native or abstract
    }

    public abstract String getManufacturer() {
        // native or abstract
    }

    public abstract String getModel() {
        // native or abstract
    }

    public abstract String getOrientation() {
        // native or abstract
    }

    public abstract String getOsVersion() {
        // native or abstract
    }

    public abstract PiiOuterClass$Pii getPiiData() {
        // native or abstract
    }

    public abstract int getRingerMode() {
        // native or abstract
    }

    public abstract long getSystemBootTime() {
        // native or abstract
    }

    public abstract Flow getVolumeSettingsChange() {
        // native or abstract
    }

    public abstract Object staticDeviceInfo(Continuation p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.DiagnosticEventRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public abstract class DiagnosticEventRepository {
    public abstract void addDiagnosticEvent(DiagnosticEventRequestOuterClass$DiagnosticEvent p0) {
        // native or abstract
    }

    public abstract void clear() {
        // native or abstract
    }

    public abstract void configure(NativeConfigurationOuterClass$DiagnosticEventsConfiguration p0) {
        // native or abstract
    }

    public abstract void flush() {
        // native or abstract
    }

    public abstract SharedFlow getDiagnosticEvents() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.LegacyUserConsentRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public abstract class LegacyUserConsentRepository {
    public abstract String getLegacyFlowUserConsent() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.MediationRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public abstract class MediationRepository {
    public abstract Function0 getMediationProvider() {
        // native or abstract
    }

    public abstract String getName() {
        // native or abstract
    }

    public abstract String getVersion() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.OpenMeasurementRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public abstract class OpenMeasurementRepository {
    public abstract Object activateOM(Context p0, Continuation p1) {
        // native or abstract
    }

    public abstract Object finishSession(ByteString p0, Continuation p1) {
        // native or abstract
    }

    public abstract OMData getOmData() {
        // native or abstract
    }

    public abstract boolean hasSessionFinished(ByteString p0) {
        // native or abstract
    }

    public abstract Object impressionOccurred(ByteString p0, boolean p1, Continuation p2) {
        // native or abstract
    }

    public abstract boolean isOMActive() {
        // native or abstract
    }

    public abstract void setOMActive(boolean p0) {
        // native or abstract
    }

    public abstract Object startSession(ByteString p0, WebView p1, OmidOptions p2, Continuation p3) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.OperativeEventRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class OperativeEventRepository {
    private final MutableSharedFlow _operativeEvents;
    private final SharedFlow operativeEvents;

    public OperativeEventRepository() {
        new Object();
        SharedFlowKt.MutableSharedFlow(10, 10, BufferOverflow.DROP_OLDEST);
        _operativeEvents = SharedFlowKt.MutableSharedFlow(..);
        FlowKt.asSharedFlow(SharedFlowKt.MutableSharedFlow(..));
        operativeEvents = FlowKt.asSharedFlow(..);
        return;
    }

    public final void addOperativeEvent(OperativeEventRequestOuterClass$OperativeEventRequest p0) {
        _operativeEvents.tryEmit(p0);
        return;
    }

    public final SharedFlow getOperativeEvents() {
        return operativeEvents;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.SessionRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public abstract class SessionRepository {
    public abstract NativeConfigurationOuterClass$FeatureFlags getFeatureFlags() {
        // native or abstract
    }

    public abstract String getGameId() {
        // native or abstract
    }

    public abstract Object getGatewayCache(Continuation p0) {
        // native or abstract
    }

    public abstract ByteString getGatewayState() {
        // native or abstract
    }

    public abstract String getGatewayUrl() {
        // native or abstract
    }

    public abstract int getHeaderBiddingTokenCounter() {
        // native or abstract
    }

    public abstract InitializationState getInitializationState() {
        // native or abstract
    }

    public abstract NativeConfigurationOuterClass$NativeConfiguration getNativeConfiguration() {
        // native or abstract
    }

    public abstract Flow getObserveInitializationState() {
        // native or abstract
    }

    public abstract SharedFlow getOnChange() {
        // native or abstract
    }

    public abstract Object getPrivacy(Continuation p0) {
        // native or abstract
    }

    public abstract Object getPrivacyFsm(Continuation p0) {
        // native or abstract
    }

    public abstract SessionCountersOuterClass$SessionCounters getSessionCounters() {
        // native or abstract
    }

    public abstract ByteString getSessionId() {
        // native or abstract
    }

    public abstract ByteString getSessionToken() {
        // native or abstract
    }

    public abstract boolean getShouldInitialize() {
        // native or abstract
    }

    public abstract TokenCounters getTokenCounters() {
        // native or abstract
    }

    public abstract void incrementBannerImpressionCount() {
        // native or abstract
    }

    public abstract void incrementBannerLoadRequestAdmCount() {
        // native or abstract
    }

    public abstract void incrementBannerLoadRequestCount() {
        // native or abstract
    }

    public abstract void incrementLoadRequestAdmCount() {
        // native or abstract
    }

    public abstract void incrementLoadRequestCount() {
        // native or abstract
    }

    public abstract void incrementTokenSequenceNumber() {
        // native or abstract
    }

    public abstract void incrementTokenStartsCount() {
        // native or abstract
    }

    public abstract void incrementTokenWinsCount() {
        // native or abstract
    }

    public abstract boolean isDiagnosticsEnabled() {
        // native or abstract
    }

    public abstract boolean isOmEnabled() {
        // native or abstract
    }

    public abstract boolean isSdkInitialized() {
        // native or abstract
    }

    public abstract boolean isTestModeEnabled() {
        // native or abstract
    }

    public abstract Object persistNativeConfiguration(Continuation p0) {
        // native or abstract
    }

    public abstract void resetTokenCounters() {
        // native or abstract
    }

    public abstract void setGameId(String p0) {
        // native or abstract
    }

    public abstract Object setGatewayCache(ByteString p0, Continuation p1) {
        // native or abstract
    }

    public abstract void setGatewayState(ByteString p0) {
        // native or abstract
    }

    public abstract void setGatewayUrl(String p0) {
        // native or abstract
    }

    public abstract void setInitializationState(InitializationState p0) {
        // native or abstract
    }

    public abstract void setNativeConfiguration(NativeConfigurationOuterClass$NativeConfiguration p0) {
        // native or abstract
    }

    public abstract Object setPrivacy(ByteString p0, Continuation p1) {
        // native or abstract
    }

    public abstract Object setPrivacyFsm(ByteString p0, Continuation p1) {
        // native or abstract
    }

    public abstract void setSessionCounters(SessionCountersOuterClass$SessionCounters p0) {
        // native or abstract
    }

    public abstract void setSessionToken(ByteString p0) {
        // native or abstract
    }

    public abstract void setShouldInitialize(boolean p0) {
        // native or abstract
    }

    public abstract void setTokenCounters(TokenCounters p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.TcfRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public abstract class TcfRepository {
    public abstract String getTcfString() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.TransactionEventRepository
// ============================================================
package com.unity3d.ads.core.data.repository;

public abstract class TransactionEventRepository {
    public abstract void addTransactionEvent(TransactionEventRequestOuterClass$TransactionEventRequest p0) {
        // native or abstract
    }

    public abstract SharedFlow getTransactionEvents() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidCacheRepository$clearCache$2
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidCacheRepository$clearCache$2 extends SuspendLambda {
    int label;
    final AndroidCacheRepository this$0;

    AndroidCacheRepository$clearCache$2(AndroidCacheRepository p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidCacheRepository$clearCache$2(this$0, p1);
        return new AndroidCacheRepository$clearCache$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidCacheRepository$clearCache$2.invoke(p0, p1);
        return AndroidCacheRepository$clearCache$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidCacheRepository$clearCache$2.create(p0, p1);
        AndroidCacheRepository$clearCache$2.invokeSuspend(Unit.INSTANCE);
        return AndroidCacheRepository$clearCache$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_27;
        ResultKt.throwOnFailure(p0);
        AndroidCacheRepository.access$getCacheDir$p(this$0);
        File.listFiles();
        if (if-eqz(File.listFiles(..))) goto L_25;
      L_18:
        if (if-ge(0, label)) goto L_22;
        File.delete();
      L_22:
      L_25:
      L_26:
        return 0;
      L_27:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getCacheSize$2
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidCacheRepository$getCacheSize$2 extends SuspendLambda {
    int label;
    final AndroidCacheRepository this$0;

    AndroidCacheRepository$getCacheSize$2(AndroidCacheRepository p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidCacheRepository$getCacheSize$2(this$0, p1);
        return new AndroidCacheRepository$getCacheSize$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidCacheRepository$getCacheSize$2.invoke(p0, p1);
        return AndroidCacheRepository$getCacheSize$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidCacheRepository$getCacheSize$2.create(p0, p1);
        AndroidCacheRepository$getCacheSize$2.invokeSuspend(Unit.INSTANCE);
        return AndroidCacheRepository$getCacheSize$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_19;
        ResultKt.throwOnFailure(p0);
        AndroidCacheRepository.access$getCacheDir$p(this$0);
        FileExtensionsKt.getDirectorySize(AndroidCacheRepository.access$getCacheDir$p(..));
        Boxing.boxLong(FileExtensionsKt.getDirectorySize(..), v1);
        return Boxing.boxLong(..);
      L_19:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidCacheRepository$getFile$2 extends SuspendLambda {
    final String $objectId;
    final int $priority;
    final String $url;
    int label;
    final AndroidCacheRepository this$0;

    AndroidCacheRepository$getFile$2(AndroidCacheRepository p0, String p1, String p2, int p3, Continuation p4) {
        this$0 = p0;
        $url = p1;
        $objectId = p2;
        $priority = p3;
        new SuspendLambda(2, p4);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidCacheRepository$getFile$2(this$0, $url, $objectId, $priority, p1);
        return new AndroidCacheRepository$getFile$2;
    }

    public Object invoke(Object p0, Object p1) {
        AndroidCacheRepository$getFile$2.invoke(p0, p1);
        return AndroidCacheRepository$getFile$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidCacheRepository$getFile$2.create(p0, p1);
        AndroidCacheRepository$getFile$2.invokeSuspend(Unit.INSTANCE);
        return AndroidCacheRepository$getFile$2.invokeSuspend(..);
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
        this$0.getFilename($url);
        AndroidCacheRepository.access$getCreateFile$p(this$0);
        AndroidCacheRepository.access$getFilePath(this$0, AndroidCacheRepository.getFilename(..));
        CreateFile.invoke(AndroidCacheRepository.access$getFilePath(..));
        CreateFile.invoke(..).createNewFile();
        new AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1($url, 0, this$0, AndroidCacheRepository.getFilename(..), $url, $priority);
        label = 1;
        CoroutineScopeKt.coroutineScope(new AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1, this);
        if (if-ne(CoroutineScopeKt.coroutineScope(..), "call to 'resume' before 'invoke' with coroutine")) goto L_51;
        return "call to 'resume' before 'invoke' with coroutine";
      L_51:
        if (if-eqz("call to 'resume' before 'invoke' with coroutine")) goto L_74;
        CoroutineScopeKt.coroutineScope(..).getCachedFile();
        CachedFile.copy$default(CacheResult$Success.getCachedFile(..), $objectId, 0, 0, 0, 0, 0L, $url, 0, 0, 254, 0);
        AndroidCacheRepository.access$addFileToCache(this$0, CachedFile.copy$default(..));
      L_74:
        return CoroutineScopeKt.coroutineScope(..);
        new CacheResult$Failure(CacheError.FILE_IO_CREATE, 0, 2, 0);
        return new CacheResult$Failure(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1 extends SuspendLambda {
    final String $filename$inlined;
    final Object $key;
    final int $priority$inlined;
    final String $url$inlined;
    private Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final AndroidCacheRepository this$0;

    public AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1(Object p0, Continuation p1, AndroidCacheRepository p2, String p3, String p4, int p5) {
        $key = p0;
        this$0 = p2;
        $filename$inlined = p3;
        $url$inlined = p4;
        $priority$inlined = p5;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1($key, p1, this$0, $filename$inlined, $url$inlined, $priority$inlined);
        L$0 = p0;
        return new AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1;
    }

    public Object invoke(Object p0, Object p1) {
        AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1.invoke(p0, p1);
        return AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1.create(p0, p1);
        AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1.invokeSuspend(Unit.INSTANCE);
        return AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_2e;
        if (if-eq(label, 1)) goto L_20;
        if (if-ne(label, 2)) goto L_18;
        ResultKt.throwOnFailure(p0);
      L_18:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_20:
        ResultKt.throwOnFailure(p0);
      L_2e:
        ResultKt.throwOnFailure(p0);
        CoroutineExtensionsKt.getMutex();
        L$0 = L$0;
        L$1 = CoroutineExtensionsKt.getMutex(..);
        L$2 = $key;
        label = L$1;
        CoroutineExtensionsKt.getMutex(..).lock(0, this);
        if (if-ne(Mutex.lock(..), new IllegalStateException(..))) goto L_4e;
        return new IllegalStateException(..);
      L_4e:
      L_50:
        CoroutineExtensionsKt.getDeferreds();
        Map.get($key);
        if (if-nez(Map.get(..))) goto L_7f;
        new AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1(0, this$0, $filename$inlined, $url$inlined, $priority$inlined);
        BuildersKt.async$default(L$0, 0, 0, new AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1, 3, 0);
        Map.put($key, BuildersKt.async$default(..));
      L_7f:
        CoroutineExtensionsKt.getMutex(..).unlock(0);
        L$0 = 0;
        L$1 = 0;
        L$2 = 0;
        label = 2;
        BuildersKt.async$default(..).await(this);
        if (if-ne(Deferred.await(..), new IllegalStateException(..))) goto L_96;
        return new IllegalStateException(..);
      L_96:
        return Deferred.await(..);
        CoroutineExtensionsKt.getMutex(..).unlock(0);
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1 extends SuspendLambda {
    final String $filename$inlined;
    final int $priority$inlined;
    final String $url$inlined;
    int label;
    final AndroidCacheRepository this$0;

    public AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1(Continuation p0, AndroidCacheRepository p1, String p2, String p3, int p4) {
        this$0 = p1;
        $filename$inlined = p2;
        $url$inlined = p3;
        $priority$inlined = p4;
        new SuspendLambda(2, p0);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1(p1, this$0, $filename$inlined, $url$inlined, $priority$inlined);
        return new AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1;
    }

    public Object invoke(Object p0, Object p1) {
        AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1.invoke(p0, p1);
        return AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1.create(p0, p1);
        AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1.invokeSuspend(Unit.INSTANCE);
        return AndroidCacheRepository$getFile$2$invokeSuspend$$inlined$memoize$1$1.invokeSuspend(..);
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
        AndroidCacheRepository.access$getRemoteCacheDataSource$p(this$0);
        AndroidCacheRepository.access$getCacheDir$p(this$0);
        Boxing.boxInt($priority$inlined);
        label = 1;
        CacheDataSource.getFile(AndroidCacheRepository.access$getCacheDir$p(..), $filename$inlined, $url$inlined, Boxing.boxInt(..), this);
        if (if-ne(CacheDataSource.getFile(..), "call to 'resume' before 'invoke' with coroutine")) goto L_3d;
        return "call to 'resume' before 'invoke' with coroutine";
      L_3d:
        return CacheDataSource.getFile(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository$getAuidByteString$1
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidDeviceInfoRepository$getAuidByteString$1 extends ContinuationImpl {
    int label;
    Object result;
    final AndroidDeviceInfoRepository this$0;

    AndroidDeviceInfoRepository$getAuidByteString$1(AndroidDeviceInfoRepository p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.getAuidByteString(this);
        return AndroidDeviceInfoRepository.getAuidByteString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidDiagnosticEventRepository$configure$1
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidDiagnosticEventRepository$configure$1 extends Lambda {
    final AndroidDiagnosticEventRepository this$0;

    AndroidDiagnosticEventRepository$configure$1(AndroidDiagnosticEventRepository p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public Object invoke() {
        AndroidDiagnosticEventRepository$configure$1.invoke();
        return Unit.INSTANCE;
    }

    public final void invoke() {
        this$0.flush();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidDiagnosticEventRepository$flush$events$2
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidDiagnosticEventRepository$flush$events$2 extends Lambda {
    final AndroidDiagnosticEventRepository this$0;

    AndroidDiagnosticEventRepository$flush$events$2(AndroidDiagnosticEventRepository p0) {
        this$0 = p0;
        new Lambda(1);
        return;
    }

    public final DiagnosticEventRequestOuterClass$DiagnosticEvent invoke(DiagnosticEventRequestOuterClass$DiagnosticEvent p0) {
        if (if-nez(p0)) goto L_15;
        AndroidDiagnosticEventRepository.access$getGetDiagnosticEventRequest$p(this$0);
        GetDiagnosticEventRequest.invoke("null_diagnostic_event", 0, 0, 0, 0, 0, 0, 0);
      L_15:
        return GetDiagnosticEventRequest.invoke(..);
    }

    public Object invoke(Object p0) {
        AndroidDiagnosticEventRepository$flush$events$2.invoke(p0);
        return AndroidDiagnosticEventRepository$flush$events$2.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidDiagnosticEventRepository$flush$events$3
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidDiagnosticEventRepository$flush$events$3 extends Lambda {
    final AndroidDiagnosticEventRepository this$0;

    AndroidDiagnosticEventRepository$flush$events$3(AndroidDiagnosticEventRepository p0) {
        this$0 = p0;
        new Lambda(1);
        return;
    }

    public final Boolean invoke(DiagnosticEventRequestOuterClass$DiagnosticEvent p0) {
        AndroidDiagnosticEventRepository.access$getAllowedEvents$p(this$0);
        Set.isEmpty();
        if (if-nez(Set.isEmpty(..))) goto L_24;
        AndroidDiagnosticEventRepository.access$getAllowedEvents$p(this$0);
        p0.getEventType();
        Set.contains(DiagnosticEventRequestOuterClass$DiagnosticEvent.getEventType(..));
        if (if-eqz(Set.contains(..))) goto L_22;
      L_22:
      L_24:
      L_25:
        Boolean.valueOf(1);
        return Boolean.valueOf(..);
    }

    public Object invoke(Object p0) {
        AndroidDiagnosticEventRepository$flush$events$3.invoke(p0);
        return AndroidDiagnosticEventRepository$flush$events$3.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidDiagnosticEventRepository$flush$events$4
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidDiagnosticEventRepository$flush$events$4 extends Lambda {
    final AndroidDiagnosticEventRepository this$0;

    AndroidDiagnosticEventRepository$flush$events$4(AndroidDiagnosticEventRepository p0) {
        this$0 = p0;
        new Lambda(1);
        return;
    }

    public final Boolean invoke(DiagnosticEventRequestOuterClass$DiagnosticEvent p0) {
        AndroidDiagnosticEventRepository.access$getBlockedEvents$p(this$0);
        p0.getEventType();
        Set.contains(DiagnosticEventRequestOuterClass$DiagnosticEvent.getEventType(..));
        Boolean.valueOf(Set.contains(..));
        return Boolean.valueOf(..);
    }

    public Object invoke(Object p0) {
        AndroidDiagnosticEventRepository$flush$events$4.invoke(p0);
        return AndroidDiagnosticEventRepository$flush$events$4.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidMediationRepository$mediationProvider$1
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidMediationRepository$mediationProvider$1 extends Lambda {
    final AndroidMediationRepository this$0;

    AndroidMediationRepository$mediationProvider$1(AndroidMediationRepository p0) {
        this$0 = p0;
        new Lambda(0);
        return;
    }

    public final ClientInfoOuterClass$MediationProvider invoke() {
        this$0.getName();
        if (if-eqz(AndroidMediationRepository.getName(..))) goto L_3c;
        StringsKt.startsWith$default(AndroidMediationRepository.getName(..), "AppLovinSdk_", 0, 2, 0);
        if (if-eqz(StringsKt.startsWith$default(..))) goto L_16;
      L_16:
        StringsKt.equals(ClientInfoOuterClass$MediationProvider.MEDIATION_PROVIDER_MAX, "AdMob", 1);
        if (if-eqz(StringsKt.equals(..))) goto L_22;
      L_22:
        StringsKt.equals(ClientInfoOuterClass$MediationProvider.MEDIATION_PROVIDER_ADMOB, "MAX", 1);
        if (if-eqz(StringsKt.equals(..))) goto L_2d;
      L_2d:
        StringsKt.equals(ClientInfoOuterClass$MediationProvider.MEDIATION_PROVIDER_MAX, "ironSource", 1);
        if (if-eqz(StringsKt.equals(..))) goto L_38;
      L_38:
      L_3a:
        if (if-nez(ClientInfoOuterClass$MediationProvider.MEDIATION_PROVIDER_CUSTOM)) goto L_3e;
      L_3c:
      L_3e:
        return ClientInfoOuterClass$MediationProvider.MEDIATION_PROVIDER_UNSPECIFIED;
    }

    public Object invoke() {
        AndroidMediationRepository$mediationProvider$1.invoke();
        return AndroidMediationRepository$mediationProvider$1.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$activateOM$2
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidOpenMeasurementRepository$activateOM$2 extends SuspendLambda {
    final Context $context;
    int label;
    final AndroidOpenMeasurementRepository this$0;

    AndroidOpenMeasurementRepository$activateOM$2(AndroidOpenMeasurementRepository p0, Context p1, Continuation p2) {
        this$0 = p0;
        $context = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidOpenMeasurementRepository$activateOM$2(this$0, $context, p1);
        return new AndroidOpenMeasurementRepository$activateOM$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidOpenMeasurementRepository$activateOM$2.invoke(p0, p1);
        return AndroidOpenMeasurementRepository$activateOM$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidOpenMeasurementRepository$activateOM$2.create(p0, p1);
        AndroidOpenMeasurementRepository$activateOM$2.invokeSuspend(Unit.INSTANCE);
        return AndroidOpenMeasurementRepository$activateOM$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_5f;
        ResultKt.throwOnFailure(p0);
        this$0.isOMActive();
        if (if-eqz(AndroidOpenMeasurementRepository.isOMActive(..))) goto L_1c;
        new OMResult$Failure("om_already_active", 0, 2, 0);
        return new OMResult$Failure(..);
      L_1c:
        AndroidOpenMeasurementRepository.access$getOmidManager$p(this$0);
        OmidManager.activate($context);
        AndroidOpenMeasurementRepository.access$getOmidManager$p(this$0);
        OmidManager.isActive();
        this$0.setOMActive(OmidManager.isActive(..));
        this$0.isOMActive();
        if (if-eqz(AndroidOpenMeasurementRepository.isOMActive(..))) goto L_41;
      L_41:
        new OMResult$Failure("om_activate_failure_time", 0, 2, 0);
        new OMResult$Failure(..).getMessage();
        String.valueOf(Throwable.getMessage(..));
        new OMResult$Failure("uncaught_exception", String.valueOf(..));
      L_5e:
        return new OMResult$Failure(..);
      L_5f:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$finishSession$2
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidOpenMeasurementRepository$finishSession$2 extends SuspendLambda {
    final ByteString $opportunityId;
    int label;
    final AndroidOpenMeasurementRepository this$0;

    AndroidOpenMeasurementRepository$finishSession$2(AndroidOpenMeasurementRepository p0, ByteString p1, Continuation p2) {
        this$0 = p0;
        $opportunityId = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidOpenMeasurementRepository$finishSession$2(this$0, $opportunityId, p1);
        return new AndroidOpenMeasurementRepository$finishSession$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidOpenMeasurementRepository$finishSession$2.invoke(p0, p1);
        return AndroidOpenMeasurementRepository$finishSession$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidOpenMeasurementRepository$finishSession$2.create(p0, p1);
        AndroidOpenMeasurementRepository$finishSession$2.invokeSuspend(Unit.INSTANCE);
        return AndroidOpenMeasurementRepository$finishSession$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_3b;
        ResultKt.throwOnFailure(p0);
        this$0.isOMActive();
        if (if-nez(AndroidOpenMeasurementRepository.isOMActive(..))) goto L_1c;
        new OMResult$Failure("om_not_active", 0, 2, 0);
        return new OMResult$Failure(..);
      L_1c:
        AndroidOpenMeasurementRepository.access$getSession(this$0, $opportunityId);
        if (if-nez(AndroidOpenMeasurementRepository.access$getSession(..))) goto L_2e;
        new OMResult$Failure("om_session_not_found", 0, 2, 0);
        return new OMResult$Failure(..);
      L_2e:
        new OMResult$Failure(..).finish();
        AndroidOpenMeasurementRepository.access$sessionFinished(this$0, $opportunityId);
        return OMResult$Success.INSTANCE;
      L_3b:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$impressionOccurred$2
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidOpenMeasurementRepository$impressionOccurred$2 extends SuspendLambda {
    final ByteString $opportunityId;
    final boolean $signalLoaded;
    int label;
    final AndroidOpenMeasurementRepository this$0;

    AndroidOpenMeasurementRepository$impressionOccurred$2(AndroidOpenMeasurementRepository p0, ByteString p1, boolean p2, Continuation p3) {
        this$0 = p0;
        $opportunityId = p1;
        $signalLoaded = p2;
        new SuspendLambda(2, p3);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidOpenMeasurementRepository$impressionOccurred$2(this$0, $opportunityId, $signalLoaded, p1);
        return new AndroidOpenMeasurementRepository$impressionOccurred$2(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidOpenMeasurementRepository$impressionOccurred$2.invoke(p0, p1);
        return AndroidOpenMeasurementRepository$impressionOccurred$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidOpenMeasurementRepository$impressionOccurred$2.create(p0, p1);
        AndroidOpenMeasurementRepository$impressionOccurred$2.invokeSuspend(Unit.INSTANCE);
        return AndroidOpenMeasurementRepository$impressionOccurred$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_35;
        ResultKt.throwOnFailure(p0);
        AndroidOpenMeasurementRepository.access$getSession(this$0, $opportunityId);
        if (if-nez(AndroidOpenMeasurementRepository.access$getSession(..))) goto L_1e;
        new OMResult$Failure("om_session_not_found", 0, 2, 0);
        return new OMResult$Failure(..);
      L_1e:
        AndroidOpenMeasurementRepository.access$getOmidManager$p(this$0);
        OmidManager.createAdEvents(new OMResult$Failure(..));
        if (if-eqz($signalLoaded)) goto L_2f;
        OmidManager.createAdEvents(..).loaded();
      L_2f:
        OmidManager.createAdEvents(..).impressionOccurred();
        return OMResult$Success.INSTANCE;
      L_35:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$startSession$2
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidOpenMeasurementRepository$startSession$2 extends SuspendLambda {
    final ByteString $opportunityId;
    final OmidOptions $options;
    final WebView $webView;
    int label;
    final AndroidOpenMeasurementRepository this$0;

    AndroidOpenMeasurementRepository$startSession$2(AndroidOpenMeasurementRepository p0, ByteString p1, OmidOptions p2, WebView p3, Continuation p4) {
        this$0 = p0;
        $opportunityId = p1;
        $options = p2;
        $webView = p3;
        new SuspendLambda(2, p4);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidOpenMeasurementRepository$startSession$2(this$0, $opportunityId, $options, $webView, p1);
        return new AndroidOpenMeasurementRepository$startSession$2;
    }

    public Object invoke(Object p0, Object p1) {
        AndroidOpenMeasurementRepository$startSession$2.invoke(p0, p1);
        return AndroidOpenMeasurementRepository$startSession$2.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidOpenMeasurementRepository$startSession$2.create(p0, p1);
        AndroidOpenMeasurementRepository$startSession$2.invokeSuspend(Unit.INSTANCE);
        return AndroidOpenMeasurementRepository$startSession$2.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_f8;
        ResultKt.throwOnFailure(p0);
        this$0.isOMActive();
        if (if-nez(AndroidOpenMeasurementRepository.isOMActive(..))) goto L_1c;
        new OMResult$Failure("om_not_active", 0, 2, 0);
        return new OMResult$Failure(..);
      L_1c:
        AndroidOpenMeasurementRepository.access$getActiveSessions$p(this$0);
        MutableStateFlow.getValue();
        ProtobufExtensionsKt.toISO8859String($opportunityId);
        MutableStateFlow.getValue(..).containsKey(ProtobufExtensionsKt.toISO8859String(..));
        if (if-eqz(Map.containsKey(..))) goto L_3c;
        new OMResult$Failure("om_session_already_exists", 0, 2, 0);
        return new OMResult$Failure(..);
      L_3c:
        $options.getCreativeType();
        if (if-nez(OmidOptions.getCreativeType(..))) goto L_4c;
        new OMResult$Failure("om_creative_type_null", 0, 2, 0);
        return new OMResult$Failure(..);
      L_4c:
        AndroidOpenMeasurementRepository.access$getOmidManager$p(this$0);
        $options.getImpressionType();
        if (if-nez(OmidOptions.getImpressionType(..))) goto L_5c;
      L_5c:
        $options.getImpressionOwner();
        if (if-nez(OmidOptions.getImpressionOwner(..))) goto L_67;
      L_67:
        $options.getVideoEventsOwner();
        if (if-nez(OmidOptions.getVideoEventsOwner(..))) goto L_72;
      L_72:
        $options.getIsolateVerificationScripts();
        OmidManager.createAdSessionConfiguration(new OMResult$Failure(..), ImpressionType.DEFINED_BY_JAVASCRIPT, Owner.JAVASCRIPT, Owner.JAVASCRIPT, OmidOptions.getIsolateVerificationScripts(..));
        new OMResult$Failure(..).ordinal();
        if (if-eq(CreativeType.ordinal(..), 1)) goto L_ac;
        if (if-eq(CreativeType.ordinal(..), 2)) goto L_93;
        new OMResult$Failure("om_creative_type_invalid", 0, 2, 0);
        return new OMResult$Failure(..);
      L_93:
        AndroidOpenMeasurementRepository.access$getOmidManager$p(this$0);
        AndroidOpenMeasurementRepository.access$getPartner$p(this$0);
        $options.getCustomReferenceData();
        OmidManager.createJavaScriptAdSessionContext(AndroidOpenMeasurementRepository.access$getPartner$p(..), $webView, 0, OmidOptions.getCustomReferenceData(..));
      L_ac:
        AndroidOpenMeasurementRepository.access$getOmidManager$p(this$0);
        AndroidOpenMeasurementRepository.access$getPartner$p(this$0);
        $options.getCustomReferenceData();
        OmidManager.createHtmlAdSessionContext(AndroidOpenMeasurementRepository.access$getPartner$p(..), $webView, 0, OmidOptions.getCustomReferenceData(..));
      L_c4:
        AndroidOpenMeasurementRepository.access$getOmidManager$p(this$0);
        OmidManager.createAdSession("om_creative_type_invalid", OmidManager.createHtmlAdSessionContext(..));
        OmidManager.createAdSession(..).registerAdView($webView);
        OmidManager.createAdSession(..).start();
        AndroidOpenMeasurementRepository.access$addSession(this$0, $opportunityId, OmidManager.createAdSession(..));
        OMResult$Success.INSTANCE.getMessage();
        String.valueOf(Throwable.getMessage(..));
        new OMResult$Failure("uncaught_exception", String.valueOf(..));
      L_f7:
        return new OMResult$Failure(..);
      L_f8:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository$1
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidSessionRepository$1 extends SuspendLambda {
    final SendDiagnosticEvent $sendDiagnosticEvent;
    int label;
    final AndroidSessionRepository this$0;

    AndroidSessionRepository$1(AndroidSessionRepository p0, SendDiagnosticEvent p1, Continuation p2) {
        this$0 = p0;
        $sendDiagnosticEvent = p1;
        new SuspendLambda(2, p2);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidSessionRepository$1(this$0, $sendDiagnosticEvent, p1);
        return new AndroidSessionRepository$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidSessionRepository$1.invoke(p0, p1);
        return AndroidSessionRepository$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidSessionRepository$1.create(p0, p1);
        AndroidSessionRepository$1.invokeSuspend(Unit.INSTANCE);
        return AndroidSessionRepository$1.invokeSuspend(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-eqz(label)) goto L_19;
        if (if-ne(label, 1)) goto L_11;
        ResultKt.throwOnFailure(p0);
      L_11:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
      L_19:
        ResultKt.throwOnFailure(new IllegalStateException(..));
        AndroidSessionRepository.access$getNativeConfigDataSource$p(this$0);
        label = 1;
        ByteStringDataSource.get(this);
        if (if-ne(ByteStringDataSource.get(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2e;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2e:
        ByteStringDataSource.get(..).getData();
        ByteString.isEmpty();
        if (if-nez(ByteString.isEmpty(..))) goto L_6c;
        AndroidSessionRepository.access$get_sdkConfiguration$p(this$0);
        NativeConfigurationOuterClass$NativeConfiguration.parseFrom(ByteStringStoreOuterClass$ByteStringStore.getData(..));
        MutableStateFlow.setValue(NativeConfigurationOuterClass$NativeConfiguration.parseFrom(..));
      L_4d:
        Exception.getMessage();
        if (if-nez(Exception.getMessage(..))) goto L_5a;
      L_5a:
        TuplesKt.to("debugReason", "unknown");
        MapsKt.mapOf(TuplesKt.to(..));
        SendDiagnosticEvent$DefaultImpls.invoke$default($sendDiagnosticEvent, "native_initialize_missed_native_parsing", 0, MapsKt.mapOf(..), 0, 0, 26, 0);
      L_6c:
        AndroidSessionRepository.access$isInit$p(this$0);
        Boxing.boxBoolean(1);
        MutableStateFlow.setValue(Boxing.boxBoolean(..));
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository$getGatewayCache$1
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidSessionRepository$getGatewayCache$1 extends ContinuationImpl {
    int label;
    Object result;
    final AndroidSessionRepository this$0;

    AndroidSessionRepository$getGatewayCache$1(AndroidSessionRepository p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.getGatewayCache(this);
        return AndroidSessionRepository.getGatewayCache(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository$getPrivacy$1
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidSessionRepository$getPrivacy$1 extends ContinuationImpl {
    int label;
    Object result;
    final AndroidSessionRepository this$0;

    AndroidSessionRepository$getPrivacy$1(AndroidSessionRepository p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.getPrivacy(this);
        return AndroidSessionRepository.getPrivacy(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository$getPrivacyFsm$1
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidSessionRepository$getPrivacyFsm$1 extends ContinuationImpl {
    int label;
    Object result;
    final AndroidSessionRepository this$0;

    AndroidSessionRepository$getPrivacyFsm$1(AndroidSessionRepository p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.getPrivacyFsm(this);
        return AndroidSessionRepository.getPrivacyFsm(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository$nativeConfiguration$1
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidSessionRepository$nativeConfiguration$1 extends SuspendLambda {
    int label;
    final AndroidSessionRepository this$0;

    AndroidSessionRepository$nativeConfiguration$1(AndroidSessionRepository p0, Continuation p1) {
        this$0 = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new AndroidSessionRepository$nativeConfiguration$1(this$0, p1);
        return new AndroidSessionRepository$nativeConfiguration$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        AndroidSessionRepository$nativeConfiguration$1.invoke(p0, p1);
        return AndroidSessionRepository$nativeConfiguration$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        AndroidSessionRepository$nativeConfiguration$1.create(p0, p1);
        AndroidSessionRepository$nativeConfiguration$1.invokeSuspend(Unit.INSTANCE);
        return AndroidSessionRepository$nativeConfiguration$1.invokeSuspend(..);
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
        AndroidSessionRepository.access$getPersistedNativeConfiguration$p(this$0);
        label = 1;
        FlowKt.first(AndroidSessionRepository.access$getPersistedNativeConfiguration$p(..), this);
        if (if-ne(FlowKt.first(..), "call to 'resume' before 'invoke' with coroutine")) goto L_2c;
        return "call to 'resume' before 'invoke' with coroutine";
      L_2c:
        return FlowKt.first(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository$persistedNativeConfiguration$1
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidSessionRepository$persistedNativeConfiguration$1 extends SuspendLambda {
    Object L$0;
    boolean Z$0;
    int label;

    AndroidSessionRepository$persistedNativeConfiguration$1(Continuation p0) {
        new SuspendLambda(3, p0);
        return;
    }

    public final Object invoke(NativeConfigurationOuterClass$NativeConfiguration p0, boolean p1, Continuation p2) {
        new AndroidSessionRepository$persistedNativeConfiguration$1(p2);
        L$0 = p0;
        Z$0 = p1;
        AndroidSessionRepository$persistedNativeConfiguration$1.invokeSuspend(Unit.INSTANCE);
        return AndroidSessionRepository$persistedNativeConfiguration$1.invokeSuspend(..);
    }

    public Object invoke(Object p0, Object p1, Object p2) {
        p1.booleanValue();
        AndroidSessionRepository$persistedNativeConfiguration$1.invoke(p0, Boolean.booleanValue(..), p2);
        return AndroidSessionRepository$persistedNativeConfiguration$1.invoke(..);
    }

    public final Object invokeSuspend(Object p0) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-nez(label)) goto L_19;
        ResultKt.throwOnFailure(p0);
        Boxing.boxBoolean(Z$0);
        TuplesKt.to(L$0, Boxing.boxBoolean(..));
        return TuplesKt.to(..);
      L_19:
        new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository$setPrivacy$1
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidSessionRepository$setPrivacy$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final AndroidSessionRepository this$0;

    AndroidSessionRepository$setPrivacy$1(AndroidSessionRepository p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.setPrivacy(0, this);
        return AndroidSessionRepository.setPrivacy(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository$setPrivacyFsm$1
// ============================================================
package com.unity3d.ads.core.data.repository;

final class AndroidSessionRepository$setPrivacyFsm$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final AndroidSessionRepository this$0;

    AndroidSessionRepository$setPrivacyFsm$1(AndroidSessionRepository p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.setPrivacyFsm(0, this);
        return AndroidSessionRepository.setPrivacyFsm(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository$special$$inlined$filter$1
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidSessionRepository$special$$inlined$filter$1 {
    final Flow $this_unsafeTransform$inlined;

    public AndroidSessionRepository$special$$inlined$filter$1(Flow p0) {
        $this_unsafeTransform$inlined = p0;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new AndroidSessionRepository$special$$inlined$filter$1$2(p0);
        $this_unsafeTransform$inlined.collect(new AndroidSessionRepository$special$$inlined$filter$1$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14;
        return Flow.collect(..);
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository$special$$inlined$filter$1$2
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidSessionRepository$special$$inlined$filter$1$2 {
    final FlowCollector $this_unsafeFlow;

    public AndroidSessionRepository$special$$inlined$filter$1$2(FlowCollector p0) {
        $this_unsafeFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidSessionRepository$special$$inlined$filter$1$2$1(this, label);
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
        new IllegalStateException(..).getSecond();
        Pair.getSecond(..).booleanValue();
        if (if-eqz(Boolean.booleanValue(..))) goto L_52;
        label = 1;
        $this_unsafeFlow.emit(new IllegalStateException(..), new AndroidSessionRepository$special$$inlined$filter$1$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_52;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_52:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository$special$$inlined$filter$1$2$1
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidSessionRepository$special$$inlined$filter$1$2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final AndroidSessionRepository$special$$inlined$filter$1$2 this$0;

    public AndroidSessionRepository$special$$inlined$filter$1$2$1(AndroidSessionRepository$special$$inlined$filter$1$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return AndroidSessionRepository$special$$inlined$filter$1$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository$special$$inlined$map$1
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidSessionRepository$special$$inlined$map$1 {
    final Flow $this_unsafeTransform$inlined;

    public AndroidSessionRepository$special$$inlined$map$1(Flow p0) {
        $this_unsafeTransform$inlined = p0;
        new Object();
        return;
    }

    public Object collect(FlowCollector p0, Continuation p1) {
        new AndroidSessionRepository$special$$inlined$map$1$2(p0);
        $this_unsafeTransform$inlined.collect(new AndroidSessionRepository$special$$inlined$map$1$2(..), p1);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (if-ne(Flow.collect(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_14;
        return Flow.collect(..);
      L_14:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository$special$$inlined$map$1$2
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidSessionRepository$special$$inlined$map$1$2 {
    final FlowCollector $this_unsafeFlow;

    public AndroidSessionRepository$special$$inlined$map$1$2(FlowCollector p0) {
        $this_unsafeFlow = p0;
        new Object();
        return;
    }

    public final Object emit(Object p0, Continuation p1) {
        if (if-eqz(v0)) goto L_14;
        if (if-eqz(label)) goto L_14;
        label = label;
      L_14:
        new AndroidSessionRepository$special$$inlined$map$1$2$1(this, label);
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
        new IllegalStateException(..).getFirst();
        label = 1;
        $this_unsafeFlow.emit(Pair.getFirst(..), new AndroidSessionRepository$special$$inlined$map$1$2$1(..));
        if (if-ne(FlowCollector.emit(..), IntrinsicsKt.getCOROUTINE_SUSPENDED(..))) goto L_49;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED(..);
      L_49:
        return Unit.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.AndroidSessionRepository$special$$inlined$map$1$2$1
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class AndroidSessionRepository$special$$inlined$map$1$2$1 extends ContinuationImpl {
    Object L$0;
    int label;
    Object result;
    final AndroidSessionRepository$special$$inlined$map$1$2 this$0;

    public AndroidSessionRepository$special$$inlined$map$1$2$1(AndroidSessionRepository$special$$inlined$map$1$2 p0, Continuation p1) {
        this$0 = p0;
        new ContinuationImpl(p1);
        return;
    }

    public final Object invokeSuspend(Object p0) {
        result = p0;
        label = label;
        this$0.emit(0, this);
        return AndroidSessionRepository$special$$inlined$map$1$2.emit(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.data.repository.CacheRepository$DefaultImpls
// ============================================================
package com.unity3d.ads.core.data.repository;

public final class CacheRepository$DefaultImpls {
    public static Object getFile$default(CacheRepository p0, String p1, String p2, JSONArray p3, int p4, Continuation p5, int p6, Object p7) {
        if (if-nez(p7)) goto L_17;
        if (if-eqz(p7)) goto L_7;
      L_7:
        if (if-eqz(0)) goto L_d;
      L_d:
        p0.getFile(p1, p2, 0, 0, p5);
        return CacheRepository.getFile(..);
      L_17:
        new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFile");
        throw new UnsupportedOperationException(..);
    }

}

