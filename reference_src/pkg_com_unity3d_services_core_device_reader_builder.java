// Package bundle: com.unity3d.services.core.device.reader.builder (3 classes)

// ============================================================
// CLASS: com.unity3d.services.core.device.reader.builder.DeviceInfoReaderBuilder
// ============================================================
package com.unity3d.services.core.device.reader.builder;

public class DeviceInfoReaderBuilder {
    private final ConfigurationReader _configurationReader;
    private final IGameSessionIdReader _gameSessionIdReader;
    private final PrivacyConfigStorage _privacyConfigStorage;

    public DeviceInfoReaderBuilder(ConfigurationReader p0, PrivacyConfigStorage p1, IGameSessionIdReader p2) {
        new Object();
        _configurationReader = p0;
        _privacyConfigStorage = p1;
        _gameSessionIdReader = p2;
        return;
    }

    private JsonFlattenerRules getTsiRequestStorageRules() {
        Arrays.asList(v1);
        Collections.singletonList("value");
        Arrays.asList(v3);
        new JsonFlattenerRules(Arrays.asList(..), Collections.singletonList(..), Arrays.asList(..));
        return new JsonFlattenerRules(..);
    }

    public IDeviceInfoReader build() {
        StorageManager.getStorage(StorageManager$StorageType.PRIVATE);
        StorageManager.getStorage(StorageManager$StorageType.PUBLIC);
        Arrays.asList(v4);
        new JsonStorageAggregator(Arrays.asList(..));
        new DeviceInfoReaderFilterProvider(StorageManager.getStorage(..));
        DeviceInfoReaderBuilder.buildWithRequestType(InitRequestType.TOKEN);
        new DeviceInfoReaderWithSessionId(DeviceInfoReaderBuilder.buildWithRequestType(..), Session.Default);
        new DeviceInfoReaderWithAuid(new DeviceInfoReaderWithSessionId(..));
        new DeviceInfoReaderExtended(new DeviceInfoReaderWithAuid(..));
        CachedLifecycle.getLifecycleListener();
        new DeviceInfoReaderWithLifecycle(new DeviceInfoReaderExtended(..), CachedLifecycle.getLifecycleListener(..));
        DeviceInfoReaderBuilder.getTsiRequestStorageRules();
        new DeviceInfoReaderWithStorageInfo(new DeviceInfoReaderWithLifecycle(..), DeviceInfoReaderBuilder.getTsiRequestStorageRules(..), 2);
        new PiiTrackingStatusReader(new JsonStorageAggregator(..));
        new PiiDataProvider();
        new DeviceInfoReaderWithPrivacy(new DeviceInfoReaderWithStorageInfo(..), _privacyConfigStorage, new PiiDataProvider(..), new PiiTrackingStatusReader(..));
        DeviceInfoReaderFilterProvider.getFilterList();
        new DeviceInfoReaderWithFilter(new DeviceInfoReaderWithPrivacy(..), DeviceInfoReaderFilterProvider.getFilterList(..));
        Utilities.getService(SDKMetricsSender.class);
        new DeviceInfoReaderWithMetrics(new DeviceInfoReaderWithFilter(..), Utilities.getService(..));
        return new DeviceInfoReaderWithMetrics(..);
    }

    protected IDeviceInfoReader buildWithRequestType(InitRequestType p0) {
        new MinimalDeviceInfoReader(_gameSessionIdReader);
        new DeviceInfoReaderWithRequestType(new MinimalDeviceInfoReader(..), p0);
        return new DeviceInfoReaderWithRequestType(..);
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.builder.DeviceInfoReaderBuilderWithExtras
// ============================================================
package com.unity3d.services.core.device.reader.builder;

public class DeviceInfoReaderBuilderWithExtras extends DeviceInfoReaderBuilder {
    private Map _extras;

    public DeviceInfoReaderBuilderWithExtras(ConfigurationReader p0, PrivacyConfigStorage p1, IGameSessionIdReader p2) {
        new DeviceInfoReaderBuilder(p0, p1, p2);
        return;
    }

    public IDeviceInfoReader build() {
        if (if-nez(_extras)) goto L_9;
        DeviceInfoReaderBuilder.build();
        return DeviceInfoReaderBuilder.build(..);
      L_9:
        DeviceInfoReaderBuilder.build();
        new DeviceInfoReaderWithExtras(DeviceInfoReaderBuilder.build(..), _extras);
        return new DeviceInfoReaderWithExtras(..);
    }

    public void setExtras(Map p0) {
        _extras = p0;
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.services.core.device.reader.builder.DeviceInfoReaderPrivacyBuilder
// ============================================================
package com.unity3d.services.core.device.reader.builder;

public class DeviceInfoReaderPrivacyBuilder extends DeviceInfoReaderBuilder {
    public DeviceInfoReaderPrivacyBuilder(ConfigurationReader p0, PrivacyConfigStorage p1, IGameSessionIdReader p2) {
        new DeviceInfoReaderBuilder(p0, p1, p2);
        return;
    }

    private JsonFlattenerRules getPrivacyRequestStorageRules() {
        Arrays.asList(v1);
        Collections.singletonList("value");
        Arrays.asList(v3);
        new JsonFlattenerRules(Arrays.asList(..), Collections.singletonList(..), Arrays.asList(..));
        return new JsonFlattenerRules(..);
    }

    public IDeviceInfoReader build() {
        StorageManager.getStorage(StorageManager$StorageType.PRIVATE);
        StorageManager.getStorage(StorageManager$StorageType.PUBLIC);
        Arrays.asList(v4);
        new JsonStorageAggregator(Arrays.asList(..));
        new NonBehavioralFlagReader(new JsonStorageAggregator(..));
        new DeviceInfoReaderFilterProvider(StorageManager.getStorage(..));
        DeviceInfoReaderPrivacyBuilder.buildWithRequestType(InitRequestType.PRIVACY);
        new DeviceInfoReaderWithBehavioralFlag(DeviceInfoReaderPrivacyBuilder.buildWithRequestType(..), new NonBehavioralFlagReader(..));
        DeviceInfoReaderPrivacyBuilder.getPrivacyRequestStorageRules();
        new DeviceInfoReaderWithStorageInfo(new DeviceInfoReaderWithBehavioralFlag(..), DeviceInfoReaderPrivacyBuilder.getPrivacyRequestStorageRules(..), 2);
        DeviceInfoReaderFilterProvider.getFilterList();
        new DeviceInfoReaderWithFilter(new DeviceInfoReaderWithStorageInfo(..), DeviceInfoReaderFilterProvider.getFilterList(..));
        return new DeviceInfoReaderWithFilter(..);
    }

}

