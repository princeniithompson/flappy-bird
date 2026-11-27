// Package bundle: com.unity3d.ads.core.configuration (4 classes)

// ============================================================
// CLASS: com.unity3d.ads.core.configuration.AlternativeFlowReader
// ============================================================
package com.unity3d.ads.core.configuration;

public final class AlternativeFlowReader {
    private final ConfigurationReader configurationReader;
    private final MutableStateFlow isAlternativeFlowEnabled;
    private final MutableStateFlow isAlternativeFlowRead;
    private final SessionRepository sessionRepository;

    public AlternativeFlowReader(ConfigurationReader p0, SessionRepository p1) {
        new Object();
        configurationReader = p0;
        sessionRepository = p1;
        Boolean.valueOf(0);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        isAlternativeFlowRead = StateFlowKt.MutableStateFlow(..);
        StateFlowKt.MutableStateFlow(Boolean.valueOf(..));
        isAlternativeFlowEnabled = StateFlowKt.MutableStateFlow(..);
        return;
    }

    public final boolean invoke() {
        isAlternativeFlowRead.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        if (if-nez(Boolean.booleanValue(..))) goto L_45;
        configurationReader.getCurrentConfiguration();
        Configuration.getExperiments();
        Configuration.getExperiments(..).isBoldSdkNextSessionEnabled();
        if (if-nez(IExperiments.isBoldSdkNextSessionEnabled(..))) goto L_34;
        sessionRepository.getNativeConfiguration();
        NativeConfigurationOuterClass$NativeConfiguration.getFeatureFlags();
        NativeConfigurationOuterClass$FeatureFlags.getBoldSdkNextSessionEnabled();
        if (if-eqz(NativeConfigurationOuterClass$FeatureFlags.getBoldSdkNextSessionEnabled(..))) goto L_32;
      L_32:
      L_34:
      L_35:
        Boolean.valueOf(1);
        isAlternativeFlowEnabled.setValue(Boolean.valueOf(..));
        Boolean.valueOf(1);
        isAlternativeFlowRead.setValue(Boolean.valueOf(..));
      L_45:
        isAlternativeFlowEnabled.getValue();
        MutableStateFlow.getValue(..).booleanValue();
        return Boolean.booleanValue(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.configuration.GameServerIdReader
// ============================================================
package com.unity3d.ads.core.configuration;

public final class GameServerIdReader extends MetadataReader {
    public static final GameServerIdReader$Companion Companion = null;
    public static final String PLAYER_SERVER_ID_KEY = "player.server_id.value";

    static <clinit>() {
        new GameServerIdReader$Companion(0);
        Companion = new GameServerIdReader$Companion(..);
        return;
    }

    public GameServerIdReader(JsonStorage p0) {
        new MetadataReader(p0, "player.server_id.value");
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.configuration.MetadataReader
// ============================================================
package com.unity3d.ads.core.configuration;

public abstract class MetadataReader {
    private final JsonStorage jsonStorage;
    private final String key;

    public MetadataReader(JsonStorage p0, String p1) {
        new Object();
        jsonStorage = p0;
        key = p1;
        return;
    }

    public final JsonStorage getJsonStorage() {
        return jsonStorage;
    }

    public final String getKey() {
        return key;
    }

    public final Object read(Object p0) {
        MetadataReader.getJsonStorage();
        MetadataReader.getKey();
        MetadataReader.getJsonStorage(..).get(MetadataReader.getKey(..));
        if (if-eqz(JsonStorage.get(..))) goto L_1e;
        Intrinsics.reifiedOperationMarker(3, "T");
        if (if-eqz(3)) goto L_19;
      L_19:
      L_1a:
        if (if-nez(p0)) goto L_1d;
      L_1d:
      L_1e:
        return p0;
    }

    public final Object readAndDelete(Object p0) {
        MetadataReader.getJsonStorage();
        MetadataReader.getKey();
        MetadataReader.getJsonStorage(..).get(MetadataReader.getKey(..));
        if (if-eqz(JsonStorage.get(..))) goto L_23;
        Intrinsics.reifiedOperationMarker(3, "T");
        if (if-eqz(3)) goto L_1e;
      L_1e:
      L_1f:
        if (if-nez(p0)) goto L_22;
      L_22:
      L_23:
        MetadataReader.getJsonStorage();
        MetadataReader.getKey();
        MetadataReader.getJsonStorage(..).get(MetadataReader.getKey(..));
        if (if-eqz(JsonStorage.get(..))) goto L_3f;
        MetadataReader.getJsonStorage();
        MetadataReader.getKey();
        MetadataReader.getJsonStorage(..).delete(MetadataReader.getKey(..));
      L_3f:
        return p0;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.core.configuration.GameServerIdReader$Companion
// ============================================================
package com.unity3d.ads.core.configuration;

public final class GameServerIdReader$Companion {
    private GameServerIdReader$Companion() {
        new Object();
        return;
    }

    public GameServerIdReader$Companion(DefaultConstructorMarker p0) {
        new GameServerIdReader$Companion();
        return;
    }

}

