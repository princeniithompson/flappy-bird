
// ===== FILE: com/google/crypto/tink/prf/AesCmacPrfKeyManager.java =====
package com.google.crypto.tink.prf;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.AesCmacPrfKey;
import com.google.crypto.tink.proto.AesCmacPrfKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.PrfAesCmac;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class AesCmacPrfKeyManager extends KeyTypeManager<AesCmacPrfKey> {
    private static final int KEY_SIZE_IN_BYTES = 32;
    private static final int VERSION = 0;

    @Override // com.google.crypto.tink.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacPrfKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    AesCmacPrfKeyManager() {
        super(AesCmacPrfKey.class, new KeyTypeManager.PrimitiveFactory<Prf, AesCmacPrfKey>(Prf.class) { // from class: com.google.crypto.tink.prf.AesCmacPrfKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public Prf getPrimitive(AesCmacPrfKey key) throws GeneralSecurityException {
                return new PrfAesCmac(key.getKeyValue().toByteArray());
            }
        });
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public void validateKey(AesCmacPrfKey key) throws GeneralSecurityException {
        Validators.validateVersion(key.getVersion(), getVersion());
        validateSize(key.getKeyValue().size());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.KeyTypeManager
    public AesCmacPrfKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return AesCmacPrfKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateSize(int size) throws GeneralSecurityException {
        if (size != 32) {
            throw new GeneralSecurityException("AesCmacPrfKey size wrong, must be 32 bytes");
        }
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, AesCmacPrfKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesCmacPrfKeyFormat, AesCmacPrfKey>(AesCmacPrfKeyFormat.class) { // from class: com.google.crypto.tink.prf.AesCmacPrfKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public void validateKeyFormat(AesCmacPrfKeyFormat format) throws GeneralSecurityException {
                AesCmacPrfKeyManager.validateSize(format.getKeySize());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public AesCmacPrfKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return AesCmacPrfKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public AesCmacPrfKey createKey(AesCmacPrfKeyFormat format) {
                return AesCmacPrfKey.newBuilder().setVersion(0).setKeyValue(ByteString.copyFrom(Random.randBytes(format.getKeySize()))).build();
            }
        };
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        Registry.registerKeyManager(new AesCmacPrfKeyManager(), newKeyAllowed);
    }

    public static final KeyTemplate aes256CmacTemplate() {
        return KeyTemplate.create(new AesCmacPrfKeyManager().getKeyType(), AesCmacPrfKeyFormat.newBuilder().setKeySize(32).build().toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }
}

// ===== FILE: com/google/crypto/tink/prf/HkdfPrfKeyManager.java =====
package com.google.crypto.tink.prf;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HkdfPrfKey;
import com.google.crypto.tink.proto.HkdfPrfKeyFormat;
import com.google.crypto.tink.proto.HkdfPrfParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Enums;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import com.google.crypto.tink.subtle.prf.HkdfStreamingPrf;
import com.google.crypto.tink.subtle.prf.PrfImpl;
import com.google.crypto.tink.subtle.prf.StreamingPrf;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public class HkdfPrfKeyManager extends KeyTypeManager<HkdfPrfKey> {
    private static final int MIN_KEY_SIZE = 32;

    @Override // com.google.crypto.tink.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HkdfPrfKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    /* renamed from: com.google.crypto.tink.prf.HkdfPrfKeyManager$4 */
    static /* synthetic */ class C05744 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType;

        static {
            int[] iArr = new int[HashType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Enums.HashType convertHash(HashType hashType) throws GeneralSecurityException {
        int i = C05744.$SwitchMap$com$google$crypto$tink$proto$HashType[hashType.ordinal()];
        if (i == 1) {
            return Enums.HashType.SHA1;
        }
        if (i == 2) {
            return Enums.HashType.SHA256;
        }
        if (i == 3) {
            return Enums.HashType.SHA384;
        }
        if (i == 4) {
            return Enums.HashType.SHA512;
        }
        throw new GeneralSecurityException("HashType " + hashType.name() + " not known in");
    }

    HkdfPrfKeyManager() {
        super(HkdfPrfKey.class, new KeyTypeManager.PrimitiveFactory<StreamingPrf, HkdfPrfKey>(StreamingPrf.class) { // from class: com.google.crypto.tink.prf.HkdfPrfKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public StreamingPrf getPrimitive(HkdfPrfKey key) throws GeneralSecurityException {
                return new HkdfStreamingPrf(HkdfPrfKeyManager.convertHash(key.getParams().getHash()), key.getKeyValue().toByteArray(), key.getParams().getSalt().toByteArray());
            }
        }, new KeyTypeManager.PrimitiveFactory<Prf, HkdfPrfKey>(Prf.class) { // from class: com.google.crypto.tink.prf.HkdfPrfKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public Prf getPrimitive(HkdfPrfKey key) throws GeneralSecurityException {
                return PrfImpl.wrap(new HkdfStreamingPrf(HkdfPrfKeyManager.convertHash(key.getParams().getHash()), key.getKeyValue().toByteArray(), key.getParams().getSalt().toByteArray()));
            }
        });
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public void validateKey(HkdfPrfKey key) throws GeneralSecurityException {
        Validators.validateVersion(key.getVersion(), getVersion());
        validateKeySize(key.getKeyValue().size());
        validateParams(key.getParams());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.KeyTypeManager
    public HkdfPrfKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return HkdfPrfKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, HkdfPrfKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<HkdfPrfKeyFormat, HkdfPrfKey>(HkdfPrfKeyFormat.class) { // from class: com.google.crypto.tink.prf.HkdfPrfKeyManager.3
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public void validateKeyFormat(HkdfPrfKeyFormat format) throws GeneralSecurityException {
                HkdfPrfKeyManager.validateKeySize(format.getKeySize());
                HkdfPrfKeyManager.validateParams(format.getParams());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public HkdfPrfKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return HkdfPrfKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public HkdfPrfKey createKey(HkdfPrfKeyFormat format) throws GeneralSecurityException {
                return HkdfPrfKey.newBuilder().setKeyValue(ByteString.copyFrom(Random.randBytes(format.getKeySize()))).setVersion(HkdfPrfKeyManager.this.getVersion()).setParams(format.getParams()).build();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateKeySize(int keySize) throws GeneralSecurityException {
        if (keySize < 32) {
            throw new GeneralSecurityException("Invalid HkdfPrfKey/HkdfPrfKeyFormat: Key size too short");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateParams(HkdfPrfParams params) throws GeneralSecurityException {
        if (params.getHash() != HashType.SHA256 && params.getHash() != HashType.SHA512) {
            throw new GeneralSecurityException("Invalid HkdfPrfKey/HkdfPrfKeyFormat: Unsupported hash");
        }
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        Registry.registerKeyManager(new HkdfPrfKeyManager(), newKeyAllowed);
    }

    public static String staticKeyType() {
        return new HkdfPrfKeyManager().getKeyType();
    }

    public static final KeyTemplate hkdfSha256Template() {
        return KeyTemplate.create(staticKeyType(), HkdfPrfKeyFormat.newBuilder().setKeySize(32).setParams(HkdfPrfParams.newBuilder().setHash(HashType.SHA256)).build().toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }
}

// ===== FILE: com/google/crypto/tink/prf/HmacPrfKeyManager.java =====
package com.google.crypto.tink.prf;

import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacPrfKey;
import com.google.crypto.tink.proto.HmacPrfKeyFormat;
import com.google.crypto.tink.proto.HmacPrfParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.PrfHmacJce;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class HmacPrfKeyManager extends KeyTypeManager<HmacPrfKey> {
    private static final int MIN_KEY_SIZE_IN_BYTES = 16;

    @Override // com.google.crypto.tink.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacPrfKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    public HmacPrfKeyManager() {
        super(HmacPrfKey.class, new KeyTypeManager.PrimitiveFactory<Prf, HmacPrfKey>(Prf.class) { // from class: com.google.crypto.tink.prf.HmacPrfKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public Prf getPrimitive(HmacPrfKey key) throws GeneralSecurityException {
                HashType hash = key.getParams().getHash();
                SecretKeySpec secretKeySpec = new SecretKeySpec(key.getKeyValue().toByteArray(), "HMAC");
                int i = C05773.$SwitchMap$com$google$crypto$tink$proto$HashType[hash.ordinal()];
                if (i == 1) {
                    return new PrfHmacJce("HMACSHA1", secretKeySpec);
                }
                if (i == 2) {
                    return new PrfHmacJce("HMACSHA256", secretKeySpec);
                }
                if (i == 3) {
                    return new PrfHmacJce("HMACSHA512", secretKeySpec);
                }
                throw new GeneralSecurityException("unknown hash");
            }
        });
    }

    /* renamed from: com.google.crypto.tink.prf.HmacPrfKeyManager$3 */
    static /* synthetic */ class C05773 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType;

        static {
            int[] iArr = new int[HashType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public void validateKey(HmacPrfKey key) throws GeneralSecurityException {
        Validators.validateVersion(key.getVersion(), getVersion());
        if (key.getKeyValue().size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        validateParams(key.getParams());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.KeyTypeManager
    public HmacPrfKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return HmacPrfKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateParams(HmacPrfParams params) throws GeneralSecurityException {
        if (params.getHash() != HashType.SHA1 && params.getHash() != HashType.SHA256 && params.getHash() != HashType.SHA512) {
            throw new GeneralSecurityException("unknown hash type");
        }
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyTypeManager.KeyFactory<?, HmacPrfKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<HmacPrfKeyFormat, HmacPrfKey>(HmacPrfKeyFormat.class) { // from class: com.google.crypto.tink.prf.HmacPrfKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public void validateKeyFormat(HmacPrfKeyFormat format) throws GeneralSecurityException {
                if (format.getKeySize() >= 16) {
                    HmacPrfKeyManager.validateParams(format.getParams());
                    return;
                }
                throw new GeneralSecurityException("key too short");
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public HmacPrfKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return HmacPrfKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public HmacPrfKey createKey(HmacPrfKeyFormat format) {
                return HmacPrfKey.newBuilder().setVersion(HmacPrfKeyManager.this.getVersion()).setParams(format.getParams()).setKeyValue(ByteString.copyFrom(Random.randBytes(format.getKeySize()))).build();
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public HmacPrfKey deriveKey(HmacPrfKeyFormat format, InputStream inputStream) throws GeneralSecurityException {
                Validators.validateVersion(format.getVersion(), HmacPrfKeyManager.this.getVersion());
                byte[] bArr = new byte[format.getKeySize()];
                try {
                    if (inputStream.read(bArr) != format.getKeySize()) {
                        throw new GeneralSecurityException("Not enough pseudorandomness given");
                    }
                    return HmacPrfKey.newBuilder().setVersion(HmacPrfKeyManager.this.getVersion()).setParams(format.getParams()).setKeyValue(ByteString.copyFrom(bArr)).build();
                } catch (IOException e) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e);
                }
            }
        };
    }

    public static void register(boolean newKeyAllowed) throws GeneralSecurityException {
        Registry.registerKeyManager(new HmacPrfKeyManager(), newKeyAllowed);
    }

    public static final KeyTemplate hmacSha256Template() {
        return createTemplate(32, HashType.SHA256);
    }

    public static final KeyTemplate hmacSha512Template() {
        return createTemplate(64, HashType.SHA512);
    }

    private static KeyTemplate createTemplate(int keySize, HashType hashType) {
        return KeyTemplate.create(new HmacPrfKeyManager().getKeyType(), HmacPrfKeyFormat.newBuilder().setParams(HmacPrfParams.newBuilder().setHash(hashType).build()).setKeySize(keySize).build().toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }
}

// ===== FILE: com/google/crypto/tink/prf/Prf.java =====
package com.google.crypto.tink.prf;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

@Immutable
/* loaded from: classes.dex */
public interface Prf {
    byte[] compute(byte[] input, int outputLength) throws GeneralSecurityException;
}

// ===== FILE: com/google/crypto/tink/prf/PrfConfig.java =====
package com.google.crypto.tink.prf;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class PrfConfig {
    public static final String PRF_TYPE_URL = new HkdfPrfKeyManager().getKeyType();

    public static void register() throws GeneralSecurityException {
        AesCmacPrfKeyManager.register(true);
        HkdfPrfKeyManager.register(true);
        HmacPrfKeyManager.register(true);
        PrfSetWrapper.register();
    }

    private PrfConfig() {
    }
}

// ===== FILE: com/google/crypto/tink/prf/PrfKeyTemplates.java =====
package com.google.crypto.tink.prf;

import com.google.crypto.tink.proto.AesCmacPrfKeyFormat;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HkdfPrfKeyFormat;
import com.google.crypto.tink.proto.HkdfPrfParams;
import com.google.crypto.tink.proto.HmacPrfKeyFormat;
import com.google.crypto.tink.proto.HmacPrfParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

@Deprecated
/* loaded from: classes.dex */
public final class PrfKeyTemplates {
    public static final KeyTemplate HKDF_SHA256 = createHkdfKeyTemplate();
    public static final KeyTemplate HMAC_SHA256_PRF = createHmacTemplate(32, HashType.SHA256);
    public static final KeyTemplate HMAC_SHA512_PRF = createHmacTemplate(64, HashType.SHA512);
    public static final KeyTemplate AES_CMAC_PRF = createAes256CmacTemplate();

    private PrfKeyTemplates() {
    }

    private static KeyTemplate createHkdfKeyTemplate() {
        return KeyTemplate.newBuilder().setValue(HkdfPrfKeyFormat.newBuilder().setKeySize(32).setParams(HkdfPrfParams.newBuilder().setHash(HashType.SHA256)).build().toByteString()).setTypeUrl(HkdfPrfKeyManager.staticKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }

    private static KeyTemplate createHmacTemplate(int keySize, HashType hashType) {
        return KeyTemplate.newBuilder().setTypeUrl(new HmacPrfKeyManager().getKeyType()).setValue(HmacPrfKeyFormat.newBuilder().setParams(HmacPrfParams.newBuilder().setHash(hashType).build()).setKeySize(keySize).build().toByteString()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }

    private static KeyTemplate createAes256CmacTemplate() {
        return KeyTemplate.newBuilder().setTypeUrl(new AesCmacPrfKeyManager().getKeyType()).setValue(AesCmacPrfKeyFormat.newBuilder().setKeySize(32).build().toByteString()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }
}

// ===== FILE: com/google/crypto/tink/prf/PrfSet.java =====
package com.google.crypto.tink.prf;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Map;

@Immutable
/* loaded from: classes.dex */
public abstract class PrfSet {
    public abstract Map<Integer, Prf> getPrfs() throws GeneralSecurityException;

    public abstract int getPrimaryId();

    public byte[] computePrimary(byte[] input, int outputLength) throws GeneralSecurityException {
        return getPrfs().get(Integer.valueOf(getPrimaryId())).compute(input, outputLength);
    }
}

// ===== FILE: com/google/crypto/tink/prf/PrfSetWrapper.java =====
package com.google.crypto.tink.prf;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Immutable
/* loaded from: classes.dex */
public class PrfSetWrapper implements PrimitiveWrapper<Prf, PrfSet> {

    private static class WrappedPrfSet extends PrfSet {
        private final Map<Integer, Prf> keyIdToPrfMap;
        private final int primaryKeyId;

        private WrappedPrfSet(PrimitiveSet<Prf> primitives) throws GeneralSecurityException {
            if (primitives.getRawPrimitives().isEmpty()) {
                throw new GeneralSecurityException("No primitives provided.");
            }
            if (primitives.getPrimary() == null) {
                throw new GeneralSecurityException("Primary key not set.");
            }
            this.primaryKeyId = primitives.getPrimary().getKeyId();
            List<PrimitiveSet.Entry<Prf>> rawPrimitives = primitives.getRawPrimitives();
            HashMap hashMap = new HashMap();
            for (PrimitiveSet.Entry<Prf> entry : rawPrimitives) {
                if (!entry.getOutputPrefixType().equals(OutputPrefixType.RAW)) {
                    throw new GeneralSecurityException("Key " + entry.getKeyId() + " has non raw prefix type");
                }
                hashMap.put(Integer.valueOf(entry.getKeyId()), entry.getPrimitive());
            }
            this.keyIdToPrfMap = Collections.unmodifiableMap(hashMap);
        }

        @Override // com.google.crypto.tink.prf.PrfSet
        public int getPrimaryId() {
            return this.primaryKeyId;
        }

        @Override // com.google.crypto.tink.prf.PrfSet
        public Map<Integer, Prf> getPrfs() throws GeneralSecurityException {
            return this.keyIdToPrfMap;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public PrfSet wrap(PrimitiveSet<Prf> set) throws GeneralSecurityException {
        return new WrappedPrfSet(set);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<PrfSet> getPrimitiveClass() {
        return PrfSet.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<Prf> getInputPrimitiveClass() {
        return Prf.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new PrfSetWrapper());
    }
}
