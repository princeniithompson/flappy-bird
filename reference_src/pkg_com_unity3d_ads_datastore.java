// Package bundle: com.unity3d.ads.datastore (25 classes)

// ============================================================
// CLASS: com.unity3d.ads.datastore.ByteStringStoreKt
// ============================================================
package com.unity3d.ads.datastore;

public final class ByteStringStoreKt {
    public static final ByteStringStoreKt INSTANCE;

    static <clinit>() {
        new ByteStringStoreKt();
        INSTANCE = new ByteStringStoreKt(..);
        return;
    }

    private ByteStringStoreKt() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.ByteStringStoreKtKt
// ============================================================
package com.unity3d.ads.datastore;

public final class ByteStringStoreKtKt {
    public static final ByteStringStoreOuterClass$ByteStringStore -initializebyteStringStore(Function1 p0) {
        ByteStringStoreOuterClass$ByteStringStore.newBuilder();
        ByteStringStoreKt$Dsl.Companion._create(ByteStringStoreOuterClass$ByteStringStore.newBuilder(..));
        p0.invoke(ByteStringStoreKt$Dsl$Companion._create(..));
        ByteStringStoreKt$Dsl._build();
        return ByteStringStoreKt$Dsl._build(..);
    }

    public static final ByteStringStoreOuterClass$ByteStringStore copy(ByteStringStoreOuterClass$ByteStringStore p0, Function1 p1) {
        p0.toBuilder();
        ByteStringStoreKt$Dsl.Companion._create(ByteStringStoreOuterClass$ByteStringStore.toBuilder(..));
        p1.invoke(ByteStringStoreKt$Dsl$Companion._create(..));
        ByteStringStoreKt$Dsl._build();
        return ByteStringStoreKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.ByteStringStoreOuterClass
// ============================================================
package com.unity3d.ads.datastore;

public final class ByteStringStoreOuterClass {
    static <clinit>() {
        return;
    }

    private ByteStringStoreOuterClass() {
        new Object();
        return;
    }

    public static void registerAllExtensions(ExtensionRegistryLite p0) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.UniversalRequestStoreKt
// ============================================================
package com.unity3d.ads.datastore;

public final class UniversalRequestStoreKt {
    public static final UniversalRequestStoreKt INSTANCE;

    static <clinit>() {
        new UniversalRequestStoreKt();
        INSTANCE = new UniversalRequestStoreKt(..);
        return;
    }

    private UniversalRequestStoreKt() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.UniversalRequestStoreKtKt
// ============================================================
package com.unity3d.ads.datastore;

public final class UniversalRequestStoreKtKt {
    public static final UniversalRequestStoreOuterClass$UniversalRequestStore -initializeuniversalRequestStore(Function1 p0) {
        UniversalRequestStoreOuterClass$UniversalRequestStore.newBuilder();
        UniversalRequestStoreKt$Dsl$Companion._create(UniversalRequestStoreOuterClass$UniversalRequestStore.newBuilder(..));
        p0.invoke(UniversalRequestStoreKt$Dsl$Companion._create(..));
        UniversalRequestStoreKt$Dsl._build();
        return UniversalRequestStoreKt$Dsl._build(..);
    }

    public static final UniversalRequestStoreOuterClass$UniversalRequestStore copy(UniversalRequestStoreOuterClass$UniversalRequestStore p0, Function1 p1) {
        p0.toBuilder();
        UniversalRequestStoreKt$Dsl$Companion._create(UniversalRequestStoreOuterClass$UniversalRequestStore.toBuilder(..));
        p1.invoke(UniversalRequestStoreKt$Dsl$Companion._create(..));
        UniversalRequestStoreKt$Dsl._build();
        return UniversalRequestStoreKt$Dsl._build(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.UniversalRequestStoreOuterClass
// ============================================================
package com.unity3d.ads.datastore;

public final class UniversalRequestStoreOuterClass {
    static <clinit>() {
        return;
    }

    private UniversalRequestStoreOuterClass() {
        new Object();
        return;
    }

    public static void registerAllExtensions(ExtensionRegistryLite p0) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.WebviewConfigurationStore
// ============================================================
package com.unity3d.ads.datastore;

public final class WebviewConfigurationStore {
    static <clinit>() {
        return;
    }

    private WebviewConfigurationStore() {
        new Object();
        return;
    }

    public static void registerAllExtensions(ExtensionRegistryLite p0) {
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.ByteStringStoreKt$Dsl
// ============================================================
package com.unity3d.ads.datastore;

public final class ByteStringStoreKt$Dsl {
    public static final ByteStringStoreKt$Dsl$Companion Companion;
    private final ByteStringStoreOuterClass$ByteStringStore$Builder _builder;

    static <clinit>() {
        new ByteStringStoreKt$Dsl$Companion(0);
        Companion = new ByteStringStoreKt$Dsl$Companion(..);
        return;
    }

    private ByteStringStoreKt$Dsl(ByteStringStoreOuterClass$ByteStringStore$Builder p0) {
        new Object();
        _builder = p0;
        return;
    }

    public ByteStringStoreKt$Dsl(ByteStringStoreOuterClass$ByteStringStore$Builder p0, DefaultConstructorMarker p1) {
        new ByteStringStoreKt$Dsl(p0);
        return;
    }

    public final ByteStringStoreOuterClass$ByteStringStore _build() {
        _builder.build();
        return ByteStringStoreOuterClass$ByteStringStore$Builder.build(..);
    }

    public final void clearData() {
        _builder.clearData();
        return;
    }

    public final ByteString getData() {
        _builder.getData();
        return ByteStringStoreOuterClass$ByteStringStore$Builder.getData(..);
    }

    public final void setData(ByteString p0) {
        _builder.setData(p0);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.ByteStringStoreKt$Dsl$Companion
// ============================================================
package com.unity3d.ads.datastore;

public final class ByteStringStoreKt$Dsl$Companion {
    private ByteStringStoreKt$Dsl$Companion() {
        new Object();
        return;
    }

    public ByteStringStoreKt$Dsl$Companion(DefaultConstructorMarker p0) {
        new ByteStringStoreKt$Dsl$Companion();
        return;
    }

    public final ByteStringStoreKt$Dsl _create(ByteStringStoreOuterClass$ByteStringStore$Builder p0) {
        new ByteStringStoreKt$Dsl(p0, 0);
        return new ByteStringStoreKt$Dsl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.ByteStringStoreOuterClass$1
// ============================================================
package com.unity3d.ads.datastore;

class ByteStringStoreOuterClass$1 {
    static final int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

    static <clinit>() {
        GeneratedMessageLite$MethodToInvoke.values();
        $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = GeneratedMessageLite$MethodToInvoke.values(..);
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.ByteStringStoreOuterClass$ByteStringStore
// ============================================================
package com.unity3d.ads.datastore;

public final class ByteStringStoreOuterClass$ByteStringStore extends GeneratedMessageLite {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final ByteStringStoreOuterClass$ByteStringStore DEFAULT_INSTANCE;
    private static Parser PARSER;
    private ByteString data_;

    static <clinit>() {
        new ByteStringStoreOuterClass$ByteStringStore();
        DEFAULT_INSTANCE = new ByteStringStoreOuterClass$ByteStringStore(..);
        GeneratedMessageLite.registerDefaultInstance(ByteStringStoreOuterClass$ByteStringStore.class, new ByteStringStoreOuterClass$ByteStringStore(..));
        return;
    }

    private ByteStringStoreOuterClass$ByteStringStore() {
        new GeneratedMessageLite();
        data_ = ByteString.EMPTY;
        return;
    }

    static ByteStringStoreOuterClass$ByteStringStore access$000() {
        return ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE;
    }

    static void access$100(ByteStringStoreOuterClass$ByteStringStore p0, ByteString p1) {
        p0.setData(p1);
        return;
    }

    static void access$200(ByteStringStoreOuterClass$ByteStringStore p0) {
        p0.clearData();
        return;
    }

    private void clearData() {
        ByteStringStoreOuterClass$ByteStringStore.getDefaultInstance();
        ByteStringStoreOuterClass$ByteStringStore.getData();
        data_ = ByteStringStoreOuterClass$ByteStringStore.getData(..);
        return;
    }

    public static ByteStringStoreOuterClass$ByteStringStore getDefaultInstance() {
        return ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE;
    }

    public static ByteStringStoreOuterClass$ByteStringStore$Builder newBuilder() {
        ByteStringStoreOuterClass$ByteStringStore.createBuilder();
        return ByteStringStoreOuterClass$ByteStringStore.createBuilder(..);
    }

    public static ByteStringStoreOuterClass$ByteStringStore$Builder newBuilder(ByteStringStoreOuterClass$ByteStringStore p0) {
        ByteStringStoreOuterClass$ByteStringStore.createBuilder(p0);
        return ByteStringStoreOuterClass$ByteStringStore.createBuilder(..);
    }

    public static ByteStringStoreOuterClass$ByteStringStore parseDelimitedFrom(InputStream p0) {
        ByteStringStoreOuterClass$ByteStringStore.parseDelimitedFrom(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE, p0);
        return ByteStringStoreOuterClass$ByteStringStore.parseDelimitedFrom(..);
    }

    public static ByteStringStoreOuterClass$ByteStringStore parseDelimitedFrom(InputStream p0, ExtensionRegistryLite p1) {
        ByteStringStoreOuterClass$ByteStringStore.parseDelimitedFrom(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE, p0, p1);
        return ByteStringStoreOuterClass$ByteStringStore.parseDelimitedFrom(..);
    }

    public static ByteStringStoreOuterClass$ByteStringStore parseFrom(ByteString p0) {
        GeneratedMessageLite.parseFrom(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static ByteStringStoreOuterClass$ByteStringStore parseFrom(ByteString p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static ByteStringStoreOuterClass$ByteStringStore parseFrom(CodedInputStream p0) {
        GeneratedMessageLite.parseFrom(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static ByteStringStoreOuterClass$ByteStringStore parseFrom(CodedInputStream p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static ByteStringStoreOuterClass$ByteStringStore parseFrom(InputStream p0) {
        GeneratedMessageLite.parseFrom(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static ByteStringStoreOuterClass$ByteStringStore parseFrom(InputStream p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static ByteStringStoreOuterClass$ByteStringStore parseFrom(ByteBuffer p0) {
        GeneratedMessageLite.parseFrom(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static ByteStringStoreOuterClass$ByteStringStore parseFrom(ByteBuffer p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static ByteStringStoreOuterClass$ByteStringStore parseFrom(byte[] p0) {
        GeneratedMessageLite.parseFrom(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static ByteStringStoreOuterClass$ByteStringStore parseFrom(byte[] p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static Parser parser() {
        ByteStringStoreOuterClass$ByteStringStore.getParserForType();
        return ByteStringStoreOuterClass$ByteStringStore.getParserForType(..);
    }

    private void setData(ByteString p0) {
        p0.getClass();
        data_ = p0;
        return;
    }

    protected final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke p0, Object p1, Object p2) {
        p0.ordinal();
        new UnsupportedOperationException();
        throw new UnsupportedOperationException(..);
        return 0;
        Byte.valueOf(1);
        return Byte.valueOf(..);
        if (if-nez(ByteStringStoreOuterClass$ByteStringStore.PARSER)) goto L_32;
        if (if-nez(ByteStringStoreOuterClass$ByteStringStore.PARSER)) goto L_2d;
        new GeneratedMessageLite$DefaultInstanceBasedParser(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE);
        PARSER = new GeneratedMessageLite$DefaultInstanceBasedParser(..);
      L_2d:
        throw new GeneratedMessageLite$DefaultInstanceBasedParser(..);
      L_32:
        return new GeneratedMessageLite$DefaultInstanceBasedParser(..);
        return ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE;
        ByteStringStoreOuterClass$ByteStringStore.newMessageInfo(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE, "������������\n", ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE);
        return ByteStringStoreOuterClass$ByteStringStore.newMessageInfo(..);
        new ByteStringStoreOuterClass$ByteStringStore$Builder(ByteStringStoreOuterClass$ByteStringStore.DEFAULT_INSTANCE);
        return new ByteStringStoreOuterClass$ByteStringStore$Builder(..);
        new ByteStringStoreOuterClass$ByteStringStore();
        return new ByteStringStoreOuterClass$ByteStringStore(..);
    }

    public ByteString getData() {
        return data_;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.ByteStringStoreOuterClass$ByteStringStore$Builder
// ============================================================
package com.unity3d.ads.datastore;

public final class ByteStringStoreOuterClass$ByteStringStore$Builder extends GeneratedMessageLite$Builder {
    private ByteStringStoreOuterClass$ByteStringStore$Builder() {
        ByteStringStoreOuterClass$ByteStringStore.access$000();
        new GeneratedMessageLite$Builder(ByteStringStoreOuterClass$ByteStringStore.access$000(..));
        return;
    }

    ByteStringStoreOuterClass$ByteStringStore$Builder(ByteStringStoreOuterClass$1 p0) {
        new ByteStringStoreOuterClass$ByteStringStore$Builder();
        return;
    }

    public ByteStringStoreOuterClass$ByteStringStore$Builder clearData() {
        ByteStringStoreOuterClass$ByteStringStore$Builder.copyOnWrite();
        ByteStringStoreOuterClass$ByteStringStore.access$200(instance);
        return this;
    }

    public ByteString getData() {
        instance.getData();
        return ByteStringStoreOuterClass$ByteStringStore.getData(..);
    }

    public ByteStringStoreOuterClass$ByteStringStore$Builder setData(ByteString p0) {
        ByteStringStoreOuterClass$ByteStringStore$Builder.copyOnWrite();
        ByteStringStoreOuterClass$ByteStringStore.access$100(instance, p0);
        return this;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.ByteStringStoreOuterClass$ByteStringStoreOrBuilder
// ============================================================
package com.unity3d.ads.datastore;

public abstract class ByteStringStoreOuterClass$ByteStringStoreOrBuilder {
    public abstract ByteString getData() {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.UniversalRequestStoreKt$Dsl
// ============================================================
package com.unity3d.ads.datastore;

public final class UniversalRequestStoreKt$Dsl {
    public static final UniversalRequestStoreKt$Dsl$Companion Companion;
    private final UniversalRequestStoreOuterClass$UniversalRequestStore$Builder _builder;

    static <clinit>() {
        new UniversalRequestStoreKt$Dsl$Companion(0);
        Companion = new UniversalRequestStoreKt$Dsl$Companion(..);
        return;
    }

    private UniversalRequestStoreKt$Dsl(UniversalRequestStoreOuterClass$UniversalRequestStore$Builder p0) {
        new Object();
        _builder = p0;
        return;
    }

    public UniversalRequestStoreKt$Dsl(UniversalRequestStoreOuterClass$UniversalRequestStore$Builder p0, DefaultConstructorMarker p1) {
        new UniversalRequestStoreKt$Dsl(p0);
        return;
    }

    public final UniversalRequestStoreOuterClass$UniversalRequestStore _build() {
        _builder.build();
        return UniversalRequestStoreOuterClass$UniversalRequestStore$Builder.build(..);
    }

    public final void clearUniversalRequestMap(DslMap p0) {
        _builder.clearUniversalRequestMap();
        return;
    }

    public final DslMap getUniversalRequestMapMap() {
        _builder.getUniversalRequestMapMap();
        new DslMap(UniversalRequestStoreOuterClass$UniversalRequestStore$Builder.getUniversalRequestMapMap(..));
        return new DslMap(..);
    }

    public final void putAllUniversalRequestMap(DslMap p0, Map p1) {
        _builder.putAllUniversalRequestMap(p1);
        return;
    }

    public final void putUniversalRequestMap(DslMap p0, String p1, ByteString p2) {
        _builder.putUniversalRequestMap(p1, p2);
        return;
    }

    public final void removeUniversalRequestMap(DslMap p0, String p1) {
        _builder.removeUniversalRequestMap(p1);
        return;
    }

    public final void setUniversalRequestMap(DslMap p0, String p1, ByteString p2) {
        UniversalRequestStoreKt$Dsl.putUniversalRequestMap(p0, p1, p2);
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.UniversalRequestStoreKt$Dsl$Companion
// ============================================================
package com.unity3d.ads.datastore;

public final class UniversalRequestStoreKt$Dsl$Companion {
    private UniversalRequestStoreKt$Dsl$Companion() {
        new Object();
        return;
    }

    public UniversalRequestStoreKt$Dsl$Companion(DefaultConstructorMarker p0) {
        new UniversalRequestStoreKt$Dsl$Companion();
        return;
    }

    public final UniversalRequestStoreKt$Dsl _create(UniversalRequestStoreOuterClass$UniversalRequestStore$Builder p0) {
        new UniversalRequestStoreKt$Dsl(p0, 0);
        return new UniversalRequestStoreKt$Dsl(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.UniversalRequestStoreKt$Dsl$UniversalRequestMapProxy
// ============================================================
package com.unity3d.ads.datastore;

public final class UniversalRequestStoreKt$Dsl$UniversalRequestMapProxy extends DslProxy {
    private UniversalRequestStoreKt$Dsl$UniversalRequestMapProxy() {
        new DslProxy();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.UniversalRequestStoreOuterClass$1
// ============================================================
package com.unity3d.ads.datastore;

class UniversalRequestStoreOuterClass$1 {
    static final int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

    static <clinit>() {
        GeneratedMessageLite$MethodToInvoke.values();
        $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = GeneratedMessageLite$MethodToInvoke.values(..);
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.UniversalRequestStoreOuterClass$UniversalRequestStore
// ============================================================
package com.unity3d.ads.datastore;

public final class UniversalRequestStoreOuterClass$UniversalRequestStore extends GeneratedMessageLite {
    private static final UniversalRequestStoreOuterClass$UniversalRequestStore DEFAULT_INSTANCE = null;
    private static Parser PARSER = null;
    public static final int UNIVERSAL_REQUEST_MAP_FIELD_NUMBER = 1;
    private MapFieldLite universalRequestMap_;

    static <clinit>() {
        new UniversalRequestStoreOuterClass$UniversalRequestStore();
        DEFAULT_INSTANCE = new UniversalRequestStoreOuterClass$UniversalRequestStore(..);
        GeneratedMessageLite.registerDefaultInstance(UniversalRequestStoreOuterClass$UniversalRequestStore.class, new UniversalRequestStoreOuterClass$UniversalRequestStore(..));
        return;
    }

    private UniversalRequestStoreOuterClass$UniversalRequestStore() {
        new GeneratedMessageLite();
        MapFieldLite.emptyMapField();
        universalRequestMap_ = MapFieldLite.emptyMapField(..);
        return;
    }

    static UniversalRequestStoreOuterClass$UniversalRequestStore access$000() {
        return UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE;
    }

    static Map access$100(UniversalRequestStoreOuterClass$UniversalRequestStore p0) {
        p0.getMutableUniversalRequestMapMap();
        return UniversalRequestStoreOuterClass$UniversalRequestStore.getMutableUniversalRequestMapMap(..);
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore getDefaultInstance() {
        return UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE;
    }

    private Map getMutableUniversalRequestMapMap() {
        UniversalRequestStoreOuterClass$UniversalRequestStore.internalGetMutableUniversalRequestMap();
        return UniversalRequestStoreOuterClass$UniversalRequestStore.internalGetMutableUniversalRequestMap(..);
    }

    private MapFieldLite internalGetMutableUniversalRequestMap() {
        universalRequestMap_.isMutable();
        if (if-nez(MapFieldLite.isMutable(..))) goto L_10;
        universalRequestMap_.mutableCopy();
        universalRequestMap_ = MapFieldLite.mutableCopy(..);
      L_10:
        return universalRequestMap_;
    }

    private MapFieldLite internalGetUniversalRequestMap() {
        return universalRequestMap_;
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore$Builder newBuilder() {
        UniversalRequestStoreOuterClass$UniversalRequestStore.createBuilder();
        return UniversalRequestStoreOuterClass$UniversalRequestStore.createBuilder(..);
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore$Builder newBuilder(UniversalRequestStoreOuterClass$UniversalRequestStore p0) {
        UniversalRequestStoreOuterClass$UniversalRequestStore.createBuilder(p0);
        return UniversalRequestStoreOuterClass$UniversalRequestStore.createBuilder(..);
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore parseDelimitedFrom(InputStream p0) {
        UniversalRequestStoreOuterClass$UniversalRequestStore.parseDelimitedFrom(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE, p0);
        return UniversalRequestStoreOuterClass$UniversalRequestStore.parseDelimitedFrom(..);
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore parseDelimitedFrom(InputStream p0, ExtensionRegistryLite p1) {
        UniversalRequestStoreOuterClass$UniversalRequestStore.parseDelimitedFrom(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE, p0, p1);
        return UniversalRequestStoreOuterClass$UniversalRequestStore.parseDelimitedFrom(..);
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore parseFrom(ByteString p0) {
        GeneratedMessageLite.parseFrom(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore parseFrom(ByteString p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore parseFrom(CodedInputStream p0) {
        GeneratedMessageLite.parseFrom(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore parseFrom(CodedInputStream p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore parseFrom(InputStream p0) {
        GeneratedMessageLite.parseFrom(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore parseFrom(InputStream p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore parseFrom(ByteBuffer p0) {
        GeneratedMessageLite.parseFrom(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore parseFrom(ByteBuffer p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore parseFrom(byte[] p0) {
        GeneratedMessageLite.parseFrom(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static UniversalRequestStoreOuterClass$UniversalRequestStore parseFrom(byte[] p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static Parser parser() {
        UniversalRequestStoreOuterClass$UniversalRequestStore.getParserForType();
        return UniversalRequestStoreOuterClass$UniversalRequestStore.getParserForType(..);
    }

    public boolean containsUniversalRequestMap(String p0) {
        p0.getClass();
        UniversalRequestStoreOuterClass$UniversalRequestStore.internalGetUniversalRequestMap();
        MapFieldLite.containsKey(p0);
        return MapFieldLite.containsKey(..);
    }

    protected final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke p0, Object p1, Object p2) {
        p0.ordinal();
        new UnsupportedOperationException();
        throw new UnsupportedOperationException(..);
        return 0;
        Byte.valueOf(1);
        return Byte.valueOf(..);
        if (if-nez(UniversalRequestStoreOuterClass$UniversalRequestStore.PARSER)) goto L_32;
        if (if-nez(UniversalRequestStoreOuterClass$UniversalRequestStore.PARSER)) goto L_2d;
        new GeneratedMessageLite$DefaultInstanceBasedParser(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE);
        PARSER = new GeneratedMessageLite$DefaultInstanceBasedParser(..);
      L_2d:
        throw new GeneratedMessageLite$DefaultInstanceBasedParser(..);
      L_32:
        return new GeneratedMessageLite$DefaultInstanceBasedParser(..);
        return UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE;
        UniversalRequestStoreOuterClass$UniversalRequestStore.newMessageInfo(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE, "����������2", 2);
        return UniversalRequestStoreOuterClass$UniversalRequestStore.newMessageInfo(..);
        new UniversalRequestStoreOuterClass$UniversalRequestStore$Builder(UniversalRequestStoreOuterClass$UniversalRequestStore.DEFAULT_INSTANCE);
        return new UniversalRequestStoreOuterClass$UniversalRequestStore$Builder(..);
        new UniversalRequestStoreOuterClass$UniversalRequestStore();
        return new UniversalRequestStoreOuterClass$UniversalRequestStore(..);
    }

    public Map getUniversalRequestMap() {
        UniversalRequestStoreOuterClass$UniversalRequestStore.getUniversalRequestMapMap();
        return UniversalRequestStoreOuterClass$UniversalRequestStore.getUniversalRequestMapMap(..);
    }

    public int getUniversalRequestMapCount() {
        UniversalRequestStoreOuterClass$UniversalRequestStore.internalGetUniversalRequestMap();
        MapFieldLite.size();
        return MapFieldLite.size(..);
    }

    public Map getUniversalRequestMapMap() {
        UniversalRequestStoreOuterClass$UniversalRequestStore.internalGetUniversalRequestMap();
        Collections.unmodifiableMap(UniversalRequestStoreOuterClass$UniversalRequestStore.internalGetUniversalRequestMap(..));
        return Collections.unmodifiableMap(..);
    }

    public ByteString getUniversalRequestMapOrDefault(String p0, ByteString p1) {
        p0.getClass();
        UniversalRequestStoreOuterClass$UniversalRequestStore.internalGetUniversalRequestMap();
        Map.containsKey(p0);
        if (if-eqz(Map.containsKey(..))) goto L_14;
        Map.get(p0);
      L_14:
        return Map.get(..);
    }

    public ByteString getUniversalRequestMapOrThrow(String p0) {
        p0.getClass();
        UniversalRequestStoreOuterClass$UniversalRequestStore.internalGetUniversalRequestMap();
        Map.containsKey(p0);
        if (if-eqz(Map.containsKey(..))) goto L_14;
        Map.get(p0);
        return Map.get(..);
      L_14:
        new IllegalArgumentException();
        throw new IllegalArgumentException(..);
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.UniversalRequestStoreOuterClass$UniversalRequestStore$Builder
// ============================================================
package com.unity3d.ads.datastore;

public final class UniversalRequestStoreOuterClass$UniversalRequestStore$Builder extends GeneratedMessageLite$Builder {
    private UniversalRequestStoreOuterClass$UniversalRequestStore$Builder() {
        UniversalRequestStoreOuterClass$UniversalRequestStore.access$000();
        new GeneratedMessageLite$Builder(UniversalRequestStoreOuterClass$UniversalRequestStore.access$000(..));
        return;
    }

    UniversalRequestStoreOuterClass$UniversalRequestStore$Builder(UniversalRequestStoreOuterClass$1 p0) {
        new UniversalRequestStoreOuterClass$UniversalRequestStore$Builder();
        return;
    }

    public UniversalRequestStoreOuterClass$UniversalRequestStore$Builder clearUniversalRequestMap() {
        UniversalRequestStoreOuterClass$UniversalRequestStore$Builder.copyOnWrite();
        UniversalRequestStoreOuterClass$UniversalRequestStore.access$100(instance);
        Map.clear();
        return this;
    }

    public boolean containsUniversalRequestMap(String p0) {
        p0.getClass();
        instance.getUniversalRequestMapMap();
        Map.containsKey(p0);
        return Map.containsKey(..);
    }

    public Map getUniversalRequestMap() {
        UniversalRequestStoreOuterClass$UniversalRequestStore$Builder.getUniversalRequestMapMap();
        return UniversalRequestStoreOuterClass$UniversalRequestStore$Builder.getUniversalRequestMapMap(..);
    }

    public int getUniversalRequestMapCount() {
        instance.getUniversalRequestMapMap();
        Map.size();
        return Map.size(..);
    }

    public Map getUniversalRequestMapMap() {
        instance.getUniversalRequestMapMap();
        Collections.unmodifiableMap(UniversalRequestStoreOuterClass$UniversalRequestStore.getUniversalRequestMapMap(..));
        return Collections.unmodifiableMap(..);
    }

    public ByteString getUniversalRequestMapOrDefault(String p0, ByteString p1) {
        p0.getClass();
        instance.getUniversalRequestMapMap();
        Map.containsKey(p0);
        if (if-eqz(Map.containsKey(..))) goto L_18;
        Map.get(p0);
      L_18:
        return Map.get(..);
    }

    public ByteString getUniversalRequestMapOrThrow(String p0) {
        p0.getClass();
        instance.getUniversalRequestMapMap();
        Map.containsKey(p0);
        if (if-eqz(Map.containsKey(..))) goto L_18;
        Map.get(p0);
        return Map.get(..);
      L_18:
        new IllegalArgumentException();
        throw new IllegalArgumentException(..);
    }

    public UniversalRequestStoreOuterClass$UniversalRequestStore$Builder putAllUniversalRequestMap(Map p0) {
        UniversalRequestStoreOuterClass$UniversalRequestStore$Builder.copyOnWrite();
        UniversalRequestStoreOuterClass$UniversalRequestStore.access$100(instance);
        Map.putAll(p0);
        return this;
    }

    public UniversalRequestStoreOuterClass$UniversalRequestStore$Builder putUniversalRequestMap(String p0, ByteString p1) {
        p0.getClass();
        p1.getClass();
        UniversalRequestStoreOuterClass$UniversalRequestStore$Builder.copyOnWrite();
        UniversalRequestStoreOuterClass$UniversalRequestStore.access$100(instance);
        Map.put(p0, p1);
        return this;
    }

    public UniversalRequestStoreOuterClass$UniversalRequestStore$Builder removeUniversalRequestMap(String p0) {
        p0.getClass();
        UniversalRequestStoreOuterClass$UniversalRequestStore$Builder.copyOnWrite();
        UniversalRequestStoreOuterClass$UniversalRequestStore.access$100(instance);
        Map.remove(p0);
        return this;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.UniversalRequestStoreOuterClass$UniversalRequestStore$UniversalRequestMapDefaultEntryHolder
// ============================================================
package com.unity3d.ads.datastore;

final class UniversalRequestStoreOuterClass$UniversalRequestStore$UniversalRequestMapDefaultEntryHolder {
    static final MapEntryLite defaultEntry;

    static <clinit>() {
        MapEntryLite.newDefaultInstance(WireFormat$FieldType.STRING, "", WireFormat$FieldType.BYTES, ByteString.EMPTY);
        defaultEntry = MapEntryLite.newDefaultInstance(..);
        return;
    }

    private UniversalRequestStoreOuterClass$UniversalRequestStore$UniversalRequestMapDefaultEntryHolder() {
        new Object();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.UniversalRequestStoreOuterClass$UniversalRequestStoreOrBuilder
// ============================================================
package com.unity3d.ads.datastore;

public abstract class UniversalRequestStoreOuterClass$UniversalRequestStoreOrBuilder {
    public abstract boolean containsUniversalRequestMap(String p0) {
        // native or abstract
    }

    public abstract Map getUniversalRequestMap() {
        // native or abstract
    }

    public abstract int getUniversalRequestMapCount() {
        // native or abstract
    }

    public abstract Map getUniversalRequestMapMap() {
        // native or abstract
    }

    public abstract ByteString getUniversalRequestMapOrDefault(String p0, ByteString p1) {
        // native or abstract
    }

    public abstract ByteString getUniversalRequestMapOrThrow(String p0) {
        // native or abstract
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.WebviewConfigurationStore$1
// ============================================================
package com.unity3d.ads.datastore;

class WebviewConfigurationStore$1 {
    static final int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

    static <clinit>() {
        GeneratedMessageLite$MethodToInvoke.values();
        $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = GeneratedMessageLite$MethodToInvoke.values(..);
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        GeneratedMessageLite$MethodToInvoke.ordinal();
        return;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.WebviewConfigurationStore$WebViewConfigurationStore
// ============================================================
package com.unity3d.ads.datastore;

public final class WebviewConfigurationStore$WebViewConfigurationStore extends GeneratedMessageLite {
    public static final int ADDITIONAL_FILES_FIELD_NUMBER = 3;
    private static final WebviewConfigurationStore$WebViewConfigurationStore DEFAULT_INSTANCE = null;
    public static final int ENTRY_POINT_FIELD_NUMBER = 2;
    private static Parser PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private Internal$ProtobufList additionalFiles_;
    private String entryPoint_;
    private int version_;

    static <clinit>() {
        new WebviewConfigurationStore$WebViewConfigurationStore();
        DEFAULT_INSTANCE = new WebviewConfigurationStore$WebViewConfigurationStore(..);
        GeneratedMessageLite.registerDefaultInstance(WebviewConfigurationStore$WebViewConfigurationStore.class, new WebviewConfigurationStore$WebViewConfigurationStore(..));
        return;
    }

    private WebviewConfigurationStore$WebViewConfigurationStore() {
        new GeneratedMessageLite();
        entryPoint_ = "";
        GeneratedMessageLite.emptyProtobufList();
        additionalFiles_ = GeneratedMessageLite.emptyProtobufList(..);
        return;
    }

    static WebviewConfigurationStore$WebViewConfigurationStore access$000() {
        return WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE;
    }

    static void access$100(WebviewConfigurationStore$WebViewConfigurationStore p0, int p1) {
        p0.setVersion(p1);
        return;
    }

    static void access$1000(WebviewConfigurationStore$WebViewConfigurationStore p0, ByteString p1) {
        p0.addAdditionalFilesBytes(p1);
        return;
    }

    static void access$200(WebviewConfigurationStore$WebViewConfigurationStore p0) {
        p0.clearVersion();
        return;
    }

    static void access$300(WebviewConfigurationStore$WebViewConfigurationStore p0, String p1) {
        p0.setEntryPoint(p1);
        return;
    }

    static void access$400(WebviewConfigurationStore$WebViewConfigurationStore p0) {
        p0.clearEntryPoint();
        return;
    }

    static void access$500(WebviewConfigurationStore$WebViewConfigurationStore p0, ByteString p1) {
        p0.setEntryPointBytes(p1);
        return;
    }

    static void access$600(WebviewConfigurationStore$WebViewConfigurationStore p0, int p1, String p2) {
        p0.setAdditionalFiles(p1, p2);
        return;
    }

    static void access$700(WebviewConfigurationStore$WebViewConfigurationStore p0, String p1) {
        p0.addAdditionalFiles(p1);
        return;
    }

    static void access$800(WebviewConfigurationStore$WebViewConfigurationStore p0, Iterable p1) {
        p0.addAllAdditionalFiles(p1);
        return;
    }

    static void access$900(WebviewConfigurationStore$WebViewConfigurationStore p0) {
        p0.clearAdditionalFiles();
        return;
    }

    private void addAdditionalFiles(String p0) {
        p0.getClass();
        WebviewConfigurationStore$WebViewConfigurationStore.ensureAdditionalFilesIsMutable();
        additionalFiles_.add(p0);
        return;
    }

    private void addAdditionalFilesBytes(ByteString p0) {
        WebviewConfigurationStore$WebViewConfigurationStore.checkByteStringIsUtf8(p0);
        WebviewConfigurationStore$WebViewConfigurationStore.ensureAdditionalFilesIsMutable();
        p0.toStringUtf8();
        additionalFiles_.add(ByteString.toStringUtf8(..));
        return;
    }

    private void addAllAdditionalFiles(Iterable p0) {
        WebviewConfigurationStore$WebViewConfigurationStore.ensureAdditionalFilesIsMutable();
        AbstractMessageLite.addAll(p0, additionalFiles_);
        return;
    }

    private void clearAdditionalFiles() {
        GeneratedMessageLite.emptyProtobufList();
        additionalFiles_ = GeneratedMessageLite.emptyProtobufList(..);
        return;
    }

    private void clearEntryPoint() {
        WebviewConfigurationStore$WebViewConfigurationStore.getDefaultInstance();
        WebviewConfigurationStore$WebViewConfigurationStore.getEntryPoint();
        entryPoint_ = WebviewConfigurationStore$WebViewConfigurationStore.getEntryPoint(..);
        return;
    }

    private void clearVersion() {
        version_ = 0;
        return;
    }

    private void ensureAdditionalFilesIsMutable() {
        additionalFiles_.isModifiable();
        if (if-nez(Internal$ProtobufList.isModifiable(..))) goto L_e;
        GeneratedMessageLite.mutableCopy(additionalFiles_);
        additionalFiles_ = GeneratedMessageLite.mutableCopy(..);
      L_e:
        return;
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore getDefaultInstance() {
        return WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE;
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore$Builder newBuilder() {
        WebviewConfigurationStore$WebViewConfigurationStore.createBuilder();
        return WebviewConfigurationStore$WebViewConfigurationStore.createBuilder(..);
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore$Builder newBuilder(WebviewConfigurationStore$WebViewConfigurationStore p0) {
        WebviewConfigurationStore$WebViewConfigurationStore.createBuilder(p0);
        return WebviewConfigurationStore$WebViewConfigurationStore.createBuilder(..);
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore parseDelimitedFrom(InputStream p0) {
        WebviewConfigurationStore$WebViewConfigurationStore.parseDelimitedFrom(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE, p0);
        return WebviewConfigurationStore$WebViewConfigurationStore.parseDelimitedFrom(..);
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore parseDelimitedFrom(InputStream p0, ExtensionRegistryLite p1) {
        WebviewConfigurationStore$WebViewConfigurationStore.parseDelimitedFrom(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE, p0, p1);
        return WebviewConfigurationStore$WebViewConfigurationStore.parseDelimitedFrom(..);
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore parseFrom(ByteString p0) {
        GeneratedMessageLite.parseFrom(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore parseFrom(ByteString p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore parseFrom(CodedInputStream p0) {
        GeneratedMessageLite.parseFrom(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore parseFrom(CodedInputStream p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore parseFrom(InputStream p0) {
        GeneratedMessageLite.parseFrom(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore parseFrom(InputStream p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore parseFrom(ByteBuffer p0) {
        GeneratedMessageLite.parseFrom(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore parseFrom(ByteBuffer p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore parseFrom(byte[] p0) {
        GeneratedMessageLite.parseFrom(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE, p0);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static WebviewConfigurationStore$WebViewConfigurationStore parseFrom(byte[] p0, ExtensionRegistryLite p1) {
        GeneratedMessageLite.parseFrom(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE, p0, p1);
        return GeneratedMessageLite.parseFrom(..);
    }

    public static Parser parser() {
        WebviewConfigurationStore$WebViewConfigurationStore.getParserForType();
        return WebviewConfigurationStore$WebViewConfigurationStore.getParserForType(..);
    }

    private void setAdditionalFiles(int p0, String p1) {
        p1.getClass();
        WebviewConfigurationStore$WebViewConfigurationStore.ensureAdditionalFilesIsMutable();
        additionalFiles_.set(p0, p1);
        return;
    }

    private void setEntryPoint(String p0) {
        p0.getClass();
        entryPoint_ = p0;
        return;
    }

    private void setEntryPointBytes(ByteString p0) {
        WebviewConfigurationStore$WebViewConfigurationStore.checkByteStringIsUtf8(p0);
        p0.toStringUtf8();
        entryPoint_ = ByteString.toStringUtf8(..);
        return;
    }

    private void setVersion(int p0) {
        version_ = p0;
        return;
    }

    protected final Object dynamicMethod(GeneratedMessageLite$MethodToInvoke p0, Object p1, Object p2) {
        p0.ordinal();
        new UnsupportedOperationException();
        throw new UnsupportedOperationException(..);
        return 0;
        Byte.valueOf(1);
        return Byte.valueOf(..);
        if (if-nez(WebviewConfigurationStore$WebViewConfigurationStore.PARSER)) goto L_32;
        if (if-nez(WebviewConfigurationStore$WebViewConfigurationStore.PARSER)) goto L_2d;
        new GeneratedMessageLite$DefaultInstanceBasedParser(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE);
        PARSER = new GeneratedMessageLite$DefaultInstanceBasedParser(..);
      L_2d:
        throw new GeneratedMessageLite$DefaultInstanceBasedParser(..);
      L_32:
        return new GeneratedMessageLite$DefaultInstanceBasedParser(..);
        return WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE;
        WebviewConfigurationStore$WebViewConfigurationStore.newMessageInfo(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE, "����������ȈȚ", 3);
        return WebviewConfigurationStore$WebViewConfigurationStore.newMessageInfo(..);
        new WebviewConfigurationStore$WebViewConfigurationStore$Builder(WebviewConfigurationStore$WebViewConfigurationStore.DEFAULT_INSTANCE);
        return new WebviewConfigurationStore$WebViewConfigurationStore$Builder(..);
        new WebviewConfigurationStore$WebViewConfigurationStore();
        return new WebviewConfigurationStore$WebViewConfigurationStore(..);
    }

    public String getAdditionalFiles(int p0) {
        additionalFiles_.get(p0);
        return Internal$ProtobufList.get(..);
    }

    public ByteString getAdditionalFilesBytes(int p0) {
        additionalFiles_.get(p0);
        ByteString.copyFromUtf8(Internal$ProtobufList.get(..));
        return ByteString.copyFromUtf8(..);
    }

    public int getAdditionalFilesCount() {
        additionalFiles_.size();
        return Internal$ProtobufList.size(..);
    }

    public List getAdditionalFilesList() {
        return additionalFiles_;
    }

    public String getEntryPoint() {
        return entryPoint_;
    }

    public ByteString getEntryPointBytes() {
        ByteString.copyFromUtf8(entryPoint_);
        return ByteString.copyFromUtf8(..);
    }

    public int getVersion() {
        return version_;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.WebviewConfigurationStore$WebViewConfigurationStore$Builder
// ============================================================
package com.unity3d.ads.datastore;

public final class WebviewConfigurationStore$WebViewConfigurationStore$Builder extends GeneratedMessageLite$Builder {
    private WebviewConfigurationStore$WebViewConfigurationStore$Builder() {
        WebviewConfigurationStore$WebViewConfigurationStore.access$000();
        new GeneratedMessageLite$Builder(WebviewConfigurationStore$WebViewConfigurationStore.access$000(..));
        return;
    }

    WebviewConfigurationStore$WebViewConfigurationStore$Builder(WebviewConfigurationStore$1 p0) {
        new WebviewConfigurationStore$WebViewConfigurationStore$Builder();
        return;
    }

    public WebviewConfigurationStore$WebViewConfigurationStore$Builder addAdditionalFiles(String p0) {
        WebviewConfigurationStore$WebViewConfigurationStore$Builder.copyOnWrite();
        WebviewConfigurationStore$WebViewConfigurationStore.access$700(instance, p0);
        return this;
    }

    public WebviewConfigurationStore$WebViewConfigurationStore$Builder addAdditionalFilesBytes(ByteString p0) {
        WebviewConfigurationStore$WebViewConfigurationStore$Builder.copyOnWrite();
        WebviewConfigurationStore$WebViewConfigurationStore.access$1000(instance, p0);
        return this;
    }

    public WebviewConfigurationStore$WebViewConfigurationStore$Builder addAllAdditionalFiles(Iterable p0) {
        WebviewConfigurationStore$WebViewConfigurationStore$Builder.copyOnWrite();
        WebviewConfigurationStore$WebViewConfigurationStore.access$800(instance, p0);
        return this;
    }

    public WebviewConfigurationStore$WebViewConfigurationStore$Builder clearAdditionalFiles() {
        WebviewConfigurationStore$WebViewConfigurationStore$Builder.copyOnWrite();
        WebviewConfigurationStore$WebViewConfigurationStore.access$900(instance);
        return this;
    }

    public WebviewConfigurationStore$WebViewConfigurationStore$Builder clearEntryPoint() {
        WebviewConfigurationStore$WebViewConfigurationStore$Builder.copyOnWrite();
        WebviewConfigurationStore$WebViewConfigurationStore.access$400(instance);
        return this;
    }

    public WebviewConfigurationStore$WebViewConfigurationStore$Builder clearVersion() {
        WebviewConfigurationStore$WebViewConfigurationStore$Builder.copyOnWrite();
        WebviewConfigurationStore$WebViewConfigurationStore.access$200(instance);
        return this;
    }

    public String getAdditionalFiles(int p0) {
        instance.getAdditionalFiles(p0);
        return WebviewConfigurationStore$WebViewConfigurationStore.getAdditionalFiles(..);
    }

    public ByteString getAdditionalFilesBytes(int p0) {
        instance.getAdditionalFilesBytes(p0);
        return WebviewConfigurationStore$WebViewConfigurationStore.getAdditionalFilesBytes(..);
    }

    public int getAdditionalFilesCount() {
        instance.getAdditionalFilesCount();
        return WebviewConfigurationStore$WebViewConfigurationStore.getAdditionalFilesCount(..);
    }

    public List getAdditionalFilesList() {
        instance.getAdditionalFilesList();
        Collections.unmodifiableList(WebviewConfigurationStore$WebViewConfigurationStore.getAdditionalFilesList(..));
        return Collections.unmodifiableList(..);
    }

    public String getEntryPoint() {
        instance.getEntryPoint();
        return WebviewConfigurationStore$WebViewConfigurationStore.getEntryPoint(..);
    }

    public ByteString getEntryPointBytes() {
        instance.getEntryPointBytes();
        return WebviewConfigurationStore$WebViewConfigurationStore.getEntryPointBytes(..);
    }

    public int getVersion() {
        instance.getVersion();
        return WebviewConfigurationStore$WebViewConfigurationStore.getVersion(..);
    }

    public WebviewConfigurationStore$WebViewConfigurationStore$Builder setAdditionalFiles(int p0, String p1) {
        WebviewConfigurationStore$WebViewConfigurationStore$Builder.copyOnWrite();
        WebviewConfigurationStore$WebViewConfigurationStore.access$600(instance, p0, p1);
        return this;
    }

    public WebviewConfigurationStore$WebViewConfigurationStore$Builder setEntryPoint(String p0) {
        WebviewConfigurationStore$WebViewConfigurationStore$Builder.copyOnWrite();
        WebviewConfigurationStore$WebViewConfigurationStore.access$300(instance, p0);
        return this;
    }

    public WebviewConfigurationStore$WebViewConfigurationStore$Builder setEntryPointBytes(ByteString p0) {
        WebviewConfigurationStore$WebViewConfigurationStore$Builder.copyOnWrite();
        WebviewConfigurationStore$WebViewConfigurationStore.access$500(instance, p0);
        return this;
    }

    public WebviewConfigurationStore$WebViewConfigurationStore$Builder setVersion(int p0) {
        WebviewConfigurationStore$WebViewConfigurationStore$Builder.copyOnWrite();
        WebviewConfigurationStore$WebViewConfigurationStore.access$100(instance, p0);
        return this;
    }

}


// ============================================================
// CLASS: com.unity3d.ads.datastore.WebviewConfigurationStore$WebViewConfigurationStoreOrBuilder
// ============================================================
package com.unity3d.ads.datastore;

public abstract class WebviewConfigurationStore$WebViewConfigurationStoreOrBuilder {
    public abstract String getAdditionalFiles(int p0) {
        // native or abstract
    }

    public abstract ByteString getAdditionalFilesBytes(int p0) {
        // native or abstract
    }

    public abstract int getAdditionalFilesCount() {
        // native or abstract
    }

    public abstract List getAdditionalFilesList() {
        // native or abstract
    }

    public abstract String getEntryPoint() {
        // native or abstract
    }

    public abstract ByteString getEntryPointBytes() {
        // native or abstract
    }

    public abstract int getVersion() {
        // native or abstract
    }

}

