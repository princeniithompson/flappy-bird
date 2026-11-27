// Package bundle: com.unity3d.services.core.di (196 classes)

// ============================================================
// CLASS: com.unity3d.services.core.di.Factory
// ============================================================
package com.unity3d.services.core.di;

final class Factory {
    private final Function0 initializer;

    public Factory(Function0 p0) {
        new Object();
        initializer = p0;
        return;
    }

    public Object getValue() {
        initializer.invoke();
        return Function0.invoke(..);
    }

    public boolean isInitialized() {
        return 0;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.IServiceComponent
// ============================================================
package com.unity3d.services.core.di;

public abstract class IServiceComponent {
    public abstract IServiceProvider getServiceProvider() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.IServiceComponentKt
// ============================================================
package com.unity3d.services.core.di;

public final class IServiceComponentKt {
    public static final Object get(IServiceComponent p0, String p1) {
        p0.getServiceProvider();
        IServiceProvider.getRegistry();
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        IServiceProvider.getRegistry(..).getService(p1, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

    public static Object get$default(IServiceComponent p0, String p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        p0.getServiceProvider();
        IServiceProvider.getRegistry();
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        IServiceProvider.getRegistry(..).getService("", Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

    public static final Lazy inject(IServiceComponent p0, String p1, LazyThreadSafetyMode p2) {
        Intrinsics.needClassReification();
        new IServiceComponentKt$inject$1(p0, p1);
        LazyKt.lazy(p2, new IServiceComponentKt$inject$1(..));
        return LazyKt.lazy(..);
    }

    public static Lazy inject$default(IServiceComponent p0, String p1, LazyThreadSafetyMode p2, int p3, Object p4) {
        if (if-eqz(p4)) goto L_6;
      L_6:
        if (if-eqz(p3)) goto L_c;
      L_c:
        Intrinsics.needClassReification();
        new IServiceComponentKt$inject$1(p0, "");
        LazyKt.lazy(LazyThreadSafetyMode.NONE, new IServiceComponentKt$inject$1(..));
        return LazyKt.lazy(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.IServiceProvider
// ============================================================
package com.unity3d.services.core.di;

public abstract class IServiceProvider {
    public abstract IServicesRegistry getRegistry() {
        // native or abstract
    }

    public abstract IServicesRegistry initialize() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.IServicesRegistry
// ============================================================
package com.unity3d.services.core.di;

public abstract class IServicesRegistry {
    public abstract Object getService(String p0, KClass p1) {
        // native or abstract
    }

    public abstract Map getServices() {
        // native or abstract
    }

    public abstract Object resolveService(ServiceKey p0) {
        // native or abstract
    }

    public abstract Object resolveServiceOrNull(ServiceKey p0) {
        // native or abstract
    }

    public abstract void updateService(ServiceKey p0, Lazy p1) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceFactoryKt
// ============================================================
package com.unity3d.services.core.di;

public final class ServiceFactoryKt {
    public static final Lazy factoryOf(Function0 p0) {
        new Factory(p0);
        return new Factory(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceKey
// ============================================================
package com.unity3d.services.core.di;

public final class ServiceKey {
    private final KClass instanceClass;
    private final String named;

    public ServiceKey(String p0, KClass p1) {
        new Object();
        named = p0;
        instanceClass = p1;
        return;
    }

    public ServiceKey(String p0, KClass p1, int p2, DefaultConstructorMarker p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        new ServiceKey("", p1);
        return;
    }

    public static ServiceKey copy$default(ServiceKey p0, String p1, KClass p2, int p3, Object p4) {
        if (if-eqz(p4)) goto L_6;
      L_6:
        if (if-eqz(p3)) goto L_c;
      L_c:
        p0.copy(named, instanceClass);
        return ServiceKey.copy(..);
    }

    public final String component1() {
        return named;
    }

    public final KClass component2() {
        return instanceClass;
    }

    public final ServiceKey copy(String p0, KClass p1) {
        new ServiceKey(p0, p1);
        return new ServiceKey(..);
    }

    public boolean equals(Object p0) {
        if (if-ne(this, p0)) goto L_4;
        return 1;
      L_4:
        if (if-nez(v1)) goto L_a;
        return 0;
      L_a:
        Intrinsics.areEqual(named, named);
        if (if-nez(Intrinsics.areEqual(..))) goto L_17;
        return 0;
      L_17:
        Intrinsics.areEqual(instanceClass, instanceClass);
        if (if-nez(Intrinsics.areEqual(..))) goto L_22;
        return 0;
      L_22:
        return 1;
    }

    public final KClass getInstanceClass() {
        return instanceClass;
    }

    public final String getNamed() {
        return named;
    }

    public int hashCode() {
        named.hashCode();
        instanceClass.hashCode();
        return String.hashCode(..);
    }

    public String toString() {
        new StringBuilder("ServiceKey(named=");
        new StringBuilder(..).append(named);
        new StringBuilder(..).append(", instanceClass=");
        new StringBuilder(..).append(instanceClass);
        new StringBuilder(..).append(41);
        new StringBuilder(..).toString();
        return StringBuilder.toString(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider
// ============================================================
package com.unity3d.services.core.di;

public final class ServiceProvider {
    public static final String CDN_CREATIVES_HOST = "cdn-creatives-cf-prd.acquire.unity3dusercontent.com";
    public static final int CDN_CREATIVES_PORT = 443;
    public static final String DATA_STORE_GATEWAY_CACHE = "gateway_cache.pb";
    public static final String DATA_STORE_GL_INFO = "glinfo.pb";
    public static final String DATA_STORE_IAP_TRANSACTION = "iap_transaction.pb";
    public static final String DATA_STORE_NATIVE_CONFIG = "native_configuration.pb";
    public static final String DATA_STORE_PRIVACY = "privacy.pb";
    public static final String DATA_STORE_PRIVACY_FSM = "privacy_fsm.pb";
    public static final String DATA_STORE_UNIVERSAL_REQUEST = "universal_request.pb";
    public static final String DATA_STORE_WEBVIEW_CONFIG = "webview_config.pb";
    public static final String DEFAULT_DISPATCHER = "default_dispatcher";
    public static final String DEV_CONSENT_PRIVACY_RULES = "dev_consent_privacy_rules";
    public static final String GATEWAY_HOST = "gateway.unityads.unity3d.com";
    public static final int GATEWAY_PORT = 443;
    public static final long HTTP_CACHE_DISK_SIZE = 5242880L;
    public static final long HTTP_CLIENT_FETCH_TIMEOUT = 500L;
    public static final ServiceProvider INSTANCE = null;
    public static final String IO_DISPATCHER = "io_dispatcher";
    public static final String LEGACY_PRIVACY_RULES = "legacy_privacy_rules";
    public static final String MAIN_DISPATCHER = "main_dispatcher";
    public static final String NAMED_AD_REQ = "ad_req";
    public static final String NAMED_GET_TOKEN_SCOPE = "get_token_scope";
    public static final String NAMED_INIT_REQ = "init_req";
    public static final String NAMED_INIT_SCOPE = "init_scope";
    public static final String NAMED_LOAD_SCOPE = "load_scope";
    public static final String NAMED_LOCAL = "local";
    public static final String NAMED_OMID_SCOPE = "omid_scope";
    public static final String NAMED_OPERATIVE_REQ = "op_event_req";
    public static final String NAMED_OTHER_REQ = "other_req";
    public static final String NAMED_PUBLIC_JOB = "public_job";
    public static final String NAMED_REMOTE = "remote";
    public static final String NAMED_SDK = "sdk";
    public static final String NAMED_SHOW_SCOPE = "show_scope";
    public static final String NAMED_TRANSACTION_SCOPE = "transaction_scope";
    public static final String PREF_GL_INFO = "glinfo";
    private static final IServicesRegistry serviceRegistry;

    static <clinit>() {
        new ServiceProvider();
        INSTANCE = new ServiceProvider(..);
        new ServiceProvider(..).initialize();
        serviceRegistry = ServiceProvider.initialize(..);
        return;
    }

    private ServiceProvider() {
        new Object();
        return;
    }

    public IServicesRegistry getRegistry() {
        return ServiceProvider.serviceRegistry;
    }

    public IServicesRegistry initialize() {
        ServicesRegistryKt.registry(ServiceProvider$initialize$1.INSTANCE);
        return ServicesRegistryKt.registry(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServicesRegistry
// ============================================================
package com.unity3d.services.core.di;

public final class ServicesRegistry {
    private final ConcurrentHashMap _services;

    public ServicesRegistry() {
        new Object();
        new ConcurrentHashMap();
        _services = new ConcurrentHashMap(..);
        return;
    }

    public static ServiceKey factory$default(ServicesRegistry p0, String p1, Function0 p2, int p3, Object p4) {
        if (if-eqz(p3)) goto L_6;
      L_6:
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(p2);
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        return new ServiceKey(..);
    }

    public static Object get$default(ServicesRegistry p0, String p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        p0.resolveService(new ServiceKey(..));
        return ServicesRegistry.resolveService(..);
    }

    public static Object getOrNull$default(ServicesRegistry p0, String p1, int p2, Object p3) {
        if (if-eqz(p2)) goto L_6;
      L_6:
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        p0.resolveServiceOrNull(new ServiceKey(..));
        return ServicesRegistry.resolveServiceOrNull(..);
    }

    public static ServiceKey single$default(ServicesRegistry p0, String p1, Function0 p2, int p3, Object p4) {
        if (if-eqz(p3)) goto L_6;
      L_6:
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(p2);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        return new ServiceKey(..);
    }

    public final ServiceKey factory(String p0, Function0 p1) {
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new ServiceKey(p0, Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(p1);
        ServicesRegistry.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        return new ServiceKey(..);
    }

    public final Object get(String p0) {
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new ServiceKey(p0, Reflection.getOrCreateKotlinClass(..));
        ServicesRegistry.resolveService(new ServiceKey(..));
        return ServicesRegistry.resolveService(..);
    }

    public final Object getOrNull(String p0) {
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new ServiceKey(p0, Reflection.getOrCreateKotlinClass(..));
        ServicesRegistry.resolveServiceOrNull(new ServiceKey(..));
        return ServicesRegistry.resolveServiceOrNull(..);
    }

    public Object getService(String p0, KClass p1) {
        new ServiceKey(p0, p1);
        ServicesRegistry.resolveService(new ServiceKey(..));
        return ServicesRegistry.resolveService(..);
    }

    public Map getServices() {
        return _services;
    }

    public Object resolveService(ServiceKey p0) {
        ServicesRegistry.getServices();
        ServicesRegistry.getServices(..).get(p0);
        if (if-eqz(Map.get(..))) goto L_16;
        Map.get(..).getValue();
        return Lazy.getValue(..);
      L_16:
        new StringBuilder("No service instance found for ");
        new StringBuilder(..).append(Lazy.getValue(..));
        new StringBuilder(..).toString();
        new IllegalStateException(StringBuilder.toString(..));
        throw new IllegalStateException(..);
    }

    public Object resolveServiceOrNull(ServiceKey p0) {
        ServicesRegistry.getServices();
        ServicesRegistry.getServices(..).get(p0);
        if (if-nez(Map.get(..))) goto L_13;
        return 0;
      L_13:
        0.getValue();
        return Lazy.getValue(..);
    }

    public final ServiceKey single(String p0, Function0 p1) {
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        new ServiceKey(p0, Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(p1);
        ServicesRegistry.updateService(new ServiceKey(..), LazyKt.lazy(..));
        return new ServiceKey(..);
    }

    public void updateService(ServiceKey p0, Lazy p1) {
        ServicesRegistry.getServices();
        ServicesRegistry.getServices(..).containsKey(p0);
        if (if-eqz(Map.containsKey(..))) goto L_1e;
        _services.put(p0, p1);
        return;
      L_1e:
        new StringBuilder("Cannot have multiple identical services: ");
        new StringBuilder(..).append(p0);
        new StringBuilder(..).toString();
        StringBuilder.toString(..).toString();
        new IllegalStateException(Object.toString(..));
        throw new IllegalStateException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServicesRegistryKt
// ============================================================
package com.unity3d.services.core.di;

public final class ServicesRegistryKt {
    public static final ServicesRegistry registry(Function1 p0) {
        new ServicesRegistry();
        p0.invoke(new ServicesRegistry(..));
        return new ServicesRegistry(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.UnityAdsModule
// ============================================================
package com.unity3d.services.core.di;

public final class UnityAdsModule {
    public UnityAdsModule() {
        new Object();
        return;
    }

    private final NativeConfigurationOuterClass$AdOperationsConfiguration getDefaultAdOperations() {
        NativeConfigurationOuterClass$AdOperationsConfiguration.newBuilder();
        AdOperationsConfigurationKt$Dsl$Companion._create(NativeConfigurationOuterClass$AdOperationsConfiguration.newBuilder(..));
        AdOperationsConfigurationKt$Dsl.setLoadTimeoutMs(30000);
        AdOperationsConfigurationKt$Dsl.setShowTimeoutMs(10000);
        AdOperationsConfigurationKt$Dsl.setGetTokenTimeoutMs(2750);
        AdOperationsConfigurationKt$Dsl._build();
        return AdOperationsConfigurationKt$Dsl._build(..);
    }

    private final NativeConfigurationOuterClass$RequestPolicy getDefaultRequestPolicy() {
        NativeConfigurationOuterClass$RequestPolicy.newBuilder();
        RequestPolicyKt$Dsl.Companion._create(NativeConfigurationOuterClass$RequestPolicy.newBuilder(..));
        UnityAdsModule.getDefaultRequestRetryPolicy();
        RequestPolicyKt$Dsl.setRetryPolicy(UnityAdsModule.getDefaultRequestRetryPolicy(..));
        UnityAdsModule.getDefaultRequestTimeoutPolicy();
        RequestPolicyKt$Dsl.setTimeoutPolicy(UnityAdsModule.getDefaultRequestTimeoutPolicy(..));
        RequestPolicyKt$Dsl._build();
        return RequestPolicyKt$Dsl._build(..);
    }

    private final NativeConfigurationOuterClass$RequestRetryPolicy getDefaultRequestRetryPolicy() {
        NativeConfigurationOuterClass$RequestRetryPolicy.newBuilder();
        RequestRetryPolicyKt$Dsl.Companion._create(NativeConfigurationOuterClass$RequestRetryPolicy.newBuilder(..));
        RequestRetryPolicyKt$Dsl.setMaxDuration(120000);
        RequestRetryPolicyKt$Dsl.setRetryWaitBase(500);
        RequestRetryPolicyKt$Dsl.setRetryJitterPct(1036831949);
        RequestRetryPolicyKt$Dsl.setShouldStoreLocally(0);
        RequestRetryPolicyKt$Dsl.setRetryMaxInterval(1000);
        RequestRetryPolicyKt$Dsl.setRetryScalingFactor(2.0f);
        RequestRetryPolicyKt$Dsl._build();
        return RequestRetryPolicyKt$Dsl._build(..);
    }

    private final NativeConfigurationOuterClass$RequestTimeoutPolicy getDefaultRequestTimeoutPolicy() {
        NativeConfigurationOuterClass$RequestTimeoutPolicy.newBuilder();
        RequestTimeoutPolicyKt$Dsl.Companion._create(NativeConfigurationOuterClass$RequestTimeoutPolicy.newBuilder(..));
        RequestTimeoutPolicyKt$Dsl.setConnectTimeoutMs(10000);
        RequestTimeoutPolicyKt$Dsl.setReadTimeoutMs(10000);
        RequestTimeoutPolicyKt$Dsl.setWriteTimeoutMs(10000);
        RequestTimeoutPolicyKt$Dsl.setOverallTimeoutMs(20000);
        RequestTimeoutPolicyKt$Dsl._build();
        return RequestTimeoutPolicyKt$Dsl._build(..);
    }

    private final ByteStringDataSource provideByteStringDataSource(DataStore p0) {
        new AndroidByteStringDataSource(p0);
        return new AndroidByteStringDataSource(..);
    }

    private final DataStore provideByteStringDataStore(Context p0, CoroutineDispatcher p1, String p2) {
        new ByteStringSerializer();
        SupervisorKt.SupervisorJob$default(0, 1, 0);
        p1.plus(SupervisorKt.SupervisorJob$default(..));
        CoroutineScopeKt.CoroutineScope(CoroutineDispatcher.plus(..));
        new UnityAdsModule$provideByteStringDataStore$1(p0, p2);
        DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new ByteStringSerializer(..), 0, 0, CoroutineScopeKt.CoroutineScope(..), new UnityAdsModule$provideByteStringDataStore$1(..), 4, 0);
        return DataStoreFactory.create$default(..);
    }

    private final JsonStorage provideJsonStorage(StorageManager$StorageType p0) {
        ClientProperties.getApplicationContext();
        StorageManager.init(ClientProperties.getApplicationContext(..));
        if (if-eqz(StorageManager.init(..))) goto L_16;
        StorageManager.getStorage(p0);
        return StorageManager.getStorage(..);
      L_16:
        Object.toString();
        new IllegalStateException(Object.toString(..));
        throw new IllegalStateException(..);
    }

    public final Context androidContext() {
        ClientProperties.getApplicationContext();
        return ClientProperties.getApplicationContext(..);
    }

    public final AsyncTokenStorage asyncTokenStorage(TokenStorage p0, SDKMetricsSender p1) {
        Looper.getMainLooper();
        new Handler(Looper.getMainLooper(..));
        new InMemoryAsyncTokenStorage(0, new Handler(..), p1, p0);
        return new InMemoryAsyncTokenStorage(..);
    }

    public final ByteStringDataSource auidDataStore(DataStore p0) {
        UnityAdsModule.provideByteStringDataSource(p0);
        return UnityAdsModule.provideByteStringDataSource(..);
    }

    public final CoroutineDispatcher defaultDispatcher() {
        Dispatchers.getDefault();
        return Dispatchers.getDefault(..);
    }

    public final NativeConfigurationOuterClass$NativeConfiguration defaultNativeConfiguration() {
        NativeConfigurationOuterClass$NativeConfiguration.newBuilder();
        NativeConfigurationKt$Dsl.Companion._create(NativeConfigurationOuterClass$NativeConfiguration.newBuilder(..));
        UnityAdsModule.getDefaultAdOperations();
        NativeConfigurationKt$Dsl.setAdOperations(UnityAdsModule.getDefaultAdOperations(..));
        UnityAdsModule.getDefaultRequestPolicy();
        NativeConfigurationKt$Dsl.setInitPolicy(UnityAdsModule.getDefaultRequestPolicy(..));
        UnityAdsModule.getDefaultRequestPolicy();
        NativeConfigurationKt$Dsl.setAdPolicy(UnityAdsModule.getDefaultRequestPolicy(..));
        UnityAdsModule.getDefaultRequestPolicy();
        NativeConfigurationKt$Dsl.setOtherPolicy(UnityAdsModule.getDefaultRequestPolicy(..));
        UnityAdsModule.getDefaultRequestPolicy();
        NativeConfigurationKt$Dsl.setOperativeEventPolicy(UnityAdsModule.getDefaultRequestPolicy(..));
        NativeConfigurationOuterClass$DiagnosticEventsConfiguration.newBuilder();
        DiagnosticEventsConfigurationKt$Dsl$Companion._create(NativeConfigurationOuterClass$DiagnosticEventsConfiguration.newBuilder(..));
        DiagnosticEventsConfigurationKt$Dsl.setEnabled(1);
        DiagnosticEventsConfigurationKt$Dsl.setMaxBatchSize(10);
        DiagnosticEventsConfigurationKt$Dsl.setMaxBatchIntervalMs(30000);
        DiagnosticEventsConfigurationKt$Dsl.setTtmEnabled(0);
        DiagnosticEventsConfigurationKt$Dsl._build();
        NativeConfigurationKt$Dsl.setDiagnosticEvents(DiagnosticEventsConfigurationKt$Dsl._build(..));
        NativeConfigurationKt$Dsl._build();
        return NativeConfigurationKt$Dsl._build(..);
    }

    public final ByteStringDataSource gatewayCacheDataStore(DataStore p0) {
        UnityAdsModule.provideByteStringDataSource(p0);
        return UnityAdsModule.provideByteStringDataSource(..);
    }

    public final DataStore gatewayDataStore(Context p0, CoroutineDispatcher p1) {
        UnityAdsModule.provideByteStringDataStore(p0, p1, "gateway_cache.pb");
        return UnityAdsModule.provideByteStringDataStore(..);
    }

    public final CoroutineScope getTokenCoroutineScope(ISDKDispatchers p0, CoroutineExceptionHandler p1, Job p2) {
        p0.getDefault();
        p2.plus(ISDKDispatchers.getDefault(..));
        new CoroutineName("get_token_scope");
        Job.plus(..).plus(new CoroutineName(..));
        CoroutineContext.plus(..).plus(p1);
        CoroutineScopeKt.CoroutineScope(CoroutineContext.plus(..));
        return CoroutineScopeKt.CoroutineScope(..);
    }

    public final DataStore glInfoDataStore(Context p0, CoroutineDispatcher p1, DataMigration p2) {
        new ByteStringSerializer();
        CollectionsKt.listOf(p2);
        SupervisorKt.SupervisorJob$default(0, 1, 0);
        p1.plus(SupervisorKt.SupervisorJob$default(..));
        CoroutineScopeKt.CoroutineScope(CoroutineDispatcher.plus(..));
        new UnityAdsModule$glInfoDataStore$1(p0);
        DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new ByteStringSerializer(..), 0, CollectionsKt.listOf(..), CoroutineScopeKt.CoroutineScope(..), new UnityAdsModule$glInfoDataStore$1(..), 2, 0);
        return DataStoreFactory.create$default(..);
    }

    public final ByteStringDataSource glInfoDataStore(DataStore p0) {
        UnityAdsModule.provideByteStringDataSource(p0);
        return UnityAdsModule.provideByteStringDataSource(..);
    }

    public final DataStore iapTransactionDataStore(Context p0, CoroutineDispatcher p1) {
        UnityAdsModule.provideByteStringDataStore(p0, p1, "iap_transaction.pb");
        return UnityAdsModule.provideByteStringDataStore(..);
    }

    public final ByteStringDataSource iapTransactionDataStore(DataStore p0) {
        UnityAdsModule.provideByteStringDataSource(p0);
        return UnityAdsModule.provideByteStringDataSource(..);
    }

    public final ByteStringDataSource idfiDataStore(DataStore p0) {
        UnityAdsModule.provideByteStringDataSource(p0);
        return UnityAdsModule.provideByteStringDataSource(..);
    }

    public final CoroutineScope initCoroutineScope(ISDKDispatchers p0, CoroutineExceptionHandler p1, Job p2) {
        p0.getDefault();
        p2.plus(ISDKDispatchers.getDefault(..));
        new CoroutineName("init_scope");
        Job.plus(..).plus(new CoroutineName(..));
        CoroutineContext.plus(..).plus(p1);
        CoroutineScopeKt.CoroutineScope(CoroutineContext.plus(..));
        return CoroutineScopeKt.CoroutineScope(..);
    }

    public final CoroutineDispatcher ioDispatcher() {
        Dispatchers.getIO();
        return Dispatchers.getIO(..);
    }

    public final CoroutineScope loadCoroutineScope(ISDKDispatchers p0, CoroutineExceptionHandler p1, Job p2) {
        p0.getDefault();
        p2.plus(ISDKDispatchers.getDefault(..));
        new CoroutineName("load_scope");
        Job.plus(..).plus(new CoroutineName(..));
        CoroutineContext.plus(..).plus(p1);
        CoroutineScopeKt.CoroutineScope(CoroutineContext.plus(..));
        return CoroutineScopeKt.CoroutineScope(..);
    }

    public final CoroutineDispatcher mainDispatcher() {
        Dispatchers.getMain();
        return Dispatchers.getMain(..);
    }

    public final MeasurementsService measurementService(Context p0, ISDKDispatchers p1) {
        SharedInstances.INSTANCE.getWebViewEventSender();
        new MeasurementsService(p0, p1, SharedInstances.getWebViewEventSender(..));
        return new MeasurementsService(..);
    }

    public final DataStore nativeConfigurationDataStore(Context p0, CoroutineDispatcher p1) {
        UnityAdsModule.provideByteStringDataStore(p0, p1, "native_configuration.pb");
        return UnityAdsModule.provideByteStringDataStore(..);
    }

    public final ByteStringDataSource nativeConfigurationDataStore(DataStore p0) {
        UnityAdsModule.provideByteStringDataSource(p0);
        return UnityAdsModule.provideByteStringDataSource(..);
    }

    public final CoroutineScope omidCoroutineScope(ISDKDispatchers p0, CoroutineExceptionHandler p1, Job p2) {
        p0.getDefault();
        p2.plus(ISDKDispatchers.getDefault(..));
        new CoroutineName("omid_scope");
        Job.plus(..).plus(new CoroutineName(..));
        CoroutineContext.plus(..).plus(p1);
        CoroutineScopeKt.CoroutineScope(CoroutineContext.plus(..));
        return CoroutineScopeKt.CoroutineScope(..);
    }

    public final DataStore privacyDataStore(Context p0, CoroutineDispatcher p1) {
        UnityAdsModule.provideByteStringDataStore(p0, p1, "privacy.pb");
        return UnityAdsModule.provideByteStringDataStore(..);
    }

    public final ByteStringDataSource privacyDataStore(DataStore p0) {
        UnityAdsModule.provideByteStringDataSource(p0);
        return UnityAdsModule.provideByteStringDataSource(..);
    }

    public final DataStore privacyFsmDataStore(Context p0, CoroutineDispatcher p1) {
        UnityAdsModule.provideByteStringDataStore(p0, p1, "privacy_fsm.pb");
        return UnityAdsModule.provideByteStringDataStore(..);
    }

    public final ByteStringDataSource privacyFsmDataStore(DataStore p0) {
        UnityAdsModule.provideByteStringDataSource(p0);
        return UnityAdsModule.provideByteStringDataSource(..);
    }

    public final JsonStorage privateJsonStorage() {
        UnityAdsModule.provideJsonStorage(StorageManager$StorageType.PRIVATE);
        return UnityAdsModule.provideJsonStorage(..);
    }

    public final Job publicApiJob(DiagnosticEventRepository p0) {
        JobKt.Job$default(0, 1, 0);
        new UnityAdsModule$publicApiJob$1$1(p0);
        JobKt.Job$default(..).invokeOnCompletion(new UnityAdsModule$publicApiJob$1$1(..));
        return JobKt.Job$default(..);
    }

    public final JsonStorage publicJsonStorage() {
        UnityAdsModule.provideJsonStorage(StorageManager$StorageType.PUBLIC);
        return UnityAdsModule.provideJsonStorage(..);
    }

    public final ISDKDispatchers sdkDispatchers() {
        new SDKDispatchers();
        return new SDKDispatchers(..);
    }

    public final SDKMetricsSender sdkMetrics() {
        SDKMetrics.getInstance();
        return SDKMetrics.getInstance(..);
    }

    public final CoroutineScope showCoroutineScope(ISDKDispatchers p0, CoroutineExceptionHandler p1, Job p2) {
        p0.getDefault();
        p2.plus(ISDKDispatchers.getDefault(..));
        new CoroutineName("show_scope");
        Job.plus(..).plus(new CoroutineName(..));
        CoroutineContext.plus(..).plus(p1);
        CoroutineScopeKt.CoroutineScope(CoroutineContext.plus(..));
        return CoroutineScopeKt.CoroutineScope(..);
    }

    public final TopicsService topicsService(Context p0, ISDKDispatchers p1) {
        SharedInstances.INSTANCE.getWebViewEventSender();
        new TopicsService(p0, p1, SharedInstances.getWebViewEventSender(..));
        return new TopicsService(..);
    }

    public final CoroutineScope transactionCoroutineScope(ISDKDispatchers p0, CoroutineExceptionHandler p1, Job p2) {
        p0.getDefault();
        p2.plus(ISDKDispatchers.getDefault(..));
        new CoroutineName("transaction_scope");
        Job.plus(..).plus(new CoroutineName(..));
        CoroutineContext.plus(..).plus(p1);
        CoroutineScopeKt.CoroutineScope(CoroutineContext.plus(..));
        return CoroutineScopeKt.CoroutineScope(..);
    }

    public final DataStore universalRequestDataStore(Context p0, CoroutineDispatcher p1) {
        new UniversalRequestStoreSerializer();
        SupervisorKt.SupervisorJob$default(0, 1, 0);
        p1.plus(SupervisorKt.SupervisorJob$default(..));
        CoroutineScopeKt.CoroutineScope(CoroutineDispatcher.plus(..));
        new UnityAdsModule$universalRequestDataStore$1(p0);
        DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new UniversalRequestStoreSerializer(..), 0, 0, CoroutineScopeKt.CoroutineScope(..), new UnityAdsModule$universalRequestDataStore$1(..), 4, 0);
        return DataStoreFactory.create$default(..);
    }

    public final VolumeChangeMonitor volumeChangeMonitor(VolumeChange p0) {
        SharedInstances.INSTANCE.getWebViewEventSender();
        new VolumeChangeMonitor(SharedInstances.getWebViewEventSender(..), p0);
        return new VolumeChangeMonitor(..);
    }

    public final DataStore webViewConfigurationDataStore(Context p0, CoroutineDispatcher p1) {
        new WebViewConfigurationStoreSerializer();
        SupervisorKt.SupervisorJob$default(0, 1, 0);
        p1.plus(SupervisorKt.SupervisorJob$default(..));
        CoroutineScopeKt.CoroutineScope(CoroutineDispatcher.plus(..));
        new UnityAdsModule$webViewConfigurationDataStore$1(p0);
        DataStoreFactory.create$default(DataStoreFactory.INSTANCE, new WebViewConfigurationStoreSerializer(..), 0, 0, CoroutineScopeKt.CoroutineScope(..), new UnityAdsModule$webViewConfigurationDataStore$1(..), 4, 0);
        return DataStoreFactory.create$default(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.IServiceComponent$DefaultImpls
// ============================================================
package com.unity3d.services.core.di;

public final class IServiceComponent$DefaultImpls {
    public static IServiceProvider getServiceProvider(IServiceComponent p0) {
        return ServiceProvider.INSTANCE;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.IServiceComponentKt$inject$1
// ============================================================
package com.unity3d.services.core.di;

public final class IServiceComponentKt$inject$1 extends Lambda {
    final String $named;
    final IServiceComponent $this_inject;

    public IServiceComponentKt$inject$1(IServiceComponent p0, String p1) {
        $this_inject = p0;
        $named = p1;
        new Lambda(0);
        return;
    }

    public final Object invoke() {
        $this_inject.getServiceProvider();
        IServiceProvider.getRegistry();
        Intrinsics.reifiedOperationMarker(4, "T");
        Reflection.getOrCreateKotlinClass(Object.class);
        IServiceProvider.getRegistry(..).getService($named, Reflection.getOrCreateKotlinClass(..));
        return IServicesRegistry.getService(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.IServicesRegistry$DefaultImpls
// ============================================================
package com.unity3d.services.core.di;

public final class IServicesRegistry$DefaultImpls {
    public static Object getService$default(IServicesRegistry p0, String p1, KClass p2, int p3, Object p4) {
        if (if-nez(p4)) goto L_d;
        if (if-eqz(p3)) goto L_8;
      L_8:
        p0.getService("", p2);
        return IServicesRegistry.getService(..);
      L_d:
        new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getService");
        throw new UnsupportedOperationException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1 extends Lambda {
    public static final ServiceProvider$initialize$1 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1();
        INSTANCE = new ServiceProvider$initialize$1(..);
        return;
    }

    ServiceProvider$initialize$1() {
        new Lambda(1);
        return;
    }

    public Object invoke(Object p0) {
        ServiceProvider$initialize$1.invoke(p0);
        return Unit.INSTANCE;
    }

    public final void invoke(ServicesRegistry p0) {
        new UnityAdsModule();
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$1.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$2(new UnityAdsModule(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("main_dispatcher", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$2(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$3(new UnityAdsModule(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("default_dispatcher", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$3(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$4(new UnityAdsModule(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("io_dispatcher", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$4(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$5(new UnityAdsModule(..));
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$5(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$6(new UnityAdsModule(..));
        Reflection.getOrCreateKotlinClass(SDKMetricsSender.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$6(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$7(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(CoroutineScope.class);
        new ServiceKey("init_scope", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$7(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$8(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(CoroutineScope.class);
        new ServiceKey("load_scope", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$8(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$9(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(CoroutineScope.class);
        new ServiceKey("show_scope", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$9(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$10(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(CoroutineScope.class);
        new ServiceKey("transaction_scope", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$10(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$11(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(CoroutineScope.class);
        new ServiceKey("get_token_scope", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$11(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$12(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(CoroutineScope.class);
        new ServiceKey("omid_scope", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$12(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$13(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(Job.class);
        new ServiceKey("public_job", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$13(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$14(p0);
        Reflection.getOrCreateKotlinClass(ByteStringDataSource.class);
        new ServiceKey("gateway_cache.pb", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$14(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$15(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(DataStore.class);
        new ServiceKey("privacy.pb", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$15(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$16(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(ByteStringDataSource.class);
        new ServiceKey("privacy.pb", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$16(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$17(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(DataStore.class);
        new ServiceKey("privacy_fsm.pb", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$17(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$18(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(ByteStringDataSource.class);
        new ServiceKey("privacy_fsm.pb", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$18(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$19(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(DataStore.class);
        new ServiceKey("native_configuration.pb", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$19(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$20(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(ByteStringDataSource.class);
        new ServiceKey("native_configuration.pb", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$20(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$21(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(DataStore.class);
        new ServiceKey("glinfo.pb", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$21(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$22(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(ByteStringDataSource.class);
        new ServiceKey("glinfo.pb", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$22(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$23(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(DataStore.class);
        new ServiceKey("universal_request.pb", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$23(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$24(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(DataStore.class);
        new ServiceKey("iap_transaction.pb", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$24(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$25(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(ByteStringDataSource.class);
        new ServiceKey("iap_transaction.pb", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$25(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$26(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(DataStore.class);
        new ServiceKey("webview_config.pb", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$26(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$27(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(AsyncTokenStorage.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$27(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$28(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(VolumeChangeMonitor.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$28(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$29(new UnityAdsModule(..));
        Reflection.getOrCreateKotlinClass(JsonStorage.class);
        new ServiceKey("PUBLIC", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$29(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$30(new UnityAdsModule(..));
        Reflection.getOrCreateKotlinClass(JsonStorage.class);
        new ServiceKey("PRIVATE", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$30(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$31(new UnityAdsModule(..));
        Reflection.getOrCreateKotlinClass(NativeConfigurationOuterClass$NativeConfiguration.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$31(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$32(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(MeasurementsService.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$32(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$33(new UnityAdsModule(..), p0);
        Reflection.getOrCreateKotlinClass(TopicsService.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$33(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(CronetEngineBuilderFactory.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$34.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$35(p0);
        Reflection.getOrCreateKotlinClass(HttpClientProvider.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$35(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$36(p0);
        Reflection.getOrCreateKotlinClass(HttpClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$36(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$37(p0);
        Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$37(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(TcfDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$38.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$39(p0);
        Reflection.getOrCreateKotlinClass(TcfRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$39(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$40(p0);
        Reflection.getOrCreateKotlinClass(GameServerIdReader.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$40(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$41(p0);
        Reflection.getOrCreateKotlinClass(StoreDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$41(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(AnalyticsDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$42.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$43(p0);
        Reflection.getOrCreateKotlinClass(DeveloperConsentDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$43(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$44(p0);
        Reflection.getOrCreateKotlinClass(DynamicDeviceInfoDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$44(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$45(p0);
        Reflection.getOrCreateKotlinClass(LegacyUserConsentDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$45(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(LifecycleDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$46.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$47(p0);
        Reflection.getOrCreateKotlinClass(CacheDataSource.class);
        new ServiceKey("local", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$47(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(CreateFile.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$48.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$49(p0);
        Reflection.getOrCreateKotlinClass(GetFileExtensionFromUrl.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$49(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(RemoveUrlQuery.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$50.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$51(p0);
        Reflection.getOrCreateKotlinClass(MediationDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$51(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$52(p0);
        Reflection.getOrCreateKotlinClass(PrivacyDeviceInfoDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$52(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$53(p0);
        Reflection.getOrCreateKotlinClass(CacheDataSource.class);
        new ServiceKey("remote", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$53(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$54(p0);
        Reflection.getOrCreateKotlinClass(StaticDeviceInfoDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$54(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$55(p0);
        Reflection.getOrCreateKotlinClass(DataMigration.class);
        new ServiceKey("glinfo", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$55(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$56(p0);
        Reflection.getOrCreateKotlinClass(UniversalRequestDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$56(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$57(p0);
        Reflection.getOrCreateKotlinClass(WebviewConfigurationDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$57(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(OmidManager.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$58.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(SDKPropertiesManager.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$59.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(StorageManager.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$60.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$61(p0);
        Reflection.getOrCreateKotlinClass(TransactionEventManager.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$61(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(AdRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$62.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$63(p0);
        Reflection.getOrCreateKotlinClass(CacheRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$63(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(GetCacheDirectory.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$64.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$65(p0);
        Reflection.getOrCreateKotlinClass(CampaignRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$65(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$66(p0);
        Reflection.getOrCreateKotlinClass(DeveloperConsentRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$66(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$67(p0);
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$67(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$68(p0);
        Reflection.getOrCreateKotlinClass(DiagnosticEventRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$68(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$69(p0);
        Reflection.getOrCreateKotlinClass(LegacyUserConsentRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$69(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$70(p0);
        Reflection.getOrCreateKotlinClass(MediationRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$70(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$71(p0);
        Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$71(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$72(p0);
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$72(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(TransactionEventRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$73.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(OperativeEventRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$74.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$75(p0);
        Reflection.getOrCreateKotlinClass(ExecuteAdViewerRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$75(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(GetByteStringId.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$76.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$77(p0);
        Reflection.getOrCreateKotlinClass(HandleOpenUrl.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$77(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$78(p0);
        Reflection.getOrCreateKotlinClass(Refresh.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$78(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$79(p0);
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$79(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$80(p0);
        Reflection.getOrCreateKotlinClass(SendWebViewClientErrorDiagnostics.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$80(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$81(p0);
        Reflection.getOrCreateKotlinClass(Show.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$81(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$82(p0);
        Reflection.getOrCreateKotlinClass(CacheFile.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$82(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$83(p0);
        Reflection.getOrCreateKotlinClass(ClearCache.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$83(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$84(p0);
        Reflection.getOrCreateKotlinClass(GetAdObject.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$84(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$85(p0);
        Reflection.getOrCreateKotlinClass(GetHeaderBiddingToken.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$85(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$86(p0);
        Reflection.getOrCreateKotlinClass(BuildHeaderBiddingToken.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$86(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$87(p0);
        Reflection.getOrCreateKotlinClass(GetInitializationData.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$87(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$88(p0);
        Reflection.getOrCreateKotlinClass(GetInitializationRequestPayload.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$88(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$89(p0);
        Reflection.getOrCreateKotlinClass(GetInitializationState.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$89(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$90(p0);
        Reflection.getOrCreateKotlinClass(GetIsFileCache.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$90(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$91(p0);
        Reflection.getOrCreateKotlinClass(SetInitializationState.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$91(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$92(p0);
        Reflection.getOrCreateKotlinClass(GetRequestPolicy.class);
        new ServiceKey("ad_req", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$92(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$93(p0);
        Reflection.getOrCreateKotlinClass(GetAdDataRefreshRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$93(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$94(p0);
        Reflection.getOrCreateKotlinClass(GetAdPlayerConfigRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$94(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$95(p0);
        Reflection.getOrCreateKotlinClass(AndroidGetAdPlayerContext.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$95(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$96(p0);
        Reflection.getOrCreateKotlinClass(GetAdRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$96(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$97(p0);
        Reflection.getOrCreateKotlinClass(GetClientInfo.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$97(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$98(p0);
        Reflection.getOrCreateKotlinClass(GetInitializationCompletedRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$98(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$99(p0);
        Reflection.getOrCreateKotlinClass(GetInitializationRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$99(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$100(p0);
        Reflection.getOrCreateKotlinClass(GetLimitedSessionToken.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$100(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$101(p0);
        Reflection.getOrCreateKotlinClass(GetOpenGLRendererInfo.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$101(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(GetSharedDataTimestamps.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$102.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$103(p0);
        Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$103(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$104(p0);
        Reflection.getOrCreateKotlinClass(GetUniversalRequestSharedData.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$104(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$105(p0);
        Reflection.getOrCreateKotlinClass(GetCachedAsset.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$105(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$106(p0);
        Reflection.getOrCreateKotlinClass(GetWebViewBridgeUseCase.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$106(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$107(p0);
        Reflection.getOrCreateKotlinClass(GetRequestPolicy.class);
        new ServiceKey("init_req", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$107(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$108(p0);
        Reflection.getOrCreateKotlinClass(GetLatestWebViewConfiguration.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$108(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$109(p0);
        Reflection.getOrCreateKotlinClass(GetRequestPolicy.class);
        new ServiceKey("op_event_req", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$109(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$110(p0);
        Reflection.getOrCreateKotlinClass(GetRequestPolicy.class);
        new ServiceKey("other_req", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$110(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$111(p0);
        Reflection.getOrCreateKotlinClass(GetPrivacyUpdateRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$111(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$112(p0);
        Reflection.getOrCreateKotlinClass(HandleGatewayInitializationResponse.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$112(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$113(p0);
        Reflection.getOrCreateKotlinClass(HandleGatewayUniversalResponse.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$113(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$114(p0);
        Reflection.getOrCreateKotlinClass(InitializeBoldSDK.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$114(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$115(p0);
        Reflection.getOrCreateKotlinClass(LegacyShowUseCase.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$115(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$116(p0);
        Reflection.getOrCreateKotlinClass(SendPrivacyUpdateRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$116(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$117(p0);
        Reflection.getOrCreateKotlinClass(TriggerInitializationCompletedRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$117(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$118(p0);
        Reflection.getOrCreateKotlinClass(TriggerInitializeListener.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$118(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$119(p0);
        Reflection.getOrCreateKotlinClass(DiagnosticEventObserver.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$119(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$120(p0);
        Reflection.getOrCreateKotlinClass(EventObservers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$120(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$121(p0);
        Reflection.getOrCreateKotlinClass(GetTransactionData.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$121(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$122(p0);
        Reflection.getOrCreateKotlinClass(GetTransactionRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$122(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(GetDiagnosticEventBatchRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$123.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$124(p0);
        Reflection.getOrCreateKotlinClass(GetDiagnosticEventRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$124(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$125(p0);
        Reflection.getOrCreateKotlinClass(GetOperativeEventApi.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$125(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$126(p0);
        Reflection.getOrCreateKotlinClass(GetOperativeEventRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$126(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(HandleGatewayEventResponse.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$127.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$128(p0);
        Reflection.getOrCreateKotlinClass(OperativeEventObserver.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$128(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$129(p0);
        Reflection.getOrCreateKotlinClass(TransactionEventObserver.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$129(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$130(p0);
        Reflection.getOrCreateKotlinClass(UniversalRequestEventSender.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$130(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$131(p0);
        Reflection.getOrCreateKotlinClass(OmFinishSession.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$131(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$132(p0);
        Reflection.getOrCreateKotlinClass(OmImpressionOccurred.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$132(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$133(p0);
        Reflection.getOrCreateKotlinClass(AndroidOmInteraction.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$133(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$134(p0);
        Reflection.getOrCreateKotlinClass(GetOmData.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$134(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$135(p0);
        Reflection.getOrCreateKotlinClass(IsOMActivated.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$135(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$136(p0);
        Reflection.getOrCreateKotlinClass(InitializeOMSDK.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$136(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(FlattenerRulesUseCase.class);
        new ServiceKey("dev_consent_privacy_rules", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$137.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(FlattenerRulesUseCase.class);
        new ServiceKey("legacy_privacy_rules", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$138.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$139(p0);
        Reflection.getOrCreateKotlinClass(BackgroundWorker.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$139(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$140(p0);
        Reflection.getOrCreateKotlinClass(DiagnosticEventRequestWorkModifier.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$140(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$141(p0);
        Reflection.getOrCreateKotlinClass(GatewayClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$141(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$142(p0);
        Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class);
        new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$142(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(TokenStorage.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$143.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(VolumeChange.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$144.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$145(p0);
        Reflection.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$145(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$146(p0);
        Reflection.getOrCreateKotlinClass(InitializeSDK.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$146(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$147(p0);
        Reflection.getOrCreateKotlinClass(InitializeStateComplete.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$147(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$148(p0);
        Reflection.getOrCreateKotlinClass(InitializeStateConfig.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$148(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$149(p0);
        Reflection.getOrCreateKotlinClass(InitializeStateConfigWithLoader.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$149(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$150(p0);
        Reflection.getOrCreateKotlinClass(InitializeStateCreate.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$150(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$151(p0);
        Reflection.getOrCreateKotlinClass(InitializeStateError.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$151(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$152(p0);
        Reflection.getOrCreateKotlinClass(InitializeStateLoadCache.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$152(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$153(p0);
        Reflection.getOrCreateKotlinClass(InitializeStateLoadWeb.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$153(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$154(p0);
        Reflection.getOrCreateKotlinClass(InitializeStateReset.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$154(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$155(p0);
        Reflection.getOrCreateKotlinClass(StoreMonitor.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$155(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$156(p0);
        Reflection.getOrCreateKotlinClass(StoreWebViewEventSender.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$156(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(StoreExceptionHandler.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$157.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$158(p0);
        Reflection.getOrCreateKotlinClass(StoreEventListenerFactory.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$158(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        Reflection.getOrCreateKotlinClass(ConfigurationReader.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$159.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$160(p0);
        Reflection.getOrCreateKotlinClass(AndroidAttribution.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$160(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$161(p0);
        Reflection.getOrCreateKotlinClass(AdPlayerScope.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$161(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$162(p0);
        Reflection.getOrCreateKotlinClass(AndroidWebViewClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$162(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$163(p0);
        Reflection.getOrCreateKotlinClass(AndroidGetWebViewContainerUseCase.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$163(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$164(p0);
        Reflection.getOrCreateKotlinClass(Load.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$164(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$165(p0);
        Reflection.getOrCreateKotlinClass(AwaitInitialization.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$165(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$166(p0);
        Reflection.getOrCreateKotlinClass(GetAsyncHeaderBiddingToken.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$166(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$167(p0);
        Reflection.getOrCreateKotlinClass(GetAdPlayer.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$167(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$168(p0);
        Reflection.getOrCreateKotlinClass(HandleGatewayAdResponse.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$168(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        Reflection.getOrCreateKotlinClass(HandleInvocationsFromAdViewer.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(ServiceProvider$initialize$1$169.INSTANCE);
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$170(p0);
        Reflection.getOrCreateKotlinClass(LegacyLoadUseCase.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$170(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$171(p0);
        Reflection.getOrCreateKotlinClass(InitializeStateNetworkError.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$171(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        new ServiceProvider$initialize$1$172(p0);
        Reflection.getOrCreateKotlinClass(GetAdAssetLoader.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$172(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$173(p0);
        Reflection.getOrCreateKotlinClass(GetWebViewCacheAssetLoader.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(new ServiceProvider$initialize$1$173(..));
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        new ServiceProvider$initialize$1$174(p0);
        Reflection.getOrCreateKotlinClass(CoroutineTimer.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        ServiceFactoryKt.factoryOf(new ServiceProvider$initialize$1$174(..));
        p0.updateService(new ServiceKey(..), ServiceFactoryKt.factoryOf(..));
        Reflection.getOrCreateKotlinClass(IEventSender.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        LazyKt.lazy(ServiceProvider$initialize$1$175.INSTANCE);
        p0.updateService(new ServiceKey(..), LazyKt.lazy(..));
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$1
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$1 extends Lambda {
    public static final ServiceProvider$initialize$1$1 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$1();
        INSTANCE = new ServiceProvider$initialize$1$1(..);
        return;
    }

    ServiceProvider$initialize$1$1() {
        new Lambda(0);
        return;
    }

    public final Context invoke() {
        ClientProperties.getApplicationContext();
        return ClientProperties.getApplicationContext(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$1.invoke();
        return ServiceProvider$initialize$1$1.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$10
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$10 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$10(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$10.invoke();
        return ServiceProvider$initialize$1$10.invoke(..);
    }

    public final CoroutineScope invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class);
        new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(Job.class);
        new ServiceKey("public_job", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.transactionCoroutineScope(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.transactionCoroutineScope(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$100
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$100 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$100(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetLimitedSessionToken invoke() {
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(MediationRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetLimitedSessionToken(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidGetLimitedSessionToken(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$100.invoke();
        return ServiceProvider$initialize$1$100.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$101
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$101 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$101(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetOpenGLRendererInfo invoke() {
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetOpenGLRendererInfo(ServicesRegistry.resolveService(..));
        return new AndroidGetOpenGLRendererInfo(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$101.invoke();
        return ServiceProvider$initialize$1$101.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$102
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$102 extends Lambda {
    public static final ServiceProvider$initialize$1$102 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$102();
        INSTANCE = new ServiceProvider$initialize$1$102(..);
        return;
    }

    ServiceProvider$initialize$1$102() {
        new Lambda(0);
        return;
    }

    public final GetSharedDataTimestamps invoke() {
        new AndroidGetSharedDataTimestamps();
        return new AndroidGetSharedDataTimestamps(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$102.invoke();
        return ServiceProvider$initialize$1$102.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$103
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$103 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$103(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetUniversalRequestForPayLoad invoke() {
        Reflection.getOrCreateKotlinClass(GetUniversalRequestSharedData.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetUniversalRequestForPayLoad(ServicesRegistry.resolveService(..));
        return new AndroidGetUniversalRequestForPayLoad(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$103.invoke();
        return ServiceProvider$initialize$1$103.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$104
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$104 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$104(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetUniversalRequestSharedData invoke() {
        Reflection.getOrCreateKotlinClass(GetSharedDataTimestamps.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetLimitedSessionToken.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DeveloperConsentRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetUniversalRequestSharedData(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidGetUniversalRequestSharedData;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$104.invoke();
        return ServiceProvider$initialize$1$104.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$105
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$105 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$105(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetCachedAsset invoke() {
        Reflection.getOrCreateKotlinClass(CacheRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new GetCachedAsset(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new GetCachedAsset(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$105.invoke();
        return ServiceProvider$initialize$1$105.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$106
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$106 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$106(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetWebViewBridgeUseCase invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("default_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonGetWebViewBridgeUseCase(ServicesRegistry.resolveService(..));
        return new CommonGetWebViewBridgeUseCase(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$106.invoke();
        return ServiceProvider$initialize$1$106.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$107
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$107 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$107(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetRequestPolicy invoke() {
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new GetInitRequestPolicy(ServicesRegistry.resolveService(..));
        return new GetInitRequestPolicy(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$107.invoke();
        return ServiceProvider$initialize$1$107.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$108
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$108 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$108(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetLatestWebViewConfiguration invoke() {
        Reflection.getOrCreateKotlinClass(WebviewConfigurationDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new GetLatestWebViewConfiguration(ServicesRegistry.resolveService(..));
        return new GetLatestWebViewConfiguration(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$108.invoke();
        return ServiceProvider$initialize$1$108.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$109
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$109 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$109(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetRequestPolicy invoke() {
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new GetOperativeEventRequestPolicy(ServicesRegistry.resolveService(..));
        return new GetOperativeEventRequestPolicy(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$109.invoke();
        return ServiceProvider$initialize$1$109.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$11
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$11 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$11(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$11.invoke();
        return ServiceProvider$initialize$1$11.invoke(..);
    }

    public final CoroutineScope invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class);
        new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(Job.class);
        new ServiceKey("public_job", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.getTokenCoroutineScope(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.getTokenCoroutineScope(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$110
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$110 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$110(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetRequestPolicy invoke() {
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new GetOtherRequestPolicy(ServicesRegistry.resolveService(..));
        return new GetOtherRequestPolicy(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$110.invoke();
        return ServiceProvider$initialize$1$110.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$111
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$111 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$111(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetPrivacyUpdateRequest invoke() {
        Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new GetPrivacyUpdateRequest(ServicesRegistry.resolveService(..));
        return new GetPrivacyUpdateRequest(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$111.invoke();
        return ServiceProvider$initialize$1$111.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$112
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$112 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$112(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final HandleGatewayInitializationResponse invoke() {
        Reflection.getOrCreateKotlinClass(TransactionEventManager.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(TriggerInitializationCompletedRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineScope.class);
        new ServiceKey("init_scope", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidHandleGatewayInitializationResponse(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidHandleGatewayInitializationResponse(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$112.invoke();
        return ServiceProvider$initialize$1$112.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$113
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$113 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$113(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final HandleGatewayUniversalResponse invoke() {
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidHandleGatewayUniversalResponse(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidHandleGatewayUniversalResponse(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$113.invoke();
        return ServiceProvider$initialize$1$113.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$114
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$114 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$114(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final InitializeBoldSDK invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("default_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(InitializeOMSDK.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetInitializationRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetRequestPolicy.class);
        new ServiceKey("init_req", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(ClearCache.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(HandleGatewayInitializationResponse.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GatewayClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(EventObservers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(TriggerInitializeListener.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DiagnosticEventRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(StorageManager.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(ConfigurationReader.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SDKPropertiesManager.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidInitializeBoldSDK(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidInitializeBoldSDK;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$114.invoke();
        return ServiceProvider$initialize$1$114.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$115
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$115 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$115(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final LegacyShowUseCase invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("main_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(Show.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(AdRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetOperativeEventApi.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetInitializationState.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new LegacyShowUseCase(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new LegacyShowUseCase;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$115.invoke();
        return ServiceProvider$initialize$1$115.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$116
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$116 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$116(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final SendPrivacyUpdateRequest invoke() {
        Reflection.getOrCreateKotlinClass(GetPrivacyUpdateRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetRequestPolicy.class);
        new ServiceKey("other_req", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GatewayClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new SendPrivacyUpdateRequest(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new SendPrivacyUpdateRequest(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$116.invoke();
        return ServiceProvider$initialize$1$116.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$117
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$117 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$117(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final TriggerInitializationCompletedRequest invoke() {
        Reflection.getOrCreateKotlinClass(GetInitializationCompletedRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetRequestPolicy.class);
        new ServiceKey("init_req", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GatewayClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidTriggerInitializationCompletedRequest(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidTriggerInitializationCompletedRequest(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$117.invoke();
        return ServiceProvider$initialize$1$117.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$118
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$118 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$118(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final TriggerInitializeListener invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("main_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new TriggerInitializeListener(ServicesRegistry.resolveService(..));
        return new TriggerInitializeListener(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$118.invoke();
        return ServiceProvider$initialize$1$118.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$119
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$119 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$119(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final DiagnosticEventObserver invoke() {
        Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetDiagnosticEventBatchRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("default_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DiagnosticEventRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(UniversalRequestDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(BackgroundWorker.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new DiagnosticEventObserver(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new DiagnosticEventObserver;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$119.invoke();
        return ServiceProvider$initialize$1$119.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$12
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$12 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$12(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$12.invoke();
        return ServiceProvider$initialize$1$12.invoke(..);
    }

    public final CoroutineScope invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class);
        new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(Job.class);
        new ServiceKey("public_job", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.omidCoroutineScope(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.omidCoroutineScope(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$120
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$120 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$120(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final EventObservers invoke() {
        Reflection.getOrCreateKotlinClass(OperativeEventObserver.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DiagnosticEventObserver.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(TransactionEventObserver.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new EventObservers(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new EventObservers(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$120.invoke();
        return ServiceProvider$initialize$1$120.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$121
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$121 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$121(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetTransactionData invoke() {
        Reflection.getOrCreateKotlinClass(GetByteStringId.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetTransactionData(ServicesRegistry.resolveService(..));
        return new AndroidGetTransactionData(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$121.invoke();
        return ServiceProvider$initialize$1$121.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$122
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$122 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$122(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetTransactionRequest invoke() {
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonGetTransactionRequest(ServicesRegistry.resolveService(..));
        return new CommonGetTransactionRequest(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$122.invoke();
        return ServiceProvider$initialize$1$122.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$123
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$123 extends Lambda {
    public static final ServiceProvider$initialize$1$123 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$123();
        INSTANCE = new ServiceProvider$initialize$1$123(..);
        return;
    }

    ServiceProvider$initialize$1$123() {
        new Lambda(0);
        return;
    }

    public final GetDiagnosticEventBatchRequest invoke() {
        new GetDiagnosticEventBatchRequest();
        return new GetDiagnosticEventBatchRequest(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$123.invoke();
        return ServiceProvider$initialize$1$123.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$124
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$124 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$124(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetDiagnosticEventRequest invoke() {
        Reflection.getOrCreateKotlinClass(GetSharedDataTimestamps.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new GetDiagnosticEventRequest(ServicesRegistry.resolveService(..));
        return new GetDiagnosticEventRequest(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$124.invoke();
        return ServiceProvider$initialize$1$124.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$125
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$125 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$125(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetOperativeEventApi invoke() {
        Reflection.getOrCreateKotlinClass(OperativeEventRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetOperativeEventRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new GetOperativeEventApi(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new GetOperativeEventApi(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$125.invoke();
        return ServiceProvider$initialize$1$125.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$126
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$126 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$126(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetOperativeEventRequest invoke() {
        Reflection.getOrCreateKotlinClass(GetByteStringId.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CampaignRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new GetOperativeEventRequest(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new GetOperativeEventRequest(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$126.invoke();
        return ServiceProvider$initialize$1$126.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$127
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$127 extends Lambda {
    public static final ServiceProvider$initialize$1$127 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$127();
        INSTANCE = new ServiceProvider$initialize$1$127(..);
        return;
    }

    ServiceProvider$initialize$1$127() {
        new Lambda(0);
        return;
    }

    public final HandleGatewayEventResponse invoke() {
        new AndroidHandleGatewayEventResponse();
        return new AndroidHandleGatewayEventResponse(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$127.invoke();
        return ServiceProvider$initialize$1$127.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$128
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$128 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$128(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final OperativeEventObserver invoke() {
        Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("default_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(OperativeEventRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(UniversalRequestDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(BackgroundWorker.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new OperativeEventObserver(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new OperativeEventObserver;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$128.invoke();
        return ServiceProvider$initialize$1$128.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$129
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$129 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$129(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final TransactionEventObserver invoke() {
        Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("default_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(TransactionEventRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GatewayClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetRequestPolicy.class);
        new ServiceKey("other_req", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(ByteStringDataSource.class);
        new ServiceKey("iap_transaction.pb", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new TransactionEventObserver(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new TransactionEventObserver;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$129.invoke();
        return ServiceProvider$initialize$1$129.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$13
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$13 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$13(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$13.invoke();
        return ServiceProvider$initialize$1$13.invoke(..);
    }

    public final Job invoke() {
        Reflection.getOrCreateKotlinClass(DiagnosticEventRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.publicApiJob(ServicesRegistry.resolveService(..));
        return UnityAdsModule.publicApiJob(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$130
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$130 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$130(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final UniversalRequestEventSender invoke() {
        Reflection.getOrCreateKotlinClass(GatewayClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(HandleGatewayEventResponse.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new UniversalRequestEventSender(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new UniversalRequestEventSender(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$130.invoke();
        return ServiceProvider$initialize$1$130.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$131
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$131 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$131(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final OmFinishSession invoke() {
        Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidOmFinishSession(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidOmFinishSession(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$131.invoke();
        return ServiceProvider$initialize$1$131.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$132
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$132 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$132(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final OmImpressionOccurred invoke() {
        Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidOmImpressionOccurred(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidOmImpressionOccurred(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$132.invoke();
        return ServiceProvider$initialize$1$132.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$133
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$133 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$133(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final AndroidOmInteraction invoke() {
        Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidOmStartSession(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidOmStartSession(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$133.invoke();
        return ServiceProvider$initialize$1$133.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$134
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$134 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$134(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetOmData invoke() {
        Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonGetOmData(ServicesRegistry.resolveService(..));
        return new CommonGetOmData(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$134.invoke();
        return ServiceProvider$initialize$1$134.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$135
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$135 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$135(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final IsOMActivated invoke() {
        Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonIsOMActivated(ServicesRegistry.resolveService(..));
        return new CommonIsOMActivated(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$135.invoke();
        return ServiceProvider$initialize$1$135.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$136
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$136 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$136(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final InitializeOMSDK invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidInitializeOMSDK(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidInitializeOMSDK(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$136.invoke();
        return ServiceProvider$initialize$1$136.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$137
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$137 extends Lambda {
    public static final ServiceProvider$initialize$1$137 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$137();
        INSTANCE = new ServiceProvider$initialize$1$137(..);
        return;
    }

    ServiceProvider$initialize$1$137() {
        new Lambda(0);
        return;
    }

    public final FlattenerRulesUseCase invoke() {
        new DeveloperConsentFlattenerRulesUseCase();
        return new DeveloperConsentFlattenerRulesUseCase(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$137.invoke();
        return ServiceProvider$initialize$1$137.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$138
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$138 extends Lambda {
    public static final ServiceProvider$initialize$1$138 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$138();
        INSTANCE = new ServiceProvider$initialize$1$138(..);
        return;
    }

    ServiceProvider$initialize$1$138() {
        new Lambda(0);
        return;
    }

    public final FlattenerRulesUseCase invoke() {
        new LegacyUserConsentFlattenerRulesUseCase();
        return new LegacyUserConsentFlattenerRulesUseCase(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$138.invoke();
        return ServiceProvider$initialize$1$138.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$139
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$139 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$139(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final BackgroundWorker invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new BackgroundWorker(ServicesRegistry.resolveService(..));
        return new BackgroundWorker(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$139.invoke();
        return ServiceProvider$initialize$1$139.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$14
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$14 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$14(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final ByteStringDataSource invoke() {
        Reflection.getOrCreateKotlinClass(StorageManager.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidLegacyConfigStoreDataSource(ServicesRegistry.resolveService(..));
        return new AndroidLegacyConfigStoreDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$14.invoke();
        return ServiceProvider$initialize$1$14.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$140
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$140 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$140(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final DiagnosticEventRequestWorkModifier invoke() {
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(LifecycleDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new DiagnosticEventRequestWorkModifier(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new DiagnosticEventRequestWorkModifier(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$140.invoke();
        return ServiceProvider$initialize$1$140.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$141
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$141 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$141(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GatewayClient invoke() {
        Reflection.getOrCreateKotlinClass(HttpClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(HandleGatewayUniversalResponse.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonGatewayClient(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new CommonGatewayClient(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$141.invoke();
        return ServiceProvider$initialize$1$141.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$142
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$142 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$142(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$142.invoke();
        return ServiceProvider$initialize$1$142.invoke(..);
    }

    public final CoroutineExceptionHandler invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("io_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SDKMetricsSender.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new SDKErrorHandler(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new SDKErrorHandler(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$143
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$143 extends Lambda {
    public static final ServiceProvider$initialize$1$143 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$143();
        INSTANCE = new ServiceProvider$initialize$1$143(..);
        return;
    }

    ServiceProvider$initialize$1$143() {
        new Lambda(0);
        return;
    }

    public final TokenStorage invoke() {
        new InMemoryTokenStorage();
        return new InMemoryTokenStorage(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$143.invoke();
        return ServiceProvider$initialize$1$143.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$144
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$144 extends Lambda {
    public static final ServiceProvider$initialize$1$144 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$144();
        INSTANCE = new ServiceProvider$initialize$1$144(..);
        return;
    }

    ServiceProvider$initialize$1$144() {
        new Lambda(0);
        return;
    }

    public final VolumeChange invoke() {
        new VolumeChangeContentObserver();
        return new VolumeChangeContentObserver(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$144.invoke();
        return ServiceProvider$initialize$1$144.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$145
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$145 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$145(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final ConfigFileFromLocalStorage invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new ConfigFileFromLocalStorage(ServicesRegistry.resolveService(..));
        return new ConfigFileFromLocalStorage(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$145.invoke();
        return ServiceProvider$initialize$1$145.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$146
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$146 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$146(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final InitializeSDK invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(InitializeStateReset.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(InitializeStateError.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(InitializeStateConfig.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(InitializeStateCreate.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(InitializeStateLoadCache.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(InitializeStateLoadWeb.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(InitializeStateComplete.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new InitializeSDK(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new InitializeSDK;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$146.invoke();
        return ServiceProvider$initialize$1$146.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$147
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$147 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$147(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final InitializeStateComplete invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new InitializeStateComplete(ServicesRegistry.resolveService(..));
        return new InitializeStateComplete(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$147.invoke();
        return ServiceProvider$initialize$1$147.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$148
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$148 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$148(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final InitializeStateConfig invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(InitializeStateConfigWithLoader.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new InitializeStateConfig(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new InitializeStateConfig(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$148.invoke();
        return ServiceProvider$initialize$1$148.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$149
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$149 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$149(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final InitializeStateConfigWithLoader invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(InitializeStateNetworkError.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(TokenStorage.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SDKMetricsSender.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new InitializeStateConfigWithLoader(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new InitializeStateConfigWithLoader(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$149.invoke();
        return ServiceProvider$initialize$1$149.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$15
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$15 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$15(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final DataStore invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("io_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.privacyDataStore(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.privacyDataStore(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$15.invoke();
        return ServiceProvider$initialize$1$15.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$150
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$150 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$150(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final InitializeStateCreate invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new InitializeStateCreate(ServicesRegistry.resolveService(..));
        return new InitializeStateCreate(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$150.invoke();
        return ServiceProvider$initialize$1$150.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$151
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$151 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$151(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final InitializeStateError invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new InitializeStateError(ServicesRegistry.resolveService(..));
        return new InitializeStateError(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$151.invoke();
        return ServiceProvider$initialize$1$151.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$152
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$152 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$152(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final InitializeStateLoadCache invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new InitializeStateLoadCache(ServicesRegistry.resolveService(..));
        return new InitializeStateLoadCache(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$152.invoke();
        return ServiceProvider$initialize$1$152.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$153
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$153 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$153(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final InitializeStateLoadWeb invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(InitializeStateNetworkError.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(HttpClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new InitializeStateLoadWeb(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new InitializeStateLoadWeb(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$153.invoke();
        return ServiceProvider$initialize$1$153.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$154
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$154 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$154(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final InitializeStateReset invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new InitializeStateReset(ServicesRegistry.resolveService(..));
        return new InitializeStateReset(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$154.invoke();
        return ServiceProvider$initialize$1$154.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$155
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$155 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$155(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final StoreMonitor invoke() {
        Reflection.getOrCreateKotlinClass(StoreExceptionHandler.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new StoreMonitor(ServicesRegistry.resolveService(..));
        return new StoreMonitor(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$155.invoke();
        return ServiceProvider$initialize$1$155.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$156
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$156 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$156(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final StoreWebViewEventSender invoke() {
        Reflection.getOrCreateKotlinClass(IEventSender.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new StoreWebViewEventSender(ServicesRegistry.resolveService(..));
        return new StoreWebViewEventSender(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$156.invoke();
        return ServiceProvider$initialize$1$156.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$157
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$157 extends Lambda {
    public static final ServiceProvider$initialize$1$157 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$157();
        INSTANCE = new ServiceProvider$initialize$1$157(..);
        return;
    }

    ServiceProvider$initialize$1$157() {
        new Lambda(0);
        return;
    }

    public final StoreExceptionHandler invoke() {
        new GatewayStoreExceptionHandler();
        return new GatewayStoreExceptionHandler(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$157.invoke();
        return ServiceProvider$initialize$1$157.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$158
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$158 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$158(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final StoreEventListenerFactory invoke() {
        Reflection.getOrCreateKotlinClass(StoreWebViewEventSender.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new StoreEventListenerFactory(ServicesRegistry.resolveService(..));
        return new StoreEventListenerFactory(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$158.invoke();
        return ServiceProvider$initialize$1$158.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$159
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$159 extends Lambda {
    public static final ServiceProvider$initialize$1$159 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$159();
        INSTANCE = new ServiceProvider$initialize$1$159(..);
        return;
    }

    ServiceProvider$initialize$1$159() {
        new Lambda(0);
        return;
    }

    public final ConfigurationReader invoke() {
        new ConfigurationReader();
        return new ConfigurationReader(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$159.invoke();
        return ServiceProvider$initialize$1$159.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$16
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$16 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$16(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final ByteStringDataSource invoke() {
        Reflection.getOrCreateKotlinClass(DataStore.class);
        new ServiceKey("privacy.pb", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.privacyDataStore(ServicesRegistry.resolveService(..));
        return UnityAdsModule.privacyDataStore(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$16.invoke();
        return ServiceProvider$initialize$1$16.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$160
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$160 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$160(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final AndroidAttribution invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidAttribution(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidAttribution(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$160.invoke();
        return ServiceProvider$initialize$1$160.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$161
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$161 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$161(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final AdPlayerScope invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("default_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AdPlayerScope(ServicesRegistry.resolveService(..));
        return new AdPlayerScope(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$161.invoke();
        return ServiceProvider$initialize$1$161.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$162
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$162 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$162(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final AndroidWebViewClient invoke() {
        Reflection.getOrCreateKotlinClass(GetWebViewCacheAssetLoader.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetAdAssetLoader.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetCachedAsset.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidWebViewClient(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidWebViewClient(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$162.invoke();
        return ServiceProvider$initialize$1$162.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$163
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$163 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$163(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final AndroidGetWebViewContainerUseCase invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(AndroidWebViewClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendWebViewClientErrorDiagnostics.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("main_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("default_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetWebViewContainerUseCase(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidGetWebViewContainerUseCase;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$163.invoke();
        return ServiceProvider$initialize$1$163.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$164
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$164 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$164(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final Load invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("default_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetAdRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetAdPlayerConfigRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetRequestPolicy.class);
        new ServiceKey("ad_req", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(HandleGatewayAdResponse.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GatewayClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(AdRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidLoad(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidLoad;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$164.invoke();
        return ServiceProvider$initialize$1$164.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$165
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$165 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$165(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final AwaitInitialization invoke() {
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonAwaitInitialization(ServicesRegistry.resolveService(..));
        return new CommonAwaitInitialization(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$165.invoke();
        return ServiceProvider$initialize$1$165.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$166
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$166 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$166(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetAsyncHeaderBiddingToken invoke() {
        Reflection.getOrCreateKotlinClass(GetHeaderBiddingToken.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetInitializationState.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(AwaitInitialization.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonInitAwaitingGetHeaderBiddingToken(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new CommonInitAwaitingGetHeaderBiddingToken;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$166.invoke();
        return ServiceProvider$initialize$1$166.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$167
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$167 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$167(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetAdPlayer invoke() {
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(ExecuteAdViewerRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("default_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(AdPlayerScope.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(OpenMeasurementRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonGetAdPlayer(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new CommonGetAdPlayer;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$167.invoke();
        return ServiceProvider$initialize$1$167.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$168
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$168 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$168(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final HandleGatewayAdResponse invoke() {
        Reflection.getOrCreateKotlinClass(AdRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(AndroidGetWebViewContainerUseCase.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetWebViewBridgeUseCase.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(HandleInvocationsFromAdViewer.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CampaignRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetOperativeEventApi.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetLatestWebViewConfiguration.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(AdPlayerScope.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetAdPlayer.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidHandleGatewayAdResponse(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidHandleGatewayAdResponse;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$168.invoke();
        return ServiceProvider$initialize$1$168.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$169
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$169 extends Lambda {
    public static final ServiceProvider$initialize$1$169 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$169();
        INSTANCE = new ServiceProvider$initialize$1$169(..);
        return;
    }

    ServiceProvider$initialize$1$169() {
        new Lambda(0);
        return;
    }

    public final HandleInvocationsFromAdViewer invoke() {
        new HandleInvocationsFromAdViewer();
        return new HandleInvocationsFromAdViewer(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$169.invoke();
        return ServiceProvider$initialize$1$169.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$17
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$17 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$17(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final DataStore invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("io_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.privacyFsmDataStore(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.privacyFsmDataStore(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$17.invoke();
        return ServiceProvider$initialize$1$17.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$170
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$170 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$170(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final LegacyLoadUseCase invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("main_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(Load.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetInitializationState.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(AwaitInitialization.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(AdRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new LegacyLoadUseCase(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new LegacyLoadUseCase;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$170.invoke();
        return ServiceProvider$initialize$1$170.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$171
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$171 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$171(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final InitializeStateNetworkError invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new InitializeStateNetworkError(ServicesRegistry.resolveService(..));
        return new InitializeStateNetworkError(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$171.invoke();
        return ServiceProvider$initialize$1$171.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$172
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$172 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$172(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetAdAssetLoader invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        GetAdAssetLoaderKt.provideGetAdCacheAssetLoader(ServicesRegistry.resolveService(..));
        return GetAdAssetLoaderKt.provideGetAdCacheAssetLoader(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$172.invoke();
        return ServiceProvider$initialize$1$172.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$173
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$173 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$173(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetWebViewCacheAssetLoader invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        GetWebViewAssetLoaderKt.provideGetWebViewCacheAssetLoader(ServicesRegistry.resolveService(..));
        return GetWebViewAssetLoaderKt.provideGetWebViewCacheAssetLoader(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$173.invoke();
        return ServiceProvider$initialize$1$173.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$174
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$174 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$174(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final CoroutineTimer invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("default_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonCoroutineTimer(ServicesRegistry.resolveService(..));
        return new CommonCoroutineTimer(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$174.invoke();
        return ServiceProvider$initialize$1$174.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$175
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$175 extends Lambda {
    public static final ServiceProvider$initialize$1$175 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$175();
        INSTANCE = new ServiceProvider$initialize$1$175(..);
        return;
    }

    ServiceProvider$initialize$1$175() {
        new Lambda(0);
        return;
    }

    public final IEventSender invoke() {
        SharedInstances.INSTANCE.getWebViewEventSender();
        return SharedInstances.getWebViewEventSender(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$175.invoke();
        return ServiceProvider$initialize$1$175.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$18
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$18 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$18(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final ByteStringDataSource invoke() {
        Reflection.getOrCreateKotlinClass(DataStore.class);
        new ServiceKey("privacy_fsm.pb", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.privacyFsmDataStore(ServicesRegistry.resolveService(..));
        return UnityAdsModule.privacyFsmDataStore(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$18.invoke();
        return ServiceProvider$initialize$1$18.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$19
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$19 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$19(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final DataStore invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("io_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.nativeConfigurationDataStore(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.nativeConfigurationDataStore(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$19.invoke();
        return ServiceProvider$initialize$1$19.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$2
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$2 extends Lambda {
    final UnityAdsModule $moduleInstance;

    ServiceProvider$initialize$1$2(UnityAdsModule p0) {
        $moduleInstance = p0;
        new Lambda(0);
        return;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$2.invoke();
        return ServiceProvider$initialize$1$2.invoke(..);
    }

    public final CoroutineDispatcher invoke() {
        $moduleInstance.mainDispatcher();
        return UnityAdsModule.mainDispatcher(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$20
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$20 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$20(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final ByteStringDataSource invoke() {
        Reflection.getOrCreateKotlinClass(DataStore.class);
        new ServiceKey("native_configuration.pb", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.nativeConfigurationDataStore(ServicesRegistry.resolveService(..));
        return UnityAdsModule.nativeConfigurationDataStore(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$20.invoke();
        return ServiceProvider$initialize$1$20.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$21
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$21 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$21(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final DataStore invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("io_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DataMigration.class);
        new ServiceKey("glinfo", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.glInfoDataStore(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.glInfoDataStore(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$21.invoke();
        return ServiceProvider$initialize$1$21.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$22
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$22 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$22(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final ByteStringDataSource invoke() {
        Reflection.getOrCreateKotlinClass(DataStore.class);
        new ServiceKey("glinfo.pb", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.glInfoDataStore(ServicesRegistry.resolveService(..));
        return UnityAdsModule.glInfoDataStore(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$22.invoke();
        return ServiceProvider$initialize$1$22.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$23
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$23 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$23(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final DataStore invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("io_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.universalRequestDataStore(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.universalRequestDataStore(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$23.invoke();
        return ServiceProvider$initialize$1$23.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$24
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$24 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$24(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final DataStore invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("io_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.iapTransactionDataStore(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.iapTransactionDataStore(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$24.invoke();
        return ServiceProvider$initialize$1$24.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$25
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$25 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$25(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final ByteStringDataSource invoke() {
        Reflection.getOrCreateKotlinClass(DataStore.class);
        new ServiceKey("iap_transaction.pb", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.iapTransactionDataStore(ServicesRegistry.resolveService(..));
        return UnityAdsModule.iapTransactionDataStore(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$25.invoke();
        return ServiceProvider$initialize$1$25.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$26
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$26 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$26(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final DataStore invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("io_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.webViewConfigurationDataStore(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.webViewConfigurationDataStore(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$26.invoke();
        return ServiceProvider$initialize$1$26.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$27
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$27 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$27(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final AsyncTokenStorage invoke() {
        Reflection.getOrCreateKotlinClass(TokenStorage.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SDKMetricsSender.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.asyncTokenStorage(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.asyncTokenStorage(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$27.invoke();
        return ServiceProvider$initialize$1$27.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$28
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$28 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$28(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final VolumeChangeMonitor invoke() {
        Reflection.getOrCreateKotlinClass(VolumeChange.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.volumeChangeMonitor(ServicesRegistry.resolveService(..));
        return UnityAdsModule.volumeChangeMonitor(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$28.invoke();
        return ServiceProvider$initialize$1$28.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$29
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$29 extends Lambda {
    final UnityAdsModule $moduleInstance;

    ServiceProvider$initialize$1$29(UnityAdsModule p0) {
        $moduleInstance = p0;
        new Lambda(0);
        return;
    }

    public final JsonStorage invoke() {
        $moduleInstance.publicJsonStorage();
        return UnityAdsModule.publicJsonStorage(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$29.invoke();
        return ServiceProvider$initialize$1$29.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$3
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$3 extends Lambda {
    final UnityAdsModule $moduleInstance;

    ServiceProvider$initialize$1$3(UnityAdsModule p0) {
        $moduleInstance = p0;
        new Lambda(0);
        return;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$3.invoke();
        return ServiceProvider$initialize$1$3.invoke(..);
    }

    public final CoroutineDispatcher invoke() {
        $moduleInstance.defaultDispatcher();
        return UnityAdsModule.defaultDispatcher(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$30
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$30 extends Lambda {
    final UnityAdsModule $moduleInstance;

    ServiceProvider$initialize$1$30(UnityAdsModule p0) {
        $moduleInstance = p0;
        new Lambda(0);
        return;
    }

    public final JsonStorage invoke() {
        $moduleInstance.privateJsonStorage();
        return UnityAdsModule.privateJsonStorage(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$30.invoke();
        return ServiceProvider$initialize$1$30.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$31
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$31 extends Lambda {
    final UnityAdsModule $moduleInstance;

    ServiceProvider$initialize$1$31(UnityAdsModule p0) {
        $moduleInstance = p0;
        new Lambda(0);
        return;
    }

    public final NativeConfigurationOuterClass$NativeConfiguration invoke() {
        $moduleInstance.defaultNativeConfiguration();
        return UnityAdsModule.defaultNativeConfiguration(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$31.invoke();
        return ServiceProvider$initialize$1$31.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$32
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$32 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$32(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final MeasurementsService invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.measurementService(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.measurementService(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$32.invoke();
        return ServiceProvider$initialize$1$32.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$33
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$33 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$33(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public final TopicsService invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.topicsService(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.topicsService(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$33.invoke();
        return ServiceProvider$initialize$1$33.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$34
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$34 extends Lambda {
    public static final ServiceProvider$initialize$1$34 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$34();
        INSTANCE = new ServiceProvider$initialize$1$34(..);
        return;
    }

    ServiceProvider$initialize$1$34() {
        new Lambda(0);
        return;
    }

    public final CronetEngineBuilderFactory invoke() {
        new CronetEngineBuilderFactory();
        return new CronetEngineBuilderFactory(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$34.invoke();
        return ServiceProvider$initialize$1$34.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$35
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$35 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$35(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final HttpClientProvider invoke() {
        Reflection.getOrCreateKotlinClass(ConfigFileFromLocalStorage.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(AlternativeFlowReader.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CronetEngineBuilderFactory.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidHttpClientProvider(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidHttpClientProvider;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$35.invoke();
        return ServiceProvider$initialize$1$35.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$36
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$36 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$36(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final HttpClient invoke() {
        new ServiceProvider$initialize$1$36$1($this_registry, 0);
        BuildersKt.runBlocking$default(0, new ServiceProvider$initialize$1$36$1(..), 1, 0);
        return BuildersKt.runBlocking$default(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$36.invoke();
        return ServiceProvider$initialize$1$36.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$36$1
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$36$1 extends SuspendLambda {
    final ServicesRegistry $this_registry;
    int label;

    ServiceProvider$initialize$1$36$1(ServicesRegistry p0, Continuation p1) {
        $this_registry = p0;
        new SuspendLambda(2, p1);
        return;
    }

    public final Continuation create(Object p0, Continuation p1) {
        new ServiceProvider$initialize$1$36$1($this_registry, p1);
        return new ServiceProvider$initialize$1$36$1(..);
    }

    public Object invoke(Object p0, Object p1) {
        ServiceProvider$initialize$1$36$1.invoke(p0, p1);
        return ServiceProvider$initialize$1$36$1.invoke(..);
    }

    public final Object invoke(CoroutineScope p0, Continuation p1) {
        ServiceProvider$initialize$1$36$1.create(p0, p1);
        ServiceProvider$initialize$1$36$1.invokeSuspend(Unit.INSTANCE);
        return ServiceProvider$initialize$1$36$1.invokeSuspend(..);
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
        Reflection.getOrCreateKotlinClass(HttpClientProvider.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        label = 1;
        ServicesRegistry.resolveService(..).invoke(this);
        if (if-ne(HttpClientProvider.invoke(..), "call to 'resume' before 'invoke' with coroutine")) goto L_3b;
        return "call to 'resume' before 'invoke' with coroutine";
      L_3b:
        return HttpClientProvider.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$37
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$37 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$37(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final AlternativeFlowReader invoke() {
        Reflection.getOrCreateKotlinClass(ConfigurationReader.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AlternativeFlowReader(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AlternativeFlowReader(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$37.invoke();
        return ServiceProvider$initialize$1$37.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$38
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$38 extends Lambda {
    public static final ServiceProvider$initialize$1$38 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$38();
        INSTANCE = new ServiceProvider$initialize$1$38(..);
        return;
    }

    ServiceProvider$initialize$1$38() {
        new Lambda(0);
        return;
    }

    public final TcfDataSource invoke() {
        new AndroidTcfDataSource();
        return new AndroidTcfDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$38.invoke();
        return ServiceProvider$initialize$1$38.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$39
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$39 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$39(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final TcfRepository invoke() {
        Reflection.getOrCreateKotlinClass(TcfDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidTcfRepository(ServicesRegistry.resolveService(..));
        return new AndroidTcfRepository(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$39.invoke();
        return ServiceProvider$initialize$1$39.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$4
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$4 extends Lambda {
    final UnityAdsModule $moduleInstance;

    ServiceProvider$initialize$1$4(UnityAdsModule p0) {
        $moduleInstance = p0;
        new Lambda(0);
        return;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$4.invoke();
        return ServiceProvider$initialize$1$4.invoke(..);
    }

    public final CoroutineDispatcher invoke() {
        $moduleInstance.ioDispatcher();
        return UnityAdsModule.ioDispatcher(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$40
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$40 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$40(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GameServerIdReader invoke() {
        Reflection.getOrCreateKotlinClass(JsonStorage.class);
        new ServiceKey("PUBLIC", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new GameServerIdReader(ServicesRegistry.resolveService(..));
        return new GameServerIdReader(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$40.invoke();
        return ServiceProvider$initialize$1$40.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$41
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$41 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$41(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final StoreDataSource invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidStoreDataSource(ServicesRegistry.resolveService(..));
        return new AndroidStoreDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$41.invoke();
        return ServiceProvider$initialize$1$41.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$42
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$42 extends Lambda {
    public static final ServiceProvider$initialize$1$42 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$42();
        INSTANCE = new ServiceProvider$initialize$1$42(..);
        return;
    }

    ServiceProvider$initialize$1$42() {
        new Lambda(0);
        return;
    }

    public final AnalyticsDataSource invoke() {
        new AndroidAnalyticsDataSource();
        return new AndroidAnalyticsDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$42.invoke();
        return ServiceProvider$initialize$1$42.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$43
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$43 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$43(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final DeveloperConsentDataSource invoke() {
        Reflection.getOrCreateKotlinClass(FlattenerRulesUseCase.class);
        new ServiceKey("dev_consent_privacy_rules", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(JsonStorage.class);
        new ServiceKey("PUBLIC", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidDeveloperConsentDataSource(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidDeveloperConsentDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$43.invoke();
        return ServiceProvider$initialize$1$43.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$44
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$44 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$44(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final DynamicDeviceInfoDataSource invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(LifecycleDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidDynamicDeviceInfoDataSource(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidDynamicDeviceInfoDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$44.invoke();
        return ServiceProvider$initialize$1$44.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$45
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$45 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$45(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final LegacyUserConsentDataSource invoke() {
        Reflection.getOrCreateKotlinClass(FlattenerRulesUseCase.class);
        new ServiceKey("legacy_privacy_rules", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(JsonStorage.class);
        new ServiceKey("PRIVATE", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidLegacyUserConsentDataSource(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidLegacyUserConsentDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$45.invoke();
        return ServiceProvider$initialize$1$45.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$46
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$46 extends Lambda {
    public static final ServiceProvider$initialize$1$46 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$46();
        INSTANCE = new ServiceProvider$initialize$1$46(..);
        return;
    }

    ServiceProvider$initialize$1$46() {
        new Lambda(0);
        return;
    }

    public final LifecycleDataSource invoke() {
        new AndroidLifecycleDataSource();
        return new AndroidLifecycleDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$46.invoke();
        return ServiceProvider$initialize$1$46.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$47
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$47 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$47(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final CacheDataSource invoke() {
        Reflection.getOrCreateKotlinClass(CreateFile.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetFileExtensionFromUrl.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidLocalCacheDataSource(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidLocalCacheDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$47.invoke();
        return ServiceProvider$initialize$1$47.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$48
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$48 extends Lambda {
    public static final ServiceProvider$initialize$1$48 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$48();
        INSTANCE = new ServiceProvider$initialize$1$48(..);
        return;
    }

    ServiceProvider$initialize$1$48() {
        new Lambda(0);
        return;
    }

    public final CreateFile invoke() {
        new CommonCreateFile();
        return new CommonCreateFile(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$48.invoke();
        return ServiceProvider$initialize$1$48.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$49
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$49 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$49(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetFileExtensionFromUrl invoke() {
        Reflection.getOrCreateKotlinClass(RemoveUrlQuery.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonGetFileExtensionFromUrl(ServicesRegistry.resolveService(..));
        return new CommonGetFileExtensionFromUrl(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$49.invoke();
        return ServiceProvider$initialize$1$49.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$5
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$5 extends Lambda {
    final UnityAdsModule $moduleInstance;

    ServiceProvider$initialize$1$5(UnityAdsModule p0) {
        $moduleInstance = p0;
        new Lambda(0);
        return;
    }

    public final ISDKDispatchers invoke() {
        $moduleInstance.sdkDispatchers();
        return UnityAdsModule.sdkDispatchers(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$5.invoke();
        return ServiceProvider$initialize$1$5.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$50
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$50 extends Lambda {
    public static final ServiceProvider$initialize$1$50 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$50();
        INSTANCE = new ServiceProvider$initialize$1$50(..);
        return;
    }

    ServiceProvider$initialize$1$50() {
        new Lambda(0);
        return;
    }

    public final RemoveUrlQuery invoke() {
        new AndroidRemoveUrlQuery();
        return new AndroidRemoveUrlQuery(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$50.invoke();
        return ServiceProvider$initialize$1$50.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$51
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$51 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$51(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final MediationDataSource invoke() {
        Reflection.getOrCreateKotlinClass(JsonStorage.class);
        new ServiceKey("PUBLIC", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidMediationDataSource(ServicesRegistry.resolveService(..));
        return new AndroidMediationDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$51.invoke();
        return ServiceProvider$initialize$1$51.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$52
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$52 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$52(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final PrivacyDeviceInfoDataSource invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidPrivacyDeviceInfoDataSource(ServicesRegistry.resolveService(..));
        return new AndroidPrivacyDeviceInfoDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$52.invoke();
        return ServiceProvider$initialize$1$52.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$53
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$53 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$53(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final CacheDataSource invoke() {
        Reflection.getOrCreateKotlinClass(HttpClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidRemoteCacheDataSource(ServicesRegistry.resolveService(..));
        return new AndroidRemoteCacheDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$53.invoke();
        return ServiceProvider$initialize$1$53.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$54
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$54 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$54(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final StaticDeviceInfoDataSource invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(ByteStringDataSource.class);
        new ServiceKey("glinfo.pb", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(AnalyticsDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(StoreDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidStaticDeviceInfoDataSource(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidStaticDeviceInfoDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$54.invoke();
        return ServiceProvider$initialize$1$54.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$55
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$55 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$55(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final DataMigration invoke() {
        Reflection.getOrCreateKotlinClass(GetOpenGLRendererInfo.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new FetchGLInfoDataMigration(ServicesRegistry.resolveService(..));
        return new FetchGLInfoDataMigration(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$55.invoke();
        return ServiceProvider$initialize$1$55.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$56
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$56 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$56(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final UniversalRequestDataSource invoke() {
        Reflection.getOrCreateKotlinClass(DataStore.class);
        new ServiceKey("universal_request.pb", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new UniversalRequestDataSource(ServicesRegistry.resolveService(..));
        return new UniversalRequestDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$56.invoke();
        return ServiceProvider$initialize$1$56.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$57
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$57 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$57(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final WebviewConfigurationDataSource invoke() {
        Reflection.getOrCreateKotlinClass(DataStore.class);
        new ServiceKey("webview_config.pb", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new WebviewConfigurationDataSource(ServicesRegistry.resolveService(..));
        return new WebviewConfigurationDataSource(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$57.invoke();
        return ServiceProvider$initialize$1$57.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$58
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$58 extends Lambda {
    public static final ServiceProvider$initialize$1$58 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$58();
        INSTANCE = new ServiceProvider$initialize$1$58(..);
        return;
    }

    ServiceProvider$initialize$1$58() {
        new Lambda(0);
        return;
    }

    public final OmidManager invoke() {
        new AndroidOmidManager();
        return new AndroidOmidManager(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$58.invoke();
        return ServiceProvider$initialize$1$58.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$59
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$59 extends Lambda {
    public static final ServiceProvider$initialize$1$59 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$59();
        INSTANCE = new ServiceProvider$initialize$1$59(..);
        return;
    }

    ServiceProvider$initialize$1$59() {
        new Lambda(0);
        return;
    }

    public final SDKPropertiesManager invoke() {
        new AndroidSDKPropertiesManager();
        return new AndroidSDKPropertiesManager(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$59.invoke();
        return ServiceProvider$initialize$1$59.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$6
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$6 extends Lambda {
    final UnityAdsModule $moduleInstance;

    ServiceProvider$initialize$1$6(UnityAdsModule p0) {
        $moduleInstance = p0;
        new Lambda(0);
        return;
    }

    public final SDKMetricsSender invoke() {
        $moduleInstance.sdkMetrics();
        return UnityAdsModule.sdkMetrics(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$6.invoke();
        return ServiceProvider$initialize$1$6.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$60
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$60 extends Lambda {
    public static final ServiceProvider$initialize$1$60 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$60();
        INSTANCE = new ServiceProvider$initialize$1$60(..);
        return;
    }

    ServiceProvider$initialize$1$60() {
        new Lambda(0);
        return;
    }

    public final StorageManager invoke() {
        new AndroidStorageManager();
        return new AndroidStorageManager(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$60.invoke();
        return ServiceProvider$initialize$1$60.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$61
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$61 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$61(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final TransactionEventManager invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineScope.class);
        new ServiceKey("transaction_scope", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(StoreMonitor.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetTransactionData.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetTransactionRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(TransactionEventRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(ByteStringDataSource.class);
        new ServiceKey("iap_transaction.pb", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new TransactionEventManager(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new TransactionEventManager;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$61.invoke();
        return ServiceProvider$initialize$1$61.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$62
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$62 extends Lambda {
    public static final ServiceProvider$initialize$1$62 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$62();
        INSTANCE = new ServiceProvider$initialize$1$62(..);
        return;
    }

    ServiceProvider$initialize$1$62() {
        new Lambda(0);
        return;
    }

    public final AdRepository invoke() {
        new AndroidAdRepository();
        return new AndroidAdRepository(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$62.invoke();
        return ServiceProvider$initialize$1$62.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$63
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$63 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$63(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final CacheRepository invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("io_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetCacheDirectory.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CreateFile.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CacheDataSource.class);
        new ServiceKey("remote", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidCacheRepository(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidCacheRepository;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$63.invoke();
        return ServiceProvider$initialize$1$63.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$64
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$64 extends Lambda {
    public static final ServiceProvider$initialize$1$64 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$64();
        INSTANCE = new ServiceProvider$initialize$1$64(..);
        return;
    }

    ServiceProvider$initialize$1$64() {
        new Lambda(0);
        return;
    }

    public final GetCacheDirectory invoke() {
        new CommonGetCacheDirectory();
        return new CommonGetCacheDirectory(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$64.invoke();
        return ServiceProvider$initialize$1$64.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$65
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$65 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$65(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final CampaignRepository invoke() {
        Reflection.getOrCreateKotlinClass(GetSharedDataTimestamps.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidCampaignRepository(ServicesRegistry.resolveService(..));
        return new AndroidCampaignRepository(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$65.invoke();
        return ServiceProvider$initialize$1$65.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$66
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$66 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$66(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final DeveloperConsentRepository invoke() {
        Reflection.getOrCreateKotlinClass(DeveloperConsentDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidDeveloperConsentRepository(ServicesRegistry.resolveService(..));
        return new AndroidDeveloperConsentRepository(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$66.invoke();
        return ServiceProvider$initialize$1$66.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$67
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$67 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$67(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final DeviceInfoRepository invoke() {
        Reflection.getOrCreateKotlinClass(StaticDeviceInfoDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DynamicDeviceInfoDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(PrivacyDeviceInfoDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidDeviceInfoRepository(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidDeviceInfoRepository(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$67.invoke();
        return ServiceProvider$initialize$1$67.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$68
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$68 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$68(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final DiagnosticEventRepository invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineTimer.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetDiagnosticEventRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidDiagnosticEventRepository(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidDiagnosticEventRepository(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$68.invoke();
        return ServiceProvider$initialize$1$68.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$69
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$69 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$69(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final LegacyUserConsentRepository invoke() {
        Reflection.getOrCreateKotlinClass(LegacyUserConsentDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidLegacyUserConsentRepository(ServicesRegistry.resolveService(..));
        return new AndroidLegacyUserConsentRepository(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$69.invoke();
        return ServiceProvider$initialize$1$69.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$7
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$7 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$7(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$7.invoke();
        return ServiceProvider$initialize$1$7.invoke(..);
    }

    public final CoroutineScope invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class);
        new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(Job.class);
        new ServiceKey("public_job", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.initCoroutineScope(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.initCoroutineScope(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$70
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$70 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$70(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final MediationRepository invoke() {
        Reflection.getOrCreateKotlinClass(MediationDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidMediationRepository(ServicesRegistry.resolveService(..));
        return new AndroidMediationRepository(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$70.invoke();
        return ServiceProvider$initialize$1$70.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$71
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$71 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$71(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final OpenMeasurementRepository invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("main_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(OmidManager.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidOpenMeasurementRepository(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidOpenMeasurementRepository(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$71.invoke();
        return ServiceProvider$initialize$1$71.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$72
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$72 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$72(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final SessionRepository invoke() {
        Reflection.getOrCreateKotlinClass(ByteStringDataSource.class);
        new ServiceKey("gateway_cache.pb", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(ByteStringDataSource.class);
        new ServiceKey("privacy.pb", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(ByteStringDataSource.class);
        new ServiceKey("privacy_fsm.pb", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(ByteStringDataSource.class);
        new ServiceKey("native_configuration.pb", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(NativeConfigurationOuterClass$NativeConfiguration.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("io_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidSessionRepository(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidSessionRepository;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$72.invoke();
        return ServiceProvider$initialize$1$72.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$73
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$73 extends Lambda {
    public static final ServiceProvider$initialize$1$73 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$73();
        INSTANCE = new ServiceProvider$initialize$1$73(..);
        return;
    }

    ServiceProvider$initialize$1$73() {
        new Lambda(0);
        return;
    }

    public final TransactionEventRepository invoke() {
        new AndroidTransactionEventRepository();
        return new AndroidTransactionEventRepository(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$73.invoke();
        return ServiceProvider$initialize$1$73.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$74
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$74 extends Lambda {
    public static final ServiceProvider$initialize$1$74 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$74();
        INSTANCE = new ServiceProvider$initialize$1$74(..);
        return;
    }

    ServiceProvider$initialize$1$74() {
        new Lambda(0);
        return;
    }

    public final OperativeEventRepository invoke() {
        new OperativeEventRepository();
        return new OperativeEventRepository(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$74.invoke();
        return ServiceProvider$initialize$1$74.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$75
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$75 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$75(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final ExecuteAdViewerRequest invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("io_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(HttpClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidExecuteAdViewerRequest(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidExecuteAdViewerRequest(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$75.invoke();
        return ServiceProvider$initialize$1$75.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$76
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$76 extends Lambda {
    public static final ServiceProvider$initialize$1$76 INSTANCE;

    static <clinit>() {
        new ServiceProvider$initialize$1$76();
        INSTANCE = new ServiceProvider$initialize$1$76(..);
        return;
    }

    ServiceProvider$initialize$1$76() {
        new Lambda(0);
        return;
    }

    public final GetByteStringId invoke() {
        new AndroidGenerateByteStringId();
        return new AndroidGenerateByteStringId(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$76.invoke();
        return ServiceProvider$initialize$1$76.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$77
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$77 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$77(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final HandleOpenUrl invoke() {
        Reflection.getOrCreateKotlinClass(Context.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidHandleOpenUrl(ServicesRegistry.resolveService(..));
        return new AndroidHandleOpenUrl(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$77.invoke();
        return ServiceProvider$initialize$1$77.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$78
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$78 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$78(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final Refresh invoke() {
        Reflection.getOrCreateKotlinClass(CoroutineDispatcher.class);
        new ServiceKey("default_dispatcher", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetAdDataRefreshRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetRequestPolicy.class);
        new ServiceKey("ad_req", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GatewayClient.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidRefresh(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidRefresh(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$78.invoke();
        return ServiceProvider$initialize$1$78.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$79
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$79 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$79(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final SendDiagnosticEvent invoke() {
        Reflection.getOrCreateKotlinClass(DiagnosticEventRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetDiagnosticEventRequest.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidSendDiagnosticEvent(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidSendDiagnosticEvent(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$79.invoke();
        return ServiceProvider$initialize$1$79.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$8
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$8 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$8(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$8.invoke();
        return ServiceProvider$initialize$1$8.invoke(..);
    }

    public final CoroutineScope invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class);
        new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(Job.class);
        new ServiceKey("public_job", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.loadCoroutineScope(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.loadCoroutineScope(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$80
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$80 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$80(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final SendWebViewClientErrorDiagnostics invoke() {
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidSendWebViewClientErrorDiagnostics(ServicesRegistry.resolveService(..));
        return new AndroidSendWebViewClientErrorDiagnostics(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$80.invoke();
        return ServiceProvider$initialize$1$80.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$81
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$81 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$81(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final Show invoke() {
        Reflection.getOrCreateKotlinClass(AdRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GameServerIdReader.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidShow(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidShow(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$81.invoke();
        return ServiceProvider$initialize$1$81.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$82
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$82 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$82(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final CacheFile invoke() {
        Reflection.getOrCreateKotlinClass(CacheRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonCacheFile(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new CommonCacheFile(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$82.invoke();
        return ServiceProvider$initialize$1$82.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$83
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$83 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$83(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final ClearCache invoke() {
        Reflection.getOrCreateKotlinClass(CacheRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonClearCache(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new CommonClearCache(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$83.invoke();
        return ServiceProvider$initialize$1$83.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$84
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$84 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$84(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetAdObject invoke() {
        Reflection.getOrCreateKotlinClass(AdRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonGetAdObject(ServicesRegistry.resolveService(..));
        return new CommonGetAdObject(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$84.invoke();
        return ServiceProvider$initialize$1$84.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$85
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$85 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$85(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetHeaderBiddingToken invoke() {
        Reflection.getOrCreateKotlinClass(BuildHeaderBiddingToken.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonGetHeaderBiddingToken(ServicesRegistry.resolveService(..));
        return new CommonGetHeaderBiddingToken(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$85.invoke();
        return ServiceProvider$initialize$1$85.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$86
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$86 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$86(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final BuildHeaderBiddingToken invoke() {
        Reflection.getOrCreateKotlinClass(GetByteStringId.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetClientInfo.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetSharedDataTimestamps.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetLimitedSessionToken.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetInitializationData.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CampaignRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(TcfRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidBuildHeaderBiddingToken(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidBuildHeaderBiddingToken;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$86.invoke();
        return ServiceProvider$initialize$1$86.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$87
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$87 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$87(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetInitializationData invoke() {
        Reflection.getOrCreateKotlinClass(GetInitializationRequestPayload.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetUniversalRequestSharedData.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetInitializationData(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidGetInitializationData(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$87.invoke();
        return ServiceProvider$initialize$1$87.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$88
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$88 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$88(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetInitializationRequestPayload invoke() {
        Reflection.getOrCreateKotlinClass(GetClientInfo.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(LegacyUserConsentRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetInitializationRequestPayload(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidGetInitializationRequestPayload(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$88.invoke();
        return ServiceProvider$initialize$1$88.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$89
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$89 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$89(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetInitializationState invoke() {
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonGetInitializationState(ServicesRegistry.resolveService(..));
        return new CommonGetInitializationState(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$89.invoke();
        return ServiceProvider$initialize$1$89.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$9
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$9 extends Lambda {
    final UnityAdsModule $moduleInstance;
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$9(UnityAdsModule p0, ServicesRegistry p1) {
        $moduleInstance = p0;
        $this_registry = p1;
        new Lambda(0);
        return;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$9.invoke();
        return ServiceProvider$initialize$1$9.invoke(..);
    }

    public final CoroutineScope invoke() {
        Reflection.getOrCreateKotlinClass(ISDKDispatchers.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CoroutineExceptionHandler.class);
        new ServiceKey("sdk", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(Job.class);
        new ServiceKey("public_job", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        $moduleInstance.showCoroutineScope(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return UnityAdsModule.showCoroutineScope(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$90
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$90 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$90(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetIsFileCache invoke() {
        Reflection.getOrCreateKotlinClass(CacheRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SendDiagnosticEvent.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonGetIsFileCache(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new CommonGetIsFileCache(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$90.invoke();
        return ServiceProvider$initialize$1$90.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$91
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$91 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$91(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final SetInitializationState invoke() {
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new CommonSetInitializationState(ServicesRegistry.resolveService(..));
        return new CommonSetInitializationState(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$91.invoke();
        return ServiceProvider$initialize$1$91.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$92
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$92 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$92(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetRequestPolicy invoke() {
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetAdRequestPolicy(ServicesRegistry.resolveService(..));
        return new AndroidGetAdRequestPolicy(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$92.invoke();
        return ServiceProvider$initialize$1$92.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$93
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$93 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$93(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetAdDataRefreshRequest invoke() {
        Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CampaignRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetAdDataRefreshRequest(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidGetAdDataRefreshRequest(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$93.invoke();
        return ServiceProvider$initialize$1$93.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$94
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$94 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$94(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetAdPlayerConfigRequest invoke() {
        Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetAdPlayerConfigRequest(ServicesRegistry.resolveService(..));
        return new AndroidGetAdPlayerConfigRequest(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$94.invoke();
        return ServiceProvider$initialize$1$94.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$95
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$95 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$95(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final AndroidGetAdPlayerContext invoke() {
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetAdPlayerContext(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidGetAdPlayerContext(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$95.invoke();
        return ServiceProvider$initialize$1$95.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$96
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$96 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$96(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetAdRequest invoke() {
        Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(CampaignRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(WebviewConfigurationDataSource.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(TcfRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetAdRequest(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidGetAdRequest;
    }

    public Object invoke() {
        ServiceProvider$initialize$1$96.invoke();
        return ServiceProvider$initialize$1$96.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$97
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$97 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$97(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetClientInfo invoke() {
        Reflection.getOrCreateKotlinClass(SessionRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(MediationRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(OmidManager.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetClientInfo(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidGetClientInfo(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$97.invoke();
        return ServiceProvider$initialize$1$97.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$98
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$98 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$98(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetInitializationCompletedRequest invoke() {
        Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(DeviceInfoRepository.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetInitializationCompletedRequest(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidGetInitializationCompletedRequest(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$98.invoke();
        return ServiceProvider$initialize$1$98.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.ServiceProvider$initialize$1$99
// ============================================================
package com.unity3d.services.core.di;

final class ServiceProvider$initialize$1$99 extends Lambda {
    final ServicesRegistry $this_registry;

    ServiceProvider$initialize$1$99(ServicesRegistry p0) {
        $this_registry = p0;
        new Lambda(0);
        return;
    }

    public final GetInitializationRequest invoke() {
        Reflection.getOrCreateKotlinClass(GetInitializationRequestPayload.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        Reflection.getOrCreateKotlinClass(GetUniversalRequestForPayLoad.class);
        new ServiceKey("", Reflection.getOrCreateKotlinClass(..));
        $this_registry.resolveService(new ServiceKey(..));
        new AndroidGetInitializationRequest(ServicesRegistry.resolveService(..), ServicesRegistry.resolveService(..));
        return new AndroidGetInitializationRequest(..);
    }

    public Object invoke() {
        ServiceProvider$initialize$1$99.invoke();
        return ServiceProvider$initialize$1$99.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.UnityAdsModule$glInfoDataStore$1
// ============================================================
package com.unity3d.services.core.di;

final class UnityAdsModule$glInfoDataStore$1 extends Lambda {
    final Context $context;

    UnityAdsModule$glInfoDataStore$1(Context p0) {
        $context = p0;
        new Lambda(0);
        return;
    }

    public final File invoke() {
        ContextExtensionsKt.unityAdsDataStoreFile($context, "glinfo.pb");
        return ContextExtensionsKt.unityAdsDataStoreFile(..);
    }

    public Object invoke() {
        UnityAdsModule$glInfoDataStore$1.invoke();
        return UnityAdsModule$glInfoDataStore$1.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.UnityAdsModule$provideByteStringDataStore$1
// ============================================================
package com.unity3d.services.core.di;

final class UnityAdsModule$provideByteStringDataStore$1 extends Lambda {
    final Context $context;
    final String $dataStoreFile;

    UnityAdsModule$provideByteStringDataStore$1(Context p0, String p1) {
        $context = p0;
        $dataStoreFile = p1;
        new Lambda(0);
        return;
    }

    public final File invoke() {
        ContextExtensionsKt.unityAdsDataStoreFile($context, $dataStoreFile);
        return ContextExtensionsKt.unityAdsDataStoreFile(..);
    }

    public Object invoke() {
        UnityAdsModule$provideByteStringDataStore$1.invoke();
        return UnityAdsModule$provideByteStringDataStore$1.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.UnityAdsModule$publicApiJob$1$1
// ============================================================
package com.unity3d.services.core.di;

final class UnityAdsModule$publicApiJob$1$1 extends Lambda {
    final DiagnosticEventRepository $diagnosticEventRepository;

    UnityAdsModule$publicApiJob$1$1(DiagnosticEventRepository p0) {
        $diagnosticEventRepository = p0;
        new Lambda(1);
        return;
    }

    public Object invoke(Object p0) {
        UnityAdsModule$publicApiJob$1$1.invoke(p0);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable p0) {
        $diagnosticEventRepository.flush();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.UnityAdsModule$universalRequestDataStore$1
// ============================================================
package com.unity3d.services.core.di;

final class UnityAdsModule$universalRequestDataStore$1 extends Lambda {
    final Context $context;

    UnityAdsModule$universalRequestDataStore$1(Context p0) {
        $context = p0;
        new Lambda(0);
        return;
    }

    public final File invoke() {
        ContextExtensionsKt.unityAdsDataStoreFile($context, "universal_request.pb");
        return ContextExtensionsKt.unityAdsDataStoreFile(..);
    }

    public Object invoke() {
        UnityAdsModule$universalRequestDataStore$1.invoke();
        return UnityAdsModule$universalRequestDataStore$1.invoke(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.di.UnityAdsModule$webViewConfigurationDataStore$1
// ============================================================
package com.unity3d.services.core.di;

final class UnityAdsModule$webViewConfigurationDataStore$1 extends Lambda {
    final Context $context;

    UnityAdsModule$webViewConfigurationDataStore$1(Context p0) {
        $context = p0;
        new Lambda(0);
        return;
    }

    public final File invoke() {
        ContextExtensionsKt.unityAdsDataStoreFile($context, "webview_config.pb");
        return ContextExtensionsKt.unityAdsDataStoreFile(..);
    }

    public Object invoke() {
        UnityAdsModule$webViewConfigurationDataStore$1.invoke();
        return UnityAdsModule$webViewConfigurationDataStore$1.invoke(..);
    }

}

