
// ===== FILE: com/google/crypto/tink/hybrid/EciesAeadHkdfPrivateKeyManager.java =====
package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.PrivateKeyTypeManager;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.aead.AesCtrHmacAeadKeyManager;
import com.google.crypto.tink.aead.AesGcmKeyManager;
import com.google.crypto.tink.proto.EcPointFormat;
import com.google.crypto.tink.proto.EciesAeadDemParams;
import com.google.crypto.tink.proto.EciesAeadHkdfKeyFormat;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.proto.EciesAeadHkdfPrivateKey;
import com.google.crypto.tink.proto.EciesAeadHkdfPublicKey;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.EciesAeadHkdfHybridDecrypt;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

/* loaded from: classes.dex */
public final class EciesAeadHkdfPrivateKeyManager extends PrivateKeyTypeManager<EciesAeadHkdfPrivateKey, EciesAeadHkdfPublicKey> {
    private static final byte[] EMPTY_SALT = new byte[0];

    @Override // com.google.crypto.tink.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    EciesAeadHkdfPrivateKeyManager() {
        super(EciesAeadHkdfPrivateKey.class, EciesAeadHkdfPublicKey.class, new KeyTypeManager.PrimitiveFactory<HybridDecrypt, EciesAeadHkdfPrivateKey>(HybridDecrypt.class) { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public HybridDecrypt getPrimitive(EciesAeadHkdfPrivateKey recipientKeyProto) throws GeneralSecurityException {
                EciesAeadHkdfParams params = recipientKeyProto.getPublicKey().getParams();
                EciesHkdfKemParams kemParams = params.getKemParams();
                return new EciesAeadHkdfHybridDecrypt(EllipticCurves.getEcPrivateKey(HybridUtil.toCurveType(kemParams.getCurveType()), recipientKeyProto.getKeyValue().toByteArray()), kemParams.getHkdfSalt().toByteArray(), HybridUtil.toHmacAlgo(kemParams.getHkdfHashType()), HybridUtil.toPointFormatType(params.getEcPointFormat()), new RegistryEciesAeadHkdfDemHelper(params.getDemParams().getAeadDem()));
            }
        });
    }

    @Override // com.google.crypto.tink.PrivateKeyTypeManager
    public EciesAeadHkdfPublicKey getPublicKey(EciesAeadHkdfPrivateKey key) throws GeneralSecurityException {
        return key.getPublicKey();
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public EciesAeadHkdfPrivateKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return EciesAeadHkdfPrivateKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public void validateKey(EciesAeadHkdfPrivateKey keyProto) throws GeneralSecurityException {
        if (keyProto.getKeyValue().isEmpty()) {
            throw new GeneralSecurityException("invalid ECIES private key");
        }
        Validators.validateVersion(keyProto.getVersion(), getVersion());
        HybridUtil.validate(keyProto.getPublicKey().getParams());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyTypeManager.KeyFactory<EciesAeadHkdfKeyFormat, EciesAeadHkdfPrivateKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<EciesAeadHkdfKeyFormat, EciesAeadHkdfPrivateKey>(EciesAeadHkdfKeyFormat.class) { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager.2
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public void validateKeyFormat(EciesAeadHkdfKeyFormat eciesKeyFormat) throws GeneralSecurityException {
                HybridUtil.validate(eciesKeyFormat.getParams());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public EciesAeadHkdfKeyFormat parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return EciesAeadHkdfKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.KeyTypeManager.KeyFactory
            public EciesAeadHkdfPrivateKey createKey(EciesAeadHkdfKeyFormat eciesKeyFormat) throws GeneralSecurityException {
                KeyPair generateKeyPair = EllipticCurves.generateKeyPair(HybridUtil.toCurveType(eciesKeyFormat.getParams().getKemParams().getCurveType()));
                ECPublicKey eCPublicKey = (ECPublicKey) generateKeyPair.getPublic();
                ECPrivateKey eCPrivateKey = (ECPrivateKey) generateKeyPair.getPrivate();
                ECPoint w = eCPublicKey.getW();
                return EciesAeadHkdfPrivateKey.newBuilder().setVersion(EciesAeadHkdfPrivateKeyManager.this.getVersion()).setPublicKey(EciesAeadHkdfPublicKey.newBuilder().setVersion(EciesAeadHkdfPrivateKeyManager.this.getVersion()).setParams(eciesKeyFormat.getParams()).setX(ByteString.copyFrom(w.getAffineX().toByteArray())).setY(ByteString.copyFrom(w.getAffineY().toByteArray())).build()).setKeyValue(ByteString.copyFrom(eCPrivateKey.getS().toByteArray())).build();
            }
        };
    }

    public static void registerPair(boolean newKeyAllowed) throws GeneralSecurityException {
        Registry.registerAsymmetricKeyManagers(new EciesAeadHkdfPrivateKeyManager(), new EciesAeadHkdfPublicKeyManager(), newKeyAllowed);
    }

    public static final KeyTemplate eciesP256HkdfHmacSha256Aes128GcmTemplate() {
        return createKeyTemplate(EllipticCurveType.NIST_P256, HashType.SHA256, EcPointFormat.UNCOMPRESSED, AesGcmKeyManager.aes128GcmTemplate(), KeyTemplate.OutputPrefixType.TINK, EMPTY_SALT);
    }

    public static final KeyTemplate rawEciesP256HkdfHmacSha256Aes128GcmCompressedTemplate() {
        return createKeyTemplate(EllipticCurveType.NIST_P256, HashType.SHA256, EcPointFormat.COMPRESSED, AesGcmKeyManager.aes128GcmTemplate(), KeyTemplate.OutputPrefixType.RAW, EMPTY_SALT);
    }

    public static final KeyTemplate eciesP256HkdfHmacSha256Aes128CtrHmacSha256Template() {
        return createKeyTemplate(EllipticCurveType.NIST_P256, HashType.SHA256, EcPointFormat.UNCOMPRESSED, AesCtrHmacAeadKeyManager.aes128CtrHmacSha256Template(), KeyTemplate.OutputPrefixType.TINK, EMPTY_SALT);
    }

    public static final KeyTemplate rawEciesP256HkdfHmacSha256Aes128CtrHmacSha256CompressedTemplate() {
        return createKeyTemplate(EllipticCurveType.NIST_P256, HashType.SHA256, EcPointFormat.COMPRESSED, AesCtrHmacAeadKeyManager.aes128CtrHmacSha256Template(), KeyTemplate.OutputPrefixType.RAW, EMPTY_SALT);
    }

    private static KeyTemplate createKeyTemplate(EllipticCurveType curve, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate demKeyTemplate, KeyTemplate.OutputPrefixType outputPrefixType, byte[] salt) {
        return KeyTemplate.create(new EciesAeadHkdfPrivateKeyManager().getKeyType(), EciesAeadHkdfKeyFormat.newBuilder().setParams(createParams(curve, hashType, ecPointFormat, demKeyTemplate, salt)).build().toByteArray(), outputPrefixType);
    }

    static EciesAeadHkdfParams createParams(EllipticCurveType curve, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate demKeyTemplate, byte[] salt) {
        EciesHkdfKemParams build = EciesHkdfKemParams.newBuilder().setCurveType(curve).setHkdfHashType(hashType).setHkdfSalt(ByteString.copyFrom(salt)).build();
        return EciesAeadHkdfParams.newBuilder().setKemParams(build).setDemParams(EciesAeadDemParams.newBuilder().setAeadDem(com.google.crypto.tink.proto.KeyTemplate.newBuilder().setTypeUrl(demKeyTemplate.getTypeUrl()).setValue(ByteString.copyFrom(demKeyTemplate.getValue())).setOutputPrefixType(toProto(demKeyTemplate.getOutputPrefixType())).build()).build()).setEcPointFormat(ecPointFormat).build();
    }

    /* renamed from: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager$3 */
    static /* synthetic */ class C05583 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType;

        static {
            int[] iArr = new int[KeyTemplate.OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType = iArr;
            try {
                iArr[KeyTemplate.OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[KeyTemplate.OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[KeyTemplate.OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[KeyTemplate.OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static OutputPrefixType toProto(KeyTemplate.OutputPrefixType outputPrefixType) {
        int i = C05583.$SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return OutputPrefixType.TINK;
        }
        if (i == 2) {
            return OutputPrefixType.LEGACY;
        }
        if (i == 3) {
            return OutputPrefixType.RAW;
        }
        if (i == 4) {
            return OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }
}

// ===== FILE: com/google/crypto/tink/hybrid/EciesAeadHkdfPublicKeyManager.java =====
package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.proto.EciesAeadHkdfPublicKey;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.EciesAeadHkdfHybridEncrypt;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
class EciesAeadHkdfPublicKeyManager extends KeyTypeManager<EciesAeadHkdfPublicKey> {
    @Override // com.google.crypto.tink.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    public EciesAeadHkdfPublicKeyManager() {
        super(EciesAeadHkdfPublicKey.class, new KeyTypeManager.PrimitiveFactory<HybridEncrypt, EciesAeadHkdfPublicKey>(HybridEncrypt.class) { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPublicKeyManager.1
            @Override // com.google.crypto.tink.KeyTypeManager.PrimitiveFactory
            public HybridEncrypt getPrimitive(EciesAeadHkdfPublicKey recipientKeyProto) throws GeneralSecurityException {
                EciesAeadHkdfParams params = recipientKeyProto.getParams();
                EciesHkdfKemParams kemParams = params.getKemParams();
                return new EciesAeadHkdfHybridEncrypt(EllipticCurves.getEcPublicKey(HybridUtil.toCurveType(kemParams.getCurveType()), recipientKeyProto.getX().toByteArray(), recipientKeyProto.getY().toByteArray()), kemParams.getHkdfSalt().toByteArray(), HybridUtil.toHmacAlgo(kemParams.getHkdfHashType()), HybridUtil.toPointFormatType(params.getEcPointFormat()), new RegistryEciesAeadHkdfDemHelper(params.getDemParams().getAeadDem()));
            }
        });
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public KeyData.KeyMaterialType keyMaterialType() {
        return KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.KeyTypeManager
    public EciesAeadHkdfPublicKey parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return EciesAeadHkdfPublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeyTypeManager
    public void validateKey(EciesAeadHkdfPublicKey key) throws GeneralSecurityException {
        Validators.validateVersion(key.getVersion(), getVersion());
        HybridUtil.validate(key.getParams());
    }
}

// ===== FILE: com/google/crypto/tink/hybrid/HybridConfig.java =====
package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.proto.RegistryConfig;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class HybridConfig {
    public static final String ECIES_AEAD_HKDF_PUBLIC_KEY_TYPE_URL = new EciesAeadHkdfPublicKeyManager().getKeyType();
    public static final String ECIES_AEAD_HKDF_PRIVATE_KEY_TYPE_URL = new EciesAeadHkdfPrivateKeyManager().getKeyType();

    @Deprecated
    public static final RegistryConfig TINK_1_0_0 = RegistryConfig.getDefaultInstance();

    @Deprecated
    public static final RegistryConfig TINK_1_1_0 = RegistryConfig.getDefaultInstance();

    @Deprecated
    public static final RegistryConfig LATEST = RegistryConfig.getDefaultInstance();

    static {
        try {
            init();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @Deprecated
    public static void init() throws GeneralSecurityException {
        register();
    }

    public static void register() throws GeneralSecurityException {
        AeadConfig.register();
        EciesAeadHkdfPrivateKeyManager.registerPair(true);
        HybridDecryptWrapper.register();
        HybridEncryptWrapper.register();
    }
}

// ===== FILE: com/google/crypto/tink/hybrid/HybridDecryptFactory.java =====
package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.Registry;
import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes.dex */
public final class HybridDecryptFactory {
    @Deprecated
    public static HybridDecrypt getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitive(keysetHandle, null);
    }

    @Deprecated
    public static HybridDecrypt getPrimitive(KeysetHandle keysetHandle, final KeyManager<HybridDecrypt> keyManager) throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new HybridDecryptWrapper());
        return (HybridDecrypt) Registry.wrap(Registry.getPrimitives(keysetHandle, keyManager, HybridDecrypt.class));
    }
}

// ===== FILE: com/google/crypto/tink/hybrid/HybridDecryptWrapper.java =====
package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class HybridDecryptWrapper implements PrimitiveWrapper<HybridDecrypt, HybridDecrypt> {
    private static final Logger logger = Logger.getLogger(HybridDecryptWrapper.class.getName());

    private static class WrappedHybridDecrypt implements HybridDecrypt {
        private final PrimitiveSet<HybridDecrypt> primitives;

        public WrappedHybridDecrypt(final PrimitiveSet<HybridDecrypt> primitives) {
            this.primitives = primitives;
        }

        @Override // com.google.crypto.tink.HybridDecrypt
        public byte[] decrypt(final byte[] ciphertext, final byte[] contextInfo) throws GeneralSecurityException {
            if (ciphertext.length > 5) {
                byte[] copyOfRange = Arrays.copyOfRange(ciphertext, 0, 5);
                byte[] copyOfRange2 = Arrays.copyOfRange(ciphertext, 5, ciphertext.length);
                Iterator<PrimitiveSet.Entry<HybridDecrypt>> it = this.primitives.getPrimitive(copyOfRange).iterator();
                while (it.hasNext()) {
                    try {
                        return it.next().getPrimitive().decrypt(copyOfRange2, contextInfo);
                    } catch (GeneralSecurityException e) {
                        HybridDecryptWrapper.logger.info("ciphertext prefix matches a key, but cannot decrypt: " + e.toString());
                    }
                }
            }
            Iterator<PrimitiveSet.Entry<HybridDecrypt>> it2 = this.primitives.getRawPrimitives().iterator();
            while (it2.hasNext()) {
                try {
                    return it2.next().getPrimitive().decrypt(ciphertext, contextInfo);
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("decryption failed");
        }
    }

    HybridDecryptWrapper() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public HybridDecrypt wrap(final PrimitiveSet<HybridDecrypt> primitives) {
        return new WrappedHybridDecrypt(primitives);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<HybridDecrypt> getPrimitiveClass() {
        return HybridDecrypt.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<HybridDecrypt> getInputPrimitiveClass() {
        return HybridDecrypt.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new HybridDecryptWrapper());
    }
}

// ===== FILE: com/google/crypto/tink/hybrid/HybridEncryptFactory.java =====
package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.Registry;
import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes.dex */
public final class HybridEncryptFactory {
    @Deprecated
    public static HybridEncrypt getPrimitive(KeysetHandle keysetHandle) throws GeneralSecurityException {
        return getPrimitive(keysetHandle, null);
    }

    @Deprecated
    public static HybridEncrypt getPrimitive(KeysetHandle keysetHandle, final KeyManager<HybridEncrypt> keyManager) throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new HybridEncryptWrapper());
        return (HybridEncrypt) Registry.wrap(Registry.getPrimitives(keysetHandle, keyManager, HybridEncrypt.class));
    }
}

// ===== FILE: com/google/crypto/tink/hybrid/HybridEncryptWrapper.java =====
package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
class HybridEncryptWrapper implements PrimitiveWrapper<HybridEncrypt, HybridEncrypt> {
    HybridEncryptWrapper() {
    }

    private static class WrappedHybridEncrypt implements HybridEncrypt {
        final PrimitiveSet<HybridEncrypt> primitives;

        public WrappedHybridEncrypt(final PrimitiveSet<HybridEncrypt> primitives) {
            this.primitives = primitives;
        }

        @Override // com.google.crypto.tink.HybridEncrypt
        public byte[] encrypt(final byte[] plaintext, final byte[] contextInfo) throws GeneralSecurityException {
            return Bytes.concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().encrypt(plaintext, contextInfo));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.crypto.tink.PrimitiveWrapper
    public HybridEncrypt wrap(final PrimitiveSet<HybridEncrypt> primitives) {
        return new WrappedHybridEncrypt(primitives);
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<HybridEncrypt> getPrimitiveClass() {
        return HybridEncrypt.class;
    }

    @Override // com.google.crypto.tink.PrimitiveWrapper
    public Class<HybridEncrypt> getInputPrimitiveClass() {
        return HybridEncrypt.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new HybridEncryptWrapper());
    }
}

// ===== FILE: com/google/crypto/tink/hybrid/HybridKeyTemplates.java =====
package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.proto.EcPointFormat;
import com.google.crypto.tink.proto.EciesAeadDemParams;
import com.google.crypto.tink.proto.EciesAeadHkdfKeyFormat;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;

@Deprecated
/* loaded from: classes.dex */
public final class HybridKeyTemplates {
    public static final KeyTemplate ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256;
    public static final KeyTemplate ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM;
    public static final KeyTemplate ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX;
    private static final byte[] EMPTY_SALT;

    static {
        byte[] bArr = new byte[0];
        EMPTY_SALT = bArr;
        ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM = createEciesAeadHkdfKeyTemplate(EllipticCurveType.NIST_P256, HashType.SHA256, EcPointFormat.UNCOMPRESSED, AeadKeyTemplates.AES128_GCM, OutputPrefixType.TINK, bArr);
        ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX = createEciesAeadHkdfKeyTemplate(EllipticCurveType.NIST_P256, HashType.SHA256, EcPointFormat.COMPRESSED, AeadKeyTemplates.AES128_GCM, OutputPrefixType.RAW, bArr);
        ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256 = createEciesAeadHkdfKeyTemplate(EllipticCurveType.NIST_P256, HashType.SHA256, EcPointFormat.UNCOMPRESSED, AeadKeyTemplates.AES128_CTR_HMAC_SHA256, OutputPrefixType.TINK, bArr);
    }

    public static KeyTemplate createEciesAeadHkdfKeyTemplate(EllipticCurveType curve, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate demKeyTemplate, OutputPrefixType outputPrefixType, byte[] salt) {
        return KeyTemplate.newBuilder().setTypeUrl(new EciesAeadHkdfPrivateKeyManager().getKeyType()).setOutputPrefixType(outputPrefixType).setValue(EciesAeadHkdfKeyFormat.newBuilder().setParams(createEciesAeadHkdfParams(curve, hashType, ecPointFormat, demKeyTemplate, salt)).build().toByteString()).build();
    }

    public static EciesAeadHkdfParams createEciesAeadHkdfParams(EllipticCurveType curve, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate demKeyTemplate, byte[] salt) {
        EciesHkdfKemParams build = EciesHkdfKemParams.newBuilder().setCurveType(curve).setHkdfHashType(hashType).setHkdfSalt(ByteString.copyFrom(salt)).build();
        return EciesAeadHkdfParams.newBuilder().setKemParams(build).setDemParams(EciesAeadDemParams.newBuilder().setAeadDem(demKeyTemplate).build()).setEcPointFormat(ecPointFormat).build();
    }
}

// ===== FILE: com/google/crypto/tink/hybrid/HybridUtil.java =====
package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.EcPointFormat;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
class HybridUtil {
    HybridUtil() {
    }

    public static void validate(EciesAeadHkdfParams params) throws GeneralSecurityException {
        EllipticCurves.getCurveSpec(toCurveType(params.getKemParams().getCurveType()));
        toHmacAlgo(params.getKemParams().getHkdfHashType());
        if (params.getEcPointFormat() == EcPointFormat.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        Registry.newKeyData(params.getDemParams().getAeadDem());
    }

    public static String toHmacAlgo(HashType hash) throws NoSuchAlgorithmException {
        int i = C05601.$SwitchMap$com$google$crypto$tink$proto$HashType[hash.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha512";
        }
        throw new NoSuchAlgorithmException("hash unsupported for HMAC: " + hash);
    }

    public static EllipticCurves.CurveType toCurveType(EllipticCurveType type) throws GeneralSecurityException {
        int i = C05601.$SwitchMap$com$google$crypto$tink$proto$EllipticCurveType[type.ordinal()];
        if (i == 1) {
            return EllipticCurves.CurveType.NIST_P256;
        }
        if (i == 2) {
            return EllipticCurves.CurveType.NIST_P384;
        }
        if (i == 3) {
            return EllipticCurves.CurveType.NIST_P521;
        }
        throw new GeneralSecurityException("unknown curve type: " + type);
    }

    /* renamed from: com.google.crypto.tink.hybrid.HybridUtil$1 */
    static /* synthetic */ class C05601 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$EcPointFormat;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType;

        static {
            int[] iArr = new int[EcPointFormat.values().length];
            $SwitchMap$com$google$crypto$tink$proto$EcPointFormat = iArr;
            try {
                iArr[EcPointFormat.UNCOMPRESSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$EcPointFormat[EcPointFormat.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$EcPointFormat[EcPointFormat.COMPRESSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[EllipticCurveType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType = iArr2;
            try {
                iArr2[EllipticCurveType.NIST_P256.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType[EllipticCurveType.NIST_P384.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType[EllipticCurveType.NIST_P521.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[HashType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = iArr3;
            try {
                iArr3[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static EllipticCurves.PointFormatType toPointFormatType(EcPointFormat format) throws GeneralSecurityException {
        int i = C05601.$SwitchMap$com$google$crypto$tink$proto$EcPointFormat[format.ordinal()];
        if (i == 1) {
            return EllipticCurves.PointFormatType.UNCOMPRESSED;
        }
        if (i == 2) {
            return EllipticCurves.PointFormatType.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (i == 3) {
            return EllipticCurves.PointFormatType.COMPRESSED;
        }
        throw new GeneralSecurityException("unknown point format: " + format);
    }
}

// ===== FILE: com/google/crypto/tink/hybrid/RegistryEciesAeadHkdfDemHelper.java =====
package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.proto.AesCtrHmacAeadKey;
import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.AesGcmKey;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.EciesAeadHkdfDemHelper;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
class RegistryEciesAeadHkdfDemHelper implements EciesAeadHkdfDemHelper {
    private AesCtrHmacAeadKey aesCtrHmacAeadKey;
    private int aesCtrKeySize;
    private AesGcmKey aesGcmKey;
    private final String demKeyTypeUrl;
    private final int symmetricKeySize;

    RegistryEciesAeadHkdfDemHelper(KeyTemplate demTemplate) throws GeneralSecurityException {
        String typeUrl = demTemplate.getTypeUrl();
        this.demKeyTypeUrl = typeUrl;
        if (typeUrl.equals(AeadConfig.AES_GCM_TYPE_URL)) {
            try {
                AesGcmKeyFormat parseFrom = AesGcmKeyFormat.parseFrom(demTemplate.getValue(), ExtensionRegistryLite.getEmptyRegistry());
                this.aesGcmKey = (AesGcmKey) Registry.newKey(demTemplate);
                this.symmetricKeySize = parseFrom.getKeySize();
                return;
            } catch (InvalidProtocolBufferException e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        }
        if (typeUrl.equals(AeadConfig.AES_CTR_HMAC_AEAD_TYPE_URL)) {
            try {
                AesCtrHmacAeadKeyFormat parseFrom2 = AesCtrHmacAeadKeyFormat.parseFrom(demTemplate.getValue(), ExtensionRegistryLite.getEmptyRegistry());
                this.aesCtrHmacAeadKey = (AesCtrHmacAeadKey) Registry.newKey(demTemplate);
                this.aesCtrKeySize = parseFrom2.getAesCtrKeyFormat().getKeySize();
                this.symmetricKeySize = this.aesCtrKeySize + parseFrom2.getHmacKeyFormat().getKeySize();
                return;
            } catch (InvalidProtocolBufferException e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        }
        throw new GeneralSecurityException("unsupported AEAD DEM key type: " + typeUrl);
    }

    @Override // com.google.crypto.tink.subtle.EciesAeadHkdfDemHelper
    public int getSymmetricKeySizeInBytes() {
        return this.symmetricKeySize;
    }

    @Override // com.google.crypto.tink.subtle.EciesAeadHkdfDemHelper
    public Aead getAead(final byte[] symmetricKeyValue) throws GeneralSecurityException {
        if (symmetricKeyValue.length != getSymmetricKeySizeInBytes()) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.demKeyTypeUrl.equals(AeadConfig.AES_GCM_TYPE_URL)) {
            return (Aead) Registry.getPrimitive(this.demKeyTypeUrl, AesGcmKey.newBuilder().mergeFrom((AesGcmKey.Builder) this.aesGcmKey).setKeyValue(ByteString.copyFrom(symmetricKeyValue, 0, this.symmetricKeySize)).build(), Aead.class);
        }
        if (this.demKeyTypeUrl.equals(AeadConfig.AES_CTR_HMAC_AEAD_TYPE_URL)) {
            byte[] copyOfRange = Arrays.copyOfRange(symmetricKeyValue, 0, this.aesCtrKeySize);
            byte[] copyOfRange2 = Arrays.copyOfRange(symmetricKeyValue, this.aesCtrKeySize, this.symmetricKeySize);
            AesCtrKey build = AesCtrKey.newBuilder().mergeFrom((AesCtrKey.Builder) this.aesCtrHmacAeadKey.getAesCtrKey()).setKeyValue(ByteString.copyFrom(copyOfRange)).build();
            return (Aead) Registry.getPrimitive(this.demKeyTypeUrl, AesCtrHmacAeadKey.newBuilder().setVersion(this.aesCtrHmacAeadKey.getVersion()).setAesCtrKey(build).setHmacKey(HmacKey.newBuilder().mergeFrom((HmacKey.Builder) this.aesCtrHmacAeadKey.getHmacKey()).setKeyValue(ByteString.copyFrom(copyOfRange2)).build()).build(), Aead.class);
        }
        throw new GeneralSecurityException("unknown DEM key type");
    }
}
