
// ===== FILE: com/google/crypto/tink/hybrid/subtle/RsaKem.java =====
package com.google.crypto.tink.hybrid.subtle;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* loaded from: classes.dex */
class RsaKem {
    static final byte[] EMPTY_AAD = new byte[0];
    static final int MIN_RSA_KEY_LENGTH_BITS = 2048;

    private RsaKem() {
    }

    static void validateRsaModulus(BigInteger mod) throws GeneralSecurityException {
        if (mod.bitLength() < 2048) {
            throw new GeneralSecurityException(String.format("RSA key must be of at least size %d bits, but got %d", 2048, Integer.valueOf(mod.bitLength())));
        }
    }

    static int bigIntSizeInBytes(BigInteger mod) {
        return (mod.bitLength() + 7) / 8;
    }

    static byte[] bigIntToByteArray(BigInteger bigInt, int size) {
        byte[] byteArray = bigInt.toByteArray();
        if (byteArray.length == size) {
            return byteArray;
        }
        byte[] bArr = new byte[size];
        if (byteArray.length == size + 1) {
            if (byteArray[0] != 0) {
                throw new IllegalArgumentException("Value is one-byte longer than the expected size, but its first byte is not 0");
            }
            System.arraycopy(byteArray, 1, bArr, 0, size);
        } else if (byteArray.length < size) {
            System.arraycopy(byteArray, 0, bArr, size - byteArray.length, byteArray.length);
        } else {
            throw new IllegalArgumentException(String.format("Value has invalid length, must be of length at most (%d + 1), but got %d", Integer.valueOf(size), Integer.valueOf(byteArray.length)));
        }
        return bArr;
    }

    static byte[] generateSecret(BigInteger max) {
        int bigIntSizeInBytes = bigIntSizeInBytes(max);
        SecureRandom secureRandom = new SecureRandom();
        while (true) {
            BigInteger bigInteger = new BigInteger(max.bitLength(), secureRandom);
            if (bigInteger.signum() > 0 && bigInteger.compareTo(max) < 0) {
                return bigIntToByteArray(bigInteger, bigIntSizeInBytes);
            }
        }
    }

    static KeyPair generateRsaKeyPair(int keySize) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(keySize);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No support for RSA algorithm.", e);
        }
    }
}

// ===== FILE: com/google/crypto/tink/hybrid/subtle/RsaKemHybridDecrypt.java =====
package com.google.crypto.tink.hybrid.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.aead.subtle.AeadFactory;
import com.google.crypto.tink.subtle.Hkdf;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPrivateKey;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public final class RsaKemHybridDecrypt implements HybridDecrypt {
    private final AeadFactory aeadFactory;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final RSAPrivateKey recipientPrivateKey;

    public RsaKemHybridDecrypt(final RSAPrivateKey recipientPrivateKey, String hkdfHmacAlgo, final byte[] hkdfSalt, AeadFactory aeadFactory) throws GeneralSecurityException {
        RsaKem.validateRsaModulus(recipientPrivateKey.getModulus());
        this.recipientPrivateKey = recipientPrivateKey;
        this.hkdfSalt = hkdfSalt;
        this.hkdfHmacAlgo = hkdfHmacAlgo;
        this.aeadFactory = aeadFactory;
    }

    @Override // com.google.crypto.tink.HybridDecrypt
    public byte[] decrypt(final byte[] ciphertext, final byte[] contextInfo) throws GeneralSecurityException {
        int bigIntSizeInBytes = RsaKem.bigIntSizeInBytes(this.recipientPrivateKey.getModulus());
        if (ciphertext.length < bigIntSizeInBytes) {
            throw new GeneralSecurityException(String.format("Ciphertext must be of at least size %d bytes, but got %d", Integer.valueOf(bigIntSizeInBytes), Integer.valueOf(ciphertext.length)));
        }
        ByteBuffer wrap = ByteBuffer.wrap(ciphertext);
        byte[] bArr = new byte[bigIntSizeInBytes];
        wrap.get(bArr);
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        cipher.init(2, this.recipientPrivateKey);
        Aead createAead = this.aeadFactory.createAead(Hkdf.computeHkdf(this.hkdfHmacAlgo, cipher.doFinal(bArr), this.hkdfSalt, contextInfo, this.aeadFactory.getKeySizeInBytes()));
        byte[] bArr2 = new byte[wrap.remaining()];
        wrap.get(bArr2);
        return createAead.decrypt(bArr2, RsaKem.EMPTY_AAD);
    }
}

// ===== FILE: com/google/crypto/tink/hybrid/subtle/RsaKemHybridEncrypt.java =====
package com.google.crypto.tink.hybrid.subtle;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.aead.subtle.AeadFactory;
import com.google.crypto.tink.subtle.Hkdf;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public final class RsaKemHybridEncrypt implements HybridEncrypt {
    private final AeadFactory aeadFactory;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final RSAPublicKey recipientPublicKey;

    public RsaKemHybridEncrypt(final RSAPublicKey recipientPublicKey, String hkdfHmacAlgo, final byte[] hkdfSalt, AeadFactory aeadFactory) throws GeneralSecurityException {
        RsaKem.validateRsaModulus(recipientPublicKey.getModulus());
        this.recipientPublicKey = recipientPublicKey;
        this.hkdfHmacAlgo = hkdfHmacAlgo;
        this.hkdfSalt = hkdfSalt;
        this.aeadFactory = aeadFactory;
    }

    @Override // com.google.crypto.tink.HybridEncrypt
    public byte[] encrypt(final byte[] plaintext, final byte[] contextInfo) throws GeneralSecurityException {
        byte[] generateSecret = RsaKem.generateSecret(this.recipientPublicKey.getModulus());
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        cipher.init(1, this.recipientPublicKey);
        byte[] doFinal = cipher.doFinal(generateSecret);
        byte[] encrypt = this.aeadFactory.createAead(Hkdf.computeHkdf(this.hkdfHmacAlgo, generateSecret, this.hkdfSalt, contextInfo, this.aeadFactory.getKeySizeInBytes())).encrypt(plaintext, RsaKem.EMPTY_AAD);
        return ByteBuffer.allocate(doFinal.length + encrypt.length).put(doFinal).put(encrypt).array();
    }
}
