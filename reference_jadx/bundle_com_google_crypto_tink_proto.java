
// ===== FILE: com/google/crypto/tink/proto/AesCmac.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class AesCmac {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private AesCmac() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCmacKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesCmacParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesCmacKey extends GeneratedMessageLite<AesCmacKey, Builder> implements AesCmacKeyOrBuilder {
    private static final AesCmacKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 3;
    private static volatile Parser<AesCmacKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private AesCmacParams params_;
    private int version_;

    private AesCmacKey() {
    }

    @Override // com.google.crypto.tink.proto.AesCmacKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesCmacKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    @Override // com.google.crypto.tink.proto.AesCmacKeyOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesCmacKeyOrBuilder
    public AesCmacParams getParams() {
        AesCmacParams aesCmacParams = this.params_;
        return aesCmacParams == null ? AesCmacParams.getDefaultInstance() : aesCmacParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(AesCmacParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(AesCmacParams value) {
        value.getClass();
        AesCmacParams aesCmacParams = this.params_;
        if (aesCmacParams != null && aesCmacParams != AesCmacParams.getDefaultInstance()) {
            this.params_ = AesCmacParams.newBuilder(this.params_).mergeFrom((AesCmacParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    public static AesCmacKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesCmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesCmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesCmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacKey parseFrom(InputStream input) throws IOException {
        return (AesCmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCmacKey parseDelimitedFrom(InputStream input) throws IOException {
        return (AesCmacKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCmacKey parseFrom(CodedInputStream input) throws IOException {
        return (AesCmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCmacKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCmacKey, Builder> implements AesCmacKeyOrBuilder {
        /* synthetic */ Builder(C05791 c05791) {
            this();
        }

        private Builder() {
            super(AesCmacKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesCmacKeyOrBuilder
        public int getVersion() {
            return ((AesCmacKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesCmacKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesCmacKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCmacKeyOrBuilder
        public ByteString getKeyValue() {
            return ((AesCmacKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((AesCmacKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((AesCmacKey) this.instance).clearKeyValue();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCmacKeyOrBuilder
        public boolean hasParams() {
            return ((AesCmacKey) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.AesCmacKeyOrBuilder
        public AesCmacParams getParams() {
            return ((AesCmacKey) this.instance).getParams();
        }

        public Builder setParams(AesCmacParams value) {
            copyOnWrite();
            ((AesCmacKey) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(AesCmacParams.Builder builderForValue) {
            copyOnWrite();
            ((AesCmacKey) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(AesCmacParams value) {
            copyOnWrite();
            ((AesCmacKey) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((AesCmacKey) this.instance).clearParams();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCmacKey$1 */
    static /* synthetic */ class C05791 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f111xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f111xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f111xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f111xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f111xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f111xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f111xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f111xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05791 c05791 = null;
        switch (C05791.f111xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesCmacKey();
            case 2:
                return new Builder(c05791);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"version_", "keyValue_", "params_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCmacKey> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCmacKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesCmacKey aesCmacKey = new AesCmacKey();
        DEFAULT_INSTANCE = aesCmacKey;
        GeneratedMessageLite.registerDefaultInstance(AesCmacKey.class, aesCmacKey);
    }

    public static AesCmacKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCmacKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCmacKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesCmacParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesCmacKeyFormat extends GeneratedMessageLite<AesCmacKeyFormat, Builder> implements AesCmacKeyFormatOrBuilder {
    private static final AesCmacKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 1;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<AesCmacKeyFormat> PARSER;
    private int keySize_;
    private AesCmacParams params_;

    private AesCmacKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.AesCmacKeyFormatOrBuilder
    public int getKeySize() {
        return this.keySize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeySize(int value) {
        this.keySize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesCmacKeyFormatOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesCmacKeyFormatOrBuilder
    public AesCmacParams getParams() {
        AesCmacParams aesCmacParams = this.params_;
        return aesCmacParams == null ? AesCmacParams.getDefaultInstance() : aesCmacParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(AesCmacParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(AesCmacParams value) {
        value.getClass();
        AesCmacParams aesCmacParams = this.params_;
        if (aesCmacParams != null && aesCmacParams != AesCmacParams.getDefaultInstance()) {
            this.params_ = AesCmacParams.newBuilder(this.params_).mergeFrom((AesCmacParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    public static AesCmacKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesCmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesCmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesCmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacKeyFormat parseFrom(InputStream input) throws IOException {
        return (AesCmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCmacKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (AesCmacKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCmacKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (AesCmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCmacKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCmacKeyFormat, Builder> implements AesCmacKeyFormatOrBuilder {
        /* synthetic */ Builder(C05801 c05801) {
            this();
        }

        private Builder() {
            super(AesCmacKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesCmacKeyFormatOrBuilder
        public int getKeySize() {
            return ((AesCmacKeyFormat) this.instance).getKeySize();
        }

        public Builder setKeySize(int value) {
            copyOnWrite();
            ((AesCmacKeyFormat) this.instance).setKeySize(value);
            return this;
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((AesCmacKeyFormat) this.instance).clearKeySize();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCmacKeyFormatOrBuilder
        public boolean hasParams() {
            return ((AesCmacKeyFormat) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.AesCmacKeyFormatOrBuilder
        public AesCmacParams getParams() {
            return ((AesCmacKeyFormat) this.instance).getParams();
        }

        public Builder setParams(AesCmacParams value) {
            copyOnWrite();
            ((AesCmacKeyFormat) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(AesCmacParams.Builder builderForValue) {
            copyOnWrite();
            ((AesCmacKeyFormat) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(AesCmacParams value) {
            copyOnWrite();
            ((AesCmacKeyFormat) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((AesCmacKeyFormat) this.instance).clearParams();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCmacKeyFormat$1 */
    static /* synthetic */ class C05801 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f112xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f112xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f112xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f112xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f112xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f112xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f112xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f112xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05801 c05801 = null;
        switch (C05801.f112xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesCmacKeyFormat();
            case 2:
                return new Builder(c05801);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"keySize_", "params_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCmacKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCmacKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesCmacKeyFormat aesCmacKeyFormat = new AesCmacKeyFormat();
        DEFAULT_INSTANCE = aesCmacKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(AesCmacKeyFormat.class, aesCmacKeyFormat);
    }

    public static AesCmacKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCmacKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCmacKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCmacKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    AesCmacParams getParams();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/AesCmacKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCmacKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    AesCmacParams getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/AesCmacParams.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesCmacParams extends GeneratedMessageLite<AesCmacParams, Builder> implements AesCmacParamsOrBuilder {
    private static final AesCmacParams DEFAULT_INSTANCE;
    private static volatile Parser<AesCmacParams> PARSER = null;
    public static final int TAG_SIZE_FIELD_NUMBER = 1;
    private int tagSize_;

    private AesCmacParams() {
    }

    @Override // com.google.crypto.tink.proto.AesCmacParamsOrBuilder
    public int getTagSize() {
        return this.tagSize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTagSize(int value) {
        this.tagSize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTagSize() {
        this.tagSize_ = 0;
    }

    public static AesCmacParams parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesCmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacParams parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacParams parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesCmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacParams parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacParams parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesCmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacParams parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacParams parseFrom(InputStream input) throws IOException {
        return (AesCmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacParams parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCmacParams parseDelimitedFrom(InputStream input) throws IOException {
        return (AesCmacParams) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacParams parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacParams) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCmacParams parseFrom(CodedInputStream input) throws IOException {
        return (AesCmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacParams parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCmacParams prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCmacParams, Builder> implements AesCmacParamsOrBuilder {
        /* synthetic */ Builder(C05811 c05811) {
            this();
        }

        private Builder() {
            super(AesCmacParams.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesCmacParamsOrBuilder
        public int getTagSize() {
            return ((AesCmacParams) this.instance).getTagSize();
        }

        public Builder setTagSize(int value) {
            copyOnWrite();
            ((AesCmacParams) this.instance).setTagSize(value);
            return this;
        }

        public Builder clearTagSize() {
            copyOnWrite();
            ((AesCmacParams) this.instance).clearTagSize();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCmacParams$1 */
    static /* synthetic */ class C05811 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f113xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f113xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f113xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f113xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f113xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f113xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f113xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f113xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05811 c05811 = null;
        switch (C05811.f113xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesCmacParams();
            case 2:
                return new Builder(c05811);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"tagSize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCmacParams> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCmacParams.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesCmacParams aesCmacParams = new AesCmacParams();
        DEFAULT_INSTANCE = aesCmacParams;
        GeneratedMessageLite.registerDefaultInstance(AesCmacParams.class, aesCmacParams);
    }

    public static AesCmacParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCmacParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCmacParamsOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCmacParamsOrBuilder extends MessageLiteOrBuilder {
    int getTagSize();
}

// ===== FILE: com/google/crypto/tink/proto/AesCmacPrf.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class AesCmacPrf {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private AesCmacPrf() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCmacPrfKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesCmacPrfKey extends GeneratedMessageLite<AesCmacPrfKey, Builder> implements AesCmacPrfKeyOrBuilder {
    private static final AesCmacPrfKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<AesCmacPrfKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private int version_;

    private AesCmacPrfKey() {
    }

    @Override // com.google.crypto.tink.proto.AesCmacPrfKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesCmacPrfKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static AesCmacPrfKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesCmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacPrfKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacPrfKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesCmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacPrfKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacPrfKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesCmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacPrfKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacPrfKey parseFrom(InputStream input) throws IOException {
        return (AesCmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacPrfKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCmacPrfKey parseDelimitedFrom(InputStream input) throws IOException {
        return (AesCmacPrfKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacPrfKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacPrfKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCmacPrfKey parseFrom(CodedInputStream input) throws IOException {
        return (AesCmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacPrfKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCmacPrfKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCmacPrfKey, Builder> implements AesCmacPrfKeyOrBuilder {
        /* synthetic */ Builder(C05821 c05821) {
            this();
        }

        private Builder() {
            super(AesCmacPrfKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesCmacPrfKeyOrBuilder
        public int getVersion() {
            return ((AesCmacPrfKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesCmacPrfKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesCmacPrfKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCmacPrfKeyOrBuilder
        public ByteString getKeyValue() {
            return ((AesCmacPrfKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((AesCmacPrfKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((AesCmacPrfKey) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCmacPrfKey$1 */
    static /* synthetic */ class C05821 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f114xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f114xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f114xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f114xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f114xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f114xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f114xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f114xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05821 c05821 = null;
        switch (C05821.f114xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesCmacPrfKey();
            case 2:
                return new Builder(c05821);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"version_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCmacPrfKey> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCmacPrfKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesCmacPrfKey aesCmacPrfKey = new AesCmacPrfKey();
        DEFAULT_INSTANCE = aesCmacPrfKey;
        GeneratedMessageLite.registerDefaultInstance(AesCmacPrfKey.class, aesCmacPrfKey);
    }

    public static AesCmacPrfKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCmacPrfKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCmacPrfKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesCmacPrfKeyFormat extends GeneratedMessageLite<AesCmacPrfKeyFormat, Builder> implements AesCmacPrfKeyFormatOrBuilder {
    private static final AesCmacPrfKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 1;
    private static volatile Parser<AesCmacPrfKeyFormat> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private int keySize_;
    private int version_;

    private AesCmacPrfKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.AesCmacPrfKeyFormatOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesCmacPrfKeyFormatOrBuilder
    public int getKeySize() {
        return this.keySize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeySize(int value) {
        this.keySize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    public static AesCmacPrfKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesCmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacPrfKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacPrfKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesCmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacPrfKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacPrfKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesCmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCmacPrfKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCmacPrfKeyFormat parseFrom(InputStream input) throws IOException {
        return (AesCmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacPrfKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCmacPrfKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (AesCmacPrfKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacPrfKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacPrfKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCmacPrfKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (AesCmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCmacPrfKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCmacPrfKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCmacPrfKeyFormat, Builder> implements AesCmacPrfKeyFormatOrBuilder {
        /* synthetic */ Builder(C05831 c05831) {
            this();
        }

        private Builder() {
            super(AesCmacPrfKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesCmacPrfKeyFormatOrBuilder
        public int getVersion() {
            return ((AesCmacPrfKeyFormat) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesCmacPrfKeyFormat) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesCmacPrfKeyFormat) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCmacPrfKeyFormatOrBuilder
        public int getKeySize() {
            return ((AesCmacPrfKeyFormat) this.instance).getKeySize();
        }

        public Builder setKeySize(int value) {
            copyOnWrite();
            ((AesCmacPrfKeyFormat) this.instance).setKeySize(value);
            return this;
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((AesCmacPrfKeyFormat) this.instance).clearKeySize();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCmacPrfKeyFormat$1 */
    static /* synthetic */ class C05831 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f115xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f115xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f115xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f115xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f115xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f115xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f115xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f115xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05831 c05831 = null;
        switch (C05831.f115xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesCmacPrfKeyFormat();
            case 2:
                return new Builder(c05831);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"keySize_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCmacPrfKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCmacPrfKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesCmacPrfKeyFormat aesCmacPrfKeyFormat = new AesCmacPrfKeyFormat();
        DEFAULT_INSTANCE = aesCmacPrfKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(AesCmacPrfKeyFormat.class, aesCmacPrfKeyFormat);
    }

    public static AesCmacPrfKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCmacPrfKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCmacPrfKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCmacPrfKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    int getVersion();
}

// ===== FILE: com/google/crypto/tink/proto/AesCmacPrfKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCmacPrfKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    int getVersion();
}

// ===== FILE: com/google/crypto/tink/proto/AesCtr.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class AesCtr {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private AesCtr() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrHmacAead.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class AesCtrHmacAead {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private AesCtrHmacAead() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrHmacAeadKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesCtrHmacAeadKey extends GeneratedMessageLite<AesCtrHmacAeadKey, Builder> implements AesCtrHmacAeadKeyOrBuilder {
    public static final int AES_CTR_KEY_FIELD_NUMBER = 2;
    private static final AesCtrHmacAeadKey DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FIELD_NUMBER = 3;
    private static volatile Parser<AesCtrHmacAeadKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AesCtrKey aesCtrKey_;
    private HmacKey hmacKey_;
    private int version_;

    private AesCtrHmacAeadKey() {
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
    public boolean hasAesCtrKey() {
        return this.aesCtrKey_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
    public AesCtrKey getAesCtrKey() {
        AesCtrKey aesCtrKey = this.aesCtrKey_;
        return aesCtrKey == null ? AesCtrKey.getDefaultInstance() : aesCtrKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAesCtrKey(AesCtrKey value) {
        value.getClass();
        this.aesCtrKey_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAesCtrKey(AesCtrKey value) {
        value.getClass();
        AesCtrKey aesCtrKey = this.aesCtrKey_;
        if (aesCtrKey != null && aesCtrKey != AesCtrKey.getDefaultInstance()) {
            this.aesCtrKey_ = AesCtrKey.newBuilder(this.aesCtrKey_).mergeFrom((AesCtrKey.Builder) value).buildPartial();
        } else {
            this.aesCtrKey_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAesCtrKey() {
        this.aesCtrKey_ = null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
    public boolean hasHmacKey() {
        return this.hmacKey_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
    public HmacKey getHmacKey() {
        HmacKey hmacKey = this.hmacKey_;
        return hmacKey == null ? HmacKey.getDefaultInstance() : hmacKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHmacKey(HmacKey value) {
        value.getClass();
        this.hmacKey_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeHmacKey(HmacKey value) {
        value.getClass();
        HmacKey hmacKey = this.hmacKey_;
        if (hmacKey != null && hmacKey != HmacKey.getDefaultInstance()) {
            this.hmacKey_ = HmacKey.newBuilder(this.hmacKey_).mergeFrom((HmacKey.Builder) value).buildPartial();
        } else {
            this.hmacKey_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHmacKey() {
        this.hmacKey_ = null;
    }

    public static AesCtrHmacAeadKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacAeadKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacAeadKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacAeadKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacAeadKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacAeadKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacAeadKey parseFrom(InputStream input) throws IOException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacAeadKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrHmacAeadKey parseDelimitedFrom(InputStream input) throws IOException {
        return (AesCtrHmacAeadKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacAeadKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacAeadKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrHmacAeadKey parseFrom(CodedInputStream input) throws IOException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacAeadKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCtrHmacAeadKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrHmacAeadKey, Builder> implements AesCtrHmacAeadKeyOrBuilder {
        /* synthetic */ Builder(C05841 c05841) {
            this();
        }

        private Builder() {
            super(AesCtrHmacAeadKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
        public int getVersion() {
            return ((AesCtrHmacAeadKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
        public boolean hasAesCtrKey() {
            return ((AesCtrHmacAeadKey) this.instance).hasAesCtrKey();
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
        public AesCtrKey getAesCtrKey() {
            return ((AesCtrHmacAeadKey) this.instance).getAesCtrKey();
        }

        public Builder setAesCtrKey(AesCtrKey value) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setAesCtrKey(value);
            return this;
        }

        public Builder setAesCtrKey(AesCtrKey.Builder builderForValue) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setAesCtrKey(builderForValue.build());
            return this;
        }

        public Builder mergeAesCtrKey(AesCtrKey value) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).mergeAesCtrKey(value);
            return this;
        }

        public Builder clearAesCtrKey() {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).clearAesCtrKey();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
        public boolean hasHmacKey() {
            return ((AesCtrHmacAeadKey) this.instance).hasHmacKey();
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyOrBuilder
        public HmacKey getHmacKey() {
            return ((AesCtrHmacAeadKey) this.instance).getHmacKey();
        }

        public Builder setHmacKey(HmacKey value) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setHmacKey(value);
            return this;
        }

        public Builder setHmacKey(HmacKey.Builder builderForValue) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).setHmacKey(builderForValue.build());
            return this;
        }

        public Builder mergeHmacKey(HmacKey value) {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).mergeHmacKey(value);
            return this;
        }

        public Builder clearHmacKey() {
            copyOnWrite();
            ((AesCtrHmacAeadKey) this.instance).clearHmacKey();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCtrHmacAeadKey$1 */
    static /* synthetic */ class C05841 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f116xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f116xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f116xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f116xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f116xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f116xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f116xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f116xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05841 c05841 = null;
        switch (C05841.f116xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesCtrHmacAeadKey();
            case 2:
                return new Builder(c05841);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"version_", "aesCtrKey_", "hmacKey_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCtrHmacAeadKey> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCtrHmacAeadKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesCtrHmacAeadKey aesCtrHmacAeadKey = new AesCtrHmacAeadKey();
        DEFAULT_INSTANCE = aesCtrHmacAeadKey;
        GeneratedMessageLite.registerDefaultInstance(AesCtrHmacAeadKey.class, aesCtrHmacAeadKey);
    }

    public static AesCtrHmacAeadKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCtrHmacAeadKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrHmacAeadKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesCtrHmacAeadKeyFormat extends GeneratedMessageLite<AesCtrHmacAeadKeyFormat, Builder> implements AesCtrHmacAeadKeyFormatOrBuilder {
    public static final int AES_CTR_KEY_FORMAT_FIELD_NUMBER = 1;
    private static final AesCtrHmacAeadKeyFormat DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FORMAT_FIELD_NUMBER = 2;
    private static volatile Parser<AesCtrHmacAeadKeyFormat> PARSER;
    private AesCtrKeyFormat aesCtrKeyFormat_;
    private HmacKeyFormat hmacKeyFormat_;

    private AesCtrHmacAeadKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormatOrBuilder
    public boolean hasAesCtrKeyFormat() {
        return this.aesCtrKeyFormat_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormatOrBuilder
    public AesCtrKeyFormat getAesCtrKeyFormat() {
        AesCtrKeyFormat aesCtrKeyFormat = this.aesCtrKeyFormat_;
        return aesCtrKeyFormat == null ? AesCtrKeyFormat.getDefaultInstance() : aesCtrKeyFormat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAesCtrKeyFormat(AesCtrKeyFormat value) {
        value.getClass();
        this.aesCtrKeyFormat_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAesCtrKeyFormat(AesCtrKeyFormat value) {
        value.getClass();
        AesCtrKeyFormat aesCtrKeyFormat = this.aesCtrKeyFormat_;
        if (aesCtrKeyFormat != null && aesCtrKeyFormat != AesCtrKeyFormat.getDefaultInstance()) {
            this.aesCtrKeyFormat_ = AesCtrKeyFormat.newBuilder(this.aesCtrKeyFormat_).mergeFrom((AesCtrKeyFormat.Builder) value).buildPartial();
        } else {
            this.aesCtrKeyFormat_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAesCtrKeyFormat() {
        this.aesCtrKeyFormat_ = null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormatOrBuilder
    public boolean hasHmacKeyFormat() {
        return this.hmacKeyFormat_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormatOrBuilder
    public HmacKeyFormat getHmacKeyFormat() {
        HmacKeyFormat hmacKeyFormat = this.hmacKeyFormat_;
        return hmacKeyFormat == null ? HmacKeyFormat.getDefaultInstance() : hmacKeyFormat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHmacKeyFormat(HmacKeyFormat value) {
        value.getClass();
        this.hmacKeyFormat_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeHmacKeyFormat(HmacKeyFormat value) {
        value.getClass();
        HmacKeyFormat hmacKeyFormat = this.hmacKeyFormat_;
        if (hmacKeyFormat != null && hmacKeyFormat != HmacKeyFormat.getDefaultInstance()) {
            this.hmacKeyFormat_ = HmacKeyFormat.newBuilder(this.hmacKeyFormat_).mergeFrom((HmacKeyFormat.Builder) value).buildPartial();
        } else {
            this.hmacKeyFormat_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHmacKeyFormat() {
        this.hmacKeyFormat_ = null;
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(InputStream input) throws IOException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrHmacAeadKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (AesCtrHmacAeadKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacAeadKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacAeadKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacAeadKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCtrHmacAeadKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrHmacAeadKeyFormat, Builder> implements AesCtrHmacAeadKeyFormatOrBuilder {
        /* synthetic */ Builder(C05851 c05851) {
            this();
        }

        private Builder() {
            super(AesCtrHmacAeadKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormatOrBuilder
        public boolean hasAesCtrKeyFormat() {
            return ((AesCtrHmacAeadKeyFormat) this.instance).hasAesCtrKeyFormat();
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormatOrBuilder
        public AesCtrKeyFormat getAesCtrKeyFormat() {
            return ((AesCtrHmacAeadKeyFormat) this.instance).getAesCtrKeyFormat();
        }

        public Builder setAesCtrKeyFormat(AesCtrKeyFormat value) {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).setAesCtrKeyFormat(value);
            return this;
        }

        public Builder setAesCtrKeyFormat(AesCtrKeyFormat.Builder builderForValue) {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).setAesCtrKeyFormat(builderForValue.build());
            return this;
        }

        public Builder mergeAesCtrKeyFormat(AesCtrKeyFormat value) {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).mergeAesCtrKeyFormat(value);
            return this;
        }

        public Builder clearAesCtrKeyFormat() {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).clearAesCtrKeyFormat();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormatOrBuilder
        public boolean hasHmacKeyFormat() {
            return ((AesCtrHmacAeadKeyFormat) this.instance).hasHmacKeyFormat();
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormatOrBuilder
        public HmacKeyFormat getHmacKeyFormat() {
            return ((AesCtrHmacAeadKeyFormat) this.instance).getHmacKeyFormat();
        }

        public Builder setHmacKeyFormat(HmacKeyFormat value) {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).setHmacKeyFormat(value);
            return this;
        }

        public Builder setHmacKeyFormat(HmacKeyFormat.Builder builderForValue) {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).setHmacKeyFormat(builderForValue.build());
            return this;
        }

        public Builder mergeHmacKeyFormat(HmacKeyFormat value) {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).mergeHmacKeyFormat(value);
            return this;
        }

        public Builder clearHmacKeyFormat() {
            copyOnWrite();
            ((AesCtrHmacAeadKeyFormat) this.instance).clearHmacKeyFormat();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat$1 */
    static /* synthetic */ class C05851 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f117xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f117xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f117xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f117xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f117xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f117xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f117xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f117xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05851 c05851 = null;
        switch (C05851.f117xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesCtrHmacAeadKeyFormat();
            case 2:
                return new Builder(c05851);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"aesCtrKeyFormat_", "hmacKeyFormat_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCtrHmacAeadKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCtrHmacAeadKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesCtrHmacAeadKeyFormat aesCtrHmacAeadKeyFormat = new AesCtrHmacAeadKeyFormat();
        DEFAULT_INSTANCE = aesCtrHmacAeadKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(AesCtrHmacAeadKeyFormat.class, aesCtrHmacAeadKeyFormat);
    }

    public static AesCtrHmacAeadKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCtrHmacAeadKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrHmacAeadKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCtrHmacAeadKeyFormatOrBuilder extends MessageLiteOrBuilder {
    AesCtrKeyFormat getAesCtrKeyFormat();

    HmacKeyFormat getHmacKeyFormat();

    boolean hasAesCtrKeyFormat();

    boolean hasHmacKeyFormat();
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrHmacAeadKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCtrHmacAeadKeyOrBuilder extends MessageLiteOrBuilder {
    AesCtrKey getAesCtrKey();

    HmacKey getHmacKey();

    int getVersion();

    boolean hasAesCtrKey();

    boolean hasHmacKey();
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrHmacStreaming.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class AesCtrHmacStreaming {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private AesCtrHmacStreaming() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrHmacStreamingKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesCtrHmacStreamingKey extends GeneratedMessageLite<AesCtrHmacStreamingKey, Builder> implements AesCtrHmacStreamingKeyOrBuilder {
    private static final AesCtrHmacStreamingKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<AesCtrHmacStreamingKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private AesCtrHmacStreamingParams params_;
    private int version_;

    private AesCtrHmacStreamingKey() {
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyOrBuilder
    public AesCtrHmacStreamingParams getParams() {
        AesCtrHmacStreamingParams aesCtrHmacStreamingParams = this.params_;
        return aesCtrHmacStreamingParams == null ? AesCtrHmacStreamingParams.getDefaultInstance() : aesCtrHmacStreamingParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(AesCtrHmacStreamingParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(AesCtrHmacStreamingParams value) {
        value.getClass();
        AesCtrHmacStreamingParams aesCtrHmacStreamingParams = this.params_;
        if (aesCtrHmacStreamingParams != null && aesCtrHmacStreamingParams != AesCtrHmacStreamingParams.getDefaultInstance()) {
            this.params_ = AesCtrHmacStreamingParams.newBuilder(this.params_).mergeFrom((AesCtrHmacStreamingParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static AesCtrHmacStreamingKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacStreamingKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacStreamingKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacStreamingKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacStreamingKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacStreamingKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacStreamingKey parseFrom(InputStream input) throws IOException {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacStreamingKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrHmacStreamingKey parseDelimitedFrom(InputStream input) throws IOException {
        return (AesCtrHmacStreamingKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacStreamingKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacStreamingKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrHmacStreamingKey parseFrom(CodedInputStream input) throws IOException {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacStreamingKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCtrHmacStreamingKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrHmacStreamingKey, Builder> implements AesCtrHmacStreamingKeyOrBuilder {
        /* synthetic */ Builder(C05861 c05861) {
            this();
        }

        private Builder() {
            super(AesCtrHmacStreamingKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyOrBuilder
        public int getVersion() {
            return ((AesCtrHmacStreamingKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyOrBuilder
        public boolean hasParams() {
            return ((AesCtrHmacStreamingKey) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyOrBuilder
        public AesCtrHmacStreamingParams getParams() {
            return ((AesCtrHmacStreamingKey) this.instance).getParams();
        }

        public Builder setParams(AesCtrHmacStreamingParams value) {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(AesCtrHmacStreamingParams.Builder builderForValue) {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(AesCtrHmacStreamingParams value) {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyOrBuilder
        public ByteString getKeyValue() {
            return ((AesCtrHmacStreamingKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCtrHmacStreamingKey$1 */
    static /* synthetic */ class C05861 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f118xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f118xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f118xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f118xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f118xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f118xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f118xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f118xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05861 c05861 = null;
        switch (C05861.f118xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesCtrHmacStreamingKey();
            case 2:
                return new Builder(c05861);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCtrHmacStreamingKey> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCtrHmacStreamingKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesCtrHmacStreamingKey aesCtrHmacStreamingKey = new AesCtrHmacStreamingKey();
        DEFAULT_INSTANCE = aesCtrHmacStreamingKey;
        GeneratedMessageLite.registerDefaultInstance(AesCtrHmacStreamingKey.class, aesCtrHmacStreamingKey);
    }

    public static AesCtrHmacStreamingKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCtrHmacStreamingKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrHmacStreamingKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesCtrHmacStreamingKeyFormat extends GeneratedMessageLite<AesCtrHmacStreamingKeyFormat, Builder> implements AesCtrHmacStreamingKeyFormatOrBuilder {
    private static final AesCtrHmacStreamingKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<AesCtrHmacStreamingKeyFormat> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private AesCtrHmacStreamingParams params_;
    private int version_;

    private AesCtrHmacStreamingKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormatOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormatOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormatOrBuilder
    public AesCtrHmacStreamingParams getParams() {
        AesCtrHmacStreamingParams aesCtrHmacStreamingParams = this.params_;
        return aesCtrHmacStreamingParams == null ? AesCtrHmacStreamingParams.getDefaultInstance() : aesCtrHmacStreamingParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(AesCtrHmacStreamingParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(AesCtrHmacStreamingParams value) {
        value.getClass();
        AesCtrHmacStreamingParams aesCtrHmacStreamingParams = this.params_;
        if (aesCtrHmacStreamingParams != null && aesCtrHmacStreamingParams != AesCtrHmacStreamingParams.getDefaultInstance()) {
            this.params_ = AesCtrHmacStreamingParams.newBuilder(this.params_).mergeFrom((AesCtrHmacStreamingParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormatOrBuilder
    public int getKeySize() {
        return this.keySize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeySize(int value) {
        this.keySize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    public static AesCtrHmacStreamingKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacStreamingKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacStreamingKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacStreamingKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacStreamingKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacStreamingKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacStreamingKeyFormat parseFrom(InputStream input) throws IOException {
        return (AesCtrHmacStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacStreamingKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrHmacStreamingKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (AesCtrHmacStreamingKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacStreamingKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacStreamingKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrHmacStreamingKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (AesCtrHmacStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacStreamingKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCtrHmacStreamingKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrHmacStreamingKeyFormat, Builder> implements AesCtrHmacStreamingKeyFormatOrBuilder {
        /* synthetic */ Builder(C05871 c05871) {
            this();
        }

        private Builder() {
            super(AesCtrHmacStreamingKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormatOrBuilder
        public int getVersion() {
            return ((AesCtrHmacStreamingKeyFormat) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesCtrHmacStreamingKeyFormat) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesCtrHmacStreamingKeyFormat) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormatOrBuilder
        public boolean hasParams() {
            return ((AesCtrHmacStreamingKeyFormat) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormatOrBuilder
        public AesCtrHmacStreamingParams getParams() {
            return ((AesCtrHmacStreamingKeyFormat) this.instance).getParams();
        }

        public Builder setParams(AesCtrHmacStreamingParams value) {
            copyOnWrite();
            ((AesCtrHmacStreamingKeyFormat) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(AesCtrHmacStreamingParams.Builder builderForValue) {
            copyOnWrite();
            ((AesCtrHmacStreamingKeyFormat) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(AesCtrHmacStreamingParams value) {
            copyOnWrite();
            ((AesCtrHmacStreamingKeyFormat) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((AesCtrHmacStreamingKeyFormat) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormatOrBuilder
        public int getKeySize() {
            return ((AesCtrHmacStreamingKeyFormat) this.instance).getKeySize();
        }

        public Builder setKeySize(int value) {
            copyOnWrite();
            ((AesCtrHmacStreamingKeyFormat) this.instance).setKeySize(value);
            return this;
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((AesCtrHmacStreamingKeyFormat) this.instance).clearKeySize();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormat$1 */
    static /* synthetic */ class C05871 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f119xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f119xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f119xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f119xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f119xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f119xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05871 c05871 = null;
        switch (C05871.f119xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesCtrHmacStreamingKeyFormat();
            case 2:
                return new Builder(c05871);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"params_", "keySize_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCtrHmacStreamingKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCtrHmacStreamingKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesCtrHmacStreamingKeyFormat aesCtrHmacStreamingKeyFormat = new AesCtrHmacStreamingKeyFormat();
        DEFAULT_INSTANCE = aesCtrHmacStreamingKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(AesCtrHmacStreamingKeyFormat.class, aesCtrHmacStreamingKeyFormat);
    }

    public static AesCtrHmacStreamingKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCtrHmacStreamingKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrHmacStreamingKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCtrHmacStreamingKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    AesCtrHmacStreamingParams getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrHmacStreamingKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCtrHmacStreamingKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    AesCtrHmacStreamingParams getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrHmacStreamingParams.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesCtrHmacStreamingParams extends GeneratedMessageLite<AesCtrHmacStreamingParams, Builder> implements AesCtrHmacStreamingParamsOrBuilder {
    public static final int CIPHERTEXT_SEGMENT_SIZE_FIELD_NUMBER = 1;
    private static final AesCtrHmacStreamingParams DEFAULT_INSTANCE;
    public static final int DERIVED_KEY_SIZE_FIELD_NUMBER = 2;
    public static final int HKDF_HASH_TYPE_FIELD_NUMBER = 3;
    public static final int HMAC_PARAMS_FIELD_NUMBER = 4;
    private static volatile Parser<AesCtrHmacStreamingParams> PARSER;
    private int ciphertextSegmentSize_;
    private int derivedKeySize_;
    private int hkdfHashType_;
    private HmacParams hmacParams_;

    private AesCtrHmacStreamingParams() {
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
    public int getCiphertextSegmentSize() {
        return this.ciphertextSegmentSize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCiphertextSegmentSize(int value) {
        this.ciphertextSegmentSize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCiphertextSegmentSize() {
        this.ciphertextSegmentSize_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
    public int getDerivedKeySize() {
        return this.derivedKeySize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDerivedKeySize(int value) {
        this.derivedKeySize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDerivedKeySize() {
        this.derivedKeySize_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
    public int getHkdfHashTypeValue() {
        return this.hkdfHashType_;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
    public HashType getHkdfHashType() {
        HashType forNumber = HashType.forNumber(this.hkdfHashType_);
        return forNumber == null ? HashType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHkdfHashTypeValue(int value) {
        this.hkdfHashType_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHkdfHashType(HashType value) {
        this.hkdfHashType_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHkdfHashType() {
        this.hkdfHashType_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
    public boolean hasHmacParams() {
        return this.hmacParams_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
    public HmacParams getHmacParams() {
        HmacParams hmacParams = this.hmacParams_;
        return hmacParams == null ? HmacParams.getDefaultInstance() : hmacParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHmacParams(HmacParams value) {
        value.getClass();
        this.hmacParams_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeHmacParams(HmacParams value) {
        value.getClass();
        HmacParams hmacParams = this.hmacParams_;
        if (hmacParams != null && hmacParams != HmacParams.getDefaultInstance()) {
            this.hmacParams_ = HmacParams.newBuilder(this.hmacParams_).mergeFrom((HmacParams.Builder) value).buildPartial();
        } else {
            this.hmacParams_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHmacParams() {
        this.hmacParams_ = null;
    }

    public static AesCtrHmacStreamingParams parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacStreamingParams parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacStreamingParams parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacStreamingParams parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacStreamingParams parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrHmacStreamingParams parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrHmacStreamingParams parseFrom(InputStream input) throws IOException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacStreamingParams parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrHmacStreamingParams parseDelimitedFrom(InputStream input) throws IOException {
        return (AesCtrHmacStreamingParams) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacStreamingParams parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacStreamingParams) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrHmacStreamingParams parseFrom(CodedInputStream input) throws IOException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrHmacStreamingParams parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrHmacStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCtrHmacStreamingParams prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrHmacStreamingParams, Builder> implements AesCtrHmacStreamingParamsOrBuilder {
        /* synthetic */ Builder(C05881 c05881) {
            this();
        }

        private Builder() {
            super(AesCtrHmacStreamingParams.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
        public int getCiphertextSegmentSize() {
            return ((AesCtrHmacStreamingParams) this.instance).getCiphertextSegmentSize();
        }

        public Builder setCiphertextSegmentSize(int value) {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).setCiphertextSegmentSize(value);
            return this;
        }

        public Builder clearCiphertextSegmentSize() {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).clearCiphertextSegmentSize();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
        public int getDerivedKeySize() {
            return ((AesCtrHmacStreamingParams) this.instance).getDerivedKeySize();
        }

        public Builder setDerivedKeySize(int value) {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).setDerivedKeySize(value);
            return this;
        }

        public Builder clearDerivedKeySize() {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).clearDerivedKeySize();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
        public int getHkdfHashTypeValue() {
            return ((AesCtrHmacStreamingParams) this.instance).getHkdfHashTypeValue();
        }

        public Builder setHkdfHashTypeValue(int value) {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).setHkdfHashTypeValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
        public HashType getHkdfHashType() {
            return ((AesCtrHmacStreamingParams) this.instance).getHkdfHashType();
        }

        public Builder setHkdfHashType(HashType value) {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).setHkdfHashType(value);
            return this;
        }

        public Builder clearHkdfHashType() {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).clearHkdfHashType();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
        public boolean hasHmacParams() {
            return ((AesCtrHmacStreamingParams) this.instance).hasHmacParams();
        }

        @Override // com.google.crypto.tink.proto.AesCtrHmacStreamingParamsOrBuilder
        public HmacParams getHmacParams() {
            return ((AesCtrHmacStreamingParams) this.instance).getHmacParams();
        }

        public Builder setHmacParams(HmacParams value) {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).setHmacParams(value);
            return this;
        }

        public Builder setHmacParams(HmacParams.Builder builderForValue) {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).setHmacParams(builderForValue.build());
            return this;
        }

        public Builder mergeHmacParams(HmacParams value) {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).mergeHmacParams(value);
            return this;
        }

        public Builder clearHmacParams() {
            copyOnWrite();
            ((AesCtrHmacStreamingParams) this.instance).clearHmacParams();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCtrHmacStreamingParams$1 */
    static /* synthetic */ class C05881 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f120xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f120xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f120xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f120xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f120xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f120xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f120xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f120xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05881 c05881 = null;
        switch (C05881.f120xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesCtrHmacStreamingParams();
            case 2:
                return new Builder(c05881);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\f\u0004\t", new Object[]{"ciphertextSegmentSize_", "derivedKeySize_", "hkdfHashType_", "hmacParams_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCtrHmacStreamingParams> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCtrHmacStreamingParams.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesCtrHmacStreamingParams aesCtrHmacStreamingParams = new AesCtrHmacStreamingParams();
        DEFAULT_INSTANCE = aesCtrHmacStreamingParams;
        GeneratedMessageLite.registerDefaultInstance(AesCtrHmacStreamingParams.class, aesCtrHmacStreamingParams);
    }

    public static AesCtrHmacStreamingParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCtrHmacStreamingParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrHmacStreamingParamsOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCtrHmacStreamingParamsOrBuilder extends MessageLiteOrBuilder {
    int getCiphertextSegmentSize();

    int getDerivedKeySize();

    HashType getHkdfHashType();

    int getHkdfHashTypeValue();

    HmacParams getHmacParams();

    boolean hasHmacParams();
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesCtrKey extends GeneratedMessageLite<AesCtrKey, Builder> implements AesCtrKeyOrBuilder {
    private static final AesCtrKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<AesCtrKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private AesCtrParams params_;
    private int version_;

    private AesCtrKey() {
    }

    @Override // com.google.crypto.tink.proto.AesCtrKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesCtrKeyOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrKeyOrBuilder
    public AesCtrParams getParams() {
        AesCtrParams aesCtrParams = this.params_;
        return aesCtrParams == null ? AesCtrParams.getDefaultInstance() : aesCtrParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(AesCtrParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(AesCtrParams value) {
        value.getClass();
        AesCtrParams aesCtrParams = this.params_;
        if (aesCtrParams != null && aesCtrParams != AesCtrParams.getDefaultInstance()) {
            this.params_ = AesCtrParams.newBuilder(this.params_).mergeFrom((AesCtrParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static AesCtrKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesCtrKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesCtrKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesCtrKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrKey parseFrom(InputStream input) throws IOException {
        return (AesCtrKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrKey parseDelimitedFrom(InputStream input) throws IOException {
        return (AesCtrKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrKey parseFrom(CodedInputStream input) throws IOException {
        return (AesCtrKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCtrKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrKey, Builder> implements AesCtrKeyOrBuilder {
        /* synthetic */ Builder(C05891 c05891) {
            this();
        }

        private Builder() {
            super(AesCtrKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesCtrKeyOrBuilder
        public int getVersion() {
            return ((AesCtrKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesCtrKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesCtrKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCtrKeyOrBuilder
        public boolean hasParams() {
            return ((AesCtrKey) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.AesCtrKeyOrBuilder
        public AesCtrParams getParams() {
            return ((AesCtrKey) this.instance).getParams();
        }

        public Builder setParams(AesCtrParams value) {
            copyOnWrite();
            ((AesCtrKey) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(AesCtrParams.Builder builderForValue) {
            copyOnWrite();
            ((AesCtrKey) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(AesCtrParams value) {
            copyOnWrite();
            ((AesCtrKey) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((AesCtrKey) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCtrKeyOrBuilder
        public ByteString getKeyValue() {
            return ((AesCtrKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((AesCtrKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((AesCtrKey) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCtrKey$1 */
    static /* synthetic */ class C05891 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f121xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f121xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f121xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f121xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f121xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f121xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f121xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f121xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05891 c05891 = null;
        switch (C05891.f121xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesCtrKey();
            case 2:
                return new Builder(c05891);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCtrKey> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCtrKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesCtrKey aesCtrKey = new AesCtrKey();
        DEFAULT_INSTANCE = aesCtrKey;
        GeneratedMessageLite.registerDefaultInstance(AesCtrKey.class, aesCtrKey);
    }

    public static AesCtrKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCtrKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesCtrKeyFormat extends GeneratedMessageLite<AesCtrKeyFormat, Builder> implements AesCtrKeyFormatOrBuilder {
    private static final AesCtrKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<AesCtrKeyFormat> PARSER;
    private int keySize_;
    private AesCtrParams params_;

    private AesCtrKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.AesCtrKeyFormatOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrKeyFormatOrBuilder
    public AesCtrParams getParams() {
        AesCtrParams aesCtrParams = this.params_;
        return aesCtrParams == null ? AesCtrParams.getDefaultInstance() : aesCtrParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(AesCtrParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(AesCtrParams value) {
        value.getClass();
        AesCtrParams aesCtrParams = this.params_;
        if (aesCtrParams != null && aesCtrParams != AesCtrParams.getDefaultInstance()) {
            this.params_ = AesCtrParams.newBuilder(this.params_).mergeFrom((AesCtrParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.AesCtrKeyFormatOrBuilder
    public int getKeySize() {
        return this.keySize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeySize(int value) {
        this.keySize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    public static AesCtrKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesCtrKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesCtrKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesCtrKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrKeyFormat parseFrom(InputStream input) throws IOException {
        return (AesCtrKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (AesCtrKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (AesCtrKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCtrKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrKeyFormat, Builder> implements AesCtrKeyFormatOrBuilder {
        /* synthetic */ Builder(C05901 c05901) {
            this();
        }

        private Builder() {
            super(AesCtrKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesCtrKeyFormatOrBuilder
        public boolean hasParams() {
            return ((AesCtrKeyFormat) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.AesCtrKeyFormatOrBuilder
        public AesCtrParams getParams() {
            return ((AesCtrKeyFormat) this.instance).getParams();
        }

        public Builder setParams(AesCtrParams value) {
            copyOnWrite();
            ((AesCtrKeyFormat) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(AesCtrParams.Builder builderForValue) {
            copyOnWrite();
            ((AesCtrKeyFormat) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(AesCtrParams value) {
            copyOnWrite();
            ((AesCtrKeyFormat) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((AesCtrKeyFormat) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesCtrKeyFormatOrBuilder
        public int getKeySize() {
            return ((AesCtrKeyFormat) this.instance).getKeySize();
        }

        public Builder setKeySize(int value) {
            copyOnWrite();
            ((AesCtrKeyFormat) this.instance).setKeySize(value);
            return this;
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((AesCtrKeyFormat) this.instance).clearKeySize();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCtrKeyFormat$1 */
    static /* synthetic */ class C05901 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f122xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f122xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f122xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f122xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f122xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f122xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f122xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f122xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05901 c05901 = null;
        switch (C05901.f122xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesCtrKeyFormat();
            case 2:
                return new Builder(c05901);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"params_", "keySize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCtrKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCtrKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesCtrKeyFormat aesCtrKeyFormat = new AesCtrKeyFormat();
        DEFAULT_INSTANCE = aesCtrKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(AesCtrKeyFormat.class, aesCtrKeyFormat);
    }

    public static AesCtrKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCtrKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCtrKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    AesCtrParams getParams();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCtrKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    AesCtrParams getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrParams.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesCtrParams extends GeneratedMessageLite<AesCtrParams, Builder> implements AesCtrParamsOrBuilder {
    private static final AesCtrParams DEFAULT_INSTANCE;
    public static final int IV_SIZE_FIELD_NUMBER = 1;
    private static volatile Parser<AesCtrParams> PARSER;
    private int ivSize_;

    private AesCtrParams() {
    }

    @Override // com.google.crypto.tink.proto.AesCtrParamsOrBuilder
    public int getIvSize() {
        return this.ivSize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIvSize(int value) {
        this.ivSize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIvSize() {
        this.ivSize_ = 0;
    }

    public static AesCtrParams parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesCtrParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrParams parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrParams parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesCtrParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrParams parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrParams parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesCtrParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesCtrParams parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesCtrParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesCtrParams parseFrom(InputStream input) throws IOException {
        return (AesCtrParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrParams parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrParams parseDelimitedFrom(InputStream input) throws IOException {
        return (AesCtrParams) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrParams parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrParams) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesCtrParams parseFrom(CodedInputStream input) throws IOException {
        return (AesCtrParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesCtrParams parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesCtrParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesCtrParams prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesCtrParams, Builder> implements AesCtrParamsOrBuilder {
        /* synthetic */ Builder(C05911 c05911) {
            this();
        }

        private Builder() {
            super(AesCtrParams.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesCtrParamsOrBuilder
        public int getIvSize() {
            return ((AesCtrParams) this.instance).getIvSize();
        }

        public Builder setIvSize(int value) {
            copyOnWrite();
            ((AesCtrParams) this.instance).setIvSize(value);
            return this;
        }

        public Builder clearIvSize() {
            copyOnWrite();
            ((AesCtrParams) this.instance).clearIvSize();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCtrParams$1 */
    static /* synthetic */ class C05911 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f123xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f123xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f123xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f123xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f123xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f123xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f123xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f123xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05911 c05911 = null;
        switch (C05911.f123xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesCtrParams();
            case 2:
                return new Builder(c05911);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"ivSize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesCtrParams> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCtrParams.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesCtrParams aesCtrParams = new AesCtrParams();
        DEFAULT_INSTANCE = aesCtrParams;
        GeneratedMessageLite.registerDefaultInstance(AesCtrParams.class, aesCtrParams);
    }

    public static AesCtrParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesCtrParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesCtrParamsOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCtrParamsOrBuilder extends MessageLiteOrBuilder {
    int getIvSize();
}

// ===== FILE: com/google/crypto/tink/proto/AesEax.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class AesEax {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private AesEax() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesEaxKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesEaxParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesEaxKey extends GeneratedMessageLite<AesEaxKey, Builder> implements AesEaxKeyOrBuilder {
    private static final AesEaxKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<AesEaxKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private AesEaxParams params_;
    private int version_;

    private AesEaxKey() {
    }

    @Override // com.google.crypto.tink.proto.AesEaxKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesEaxKeyOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesEaxKeyOrBuilder
    public AesEaxParams getParams() {
        AesEaxParams aesEaxParams = this.params_;
        return aesEaxParams == null ? AesEaxParams.getDefaultInstance() : aesEaxParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(AesEaxParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(AesEaxParams value) {
        value.getClass();
        AesEaxParams aesEaxParams = this.params_;
        if (aesEaxParams != null && aesEaxParams != AesEaxParams.getDefaultInstance()) {
            this.params_ = AesEaxParams.newBuilder(this.params_).mergeFrom((AesEaxParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.AesEaxKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static AesEaxKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesEaxKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesEaxKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesEaxKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesEaxKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesEaxKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesEaxKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesEaxKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesEaxKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesEaxKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesEaxKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesEaxKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesEaxKey parseFrom(InputStream input) throws IOException {
        return (AesEaxKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesEaxKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesEaxKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesEaxKey parseDelimitedFrom(InputStream input) throws IOException {
        return (AesEaxKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesEaxKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesEaxKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesEaxKey parseFrom(CodedInputStream input) throws IOException {
        return (AesEaxKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesEaxKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesEaxKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesEaxKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesEaxKey, Builder> implements AesEaxKeyOrBuilder {
        /* synthetic */ Builder(C05921 c05921) {
            this();
        }

        private Builder() {
            super(AesEaxKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesEaxKeyOrBuilder
        public int getVersion() {
            return ((AesEaxKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesEaxKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesEaxKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesEaxKeyOrBuilder
        public boolean hasParams() {
            return ((AesEaxKey) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.AesEaxKeyOrBuilder
        public AesEaxParams getParams() {
            return ((AesEaxKey) this.instance).getParams();
        }

        public Builder setParams(AesEaxParams value) {
            copyOnWrite();
            ((AesEaxKey) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(AesEaxParams.Builder builderForValue) {
            copyOnWrite();
            ((AesEaxKey) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(AesEaxParams value) {
            copyOnWrite();
            ((AesEaxKey) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((AesEaxKey) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesEaxKeyOrBuilder
        public ByteString getKeyValue() {
            return ((AesEaxKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((AesEaxKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((AesEaxKey) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesEaxKey$1 */
    static /* synthetic */ class C05921 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f124xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f124xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f124xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f124xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f124xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f124xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f124xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f124xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05921 c05921 = null;
        switch (C05921.f124xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesEaxKey();
            case 2:
                return new Builder(c05921);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesEaxKey> parser = PARSER;
                if (parser == null) {
                    synchronized (AesEaxKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesEaxKey aesEaxKey = new AesEaxKey();
        DEFAULT_INSTANCE = aesEaxKey;
        GeneratedMessageLite.registerDefaultInstance(AesEaxKey.class, aesEaxKey);
    }

    public static AesEaxKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesEaxKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesEaxKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesEaxParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesEaxKeyFormat extends GeneratedMessageLite<AesEaxKeyFormat, Builder> implements AesEaxKeyFormatOrBuilder {
    private static final AesEaxKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<AesEaxKeyFormat> PARSER;
    private int keySize_;
    private AesEaxParams params_;

    private AesEaxKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.AesEaxKeyFormatOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesEaxKeyFormatOrBuilder
    public AesEaxParams getParams() {
        AesEaxParams aesEaxParams = this.params_;
        return aesEaxParams == null ? AesEaxParams.getDefaultInstance() : aesEaxParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(AesEaxParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(AesEaxParams value) {
        value.getClass();
        AesEaxParams aesEaxParams = this.params_;
        if (aesEaxParams != null && aesEaxParams != AesEaxParams.getDefaultInstance()) {
            this.params_ = AesEaxParams.newBuilder(this.params_).mergeFrom((AesEaxParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.AesEaxKeyFormatOrBuilder
    public int getKeySize() {
        return this.keySize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeySize(int value) {
        this.keySize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    public static AesEaxKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesEaxKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesEaxKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesEaxKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesEaxKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesEaxKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesEaxKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesEaxKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesEaxKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesEaxKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesEaxKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesEaxKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesEaxKeyFormat parseFrom(InputStream input) throws IOException {
        return (AesEaxKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesEaxKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesEaxKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesEaxKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (AesEaxKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesEaxKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesEaxKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesEaxKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (AesEaxKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesEaxKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesEaxKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesEaxKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesEaxKeyFormat, Builder> implements AesEaxKeyFormatOrBuilder {
        /* synthetic */ Builder(C05931 c05931) {
            this();
        }

        private Builder() {
            super(AesEaxKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesEaxKeyFormatOrBuilder
        public boolean hasParams() {
            return ((AesEaxKeyFormat) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.AesEaxKeyFormatOrBuilder
        public AesEaxParams getParams() {
            return ((AesEaxKeyFormat) this.instance).getParams();
        }

        public Builder setParams(AesEaxParams value) {
            copyOnWrite();
            ((AesEaxKeyFormat) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(AesEaxParams.Builder builderForValue) {
            copyOnWrite();
            ((AesEaxKeyFormat) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(AesEaxParams value) {
            copyOnWrite();
            ((AesEaxKeyFormat) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((AesEaxKeyFormat) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesEaxKeyFormatOrBuilder
        public int getKeySize() {
            return ((AesEaxKeyFormat) this.instance).getKeySize();
        }

        public Builder setKeySize(int value) {
            copyOnWrite();
            ((AesEaxKeyFormat) this.instance).setKeySize(value);
            return this;
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((AesEaxKeyFormat) this.instance).clearKeySize();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesEaxKeyFormat$1 */
    static /* synthetic */ class C05931 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f125xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f125xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f125xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f125xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f125xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f125xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f125xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f125xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05931 c05931 = null;
        switch (C05931.f125xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesEaxKeyFormat();
            case 2:
                return new Builder(c05931);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"params_", "keySize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesEaxKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (AesEaxKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesEaxKeyFormat aesEaxKeyFormat = new AesEaxKeyFormat();
        DEFAULT_INSTANCE = aesEaxKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(AesEaxKeyFormat.class, aesEaxKeyFormat);
    }

    public static AesEaxKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesEaxKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesEaxKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesEaxKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    AesEaxParams getParams();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/AesEaxKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesEaxKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    AesEaxParams getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/AesEaxParams.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesEaxParams extends GeneratedMessageLite<AesEaxParams, Builder> implements AesEaxParamsOrBuilder {
    private static final AesEaxParams DEFAULT_INSTANCE;
    public static final int IV_SIZE_FIELD_NUMBER = 1;
    private static volatile Parser<AesEaxParams> PARSER;
    private int ivSize_;

    private AesEaxParams() {
    }

    @Override // com.google.crypto.tink.proto.AesEaxParamsOrBuilder
    public int getIvSize() {
        return this.ivSize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIvSize(int value) {
        this.ivSize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIvSize() {
        this.ivSize_ = 0;
    }

    public static AesEaxParams parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesEaxParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesEaxParams parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesEaxParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesEaxParams parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesEaxParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesEaxParams parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesEaxParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesEaxParams parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesEaxParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesEaxParams parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesEaxParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesEaxParams parseFrom(InputStream input) throws IOException {
        return (AesEaxParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesEaxParams parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesEaxParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesEaxParams parseDelimitedFrom(InputStream input) throws IOException {
        return (AesEaxParams) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesEaxParams parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesEaxParams) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesEaxParams parseFrom(CodedInputStream input) throws IOException {
        return (AesEaxParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesEaxParams parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesEaxParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesEaxParams prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesEaxParams, Builder> implements AesEaxParamsOrBuilder {
        /* synthetic */ Builder(C05941 c05941) {
            this();
        }

        private Builder() {
            super(AesEaxParams.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesEaxParamsOrBuilder
        public int getIvSize() {
            return ((AesEaxParams) this.instance).getIvSize();
        }

        public Builder setIvSize(int value) {
            copyOnWrite();
            ((AesEaxParams) this.instance).setIvSize(value);
            return this;
        }

        public Builder clearIvSize() {
            copyOnWrite();
            ((AesEaxParams) this.instance).clearIvSize();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesEaxParams$1 */
    static /* synthetic */ class C05941 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f126xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f126xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f126xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f126xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f126xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f126xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f126xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f126xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05941 c05941 = null;
        switch (C05941.f126xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesEaxParams();
            case 2:
                return new Builder(c05941);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"ivSize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesEaxParams> parser = PARSER;
                if (parser == null) {
                    synchronized (AesEaxParams.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesEaxParams aesEaxParams = new AesEaxParams();
        DEFAULT_INSTANCE = aesEaxParams;
        GeneratedMessageLite.registerDefaultInstance(AesEaxParams.class, aesEaxParams);
    }

    public static AesEaxParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesEaxParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesEaxParamsOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesEaxParamsOrBuilder extends MessageLiteOrBuilder {
    int getIvSize();
}

// ===== FILE: com/google/crypto/tink/proto/AesGcm.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class AesGcm {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private AesGcm() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmHkdfStreaming.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class AesGcmHkdfStreaming {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private AesGcmHkdfStreaming() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmHkdfStreamingKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesGcmHkdfStreamingKey extends GeneratedMessageLite<AesGcmHkdfStreamingKey, Builder> implements AesGcmHkdfStreamingKeyOrBuilder {
    private static final AesGcmHkdfStreamingKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<AesGcmHkdfStreamingKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private AesGcmHkdfStreamingParams params_;
    private int version_;

    private AesGcmHkdfStreamingKey() {
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyOrBuilder
    public AesGcmHkdfStreamingParams getParams() {
        AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams = this.params_;
        return aesGcmHkdfStreamingParams == null ? AesGcmHkdfStreamingParams.getDefaultInstance() : aesGcmHkdfStreamingParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(AesGcmHkdfStreamingParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(AesGcmHkdfStreamingParams value) {
        value.getClass();
        AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams = this.params_;
        if (aesGcmHkdfStreamingParams != null && aesGcmHkdfStreamingParams != AesGcmHkdfStreamingParams.getDefaultInstance()) {
            this.params_ = AesGcmHkdfStreamingParams.newBuilder(this.params_).mergeFrom((AesGcmHkdfStreamingParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static AesGcmHkdfStreamingKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmHkdfStreamingKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmHkdfStreamingKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmHkdfStreamingKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmHkdfStreamingKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmHkdfStreamingKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmHkdfStreamingKey parseFrom(InputStream input) throws IOException {
        return (AesGcmHkdfStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmHkdfStreamingKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmHkdfStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesGcmHkdfStreamingKey parseDelimitedFrom(InputStream input) throws IOException {
        return (AesGcmHkdfStreamingKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmHkdfStreamingKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmHkdfStreamingKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesGcmHkdfStreamingKey parseFrom(CodedInputStream input) throws IOException {
        return (AesGcmHkdfStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmHkdfStreamingKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmHkdfStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesGcmHkdfStreamingKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesGcmHkdfStreamingKey, Builder> implements AesGcmHkdfStreamingKeyOrBuilder {
        /* synthetic */ Builder(C05951 c05951) {
            this();
        }

        private Builder() {
            super(AesGcmHkdfStreamingKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyOrBuilder
        public int getVersion() {
            return ((AesGcmHkdfStreamingKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesGcmHkdfStreamingKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesGcmHkdfStreamingKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyOrBuilder
        public boolean hasParams() {
            return ((AesGcmHkdfStreamingKey) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyOrBuilder
        public AesGcmHkdfStreamingParams getParams() {
            return ((AesGcmHkdfStreamingKey) this.instance).getParams();
        }

        public Builder setParams(AesGcmHkdfStreamingParams value) {
            copyOnWrite();
            ((AesGcmHkdfStreamingKey) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(AesGcmHkdfStreamingParams.Builder builderForValue) {
            copyOnWrite();
            ((AesGcmHkdfStreamingKey) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(AesGcmHkdfStreamingParams value) {
            copyOnWrite();
            ((AesGcmHkdfStreamingKey) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((AesGcmHkdfStreamingKey) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyOrBuilder
        public ByteString getKeyValue() {
            return ((AesGcmHkdfStreamingKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((AesGcmHkdfStreamingKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((AesGcmHkdfStreamingKey) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesGcmHkdfStreamingKey$1 */
    static /* synthetic */ class C05951 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f127xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f127xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f127xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f127xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f127xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f127xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f127xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f127xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05951 c05951 = null;
        switch (C05951.f127xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesGcmHkdfStreamingKey();
            case 2:
                return new Builder(c05951);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesGcmHkdfStreamingKey> parser = PARSER;
                if (parser == null) {
                    synchronized (AesGcmHkdfStreamingKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesGcmHkdfStreamingKey aesGcmHkdfStreamingKey = new AesGcmHkdfStreamingKey();
        DEFAULT_INSTANCE = aesGcmHkdfStreamingKey;
        GeneratedMessageLite.registerDefaultInstance(AesGcmHkdfStreamingKey.class, aesGcmHkdfStreamingKey);
    }

    public static AesGcmHkdfStreamingKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesGcmHkdfStreamingKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmHkdfStreamingKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesGcmHkdfStreamingKeyFormat extends GeneratedMessageLite<AesGcmHkdfStreamingKeyFormat, Builder> implements AesGcmHkdfStreamingKeyFormatOrBuilder {
    private static final AesGcmHkdfStreamingKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<AesGcmHkdfStreamingKeyFormat> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private AesGcmHkdfStreamingParams params_;
    private int version_;

    private AesGcmHkdfStreamingKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormatOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormatOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormatOrBuilder
    public AesGcmHkdfStreamingParams getParams() {
        AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams = this.params_;
        return aesGcmHkdfStreamingParams == null ? AesGcmHkdfStreamingParams.getDefaultInstance() : aesGcmHkdfStreamingParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(AesGcmHkdfStreamingParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(AesGcmHkdfStreamingParams value) {
        value.getClass();
        AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams = this.params_;
        if (aesGcmHkdfStreamingParams != null && aesGcmHkdfStreamingParams != AesGcmHkdfStreamingParams.getDefaultInstance()) {
            this.params_ = AesGcmHkdfStreamingParams.newBuilder(this.params_).mergeFrom((AesGcmHkdfStreamingParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormatOrBuilder
    public int getKeySize() {
        return this.keySize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeySize(int value) {
        this.keySize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(InputStream input) throws IOException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesGcmHkdfStreamingKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (AesGcmHkdfStreamingKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmHkdfStreamingKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmHkdfStreamingKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmHkdfStreamingKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmHkdfStreamingKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesGcmHkdfStreamingKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesGcmHkdfStreamingKeyFormat, Builder> implements AesGcmHkdfStreamingKeyFormatOrBuilder {
        /* synthetic */ Builder(C05961 c05961) {
            this();
        }

        private Builder() {
            super(AesGcmHkdfStreamingKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormatOrBuilder
        public int getVersion() {
            return ((AesGcmHkdfStreamingKeyFormat) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesGcmHkdfStreamingKeyFormat) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesGcmHkdfStreamingKeyFormat) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormatOrBuilder
        public boolean hasParams() {
            return ((AesGcmHkdfStreamingKeyFormat) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormatOrBuilder
        public AesGcmHkdfStreamingParams getParams() {
            return ((AesGcmHkdfStreamingKeyFormat) this.instance).getParams();
        }

        public Builder setParams(AesGcmHkdfStreamingParams value) {
            copyOnWrite();
            ((AesGcmHkdfStreamingKeyFormat) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(AesGcmHkdfStreamingParams.Builder builderForValue) {
            copyOnWrite();
            ((AesGcmHkdfStreamingKeyFormat) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(AesGcmHkdfStreamingParams value) {
            copyOnWrite();
            ((AesGcmHkdfStreamingKeyFormat) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((AesGcmHkdfStreamingKeyFormat) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormatOrBuilder
        public int getKeySize() {
            return ((AesGcmHkdfStreamingKeyFormat) this.instance).getKeySize();
        }

        public Builder setKeySize(int value) {
            copyOnWrite();
            ((AesGcmHkdfStreamingKeyFormat) this.instance).setKeySize(value);
            return this;
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((AesGcmHkdfStreamingKeyFormat) this.instance).clearKeySize();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat$1 */
    static /* synthetic */ class C05961 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f128xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f128xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f128xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f128xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f128xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f128xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f128xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f128xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05961 c05961 = null;
        switch (C05961.f128xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesGcmHkdfStreamingKeyFormat();
            case 2:
                return new Builder(c05961);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"params_", "keySize_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesGcmHkdfStreamingKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (AesGcmHkdfStreamingKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesGcmHkdfStreamingKeyFormat aesGcmHkdfStreamingKeyFormat = new AesGcmHkdfStreamingKeyFormat();
        DEFAULT_INSTANCE = aesGcmHkdfStreamingKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(AesGcmHkdfStreamingKeyFormat.class, aesGcmHkdfStreamingKeyFormat);
    }

    public static AesGcmHkdfStreamingKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesGcmHkdfStreamingKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmHkdfStreamingKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesGcmHkdfStreamingKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    AesGcmHkdfStreamingParams getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmHkdfStreamingKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesGcmHkdfStreamingKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    AesGcmHkdfStreamingParams getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmHkdfStreamingParams.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesGcmHkdfStreamingParams extends GeneratedMessageLite<AesGcmHkdfStreamingParams, Builder> implements AesGcmHkdfStreamingParamsOrBuilder {
    public static final int CIPHERTEXT_SEGMENT_SIZE_FIELD_NUMBER = 1;
    private static final AesGcmHkdfStreamingParams DEFAULT_INSTANCE;
    public static final int DERIVED_KEY_SIZE_FIELD_NUMBER = 2;
    public static final int HKDF_HASH_TYPE_FIELD_NUMBER = 3;
    private static volatile Parser<AesGcmHkdfStreamingParams> PARSER;
    private int ciphertextSegmentSize_;
    private int derivedKeySize_;
    private int hkdfHashType_;

    private AesGcmHkdfStreamingParams() {
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingParamsOrBuilder
    public int getCiphertextSegmentSize() {
        return this.ciphertextSegmentSize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCiphertextSegmentSize(int value) {
        this.ciphertextSegmentSize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCiphertextSegmentSize() {
        this.ciphertextSegmentSize_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingParamsOrBuilder
    public int getDerivedKeySize() {
        return this.derivedKeySize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDerivedKeySize(int value) {
        this.derivedKeySize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDerivedKeySize() {
        this.derivedKeySize_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingParamsOrBuilder
    public int getHkdfHashTypeValue() {
        return this.hkdfHashType_;
    }

    @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingParamsOrBuilder
    public HashType getHkdfHashType() {
        HashType forNumber = HashType.forNumber(this.hkdfHashType_);
        return forNumber == null ? HashType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHkdfHashTypeValue(int value) {
        this.hkdfHashType_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHkdfHashType(HashType value) {
        this.hkdfHashType_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHkdfHashType() {
        this.hkdfHashType_ = 0;
    }

    public static AesGcmHkdfStreamingParams parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmHkdfStreamingParams parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmHkdfStreamingParams parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmHkdfStreamingParams parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmHkdfStreamingParams parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmHkdfStreamingParams parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmHkdfStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmHkdfStreamingParams parseFrom(InputStream input) throws IOException {
        return (AesGcmHkdfStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmHkdfStreamingParams parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmHkdfStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesGcmHkdfStreamingParams parseDelimitedFrom(InputStream input) throws IOException {
        return (AesGcmHkdfStreamingParams) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmHkdfStreamingParams parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmHkdfStreamingParams) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesGcmHkdfStreamingParams parseFrom(CodedInputStream input) throws IOException {
        return (AesGcmHkdfStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmHkdfStreamingParams parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmHkdfStreamingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesGcmHkdfStreamingParams prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesGcmHkdfStreamingParams, Builder> implements AesGcmHkdfStreamingParamsOrBuilder {
        /* synthetic */ Builder(C05971 c05971) {
            this();
        }

        private Builder() {
            super(AesGcmHkdfStreamingParams.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingParamsOrBuilder
        public int getCiphertextSegmentSize() {
            return ((AesGcmHkdfStreamingParams) this.instance).getCiphertextSegmentSize();
        }

        public Builder setCiphertextSegmentSize(int value) {
            copyOnWrite();
            ((AesGcmHkdfStreamingParams) this.instance).setCiphertextSegmentSize(value);
            return this;
        }

        public Builder clearCiphertextSegmentSize() {
            copyOnWrite();
            ((AesGcmHkdfStreamingParams) this.instance).clearCiphertextSegmentSize();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingParamsOrBuilder
        public int getDerivedKeySize() {
            return ((AesGcmHkdfStreamingParams) this.instance).getDerivedKeySize();
        }

        public Builder setDerivedKeySize(int value) {
            copyOnWrite();
            ((AesGcmHkdfStreamingParams) this.instance).setDerivedKeySize(value);
            return this;
        }

        public Builder clearDerivedKeySize() {
            copyOnWrite();
            ((AesGcmHkdfStreamingParams) this.instance).clearDerivedKeySize();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingParamsOrBuilder
        public int getHkdfHashTypeValue() {
            return ((AesGcmHkdfStreamingParams) this.instance).getHkdfHashTypeValue();
        }

        public Builder setHkdfHashTypeValue(int value) {
            copyOnWrite();
            ((AesGcmHkdfStreamingParams) this.instance).setHkdfHashTypeValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesGcmHkdfStreamingParamsOrBuilder
        public HashType getHkdfHashType() {
            return ((AesGcmHkdfStreamingParams) this.instance).getHkdfHashType();
        }

        public Builder setHkdfHashType(HashType value) {
            copyOnWrite();
            ((AesGcmHkdfStreamingParams) this.instance).setHkdfHashType(value);
            return this;
        }

        public Builder clearHkdfHashType() {
            copyOnWrite();
            ((AesGcmHkdfStreamingParams) this.instance).clearHkdfHashType();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesGcmHkdfStreamingParams$1 */
    static /* synthetic */ class C05971 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f129xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f129xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f129xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f129xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f129xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f129xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f129xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f129xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05971 c05971 = null;
        switch (C05971.f129xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesGcmHkdfStreamingParams();
            case 2:
                return new Builder(c05971);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\f", new Object[]{"ciphertextSegmentSize_", "derivedKeySize_", "hkdfHashType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesGcmHkdfStreamingParams> parser = PARSER;
                if (parser == null) {
                    synchronized (AesGcmHkdfStreamingParams.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesGcmHkdfStreamingParams aesGcmHkdfStreamingParams = new AesGcmHkdfStreamingParams();
        DEFAULT_INSTANCE = aesGcmHkdfStreamingParams;
        GeneratedMessageLite.registerDefaultInstance(AesGcmHkdfStreamingParams.class, aesGcmHkdfStreamingParams);
    }

    public static AesGcmHkdfStreamingParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesGcmHkdfStreamingParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmHkdfStreamingParamsOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesGcmHkdfStreamingParamsOrBuilder extends MessageLiteOrBuilder {
    int getCiphertextSegmentSize();

    int getDerivedKeySize();

    HashType getHkdfHashType();

    int getHkdfHashTypeValue();
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesGcmKey extends GeneratedMessageLite<AesGcmKey, Builder> implements AesGcmKeyOrBuilder {
    private static final AesGcmKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    private static volatile Parser<AesGcmKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private int version_;

    private AesGcmKey() {
    }

    @Override // com.google.crypto.tink.proto.AesGcmKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesGcmKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static AesGcmKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesGcmKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesGcmKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesGcmKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmKey parseFrom(InputStream input) throws IOException {
        return (AesGcmKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesGcmKey parseDelimitedFrom(InputStream input) throws IOException {
        return (AesGcmKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesGcmKey parseFrom(CodedInputStream input) throws IOException {
        return (AesGcmKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesGcmKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesGcmKey, Builder> implements AesGcmKeyOrBuilder {
        /* synthetic */ Builder(C05981 c05981) {
            this();
        }

        private Builder() {
            super(AesGcmKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesGcmKeyOrBuilder
        public int getVersion() {
            return ((AesGcmKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesGcmKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesGcmKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesGcmKeyOrBuilder
        public ByteString getKeyValue() {
            return ((AesGcmKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((AesGcmKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((AesGcmKey) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesGcmKey$1 */
    static /* synthetic */ class C05981 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f130xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f130xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f130xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f130xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f130xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f130xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f130xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f130xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05981 c05981 = null;
        switch (C05981.f130xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesGcmKey();
            case 2:
                return new Builder(c05981);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"version_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesGcmKey> parser = PARSER;
                if (parser == null) {
                    synchronized (AesGcmKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesGcmKey aesGcmKey = new AesGcmKey();
        DEFAULT_INSTANCE = aesGcmKey;
        GeneratedMessageLite.registerDefaultInstance(AesGcmKey.class, aesGcmKey);
    }

    public static AesGcmKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesGcmKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesGcmKeyFormat extends GeneratedMessageLite<AesGcmKeyFormat, Builder> implements AesGcmKeyFormatOrBuilder {
    private static final AesGcmKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    private static volatile Parser<AesGcmKeyFormat> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private int version_;

    private AesGcmKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.AesGcmKeyFormatOrBuilder
    public int getKeySize() {
        return this.keySize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeySize(int value) {
        this.keySize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesGcmKeyFormatOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static AesGcmKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesGcmKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesGcmKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesGcmKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmKeyFormat parseFrom(InputStream input) throws IOException {
        return (AesGcmKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesGcmKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (AesGcmKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesGcmKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (AesGcmKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesGcmKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesGcmKeyFormat, Builder> implements AesGcmKeyFormatOrBuilder {
        /* synthetic */ Builder(C05991 c05991) {
            this();
        }

        private Builder() {
            super(AesGcmKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesGcmKeyFormatOrBuilder
        public int getKeySize() {
            return ((AesGcmKeyFormat) this.instance).getKeySize();
        }

        public Builder setKeySize(int value) {
            copyOnWrite();
            ((AesGcmKeyFormat) this.instance).setKeySize(value);
            return this;
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((AesGcmKeyFormat) this.instance).clearKeySize();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesGcmKeyFormatOrBuilder
        public int getVersion() {
            return ((AesGcmKeyFormat) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesGcmKeyFormat) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesGcmKeyFormat) this.instance).clearVersion();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesGcmKeyFormat$1 */
    static /* synthetic */ class C05991 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f131xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f131xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f131xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f131xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f131xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f131xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f131xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f131xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C05991 c05991 = null;
        switch (C05991.f131xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesGcmKeyFormat();
            case 2:
                return new Builder(c05991);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"keySize_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesGcmKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (AesGcmKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesGcmKeyFormat aesGcmKeyFormat = new AesGcmKeyFormat();
        DEFAULT_INSTANCE = aesGcmKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(AesGcmKeyFormat.class, aesGcmKeyFormat);
    }

    public static AesGcmKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesGcmKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesGcmKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    int getVersion();
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesGcmKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    int getVersion();
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmSiv.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class AesGcmSiv {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private AesGcmSiv() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmSivKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesGcmSivKey extends GeneratedMessageLite<AesGcmSivKey, Builder> implements AesGcmSivKeyOrBuilder {
    private static final AesGcmSivKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    private static volatile Parser<AesGcmSivKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private int version_;

    private AesGcmSivKey() {
    }

    @Override // com.google.crypto.tink.proto.AesGcmSivKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesGcmSivKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static AesGcmSivKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesGcmSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmSivKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmSivKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesGcmSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmSivKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmSivKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesGcmSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmSivKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmSivKey parseFrom(InputStream input) throws IOException {
        return (AesGcmSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmSivKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesGcmSivKey parseDelimitedFrom(InputStream input) throws IOException {
        return (AesGcmSivKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmSivKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmSivKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesGcmSivKey parseFrom(CodedInputStream input) throws IOException {
        return (AesGcmSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmSivKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesGcmSivKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesGcmSivKey, Builder> implements AesGcmSivKeyOrBuilder {
        /* synthetic */ Builder(C06001 c06001) {
            this();
        }

        private Builder() {
            super(AesGcmSivKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesGcmSivKeyOrBuilder
        public int getVersion() {
            return ((AesGcmSivKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesGcmSivKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesGcmSivKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesGcmSivKeyOrBuilder
        public ByteString getKeyValue() {
            return ((AesGcmSivKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((AesGcmSivKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((AesGcmSivKey) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesGcmSivKey$1 */
    static /* synthetic */ class C06001 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f132xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f132xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f132xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f132xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f132xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f132xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f132xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f132xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06001 c06001 = null;
        switch (C06001.f132xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesGcmSivKey();
            case 2:
                return new Builder(c06001);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"version_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesGcmSivKey> parser = PARSER;
                if (parser == null) {
                    synchronized (AesGcmSivKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesGcmSivKey aesGcmSivKey = new AesGcmSivKey();
        DEFAULT_INSTANCE = aesGcmSivKey;
        GeneratedMessageLite.registerDefaultInstance(AesGcmSivKey.class, aesGcmSivKey);
    }

    public static AesGcmSivKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesGcmSivKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmSivKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesGcmSivKeyFormat extends GeneratedMessageLite<AesGcmSivKeyFormat, Builder> implements AesGcmSivKeyFormatOrBuilder {
    private static final AesGcmSivKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    private static volatile Parser<AesGcmSivKeyFormat> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private int keySize_;
    private int version_;

    private AesGcmSivKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.AesGcmSivKeyFormatOrBuilder
    public int getKeySize() {
        return this.keySize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeySize(int value) {
        this.keySize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesGcmSivKeyFormatOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static AesGcmSivKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesGcmSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmSivKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmSivKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesGcmSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmSivKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmSivKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesGcmSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesGcmSivKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesGcmSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesGcmSivKeyFormat parseFrom(InputStream input) throws IOException {
        return (AesGcmSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmSivKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesGcmSivKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (AesGcmSivKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmSivKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmSivKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesGcmSivKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (AesGcmSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesGcmSivKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesGcmSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesGcmSivKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesGcmSivKeyFormat, Builder> implements AesGcmSivKeyFormatOrBuilder {
        /* synthetic */ Builder(C06011 c06011) {
            this();
        }

        private Builder() {
            super(AesGcmSivKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesGcmSivKeyFormatOrBuilder
        public int getKeySize() {
            return ((AesGcmSivKeyFormat) this.instance).getKeySize();
        }

        public Builder setKeySize(int value) {
            copyOnWrite();
            ((AesGcmSivKeyFormat) this.instance).setKeySize(value);
            return this;
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((AesGcmSivKeyFormat) this.instance).clearKeySize();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesGcmSivKeyFormatOrBuilder
        public int getVersion() {
            return ((AesGcmSivKeyFormat) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesGcmSivKeyFormat) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesGcmSivKeyFormat) this.instance).clearVersion();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesGcmSivKeyFormat$1 */
    static /* synthetic */ class C06011 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f133xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f133xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f133xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f133xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f133xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f133xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f133xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f133xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06011 c06011 = null;
        switch (C06011.f133xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesGcmSivKeyFormat();
            case 2:
                return new Builder(c06011);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"version_", "keySize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesGcmSivKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (AesGcmSivKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesGcmSivKeyFormat aesGcmSivKeyFormat = new AesGcmSivKeyFormat();
        DEFAULT_INSTANCE = aesGcmSivKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(AesGcmSivKeyFormat.class, aesGcmSivKeyFormat);
    }

    public static AesGcmSivKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesGcmSivKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmSivKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesGcmSivKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    int getVersion();
}

// ===== FILE: com/google/crypto/tink/proto/AesGcmSivKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesGcmSivKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    int getVersion();
}

// ===== FILE: com/google/crypto/tink/proto/AesSiv.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class AesSiv {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private AesSiv() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesSivKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesSivKey extends GeneratedMessageLite<AesSivKey, Builder> implements AesSivKeyOrBuilder {
    private static final AesSivKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<AesSivKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private int version_;

    private AesSivKey() {
    }

    @Override // com.google.crypto.tink.proto.AesSivKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.AesSivKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static AesSivKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesSivKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesSivKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesSivKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesSivKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesSivKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesSivKey parseFrom(InputStream input) throws IOException {
        return (AesSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesSivKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesSivKey parseDelimitedFrom(InputStream input) throws IOException {
        return (AesSivKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesSivKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesSivKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesSivKey parseFrom(CodedInputStream input) throws IOException {
        return (AesSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesSivKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesSivKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesSivKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesSivKey, Builder> implements AesSivKeyOrBuilder {
        /* synthetic */ Builder(C06021 c06021) {
            this();
        }

        private Builder() {
            super(AesSivKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesSivKeyOrBuilder
        public int getVersion() {
            return ((AesSivKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((AesSivKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((AesSivKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.AesSivKeyOrBuilder
        public ByteString getKeyValue() {
            return ((AesSivKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((AesSivKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((AesSivKey) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesSivKey$1 */
    static /* synthetic */ class C06021 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f134xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f134xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f134xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f134xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f134xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f134xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f134xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f134xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06021 c06021 = null;
        switch (C06021.f134xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesSivKey();
            case 2:
                return new Builder(c06021);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"version_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesSivKey> parser = PARSER;
                if (parser == null) {
                    synchronized (AesSivKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesSivKey aesSivKey = new AesSivKey();
        DEFAULT_INSTANCE = aesSivKey;
        GeneratedMessageLite.registerDefaultInstance(AesSivKey.class, aesSivKey);
    }

    public static AesSivKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesSivKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesSivKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class AesSivKeyFormat extends GeneratedMessageLite<AesSivKeyFormat, Builder> implements AesSivKeyFormatOrBuilder {
    private static final AesSivKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 1;
    private static volatile Parser<AesSivKeyFormat> PARSER;
    private int keySize_;

    private AesSivKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.AesSivKeyFormatOrBuilder
    public int getKeySize() {
        return this.keySize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeySize(int value) {
        this.keySize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    public static AesSivKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (AesSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesSivKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesSivKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (AesSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesSivKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesSivKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (AesSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static AesSivKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (AesSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static AesSivKeyFormat parseFrom(InputStream input) throws IOException {
        return (AesSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesSivKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesSivKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (AesSivKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static AesSivKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesSivKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static AesSivKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (AesSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static AesSivKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (AesSivKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AesSivKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AesSivKeyFormat, Builder> implements AesSivKeyFormatOrBuilder {
        /* synthetic */ Builder(C06031 c06031) {
            this();
        }

        private Builder() {
            super(AesSivKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.AesSivKeyFormatOrBuilder
        public int getKeySize() {
            return ((AesSivKeyFormat) this.instance).getKeySize();
        }

        public Builder setKeySize(int value) {
            copyOnWrite();
            ((AesSivKeyFormat) this.instance).setKeySize(value);
            return this;
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((AesSivKeyFormat) this.instance).clearKeySize();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesSivKeyFormat$1 */
    static /* synthetic */ class C06031 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f135xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f135xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f135xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f135xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f135xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f135xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f135xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f135xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06031 c06031 = null;
        switch (C06031.f135xa1df5c61[method.ordinal()]) {
            case 1:
                return new AesSivKeyFormat();
            case 2:
                return new Builder(c06031);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"keySize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AesSivKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (AesSivKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        AesSivKeyFormat aesSivKeyFormat = new AesSivKeyFormat();
        DEFAULT_INSTANCE = aesSivKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(AesSivKeyFormat.class, aesSivKeyFormat);
    }

    public static AesSivKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AesSivKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/AesSivKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesSivKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();
}

// ===== FILE: com/google/crypto/tink/proto/AesSivKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesSivKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    int getVersion();
}

// ===== FILE: com/google/crypto/tink/proto/ChaCha20Poly1305Key.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class ChaCha20Poly1305Key extends GeneratedMessageLite<ChaCha20Poly1305Key, Builder> implements ChaCha20Poly1305KeyOrBuilder {
    private static final ChaCha20Poly1305Key DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<ChaCha20Poly1305Key> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private int version_;

    private ChaCha20Poly1305Key() {
    }

    @Override // com.google.crypto.tink.proto.ChaCha20Poly1305KeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.ChaCha20Poly1305KeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static ChaCha20Poly1305Key parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (ChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ChaCha20Poly1305Key parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ChaCha20Poly1305Key parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ChaCha20Poly1305Key parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ChaCha20Poly1305Key parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ChaCha20Poly1305Key parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ChaCha20Poly1305Key parseFrom(InputStream input) throws IOException {
        return (ChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ChaCha20Poly1305Key parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ChaCha20Poly1305Key parseDelimitedFrom(InputStream input) throws IOException {
        return (ChaCha20Poly1305Key) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ChaCha20Poly1305Key parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ChaCha20Poly1305Key) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ChaCha20Poly1305Key parseFrom(CodedInputStream input) throws IOException {
        return (ChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ChaCha20Poly1305Key parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(ChaCha20Poly1305Key prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ChaCha20Poly1305Key, Builder> implements ChaCha20Poly1305KeyOrBuilder {
        /* synthetic */ Builder(C06041 c06041) {
            this();
        }

        private Builder() {
            super(ChaCha20Poly1305Key.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.ChaCha20Poly1305KeyOrBuilder
        public int getVersion() {
            return ((ChaCha20Poly1305Key) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((ChaCha20Poly1305Key) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((ChaCha20Poly1305Key) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.ChaCha20Poly1305KeyOrBuilder
        public ByteString getKeyValue() {
            return ((ChaCha20Poly1305Key) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((ChaCha20Poly1305Key) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((ChaCha20Poly1305Key) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.ChaCha20Poly1305Key$1 */
    static /* synthetic */ class C06041 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f136xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f136xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f136xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f136xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f136xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f136xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f136xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f136xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06041 c06041 = null;
        switch (C06041.f136xa1df5c61[method.ordinal()]) {
            case 1:
                return new ChaCha20Poly1305Key();
            case 2:
                return new Builder(c06041);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"version_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ChaCha20Poly1305Key> parser = PARSER;
                if (parser == null) {
                    synchronized (ChaCha20Poly1305Key.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        ChaCha20Poly1305Key chaCha20Poly1305Key = new ChaCha20Poly1305Key();
        DEFAULT_INSTANCE = chaCha20Poly1305Key;
        GeneratedMessageLite.registerDefaultInstance(ChaCha20Poly1305Key.class, chaCha20Poly1305Key);
    }

    public static ChaCha20Poly1305Key getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ChaCha20Poly1305Key> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/ChaCha20Poly1305KeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class ChaCha20Poly1305KeyFormat extends GeneratedMessageLite<ChaCha20Poly1305KeyFormat, Builder> implements ChaCha20Poly1305KeyFormatOrBuilder {
    private static final ChaCha20Poly1305KeyFormat DEFAULT_INSTANCE;
    private static volatile Parser<ChaCha20Poly1305KeyFormat> PARSER;

    private ChaCha20Poly1305KeyFormat() {
    }

    public static ChaCha20Poly1305KeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (ChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ChaCha20Poly1305KeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ChaCha20Poly1305KeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (ChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ChaCha20Poly1305KeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ChaCha20Poly1305KeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (ChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static ChaCha20Poly1305KeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (ChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static ChaCha20Poly1305KeyFormat parseFrom(InputStream input) throws IOException {
        return (ChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ChaCha20Poly1305KeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ChaCha20Poly1305KeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (ChaCha20Poly1305KeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static ChaCha20Poly1305KeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ChaCha20Poly1305KeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static ChaCha20Poly1305KeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (ChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static ChaCha20Poly1305KeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (ChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(ChaCha20Poly1305KeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ChaCha20Poly1305KeyFormat, Builder> implements ChaCha20Poly1305KeyFormatOrBuilder {
        /* synthetic */ Builder(C06051 c06051) {
            this();
        }

        private Builder() {
            super(ChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: com.google.crypto.tink.proto.ChaCha20Poly1305KeyFormat$1 */
    static /* synthetic */ class C06051 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f137xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f137xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f137xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f137xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f137xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f137xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f137xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f137xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06051 c06051 = null;
        switch (C06051.f137xa1df5c61[method.ordinal()]) {
            case 1:
                return new ChaCha20Poly1305KeyFormat();
            case 2:
                return new Builder(c06051);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ChaCha20Poly1305KeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (ChaCha20Poly1305KeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        ChaCha20Poly1305KeyFormat chaCha20Poly1305KeyFormat = new ChaCha20Poly1305KeyFormat();
        DEFAULT_INSTANCE = chaCha20Poly1305KeyFormat;
        GeneratedMessageLite.registerDefaultInstance(ChaCha20Poly1305KeyFormat.class, chaCha20Poly1305KeyFormat);
    }

    public static ChaCha20Poly1305KeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ChaCha20Poly1305KeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/ChaCha20Poly1305KeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface ChaCha20Poly1305KeyFormatOrBuilder extends MessageLiteOrBuilder {
}

// ===== FILE: com/google/crypto/tink/proto/ChaCha20Poly1305KeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface ChaCha20Poly1305KeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    int getVersion();
}

// ===== FILE: com/google/crypto/tink/proto/Chacha20Poly1305.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class Chacha20Poly1305 {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private Chacha20Poly1305() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/Common.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class Common {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private Common() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/Config.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class Config {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private Config() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/EcPointFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* loaded from: classes.dex */
public enum EcPointFormat implements Internal.EnumLite {
    UNKNOWN_FORMAT(0),
    UNCOMPRESSED(1),
    COMPRESSED(2),
    DO_NOT_USE_CRUNCHY_UNCOMPRESSED(3),
    UNRECOGNIZED(-1);

    public static final int COMPRESSED_VALUE = 2;
    public static final int DO_NOT_USE_CRUNCHY_UNCOMPRESSED_VALUE = 3;
    public static final int UNCOMPRESSED_VALUE = 1;
    public static final int UNKNOWN_FORMAT_VALUE = 0;
    private static final Internal.EnumLiteMap<EcPointFormat> internalValueMap = new Internal.EnumLiteMap<EcPointFormat>() { // from class: com.google.crypto.tink.proto.EcPointFormat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public EcPointFormat findValueByNumber(int number) {
            return EcPointFormat.forNumber(number);
        }
    };
    private final int value;

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static EcPointFormat valueOf(int value) {
        return forNumber(value);
    }

    public static EcPointFormat forNumber(int value) {
        if (value == 0) {
            return UNKNOWN_FORMAT;
        }
        if (value == 1) {
            return UNCOMPRESSED;
        }
        if (value == 2) {
            return COMPRESSED;
        }
        if (value != 3) {
            return null;
        }
        return DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
    }

    public static Internal.EnumLiteMap<EcPointFormat> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EcPointFormatVerifier.INSTANCE;
    }

    private static final class EcPointFormatVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new EcPointFormatVerifier();

        private EcPointFormatVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            return EcPointFormat.forNumber(number) != null;
        }
    }

    EcPointFormat(int value) {
        this.value = value;
    }
}

// ===== FILE: com/google/crypto/tink/proto/Ecdsa.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class Ecdsa {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private Ecdsa() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/EcdsaKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.EcdsaParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class EcdsaKeyFormat extends GeneratedMessageLite<EcdsaKeyFormat, Builder> implements EcdsaKeyFormatOrBuilder {
    private static final EcdsaKeyFormat DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<EcdsaKeyFormat> PARSER;
    private EcdsaParams params_;

    private EcdsaKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.EcdsaKeyFormatOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.EcdsaKeyFormatOrBuilder
    public EcdsaParams getParams() {
        EcdsaParams ecdsaParams = this.params_;
        return ecdsaParams == null ? EcdsaParams.getDefaultInstance() : ecdsaParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(EcdsaParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(EcdsaParams value) {
        value.getClass();
        EcdsaParams ecdsaParams = this.params_;
        if (ecdsaParams != null && ecdsaParams != EcdsaParams.getDefaultInstance()) {
            this.params_ = EcdsaParams.newBuilder(this.params_).mergeFrom((EcdsaParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    public static EcdsaKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (EcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EcdsaKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EcdsaKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (EcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EcdsaKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EcdsaKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (EcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EcdsaKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EcdsaKeyFormat parseFrom(InputStream input) throws IOException {
        return (EcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EcdsaKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EcdsaKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (EcdsaKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static EcdsaKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EcdsaKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EcdsaKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (EcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EcdsaKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EcdsaKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(EcdsaKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EcdsaKeyFormat, Builder> implements EcdsaKeyFormatOrBuilder {
        /* synthetic */ Builder(C06071 c06071) {
            this();
        }

        private Builder() {
            super(EcdsaKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.EcdsaKeyFormatOrBuilder
        public boolean hasParams() {
            return ((EcdsaKeyFormat) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.EcdsaKeyFormatOrBuilder
        public EcdsaParams getParams() {
            return ((EcdsaKeyFormat) this.instance).getParams();
        }

        public Builder setParams(EcdsaParams value) {
            copyOnWrite();
            ((EcdsaKeyFormat) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(EcdsaParams.Builder builderForValue) {
            copyOnWrite();
            ((EcdsaKeyFormat) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(EcdsaParams value) {
            copyOnWrite();
            ((EcdsaKeyFormat) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((EcdsaKeyFormat) this.instance).clearParams();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.EcdsaKeyFormat$1 */
    static /* synthetic */ class C06071 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f138xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f138xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f138xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f138xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f138xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f138xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f138xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f138xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06071 c06071 = null;
        switch (C06071.f138xa1df5c61[method.ordinal()]) {
            case 1:
                return new EcdsaKeyFormat();
            case 2:
                return new Builder(c06071);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"params_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EcdsaKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (EcdsaKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        EcdsaKeyFormat ecdsaKeyFormat = new EcdsaKeyFormat();
        DEFAULT_INSTANCE = ecdsaKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(EcdsaKeyFormat.class, ecdsaKeyFormat);
    }

    public static EcdsaKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<EcdsaKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/EcdsaKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface EcdsaKeyFormatOrBuilder extends MessageLiteOrBuilder {
    EcdsaParams getParams();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/EcdsaParams.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class EcdsaParams extends GeneratedMessageLite<EcdsaParams, Builder> implements EcdsaParamsOrBuilder {
    public static final int CURVE_FIELD_NUMBER = 2;
    private static final EcdsaParams DEFAULT_INSTANCE;
    public static final int ENCODING_FIELD_NUMBER = 3;
    public static final int HASH_TYPE_FIELD_NUMBER = 1;
    private static volatile Parser<EcdsaParams> PARSER;
    private int curve_;
    private int encoding_;
    private int hashType_;

    private EcdsaParams() {
    }

    @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
    public int getHashTypeValue() {
        return this.hashType_;
    }

    @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
    public HashType getHashType() {
        HashType forNumber = HashType.forNumber(this.hashType_);
        return forNumber == null ? HashType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHashTypeValue(int value) {
        this.hashType_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHashType(HashType value) {
        this.hashType_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHashType() {
        this.hashType_ = 0;
    }

    @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
    public int getCurveValue() {
        return this.curve_;
    }

    @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
    public EllipticCurveType getCurve() {
        EllipticCurveType forNumber = EllipticCurveType.forNumber(this.curve_);
        return forNumber == null ? EllipticCurveType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurveValue(int value) {
        this.curve_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurve(EllipticCurveType value) {
        this.curve_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCurve() {
        this.curve_ = 0;
    }

    @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
    public int getEncodingValue() {
        return this.encoding_;
    }

    @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
    public EcdsaSignatureEncoding getEncoding() {
        EcdsaSignatureEncoding forNumber = EcdsaSignatureEncoding.forNumber(this.encoding_);
        return forNumber == null ? EcdsaSignatureEncoding.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEncodingValue(int value) {
        this.encoding_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEncoding(EcdsaSignatureEncoding value) {
        this.encoding_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEncoding() {
        this.encoding_ = 0;
    }

    public static EcdsaParams parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EcdsaParams parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EcdsaParams parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EcdsaParams parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EcdsaParams parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EcdsaParams parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EcdsaParams parseFrom(InputStream input) throws IOException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EcdsaParams parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EcdsaParams parseDelimitedFrom(InputStream input) throws IOException {
        return (EcdsaParams) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static EcdsaParams parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EcdsaParams) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EcdsaParams parseFrom(CodedInputStream input) throws IOException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EcdsaParams parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EcdsaParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(EcdsaParams prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EcdsaParams, Builder> implements EcdsaParamsOrBuilder {
        /* synthetic */ Builder(C06081 c06081) {
            this();
        }

        private Builder() {
            super(EcdsaParams.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
        public int getHashTypeValue() {
            return ((EcdsaParams) this.instance).getHashTypeValue();
        }

        public Builder setHashTypeValue(int value) {
            copyOnWrite();
            ((EcdsaParams) this.instance).setHashTypeValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
        public HashType getHashType() {
            return ((EcdsaParams) this.instance).getHashType();
        }

        public Builder setHashType(HashType value) {
            copyOnWrite();
            ((EcdsaParams) this.instance).setHashType(value);
            return this;
        }

        public Builder clearHashType() {
            copyOnWrite();
            ((EcdsaParams) this.instance).clearHashType();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
        public int getCurveValue() {
            return ((EcdsaParams) this.instance).getCurveValue();
        }

        public Builder setCurveValue(int value) {
            copyOnWrite();
            ((EcdsaParams) this.instance).setCurveValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
        public EllipticCurveType getCurve() {
            return ((EcdsaParams) this.instance).getCurve();
        }

        public Builder setCurve(EllipticCurveType value) {
            copyOnWrite();
            ((EcdsaParams) this.instance).setCurve(value);
            return this;
        }

        public Builder clearCurve() {
            copyOnWrite();
            ((EcdsaParams) this.instance).clearCurve();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
        public int getEncodingValue() {
            return ((EcdsaParams) this.instance).getEncodingValue();
        }

        public Builder setEncodingValue(int value) {
            copyOnWrite();
            ((EcdsaParams) this.instance).setEncodingValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.EcdsaParamsOrBuilder
        public EcdsaSignatureEncoding getEncoding() {
            return ((EcdsaParams) this.instance).getEncoding();
        }

        public Builder setEncoding(EcdsaSignatureEncoding value) {
            copyOnWrite();
            ((EcdsaParams) this.instance).setEncoding(value);
            return this;
        }

        public Builder clearEncoding() {
            copyOnWrite();
            ((EcdsaParams) this.instance).clearEncoding();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.EcdsaParams$1 */
    static /* synthetic */ class C06081 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f139xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f139xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f139xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f139xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f139xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f139xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f139xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f139xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06081 c06081 = null;
        switch (C06081.f139xa1df5c61[method.ordinal()]) {
            case 1:
                return new EcdsaParams();
            case 2:
                return new Builder(c06081);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"hashType_", "curve_", "encoding_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EcdsaParams> parser = PARSER;
                if (parser == null) {
                    synchronized (EcdsaParams.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        EcdsaParams ecdsaParams = new EcdsaParams();
        DEFAULT_INSTANCE = ecdsaParams;
        GeneratedMessageLite.registerDefaultInstance(EcdsaParams.class, ecdsaParams);
    }

    public static EcdsaParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<EcdsaParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/EcdsaParamsOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface EcdsaParamsOrBuilder extends MessageLiteOrBuilder {
    EllipticCurveType getCurve();

    int getCurveValue();

    EcdsaSignatureEncoding getEncoding();

    int getEncodingValue();

    HashType getHashType();

    int getHashTypeValue();
}

// ===== FILE: com/google/crypto/tink/proto/EcdsaPrivateKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.EcdsaPublicKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class EcdsaPrivateKey extends GeneratedMessageLite<EcdsaPrivateKey, Builder> implements EcdsaPrivateKeyOrBuilder {
    private static final EcdsaPrivateKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    private static volatile Parser<EcdsaPrivateKey> PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private EcdsaPublicKey publicKey_;
    private int version_;

    private EcdsaPrivateKey() {
    }

    @Override // com.google.crypto.tink.proto.EcdsaPrivateKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.EcdsaPrivateKeyOrBuilder
    public boolean hasPublicKey() {
        return this.publicKey_ != null;
    }

    @Override // com.google.crypto.tink.proto.EcdsaPrivateKeyOrBuilder
    public EcdsaPublicKey getPublicKey() {
        EcdsaPublicKey ecdsaPublicKey = this.publicKey_;
        return ecdsaPublicKey == null ? EcdsaPublicKey.getDefaultInstance() : ecdsaPublicKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublicKey(EcdsaPublicKey value) {
        value.getClass();
        this.publicKey_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePublicKey(EcdsaPublicKey value) {
        value.getClass();
        EcdsaPublicKey ecdsaPublicKey = this.publicKey_;
        if (ecdsaPublicKey != null && ecdsaPublicKey != EcdsaPublicKey.getDefaultInstance()) {
            this.publicKey_ = EcdsaPublicKey.newBuilder(this.publicKey_).mergeFrom((EcdsaPublicKey.Builder) value).buildPartial();
        } else {
            this.publicKey_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublicKey() {
        this.publicKey_ = null;
    }

    @Override // com.google.crypto.tink.proto.EcdsaPrivateKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static EcdsaPrivateKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (EcdsaPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EcdsaPrivateKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EcdsaPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EcdsaPrivateKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (EcdsaPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EcdsaPrivateKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EcdsaPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EcdsaPrivateKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (EcdsaPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EcdsaPrivateKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EcdsaPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EcdsaPrivateKey parseFrom(InputStream input) throws IOException {
        return (EcdsaPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EcdsaPrivateKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EcdsaPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EcdsaPrivateKey parseDelimitedFrom(InputStream input) throws IOException {
        return (EcdsaPrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static EcdsaPrivateKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EcdsaPrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EcdsaPrivateKey parseFrom(CodedInputStream input) throws IOException {
        return (EcdsaPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EcdsaPrivateKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EcdsaPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(EcdsaPrivateKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EcdsaPrivateKey, Builder> implements EcdsaPrivateKeyOrBuilder {
        /* synthetic */ Builder(C06091 c06091) {
            this();
        }

        private Builder() {
            super(EcdsaPrivateKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.EcdsaPrivateKeyOrBuilder
        public int getVersion() {
            return ((EcdsaPrivateKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((EcdsaPrivateKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((EcdsaPrivateKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EcdsaPrivateKeyOrBuilder
        public boolean hasPublicKey() {
            return ((EcdsaPrivateKey) this.instance).hasPublicKey();
        }

        @Override // com.google.crypto.tink.proto.EcdsaPrivateKeyOrBuilder
        public EcdsaPublicKey getPublicKey() {
            return ((EcdsaPrivateKey) this.instance).getPublicKey();
        }

        public Builder setPublicKey(EcdsaPublicKey value) {
            copyOnWrite();
            ((EcdsaPrivateKey) this.instance).setPublicKey(value);
            return this;
        }

        public Builder setPublicKey(EcdsaPublicKey.Builder builderForValue) {
            copyOnWrite();
            ((EcdsaPrivateKey) this.instance).setPublicKey(builderForValue.build());
            return this;
        }

        public Builder mergePublicKey(EcdsaPublicKey value) {
            copyOnWrite();
            ((EcdsaPrivateKey) this.instance).mergePublicKey(value);
            return this;
        }

        public Builder clearPublicKey() {
            copyOnWrite();
            ((EcdsaPrivateKey) this.instance).clearPublicKey();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EcdsaPrivateKeyOrBuilder
        public ByteString getKeyValue() {
            return ((EcdsaPrivateKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((EcdsaPrivateKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((EcdsaPrivateKey) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.EcdsaPrivateKey$1 */
    static /* synthetic */ class C06091 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f140xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f140xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f140xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f140xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f140xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f140xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f140xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f140xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06091 c06091 = null;
        switch (C06091.f140xa1df5c61[method.ordinal()]) {
            case 1:
                return new EcdsaPrivateKey();
            case 2:
                return new Builder(c06091);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "publicKey_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EcdsaPrivateKey> parser = PARSER;
                if (parser == null) {
                    synchronized (EcdsaPrivateKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        EcdsaPrivateKey ecdsaPrivateKey = new EcdsaPrivateKey();
        DEFAULT_INSTANCE = ecdsaPrivateKey;
        GeneratedMessageLite.registerDefaultInstance(EcdsaPrivateKey.class, ecdsaPrivateKey);
    }

    public static EcdsaPrivateKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<EcdsaPrivateKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/EcdsaPrivateKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface EcdsaPrivateKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    EcdsaPublicKey getPublicKey();

    int getVersion();

    boolean hasPublicKey();
}

// ===== FILE: com/google/crypto/tink/proto/EcdsaPublicKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.EcdsaParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class EcdsaPublicKey extends GeneratedMessageLite<EcdsaPublicKey, Builder> implements EcdsaPublicKeyOrBuilder {
    private static final EcdsaPublicKey DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<EcdsaPublicKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public static final int X_FIELD_NUMBER = 3;
    public static final int Y_FIELD_NUMBER = 4;
    private EcdsaParams params_;
    private int version_;

    /* renamed from: x_ */
    private ByteString f141x_ = ByteString.EMPTY;

    /* renamed from: y_ */
    private ByteString f142y_ = ByteString.EMPTY;

    private EcdsaPublicKey() {
    }

    @Override // com.google.crypto.tink.proto.EcdsaPublicKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.EcdsaPublicKeyOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.EcdsaPublicKeyOrBuilder
    public EcdsaParams getParams() {
        EcdsaParams ecdsaParams = this.params_;
        return ecdsaParams == null ? EcdsaParams.getDefaultInstance() : ecdsaParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(EcdsaParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(EcdsaParams value) {
        value.getClass();
        EcdsaParams ecdsaParams = this.params_;
        if (ecdsaParams != null && ecdsaParams != EcdsaParams.getDefaultInstance()) {
            this.params_ = EcdsaParams.newBuilder(this.params_).mergeFrom((EcdsaParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.EcdsaPublicKeyOrBuilder
    public ByteString getX() {
        return this.f141x_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setX(ByteString value) {
        value.getClass();
        this.f141x_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearX() {
        this.f141x_ = getDefaultInstance().getX();
    }

    @Override // com.google.crypto.tink.proto.EcdsaPublicKeyOrBuilder
    public ByteString getY() {
        return this.f142y_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setY(ByteString value) {
        value.getClass();
        this.f142y_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearY() {
        this.f142y_ = getDefaultInstance().getY();
    }

    public static EcdsaPublicKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (EcdsaPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EcdsaPublicKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EcdsaPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EcdsaPublicKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (EcdsaPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EcdsaPublicKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EcdsaPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EcdsaPublicKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (EcdsaPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EcdsaPublicKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EcdsaPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EcdsaPublicKey parseFrom(InputStream input) throws IOException {
        return (EcdsaPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EcdsaPublicKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EcdsaPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EcdsaPublicKey parseDelimitedFrom(InputStream input) throws IOException {
        return (EcdsaPublicKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static EcdsaPublicKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EcdsaPublicKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EcdsaPublicKey parseFrom(CodedInputStream input) throws IOException {
        return (EcdsaPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EcdsaPublicKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EcdsaPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(EcdsaPublicKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EcdsaPublicKey, Builder> implements EcdsaPublicKeyOrBuilder {
        /* synthetic */ Builder(C06101 c06101) {
            this();
        }

        private Builder() {
            super(EcdsaPublicKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.EcdsaPublicKeyOrBuilder
        public int getVersion() {
            return ((EcdsaPublicKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((EcdsaPublicKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((EcdsaPublicKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EcdsaPublicKeyOrBuilder
        public boolean hasParams() {
            return ((EcdsaPublicKey) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.EcdsaPublicKeyOrBuilder
        public EcdsaParams getParams() {
            return ((EcdsaPublicKey) this.instance).getParams();
        }

        public Builder setParams(EcdsaParams value) {
            copyOnWrite();
            ((EcdsaPublicKey) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(EcdsaParams.Builder builderForValue) {
            copyOnWrite();
            ((EcdsaPublicKey) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(EcdsaParams value) {
            copyOnWrite();
            ((EcdsaPublicKey) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((EcdsaPublicKey) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EcdsaPublicKeyOrBuilder
        public ByteString getX() {
            return ((EcdsaPublicKey) this.instance).getX();
        }

        public Builder setX(ByteString value) {
            copyOnWrite();
            ((EcdsaPublicKey) this.instance).setX(value);
            return this;
        }

        public Builder clearX() {
            copyOnWrite();
            ((EcdsaPublicKey) this.instance).clearX();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EcdsaPublicKeyOrBuilder
        public ByteString getY() {
            return ((EcdsaPublicKey) this.instance).getY();
        }

        public Builder setY(ByteString value) {
            copyOnWrite();
            ((EcdsaPublicKey) this.instance).setY(value);
            return this;
        }

        public Builder clearY() {
            copyOnWrite();
            ((EcdsaPublicKey) this.instance).clearY();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.EcdsaPublicKey$1 */
    static /* synthetic */ class C06101 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f143xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f143xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f143xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f143xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f143xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f143xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f143xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f143xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06101 c06101 = null;
        switch (C06101.f143xa1df5c61[method.ordinal()]) {
            case 1:
                return new EcdsaPublicKey();
            case 2:
                return new Builder(c06101);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"version_", "params_", "x_", "y_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EcdsaPublicKey> parser = PARSER;
                if (parser == null) {
                    synchronized (EcdsaPublicKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        EcdsaPublicKey ecdsaPublicKey = new EcdsaPublicKey();
        DEFAULT_INSTANCE = ecdsaPublicKey;
        GeneratedMessageLite.registerDefaultInstance(EcdsaPublicKey.class, ecdsaPublicKey);
    }

    public static EcdsaPublicKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<EcdsaPublicKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/EcdsaPublicKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface EcdsaPublicKeyOrBuilder extends MessageLiteOrBuilder {
    EcdsaParams getParams();

    int getVersion();

    ByteString getX();

    ByteString getY();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/EcdsaSignatureEncoding.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* loaded from: classes.dex */
public enum EcdsaSignatureEncoding implements Internal.EnumLite {
    UNKNOWN_ENCODING(0),
    IEEE_P1363(1),
    DER(2),
    UNRECOGNIZED(-1);

    public static final int DER_VALUE = 2;
    public static final int IEEE_P1363_VALUE = 1;
    public static final int UNKNOWN_ENCODING_VALUE = 0;
    private static final Internal.EnumLiteMap<EcdsaSignatureEncoding> internalValueMap = new Internal.EnumLiteMap<EcdsaSignatureEncoding>() { // from class: com.google.crypto.tink.proto.EcdsaSignatureEncoding.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public EcdsaSignatureEncoding findValueByNumber(int number) {
            return EcdsaSignatureEncoding.forNumber(number);
        }
    };
    private final int value;

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static EcdsaSignatureEncoding valueOf(int value) {
        return forNumber(value);
    }

    public static EcdsaSignatureEncoding forNumber(int value) {
        if (value == 0) {
            return UNKNOWN_ENCODING;
        }
        if (value == 1) {
            return IEEE_P1363;
        }
        if (value != 2) {
            return null;
        }
        return DER;
    }

    public static Internal.EnumLiteMap<EcdsaSignatureEncoding> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EcdsaSignatureEncodingVerifier.INSTANCE;
    }

    private static final class EcdsaSignatureEncodingVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new EcdsaSignatureEncodingVerifier();

        private EcdsaSignatureEncodingVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            return EcdsaSignatureEncoding.forNumber(number) != null;
        }
    }

    EcdsaSignatureEncoding(int value) {
        this.value = value;
    }
}

// ===== FILE: com/google/crypto/tink/proto/EciesAeadDemParams.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class EciesAeadDemParams extends GeneratedMessageLite<EciesAeadDemParams, Builder> implements EciesAeadDemParamsOrBuilder {
    public static final int AEAD_DEM_FIELD_NUMBER = 2;
    private static final EciesAeadDemParams DEFAULT_INSTANCE;
    private static volatile Parser<EciesAeadDemParams> PARSER;
    private KeyTemplate aeadDem_;

    private EciesAeadDemParams() {
    }

    @Override // com.google.crypto.tink.proto.EciesAeadDemParamsOrBuilder
    public boolean hasAeadDem() {
        return this.aeadDem_ != null;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadDemParamsOrBuilder
    public KeyTemplate getAeadDem() {
        KeyTemplate keyTemplate = this.aeadDem_;
        return keyTemplate == null ? KeyTemplate.getDefaultInstance() : keyTemplate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAeadDem(KeyTemplate value) {
        value.getClass();
        this.aeadDem_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAeadDem(KeyTemplate value) {
        value.getClass();
        KeyTemplate keyTemplate = this.aeadDem_;
        if (keyTemplate != null && keyTemplate != KeyTemplate.getDefaultInstance()) {
            this.aeadDem_ = KeyTemplate.newBuilder(this.aeadDem_).mergeFrom((KeyTemplate.Builder) value).buildPartial();
        } else {
            this.aeadDem_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAeadDem() {
        this.aeadDem_ = null;
    }

    public static EciesAeadDemParams parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (EciesAeadDemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadDemParams parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadDemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadDemParams parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (EciesAeadDemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadDemParams parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadDemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadDemParams parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (EciesAeadDemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadDemParams parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadDemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadDemParams parseFrom(InputStream input) throws IOException {
        return (EciesAeadDemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadDemParams parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadDemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EciesAeadDemParams parseDelimitedFrom(InputStream input) throws IOException {
        return (EciesAeadDemParams) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadDemParams parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadDemParams) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EciesAeadDemParams parseFrom(CodedInputStream input) throws IOException {
        return (EciesAeadDemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadDemParams parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadDemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(EciesAeadDemParams prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EciesAeadDemParams, Builder> implements EciesAeadDemParamsOrBuilder {
        /* synthetic */ Builder(C06121 c06121) {
            this();
        }

        private Builder() {
            super(EciesAeadDemParams.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.EciesAeadDemParamsOrBuilder
        public boolean hasAeadDem() {
            return ((EciesAeadDemParams) this.instance).hasAeadDem();
        }

        @Override // com.google.crypto.tink.proto.EciesAeadDemParamsOrBuilder
        public KeyTemplate getAeadDem() {
            return ((EciesAeadDemParams) this.instance).getAeadDem();
        }

        public Builder setAeadDem(KeyTemplate value) {
            copyOnWrite();
            ((EciesAeadDemParams) this.instance).setAeadDem(value);
            return this;
        }

        public Builder setAeadDem(KeyTemplate.Builder builderForValue) {
            copyOnWrite();
            ((EciesAeadDemParams) this.instance).setAeadDem(builderForValue.build());
            return this;
        }

        public Builder mergeAeadDem(KeyTemplate value) {
            copyOnWrite();
            ((EciesAeadDemParams) this.instance).mergeAeadDem(value);
            return this;
        }

        public Builder clearAeadDem() {
            copyOnWrite();
            ((EciesAeadDemParams) this.instance).clearAeadDem();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.EciesAeadDemParams$1 */
    static /* synthetic */ class C06121 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f144xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f144xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f144xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f144xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f144xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f144xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f144xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f144xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06121 c06121 = null;
        switch (C06121.f144xa1df5c61[method.ordinal()]) {
            case 1:
                return new EciesAeadDemParams();
            case 2:
                return new Builder(c06121);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"aeadDem_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EciesAeadDemParams> parser = PARSER;
                if (parser == null) {
                    synchronized (EciesAeadDemParams.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        EciesAeadDemParams eciesAeadDemParams = new EciesAeadDemParams();
        DEFAULT_INSTANCE = eciesAeadDemParams;
        GeneratedMessageLite.registerDefaultInstance(EciesAeadDemParams.class, eciesAeadDemParams);
    }

    public static EciesAeadDemParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<EciesAeadDemParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/EciesAeadDemParamsOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface EciesAeadDemParamsOrBuilder extends MessageLiteOrBuilder {
    KeyTemplate getAeadDem();

    boolean hasAeadDem();
}

// ===== FILE: com/google/crypto/tink/proto/EciesAeadHkdf.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class EciesAeadHkdf {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private EciesAeadHkdf() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/EciesAeadHkdfKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class EciesAeadHkdfKeyFormat extends GeneratedMessageLite<EciesAeadHkdfKeyFormat, Builder> implements EciesAeadHkdfKeyFormatOrBuilder {
    private static final EciesAeadHkdfKeyFormat DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<EciesAeadHkdfKeyFormat> PARSER;
    private EciesAeadHkdfParams params_;

    private EciesAeadHkdfKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfKeyFormatOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfKeyFormatOrBuilder
    public EciesAeadHkdfParams getParams() {
        EciesAeadHkdfParams eciesAeadHkdfParams = this.params_;
        return eciesAeadHkdfParams == null ? EciesAeadHkdfParams.getDefaultInstance() : eciesAeadHkdfParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(EciesAeadHkdfParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(EciesAeadHkdfParams value) {
        value.getClass();
        EciesAeadHkdfParams eciesAeadHkdfParams = this.params_;
        if (eciesAeadHkdfParams != null && eciesAeadHkdfParams != EciesAeadHkdfParams.getDefaultInstance()) {
            this.params_ = EciesAeadHkdfParams.newBuilder(this.params_).mergeFrom((EciesAeadHkdfParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    public static EciesAeadHkdfKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadHkdfKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadHkdfKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadHkdfKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadHkdfKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadHkdfKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadHkdfKeyFormat parseFrom(InputStream input) throws IOException {
        return (EciesAeadHkdfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadHkdfKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadHkdfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EciesAeadHkdfKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (EciesAeadHkdfKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadHkdfKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadHkdfKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EciesAeadHkdfKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (EciesAeadHkdfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadHkdfKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadHkdfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(EciesAeadHkdfKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EciesAeadHkdfKeyFormat, Builder> implements EciesAeadHkdfKeyFormatOrBuilder {
        /* synthetic */ Builder(C06131 c06131) {
            this();
        }

        private Builder() {
            super(EciesAeadHkdfKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfKeyFormatOrBuilder
        public boolean hasParams() {
            return ((EciesAeadHkdfKeyFormat) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfKeyFormatOrBuilder
        public EciesAeadHkdfParams getParams() {
            return ((EciesAeadHkdfKeyFormat) this.instance).getParams();
        }

        public Builder setParams(EciesAeadHkdfParams value) {
            copyOnWrite();
            ((EciesAeadHkdfKeyFormat) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(EciesAeadHkdfParams.Builder builderForValue) {
            copyOnWrite();
            ((EciesAeadHkdfKeyFormat) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(EciesAeadHkdfParams value) {
            copyOnWrite();
            ((EciesAeadHkdfKeyFormat) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((EciesAeadHkdfKeyFormat) this.instance).clearParams();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.EciesAeadHkdfKeyFormat$1 */
    static /* synthetic */ class C06131 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f145xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f145xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f145xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f145xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f145xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f145xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f145xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f145xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06131 c06131 = null;
        switch (C06131.f145xa1df5c61[method.ordinal()]) {
            case 1:
                return new EciesAeadHkdfKeyFormat();
            case 2:
                return new Builder(c06131);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"params_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EciesAeadHkdfKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (EciesAeadHkdfKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        EciesAeadHkdfKeyFormat eciesAeadHkdfKeyFormat = new EciesAeadHkdfKeyFormat();
        DEFAULT_INSTANCE = eciesAeadHkdfKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(EciesAeadHkdfKeyFormat.class, eciesAeadHkdfKeyFormat);
    }

    public static EciesAeadHkdfKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<EciesAeadHkdfKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/EciesAeadHkdfKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface EciesAeadHkdfKeyFormatOrBuilder extends MessageLiteOrBuilder {
    EciesAeadHkdfParams getParams();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/EciesAeadHkdfParams.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.EciesAeadDemParams;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class EciesAeadHkdfParams extends GeneratedMessageLite<EciesAeadHkdfParams, Builder> implements EciesAeadHkdfParamsOrBuilder {
    private static final EciesAeadHkdfParams DEFAULT_INSTANCE;
    public static final int DEM_PARAMS_FIELD_NUMBER = 2;
    public static final int EC_POINT_FORMAT_FIELD_NUMBER = 3;
    public static final int KEM_PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<EciesAeadHkdfParams> PARSER;
    private EciesAeadDemParams demParams_;
    private int ecPointFormat_;
    private EciesHkdfKemParams kemParams_;

    private EciesAeadHkdfParams() {
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
    public boolean hasKemParams() {
        return this.kemParams_ != null;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
    public EciesHkdfKemParams getKemParams() {
        EciesHkdfKemParams eciesHkdfKemParams = this.kemParams_;
        return eciesHkdfKemParams == null ? EciesHkdfKemParams.getDefaultInstance() : eciesHkdfKemParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKemParams(EciesHkdfKemParams value) {
        value.getClass();
        this.kemParams_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeKemParams(EciesHkdfKemParams value) {
        value.getClass();
        EciesHkdfKemParams eciesHkdfKemParams = this.kemParams_;
        if (eciesHkdfKemParams != null && eciesHkdfKemParams != EciesHkdfKemParams.getDefaultInstance()) {
            this.kemParams_ = EciesHkdfKemParams.newBuilder(this.kemParams_).mergeFrom((EciesHkdfKemParams.Builder) value).buildPartial();
        } else {
            this.kemParams_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKemParams() {
        this.kemParams_ = null;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
    public boolean hasDemParams() {
        return this.demParams_ != null;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
    public EciesAeadDemParams getDemParams() {
        EciesAeadDemParams eciesAeadDemParams = this.demParams_;
        return eciesAeadDemParams == null ? EciesAeadDemParams.getDefaultInstance() : eciesAeadDemParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDemParams(EciesAeadDemParams value) {
        value.getClass();
        this.demParams_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDemParams(EciesAeadDemParams value) {
        value.getClass();
        EciesAeadDemParams eciesAeadDemParams = this.demParams_;
        if (eciesAeadDemParams != null && eciesAeadDemParams != EciesAeadDemParams.getDefaultInstance()) {
            this.demParams_ = EciesAeadDemParams.newBuilder(this.demParams_).mergeFrom((EciesAeadDemParams.Builder) value).buildPartial();
        } else {
            this.demParams_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDemParams() {
        this.demParams_ = null;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
    public int getEcPointFormatValue() {
        return this.ecPointFormat_;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
    public EcPointFormat getEcPointFormat() {
        EcPointFormat forNumber = EcPointFormat.forNumber(this.ecPointFormat_);
        return forNumber == null ? EcPointFormat.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEcPointFormatValue(int value) {
        this.ecPointFormat_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEcPointFormat(EcPointFormat value) {
        this.ecPointFormat_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEcPointFormat() {
        this.ecPointFormat_ = 0;
    }

    public static EciesAeadHkdfParams parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadHkdfParams parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadHkdfParams parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadHkdfParams parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadHkdfParams parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadHkdfParams parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadHkdfParams parseFrom(InputStream input) throws IOException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadHkdfParams parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EciesAeadHkdfParams parseDelimitedFrom(InputStream input) throws IOException {
        return (EciesAeadHkdfParams) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadHkdfParams parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadHkdfParams) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EciesAeadHkdfParams parseFrom(CodedInputStream input) throws IOException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadHkdfParams parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadHkdfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(EciesAeadHkdfParams prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EciesAeadHkdfParams, Builder> implements EciesAeadHkdfParamsOrBuilder {
        /* synthetic */ Builder(C06141 c06141) {
            this();
        }

        private Builder() {
            super(EciesAeadHkdfParams.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
        public boolean hasKemParams() {
            return ((EciesAeadHkdfParams) this.instance).hasKemParams();
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
        public EciesHkdfKemParams getKemParams() {
            return ((EciesAeadHkdfParams) this.instance).getKemParams();
        }

        public Builder setKemParams(EciesHkdfKemParams value) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).setKemParams(value);
            return this;
        }

        public Builder setKemParams(EciesHkdfKemParams.Builder builderForValue) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).setKemParams(builderForValue.build());
            return this;
        }

        public Builder mergeKemParams(EciesHkdfKemParams value) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).mergeKemParams(value);
            return this;
        }

        public Builder clearKemParams() {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).clearKemParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
        public boolean hasDemParams() {
            return ((EciesAeadHkdfParams) this.instance).hasDemParams();
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
        public EciesAeadDemParams getDemParams() {
            return ((EciesAeadHkdfParams) this.instance).getDemParams();
        }

        public Builder setDemParams(EciesAeadDemParams value) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).setDemParams(value);
            return this;
        }

        public Builder setDemParams(EciesAeadDemParams.Builder builderForValue) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).setDemParams(builderForValue.build());
            return this;
        }

        public Builder mergeDemParams(EciesAeadDemParams value) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).mergeDemParams(value);
            return this;
        }

        public Builder clearDemParams() {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).clearDemParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
        public int getEcPointFormatValue() {
            return ((EciesAeadHkdfParams) this.instance).getEcPointFormatValue();
        }

        public Builder setEcPointFormatValue(int value) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).setEcPointFormatValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfParamsOrBuilder
        public EcPointFormat getEcPointFormat() {
            return ((EciesAeadHkdfParams) this.instance).getEcPointFormat();
        }

        public Builder setEcPointFormat(EcPointFormat value) {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).setEcPointFormat(value);
            return this;
        }

        public Builder clearEcPointFormat() {
            copyOnWrite();
            ((EciesAeadHkdfParams) this.instance).clearEcPointFormat();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.EciesAeadHkdfParams$1 */
    static /* synthetic */ class C06141 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f146xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f146xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f146xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f146xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f146xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f146xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f146xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f146xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06141 c06141 = null;
        switch (C06141.f146xa1df5c61[method.ordinal()]) {
            case 1:
                return new EciesAeadHkdfParams();
            case 2:
                return new Builder(c06141);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"kemParams_", "demParams_", "ecPointFormat_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EciesAeadHkdfParams> parser = PARSER;
                if (parser == null) {
                    synchronized (EciesAeadHkdfParams.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        EciesAeadHkdfParams eciesAeadHkdfParams = new EciesAeadHkdfParams();
        DEFAULT_INSTANCE = eciesAeadHkdfParams;
        GeneratedMessageLite.registerDefaultInstance(EciesAeadHkdfParams.class, eciesAeadHkdfParams);
    }

    public static EciesAeadHkdfParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<EciesAeadHkdfParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/EciesAeadHkdfParamsOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface EciesAeadHkdfParamsOrBuilder extends MessageLiteOrBuilder {
    EciesAeadDemParams getDemParams();

    EcPointFormat getEcPointFormat();

    int getEcPointFormatValue();

    EciesHkdfKemParams getKemParams();

    boolean hasDemParams();

    boolean hasKemParams();
}

// ===== FILE: com/google/crypto/tink/proto/EciesAeadHkdfPrivateKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.EciesAeadHkdfPublicKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class EciesAeadHkdfPrivateKey extends GeneratedMessageLite<EciesAeadHkdfPrivateKey, Builder> implements EciesAeadHkdfPrivateKeyOrBuilder {
    private static final EciesAeadHkdfPrivateKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    private static volatile Parser<EciesAeadHkdfPrivateKey> PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private EciesAeadHkdfPublicKey publicKey_;
    private int version_;

    private EciesAeadHkdfPrivateKey() {
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfPrivateKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfPrivateKeyOrBuilder
    public boolean hasPublicKey() {
        return this.publicKey_ != null;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfPrivateKeyOrBuilder
    public EciesAeadHkdfPublicKey getPublicKey() {
        EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey = this.publicKey_;
        return eciesAeadHkdfPublicKey == null ? EciesAeadHkdfPublicKey.getDefaultInstance() : eciesAeadHkdfPublicKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublicKey(EciesAeadHkdfPublicKey value) {
        value.getClass();
        this.publicKey_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePublicKey(EciesAeadHkdfPublicKey value) {
        value.getClass();
        EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey = this.publicKey_;
        if (eciesAeadHkdfPublicKey != null && eciesAeadHkdfPublicKey != EciesAeadHkdfPublicKey.getDefaultInstance()) {
            this.publicKey_ = EciesAeadHkdfPublicKey.newBuilder(this.publicKey_).mergeFrom((EciesAeadHkdfPublicKey.Builder) value).buildPartial();
        } else {
            this.publicKey_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublicKey() {
        this.publicKey_ = null;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfPrivateKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static EciesAeadHkdfPrivateKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadHkdfPrivateKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadHkdfPrivateKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadHkdfPrivateKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadHkdfPrivateKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadHkdfPrivateKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadHkdfPrivateKey parseFrom(InputStream input) throws IOException {
        return (EciesAeadHkdfPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadHkdfPrivateKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadHkdfPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EciesAeadHkdfPrivateKey parseDelimitedFrom(InputStream input) throws IOException {
        return (EciesAeadHkdfPrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadHkdfPrivateKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadHkdfPrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EciesAeadHkdfPrivateKey parseFrom(CodedInputStream input) throws IOException {
        return (EciesAeadHkdfPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadHkdfPrivateKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadHkdfPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(EciesAeadHkdfPrivateKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EciesAeadHkdfPrivateKey, Builder> implements EciesAeadHkdfPrivateKeyOrBuilder {
        /* synthetic */ Builder(C06151 c06151) {
            this();
        }

        private Builder() {
            super(EciesAeadHkdfPrivateKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfPrivateKeyOrBuilder
        public int getVersion() {
            return ((EciesAeadHkdfPrivateKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((EciesAeadHkdfPrivateKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((EciesAeadHkdfPrivateKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfPrivateKeyOrBuilder
        public boolean hasPublicKey() {
            return ((EciesAeadHkdfPrivateKey) this.instance).hasPublicKey();
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfPrivateKeyOrBuilder
        public EciesAeadHkdfPublicKey getPublicKey() {
            return ((EciesAeadHkdfPrivateKey) this.instance).getPublicKey();
        }

        public Builder setPublicKey(EciesAeadHkdfPublicKey value) {
            copyOnWrite();
            ((EciesAeadHkdfPrivateKey) this.instance).setPublicKey(value);
            return this;
        }

        public Builder setPublicKey(EciesAeadHkdfPublicKey.Builder builderForValue) {
            copyOnWrite();
            ((EciesAeadHkdfPrivateKey) this.instance).setPublicKey(builderForValue.build());
            return this;
        }

        public Builder mergePublicKey(EciesAeadHkdfPublicKey value) {
            copyOnWrite();
            ((EciesAeadHkdfPrivateKey) this.instance).mergePublicKey(value);
            return this;
        }

        public Builder clearPublicKey() {
            copyOnWrite();
            ((EciesAeadHkdfPrivateKey) this.instance).clearPublicKey();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfPrivateKeyOrBuilder
        public ByteString getKeyValue() {
            return ((EciesAeadHkdfPrivateKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((EciesAeadHkdfPrivateKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((EciesAeadHkdfPrivateKey) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.EciesAeadHkdfPrivateKey$1 */
    static /* synthetic */ class C06151 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f147xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f147xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f147xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f147xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f147xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f147xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f147xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f147xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06151 c06151 = null;
        switch (C06151.f147xa1df5c61[method.ordinal()]) {
            case 1:
                return new EciesAeadHkdfPrivateKey();
            case 2:
                return new Builder(c06151);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "publicKey_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EciesAeadHkdfPrivateKey> parser = PARSER;
                if (parser == null) {
                    synchronized (EciesAeadHkdfPrivateKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        EciesAeadHkdfPrivateKey eciesAeadHkdfPrivateKey = new EciesAeadHkdfPrivateKey();
        DEFAULT_INSTANCE = eciesAeadHkdfPrivateKey;
        GeneratedMessageLite.registerDefaultInstance(EciesAeadHkdfPrivateKey.class, eciesAeadHkdfPrivateKey);
    }

    public static EciesAeadHkdfPrivateKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<EciesAeadHkdfPrivateKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/EciesAeadHkdfPrivateKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface EciesAeadHkdfPrivateKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    EciesAeadHkdfPublicKey getPublicKey();

    int getVersion();

    boolean hasPublicKey();
}

// ===== FILE: com/google/crypto/tink/proto/EciesAeadHkdfPublicKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class EciesAeadHkdfPublicKey extends GeneratedMessageLite<EciesAeadHkdfPublicKey, Builder> implements EciesAeadHkdfPublicKeyOrBuilder {
    private static final EciesAeadHkdfPublicKey DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<EciesAeadHkdfPublicKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public static final int X_FIELD_NUMBER = 3;
    public static final int Y_FIELD_NUMBER = 4;
    private EciesAeadHkdfParams params_;
    private int version_;

    /* renamed from: x_ */
    private ByteString f148x_ = ByteString.EMPTY;

    /* renamed from: y_ */
    private ByteString f149y_ = ByteString.EMPTY;

    private EciesAeadHkdfPublicKey() {
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
    public EciesAeadHkdfParams getParams() {
        EciesAeadHkdfParams eciesAeadHkdfParams = this.params_;
        return eciesAeadHkdfParams == null ? EciesAeadHkdfParams.getDefaultInstance() : eciesAeadHkdfParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(EciesAeadHkdfParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(EciesAeadHkdfParams value) {
        value.getClass();
        EciesAeadHkdfParams eciesAeadHkdfParams = this.params_;
        if (eciesAeadHkdfParams != null && eciesAeadHkdfParams != EciesAeadHkdfParams.getDefaultInstance()) {
            this.params_ = EciesAeadHkdfParams.newBuilder(this.params_).mergeFrom((EciesAeadHkdfParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
    public ByteString getX() {
        return this.f148x_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setX(ByteString value) {
        value.getClass();
        this.f148x_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearX() {
        this.f148x_ = getDefaultInstance().getX();
    }

    @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
    public ByteString getY() {
        return this.f149y_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setY(ByteString value) {
        value.getClass();
        this.f149y_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearY() {
        this.f149y_ = getDefaultInstance().getY();
    }

    public static EciesAeadHkdfPublicKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadHkdfPublicKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadHkdfPublicKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadHkdfPublicKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadHkdfPublicKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesAeadHkdfPublicKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesAeadHkdfPublicKey parseFrom(InputStream input) throws IOException {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadHkdfPublicKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EciesAeadHkdfPublicKey parseDelimitedFrom(InputStream input) throws IOException {
        return (EciesAeadHkdfPublicKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadHkdfPublicKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadHkdfPublicKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EciesAeadHkdfPublicKey parseFrom(CodedInputStream input) throws IOException {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesAeadHkdfPublicKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(EciesAeadHkdfPublicKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EciesAeadHkdfPublicKey, Builder> implements EciesAeadHkdfPublicKeyOrBuilder {
        /* synthetic */ Builder(C06161 c06161) {
            this();
        }

        private Builder() {
            super(EciesAeadHkdfPublicKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
        public int getVersion() {
            return ((EciesAeadHkdfPublicKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
        public boolean hasParams() {
            return ((EciesAeadHkdfPublicKey) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
        public EciesAeadHkdfParams getParams() {
            return ((EciesAeadHkdfPublicKey) this.instance).getParams();
        }

        public Builder setParams(EciesAeadHkdfParams value) {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(EciesAeadHkdfParams.Builder builderForValue) {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(EciesAeadHkdfParams value) {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
        public ByteString getX() {
            return ((EciesAeadHkdfPublicKey) this.instance).getX();
        }

        public Builder setX(ByteString value) {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).setX(value);
            return this;
        }

        public Builder clearX() {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).clearX();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EciesAeadHkdfPublicKeyOrBuilder
        public ByteString getY() {
            return ((EciesAeadHkdfPublicKey) this.instance).getY();
        }

        public Builder setY(ByteString value) {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).setY(value);
            return this;
        }

        public Builder clearY() {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).clearY();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.EciesAeadHkdfPublicKey$1 */
    static /* synthetic */ class C06161 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f150xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f150xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f150xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f150xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f150xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f150xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f150xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f150xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06161 c06161 = null;
        switch (C06161.f150xa1df5c61[method.ordinal()]) {
            case 1:
                return new EciesAeadHkdfPublicKey();
            case 2:
                return new Builder(c06161);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"version_", "params_", "x_", "y_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EciesAeadHkdfPublicKey> parser = PARSER;
                if (parser == null) {
                    synchronized (EciesAeadHkdfPublicKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey = new EciesAeadHkdfPublicKey();
        DEFAULT_INSTANCE = eciesAeadHkdfPublicKey;
        GeneratedMessageLite.registerDefaultInstance(EciesAeadHkdfPublicKey.class, eciesAeadHkdfPublicKey);
    }

    public static EciesAeadHkdfPublicKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<EciesAeadHkdfPublicKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/EciesAeadHkdfPublicKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface EciesAeadHkdfPublicKeyOrBuilder extends MessageLiteOrBuilder {
    EciesAeadHkdfParams getParams();

    int getVersion();

    ByteString getX();

    ByteString getY();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/EciesHkdfKemParams.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class EciesHkdfKemParams extends GeneratedMessageLite<EciesHkdfKemParams, Builder> implements EciesHkdfKemParamsOrBuilder {
    public static final int CURVE_TYPE_FIELD_NUMBER = 1;
    private static final EciesHkdfKemParams DEFAULT_INSTANCE;
    public static final int HKDF_HASH_TYPE_FIELD_NUMBER = 2;
    public static final int HKDF_SALT_FIELD_NUMBER = 11;
    private static volatile Parser<EciesHkdfKemParams> PARSER;
    private int curveType_;
    private int hkdfHashType_;
    private ByteString hkdfSalt_ = ByteString.EMPTY;

    private EciesHkdfKemParams() {
    }

    @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
    public int getCurveTypeValue() {
        return this.curveType_;
    }

    @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
    public EllipticCurveType getCurveType() {
        EllipticCurveType forNumber = EllipticCurveType.forNumber(this.curveType_);
        return forNumber == null ? EllipticCurveType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurveTypeValue(int value) {
        this.curveType_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurveType(EllipticCurveType value) {
        this.curveType_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCurveType() {
        this.curveType_ = 0;
    }

    @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
    public int getHkdfHashTypeValue() {
        return this.hkdfHashType_;
    }

    @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
    public HashType getHkdfHashType() {
        HashType forNumber = HashType.forNumber(this.hkdfHashType_);
        return forNumber == null ? HashType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHkdfHashTypeValue(int value) {
        this.hkdfHashType_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHkdfHashType(HashType value) {
        this.hkdfHashType_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHkdfHashType() {
        this.hkdfHashType_ = 0;
    }

    @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
    public ByteString getHkdfSalt() {
        return this.hkdfSalt_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHkdfSalt(ByteString value) {
        value.getClass();
        this.hkdfSalt_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHkdfSalt() {
        this.hkdfSalt_ = getDefaultInstance().getHkdfSalt();
    }

    public static EciesHkdfKemParams parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (EciesHkdfKemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesHkdfKemParams parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesHkdfKemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesHkdfKemParams parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (EciesHkdfKemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesHkdfKemParams parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesHkdfKemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesHkdfKemParams parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (EciesHkdfKemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EciesHkdfKemParams parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EciesHkdfKemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EciesHkdfKemParams parseFrom(InputStream input) throws IOException {
        return (EciesHkdfKemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesHkdfKemParams parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesHkdfKemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EciesHkdfKemParams parseDelimitedFrom(InputStream input) throws IOException {
        return (EciesHkdfKemParams) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesHkdfKemParams parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesHkdfKemParams) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EciesHkdfKemParams parseFrom(CodedInputStream input) throws IOException {
        return (EciesHkdfKemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EciesHkdfKemParams parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EciesHkdfKemParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(EciesHkdfKemParams prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EciesHkdfKemParams, Builder> implements EciesHkdfKemParamsOrBuilder {
        /* synthetic */ Builder(C06171 c06171) {
            this();
        }

        private Builder() {
            super(EciesHkdfKemParams.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
        public int getCurveTypeValue() {
            return ((EciesHkdfKemParams) this.instance).getCurveTypeValue();
        }

        public Builder setCurveTypeValue(int value) {
            copyOnWrite();
            ((EciesHkdfKemParams) this.instance).setCurveTypeValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
        public EllipticCurveType getCurveType() {
            return ((EciesHkdfKemParams) this.instance).getCurveType();
        }

        public Builder setCurveType(EllipticCurveType value) {
            copyOnWrite();
            ((EciesHkdfKemParams) this.instance).setCurveType(value);
            return this;
        }

        public Builder clearCurveType() {
            copyOnWrite();
            ((EciesHkdfKemParams) this.instance).clearCurveType();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
        public int getHkdfHashTypeValue() {
            return ((EciesHkdfKemParams) this.instance).getHkdfHashTypeValue();
        }

        public Builder setHkdfHashTypeValue(int value) {
            copyOnWrite();
            ((EciesHkdfKemParams) this.instance).setHkdfHashTypeValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
        public HashType getHkdfHashType() {
            return ((EciesHkdfKemParams) this.instance).getHkdfHashType();
        }

        public Builder setHkdfHashType(HashType value) {
            copyOnWrite();
            ((EciesHkdfKemParams) this.instance).setHkdfHashType(value);
            return this;
        }

        public Builder clearHkdfHashType() {
            copyOnWrite();
            ((EciesHkdfKemParams) this.instance).clearHkdfHashType();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EciesHkdfKemParamsOrBuilder
        public ByteString getHkdfSalt() {
            return ((EciesHkdfKemParams) this.instance).getHkdfSalt();
        }

        public Builder setHkdfSalt(ByteString value) {
            copyOnWrite();
            ((EciesHkdfKemParams) this.instance).setHkdfSalt(value);
            return this;
        }

        public Builder clearHkdfSalt() {
            copyOnWrite();
            ((EciesHkdfKemParams) this.instance).clearHkdfSalt();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.EciesHkdfKemParams$1 */
    static /* synthetic */ class C06171 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f151xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f151xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f151xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f151xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f151xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f151xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f151xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f151xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06171 c06171 = null;
        switch (C06171.f151xa1df5c61[method.ordinal()]) {
            case 1:
                return new EciesHkdfKemParams();
            case 2:
                return new Builder(c06171);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"curveType_", "hkdfHashType_", "hkdfSalt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EciesHkdfKemParams> parser = PARSER;
                if (parser == null) {
                    synchronized (EciesHkdfKemParams.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        EciesHkdfKemParams eciesHkdfKemParams = new EciesHkdfKemParams();
        DEFAULT_INSTANCE = eciesHkdfKemParams;
        GeneratedMessageLite.registerDefaultInstance(EciesHkdfKemParams.class, eciesHkdfKemParams);
    }

    public static EciesHkdfKemParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<EciesHkdfKemParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/EciesHkdfKemParamsOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface EciesHkdfKemParamsOrBuilder extends MessageLiteOrBuilder {
    EllipticCurveType getCurveType();

    int getCurveTypeValue();

    HashType getHkdfHashType();

    int getHkdfHashTypeValue();

    ByteString getHkdfSalt();
}

// ===== FILE: com/google/crypto/tink/proto/Ed25519.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class Ed25519 {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private Ed25519() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/Ed25519KeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Ed25519KeyFormat extends GeneratedMessageLite<Ed25519KeyFormat, Builder> implements Ed25519KeyFormatOrBuilder {
    private static final Ed25519KeyFormat DEFAULT_INSTANCE;
    private static volatile Parser<Ed25519KeyFormat> PARSER;

    private Ed25519KeyFormat() {
    }

    public static Ed25519KeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Ed25519KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Ed25519KeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Ed25519KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Ed25519KeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Ed25519KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Ed25519KeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Ed25519KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Ed25519KeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Ed25519KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Ed25519KeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Ed25519KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Ed25519KeyFormat parseFrom(InputStream input) throws IOException {
        return (Ed25519KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Ed25519KeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Ed25519KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Ed25519KeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (Ed25519KeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Ed25519KeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Ed25519KeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Ed25519KeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (Ed25519KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Ed25519KeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Ed25519KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Ed25519KeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Ed25519KeyFormat, Builder> implements Ed25519KeyFormatOrBuilder {
        /* synthetic */ Builder(C06181 c06181) {
            this();
        }

        private Builder() {
            super(Ed25519KeyFormat.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: com.google.crypto.tink.proto.Ed25519KeyFormat$1 */
    static /* synthetic */ class C06181 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f152xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f152xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f152xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f152xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f152xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f152xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f152xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f152xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06181 c06181 = null;
        switch (C06181.f152xa1df5c61[method.ordinal()]) {
            case 1:
                return new Ed25519KeyFormat();
            case 2:
                return new Builder(c06181);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Ed25519KeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (Ed25519KeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        Ed25519KeyFormat ed25519KeyFormat = new Ed25519KeyFormat();
        DEFAULT_INSTANCE = ed25519KeyFormat;
        GeneratedMessageLite.registerDefaultInstance(Ed25519KeyFormat.class, ed25519KeyFormat);
    }

    public static Ed25519KeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Ed25519KeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/Ed25519KeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface Ed25519KeyFormatOrBuilder extends MessageLiteOrBuilder {
}

// ===== FILE: com/google/crypto/tink/proto/Ed25519PrivateKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.Ed25519PublicKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Ed25519PrivateKey extends GeneratedMessageLite<Ed25519PrivateKey, Builder> implements Ed25519PrivateKeyOrBuilder {
    private static final Ed25519PrivateKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<Ed25519PrivateKey> PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 3;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private Ed25519PublicKey publicKey_;
    private int version_;

    private Ed25519PrivateKey() {
    }

    @Override // com.google.crypto.tink.proto.Ed25519PrivateKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.Ed25519PrivateKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    @Override // com.google.crypto.tink.proto.Ed25519PrivateKeyOrBuilder
    public boolean hasPublicKey() {
        return this.publicKey_ != null;
    }

    @Override // com.google.crypto.tink.proto.Ed25519PrivateKeyOrBuilder
    public Ed25519PublicKey getPublicKey() {
        Ed25519PublicKey ed25519PublicKey = this.publicKey_;
        return ed25519PublicKey == null ? Ed25519PublicKey.getDefaultInstance() : ed25519PublicKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublicKey(Ed25519PublicKey value) {
        value.getClass();
        this.publicKey_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePublicKey(Ed25519PublicKey value) {
        value.getClass();
        Ed25519PublicKey ed25519PublicKey = this.publicKey_;
        if (ed25519PublicKey != null && ed25519PublicKey != Ed25519PublicKey.getDefaultInstance()) {
            this.publicKey_ = Ed25519PublicKey.newBuilder(this.publicKey_).mergeFrom((Ed25519PublicKey.Builder) value).buildPartial();
        } else {
            this.publicKey_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublicKey() {
        this.publicKey_ = null;
    }

    public static Ed25519PrivateKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Ed25519PrivateKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Ed25519PrivateKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Ed25519PrivateKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Ed25519PrivateKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Ed25519PrivateKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Ed25519PrivateKey parseFrom(InputStream input) throws IOException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Ed25519PrivateKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Ed25519PrivateKey parseDelimitedFrom(InputStream input) throws IOException {
        return (Ed25519PrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Ed25519PrivateKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Ed25519PrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Ed25519PrivateKey parseFrom(CodedInputStream input) throws IOException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Ed25519PrivateKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Ed25519PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Ed25519PrivateKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Ed25519PrivateKey, Builder> implements Ed25519PrivateKeyOrBuilder {
        /* synthetic */ Builder(C06191 c06191) {
            this();
        }

        private Builder() {
            super(Ed25519PrivateKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.Ed25519PrivateKeyOrBuilder
        public int getVersion() {
            return ((Ed25519PrivateKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.Ed25519PrivateKeyOrBuilder
        public ByteString getKeyValue() {
            return ((Ed25519PrivateKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).clearKeyValue();
            return this;
        }

        @Override // com.google.crypto.tink.proto.Ed25519PrivateKeyOrBuilder
        public boolean hasPublicKey() {
            return ((Ed25519PrivateKey) this.instance).hasPublicKey();
        }

        @Override // com.google.crypto.tink.proto.Ed25519PrivateKeyOrBuilder
        public Ed25519PublicKey getPublicKey() {
            return ((Ed25519PrivateKey) this.instance).getPublicKey();
        }

        public Builder setPublicKey(Ed25519PublicKey value) {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).setPublicKey(value);
            return this;
        }

        public Builder setPublicKey(Ed25519PublicKey.Builder builderForValue) {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).setPublicKey(builderForValue.build());
            return this;
        }

        public Builder mergePublicKey(Ed25519PublicKey value) {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).mergePublicKey(value);
            return this;
        }

        public Builder clearPublicKey() {
            copyOnWrite();
            ((Ed25519PrivateKey) this.instance).clearPublicKey();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.Ed25519PrivateKey$1 */
    static /* synthetic */ class C06191 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f153xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f153xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f153xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f153xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f153xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f153xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f153xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f153xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06191 c06191 = null;
        switch (C06191.f153xa1df5c61[method.ordinal()]) {
            case 1:
                return new Ed25519PrivateKey();
            case 2:
                return new Builder(c06191);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"version_", "keyValue_", "publicKey_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Ed25519PrivateKey> parser = PARSER;
                if (parser == null) {
                    synchronized (Ed25519PrivateKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        Ed25519PrivateKey ed25519PrivateKey = new Ed25519PrivateKey();
        DEFAULT_INSTANCE = ed25519PrivateKey;
        GeneratedMessageLite.registerDefaultInstance(Ed25519PrivateKey.class, ed25519PrivateKey);
    }

    public static Ed25519PrivateKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Ed25519PrivateKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/Ed25519PrivateKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface Ed25519PrivateKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    Ed25519PublicKey getPublicKey();

    int getVersion();

    boolean hasPublicKey();
}

// ===== FILE: com/google/crypto/tink/proto/Ed25519PublicKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Ed25519PublicKey extends GeneratedMessageLite<Ed25519PublicKey, Builder> implements Ed25519PublicKeyOrBuilder {
    private static final Ed25519PublicKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<Ed25519PublicKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private int version_;

    private Ed25519PublicKey() {
    }

    @Override // com.google.crypto.tink.proto.Ed25519PublicKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.Ed25519PublicKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static Ed25519PublicKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Ed25519PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Ed25519PublicKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Ed25519PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Ed25519PublicKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Ed25519PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Ed25519PublicKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Ed25519PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Ed25519PublicKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Ed25519PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Ed25519PublicKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Ed25519PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Ed25519PublicKey parseFrom(InputStream input) throws IOException {
        return (Ed25519PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Ed25519PublicKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Ed25519PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Ed25519PublicKey parseDelimitedFrom(InputStream input) throws IOException {
        return (Ed25519PublicKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Ed25519PublicKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Ed25519PublicKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Ed25519PublicKey parseFrom(CodedInputStream input) throws IOException {
        return (Ed25519PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Ed25519PublicKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Ed25519PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Ed25519PublicKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Ed25519PublicKey, Builder> implements Ed25519PublicKeyOrBuilder {
        /* synthetic */ Builder(C06201 c06201) {
            this();
        }

        private Builder() {
            super(Ed25519PublicKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.Ed25519PublicKeyOrBuilder
        public int getVersion() {
            return ((Ed25519PublicKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((Ed25519PublicKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((Ed25519PublicKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.Ed25519PublicKeyOrBuilder
        public ByteString getKeyValue() {
            return ((Ed25519PublicKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((Ed25519PublicKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((Ed25519PublicKey) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.Ed25519PublicKey$1 */
    static /* synthetic */ class C06201 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f154xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f154xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f154xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f154xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f154xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f154xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f154xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f154xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06201 c06201 = null;
        switch (C06201.f154xa1df5c61[method.ordinal()]) {
            case 1:
                return new Ed25519PublicKey();
            case 2:
                return new Builder(c06201);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"version_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Ed25519PublicKey> parser = PARSER;
                if (parser == null) {
                    synchronized (Ed25519PublicKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        Ed25519PublicKey ed25519PublicKey = new Ed25519PublicKey();
        DEFAULT_INSTANCE = ed25519PublicKey;
        GeneratedMessageLite.registerDefaultInstance(Ed25519PublicKey.class, ed25519PublicKey);
    }

    public static Ed25519PublicKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Ed25519PublicKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/Ed25519PublicKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface Ed25519PublicKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    int getVersion();
}

// ===== FILE: com/google/crypto/tink/proto/EllipticCurveType.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* loaded from: classes.dex */
public enum EllipticCurveType implements Internal.EnumLite {
    UNKNOWN_CURVE(0),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    CURVE25519(5),
    UNRECOGNIZED(-1);

    public static final int CURVE25519_VALUE = 5;
    public static final int NIST_P256_VALUE = 2;
    public static final int NIST_P384_VALUE = 3;
    public static final int NIST_P521_VALUE = 4;
    public static final int UNKNOWN_CURVE_VALUE = 0;
    private static final Internal.EnumLiteMap<EllipticCurveType> internalValueMap = new Internal.EnumLiteMap<EllipticCurveType>() { // from class: com.google.crypto.tink.proto.EllipticCurveType.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public EllipticCurveType findValueByNumber(int number) {
            return EllipticCurveType.forNumber(number);
        }
    };
    private final int value;

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static EllipticCurveType valueOf(int value) {
        return forNumber(value);
    }

    public static EllipticCurveType forNumber(int value) {
        if (value == 0) {
            return UNKNOWN_CURVE;
        }
        if (value == 2) {
            return NIST_P256;
        }
        if (value == 3) {
            return NIST_P384;
        }
        if (value == 4) {
            return NIST_P521;
        }
        if (value != 5) {
            return null;
        }
        return CURVE25519;
    }

    public static Internal.EnumLiteMap<EllipticCurveType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EllipticCurveTypeVerifier.INSTANCE;
    }

    private static final class EllipticCurveTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new EllipticCurveTypeVerifier();

        private EllipticCurveTypeVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            return EllipticCurveType.forNumber(number) != null;
        }
    }

    EllipticCurveType(int value) {
        this.value = value;
    }
}

// ===== FILE: com/google/crypto/tink/proto/EncryptedKeyset.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class EncryptedKeyset extends GeneratedMessageLite<EncryptedKeyset, Builder> implements EncryptedKeysetOrBuilder {
    private static final EncryptedKeyset DEFAULT_INSTANCE;
    public static final int ENCRYPTED_KEYSET_FIELD_NUMBER = 2;
    public static final int KEYSET_INFO_FIELD_NUMBER = 3;
    private static volatile Parser<EncryptedKeyset> PARSER;
    private ByteString encryptedKeyset_ = ByteString.EMPTY;
    private KeysetInfo keysetInfo_;

    private EncryptedKeyset() {
    }

    @Override // com.google.crypto.tink.proto.EncryptedKeysetOrBuilder
    public ByteString getEncryptedKeyset() {
        return this.encryptedKeyset_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEncryptedKeyset(ByteString value) {
        value.getClass();
        this.encryptedKeyset_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEncryptedKeyset() {
        this.encryptedKeyset_ = getDefaultInstance().getEncryptedKeyset();
    }

    @Override // com.google.crypto.tink.proto.EncryptedKeysetOrBuilder
    public boolean hasKeysetInfo() {
        return this.keysetInfo_ != null;
    }

    @Override // com.google.crypto.tink.proto.EncryptedKeysetOrBuilder
    public KeysetInfo getKeysetInfo() {
        KeysetInfo keysetInfo = this.keysetInfo_;
        return keysetInfo == null ? KeysetInfo.getDefaultInstance() : keysetInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeysetInfo(KeysetInfo value) {
        value.getClass();
        this.keysetInfo_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeKeysetInfo(KeysetInfo value) {
        value.getClass();
        KeysetInfo keysetInfo = this.keysetInfo_;
        if (keysetInfo != null && keysetInfo != KeysetInfo.getDefaultInstance()) {
            this.keysetInfo_ = KeysetInfo.newBuilder(this.keysetInfo_).mergeFrom((KeysetInfo.Builder) value).buildPartial();
        } else {
            this.keysetInfo_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeysetInfo() {
        this.keysetInfo_ = null;
    }

    public static EncryptedKeyset parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (EncryptedKeyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EncryptedKeyset parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EncryptedKeyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EncryptedKeyset parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (EncryptedKeyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EncryptedKeyset parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EncryptedKeyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EncryptedKeyset parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (EncryptedKeyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static EncryptedKeyset parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (EncryptedKeyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static EncryptedKeyset parseFrom(InputStream input) throws IOException {
        return (EncryptedKeyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EncryptedKeyset parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EncryptedKeyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EncryptedKeyset parseDelimitedFrom(InputStream input) throws IOException {
        return (EncryptedKeyset) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static EncryptedKeyset parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EncryptedKeyset) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static EncryptedKeyset parseFrom(CodedInputStream input) throws IOException {
        return (EncryptedKeyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static EncryptedKeyset parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (EncryptedKeyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(EncryptedKeyset prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<EncryptedKeyset, Builder> implements EncryptedKeysetOrBuilder {
        /* synthetic */ Builder(C06221 c06221) {
            this();
        }

        private Builder() {
            super(EncryptedKeyset.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.EncryptedKeysetOrBuilder
        public ByteString getEncryptedKeyset() {
            return ((EncryptedKeyset) this.instance).getEncryptedKeyset();
        }

        public Builder setEncryptedKeyset(ByteString value) {
            copyOnWrite();
            ((EncryptedKeyset) this.instance).setEncryptedKeyset(value);
            return this;
        }

        public Builder clearEncryptedKeyset() {
            copyOnWrite();
            ((EncryptedKeyset) this.instance).clearEncryptedKeyset();
            return this;
        }

        @Override // com.google.crypto.tink.proto.EncryptedKeysetOrBuilder
        public boolean hasKeysetInfo() {
            return ((EncryptedKeyset) this.instance).hasKeysetInfo();
        }

        @Override // com.google.crypto.tink.proto.EncryptedKeysetOrBuilder
        public KeysetInfo getKeysetInfo() {
            return ((EncryptedKeyset) this.instance).getKeysetInfo();
        }

        public Builder setKeysetInfo(KeysetInfo value) {
            copyOnWrite();
            ((EncryptedKeyset) this.instance).setKeysetInfo(value);
            return this;
        }

        public Builder setKeysetInfo(KeysetInfo.Builder builderForValue) {
            copyOnWrite();
            ((EncryptedKeyset) this.instance).setKeysetInfo(builderForValue.build());
            return this;
        }

        public Builder mergeKeysetInfo(KeysetInfo value) {
            copyOnWrite();
            ((EncryptedKeyset) this.instance).mergeKeysetInfo(value);
            return this;
        }

        public Builder clearKeysetInfo() {
            copyOnWrite();
            ((EncryptedKeyset) this.instance).clearKeysetInfo();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.EncryptedKeyset$1 */
    static /* synthetic */ class C06221 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f155xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f155xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f155xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f155xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f155xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f155xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f155xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f155xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06221 c06221 = null;
        switch (C06221.f155xa1df5c61[method.ordinal()]) {
            case 1:
                return new EncryptedKeyset();
            case 2:
                return new Builder(c06221);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{"encryptedKeyset_", "keysetInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EncryptedKeyset> parser = PARSER;
                if (parser == null) {
                    synchronized (EncryptedKeyset.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        EncryptedKeyset encryptedKeyset = new EncryptedKeyset();
        DEFAULT_INSTANCE = encryptedKeyset;
        GeneratedMessageLite.registerDefaultInstance(EncryptedKeyset.class, encryptedKeyset);
    }

    public static EncryptedKeyset getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<EncryptedKeyset> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/EncryptedKeysetOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface EncryptedKeysetOrBuilder extends MessageLiteOrBuilder {
    ByteString getEncryptedKeyset();

    KeysetInfo getKeysetInfo();

    boolean hasKeysetInfo();
}

// ===== FILE: com/google/crypto/tink/proto/HashType.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* loaded from: classes.dex */
public enum HashType implements Internal.EnumLite {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);

    public static final int SHA1_VALUE = 1;
    public static final int SHA256_VALUE = 3;
    public static final int SHA384_VALUE = 2;
    public static final int SHA512_VALUE = 4;
    public static final int UNKNOWN_HASH_VALUE = 0;
    private static final Internal.EnumLiteMap<HashType> internalValueMap = new Internal.EnumLiteMap<HashType>() { // from class: com.google.crypto.tink.proto.HashType.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public HashType findValueByNumber(int number) {
            return HashType.forNumber(number);
        }
    };
    private final int value;

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static HashType valueOf(int value) {
        return forNumber(value);
    }

    public static HashType forNumber(int value) {
        if (value == 0) {
            return UNKNOWN_HASH;
        }
        if (value == 1) {
            return SHA1;
        }
        if (value == 2) {
            return SHA384;
        }
        if (value == 3) {
            return SHA256;
        }
        if (value != 4) {
            return null;
        }
        return SHA512;
    }

    public static Internal.EnumLiteMap<HashType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return HashTypeVerifier.INSTANCE;
    }

    private static final class HashTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new HashTypeVerifier();

        private HashTypeVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            return HashType.forNumber(number) != null;
        }
    }

    HashType(int value) {
        this.value = value;
    }
}

// ===== FILE: com/google/crypto/tink/proto/HkdfPrf.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class HkdfPrf {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private HkdfPrf() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/HkdfPrfKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.HkdfPrfParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class HkdfPrfKey extends GeneratedMessageLite<HkdfPrfKey, Builder> implements HkdfPrfKeyOrBuilder {
    private static final HkdfPrfKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<HkdfPrfKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private HkdfPrfParams params_;
    private int version_;

    private HkdfPrfKey() {
    }

    @Override // com.google.crypto.tink.proto.HkdfPrfKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.HkdfPrfKeyOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.HkdfPrfKeyOrBuilder
    public HkdfPrfParams getParams() {
        HkdfPrfParams hkdfPrfParams = this.params_;
        return hkdfPrfParams == null ? HkdfPrfParams.getDefaultInstance() : hkdfPrfParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(HkdfPrfParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(HkdfPrfParams value) {
        value.getClass();
        HkdfPrfParams hkdfPrfParams = this.params_;
        if (hkdfPrfParams != null && hkdfPrfParams != HkdfPrfParams.getDefaultInstance()) {
            this.params_ = HkdfPrfParams.newBuilder(this.params_).mergeFrom((HkdfPrfParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.HkdfPrfKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static HkdfPrfKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (HkdfPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HkdfPrfKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HkdfPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HkdfPrfKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (HkdfPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HkdfPrfKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HkdfPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HkdfPrfKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (HkdfPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HkdfPrfKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HkdfPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HkdfPrfKey parseFrom(InputStream input) throws IOException {
        return (HkdfPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HkdfPrfKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HkdfPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HkdfPrfKey parseDelimitedFrom(InputStream input) throws IOException {
        return (HkdfPrfKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static HkdfPrfKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HkdfPrfKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HkdfPrfKey parseFrom(CodedInputStream input) throws IOException {
        return (HkdfPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HkdfPrfKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HkdfPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HkdfPrfKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<HkdfPrfKey, Builder> implements HkdfPrfKeyOrBuilder {
        /* synthetic */ Builder(C06241 c06241) {
            this();
        }

        private Builder() {
            super(HkdfPrfKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.HkdfPrfKeyOrBuilder
        public int getVersion() {
            return ((HkdfPrfKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((HkdfPrfKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((HkdfPrfKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.HkdfPrfKeyOrBuilder
        public boolean hasParams() {
            return ((HkdfPrfKey) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.HkdfPrfKeyOrBuilder
        public HkdfPrfParams getParams() {
            return ((HkdfPrfKey) this.instance).getParams();
        }

        public Builder setParams(HkdfPrfParams value) {
            copyOnWrite();
            ((HkdfPrfKey) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(HkdfPrfParams.Builder builderForValue) {
            copyOnWrite();
            ((HkdfPrfKey) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(HkdfPrfParams value) {
            copyOnWrite();
            ((HkdfPrfKey) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((HkdfPrfKey) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.HkdfPrfKeyOrBuilder
        public ByteString getKeyValue() {
            return ((HkdfPrfKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((HkdfPrfKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((HkdfPrfKey) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.HkdfPrfKey$1 */
    static /* synthetic */ class C06241 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f156xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f156xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f156xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f156xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f156xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f156xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f156xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f156xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06241 c06241 = null;
        switch (C06241.f156xa1df5c61[method.ordinal()]) {
            case 1:
                return new HkdfPrfKey();
            case 2:
                return new Builder(c06241);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HkdfPrfKey> parser = PARSER;
                if (parser == null) {
                    synchronized (HkdfPrfKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        HkdfPrfKey hkdfPrfKey = new HkdfPrfKey();
        DEFAULT_INSTANCE = hkdfPrfKey;
        GeneratedMessageLite.registerDefaultInstance(HkdfPrfKey.class, hkdfPrfKey);
    }

    public static HkdfPrfKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HkdfPrfKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/HkdfPrfKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.HkdfPrfParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class HkdfPrfKeyFormat extends GeneratedMessageLite<HkdfPrfKeyFormat, Builder> implements HkdfPrfKeyFormatOrBuilder {
    private static final HkdfPrfKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<HkdfPrfKeyFormat> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private HkdfPrfParams params_;
    private int version_;

    private HkdfPrfKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.HkdfPrfKeyFormatOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.HkdfPrfKeyFormatOrBuilder
    public HkdfPrfParams getParams() {
        HkdfPrfParams hkdfPrfParams = this.params_;
        return hkdfPrfParams == null ? HkdfPrfParams.getDefaultInstance() : hkdfPrfParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(HkdfPrfParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(HkdfPrfParams value) {
        value.getClass();
        HkdfPrfParams hkdfPrfParams = this.params_;
        if (hkdfPrfParams != null && hkdfPrfParams != HkdfPrfParams.getDefaultInstance()) {
            this.params_ = HkdfPrfParams.newBuilder(this.params_).mergeFrom((HkdfPrfParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.HkdfPrfKeyFormatOrBuilder
    public int getKeySize() {
        return this.keySize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeySize(int value) {
        this.keySize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    @Override // com.google.crypto.tink.proto.HkdfPrfKeyFormatOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static HkdfPrfKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (HkdfPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HkdfPrfKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HkdfPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HkdfPrfKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (HkdfPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HkdfPrfKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HkdfPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HkdfPrfKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (HkdfPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HkdfPrfKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HkdfPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HkdfPrfKeyFormat parseFrom(InputStream input) throws IOException {
        return (HkdfPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HkdfPrfKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HkdfPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HkdfPrfKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (HkdfPrfKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static HkdfPrfKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HkdfPrfKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HkdfPrfKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (HkdfPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HkdfPrfKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HkdfPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HkdfPrfKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<HkdfPrfKeyFormat, Builder> implements HkdfPrfKeyFormatOrBuilder {
        /* synthetic */ Builder(C06251 c06251) {
            this();
        }

        private Builder() {
            super(HkdfPrfKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.HkdfPrfKeyFormatOrBuilder
        public boolean hasParams() {
            return ((HkdfPrfKeyFormat) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.HkdfPrfKeyFormatOrBuilder
        public HkdfPrfParams getParams() {
            return ((HkdfPrfKeyFormat) this.instance).getParams();
        }

        public Builder setParams(HkdfPrfParams value) {
            copyOnWrite();
            ((HkdfPrfKeyFormat) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(HkdfPrfParams.Builder builderForValue) {
            copyOnWrite();
            ((HkdfPrfKeyFormat) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(HkdfPrfParams value) {
            copyOnWrite();
            ((HkdfPrfKeyFormat) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((HkdfPrfKeyFormat) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.HkdfPrfKeyFormatOrBuilder
        public int getKeySize() {
            return ((HkdfPrfKeyFormat) this.instance).getKeySize();
        }

        public Builder setKeySize(int value) {
            copyOnWrite();
            ((HkdfPrfKeyFormat) this.instance).setKeySize(value);
            return this;
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((HkdfPrfKeyFormat) this.instance).clearKeySize();
            return this;
        }

        @Override // com.google.crypto.tink.proto.HkdfPrfKeyFormatOrBuilder
        public int getVersion() {
            return ((HkdfPrfKeyFormat) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((HkdfPrfKeyFormat) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((HkdfPrfKeyFormat) this.instance).clearVersion();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.HkdfPrfKeyFormat$1 */
    static /* synthetic */ class C06251 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f157xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f157xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f157xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f157xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f157xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f157xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f157xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f157xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06251 c06251 = null;
        switch (C06251.f157xa1df5c61[method.ordinal()]) {
            case 1:
                return new HkdfPrfKeyFormat();
            case 2:
                return new Builder(c06251);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"params_", "keySize_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HkdfPrfKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (HkdfPrfKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        HkdfPrfKeyFormat hkdfPrfKeyFormat = new HkdfPrfKeyFormat();
        DEFAULT_INSTANCE = hkdfPrfKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(HkdfPrfKeyFormat.class, hkdfPrfKeyFormat);
    }

    public static HkdfPrfKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HkdfPrfKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/HkdfPrfKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface HkdfPrfKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    HkdfPrfParams getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/HkdfPrfKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface HkdfPrfKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    HkdfPrfParams getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/HkdfPrfParams.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class HkdfPrfParams extends GeneratedMessageLite<HkdfPrfParams, Builder> implements HkdfPrfParamsOrBuilder {
    private static final HkdfPrfParams DEFAULT_INSTANCE;
    public static final int HASH_FIELD_NUMBER = 1;
    private static volatile Parser<HkdfPrfParams> PARSER = null;
    public static final int SALT_FIELD_NUMBER = 2;
    private int hash_;
    private ByteString salt_ = ByteString.EMPTY;

    private HkdfPrfParams() {
    }

    @Override // com.google.crypto.tink.proto.HkdfPrfParamsOrBuilder
    public int getHashValue() {
        return this.hash_;
    }

    @Override // com.google.crypto.tink.proto.HkdfPrfParamsOrBuilder
    public HashType getHash() {
        HashType forNumber = HashType.forNumber(this.hash_);
        return forNumber == null ? HashType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHashValue(int value) {
        this.hash_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHash(HashType value) {
        this.hash_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHash() {
        this.hash_ = 0;
    }

    @Override // com.google.crypto.tink.proto.HkdfPrfParamsOrBuilder
    public ByteString getSalt() {
        return this.salt_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSalt(ByteString value) {
        value.getClass();
        this.salt_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSalt() {
        this.salt_ = getDefaultInstance().getSalt();
    }

    public static HkdfPrfParams parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (HkdfPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HkdfPrfParams parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HkdfPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HkdfPrfParams parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (HkdfPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HkdfPrfParams parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HkdfPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HkdfPrfParams parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (HkdfPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HkdfPrfParams parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HkdfPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HkdfPrfParams parseFrom(InputStream input) throws IOException {
        return (HkdfPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HkdfPrfParams parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HkdfPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HkdfPrfParams parseDelimitedFrom(InputStream input) throws IOException {
        return (HkdfPrfParams) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static HkdfPrfParams parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HkdfPrfParams) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HkdfPrfParams parseFrom(CodedInputStream input) throws IOException {
        return (HkdfPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HkdfPrfParams parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HkdfPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HkdfPrfParams prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<HkdfPrfParams, Builder> implements HkdfPrfParamsOrBuilder {
        /* synthetic */ Builder(C06261 c06261) {
            this();
        }

        private Builder() {
            super(HkdfPrfParams.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.HkdfPrfParamsOrBuilder
        public int getHashValue() {
            return ((HkdfPrfParams) this.instance).getHashValue();
        }

        public Builder setHashValue(int value) {
            copyOnWrite();
            ((HkdfPrfParams) this.instance).setHashValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.HkdfPrfParamsOrBuilder
        public HashType getHash() {
            return ((HkdfPrfParams) this.instance).getHash();
        }

        public Builder setHash(HashType value) {
            copyOnWrite();
            ((HkdfPrfParams) this.instance).setHash(value);
            return this;
        }

        public Builder clearHash() {
            copyOnWrite();
            ((HkdfPrfParams) this.instance).clearHash();
            return this;
        }

        @Override // com.google.crypto.tink.proto.HkdfPrfParamsOrBuilder
        public ByteString getSalt() {
            return ((HkdfPrfParams) this.instance).getSalt();
        }

        public Builder setSalt(ByteString value) {
            copyOnWrite();
            ((HkdfPrfParams) this.instance).setSalt(value);
            return this;
        }

        public Builder clearSalt() {
            copyOnWrite();
            ((HkdfPrfParams) this.instance).clearSalt();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.HkdfPrfParams$1 */
    static /* synthetic */ class C06261 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f158xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f158xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f158xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f158xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f158xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f158xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f158xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f158xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06261 c06261 = null;
        switch (C06261.f158xa1df5c61[method.ordinal()]) {
            case 1:
                return new HkdfPrfParams();
            case 2:
                return new Builder(c06261);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\n", new Object[]{"hash_", "salt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HkdfPrfParams> parser = PARSER;
                if (parser == null) {
                    synchronized (HkdfPrfParams.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        HkdfPrfParams hkdfPrfParams = new HkdfPrfParams();
        DEFAULT_INSTANCE = hkdfPrfParams;
        GeneratedMessageLite.registerDefaultInstance(HkdfPrfParams.class, hkdfPrfParams);
    }

    public static HkdfPrfParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HkdfPrfParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/HkdfPrfParamsOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface HkdfPrfParamsOrBuilder extends MessageLiteOrBuilder {
    HashType getHash();

    int getHashValue();

    ByteString getSalt();
}

// ===== FILE: com/google/crypto/tink/proto/Hmac.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class Hmac {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private Hmac() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/HmacKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class HmacKey extends GeneratedMessageLite<HmacKey, Builder> implements HmacKeyOrBuilder {
    private static final HmacKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<HmacKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private HmacParams params_;
    private int version_;

    private HmacKey() {
    }

    @Override // com.google.crypto.tink.proto.HmacKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.HmacKeyOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.HmacKeyOrBuilder
    public HmacParams getParams() {
        HmacParams hmacParams = this.params_;
        return hmacParams == null ? HmacParams.getDefaultInstance() : hmacParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(HmacParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(HmacParams value) {
        value.getClass();
        HmacParams hmacParams = this.params_;
        if (hmacParams != null && hmacParams != HmacParams.getDefaultInstance()) {
            this.params_ = HmacParams.newBuilder(this.params_).mergeFrom((HmacParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.HmacKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static HmacKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (HmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (HmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (HmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacKey parseFrom(InputStream input) throws IOException {
        return (HmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HmacKey parseDelimitedFrom(InputStream input) throws IOException {
        return (HmacKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HmacKey parseFrom(CodedInputStream input) throws IOException {
        return (HmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HmacKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<HmacKey, Builder> implements HmacKeyOrBuilder {
        /* synthetic */ Builder(C06271 c06271) {
            this();
        }

        private Builder() {
            super(HmacKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.HmacKeyOrBuilder
        public int getVersion() {
            return ((HmacKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((HmacKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((HmacKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.HmacKeyOrBuilder
        public boolean hasParams() {
            return ((HmacKey) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.HmacKeyOrBuilder
        public HmacParams getParams() {
            return ((HmacKey) this.instance).getParams();
        }

        public Builder setParams(HmacParams value) {
            copyOnWrite();
            ((HmacKey) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(HmacParams.Builder builderForValue) {
            copyOnWrite();
            ((HmacKey) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(HmacParams value) {
            copyOnWrite();
            ((HmacKey) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((HmacKey) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.HmacKeyOrBuilder
        public ByteString getKeyValue() {
            return ((HmacKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((HmacKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((HmacKey) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.HmacKey$1 */
    static /* synthetic */ class C06271 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f159xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f159xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f159xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f159xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f159xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f159xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f159xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f159xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06271 c06271 = null;
        switch (C06271.f159xa1df5c61[method.ordinal()]) {
            case 1:
                return new HmacKey();
            case 2:
                return new Builder(c06271);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HmacKey> parser = PARSER;
                if (parser == null) {
                    synchronized (HmacKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        HmacKey hmacKey = new HmacKey();
        DEFAULT_INSTANCE = hmacKey;
        GeneratedMessageLite.registerDefaultInstance(HmacKey.class, hmacKey);
    }

    public static HmacKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HmacKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/HmacKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class HmacKeyFormat extends GeneratedMessageLite<HmacKeyFormat, Builder> implements HmacKeyFormatOrBuilder {
    private static final HmacKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<HmacKeyFormat> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private HmacParams params_;
    private int version_;

    private HmacKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.HmacKeyFormatOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.HmacKeyFormatOrBuilder
    public HmacParams getParams() {
        HmacParams hmacParams = this.params_;
        return hmacParams == null ? HmacParams.getDefaultInstance() : hmacParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(HmacParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(HmacParams value) {
        value.getClass();
        HmacParams hmacParams = this.params_;
        if (hmacParams != null && hmacParams != HmacParams.getDefaultInstance()) {
            this.params_ = HmacParams.newBuilder(this.params_).mergeFrom((HmacParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.HmacKeyFormatOrBuilder
    public int getKeySize() {
        return this.keySize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeySize(int value) {
        this.keySize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    @Override // com.google.crypto.tink.proto.HmacKeyFormatOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static HmacKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacKeyFormat parseFrom(InputStream input) throws IOException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HmacKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (HmacKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HmacKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HmacKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<HmacKeyFormat, Builder> implements HmacKeyFormatOrBuilder {
        /* synthetic */ Builder(C06281 c06281) {
            this();
        }

        private Builder() {
            super(HmacKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.HmacKeyFormatOrBuilder
        public boolean hasParams() {
            return ((HmacKeyFormat) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.HmacKeyFormatOrBuilder
        public HmacParams getParams() {
            return ((HmacKeyFormat) this.instance).getParams();
        }

        public Builder setParams(HmacParams value) {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(HmacParams.Builder builderForValue) {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(HmacParams value) {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.HmacKeyFormatOrBuilder
        public int getKeySize() {
            return ((HmacKeyFormat) this.instance).getKeySize();
        }

        public Builder setKeySize(int value) {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).setKeySize(value);
            return this;
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).clearKeySize();
            return this;
        }

        @Override // com.google.crypto.tink.proto.HmacKeyFormatOrBuilder
        public int getVersion() {
            return ((HmacKeyFormat) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((HmacKeyFormat) this.instance).clearVersion();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.HmacKeyFormat$1 */
    static /* synthetic */ class C06281 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f160xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f160xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f160xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f160xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f160xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f160xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f160xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f160xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06281 c06281 = null;
        switch (C06281.f160xa1df5c61[method.ordinal()]) {
            case 1:
                return new HmacKeyFormat();
            case 2:
                return new Builder(c06281);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"params_", "keySize_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HmacKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (HmacKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        HmacKeyFormat hmacKeyFormat = new HmacKeyFormat();
        DEFAULT_INSTANCE = hmacKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(HmacKeyFormat.class, hmacKeyFormat);
    }

    public static HmacKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HmacKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/HmacKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface HmacKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    HmacParams getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/HmacKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface HmacKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    HmacParams getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/HmacParams.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class HmacParams extends GeneratedMessageLite<HmacParams, Builder> implements HmacParamsOrBuilder {
    private static final HmacParams DEFAULT_INSTANCE;
    public static final int HASH_FIELD_NUMBER = 1;
    private static volatile Parser<HmacParams> PARSER = null;
    public static final int TAG_SIZE_FIELD_NUMBER = 2;
    private int hash_;
    private int tagSize_;

    private HmacParams() {
    }

    @Override // com.google.crypto.tink.proto.HmacParamsOrBuilder
    public int getHashValue() {
        return this.hash_;
    }

    @Override // com.google.crypto.tink.proto.HmacParamsOrBuilder
    public HashType getHash() {
        HashType forNumber = HashType.forNumber(this.hash_);
        return forNumber == null ? HashType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHashValue(int value) {
        this.hash_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHash(HashType value) {
        this.hash_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHash() {
        this.hash_ = 0;
    }

    @Override // com.google.crypto.tink.proto.HmacParamsOrBuilder
    public int getTagSize() {
        return this.tagSize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTagSize(int value) {
        this.tagSize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTagSize() {
        this.tagSize_ = 0;
    }

    public static HmacParams parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (HmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacParams parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacParams parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (HmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacParams parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacParams parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (HmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacParams parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacParams parseFrom(InputStream input) throws IOException {
        return (HmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacParams parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HmacParams parseDelimitedFrom(InputStream input) throws IOException {
        return (HmacParams) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacParams parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacParams) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HmacParams parseFrom(CodedInputStream input) throws IOException {
        return (HmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacParams parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HmacParams prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<HmacParams, Builder> implements HmacParamsOrBuilder {
        /* synthetic */ Builder(C06291 c06291) {
            this();
        }

        private Builder() {
            super(HmacParams.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.HmacParamsOrBuilder
        public int getHashValue() {
            return ((HmacParams) this.instance).getHashValue();
        }

        public Builder setHashValue(int value) {
            copyOnWrite();
            ((HmacParams) this.instance).setHashValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.HmacParamsOrBuilder
        public HashType getHash() {
            return ((HmacParams) this.instance).getHash();
        }

        public Builder setHash(HashType value) {
            copyOnWrite();
            ((HmacParams) this.instance).setHash(value);
            return this;
        }

        public Builder clearHash() {
            copyOnWrite();
            ((HmacParams) this.instance).clearHash();
            return this;
        }

        @Override // com.google.crypto.tink.proto.HmacParamsOrBuilder
        public int getTagSize() {
            return ((HmacParams) this.instance).getTagSize();
        }

        public Builder setTagSize(int value) {
            copyOnWrite();
            ((HmacParams) this.instance).setTagSize(value);
            return this;
        }

        public Builder clearTagSize() {
            copyOnWrite();
            ((HmacParams) this.instance).clearTagSize();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.HmacParams$1 */
    static /* synthetic */ class C06291 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f161xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f161xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f161xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f161xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f161xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f161xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f161xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f161xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06291 c06291 = null;
        switch (C06291.f161xa1df5c61[method.ordinal()]) {
            case 1:
                return new HmacParams();
            case 2:
                return new Builder(c06291);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"hash_", "tagSize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HmacParams> parser = PARSER;
                if (parser == null) {
                    synchronized (HmacParams.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        HmacParams hmacParams = new HmacParams();
        DEFAULT_INSTANCE = hmacParams;
        GeneratedMessageLite.registerDefaultInstance(HmacParams.class, hmacParams);
    }

    public static HmacParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HmacParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/HmacParamsOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface HmacParamsOrBuilder extends MessageLiteOrBuilder {
    HashType getHash();

    int getHashValue();

    int getTagSize();
}

// ===== FILE: com/google/crypto/tink/proto/HmacPrf.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class HmacPrf {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private HmacPrf() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/HmacPrfKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.HmacPrfParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class HmacPrfKey extends GeneratedMessageLite<HmacPrfKey, Builder> implements HmacPrfKeyOrBuilder {
    private static final HmacPrfKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<HmacPrfKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private HmacPrfParams params_;
    private int version_;

    private HmacPrfKey() {
    }

    @Override // com.google.crypto.tink.proto.HmacPrfKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.HmacPrfKeyOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.HmacPrfKeyOrBuilder
    public HmacPrfParams getParams() {
        HmacPrfParams hmacPrfParams = this.params_;
        return hmacPrfParams == null ? HmacPrfParams.getDefaultInstance() : hmacPrfParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(HmacPrfParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(HmacPrfParams value) {
        value.getClass();
        HmacPrfParams hmacPrfParams = this.params_;
        if (hmacPrfParams != null && hmacPrfParams != HmacPrfParams.getDefaultInstance()) {
            this.params_ = HmacPrfParams.newBuilder(this.params_).mergeFrom((HmacPrfParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.HmacPrfKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static HmacPrfKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (HmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacPrfKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacPrfKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (HmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacPrfKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacPrfKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (HmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacPrfKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacPrfKey parseFrom(InputStream input) throws IOException {
        return (HmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacPrfKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HmacPrfKey parseDelimitedFrom(InputStream input) throws IOException {
        return (HmacPrfKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacPrfKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacPrfKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HmacPrfKey parseFrom(CodedInputStream input) throws IOException {
        return (HmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacPrfKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacPrfKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HmacPrfKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<HmacPrfKey, Builder> implements HmacPrfKeyOrBuilder {
        /* synthetic */ Builder(C06301 c06301) {
            this();
        }

        private Builder() {
            super(HmacPrfKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.HmacPrfKeyOrBuilder
        public int getVersion() {
            return ((HmacPrfKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((HmacPrfKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((HmacPrfKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.HmacPrfKeyOrBuilder
        public boolean hasParams() {
            return ((HmacPrfKey) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.HmacPrfKeyOrBuilder
        public HmacPrfParams getParams() {
            return ((HmacPrfKey) this.instance).getParams();
        }

        public Builder setParams(HmacPrfParams value) {
            copyOnWrite();
            ((HmacPrfKey) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(HmacPrfParams.Builder builderForValue) {
            copyOnWrite();
            ((HmacPrfKey) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(HmacPrfParams value) {
            copyOnWrite();
            ((HmacPrfKey) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((HmacPrfKey) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.HmacPrfKeyOrBuilder
        public ByteString getKeyValue() {
            return ((HmacPrfKey) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((HmacPrfKey) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((HmacPrfKey) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.HmacPrfKey$1 */
    static /* synthetic */ class C06301 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f162xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f162xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f162xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f162xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f162xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f162xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f162xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f162xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06301 c06301 = null;
        switch (C06301.f162xa1df5c61[method.ordinal()]) {
            case 1:
                return new HmacPrfKey();
            case 2:
                return new Builder(c06301);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HmacPrfKey> parser = PARSER;
                if (parser == null) {
                    synchronized (HmacPrfKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        HmacPrfKey hmacPrfKey = new HmacPrfKey();
        DEFAULT_INSTANCE = hmacPrfKey;
        GeneratedMessageLite.registerDefaultInstance(HmacPrfKey.class, hmacPrfKey);
    }

    public static HmacPrfKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HmacPrfKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/HmacPrfKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.HmacPrfParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class HmacPrfKeyFormat extends GeneratedMessageLite<HmacPrfKeyFormat, Builder> implements HmacPrfKeyFormatOrBuilder {
    private static final HmacPrfKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<HmacPrfKeyFormat> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int keySize_;
    private HmacPrfParams params_;
    private int version_;

    private HmacPrfKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.HmacPrfKeyFormatOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.HmacPrfKeyFormatOrBuilder
    public HmacPrfParams getParams() {
        HmacPrfParams hmacPrfParams = this.params_;
        return hmacPrfParams == null ? HmacPrfParams.getDefaultInstance() : hmacPrfParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(HmacPrfParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(HmacPrfParams value) {
        value.getClass();
        HmacPrfParams hmacPrfParams = this.params_;
        if (hmacPrfParams != null && hmacPrfParams != HmacPrfParams.getDefaultInstance()) {
            this.params_ = HmacPrfParams.newBuilder(this.params_).mergeFrom((HmacPrfParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.HmacPrfKeyFormatOrBuilder
    public int getKeySize() {
        return this.keySize_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeySize(int value) {
        this.keySize_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeySize() {
        this.keySize_ = 0;
    }

    @Override // com.google.crypto.tink.proto.HmacPrfKeyFormatOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static HmacPrfKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (HmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacPrfKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacPrfKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (HmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacPrfKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacPrfKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (HmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacPrfKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacPrfKeyFormat parseFrom(InputStream input) throws IOException {
        return (HmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacPrfKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HmacPrfKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (HmacPrfKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacPrfKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacPrfKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HmacPrfKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (HmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacPrfKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacPrfKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HmacPrfKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<HmacPrfKeyFormat, Builder> implements HmacPrfKeyFormatOrBuilder {
        /* synthetic */ Builder(C06311 c06311) {
            this();
        }

        private Builder() {
            super(HmacPrfKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.HmacPrfKeyFormatOrBuilder
        public boolean hasParams() {
            return ((HmacPrfKeyFormat) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.HmacPrfKeyFormatOrBuilder
        public HmacPrfParams getParams() {
            return ((HmacPrfKeyFormat) this.instance).getParams();
        }

        public Builder setParams(HmacPrfParams value) {
            copyOnWrite();
            ((HmacPrfKeyFormat) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(HmacPrfParams.Builder builderForValue) {
            copyOnWrite();
            ((HmacPrfKeyFormat) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(HmacPrfParams value) {
            copyOnWrite();
            ((HmacPrfKeyFormat) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((HmacPrfKeyFormat) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.HmacPrfKeyFormatOrBuilder
        public int getKeySize() {
            return ((HmacPrfKeyFormat) this.instance).getKeySize();
        }

        public Builder setKeySize(int value) {
            copyOnWrite();
            ((HmacPrfKeyFormat) this.instance).setKeySize(value);
            return this;
        }

        public Builder clearKeySize() {
            copyOnWrite();
            ((HmacPrfKeyFormat) this.instance).clearKeySize();
            return this;
        }

        @Override // com.google.crypto.tink.proto.HmacPrfKeyFormatOrBuilder
        public int getVersion() {
            return ((HmacPrfKeyFormat) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((HmacPrfKeyFormat) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((HmacPrfKeyFormat) this.instance).clearVersion();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.HmacPrfKeyFormat$1 */
    static /* synthetic */ class C06311 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f163xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f163xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f163xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f163xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f163xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f163xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f163xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f163xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06311 c06311 = null;
        switch (C06311.f163xa1df5c61[method.ordinal()]) {
            case 1:
                return new HmacPrfKeyFormat();
            case 2:
                return new Builder(c06311);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"params_", "keySize_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HmacPrfKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (HmacPrfKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        HmacPrfKeyFormat hmacPrfKeyFormat = new HmacPrfKeyFormat();
        DEFAULT_INSTANCE = hmacPrfKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(HmacPrfKeyFormat.class, hmacPrfKeyFormat);
    }

    public static HmacPrfKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HmacPrfKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/HmacPrfKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface HmacPrfKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getKeySize();

    HmacPrfParams getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/HmacPrfKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface HmacPrfKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    HmacPrfParams getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/HmacPrfParams.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class HmacPrfParams extends GeneratedMessageLite<HmacPrfParams, Builder> implements HmacPrfParamsOrBuilder {
    private static final HmacPrfParams DEFAULT_INSTANCE;
    public static final int HASH_FIELD_NUMBER = 1;
    private static volatile Parser<HmacPrfParams> PARSER;
    private int hash_;

    private HmacPrfParams() {
    }

    @Override // com.google.crypto.tink.proto.HmacPrfParamsOrBuilder
    public int getHashValue() {
        return this.hash_;
    }

    @Override // com.google.crypto.tink.proto.HmacPrfParamsOrBuilder
    public HashType getHash() {
        HashType forNumber = HashType.forNumber(this.hash_);
        return forNumber == null ? HashType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHashValue(int value) {
        this.hash_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHash(HashType value) {
        this.hash_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHash() {
        this.hash_ = 0;
    }

    public static HmacPrfParams parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (HmacPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacPrfParams parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacPrfParams parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (HmacPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacPrfParams parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacPrfParams parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (HmacPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static HmacPrfParams parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (HmacPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static HmacPrfParams parseFrom(InputStream input) throws IOException {
        return (HmacPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacPrfParams parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HmacPrfParams parseDelimitedFrom(InputStream input) throws IOException {
        return (HmacPrfParams) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacPrfParams parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacPrfParams) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static HmacPrfParams parseFrom(CodedInputStream input) throws IOException {
        return (HmacPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static HmacPrfParams parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (HmacPrfParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HmacPrfParams prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<HmacPrfParams, Builder> implements HmacPrfParamsOrBuilder {
        /* synthetic */ Builder(C06321 c06321) {
            this();
        }

        private Builder() {
            super(HmacPrfParams.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.HmacPrfParamsOrBuilder
        public int getHashValue() {
            return ((HmacPrfParams) this.instance).getHashValue();
        }

        public Builder setHashValue(int value) {
            copyOnWrite();
            ((HmacPrfParams) this.instance).setHashValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.HmacPrfParamsOrBuilder
        public HashType getHash() {
            return ((HmacPrfParams) this.instance).getHash();
        }

        public Builder setHash(HashType value) {
            copyOnWrite();
            ((HmacPrfParams) this.instance).setHash(value);
            return this;
        }

        public Builder clearHash() {
            copyOnWrite();
            ((HmacPrfParams) this.instance).clearHash();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.HmacPrfParams$1 */
    static /* synthetic */ class C06321 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f164xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f164xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f164xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f164xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f164xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f164xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f164xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f164xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06321 c06321 = null;
        switch (C06321.f164xa1df5c61[method.ordinal()]) {
            case 1:
                return new HmacPrfParams();
            case 2:
                return new Builder(c06321);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"hash_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HmacPrfParams> parser = PARSER;
                if (parser == null) {
                    synchronized (HmacPrfParams.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        HmacPrfParams hmacPrfParams = new HmacPrfParams();
        DEFAULT_INSTANCE = hmacPrfParams;
        GeneratedMessageLite.registerDefaultInstance(HmacPrfParams.class, hmacPrfParams);
    }

    public static HmacPrfParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HmacPrfParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/HmacPrfParamsOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface HmacPrfParamsOrBuilder extends MessageLiteOrBuilder {
    HashType getHash();

    int getHashValue();
}

// ===== FILE: com/google/crypto/tink/proto/KeyData.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class KeyData extends GeneratedMessageLite<KeyData, Builder> implements KeyDataOrBuilder {
    private static final KeyData DEFAULT_INSTANCE;
    public static final int KEY_MATERIAL_TYPE_FIELD_NUMBER = 3;
    private static volatile Parser<KeyData> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int keyMaterialType_;
    private String typeUrl_ = "";
    private ByteString value_ = ByteString.EMPTY;

    private KeyData() {
    }

    public enum KeyMaterialType implements Internal.EnumLite {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);

        public static final int ASYMMETRIC_PRIVATE_VALUE = 2;
        public static final int ASYMMETRIC_PUBLIC_VALUE = 3;
        public static final int REMOTE_VALUE = 4;
        public static final int SYMMETRIC_VALUE = 1;
        public static final int UNKNOWN_KEYMATERIAL_VALUE = 0;
        private static final Internal.EnumLiteMap<KeyMaterialType> internalValueMap = new Internal.EnumLiteMap<KeyMaterialType>() { // from class: com.google.crypto.tink.proto.KeyData.KeyMaterialType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
            public KeyMaterialType findValueByNumber(int number) {
                return KeyMaterialType.forNumber(number);
            }
        };
        private final int value;

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static KeyMaterialType valueOf(int value) {
            return forNumber(value);
        }

        public static KeyMaterialType forNumber(int value) {
            if (value == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (value == 1) {
                return SYMMETRIC;
            }
            if (value == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (value == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (value != 4) {
                return null;
            }
            return REMOTE;
        }

        public static Internal.EnumLiteMap<KeyMaterialType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return KeyMaterialTypeVerifier.INSTANCE;
        }

        private static final class KeyMaterialTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new KeyMaterialTypeVerifier();

            private KeyMaterialTypeVerifier() {
            }

            @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
            public boolean isInRange(int number) {
                return KeyMaterialType.forNumber(number) != null;
            }
        }

        KeyMaterialType(int value) {
            this.value = value;
        }
    }

    @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
    public String getTypeUrl() {
        return this.typeUrl_;
    }

    @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
    public ByteString getTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.typeUrl_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeUrl(String value) {
        value.getClass();
        this.typeUrl_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTypeUrl() {
        this.typeUrl_ = getDefaultInstance().getTypeUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeUrlBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.typeUrl_ = value.toStringUtf8();
    }

    @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
    public ByteString getValue() {
        return this.value_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(ByteString value) {
        value.getClass();
        this.value_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = getDefaultInstance().getValue();
    }

    @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
    public int getKeyMaterialTypeValue() {
        return this.keyMaterialType_;
    }

    @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
    public KeyMaterialType getKeyMaterialType() {
        KeyMaterialType forNumber = KeyMaterialType.forNumber(this.keyMaterialType_);
        return forNumber == null ? KeyMaterialType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyMaterialTypeValue(int value) {
        this.keyMaterialType_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyMaterialType(KeyMaterialType value) {
        this.keyMaterialType_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyMaterialType() {
        this.keyMaterialType_ = 0;
    }

    public static KeyData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (KeyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KeyData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KeyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KeyData parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (KeyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KeyData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KeyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KeyData parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (KeyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KeyData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KeyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KeyData parseFrom(InputStream input) throws IOException {
        return (KeyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KeyData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KeyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KeyData parseDelimitedFrom(InputStream input) throws IOException {
        return (KeyData) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static KeyData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KeyData) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KeyData parseFrom(CodedInputStream input) throws IOException {
        return (KeyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KeyData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KeyData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(KeyData prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<KeyData, Builder> implements KeyDataOrBuilder {
        /* synthetic */ Builder(C06331 c06331) {
            this();
        }

        private Builder() {
            super(KeyData.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
        public String getTypeUrl() {
            return ((KeyData) this.instance).getTypeUrl();
        }

        @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
        public ByteString getTypeUrlBytes() {
            return ((KeyData) this.instance).getTypeUrlBytes();
        }

        public Builder setTypeUrl(String value) {
            copyOnWrite();
            ((KeyData) this.instance).setTypeUrl(value);
            return this;
        }

        public Builder clearTypeUrl() {
            copyOnWrite();
            ((KeyData) this.instance).clearTypeUrl();
            return this;
        }

        public Builder setTypeUrlBytes(ByteString value) {
            copyOnWrite();
            ((KeyData) this.instance).setTypeUrlBytes(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
        public ByteString getValue() {
            return ((KeyData) this.instance).getValue();
        }

        public Builder setValue(ByteString value) {
            copyOnWrite();
            ((KeyData) this.instance).setValue(value);
            return this;
        }

        public Builder clearValue() {
            copyOnWrite();
            ((KeyData) this.instance).clearValue();
            return this;
        }

        @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
        public int getKeyMaterialTypeValue() {
            return ((KeyData) this.instance).getKeyMaterialTypeValue();
        }

        public Builder setKeyMaterialTypeValue(int value) {
            copyOnWrite();
            ((KeyData) this.instance).setKeyMaterialTypeValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.KeyDataOrBuilder
        public KeyMaterialType getKeyMaterialType() {
            return ((KeyData) this.instance).getKeyMaterialType();
        }

        public Builder setKeyMaterialType(KeyMaterialType value) {
            copyOnWrite();
            ((KeyData) this.instance).setKeyMaterialType(value);
            return this;
        }

        public Builder clearKeyMaterialType() {
            copyOnWrite();
            ((KeyData) this.instance).clearKeyMaterialType();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.KeyData$1 */
    static /* synthetic */ class C06331 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f165xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f165xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f165xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f165xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f165xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f165xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f165xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f165xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06331 c06331 = null;
        switch (C06331.f165xa1df5c61[method.ordinal()]) {
            case 1:
                return new KeyData();
            case 2:
                return new Builder(c06331);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "keyMaterialType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<KeyData> parser = PARSER;
                if (parser == null) {
                    synchronized (KeyData.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        KeyData keyData = new KeyData();
        DEFAULT_INSTANCE = keyData;
        GeneratedMessageLite.registerDefaultInstance(KeyData.class, keyData);
    }

    public static KeyData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<KeyData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/KeyDataOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface KeyDataOrBuilder extends MessageLiteOrBuilder {
    KeyData.KeyMaterialType getKeyMaterialType();

    int getKeyMaterialTypeValue();

    String getTypeUrl();

    ByteString getTypeUrlBytes();

    ByteString getValue();
}

// ===== FILE: com/google/crypto/tink/proto/KeyStatusType.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* loaded from: classes.dex */
public enum KeyStatusType implements Internal.EnumLite {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);

    public static final int DESTROYED_VALUE = 3;
    public static final int DISABLED_VALUE = 2;
    public static final int ENABLED_VALUE = 1;
    public static final int UNKNOWN_STATUS_VALUE = 0;
    private static final Internal.EnumLiteMap<KeyStatusType> internalValueMap = new Internal.EnumLiteMap<KeyStatusType>() { // from class: com.google.crypto.tink.proto.KeyStatusType.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public KeyStatusType findValueByNumber(int number) {
            return KeyStatusType.forNumber(number);
        }
    };
    private final int value;

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static KeyStatusType valueOf(int value) {
        return forNumber(value);
    }

    public static KeyStatusType forNumber(int value) {
        if (value == 0) {
            return UNKNOWN_STATUS;
        }
        if (value == 1) {
            return ENABLED;
        }
        if (value == 2) {
            return DISABLED;
        }
        if (value != 3) {
            return null;
        }
        return DESTROYED;
    }

    public static Internal.EnumLiteMap<KeyStatusType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return KeyStatusTypeVerifier.INSTANCE;
    }

    private static final class KeyStatusTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new KeyStatusTypeVerifier();

        private KeyStatusTypeVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            return KeyStatusType.forNumber(number) != null;
        }
    }

    KeyStatusType(int value) {
        this.value = value;
    }
}

// ===== FILE: com/google/crypto/tink/proto/KeyTemplate.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class KeyTemplate extends GeneratedMessageLite<KeyTemplate, Builder> implements KeyTemplateOrBuilder {
    private static final KeyTemplate DEFAULT_INSTANCE;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 3;
    private static volatile Parser<KeyTemplate> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int outputPrefixType_;
    private String typeUrl_ = "";
    private ByteString value_ = ByteString.EMPTY;

    private KeyTemplate() {
    }

    @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
    public String getTypeUrl() {
        return this.typeUrl_;
    }

    @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
    public ByteString getTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.typeUrl_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeUrl(String value) {
        value.getClass();
        this.typeUrl_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTypeUrl() {
        this.typeUrl_ = getDefaultInstance().getTypeUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeUrlBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.typeUrl_ = value.toStringUtf8();
    }

    @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
    public ByteString getValue() {
        return this.value_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(ByteString value) {
        value.getClass();
        this.value_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = getDefaultInstance().getValue();
    }

    @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
    public int getOutputPrefixTypeValue() {
        return this.outputPrefixType_;
    }

    @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
    public OutputPrefixType getOutputPrefixType() {
        OutputPrefixType forNumber = OutputPrefixType.forNumber(this.outputPrefixType_);
        return forNumber == null ? OutputPrefixType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutputPrefixTypeValue(int value) {
        this.outputPrefixType_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOutputPrefixType(OutputPrefixType value) {
        this.outputPrefixType_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOutputPrefixType() {
        this.outputPrefixType_ = 0;
    }

    public static KeyTemplate parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (KeyTemplate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KeyTemplate parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KeyTemplate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KeyTemplate parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (KeyTemplate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KeyTemplate parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KeyTemplate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KeyTemplate parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (KeyTemplate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KeyTemplate parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KeyTemplate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KeyTemplate parseFrom(InputStream input) throws IOException {
        return (KeyTemplate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KeyTemplate parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KeyTemplate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KeyTemplate parseDelimitedFrom(InputStream input) throws IOException {
        return (KeyTemplate) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static KeyTemplate parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KeyTemplate) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KeyTemplate parseFrom(CodedInputStream input) throws IOException {
        return (KeyTemplate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KeyTemplate parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KeyTemplate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(KeyTemplate prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<KeyTemplate, Builder> implements KeyTemplateOrBuilder {
        /* synthetic */ Builder(C06361 c06361) {
            this();
        }

        private Builder() {
            super(KeyTemplate.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
        public String getTypeUrl() {
            return ((KeyTemplate) this.instance).getTypeUrl();
        }

        @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
        public ByteString getTypeUrlBytes() {
            return ((KeyTemplate) this.instance).getTypeUrlBytes();
        }

        public Builder setTypeUrl(String value) {
            copyOnWrite();
            ((KeyTemplate) this.instance).setTypeUrl(value);
            return this;
        }

        public Builder clearTypeUrl() {
            copyOnWrite();
            ((KeyTemplate) this.instance).clearTypeUrl();
            return this;
        }

        public Builder setTypeUrlBytes(ByteString value) {
            copyOnWrite();
            ((KeyTemplate) this.instance).setTypeUrlBytes(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
        public ByteString getValue() {
            return ((KeyTemplate) this.instance).getValue();
        }

        public Builder setValue(ByteString value) {
            copyOnWrite();
            ((KeyTemplate) this.instance).setValue(value);
            return this;
        }

        public Builder clearValue() {
            copyOnWrite();
            ((KeyTemplate) this.instance).clearValue();
            return this;
        }

        @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
        public int getOutputPrefixTypeValue() {
            return ((KeyTemplate) this.instance).getOutputPrefixTypeValue();
        }

        public Builder setOutputPrefixTypeValue(int value) {
            copyOnWrite();
            ((KeyTemplate) this.instance).setOutputPrefixTypeValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.KeyTemplateOrBuilder
        public OutputPrefixType getOutputPrefixType() {
            return ((KeyTemplate) this.instance).getOutputPrefixType();
        }

        public Builder setOutputPrefixType(OutputPrefixType value) {
            copyOnWrite();
            ((KeyTemplate) this.instance).setOutputPrefixType(value);
            return this;
        }

        public Builder clearOutputPrefixType() {
            copyOnWrite();
            ((KeyTemplate) this.instance).clearOutputPrefixType();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.KeyTemplate$1 */
    static /* synthetic */ class C06361 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f166xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f166xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f166xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f166xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f166xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f166xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f166xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f166xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06361 c06361 = null;
        switch (C06361.f166xa1df5c61[method.ordinal()]) {
            case 1:
                return new KeyTemplate();
            case 2:
                return new Builder(c06361);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "outputPrefixType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<KeyTemplate> parser = PARSER;
                if (parser == null) {
                    synchronized (KeyTemplate.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        KeyTemplate keyTemplate = new KeyTemplate();
        DEFAULT_INSTANCE = keyTemplate;
        GeneratedMessageLite.registerDefaultInstance(KeyTemplate.class, keyTemplate);
    }

    public static KeyTemplate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<KeyTemplate> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/KeyTemplateOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface KeyTemplateOrBuilder extends MessageLiteOrBuilder {
    OutputPrefixType getOutputPrefixType();

    int getOutputPrefixTypeValue();

    String getTypeUrl();

    ByteString getTypeUrlBytes();

    ByteString getValue();
}

// ===== FILE: com/google/crypto/tink/proto/KeyTypeEntry.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@Deprecated
/* loaded from: classes.dex */
public final class KeyTypeEntry extends GeneratedMessageLite<KeyTypeEntry, Builder> implements KeyTypeEntryOrBuilder {
    public static final int CATALOGUE_NAME_FIELD_NUMBER = 5;
    private static final KeyTypeEntry DEFAULT_INSTANCE;
    public static final int KEY_MANAGER_VERSION_FIELD_NUMBER = 3;
    public static final int NEW_KEY_ALLOWED_FIELD_NUMBER = 4;
    private static volatile Parser<KeyTypeEntry> PARSER = null;
    public static final int PRIMITIVE_NAME_FIELD_NUMBER = 1;
    public static final int TYPE_URL_FIELD_NUMBER = 2;
    private int keyManagerVersion_;
    private boolean newKeyAllowed_;
    private String primitiveName_ = "";
    private String typeUrl_ = "";
    private String catalogueName_ = "";

    private KeyTypeEntry() {
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public String getPrimitiveName() {
        return this.primitiveName_;
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public ByteString getPrimitiveNameBytes() {
        return ByteString.copyFromUtf8(this.primitiveName_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrimitiveName(String value) {
        value.getClass();
        this.primitiveName_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPrimitiveName() {
        this.primitiveName_ = getDefaultInstance().getPrimitiveName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrimitiveNameBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.primitiveName_ = value.toStringUtf8();
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public String getTypeUrl() {
        return this.typeUrl_;
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public ByteString getTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.typeUrl_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeUrl(String value) {
        value.getClass();
        this.typeUrl_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTypeUrl() {
        this.typeUrl_ = getDefaultInstance().getTypeUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeUrlBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.typeUrl_ = value.toStringUtf8();
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public int getKeyManagerVersion() {
        return this.keyManagerVersion_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyManagerVersion(int value) {
        this.keyManagerVersion_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyManagerVersion() {
        this.keyManagerVersion_ = 0;
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public boolean getNewKeyAllowed() {
        return this.newKeyAllowed_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewKeyAllowed(boolean value) {
        this.newKeyAllowed_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNewKeyAllowed() {
        this.newKeyAllowed_ = false;
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public String getCatalogueName() {
        return this.catalogueName_;
    }

    @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
    public ByteString getCatalogueNameBytes() {
        return ByteString.copyFromUtf8(this.catalogueName_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCatalogueName(String value) {
        value.getClass();
        this.catalogueName_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCatalogueName() {
        this.catalogueName_ = getDefaultInstance().getCatalogueName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCatalogueNameBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.catalogueName_ = value.toStringUtf8();
    }

    public static KeyTypeEntry parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KeyTypeEntry parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KeyTypeEntry parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KeyTypeEntry parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KeyTypeEntry parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KeyTypeEntry parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KeyTypeEntry parseFrom(InputStream input) throws IOException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KeyTypeEntry parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KeyTypeEntry parseDelimitedFrom(InputStream input) throws IOException {
        return (KeyTypeEntry) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static KeyTypeEntry parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KeyTypeEntry) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KeyTypeEntry parseFrom(CodedInputStream input) throws IOException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KeyTypeEntry parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KeyTypeEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(KeyTypeEntry prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<KeyTypeEntry, Builder> implements KeyTypeEntryOrBuilder {
        /* synthetic */ Builder(C06371 c06371) {
            this();
        }

        private Builder() {
            super(KeyTypeEntry.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
        public String getPrimitiveName() {
            return ((KeyTypeEntry) this.instance).getPrimitiveName();
        }

        @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
        public ByteString getPrimitiveNameBytes() {
            return ((KeyTypeEntry) this.instance).getPrimitiveNameBytes();
        }

        public Builder setPrimitiveName(String value) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setPrimitiveName(value);
            return this;
        }

        public Builder clearPrimitiveName() {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).clearPrimitiveName();
            return this;
        }

        public Builder setPrimitiveNameBytes(ByteString value) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setPrimitiveNameBytes(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
        public String getTypeUrl() {
            return ((KeyTypeEntry) this.instance).getTypeUrl();
        }

        @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
        public ByteString getTypeUrlBytes() {
            return ((KeyTypeEntry) this.instance).getTypeUrlBytes();
        }

        public Builder setTypeUrl(String value) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setTypeUrl(value);
            return this;
        }

        public Builder clearTypeUrl() {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).clearTypeUrl();
            return this;
        }

        public Builder setTypeUrlBytes(ByteString value) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setTypeUrlBytes(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
        public int getKeyManagerVersion() {
            return ((KeyTypeEntry) this.instance).getKeyManagerVersion();
        }

        public Builder setKeyManagerVersion(int value) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setKeyManagerVersion(value);
            return this;
        }

        public Builder clearKeyManagerVersion() {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).clearKeyManagerVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
        public boolean getNewKeyAllowed() {
            return ((KeyTypeEntry) this.instance).getNewKeyAllowed();
        }

        public Builder setNewKeyAllowed(boolean value) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setNewKeyAllowed(value);
            return this;
        }

        public Builder clearNewKeyAllowed() {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).clearNewKeyAllowed();
            return this;
        }

        @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
        public String getCatalogueName() {
            return ((KeyTypeEntry) this.instance).getCatalogueName();
        }

        @Override // com.google.crypto.tink.proto.KeyTypeEntryOrBuilder
        public ByteString getCatalogueNameBytes() {
            return ((KeyTypeEntry) this.instance).getCatalogueNameBytes();
        }

        public Builder setCatalogueName(String value) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setCatalogueName(value);
            return this;
        }

        public Builder clearCatalogueName() {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).clearCatalogueName();
            return this;
        }

        public Builder setCatalogueNameBytes(ByteString value) {
            copyOnWrite();
            ((KeyTypeEntry) this.instance).setCatalogueNameBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.KeyTypeEntry$1 */
    static /* synthetic */ class C06371 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f167xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f167xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f167xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f167xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f167xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f167xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f167xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f167xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06371 c06371 = null;
        switch (C06371.f167xa1df5c61[method.ordinal()]) {
            case 1:
                return new KeyTypeEntry();
            case 2:
                return new Builder(c06371);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"primitiveName_", "typeUrl_", "keyManagerVersion_", "newKeyAllowed_", "catalogueName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<KeyTypeEntry> parser = PARSER;
                if (parser == null) {
                    synchronized (KeyTypeEntry.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        KeyTypeEntry keyTypeEntry = new KeyTypeEntry();
        DEFAULT_INSTANCE = keyTypeEntry;
        GeneratedMessageLite.registerDefaultInstance(KeyTypeEntry.class, keyTypeEntry);
    }

    public static KeyTypeEntry getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<KeyTypeEntry> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/KeyTypeEntryOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

@Deprecated
/* loaded from: classes.dex */
public interface KeyTypeEntryOrBuilder extends MessageLiteOrBuilder {
    String getCatalogueName();

    ByteString getCatalogueNameBytes();

    int getKeyManagerVersion();

    boolean getNewKeyAllowed();

    String getPrimitiveName();

    ByteString getPrimitiveNameBytes();

    String getTypeUrl();

    ByteString getTypeUrlBytes();
}

// ===== FILE: com/google/crypto/tink/proto/Keyset.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class Keyset extends GeneratedMessageLite<Keyset, Builder> implements KeysetOrBuilder {
    private static final Keyset DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile Parser<Keyset> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private Internal.ProtobufList<Key> key_ = emptyProtobufList();
    private int primaryKeyId_;

    public interface KeyOrBuilder extends MessageLiteOrBuilder {
        KeyData getKeyData();

        int getKeyId();

        OutputPrefixType getOutputPrefixType();

        int getOutputPrefixTypeValue();

        KeyStatusType getStatus();

        int getStatusValue();

        boolean hasKeyData();
    }

    private Keyset() {
    }

    public static final class Key extends GeneratedMessageLite<Key, Builder> implements KeyOrBuilder {
        private static final Key DEFAULT_INSTANCE;
        public static final int KEY_DATA_FIELD_NUMBER = 1;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        private static volatile Parser<Key> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        private KeyData keyData_;
        private int keyId_;
        private int outputPrefixType_;
        private int status_;

        private Key() {
        }

        @Override // com.google.crypto.tink.proto.Keyset.KeyOrBuilder
        public boolean hasKeyData() {
            return this.keyData_ != null;
        }

        @Override // com.google.crypto.tink.proto.Keyset.KeyOrBuilder
        public KeyData getKeyData() {
            KeyData keyData = this.keyData_;
            return keyData == null ? KeyData.getDefaultInstance() : keyData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyData(KeyData value) {
            value.getClass();
            this.keyData_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeKeyData(KeyData value) {
            value.getClass();
            KeyData keyData = this.keyData_;
            if (keyData != null && keyData != KeyData.getDefaultInstance()) {
                this.keyData_ = KeyData.newBuilder(this.keyData_).mergeFrom((KeyData.Builder) value).buildPartial();
            } else {
                this.keyData_ = value;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKeyData() {
            this.keyData_ = null;
        }

        @Override // com.google.crypto.tink.proto.Keyset.KeyOrBuilder
        public int getStatusValue() {
            return this.status_;
        }

        @Override // com.google.crypto.tink.proto.Keyset.KeyOrBuilder
        public KeyStatusType getStatus() {
            KeyStatusType forNumber = KeyStatusType.forNumber(this.status_);
            return forNumber == null ? KeyStatusType.UNRECOGNIZED : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStatusValue(int value) {
            this.status_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStatus(KeyStatusType value) {
            this.status_ = value.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStatus() {
            this.status_ = 0;
        }

        @Override // com.google.crypto.tink.proto.Keyset.KeyOrBuilder
        public int getKeyId() {
            return this.keyId_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyId(int value) {
            this.keyId_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKeyId() {
            this.keyId_ = 0;
        }

        @Override // com.google.crypto.tink.proto.Keyset.KeyOrBuilder
        public int getOutputPrefixTypeValue() {
            return this.outputPrefixType_;
        }

        @Override // com.google.crypto.tink.proto.Keyset.KeyOrBuilder
        public OutputPrefixType getOutputPrefixType() {
            OutputPrefixType forNumber = OutputPrefixType.forNumber(this.outputPrefixType_);
            return forNumber == null ? OutputPrefixType.UNRECOGNIZED : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOutputPrefixTypeValue(int value) {
            this.outputPrefixType_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOutputPrefixType(OutputPrefixType value) {
            this.outputPrefixType_ = value.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOutputPrefixType() {
            this.outputPrefixType_ = 0;
        }

        public static Key parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Key parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Key parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Key parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Key parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Key parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Key parseFrom(InputStream input) throws IOException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Key parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Key parseDelimitedFrom(InputStream input) throws IOException {
            return (Key) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Key parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Key) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Key parseFrom(CodedInputStream input) throws IOException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Key parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Key prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Key, Builder> implements KeyOrBuilder {
            /* synthetic */ Builder(C06381 c06381) {
                this();
            }

            private Builder() {
                super(Key.DEFAULT_INSTANCE);
            }

            @Override // com.google.crypto.tink.proto.Keyset.KeyOrBuilder
            public boolean hasKeyData() {
                return ((Key) this.instance).hasKeyData();
            }

            @Override // com.google.crypto.tink.proto.Keyset.KeyOrBuilder
            public KeyData getKeyData() {
                return ((Key) this.instance).getKeyData();
            }

            public Builder setKeyData(KeyData value) {
                copyOnWrite();
                ((Key) this.instance).setKeyData(value);
                return this;
            }

            public Builder setKeyData(KeyData.Builder builderForValue) {
                copyOnWrite();
                ((Key) this.instance).setKeyData(builderForValue.build());
                return this;
            }

            public Builder mergeKeyData(KeyData value) {
                copyOnWrite();
                ((Key) this.instance).mergeKeyData(value);
                return this;
            }

            public Builder clearKeyData() {
                copyOnWrite();
                ((Key) this.instance).clearKeyData();
                return this;
            }

            @Override // com.google.crypto.tink.proto.Keyset.KeyOrBuilder
            public int getStatusValue() {
                return ((Key) this.instance).getStatusValue();
            }

            public Builder setStatusValue(int value) {
                copyOnWrite();
                ((Key) this.instance).setStatusValue(value);
                return this;
            }

            @Override // com.google.crypto.tink.proto.Keyset.KeyOrBuilder
            public KeyStatusType getStatus() {
                return ((Key) this.instance).getStatus();
            }

            public Builder setStatus(KeyStatusType value) {
                copyOnWrite();
                ((Key) this.instance).setStatus(value);
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((Key) this.instance).clearStatus();
                return this;
            }

            @Override // com.google.crypto.tink.proto.Keyset.KeyOrBuilder
            public int getKeyId() {
                return ((Key) this.instance).getKeyId();
            }

            public Builder setKeyId(int value) {
                copyOnWrite();
                ((Key) this.instance).setKeyId(value);
                return this;
            }

            public Builder clearKeyId() {
                copyOnWrite();
                ((Key) this.instance).clearKeyId();
                return this;
            }

            @Override // com.google.crypto.tink.proto.Keyset.KeyOrBuilder
            public int getOutputPrefixTypeValue() {
                return ((Key) this.instance).getOutputPrefixTypeValue();
            }

            public Builder setOutputPrefixTypeValue(int value) {
                copyOnWrite();
                ((Key) this.instance).setOutputPrefixTypeValue(value);
                return this;
            }

            @Override // com.google.crypto.tink.proto.Keyset.KeyOrBuilder
            public OutputPrefixType getOutputPrefixType() {
                return ((Key) this.instance).getOutputPrefixType();
            }

            public Builder setOutputPrefixType(OutputPrefixType value) {
                copyOnWrite();
                ((Key) this.instance).setOutputPrefixType(value);
                return this;
            }

            public Builder clearOutputPrefixType() {
                copyOnWrite();
                ((Key) this.instance).clearOutputPrefixType();
                return this;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            C06381 c06381 = null;
            switch (C06381.f168xa1df5c61[method.ordinal()]) {
                case 1:
                    return new Key();
                case 2:
                    return new Builder(c06381);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"keyData_", "status_", "keyId_", "outputPrefixType_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Key> parser = PARSER;
                    if (parser == null) {
                        synchronized (Key.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Key key = new Key();
            DEFAULT_INSTANCE = key;
            GeneratedMessageLite.registerDefaultInstance(Key.class, key);
        }

        public static Key getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Key> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.crypto.tink.proto.Keyset$1 */
    static /* synthetic */ class C06381 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f168xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f168xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f168xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f168xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f168xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f168xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f168xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f168xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.proto.KeysetOrBuilder
    public int getPrimaryKeyId() {
        return this.primaryKeyId_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrimaryKeyId(int value) {
        this.primaryKeyId_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPrimaryKeyId() {
        this.primaryKeyId_ = 0;
    }

    @Override // com.google.crypto.tink.proto.KeysetOrBuilder
    public List<Key> getKeyList() {
        return this.key_;
    }

    public List<? extends KeyOrBuilder> getKeyOrBuilderList() {
        return this.key_;
    }

    @Override // com.google.crypto.tink.proto.KeysetOrBuilder
    public int getKeyCount() {
        return this.key_.size();
    }

    @Override // com.google.crypto.tink.proto.KeysetOrBuilder
    public Key getKey(int index) {
        return this.key_.get(index);
    }

    public KeyOrBuilder getKeyOrBuilder(int index) {
        return this.key_.get(index);
    }

    private void ensureKeyIsMutable() {
        if (this.key_.isModifiable()) {
            return;
        }
        this.key_ = GeneratedMessageLite.mutableCopy(this.key_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKey(int index, Key value) {
        value.getClass();
        ensureKeyIsMutable();
        this.key_.set(index, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKey(Key value) {
        value.getClass();
        ensureKeyIsMutable();
        this.key_.add(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKey(int index, Key value) {
        value.getClass();
        ensureKeyIsMutable();
        this.key_.add(index, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllKey(Iterable<? extends Key> values) {
        ensureKeyIsMutable();
        AbstractMessageLite.addAll((Iterable) values, (List) this.key_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKey() {
        this.key_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeKey(int index) {
        ensureKeyIsMutable();
        this.key_.remove(index);
    }

    public static Keyset parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Keyset parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Keyset parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Keyset parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Keyset parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static Keyset parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static Keyset parseFrom(InputStream input) throws IOException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Keyset parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Keyset parseDelimitedFrom(InputStream input) throws IOException {
        return (Keyset) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static Keyset parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Keyset) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Keyset parseFrom(CodedInputStream input) throws IOException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static Keyset parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Keyset prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Keyset, Builder> implements KeysetOrBuilder {
        /* synthetic */ Builder(C06381 c06381) {
            this();
        }

        private Builder() {
            super(Keyset.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.KeysetOrBuilder
        public int getPrimaryKeyId() {
            return ((Keyset) this.instance).getPrimaryKeyId();
        }

        public Builder setPrimaryKeyId(int value) {
            copyOnWrite();
            ((Keyset) this.instance).setPrimaryKeyId(value);
            return this;
        }

        public Builder clearPrimaryKeyId() {
            copyOnWrite();
            ((Keyset) this.instance).clearPrimaryKeyId();
            return this;
        }

        @Override // com.google.crypto.tink.proto.KeysetOrBuilder
        public List<Key> getKeyList() {
            return Collections.unmodifiableList(((Keyset) this.instance).getKeyList());
        }

        @Override // com.google.crypto.tink.proto.KeysetOrBuilder
        public int getKeyCount() {
            return ((Keyset) this.instance).getKeyCount();
        }

        @Override // com.google.crypto.tink.proto.KeysetOrBuilder
        public Key getKey(int index) {
            return ((Keyset) this.instance).getKey(index);
        }

        public Builder setKey(int index, Key value) {
            copyOnWrite();
            ((Keyset) this.instance).setKey(index, value);
            return this;
        }

        public Builder setKey(int index, Key.Builder builderForValue) {
            copyOnWrite();
            ((Keyset) this.instance).setKey(index, builderForValue.build());
            return this;
        }

        public Builder addKey(Key value) {
            copyOnWrite();
            ((Keyset) this.instance).addKey(value);
            return this;
        }

        public Builder addKey(int index, Key value) {
            copyOnWrite();
            ((Keyset) this.instance).addKey(index, value);
            return this;
        }

        public Builder addKey(Key.Builder builderForValue) {
            copyOnWrite();
            ((Keyset) this.instance).addKey(builderForValue.build());
            return this;
        }

        public Builder addKey(int index, Key.Builder builderForValue) {
            copyOnWrite();
            ((Keyset) this.instance).addKey(index, builderForValue.build());
            return this;
        }

        public Builder addAllKey(Iterable<? extends Key> values) {
            copyOnWrite();
            ((Keyset) this.instance).addAllKey(values);
            return this;
        }

        public Builder clearKey() {
            copyOnWrite();
            ((Keyset) this.instance).clearKey();
            return this;
        }

        public Builder removeKey(int index) {
            copyOnWrite();
            ((Keyset) this.instance).removeKey(index);
            return this;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06381 c06381 = null;
        switch (C06381.f168xa1df5c61[method.ordinal()]) {
            case 1:
                return new Keyset();
            case 2:
                return new Builder(c06381);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", Key.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Keyset> parser = PARSER;
                if (parser == null) {
                    synchronized (Keyset.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        Keyset keyset = new Keyset();
        DEFAULT_INSTANCE = keyset;
        GeneratedMessageLite.registerDefaultInstance(Keyset.class, keyset);
    }

    public static Keyset getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Keyset> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/KeysetInfo.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class KeysetInfo extends GeneratedMessageLite<KeysetInfo, Builder> implements KeysetInfoOrBuilder {
    private static final KeysetInfo DEFAULT_INSTANCE;
    public static final int KEY_INFO_FIELD_NUMBER = 2;
    private static volatile Parser<KeysetInfo> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private Internal.ProtobufList<KeyInfo> keyInfo_ = emptyProtobufList();
    private int primaryKeyId_;

    public interface KeyInfoOrBuilder extends MessageLiteOrBuilder {
        int getKeyId();

        OutputPrefixType getOutputPrefixType();

        int getOutputPrefixTypeValue();

        KeyStatusType getStatus();

        int getStatusValue();

        String getTypeUrl();

        ByteString getTypeUrlBytes();
    }

    private KeysetInfo() {
    }

    public static final class KeyInfo extends GeneratedMessageLite<KeyInfo, Builder> implements KeyInfoOrBuilder {
        private static final KeyInfo DEFAULT_INSTANCE;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        private static volatile Parser<KeyInfo> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        public static final int TYPE_URL_FIELD_NUMBER = 1;
        private int keyId_;
        private int outputPrefixType_;
        private int status_;
        private String typeUrl_ = "";

        private KeyInfo() {
        }

        @Override // com.google.crypto.tink.proto.KeysetInfo.KeyInfoOrBuilder
        public String getTypeUrl() {
            return this.typeUrl_;
        }

        @Override // com.google.crypto.tink.proto.KeysetInfo.KeyInfoOrBuilder
        public ByteString getTypeUrlBytes() {
            return ByteString.copyFromUtf8(this.typeUrl_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTypeUrl(String value) {
            value.getClass();
            this.typeUrl_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTypeUrl() {
            this.typeUrl_ = getDefaultInstance().getTypeUrl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTypeUrlBytes(ByteString value) {
            checkByteStringIsUtf8(value);
            this.typeUrl_ = value.toStringUtf8();
        }

        @Override // com.google.crypto.tink.proto.KeysetInfo.KeyInfoOrBuilder
        public int getStatusValue() {
            return this.status_;
        }

        @Override // com.google.crypto.tink.proto.KeysetInfo.KeyInfoOrBuilder
        public KeyStatusType getStatus() {
            KeyStatusType forNumber = KeyStatusType.forNumber(this.status_);
            return forNumber == null ? KeyStatusType.UNRECOGNIZED : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStatusValue(int value) {
            this.status_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStatus(KeyStatusType value) {
            this.status_ = value.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStatus() {
            this.status_ = 0;
        }

        @Override // com.google.crypto.tink.proto.KeysetInfo.KeyInfoOrBuilder
        public int getKeyId() {
            return this.keyId_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyId(int value) {
            this.keyId_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKeyId() {
            this.keyId_ = 0;
        }

        @Override // com.google.crypto.tink.proto.KeysetInfo.KeyInfoOrBuilder
        public int getOutputPrefixTypeValue() {
            return this.outputPrefixType_;
        }

        @Override // com.google.crypto.tink.proto.KeysetInfo.KeyInfoOrBuilder
        public OutputPrefixType getOutputPrefixType() {
            OutputPrefixType forNumber = OutputPrefixType.forNumber(this.outputPrefixType_);
            return forNumber == null ? OutputPrefixType.UNRECOGNIZED : forNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOutputPrefixTypeValue(int value) {
            this.outputPrefixType_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOutputPrefixType(OutputPrefixType value) {
            this.outputPrefixType_ = value.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOutputPrefixType() {
            this.outputPrefixType_ = 0;
        }

        public static KeyInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static KeyInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static KeyInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static KeyInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static KeyInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static KeyInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static KeyInfo parseFrom(InputStream input) throws IOException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static KeyInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static KeyInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (KeyInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static KeyInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (KeyInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static KeyInfo parseFrom(CodedInputStream input) throws IOException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static KeyInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(KeyInfo prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<KeyInfo, Builder> implements KeyInfoOrBuilder {
            /* synthetic */ Builder(C06391 c06391) {
                this();
            }

            private Builder() {
                super(KeyInfo.DEFAULT_INSTANCE);
            }

            @Override // com.google.crypto.tink.proto.KeysetInfo.KeyInfoOrBuilder
            public String getTypeUrl() {
                return ((KeyInfo) this.instance).getTypeUrl();
            }

            @Override // com.google.crypto.tink.proto.KeysetInfo.KeyInfoOrBuilder
            public ByteString getTypeUrlBytes() {
                return ((KeyInfo) this.instance).getTypeUrlBytes();
            }

            public Builder setTypeUrl(String value) {
                copyOnWrite();
                ((KeyInfo) this.instance).setTypeUrl(value);
                return this;
            }

            public Builder clearTypeUrl() {
                copyOnWrite();
                ((KeyInfo) this.instance).clearTypeUrl();
                return this;
            }

            public Builder setTypeUrlBytes(ByteString value) {
                copyOnWrite();
                ((KeyInfo) this.instance).setTypeUrlBytes(value);
                return this;
            }

            @Override // com.google.crypto.tink.proto.KeysetInfo.KeyInfoOrBuilder
            public int getStatusValue() {
                return ((KeyInfo) this.instance).getStatusValue();
            }

            public Builder setStatusValue(int value) {
                copyOnWrite();
                ((KeyInfo) this.instance).setStatusValue(value);
                return this;
            }

            @Override // com.google.crypto.tink.proto.KeysetInfo.KeyInfoOrBuilder
            public KeyStatusType getStatus() {
                return ((KeyInfo) this.instance).getStatus();
            }

            public Builder setStatus(KeyStatusType value) {
                copyOnWrite();
                ((KeyInfo) this.instance).setStatus(value);
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((KeyInfo) this.instance).clearStatus();
                return this;
            }

            @Override // com.google.crypto.tink.proto.KeysetInfo.KeyInfoOrBuilder
            public int getKeyId() {
                return ((KeyInfo) this.instance).getKeyId();
            }

            public Builder setKeyId(int value) {
                copyOnWrite();
                ((KeyInfo) this.instance).setKeyId(value);
                return this;
            }

            public Builder clearKeyId() {
                copyOnWrite();
                ((KeyInfo) this.instance).clearKeyId();
                return this;
            }

            @Override // com.google.crypto.tink.proto.KeysetInfo.KeyInfoOrBuilder
            public int getOutputPrefixTypeValue() {
                return ((KeyInfo) this.instance).getOutputPrefixTypeValue();
            }

            public Builder setOutputPrefixTypeValue(int value) {
                copyOnWrite();
                ((KeyInfo) this.instance).setOutputPrefixTypeValue(value);
                return this;
            }

            @Override // com.google.crypto.tink.proto.KeysetInfo.KeyInfoOrBuilder
            public OutputPrefixType getOutputPrefixType() {
                return ((KeyInfo) this.instance).getOutputPrefixType();
            }

            public Builder setOutputPrefixType(OutputPrefixType value) {
                copyOnWrite();
                ((KeyInfo) this.instance).setOutputPrefixType(value);
                return this;
            }

            public Builder clearOutputPrefixType() {
                copyOnWrite();
                ((KeyInfo) this.instance).clearOutputPrefixType();
                return this;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            C06391 c06391 = null;
            switch (C06391.f169xa1df5c61[method.ordinal()]) {
                case 1:
                    return new KeyInfo();
                case 2:
                    return new Builder(c06391);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"typeUrl_", "status_", "keyId_", "outputPrefixType_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<KeyInfo> parser = PARSER;
                    if (parser == null) {
                        synchronized (KeyInfo.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            KeyInfo keyInfo = new KeyInfo();
            DEFAULT_INSTANCE = keyInfo;
            GeneratedMessageLite.registerDefaultInstance(KeyInfo.class, keyInfo);
        }

        public static KeyInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<KeyInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.crypto.tink.proto.KeysetInfo$1 */
    static /* synthetic */ class C06391 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f169xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f169xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f169xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f169xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f169xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f169xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f169xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f169xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.proto.KeysetInfoOrBuilder
    public int getPrimaryKeyId() {
        return this.primaryKeyId_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPrimaryKeyId(int value) {
        this.primaryKeyId_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPrimaryKeyId() {
        this.primaryKeyId_ = 0;
    }

    @Override // com.google.crypto.tink.proto.KeysetInfoOrBuilder
    public List<KeyInfo> getKeyInfoList() {
        return this.keyInfo_;
    }

    public List<? extends KeyInfoOrBuilder> getKeyInfoOrBuilderList() {
        return this.keyInfo_;
    }

    @Override // com.google.crypto.tink.proto.KeysetInfoOrBuilder
    public int getKeyInfoCount() {
        return this.keyInfo_.size();
    }

    @Override // com.google.crypto.tink.proto.KeysetInfoOrBuilder
    public KeyInfo getKeyInfo(int index) {
        return this.keyInfo_.get(index);
    }

    public KeyInfoOrBuilder getKeyInfoOrBuilder(int index) {
        return this.keyInfo_.get(index);
    }

    private void ensureKeyInfoIsMutable() {
        if (this.keyInfo_.isModifiable()) {
            return;
        }
        this.keyInfo_ = GeneratedMessageLite.mutableCopy(this.keyInfo_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyInfo(int index, KeyInfo value) {
        value.getClass();
        ensureKeyInfoIsMutable();
        this.keyInfo_.set(index, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKeyInfo(KeyInfo value) {
        value.getClass();
        ensureKeyInfoIsMutable();
        this.keyInfo_.add(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addKeyInfo(int index, KeyInfo value) {
        value.getClass();
        ensureKeyInfoIsMutable();
        this.keyInfo_.add(index, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllKeyInfo(Iterable<? extends KeyInfo> values) {
        ensureKeyInfoIsMutable();
        AbstractMessageLite.addAll((Iterable) values, (List) this.keyInfo_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyInfo() {
        this.keyInfo_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeKeyInfo(int index) {
        ensureKeyInfoIsMutable();
        this.keyInfo_.remove(index);
    }

    public static KeysetInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KeysetInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KeysetInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KeysetInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KeysetInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KeysetInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KeysetInfo parseFrom(InputStream input) throws IOException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KeysetInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KeysetInfo parseDelimitedFrom(InputStream input) throws IOException {
        return (KeysetInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static KeysetInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KeysetInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KeysetInfo parseFrom(CodedInputStream input) throws IOException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KeysetInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KeysetInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(KeysetInfo prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<KeysetInfo, Builder> implements KeysetInfoOrBuilder {
        /* synthetic */ Builder(C06391 c06391) {
            this();
        }

        private Builder() {
            super(KeysetInfo.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.KeysetInfoOrBuilder
        public int getPrimaryKeyId() {
            return ((KeysetInfo) this.instance).getPrimaryKeyId();
        }

        public Builder setPrimaryKeyId(int value) {
            copyOnWrite();
            ((KeysetInfo) this.instance).setPrimaryKeyId(value);
            return this;
        }

        public Builder clearPrimaryKeyId() {
            copyOnWrite();
            ((KeysetInfo) this.instance).clearPrimaryKeyId();
            return this;
        }

        @Override // com.google.crypto.tink.proto.KeysetInfoOrBuilder
        public List<KeyInfo> getKeyInfoList() {
            return Collections.unmodifiableList(((KeysetInfo) this.instance).getKeyInfoList());
        }

        @Override // com.google.crypto.tink.proto.KeysetInfoOrBuilder
        public int getKeyInfoCount() {
            return ((KeysetInfo) this.instance).getKeyInfoCount();
        }

        @Override // com.google.crypto.tink.proto.KeysetInfoOrBuilder
        public KeyInfo getKeyInfo(int index) {
            return ((KeysetInfo) this.instance).getKeyInfo(index);
        }

        public Builder setKeyInfo(int index, KeyInfo value) {
            copyOnWrite();
            ((KeysetInfo) this.instance).setKeyInfo(index, value);
            return this;
        }

        public Builder setKeyInfo(int index, KeyInfo.Builder builderForValue) {
            copyOnWrite();
            ((KeysetInfo) this.instance).setKeyInfo(index, builderForValue.build());
            return this;
        }

        public Builder addKeyInfo(KeyInfo value) {
            copyOnWrite();
            ((KeysetInfo) this.instance).addKeyInfo(value);
            return this;
        }

        public Builder addKeyInfo(int index, KeyInfo value) {
            copyOnWrite();
            ((KeysetInfo) this.instance).addKeyInfo(index, value);
            return this;
        }

        public Builder addKeyInfo(KeyInfo.Builder builderForValue) {
            copyOnWrite();
            ((KeysetInfo) this.instance).addKeyInfo(builderForValue.build());
            return this;
        }

        public Builder addKeyInfo(int index, KeyInfo.Builder builderForValue) {
            copyOnWrite();
            ((KeysetInfo) this.instance).addKeyInfo(index, builderForValue.build());
            return this;
        }

        public Builder addAllKeyInfo(Iterable<? extends KeyInfo> values) {
            copyOnWrite();
            ((KeysetInfo) this.instance).addAllKeyInfo(values);
            return this;
        }

        public Builder clearKeyInfo() {
            copyOnWrite();
            ((KeysetInfo) this.instance).clearKeyInfo();
            return this;
        }

        public Builder removeKeyInfo(int index) {
            copyOnWrite();
            ((KeysetInfo) this.instance).removeKeyInfo(index);
            return this;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06391 c06391 = null;
        switch (C06391.f169xa1df5c61[method.ordinal()]) {
            case 1:
                return new KeysetInfo();
            case 2:
                return new Builder(c06391);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "keyInfo_", KeyInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<KeysetInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (KeysetInfo.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        KeysetInfo keysetInfo = new KeysetInfo();
        DEFAULT_INSTANCE = keysetInfo;
        GeneratedMessageLite.registerDefaultInstance(KeysetInfo.class, keysetInfo);
    }

    public static KeysetInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<KeysetInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/KeysetInfoOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes.dex */
public interface KeysetInfoOrBuilder extends MessageLiteOrBuilder {
    KeysetInfo.KeyInfo getKeyInfo(int index);

    int getKeyInfoCount();

    List<KeysetInfo.KeyInfo> getKeyInfoList();

    int getPrimaryKeyId();
}

// ===== FILE: com/google/crypto/tink/proto/KeysetOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes.dex */
public interface KeysetOrBuilder extends MessageLiteOrBuilder {
    Keyset.Key getKey(int index);

    int getKeyCount();

    List<Keyset.Key> getKeyList();

    int getPrimaryKeyId();
}

// ===== FILE: com/google/crypto/tink/proto/KmsAead.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class KmsAead {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private KmsAead() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/KmsAeadKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KmsAeadKeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class KmsAeadKey extends GeneratedMessageLite<KmsAeadKey, Builder> implements KmsAeadKeyOrBuilder {
    private static final KmsAeadKey DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<KmsAeadKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private KmsAeadKeyFormat params_;
    private int version_;

    private KmsAeadKey() {
    }

    @Override // com.google.crypto.tink.proto.KmsAeadKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.KmsAeadKeyOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.KmsAeadKeyOrBuilder
    public KmsAeadKeyFormat getParams() {
        KmsAeadKeyFormat kmsAeadKeyFormat = this.params_;
        return kmsAeadKeyFormat == null ? KmsAeadKeyFormat.getDefaultInstance() : kmsAeadKeyFormat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(KmsAeadKeyFormat value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(KmsAeadKeyFormat value) {
        value.getClass();
        KmsAeadKeyFormat kmsAeadKeyFormat = this.params_;
        if (kmsAeadKeyFormat != null && kmsAeadKeyFormat != KmsAeadKeyFormat.getDefaultInstance()) {
            this.params_ = KmsAeadKeyFormat.newBuilder(this.params_).mergeFrom((KmsAeadKeyFormat.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    public static KmsAeadKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (KmsAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KmsAeadKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KmsAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KmsAeadKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (KmsAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KmsAeadKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KmsAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KmsAeadKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (KmsAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KmsAeadKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KmsAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KmsAeadKey parseFrom(InputStream input) throws IOException {
        return (KmsAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KmsAeadKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KmsAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KmsAeadKey parseDelimitedFrom(InputStream input) throws IOException {
        return (KmsAeadKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static KmsAeadKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KmsAeadKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KmsAeadKey parseFrom(CodedInputStream input) throws IOException {
        return (KmsAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KmsAeadKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KmsAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(KmsAeadKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<KmsAeadKey, Builder> implements KmsAeadKeyOrBuilder {
        /* synthetic */ Builder(C06401 c06401) {
            this();
        }

        private Builder() {
            super(KmsAeadKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.KmsAeadKeyOrBuilder
        public int getVersion() {
            return ((KmsAeadKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((KmsAeadKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((KmsAeadKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.KmsAeadKeyOrBuilder
        public boolean hasParams() {
            return ((KmsAeadKey) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.KmsAeadKeyOrBuilder
        public KmsAeadKeyFormat getParams() {
            return ((KmsAeadKey) this.instance).getParams();
        }

        public Builder setParams(KmsAeadKeyFormat value) {
            copyOnWrite();
            ((KmsAeadKey) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(KmsAeadKeyFormat.Builder builderForValue) {
            copyOnWrite();
            ((KmsAeadKey) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(KmsAeadKeyFormat value) {
            copyOnWrite();
            ((KmsAeadKey) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((KmsAeadKey) this.instance).clearParams();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.KmsAeadKey$1 */
    static /* synthetic */ class C06401 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f170xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f170xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f170xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f170xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f170xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f170xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f170xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f170xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06401 c06401 = null;
        switch (C06401.f170xa1df5c61[method.ordinal()]) {
            case 1:
                return new KmsAeadKey();
            case 2:
                return new Builder(c06401);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"version_", "params_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<KmsAeadKey> parser = PARSER;
                if (parser == null) {
                    synchronized (KmsAeadKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        KmsAeadKey kmsAeadKey = new KmsAeadKey();
        DEFAULT_INSTANCE = kmsAeadKey;
        GeneratedMessageLite.registerDefaultInstance(KmsAeadKey.class, kmsAeadKey);
    }

    public static KmsAeadKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<KmsAeadKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/KmsAeadKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class KmsAeadKeyFormat extends GeneratedMessageLite<KmsAeadKeyFormat, Builder> implements KmsAeadKeyFormatOrBuilder {
    private static final KmsAeadKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_URI_FIELD_NUMBER = 1;
    private static volatile Parser<KmsAeadKeyFormat> PARSER;
    private String keyUri_ = "";

    private KmsAeadKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.KmsAeadKeyFormatOrBuilder
    public String getKeyUri() {
        return this.keyUri_;
    }

    @Override // com.google.crypto.tink.proto.KmsAeadKeyFormatOrBuilder
    public ByteString getKeyUriBytes() {
        return ByteString.copyFromUtf8(this.keyUri_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyUri(String value) {
        value.getClass();
        this.keyUri_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyUri() {
        this.keyUri_ = getDefaultInstance().getKeyUri();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyUriBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.keyUri_ = value.toStringUtf8();
    }

    public static KmsAeadKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (KmsAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KmsAeadKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KmsAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KmsAeadKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (KmsAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KmsAeadKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KmsAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KmsAeadKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (KmsAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KmsAeadKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KmsAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KmsAeadKeyFormat parseFrom(InputStream input) throws IOException {
        return (KmsAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KmsAeadKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KmsAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KmsAeadKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (KmsAeadKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static KmsAeadKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KmsAeadKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KmsAeadKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (KmsAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KmsAeadKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KmsAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(KmsAeadKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<KmsAeadKeyFormat, Builder> implements KmsAeadKeyFormatOrBuilder {
        /* synthetic */ Builder(C06411 c06411) {
            this();
        }

        private Builder() {
            super(KmsAeadKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.KmsAeadKeyFormatOrBuilder
        public String getKeyUri() {
            return ((KmsAeadKeyFormat) this.instance).getKeyUri();
        }

        @Override // com.google.crypto.tink.proto.KmsAeadKeyFormatOrBuilder
        public ByteString getKeyUriBytes() {
            return ((KmsAeadKeyFormat) this.instance).getKeyUriBytes();
        }

        public Builder setKeyUri(String value) {
            copyOnWrite();
            ((KmsAeadKeyFormat) this.instance).setKeyUri(value);
            return this;
        }

        public Builder clearKeyUri() {
            copyOnWrite();
            ((KmsAeadKeyFormat) this.instance).clearKeyUri();
            return this;
        }

        public Builder setKeyUriBytes(ByteString value) {
            copyOnWrite();
            ((KmsAeadKeyFormat) this.instance).setKeyUriBytes(value);
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.KmsAeadKeyFormat$1 */
    static /* synthetic */ class C06411 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f171xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f171xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f171xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f171xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f171xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f171xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f171xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f171xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06411 c06411 = null;
        switch (C06411.f171xa1df5c61[method.ordinal()]) {
            case 1:
                return new KmsAeadKeyFormat();
            case 2:
                return new Builder(c06411);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"keyUri_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<KmsAeadKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (KmsAeadKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        KmsAeadKeyFormat kmsAeadKeyFormat = new KmsAeadKeyFormat();
        DEFAULT_INSTANCE = kmsAeadKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(KmsAeadKeyFormat.class, kmsAeadKeyFormat);
    }

    public static KmsAeadKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<KmsAeadKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/KmsAeadKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface KmsAeadKeyFormatOrBuilder extends MessageLiteOrBuilder {
    String getKeyUri();

    ByteString getKeyUriBytes();
}

// ===== FILE: com/google/crypto/tink/proto/KmsAeadKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface KmsAeadKeyOrBuilder extends MessageLiteOrBuilder {
    KmsAeadKeyFormat getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/KmsEnvelope.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class KmsEnvelope {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private KmsEnvelope() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/KmsEnvelopeAeadKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class KmsEnvelopeAeadKey extends GeneratedMessageLite<KmsEnvelopeAeadKey, Builder> implements KmsEnvelopeAeadKeyOrBuilder {
    private static final KmsEnvelopeAeadKey DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<KmsEnvelopeAeadKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private KmsEnvelopeAeadKeyFormat params_;
    private int version_;

    private KmsEnvelopeAeadKey() {
    }

    @Override // com.google.crypto.tink.proto.KmsEnvelopeAeadKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.KmsEnvelopeAeadKeyOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.KmsEnvelopeAeadKeyOrBuilder
    public KmsEnvelopeAeadKeyFormat getParams() {
        KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat = this.params_;
        return kmsEnvelopeAeadKeyFormat == null ? KmsEnvelopeAeadKeyFormat.getDefaultInstance() : kmsEnvelopeAeadKeyFormat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(KmsEnvelopeAeadKeyFormat value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(KmsEnvelopeAeadKeyFormat value) {
        value.getClass();
        KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat = this.params_;
        if (kmsEnvelopeAeadKeyFormat != null && kmsEnvelopeAeadKeyFormat != KmsEnvelopeAeadKeyFormat.getDefaultInstance()) {
            this.params_ = KmsEnvelopeAeadKeyFormat.newBuilder(this.params_).mergeFrom((KmsEnvelopeAeadKeyFormat.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    public static KmsEnvelopeAeadKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KmsEnvelopeAeadKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KmsEnvelopeAeadKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KmsEnvelopeAeadKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KmsEnvelopeAeadKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KmsEnvelopeAeadKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KmsEnvelopeAeadKey parseFrom(InputStream input) throws IOException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KmsEnvelopeAeadKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KmsEnvelopeAeadKey parseDelimitedFrom(InputStream input) throws IOException {
        return (KmsEnvelopeAeadKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static KmsEnvelopeAeadKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KmsEnvelopeAeadKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KmsEnvelopeAeadKey parseFrom(CodedInputStream input) throws IOException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KmsEnvelopeAeadKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KmsEnvelopeAeadKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(KmsEnvelopeAeadKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<KmsEnvelopeAeadKey, Builder> implements KmsEnvelopeAeadKeyOrBuilder {
        /* synthetic */ Builder(C06421 c06421) {
            this();
        }

        private Builder() {
            super(KmsEnvelopeAeadKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.KmsEnvelopeAeadKeyOrBuilder
        public int getVersion() {
            return ((KmsEnvelopeAeadKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((KmsEnvelopeAeadKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((KmsEnvelopeAeadKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.KmsEnvelopeAeadKeyOrBuilder
        public boolean hasParams() {
            return ((KmsEnvelopeAeadKey) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.KmsEnvelopeAeadKeyOrBuilder
        public KmsEnvelopeAeadKeyFormat getParams() {
            return ((KmsEnvelopeAeadKey) this.instance).getParams();
        }

        public Builder setParams(KmsEnvelopeAeadKeyFormat value) {
            copyOnWrite();
            ((KmsEnvelopeAeadKey) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(KmsEnvelopeAeadKeyFormat.Builder builderForValue) {
            copyOnWrite();
            ((KmsEnvelopeAeadKey) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(KmsEnvelopeAeadKeyFormat value) {
            copyOnWrite();
            ((KmsEnvelopeAeadKey) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((KmsEnvelopeAeadKey) this.instance).clearParams();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.KmsEnvelopeAeadKey$1 */
    static /* synthetic */ class C06421 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f172xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f172xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f172xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f172xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f172xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f172xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f172xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f172xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06421 c06421 = null;
        switch (C06421.f172xa1df5c61[method.ordinal()]) {
            case 1:
                return new KmsEnvelopeAeadKey();
            case 2:
                return new Builder(c06421);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"version_", "params_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<KmsEnvelopeAeadKey> parser = PARSER;
                if (parser == null) {
                    synchronized (KmsEnvelopeAeadKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        KmsEnvelopeAeadKey kmsEnvelopeAeadKey = new KmsEnvelopeAeadKey();
        DEFAULT_INSTANCE = kmsEnvelopeAeadKey;
        GeneratedMessageLite.registerDefaultInstance(KmsEnvelopeAeadKey.class, kmsEnvelopeAeadKey);
    }

    public static KmsEnvelopeAeadKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<KmsEnvelopeAeadKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/KmsEnvelopeAeadKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class KmsEnvelopeAeadKeyFormat extends GeneratedMessageLite<KmsEnvelopeAeadKeyFormat, Builder> implements KmsEnvelopeAeadKeyFormatOrBuilder {
    private static final KmsEnvelopeAeadKeyFormat DEFAULT_INSTANCE;
    public static final int DEK_TEMPLATE_FIELD_NUMBER = 2;
    public static final int KEK_URI_FIELD_NUMBER = 1;
    private static volatile Parser<KmsEnvelopeAeadKeyFormat> PARSER;
    private KeyTemplate dekTemplate_;
    private String kekUri_ = "";

    private KmsEnvelopeAeadKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormatOrBuilder
    public String getKekUri() {
        return this.kekUri_;
    }

    @Override // com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormatOrBuilder
    public ByteString getKekUriBytes() {
        return ByteString.copyFromUtf8(this.kekUri_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKekUri(String value) {
        value.getClass();
        this.kekUri_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKekUri() {
        this.kekUri_ = getDefaultInstance().getKekUri();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKekUriBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.kekUri_ = value.toStringUtf8();
    }

    @Override // com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormatOrBuilder
    public boolean hasDekTemplate() {
        return this.dekTemplate_ != null;
    }

    @Override // com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormatOrBuilder
    public KeyTemplate getDekTemplate() {
        KeyTemplate keyTemplate = this.dekTemplate_;
        return keyTemplate == null ? KeyTemplate.getDefaultInstance() : keyTemplate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDekTemplate(KeyTemplate value) {
        value.getClass();
        this.dekTemplate_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDekTemplate(KeyTemplate value) {
        value.getClass();
        KeyTemplate keyTemplate = this.dekTemplate_;
        if (keyTemplate != null && keyTemplate != KeyTemplate.getDefaultInstance()) {
            this.dekTemplate_ = KeyTemplate.newBuilder(this.dekTemplate_).mergeFrom((KeyTemplate.Builder) value).buildPartial();
        } else {
            this.dekTemplate_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDekTemplate() {
        this.dekTemplate_ = null;
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(InputStream input) throws IOException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KmsEnvelopeAeadKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (KmsEnvelopeAeadKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static KmsEnvelopeAeadKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KmsEnvelopeAeadKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static KmsEnvelopeAeadKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (KmsEnvelopeAeadKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(KmsEnvelopeAeadKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<KmsEnvelopeAeadKeyFormat, Builder> implements KmsEnvelopeAeadKeyFormatOrBuilder {
        /* synthetic */ Builder(C06431 c06431) {
            this();
        }

        private Builder() {
            super(KmsEnvelopeAeadKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormatOrBuilder
        public String getKekUri() {
            return ((KmsEnvelopeAeadKeyFormat) this.instance).getKekUri();
        }

        @Override // com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormatOrBuilder
        public ByteString getKekUriBytes() {
            return ((KmsEnvelopeAeadKeyFormat) this.instance).getKekUriBytes();
        }

        public Builder setKekUri(String value) {
            copyOnWrite();
            ((KmsEnvelopeAeadKeyFormat) this.instance).setKekUri(value);
            return this;
        }

        public Builder clearKekUri() {
            copyOnWrite();
            ((KmsEnvelopeAeadKeyFormat) this.instance).clearKekUri();
            return this;
        }

        public Builder setKekUriBytes(ByteString value) {
            copyOnWrite();
            ((KmsEnvelopeAeadKeyFormat) this.instance).setKekUriBytes(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormatOrBuilder
        public boolean hasDekTemplate() {
            return ((KmsEnvelopeAeadKeyFormat) this.instance).hasDekTemplate();
        }

        @Override // com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormatOrBuilder
        public KeyTemplate getDekTemplate() {
            return ((KmsEnvelopeAeadKeyFormat) this.instance).getDekTemplate();
        }

        public Builder setDekTemplate(KeyTemplate value) {
            copyOnWrite();
            ((KmsEnvelopeAeadKeyFormat) this.instance).setDekTemplate(value);
            return this;
        }

        public Builder setDekTemplate(KeyTemplate.Builder builderForValue) {
            copyOnWrite();
            ((KmsEnvelopeAeadKeyFormat) this.instance).setDekTemplate(builderForValue.build());
            return this;
        }

        public Builder mergeDekTemplate(KeyTemplate value) {
            copyOnWrite();
            ((KmsEnvelopeAeadKeyFormat) this.instance).mergeDekTemplate(value);
            return this;
        }

        public Builder clearDekTemplate() {
            copyOnWrite();
            ((KmsEnvelopeAeadKeyFormat) this.instance).clearDekTemplate();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormat$1 */
    static /* synthetic */ class C06431 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f173xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f173xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f173xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f173xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f173xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f173xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f173xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f173xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06431 c06431 = null;
        switch (C06431.f173xa1df5c61[method.ordinal()]) {
            case 1:
                return new KmsEnvelopeAeadKeyFormat();
            case 2:
                return new Builder(c06431);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"kekUri_", "dekTemplate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<KmsEnvelopeAeadKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (KmsEnvelopeAeadKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat = new KmsEnvelopeAeadKeyFormat();
        DEFAULT_INSTANCE = kmsEnvelopeAeadKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(KmsEnvelopeAeadKeyFormat.class, kmsEnvelopeAeadKeyFormat);
    }

    public static KmsEnvelopeAeadKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<KmsEnvelopeAeadKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/KmsEnvelopeAeadKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface KmsEnvelopeAeadKeyFormatOrBuilder extends MessageLiteOrBuilder {
    KeyTemplate getDekTemplate();

    String getKekUri();

    ByteString getKekUriBytes();

    boolean hasDekTemplate();
}

// ===== FILE: com/google/crypto/tink/proto/KmsEnvelopeAeadKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface KmsEnvelopeAeadKeyOrBuilder extends MessageLiteOrBuilder {
    KmsEnvelopeAeadKeyFormat getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/OutputPrefixType.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

/* loaded from: classes.dex */
public enum OutputPrefixType implements Internal.EnumLite {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);

    public static final int CRUNCHY_VALUE = 4;
    public static final int LEGACY_VALUE = 2;
    public static final int RAW_VALUE = 3;
    public static final int TINK_VALUE = 1;
    public static final int UNKNOWN_PREFIX_VALUE = 0;
    private static final Internal.EnumLiteMap<OutputPrefixType> internalValueMap = new Internal.EnumLiteMap<OutputPrefixType>() { // from class: com.google.crypto.tink.proto.OutputPrefixType.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public OutputPrefixType findValueByNumber(int number) {
            return OutputPrefixType.forNumber(number);
        }
    };
    private final int value;

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static OutputPrefixType valueOf(int value) {
        return forNumber(value);
    }

    public static OutputPrefixType forNumber(int value) {
        if (value == 0) {
            return UNKNOWN_PREFIX;
        }
        if (value == 1) {
            return TINK;
        }
        if (value == 2) {
            return LEGACY;
        }
        if (value == 3) {
            return RAW;
        }
        if (value != 4) {
            return null;
        }
        return CRUNCHY;
    }

    public static Internal.EnumLiteMap<OutputPrefixType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return OutputPrefixTypeVerifier.INSTANCE;
    }

    private static final class OutputPrefixTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new OutputPrefixTypeVerifier();

        private OutputPrefixTypeVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int number) {
            return OutputPrefixType.forNumber(number) != null;
        }
    }

    OutputPrefixType(int value) {
        this.value = value;
    }
}

// ===== FILE: com/google/crypto/tink/proto/RegistryConfig.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.KeyTypeEntry;
import com.google.crypto.tink.shaded.protobuf.AbstractMessageLite;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public final class RegistryConfig extends GeneratedMessageLite<RegistryConfig, Builder> implements RegistryConfigOrBuilder {
    public static final int CONFIG_NAME_FIELD_NUMBER = 1;
    private static final RegistryConfig DEFAULT_INSTANCE;
    public static final int ENTRY_FIELD_NUMBER = 2;
    private static volatile Parser<RegistryConfig> PARSER;
    private String configName_ = "";
    private Internal.ProtobufList<KeyTypeEntry> entry_ = emptyProtobufList();

    private RegistryConfig() {
    }

    @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
    public String getConfigName() {
        return this.configName_;
    }

    @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
    public ByteString getConfigNameBytes() {
        return ByteString.copyFromUtf8(this.configName_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfigName(String value) {
        value.getClass();
        this.configName_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConfigName() {
        this.configName_ = getDefaultInstance().getConfigName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfigNameBytes(ByteString value) {
        checkByteStringIsUtf8(value);
        this.configName_ = value.toStringUtf8();
    }

    @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
    public List<KeyTypeEntry> getEntryList() {
        return this.entry_;
    }

    public List<? extends KeyTypeEntryOrBuilder> getEntryOrBuilderList() {
        return this.entry_;
    }

    @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
    public int getEntryCount() {
        return this.entry_.size();
    }

    @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
    public KeyTypeEntry getEntry(int index) {
        return this.entry_.get(index);
    }

    public KeyTypeEntryOrBuilder getEntryOrBuilder(int index) {
        return this.entry_.get(index);
    }

    private void ensureEntryIsMutable() {
        if (this.entry_.isModifiable()) {
            return;
        }
        this.entry_ = GeneratedMessageLite.mutableCopy(this.entry_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEntry(int index, KeyTypeEntry value) {
        value.getClass();
        ensureEntryIsMutable();
        this.entry_.set(index, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEntry(KeyTypeEntry value) {
        value.getClass();
        ensureEntryIsMutable();
        this.entry_.add(value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEntry(int index, KeyTypeEntry value) {
        value.getClass();
        ensureEntryIsMutable();
        this.entry_.add(index, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEntry(Iterable<? extends KeyTypeEntry> values) {
        ensureEntryIsMutable();
        AbstractMessageLite.addAll((Iterable) values, (List) this.entry_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEntry() {
        this.entry_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeEntry(int index) {
        ensureEntryIsMutable();
        this.entry_.remove(index);
    }

    public static RegistryConfig parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RegistryConfig parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RegistryConfig parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RegistryConfig parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RegistryConfig parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RegistryConfig parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RegistryConfig parseFrom(InputStream input) throws IOException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RegistryConfig parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RegistryConfig parseDelimitedFrom(InputStream input) throws IOException {
        return (RegistryConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RegistryConfig parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RegistryConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RegistryConfig parseFrom(CodedInputStream input) throws IOException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RegistryConfig parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RegistryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RegistryConfig prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RegistryConfig, Builder> implements RegistryConfigOrBuilder {
        /* synthetic */ Builder(C06451 c06451) {
            this();
        }

        private Builder() {
            super(RegistryConfig.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
        public String getConfigName() {
            return ((RegistryConfig) this.instance).getConfigName();
        }

        @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
        public ByteString getConfigNameBytes() {
            return ((RegistryConfig) this.instance).getConfigNameBytes();
        }

        public Builder setConfigName(String value) {
            copyOnWrite();
            ((RegistryConfig) this.instance).setConfigName(value);
            return this;
        }

        public Builder clearConfigName() {
            copyOnWrite();
            ((RegistryConfig) this.instance).clearConfigName();
            return this;
        }

        public Builder setConfigNameBytes(ByteString value) {
            copyOnWrite();
            ((RegistryConfig) this.instance).setConfigNameBytes(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
        public List<KeyTypeEntry> getEntryList() {
            return Collections.unmodifiableList(((RegistryConfig) this.instance).getEntryList());
        }

        @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
        public int getEntryCount() {
            return ((RegistryConfig) this.instance).getEntryCount();
        }

        @Override // com.google.crypto.tink.proto.RegistryConfigOrBuilder
        public KeyTypeEntry getEntry(int index) {
            return ((RegistryConfig) this.instance).getEntry(index);
        }

        public Builder setEntry(int index, KeyTypeEntry value) {
            copyOnWrite();
            ((RegistryConfig) this.instance).setEntry(index, value);
            return this;
        }

        public Builder setEntry(int index, KeyTypeEntry.Builder builderForValue) {
            copyOnWrite();
            ((RegistryConfig) this.instance).setEntry(index, builderForValue.build());
            return this;
        }

        public Builder addEntry(KeyTypeEntry value) {
            copyOnWrite();
            ((RegistryConfig) this.instance).addEntry(value);
            return this;
        }

        public Builder addEntry(int index, KeyTypeEntry value) {
            copyOnWrite();
            ((RegistryConfig) this.instance).addEntry(index, value);
            return this;
        }

        public Builder addEntry(KeyTypeEntry.Builder builderForValue) {
            copyOnWrite();
            ((RegistryConfig) this.instance).addEntry(builderForValue.build());
            return this;
        }

        public Builder addEntry(int index, KeyTypeEntry.Builder builderForValue) {
            copyOnWrite();
            ((RegistryConfig) this.instance).addEntry(index, builderForValue.build());
            return this;
        }

        public Builder addAllEntry(Iterable<? extends KeyTypeEntry> values) {
            copyOnWrite();
            ((RegistryConfig) this.instance).addAllEntry(values);
            return this;
        }

        public Builder clearEntry() {
            copyOnWrite();
            ((RegistryConfig) this.instance).clearEntry();
            return this;
        }

        public Builder removeEntry(int index) {
            copyOnWrite();
            ((RegistryConfig) this.instance).removeEntry(index);
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.RegistryConfig$1 */
    static /* synthetic */ class C06451 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f174xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f174xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f174xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f174xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f174xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f174xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f174xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f174xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06451 c06451 = null;
        switch (C06451.f174xa1df5c61[method.ordinal()]) {
            case 1:
                return new RegistryConfig();
            case 2:
                return new Builder(c06451);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"configName_", "entry_", KeyTypeEntry.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RegistryConfig> parser = PARSER;
                if (parser == null) {
                    synchronized (RegistryConfig.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        RegistryConfig registryConfig = new RegistryConfig();
        DEFAULT_INSTANCE = registryConfig;
        GeneratedMessageLite.registerDefaultInstance(RegistryConfig.class, registryConfig);
    }

    public static RegistryConfig getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RegistryConfig> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/RegistryConfigOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public interface RegistryConfigOrBuilder extends MessageLiteOrBuilder {
    String getConfigName();

    ByteString getConfigNameBytes();

    KeyTypeEntry getEntry(int index);

    int getEntryCount();

    List<KeyTypeEntry> getEntryList();
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPkcs1.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class RsaSsaPkcs1 {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private RsaSsaPkcs1() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPkcs1KeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.RsaSsaPkcs1Params;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class RsaSsaPkcs1KeyFormat extends GeneratedMessageLite<RsaSsaPkcs1KeyFormat, Builder> implements RsaSsaPkcs1KeyFormatOrBuilder {
    private static final RsaSsaPkcs1KeyFormat DEFAULT_INSTANCE;
    public static final int MODULUS_SIZE_IN_BITS_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<RsaSsaPkcs1KeyFormat> PARSER = null;
    public static final int PUBLIC_EXPONENT_FIELD_NUMBER = 3;
    private int modulusSizeInBits_;
    private RsaSsaPkcs1Params params_;
    private ByteString publicExponent_ = ByteString.EMPTY;

    private RsaSsaPkcs1KeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormatOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormatOrBuilder
    public RsaSsaPkcs1Params getParams() {
        RsaSsaPkcs1Params rsaSsaPkcs1Params = this.params_;
        return rsaSsaPkcs1Params == null ? RsaSsaPkcs1Params.getDefaultInstance() : rsaSsaPkcs1Params;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(RsaSsaPkcs1Params value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(RsaSsaPkcs1Params value) {
        value.getClass();
        RsaSsaPkcs1Params rsaSsaPkcs1Params = this.params_;
        if (rsaSsaPkcs1Params != null && rsaSsaPkcs1Params != RsaSsaPkcs1Params.getDefaultInstance()) {
            this.params_ = RsaSsaPkcs1Params.newBuilder(this.params_).mergeFrom((RsaSsaPkcs1Params.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormatOrBuilder
    public int getModulusSizeInBits() {
        return this.modulusSizeInBits_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModulusSizeInBits(int value) {
        this.modulusSizeInBits_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModulusSizeInBits() {
        this.modulusSizeInBits_ = 0;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormatOrBuilder
    public ByteString getPublicExponent() {
        return this.publicExponent_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublicExponent(ByteString value) {
        value.getClass();
        this.publicExponent_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublicExponent() {
        this.publicExponent_ = getDefaultInstance().getPublicExponent();
    }

    public static RsaSsaPkcs1KeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPkcs1KeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPkcs1KeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPkcs1KeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPkcs1KeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPkcs1KeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPkcs1KeyFormat parseFrom(InputStream input) throws IOException {
        return (RsaSsaPkcs1KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPkcs1KeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPkcs1KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPkcs1KeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (RsaSsaPkcs1KeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPkcs1KeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPkcs1KeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPkcs1KeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (RsaSsaPkcs1KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPkcs1KeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPkcs1KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RsaSsaPkcs1KeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPkcs1KeyFormat, Builder> implements RsaSsaPkcs1KeyFormatOrBuilder {
        /* synthetic */ Builder(C06461 c06461) {
            this();
        }

        private Builder() {
            super(RsaSsaPkcs1KeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormatOrBuilder
        public boolean hasParams() {
            return ((RsaSsaPkcs1KeyFormat) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormatOrBuilder
        public RsaSsaPkcs1Params getParams() {
            return ((RsaSsaPkcs1KeyFormat) this.instance).getParams();
        }

        public Builder setParams(RsaSsaPkcs1Params value) {
            copyOnWrite();
            ((RsaSsaPkcs1KeyFormat) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(RsaSsaPkcs1Params.Builder builderForValue) {
            copyOnWrite();
            ((RsaSsaPkcs1KeyFormat) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(RsaSsaPkcs1Params value) {
            copyOnWrite();
            ((RsaSsaPkcs1KeyFormat) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((RsaSsaPkcs1KeyFormat) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormatOrBuilder
        public int getModulusSizeInBits() {
            return ((RsaSsaPkcs1KeyFormat) this.instance).getModulusSizeInBits();
        }

        public Builder setModulusSizeInBits(int value) {
            copyOnWrite();
            ((RsaSsaPkcs1KeyFormat) this.instance).setModulusSizeInBits(value);
            return this;
        }

        public Builder clearModulusSizeInBits() {
            copyOnWrite();
            ((RsaSsaPkcs1KeyFormat) this.instance).clearModulusSizeInBits();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormatOrBuilder
        public ByteString getPublicExponent() {
            return ((RsaSsaPkcs1KeyFormat) this.instance).getPublicExponent();
        }

        public Builder setPublicExponent(ByteString value) {
            copyOnWrite();
            ((RsaSsaPkcs1KeyFormat) this.instance).setPublicExponent(value);
            return this;
        }

        public Builder clearPublicExponent() {
            copyOnWrite();
            ((RsaSsaPkcs1KeyFormat) this.instance).clearPublicExponent();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPkcs1KeyFormat$1 */
    static /* synthetic */ class C06461 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f175xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f175xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f175xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f175xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f175xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f175xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f175xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f175xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06461 c06461 = null;
        switch (C06461.f175xa1df5c61[method.ordinal()]) {
            case 1:
                return new RsaSsaPkcs1KeyFormat();
            case 2:
                return new Builder(c06461);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\n", new Object[]{"params_", "modulusSizeInBits_", "publicExponent_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RsaSsaPkcs1KeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (RsaSsaPkcs1KeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        RsaSsaPkcs1KeyFormat rsaSsaPkcs1KeyFormat = new RsaSsaPkcs1KeyFormat();
        DEFAULT_INSTANCE = rsaSsaPkcs1KeyFormat;
        GeneratedMessageLite.registerDefaultInstance(RsaSsaPkcs1KeyFormat.class, rsaSsaPkcs1KeyFormat);
    }

    public static RsaSsaPkcs1KeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RsaSsaPkcs1KeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPkcs1KeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface RsaSsaPkcs1KeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getModulusSizeInBits();

    RsaSsaPkcs1Params getParams();

    ByteString getPublicExponent();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPkcs1Params.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class RsaSsaPkcs1Params extends GeneratedMessageLite<RsaSsaPkcs1Params, Builder> implements RsaSsaPkcs1ParamsOrBuilder {
    private static final RsaSsaPkcs1Params DEFAULT_INSTANCE;
    public static final int HASH_TYPE_FIELD_NUMBER = 1;
    private static volatile Parser<RsaSsaPkcs1Params> PARSER;
    private int hashType_;

    private RsaSsaPkcs1Params() {
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1ParamsOrBuilder
    public int getHashTypeValue() {
        return this.hashType_;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1ParamsOrBuilder
    public HashType getHashType() {
        HashType forNumber = HashType.forNumber(this.hashType_);
        return forNumber == null ? HashType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHashTypeValue(int value) {
        this.hashType_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHashType(HashType value) {
        this.hashType_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHashType() {
        this.hashType_ = 0;
    }

    public static RsaSsaPkcs1Params parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1Params) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPkcs1Params parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1Params) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPkcs1Params parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1Params) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPkcs1Params parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1Params) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPkcs1Params parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1Params) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPkcs1Params parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1Params) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPkcs1Params parseFrom(InputStream input) throws IOException {
        return (RsaSsaPkcs1Params) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPkcs1Params parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPkcs1Params) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPkcs1Params parseDelimitedFrom(InputStream input) throws IOException {
        return (RsaSsaPkcs1Params) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPkcs1Params parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPkcs1Params) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPkcs1Params parseFrom(CodedInputStream input) throws IOException {
        return (RsaSsaPkcs1Params) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPkcs1Params parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPkcs1Params) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RsaSsaPkcs1Params prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPkcs1Params, Builder> implements RsaSsaPkcs1ParamsOrBuilder {
        /* synthetic */ Builder(C06471 c06471) {
            this();
        }

        private Builder() {
            super(RsaSsaPkcs1Params.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1ParamsOrBuilder
        public int getHashTypeValue() {
            return ((RsaSsaPkcs1Params) this.instance).getHashTypeValue();
        }

        public Builder setHashTypeValue(int value) {
            copyOnWrite();
            ((RsaSsaPkcs1Params) this.instance).setHashTypeValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1ParamsOrBuilder
        public HashType getHashType() {
            return ((RsaSsaPkcs1Params) this.instance).getHashType();
        }

        public Builder setHashType(HashType value) {
            copyOnWrite();
            ((RsaSsaPkcs1Params) this.instance).setHashType(value);
            return this;
        }

        public Builder clearHashType() {
            copyOnWrite();
            ((RsaSsaPkcs1Params) this.instance).clearHashType();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPkcs1Params$1 */
    static /* synthetic */ class C06471 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f176xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f176xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f176xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f176xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f176xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f176xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f176xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f176xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06471 c06471 = null;
        switch (C06471.f176xa1df5c61[method.ordinal()]) {
            case 1:
                return new RsaSsaPkcs1Params();
            case 2:
                return new Builder(c06471);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"hashType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RsaSsaPkcs1Params> parser = PARSER;
                if (parser == null) {
                    synchronized (RsaSsaPkcs1Params.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        RsaSsaPkcs1Params rsaSsaPkcs1Params = new RsaSsaPkcs1Params();
        DEFAULT_INSTANCE = rsaSsaPkcs1Params;
        GeneratedMessageLite.registerDefaultInstance(RsaSsaPkcs1Params.class, rsaSsaPkcs1Params);
    }

    public static RsaSsaPkcs1Params getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RsaSsaPkcs1Params> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPkcs1ParamsOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface RsaSsaPkcs1ParamsOrBuilder extends MessageLiteOrBuilder {
    HashType getHashType();

    int getHashTypeValue();
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPkcs1PrivateKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class RsaSsaPkcs1PrivateKey extends GeneratedMessageLite<RsaSsaPkcs1PrivateKey, Builder> implements RsaSsaPkcs1PrivateKeyOrBuilder {
    public static final int CRT_FIELD_NUMBER = 8;
    private static final RsaSsaPkcs1PrivateKey DEFAULT_INSTANCE;
    public static final int DP_FIELD_NUMBER = 6;
    public static final int DQ_FIELD_NUMBER = 7;
    public static final int D_FIELD_NUMBER = 3;
    private static volatile Parser<RsaSsaPkcs1PrivateKey> PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int P_FIELD_NUMBER = 4;
    public static final int Q_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;
    private RsaSsaPkcs1PublicKey publicKey_;
    private int version_;

    /* renamed from: d_ */
    private ByteString f177d_ = ByteString.EMPTY;

    /* renamed from: p_ */
    private ByteString f178p_ = ByteString.EMPTY;

    /* renamed from: q_ */
    private ByteString f179q_ = ByteString.EMPTY;
    private ByteString dp_ = ByteString.EMPTY;
    private ByteString dq_ = ByteString.EMPTY;
    private ByteString crt_ = ByteString.EMPTY;

    private RsaSsaPkcs1PrivateKey() {
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
    public boolean hasPublicKey() {
        return this.publicKey_ != null;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
    public RsaSsaPkcs1PublicKey getPublicKey() {
        RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey = this.publicKey_;
        return rsaSsaPkcs1PublicKey == null ? RsaSsaPkcs1PublicKey.getDefaultInstance() : rsaSsaPkcs1PublicKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublicKey(RsaSsaPkcs1PublicKey value) {
        value.getClass();
        this.publicKey_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePublicKey(RsaSsaPkcs1PublicKey value) {
        value.getClass();
        RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey = this.publicKey_;
        if (rsaSsaPkcs1PublicKey != null && rsaSsaPkcs1PublicKey != RsaSsaPkcs1PublicKey.getDefaultInstance()) {
            this.publicKey_ = RsaSsaPkcs1PublicKey.newBuilder(this.publicKey_).mergeFrom((RsaSsaPkcs1PublicKey.Builder) value).buildPartial();
        } else {
            this.publicKey_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublicKey() {
        this.publicKey_ = null;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
    public ByteString getD() {
        return this.f177d_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setD(ByteString value) {
        value.getClass();
        this.f177d_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearD() {
        this.f177d_ = getDefaultInstance().getD();
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
    public ByteString getP() {
        return this.f178p_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setP(ByteString value) {
        value.getClass();
        this.f178p_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearP() {
        this.f178p_ = getDefaultInstance().getP();
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
    public ByteString getQ() {
        return this.f179q_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQ(ByteString value) {
        value.getClass();
        this.f179q_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQ() {
        this.f179q_ = getDefaultInstance().getQ();
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
    public ByteString getDp() {
        return this.dp_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDp(ByteString value) {
        value.getClass();
        this.dp_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDp() {
        this.dp_ = getDefaultInstance().getDp();
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
    public ByteString getDq() {
        return this.dq_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDq(ByteString value) {
        value.getClass();
        this.dq_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDq() {
        this.dq_ = getDefaultInstance().getDq();
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
    public ByteString getCrt() {
        return this.crt_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCrt(ByteString value) {
        value.getClass();
        this.crt_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCrt() {
        this.crt_ = getDefaultInstance().getCrt();
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(InputStream input) throws IOException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPkcs1PrivateKey parseDelimitedFrom(InputStream input) throws IOException {
        return (RsaSsaPkcs1PrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPkcs1PrivateKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPkcs1PrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(CodedInputStream input) throws IOException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPkcs1PrivateKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RsaSsaPkcs1PrivateKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPkcs1PrivateKey, Builder> implements RsaSsaPkcs1PrivateKeyOrBuilder {
        /* synthetic */ Builder(C06481 c06481) {
            this();
        }

        private Builder() {
            super(RsaSsaPkcs1PrivateKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
        public int getVersion() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
        public boolean hasPublicKey() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).hasPublicKey();
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
        public RsaSsaPkcs1PublicKey getPublicKey() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getPublicKey();
        }

        public Builder setPublicKey(RsaSsaPkcs1PublicKey value) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setPublicKey(value);
            return this;
        }

        public Builder setPublicKey(RsaSsaPkcs1PublicKey.Builder builderForValue) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setPublicKey(builderForValue.build());
            return this;
        }

        public Builder mergePublicKey(RsaSsaPkcs1PublicKey value) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).mergePublicKey(value);
            return this;
        }

        public Builder clearPublicKey() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearPublicKey();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
        public ByteString getD() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getD();
        }

        public Builder setD(ByteString value) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setD(value);
            return this;
        }

        public Builder clearD() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearD();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
        public ByteString getP() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getP();
        }

        public Builder setP(ByteString value) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setP(value);
            return this;
        }

        public Builder clearP() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearP();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
        public ByteString getQ() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getQ();
        }

        public Builder setQ(ByteString value) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setQ(value);
            return this;
        }

        public Builder clearQ() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearQ();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
        public ByteString getDp() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getDp();
        }

        public Builder setDp(ByteString value) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setDp(value);
            return this;
        }

        public Builder clearDp() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearDp();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
        public ByteString getDq() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getDq();
        }

        public Builder setDq(ByteString value) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setDq(value);
            return this;
        }

        public Builder clearDq() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearDq();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKeyOrBuilder
        public ByteString getCrt() {
            return ((RsaSsaPkcs1PrivateKey) this.instance).getCrt();
        }

        public Builder setCrt(ByteString value) {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).setCrt(value);
            return this;
        }

        public Builder clearCrt() {
            copyOnWrite();
            ((RsaSsaPkcs1PrivateKey) this.instance).clearCrt();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKey$1 */
    static /* synthetic */ class C06481 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f180xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f180xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f180xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f180xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f180xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f180xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f180xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f180xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06481 c06481 = null;
        switch (C06481.f180xa1df5c61[method.ordinal()]) {
            case 1:
                return new RsaSsaPkcs1PrivateKey();
            case 2:
                return new Builder(c06481);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n\u0005\n\u0006\n\u0007\n\b\n", new Object[]{"version_", "publicKey_", "d_", "p_", "q_", "dp_", "dq_", "crt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RsaSsaPkcs1PrivateKey> parser = PARSER;
                if (parser == null) {
                    synchronized (RsaSsaPkcs1PrivateKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey = new RsaSsaPkcs1PrivateKey();
        DEFAULT_INSTANCE = rsaSsaPkcs1PrivateKey;
        GeneratedMessageLite.registerDefaultInstance(RsaSsaPkcs1PrivateKey.class, rsaSsaPkcs1PrivateKey);
    }

    public static RsaSsaPkcs1PrivateKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RsaSsaPkcs1PrivateKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPkcs1PrivateKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface RsaSsaPkcs1PrivateKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getCrt();

    ByteString getD();

    ByteString getDp();

    ByteString getDq();

    ByteString getP();

    RsaSsaPkcs1PublicKey getPublicKey();

    ByteString getQ();

    int getVersion();

    boolean hasPublicKey();
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPkcs1PublicKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.RsaSsaPkcs1Params;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class RsaSsaPkcs1PublicKey extends GeneratedMessageLite<RsaSsaPkcs1PublicKey, Builder> implements RsaSsaPkcs1PublicKeyOrBuilder {
    private static final RsaSsaPkcs1PublicKey DEFAULT_INSTANCE;
    public static final int E_FIELD_NUMBER = 4;
    public static final int N_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<RsaSsaPkcs1PublicKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private RsaSsaPkcs1Params params_;
    private int version_;

    /* renamed from: n_ */
    private ByteString f182n_ = ByteString.EMPTY;

    /* renamed from: e_ */
    private ByteString f181e_ = ByteString.EMPTY;

    private RsaSsaPkcs1PublicKey() {
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PublicKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PublicKeyOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PublicKeyOrBuilder
    public RsaSsaPkcs1Params getParams() {
        RsaSsaPkcs1Params rsaSsaPkcs1Params = this.params_;
        return rsaSsaPkcs1Params == null ? RsaSsaPkcs1Params.getDefaultInstance() : rsaSsaPkcs1Params;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(RsaSsaPkcs1Params value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(RsaSsaPkcs1Params value) {
        value.getClass();
        RsaSsaPkcs1Params rsaSsaPkcs1Params = this.params_;
        if (rsaSsaPkcs1Params != null && rsaSsaPkcs1Params != RsaSsaPkcs1Params.getDefaultInstance()) {
            this.params_ = RsaSsaPkcs1Params.newBuilder(this.params_).mergeFrom((RsaSsaPkcs1Params.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PublicKeyOrBuilder
    public ByteString getN() {
        return this.f182n_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setN(ByteString value) {
        value.getClass();
        this.f182n_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearN() {
        this.f182n_ = getDefaultInstance().getN();
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PublicKeyOrBuilder
    public ByteString getE() {
        return this.f181e_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setE(ByteString value) {
        value.getClass();
        this.f181e_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearE() {
        this.f181e_ = getDefaultInstance().getE();
    }

    public static RsaSsaPkcs1PublicKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPkcs1PublicKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPkcs1PublicKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPkcs1PublicKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPkcs1PublicKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPkcs1PublicKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPkcs1PublicKey parseFrom(InputStream input) throws IOException {
        return (RsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPkcs1PublicKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPkcs1PublicKey parseDelimitedFrom(InputStream input) throws IOException {
        return (RsaSsaPkcs1PublicKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPkcs1PublicKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPkcs1PublicKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPkcs1PublicKey parseFrom(CodedInputStream input) throws IOException {
        return (RsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPkcs1PublicKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RsaSsaPkcs1PublicKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPkcs1PublicKey, Builder> implements RsaSsaPkcs1PublicKeyOrBuilder {
        /* synthetic */ Builder(C06491 c06491) {
            this();
        }

        private Builder() {
            super(RsaSsaPkcs1PublicKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PublicKeyOrBuilder
        public int getVersion() {
            return ((RsaSsaPkcs1PublicKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((RsaSsaPkcs1PublicKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((RsaSsaPkcs1PublicKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PublicKeyOrBuilder
        public boolean hasParams() {
            return ((RsaSsaPkcs1PublicKey) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PublicKeyOrBuilder
        public RsaSsaPkcs1Params getParams() {
            return ((RsaSsaPkcs1PublicKey) this.instance).getParams();
        }

        public Builder setParams(RsaSsaPkcs1Params value) {
            copyOnWrite();
            ((RsaSsaPkcs1PublicKey) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(RsaSsaPkcs1Params.Builder builderForValue) {
            copyOnWrite();
            ((RsaSsaPkcs1PublicKey) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(RsaSsaPkcs1Params value) {
            copyOnWrite();
            ((RsaSsaPkcs1PublicKey) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((RsaSsaPkcs1PublicKey) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PublicKeyOrBuilder
        public ByteString getN() {
            return ((RsaSsaPkcs1PublicKey) this.instance).getN();
        }

        public Builder setN(ByteString value) {
            copyOnWrite();
            ((RsaSsaPkcs1PublicKey) this.instance).setN(value);
            return this;
        }

        public Builder clearN() {
            copyOnWrite();
            ((RsaSsaPkcs1PublicKey) this.instance).clearN();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPkcs1PublicKeyOrBuilder
        public ByteString getE() {
            return ((RsaSsaPkcs1PublicKey) this.instance).getE();
        }

        public Builder setE(ByteString value) {
            copyOnWrite();
            ((RsaSsaPkcs1PublicKey) this.instance).setE(value);
            return this;
        }

        public Builder clearE() {
            copyOnWrite();
            ((RsaSsaPkcs1PublicKey) this.instance).clearE();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey$1 */
    static /* synthetic */ class C06491 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f183xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f183xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f183xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f183xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f183xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f183xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f183xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f183xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06491 c06491 = null;
        switch (C06491.f183xa1df5c61[method.ordinal()]) {
            case 1:
                return new RsaSsaPkcs1PublicKey();
            case 2:
                return new Builder(c06491);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"version_", "params_", "n_", "e_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RsaSsaPkcs1PublicKey> parser = PARSER;
                if (parser == null) {
                    synchronized (RsaSsaPkcs1PublicKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        RsaSsaPkcs1PublicKey rsaSsaPkcs1PublicKey = new RsaSsaPkcs1PublicKey();
        DEFAULT_INSTANCE = rsaSsaPkcs1PublicKey;
        GeneratedMessageLite.registerDefaultInstance(RsaSsaPkcs1PublicKey.class, rsaSsaPkcs1PublicKey);
    }

    public static RsaSsaPkcs1PublicKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RsaSsaPkcs1PublicKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPkcs1PublicKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface RsaSsaPkcs1PublicKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getE();

    ByteString getN();

    RsaSsaPkcs1Params getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPss.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class RsaSsaPss {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private RsaSsaPss() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPssKeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class RsaSsaPssKeyFormat extends GeneratedMessageLite<RsaSsaPssKeyFormat, Builder> implements RsaSsaPssKeyFormatOrBuilder {
    private static final RsaSsaPssKeyFormat DEFAULT_INSTANCE;
    public static final int MODULUS_SIZE_IN_BITS_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile Parser<RsaSsaPssKeyFormat> PARSER = null;
    public static final int PUBLIC_EXPONENT_FIELD_NUMBER = 3;
    private int modulusSizeInBits_;
    private RsaSsaPssParams params_;
    private ByteString publicExponent_ = ByteString.EMPTY;

    private RsaSsaPssKeyFormat() {
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssKeyFormatOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssKeyFormatOrBuilder
    public RsaSsaPssParams getParams() {
        RsaSsaPssParams rsaSsaPssParams = this.params_;
        return rsaSsaPssParams == null ? RsaSsaPssParams.getDefaultInstance() : rsaSsaPssParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(RsaSsaPssParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(RsaSsaPssParams value) {
        value.getClass();
        RsaSsaPssParams rsaSsaPssParams = this.params_;
        if (rsaSsaPssParams != null && rsaSsaPssParams != RsaSsaPssParams.getDefaultInstance()) {
            this.params_ = RsaSsaPssParams.newBuilder(this.params_).mergeFrom((RsaSsaPssParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssKeyFormatOrBuilder
    public int getModulusSizeInBits() {
        return this.modulusSizeInBits_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModulusSizeInBits(int value) {
        this.modulusSizeInBits_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModulusSizeInBits() {
        this.modulusSizeInBits_ = 0;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssKeyFormatOrBuilder
    public ByteString getPublicExponent() {
        return this.publicExponent_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublicExponent(ByteString value) {
        value.getClass();
        this.publicExponent_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublicExponent() {
        this.publicExponent_ = getDefaultInstance().getPublicExponent();
    }

    public static RsaSsaPssKeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPssKeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPssKeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPssKeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPssKeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPssKeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPssKeyFormat parseFrom(InputStream input) throws IOException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPssKeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPssKeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (RsaSsaPssKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPssKeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPssKeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPssKeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPssKeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RsaSsaPssKeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPssKeyFormat, Builder> implements RsaSsaPssKeyFormatOrBuilder {
        /* synthetic */ Builder(C06501 c06501) {
            this();
        }

        private Builder() {
            super(RsaSsaPssKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssKeyFormatOrBuilder
        public boolean hasParams() {
            return ((RsaSsaPssKeyFormat) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssKeyFormatOrBuilder
        public RsaSsaPssParams getParams() {
            return ((RsaSsaPssKeyFormat) this.instance).getParams();
        }

        public Builder setParams(RsaSsaPssParams value) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(RsaSsaPssParams.Builder builderForValue) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(RsaSsaPssParams value) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssKeyFormatOrBuilder
        public int getModulusSizeInBits() {
            return ((RsaSsaPssKeyFormat) this.instance).getModulusSizeInBits();
        }

        public Builder setModulusSizeInBits(int value) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).setModulusSizeInBits(value);
            return this;
        }

        public Builder clearModulusSizeInBits() {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).clearModulusSizeInBits();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssKeyFormatOrBuilder
        public ByteString getPublicExponent() {
            return ((RsaSsaPssKeyFormat) this.instance).getPublicExponent();
        }

        public Builder setPublicExponent(ByteString value) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).setPublicExponent(value);
            return this;
        }

        public Builder clearPublicExponent() {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).clearPublicExponent();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPssKeyFormat$1 */
    static /* synthetic */ class C06501 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f184xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f184xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f184xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f184xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f184xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f184xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f184xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f184xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06501 c06501 = null;
        switch (C06501.f184xa1df5c61[method.ordinal()]) {
            case 1:
                return new RsaSsaPssKeyFormat();
            case 2:
                return new Builder(c06501);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\n", new Object[]{"params_", "modulusSizeInBits_", "publicExponent_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RsaSsaPssKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (RsaSsaPssKeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        RsaSsaPssKeyFormat rsaSsaPssKeyFormat = new RsaSsaPssKeyFormat();
        DEFAULT_INSTANCE = rsaSsaPssKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(RsaSsaPssKeyFormat.class, rsaSsaPssKeyFormat);
    }

    public static RsaSsaPssKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RsaSsaPssKeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPssKeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface RsaSsaPssKeyFormatOrBuilder extends MessageLiteOrBuilder {
    int getModulusSizeInBits();

    RsaSsaPssParams getParams();

    ByteString getPublicExponent();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPssParams.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class RsaSsaPssParams extends GeneratedMessageLite<RsaSsaPssParams, Builder> implements RsaSsaPssParamsOrBuilder {
    private static final RsaSsaPssParams DEFAULT_INSTANCE;
    public static final int MGF1_HASH_FIELD_NUMBER = 2;
    private static volatile Parser<RsaSsaPssParams> PARSER = null;
    public static final int SALT_LENGTH_FIELD_NUMBER = 3;
    public static final int SIG_HASH_FIELD_NUMBER = 1;
    private int mgf1Hash_;
    private int saltLength_;
    private int sigHash_;

    private RsaSsaPssParams() {
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
    public int getSigHashValue() {
        return this.sigHash_;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
    public HashType getSigHash() {
        HashType forNumber = HashType.forNumber(this.sigHash_);
        return forNumber == null ? HashType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSigHashValue(int value) {
        this.sigHash_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSigHash(HashType value) {
        this.sigHash_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSigHash() {
        this.sigHash_ = 0;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
    public int getMgf1HashValue() {
        return this.mgf1Hash_;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
    public HashType getMgf1Hash() {
        HashType forNumber = HashType.forNumber(this.mgf1Hash_);
        return forNumber == null ? HashType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMgf1HashValue(int value) {
        this.mgf1Hash_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMgf1Hash(HashType value) {
        this.mgf1Hash_ = value.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMgf1Hash() {
        this.mgf1Hash_ = 0;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
    public int getSaltLength() {
        return this.saltLength_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSaltLength(int value) {
        this.saltLength_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSaltLength() {
        this.saltLength_ = 0;
    }

    public static RsaSsaPssParams parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPssParams parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPssParams parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPssParams parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPssParams parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPssParams parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPssParams parseFrom(InputStream input) throws IOException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPssParams parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPssParams parseDelimitedFrom(InputStream input) throws IOException {
        return (RsaSsaPssParams) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPssParams parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPssParams) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPssParams parseFrom(CodedInputStream input) throws IOException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPssParams parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPssParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RsaSsaPssParams prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPssParams, Builder> implements RsaSsaPssParamsOrBuilder {
        /* synthetic */ Builder(C06511 c06511) {
            this();
        }

        private Builder() {
            super(RsaSsaPssParams.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
        public int getSigHashValue() {
            return ((RsaSsaPssParams) this.instance).getSigHashValue();
        }

        public Builder setSigHashValue(int value) {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).setSigHashValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
        public HashType getSigHash() {
            return ((RsaSsaPssParams) this.instance).getSigHash();
        }

        public Builder setSigHash(HashType value) {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).setSigHash(value);
            return this;
        }

        public Builder clearSigHash() {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).clearSigHash();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
        public int getMgf1HashValue() {
            return ((RsaSsaPssParams) this.instance).getMgf1HashValue();
        }

        public Builder setMgf1HashValue(int value) {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).setMgf1HashValue(value);
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
        public HashType getMgf1Hash() {
            return ((RsaSsaPssParams) this.instance).getMgf1Hash();
        }

        public Builder setMgf1Hash(HashType value) {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).setMgf1Hash(value);
            return this;
        }

        public Builder clearMgf1Hash() {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).clearMgf1Hash();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssParamsOrBuilder
        public int getSaltLength() {
            return ((RsaSsaPssParams) this.instance).getSaltLength();
        }

        public Builder setSaltLength(int value) {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).setSaltLength(value);
            return this;
        }

        public Builder clearSaltLength() {
            copyOnWrite();
            ((RsaSsaPssParams) this.instance).clearSaltLength();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPssParams$1 */
    static /* synthetic */ class C06511 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f185xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f185xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f185xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f185xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f185xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f185xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f185xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f185xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06511 c06511 = null;
        switch (C06511.f185xa1df5c61[method.ordinal()]) {
            case 1:
                return new RsaSsaPssParams();
            case 2:
                return new Builder(c06511);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\u0004", new Object[]{"sigHash_", "mgf1Hash_", "saltLength_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RsaSsaPssParams> parser = PARSER;
                if (parser == null) {
                    synchronized (RsaSsaPssParams.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        RsaSsaPssParams rsaSsaPssParams = new RsaSsaPssParams();
        DEFAULT_INSTANCE = rsaSsaPssParams;
        GeneratedMessageLite.registerDefaultInstance(RsaSsaPssParams.class, rsaSsaPssParams);
    }

    public static RsaSsaPssParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RsaSsaPssParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPssParamsOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface RsaSsaPssParamsOrBuilder extends MessageLiteOrBuilder {
    HashType getMgf1Hash();

    int getMgf1HashValue();

    int getSaltLength();

    HashType getSigHash();

    int getSigHashValue();
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPssPrivateKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.RsaSsaPssPublicKey;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class RsaSsaPssPrivateKey extends GeneratedMessageLite<RsaSsaPssPrivateKey, Builder> implements RsaSsaPssPrivateKeyOrBuilder {
    public static final int CRT_FIELD_NUMBER = 8;
    private static final RsaSsaPssPrivateKey DEFAULT_INSTANCE;
    public static final int DP_FIELD_NUMBER = 6;
    public static final int DQ_FIELD_NUMBER = 7;
    public static final int D_FIELD_NUMBER = 3;
    private static volatile Parser<RsaSsaPssPrivateKey> PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int P_FIELD_NUMBER = 4;
    public static final int Q_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;
    private RsaSsaPssPublicKey publicKey_;
    private int version_;

    /* renamed from: d_ */
    private ByteString f186d_ = ByteString.EMPTY;

    /* renamed from: p_ */
    private ByteString f187p_ = ByteString.EMPTY;

    /* renamed from: q_ */
    private ByteString f188q_ = ByteString.EMPTY;
    private ByteString dp_ = ByteString.EMPTY;
    private ByteString dq_ = ByteString.EMPTY;
    private ByteString crt_ = ByteString.EMPTY;

    private RsaSsaPssPrivateKey() {
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
    public boolean hasPublicKey() {
        return this.publicKey_ != null;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
    public RsaSsaPssPublicKey getPublicKey() {
        RsaSsaPssPublicKey rsaSsaPssPublicKey = this.publicKey_;
        return rsaSsaPssPublicKey == null ? RsaSsaPssPublicKey.getDefaultInstance() : rsaSsaPssPublicKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublicKey(RsaSsaPssPublicKey value) {
        value.getClass();
        this.publicKey_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePublicKey(RsaSsaPssPublicKey value) {
        value.getClass();
        RsaSsaPssPublicKey rsaSsaPssPublicKey = this.publicKey_;
        if (rsaSsaPssPublicKey != null && rsaSsaPssPublicKey != RsaSsaPssPublicKey.getDefaultInstance()) {
            this.publicKey_ = RsaSsaPssPublicKey.newBuilder(this.publicKey_).mergeFrom((RsaSsaPssPublicKey.Builder) value).buildPartial();
        } else {
            this.publicKey_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublicKey() {
        this.publicKey_ = null;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
    public ByteString getD() {
        return this.f186d_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setD(ByteString value) {
        value.getClass();
        this.f186d_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearD() {
        this.f186d_ = getDefaultInstance().getD();
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
    public ByteString getP() {
        return this.f187p_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setP(ByteString value) {
        value.getClass();
        this.f187p_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearP() {
        this.f187p_ = getDefaultInstance().getP();
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
    public ByteString getQ() {
        return this.f188q_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQ(ByteString value) {
        value.getClass();
        this.f188q_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQ() {
        this.f188q_ = getDefaultInstance().getQ();
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
    public ByteString getDp() {
        return this.dp_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDp(ByteString value) {
        value.getClass();
        this.dp_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDp() {
        this.dp_ = getDefaultInstance().getDp();
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
    public ByteString getDq() {
        return this.dq_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDq(ByteString value) {
        value.getClass();
        this.dq_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDq() {
        this.dq_ = getDefaultInstance().getDq();
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
    public ByteString getCrt() {
        return this.crt_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCrt(ByteString value) {
        value.getClass();
        this.crt_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCrt() {
        this.crt_ = getDefaultInstance().getCrt();
    }

    public static RsaSsaPssPrivateKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPssPrivateKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPssPrivateKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPssPrivateKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPssPrivateKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPssPrivateKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPssPrivateKey parseFrom(InputStream input) throws IOException {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPssPrivateKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPssPrivateKey parseDelimitedFrom(InputStream input) throws IOException {
        return (RsaSsaPssPrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPssPrivateKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPssPrivateKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPssPrivateKey parseFrom(CodedInputStream input) throws IOException {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPssPrivateKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RsaSsaPssPrivateKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPssPrivateKey, Builder> implements RsaSsaPssPrivateKeyOrBuilder {
        /* synthetic */ Builder(C06521 c06521) {
            this();
        }

        private Builder() {
            super(RsaSsaPssPrivateKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
        public int getVersion() {
            return ((RsaSsaPssPrivateKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
        public boolean hasPublicKey() {
            return ((RsaSsaPssPrivateKey) this.instance).hasPublicKey();
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
        public RsaSsaPssPublicKey getPublicKey() {
            return ((RsaSsaPssPrivateKey) this.instance).getPublicKey();
        }

        public Builder setPublicKey(RsaSsaPssPublicKey value) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).setPublicKey(value);
            return this;
        }

        public Builder setPublicKey(RsaSsaPssPublicKey.Builder builderForValue) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).setPublicKey(builderForValue.build());
            return this;
        }

        public Builder mergePublicKey(RsaSsaPssPublicKey value) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).mergePublicKey(value);
            return this;
        }

        public Builder clearPublicKey() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).clearPublicKey();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
        public ByteString getD() {
            return ((RsaSsaPssPrivateKey) this.instance).getD();
        }

        public Builder setD(ByteString value) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).setD(value);
            return this;
        }

        public Builder clearD() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).clearD();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
        public ByteString getP() {
            return ((RsaSsaPssPrivateKey) this.instance).getP();
        }

        public Builder setP(ByteString value) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).setP(value);
            return this;
        }

        public Builder clearP() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).clearP();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
        public ByteString getQ() {
            return ((RsaSsaPssPrivateKey) this.instance).getQ();
        }

        public Builder setQ(ByteString value) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).setQ(value);
            return this;
        }

        public Builder clearQ() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).clearQ();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
        public ByteString getDp() {
            return ((RsaSsaPssPrivateKey) this.instance).getDp();
        }

        public Builder setDp(ByteString value) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).setDp(value);
            return this;
        }

        public Builder clearDp() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).clearDp();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
        public ByteString getDq() {
            return ((RsaSsaPssPrivateKey) this.instance).getDq();
        }

        public Builder setDq(ByteString value) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).setDq(value);
            return this;
        }

        public Builder clearDq() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).clearDq();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssPrivateKeyOrBuilder
        public ByteString getCrt() {
            return ((RsaSsaPssPrivateKey) this.instance).getCrt();
        }

        public Builder setCrt(ByteString value) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).setCrt(value);
            return this;
        }

        public Builder clearCrt() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).clearCrt();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPssPrivateKey$1 */
    static /* synthetic */ class C06521 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f189xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f189xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f189xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f189xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f189xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f189xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f189xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f189xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06521 c06521 = null;
        switch (C06521.f189xa1df5c61[method.ordinal()]) {
            case 1:
                return new RsaSsaPssPrivateKey();
            case 2:
                return new Builder(c06521);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n\u0005\n\u0006\n\u0007\n\b\n", new Object[]{"version_", "publicKey_", "d_", "p_", "q_", "dp_", "dq_", "crt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RsaSsaPssPrivateKey> parser = PARSER;
                if (parser == null) {
                    synchronized (RsaSsaPssPrivateKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        RsaSsaPssPrivateKey rsaSsaPssPrivateKey = new RsaSsaPssPrivateKey();
        DEFAULT_INSTANCE = rsaSsaPssPrivateKey;
        GeneratedMessageLite.registerDefaultInstance(RsaSsaPssPrivateKey.class, rsaSsaPssPrivateKey);
    }

    public static RsaSsaPssPrivateKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RsaSsaPssPrivateKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPssPrivateKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface RsaSsaPssPrivateKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getCrt();

    ByteString getD();

    ByteString getDp();

    ByteString getDq();

    ByteString getP();

    RsaSsaPssPublicKey getPublicKey();

    ByteString getQ();

    int getVersion();

    boolean hasPublicKey();
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPssPublicKey.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class RsaSsaPssPublicKey extends GeneratedMessageLite<RsaSsaPssPublicKey, Builder> implements RsaSsaPssPublicKeyOrBuilder {
    private static final RsaSsaPssPublicKey DEFAULT_INSTANCE;
    public static final int E_FIELD_NUMBER = 4;
    public static final int N_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile Parser<RsaSsaPssPublicKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private RsaSsaPssParams params_;
    private int version_;

    /* renamed from: n_ */
    private ByteString f191n_ = ByteString.EMPTY;

    /* renamed from: e_ */
    private ByteString f190e_ = ByteString.EMPTY;

    private RsaSsaPssPublicKey() {
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
    public boolean hasParams() {
        return this.params_ != null;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
    public RsaSsaPssParams getParams() {
        RsaSsaPssParams rsaSsaPssParams = this.params_;
        return rsaSsaPssParams == null ? RsaSsaPssParams.getDefaultInstance() : rsaSsaPssParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(RsaSsaPssParams value) {
        value.getClass();
        this.params_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(RsaSsaPssParams value) {
        value.getClass();
        RsaSsaPssParams rsaSsaPssParams = this.params_;
        if (rsaSsaPssParams != null && rsaSsaPssParams != RsaSsaPssParams.getDefaultInstance()) {
            this.params_ = RsaSsaPssParams.newBuilder(this.params_).mergeFrom((RsaSsaPssParams.Builder) value).buildPartial();
        } else {
            this.params_ = value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.params_ = null;
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
    public ByteString getN() {
        return this.f191n_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setN(ByteString value) {
        value.getClass();
        this.f191n_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearN() {
        this.f191n_ = getDefaultInstance().getN();
    }

    @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
    public ByteString getE() {
        return this.f190e_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setE(ByteString value) {
        value.getClass();
        this.f190e_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearE() {
        this.f190e_ = getDefaultInstance().getE();
    }

    public static RsaSsaPssPublicKey parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (RsaSsaPssPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPssPublicKey parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPssPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPssPublicKey parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (RsaSsaPssPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPssPublicKey parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPssPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPssPublicKey parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (RsaSsaPssPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static RsaSsaPssPublicKey parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (RsaSsaPssPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static RsaSsaPssPublicKey parseFrom(InputStream input) throws IOException {
        return (RsaSsaPssPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPssPublicKey parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPssPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPssPublicKey parseDelimitedFrom(InputStream input) throws IOException {
        return (RsaSsaPssPublicKey) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPssPublicKey parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPssPublicKey) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static RsaSsaPssPublicKey parseFrom(CodedInputStream input) throws IOException {
        return (RsaSsaPssPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static RsaSsaPssPublicKey parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (RsaSsaPssPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RsaSsaPssPublicKey prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<RsaSsaPssPublicKey, Builder> implements RsaSsaPssPublicKeyOrBuilder {
        /* synthetic */ Builder(C06531 c06531) {
            this();
        }

        private Builder() {
            super(RsaSsaPssPublicKey.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
        public int getVersion() {
            return ((RsaSsaPssPublicKey) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((RsaSsaPssPublicKey) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((RsaSsaPssPublicKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
        public boolean hasParams() {
            return ((RsaSsaPssPublicKey) this.instance).hasParams();
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
        public RsaSsaPssParams getParams() {
            return ((RsaSsaPssPublicKey) this.instance).getParams();
        }

        public Builder setParams(RsaSsaPssParams value) {
            copyOnWrite();
            ((RsaSsaPssPublicKey) this.instance).setParams(value);
            return this;
        }

        public Builder setParams(RsaSsaPssParams.Builder builderForValue) {
            copyOnWrite();
            ((RsaSsaPssPublicKey) this.instance).setParams(builderForValue.build());
            return this;
        }

        public Builder mergeParams(RsaSsaPssParams value) {
            copyOnWrite();
            ((RsaSsaPssPublicKey) this.instance).mergeParams(value);
            return this;
        }

        public Builder clearParams() {
            copyOnWrite();
            ((RsaSsaPssPublicKey) this.instance).clearParams();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
        public ByteString getN() {
            return ((RsaSsaPssPublicKey) this.instance).getN();
        }

        public Builder setN(ByteString value) {
            copyOnWrite();
            ((RsaSsaPssPublicKey) this.instance).setN(value);
            return this;
        }

        public Builder clearN() {
            copyOnWrite();
            ((RsaSsaPssPublicKey) this.instance).clearN();
            return this;
        }

        @Override // com.google.crypto.tink.proto.RsaSsaPssPublicKeyOrBuilder
        public ByteString getE() {
            return ((RsaSsaPssPublicKey) this.instance).getE();
        }

        public Builder setE(ByteString value) {
            copyOnWrite();
            ((RsaSsaPssPublicKey) this.instance).setE(value);
            return this;
        }

        public Builder clearE() {
            copyOnWrite();
            ((RsaSsaPssPublicKey) this.instance).clearE();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPssPublicKey$1 */
    static /* synthetic */ class C06531 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f192xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f192xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f192xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f192xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f192xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f192xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f192xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f192xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06531 c06531 = null;
        switch (C06531.f192xa1df5c61[method.ordinal()]) {
            case 1:
                return new RsaSsaPssPublicKey();
            case 2:
                return new Builder(c06531);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"version_", "params_", "n_", "e_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RsaSsaPssPublicKey> parser = PARSER;
                if (parser == null) {
                    synchronized (RsaSsaPssPublicKey.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        RsaSsaPssPublicKey rsaSsaPssPublicKey = new RsaSsaPssPublicKey();
        DEFAULT_INSTANCE = rsaSsaPssPublicKey;
        GeneratedMessageLite.registerDefaultInstance(RsaSsaPssPublicKey.class, rsaSsaPssPublicKey);
    }

    public static RsaSsaPssPublicKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RsaSsaPssPublicKey> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/RsaSsaPssPublicKeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface RsaSsaPssPublicKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getE();

    ByteString getN();

    RsaSsaPssParams getParams();

    int getVersion();

    boolean hasParams();
}

// ===== FILE: com/google/crypto/tink/proto/Tink.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class Tink {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private Tink() {
    }
}

// ===== FILE: com/google/crypto/tink/proto/XChaCha20Poly1305Key.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class XChaCha20Poly1305Key extends GeneratedMessageLite<XChaCha20Poly1305Key, Builder> implements XChaCha20Poly1305KeyOrBuilder {
    private static final XChaCha20Poly1305Key DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    private static volatile Parser<XChaCha20Poly1305Key> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.EMPTY;
    private int version_;

    private XChaCha20Poly1305Key() {
    }

    @Override // com.google.crypto.tink.proto.XChaCha20Poly1305KeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int value) {
        this.version_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    @Override // com.google.crypto.tink.proto.XChaCha20Poly1305KeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString value) {
        value.getClass();
        this.keyValue_ = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    public static XChaCha20Poly1305Key parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (XChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static XChaCha20Poly1305Key parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (XChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static XChaCha20Poly1305Key parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (XChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static XChaCha20Poly1305Key parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (XChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static XChaCha20Poly1305Key parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (XChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static XChaCha20Poly1305Key parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (XChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static XChaCha20Poly1305Key parseFrom(InputStream input) throws IOException {
        return (XChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static XChaCha20Poly1305Key parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (XChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static XChaCha20Poly1305Key parseDelimitedFrom(InputStream input) throws IOException {
        return (XChaCha20Poly1305Key) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static XChaCha20Poly1305Key parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (XChaCha20Poly1305Key) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static XChaCha20Poly1305Key parseFrom(CodedInputStream input) throws IOException {
        return (XChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static XChaCha20Poly1305Key parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (XChaCha20Poly1305Key) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(XChaCha20Poly1305Key prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<XChaCha20Poly1305Key, Builder> implements XChaCha20Poly1305KeyOrBuilder {
        /* synthetic */ Builder(C06541 c06541) {
            this();
        }

        private Builder() {
            super(XChaCha20Poly1305Key.DEFAULT_INSTANCE);
        }

        @Override // com.google.crypto.tink.proto.XChaCha20Poly1305KeyOrBuilder
        public int getVersion() {
            return ((XChaCha20Poly1305Key) this.instance).getVersion();
        }

        public Builder setVersion(int value) {
            copyOnWrite();
            ((XChaCha20Poly1305Key) this.instance).setVersion(value);
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((XChaCha20Poly1305Key) this.instance).clearVersion();
            return this;
        }

        @Override // com.google.crypto.tink.proto.XChaCha20Poly1305KeyOrBuilder
        public ByteString getKeyValue() {
            return ((XChaCha20Poly1305Key) this.instance).getKeyValue();
        }

        public Builder setKeyValue(ByteString value) {
            copyOnWrite();
            ((XChaCha20Poly1305Key) this.instance).setKeyValue(value);
            return this;
        }

        public Builder clearKeyValue() {
            copyOnWrite();
            ((XChaCha20Poly1305Key) this.instance).clearKeyValue();
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.proto.XChaCha20Poly1305Key$1 */
    static /* synthetic */ class C06541 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f193xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f193xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f193xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f193xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f193xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f193xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f193xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f193xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06541 c06541 = null;
        switch (C06541.f193xa1df5c61[method.ordinal()]) {
            case 1:
                return new XChaCha20Poly1305Key();
            case 2:
                return new Builder(c06541);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"version_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<XChaCha20Poly1305Key> parser = PARSER;
                if (parser == null) {
                    synchronized (XChaCha20Poly1305Key.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        XChaCha20Poly1305Key xChaCha20Poly1305Key = new XChaCha20Poly1305Key();
        DEFAULT_INSTANCE = xChaCha20Poly1305Key;
        GeneratedMessageLite.registerDefaultInstance(XChaCha20Poly1305Key.class, xChaCha20Poly1305Key);
    }

    public static XChaCha20Poly1305Key getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<XChaCha20Poly1305Key> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/XChaCha20Poly1305KeyFormat.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.CodedInputStream;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class XChaCha20Poly1305KeyFormat extends GeneratedMessageLite<XChaCha20Poly1305KeyFormat, Builder> implements XChaCha20Poly1305KeyFormatOrBuilder {
    private static final XChaCha20Poly1305KeyFormat DEFAULT_INSTANCE;
    private static volatile Parser<XChaCha20Poly1305KeyFormat> PARSER;

    private XChaCha20Poly1305KeyFormat() {
    }

    public static XChaCha20Poly1305KeyFormat parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return (XChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static XChaCha20Poly1305KeyFormat parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (XChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static XChaCha20Poly1305KeyFormat parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return (XChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static XChaCha20Poly1305KeyFormat parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (XChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static XChaCha20Poly1305KeyFormat parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return (XChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
    }

    public static XChaCha20Poly1305KeyFormat parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return (XChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static XChaCha20Poly1305KeyFormat parseFrom(InputStream input) throws IOException {
        return (XChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static XChaCha20Poly1305KeyFormat parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (XChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static XChaCha20Poly1305KeyFormat parseDelimitedFrom(InputStream input) throws IOException {
        return (XChaCha20Poly1305KeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static XChaCha20Poly1305KeyFormat parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (XChaCha20Poly1305KeyFormat) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static XChaCha20Poly1305KeyFormat parseFrom(CodedInputStream input) throws IOException {
        return (XChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
    }

    public static XChaCha20Poly1305KeyFormat parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return (XChaCha20Poly1305KeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(XChaCha20Poly1305KeyFormat prototype) {
        return DEFAULT_INSTANCE.createBuilder(prototype);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<XChaCha20Poly1305KeyFormat, Builder> implements XChaCha20Poly1305KeyFormatOrBuilder {
        /* synthetic */ Builder(C06551 c06551) {
            this();
        }

        private Builder() {
            super(XChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: com.google.crypto.tink.proto.XChaCha20Poly1305KeyFormat$1 */
    static /* synthetic */ class C06551 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f194xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f194xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f194xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f194xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f194xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f194xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f194xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f194xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
        C06551 c06551 = null;
        switch (C06551.f194xa1df5c61[method.ordinal()]) {
            case 1:
                return new XChaCha20Poly1305KeyFormat();
            case 2:
                return new Builder(c06551);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<XChaCha20Poly1305KeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (XChaCha20Poly1305KeyFormat.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        XChaCha20Poly1305KeyFormat xChaCha20Poly1305KeyFormat = new XChaCha20Poly1305KeyFormat();
        DEFAULT_INSTANCE = xChaCha20Poly1305KeyFormat;
        GeneratedMessageLite.registerDefaultInstance(XChaCha20Poly1305KeyFormat.class, xChaCha20Poly1305KeyFormat);
    }

    public static XChaCha20Poly1305KeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<XChaCha20Poly1305KeyFormat> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}

// ===== FILE: com/google/crypto/tink/proto/XChaCha20Poly1305KeyFormatOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface XChaCha20Poly1305KeyFormatOrBuilder extends MessageLiteOrBuilder {
}

// ===== FILE: com/google/crypto/tink/proto/XChaCha20Poly1305KeyOrBuilder.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface XChaCha20Poly1305KeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    int getVersion();
}

// ===== FILE: com/google/crypto/tink/proto/Xchacha20Poly1305.java =====
package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;

/* loaded from: classes.dex */
public final class Xchacha20Poly1305 {
    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private Xchacha20Poly1305() {
    }
}
